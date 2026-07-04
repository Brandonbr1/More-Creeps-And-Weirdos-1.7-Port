package jerios.morecreeps;

import java.util.Random;

import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IIcon;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import jerios.morecreeps.registry.AchievmentRegistry;
import jerios.morecreeps.registry.CREEPSItemBlocks;
import jerios.morecreeps.registry.RegistryHandler;
import jerios.morecreeps.utils.AchievementUtil;
import jerios.morecreeps.utils.CREEPSProps;

@Mod(
    modid = MoreCreeps.MODID,
    version = Tags.VERSION,
    name = "More Creeps And Weirdos 1.7 Port",
    acceptedMinecraftVersions = "[1.7.10]")
public class MoreCreeps {

    public static final String MODID = "morecreeps";

    // for unimportant stuff
    public static final Random globalRandom = new Random(49984322L * 848764L);

    @Mod.Instance("morecreeps")
    public static MoreCreeps INSTANCE;

    @SidedProxy(clientSide = "jerios.morecreeps.ClientProxy", serverSide = "jerios.morecreeps.CommonProxy")
    public static CommonProxy proxy;

    public static DamageSource DAMAGESOURCE_TAZED = new DamageSource("tazed");

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        Config.synchronizeConfiguration(event.getSuggestedConfigurationFile());
        RegistryHandler.registerPreInit();
        proxy.clientProxy();
        MinecraftForge.EVENT_BUS.register(this);
        FMLCommonHandler.instance()
            .bus()
            .register(this);
        CREEPSProps.register();
    }

    boolean DEBUG_MODE = false;

    // REMOVE THIS FOR RELEASE BUILDS
    @SubscribeEvent
    public void debugPlayer(LivingAttackEvent livingEvent) {
        if (livingEvent.entity instanceof EntityPlayer player) {

            if (player.getCommandSenderName()
                .equals("MORE_CREEP_DEV") && DEBUG_MODE) {
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

    private boolean loggedIn = false;
    @SubscribeEvent
    public void onJoinWorld(PlayerEvent.PlayerLoggedInEvent event) {
            if (Config.greeting && !loggedIn) {
                loggedIn = true;
                event.player.worldObj.playSoundAtEntity(event.player, "morecreeps:WelcomePlayer", 1.0F, 1.0F);
            }


    }

    @SubscribeEvent
    public void onPickup(PlayerEvent.ItemPickupEvent pickupEvent) {
        ItemStack[] inv = pickupEvent.player.inventory.mainInventory;

        EntityPlayer player = pickupEvent.player;

        ItemStack stack = pickupEvent.pickedUp.getEntityItem();

        boolean hasItem = stack.getItem() == CREEPSItemBlocks.money || stack.getItem() == CREEPSItemBlocks.ram16k;

        if (hasItem) {

            int money = 0;
            int ram = 0;

            for (int i = 0; i < inv.length; i++) {

                ItemStack allStack = inv[i];

                boolean check = allStack != null && allStack.getItem() != null;

                if (check && allStack.getItem() == CREEPSItemBlocks.money) {
                    money += allStack.stackSize;

                    if (money > 99) {
                        AchievementUtil.givePlayerAchievement(player, AchievmentRegistry.achieve100bucks);
                    }

                    if (money > 499) {
                        AchievementUtil.givePlayerAchievement(player, AchievmentRegistry.achieve500bucks);
                    }

                    if (money > 999) {
                        AchievementUtil.givePlayerAchievement(player, AchievmentRegistry.achieve1000bucks);
                    }

                }

                if (check && allStack.getItem() == CREEPSItemBlocks.ram16k) {
                    ram += allStack.stackSize;

                    if (ram > 8) {
                        AchievementUtil.givePlayerAchievement(player, AchievmentRegistry.achieveram128);
                    }

                    if (ram > 32) {
                        AchievementUtil.givePlayerAchievement(player, AchievmentRegistry.achieveram512);
                    }

                    if (ram > 64) {
                        AchievementUtil.givePlayerAchievement(player, AchievmentRegistry.achieveram1024);
                    }

                }

            }

        }

    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        RegistryHandler.registerInit();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {}

    @Mod.EventHandler
    public void serverStarting(FMLServerStartingEvent event) {}
}
