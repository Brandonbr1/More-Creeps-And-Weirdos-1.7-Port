package jerios.morecreeps.entity.agressive;

import jerios.morecreeps.MoreCreeps;
import jerios.morecreeps.entity.base.BaseAgressiveCreep;
import net.minecraft.entity.Entity;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class GEntity extends BaseAgressiveCreep {
    int attackDelay;
    int attackDelayMax;

    public GEntity(World world) {
        super(world);
        this.experienceValue = 15;
        this.attackDelayMax = 8;
        this.setModelSize(2.0F);
        setSize(this.width * this.getModelSize(), this.height * this.getModelSize() + 0.5F);
    }

    @Override
    public void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(40D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.65D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(2D);
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {
        Entity attacker = source.getEntity();
        if (attacker == null) return false;

        this.entityToAttack = attacker;

        if (attacker instanceof EntityPlayer) {
            this.attackDelay = this.worldObj.rand.nextInt(this.attackDelayMax);
        }


        double xHeading = -MathHelper.sin(attacker.rotationYaw * 3.141593F / 180.0F);
        double zHeading = MathHelper.cos(attacker.rotationYaw * 3.141593F / 180.0F);

        this.motionX = xHeading;
        this.motionZ = zHeading;

        return super.attackEntityFrom(source, amount);
    }

    @Override
    protected void attackEntity(Entity mob, float dist) {

         if (this.attackDelay-- < 0) {
            this.attackDelay = attackDelayMax;

            if (this.onGround) {
                double posXDiff = mob.posX - this.posX;
                double posZDiff = mob.posZ - this.posZ;
                double srtDiff = MathHelper.sqrt_double(posXDiff * posXDiff + posZDiff * posZDiff);
                this.motionX = posXDiff / srtDiff * 0.4D * 0.500000001920929D + this.motionX * 0.18000000098023225D;
                this.motionZ = posZDiff / srtDiff * 0.4D * 0.37000000192092897D + this.motionZ * 0.18000000098023225D;
                this.motionY = 0.15000000019604645D;
            }

            if (dist < 6.0D) {
                double posXDiff = mob.posX - this.posX;
                double posZDiff = mob.posZ - this.posZ;
                double srtDiff = MathHelper.sqrt_double(posXDiff * posXDiff + posZDiff * posZDiff);
                this.motionX = posXDiff / srtDiff * 0.4D * 0.40000000192092894D + this.motionX * 0.18000000098023225D;
                this.motionZ = posZDiff / srtDiff * 0.4D * 0.27000000192092893D + this.motionZ * 0.18000000098023225D;
                this.rotationPitch = 90.0F;
            }

             if (dist < 3.0F - (2.5F - getModelSize()) && mob.boundingBox.maxY > this.boundingBox.minY && mob.boundingBox.minY < this.boundingBox.maxY)
             {
                 this.attackTime = 10;
                 this.attackEntityAsMob(mob);
             }

         }
          super.attackEntity(mob, dist);

    }

    @Override
    public int getMaxSpawnedInChunk()
    {
        return 1;
    }

    @Override
    protected String getLivingSound() {
        return "morecreeps:gliving";
    }

    @Override
    protected String getHurtSound() {
        return "morecreeps:ghurt";
    }

    @Override
    protected String getDeathSound() {
        return "morecreeps:gdeath";
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();

        this.ignoreFrustumCheck = this.getModelSize() > 1.0F;

    }

    @Override
    public void playLivingSound() {
        String s = this.getLivingSound();
        if (s != null) {
            super.worldObj.playSoundAtEntity(this, s, this.getSoundVolume(), (super.rand.nextFloat() - super.rand.nextFloat()) * 0.2F + 1.0F + (2.0F - this.getModelSize()) * 2.0F);
        }
    }


    @Override
    protected void dropFewItems(boolean recentHit, int lootLevel) {
        super.dropFewItems(recentHit, lootLevel);

        int random200 = this.worldObj.rand.nextInt(200);
        int random150 = this.worldObj.rand.nextInt(150);
        int random5 = this.worldObj.rand.nextInt(5);




        if (!(random200 == 98)) {
            if (this.worldObj.rand.nextInt(100) > 88) {
                dropItemAndCount(Item.getItemFromBlock(Blocks.grass), this.worldObj.rand.nextInt(6) + 1);
            } else if(this.worldObj.rand.nextInt(100) > 88) {
               MoreCreeps.LOG.warn("GUM");
            } else if (this.worldObj.rand.nextInt(100) > 80) {
                dropItemAndCount(Items.wheat, this.worldObj.rand.nextInt(6) + 1);
            } else {
                switch (this.worldObj.rand.nextInt(26)) {
                    case 0:
                    case 1:
                        dropItemAndCount(Items.golden_pickaxe, 1);
                        break;
                    case 2:
                    case 3:
                        dropItemAndCount(Items.golden_shovel, 1);
                        break;
                    case 4:
                    case 5:
                        dropItemAndCount(Items.golden_axe, 1);
                        break;
                    case 6:
                    case 7:
                        dropItemAndCount(Items.golden_helmet, 1);
                        break;
                    case 8:
                    case 9:
                        dropItemAndCount(Items.golden_chestplate, 1);
                        break;
                    case 10:
                    case 11:
                        dropItemAndCount(Items.golden_boots, 1);
                        break;
                    case 12:
                    case 13:
                        dropItemAndCount(Item.getItemFromBlock(Blocks.glass), this.rand.nextInt(6) + 1);
                        break;
                    case 14:
                    case 15:
                        MoreCreeps.LOG.warn("I would be the goo donut");
                        break;
                    case 16:
                    case 17:
                        dropItemAndCount(Item.getItemFromBlock(Blocks.glowstone), this.rand.nextInt(2) + 1);
                        break;
                    case 18:
                    case 19:
                        dropItemAndCount(Items.glowstone_dust, this.rand.nextInt(2) + 1);
                        break;
                    case 20:
                    case 21:
                        MoreCreeps.LOG.warn("GROW RAY");
                        break;
                    case 22:
                    case 23:
                        MoreCreeps.LOG.warn("GUN");
                        break;
                    case 24:
                    case 25:
                        break;

                }
            }


        } else if (random150 > 145) {
            dropItemAndCount(Items.golden_sword, 1);
        } else if (random5 == 0) {
            dropItemAndCount(Items.gold_ingot, this.rand.nextInt(2) + 1);
        } else {
            dropItemAndCount(Item.getItemFromBlock(Blocks.gold_block), 1);
        }

    }

    private void dropItemAndCount(Item item, int size) {
            dropItem(item, size);
    }

    @Override
    public IEntityLivingData onSpawnWithEgg(IEntityLivingData p_110161_1_) {

        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(40D + (double)this.rand.nextInt(40));
        this.setHealth(this.getMaxHealth());

        return super.onSpawnWithEgg(p_110161_1_);
    }

}
