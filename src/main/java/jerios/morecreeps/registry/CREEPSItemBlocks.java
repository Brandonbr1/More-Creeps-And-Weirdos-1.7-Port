package jerios.morecreeps.registry;

import net.minecraft.item.Item;

import cpw.mods.fml.common.registry.GameRegistry;
import jerios.morecreeps.item.CreepSpawnEggItem;
import jerios.morecreeps.item.gems.HealingGemItem;
import jerios.morecreeps.item.misc.BatteryItem;
import jerios.morecreeps.item.throwables.ItemGooDonut;

public class CREEPSItemBlocks {

    public static Item spawnEgg;
    public static Item healingGem;
    public static Item gooDonut;
    public static Item battery;

    public static void registerItems() {
        spawnEgg = new CreepSpawnEggItem().setCreativeTab(TabsManager.SPAWN_EGG_TAB);
        registerItem(spawnEgg, "spawn_egg");

        healingGem = new HealingGemItem();
        registerItem(healingGem, "healingGem");

        gooDonut = new ItemGooDonut();
        registerItem(gooDonut, "GooDonut");

        battery = new BatteryItem();
        registerItem(battery, "Battery");

    }

    private static void registerItem(Item item, String name) {
        GameRegistry.registerItem(item, name);
    }
}
