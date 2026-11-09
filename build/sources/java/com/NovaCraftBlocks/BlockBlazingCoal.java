package com.NovaCraftBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockBlazingCoal extends Block {
	
	public BlockBlazingCoal() {
		super(Material.rock);

		this.setHardness(3.5F);
		this.setResistance(5F);
		this.setStepSound(soundTypeStone);
		this.setHarvestLevel("pickaxe", 2);
	}
	
}
