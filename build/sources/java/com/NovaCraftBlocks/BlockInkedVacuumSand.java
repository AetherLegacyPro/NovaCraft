package com.NovaCraftBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockInkedVacuumSand extends Block {

	public BlockInkedVacuumSand() {
		super(Material.sand);

		this.setHardness(0.45F);
		this.setResistance(0.45F);
		this.setHarvestLevel("shovel", 0);
		this.setStepSound(soundTypeSand);
	}

}
