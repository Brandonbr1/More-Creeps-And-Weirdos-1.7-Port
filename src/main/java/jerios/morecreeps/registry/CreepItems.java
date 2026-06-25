package jerios.morecreeps.registry;

import cpw.mods.fml.common.registry.GameRegistry;
import jerios.morecreeps.item.CreepSpawnEggItem;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreepItems {

    public static Item spawnEgg;
    public static Item test;

    public static void registerItems() {
        spawnEgg = new CreepSpawnEggItem().setCreativeTab(CreativeTabs.tabRedstone);
        registerItem(spawnEgg, "spawn_egg");

        test = new Item().setUnlocalizedName("TEST").setCreativeTab(CreativeTabs.tabRedstone);
        registerItem(test, "TEST ITEM");

    }

    private static void registerItem(Item item, String name) {
        GameRegistry.registerItem(item, name);
    }



}
