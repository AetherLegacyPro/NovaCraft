package com.NovaCraftBlocks;

import com.NovaCraft.sounds.ModSounds;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockSculkBuildingBlocks extends Block {
	
	public BlockSculkBuildingBlocks() {
		super(Material.rock);
		this.setHardness(3);
		this.setResistance(6);
		this.setStepSound(ModSounds.soundSculkBricks);
		this.setHarvestLevel("pickaxe", 2);
	}

}
