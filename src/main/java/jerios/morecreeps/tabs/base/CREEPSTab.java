package jerios.morecreeps.tabs.base;

import jerios.morecreeps.CREEPSConstants;
import jerios.morecreeps.registry.CREEPSItemBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CREEPSTab extends CreativeTabs {
    public CREEPSTab(String label) {
        super(CREEPSConstants.MOD_ID_DOT + label);
    }

    @Override
    public Item getTabIconItem() {
        return CREEPSItemBlocks.healingGem;
    }
    @Override
    public boolean hasSearchBar() {
        return true;
    }

}
