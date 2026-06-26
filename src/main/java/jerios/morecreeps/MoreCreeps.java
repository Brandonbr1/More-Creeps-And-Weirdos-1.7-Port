package jerios.morecreeps;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import jerios.morecreeps.registry.RegistryHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
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

    boolean DEBUG_MODE = true;

    // REMOVE THIS FOR RELEASE BUILDS
    @SubscribeEvent
    public void debugPlayer(LivingAttackEvent livingEvent) {
        if (livingEvent.entity instanceof EntityPlayer player) {

            if (player.getCommandSenderName().equals("MORE_CREEP_DEV") && DEBUG_MODE) {
               // livingEvent.setCanceled(true);
                player.heal(livingEvent.ammount / 2);
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
