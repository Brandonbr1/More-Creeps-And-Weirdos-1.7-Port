package jerios.morecreeps.item.throwables;

import jerios.morecreeps.entity.nonLiving.EntityMoney;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import jerios.morecreeps.item.base.ItemsCREEPS;

public class MoneyItems extends ItemsCREEPS {

    public MoneyItems() {
        super("money");
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer player) {
        if (!player.capabilities.isCreativeMode) {
            itemStackIn.stackSize--;
        }
        worldIn.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (Item.itemRand.nextFloat() * 0.4F + 0.8F));
       // worldIn.spawnEntityInWorld(new EntityMoney(worldIn, player));

        return super.onItemRightClick(itemStackIn, worldIn, player);
    }
}
