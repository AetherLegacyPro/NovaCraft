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

public class AncientCityFurnaceRoomGen2 extends WorldGenerator
{
	public AncientCityFurnaceRoomGen2() {

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
		 
		 world.setBlock(i + 9, j + 13, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 10, j + 13, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 11, j + 13, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 12, j + 13, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 13, j + 13, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 14, j + 13, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 0, j + 13, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 13, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 13, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 13, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 13, k + 3, NovaCraftBlocks.sculk_block, 0, 2);
			world.setBlock(i + 5, j + 13, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 13, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 7, j + 13, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 8, j + 13, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 9, j + 13, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 10, j + 13, k + 3, NovaCraftBlocks.sculk_block, 0, 2);
			world.setBlock(i + 11, j + 13, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 12, j + 13, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 13, j + 13, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 14, j + 13, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 0, j + 13, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 13, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 13, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 13, k + 4, NovaCraftBlocks.sculk_block, 0, 2);
			world.setBlock(i + 4, j + 13, k + 4, NovaCraftBlocks.sculk_block, 0, 2);
			world.setBlock(i + 5, j + 13, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 13, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 7, j + 13, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 8, j + 13, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 9, j + 13, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 10, j + 13, k + 4, NovaCraftBlocks.sculk_block, 0, 2);
			world.setBlock(i + 11, j + 13, k + 4, NovaCraftBlocks.sculk_block, 0, 2);
			world.setBlock(i + 12, j + 13, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 13, j + 13, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 14, j + 13, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 0, j + 13, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 13, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 13, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 13, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 13, k + 5, NovaCraftBlocks.sculk_block, 0, 2);
			world.setBlock(i + 5, j + 13, k + 5, NovaCraftBlocks.sculk_block, 0, 2);
			world.setBlock(i + 6, j + 13, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 7, j + 13, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 8, j + 13, k + 5, NovaCraftBlocks.sculk_block, 0, 2);
			world.setBlock(i + 9, j + 13, k + 5, NovaCraftBlocks.sculk_block, 0, 2);
			world.setBlock(i + 10, j + 13, k + 5, NovaCraftBlocks.sculk_block, 0, 2);
			world.setBlock(i + 11, j + 13, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 12, j + 13, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 13, j + 13, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 14, j + 13, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 0, j + 13, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 13, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 13, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 13, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 13, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 13, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 13, k + 6, NovaCraftBlocks.sculk_block, 0, 2);
			world.setBlock(i + 7, j + 13, k + 6, NovaCraftBlocks.sculk_block, 0, 2);
			world.setBlock(i + 8, j + 13, k + 6, NovaCraftBlocks.sculk_block, 0, 2);
			world.setBlock(i + 9, j + 13, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 10, j + 13, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 11, j + 13, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 12, j + 13, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 13, j + 13, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 14, j + 13, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 0, j + 13, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 13, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 13, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 13, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 13, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 13, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 13, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 7, j + 13, k + 7, NovaCraftBlocks.sculk_block, 0, 2);
			world.setBlock(i + 8, j + 13, k + 7, NovaCraftBlocks.sculk_block, 0, 2);
			world.setBlock(i + 9, j + 13, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 10, j + 13, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 11, j + 13, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 12, j + 13, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 13, j + 13, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 14, j + 13, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 0, j + 13, k + 8, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 13, k + 8, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 13, k + 8, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 13, k + 8, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 13, k + 8, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 13, k + 8, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 13, k + 8, NovaCraftBlocks.sculk_block, 0, 2);
			world.setBlock(i + 7, j + 13, k + 8, NovaCraftBlocks.sculk_block, 0, 2);
			world.setBlock(i + 8, j + 13, k + 8, NovaCraftBlocks.sculk_block, 0, 2);
			world.setBlock(i + 9, j + 13, k + 8, NovaCraftBlocks.sculk_block, 0, 2);
			world.setBlock(i + 10, j + 13, k + 8, Blocks.air, 0, 2);
			world.setBlock(i + 11, j + 13, k + 8, Blocks.air, 0, 2);
			world.setBlock(i + 12, j + 13, k + 8, Blocks.air, 0, 2);
			world.setBlock(i + 13, j + 13, k + 8, Blocks.air, 0, 2);
			world.setBlock(i + 14, j + 13, k + 8, Blocks.air, 0, 2);
			world.setBlock(i + 0, j + 13, k + 9, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 13, k + 9, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 13, k + 9, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 13, k + 9, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 13, k + 9, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 13, k + 9, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 13, k + 9, Blocks.air, 0, 2);
			world.setBlock(i + 7, j + 13, k + 9, Blocks.air, 0, 2);
			world.setBlock(i + 8, j + 13, k + 9, NovaCraftBlocks.sculk_block, 0, 2);
			world.setBlock(i + 9, j + 13, k + 9, NovaCraftBlocks.sculk_block, 0, 2);
			world.setBlock(i + 10, j + 13, k + 9, NovaCraftBlocks.sculk_block, 0, 2);
			world.setBlock(i + 11, j + 13, k + 9, Blocks.air, 0, 2);
			world.setBlock(i + 12, j + 13, k + 9, Blocks.air, 0, 2);
			world.setBlock(i + 13, j + 13, k + 9, Blocks.air, 0, 2);
			world.setBlock(i + 14, j + 13, k + 9, Blocks.air, 0, 2);
			world.setBlock(i + 0, j + 13, k + 10, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 13, k + 10, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 13, k + 10, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 13, k + 10, NovaCraftBlocks.sculk_block, 0, 2);
			world.setBlock(i + 4, j + 13, k + 10, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 13, k + 10, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 13, k + 10, Blocks.air, 0, 2);
			world.setBlock(i + 7, j + 13, k + 10, Blocks.air, 0, 2);
			world.setBlock(i + 8, j + 13, k + 10, Blocks.air, 0, 2);
			world.setBlock(i + 9, j + 13, k + 10, NovaCraftBlocks.sculk_block, 0, 2);
			world.setBlock(i + 10, j + 13, k + 10, NovaCraftBlocks.sculk_block, 0, 2);
			world.setBlock(i + 11, j + 13, k + 10, NovaCraftBlocks.sculk_block, 0, 2);
			world.setBlock(i + 12, j + 13, k + 10, Blocks.air, 0, 2);
			world.setBlock(i + 13, j + 13, k + 10, Blocks.air, 0, 2);
			world.setBlock(i + 14, j + 13, k + 10, Blocks.air, 0, 2);
			world.setBlock(i + 0, j + 13, k + 11, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 13, k + 11, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 13, k + 11, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 13, k + 11, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 13, k + 11, NovaCraftBlocks.sculk_block, 0, 2);
			world.setBlock(i + 5, j + 13, k + 11, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 13, k + 11, Blocks.air, 0, 2);
			world.setBlock(i + 7, j + 13, k + 11, Blocks.air, 0, 2);
			world.setBlock(i + 8, j + 13, k + 11, Blocks.air, 0, 2);
			world.setBlock(i + 9, j + 13, k + 11, Blocks.air, 0, 2);
			world.setBlock(i + 10, j + 13, k + 11, NovaCraftBlocks.sculk_block, 0, 2);
			world.setBlock(i + 11, j + 13, k + 11, Blocks.air, 0, 2);
			world.setBlock(i + 12, j + 13, k + 11, Blocks.air, 0, 2);
			world.setBlock(i + 13, j + 13, k + 11, Blocks.air, 0, 2);
			world.setBlock(i + 14, j + 13, k + 11, Blocks.air, 0, 2);
			world.setBlock(i + 0, j + 13, k + 12, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 13, k + 12, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 13, k + 12, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 13, k + 12, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 13, k + 12, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 13, k + 12, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 13, k + 12, Blocks.air, 0, 2);
			world.setBlock(i + 7, j + 13, k + 12, Blocks.air, 0, 2);
			world.setBlock(i + 8, j + 13, k + 12, Blocks.air, 0, 2);
			world.setBlock(i + 9, j + 13, k + 12, Blocks.air, 0, 2);
			world.setBlock(i + 10, j + 13, k + 12, Blocks.air, 0, 2);
			world.setBlock(i + 11, j + 13, k + 12, Blocks.air, 0, 2);
			world.setBlock(i + 12, j + 13, k + 12, Blocks.air, 0, 2);
			world.setBlock(i + 13, j + 13, k + 12, Blocks.air, 0, 2);
			world.setBlock(i + 14, j + 13, k + 12, Blocks.air, 0, 2);
			world.setBlock(i + 0, j + 13, k + 13, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 13, k + 13, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 13, k + 13, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 13, k + 13, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 13, k + 13, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 13, k + 13, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 13, k + 13, Blocks.air, 0, 2);
			world.setBlock(i + 7, j + 13, k + 13, Blocks.air, 0, 2);
			world.setBlock(i + 8, j + 13, k + 13, Blocks.air, 0, 2);
			world.setBlock(i + 9, j + 13, k + 13, Blocks.air, 0, 2);
			world.setBlock(i + 10, j + 13, k + 13, Blocks.air, 0, 2);
			world.setBlock(i + 11, j + 13, k + 13, Blocks.air, 0, 2);
			world.setBlock(i + 12, j + 13, k + 13, Blocks.air, 0, 2);
			world.setBlock(i + 13, j + 13, k + 13, Blocks.air, 0, 2);
			world.setBlock(i + 14, j + 13, k + 13, Blocks.air, 0, 2);
			world.setBlock(i + 0, j + 13, k + 14, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 13, k + 14, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 13, k + 14, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 13, k + 14, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 13, k + 14, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 13, k + 14, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 13, k + 14, Blocks.air, 0, 2);
			world.setBlock(i + 7, j + 13, k + 14, Blocks.air, 0, 2);
			world.setBlock(i + 8, j + 13, k + 14, Blocks.air, 0, 2);
			world.setBlock(i + 9, j + 13, k + 14, Blocks.air, 0, 2);
			world.setBlock(i + 10, j + 13, k + 14, Blocks.air, 0, 2);
			world.setBlock(i + 11, j + 13, k + 14, Blocks.air, 0, 2);
			world.setBlock(i + 12, j + 13, k + 14, Blocks.air, 0, 2);
			world.setBlock(i + 13, j + 13, k + 14, Blocks.air, 0, 2);
			world.setBlock(i + 14, j + 13, k + 14, Blocks.air, 0, 2);
			world.setBlock(i + 0, j + 14, k + 0, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 14, k + 0, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 14, k + 0, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 14, k + 0, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 14, k + 0, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 14, k + 0, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 14, k + 0, Blocks.air, 0, 2);
			world.setBlock(i + 7, j + 14, k + 0, Blocks.air, 0, 2);
			world.setBlock(i + 8, j + 14, k + 0, Blocks.air, 0, 2);
			world.setBlock(i + 9, j + 14, k + 0, Blocks.air, 0, 2);
			world.setBlock(i + 10, j + 14, k + 0, Blocks.air, 0, 2);
			world.setBlock(i + 11, j + 14, k + 0, Blocks.air, 0, 2);
			world.setBlock(i + 12, j + 14, k + 0, Blocks.air, 0, 2);
			world.setBlock(i + 13, j + 14, k + 0, Blocks.air, 0, 2);
			world.setBlock(i + 14, j + 14, k + 0, Blocks.air, 0, 2);
			world.setBlock(i + 0, j + 14, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 14, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 14, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 14, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 14, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 14, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 14, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 7, j + 14, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 8, j + 14, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 9, j + 14, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 10, j + 14, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 11, j + 14, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 12, j + 14, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 13, j + 14, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 14, j + 14, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 0, j + 14, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 14, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 14, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 14, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 14, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 14, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 14, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 7, j + 14, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 8, j + 14, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 9, j + 14, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 10, j + 14, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 11, j + 14, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 12, j + 14, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 13, j + 14, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 14, j + 14, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 0, j + 14, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 14, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 14, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 14, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 14, k + 3, NovaCraftBlocks.sculk_tentacle_2, 1, 2);
			world.setBlock(i + 5, j + 14, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 14, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 7, j + 14, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 8, j + 14, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 9, j + 14, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 10, j + 14, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 11, j + 14, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 12, j + 14, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 13, j + 14, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 14, j + 14, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 0, j + 14, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 14, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 14, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 14, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 14, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 14, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 14, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 7, j + 14, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 8, j + 14, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 9, j + 14, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 10, j + 14, k + 4, NovaCraftBlocks.sculk_spike, 1, 2);
			world.setBlock(i + 11, j + 14, k + 4, NovaCraftBlocks.sculk_tentacle_2, 1, 2);
			world.setBlock(i + 12, j + 14, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 13, j + 14, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 14, j + 14, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 0, j + 14, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 14, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 14, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 14, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 14, k + 5, NovaCraftBlocks.sculk_spike, 1, 2);
			world.setBlock(i + 5, j + 14, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 14, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 7, j + 14, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 8, j + 14, k + 5, NovaCraftBlocks.sculk_spike, 1, 2);
			world.setBlock(i + 9, j + 14, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 10, j + 14, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 11, j + 14, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 12, j + 14, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 13, j + 14, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 14, j + 14, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 0, j + 14, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 14, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 14, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 14, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 14, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 14, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 14, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 7, j + 14, k + 6, NovaCraftBlocks.sculk_tentacle_2, 1, 2);
			world.setBlock(i + 8, j + 14, k + 6, NovaCraftBlocks.sculk_block, 0, 2);
			world.setBlock(i + 9, j + 14, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 10, j + 14, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 11, j + 14, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 12, j + 14, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 13, j + 14, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 14, j + 14, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 0, j + 14, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 14, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 14, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 14, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 14, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 14, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 14, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 7, j + 14, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 8, j + 14, k + 7, NovaCraftBlocks.sculk_block, 0, 2);
			world.setBlock(i + 9, j + 14, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 10, j + 14, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 11, j + 14, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 12, j + 14, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 13, j + 14, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 14, j + 14, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 0, j + 14, k + 8, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 14, k + 8, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 14, k + 8, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 14, k + 8, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 14, k + 8, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 14, k + 8, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 14, k + 8, NovaCraftBlocks.sculk_spike, 1, 2);
			world.setBlock(i + 7, j + 14, k + 8, NovaCraftBlocks.sculk_block, 0, 2);
			world.setBlock(i + 9, j + 14, k + 8, NovaCraftBlocks.sculk_block, 0, 2);
			world.setBlock(i + 10, j + 14, k + 8, Blocks.air, 0, 2);
			world.setBlock(i + 11, j + 14, k + 8, Blocks.air, 0, 2);
			world.setBlock(i + 12, j + 14, k + 8, Blocks.air, 0, 2);
			world.setBlock(i + 13, j + 14, k + 8, Blocks.air, 0, 2);
			world.setBlock(i + 14, j + 14, k + 8, Blocks.air, 0, 2);
			world.setBlock(i + 0, j + 14, k + 9, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 14, k + 9, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 14, k + 9, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 14, k + 9, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 14, k + 9, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 14, k + 9, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 14, k + 9, Blocks.air, 0, 2);
			world.setBlock(i + 7, j + 14, k + 9, Blocks.air, 0, 2);
			world.setBlock(i + 8, j + 14, k + 9, NovaCraftBlocks.sculk_block, 0, 2);
			world.setBlock(i + 9, j + 14, k + 9, NovaCraftBlocks.sculk_spike, 1, 2);
			world.setBlock(i + 10, j + 14, k + 9, NovaCraftBlocks.sculk_tentacle_2, 1, 2);
			world.setBlock(i + 11, j + 14, k + 9, Blocks.air, 0, 2);
			world.setBlock(i + 12, j + 14, k + 9, Blocks.air, 0, 2);
			world.setBlock(i + 13, j + 14, k + 9, Blocks.air, 0, 2);
			world.setBlock(i + 14, j + 14, k + 9, Blocks.air, 0, 2);
			world.setBlock(i + 0, j + 14, k + 10, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 14, k + 10, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 14, k + 10, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 14, k + 10, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 14, k + 10, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 14, k + 10, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 14, k + 10, Blocks.air, 0, 2);
			world.setBlock(i + 7, j + 14, k + 10, Blocks.air, 0, 2);
			world.setBlock(i + 8, j + 14, k + 10, Blocks.air, 0, 2);
			world.setBlock(i + 9, j + 14, k + 10, Blocks.air, 0, 2);
			world.setBlock(i + 10, j + 14, k + 10, NovaCraftBlocks.sculk_tentacle_2, 1, 2);
			world.setBlock(i + 11, j + 14, k + 10, Blocks.air, 0, 2);
			world.setBlock(i + 12, j + 14, k + 10, Blocks.air, 0, 2);
			world.setBlock(i + 13, j + 14, k + 10, Blocks.air, 0, 2);
			world.setBlock(i + 14, j + 14, k + 10, Blocks.air, 0, 2);
			world.setBlock(i + 0, j + 14, k + 11, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 14, k + 11, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 14, k + 11, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 14, k + 11, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 14, k + 11, NovaCraftBlocks.sculk_tentacle_2, 1, 2);
			world.setBlock(i + 5, j + 14, k + 11, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 14, k + 11, Blocks.air, 0, 2);
			world.setBlock(i + 7, j + 14, k + 11, Blocks.air, 0, 2);
			world.setBlock(i + 8, j + 14, k + 11, Blocks.air, 0, 2);
			world.setBlock(i + 9, j + 14, k + 11, Blocks.air, 0, 2);
			world.setBlock(i + 10, j + 14, k + 11, NovaCraftBlocks.sculk_spike, 1, 2);
			world.setBlock(i + 11, j + 14, k + 11, Blocks.air, 0, 2);
			world.setBlock(i + 12, j + 14, k + 11, Blocks.air, 0, 2);
			world.setBlock(i + 13, j + 14, k + 11, Blocks.air, 0, 2);
			world.setBlock(i + 14, j + 14, k + 11, Blocks.air, 0, 2);
			world.setBlock(i + 0, j + 14, k + 12, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 14, k + 12, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 14, k + 12, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 14, k + 12, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 14, k + 12, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 14, k + 12, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 14, k + 12, Blocks.air, 0, 2);
			world.setBlock(i + 7, j + 14, k + 12, Blocks.air, 0, 2);
			world.setBlock(i + 8, j + 14, k + 12, Blocks.air, 0, 2);
			world.setBlock(i + 9, j + 14, k + 12, Blocks.air, 0, 2);
			world.setBlock(i + 10, j + 14, k + 12, Blocks.air, 0, 2);
			world.setBlock(i + 11, j + 14, k + 12, Blocks.air, 0, 2);
			world.setBlock(i + 12, j + 14, k + 12, Blocks.air, 0, 2);
			world.setBlock(i + 13, j + 14, k + 12, Blocks.air, 0, 2);
			world.setBlock(i + 14, j + 14, k + 12, Blocks.air, 0, 2);
			world.setBlock(i + 0, j + 14, k + 13, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 14, k + 13, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 14, k + 13, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 14, k + 13, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 14, k + 13, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 14, k + 13, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 14, k + 13, Blocks.air, 0, 2);
			world.setBlock(i + 7, j + 14, k + 13, Blocks.air, 0, 2);
			world.setBlock(i + 8, j + 14, k + 13, Blocks.air, 0, 2);
			world.setBlock(i + 9, j + 14, k + 13, Blocks.air, 0, 2);
			world.setBlock(i + 10, j + 14, k + 13, Blocks.air, 0, 2);
			world.setBlock(i + 11, j + 14, k + 13, Blocks.air, 0, 2);
			world.setBlock(i + 12, j + 14, k + 13, Blocks.air, 0, 2);
			world.setBlock(i + 13, j + 14, k + 13, Blocks.air, 0, 2);
			world.setBlock(i + 14, j + 14, k + 13, Blocks.air, 0, 2);
			world.setBlock(i + 0, j + 14, k + 14, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 14, k + 14, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 14, k + 14, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 14, k + 14, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 14, k + 14, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 14, k + 14, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 14, k + 14, Blocks.air, 0, 2);
			world.setBlock(i + 7, j + 14, k + 14, Blocks.air, 0, 2);
			world.setBlock(i + 8, j + 14, k + 14, Blocks.air, 0, 2);
			world.setBlock(i + 9, j + 14, k + 14, Blocks.air, 0, 2);
			world.setBlock(i + 10, j + 14, k + 14, Blocks.air, 0, 2);
			world.setBlock(i + 11, j + 14, k + 14, Blocks.air, 0, 2);
			world.setBlock(i + 12, j + 14, k + 14, Blocks.air, 0, 2);
			world.setBlock(i + 13, j + 14, k + 14, Blocks.air, 0, 2);
			world.setBlock(i + 14, j + 14, k + 14, Blocks.air, 0, 2);
			world.setBlock(i + 0, j + 15, k + 0, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 15, k + 0, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 15, k + 0, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 15, k + 0, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 15, k + 0, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 15, k + 0, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 15, k + 0, Blocks.air, 0, 2);
			world.setBlock(i + 7, j + 15, k + 0, Blocks.air, 0, 2);
			world.setBlock(i + 8, j + 15, k + 0, Blocks.air, 0, 2);
			world.setBlock(i + 9, j + 15, k + 0, Blocks.air, 0, 2);
			world.setBlock(i + 10, j + 15, k + 0, Blocks.air, 0, 2);
			world.setBlock(i + 11, j + 15, k + 0, Blocks.air, 0, 2);
			world.setBlock(i + 12, j + 15, k + 0, Blocks.air, 0, 2);
			world.setBlock(i + 13, j + 15, k + 0, Blocks.air, 0, 2);
			world.setBlock(i + 14, j + 15, k + 0, Blocks.air, 0, 2);
			world.setBlock(i + 0, j + 15, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 15, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 15, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 15, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 15, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 15, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 15, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 7, j + 15, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 8, j + 15, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 9, j + 15, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 10, j + 15, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 11, j + 15, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 12, j + 15, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 13, j + 15, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 14, j + 15, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 0, j + 15, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 15, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 15, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 15, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 15, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 15, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 15, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 7, j + 15, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 8, j + 15, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 9, j + 15, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 10, j + 15, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 11, j + 15, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 12, j + 15, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 13, j + 15, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 14, j + 15, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 0, j + 15, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 15, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 15, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 15, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 15, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 15, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 15, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 7, j + 15, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 8, j + 15, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 9, j + 15, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 10, j + 15, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 11, j + 15, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 12, j + 15, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 13, j + 15, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 14, j + 15, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 0, j + 15, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 15, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 15, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 15, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 15, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 15, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 15, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 7, j + 15, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 8, j + 15, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 9, j + 15, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 10, j + 15, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 11, j + 15, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 12, j + 15, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 13, j + 15, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 14, j + 15, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 0, j + 15, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 15, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 15, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 15, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 15, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 15, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 15, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 7, j + 15, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 8, j + 15, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 9, j + 15, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 10, j + 15, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 11, j + 15, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 12, j + 15, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 13, j + 15, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 14, j + 15, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 0, j + 15, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 15, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 15, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 15, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 15, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 15, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 15, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 7, j + 15, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 8, j + 15, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 9, j + 15, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 10, j + 15, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 11, j + 15, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 12, j + 15, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 13, j + 15, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 14, j + 15, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 0, j + 15, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 15, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 15, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 15, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 15, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 15, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 15, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 7, j + 15, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 8, j + 15, k + 7, NovaCraftBlocks.sculk_spike, 1, 2);
			world.setBlock(i + 9, j + 15, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 10, j + 15, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 11, j + 15, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 12, j + 15, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 13, j + 15, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 14, j + 15, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 0, j + 15, k + 8, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 15, k + 8, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 15, k + 8, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 15, k + 8, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 15, k + 8, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 15, k + 8, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 15, k + 8, Blocks.air, 0, 2);
			world.setBlock(i + 7, j + 15, k + 8, Blocks.air, 0, 2);
			world.setBlock(i + 8, j + 15, k + 8, NovaCraftBlocks.sculk_block, 0, 2);
			world.setBlock(i + 9, j + 15, k + 8, NovaCraftBlocks.sculk_spike, 1, 2);
			world.setBlock(i + 10, j + 15, k + 8, Blocks.air, 0, 2);
			world.setBlock(i + 11, j + 15, k + 8, Blocks.air, 0, 2);
			world.setBlock(i + 12, j + 15, k + 8, Blocks.air, 0, 2);
			world.setBlock(i + 13, j + 15, k + 8, Blocks.air, 0, 2);
			world.setBlock(i + 14, j + 15, k + 8, Blocks.air, 0, 2);
			world.setBlock(i + 0, j + 15, k + 9, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 15, k + 9, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 15, k + 9, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 15, k + 9, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 15, k + 9, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 15, k + 9, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 15, k + 9, Blocks.air, 0, 2);
			world.setBlock(i + 7, j + 15, k + 9, Blocks.air, 0, 2);
			world.setBlock(i + 8, j + 15, k + 9, NovaCraftBlocks.sculk_spike, 1, 2);
			world.setBlock(i + 9, j + 15, k + 9, Blocks.air, 0, 2);
			world.setBlock(i + 10, j + 15, k + 9, Blocks.air, 0, 2);
			world.setBlock(i + 11, j + 15, k + 9, Blocks.air, 0, 2);
			world.setBlock(i + 12, j + 15, k + 9, Blocks.air, 0, 2);
			world.setBlock(i + 13, j + 15, k + 9, Blocks.air, 0, 2);
			world.setBlock(i + 14, j + 15, k + 9, Blocks.air, 0, 2);
			world.setBlock(i + 0, j + 15, k + 10, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 15, k + 10, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 15, k + 10, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 15, k + 10, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 15, k + 10, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 15, k + 10, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 15, k + 10, Blocks.air, 0, 2);
			world.setBlock(i + 7, j + 15, k + 10, Blocks.air, 0, 2);
			world.setBlock(i + 8, j + 15, k + 10, Blocks.air, 0, 2);
			world.setBlock(i + 9, j + 15, k + 10, Blocks.air, 0, 2);
			world.setBlock(i + 10, j + 15, k + 10, Blocks.air, 0, 2);
			world.setBlock(i + 11, j + 15, k + 10, Blocks.air, 0, 2);
			world.setBlock(i + 12, j + 15, k + 10, Blocks.air, 0, 2);
			world.setBlock(i + 13, j + 15, k + 10, Blocks.air, 0, 2);
			world.setBlock(i + 14, j + 15, k + 10, Blocks.air, 0, 2);
			world.setBlock(i + 0, j + 15, k + 11, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 15, k + 11, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 15, k + 11, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 15, k + 11, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 15, k + 11, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 15, k + 11, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 15, k + 11, Blocks.air, 0, 2);
			world.setBlock(i + 7, j + 15, k + 11, Blocks.air, 0, 2);
			world.setBlock(i + 8, j + 15, k + 11, Blocks.air, 0, 2);
			world.setBlock(i + 9, j + 15, k + 11, Blocks.air, 0, 2);
			world.setBlock(i + 10, j + 15, k + 11, Blocks.air, 0, 2);
			world.setBlock(i + 11, j + 15, k + 11, Blocks.air, 0, 2);
			world.setBlock(i + 12, j + 15, k + 11, Blocks.air, 0, 2);
			world.setBlock(i + 13, j + 15, k + 11, Blocks.air, 0, 2);
			world.setBlock(i + 14, j + 15, k + 11, Blocks.air, 0, 2);
			world.setBlock(i + 0, j + 15, k + 12, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 15, k + 12, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 15, k + 12, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 15, k + 12, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 15, k + 12, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 15, k + 12, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 15, k + 12, Blocks.air, 0, 2);
			world.setBlock(i + 7, j + 15, k + 12, Blocks.air, 0, 2);
			world.setBlock(i + 8, j + 15, k + 12, Blocks.air, 0, 2);
			world.setBlock(i + 9, j + 15, k + 12, Blocks.air, 0, 2);
			world.setBlock(i + 10, j + 15, k + 12, Blocks.air, 0, 2);
			world.setBlock(i + 11, j + 15, k + 12, Blocks.air, 0, 2);
			world.setBlock(i + 12, j + 15, k + 12, Blocks.air, 0, 2);
			world.setBlock(i + 13, j + 15, k + 12, Blocks.air, 0, 2);
			world.setBlock(i + 14, j + 15, k + 12, Blocks.air, 0, 2);
			world.setBlock(i + 0, j + 15, k + 13, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 15, k + 13, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 15, k + 13, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 15, k + 13, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 15, k + 13, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 15, k + 13, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 15, k + 13, Blocks.air, 0, 2);
			world.setBlock(i + 7, j + 15, k + 13, Blocks.air, 0, 2);
			world.setBlock(i + 8, j + 15, k + 13, Blocks.air, 0, 2);
			world.setBlock(i + 9, j + 15, k + 13, Blocks.air, 0, 2);
			world.setBlock(i + 10, j + 15, k + 13, Blocks.air, 0, 2);
			world.setBlock(i + 11, j + 15, k + 13, Blocks.air, 0, 2);
			world.setBlock(i + 12, j + 15, k + 13, Blocks.air, 0, 2);
			world.setBlock(i + 13, j + 15, k + 13, Blocks.air, 0, 2);
			world.setBlock(i + 14, j + 15, k + 13, Blocks.air, 0, 2);
			world.setBlock(i + 0, j + 15, k + 14, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 15, k + 14, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 15, k + 14, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 15, k + 14, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 15, k + 14, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 15, k + 14, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 15, k + 14, Blocks.air, 0, 2);
			world.setBlock(i + 7, j + 15, k + 14, Blocks.air, 0, 2);
			world.setBlock(i + 8, j + 15, k + 14, Blocks.air, 0, 2);
			world.setBlock(i + 9, j + 15, k + 14, Blocks.air, 0, 2);
			world.setBlock(i + 10, j + 15, k + 14, Blocks.air, 0, 2);
			world.setBlock(i + 11, j + 15, k + 14, Blocks.air, 0, 2);
			world.setBlock(i + 12, j + 15, k + 14, Blocks.air, 0, 2);
			world.setBlock(i + 13, j + 15, k + 14, Blocks.air, 0, 2);
			world.setBlock(i + 14, j + 15, k + 14, Blocks.air, 0, 2);
			world.setBlock(i + 0, j + 16, k + 0, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 16, k + 0, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 16, k + 0, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 16, k + 0, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 16, k + 0, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 16, k + 0, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 16, k + 0, Blocks.air, 0, 2);
			world.setBlock(i + 7, j + 16, k + 0, Blocks.air, 0, 2);
			world.setBlock(i + 8, j + 16, k + 0, Blocks.air, 0, 2);
			world.setBlock(i + 9, j + 16, k + 0, Blocks.air, 0, 2);
			world.setBlock(i + 10, j + 16, k + 0, Blocks.air, 0, 2);
			world.setBlock(i + 11, j + 16, k + 0, Blocks.air, 0, 2);
			world.setBlock(i + 12, j + 16, k + 0, Blocks.air, 0, 2);
			world.setBlock(i + 13, j + 16, k + 0, Blocks.air, 0, 2);
			world.setBlock(i + 14, j + 16, k + 0, Blocks.air, 0, 2);
			world.setBlock(i + 0, j + 16, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 16, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 16, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 16, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 16, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 16, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 16, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 7, j + 16, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 8, j + 16, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 9, j + 16, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 10, j + 16, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 11, j + 16, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 12, j + 16, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 13, j + 16, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 14, j + 16, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 0, j + 16, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 16, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 16, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 16, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 16, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 16, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 16, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 7, j + 16, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 8, j + 16, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 9, j + 16, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 10, j + 16, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 11, j + 16, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 12, j + 16, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 13, j + 16, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 14, j + 16, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 0, j + 16, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 16, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 16, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 16, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 16, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 16, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 16, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 7, j + 16, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 8, j + 16, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 9, j + 16, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 10, j + 16, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 11, j + 16, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 12, j + 16, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 13, j + 16, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 14, j + 16, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 0, j + 16, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 16, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 16, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 16, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 16, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 16, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 16, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 7, j + 16, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 8, j + 16, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 9, j + 16, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 10, j + 16, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 11, j + 16, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 12, j + 16, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 13, j + 16, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 14, j + 16, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 0, j + 16, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 16, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 16, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 16, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 16, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 16, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 16, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 7, j + 16, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 8, j + 16, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 9, j + 16, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 10, j + 16, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 11, j + 16, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 12, j + 16, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 13, j + 16, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 14, j + 16, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 0, j + 16, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 16, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 16, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 16, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 16, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 16, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 16, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 7, j + 16, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 8, j + 16, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 9, j + 16, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 10, j + 16, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 11, j + 16, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 12, j + 16, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 13, j + 16, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 14, j + 16, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 0, j + 16, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 16, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 16, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 16, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 16, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 16, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 16, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 7, j + 16, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 8, j + 16, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 9, j + 16, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 10, j + 16, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 11, j + 16, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 12, j + 16, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 13, j + 16, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 14, j + 16, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 0, j + 16, k + 8, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 16, k + 8, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 16, k + 8, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 16, k + 8, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 16, k + 8, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 16, k + 8, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 16, k + 8, Blocks.air, 0, 2);
			world.setBlock(i + 7, j + 16, k + 8, Blocks.air, 0, 2);
			world.setBlock(i + 8, j + 16, k + 8, NovaCraftBlocks.sculk_spike, 1, 2);
			world.setBlock(i + 9, j + 16, k + 8, Blocks.air, 0, 2);
			world.setBlock(i + 10, j + 16, k + 8, Blocks.air, 0, 2);
			world.setBlock(i + 11, j + 16, k + 8, Blocks.air, 0, 2);
			world.setBlock(i + 12, j + 16, k + 8, Blocks.air, 0, 2);
			world.setBlock(i + 13, j + 16, k + 8, Blocks.air, 0, 2);
			world.setBlock(i + 14, j + 16, k + 8, Blocks.air, 0, 2);
			world.setBlock(i + 0, j + 16, k + 9, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 16, k + 9, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 16, k + 9, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 16, k + 9, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 16, k + 9, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 16, k + 9, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 16, k + 9, Blocks.air, 0, 2);
			world.setBlock(i + 7, j + 16, k + 9, Blocks.air, 0, 2);
			world.setBlock(i + 8, j + 16, k + 9, Blocks.air, 0, 2);
			world.setBlock(i + 9, j + 16, k + 9, Blocks.air, 0, 2);
			world.setBlock(i + 10, j + 16, k + 9, Blocks.air, 0, 2);
			world.setBlock(i + 11, j + 16, k + 9, Blocks.air, 0, 2);
			world.setBlock(i + 12, j + 16, k + 9, Blocks.air, 0, 2);
			world.setBlock(i + 13, j + 16, k + 9, Blocks.air, 0, 2);
			world.setBlock(i + 14, j + 16, k + 9, Blocks.air, 0, 2);
			world.setBlock(i + 0, j + 16, k + 10, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 16, k + 10, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 16, k + 10, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 16, k + 10, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 16, k + 10, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 16, k + 10, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 16, k + 10, Blocks.air, 0, 2);
			world.setBlock(i + 7, j + 16, k + 10, Blocks.air, 0, 2);
			world.setBlock(i + 8, j + 16, k + 10, Blocks.air, 0, 2);
			world.setBlock(i + 9, j + 16, k + 10, Blocks.air, 0, 2);
			world.setBlock(i + 10, j + 16, k + 10, Blocks.air, 0, 2);
			world.setBlock(i + 11, j + 16, k + 10, Blocks.air, 0, 2);
			world.setBlock(i + 12, j + 16, k + 10, Blocks.air, 0, 2);
			world.setBlock(i + 13, j + 16, k + 10, Blocks.air, 0, 2);
			world.setBlock(i + 14, j + 16, k + 10, Blocks.air, 0, 2);
			world.setBlock(i + 0, j + 16, k + 11, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 16, k + 11, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 16, k + 11, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 16, k + 11, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 16, k + 11, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 16, k + 11, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 16, k + 11, Blocks.air, 0, 2);
			world.setBlock(i + 7, j + 16, k + 11, Blocks.air, 0, 2);
			world.setBlock(i + 8, j + 16, k + 11, Blocks.air, 0, 2);
			world.setBlock(i + 9, j + 16, k + 11, Blocks.air, 0, 2);
			world.setBlock(i + 10, j + 16, k + 11, Blocks.air, 0, 2);
			world.setBlock(i + 11, j + 16, k + 11, Blocks.air, 0, 2);
			world.setBlock(i + 12, j + 16, k + 11, Blocks.air, 0, 2);
			world.setBlock(i + 13, j + 16, k + 11, Blocks.air, 0, 2);
			world.setBlock(i + 14, j + 16, k + 11, Blocks.air, 0, 2);
			world.setBlock(i + 0, j + 16, k + 12, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 16, k + 12, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 16, k + 12, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 16, k + 12, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 16, k + 12, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 16, k + 12, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 16, k + 12, Blocks.air, 0, 2);
			world.setBlock(i + 7, j + 16, k + 12, Blocks.air, 0, 2);
			world.setBlock(i + 8, j + 16, k + 12, Blocks.air, 0, 2);
			world.setBlock(i + 9, j + 16, k + 12, Blocks.air, 0, 2);
			world.setBlock(i + 10, j + 16, k + 12, Blocks.air, 0, 2);
			world.setBlock(i + 11, j + 16, k + 12, Blocks.air, 0, 2);
			world.setBlock(i + 12, j + 16, k + 12, Blocks.air, 0, 2);
			world.setBlock(i + 13, j + 16, k + 12, Blocks.air, 0, 2);
			world.setBlock(i + 14, j + 16, k + 12, Blocks.air, 0, 2);
			world.setBlock(i + 0, j + 16, k + 13, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 16, k + 13, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 16, k + 13, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 16, k + 13, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 16, k + 13, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 16, k + 13, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 16, k + 13, Blocks.air, 0, 2);
			world.setBlock(i + 7, j + 16, k + 13, Blocks.air, 0, 2);
			world.setBlock(i + 8, j + 16, k + 13, Blocks.air, 0, 2);
			world.setBlock(i + 9, j + 16, k + 13, Blocks.air, 0, 2);
			world.setBlock(i + 10, j + 16, k + 13, Blocks.air, 0, 2);
			world.setBlock(i + 11, j + 16, k + 13, Blocks.air, 0, 2);
			world.setBlock(i + 12, j + 16, k + 13, Blocks.air, 0, 2);
			world.setBlock(i + 13, j + 16, k + 13, Blocks.air, 0, 2);
			world.setBlock(i + 14, j + 16, k + 13, Blocks.air, 0, 2);
			world.setBlock(i + 0, j + 16, k + 14, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 16, k + 14, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 16, k + 14, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 16, k + 14, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 16, k + 14, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 16, k + 14, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 16, k + 14, Blocks.air, 0, 2);
			world.setBlock(i + 7, j + 16, k + 14, Blocks.air, 0, 2);
			world.setBlock(i + 8, j + 16, k + 14, Blocks.air, 0, 2);
			world.setBlock(i + 9, j + 16, k + 14, Blocks.air, 0, 2);
			world.setBlock(i + 10, j + 16, k + 14, Blocks.air, 0, 2);
			world.setBlock(i + 11, j + 16, k + 14, Blocks.air, 0, 2);
			world.setBlock(i + 12, j + 16, k + 14, Blocks.air, 0, 2);
			world.setBlock(i + 13, j + 16, k + 14, Blocks.air, 0, 2);
			world.setBlock(i + 14, j + 16, k + 14, Blocks.air, 0, 2);
			
			world.setBlock(i + 1, j + 3, k + 6, Blocks.furnace, 5, 2);
			world.setBlock(i + 1, j + 3, k + 5, Blocks.furnace, 5, 2);
			world.setBlock(i + 1, j + 3, k + 7, Blocks.furnace, 5, 2);
			world.setBlock(i + 1, j + 3, k + 8, Blocks.furnace, 5, 2);
			world.setBlock(i + 1, j + 3, k + 9, Blocks.furnace, 5, 2);
			
			world.setBlock(i + 1, j + 5, k + 5, Blocks.chest, 5, 2);
			world.setBlock(i + 1, j + 5, k + 9, Blocks.chest, 5, 2);
			world.setBlock(i + 1, j + 5, k + 7, Blocks.chest, 5, 2);			
			world.setBlock(i + 1, j + 5, k + 6, Blocks.trapped_chest, 5, 2);
			world.setBlock(i + 1, j + 5, k + 8, Blocks.trapped_chest, 5, 2);
			
			world.setBlock(i + 8, j + 14, k + 8, Blocks.mob_spawner, 0, 2);
			TileEntityMobSpawner tileentitymobspawner2 = (TileEntityMobSpawner)world.getTileEntity(i + 8, j + 14, k + 8);
	        
	        if (tileentitymobspawner2 != null)
	        {
	        	tileentitymobspawner2.func_145881_a().setEntityName("nova_craft.sculk_incinerator");
	        }
			
			world.setBlock(i + 9, j + 9, k + 4, Blocks.mob_spawner, 0, 2);
			TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner)world.getTileEntity(i + 9, j + 9, k + 4);
	        
