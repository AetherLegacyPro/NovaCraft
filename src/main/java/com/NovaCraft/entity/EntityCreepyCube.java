package com.NovaCraft.entity;

import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;

import java.util.List;

import com.NovaCraftBlocks.NovaCraftBlocks;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

public class EntityCreepyCube extends EntityMob
{
    public EntityCreepyCube(final World world) {
        super(world);
        this.experienceValue = 5;
    }
    
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(1.0);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(2.0);
        this.setHealth(1);
    }
    
    public int getTotalArmorValue() {
        return 4;
    }
    
    public void onLivingUpdate() {
        super.onLivingUpdate();
    }
    
    public void jump(final int mx, final int mz) {
        if (this.onGround) {
            this.motionY += 2.0;
            this.motionX += mx;
            this.motionZ += mz;

            this.worldObj.spawnParticle("largeexplode", this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, 0.0D, 0.0D, 0.0D);
            if (!this.worldObj.isRemote) {                
                double radius = 2.0;
                List<EntityLivingBase> entities = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(radius, radius, radius));

                for (EntityLivingBase entity : entities) {
                    if (entity != this) {
                        double dx = entity.posX - this.posX;
                        double dz = entity.posZ - this.posZ;
                        double dist = Math.max(0.1, dx * dx + dz * dz);
                        double strength = 1.0 / dist;

                        entity.attackEntityFrom(DamageSource.generic, 4.0f);
                        entity.addVelocity(dx * strength, 0.5, dz * strength);
                    }
                }
            }
        }
    }
    
    @Override
	public boolean getCanSpawnHere() {
        final int i = MathHelper.floor_double(this.posX);
        final int j = MathHelper.floor_double(this.boundingBox.minY);
        final int k = MathHelper.floor_double(this.posZ);
        final boolean canSpawn = this.worldObj.checkNoEntityCollision(this.boundingBox) && this.worldObj.getCollidingBoundingBoxes((Entity)this, this.boundingBox).isEmpty() && !this.worldObj.isAnyLiquid(this.boundingBox);          
        return (this.posY >= 85.0D && this.worldObj.canBlockSeeTheSky(i, j, k) && this.worldObj.getBlockLightValue(i, j, k) <= 7 && canSpawn);
                       
    }
    
    @Override
    protected Item getDropItem() {
        return Item.getItemFromBlock(NovaCraftBlocks.cobbled_etherstone);
    }
    
    public void onUpdate() {
        super.onUpdate();
        this.fallDistance = 0.0f;
        if (this.attackingPlayer != null) {
            final float px = (float)this.attackingPlayer.posX;
            final float pz = (float)this.attackingPlayer.posZ;
            if (px > this.posX) {
                this.jump(1, 0);
            }
            else if (px < this.posX) {
                this.jump(-1, 0);
            }
            if (pz > this.posZ) {
                this.jump(0, 1);
            }
            else if (pz < this.posZ) {
                this.jump(0, -1);
            }
        }
        else {
            this.jump(this.rand.nextInt(3) - 1, this.rand.nextInt(3) - 1);
        }
    }
    
    protected String getLivingSound() {
        return "nova_craft:grimstone.break";
    }
    
    protected String getHurtSound() {
        return "nova_craft:grimstone.break";
    }
    
    protected String getDeathSound() {
        return "nova_craft:grimstone.break";
    }
    
    protected float getSoundVolume()
    {
        return 1.0F;
    }
    
    public EnumCreatureAttribute getCreatureAttribute() {
        return EnumCreatureAttribute.UNDEFINED;
    }
}
