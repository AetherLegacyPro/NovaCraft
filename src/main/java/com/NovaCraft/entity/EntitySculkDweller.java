package com.NovaCraft.entity;

import com.NovaCraft.NovaCraft;
import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.achievements.AchievementsNovaCraft;
import com.NovaCraft.registry.OtherModBlocks;
import com.NovaCraftBlocks.NovaCraftBlocks;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntitySculkDweller extends EntityMob
{		
	public EntitySculkDweller(final World p_i1745_1_) {
		super(p_i1745_1_);
		getNavigator().setBreakDoors(true);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
		this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
		this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(8, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
		addRandomArmor();
		setSize(0.6F, 1.8F);
		this.experienceValue = 25;
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();

		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.65D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(100.0D);
		this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0.20D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(12D);
		this.setHealth(100);
	}
	
	@Override
	protected void addRandomArmor()
	{		
		this.setCurrentItemOrArmor(0, new ItemStack(NovaCraftItems.eerie_sword));
		this.setCurrentItemOrArmor(4, new ItemStack(NovaCraftItems.sculk_helmet));
		this.setCurrentItemOrArmor(3, new ItemStack(NovaCraftItems.sculk_chestplate));
		this.setCurrentItemOrArmor(2, new ItemStack(NovaCraftItems.sculk_leggings));
		this.setCurrentItemOrArmor(1, new ItemStack(NovaCraftItems.sculk_boots));
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
	
	public void onLivingUpdate()
	{		
		if (this.worldObj.isDaytime() && !this.worldObj.isRemote && this.worldObj.provider.dimensionId != 1 && this.worldObj.canBlockSeeTheSky(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ))) {
            this.damageEntity(DamageSource.drown, 2.0f);
            this.setFire(4);
        }	
		super.onLivingUpdate();
	}
	
	public float getBrightness(float p_70013_1_)
	{
		return super.getBrightness(p_70013_1_);
	}
	
	 protected void dropFewItems(boolean p_70628_1_, int p_70628_2_)
	    {
	        int j;
	        int k;
	        {
	            j = this.rand.nextInt(3 + p_70628_2_);

	            for (k = 0; k < j; ++k)
	            {
	                this.dropItem(NovaCraftItems.sculk_flesh, 1);
	            }
	        }

	        j = this.rand.nextInt(3 + p_70628_2_);

	        for (k = 0; k < j; ++k)
	        {
	        	this.dropItem(Item.getItemFromBlock(NovaCraftBlocks.sculk_block), 1);
	        }
	        
	        j = this.rand.nextInt(2 + p_70628_2_);

	        for (k = 0; k < j; ++k)
	        {
	        	this.dropItem(NovaCraftItems.anomalous_essence, 1);
	        }
	    }
	 
	 	/**
	     * Called when the mob's health reaches 0.
	     */
	    public void onDeath(DamageSource p_70645_1_)
	    {
	        super.onDeath(p_70645_1_);

	        if (p_70645_1_.getEntity() instanceof EntityPlayer)
	        {
	            EntityPlayer entityplayer = (EntityPlayer)p_70645_1_.getEntity();
	            
	            entityplayer.triggerAchievement(AchievementsNovaCraft.kill_sculk_dweller);
	            
	        }
	    }
	
	public EnumCreatureAttribute getCreatureAttribute()
    {
        return EnumCreatureAttribute.UNDEAD;
    }
	
	protected void dropRareDrop(int p_70600_1_)
    {
        switch (this.rand.nextInt(5))
        {
        	case 0:
        		this.dropItem(NovaCraftItems.sculk_dweller_heart, 1);
        		break;
            case 1:
                this.dropItem(NovaCraftItems.sculk_helmet, 1);
                break;
            case 2:
                this.dropItem(NovaCraftItems.sculk_chestplate, 1);
                break;
            case 3:
                this.dropItem(NovaCraftItems.sculk_leggings, 1);
                break;
            case 4:
                this.dropItem(NovaCraftItems.sculk_boots, 1);
        }
    }
	
	/**
     * Returns the sound this mob makes while it's alive.
     */
	@Override
    protected String getLivingSound()
    {
        return "nova_craft:sculk_abomination.living";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
	@Override
    protected String getHurtSound()
    {
        return "nova_craft:warden_altar.shriek";
    }

    /**
     * Returns the sound this mob makes on death.
     */
	@Override
    protected String getDeathSound()
    {
        return "nova_craft:sculk_abomination.death";
    }
	
	@Override
    protected float getSoundVolume() {
        return 1.5F;
    }

	@Override
    protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_)
    {
        this.playSound("mob.zombie.step", 0.25F, 1.1F);
    }
	
	public boolean getCanSpawnHere() {
        final int i = MathHelper.floor_double(this.posX);
        final int j = MathHelper.floor_double(this.boundingBox.minY);
        final int k = MathHelper.floor_double(this.posZ);
        final boolean canSpawn = this.worldObj.checkNoEntityCollision(this.boundingBox) && this.worldObj.getCollidingBoundingBoxes((Entity)this, this.boundingBox).isEmpty() && !this.worldObj.isAnyLiquid(this.boundingBox);          
        return (this.worldObj.getBlock(i, j - 1, k) == NovaCraftBlocks.nullstone_bricks || this.worldObj.getBlock(i, j - 1, k) == NovaCraftBlocks.grimstone_bricks || this.worldObj.getBlock(i, j - 1, k) == NovaCraftBlocks.sculk_bricks || this.worldObj.getBlock(i, j - 1, k) == NovaCraftBlocks.sculk_block || this.worldObj.getBlock(i, j - 1, k) == NovaCraftBlocks.sculk_stone || this.worldObj.getBlock(i, j - 1, k) == NovaCraftBlocks.sculk_grimstone || this.worldObj.getBlock(i, j - 1, k) == NovaCraftBlocks.sculk_deepslate || this.worldObj.getBlock(i, j - 1, k) == NovaCraftBlocks.sculk_nullstone || this.worldObj.getBlock(i, j - 1, k) == NovaCraftBlocks.sculk_endstone || this.worldObj.getBlock(i, j - 1, k) == NovaCraftBlocks.inked_sculk_block  || this.worldObj.getBlock(i, j - 1, k) == Blocks.end_stone || this.worldObj.getBlock(i, j - 1, k) == NovaCraftBlocks.sculk_tentacle_1 || this.worldObj.getBlock(i, j - 1, k) == NovaCraftBlocks.sculk_tentacle_2 || this.worldObj.getBlock(i, j - 1, k) == NovaCraftBlocks.nullstone || this.worldObj.getBlock(i, j - 1, k) == NovaCraftBlocks.carved_vanite_bricks || this.worldObj.getBlock(i, j - 1, k) == OtherModBlocks.deepslate_bricks) && this.worldObj.getBlockLightValue(i, j, k) < 8 && this.posY <= 50.0D && canSpawn;
        
     
               
    }

}
