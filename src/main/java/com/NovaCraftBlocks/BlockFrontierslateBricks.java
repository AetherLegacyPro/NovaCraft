package com.NovaCraftBlocks;

import com.NovaCraft.sounds.ModSounds;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockFrontierslateBricks extends Block {
	
	public BlockFrontierslateBricks() {
		super(Material.rock);
		this.setHardness(8);
		this.setResistance(15);
		this.setStepSound(ModSounds.soundFrontierslateBricks);
		this.setHarvestLevel("pickaxe", 3);
	}
	
}

