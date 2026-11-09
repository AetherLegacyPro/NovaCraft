package com.NovaCraftBlocks;

import com.NovaCraft.sounds.ModSounds;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockGrimstoneBuildingBlocks extends Block {
	
	public BlockGrimstoneBuildingBlocks() {
		super(Material.rock);
		this.setHardness(3);
		this.setResistance(6);
		this.setStepSound(ModSounds.soundGrimstoneBricks);
		this.setHarvestLevel("pickaxe", 1);
	}

}
