package jerios.morecreeps.entity.base;

import net.minecraft.entity.monster.EntityMob;
import net.minecraft.world.World;

public class BaseAgressiveCreep extends EntityMob {
    private int modelSize;
    private int attackStrength;

    public int getAttackStrength() {
        return attackStrength;
    }

    public void setAttackStrength(int attackStrength) {
        this.attackStrength = attackStrength;
    }

    public int getModelSize() {
        return modelSize;
    }

    public void setModelSize(int modelSize) {
        this.modelSize = modelSize;
    }

    public BaseAgressiveCreep(World world) {
        super(world);
    }
}
