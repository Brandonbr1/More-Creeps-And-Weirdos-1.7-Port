package jerios.morecreeps.entity.agressive;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStoneSlab;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import jerios.morecreeps.entity.base.BaseAgressiveCreep;

public class EntityCastleCritter extends BaseAgressiveCreep {

    public EntityCastleCritter(World world) {
        super(world);
        this.setSize(0.6F, 0.6F);
        this.setModelSize(1.6f);
        this.experienceValue = 5;
    }

    @Override
    public void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
            .setBaseValue(6D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue(0.4D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
            .setBaseValue(1D);
    }

    @Override
    public boolean attackEntityFrom(DamageSource damagesource, float i) {
        Entity entity = damagesource.getEntity();
        if (super.attackEntityFrom(DamageSource.causeMobDamage(this), i)) {
            if (super.riddenByEntity != entity && super.ridingEntity != entity) {
                if (entity != this && super.worldObj.difficultySetting.getDifficultyId() > 0) {
                    super.entityToAttack = entity;
                }

                return true;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    @Override
    protected void attackEntity(Entity entity, float f) {
        if (super.onGround) {
            double d = entity.posX - super.posX;
            double d1 = entity.posZ - super.posZ;
            float f2 = MathHelper.sqrt_double(d * d + d1 * d1);
            super.motionX = d / f2 * 0.2 * (0.8F + super.motionX * 0.2F);
            super.motionZ = d1 / f2 * 0.2 * (0.7500000119209289 + super.motionZ * 0.2F);
            super.motionY = 0.10000000596246449;
            super.fallDistance = -25.0F;
            if (super.rand.nextInt(5) == 0) {
                double xHeading = -MathHelper.sin(super.rotationYaw * 3.141593F / 180.0F);
                double zHeading = MathHelper.cos(super.rotationYaw * 3.141593F / 180.0F);
                super.motionX += xHeading * 0.65F;
                super.motionZ += zHeading * 0.65F;
            }
        }

        if (f < 2.0 && entity.boundingBox.maxY > super.boundingBox.minY
            && entity.boundingBox.minY < super.boundingBox.maxY
            && super.rand.nextInt(10) == 0) {
            super.attackTime = 20;
            attackEntityAsMob(entity);
        }
    }

    @Override
    public int getMaxSpawnedInChunk() {
        return 2;
    }

    @Override
    public boolean getCanSpawnHere() {
        int i = MathHelper.floor_double(super.posX);
        int j = MathHelper.floor_double(super.boundingBox.minY);
        int k = MathHelper.floor_double(super.posZ);
        int l = super.worldObj.getFullBlockLightValue(i, j, k);
        Block m = super.worldObj.getBlock(i, j - 1, k);
        return m != Blocks.cobblestone && m != Blocks.log
            && m != Blocks.log2
            && m != Blocks.wool
            && super.worldObj.getCollidingBoundingBoxes(this, super.boundingBox)
                .isEmpty()
            && super.worldObj.checkNoEntityCollision(super.boundingBox);
    }

    @Override
    public void playLivingSound() {
        String s = this.getLivingSound();
        if (s != null) {
            this.worldObj.playSoundAtEntity(
                this,
                s,
                this.getSoundVolume(),
                (super.rand.nextFloat() - super.rand.nextFloat()) * 0.2F + 1.0F + (1.6F - this.getModelSize()) * 2.0F);
        }
    }

    @Override
    protected String getLivingSound() {
        return super.rand.nextInt(5) == 0 ? "morecreeps:CastleCritter" : null;
    }

    @Override
    protected String getHurtSound() {
        return "morecreeps:CastleCritterHurt";
    }

    @Override
    protected String getDeathSound() {
        return "morecreeps:CastleCritterDeath";
    }

    @Override
    protected void dropFewItems(boolean recentHit, int lootLevel) {
        super.dropFewItems(recentHit, lootLevel);
        if (this.rand.nextInt(10) == 0) {
            this.dropItem(Items.porkchop, this.rand.nextInt(3) + 1);
        }
        if (super.rand.nextInt(10) == 0) {
            this.dropItem(Items.bone, super.rand.nextInt(3) + 1);
        }

    }

    @Override
    public float getBlockPathWeight(int i, int j, int k) {
        return !(this.worldObj.getBlock(i, j - 1, k) instanceof BlockStoneSlab) ? -j : 10.0F;
    }
}
