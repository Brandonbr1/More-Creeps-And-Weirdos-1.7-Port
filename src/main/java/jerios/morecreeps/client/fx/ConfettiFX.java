package jerios.morecreeps.client.fx;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

@SideOnly(Side.CLIENT)
public class ConfettiFX extends EntityFX {

    public ConfettiFX(World world, double x, double y, double z){
        super(world, x, y, z, 0, 0, 0);

        float color = 1.0F;

        this.particleRed = color;
        this.particleGreen = color;
        this.particleBlue = color;

        this.particleScale = 2.0F;
        this.setSize(0.5F, 0.5F);
        this.particleMaxAge = 50;


        this.noClip = true;

        this.renderDistanceWeight = 30;
    }

    @Override
    public int getFXLayer() {
        return 1;
    }
}
