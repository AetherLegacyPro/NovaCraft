package com.NovaCraft.entity.misc;

import com.NovaCraft.entity.EntityCrystalSlime;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;

public class EntityAICrystalSlimeSwell extends EntityAIBase
{
    EntityCrystalSlime swellingUro;
    EntityLivingBase uroAttackTarget;

    public EntityAICrystalSlimeSwell(EntityCrystalSlime p_i1655_1_)
    {
        this.swellingUro = p_i1655_1_;
        this.setMutexBits(1);
    }

    public boolean shouldExecute()
    {
        EntityLivingBase entitylivingbase = this.swellingUro.getAttackTarget();
        return this.swellingUro.getCreeperState() > 0 || entitylivingbase != null && this.swellingUro.getDistanceSqToEntity(entitylivingbase) < 9.0D;
    }

    public void startExecuting()
    {
        this.swellingUro.getNavigator().clearPathEntity();
        this.uroAttackTarget = this.swellingUro.getAttackTarget();
    }

    public void resetTask()
    {
        this.uroAttackTarget = null;
    }

    public void updateTask()
    {
        if (this.uroAttackTarget == null)
        {
            this.swellingUro.setCreeperState(-1);
        }
        else if (this.swellingUro.getDistanceSqToEntity(this.uroAttackTarget) > 64.0D)
        {
            this.swellingUro.setCreeperState(-1);
        }
        else if (!this.swellingUro.getEntitySenses().canSee(this.uroAttackTarget))
        {
            this.swellingUro.setCreeperState(-1);
        }
        else
        {
            this.swellingUro.setCreeperState(1);
        }
    }
}
