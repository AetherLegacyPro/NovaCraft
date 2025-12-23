package com.NovaCraft.entity.illager;

import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.enchantment.*;
import net.minecraft.village.*;
import net.minecraft.potion.*;
import net.minecraft.util.*;
import net.minecraft.nbt.*;
import net.minecraft.block.*;
import net.minecraft.entity.monster.*;
import net.minecraft.item.*;
import net.minecraft.entity.item.*;
import net.minecraft.init.*;
import cpw.mods.fml.relauncher.*;
import java.util.*;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.achievements.AchievementsNovaCraft;
import com.NovaCraft.entity.EntitySculkAbomination;
import com.NovaCraft.entity.EntitySculkDuplicator;
import com.NovaCraft.entity.EntitySculkDweller;
import com.NovaCraft.entity.EntitySculkHunger;
import com.NovaCraft.entity.EntitySculkIncinerator;
import com.NovaCraft.entity.EntitySculkSymbiote;
import com.NovaCraft.entity.EntitySculkedMonitor;
import com.NovaCraft.entity.EntityWarden;
import com.NovaCraft.entity.EntityWardenVessel;
import com.NovaCraftBlocks.NovaCraftBlocks;

//Credit goes to Delirus, Netherlious Author
public class EntityIllagerChief extends EntityAgeable implements IMerchant, INpc, IRangedAttackMob
{
  private int randomTickDivider;
  private boolean isMating;
  private boolean isPlaying;
  Village villageObj;
  private EntityPlayer buyingPlayer;
  private MerchantRecipeList buyingList;
  private int timeUntilReset;
  private boolean needsInitilization;
  private String lastBuyingPlayer;
  private boolean isLookingForHome;
  private float field_82191_bN;
  private NewEntityAIArrowAttack aiArrowAttack;
  private EntityAIAttackOnCollide aiAttackOnCollide;
  public float moveForwardIllager;
  public int potionCount;
  private int targetObstructedTicks;
  public int switchCoolDown;
  //private MerchantRecipe merchantrecipe;
  
  private int angerLevel;
  private Entity lastAggroTarget;
  
  public EntityIllagerChief(final World p_i1747_1_) {
      this(p_i1747_1_, 0);
  }
  
