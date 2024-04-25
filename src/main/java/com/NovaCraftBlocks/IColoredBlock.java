package com.NovaCraftBlocks;

import net.minecraft.item.ItemStack;

public interface IColoredBlock {

	public int getColorFromItemStack(ItemStack stack, int pass);

}
