package com.NovaCraft.entity;

import java.util.Iterator;
import java.util.List;

import com.NovaCraft.Hardmode;
import com.NovaCraft.NovaCraft;
import com.NovaCraft.ServerMessage;
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
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
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
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityPrisoner extends EntityAnimal implements IBossDisplayData
{		
	boolean angry = false;
	EntityPlayer player;
	public EntityPrisoner warden;
	public int shootTime;
	private boolean projectile;
	private int field_82222_j;
	private int[] field_82224_i = new int[2];
	public int deathTicks;
	
	public EntityPrisoner(final World p_i1745_1_) {
		super(p_i1745_1_);
		this.isImmuneToFire = true;
		setSize(1F, 8F);
		this.experienceValue = 500;
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();

		//World world = MinecraftServer.getServer().worldServers[0];
        //Hardmode data = Hardmode.get(world);
        //if (data.getHardmode() == true) {
        //	this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(2000.0D);
        //	this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(1.0D);
        //	this.setHealth(2000);
        //} 
        //else {
        	this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(1000.0D);
        	this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(1.0D);
        	this.setHealth(1000);
        //}
		
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

		List<Entity> volume = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(8, 8, 8));
		{
		if(Configs.enableWardenBlindness == true) {
        for(Entity entity : volume) {
        	if(entity instanceof EntityPlayer && this.canEntityBeSeen(entity)) ((EntityPlayer)entity).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 100, 0, true));
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
		int random1 = (int)(1 + Math.random() * 150);
       	 if(random1 <= 25 ) {
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
       	if(random1 > 25 && random1 <= 50) {
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
       	
       	if(random1 > 50 && random1 <= 100) {
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
       	
       	if(random1 > 100 && random1 <= 150) {
       		
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
                if (data.getHardmode() == true) {
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
                if (data.getHardmode() == true) {
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

	    if (!this.worldObj.isRemote && source.getEntity() instanceof EntityPlayer) {
	        World world = this.worldObj;
	        Hardmode data = Hardmode.get(world);

	        if (!data.getHardmode()) {
	            data.triggerEvent(world);
	            MinecraftServer.getServer().worldServers[0].mapStorage.saveAllData();
	            ServerMessage.broadcastMessage("Hardmode Enabled");
	        }

	        ((EntityPlayer) source.getEntity()).triggerAchievement(AchievementsNovaCraft.unforeseen_consequences);
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

	public void shootTarget() { //shootTarget
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
	
	 protected void dropFewItems(boolean p_70628_1_, int p_70628_2_)
	    {
		 	int j;
		 	int k;
	        
	        this.entityDropItem(new ItemStack(NovaCraftItems.prisoner_eye), 0.5F);
	        this.entityDropItem(new ItemStack(NovaCraftItems.unknown_star), 0.5F);	       
	        
	        j = this.rand.nextInt(3 + p_70628_2_);

	        for (k = 0; k < j; ++k)
	        {
	        	this.dropItem(NovaCraftItems.outsider_essence, 12 + p_70628_2_);
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

}
