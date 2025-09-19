package com.NovaCraft.entity;

import com.NovaCraft.NovaCraft;
import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.entity.AI.EntityAILavaSwimming;
import com.NovaCraftBlocks.NovaCraftBlocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntitySeaSerpent extends EntityMob
{		
	public EntitySeaSerpent(final World p_i1745_1_) {
		super(p_i1745_1_);
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
		this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
		this.tasks.addTask(5, new EntityAISwimming(this));
		this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(8, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
		setSize(0.5F, 0.5F);
		this.experienceValue = 5;
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();

		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(8D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(18.0D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(2D);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(8D);
		this.setHealth(18);
	}
	
	@Override
	public boolean attackEntityAsMob(final Entity entity) {
		final boolean flag = super.attackEntityAsMob(entity);
		((EntityLivingBase) entity).addPotionEffect(new PotionEffect(Potion.poison.id, 120, 2));
        
                
		return flag;
	}
	
	public boolean canBreatheUnderwater()
    {
        return true;
    }
	
	@Override
    public boolean isInWater() {
        return this.worldObj.getBlock((int)this.posX, MathHelper.floor_double(this.posY), (int)this.posZ).getMaterial() == Material.water;
    }
	
	@Override
    public boolean getCanSpawnHere() {
        return this.isInWater();
    }
	
	@Override
	public void onEntityUpdate() {
		int i = this.getAir();
        super.onEntityUpdate();

        if (this.isEntityAlive() && !this.isInWater()) {
        	if (!this.worldObj.isRemote) {
                this.motionX = 0.0D;
                this.motionY -= 0.08D;
                this.motionY *= 0.9800000190734863D;
                this.motionZ = 0.0D;
            }
            --i;
            this.setAir(i);

            if (this.getAir() == -20) {
                this.setAir(0);
                this.attackEntityFrom(DamageSource.drown, 2.0F);
            }
        }
        else {
            this.setAir(300);
        }	
	}
	
	protected Item getDropItem()
	{
	     return NovaCraftItems.sea_serpent_scales;
	}

	    
	protected void dropFewItems(boolean p_70628_1_, int p_70628_2_)
	{
	     super.dropFewItems(p_70628_1_, p_70628_2_);

	     if (p_70628_1_ && (this.rand.nextInt(5) == 0 || this.rand.nextInt(1 + p_70628_2_) > 0))
	     {
	         this.dropItem(NovaCraftItems.sea_serpent_venom_sac, 1);
	     }
	}
	
	public EnumCreatureAttribute getCreatureAttribute()
    {
        return EnumCreatureAttribute.UNDEFINED;
    }
	
	protected String getHurtSound() {
        return "nova_craft:blazing_serpent.hurt";
    }
    
    protected String getDeathSound() {
        return "nova_craft:blazing_serpent.hurt";
    }
    
    protected String getChargeSound() {
        return null;
    }
    
    @Override
    protected float getSoundVolume() {
        return 0.4F;
    }



}
