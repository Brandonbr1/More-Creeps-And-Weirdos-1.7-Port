package jerios.morecreeps.utils;


import cpw.mods.fml.common.FMLLog;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.stats.StatBase;
import net.minecraft.stats.StatList;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class CreepsList {

    private static final Logger logger = LogManager.getLogger();
    /** Provides a mapping between entity classes and a string */
    public static Map<String, Class<? extends net.minecraft.entity.Entity>> stringToClassMapping = new HashMap();
    /** Provides a mapping between a string and an entity classes */
    public static Map<Class<? extends net.minecraft.entity.Entity>, String> classToStringMapping = new HashMap();
    /** provides a mapping between an entityID and an Entity Class */
    public static Map<Integer, Class<? extends net.minecraft.entity.Entity>> IDtoClassMapping = new HashMap();
    /** provides a mapping between an Entity Class and an entity ID */
    private static Map classToIDMapping = new HashMap();
    /** Maps entity names to their numeric identifiers */
    private static Map stringToIDMapping = new HashMap();
    /** This is a HashMap of the Creative Entity Eggs/Spawners. */
    public static HashMap<Integer, CreepsList.EntityEggInfo> entityEggs = new LinkedHashMap();

    /**
     * adds a mapping between Entity classes and both a string representation and an ID
     */
    public static void addMapping(Class<? extends net.minecraft.entity.Entity> p_75618_0_, String p_75618_1_, int p_75618_2_)
    {
        if (p_75618_2_ < 0 || p_75618_2_ > Integer.MAX_VALUE - 1) throw new IllegalArgumentException("Attempted to register a entity with invalid ID: " + p_75618_2_ + " Name: " + p_75618_1_ + " Class: " + p_75618_0_);
        if (stringToClassMapping.containsKey(p_75618_1_))
        {
            throw new IllegalArgumentException("ID is already registered: " + p_75618_1_);
        }
        else if (IDtoClassMapping.containsKey(p_75618_2_))
        {
            throw new IllegalArgumentException("ID is already registered: " + p_75618_2_);
        }
        else
        {
            stringToClassMapping.put(p_75618_1_, p_75618_0_);
            classToStringMapping.put(p_75618_0_, p_75618_1_);
            IDtoClassMapping.put(p_75618_2_, p_75618_0_);
            classToIDMapping.put(p_75618_0_, p_75618_2_);
            stringToIDMapping.put(p_75618_1_, p_75618_2_);
        }
    }

    /**
     * Adds a entity mapping with egg info.
     */
    public static void addMapping(Class<? extends net.minecraft.entity.Entity> p_75614_0_, String p_75614_1_, int p_75614_2_, int p_75614_3_, int p_75614_4_)
    {
        addMapping(p_75614_0_, p_75614_1_, p_75614_2_);
        entityEggs.put(p_75614_2_, new CreepsList.EntityEggInfo(p_75614_2_, p_75614_3_, p_75614_4_));
    }

    /**
     * Create a new instance of an entity in the world by using the entity name.
     */
    public static Entity createEntityByName(String p_75620_0_, World p_75620_1_)
    {
        Entity entity = null;

        try
        {
            Class oclass = (Class)stringToClassMapping.get(p_75620_0_);

            if (oclass != null)
            {
                entity = (Entity)oclass.getConstructor(new Class[] {World.class}).newInstance(new Object[] {p_75620_1_});
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }

        return entity;
    }

    /**
     * create a new instance of an entity from NBT store
     */
    public static Entity createEntityFromNBT(NBTTagCompound p_75615_0_, World p_75615_1_)
    {
        Entity entity = null;

        if ("Minecart".equals(p_75615_0_.getString("id")))
        {
            switch (p_75615_0_.getInteger("Type"))
            {
                case 0:
                    p_75615_0_.setString("id", "MinecartRideable");
                    break;
                case 1:
                    p_75615_0_.setString("id", "MinecartChest");
                    break;
                case 2:
                    p_75615_0_.setString("id", "MinecartFurnace");
            }

            p_75615_0_.removeTag("Type");
        }

        Class oclass = null;
        try
        {
            oclass = (Class)stringToClassMapping.get(p_75615_0_.getString("id"));

            if (oclass != null)
            {
                entity = (Entity)oclass.getConstructor(new Class[] {World.class}).newInstance(new Object[] {p_75615_1_});
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }

        if (entity != null)
        {
            try
            {
                entity.readFromNBT(p_75615_0_);
            }
            catch (Exception e)
            {
                FMLLog.log(Level.ERROR, e,
                    "An Entity %s(%s) has thrown an exception during loading, its state cannot be restored. Report this to the mod author",
                    p_75615_0_.getString("id"), oclass.getName());
                entity = null;
            }
        }
        else
        {
            logger.warn("Skipping Entity with id " + p_75615_0_.getString("id"));
        }

        return entity;
    }

    /**
     * Create a new instance of an entity in the world by using an entity ID.
     */
    public static Entity createEntityByID(int p_75616_0_, World p_75616_1_)
    {
        Entity entity = null;

        try
        {
            Class oclass = getClassFromID(p_75616_0_);

            if (oclass != null)
            {
               entity = (Entity)oclass.getConstructor(new Class[] {World.class}).newInstance(new Object[] {p_75616_1_});
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }

        if (entity == null)
        {
            logger.warn("Skipping Entity with id " + p_75616_0_);
        }

        return entity;
    }

    /**
     * gets the entityID of a specific entity
     */
    public static int getEntityID(Entity p_75619_0_)
    {
        Class oclass = p_75619_0_.getClass();
        return classToIDMapping.containsKey(oclass) ? ((Integer)classToIDMapping.get(oclass)).intValue() : 0;
    }

    /**
     * Return the class assigned to this entity ID.
     */
    public static Class<? extends net.minecraft.entity.Entity> getClassFromID(int p_90035_0_)
    {
        return (Class)IDtoClassMapping.get(Integer.valueOf(p_90035_0_));
    }

    /**
     * Gets the string representation of a specific entity.
     */
    public static String getEntityString(Entity p_75621_0_)
    {
        return (String)classToStringMapping.get(p_75621_0_.getClass());
    }

    /**
     * Finds the class using IDtoClassMapping and classToStringMapping
     */
    public static String getStringFromID(int p_75617_0_)
    {
        Class oclass = getClassFromID(p_75617_0_);
        return oclass != null ? (String)classToStringMapping.get(oclass) : null;
    }

    public static StatBase func_151182_a(CreepsList.EntityEggInfo p_151182_0_)
    {
        String s = CreepsList.getStringFromID(p_151182_0_.spawnedID);
        return s == null ? null : (new StatBase("stat.killEntity." + s, new ChatComponentTranslation("stat.entityKill", new Object[] {new ChatComponentTranslation("entity." + s + ".name", new Object[0])}))).registerStat();
    }

    public static StatBase func_151176_b(CreepsList.EntityEggInfo p_151176_0_)
    {
        String s = CreepsList.getStringFromID(p_151176_0_.spawnedID);
        return s == null ? null : (new StatBase("stat.entityKilledBy." + s, new ChatComponentTranslation("stat.entityKilledBy", new Object[] {new ChatComponentTranslation("entity." + s + ".name", new Object[0])}))).registerStat();
    }


    public static class EntityEggInfo
    {
        /** The entityID of the spawned mob */
        public final int spawnedID;
        /** Base color of the egg */
        public final int primaryColor;
        /** Color of the egg spots */
        public final int secondaryColor;
        public final StatBase field_151512_d;
        public final StatBase field_151513_e;

        public EntityEggInfo(int p_i1583_1_, int p_i1583_2_, int p_i1583_3_)
        {
            this.spawnedID = p_i1583_1_;
            this.primaryColor = p_i1583_2_;
            this.secondaryColor = p_i1583_3_;
            this.field_151512_d = CreepsList.func_151182_a(this);
            this.field_151513_e = CreepsList.func_151176_b(this);
        }
    }


}
