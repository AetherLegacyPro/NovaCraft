package com.NovaCraft.entity;

import com.NovaCraft.config.ConfigsEntities;
import net.minecraft.entity.passive.*;
import net.minecraft.world.*;

import java.util.Random;

import com.NovaCraft.config.Configs;
import com.NovaCraft.particles.ParticleHandler;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockGrass;
import net.minecraft.entity.*;
import net.minecraft.util.*;

public class EntityFirefly extends EntityAmbientCreature
{
    public int courseChangeCooldown;
    public double waypointX;
    public double waypointY;
    public double waypointZ;
    
    private World world;
    
    public EntityFirefly(final World world) {
        super(world);
        this.courseChangeCooldown = 0;
        this.setSize(0.5f, 0.5f);
    }
    
    @SideOnly(Side.CLIENT)
    public void onEntityUpdate() {
        super.onEntityUpdate();
        
        if (this.worldObj.isRemote && Configs.enableFireflyParticles == true) {
        		ParticleHandler.FIREFLY.spawn(worldObj, this.posX, this.posY, this.posZ);        
           }
    }
    
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(1.0);
    }
    
    protected boolean canTriggerWalking() {
        return false;
    }
    
    public int decreaseAirSupply(final int par1) {
        return par1;
    }
    
    public boolean canBePushed() {
        return false;
    }
    
    protected boolean canDespawn() {
        return true;
    }
    
    public boolean doesEntityNotTriggerPressurePlate() {
        return true;
    }
    
    public boolean allowLeashing() {
        return false;
    }
    
    public void onUpdate() {
        super.onUpdate();
       if (ConfigsEntities.enableNoDespawnFirefly) {
        if (this.ticksExisted > 7200) {
            this.setDead();
         }
       }
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
        return 1.0F;
    }
    
    protected void updateEntityActionState() {
        final double var18 = 16.0;
        final double d = this.waypointX - this.posX;
        final double d2 = this.waypointY - this.posY;
        final double d3 = this.waypointZ - this.posZ;
        double d4 = d * d + d2 * d2 + d3 * d3;
        if (d4 < 1.0 || d4 > 3600.0) {
            this.waypointX = this.posX + (this.rand.nextFloat() * 2.0f - 1.0f) * 16.0;
            this.waypointY = this.posY + (this.rand.nextFloat() * 2.0f - 1.0f) * 16.0;
            this.waypointZ = this.posZ + (this.rand.nextFloat() * 2.0f - 1.0f) * 16.0;
        }
        if (this.courseChangeCooldown-- <= 0) {
            this.courseChangeCooldown += this.rand.nextInt(5) + 2;
            d4 = MathHelper.sqrt_double(d4);
            if (this.isCourseTraversable(this.waypointX, this.waypointY, this.waypointZ, d4)) {
                this.motionX += d / d4 * 0.1;
                this.motionY += d2 / d4 * 0.1;
                this.motionZ += d3 / d4 * 0.1;
            }
            else {
                this.waypointX = this.posX;
                this.waypointY = this.posY;
                this.waypointZ = this.posZ;
            }
        }
    }
    
    protected void fall(final float p_70069_1_) {
    }
    
    protected void updateFallState(final double p_70064_1_, final boolean p_70064_3_) {
    }
    
    public void moveEntityWithHeading(final float p_70612_1_, final float p_70612_2_) {
        if (this.isInWater()) {
            this.moveFlying(p_70612_1_, p_70612_2_, 0.02f);
            this.moveEntity(this.motionX, this.motionY, this.motionZ);
            this.motionX *= 0.800000011920929;
            this.motionY *= 0.800000011920929;
            this.motionZ *= 0.800000011920929;
        }
        else if (this.handleLavaMovement()) {
            this.moveFlying(p_70612_1_, p_70612_2_, 0.02f);
            this.moveEntity(this.motionX, this.motionY, this.motionZ);
            this.motionX *= 0.5;
            this.motionY *= 0.5;
            this.motionZ *= 0.5;
        }
        else {
            float f2 = 0.91f;
            if (this.onGround) {
                f2 = this.worldObj.getBlock(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.boundingBox.minY) - 1, MathHelper.floor_double(this.posZ)).slipperiness * 0.91f;
            }
            final float f3 = 0.16277136f / (f2 * f2 * f2);
            this.moveFlying(p_70612_1_, p_70612_2_, this.onGround ? (0.1f * f3) : 0.02f);
            f2 = 0.91f;
            if (this.onGround) {
                f2 = this.worldObj.getBlock(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.boundingBox.minY) - 1, MathHelper.floor_double(this.posZ)).slipperiness * 0.91f;
            }
            this.moveEntity(this.motionX, this.motionY, this.motionZ);
            this.motionX *= f2;
            this.motionY *= f2;
            this.motionZ *= f2;
        }
        this.prevLimbSwingAmount = this.limbSwingAmount;
        final double d1 = this.posX - this.prevPosX;
        final double d2 = this.posZ - this.prevPosZ;
        float f4 = MathHelper.sqrt_double(d1 * d1 + d2 * d2) * 4.0f;
        if (f4 > 1.0f) {
            f4 = 1.0f;
        }
        this.limbSwingAmount += (f4 - this.limbSwingAmount) * 0.4f;
        this.limbSwing += this.limbSwingAmount;
    }
    
    public boolean isOnLadder() {
        return false;
    }
    
    private boolean isCourseTraversable(final double d, final double d1, final double d2, final double d3) {
        final double d4 = (this.waypointX - this.posX) / d3;
        final double d5 = (this.waypointY - this.posY) / d3;
        final double d6 = (this.waypointZ - this.posZ) / d3;
        final AxisAlignedBB axisalignedbb = this.boundingBox.copy();
        for (int x = 1; x < d3; ++x) {
            axisalignedbb.offset(d4, d5, d6);
            if (!this.worldObj.getCollidingBoundingBoxes((Entity)this, axisalignedbb).isEmpty()) {
                return false;
            }
        }
        int x = (int)this.waypointX;
        final int y = (int)this.waypointY;
        final int z = (int)this.waypointZ;
        if (this.worldObj.getBlock(x, y, z).getMaterial().isLiquid()) {
            return false;
        }
        for (int a = 0; a < 11; ++a) {
            if (!this.worldObj.isAirBlock(x, y - a, z)) {
                return true;
            }
        }
        return false;
    }
    
    protected String getLivingSound() {
    	return null;
    }
    
    protected String getHurtSound() {
    	return null;
    }
    
    protected String getDeathSound() {
        return null;
    }
    
    protected float getSoundVolume() {
        return 0.25f;
    }
    
    public int getMaxSpawnedInChunk() {
        return 4;
    }
    
    public boolean getCanSpawnHere() {
        final int i = MathHelper.floor_double(this.posX);
        final int j = MathHelper.floor_double(this.boundingBox.minY);
        final int k = MathHelper.floor_double(this.posZ);
        return (this.worldObj.getBlock(i, j - 1, k) instanceof BlockGrass && j >= 60 && this.worldObj.getBlockLightValue(i, j, k) <= 7 && !this.worldObj.isDaytime()); 
        }
}

