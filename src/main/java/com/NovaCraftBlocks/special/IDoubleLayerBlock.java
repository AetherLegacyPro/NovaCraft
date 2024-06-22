package com.NovaCraftBlocks.special;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.IIcon;

public interface IDoubleLayerBlock {
	@SideOnly(Side.CLIENT)
	IIcon getSecondLayerIcon(int side, int meta);

	/**
	 * Used by Thaumcraft ores so the amber and cinnibar deepslate ores render normally.
	 *
	 * @param meta
	 * @return
	 */
	default boolean isMetaNormalBlock(int meta) {
		return false;
	}

	default boolean isSecondLayerAbove(int meta) {
		return false;
	}
}
