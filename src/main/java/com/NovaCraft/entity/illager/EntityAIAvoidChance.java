package com.NovaCraft.entity.illager;

import net.minecraft.entity.ai.*;
import net.minecraft.entity.*;

public class EntityAIAvoidChance extends EntityAIAvoidEntity
{
    private EntityCreature theEntity;
    private float chance;
    private String soundEffect;
    
    public EntityAIAvoidChance(final EntityCreature entity, final Class avoidClass, final float f, final double d, final double d1, final float c) {
        this(entity, avoidClass, f, d, d1, c, null);
    }
    
    public EntityAIAvoidChance(final EntityCreature entity, final Class avoidClass, final float f, final double d, final double d1, final float c, final String sound) {
        super(entity, avoidClass, f, d, d1);
        this.theEntity = entity;
        this.chance = c;
        this.soundEffect = sound;
    }
    
    public boolean shouldExecute() {
        return this.theEntity.getAttackTarget() == null && this.theEntity.getRNG().nextFloat() < this.chance && super.shouldExecute();
    }
    
    public void startExecuting() {
        super.startExecuting();
        if (this.soundEffect != null) {
            this.theEntity.playSound(this.soundEffect, 0.5f, (this.theEntity.getRNG().nextFloat() - this.theEntity.getRNG().nextFloat()) * 0.2f + 1.0f);
        }
    }
}
