package com.NovaCraftBlocks.crystals;

import com.NovaCraft.sounds.ModSounds;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockVariegatedShard extends Block {
	
	public BlockVariegatedShard() {
		this(Material.glass);
	}
	public BlockVariegatedShard(Material material) {
		super(material);
		setHardness(7.5F);
		setResistance(7.5F);
		this.setStepSound(ModSounds.soundCrystal);
	}

}