	        if (tileentitymobspawner != null)
	        {
	        	tileentitymobspawner.func_145881_a().setEntityName("nova_craft.sculk_dweller");
	        }
			
			world.setBlock(i + 1, j + 1, k + 6, Blocks.trapped_chest, 5, 2);
			TileEntityChest chest = (TileEntityChest) world.getTileEntity(i + 1, j + 1, k + 6);

			for (int slot = 0; slot < 3 + random.nextInt(25); slot++) {
				chest.setInventorySlotContents(random.nextInt(chest.getSizeInventory()), this.getSmeltLoot(random));
			}
			
			world.setBlock(i + 1, j + 1, k + 8, Blocks.trapped_chest, 5, 2);
			TileEntityChest chest2 = (TileEntityChest) world.getTileEntity(i + 1, j + 1, k + 8);

			for (int slot = 0; slot < 3 + random.nextInt(25); slot++) {
				chest2.setInventorySlotContents(random.nextInt(chest2.getSizeInventory()), this.getSmeltLoot(random));
			}
			
			world.setBlock(i + 1, j + 1, k + 7, Blocks.chest, 5, 2);
			TileEntityChest chest3 = (TileEntityChest) world.getTileEntity(i + 1, j + 1, k + 7);

			for (int slot = 0; slot < 3 + random.nextInt(25); slot++) {
				chest3.setInventorySlotContents(random.nextInt(chest3.getSizeInventory()), this.getSmeltLoot(random));
			}
			
