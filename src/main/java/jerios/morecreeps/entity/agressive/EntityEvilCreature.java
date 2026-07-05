package jerios.morecreeps.entity.agressive;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Items;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import jerios.morecreeps.entity.base.BaseAgressiveCreep;
import jerios.morecreeps.entity.interfaces.ICreepGrowable;

public class EntityEvilCreature extends BaseAgressiveCreep implements ICreepGrowable {

    public boolean jumping;

    public EntityEvilCreature(World world) {
        super(world);
        this.isImmuneToFire = true;
        this.experienceValue = 15;
        this.yOffset *= 3.0F;
        setModelSize(3.0F);
        this.setSize(this.width * 3.0F, this.height * 3.0F);
        this.jumping = false;
    }

    @Override
    public void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
            .setBaseValue(45D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue(0.4D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
            .setBaseValue(3D);
    }

    @Override
    public float getShadowSize() {
        return 2.9F;
    }

    @Override
    public void spawnHook() {
        setIncreasedHP(75);
    }

    @Override
    public boolean getCanSpawnHere() {
        return true;
    }

    @Override
    protected void attackEntity(Entity entity, float f) {
        if (super.onGround && this.jumping) {
            this.jumping = false;
            super.worldObj.playSoundAtEntity(
                this,
                "morecreeps:EvilCreatureJump",
                1.0F * (this.getModelSize() / 3.0F),
                (super.rand.nextFloat() - super.rand.nextFloat()) * 0.2F + 1.0F + (3.0F - this.getModelSize()) * 2.0F);
            List<Entity> list = this.worldObj
                .getEntitiesWithinAABBExcludingEntity(this, super.boundingBox.expand(18.0, 18.0, 18.0));

            for (int i = 0; i < list.size(); i++) {
                Entity entity1 = list.get(i);
                if (entity1 instanceof EntityLiving && !entity1.handleWaterMovement() && entity1.onGround) {
                    double h = this.getDistanceToEntity(entity1);
                    entity1.motionY = entity1.motionY + (17.0 - h) * 0.067058F * (this.getModelSize() / 3.0F);
                }
            }
        }

        if (super.onGround) {
            double d = entity.posX - super.posX;
            double d1 = entity.posZ - super.posZ;
            float f2 = MathHelper.sqrt_double(d * d + d1 * d1);
            super.motionX = d / f2 * 0.5 * 0.40000000192092894 + super.motionX * 0.20000000098023224;
            super.motionZ = d1 / f2 * 0.5 * 0.30000000192092896 + super.motionZ * 0.20000000098023224;
            super.motionY = 0.3500000019604645;
            this.jumping = true;
        }

        if (f < 3.0 - (2.0 - this.getModelSize()) && entity.boundingBox.maxY > super.boundingBox.minY
            && entity.boundingBox.minY < super.boundingBox.maxY) {
            super.attackTime = 20;
            entity.motionY += 0.77F;
            attackEntityAsMob(entity);
            // entity.attackEntityFrom(DamageSource.causeMobDamage(this), 3);
        }

        super.attackEntity(entity, f);
    }

    public void playLivingSound() {
        String s = this.getLivingSound();
        if (s != null) {
            super.worldObj.playSoundAtEntity(
                this,
                s,
                this.getSoundVolume(),
                (super.rand.nextFloat() - super.rand.nextFloat()) * 0.2F + 1.0F + (3.0F - this.getModelSize()) * 2.0F);
        }
    }

    @Override
    protected void dropFewItems(boolean recentHit, int lootLevel) {
        super.dropFewItems(recentHit, lootLevel);
        if (rand.nextInt(5) == 0) {
            this.dropItem(Items.bread, this.rand.nextInt(3) + 1);
        } else {
            this.dropItem(Items.fish, this.rand.nextInt(3) + 1);
        }

    }

    @Override
    protected String getLivingSound() {
        return "morecreeps:EvilCreatureLiving";
    }

    @Override
    protected String getHurtSound() {
        return "morecreeps:EvilCreatureHurt";
    }

    @Override
    protected String getDeathSound() {
        return "morecreeps:EvilCreatureDeath";
    }

    @Override
    protected void fall(float distance) {

    }

    @Override
    public void onSizeChange() {}
}
