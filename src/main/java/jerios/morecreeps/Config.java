package jerios.morecreeps;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class Config {

    public static boolean greeting = true;
    public static boolean invisibleManGetsAngryWhenPunched = true;

    public static void synchronizeConfiguration(File configFile) {
        Configuration configuration = new Configuration(configFile);

        greeting = configuration.getBoolean(
            "greeting",
            Configuration.CATEGORY_GENERAL,
            true,
            "Should More Creeps Narrator greet you on world Join?");

        invisibleManGetsAngryWhenPunched = configuration.getBoolean(
            "Invisible Man",
            Configuration.CATEGORY_GENERAL,
            true,
            "Should the invisible man get more angry when you attack it?");

        if (configuration.hasChanged()) {
            configuration.save();
        }
    }
}
