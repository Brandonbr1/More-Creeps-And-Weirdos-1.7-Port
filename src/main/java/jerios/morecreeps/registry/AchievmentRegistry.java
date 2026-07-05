package jerios.morecreeps.registry;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

public class AchievmentRegistry {

    public static AchievementPage creepsPage;

    public static Achievement achieve100bucks;
    public static Achievement achieve500bucks;
    public static Achievement achieve1000bucks;

    public static Achievement achieveram128;
    public static Achievement achieveram512;
    public static Achievement achieveram1024;

    public static Achievement achievesnowtiny;
    public static Achievement achievesnowtall;
    public static Achievement achievesnow;

    public static Achievement achieverockmonster;

    public static void register() {
        achieve100bucks = new Achievement(
            "achievement.achieve100bucks",
            "achieve100bucks",
            0,
            0,
            CREEPSItemBlocks.money,
            null).registerStat()
                .setSpecial();

        achieve500bucks = new Achievement(
            "achievement.achieve500bucks",
            "achieve500bucks",
            1,
            0,
            CREEPSItemBlocks.money,
            achieve100bucks).registerStat()
                .setSpecial();

        achieve1000bucks = new Achievement(
            "achievement.achieve1000bucks",
            "achieve1000bucks",
            2,
            0,
            CREEPSItemBlocks.money,
            achieve500bucks).registerStat()
                .setSpecial();

        achieveram128 = new Achievement(
            "achievement.achieveram128",
            "achieveram128",
            0,
            1,
            CREEPSItemBlocks.ram16k,
            null).registerStat()
                .setSpecial();

        achieveram512 = new Achievement(
            "achievement.achieveram512",
            "achieveram512",
            1,
            1,
            CREEPSItemBlocks.ram16k,
            achieveram128).registerStat()
                .setSpecial();

        achieveram1024 = new Achievement(
            "achievement.achieveram1024",
            "achieveram1024",
            2,
            1,
            CREEPSItemBlocks.ram16k,
            achieveram512).registerStat()
                .setSpecial();

        achievesnowtiny = new Achievement("achievement.achievesnowtiny", "achievesnowtiny", 0, 3, Items.snowball, null)
            .registerStat()
            .setSpecial();

        achievesnowtall = new Achievement("achievement.achievesnowtall", "achievesnowtall", 1, 3, Items.snowball, null)
            .registerStat()
            .setSpecial();

        achievesnow = new Achievement("achievement.achievesnow", "achievesnow", 2, 3, Items.snowball, null)
            .registerStat()
            .setSpecial();

        achieverockmonster = new Achievement(
            "achievement.achieverockmonster",
            "achieverockmonster",
            0,
            4,
            Item.getItemFromBlock(Blocks.cobblestone),
            null).registerStat()
                .setSpecial();

        creepsPage = new AchievementPage(
            "More Creeps",
            achieve100bucks,
            achieve500bucks,
            achieve1000bucks,
            achieveram128,
            achieveram512,
            achieveram1024,
            achievesnowtiny,
            achievesnow,
            achievesnowtall,
            achieverockmonster);

        AchievementPage.registerAchievementPage(creepsPage);
    }

}
