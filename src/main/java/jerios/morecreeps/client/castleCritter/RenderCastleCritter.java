package jerios.morecreeps.client.castleCritter;

import jerios.morecreeps.client.CREEPSBaseLivingRender;
import jerios.morecreeps.entity.agressive.CastleCritterEntity;
import jerios.morecreeps.utils.ResourceLocationUtils;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderCastleCritter extends CREEPSBaseLivingRender {

    public RenderCastleCritter() {
        super(new ModelCastleCritter(), 0.5f);
    }

    protected void preRenderCallback(CastleCritterEntity mob) {
        GL11.glScalef(mob.getModelSize(), mob.getModelSize(), mob.getModelSize());
    }

    @Override
    protected void preRenderCallback(EntityLivingBase p_77041_1_, float p_77041_2_) {
        super.preRenderCallback(p_77041_1_, p_77041_2_);
        preRenderCallback((CastleCritterEntity)p_77041_1_);
    }

    protected int eyeGlow(CastleCritterEntity entitycastlecritter, int i, float f) {
        if (i != 0) {
            return -1;
        }

        this.bindTexture(ResourceLocationUtils.makeResourceLocationEntityHostile("castlecritterglow"));
        float f1 = (1.0F - entitycastlecritter.getBrightness(1.0F)) * 0.5F;
        GL11.glEnable(3042);
        GL11.glDisable(3008);
        GL11.glBlendFunc(770, 771);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, f1);
        return 1;
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
        return ResourceLocationUtils.makeResourceLocationEntityHostile("castlecritter");
    }

    @Override
    protected int shouldRenderPass(EntityLivingBase p_77032_1_, int p_77032_2_, float p_77032_3_) {
        return super.shouldRenderPass(p_77032_1_, p_77032_2_, p_77032_3_);
    }
}
