package jerios.morecreeps.client.GMob;

import jerios.morecreeps.client.CreepsBaseLivingRender;
import jerios.morecreeps.entity.agressive.GEntity;
import jerios.morecreeps.utils.ResourceLocationUtils;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderGMob extends CreepsBaseLivingRender {


    public RenderGMob() {
        super(new ModelGMob(), 0.5f);
    }

    protected ResourceLocation getEntityTexture(GEntity entity) {
        return ResourceLocationUtils.makeResourceLocationEntityHostile("G_entity");
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        return getEntityTexture((GEntity)entity);
    }


    protected void preRenderCallback(GEntity mob, float size) {
        GL11.glScalef(mob.getModelSize(), mob.getModelSize(), mob.getModelSize());
    }

    @Override
    protected void preRenderCallback(EntityLivingBase mob, float size) {
        super.preRenderCallback(mob, size);
        this.preRenderCallback((GEntity) mob, size);

    }
}
