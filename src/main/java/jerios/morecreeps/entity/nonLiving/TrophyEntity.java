package jerios.morecreeps.entity.nonLiving;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import jerios.morecreeps.MoreCreeps;

public class TrophyEntity extends Entity {

    public int partyTime;
    public int trophyLifespan;

    public TrophyEntity(World worldIn) {
        super(worldIn);
        this.partyTime = this.rand.nextInt(30) + 40;
        this.trophyLifespan = 80;
        this.setSize(1.0F, 2.5F);
        this.ignoreFrustumCheck = true;
    }

    @Override
    protected void entityInit() {

    }

    @Override
    public void onUpdate() {

        if (this.partyTime-- > 1) {
            this.confetti();
        }

        if (this.trophyLifespan-- < 0) {
             this.setDead();
        }
        super.onUpdate();
    }

    @Override
    protected void readEntityFromNBT(NBTTagCompound tagCompound) {
        this.partyTime = tagCompound.getInteger("PartyTime");
        this.trophyLifespan = tagCompound.getInteger("Lifespan");
    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound tagCompound) {
        tagCompound.setInteger("PartyTime", this.partyTime);
        tagCompound.setInteger("Lifespan", this.trophyLifespan);

    }

    public void confetti() {
        MoreCreeps.proxy.spawnConfettiTrophyA(worldObj, this.posX, this.posY, this.posZ);
    }
}