			world.setBlock(i + 1, j + 1, k + 5, Blocks.chest, 5, 2);
			TileEntityChest chest4 = (TileEntityChest) world.getTileEntity(i + 1, j + 1, k + 5);

			for (int slot = 0; slot < 3 + random.nextInt(25); slot++) {
				chest4.setInventorySlotContents(random.nextInt(chest4.getSizeInventory()), this.getSmeltLoot(random));
			}
			
			world.setBlock(i + 1, j + 1, k + 9, Blocks.chest, 5, 2);
			TileEntityChest chest5 = (TileEntityChest) world.getTileEntity(i + 1, j + 1, k + 9);

			for (int slot = 0; slot < 3 + random.nextInt(25); slot++) {
				chest5.setInventorySlotContents(random.nextInt(chest5.getSizeInventory()), this.getSmeltLoot(random));
			}
			
			world.setBlock(i + 4, j + 2, k + 4, Blocks.chest, 5, 2);
			TileEntityChest chest6 = (TileEntityChest) world.getTileEntity(i + 4, j + 2, k + 4);

			for (int slot = 0; slot < 3 + random.nextInt(25); slot++) {
				chest6.setInventorySlotContents(random.nextInt(chest6.getSizeInventory()), this.getChestLoot(random));
			}
			
			world.setBlock(i + 4, j + 2, k + 10, Blocks.chest, 5, 2);
			TileEntityChest chest7 = (TileEntityChest) world.getTileEntity(i + 4, j + 2, k + 10);

