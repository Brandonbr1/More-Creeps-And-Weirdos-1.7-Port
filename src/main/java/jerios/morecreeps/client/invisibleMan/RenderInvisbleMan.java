package jerios.morecreeps.client.invisibleMan;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import jerios.morecreeps.client.CREEPSBaseLivingRender;
import jerios.morecreeps.entity.agressive.GEntity;
import jerios.morecreeps.entity.netural.InvisibleManEntity;
import jerios.morecreeps.utils.ResourceLocationUtils;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderInvisbleMan extends RenderBiped {

    public RenderInvisbleMan() {
        super(new ModelBiped(), 0.5f);
    }

    protected ResourceLocation getEntityTexture(InvisibleManEntity entity) {
        return ResourceLocationUtils.makeResourceLocationEntityHostile(entity.getTexture());
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        return getEntityTexture((InvisibleManEntity) entity);
    }

}
