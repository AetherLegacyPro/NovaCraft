package com.NovaCraft.entity;

import net.minecraft.entity.monster.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.ai.*;
import net.minecraft.world.*;
import net.minecraft.util.*;

import java.util.Random;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.config.Configs;
import com.NovaCraft.entity.misc.EntitySculkLaser;
import com.NovaCraft.particles.ParticleHandler;
import com.NovaCraftBlocks.NovaCraftBlocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.nbt.NBTTagCompound;

public class EntitySculkIncinerator extends EntityFlying implements IMob
{
    public int flapSoundTime;
    public int courseChangeCooldown;
    public int courseChangeCooldown2;
    private int field_82222_j;
	private int[] field_82224_i = new int[2];
    public double waypointX;
    public double waypointY;
    public double waypointZ;
    private EntityLivingBase targetedEntity;
    private int targetObstructedTicks;
    public float animTime;
    public float prevAnimTime;
    private int aggroCooldown;
    public int prevAttackCounter;
    public int attackCounter;
    private final float base;
    
    public EntitySculkIncinerator(final World p_i1731_1_) {
        super(p_i1731_1_);
        this.targetObstructedTicks = 0;
        this.tasks.addTask(0, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 30.0f));
        this.tasks.addTask(1, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.setSize(2.0f, 2.0f);
        this.experienceValue = 5;
        this.base = (this.getRNG().nextFloat() - this.getRNG().nextFloat()) * 0.2F + 1.0F;
    }
    
    protected boolean canTriggerWalking() {
        return false;
    }
    
    public boolean doesEntityNotTriggerPressurePlate() {
        return true;
    }
    
    public void onUpdate() {
        super.onUpdate();
        
        if (!this.worldObj.isRemote && this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL)
        {
            this.setDead();
        }
        
        if (!this.worldObj.isRemote) {
            if (this.motionY < 0.0 && this.posX != this.waypointX && this.posZ != this.waypointZ && this.targetedEntity == null) {
                this.motionY *= 1.0;
                this.motionX *= 1.0;
                this.motionZ *= 1.0;
            }
            if (this.targetedEntity != null) {
                if (this.targetedEntity instanceof EntityPlayer) {
                    if (!this.getEntitySenses().canSee((Entity)this.targetedEntity)) {
                        ++this.targetObstructedTicks;
                    }
                    else {
                        this.targetObstructedTicks = 0;
                    }
                }
                if (((EntityPlayer)this.targetedEntity).capabilities.isCreativeMode || this.targetObstructedTicks > 100) {
                    this.targetObstructedTicks = 0;
                    this.targetedEntity = null;
                }
                else {
                    final double standOffX = this.targetedEntity.posX;
                    final double standOffZ = this.targetedEntity.posZ;
                    this.waypointX = standOffX;
                    this.waypointY = this.targetedEntity.posY + 1.0 - this.rand.nextFloat() * 0.3f;
                    this.waypointZ = standOffZ;
                }
            }
            
        }
    }
    
    public void onLivingUpdate()
	{		
		if (this.worldObj.isDaytime() && !this.worldObj.isRemote && this.worldObj.provider.dimensionId != 1 && this.worldObj.canBlockSeeTheSky(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ))) {
            this.damageEntity(DamageSource.drown, 1.0f);
            this.setFire(1);
        }
		
