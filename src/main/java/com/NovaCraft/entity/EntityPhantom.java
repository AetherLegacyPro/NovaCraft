package com.NovaCraft.entity;

import net.minecraft.entity.monster.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.ai.*;
import net.minecraft.world.*;
import net.minecraft.util.*;

import com.NovaCraft.Items.NovaCraftItems;

import net.minecraft.entity.*;
import net.minecraft.item.*;

public class EntityPhantom extends EntityFlying implements IMob
{
    public int flapSoundTime;
    public int courseChangeCooldown;
    public double waypointX;
    public double waypointY;
    public double waypointZ;
    private EntityLivingBase targetedEntity;
    private int targetObstructedTicks;
    public float animTime;
    public float prevAnimTime;
    
    public EntityPhantom(final World p_i1731_1_) {
        super(p_i1731_1_);
        this.targetObstructedTicks = 0;
        this.tasks.addTask(0, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 8.0f));
        this.tasks.addTask(1, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.setSize(1.5f, 1.0f);
        this.isImmuneToFire = false;
        this.experienceValue = 8;
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

            	target.attackEntityFrom(DamageSource.magic, 1.0F);
            }
            
            else {
            	target.attackEntityFrom(DamageSource.magic, 10.0F);
            }
             
        }
        
        return true;
    }
    
    protected void updateEntityActionState() {
        super.updateEntityActionState();
        if (!this.worldObj.isRemote && this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL) {
            this.setDead();
        }
        double distanceX = this.waypointX - this.posX;
        double distanceY = this.waypointY - this.posY;
        double distanceZ = this.waypointZ - this.posZ;
        double distanceScaled = distanceX * distanceX + distanceY * distanceY + distanceZ * distanceZ;
        if (distanceScaled < 1.0 || distanceScaled > 3600.0) {
            this.waypointX = this.posX + (this.rand.nextFloat() * 2.0f - 1.0f) * 16.0f;
            this.waypointY = this.posY + (this.rand.nextFloat() * 2.0f - 1.0f) * 16.0f;
            this.waypointZ = this.posZ + (this.rand.nextFloat() * 2.0f - 1.0f) * 16.0f;
        }
        if (this.courseChangeCooldown-- <= 0) {
            this.courseChangeCooldown += this.rand.nextInt(5) + 10;
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
            this.targetedEntity = (EntityLivingBase)this.getClosestVulnerableVisiblePlayer(40.0);
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
        final double boxX = (this.waypointX - this.posX) / distance;
        final double boxY = (this.waypointY - this.posY) / distance;
        final double boxZ = (this.waypointZ - this.posZ) / distance;
        final AxisAlignedBB axisalignedbb = this.boundingBox.copy();
        for (int i = 1; i < distance; ++i) {
            axisalignedbb.offset(boxX, boxY, boxZ);
            if (!this.worldObj.getCollidingBoundingBoxes((Entity)this, axisalignedbb).isEmpty()) {
                return false;
            }
        }
        return true;
    }
    
    public void onCollideWithPlayer(final EntityPlayer player) {
        super.onCollideWithPlayer(player);
        if (!player.capabilities.isCreativeMode && !this.worldObj.isRemote && this.getEntitySenses().canSee((Entity)player) && this.getDistanceToEntity((Entity)player) <= 1.8f && player.boundingBox.maxY >= this.boundingBox.minY && player.boundingBox.minY <= this.boundingBox.maxY && this.attackTime <= 0 && this.attackEntityAsMob((player))) {
            this.attackTime = 20;
            player.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), 5.0f);
            this.playSound("nova_craft:phantom.hurt", 1.0f, 1.0f);
        }
    }
    
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0);
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
                this.worldObj.playSound(this.posX, this.posY, this.posZ, "nova_craft:phantom.flap", 0.95f + this.rand.nextFloat() * 0.05f, 0.95f + this.rand.nextFloat() * 0.05f, false);
            }
           // if (this.ticksExisted % 10 == 0 && ParticleConfiguration.WarpedRayParticle) {
                //for (int i = 0; i < 20; ++i) {
                 //   ParticleHandler.WarpedNyliumBright.spawn(this.worldObj, this.posX + (this.rand.nextFloat() - this.rand.nextFloat()), this.posY + this.rand.nextFloat(), this.posZ + (this.rand.nextFloat() - this.rand.nextFloat()), 0.0, 0.0, 0.0, 0.0f, new Object[0]);
                //}
           // }
        }
    }
    
    protected String getLivingSound() {
        return "nova_craft:phantom.living";
    }
    
    protected String getFlapingSound() {
        return "nova_craft:phantom.flap";
    }
    
    protected String getHurtSound() {
        return "nova_craft:phantom.hurt";
    }
    
    protected String getDeathSound() {
        return "nova_craft:phantom.death";
    }
    
    protected void dropFewItems(final boolean p_70628_1_, final int p_70628_2_) {
        if (p_70628_1_) {
            for (int j = 2 + this.rand.nextInt(3) + p_70628_2_, k = 0; k < j; ++k) {
               this.entityDropItem(new ItemStack(NovaCraftItems.phantom_membrane), 1.5f);
            }
        }
    }
    
    public boolean getCanSpawnHere() {
        final int var1 = MathHelper.floor_double(this.boundingBox.minY);
        final int var2 = MathHelper.floor_double(this.posX);
        final int var3 = MathHelper.floor_double(this.posZ);
        final int var4 = this.worldObj.getBlockLightValue(var2, var1, var3);
        final byte var5 = 7;
        return var4 <= this.rand.nextInt(var5) && super.getCanSpawnHere();
    }
    
    public int getMaxSpawnedInChunk() {
        return 3;
    }
}
