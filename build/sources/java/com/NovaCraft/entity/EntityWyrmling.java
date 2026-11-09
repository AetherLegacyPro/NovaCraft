package com.NovaCraft.entity;

import java.util.List;
import com.NovaCraft.Items.NovaCraftItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityFlying;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.IAnimals;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityWyrmling extends EntityFlying implements IMob {
    public int courseChangeCooldown;
    public double waypointX;
    public double waypointY;
    public double waypointZ;

    private EntityLivingBase targetedEntity;
    private int targetObstructedTicks;

    private int angerLevel;
    private int randomSoundDelay;
    private boolean alwaysHostile;

    public float animTime;
    public float prevAnimTime;

    private static final int PASSIVE_ATTACK_COOLDOWN = 5000;
    private int passiveAttackCooldown;

    public EntityWyrmling(final World world) {
        super(world);
        this.targetObstructedTicks = 0;
        this.angerLevel = 0;
        this.randomSoundDelay = 0;
        this.passiveAttackCooldown = 0;
        this.tasks.addTask(0, (EntityAIBase) new EntityAIWatchClosest((EntityLiving) this, (Class) EntityPlayer.class, 8.0F));
        this.tasks.addTask(1, (EntityAIBase) new EntityAILookIdle((EntityLiving) this));
        this.setSize(1.5F, 1.0F);
        this.isImmuneToFire = false;
        this.experienceValue = 10;
    }

    protected boolean canTriggerWalking() {
        return false;
    }

    public boolean doesEntityNotTriggerPressurePlate() {
        return true;
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(16, Byte.valueOf((byte) 0));
    }

    @Override
    public void onUpdate() {
        super.onUpdate();

        if (!this.worldObj.isRemote) {
            this.updateAnger();

            if (this.passiveAttackCooldown > 0) {
                --this.passiveAttackCooldown;
            }

            if (this.motionY < 0.0D && this.posX != this.waypointX && this.posZ != this.waypointZ && this.targetedEntity == null) {
                this.motionY *= 1.0D;
                this.motionX *= 1.0D;
                this.motionZ *= 1.0D;
            }

            if (this.targetedEntity != null) {
                if (!this.isValidAttackTarget(this.targetedEntity)) {
                    this.clearTarget();
                } else {
                    if (this.targetedEntity instanceof EntityPlayer) {
                        EntityPlayer player = (EntityPlayer) this.targetedEntity;

                        if (!this.getEntitySenses().canSee(player)) {
                            ++this.targetObstructedTicks;
                        } else {
                            this.targetObstructedTicks = 0;
                        }

                        if (player.capabilities.isCreativeMode || player.capabilities.disableDamage || (!this.alwaysHostile && this.angerLevel <= 0) || this.targetObstructedTicks > 100) {
                            this.clearTarget();
                        }
                    } else {
                        this.targetObstructedTicks = 0;
                    }

                    if (this.targetedEntity != null) {
                        this.waypointX = this.targetedEntity.posX;
                        this.waypointY = this.targetedEntity.posY + 1.0D - this.rand.nextFloat() * 0.3F;
                        this.waypointZ = this.targetedEntity.posZ;
                    }
                }
            }
        }
    }

    private void updateAnger() {
        if (this.alwaysHostile) {
            this.angerLevel = 32767;
        } else if (this.angerLevel > 0) {
            --this.angerLevel;

            if (this.angerLevel == 0
                    && this.targetedEntity instanceof EntityPlayer) {
                this.clearTarget();
            }
        }

        if (this.randomSoundDelay > 0 && --this.randomSoundDelay == 0) {
            this.playSound("nova_craft:deepoid.living", this.getSoundVolume() * 2.0F, ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F) * 1.8F);
        }
    }

    @Override
    public boolean attackEntityFrom(final DamageSource source, final float amount) {
        if (this.isEntityInvulnerable()) {
            return false;
        }

        Entity attacker = source.getEntity();
        if (!this.worldObj.isRemote && attacker instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) attacker;

            if (!player.capabilities.isCreativeMode) {
                List nearbyEntities = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(32.0D, 32.0D, 32.0D));

                for (int i = 0; i < nearbyEntities.size(); ++i) {
                    Entity nearbyEntity = (Entity) nearbyEntities.get(i);
                    if (nearbyEntity instanceof EntityWyrmling) {
                        ((EntityWyrmling) nearbyEntity).becomeAngryAt(player);
                    }
                }

                this.becomeAngryAt(player);
            }
        }

        return super.attackEntityFrom(source, amount);
    }

    private void becomeAngryAt(final EntityPlayer player) {
        if (player == null || player.capabilities.isCreativeMode || player.capabilities.disableDamage) {
            return;
        }

        this.targetedEntity = player;
        this.angerLevel = 400 + this.rand.nextInt(400);
        this.randomSoundDelay = this.rand.nextInt(40);
        this.targetObstructedTicks = 0;

        this.waypointX = player.posX;
        this.waypointY = player.posY + 1.0D;
        this.waypointZ = player.posZ;
    }

    @Override
    public boolean attackEntityAsMob(final Entity target) {
        if (!(target instanceof EntityLivingBase)) {
            return false;
        }

        EntityLivingBase livingTarget = (EntityLivingBase) target;
        if (!this.isValidAttackTarget(livingTarget)) {
            return false;
        }

        boolean attacked = livingTarget.attackEntityFrom(DamageSource.causeMobDamage(this), 5.0F);

        if (attacked && !(livingTarget instanceof EntityPlayer) && this.isLabeledPassive(livingTarget)) {
            this.passiveAttackCooldown = PASSIVE_ATTACK_COOLDOWN;
            this.clearTarget();
        }

        return attacked;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(40.0D);
    }

    @Override
    protected void updateEntityActionState() {
        super.updateEntityActionState();

        if (!this.worldObj.isRemote && this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL) {
            this.setDead();
            return;
        }

        double distanceX = this.waypointX - this.posX;
        double distanceY = this.waypointY - this.posY;
        double distanceZ = this.waypointZ - this.posZ;
        double distanceScaled = distanceX * distanceX + distanceY * distanceY + distanceZ * distanceZ;
        if (distanceScaled < 1.0D || distanceScaled > 8100.0D) {
            this.waypointX = this.posX + (this.rand.nextFloat() * 2.0F - 1.0F) * 16.0F;
            this.waypointY = this.posY + (this.rand.nextFloat() * 2.0F - 1.0F) * 16.0F;
            this.waypointZ = this.posZ + (this.rand.nextFloat() * 2.0F - 1.0F) * 16.0F;
        }

        if (this.courseChangeCooldown-- <= 0) {
            this.courseChangeCooldown += this.rand.nextInt(5) + 10;

            distanceX = this.waypointX - this.posX;
            distanceY = this.waypointY - this.posY;
            distanceZ = this.waypointZ - this.posZ;
            distanceScaled = distanceX * distanceX + distanceY * distanceY + distanceZ * distanceZ;

            double distance = MathHelper.sqrt_double(distanceScaled);
            if (distance > 0.0D) {
                if (this.isCourseTraversable(this.waypointX, this.waypointY, this.waypointZ, distance)) {
                    this.motionX += distanceX / distance * 0.6D;
                    this.motionY += distanceY / distance * 0.6D;
                    this.motionZ += distanceZ / distance * 0.6D;
                } else if (this.targetedEntity != null) {
                    this.motionX += distanceX / distance * 0.6D;
                    this.motionY += distanceY / distance * 0.6D;
                    this.motionZ += distanceZ / distance * 0.6D;
                } else {
                    this.waypointX = this.posX;
                    this.waypointY = this.posY;
                    this.waypointZ = this.posZ;
                }
            }
        }

        if (this.targetedEntity != null && !this.isValidAttackTarget(this.targetedEntity)) {
            this.clearTarget();
        }

        this.getEntitySenses().clearSensingCache();

        if (this.alwaysHostile) {
            if (!(this.targetedEntity instanceof EntityPlayer) || !this.isValidAttackTarget(this.targetedEntity)) {

                EntityPlayer player = this.worldObj.getClosestVulnerablePlayerToEntity(this, 40.0D);
                if (player != null) {
                    this.targetedEntity = player;
                    this.targetObstructedTicks = 0;
                }
            }
        }

        if (this.targetedEntity == null && this.passiveAttackCooldown <= 0) {
            this.targetedEntity = this.getClosestVisiblePassiveEntity(40.0D);
        }

        if (this.targetedEntity != null) {
            distanceX = this.targetedEntity.posX - this.posX;
            distanceZ = this.targetedEntity.posZ - this.posZ;

            float yaw = -(float) Math.atan2(distanceX, distanceZ) * 180.0F / (float) Math.PI;

            this.rotationYaw = yaw;
            this.renderYawOffset = yaw;

            if (this.getDistanceToEntity(this.targetedEntity) <= 1.8F && this.targetedEntity.boundingBox.maxY >= this.boundingBox.minY && this.targetedEntity.boundingBox.minY <= this.boundingBox.maxY
                    && this.attackTime <= 0 && this.getEntitySenses().canSee(this.targetedEntity)) {

                if (this.attackEntityAsMob(this.targetedEntity)) {
                    this.attackTime = 20;
                    this.playSound("nova_craft:deepoid.hurt", 1.0F, 1.0F);
                }
            }
        } else {
            float yaw = -(float) Math.atan2(this.motionX, this.motionZ) * 180.0F / (float) Math.PI;
            this.rotationYaw = yaw;
            this.renderYawOffset = yaw;
        }
    }

    private EntityLivingBase getClosestVisiblePassiveEntity(final double range) {
        EntityLivingBase closest = null;
        double closestDistanceSq = range * range;

        AxisAlignedBB searchBox = this.boundingBox.expand(range, range, range);
        List entities = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, searchBox);

        for (int i = 0; i < entities.size(); ++i) {
            EntityLivingBase candidate = (EntityLivingBase) entities.get(i);

            if (candidate == this || !candidate.isEntityAlive() || !this.isLabeledPassive(candidate) || !this.getEntitySenses().canSee(candidate)) {
                continue;
            }

            double distanceSq = candidate.getDistanceSq(this.posX, this.posY, this.posZ);
            if (distanceSq < closestDistanceSq) {
                closestDistanceSq = distanceSq;
                closest = candidate;
            }
        }

        return closest;
    }

    private boolean isLabeledPassive(final Entity entity) {
        return entity instanceof IAnimals && !(entity instanceof IMob);
    }

    private boolean isValidAttackTarget(final EntityLivingBase target) {
        if (target == null || target == this || !target.isEntityAlive()) {
            return false;
        }

        if (target instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) target;
            return (this.alwaysHostile || this.angerLevel > 0) && !player.capabilities.isCreativeMode && !player.capabilities.disableDamage;
        }

        return this.passiveAttackCooldown <= 0 && this.isLabeledPassive(target);
    }

    private void clearTarget() {
        this.targetedEntity = null;
        this.targetObstructedTicks = 0;
    }

    private boolean isCourseTraversable(final double x, final double y, final double z, final double distance) {
        final double boxX = (x - this.posX) / distance;
        final double boxY = (y - this.posY) / distance;
        final double boxZ = (z - this.posZ) / distance;
        final AxisAlignedBB box = this.boundingBox.copy();

        for (int i = 1; i < distance; ++i) {
            box.offset(boxX, boxY, boxZ);

            if (!this.worldObj.getCollidingBoundingBoxes(this, box).isEmpty()) {
                return false;
            }
        }

        return true;
    }

    @Override
    public void onCollideWithPlayer(final EntityPlayer player) {
        super.onCollideWithPlayer(player);

        if (player == this.targetedEntity && this.angerLevel > 0 && !player.capabilities.isCreativeMode && !this.worldObj.isRemote && this.getEntitySenses().canSee(player)
                && this.getDistanceToEntity(player) <= 1.8F && player.boundingBox.maxY >= this.boundingBox.minY && player.boundingBox.minY <= this.boundingBox.maxY && this.attackTime <= 0) {

            if (this.attackEntityAsMob(player)) {
                this.attackTime = 20;
                this.playSound("nova_craft:deepoid.hurt", 1.0F, 1.0F);
            }
        }
    }

    @Override
    public void writeEntityToNBT(final NBTTagCompound tag) {
        super.writeEntityToNBT(tag);

        tag.setShort("Anger", (short) this.angerLevel);
        tag.setInteger("PassiveAttackCooldown", this.passiveAttackCooldown);
        tag.setBoolean("AlwaysHostile", this.alwaysHostile);
    }

    @Override
    public void readEntityFromNBT(final NBTTagCompound tag) {
        super.readEntityFromNBT(tag);

        this.angerLevel = tag.getShort("Anger");
        this.passiveAttackCooldown = tag.getInteger("PassiveAttackCooldown");
        this.alwaysHostile = tag.getBoolean("AlwaysHostile");
        if (this.alwaysHostile) {
            this.angerLevel = 32767;
        }
    }

    protected void fall(final float distance) {
    }

    protected void updateFallState(final double distanceFallen, final boolean onGround) {
    }

    public boolean isOnLadder() {
        return false;
    }

    @Override
    public void onEntityUpdate() {
        super.onEntityUpdate();

        if (this.worldObj.isRemote) {
            final float f = MathHelper.cos((48 + this.ticksExisted) * 0.13F + (float) Math.PI);
            final float f2 = MathHelper.cos((48 + this.ticksExisted + 1) * 0.13F + (float) Math.PI);

            if (f > 0.0F && f2 <= 0.0F) {
                this.worldObj.playSound(this.posX, this.posY, this.posZ, "mob.enderdragon.wings", 0.95F + this.rand.nextFloat() * 0.05F, 0.95F + this.rand.nextFloat() * 0.05F, false);
            }
        }
    }

    @Override
    public boolean getCanSpawnHere() {
        final int x = MathHelper.floor_double(this.posX);
        final int y = MathHelper.floor_double(this.boundingBox.minY);
        final int z = MathHelper.floor_double(this.posZ);
        final boolean canSpawn = this.worldObj.checkNoEntityCollision(this.boundingBox) && this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).isEmpty() && !this.worldObj.isAnyLiquid(this.boundingBox);
        return this.posY >= 95.0D && this.worldObj.canBlockSeeTheSky(x, y, z) && this.worldObj.getBlockLightValue(x, y, z) >= 7 && canSpawn;
    }

    @Override
    protected String getLivingSound() {
        return "nova_craft:deepoid.living";
    }

    @Override
    protected String getHurtSound() {
        return "nova_craft:deepoid.hurt";
    }

    @Override
    protected String getDeathSound() {
        return "nova_craft:deepoid.death";
    }

    @Override
    protected void dropFewItems(final boolean recentlyHit, final int lootingLevel) {
        if (recentlyHit) {
            int amount = 2 + this.rand.nextInt(3) + lootingLevel;
            for (int i = 0; i < amount; ++i) {
                this.entityDropItem(new ItemStack(NovaCraftItems.wyrmling_scales), 1.5F);
            }
        }
    }
}