package jerios.morecreeps;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import jerios.morecreeps.registry.RegistryHandler;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IIcon;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;

import java.util.Random;

@Mod(modid = MoreCreeps.MODID, version = Tags.VERSION, name = "More Creeps And Weirdos 1.7 Port", acceptedMinecraftVersions = "[1.7.10]")
public class MoreCreeps {

    public static final String MODID = "morecreeps";

    // for unimportant stuff
    public static final Random globalRandom = new Random(49984322L * 848764L);

    @Mod.Instance("morecreeps")
    public static MoreCreeps INSTANCE;


    @SidedProxy(clientSide = "jerios.morecreeps.ClientProxy", serverSide = "jerios.morecreeps.CommonProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        Config.synchronizeConfiguration(event.getSuggestedConfigurationFile());
        RegistryHandler.registerPreInit();
        proxy.clientProxy();
        MinecraftForge.EVENT_BUS.register(this);
    }

    boolean DEBUG_MODE = false;

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
    public static IIcon blood;
    public static IIcon piss;
    public static IIcon barf;

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void addParticles(TextureStitchEvent event) {
        TextureMap map = event.map;
        if (event.map.getTextureType() == 1) {
            blood = map.registerIcon(CREEPSConstants.MODID_PREFIX + "blood_particle2");
            piss = map.registerIcon(CREEPSConstants.MODID_PREFIX + "piss_particle");
        }

    }

    // Do welcome message and sound!
   @SubscribeEvent
    public void onJoinWorld(PlayerEvent.PlayerLoggedInEvent event) {

      //  event.player.worldObj.playSoundAtEntity();

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
