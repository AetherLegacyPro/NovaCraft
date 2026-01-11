package com.NovaCraft.registry;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraftBlocks.NovaCraftBlocks;

import cpw.mods.fml.common.IFuelHandler;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class NovaCraftFuelHander implements IFuelHandler {
	
	@Override
	public int getBurnTime(ItemStack fuel) {
		
		Item item = fuel.getItem();
		
		if(fuel.getItem() == NovaCraftItems.blazing_coal) return 3600;
		if (item == Item.getItemFromBlock(NovaCraftBlocks.blazing_coal_block)) return 32600;
		if(fuel.getItem() == NovaCraftItems.ionizatior_rod) return 2400;
		if(fuel.getItem() == NovaCraftItems.yttrlinsite_shard) return 1200;
		if (item == Item.getItemFromBlock(NovaCraftBlocks.yttrlinsite_block)) return 11500;
		if (item == Item.getItemFromBlock(NovaCraftBlocks.luminant_log)) return 300;
		if(item == Item.getItemFromBlock(NovaCraftBlocks.luminant_sapling)) return 100;

		return 0;
	}

}
