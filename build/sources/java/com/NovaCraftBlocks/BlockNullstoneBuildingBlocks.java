package com.NovaCraftBlocks;

import com.NovaCraft.sounds.ModSounds;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockNullstoneBuildingBlocks extends Block {
	
	public BlockNullstoneBuildingBlocks() {
		super(Material.rock);
		this.setHardness(5);
		this.setResistance(12);
		this.setStepSound(ModSounds.soundNullstoneBricks);
		this.setHarvestLevel("pickaxe", 3);
	}

}

