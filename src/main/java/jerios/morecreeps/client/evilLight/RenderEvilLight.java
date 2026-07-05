package jerios.morecreeps.client.evilLight;

import jerios.morecreeps.client.CREEPSBaseLivingRender;
import jerios.morecreeps.entity.agressive.EvilLight;
import jerios.morecreeps.entity.agressive.EvilPigEntity;
import jerios.morecreeps.utils.ResourceLocationUtils;
import net.minecraft.client.renderer.OpenGlHelper;
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


  /**  protected int glow(EvilLight entityevillight, int i, float f) {
        if (i != 0) {
            return -1;
        }

        if (i != 0) {
            return -1;
        }

        this.bindTexture(RENDER_EFFECT);
        float f1 = (1.0F - entityevillight.getBrightness(1.0F)) * 0.5F;
        GL11.glEnable(3042);
        GL11.glBlendFunc(1, 771);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, f1);
        return 1;
    }**/

 /**   @Override
    protected int shouldRenderPass(EntityLivingBase livingBase, int i, float f) {
        return this.glow((EvilLight)livingBase, i, f);
    }
  **/


    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        return TEXTURE;
    }
}
