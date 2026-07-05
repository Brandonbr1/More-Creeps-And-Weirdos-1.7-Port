package jerios.morecreeps.client.trophy;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelTrophy extends ModelBase {

    public ModelRenderer body;
    public ModelRenderer New_Shape2;
    public ModelRenderer New_Shape3;
    public ModelRenderer New_Shape1;
    public ModelRenderer New_Shape11;
    public ModelRenderer New_Shape8;
    public ModelRenderer New_Shape6;
    public ModelRenderer New_Shape4;
    public ModelRenderer New_Shape7;
    public ModelRenderer New_Shape5;
    public ModelRenderer New_Shape13;
    public ModelRenderer New_Shape12;
    public ModelRenderer New_Shape10;
    public ModelRenderer New_Shape9;

    public ModelTrophy() {
        this(0.0F);
    }

    public ModelTrophy(float f) {
        this(f, 0.0F);
    }

    public ModelTrophy(float f, float f1) {
        float f2 = 0.0F;
        this.body = new ModelRenderer(this, 32, 24);
        this.body.addBox(-3.0F, -2.0F, -3.0F, 6, 2, 6, f2);
        this.body.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.New_Shape2 = new ModelRenderer(this, 37, 11);
        this.New_Shape2.addBox(-1.5F, -7.0F, -1.5F, 3, 4, 3, f2);
        this.New_Shape2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.New_Shape3 = new ModelRenderer(this, 0, 13);
        this.New_Shape3.addBox(-4.0F, -18.0F, -4.0F, 8, 11, 8, f2);
        this.New_Shape3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.New_Shape1 = new ModelRenderer(this, 35, 19);
        this.New_Shape1.addBox(-2.0F, -3.0F, -2.0F, 4, 1, 4, f2);
        this.New_Shape1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.New_Shape11 = new ModelRenderer(this, 8, 3);
        this.New_Shape11.addBox(7.0F, -14.0F, -0.5F, 1, 3, 1, f2);
        this.New_Shape11.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.New_Shape8 = new ModelRenderer(this, 0, 9);
        this.New_Shape8.addBox(-6.0F, -10.0F, -1.0F, 2, 1, 1, f2);
        this.New_Shape8.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.New_Shape6 = new ModelRenderer(this, 0, 3);
        this.New_Shape6.addBox(-8.0F, -14.0F, -1.0F, 1, 3, 1, f2);
        this.New_Shape6.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.New_Shape4 = new ModelRenderer(this, 0, 0);
        this.New_Shape4.addBox(-6.0F, -16.0F, -1.0F, 2, 1, 1, f2);
        this.New_Shape4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.New_Shape7 = new ModelRenderer(this, 24, 0);
        this.New_Shape7.addBox(-7.0F, -11.0F, -1.0F, 1, 1, 1, f2);
        this.New_Shape7.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.New_Shape5 = new ModelRenderer(this, 30, 0);
        this.New_Shape5.addBox(-7.0F, -15.0F, -1.0F, 1, 1, 1, f2);
        this.New_Shape5.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.New_Shape13 = new ModelRenderer(this, 8, 9);
        this.New_Shape13.addBox(4.0F, -10.0F, -1.0F, 2, 1, 1, f2);
        this.New_Shape13.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.New_Shape12 = new ModelRenderer(this, 8, 0);
        this.New_Shape12.addBox(6.0F, -11.0F, -1.0F, 1, 1, 1, f2);
        this.New_Shape12.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.New_Shape10 = new ModelRenderer(this, 8, 0);
        this.New_Shape10.addBox(6.0F, -15.0F, -0.5F, 1, 1, 1, f2);
        this.New_Shape10.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.New_Shape9 = new ModelRenderer(this, 16, 0);
        this.New_Shape9.addBox(4.0F, -16.0F, -0.5F, 2, 1, 1, f2);
        this.New_Shape9.setRotationPoint(0.0F, 0.0F, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.body.render(f5);
        this.New_Shape2.render(f5);
        this.New_Shape3.render(f5);
        this.New_Shape1.render(f5);
        this.New_Shape11.render(f5);
        this.New_Shape8.render(f5);
        this.New_Shape6.render(f5);
        this.New_Shape4.render(f5);
        this.New_Shape7.render(f5);
        this.New_Shape5.render(f5);
        this.New_Shape13.render(f5);
        this.New_Shape12.render(f5);
        this.New_Shape10.render(f5);
        this.New_Shape9.render(f5);
    }

}
