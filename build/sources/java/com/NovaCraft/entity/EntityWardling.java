package com.NovaCraft.entity;

import java.util.List;
import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.entity.misc.EntityWardenProjectile;
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
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Vec3;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityWardling extends EntityMob {

	public EntityWarden warden;
	public int shootTime;
	private int field_82222_j;
	private int[] field_82224_i = new int[2];
	public int deathTicks;
	
	public EntityWardling(final World world) {
		super(world);
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
		setSize(0.5F, 1.5F);
		this.experienceValue = 50;
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();

		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(6D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(150.0D);
		this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(1.0D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(15D);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(15D);
		this.setHealth(150);		
		
	}
	
	public boolean canBreatheUnderwater()
    {
        return true;
    }
	
	 public int getTotalArmorValue()
	    {
	        return 14;
	    }

	public void onLivingUpdate() {
		if (!this.worldObj.isRemote) {
			List<EntityPlayer> players = this.worldObj.getEntitiesWithinAABB(EntityPlayer.class, this.boundingBox.expand(5, 5, 5));

			for (EntityPlayer player : players) {
				if (this.canEntityBeSeen(player)) player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 60, 1, true));
			}

			if (isWet()) {
				this.addPotionEffect(new PotionEffect(Potion.regeneration.id, 300, 4));
				this.heal(10.0F);
			}

			if (this.rand.nextInt(500) == 0) {
				this.heal(2.0F);
			}
		}

		super.onLivingUpdate();
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
        		      	
		this.heal(1.0F);          

        if (target instanceof EntityPlayer) {

            ItemStack helmet = ((EntityPlayer) target).getCurrentArmor(3);
            ItemStack chest = ((EntityPlayer) target).getCurrentArmor(2);
            ItemStack legs = ((EntityPlayer) target).getCurrentArmor(1);
            ItemStack boots = ((EntityPlayer) target).getCurrentArmor(0);
            //ItemStack hand = ((EntityPlayer) target).getCurrentEquippedItem();

            boolean hasWardenHelmet = false;
            boolean hasWardenChest = false;
            boolean hasWardenLegs = false;
            boolean hasWardenBoots = false;
           // boolean hasWardenHand = false;


            if(helmet != null)
                hasWardenHelmet = helmet.getItem() == NovaCraftItems.warden_helmet || helmet.getItem() == NovaCraftItems.crystalite_helmet;

            if(chest != null)
                hasWardenChest = chest.getItem() == NovaCraftItems.warden_chestplate || chest.getItem() == NovaCraftItems.crystalite_chestplate;

            if(legs != null)
                hasWardenLegs = legs.getItem() == NovaCraftItems.warden_leggings || legs.getItem() == NovaCraftItems.crystalite_leggings;

            if(boots != null)
                hasWardenBoots = boots.getItem() == NovaCraftItems.warden_boots || boots.getItem() == NovaCraftItems.crystalite_boots;

           // if(hand != null)
                //hasWardenHand = boots.getItem() == Items.Warden_sword;


            if (hasWardenHelmet && hasWardenChest && hasWardenLegs && hasWardenBoots) {

            	target.attackEntityFrom(DamageSource.causeMobDamage(this), 14.0F);
            	target.attackEntityFrom(DamageSource.magic, 3.0F);
            }
            
            else {
            	target.attackEntityFrom(DamageSource.causeMobDamage(this), 20.0F);
            	target.attackEntityFrom(DamageSource.magic, 5.0F);
            	target.attackEntityFrom(DamageSource.wither, 1.0F);
            	
            	 ((EntityLivingBase) target).addPotionEffect(new PotionEffect(Potion.harm.id, 20, 0));
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
	
	 protected void dropFewItems(boolean p_70628_1_, int chance)
	    {
	        int j;
	        int k;
	        j = this.rand.nextInt(3 + chance);
	        
	        for (k = 0; k < j; ++k)
	        {
	        	this.dropItem(NovaCraftItems.static_essence, 1);
	        }
	        
	        this.dropItem(NovaCraftItems.wardling_dust, 1 + chance);
	    }
	 
	 protected void dropRareDrop(int p_70600_1_)
	    {    
	       this.dropItem(NovaCraftItems.warden_tentacle, 1);
	    }
	
	public EnumCreatureAttribute getCreatureAttribute()
    {
        return EnumCreatureAttribute.UNDEFINED;
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
        return 0.5F;
    }
	
	public boolean canDespawn() {
        return false;
    }

}
