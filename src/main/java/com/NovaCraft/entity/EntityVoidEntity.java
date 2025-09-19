package com.NovaCraft.entity;

import com.NovaCraft.Hardmode;
import com.NovaCraft.NovaCraft;
import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.achievements.AchievementsNovaCraft;
import com.NovaCraft.config.Configs;
import com.NovaCraft.particles.ParticleHandler;
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
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityVoidEntity extends EntityMob
{
	private int field_82222_j;
	private int[] field_82224_i = new int[2];
	
	public EntityVoidEntity(final World p_i1745_1_) {
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
		setSize(0.6F, 1.8F);
		this.experienceValue = 30;
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		
		//World world = MinecraftServer.getServer().worldServers[0];
        //Hardmode data = Hardmode.get(world);
        //if (data.getHardmode() == true) {
        	//this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(60D);
    		//this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.05D);
    		//this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(150.0D);
    		//this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0.90D);
    		//this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(30D);
    		//this.setHealth(150);
        //} else {
        	this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(60D);
    		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.95D);
    		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(100.0D);
    		this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0.90D);
    		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(20D);
    		this.setHealth(100);
        //}
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
	
	@Override
   	public void fall(float distance) {
   	}
	
	public void onLivingUpdate()
	{		
		if (this.worldObj.isDaytime() && !this.worldObj.isRemote && this.worldObj.provider.dimensionId != 1 && this.worldObj.canBlockSeeTheSky(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ))) {
            this.damageEntity(DamageSource.drown, 2.0f);
            this.setFire(4);
        }
		
		if (!this.onGround && this.motionY < 0.0D) {
			this.motionY *= 0.59999999999999998D;
		}
		
		super.onLivingUpdate();
	}
	
	public float getBrightness(float p_70013_1_)
	{
		return super.getBrightness(p_70013_1_);
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
        		ParticleHandler.VOIDENTITY.spawn(worldObj, this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height - 0.25D, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width);
        		ParticleHandler.VOIDENTITY.spawn(worldObj, this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height + 0.25D, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width);

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
		Entity entity;
		entity = source.getSourceOfDamage();

		if (entity instanceof EntityArrow)
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
	
	/**
     * Called when the mob's health reaches 0.
     */
    public void onDeath(DamageSource p_70645_1_)
    {
        super.onDeath(p_70645_1_);

        if (p_70645_1_.getEntity() instanceof EntityPlayer)
        {
            EntityPlayer entityplayer = (EntityPlayer)p_70645_1_.getEntity();
            
            entityplayer.triggerAchievement(AchievementsNovaCraft.well_this_complicates_things);
            
        }
    }
	
	 protected void dropFewItems(boolean p_70628_1_, int p_70628_2_)
	    {
	        int j;
	        int k;
	       	        
	        j = this.rand.nextInt(2 + p_70628_2_);

	        for (k = 0; k < j; ++k)
	        {
	        	this.dropItem(NovaCraftItems.anomalous_essence, 1);
	        }
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
        return "nova_craft:void_entity.living";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
	@Override
    protected String getHurtSound()
    {
        return "nova_craft:void_entity.hurt";
    }

    /**
     * Returns the sound this mob makes on death.
     */
	@Override
    protected String getDeathSound()
    {
        return "nova_craft:void_entity.death";
    }
	
	@Override
    protected float getSoundVolume() {
        return 0.7F;
    }

}
