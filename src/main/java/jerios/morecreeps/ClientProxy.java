package jerios.morecreeps;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import jerios.morecreeps.client.GMob.RenderGMob;
import jerios.morecreeps.client.fx.ConfettiFX;
import jerios.morecreeps.entity.agressive.GEntity;
import jerios.morecreeps.entity.nonLiving.TrophyEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;

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

    public void spawnConfettiTrophyA(TrophyEntity trophyEntity) {
        if (trophyEntity == null) return;
        if (trophyEntity.worldObj == null) return;
        if (trophyEntity.worldObj.isRemote) return;



        for (int i = 1; i < 10; i++) {
            for (int ii = 0; ii < 10; ii++) {

                ConfettiFX particle = new ConfettiFX(
                    trophyEntity.worldObj,
                    trophyEntity.posX + (double)(trophyEntity.worldObj.rand.nextFloat() * 8F - trophyEntity.worldObj.rand.nextFloat() * 8F), trophyEntity.posY + (double)trophyEntity.worldObj.rand.nextInt(4) + 4D, trophyEntity.posZ + (double)(trophyEntity.worldObj.rand.nextFloat() * 8F - trophyEntity.worldObj.rand.nextFloat() * 8F));

                if (mc != null) {
                    particle.renderDistanceWeight = 30.0;
                    mc.effectRenderer.addEffect(particle);
                }


            }
        }

    }
}
