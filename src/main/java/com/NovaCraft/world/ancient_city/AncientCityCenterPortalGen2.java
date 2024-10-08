package com.NovaCraft.world.ancient_city;

import net.minecraft.world.gen.feature.*;
import net.minecraft.block.*;
import net.minecraft.world.*;
import java.util.*;

import com.NovaCraft.registry.OtherModBlocks;
import com.NovaCraftBlocks.NovaCraftBlocks;

import net.minecraft.init.*;

public class AncientCityCenterPortalGen2 extends WorldGenerator
{
	public AncientCityCenterPortalGen2() {

	}
	
	private static final Block cobbled_deepslate = OtherModBlocks.cobbled_deepslate;
	private static final Block deepslate = OtherModBlocks.deepslate;
	private static final Block sculk_block = NovaCraftBlocks.sculk_block;
	private static final Block soul_lantern = Blocks.glowstone; //1
	private static final Block soul_sand = Blocks.netherrack;
	private static final Block SoulFire = OtherModBlocks.SoulFire;
	
	private static final Block polished_deepslate = OtherModBlocks.polished_deepslate;
	private static final Block deepslate_brick_slab = OtherModBlocks.deepslate_brick_slab;
	private static final Block deepslate_tile_stairs = OtherModBlocks.deepslate_tile_stairs;
	private static final Block deepslate_brick_stairs = OtherModBlocks.deepslate_brick_stairs;
	private static final Block polished_deepslate_stairs = OtherModBlocks.polished_deepslate_stairs;
	private static final Block deepslate_wall = OtherModBlocks.deepslate_wall;
	private static final Block fence_dark_oak = OtherModBlocks.fence_dark_oak;
	
	private static final Block deepslate_bricks = OtherModBlocks.deepslate_bricks;
	
	//0 -> deepslate bricks
	//1 -> cracked deepslate bricks
	//2 -> deepslate tiles
	//3 -> cracked deepslate bricks
	//4 -> chiseled deepslate bricks

