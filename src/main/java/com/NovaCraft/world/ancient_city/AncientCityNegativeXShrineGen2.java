package com.NovaCraft.world.ancient_city;

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

public class AncientCityNegativeXShrineGen2 extends WorldGenerator
{
	public AncientCityNegativeXShrineGen2() {

	}

	private static final Block soul_sand = Blocks.soul_sand;
	private Block PlaceDeepslate;
	private Block PlaceDeepslateBricks;
	private Block PlaceDeepslateTiles;
	private Block PlaceCrackedDeepslateTiles;
	private Block PlaceCrackedDeepslateBricks;
	private Block PlaceChiseledDeepslate;
	private Block PlacePolishedDeepslate;
	private Block PlaceSoulLantern;
	private Block PlaceCobbledDeepslate;
	private Block PlaceSoulFire;
	private Block PlaceDarkOakFence;
	private Block PlaceBasalt;
	private Block PlaceSmoothBasalt;
	private Block ShouldPlaceSoulSand;
	
	private Block PlaceDeepslateBrickSlab;
	private Block PlaceDeepslateTileStairs;
	private Block PlaceDeepslateBrickStairs;
	private Block PlacePolishedDeepslateStairs;
	private Block PlaceCobbledDeepslateStairs;
	private Block PlaceDeepslateWall;
	private Block PlaceDeepslateBrickWall;