  public EntityIllagerChief(final World p_i1748_1_, final int p_i1748_2_) {
      super(p_i1748_1_);
      this.aiArrowAttack = new NewEntityAIArrowAttack((IRangedAttackMob)this, 1.0, 20, 60, 15.0f);
      this.aiAttackOnCollide = new EntityAIAttackOnCollide((EntityCreature)this, 1.2, false);
      this.targetObstructedTicks = 0;
      this.switchCoolDown = 0;
      this.setSize(0.6f, 1.8f);
      this.potionCount = 1;
      this.moveForwardIllager = 0.0f;
      this.getNavigator().setBreakDoors(true);
      this.getNavigator().setAvoidsWater(true);
      this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
      this.tasks.addTask(1, (EntityAIBase)new EntityAIAvoidChance((EntityCreature)this, (Class)EntitySculkDweller.class, 6.0f, 1.0, 1.0, 0.1f, "nova_craft:vindicator.living"));
      this.tasks.addTask(1, (EntityAIBase)new EntityAIAvoidChance((EntityCreature)this, (Class)EntitySculkSymbiote.class, 6.0f, 1.0, 1.0, 0.1f, "nova_craft:vindicator.living"));
      this.tasks.addTask(1, (EntityAIBase)new EntityAIAvoidChance((EntityCreature)this, (Class)EntitySculkAbomination.class, 6.0f, 1.0, 1.0, 0.1f, "nova_craft:vindicator.living"));
      this.tasks.addTask(1, (EntityAIBase)new EntityAIAvoidChance((EntityCreature)this, (Class)EntitySculkHunger.class, 6.0f, 1.0, 1.0, 0.1f, "nova_craft:vindicator.living"));
      this.tasks.addTask(1, (EntityAIBase)new EntityAIAvoidChance((EntityCreature)this, (Class)EntitySculkDuplicator.class, 6.0f, 1.0, 1.0, 0.1f, "nova_craft:vindicator.living"));      
      this.tasks.addTask(1, (EntityAIBase)new EntityAIAvoidChance((EntityCreature)this, (Class)EntitySculkedMonitor.class, 6.0f, 1.0, 1.0, 0.1f, "nova_craft:vindicator.living"));
      this.tasks.addTask(1, (EntityAIBase)new EntityAIAvoidChance((EntityCreature)this, (Class)EntityWardenVessel.class, 6.0f, 1.0, 1.0, 0.1f, "nova_craft:vindicator.living"));
      this.tasks.addTask(1, (EntityAIBase)new EntityAIAvoidChance((EntityCreature)this, (Class)EntitySculkIncinerator.class, 6.0f, 1.0, 1.0, 0.1f, "nova_craft:vindicator.living"));
      this.tasks.addTask(1, (EntityAIBase)new EntityAIAvoidChance((EntityCreature)this, (Class)EntityWarden.class, 6.0f, 1.0, 1.0, 0.1f, "nova_craft:vindicator.living")); 
      this.tasks.addTask(1, (EntityAIBase)new EntityAIAvoidChance((EntityCreature)this, (Class)EntityWither.class, 6.0f, 1.0, 1.0, 0.1f, "nova_craft:vindicator.living"));
      this.tasks.addTask(1, (EntityAIBase)new EntityAITradeIllagerChief(this));
      this.tasks.addTask(1, (EntityAIBase)new EntityAILookAtTradePlayerIllagerChief(this));
      this.tasks.addTask(2, (EntityAIBase)new EntityAIMoveIndoors((EntityCreature)this));
      this.tasks.addTask(3, (EntityAIBase)new EntityAIRestrictOpenDoor((EntityCreature)this));
      this.tasks.addTask(4, (EntityAIBase)new EntityAIOpenAllDoor((EntityLiving)this, true));
      this.tasks.addTask(5, (EntityAIBase)new EntityAIMoveTowardsRestriction((EntityCreature)this, 0.6));
      this.tasks.addTask(8, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
      this.tasks.addTask(9, (EntityAIBase)new EntityAIWatchClosest2((EntityLiving)this, (Class)EntityPlayer.class, 3.0f, 1.0f));
      this.tasks.addTask(9, (EntityAIBase)new EntityAIWatchClosest2((EntityLiving)this, (Class)EntityIllagerTrader.class, 5.0f, 0.02f));
      this.tasks.addTask(9, (EntityAIBase)new EntityAIWatchClosest2((EntityLiving)this, (Class)EntityVillager.class, 5.0f, 0.02f));
      this.tasks.addTask(9, (EntityAIBase)new EntityAIWander((EntityCreature)this, 0.6));
      this.tasks.addTask(10, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityLiving.class, 8.0f));
      this.targetTasks.addTask(3, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, true));
      this.targetTasks.addTask(2, (EntityAIBase)new EntityAIAttackIllager((EntityCreature)this, (Class)EntityVillager.class, 200, true));
      this.targetTasks.addTask(2, (EntityAIBase)new EntityAIAttackIllager((EntityCreature)this, (Class)EntityPlayer.class, 0, true));
      this.experienceValue = 30;
      addRandomArmor();
  }
  
  public void onLivingUpdate() {
      super.onLivingUpdate();
      this.updateArmSwingProgress();
      if (!this.worldObj.isRemote && this.rand.nextInt(300) == 0 && this.deathTime == 0 && this.getAttackTarget() == null) {
          this.heal(4.0f);
      }
      
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
  
  @Override
	protected void addRandomArmor()
	{		
		int rand = (int)(1 + Math.random() * 4);
		switch (rand)
      {
      	case 1:
      		this.setCurrentItemOrArmor(0, new ItemStack(Items.diamond_axe));
      		break;
          case 2:
          	this.setCurrentItemOrArmor(0, new ItemStack(Items.diamond_sword));
              break;
          case 3:
          	this.setCurrentItemOrArmor(0, new ItemStack(NovaCraftItems.eerie_sword));
          	break;
          case 4:
          	this.setCurrentItemOrArmor(0, new ItemStack(NovaCraftItems.vanite_trident));
          	break;
      }
	}
  
  protected void applyEntityAttributes() {
      super.applyEntityAttributes();
      this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(120.0);
      this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.38);
      this.getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage);
      if (!this.isChild()) {
          this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(4.0);
      }
      if (this.isChild()) {
          this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(3.0);
      }
      this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0.15);
  }
  
  public void moveEntityWithHeading(final float par1, float par2) {
      if (this.moveForwardIllager != 0.0f) {
          par2 = this.moveForwardIllager;
      }
      super.moveEntityWithHeading(par1, par2);
  }
  
  public boolean attackEntityFrom(final DamageSource par1DamageSource, final int par2) {
      if (super.attackEntityFrom(par1DamageSource, (float)par2)) {
          final Entity var3 = par1DamageSource.getEntity();
          final int i = this.rand.nextInt(2);
          if (var3 != null) {
              this.dodgeAttack();
          }
          return super.attackEntityFrom(par1DamageSource, (float)par2);
      }
      return false;
  }
  
  public int getTotalArmorValue() {
      int i = super.getTotalArmorValue() + 7;
      if (i > 20) {
          i = 20;
      }
      return i;
  }
  
  public boolean attackEntityFrom(final DamageSource par1DamageSource, final float float1) {
      return (par1DamageSource.getEntity() == null || !(par1DamageSource.getEntity() instanceof EntityIllagerTrader)) && super.attackEntityFrom(par1DamageSource, float1);
  }
  
  public void dodgeAttack() {
      final EntityLivingBase attacker = this.getAttackTarget();
      if (attacker != null) {
          if (attacker.posX > this.posX) {
              ++this.motionZ;
          }
          else if (attacker.posX < this.posX) {
              --this.motionZ;
          }
          else if (attacker.posZ > this.posZ) {
              ++this.motionX;
          }
          else if (attacker.posZ < this.posZ) {
              --this.motionX;
          }
      }
  }
  
  public IEntityLivingData onSpawnWithEgg(IEntityLivingData p_110161_1_) {
      p_110161_1_ = super.onSpawnWithEgg(p_110161_1_);
      return p_110161_1_;
  }
  
  public boolean canAttackClass(final Class p_70686_1_) {
      return !EntityIllagerTrader.class.isAssignableFrom(p_70686_1_) && super.canAttackClass(p_70686_1_);
  }
  
  public void setCombatTask() {
      final ItemStack itemstack = this.getHeldItem();
      if (itemstack != null && itemstack.getItem() == NovaCraftItems.diamond_bow) {
          this.tasks.addTask(4, (EntityAIBase)this.aiArrowAttack);
          this.tasks.removeTask((EntityAIBase)this.aiAttackOnCollide);
      }
      else {
          this.tasks.addTask(4, (EntityAIBase)this.aiAttackOnCollide);
          this.tasks.removeTask((EntityAIBase)this.aiArrowAttack);
      }
  }
  
  public void attackEntityWithRangedAttack(final EntityLivingBase p_82196_1_, final float p_82196_2_) {
      final EntityArrow entityarrow = new EntityArrow(this.worldObj, (EntityLivingBase)this, p_82196_1_, 1.6f, (float)(14 - this.worldObj.difficultySetting.getDifficultyId() * 4));
      final int i = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, this.getHeldItem());
      final int j = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, this.getHeldItem());
      entityarrow.setDamage(p_82196_2_ * 3.0f + this.rand.nextGaussian() * 0.25 + this.worldObj.difficultySetting.getDifficultyId() * 0.11f);
      if (i > 0) {
          entityarrow.setDamage(entityarrow.getDamage() + i * 0.5 + 0.5);
      }
      if (j > 0) {
          entityarrow.setKnockbackStrength(j);
      }
      if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, this.getHeldItem()) > 0) {
          entityarrow.setFire(100);
      }
      this.playSound("random.bow", 1.0f, 1.0f / (this.getRNG().nextFloat() * 0.4f + 0.8f));
      this.worldObj.spawnEntityInWorld((Entity)entityarrow);
  }
  
  public void onUpdate() {
      super.onUpdate();
      final EntityPlayer entityplayer = this.worldObj.getClosestVulnerablePlayerToEntity((Entity)this, 16.0);
      final EntityLivingBase attacker = this.getAttackTarget();
      final ItemStack var1 = this.getHeldItem();
      if (attacker != null) {
          if (!this.getEntitySenses().canSee((Entity)attacker)) {
              ++this.targetObstructedTicks;
          }
          else if (attacker == this || !attacker.isEntityAlive()) {
              this.setAttackTarget((EntityLivingBase)null);
          }
          else {
              this.targetObstructedTicks = 0;
          }
          if (this.targetObstructedTicks > 300) {
              this.targetObstructedTicks = 0;
              this.setAttackTarget((EntityLivingBase)null);
          }
      }
      if (attacker == null && this.potionCount == 0) {
          this.potionCount = 1;
      }
      if (attacker != null && this.switchCoolDown == 0) {
          final float d = this.getDistanceToEntity((Entity)attacker);
          if (var1 != null && d <= 5.0f && !this.isChild() && var1.getItem() != Items.iron_sword) {
              this.switchCoolDown = 200;
              this.setCurrentItemOrArmor(0, new ItemStack(Items.iron_sword));
              this.tasks.addTask(4, (EntityAIBase)this.aiAttackOnCollide);
              this.tasks.removeTask((EntityAIBase)this.aiArrowAttack);
          }
          else if (var1 == null && d <= 5.0f && !this.isChild()) {
              this.setCurrentItemOrArmor(0, new ItemStack(Items.iron_sword));
              this.tasks.addTask(4, (EntityAIBase)this.aiAttackOnCollide);
              this.tasks.removeTask((EntityAIBase)this.aiArrowAttack);
          }
          else if (var1 != null && d > 5.0f && !this.isChild() && var1.getItem() != NovaCraftItems.diamond_bow) {
              this.switchCoolDown = 200;
              this.setCurrentItemOrArmor(0, new ItemStack((Item)NovaCraftItems.diamond_bow));
              this.tasks.addTask(4, (EntityAIBase)this.aiArrowAttack);
              this.tasks.removeTask((EntityAIBase)this.aiAttackOnCollide);
          }
          else if (var1 == null && d > 5.0f && !this.isChild()) {
              this.setCurrentItemOrArmor(0, new ItemStack((Item)NovaCraftItems.diamond_bow));
              this.tasks.addTask(4, (EntityAIBase)this.aiArrowAttack);
              this.tasks.removeTask((EntityAIBase)this.aiAttackOnCollide);
          }
          else if (d > 5.0f && d < 7.0f) {
              this.motionX = attacker.posX - this.posX;
              this.motionZ = attacker.posZ - this.posZ;
              final double e = -0.7 / (this.motionX * this.motionX + this.motionZ * this.motionZ + 0.0625);
              this.motionX *= e;
              this.motionZ *= e;
          }
      }
      if (this.switchCoolDown != 0) {
          --this.switchCoolDown;
      }
  }
  
  protected void attackEntity(final Entity p_70785_1_, final float p_70785_2_) {
      if (this.attackTime <= 0 && p_70785_2_ < 2.0f && p_70785_1_.boundingBox.maxY > this.boundingBox.minY && p_70785_1_.boundingBox.minY < this.boundingBox.maxY) {
          this.attackTime = 20;
          this.attackEntityAsMob(p_70785_1_);
          this.swingItem();
      }
  }
  
  public boolean attackEntityAsMob(final Entity target) {
      float attackDamage = (float)this.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
      int knockback = 0;
      if (target instanceof EntityLivingBase) {
          attackDamage += EnchantmentHelper.getEnchantmentModifierLiving((EntityLivingBase)this, (EntityLivingBase)target);
          knockback += EnchantmentHelper.getKnockbackModifier((EntityLivingBase)this, (EntityLivingBase)target);
      }
      final boolean flag = target.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), attackDamage);
      if (flag) {
          if (knockback > 0) {
              target.addVelocity((double)(-MathHelper.sin(this.rotationYaw * 3.1415927f / 180.0f) * knockback * 0.5f), 0.1, (double)(MathHelper.cos(this.rotationYaw * 3.1415927f / 180.0f) * knockback * 0.5f));
              this.motionX *= 0.6;
              this.motionZ *= 0.6;
          }
          final int fire = EnchantmentHelper.getFireAspectModifier((EntityLivingBase)this);
          if (fire > 0) {
              target.setFire(fire * 4);
          }
          if (target instanceof EntityLivingBase) {
              EnchantmentHelper.func_151384_a((EntityLivingBase)target, (Entity)this);
          }
          EnchantmentHelper.func_151385_b((EntityLivingBase)this, target);
      }
      this.worldObj.setEntityState((Entity)this, (byte)4);
      return flag;
  }
  
  public boolean isAIEnabled() {
      return true;
  }
  
  protected void updateAITick() {
      final int randomTickDivider = this.randomTickDivider - 1;
      this.randomTickDivider = randomTickDivider;
      if (randomTickDivider <= 0) {
          this.worldObj.villageCollectionObj.addVillagerPosition(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ));
          this.randomTickDivider = 70 + this.rand.nextInt(50);
          this.villageObj = this.worldObj.villageCollectionObj.findNearestVillage(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ), 32);
          if (this.villageObj == null) {
              this.detachHome();
          }
          else {
              final ChunkCoordinates chunkcoordinates = this.villageObj.getCenter();
              this.setHomeArea(chunkcoordinates.posX, chunkcoordinates.posY, chunkcoordinates.posZ, (int)(this.villageObj.getVillageRadius() * 0.6f));
              if (this.isLookingForHome) {
                  this.isLookingForHome = false;
                  this.villageObj.setDefaultPlayerReputation(5);
              }
          }
      }
      if (!this.isTrading() && this.timeUntilReset > 0) {
          --this.timeUntilReset;
          if (this.timeUntilReset <= 0) {
              if (this.needsInitilization) {
                  if (this.buyingList.size() > 1) {
                      //for (final MerchantRecipe merchantrecipe : this.buyingList) {
                      Iterator iterator = this.buyingList.iterator();

                      while(iterator.hasNext()) {
                          MerchantRecipe merchantrecipe = (MerchantRecipe)iterator.next();

                          if (merchantrecipe.isRecipeDisabled()) {
                              merchantrecipe.func_82783_a(this.rand.nextInt(6) + this.rand.nextInt(6) + 2);
                          }
                      }
                  }
                  this.addDefaultEquipmentAndRecipies(1);
                  this.needsInitilization = false;
                  if (this.villageObj != null && this.lastBuyingPlayer != null) {
                      this.worldObj.setEntityState((Entity)this, (byte)14);
                      this.villageObj.setReputationForPlayer(this.lastBuyingPlayer, 1);
                  }
              }
              this.addPotionEffect(new PotionEffect(Potion.regeneration.id, 200, 0));
          }
      }
      super.updateAITick();
  }
  
  public boolean interact(final EntityPlayer p_70085_1_) {
      final ItemStack itemstack = p_70085_1_.inventory.getCurrentItem();
      final boolean flag = itemstack != null && itemstack.getItem() == Items.spawn_egg;
      if (!flag && this.isEntityAlive() && !this.isTrading() && !this.isChild() && this.getAttackTarget() == null && !p_70085_1_.isSneaking()) {
          if (!this.worldObj.isRemote) {
              this.setCustomer(p_70085_1_);
              if (this.hasCustomNameTag()) {
                  p_70085_1_.displayGUIMerchant((IMerchant)this, this.getCustomNameTag());
                  p_70085_1_.triggerAchievement(AchievementsNovaCraft.what_are_ya_buyin);
              }
              else {
                  p_70085_1_.displayGUIMerchant((IMerchant)this, StatCollector.translateToLocal("entity.nova_craft.vindicator_chief.name"));
                  p_70085_1_.triggerAchievement(AchievementsNovaCraft.what_are_ya_buyin);
              }
          }
          return true;
      }
      return super.interact(p_70085_1_);
  }
  
  protected void entityInit() {
      super.entityInit();
      this.dataWatcher.addObject(16, (Object)0);
      this.dataWatcher.addObject(13, (Object)new Byte((byte)0));
  }
  
  public void writeEntityToNBT(final NBTTagCompound p_70014_1_) {
      super.writeEntityToNBT(p_70014_1_);
      p_70014_1_.setInteger("PotionCount", this.potionCount);
      if (this.buyingList != null) {
          p_70014_1_.setTag("Offers", (NBTBase)this.buyingList.getRecipiesAsTags());
      }
  }
  
  public void readEntityFromNBT(final NBTTagCompound p_70037_1_) {
      super.readEntityFromNBT(p_70037_1_);
      if (p_70037_1_.hasKey("PotionCount")) {
          this.potionCount = p_70037_1_.getInteger("PotionCount");
      }
      if (p_70037_1_.hasKey("Offers", 10)) {
          final NBTTagCompound nbttagcompound1 = p_70037_1_.getCompoundTag("Offers");
          this.buyingList = new MerchantRecipeList(nbttagcompound1);
      }
  }
  
  public void setCurrentItemOrArmor(final int p_70062_1_, final ItemStack p_70062_2_) {
      super.setCurrentItemOrArmor(p_70062_1_, p_70062_2_);
      if (!this.worldObj.isRemote && p_70062_1_ == 0) {
          this.setCombatTask();
      }
  }
  
  protected String getLivingSound() {
	  return "nova_craft:vindicator.living";
  }
  
  public int getTalkInterval() {
      return (this.getAttackTarget() != null) ? 30 : 120;
  }
  
  protected String getHurtSound() {
      return "nova_craft:vindicator.hurt";
  }
  
  protected String getDeathSound() {
      return "nova_craft:vindicator.death";
  }
  
  public boolean isMating() {
      return this.isMating;
  }
  
  public void setMating(final boolean p_70947_1_) {
      this.isMating = p_70947_1_;
  }
  
  public void setPlaying(final boolean p_70939_1_) {
      this.isPlaying = p_70939_1_;
  }
  
  public boolean isPlaying() {
      return this.isPlaying;
  }
  
  public void setRevengeTarget(final EntityLivingBase p_70604_1_) {
      super.setRevengeTarget(p_70604_1_);
      if (this.villageObj != null && p_70604_1_ != null) {
          this.villageObj.addOrRenewAgressor(p_70604_1_);
          if (p_70604_1_ instanceof EntityPlayer) {
              byte b0 = -1;
              if (this.isChild()) {
                  b0 = -3;
              }
              this.villageObj.setReputationForPlayer(p_70604_1_.getCommandSenderName(), (int)b0);
              if (this.isEntityAlive()) {
                  this.worldObj.setEntityState((Entity)this, (byte)13);
              }
          }
      }
  }
  
  public void onDeath(final DamageSource p_70645_1_) {
      if (this.villageObj != null) {
          final Entity entity = p_70645_1_.getEntity();
          if (entity != null) {
              if (entity instanceof EntityPlayer) {
                  this.villageObj.setReputationForPlayer(entity.getCommandSenderName(), -2);
              }
              else if (entity instanceof IMob) {
                  this.villageObj.endMatingSeason();
              }
          }
          else if (entity == null) {
              final EntityPlayer entityplayer = this.worldObj.getClosestPlayerToEntity((Entity)this, 16.0);
              if (entityplayer != null) {
                  this.villageObj.endMatingSeason();
              }
          }
      }
      super.onDeath(p_70645_1_);
  }
  
  public void setCustomer(final EntityPlayer p_70932_1_) {
      this.buyingPlayer = p_70932_1_;
  }
  
  public EntityPlayer getCustomer() {
      return this.buyingPlayer;
  }
  
  public boolean isTrading() {
      return this.buyingPlayer != null;
  }
  
  public void useRecipe(final MerchantRecipe recipe) {
      recipe.incrementToolUses();
      this.livingSoundTime = -this.getTalkInterval();
      this.playSound("nova_craft:vindicator.living", this.getSoundVolume(), this.getSoundPitch());
      if (recipe.hasSameIDsAs((MerchantRecipe)this.buyingList.get(this.buyingList.size() - 1))) {
          this.timeUntilReset = 40;
          this.needsInitilization = true;
          if (this.buyingPlayer != null) {
              this.lastBuyingPlayer = this.buyingPlayer.getCommandSenderName();
          }
          else {
              this.lastBuyingPlayer = null;
          }
      }
      if (recipe.getItemToBuy().getItem() instanceof ItemArmor) {
          this.setCurrentItemOrArmor(4 - ((ItemArmor)recipe.getItemToBuy().getItem()).armorType, new ItemStack(recipe.getItemToBuy().getItem()));
          this.buyingList.remove((Object)recipe);
          this.enchantEquipment();
          this.playSound("nova_craft:vindicator.living", this.getSoundVolume(), this.getSoundPitch());
      }
      this.playSound(this.getLivingSound(), this.getSoundVolume() * 1.5f, this.getSoundPitch());
      if (!recipe.isRecipeDisabled()) {
          recipe.incrementToolUses();
          boolean lastUse = false;
          int i = 3 + this.rand.nextInt(4);
          if (recipe.isRecipeDisabled()) {
              this.buyingList.remove((Object)recipe);
              lastUse = true;
          }
          if (lastUse || this.buyingList.size() == 0 || this.rand.nextInt(8 - i) == 0) {
              this.timeUntilReset = 40;
              i += 5;
          }
          if (this.rand.nextInt(6) == 0) {
              this.worldObj.spawnEntityInWorld((Entity)new EntityXPOrb(this.worldObj, this.posX, this.posY + 0.5, this.posZ, i));
          }
      }
      boolean lastUse = false;
      int o = 3 + this.rand.nextInt(4);
      if (recipe.isRecipeDisabled()) {
          this.buyingList.remove((Object)recipe);
          lastUse = true;
      }
      if (lastUse || this.buyingList.size() == 0 || this.rand.nextInt(8 - o) == 0) {
          this.timeUntilReset = 40;
          o += 5;
      }
  }
  
  public static Item getArmorItemForSlot(final int p_82161_0_, final int p_82161_1_) {
      switch (p_82161_0_) {
          case 4: {
              if (p_82161_1_ == 3) {
                  return (Item)NovaCraftItems.vanite_blue_crown;
              }
              if (p_82161_1_ == 3) {
                  return (Item)NovaCraftItems.vanite_red_crown;
              }
              if (p_82161_1_ == 3) {
                  return (Item)NovaCraftItems.vanite_orange_crown;
              }
              if (p_82161_1_ == 3) {
                  return (Item)NovaCraftItems.vanite_green_crown;
              }
              if (p_82161_1_ == 3) {
                  return (Item)NovaCraftItems.vanite_dark_blue_crown;
              }
              if (p_82161_1_ == 3) {
                  return (Item)NovaCraftItems.vanite_notched_crown;
              }
              if (p_82161_1_ == 3) {
                  return (Item)NovaCraftItems.vanite_mysterious_crown;
              }
              if (p_82161_1_ == 3) {
                  return (Item)NovaCraftItems.vanite_exotic_crown;
              }
              break;
          }
      }
      return null;
  }
  
  public void func_110297_a_(final ItemStack p_110297_1_) {
      if (!this.worldObj.isRemote && this.livingSoundTime > -this.getTalkInterval() + 20) {
          this.livingSoundTime = -this.getTalkInterval();
          if (p_110297_1_ != null) {
              this.playSound("nova_craft:vindicator.living", this.getSoundVolume(), this.getSoundPitch());
          }
          else {
              this.playSound("nova_craft:vindicator.living", this.getSoundVolume(), this.getSoundPitch());
          }
      }
  }
  
  public MerchantRecipeList getRecipes(final EntityPlayer p_70934_1_) {
      if (this.buyingList == null) {
          this.addDefaultEquipmentAndRecipies(1);
      }
      return this.buyingList;
  }
  
  private float adjustProbability(final float p_82188_1_) {
      final float f1 = p_82188_1_ + this.field_82191_bN;
      return (f1 > 0.9f) ? (0.9f - (f1 - 0.9f)) : f1;
  }
  
  private void addDefaultEquipmentAndRecipies(final int p_70950_1_) {
      if (this.buyingList != null) {
          this.field_82191_bN = MathHelper.sqrt_float((float)this.buyingList.size()) * 0.2f;
      }
      else {
          this.field_82191_bN = 0.0f;
      }
      final MerchantRecipeList merchantrecipelist = new MerchantRecipeList();                            
                 
          buyItem(merchantrecipelist, NovaCraftItems.vanite_chunk, 0, 3 + this.rand.nextInt(5), (Item)Items.iron_ingot, 0, 1 + this.rand.nextInt(6), this.rand, this.adjustProbability(0.4f));
          
          buyItem(merchantrecipelist, NovaCraftItems.vanite_ingot, 0, 4 + this.rand.nextInt(6), (Item)Items.emerald, 0, 1, this.rand, this.adjustProbability(0.3f));
           
          buyItem(merchantrecipelist, NovaCraftItems.vanite_ingot, 0, 2 + this.rand.nextInt(3), (Item)NovaCraftItems.luminant_apple, 0, 1 + this.rand.nextInt(3), this.rand, this.adjustProbability(0.3f));
           
          buyItem(merchantrecipelist, NovaCraftItems.vanite_ingot, 0, 6 + this.rand.nextInt(7), Items.experience_bottle, 0, 1 + this.rand.nextInt(6), this.rand, this.adjustProbability(0.3f));
            
          buyItem(merchantrecipelist, Items.diamond, 0, 1 + this.rand.nextInt(1), (Item)NovaCraftItems.pherithium_scraps, 0, 6 + this.rand.nextInt(12), this.rand, this.adjustProbability(0.15f));
      
          buyItem(merchantrecipelist, Items.gold_ingot, 0, 5 + this.rand.nextInt(6), (Item)NovaCraftItems.pherithium_scraps, 0, 1 + this.rand.nextInt(1), this.rand, this.adjustProbability(0.25f));
      
          buyItem(merchantrecipelist, NovaCraftItems.vanite_ingot, 0, 3 + this.rand.nextInt(2), Item.getItemFromBlock((Block)Blocks.cobblestone), 0, 22 + this.rand.nextInt(8), this.rand, this.adjustProbability(0.15f));
          
          buyItem(merchantrecipelist, NovaCraftItems.vanite_ingot, 0, 6 + this.rand.nextInt(6), Item.getItemFromBlock((Block)NovaCraftBlocks.cobbled_nullstone), 0, 15 + this.rand.nextInt(8), this.rand, this.adjustProbability(0.15f));
      
          buyItem(merchantrecipelist, NovaCraftItems.vanite_ingot, 0, 3 + this.rand.nextInt(6), Item.getItemFromBlock((Block)NovaCraftBlocks.cobbled_grimstone), 0, 20 + this.rand.nextInt(8), this.rand, this.adjustProbability(0.35f));

          buyItem(merchantrecipelist, NovaCraftItems.vanite_ingot, 0, 7 + this.rand.nextInt(6), Item.getItemFromBlock((Block)NovaCraftBlocks.cobbled_etherstone), 0, 20 + this.rand.nextInt(8), this.rand, this.adjustProbability(0.35f));
       
          buyItem(merchantrecipelist, Items.diamond, 0, 5 + this.rand.nextInt(2), Item.getItemFromBlock((Block)NovaCraftBlocks.luminant_sapling), 0, 1 + this.rand.nextInt(1), this.rand, this.adjustProbability(0.12f));

          buyItem(merchantrecipelist, Items.diamond, 0, 1 + this.rand.nextInt(1), (Item)NovaCraftItems.pherithium_scraps, 0, 6 + this.rand.nextInt(12), this.rand, this.adjustProbability(0.25f));
                   
          buyItem(merchantrecipelist, Item.getItemFromBlock((Block)NovaCraftBlocks.block_of_vanite), 0, 4 + this.rand.nextInt(3), (Item)Items.ender_pearl, 0, 2 + this.rand.nextInt(3), this.rand, this.adjustProbability(0.25f));
          
          buyItem(merchantrecipelist, NovaCraftItems.eerie_sword, 0, 1, (Item)NovaCraftItems.disc_fragment_5, 0, 1 + this.rand.nextInt(3), this.rand, this.adjustProbability(0.15f));

          buyItem(merchantrecipelist, Item.getItemFromBlock((Block)NovaCraftBlocks.inked_sculk_block), 0, 14 + this.rand.nextInt(15), (Item)NovaCraftItems.sculk_helmet, 0, 1, this.rand, this.adjustProbability(0.15f));
          
          buyItem(merchantrecipelist, Item.getItemFromBlock((Block)NovaCraftBlocks.inked_sculk_block), 0, 30 + this.rand.nextInt(10), (Item)NovaCraftItems.sculk_chestplate, 0, 1, this.rand, this.adjustProbability(0.15f));

          buyItem(merchantrecipelist, Item.getItemFromBlock((Block)NovaCraftBlocks.inked_sculk_block), 0, 28 + this.rand.nextInt(10), (Item)NovaCraftItems.sculk_leggings, 0, 1, this.rand, this.adjustProbability(0.15f));
          
          buyItem(merchantrecipelist, Item.getItemFromBlock((Block)NovaCraftBlocks.inked_sculk_block), 0, 14 + this.rand.nextInt(15), (Item)NovaCraftItems.sculk_boots, 0, 1, this.rand, this.adjustProbability(0.15f));
          
          buyItem(merchantrecipelist, Items.emerald, 0, 1 + this.rand.nextInt(4), (Item)NovaCraftItems.vindicator_insignia, 0, 1 + this.rand.nextInt(3), this.rand, this.adjustProbability(0.25f));

          buyItem(merchantrecipelist, NovaCraftItems.sculk_dweller_heart, 0, 1, (Item)NovaCraftItems.nullwart, 0, 1 + this.rand.nextInt(2), this.rand, this.adjustProbability(0.15f));

          buyItem(merchantrecipelist, Item.getItemFromBlock((Block)NovaCraftBlocks.block_of_vanite), 0, 9 + this.rand.nextInt(5), (Item)NovaCraftItems.tophinite_gemstone, 0, 1 + this.rand.nextInt(1), this.rand, this.adjustProbability(0.06f));
          
      if (merchantrecipelist.isEmpty()) {
          buyItem(merchantrecipelist, NovaCraftItems.vanite_ingot, 0, 1, NovaCraftItems.vanite_ingot, 0, 1, this.rand, 1.0f);
      }
      Collections.shuffle((List<?>)merchantrecipelist);
      if (this.buyingList == null) {
          this.buyingList = new MerchantRecipeList();
      }
      for (int l = 0; l < p_70950_1_ && l < merchantrecipelist.size(); ++l) {
          this.buyingList.addToListWithCheck((MerchantRecipe)merchantrecipelist.get(l));
      }
  }
  
  @SideOnly(Side.CLIENT)
  public void setRecipes(final MerchantRecipeList p_70930_1_) {
  }
  
  public static void buyItem(final MerchantRecipeList p_146089_0_, final Item priceItem, final int priceMeta, final int priceCount, final Item buyItem, final int buyMeta, final int buyCount, final Random p_146089_2_, final float p_146089_3_) {
      if (p_146089_2_.nextFloat() < p_146089_3_) {
          final ItemStack itemstack = new ItemStack(priceItem, priceCount, priceMeta);
          final ItemStack itemstack2 = new ItemStack(buyItem, buyCount, buyMeta);
          p_146089_0_.add((Object)new MerchantRecipe(itemstack, itemstack2));
      }
  }
  
  @SideOnly(Side.CLIENT)
  public void handleHealthUpdate(final byte p_70103_1_) {
      if (p_70103_1_ == 12) {
          this.generateRandomParticles("heart");
      }
      else if (p_70103_1_ == 13) {
          this.generateRandomParticles("angryVillager");
      }
      else if (p_70103_1_ == 14) {
          this.generateRandomParticles("happyVillager");
      }
      else {
          super.handleHealthUpdate(p_70103_1_);
      }
  }
  
  @SideOnly(Side.CLIENT)
  private void generateRandomParticles(final String p_70942_1_) {
      for (int i = 0; i < 5; ++i) {
          final double d0 = this.rand.nextGaussian() * 0.02;
          final double d2 = this.rand.nextGaussian() * 0.02;
          final double d3 = this.rand.nextGaussian() * 0.02;
          this.worldObj.spawnParticle(p_70942_1_, this.posX + this.rand.nextFloat() * this.width * 2.0f - this.width, this.posY + 1.0 + this.rand.nextFloat() * this.height, this.posZ + this.rand.nextFloat() * this.width * 2.0f - this.width, d0, d2, d3);
      }
  }
  
  public void setLookingForHome() {
      this.isLookingForHome = true;
  }
  
  public EntityIllagerTrader createChild(final EntityAgeable p_90011_1_) {
      final EntityIllagerTrader entityvillager = new EntityIllagerTrader(this.worldObj);
      entityvillager.onSpawnWithEgg(null);
      return entityvillager;
  }
  
  public boolean allowLeashing() {
      return false;
  }
  
  public boolean canDespawn() {
      return false;
  }
  
  protected void dropFewItems(boolean p_70628_1_, int p_70628_2_)
  {
      int j;
      int k;
      {
          j = this.rand.nextInt(3 + p_70628_2_);

          for (k = 0; k < j; ++k)
          {
              this.dropItem(Items.emerald, 7);
          }
      }

      int rand = (int)(1 + Math.random() * 5);
		switch (rand)
      {
      case 1:
          this.entityDropItem(new ItemStack(NovaCraftItems.vanite_trident), 0.0F);
          break;
      case 2:
          break;
      case 3:
          break;
      case 4:
          break;
      case 5:
    	  break;
      }
  }
}


