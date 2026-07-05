package jerios.morecreeps.item;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockCREEPSSpawner extends Block {

    public BlockCREEPSSpawner() {
        super(Material.ground);
        this.setBlockName("mobSpawner");
        this.disableStats();
        this.setBlockTextureName("mob_spawner");
    }
}
