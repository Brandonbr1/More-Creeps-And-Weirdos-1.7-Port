package jerios.morecreeps.entity.nonLiving;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import jerios.morecreeps.registry.CREEPSItemBlocks;

public class EntityGooDonut extends EntityItem {

    protected double initialVelocity;
    double bounceFactor;
    boolean exploded;
    int fuse;

    public EntityGooDonut(World world) {
        super(world);;
        this.setSize(0.25F, 0.25F);
        this.initialVelocity = 1.0;
        this.yOffset = 0.0F;
        this.bounceFactor = 0.85;
        this.exploded = false;
        this.fuse = 0;;
        this.setEntityItemStack(new ItemStack(CREEPSItemBlocks.gooDonut));
    }

    @Override
    public boolean isInRangeToRenderDist(double d) {
        double d1 = this.boundingBox.getAverageEdgeLength() * 4.0;
        d1 *= 64.0;
        return d < d1 * d1;
    }

    public EntityGooDonut(World world, EntityLivingBase entity) {
        super(world /** , entity **/
        );
        this.setRotation(entity.rotationYaw, 0.0F);
        double xHeading = -MathHelper.sin(entity.rotationYaw * 3.141593F / 180.0F);
        double zHeading = MathHelper.cos(entity.rotationYaw * 3.141593F / 180.0F);
        this.motionX = 0.7 * xHeading * MathHelper.cos(entity.rotationPitch / 180.0F * 3.141593F);
        this.motionY = -0.8 * MathHelper.sin(entity.rotationPitch / 180.0F * 3.141593F);
        this.motionZ = 0.7 * zHeading * MathHelper.cos(entity.rotationPitch / 180.0F * 3.141593F);
        this.setPosition(entity.posX + xHeading * 0.8, entity.posY, entity.posZ + zHeading * 0.8);
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        this.fuse = 30;
        this.setEntityItemStack(new ItemStack(CREEPSItemBlocks.gooDonut));
    }

    public EntityGooDonut(World world, double x, double y, double z) {
        super(world, x, y, z);
        this.setPosition(x, y, z);
        this.setEntityItemStack(new ItemStack(CREEPSItemBlocks.gooDonut));
    }

    @Override
    public void setVelocity(double d, double d1, double d2) {
        this.motionX = d;
        this.motionY = d1;
        this.motionZ = d2;
        if (this.prevRotationPitch == 0.0F && this.prevRotationYaw == 0.0F) {
            float f = MathHelper.sqrt_double(d * d + d2 * d2);
            this.prevRotationYaw = this.rotationYaw = (float) (Math.atan2(d, d2) * 180.0 / (float) Math.PI);
            this.prevRotationPitch = this.rotationPitch = (float) (Math.atan2(d1, f) * 180.0 / (float) Math.PI);
        }
    }

    @Override
    public void onUpdate() {
        double prevVelX = this.motionX;
        double prevVelY = this.motionY;
        double prevVelZ = this.motionZ;
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        if (this.motionX != prevVelX) {
            this.motionX = -this.bounceFactor * prevVelX;
        }

        if (this.motionY != prevVelY) {
            this.motionY = -this.bounceFactor * prevVelY;
        }

        if (this.motionY != prevVelY) {
            this.motionY = -this.bounceFactor * prevVelY;
        } else {
            this.motionY -= 0.04;
        }

        this.motionX *= 0.98;
        this.motionY *= 0.995;
        this.motionZ *= 0.98;
        if (this.fuse-- <= 0) {
            this.explode();
            this.setDead();
        }

        if (this.handleWaterMovement()) {
            for (int J = 0; J < 8; J++) {
                for (int k = 0; k < 10; k++) {
                    float f3 = 0.85F;
                    this.worldObj.spawnParticle(
                        "bubble",
                        this.posX - this.motionX - 0.25 * f3,
                        this.posY - this.motionY - 0.25 * f3,
                        this.posZ - this.motionZ - 0.25 * f3,
                        this.motionX,
                        this.motionY,
                        this.motionZ);
                }
            }

            this.setDead();
            if (!worldObj.isRemote) {
                this.dropItem(CREEPSItemBlocks.gooDonut, 1);
            }
        }

        double expand = 1.0D;

        List<Entity> entityList = this.worldObj.getEntitiesWithinAABBExcludingEntity(
            this,
            this.boundingBox.addCoord(this.posX, this.posY, this.posZ)
                .expand(expand, expand, expand));

        for (int i = 0; i < entityList.size(); i++) {
            Entity entity = entityList.get(i);
            if (entity != null && entity.canBeCollidedWith() && !(entity instanceof EntityPlayer)) {
                this.explode();
            }

        }

        if (this.delayBeforeCanPickup > 0) {
            this.delayBeforeCanPickup--;
        }
    }

    private void explode() {
        if (!this.worldObj.isRemote) {
            if (!this.exploded) {
                this.exploded = true;
                this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, 3.85F, true);
            }
        }

    }

    @Override
    public void readEntityFromNBT(NBTTagCompound tagCompund) {
        super.readEntityFromNBT(tagCompund);
        this.fuse = tagCompund.getInteger("Timer");
        this.exploded = tagCompund.getBoolean("Exploded");
        this.setEntityItemStack(new ItemStack(CREEPSItemBlocks.gooDonut));
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound tagCompound) {
        super.writeEntityToNBT(tagCompound);
        tagCompound.setInteger("Timer", this.fuse);
        tagCompound.setBoolean("Exploded", this.exploded);
    }

    @Override
    public void onCollideWithPlayer(EntityPlayer entityIn) {}

    public float getShadowSize() {
        return 0.0F;
    }
}
