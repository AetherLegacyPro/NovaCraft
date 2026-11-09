package com.NovaCraft.entity.illager;

import net.minecraft.entity.ai.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;

public class EntityAILookAtTradePlayerIllager extends EntityAIWatchClosest
{
    private final EntityIllagerTrader theMerchant;
    
    public EntityAILookAtTradePlayerIllager(final EntityIllagerTrader entity) {
        super((EntityLiving)entity, (Class)EntityPlayer.class, 8.0f);
        this.theMerchant = entity;
    }
    
    public boolean shouldExecute() {
        if (this.theMerchant.isTrading()) {
            this.closestEntity = (Entity)this.theMerchant.getCustomer();
            return true;
        }
        return false;
    }
}
