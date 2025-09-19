package com.NovaCraft.entity;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.achievements.AchievementsNovaCraft;
import com.NovaCraft.config.Configs;
import com.NovaCraft.particles.ParticleHandler;
import com.NovaCraftBlocks.NovaCraftBlocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityEnderAvis extends EntityAnimal {

    public float wingFold;

    public float wingAngle;

    private float aimingForFold;

    public int jumpsRemaining;

    private int ticks;
    
    public int ticksFlying;
    
    public float wingRotation, destPos, prevDestPos, prevWingRotation;
    
    protected int ticksUntilFlap;
    
    protected float jumpPower;

	protected int field_110285_bP;

	protected boolean mountJumping;

	protected boolean playStepSound = false;

	protected boolean canJumpMidAir = false;

    public EntityEnderAvis(World world) {
        super(world);
        
        this.ticksFlying = 0;
        this.ticks = 0;
        this.jumpsRemaining = 0;
        this.stepHeight = 1.0F;
        this.ignoreFrustumCheck = true;
        this.canJumpMidAir = true;

        this.setSize(0.9F, 1.3F);
        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 2.0D));
        this.tasks.addTask(3, new EntityAIMate(this, 1.0D));
        this.tasks.addTask(3, new EntityAITempt(this, 1.25D, NovaCraftItems.nullwart, false));
        this.tasks.addTask(4, new EntityAIFollowParent(this, 1.25D));
        this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(7, new EntityAILookIdle(this));
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.20000000298023224D);
    }
    
    @Override
	public void entityInit() {
		super.entityInit();

		this.dataWatcher.addObject(17, new Byte((byte) 0));
		this.dataWatcher.addObject(18, new Byte((byte) 0));
		this.dataWatcher.addObject(19, new Byte((byte) 0));
	}
    
    @Override
	public boolean interact(EntityPlayer entityplayer) {
		if (!this.canSaddle()) {
			return super.interact(entityplayer);
		}

		if (!this.isSaddled()) {
			if (entityplayer.inventory.getCurrentItem() != null && (entityplayer.inventory.getCurrentItem().getItem() == Items.saddle) && !this.isChild()) {
				if (!entityplayer.capabilities.isCreativeMode) {
					entityplayer.inventory.setInventorySlotContents(entityplayer.inventory.currentItem, null);
				}

				if (entityplayer.worldObj.isRemote) {
					entityplayer.worldObj.playSoundAtEntity(this, "mob.horse.leather", 0.5F, 1.0F);
				}

				this.setSaddled(true);

				return true;
			}
		} else if (this.riddenByEntity == null) {
			if (!entityplayer.worldObj.isRemote) {
				entityplayer.mountEntity(this);
				entityplayer.triggerAchievement(AchievementsNovaCraft.end_transportation);
				entityplayer.prevRotationYaw = entityplayer.rotationYaw = this.rotationYaw;
			}

			return true;
		}

		return super.interact(entityplayer);
	}
    
    @Override
	public boolean attackEntityFrom(DamageSource damagesource, float i) {
		if ((damagesource.getEntity() instanceof EntityPlayer) && (this.riddenByEntity == damagesource.getEntity())) {
			return false;
		}

		return super.attackEntityFrom(damagesource, i);
	}
    
    @Override
	public boolean isEntityInsideOpaqueBlock() {
		return this.riddenByEntity != null ? false : super.isEntityInsideOpaqueBlock();
	}

	@Override
	public boolean shouldRiderFaceForward(EntityPlayer player) {
		return false;
	}

	@Override
	protected boolean canTriggerWalking() {
		return this.onGround;
	}

	@Override
	public boolean canBeSteered() {
		return true;
	}
	
	public void setSaddled(boolean saddled) {
		this.dataWatcher.updateObject(19, (byte) (saddled ? 1 : 0));
	}

	public boolean isSaddled() {
		return this.dataWatcher.getWatchableObjectByte(19) == (byte) 1;
	}

	public boolean canSaddle() {
		return true;
	}
	
	@Override
	public boolean canRiderInteract() {
		return true;
	}

	@Override
	public boolean shouldDismountInWater(Entity rider) {
		return false;
	}
	
	public boolean isOnGround() {
		return this.dataWatcher.getWatchableObjectByte(17) == (byte) 1;
	}

	private void setOnGround(boolean onGround) {
		this.dataWatcher.updateObject(17, (byte) (onGround ? 1 : 0));
	}

	public boolean isRiderSneaking() {
		return this.dataWatcher.getWatchableObjectByte(18) == (byte) 1;
	}

	public void setRiderSneaking(boolean riderSneaking) {
		this.dataWatcher.updateObject(18, (byte) (riderSneaking ? 1 : 0));
	}

    @Override
    public void onUpdate() {
        super.onUpdate();

        if (this.isJumping) {
            this.motionY += 0.05F;
        }

        this.updateWingRotation();
        this.fall();
        
        this.fallDistance = 0;
        
        if (!this.worldObj.isRemote) {
			if (this.onGround != this.isOnGround()) {
				this.setOnGround(this.onGround);
			}

			this.updateRider();
		}
    }
    
    public void updateRider() {
		if (this.canDismount() && this.riddenByEntity instanceof EntityPlayer) {
				if (this.onGround) {
					this.riddenByEntity.mountEntity(null);
					
				this.setRiderSneaking(true);
			} else {
				this.setRiderSneaking(false);
			}
		}
	}
    
    private float updateRotation(float angle, float targetAngle, float maxIncrease) {
		float f = MathHelper.wrapAngleTo180_float(targetAngle - angle);

		if (f > maxIncrease) {
			f = maxIncrease;
		}

		if (f < -maxIncrease) {
			f = -maxIncrease;
		}

		return angle + f;
	}
    
    @Override
	public void moveEntityWithHeading(float par1, float par2) {
		Entity entity = this.riddenByEntity;

		if (entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entity;

			this.prevRotationYaw = this.rotationYaw = player.rotationYaw;
			this.prevRotationPitch = this.rotationPitch = player.rotationPitch;

			this.rotationYawHead = player.rotationYawHead;

			par1 = player.moveStrafing;
			par2 = player.moveForward;

			if (par2 <= 0.0F) {
				par2 *= 0.25F;
				this.field_110285_bP = 0;
			}

			double d01 = player.posX - this.posX;
			double d2 = player.posZ - this.posZ;

			float f = (float) (Math.atan2(d2, d01) * (180D / Math.PI)) - 90.0F;

			if (player.moveStrafing != 0.0F && player.worldObj.isRemote) {
				this.rotationYaw = this.updateRotation(this.rotationYaw, f, 40.0F);
			}

				onMountedJump(par1, par2);

			if (this.jumpPower > 0.0F && !this.isMountJumping() && (this.onGround || this.canJumpMidAir)) {
				this.motionY = this.getMountJumpStrength() * (double) this.jumpPower;

				if (this.isPotionActive(Potion.jump)) {
					this.motionY += (double) ((float) (this.getActivePotionEffect(Potion.jump).getAmplifier() + 1) * 0.1F);
				}

				this.setMountJumping(true);
				this.isAirBorne = true;

				this.jumpPower = 0.0F;

				if (!this.worldObj.isRemote) {
					this.moveEntity(this.motionX, this.motionY, this.motionZ);
				}
			}

			this.motionX *= 0.35F;
			this.motionZ *= 0.35F;

			this.stepHeight = 1.0F;

			if (!this.worldObj.isRemote) {
				this.jumpMovementFactor = this.getAIMoveSpeed() * 0.6F;
				super.moveEntityWithHeading(par1, par2);
			}

			if (this.onGround) {
				this.jumpPower = 0.0F;
				this.setMountJumping(false);
			}

			this.prevLimbSwingAmount = this.limbSwingAmount;
			double d0 = this.posX - this.prevPosX;
			double d1 = this.posZ - this.prevPosZ;
			float f4 = MathHelper.sqrt_double(d0 * d0 + d1 * d1) * 4.0F;

			if (f4 > 1.0F) {
				f4 = 1.0F;
			}

			this.limbSwingAmount += (f4 - this.limbSwingAmount) * 0.4F;
			this.limbSwing += this.limbSwingAmount;
		} else {
			this.stepHeight = 0.5F;
			this.jumpMovementFactor = 0.02F;
			super.moveEntityWithHeading(par1, par2);
		}
	}
    
    @Override
	public float getAIMoveSpeed() {
		return this.riddenByEntity != null ? this.getMountedMoveSpeed() : super.getAIMoveSpeed();
	}

	protected void setMountJumping(boolean mountJumping) {
		this.mountJumping = mountJumping;
	}

	protected boolean isMountJumping() {
		return this.mountJumping;
	}

	public void onMountedJump(float par1, float par2) {
		this.jumpPower = 0.4F;
	}

	public boolean canDismount() {
		return true;
	}
    
    @SideOnly(Side.CLIENT)
    public void onEntityUpdate() {
    	super.onEntityUpdate();
    	if (this.worldObj.isRemote) {
    		
    		if (net.minecraft.client.Minecraft.getMinecraft().gameSettings.particleSetting == 2) {
    			return;
    		}
    		
    	int k;    
            for (k = 0; k < 1; ++k)
            {
            	ParticleHandler.AVIS.spawn(worldObj, this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height + 0.25D, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width);
            }
            
            for (k = 0; k < 3; ++k)
            {
                this.worldObj.spawnParticle("portal", this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height - 0.25D, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, (this.rand.nextDouble() - 0.5D) * 2.0D, -this.rand.nextDouble(), (this.rand.nextDouble() - 0.5D) * 2.0D);
            }   	  
    	}
    }
    
    public void updateWingRotation() {
        if (!this.onGround) {
            if (this.ticksFlying == 0) {
                this.worldObj.playSoundAtEntity(this, "nova_craft:phantom.flap", 0.15F, MathHelper.clamp_float(this.rand.nextFloat(), 0.7f, 1.0f) + MathHelper.clamp_float(this.rand.nextFloat(), 0f, 0.3f));

                this.ticksFlying = 8;
            } else {
                this.ticksFlying--;
            }
        }

        this.prevWingRotation = this.wingRotation;
        this.prevDestPos = this.destPos;

        this.destPos += 0.2D;
        this.destPos = minMax(0.01F, 1.0F, this.destPos);

        if (this.isOnGround()) {
            this.destPos = 0.0F;
        }

        this.wingRotation += 1.233F;
    }
    
    public static float minMax(float min, float max, float value) {
        return Math.min(max, Math.max(min, value));
    }

    @Override
    public double getMountedYOffset() {
        return 1.15D;
    }

    public float getMountedMoveSpeed() {
        return 0.6F;
    }

    @Override
    protected void jump() {
        if (this.riddenByEntity == null) {
            super.jump();
        }
    }

    private void fall() {
        if (!this.onGround) {
            if (this.motionY < 0.0D && !this.isRiderSneaking()) {
                this.motionY *= 0.1D;
            }
        }
    }

    /**
     * Returns the sound this mob makes while it's alive.
     */
	@Override
    protected String getLivingSound()
    {
        return "nova_craft:ender_avis.living";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
	@Override
    protected String getHurtSound()
    {
        return "nova_craft:ender_avis.death";
    }

    /**
     * Returns the sound this mob makes on death.
     */
	@Override
    protected String getDeathSound()
    {
        return "nova_craft:ender_avis.death";
    }

    @Override
    protected float getSoundVolume() {
        return 0.9F;
    }

    @Override
    protected void func_145780_a(int x, int y, int z, Block block) {
        this.playSound("mob.cow.step", 0.05F, 1.0F);
    }

    @Override
    protected void dropFewItems(boolean recentlyHit, int lootLevel) {
        int j = this.rand.nextInt(3) + this.rand.nextInt(1 + lootLevel);
        int k;

        for (k = 0; k < j; ++k) {
            this.dropItem(NovaCraftItems.enderavis_feather, 1);
        }

        j = this.rand.nextInt(3) + 1 + this.rand.nextInt(1 + lootLevel);

        for (k = 0; k < j; ++k) {
            if (this.isBurning()) {
                this.dropItem(NovaCraftItems.cooked_enderavis, 1);
            } else {
                this.dropItem(NovaCraftItems.raw_enderavis, 1);
            }
        }
        
        if (this.isSaddled()) {
			this.dropItem(Items.saddle, 1);
		}

        super.dropFewItems(recentlyHit, lootLevel);
    }

    protected double getMountJumpStrength() {
        return 1.0D;
    }
    
    @Override
	public void writeEntityToNBT(NBTTagCompound compound) {
		super.writeEntityToNBT(compound);

		compound.setBoolean("isSaddled", this.isSaddled());
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);

		this.setSaddled(compound.getBoolean("isSaddled"));
	}

    public EntityEnderAvis createChild(EntityAgeable p_90011_1_)
    {
    	EntityEnderAvis avis = new EntityEnderAvis(this.worldObj);

        return avis;
    }
    
    public boolean getCanSpawnHere() {
        final int i = MathHelper.floor_double(this.posX);
        final int j = MathHelper.floor_double(this.boundingBox.minY);
        final int k = MathHelper.floor_double(this.posZ);
        final boolean canSpawn = this.worldObj.checkNoEntityCollision(this.boundingBox) && this.worldObj.getCollidingBoundingBoxes((Entity)this, this.boundingBox).isEmpty() && !this.worldObj.isAnyLiquid(this.boundingBox);          
        return this.worldObj.getBlockLightValue(i, j, k) == 0 && canSpawn;
               
    }

}