package com.NovaCraft.entity;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.entity.AI.EntityAIDeepoidBreathAttack;
import com.NovaCraft.entity.AI.IDeepoidBreathAttacker;
import com.NovaCraft.particles.ParticleHandler;
import com.NovaCraftBlocks.NovaCraftBlocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityDeepoid extends EntityMob implements IDeepoidBreathAttacker 
{		
	
	public static final int BREATH_DURATION = 10;
    public static final int BREATH_DAMAGE = 7;
	
	public EntityDeepoid(final World world) {
		super(world);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIDeepoidBreathAttack(this, 1.0F, 5F, 30, 0.1F));
        this.tasks.addTask(3, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0F, false));
        this.tasks.addTask(6, new EntityAIWander(this, 1.0F));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
		setSize(0.6F, 1.8F);
		this.isImmuneToFire = true;
		this.experienceValue = 15;
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		
		//World world = MinecraftServer.getServer().worldServers[0];
        //Hardmode data = Hardmode.get(world);
        //if (data.getHardmode() == true) {
        	//this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.45D);
    		//this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(140.0D);
    		//this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0.40D);
    		//this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(12D);
    		//this.setHealth(140);
        //} else {
        	this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.35D);
    		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(70.0D);
    		this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0.40D);
    		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(5D);
    		this.setHealth(70);
        //}
	}
	
	 public int getTotalArmorValue()
	 {
	    return 10;
	 }
	
	public EntityDeepoid(World world, double x, double y, double z)
    {
        this(world);
        this.setPosition(x, y, z);
    }
	
	@Override
	protected boolean isAIEnabled()
    {
        return true;
    }
	
	@Override
    protected void entityInit()
    {
        super.entityInit();
        dataWatcher.addObject(17, Byte.valueOf((byte)0));
    }
	
	@Override
	public boolean isBreathing()
    {
        return dataWatcher.getWatchableObjectByte(17) != 0;
    }

    @Override
	public void setBreathing(boolean flag)
    {
        if (flag)
        {
            dataWatcher.updateObject(17, Byte.valueOf((byte)127));
        }
        else
        {
            dataWatcher.updateObject(17, Byte.valueOf((byte)0));
        }
    }
    @Override
    public void onLivingUpdate()
    {
    	super.onLivingUpdate();   	
        
    	if (isBreathing())
    	{
    		Vec3 look = this.getLookVec();

    		double dist = 0.9;
    		double px = this.posX + look.xCoord * dist;
    		double py = this.posY + 0.25 + look.yCoord * dist;
    		double pz = this.posZ + look.zCoord * dist;

    		for (int i = 0; i < 3; i++)
    		{
    			double dx = look.xCoord;
    			double dy = look.yCoord;
    			double dz = look.zCoord;

    			double spread = 6 + this.getRNG().nextDouble() * 2.5;
    			double velocity = 0.15 + this.getRNG().nextDouble() * 0.15;

    			dx += this.getRNG().nextGaussian() * 0.007499999832361937D * spread;
    			dy += this.getRNG().nextGaussian() * 0.007499999832361937D * spread;
    			dz += this.getRNG().nextGaussian() * 0.007499999832361937D * spread;
    			dx *= velocity;
    			dy *= velocity;
    			dz *= velocity;

    			if (worldObj.isRemote) {
    			ParticleHandler.IONFLAME.spawn(worldObj, px, py, pz, dx, dy, dz, 0.0f, new Object[0]);
    			}
    		}
    		
    		playBreathSound();
    					
    	}
    	
    	if (!this.worldObj.isRemote)
        {
            if (this.isWet())
            {
                this.attackEntityFrom(DamageSource.drown, 3.0F);
            }
           
        }
    }

	public void playBreathSound() {
		worldObj.playSoundEffect(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5, "nova_craft:deepoid.breath", rand.nextFloat() * 0.5F, rand.nextFloat() * 0.5F);
	}
	
	@Override
    public int getVerticalFaceSpeed()
    {
        return 500; 
    }
	
	@Override
	public float getEyeHeight() {
		return 0.25F;
	}
	
	public float getBrightness(float p_70013_1_)
	{
		return super.getBrightness(p_70013_1_);
	}
	
	protected void dropFewItems(boolean p_70628_1_, int chance)
	{
	     int j = this.rand.nextInt(2 + chance) + 1;

	      for (int k = 0; k < j; ++k)
	      {
	          this.entityDropItem(new ItemStack(NovaCraftItems.deepoid_scales), 0.0F);
	      }
	        
	     int j2 = 1 + this.rand.nextInt(1 + chance);
	      for (int k = 0; k < j2; ++k)
	      {
	    	  int chance_horn = (int)(1 + Math.random() * 3);
			  if (chance_horn == 2) {
				  this.entityDropItem(new ItemStack(NovaCraftItems.deepoid_horn), 0.0F);
			  }
	      }
	 }
	
	public EnumCreatureAttribute getCreatureAttribute()
    {
        return EnumCreatureAttribute.UNDEFINED;
    }

	@Override
    protected String getLivingSound()
    {
        return "nova_craft:deepoid.living";
    }

	@Override
    protected String getHurtSound()
    {
        return "nova_craft:deepoid.hurt";
    }

	@Override
    protected String getDeathSound()
    {
        return "nova_craft:deepoid.death";
    }
	
    protected String getBreathSound()
    {
        return "nova_craft:deepoid.breath";
    }
	
	@Override
    protected float getSoundVolume() {
        return 1.0F;
    }
	
	@Override
	public boolean getCanSpawnHere() {
        final int i = MathHelper.floor_double(this.posX);
        final int j = MathHelper.floor_double(this.boundingBox.minY);
        final int k = MathHelper.floor_double(this.posZ);
        final boolean canSpawn = this.worldObj.checkNoEntityCollision(this.boundingBox) && this.worldObj.getCollidingBoundingBoxes((Entity)this, this.boundingBox).isEmpty() && !this.worldObj.isAnyLiquid(this.boundingBox);          
        return ((this.worldObj.getBlock(i, j - 1, k) == NovaCraftBlocks.nullwart_bricks || this.worldObj.getBlock(i, j - 1, k) == NovaCraftBlocks.flaming_nullwart_bricks) && this.worldObj.getBlockLightValue(i, j, k) < 13 && canSpawn);
                       
    }
	
	@Override
	public void doBreathAttack(Entity target) 
	{
		if (!target.isImmuneToFire() && target.attackEntityFrom(DamageSource.inFire, BREATH_DAMAGE))
    	{
	        target.setFire(BREATH_DURATION);
	        target.attackEntityFrom(DamageSource.inFire, 5.0F);
	        target.attackEntityFrom(DamageSource.magic, 1.0F);
    	}
		else
		{
	        target.setFire(BREATH_DURATION);
			target.attackEntityFrom(DamageSource.generic, 3.0F);
			target.attackEntityFrom(DamageSource.magic, 3.0F);

		}
			
	}

}
