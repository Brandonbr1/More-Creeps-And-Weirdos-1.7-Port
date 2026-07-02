package jerios.morecreeps.entity.interfaces;

public interface ICreepGrowable {

    float getModelSize();

    void setModelSize(float modelSize);

    void setCanBeShrunk(boolean canBeShrunk);

    boolean canBeShrunk();

    void onSizeChange();
}
