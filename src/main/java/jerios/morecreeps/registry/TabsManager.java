package jerios.morecreeps.registry;

import jerios.morecreeps.tabs.CREEPSFoodTab;
import jerios.morecreeps.tabs.CREEPSItemsTab;
import jerios.morecreeps.tabs.CREEPSSpawnEggTab;
import net.minecraft.creativetab.CreativeTabs;

public class TabsManager {

    public static final CreativeTabs SPAWN_EGG_TAB = new CREEPSSpawnEggTab();
    public static final CreativeTabs ITEMS_TAB = new CREEPSItemsTab();
    public static final CreativeTabs FOODS_TAB = new CREEPSFoodTab();
}
