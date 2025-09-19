package com.NovaCraft.entity.illager;

import com.NovaCraft.NovaCraft;
import com.NovaCraft.Items.NovaCraftItems;
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

public class EntityVindicator extends EntityMob
{
	private int angerLevel;
	private Entity lastAggroTarget;
	
	public EntityVindicator(final World p_i1745_1_) {
		super(p_i1745_1_);
		getNavigator().setBreakDoors(true);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityVillager.class, 1.0D, false));
		this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
		this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(8, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityVillager.class, 0, true));
		addRandomArmor();
		setSize(0.6F, 1.8F);
		this.experienceValue = 6;
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();

		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.90D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0D);
		this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0.30D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(5.0D);
		this.setHealth(20);
	}
	
	@Override
	protected void addRandomArmor()
	{		
		int rand = (int)(1 + Math.random() * 12);
		switch (rand)
        {
        	case 1:
        		this.setCurrentItemOrArmor(0, new ItemStack(Items.iron_axe));
        		break;
            case 2:
            	this.setCurrentItemOrArmor(0, new ItemStack(Items.iron_sword));
                break;
            case 3:
            	this.setCurrentItemOrArmor(0, new ItemStack(Items.stone_axe));
                break;
            case 4:
            	this.setCurrentItemOrArmor(0, new ItemStack(Items.stone_sword));
                break;
            case 5:
            	this.setCurrentItemOrArmor(0, new ItemStack(Items.iron_axe));
            	break;
            case 6:
            	this.setCurrentItemOrArmor(0, new ItemStack(Items.diamond_axe));
            	break;
            case 7:
            	this.setCurrentItemOrArmor(0, new ItemStack(NovaCraftItems.pherithium_axe));
            	break;
            case 8:
            	this.setCurrentItemOrArmor(0, new ItemStack(NovaCraftItems.pherithium_sword));
            	break;
            default:
            	this.setCurrentItemOrArmor(0, new ItemStack(Items.stone_axe));
            	break;
        }
	}
	
	@Override
	public void onLivingUpdate() {
	    super.onLivingUpdate();

	    EntityLivingBase nearby = this.worldObj.getClosestVulnerablePlayerToEntity(this, 16.0D);
	    if (nearby == null) {
	        nearby = (EntityLivingBase) this.worldObj.findNearestEntityWithinAABB(EntityVillager.class, this.boundingBox.expand(16.0D, 4.0D, 16.0D), this);
	    }

	    if (nearby != null) {
	        this.angerLevel = 20;
	        this.lastAggroTarget = nearby;
	    } else if (angerLevel > 0) {
	        this.angerLevel--;
	        if (angerLevel == 0) this.lastAggroTarget = null;
	    }
	}
	
	public boolean isAngry() {
	    return this.angerLevel > 0;
	}
	
	public float getBrightness(float p_70013_1_)
	{
		return super.getBrightness(p_70013_1_);
	}
	
	protected void dropRareDrop(int p_70600_1_)
	{
		this.dropItem(Items.emerald, 1);
    }
	
	
	public EnumCreatureAttribute getCreatureAttribute()
    {
        return EnumCreatureAttribute.UNDEFINED;
    }
	
	/**
     * Returns the sound this mob makes while it's alive.
     */
	@Override
    protected String getLivingSound()
    {
        return "nova_craft:vindicator.living";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
	@Override
    protected String getHurtSound()
    {
        return "nova_craft:vindicator.hurt";
    }

    /**
     * Returns the sound this mob makes on death.
     */
	@Override
    protected String getDeathSound()
    {
        return "nova_craft:vindicator.death";
    }
	
	@Override
    protected float getSoundVolume() {
        return 0.7F;
    }
	
	public boolean canDespawn() {
        return false;
    }

}
