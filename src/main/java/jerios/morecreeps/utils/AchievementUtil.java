package jerios.morecreeps.utils;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.stats.Achievement;

public class AchievementUtil {

    public static void givePlayerAchievement(EntityPlayer player, Achievement achievement) {

       if (player instanceof EntityPlayerMP) {
           EntityPlayerMP p = (EntityPlayerMP) player;
            boolean hasAch = p.func_147099_x().hasAchievementUnlocked(achievement);

          if (!hasAch) {
              player.worldObj.playSoundAtEntity(
                  player,
                  "morecreeps:Achievement",
                  1.0F,
                  (player.worldObj.rand.nextFloat() - player.worldObj.rand.nextFloat()) * 0.2F + 1.0F);

          }
       }

        player.triggerAchievement(achievement);
    }

    public static void givePlayerAchievement2(EntityPlayer player, Entity originalEntity, Achievement achievement) {
        if (player instanceof EntityPlayerMP) {
            EntityPlayerMP p = (EntityPlayerMP) player;
            boolean hasAch = p.func_147099_x().hasAchievementUnlocked(achievement);

            if (!hasAch) {
                player.worldObj.playSoundAtEntity(
                    originalEntity,
                    "morecreeps:Achievement",
                    1.0F,
                    (originalEntity.worldObj.rand.nextFloat() - originalEntity.worldObj.rand.nextFloat()) * 0.2F + 1.0F);
            }

        }
        player.triggerAchievement(achievement);
    }


}
