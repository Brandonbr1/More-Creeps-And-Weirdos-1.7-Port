package jerios.morecreeps.item.throwables;

import jerios.morecreeps.entity.nonLiving.EntityGooDonut;
import jerios.morecreeps.item.base.CREEPSItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemGooDonut extends CREEPSItem {
    public ItemGooDonut() {
        super("gooDonut");
        this.setMaxStackSize(16);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer player) {
        worldIn.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (Item.itemRand.nextFloat() * 0.4F + 0.8F));
        itemStackIn.stackSize--;
        worldIn.spawnEntityInWorld(new EntityGooDonut(worldIn, player));

        return super.onItemRightClick(itemStackIn, worldIn, player);
    }
}
