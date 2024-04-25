package com.NovaCraft.entity.illager;

import net.minecraft.entity.ai.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;

public class EntityAILookAtTradePlayerIllagerChief extends EntityAIWatchClosest
{
    private final EntityIllagerChief theMerchant;
    private static final String __OBFID = "CL_00001593";
    
    public EntityAILookAtTradePlayerIllagerChief(final EntityIllagerChief p_i1633_1_) {
        super((EntityLiving)p_i1633_1_, (Class)EntityPlayer.class, 8.0f);
        this.theMerchant = p_i1633_1_;
    }
    
    public boolean shouldExecute() {
        if (this.theMerchant.isTrading()) {
            this.closestEntity = (Entity)this.theMerchant.getCustomer();
            return true;
        }
        return false;
    }
}
