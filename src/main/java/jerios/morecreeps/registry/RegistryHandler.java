package jerios.morecreeps.registry;

import jerios.morecreeps.item.ItemCreepSpawnEgg;
import jerios.morecreeps.networking.CREEPSPacketHandler;
import net.minecraft.block.BlockDispenser;
import net.minecraft.dispenser.BehaviorDefaultDispenseItem;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;

public class RegistryHandler {

    public static void registerPreInit() {
        CREEPSItemBlocks.registerItems();
        CREEPSMobs.registerMobs();
        CREEPSPacketHandler.registerPackets();
        registerDispenserBehaviour();
    }

    public static void registerInit() {
        AchievmentRegistry.register();
    }


    private static void registerDispenserBehaviour() {
        BlockDispenser.dispenseBehaviorRegistry.putObject(CREEPSItemBlocks.spawnEgg, new BehaviorDefaultDispenseItem()
        {
            public ItemStack dispenseStack(IBlockSource source, ItemStack stack)
            {
                EnumFacing enumfacing = BlockDispenser.func_149937_b(source.getBlockMetadata());
                double d0 = source.getX() + (double)enumfacing.getFrontOffsetX();
                double d1 = (float)source.getYInt() + 0.2F;
                double d2 = source.getZ() + (double)enumfacing.getFrontOffsetZ();
                Entity entity = ItemCreepSpawnEgg.spawnCreature(source.getWorld(), stack.getItemDamage(), d0, d1, d2);

                if (entity instanceof EntityLivingBase && stack.hasDisplayName())
                {
                    ((EntityLiving)entity).setCustomNameTag(stack.getDisplayName());
                }

                stack.splitStack(1);
                return stack;
            }
        });

    }

}
