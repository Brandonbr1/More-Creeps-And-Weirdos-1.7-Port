package jerios.morecreeps.registry;

import jerios.morecreeps.entity.agressive.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;

import cpw.mods.fml.common.registry.EntityRegistry;
import jerios.morecreeps.CREEPSConstants;
import jerios.morecreeps.MoreCreeps;
import jerios.morecreeps.entity.nonLiving.EntityGooDonut;
import jerios.morecreeps.entity.nonLiving.TrophyEntity;
import jerios.morecreeps.item.CreepSpawnEggItem;

public class CREEPSMobs {

    public static void registerMobs() {
        registerEntity(GEntity.class, "GEntity", 128, 1, true, true, 44975, 7969893);
        registerEntity(TrophyEntity.class, "Trophy", 128, 1, true, true, 44975, 7969893);
        registerEntity(EvilCreatureEntity.class, "EvilCreature", 128, 1, true, true, 44975, 7969893);
        registerEntity(EntityGooDonut.class, "GooDonut", 128, 1, true, false, 44975, 7969893);
        registerEntity(EvilPigEntity.class, "EvilPig", 128, 1, true, true, 44975, 7969893);
        registerEntity(EvilLight.class, "EvilLight", 128, 1, true, true, 44975, 7969893);
        registerEntity(EvilSnowmanEntity.class, "EvilSnowman", 128, 1, true, true, 44975, 7969893);
    }

    static int id = 1;

    public static void registerEntity(Class<? extends Entity> entityClass, String entityName, int trackingRange,
        int updateFrequency, boolean sendsVelocityUpdates, boolean withEgg, int spot1, int spot2) {
        EntityRegistry.registerModEntity(
            entityClass,
            entityName,
            id++,
            MoreCreeps.INSTANCE,
            trackingRange,
            updateFrequency,
            sendsVelocityUpdates);
        if (withEgg) {
            CreepSpawnEggItem.addSpawnEgg(id++, entityClass, CREEPSConstants.MOD_ID_DOT + entityName, spot1, spot2);
        }
    }

    private static void addBiomes(Class<? extends EntityLiving> entityClass, int weightedProb, int min, int max,
        EnumCreatureType typeOfCreature, BiomeGenBase... biomes) {
        EntityRegistry.addSpawn(entityClass, weightedProb, min, max, typeOfCreature, biomes);
    }
}
