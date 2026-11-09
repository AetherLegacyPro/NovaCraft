package com.NovaCraft.entity;

import com.NovaCraft.Hardmode;
import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.entity.misc.EntityPhantomizedLaser;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public class EntityPhantomized extends EntityMob implements IMob, IBossDisplayData {

    private static final int AWAKE_WATCHER_ID = 20;
    private static final int LOCKED_YAW_WATCHER_ID = 21;
    private static final int LOCKED_PITCH_WATCHER_ID = 22;

    private static final int TELEPORT_DELAY = 20;
    private static final double DESIRED_DISTANCE = 14.0D;
    private static final int PROJECTILE_COUNT = 9;

    private int teleportTicks;
    public int searchTicks;
    public int lostTicks;

    private int attackCounter;
    private int attackCooldown;

    private int spazTicks;
    private float spazYawOffset;
    private float spazPitchOffset;

    private boolean hardmodeStatsApplied = false;

    public EntityPhantomized(World world) {
        super(world);

        this.yOffset = 0.0F;
        this.setSize(0.85F, 3.85F);
        this.teleportTicks = TELEPORT_DELAY;

        this.getNavigator().setAvoidsWater(true);
        this.getNavigator().clearPathEntity();

        float initialYaw = (float) this.rand.nextInt(4) * 90.0F;
        this.setLockedRotation(initialYaw, 0.0F);
        this.stopAllMovement();
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(AWAKE_WATCHER_ID, Byte.valueOf((byte) 0));
        this.dataWatcher.addObject(LOCKED_YAW_WATCHER_ID, Float.valueOf(0.0F));
        this.dataWatcher.addObject(LOCKED_PITCH_WATCHER_ID, Float.valueOf(0.0F));
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.0D);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(100.0D);
    }

    public int getTotalArmorValue()
    {
        return 10;
    }

    //The entity will not move unless it teleports, takes no knockback.
    //Have to do override like 5 different things
    @Override
    protected boolean isAIEnabled() {
        return false;
    }

    @Override
    public void moveEntity(double x, double y, double z) {
        if (this.isAwake()) {
            super.moveEntity(x, y, z);
        }
    }

    @Override
    public void addVelocity(double x, double y, double z) {
        if (this.isAwake()) {
            super.addVelocity(x, y, z);
        }
    }

    @Override
    public void knockBack(Entity attacker, float strength, double xRatio, double zRatio) {
        if (this.isAwake()) {
            super.knockBack(attacker, strength, xRatio, zRatio);
        }
    }

    @Override
    protected void jump() {
        this.isJumping = false;
        this.motionY = 0.0D;
    }

    @Override
    public void faceEntity(Entity entity, float maximumYawChange, float maximumPitchChange) {
        this.restoreLockedRotation();
    }

    @Override
    public void setPositionAndRotation2(double x, double y, double z, float yaw, float pitch, int interpolationTicks) {
        this.setPosition(x, y, z);
        this.restoreLockedRotation();
    }

    @Override
    public boolean interact(EntityPlayer player) {
        ItemStack heldItem = player.getCurrentEquippedItem();
        if (heldItem == null || heldItem.getItem() != NovaCraftItems.unpowered_heart_of_the_end) {
            return super.interact(player);
        }

        if (this.isAwake()) {
            return true;
        }

        if (!this.worldObj.isRemote) {
            if (!player.capabilities.isCreativeMode) {
                --heldItem.stackSize;

                if (heldItem.stackSize <= 0) {
                    player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
                }

                player.inventory.markDirty();
            }

            this.setAwake(true);
            this.setAttackTarget(player);

            this.teleportTicks = TELEPORT_DELAY;
            this.searchTicks = 0;
            this.lostTicks = 0;
            this.attackCounter = 0;
            this.attackCooldown = 0;

            this.lockFacingTarget(player);
            this.stopAllMovement();

            this.worldObj.playSoundEffect(this.posX, this.posY, this.posZ, "mob.endermen.portal", 2.0F, 0.8F + this.rand.nextFloat() * 0.15F);
            this.spawnTeleportParticles(this.posX, this.posY, this.posZ);
        }

        return true;
    }

    private void stopAllMovement() {
        this.getNavigator().clearPathEntity();
        this.isJumping = false;
        this.moveForward = 0.0F;
        this.moveStrafing = 0.0F;

        this.motionX = 0.0D;
        this.motionY = 0.0D;
        this.motionZ = 0.0D;

        this.fallDistance = 0.0F;
    }

    private void setLockedRotation(float yaw, float pitch) {
        this.dataWatcher.updateObject(LOCKED_YAW_WATCHER_ID, Float.valueOf(yaw));
        this.dataWatcher.updateObject(LOCKED_PITCH_WATCHER_ID, Float.valueOf(pitch));
        this.spazYawOffset = 0.0F;
        this.spazPitchOffset = 0.0F;
        this.spazTicks = 1;
        this.applyRotation(yaw, pitch);
    }

    private float getLockedYaw() {
        return this.dataWatcher.getWatchableObjectFloat(LOCKED_YAW_WATCHER_ID);
    }

    private float getLockedPitch() {
        return this.dataWatcher.getWatchableObjectFloat(LOCKED_PITCH_WATCHER_ID);
    }

    private void restoreLockedRotation() {
        this.spazYawOffset = 0.0F;
        this.spazPitchOffset = 0.0F;
        this.applyRotation(this.getLockedYaw(), this.getLockedPitch());
    }

    private void applyRotation(float yaw, float pitch) {
        this.rotationYaw = yaw;
        this.rotationYawHead = yaw;
        this.renderYawOffset = yaw;
        this.rotationPitch = pitch;

        this.prevRotationYaw = yaw;
        this.prevRotationYawHead = yaw;
        this.prevRenderYawOffset = yaw;
        this.prevRotationPitch = pitch;
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound compound) {
        super.writeEntityToNBT(compound);
        compound.setBoolean("Awake", this.isAwake());
        compound.setInteger("TeleportTicks", this.teleportTicks);
        compound.setInteger("SearchTicks", this.searchTicks);
        compound.setInteger("LostTicks", this.lostTicks);
        compound.setInteger("AttackCounter", this.attackCounter);
        compound.setInteger("AttackCooldown", this.attackCooldown);
        compound.setFloat("LockedYaw", this.getLockedYaw());
        compound.setFloat("LockedPitch", this.getLockedPitch());
        compound.setBoolean("HardmodeStatsApplied", this.hardmodeStatsApplied);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound compound) {
        super.readEntityFromNBT(compound);

        if (compound.hasKey("Awake")) {
            this.setAwake(compound.getBoolean("Awake"));
        } else {
            this.setAwake(compound.getBoolean("awake"));
        }

        if (compound.hasKey("TeleportTicks")) {
            this.teleportTicks = compound.getInteger("TeleportTicks");
        } else {
            this.teleportTicks = TELEPORT_DELAY;
        }

        this.searchTicks = compound.getInteger("SearchTicks");
        this.lostTicks = compound.getInteger("LostTicks");
        this.attackCounter = compound.getInteger("AttackCounter");
        this.attackCooldown = compound.getInteger("AttackCooldown");

        this.hardmodeStatsApplied = compound.getBoolean("HardmodeStatsApplied");

        float yaw = compound.hasKey("LockedYaw") ? compound.getFloat("LockedYaw") : this.rotationYaw;
        float pitch = compound.hasKey("LockedPitch") ? compound.getFloat("LockedPitch") : this.rotationPitch;

        this.setLockedRotation(yaw, pitch);
        this.stopAllMovement();
    }

    @Override
    public void onUpdate() {
        this.stopAllMovement();
        this.restoreLockedRotation();

        if (!this.worldObj.isRemote && !this.hardmodeStatsApplied && Hardmode.get(this.worldObj).getHardmode()) {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(200.0D);
            this.setHealth(this.getHealth() * 2.0F);
            this.hardmodeStatsApplied = true;
        }

        super.onUpdate();

        this.stopAllMovement();

        if (this.worldObj.isRemote && this.isAwake()) {
            this.applyAwakeSpazEffect();
        } else {
            this.restoreLockedRotation();
        }

        if (!this.worldObj.isRemote) {
            EntityLivingBase target = this.getAttackTarget();
            if (target != null && (target.isDead || !target.isEntityAlive())) {
                this.setAttackTarget(null);
                this.lostTicks = 0;
                this.attackCounter = 0;
            }
        }
    }

    @Override
    public void onLivingUpdate() {
        if (!this.worldObj.isRemote && this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL) {
            this.setDead();
            return;
        }

        this.stopAllMovement();
        this.restoreLockedRotation();

        super.onLivingUpdate();
        this.stopAllMovement();

        if (!this.worldObj.isRemote) {
            this.restoreLockedRotation();
        }
    }

    private void applyAwakeSpazEffect() {
        if (--this.spazTicks <= 0) {
            this.spazTicks = 1 + this.rand.nextInt(2);
            this.spazYawOffset = (this.rand.nextFloat() * 2.0F - 1.0F) * 25.0F;
            this.spazPitchOffset = (this.rand.nextFloat() * 2.0F - 1.0F) * 15.0F;
            if (this.rand.nextInt(5) == 0) {
                this.spazYawOffset *= 1.75F;
                this.spazPitchOffset *= 1.5F;
            }
        }

        float visualYaw = this.getLockedYaw() + this.spazYawOffset;
        float visualPitch = this.clampPitch(this.getLockedPitch() + this.spazPitchOffset);

        this.rotationYaw = visualYaw;
        this.rotationYawHead = visualYaw;
        this.renderYawOffset = visualYaw;
        this.rotationPitch = visualPitch;

        this.prevRotationYaw = this.getLockedYaw() - this.spazYawOffset;
        this.prevRotationYawHead = this.getLockedYaw() - this.spazYawOffset;
        this.prevRenderYawOffset = this.getLockedYaw() - this.spazYawOffset;
        this.prevRotationPitch = this.clampPitch(this.getLockedPitch() - this.spazPitchOffset);

        this.limbSwingAmount = 0.8F + this.rand.nextFloat() * 0.8F;
        this.limbSwing += 1.5F + this.rand.nextFloat() * 2.5F;

        //Particle interval when spazzing out
        if (this.ticksExisted % 3 == 0) {
            for (int i = 0; i < 4; ++i) {
                double particleX = this.posX + (this.rand.nextDouble() - 0.5D) * ((double) this.width + 0.4D);
                double particleY = this.posY + this.rand.nextDouble() * (double) this.height;
                double particleZ = this.posZ + (this.rand.nextDouble() - 0.5D) * ((double) this.width + 0.4D);
                this.worldObj.spawnParticle("portal", particleX, particleY, particleZ, (this.rand.nextDouble() - 0.5D) * 0.15D, (this.rand.nextDouble() - 0.5D) * 0.15D, (this.rand.nextDouble() - 0.5D) * 0.15D);
            }
        }
    }

    private float clampPitch(float pitch) {
        if (pitch < -80.0F) {
            return -80.0F;
        }

        return Math.min(pitch, 80.0F);

    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float damage) {
        if (!this.isAwake()) {
            return false;
        }

        if (source == DamageSource.drown || source == DamageSource.wither || source == DamageSource.inWall || source.isExplosion()) {
            return false;
        }

        boolean damaged = super.attackEntityFrom(source, damage);
        this.stopAllMovement();
        this.restoreLockedRotation();

        if (!this.worldObj.isRemote && damaged) {
            Entity attacker = source.getEntity();
            if (attacker instanceof EntityLivingBase && attacker != this) {
                EntityLivingBase livingAttacker = (EntityLivingBase) attacker;
                if (!(livingAttacker instanceof EntityPlayer) || !((EntityPlayer) livingAttacker).capabilities.isCreativeMode) {
                    this.setAttackTarget(livingAttacker);
                    this.lostTicks = 0;
                    this.searchTicks = 0;
                    this.teleportTicks = TELEPORT_DELAY;
                }
            }
        }

        return damaged;
    }

    @Override
    public void applyEntityCollision(Entity entity) {
        if (!this.isAwake()) {
            this.stopAllMovement();
            this.restoreLockedRotation();
            return;
        }

        if (!this.worldObj.isRemote && !this.isDead && this.getAttackTarget() == entity) {
            this.performCollisionAttack(entity);
        }

        this.stopAllMovement();
        this.restoreLockedRotation();
    }

    private void performCollisionAttack(Entity entity) {
        if (this.worldObj.isRemote || this.isDead || entity == null || !this.isAwake()) {
            return;
        }

        int explosionChance = 1 + this.rand.nextInt(100);
        if (explosionChance <= 5) {
            this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, 4.0F, false);
        }

        entity.attackEntityFrom(DamageSource.magic, 2.0F);
        if (entity instanceof EntityLivingBase) {
            EntityLivingBase living = (EntityLivingBase) entity;
            living.addPotionEffect(new PotionEffect(Potion.blindness.id, 60, 0));

            double differenceX = living.posX - this.posX;
            double differenceZ = living.posZ - this.posZ;
            while (differenceX * differenceX + differenceZ * differenceZ < 0.0001D) {
                differenceX = (this.rand.nextDouble() - this.rand.nextDouble()) * 0.01D;
                differenceZ = (this.rand.nextDouble() - this.rand.nextDouble()) * 0.01D;
            }

            living.knockBack(this, 5.0F, -differenceX, -differenceZ);
            living.motionX *= 4.0D;
            living.motionY *= 4.0D;
            living.motionZ *= 4.0D;
        }

        this.spawnCollisionParticles();
    }

    @Override
    protected void updateEntityActionState() {
        this.stopAllMovement();
        this.restoreLockedRotation();

        if (!this.isAwake()) {
            this.setAttackTarget(null);
            this.attackCounter = 0;
            this.attackCooldown = 0;
            return;
        }

        EntityPlayer nearbyPlayer = this.findClosestValidPlayer(40.0D);
        this.updateTargetState(nearbyPlayer);

        EntityLivingBase target = this.getAttackTarget();
        if (target == null) {
            this.stopAllMovement();
            return;
        }

        if (target instanceof EntityPlayer && ((EntityPlayer) target).capabilities.isCreativeMode) {
            this.setAttackTarget(null);
            this.attackCounter = 0;
            return;
        }

        this.lockFacingTarget(target);

        if (--this.teleportTicks <= 0) {
            this.teleportTicks = TELEPORT_DELAY;
            this.teleportToCombatRange(target);
        }

        this.updateProjectileAttack(target);
        this.stopAllMovement();
    }

    private EntityPlayer findClosestValidPlayer(double maximumDistance) {
        EntityPlayer closest = null;
        double closestDistanceSquared = maximumDistance * maximumDistance;

        for (Object object : this.worldObj.playerEntities) {

            EntityPlayer player = (EntityPlayer) object;
            if (player.isDead || !player.isEntityAlive() || player.capabilities.isCreativeMode || player.capabilities.disableDamage) {
                continue;
            }

            double distanceSquared = this.getDistanceSqToEntity(player);
            if (distanceSquared < closestDistanceSquared) {
                closestDistanceSquared = distanceSquared;
                closest = player;
            }
        }

        return closest;
    }

    private void updateTargetState(EntityPlayer nearbyPlayer) {
        if (!this.isAwake()) {
            this.setAttackTarget(null);
            this.lostTicks = 0;
            return;
        }

        if (++this.searchTicks < 8) {
            return;
        }

        this.searchTicks = 0;

        EntityLivingBase target = this.getAttackTarget();
        if (target == null || target.isDead || !target.isEntityAlive() || (target instanceof EntityPlayer && ((EntityPlayer) target).capabilities.isCreativeMode)) {
            if (this.isValidVisiblePlayer(nearbyPlayer)) {
                this.setAttackTarget(nearbyPlayer);
                this.lostTicks = 0;
            } else {
                this.setAttackTarget(null);
            }

            return;
        }

        if (!this.canEntityBeSeen(target) || this.getDistanceToEntity(target) >= 48.0D) {
            ++this.lostTicks;
            if (this.lostTicks >= 16) {
                this.setAttackTarget(null);
                this.lostTicks = 0;
                this.attackCounter = 0;
            }
        } else {
            this.lostTicks = 0;
        }
    }

    private boolean isValidVisiblePlayer(EntityPlayer player) {
        return player != null && !player.isDead && player.isEntityAlive() && !player.capabilities.isCreativeMode && !player.capabilities.disableDamage && this.canEntityBeSeen(player);
    }

    private void lockFacingTarget(EntityLivingBase target) {
        if (target == null) {
            return;
        }

        double differenceX = target.posX - this.posX;
        double differenceZ = target.posZ - this.posZ;

        double targetEyeY = target.posY + (double) target.getEyeHeight();
        double entityEyeY = this.posY + (double) this.getEyeHeight();
        double differenceY = targetEyeY - entityEyeY;

        double horizontalDistance = Math.sqrt(differenceX * differenceX + differenceZ * differenceZ);

        float yaw = (float) (Math.atan2(differenceZ, differenceX) * 180.0D / Math.PI) + 90.0F;
        float pitch = (float) (-Math.atan2(differenceY, horizontalDistance) * 180.0D / Math.PI);

        this.setLockedRotation(yaw, pitch);
    }

    private void teleportToCombatRange(EntityLivingBase target) {
        if (this.worldObj.isRemote || target == null || target.isDead || !target.isEntityAlive()) {
            return;
        }

        double fromTargetX = this.posX - target.posX;
        double fromTargetZ = this.posZ - target.posZ;

        double currentDistance = Math.sqrt(fromTargetX * fromTargetX + fromTargetZ * fromTargetZ);
        if (currentDistance < 0.001D) {
            double randomAngle = this.rand.nextDouble() * Math.PI * 2.0D;
            fromTargetX = Math.cos(randomAngle);
            fromTargetZ = Math.sin(randomAngle);
            currentDistance = 1.0D;
        }

        double radialX = fromTargetX / currentDistance;
        double radialZ = fromTargetZ / currentDistance;

        double sidewaysX = -radialZ;
        double sidewaysZ = radialX;

        for (int attempt = 0; attempt < 12; ++attempt) {
            double offsetX;
            double offsetZ;

            if (currentDistance < 11.0D) { //Closest the Boss can be for combat otherwise try to teleport to a safer distance
                double neededDistance = DESIRED_DISTANCE - currentDistance;
                double step = Math.min(8.0D, Math.max(2.0D, neededDistance)); //how many blocks can the Boss teleport? 8 Blocks at a time.
                double sidewaysAmount = (this.rand.nextDouble() * 2.0D - 1.0D) * 2.0D;

                offsetX = radialX * step + sidewaysX * sidewaysAmount;
                offsetZ = radialZ * step + sidewaysZ * sidewaysAmount;
            } else if (currentDistance > 19.0D) { //Furtherest the Boss can be for combat otherwise try to teleport to closer to the target
                double neededDistance = currentDistance - DESIRED_DISTANCE;
                double step = Math.min(8.0D, Math.max(2.0D, neededDistance)); //how many blocks can the Boss teleport?
                double sidewaysAmount = (this.rand.nextDouble() * 2.0D - 1.0D) * 2.0D;
                offsetX = -radialX * step + sidewaysX * sidewaysAmount;
                offsetZ = -radialZ * step + sidewaysZ * sidewaysAmount;
            } else {
                double direction = this.rand.nextBoolean() ? 1.0D : -1.0D;
                double step = 2.0D + this.rand.nextDouble() * (3.0D);

                double radialCorrection = DESIRED_DISTANCE - currentDistance;
                radialCorrection = Math.max(-1.5D, Math.min(1.5D, radialCorrection));

                offsetX = sidewaysX * step * direction + radialX * radialCorrection;
                offsetZ = sidewaysZ * step * direction + radialZ * radialCorrection;
            }

            double offsetY = (this.rand.nextDouble() * 1.5D - 1.0D) * 3.0D; //Vertical Range the boss can be above or below the player, 3 blocks
            if (this.tryTeleportOffset(offsetX, offsetY, offsetZ, target)) {
                this.lockFacingTarget(target);
                return;
            }
        }

        this.spawnFailedTeleportParticles();
    }

    private boolean tryTeleportOffset(double offsetX, double offsetY, double offsetZ, EntityLivingBase target) {
        double oldX = this.posX;
        double oldY = this.posY;
        double oldZ = this.posZ;

        double destinationX = oldX + offsetX;
        double destinationY = oldY + offsetY;
        double destinationZ = oldZ + offsetZ;

        AxisAlignedBB destination = this.boundingBox.getOffsetBoundingBox(offsetX, offsetY, offsetZ);
        if (!this.worldObj.getCollidingBoundingBoxes(this, destination).isEmpty() || this.worldObj.isAnyLiquid(destination)) {
            return false;
        }

        this.stopAllMovement();

        this.spawnTeleportParticles(oldX, oldY, oldZ);

        this.worldObj.playSoundEffect(oldX, oldY, oldZ, "mob.endermen.portal", 1.0F, 0.65F + this.rand.nextFloat() * 0.15F);
        this.setPosition(destinationX, destinationY, destinationZ);
        this.stopAllMovement();

        this.spawnTeleportParticles(this.posX, this.posY, this.posZ);

        this.worldObj.playSoundEffect(this.posX, this.posY, this.posZ, "mob.endermen.portal", 2.0F, 0.9F + this.rand.nextFloat() * 0.15F);

        if (!this.isDead && target != null && this.boundingBox.intersectsWith(target.boundingBox)) {
            this.performCollisionAttack(target);
        }

        return true;
    }

    private void updateProjectileAttack(EntityLivingBase target) {
        if (this.worldObj.isRemote || target == null || target.isDead || !target.isEntityAlive()) {
            return;
        }

        if (this.attackCooldown > 0) {
            --this.attackCooldown;
            return;
        }

        if (!this.canEntityBeSeen(target)) {
            if (this.attackCounter > 0) {
                --this.attackCounter;
            }
            return;
        }

        ++this.attackCounter;
        if (this.attackCounter == 5) {
            this.playSound("nova_craft:sculk_laser.charge", 3.0F, 0.9F + this.rand.nextFloat() * 0.2F);
        }

        if (this.attackCounter >= 40) { //Time between firing
            this.fireProjectileVolley(target);
            this.attackCounter = 0;
            this.attackCooldown = 60; //Countdown timer
        }
    }

    private void fireProjectileVolley(EntityLivingBase target) {
        if (this.worldObj.isRemote || target == null) {
            return;
        }

        this.lockFacingTarget(target);

        this.playSound("nova_craft:sculk_laser.laser_fire", 3.0F, 0.9F + this.rand.nextFloat() * 0.2F);

        double sourceX = this.posX;
        double sourceY = this.posY + (double) this.getEyeHeight() + 2.0F;
        double sourceZ = this.posZ;

        double targetX = target.posX;
        double targetY = target.boundingBox.minY + (double) target.height * 0.5D;
        double targetZ = target.posZ;

        double directionX = targetX - sourceX;
        double directionY = targetY - sourceY;
        double directionZ = targetZ - sourceZ;

        double horizontalLength = Math.sqrt(directionX * directionX + directionZ * directionZ);

        double sideX = 0.0D;
        double sideZ = 0.0D;

        if (horizontalLength > 0.001D) {
            sideX = -directionZ / horizontalLength;
            sideZ = directionX / horizontalLength;
        }

        for (int i = 0; i < PROJECTILE_COUNT; ++i) {
            double spread = (i - (PROJECTILE_COUNT - 1) / 2.0D) * 0.22D;

            EntityPhantomizedLaser projectile = new EntityPhantomizedLaser(this.worldObj, directionX, directionY, directionZ);
            projectile.setPosition(sourceX + sideX * spread, sourceY, sourceZ + sideZ * spread);
            projectile.setThrowableHeading(directionX, directionY, directionZ, 1.2F, 1.0F); //1.2F speed, 1.0F randomness
            this.worldObj.spawnEntityInWorld(projectile);
        }
    }

    private void spawnTeleportParticles(double x, double y, double z) {
        if (!(this.worldObj instanceof WorldServer)) {
            return;
        }

        WorldServer worldServer = (WorldServer) this.worldObj;
        worldServer.func_147487_a("portal", x, y + (double) this.height * 0.5D, z, 80, (double) this.width * 0.8D, (double) this.height * 0.7D, (double) this.width * 0.8D, 0.3D);
        worldServer.func_147487_a("largesmoke", x, y + (double) this.height * 0.5D, z, 12, (double) this.width * 0.4D, (double) this.height * 0.4D, (double) this.width * 0.4D, 0.05D);
    }

    private void spawnFailedTeleportParticles() {
        if (!(this.worldObj instanceof WorldServer)) {
            return;
        }

        WorldServer worldServer = (WorldServer) this.worldObj;
        worldServer.func_147487_a("portal", this.posX, this.posY + (double) this.height * 0.5D, this.posZ, 16, (double) this.width * 0.4D, (double) this.height * 0.4D, (double) this.width * 0.4D, 0.05D);
    }

    private void spawnCollisionParticles() {
        if (!(this.worldObj instanceof WorldServer)) {
            return;
        }

        WorldServer worldServer = (WorldServer) this.worldObj;
        worldServer.func_147487_a("explode", this.posX, this.posY + 0.5D, this.posZ, 40, 0.25D, 0.25D, 0.25D, 0.125D);
    }

    @Override
    protected void dropFewItems(boolean recentlyHit, int lootingLevel) {
        this.entityDropItem(new ItemStack(NovaCraftItems.heart_of_the_end), 0.5F);
    }

    public void setAwake(boolean awake) {
        this.dataWatcher.updateObject(AWAKE_WATCHER_ID, Byte.valueOf((byte) (awake ? 1 : 0)));
        if (!awake) {
            this.setAttackTarget(null);
            this.attackCounter = 0;
            this.attackCooldown = 0;
            this.stopAllMovement();
        }
    }

    public boolean isAwake() {
        return this.dataWatcher.getWatchableObjectByte(AWAKE_WATCHER_ID) == (byte) 1;
    }

    @Override
    protected String getLivingSound() {
        return "nova_craft:ambient.cave_new13";
    }

    @Override
    protected String getHurtSound() {
        return "nova_craft:crystal.break";
    }

    @Override
    protected String getDeathSound() {
        return "nova_craft:ambient.cave_new13";
    }

    @Override
    protected float getSoundVolume() {
        return 2.0F;
    }

    @Override
    protected boolean canDespawn() {
        return false;
    }

    @Override
    public String getCommandSenderName() {
        return "The Phantomized";
    }
}