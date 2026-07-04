package jerios.morecreeps.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import jerios.morecreeps.CREEPSConstants;
import jerios.morecreeps.registry.CREEPSItemBlocks;
import jerios.morecreeps.registry.TabsManager;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.Facing;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import java.util.List;

public class ItemMonsterSpawner extends ItemBlock {
    public ItemMonsterSpawner(Block block) {
        super(block);
        this.setHasSubtypes(true);
        this.setCreativeTab(TabsManager.SPAWN_EGG_TAB);
    }

    @Override
    public String getItemStackDisplayName(ItemStack p_77653_1_) {
        String s = (StatCollector.translateToLocal(this.getUnlocalizedName() + ".name")).trim();
        String s1 = CreepSpawnEggItem.INTEGER_STRING_MAP.get(p_77653_1_.getItemDamage());

        if (s1 != null) {
            s = s + " " + StatCollector.translateToLocal("entity." + s1 + ".name");
        }

        return s;
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int facing, float unknown, float unkown2, float unkown3) {

        if (!world.isRemote) {
            x += Facing.offsetsXForSide[facing];
            y += Facing.offsetsYForSide[facing];
            z += Facing.offsetsZForSide[facing];

            world.setBlock(x, y, z, Blocks.mob_spawner, 0, 2);

            TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner)world.getTileEntity(x, y, z);

            if (tileentitymobspawner != null)
            {
                String name = CreepSpawnEggItem.STRING_ID_MAP.get(stack.getItemDamage());
                if (name != null) {
                    tileentitymobspawner.func_145881_a().setEntityName(name);
                } else {
                    System.out.println("YOOOOO " + stack.getItemDamage());
                    System.out.println(CreepSpawnEggItem.STRING_ID_MAP.keySet());
                }
            }

            if (!player.capabilities.isCreativeMode) {
                --stack.stackSize;
            }

        }

        return true;
    }


    @SideOnly(Side.CLIENT)
    @Override
    public void getSubItems(Item item, CreativeTabs tab, List<ItemStack> stacks) {
        super.getSubItems(item, tab, stacks);
        for (CreepSpawnEggItem.EGGSpots entityegginfo : CreepSpawnEggItem.INTEGER_COLOR_MAP.values()) {
            stacks.add(new ItemStack(item, 1, entityegginfo.id));
        }

    }
}
