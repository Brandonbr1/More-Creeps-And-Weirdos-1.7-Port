package jerios.morecreeps.client.fx;

import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class PissFX extends CREEPSFX {

    public PissFX(World world, double x, double y, double z) {
        super(world, x, y, z, false);
    }

}
