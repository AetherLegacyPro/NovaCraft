package com.NovaCraftBlocks.decorative;

import java.util.Random;

import com.NovaCraft.sounds.ModSounds;
import com.NovaCraftBlocks.NovaCraftBlocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class BlocksNovaCraftSlab extends BlockSlab {

	private String name;

	public BlocksNovaCraftSlab(String name, boolean double_slab, Material materialIn) {
		super(double_slab, materialIn);
		this.name = name;

		this.setLightOpacity(0);
		this.setStepSound(materialIn == Material.wood ? soundTypeWood : ModSounds.soundNullstoneBricks);
	}

	@Override
	public Item getItem(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_) {
		return Item.getItemFromBlock(this.getDroppedSlab());
	}

	public Block getDroppedSlab() {
		if (this == NovaCraftBlocks.grimstone_double_slab) {
			return NovaCraftBlocks.grimstone_slab;		 
		} else if (this == NovaCraftBlocks.cobbled_grimstone_double_slab) {
			return NovaCraftBlocks.cobbled_grimstone_slab;
		} else if (this == NovaCraftBlocks.cobbled_nullstone_double_slab) {
			return NovaCraftBlocks.cobbled_nullstone_slab;
		} else if (this == NovaCraftBlocks.nullstone_double_slab) {
			return NovaCraftBlocks.nullstone_slab;
		} else if (this == NovaCraftBlocks.grimstone_tiled_double_slab) {
			return NovaCraftBlocks.grimstone_tiled_slab;
		} else if (this == NovaCraftBlocks.grimstone_brick_double_slab) {
			return NovaCraftBlocks.grimstone_brick_slab;
		} else if (this == NovaCraftBlocks.etherstone_double_slab) {
			return NovaCraftBlocks.etherstone_slab;
		} else if (this == NovaCraftBlocks.cobbled_etherstone_double_slab) {
			return NovaCraftBlocks.cobbled_etherstone_slab;
		} else if (this == NovaCraftBlocks.etherstone_brick_double_slab) {
			return NovaCraftBlocks.etherstone_brick_slab;
		} else if (this == NovaCraftBlocks.etherstone_tiled_double_slab) {
			return NovaCraftBlocks.etherstone_tiled_slab;
		} else if (this == NovaCraftBlocks.frontierslate_double_slab) {
			return NovaCraftBlocks.frontierslate_slab;
		} else if (this == NovaCraftBlocks.frontierslate_brick_double_slab) {
			return NovaCraftBlocks.frontierslate_brick_slab;
		} else if (this == NovaCraftBlocks.nullstone_brick_double_slab) {
			return NovaCraftBlocks.nullstone_brick_slab;
		} else if (this == NovaCraftBlocks.nullstone_tiled_double_slab) {
			return NovaCraftBlocks.nullstone_tiled_slab;
		} else if (this == NovaCraftBlocks.sculk_tiled_double_slab) {
			return NovaCraftBlocks.sculk_tiled_slab;
		} else if (this == NovaCraftBlocks.sculk_brick_double_slab) {
			return NovaCraftBlocks.sculk_brick_slab;
		} else if (this == NovaCraftBlocks.nullwart_brick_double_slab) {
			return NovaCraftBlocks.nullwart_brick_slab;
		} else if (this == NovaCraftBlocks.tuff_brick_double_slab) {
			return NovaCraftBlocks.tuff_brick_slab;
		} else if (this == NovaCraftBlocks.tuff_tiled_double_slab) {
			return NovaCraftBlocks.tuff_tiled_slab;
		} else if (this == NovaCraftBlocks.lacuna_double_slab) {
			return NovaCraftBlocks.lacuna_slab;
		} else if (this == NovaCraftBlocks.luminant_double_slab) {
			return NovaCraftBlocks.luminant_slab;
		} else if (this == NovaCraftBlocks.vanite_brick_double_slab) {
			return NovaCraftBlocks.vanite_brick_slab;
		} else if (this == NovaCraftBlocks.carved_vanite_brick_double_slab) {
			return NovaCraftBlocks.carved_vanite_brick_slab;
		}
		else {
			return this;
		}
	}

	@Override
	public Item getItemDropped(int meta, Random rand, int fortune) {
		return Item.getItemFromBlock(this.getDroppedSlab());
	}

	@Override
	public int damageDropped(int meta) {
		return 0;
	}

	@Override
	public String func_150002_b(int meta) {
		return this.name;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getRenderBlockPass() {
		return 0;
	}
}

