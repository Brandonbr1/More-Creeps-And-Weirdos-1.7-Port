package jerios.morecreeps.item.misc;

import jerios.morecreeps.MoreCreeps;
import jerios.morecreeps.item.base.CREEPSItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BatteryItem extends CREEPSItem {
    public BatteryItem() {
        super("battery");
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer player) {
        worldIn.playSoundAtEntity(player, "morecreeps:Spark", 1.0F, 1.0F);
            player.attackEntityFrom(MoreCreeps.DAMAGESOURCE_TAZED, 1.0f);

        return super.onItemRightClick(itemStackIn, worldIn, player);
    }
}
