package com.NovaCraft.entity;

import java.util.Iterator;
import java.util.List;

import com.NovaCraft.Hardmode;
import com.NovaCraft.NovaCraft;
import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.achievements.AchievementsNovaCraft;
import com.NovaCraft.config.Configs;
import com.NovaCraft.entity.misc.EntityRayfireball;
import com.NovaCraft.entity.misc.EntitySculkHornProjectile;
import com.NovaCraft.entity.misc.EntityWardenProjectile;
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
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityWitherSkull;
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
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityWarden extends EntityMob implements IBossDisplayData
{		
	
	EntityPlayer player;
	public EntityWarden warden;
	public int shootTime;
	private boolean projectile;
	private int field_82222_j;
	private int[] field_82224_i = new int[2];
	public int deathTicks;
	
	public EntityWarden(final World p_i1745_1_) {
		super(p_i1745_1_);
		this.isImmuneToFire = true;
		getNavigator().setBreakDoors(true);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
		this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
		this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(8, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
		setSize(1F, 3F);
		this.experienceValue = 500;
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();

		//World world = MinecraftServer.getServer().worldServers[0];
        //Hardmode data = Hardmode.get(world);
        //if (data.getHardmode() == true) {
        //	this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(14D);
        //	this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(1200.0D);
        	//this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(1.0D);
			//this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(30D);
			//this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(50D);
			//this.setHealth(1200);
        //}
        //else {
        	this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(11D);
        	this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(600.0D);
        	this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(1.0D);
			this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(20D);
			this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(50D);
			this.setHealth(600);
        //}
		
	}
	
	public boolean canBreatheUnderwater()
    {
        return true;
    }
	
	 public int getTotalArmorValue()
	    {
	        return 17;
	    }
	
	public void onLivingUpdate()
	{
		
		int i = MathHelper.floor_double(this.posX);
        int j = MathHelper.floor_double(this.posY);
        int k = MathHelper.floor_double(this.posZ);
		
		for (int l = 0; l < 4; ++l)
        {
            i = MathHelper.floor_double(this.posX + (double)((float)(l % 2 * 2 - 1) * 0.25F));
            j = MathHelper.floor_double(this.posY);
            k = MathHelper.floor_double(this.posZ + (double)((float)(l / 2 % 2 * 2 - 1) * 0.25F));
            
            if (this.worldObj.getBlock(i, j, k).getMaterial() == Material.air && this.worldObj.getBiomeGenForCoords(i, k).getFloatTemperature(i, j, k) < 0.8F && NovaCraftBlocks.sculk_growth.canPlaceBlockAt(this.worldObj, i, j, k))
            {
                this.worldObj.setBlock(i, j, k, NovaCraftBlocks.sculk_growth, 1, 0);
            }
        }

		List<Entity> volume = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(5, 5, 5));
		{
		if(Configs.enableWardenBlindness) {
        for(Entity entity : volume) {
        	if(entity instanceof EntityPlayer && this.canEntityBeSeen(entity)) ((EntityPlayer)entity).addPotionEffect(new PotionEffect(Potion.blindness.id, 100, 0, true));
        	}
		}
		else {
		for(Entity entity : volume) {
	        if(entity instanceof EntityPlayer && this.canEntityBeSeen(entity)) ((EntityPlayer)entity).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 100, 1, true));
	         }

			}
		}
        
		if(Configs.enableWardenSlowness) {
        for(Entity entity : volume) {
        	if(entity instanceof EntityPlayer && this.canEntityBeSeen(entity)) ((EntityPlayer)entity).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 100, 1, true));
        	}
		}
        
		if(Configs.enableWardenWeakness) {
        for(Entity entity : volume) {
        	if(entity instanceof EntityPlayer && this.canEntityBeSeen(entity)) ((EntityPlayer)entity).addPotionEffect(new PotionEffect(Potion.weakness.id, 100, 0, true));
        	}
		}
        
        if (isWet()){
            this.addPotionEffect(new PotionEffect(Potion.regeneration.id, 300, 4));
            this.heal(10.0F);	
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
	    	final float f = MathHelper.cos((48 + this.ticksExisted) * 0.13f + 3.1415927f);
            final float f2 = MathHelper.cos((48 + this.ticksExisted + 1) * 0.13f + 3.1415927f);
            if (f > 0.0f && f2 <= 0.0f) {
	    	this.playSound("nova_craft:warden.heartbeat", 2.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));
            }
	    	if (Configs.enableWardenParticles) {
	    	for (k = 0; k < 1; ++k)
	        {
	        	ParticleHandler.WARDEN.spawn(worldObj, this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height - 0.25D, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width);
	        }
	        
	        for (k = 0; k < 1; ++k)
	        {
	        	ParticleHandler.WARDEN.spawn(worldObj, this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height + 0.25D, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width);
	        	}
	    	  }
	    	}
	    }
	
	@Override
    public boolean attackEntityFrom(DamageSource source, float amount)
    {
		if (source == DamageSource.drown || source == DamageSource.wither || source == DamageSource.inWall  || source.isProjectile() || source.isExplosion())
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
	
	
	public boolean attackEntityAsMob(final Entity target) {
		
		boolean flag = super.attackEntityAsMob(target);
        		      	
		this.heal(10.0F);
		this.addPotionEffect(new PotionEffect(Potion.regeneration.id, 150, 4));
		this.addPotionEffect(new PotionEffect(Potion.jump.id, 100, 2));
        this.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 100, 1));               

        if (target instanceof EntityPlayer) {

            ItemStack helmet = ((EntityPlayer) target).getCurrentArmor(3);
            ItemStack chest = ((EntityPlayer) target).getCurrentArmor(2);
            ItemStack legs = ((EntityPlayer) target).getCurrentArmor(1);
            ItemStack boots = ((EntityPlayer) target).getCurrentArmor(0);
            
            boolean hasWardenHelmet = false;
            boolean hasWardenChest = false;
            boolean hasWardenLegs = false;
            boolean hasWardenBoots = false;

            if(helmet != null)
                hasWardenHelmet = helmet.getItem() == NovaCraftItems.warden_helmet || helmet.getItem() == NovaCraftItems.crystalite_helmet;

            if(chest != null)
                hasWardenChest = chest.getItem() == NovaCraftItems.warden_chestplate || chest.getItem() == NovaCraftItems.crystalite_chestplate;

            if(legs != null)
                hasWardenLegs = legs.getItem() == NovaCraftItems.warden_leggings || legs.getItem() == NovaCraftItems.crystalite_leggings;

            if(boots != null)
                hasWardenBoots = boots.getItem() == NovaCraftItems.warden_boots || boots.getItem() == NovaCraftItems.crystalite_boots;

            if (hasWardenHelmet && hasWardenChest && hasWardenLegs && hasWardenBoots) {

            	target.attackEntityFrom(DamageSource.causeMobDamage(this), 22.0F);
            	target.attackEntityFrom(DamageSource.magic, 12.0F);
            }
            
            else {
            	target.attackEntityFrom(DamageSource.causeMobDamage(this), 64.0F);
            	target.attackEntityFrom(DamageSource.magic, 12.0F);
            	target.attackEntityFrom(DamageSource.wither, 2.0F);
            	target.attackEntityFrom(DamageSource.outOfWorld, 1.0F);
            	
            	 ((EntityLivingBase) target).addPotionEffect(new PotionEffect(Potion.harm.id, 20, 1));
            }
             
        }
        
        return true;
    }
	
	@Override
	public void onUpdate() {
		super.onUpdate();

		if (this.entityToAttack instanceof EntityPlayer && this.shouldAttackPlayer((EntityPlayer)this.entityToAttack))
        {
			
		if (this.getEntityToAttack() != null) {
			if (this.getAttackTarget() instanceof EntityPlayer && ((EntityPlayer) this.getAttackTarget()).capabilities.isCreativeMode) {
				this.setAttackTarget(null);
			}
			else {
				double d = this.getEntityToAttack().posX - this.posX;
				double d1 = this.getEntityToAttack().posZ - this.posZ;

				this.getLookHelper().setLookPositionWithEntity(this.getEntityToAttack(), 30.0F, 30.0F);

				if (this.shootTime >= 20 && this.canEntityBeSeen(this.getEntityToAttack())) {
					this.shootTarget();
					this.shootTime = -60;
				}

				if (this.shootTime < 20) {
					this.shootTime += 5;
				}

				this.rotationYaw = (float) ((Math.atan2(d1, d) * 180D) / 3.1415927410125732D) - 90F;
				}
			
			}
				
		}
				
		if (!this.worldObj.isRemote && this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL) {
			this.setDead();
		}
	}
	
	protected void onDeathUpdate()
    {
		 ++this.deathTicks;
	        if (this.deathTicks >= 180 && this.deathTicks <= 200)
	        {
	            float f = (this.rand.nextFloat() - 0.5F) * 8.0F;
	            float f1 = (this.rand.nextFloat() - 0.5F) * 4.0F;
	            float f2 = (this.rand.nextFloat() - 0.5F) * 8.0F;
	            this.worldObj.spawnParticle("hugeexplosion", this.posX + (double)f, this.posY + 2.0D + (double)f1, this.posZ + (double)f2, 0.0D, 0.0D, 0.0D);
	           
	         }

	        int i;
	        int j;

	        if (!this.worldObj.isRemote)
	        {
	            if (this.deathTicks > 150 && this.deathTicks % 5 == 0)
	            {
	                i = 1000;

	                while (i > 0)
	                {
	                    j = EntityXPOrb.getXPSplit(i);
	                    i -= j;
	                    this.worldObj.spawnEntityInWorld(new EntityXPOrb(this.worldObj, this.posX, this.posY, this.posZ, j));
	                }
	            }

	            if (this.deathTicks == 1)
	            {
	                this.worldObj.playBroadcastSound(1018, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
	            }
	        }

	        this.moveEntity(0.0D, 0.10000000149011612D, 0.0D);
	        this.renderYawOffset = this.rotationYaw += 20.0F;

	        if (this.deathTicks == 200 && !this.worldObj.isRemote)
	        {
	            i = 500;

	            while (i > 0)
	            {
	                j = EntityXPOrb.getXPSplit(i);
	                i -= j;
	                this.worldObj.spawnEntityInWorld(new EntityXPOrb(this.worldObj, this.posX, this.posY, this.posZ, j));
	            }

	            this.createloot(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ));
	            this.setDead();
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
            
            entityplayer.triggerAchievement(AchievementsNovaCraft.reached_for_things_I_didnt_need);
            
        }
            
    }
	
	private void createloot(int p_70975_1_, int p_70975_2_, int p_70975_3_)
    {
		this.worldObj.setBlock(p_70975_1_, p_70975_2_, p_70975_3_, NovaCraftBlocks.sculk_chest);
		this.worldObj.setBlock(p_70975_1_, p_70975_2_ + 1, p_70975_3_, NovaCraftBlocks.sculk_chest);
    }
	
	private boolean shouldAttackPlayer(EntityPlayer p_70821_1_)
    {
        
            Vec3 vec3 = p_70821_1_.getLook(1.0F).normalize();
            Vec3 vec31 = Vec3.createVectorHelper(this.posX - p_70821_1_.posX, this.boundingBox.minY + (double)(this.height / 2.0F) - (p_70821_1_.posY + (double)p_70821_1_.getEyeHeight()), this.posZ - p_70821_1_.posZ);
            double d0 = vec31.lengthVector();
            vec31 = vec31.normalize();
            double d1 = vec3.dotProduct(vec31);
            return d1 > 1.0D - 0.025D / d0 && p_70821_1_.canEntityBeSeen(this);
        
    }

	public void shootTarget() {
		if (this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL) {
			return;
		}		
		
		if (isWet()) {
		EntityWardenProjectile entityarrow2 = new EntityWardenProjectile(this.worldObj, this, 20.0F);
		this.playSound("nova_craft:sculk_horn.vibration", 2.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));
		this.worldObj.spawnEntityInWorld(entityarrow2);	
			
		}
		
		else {
			
			EntityWardenProjectile entityarrow = new EntityWardenProjectile(this.worldObj, this, 10.0F);
			this.playSound("nova_craft:sculk_horn.vibration", 2.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));
			this.worldObj.spawnEntityInWorld(entityarrow);
			
		}
	}
	
	protected Entity findEnemyToAttack() {
        final List list = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(8.0, 4.0, 8.0));
        for (int i = 0; i < list.size(); ++i) {
            final Entity entity = (Entity) list.get(i);
            if (entity != null && (entity instanceof EntitySlime || entity instanceof EntityMob || entity instanceof EntityAnimal)) {
                this.entityToAttack = entity;
            }
        }
        return null;
    }
	
	 protected void dropFewItems(boolean p_70628_1_, int p_70628_2_)
	    {
	        int j;
	        int k;
	        {
	            j = this.rand.nextInt(3 + p_70628_2_);

	            for (k = 0; k < j; ++k)
	            {
	                this.dropItem(NovaCraftItems.sculk_flesh, 7);
	            }
	        }
	        
	        this.entityDropItem(new ItemStack(NovaCraftItems.warden_heart), 0.5F);
	        j = this.rand.nextInt(1 + p_70628_2_);
	        
	        for (k = 0; k < j; ++k)
	        {
	        	this.dropItem(NovaCraftItems.warden_tentacle, p_70628_2_);
	        }	
	        
	        j = this.rand.nextInt(3 + p_70628_2_);
	        
	        for (k = 0; k < j; ++k)
	        {
	        	this.dropItem(NovaCraftItems.warden_shard, 4 + p_70628_2_);
	        }	       

	        j = this.rand.nextInt(3 + p_70628_2_);

	        for (k = 0; k < j; ++k)
	        {
	        	this.dropItem(Item.getItemFromBlock(NovaCraftBlocks.sculk_block), 12);
	        }
	        
	        j = this.rand.nextInt(3 + p_70628_2_);

	        for (k = 0; k < j; ++k)
	        {
	        	this.dropItem(NovaCraftItems.anomalous_essence, 6 + p_70628_2_);
	        }
	    }
	
	public EnumCreatureAttribute getCreatureAttribute()
    {
        return EnumCreatureAttribute.UNDEFINED;
    }
	
	protected void dropRareDrop(int p_70600_1_)
    {    
       this.dropItem(NovaCraftItems.warden_tentacle, 2);
       this.dropItem(NovaCraftItems.warden_heart, 1);
    }
	
	protected String getHeartbeatSound() {
	      return "nova_craft:warden.heartbeat";
	 }
	
	protected String getVibrationSound() {
	      return "nova_craft:sculk_horn.vibration";
	 }

	@Override
    protected String getLivingSound()
    {
        return "nova_craft:sculk_dweller.living";
    }

	@Override
    protected String getHurtSound()
    {
        return "nova_craft:sculk_dweller.hurt";
    }

	@Override
    protected String getDeathSound()
    {
        return "nova_craft:sculk_dweller.death";
    }
	
	public World func_82194_d()
    {
        return this.worldObj;
    }
	
	@Override
    protected float getSoundVolume() {
        return 3.0F;
    }
	
	public boolean canDespawn() {
        return false;
    }

}
