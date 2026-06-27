package jerios.morecreeps.entity.fx;

import net.minecraft.client.particle.EntityFX;
import net.minecraft.world.World;

public class ConfettiFX extends EntityFX {

    public ConfettiFX(World world, double x, double y, double z) {
        super(world, x, y, z);
    }

    public ConfettiFX(World world, double x, double y, double z, double motionX, double motionY, double motionZ) {
        super(world, x, y, z, motionX, motionY, motionZ);
    }
}