	private Block determineIfCobbledDeepslateExists(World world, int x, int y, int z) {
		Block existingBlock = world.getBlock(x, y, z);
		if (Configs.enableCobbledDeepslateInAncientCity && Loader.isModLoaded("etfuturum")) {
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
		if (Configs.enableDeepslateInAncientCity && Loader.isModLoaded("etfuturum")) {
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
		if (Configs.enableDeepslateBricksInAncientCity && Loader.isModLoaded("etfuturum")) {
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

	private Block determineIfCrackedDeepslateBricksExists(World world, int x, int y, int z) {
		Block existingBlock = world.getBlock(x, y, z);
		if (Configs.enableDeepslateBricksInAncientCity && Loader.isModLoaded("etfuturum")) {
			try {
				Block deepslate_bricks = GameRegistry.findBlock("etfuturum", "deepslate_bricks");
				if (deepslate_bricks != null && (existingBlock == null || existingBlock != deepslate_bricks)) {
					return deepslate_bricks;
				}
			} catch (Exception ex) {
				if (Configs.enableDebugMode) {
					System.out.println("Missing Cracked Deepslate Bricks from Et Futurum Requiem, using Cracked Grimstone Bricks instead...");
				}
				return NovaCraftBlocks.cracked_grimstone_bricks;
			}
		}

		return NovaCraftBlocks.cracked_grimstone_bricks;
	}

	private Block determineIfDeepslateTilesExist(World world, int x, int y, int z) {
		Block existingBlock = world.getBlock(x, y, z);
		if (Configs.enableDeepslateBricksInAncientCity && Loader.isModLoaded("etfuturum")) {
			try {
				Block deepslate_bricks = GameRegistry.findBlock("etfuturum", "deepslate_bricks");
				if (deepslate_bricks != null && (existingBlock == null || existingBlock != deepslate_bricks)) {
					return deepslate_bricks;
				}
			} catch (Exception ex) {
				if (Configs.enableDebugMode) {
					System.out.println("Missing Deepslate Tiles from Et Futurum Requiem, using Grimstone Tiles instead...");
				}
				return NovaCraftBlocks.grimstone_tiles;
			}
		}

		return NovaCraftBlocks.grimstone_tiles;
	}

	private Block determineIfCrackedDeepslateTilesExist(World world, int x, int y, int z) {
		Block existingBlock = world.getBlock(x, y, z);
		if (Configs.enableDeepslateBricksInAncientCity && Loader.isModLoaded("etfuturum")) {
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
		if (Configs.enableDeepslateBricksInAncientCity && Loader.isModLoaded("etfuturum")) {
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

	private Block determineIfChiseledDeepslateExist(World world, int x, int y, int z) {
		Block existingBlock = world.getBlock(x, y, z);
		if (Configs.enableDeepslateBricksInAncientCity && Loader.isModLoaded("etfuturum")) {
			try {
				Block deepslate_bricks = GameRegistry.findBlock("etfuturum", "deepslate_bricks");
				if (deepslate_bricks != null && (existingBlock == null || existingBlock != deepslate_bricks)) {
					return deepslate_bricks;
				}
			} catch (Exception ex) {
				if (Configs.enableDebugMode) {
					System.out.println("Missing Chiseled Deepslate from Et Futurum Requiem, using Chiseled Grimstone instead...");
				}
				return NovaCraftBlocks.chiseled_grimstone;
			}
		}

		return NovaCraftBlocks.chiseled_grimstone;
	}

	private Block determineIfDeepslateTileStairsExists(World world, int x, int y, int z) {
		Block existingBlock = world.getBlock(x, y, z);
		if (Configs.enableDeepslateBricksInAncientCity && Loader.isModLoaded("etfuturum")) {
			try {
				Block deepslate_tile_stairs = GameRegistry.findBlock("etfuturum", "deepslate_tile_stairs");
				if (deepslate_tile_stairs != null && (existingBlock == null || existingBlock != deepslate_tile_stairs)) {
					return deepslate_tile_stairs;
				}
			} catch (Exception ex) {
				if (Configs.enableDebugMode) {
					System.out.println("Missing Deepslate Tile Stairs from Et Futurum Requiem, using Grimstone Tile Stairs instead...");
				}
				return NovaCraftBlocks.grimstone_tiled_stairs;
			}
		}

		return NovaCraftBlocks.grimstone_tiled_stairs;
	}

	private Block determineIfDeepslateBrickStairsExists(World world, int x, int y, int z) {
		Block existingBlock = world.getBlock(x, y, z);
		if (Configs.enableDeepslateBricksInAncientCity && Loader.isModLoaded("etfuturum")) {
			try {
				Block deepslate_brick_stairs = GameRegistry.findBlock("etfuturum", "deepslate_brick_stairs");
				if (deepslate_brick_stairs != null && (existingBlock == null || existingBlock != deepslate_brick_stairs)) {
					return deepslate_brick_stairs;
				}
			} catch (Exception ex) {
				if (Configs.enableDebugMode) {
					System.out.println("Missing Deepslate Tile Stairs from Et Futurum Requiem, using Grimstone Tile Stairs instead...");
				}
				return NovaCraftBlocks.grimstone_brick_stairs;
			}
		}

		return NovaCraftBlocks.grimstone_brick_stairs;
	}

	private Block determineIfDeepslateSlabExists(World world, int x, int y, int z) {
		Block existingBlock = world.getBlock(x, y, z);
		if (Configs.enableDeepslateBricksInAncientCity && Loader.isModLoaded("etfuturum")) {
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

	private Block determineIfShouldPlaceSoulSand(World world, int x, int y, int z) {
		Block existingBlock = world.getBlock(x, y, z);

		if (Configs.enableEtFuturumSoulFireInAncientCity && Loader.isModLoaded("netherlicious") && (existingBlock == null || existingBlock != soul_sand)) {
			return soul_sand;
		} else if (Loader.isModLoaded("etfuturum") && (existingBlock == null || existingBlock != soul_sand)) {
			return soul_sand;
		}	else {
			return Blocks.netherrack;
		}
	}

	private Block determineIfSoulFireEtExists(World world, int x, int y, int z) {
		Block existingBlock = world.getBlock(x, y, z);

		if (!(Configs.enableEtFuturumSoulFireInAncientCity) && Loader.isModLoaded("netherlicious")) {
			try {
				Block SoulFire = GameRegistry.findBlock("netherlicious", "SoulFire");
				if (SoulFire != null && (existingBlock == null || existingBlock != SoulFire)) {
					return SoulFire;
				}
			} catch (Exception ex) {
				if (Configs.enableDebugMode) {
					System.out.println("Failed to Find Netherlicious Soul Fire, trying Et Futurum Requiem...");
				}
			}
		}

		if (Loader.isModLoaded("etfuturum")) {
			return Blocks.fire;
		}

		return NovaCraftBlocks.deepfire;
	}
    
    public boolean generate(final World world, final Random random, final int i, final int j, final int k) {
    	PlaceDeepslate = determineIfDeepslateExists(world, i + 16, j + 6, k + 4);
    	PlaceCobbledDeepslate = determineIfCobbledDeepslateExists(world, i + 0, j + 7, k + 8);
    	
    	PlaceDeepslateBricks = determineIfDeepslateBricksExists(world, i + 11, j + 6, k + 19);
    	PlaceCrackedDeepslateBricks = determineIfCrackedDeepslateBricksExists(world, i + 8, j + 9, k + 20);
    	PlaceDeepslateTiles = determineIfDeepslateTilesExist(world, i + 1, j + 6, k + 17);
    	PlaceCrackedDeepslateTiles = determineIfCrackedDeepslateTilesExist(world, i + 0, j + 6, k + 17);
    	PlaceChiseledDeepslate = determineIfChiseledDeepslateExist(world, i + 8, j + 8, k + 19);
    	PlacePolishedDeepslate = determineIfPolishedDeepslateExists(world, i + 3, j + 8, k + 0);

    	PlaceDeepslateBrickStairs = determineIfDeepslateBrickStairsExists(world, i + 0, j + 6, k + 6);
    	PlaceDeepslateTileStairs = determineIfDeepslateTileStairsExists(world, i + 1, j + 6, k + 16);
    	PlaceDeepslateBrickSlab = determineIfDeepslateSlabExists(world, i + 10, j + 6, k + 7);
    	
    	ShouldPlaceSoulSand = determineIfShouldPlaceSoulSand(world, i + 6, j + 6, k + 19);
    	PlaceSoulFire = determineIfSoulFireEtExists(world, i + 6, j + 7, k + 19);    	
    	
    	
    	world.setBlock(i + 13, j + 6, k + 2, NovaCraftBlocks.sculk_vein, 1, 2);
		world.setBlock(i + 14, j + 6, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 6, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 6, k + 2, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 17, j + 6, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 6, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 6, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 6, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 6, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 6, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 6, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 6, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 6, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 6, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 6, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 6, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 6, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 6, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 6, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 6, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 6, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 6, k + 3, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 17, j + 6, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 6, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 6, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 6, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 6, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 6, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 6, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 6, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 6, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 6, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 6, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 6, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 6, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 6, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 6, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 6, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 6, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 6, k + 4, PlaceDeepslate, 0, 2);
		world.setBlock(i + 17, j + 6, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 6, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 6, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 6, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 6, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 6, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 6, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 6, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 6, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 6, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 6, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 6, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 6, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 6, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 6, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 6, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 6, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 6, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 6, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 6, k + 6, PlaceDeepslateBrickStairs, 2, 2);
		world.setBlock(i + 1, j + 6, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 6, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 6, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 6, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 6, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 6, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 6, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 6, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 6, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 6, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 6, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 6, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 6, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 6, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 6, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 6, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 6, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 6, k + 7, PlaceDeepslate, 0, 2);
		world.setBlock(i + 1, j + 6, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 6, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 6, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 6, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 6, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 6, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 6, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 6, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 6, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 6, k + 7, PlaceDeepslateBrickSlab, 0, 2);
		world.setBlock(i + 11, j + 6, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 6, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 6, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 6, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 6, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 6, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 6, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 6, k + 8, PlaceDeepslate, 0, 2);
		world.setBlock(i + 1, j + 6, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 6, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 6, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 6, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 6, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 6, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 6, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 6, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 6, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 6, k + 8, PlaceDeepslateBrickSlab, 0, 2);
		world.setBlock(i + 11, j + 6, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 6, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 6, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 6, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 6, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 6, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 6, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 6, k + 9, PlaceDeepslate, 0, 2);
		world.setBlock(i + 1, j + 6, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 6, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 6, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 6, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 6, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 6, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 6, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 6, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 6, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 6, k + 9, PlaceDeepslateBrickSlab, 0, 2);
		world.setBlock(i + 11, j + 6, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 6, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 6, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 6, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 6, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 6, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 6, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 6, k + 10, PlaceDeepslateBrickStairs, 3, 2);
		world.setBlock(i + 1, j + 6, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 6, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 6, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 6, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 6, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 6, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 6, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 6, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 6, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 6, k + 10, PlaceDeepslateBrickSlab, 0, 2);
		world.setBlock(i + 11, j + 6, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 6, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 6, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 6, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 6, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 6, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 6, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 6, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 6, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 6, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 6, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 6, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 6, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 6, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 6, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 6, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 6, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 6, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 6, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 6, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 6, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 6, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 6, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 6, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 6, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 6, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 6, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 6, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 6, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 6, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 6, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 6, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 6, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 6, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 6, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 6, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 6, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 6, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 6, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 6, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 6, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 6, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 6, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 6, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 6, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 6, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 6, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 6, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 6, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 6, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 6, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 6, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 6, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 6, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 6, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 6, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 6, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 6, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 6, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 6, k + 13, PlaceDeepslate, 0, 2);
		world.setBlock(i + 17, j + 6, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 6, k + 14, PlaceDeepslate, 0, 2);
		world.setBlock(i + 1, j + 6, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 6, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 6, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 6, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 6, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 6, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 6, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 6, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 6, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 6, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 6, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 6, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 6, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 6, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 6, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 6, k + 14, PlaceDeepslate, 0, 2);
		world.setBlock(i + 17, j + 6, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 6, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 6, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 6, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 6, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 6, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 6, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 6, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 6, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 6, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 6, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 6, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 6, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 6, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 6, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 6, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 6, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 6, k + 15, PlaceDeepslate, 0, 2);
		world.setBlock(i + 17, j + 6, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 6, k + 16, PlaceDeepslate, 0, 2);
		world.setBlock(i + 1, j + 6, k + 16, PlaceDeepslateTileStairs, 2, 2);
		world.setBlock(i + 2, j + 6, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 6, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 6, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 6, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 6, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 6, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 6, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 6, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 6, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 6, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 6, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 6, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 6, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 6, k + 16, PlaceDeepslateTileStairs, 2, 2);
		world.setBlock(i + 16, j + 6, k + 16, PlaceDeepslate, 0, 2);
		world.setBlock(i + 17, j + 6, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 6, k + 17, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 1, j + 6, k + 17, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 2, j + 6, k + 17, PlaceDeepslateBrickStairs, 5, 2);
		world.setBlock(i + 3, j + 6, k + 17, PlaceDeepslateBrickStairs, 4, 2);
		world.setBlock(i + 4, j + 6, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 6, k + 17, PlaceDeepslateBrickStairs, 5, 2);
		world.setBlock(i + 6, j + 6, k + 17, PlaceDeepslateBrickStairs, 4, 2);
		world.setBlock(i + 7, j + 6, k + 17, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 8, j + 6, k + 17, PlaceDeepslateBrickSlab, 0, 2);
		world.setBlock(i + 9, j + 6, k + 17, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 10, j + 6, k + 17, PlaceDeepslateBrickStairs, 5, 2);
		world.setBlock(i + 11, j + 6, k + 17, PlaceDeepslateBrickStairs, 4, 2);
		world.setBlock(i + 12, j + 6, k + 17, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 13, j + 6, k + 17, PlaceDeepslateBrickStairs, 5, 2);
		world.setBlock(i + 14, j + 6, k + 17, PlaceDeepslateBrickStairs, 4, 2);
		world.setBlock(i + 15, j + 6, k + 17, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 16, j + 6, k + 17, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 17, j + 6, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 6, k + 18, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 1, j + 6, k + 18, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 2, j + 6, k + 18, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 3, j + 6, k + 18, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 4, j + 6, k + 18, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 5, j + 6, k + 18, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 6, j + 6, k + 18, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 7, j + 6, k + 18, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 8, j + 6, k + 18, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 9, j + 6, k + 18, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 10, j + 6, k + 18, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 11, j + 6, k + 18, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 12, j + 6, k + 18, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 13, j + 6, k + 18, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 14, j + 6, k + 18, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 15, j + 6, k + 18, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 16, j + 6, k + 18, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 17, j + 6, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 6, k + 19, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 1, j + 6, k + 19, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 2, j + 6, k + 19, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 3, j + 6, k + 19, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 4, j + 6, k + 19, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 5, j + 6, k + 19, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 6, j + 6, k + 19, ShouldPlaceSoulSand, 0, 2);
		world.setBlock(i + 7, j + 6, k + 19, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 8, j + 6, k + 19, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 9, j + 6, k + 19, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 10, j + 6, k + 19, ShouldPlaceSoulSand, 0, 2);
		world.setBlock(i + 11, j + 6, k + 19, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 12, j + 6, k + 19, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 13, j + 6, k + 19, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 14, j + 6, k + 19, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 15, j + 6, k + 19, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 16, j + 6, k + 19, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 17, j + 6, k + 19, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 6, k + 20, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 1, j + 6, k + 20, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 2, j + 6, k + 20, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 3, j + 6, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 6, k + 20, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 5, j + 6, k + 20, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 6, j + 6, k + 20, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 7, j + 6, k + 20, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 8, j + 6, k + 20, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 9, j + 6, k + 20, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 10, j + 6, k + 20, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 11, j + 6, k + 20, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 12, j + 6, k + 20, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 13, j + 6, k + 20, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 14, j + 6, k + 20, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 15, j + 6, k + 20, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 16, j + 6, k + 20, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 17, j + 6, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 7, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 7, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 7, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 7, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 7, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 7, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 7, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 7, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 7, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 7, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 7, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 7, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 7, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 7, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 7, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 7, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 7, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 7, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 7, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 7, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 7, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 7, k + 1, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 4, j + 7, k + 1, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 5, j + 7, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 7, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 7, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 7, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 7, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 7, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 7, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 7, k + 1, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 13, j + 7, k + 1, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 14, j + 7, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 7, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 7, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 7, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 7, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 7, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 7, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 7, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 7, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 7, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 7, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 7, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 7, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 7, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 7, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 7, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 7, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 7, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 7, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 7, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 7, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 7, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 7, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 7, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 7, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 7, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 7, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 7, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 7, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 7, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 7, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 7, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 7, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 7, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 7, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 7, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 7, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 7, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 7, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 7, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 7, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 7, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 7, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 7, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 7, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 7, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 7, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 7, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 7, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 7, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 7, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 7, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 7, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 7, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 7, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 7, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 7, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 7, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 7, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 7, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 7, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 7, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 7, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 7, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 7, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 7, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 7, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 7, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 7, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 7, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 7, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 7, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 7, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 7, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 7, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 7, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 7, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 7, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 7, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 7, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 7, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 7, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 7, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 7, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 7, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 7, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 7, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 7, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 7, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 7, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 7, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 7, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 7, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 7, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 7, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 7, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 7, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 7, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 7, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 7, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 7, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 7, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 7, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 7, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 7, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 7, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 7, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 7, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 7, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 7, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 7, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 7, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 7, k + 8, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 1, j + 7, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 7, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 7, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 7, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 7, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 7, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 7, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 7, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 7, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 7, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 7, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 7, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 7, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 7, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 7, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 7, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 7, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 7, k + 9, PlaceDeepslateBrickStairs, 3, 2);
		world.setBlock(i + 1, j + 7, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 7, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 7, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 7, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 7, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 7, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 7, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 7, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 7, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 7, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 7, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 7, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 7, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 7, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 7, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 7, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 7, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 7, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 7, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 7, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 7, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 7, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 7, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 7, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 7, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 7, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 7, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 7, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 7, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 7, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 7, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 7, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 7, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 7, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 7, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 7, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 7, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 7, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 7, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 7, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 7, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 7, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 7, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 7, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 7, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 7, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 7, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 7, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 7, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 7, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 7, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 7, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 7, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 7, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 7, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 7, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 7, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 7, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 7, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 7, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 7, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 7, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 7, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 7, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 7, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 7, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 7, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 7, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 7, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 7, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 7, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 7, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 7, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 7, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 7, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 7, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 7, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 7, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 7, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 7, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 7, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 7, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 7, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 7, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 7, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 7, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 7, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 7, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 7, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 7, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 7, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 7, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 7, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 7, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 7, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 7, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 7, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 7, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 7, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 7, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 7, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 7, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 7, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 7, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 7, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 7, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 7, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 7, k + 15, PlaceDeepslate, 0, 2);
		world.setBlock(i + 1, j + 7, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 7, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 7, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 7, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 7, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 7, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 7, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 7, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 7, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 7, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 7, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 7, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 7, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 7, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 7, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 7, k + 15, PlaceDeepslate, 0, 2);
		world.setBlock(i + 17, j + 7, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 7, k + 16, PlaceDeepslate, 0, 2);
		world.setBlock(i + 1, j + 7, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 7, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 7, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 7, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 7, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 7, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 7, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 7, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 7, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 7, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 7, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 7, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 7, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 7, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 7, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 7, k + 16, PlaceDeepslate, 0, 2);
		world.setBlock(i + 17, j + 7, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 7, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 7, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 7, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 7, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 7, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 7, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 7, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 7, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 7, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 7, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 7, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 7, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 7, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 7, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 7, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 7, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 7, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 7, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 7, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 7, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 7, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 7, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 7, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 7, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 7, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 7, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 7, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 7, k + 18, NovaCraftBlocks.dim_vanite_torch, 5, 2);
		world.setBlock(i + 10, j + 7, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 7, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 7, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 7, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 7, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 7, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 7, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 7, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 7, k + 19, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 7, k + 19, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 7, k + 19, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 7, k + 19, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 7, k + 19, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 7, k + 19, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 7, k + 19, PlaceSoulFire, 15, 2);
		world.setBlock(i + 7, j + 7, k + 19, PlaceDeepslateBrickStairs, 5, 2);
		world.setBlock(i + 8, j + 7, k + 19, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 9, j + 7, k + 19, PlaceDeepslateBrickStairs, 4, 2);
		world.setBlock(i + 10, j + 7, k + 19, PlaceSoulFire, 15, 2);
		world.setBlock(i + 11, j + 7, k + 19, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 7, k + 19, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 7, k + 19, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 7, k + 19, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 7, k + 19, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 7, k + 19, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 7, k + 19, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 7, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 7, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 7, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 7, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 7, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 7, k + 20, PlaceDeepslateBrickStairs, 0, 2);
		world.setBlock(i + 6, j + 7, k + 20, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 7, j + 7, k + 20, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 8, j + 7, k + 20, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 9, j + 7, k + 20, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 10, j + 7, k + 20, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 11, j + 7, k + 20, PlaceDeepslateBrickStairs, 1, 2);
		world.setBlock(i + 12, j + 7, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 7, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 7, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 7, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 7, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 7, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 8, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 8, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 8, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 8, k + 0, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 4, j + 8, k + 0, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 5, j + 8, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 8, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 8, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 8, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 8, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 8, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 8, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 8, k + 0, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 13, j + 8, k + 0, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 14, j + 8, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 8, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 8, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 8, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 8, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 8, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 8, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 8, k + 1, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 4, j + 8, k + 1, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 5, j + 8, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 8, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 8, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 8, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 8, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 8, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 8, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 8, k + 1, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 13, j + 8, k + 1, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 14, j + 8, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 8, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 8, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 8, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 8, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 8, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 8, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 8, k + 2, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 4, j + 8, k + 2, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 5, j + 8, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 8, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 8, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 8, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 8, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 8, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 8, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 8, k + 2, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 13, j + 8, k + 2, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 14, j + 8, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 8, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 8, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 8, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 8, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 8, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 8, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 8, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 8, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 8, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 8, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 8, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 8, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 8, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 8, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 8, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 8, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 8, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 8, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 8, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 8, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 8, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 8, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 8, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 8, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 8, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 8, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 8, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 8, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 8, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 8, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 8, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 8, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 8, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 8, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 8, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 8, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 8, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 8, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 8, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 8, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 8, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 8, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 8, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 8, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 8, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 8, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 8, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 8, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 8, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 8, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 8, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 8, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 8, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 8, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 8, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 8, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 8, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 8, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 8, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 8, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 8, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 8, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 8, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 8, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 8, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 8, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 8, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 8, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 8, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 8, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 8, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 8, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 8, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 8, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 8, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 8, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 8, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 8, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 8, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 8, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 8, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 8, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 8, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 8, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 8, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 8, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 8, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 8, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 8, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 8, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 8, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 8, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 8, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 8, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 8, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 8, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 8, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 8, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 8, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 8, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 8, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 8, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 8, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 8, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 8, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 8, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 8, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 8, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 8, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 8, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 8, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 8, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 8, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 8, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 8, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 8, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 8, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 8, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 8, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 8, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 8, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 8, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 8, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 8, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 8, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 8, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 8, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 8, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 8, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 8, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 8, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 8, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 8, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 8, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 8, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 8, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 8, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 8, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 8, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 8, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 8, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 8, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 8, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 8, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 8, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 8, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 8, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 8, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 8, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 8, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 8, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 8, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 8, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 8, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 8, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 8, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 8, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 8, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 8, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 8, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 8, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 8, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 8, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 8, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 8, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 8, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 8, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 8, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 8, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 8, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 8, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 8, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 8, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 8, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 8, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 8, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 8, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 8, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 8, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 8, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 8, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 8, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 8, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 8, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 8, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 8, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 8, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 8, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 8, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 8, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 8, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 8, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 8, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 8, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 8, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 8, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 8, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 8, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 8, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 8, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 8, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 8, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 8, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 8, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 8, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 8, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 8, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 8, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 8, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 8, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 8, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 8, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 8, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 8, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 8, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 8, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 8, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 8, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 8, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 8, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 8, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 8, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 8, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 8, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 8, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 8, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 8, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 8, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 8, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 8, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 8, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 8, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 8, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 8, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 8, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 8, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 8, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 8, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 8, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 8, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 8, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 8, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 8, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 8, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 8, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 8, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 8, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 8, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 8, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 8, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 8, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 8, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 8, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 8, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 8, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 8, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 8, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 8, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 8, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 8, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 8, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 8, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 8, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 8, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 8, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 8, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 8, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 8, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 8, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 8, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 8, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 8, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 8, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 8, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 8, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 8, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 8, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 8, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 8, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 8, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 8, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 8, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 8, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 8, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 8, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 8, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 8, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 8, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 8, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 8, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 8, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 8, k + 19, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 8, k + 19, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 8, k + 19, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 8, k + 19, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 8, k + 19, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 8, k + 19, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 8, k + 19, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 8, k + 19, NovaCraftBlocks.dim_vanite_torch, 5, 2);
		world.setBlock(i + 8, j + 8, k + 19, PlaceChiseledDeepslate, 4, 2);
		world.setBlock(i + 9, j + 8, k + 19, NovaCraftBlocks.dim_vanite_torch, 5, 2);
		world.setBlock(i + 10, j + 8, k + 19, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 8, k + 19, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 8, k + 19, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 8, k + 19, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 8, k + 19, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 8, k + 19, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 8, k + 19, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 8, k + 19, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 8, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 8, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 8, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 8, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 8, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 8, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 8, k + 20, PlaceDeepslateBrickStairs, 0, 2);
		world.setBlock(i + 7, j + 8, k + 20, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 8, j + 8, k + 20, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 9, j + 8, k + 20, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 10, j + 8, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 8, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 8, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 8, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 8, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 8, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 8, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 8, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 9, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 9, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 9, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 9, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 9, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 9, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 9, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 9, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 9, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 9, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 9, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 9, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 9, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 9, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 9, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 9, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 9, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 9, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 9, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 9, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 9, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 9, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 9, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 9, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 9, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 9, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 9, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 9, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 9, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 9, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 9, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 9, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 9, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 9, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 9, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 9, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 9, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 9, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 9, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 9, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 9, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 9, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 9, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 9, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 9, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 9, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 9, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 9, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 9, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 9, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 9, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 9, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 9, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 9, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 9, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 9, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 9, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 9, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 9, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 9, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 9, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 9, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 9, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 9, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 9, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 9, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 9, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 9, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 9, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 9, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 9, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 9, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 9, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 9, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 9, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 9, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 9, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 9, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 9, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 9, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 9, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 9, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 9, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 9, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 9, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 9, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 9, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 9, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 9, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 9, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 9, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 9, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 9, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 9, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 9, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 9, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 9, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 9, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 9, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 9, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 9, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 9, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 9, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 9, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 9, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 9, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 9, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 9, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 9, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 9, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 9, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 9, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 9, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 9, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 9, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 9, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 9, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 9, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 9, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 9, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 9, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 9, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 9, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 9, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 9, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 9, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 9, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 9, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 9, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 9, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 9, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 9, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 9, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 9, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 9, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 9, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 9, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 9, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 9, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 9, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 9, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 9, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 9, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 9, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 9, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 9, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 9, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 9, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 9, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 9, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 9, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 9, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 9, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 9, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 9, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 9, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 9, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 9, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 9, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 9, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 9, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 9, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 9, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 9, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 9, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 9, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 9, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 9, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 9, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 9, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 9, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 9, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 9, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 9, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 9, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 9, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 9, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 9, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 9, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 9, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 9, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 9, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 9, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 9, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 9, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 9, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 9, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 9, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 9, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 9, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 9, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 9, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 9, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 9, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 9, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 9, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 9, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 9, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 9, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 9, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 9, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 9, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 9, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 9, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 9, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 9, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 9, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 9, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 9, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 9, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 9, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 9, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 9, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 9, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 9, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 9, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 9, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 9, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 9, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 9, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 9, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 9, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 9, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 9, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 9, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 9, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 9, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 9, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 9, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 9, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 9, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 9, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 9, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 9, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 9, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 9, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 9, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 9, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 9, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 9, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 9, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 9, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 9, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 9, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 9, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 9, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 9, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 9, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 9, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 9, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 9, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 9, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 9, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 9, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 9, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 9, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 9, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 9, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 9, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 9, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 9, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 9, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 9, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 9, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 9, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 9, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 9, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 9, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 9, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 9, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 9, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 9, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 9, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 9, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 9, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 9, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 9, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 9, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 9, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 9, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 9, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 9, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 9, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 9, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 9, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 9, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 9, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 9, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 9, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 9, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 9, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 9, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 9, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 9, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 9, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 9, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 9, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 9, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 9, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 9, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 9, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 9, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 9, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 9, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 9, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 9, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 9, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 9, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 9, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 9, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 9, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 9, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 9, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 9, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 9, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 9, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 9, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 9, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 9, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 9, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 9, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 9, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 9, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 9, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 9, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 9, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 9, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 9, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 9, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 9, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 9, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 9, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 9, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 9, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 9, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 9, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 9, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 9, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 9, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 9, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 9, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 9, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 9, k + 19, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 9, k + 19, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 9, k + 19, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 9, k + 19, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 9, k + 19, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 9, k + 19, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 9, k + 19, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 9, k + 19, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 9, k + 19, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 9, k + 19, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 9, k + 19, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 9, k + 19, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 9, k + 19, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 9, k + 19, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 9, k + 19, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 9, k + 19, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 9, k + 19, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 9, k + 19, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 9, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 9, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 9, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 9, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 9, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 9, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 9, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 9, k + 20, PlaceDeepslateBrickStairs, 0, 2);
		world.setBlock(i + 8, j + 9, k + 20, PlaceCrackedDeepslateBricks, 1, 2);
		world.setBlock(i + 9, j + 9, k + 20, PlaceDeepslateBrickStairs, 1, 2);
		world.setBlock(i + 10, j + 9, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 9, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 9, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 9, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 9, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 9, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 9, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 9, k + 20, Blocks.air, 0, 2);
    	
    	return true;
    }

}
