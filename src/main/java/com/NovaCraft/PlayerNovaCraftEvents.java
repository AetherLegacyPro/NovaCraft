package com.NovaCraft;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;

public class PlayerNovaCraftEvents {

	@SubscribeEvent
	public void onPlayerNovaCraftConstructing(EntityConstructing event) {
		if (event.entity instanceof EntityPlayer) {
			event.entity.registerExtendedProperties("nova_craft:player_novacraft", new PlayerNovaCraft());
		} 
	}
	
}
