package jerios.morecreeps.entity.netural;

import jerios.morecreeps.CREEPSConstants;
import jerios.morecreeps.Config;
import jerios.morecreeps.MoreCreeps;
import jerios.morecreeps.entity.base.BaseAgressiveCreep;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class InvisibleManEntity extends BaseAgressiveCreep {

    private static final ItemStack defaultHeldItem = new ItemStack(Items.stick, 1);

   /** private static final int[] dropItems = new int[]{
        Item.stick.shiftedIndex,
        Item.stick.shiftedIndex,
        Item.stick.shiftedIndex,
        Item.stick.shiftedIndex,
        Item.appleRed.shiftedIndex,
        Item.bread.shiftedIndex,
        Item.bread.shiftedIndex,
        Item.cake.shiftedIndex,
        Item.stick.shiftedIndex,
        Item.cake.shiftedIndex,
        Item.stick.shiftedIndex,
        Item.stick.shiftedIndex,
        Item.stick.shiftedIndex,
        Item.stick.shiftedIndex,
        Item.stick.shiftedIndex,
        Item.stick.shiftedIndex,
        Item.stick.shiftedIndex,
        Item.stick.shiftedIndex,
        Item.stick.shiftedIndex,
        Item.stick.shiftedIndex,
        Item.stick.shiftedIndex,
        Item.stick.shiftedIndex,
        Item.stick.shiftedIndex,
        Item.stick.shiftedIndex,
        Item.ingotGold.shiftedIndex,
        Item.stick.shiftedIndex,
        Item.stick.shiftedIndex,
        Item.stick.shiftedIndex,
        Item.appleRed.shiftedIndex,
        Item.appleRed.shiftedIndex,
        Item.stick.shiftedIndex
    };
   **/

    public InvisibleManEntity(World world) {
        super(world);
        setAnger(0);
        setTexture("invisibleman");
        this.experienceValue = 7;
    }

    @Override
    public void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
            .setBaseValue(20D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue(0.5D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
            .setBaseValue(2D);
    }

    @Override
    public void spawnHook() {
        this.setIncreasedHP(10);
    }

    public static int ANGRY = 21;
    public static int TEXTURE = 22;

    @Override
    protected void entityInit() {
        super.entityInit();
        this.getDataWatcher().addObject(ANGRY, 0);
        this.getDataWatcher().addObject(TEXTURE, "");
    }

    public int getAnger() {
        return this.getDataWatcher().getWatchableObjectInt(ANGRY);
    }

    public void setAnger(int anger) {
        this.getDataWatcher().updateObject(ANGRY, anger);
    }

    public String getTexture() {
        return this.getDataWatcher().getWatchableObjectString(TEXTURE);
    }

    public void setTexture(String texture) {
        this.getDataWatcher().updateObject(TEXTURE, texture);
    }


    public static final String ANGER_NBT = CREEPSConstants.MOD_ID_DOT + "ANGER";
    public static final String TEXTURE_NBT = CREEPSConstants.MOD_ID_DOT + "TEXTURE";
    @Override
    public void writeEntityToNBT(NBTTagCompound nbttagcompound) {
        super.writeEntityToNBT(nbttagcompound);
        nbttagcompound.setInteger(ANGER_NBT, this.getAnger());
        nbttagcompound.setString(TEXTURE_NBT, this.getTexture());
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nbttagcompound) {
        super.readEntityFromNBT(nbttagcompound);
        this.setAnger(nbttagcompound.getInteger(ANGER_NBT));
        this.setTexture(nbttagcompound.getString(TEXTURE_NBT));
    }

    @Override
    protected Entity findPlayerToAttack() {
        if (this.getAnger() == 0) {
            return null;
        }

        this.setTexture("invisiblemanmad");
     //   super.texture = "/mob/creeps/invisiblemanmad.png";
        return super.findPlayerToAttack();
    }

    @Override
    protected void attackEntity(Entity entity, float f) {
        if (super.onGround) {
            double d = entity.posX - super.posX;
            double d1 = entity.posZ - super.posZ;
            float f2 = MathHelper.sqrt_double(d * d + d1 * d1);
            super.motionX = d / f2 * 0.2 * 0.8F + super.motionX * 0.2F;
            super.motionZ = d1 / f2 * 0.2 * 0.8F + super.motionZ * 0.2F;
            super.motionY = 0.20000000596246448;
        } else if (f < 2.5 && entity.boundingBox.maxY > super.boundingBox.minY && entity.boundingBox.minY < super.boundingBox.maxY) {
            super.attackTime = 20;
            attackEntityAsMob(entity);
            if (Config.invisibleManGetsAngryWhenPunched) {
                this.setAnger(this.getAnger() + this.rand.nextInt(15) + 5);
            }

        }
    }

    @Override
    public ItemStack getHeldItem() {
        return defaultHeldItem;
    }

    @Override
    public int getMaxSpawnedInChunk() {
        return 1;
    }


    @Override
    public void playLivingSound() {
        String s = this.getLivingSound();
        if (s != null) {
            super.worldObj
                .playSoundAtEntity(this, s, this.getSoundVolume(), (super.rand.nextFloat() - super.rand.nextFloat()) * 0.2F + 1.0F + (1.0F - this.getModelSize()) * 2.0F);
        }
    }

    @Override
    protected String getLivingSound() {
        return this.getAnger() == 0 ? "morecreeps:invisibleman" : "morecreeps:invisiblemanangry";
    }

    @Override
    protected String getHurtSound() {
        return "morecreeps:invisiblemanhurt";
    }

    @Override
    protected String getDeathSound() {
        return "morecreeps:invisiblemandeath";
    }


}
