package jerios.morecreeps.client.evilSnowman;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import jerios.morecreeps.client.CREEPSBaseLivingRender;
import jerios.morecreeps.entity.agressive.EvilSnowmanEntity;
import jerios.morecreeps.utils.ResourceLocationUtils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderEvilSnowman extends CREEPSBaseLivingRender {

    public RenderEvilSnowman() {
        super(new ModelEvilSnowman(), 0.5f);
    }

    protected void preRenderCallback(EvilSnowmanEntity mob) {
        this.shadowSize = mob.getModelSize() * 0.5f;
        GL11.glScalef(mob.getModelSize(), mob.getModelSize(), mob.getModelSize());
    }

    @Override
    protected void preRenderCallback(EntityLivingBase mob, float size) {
        super.preRenderCallback(mob, size);
        this.preRenderCallback((EvilSnowmanEntity)mob);
    }

    protected ResourceLocation getEntityTexture(EvilSnowmanEntity entity) {
        return ResourceLocationUtils.makeResourceLocationEntityHostile("evilsnowman");
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        return getEntityTexture((EvilSnowmanEntity) entity);
    }

}
