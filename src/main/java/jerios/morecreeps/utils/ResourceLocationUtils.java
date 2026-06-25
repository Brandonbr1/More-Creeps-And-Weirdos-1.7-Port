package jerios.morecreeps.utils;

import jerios.morecreeps.Constants;
import jerios.morecreeps.MoreCreeps;
import net.minecraft.util.ResourceLocation;

public class ResourceLocationUtils {

    public static ResourceLocation makeResourceLocationEntityHostile(String filename) {
        return new ResourceLocation(MoreCreeps.MODID, Constants.ENTITY_AGREESIVE + filename + ".png");
    }

    public static ResourceLocation makeResourceLocationEntityPeaceful(String filename) {
        return new ResourceLocation(MoreCreeps.MODID, Constants.ENTITY_PEACEFUL + filename + ".png");
    }


}
