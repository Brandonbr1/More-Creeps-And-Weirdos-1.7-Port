package jerios.morecreeps.client.fx;

import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.World;

public class CREEPSFX extends EntityFX {

    public CREEPSFX(World p_i1218_1_, double p_i1218_2_, double p_i1218_4_, double p_i1218_6_) {
        super(p_i1218_1_, p_i1218_2_, p_i1218_4_, p_i1218_6_);
    }

    public CREEPSFX(World world, double x, double y, double z, boolean signatureTrick) {
        super(world, x, y, z, 0, 0, 0);
    }

    @Override
    public int getFXLayer() {
        return 2;
    }

    // remove check, allows it to be on the same layer as original more creeps.
    @Override
    public void setParticleTextureIndex(int p_70536_1_) {
        this.particleTextureIndexX = p_70536_1_ % 16;
        this.particleTextureIndexY = p_70536_1_ / 16;
    }

    @Override
    public void renderParticle(Tessellator tessellator, float p_70539_2_, float p_70539_3_, float p_70539_4_,
        float p_70539_5_, float p_70539_6_, float p_70539_7_) {
        float f6 = (this.particleTextureIndexX + this.particleTextureJitterX / 14.0F) / 16.0F;
        float f7 = f6 + 0.01560938F;
        float f8 = (this.particleTextureIndexY + this.particleTextureJitterY / 14.0F) / 16.0F;
        float f9 = f8 + 0.01560938F;
        float f10 = 0.1F * this.particleScale;

        float f11 = (float) (this.prevPosX + (this.posX - this.prevPosX) * (double) p_70539_2_ - interpPosX);
        float f12 = (float) (this.prevPosY + (this.posY - this.prevPosY) * (double) p_70539_2_ - interpPosY);
        float f13 = (float) (this.prevPosZ + (this.posZ - this.prevPosZ) * (double) p_70539_2_ - interpPosZ);
        float f14 = this.getBrightness(p_70539_2_);
        tessellator.setColorOpaque_F(f14 * this.particleRed, f14 * this.particleGreen, f14 * this.particleBlue);
        // tessellator.setColorRGBA_F(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha);
        tessellator.addVertexWithUV(
            (double) (f11 - p_70539_3_ * f10 - p_70539_6_ * f10),
            (double) (f12 - p_70539_4_ * f10),
            (double) (f13 - p_70539_5_ * f10 - p_70539_7_ * f10),
            (double) f7,
            (double) f9);
        tessellator.addVertexWithUV(
            (double) (f11 - p_70539_3_ * f10 + p_70539_6_ * f10),
            (double) (f12 + p_70539_4_ * f10),
            (double) (f13 - p_70539_5_ * f10 + p_70539_7_ * f10),
            (double) f7,
            (double) f8);
        tessellator.addVertexWithUV(
            (double) (f11 + p_70539_3_ * f10 + p_70539_6_ * f10),
            (double) (f12 + p_70539_4_ * f10),
            (double) (f13 + p_70539_5_ * f10 + p_70539_7_ * f10),
            (double) f6,
            (double) f8);
        tessellator.addVertexWithUV(
            (double) (f11 + p_70539_3_ * f10 - p_70539_6_ * f10),
            (double) (f12 - p_70539_4_ * f10),
            (double) (f13 + p_70539_5_ * f10 - p_70539_7_ * f10),
            (double) f6,
            (double) f9);
    }
}
