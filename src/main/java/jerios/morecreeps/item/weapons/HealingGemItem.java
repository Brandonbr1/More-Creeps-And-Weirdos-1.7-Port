package jerios.morecreeps.item.weapons;

import jerios.morecreeps.MoreCreeps;
import jerios.morecreeps.item.base.CREEPSItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.Random;

public class HealingGemItem extends CREEPSItem {

    private static final int HEAL_AMM = 5;

    public HealingGemItem() {
        super("healingGem");
        setMaxDamage(16);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer player) {
        worldIn.playSoundAtEntity(player, "morecreeps:healinggem", 1.0F, 1.0F);


        boolean HPIsNotFull = player.getHealth() < 20;
        Random rand = MoreCreeps.globalRandom;


        if (HPIsNotFull) {

            if (!worldIn.isRemote) {
                player.heal(HEAL_AMM);
            }


            itemStackIn.damageItem(1, player);
            player.swingItem();
            for (int i = 0; i < 20; i++) {
                double d = rand.nextGaussian() * 0.02;
                double d1 = rand.nextGaussian() * 0.02;
                double d2 = rand.nextGaussian() * 0.02;
                worldIn.spawnParticle(
                    "explode",
                    player.posX + rand.nextGaussian() * 0.5 - rand.nextGaussian() * 0.5,
                    player.posY - 0.5 + rand.nextGaussian() * 0.5 - rand.nextGaussian() * 0.5,
                    player.posZ + rand.nextGaussian() * 0.5 - rand.nextGaussian() * 0.5,
                    d,
                    d1,
                    d2
                );
                worldIn.spawnParticle(
                    "heart",
                    player.posX + rand.nextGaussian() * 0.5 - rand.nextGaussian() * 0.5,
                    player.posY - 0.5 + rand.nextGaussian() * 0.5 - rand.nextGaussian() * 0.5,
                    player.posZ + rand.nextGaussian() * 0.5 - rand.nextGaussian() * 0.5,
                    d,
                    d1,
                    d2
                );
            }

        }



        return super.onItemRightClick(itemStackIn, worldIn, player);
    }

}
