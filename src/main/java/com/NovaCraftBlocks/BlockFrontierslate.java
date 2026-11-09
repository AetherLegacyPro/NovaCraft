package com.NovaCraftBlocks;

import com.NovaCraft.sounds.ModSounds;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockFrontierslate extends Block {
	
	public BlockFrontierslate() {
		super(Material.rock);
		this.setHardness(8);
		this.setResistance(15);
		this.setStepSound(ModSounds.soundFrontierslate);
		this.setHarvestLevel("pickaxe", 3);
	}
	
}
