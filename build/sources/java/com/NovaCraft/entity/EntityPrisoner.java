package com.NovaCraft.entity;

import java.util.List;
import com.NovaCraft.Hardmode;
import com.NovaCraft.ServerMessage;
import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.achievements.AchievementsNovaCraft;
import com.NovaCraft.config.Configs;
import com.NovaCraft.entity.misc.EntityPrisonerTrackingLaser;
import com.NovaCraft.particles.ParticleHandler;
import com.NovaCraftBlocks.NovaCraftBlocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityPrisoner extends EntityAnimal implements IBossDisplayData {

	private static final double TRACKING_RANGE = 64.0D;

	private boolean angry;
	private boolean hardmodeStatsApplied;
	private int trackingShotCooldown = 40;

	private int field_82222_j;
	private final int[] field_82224_i = new int[2];

	public EntityPrisoner prisoner;

	public EntityPrisoner(World world) {
		super(world);
		this.isImmuneToFire = true;
		this.setSize(1.0F, 8.0F);
		this.experienceValue = 500;
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();

		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(1000.0D);
		this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(1.0D);
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

	@Override
	public boolean canBreatheUnderwater() {
		return true;
	}

	@Override
	public int getTotalArmorValue() {
		return 17;
	}

	private boolean isFightActivated() {
		int x = MathHelper.floor_double(this.posX);
		int y = MathHelper.floor_double(this.boundingBox.minY) - 1;
		int z = MathHelper.floor_double(this.posZ);
		return (this.worldObj.getBlock(x, y, z) == NovaCraftBlocks.unknown_portal_sealed);
	}

	public void summonMinions() {
		if (this.worldObj.isRemote) {
			return;
		}

		this.spawnMinion(new EntityNulk(this.worldObj), 3.0D);
		this.playSound("nova_craft:sculk.break", 0.5F, 1.0F);
	}

	@Override
	public void onLivingUpdate() {
		if (!this.worldObj.isRemote) {
			if (!this.isFightActivated()) {
				this.setHealth(1000.0F);
			} else if (!this.angry) {
				this.playSound("nova_craft:warden.roar", 0.5F, 1.0F);
				this.angry = true;
			}

			if (this.rand.nextInt(100) == 1 && this.getEntityToAttack() != null) {
				this.summonMinions();
			}

			List<EntityPlayer> players = this.worldObj.getEntitiesWithinAABB(EntityPlayer.class, this.boundingBox.expand(8.0D, 8.0D, 8.0D));

			for (EntityPlayer player : players) {
				if (!this.canEntityBeSeen(player)) {
					continue;
				}

				player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 100, 0, true));

				if (Configs.enableWardenSlowness) {
					player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 100, 1, true));
				}

				if (Configs.enableWardenWeakness) {
					player.addPotionEffect(new PotionEffect(Potion.weakness.id, 100, 0, true));
				}
			}
		}

		super.onLivingUpdate();
	}

	@Override
	public void onUpdate() {
		if (!this.worldObj.isRemote && !this.hardmodeStatsApplied && Hardmode.get(this.worldObj).getHardmode()) {
			this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(1000.0D);
			this.setHealth(Math.min(this.getMaxHealth(), this.getHealth() * 2.0F));
			this.hardmodeStatsApplied = true;
		}

		super.onUpdate();

		if (this.worldObj.isRemote || !this.isEntityAlive()) {
			return;
		}

		if (this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL) {
			this.setDead();
			return;
		}

		boolean activated = this.isFightActivated();
		EntityPlayer target = this.findTrackingTarget();

		if (!activated) {
			this.setAttackTarget(null);
			this.entityToAttack = null;
			return;
		}

		if (this.trackingShotCooldown > 0) {
			--this.trackingShotCooldown;
		}

		if (target == null) {
			this.setAttackTarget(null);
			this.entityToAttack = null;
			return;
		}

		this.setAttackTarget(target);
		this.entityToAttack = target;

		this.getLookHelper().setLookPositionWithEntity(target, 100.0F, 100.0F);

		if (this.trackingShotCooldown <= 0) {
			this.fireTrackingProjectile(target);
			this.trackingShotCooldown = 40 + this.rand.nextInt(61);
		}
	}

	private EntityPlayer findTrackingTarget() {
		EntityPlayer nearestPlayer = null;
		double nearestDistanceSq = TRACKING_RANGE * TRACKING_RANGE;

		for (Object object : this.worldObj.playerEntities) {
			EntityPlayer player = (EntityPlayer)object;

			if (!player.isEntityAlive() || player.capabilities.disableDamage) {
				continue;
			}

			double distanceSq = this.getDistanceSqToEntity(player);
			if (distanceSq <= nearestDistanceSq) {
				nearestPlayer = player;
				nearestDistanceSq = distanceSq;
			}
		}

		return nearestPlayer;
	}

	private void fireTrackingProjectile(EntityPlayer target) {
		EntityPrisonerTrackingLaser projectile = new EntityPrisonerTrackingLaser(this.worldObj, this, target);

		boolean spawned = this.worldObj.spawnEntityInWorld(projectile);
		if (spawned) {
			this.playSound("nova_craft:sculk_horn.vibration", 2.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));
		}
	}

	@Override
	public boolean attackEntityFrom(DamageSource source, float amount) {
		if (!this.worldObj.isRemote && source.getEntity() instanceof EntityPlayer) {

			int summonChance = 1 + this.rand.nextInt(150);

			if (summonChance <= 25) {
				this.playSound("nova_craft:sculk.break", 0.5F, 1.0F);
				this.spawnMinion(new EntityNulk(this.worldObj), 3.0D);
				this.spawnMinion(new EntityNulk(this.worldObj), 6.0D);
			} else if (summonChance <= 50) {
				this.playSound("nova_craft:sculk.break", 1.0F, 1.0F);
				this.spawnMinion(new EntityNuxx(this.worldObj), 3.0D);
				this.spawnMinion(new EntityNuxx(this.worldObj), 6.0D);
				this.spawnMinion(new EntityNuxx(this.worldObj), 7.0D);
			} else if (summonChance <= 100) {
				this.playSound("nova_craft:sculk.break", 1.0F, 1.0F);
				this.spawnMinion(new EntityOutsiderEye(this.worldObj), 30.0D);
				this.spawnMinion(new EntityOutsiderEye(this.worldObj), 10.0D);
				this.spawnMinion(new EntityOutsiderEye(this.worldObj), -30.0D);
			}
		}

		if (source == DamageSource.drown || source == DamageSource.wither || source == DamageSource.inWall
				|| source.isProjectile() || source.isExplosion() || source.getSourceOfDamage() instanceof EntityArrow) {
			return false;
		}

		if (this.field_82222_j <= 0) {
			this.field_82222_j = 20;
		}

		for (int i = 0; i < this.field_82224_i.length; ++i) {
			this.field_82224_i[i] += 3;
		}

		return super.attackEntityFrom(source, amount);
	}

	private void spawnMinion(EntityLiving minion, double offsetX) {
		minion.setLocationAndAngles(this.posX + offsetX, this.posY, this.posZ, this.rotationYaw, 0.0F);
		minion.setAttackTarget(this.getAttackTarget());
		this.worldObj.spawnEntityInWorld(minion);
	}

	@Override
	public void applyEntityCollision(Entity entity) {
		if (this.worldObj.isRemote) {
			return;
		}

		boolean damaged = entity.attackEntityFrom(DamageSource.generic, 30.0F);

		if (damaged && entity instanceof EntityLivingBase) {
			entity.addVelocity(entity.motionY, 3.0D, entity.motionZ);
			this.worldObj.playSoundEffect(this.posX, this.posY, this.posZ, "nova_craft:null_explosion", 1.5F, 1.0F / (this.rand.nextFloat() * 0.2F + 0.9F));
		}
	}

	@Override
	protected void collideWithNearbyEntities() {
		if (this.worldObj.isRemote) {
			return;
		}

		List<?> entities = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(0.2D, 8.0D, 0.2D));
		for (Object object : entities) {
			this.applyEntityCollision((Entity)object);
		}
	}

	@Override
	public boolean attackEntityAsMob(Entity target) {
		if (this.worldObj.isRemote) {
			return false;
		}

		super.attackEntityAsMob(target);

		this.heal(10.0F);
		this.addPotionEffect(new PotionEffect(Potion.regeneration.id, 150, 4));

		if (!(target instanceof EntityPlayer)) {
			return true;
		}

		EntityPlayer player = (EntityPlayer)target;

		boolean fullArmor = this.matchesArmor(player.getCurrentArmor(3), NovaCraftItems.warden_helmet, NovaCraftItems.crystalite_helmet)
						&& this.matchesArmor(player.getCurrentArmor(2), NovaCraftItems.warden_chestplate, NovaCraftItems.crystalite_chestplate)
						&& this.matchesArmor(player.getCurrentArmor(1), NovaCraftItems.warden_leggings, NovaCraftItems.crystalite_leggings)
						&& this.matchesArmor(player.getCurrentArmor(0), NovaCraftItems.warden_boots, NovaCraftItems.crystalite_boots);

		boolean hardmode = Hardmode.get(this.worldObj).getHardmode();

		if (fullArmor) {
			target.attackEntityFrom(DamageSource.causeMobDamage(this), hardmode ? 48.0F : 32.0F);
			target.attackEntityFrom(DamageSource.magic, hardmode ? 12.0F : 8.0F);
		} else {
			target.attackEntityFrom(DamageSource.causeMobDamage(this), hardmode ? 84.0F : 74.0F);
			target.attackEntityFrom(DamageSource.magic, hardmode ? 14.0F : 12.0F);
			target.attackEntityFrom(DamageSource.wither, hardmode ? 3.0F : 2.0F);
			target.attackEntityFrom(DamageSource.outOfWorld, hardmode ? 2.0F : 1.0F);
			player.addPotionEffect(new PotionEffect(Potion.harm.id, 20, 1));
		}

		return true;
	}

	private boolean matchesArmor(ItemStack stack, Item wardenItem, Item crystaliteItem) {
		return stack != null && (stack.getItem() == wardenItem || stack.getItem() == crystaliteItem);
	}

	@Override
	public void onDeath(DamageSource source) {
		super.onDeath(source);

		if (this.worldObj.isRemote) {
			return;
		}

		Hardmode data = Hardmode.get(this.worldObj);
		boolean hardmodeWasAlreadyEnabled = data.getHardmode();

		Configs.enableHardmodeAndSave();

		if (!data.areHardmodeMobsUnlocked()) {
			data.triggerEvent(this.worldObj);
			MinecraftServer.getServer().worldServerForDimension(0).mapStorage.saveAllData();
			ServerMessage.broadcastMessage(hardmodeWasAlreadyEnabled ? "True Hardmode Enabled" : "Hardmode Enabled");
		}

		if (source.getEntity() instanceof EntityPlayer) {
			((EntityPlayer)source.getEntity()).triggerAchievement(AchievementsNovaCraft.unforeseen_consequences);
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void onEntityUpdate() {
		super.onEntityUpdate();

		if (!this.worldObj.isRemote || !Configs.enableWardenParticles) {
			return;
		}

		if (net.minecraft.client.Minecraft.getMinecraft().gameSettings.particleSetting == 2) {
			return;
		}

		ParticleHandler.PORTAL_PARTICLE.spawn(this.worldObj, this.posX + (this.rand.nextDouble() - 0.5D) * this.width, this.posY + this.rand.nextDouble() * this.height - 0.25D, this.posZ + (this.rand.nextDouble() - 0.5D) * this.width);
		ParticleHandler.PORTAL_PARTICLE.spawn(this.worldObj, this.posX + (this.rand.nextDouble() - 0.5D) * this.width, this.posY + this.rand.nextDouble() * this.height + 0.25D, this.posZ + (this.rand.nextDouble() - 0.5D) * this.width);
	}

	@Override
	protected void dropFewItems(boolean recentlyHit, int chance) {
		this.entityDropItem(new ItemStack(NovaCraftItems.prisoner_eye), 0.5F);
		this.entityDropItem(new ItemStack(NovaCraftItems.unknown_star), 0.5F);

		int count = this.rand.nextInt(3 + chance);
		for (int i = 0; i < count; ++i) {
			this.dropItem(NovaCraftItems.outsider_essence, 12 + chance);
		}
	}

	@Override
	public EnumCreatureAttribute getCreatureAttribute() {
		return EnumCreatureAttribute.UNDEFINED;
	}

	protected String getHeartbeatSound() {
		return "nova_craft:warden.heartbeat";
	}

	protected String getVibrationSound() {
		return "nova_craft:sculk_horn.vibration";
	}

	@Override
	protected String getLivingSound() {
		return "nova_craft:reality_distorter.living";
	}

	@Override
	protected String getHurtSound() {
		return "nova_craft:reality_distorter.hurt";
	}

	@Override
	protected String getDeathSound() {
		return "nova_craft:reality_distorter.death";
	}

	@Override
	protected float getSoundVolume() {
		return 3.0F;
	}

	public World func_82194_d() {
		return this.worldObj;
	}

	@Override
	public boolean canDespawn() {
		return false;
	}

	@Override
	public EntityAgeable createChild(EntityAgeable other) {
		return null;
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound compound) {
		super.writeEntityToNBT(compound);
		compound.setBoolean("HardmodeStatsApplied", this.hardmodeStatsApplied);
		compound.setBoolean("Angry", this.angry);
		compound.setInteger("TrackingShotCooldown", this.trackingShotCooldown);
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);

		this.hardmodeStatsApplied = compound.getBoolean("HardmodeStatsApplied");
		this.angry = compound.getBoolean("Angry");

		if (compound.hasKey("TrackingShotCooldown", 99)) {
			this.trackingShotCooldown = Math.max(0, compound.getInteger("TrackingShotCooldown"));
		}
	}
}