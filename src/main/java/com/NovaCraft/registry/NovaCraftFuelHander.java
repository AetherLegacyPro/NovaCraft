package com.NovaCraft.registry;

import com.NovaCraft.Items.NovaCraftItems;

import cpw.mods.fml.common.IFuelHandler;
import net.minecraft.item.ItemStack;

public class NovaCraftFuelHander implements IFuelHandler {
	
	@Override
	public int getBurnTime(ItemStack fuel) {
		if(fuel.getItem() == NovaCraftItems.blazing_coal) return 3600;
		if(fuel.getItem() == NovaCraftItems.ionizatior_rod) return 2400;
		if(fuel.getItem() == NovaCraftItems.yttrlinsite_shard) return 1200;
		return 0;
	}

}
