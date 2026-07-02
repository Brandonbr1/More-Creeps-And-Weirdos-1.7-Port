package jerios.morecreeps;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.world.World;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import jerios.morecreeps.client.GMob.RenderGMob;
import jerios.morecreeps.client.evilCreature.EvilCreatureRender;
import jerios.morecreeps.client.evilPig.EvilPigRender;
import jerios.morecreeps.client.fx.ConfettiFX;
import jerios.morecreeps.entity.agressive.EvilCreatureEntity;
import jerios.morecreeps.entity.agressive.EvilPigEntity;
import jerios.morecreeps.entity.agressive.GEntity;

public class ClientProxy extends CommonProxy {

    Minecraft mc = FMLClientHandler.instance()
        .getClient();

    @Override
    public void clientProxy() {
        registerMobs();
        registerThrowable();
    }

    private void registerMobs() {
        renderEntity(GEntity.class, new RenderGMob());
        renderEntity(EvilCreatureEntity.class, new EvilCreatureRender());
        renderEntity(EvilPigEntity.class, new EvilPigRender());
    }

    private void registerThrowable() {}

    private void renderEntity(Class<? extends Entity> clazz, Render render) {
        RenderingRegistry.registerEntityRenderingHandler(clazz, render);
    }

    private void render2D(Class<? extends Entity> clazz, Item item) {
        renderEntity(clazz, new RenderSnowball(item));
    }

    @Override
    public void spawnConfettiTrophyA(World world, double x, double y, double z) {
        if (world == null || !world.isRemote || mc == null || mc.effectRenderer == null) return;

        for (int i = 1; i < 10; i++) {
            for (int ii = 0; ii < 10; ii++) {

                ConfettiFX particle = new ConfettiFX(
                    world,
                    x + (world.rand.nextFloat() * 8.0F - world.rand.nextFloat() * 8.0F),
                    y + world.rand.nextInt(4) + 4.0,
                    z + (world.rand.nextFloat() * 8.0F - world.rand.nextFloat() * 8.0F));

                mc.effectRenderer.addEffect(particle);

            }
        }

    }
}
