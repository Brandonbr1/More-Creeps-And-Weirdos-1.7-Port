package jerios.morecreeps.registry;

public class RegistryHandler {

    public static void registerPreInit(){
        CREEPSItemBlocks.registerItems();
        CREEPSMobs.registerMobs();
    }

}
