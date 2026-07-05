package jerios.morecreeps.entity.agressive;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import jerios.morecreeps.entity.base.BaseAgressiveCreep;
import jerios.morecreeps.entity.nonLiving.EntityTrophy;
import jerios.morecreeps.registry.AchievmentRegistry;
import jerios.morecreeps.utils.AchievementUtil;

public class EvilSnowmanEntity extends BaseAgressiveCreep {

    public EvilSnowmanEntity(World world) {
        super(world);
        this.isImmuneToFire = true;
        this.experienceValue = 10;
    }

    @Override
    public void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
            .setBaseValue(25D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue(0.3D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
            .setBaseValue(1D);
    }

    @Override
    public void onDeath(DamageSource damageSource) {

        if (this.entityToAttack instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) entityToAttack;

            if (this.getModelSize() < 0.1f) {
                AchievementUtil.givePlayerAchievement(player, AchievmentRegistry.achievesnowtiny);
            } else if (this.getModelSize() > 5.0F) {
                AchievementUtil.givePlayerAchievement(player, AchievmentRegistry.achievesnowtall);
            } else {
                AchievementUtil.givePlayerAchievement(player, AchievmentRegistry.achievesnow);
            }
        }

        super.onDeath(damageSource);

    }

    @Override
    protected void attackEntity(Entity entity, float f) {
        Entity attackerEntity = entity;

        if (super.onGround) {
            for (int j = 0; j < 8; j++) {
                super.worldObj.playSoundAtEntity(this, "morecreeps:SnowmanBounce", 1.0F, 2.0F - this.getModelSize());
                super.worldObj.spawnParticle("snowballpoof", super.posX, super.posY, super.posZ, 0.0, 0.0, 0.0);
            }

            double d = entity.posX - this.posX;
            double d1 = entity.posZ - this.posZ;
            float f2 = MathHelper.sqrt_double(d * d + d1 * d1);
            this.motionX = d / f2 * 0.5 * 0.30000000192092896 + this.motionX * 0.20000000098023224;
            this.motionZ = d1 / f2 * 0.5 * 0.25000000192092897 + this.motionZ * 0.20000000098023224;
            this.motionY = 0.3500000019604645;

            if (attackerEntity instanceof EntityPlayer) {
                EntityPlayer entityplayer = (EntityPlayer) attackerEntity;
                if (this.rand.nextInt(20) == 0) {
                    double xHeading = -MathHelper.sin(entityplayer.rotationYaw * 3.141593F / 180.0F);
                    double zHeading = MathHelper.cos(entityplayer.rotationYaw * 3.141593F / 180.0F);
                    this.motionX -= xHeading * 0.4F;
                    this.motionZ -= zHeading * 0.4F;

                }

                if (this.rand.nextInt(20) == 0) {
                    double xHeading = -MathHelper.sin(entityplayer.rotationYaw * 3.141593F / 180.0F);
                    double zHeading = MathHelper.cos(entityplayer.rotationYaw * 3.141593F / 180.0F);
                    this.motionX -= xHeading * 1.0;
                    this.motionY += 0.166F;

                }

                if (super.rand.nextInt(40) == 0) {
                    double xHeading = -MathHelper.sin(entityplayer.rotationYaw * 3.141593F / 180.0F);
                    double zHeading = MathHelper.cos(entityplayer.rotationYaw * 3.141593F / 180.0F);
                    this.motionX -= xHeading * 0.3F;
                    this.motionZ -= zHeading * 0.3F;
                    this.motionY += 0.766F;

                }
            }
        }

        if (f < this.getModelSize() && entity.boundingBox.maxY > super.boundingBox.minY
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
            EntityPlayer entityplayer = (EntityPlayer) entity;
            double xHeading = -MathHelper.sin(entityplayer.rotationYaw * 3.141593F / 180.0F);
            double zHeading = MathHelper.cos(entityplayer.rotationYaw * 3.141593F / 180.0F);
            this.motionX += xHeading * 2.0;
            this.motionZ += zHeading * 2.0;
        }
        this.setModelSize(this.getModelSize() - 0.02F);
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
    protected void dropFewItems(boolean recentHit, int lootLevel) {
        super.dropFewItems(recentHit, lootLevel);
        if (this.rand.nextInt(10) == 0) {
            this.dropItem(Item.getItemFromBlock(Blocks.ice), this.rand.nextInt(3) + 1);
            this.dropItem(Item.getItemFromBlock(Blocks.snow), this.rand.nextInt(10) + 1);
        } else {
            this.dropItem(Item.getItemFromBlock(Blocks.snow), this.rand.nextInt(5) + 2);
        }
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();

        if (!this.onGround && !this.isJumping) {
            this.motionY -= 0.002F;
        }

        int x = MathHelper.floor_double(this.posX);
        int y = MathHelper.floor_double(this.boundingBox.minY);
        int z = MathHelper.floor_double(this.posZ);

        Block blockBelow = this.worldObj.getBlock(x, y - 1, z);
        Block blockOn = this.worldObj.getBlock(x, y, z);

        this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
            .setBaseValue((double) this.getModelSize() + 1);

        boolean badBlocks = blockBelow == Blocks.snow || blockBelow == Blocks.stone_button
            || blockBelow == Blocks.ice
            || blockBelow == Blocks.packed_ice // packed_ice I don't think existed in 1.2.5, added it
            || blockBelow == Blocks.cactus;

        if (badBlocks && blockOn != Blocks.snow_layer) {
            this.setModelSize(this.getModelSize() - 0.002F);
        } else {
            this.setModelSize(this.getModelSize() + 0.001F);
        }

        if (this.inWater) {
            this.setModelSize(this.getModelSize() - 0.002F);
        }

        if (this.getModelSize() > 6.0F) {
            this.setModelSize(6.0F);
        }

        this.setSize(this.getModelSize() * 0.45F, this.getModelSize() * 2.0F);

        if (this.getModelSize() < 0.05D) {
            this.setDead();
        }

    }

    @Override
    public void knockBack(Entity entity, float i, double motionX, double motionZ) {

        for (int j = 0; j < 8 + (int) (this.getModelSize() * 20.0F); j++) {
            this.worldObj
                .spawnParticle("snowballpoof", this.posX, this.posY + this.getModelSize(), this.posZ, 0.0, 0.0, 0.0);
        }

        i *= i;
        super.motionY += 0.3330000042915344D;
        motionX *= 8.199999809265137D;
        motionZ *= 8.300000190734863D;

        super.knockBack(entity, i, motionX, motionZ);
    }

    @Override
    protected void fall(float distance) {

    }

    public void spawnConfetti(EntityPlayer entityplayer) {
        double xHeading = -MathHelper.sin(entityplayer.rotationYaw * 3.141593F / 180.0F);
        double zHeading = MathHelper.cos(entityplayer.rotationYaw * 3.141593F / 180.0F);
        EntityTrophy entityTrophy = new EntityTrophy(worldObj);
        entityTrophy.setLocationAndAngles(
            entityplayer.posX + xHeading * 3.0,
            entityplayer.posY - 2.0,
            entityplayer.posZ + zHeading * 3.0,
            entityplayer.rotationYaw,
            0.0F);

        entityplayer.worldObj.spawnEntityInWorld(entityTrophy);

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
        return "morecreeps:Snowman";
    }

    @Override
    protected String getHurtSound() {
        return "morecreeps:SnowmanHurt";
    }

    @Override
    protected String getDeathSound() {
        return "morecreeps:SnowmanDeath";
    }

    @Override
    public float getShadowSize() {
        return this.getModelSize() * 0.4F;
    }

}
