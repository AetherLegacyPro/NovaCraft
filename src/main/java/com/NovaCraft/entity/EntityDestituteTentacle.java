package com.NovaCraft.entity;

import com.NovaCraft.NovaCraft;
import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.entity.misc.EntityDestituteTentacleProjectile;
import com.NovaCraft.entity.misc.EntityWardenProjectile;
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
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityDestituteTentacle extends EntityMob
{			
	public int shootTime;
	
	public EntityDestituteTentacle(final World p_i1745_1_) {
		super(p_i1745_1_);
		setSize(0.6F, 1.0F);
		this.experienceValue = 3;
		this.isJumping = false;
        this.moveStrafing = 0.0F;
        this.moveForward = 0.0F;
        this.randomYawVelocity = 0.0F;
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();

		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(25.0D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(3D);
		this.setHealth(25);
	}
	
	@Override
	public void knockBack(Entity entity, float strength, double xRatio, double zRatio) {
		if (this.getHealth() >= 0) {
			return;
		}

		super.knockBack(entity, strength, xRatio, zRatio);
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
		
		this.addPotionEffect(new PotionEffect(Potion.regeneration.id, 30, 0));        
        int rand = (int)(1 + Math.random() * 2);
		switch (rand)
        {
        	case 1:
            	((EntityLivingBase) entity).addPotionEffect(new PotionEffect(Potion.blindness.id, 60, 0));
                break;         
            case 2:
            	((EntityLivingBase) entity).addPotionEffect(new PotionEffect(Potion.wither.id, 100, 0));
            	break;
        }
        
                
		return flag;
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
	                this.dropItem(NovaCraftItems.destitute_tentacle, 1);
	            }
	        }
	        
	    }
	 
	 @Override
		public void onUpdate() {
			super.onUpdate();

			if (this.entityToAttack instanceof EntityPlayer && this.shouldAttackPlayer((EntityPlayer)this.entityToAttack))
	        {
				
			if (this.getEntityToAttack() != null) {
				if (this.getAttackTarget() instanceof EntityPlayer && ((EntityPlayer) this.getAttackTarget()).capabilities.isCreativeMode) {
					this.setAttackTarget(null);
				}
				else {
					double d = this.getEntityToAttack().posX - this.posX;
					double d1 = this.getEntityToAttack().posZ - this.posZ;

					this.getLookHelper().setLookPositionWithEntity(this.getEntityToAttack(), 30.0F, 30.0F);

					if (this.shootTime >= 10 && this.canEntityBeSeen(this.getEntityToAttack())) {
						this.shootTarget();
						this.shootTime = -20;
					}

					if (this.shootTime < 10) {
						this.shootTime += 5;
					}

					this.rotationYaw = (float) ((Math.atan2(d1, d) * 180D) / 3.1415927410125732D) - 90F;
					}
				
				}
					
			}
						
			if (!this.worldObj.isRemote && this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL) {
				this.setDead();
			}
		}
	 
	 private boolean shouldAttackPlayer(EntityPlayer p_70821_1_)
	    {
	        
	            Vec3 vec3 = p_70821_1_.getLook(1.0F).normalize();
	            Vec3 vec31 = Vec3.createVectorHelper(this.posX - p_70821_1_.posX, this.boundingBox.minY + (double)(this.height / 2.0F) - (p_70821_1_.posY + (double)p_70821_1_.getEyeHeight()), this.posZ - p_70821_1_.posZ);
	            double d0 = vec31.lengthVector();
	            vec31 = vec31.normalize();
	            double d1 = vec3.dotProduct(vec31);
	            return d1 > 1.0D - 0.025D / d0 && p_70821_1_.canEntityBeSeen(this);
	        
	    }

		public void shootTarget() { //shootTarget
			if (this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL) {
				return;
			}		
			
			EntityDestituteTentacleProjectile tentacle = new EntityDestituteTentacleProjectile(this.worldObj, this, 3.0F);
			this.playSound("nova_craft:sculk.break", 2.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));
			this.worldObj.spawnEntityInWorld(tentacle);	
				
			
		}
	 
	
	public EnumCreatureAttribute getCreatureAttribute()
    {
        return EnumCreatureAttribute.UNDEFINED;
    }

	@Override
	protected String getHurtSound() {
		return "nova_craft:sculk.break";
	}

	@Override
	protected String getDeathSound() {
		return "nova_craft:sculk.place";
	}

	@Override
	public boolean canBePushed() {
		return false;
	}

	@Override
	protected boolean canDespawn() {
		return false;
	}
	
	@Override
	 public boolean getCanSpawnHere() {
        final int i = MathHelper.floor_double(this.posX);
        final int j = MathHelper.floor_double(this.boundingBox.minY);
        final int k = MathHelper.floor_double(this.posZ);
        final boolean canSpawn = this.worldObj.checkNoEntityCollision(this.boundingBox) && this.worldObj.getCollidingBoundingBoxes((Entity)this, this.boundingBox).isEmpty() && !this.worldObj.isAnyLiquid(this.boundingBox);          
     return (this.worldObj.getBlock(i, j - 1, k) == NovaCraftBlocks.destitude_block || this.worldObj.getBlock(i, j - 1, k) == NovaCraftBlocks.destitude_growth) && this.worldObj.getBlockLightValue(i, j, k) < 8 && this.posY <= 50.0D && canSpawn;
               
    }

}
