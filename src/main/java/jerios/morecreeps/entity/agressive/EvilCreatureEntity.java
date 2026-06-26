package jerios.morecreeps.entity.agressive;

import jerios.morecreeps.entity.base.BaseAgressiveCreep;
import net.minecraft.world.World;

public class EvilCreatureEntity extends BaseAgressiveCreep {

    public EvilCreatureEntity(World world) {
        super(world);
        this.isImmuneToFire = true;
        this.experienceValue = 15;
    }

    @Override
    public float getShadowSize() {
        return 2.9F;
    }
}
