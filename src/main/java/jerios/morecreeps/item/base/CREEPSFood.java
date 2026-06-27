package jerios.morecreeps.item.base;

import jerios.morecreeps.CREEPSConstants;
import jerios.morecreeps.registry.TabsManager;
import net.minecraft.item.Item;

public class CREEPSFood extends Item {

    public CREEPSFood(String name) {
        this.setUnlocalizedName(name);
        this.setCreativeTab(TabsManager.FOODS_TAB);
        this.setTextureName(CREEPSConstants.MODID_PREFIX + name);
    }


}