			for (int slot = 0; slot < 3 + random.nextInt(25); slot++) {
				chest7.setInventorySlotContents(random.nextInt(chest7.getSizeInventory()), this.getChestLoot(random));
			}
			
		 return true;
	 }
	 
	 private ItemStack getSmeltLoot(Random random) {
			int item = random.nextInt(10);
			switch (item) {
				case 0:
					return new ItemStack(Blocks.stone, random.nextInt(14) + 26);
				case 1:
					return new ItemStack(NovaCraftBlocks.grimstone, random.nextInt(14) + 26);
				case 2:
					return new ItemStack(NovaCraftBlocks.nullstone, random.nextInt(8) + 22);
				case 3:
					return new ItemStack(NovaCraftBlocks.grimstone, random.nextInt(12) + 18);
				case 4:
					return new ItemStack(Blocks.glass, random.nextInt(5) + 9);
				case 5:
					return new ItemStack(Items.iron_ingot, random.nextInt(12) + 18);
				case 6:
					return new ItemStack(Items.gold_ingot, random.nextInt(4) + 8);
				case 7: 
					return new ItemStack(NovaCraftItems.vanite_ingot, random.nextInt(18) + 18);
				case 8: 
					return new ItemStack(Items.coal, random.nextInt(12) + 18);	                
				default: {
					return new ItemStack(NovaCraftBlocks.grimstone, random.nextInt(12) + 18);
				}
			}
		}
	 
	 private ItemStack getChestLoot(Random random) {
			int item = random.nextInt(16);
			switch (item) {
				case 0:
					return new ItemStack(Blocks.cobblestone, random.nextInt(14) + 12);
				case 1:
					return new ItemStack(NovaCraftBlocks.cobbled_grimstone, random.nextInt(14) + 26);
				case 2:
					return new ItemStack(NovaCraftBlocks.cobbled_nullstone, random.nextInt(8) + 22);
				case 3:
					return new ItemStack(NovaCraftBlocks.cobbled_grimstone, random.nextInt(12) + 18);
				case 4:
					return new ItemStack(Blocks.sand, random.nextInt(5) + 9);
				case 5:
					return new ItemStack(Blocks.iron_ore, random.nextInt(12) + 18);	
				case 6:
					return new ItemStack(Blocks.gold_ore, random.nextInt(4) + 8);
				case 7: 
					return new ItemStack(NovaCraftItems.vanite_chunk, random.nextInt(18) + 18);
				case 8: 
					return new ItemStack(Blocks.log, random.nextInt(8) + 9);
				case 9:
					//Pick enchants
				    Enchantment[] pickEnchantments = {Enchantment.efficiency, Enchantment.unbreaking};
				    Enchantment[] pickEnchantments2 = {Enchantment.silkTouch, Enchantment.fortune};
				    Enchantment enchantment3 = pickEnchantments[random.nextInt(pickEnchantments.length)];
				    Enchantment enchantment33 = pickEnchantments2[random.nextInt(pickEnchantments2.length)];	
				    int maxLevel3 = enchantment3.getMaxLevel();			
				    int maxLevel33 = enchantment33.getMaxLevel();	
				    ItemStack itemStack3 = new ItemStack(Items.diamond_pickaxe);
				    
				    itemStack3.addEnchantment(enchantment3, maxLevel3);
				    itemStack3.addEnchantment(enchantment33, maxLevel33);
				    
				    return itemStack3;
				case 10:
					//shovel enchants
				    Enchantment[] pickEnchantments3 = {Enchantment.efficiency, Enchantment.unbreaking};
				    Enchantment[] pickEnchantments4 = {Enchantment.silkTouch, Enchantment.fortune};
				    Enchantment enchantment4 = pickEnchantments3[random.nextInt(pickEnchantments3.length)];
				    Enchantment enchantment44 = pickEnchantments4[random.nextInt(pickEnchantments4.length)];	
				    int maxLevel4 = enchantment4.getMaxLevel();			
				    int maxLevel44 = enchantment44.getMaxLevel();	
				    ItemStack itemStack4 = new ItemStack(Items.diamond_shovel);
				    
				    itemStack4.addEnchantment(enchantment4, maxLevel4);
				    itemStack4.addEnchantment(enchantment44, maxLevel44);
				    
				    return itemStack4;				    
				case 11:
					//Pick enchants
				    Enchantment[] pickEnchantments5 = {Enchantment.efficiency, Enchantment.unbreaking};
				    Enchantment[] pickEnchantments6 = {Enchantment.silkTouch, Enchantment.fortune};
				    Enchantment enchantment5 = pickEnchantments5[random.nextInt(pickEnchantments5.length)];
				    Enchantment enchantment55 = pickEnchantments6[random.nextInt(pickEnchantments6.length)];	
				    int maxLevel5 = enchantment5.getMaxLevel();			
				    int maxLevel55 = enchantment55.getMaxLevel();	
				    ItemStack itemStack5 = new ItemStack(NovaCraftItems.pherithium_pickaxe);
				    
				    itemStack5.addEnchantment(enchantment5, maxLevel5);
				    itemStack5.addEnchantment(enchantment55, maxLevel55);
				    
				    return itemStack5;
				case 12: 
					if (random.nextInt(4) == 0) {
					return new ItemStack(NovaCraftItems.primeval_mace, 1);
					}
				case 13: 
					if (Loader.isModLoaded("etfuturum")) {
						return new ItemStack(OtherModBlocks.cobbled_deepslate, random.nextInt(24) + 18);
					}
					else {
						return new ItemStack(Blocks.cobblestone, random.nextInt(24) + 18);
					}
				case 14: 
					return new ItemStack(NovaCraftItems.vanite_chunk, random.nextInt(18) + 18);
				default: {
					return new ItemStack(NovaCraftBlocks.cobbled_nullstone, random.nextInt(12) + 18);
				}
			}		 
	 	}

}
