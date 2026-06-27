package jerios.morecreeps.item.base;

import jerios.morecreeps.CREEPSConstants;
import jerios.morecreeps.registry.TabsManager;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CREEPSItem extends Item {

    public CREEPSItem(String name) {
        this.setUnlocalizedName(name);
        this.setCreativeTab(TabsManager.ITEMS_TAB);
        this.setTextureName(CREEPSConstants.MODID_PREFIX + name);
    }


}
