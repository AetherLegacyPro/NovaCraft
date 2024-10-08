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

public class AncientCityWardenAltarGen extends WorldGenerator
{
	public AncientCityWardenAltarGen() {

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
		 
		 	world.setBlock(i + 22, j + 0, k + 22, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 24, j + 0, k + 22, NovaCraftBlocks.nullstone_tiled_stairs, 1, 2);
			world.setBlock(i + 22, j + 0, k + 23, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 23, j + 0, k + 23, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 24, j + 0, k + 23, NovaCraftBlocks.nullstone_tiled_stairs, 1, 2);
			world.setBlock(i + 22, j + 0, k + 24, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 23, j + 0, k + 24, sculk_block, 0, 2);
			world.setBlock(i + 22, j + 1, k + 21, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 23, j + 1, k + 21, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 20, j + 1, k + 22, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 21, j + 1, k + 22, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 22, j + 1, k + 22, NovaCraftBlocks.nullstone_tiled_stairs, 1, 2);
			world.setBlock(i + 20, j + 1, k + 23, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 21, j + 1, k + 23, sculk_block, 0, 2);
			world.setBlock(i + 22, j + 1, k + 23, NovaCraftBlocks.nullstone_tiled_stairs, 1, 2);
			world.setBlock(i + 20, j + 1, k + 24, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 22, j + 1, k + 24, NovaCraftBlocks.nullstone_tiled_stairs, 1, 2);
			world.setBlock(i + 22, j + 1, k + 25, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 23, j + 1, k + 25, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 20, j + 2, k + 21, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 21, j + 2, k + 21, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 22, j + 2, k + 21, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 23, j + 2, k + 21, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 18, j + 2, k + 22, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 19, j + 2, k + 22, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 20, j + 2, k + 22, NovaCraftBlocks.nullstone_tiled_stairs, 1, 2);
			world.setBlock(i + 18, j + 2, k + 23, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 19, j + 2, k + 23, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 20, j + 2, k + 23, NovaCraftBlocks.nullstone_tiled_stairs, 1, 2);
			world.setBlock(i + 18, j + 2, k + 24, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 20, j + 2, k + 24, NovaCraftBlocks.nullstone_tiled_stairs, 1, 2);
			world.setBlock(i + 20, j + 2, k + 25, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 21, j + 2, k + 25, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 22, j + 2, k + 25, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 23, j + 2, k + 25, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 18, j + 3, k + 21, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 19, j + 3, k + 21, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 20, j + 3, k + 21, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 21, j + 3, k + 21, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 22, j + 3, k + 21, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 16, j + 3, k + 22, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 17, j + 3, k + 22, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 18, j + 3, k + 22, NovaCraftBlocks.nullstone_tiled_stairs, 1, 2);
			world.setBlock(i + 16, j + 3, k + 23, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 17, j + 3, k + 23, sculk_block, 0, 2);
			world.setBlock(i + 16, j + 3, k + 24, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 18, j + 3, k + 25, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 19, j + 3, k + 25, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 20, j + 3, k + 25, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 21, j + 3, k + 25, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 22, j + 3, k + 25, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 16, j + 4, k + 21, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 17, j + 4, k + 21, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 18, j + 4, k + 21, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 19, j + 4, k + 21, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 20, j + 4, k + 21, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 14, j + 4, k + 22, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 16, j + 4, k + 22, NovaCraftBlocks.nullstone_tiled_stairs, 1, 2);
			world.setBlock(i + 14, j + 4, k + 23, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 15, j + 4, k + 23, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 16, j + 4, k + 23, NovaCraftBlocks.nullstone_tiled_stairs, 1, 2);
			world.setBlock(i + 14, j + 4, k + 24, sculk_block, 0, 2);
			world.setBlock(i + 16, j + 4, k + 24, NovaCraftBlocks.nullstone_tiled_stairs, 1, 2);
			world.setBlock(i + 16, j + 4, k + 25, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 17, j + 4, k + 25, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 18, j + 4, k + 25, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 19, j + 4, k + 25, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 20, j + 4, k + 25, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 6, j + 5, k + 14, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 7, j + 5, k + 14, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 8, j + 5, k + 14, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 5, k + 15, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 7, j + 5, k + 15, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 8, j + 5, k + 15, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 1, j + 5, k + 16, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 3, j + 5, k + 16, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 4, j + 5, k + 16, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 5, j + 5, k + 16, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 5, k + 16, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 7, j + 5, k + 16, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 8, j + 5, k + 16, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 9, j + 5, k + 16, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 10, j + 5, k + 16, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 11, j + 5, k + 16, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 12, j + 5, k + 16, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 0, j + 5, k + 17, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 1, j + 5, k + 17, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 2, j + 5, k + 17, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 3, j + 5, k + 17, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 4, j + 5, k + 17, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 6, j + 5, k + 17, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 7, j + 5, k + 17, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 8, j + 5, k + 17, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 9, j + 5, k + 17, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 11, j + 5, k + 17, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 12, j + 5, k + 17, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 13, j + 5, k + 17, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 0, j + 5, k + 18, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 1, j + 5, k + 18, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 2, j + 5, k + 18, sculk_block, 0, 2);
			world.setBlock(i + 3, j + 5, k + 18, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 4, j + 5, k + 18, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 5, j + 5, k + 18, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 5, k + 18, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 7, j + 5, k + 18, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 8, j + 5, k + 18, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 9, j + 5, k + 18, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 10, j + 5, k + 18, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 11, j + 5, k + 18, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 13, j + 5, k + 18, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 0, j + 5, k + 19, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 1, j + 5, k + 19, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 2, j + 5, k + 19, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 3, j + 5, k + 19, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 4, j + 5, k + 19, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 5, j + 5, k + 19, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 5, k + 19, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 7, j + 5, k + 19, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 8, j + 5, k + 19, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 9, j + 5, k + 19, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 10, j + 5, k + 19, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 11, j + 5, k + 19, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 12, j + 5, k + 19, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 13, j + 5, k + 19, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 0, j + 5, k + 20, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 1, j + 5, k + 20, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 2, j + 5, k + 20, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 3, j + 5, k + 20, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 4, j + 5, k + 20, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 5, j + 5, k + 20, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 6, j + 5, k + 20, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 7, j + 5, k + 20, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 8, j + 5, k + 20, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 9, j + 5, k + 20, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 10, j + 5, k + 20, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 11, j + 5, k + 20, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 12, j + 5, k + 20, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 13, j + 5, k + 20, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 0, j + 5, k + 21, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 2, j + 5, k + 21, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 3, j + 5, k + 21, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 4, j + 5, k + 21, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 5, j + 5, k + 21, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 5, k + 21, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 7, j + 5, k + 21, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 8, j + 5, k + 21, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 9, j + 5, k + 21, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 10, j + 5, k + 21, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 11, j + 5, k + 21, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 12, j + 5, k + 21, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 13, j + 5, k + 21, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 14, j + 5, k + 21, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 15, j + 5, k + 21, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 16, j + 5, k + 21, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 17, j + 5, k + 21, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 18, j + 5, k + 21, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 0, j + 5, k + 22, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 2, j + 5, k + 22, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 3, j + 5, k + 22, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 4, j + 5, k + 22, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 5, j + 5, k + 22, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 6, j + 5, k + 22, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 7, j + 5, k + 22, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 8, j + 5, k + 22, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 9, j + 5, k + 22, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 10, j + 5, k + 22, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 11, j + 5, k + 22, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 12, j + 5, k + 22, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 13, j + 5, k + 22, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 14, j + 5, k + 22, NovaCraftBlocks.nullstone_tiled_stairs, 1, 2);
			world.setBlock(i + 0, j + 5, k + 23, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 1, j + 5, k + 23, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 2, j + 5, k + 23, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 3, j + 5, k + 23, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 4, j + 5, k + 23, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 5, j + 5, k + 23, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 6, j + 5, k + 23, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 7, j + 5, k + 23, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 8, j + 5, k + 23, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 9, j + 5, k + 23, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 10, j + 5, k + 23, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 11, j + 5, k + 23, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 12, j + 5, k + 23, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 13, j + 5, k + 23, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 14, j + 5, k + 23, NovaCraftBlocks.nullstone_tiled_stairs, 1, 2);
			world.setBlock(i + 0, j + 5, k + 24, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 1, j + 5, k + 24, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 2, j + 5, k + 24, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 3, j + 5, k + 24, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 4, j + 5, k + 24, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 5, j + 5, k + 24, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 5, k + 24, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 7, j + 5, k + 24, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 8, j + 5, k + 24, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 9, j + 5, k + 24, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 10, j + 5, k + 24, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 11, j + 5, k + 24, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 13, j + 5, k + 24, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 0, j + 5, k + 25, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 1, j + 5, k + 25, sculk_block, 0, 2);
			world.setBlock(i + 2, j + 5, k + 25, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 3, j + 5, k + 25, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 4, j + 5, k + 25, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 5, j + 5, k + 25, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 6, j + 5, k + 25, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 7, j + 5, k + 25, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 8, j + 5, k + 25, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 9, j + 5, k + 25, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 10, j + 5, k + 25, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 11, j + 5, k + 25, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 12, j + 5, k + 25, sculk_block, 0, 2);
			world.setBlock(i + 13, j + 5, k + 25, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 14, j + 5, k + 25, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 15, j + 5, k + 25, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 16, j + 5, k + 25, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 17, j + 5, k + 25, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 18, j + 5, k + 25, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 0, j + 5, k + 26, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 1, j + 5, k + 26, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 2, j + 5, k + 26, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 3, j + 5, k + 26, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 4, j + 5, k + 26, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 5, j + 5, k + 26, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 5, k + 26, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 7, j + 5, k + 26, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 8, j + 5, k + 26, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 9, j + 5, k + 26, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 10, j + 5, k + 26, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 11, j + 5, k + 26, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 12, j + 5, k + 26, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 13, j + 5, k + 26, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 0, j + 5, k + 27, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 2, j + 5, k + 27, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 3, j + 5, k + 27, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 4, j + 5, k + 27, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 5, j + 5, k + 27, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 5, k + 27, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 7, j + 5, k + 27, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 8, j + 5, k + 27, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 9, j + 5, k + 27, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 10, j + 5, k + 27, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 11, j + 5, k + 27, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 12, j + 5, k + 27, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 13, j + 5, k + 27, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 1, j + 5, k + 28, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 3, j + 5, k + 28, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 4, j + 5, k + 28, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 5, j + 5, k + 28, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 5, k + 28, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 7, j + 5, k + 28, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 8, j + 5, k + 28, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 9, j + 5, k + 28, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 10, j + 5, k + 28, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 11, j + 5, k + 28, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 13, j + 5, k + 28, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 0, j + 5, k + 29, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 1, j + 5, k + 29, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 2, j + 5, k + 29, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 3, j + 5, k + 29, sculk_block, 0, 2);
			world.setBlock(i + 4, j + 5, k + 29, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 5, j + 5, k + 29, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 7, j + 5, k + 29, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 8, j + 5, k + 29, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 9, j + 5, k + 29, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 11, j + 5, k + 29, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 12, j + 5, k + 29, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 13, j + 5, k + 29, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 1, j + 5, k + 30, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 2, j + 5, k + 30, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 3, j + 5, k + 30, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 4, j + 5, k + 30, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 5, j + 5, k + 30, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 7, j + 5, k + 30, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 8, j + 5, k + 30, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 9, j + 5, k + 30, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 10, j + 5, k + 30, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 11, j + 5, k + 30, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 12, j + 5, k + 30, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 6, j + 5, k + 31, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 7, j + 5, k + 31, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 8, j + 5, k + 31, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 5, k + 32, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 7, j + 5, k + 32, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 8, j + 5, k + 32, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 6, k + 12, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 7, j + 6, k + 12, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 8, j + 6, k + 12, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 6, k + 13, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 7, j + 6, k + 13, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 8, j + 6, k + 13, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 6, j + 6, k + 14, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 7, j + 6, k + 14, NovaCraftBlocks.nullstone_tiled_stairs, 3, 2);
			world.setBlock(i + 8, j + 6, k + 14, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 6, j + 6, k + 15, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 8, j + 6, k + 15, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 1, j + 6, k + 16, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 3, j + 6, k + 16, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 4, j + 6, k + 16, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 5, j + 6, k + 16, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 6, j + 6, k + 16, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 8, j + 6, k + 16, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 9, j + 6, k + 16, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 10, j + 6, k + 16, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 11, j + 6, k + 16, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 12, j + 6, k + 16, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 0, j + 6, k + 17, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 1, j + 6, k + 17, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 12, j + 6, k + 17, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 13, j + 6, k + 17, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 0, j + 6, k + 18, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 13, j + 6, k + 18, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 0, j + 6, k + 19, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 3, j + 6, k + 19, NovaCraftBlocks.crystallized_end, 0, 2);
			world.setBlock(i + 4, j + 6, k + 19, NovaCraftBlocks.nullstone, 0, 2);
			world.setBlock(i + 5, j + 6, k + 19, NovaCraftBlocks.nullstone, 0, 2);
			world.setBlock(i + 6, j + 6, k + 19, NovaCraftBlocks.nullstone, 0, 2);
			world.setBlock(i + 8, j + 6, k + 19, NovaCraftBlocks.nullstone, 0, 2);
			world.setBlock(i + 9, j + 6, k + 19, NovaCraftBlocks.nullstone, 0, 2);
			world.setBlock(i + 10, j + 6, k + 19, NovaCraftBlocks.nullstone, 0, 2);
			world.setBlock(i + 11, j + 6, k + 19, NovaCraftBlocks.crystallized_end, 0, 2);
			world.setBlock(i + 13, j + 6, k + 19, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 0, j + 6, k + 20, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 3, j + 6, k + 20, NovaCraftBlocks.nullstone, 0, 2);
			world.setBlock(i + 4, j + 6, k + 20, sculk_block, 0, 2);
			world.setBlock(i + 5, j + 6, k + 20, sculk_block, 0, 2);
			world.setBlock(i + 6, j + 6, k + 20, sculk_block, 0, 2);
			world.setBlock(i + 7, j + 6, k + 20, sculk_block, 0, 2);
			world.setBlock(i + 8, j + 6, k + 20, sculk_block, 0, 2);
			world.setBlock(i + 9, j + 6, k + 20, sculk_block, 0, 2);
			world.setBlock(i + 10, j + 6, k + 20, sculk_block, 0, 2);
			world.setBlock(i + 11, j + 6, k + 20, NovaCraftBlocks.nullstone, 0, 2);
			world.setBlock(i + 13, j + 6, k + 20, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 0, j + 6, k + 21, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 3, j + 6, k + 21, NovaCraftBlocks.nullstone, 0, 2);
			world.setBlock(i + 4, j + 6, k + 21, sculk_block, 0, 2);
			world.setBlock(i + 5, j + 6, k + 21, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 6, j + 6, k + 21, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 9, j + 6, k + 21, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 10, j + 6, k + 21, sculk_block, 0, 2);
			world.setBlock(i + 11, j + 6, k + 21, NovaCraftBlocks.nullstone, 0, 2);
			world.setBlock(i + 13, j + 6, k + 21, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 14, j + 6, k + 21, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 15, j + 6, k + 21, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 16, j + 6, k + 21, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 3, j + 6, k + 22, NovaCraftBlocks.nullstone, 0, 2);
			world.setBlock(i + 4, j + 6, k + 22, sculk_block, 0, 2);
			world.setBlock(i + 6, j + 6, k + 22, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 7, j + 6, k + 22, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 8, j + 6, k + 22, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 9, j + 6, k + 22, NovaCraftBlocks.budding_echo_block, 0, 2);
			world.setBlock(i + 10, j + 6, k + 22, sculk_block, 0, 2);
			world.setBlock(i + 11, j + 6, k + 22, NovaCraftBlocks.nullstone, 0, 2);
			world.setBlock(i + 0, j + 6, k + 23, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 3, j + 6, k + 23, NovaCraftBlocks.block_of_vanite, 0, 2);
			world.setBlock(i + 4, j + 6, k + 23, sculk_block, 0, 2);
			world.setBlock(i + 6, j + 6, k + 23, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 7, j + 6, k + 23, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 8, j + 6, k + 23, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 10, j + 6, k + 23, sculk_block, 0, 2);
			world.setBlock(i + 11, j + 6, k + 23, NovaCraftBlocks.crystallized_end, 0, 2);
			world.setBlock(i + 0, j + 6, k + 24, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 3, j + 6, k + 24, NovaCraftBlocks.nullstone, 0, 2);
			world.setBlock(i + 4, j + 6, k + 24, sculk_block, 0, 2);
			world.setBlock(i + 6, j + 6, k + 24, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 7, j + 6, k + 24, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 8, j + 6, k + 24, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 10, j + 6, k + 24, sculk_block, 0, 2);
			world.setBlock(i + 11, j + 6, k + 24, NovaCraftBlocks.nullstone, 0, 2);
			world.setBlock(i + 0, j + 6, k + 25, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 3, j + 6, k + 25, NovaCraftBlocks.nullstone, 0, 2);
			world.setBlock(i + 4, j + 6, k + 25, sculk_block, 0, 2);
			world.setBlock(i + 5, j + 6, k + 25, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 7, j + 6, k + 25, NovaCraftBlocks.budding_echo_block, 0, 2);
			world.setBlock(i + 9, j + 6, k + 25, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 10, j + 6, k + 25, sculk_block, 0, 2);
			world.setBlock(i + 11, j + 6, k + 25, NovaCraftBlocks.nullstone, 0, 2);
			world.setBlock(i + 13, j + 6, k + 25, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 14, j + 6, k + 25, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 15, j + 6, k + 25, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 16, j + 6, k + 25, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 0, j + 6, k + 26, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 3, j + 6, k + 26, NovaCraftBlocks.nullstone, 0, 2);
			world.setBlock(i + 4, j + 6, k + 26, sculk_block, 0, 2);
			world.setBlock(i + 5, j + 6, k + 26, sculk_block, 0, 2);
			world.setBlock(i + 6, j + 6, k + 26, sculk_block, 0, 2);
			world.setBlock(i + 7, j + 6, k + 26, sculk_block, 0, 2);
			world.setBlock(i + 8, j + 6, k + 26, sculk_block, 0, 2);
			world.setBlock(i + 9, j + 6, k + 26, sculk_block, 0, 2);
			world.setBlock(i + 10, j + 6, k + 26, sculk_block, 0, 2);
			world.setBlock(i + 11, j + 6, k + 26, NovaCraftBlocks.nullstone, 0, 2);
			world.setBlock(i + 13, j + 6, k + 26, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 0, j + 6, k + 27, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 3, j + 6, k + 27, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 4, j + 6, k + 27, NovaCraftBlocks.nullstone, 0, 2);
			world.setBlock(i + 5, j + 6, k + 27, NovaCraftBlocks.nullstone, 0, 2);
			world.setBlock(i + 6, j + 6, k + 27, NovaCraftBlocks.nullstone, 0, 2);
			world.setBlock(i + 7, j + 6, k + 27, NovaCraftBlocks.crystallized_end, 0, 2);
			world.setBlock(i + 8, j + 6, k + 27, NovaCraftBlocks.nullstone, 0, 2);
			world.setBlock(i + 9, j + 6, k + 27, NovaCraftBlocks.nullstone, 0, 2);
			world.setBlock(i + 10, j + 6, k + 27, NovaCraftBlocks.nullstone, 0, 2);
			world.setBlock(i + 11, j + 6, k + 27, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 13, j + 6, k + 27, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 13, j + 6, k + 28, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 0, j + 6, k + 29, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 1, j + 6, k + 29, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 12, j + 6, k + 29, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 13, j + 6, k + 29, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 1, j + 6, k + 30, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 2, j + 6, k + 30, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 3, j + 6, k + 30, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 4, j + 6, k + 30, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 5, j + 6, k + 30, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 8, j + 6, k + 30, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 9, j + 6, k + 30, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 10, j + 6, k + 30, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 11, j + 6, k + 30, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 12, j + 6, k + 30, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 6, j + 6, k + 31, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 8, j + 6, k + 31, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 6, j + 6, k + 32, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 7, j + 6, k + 32, NovaCraftBlocks.nullstone_tiled_stairs, 2, 2);
			world.setBlock(i + 8, j + 6, k + 32, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 6, j + 6, k + 33, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 8, j + 6, k + 33, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 6, j + 6, k + 34, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 7, j + 6, k + 34, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 8, j + 6, k + 34, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 7, k + 10, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 7, j + 7, k + 10, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 8, j + 7, k + 10, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 7, j + 7, k + 11, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 8, j + 7, k + 11, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 7, k + 12, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 7, j + 7, k + 12, NovaCraftBlocks.nullstone_tiled_stairs, 3, 2);
			world.setBlock(i + 8, j + 7, k + 12, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 6, j + 7, k + 13, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 8, j + 7, k + 13, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 6, j + 7, k + 14, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 8, j + 7, k + 14, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 3, j + 7, k + 19, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 5, j + 7, k + 19, NovaCraftBlocks.null_wart, 1, 2);
			world.setBlock(i + 8, j + 7, k + 19, NovaCraftBlocks.null_wart, 1, 2);
			world.setBlock(i + 10, j + 7, k + 19, NovaCraftBlocks.null_wart, 1, 2);
			world.setBlock(i + 11, j + 7, k + 19, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 3, j + 7, k + 20, NovaCraftBlocks.null_wart, 1, 2);
			world.setBlock(i + 5, j + 7, k + 20, NovaCraftBlocks.sculk_tentacle_2, 1, 2);
			world.setBlock(i + 6, j + 7, k + 20, NovaCraftBlocks.sculk_tentacle_2, 1, 2);
			world.setBlock(i + 7, j + 7, k + 20, NovaCraftBlocks.sculk_tentacle_2, 1, 2);
			world.setBlock(i + 11, j + 7, k + 20, NovaCraftBlocks.null_wart, 1, 2);
			world.setBlock(i + 5, j + 7, k + 21, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 9, j + 7, k + 21, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 10, j + 7, k + 21, NovaCraftBlocks.sculk_tentacle_2, 1, 2);
			world.setBlock(i + 11, j + 7, k + 21, NovaCraftBlocks.null_wart, 1, 2);
			world.setBlock(i + 3, j + 7, k + 22, NovaCraftBlocks.null_wart, 1, 2);
			world.setBlock(i + 4, j + 7, k + 22, NovaCraftBlocks.sculk_tentacle_2, 1, 2);
			world.setBlock(i + 9, j + 7, k + 22, NovaCraftBlocks.echo_cluster_2, 1, 2);
			world.setBlock(i + 4, j + 7, k + 23, NovaCraftBlocks.sculk_tentacle_2, 1, 2);
			world.setBlock(i + 7, j + 7, k + 23, NovaCraftBlocks.grimstone_shrieker, 0, 2);
			world.setBlock(i + 10, j + 7, k + 23, NovaCraftBlocks.sculk_tentacle_2, 1, 2);
			world.setBlock(i + 3, j + 7, k + 25, NovaCraftBlocks.null_wart, 1, 2);
			world.setBlock(i + 4, j + 7, k + 25, NovaCraftBlocks.sculk_tentacle_2, 1, 2);
			world.setBlock(i + 5, j + 7, k + 25, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 7, j + 7, k + 25, NovaCraftBlocks.echo_cluster_2, 1, 2);
			world.setBlock(i + 9, j + 7, k + 25, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 10, j + 7, k + 25, NovaCraftBlocks.sculk_tentacle_2, 1, 2);
			world.setBlock(i + 11, j + 7, k + 25, NovaCraftBlocks.null_wart, 1, 2);
			world.setBlock(i + 6, j + 7, k + 26, NovaCraftBlocks.sculk_tentacle_2, 1, 2);
			world.setBlock(i + 7, j + 7, k + 26, NovaCraftBlocks.sculk_tentacle_2, 1, 2);
			world.setBlock(i + 10, j + 7, k + 26, NovaCraftBlocks.sculk_tentacle_2, 1, 2);
			world.setBlock(i + 3, j + 7, k + 27, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 4, j + 7, k + 27, NovaCraftBlocks.null_wart, 1, 2);
			world.setBlock(i + 5, j + 7, k + 27, NovaCraftBlocks.null_wart, 1, 2);
			world.setBlock(i + 7, j + 7, k + 27, NovaCraftBlocks.block_of_vanite, 0, 2);
			world.setBlock(i + 8, j + 7, k + 27, NovaCraftBlocks.null_wart, 1, 2);
			world.setBlock(i + 9, j + 7, k + 27, NovaCraftBlocks.null_wart, 1, 2);
			world.setBlock(i + 11, j + 7, k + 27, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 6, j + 7, k + 32, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 8, j + 7, k + 32, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 6, j + 7, k + 33, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 8, j + 7, k + 33, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 6, j + 7, k + 34, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 7, j + 7, k + 34, NovaCraftBlocks.nullstone_tiled_stairs, 2, 2);
			world.setBlock(i + 8, j + 7, k + 34, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 6, j + 7, k + 35, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 7, j + 7, k + 35, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 8, j + 7, k + 35, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 7, k + 36, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 7, j + 7, k + 36, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 8, j + 7, k + 36, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 3, j + 8, k + 0, sculk_block, 0, 2);
			world.setBlock(i + 4, j + 8, k + 0, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 5, j + 8, k + 0, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 6, j + 8, k + 0, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 7, j + 8, k + 0, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 9, j + 8, k + 0, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 10, j + 8, k + 0, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 11, j + 8, k + 0, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 2, j + 8, k + 1, sculk_block, 0, 2);
			world.setBlock(i + 3, j + 8, k + 1, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 5, j + 8, k + 1, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 6, j + 8, k + 1, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 7, j + 8, k + 1, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 8, j + 8, k + 1, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 9, j + 8, k + 1, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 10, j + 8, k + 1, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 11, j + 8, k + 1, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 12, j + 8, k + 1, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 2, j + 8, k + 2, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 3, j + 8, k + 2, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 4, j + 8, k + 2, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 5, j + 8, k + 2, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 8, k + 2, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 7, j + 8, k + 2, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 8, j + 8, k + 2, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 9, j + 8, k + 2, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 10, j + 8, k + 2, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 11, j + 8, k + 2, sculk_block, 0, 2);
			world.setBlock(i + 12, j + 8, k + 2, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 2, j + 8, k + 3, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 3, j + 8, k + 3, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 4, j + 8, k + 3, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 5, j + 8, k + 3, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 8, k + 3, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 7, j + 8, k + 3, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 8, j + 8, k + 3, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 9, j + 8, k + 3, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 10, j + 8, k + 3, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 11, j + 8, k + 3, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 12, j + 8, k + 3, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 4, j + 8, k + 4, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 5, j + 8, k + 4, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 8, k + 4, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 7, j + 8, k + 4, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 8, j + 8, k + 4, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 9, j + 8, k + 4, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 10, j + 8, k + 4, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 11, j + 8, k + 4, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 12, j + 8, k + 4, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 2, j + 8, k + 5, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 3, j + 8, k + 5, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 4, j + 8, k + 5, sculk_block, 0, 2);
			world.setBlock(i + 5, j + 8, k + 5, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 6, j + 8, k + 5, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 7, j + 8, k + 5, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 8, j + 8, k + 5, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 9, j + 8, k + 5, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 10, j + 8, k + 5, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 2, j + 8, k + 6, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 4, j + 8, k + 6, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 5, j + 8, k + 6, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 8, k + 6, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 7, j + 8, k + 6, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 8, j + 8, k + 6, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 10, j + 8, k + 6, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 11, j + 8, k + 6, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 12, j + 8, k + 6, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 3, j + 8, k + 7, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 4, j + 8, k + 7, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 5, j + 8, k + 7, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 6, j + 8, k + 7, sculk_block, 0, 2);
			world.setBlock(i + 7, j + 8, k + 7, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 8, j + 8, k + 7, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 9, j + 8, k + 7, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 10, j + 8, k + 7, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 11, j + 8, k + 7, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 12, j + 8, k + 7, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 2, j + 8, k + 8, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 3, j + 8, k + 8, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 4, j + 8, k + 8, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 5, j + 8, k + 8, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 8, k + 8, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 7, j + 8, k + 8, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 8, j + 8, k + 8, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 10, j + 8, k + 8, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 11, j + 8, k + 8, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 12, j + 8, k + 8, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 3, j + 8, k + 9, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 4, j + 8, k + 9, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 5, j + 8, k + 9, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 8, k + 9, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 7, j + 8, k + 9, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 8, j + 8, k + 9, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 9, j + 8, k + 9, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 10, j + 8, k + 9, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 11, j + 8, k + 9, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 8, k + 10, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 7, j + 8, k + 10, NovaCraftBlocks.nullstone_tiled_stairs, 3, 2);
			world.setBlock(i + 8, j + 8, k + 10, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 8, j + 8, k + 11, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 6, j + 8, k + 12, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 8, j + 8, k + 12, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 3, j + 8, k + 19, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 11, j + 8, k + 19, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 5, j + 8, k + 21, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 9, j + 8, k + 21, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 5, j + 8, k + 25, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 9, j + 8, k + 25, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 3, j + 8, k + 27, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 11, j + 8, k + 27, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 6, j + 8, k + 34, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 8, j + 8, k + 34, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 6, j + 8, k + 35, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 8, j + 8, k + 35, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 6, j + 8, k + 36, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 7, j + 8, k + 36, NovaCraftBlocks.nullstone_tiled_stairs, 2, 2);
			world.setBlock(i + 8, j + 8, k + 36, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 6, j + 8, k + 37, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 7, j + 8, k + 37, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 8, j + 8, k + 37, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 3, j + 8, k + 38, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 4, j + 8, k + 38, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 5, j + 8, k + 38, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 8, k + 38, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 7, j + 8, k + 38, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 8, j + 8, k + 38, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 9, j + 8, k + 38, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 10, j + 8, k + 38, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 11, j + 8, k + 38, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 2, j + 8, k + 39, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 3, j + 8, k + 39, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 4, j + 8, k + 39, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 5, j + 8, k + 39, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 6, j + 8, k + 39, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 8, j + 8, k + 39, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 9, j + 8, k + 39, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 10, j + 8, k + 39, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 11, j + 8, k + 39, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 12, j + 8, k + 39, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 2, j + 8, k + 40, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 4, j + 8, k + 40, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 5, j + 8, k + 40, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 8, k + 40, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 7, j + 8, k + 40, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 8, j + 8, k + 40, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 10, j + 8, k + 40, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 11, j + 8, k + 40, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 12, j + 8, k + 40, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 2, j + 8, k + 41, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 3, j + 8, k + 41, sculk_block, 0, 2);
			world.setBlock(i + 4, j + 8, k + 41, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 5, j + 8, k + 41, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 6, j + 8, k + 41, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 7, j + 8, k + 41, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 8, j + 8, k + 41, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 9, j + 8, k + 41, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 11, j + 8, k + 41, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 12, j + 8, k + 41, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 2, j + 8, k + 42, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 3, j + 8, k + 42, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 4, j + 8, k + 42, sculk_block, 0, 2);
			world.setBlock(i + 5, j + 8, k + 42, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 8, k + 42, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 7, j + 8, k + 42, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 8, j + 8, k + 42, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 9, j + 8, k + 42, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 10, j + 8, k + 42, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 11, j + 8, k + 42, sculk_block, 0, 2);
			world.setBlock(i + 12, j + 8, k + 42, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 2, j + 8, k + 43, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 3, j + 8, k + 43, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 4, j + 8, k + 43, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 5, j + 8, k + 43, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 8, k + 43, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 7, j + 8, k + 43, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 8, j + 8, k + 43, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 9, j + 8, k + 43, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 10, j + 8, k + 43, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 11, j + 8, k + 43, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 12, j + 8, k + 43, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 2, j + 8, k + 44, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 3, j + 8, k + 44, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 4, j + 8, k + 44, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 5, j + 8, k + 44, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 8, k + 44, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 7, j + 8, k + 44, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 8, j + 8, k + 44, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 9, j + 8, k + 44, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 10, j + 8, k + 44, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 11, j + 8, k + 44, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 12, j + 8, k + 44, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 2, j + 8, k + 45, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 3, j + 8, k + 45, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 5, j + 8, k + 45, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 6, j + 8, k + 45, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 7, j + 8, k + 45, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 8, j + 8, k + 45, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 9, j + 8, k + 45, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 11, j + 8, k + 45, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 12, j + 8, k + 45, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 3, j + 8, k + 46, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 4, j + 8, k + 46, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 5, j + 8, k + 46, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 6, j + 8, k + 46, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 7, j + 8, k + 46, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 8, j + 8, k + 46, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 9, j + 8, k + 46, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 10, j + 8, k + 46, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 11, j + 8, k + 46, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 3, j + 9, k + 0, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 4, j + 9, k + 0, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 5, j + 9, k + 0, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 6, j + 9, k + 0, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 7, j + 9, k + 0, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 9, j + 9, k + 0, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 10, j + 9, k + 0, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 2, j + 9, k + 1, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 3, j + 9, k + 1, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 11, j + 9, k + 1, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 12, j + 9, k + 1, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 2, j + 9, k + 2, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 5, j + 9, k + 2, NovaCraftBlocks.sculk_tiled_slab, 0, 2);
			world.setBlock(i + 6, j + 9, k + 2, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 7, j + 9, k + 2, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 8, j + 9, k + 2, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 9, j + 9, k + 2, NovaCraftBlocks.sculk_tiled_slab, 0, 2);
			world.setBlock(i + 12, j + 9, k + 2, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 2, j + 9, k + 3, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 4, j + 9, k + 3, NovaCraftBlocks.sculk_tiled_slab, 0, 2);
			world.setBlock(i + 5, j + 9, k + 3, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 6, j + 9, k + 3, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 7, j + 9, k + 3, NovaCraftBlocks.sculk_tiles, 0, 2);
			world.setBlock(i + 8, j + 9, k + 3, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 9, j + 9, k + 3, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 10, j + 9, k + 3, NovaCraftBlocks.sculk_tiled_slab, 0, 2);
			world.setBlock(i + 12, j + 9, k + 3, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 5, j + 9, k + 4, NovaCraftBlocks.sculk_tiled_slab, 0, 2);
			world.setBlock(i + 6, j + 9, k + 4, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 7, j + 9, k + 4, NovaCraftBlocks.sculk_tiled_slab, 0, 2);
			world.setBlock(i + 8, j + 9, k + 4, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 9, j + 9, k + 4, NovaCraftBlocks.sculk_tiled_slab, 0, 2);
			world.setBlock(i + 12, j + 9, k + 4, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 2, j + 9, k + 5, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 6, j + 9, k + 5, NovaCraftBlocks.sculk_tiled_slab, 0, 2);
			world.setBlock(i + 8, j + 9, k + 5, NovaCraftBlocks.sculk_tiled_slab, 0, 2);
			world.setBlock(i + 2, j + 9, k + 6, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 12, j + 9, k + 6, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 2, j + 9, k + 7, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 4, j + 9, k + 7, NovaCraftBlocks.sculk_tiles, 0, 2);
			world.setBlock(i + 10, j + 9, k + 7, NovaCraftBlocks.sculk_tiles, 0, 2);
			world.setBlock(i + 12, j + 9, k + 7, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 2, j + 9, k + 8, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 3, j + 9, k + 8, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 11, j + 9, k + 8, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 12, j + 9, k + 8, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 3, j + 9, k + 9, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 4, j + 9, k + 9, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 5, j + 9, k + 9, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 6, j + 9, k + 9, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 8, j + 9, k + 9, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 9, j + 9, k + 9, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 10, j + 9, k + 9, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 11, j + 9, k + 9, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 6, j + 9, k + 10, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 8, j + 9, k + 10, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 3, j + 9, k + 19, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 11, j + 9, k + 19, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 5, j + 9, k + 20, NovaCraftBlocks.null_cluster_2, 2, 2);
			world.setBlock(i + 4, j + 9, k + 21, NovaCraftBlocks.null_cluster_2, 4, 2);
			world.setBlock(i + 5, j + 9, k + 21, NovaCraftBlocks.budding_null_block, 0, 2);
			world.setBlock(i + 6, j + 9, k + 21, NovaCraftBlocks.null_cluster_2, 5, 2);
			world.setBlock(i + 5, j + 9, k + 22, NovaCraftBlocks.null_cluster_2, 3, 2);
			world.setBlock(i + 9, j + 9, k + 25, NovaCraftBlocks.budding_null_block, 0, 2);
			world.setBlock(i + 6, j + 9, k + 36, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 8, j + 9, k + 36, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 6, j + 9, k + 37, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 8, j + 9, k + 37, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 3, j + 9, k + 38, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 4, j + 9, k + 38, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 5, j + 9, k + 38, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 6, j + 9, k + 38, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 8, j + 9, k + 38, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 9, j + 9, k + 38, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 10, j + 9, k + 38, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 11, j + 9, k + 38, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 2, j + 9, k + 39, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 3, j + 9, k + 39, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 11, j + 9, k + 39, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 12, j + 9, k + 39, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 2, j + 9, k + 40, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 4, j + 9, k + 40, NovaCraftBlocks.sculk_tiled_wall, 0, 2);
			world.setBlock(i + 10, j + 9, k + 40, NovaCraftBlocks.sculk_tiled_wall, 0, 2);
			world.setBlock(i + 12, j + 9, k + 40, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 2, j + 9, k + 41, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 6, j + 9, k + 41, NovaCraftBlocks.sculk_tiled_slab, 0, 2);
			world.setBlock(i + 8, j + 9, k + 41, NovaCraftBlocks.sculk_tiled_slab, 0, 2);
			world.setBlock(i + 12, j + 9, k + 41, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 2, j + 9, k + 42, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 5, j + 9, k + 42, NovaCraftBlocks.sculk_tiled_slab, 0, 2);
			world.setBlock(i + 6, j + 9, k + 42, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 7, j + 9, k + 42, NovaCraftBlocks.sculk_tiled_slab, 0, 2);
			world.setBlock(i + 8, j + 9, k + 42, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 9, j + 9, k + 42, NovaCraftBlocks.sculk_tiled_slab, 0, 2);
			world.setBlock(i + 12, j + 9, k + 42, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 2, j + 9, k + 43, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 4, j + 9, k + 43, NovaCraftBlocks.sculk_tiled_slab, 0, 2);
			world.setBlock(i + 5, j + 9, k + 43, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 6, j + 9, k + 43, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 7, j + 9, k + 43, NovaCraftBlocks.sculk_tiles, 0, 2);
			world.setBlock(i + 8, j + 9, k + 43, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 9, j + 9, k + 43, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 10, j + 9, k + 43, NovaCraftBlocks.sculk_tiled_slab, 0, 2);
			world.setBlock(i + 12, j + 9, k + 43, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 2, j + 9, k + 44, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 5, j + 9, k + 44, NovaCraftBlocks.sculk_tiled_slab, 0, 2);
			world.setBlock(i + 6, j + 9, k + 44, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 7, j + 9, k + 44, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 8, j + 9, k + 44, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 9, j + 9, k + 44, NovaCraftBlocks.sculk_tiled_slab, 0, 2);
			world.setBlock(i + 12, j + 9, k + 44, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 2, j + 9, k + 45, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 3, j + 9, k + 45, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 11, j + 9, k + 45, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 12, j + 9, k + 45, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 3, j + 9, k + 46, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 4, j + 9, k + 46, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 5, j + 9, k + 46, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 6, j + 9, k + 46, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 7, j + 9, k + 46, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 8, j + 9, k + 46, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 9, j + 9, k + 46, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 10, j + 9, k + 46, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 11, j + 9, k + 46, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 6, j + 10, k + 2, NovaCraftBlocks.sculk_tiles, 0, 2);
			world.setBlock(i + 7, j + 10, k + 2, NovaCraftBlocks.sculk_tiles, 0, 2);
			world.setBlock(i + 8, j + 10, k + 2, NovaCraftBlocks.sculk_tiles, 0, 2);
			world.setBlock(i + 5, j + 10, k + 3, NovaCraftBlocks.sculk_tiled_wall, 0, 2);
			world.setBlock(i + 9, j + 10, k + 3, NovaCraftBlocks.sculk_tiled_wall, 0, 2);
			world.setBlock(i + 6, j + 10, k + 4, NovaCraftBlocks.sculk_tiled_wall, 0, 2);
			world.setBlock(i + 8, j + 10, k + 4, NovaCraftBlocks.sculk_tiled_wall, 0, 2);
			world.setBlock(i + 3, j + 10, k + 19, Blocks.diamond_block, 0, 2);
			world.setBlock(i + 5, j + 10, k + 21, Blocks.air, 0, 2); //1
			world.setBlock(i + 4, j + 10, k + 40, NovaCraftBlocks.dim_vanite_torch, 5, 2);
			world.setBlock(i + 10, j + 10, k + 40, NovaCraftBlocks.dim_vanite_torch, 5, 2);
			world.setBlock(i + 6, j + 10, k + 42, NovaCraftBlocks.sculk_tiled_wall, 0, 2);
			world.setBlock(i + 8, j + 10, k + 42, NovaCraftBlocks.sculk_tiled_wall, 0, 2);
			world.setBlock(i + 5, j + 10, k + 43, NovaCraftBlocks.sculk_tiled_wall, 0, 2);
			world.setBlock(i + 9, j + 10, k + 43, NovaCraftBlocks.sculk_tiled_wall, 0, 2);
			world.setBlock(i + 6, j + 10, k + 44, NovaCraftBlocks.sculk_tiles, 0, 2);
			world.setBlock(i + 7, j + 10, k + 44, NovaCraftBlocks.sculk_tiles, 0, 2);
			world.setBlock(i + 8, j + 10, k + 44, NovaCraftBlocks.sculk_tiles, 0, 2);
			world.setBlock(i + 7, j + 11, k + 2, NovaCraftBlocks.chiseled_sculk, 0, 2);
			world.setBlock(i + 5, j + 11, k + 3, NovaCraftBlocks.sculk_tiled_wall, 0, 2);
			world.setBlock(i + 9, j + 11, k + 3, NovaCraftBlocks.sculk_tiled_wall, 0, 2);
			world.setBlock(i + 6, j + 11, k + 4, NovaCraftBlocks.dim_vanite_torch, 5, 2);
			world.setBlock(i + 8, j + 11, k + 4, NovaCraftBlocks.dim_vanite_torch, 5, 2);
			world.setBlock(i + 6, j + 11, k + 42, NovaCraftBlocks.dim_vanite_torch, 5, 2);
			world.setBlock(i + 8, j + 11, k + 42, NovaCraftBlocks.dim_vanite_torch, 5, 2);
			world.setBlock(i + 5, j + 11, k + 43, NovaCraftBlocks.sculk_tiled_wall, 0, 2);
			world.setBlock(i + 9, j + 11, k + 43, NovaCraftBlocks.sculk_tiled_wall, 0, 2);
			world.setBlock(i + 7, j + 11, k + 44, NovaCraftBlocks.chiseled_sculk, 0, 2);
			
			world.setBlock(i + 12, j + 7, k + 29, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        if ((world.getBlock(i + 12, j + 8, k + 29) == Blocks.air || world.getBlock(i + 12, j + 8, k + 29) == Blocks.gravel) && world.getBlock(i + 12, j + 7, k + 29) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 12, j + 8, k + 29, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 12, j + 9, k + 29) == Blocks.air || world.getBlock(i + 12, j + 9, k + 29) == Blocks.gravel) && world.getBlock(i + 12, j + 8, k + 29) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 12, j + 9, k + 29, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 12, j + 10, k + 29) == Blocks.air || world.getBlock(i + 12, j + 10, k + 29) == Blocks.gravel) && world.getBlock(i + 12, j + 9, k + 29) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 12, j + 10, k + 29, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 12, j + 11, k + 29) == Blocks.air || world.getBlock(i + 12, j + 11, k + 29) == Blocks.gravel) && world.getBlock(i + 12, j + 10, k + 29) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 12, j + 11, k + 29, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 12, j + 12, k + 29) == Blocks.air || world.getBlock(i + 12, j + 12, k + 29) == Blocks.gravel) && world.getBlock(i + 12, j + 11, k + 29) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 12, j + 12, k + 29, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 12, j + 13, k + 29) == Blocks.air || world.getBlock(i + 12, j + 13, k + 29) == Blocks.gravel) && world.getBlock(i + 12, j + 12, k + 29) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 12, j + 13, k + 29, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 12, j + 14, k + 29) == Blocks.air || world.getBlock(i + 12, j + 14, k + 29) == Blocks.gravel) && world.getBlock(i + 12, j + 13, k + 29) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 12, j + 14, k + 29, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 12, j + 15, k + 29) == Blocks.air || world.getBlock(i + 12, j + 15, k + 29) == Blocks.gravel) && world.getBlock(i + 12, j + 14, k + 29) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 12, j + 15, k + 29, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 12, j + 16, k + 29) == Blocks.air || world.getBlock(i + 12, j + 16, k + 29) == Blocks.gravel) && world.getBlock(i + 12, j + 15, k + 29) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 12, j + 16, k + 29, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 12, j + 17, k + 29) == Blocks.air || world.getBlock(i + 12, j + 17, k + 29) == Blocks.gravel) && world.getBlock(i + 12, j + 16, k + 29) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 12, j + 17, k + 29, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 12, j + 18, k + 29) == Blocks.air || world.getBlock(i + 12, j + 18, k + 29) == Blocks.gravel) && world.getBlock(i + 12, j + 17, k + 29) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 12, j + 18, k + 29, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 12, j + 19, k + 29) == Blocks.air || world.getBlock(i + 12, j + 19, k + 29) == Blocks.gravel) && world.getBlock(i + 12, j + 18, k + 29) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 12, j + 19, k + 29, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        
	        
	        world.setBlock(i + 12, j + 7, k + 17, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        if ((world.getBlock(i + 12, j + 8, k + 17) == Blocks.air || world.getBlock(i + 12, j + 8, k + 17) == Blocks.gravel) && world.getBlock(i + 12, j + 7, k + 17) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 12, j + 8, k + 17, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 12, j + 9, k + 17) == Blocks.air || world.getBlock(i + 12, j + 9, k + 17) == Blocks.gravel) && world.getBlock(i + 12, j + 8, k + 17) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 12, j + 9, k + 17, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 12, j + 10, k + 17) == Blocks.air || world.getBlock(i + 12, j + 10, k + 17) == Blocks.gravel) && world.getBlock(i + 12, j + 9, k + 17) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 12, j + 10, k + 17, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 12, j + 11, k + 17) == Blocks.air || world.getBlock(i + 12, j + 11, k + 17) == Blocks.gravel) && world.getBlock(i + 12, j + 10, k + 17) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 12, j + 11, k + 17, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 12, j + 12, k + 17) == Blocks.air || world.getBlock(i + 12, j + 12, k + 17) == Blocks.gravel) && world.getBlock(i + 12, j + 11, k + 17) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 12, j + 12, k + 17, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 12, j + 13, k + 17) == Blocks.air || world.getBlock(i + 12, j + 13, k + 17) == Blocks.gravel) && world.getBlock(i + 12, j + 12, k + 17) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 12, j + 13, k + 17, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 12, j + 14, k + 17) == Blocks.air || world.getBlock(i + 12, j + 14, k + 17) == Blocks.gravel) && world.getBlock(i + 12, j + 13, k + 17) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 12, j + 14, k + 17, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 12, j + 15, k + 17) == Blocks.air || world.getBlock(i + 12, j + 15, k + 17) == Blocks.gravel) && world.getBlock(i + 12, j + 14, k + 17) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 12, j + 15, k + 17, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 12, j + 16, k + 17) == Blocks.air || world.getBlock(i + 12, j + 16, k + 17) == Blocks.gravel) && world.getBlock(i + 12, j + 15, k + 17) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 12, j + 16, k + 17, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 12, j + 17, k + 17) == Blocks.air || world.getBlock(i + 12, j + 17, k + 17) == Blocks.gravel) && world.getBlock(i + 12, j + 16, k + 17) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 12, j + 17, k + 17, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 12, j + 18, k + 17) == Blocks.air || world.getBlock(i + 12, j + 18, k + 17) == Blocks.gravel) && world.getBlock(i + 12, j + 17, k + 17) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 12, j + 18, k + 17, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 12, j + 19, k + 17) == Blocks.air || world.getBlock(i + 12, j + 19, k + 17) == Blocks.gravel) && world.getBlock(i + 12, j + 18, k + 17) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 12, j + 19, k + 17, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        
	        
	        world.setBlock(i + 11, j + 10, k + 8, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        if ((world.getBlock(i + 11, j + 11, k + 8) == Blocks.air || world.getBlock(i + 11, j + 11, k + 8) == Blocks.gravel) && world.getBlock(i + 11, j + 10, k + 8) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 11, j + 11, k + 8, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 11, j + 12, k + 8) == Blocks.air || world.getBlock(i + 11, j + 12, k + 8) == Blocks.gravel) && world.getBlock(i + 11, j + 11, k + 8) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 11, j + 12, k + 8, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 11, j + 13, k + 8) == Blocks.air || world.getBlock(i + 11, j + 13, k + 8) == Blocks.gravel) && world.getBlock(i + 11, j + 12, k + 8) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 11, j + 13, k + 8, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 11, j + 14, k + 8) == Blocks.air || world.getBlock(i + 11, j + 14, k + 8) == Blocks.gravel) && world.getBlock(i + 11, j + 13, k + 8) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 11, j + 14, k + 8, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 11, j + 15, k + 8) == Blocks.air || world.getBlock(i + 11, j + 15, k + 8) == Blocks.gravel) && world.getBlock(i + 11, j + 14, k + 8) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 11, j + 15, k + 8, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 11, j + 16, k + 8) == Blocks.air || world.getBlock(i + 11, j + 16, k + 8) == Blocks.gravel) && world.getBlock(i + 11, j + 15, k + 8) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 11, j + 16, k + 8, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 11, j + 17, k + 8) == Blocks.air || world.getBlock(i + 11, j + 17, k + 8) == Blocks.gravel) && world.getBlock(i + 11, j + 16, k + 8) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 11, j + 17, k + 8, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 11, j + 18, k + 8) == Blocks.air || world.getBlock(i + 11, j + 18, k + 8) == Blocks.gravel) && world.getBlock(i + 11, j + 17, k + 8) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 11, j + 18, k + 8, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 11, j + 19, k + 8) == Blocks.air || world.getBlock(i + 11, j + 19, k + 8) == Blocks.gravel) && world.getBlock(i + 11, j + 18, k + 8) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 11, j + 19, k + 8, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 11, j + 20, k + 8) == Blocks.air || world.getBlock(i + 11, j + 20, k + 8) == Blocks.gravel) && world.getBlock(i + 11, j + 19, k + 8) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 11, j + 20, k + 8, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 11, j + 21, k + 8) == Blocks.air || world.getBlock(i + 11, j + 21, k + 8) == Blocks.gravel) && world.getBlock(i + 11, j + 20, k + 8) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 11, j + 21, k + 8, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 11, j + 22, k + 8) == Blocks.air || world.getBlock(i + 11, j + 22, k + 8) == Blocks.gravel) && world.getBlock(i + 11, j + 21, k + 8) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 11, j + 22, k + 8, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        	        
	        world.setBlock(i + 1, j + 7, k + 17, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        world.setBlock(i + 1, j + 8, k + 17, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        world.setBlock(i + 1, j + 9, k + 17, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        world.setBlock(i + 1, j + 10, k + 17, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        world.setBlock(i + 1, j + 11, k + 17, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        world.setBlock(i + 1, j + 12, k + 17, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        if ((world.getBlock(i + 1, j + 13, k + 17) == Blocks.air || world.getBlock(i + 1, j + 13, k + 17) == Blocks.gravel) && world.getBlock(i + 1, j + 12, k + 17) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 1, j + 13, k + 17, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 1, j + 14, k + 17) == Blocks.air || world.getBlock(i + 1, j + 14, k + 17) == Blocks.gravel) && world.getBlock(i + 1, j + 13, k + 17) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 1, j + 14, k + 17, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 1, j + 15, k + 17) == Blocks.air || world.getBlock(i + 1, j + 15, k + 17) == Blocks.gravel) && world.getBlock(i + 1, j + 14, k + 17) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 1, j + 15, k + 17, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 1, j + 16, k + 17) == Blocks.air || world.getBlock(i + 1, j + 16, k + 17) == Blocks.gravel) && world.getBlock(i + 1, j + 15, k + 17) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 1, j + 16, k + 17, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 1, j + 17, k + 17) == Blocks.air || world.getBlock(i + 1, j + 17, k + 17) == Blocks.gravel) && world.getBlock(i + 1, j + 16, k + 17) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 1, j + 17, k + 17, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 1, j + 18, k + 17) == Blocks.air || world.getBlock(i + 1, j + 18, k + 17) == Blocks.gravel) && world.getBlock(i + 1, j + 17, k + 17) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 1, j + 18, k + 17, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 1, j + 19, k + 17) == Blocks.air || world.getBlock(i + 1, j + 19, k + 17) == Blocks.gravel) && world.getBlock(i + 1, j + 18, k + 17) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 1, j + 19, k + 17, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        
	        world.setBlock(i + 1, j + 7, k + 29, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        world.setBlock(i + 1, j + 8, k + 29, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        world.setBlock(i + 1, j + 9, k + 29, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        world.setBlock(i + 1, j + 10, k + 29, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        world.setBlock(i + 1, j + 11, k + 29, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        world.setBlock(i + 1, j + 12, k + 29, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        if ((world.getBlock(i + 1, j + 13, k + 29) == Blocks.air || world.getBlock(i + 1, j + 13, k + 29) == Blocks.gravel) && world.getBlock(i + 1, j + 12, k + 29) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 1, j + 13, k + 29, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 1, j + 14, k + 29) == Blocks.air || world.getBlock(i + 1, j + 14, k + 29) == Blocks.gravel) && world.getBlock(i + 1, j + 13, k + 29) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 1, j + 14, k + 29, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 1, j + 15, k + 29) == Blocks.air || world.getBlock(i + 1, j + 15, k + 29) == Blocks.gravel) && world.getBlock(i + 1, j + 14, k + 29) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 1, j + 15, k + 29, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 1, j + 16, k + 29) == Blocks.air || world.getBlock(i + 1, j + 16, k + 29) == Blocks.gravel) && world.getBlock(i + 1, j + 15, k + 29) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 1, j + 16, k + 29, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 1, j + 17, k + 29) == Blocks.air || world.getBlock(i + 1, j + 17, k + 29) == Blocks.gravel) && world.getBlock(i + 1, j + 16, k + 29) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 1, j + 17, k + 29, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 1, j + 18, k + 29) == Blocks.air || world.getBlock(i + 1, j + 18, k + 29) == Blocks.gravel) && world.getBlock(i + 1, j + 17, k + 29) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 1, j + 18, k + 29, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 1, j + 19, k + 29) == Blocks.air || world.getBlock(i + 1, j + 19, k + 29) == Blocks.gravel) && world.getBlock(i + 1, j + 18, k + 29) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 1, j + 19, k + 29, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        
	        world.setBlock(i + 11, j + 10, k + 45, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        world.setBlock(i + 11, j + 11, k + 45, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        world.setBlock(i + 11, j + 12, k + 45, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        world.setBlock(i + 11, j + 13, k + 45, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        world.setBlock(i + 11, j + 14, k + 45, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        world.setBlock(i + 11, j + 15, k + 45, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        if ((world.getBlock(i + 11, j + 16, k + 45) == Blocks.air || world.getBlock(i + 11, j + 16, k + 45) == Blocks.gravel) && world.getBlock(i + 11, j + 15, k + 45) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 11, j + 16, k + 45, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 11, j + 17, k + 45) == Blocks.air || world.getBlock(i + 11, j + 17, k + 45) == Blocks.gravel) && world.getBlock(i + 11, j + 16, k + 45) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 11, j + 17, k + 45, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 11, j + 18, k + 45) == Blocks.air || world.getBlock(i + 11, j + 18, k + 45) == Blocks.gravel) && world.getBlock(i + 11, j + 17, k + 45) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 11, j + 18, k + 45, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 11, j + 19, k + 45) == Blocks.air || world.getBlock(i + 11, j + 19, k + 45) == Blocks.gravel) && world.getBlock(i + 11, j + 18, k + 45) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 11, j + 19, k + 45, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 11, j + 20, k + 45) == Blocks.air || world.getBlock(i + 11, j + 20, k + 45) == Blocks.gravel) && world.getBlock(i + 11, j + 19, k + 45) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 11, j + 20, k + 45, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        
	        world.setBlock(i + 3, j + 10, k + 1, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        world.setBlock(i + 3, j + 11, k + 1, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        world.setBlock(i + 3, j + 12, k + 1, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        world.setBlock(i + 3, j + 13, k + 1, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        world.setBlock(i + 3, j + 14, k + 1, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        world.setBlock(i + 3, j + 15, k + 1, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        if ((world.getBlock(i + 3, j + 16, k + 1) == Blocks.air || world.getBlock(i + 3, j + 16, k + 1) == Blocks.gravel) && world.getBlock(i + 3, j + 15, k + 1) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 3, j + 16, k + 1, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 3, j + 17, k + 1) == Blocks.air || world.getBlock(i + 3, j + 17, k + 1) == Blocks.gravel) && world.getBlock(i + 3, j + 16, k + 1) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 3, j + 17, k + 1, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 3, j + 18, k + 1) == Blocks.air || world.getBlock(i + 3, j + 18, k + 1) == Blocks.gravel) && world.getBlock(i + 3, j + 17, k + 1) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 3, j + 18, k + 1, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 3, j + 19, k + 1) == Blocks.air || world.getBlock(i + 3, j + 19, k + 1) == Blocks.gravel) && world.getBlock(i + 3, j + 18, k + 1) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 3, j + 19, k + 1, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 3, j + 20, k + 1) == Blocks.air || world.getBlock(i + 3, j + 20, k + 1) == Blocks.gravel) && world.getBlock(i + 3, j + 19, k + 1) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 3, j + 20, k + 1, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
			/*
			world.setBlock(i + 12, j + 7, k + 29, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 11, j + 10, k + 1, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 3, j + 10, k + 8, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 3, j + 10, k + 39, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 11, j + 10, k + 39, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 3, j + 10, k + 45, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			*/
	        
	        world.setBlock(i + 11, j + 7, k + 26, Blocks.mob_spawner, 0, 2);
	        TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner)world.getTileEntity(i + 11, j + 7, k + 26);
	        
	        if (tileentitymobspawner != null)
	        {
	        	tileentitymobspawner.func_145881_a().setEntityName("nova_craft.sculk_abomination");
	        }
	        
			world.setBlock(i + 4, j + 9, k + 5, Blocks.mob_spawner, 0, 2);
			TileEntityMobSpawner tileentitymobspawner2 = (TileEntityMobSpawner)world.getTileEntity(i + 4, j + 9, k + 5);
	        
	        if (tileentitymobspawner2 != null)
	        {
	        	tileentitymobspawner2.func_145881_a().setEntityName("nova_craft.sculk_dweller");
	        }
	        
			world.setBlock(i + 4, j + 9, k + 42, Blocks.mob_spawner, 0, 2);
			TileEntityMobSpawner tileentitymobspawner3 = (TileEntityMobSpawner)world.getTileEntity(i + 4, j + 9, k + 42);
	        
	        if (tileentitymobspawner3 != null)
	        {
	        	tileentitymobspawner3.func_145881_a().setEntityName("nova_craft.sculk_dweller");
	        }
	        
			world.setBlock(i + 2, j + 6, k + 18, Blocks.mob_spawner, 0, 2);
			TileEntityMobSpawner tileentitymobspawner4 = (TileEntityMobSpawner)world.getTileEntity(i + 2, j + 6, k + 18);
	        
	        if (tileentitymobspawner4 != null)
	        {
	        	tileentitymobspawner4.func_145881_a().setEntityName("nova_craft.sculk_incinerator");
	        }
			
			world.setBlock(i + 7, j + 10, k + 43, Blocks.chest, 2, 2);
			TileEntityChest chest = (TileEntityChest) world.getTileEntity(i + 7, j + 10, k + 43);

			for (int slot = 0; slot < 3 + random.nextInt(65); slot++) {
				chest.setInventorySlotContents(random.nextInt(chest.getSizeInventory()), this.getSpecialLoot(random));
				chest.setInventorySlotContents(random.nextInt(chest.getSizeInventory()), this.getSpecialLoot(random));
			}
			
			world.setBlock(i + 7, j + 10, k + 3, Blocks.chest, 3, 2);
			TileEntityChest chest2 = (TileEntityChest) world.getTileEntity(i + 7, j + 10, k + 3);

			for (int slot = 0; slot < 3 + random.nextInt(65); slot++) {
				chest2.setInventorySlotContents(random.nextInt(chest2.getSizeInventory()), this.getSpecialLoot(random));
				chest2.setInventorySlotContents(random.nextInt(chest2.getSizeInventory()), this.getSpecialLoot(random));
			}
			
			
			world.setBlock(i + 4, j + 10, k + 7, Blocks.chest, 5, 2);
			TileEntityChest chest3 = (TileEntityChest) world.getTileEntity(i + 4, j + 10, k + 7);

			for (int slot = 0; slot < 3 + random.nextInt(25); slot++) {
				chest3.setInventorySlotContents(random.nextInt(chest3.getSizeInventory()), this.getSculkLoot(random));
			}
			
			world.setBlock(i + 10, j + 10, k + 7, Blocks.chest, 4, 2);
			TileEntityChest chest4 = (TileEntityChest) world.getTileEntity(i + 10, j + 10, k + 7);

			for (int slot = 0; slot < 3 + random.nextInt(25); slot++) {
				chest4.setInventorySlotContents(random.nextInt(chest4.getSizeInventory()), this.getSculkLoot(random));
			}
		 
			return true;
	 }
	 
	 private ItemStack getSculkLoot(Random random) {
			int item = random.nextInt(11);
			switch (item) {
				case 0:
					return new ItemStack(NovaCraftItems.sculked_shard, random.nextInt(5) + 3);
				case 1:
					return new ItemStack(NovaCraftItems.sculked_shard, random.nextInt(1) + 2);
				case 2:
					return new ItemStack(NovaCraftItems.sculk_dweller_heart, 1);
				case 3:
					return new ItemStack(NovaCraftItems.sculked_monitor_scales, random.nextInt(5) + 2);
				case 4:
					return new ItemStack(NovaCraftBlocks.sculk_bricks, random.nextInt(21) + 11);
				case 5:
					return new ItemStack(NovaCraftBlocks.sculk_block, random.nextInt(11) + 5);
				case 6:
					return new ItemStack(NovaCraftBlocks.sculk_tentacle_2, random.nextInt(2) + 3);
				case 7:
					return new ItemStack(NovaCraftBlocks.sculk_bush, random.nextInt(3) + 1);
				case 8:
					return new ItemStack(NovaCraftBlocks.sculk_bloom, random.nextInt(2) + 1);
				default: {
					return new ItemStack(NovaCraftBlocks.sculk_block, random.nextInt(9) + 2);
				}
			}
		}
	 
	 private ItemStack getSpecialLoot(Random random) {
			int item = random.nextInt(24);
			switch (item) {
				case 0:
					return new ItemStack(Items.diamond, random.nextInt(3) + 2);
				case 1:
					return new ItemStack(Items.skull, 1, 1);
				case 2:
					return new ItemStack(NovaCraftItems.larimar_shard, random.nextInt(8) + 2);
				case 3:
					return new ItemStack(NovaCraftItems.copartz_shard, random.nextInt(8) + 2);
				case 4:
					return new ItemStack(NovaCraftItems.tsavorokite_shard, random.nextInt(8) + 2);
				case 5:
					return new ItemStack(NovaCraftItems.yttrlinsite_shard,  random.nextInt(8) + 2);
				case 6: 
					return new ItemStack(Items.skull, 1, 1);
				case 7: 
					Enchantment enchantment = Enchantment.enchantmentsBookList[random.nextInt(Enchantment.enchantmentsBookList.length)];
			        		        
					int minLevel = enchantment.getMinLevel();
			        int maxLevel = enchantment.getMaxLevel();
			        int level = MathHelper.getRandomIntegerInRange(random, minLevel, maxLevel);
			        ItemStack itemStack = Items.enchanted_book.getEnchantedItemStack(new EnchantmentData(enchantment, maxLevel));
	                
	                return itemStack;
				case 8: 
					Enchantment enchantment2 = Enchantment.enchantmentsBookList[random.nextInt(Enchantment.enchantmentsBookList.length)];
			        
			        int minLevel2 = enchantment2.getMinLevel();
			        int maxLevel2 = enchantment2.getMaxLevel();
			        int level2 = MathHelper.getRandomIntegerInRange(random, minLevel2, maxLevel2);		       
			        ItemStack itemStack2 = Items.enchanted_book.getEnchantedItemStack(new EnchantmentData(enchantment2, maxLevel2));
	                
	                return itemStack2;
	                
				case 9: 
					return new ItemStack(Items.diamond, random.nextInt(3) + 2);
				case 10: 
					return new ItemStack(NovaCraftItems.primeval_mace, 1);
				case 11: 
					return new ItemStack(Items.experience_bottle, random.nextInt(12) + 5);
				case 12:
					//Helmet enchants
				    Enchantment[] helmetEnchantments = {Enchantment.protection, Enchantment.projectileProtection, Enchantment.unbreaking, Enchantment.respiration};
				    Enchantment[] helmetEnchantments2 = {Enchantment.aquaAffinity, Enchantment.fireProtection, Enchantment.blastProtection};
				    Enchantment enchantment3 = helmetEnchantments[random.nextInt(helmetEnchantments.length)];
				    Enchantment enchantment33 = helmetEnchantments2[random.nextInt(helmetEnchantments2.length)];	
				    int maxLevel3 = enchantment3.getMaxLevel() + 1 + random.nextInt(1);			
				    int maxLevel33 = enchantment33.getMaxLevel() + 1 + random.nextInt(1);	
				    ItemStack itemStack3 = new ItemStack(NovaCraftItems.tophinite_helmet);
				    
				    itemStack3.addEnchantment(enchantment3, maxLevel3);
				    itemStack3.addEnchantment(enchantment33, maxLevel33);
				    
				    return itemStack3;
				case 13:
					//Chestplate enchants
				    Enchantment[] chestplateEnchantments = {Enchantment.protection, Enchantment.blastProtection};
				    Enchantment[] chestplateEnchantments2 = {Enchantment.unbreaking, Enchantment.fireProtection, Enchantment.projectileProtection};
				    
				    //Selects a random enchantment
				    Enchantment enchantment4 = chestplateEnchantments[random.nextInt(chestplateEnchantments.length)];		    
				    int maxLevel4 = enchantment4.getMaxLevel() + 1 + random.nextInt(1);		    
				    
				    Enchantment enchantment44 = chestplateEnchantments2[random.nextInt(chestplateEnchantments2.length)];		    
				    int maxLevel44 = enchantment44.getMaxLevel() + 1 + random.nextInt(1);
				    
				    //Creates an ItemStack for diamond chestplate
				    ItemStack itemStack4 = new ItemStack(NovaCraftItems.tophinite_chestplate);
				    
				    //Adds the enchantment
				    itemStack4.addEnchantment(enchantment4, maxLevel4);
				    itemStack4.addEnchantment(enchantment44, maxLevel44);
				    
				    return itemStack4;			
				case 14:
					//Legging enchants
				    Enchantment[] leggingsEnchantments = {Enchantment.protection, Enchantment.fireProtection};
				    Enchantment[] leggingsEnchantments2 = {Enchantment.unbreaking, Enchantment.blastProtection, Enchantment.projectileProtection};
				    Enchantment enchantment5 = leggingsEnchantments[random.nextInt(leggingsEnchantments.length)];
				    Enchantment enchantment55 = leggingsEnchantments2[random.nextInt(leggingsEnchantments2.length)];
				    int maxLevel5 = enchantment5.getMaxLevel() + 1 + random.nextInt(1);
				    int maxLevel55 = enchantment55.getMaxLevel() + 1 + random.nextInt(1);
				    ItemStack itemStack5 = new ItemStack(NovaCraftItems.tophinite_leggings);
				    
				    itemStack5.addEnchantment(enchantment5, maxLevel5);
				    itemStack5.addEnchantment(enchantment55, maxLevel55);
				    
				    return itemStack5;
				case 15:
					//Boot enchants
					Enchantment[] bootEnchantments = {Enchantment.protection, Enchantment.unbreaking};
				    Enchantment[] bootEnchantments2 = {Enchantment.projectileProtection, Enchantment.featherFalling, Enchantment.blastProtection, Enchantment.fireProtection};
				    Enchantment enchantment6 = bootEnchantments[random.nextInt(bootEnchantments.length)];
				    Enchantment enchantment66 = bootEnchantments2[random.nextInt(bootEnchantments2.length)];
				    int maxLevel6 = enchantment6.getMaxLevel() + 1 + random.nextInt(1);
				    int maxLevel66 = enchantment66.getMaxLevel() + 1 + random.nextInt(1);
				    ItemStack itemStack6 = new ItemStack(NovaCraftItems.tophinite_boots);
				    
				    itemStack6.addEnchantment(enchantment6, maxLevel6);
				    itemStack6.addEnchantment(enchantment66, maxLevel66);
				    
				    return itemStack6;
				case 16: 
					return new ItemStack(Blocks.iron_block, random.nextInt(18) + 8);
				case 17: 
					return new ItemStack(Blocks.gold_block, random.nextInt(13) + 11);
				case 18: 
					return new ItemStack(NovaCraftItems.vanite_ingot, random.nextInt(30) + 18);
				case 19: 
					return new ItemStack(Items.golden_apple, 1, 1);
				case 20: 
					return new ItemStack(Blocks.iron_block, random.nextInt(18) + 25);
				case 21: 
					return new ItemStack(NovaCraftItems.primeval_mace, 1);
				default: {
					return new ItemStack(NovaCraftItems.blazing_coal, random.nextInt(26) + 12);
				}
			}
		}

}
