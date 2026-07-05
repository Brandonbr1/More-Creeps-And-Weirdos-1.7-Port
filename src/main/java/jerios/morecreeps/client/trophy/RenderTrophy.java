package jerios.morecreeps.client.trophy;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import jerios.morecreeps.entity.nonLiving.EntityTrophy;
import jerios.morecreeps.utils.ResourceLocationUtils;

@SideOnly(Side.CLIENT)
public class RenderTrophy extends Render {

    private static final ResourceLocation TEXTURE = ResourceLocationUtils.makeResourceLocationEntityPeaceful("trophy");
    private ModelBase model;

    public RenderTrophy() {
        this.shadowSize = 0.5F;
        this.model = new ModelTrophy();
    }

    @Override
    public void doRender(Entity entity, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_,
        float p_76986_9_) {
        this.doRender((EntityTrophy) entity, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }

    public void doRender(EntityTrophy entityTrophy, double f1, double p_76986_4_, double p_76986_6_, float p_76986_8_,
        float p_76986_9_) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float) f1, (float) p_76986_4_, (float) p_76986_6_);
        GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
        this.bindTexture(TEXTURE);

        this.model.render(entityTrophy, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);

        GL11.glPopMatrix();
    }

    protected ResourceLocation getEntityTexture(EntityTrophy p_110775_1_) {
        return TEXTURE;
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        return getEntityTexture((EntityTrophy) entity);
    }
}
