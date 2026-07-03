package jerios.morecreeps.entity.agressive;

import jerios.morecreeps.entity.base.BaseAgressiveCreep;
import jerios.morecreeps.entity.interfaces.IEvilMobs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

import java.util.List;


public class EvilLight extends BaseAgressiveCreep implements IEvilMobs{
    public int lifespan;

    public EvilLight(World world) {
        super(world);
        this.lifespan = 200;
        this.motionZ = this.rand.nextFloat() * 2.0F - 1.0F;
        this.motionX = this.rand.nextFloat() * 2.0F - 1.0F;
    }

    @Override
    public void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
            .setBaseValue(1D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue(0.4D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
            .setBaseValue(3D);
    }

    @Override
    public void onLivingUpdate() {

        if (this.lifespan-- < 1 || this.handleWaterMovement()) {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
                .setBaseValue(0D);
            this.setDead();
        }

        List<Entity> list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(this.motionX, this.motionY, this.motionZ).expand(1.0, 1.0,1.0));

        for (int i = 0; i < list.size(); i++) {
            Entity entity = list.get(i);
            if (entity.canBeCollidedWith() && !(entity instanceof IEvilMobs)) {
                dealFireDamageToMob(entity,3);
                entity.motionX = this.rand.nextFloat() * 0.7F;
                entity.motionY = this.rand.nextFloat() * 0.4F;
                entity.motionZ = this.rand.nextFloat() * 0.7F;
                this.worldObj.playSoundAtEntity(this, "morecreeps:EvilLight", 0.2F, 1.0F / (super.rand.nextFloat() * 0.1F + 0.95F));

            }

        }
        super.onLivingUpdate();
    }

    // Method was protected for some reason, copypasta!
    public void dealFireDamageToMob(Entity entity, float amount)
    {
        if (!entity.isImmuneToFire())
        {
            entity.attackEntityFrom(DamageSource.inFire, amount);
        }
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nbttagcompound) {
        super.writeEntityToNBT(nbttagcompound);
        nbttagcompound.setInteger("Lifespan", this.lifespan);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nbttagcompound) {
        super.readEntityFromNBT(nbttagcompound);
        this.lifespan = nbttagcompound.getInteger("Lifespan");
    }

    @Override
    protected String getLivingSound() {
        return "morecreeps:EvilLight";
    }

    @Override
    protected String getHurtSound() {
        return "morecreeps:EvilLight";
    }

    @Override
    protected String getDeathSound() {
        return "morecreeps:EvilLight";
    }


    @Override
    protected void attackEntity(Entity entity, float f) {
        if (!(entity instanceof IEvilMobs)) {
            if (f < 3.0 && entity.boundingBox.maxY > this.boundingBox.minY && entity.boundingBox.minY < this.boundingBox.maxY) {
                super.attackTime = 10;
                attackEntityAsMob(entity);
            }
        }

    }

    @Override
    protected void fall(float par1) {
        int var2 = (int)Math.ceil(par1 - 3.0F);
        super.fall(var2);
    }

    @Override
    public float getShadowSize() {
        return 0;
    }

    @Override
    public boolean getCanSpawnHere() {
        return true;
    }
}
