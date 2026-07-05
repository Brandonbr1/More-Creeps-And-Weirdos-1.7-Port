package jerios.morecreeps.entity.nonLiving;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityMoney extends EntityItem {

    public EntityMoney(World worldIn, double x, double y, double z) {
        super(worldIn, x, y, z);
    }

    public EntityMoney(World worldIn, double x, double y, double z, ItemStack stack) {
        super(worldIn, x, y, z, stack);
    }

    public EntityMoney(World world) {
        super(world);
    }

    @Override
    public boolean isInRangeToRenderDist(double d) {
        double d1 = this.boundingBox.getAverageEdgeLength() * 4.0;
        d1 *= 64.0;
        return d < d1 * d1;
    }

    @Override
    public void setVelocity(double d, double d1, double d2) {
        this.motionX = d;
        this.motionY = d1;
        this.motionZ = d2;
        if (this.prevRotationPitch == 0.0F && this.prevRotationYaw == 0.0F) {
            float f = MathHelper.sqrt_double(d * d + d2 * d2);
            this.prevRotationYaw = this.rotationYaw = (float) (Math.atan2(d, d2) * 180.0 / (float) Math.PI);
            this.prevRotationPitch = this.rotationPitch = (float) (Math.atan2(d1, f) * 180.0 / (float) Math.PI);
        }
    }

    @Override
    public float getShadowSize() {
        return 0.2F;
    }
}
