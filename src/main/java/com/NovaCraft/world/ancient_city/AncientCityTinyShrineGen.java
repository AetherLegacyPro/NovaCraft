package com.NovaCraft.world.ancient_city;

import net.minecraft.world.gen.feature.*;
import net.minecraft.block.*;
import net.minecraft.world.*;
import java.util.*;

import com.NovaCraft.registry.OtherModBlocks;
import com.NovaCraftBlocks.NovaCraftBlocks;

import cpw.mods.fml.common.Loader;
import net.minecraft.init.*;

public class AncientCityTinyShrineGen extends WorldGenerator
{
	public AncientCityTinyShrineGen() {

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
	
	private static final Block smooth_basalt = OtherModBlocks.BasaltBricks; //netherlicious 6
	private static final Block smooth_basalt1 = OtherModBlocks.smooth_basalt; //et futurum requiem

	//0 -> deepslate bricks
	//1 -> cracked deepslate bricks
	//2 -> deepslate tiles
	//3 -> cracked deepslate bricks
	//4 -> chiseled deepslate bricks
    
    public boolean generate(final World world, final Random random, final int i, final int j, final int k) {
    	
    	world.setBlock(i + 0, j + 0, k + 0, polished_deepslate, 0, 2);
		world.setBlock(i + 1, j + 0, k + 0, polished_deepslate, 0, 2);
		world.setBlock(i + 2, j + 0, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 0, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 0, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 0, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 0, k + 0, polished_deepslate, 0, 2);
		world.setBlock(i + 7, j + 0, k + 0, polished_deepslate, 0, 2);
		world.setBlock(i + 0, j + 0, k + 1, polished_deepslate, 0, 2);
		world.setBlock(i + 1, j + 0, k + 1, deepslate, 0, 2);
		world.setBlock(i + 2, j + 0, k + 1, deepslate, 0, 2);
		world.setBlock(i + 3, j + 0, k + 1, polished_deepslate, 0, 2);
		world.setBlock(i + 4, j + 0, k + 1, polished_deepslate, 0, 2);
		world.setBlock(i + 5, j + 0, k + 1, deepslate, 0, 2);
		world.setBlock(i + 6, j + 0, k + 1, deepslate, 0, 2);
		world.setBlock(i + 7, j + 0, k + 1, polished_deepslate, 0, 2);
		world.setBlock(i + 0, j + 0, k + 2, polished_deepslate, 0, 2);
		world.setBlock(i + 1, j + 0, k + 2, deepslate, 0, 2);
		world.setBlock(i + 2, j + 0, k + 2, cobbled_deepslate, 0, 2);
		world.setBlock(i + 3, j + 0, k + 2, cobbled_deepslate, 0, 2);
		world.setBlock(i + 4, j + 0, k + 2, cobbled_deepslate, 0, 2);
		world.setBlock(i + 5, j + 0, k + 2, cobbled_deepslate, 0, 2);
		world.setBlock(i + 6, j + 0, k + 2, deepslate, 0, 2);
		world.setBlock(i + 7, j + 0, k + 2, polished_deepslate, 0, 2);
		world.setBlock(i + 0, j + 0, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 0, k + 3, deepslate, 0, 2);
		world.setBlock(i + 2, j + 0, k + 3, cobbled_deepslate, 0, 2);
		world.setBlock(i + 3, j + 0, k + 3, cobbled_deepslate, 0, 2);
		world.setBlock(i + 4, j + 0, k + 3, cobbled_deepslate, 0, 2);
		world.setBlock(i + 5, j + 0, k + 3, cobbled_deepslate, 0, 2);
		world.setBlock(i + 6, j + 0, k + 3, deepslate, 0, 2);
		world.setBlock(i + 7, j + 0, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 0, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 0, k + 4, deepslate, 0, 2);
		world.setBlock(i + 2, j + 0, k + 4, cobbled_deepslate, 0, 2);
		world.setBlock(i + 3, j + 0, k + 4, cobbled_deepslate, 0, 2);
		world.setBlock(i + 4, j + 0, k + 4, cobbled_deepslate, 0, 2);
		world.setBlock(i + 5, j + 0, k + 4, cobbled_deepslate, 0, 2);
		world.setBlock(i + 6, j + 0, k + 4, deepslate, 0, 2);
		world.setBlock(i + 7, j + 0, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 0, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 0, k + 5, deepslate, 0, 2);
		world.setBlock(i + 2, j + 0, k + 5, cobbled_deepslate, 0, 2);
		world.setBlock(i + 3, j + 0, k + 5, cobbled_deepslate, 0, 2);
		world.setBlock(i + 4, j + 0, k + 5, cobbled_deepslate, 0, 2);
		world.setBlock(i + 5, j + 0, k + 5, cobbled_deepslate, 0, 2);
		world.setBlock(i + 6, j + 0, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 0, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 0, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 0, k + 6, deepslate, 0, 2);
		world.setBlock(i + 2, j + 0, k + 6, cobbled_deepslate, 0, 2);
		world.setBlock(i + 3, j + 0, k + 6, cobbled_deepslate, 0, 2);
		world.setBlock(i + 4, j + 0, k + 6, cobbled_deepslate, 0, 2);
		world.setBlock(i + 5, j + 0, k + 6, cobbled_deepslate, 0, 2);
		world.setBlock(i + 6, j + 0, k + 6, deepslate, 0, 2);
		world.setBlock(i + 7, j + 0, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 0, k + 7, polished_deepslate, 0, 2);
		world.setBlock(i + 1, j + 0, k + 7, deepslate, 0, 2);
		world.setBlock(i + 2, j + 0, k + 7, deepslate, 0, 2);
		world.setBlock(i + 3, j + 0, k + 7, deepslate, 0, 2);
		world.setBlock(i + 4, j + 0, k + 7, deepslate, 0, 2);
		world.setBlock(i + 5, j + 0, k + 7, deepslate, 0, 2);
		world.setBlock(i + 6, j + 0, k + 7, deepslate, 0, 2);
		world.setBlock(i + 7, j + 0, k + 7, polished_deepslate, 0, 2);
		world.setBlock(i + 0, j + 0, k + 8, polished_deepslate, 0, 2);
		world.setBlock(i + 1, j + 0, k + 8, deepslate, 0, 2);
		world.setBlock(i + 2, j + 0, k + 8, deepslate, 0, 2);
		world.setBlock(i + 3, j + 0, k + 8, polished_deepslate, 0, 2);
		world.setBlock(i + 4, j + 0, k + 8, polished_deepslate, 0, 2);
		world.setBlock(i + 5, j + 0, k + 8, deepslate, 0, 2);
		world.setBlock(i + 6, j + 0, k + 8, deepslate, 0, 2);
		world.setBlock(i + 7, j + 0, k + 8, polished_deepslate, 0, 2);
		world.setBlock(i + 0, j + 0, k + 9, polished_deepslate, 0, 2);
		world.setBlock(i + 1, j + 0, k + 9, polished_deepslate, 0, 2);
		world.setBlock(i + 2, j + 0, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 0, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 0, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 0, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 0, k + 9, polished_deepslate, 0, 2);
		world.setBlock(i + 7, j + 0, k + 9, polished_deepslate, 0, 2);
		world.setBlock(i + 0, j + 1, k + 0, polished_deepslate, 0, 2);
		world.setBlock(i + 1, j + 1, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 1, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 1, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 1, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 1, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 1, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 1, k + 0, polished_deepslate, 0, 2);
		world.setBlock(i + 0, j + 1, k + 1, polished_deepslate, 0, 2);
		world.setBlock(i + 1, j + 1, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 1, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 1, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 1, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 1, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 1, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 1, k + 1, polished_deepslate, 0, 2);
		world.setBlock(i + 0, j + 1, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 1, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 1, k + 2, polished_deepslate, 0, 2);
		world.setBlock(i + 3, j + 1, k + 2, deepslate, 0, 2);
		world.setBlock(i + 4, j + 1, k + 2, deepslate, 0, 2);
		world.setBlock(i + 5, j + 1, k + 2, polished_deepslate, 0, 2);
		world.setBlock(i + 6, j + 1, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 1, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 1, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 1, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 1, k + 3, polished_deepslate, 0, 2);
		world.setBlock(i + 3, j + 1, k + 3, cobbled_deepslate, 0, 2);
		world.setBlock(i + 4, j + 1, k + 3, cobbled_deepslate, 0, 2);
		world.setBlock(i + 5, j + 1, k + 3, polished_deepslate, 0, 2);
		world.setBlock(i + 6, j + 1, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 1, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 1, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 1, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 1, k + 4, polished_deepslate, 0, 2);
		world.setBlock(i + 3, j + 1, k + 4, deepslate, 0, 2);
		world.setBlock(i + 4, j + 1, k + 4, deepslate, 0, 2);
		world.setBlock(i + 5, j + 1, k + 4, polished_deepslate, 0, 2);
		world.setBlock(i + 6, j + 1, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 1, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 1, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 1, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 1, k + 5, polished_deepslate, 0, 2);
		world.setBlock(i + 3, j + 1, k + 5, deepslate, 0, 2);
		world.setBlock(i + 4, j + 1, k + 5, deepslate, 0, 2);
		world.setBlock(i + 5, j + 1, k + 5, polished_deepslate, 0, 2);
		world.setBlock(i + 6, j + 1, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 1, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 1, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 1, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 1, k + 6, polished_deepslate, 0, 2);
		world.setBlock(i + 3, j + 1, k + 6, deepslate, 0, 2);
		world.setBlock(i + 4, j + 1, k + 6, deepslate, 0, 2);
		world.setBlock(i + 5, j + 1, k + 6, polished_deepslate, 0, 2);
		world.setBlock(i + 6, j + 1, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 1, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 1, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 1, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 1, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 1, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 1, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 1, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 1, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 1, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 1, k + 8, polished_deepslate, 0, 2);
		world.setBlock(i + 1, j + 1, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 1, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 1, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 1, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 1, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 1, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 1, k + 8, polished_deepslate, 0, 2);
		world.setBlock(i + 0, j + 1, k + 9, polished_deepslate, 0, 2);
		world.setBlock(i + 1, j + 1, k + 9, polished_deepslate, 0, 2);
		world.setBlock(i + 2, j + 1, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 1, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 1, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 1, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 1, k + 9, polished_deepslate, 0, 2);
		world.setBlock(i + 7, j + 1, k + 9, polished_deepslate, 0, 2);
		world.setBlock(i + 0, j + 2, k + 0, polished_deepslate, 0, 2);
		world.setBlock(i + 1, j + 2, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 2, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 2, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 2, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 2, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 2, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 2, k + 0, polished_deepslate, 0, 2);
		world.setBlock(i + 0, j + 2, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 2, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 2, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 2, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 2, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 2, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 2, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 2, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 2, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 2, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 2, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 2, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 2, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 2, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 2, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 2, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 2, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 2, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 2, k + 3, deepslate_bricks, 3, 2);
		world.setBlock(i + 3, j + 2, k + 3, deepslate_brick_slab, 1, 2);
		world.setBlock(i + 4, j + 2, k + 3, deepslate_brick_slab, 1, 2);
		world.setBlock(i + 5, j + 2, k + 3, deepslate_bricks, 3, 2);
		world.setBlock(i + 6, j + 2, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 2, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 2, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 2, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 2, k + 4, NovaCraftBlocks.dim_vanite_torch, 5, 2);
		world.setBlock(i + 3, j + 2, k + 4, NovaCraftBlocks.dim_vanite_torch, 5, 2);
		world.setBlock(i + 4, j + 2, k + 4, NovaCraftBlocks.dim_vanite_torch, 5, 2);
		world.setBlock(i + 5, j + 2, k + 4, NovaCraftBlocks.dim_vanite_torch, 5, 2);
		world.setBlock(i + 6, j + 2, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 2, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 2, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 2, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 2, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 2, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 2, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 2, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 2, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 2, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 2, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 2, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 2, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 2, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 2, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 2, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 2, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 2, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 2, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 2, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 2, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 2, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 2, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 2, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 2, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 2, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 2, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 2, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 2, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 2, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 2, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 2, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 2, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 2, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 2, k + 9, polished_deepslate, 0, 2);
		world.setBlock(i + 1, j + 2, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 2, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 2, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 2, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 2, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 2, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 2, k + 9, polished_deepslate, 0, 2);
		world.setBlock(i + 0, j + 3, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 3, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 3, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 3, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 3, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 3, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 3, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 3, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 3, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 3, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 3, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 3, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 3, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 3, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 3, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 3, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 3, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 3, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 3, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 3, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 3, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 3, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 3, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 3, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 3, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 3, k + 3, deepslate_brick_wall, 1, 2);
		world.setBlock(i + 2, j + 3, k + 3, deepslate_bricks, 0, 2);
		world.setBlock(i + 3, j + 3, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 3, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 3, k + 3, deepslate_bricks, 0, 2);
		world.setBlock(i + 6, j + 3, k + 3, deepslate_brick_wall, 1, 2);
		world.setBlock(i + 7, j + 3, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 3, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 3, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 3, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 3, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 3, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 3, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 3, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 3, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 3, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 3, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 3, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 3, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 3, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 3, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 3, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 3, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 3, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 3, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 3, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 3, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 3, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 3, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 3, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 3, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 3, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 3, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 3, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 3, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 3, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 3, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 3, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 3, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 3, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 3, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 3, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 3, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 3, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 3, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 3, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 3, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 3, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 3, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 3, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 3, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 3, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 3, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 3, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 3, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 4, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 4, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 4, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 4, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 4, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 4, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 4, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 4, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 4, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 4, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 4, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 4, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 4, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 4, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 4, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 4, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 4, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 4, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 4, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 4, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 4, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 4, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 4, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 4, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 4, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 4, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 4, k + 3, deepslate_brick_slab, 0, 2);
		world.setBlock(i + 3, j + 4, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 4, k + 3, deepslate_brick_slab, 0, 2);
		world.setBlock(i + 5, j + 4, k + 3, deepslate_brick_slab, 0, 2);
		world.setBlock(i + 6, j + 4, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 4, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 4, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 4, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 4, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 4, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 4, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 4, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 4, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 4, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 4, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 4, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 4, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 4, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 4, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 4, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 4, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 4, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 4, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 4, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 4, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 4, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 4, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 4, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 4, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 4, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 4, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 4, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 4, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 4, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 4, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 4, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 4, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 4, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 4, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 4, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 4, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 4, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 4, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 4, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 4, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 4, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 4, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 4, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 4, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 4, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 4, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 4, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 4, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 4, k + 9, Blocks.air, 0, 2);
    	
    	return true;
    }

}
