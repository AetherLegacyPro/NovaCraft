package com.NovaCraft.entity;

import com.NovaCraft.NovaCraft;
import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraftBlocks.NovaCraftBlocks;

import net.minecraft.block.Block;
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

public class EntitySculkDuplicator extends EntityMob
{		
	public EntitySculkDuplicator(final World p_i1745_1_) {
		super(p_i1745_1_);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
		this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
		this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(8, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
		setSize(0.6F, 1.8F);
		this.experienceValue = 5;
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();

		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.55D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(50.0D);
		this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0.20D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(7D);
		this.setHealth(50);
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
		
		this.addPotionEffect(new PotionEffect(Potion.regeneration.id, 60, 0));        
        int rand = (int)(1 + Math.random() * 8);
		switch (rand)
        {
        	case 1:
        		((EntityLivingBase) entity).addPotionEffect(new PotionEffect(Potion.hunger.id, 150, 0));
        		((EntityLivingBase) entity).addPotionEffect(new PotionEffect(Potion.poison.id, 100, 0));
        		break;
            case 2:
            	((EntityLivingBase) entity).addPotionEffect(new PotionEffect(Potion.poison.id, 100, 1));
            	((EntityLivingBase) entity).addPotionEffect(new PotionEffect(Potion.blindness.id, 60, 0));
                break;
            case 3:
            	((EntityLivingBase) entity).addPotionEffect(new PotionEffect(Potion.blindness.id, 60, 0));
            	((EntityLivingBase) entity).addPotionEffect(new PotionEffect(Potion.blindness.id, 60, 0));
                break;
            case 4:
            	((EntityLivingBase) entity).addPotionEffect(new PotionEffect(Potion.weakness.id, 150, 1));
            	((EntityLivingBase) entity).addPotionEffect(new PotionEffect(Potion.blindness.id, 60, 0));
                break;
            case 5:
            	((EntityLivingBase) entity).addPotionEffect(new PotionEffect(Potion.wither.id, 100, 0));
            	((EntityLivingBase) entity).addPotionEffect(new PotionEffect(Potion.blindness.id, 60, 0));
            	break;
            case 6:
            	((EntityLivingBase) entity).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 100, 1));
            	((EntityLivingBase) entity).addPotionEffect(new PotionEffect(Potion.blindness.id, 60, 0));
            	break;
            case 7:
            	((EntityLivingBase) entity).addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 200, 1));
            	((EntityLivingBase) entity).addPotionEffect(new PotionEffect(Potion.blindness.id, 60, 0));
            	break;
            case 8:
            	((EntityLivingBase) entity).addPotionEffect(new PotionEffect(Potion.harm.id, 1, 0));
            	((EntityLivingBase) entity).addPotionEffect(new PotionEffect(Potion.blindness.id, 60, 0));
        }
        
                
		return flag;
	}
	
	@Override
    public boolean attackEntityFrom(DamageSource ds, float i) {
		Entity entity = ds.getEntity();
		if (entity instanceof EntityPlayer)
        {
		int random1 = (int)(1 + Math.random() * 2);
       	 if(random1 == 1 ) {
       		this.playSound("nova_craft:warden_altar.shriek", 2.0F, 0.5F);
               EntitySculkSymbiote symbiote = new EntitySculkSymbiote(this.worldObj);
               symbiote.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
               symbiote.setAttackTarget(this.getAttackTarget());

               if (!this.worldObj.isRemote) {
                   this.worldObj.spawnEntityInWorld(symbiote);
               	}
               
       		}
       	 
       	int random2 = (int)(1 + Math.random() * 10);
      	 if(random2 == 1 ) {
      		this.playSound("nova_craft:warden_altar.shriek", 2.0F, 0.5F);
              EntitySculkHunger abomination = new EntitySculkHunger(this.worldObj);
              abomination.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
              abomination.setAttackTarget(this.getAttackTarget());

              if (!this.worldObj.isRemote) {
                  this.worldObj.spawnEntityInWorld(abomination);
              	}
              
      		}
       	 
       	 int random3 = (int)(1 + Math.random() * 25);
       	 if(random3 == 1 ) {
       		this.playSound("nova_craft:warden_altar.shriek", 2.0F, 0.5F);
               EntitySculkAbomination abomination = new EntitySculkAbomination(this.worldObj);
               abomination.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
               abomination.setAttackTarget(this.getAttackTarget());

               if (!this.worldObj.isRemote) {
                   this.worldObj.spawnEntityInWorld(abomination);
               	}
               
       		}
       	 
       	int random4 = (int)(1 + Math.random() * 200);
      	 if(random4 == 1 ) {
      		this.playSound("nova_craft:warden_altar.shriek", 2.0F, 0.5F);
              EntitySculkDuplicator duplicator = new EntitySculkDuplicator(this.worldObj);
              duplicator.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
              duplicator.setAttackTarget(this.getAttackTarget());

              if (!this.worldObj.isRemote) {
                  this.worldObj.spawnEntityInWorld(duplicator);
              	}
              
      		}   
        }
		
		return super.attackEntityFrom(ds, i);
		
       }
	
	public void onLivingUpdate()
	{		
		if (this.worldObj.isDaytime() && !this.worldObj.isRemote && this.worldObj.provider.dimensionId != 1 && this.worldObj.canBlockSeeTheSky(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ))) {
            this.damageEntity(DamageSource.drown, 2.0f);
            this.setFire(4);
        }	
		super.onLivingUpdate();
	}
	
	public float getBrightness(float p_70013_1_)
	{
		return super.getBrightness(p_70013_1_);
	}
	
	 protected void dropFewItems(boolean p_70628_1_, int p_70628_2_)
	    {
	        int j;
	        int k;
	        {
	            j = this.rand.nextInt(1 + p_70628_2_);

	            for (k = 0; k < j; ++k)
	            {
	                this.dropItem(NovaCraftItems.sculk_flesh, 2 + p_70628_2_);
	            }
	        }
	        
	        {
	        	j = this.rand.nextInt(1 + p_70628_2_);

	        	for (k = 0; k < j; ++k)
	        {
	        	this.dropItem(Item.getItemFromBlock(NovaCraftBlocks.sculk_block), 2 + p_70628_2_);
	        }
	        	
	        	j = this.rand.nextInt(1 + p_70628_2_);
	        	
	        	int rand = (int)(1 + Math.random() * 10);
        		switch (rand)
                {
        		case 1:
	        		break;
        		case 2:
        			break;
        		case 3:
        		this.dropItem((NovaCraftItems.sculk_dweller_heart), 1);
        			break;
        		case 4:
        			break;
        		case 5:
        			break;
        		case 6:
        			break;
        		case 7:
        			break;
        		case 8:
        			break;
        		case 9:
        			break;
        		case 10:
        			break;
                }
	        	
	        }
	        
	    }
	 
	 protected void dropRareDrop(int p_70600_1_)
	    {
		 int rand = (int)(1 + Math.random() * 2);
		 switch (rand)
	        {
	        	case 0:
	        		this.dropItem(NovaCraftItems.anomalous_essence, 1);
	        		break;
	        		
	        }
		 
	    }
	
	public EnumCreatureAttribute getCreatureAttribute()
    {
        return EnumCreatureAttribute.UNDEFINED;
    }
	
	protected String getShriekerSound()
    {
        return "nova_craft:warden_altar.shriek";
    }
	
	/**
     * Returns the sound this mob makes while it's alive.
     */
	@Override
    protected String getLivingSound()
    {
        return "mob.silverfish.say";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
	@Override
    protected String getHurtSound()
    {
        return "mob.silverfish.hit";
    }

    /**
     * Returns the sound this mob makes on death.
     */
	@Override
    protected String getDeathSound()
    {
        return "mob.silverfish.kill";
    }
	
	@Override
    protected float getSoundVolume() {
        return 1.66F;
    }
	

}
