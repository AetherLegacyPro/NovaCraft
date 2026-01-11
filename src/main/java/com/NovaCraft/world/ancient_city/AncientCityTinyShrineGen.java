package com.NovaCraft.world.ancient_city;

import com.NovaCraft.config.ConfigsCompact;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.world.gen.feature.*;
import net.minecraft.block.*;
import net.minecraft.world.*;
import java.util.*;

import com.NovaCraft.config.Configs;
import com.NovaCraft.registry.OtherModBlocks;
import com.NovaCraftBlocks.NovaCraftBlocks;

import cpw.mods.fml.common.Loader;
import net.minecraft.init.*;

public class AncientCityTinyShrineGen extends WorldGenerator
{
	public AncientCityTinyShrineGen() {

	}
	
	private Block PlaceDeepslate;
	private Block PlaceDeepslateBricks;
	private Block PlaceCrackedDeepslateTiles;
	private Block PlacePolishedDeepslate;
	private Block PlaceCobbledDeepslate;
	
	private Block PlaceDeepslateBrickSlab;
	private Block PlaceDeepslateBrickWall;

	private Block determineIfCobbledDeepslateExists(World world, int x, int y, int z) {
		Block existingBlock = world.getBlock(x, y, z);
		if (ConfigsCompact.enableCobbledDeepslate && Loader.isModLoaded("etfuturum")) {
			try {
				Block cobbled_deepslate = GameRegistry.findBlock("etfuturum", "cobbled_deepslate");
				if (cobbled_deepslate != null && (existingBlock == null || existingBlock != cobbled_deepslate)) {
					return cobbled_deepslate;
				}
			} catch (Exception ex) {
				if (Configs.enableDebugMode) {
					System.out.println("Missing Cobbled Deepslate from Et Futurum Requiem, using Cobbled Grimstone instead...");
				}
				return NovaCraftBlocks.cobbled_grimstone;
			}
		}

		return NovaCraftBlocks.cobbled_grimstone;
	}

	private Block determineIfDeepslateExists(World world, int x, int y, int z) {
		Block existingBlock = world.getBlock(x, y, z);
		if (ConfigsCompact.enableDeepslate && Loader.isModLoaded("etfuturum")) {
			try {
				Block deepslate = GameRegistry.findBlock("etfuturum", "deepslate");
				if (deepslate != null && (existingBlock == null || existingBlock != deepslate)) {
					return deepslate;
				}
			} catch (Exception ex) {
				if (Configs.enableDebugMode) {
					System.out.println("Missing Deepslate from Et Futurum Requiem, using Grimstone instead...");
				}
				return NovaCraftBlocks.grimstone;
			}
		}

		return NovaCraftBlocks.grimstone;
	}

	private Block determineIfDeepslateBricksExists(World world, int x, int y, int z) {
		Block existingBlock = world.getBlock(x, y, z);
		if (ConfigsCompact.enableDeepslateBricks && Loader.isModLoaded("etfuturum")) {
			try {
				Block deepslate_bricks = GameRegistry.findBlock("etfuturum", "deepslate_bricks");
				if (deepslate_bricks != null && (existingBlock == null || existingBlock != deepslate_bricks)) {
					return deepslate_bricks;
				}
			} catch (Exception ex) {
				if (Configs.enableDebugMode) {
					System.out.println("Missing Deepslate Bricks from Et Futurum Requiem, using Grimstone Bricks instead...");
				}
				return NovaCraftBlocks.grimstone_bricks;
			}
		}

		return NovaCraftBlocks.grimstone_bricks;
	}

	private Block determineIfCrackedDeepslateTilesExist(World world, int x, int y, int z) {
		Block existingBlock = world.getBlock(x, y, z);
		if (ConfigsCompact.enableDeepslateBricks && Loader.isModLoaded("etfuturum")) {
			try {
				Block deepslate_bricks = GameRegistry.findBlock("etfuturum", "deepslate_bricks");
				if (deepslate_bricks != null && (existingBlock == null || existingBlock != deepslate_bricks)) {
					return deepslate_bricks;
				}
			} catch (Exception ex) {
				if (Configs.enableDebugMode) {
					System.out.println("Missing Cracked Deepslate Tiles from Et Futurum Requiem, using Cracked Grimstone Tiles instead...");
				}
				return NovaCraftBlocks.cracked_grimstone_tiles;
			}
		}

		return NovaCraftBlocks.cracked_grimstone_tiles;
	}

	private Block determineIfPolishedDeepslateExists(World world, int x, int y, int z) {
		Block existingBlock = world.getBlock(x, y, z);
		if (ConfigsCompact.enableDeepslateBricks && Loader.isModLoaded("etfuturum")) {
			try {
				Block polished_deepslate = GameRegistry.findBlock("etfuturum", "polished_deepslate");
				if (polished_deepslate != null && (existingBlock == null || existingBlock != polished_deepslate)) {
					return polished_deepslate;
				}
			} catch (Exception ex) {
				if (Configs.enableDebugMode) {
					System.out.println("Missing Polished Deepslate from Et Futurum Requiem, using Polished Grimstone instead...");
				}
				return NovaCraftBlocks.polished_grimstone;
			}
		}

		return NovaCraftBlocks.polished_grimstone;
	}

