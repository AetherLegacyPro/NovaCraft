package com.NovaCraft.entity;

import java.util.List;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.achievements.AchievementsNovaCraft;
import com.NovaCraft.entity.AI.EntityAILavaSwimming;
import com.NovaCraft.entity.misc.EntityRayfireball;

import net.minecraft.item.Item;
import java.util.ArrayList;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

import java.util.Iterator;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Vec3;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.init.Items;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.EntityFlying;

public class EntityPhoenix extends EntityAnimal implements IMob
{
    public int courseChangeCooldown;
    public double waypointX;
    public double waypointY;
    public double waypointZ;
    public boolean hasSpecialTexture;
    private Entity targetedEntity;
    private Entity attackedEntity;
    private int aggroCooldown;
    public int prevAttackCounter;
    public int attackCounter;
    
    public EntityPhoenix(final World par1World) {
        super(par1World);
        this.isImmuneToFire = true;
        this.courseChangeCooldown = 0;
        this.hasSpecialTexture = false;
        this.targetedEntity = null;
        this.attackedEntity = null;
        this.aggroCooldown = 0;
        this.prevAttackCounter = 0;
        this.attackCounter = 0;
        this.setSize(1.0f, 1.0f);
        this.hasSpecialTexture = (this.rand.nextInt(2) == 0);
        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(0, new EntityAILavaSwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 2.0D));
        this.tasks.addTask(9, new EntityAIMate(this, 1.0D));
        this.tasks.addTask(8, new EntityAITempt(this, 1.25D, NovaCraftItems.flaming_pitcher_petal, false));
        this.tasks.addTask(4, new EntityAIFollowParent(this, 1.25D));
        this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(7, new EntityAILookIdle(this));
        this.experienceValue = 1;
    }
    
    @Override
    protected void applyEntityAttributes()
    {
    	super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(3.0D);
        this.setHealth(20);
    }
    
    @SideOnly(Side.CLIENT)
    public String func_70073_O() {
        if (this.hasSpecialTexture) {
            return "novacraft:textures/entity/phoenix/phoenix_flames.png";
        }
        return "novacraft:textures/entity/phoenix/phoenix.png";
    }
    
    @Override
   	protected void entityInit() {
   		super.entityInit();
   		this.dataWatcher.addObject(17, (byte) 0);
   	}
    
    public boolean getCanSpawnHere() {
        final int i = MathHelper.floor_double(this.posX);
        final int j = MathHelper.floor_double(this.boundingBox.minY);
        final int k = MathHelper.floor_double(this.posZ);
        final boolean canSpawn = this.worldObj.checkNoEntityCollision(this.boundingBox) && this.worldObj.getCollidingBoundingBoxes((Entity)this, this.boundingBox).isEmpty() && !this.worldObj.isAnyLiquid(this.boundingBox);          
        return this.worldObj.getBlockLightValue(i, j, k) < 12  && this.posY <= 64.0D && canSpawn;
                      
    }
    
    @Override
	public boolean interact(EntityPlayer player) {
		ItemStack itemstack = player.inventory.getCurrentItem();

		if (itemstack != null && itemstack.getItem() == NovaCraftItems.phoenix_razor && !this.getSheared()) {
			if (!this.worldObj.isRemote) {
				this.setSheared(true);
				this.damageEntity(DamageSource.generic, 4);
				
				player.triggerAchievement(AchievementsNovaCraft.shearing_the_phoenix);
				int i = 2 + this.rand.nextInt(3);

				for (int j = 0; j < i; j++) {
					EntityItem entityitem = this.entityDropItem(new ItemStack(NovaCraftItems.phoenix_feather, 1, 0), 1.0F);
					entityitem.motionY += this.rand.nextFloat() * 0.05F;
					entityitem.motionX += (this.rand.nextFloat() - this.rand.nextFloat()) * 0.1F;
					entityitem.motionZ += (this.rand.nextFloat() - this.rand.nextFloat()) * 0.1F;
				}
			}

			itemstack.damageItem(1, player);
		}		

		return super.interact(player);
	}
    
    @Override
	public boolean attackEntityAsMob(final Entity entity) {
		final boolean flag = super.attackEntityAsMob(entity);
		
		entity.setFire(4);
        
                
		return flag;
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
    
    public void moveEntityWithHeading(final float p_70612_1_, final float p_70612_2_) {
        if (this.handleLavaMovement()) {
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
    
    public void onUpdate() {
		super.onUpdate();

		int rand = (int)(1 + Math.random() * 7500);
		if (rand == 1 && this.getSheared() == true) {
			this.setSheared(false);
		}
	}
    
    protected void fall(final float p_70069_1_) {
    }
    
    protected void updateFallState(final double p_70064_1_, final boolean p_70064_3_) {
    }
    
    public int func_70667_aM() {
        return 40;
    }
    
    public void onLivingUpdate()
	{		
		if (this.isWet())
        {
            this.attackEntityFrom(DamageSource.drown, 1.0F);
        }
		
		for (int i = 0; i < 2; ++i)
        {
            this.worldObj.spawnParticle("flame", this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, 0.0D, 0.0D, 0.0D);
        }
		
		super.onLivingUpdate();
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
        return 0.45F;
    }
    
    public EnumCreatureAttribute getCreatureAttribute()
    {
        return EnumCreatureAttribute.UNDEFINED;
    }
    
    protected String getLivingSound() {
        return "nova_craft:phoenix.living";
    }
    
    protected String getHurtSound() {
        return "nova_craft:phoenix.hurt";
    }
    
    protected String getDeathSound() {
        return "nova_craft:phoenix.hurt";
    }
    
    protected float getSoundVolume() {
        return 2.0f;
    }
    
    @Override
	protected void dropFewItems(boolean var1, int ammount) {
		if (!this.getSheared()) {
			this.entityDropItem(new ItemStack(NovaCraftItems.phoenix_feather, 1 + this.rand.nextInt(1)), 1.0F);
		}
	}
    
    public boolean allowLeashing() {
        return true;
    }
    
    //protected Item getDropItem()
    //{
       // return NovaCraftItems.phoenix_feather;
   // }
    
    @Override
    public EntityPhoenix createChild(EntityAgeable p_90011_1_)
    {
    	EntityPhoenix phoenix = new EntityPhoenix(this.worldObj);

        return phoenix;
    }
    
    public void writeEntityToNBT(NBTTagCompound nbttagcompound) {
		super.writeEntityToNBT(nbttagcompound);
		nbttagcompound.setBoolean("Sheared", this.getSheared());
	}

	public void readEntityFromNBT(NBTTagCompound nbttagcompound) {
		super.readEntityFromNBT(nbttagcompound);
		this.setSheared(nbttagcompound.getBoolean("Sheared"));
		
	}
	
	public boolean getSheared() {
		return this.dataWatcher.getWatchableObjectByte(17) == (byte) 1;
	}

	public void setSheared(boolean flag) {
		this.dataWatcher.updateObject(17, Byte.valueOf((byte) (flag ? 1 : 0)));
	}
 
}
