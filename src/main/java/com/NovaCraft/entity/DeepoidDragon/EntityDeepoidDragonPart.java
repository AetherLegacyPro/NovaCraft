package com.NovaCraft.entity.DeepoidDragon;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;

public class EntityDeepoidDragonPart extends Entity
{
    public final GIEntityMultiPart entityDragonObj;
    public final String field_146032_b;

    public EntityDeepoidDragonPart(GIEntityMultiPart p_i1697_1_, String p_i1697_2_, float p_i1697_3_, float p_i1697_4_)
    {
        super(p_i1697_1_.func_82194_d());
        this.setSize(p_i1697_3_, p_i1697_4_);
        this.entityDragonObj = p_i1697_1_;
        this.field_146032_b = p_i1697_2_;
    }

    protected void entityInit() {}

    protected void readEntityFromNBT(NBTTagCompound p_70037_1_) {}

    protected void writeEntityToNBT(NBTTagCompound p_70014_1_) {}

    public boolean canBeCollidedWith()
    {
        return true;
    }

    public boolean attackEntityFrom(DamageSource p_70097_1_, float p_70097_2_)
    {
        return this.isEntityInvulnerable() ? false : this.entityDragonObj.aattackEntityFromPart(this, p_70097_1_, p_70097_2_);
    }

    public boolean isEntityEqual(Entity p_70028_1_)
    {
        return this == p_70028_1_ || this.entityDragonObj == p_70028_1_;
    }
}
