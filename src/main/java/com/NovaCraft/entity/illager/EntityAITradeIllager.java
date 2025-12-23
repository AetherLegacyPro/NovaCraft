package com.NovaCraft.entity.illager;

import net.minecraft.entity.ai.*;
import net.minecraft.entity.*;
import net.minecraft.inventory.*;
import net.minecraft.entity.player.*;

public class EntityAITradeIllager extends EntityAIBase
{
    private EntityIllagerTrader villager;
    
    public EntityAITradeIllager(final EntityIllagerTrader p_i1658_1_) {
        this.villager = p_i1658_1_;
        this.setMutexBits(5);
    }
    
    public boolean shouldExecute() {
        if (!this.villager.isEntityAlive()) {
            return false;
        }
        if (this.villager.isInWater()) {
            return false;
        }
        if (!this.villager.onGround) {
            return false;
        }
        if (this.villager.velocityChanged) {
            return false;
        }
        final EntityPlayer entityplayer = this.villager.getCustomer();
        return entityplayer != null && this.villager.getDistanceSqToEntity((Entity)entityplayer) <= 16.0 && entityplayer.openContainer instanceof Container;
    }
    
    public void startExecuting() {
        this.villager.getNavigator().clearPathEntity();
    }
    
    public void resetTask() {
        this.villager.setCustomer(null);
    }
}

