package jerios.morecreeps.networking;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;
import jerios.morecreeps.CREEPSConstants;

public class CREEPSPacketHandler {

    public static final SimpleNetworkWrapper NETWORK_WRAPPER = NetworkRegistry.INSTANCE.newSimpleChannel(CREEPSConstants.MOD_ID_DOT + "PacketHandler");

    public static void registerPackets() {
     //   NETWORK_WRAPPER.registerMessage(ExamplePacket.Handler.class, ExamplePacket.class, 1, Side.CLIENT);
    }

}
