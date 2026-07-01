package jerios.morecreeps;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class Config {

    public static boolean greeting = true;

    public static void synchronizeConfiguration(File configFile) {
        Configuration configuration = new Configuration(configFile);

        greeting = configuration.getBoolean("greeting", Configuration.CATEGORY_GENERAL, true, "Should More Creeps Narrator greet you on world Join?");

        if (configuration.hasChanged()) {
            configuration.save();
        }
    }
}
