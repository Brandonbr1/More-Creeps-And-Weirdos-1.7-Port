package jerios.morecreeps.registry;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

import cpw.mods.fml.common.registry.GameRegistry;
import jerios.morecreeps.item.BlockCREEPSSpawner;
import jerios.morecreeps.item.ItemCreepSpawnEgg;
import jerios.morecreeps.item.ItemMonsterSpawner;
import jerios.morecreeps.item.base.ItemsCREEPS;
import jerios.morecreeps.item.consumables.BandaidItems;
import jerios.morecreeps.item.gems.HealingGemItems;
import jerios.morecreeps.item.misc.BatteryItems;
import jerios.morecreeps.item.throwables.GooDonutItems;
import jerios.morecreeps.item.throwables.MoneyItems;

public class CREEPSItemBlocks {

    public static Item spawnEgg;
    public static Item healingGem;
    public static Item gooDonut;
    public static Item battery;
    public static Item money;
    public static Item ram16k;
    public static Item bandaid;

    public static void registerItems() {
        spawnEgg = new ItemCreepSpawnEgg().setCreativeTab(TabsManager.SPAWN_EGG_TAB);
        registerItem(spawnEgg, "spawn_egg");

        healingGem = new HealingGemItems();
        registerItem(healingGem, "healingGem");

        gooDonut = new GooDonutItems();
        registerItem(gooDonut, "GooDonut");

        battery = new BatteryItems();
        registerItem(battery, "Battery");

        money = new MoneyItems();
        registerItem(money, "money");

        ram16k = new ItemsCREEPS("ram16k").setMaxStackSize(64);
        registerItem(ram16k, "ram16k");

        bandaid = new BandaidItems();
        registerItem(bandaid, "bandAid");

        registerBlocks();
    }

    public static Block spawner;

    private static void registerBlocks() {

        spawner = new BlockCREEPSSpawner().setCreativeTab(TabsManager.SPAWN_EGG_TAB);

        GameRegistry.registerBlock(spawner, ItemMonsterSpawner.class, "monsterSpawner");
    }

    private static void registerItem(Item item, String name) {
        GameRegistry.registerItem(item, name);
    }
}
