package com.NovaCraft.entity.misc;

import com.NovaCraft.entity.EntityNulk;
import com.NovaCraft.entity.EntityNuxx;
import com.NovaCraft.entity.EntityPrisoner;
import com.NovaCraftBlocks.NovaCraftBlocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityPrisonerTrackingLaser extends Entity implements IProjectile {
    private static final double TRACKING_SPEED = 0.65D;
    private static final double TURN_RATE = 0.15D;
    private static final int MAX_LIFETIME = 200;

    public Entity shootingEntity;
    public int arrowShake;

    private EntityLivingBase trackingTarget;
    private double damage = 25.0D;

    public EntityPrisonerTrackingLaser(World world) {
        super(world);
        this.renderDistanceWeight = 5.0D;
        this.setSize(0.5F, 0.5F);
        this.yOffset = 0.0F;
    }

    public EntityPrisonerTrackingLaser(World world, double x, double y, double z) {
        this(world);
        this.setPosition(x, y, z);
    }

    public EntityPrisonerTrackingLaser(World world, EntityLivingBase shooter, EntityLivingBase target) {
        this(world);
        this.shootingEntity = shooter;
        this.trackingTarget = target;

        double startX = shooter.posX;
        double startY = shooter.posY + shooter.height * 0.5D;
        double startZ = shooter.posZ;

        double differenceX = target.posX - startX;
        double differenceY = target.posY + target.height * 0.5D - startY;
        double differenceZ = target.posZ - startZ;

        double distance = Math.sqrt(differenceX * differenceX + differenceY * differenceY + differenceZ * differenceZ);
        if (distance > 0.0001D) {
            double offset = shooter.width * 0.5D + 0.75D;
            startX += differenceX / distance * offset;
            startY += differenceY / distance * offset;
            startZ += differenceZ / distance * offset;
        }

        this.setPosition(startX, startY, startZ);
        this.setThrowableHeading(differenceX, differenceY, differenceZ, (float)TRACKING_SPEED, 0.0F);
    }

    @Override
    protected void entityInit() {
    }

    @Override
    public boolean canBeCollidedWith()
    {
        return false;
    }

    @Override
    public boolean canBePushed()
    {
        return false;
    }

    @Override
    public boolean canAttackWithItem()
    {
        return false;
    }

    @Override
    protected boolean canTriggerWalking()
    {
        return false;
    }

    public double getDamage()
    {
        return this.damage;
    }

    public void setDamage(double damage)
    {
        this.damage = damage;
    }

    @Override
    public void onUpdate() {
        super.onUpdate();

        if (!this.worldObj.isRemote) {
            if (this.ticksExisted >= MAX_LIFETIME || !this.hasValidTarget()) {
                this.setDead();
                return;
            }

            this.updateHomingMotion();

            MovingObjectPosition hit = this.findCollision();
            if (hit != null) {
                this.onImpact(hit);
                return;
            }
        }

        this.setPosition(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);

        double horizontalSpeed = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);

        this.rotationYaw = (float)(Math.atan2(this.motionX, this.motionZ) * 180.0D / Math.PI);

        this.rotationPitch = (float)(Math.atan2(this.motionY, horizontalSpeed) * 180.0D / Math.PI);

        if (this.worldObj.isRemote) {
            this.worldObj.spawnParticle("portal", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
        }
    }

    private boolean hasValidTarget() {
        if (this.trackingTarget == null || !this.trackingTarget.isEntityAlive() || this.trackingTarget.worldObj != this.worldObj) {
            return false;
        }

        return !(this.trackingTarget instanceof EntityPlayer) || !((EntityPlayer)this.trackingTarget).capabilities.disableDamage;
    }

    private void updateHomingMotion() {
        double differenceX = this.trackingTarget.posX - this.posX;
        double differenceY = this.trackingTarget.posY + this.trackingTarget.height * 0.5D - this.posY;
        double differenceZ = this.trackingTarget.posZ - this.posZ;

        double distance = Math.sqrt(differenceX * differenceX + differenceY * differenceY + differenceZ * differenceZ);
        if (distance > 0.0001D) {
            double desiredX = differenceX / distance * TRACKING_SPEED;
            double desiredY = differenceY / distance * TRACKING_SPEED;
            double desiredZ = differenceZ / distance * TRACKING_SPEED;

            this.motionX += (desiredX - this.motionX) * TURN_RATE;
            this.motionY += (desiredY - this.motionY) * TURN_RATE;
            this.motionZ += (desiredZ - this.motionZ) * TURN_RATE;

            this.velocityChanged = true;
        }
    }

    private MovingObjectPosition findCollision() {
        Vec3 start = Vec3.createVectorHelper(this.posX, this.posY, this.posZ);
        Vec3 end = Vec3.createVectorHelper(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);

        MovingObjectPosition hit = this.findBlockingBlock(start, end);
        if (hit != null) {
            end = Vec3.createVectorHelper(hit.hitVec.xCoord, hit.hitVec.yCoord, hit.hitVec.zCoord);
        }

        List candidates = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.addCoord(this.motionX, this.motionY, this.motionZ).expand(1.0D, 1.0D, 1.0D));

        double nearestDistance = start.distanceTo(end);

        for (Object object : candidates) {
            Entity candidate = (Entity)object;
            if (candidate == this.shootingEntity || candidate instanceof EntityPrisoner || candidate instanceof EntityNulk
                    || candidate instanceof EntityNuxx || !candidate.canBeCollidedWith()) {
                continue;
            }

            if (candidate instanceof EntityPlayer && ((EntityPlayer)candidate).capabilities.disableDamage) {
                continue;
            }

            AxisAlignedBB collisionBox = candidate.boundingBox.expand(0.3D, 0.3D, 0.3D);

            MovingObjectPosition intercept = collisionBox.calculateIntercept(start, end);

            if (collisionBox.isVecInside(start)) {
                hit = new MovingObjectPosition(candidate);
                nearestDistance = 0.0D;
            }
            else if (intercept != null) {
                double hitDistance = start.distanceTo(intercept.hitVec);
                if (hitDistance <= nearestDistance) {
                    hit = new MovingObjectPosition(candidate);
                    nearestDistance = hitDistance;
                }
            }
        }

        return hit;
    }

    protected void onImpact(MovingObjectPosition hit) {
        if (this.worldObj.isRemote) {
            return;
        }

        if (hit.entityHit != null) {
            if (hit.entityHit.attackEntityFrom(DamageSource.magic, (float)this.damage)) {
                hit.entityHit.setFire(8);
            }
        } else {
            int x = hit.blockX;
            int y = hit.blockY;
            int z = hit.blockZ;

            switch (hit.sideHit) {
                case 0:
                    --y;
                    break;
                case 1:
                    ++y;
                    break;
                case 2:
                    --z;
                    break;
                case 3:
                    ++z;
                    break;
                case 4:
                    --x;
                    break;
                case 5:
                    ++x;
                    break;
                default:
                    break;
            }

            if (y >= 0 && y < 256 && this.worldObj.isAirBlock(x, y, z)) {
                this.worldObj.setBlock(x, y, z, NovaCraftBlocks.deepfire);
            }
        }

        this.playSound("random.fizz", 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));
        this.setDead();
    }

    @Override
    public void setThrowableHeading(double x, double y, double z, float speed, float inaccuracy) {
        double length = Math.sqrt(x * x + y * y + z * z);
        if (length < 0.0001D) {
            this.motionX = 0.0D;
            this.motionY = 0.0D;
            this.motionZ = 0.0D;
            return;
        }

        x /= length;
        y /= length;
        z /= length;

        x += this.rand.nextGaussian() * 0.0075D * inaccuracy;
        y += this.rand.nextGaussian() * 0.0075D * inaccuracy;
        z += this.rand.nextGaussian() * 0.0075D * inaccuracy;

        this.motionX = x * speed;
        this.motionY = y * speed;
        this.motionZ = z * speed;

        double horizontalSpeed = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
        this.rotationYaw = (float)(Math.atan2(this.motionX, this.motionZ) * 180.0D / Math.PI);
        this.rotationPitch = (float)(Math.atan2(this.motionY, horizontalSpeed) * 180.0D / Math.PI);

        this.prevRotationYaw = this.rotationYaw;
        this.prevRotationPitch = this.rotationPitch;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void setVelocity(double x, double y, double z) {
        this.motionX = x;
        this.motionY = y;
        this.motionZ = z;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void setPositionAndRotation2(double x, double y, double z, float yaw, float pitch, int interpolationTicks) {
        this.setPosition(x, y, z);
        this.setRotation(yaw, pitch);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public float getBrightness(float partialTicks)
    {
        return 1.0F;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getBrightnessForRender(float partialTicks)
    {
        return 15728880;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public float getShadowSize()
    {
        return 0.0F;
    }

    private boolean canPassThrough(Block block) {
        return (block == NovaCraftBlocks.unknown_portal_sealed || block == NovaCraftBlocks.unknown_portal);
    }

    private MovingObjectPosition findBlockingBlock(Vec3 start, Vec3 end) {
        double differenceX = end.xCoord - start.xCoord;
        double differenceY = end.yCoord - start.yCoord;
        double differenceZ = end.zCoord - start.zCoord;

        double length = Math.sqrt(differenceX * differenceX + differenceY * differenceY + differenceZ * differenceZ);

        if (length < 0.000001D) {
            return null;
        }

        double directionX = differenceX / length;
        double directionY = differenceY / length;
        double directionZ = differenceZ / length;

        Vec3 currentStart = start;
        for (int attempts = 0; attempts < 64; ++attempts) {
            MovingObjectPosition hit = this.worldObj.func_147447_a(currentStart, end, false, true, false);

            if (hit == null) {
                return null;
            }

            Block block = this.worldObj.getBlock(hit.blockX, hit.blockY, hit.blockZ);

            if (!this.canPassThrough(block)) {
                return hit;
            }

            double exitX = Double.POSITIVE_INFINITY;
            double exitY = Double.POSITIVE_INFINITY;
            double exitZ = Double.POSITIVE_INFINITY;

            if (directionX > 0.000001D) {
                exitX = (hit.blockX + 1.0D - start.xCoord) / directionX;
            }
            else if (directionX < -0.000001D) {
                exitX = (hit.blockX - start.xCoord) / directionX;
            }

            if (directionY > 0.000001D) {
                exitY = (hit.blockY + 1.0D - start.yCoord) / directionY;
            }
            else if (directionY < -0.000001D) {
                exitY = (hit.blockY - start.yCoord) / directionY;
            }

            if (directionZ > 0.000001D) {
                exitZ = (hit.blockZ + 1.0D - start.zCoord) / directionZ;
            }
            else if (directionZ < -0.000001D) {
                exitZ = (hit.blockZ - start.zCoord) / directionZ;
            }

            double exitDistance = Math.min(exitX, Math.min(exitY, exitZ));

            if (exitDistance >= length) {
                return null;
            }

            double nextDistance = exitDistance + 0.0001D;
            if (nextDistance >= length) {
                return null;
            }

            currentStart = Vec3.createVectorHelper(start.xCoord + directionX * nextDistance, start.yCoord + directionY * nextDistance, start.zCoord + directionZ * nextDistance);
        }

        return this.worldObj.func_147447_a(currentStart, end, false, true, false);
    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound compound)
    {
        compound.setDouble("Damage", this.damage);
    }

    @Override
    protected void readEntityFromNBT(NBTTagCompound compound) {
        if (compound.hasKey("Damage", 99)) {
            this.damage = compound.getDouble("Damage");
        }

        this.trackingTarget = null;
    }
}