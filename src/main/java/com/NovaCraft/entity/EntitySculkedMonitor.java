package com.NovaCraft.entity;

import java.util.Random;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.entity.misc.EntitySculkedMonitorProjectile;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntitySculkedMonitor extends EntityMob
{	
	public int timeUntilShoot;
	public int courseChangeCooldown;
	public double waypointX, waypointY, waypointZ;
	public int prevAttackCounter;
	public int attackCounter;	
	private final float base;

    public EntitySculkedMonitor(World p_i1743_1_)
    {
        super(p_i1743_1_);
        this.timeUntilShoot = 30;
        this.attackTime = this.timeUntilShoot;
        this.base = (this.getRNG().nextFloat() - this.getRNG().nextFloat()) * 0.2F + 1.0F;
        setSize(1.2F, 1.8F);
    }

    protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(16, new Byte((byte)0));
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
        super.onUpdate();
        
        if (!this.worldObj.isRemote && this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL)
        {
            this.setDead();
        }

        if (!this.worldObj.isRemote)
        {
            this.setBesideClimbableBlock(this.isCollidedHorizontally);
        }
        
        if (this.entityToAttack != null) {
            this.attackEntity(this.entityToAttack, this.getDistanceToEntity(this.entityToAttack));
        }
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
		return flag;
	}

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(8.0D);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(120.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.100000011920929D);
        this.setHealth(120);
    }
    
    public boolean canBreatheUnderwater()
    {
        return true;
    }
    
    public int getTotalArmorValue()
    {
        return 8;
    }

    /**
     * Finds the closest player within 16 blocks to attack, or null if this Entity isn't interested in attacking
     * (Animals, Spiders at day, peaceful PigZombies).
     */
    protected Entity findPlayerToAttack()
    {
        float f = this.getBrightness(1.0F);

        if (f < 0.5F)
        {
            double d0 = 32.0D;
            return this.worldObj.getClosestVulnerablePlayerToEntity(this, d0);
        }
        else
        {
            return null;
        }
    }

    /**
     * Returns the sound this mob makes while it's alive.
     */
    protected String getLivingSound()
    {
        return "nova_craft:overworld_lizard.living";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        return "nova_craft:overworld_lizard.hurt";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return "nova_craft:overworld_lizard.hurt";
    }

    /**
     * Basic mob attack. Default to touch of death in EntityCreature. Overridden by each mob to define their attack.
     */
    protected void attackEntity(Entity p_70785_1_, float p_70785_2_)
    {
        float f1 = this.getBrightness(1.0F);

        if (f1 > 0.5F && this.rand.nextInt(100) == 0)
        {
            this.entityToAttack = null;
        }
        else
        {
            if (p_70785_2_ > 2.0F && p_70785_2_ < 6.0F && this.rand.nextInt(10) == 0)
            {
                if (this.onGround)
                {
                    double d0 = p_70785_1_.posX - this.posX;
                    double d1 = p_70785_1_.posZ - this.posZ;
                    float f2 = MathHelper.sqrt_double(d0 * d0 + d1 * d1);
                    this.motionX = d0 / (double)f2 * 0.5D * 0.800000011920929D + this.motionX * 0.20000000298023224D;
                    this.motionZ = d1 / (double)f2 * 0.5D * 0.800000011920929D + this.motionZ * 0.20000000298023224D;
                    this.motionY = 0.4000000059604645D;
                }
            }
            else
            {
                super.attackEntity(p_70785_1_, p_70785_2_);
            }
        }
        
        if (p_70785_1_ instanceof EntityLivingBase) {
			if (p_70785_2_ < 10.0f) {
                final double d = p_70785_1_.posX - this.posX;
                final double d2 = p_70785_1_.posZ - this.posZ;
                if (p_70785_1_ != null) {
                    if (p_70785_1_.isDead || p_70785_1_.getDistanceToEntity(this) > 12.0 || p_70785_1_ instanceof EntitySculkedMonitor) {
                    	p_70785_1_ = null;
                        this.entityToAttack = null;
                        return;
                    }
                    if (this.attackTime >= this.timeUntilShoot) {
                        this.shootTarget((EntityLivingBase) p_70785_1_);
                    }
                    if (this.attackTime >= this.timeUntilShoot && this.canEntityBeSeen(p_70785_1_)) {
                        this.attackTime = -10;
                    }
                    if (this.attackTime < this.timeUntilShoot) {
                        ++this.attackTime;
                    }
                }
                this.rotationYaw = (float)(Math.atan2(d2, d) * 180.0 / 3.1415927410125732) - 90.0f;
            }
        }
    }
    
    @Override
   	protected void updateEntityActionState()
   	{
   	
   		if (!this.worldObj.isRemote && this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL)
   		{
   			this.setDead();
   		}
                                   
   		this.despawnEntity();
   		this.prevAttackCounter = this.attackCounter;
   		double d0 = this.waypointX - this.posX;
   		double d1 = this.waypointY - this.posY;
   		double d2 = this.waypointZ - this.posZ;
   		double d3 = d0 * d0 + d1 * d1 + d2 * d2;
   		
   		
   		if (d3 < 1.0D || d3 > 3600.0D)
   		{
   			this.waypointX = this.posX + (double)((this.rand.nextFloat() * 2.0F - 1.0F) * 16.0F);
   			this.waypointY = this.posY + (double)((this.rand.nextFloat() * 2.0F - 1.0F) * 16.0F);
   			this.waypointZ = this.posZ + (double)((this.rand.nextFloat() * 2.0F - 1.0F) * 16.0F);
   		}

   		if (this.courseChangeCooldown-- <= 0)
   		{
   			this.courseChangeCooldown += this.rand.nextInt(5) + 2;
   			d3 = MathHelper.sqrt_double(d3);

   			if (this.isCourseTraversable(this.waypointX, this.waypointY, this.waypointZ, d3))
   			{
   				this.motionX += d0 / d3 * 0.1D;
   				this.motionY += d1 / d3 * 0.1D;
   				this.motionZ += d2 / d3 * 0.1D;
   			}
   			else
   			{
   				this.waypointX = this.posX;
   				this.waypointY = this.posY;
   				this.waypointZ = this.posZ;
   			}
   		}

   		this.prevAttackCounter = this.attackCounter;

   		if (this.getAttackTarget() == null) {
   			if (this.attackCounter > 0) {
   				this.attackCounter--;
   			}

   			this.setAttackTarget(this.worldObj.getClosestVulnerablePlayerToEntity(this, 40D));
   		} else {
   			if (this.getAttackTarget() instanceof EntityPlayer && (((EntityPlayer) this.getAttackTarget()).capabilities.isCreativeMode)) {
   				this.setAttackTarget(null);
   				return;
   			}

   			if (this.getAttackTarget().getDistanceSqToEntity(this) < 4096.0D && this.canEntityBeSeen(this.getAttackTarget())) {
   				double x = this.getAttackTarget().posX - this.posX;
   				double y = (this.getAttackTarget().boundingBox.minY + (this.getAttackTarget().height / 2.0F)) - (this.posY + (this.height / 2.0F));
   				double z = this.getAttackTarget().posZ - this.posZ;

   				this.rotationYaw = (-(float) Math.atan2(x, z) * 180F) / 3.141593F;

   				++this.attackCounter;

   				if (this.attackCounter == 20) {
   					this.playSound("nova_craft:overworld_lizard.hurt", 1F, this.base);
   				} else if (this.attackCounter == 40) {
   					this.playSound("nova_craft:overworld_lizard.hurt", 1F, this.base);

   					EntitySculkedMonitorProjectile projectile = new EntitySculkedMonitorProjectile(this.worldObj, this, x, y, z);
   			            
   					Vec3 lookVector = this.getLook(1.0F);

   					projectile.posX = this.posX + lookVector.xCoord * 4D;
   					projectile.posY = this.posY + (double) (this.height / 2.0F) + 0.5D;
   					projectile.posZ = this.posZ + lookVector.zCoord * 4D;

   					if (!this.worldObj.isRemote) {
   						projectile.setThrowableHeading(x, y, z, 1.2F, 1.0F);
   						this.worldObj.spawnEntityInWorld(projectile);
   					}

   					this.attackCounter = -40;
   				}
   			} else if (this.attackCounter > 0) {
   				this.attackCounter--;
   					}           
   			
   		}
   	}
       
    private boolean isCourseTraversable(double p_70790_1_, double p_70790_3_, double p_70790_5_, double p_70790_7_)
   	{
   		double d4 = (this.waypointX - this.posX) / p_70790_7_;
   		double d5 = (this.waypointY - this.posY) / p_70790_7_;
   		double d6 = (this.waypointZ - this.posZ) / p_70790_7_;
   		AxisAlignedBB axisalignedbb = this.boundingBox.copy();

   		for (int i = 1; (double)i < p_70790_7_; ++i)
   		{
   			axisalignedbb.offset(d4, d5, d6);

   			if (!this.worldObj.getCollidingBoundingBoxes(this, axisalignedbb).isEmpty())
   			{
   				return false;
   			}
   		}

   		return true;
   	}
    
    public void shootTarget(final EntityLivingBase target) {
        if (this.worldObj.difficultySetting.getDifficultyId() == 0) {
            return;
        }
        final double d5 = target.posX - this.posX;
        final double d6 = target.boundingBox.minY + target.height / 2.0f - (this.posY + this.height / 2.0f);
        final double d7 = target.posZ - this.posZ;
        final EntitySculkedMonitorProjectile projectile = new EntitySculkedMonitorProjectile(this.worldObj, this, d5, d6, d7);
        projectile.posY = this.posY + 1.0;
        this.worldObj.playSoundAtEntity(this, "nova_craft:overworld_lizard.hurt", 2.0f, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f + 1.0f);
        if (!this.worldObj.isRemote) {
            this.worldObj.spawnEntityInWorld(projectile);
        }
    }

    protected Item getDropItem()
    {
        return NovaCraftItems.sculked_monitor_scales;
    }

    /**
     * Drop 0-2 items of this living's type. @param par1 - Whether this entity has recently been hit by a player. @param
     * par2 - Level of Looting used to kill this mob.
     */
    protected void dropFewItems(boolean p_70628_1_, int p_70628_2_)
    {
        super.dropFewItems(p_70628_1_, p_70628_2_);
        
        if (p_70628_1_ && (this.rand.nextInt(5) == 0 || this.rand.nextInt(1 + p_70628_2_) > 0))
        {
            this.dropItem(NovaCraftItems.sculk_dweller_heart, 1);
        }

        if (p_70628_1_ && (this.rand.nextInt(3) == 0 || this.rand.nextInt(1 + p_70628_2_) > 0))
        {
            this.dropItem(NovaCraftItems.sculked_monitor_eye, 1);
        }
    }

    /**
     * returns true if this entity is by a ladder, false otherwise
     */
    public boolean isOnLadder()
    {
        return this.isBesideClimbableBlock();
    }

    /**
     * Sets the Entity inside a web block.
     */
    public void setInWeb() {}

    /**
     * Get this Entity's EnumCreatureAttribute
     */
    public EnumCreatureAttribute getCreatureAttribute()
    {
        return EnumCreatureAttribute.UNDEFINED;
    }

    public boolean isPotionApplicable(PotionEffect p_70687_1_)
    {
        return p_70687_1_.getPotionID() == Potion.poison.id ? false : super.isPotionApplicable(p_70687_1_);
    }

    /**
     * Returns true if the WatchableObject (Byte) is 0x01 otherwise returns false. The WatchableObject is updated using
     * setBesideClimableBlock.
     */
    public boolean isBesideClimbableBlock()
    {
        return (this.dataWatcher.getWatchableObjectByte(16) & 1) != 0;
    }

    /**
     * Updates the WatchableObject (Byte) created in entityInit(), setting it to 0x01 if par1 is true or 0x00 if it is
     * false.
     */
    public void setBesideClimbableBlock(boolean p_70839_1_)
    {
        byte b0 = this.dataWatcher.getWatchableObjectByte(16);

        if (p_70839_1_)
        {
            b0 = (byte)(b0 | 1);
        }
        else
        {
            b0 &= -2;
        }

        this.dataWatcher.updateObject(16, Byte.valueOf(b0));
    }

    public static class GroupData implements IEntityLivingData
        {
            public int field_111105_a;
            private static final String __OBFID = "CL_00001700";

            public void func_111104_a(Random p_111104_1_)
            {
                int i = p_111104_1_.nextInt(5);

                if (i <= 1)
                {
                    this.field_111105_a = Potion.moveSpeed.id;
                }
                else if (i <= 2)
                {
                    this.field_111105_a = Potion.damageBoost.id;
                }
                else if (i <= 3)
                {
                    this.field_111105_a = Potion.regeneration.id;
                }
                else if (i <= 4)
                {
                    this.field_111105_a = Potion.invisibility.id;
                }
            }
        }
}
