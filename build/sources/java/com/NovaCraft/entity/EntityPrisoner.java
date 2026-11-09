package com.NovaCraft.entity;

import java.util.List;
import com.NovaCraft.Hardmode;
import com.NovaCraft.ServerMessage;
import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.achievements.AchievementsNovaCraft;
import com.NovaCraft.config.Configs;
import com.NovaCraft.entity.misc.EntityWardenProjectile;
import com.NovaCraft.particles.ParticleHandler;
import com.NovaCraftBlocks.NovaCraftBlocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityPrisoner extends EntityAnimal implements IBossDisplayData
{		
	boolean angry = false;
	public EntityPrisoner warden;
	public int shootTime;
	private int field_82222_j;
	private int[] field_82224_i = new int[2];
	private boolean hardmodeStatsApplied = false;
	
	public EntityPrisoner(final World world) {
		super(world);
		this.isImmuneToFire = true;
		setSize(1F, 8F);
		this.experienceValue = 500;
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(1000.0D);
		this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(1.0D);
		this.setHealth(1000);
	}
	

	@Override
	public void addVelocity(double x, double y, double z) {
	}
	
	@Override
	protected boolean isMovementBlocked() {
		return true;
	}
	
	@Override
	public void moveEntity(double x, double y, double z) {
	}
	
	@Override
	public boolean canBePushed() {
		return false;
	}
	
	@Override
	public void onCollideWithPlayer(EntityPlayer player) {
	}
	
	public boolean canBreatheUnderwater()
    {
        return true;
    }
	
	public int getTotalArmorValue()
	{
	    return 17;
	}
	
	public void summonMinions() {
    	if (!this.worldObj.isRemote) {
    		EntityNulk nulk = new EntityNulk(this.worldObj);
    		nulk.setLocationAndAngles(this.posX + 3, this.posY, this.posZ, this.rotationYaw, 0.0F);
    		nulk.setAttackTarget(this.getAttackTarget());
    		this.worldObj.spawnEntityInWorld(nulk);
    		this.playSound("nova_craft:sculk.break", 0.5f, 1.0f);
    	}
    	
    }
	
	public void onLivingUpdate()
	{
		if (this.worldObj.getBlock(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY) - 1, MathHelper.floor_double(this.posZ)) != NovaCraftBlocks.unknown_portal_sealed) {
			this.setHealth(1000.0F);
		}
		else if (this.worldObj.getBlock(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY) - 1, MathHelper.floor_double(this.posZ)) == NovaCraftBlocks.unknown_portal_sealed && angry == false) {
			this.playSound("nova_craft:warden.roar", 0.5f, 1.0f);
			angry = true;
		}
		
		if (this.rand.nextInt(10) == 1 && this.getEntityToAttack() != null) {
            this.summonMinions();
        }

		if (!this.worldObj.isRemote) {
			List<EntityPlayer> players = this.worldObj.getEntitiesWithinAABB(EntityPlayer.class, this.boundingBox.expand(8, 8, 8));

			for (EntityPlayer player : players) {
				if (!this.canEntityBeSeen(player)) continue;

				player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 100, 0, true));
				if (Configs.enableWardenSlowness)
					player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 100, 1, true));
				if (Configs.enableWardenWeakness)
					player.addPotionEffect(new PotionEffect(Potion.weakness.id, 100, 0, true));
			}
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
	    	if (Configs.enableWardenParticles) {
	    	for (k = 0; k < 1; ++k)
	        {
	        	ParticleHandler.PORTAL_PARTICLE.spawn(worldObj, this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height - 0.25D, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width);
	        }
	        
	        for (k = 0; k < 1; ++k)
	        {
	        	ParticleHandler.PORTAL_PARTICLE.spawn(worldObj, this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height + 0.25D, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width);
	        	}
	    	  }
	    	}
	    }
	
	@Override
    public boolean attackEntityFrom(DamageSource source, float amount)
    {
		Entity entity2 = source.getEntity();
		if (entity2 instanceof EntityPlayer)
        {
		int summon_chance = (int)(1 + Math.random() * 150);
       	 if(summon_chance <= 25 ) {
       		this.playSound("nova_craft:sculk.break", 0.5f, 1.0f);
       		EntityNulk nulk = new EntityNulk(this.worldObj);
    		nulk.setLocationAndAngles(this.posX + 3, this.posY, this.posZ, this.rotationYaw, 0.0F);
    		nulk.setAttackTarget(this.getAttackTarget());

               if (!this.worldObj.isRemote) {
                   this.worldObj.spawnEntityInWorld(nulk);
               	}
               
          	EntityNulk nulk2 = new EntityNulk(this.worldObj);
          	nulk2.setLocationAndAngles(this.posX + 6, this.posY, this.posZ, this.rotationYaw, 0.0F);
          	nulk2.setAttackTarget(this.getAttackTarget());

                if (!this.worldObj.isRemote) {
                    this.worldObj.spawnEntityInWorld(nulk2);
                }
               
       		}
       	if(summon_chance > 25 && summon_chance <= 50) {
       		this.playSound("nova_craft:sculk.break", 1.0f, 1.0f);
       		EntityNuxx nuxx = new EntityNuxx(this.worldObj);
       		nuxx.setLocationAndAngles(this.posX + 3, this.posY, this.posZ, this.rotationYaw, 0.0F);
       		nuxx.setAttackTarget(this.getAttackTarget());

               if (!this.worldObj.isRemote) {
                   this.worldObj.spawnEntityInWorld(nuxx);
               	}
               
            EntityNuxx nuxx2 = new EntityNuxx(this.worldObj);
            nuxx2.setLocationAndAngles(this.posX + 6, this.posY, this.posZ, this.rotationYaw, 0.0F);
          	nuxx2.setAttackTarget(this.getAttackTarget());

               if (!this.worldObj.isRemote) {
                   this.worldObj.spawnEntityInWorld(nuxx2);
               }
               
           EntityNuxx nuxx3 = new EntityNuxx(this.worldObj);
           nuxx3.setLocationAndAngles(this.posX + 7, this.posY, this.posZ, this.rotationYaw, 0.0F);
           nuxx3.setAttackTarget(this.getAttackTarget());

               if (!this.worldObj.isRemote) {
                   this.worldObj.spawnEntityInWorld(nuxx3);
               }
               
       		}
       	
       	if(summon_chance > 50 && summon_chance <= 100) {
       		this.playSound("nova_craft:sculk.break", 1.0f, 1.0f);
       		EntityOutsiderEye outsider = new EntityOutsiderEye(this.worldObj);
       		outsider.setLocationAndAngles(this.posX + 30, this.posY, this.posZ, this.rotationYaw, 0.0F);
       		outsider.setAttackTarget(this.getAttackTarget());

               if (!this.worldObj.isRemote) {
                   this.worldObj.spawnEntityInWorld(outsider);
               	}
               
               EntityOutsiderEye outsider1 = new EntityOutsiderEye(this.worldObj);
               outsider1.setLocationAndAngles(this.posX + 10, this.posY, this.posZ, this.rotationYaw, 0.0F);
               outsider1.setAttackTarget(this.getAttackTarget());

               if (!this.worldObj.isRemote) {
                   this.worldObj.spawnEntityInWorld(outsider1);
               }
               
               EntityOutsiderEye outsider2 = new EntityOutsiderEye(this.worldObj);
               outsider2.setLocationAndAngles(this.posX - 30, this.posY, this.posZ, this.rotationYaw, 0.0F);
               outsider2.setAttackTarget(this.getAttackTarget());

               if (!this.worldObj.isRemote) {
                   this.worldObj.spawnEntityInWorld(outsider2);
               }
       		}
        }
		
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
	
	@Override
    public void applyEntityCollision(Entity entity) {
            boolean flag = entity.attackEntityFrom(DamageSource.generic, 30.0F);

            if (flag && entity instanceof EntityLivingBase) {
            	entity.addVelocity(entity.motionY, 3.0D, entity.motionZ);
                this.worldObj.playSoundEffect(this.posX, this.posY, this.posZ, "nova_craft:null_explosion", 1.5F, 1.0F / (this.rand.nextFloat() * 0.2F + 0.9F));
            }
    }
	
	@Override
    protected void collideWithNearbyEntities() {
        List<?> list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(0.20000000298023224D, 8.0D, 0.20000000298023224D));

        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < list.size(); ++i) {
                Entity entity = (Entity) list.get(i);

                this.applyEntityCollision(entity);
            }
        }
    }
	
	
	public boolean attackEntityAsMob(final Entity target) {
		
		boolean flag = super.attackEntityAsMob(target);
        		      	
		this.heal(10.0F);
		this.addPotionEffect(new PotionEffect(Potion.regeneration.id, 150, 4));             

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

            	World world = MinecraftServer.getServer().worldServers[0];
                Hardmode data = Hardmode.get(world);
                if (data.getHardmode()) {
                	target.attackEntityFrom(DamageSource.causeMobDamage(this), 48.0F);
                	target.attackEntityFrom(DamageSource.magic, 12.0F);
                } 
                else {
                	target.attackEntityFrom(DamageSource.causeMobDamage(this), 32.0F);
                	target.attackEntityFrom(DamageSource.magic, 8.0F);
                }
            }
            
            else {
            	World world = MinecraftServer.getServer().worldServers[0];
                Hardmode data = Hardmode.get(world);
                if (data.getHardmode()) {
                	target.attackEntityFrom(DamageSource.causeMobDamage(this), 84.0F);
                	target.attackEntityFrom(DamageSource.magic, 14.0F);
                	target.attackEntityFrom(DamageSource.wither, 3.0F);
                	target.attackEntityFrom(DamageSource.outOfWorld, 2.0F);
                }
                else {
                	target.attackEntityFrom(DamageSource.causeMobDamage(this), 74.0F);
                	target.attackEntityFrom(DamageSource.magic, 12.0F);
                	target.attackEntityFrom(DamageSource.wither, 2.0F);
                	target.attackEntityFrom(DamageSource.outOfWorld, 1.0F);
                }
            	 ((EntityLivingBase) target).addPotionEffect(new PotionEffect(Potion.harm.id, 20, 1));
            }
             
        }
        
        return true;
    }
	
	@Override
	public void onUpdate() {
		if (!this.worldObj.isRemote && !this.hardmodeStatsApplied && Hardmode.get(this.worldObj).getHardmode()) {
			this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(200.0D);
			this.setHealth(this.getHealth() * 2.0F);
			this.hardmodeStatsApplied = true;
		}

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

				this.getLookHelper().setLookPositionWithEntity(this.getEntityToAttack(), 100.0F, 100.0F);

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

	@Override
	public void onDeath(DamageSource source) {
		super.onDeath(source);

		if (this.worldObj.isRemote) {
			return;
		}

		Configs.enableHardmodeAndSave();

		Hardmode data = Hardmode.get(this.worldObj);
		if (!data.areHardmodeMobsUnlocked()) {
			boolean hardmodeWasAlreadyEnabled = data.getHardmode();
			data.triggerEvent(this.worldObj);
			MinecraftServer.getServer().worldServerForDimension(0).mapStorage.saveAllData();
			ServerMessage.broadcastMessage(hardmodeWasAlreadyEnabled ? "True Hardmode Enabled" : "Hardmode Enabled");
		}

		if (source.getEntity() instanceof EntityPlayer) {
			((EntityPlayer)source.getEntity()).triggerAchievement(AchievementsNovaCraft.unforeseen_consequences);
		}
	}
	
	private boolean shouldAttackPlayer(EntityPlayer entityPlayer)
    {
            Vec3 vec3 = entityPlayer.getLook(1.0F).normalize();
            Vec3 vec31 = Vec3.createVectorHelper(this.posX - entityPlayer.posX, this.boundingBox.minY + (double)(this.height / 2.0F) - (entityPlayer.posY + (double)entityPlayer.getEyeHeight()), this.posZ - entityPlayer.posZ);
            double d0 = vec31.lengthVector();
            vec31 = vec31.normalize();
            double d1 = vec3.dotProduct(vec31);
            return d1 > 1.0D - 0.025D / d0 && entityPlayer.canEntityBeSeen(this);
        
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
	
	 protected void dropFewItems(boolean p_70628_1_, int chance)
	    {
		 	int j;
		 	int k;
	        
	        this.entityDropItem(new ItemStack(NovaCraftItems.prisoner_eye), 0.5F);
	        this.entityDropItem(new ItemStack(NovaCraftItems.unknown_star), 0.5F);	       
	        
	        j = this.rand.nextInt(3 + chance);

	        for (k = 0; k < j; ++k)
	        {
	        	this.dropItem(NovaCraftItems.outsider_essence, 12 + chance);
	        }
	    }
	
	public EnumCreatureAttribute getCreatureAttribute()
    {
        return EnumCreatureAttribute.UNDEFINED;
    }
	
	protected void dropRareDrop(int chance)
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
	
	protected String getLivingSound() {
        return "nova_craft:reality_distorter.living";
    }
    
    protected String getHurtSound() {
        return "nova_craft:reality_distorter.hurt";
    }
    
    protected String getDeathSound() {
        return "nova_craft:reality_distorter.death";
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

	@Override
	public EntityAgeable createChild(EntityAgeable p_90011_1_) {
		return null;
	}

	public void writeEntityToNBT(NBTTagCompound compound) {
		super.writeEntityToNBT(compound);
		compound.setBoolean("HardmodeStatsApplied", this.hardmodeStatsApplied);
	}

	public void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);
		this.hardmodeStatsApplied = compound.getBoolean("HardmodeStatsApplied");
	}
}
