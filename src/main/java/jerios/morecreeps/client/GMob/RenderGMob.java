package jerios.morecreeps.client.GMob;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import jerios.morecreeps.client.CREEPSBaseLivingRender;
import jerios.morecreeps.entity.agressive.EntityG;
import jerios.morecreeps.utils.ResourceLocationUtils;

@SideOnly(Side.CLIENT)
public class RenderGMob extends CREEPSBaseLivingRender {

    public RenderGMob() {
        super(new ModelGMob(), 0.5f);
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        return ResourceLocationUtils.makeResourceLocationEntityHostile("GEntity");
    }

    protected void preRenderCallback(EntityG mob, float size) {
        GL11.glScalef(mob.getModelSize(), mob.getModelSize(), mob.getModelSize());
    }

    @Override
    protected void preRenderCallback(EntityLivingBase mob, float size) {
        super.preRenderCallback(mob, size);
        this.preRenderCallback((EntityG) mob, size);

    }
}
