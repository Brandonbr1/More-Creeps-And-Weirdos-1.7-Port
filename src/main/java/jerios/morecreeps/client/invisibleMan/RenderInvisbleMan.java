package jerios.morecreeps.client.invisibleMan;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import jerios.morecreeps.entity.netural.EntityInvisibleMan;
import jerios.morecreeps.utils.ResourceLocationUtils;

@SideOnly(Side.CLIENT)
public class RenderInvisbleMan extends RenderBiped {

    public RenderInvisbleMan() {
        super(new ModelBiped(), 0.5f);
    }

    protected ResourceLocation getEntityTexture(EntityInvisibleMan entity) {
        return ResourceLocationUtils.makeResourceLocationEntityHostile(entity.getTexture());
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        return getEntityTexture((EntityInvisibleMan) entity);
    }

}
