package jerios.morecreeps.utils;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import jerios.morecreeps.CREEPSConstants;
import jerios.morecreeps.item.base.CREEPSItem;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

public class ParticlesManager extends Item {
    @SideOnly(Side.CLIENT)
    public static IIcon bloodParticle;


    public ParticlesManager() {
        this.setUnlocalizedName("morecreeps.underlyingParticleRegistry");
    }


    @Override
    public void registerIcons(IIconRegister register) {
        super.registerIcons(register);
        bloodParticle = register.registerIcon(CREEPSConstants.MODID_PREFIX + "blood_particle2");
    }


}
