package jerios.morecreeps.registry;

import jerios.morecreeps.entity.agressive.GEntity;
import jerios.morecreeps.utils.RegisterMobUtil;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;

public class CreepMobs {

    public static void registerMobs() {
        RegisterMobUtil.registerEntity(GEntity.class, "GEntity", 64, 1, true, true, 44975, 7969893);
    }

}
