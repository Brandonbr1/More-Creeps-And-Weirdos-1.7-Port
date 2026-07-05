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
import jerios.morecreeps.client.castleCritter.RenderCastleCritter;
import jerios.morecreeps.client.evilCreature.RenderEvilCreature;
import jerios.morecreeps.client.evilLight.RenderEvilLight;
import jerios.morecreeps.client.evilPig.RenderEvilPig;
import jerios.morecreeps.client.evilSnowman.RenderEvilSnowman;
import jerios.morecreeps.client.fx.ConfettiFX;
import jerios.morecreeps.client.invisibleMan.RenderInvisbleMan;
import jerios.morecreeps.client.trophy.RenderTrophy;
import jerios.morecreeps.entity.agressive.*;
import jerios.morecreeps.entity.netural.EntityInvisibleMan;
import jerios.morecreeps.entity.nonLiving.EntityTrophy;

public class ClientProxy extends CommonProxy {

    Minecraft mc = FMLClientHandler.instance()
        .getClient();

    @Override
    public void clientProxy() {
        registerMobs();
        registerThrowable();
    }

    private void registerMobs() {
        renderEntity(EntityG.class, new RenderGMob());
        renderEntity(EntityTrophy.class, new RenderTrophy());
        renderEntity(EntityEvilCreature.class, new RenderEvilCreature());
        renderEntity(EntityEvilPig.class, new RenderEvilPig());
        renderEntity(EntityEvilLight.class, new RenderEvilLight());
        renderEntity(EvilSnowmanEntity.class, new RenderEvilSnowman());
        renderEntity(EntityInvisibleMan.class, new RenderInvisbleMan());
        renderEntity(EntityCastleCritter.class, new RenderCastleCritter());
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
