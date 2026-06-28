package jerios.morecreeps.registry;

import cpw.mods.fml.common.registry.GameRegistry;
import jerios.morecreeps.CREEPSConstants;
import jerios.morecreeps.item.CreepSpawnEggItem;
import jerios.morecreeps.item.CreepSpawnEggItem2;
import jerios.morecreeps.item.weapons.HealingGemItem;
import jerios.morecreeps.utils.ParticlesManager;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CREEPSItemBlocks {

    public static Item spawnEgg;
    public static Item healingGem;
    public static Item bhef;
    public static Item particleRegistry;

    public static void registerItems() {
        spawnEgg = new CreepSpawnEggItem().setCreativeTab(TabsManager.SPAWN_EGG_TAB);
        registerItem(spawnEgg, "spawn_egg");

        healingGem = new HealingGemItem();
        registerItem(healingGem, "healingGem");

        bhef = new CreepSpawnEggItem2().setCreativeTab(CreativeTabs.tabFood);
        registerItem(bhef, "TEST TEST  TE");

        particleRegistry = new ParticlesManager();
        registerItem(particleRegistry, "Underlying Particle Handler");


    }

    private static void registerItem(Item item, String name) {
        GameRegistry.registerItem(item, name);
    }
}