	private Block determineIfDeepslateSlabExists(World world, int x, int y, int z) {
		Block existingBlock = world.getBlock(x, y, z);
		if (ConfigsCompact.enableDeepslateBricks && Loader.isModLoaded("etfuturum")) {
			try {
				Block deepslate_brick_slab = GameRegistry.findBlock("etfuturum", "deepslate_brick_slab");
				if (deepslate_brick_slab != null && (existingBlock == null || existingBlock != deepslate_brick_slab)) {
					return deepslate_brick_slab;
				}
			} catch (Exception ex) {
				if (Configs.enableDebugMode) {
					System.out.println("Missing Deepslate Brick Slab from Et Futurum Requiem, using Grimstone Brick Slab instead...");
				}
				return NovaCraftBlocks.grimstone_brick_slab;
			}
		}

		return NovaCraftBlocks.grimstone_brick_slab;
	}

	private Block determineIfDeepslateBrickWallExists(World world, int x, int y, int z) {
		Block existingBlock = world.getBlock(x, y, z);
		if (ConfigsCompact.enableDeepslateBricks && Loader.isModLoaded("etfuturum")) {
			try {
				Block deepslate_brick_wall = GameRegistry.findBlock("etfuturum", "deepslate_brick_wall");
				if (deepslate_brick_wall != null && (existingBlock == null || existingBlock != deepslate_brick_wall)) {
					return deepslate_brick_wall;
				}
			} catch (Exception ex) {
				if (Configs.enableDebugMode) {
					System.out.println("Missing Deepslate from Et Futurum Requiem, using Grimstone instead...");
				}
				return NovaCraftBlocks.grimstone_brick_wall;
			}
		}

		return NovaCraftBlocks.grimstone_brick_wall;
	}
    
