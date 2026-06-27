package jerios.morecreeps.registry;

import cpw.mods.fml.common.registry.GameRegistry;
import jerios.morecreeps.item.CreepSpawnEggItem;
import jerios.morecreeps.item.weapons.HealingGemItem;
import net.minecraft.item.Item;

public class CREEPSItemBlocks {

    public static Item spawnEgg;
    public static Item healingGem;

    public static void registerItems() {
        spawnEgg = new CreepSpawnEggItem().setCreativeTab(TabsManager.SPAWN_EGG_TAB);
        registerItem(spawnEgg, "spawn_egg");

        healingGem = new HealingGemItem();
        registerItem(healingGem, "healing_gem");

    }

    private static void registerItem(Item item, String name) {
        GameRegistry.registerItem(item, name);
    }
}
