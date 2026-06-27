package jerios.morecreeps;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import jerios.morecreeps.client.GMob.RenderGMob;
import jerios.morecreeps.client.fx.ConfettiFX;
import jerios.morecreeps.debug.CREEPSLogger;
import jerios.morecreeps.entity.agressive.GEntity;
import jerios.morecreeps.entity.nonLiving.TrophyEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class ClientProxy extends CommonProxy {

    Minecraft mc = FMLClientHandler.instance().getClient();

    @Override
    public void clientProxy() {
        registerMobs();
        registerThrowable();
    }

    private void registerMobs() {
        renderEntity(GEntity.class, new RenderGMob());
    }

    private void registerThrowable() {
    }

    private void renderEntity(Class<? extends Entity> clazz, Render render) {
        RenderingRegistry.registerEntityRenderingHandler(clazz, render);
    }

    private void render2D(Class<? extends Entity> clazz, Item item) {
        renderEntity(clazz, new RenderSnowball(item));
    }

    public void spawnConfettiTrophyA(Entity trophyEntity) {
        if (trophyEntity == null) return;
        if (trophyEntity.worldObj == null) return;

        World world = trophyEntity.worldObj;

        CREEPSLogger.error("ON CLIENT PROY" + world.isRemote);

        for (int i = 1; i < 10; i++) {
            for (int ii = 0; ii < 10; ii++) {

                ConfettiFX particle = new ConfettiFX(
                    world,
                    trophyEntity.posX + (world.rand.nextFloat() * 8.0F - world.rand.nextFloat() * 8.0F),
                    trophyEntity.posY + world.rand.nextInt(4) + 4.0,
                    trophyEntity.posZ + (world.rand.nextFloat() * 8.0F - world.rand.nextFloat() * 8.0F)
                );

                if (mc != null) {
                    mc.effectRenderer.addEffect(particle);
                }


            }
        }

    }
}
