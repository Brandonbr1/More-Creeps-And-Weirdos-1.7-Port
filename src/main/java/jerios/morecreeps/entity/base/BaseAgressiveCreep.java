package jerios.morecreeps.entity.base;

import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class BaseAgressiveCreep extends EntityMob {
    boolean canBeShrunk = false;
    int spawnAdditionalHP = 0;

    public int getSpawnAdditionalHP() {
        return spawnAdditionalHP;
    }

    public void setSpawnAdditionalHP(int spawnAdditionalHP) {
        this.spawnAdditionalHP = spawnAdditionalHP;
    }

    public float getModelSize() {
        return this.getDataWatcher().getWatchableObjectFloat(SIZE_DW);
    }

    public void setModelSize(float modelSize) {
        this.getDataWatcher().updateObject(SIZE_DW, modelSize);
    }

    public BaseAgressiveCreep(World world) {
        super(world);
        setModelSize(1.0F);
    }

    public BaseAgressiveCreep(World world, float modelSize, int spawnAdditionalHP) {
        super(world);
        setModelSize(modelSize);
        setSize(this.width * this.getModelSize(), this.height * this.getModelSize() + 0.5F);
        setSpawnAdditionalHP(spawnAdditionalHP);
    }


    @Override
    public IEntityLivingData onSpawnWithEgg(IEntityLivingData iEntityLivingData) {
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue((double)this.getMaxHealth() + (double)this.rand.nextInt(spawnAdditionalHP));
        this.setHealth(this.getMaxHealth());

        return super.onSpawnWithEgg(iEntityLivingData);
    }

    private static final int SIZE_DW = 20;
    @Override
    protected void entityInit() {
        super.entityInit();
        this.getDataWatcher().addObject(SIZE_DW, 1.0F);
    }

    private static final String DW_STRING = "CREEPSModelSize";

    @Override
    public void writeEntityToNBT(NBTTagCompound nbttagcompound) {
        super.writeEntityToNBT(nbttagcompound);
        nbttagcompound.setFloat(DW_STRING, this.getModelSize());
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nbttagcompound) {
        super.readEntityFromNBT(nbttagcompound);
        this.setModelSize(nbttagcompound.getFloat(DW_STRING));
    }
}
