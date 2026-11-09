package com.NovaCraft.entity.AI;

import net.minecraft.entity.Entity;

public interface IDeepoidBreathAttacker {

	public abstract boolean isBreathing();

	public abstract void setBreathing(boolean flag);

	public abstract void doBreathAttack(Entity target);

}
