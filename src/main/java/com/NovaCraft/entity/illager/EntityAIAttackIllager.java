package com.NovaCraft.entity.illager;

import net.minecraft.entity.ai.*;
import net.minecraft.command.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.init.*;
import net.minecraft.world.*;
import java.util.*;

import com.NovaCraft.Items.NovaCraftItems;

public class EntityAIAttackIllager extends EntityAITarget
{
    private final Class targetClass;
    private final int targetChance;
    private final Sorter theNearestAttackableTargetSorter;
    private final IEntitySelector targetEntitySelector;
    private EntityLivingBase targetEntity;
    private static final String __OBFID = "CL_00001620";
    
    public EntityAIAttackIllager(final EntityCreature p_i1663_1_, final Class p_i1663_2_, final int p_i1663_3_, final boolean p_i1663_4_) {
        this(p_i1663_1_, p_i1663_2_, p_i1663_3_, p_i1663_4_, false);
    }
    
    public EntityAIAttackIllager(final EntityCreature p_i1664_1_, final Class p_i1664_2_, final int p_i1664_3_, final boolean p_i1664_4_, final boolean p_i1664_5_) {
        this(p_i1664_1_, p_i1664_2_, p_i1664_3_, p_i1664_4_, p_i1664_5_, null);
    }
    
    public EntityAIAttackIllager(final EntityCreature p_i1665_1_, final Class p_i1665_2_, final int p_i1665_3_, final boolean p_i1665_4_, final boolean p_i1665_5_, final IEntitySelector p_i1665_6_) {
        super(p_i1665_1_, p_i1665_4_, p_i1665_5_);
        this.targetClass = p_i1665_2_;
        this.targetChance = p_i1665_3_;
        this.theNearestAttackableTargetSorter = new Sorter((Entity)p_i1665_1_);
        this.setMutexBits(1);
        this.targetEntitySelector = (IEntitySelector)new IEntitySelector() {
            private static final String __OBFID = "CL_00001621";
            
            public boolean isEntityApplicable(final Entity p_82704_1_) {
                return (!(p_82704_1_ instanceof IEntityOwnable) || !(((IEntityOwnable)p_82704_1_).getOwner() instanceof EntityPlayer)) && 
                		(!(p_82704_1_ instanceof EntityPlayer) || ((EntityPlayer)p_82704_1_).inventory.armorItemInSlot(3) == null || ((EntityPlayer)p_82704_1_).inventory.armorItemInSlot(3).getItem() != NovaCraftItems.vanite_blue_crown)                	             		             		
                		&& (!(p_82704_1_ instanceof EntityPlayer) || ((EntityPlayer)p_82704_1_).inventory.armorItemInSlot(3) == null || ((EntityPlayer)p_82704_1_).inventory.armorItemInSlot(3).getItem() != NovaCraftItems.vanite_red_crown) 
                		&& (!(p_82704_1_ instanceof EntityPlayer) || ((EntityPlayer)p_82704_1_).inventory.armorItemInSlot(3) == null || ((EntityPlayer)p_82704_1_).inventory.armorItemInSlot(3).getItem() != NovaCraftItems.vanite_green_crown) 
                		&& (!(p_82704_1_ instanceof EntityPlayer) || ((EntityPlayer)p_82704_1_).inventory.armorItemInSlot(3) == null || ((EntityPlayer)p_82704_1_).inventory.armorItemInSlot(3).getItem() != NovaCraftItems.vanite_orange_crown)               		
                		&& (!(p_82704_1_ instanceof EntityPlayer) || ((EntityPlayer)p_82704_1_).inventory.armorItemInSlot(3) == null || ((EntityPlayer)p_82704_1_).inventory.armorItemInSlot(3).getItem() != NovaCraftItems.vanite_dark_blue_crown) 
                		&& (!(p_82704_1_ instanceof EntityPlayer) || ((EntityPlayer)p_82704_1_).inventory.armorItemInSlot(3) == null || ((EntityPlayer)p_82704_1_).inventory.armorItemInSlot(3).getItem() != NovaCraftItems.vanite_exotic_crown) 
                		&& (!(p_82704_1_ instanceof EntityPlayer) || ((EntityPlayer)p_82704_1_).inventory.armorItemInSlot(3) == null || ((EntityPlayer)p_82704_1_).inventory.armorItemInSlot(3).getItem() != NovaCraftItems.vanite_notched_crown) 
                		&& (!(p_82704_1_ instanceof EntityPlayer) || ((EntityPlayer)p_82704_1_).inventory.armorItemInSlot(3) == null || ((EntityPlayer)p_82704_1_).inventory.armorItemInSlot(3).getItem() != NovaCraftItems.vanite_mysterious_crown)                 		
                		&& (!(p_82704_1_ instanceof EntityPlayer) || ((EntityPlayer)p_82704_1_).worldObj.difficultySetting != EnumDifficulty.PEACEFUL) && p_82704_1_ instanceof EntityLivingBase && (p_i1665_6_ == null || p_i1665_6_.isEntityApplicable(p_82704_1_)) 
                		&& EntityAIAttackIllager.access$000(EntityAIAttackIllager.this, (EntityLivingBase)p_82704_1_, false);
            }
        };
    }
    
