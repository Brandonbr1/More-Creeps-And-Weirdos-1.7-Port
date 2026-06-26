package jerios.morecreeps.utils;

import jerios.morecreeps.CREEPSConstants;
import jerios.morecreeps.MoreCreeps;
import net.minecraft.util.ResourceLocation;

public class ResourceLocationUtils {

    public static ResourceLocation makeResourceLocationEntityHostile(String filename) {
        return new ResourceLocation(MoreCreeps.MODID, CREEPSConstants.ENTITY_AGREESIVE + filename + ".png");
    }

    public static ResourceLocation makeResourceLocationEntityPeaceful(String filename) {
        return new ResourceLocation(MoreCreeps.MODID, CREEPSConstants.ENTITY_PEACEFUL + filename + ".png");
    }


}