		super.onLivingUpdate();
	}
    
    @Override
    public boolean attackEntityFrom(DamageSource source, float amount)
    {
		if (source == DamageSource.wither || source == DamageSource.inWall || source == DamageSource.cactus)
        {
            return false;
        }
		
		else
        {
            if (this.field_82222_j <= 0)
            {
                this.field_82222_j = 20;
            }

            for (int i = 0; i < this.field_82224_i.length; ++i)
            {
                this.field_82224_i[i] += 3;
            }

            return super.attackEntityFrom(source, amount);
        }
		
    }
    
    protected void updateEntityActionState() {
        super.updateEntityActionState();
        double distanceX = this.waypointX - this.posX;
        double distanceY = this.waypointY - this.posY;
        double distanceZ = this.waypointZ - this.posZ;
        double distanceScaled = distanceX * distanceX + distanceY * distanceY + distanceZ * distanceZ;
        if (distanceScaled < 1.0 || distanceScaled > 3600.0) {
            this.waypointX = this.posX + (this.rand.nextFloat() * 2.0f - 1.0f) * 16.0f;
            this.waypointY = this.posY + (this.rand.nextFloat() * 2.0f - 1.0f) * 16.0f;
            this.waypointZ = this.posZ + (this.rand.nextFloat() * 2.0f - 1.0f) * 16.0f;
        }
        if (this.courseChangeCooldown2-- <= 0) {
            this.courseChangeCooldown2 += this.rand.nextInt(5) + 10;
            distanceScaled = MathHelper.sqrt_double(distanceScaled);
            if (this.isCourseTraversable(this.waypointX, this.waypointY, this.waypointZ, distanceScaled)) {
                this.motionX += distanceX / distanceScaled * 0.2;
                this.motionY += distanceY / distanceScaled * 0.2;
                this.motionZ += distanceZ / distanceScaled * 0.2;
            }
            else if (this.targetedEntity != null) {
                this.motionX += distanceX / distanceScaled * 0.2;
                this.motionY += distanceY / distanceScaled * 0.2;
                this.motionZ += distanceZ / distanceScaled * 0.2;
            }
            else {
                this.waypointX = this.posX;
                this.waypointY = this.posY;
                this.waypointZ = this.posZ;
            }
        }
        if (this.targetedEntity != null && this.targetedEntity.isDead) {
            this.targetedEntity = null;
        }
        this.getEntitySenses().clearSensingCache();
        if (this.targetedEntity == null) {
            this.targetedEntity = (EntityLivingBase)this.getClosestVulnerableVisiblePlayer(30.0);
        }
        if (this.targetedEntity != null) {
            distanceX = this.targetedEntity.posX - this.posX;
            distanceY = this.targetedEntity.boundingBox.minY + this.targetedEntity.height / 2.0f - (this.posY + this.height / 2.0f);
            distanceZ = this.targetedEntity.posZ - this.posZ;
            final float n = -(float)Math.atan2(distanceX, distanceZ) * 180.0f / 3.1415927f;
            this.rotationYaw = n;
            this.renderYawOffset = n;
        }
        else {
            final float n2 = -(float)Math.atan2(this.motionX, this.motionZ) * 180.0f / 3.1415927f;
            this.rotationYaw = n2;
            this.renderYawOffset = n2;
        }
        
        
        
        //new

        double d4 = 256.0D; //128
        this.prevAttackCounter = this.attackCounter;

		if (this.getAttackTarget() == null) {
			if (this.attackCounter > 0) {
				this.attackCounter--;
			}

			this.setAttackTarget(this.worldObj.getClosestVulnerablePlayerToEntity(this, 30D));
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
				if (this.attackCounter == 5) {
					this.playSound("nova_craft:sculk_laser.charge", 1F, this.base);
					
				}
				else if (this.attackCounter == 40) {
					this.playSound("nova_craft:sculk_laser.laser_fire", 1F, this.base);
					
					for (int j = 0; j < 9; ++j) {						
					switch(j) {
						case 0: EntitySculkLaser projectile = new EntitySculkLaser(this.worldObj, x, y, z);
						Vec3 lookVector = this.getLook(1.0F);

						projectile.posX = this.posX + lookVector.xCoord * 4D; //4
						projectile.posY = this.posY + (double) (this.height / 2.0F) + 1.0D;
						projectile.posZ = this.posZ + lookVector.zCoord * 4D;

						if (!this.worldObj.isRemote) {
							projectile.setThrowableHeading(x, y, z, 1.2F, 1.0F);
							this.worldObj.spawnEntityInWorld(projectile);
						}
						case 1: EntitySculkLaser projectile1 = new EntitySculkLaser(this.worldObj, x, y, z);
							Vec3 lookVector1 = this.getLook(1.0F);

							projectile1.posX = this.posX + lookVector1.xCoord * 4D + 1.0D;
							projectile1.posY = this.posY + (double) (this.height / 2.0F) + 0.5D;
							projectile1.posZ = this.posZ + lookVector1.zCoord * 4D;

							if (!this.worldObj.isRemote) {
								projectile1.setThrowableHeading(x, y, z, 1.2F, 1.0F);
								this.worldObj.spawnEntityInWorld(projectile1);
							}
						case 2: EntitySculkLaser projectile2 = new EntitySculkLaser(this.worldObj, x, y, z);
						Vec3 lookVector2 = this.getLook(1.0F);

						projectile2.posX = this.posX + lookVector2.xCoord * 4D - 1.0D;
						projectile2.posY = this.posY + (double) (this.height / 2.0F) + 0.5D;
						projectile2.posZ = this.posZ + lookVector2.zCoord * 4D;

						if (!this.worldObj.isRemote) {
							projectile2.setThrowableHeading(x, y, z, 1.2F, 1.0F);
							this.worldObj.spawnEntityInWorld(projectile2);
						}
						case 3: EntitySculkLaser projectile3 = new EntitySculkLaser(this.worldObj, x, y, z);
						Vec3 lookVector3 = this.getLook(1.0F);

						projectile3.posX = this.posX + lookVector3.xCoord * 4D;
						projectile3.posY = this.posY + (double) (this.height / 2.0F) + 0.5D;
						projectile3.posZ = this.posZ + lookVector3.zCoord * 4D + 1.0D;

						if (!this.worldObj.isRemote) {
							projectile3.setThrowableHeading(x, y, z, 1.2F, 1.0F);
							this.worldObj.spawnEntityInWorld(projectile3);
						}
						case 4: EntitySculkLaser projectile4 = new EntitySculkLaser(this.worldObj, x, y, z);
						Vec3 lookVector4 = this.getLook(1.0F);

						projectile4.posX = this.posX + lookVector4.xCoord * 4D;
						projectile4.posY = this.posY + (double) (this.height / 2.0F) + 0.5D;
						projectile4.posZ = this.posZ + lookVector4.zCoord * 4D - 1.0D;

						if (!this.worldObj.isRemote) {
							projectile4.setThrowableHeading(x, y, z, 1.2F, 1.0F);
							this.worldObj.spawnEntityInWorld(projectile4);
						}
						case 5: EntitySculkLaser projectile5 = new EntitySculkLaser(this.worldObj, x, y, z);
						Vec3 lookVector5 = this.getLook(1.0F);

						projectile5.posX = this.posX + lookVector5.xCoord * 4D + 1.0D;
						projectile5.posY = this.posY + (double) (this.height / 2.0F) + 0.5D;
						projectile5.posZ = this.posZ + lookVector5.zCoord * 4D - 1.0D;

						if (!this.worldObj.isRemote) {
							projectile5.setThrowableHeading(x, y, z, 1.2F, 1.0F);
							this.worldObj.spawnEntityInWorld(projectile5);
						}
						case 6: EntitySculkLaser projectile6 = new EntitySculkLaser(this.worldObj, x, y, z);
						Vec3 lookVector6 = this.getLook(1.0F);

						projectile6.posX = this.posX + lookVector6.xCoord * 4D + 1.25D;
						projectile6.posY = this.posY + (double) (this.height / 2.0F) + 0.5D;
						projectile6.posZ = this.posZ + lookVector6.zCoord * 4D - 1.25D;

						if (!this.worldObj.isRemote) {
							projectile6.setThrowableHeading(x, y, z, 1.2F, 1.0F);
							this.worldObj.spawnEntityInWorld(projectile6);
						}
						case 7: EntitySculkLaser projectile7 = new EntitySculkLaser(this.worldObj, x, y, z);
						Vec3 lookVector7 = this.getLook(1.0F);

						projectile7.posX = this.posX + lookVector7.xCoord * 4D - 1.0D;
						projectile7.posY = this.posY + (double) (this.height / 2.0F) + 0.5D;
						projectile7.posZ = this.posZ + lookVector7.zCoord * 4D + 1.0D;

						if (!this.worldObj.isRemote) {
							projectile7.setThrowableHeading(x, y, z, 1.2F, 1.0F);
							this.worldObj.spawnEntityInWorld(projectile7);
						}
						case 8: EntitySculkLaser projectile8 = new EntitySculkLaser(this.worldObj, x, y, z);
						Vec3 lookVector8 = this.getLook(1.0F);

						projectile8.posX = this.posX + lookVector8.xCoord * 4D + 1.25D;
						projectile8.posY = this.posY + (double) (this.height / 2.0F) + 0.5D;
						projectile8.posZ = this.posZ + lookVector8.zCoord * 4D - 1.25D;

						if (!this.worldObj.isRemote) {
							projectile8.setThrowableHeading(x, y, z, 1.2F, 1.0F);
							this.worldObj.spawnEntityInWorld(projectile8);
						}
						default: this.attackCounter = -60;
						
					}
												
					}
				}
			} else if (this.attackCounter > 0) {
				this.attackCounter--;
			}
			
		}
    }
    
    public EntityPlayer getClosestVulnerableVisiblePlayer(final double p_72846_7_) {
        double d4 = -1.0;
        EntityPlayer entityplayer = null;
        for (int i = 0; i < this.worldObj.playerEntities.size(); ++i) {
            final EntityPlayer entityplayer2 = (EntityPlayer) this.worldObj.playerEntities.get(i);
            if (!entityplayer2.capabilities.disableDamage && entityplayer2.isEntityAlive() && this.getEntitySenses().canSee((Entity)entityplayer2)) {
                final double d5 = entityplayer2.getDistanceSq(this.posX, this.posY, this.posZ);
                double d6 = p_72846_7_;
                if (entityplayer2.isSneaking()) {
                    d6 = p_72846_7_ * 0.800000011920929;
                }
                if (entityplayer2.isInvisible()) {
                    float f = entityplayer2.getArmorVisibility();
                    if (f < 0.1f) {
                        f = 0.1f;
                    }
                    d6 *= 0.7f * f;
                }
                if ((p_72846_7_ < 0.0 || d5 < d6 * d6) && (d4 == -1.0 || d5 < d4)) {
                    d4 = d5;
                    entityplayer = entityplayer2;
                }
            }
        }
        return entityplayer;
    }
    
    private boolean isCourseTraversable(final double x, final double y, final double z, final double distance) {
    	double d4 = (this.waypointX - this.posX) / distance;
		double d5 = (this.waypointY - this.posY) / distance;
		double d6 = (this.waypointZ - this.posZ) / distance;
		AxisAlignedBB axisalignedbb = this.boundingBox.copy();

		for (int i = 1; (double)i < distance; ++i)
		{
			axisalignedbb.offset(d4, d5, d6);

			if (!this.worldObj.getCollidingBoundingBoxes(this, axisalignedbb).isEmpty())
			{
				return false;
			}
		}
        return true;
    }
    
    public void onCollideWithPlayer(final EntityPlayer player) {
        super.onCollideWithPlayer(player);
        if (!player.capabilities.isCreativeMode && !this.worldObj.isRemote && this.getEntitySenses().canSee((Entity)player) && this.getDistanceToEntity((Entity)player) <= 1.8f && player.boundingBox.maxY >= this.boundingBox.minY && player.boundingBox.minY <= this.boundingBox.maxY && this.attackTime <= 0 && this.attackEntityAsMob((player))) {
            this.attackTime = 10;
            player.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), 3.0f);
            this.playSound("nova_craft:warden_altar.shriek", 1.0f, 1.0f);
        }
    }
    
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(30.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(2D);
        this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0.30D);
    }
    
    protected void fall(final float p_70069_1_) {
    }
    
    protected void updateFallState(final double p_70064_1_, final boolean p_70064_3_) {
    }
    
    public boolean isOnLadder() {
        return false;
    }
    
    /*public void onEntityUpdate() {
        super.onEntityUpdate();
        if (this.worldObj.isRemote) {
            final float f = MathHelper.cos((48 + this.ticksExisted) * 0.13f + 3.1415927f);
            final float f2 = MathHelper.cos((48 + this.ticksExisted + 1) * 0.13f + 3.1415927f);
            if (f > 0.0f && f2 <= 0.0f) {
                //this.worldObj.playSound(this.posX, this.posY, this.posZ, "nova_craft:sculk_laser.charge", 0.95f + this.rand.nextFloat() * 0.05f, 0.95f + this.rand.nextFloat() * 0.05f, false);
            }
        }
    }*/
    
    @Override
    protected String getLivingSound() {
        return null;
    }
    
    @Override
    protected String getHurtSound()
    {
        return "nova_craft:warden_altar.shriek";
    }
    
    @Override
    protected String getDeathSound()
    {
        return "nova_craft:sculk_abomination.death";
    }
    
    protected float getSoundPitch()
    {
        return super.getSoundPitch() * 1.20F;
    }
    
    protected float getSoundVolume()
    {
        return 2.0F;
    }
    
    protected void dropFewItems(boolean p_70628_1_, int p_70628_2_)
    {
        int j;
        int k;
        {
            j = this.rand.nextInt(1 + p_70628_2_);

            for (k = 0; k < j; ++k)
            {
                this.dropItem(NovaCraftItems.sculked_leather, 1);
            }
        }

        j = this.rand.nextInt(1 + p_70628_2_);

        for (k = 0; k < j; ++k)
        {
        	this.dropItem(Item.getItemFromBlock(NovaCraftBlocks.sculk_block), 1);
        }
        
    }
}
