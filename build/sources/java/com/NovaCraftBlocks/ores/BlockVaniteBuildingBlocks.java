package com.NovaCraftBlocks.ores;

import com.NovaCraft.sounds.ModSounds;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockVaniteBuildingBlocks extends Block {
	
	public BlockVaniteBuildingBlocks() {
		super(Material.iron);
		this.setHardness(15);
		this.setResistance(25);
		this.setStepSound(ModSounds.soundNullstone);
		this.setHarvestLevel("pickaxe", 3);
	}	

}


