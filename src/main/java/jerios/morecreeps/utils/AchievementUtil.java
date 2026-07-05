package jerios.morecreeps.utils;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.stats.Achievement;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import jerios.morecreeps.entity.nonLiving.EntityTrophy;

public class AchievementUtil {

    public static void givePlayerAchievement(EntityPlayer player, Achievement achievement) {

        if (player instanceof EntityPlayerMP) {
            EntityPlayerMP playerMP = (EntityPlayerMP) player;
            if (!playerMP.func_147099_x()
                .hasAchievementUnlocked(achievement)) {
                player.worldObj.playSoundAtEntity(
                    player,
                    "morecreeps:Achievement",
                    1.0F,
                    (player.worldObj.rand.nextFloat() - player.worldObj.rand.nextFloat()) * 0.2F + 1.0F);
                spawnTrophy(player, player.worldObj);
                player.triggerAchievement(achievement);
            }
        }
    }

    public static void spawnTrophy(EntityPlayer entityplayer, World world) {
        double xHeading = -MathHelper.sin(entityplayer.rotationYaw * 3.141593F / 180.0F);
        double zHeading = MathHelper.cos(entityplayer.rotationYaw * 3.141593F / 180.0F);
        EntityTrophy entityTrophy = new EntityTrophy(world);
        entityTrophy.setLocationAndAngles(
            entityplayer.posX + xHeading * 3.0,
            entityplayer.posY + world.rand.nextInt(2),
            entityplayer.posZ + zHeading * 3.0,
            entityplayer.rotationYaw,
            0.0F);
        world.spawnEntityInWorld(entityTrophy);
    }

}
