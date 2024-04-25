package com.NovaCraft;

import java.util.ArrayList;

import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.common.IExtendedEntityProperties;

public interface IPlayerNovaCraft extends IExtendedEntityProperties {
	
	public void onUpdate();
	
	public EntityLivingBase getEntity();

	public void setJumping(boolean isJumping);

	public boolean isJumping();

	public void setMountSneaking(boolean isSneaking);

	public boolean isMountSneaking();
	
}
