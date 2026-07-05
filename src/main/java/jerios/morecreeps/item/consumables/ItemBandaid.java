package jerios.morecreeps.item.consumables;

import jerios.morecreeps.item.base.CREEPSItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.Random;

public class ItemBandaid extends CREEPSItem {

    private static final int HEAL_AMM = 4;

    public ItemBandaid() {
        super("bandAid");
        this.setMaxStackSize(24);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer player) {
        worldIn.playSoundAtEntity(player, "morecreeps:BandAid", 1.0F, 1.0F);

        boolean HPIsNotFull = player.getHealth() < 20;

        if (HPIsNotFull) {

            if (!worldIn.isRemote) {
                player.heal(HEAL_AMM);
            }

            itemStackIn.stackSize--;
            player.swingItem();

        }

        return super.onItemRightClick(itemStackIn, worldIn, player);
    }
}