	public boolean generate(final World world, final Random random, final int i, final int j, final int k) {
		
		world.setBlock(i + 16, j + 16, k + 18, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 16, k + 18, deepslate_bricks, 1, 2);
		world.setBlock(i + 18, j + 16, k + 18, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 16, k + 18, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 16, k + 19, deepslate_bricks, 1, 2);
		world.setBlock(i + 17, j + 16, k + 19, deepslate_bricks, 1, 2);
		world.setBlock(i + 18, j + 16, k + 19, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 16, k + 19, deepslate_bricks, 0, 2);
		world.setBlock(i + 20, j + 16, k + 19, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 16, k + 20, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 16, k + 20, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 16, k + 20, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 16, k + 20, deepslate_bricks, 0, 2);
		world.setBlock(i + 20, j + 16, k + 20, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 16, k + 21, deepslate_bricks, 1, 2);
		world.setBlock(i + 17, j + 16, k + 21, deepslate_bricks, 1, 2);
		world.setBlock(i + 18, j + 16, k + 21, deepslate_bricks, 1, 2);
		world.setBlock(i + 19, j + 16, k + 21, deepslate_bricks, 0, 2);
		world.setBlock(i + 20, j + 16, k + 21, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 16, k + 22, deepslate_bricks, 2, 2);
		world.setBlock(i + 17, j + 16, k + 22, deepslate_bricks, 2, 2);
		world.setBlock(i + 18, j + 16, k + 22, deepslate_bricks, 2, 2);
		world.setBlock(i + 19, j + 16, k + 22, deepslate_bricks, 2, 2);
		world.setBlock(i + 20, j + 16, k + 22, deepslate_bricks, 3, 2);
		world.setBlock(i + 16, j + 16, k + 23, deepslate_bricks, 2, 2);
		world.setBlock(i + 17, j + 16, k + 23, deepslate_bricks, 2, 2);
		world.setBlock(i + 18, j + 16, k + 23, deepslate_bricks, 3, 2);
		world.setBlock(i + 19, j + 16, k + 23, deepslate_bricks, 3, 2);
		world.setBlock(i + 20, j + 16, k + 23, deepslate_bricks, 3, 2);
		world.setBlock(i + 17, j + 16, k + 24, deepslate_bricks, 3, 2);
		world.setBlock(i + 18, j + 16, k + 24, deepslate_bricks, 3, 2);
		world.setBlock(i + 19, j + 16, k + 24, deepslate_bricks, 2, 2);
		world.setBlock(i + 16, j + 16, k + 25, deepslate_bricks, 2, 2);
		world.setBlock(i + 17, j + 16, k + 25, deepslate_bricks, 2, 2);
		world.setBlock(i + 18, j + 16, k + 25, deepslate_bricks, 3, 2);
		world.setBlock(i + 19, j + 16, k + 25, deepslate_bricks, 2, 2);
		world.setBlock(i + 20, j + 16, k + 25, deepslate_bricks, 2, 2);
		world.setBlock(i + 16, j + 16, k + 26, deepslate_bricks, 3, 2);
		world.setBlock(i + 17, j + 16, k + 26, deepslate_bricks, 3, 2);
		world.setBlock(i + 18, j + 16, k + 26, deepslate_bricks, 3, 2);
		world.setBlock(i + 19, j + 16, k + 26, deepslate_bricks, 2, 2);
		world.setBlock(i + 20, j + 16, k + 26, deepslate_bricks, 2, 2);
		world.setBlock(i + 17, j + 16, k + 27, deepslate_bricks, 2, 2);
		world.setBlock(i + 18, j + 16, k + 27, deepslate_bricks, 3, 2);
		world.setBlock(i + 19, j + 16, k + 27, deepslate_bricks, 2, 2);
		world.setBlock(i + 17, j + 16, k + 28, deepslate_bricks, 3, 2);
		world.setBlock(i + 18, j + 16, k + 28, deepslate_bricks, 2, 2);
		world.setBlock(i + 19, j + 16, k + 28, deepslate_bricks, 2, 2);
		world.setBlock(i + 16, j + 16, k + 29, deepslate_bricks, 3, 2);
		world.setBlock(i + 17, j + 16, k + 29, deepslate_bricks, 3, 2);
		world.setBlock(i + 18, j + 16, k + 29, deepslate_bricks, 2, 2);
		world.setBlock(i + 19, j + 16, k + 29, deepslate_bricks, 2, 2);
		world.setBlock(i + 20, j + 16, k + 29, deepslate_bricks, 3, 2);
		world.setBlock(i + 16, j + 16, k + 30, deepslate_bricks, 2, 2);
		world.setBlock(i + 17, j + 16, k + 30, deepslate_bricks, 2, 2);
		world.setBlock(i + 18, j + 16, k + 30, deepslate_bricks, 2, 2);
		world.setBlock(i + 19, j + 16, k + 30, deepslate_bricks, 2, 2);
		world.setBlock(i + 20, j + 16, k + 30, deepslate_bricks, 2, 2);
		world.setBlock(i + 17, j + 16, k + 31, deepslate_bricks, 3, 2);
		world.setBlock(i + 18, j + 16, k + 31, deepslate_bricks, 2, 2);
		world.setBlock(i + 19, j + 16, k + 31, deepslate_bricks, 2, 2);
		world.setBlock(i + 17, j + 16, k + 32, deepslate_bricks, 3, 2);
		world.setBlock(i + 18, j + 16, k + 32, deepslate_bricks, 2, 2);
		world.setBlock(i + 19, j + 16, k + 32, deepslate_bricks, 3, 2);
		world.setBlock(i + 16, j + 16, k + 33, deepslate_bricks, 2, 2);
		world.setBlock(i + 17, j + 16, k + 33, deepslate_bricks, 3, 2);
		world.setBlock(i + 18, j + 16, k + 33, deepslate_bricks, 2, 2);
		world.setBlock(i + 19, j + 16, k + 33, deepslate_bricks, 2, 2);
		world.setBlock(i + 20, j + 16, k + 33, deepslate_bricks, 2, 2);
		world.setBlock(i + 16, j + 16, k + 34, deepslate_bricks, 2, 2);
		world.setBlock(i + 17, j + 16, k + 34, deepslate_bricks, 2, 2);
		world.setBlock(i + 18, j + 16, k + 34, deepslate_bricks, 2, 2);
		world.setBlock(i + 19, j + 16, k + 34, deepslate_bricks, 3, 2);
		world.setBlock(i + 20, j + 16, k + 34, deepslate_bricks, 2, 2);
		world.setBlock(i + 17, j + 16, k + 35, deepslate_bricks, 2, 2);
		world.setBlock(i + 18, j + 16, k + 35, deepslate_bricks, 3, 2);
		world.setBlock(i + 19, j + 16, k + 35, deepslate_bricks, 2, 2);
		world.setBlock(i + 17, j + 16, k + 36, deepslate_bricks, 3, 2);
		world.setBlock(i + 18, j + 16, k + 36, deepslate_bricks, 2, 2);
		world.setBlock(i + 19, j + 16, k + 36, deepslate_bricks, 3, 2);
		world.setBlock(i + 16, j + 16, k + 37, deepslate_bricks, 3, 2);
		world.setBlock(i + 17, j + 16, k + 37, deepslate_bricks, 2, 2);
		world.setBlock(i + 18, j + 16, k + 37, deepslate_bricks, 2, 2);
		world.setBlock(i + 19, j + 16, k + 37, deepslate_bricks, 2, 2);
		world.setBlock(i + 20, j + 16, k + 37, deepslate_bricks, 2, 2);
		world.setBlock(i + 16, j + 16, k + 38, deepslate_bricks, 2, 2);
		world.setBlock(i + 17, j + 16, k + 38, deepslate_bricks, 2, 2);
		world.setBlock(i + 18, j + 16, k + 38, deepslate_bricks, 2, 2);
		world.setBlock(i + 19, j + 16, k + 38, deepslate_bricks, 2, 2);
		world.setBlock(i + 20, j + 16, k + 38, deepslate_bricks, 2, 2);
		world.setBlock(i + 17, j + 16, k + 39, deepslate_bricks, 2, 2);
		world.setBlock(i + 18, j + 16, k + 39, deepslate_bricks, 3, 2);
		world.setBlock(i + 17, j + 16, k + 40, deepslate_bricks, 2, 2);
		world.setBlock(i + 18, j + 16, k + 40, deepslate_bricks, 2, 2);
		world.setBlock(i + 19, j + 16, k + 40, deepslate_bricks, 3, 2);
		world.setBlock(i + 16, j + 16, k + 41, deepslate_bricks, 2, 2);
		world.setBlock(i + 17, j + 16, k + 41, deepslate_bricks, 3, 2);
		world.setBlock(i + 18, j + 16, k + 41, cobbled_deepslate, 0, 2);
		world.setBlock(i + 19, j + 16, k + 41, cobbled_deepslate, 0, 2);
		world.setBlock(i + 20, j + 16, k + 41, deepslate_bricks, 2, 2);
		world.setBlock(i + 16, j + 16, k + 42, deepslate_bricks, 3, 2);
		world.setBlock(i + 17, j + 16, k + 42, cobbled_deepslate, 0, 2);
		world.setBlock(i + 18, j + 16, k + 42, cobbled_deepslate, 0, 2);
		world.setBlock(i + 19, j + 16, k + 42, cobbled_deepslate, 0, 2);
		world.setBlock(i + 20, j + 16, k + 42, deepslate_bricks, 2, 2);
		world.setBlock(i + 17, j + 16, k + 43, cobbled_deepslate, 0, 2);
		world.setBlock(i + 18, j + 16, k + 43, deepslate_bricks, 2, 2);
		world.setBlock(i + 19, j + 16, k + 43, cobbled_deepslate, 0, 2);
		world.setBlock(i + 16, j + 16, k + 44, deepslate_bricks, 2, 2);
		world.setBlock(i + 17, j + 16, k + 44, cobbled_deepslate, 0, 2);
		world.setBlock(i + 18, j + 16, k + 44, cobbled_deepslate, 0, 2);
		world.setBlock(i + 19, j + 16, k + 44, cobbled_deepslate, 0, 2);
		world.setBlock(i + 20, j + 16, k + 44, deepslate_bricks, 3, 2);
		world.setBlock(i + 16, j + 16, k + 45, deepslate_bricks, 3, 2);
		world.setBlock(i + 17, j + 16, k + 45, cobbled_deepslate, 0, 2);
		world.setBlock(i + 18, j + 16, k + 45, cobbled_deepslate, 0, 2);
		world.setBlock(i + 19, j + 16, k + 45, cobbled_deepslate, 0, 2);
		world.setBlock(i + 20, j + 16, k + 45, deepslate_bricks, 3, 2);
		world.setBlock(i + 17, j + 16, k + 46, cobbled_deepslate, 0, 2);
		world.setBlock(i + 18, j + 16, k + 46, cobbled_deepslate, 0, 2);
		world.setBlock(i + 19, j + 16, k + 46, cobbled_deepslate, 0, 2);
		world.setBlock(i + 16, j + 16, k + 47, cobbled_deepslate, 0, 2);
		world.setBlock(i + 17, j + 16, k + 47, cobbled_deepslate, 0, 2);
		world.setBlock(i + 18, j + 16, k + 47, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 16, k + 47, deepslate_bricks, 1, 2);
		world.setBlock(i + 20, j + 16, k + 47, deepslate_bricks, 1, 2);
		world.setBlock(i + 16, j + 16, k + 48, deepslate_bricks, 1, 2);
		world.setBlock(i + 17, j + 16, k + 48, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 16, k + 48, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 16, k + 48, deepslate_bricks, 0, 2);
		world.setBlock(i + 20, j + 16, k + 48, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 16, k + 49, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 16, k + 49, deepslate_bricks, 1, 2);
		world.setBlock(i + 20, j + 16, k + 49, deepslate_bricks, 1, 2);
		world.setBlock(i + 16, j + 17, k + 18, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 17, k + 18, deepslate_bricks, 1, 2);
		world.setBlock(i + 18, j + 17, k + 18, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 17, k + 18, deepslate_bricks, 1, 2);
		world.setBlock(i + 16, j + 17, k + 19, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 17, k + 19, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 17, k + 19, deepslate_bricks, 1, 2);
		world.setBlock(i + 19, j + 17, k + 19, deepslate_bricks, 0, 2);
		world.setBlock(i + 20, j + 17, k + 19, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 17, k + 20, deepslate_bricks, 1, 2);
		world.setBlock(i + 17, j + 17, k + 20, deepslate_bricks, 1, 2);
		world.setBlock(i + 18, j + 17, k + 20, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 17, k + 20, deepslate_bricks, 0, 2);
		world.setBlock(i + 20, j + 17, k + 20, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 17, k + 21, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 17, k + 21, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 17, k + 21, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 17, k + 21, deepslate_bricks, 1, 2);
		world.setBlock(i + 20, j + 17, k + 21, deepslate_bricks, 1, 2);
		world.setBlock(i + 16, j + 17, k + 22, deepslate_bricks, 3, 2);
		world.setBlock(i + 17, j + 17, k + 22, deepslate_bricks, 2, 2);
		world.setBlock(i + 18, j + 17, k + 22, deepslate_bricks, 2, 2);
		world.setBlock(i + 19, j + 17, k + 22, deepslate_bricks, 2, 2);
		world.setBlock(i + 20, j + 17, k + 22, deepslate_bricks, 2, 2);
		world.setBlock(i + 16, j + 17, k + 23, deepslate_bricks, 3, 2);
		world.setBlock(i + 18, j + 17, k + 23, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
		world.setBlock(i + 20, j + 17, k + 23, deepslate_bricks, 2, 2);
		world.setBlock(i + 18, j + 17, k + 24, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
		world.setBlock(i + 18, j + 17, k + 25, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
		world.setBlock(i + 18, j + 17, k + 26, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
		world.setBlock(i + 18, j + 17, k + 27, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
		world.setBlock(i + 18, j + 17, k + 28, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
		world.setBlock(i + 18, j + 17, k + 29, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
		world.setBlock(i + 18, j + 17, k + 30, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
		world.setBlock(i + 18, j + 17, k + 31, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
		world.setBlock(i + 18, j + 17, k + 32, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
		world.setBlock(i + 18, j + 17, k + 33, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
		world.setBlock(i + 18, j + 17, k + 34, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
		world.setBlock(i + 18, j + 17, k + 35, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
		world.setBlock(i + 18, j + 17, k + 36, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
		world.setBlock(i + 18, j + 17, k + 37, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
		world.setBlock(i + 18, j + 17, k + 38, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
		world.setBlock(i + 18, j + 17, k + 39, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
		world.setBlock(i + 18, j + 17, k + 40, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
		world.setBlock(i + 18, j + 17, k + 41, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
		world.setBlock(i + 18, j + 17, k + 42, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
		world.setBlock(i + 18, j + 17, k + 43, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
		world.setBlock(i + 16, j + 17, k + 44, deepslate_bricks, 3, 2);
		world.setBlock(i + 18, j + 17, k + 44, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
		world.setBlock(i + 20, j + 17, k + 44, deepslate_bricks, 3, 2);
		world.setBlock(i + 16, j + 17, k + 45, deepslate_bricks, 3, 2);
		world.setBlock(i + 17, j + 17, k + 45, deepslate_bricks, 3, 2);
		world.setBlock(i + 18, j + 17, k + 45, deepslate_bricks, 2, 2);
		world.setBlock(i + 19, j + 17, k + 45, deepslate_bricks, 2, 2);
		world.setBlock(i + 20, j + 17, k + 45, deepslate_bricks, 2, 2);
		world.setBlock(i + 16, j + 17, k + 46, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 17, k + 46, deepslate_bricks, 2, 2);
		world.setBlock(i + 18, j + 17, k + 46, deepslate_bricks, 3, 2);
		world.setBlock(i + 19, j + 17, k + 46, deepslate_bricks, 3, 2);
		world.setBlock(i + 20, j + 17, k + 46, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 17, k + 47, deepslate_bricks, 1, 2);
		world.setBlock(i + 17, j + 17, k + 47, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 17, k + 47, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 17, k + 47, deepslate_bricks, 0, 2);
		world.setBlock(i + 20, j + 17, k + 47, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 17, k + 48, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 17, k + 48, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 17, k + 48, deepslate_bricks, 1, 2);
		world.setBlock(i + 19, j + 17, k + 48, deepslate_bricks, 1, 2);
		world.setBlock(i + 20, j + 17, k + 48, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 17, k + 49, deepslate_bricks, 1, 2);
		world.setBlock(i + 17, j + 17, k + 49, deepslate_bricks, 1, 2);
		world.setBlock(i + 18, j + 17, k + 49, deepslate_bricks, 1, 2);
		world.setBlock(i + 19, j + 17, k + 49, deepslate_bricks, 1, 2);
		world.setBlock(i + 20, j + 17, k + 49, deepslate_bricks, 1, 2);
		world.setBlock(i + 16, j + 18, k + 18, deepslate_bricks, 1, 2);
		world.setBlock(i + 17, j + 18, k + 18, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 18, k + 18, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 18, k + 18, deepslate_bricks, 1, 2);
		world.setBlock(i + 20, j + 18, k + 18, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 18, k + 19, deepslate_bricks, 1, 2);
		world.setBlock(i + 17, j + 18, k + 19, deepslate_bricks, 1, 2);
		world.setBlock(i + 18, j + 18, k + 19, deepslate_bricks, 1, 2);
		world.setBlock(i + 19, j + 18, k + 19, deepslate_bricks, 0, 2);
		world.setBlock(i + 20, j + 18, k + 19, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 18, k + 20, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 18, k + 20, deepslate_bricks, 1, 2);
		world.setBlock(i + 18, j + 18, k + 20, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 18, k + 20, deepslate_bricks, 0, 2);
		world.setBlock(i + 20, j + 18, k + 20, deepslate_bricks, 1, 2);
		world.setBlock(i + 16, j + 18, k + 21, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 18, k + 21, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 18, k + 21, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 18, k + 21, deepslate_bricks, 0, 2);
		world.setBlock(i + 20, j + 18, k + 21, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 18, k + 22, deepslate_bricks, 2, 2);
		world.setBlock(i + 17, j + 18, k + 22, deepslate_bricks, 2, 2);
		world.setBlock(i + 18, j + 18, k + 22, deepslate_bricks, 3, 2);
		world.setBlock(i + 19, j + 18, k + 22, deepslate_bricks, 2, 2);
		world.setBlock(i + 20, j + 18, k + 22, deepslate_bricks, 2, 2);
		world.setBlock(i + 18, j + 18, k + 23, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
		world.setBlock(i + 18, j + 18, k + 44, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
		world.setBlock(i + 16, j + 18, k + 45, deepslate_bricks, 2, 2);
		world.setBlock(i + 17, j + 18, k + 45, deepslate_bricks, 2, 2);
		world.setBlock(i + 18, j + 18, k + 45, deepslate_bricks, 2, 2);
		world.setBlock(i + 19, j + 18, k + 45, deepslate_bricks, 2, 2);
		world.setBlock(i + 20, j + 18, k + 45, deepslate_bricks, 2, 2);
		world.setBlock(i + 16, j + 18, k + 46, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 18, k + 46, deepslate_bricks, 2, 2);
		world.setBlock(i + 18, j + 18, k + 46, deepslate_bricks, 3, 2);
		world.setBlock(i + 19, j + 18, k + 46, deepslate_bricks, 3, 2);
		world.setBlock(i + 20, j + 18, k + 46, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 18, k + 47, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 18, k + 47, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 18, k + 47, deepslate_bricks, 1, 2);
		world.setBlock(i + 19, j + 18, k + 47, deepslate_bricks, 0, 2);
		world.setBlock(i + 20, j + 18, k + 47, deepslate_bricks, 1, 2);
		world.setBlock(i + 16, j + 18, k + 48, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 18, k + 48, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 18, k + 48, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 18, k + 48, deepslate_bricks, 1, 2);
		world.setBlock(i + 20, j + 18, k + 48, deepslate_bricks, 1, 2);
		world.setBlock(i + 16, j + 18, k + 49, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 18, k + 49, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 18, k + 49, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 18, k + 49, cobbled_deepslate, 0, 2);
		world.setBlock(i + 20, j + 18, k + 49, cobbled_deepslate, 0, 2);


























































		world.setBlock(i + 16, j + 19, k + 18, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 19, k + 18, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 19, k + 18, cobbled_deepslate, 0, 2);
		world.setBlock(i + 19, j + 19, k + 18, cobbled_deepslate, 0, 2);
		world.setBlock(i + 20, j + 19, k + 18, cobbled_deepslate, 0, 2);
		world.setBlock(i + 16, j + 19, k + 19, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 19, k + 19, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 19, k + 19, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 19, k + 19, deepslate_bricks, 0, 2);
		world.setBlock(i + 20, j + 19, k + 19, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 19, k + 20, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 19, k + 20, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 19, k + 20, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 19, k + 20, deepslate_bricks, 0, 2);
		world.setBlock(i + 20, j + 19, k + 20, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 19, k + 21, deepslate_bricks, 2, 2);
		world.setBlock(i + 17, j + 19, k + 21, deepslate_bricks, 1, 2);
		world.setBlock(i + 18, j + 19, k + 21, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 19, k + 21, deepslate_bricks, 0, 2);
		world.setBlock(i + 20, j + 19, k + 21, deepslate_bricks, 2, 2);
		world.setBlock(i + 16, j + 19, k + 22, deepslate_bricks, 3, 2);
		world.setBlock(i + 17, j + 19, k + 22, deepslate_bricks, 2, 2);
		world.setBlock(i + 18, j + 19, k + 22, deepslate_bricks, 2, 2);
		world.setBlock(i + 19, j + 19, k + 22, deepslate_bricks, 2, 2);
		world.setBlock(i + 20, j + 19, k + 22, deepslate_bricks, 2, 2);
		world.setBlock(i + 18, j + 19, k + 23, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
		world.setBlock(i + 18, j + 19, k + 44, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
		world.setBlock(i + 16, j + 19, k + 45, deepslate_bricks, 2, 2);
		world.setBlock(i + 17, j + 19, k + 45, deepslate_bricks, 2, 2);
		world.setBlock(i + 18, j + 19, k + 45, deepslate_bricks, 3, 2);
		world.setBlock(i + 19, j + 19, k + 45, deepslate_bricks, 2, 2);
		world.setBlock(i + 20, j + 19, k + 45, deepslate_bricks, 2, 2);
		world.setBlock(i + 16, j + 19, k + 46, deepslate_bricks, 2, 2);
		world.setBlock(i + 17, j + 19, k + 46, deepslate_bricks, 2, 2);
		world.setBlock(i + 18, j + 19, k + 46, deepslate_bricks, 3, 2);
		world.setBlock(i + 19, j + 19, k + 46, deepslate_bricks, 2, 2);
		world.setBlock(i + 20, j + 19, k + 46, deepslate_bricks, 3, 2);
		world.setBlock(i + 16, j + 19, k + 47, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 19, k + 47, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 19, k + 47, deepslate_bricks, 1, 2);
		world.setBlock(i + 19, j + 19, k + 47, deepslate_bricks, 1, 2);
		world.setBlock(i + 20, j + 19, k + 47, deepslate_bricks, 1, 2);
		world.setBlock(i + 16, j + 19, k + 48, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 19, k + 48, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 19, k + 48, cobbled_deepslate, 0, 2);
		world.setBlock(i + 19, j + 19, k + 48, cobbled_deepslate, 0, 2);
		world.setBlock(i + 20, j + 19, k + 48, cobbled_deepslate, 0, 2);
		world.setBlock(i + 16, j + 19, k + 49, cobbled_deepslate, 0, 2);
		world.setBlock(i + 17, j + 19, k + 49, cobbled_deepslate, 0, 2);
		world.setBlock(i + 18, j + 19, k + 49, cobbled_deepslate, 0, 2);
		world.setBlock(i + 19, j + 19, k + 49, cobbled_deepslate, 0, 2);
		world.setBlock(i + 20, j + 19, k + 49, cobbled_deepslate, 0, 2);
		world.setBlock(i + 17, j + 20, k + 15, cobbled_deepslate, 0, 2);
		world.setBlock(i + 18, j + 20, k + 15, cobbled_deepslate, 0, 2);
		world.setBlock(i + 19, j + 20, k + 15, cobbled_deepslate, 0, 2);
		world.setBlock(i + 17, j + 20, k + 16, cobbled_deepslate, 0, 2);
		world.setBlock(i + 18, j + 20, k + 16, cobbled_deepslate, 0, 2);
		world.setBlock(i + 19, j + 20, k + 16, cobbled_deepslate, 0, 2);
		world.setBlock(i + 17, j + 20, k + 17, cobbled_deepslate, 0, 2);
		world.setBlock(i + 18, j + 20, k + 17, cobbled_deepslate, 0, 2);
		world.setBlock(i + 19, j + 20, k + 17, cobbled_deepslate, 0, 2);
		world.setBlock(i + 16, j + 20, k + 18, cobbled_deepslate, 0, 2);
		world.setBlock(i + 17, j + 20, k + 18, cobbled_deepslate, 0, 2);
		world.setBlock(i + 18, j + 20, k + 18, cobbled_deepslate, 0, 2);
		world.setBlock(i + 19, j + 20, k + 18, cobbled_deepslate, 0, 2);
		world.setBlock(i + 20, j + 20, k + 18, cobbled_deepslate, 0, 2);
		world.setBlock(i + 16, j + 20, k + 19, deepslate_bricks, 1, 2);
		world.setBlock(i + 17, j + 20, k + 19, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 20, k + 19, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 20, k + 19, cobbled_deepslate, 0, 2);
		world.setBlock(i + 20, j + 20, k + 19, cobbled_deepslate, 0, 2);
		world.setBlock(i + 16, j + 20, k + 20, deepslate_bricks, 1, 2);
		world.setBlock(i + 17, j + 20, k + 20, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 20, k + 20, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 20, k + 20, deepslate_bricks, 0, 2);
		world.setBlock(i + 20, j + 20, k + 20, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 20, k + 21, deepslate_bricks, 2, 2);
		world.setBlock(i + 17, j + 20, k + 21, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 20, k + 21, deepslate_bricks, 1, 2);
		world.setBlock(i + 19, j + 20, k + 21, deepslate_bricks, 0, 2);
		world.setBlock(i + 20, j + 20, k + 21, deepslate_bricks, 2, 2);
		world.setBlock(i + 17, j + 20, k + 22, deepslate_bricks, 2, 2);
		world.setBlock(i + 18, j + 20, k + 22, deepslate_bricks, 2, 2);
		world.setBlock(i + 19, j + 20, k + 22, deepslate_bricks, 3, 2);
		world.setBlock(i + 18, j + 20, k + 23, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
		world.setBlock(i + 18, j + 20, k + 44, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
		world.setBlock(i + 17, j + 20, k + 45, deepslate_bricks, 2, 2);
		world.setBlock(i + 18, j + 20, k + 45, deepslate_bricks, 2, 2);
		world.setBlock(i + 19, j + 20, k + 45, deepslate_bricks, 3, 2);
		world.setBlock(i + 16, j + 20, k + 46, deepslate_bricks, 2, 2);
		world.setBlock(i + 17, j + 20, k + 46, deepslate_bricks, 2, 2);
		world.setBlock(i + 18, j + 20, k + 46, deepslate_bricks, 3, 2);
		world.setBlock(i + 19, j + 20, k + 46, deepslate_bricks, 3, 2);
		world.setBlock(i + 20, j + 20, k + 46, deepslate_bricks, 2, 2);
		world.setBlock(i + 16, j + 20, k + 47, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 20, k + 47, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 20, k + 47, deepslate_bricks, 1, 2);
		world.setBlock(i + 19, j + 20, k + 47, deepslate_bricks, 0, 2);
		world.setBlock(i + 20, j + 20, k + 47, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 20, k + 48, deepslate_bricks, 1, 2);
		world.setBlock(i + 17, j + 20, k + 48, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 20, k + 48, cobbled_deepslate, 0, 2);
		world.setBlock(i + 19, j + 20, k + 48, cobbled_deepslate, 0, 2);
		world.setBlock(i + 20, j + 20, k + 48, cobbled_deepslate, 0, 2);
		world.setBlock(i + 16, j + 20, k + 49, cobbled_deepslate, 0, 2);
		world.setBlock(i + 17, j + 20, k + 49, cobbled_deepslate, 0, 2);
		world.setBlock(i + 18, j + 20, k + 49, cobbled_deepslate, 0, 2);
		world.setBlock(i + 19, j + 20, k + 49, cobbled_deepslate, 0, 2);
		world.setBlock(i + 20, j + 20, k + 49, cobbled_deepslate, 0, 2);
		world.setBlock(i + 17, j + 20, k + 50, cobbled_deepslate, 0, 2);
		world.setBlock(i + 18, j + 20, k + 50, cobbled_deepslate, 0, 2);
		world.setBlock(i + 19, j + 20, k + 50, cobbled_deepslate, 0, 2);
		world.setBlock(i + 17, j + 20, k + 51, cobbled_deepslate, 0, 2);
		world.setBlock(i + 18, j + 20, k + 51, cobbled_deepslate, 0, 2);
		world.setBlock(i + 17, j + 20, k + 52, cobbled_deepslate, 0, 2);
		world.setBlock(i + 18, j + 20, k + 52, cobbled_deepslate, 0, 2);
		world.setBlock(i + 19, j + 20, k + 52, cobbled_deepslate, 0, 2);
		world.setBlock(i + 17, j + 20, k + 53, cobbled_deepslate, 0, 2);
		world.setBlock(i + 18, j + 20, k + 53, cobbled_deepslate, 0, 2);
		world.setBlock(i + 17, j + 21, k + 14, cobbled_deepslate, 0, 2);
		world.setBlock(i + 18, j + 21, k + 14, cobbled_deepslate, 0, 2);
		world.setBlock(i + 19, j + 21, k + 14, cobbled_deepslate, 0, 2);
		world.setBlock(i + 17, j + 21, k + 15, cobbled_deepslate, 0, 2);
		world.setBlock(i + 18, j + 21, k + 15, cobbled_deepslate, 0, 2);
		world.setBlock(i + 19, j + 21, k + 15, cobbled_deepslate, 0, 2);
		world.setBlock(i + 17, j + 21, k + 16, cobbled_deepslate, 0, 2);
		world.setBlock(i + 18, j + 21, k + 16, cobbled_deepslate, 0, 2);
		world.setBlock(i + 19, j + 21, k + 16, cobbled_deepslate, 0, 2);
		world.setBlock(i + 17, j + 21, k + 17, cobbled_deepslate, 0, 2);
		world.setBlock(i + 18, j + 21, k + 17, cobbled_deepslate, 0, 2);
		world.setBlock(i + 19, j + 21, k + 17, cobbled_deepslate, 0, 2);
		world.setBlock(i + 16, j + 21, k + 18, cobbled_deepslate, 0, 2);
		world.setBlock(i + 17, j + 21, k + 18, cobbled_deepslate, 0, 2);
		world.setBlock(i + 18, j + 21, k + 18, cobbled_deepslate, 0, 2);
		world.setBlock(i + 19, j + 21, k + 18, cobbled_deepslate, 0, 2);
		world.setBlock(i + 20, j + 21, k + 18, cobbled_deepslate, 0, 2);
		world.setBlock(i + 16, j + 21, k + 19, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 21, k + 19, deepslate_bricks, 1, 2);
		world.setBlock(i + 18, j + 21, k + 19, deepslate_bricks, 1, 2);
		world.setBlock(i + 19, j + 21, k + 19, cobbled_deepslate, 0, 2);
		world.setBlock(i + 20, j + 21, k + 19, cobbled_deepslate, 0, 2);
		world.setBlock(i + 16, j + 21, k + 20, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 21, k + 20, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 21, k + 20, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 21, k + 20, deepslate_bricks, 1, 2);
		world.setBlock(i + 20, j + 21, k + 20, deepslate_bricks, 1, 2);
		world.setBlock(i + 16, j + 21, k + 21, deepslate_bricks, 3, 2);
		world.setBlock(i + 17, j + 21, k + 21, deepslate_bricks, 1, 2);
		world.setBlock(i + 18, j + 21, k + 21, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 21, k + 21, deepslate_bricks, 1, 2);
		world.setBlock(i + 20, j + 21, k + 21, deepslate_bricks, 2, 2);
		world.setBlock(i + 17, j + 21, k + 22, deepslate_bricks, 3, 2);
		world.setBlock(i + 18, j + 21, k + 22, deepslate_bricks, 2, 2);
		world.setBlock(i + 19, j + 21, k + 22, deepslate_bricks, 2, 2);
		world.setBlock(i + 18, j + 21, k + 23, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
		world.setBlock(i + 18, j + 21, k + 44, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
		world.setBlock(i + 17, j + 21, k + 45, deepslate_bricks, 2, 2);
		world.setBlock(i + 18, j + 21, k + 45, deepslate_bricks, 2, 2);
		world.setBlock(i + 19, j + 21, k + 45, deepslate_bricks, 2, 2);
		world.setBlock(i + 16, j + 21, k + 46, deepslate_bricks, 3, 2);
		world.setBlock(i + 17, j + 21, k + 46, deepslate_bricks, 3, 2);
		world.setBlock(i + 18, j + 21, k + 46, deepslate_bricks, 2, 2);
		world.setBlock(i + 19, j + 21, k + 46, deepslate_bricks, 2, 2);
		world.setBlock(i + 20, j + 21, k + 46, deepslate_bricks, 2, 2);
		world.setBlock(i + 16, j + 21, k + 47, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 21, k + 47, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 21, k + 47, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 21, k + 47, deepslate_bricks, 1, 2);
		world.setBlock(i + 20, j + 21, k + 47, deepslate_bricks, 1, 2);
		world.setBlock(i + 16, j + 21, k + 48, deepslate_bricks, 1, 2);
		world.setBlock(i + 17, j + 21, k + 48, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 21, k + 48, cobbled_deepslate, 0, 2);
		world.setBlock(i + 19, j + 21, k + 48, cobbled_deepslate, 0, 2);
		world.setBlock(i + 16, j + 21, k + 49, cobbled_deepslate, 0, 2);
		world.setBlock(i + 17, j + 21, k + 49, cobbled_deepslate, 0, 2);
		world.setBlock(i + 18, j + 21, k + 49, cobbled_deepslate, 0, 2);
		world.setBlock(i + 19, j + 21, k + 49, cobbled_deepslate, 0, 2);
		world.setBlock(i + 20, j + 21, k + 49, cobbled_deepslate, 0, 2);
		world.setBlock(i + 17, j + 21, k + 50, cobbled_deepslate, 0, 2);
		world.setBlock(i + 18, j + 21, k + 50, cobbled_deepslate, 0, 2);
		world.setBlock(i + 19, j + 21, k + 50, cobbled_deepslate, 0, 2);
		world.setBlock(i + 17, j + 21, k + 51, cobbled_deepslate, 0, 2);
		world.setBlock(i + 18, j + 21, k + 51, cobbled_deepslate, 0, 2);
		world.setBlock(i + 19, j + 21, k + 51, cobbled_deepslate, 0, 2);
		world.setBlock(i + 17, j + 21, k + 52, cobbled_deepslate, 0, 2);
		world.setBlock(i + 18, j + 21, k + 52, cobbled_deepslate, 0, 2);
		world.setBlock(i + 19, j + 21, k + 52, cobbled_deepslate, 0, 2);
		world.setBlock(i + 17, j + 21, k + 53, cobbled_deepslate, 0, 2);
		world.setBlock(i + 18, j + 21, k + 53, cobbled_deepslate, 0, 2);
		world.setBlock(i + 19, j + 21, k + 53, cobbled_deepslate, 0, 2);













































































		world.setBlock(i + 17, j + 22, k + 14, cobbled_deepslate, 0, 2);
		world.setBlock(i + 18, j + 22, k + 14, cobbled_deepslate, 0, 2);
		world.setBlock(i + 19, j + 22, k + 14, cobbled_deepslate, 0, 2);
		world.setBlock(i + 17, j + 22, k + 15, cobbled_deepslate, 0, 2);
		world.setBlock(i + 18, j + 22, k + 15, cobbled_deepslate, 0, 2);
		world.setBlock(i + 19, j + 22, k + 15, cobbled_deepslate, 0, 2);
		world.setBlock(i + 16, j + 22, k + 18, cobbled_deepslate, 0, 2);
		world.setBlock(i + 17, j + 22, k + 18, cobbled_deepslate, 0, 2);
		world.setBlock(i + 18, j + 22, k + 18, cobbled_deepslate, 0, 2);
		world.setBlock(i + 19, j + 22, k + 18, cobbled_deepslate, 0, 2);
		world.setBlock(i + 16, j + 22, k + 19, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 22, k + 19, deepslate_bricks, 1, 2);
		world.setBlock(i + 18, j + 22, k + 19, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 22, k + 19, cobbled_deepslate, 0, 2);
		world.setBlock(i + 20, j + 22, k + 19, cobbled_deepslate, 0, 2);
		world.setBlock(i + 16, j + 22, k + 20, deepslate_bricks, 1, 2);
		world.setBlock(i + 17, j + 22, k + 20, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 22, k + 20, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 22, k + 20, deepslate_bricks, 0, 2);
		world.setBlock(i + 20, j + 22, k + 20, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 22, k + 21, deepslate_bricks, 3, 2);
		world.setBlock(i + 17, j + 22, k + 21, deepslate_bricks, 1, 2);
		world.setBlock(i + 18, j + 22, k + 21, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 22, k + 21, deepslate_bricks, 0, 2);
		world.setBlock(i + 20, j + 22, k + 21, deepslate_bricks, 3, 2);
		world.setBlock(i + 16, j + 22, k + 22, deepslate_bricks, 2, 2);
		world.setBlock(i + 17, j + 22, k + 22, deepslate_bricks, 2, 2);
		world.setBlock(i + 18, j + 22, k + 22, deepslate_bricks, 2, 2);
		world.setBlock(i + 19, j + 22, k + 22, deepslate_bricks, 2, 2);
		world.setBlock(i + 20, j + 22, k + 22, deepslate_bricks, 3, 2);
		world.setBlock(i + 18, j + 22, k + 23, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
		world.setBlock(i + 18, j + 22, k + 44, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
		world.setBlock(i + 16, j + 22, k + 45, deepslate_bricks, 3, 2);
		world.setBlock(i + 17, j + 22, k + 45, deepslate_bricks, 2, 2);
		world.setBlock(i + 18, j + 22, k + 45, deepslate_bricks, 3, 2);
		world.setBlock(i + 19, j + 22, k + 45, deepslate_bricks, 2, 2);
		world.setBlock(i + 20, j + 22, k + 45, deepslate_bricks, 2, 2);
		world.setBlock(i + 16, j + 22, k + 46, deepslate_bricks, 2, 2);
		world.setBlock(i + 17, j + 22, k + 46, deepslate_bricks, 3, 2);
		world.setBlock(i + 18, j + 22, k + 46, deepslate_bricks, 3, 2);
		world.setBlock(i + 19, j + 22, k + 46, deepslate_bricks, 2, 2);
		world.setBlock(i + 20, j + 22, k + 46, deepslate_bricks, 2, 2);
		world.setBlock(i + 16, j + 22, k + 47, deepslate_bricks, 1, 2);
		world.setBlock(i + 17, j + 22, k + 47, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 22, k + 47, deepslate_bricks, 1, 2);
		world.setBlock(i + 19, j + 22, k + 47, deepslate_bricks, 0, 2);
		world.setBlock(i + 20, j + 22, k + 47, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 22, k + 48, deepslate_bricks, 1, 2);
		world.setBlock(i + 17, j + 22, k + 48, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 22, k + 48, deepslate_bricks, 1, 2);
		world.setBlock(i + 19, j + 22, k + 48, cobbled_deepslate, 0, 2);
		world.setBlock(i + 20, j + 22, k + 48, cobbled_deepslate, 0, 2);
		world.setBlock(i + 16, j + 22, k + 49, cobbled_deepslate, 0, 2);
		world.setBlock(i + 17, j + 22, k + 49, cobbled_deepslate, 0, 2);
		world.setBlock(i + 18, j + 22, k + 49, cobbled_deepslate, 0, 2);
		world.setBlock(i + 19, j + 22, k + 49, cobbled_deepslate, 0, 2);
		world.setBlock(i + 20, j + 22, k + 49, cobbled_deepslate, 0, 2);
		world.setBlock(i + 17, j + 22, k + 52, cobbled_deepslate, 0, 2);
		world.setBlock(i + 18, j + 22, k + 52, cobbled_deepslate, 0, 2);
		world.setBlock(i + 19, j + 22, k + 52, cobbled_deepslate, 0, 2);
		world.setBlock(i + 17, j + 22, k + 53, cobbled_deepslate, 0, 2);
		world.setBlock(i + 18, j + 22, k + 53, cobbled_deepslate, 0, 2);
		world.setBlock(i + 17, j + 23, k + 14, cobbled_deepslate, 0, 2);
		world.setBlock(i + 18, j + 23, k + 14, cobbled_deepslate, 0, 2);
		world.setBlock(i + 19, j + 23, k + 14, cobbled_deepslate, 0, 2);
		world.setBlock(i + 17, j + 23, k + 15, cobbled_deepslate, 0, 2);
		world.setBlock(i + 18, j + 23, k + 15, cobbled_deepslate, 0, 2);
		world.setBlock(i + 19, j + 23, k + 15, cobbled_deepslate, 0, 2);
		world.setBlock(i + 16, j + 23, k + 18, cobbled_deepslate, 0, 2);
		world.setBlock(i + 17, j + 23, k + 18, cobbled_deepslate, 0, 2);
		world.setBlock(i + 18, j + 23, k + 18, cobbled_deepslate, 0, 2);
		world.setBlock(i + 19, j + 23, k + 18, cobbled_deepslate, 0, 2);
		world.setBlock(i + 20, j + 23, k + 18, cobbled_deepslate, 0, 2);
		world.setBlock(i + 16, j + 23, k + 19, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 23, k + 19, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 23, k + 19, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 23, k + 19, deepslate_bricks, 1, 2);
		world.setBlock(i + 20, j + 23, k + 19, cobbled_deepslate, 0, 2);
		world.setBlock(i + 16, j + 23, k + 20, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 23, k + 20, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 23, k + 20, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 23, k + 20, deepslate_bricks, 0, 2);
		world.setBlock(i + 20, j + 23, k + 20, deepslate_bricks, 1, 2);
		world.setBlock(i + 16, j + 23, k + 21, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 23, k + 21, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 23, k + 21, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 23, k + 21, deepslate_bricks, 0, 2);
		world.setBlock(i + 20, j + 23, k + 21, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 23, k + 22, deepslate_bricks, 3, 2);
		world.setBlock(i + 17, j + 23, k + 22, deepslate_bricks, 2, 2);
		world.setBlock(i + 18, j + 23, k + 22, deepslate_bricks, 3, 2);
		world.setBlock(i + 19, j + 23, k + 22, deepslate_bricks, 2, 2);
		world.setBlock(i + 20, j + 23, k + 22, deepslate_bricks, 2, 2);
		world.setBlock(i + 18, j + 23, k + 23, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
		world.setBlock(i + 18, j + 23, k + 44, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
		world.setBlock(i + 16, j + 23, k + 45, deepslate_bricks, 2, 2);
		world.setBlock(i + 17, j + 23, k + 45, deepslate_bricks, 2, 2);
		world.setBlock(i + 18, j + 23, k + 45, deepslate_bricks, 2, 2);
		world.setBlock(i + 19, j + 23, k + 45, deepslate_bricks, 3, 2);
		world.setBlock(i + 20, j + 23, k + 45, deepslate_bricks, 2, 2);
		world.setBlock(i + 16, j + 23, k + 46, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 23, k + 46, deepslate_bricks, 2, 2);
		world.setBlock(i + 18, j + 23, k + 46, deepslate_bricks, 2, 2);
		world.setBlock(i + 19, j + 23, k + 46, deepslate_bricks, 2, 2);
		world.setBlock(i + 20, j + 23, k + 46, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 23, k + 47, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 23, k + 47, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 23, k + 47, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 23, k + 47, deepslate_bricks, 1, 2);
		world.setBlock(i + 20, j + 23, k + 47, deepslate_bricks, 1, 2);
		world.setBlock(i + 16, j + 23, k + 48, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 23, k + 48, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 23, k + 48, cobbled_deepslate, 0, 2);
		world.setBlock(i + 19, j + 23, k + 48, cobbled_deepslate, 0, 2);
		world.setBlock(i + 20, j + 23, k + 48, cobbled_deepslate, 0, 2);
		world.setBlock(i + 16, j + 23, k + 49, cobbled_deepslate, 0, 2);
		world.setBlock(i + 17, j + 23, k + 49, cobbled_deepslate, 0, 2);
		world.setBlock(i + 18, j + 23, k + 49, cobbled_deepslate, 0, 2);
		world.setBlock(i + 19, j + 23, k + 49, cobbled_deepslate, 0, 2);
		world.setBlock(i + 20, j + 23, k + 49, cobbled_deepslate, 0, 2);
		world.setBlock(i + 17, j + 23, k + 52, cobbled_deepslate, 0, 2);
		world.setBlock(i + 18, j + 23, k + 52, cobbled_deepslate, 0, 2);
		world.setBlock(i + 17, j + 23, k + 53, cobbled_deepslate, 0, 2);
		world.setBlock(i + 18, j + 23, k + 53, cobbled_deepslate, 0, 2);
		world.setBlock(i + 19, j + 23, k + 53, cobbled_deepslate, 0, 2);
		world.setBlock(i + 17, j + 24, k + 14, cobbled_deepslate, 0, 2);
		world.setBlock(i + 18, j + 24, k + 14, cobbled_deepslate, 0, 2);
		world.setBlock(i + 19, j + 24, k + 14, cobbled_deepslate, 0, 2);
		world.setBlock(i + 17, j + 24, k + 15, cobbled_deepslate, 0, 2);
		world.setBlock(i + 18, j + 24, k + 15, cobbled_deepslate, 0, 2);
		world.setBlock(i + 19, j + 24, k + 15, cobbled_deepslate, 0, 2);
		world.setBlock(i + 17, j + 24, k + 16, cobbled_deepslate, 0, 2);
		world.setBlock(i + 18, j + 24, k + 16, cobbled_deepslate, 0, 2);
		world.setBlock(i + 19, j + 24, k + 16, cobbled_deepslate, 0, 2);
		world.setBlock(i + 17, j + 24, k + 17, cobbled_deepslate, 0, 2);
		world.setBlock(i + 18, j + 24, k + 17, cobbled_deepslate, 0, 2);
		world.setBlock(i + 19, j + 24, k + 17, cobbled_deepslate, 0, 2);
		world.setBlock(i + 16, j + 24, k + 18, deepslate_bricks, 1, 2);
		world.setBlock(i + 17, j + 24, k + 18, cobbled_deepslate, 0, 2);
		world.setBlock(i + 18, j + 24, k + 18, cobbled_deepslate, 0, 2);
		world.setBlock(i + 19, j + 24, k + 18, cobbled_deepslate, 0, 2);
		world.setBlock(i + 20, j + 24, k + 18, cobbled_deepslate, 0, 2);
		world.setBlock(i + 16, j + 24, k + 19, deepslate_bricks, 1, 2);
		world.setBlock(i + 17, j + 24, k + 19, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 24, k + 19, deepslate_bricks, 1, 2);
		world.setBlock(i + 19, j + 24, k + 19, deepslate_bricks, 0, 2);
		world.setBlock(i + 20, j + 24, k + 19, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 24, k + 20, deepslate_bricks, 1, 2);
		world.setBlock(i + 17, j + 24, k + 20, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 24, k + 20, deepslate_bricks, 1, 2);
		world.setBlock(i + 19, j + 24, k + 20, deepslate_bricks, 0, 2);
		world.setBlock(i + 20, j + 24, k + 20, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 24, k + 21, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 24, k + 21, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 24, k + 21, deepslate_bricks, 1, 2);
		world.setBlock(i + 19, j + 24, k + 21, deepslate_bricks, 0, 2);
		world.setBlock(i + 20, j + 24, k + 21, deepslate_bricks, 1, 2);
		world.setBlock(i + 16, j + 24, k + 22, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 24, k + 22, deepslate_bricks, 3, 2);
		world.setBlock(i + 18, j + 24, k + 22, deepslate_bricks, 3, 2);
		world.setBlock(i + 19, j + 24, k + 22, deepslate_bricks, 2, 2);
		world.setBlock(i + 20, j + 24, k + 22, deepslate_bricks, 1, 2);
		world.setBlock(i + 16, j + 24, k + 23, deepslate_bricks, 3, 2);
		world.setBlock(i + 18, j + 24, k + 23, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
		world.setBlock(i + 20, j + 24, k + 23, deepslate_bricks, 3, 2);
		world.setBlock(i + 18, j + 24, k + 24, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
		world.setBlock(i + 18, j + 24, k + 25, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
		world.setBlock(i + 18, j + 24, k + 26, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
		world.setBlock(i + 18, j + 24, k + 27, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
		world.setBlock(i + 18, j + 24, k + 28, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
		world.setBlock(i + 18, j + 24, k + 29, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
		world.setBlock(i + 18, j + 24, k + 30, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
		world.setBlock(i + 18, j + 24, k + 31, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
		world.setBlock(i + 18, j + 24, k + 32, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
		world.setBlock(i + 18, j + 24, k + 33, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
		world.setBlock(i + 18, j + 24, k + 34, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
		world.setBlock(i + 18, j + 24, k + 35, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
		world.setBlock(i + 18, j + 24, k + 36, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
		world.setBlock(i + 18, j + 24, k + 37, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
		world.setBlock(i + 18, j + 24, k + 38, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
		world.setBlock(i + 18, j + 24, k + 39, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
		world.setBlock(i + 18, j + 24, k + 40, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
		world.setBlock(i + 18, j + 24, k + 41, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
		world.setBlock(i + 18, j + 24, k + 42, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
		world.setBlock(i + 18, j + 24, k + 43, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
		world.setBlock(i + 16, j + 24, k + 44, deepslate_bricks, 2, 2);
		world.setBlock(i + 18, j + 24, k + 44, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
		world.setBlock(i + 20, j + 24, k + 44, deepslate_bricks, 2, 2);
		world.setBlock(i + 16, j + 24, k + 45, deepslate_bricks, 2, 2);
		world.setBlock(i + 17, j + 24, k + 45, deepslate_bricks, 2, 2);
		world.setBlock(i + 18, j + 24, k + 45, deepslate_bricks, 3, 2);
		world.setBlock(i + 19, j + 24, k + 45, deepslate_bricks, 2, 2);
		world.setBlock(i + 20, j + 24, k + 45, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 24, k + 46, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 24, k + 46, deepslate_bricks, 3, 2);
		world.setBlock(i + 18, j + 24, k + 46, deepslate_bricks, 3, 2);
		world.setBlock(i + 19, j + 24, k + 46, deepslate_bricks, 2, 2);
		world.setBlock(i + 20, j + 24, k + 46, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 24, k + 47, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 24, k + 47, deepslate_bricks, 1, 2);
		world.setBlock(i + 18, j + 24, k + 47, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 24, k + 47, deepslate_bricks, 1, 2);
		world.setBlock(i + 20, j + 24, k + 47, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 24, k + 48, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 24, k + 48, cobbled_deepslate, 0, 2);
		world.setBlock(i + 18, j + 24, k + 48, cobbled_deepslate, 0, 2);
		world.setBlock(i + 19, j + 24, k + 48, cobbled_deepslate, 0, 2);
		world.setBlock(i + 20, j + 24, k + 48, cobbled_deepslate, 0, 2);
		world.setBlock(i + 16, j + 24, k + 49, cobbled_deepslate, 0, 2);
		world.setBlock(i + 17, j + 24, k + 49, cobbled_deepslate, 0, 2);
		world.setBlock(i + 18, j + 24, k + 49, cobbled_deepslate, 0, 2);
		world.setBlock(i + 19, j + 24, k + 49, cobbled_deepslate, 0, 2);
		world.setBlock(i + 20, j + 24, k + 49, cobbled_deepslate, 0, 2);
		world.setBlock(i + 17, j + 24, k + 50, cobbled_deepslate, 0, 2);
		world.setBlock(i + 18, j + 24, k + 50, cobbled_deepslate, 0, 2);
		world.setBlock(i + 19, j + 24, k + 50, cobbled_deepslate, 0, 2);
		world.setBlock(i + 17, j + 24, k + 51, cobbled_deepslate, 0, 2);
		world.setBlock(i + 18, j + 24, k + 51, cobbled_deepslate, 0, 2);
		world.setBlock(i + 19, j + 24, k + 51, cobbled_deepslate, 0, 2);
		world.setBlock(i + 17, j + 24, k + 52, cobbled_deepslate, 0, 2);
		world.setBlock(i + 18, j + 24, k + 52, cobbled_deepslate, 0, 2);
		world.setBlock(i + 19, j + 24, k + 52, cobbled_deepslate, 0, 2);
		world.setBlock(i + 17, j + 24, k + 53, cobbled_deepslate, 0, 2);
		world.setBlock(i + 18, j + 24, k + 53, cobbled_deepslate, 0, 2);
		world.setBlock(i + 19, j + 24, k + 53, cobbled_deepslate, 0, 2);
		world.setBlock(i + 17, j + 25, k + 14, cobbled_deepslate, 0, 2);
		world.setBlock(i + 18, j + 25, k + 14, cobbled_deepslate, 0, 2);
















































		world.setBlock(i + 17, j + 25, k + 15, cobbled_deepslate, 0, 2);
		world.setBlock(i + 18, j + 25, k + 15, cobbled_deepslate, 0, 2);
		world.setBlock(i + 19, j + 25, k + 15, cobbled_deepslate, 0, 2);
		world.setBlock(i + 17, j + 25, k + 16, cobbled_deepslate, 0, 2);
		world.setBlock(i + 18, j + 25, k + 16, cobbled_deepslate, 0, 2);
		world.setBlock(i + 19, j + 25, k + 16, cobbled_deepslate, 0, 2);
		world.setBlock(i + 17, j + 25, k + 17, cobbled_deepslate, 0, 2);
		world.setBlock(i + 18, j + 25, k + 17, cobbled_deepslate, 0, 2);
		world.setBlock(i + 19, j + 25, k + 17, cobbled_deepslate, 0, 2);
		world.setBlock(i + 16, j + 25, k + 18, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 25, k + 18, deepslate_bricks, 1, 2);
		world.setBlock(i + 18, j + 25, k + 18, cobbled_deepslate, 0, 2);
		world.setBlock(i + 19, j + 25, k + 18, cobbled_deepslate, 0, 2);
		world.setBlock(i + 20, j + 25, k + 18, cobbled_deepslate, 0, 2);
		world.setBlock(i + 16, j + 25, k + 19, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 25, k + 19, deepslate_bricks, 1, 2);
		world.setBlock(i + 18, j + 25, k + 19, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 25, k + 19, deepslate_bricks, 0, 2);
		world.setBlock(i + 20, j + 25, k + 19, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 25, k + 20, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 25, k + 20, deepslate_bricks, 1, 2);
		world.setBlock(i + 18, j + 25, k + 20, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 25, k + 20, deepslate_bricks, 0, 2);
		world.setBlock(i + 20, j + 25, k + 20, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 25, k + 21, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 25, k + 21, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 25, k + 21, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 25, k + 21, deepslate_bricks, 1, 2);
		world.setBlock(i + 20, j + 25, k + 21, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 25, k + 22, deepslate_bricks, 3, 2);
		world.setBlock(i + 18, j + 25, k + 22, deepslate_bricks, 2, 2);
		world.setBlock(i + 19, j + 25, k + 22, deepslate_bricks, 3, 2);
		world.setBlock(i + 20, j + 25, k + 22, deepslate_bricks, 1, 2);
		world.setBlock(i + 17, j + 25, k + 23, deepslate_bricks, 2, 2);
		world.setBlock(i + 18, j + 25, k + 23, deepslate_bricks, 2, 2);
		world.setBlock(i + 19, j + 25, k + 23, deepslate_bricks, 2, 2);
		world.setBlock(i + 20, j + 25, k + 23, deepslate_bricks, 1, 2);
		world.setBlock(i + 16, j + 25, k + 24, deepslate_bricks, 2, 2);
		world.setBlock(i + 17, j + 25, k + 24, deepslate_bricks, 2, 2);
		world.setBlock(i + 18, j + 25, k + 24, deepslate_bricks, 2, 2);
		world.setBlock(i + 19, j + 25, k + 24, deepslate_bricks, 2, 2);
		world.setBlock(i + 20, j + 25, k + 24, deepslate_bricks, 2, 2);
		world.setBlock(i + 16, j + 25, k + 25, deepslate_bricks, 3, 2);
		world.setBlock(i + 17, j + 25, k + 25, deepslate_bricks, 3, 2);
		world.setBlock(i + 18, j + 25, k + 25, deepslate_bricks, 3, 2);
		world.setBlock(i + 19, j + 25, k + 25, deepslate_bricks, 2, 2);
		world.setBlock(i + 20, j + 25, k + 25, deepslate_bricks, 3, 2);
		world.setBlock(i + 16, j + 25, k + 26, deepslate_bricks, 2, 2);
		world.setBlock(i + 17, j + 25, k + 26, deepslate_bricks, 2, 2);
		world.setBlock(i + 18, j + 25, k + 26, deepslate_bricks, 2, 2);
		world.setBlock(i + 19, j + 25, k + 26, deepslate_bricks, 2, 2);
		world.setBlock(i + 20, j + 25, k + 26, deepslate_bricks, 2, 2);
		world.setBlock(i + 17, j + 25, k + 27, deepslate_bricks, 2, 2);
		world.setBlock(i + 18, j + 25, k + 27, deepslate_bricks, 2, 2);
		world.setBlock(i + 19, j + 25, k + 27, deepslate_bricks, 2, 2);
		world.setBlock(i + 17, j + 25, k + 28, deepslate_bricks, 2, 2);
		world.setBlock(i + 18, j + 25, k + 28, deepslate_bricks, 2, 2);
		world.setBlock(i + 19, j + 25, k + 28, deepslate_bricks, 2, 2);
		world.setBlock(i + 16, j + 25, k + 29, deepslate_bricks, 2, 2);
		world.setBlock(i + 17, j + 25, k + 29, deepslate_bricks, 2, 2);
		world.setBlock(i + 18, j + 25, k + 29, deepslate_bricks, 2, 2);
		world.setBlock(i + 19, j + 25, k + 29, deepslate_bricks, 2, 2);
		world.setBlock(i + 20, j + 25, k + 29, deepslate_bricks, 2, 2);
		world.setBlock(i + 16, j + 25, k + 30, deepslate_bricks, 2, 2);
		world.setBlock(i + 17, j + 25, k + 30, deepslate_bricks, 2, 2);
		world.setBlock(i + 18, j + 25, k + 30, deepslate_bricks, 3, 2);
		world.setBlock(i + 19, j + 25, k + 30, deepslate_bricks, 2, 2);
		world.setBlock(i + 20, j + 25, k + 30, deepslate_bricks, 2, 2);
		world.setBlock(i + 16, j + 25, k + 31, deepslate_bricks, 3, 2);
		world.setBlock(i + 17, j + 25, k + 31, deepslate_bricks, 3, 2);
		world.setBlock(i + 18, j + 25, k + 31, deepslate_bricks, 3, 2);
		world.setBlock(i + 19, j + 25, k + 31, deepslate_bricks, 3, 2);
		world.setBlock(i + 17, j + 25, k + 32, deepslate_bricks, 2, 2);
		world.setBlock(i + 18, j + 25, k + 32, deepslate_bricks, 2, 2);
		world.setBlock(i + 19, j + 25, k + 32, deepslate_bricks, 2, 2);
		world.setBlock(i + 16, j + 25, k + 33, deepslate_bricks, 3, 2);
		world.setBlock(i + 17, j + 25, k + 33, deepslate_bricks, 3, 2);
		world.setBlock(i + 18, j + 25, k + 33, deepslate_bricks, 2, 2);
		world.setBlock(i + 19, j + 25, k + 33, deepslate_bricks, 2, 2);
		world.setBlock(i + 20, j + 25, k + 33, deepslate_bricks, 2, 2);
		world.setBlock(i + 16, j + 25, k + 34, deepslate_bricks, 2, 2);
		world.setBlock(i + 17, j + 25, k + 34, deepslate_bricks, 2, 2);
		world.setBlock(i + 18, j + 25, k + 34, deepslate_bricks, 3, 2);
		world.setBlock(i + 19, j + 25, k + 34, deepslate_bricks, 2, 2);
		world.setBlock(i + 20, j + 25, k + 34, deepslate_bricks, 2, 2);
		world.setBlock(i + 17, j + 25, k + 35, deepslate_bricks, 2, 2);
		world.setBlock(i + 18, j + 25, k + 35, deepslate_bricks, 2, 2);
		world.setBlock(i + 19, j + 25, k + 35, deepslate_bricks, 2, 2);
		world.setBlock(i + 17, j + 25, k + 36, deepslate_bricks, 3, 2);
		world.setBlock(i + 18, j + 25, k + 36, deepslate_bricks, 3, 2);
		world.setBlock(i + 19, j + 25, k + 36, deepslate_bricks, 2, 2);
		world.setBlock(i + 16, j + 25, k + 37, deepslate_bricks, 2, 2);
		world.setBlock(i + 17, j + 25, k + 37, deepslate_bricks, 3, 2);
		world.setBlock(i + 18, j + 25, k + 37, deepslate_bricks, 2, 2);
		world.setBlock(i + 19, j + 25, k + 37, deepslate_bricks, 2, 2);
		world.setBlock(i + 20, j + 25, k + 37, deepslate_bricks, 2, 2);
		world.setBlock(i + 16, j + 25, k + 38, deepslate_bricks, 2, 2);
		world.setBlock(i + 17, j + 25, k + 38, deepslate_bricks, 3, 2);
		world.setBlock(i + 18, j + 25, k + 38, deepslate_bricks, 2, 2);
		world.setBlock(i + 19, j + 25, k + 38, deepslate_bricks, 2, 2);
		world.setBlock(i + 20, j + 25, k + 38, deepslate_bricks, 3, 2);
		world.setBlock(i + 17, j + 25, k + 39, deepslate_bricks, 2, 2);
		world.setBlock(i + 18, j + 25, k + 39, deepslate_bricks, 2, 2);
		world.setBlock(i + 19, j + 25, k + 39, deepslate_bricks, 2, 2);
		world.setBlock(i + 17, j + 25, k + 40, deepslate_bricks, 2, 2);
		world.setBlock(i + 18, j + 25, k + 40, deepslate_bricks, 2, 2);
		world.setBlock(i + 19, j + 25, k + 40, deepslate_bricks, 2, 2);
		world.setBlock(i + 16, j + 25, k + 41, deepslate_bricks, 2, 2);
		world.setBlock(i + 17, j + 25, k + 41, deepslate_bricks, 3, 2);
		world.setBlock(i + 18, j + 25, k + 41, deepslate_bricks, 2, 2);
		world.setBlock(i + 19, j + 25, k + 41, deepslate_bricks, 2, 2);
		world.setBlock(i + 20, j + 25, k + 41, deepslate_bricks, 3, 2);
		world.setBlock(i + 16, j + 25, k + 42, deepslate_bricks, 2, 2);
		world.setBlock(i + 17, j + 25, k + 42, deepslate_bricks, 2, 2);
		world.setBlock(i + 18, j + 25, k + 42, deepslate_bricks, 3, 2);
		world.setBlock(i + 19, j + 25, k + 42, deepslate_bricks, 3, 2);
		world.setBlock(i + 20, j + 25, k + 42, deepslate_bricks, 2, 2);
		world.setBlock(i + 16, j + 25, k + 43, deepslate_bricks, 2, 2);
		world.setBlock(i + 17, j + 25, k + 43, deepslate_bricks, 2, 2);
		world.setBlock(i + 18, j + 25, k + 43, deepslate_bricks, 2, 2);
		world.setBlock(i + 19, j + 25, k + 43, deepslate_bricks, 2, 2);
		world.setBlock(i + 20, j + 25, k + 43, deepslate_bricks, 3, 2);
		world.setBlock(i + 16, j + 25, k + 44, deepslate_bricks, 2, 2);
		world.setBlock(i + 17, j + 25, k + 44, deepslate_bricks, 3, 2);
		world.setBlock(i + 18, j + 25, k + 44, deepslate_bricks, 2, 2);
		world.setBlock(i + 19, j + 25, k + 44, deepslate_bricks, 3, 2);
		world.setBlock(i + 20, j + 25, k + 44, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 25, k + 45, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 25, k + 45, deepslate_bricks, 2, 2);
		world.setBlock(i + 18, j + 25, k + 45, deepslate_bricks, 2, 2);
		world.setBlock(i + 19, j + 25, k + 45, deepslate_bricks, 0, 2);
		world.setBlock(i + 20, j + 25, k + 45, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 25, k + 46, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 25, k + 46, deepslate_bricks, 2, 2);
		world.setBlock(i + 18, j + 25, k + 46, deepslate_bricks, 2, 2);
		world.setBlock(i + 19, j + 25, k + 46, deepslate_bricks, 2, 2);
		world.setBlock(i + 20, j + 25, k + 46, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 25, k + 47, deepslate_bricks, 1, 2);
		world.setBlock(i + 17, j + 25, k + 47, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 25, k + 47, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 25, k + 47, deepslate_bricks, 0, 2);
		world.setBlock(i + 20, j + 25, k + 47, deepslate_bricks, 1, 2);
		world.setBlock(i + 16, j + 25, k + 48, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 25, k + 48, cobbled_deepslate, 0, 2);
		world.setBlock(i + 18, j + 25, k + 48, cobbled_deepslate, 0, 2);
		world.setBlock(i + 19, j + 25, k + 48, cobbled_deepslate, 0, 2);
		world.setBlock(i + 20, j + 25, k + 48, cobbled_deepslate, 0, 2);
		world.setBlock(i + 16, j + 25, k + 49, cobbled_deepslate, 0, 2);
		world.setBlock(i + 17, j + 25, k + 49, cobbled_deepslate, 0, 2);
		world.setBlock(i + 18, j + 25, k + 49, cobbled_deepslate, 0, 2);
		world.setBlock(i + 19, j + 25, k + 49, cobbled_deepslate, 0, 2);
		world.setBlock(i + 17, j + 25, k + 50, cobbled_deepslate, 0, 2);
		world.setBlock(i + 18, j + 25, k + 50, cobbled_deepslate, 0, 2);
		world.setBlock(i + 17, j + 25, k + 51, cobbled_deepslate, 0, 2);
		world.setBlock(i + 18, j + 25, k + 51, cobbled_deepslate, 0, 2);
		world.setBlock(i + 19, j + 25, k + 51, cobbled_deepslate, 0, 2);
		world.setBlock(i + 17, j + 25, k + 52, cobbled_deepslate, 0, 2);
		world.setBlock(i + 18, j + 25, k + 52, cobbled_deepslate, 0, 2);
		world.setBlock(i + 19, j + 25, k + 52, cobbled_deepslate, 0, 2);
		world.setBlock(i + 17, j + 25, k + 53, cobbled_deepslate, 0, 2);
		world.setBlock(i + 18, j + 25, k + 53, cobbled_deepslate, 0, 2);
		world.setBlock(i + 16, j + 26, k + 18, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 26, k + 18, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 26, k + 18, deepslate_bricks, 1, 2);
		world.setBlock(i + 19, j + 26, k + 18, deepslate_bricks, 0, 2);
		world.setBlock(i + 20, j + 26, k + 18, deepslate_bricks, 1, 2);
		world.setBlock(i + 16, j + 26, k + 19, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 26, k + 19, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 26, k + 19, deepslate_bricks, 1, 2);
		world.setBlock(i + 19, j + 26, k + 19, deepslate_bricks, 0, 2);
		world.setBlock(i + 20, j + 26, k + 19, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 26, k + 20, deepslate_bricks, 1, 2);
		world.setBlock(i + 17, j + 26, k + 20, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 26, k + 20, deepslate_bricks, 1, 2);
		world.setBlock(i + 19, j + 26, k + 20, deepslate_bricks, 1, 2);
		world.setBlock(i + 20, j + 26, k + 20, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 26, k + 21, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 26, k + 21, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 26, k + 21, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 26, k + 21, deepslate_bricks, 1, 2);
		world.setBlock(i + 17, j + 26, k + 22, deepslate_bricks, 3, 2);
		world.setBlock(i + 18, j + 26, k + 22, deepslate_bricks, 2, 2);
		world.setBlock(i + 19, j + 26, k + 22, deepslate_bricks, 2, 2);
		world.setBlock(i + 20, j + 26, k + 22, deepslate_bricks, 1, 2);
		world.setBlock(i + 17, j + 26, k + 23, deepslate_bricks, 2, 2);
		world.setBlock(i + 18, j + 26, k + 23, deepslate_bricks, 2, 2);
		world.setBlock(i + 19, j + 26, k + 23, deepslate_bricks, 2, 2);
		world.setBlock(i + 20, j + 26, k + 23, deepslate_bricks, 1, 2);
		world.setBlock(i + 16, j + 26, k + 24, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 26, k + 24, deepslate_bricks, 2, 2);
		world.setBlock(i + 18, j + 26, k + 24, deepslate_bricks, 3, 2);
		world.setBlock(i + 19, j + 26, k + 24, deepslate_bricks, 2, 2);
		world.setBlock(i + 20, j + 26, k + 24, deepslate_bricks, 1, 2);
		world.setBlock(i + 16, j + 26, k + 25, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 26, k + 25, deepslate_bricks, 3, 2);
		world.setBlock(i + 18, j + 26, k + 25, deepslate_bricks, 2, 2);
		world.setBlock(i + 19, j + 26, k + 25, deepslate_bricks, 2, 2);
		world.setBlock(i + 20, j + 26, k + 25, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 26, k + 26, deepslate_bricks, 1, 2);
		world.setBlock(i + 17, j + 26, k + 26, deepslate_bricks, 2, 2);
		world.setBlock(i + 18, j + 26, k + 26, deepslate_bricks, 2, 2);
		world.setBlock(i + 19, j + 26, k + 26, deepslate_bricks, 2, 2);
		world.setBlock(i + 20, j + 26, k + 26, deepslate_bricks, 1, 2);
		world.setBlock(i + 16, j + 26, k + 27, deepslate_bricks, 1, 2);
		world.setBlock(i + 17, j + 26, k + 27, deepslate_bricks, 2, 2);
		world.setBlock(i + 18, j + 26, k + 27, deepslate_bricks, 2, 2);
		world.setBlock(i + 19, j + 26, k + 27, deepslate_bricks, 2, 2);
		world.setBlock(i + 20, j + 26, k + 27, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 26, k + 28, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 26, k + 28, deepslate_bricks, 3, 2);
		world.setBlock(i + 18, j + 26, k + 28, deepslate_bricks, 3, 2);
		world.setBlock(i + 19, j + 26, k + 28, deepslate_bricks, 2, 2);
		world.setBlock(i + 20, j + 26, k + 28, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 26, k + 29, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 26, k + 29, deepslate_bricks, 2, 2);
		world.setBlock(i + 18, j + 26, k + 29, deepslate_bricks, 2, 2);
		world.setBlock(i + 19, j + 26, k + 29, deepslate_bricks, 2, 2);
		world.setBlock(i + 20, j + 26, k + 29, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 26, k + 30, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 26, k + 30, deepslate_bricks, 3, 2);
		world.setBlock(i + 18, j + 26, k + 30, deepslate_bricks, 3, 2);
		world.setBlock(i + 19, j + 26, k + 30, deepslate_bricks, 2, 2);
		world.setBlock(i + 20, j + 26, k + 30, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 26, k + 31, deepslate_bricks, 1, 2);
		world.setBlock(i + 17, j + 26, k + 31, deepslate_bricks, 3, 2);
		world.setBlock(i + 18, j + 26, k + 31, deepslate_bricks, 2, 2);
		world.setBlock(i + 19, j + 26, k + 31, deepslate_bricks, 3, 2);
		world.setBlock(i + 20, j + 26, k + 31, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 26, k + 32, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 26, k + 32, deepslate_bricks, 2, 2);
		world.setBlock(i + 18, j + 26, k + 32, deepslate_bricks, 2, 2);
		world.setBlock(i + 19, j + 26, k + 32, deepslate_bricks, 2, 2);
		world.setBlock(i + 20, j + 26, k + 32, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 26, k + 33, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 26, k + 33, deepslate_bricks, 2, 2);
		world.setBlock(i + 18, j + 26, k + 33, deepslate_bricks, 2, 2);
		world.setBlock(i + 19, j + 26, k + 33, deepslate_bricks, 2, 2);
		world.setBlock(i + 20, j + 26, k + 33, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 26, k + 34, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 26, k + 34, deepslate_bricks, 3, 2);
		world.setBlock(i + 18, j + 26, k + 34, deepslate_bricks, 2, 2);
		world.setBlock(i + 19, j + 26, k + 34, deepslate_bricks, 2, 2);
		world.setBlock(i + 20, j + 26, k + 34, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 26, k + 35, deepslate_bricks, 1, 2);
		world.setBlock(i + 17, j + 26, k + 35, deepslate_bricks, 2, 2);
		world.setBlock(i + 18, j + 26, k + 35, deepslate_bricks, 2, 2);
		world.setBlock(i + 19, j + 26, k + 35, deepslate_bricks, 3, 2);
		world.setBlock(i + 20, j + 26, k + 35, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 26, k + 36, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 26, k + 36, deepslate_bricks, 3, 2);
		world.setBlock(i + 18, j + 26, k + 36, deepslate_bricks, 2, 2);
		world.setBlock(i + 19, j + 26, k + 36, deepslate_bricks, 2, 2);
		world.setBlock(i + 20, j + 26, k + 36, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 26, k + 37, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 26, k + 37, deepslate_bricks, 3, 2);
		world.setBlock(i + 18, j + 26, k + 37, deepslate_bricks, 2, 2);
		world.setBlock(i + 19, j + 26, k + 37, deepslate_bricks, 2, 2);
		world.setBlock(i + 20, j + 26, k + 37, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 26, k + 38, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 26, k + 38, deepslate_bricks, 3, 2);
		world.setBlock(i + 18, j + 26, k + 38, deepslate_bricks, 3, 2);
		world.setBlock(i + 19, j + 26, k + 38, deepslate_bricks, 2, 2);
		world.setBlock(i + 20, j + 26, k + 38, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 26, k + 39, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 26, k + 39, deepslate_bricks, 3, 2);
		world.setBlock(i + 18, j + 26, k + 39, deepslate_bricks, 2, 2);
		world.setBlock(i + 19, j + 26, k + 39, deepslate_bricks, 3, 2);
		world.setBlock(i + 20, j + 26, k + 39, deepslate_bricks, 1, 2);
		world.setBlock(i + 16, j + 26, k + 40, deepslate_bricks, 1, 2);
		world.setBlock(i + 17, j + 26, k + 40, deepslate_bricks, 2, 2);
		world.setBlock(i + 18, j + 26, k + 40, deepslate_bricks, 2, 2);
		world.setBlock(i + 19, j + 26, k + 40, deepslate_bricks, 2, 2);
		world.setBlock(i + 20, j + 26, k + 40, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 26, k + 41, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 26, k + 41, deepslate_bricks, 2, 2);
		world.setBlock(i + 18, j + 26, k + 41, deepslate_bricks, 2, 2);
		world.setBlock(i + 19, j + 26, k + 41, deepslate_bricks, 2, 2);
		world.setBlock(i + 20, j + 26, k + 41, deepslate_bricks, 1, 2);
		world.setBlock(i + 16, j + 26, k + 42, deepslate_bricks, 1, 2);
		world.setBlock(i + 17, j + 26, k + 42, deepslate_bricks, 2, 2);
		world.setBlock(i + 18, j + 26, k + 42, deepslate_bricks, 3, 2);
		world.setBlock(i + 19, j + 26, k + 42, deepslate_bricks, 2, 2);
		world.setBlock(i + 20, j + 26, k + 42, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 26, k + 43, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 26, k + 43, deepslate_bricks, 3, 2);
		world.setBlock(i + 18, j + 26, k + 43, deepslate_bricks, 2, 2);
		world.setBlock(i + 19, j + 26, k + 43, deepslate_bricks, 2, 2);
		world.setBlock(i + 20, j + 26, k + 43, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 26, k + 44, deepslate_bricks, 1, 2);
		world.setBlock(i + 17, j + 26, k + 44, deepslate_bricks, 2, 2);
		world.setBlock(i + 18, j + 26, k + 44, deepslate_bricks, 2, 2);
		world.setBlock(i + 19, j + 26, k + 44, deepslate_bricks, 3, 2);
		world.setBlock(i + 20, j + 26, k + 44, deepslate_bricks, 1, 2);
		world.setBlock(i + 16, j + 26, k + 45, deepslate_bricks, 1, 2);
		world.setBlock(i + 17, j + 26, k + 45, deepslate_bricks, 2, 2);
		world.setBlock(i + 18, j + 26, k + 45, deepslate_bricks, 2, 2);
		world.setBlock(i + 19, j + 26, k + 45, deepslate_bricks, 2, 2);
		world.setBlock(i + 20, j + 26, k + 45, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 26, k + 46, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 26, k + 46, deepslate_bricks, 3, 2);
		world.setBlock(i + 18, j + 26, k + 46, deepslate_bricks, 2, 2);
		world.setBlock(i + 20, j + 26, k + 46, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 26, k + 47, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 26, k + 47, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 26, k + 47, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 26, k + 47, deepslate_bricks, 0, 2);
		world.setBlock(i + 20, j + 26, k + 47, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 26, k + 48, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 26, k + 48, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 26, k + 48, cobbled_deepslate, 0, 2);
		world.setBlock(i + 19, j + 26, k + 48, cobbled_deepslate, 0, 2);
		world.setBlock(i + 20, j + 26, k + 48, cobbled_deepslate, 0, 2);
		world.setBlock(i + 16, j + 26, k + 49, cobbled_deepslate, 0, 2);
		world.setBlock(i + 17, j + 26, k + 49, cobbled_deepslate, 0, 2);
		world.setBlock(i + 18, j + 26, k + 49, cobbled_deepslate, 0, 2);
		world.setBlock(i + 19, j + 26, k + 49, cobbled_deepslate, 0, 2);
		world.setBlock(i + 20, j + 26, k + 49, cobbled_deepslate, 0, 2);
		world.setBlock(i + 16, j + 27, k + 18, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 27, k + 18, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 27, k + 18, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 27, k + 18, deepslate_bricks, 1, 2);
		world.setBlock(i + 20, j + 27, k + 18, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 27, k + 19, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 27, k + 19, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 27, k + 19, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 27, k + 19, deepslate_bricks, 0, 2);
		world.setBlock(i + 20, j + 27, k + 19, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 27, k + 20, deepslate_bricks, 3, 2);
		world.setBlock(i + 17, j + 27, k + 20, deepslate_bricks, 3, 2);
		world.setBlock(i + 18, j + 27, k + 20, deepslate_bricks, 2, 2);
		world.setBlock(i + 19, j + 27, k + 20, deepslate_bricks, 2, 2);
		world.setBlock(i + 20, j + 27, k + 20, deepslate_bricks, 2, 2);
		world.setBlock(i + 16, j + 27, k + 21, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 27, k + 21, deepslate_bricks, 1, 2);
		world.setBlock(i + 18, j + 27, k + 21, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 27, k + 21, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 27, k + 22, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 27, k + 22, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 27, k + 22, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 27, k + 22, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 27, k + 23, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 27, k + 23, deepslate_bricks, 1, 2);
		world.setBlock(i + 18, j + 27, k + 23, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 27, k + 23, deepslate_bricks, 0, 2);
		world.setBlock(i + 20, j + 27, k + 23, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 27, k + 24, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 27, k + 24, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 27, k + 24, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 27, k + 24, deepslate_bricks, 0, 2);
		world.setBlock(i + 20, j + 27, k + 24, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 27, k + 25, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 27, k + 25, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 27, k + 25, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 27, k + 25, deepslate_bricks, 0, 2);
		world.setBlock(i + 20, j + 27, k + 25, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 27, k + 26, deepslate_bricks, 1, 2);
		world.setBlock(i + 17, j + 27, k + 26, deepslate_bricks, 1, 2);
		world.setBlock(i + 18, j + 27, k + 26, deepslate_bricks, 1, 2);
		world.setBlock(i + 19, j + 27, k + 26, deepslate_bricks, 1, 2);
		world.setBlock(i + 20, j + 27, k + 26, deepslate_bricks, 1, 2);
		world.setBlock(i + 16, j + 27, k + 27, deepslate_bricks, 1, 2);
		world.setBlock(i + 17, j + 27, k + 27, deepslate_bricks, 1, 2);
		world.setBlock(i + 18, j + 27, k + 27, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 27, k + 27, deepslate_bricks, 1, 2);
		world.setBlock(i + 20, j + 27, k + 27, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 27, k + 28, deepslate_bricks, 1, 2);
		world.setBlock(i + 17, j + 27, k + 28, deepslate_bricks, 1, 2);
		world.setBlock(i + 18, j + 27, k + 28, deepslate_bricks, 1, 2);
		world.setBlock(i + 19, j + 27, k + 28, deepslate_bricks, 1, 2);
		world.setBlock(i + 20, j + 27, k + 28, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 27, k + 29, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 27, k + 29, deepslate_bricks, 1, 2);
		world.setBlock(i + 18, j + 27, k + 29, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 27, k + 29, deepslate_bricks, 0, 2);
		world.setBlock(i + 20, j + 27, k + 29, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 27, k + 30, deepslate_bricks, 2, 2);
		world.setBlock(i + 17, j + 27, k + 30, deepslate_bricks, 3, 2);
		world.setBlock(i + 18, j + 27, k + 30, deepslate_bricks, 3, 2);
		world.setBlock(i + 19, j + 27, k + 30, deepslate_bricks, 2, 2);
		world.setBlock(i + 20, j + 27, k + 30, deepslate_bricks, 3, 2);
		world.setBlock(i + 16, j + 27, k + 31, deepslate_bricks, 2, 2);
		world.setBlock(i + 17, j + 27, k + 31, deepslate_bricks, 2, 2);
		world.setBlock(i + 18, j + 27, k + 31, deepslate_bricks, 2, 2);
		world.setBlock(i + 19, j + 27, k + 31, deepslate_bricks, 3, 2);
		world.setBlock(i + 20, j + 27, k + 31, deepslate_bricks, 2, 2);
		world.setBlock(i + 16, j + 27, k + 32, deepslate_bricks, 2, 2);
		world.setBlock(i + 17, j + 27, k + 32, deepslate_bricks, 2, 2);
		world.setBlock(i + 18, j + 27, k + 32, deepslate_bricks, 2, 2);
		world.setBlock(i + 19, j + 27, k + 32, deepslate_bricks, 2, 2);
		world.setBlock(i + 20, j + 27, k + 32, deepslate_bricks, 3, 2);
		world.setBlock(i + 16, j + 27, k + 33, deepslate_bricks, 2, 2);
		world.setBlock(i + 17, j + 27, k + 33, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 27, k + 33, deepslate_bricks, 1, 2);
		world.setBlock(i + 19, j + 27, k + 33, deepslate_bricks, 1, 2);
		world.setBlock(i + 20, j + 27, k + 33, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 27, k + 34, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 27, k + 34, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 27, k + 34, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 27, k + 34, deepslate_bricks, 0, 2);
		world.setBlock(i + 20, j + 27, k + 34, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 27, k + 35, deepslate_bricks, 1, 2);
		world.setBlock(i + 17, j + 27, k + 35, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 27, k + 35, deepslate_bricks, 1, 2);
		world.setBlock(i + 19, j + 27, k + 35, deepslate_bricks, 0, 2);
		world.setBlock(i + 20, j + 27, k + 35, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 27, k + 36, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 27, k + 36, deepslate_bricks, 1, 2);
		world.setBlock(i + 18, j + 27, k + 36, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 27, k + 36, deepslate_bricks, 0, 2);
		world.setBlock(i + 20, j + 27, k + 36, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 27, k + 37, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 27, k + 37, deepslate_bricks, 1, 2);
		world.setBlock(i + 18, j + 27, k + 37, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 27, k + 37, deepslate_bricks, 0, 2);
		world.setBlock(i + 20, j + 27, k + 37, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 27, k + 38, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 27, k + 38, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 27, k + 38, deepslate_bricks, 1, 2);
		world.setBlock(i + 19, j + 27, k + 38, deepslate_bricks, 0, 2);
		world.setBlock(i + 20, j + 27, k + 38, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 27, k + 39, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 27, k + 39, deepslate_bricks, 1, 2);
		world.setBlock(i + 18, j + 27, k + 39, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 27, k + 39, deepslate_bricks, 0, 2);
		world.setBlock(i + 20, j + 27, k + 39, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 27, k + 40, deepslate_bricks, 1, 2);
		world.setBlock(i + 17, j + 27, k + 40, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 27, k + 40, deepslate_bricks, 1, 2);
		world.setBlock(i + 19, j + 27, k + 40, deepslate_bricks, 0, 2);
		world.setBlock(i + 20, j + 27, k + 40, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 27, k + 41, deepslate_bricks, 1, 2);
		world.setBlock(i + 17, j + 27, k + 41, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 27, k + 41, deepslate_bricks, 1, 2);
		world.setBlock(i + 19, j + 27, k + 41, deepslate_bricks, 1, 2);
		world.setBlock(i + 20, j + 27, k + 41, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 27, k + 42, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 27, k + 42, deepslate_bricks, 1, 2);
		world.setBlock(i + 18, j + 27, k + 42, deepslate_bricks, 1, 2);
		world.setBlock(i + 19, j + 27, k + 42, deepslate_bricks, 0, 2);
		world.setBlock(i + 20, j + 27, k + 42, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 27, k + 43, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 27, k + 43, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 27, k + 43, deepslate_bricks, 1, 2);
		world.setBlock(i + 19, j + 27, k + 43, deepslate_bricks, 0, 2);
		world.setBlock(i + 20, j + 27, k + 43, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 27, k + 44, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 27, k + 44, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 27, k + 44, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 27, k + 44, deepslate_bricks, 0, 2);
		world.setBlock(i + 20, j + 27, k + 44, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 27, k + 45, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 27, k + 45, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 27, k + 45, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 27, k + 45, deepslate_bricks, 0, 2);
		world.setBlock(i + 20, j + 27, k + 45, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 27, k + 46, deepslate_bricks, 1, 2);
		world.setBlock(i + 17, j + 27, k + 46, deepslate_bricks, 1, 2);
		world.setBlock(i + 18, j + 27, k + 46, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 27, k + 46, deepslate_bricks, 0, 2);
		world.setBlock(i + 20, j + 27, k + 46, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 27, k + 47, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 27, k + 47, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 27, k + 47, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 27, k + 47, deepslate_bricks, 1, 2);
		world.setBlock(i + 20, j + 27, k + 47, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 27, k + 48, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 27, k + 48, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 27, k + 48, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 27, k + 48, deepslate_bricks, 0, 2);
		world.setBlock(i + 20, j + 27, k + 48, cobbled_deepslate, 0, 2);
		world.setBlock(i + 16, j + 27, k + 49, cobbled_deepslate, 0, 2);
		world.setBlock(i + 17, j + 27, k + 49, cobbled_deepslate, 0, 2);
		world.setBlock(i + 18, j + 27, k + 49, cobbled_deepslate, 0, 2);
		world.setBlock(i + 19, j + 27, k + 49, cobbled_deepslate, 0, 2);
		world.setBlock(i + 20, j + 27, k + 49, cobbled_deepslate, 0, 2);
		world.setBlock(i + 16, j + 28, k + 18, deepslate_bricks, 2, 2);
		world.setBlock(i + 17, j + 28, k + 18, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 28, k + 19, deepslate_bricks, 2, 2);
		world.setBlock(i + 17, j + 28, k + 19, deepslate_bricks, 2, 2);
		world.setBlock(i + 18, j + 28, k + 19, deepslate_bricks, 2, 2);
		world.setBlock(i + 16, j + 28, k + 20, deepslate_bricks, 3, 2);
		world.setBlock(i + 17, j + 28, k + 20, deepslate_bricks, 2, 2);
		world.setBlock(i + 18, j + 28, k + 20, deepslate_bricks, 2, 2);
		world.setBlock(i + 19, j + 28, k + 20, deepslate_bricks, 3, 2);
		world.setBlock(i + 20, j + 28, k + 20, deepslate_bricks, 2, 2);
		world.setBlock(i + 16, j + 28, k + 21, deepslate_bricks, 3, 2);
		world.setBlock(i + 17, j + 28, k + 21, deepslate_bricks, 3, 2);
		world.setBlock(i + 18, j + 28, k + 21, deepslate_bricks, 3, 2);
		world.setBlock(i + 19, j + 28, k + 21, deepslate_bricks, 2, 2);
		world.setBlock(i + 16, j + 28, k + 22, deepslate_bricks, 1, 2);
		world.setBlock(i + 17, j + 28, k + 22, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 28, k + 22, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 28, k + 22, deepslate_bricks, 1, 2);
		world.setBlock(i + 16, j + 28, k + 23, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 28, k + 23, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 28, k + 23, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 28, k + 23, deepslate_bricks, 0, 2);
		world.setBlock(i + 20, j + 28, k + 23, deepslate_bricks, 1, 2);
		world.setBlock(i + 16, j + 28, k + 24, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 28, k + 24, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 28, k + 24, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 28, k + 24, deepslate_bricks, 1, 2);
		world.setBlock(i + 20, j + 28, k + 24, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 28, k + 25, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 28, k + 25, deepslate_bricks, 2, 2);
		world.setBlock(i + 18, j + 28, k + 25, deepslate_bricks, 3, 2);
		world.setBlock(i + 19, j + 28, k + 25, deepslate_bricks, 2, 2);
		world.setBlock(i + 20, j + 28, k + 25, deepslate_bricks, 3, 2);
		world.setBlock(i + 16, j + 28, k + 26, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 28, k + 26, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 28, k + 26, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 28, k + 26, deepslate_bricks, 0, 2);
		world.setBlock(i + 20, j + 28, k + 26, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 28, k + 27, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 28, k + 27, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 28, k + 27, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 28, k + 27, deepslate_bricks, 0, 2);
		world.setBlock(i + 20, j + 28, k + 27, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 28, k + 28, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 28, k + 28, deepslate_bricks, 1, 2);
		world.setBlock(i + 18, j + 28, k + 28, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 28, k + 28, deepslate_bricks, 0, 2);
		world.setBlock(i + 20, j + 28, k + 28, deepslate_bricks, 1, 2);











































		world.setBlock(i + 16, j + 28, k + 29, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 28, k + 29, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 28, k + 29, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 28, k + 29, deepslate_bricks, 0, 2);
		world.setBlock(i + 20, j + 28, k + 29, deepslate_bricks, 1, 2);
		world.setBlock(i + 16, j + 28, k + 30, deepslate_bricks, 1, 2);
		world.setBlock(i + 17, j + 28, k + 30, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 28, k + 30, deepslate_bricks, 2, 2);
		world.setBlock(i + 19, j + 28, k + 30, deepslate_bricks, 3, 2);
		world.setBlock(i + 20, j + 28, k + 30, deepslate_bricks, 2, 2);
		world.setBlock(i + 16, j + 28, k + 31, deepslate_bricks, 3, 2);
		world.setBlock(i + 17, j + 28, k + 31, deepslate_bricks, 1, 2);
		world.setBlock(i + 18, j + 28, k + 31, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 28, k + 31, deepslate_bricks, 0, 2);
		world.setBlock(i + 20, j + 28, k + 31, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 28, k + 32, deepslate_bricks, 1, 2);
		world.setBlock(i + 17, j + 28, k + 32, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 28, k + 32, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 28, k + 32, deepslate_bricks, 0, 2);
		world.setBlock(i + 20, j + 28, k + 32, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 28, k + 33, deepslate_bricks, 1, 2);
		world.setBlock(i + 17, j + 28, k + 33, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 28, k + 33, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 28, k + 33, deepslate_bricks, 0, 2);
		world.setBlock(i + 20, j + 28, k + 33, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 28, k + 34, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 28, k + 34, deepslate_bricks, 1, 2);
		world.setBlock(i + 18, j + 28, k + 34, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 28, k + 34, deepslate_bricks, 1, 2);
		world.setBlock(i + 20, j + 28, k + 34, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 28, k + 35, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 28, k + 35, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 28, k + 35, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 28, k + 35, deepslate_bricks, 1, 2);
		world.setBlock(i + 20, j + 28, k + 35, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 28, k + 36, deepslate_bricks, 1, 2);
		world.setBlock(i + 17, j + 28, k + 36, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 28, k + 36, deepslate_bricks, 1, 2);
		world.setBlock(i + 19, j + 28, k + 36, deepslate_bricks, 0, 2);
		world.setBlock(i + 20, j + 28, k + 36, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 28, k + 37, deepslate_bricks, 1, 2);
		world.setBlock(i + 17, j + 28, k + 37, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 28, k + 37, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 28, k + 37, deepslate_bricks, 0, 2);
		world.setBlock(i + 20, j + 28, k + 37, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 28, k + 38, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 28, k + 38, deepslate_bricks, 1, 2);
		world.setBlock(i + 18, j + 28, k + 38, deepslate_bricks, 1, 2);
		world.setBlock(i + 19, j + 28, k + 38, deepslate_bricks, 1, 2);
		world.setBlock(i + 20, j + 28, k + 38, deepslate_bricks, 1, 2);
		world.setBlock(i + 16, j + 28, k + 39, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 28, k + 39, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 28, k + 39, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 28, k + 39, deepslate_bricks, 1, 2);
		world.setBlock(i + 20, j + 28, k + 39, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 28, k + 40, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 28, k + 40, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 28, k + 40, deepslate_bricks, 1, 2);
		world.setBlock(i + 19, j + 28, k + 40, deepslate_bricks, 0, 2);
		world.setBlock(i + 20, j + 28, k + 40, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 28, k + 41, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 28, k + 41, deepslate_bricks, 1, 2);
		world.setBlock(i + 18, j + 28, k + 41, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 28, k + 41, deepslate_bricks, 1, 2);
		world.setBlock(i + 20, j + 28, k + 41, deepslate_bricks, 1, 2);
		world.setBlock(i + 16, j + 28, k + 42, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 28, k + 42, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 28, k + 42, deepslate_bricks, 1, 2);
		world.setBlock(i + 19, j + 28, k + 42, deepslate_bricks, 1, 2);
		world.setBlock(i + 20, j + 28, k + 42, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 28, k + 43, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 28, k + 43, deepslate_bricks, 1, 2);
		world.setBlock(i + 18, j + 28, k + 43, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 28, k + 43, deepslate_bricks, 0, 2);
		world.setBlock(i + 20, j + 28, k + 43, deepslate_bricks, 1, 2);
		world.setBlock(i + 16, j + 28, k + 44, deepslate_bricks, 1, 2);
		world.setBlock(i + 17, j + 28, k + 44, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 28, k + 44, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 28, k + 44, deepslate_bricks, 0, 2);
		world.setBlock(i + 20, j + 28, k + 44, deepslate_bricks, 1, 2);
		world.setBlock(i + 16, j + 28, k + 45, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 28, k + 45, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 28, k + 45, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 28, k + 45, deepslate_bricks, 0, 2);
		world.setBlock(i + 20, j + 28, k + 45, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 28, k + 46, deepslate_bricks, 1, 2);
		world.setBlock(i + 17, j + 28, k + 46, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 28, k + 46, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 28, k + 46, deepslate_bricks, 0, 2);
		world.setBlock(i + 20, j + 28, k + 46, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 28, k + 47, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 28, k + 47, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 28, k + 47, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 28, k + 47, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 28, k + 48, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 28, k + 48, deepslate_bricks, 1, 2);
		world.setBlock(i + 18, j + 28, k + 48, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 28, k + 48, deepslate_bricks, 0, 2);
		world.setBlock(i + 20, j + 28, k + 48, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 28, k + 49, cobbled_deepslate, 0, 2);
		world.setBlock(i + 17, j + 28, k + 49, cobbled_deepslate, 0, 2);
		world.setBlock(i + 18, j + 28, k + 49, cobbled_deepslate, 0, 2);
		world.setBlock(i + 19, j + 28, k + 49, cobbled_deepslate, 0, 2);
		world.setBlock(i + 20, j + 28, k + 49, cobbled_deepslate, 0, 2);
		world.setBlock(i + 16, j + 29, k + 20, deepslate_bricks, 2, 2);
		world.setBlock(i + 17, j + 29, k + 20, deepslate_bricks, 2, 2);
		world.setBlock(i + 18, j + 29, k + 20, deepslate_bricks, 2, 2);
		world.setBlock(i + 19, j + 29, k + 20, deepslate_bricks, 2, 2);
		world.setBlock(i + 20, j + 29, k + 20, deepslate_bricks, 2, 2);
		world.setBlock(i + 16, j + 29, k + 21, deepslate_bricks, 2, 2);
		world.setBlock(i + 17, j + 29, k + 21, deepslate_bricks, 3, 2);
		world.setBlock(i + 18, j + 29, k + 21, deepslate_bricks, 2, 2);
		world.setBlock(i + 19, j + 29, k + 21, deepslate_bricks, 2, 2);
		world.setBlock(i + 20, j + 29, k + 21, deepslate_bricks, 2, 2);
		world.setBlock(i + 16, j + 29, k + 22, deepslate_bricks, 3, 2);
		world.setBlock(i + 17, j + 29, k + 22, deepslate_bricks, 2, 2);
		world.setBlock(i + 18, j + 29, k + 22, deepslate_bricks, 2, 2);
		world.setBlock(i + 19, j + 29, k + 22, deepslate_bricks, 2, 2);
		world.setBlock(i + 20, j + 29, k + 22, deepslate_bricks, 2, 2);
		world.setBlock(i + 16, j + 29, k + 23, deepslate_bricks, 3, 2);
		world.setBlock(i + 17, j + 29, k + 23, deepslate_bricks, 2, 2);
		world.setBlock(i + 18, j + 29, k + 23, deepslate_bricks, 2, 2);
		world.setBlock(i + 19, j + 29, k + 23, deepslate_bricks, 3, 2);
		world.setBlock(i + 20, j + 29, k + 23, deepslate_bricks, 2, 2);
		world.setBlock(i + 16, j + 29, k + 24, deepslate_bricks, 2, 2);
		world.setBlock(i + 17, j + 29, k + 24, deepslate_bricks, 2, 2);
		world.setBlock(i + 18, j + 29, k + 24, deepslate_bricks, 3, 2);
		world.setBlock(i + 19, j + 29, k + 24, deepslate_bricks, 2, 2);
		world.setBlock(i + 20, j + 29, k + 24, deepslate_bricks, 3, 2);
		world.setBlock(i + 16, j + 29, k + 25, deepslate_bricks, 2, 2);
		world.setBlock(i + 17, j + 29, k + 25, deepslate_bricks, 2, 2);
		world.setBlock(i + 18, j + 29, k + 25, deepslate_bricks, 2, 2);
		world.setBlock(i + 19, j + 29, k + 25, deepslate_bricks, 2, 2);
		world.setBlock(i + 20, j + 29, k + 25, deepslate_bricks, 2, 2);
		world.setBlock(i + 17, j + 29, k + 26, deepslate_bricks, 2, 2);
		world.setBlock(i + 18, j + 29, k + 26, deepslate_bricks, 2, 2);
		world.setBlock(i + 19, j + 29, k + 26, deepslate_bricks, 3, 2);
		world.setBlock(i + 20, j + 29, k + 26, deepslate_bricks, 2, 2);
		world.setBlock(i + 16, j + 29, k + 27, deepslate_bricks, 3, 2);
		world.setBlock(i + 17, j + 29, k + 27, deepslate_bricks, 3, 2);
		world.setBlock(i + 18, j + 29, k + 27, deepslate_bricks, 2, 2);
		world.setBlock(i + 19, j + 29, k + 27, deepslate_bricks, 2, 2);
		world.setBlock(i + 20, j + 29, k + 27, deepslate_bricks, 2, 2);
		world.setBlock(i + 16, j + 29, k + 28, deepslate_bricks, 2, 2);
		world.setBlock(i + 17, j + 29, k + 28, deepslate_bricks, 3, 2);
		world.setBlock(i + 18, j + 29, k + 28, deepslate_bricks, 2, 2);
		world.setBlock(i + 19, j + 29, k + 28, deepslate_bricks, 2, 2);
		world.setBlock(i + 20, j + 29, k + 28, deepslate_bricks, 1, 2);
		world.setBlock(i + 16, j + 29, k + 29, deepslate_bricks, 3, 2);
		world.setBlock(i + 17, j + 29, k + 29, deepslate_bricks, 2, 2);
		world.setBlock(i + 18, j + 29, k + 29, deepslate_bricks, 2, 2);
		world.setBlock(i + 19, j + 29, k + 29, deepslate_bricks, 3, 2);
		world.setBlock(i + 20, j + 29, k + 29, deepslate_bricks, 3, 2);
		world.setBlock(i + 16, j + 29, k + 30, deepslate_bricks, 1, 2);
		world.setBlock(i + 17, j + 29, k + 30, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 29, k + 30, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 29, k + 30, deepslate_bricks, 1, 2);
		world.setBlock(i + 20, j + 29, k + 30, deepslate_bricks, 1, 2);
		world.setBlock(i + 16, j + 29, k + 31, deepslate_bricks, 1, 2);
		world.setBlock(i + 17, j + 29, k + 31, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 29, k + 31, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 29, k + 31, deepslate_bricks, 0, 2);
		world.setBlock(i + 20, j + 29, k + 31, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 29, k + 32, deepslate_bricks, 1, 2);
		world.setBlock(i + 17, j + 29, k + 32, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 29, k + 32, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 29, k + 32, deepslate_bricks, 1, 2);
		world.setBlock(i + 20, j + 29, k + 32, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 29, k + 33, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 29, k + 33, deepslate_bricks, 1, 2);
		world.setBlock(i + 18, j + 29, k + 33, deepslate_bricks, 1, 2);
		world.setBlock(i + 19, j + 29, k + 33, deepslate_bricks, 1, 2);
		world.setBlock(i + 20, j + 29, k + 33, deepslate_bricks, 1, 2);
		world.setBlock(i + 16, j + 29, k + 34, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 29, k + 34, deepslate_bricks, 1, 2);
		world.setBlock(i + 18, j + 29, k + 34, deepslate_bricks, 1, 2);
		world.setBlock(i + 19, j + 29, k + 34, deepslate_bricks, 1, 2);
		world.setBlock(i + 20, j + 29, k + 34, deepslate_bricks, 1, 2);
		world.setBlock(i + 16, j + 29, k + 35, deepslate_bricks, 1, 2);
		world.setBlock(i + 17, j + 29, k + 35, deepslate_bricks, 1, 2);
		world.setBlock(i + 18, j + 29, k + 35, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 29, k + 35, deepslate_bricks, 0, 2);
		world.setBlock(i + 20, j + 29, k + 35, deepslate_bricks, 1, 2);
		world.setBlock(i + 16, j + 29, k + 36, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 29, k + 36, deepslate_bricks, 1, 2);
		world.setBlock(i + 18, j + 29, k + 36, deepslate_bricks, 1, 2);
		world.setBlock(i + 19, j + 29, k + 36, deepslate_bricks, 0, 2);
		world.setBlock(i + 20, j + 29, k + 36, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 29, k + 37, deepslate_bricks, 1, 2);
		world.setBlock(i + 17, j + 29, k + 37, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 29, k + 37, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 29, k + 37, deepslate_bricks, 1, 2);
		world.setBlock(i + 20, j + 29, k + 37, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 29, k + 38, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 29, k + 38, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 29, k + 38, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 29, k + 38, deepslate_bricks, 0, 2);
		world.setBlock(i + 20, j + 29, k + 38, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 29, k + 39, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 29, k + 39, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 29, k + 39, deepslate_bricks, 1, 2);
		world.setBlock(i + 19, j + 29, k + 39, deepslate_bricks, 0, 2);
		world.setBlock(i + 20, j + 29, k + 39, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 29, k + 40, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 29, k + 40, deepslate_bricks, 1, 2);
		world.setBlock(i + 18, j + 29, k + 40, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 29, k + 40, deepslate_bricks, 0, 2);
		world.setBlock(i + 20, j + 29, k + 40, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 29, k + 41, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 29, k + 41, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 29, k + 41, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 29, k + 41, deepslate_bricks, 0, 2);
		world.setBlock(i + 20, j + 29, k + 41, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 29, k + 42, deepslate_bricks, 1, 2);
		world.setBlock(i + 17, j + 29, k + 42, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 29, k + 42, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 29, k + 42, deepslate_bricks, 1, 2);
		world.setBlock(i + 20, j + 29, k + 42, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 29, k + 43, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 29, k + 43, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 29, k + 43, deepslate_bricks, 1, 2);
		world.setBlock(i + 19, j + 29, k + 43, deepslate_bricks, 0, 2);
		world.setBlock(i + 20, j + 29, k + 43, deepslate_bricks, 1, 2);
		world.setBlock(i + 16, j + 29, k + 44, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 29, k + 44, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 29, k + 44, deepslate_bricks, 1, 2);
		world.setBlock(i + 20, j + 29, k + 44, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 29, k + 45, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 29, k + 45, deepslate_bricks, 0, 2);
		world.setBlock(i + 20, j + 29, k + 45, deepslate_bricks, 1, 2);
		world.setBlock(i + 16, j + 29, k + 46, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 29, k + 46, deepslate_bricks, 1, 2);
		world.setBlock(i + 16, j + 29, k + 47, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 29, k + 47, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 29, k + 47, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 29, k + 47, deepslate_bricks, 0, 2);
		world.setBlock(i + 20, j + 29, k + 47, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 29, k + 48, deepslate_bricks, 1, 2);
		world.setBlock(i + 17, j + 29, k + 48, deepslate_bricks, 1, 2);
		world.setBlock(i + 18, j + 29, k + 48, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 29, k + 48, deepslate_bricks, 0, 2);
		world.setBlock(i + 20, j + 29, k + 48, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 29, k + 49, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 29, k + 49, deepslate_bricks, 1, 2);
		world.setBlock(i + 18, j + 29, k + 49, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 29, k + 49, deepslate_bricks, 1, 2);
		world.setBlock(i + 19, j + 30, k + 21, deepslate_bricks, 3, 2);
		world.setBlock(i + 17, j + 30, k + 22, deepslate_bricks, 2, 2);
		world.setBlock(i + 18, j + 30, k + 22, deepslate_bricks, 2, 2);
		world.setBlock(i + 20, j + 30, k + 22, deepslate_bricks, 2, 2);
		world.setBlock(i + 16, j + 30, k + 23, deepslate_bricks, 3, 2);
		world.setBlock(i + 17, j + 30, k + 23, deepslate_bricks, 3, 2);
		world.setBlock(i + 19, j + 30, k + 23, deepslate_bricks, 2, 2);
		world.setBlock(i + 20, j + 30, k + 23, deepslate_bricks, 2, 2);
		world.setBlock(i + 17, j + 30, k + 24, deepslate_bricks, 2, 2);
		world.setBlock(i + 18, j + 30, k + 24, deepslate_bricks, 2, 2);
		world.setBlock(i + 20, j + 30, k + 25, deepslate_bricks, 2, 2);
		world.setBlock(i + 19, j + 30, k + 26, deepslate_bricks, 2, 2);
		world.setBlock(i + 19, j + 30, k + 27, deepslate_bricks, 3, 2);
		world.setBlock(i + 18, j + 30, k + 28, deepslate_bricks, 2, 2);
		world.setBlock(i + 19, j + 30, k + 28, deepslate_bricks, 2, 2);
		world.setBlock(i + 16, j + 30, k + 29, deepslate_bricks, 2, 2);
		world.setBlock(i + 19, j + 30, k + 29, deepslate_bricks, 2, 2);
		world.setBlock(i + 20, j + 30, k + 29, deepslate_bricks, 2, 2);
		world.setBlock(i + 16, j + 30, k + 30, deepslate_bricks, 3, 2);
		world.setBlock(i + 17, j + 30, k + 30, deepslate_bricks, 3, 2);
		world.setBlock(i + 19, j + 30, k + 30, deepslate_bricks, 2, 2);
		world.setBlock(i + 20, j + 30, k + 30, deepslate_bricks, 2, 2);
		world.setBlock(i + 18, j + 30, k + 31, deepslate_bricks, 1, 2);
		world.setBlock(i + 20, j + 30, k + 31, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 30, k + 33, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 30, k + 33, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 30, k + 33, deepslate_bricks, 0, 2);
		world.setBlock(i + 20, j + 30, k + 33, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 30, k + 34, deepslate_bricks, 1, 2);
		world.setBlock(i + 17, j + 30, k + 34, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 30, k + 34, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 30, k + 34, deepslate_bricks, 0, 2);
		world.setBlock(i + 20, j + 30, k + 34, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 30, k + 35, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 30, k + 36, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 30, k + 37, deepslate_bricks, 1, 2);
		world.setBlock(i + 16, j + 30, k + 38, deepslate_bricks, 1, 2);
		world.setBlock(i + 20, j + 30, k + 38, deepslate_bricks, 0, 2);
		world.setBlock(i + 20, j + 30, k + 39, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 30, k + 40, deepslate_bricks, 0, 2);
		world.setBlock(i + 20, j + 30, k + 40, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 30, k + 41, deepslate_bricks, 1, 2);
		world.setBlock(i + 20, j + 30, k + 41, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 30, k + 42, deepslate_bricks, 1, 2);
		world.setBlock(i + 17, j + 30, k + 42, deepslate_bricks, 0, 2);
		world.setBlock(i + 19, j + 30, k + 42, deepslate_bricks, 1, 2);
		world.setBlock(i + 20, j + 30, k + 42, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 30, k + 43, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 30, k + 43, deepslate_bricks, 0, 2);
		world.setBlock(i + 18, j + 30, k + 43, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 30, k + 46, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 30, k + 47, deepslate_bricks, 0, 2);
		world.setBlock(i + 17, j + 30, k + 47, deepslate_bricks, 0, 2);
		world.setBlock(i + 16, j + 30, k + 49, deepslate_bricks, 0, 2);
		
		return true;
	}
}
