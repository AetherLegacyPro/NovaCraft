package com.NovaCraft.entity.AI;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIBase;

public class EntityAILavaSwimming extends EntityAIBase
{
    private EntityLiving theEntity;

    public EntityAILavaSwimming(EntityLiving living)
    {
        this.theEntity = living;
        this.setMutexBits(4);
        living.getNavigator().setCanSwim(true);
    }

    public boolean shouldExecute()
    {
        return this.theEntity.handleLavaMovement();
    }

    public void updateTask()
    {
        if (this.theEntity.getRNG().nextFloat() < 0.8F)
        {
            this.theEntity.getJumpHelper().setJumping();
        }
    }
}
