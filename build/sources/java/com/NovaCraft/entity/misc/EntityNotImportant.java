package com.NovaCraft.entity.misc;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityNotImportant extends EntityLiving {
    private static final int WATCH_YAW_ID = 20;
    private static final int WATCH_PITCH_ID = 21;

    public EntityNotImportant(World world) {
        super(world);
        this.yOffset = 0.0F;
        this.setSize(0.85F, 3.85F);
        this.getNavigator().clearPathEntity();
        this.stopAllMovement();
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(WATCH_YAW_ID, Float.valueOf(0.0F));
        this.dataWatcher.addObject(WATCH_PITCH_ID, Float.valueOf(0.0F));
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.0D);
        this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(1.0D);
    }

    @Override
    protected boolean isAIEnabled() {
        return false;
    }

    @Override
    protected void updateEntityActionState() {
        this.stopAllMovement();
    }

    @Override
    public void onUpdate() {
        this.stopAllMovement();

        super.onUpdate();

        this.stopAllMovement();

        if (!this.worldObj.isRemote && this.isEntityAlive()) {
            this.updateObservation();
        }

        if (!this.isDead) {
            this.applyWatchingRotation();
        }
    }

    private void updateObservation() {
        EntityPlayer closestVisiblePlayer = null;
        double closestDistanceSq = 96.0D * 96.0D;

        for (Object object : this.worldObj.playerEntities) {
            EntityPlayer player = (EntityPlayer) object;
            if (!player.isEntityAlive()) {
                continue;
            }

            double distanceSq = this.getDistanceSqToEntity(player);
            //if (!player.capabilities.isCreativeMode) {
            if (distanceSq <= 30.0D * 30.0D) {
                this.disappear();
                return;
            }

            if (distanceSq <= 96.0D * 96.0D && this.isPlayerLookingAtMe(player)) {
                this.disappear();
                return;
            }
            //}

            if (distanceSq <= closestDistanceSq && this.canEntityBeSeen(player)) {
                closestVisiblePlayer = player;
                closestDistanceSq = distanceSq;
            }
        }

        if (closestVisiblePlayer != null) {
            this.faceWatchingPlayer(closestVisiblePlayer);
        }
    }

    private boolean isPlayerLookingAtMe(EntityPlayer player) {
        Vec3 look = player.getLook(1.0F).normalize();
        Vec3 direction = Vec3.createVectorHelper(this.posX - player.posX, this.boundingBox.minY + this.height * 0.75D - (player.posY + player.getEyeHeight()), this.posZ - player.posZ);

        double distance = direction.lengthVector();
        if (distance < 0.0001D) {
            return true;
        }

        direction = direction.normalize();
        double alignment = look.dotProduct(direction);
        return alignment > 1.0D - 0.025D / distance && player.canEntityBeSeen(this);
    }

    private void faceWatchingPlayer(EntityPlayer player) {
        double differenceX = player.posX - this.posX;
        double differenceZ = player.posZ - this.posZ;
        double differenceY = player.posY + player.getEyeHeight() - (this.posY + this.getEyeHeight());

        double horizontalDistance = Math.sqrt(differenceX * differenceX + differenceZ * differenceZ);
        float yaw = (float) (Math.atan2(differenceZ, differenceX) * 180.0D / Math.PI);

        float pitch = (float) (-Math.atan2(differenceY, horizontalDistance) * 180.0D / Math.PI);
        pitch = Math.max(-80.0F, Math.min(80.0F, pitch));

        this.dataWatcher.updateObject(WATCH_YAW_ID, Float.valueOf(yaw));
        this.dataWatcher.updateObject(WATCH_PITCH_ID, Float.valueOf(pitch));
    }

    private void applyWatchingRotation() {
        float yaw = this.dataWatcher.getWatchableObjectFloat(WATCH_YAW_ID);
        float pitch = this.dataWatcher.getWatchableObjectFloat(WATCH_PITCH_ID);

        this.rotationYaw = yaw;
        this.rotationYawHead = yaw;
        this.renderYawOffset = yaw;
        this.rotationPitch = pitch;

        this.prevRotationYaw = yaw;
        this.prevRotationYawHead = yaw;
        this.prevRenderYawOffset = yaw;
        this.prevRotationPitch = pitch;
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

    private void disappear() {
        this.setDead();
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
    public boolean canBePushed() {
        return false;
    }

    @Override
    public void applyEntityCollision(Entity entity) {
    }

    @Override
    protected void collideWithNearbyEntities() {
    }

    @Override
    public boolean attackEntityAsMob(Entity target) {
        return false;
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {
        if (!this.worldObj.isRemote) {
            this.disappear();
        }

        return false;
    }

    @Override
    public boolean canBreatheUnderwater() {
        return true;
    }

    @Override
    public boolean getCanSpawnHere() {
        if (this.worldObj.provider.dimensionId != 0) return false;

        for (Object object : this.worldObj.playerEntities) {
            EntityPlayer player = (EntityPlayer) object;

            if (!player.isEntityAlive()) { //|| player.capabilities.isCreativeMode
                continue;
            }

            if (this.getDistanceSqToEntity(player) <= 30.0D * 30.0D) {
                return false;
            }
        }

        return super.getCanSpawnHere();
    }

    @Override
    protected boolean canDespawn() {
        return true;
    }

    @Override
    protected String getLivingSound() {
        return null;
    }

    @Override
    protected String getHurtSound() {
        return null;
    }

    @Override
    protected String getDeathSound() {
        return null;
    }

    @Override
    public String getCommandSenderName() {
        return "The Watcher";
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound compound) {
        super.writeEntityToNBT(compound);

        compound.setFloat("WatchYaw", this.dataWatcher.getWatchableObjectFloat(WATCH_YAW_ID));
        compound.setFloat("WatchPitch", this.dataWatcher.getWatchableObjectFloat(WATCH_PITCH_ID));
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound compound) {
        super.readEntityFromNBT(compound);
        this.setDead();
    }
}
