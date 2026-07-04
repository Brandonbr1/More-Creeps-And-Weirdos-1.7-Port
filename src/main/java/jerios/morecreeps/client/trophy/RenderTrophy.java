package jerios.morecreeps.client.trophy;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import jerios.morecreeps.client.CREEPSBaseLivingRender;
import jerios.morecreeps.entity.nonLiving.TrophyEntity;
import jerios.morecreeps.utils.ResourceLocationUtils;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderTrophy extends Render {

    private static final ResourceLocation TEXTURE = ResourceLocationUtils.makeResourceLocationEntityPeaceful("trophy");
    private ModelBase model;

    public RenderTrophy() {
        this.shadowSize = 0.5F;
        this.model = new ModelTrophy();
    }

    @Override
    public void doRender(Entity entity, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
        this.doRender((TrophyEntity)entity, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }

    public void doRender(TrophyEntity trophyEntity, double f1, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_)
    {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)f1, (float)p_76986_4_, (float)p_76986_6_);
        this.bindEntityTexture(trophyEntity);

        this.model.render(trophyEntity, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);

        GL11.glPopMatrix();
    }


    protected ResourceLocation getEntityTexture(TrophyEntity p_110775_1_) {
        return TEXTURE;
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        return getEntityTexture((TrophyEntity) entity);
    }
}
