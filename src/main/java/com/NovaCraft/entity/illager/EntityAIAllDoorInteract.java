package com.NovaCraft.entity.illager;

import net.minecraft.entity.ai.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import net.minecraft.pathfinding.*;
import net.minecraft.block.*;

public class EntityAIAllDoorInteract extends EntityAIBase
{
    protected EntityLiving theEntity;
    protected int entityPosX;
    protected int entityPosY;
    protected int entityPosZ;
    protected BlockDoor field_151504_e;
    boolean hasStoppedDoorInteraction;
    float entityPositionX;
    float entityPositionZ;
    private static final String __OBFID = "CL_00001581";
    
    public EntityAIAllDoorInteract(final EntityLiving p_i1621_1_) {
        this.theEntity = p_i1621_1_;
    }
    
    public boolean shouldExecute() {
        if (!this.theEntity.isCollidedHorizontally) {
            return false;
        }
        final PathNavigate pathnavigate = this.theEntity.getNavigator();
        final PathEntity pathentity = pathnavigate.getPath();
        if (pathentity != null && !pathentity.isFinished() && pathnavigate.getCanBreakDoors()) {
            for (int i = 0; i < Math.min(pathentity.getCurrentPathIndex() + 2, pathentity.getCurrentPathLength()); ++i) {
                final PathPoint pathpoint = pathentity.getPathPointFromIndex(i);
                this.entityPosX = pathpoint.xCoord;
                this.entityPosY = pathpoint.yCoord + 1;
                this.entityPosZ = pathpoint.zCoord;
                if (this.theEntity.getDistanceSq((double)this.entityPosX, this.theEntity.posY, (double)this.entityPosZ) <= 2.25) {
                    this.field_151504_e = this.func_151503_a(this.entityPosX, this.entityPosY, this.entityPosZ);
                    if (this.field_151504_e != null) {
                        return true;
                    }
                }
            }
            this.entityPosX = MathHelper.floor_double(this.theEntity.posX);
            this.entityPosY = MathHelper.floor_double(this.theEntity.posY + 1.0);
            this.entityPosZ = MathHelper.floor_double(this.theEntity.posZ);
            this.field_151504_e = this.func_151503_a(this.entityPosX, this.entityPosY, this.entityPosZ);
            return this.field_151504_e != null;
        }
        return false;
    }
    
    public boolean continueExecuting() {
        return !this.hasStoppedDoorInteraction;
    }
    
    public void startExecuting() {
        this.hasStoppedDoorInteraction = false;
        this.entityPositionX = (float)(this.entityPosX + 0.5f - this.theEntity.posX);
        this.entityPositionZ = (float)(this.entityPosZ + 0.5f - this.theEntity.posZ);
    }
    
    public void updateTask() {
        final float f = (float)(this.entityPosX + 0.5f - this.theEntity.posX);
        final float f2 = (float)(this.entityPosZ + 0.5f - this.theEntity.posZ);
        final float f3 = this.entityPositionX * f + this.entityPositionZ * f2;
        if (f3 < 0.0f) {
            this.hasStoppedDoorInteraction = true;
        }
    }
    
    private BlockDoor func_151503_a(final int x, final int y, final int z) {
        final Block block = this.theEntity.worldObj.getBlock(x, y, z);
        return (block instanceof BlockDoor) ? (BlockDoor) block : null;
    }
}
