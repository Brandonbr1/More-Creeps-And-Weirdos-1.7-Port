package jerios.morecreeps.utils;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import jerios.morecreeps.MoreCreeps;

public class CREEPSProps implements IExtendedEntityProperties {

    public static final String PROP_NAME = MoreCreeps.MODID + "_CREEPS_DATA";
    int fine;

    public static void register() {
        MinecraftForge.EVENT_BUS.register(new Handler());
    }

    public static CREEPSProps get(Entity p) {
        return (CREEPSProps) p.getExtendedProperties(PROP_NAME);
    }

    public static class Handler {

        @SubscribeEvent
        public void entityConstruct(EntityEvent.EntityConstructing e) {
            if (e.entity instanceof EntityPlayer) {
                if (e.entity.getExtendedProperties(PROP_NAME) == null) {
                    e.entity.registerExtendedProperties(PROP_NAME, new CREEPSProps());
                }
            }
        }

        @SubscribeEvent
        public void onClonePlayer(PlayerEvent.Clone e) {
            if (e.wasDeath) {
                NBTTagCompound compound = new NBTTagCompound();
                CREEPSProps.get(e.original)
                    .saveNBTData(compound);
                CREEPSProps.get(e.entityPlayer)
                    .loadNBTData(compound);
            }
        }

    }

    @Override
    public void saveNBTData(NBTTagCompound compound) {
        NBTTagCompound propertyData = new NBTTagCompound();

        // Write data to propertyData

        compound.setTag(PROP_NAME, propertyData);

    }

    @Override
    public void loadNBTData(NBTTagCompound compound) {
        if (compound.hasKey(PROP_NAME, Constants.NBT.TAG_COMPOUND)) {
            NBTTagCompound propertyData = compound.getCompoundTag(PROP_NAME);

        }

    }

    @Override
    public void init(Entity entity, World world) {

    }
}
