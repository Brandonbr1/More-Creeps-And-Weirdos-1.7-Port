package jerios.morecreeps.item.consumables;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import jerios.morecreeps.item.base.ItemsCREEPS;

public class BandaidItems extends ItemsCREEPS {

    private static final int HEAL_AMM = 4;

    public BandaidItems() {
        super("band_aid");
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
