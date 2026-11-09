package com.NovaCraft.entity;

import com.NovaCraft.Items.NovaCraftItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public class EntityFrontierGolem extends EntityMob implements IMob {
    private static final int AWAKE_WATCHER_ID = 20;
    private static final int LOCKED_YAW_WATCHER_ID = 21;
    private static final int LOCKED_PITCH_WATCHER_ID = 22;

    //In Ticks, 40 ticks are about 2 seconds
    private static final int TELEPORT_DELAY = 20;

    //Amount it can teleport and see the player
    private static final double TELEPORT_STEP = 4.0D;
    private static final double SEARCH_DISTANCE = 12.0D;
    private static final double LOST_DISTANCE = 16.0D;

    //Vertical teleportation distance
    private static final double VERTICAL_THRESHOLD = 4.0D;
    private static final double MAX_VERTICAL_STEP = 4.0D;

    private int teleportTicks;
    public int searchTicks;
    public int lostTicks;
    private int spazTicks;
    private float spazYawOffset;
    private float spazPitchOffset;

    //Spaz constants
    private static final float SPAZ_YAW_AMOUNT = 25.0F;
    private static final float SPAZ_PITCH_AMOUNT = 15.0F;
    private static final int SPAZ_PARTICLE_INTERVAL = 3;

    public EntityFrontierGolem(World world) {
        super(world);

        this.yOffset = 0.0F;
        this.setSize(0.85F, 0.85F);
        this.teleportTicks = TELEPORT_DELAY;

        this.getNavigator().setAvoidsWater(true);
        this.getNavigator().clearPathEntity();

        //Tells the direction it is locked at until it teleports again
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
    }

    @Override
    protected boolean isAIEnabled() {
        return false;
    }

    @Override
    public void moveEntity(double x, double y, double z) {
    }

    @Override
    public void addVelocity(double x, double y, double z) {
    }

    @Override
    public void knockBack(Entity attacker, float strength, double xRatio, double zRatio) {
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

    //Looks like normal movement without this; it is teleporting
    @Override
    public void setPositionAndRotation2(double x, double y, double z, float yaw, float pitch, int interpolationTicks) {
        this.setPosition(x, y, z);
        this.restoreLockedRotation();
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

    //Changes the direction the entity is facing
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
        compound.setBoolean("awake", this.isAwake());
        compound.setInteger("TeleportTicks", this.teleportTicks);
        compound.setInteger("SearchTicks", this.searchTicks);
        compound.setInteger("LostTicks", this.lostTicks);
        compound.setFloat("LockedYaw", this.getLockedYaw());
        compound.setFloat("LockedPitch", this.getLockedPitch());
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound compound) {
        super.readEntityFromNBT(compound);

        this.setAwake(compound.getBoolean("awake"));

        if (compound.hasKey("TeleportTicks")) {
            this.teleportTicks = compound.getInteger("TeleportTicks");
        } else {
            this.teleportTicks = TELEPORT_DELAY;
        }

        this.searchTicks = compound.getInteger("SearchTicks");
        this.lostTicks = compound.getInteger("LostTicks");

        float yaw = compound.hasKey("LockedYaw") ? compound.getFloat("LockedYaw") : this.rotationYaw;
        float pitch = compound.hasKey("LockedPitch") ? compound.getFloat("LockedPitch") : this.rotationPitch;

        this.setLockedRotation(yaw, pitch);
        this.stopAllMovement();
    }

    //StopAllMovement is often called twice to make sure after every action all movement is stopped
    @Override
    public void onUpdate() {
        this.stopAllMovement();
        this.restoreLockedRotation();

        super.onUpdate();

        this.stopAllMovement();

        //Spaz out when awake
        if (this.worldObj.isRemote && this.isAwake()) {
            this.applyAwakeSpazEffect();
        } else {
            this.restoreLockedRotation();
        }

        EntityLivingBase target = this.getAttackTarget();
        if (target != null && (target.isDead || !target.isEntityAlive())) {
            this.setFrontierGolemLost();
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

    //Makes the entity spaz out without really moving it
    private void applyAwakeSpazEffect() {
        if (--this.spazTicks <= 0) {
            this.spazTicks = 1 + this.rand.nextInt(2);
            this.spazYawOffset = (this.rand.nextFloat() * 2.0F - 1.0F) * SPAZ_YAW_AMOUNT;
            this.spazPitchOffset = (this.rand.nextFloat() * 2.0F - 1.0F) * SPAZ_PITCH_AMOUNT;

            //Makes a more noticeable spaz out every so often
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

        if (this.ticksExisted % SPAZ_PARTICLE_INTERVAL == 0) {
            if (!this.worldObj.isRemote) {
                return;
            }

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

        if (pitch > 80.0F) {
            return 80.0F;
        }

        return pitch;
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float damage) {
        if (source == DamageSource.drown || source == DamageSource.wither || source == DamageSource.inWall || source.isExplosion()) {
            return false;
        }

        boolean damaged = super.attackEntityFrom(source, damage);
        this.stopAllMovement();
        this.restoreLockedRotation();

        if (!this.worldObj.isRemote && damaged) {
            Entity attacker = source.getEntity();
            if (attacker instanceof EntityLivingBase && attacker != this) {
                this.lostTicks = 0;
                this.searchTicks = 0;
                this.teleportTicks = TELEPORT_DELAY;
                this.setAwake(true);
                this.setAttackTarget((EntityLivingBase) attacker);
            }
        }

        return damaged;
    }

    @Override
    public void applyEntityCollision(Entity entity) {
        if (!this.worldObj.isRemote && !this.isDead && this.getAttackTarget() != null && this.getAttackTarget() == entity) {
            this.performCollisionAttack(entity);
            return;
        }

        this.stopAllMovement();
        this.restoreLockedRotation();
    }

    private void performCollisionAttack(Entity entity) {
        if (this.worldObj.isRemote || this.isDead || entity == null) {
            return;
        }

        int explode_chance = (int)(1 + Math.random() * 100);
        if (explode_chance <= 5) {
            this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, 4.0F, false);
        }

        entity.attackEntityFrom(DamageSource.magic, 2.0F);

        if (entity instanceof EntityLivingBase) {
            EntityLivingBase living = (EntityLivingBase) entity;

            ((EntityLivingBase) entity).addPotionEffect(new PotionEffect(Potion.blindness.id, 60, 0));

            double differenceX = living.posX - this.posX;
            double differenceZ = living.posZ - this.posZ;

            while (differenceX * differenceX + differenceZ * differenceZ < 0.0001D) {
                differenceX = (Math.random() - Math.random()) * 0.01D;
                differenceZ = (Math.random() - Math.random()) * 0.01D;
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

        EntityPlayer nearbyPlayer = this.worldObj.getClosestPlayerToEntity(this, SEARCH_DISTANCE);
        this.updateTargetState(nearbyPlayer);

        if (nearbyPlayer != null && nearbyPlayer.capabilities.isCreativeMode) {
            this.setFrontierGolemLost();
            return;
        }

        if (!this.isAwake()) {
            return;
        }

        EntityLivingBase target = this.getAttackTarget();
        if (target == null) {
            return;
        }

        //Stops the entity from turning without teleporting first
        if (--this.teleportTicks <= 0) {
            this.teleportTicks = TELEPORT_DELAY;
            this.teleportTowardTarget(target);
        }

        this.stopAllMovement();
        this.restoreLockedRotation();
    }

    private void updateTargetState(EntityPlayer nearbyPlayer) {
        if (++this.searchTicks < 8) {
            return;
        }

        this.searchTicks = 0;

        if (!this.isAwake()) {
            if (this.isValidVisiblePlayer(nearbyPlayer)) {
                this.wakeUpAndTarget(nearbyPlayer);
            }
            return;
        }

        EntityLivingBase target = this.getAttackTarget();
        if (target == null) {
            if (this.isValidVisiblePlayer(nearbyPlayer)) {
                this.wakeUpAndTarget(nearbyPlayer);
            } else {
                this.incrementLostTicks();
            }
            return;
        }

        if (target.isDead || !target.isEntityAlive() || !this.canEntityBeSeen(target) || this.getDistanceToEntity(target) >= LOST_DISTANCE) {
            this.incrementLostTicks();
        } else {
            this.lostTicks = 0;
        }
    }

    private boolean isValidVisiblePlayer(EntityPlayer player) {
        return player != null && !player.isDead && player.isEntityAlive() && this.canEntityBeSeen(player);
    }

    private void wakeUpAndTarget(EntityLivingBase target) {
        this.lostTicks = 0;
        this.teleportTicks = TELEPORT_DELAY;
        this.setAwake(true);
        this.setAttackTarget(target);
        this.stopAllMovement();
        this.restoreLockedRotation();
    }

    private void incrementLostTicks() {
        ++this.lostTicks;
        if (this.lostTicks >= 16) {
            this.setFrontierGolemLost();
        }
    }

    //Calculates the new direction toward the target
    private void lockFacingTarget(EntityLivingBase target) {
        if (target == null) {
            return;
        }

        double differenceX = target.posX - this.posX;
        double differenceZ = target.posZ - this.posZ;

        double targetEyeY = target.posY + (double) target.getEyeHeight();
        double golemEyeY = this.posY + (double) this.getEyeHeight();
        double differenceY = targetEyeY - golemEyeY;

        double horizontalDistance = Math.sqrt(differenceX * differenceX + differenceZ * differenceZ);

        float yaw = (float) (Math.atan2(differenceZ, differenceX) * 180.0D / Math.PI) - 90.0F;
        float pitch = (float) (-Math.atan2(differenceY, horizontalDistance) * 180.0D / Math.PI);
        this.setLockedRotation(yaw, pitch);
    }

    private void teleportTowardTarget(EntityLivingBase target) {
        if (this.worldObj.isRemote || target == null || target.isDead || !target.isEntityAlive()) {
            return;
        }

        this.lockFacingTarget(target);

        double differenceX = target.posX - this.posX;
        double differenceZ = target.posZ - this.posZ;
        double horizontalDistance = Math.sqrt(differenceX * differenceX + differenceZ * differenceZ);
        double verticalDifference = target.boundingBox.minY - this.boundingBox.minY;

        double offsetY = 0.0D;
        if (verticalDifference > VERTICAL_THRESHOLD) {
            offsetY = Math.min(MAX_VERTICAL_STEP, verticalDifference);
        }
        else if (verticalDifference < -VERTICAL_THRESHOLD) {
            offsetY = Math.max(-MAX_VERTICAL_STEP, verticalDifference);
        }

        double offsetX = 0.0D;
        double offsetZ = 0.0D;
        if (horizontalDistance >= 0.001D) {
            double step = Math.min(TELEPORT_STEP, horizontalDistance);
            offsetX = differenceX / horizontalDistance * step;
            offsetZ = differenceZ / horizontalDistance * step;
        }
        else if (offsetY == 0.0D) {
            if (this.boundingBox.intersectsWith(target.boundingBox)) {
                this.performCollisionAttack(target);
            }

            return;
        }

        this.tryTeleportOffset(offsetX, offsetY, offsetZ, target);
    }

    //When teleporting make sure it is not in a block
    private boolean tryTeleportOffset(double offsetX, double offsetY, double offsetZ, EntityLivingBase target) {
        double oldX = this.posX;
        double oldY = this.posY;
        double oldZ = this.posZ;

        double destinationX = oldX + offsetX;
        double destinationY = oldY + offsetY;
        double destinationZ = oldZ + offsetZ;

        AxisAlignedBB destination = this.boundingBox.getOffsetBoundingBox(offsetX, offsetY, offsetZ);
        if (!this.worldObj.getCollidingBoundingBoxes(this, destination).isEmpty() || this.worldObj.isAnyLiquid(destination)) {

            this.spawnFailedTeleportParticles();
            return false;
        }

        this.stopAllMovement();

        this.spawnTeleportParticles(oldX, oldY, oldZ);
        this.worldObj.playSoundEffect(oldX, oldY, oldZ, "mob.endermen.portal", 1.0F, 0.65F + this.rand.nextFloat() * 0.15F);

        this.setPosition(destinationX, destinationY, destinationZ);
        this.stopAllMovement();
        this.restoreLockedRotation();

        this.spawnTeleportParticles(this.posX, this.posY, this.posZ);
        this.worldObj.playSoundEffect(this.posX, this.posY, this.posZ, "mob.endermen.portal", 1.0F, 0.9F + this.rand.nextFloat() * 0.15F);

        if (!this.isDead && target != null && this.boundingBox.intersectsWith(target.boundingBox)) {
            this.performCollisionAttack(target);
        }

        return true;
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

    private void setFrontierGolemLost() {
        this.lostTicks = 0;
        this.searchTicks = -64;
        this.teleportTicks = TELEPORT_DELAY;

        this.spazTicks = 0;
        this.spazYawOffset = 0.0F;
        this.spazPitchOffset = 0.0F;
        this.limbSwingAmount = 0.0F;

        this.setAttackTarget(null);
        this.setAwake(false);
        this.stopAllMovement();
        this.restoreLockedRotation();
    }

    protected void dropFewItems(boolean p_70628_1_, int chance) {
        int j;
        int k;
        j = this.rand.nextInt(2 + chance);

        for (k = 0; k < j; ++k) {
            this.dropItem(NovaCraftItems.small_xancium_dust, 1);
        }

        int shard_chance = (int)(1 + Math.random() * 9);
        if (shard_chance == 1) {
            this.dropItem(NovaCraftItems.crystallized_end_shard, 1);
        }

        int special = (int)(1 + Math.random() * 3);
        if (special == 1) {
            this.dropItem(NovaCraftItems.fractured_heart_of_the_end, 1);
        }
    }

    public void setAwake(boolean awake) {
        this.dataWatcher.updateObject(AWAKE_WATCHER_ID, Byte.valueOf((byte) (awake ? 1 : 0)));
    }

    public boolean isAwake() {
        return this.dataWatcher.getWatchableObjectByte(AWAKE_WATCHER_ID) == (byte) 1;
    }

    @Override
    protected String getLivingSound() {
        return "nova_craft:ambient.cave_new12";
    }

    @Override
    protected String getHurtSound() {
        return "nova_craft:crystal.break";
    }

    @Override
    protected String getDeathSound() {
        return "nova_craft:ambient.cave_new12";
    }

    @Override
    protected float getSoundVolume() {
        return 0.6F;
    }

    @Override
    protected boolean canDespawn() {
        return false;
    }
}