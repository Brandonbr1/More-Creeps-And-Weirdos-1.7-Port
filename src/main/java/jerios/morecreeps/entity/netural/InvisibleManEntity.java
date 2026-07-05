package jerios.morecreeps.entity.netural;

import jerios.morecreeps.CREEPSConstants;
import jerios.morecreeps.Config;
import jerios.morecreeps.MoreCreeps;
import jerios.morecreeps.entity.base.BaseAgressiveCreep;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStoneSlab;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class InvisibleManEntity extends BaseAgressiveCreep {

    private static final ItemStack defaultHeldItem = new ItemStack(Items.stick, 1);
    private int anger = 0;

    private static final Item[] dropItems = new Item[]{
        Items.stick,
        Items.stick,
        Items.stick,
        Items.stick,
        Items.apple,
        Items.bread,
        Items.bread,
        Items.cake,
        Items.stick,
        Items.cake,
        Items.stick,
        Items.stick,
        Items.stick,
        Items.stick,
        Items.stick,
        Items.stick,
        Items.stick,
        Items.stick,
        Items.stick,
        Items.stick,
        Items.stick,
        Items.stick,
        Items.stick,
        Items.stick,
        Items.gold_ingot,
        Items.stick,
        Items.stick,
        Items.stick,
        Items.apple,
        Items.apple,
        Items.stick
    };


    public InvisibleManEntity(World world) {
        super(world);
        anger = 0;
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

    public static int TEXTURE = 22;

    @Override
    protected void entityInit() {
        super.entityInit();
        this.getDataWatcher().addObject(TEXTURE, "");
    }

    public String getTexture() {
        return this.getDataWatcher().getWatchableObjectString(TEXTURE);
    }

    public void setTexture(String texture) {
        this.getDataWatcher().updateObject(TEXTURE, texture);
    }

    public static final String ANGER_NBT = CREEPSConstants.MOD_ID_DOT + "ANGERLEVELS";
    public static final String TEXTURE_NBT = CREEPSConstants.MOD_ID_DOT + "TEXTURE";
    @Override
    public void writeEntityToNBT(NBTTagCompound nbttagcompound) {
        super.writeEntityToNBT(nbttagcompound);
        nbttagcompound.setInteger(ANGER_NBT, anger);
        nbttagcompound.setString(TEXTURE_NBT, this.getTexture());

    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nbttagcompound) {
        super.readEntityFromNBT(nbttagcompound);
        nbttagcompound.getInteger(ANGER_NBT);
        this.setTexture(nbttagcompound.getString(TEXTURE_NBT));
    }

    @Override
    protected Entity findPlayerToAttack() {
        if (this.anger == 0) {
            return null;
        }

        this.setTexture("invisiblemanmad");
        return super.findPlayerToAttack();
    }

    @Override
    public void onUpdate() {
        if (super.entityToAttack instanceof EntityPlayer && this.anger == 0) {
            this.setTexture("invisiblemanmad");
            this.anger = this.rand.nextInt(15) + 5;
        }
        if (this.entityToAttack == null) {
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
                .setBaseValue(0.5F);
        } else {
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
                .setBaseValue(0.75F);
        }

        super.onUpdate();
        if (super.rand.nextInt(30) == 0 && this.anger > 0) {
            anger--;
            if (this.anger == 0) {
                super.worldObj.playSoundAtEntity(this, "morecreeps:InvisibleManForgetIt", 1.0F, (super.rand.nextFloat() - super.rand.nextFloat()) * 0.2F + 1.0F);
                super.entityToAttack = null;
                setTexture("invisibleman");
            }
        }
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
                anger = this.rand.nextInt(15) + 5;
            }

        }
    }

    @Override
    public boolean getCanSpawnHere() {
        int i = MathHelper.floor_double(super.posX);
        int j = MathHelper.floor_double(super.boundingBox.minY);
        int k = MathHelper.floor_double(super.posZ);
        int l = super.worldObj.getFullBlockLightValue(i, j, k);
        Block m = super.worldObj.getBlock(i, j - 1, k);
        boolean chance = true;
        int a = super.rand.nextInt(15);
        if (Config.megaSpawn && a != 0) {
            chance = false;
        }

        return m != Blocks.sand
            && m != Blocks.cobblestone
            && m != Blocks.planks
            && !(m instanceof BlockStoneSlab)
            && super.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).isEmpty()
            && super.worldObj.checkNoEntityCollision(this.boundingBox)
            && super.worldObj.canBlockSeeTheSky(i, j, k)
            && chance
            && l > 7;
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
    protected Item getDropItem()
    {
        return dropItems[this.rand.nextInt(dropItems.length)];
    }


    @Override
    protected String getLivingSound() {
        return this.anger == 0 ? "morecreeps:InvisibleMan" : "morecreeps:InvisibleManAngry";
    }

    @Override
    protected String getHurtSound() {
        return "morecreeps:InvisibleManHurt";
    }

    @Override
    protected String getDeathSound() {
        return "morecreeps:InvisibleManDeath";
    }


}
