package jerios.morecreeps.entity.agressive;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import jerios.morecreeps.CREEPSConstants;
import jerios.morecreeps.entity.base.BaseAgressiveCreep;
import jerios.morecreeps.registry.AchievmentRegistry;
import jerios.morecreeps.utils.AchievementUtil;

public class EntityRockMonster extends BaseAgressiveCreep {

    private int angerLevel;

    private static final Block[] dropItems = new Block[] { Blocks.cobblestone, Blocks.gravel, Blocks.cobblestone,
        Blocks.gravel, Blocks.iron_ore, Blocks.mossy_cobblestone };

    public EntityRockMonster(World world) {
        super(world);
        this.angerLevel = 0;
        this.experienceValue = 10;
        this.setModelSize(3.0F);
        this.setSize(this.width * 3.25F, this.height * 3.25F);
        // this.height = 4.0F;
        // this.width = 3.0F;
        // MORE CREEPS Has these conflict so which one is correct???
    }

    @Override
    public void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
            .setBaseValue(60D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue(0.35D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
            .setBaseValue(5D);
    }

    @Override
    public void onUpdate() {
        if (this.entityToAttack == null) {
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
                .setBaseValue(0.35D);
        } else {
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
                .setBaseValue(0.6D);
        }
        super.onUpdate();
        if (super.motionY > 0.0) {
            super.motionY -= 3.3E-4F;
        }
    }

    @Override
    public int getMaxSpawnedInChunk() {
        return 1;
    }

    private void becomeAngryAt(Entity entity) {
        this.entityToAttack = entity;
        this.angerLevel = 400 + super.rand.nextInt(400);
    }

    @Override
    protected void attackEntity(Entity entity, float f) {
        double d = entity.posX - super.posX;
        double d1 = entity.posZ - super.posZ;
        float f2 = MathHelper.sqrt_double(d * d + d1 * d1);
        super.motionX = d / f2 * 0.5 * 0.30000000192092896 + super.motionX * 0.38000000098023223;
        super.motionZ = d1 / f2 * 0.5 * 0.17000000192092896 + super.motionZ * 0.38000000098023223;
        if (f < this.getModelSize() * 0.7 + 1.1 && entity.boundingBox.maxY > super.boundingBox.minY
            && entity.boundingBox.minY < super.boundingBox.maxY) {
            super.attackTime = 10;
            entity.motionX = super.motionX * 3.0;
            entity.motionY = super.rand.nextFloat() * 2.533F;
            entity.motionZ = super.motionZ * 3.0;
            attackEntityAsMob(entity);
            // entity.attackEntityFrom(DamageSource.causeMobDamage(this), super.attackStrength);
        }

        super.attackEntity(entity, f);
    }

    @Override
    protected Entity findPlayerToAttack() {
        if (this.angerLevel > 0) {
            this.angerLevel--;
        }

        return this.angerLevel == 0 ? null : super.findPlayerToAttack();
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {
        if (this.isEntityInvulnerable()) {
            return false;
        } else {
            Entity entity = source.getEntity();

            if (entity instanceof EntityPlayer) {
                List<Entity> list = this.worldObj
                    .getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(32.0D, 32.0D, 32.0D));

                for (int i = 0; i < list.size(); ++i) {
                    Entity entity1 = (Entity) list.get(i);

                    if (entity1 instanceof EntityRockMonster) {
                        EntityRockMonster rockMonster = (EntityRockMonster) entity1;
                        rockMonster.becomeAngryAt(entity);
                    }
                }

                this.becomeAngryAt(entity);
            }

            return super.attackEntityFrom(source, amount);
        }
    }

    @Override
    protected String getLivingSound() {
        return "morecreeps:RockMonster";
    }

    @Override
    protected String getHurtSound() {
        return "morecreeps:RockMonsterHurt";
    }

    @Override
    protected String getDeathSound() {
        return "morecreeps:RockMonsterDeath";
    }

    @Override
    public void playLivingSound() {
        String s = this.getLivingSound();
        if (s != null) {
            super.worldObj.playSoundAtEntity(
                this,
                s,
                this.getSoundVolume(),
                (super.rand.nextFloat() - super.rand.nextFloat()) * 0.2F + 1.0F + (3.0F - this.getModelSize()));
        }
    }

    @Override
    protected Item getDropItem() {
        return Item.getItemFromBlock(dropItems[this.rand.nextInt(dropItems.length)]);
    }

    public static final String ANGER_NBT = CREEPSConstants.MOD_ID_DOT + "ANGERLEVELS";

    @Override
    public void writeEntityToNBT(NBTTagCompound nbttagcompound) {
        super.writeEntityToNBT(nbttagcompound);
        nbttagcompound.setInteger(ANGER_NBT, this.angerLevel);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nbttagcompound) {
        super.readEntityFromNBT(nbttagcompound);
        nbttagcompound.getInteger(ANGER_NBT);
    }

    @Override
    public void onDeath(DamageSource damageSource) {
        super.onDeath(damageSource);

        if (this.entityToAttack instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) this.entityToAttack;

            AchievementUtil.givePlayerAchievement(player, AchievmentRegistry.achieverockmonster);

        }

    }
}
