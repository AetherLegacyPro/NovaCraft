package com.NovaCraftBlocks;

import com.NovaCraft.sounds.ModSounds;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockEtherstoneBuildingBlocks extends Block {
	
	public BlockEtherstoneBuildingBlocks() {
		super(Material.rock);
		this.setHardness(2);
		this.setResistance(3);
		this.setStepSound(ModSounds.soundEtherstoneBricks);
		this.setHarvestLevel("pickaxe", 1);
	}

}
