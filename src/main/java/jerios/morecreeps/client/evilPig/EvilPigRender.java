package jerios.morecreeps.client.evilPig;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import jerios.morecreeps.client.CREEPSBaseLivingRender;
import jerios.morecreeps.entity.agressive.EvilPigEntity;
import jerios.morecreeps.utils.ResourceLocationUtils;

@SideOnly(Side.CLIENT)
public class EvilPigRender extends CREEPSBaseLivingRender {

    public EvilPigRender() {
        super(new ModelEvilPig(), 0.5f);
        this.setRenderPassModel(new ModelEvilPig());
    }

    protected ResourceLocation getEntityTexture(EvilPigEntity entity) {
        return ResourceLocationUtils.makeResourceLocationEntityHostile("evilpig");
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        return getEntityTexture((EvilPigEntity) entity);
    }

    protected void preRenderCallback(EvilPigEntity mob, float size) {
        GL11.glScalef(mob.getModelSize(), mob.getModelSize(), mob.getModelSize());
    }

    @Override
    protected void preRenderCallback(EntityLivingBase mob, float size) {
        super.preRenderCallback(mob, size);
        this.preRenderCallback((EvilPigEntity) mob, size);

    }
}
