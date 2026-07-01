package jerios.morecreeps.item.base;

import net.minecraft.item.Item;

import jerios.morecreeps.CREEPSConstants;
import jerios.morecreeps.registry.TabsManager;

public class CREEPSFood extends Item {

    public CREEPSFood(String name) {
        this.setUnlocalizedName(name);
        this.setCreativeTab(TabsManager.FOODS_TAB);
        this.setTextureName(CREEPSConstants.MODID_PREFIX + name);
    }

}
