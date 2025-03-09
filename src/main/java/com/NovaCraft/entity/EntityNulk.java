package com.NovaCraft.entity;

import net.minecraft.entity.monster.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Blocks;
import net.minecraft.entity.ai.*;
import net.minecraft.world.*;
import net.minecraft.util.*;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.config.Configs;
import com.NovaCraft.particles.ParticleHandler;
import com.NovaCraftBlocks.NovaCraftBlocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.*;
import net.minecraft.item.*;

public class EntityNulk extends EntityFlying implements IMob
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
    private int field_82222_j;
	private int[] field_82224_i = new int[2];
    
    public EntityNulk(final World p_i1731_1_) {
        super(p_i1731_1_);
        this.targetObstructedTicks = 0;
        this.tasks.addTask(0, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 8.0f));
        this.tasks.addTask(1, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.setSize(1.0f, 3.0f);
        this.isImmuneToFire = false;
        this.experienceValue = 15;
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
    
    @Override
    public boolean attackEntityAsMob(final Entity target) {			

        if (target instanceof EntityPlayer) {

            target.attackEntityFrom(DamageSource.generic, 25.0F);            
        }
        
        return true;
    }
    
    public void onLivingUpdate()
	{		
		if (this.worldObj.isDaytime() && !this.worldObj.isRemote && this.worldObj.provider.dimensionId != 1 && this.worldObj.canBlockSeeTheSky(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ))) {
            this.damageEntity(DamageSource.drown, 4.0f);
            this.setFire(4);
        }
		
		super.onLivingUpdate();
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
            player.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), 25.0f);
            this.playSound("nova_craft:reality_distorter.hurt", 1.0f, 1.0f);
        }
    }
    
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(40.0);
        this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0.90D);
    }
    
    @SideOnly(Side.CLIENT)
    public void onEntityUpdate() {
    	super.onEntityUpdate();
    	if (this.worldObj.isRemote) {
    		
    		if (net.minecraft.client.Minecraft.getMinecraft().gameSettings.particleSetting == 2) {
    			return;
    		}
    		
    	int k;
        if (Configs.enableVoidEntityParticles) {
        	for (k = 0; k < 4; ++k)
        	{
        		ParticleHandler.VOID.spawn(worldObj, this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height - 0.25D, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width);
        		ParticleHandler.VOID.spawn(worldObj, this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height + 0.25D, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width);

        		}
        	}
    	}
    }
    
    @Override
    public boolean attackEntityFrom(DamageSource source, float amount)
    {
		if (source == DamageSource.drown || source == DamageSource.wither || source == DamageSource.outOfWorld || source == DamageSource.inWall || source.isProjectile())
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
    
    public EnumCreatureAttribute getCreatureAttribute()
    {
        return EnumCreatureAttribute.UNDEFINED;
    }
    
    protected void fall(final float p_70069_1_) {
    }
    
    protected void updateFallState(final double p_70064_1_, final boolean p_70064_3_) {
    }
    
    public boolean isOnLadder() {
        return false;
    }
    
    protected String getLivingSound() {
        return "nova_craft:reality_distorter.living";
    }
    
    protected String getHurtSound() {
        return "nova_craft:reality_distorter.hurt";
    }
    
    protected String getDeathSound() {
        return "nova_craft:reality_distorter.death";
    }
    
    protected void dropFewItems(final boolean p_70628_1_, final int p_70628_2_) {
       this.entityDropItem(new ItemStack(NovaCraftItems.nulk_dust), 1.5f);
       this.entityDropItem(new ItemStack(NovaCraftItems.static_essence, 1 + this.rand.nextInt(3)), 1.0F);
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
