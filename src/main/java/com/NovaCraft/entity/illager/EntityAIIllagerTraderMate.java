package com.NovaCraft.entity.illager;

import net.minecraft.entity.ai.*;
import net.minecraft.world.*;
import net.minecraft.village.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;

public class EntityAIIllagerTraderMate extends EntityAIBase
{
    private EntityIllagerTrader villagerObj;
    private EntityIllagerTrader mate;
    private World worldObj;
    private int matingTimeout;
    Village villageObj;
    private static final String __OBFID = "CL_00001594";
    
    public EntityAIIllagerTraderMate(final EntityIllagerTrader p_i1634_1_) {
        this.villagerObj = p_i1634_1_;
        this.worldObj = p_i1634_1_.worldObj;
        this.setMutexBits(3);
    }
    
    public boolean shouldExecute() {
        if (this.villagerObj.getGrowingAge() != 0) {
            return false;
        }
        if (this.villagerObj.getRNG().nextInt(500) != 0) {
            return false;
        }
        this.villageObj = this.worldObj.villageCollectionObj.findNearestVillage(MathHelper.floor_double(this.villagerObj.posX), MathHelper.floor_double(this.villagerObj.posY), MathHelper.floor_double(this.villagerObj.posZ), 0);
        if (this.villageObj == null) {
            return false;
        }
        if (!this.checkSufficientDoorsPresentForNewVillager()) {
            return false;
        }
        final Entity entity = this.worldObj.findNearestEntityWithinAABB((Class)EntityIllagerTrader.class, this.villagerObj.boundingBox.expand(8.0, 3.0, 8.0), (Entity)this.villagerObj);
        if (entity == null) {
            return false;
        }
        this.mate = (EntityIllagerTrader)entity;
        return this.mate.getGrowingAge() == 0;
    }
    
    public void startExecuting() {
        this.matingTimeout = 600;
        this.villagerObj.setMating(true);
    }
    
    public void resetTask() {
        this.villageObj = null;
        this.mate = null;
        this.villagerObj.setMating(false);
    }
    
    public boolean continueExecuting() {
        return this.matingTimeout >= 0 && this.checkSufficientDoorsPresentForNewVillager() && this.villagerObj.getGrowingAge() == 0;
    }
    
    public void updateTask() {
        --this.matingTimeout;
        this.villagerObj.getLookHelper().setLookPositionWithEntity((Entity)this.mate, 10.0f, 30.0f);
        if (this.villagerObj.getDistanceSqToEntity((Entity)this.mate) > 2.25) {
            this.villagerObj.getNavigator().tryMoveToEntityLiving((Entity)this.mate, 0.25);
        }
        else if (this.matingTimeout == 0 && this.mate.isMating()) {
            this.giveBirth();
        }
        if (this.villagerObj.getRNG().nextInt(35) == 0) {
            this.worldObj.setEntityState((Entity)this.villagerObj, (byte)12);
        }
    }
    
    private boolean checkSufficientDoorsPresentForNewVillager() {
        if (!this.villageObj.isMatingSeason()) {
            return false;
        }
        final int i = (int)((float)this.villageObj.getNumVillageDoors() * 0.35);
        return this.villageObj.getNumVillagers() < i;
    }
    
    private void giveBirth() {
        final EntityIllagerTrader entityvillager = this.villagerObj.createChild(this.mate);
        this.mate.setGrowingAge(6000);
        this.villagerObj.setGrowingAge(6000);
        entityvillager.setGrowingAge(-24000);
        entityvillager.setLocationAndAngles(this.villagerObj.posX, this.villagerObj.posY, this.villagerObj.posZ, 0.0f, 0.0f);
        this.worldObj.spawnEntityInWorld((Entity)entityvillager);
        this.worldObj.setEntityState((Entity)entityvillager, (byte)12);
    }
}
