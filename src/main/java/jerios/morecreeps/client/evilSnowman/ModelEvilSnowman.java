package jerios.morecreeps.client.evilSnowman;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelEvilSnowman extends ModelBase {

    public ModelRenderer body2;
    public ModelRenderer body1;
    public ModelRenderer head;
    public ModelRenderer hatbrim;
    public ModelRenderer hat;
    public ModelRenderer arm2L;
    public ModelRenderer arm1L;
    public ModelRenderer arm2R;
    public ModelRenderer arm1R;
    public ModelRenderer nose;
    public ModelRenderer eyeL;
    public ModelRenderer eyeR;
    public boolean field_1279_h;
    public boolean field_1278_i;
    public boolean isSneak;

    public ModelEvilSnowman() {
        this(0.0F);
    }

    public ModelEvilSnowman(float f) {
        this(f, 0.0F);
    }

    public ModelEvilSnowman(float f, float f1) {
        float f2 = 0.0F;
        this.body2 = new ModelRenderer(this, 20, 0);
        this.body2.addBox(-5.0F, -5.0F, -5.0F, 11, 11, 11, f2);
        this.body2.setRotationPoint(0.0F, 17.0F, 0.0F);
        this.body1 = new ModelRenderer(this, 24, 4);
        this.body1.addBox(-5.0F, -5.0F, -5.0F, 8, 8, 8, f2);
        this.body1.setRotationPoint(2.0F, 9.0F, 2.0F);
        this.head = new ModelRenderer(this, 27, 0);
        this.head.addBox(-3.0F, -6.0F, -3.0F, 6, 6, 6, f2);
        this.head.setRotationPoint(1.0F, 4.0F, 1.0F);
        this.hatbrim = new ModelRenderer(this, 0, 23);
        this.hatbrim.addBox(-4.0F, -7.0F, -4.0F, 8, 1, 8, f2);
        this.hatbrim.setRotationPoint(1.0F, 4.0F, 1.0F);
        this.hat = new ModelRenderer(this, 0, 22);
        this.hat.addBox(-2.5F, -12.0F, -2.5F, 5, 5, 5, f2);
        this.hat.setRotationPoint(1.0F, 4.0F, 1.0F);
        this.arm2L = new ModelRenderer(this, 0, 10);
        this.arm2L.addBox(-8.0F, 2.0F, 0.0F, 5, 1, 1, f2);
        this.arm2L.setRotationPoint(-3.0F, 6.0F, 0.0F);
        this.arm2L.rotateAngleZ = 0.13561F;
        this.arm1L = new ModelRenderer(this, 0, 10);
        this.arm1L.addBox(-8.0F, 0.0F, 0.0F, 8, 1, 1, f2);
        this.arm1L.setRotationPoint(-3.0F, 6.0F, 0.0F);
        this.arm1L.rotateAngleZ = -0.45203F;
        this.arm2R = new ModelRenderer(this, 0, 10);
        this.arm2R.addBox(2.0F, 3.0F, 0.0F, 5, 1, 1, f2);
        this.arm2R.setRotationPoint(5.0F, 6.0F, 0.0F);
        this.arm2R.rotateAngleZ = -0.40682F;
        this.arm1R = new ModelRenderer(this, 0, 10);
        this.arm1R.addBox(0.0F, 0.0F, 0.0F, 8, 1, 1, f2);
        this.arm1R.setRotationPoint(5.0F, 6.0F, 0.0F);
        this.arm1R.rotateAngleZ = 0.49723F;
        this.nose = new ModelRenderer(this, 10, 0);
        this.nose.addBox(-0.5F, -3.0F, -6.0F, 1, 1, 3, f2);
        this.nose.setRotationPoint(1.0F, 4.0F, 1.0F);
        this.eyeL = new ModelRenderer(this, 0, 0);
        this.eyeL.addBox(-2.0F, -5.0F, -3.5F, 1, 1, 1, f2);
        this.eyeL.setRotationPoint(1.0F, 4.0F, 1.0F);
        this.eyeR = new ModelRenderer(this, 0, 0);
        this.eyeR.addBox(1.0F, -5.0F, -3.5F, 1, 1, 1, f2);
        this.eyeR.setRotationPoint(1.0F, 4.0F, 1.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.body2.render(f5);
        this.body1.render(f5);
        this.head.render(f5);
        this.hatbrim.render(f5);
        this.hat.render(f5);
        this.arm2L.render(f5);
        this.arm1L.render(f5);
        this.arm2R.render(f5);
        this.arm1R.render(f5);
        this.nose.render(f5);
        this.eyeL.render(f5);
        this.eyeR.render(f5);
    }

    @Override
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        this.head.rotateAngleY = f3 / (float) (180.0 / Math.PI);
        this.head.rotateAngleX = f4 / (float) (180.0 / Math.PI);
        this.hat.rotateAngleY = this.hatbrim.rotateAngleY = this.nose.rotateAngleY = this.eyeL.rotateAngleY = this.eyeR.rotateAngleY = this.head.rotateAngleY;
        this.hat.rotateAngleX = this.hatbrim.rotateAngleX = this.nose.rotateAngleX = this.eyeL.rotateAngleX = this.eyeR.rotateAngleX = this.head.rotateAngleX;
        this.arm1R.rotateAngleZ = MathHelper.cos(f * 0.6662F + 3.141593F) * 3.0F * f1 * 0.5F + 0.3F + 0.49723F;
        this.arm2R.rotateAngleZ = MathHelper.cos(f * 0.6662F + 3.141593F) * 3.0F * f1 * 0.5F + 0.3F - 0.40682F;
        this.arm1L.rotateAngleZ = MathHelper.cos(f * 0.6662F) * 3.0F * f1 * 0.5F - 0.5F - 0.45203F;
        this.arm2L.rotateAngleZ = MathHelper.cos(f * 0.6662F) * 3.0F * f1 * 0.5F - 0.5F + 0.13561F;
    }
}
