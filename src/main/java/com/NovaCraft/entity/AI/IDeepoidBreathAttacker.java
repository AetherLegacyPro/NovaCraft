package com.NovaCraft.entity.AI;

import net.minecraft.entity.Entity;

public interface IDeepoidBreathAttacker {

	public abstract boolean isBreathing();

	public abstract void setBreathing(boolean flag);

	/**
	 * Deal damage for our breath attack
	 * @param target
	 */
	public abstract void doBreathAttack(Entity target);

}
