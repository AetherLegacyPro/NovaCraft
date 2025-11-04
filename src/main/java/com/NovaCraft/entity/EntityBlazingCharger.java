package com.NovaCraft.entity;

import net.minecraft.entity.*;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.util.DamageSource;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraftBlocks.NovaCraftBlocks;

import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.init.Items;

public class EntityBlazingCharger extends EntityMob
{
    public EntityBlazingCharger(final World par1World) {
        super(par1World);
        this.setSize(1.4f, 0.9f);
        this.isImmuneToFire = true;
    }
    
    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(16, (Object)new Byte((byte)0));
    }
    
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(24.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.9);
    }
    
    public void onLivingUpdate() {
        for (int i = 0; i < 2; ++i) {
            this.worldObj.spawnParticle("flame", this.posX + (this.rand.nextDouble() - 0.5) * this.width, this.posY + this.rand.nextDouble() * this.height, this.posZ + (this.rand.nextDouble() - 0.5) * this.width, 0.0, 0.0, 0.0);
        }
        super.onLivingUpdate();
    }
    
    protected String getLivingSound() {
        return "mob.cow.hurt";
    }
    
    protected String getHurtSound() {
        return "mob.cow.hurt";
    }
    
    protected String getDeathSound() {
        return "mob.cow.hurt";
    }
    
    protected float getSoundPitch() {
        return super.getSoundPitch() * 0.55f;
    }
    
    protected void func_70036_a(final int par1, final int par2, final int par3, final int par4) {
        this.playSound("mob.cow.step", 0.15f, 1.0f);
    }
    
    protected Item getDropItem()
    {
        return Items.leather;
    }
    
    protected void dropFewItems(boolean p_70628_1_, int p_70628_2_)
    {
        int j;
        int k;
        {
            j = this.rand.nextInt(3 + p_70628_2_);

            for (k = 0; k < j; ++k)
            {
                this.dropItem(NovaCraftItems.raw_blazing_charger, 1);
            }
        }

        j = this.rand.nextInt(3 + p_70628_2_);

        for (k = 0; k < j; ++k)
        {
        	this.dropItem(Items.leather, 1);
        }
    }
    
    public boolean attackEntityAsMob(final Entity par1Entity) {
        this.worldObj.setEntityState((Entity)this, (byte)4);
        final boolean flag = par1Entity.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), (float)(3 + this.rand.nextInt(5)));
        if (flag) {
            par1Entity.motionY += 0.4000000059604645;
        }
        this.playSound("mob.irongolem.throw", 1.0f, 1.0f);
        return flag;
    }

    @Override
    public double getMountedYOffset() {
        return this.height + 0.6D;
    }

    public IEntityLivingData onSpawnWithEgg(IEntityLivingData p_110161_1_) {
        Object p_110161_1_1 = super.onSpawnWithEgg(p_110161_1_);

        if (this.worldObj.rand.nextInt(6) == 0) {
            EntitySlaughter entity = new EntitySlaughter(this.worldObj);
            entity.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
            entity.onSpawnWithEgg(null);
            this.worldObj.spawnEntityInWorld(entity);
            entity.mountEntity(this);
        }

        return (IEntityLivingData)p_110161_1_1;
    }
    
    public EnumCreatureAttribute getCreatureAttribute() {
        return EnumCreatureAttribute.UNDEFINED;
    }
}
