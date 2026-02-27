package com.NovaCraft.entity;

import java.util.List;
import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.achievements.AchievementsNovaCraft;
import com.NovaCraft.config.Configs;
import com.NovaCraft.entity.misc.EntityWardenProjectile;
import com.NovaCraft.particles.ParticleHandler;
import com.NovaCraftBlocks.NovaCraftBlocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityWarden extends EntityMob implements IBossDisplayData {

	public EntityWarden warden;
	public int shootTime;
	public int deathTicks;
	public int attackAnimationTicks;
	private static final int SONIC_ANIMATION = 20;
	
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
		this.experienceValue = 500;
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
        	this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(11D);
        	this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(600.0D);
        	this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(1.0D);
			this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(20D);
			this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(60D);
			this.setHealth(600);
	}

	@Override
	protected void entityInit() {
		super.entityInit();
		this.dataWatcher.addObject(SONIC_ANIMATION, 0);
	}

	public void startSonicBoomAnimation(int ticks) {
		this.dataWatcher.updateObject(SONIC_ANIMATION, ticks);
	}

	public int getSonicBoomTicks() {
		return this.dataWatcher.getWatchableObjectInt(SONIC_ANIMATION);
	}
	
	public boolean canBreatheUnderwater()
    {
        return true;
    }
	
	 public int getTotalArmorValue()
	    {
	        return 17;
	    }
	
	public void onLivingUpdate() {
		int chance = (int)(1 + Math.random() * 30000);
		List<Entity> volume = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(3, 3, 3));

		if (Configs.enableWardenSlowness && chance < 15000) {
			for (Entity entity : volume) {
				if (entity instanceof EntityPlayer && this.canEntityBeSeen(entity))
					((EntityPlayer) entity).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 100, 1, true));
			}
		}

		if (Configs.enableWardenWeakness && chance > 22500) {
			for (Entity entity : volume) {
				if (entity instanceof EntityPlayer && this.canEntityBeSeen(entity))
					((EntityPlayer) entity).addPotionEffect(new PotionEffect(Potion.weakness.id, 100, 0, true));
			}
		}

        
        if (isWet()) {
            this.addPotionEffect(new PotionEffect(Potion.regeneration.id, 140, 3));
            this.heal(10.0F);	
		}
		
		super.onLivingUpdate();
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void onEntityUpdate() {
		super.onEntityUpdate();

		if (!this.worldObj.isRemote) return;

		Minecraft mc = Minecraft.getMinecraft();
		EntityPlayer player = mc.thePlayer;

		if (player == null) return;

		if (player.isPotionActive(Potion.blindness)) {
			double dx = this.posX - player.posX;
			double dy = (this.posY + this.height / 2.0D) - (player.posY + player.getEyeHeight());
			double dz = this.posZ - player.posZ;

			double distance = Math.sqrt(dx * dx + dy * dy + dz * dz);

			if (distance < 50.0D) {
				int chance = (int)(1 + Math.random() * 100);
				if (chance > 75) {
					int steps = (int) (distance);
					for (int i = 0; i <= steps; i++) {
						double t = (double) i / (double) steps;
						double px = player.posX + dx * t + (rand.nextDouble() - 0.5D) * 0.2D;
						double py = player.posY + player.getEyeHeight() + dy * t + (rand.nextDouble() - 2.5D) * 0.2D;
						double pz = player.posZ + dz * t + (rand.nextDouble() - 0.5D) * 0.2D;

						ParticleHandler.VIBRATION.spawn(worldObj, px, py, pz);
					}
				}
			}
		}
	}

	@Override
	public boolean attackEntityFrom(DamageSource source, float amount) {
		if (this.isEntityInvulnerable()) {
			return false;
		}

		if (source == DamageSource.outOfWorld) {
			return super.attackEntityFrom(source, amount);
		}

		if (source.getEntity() instanceof EntityPlayer) {

			EntityPlayer player = (EntityPlayer) source.getEntity();

			if (!player.isPotionActive(Potion.blindness)) {
				amount *= 0.25F;
			}
		}

		double hitY = -1.0D;

		if (source.getSourceOfDamage() != null) {

			Entity src = source.getSourceOfDamage();

			if (src instanceof EntityArrow) {
				hitY = src.posY;
			}
		}

		if (hitY < 0.0D && source.getEntity() != null) {

			Entity attacker = source.getEntity();

			hitY = attacker.posY + attacker.getEyeHeight() - 0.3D;
		}

		if (hitY < 0.0D) {
			return false;
		}

		if (!(isHeartHit(hitY))) {
			return false;
		}

		return super.attackEntityFrom(source, amount);
	}

	private boolean isHeartHit(double hitY) {
		double heartMin = this.posY + 1.3D;
		double heartMax = this.posY + 1.9D;

		return hitY >= heartMin && hitY <= heartMax;
	}

	private boolean canHitTarget(Entity target) {
		double reach = 4.5D;
		return this.getDistanceSqToEntity(target) <= reach * reach;
	}


	@Override
	public boolean attackEntityAsMob(Entity target) {
		if (!canHitTarget(target)) {
			return false;
		}

		this.swingItem();

		float damage = (float)this.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();

		if (target instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) target;
			if (!player.isPotionActive(Potion.blindness)) {
				this.heal(10.0F);
				this.addPotionEffect(new PotionEffect(Potion.regeneration.id, 240, 3));
				this.addPotionEffect(new PotionEffect(Potion.jump.id, 120, 2));
				this.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 120, 1));
			}
			if (player.isPotionActive(Potion.blindness)) {
				this.heal(3.0F);
				this.addPotionEffect(new PotionEffect(Potion.regeneration.id, 80, 3));
				this.addPotionEffect(new PotionEffect(Potion.jump.id, 100, 2));
				this.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 100, 1));
			}

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
            	target.attackEntityFrom(DamageSource.causeMobDamage(this), 32.0F);
            	target.attackEntityFrom(DamageSource.magic, 14.0F);
            }
			else if ((!hasWardenHelmet && hasWardenChest && hasWardenLegs && hasWardenBoots) || (hasWardenHelmet && !hasWardenChest && hasWardenLegs && hasWardenBoots) || (hasWardenHelmet && hasWardenChest && !hasWardenLegs && hasWardenBoots) || (hasWardenHelmet && hasWardenChest && hasWardenLegs && !hasWardenBoots)) {
				target.attackEntityFrom(DamageSource.causeMobDamage(this), 40.0F);
				target.attackEntityFrom(DamageSource.magic, 14.0F);
			}
			else if ((!hasWardenHelmet && !hasWardenChest && hasWardenLegs && hasWardenBoots) || (!hasWardenHelmet && hasWardenChest && !hasWardenLegs && hasWardenBoots) || (!hasWardenHelmet && hasWardenChest && hasWardenLegs && !hasWardenBoots)
					|| (hasWardenHelmet && !hasWardenChest && !hasWardenLegs && hasWardenBoots) || (hasWardenHelmet && !hasWardenChest && hasWardenLegs && !hasWardenBoots) || (hasWardenHelmet && hasWardenChest && !hasWardenLegs && !hasWardenBoots)) {
				target.attackEntityFrom(DamageSource.causeMobDamage(this), 48.0F);
				target.attackEntityFrom(DamageSource.magic, 16.0F);
			}
			else if ((!hasWardenHelmet && !hasWardenChest && !hasWardenLegs && hasWardenBoots) || (hasWardenHelmet && !hasWardenChest && !hasWardenLegs && !hasWardenBoots) || (!hasWardenHelmet && hasWardenChest && !hasWardenLegs && !hasWardenBoots) || (!hasWardenHelmet && !hasWardenChest && hasWardenLegs && !hasWardenBoots)) {
				target.attackEntityFrom(DamageSource.causeMobDamage(this), 56.0F);
				target.attackEntityFrom(DamageSource.magic, 18.0F);
				target.attackEntityFrom(DamageSource.wither, 1.0F);
			}
            else {
            	target.attackEntityFrom(DamageSource.causeMobDamage(this), 64.0F);
            	target.attackEntityFrom(DamageSource.magic, 20.0F);
            	target.attackEntityFrom(DamageSource.wither, 2.0F);
            	target.attackEntityFrom(DamageSource.outOfWorld, 1.0F);
            	
				((EntityLivingBase) target).addPotionEffect(new PotionEffect(Potion.harm.id, 20, 1));
            }
             
        } else if (target instanceof EntityLivingBase) {
			((EntityLivingBase)target).attackEntityFrom(DamageSource.causeMobDamage(this), damage);
		}
        
        return true;
    }
	
	@Override
	public void onUpdate() {
		super.onUpdate();

		if (this.attackAnimationTicks > 0) {
			this.attackAnimationTicks--;
		}

		int sonic = this.getSonicBoomTicks();
		if (sonic > 0) {
			this.dataWatcher.updateObject(SONIC_ANIMATION, sonic - 1);
		}

		if (this.entityToAttack instanceof EntityPlayer && this.shouldAttackPlayer((EntityPlayer)this.entityToAttack)) {
		if (this.getEntityToAttack() != null) {
			if (this.getAttackTarget() instanceof EntityPlayer && ((EntityPlayer) this.getAttackTarget()).capabilities.isCreativeMode) {
				this.setAttackTarget(null);
			}
			else {
				double d = this.getEntityToAttack().posX - this.posX;
				double d1 = this.getEntityToAttack().posZ - this.posZ;

				this.getLookHelper().setLookPositionWithEntity(this.getEntityToAttack(), 60.0F, 60.0F);

				if (this.shootTime >= 20 && this.canEntityBeSeen(this.getEntityToAttack())) {
					this.shootTarget();
					this.startSonicBoomAnimation(25);
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
	
	protected void onDeathUpdate() {
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

    public void onDeath(DamageSource p_70645_1_) {
        super.onDeath(p_70645_1_);

        if (p_70645_1_.getEntity() instanceof EntityPlayer)
        {
            EntityPlayer entityplayer = (EntityPlayer)p_70645_1_.getEntity();
            
            entityplayer.triggerAchievement(AchievementsNovaCraft.reached_for_things_I_didnt_need);
            
        }
            
    }

	private void createloot(int x, int y, int z) {
		if (shouldReplaceBlock(x, y, z)) {
			this.worldObj.setBlock(x, y, z, NovaCraftBlocks.sculk_chest);
		}

		if (shouldReplaceBlock(x, y + 1, z)) {
			this.worldObj.setBlock(x, y + 1, z, NovaCraftBlocks.sculk_chest);
		}
	}

	private boolean shouldReplaceBlock(int x, int y, int z) {
		Block block = this.worldObj.getBlock(x, y, z);

		if (block.isAir(this.worldObj, x, y, z)) {
			return true;
		}

		float hardness = block.getBlockHardness(this.worldObj, x, y, z);
		return hardness >= 0.0F;
	}
	
	private boolean shouldAttackPlayer(EntityPlayer p_70821_1_) {
		Vec3 vec3 = p_70821_1_.getLook(1.0F).normalize();
		Vec3 vec31 = Vec3.createVectorHelper(this.posX - p_70821_1_.posX, this.boundingBox.minY + (double)(this.height / 2.0F) - (p_70821_1_.posY + (double)p_70821_1_.getEyeHeight()), this.posZ - p_70821_1_.posZ);
		double d0 = vec31.lengthVector();
		vec31 = vec31.normalize();
		double d1 = vec3.dotProduct(vec31);
		return d1 > 1.0D - 0.025D / d0 && p_70821_1_.canEntityBeSeen(this);
    }

	public void shootTarget() {
		if (this.worldObj.isRemote) return;
		if (this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL) return;

		EntityWardenProjectile projectile = new EntityWardenProjectile(this.worldObj, this);
		projectile.posX += projectile.motionX * 1.5D;
		projectile.posY += projectile.motionY * 1.5D;
		projectile.posZ += projectile.motionZ * 1.5D;

		this.worldObj.spawnEntityInWorld(projectile);

		this.playSound("nova_craft:sculk_horn.vibration", 2.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));
	}
	
	 protected void dropFewItems(boolean p_70628_1_, int p_70628_2_) {
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
	
	public EnumCreatureAttribute getCreatureAttribute() {
        return EnumCreatureAttribute.UNDEFINED;
    }
	
	protected void dropRareDrop(int p_70600_1_) {
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
    protected String getLivingSound() {
        return "nova_craft:sculk_dweller.living";
    }

	@Override
    protected String getHurtSound() {
        return "nova_craft:sculk_dweller.hurt";
    }

	@Override
    protected String getDeathSound() {
        return "nova_craft:sculk_dweller.death";
    }
	
	public World func_82194_d() {
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
