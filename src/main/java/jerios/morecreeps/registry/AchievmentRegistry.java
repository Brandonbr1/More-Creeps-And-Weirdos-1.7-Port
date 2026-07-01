package jerios.morecreeps.registry;

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

    public static void register() {
        achieve100bucks = new Achievement(
            "achievement.achieve100bucks",
            "achieve100bucks",
            0,
            0,
            CREEPSItemBlocks.money,
            null).registerStat().setSpecial();

        achieve500bucks = new Achievement(
            "achievement.achieve500bucks",
            "achieve500bucks",
            1,
            0,
            CREEPSItemBlocks.money,
            achieve100bucks).registerStat();

        achieve1000bucks = new Achievement(
            "achievement.achieve1000bucks",
            "achieve1000bucks",
            2,
            0,
            CREEPSItemBlocks.money,
            achieve500bucks).registerStat();

        achieveram128 = new Achievement(
            "achievement.achieveram128",
            "achieveram128",
            0,
            1,
            CREEPSItemBlocks.money,
            null).registerStat();

        achieveram512 = new Achievement(
            "achievement.achieveram512",
            "achieveram512",
            1,
            1,
            CREEPSItemBlocks.money,
            achieveram128).registerStat();

        achieveram1024 = new Achievement(
            "achievement.achieveram1024",
            "achieveram1024",
            2,
            1,
            CREEPSItemBlocks.money,
            achieveram512).registerStat();

        creepsPage = new AchievementPage(
            "More Creeps",
            achieve100bucks,
            achieve500bucks,
            achieve1000bucks,
            achieveram128,
            achieveram512,
            achieveram1024);

        AchievementPage.registerAchievementPage(creepsPage);
    }

}
