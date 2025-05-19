package com.NovaCraft.entity;

import com.NovaCraft.Hardmode;
import com.NovaCraft.NovaCraft;
import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.entity.AI.EntityAIDeepoidBreathAttack;
import com.NovaCraft.entity.AI.EntityAILavaSwimming;
import com.NovaCraft.entity.AI.IDeepoidBreathAttacker;
import com.NovaCraft.particles.ParticleHandler;
import com.NovaCraftBlocks.NovaCraftBlocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
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
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityPigZombie;
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
import net.minecraft.util.Vec3;
import net.minecraft.world.World;


public class EntityBlazingSerpentQueen extends EntityMob implements IDeepoidBreathAttacker, IBossDisplayData 
{		
	public static final int BREATH_DURATION = 16;
    public static final int BREATH_DAMAGE = 3;
    public static final int BREATH_DAMAGE_NOTFIRE = 3;
	
	public EntityBlazingSerpentQueen(final World p_i1745_1_) {
		super(p_i1745_1_);
		
		this.tasks.addTask(0, new EntityAILavaSwimming(this));
		this.tasks.addTask(2, new EntityAIDeepoidBreathAttack(this, 1.0F, 5F, 30, 0.1F));
        this.tasks.addTask(3, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0F, false));
        this.tasks.addTask(6, new EntityAIWander(this, 1.0F));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));		
        this.isImmuneToFire = true;		
		setSize(1.5F, 1.5F);
		this.experienceValue = 40;
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		
        	this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.22D);
    		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(180.0D);
    		this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0.20D);
    		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(13D);
    		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(30D);
    		this.setHealth(180);
	}
	
	 public int getTotalArmorValue() {
	       return 8;
     }

	 public EntityBlazingSerpentQueen(World world, double x, double y, double z)
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
	public boolean attackEntityAsMob(final Entity entity) {
		final boolean flag = super.attackEntityAsMob(entity);
		if (flag) {
			final int i = this.worldObj.difficultySetting.getDifficultyId();
			if (this.getHeldItem() == null && this.isBurning() && this.rand.nextFloat() < i * 0.3f) {
				entity.setFire(0 * i);
			}
		}
		
		if (this.handleLavaMovement() == true) {
		this.addPotionEffect(new PotionEffect(Potion.regeneration.id, 30, 0));  
		}
		
		((EntityLivingBase) entity).addPotionEffect(new PotionEffect(Potion.poison.id, 200, 0));
		entity.setFire(7);
        
                
		return flag;
	}
	
	public boolean getCanSpawnHere() {
        final int i = MathHelper.floor_double(this.posX);
        final int j = MathHelper.floor_double(this.boundingBox.minY);
        final int k = MathHelper.floor_double(this.posZ);
        final boolean canSpawn = this.worldObj.checkNoEntityCollision(this.boundingBox) && this.worldObj.getCollidingBoundingBoxes((Entity)this, this.boundingBox).isEmpty() && !this.worldObj.isAnyLiquid(this.boundingBox);          
        return this.worldObj.getBlockLightValue(i, j, k) < 12  && this.posY <= 64.0D && canSpawn;
                      
    }
	
	public boolean handleLavaMovement()
    {
        return this.worldObj.isMaterialInBB(this.boundingBox.expand(-0.10000000149011612D, -0.4000000059604645D, -0.10000000149011612D), Material.lava);
    }
	
	@Override
	public void onLivingUpdate()
	{			
		super.onLivingUpdate();   	
        
    	if (isBreathing())
    	{
    		Vec3 look = this.getLookVec();

    		double dist = 2.6; //3.2
    		double px = this.posX + look.xCoord * dist;
    		double py = this.posY - 0.15 + look.yCoord * dist; //0.25
    		double pz = this.posZ + look.zCoord * dist;

    		for (int i = 0; i < 3; i++)
    		{
    			double dx = look.xCoord;
    			double dy = look.yCoord;
    			double dz = look.zCoord;

    			double spread = 6 + this.getRNG().nextDouble() * 2.5; //5
    			double velocity = 0.15 + this.getRNG().nextDouble() * 0.15; //0.15

    			dx += this.getRNG().nextGaussian() * 0.007499999832361937D * spread;
    			dy += this.getRNG().nextGaussian() * 0.007499999832361937D * spread;
    			dz += this.getRNG().nextGaussian() * 0.007499999832361937D * spread;
    			dx *= velocity;
    			dy *= velocity;
    			dz *= velocity;

    			if (worldObj.isRemote) {
    			ParticleHandler.REGULARFLAME.spawn(worldObj, px, py, pz, dx, dy, dz, 0.0f, new Object[0]);
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
    		
    	for (int i = 0; i < 1; ++i)
        {
          this.worldObj.spawnParticle("flame", this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, 0.0D, 0.0D, 0.0D);
        }
		
	}
	
	@Override
    public boolean attackEntityFrom(DamageSource source, float amount)
    {
		if (source == DamageSource.inWall)
        {
            return false;
        }

        return super.attackEntityFrom(source, amount);
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
	
	 protected void dropFewItems(boolean p_70628_1_, int p_70628_2_)
	    {
	        int j;
	        int k;
	        {
	            j = this.rand.nextInt(1 + p_70628_2_);

	            for (k = 0; k < j; ++k)
	            {
	                this.dropItem(NovaCraftItems.blazing_serpent_scales, 1 + p_70628_2_);
	            }
	        }
	        
	        this.entityDropItem(new ItemStack(NovaCraftItems.serpent_crown), 0.5F);
	        
	    }
	 
	protected void dropRareDrop(int p_70600_1_)
	 {	
	  this.dropItem(NovaCraftItems.blazing_serpent_tooth, 1);
	 }
	
	public EnumCreatureAttribute getCreatureAttribute()
    {
        return EnumCreatureAttribute.UNDEFINED;
    }
	
	protected String getHurtSound() {
        return "nova_craft:blazing_serpent.hurt";
    }
    
    protected String getDeathSound() {
        return "nova_craft:blazing_serpent.hurt";
    }
    
    protected String getChargeSound() {
        return null;
    }
	
	@Override
    protected float getSoundVolume() {
        return 1.86F;
    }
	
	protected float getSoundPitch()
    {
        return super.getSoundPitch() * 1.20F;
    }
    
    @Override
	public void doBreathAttack(Entity target) 
	{
		if (!target.isImmuneToFire() && target.attackEntityFrom(DamageSource.inFire, BREATH_DAMAGE))
    	{
			target.setFire(BREATH_DURATION);
	        target.attackEntityFrom(DamageSource.generic, 4.0F);
	        ((EntityLivingBase) target).addPotionEffect(new PotionEffect(Potion.poison.id, 100, 1));
    	}
		else
		{
			target.setFire(BREATH_DURATION);
			target.attackEntityFrom(DamageSource.inFire, 3.0F);
	        target.attackEntityFrom(DamageSource.generic, 2.0F);
	        ((EntityLivingBase) target).addPotionEffect(new PotionEffect(Potion.poison.id, 100, 1));

		}
			
	}
    
    public boolean canDespawn() {
        return false;
    }
    
    public World func_82194_d()
    {
        return this.worldObj;
    }

}
