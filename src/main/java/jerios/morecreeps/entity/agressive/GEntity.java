package jerios.morecreeps.entity.agressive;

import jerios.morecreeps.entity.base.CreepsAgressiveMobBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class GEntity extends CreepsAgressiveMobBase {
    public GEntity(World world) {
        super(world);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(40.0D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(40.0D);
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {
        return super.attackEntityFrom(source, amount);
    }

    @Override
    public IEntityLivingData onSpawnWithEgg(IEntityLivingData entityLivingData) {
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(this.getMaxHealth() + this.worldObj.rand.nextInt(40));

        return super.onSpawnWithEgg(entityLivingData);

    }
}
