package jerios.morecreeps.item.base;

import net.minecraft.item.Item;

import jerios.morecreeps.CREEPSConstants;
import jerios.morecreeps.registry.TabsManager;

public class ItemsCREEPS extends Item {

    public ItemsCREEPS(String name) {
        this.setUnlocalizedName(name);
        this.setCreativeTab(TabsManager.ITEMS_TAB);
        this.setTextureName(CREEPSConstants.MODID_PREFIX + name);
    }

}
