package jerios.morecreeps.client.evilLight;

import jerios.morecreeps.client.CREEPSBaseLivingRender;
import jerios.morecreeps.entity.agressive.EvilLight;
import jerios.morecreeps.entity.agressive.EvilPigEntity;
import jerios.morecreeps.utils.ResourceLocationUtils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderEvilLight extends CREEPSBaseLivingRender {

    private static final ResourceLocation TEXTURE = ResourceLocationUtils.makeResourceLocationEntityHostile("evillight1");
    private static final ResourceLocation RENDER_EFFECT = ResourceLocationUtils.makeResourceLocationEntityHostile("evillightglow");

    public RenderEvilLight() {
        super(new ModelEvilLight(), 0.0f);
        this.shadowSize = 0.0F;
        this.setRenderPassModel(new ModelEvilLight());
    }


    @Override
    protected void preRenderCallback(EntityLivingBase p_77041_1_, float p_77041_2_) {
        super.preRenderCallback(p_77041_1_, p_77041_2_);
    //    GL11.glScalef(4.0F, 3.0F, 4.0F);
    }

    protected int glow(EvilLight entityevillight, int i, float f) {

        if (i != 0) {
            return -1;
        }

        this.bindTexture(RENDER_EFFECT);
       float f1 = (1.0F - entityevillight.getBrightness(1.0F)) * 0.5F;
        GL11.glEnable(GL11.GL_BLEND);
      //  GL11.glDisable(GL11.GL_ALPHA_TEST);
        GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, f1);


        return 1;
    }

    @Override
    protected int shouldRenderPass(EntityLivingBase livingBase, int i, float f) {
        return this.glow((EvilLight)livingBase, i, f);
    }

    protected ResourceLocation getEntityTexture(EvilLight entity) {
        return TEXTURE;
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        return getEntityTexture((EvilLight) entity);
    }
}
