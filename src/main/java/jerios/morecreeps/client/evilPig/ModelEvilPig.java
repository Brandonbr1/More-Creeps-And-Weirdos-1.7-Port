package jerios.morecreeps.client.evilPig;

import java.util.Random;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelEvilPig extends ModelBase {

    public static Random rand = new Random();
    public ModelRenderer body;
    public ModelRenderer headEvilpig;
    public ModelRenderer leg1;
    public ModelRenderer leg2;
    public ModelRenderer leg3;
    public ModelRenderer leg4;
    public ModelRenderer headEvilpig1;
    public ModelRenderer headEvilpig2;
    public ModelRenderer headEvilpig3;
    public ModelRenderer headEvilpig4;
    public ModelRenderer headEvilpig5;
    public int headEvilpigpop;

    public ModelEvilPig() {
        byte byte0 = 6;
        this.headEvilpig = new ModelRenderer(this, 0, 0);
        this.headEvilpig.addBox(-16.0F, -4.0F, -10.0F, 8, 8, 8);
        this.headEvilpig.setRotationPoint(0.0F, 23 - byte0, -6.0F);
        this.headEvilpig1 = new ModelRenderer(this, 0, 0);
        this.headEvilpig1.addBox(-4.0F, -4.0F, -13.0F, 8, 8, 8);
        this.headEvilpig1.setRotationPoint(0.0F, 23 - byte0, -6.0F);
        this.headEvilpig2 = new ModelRenderer(this, 0, 0);
        this.headEvilpig2.addBox(8.0F, -4.0F, -10.0F, 8, 8, 8);
        this.headEvilpig2.setRotationPoint(0.0F, 23 - byte0, -6.0F);
        this.headEvilpig3 = new ModelRenderer(this, 0, 0);
        this.headEvilpig3.addBox(-16.0F, -4.0F, -6.0F, 8, 8, 8);
        this.headEvilpig3.setRotationPoint(0.0F, 12 - byte0, -6.0F);
        this.headEvilpig4 = new ModelRenderer(this, 0, 0);
        this.headEvilpig4.addBox(-4.0F, -4.0F, -9.0F, 8, 8, 8);
        this.headEvilpig4.setRotationPoint(0.0F, 12 - byte0, -6.0F);
        this.headEvilpig5 = new ModelRenderer(this, 0, 0);
        this.headEvilpig5.addBox(8.0F, -4.0F, -6.0F, 8, 8, 8);
        this.headEvilpig5.setRotationPoint(0.0F, 12 - byte0, -6.0F);
        this.body = new ModelRenderer(this, 20, 8);
        this.body.addBox(-10.0F, -10.0F, -7.0F, 20, 16, 12);
        this.body.setRotationPoint(0.0F, 17 - byte0, 2.0F);
        this.leg1 = new ModelRenderer(this, 0, 16);
        this.leg1.addBox(-2.0F, 0.0F, -2.0F, 4, byte0, 4);
        this.leg1.setRotationPoint(-8.0F, 24 - byte0, 7.0F);
        this.leg2 = new ModelRenderer(this, 0, 16);
        this.leg2.addBox(-2.0F, 0.0F, -2.0F, 4, byte0, 4);
        this.leg2.setRotationPoint(8.0F, 24 - byte0, 7.0F);
        this.leg3 = new ModelRenderer(this, 0, 16);
        this.leg3.addBox(-2.0F, 0.0F, -2.0F, 4, byte0, 4);
        this.leg3.setRotationPoint(-8.0F, 24 - byte0, -5.0F);
        this.leg4 = new ModelRenderer(this, 0, 16);
        this.leg4.addBox(-2.0F, 0.0F, -2.0F, 4, byte0, 4);
        this.leg4.setRotationPoint(8.0F, 24 - byte0, -5.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.body.render(f5);
        this.headEvilpig.render(f5);
        this.leg1.render(f5);
        this.leg2.render(f5);
        this.leg3.render(f5);
        this.leg4.render(f5);
        this.headEvilpig1.render(f5);
        this.headEvilpig2.render(f5);
        this.headEvilpig3.render(f5);
        this.headEvilpig4.render(f5);
        this.headEvilpig5.render(f5);
    }

    @Override
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        this.body.rotateAngleX = 1.570796F;
        this.leg1.rotateAngleX = MathHelper.cos(f * 0.6662F + 0.0F) * 1.4F * f1;
        this.leg2.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.141593F) * 1.4F * f1;
        this.leg3.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.141593F) * 1.4F * f1;
        this.leg4.rotateAngleX = MathHelper.cos(f * 0.6662F + 0.0F) * 1.4F * f1;
        this.headEvilpig.rotateAngleX = -(f4 / 50.29578F);
        this.headEvilpig.rotateAngleY = f3 / 50.29578F;
        this.headEvilpig1.rotateAngleX = -(f4 / (float) (180.0 / Math.PI));
        this.headEvilpig1.rotateAngleY = f3 / (float) (180.0 / Math.PI);
        this.headEvilpig2.rotateAngleX = -(f4 / 52.29578F);
        this.headEvilpig2.rotateAngleY = f3 / 52.29578F;
        this.headEvilpig3.rotateAngleX = -(f4 / 52.29578F);
        this.headEvilpig3.rotateAngleY = f3 / 52.29578F;
        this.headEvilpig4.rotateAngleX = -(f4 / (float) (180.0 / Math.PI));
        this.headEvilpig4.rotateAngleY = f3 / (float) (180.0 / Math.PI);
        this.headEvilpig5.rotateAngleX = -(f4 / 50.29578F);
        this.headEvilpig5.rotateAngleY = f3 / 50.29578F;
        if (rand.nextInt(50) == 0) {
            this.headEvilpigpop++;
            if (this.headEvilpigpop > 5) {
                this.headEvilpigpop = 0;
            }

            this.headEvilpig.rotationPointZ = -10.0F;
            this.headEvilpig1.rotationPointZ = -13.0F;
            this.headEvilpig2.rotationPointZ = -10.0F;
            this.headEvilpig3.rotationPointZ = -6.0F;
            this.headEvilpig4.rotationPointZ = -9.0F;
            this.headEvilpig5.rotationPointZ = -6.0F;
            int i = this.headEvilpigpop;
            if (i == 0) {
                this.headEvilpig.rotationPointZ = -13.0F;
            }

            if (i == 1) {
                this.headEvilpig1.rotationPointZ = -16.0F;
            }

            if (i == 2) {
                this.headEvilpig2.rotationPointZ = -13.0F;
            }

            if (i == 3) {
                this.headEvilpig3.rotationPointZ = -9.0F;
            }

            if (i == 4) {
                this.headEvilpig4.rotationPointZ = -12.0F;
            }

            if (i == 5) {
                this.headEvilpig5.rotationPointZ = -9.0F;
            }
        }
    }

}
