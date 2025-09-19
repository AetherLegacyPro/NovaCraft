package com.NovaCraft.entity.illager;

import net.minecraft.entity.ai.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;

public class NewEntityAIArrowAttack extends EntityAIBase
{
    private final EntityLiving entityHost;
    private final IRangedAttackMob rangedAttackEntityHost;
    private EntityLivingBase attackTarget;
    private int rangedAttackTime;
    private double entityMoveSpeed;
    private int field_75318_f;
    private int field_96561_g;
    private int maxRangedAttackTime;
    private float field_96562_i;
    private float field_82642_h;
    private static final String __OBFID = "CL_00001609";
    
    public NewEntityAIArrowAttack(final IRangedAttackMob p_i1649_1_, final double p_i1649_2_, final int p_i1649_4_, final float p_i1649_5_) {
        this(p_i1649_1_, p_i1649_2_, p_i1649_4_, p_i1649_4_, p_i1649_5_);
    }
    
    public NewEntityAIArrowAttack(final IRangedAttackMob p_i1650_1_, final double p_i1650_2_, final int p_i1650_4_, final int p_i1650_5_, final float p_i1650_6_) {
        this.rangedAttackTime = -1;
        if (!(p_i1650_1_ instanceof EntityLivingBase)) {
            throw new IllegalArgumentException("ArrowAttackGoal requires Mob implements RangedAttackMob");
        }
        this.rangedAttackEntityHost = p_i1650_1_;
        this.entityHost = (EntityLiving)p_i1650_1_;
        this.entityMoveSpeed = p_i1650_2_;
        this.field_96561_g = p_i1650_4_;
        this.maxRangedAttackTime = p_i1650_5_;
        this.field_96562_i = p_i1650_6_;
        this.field_82642_h = p_i1650_6_ * p_i1650_6_;
        this.setMutexBits(3);
    }
    
    public boolean shouldExecute() {
        final EntityLivingBase entitylivingbase = this.entityHost.getAttackTarget();
        if (entitylivingbase == null) {
            return false;
        }
        if (!entitylivingbase.isEntityAlive()) {
            return false;
        }
        this.attackTarget = entitylivingbase;
        return true;
    }
    
    public boolean continueExecuting() {
        return this.shouldExecute() || !this.entityHost.getNavigator().noPath();
    }
    
    public void resetTask() {
        this.attackTarget = null;
        this.field_75318_f = 0;
        this.rangedAttackTime = -1;
    }
    
    public void updateTask() {
        final double d0 = this.entityHost.getDistanceSq(this.attackTarget.posX, this.attackTarget.boundingBox.minY, this.attackTarget.posZ);
        final boolean flag = this.entityHost.getEntitySenses().canSee((Entity)this.attackTarget);
        if (flag) {
            ++this.field_75318_f;
        }
        else {
            this.field_75318_f = 0;
        }
        if (d0 <= this.field_82642_h && this.field_75318_f >= 20) {
            this.entityHost.getNavigator().clearPathEntity();
        }
        else {
            this.entityHost.getNavigator().tryMoveToEntityLiving((Entity)this.attackTarget, this.entityMoveSpeed);
        }
        this.entityHost.getLookHelper().setLookPositionWithEntity((Entity)this.attackTarget, 30.0f, 30.0f);
        final int rangedAttackTime = this.rangedAttackTime - 1;
        this.rangedAttackTime = rangedAttackTime;
        if (rangedAttackTime == 0) {
            if (d0 > this.field_82642_h || !flag) {
                return;
            }
            float f2;
            final float f = f2 = MathHelper.sqrt_double(d0) / this.field_96562_i;
            if (f < 0.1f) {
                f2 = 0.1f;
            }
            if (f2 > 1.0f) {
                f2 = 1.0f;
            }
            this.rangedAttackEntityHost.attackEntityWithRangedAttack(this.attackTarget, f2);
            this.rangedAttackTime = MathHelper.floor_float(f * (this.maxRangedAttackTime - this.field_96561_g) + this.field_96561_g);
        }
        else if (this.rangedAttackTime < 0) {
            final float f = MathHelper.sqrt_double(d0) / this.field_96562_i;
            this.rangedAttackTime = MathHelper.floor_float(f * (this.maxRangedAttackTime - this.field_96561_g) + this.field_96561_g);
        }
    }
}
