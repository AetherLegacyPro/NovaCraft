package com.NovaCraft.entity.AI;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIBase;

public class EntityAILavaSwimming extends EntityAIBase
{
    private EntityLiving theEntity;

    public EntityAILavaSwimming(EntityLiving p_i1624_1_)
    {
        this.theEntity = p_i1624_1_;
        this.setMutexBits(4);
        p_i1624_1_.getNavigator().setCanSwim(true);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
        return this.theEntity.handleLavaMovement();
    }

    /**
     * Updates the task
     */
    public void updateTask()
    {
        if (this.theEntity.getRNG().nextFloat() < 0.8F)
        {
            this.theEntity.getJumpHelper().setJumping();
        }
    }
}
