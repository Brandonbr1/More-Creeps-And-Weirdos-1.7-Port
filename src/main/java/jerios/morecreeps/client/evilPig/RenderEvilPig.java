package jerios.morecreeps.client.evilPig;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import jerios.morecreeps.client.CREEPSBaseLivingRender;
import jerios.morecreeps.entity.agressive.EntityEvilPig;
import jerios.morecreeps.utils.ResourceLocationUtils;

@SideOnly(Side.CLIENT)
public class RenderEvilPig extends CREEPSBaseLivingRender {

    public RenderEvilPig() {
        super(new ModelEvilPig(), 0.5f);
        this.setRenderPassModel(new ModelEvilPig());
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        return ResourceLocationUtils.makeResourceLocationEntityHostile("evilpig");
    }

    protected void preRenderCallback(EntityEvilPig mob, float size) {
        GL11.glScalef(mob.getModelSize(), mob.getModelSize(), mob.getModelSize());
    }

    @Override
    protected void preRenderCallback(EntityLivingBase mob, float size) {
        super.preRenderCallback(mob, size);
        this.preRenderCallback((EntityEvilPig) mob, size);

    }
}
