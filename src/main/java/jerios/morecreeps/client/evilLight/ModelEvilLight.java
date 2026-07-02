package jerios.morecreeps.client.evilLight;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelEvilLight extends ModelBase {

    public ModelRenderer bipedHead = new ModelRenderer(this, 0, 0);
    public ModelRenderer bipedBody;
    public ModelRenderer bipedBody2;

    public ModelEvilLight() {
        this(2.0F);
    }

    public ModelEvilLight(float f) {
        this(f, 0.0F);
    }

    public ModelEvilLight(float f, float f1) {
        this.bipedHead.addBox(-5.0F, 0.0F, 0.0F, 10, 20, 0, f);
        this.bipedHead.setRotationPoint(0.0F, 0.0F + f1, 2.0F);
        this.bipedBody = new ModelRenderer(this, 0, 0);
        this.bipedBody.addBox(-5.0F, 0.0F, 0.0F, 10, 20, 0, f);
        this.bipedBody.setRotationPoint(6.0F, 0.0F + f1, 3.0F);
        this.bipedBody2 = new ModelRenderer(this, 0, 0);
        this.bipedBody2.addBox(-5.0F, 0.0F, 0.0F, 10, 20, 0, f);
        this.bipedBody2.setRotationPoint(-6.0F, -6.0F + f1, 2.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.bipedHead.render(f5);
        this.bipedBody.render(f5);
        this.bipedBody2.render(f5);
    }

    @Override
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        this.bipedHead.rotateAngleZ = f2 * 2.0F;
        this.bipedHead.rotateAngleX = f2;
        this.bipedBody.rotateAngleZ = f2 * 3.0F;
        this.bipedBody2.rotateAngleZ = f2 * 5.0F;
        this.bipedBody2.rotateAngleX = f2 * 2.0F;
    }
}
