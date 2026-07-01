package jerios.morecreeps.item.base;

import net.minecraft.item.Item;

import jerios.morecreeps.CREEPSConstants;
import jerios.morecreeps.registry.TabsManager;

public class CREEPSItem extends Item {

    public CREEPSItem(String name) {
        this.setUnlocalizedName(name);
        this.setCreativeTab(TabsManager.ITEMS_TAB);
        this.setTextureName(CREEPSConstants.MODID_PREFIX + name);
    }

}
