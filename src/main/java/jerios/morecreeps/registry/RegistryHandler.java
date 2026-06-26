package jerios.morecreeps.registry;

import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import jerios.morecreeps.CREEPSConstants;
import jerios.morecreeps.MoreCreeps;
import jerios.morecreeps.entity.agressive.GEntity;
import jerios.morecreeps.item.CreepSpawnEggItem;
import jerios.morecreeps.utils.CreepsList;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.Item;
import net.minecraft.world.biome.BiomeGenBase;

public class RegistryHandler {

    public static void registerMobs() {
        registerEntity(GEntity.class, "GEntity", 64, 5, true, true, 44975, 7969893);
    }

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

    static int id = 1;
    public static void registerEntity(
        Class<? extends Entity> entityClass, String entityName, int trackingRange,
        int updateFrequency, boolean sendsVelocityUpdates, boolean withEgg, int spot1, int spot2) {
        EntityRegistry.registerModEntity(
            entityClass,
            entityName,
            id++,
            MoreCreeps.INSTANCE,
            trackingRange,
            updateFrequency,
            sendsVelocityUpdates);
        if (withEgg)
        {
            CreepsList.addMapping(entityClass, CREEPSConstants.MOD_ID_DOT + entityName, id++, spot1, spot2);
        }
    }

    public static void registerEntityWithBiomes(
        Class<? extends EntityLiving> entityClass, String entityName, int trackingRange,
        int updateFrequency, boolean sendsVelocityUpdates, int weightProb, int min, int max,
        EnumCreatureType typeOfCreature, boolean withEgg, int spot1, int spot2, BiomeGenBase... biomes

    ) {
        EntityRegistry.registerModEntity(
            entityClass,
            entityName,
            id++,
            MoreCreeps.INSTANCE,
            trackingRange,
            updateFrequency,
            sendsVelocityUpdates);
        addBiomes(entityClass, weightProb, min, max, typeOfCreature, biomes);
        if (withEgg)
        {
            CreepsList.addMapping(entityClass, CREEPSConstants.MOD_ID_DOT + entityName, id++, spot1, spot2);
        }

    }

    private static void addBiomes(Class<? extends EntityLiving> entityClass, int weightedProb, int min, int max, EnumCreatureType typeOfCreature, BiomeGenBase... biomes) {
        EntityRegistry.addSpawn(entityClass, weightedProb, min, max, typeOfCreature, biomes);
    }

}
