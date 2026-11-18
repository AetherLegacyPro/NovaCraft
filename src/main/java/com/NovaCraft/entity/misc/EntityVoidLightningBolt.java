package com.NovaCraft.entity.misc;

import java.util.List;
import com.NovaCraft.entity.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityDragonPart;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityVoidLightningBolt extends Entity {
    private static final int LIFETIME = 16;

    public EntityVoidLightningBolt(World world) {
        super(world);
        this.setSize(0.1F, 0.1F);
        this.ignoreFrustumCheck = true;
        this.renderDistanceWeight = 128.0D;
    }

    public EntityVoidLightningBolt(World world, double x, double y, double z) {
        this(world);
        this.setPosition(x, y, z);
    }

    @Override
    protected void entityInit() {
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        if (!this.worldObj.isRemote) {
            if (this.ticksExisted == 1) {
                this.worldObj.playSoundEffect(this.posX, this.posY, this.posZ, "ambient.weather.thunder", 0.2F, 0.4F);
                this.worldObj.playSoundEffect(this.posX, this.posY, this.posZ, "random.explode", 0.1F, 0.2F);

                this.damageNearbyEntities();
                this.trySummonMob();
            }

            if (this.ticksExisted >= LIFETIME) {
                this.setDead();
            }
        }
    }

    private void damageNearbyEntities() {
        AxisAlignedBB area = AxisAlignedBB.getBoundingBox(this.posX - 3.0D, this.posY - 3.0D, this.posZ - 3.0D, this.posX + 3.0D, this.posY + 6.0D, this.posZ + 3.0D);
        List entities = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, area);
        for (Object object : entities) {
            Entity entity = (Entity)object;
            if (entity instanceof EntityNullifier) {
                ((EntityNullifier)entity).setPowered(true);
            }

            if (posY >= 12) {
                if (this.isExcluded(entity)) {
                    continue;
                }

                entity.attackEntityFrom(DamageSource.outOfWorld, 2.0F);
            } else {
                if (this.isExcluded(entity)) {
                    continue;
                }

                entity.attackEntityFrom(DamageSource.magic, 4.0F);
            }
        }
    }

    private EntityLiving createSummonedMob() {
        if (this.rand.nextBoolean()) {
            return new EntityVoidEntity(this.worldObj);
        }

        return new EntityRealityDistorter(this.worldObj);
    }

    private void trySummonMob() {
        int summon_entity_chance = (int)(Math.random() * 30);
        if (summon_entity_chance != 0) {
            return;
        }

        EntityLiving mob = this.createSummonedMob();
        int centerX = MathHelper.floor_double(this.posX);
        int centerY = MathHelper.floor_double(this.posY);
        int centerZ = MathHelper.floor_double(this.posZ);

        double closestDistanceSq = Double.MAX_VALUE;

        int bestX = 0;
        int bestY = 0;
        int bestZ = 0;

        boolean foundPosition = false;

        int minimumY = Math.max(1, centerY - 8);
        int maximumY = Math.min(255, centerY + 8);

        for (int x = centerX - 4; x <= centerX + 4; ++x) {
            for (int y = minimumY; y <= maximumY; ++y) {
                for (int z = centerZ - 4; z <= centerZ + 4; ++z) {
                    if (!this.isBlockSolid(mob, x, y, z)) {
                        continue;
                    }

                    double differenceX = x + 0.5D - this.posX;
                    double differenceY = y - this.posY;
                    double differenceZ = z + 0.5D - this.posZ;

                    double distanceSq = differenceX * differenceX + differenceY * differenceY + differenceZ * differenceZ;
                    if (distanceSq < closestDistanceSq) {
                        closestDistanceSq = distanceSq;

                        bestX = x;
                        bestY = y;
                        bestZ = z;

                        foundPosition = true;
                    }
                }
            }
        }

        if (!foundPosition) {
            return;
        }

        mob.setLocationAndAngles(bestX + 0.5D, bestY, bestZ + 0.5D, this.rand.nextFloat() * 360.0F, 0.0F);

        this.worldObj.spawnEntityInWorld(mob);
    }

    private boolean isBlockSolid(EntityLiving mob, int x, int y, int z) {
        if (!this.worldObj.blockExists(x, y - 1, z)) {
            return false;
        }

        if (!World.doesBlockHaveSolidTopSurface(this.worldObj, x, y - 1, z)) {
            return false;
        }

        mob.setLocationAndAngles(x + 0.5D, y, z + 0.5D, 0.0F, 0.0F);

        AxisAlignedBB box = mob.boundingBox;
        if (box.minY < 0.0D || box.maxY > 256.0D) {
            return false;
        }

        //Is the chunk loaded? May cause a crash otherwise or infinite loop...
        int minimumX = MathHelper.floor_double(box.minX);
        int maximumX = MathHelper.floor_double(box.maxX);
        int minimumZ = MathHelper.floor_double(box.minZ);
        int maximumZ = MathHelper.floor_double(box.maxZ);
        int topY = MathHelper.floor_double(box.maxY - 0.0001D);

        for (int checkX = minimumX; checkX <= maximumX; ++checkX) {
            for (int checkZ = minimumZ; checkZ <= maximumZ; ++checkZ) {
                if (!this.worldObj.blockExists(checkX, y, checkZ) || !this.worldObj.blockExists(checkX, topY, checkZ)) {
                    return false;
                }
            }
        }

        return this.worldObj.getCollidingBoundingBoxes(mob, box).isEmpty() && !this.worldObj.isAnyLiquid(box) && this.worldObj.checkNoEntityCollision(box);
    }

    private boolean isExcluded(Entity entity) {
        return entity instanceof EntityPrisoner || entity instanceof EntityDistortion || entity instanceof EntityRealityDistorter || entity instanceof EntityFrontierGolem
                || entity instanceof EntityPhantomized || entity instanceof EntityVoidEntity || entity instanceof EntityVoidCube || entity instanceof EntityBloviator
                || entity instanceof EntityPhantom || entity instanceof EntityDragon || entity instanceof EntityDragonPart;
    }

    @Override
    public boolean canBeCollidedWith() {
        return false;
    }

    @Override
    public boolean canBePushed() {
        return false;
    }

    @Override
    protected boolean canTriggerWalking() {
        return false;
    }

    @Override
    protected void readEntityFromNBT(NBTTagCompound compound) {
        this.setDead();
    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound compound) {
    }
}