package jerios.morecreeps;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import jerios.morecreeps.registry.RegistryHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;

@Mod(modid = MoreCreeps.MODID, version = Tags.VERSION, name = "MyMod", acceptedMinecraftVersions = "[1.7.10]")
public class MoreCreeps {

    public static final String MODID = "morecreeps";

    @Mod.Instance("morecreeps")
    public static MoreCreeps INSTANCE;


    public static final Logger LOG = LogManager.getLogger(MODID);

    @SidedProxy(clientSide = "jerios.morecreeps.ClientProxy", serverSide = "jerios.morecreeps.CommonProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        Config.synchronizeConfiguration(event.getSuggestedConfigurationFile());
        RegistryHandler.registerItems();
        RegistryHandler.registerMobs();
        proxy.clientProxy();
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void debugPlayer(LivingEvent livingEvent) {
        if(livingEvent.entityLiving instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) livingEvent.entityLiving;
            if (!player.worldObj.isRemote) {
             //   if( player.getCommandSenderName() != null .equals("MORE_CREEP_DEV")) {
                    // debugging, remove for release
                  // player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 40, 5));
              //  }
            }

        }
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    }

    @Mod.EventHandler
    public void serverStarting(FMLServerStartingEvent event) {
    }
}
