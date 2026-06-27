package jerios.morecreeps;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import jerios.morecreeps.client.GMob.RenderGMob;
import jerios.morecreeps.entity.agressive.GEntity;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;

public class ClientProxy extends CommonProxy {

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

    public void spawnParticle() {

    }
}
