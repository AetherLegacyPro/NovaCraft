package com.NovaCraftBlocks;

import com.NovaCraft.sounds.ModSounds;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockBasalBuildingBlocks extends Block {
	
	public BlockBasalBuildingBlocks() {
		super(Material.rock);
		this.setHardness(1.5F);
		this.setResistance(12F);
		this.setStepSound(ModSounds.soundGrimstone);
		this.setHarvestLevel("pickaxe", 2);
	}

}
