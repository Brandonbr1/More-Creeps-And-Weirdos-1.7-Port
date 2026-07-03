package jerios.morecreeps.registry;

import jerios.morecreeps.networking.CREEPSPacketHandler;

public class RegistryHandler {

    public static void registerPreInit() {
        CREEPSItemBlocks.registerItems();
        CREEPSMobs.registerMobs();
        CREEPSPacketHandler.registerPackets();
    }

    public static void registerInit() {
        AchievmentRegistry.register();
    }

}
