package jerios.morecreeps.item.throwables;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import jerios.morecreeps.item.base.CREEPSItem;

public class ItemMoney extends CREEPSItem {

    public ItemMoney() {
        super("money");
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer player) {
        if (!player.capabilities.isCreativeMode) {
            itemStackIn.stackSize--;
        }
        worldIn.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (Item.itemRand.nextFloat() * 0.4F + 0.8F));
        // worldIn.spawnEntityInWorld(new EntityGooDonut(worldIn, player));

        return super.onItemRightClick(itemStackIn, worldIn, player);
    }
}
