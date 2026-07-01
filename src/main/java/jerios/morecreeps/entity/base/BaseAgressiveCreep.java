package jerios.morecreeps.entity.base;

import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class BaseAgressiveCreep extends EntityMob {

    boolean canBeShrunk = false;

    public float getModelSize() {
        return this.getDataWatcher()
            .getWatchableObjectFloat(SIZE_DW);
    }

    public void setModelSize(float modelSize) {
        this.getDataWatcher()
            .updateObject(SIZE_DW, modelSize);
    }

    public void setCanBeShrunk(boolean canBeShrunk) {
        this.canBeShrunk = canBeShrunk;
    }

    public boolean canBeShrunk() {
        return canBeShrunk;
    }

    public BaseAgressiveCreep(World world) {
        super(world);
        setModelSize(1.0F);
    }

    public BaseAgressiveCreep(World world, float modelSize) {
        super(world);
        setModelSize(modelSize);
        setSize(this.width * this.getModelSize(), this.height * this.getModelSize() + 0.5F);
    }

    public void setIncreasedHP(int spawnAdditionalHP) {
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
            .setBaseValue((double) this.getMaxHealth() + (double) this.rand.nextInt(spawnAdditionalHP));
        this.setHealth(this.getMaxHealth());
    }

    public void spawnHook() {}

    @Override
    public IEntityLivingData onSpawnWithEgg(IEntityLivingData iEntityLivingData) {
        spawnHook();

        return super.onSpawnWithEgg(iEntityLivingData);
    }

    private static final int SIZE_DW = 20;

    @Override
    protected void entityInit() {
        super.entityInit();
        this.getDataWatcher()
            .addObject(SIZE_DW, 1.0F);
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