    public boolean shouldExecute() {
        if (this.targetChance > 0 && this.taskOwner.getRNG().nextInt(this.targetChance) != 0) {
            return false;
        }
        final double d0 = this.getTargetDistance();
        final List list = this.taskOwner.worldObj.selectEntitiesWithinAABB(this.targetClass, this.taskOwner.boundingBox.expand(d0, 4.0, d0), this.targetEntitySelector);
        Collections.sort((List<Object>)list, this.theNearestAttackableTargetSorter);
        if (list.isEmpty()) {
            return false;
        }
        this.targetEntity = (EntityLivingBase) list.get(0);
        return true;
    }
    
    public void startExecuting() {
        this.taskOwner.setAttackTarget(this.targetEntity);
        final List<EntityIllagerTrader> piglinsNear = (List<EntityIllagerTrader>)this.taskOwner.worldObj.getEntitiesWithinAABB((Class)EntityIllagerTrader.class, this.taskOwner.boundingBox.expand(10.0, 10.0, 10.0));
        if (this.taskOwner.getAttackTarget() != null) {
            for (final EntityIllagerTrader piglin : piglinsNear) {
                if (piglin != null) {
                    if (piglin.isDead) {
                        continue;
                    }
                    if (piglin.getAttackTarget() != null || !this.taskOwner.getAttackTarget().isEntityAlive()) {
                        continue;
                    }
                    piglin.setAttackTarget(this.taskOwner.getAttackTarget());
                }
            }
        }
        super.startExecuting();
    }
    
    static /* synthetic */ boolean access$000(final EntityAIAttackIllager x0, final EntityLivingBase x1, final boolean x2) {
        return x0.isSuitableTarget(x1, x2);
    }
    
    public static class Sorter implements Comparator
    {
        private final Entity theEntity;
        private static final String __OBFID = "CL_00001622";
        
        public Sorter(final Entity p_i1662_1_) {
            this.theEntity = p_i1662_1_;
        }
        
        public int compare(final Entity p_compare_1_, final Entity p_compare_2_) {
            final double d0 = this.theEntity.getDistanceSqToEntity(p_compare_1_);
            final double d2 = this.theEntity.getDistanceSqToEntity(p_compare_2_);
            return (d0 < d2) ? -1 : ((d0 > d2) ? 1 : 0);
        }
        
        @Override
        public int compare(final Object p_compare_1_, final Object p_compare_2_) {
            return this.compare((Entity)p_compare_1_, (Entity)p_compare_2_);
        }
    }
}
