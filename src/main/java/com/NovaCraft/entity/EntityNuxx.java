package com.NovaCraft.entity;

import com.NovaCraft.NovaCraft;
import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.achievements.AchievementsNovaCraft;
import com.NovaCraft.config.Configs;
import com.NovaCraft.particles.ParticleHandler;
import com.NovaCraft.registry.OtherModBlocks;
import com.NovaCraftBlocks.NovaCraftBlocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
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

public class EntityNuxx extends EntityMob
{		
	public EntityNuxx(final World p_i1745_1_) {
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
		this.experienceValue = 15;
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();

		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.85D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(100.0D);
		this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0.30D);
		this.setHealth(100);
	}
	
	@Override
	protected void addRandomArmor()
	{		
		this.setCurrentItemOrArmor(0, new ItemStack(NovaCraftItems.klangite_sword));
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
		
		if (entity instanceof EntityPlayer) {
			
			entity.attackEntityFrom(DamageSource.generic, 20.0f);
			entity.attackEntityFrom(DamageSource.magic, 6.0F);            
        }
		
		return flag;
	}
	
	public void onCollideWithPlayer(final EntityPlayer player) {
        super.onCollideWithPlayer(player);
        if (!player.capabilities.isCreativeMode && !this.worldObj.isRemote && this.getEntitySenses().canSee((Entity)player) && this.getDistanceToEntity((Entity)player) <= 1.8f && player.boundingBox.maxY >= this.boundingBox.minY && player.boundingBox.minY <= this.boundingBox.maxY && this.attackTime <= 0 && this.attackEntityAsMob((player))) {
            this.attackTime = 20;
            player.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), 20.0f);
            player.attackEntityFrom(DamageSource.magic, 6.0f);
            this.playSound("nova_craft:reality_distorter.hurt", 1.0f, 1.0f);
        }
    }
	
	public void onLivingUpdate()
	{		
		if (this.worldObj.isDaytime() && !this.worldObj.isRemote && this.worldObj.provider.dimensionId != 1 && this.worldObj.canBlockSeeTheSky(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ))) {
            this.damageEntity(DamageSource.drown, 2.0f);
            this.setFire(4);
        }	
		super.onLivingUpdate();
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
	
	public float getBrightness(float p_70013_1_)
	{
		return super.getBrightness(p_70013_1_);
	}
	 
	 	/**
	     * Called when the mob's health reaches 0.
	     */
	    public void onDeath(DamageSource p_70645_1_)
	    {
	        super.onDeath(p_70645_1_);

	        if (p_70645_1_.getEntity() instanceof EntityPlayer)
	        {
	            //EntityPlayer entityplayer = (EntityPlayer)p_70645_1_.getEntity();
	            
	            //entityplayer.triggerAchievement(AchievementsNovaCraft.kill_sculk_dweller);
	            
	        }
	    }
	
	public EnumCreatureAttribute getCreatureAttribute()
    {
        return EnumCreatureAttribute.UNDEFINED;
    }
	
	protected void dropFewItems(final boolean p_70628_1_, final int p_70628_2_) {
	    this.entityDropItem(new ItemStack(NovaCraftItems.nulk_dust), 1.5f);
	    this.entityDropItem(new ItemStack(NovaCraftItems.static_essence, 1 + this.rand.nextInt(3)), 1.0F);
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
	
	@Override
    protected float getSoundVolume() {
        return 1.5F;
    }

}
