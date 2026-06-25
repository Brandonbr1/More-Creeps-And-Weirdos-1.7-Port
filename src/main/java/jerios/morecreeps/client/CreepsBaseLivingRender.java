package jerios.morecreeps.client;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class CreepsBaseLivingRender extends RenderLiving {
    public CreepsBaseLivingRender(ModelBase modelBase, float shadow) {
        super(modelBase, shadow);
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
        return null;
    }
}
