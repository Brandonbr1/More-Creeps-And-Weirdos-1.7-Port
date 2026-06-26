package jerios.morecreeps.entity.base;

import net.minecraft.entity.monster.EntityMob;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class BaseAgressiveCreep extends EntityMob {
    boolean canBeShrunk = false;


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
