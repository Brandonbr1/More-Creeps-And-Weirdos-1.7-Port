package jerios.morecreeps;

import jerios.morecreeps.debug.CREEPSLogger;
import jerios.morecreeps.entity.nonLiving.TrophyEntity;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public class CommonProxy {

    public void clientProxy() { }




    // NO-OP SERVER METHODS
    public void spawnConfettiTrophyA(Entity trophyEntity) {
        CREEPSLogger.error("ON SERVER PROY" + trophyEntity.worldObj.isRemote);
    }

}
