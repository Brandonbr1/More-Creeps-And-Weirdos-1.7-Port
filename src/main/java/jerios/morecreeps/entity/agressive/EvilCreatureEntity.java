package jerios.morecreeps.entity.agressive;

import jerios.morecreeps.entity.base.BaseAgressiveCreep;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public class EvilCreatureEntity extends BaseAgressiveCreep  {

    public EvilCreatureEntity(World world) {
        super(world);
        this.isImmuneToFire = true;
        this.experienceValue = 15;
    }


    protected String getLivingSound() {
        return "morecreeps:evilcreature";
    }

    protected String getHurtSound() {
        return "morecreeps:evilcreaturehurt";
    }

    protected String getDeathSound() {
        return "morecreeps:evilcreaturedeath";
    }

    @Override
    public float getShadowSize() {
        return 2.9F;
    }

    @Override
    protected void dropFewItems(boolean recentHit, int lootLevel) {
        super.dropFewItems(recentHit, lootLevel);
    }

    @Override
    protected void fall(float distance) {

    }

}
