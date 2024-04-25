package com.NovaCraft.entity;

import net.minecraft.entity.monster.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.world.*;
import net.minecraft.util.*;

import java.util.Random;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.entity.misc.EntityBloviatorProjectile;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.nbt.NBTTagCompound;

public class EntityBloviator extends EntityFlying implements IMob, IBossDisplayData
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
    private int explosionStrength = 3;
    private final float base;
    
    public EntityBloviator(final World p_i1731_1_) {
        super(p_i1731_1_);
        this.targetObstructedTicks = 0;
        this.tasks.addTask(0, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 200.0f));
        this.tasks.addTask(1, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.setSize(2.0f, 2.0f);
        this.isImmuneToFire = true;
        this.experienceValue = 100;
        this.base = (this.getRNG().nextFloat() - this.getRNG().nextFloat()) * 0.2F + 1.0F;
    }
    
    public int getTotalArmorValue()
    {
        return 10;
    }
    
    @SideOnly(Side.CLIENT)
    public boolean func_110182_bF()
    {
        return this.dataWatcher.getWatchableObjectByte(17) != 0;
    }
    
    protected boolean canTriggerWalking() {
        return false;
    }
    
    public boolean doesEntityNotTriggerPressurePlate() {
        return true;
    }
    
    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(16, (Object)new Byte((byte)0));
        this.dataWatcher.addObject(17, Byte.valueOf((byte)0));
    }
    
    public void onUpdate() {
        super.onUpdate();
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
		int rand2 = (int)(1 + Math.random() * 4);
		switch (rand2)
        {
        case 1: 
		 if (this.rand.nextInt(100) == 1 && !this.worldObj.isRemote) {
		        EntityPhantom phantom = new EntityPhantom(this.worldObj);
		        phantom.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
		        phantom.setAttackTarget(this.getAttackTarget());

		        if (!this.worldObj.isRemote) {
		           this.worldObj.spawnEntityInWorld(phantom);
		          }
		        
		        break;
         	}
        case 2: 
   		 if (this.rand.nextInt(200) == 2 && !this.worldObj.isRemote) {
   		        EntityNullifier nullifier = new EntityNullifier(this.worldObj);
   		        nullifier.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
   		        nullifier.motionY = 1.0;
   		        nullifier.fallDistance = -100.0f;
   		        nullifier.setAttackTarget(this.getAttackTarget());

   		        if (!this.worldObj.isRemote) {
   		           this.worldObj.spawnEntityInWorld(nullifier);
   		          }
   		        
   		        break;
            	}
        case 3: 
   		 if (this.rand.nextInt(300) == 3 && !this.worldObj.isRemote) {
   		        EntityVoidEntity void_entity = new EntityVoidEntity(this.worldObj);
   		        void_entity.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
   		        void_entity.setAttackTarget(this.getAttackTarget());

   		        if (!this.worldObj.isRemote) {
   		           this.worldObj.spawnEntityInWorld(void_entity);
   		          }
   		        
   		        break;
            	}
   		 
        case 4: 
   		 if (this.rand.nextInt(300) == 4 && !this.worldObj.isRemote) {
   		        EntityVoidCube cube = new EntityVoidCube(this.worldObj);
   		        cube.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
   		        cube.motionY = 1.0;
   		        cube.fallDistance = -100.0f;
   		        cube.setAttackTarget(this.getAttackTarget());

   		        if (!this.worldObj.isRemote) {
   		           this.worldObj.spawnEntityInWorld(cube);
   		          }
   		        
   		        break;
            	}
		  }      
		
		super.onLivingUpdate();
	}
    
    @Override
    public boolean attackEntityAsMob(final Entity target) {			

        if (target instanceof EntityPlayer) {

            ItemStack helmet = ((EntityPlayer) target).getCurrentArmor(3);
            ItemStack chest = ((EntityPlayer) target).getCurrentArmor(2);
            ItemStack legs = ((EntityPlayer) target).getCurrentArmor(1);
            ItemStack boots = ((EntityPlayer) target).getCurrentArmor(0);

            boolean hasphantomHelmet = false;
            boolean hasphantomChest = false;
            boolean hasphantomLegs = false;
            boolean hasphantomBoots = false;


            if(helmet != null)
                hasphantomHelmet = helmet.getItem() == NovaCraftItems.phantom_helmet;

            if(chest != null)
                hasphantomChest = chest.getItem() == NovaCraftItems.phantom_chestplate;

            if(legs != null)
                hasphantomLegs = legs.getItem() == NovaCraftItems.phantom_leggings;

            if(boots != null)
                hasphantomBoots = boots.getItem() == NovaCraftItems.phantom_boots;

            if (hasphantomHelmet || hasphantomChest || hasphantomLegs || hasphantomBoots) {

            	target.attackEntityFrom(DamageSource.magic, 2.0F);
            }
            
            else {
            	target.attackEntityFrom(DamageSource.magic, 6.0F);
            }
             
        }
        
        return true;
    }
    
    @Override
    public boolean attackEntityFrom(DamageSource source, float amount)
    {
		if (source == DamageSource.wither || source == DamageSource.inWall || source == DamageSource.cactus || source.isExplosion())
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
            this.targetedEntity = (EntityLivingBase)this.getClosestVulnerableVisiblePlayer(100.0);
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

			this.setAttackTarget(this.worldObj.getClosestVulnerablePlayerToEntity(this, 250D));
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

				if (this.attackCounter == 10) {
					this.playSound("nova_craft:ender_ray.charge", 3F, this.base);
				} else if (this.attackCounter == 20) {
					this.playSound("nova_craft:ender_ray.charge", 3F, this.base);

					EntityBloviatorProjectile projectile = new EntityBloviatorProjectile(this.worldObj, this, x, y, z);
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

        if (!this.worldObj.isRemote)
        {
            byte b1 = this.dataWatcher.getWatchableObjectByte(17);
            byte b0 = (byte)(this.attackCounter > 10 ? 1 : 0);

            if (b1 != b0)
            {
                this.dataWatcher.updateObject(17, Byte.valueOf(b0));
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
            player.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), 15.0f);
            this.playSound("nova_craft:ender_ray.hurt", 1.0f, 1.0f);
        }
    }
    
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(350.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(16D);
        this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0.60D);
    }
    
    protected void fall(final float p_70069_1_) {
    }
    
    protected void updateFallState(final double p_70064_1_, final boolean p_70064_3_) {
    }
    
    public boolean isOnLadder() {
        return false;
    }
    
    public void onEntityUpdate() {
        super.onEntityUpdate();
        if (this.worldObj.isRemote) {
            final float f = MathHelper.cos((48 + this.ticksExisted) * 0.13f + 3.1415927f);
            final float f2 = MathHelper.cos((48 + this.ticksExisted + 1) * 0.13f + 3.1415927f);
            if (f > 0.0f && f2 <= 0.0f) {
                this.worldObj.playSound(this.posX, this.posY, this.posZ, "nova_craft:ender_ray.charge", 0.95f + this.rand.nextFloat() * 0.05f, 0.95f + this.rand.nextFloat() * 0.05f, false);
            }
        }
    }
    
    protected String getLivingSound() {
        return  "nova_craft:ender_ray.living";
    }
    
    protected String getFlapingSound() {
        return "nova_craft:ender_ray.charge";
    }
    
    protected String getHurtSound() {
        return "nova_craft:ender_ray.hurt";
    }
    
    protected String getDeathSound() {
        return "nova_craft:ender_ray.death";
    }
    
    protected float getSoundPitch()
    {
        return super.getSoundPitch() * 1.20F;
    }
    
    protected float getSoundVolume()
    {
        return 6.0F;
    }
    
    protected void dropFewItems(final boolean p_70628_1_, final int p_70628_2_) {
    	this.entityDropItem(new ItemStack(NovaCraftItems.heart_of_the_end, 1, 0), 0.5F);
    	
    	int j;
        int k;
       	        
        j = this.rand.nextInt(4 + p_70628_2_);

        for (k = 0; k < j; ++k)
        {
        	this.dropItem(NovaCraftItems.nullified_dust, 6);
        }
    }
    
    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound p_70014_1_)
    {
        super.writeEntityToNBT(p_70014_1_);
        p_70014_1_.setInteger("ExplosionPower", this.explosionStrength);
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound p_70037_1_)
    {
        super.readEntityFromNBT(p_70037_1_);

        if (p_70037_1_.hasKey("ExplosionPower", 99))
        {
            this.explosionStrength = p_70037_1_.getInteger("ExplosionPower");
        }
    }
    
    public boolean canDespawn() {
        return false;
    }
}
