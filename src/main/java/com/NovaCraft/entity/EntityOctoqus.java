package com.NovaCraft.entity;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.entity.misc.EntityOctoqusProjectile;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.potion.Potion;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityOctoqus extends EntityMob {
    private int field_70846_g;

    private static final double GRAB_DISTANCE = 1.0D;
    private static final int CONTACT_ATTACK_COOLDOWN = 20;

    private static final int WATER_SEARCH_RADIUS = 16;
    private static final int WATER_SEARCH_VERTICAL = 6;

    private static final int THROW_SEQUENCE_DURATION = 240;
    private static final int THROW_COOLDOWN = 100;

    private static final double THROW_HORIZONTAL_SPEED = 0.72D;
    private static final double THROW_UPWARD_SPEED = 0.28D;

    private static final double WATER_APPROACH_ACCELERATION = 0.035D;
    private static final double WATER_APPROACH_MAX_SPEED = 0.16D;

    private static final double UNDERWATER_PULL_STRENGTH = 0.045D;
    private static final double UNDERWATER_MAX_DOWNWARD_SPEED = -0.16D;

    private static final double JUMP_UPWARD_SPEED = 0.42D;
    private static final double JUMP_FORWARD_SPEED = 0.20D;
    private static final int JUMP_COOLDOWN = 20;

    private EntityPlayer thrownPlayer;
    private int throwSequenceTime;
    private int throwCooldown;
    private int contactAttackCooldown;
    private int jumpCooldown;

    private boolean lineOfSightStrafeRight;

    private int targetWaterX;
    private int targetWaterY;
    private int targetWaterZ;
    private boolean hasTargetWater;

    public EntityOctoqus(final World world) {
        super(world);
        this.experienceValue = 5;
        this.lineOfSightStrafeRight = this.rand.nextBoolean();
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(1.0D);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(12.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.23D);
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(16, Byte.valueOf((byte) 0));
    }

    @Override
    protected String getLivingSound() {
        return "nova_craft:glow_squid.living";
    }

    @Override
    protected String getHurtSound() {
        return "nova_craft:glow_squid.hurt";
    }

    @Override
    protected String getDeathSound() {
        return "nova_craft:glow_squid.death";
    }

    @Override
    public void onLivingUpdate() {
        if (!this.worldObj.isRemote) {
            if (this.throwCooldown > 0) {
                --this.throwCooldown;
            }

            if (this.contactAttackCooldown > 0) {
                --this.contactAttackCooldown;
            }

            if (this.jumpCooldown > 0) {
                --this.jumpCooldown;
            }

            this.updateContactDamage();
            this.updateThrownPlayerSequence();

            if (this.isWet() && this.rand.nextInt(30) == 0) {
                this.heal(1.0F);
            }

            this.Jump();
        }

        for (int i = 0; i < 2; ++i) {
            this.worldObj.spawnParticle("dripWater", this.posX + (this.rand.nextDouble() - 0.5D) * (double) this.width, this.posY - this.rand.nextDouble() * (double) this.height, this.posZ + (this.rand.nextDouble() - 0.5D) * (double) this.width, 0.0D, 0.0D, 0.0D);
        }

        super.onLivingUpdate();
    }

    private void Jump() {
        if (this.jumpCooldown > 0 || this.isInWater() || !this.onGround) {
            return;
        }

        Entity target = this.getEntityToAttack();

        if (target == null || target.isDead) {
            return;
        }

        double dx = target.posX - this.posX;
        double dz = target.posZ - this.posZ;
        double horizontalDistance = MathHelper.sqrt_double(dx * dx + dz * dz);

        if (horizontalDistance < 0.001D) {
            return;
        }

        boolean targetIsHigher = target.boundingBox.minY > this.boundingBox.maxY - 0.2D && horizontalDistance < 5.0D;
        boolean blocked = this.isCollidedHorizontally && horizontalDistance < 10.0D;
        boolean opportunisticJump = horizontalDistance < 4.0D && this.rand.nextInt(20) == 0;

        if (!blocked && !targetIsHigher && !opportunisticJump) {
            return;
        }

        this.motionY = JUMP_UPWARD_SPEED;
        this.motionX += dx / horizontalDistance * JUMP_FORWARD_SPEED;
        this.motionZ += dz / horizontalDistance * JUMP_FORWARD_SPEED;

        this.isAirBorne = true;
        this.velocityChanged = true;
        this.jumpCooldown = JUMP_COOLDOWN;
    }

    @Override
    public void moveEntityWithHeading(final float strafe, final float forward) {
        if (this.isInWater()) {
            super.moveEntityWithHeading(strafe, forward);
            return;
        }

        this.moveFlying(strafe, forward, 0.1F);
        this.moveEntity(this.motionX, this.motionY, this.motionZ);

        this.motionX *= 0.91D;
        this.motionZ *= 0.91D;
        this.motionY -= 0.08D;
        this.motionY *= 0.98D;
    }

    private void updateContactDamage() {
        if (this.contactAttackCooldown > 0) {
            return;
        }

        EntityPlayer player = this.getTouchingPlayer();
        if (player == null) {
            return;
        }

        if (player.attackEntityFrom(DamageSource.causeMobDamage(this), 1.0F)) {
            this.contactAttackCooldown = CONTACT_ATTACK_COOLDOWN;
        }
    }

    private EntityPlayer getTouchingPlayer() {
        for (int i = 0; i < this.worldObj.playerEntities.size(); ++i) {

            EntityPlayer player = (EntityPlayer) this.worldObj.playerEntities.get(i);
            if (player.isDead || player.capabilities.isCreativeMode || player.capabilities.disableDamage) {
                continue;
            }

            if (this.areHitboxesTouching(player)) {
                return player;
            }
        }

        return null;
    }

    @Override
    protected void attackEntity(final Entity entity, final float distance) {
        if (!(entity instanceof EntityPlayer)) {
            this.performRangedAttack(entity, distance);
            return;
        }

        EntityPlayer player = (EntityPlayer) entity;

        if (player.capabilities.isCreativeMode || player.capabilities.disableDamage) {
            this.clearThrowSequence();
            return;
        }

        if (this.hasWaterBreathing(player)) {
            if (this.thrownPlayer == player) {
                this.clearThrowSequence();
            }

            this.keepRangedDistance(player, distance);
            this.performRangedAttack(player, distance);
            return;
        }

        if (this.thrownPlayer == player) {
            this.faceTarget(player);
            this.hasAttacked = true;
            return;
        }

        if (this.thrownPlayer != null) {
            return;
        }

        if (this.throwCooldown <= 0 && this.canThrowPlayer(player)) {
            if (this.findWaterTarget(player)) {
                this.throwPlayerTowardWater(player);
                return;
            }

            this.performRangedAttack(player, distance);
            return;
        }

        if (this.throwCooldown <= 0 && distance < 8.0F) {
            this.moveTowardEntity(player, 0.10D, 0.24D, false);
            this.faceTarget(player);
            this.hasAttacked = true;
            return;
        }

        this.performRangedAttack(player, distance);
    }

    private void keepRangedDistance(final EntityPlayer player, final float distance) {
        if (!this.getEntitySenses().canSee(player)) {
            this.moveToGainLineOfSight(player);
        } else if (distance < 6.0F) {
            this.moveAwayFromEntity(player, 0.07D, 0.18D);
        }

        this.faceTarget(player);
        this.hasAttacked = true;
    }

    private boolean hasWaterBreathing(final EntityLivingBase entity) {
        return entity.isPotionActive(Potion.waterBreathing);
    }

    private boolean canThrowPlayer(final EntityPlayer player) {
        if (player == null || player.isDead || player.capabilities.isCreativeMode || player.capabilities.disableDamage || this.hasWaterBreathing(player)) {
            return false;
        }

        return this.getDistanceToEntity(player) <= GRAB_DISTANCE && this.areHitboxesTouching(player);
    }

    private void throwPlayerTowardWater(final EntityPlayer player) {
        if (this.hasWaterBreathing(player)) {
            return;
        }

        this.thrownPlayer = player;
        this.throwSequenceTime = THROW_SEQUENCE_DURATION;
        this.throwCooldown = THROW_COOLDOWN;

        this.field_70846_g = 0;
        this.func_70844_e(false);
        this.attackTime = 20;
        this.getNavigator().clearPathEntity();

        double targetX = this.targetWaterX + 0.5D;
        double targetZ = this.targetWaterZ + 0.5D;

        double dx = targetX - player.posX;
        double dz = targetZ - player.posZ;
        double horizontalDistance = MathHelper.sqrt_double(dx * dx + dz * dz);
        if (horizontalDistance < 0.001D) {
            double yawRadians = Math.toRadians(this.rotationYaw);
            dx = -MathHelper.sin((float) yawRadians);
            dz = MathHelper.cos((float) yawRadians);
            horizontalDistance = 1.0D;
        }

        double upwardSpeed = THROW_UPWARD_SPEED + Math.min(horizontalDistance * 0.012D, 0.16D);

        player.motionX = dx / horizontalDistance * THROW_HORIZONTAL_SPEED;
        player.motionY = upwardSpeed;
        player.motionZ = dz / horizontalDistance * THROW_HORIZONTAL_SPEED;

        player.velocityChanged = true;
        player.fallDistance = 0.0F;
    }

    private void updateThrownPlayerSequence() {
        if (this.thrownPlayer == null) {
            return;
        }

        EntityPlayer player = this.thrownPlayer;
        if (player.isDead || player.worldObj != this.worldObj || player.capabilities.isCreativeMode || player.capabilities.disableDamage || this.hasWaterBreathing(player) || --this.throwSequenceTime <= 0 || !this.hasTargetWater || !this.isWaterTargetStillValid()) {
            this.clearThrowSequence();
            return;
        }

        double targetX = this.targetWaterX + 0.5D;
        double targetY = this.targetWaterY + 0.20D;
        double targetZ = this.targetWaterZ + 0.5D;

        double moveX = targetX * 0.35D + player.posX * 0.65D;
        double moveY = targetY * 0.35D + player.posY * 0.65D;
        double moveZ = targetZ * 0.35D + player.posZ * 0.65D;

        this.moveTowardPosition(moveX, moveY, moveZ, WATER_APPROACH_ACCELERATION, WATER_APPROACH_MAX_SPEED, this.isInWater());

        if (player.isInWater()) {
            this.drownPlayer(player);
        }

        if (this.isEntitySubmerged(player) && this.areHitboxesTouching(player) && this.attackTime <= 0) {
            this.attackTime = 20;
            this.attackEntityAsMob(player);
        }

        this.faceTarget(player);
        this.hasAttacked = true;
    }

    private void drownPlayer(final EntityPlayer player) {
        if (this.hasWaterBreathing(player)) {
            this.clearThrowSequence();
            return;
        }

        double targetX = this.targetWaterX + 0.5D;
        double targetZ = this.targetWaterZ + 0.5D;

        double dx = targetX - player.posX;
        double dz = targetZ - player.posZ;
        double horizontalDistance = MathHelper.sqrt_double(dx * dx + dz * dz);

        if (horizontalDistance > 0.001D) {
            player.motionX += dx / horizontalDistance * 0.025D;
            player.motionZ += dz / horizontalDistance * 0.025D;
        }

        player.motionY -= UNDERWATER_PULL_STRENGTH;

        if (player.motionY < UNDERWATER_MAX_DOWNWARD_SPEED) {
            player.motionY = UNDERWATER_MAX_DOWNWARD_SPEED;
        }

        player.velocityChanged = true;
        player.fallDistance = 0.0F;
    }

    private void clearThrowSequence() {
        this.thrownPlayer = null;
        this.throwSequenceTime = 0;
        this.hasTargetWater = false;
    }

    private boolean findWaterTarget(final EntityPlayer player) {
        int centerX = MathHelper.floor_double(player.posX);
        int centerY = MathHelper.floor_double(player.posY);
        int centerZ = MathHelper.floor_double(player.posZ);

        double bestScore = Double.MAX_VALUE;
        boolean found = false;

        for (int x = centerX - WATER_SEARCH_RADIUS; x <= centerX + WATER_SEARCH_RADIUS; ++x) {
            for (int y = centerY - WATER_SEARCH_VERTICAL; y <= centerY + WATER_SEARCH_VERTICAL; ++y) {
                for (int z = centerZ - WATER_SEARCH_RADIUS; z <= centerZ + WATER_SEARCH_RADIUS; ++z) {
                    if (!this.isDeepWater(x, y, z)) {
                        continue;
                    }

                    double waterX = x + 0.5D;
                    double waterY = y + 0.5D;
                    double waterZ = z + 0.5D;

                    double playerDX = waterX - player.posX;
                    double playerDY = waterY - player.posY;
                    double playerDZ = waterZ - player.posZ;

                    double mobDX = waterX - this.posX;
                    double mobDY = waterY - this.posY;
                    double mobDZ = waterZ - this.posZ;

                    double score = playerDX * playerDX + playerDY * playerDY + playerDZ * playerDZ + (mobDX * mobDX + mobDY * mobDY + mobDZ * mobDZ) * 0.25D;
                    if (score < bestScore) {
                        bestScore = score;
                        this.targetWaterX = x;
                        this.targetWaterY = y;
                        this.targetWaterZ = z;
                        found = true;
                    }
                }
            }
        }

        this.hasTargetWater = found;
        return found;
    }

    private boolean isDeepWater(final int x, final int y, final int z) {
        return this.worldObj.getBlock(x, y, z).getMaterial() == Material.water && this.worldObj.getBlock(x, y + 1, z).getMaterial() == Material.water && this.worldObj.getBlock(x, y + 2, z).getMaterial() == Material.water;
    }

    private boolean isWaterTargetStillValid() {
        return this.isDeepWater(this.targetWaterX, this.targetWaterY, this.targetWaterZ);
    }

    private boolean areHitboxesTouching(final EntityPlayer player) {
        return this.boundingBox.expand(0.10D, 0.10D, 0.10D).intersectsWith(player.boundingBox);
    }

    private boolean isEntitySubmerged(final EntityLivingBase entity) {
        int eyeX = MathHelper.floor_double(entity.posX);
        int eyeY = MathHelper.floor_double(entity.posY + entity.getEyeHeight());
        int eyeZ = MathHelper.floor_double(entity.posZ);
        return this.worldObj.getBlock(eyeX, eyeY, eyeZ).getMaterial() == Material.water;
    }

    private void moveTowardEntity(final Entity entity, final double acceleration, final double maximumSpeed, final boolean allowVerticalMovement) {
        this.moveTowardPosition(entity.posX, entity.posY, entity.posZ, acceleration, maximumSpeed, allowVerticalMovement);
    }

    private void moveTowardPosition(final double x, final double y, final double z, final double acceleration, final double maximumSpeed, final boolean allowVerticalMovement) {
        double dx = x - this.posX;
        double dy = allowVerticalMovement ? y - this.posY : 0.0D;
        double dz = z - this.posZ;

        double distance = MathHelper.sqrt_double(dx * dx + dy * dy + dz * dz);
        if (distance < 0.001D) {
            this.motionX *= 0.8D;
            this.motionZ *= 0.8D;

            if (allowVerticalMovement) {
                this.motionY *= 0.8D;
            }

            return;
        }

        this.motionX += dx / distance * acceleration;
        this.motionZ += dz / distance * acceleration;

        if (allowVerticalMovement) {
            this.motionY += dy / distance * acceleration;
        }

        double speedSquared = this.motionX * this.motionX + this.motionZ * this.motionZ;
        if (allowVerticalMovement) {
            speedSquared += this.motionY * this.motionY;
        }

        double currentSpeed = MathHelper.sqrt_double(speedSquared);
        if (currentSpeed > maximumSpeed) {
            double scale = maximumSpeed / currentSpeed;
            this.motionX *= scale;
            this.motionZ *= scale;

            if (allowVerticalMovement) {
                this.motionY *= scale;
            }
        }

        this.velocityChanged = true;
    }

    private void moveAwayFromEntity(final Entity entity, final double acceleration, final double maximumSpeed) {
        double dx = this.posX - entity.posX;
        double dz = this.posZ - entity.posZ;

        double distance = MathHelper.sqrt_double(dx * dx + dz * dz);
        if (distance < 0.001D) {
            double yaw = Math.toRadians(this.rotationYaw);

            dx = MathHelper.sin((float) yaw);
            dz = -MathHelper.cos((float) yaw);
            distance = 1.0D;
        }

        this.motionX += dx / distance * acceleration;
        this.motionZ += dz / distance * acceleration;

        double horizontalSpeed = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
        if (horizontalSpeed > maximumSpeed) {
            double scale = maximumSpeed / horizontalSpeed;
            this.motionX *= scale;
            this.motionZ *= scale;
        }

        this.velocityChanged = true;
    }

    private void moveToGainLineOfSight(final EntityLivingBase target) {
        this.getNavigator().tryMoveToEntityLiving(target, 1.0D);

        double dx = target.posX - this.posX;
        double dz = target.posZ - this.posZ;
        double horizontalDistance = MathHelper.sqrt_double(dx * dx + dz * dz);

        if (horizontalDistance > 0.001D) {
            this.motionX += dx / horizontalDistance * 0.065D;
            this.motionZ += dz / horizontalDistance * 0.065D;

            double sideX = -dz / horizontalDistance;
            double sideZ = dx / horizontalDistance;

            double direction = this.lineOfSightStrafeRight ? 1.0D : -1.0D;

            this.motionX += sideX * 0.035D * direction;
            this.motionZ += sideZ * 0.035D * direction;

            if (this.isCollidedHorizontally && this.rand.nextInt(10) == 0) {
                this.lineOfSightStrafeRight = !this.lineOfSightStrafeRight;
            }
        }

        double horizontalSpeed = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
        if (horizontalSpeed > 0.20D) {
            double scale = 0.20D / horizontalSpeed;
            this.motionX *= scale;
            this.motionZ *= scale;
        }

        this.faceTarget(target);
        this.hasAttacked = true;
        this.velocityChanged = true;
    }

    private void faceTarget(final Entity entity) {
        double dx = entity.posX - this.posX;
        double dz = entity.posZ - this.posZ;
        float yaw = (float) (Math.atan2(dz, dx) * 180.0D / Math.PI) - 90.0F;
        this.rotationYaw = yaw;
        this.renderYawOffset = yaw;
        this.rotationYawHead = yaw;
    }

    private void resetRangedAttack() {
        this.field_70846_g = 0;
        this.func_70844_e(false);
    }

    private void performRangedAttack(final Entity entity, final float distance) {
        if (distance >= 30.0F || !(entity instanceof EntityLivingBase)) {
            return;
        }

        EntityLivingBase livingTarget = (EntityLivingBase) entity;

        this.faceTarget(entity);

        if (!this.getEntitySenses().canSee(livingTarget)) {
            this.resetRangedAttack();
            this.moveToGainLineOfSight(livingTarget);
            return;
        }

        if (this.attackTime == 0) {
            ++this.field_70846_g;
            if (this.field_70846_g == 1) {
                this.attackTime = 60;
                this.func_70844_e(true);
            } else if (this.field_70846_g <= 4) {
                this.attackTime = 6;
            } else {
                this.attackTime = 100;
                this.field_70846_g = 0;
                this.func_70844_e(false);
            }

            if (this.field_70846_g > 1) {
                this.faceTarget(entity);
                this.playSound("nova_craft:glow_squid.hurt", 1.0f, 1.0f);

                EntityOctoqusProjectile waterball = new EntityOctoqusProjectile(this.worldObj, this, 0.85F);
                waterball.posY = this.posY + (double) (this.height / 2.0F);
                this.worldObj.spawnEntityInWorld(waterball);
            }
        }

        this.hasAttacked = true;
    }

    @Override
    public boolean getCanSpawnHere() {
        final int x = MathHelper.floor_double(this.posX);
        final int y = MathHelper.floor_double(this.boundingBox.minY);
        final int z = MathHelper.floor_double(this.posZ);
        final boolean canSpawn = this.worldObj.checkNoEntityCollision(this.boundingBox) && this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).isEmpty() && !this.worldObj.isAnyLiquid(this.boundingBox);
        return this.posY >= 55.0D && this.posY <= 135.0D && this.worldObj.canBlockSeeTheSky(x, y, z) && this.worldObj.getBlockLightValue(x, y, z) <= 7 && canSpawn && (this.worldObj.getBlock(x, y - 1, z) == Blocks.sand || this.worldObj.getBlock(x, y - 1, z) == Blocks.gravel || this.worldObj.getBlock(x, y - 1, z) == Blocks.clay);
    }

    @Override
    protected void fall(final float distance) {
    }

    @Override
    protected void dropFewItems(final boolean recentlyHit, final int lootingLevel) {
        int amount = this.rand.nextInt(3) + this.rand.nextInt(1 + lootingLevel);
        for (int i = 0; i < amount; ++i) {
            if (this.isBurning()) {
                this.dropItem(NovaCraftItems.cooked_octoqus, 1);
            } else {
                this.dropItem(NovaCraftItems.raw_octoqus, 1);
            }
        }
    }

    public void func_70844_e(final boolean active) {
        byte value = this.dataWatcher.getWatchableObjectByte(16);

        if (active) {
            value = (byte) (value | 1);
        } else {
            value &= -2;
        }

        this.dataWatcher.updateObject(16, Byte.valueOf(value));
    }

    @Override
    protected boolean isValidLightLevel() {
        return true;
    }
}