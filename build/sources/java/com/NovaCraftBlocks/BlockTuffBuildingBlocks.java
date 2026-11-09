package com.NovaCraftBlocks;

import com.NovaCraft.sounds.ModSounds;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockTuffBuildingBlocks extends Block {
	
	public BlockTuffBuildingBlocks() {
		super(Material.rock);
		this.setHardness(0.75F);
		this.setResistance(1);
		this.setStepSound(ModSounds.soundSculkBricks);
		this.setHarvestLevel("pickaxe", 0);
	}

}
