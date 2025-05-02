package com.NovaCraft.entity;

import com.NovaCraft.Hardmode;
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
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityBlazingSerpent extends EntityMob
{		
	public EntityBlazingSerpent(final World p_i1745_1_) {
		super(p_i1745_1_);
		this.isImmuneToFire = true;
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
		this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
		this.tasks.addTask(5, new EntityAILavaSwimming(this));
		this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(8, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityVillager.class, 0, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPigZombie.class, 0, true));
		setSize(2.0F, 2.0F);
		this.experienceValue = 25;
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		
		//World world = MinecraftServer.getServer().worldServers[0];
        //Hardmode data = Hardmode.get(world);
        //if (data.getHardmode() == true) {
        	//this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(6.65D);
    		//this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(220.0D);
    		//this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0.20D);
    		//this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(20D);
    		//this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(30D);
    		//this.setHealth(220);
        //} else {
        	this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(6.55D);
    		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(110.0D);
    		this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0.20D);
    		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(10D);
    		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(30D);
    		this.setHealth(110);
        //}
	}
	
	 public int getTotalArmorValue() {
	       return 6;
     }
	
	@Override
	public boolean attackEntityAsMob(final Entity entity) {
		final boolean flag = super.attackEntityAsMob(entity);
		if (flag) {
			final int i = this.worldObj.difficultySetting.getDifficultyId();
			if (this.getHeldItem() == null && this.isBurning() && this.rand.nextFloat() < i * 0.3f) {
				entity.setFire(0 * i);
			}
		}
		
		if (this.handleLavaMovement() == true) {
		this.addPotionEffect(new PotionEffect(Potion.regeneration.id, 30, 0));  
		}
		
		((EntityLivingBase) entity).addPotionEffect(new PotionEffect(Potion.poison.id, 200, 0));
		entity.setFire(7);
        
                
		return flag;
	}
	
	public boolean getCanSpawnHere() {
        final int i = MathHelper.floor_double(this.posX);
        final int j = MathHelper.floor_double(this.boundingBox.minY);
        final int k = MathHelper.floor_double(this.posZ);
        final boolean canSpawn = this.worldObj.checkNoEntityCollision(this.boundingBox) && this.worldObj.getCollidingBoundingBoxes((Entity)this, this.boundingBox).isEmpty() && !this.worldObj.isAnyLiquid(this.boundingBox);          
        return this.worldObj.getBlockLightValue(i, j, k) < 12  && this.posY <= 64.0D && canSpawn;
                      
    }
	
	public boolean handleLavaMovement()
    {
        return this.worldObj.isMaterialInBB(this.boundingBox.expand(-0.10000000149011612D, -0.4000000059604645D, -0.10000000149011612D), Material.lava);
    }
	
	public void onLivingUpdate()
	{		
		if (this.isWet())
        {
            this.attackEntityFrom(DamageSource.drown, 1.0F);
        }
		
		for (int i = 0; i < 2; ++i)
        {
            this.worldObj.spawnParticle("flame", this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, 0.0D, 0.0D, 0.0D);
        }
		
		super.onLivingUpdate();
	}
	
	@SideOnly(Side.CLIENT)
    public int getBrightnessForRender(float p_70070_1_)
    {
        return 15728880;
    }

    /**
     * Gets how bright this entity is.
     */
    public float getBrightness(float p_70013_1_)
    {
        return 0.45F;
    }
	
	 protected void dropFewItems(boolean p_70628_1_, int p_70628_2_)
	    {
	        int j;
	        int k;
	        {
	            j = this.rand.nextInt(1 + p_70628_2_);

	            for (k = 0; k < j; ++k)
	            {
	                this.dropItem(NovaCraftItems.blazing_serpent_scales, 1 + p_70628_2_);
	            }
	        }
	        
	    }
	 
	protected void dropRareDrop(int p_70600_1_)
	 {	
	  this.dropItem(NovaCraftItems.blazing_serpent_tooth, 1);
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
        return 3.66F;
    }



}

