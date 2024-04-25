package com.NovaCraft.entity;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.config.Configs;
import com.NovaCraft.entity.misc.EntitySaddleMount;
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
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityEnderAvis extends EntitySaddleMount {

    public float wingFold;

    public float wingAngle;

    private float aimingForFold;

    public int maxJumps;

    public int jumpsRemaining;

    private int ticks;
    
    public int ticksFlying;
    
    public float wingRotation, destPos, prevDestPos, prevWingRotation;
    
    protected int ticksUntilFlap;

    public EntityEnderAvis(World world) {
        super(world);
        
        this.ticksFlying = 0;
        this.ticks = 0;
        this.maxJumps = 1;
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
    public void onUpdate() {
        super.onUpdate();

        if (this.isJumping) {
            this.motionY += 0.05F;
        }

        this.updateWingRotation();
        this.fall();
        
        this.fallDistance = 0;
              
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
    public void writeEntityToNBT(NBTTagCompound compound) {
        super.writeEntityToNBT(compound);

        compound.setInteger("maxJumps", (short) this.maxJumps);
        compound.setInteger("jumpsRemaining", (short) this.jumpsRemaining);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound compound) {
        super.readEntityFromNBT(compound);

        this.maxJumps = compound.getInteger("maxJumps");
        this.jumpsRemaining = compound.getInteger("jumpsRemaining");
    }

    @Override
    public double getMountedYOffset() {
        return 1.15D;
    }

    @Override
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

            if (this.onGround && !this.worldObj.isRemote) {
                this.jumpsRemaining = this.maxJumps;
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
        return "nova_craft:ender_avis.hurt";
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
        this.playSound("mob.cow.step", 0.15F, 1.0F);
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

        super.dropFewItems(recentlyHit, lootLevel);
    }

    @Override
    protected double getMountJumpStrength() {
        return 1.0D;
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