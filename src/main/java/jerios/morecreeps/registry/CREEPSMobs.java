package jerios.morecreeps.registry;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;

import cpw.mods.fml.common.registry.EntityRegistry;
import jerios.morecreeps.CREEPSConstants;
import jerios.morecreeps.MoreCreeps;
import jerios.morecreeps.entity.agressive.*;
import jerios.morecreeps.entity.netural.EntityInvisibleMan;
import jerios.morecreeps.entity.nonLiving.EntityGooDonut;
import jerios.morecreeps.entity.nonLiving.EntityTrophy;
import jerios.morecreeps.item.ItemCreepSpawnEgg;

public class CREEPSMobs {

    public static void registerMobs() {
        registerEntityWithEgg(EntityG.class, "GEntity", 128, 1, true, 12728089, 222630);

        registerEntity(EntityTrophy.class, "Trophy", 128, 1, true, 44975, 7969893);

        registerEntityWithEgg(EntityEvilCreature.class, "EvilCreature", 128, 1, true, 2247962, 10224389);

        registerEntity(EntityGooDonut.class, "GooDonut", 128, 1, true, 44975, 7969893);

        registerEntityWithEgg(EntityEvilPig.class, "EvilPig", 128, 1, true, 12100209, 13303810);

        registerEntityWithEgg(EntityEvilLight.class, "EvilLight", 128, 1, true, 16378430, 0);

        registerEntityWithEgg(EvilSnowmanEntity.class, "EvilSnowman", 128, 1, true, 11645613, 2236962);

        registerEntityWithEgg(EntityInvisibleMan.class, "InvisibleMan", 128, 1, true, 9145227, 9145227);

        registerEntityWithEgg(EntityCastleCritter.class, "CastleCritter", 128, 1, true, 10487043, 13896822);
    }

    static int id = 10;

    public static void registerEntity(Class<? extends Entity> entityClass, String entityName, int trackingRange,
        int updateFrequency, boolean sendsVelocityUpdates, int spot1, int spot2) {
        EntityRegistry.registerModEntity(
            entityClass,
            entityName,
            id++,
            MoreCreeps.INSTANCE,
            trackingRange,
            updateFrequency,
            sendsVelocityUpdates);
    }

    public static void registerEntityWithEgg(Class<? extends Entity> entityClass, String entityName, int trackingRange,
        int updateFrequency, boolean sendsVelocityUpdates, int spot1, int spot2) {
        EntityRegistry.registerModEntity(
            entityClass,
            entityName,
            id++,
            MoreCreeps.INSTANCE,
            trackingRange,
            updateFrequency,
            sendsVelocityUpdates);
        ItemCreepSpawnEgg.addSpawnEgg(id++, entityClass, CREEPSConstants.MOD_ID_DOT + entityName, spot1, spot2);

    }

    private static void addBiomes(Class<? extends EntityLiving> entityClass, int weightedProb, int min, int max,
        EnumCreatureType typeOfCreature, BiomeGenBase... biomes) {
        EntityRegistry.addSpawn(entityClass, weightedProb, min, max, typeOfCreature, biomes);
    }
}
