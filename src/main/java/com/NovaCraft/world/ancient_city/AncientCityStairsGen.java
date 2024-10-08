package com.NovaCraft.world.ancient_city;

import net.minecraft.world.gen.feature.*;
import net.minecraft.block.*;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.world.*;
import java.util.*;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.registry.OtherModBlocks;
import com.NovaCraft.registry.OtherModItems;
import com.NovaCraftBlocks.NovaCraftBlocks;

import cpw.mods.fml.common.Loader;
import net.minecraft.init.*;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.MathHelper;

public class AncientCityStairsGen extends WorldGenerator
{
	public AncientCityStairsGen() {

	}
	
	private static final Block cobbled_deepslate = OtherModBlocks.cobbled_deepslate;
	private static final Block deepslate = OtherModBlocks.deepslate;
	private static final Block sculk_block = NovaCraftBlocks.sculk_block;
	private static final Block soul_lantern = OtherModBlocks.soul_lantern; //1
	private static final Block soul_sand = Blocks.netherrack;
	
	private static final Block polished_deepslate = OtherModBlocks.polished_deepslate;
	private static final Block deepslate_brick_slab = OtherModBlocks.deepslate_brick_slab;
	private static final Block deepslate_tile_stairs = OtherModBlocks.deepslate_tile_stairs;
	private static final Block deepslate_brick_stairs = OtherModBlocks.deepslate_brick_stairs;
	private static final Block polished_deepslate_stairs = OtherModBlocks.polished_deepslate_stairs;
	private static final Block deepslate_wall = OtherModBlocks.deepslate_wall;
	private static final Block deepslate_brick_wall = OtherModBlocks.deepslate_brick_wall;
	private static final Block fence_dark_oak = OtherModBlocks.fence_dark_oak;
	private static final Block blue_ice = OtherModBlocks.blue_ice;
	private static final Block iron_trapdoor = OtherModBlocks.iron_trapdoor;
	
	private static final Block deepslate_bricks = OtherModBlocks.deepslate_bricks;
	private static final Block cobbled_deepslate_stairs = OtherModBlocks.cobbled_deepslate_stairs;
	
	private static final Block basalt = OtherModBlocks.Basalt; //netherlicious
	private static final Block basalt1 = OtherModBlocks.basalt; //et futurum requiem
	
	//0 -> deepslate bricks
	//1 -> cracked deepslate bricks
	//2 -> deepslate tiles
	//3 -> cracked deepslate bricks
	//4 -> chiseled deepslate bricks
	
	 public boolean generate(final World world, final Random random, final int i, final int j, final int k) {
		 
			world.setBlock(i + 1, j + 0, k + 5, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 1, j + 0, k + 6, NovaCraftBlocks.nullstone_tiled_stairs, 3, 2);
			world.setBlock(i + 1, j + 0, k + 15, NovaCraftBlocks.nullstone_tiled_stairs, 2, 2);
			world.setBlock(i + 1, j + 0, k + 16, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 1, j + 1, k + 4, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 1, j + 1, k + 5, NovaCraftBlocks.nullstone_tiled_stairs, 3, 2);
			world.setBlock(i + 1, j + 1, k + 16, NovaCraftBlocks.nullstone_tiled_stairs, 2, 2);
			world.setBlock(i + 1, j + 1, k + 17, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 1, j + 2, k + 3, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 1, j + 2, k + 4, NovaCraftBlocks.nullstone_tiled_stairs, 3, 2);
			world.setBlock(i + 1, j + 2, k + 17, NovaCraftBlocks.nullstone_tiled_stairs, 2, 2);
			world.setBlock(i + 1, j + 2, k + 18, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 1, j + 3, k + 1, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 1, j + 3, k + 2, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 1, j + 3, k + 3, NovaCraftBlocks.nullstone_tiled_stairs, 3, 2);
			world.setBlock(i + 1, j + 3, k + 18, NovaCraftBlocks.nullstone_tiled_stairs, 2, 2);
			world.setBlock(i + 1, j + 3, k + 19, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 1, j + 3, k + 20, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 1, j + 4, k + 0, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 1, j + 4, k + 1, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 1, j + 4, k + 2, NovaCraftBlocks.nullstone_tiled_stairs, 3, 2);
			world.setBlock(i + 1, j + 4, k + 19, NovaCraftBlocks.nullstone_tiled_stairs, 2, 2);
			world.setBlock(i + 1, j + 4, k + 20, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 1, j + 4, k + 21, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 1, j + 5, k + 0, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 1, j + 5, k + 1, NovaCraftBlocks.nullstone_tiled_stairs, 3, 2);
			world.setBlock(i + 1, j + 5, k + 20, NovaCraftBlocks.nullstone_tiled_stairs, 2, 2);
			world.setBlock(i + 1, j + 5, k + 21, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 1, j + 6, k + 0, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 0, j + 6, k + 1, NovaCraftBlocks.nullstone_tiled_stairs, 1, 2);
			world.setBlock(i + 0, j + 6, k + 20, NovaCraftBlocks.nullstone_tiled_stairs, 1, 2);
			world.setBlock(i + 1, j + 6, k + 21, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 1, j + 7, k + 0, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 1, j + 7, k + 21, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 1, j + 8, k + 0, NovaCraftBlocks.dim_vanite_torch, 5, 2);
			world.setBlock(i + 1, j + 8, k + 21, NovaCraftBlocks.dim_vanite_torch, 5, 2);
		 
			return true;
	 }

}
