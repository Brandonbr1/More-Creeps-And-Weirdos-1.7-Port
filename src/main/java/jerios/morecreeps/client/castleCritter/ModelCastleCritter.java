package jerios.morecreeps.client.castleCritter;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelCastleCritter extends ModelBase {

    public ModelRenderer critterHead = new ModelRenderer(this, 12, 0);
    public ModelRenderer body;
    public ModelRenderer leg1;
    public ModelRenderer leg2;
    public ModelRenderer leg3;
    public ModelRenderer leg4;
    public ModelRenderer tail;
    public ModelRenderer hornR;
    public ModelRenderer hornL;

    public ModelCastleCritter() {
        this.critterHead.addBox(-1.5F, -1.5F, -3.0F, 3, 3, 3, 0.0F);
        this.critterHead.setRotationPoint(0.0F, 19.0F, -1.0F);
        this.body = new ModelRenderer(this, 0, 6);
        this.body.addBox(-1.0F, -1.0F, -2.5F, 2, 2, 5, 0.0F);
        this.body.setRotationPoint(0.0F, 21.0F, 1.5F);
        this.leg1 = new ModelRenderer(this, 0, 13);
        this.leg1.addBox(-0.5F, 0.0F, -0.5F, 1, 2, 1, -0.25F);
        this.leg1.setRotationPoint(0.5F, 22.0F, -0.5F);
        this.leg2 = new ModelRenderer(this, 0, 13);
        this.leg2.addBox(-0.5F, 0.0F, -0.5F, 1, 2, 1, -0.25F);
        this.leg2.setRotationPoint(-0.5F, 22.0F, -0.5F);
        this.leg3 = new ModelRenderer(this, 0, 13);
        this.leg3.addBox(-0.5F, 0.0F, -0.5F, 1, 2, 1, -0.25F);
        this.leg3.setRotationPoint(0.5F, 22.0F, 3.5F);
        this.leg4 = new ModelRenderer(this, 0, 13);
        this.leg4.addBox(-0.5F, 0.0F, -0.5F, 1, 2, 1, -0.25F);
        this.leg4.setRotationPoint(-0.5F, 22.0F, 3.5F);
        this.tail = new ModelRenderer(this, 0, 0);
        this.tail.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 5, 0.0F);
        this.tail.setRotationPoint(0.0F, 21.0F, 3.5F);
        this.tail.rotateAngleX = -0.3346075F;
        this.hornR = new ModelRenderer(this, 0, 16);
        this.hornR.addBox(-1.5F, -3.0F, -2.0F, 1, 2, 1, 0.0F);
        this.hornR.setRotationPoint(0.0F, 19.0F, -1.0F);
        this.hornL = new ModelRenderer(this, 0, 16);
        this.hornL.addBox(0.5F, -3.0F, -2.0F, 1, 2, 1, 0.0F);
        this.hornL.setRotationPoint(0.0F, 19.0F, -1.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.critterHead.render(f5);
        this.body.render(f5);
        this.leg1.render(f5);
        this.leg2.render(f5);
        this.leg3.render(f5);
        this.leg4.render(f5);
        this.tail.render(f5);
        this.hornR.render(f5);
        this.hornL.render(f5);
    }

    @Override
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
        float f6 = f3 / (float) (180.0 / Math.PI);
        float f7 = f4 / (float) (180.0 / Math.PI);
        this.hornR.rotateAngleY = this.hornL.rotateAngleY = this.critterHead.rotateAngleY = f6;
        this.hornR.rotateAngleX = this.hornL.rotateAngleX = this.critterHead.rotateAngleX = f7;
        this.tail.rotateAngleY = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
        this.leg1.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
        this.leg2.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.141593F) * 1.4F * f1;
        this.leg3.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.141593F) * 1.4F * f1;
        this.leg4.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
    }


}
