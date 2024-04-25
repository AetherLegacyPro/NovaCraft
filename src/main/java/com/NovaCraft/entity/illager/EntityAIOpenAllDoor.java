package com.NovaCraft.entity.illager;

import net.minecraft.entity.*;

public class EntityAIOpenAllDoor extends EntityAIAllDoorInteract
{
    boolean field_75361_i;
    int field_75360_j;
    
    public EntityAIOpenAllDoor(final EntityLiving p_i1644_1_, final boolean p_i1644_2_) {
        super(p_i1644_1_);
        this.theEntity = p_i1644_1_;
        this.field_75361_i = p_i1644_2_;
    }
    
    public boolean continueExecuting() {
        return this.field_75361_i && this.field_75360_j > 0 && super.continueExecuting();
    }
    
    public void startExecuting() {
        this.field_75360_j = 20;
        this.field_151504_e.func_150014_a(this.theEntity.worldObj, this.entityPosX, this.entityPosY, this.entityPosZ, true);
    }
    
    public void resetTask() {
        if (this.field_75361_i) {
            this.field_151504_e.func_150014_a(this.theEntity.worldObj, this.entityPosX, this.entityPosY, this.entityPosZ, false);
        }
    }
    
    public void updateTask() {
        --this.field_75360_j;
        super.updateTask();
    }
}
