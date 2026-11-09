package com.NovaCraft.entity.misc;

import com.NovaCraft.entity.EntityNullifier;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;

public class EntityAINulliferSwell extends EntityAIBase
{
	EntityNullifier swellingCreeper;
    EntityLivingBase creeperAttackTarget;

    public EntityAINulliferSwell(EntityNullifier nullifier)
    {
        this.swellingCreeper = nullifier;
        this.setMutexBits(1);
    }

    public boolean shouldExecute()
    {
        EntityLivingBase entitylivingbase = this.swellingCreeper.getAttackTarget();
        return this.swellingCreeper.getCreeperState() > 0 || entitylivingbase != null && this.swellingCreeper.getDistanceSqToEntity(entitylivingbase) < 9.0D;
    }

    public void startExecuting()
    {
        this.swellingCreeper.getNavigator().clearPathEntity();
        this.creeperAttackTarget = this.swellingCreeper.getAttackTarget();
    }

    public void resetTask()
    {
        this.creeperAttackTarget = null;
    }

    @Override
    public void updateTask() {
        EntityLivingBase target = this.swellingCreeper.getAttackTarget();
        if (target == null) {
            this.swellingCreeper.setCreeperState(-1);
        }
        else if (this.swellingCreeper.getDistanceSqToEntity(target) > 49.0D) {
            this.swellingCreeper.setCreeperState(-1);
        }
        else if (!this.swellingCreeper.getEntitySenses().canSee(target)) {
            this.swellingCreeper.setCreeperState(-1);
        }
        else {
            this.swellingCreeper.setCreeperState(1);
        }
    }
}