    public boolean generate(final World world, final Random random, final int i, final int j, final int k) {
    	PlaceDeepslate = determineIfDeepslateExists(world, i + 1, j + 0, k + 1);
    	PlaceCobbledDeepslate = determineIfCobbledDeepslateExists(world, i + 2, j + 0, k + 2);
    	
    	PlaceDeepslateBricks = determineIfDeepslateBricksExists(world, i + 2, j + 3, k + 3);
    	PlaceCrackedDeepslateTiles = determineIfCrackedDeepslateTilesExist(world, i + 2, j + 2, k + 3);
    	
    	PlacePolishedDeepslate = determineIfPolishedDeepslateExists(world, i + 0, j + 0, k + 0);
    	PlaceDeepslateBrickSlab = determineIfDeepslateSlabExists(world, i + 3, j + 2, k + 3);
    	PlaceDeepslateBrickWall = determineIfDeepslateBrickWallExists(world, i + 1, j + 3, k + 3);
    	
    	world.setBlock(i + 0, j + 0, k + 0, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 1, j + 0, k + 0, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 2, j + 0, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 0, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 0, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 0, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 0, k + 0, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 7, j + 0, k + 0, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 0, j + 0, k + 1, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 1, j + 0, k + 1, PlaceDeepslate, 0, 2);
		world.setBlock(i + 2, j + 0, k + 1, PlaceDeepslate, 0, 2);
		world.setBlock(i + 3, j + 0, k + 1, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 4, j + 0, k + 1, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 5, j + 0, k + 1, PlaceDeepslate, 0, 2);
		world.setBlock(i + 6, j + 0, k + 1, PlaceDeepslate, 0, 2);
		world.setBlock(i + 7, j + 0, k + 1, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 0, j + 0, k + 2, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 1, j + 0, k + 2, PlaceDeepslate, 0, 2);
		world.setBlock(i + 2, j + 0, k + 2, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 3, j + 0, k + 2, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 4, j + 0, k + 2, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 5, j + 0, k + 2, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 6, j + 0, k + 2, PlaceDeepslate, 0, 2);
		world.setBlock(i + 7, j + 0, k + 2, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 0, j + 0, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 0, k + 3, PlaceDeepslate, 0, 2);
		world.setBlock(i + 2, j + 0, k + 3, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 3, j + 0, k + 3, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 4, j + 0, k + 3, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 5, j + 0, k + 3, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 6, j + 0, k + 3, PlaceDeepslate, 0, 2);
		world.setBlock(i + 7, j + 0, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 0, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 0, k + 4, PlaceDeepslate, 0, 2);
		world.setBlock(i + 2, j + 0, k + 4, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 3, j + 0, k + 4, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 4, j + 0, k + 4, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 5, j + 0, k + 4, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 6, j + 0, k + 4, PlaceDeepslate, 0, 2);
		world.setBlock(i + 7, j + 0, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 0, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 0, k + 5, PlaceDeepslate, 0, 2);
		world.setBlock(i + 2, j + 0, k + 5, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 3, j + 0, k + 5, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 4, j + 0, k + 5, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 5, j + 0, k + 5, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 6, j + 0, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 0, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 0, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 0, k + 6, PlaceDeepslate, 0, 2);
		world.setBlock(i + 2, j + 0, k + 6, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 3, j + 0, k + 6, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 4, j + 0, k + 6, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 5, j + 0, k + 6, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 6, j + 0, k + 6, PlaceDeepslate, 0, 2);
		world.setBlock(i + 7, j + 0, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 0, k + 7, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 1, j + 0, k + 7, PlaceDeepslate, 0, 2);
		world.setBlock(i + 2, j + 0, k + 7, PlaceDeepslate, 0, 2);
		world.setBlock(i + 3, j + 0, k + 7, PlaceDeepslate, 0, 2);
		world.setBlock(i + 4, j + 0, k + 7, PlaceDeepslate, 0, 2);
		world.setBlock(i + 5, j + 0, k + 7, PlaceDeepslate, 0, 2);
		world.setBlock(i + 6, j + 0, k + 7, PlaceDeepslate, 0, 2);
		world.setBlock(i + 7, j + 0, k + 7, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 0, j + 0, k + 8, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 1, j + 0, k + 8, PlaceDeepslate, 0, 2);
		world.setBlock(i + 2, j + 0, k + 8, PlaceDeepslate, 0, 2);
		world.setBlock(i + 3, j + 0, k + 8, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 4, j + 0, k + 8, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 5, j + 0, k + 8, PlaceDeepslate, 0, 2);
		world.setBlock(i + 6, j + 0, k + 8, PlaceDeepslate, 0, 2);
		world.setBlock(i + 7, j + 0, k + 8, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 0, j + 0, k + 9, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 1, j + 0, k + 9, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 2, j + 0, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 0, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 0, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 0, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 0, k + 9, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 7, j + 0, k + 9, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 0, j + 1, k + 0, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 1, j + 1, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 1, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 1, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 1, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 1, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 1, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 1, k + 0, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 0, j + 1, k + 1, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 1, j + 1, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 1, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 1, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 1, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 1, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 1, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 1, k + 1, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 0, j + 1, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 1, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 1, k + 2, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 3, j + 1, k + 2, PlaceDeepslate, 0, 2);
		world.setBlock(i + 4, j + 1, k + 2, PlaceDeepslate, 0, 2);
		world.setBlock(i + 5, j + 1, k + 2, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 6, j + 1, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 1, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 1, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 1, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 1, k + 3, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 3, j + 1, k + 3, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 4, j + 1, k + 3, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 5, j + 1, k + 3, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 6, j + 1, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 1, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 1, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 1, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 1, k + 4, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 3, j + 1, k + 4, PlaceDeepslate, 0, 2);
		world.setBlock(i + 4, j + 1, k + 4, PlaceDeepslate, 0, 2);
		world.setBlock(i + 5, j + 1, k + 4, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 6, j + 1, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 1, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 1, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 1, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 1, k + 5, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 3, j + 1, k + 5, PlaceDeepslate, 0, 2);
		world.setBlock(i + 4, j + 1, k + 5, PlaceDeepslate, 0, 2);
		world.setBlock(i + 5, j + 1, k + 5, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 6, j + 1, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 1, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 1, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 1, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 1, k + 6, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 3, j + 1, k + 6, PlaceDeepslate, 0, 2);
		world.setBlock(i + 4, j + 1, k + 6, PlaceDeepslate, 0, 2);
		world.setBlock(i + 5, j + 1, k + 6, PlacePolishedDeepslate, 0, 2);
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
		world.setBlock(i + 0, j + 1, k + 8, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 1, j + 1, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 1, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 1, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 1, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 1, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 1, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 1, k + 8, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 0, j + 1, k + 9, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 1, j + 1, k + 9, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 2, j + 1, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 1, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 1, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 1, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 1, k + 9, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 7, j + 1, k + 9, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 0, j + 2, k + 0, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 1, j + 2, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 2, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 2, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 2, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 2, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 2, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 2, k + 0, PlacePolishedDeepslate, 0, 2);
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
		world.setBlock(i + 2, j + 2, k + 3, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 3, j + 2, k + 3, PlaceDeepslateBrickSlab, 1, 2);
		world.setBlock(i + 4, j + 2, k + 3, PlaceDeepslateBrickSlab, 1, 2);
		world.setBlock(i + 5, j + 2, k + 3, PlaceCrackedDeepslateTiles, 3, 2);
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
		world.setBlock(i + 0, j + 2, k + 9, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 1, j + 2, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 2, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 2, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 2, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 2, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 2, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 2, k + 9, PlacePolishedDeepslate, 0, 2);
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
		world.setBlock(i + 1, j + 3, k + 3, PlaceDeepslateBrickWall, 1, 2);
		world.setBlock(i + 2, j + 3, k + 3, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 3, j + 3, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 3, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 3, k + 3, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 6, j + 3, k + 3, PlaceDeepslateBrickWall, 1, 2);
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
		world.setBlock(i + 2, j + 4, k + 3, PlaceDeepslateBrickSlab, 0, 2);
		world.setBlock(i + 3, j + 4, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 4, k + 3, PlaceDeepslateBrickSlab, 0, 2);
		world.setBlock(i + 5, j + 4, k + 3, PlaceDeepslateBrickSlab, 0, 2);
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
