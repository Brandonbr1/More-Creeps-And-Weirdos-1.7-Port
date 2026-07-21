package jerios.morecreeps.command;

import jerios.morecreeps.item.ItemCreepSpawnEgg;
import net.minecraft.command.server.CommandSummon;

public class CommandCreepsSummon extends CommandSummon {

    @Override
    public String getCommandName()
    {
        return "summonCreep";
    }

    @Override
    protected String[] func_147182_d() {
        return (String[]) ItemCreepSpawnEgg.func_151515_b().toArray(new String[0]);
    }
}
