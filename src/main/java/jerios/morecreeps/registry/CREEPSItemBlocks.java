package jerios.morecreeps.registry;

import jerios.morecreeps.item.BlockCREEPSSpawner;
import jerios.morecreeps.item.ItemMonsterSpawner;
import jerios.morecreeps.item.consumables.ItemBandaid;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

import cpw.mods.fml.common.registry.GameRegistry;
import jerios.morecreeps.item.CreepSpawnEggItem;
import jerios.morecreeps.item.base.CREEPSItem;
import jerios.morecreeps.item.gems.HealingGemItem;
import jerios.morecreeps.item.misc.BatteryItem;
import jerios.morecreeps.item.throwables.ItemGooDonut;
import jerios.morecreeps.item.throwables.ItemMoney;

public class CREEPSItemBlocks {

    public static Item spawnEgg;
    public static Item healingGem;
    public static Item gooDonut;
    public static Item battery;
    public static Item money;
    public static Item ram16k;
    public static Item bandaid;

    public static void registerItems() {
        spawnEgg = new CreepSpawnEggItem().setCreativeTab(TabsManager.SPAWN_EGG_TAB);
        registerItem(spawnEgg, "spawn_egg");

        healingGem = new HealingGemItem();
        registerItem(healingGem, "healingGem");

        gooDonut = new ItemGooDonut();
        registerItem(gooDonut, "GooDonut");

        battery = new BatteryItem();
        registerItem(battery, "Battery");

        money = new ItemMoney();
        registerItem(money, "money");

        ram16k = new CREEPSItem("ram16k").setMaxStackSize(64);
        registerItem(ram16k, "ram16k");

        bandaid = new ItemBandaid();
        registerItem(bandaid, "bandAid");

        registerBlocks();
    }

    public static Block spawner;

    private static void registerBlocks() {

        spawner= new BlockCREEPSSpawner().setCreativeTab(TabsManager.SPAWN_EGG_TAB);

        GameRegistry.registerBlock(spawner, ItemMonsterSpawner.class, "monsterSpawner");
    }

    private static void registerItem(Item item, String name) {
        GameRegistry.registerItem(item, name);
    }
}
