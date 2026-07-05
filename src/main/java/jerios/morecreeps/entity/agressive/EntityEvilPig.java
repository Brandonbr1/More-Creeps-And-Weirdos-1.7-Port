package jerios.morecreeps.entity.agressive;

import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import jerios.morecreeps.entity.base.BaseAgressiveCreep;
import jerios.morecreeps.entity.interfaces.IEvilMobs;

public class EntityEvilPig extends BaseAgressiveCreep implements IEvilMobs {

    public EntityEvilPig(World world) {
        super(world);
        this.fallDistance = -25.0F;
        this.experienceValue = 8;
        this.yOffset *= 3.0F;
        this.setSize(this.width * 2.2F, this.height * 1.6F);
        this.isImmuneToFire = true;
    }

    @Override
    public void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
            .setBaseValue(15D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue(0.45D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
            .setBaseValue(1D);
    }

    @Override
    protected void attackEntity(Entity entity, float f) {
        double d = entity.posX - super.posX;
        double d1 = entity.posZ - super.posZ;
        float f2 = MathHelper.sqrt_double(d * d + d1 * d1);
        super.motionX = d / f2 * 0.4 * 0.500000001920929 + super.motionX * 0.18000000098023225;
        super.motionZ = d1 / f2 * 0.4 * 0.34000000192092894 + super.motionZ * 0.18000000098023225;
        if (f < 2.5 - (2.0 - this.getModelSize()) && entity.boundingBox.maxY > super.boundingBox.minY
            && entity.boundingBox.minY < super.boundingBox.maxY) {
            super.attackTime = 20;
            attackEntityAsMob(entity);
        }

        super.attackEntity(entity, f);
    }

    @Override
    public boolean attackEntityFrom(DamageSource damagesource, float i) {
        Entity entity = damagesource.getEntity();
        if (entity instanceof EntityPlayer) {
            EntityPlayer entityPlayer = (EntityPlayer) entity;
            double xHeading = -MathHelper.sin(entityPlayer.rotationYaw * 3.141593F / 180.0F);
            double zHeading = MathHelper.cos(entityPlayer.rotationYaw * 3.141593F / 180.0F);
            this.motionX += xHeading * 2.0;
            this.motionZ += zHeading * 2.0;
        }

        if (super.attackEntityFrom(DamageSource.causeMobDamage(this), i)) {
            if (this.riddenByEntity != entity && this.ridingEntity != entity) {
                if (entity != this && this.worldObj.difficultySetting.getDifficultyId() > 0) {
                    this.entityToAttack = entity;
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
    public boolean getCanSpawnHere() {
        return true;
    }

    @Override
    public void playLivingSound() {
        String s = this.getLivingSound();
        if (s != null) {
            this.worldObj.playSoundAtEntity(
                this,
                s,
                this.getSoundVolume(),
                (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F + (1.0F - this.getModelSize()) * 2.0F);
        }
    }

    @Override
    protected String getLivingSound() {
        return "mob.pig.say";
    }

    @Override
    protected String getHurtSound() {
        return "mob.pig.say";
    }

    @Override
    protected String getDeathSound() {
        return "mob.pig.death";
    }
}
