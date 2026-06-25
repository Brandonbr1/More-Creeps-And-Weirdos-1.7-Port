package jerios.morecreeps.entity.agressive;

import jerios.morecreeps.entity.base.BaseAgressiveCreep;
import net.minecraft.entity.Entity;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
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

        double superX = 0;
        double superZ = 0;

        // super buncy
        if (rand.nextInt(32) == 0)
        {
            double x = Math.sqrt(attacker.rotationYaw * this.rotationYaw);
            double z = Math.sqrt(attacker.rotationYaw * this.rotationYaw);

            superX = Math.abs(x);
            superZ = Math.abs(z);
        }

        this.attackDelay = this.worldObj.rand.nextInt(this.attackDelayMax);
        double xHeading = -MathHelper.sin(attacker.rotationYaw * 3.141593F / 180.0F);
        double zHeading = MathHelper.cos(attacker.rotationYaw * 3.141593F / 180.0F);

        this.motionX = xHeading * (1.0D + superX);
        this.motionZ = zHeading * (1.0D + superZ);

        return super.attackEntityFrom(source, amount);
    }

    @Override
    protected void attackEntity(Entity mob, float dist) {

        if (this.onGround) {
            double posXDiff = mob.posX - this.posX;
            double posZDiff = mob.posZ - this.posZ;
            float srtDiff = MathHelper.sqrt_double(posXDiff * posXDiff + posZDiff * posZDiff);
            this.motionX = posXDiff / srtDiff * 0.4D * 0.500000001920929D + this.motionX * 0.18000000098023225D;
            this.motionZ = posZDiff / srtDiff * 0.4D * 0.37000000192092897D + this.motionZ * 0.18000000098023225D;
            this.motionY = 0.15000000019604645D;
        }

        if (dist < 6.0D) {
            double d = mob.posX - this.posX;
            double d1 = mob.posZ - this.posZ;
            float f2 = MathHelper.sqrt_double(d * d + d1 * d1);
            this.motionX = d / f2 * 0.4D * 0.40000000192092894D + this.motionX * 0.18000000098023225D;
            this.motionZ = d1 / f2 * 0.4D * 0.27000000192092893D + this.motionZ * 0.18000000098023225D;
            this.rotationPitch = 90.0F;
        }


        if (this.attackTime <= 0 && dist < 3.0F - (2.5F - this.getModelSize()) && mob.boundingBox.maxY > this.boundingBox.minY && mob.boundingBox.minY < this.boundingBox.maxY)
        {
            this.attackTime = 10;
            this.attackEntityAsMob(mob);
        }
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();

        this.ignoreFrustumCheck = this.getModelSize() > 1.0F;

    }



    Item[] itemsList = new Item[]{
    };

    @Override
    protected void dropFewItems(boolean recentHit, int lootLevel) {
        super.dropFewItems(recentHit, lootLevel);

        int random200 = this.worldObj.rand.nextInt(200);
        int random5 = this.worldObj.rand.nextInt(5);

        if (!(random200 == 98)) {

            int random100 = this.worldObj.rand.nextInt(100);

            if (random100 > 98)
            {

            } else if (random100 > 88) {

            } else if (random100 > 80) {

            }


        } else if (random5 == 0) {
            dropItem(Items.gold_ingot, this.rand.nextInt(2) + 1);
        } else {
            dropItem( Item.getItemFromBlock(Blocks.gold_block), 1);
        }


    }

    @Override
    public IEntityLivingData onSpawnWithEgg(IEntityLivingData p_110161_1_) {

        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(40D + (double)this.rand.nextInt(40));
        this.setHealth(this.getMaxHealth());

        return super.onSpawnWithEgg(p_110161_1_);
    }
}
