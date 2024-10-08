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

public class AncientCityCrystalFarmGen extends WorldGenerator
{
	public AncientCityCrystalFarmGen() {

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
		 
		 	world.setBlock(i + 0, j + 0, k + 0, NovaCraftBlocks.vanite_brick_stairs, 2, 2);
			world.setBlock(i + 1, j + 0, k + 0, NovaCraftBlocks.vanite_brick_stairs, 2, 2);
			world.setBlock(i + 2, j + 0, k + 0, NovaCraftBlocks.vanite_brick_stairs, 2, 2);
			world.setBlock(i + 3, j + 0, k + 0, NovaCraftBlocks.vanite_brick_stairs, 2, 2);
			world.setBlock(i + 4, j + 0, k + 0, NovaCraftBlocks.vanite_brick_stairs, 2, 2);
			world.setBlock(i + 5, j + 0, k + 0, NovaCraftBlocks.vanite_brick_stairs, 2, 2);
			world.setBlock(i + 6, j + 0, k + 0, NovaCraftBlocks.vanite_brick_stairs, 2, 2);
			world.setBlock(i + 0, j + 0, k + 1, NovaCraftBlocks.vanite_brick_stairs, 0, 2);
			world.setBlock(i + 1, j + 0, k + 1, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 3, j + 0, k + 1, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 4, j + 0, k + 1, NovaCraftBlocks.sculk_block, 0, 2);
			world.setBlock(i + 5, j + 0, k + 1, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 0, k + 1, NovaCraftBlocks.vanite_brick_stairs, 1, 2);
			world.setBlock(i + 0, j + 0, k + 2, NovaCraftBlocks.vanite_brick_stairs, 0, 2);
			world.setBlock(i + 1, j + 0, k + 2, NovaCraftBlocks.sculk_block, 0, 2);
			world.setBlock(i + 4, j + 0, k + 2, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 5, j + 0, k + 2, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 0, k + 2, NovaCraftBlocks.vanite_brick_stairs, 1, 2);
			world.setBlock(i + 0, j + 0, k + 3, NovaCraftBlocks.vanite_brick_stairs, 0, 2);
			world.setBlock(i + 6, j + 0, k + 3, NovaCraftBlocks.vanite_brick_stairs, 1, 2);
			world.setBlock(i + 0, j + 0, k + 4, NovaCraftBlocks.vanite_brick_stairs, 0, 2);
			world.setBlock(i + 1, j + 0, k + 4, NovaCraftBlocks.sculk_block, 0, 2);
			world.setBlock(i + 5, j + 0, k + 4, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 0, k + 4, NovaCraftBlocks.vanite_brick_stairs, 1, 2);
			world.setBlock(i + 0, j + 0, k + 5, NovaCraftBlocks.vanite_brick_stairs, 0, 2);
			world.setBlock(i + 1, j + 0, k + 5, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 2, j + 0, k + 5, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 5, j + 0, k + 5, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 0, k + 5, NovaCraftBlocks.vanite_brick_stairs, 1, 2);
			world.setBlock(i + 0, j + 0, k + 6, NovaCraftBlocks.vanite_brick_stairs, 3, 2);
			world.setBlock(i + 1, j + 0, k + 6, NovaCraftBlocks.vanite_brick_stairs, 3, 2);
			world.setBlock(i + 2, j + 0, k + 6, NovaCraftBlocks.vanite_brick_stairs, 3, 2);
			world.setBlock(i + 3, j + 0, k + 6, NovaCraftBlocks.vanite_brick_stairs, 3, 2);
			world.setBlock(i + 4, j + 0, k + 6, NovaCraftBlocks.vanite_brick_stairs, 3, 2);
			world.setBlock(i + 5, j + 0, k + 6, NovaCraftBlocks.vanite_brick_stairs, 3, 2);
			world.setBlock(i + 6, j + 0, k + 6, NovaCraftBlocks.vanite_brick_stairs, 1, 2);
			world.setBlock(i + 0, j + 1, k + 0, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 1, k + 0, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 1, k + 0, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 1, k + 0, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 1, k + 0, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 1, k + 0, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 1, k + 0, Blocks.air, 0, 2);
			world.setBlock(i + 0, j + 1, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 1, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 1, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 1, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 1, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 1, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 1, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 0, j + 1, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 1, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 1, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 1, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 1, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 0, j + 1, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 1, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 1, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 1, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 1, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 1, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 0, j + 1, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 1, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 1, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 1, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 1, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 1, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 1, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 0, j + 1, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 1, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 1, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 1, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 1, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 1, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 0, j + 1, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 1, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 1, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 1, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 1, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 1, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 1, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 0, j + 2, k + 0, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 2, k + 0, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 2, k + 0, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 2, k + 0, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 2, k + 0, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 2, k + 0, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 2, k + 0, Blocks.air, 0, 2);
			world.setBlock(i + 0, j + 2, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 2, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 2, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 2, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 2, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 2, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 2, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 0, j + 2, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 2, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 2, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 2, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 2, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 2, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 0, j + 2, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 2, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 2, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 2, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 2, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 2, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 2, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 0, j + 2, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 2, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 2, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 2, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 2, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 2, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 2, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 0, j + 2, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 2, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 2, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 2, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 2, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 2, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 2, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 0, j + 2, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 2, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 2, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 2, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 2, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 2, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 2, k + 6, Blocks.air, 0, 2);
			
			int rand = (int)(1 + Math.random() * 4);
			switch (rand)
	        {			        
	        case 1:			
	        	world.setBlock(i + 4, j + 1, k + 2, NovaCraftBlocks.budding_copartz_block, 0, 2);
				world.setBlock(i + 2, j + 0, k + 2, NovaCraftBlocks.budding_copartz_block, 0, 2);
				world.setBlock(i + 3, j + 0, k + 3, NovaCraftBlocks.budding_copartz_block, 0, 2);
				world.setBlock(i + 4, j + 0, k + 5, NovaCraftBlocks.budding_copartz_block, 0, 2);			
				world.setBlock(i + 2, j + 0, k + 1, NovaCraftBlocks.copartz_block, 0, 2);
				world.setBlock(i + 3, j + 0, k + 2, NovaCraftBlocks.copartz_block, 0, 2);
				world.setBlock(i + 1, j + 0, k + 3, NovaCraftBlocks.copartz_block, 0, 2);
				world.setBlock(i + 2, j + 0, k + 3, NovaCraftBlocks.copartz_block, 0, 2);		
				world.setBlock(i + 4, j + 0, k + 3, NovaCraftBlocks.copartz_block, 0, 2);
				world.setBlock(i + 5, j + 0, k + 3, NovaCraftBlocks.copartz_block, 0, 2);
				world.setBlock(i + 2, j + 0, k + 4, NovaCraftBlocks.copartz_block, 0, 2);
				world.setBlock(i + 3, j + 0, k + 4, NovaCraftBlocks.copartz_block, 0, 2);
				world.setBlock(i + 4, j + 0, k + 4, NovaCraftBlocks.copartz_block, 0, 2);
				world.setBlock(i + 3, j + 0, k + 5, NovaCraftBlocks.copartz_block, 0, 2);			
				world.setBlock(i + 3, j + 1, k + 3, NovaCraftBlocks.copartz_cluster_2, 7, 2);
				world.setBlock(i + 4, j + 1, k + 5, NovaCraftBlocks.copartz_cluster_2, 7, 2);
				world.setBlock(i + 4, j + 2, k + 2, NovaCraftBlocks.copartz_cluster_2, 7, 2);
				world.setBlock(i + 2, j + 1, k + 2, NovaCraftBlocks.copartz_cluster_2, 7, 2);
			
	        case 2:			
				world.setBlock(i + 4, j + 1, k + 2, NovaCraftBlocks.budding_larimar_block, 0, 2);
				world.setBlock(i + 2, j + 0, k + 2, NovaCraftBlocks.budding_larimar_block, 0, 2);
				world.setBlock(i + 3, j + 0, k + 3, NovaCraftBlocks.budding_larimar_block, 0, 2);
				world.setBlock(i + 4, j + 0, k + 5, NovaCraftBlocks.budding_larimar_block, 0, 2);			
				world.setBlock(i + 2, j + 0, k + 1, NovaCraftBlocks.larimar_block, 0, 2);
				world.setBlock(i + 3, j + 0, k + 2, NovaCraftBlocks.larimar_block, 0, 2);
				world.setBlock(i + 1, j + 0, k + 3, NovaCraftBlocks.larimar_block, 0, 2);
				world.setBlock(i + 2, j + 0, k + 3, NovaCraftBlocks.larimar_block, 0, 2);		
				world.setBlock(i + 4, j + 0, k + 3, NovaCraftBlocks.larimar_block, 0, 2);
				world.setBlock(i + 5, j + 0, k + 3, NovaCraftBlocks.larimar_block, 0, 2);
				world.setBlock(i + 2, j + 0, k + 4, NovaCraftBlocks.larimar_block, 0, 2);
				world.setBlock(i + 3, j + 0, k + 4, NovaCraftBlocks.larimar_block, 0, 2);
				world.setBlock(i + 4, j + 0, k + 4, NovaCraftBlocks.larimar_block, 0, 2);
				world.setBlock(i + 3, j + 0, k + 5, NovaCraftBlocks.larimar_block, 0, 2);			
				world.setBlock(i + 3, j + 1, k + 3, NovaCraftBlocks.larimar_cluster_2, 7, 2);
				world.setBlock(i + 4, j + 1, k + 5, NovaCraftBlocks.larimar_cluster_2, 7, 2);
				world.setBlock(i + 4, j + 2, k + 2, NovaCraftBlocks.larimar_cluster_2, 7, 2);
				world.setBlock(i + 2, j + 1, k + 2, NovaCraftBlocks.larimar_cluster_2, 7, 2);
				
	        case 3:			
				world.setBlock(i + 4, j + 1, k + 2, NovaCraftBlocks.budding_tsavorokite_block, 0, 2);
				world.setBlock(i + 2, j + 0, k + 2, NovaCraftBlocks.budding_tsavorokite_block, 0, 2);
				world.setBlock(i + 3, j + 0, k + 3, NovaCraftBlocks.budding_tsavorokite_block, 0, 2);
				world.setBlock(i + 4, j + 0, k + 5, NovaCraftBlocks.budding_tsavorokite_block, 0, 2);			
				world.setBlock(i + 2, j + 0, k + 1, NovaCraftBlocks.tsavorokite_block, 0, 2);
				world.setBlock(i + 3, j + 0, k + 2, NovaCraftBlocks.tsavorokite_block, 0, 2);
				world.setBlock(i + 1, j + 0, k + 3, NovaCraftBlocks.tsavorokite_block, 0, 2);
				world.setBlock(i + 2, j + 0, k + 3, NovaCraftBlocks.tsavorokite_block, 0, 2);		
				world.setBlock(i + 4, j + 0, k + 3, NovaCraftBlocks.tsavorokite_block, 0, 2);
				world.setBlock(i + 5, j + 0, k + 3, NovaCraftBlocks.tsavorokite_block, 0, 2);
				world.setBlock(i + 2, j + 0, k + 4, NovaCraftBlocks.tsavorokite_block, 0, 2);
				world.setBlock(i + 3, j + 0, k + 4, NovaCraftBlocks.tsavorokite_block, 0, 2);
				world.setBlock(i + 4, j + 0, k + 4, NovaCraftBlocks.tsavorokite_block, 0, 2);
				world.setBlock(i + 3, j + 0, k + 5, NovaCraftBlocks.tsavorokite_block, 0, 2);			
				world.setBlock(i + 3, j + 1, k + 3, NovaCraftBlocks.tsavorokite_cluster_2, 7, 2);
				world.setBlock(i + 4, j + 1, k + 5, NovaCraftBlocks.tsavorokite_cluster_2, 7, 2);
				world.setBlock(i + 4, j + 2, k + 2, NovaCraftBlocks.tsavorokite_cluster_2, 7, 2);
				world.setBlock(i + 2, j + 1, k + 2, NovaCraftBlocks.tsavorokite_cluster_2, 7, 2);
				
	        case 4:			
				world.setBlock(i + 4, j + 1, k + 2, NovaCraftBlocks.budding_yttrlinsite_block, 0, 2);
				world.setBlock(i + 2, j + 0, k + 2, NovaCraftBlocks.budding_yttrlinsite_block, 0, 2);
				world.setBlock(i + 3, j + 0, k + 3, NovaCraftBlocks.budding_yttrlinsite_block, 0, 2);
				world.setBlock(i + 4, j + 0, k + 5, NovaCraftBlocks.budding_yttrlinsite_block, 0, 2);			
				world.setBlock(i + 2, j + 0, k + 1, NovaCraftBlocks.yttrlinsite_block, 0, 2);
				world.setBlock(i + 3, j + 0, k + 2, NovaCraftBlocks.yttrlinsite_block, 0, 2);
				world.setBlock(i + 1, j + 0, k + 3, NovaCraftBlocks.yttrlinsite_block, 0, 2);
				world.setBlock(i + 2, j + 0, k + 3, NovaCraftBlocks.yttrlinsite_block, 0, 2);		
				world.setBlock(i + 4, j + 0, k + 3, NovaCraftBlocks.yttrlinsite_block, 0, 2);
				world.setBlock(i + 5, j + 0, k + 3, NovaCraftBlocks.yttrlinsite_block, 0, 2);
				world.setBlock(i + 2, j + 0, k + 4, NovaCraftBlocks.yttrlinsite_block, 0, 2);
				world.setBlock(i + 3, j + 0, k + 4, NovaCraftBlocks.yttrlinsite_block, 0, 2);
				world.setBlock(i + 4, j + 0, k + 4, NovaCraftBlocks.yttrlinsite_block, 0, 2);
				world.setBlock(i + 3, j + 0, k + 5, NovaCraftBlocks.yttrlinsite_block, 0, 2);			
				world.setBlock(i + 3, j + 1, k + 3, NovaCraftBlocks.yttrlinsite_cluster_2, 7, 2);
				world.setBlock(i + 4, j + 1, k + 5, NovaCraftBlocks.yttrlinsite_cluster_2, 7, 2);
				world.setBlock(i + 4, j + 2, k + 2, NovaCraftBlocks.yttrlinsite_cluster_2, 7, 2);
				world.setBlock(i + 2, j + 1, k + 2, NovaCraftBlocks.yttrlinsite_cluster_2, 7, 2);
	        }
		 
		 return true;
	 }

}
