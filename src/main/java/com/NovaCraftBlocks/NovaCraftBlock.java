package com.NovaCraftBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class NovaCraftBlock extends Block {

	public NovaCraftBlock(Material material, String texture) {
		super(material);

		this.setBlockTextureName(texture);
	}

}
