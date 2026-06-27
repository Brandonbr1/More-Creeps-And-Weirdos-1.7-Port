package jerios.morecreeps.client.GMob;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
@SideOnly(Side.CLIENT)
public class ModelGMob extends ModelBase {
    public ModelRenderer bipedRightArm;

    public ModelRenderer bipedLeftArm;

    public ModelRenderer bipedRightLeg;

    public ModelRenderer bipedLeftLeg;

    public ModelRenderer bipedEars;

    public ModelRenderer bipedCloak;

    public boolean field_1279_h = false;

    public boolean field_1278_i = false;

    public boolean isSneak = false;

    public ModelRenderer eyeL;

    public ModelRenderer g3;

    public ModelRenderer g5;

    public ModelRenderer g1;

    public ModelRenderer g2;

    public ModelRenderer g4;

    public ModelRenderer eyeR;

    public float modelsize;

    public ModelGMob() {
        this(0.0F);
    }

    public ModelGMob(float f) {
        this(f, 0.0F);
    }

    public ModelGMob(float f, float f1) {
        float f2 = 0.0F;
        this.eyeL = new ModelRenderer(this, 0, 0);
        this.eyeL.addBox(-3.0F, -17.0F, -2.5F, 3, 3, 1, f2);
        this.eyeL.setRotationPoint(0.0F, 8.0F, 0.0F);
        this.g3 = new ModelRenderer(this, 16, 6);
        this.g3.addBox(-8.0F, 0.0F, -2.0F, 16, 4, 4, f2);
        this.g3.setRotationPoint(0.0F, 8.0F, 0.0F);
        this.bipedLeftArm = new ModelRenderer(this, 56, 16);
        this.bipedLeftArm.addBox(-2.0F, -1.0F, -1.0F, 2, 8, 2, f2);
        this.bipedLeftArm.setRotationPoint(-8.0F, 8.0F, 0.0F);
        this.g5 = new ModelRenderer(this, 16, 6);
        this.g5.addBox(-8.0F, -16.0F, -2.0F, 16, 4, 4, f2);
        this.g5.setRotationPoint(0.0F, 8.0F, 0.0F);
        this.bipedRightLeg = new ModelRenderer(this, 0, 16);
        this.bipedRightLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, f2);
        this.bipedRightLeg.setRotationPoint(-3.0F, 12.0F, 0.0F);
        this.bipedLeftLeg = new ModelRenderer(this, 0, 16);
        this.bipedLeftLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, f2);
        this.bipedLeftLeg.setRotationPoint(3.0F, 12.0F, 0.0F);
        this.g1 = new ModelRenderer(this, 16, 16);
        this.g1.addBox(0.0F, -7.0F, -2.0F, 8, 4, 4, f2);
        this.g1.setRotationPoint(0.0F, 8.0F, 0.0F);
        this.g2 = new ModelRenderer(this, 40, 16);
        this.g2.addBox(4.0F, -3.0F, -2.0F, 4, 3, 4, f2);
        this.g2.setRotationPoint(0.0F, 8.0F, 0.0F);
        this.g4 = new ModelRenderer(this, 40, 16);
        this.g4.addBox(-8.0F, -12.0F, -2.0F, 4, 12, 4, f2);
        this.g4.setRotationPoint(0.0F, 8.0F, 0.0F);
        this.bipedRightArm = new ModelRenderer(this, 56, 16);
        this.bipedRightArm.addBox(0.0F, -1.0F, -1.0F, 2, 8, 2, f2);
        this.bipedRightArm.setRotationPoint(8.0F, 8.0F, 0.0F);
        this.eyeR = new ModelRenderer(this, 0, 0);
        this.eyeR.addBox(1.0F, -17.0F, -2.5F, 3, 3, 1, f2);
        this.eyeR.setRotationPoint(0.0F, 8.0F, 0.0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        setRotationAngles(f, f1, f2, f3, f4, f5);
        this.eyeL.render(f5);
        this.g3.render(f5);
        this.bipedLeftArm.render(f5);
        this.g5.render(f5);
        this.bipedRightLeg.render(f5);
        this.bipedLeftLeg.render(f5);
        this.g1.render(f5);
        this.g2.render(f5);
        this.g4.render(f5);
        this.bipedRightArm.render(f5);
        this.eyeR.render(f5);
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
        this.bipedRightArm.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.141593F) * 2.0F * f1 * 0.5F;
        this.bipedLeftArm.rotateAngleX = MathHelper.cos(f * 0.6662F) * 2.0F * f1 * 0.5F;
        this.bipedRightArm.rotateAngleZ = 0.0F;
        this.bipedLeftArm.rotateAngleZ = 0.0F;
        this.bipedRightLeg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
        this.bipedLeftLeg.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.141593F) * 1.4F * f1;
        this.bipedRightLeg.rotateAngleY = 0.0F;
        this.bipedLeftLeg.rotateAngleY = 0.0F;
        if (this.isRiding) {
            this.bipedRightArm.rotateAngleX += -0.6283185F;
            this.bipedLeftArm.rotateAngleX += -0.6283185F;
            this.bipedRightLeg.rotateAngleX = -1.256637F;
            this.bipedLeftLeg.rotateAngleX = -1.256637F;
            this.bipedRightLeg.rotateAngleY = 0.3141593F;
            this.bipedLeftLeg.rotateAngleY = -0.3141593F;
        }
        if (this.field_1279_h)
            this.bipedLeftArm.rotateAngleX = this.bipedLeftArm.rotateAngleX * 0.5F - 0.3141593F;
        if (this.field_1278_i)
            this.bipedRightArm.rotateAngleX = this.bipedRightArm.rotateAngleX * 0.5F - 0.3141593F;
        this.bipedRightArm.rotateAngleY = 0.0F;
        this.bipedLeftArm.rotateAngleY = 0.0F;
        if (this.onGround > -9990.0F) {
            float f6 = this.onGround;
            f6 = 1.0F - this.onGround;
            f6 *= f6;
            f6 *= f6;
            f6 = 1.0F - f6;
            float f7 = MathHelper.sin(f6 * 3.141593F);
            this.bipedRightArm.rotateAngleZ = MathHelper.sin(this.onGround * 3.141593F) * -0.4F;
        }
        if (this.isSneak) {
            this.bipedRightLeg.rotateAngleX -= 0.0F;
            this.bipedLeftLeg.rotateAngleX -= 0.0F;
            this.bipedRightArm.rotateAngleX += 0.4F;
            this.bipedLeftArm.rotateAngleX += 0.4F;
            this.bipedRightLeg.rotationPointZ = 4.0F;
            this.bipedLeftLeg.rotationPointZ = 4.0F;
            this.bipedRightLeg.rotationPointY = 9.0F;
            this.bipedLeftLeg.rotationPointY = 9.0F;
        } else {
            this.bipedRightLeg.rotationPointZ = 0.0F;
            this.bipedLeftLeg.rotationPointZ = 0.0F;
            this.bipedRightLeg.rotationPointY = 12.0F;
            this.bipedLeftLeg.rotationPointY = 12.0F;
        }
        this.bipedRightArm.rotateAngleZ += MathHelper.cos(f2 * 0.09F) * 0.05F + 0.05F;
        this.bipedLeftArm.rotateAngleZ -= MathHelper.cos(f2 * 0.09F) * 0.05F + 0.05F;
        this.bipedRightArm.rotateAngleX += MathHelper.sin(f2 * 0.067F) * 0.05F;
        this.bipedLeftArm.rotateAngleX -= MathHelper.sin(f2 * 0.067F) * 0.05F;
    }

}
