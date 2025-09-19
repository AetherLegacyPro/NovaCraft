package com.NovaCraft.world.ancient_city;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.world.gen.feature.*;
import net.minecraft.block.*;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.world.*;
import java.util.*;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.config.Configs;
import com.NovaCraft.entity.EntityWardenVessel;
import com.NovaCraft.registry.OtherModBlocks;
import com.NovaCraft.registry.OtherModItems;
import com.NovaCraftBlocks.NovaCraftBlocks;

import cpw.mods.fml.common.Loader;
import net.minecraft.init.*;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.MathHelper;

public class AncientCityNegativeXShrineGen1 extends WorldGenerator
{
	public AncientCityNegativeXShrineGen1() {

	}
	
	private Block PlaceDeepslate;
	private Block PlaceDeepslateBricks;
	private Block PlaceDeepslateTiles;
	private Block PlaceCrackedDeepslateTiles;
	private Block PlaceCrackedDeepslateBricks;
	private Block PlaceChiseledDeepslate;
	private Block PlacePolishedDeepslate;
	private Block PlaceCobbledDeepslate;
	
	private Block PlaceDeepslateBrickSlab;
	private Block PlaceDeepslateTileStairs;
	private Block PlaceDeepslateBrickStairs;
	private Block PlaceCobbledDeepslateStairs;
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
				Block deepslate_brick_wall = GameRegistry.findBlock("etfuturum", "deepslate_brick_wall");
				if (deepslate_brick_wall != null && (existingBlock == null || existingBlock != deepslate_brick_wall)) {
					return deepslate_brick_wall;
				}
			} catch (Exception ex) {
				if (Configs.enableDebugMode) {
					System.out.println("Missing Deepslate Brick Wall from Et Futurum Requiem, using Grimstone Brick Wall instead...");
				}
				return NovaCraftBlocks.grimstone_brick_wall;
			}
		}

		return NovaCraftBlocks.grimstone_brick_wall;
	}

	private Block determineIfDeepslateBrickWallExists(World world, int x, int y, int z) {
		Block existingBlock = world.getBlock(x, y, z);
		if (Configs.enableDeepslateBricksInAncientCity && Loader.isModLoaded("etfuturum")) {
			try {
				Block deepslate_brick_wall = GameRegistry.findBlock("etfuturum", "deepslate_brick_wall");
				if (deepslate_brick_wall != null && (existingBlock == null || existingBlock != deepslate_brick_wall)) {
					return deepslate_brick_wall;
				}
			} catch (Exception ex) {
				if (Configs.enableDebugMode) {
					System.out.println("Missing Deepslate Brick Slab from Et Futurum Requiem, using Grimstone Brick Slab instead...");
				}
				return NovaCraftBlocks.grimstone_brick_wall;
			}
		}

		return NovaCraftBlocks.grimstone_brick_wall;
	}

	private Block determineIfCobbledDeepslateStairsExists(World world, int x, int y, int z) {
		Block existingBlock = world.getBlock(x, y, z);
		if (Configs.enableCobbledDeepslateInAncientCity && Loader.isModLoaded("etfuturum")) {
			try {
				Block cobbled_deepslate_stairs = GameRegistry.findBlock("etfuturum", "cobbled_deepslate_stairs");
				if (cobbled_deepslate_stairs != null && (existingBlock == null || existingBlock != cobbled_deepslate_stairs)) {
					return cobbled_deepslate_stairs;
				}
			} catch (Exception ex) {
				if (Configs.enableDebugMode) {
					System.out.println("Missing Cobbled Deepslate Stairs from Et Futurum Requiem, using Cobbled Grimstone Stairs instead...");
				}
				return NovaCraftBlocks.cobbled_grimstone_stairs;
			}
		}

		return NovaCraftBlocks.cobbled_grimstone_stairs;
	}
    
    public boolean generate(final World world, final Random random, final int i, final int j, final int k) {
    	PlaceDeepslate = determineIfDeepslateExists(world, i + 0, j + 0, k + 1);
    	PlaceCobbledDeepslate = determineIfCobbledDeepslateExists(world, i + 16, j + 0, k + 9);
    	
    	PlaceDeepslateBricks = determineIfDeepslateBricksExists(world, i + 1, j + 4, k + 7);
    	PlaceCrackedDeepslateBricks = determineIfCrackedDeepslateBricksExists(world, i + 1, j + 4, k + 8);
    	PlaceDeepslateTiles = determineIfDeepslateTilesExist(world, i + 0, j + 4, k + 1);
    	PlaceCrackedDeepslateTiles = determineIfCrackedDeepslateTilesExist(world, i + 4, j + 4, k + 2);
    	PlaceChiseledDeepslate = determineIfChiseledDeepslateExist(world, i + 2, j + 4, k + 19);
    	PlacePolishedDeepslate = determineIfPolishedDeepslateExists(world, i + 4, j + 1, k + 1);
    	
    	PlaceDeepslateTileStairs = determineIfDeepslateTileStairsExists(world, i + 1, j + 4, k + 14);
    	PlaceDeepslateBrickStairs = determineIfDeepslateBrickStairsExists(world, i + 16, j + 0, k + 18);
    	PlaceDeepslateBrickWall = determineIfDeepslateBrickWallExists(world, i + 10, j + 5, k + 6);
    	PlaceCobbledDeepslateStairs = determineIfCobbledDeepslateStairsExists(world, i + 5, j + 0, k + 3);
    	PlaceDeepslateBrickSlab = determineIfDeepslateSlabExists(world, i + 2, j + 4, k + 6);

		world.setBlock(i + 0, j + 0, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 0, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 0, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 0, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 0, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 0, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 0, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 0, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 0, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 0, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 0, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 0, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 0, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 0, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 0, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 0, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 0, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 0, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 0, k + 1, PlaceDeepslate, 0, 2);
		world.setBlock(i + 1, j + 0, k + 1, PlaceDeepslate, 0, 2);
		world.setBlock(i + 2, j + 0, k + 1, PlaceDeepslate, 0, 2);
		world.setBlock(i + 3, j + 0, k + 1, PlaceDeepslate, 0, 2);
		world.setBlock(i + 4, j + 0, k + 1, PlaceDeepslate, 0, 2);
		world.setBlock(i + 5, j + 0, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 0, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 0, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 0, k + 1, PlaceDeepslate, 0, 2);
		world.setBlock(i + 9, j + 0, k + 1, PlaceDeepslate, 0, 2);
		world.setBlock(i + 10, j + 0, k + 1, PlaceDeepslate, 0, 2);
		world.setBlock(i + 11, j + 0, k + 1, PlaceDeepslate, 0, 2);
		world.setBlock(i + 12, j + 0, k + 1, PlaceDeepslate, 0, 2);
		world.setBlock(i + 13, j + 0, k + 1, PlaceDeepslate, 0, 2);
		world.setBlock(i + 14, j + 0, k + 1, PlaceDeepslate, 0, 2);
		world.setBlock(i + 15, j + 0, k + 1, PlaceDeepslate, 0, 2);
		world.setBlock(i + 16, j + 0, k + 1, PlaceDeepslate, 0, 2);
		world.setBlock(i + 17, j + 0, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 0, k + 2, PlaceDeepslate, 0, 2);
		world.setBlock(i + 1, j + 0, k + 2, PlaceDeepslate, 0, 2);
		world.setBlock(i + 2, j + 0, k + 2, PlaceDeepslate, 0, 2);
		world.setBlock(i + 3, j + 0, k + 2, PlaceDeepslate, 0, 2);
		world.setBlock(i + 4, j + 0, k + 2, PlaceDeepslate, 0, 2);
		world.setBlock(i + 5, j + 0, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 0, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 0, k + 2, PlaceDeepslate, 0, 2);
		world.setBlock(i + 8, j + 0, k + 2, PlaceDeepslate, 0, 2);
		world.setBlock(i + 9, j + 0, k + 2, PlaceDeepslate, 0, 2);
		world.setBlock(i + 10, j + 0, k + 2, PlaceDeepslate, 0, 2);
		world.setBlock(i + 11, j + 0, k + 2, PlaceDeepslate, 0, 2);
		world.setBlock(i + 12, j + 0, k + 2, PlaceDeepslate, 0, 2);
		world.setBlock(i + 13, j + 0, k + 2, PlaceDeepslate, 0, 2);
		world.setBlock(i + 14, j + 0, k + 2, PlaceDeepslate, 0, 2);
		world.setBlock(i + 15, j + 0, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 0, k + 2, PlaceDeepslate, 0, 2);
		world.setBlock(i + 17, j + 0, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 0, k + 3, PlaceDeepslate, 0, 2);
		world.setBlock(i + 1, j + 0, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 0, k + 3, PlaceDeepslate, 0, 2);
		world.setBlock(i + 3, j + 0, k + 3, PlaceDeepslate, 0, 2);
		world.setBlock(i + 4, j + 0, k + 3, PlaceDeepslate, 0, 2);
		world.setBlock(i + 5, j + 0, k + 3, PlaceCobbledDeepslateStairs, 2, 2);
		world.setBlock(i + 6, j + 0, k + 3, PlaceCobbledDeepslateStairs, 2, 2);
		world.setBlock(i + 7, j + 0, k + 3, PlaceDeepslate, 0, 2);
		world.setBlock(i + 8, j + 0, k + 3, PlaceDeepslate, 0, 2);
		world.setBlock(i + 9, j + 0, k + 3, PlaceDeepslate, 0, 2);
		world.setBlock(i + 10, j + 0, k + 3, PlaceDeepslate, 0, 2);
		world.setBlock(i + 11, j + 0, k + 3, PlaceDeepslate, 0, 2);
		world.setBlock(i + 12, j + 0, k + 3, PlaceDeepslate, 0, 2);
		world.setBlock(i + 13, j + 0, k + 3, PlaceDeepslate, 0, 2);
		world.setBlock(i + 14, j + 0, k + 3, PlaceDeepslate, 0, 2);
		world.setBlock(i + 15, j + 0, k + 3, PlaceDeepslate, 0, 2);
		world.setBlock(i + 16, j + 0, k + 3, PlaceDeepslate, 0, 2);
		world.setBlock(i + 17, j + 0, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 0, k + 4, PlaceDeepslate, 0, 2);
		world.setBlock(i + 1, j + 0, k + 4, PlaceDeepslate, 0, 2);
		world.setBlock(i + 2, j + 0, k + 4, PlaceDeepslate, 0, 2);
		world.setBlock(i + 3, j + 0, k + 4, PlaceDeepslate, 0, 2);
		world.setBlock(i + 4, j + 0, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 0, k + 4, PlaceDeepslate, 0, 2);
		world.setBlock(i + 6, j + 0, k + 4, PlaceDeepslate, 0, 2);
		world.setBlock(i + 7, j + 0, k + 4, PlaceDeepslate, 0, 2);
		world.setBlock(i + 8, j + 0, k + 4, PlaceDeepslate, 0, 2);
		world.setBlock(i + 9, j + 0, k + 4, PlaceDeepslate, 0, 2);
		world.setBlock(i + 10, j + 0, k + 4, PlaceDeepslate, 0, 2);
		world.setBlock(i + 11, j + 0, k + 4, PlaceDeepslate, 0, 2);
		world.setBlock(i + 12, j + 0, k + 4, PlaceDeepslate, 0, 2);
		world.setBlock(i + 13, j + 0, k + 4, PlaceDeepslate, 0, 2);
		world.setBlock(i + 14, j + 0, k + 4, PlaceDeepslate, 0, 2);
		world.setBlock(i + 15, j + 0, k + 4, PlaceDeepslate, 0, 2);
		world.setBlock(i + 16, j + 0, k + 4, PlaceDeepslate, 0, 2);
		world.setBlock(i + 17, j + 0, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 0, k + 5, PlaceDeepslate, 0, 2);
		world.setBlock(i + 1, j + 0, k + 5, PlaceDeepslate, 0, 2);
		world.setBlock(i + 2, j + 0, k + 5, PlaceDeepslate, 0, 2);
		world.setBlock(i + 3, j + 0, k + 5, PlaceDeepslate, 0, 2);
		world.setBlock(i + 4, j + 0, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 0, k + 5, PlaceDeepslate, 0, 2);
		world.setBlock(i + 6, j + 0, k + 5, PlaceDeepslate, 0, 2);
		world.setBlock(i + 7, j + 0, k + 5, PlaceDeepslate, 0, 2);
		world.setBlock(i + 8, j + 0, k + 5, PlaceDeepslate, 0, 2);
		world.setBlock(i + 9, j + 0, k + 5, PlaceDeepslate, 0, 2);
		world.setBlock(i + 10, j + 0, k + 5, PlaceDeepslate, 0, 2);
		world.setBlock(i + 11, j + 0, k + 5, PlaceDeepslate, 0, 2);
		world.setBlock(i + 12, j + 0, k + 5, PlaceDeepslate, 0, 2);
		world.setBlock(i + 13, j + 0, k + 5, PlaceDeepslate, 0, 2);
		world.setBlock(i + 14, j + 0, k + 5, PlaceDeepslate, 0, 2);
		world.setBlock(i + 15, j + 0, k + 5, PlaceDeepslate, 0, 2);
		world.setBlock(i + 16, j + 0, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 0, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 0, k + 6, PlaceDeepslate, 0, 2);
		world.setBlock(i + 1, j + 0, k + 6, PlaceDeepslate, 0, 2);
		world.setBlock(i + 2, j + 0, k + 6, PlaceDeepslate, 0, 2);
		world.setBlock(i + 3, j + 0, k + 6, PlaceDeepslate, 0, 2);
		world.setBlock(i + 4, j + 0, k + 6, PlaceDeepslate, 0, 2);
		world.setBlock(i + 5, j + 0, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 0, k + 6, PlaceDeepslate, 0, 2);
		world.setBlock(i + 7, j + 0, k + 6, PlaceDeepslate, 0, 2);
		world.setBlock(i + 8, j + 0, k + 6, PlaceDeepslate, 0, 2);
		world.setBlock(i + 9, j + 0, k + 6, PlaceDeepslate, 0, 2);
		world.setBlock(i + 10, j + 0, k + 6, PlaceDeepslate, 0, 2);
		world.setBlock(i + 11, j + 0, k + 6, PlaceDeepslate, 0, 2);
		world.setBlock(i + 12, j + 0, k + 6, PlaceDeepslate, 0, 2);
		world.setBlock(i + 13, j + 0, k + 6, PlaceDeepslate, 0, 2);
		world.setBlock(i + 14, j + 0, k + 6, PlaceDeepslate, 0, 2);
		world.setBlock(i + 15, j + 0, k + 6, PlaceDeepslate, 0, 2);
		world.setBlock(i + 16, j + 0, k + 6, PlaceDeepslate, 0, 2);
		world.setBlock(i + 17, j + 0, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 0, k + 7, PlaceDeepslate, 0, 2);
		world.setBlock(i + 1, j + 0, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 0, k + 7, PlaceDeepslate, 0, 2);
		world.setBlock(i + 3, j + 0, k + 7, PlaceDeepslate, 0, 2);
		world.setBlock(i + 4, j + 0, k + 7, PlaceDeepslate, 0, 2);
		world.setBlock(i + 5, j + 0, k + 7, PlaceDeepslate, 0, 2);
		world.setBlock(i + 6, j + 0, k + 7, PlaceDeepslate, 0, 2);
		world.setBlock(i + 7, j + 0, k + 7, PlaceDeepslate, 0, 2);
		world.setBlock(i + 8, j + 0, k + 7, PlaceDeepslate, 0, 2);
		world.setBlock(i + 9, j + 0, k + 7, PlaceDeepslate, 0, 2);
		world.setBlock(i + 10, j + 0, k + 7, PlaceDeepslate, 0, 2);
		world.setBlock(i + 11, j + 0, k + 7, PlaceDeepslate, 0, 2);
		world.setBlock(i + 12, j + 0, k + 7, PlaceDeepslate, 0, 2);
		world.setBlock(i + 13, j + 0, k + 7, PlaceDeepslate, 0, 2);
		world.setBlock(i + 14, j + 0, k + 7, PlaceDeepslate, 0, 2);
		world.setBlock(i + 15, j + 0, k + 7, PlaceDeepslate, 0, 2);
		world.setBlock(i + 16, j + 0, k + 7, PlaceDeepslate, 0, 2);
		world.setBlock(i + 17, j + 0, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 0, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 0, k + 8, PlaceDeepslate, 0, 2);
		world.setBlock(i + 2, j + 0, k + 8, PlaceDeepslate, 0, 2);
		world.setBlock(i + 3, j + 0, k + 8, PlaceDeepslate, 0, 2);
		world.setBlock(i + 4, j + 0, k + 8, PlaceDeepslate, 0, 2);
		world.setBlock(i + 5, j + 0, k + 8, PlaceDeepslate, 0, 2);
		world.setBlock(i + 6, j + 0, k + 8, PlaceDeepslate, 0, 2);
		world.setBlock(i + 7, j + 0, k + 8, PlaceDeepslate, 0, 2);
		world.setBlock(i + 8, j + 0, k + 8, PlaceDeepslate, 0, 2);
		world.setBlock(i + 9, j + 0, k + 8, PlaceDeepslate, 0, 2);
		world.setBlock(i + 10, j + 0, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 0, k + 8, PlaceDeepslate, 0, 2);
		world.setBlock(i + 12, j + 0, k + 8, PlaceDeepslate, 0, 2);
		world.setBlock(i + 13, j + 0, k + 8, PlaceDeepslate, 0, 2);
		world.setBlock(i + 14, j + 0, k + 8, PlaceDeepslate, 0, 2);
		world.setBlock(i + 15, j + 0, k + 8, PlaceDeepslate, 0, 2);
		world.setBlock(i + 16, j + 0, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 0, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 0, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 0, k + 9, PlaceDeepslate, 0, 2);
		world.setBlock(i + 2, j + 0, k + 9, PlaceDeepslate, 0, 2);
		world.setBlock(i + 3, j + 0, k + 9, PlaceDeepslate, 0, 2);
		world.setBlock(i + 4, j + 0, k + 9, PlaceDeepslate, 0, 2);
		world.setBlock(i + 5, j + 0, k + 9, PlaceDeepslate, 0, 2);
		world.setBlock(i + 6, j + 0, k + 9, PlaceDeepslate, 0, 2);
		world.setBlock(i + 7, j + 0, k + 9, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 8, j + 0, k + 9, PlaceDeepslate, 0, 2);
		world.setBlock(i + 9, j + 0, k + 9, PlaceDeepslate, 0, 2);
		world.setBlock(i + 10, j + 0, k + 9, PlaceDeepslate, 0, 2);
		world.setBlock(i + 11, j + 0, k + 9, PlaceDeepslate, 0, 2);
		world.setBlock(i + 12, j + 0, k + 9, PlaceDeepslate, 0, 2);
		world.setBlock(i + 13, j + 0, k + 9, PlaceDeepslate, 0, 2);
		world.setBlock(i + 14, j + 0, k + 9, PlaceDeepslate, 0, 2);
		world.setBlock(i + 15, j + 0, k + 9, PlaceDeepslate, 0, 2);
		world.setBlock(i + 16, j + 0, k + 9, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 17, j + 0, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 0, k + 10, PlaceDeepslate, 0, 2);
		world.setBlock(i + 1, j + 0, k + 10, PlaceDeepslate, 0, 2);
		world.setBlock(i + 2, j + 0, k + 10, PlaceDeepslate, 0, 2);
		world.setBlock(i + 3, j + 0, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 0, k + 10, PlaceDeepslate, 0, 2);
		world.setBlock(i + 5, j + 0, k + 10, PlaceDeepslate, 0, 2);
		world.setBlock(i + 6, j + 0, k + 10, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 7, j + 0, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 0, k + 10, PlaceDeepslate, 0, 2);
		world.setBlock(i + 9, j + 0, k + 10, PlaceDeepslate, 0, 2);
		world.setBlock(i + 10, j + 0, k + 10, PlaceDeepslate, 0, 2);
		world.setBlock(i + 11, j + 0, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 0, k + 10, PlaceDeepslate, 0, 2);
		world.setBlock(i + 13, j + 0, k + 10, PlaceDeepslate, 0, 2);
		world.setBlock(i + 14, j + 0, k + 10, PlaceDeepslate, 0, 2);
		world.setBlock(i + 15, j + 0, k + 10, PlaceDeepslate, 0, 2);
		world.setBlock(i + 16, j + 0, k + 10, PlaceDeepslate, 0, 2);
		world.setBlock(i + 17, j + 0, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 0, k + 11, PlaceDeepslate, 0, 2);
		world.setBlock(i + 1, j + 0, k + 11, PlaceDeepslate, 0, 2);
		world.setBlock(i + 2, j + 0, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 0, k + 11, PlaceDeepslate, 0, 2);
		world.setBlock(i + 4, j + 0, k + 11, PlaceDeepslate, 0, 2);
		world.setBlock(i + 5, j + 0, k + 11, PlaceDeepslate, 0, 2);
		world.setBlock(i + 6, j + 0, k + 11, PlaceDeepslate, 0, 2);
		world.setBlock(i + 7, j + 0, k + 11, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 8, j + 0, k + 11, PlaceDeepslate, 0, 2);
		world.setBlock(i + 9, j + 0, k + 11, PlaceDeepslate, 0, 2);
		world.setBlock(i + 10, j + 0, k + 11, PlaceDeepslate, 0, 2);
		world.setBlock(i + 11, j + 0, k + 11, PlaceDeepslate, 0, 2);
		world.setBlock(i + 12, j + 0, k + 11, PlaceDeepslate, 0, 2);
		world.setBlock(i + 13, j + 0, k + 11, PlaceDeepslate, 0, 2);
		world.setBlock(i + 14, j + 0, k + 11, PlaceDeepslate, 0, 2);
		world.setBlock(i + 15, j + 0, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 0, k + 11, PlaceDeepslate, 0, 2);
		world.setBlock(i + 17, j + 0, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 0, k + 12, PlaceDeepslate, 0, 2);
		world.setBlock(i + 1, j + 0, k + 12, PlaceDeepslate, 0, 2);
		world.setBlock(i + 2, j + 0, k + 12, PlaceDeepslate, 0, 2);
		world.setBlock(i + 3, j + 0, k + 12, PlaceDeepslate, 0, 2);
		world.setBlock(i + 4, j + 0, k + 12, PlaceDeepslate, 0, 2);
		world.setBlock(i + 5, j + 0, k + 12, PlaceDeepslate, 0, 2);
		world.setBlock(i + 6, j + 0, k + 12, PlaceDeepslate, 0, 2);
		world.setBlock(i + 7, j + 0, k + 12, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 8, j + 0, k + 12, PlaceDeepslate, 0, 2);
		world.setBlock(i + 9, j + 0, k + 12, PlaceDeepslate, 0, 2);
		world.setBlock(i + 10, j + 0, k + 12, PlaceDeepslate, 0, 2);
		world.setBlock(i + 11, j + 0, k + 12, PlaceDeepslate, 0, 2);
		world.setBlock(i + 12, j + 0, k + 12, PlaceDeepslate, 0, 2);
		world.setBlock(i + 13, j + 0, k + 12, PlaceDeepslate, 0, 2);
		world.setBlock(i + 14, j + 0, k + 12, PlaceDeepslate, 0, 2);
		world.setBlock(i + 15, j + 0, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 0, k + 12, PlaceDeepslate, 0, 2);
		world.setBlock(i + 17, j + 0, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 0, k + 13, PlaceDeepslate, 0, 2);
		world.setBlock(i + 1, j + 0, k + 13, PlaceDeepslate, 0, 2);
		world.setBlock(i + 2, j + 0, k + 13, PlaceDeepslate, 0, 2);
		world.setBlock(i + 3, j + 0, k + 13, PlaceDeepslate, 0, 2);
		world.setBlock(i + 4, j + 0, k + 13, PlaceDeepslate, 0, 2);
		world.setBlock(i + 5, j + 0, k + 13, PlaceDeepslate, 0, 2);
		world.setBlock(i + 6, j + 0, k + 13, PlaceDeepslate, 0, 2);
		world.setBlock(i + 7, j + 0, k + 13, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 8, j + 0, k + 13, PlaceDeepslate, 0, 2);
		world.setBlock(i + 9, j + 0, k + 13, PlaceDeepslate, 0, 2);
		world.setBlock(i + 10, j + 0, k + 13, PlaceDeepslate, 0, 2);
		world.setBlock(i + 11, j + 0, k + 13, PlaceDeepslate, 0, 2);
		world.setBlock(i + 12, j + 0, k + 13, PlaceDeepslate, 0, 2);
		world.setBlock(i + 13, j + 0, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 0, k + 13, PlaceDeepslate, 0, 2);
		world.setBlock(i + 15, j + 0, k + 13, PlaceDeepslate, 0, 2);
		world.setBlock(i + 16, j + 0, k + 13, PlaceDeepslate, 0, 2);
		world.setBlock(i + 17, j + 0, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 0, k + 14, PlaceDeepslate, 0, 2);
		world.setBlock(i + 1, j + 0, k + 14, PlaceDeepslate, 0, 2);
		world.setBlock(i + 2, j + 0, k + 14, PlaceDeepslate, 0, 2);
		world.setBlock(i + 3, j + 0, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 0, k + 14, PlaceDeepslate, 0, 2);
		world.setBlock(i + 5, j + 0, k + 14, PlaceDeepslate, 0, 2);
		world.setBlock(i + 6, j + 0, k + 14, PlaceDeepslate, 0, 2);
		world.setBlock(i + 7, j + 0, k + 14, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 8, j + 0, k + 14, PlaceDeepslate, 0, 2);
		world.setBlock(i + 9, j + 0, k + 14, PlaceDeepslate, 0, 2);
		world.setBlock(i + 10, j + 0, k + 14, PlaceDeepslate, 0, 2);
		world.setBlock(i + 11, j + 0, k + 14, PlaceDeepslate, 0, 2);
		world.setBlock(i + 12, j + 0, k + 14, PlaceDeepslate, 0, 2);
		world.setBlock(i + 13, j + 0, k + 14, PlaceDeepslate, 0, 2);
		world.setBlock(i + 14, j + 0, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 0, k + 14, PlaceDeepslate, 0, 2);
		world.setBlock(i + 16, j + 0, k + 14, PlaceDeepslate, 0, 2);
		world.setBlock(i + 17, j + 0, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 0, k + 15, PlaceDeepslate, 0, 2);
		world.setBlock(i + 1, j + 0, k + 15, PlaceDeepslate, 0, 2);
		world.setBlock(i + 2, j + 0, k + 15, PlaceDeepslate, 0, 2);
		world.setBlock(i + 3, j + 0, k + 15, PlaceDeepslate, 0, 2);
		world.setBlock(i + 4, j + 0, k + 15, PlaceDeepslate, 0, 2);
		world.setBlock(i + 5, j + 0, k + 15, PlaceDeepslate, 0, 2);
		world.setBlock(i + 6, j + 0, k + 15, PlaceDeepslate, 0, 2);
		world.setBlock(i + 7, j + 0, k + 15, PlaceDeepslate, 0, 2);
		world.setBlock(i + 8, j + 0, k + 15, PlaceDeepslate, 0, 2);
		world.setBlock(i + 9, j + 0, k + 15, PlaceDeepslate, 0, 2);
		world.setBlock(i + 10, j + 0, k + 15, PlaceDeepslate, 0, 2);
		world.setBlock(i + 11, j + 0, k + 15, PlaceDeepslate, 0, 2);
		world.setBlock(i + 12, j + 0, k + 15, PlaceDeepslate, 0, 2);
		world.setBlock(i + 13, j + 0, k + 15, PlaceDeepslate, 0, 2);
		world.setBlock(i + 14, j + 0, k + 15, PlaceDeepslate, 0, 2);
		world.setBlock(i + 15, j + 0, k + 15, PlaceDeepslate, 0, 2);
		world.setBlock(i + 16, j + 0, k + 15, PlaceDeepslate, 0, 2);
		world.setBlock(i + 17, j + 0, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 0, k + 16, PlaceDeepslate, 0, 2);
		world.setBlock(i + 1, j + 0, k + 16, PlaceDeepslate, 0, 2);
		world.setBlock(i + 2, j + 0, k + 16, PlaceDeepslate, 0, 2);
		world.setBlock(i + 3, j + 0, k + 16, PlaceDeepslate, 0, 2);
		world.setBlock(i + 4, j + 0, k + 16, PlaceDeepslate, 0, 2);
		world.setBlock(i + 5, j + 0, k + 16, PlaceDeepslate, 0, 2);
		world.setBlock(i + 6, j + 0, k + 16, PlaceDeepslate, 0, 2);
		world.setBlock(i + 7, j + 0, k + 16, PlaceDeepslate, 0, 2);
		world.setBlock(i + 8, j + 0, k + 16, PlaceDeepslate, 0, 2);
		world.setBlock(i + 9, j + 0, k + 16, PlaceDeepslate, 0, 2);
		world.setBlock(i + 10, j + 0, k + 16, PlaceDeepslate, 0, 2);
		world.setBlock(i + 11, j + 0, k + 16, PlaceDeepslate, 0, 2);
		world.setBlock(i + 12, j + 0, k + 16, PlaceDeepslate, 0, 2);
		world.setBlock(i + 13, j + 0, k + 16, PlaceDeepslate, 0, 2);
		world.setBlock(i + 14, j + 0, k + 16, PlaceDeepslate, 0, 2);
		world.setBlock(i + 15, j + 0, k + 16, PlaceDeepslate, 0, 2);
		world.setBlock(i + 16, j + 0, k + 16, PlaceDeepslate, 0, 2);
		world.setBlock(i + 17, j + 0, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 0, k + 17, PlaceDeepslate, 0, 2);
		world.setBlock(i + 1, j + 0, k + 17, PlaceDeepslate, 0, 2);
		world.setBlock(i + 2, j + 0, k + 17, PlaceDeepslate, 0, 2);
		world.setBlock(i + 3, j + 0, k + 17, PlaceDeepslate, 0, 2);
		world.setBlock(i + 4, j + 0, k + 17, PlaceDeepslate, 0, 2);
		world.setBlock(i + 5, j + 0, k + 17, PlaceDeepslate, 0, 2);
		world.setBlock(i + 6, j + 0, k + 17, PlaceDeepslate, 0, 2);
		world.setBlock(i + 7, j + 0, k + 17, PlaceDeepslate, 0, 2);
		world.setBlock(i + 8, j + 0, k + 17, PlaceDeepslate, 0, 2);
		world.setBlock(i + 9, j + 0, k + 17, PlaceDeepslate, 0, 2);
		world.setBlock(i + 10, j + 0, k + 17, PlaceDeepslate, 0, 2);
		world.setBlock(i + 11, j + 0, k + 17, PlaceDeepslate, 0, 2);
		world.setBlock(i + 12, j + 0, k + 17, PlaceDeepslate, 0, 2);
		world.setBlock(i + 13, j + 0, k + 17, PlaceDeepslate, 0, 2);
		world.setBlock(i + 14, j + 0, k + 17, PlaceDeepslate, 0, 2);
		world.setBlock(i + 15, j + 0, k + 17, PlaceDeepslate, 0, 2);
		world.setBlock(i + 16, j + 0, k + 17, PlaceDeepslate, 0, 2);
		world.setBlock(i + 17, j + 0, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 0, k + 18, PlaceDeepslate, 0, 2);
		world.setBlock(i + 1, j + 0, k + 18, PlaceDeepslate, 0, 2);
		world.setBlock(i + 2, j + 0, k + 18, PlaceDeepslate, 0, 2);
		world.setBlock(i + 3, j + 0, k + 18, PlaceDeepslate, 0, 2);
		world.setBlock(i + 4, j + 0, k + 18, PlaceDeepslate, 0, 2);
		world.setBlock(i + 5, j + 0, k + 18, PlaceDeepslate, 0, 2);
		world.setBlock(i + 6, j + 0, k + 18, PlaceDeepslate, 0, 2);
		world.setBlock(i + 7, j + 0, k + 18, PlaceDeepslate, 0, 2);
		world.setBlock(i + 8, j + 0, k + 18, PlaceDeepslate, 0, 2);
		world.setBlock(i + 9, j + 0, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 0, k + 18, PlaceDeepslate, 0, 2);
		world.setBlock(i + 11, j + 0, k + 18, PlaceDeepslate, 0, 2);
		world.setBlock(i + 12, j + 0, k + 18, PlaceDeepslate, 0, 2);
		world.setBlock(i + 13, j + 0, k + 18, PlaceDeepslate, 0, 2);
		world.setBlock(i + 14, j + 0, k + 18, PlaceDeepslate, 0, 2);
		world.setBlock(i + 15, j + 0, k + 18, PlaceDeepslate, 0, 2);
		world.setBlock(i + 16, j + 0, k + 18, PlaceDeepslateBrickStairs, 1, 2);
		world.setBlock(i + 17, j + 0, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 0, k + 19, PlaceDeepslate, 0, 2);
		world.setBlock(i + 1, j + 0, k + 19, PlaceDeepslate, 0, 2);
		world.setBlock(i + 2, j + 0, k + 19, PlaceDeepslate, 0, 2);
		world.setBlock(i + 3, j + 0, k + 19, PlaceDeepslate, 0, 2);
		world.setBlock(i + 4, j + 0, k + 19, PlaceDeepslate, 0, 2);
		world.setBlock(i + 5, j + 0, k + 19, PlaceDeepslate, 0, 2);
		world.setBlock(i + 6, j + 0, k + 19, PlaceDeepslate, 0, 2);
		world.setBlock(i + 7, j + 0, k + 19, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 0, k + 19, PlaceDeepslate, 0, 2);
		world.setBlock(i + 9, j + 0, k + 19, PlaceDeepslate, 0, 2);
		world.setBlock(i + 10, j + 0, k + 19, PlaceDeepslate, 0, 2);
		world.setBlock(i + 11, j + 0, k + 19, PlaceDeepslate, 0, 2);
		world.setBlock(i + 12, j + 0, k + 19, PlaceDeepslate, 0, 2);
		world.setBlock(i + 13, j + 0, k + 19, PlaceDeepslate, 0, 2);
		world.setBlock(i + 14, j + 0, k + 19, PlaceDeepslate, 0, 2);
		world.setBlock(i + 15, j + 0, k + 19, PlaceDeepslate, 0, 2);
		world.setBlock(i + 16, j + 0, k + 19, PlaceDeepslate, 0, 2);
		world.setBlock(i + 17, j + 0, k + 19, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 0, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 0, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 0, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 0, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 0, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 0, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 0, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 0, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 0, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 0, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 0, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 0, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 0, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 0, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 0, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 0, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 0, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 0, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 1, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 1, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 1, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 1, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 1, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 1, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 1, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 1, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 1, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 1, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 1, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 1, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 1, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 1, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 1, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 1, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 1, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 1, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 1, k + 1, PlaceDeepslate, 0, 2);
		world.setBlock(i + 1, j + 1, k + 1, PlaceDeepslate, 0, 2);
		world.setBlock(i + 2, j + 1, k + 1, PlaceDeepslate, 0, 2);
		world.setBlock(i + 3, j + 1, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 1, k + 1, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 5, j + 1, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 1, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 1, k + 1, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 8, j + 1, k + 1, PlaceDeepslate, 0, 2);
		world.setBlock(i + 9, j + 1, k + 1, PlaceDeepslate, 0, 2);
		world.setBlock(i + 10, j + 1, k + 1, PlaceDeepslate, 0, 2);
		world.setBlock(i + 11, j + 1, k + 1, PlaceDeepslate, 0, 2);
		world.setBlock(i + 12, j + 1, k + 1, PlaceDeepslate, 0, 2);
		world.setBlock(i + 13, j + 1, k + 1, PlaceDeepslate, 0, 2);
		world.setBlock(i + 14, j + 1, k + 1, PlaceDeepslate, 0, 2);
		world.setBlock(i + 15, j + 1, k + 1, PlaceDeepslate, 0, 2);
		world.setBlock(i + 16, j + 1, k + 1, PlaceDeepslate, 0, 2);
		world.setBlock(i + 17, j + 1, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 1, k + 2, PlaceDeepslate, 0, 2);
		world.setBlock(i + 1, j + 1, k + 2, PlaceDeepslate, 0, 2);
		world.setBlock(i + 2, j + 1, k + 2, PlaceDeepslate, 0, 2);
		world.setBlock(i + 3, j + 1, k + 2, PlaceDeepslate, 0, 2);
		world.setBlock(i + 4, j + 1, k + 2, PlaceDeepslate, 0, 2);
		world.setBlock(i + 5, j + 1, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 1, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 1, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 1, k + 2, PlaceDeepslate, 0, 2);
		world.setBlock(i + 9, j + 1, k + 2, PlaceDeepslate, 0, 2);
		world.setBlock(i + 10, j + 1, k + 2, PlaceDeepslate, 0, 2);
		world.setBlock(i + 11, j + 1, k + 2, PlaceDeepslate, 0, 2);
		world.setBlock(i + 12, j + 1, k + 2, PlaceDeepslate, 0, 2);
		world.setBlock(i + 13, j + 1, k + 2, PlaceDeepslate, 0, 2);
		world.setBlock(i + 14, j + 1, k + 2, PlaceDeepslate, 0, 2);
		world.setBlock(i + 15, j + 1, k + 2, PlaceDeepslate, 0, 2);
		world.setBlock(i + 16, j + 1, k + 2, PlaceDeepslate, 0, 2);
		world.setBlock(i + 17, j + 1, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 1, k + 3, PlaceDeepslate, 0, 2);
		world.setBlock(i + 1, j + 1, k + 3, PlaceDeepslate, 0, 2);
		world.setBlock(i + 2, j + 1, k + 3, PlaceDeepslate, 0, 2);
		world.setBlock(i + 3, j + 1, k + 3, PlaceDeepslate, 0, 2);
		world.setBlock(i + 4, j + 1, k + 3, PlaceDeepslate, 0, 2);
		world.setBlock(i + 5, j + 1, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 1, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 1, k + 3, PlaceDeepslate, 0, 2);
		world.setBlock(i + 8, j + 1, k + 3, PlaceDeepslate, 0, 2);
		world.setBlock(i + 9, j + 1, k + 3, PlaceDeepslate, 0, 2);
		world.setBlock(i + 10, j + 1, k + 3, PlaceDeepslate, 0, 2);
		world.setBlock(i + 11, j + 1, k + 3, PlaceDeepslate, 0, 2);
		world.setBlock(i + 12, j + 1, k + 3, PlaceDeepslate, 0, 2);
		world.setBlock(i + 13, j + 1, k + 3, PlaceDeepslate, 0, 2);
		world.setBlock(i + 14, j + 1, k + 3, PlaceDeepslate, 0, 2);
		world.setBlock(i + 15, j + 1, k + 3, PlaceDeepslate, 0, 2);
		world.setBlock(i + 16, j + 1, k + 3, PlaceDeepslate, 0, 2);
		world.setBlock(i + 17, j + 1, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 1, k + 4, PlaceDeepslate, 0, 2);
		world.setBlock(i + 1, j + 1, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 1, k + 4, PlaceDeepslate, 0, 2);
		world.setBlock(i + 3, j + 1, k + 4, PlaceDeepslate, 0, 2);
		world.setBlock(i + 4, j + 1, k + 4, PlaceDeepslate, 0, 2);
		world.setBlock(i + 5, j + 1, k + 4, PlaceCobbledDeepslateStairs, 2, 2);
		world.setBlock(i + 6, j + 1, k + 4, PlaceCobbledDeepslateStairs, 2, 2);
		world.setBlock(i + 7, j + 1, k + 4, PlaceDeepslate, 0, 2);
		world.setBlock(i + 8, j + 1, k + 4, PlaceDeepslate, 0, 2);
		world.setBlock(i + 9, j + 1, k + 4, PlaceDeepslate, 0, 2);
		world.setBlock(i + 10, j + 1, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 1, k + 4, PlaceDeepslate, 0, 2);
		world.setBlock(i + 12, j + 1, k + 4, PlaceDeepslate, 0, 2);
		world.setBlock(i + 13, j + 1, k + 4, PlaceDeepslate, 0, 2);
		world.setBlock(i + 14, j + 1, k + 4, PlaceDeepslate, 0, 2);
		world.setBlock(i + 15, j + 1, k + 4, PlaceDeepslate, 0, 2);
		world.setBlock(i + 16, j + 1, k + 4, PlaceDeepslate, 0, 2);
		world.setBlock(i + 17, j + 1, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 1, k + 5, PlaceDeepslate, 0, 2);
		world.setBlock(i + 1, j + 1, k + 5, PlaceDeepslate, 0, 2);
		world.setBlock(i + 2, j + 1, k + 5, PlaceDeepslate, 0, 2);
		world.setBlock(i + 3, j + 1, k + 5, PlaceDeepslate, 0, 2);
		world.setBlock(i + 4, j + 1, k + 5, PlaceDeepslate, 0, 2);
		world.setBlock(i + 5, j + 1, k + 5, PlaceDeepslate, 0, 2);
		world.setBlock(i + 6, j + 1, k + 5, PlaceDeepslate, 0, 2);
		world.setBlock(i + 7, j + 1, k + 5, PlaceDeepslate, 0, 2);
		world.setBlock(i + 8, j + 1, k + 5, PlaceDeepslate, 0, 2);
		world.setBlock(i + 9, j + 1, k + 5, PlaceDeepslate, 0, 2);
		world.setBlock(i + 10, j + 1, k + 5, PlaceDeepslate, 0, 2);
		world.setBlock(i + 11, j + 1, k + 5, PlaceDeepslate, 0, 2);
		world.setBlock(i + 12, j + 1, k + 5, PlaceDeepslate, 0, 2);
		world.setBlock(i + 13, j + 1, k + 5, PlaceDeepslate, 0, 2);
		world.setBlock(i + 14, j + 1, k + 5, PlaceDeepslate, 0, 2);
		world.setBlock(i + 15, j + 1, k + 5, PlaceDeepslate, 0, 2);
		world.setBlock(i + 16, j + 1, k + 5, PlaceDeepslate, 0, 2);
		world.setBlock(i + 17, j + 1, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 1, k + 6, PlaceDeepslate, 0, 2);
		world.setBlock(i + 1, j + 1, k + 6, PlaceDeepslate, 0, 2);
		world.setBlock(i + 2, j + 1, k + 6, PlaceDeepslate, 0, 2);
		world.setBlock(i + 3, j + 1, k + 6, PlaceDeepslate, 0, 2);
		world.setBlock(i + 4, j + 1, k + 6, PlaceDeepslate, 0, 2);
		world.setBlock(i + 5, j + 1, k + 6, PlaceDeepslate, 0, 2);
		world.setBlock(i + 6, j + 1, k + 6, PlaceDeepslate, 0, 2);
		world.setBlock(i + 7, j + 1, k + 6, PlaceDeepslate, 0, 2);
		world.setBlock(i + 8, j + 1, k + 6, PlaceDeepslate, 0, 2);
		world.setBlock(i + 9, j + 1, k + 6, PlaceDeepslate, 0, 2);
		world.setBlock(i + 10, j + 1, k + 6, PlaceDeepslate, 0, 2);
		world.setBlock(i + 11, j + 1, k + 6, PlaceDeepslate, 0, 2);
		world.setBlock(i + 12, j + 1, k + 6, PlaceDeepslate, 0, 2);
		world.setBlock(i + 13, j + 1, k + 6, PlaceDeepslate, 0, 2);
		world.setBlock(i + 14, j + 1, k + 6, PlaceDeepslate, 0, 2);
		world.setBlock(i + 15, j + 1, k + 6, PlaceDeepslate, 0, 2);
		world.setBlock(i + 16, j + 1, k + 6, PlaceDeepslate, 0, 2);
		world.setBlock(i + 17, j + 1, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 1, k + 7, PlaceDeepslate, 0, 2);
		world.setBlock(i + 1, j + 1, k + 7, PlaceDeepslate, 0, 2);
		world.setBlock(i + 2, j + 1, k + 7, PlaceDeepslate, 0, 2);
		world.setBlock(i + 3, j + 1, k + 7, PlaceDeepslate, 0, 2);
		world.setBlock(i + 4, j + 1, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 1, k + 7, PlaceDeepslate, 0, 2);
		world.setBlock(i + 6, j + 1, k + 7, PlaceDeepslate, 0, 2);
		world.setBlock(i + 7, j + 1, k + 7, PlaceDeepslate, 0, 2);
		world.setBlock(i + 8, j + 1, k + 7, PlaceDeepslate, 0, 2);
		world.setBlock(i + 9, j + 1, k + 7, PlaceDeepslate, 0, 2);
		world.setBlock(i + 10, j + 1, k + 7, PlaceDeepslate, 0, 2);
		world.setBlock(i + 11, j + 1, k + 7, PlaceDeepslate, 0, 2);
		world.setBlock(i + 12, j + 1, k + 7, PlaceDeepslate, 0, 2);
		world.setBlock(i + 13, j + 1, k + 7, PlaceDeepslate, 0, 2);
		world.setBlock(i + 14, j + 1, k + 7, PlaceDeepslate, 0, 2);
		world.setBlock(i + 15, j + 1, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 1, k + 7, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 17, j + 1, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 1, k + 8, PlaceDeepslate, 0, 2);
		world.setBlock(i + 1, j + 1, k + 8, PlaceDeepslate, 0, 2);
		world.setBlock(i + 2, j + 1, k + 8, PlaceDeepslate, 0, 2);
		world.setBlock(i + 3, j + 1, k + 8, PlaceDeepslate, 0, 2);
		world.setBlock(i + 4, j + 1, k + 8, PlaceDeepslate, 0, 2);
		world.setBlock(i + 5, j + 1, k + 8, PlaceDeepslate, 0, 2);
		world.setBlock(i + 6, j + 1, k + 8, PlaceDeepslate, 0, 2);
		world.setBlock(i + 7, j + 1, k + 8, PlaceDeepslate, 0, 2);
		world.setBlock(i + 8, j + 1, k + 8, PlaceDeepslate, 0, 2);
		world.setBlock(i + 9, j + 1, k + 8, PlaceDeepslate, 0, 2);
		world.setBlock(i + 10, j + 1, k + 8, PlaceDeepslate, 0, 2);
		world.setBlock(i + 11, j + 1, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 1, k + 8, PlaceDeepslate, 0, 2);
		world.setBlock(i + 13, j + 1, k + 8, PlaceDeepslate, 0, 2);
		world.setBlock(i + 14, j + 1, k + 8, PlaceDeepslate, 0, 2);
		world.setBlock(i + 15, j + 1, k + 8, PlaceDeepslate, 0, 2);
		world.setBlock(i + 16, j + 1, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 1, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 1, k + 9, PlaceDeepslate, 0, 2);
		world.setBlock(i + 1, j + 1, k + 9, PlaceDeepslate, 0, 2);
		world.setBlock(i + 2, j + 1, k + 9, PlaceDeepslate, 0, 2);
		world.setBlock(i + 3, j + 1, k + 9, PlaceDeepslate, 0, 2);
		world.setBlock(i + 4, j + 1, k + 9, PlaceDeepslate, 0, 2);
		world.setBlock(i + 5, j + 1, k + 9, PlaceDeepslate, 0, 2);
		world.setBlock(i + 6, j + 1, k + 9, PlaceDeepslate, 0, 2);
		world.setBlock(i + 7, j + 1, k + 9, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 8, j + 1, k + 9, PlaceDeepslate, 0, 2);
		world.setBlock(i + 9, j + 1, k + 9, PlaceDeepslate, 0, 2);
		world.setBlock(i + 10, j + 1, k + 9, PlaceDeepslate, 0, 2);
		world.setBlock(i + 11, j + 1, k + 9, PlaceDeepslate, 0, 2);
		world.setBlock(i + 12, j + 1, k + 9, PlaceDeepslate, 0, 2);
		world.setBlock(i + 13, j + 1, k + 9, PlaceDeepslate, 0, 2);
		world.setBlock(i + 14, j + 1, k + 9, PlaceDeepslate, 0, 2);
		world.setBlock(i + 15, j + 1, k + 9, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 16, j + 1, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 1, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 1, k + 10, PlaceDeepslate, 0, 2);
		world.setBlock(i + 1, j + 1, k + 10, PlaceDeepslate, 0, 2);
		world.setBlock(i + 2, j + 1, k + 10, PlaceDeepslate, 0, 2);
		world.setBlock(i + 3, j + 1, k + 10, PlaceDeepslate, 0, 2);
		world.setBlock(i + 4, j + 1, k + 10, PlaceDeepslate, 0, 2);
		world.setBlock(i + 5, j + 1, k + 10, PlaceDeepslate, 0, 2);
		world.setBlock(i + 6, j + 1, k + 10, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 7, j + 1, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 1, k + 10, PlaceDeepslate, 0, 2);
		world.setBlock(i + 9, j + 1, k + 10, PlaceDeepslate, 0, 2);
		world.setBlock(i + 10, j + 1, k + 10, PlaceDeepslate, 0, 2);
		world.setBlock(i + 11, j + 1, k + 10, PlaceDeepslate, 0, 2);
		world.setBlock(i + 12, j + 1, k + 10, PlaceDeepslate, 0, 2);
		world.setBlock(i + 13, j + 1, k + 10, PlaceDeepslate, 0, 2);
		world.setBlock(i + 14, j + 1, k + 10, PlaceDeepslate, 0, 2);
		world.setBlock(i + 15, j + 1, k + 10, PlaceDeepslate, 0, 2);
		world.setBlock(i + 16, j + 1, k + 10, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 17, j + 1, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 1, k + 11, PlaceDeepslate, 0, 2);
		world.setBlock(i + 1, j + 1, k + 11, PlaceDeepslate, 0, 2);
		world.setBlock(i + 2, j + 1, k + 11, PlaceDeepslate, 0, 2);
		world.setBlock(i + 3, j + 1, k + 11, PlaceDeepslate, 0, 2);
		world.setBlock(i + 4, j + 1, k + 11, PlaceDeepslate, 0, 2);
		world.setBlock(i + 5, j + 1, k + 11, PlaceDeepslate, 0, 2);
		world.setBlock(i + 6, j + 1, k + 11, PlaceDeepslate, 0, 2);
		world.setBlock(i + 7, j + 1, k + 11, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 8, j + 1, k + 11, PlaceDeepslate, 0, 2);
		world.setBlock(i + 9, j + 1, k + 11, PlaceDeepslate, 0, 2);
		world.setBlock(i + 10, j + 1, k + 11, PlaceDeepslate, 0, 2);
		world.setBlock(i + 11, j + 1, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 1, k + 11, PlaceDeepslate, 0, 2);
		world.setBlock(i + 13, j + 1, k + 11, PlaceDeepslate, 0, 2);
		world.setBlock(i + 14, j + 1, k + 11, PlaceDeepslate, 0, 2);
		world.setBlock(i + 15, j + 1, k + 11, PlaceDeepslate, 0, 2);
		world.setBlock(i + 16, j + 1, k + 11, PlaceDeepslate, 0, 2);
		world.setBlock(i + 17, j + 1, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 1, k + 12, PlaceDeepslate, 0, 2);
		world.setBlock(i + 1, j + 1, k + 12, PlaceDeepslate, 0, 2);
		world.setBlock(i + 2, j + 1, k + 12, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 3, j + 1, k + 12, PlaceDeepslate, 0, 2);
		world.setBlock(i + 4, j + 1, k + 12, PlaceDeepslate, 0, 2);
		world.setBlock(i + 5, j + 1, k + 12, PlaceDeepslate, 0, 2);
		world.setBlock(i + 6, j + 1, k + 12, PlaceDeepslate, 0, 2);
		world.setBlock(i + 7, j + 1, k + 12, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 8, j + 1, k + 12, PlaceDeepslate, 0, 2);
		world.setBlock(i + 9, j + 1, k + 12, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 10, j + 1, k + 12, PlaceDeepslate, 0, 2);
		world.setBlock(i + 11, j + 1, k + 12, PlaceDeepslate, 0, 2);
		world.setBlock(i + 12, j + 1, k + 12, PlaceDeepslate, 0, 2);
		world.setBlock(i + 13, j + 1, k + 12, PlaceDeepslate, 0, 2);
		world.setBlock(i + 14, j + 1, k + 12, PlaceDeepslate, 0, 2);
		world.setBlock(i + 15, j + 1, k + 12, PlaceDeepslate, 0, 2);
		world.setBlock(i + 16, j + 1, k + 12, PlaceDeepslate, 0, 2);
		world.setBlock(i + 17, j + 1, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 1, k + 13, PlaceDeepslate, 0, 2);
		world.setBlock(i + 1, j + 1, k + 13, PlaceDeepslate, 0, 2);
		world.setBlock(i + 2, j + 1, k + 13, PlaceDeepslate, 0, 2);
		world.setBlock(i + 3, j + 1, k + 13, PlaceDeepslate, 0, 2);
		world.setBlock(i + 4, j + 1, k + 13, PlaceDeepslate, 0, 2);
		world.setBlock(i + 5, j + 1, k + 13, PlaceDeepslate, 0, 2);
		world.setBlock(i + 6, j + 1, k + 13, PlaceDeepslate, 0, 2);
		world.setBlock(i + 7, j + 1, k + 13, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 8, j + 1, k + 13, PlaceDeepslate, 0, 2);
		world.setBlock(i + 9, j + 1, k + 13, PlaceDeepslate, 0, 2);
		world.setBlock(i + 10, j + 1, k + 13, PlaceDeepslate, 0, 2);
		world.setBlock(i + 11, j + 1, k + 13, PlaceDeepslate, 0, 2);
		world.setBlock(i + 12, j + 1, k + 13, PlaceDeepslate, 0, 2);
		world.setBlock(i + 13, j + 1, k + 13, PlaceDeepslate, 0, 2);
		world.setBlock(i + 14, j + 1, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 1, k + 13, PlaceDeepslate, 0, 2);
		world.setBlock(i + 16, j + 1, k + 13, PlaceDeepslate, 0, 2);
		world.setBlock(i + 17, j + 1, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 1, k + 14, PlaceDeepslate, 0, 2);
		world.setBlock(i + 1, j + 1, k + 14, PlaceDeepslate, 0, 2);
		world.setBlock(i + 2, j + 1, k + 14, PlaceDeepslate, 0, 2);
		world.setBlock(i + 3, j + 1, k + 14, PlaceDeepslate, 0, 2);
		world.setBlock(i + 4, j + 1, k + 14, PlaceDeepslate, 0, 2);
		world.setBlock(i + 5, j + 1, k + 14, PlaceDeepslate, 0, 2);
		world.setBlock(i + 6, j + 1, k + 14, PlaceDeepslate, 0, 2);
		world.setBlock(i + 7, j + 1, k + 14, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 8, j + 1, k + 14, PlaceDeepslate, 0, 2);
		world.setBlock(i + 9, j + 1, k + 14, PlaceDeepslate, 0, 2);
		world.setBlock(i + 10, j + 1, k + 14, PlaceDeepslate, 0, 2);
		world.setBlock(i + 11, j + 1, k + 14, PlaceDeepslate, 0, 2);
		world.setBlock(i + 12, j + 1, k + 14, PlaceDeepslate, 0, 2);
		world.setBlock(i + 13, j + 1, k + 14, PlaceDeepslate, 0, 2);
		world.setBlock(i + 14, j + 1, k + 14, PlaceDeepslate, 0, 2);
		world.setBlock(i + 15, j + 1, k + 14, PlaceDeepslate, 0, 2);
		world.setBlock(i + 16, j + 1, k + 14, PlaceDeepslate, 0, 2);
		world.setBlock(i + 17, j + 1, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 1, k + 15, PlaceDeepslate, 0, 2);
		world.setBlock(i + 1, j + 1, k + 15, PlaceDeepslate, 0, 2);
		world.setBlock(i + 2, j + 1, k + 15, PlaceDeepslate, 0, 2);
		world.setBlock(i + 3, j + 1, k + 15, PlaceDeepslate, 0, 2);
		world.setBlock(i + 4, j + 1, k + 15, PlaceDeepslate, 0, 2);
		world.setBlock(i + 5, j + 1, k + 15, PlaceDeepslate, 0, 2);
		world.setBlock(i + 6, j + 1, k + 15, PlaceDeepslate, 0, 2);
		world.setBlock(i + 7, j + 1, k + 15, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 8, j + 1, k + 15, PlaceDeepslate, 0, 2);
		world.setBlock(i + 9, j + 1, k + 15, PlaceDeepslate, 0, 2);
		world.setBlock(i + 10, j + 1, k + 15, PlaceDeepslate, 0, 2);
		world.setBlock(i + 11, j + 1, k + 15, PlaceDeepslate, 0, 2);
		world.setBlock(i + 12, j + 1, k + 15, PlaceDeepslate, 0, 2);
		world.setBlock(i + 13, j + 1, k + 15, PlaceDeepslate, 0, 2);
		world.setBlock(i + 14, j + 1, k + 15, PlaceDeepslate, 0, 2);
		world.setBlock(i + 15, j + 1, k + 15, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 16, j + 1, k + 15, PlaceDeepslate, 0, 2);
		world.setBlock(i + 17, j + 1, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 1, k + 16, PlaceDeepslate, 0, 2);
		world.setBlock(i + 1, j + 1, k + 16, PlaceDeepslate, 0, 2);
		world.setBlock(i + 2, j + 1, k + 16, PlaceDeepslate, 0, 2);
		world.setBlock(i + 3, j + 1, k + 16, PlaceDeepslate, 0, 2);
		world.setBlock(i + 4, j + 1, k + 16, PlaceDeepslate, 0, 2);
		world.setBlock(i + 5, j + 1, k + 16, PlaceDeepslate, 0, 2);
		world.setBlock(i + 6, j + 1, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 1, k + 16, PlaceDeepslate, 0, 2);
		world.setBlock(i + 8, j + 1, k + 16, PlaceDeepslate, 0, 2);
		world.setBlock(i + 9, j + 1, k + 16, PlaceDeepslate, 0, 2);
		world.setBlock(i + 10, j + 1, k + 16, PlaceDeepslate, 0, 2);
		world.setBlock(i + 11, j + 1, k + 16, PlaceDeepslate, 0, 2);
		world.setBlock(i + 12, j + 1, k + 16, PlaceDeepslate, 0, 2);
		world.setBlock(i + 13, j + 1, k + 16, PlaceDeepslate, 0, 2);
		world.setBlock(i + 14, j + 1, k + 16, PlaceDeepslate, 0, 2);
		world.setBlock(i + 15, j + 1, k + 16, PlaceDeepslate, 0, 2);
		world.setBlock(i + 16, j + 1, k + 16, PlaceDeepslate, 0, 2);
		world.setBlock(i + 17, j + 1, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 1, k + 17, PlaceDeepslate, 0, 2);
		world.setBlock(i + 1, j + 1, k + 17, PlaceDeepslate, 0, 2);
		world.setBlock(i + 2, j + 1, k + 17, PlaceDeepslate, 0, 2);
		world.setBlock(i + 3, j + 1, k + 17, PlaceDeepslate, 0, 2);
		world.setBlock(i + 4, j + 1, k + 17, PlaceDeepslate, 0, 2);
		world.setBlock(i + 5, j + 1, k + 17, PlaceDeepslate, 0, 2);
		world.setBlock(i + 6, j + 1, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 1, k + 17, PlaceDeepslate, 0, 2);
		world.setBlock(i + 8, j + 1, k + 17, PlaceDeepslate, 0, 2);
		world.setBlock(i + 9, j + 1, k + 17, PlaceDeepslate, 0, 2);
		world.setBlock(i + 10, j + 1, k + 17, PlaceDeepslate, 0, 2);
		world.setBlock(i + 11, j + 1, k + 17, PlaceDeepslate, 0, 2);
		world.setBlock(i + 12, j + 1, k + 17, PlaceDeepslate, 0, 2);
		world.setBlock(i + 13, j + 1, k + 17, PlaceDeepslate, 0, 2);
		world.setBlock(i + 14, j + 1, k + 17, PlaceDeepslate, 0, 2);
		world.setBlock(i + 15, j + 1, k + 17, PlaceDeepslate, 0, 2);
		world.setBlock(i + 16, j + 1, k + 17, PlaceDeepslate, 0, 2);
		world.setBlock(i + 17, j + 1, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 1, k + 18, PlaceDeepslate, 0, 2);
		world.setBlock(i + 1, j + 1, k + 18, PlaceDeepslate, 0, 2);
		world.setBlock(i + 2, j + 1, k + 18, PlaceDeepslate, 0, 2);
		world.setBlock(i + 3, j + 1, k + 18, PlaceDeepslate, 0, 2);
		world.setBlock(i + 4, j + 1, k + 18, PlaceDeepslate, 0, 2);
		world.setBlock(i + 5, j + 1, k + 18, PlaceDeepslate, 0, 2);
		world.setBlock(i + 6, j + 1, k + 18, PlaceDeepslate, 0, 2);
		world.setBlock(i + 7, j + 1, k + 18, PlaceDeepslate, 0, 2);
		world.setBlock(i + 8, j + 1, k + 18, PlaceDeepslate, 0, 2);
		world.setBlock(i + 9, j + 1, k + 18, PlaceDeepslate, 0, 2);
		world.setBlock(i + 10, j + 1, k + 18, PlaceDeepslate, 0, 2);
		world.setBlock(i + 11, j + 1, k + 18, PlaceDeepslate, 0, 2);
		world.setBlock(i + 12, j + 1, k + 18, PlaceDeepslate, 0, 2);
		world.setBlock(i + 13, j + 1, k + 18, PlaceDeepslate, 0, 2);
		world.setBlock(i + 14, j + 1, k + 18, PlaceDeepslate, 0, 2);
		world.setBlock(i + 15, j + 1, k + 18, PlaceDeepslateBrickStairs, 1, 2);
		world.setBlock(i + 16, j + 1, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 1, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 1, k + 19, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 1, k + 19, PlaceDeepslate, 0, 2);
		world.setBlock(i + 2, j + 1, k + 19, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 1, k + 19, PlaceDeepslate, 0, 2);
		world.setBlock(i + 4, j + 1, k + 19, PlaceDeepslate, 0, 2);
		world.setBlock(i + 5, j + 1, k + 19, PlaceDeepslate, 0, 2);
		world.setBlock(i + 6, j + 1, k + 19, PlaceDeepslate, 0, 2);
		world.setBlock(i + 7, j + 1, k + 19, PlaceDeepslate, 0, 2);
		world.setBlock(i + 8, j + 1, k + 19, PlaceDeepslate, 0, 2);
		world.setBlock(i + 9, j + 1, k + 19, PlaceDeepslate, 0, 2);
		world.setBlock(i + 10, j + 1, k + 19, PlaceDeepslate, 0, 2);
		world.setBlock(i + 11, j + 1, k + 19, PlaceDeepslate, 0, 2);
		world.setBlock(i + 12, j + 1, k + 19, PlaceDeepslate, 0, 2);
		world.setBlock(i + 13, j + 1, k + 19, PlaceDeepslate, 0, 2);
		world.setBlock(i + 14, j + 1, k + 19, PlaceDeepslate, 0, 2);
		world.setBlock(i + 15, j + 1, k + 19, PlaceDeepslate, 0, 2);
		world.setBlock(i + 16, j + 1, k + 19, PlaceDeepslate, 0, 2);
		world.setBlock(i + 17, j + 1, k + 19, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 1, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 1, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 1, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 1, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 1, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 1, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 1, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 1, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 1, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 1, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 1, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 1, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 1, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 1, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 1, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 1, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 1, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 1, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 2, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 2, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 2, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 2, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 2, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 2, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 2, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 2, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 2, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 2, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 2, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 2, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 2, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 2, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 2, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 2, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 2, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 2, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 2, k + 1, PlaceDeepslate, 0, 2);
		world.setBlock(i + 1, j + 2, k + 1, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 2, j + 2, k + 1, PlaceDeepslate, 0, 2);
		world.setBlock(i + 3, j + 2, k + 1, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 4, j + 2, k + 1, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 5, j + 2, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 2, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 2, k + 1, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 8, j + 2, k + 1, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 9, j + 2, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 2, k + 1, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 11, j + 2, k + 1, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 12, j + 2, k + 1, PlaceDeepslate, 0, 2);
		world.setBlock(i + 13, j + 2, k + 1, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 14, j + 2, k + 1, PlaceDeepslate, 0, 2);
		world.setBlock(i + 15, j + 2, k + 1, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 16, j + 2, k + 1, PlaceDeepslate, 0, 2);
		world.setBlock(i + 17, j + 2, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 2, k + 2, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 1, j + 2, k + 2, PlaceDeepslate, 0, 2);
		world.setBlock(i + 2, j + 2, k + 2, PlaceDeepslate, 0, 2);
		world.setBlock(i + 3, j + 2, k + 2, PlaceDeepslate, 0, 2);
		world.setBlock(i + 4, j + 2, k + 2, PlaceDeepslate, 0, 2);
		world.setBlock(i + 5, j + 2, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 2, k + 2, NovaCraftBlocks.sculk_vein, 4, 2);
		world.setBlock(i + 7, j + 2, k + 2, PlaceDeepslate, 0, 2);
		world.setBlock(i + 8, j + 2, k + 2, PlaceDeepslate, 0, 2);
		world.setBlock(i + 9, j + 2, k + 2, PlaceDeepslate, 0, 2);
		world.setBlock(i + 10, j + 2, k + 2, PlaceDeepslate, 0, 2);
		world.setBlock(i + 11, j + 2, k + 2, PlaceDeepslate, 0, 2);
		world.setBlock(i + 12, j + 2, k + 2, PlaceDeepslate, 0, 2);
		world.setBlock(i + 13, j + 2, k + 2, PlaceDeepslate, 0, 2);
		world.setBlock(i + 14, j + 2, k + 2, PlaceDeepslate, 0, 2);
		world.setBlock(i + 15, j + 2, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 2, k + 2, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 17, j + 2, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 2, k + 3, PlaceDeepslate, 0, 2);
		world.setBlock(i + 1, j + 2, k + 3, PlaceDeepslate, 0, 2);
		world.setBlock(i + 2, j + 2, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 2, k + 3, PlaceDeepslate, 0, 2);
		world.setBlock(i + 4, j + 2, k + 3, PlaceDeepslate, 0, 2);
		world.setBlock(i + 5, j + 2, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 2, k + 3, NovaCraftBlocks.sculk_vein, 4, 2);
		world.setBlock(i + 7, j + 2, k + 3, PlaceDeepslate, 0, 2);
		world.setBlock(i + 8, j + 2, k + 3, PlaceDeepslate, 0, 2);
		world.setBlock(i + 9, j + 2, k + 3, PlaceDeepslate, 0, 2);
		world.setBlock(i + 10, j + 2, k + 3, PlaceDeepslate, 0, 2);
		world.setBlock(i + 11, j + 2, k + 3, PlaceDeepslate, 0, 2);
		world.setBlock(i + 12, j + 2, k + 3, PlaceDeepslate, 0, 2);
		world.setBlock(i + 13, j + 2, k + 3, PlaceDeepslate, 0, 2);
		world.setBlock(i + 14, j + 2, k + 3, PlaceDeepslate, 0, 2);
		world.setBlock(i + 15, j + 2, k + 3, PlaceDeepslate, 0, 2);
		world.setBlock(i + 16, j + 2, k + 3, PlaceDeepslate, 0, 2);
		world.setBlock(i + 17, j + 2, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 2, k + 4, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 1, j + 2, k + 4, PlaceDeepslate, 0, 2);
		world.setBlock(i + 2, j + 2, k + 4, PlaceDeepslate, 0, 2);
		world.setBlock(i + 3, j + 2, k + 4, PlaceDeepslate, 0, 2);
		world.setBlock(i + 4, j + 2, k + 4, PlaceDeepslate, 0, 2);
		world.setBlock(i + 5, j + 2, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 2, k + 4, NovaCraftBlocks.sculk_vein, 4, 2);
		world.setBlock(i + 7, j + 2, k + 4, PlaceDeepslate, 0, 2);
		world.setBlock(i + 8, j + 2, k + 4, PlaceDeepslate, 0, 2);
		world.setBlock(i + 9, j + 2, k + 4, PlaceDeepslate, 0, 2);
		world.setBlock(i + 10, j + 2, k + 4, PlaceDeepslate, 0, 2);
		world.setBlock(i + 11, j + 2, k + 4, PlaceDeepslate, 0, 2);
		world.setBlock(i + 12, j + 2, k + 4, PlaceDeepslate, 0, 2);
		world.setBlock(i + 13, j + 2, k + 4, PlaceDeepslate, 0, 2);
		world.setBlock(i + 14, j + 2, k + 4, PlaceDeepslate, 0, 2);
		world.setBlock(i + 15, j + 2, k + 4, PlaceDeepslate, 0, 2);
		world.setBlock(i + 16, j + 2, k + 4, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 17, j + 2, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 2, k + 5, PlaceDeepslate, 0, 2);
		world.setBlock(i + 1, j + 2, k + 5, PlaceDeepslate, 0, 2);
		world.setBlock(i + 2, j + 2, k + 5, PlaceDeepslate, 0, 2);
		world.setBlock(i + 3, j + 2, k + 5, PlaceDeepslate, 0, 2);
		world.setBlock(i + 4, j + 2, k + 5, PlaceDeepslate, 0, 2);
		world.setBlock(i + 5, j + 2, k + 5, PlaceCobbledDeepslateStairs, 2, 2);
		world.setBlock(i + 6, j + 2, k + 5, PlaceCobbledDeepslateStairs, 2, 2);
		world.setBlock(i + 7, j + 2, k + 5, PlaceDeepslate, 0, 2);
		world.setBlock(i + 8, j + 2, k + 5, PlaceDeepslate, 0, 2);
		world.setBlock(i + 9, j + 2, k + 5, PlaceDeepslate, 0, 2);
		world.setBlock(i + 10, j + 2, k + 5, PlaceDeepslate, 0, 2);
		world.setBlock(i + 11, j + 2, k + 5, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 12, j + 2, k + 5, PlaceDeepslate, 0, 2);
		world.setBlock(i + 13, j + 2, k + 5, PlaceDeepslate, 0, 2);
		world.setBlock(i + 14, j + 2, k + 5, PlaceDeepslate, 0, 2);
		world.setBlock(i + 15, j + 2, k + 5, PlaceDeepslate, 0, 2);
		world.setBlock(i + 16, j + 2, k + 5, PlaceDeepslate, 0, 2);
		world.setBlock(i + 17, j + 2, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 2, k + 6, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 1, j + 2, k + 6, PlaceDeepslate, 0, 2);
		world.setBlock(i + 2, j + 2, k + 6, PlaceDeepslate, 0, 2);
		world.setBlock(i + 3, j + 2, k + 6, PlaceDeepslate, 0, 2);
		world.setBlock(i + 4, j + 2, k + 6, PlaceDeepslate, 0, 2);
		world.setBlock(i + 5, j + 2, k + 6, PlaceDeepslate, 0, 2);
		world.setBlock(i + 6, j + 2, k + 6, PlaceDeepslate, 0, 2);
		world.setBlock(i + 7, j + 2, k + 6, PlaceDeepslate, 0, 2);
		world.setBlock(i + 8, j + 2, k + 6, PlaceDeepslate, 0, 2);
		world.setBlock(i + 9, j + 2, k + 6, PlaceDeepslate, 0, 2);
		world.setBlock(i + 10, j + 2, k + 6, PlaceDeepslate, 0, 2);
		world.setBlock(i + 11, j + 2, k + 6, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 12, j + 2, k + 6, PlaceDeepslate, 0, 2);
		world.setBlock(i + 13, j + 2, k + 6, PlaceDeepslate, 0, 2);
		world.setBlock(i + 14, j + 2, k + 6, PlaceDeepslate, 0, 2);
		world.setBlock(i + 15, j + 2, k + 6, PlaceDeepslate, 0, 2);
		world.setBlock(i + 16, j + 2, k + 6, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 17, j + 2, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 2, k + 7, PlaceDeepslate, 0, 2);
		world.setBlock(i + 1, j + 2, k + 7, PlaceDeepslate, 0, 2);
		world.setBlock(i + 2, j + 2, k + 7, PlaceDeepslate, 0, 2);
		world.setBlock(i + 3, j + 2, k + 7, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 4, j + 2, k + 7, PlaceDeepslate, 0, 2);
		world.setBlock(i + 5, j + 2, k + 7, PlaceDeepslate, 0, 2);
		world.setBlock(i + 6, j + 2, k + 7, PlaceDeepslate, 0, 2);
		world.setBlock(i + 7, j + 2, k + 7, PlaceDeepslate, 0, 2);
		world.setBlock(i + 8, j + 2, k + 7, PlaceDeepslate, 0, 2);
		world.setBlock(i + 9, j + 2, k + 7, PlaceDeepslate, 0, 2);
		world.setBlock(i + 10, j + 2, k + 7, PlaceDeepslate, 0, 2);
		world.setBlock(i + 11, j + 2, k + 7, PlaceDeepslate, 0, 2);
		world.setBlock(i + 12, j + 2, k + 7, PlaceDeepslate, 0, 2);
		world.setBlock(i + 13, j + 2, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 2, k + 7, PlaceDeepslate, 0, 2);
		world.setBlock(i + 15, j + 2, k + 7, PlaceDeepslate, 0, 2);
		world.setBlock(i + 16, j + 2, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 2, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 2, k + 8, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 1, j + 2, k + 8, PlaceDeepslate, 0, 2);
		world.setBlock(i + 2, j + 2, k + 8, PlaceDeepslate, 0, 2);
		world.setBlock(i + 3, j + 2, k + 8, PlaceDeepslate, 0, 2);
		world.setBlock(i + 4, j + 2, k + 8, PlaceDeepslate, 0, 2);
		world.setBlock(i + 5, j + 2, k + 8, PlaceDeepslate, 0, 2);
		world.setBlock(i + 6, j + 2, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 2, k + 8, PlaceDeepslate, 0, 2);
		world.setBlock(i + 8, j + 2, k + 8, PlaceDeepslate, 0, 2);
		world.setBlock(i + 9, j + 2, k + 8, PlaceDeepslate, 0, 2);
		world.setBlock(i + 10, j + 2, k + 8, PlaceDeepslate, 0, 2);
		world.setBlock(i + 11, j + 2, k + 8, PlaceDeepslate, 0, 2);
		world.setBlock(i + 12, j + 2, k + 8, PlaceDeepslate, 0, 2);
		world.setBlock(i + 13, j + 2, k + 8, PlaceDeepslate, 0, 2);
		world.setBlock(i + 14, j + 2, k + 8, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 15, j + 2, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 2, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 2, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 2, k + 9, PlaceDeepslate, 0, 2);
		world.setBlock(i + 1, j + 2, k + 9, PlaceDeepslate, 0, 2);
		world.setBlock(i + 2, j + 2, k + 9, PlaceDeepslate, 0, 2);
		world.setBlock(i + 3, j + 2, k + 9, PlaceDeepslate, 0, 2);
		world.setBlock(i + 4, j + 2, k + 9, PlaceDeepslate, 0, 2);
		world.setBlock(i + 5, j + 2, k + 9, PlaceDeepslate, 0, 2);
		world.setBlock(i + 6, j + 2, k + 9, PlaceDeepslate, 0, 2);
		world.setBlock(i + 7, j + 2, k + 9, PlaceDeepslate, 0, 2);
		world.setBlock(i + 8, j + 2, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 2, k + 9, PlaceDeepslate, 0, 2);
		world.setBlock(i + 10, j + 2, k + 9, PlaceDeepslate, 0, 2);
		world.setBlock(i + 11, j + 2, k + 9, PlaceDeepslate, 0, 2);
		world.setBlock(i + 12, j + 2, k + 9, PlaceDeepslate, 0, 2);
		world.setBlock(i + 13, j + 2, k + 9, NovaCraftBlocks.sculk_vein, 2, 2);
		world.setBlock(i + 14, j + 2, k + 9, PlaceDeepslate, 0, 2);
		world.setBlock(i + 15, j + 2, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 2, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 2, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 2, k + 10, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 1, j + 2, k + 10, PlaceDeepslate, 0, 2);
		world.setBlock(i + 2, j + 2, k + 10, PlaceDeepslate, 0, 2);
		world.setBlock(i + 3, j + 2, k + 10, PlaceDeepslate, 0, 2);
		world.setBlock(i + 4, j + 2, k + 10, PlaceDeepslate, 0, 2);
		world.setBlock(i + 5, j + 2, k + 10, PlaceDeepslate, 0, 2);
		world.setBlock(i + 6, j + 2, k + 10, PlaceDeepslate, 0, 2);
		world.setBlock(i + 7, j + 2, k + 10, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 8, j + 2, k + 10, PlaceDeepslate, 0, 2);
		world.setBlock(i + 9, j + 2, k + 10, PlaceDeepslate, 0, 2);
		world.setBlock(i + 10, j + 2, k + 10, PlaceDeepslate, 0, 2);
		world.setBlock(i + 11, j + 2, k + 10, PlaceDeepslate, 0, 2);
		world.setBlock(i + 12, j + 2, k + 10, PlaceDeepslate, 0, 2);
		world.setBlock(i + 13, j + 2, k + 10, PlaceDeepslate, 0, 2);
		world.setBlock(i + 14, j + 2, k + 10, PlaceDeepslate, 0, 2);
		world.setBlock(i + 15, j + 2, k + 10, PlaceDeepslate, 0, 2);
		world.setBlock(i + 16, j + 2, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 2, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 2, k + 11, PlaceDeepslate, 0, 2);
		world.setBlock(i + 1, j + 2, k + 11, PlaceDeepslate, 0, 2);
		world.setBlock(i + 2, j + 2, k + 11, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 3, j + 2, k + 11, PlaceDeepslate, 0, 2);
		world.setBlock(i + 4, j + 2, k + 11, PlaceDeepslate, 0, 2);
		world.setBlock(i + 5, j + 2, k + 11, PlaceDeepslate, 0, 2);
		world.setBlock(i + 6, j + 2, k + 11, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 7, j + 2, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 2, k + 11, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 9, j + 2, k + 11, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 10, j + 2, k + 11, PlaceDeepslate, 0, 2);
		world.setBlock(i + 11, j + 2, k + 11, PlaceDeepslate, 0, 2);
		world.setBlock(i + 12, j + 2, k + 11, PlaceDeepslate, 0, 2);
		world.setBlock(i + 13, j + 2, k + 11, PlaceDeepslate, 0, 2);
		world.setBlock(i + 14, j + 2, k + 11, PlaceDeepslate, 0, 2);
		world.setBlock(i + 15, j + 2, k + 11, PlaceDeepslate, 0, 2);
		world.setBlock(i + 16, j + 2, k + 11, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 17, j + 2, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 2, k + 12, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 1, j + 2, k + 12, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 2, j + 2, k + 12, NovaCraftBlocks.sculk_vein, 3, 2);
		world.setBlock(i + 3, j + 2, k + 12, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 4, j + 2, k + 12, PlaceDeepslate, 0, 2);
		world.setBlock(i + 5, j + 2, k + 12, PlaceDeepslate, 0, 2);
		world.setBlock(i + 6, j + 2, k + 12, PlaceDeepslate, 0, 2);
		world.setBlock(i + 7, j + 2, k + 12, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 8, j + 2, k + 12, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 9, j + 2, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 2, k + 12, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 11, j + 2, k + 12, PlaceDeepslate, 0, 2);
		world.setBlock(i + 12, j + 2, k + 12, PlaceDeepslate, 0, 2);
		world.setBlock(i + 13, j + 2, k + 12, PlaceDeepslate, 0, 2);
		world.setBlock(i + 14, j + 2, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 2, k + 12, PlaceDeepslate, 0, 2);
		world.setBlock(i + 16, j + 2, k + 12, PlaceDeepslate, 0, 2);
		world.setBlock(i + 17, j + 2, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 2, k + 13, PlaceDeepslate, 0, 2);
		world.setBlock(i + 1, j + 2, k + 13, PlaceDeepslate, 0, 2);
		world.setBlock(i + 2, j + 2, k + 13, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 3, j + 2, k + 13, PlaceDeepslate, 0, 2);
		world.setBlock(i + 4, j + 2, k + 13, PlaceDeepslate, 0, 2);
		world.setBlock(i + 5, j + 2, k + 13, PlaceDeepslate, 0, 2);
		world.setBlock(i + 6, j + 2, k + 13, PlaceDeepslate, 0, 2);
		world.setBlock(i + 7, j + 2, k + 13, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 8, j + 2, k + 13, PlaceDeepslate, 0, 2);
		world.setBlock(i + 9, j + 2, k + 13, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 10, j + 2, k + 13, PlaceDeepslate, 0, 2);
		world.setBlock(i + 11, j + 2, k + 13, PlaceDeepslate, 0, 2);
		world.setBlock(i + 12, j + 2, k + 13, PlaceDeepslate, 0, 2);
		world.setBlock(i + 13, j + 2, k + 13, PlaceDeepslate, 0, 2);
		world.setBlock(i + 14, j + 2, k + 13, PlaceDeepslate, 0, 2);
		world.setBlock(i + 15, j + 2, k + 13, PlaceDeepslate, 0, 2);
		world.setBlock(i + 16, j + 2, k + 13, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 17, j + 2, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 2, k + 14, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 1, j + 2, k + 14, PlaceDeepslate, 0, 2);
		world.setBlock(i + 2, j + 2, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 2, k + 14, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 4, j + 2, k + 14, PlaceDeepslate, 0, 2);
		world.setBlock(i + 5, j + 2, k + 14, PlaceDeepslate, 0, 2);
		world.setBlock(i + 6, j + 2, k + 14, PlaceDeepslate, 0, 2);
		world.setBlock(i + 7, j + 2, k + 14, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 8, j + 2, k + 14, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 9, j + 2, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 2, k + 14, PlaceDeepslate, 0, 2);
		world.setBlock(i + 11, j + 2, k + 14, PlaceDeepslate, 0, 2);
		world.setBlock(i + 12, j + 2, k + 14, PlaceDeepslate, 0, 2);
		world.setBlock(i + 13, j + 2, k + 14, PlaceDeepslate, 0, 2);
		world.setBlock(i + 14, j + 2, k + 14, PlaceDeepslate, 0, 2);
		world.setBlock(i + 15, j + 2, k + 14, PlaceDeepslate, 0, 2);
		world.setBlock(i + 16, j + 2, k + 14, PlaceDeepslate, 0, 2);
		world.setBlock(i + 17, j + 2, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 2, k + 15, PlaceDeepslate, 0, 2);
		world.setBlock(i + 1, j + 2, k + 15, PlaceDeepslate, 0, 2);
		world.setBlock(i + 2, j + 2, k + 15, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 3, j + 2, k + 15, PlaceDeepslate, 0, 2);
		world.setBlock(i + 4, j + 2, k + 15, PlaceDeepslate, 0, 2);
		world.setBlock(i + 5, j + 2, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 2, k + 15, PlaceDeepslate, 0, 2);
		world.setBlock(i + 7, j + 2, k + 15, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 8, j + 2, k + 15, PlaceDeepslate, 0, 2);
		world.setBlock(i + 9, j + 2, k + 15, PlaceDeepslate, 0, 2);
		world.setBlock(i + 10, j + 2, k + 15, PlaceDeepslate, 0, 2);
		world.setBlock(i + 11, j + 2, k + 15, PlaceDeepslate, 0, 2);
		world.setBlock(i + 12, j + 2, k + 15, PlaceDeepslate, 0, 2);
		world.setBlock(i + 13, j + 2, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 2, k + 15, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 15, j + 2, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 2, k + 15, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 17, j + 2, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 2, k + 16, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 1, j + 2, k + 16, PlaceDeepslate, 0, 2);
		world.setBlock(i + 2, j + 2, k + 16, PlaceDeepslate, 0, 2);
		world.setBlock(i + 3, j + 2, k + 16, PlaceDeepslate, 0, 2);
		world.setBlock(i + 4, j + 2, k + 16, PlaceDeepslate, 0, 2);
		world.setBlock(i + 5, j + 2, k + 16, PlaceDeepslate, 0, 2);
		world.setBlock(i + 6, j + 2, k + 16, PlaceDeepslate, 0, 2);
		world.setBlock(i + 7, j + 2, k + 16, PlaceDeepslate, 0, 2);
		world.setBlock(i + 8, j + 2, k + 16, PlaceDeepslate, 0, 2);
		world.setBlock(i + 9, j + 2, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 2, k + 16, PlaceDeepslate, 0, 2);
		world.setBlock(i + 11, j + 2, k + 16, PlaceDeepslate, 0, 2);
		world.setBlock(i + 12, j + 2, k + 16, PlaceDeepslate, 0, 2);
		world.setBlock(i + 13, j + 2, k + 16, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 14, j + 2, k + 16, PlaceDeepslate, 0, 2);
		world.setBlock(i + 15, j + 2, k + 16, PlaceDeepslate, 0, 2);
		world.setBlock(i + 16, j + 2, k + 16, PlaceDeepslate, 0, 2);
		world.setBlock(i + 17, j + 2, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 2, k + 17, PlaceDeepslate, 0, 2);
		world.setBlock(i + 1, j + 2, k + 17, PlaceDeepslate, 0, 2);
		world.setBlock(i + 2, j + 2, k + 17, PlaceDeepslate, 0, 2);
		world.setBlock(i + 3, j + 2, k + 17, PlaceDeepslate, 0, 2);
		world.setBlock(i + 4, j + 2, k + 17, PlaceDeepslate, 0, 2);
		world.setBlock(i + 5, j + 2, k + 17, PlaceDeepslate, 0, 2);
		world.setBlock(i + 6, j + 2, k + 17, PlaceDeepslate, 0, 2);
		world.setBlock(i + 7, j + 2, k + 17, PlaceDeepslate, 0, 2);
		world.setBlock(i + 8, j + 2, k + 17, PlaceDeepslate, 0, 2);
		world.setBlock(i + 9, j + 2, k + 17, PlaceDeepslate, 0, 2);
		world.setBlock(i + 10, j + 2, k + 17, PlaceDeepslate, 0, 2);
		world.setBlock(i + 11, j + 2, k + 17, PlaceDeepslate, 0, 2);
		world.setBlock(i + 12, j + 2, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 2, k + 17, PlaceDeepslate, 0, 2);
		world.setBlock(i + 14, j + 2, k + 17, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 15, j + 2, k + 17, PlaceDeepslate, 0, 2);
		world.setBlock(i + 16, j + 2, k + 17, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 17, j + 2, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 2, k + 18, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 1, j + 2, k + 18, PlaceDeepslate, 0, 2);
		world.setBlock(i + 2, j + 2, k + 18, PlaceDeepslate, 0, 2);
		world.setBlock(i + 3, j + 2, k + 18, PlaceDeepslate, 0, 2);
		world.setBlock(i + 4, j + 2, k + 18, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 5, j + 2, k + 18, PlaceDeepslate, 0, 2);
		world.setBlock(i + 6, j + 2, k + 18, PlaceDeepslate, 0, 2);
		world.setBlock(i + 7, j + 2, k + 18, PlaceDeepslate, 0, 2);
		world.setBlock(i + 8, j + 2, k + 18, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 9, j + 2, k + 18, PlaceDeepslate, 0, 2);
		world.setBlock(i + 10, j + 2, k + 18, PlaceDeepslate, 0, 2);
		world.setBlock(i + 11, j + 2, k + 18, PlaceDeepslate, 0, 2);
		world.setBlock(i + 12, j + 2, k + 18, PlaceDeepslate, 0, 2);
		world.setBlock(i + 13, j + 2, k + 18, PlaceDeepslate, 0, 2);
		world.setBlock(i + 14, j + 2, k + 18, PlaceDeepslateBrickStairs, 1, 2);
		world.setBlock(i + 15, j + 2, k + 18, NovaCraftBlocks.sculk_vein, 3, 2);
		world.setBlock(i + 16, j + 2, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 2, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 2, k + 19, PlaceDeepslate, 0, 2);
		world.setBlock(i + 1, j + 2, k + 19, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 2, j + 2, k + 19, PlaceDeepslate, 0, 2);
		world.setBlock(i + 3, j + 2, k + 19, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 4, j + 2, k + 19, PlaceDeepslate, 0, 2);
		world.setBlock(i + 5, j + 2, k + 19, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 6, j + 2, k + 19, PlaceDeepslate, 0, 2);
		world.setBlock(i + 7, j + 2, k + 19, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 8, j + 2, k + 19, PlaceDeepslate, 0, 2);
		world.setBlock(i + 9, j + 2, k + 19, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 10, j + 2, k + 19, PlaceDeepslate, 0, 2);
		world.setBlock(i + 11, j + 2, k + 19, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 12, j + 2, k + 19, PlaceDeepslate, 0, 2);
		world.setBlock(i + 13, j + 2, k + 19, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 14, j + 2, k + 19, PlaceDeepslate, 0, 2);
		world.setBlock(i + 15, j + 2, k + 19, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 16, j + 2, k + 19, PlaceDeepslate, 0, 2);
		world.setBlock(i + 17, j + 2, k + 19, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 2, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 2, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 2, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 2, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 2, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 2, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 2, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 2, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 2, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 2, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 2, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 2, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 2, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 2, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 2, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 2, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 2, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 2, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 3, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 3, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 3, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 3, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 3, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 3, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 3, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 3, k + 0, NovaCraftBlocks.sculk_vein, 2, 2);
		world.setBlock(i + 8, j + 3, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 3, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 3, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 3, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 3, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 3, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 3, k + 0, NovaCraftBlocks.sculk_vein, 2, 2);
		world.setBlock(i + 15, j + 3, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 3, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 3, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 3, k + 1, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 1, j + 3, k + 1, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 2, j + 3, k + 1, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 3, j + 3, k + 1, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 4, j + 3, k + 1, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 5, j + 3, k + 1, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 6, j + 3, k + 1, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 7, j + 3, k + 1, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 8, j + 3, k + 1, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 9, j + 3, k + 1, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 10, j + 3, k + 1, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 11, j + 3, k + 1, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 12, j + 3, k + 1, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 13, j + 3, k + 1, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 14, j + 3, k + 1, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 15, j + 3, k + 1, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 16, j + 3, k + 1, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 17, j + 3, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 3, k + 2, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 1, j + 3, k + 2, PlaceDeepslate, 0, 2);
		world.setBlock(i + 2, j + 3, k + 2, PlaceDeepslate, 0, 2);
		world.setBlock(i + 3, j + 3, k + 2, PlaceDeepslate, 0, 2);
		world.setBlock(i + 4, j + 3, k + 2, PlaceDeepslate, 0, 2);
		world.setBlock(i + 5, j + 3, k + 2, PlaceCobbledDeepslateStairs, 7, 2);
		world.setBlock(i + 6, j + 3, k + 2, PlaceCobbledDeepslateStairs, 7, 2);
		world.setBlock(i + 7, j + 3, k + 2, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 8, j + 3, k + 2, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 9, j + 3, k + 2, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 10, j + 3, k + 2, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 11, j + 3, k + 2, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 12, j + 3, k + 2, PlaceDeepslate, 0, 2);
		world.setBlock(i + 13, j + 3, k + 2, PlaceDeepslate, 0, 2);
		world.setBlock(i + 14, j + 3, k + 2, PlaceDeepslate, 0, 2);
		world.setBlock(i + 15, j + 3, k + 2, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 16, j + 3, k + 2, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 17, j + 3, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 3, k + 3, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 1, j + 3, k + 3, PlaceDeepslate, 0, 2);
		world.setBlock(i + 2, j + 3, k + 3, PlaceDeepslate, 0, 2);
		world.setBlock(i + 3, j + 3, k + 3, PlaceDeepslate, 0, 2);
		world.setBlock(i + 4, j + 3, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 3, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 3, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 3, k + 3, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 8, j + 3, k + 3, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 9, j + 3, k + 3, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 10, j + 3, k + 3, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 11, j + 3, k + 3, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 12, j + 3, k + 3, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 13, j + 3, k + 3, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 14, j + 3, k + 3, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 15, j + 3, k + 3, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 16, j + 3, k + 3, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 17, j + 3, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 3, k + 4, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 1, j + 3, k + 4, PlaceDeepslate, 0, 2);
		world.setBlock(i + 2, j + 3, k + 4, PlaceDeepslate, 0, 2);
		world.setBlock(i + 3, j + 3, k + 4, PlaceDeepslate, 0, 2);
		world.setBlock(i + 4, j + 3, k + 4, PlaceDeepslate, 0, 2);
		world.setBlock(i + 5, j + 3, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 3, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 3, k + 4, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 8, j + 3, k + 4, PlaceDeepslate, 0, 2);
		world.setBlock(i + 9, j + 3, k + 4, PlaceDeepslate, 0, 2);
		world.setBlock(i + 10, j + 3, k + 4, PlaceDeepslate, 0, 2);
		world.setBlock(i + 11, j + 3, k + 4, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 12, j + 3, k + 4, PlaceDeepslate, 0, 2);
		world.setBlock(i + 13, j + 3, k + 4, PlaceDeepslate, 0, 2);
		world.setBlock(i + 14, j + 3, k + 4, PlaceDeepslate, 0, 2);
		world.setBlock(i + 15, j + 3, k + 4, PlaceDeepslate, 0, 2);
		world.setBlock(i + 16, j + 3, k + 4, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 17, j + 3, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 3, k + 5, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 1, j + 3, k + 5, PlaceDeepslate, 0, 2);
		world.setBlock(i + 2, j + 3, k + 5, PlaceDeepslate, 0, 2);
		world.setBlock(i + 3, j + 3, k + 5, PlaceDeepslate, 0, 2);
		world.setBlock(i + 4, j + 3, k + 5, PlaceDeepslate, 0, 2);
		world.setBlock(i + 5, j + 3, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 3, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 3, k + 5, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 8, j + 3, k + 5, PlaceDeepslate, 0, 2);
		world.setBlock(i + 9, j + 3, k + 5, PlaceDeepslate, 0, 2);
		world.setBlock(i + 10, j + 3, k + 5, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 11, j + 3, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 3, k + 5, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 13, j + 3, k + 5, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 14, j + 3, k + 5, PlaceDeepslate, 0, 2);
		world.setBlock(i + 15, j + 3, k + 5, PlaceDeepslate, 0, 2);
		world.setBlock(i + 16, j + 3, k + 5, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 17, j + 3, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 3, k + 6, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 1, j + 3, k + 6, PlaceDeepslate, 0, 2);
		world.setBlock(i + 2, j + 3, k + 6, PlaceDeepslate, 0, 2);
		world.setBlock(i + 3, j + 3, k + 6, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 4, j + 3, k + 6, PlaceDeepslate, 0, 2);
		world.setBlock(i + 5, j + 3, k + 6, PlaceCobbledDeepslateStairs, 2, 2);
		world.setBlock(i + 6, j + 3, k + 6, PlaceCobbledDeepslateStairs, 2, 2);
		world.setBlock(i + 7, j + 3, k + 6, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 8, j + 3, k + 6, PlaceDeepslate, 0, 2);
		world.setBlock(i + 9, j + 3, k + 6, NovaCraftBlocks.sculk_vein, 1, 2);
		world.setBlock(i + 10, j + 3, k + 6, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 11, j + 3, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 3, k + 6, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 13, j + 3, k + 6, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 14, j + 3, k + 6, PlaceDeepslate, 0, 2);
		world.setBlock(i + 15, j + 3, k + 6, PlaceDeepslate, 0, 2);
		world.setBlock(i + 16, j + 3, k + 6, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 17, j + 3, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 3, k + 7, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 1, j + 3, k + 7, PlaceDeepslate, 0, 2);
		world.setBlock(i + 2, j + 3, k + 7, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 3, j + 3, k + 7, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 4, j + 3, k + 7, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 5, j + 3, k + 7, PlaceDeepslate, 0, 2);
		world.setBlock(i + 6, j + 3, k + 7, NovaCraftBlocks.sculk_vein, 1, 2);
		world.setBlock(i + 7, j + 3, k + 7, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 8, j + 3, k + 7, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 9, j + 3, k + 7, PlaceDeepslate, 0, 2);
		world.setBlock(i + 10, j + 3, k + 7, PlaceDeepslate, 0, 2);
		world.setBlock(i + 11, j + 3, k + 7, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 12, j + 3, k + 7, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 13, j + 3, k + 7, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 14, j + 3, k + 7, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 15, j + 3, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 3, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 3, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 3, k + 8, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 1, j + 3, k + 8, PlaceDeepslate, 0, 2);
		world.setBlock(i + 2, j + 3, k + 8, PlaceDeepslate, 0, 2);
		world.setBlock(i + 3, j + 3, k + 8, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 4, j + 3, k + 8, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 5, j + 3, k + 8, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 6, j + 3, k + 8, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 7, j + 3, k + 8, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 8, j + 3, k + 8, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 9, j + 3, k + 8, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 10, j + 3, k + 8, PlaceDeepslate, 0, 2);
		world.setBlock(i + 11, j + 3, k + 8, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 12, j + 3, k + 8, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 13, j + 3, k + 8, PlaceDeepslate, 0, 2);
		world.setBlock(i + 14, j + 3, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 3, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 3, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 3, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 3, k + 9, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 1, j + 3, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 3, k + 9, PlaceDeepslate, 0, 2);
		world.setBlock(i + 3, j + 3, k + 9, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 4, j + 3, k + 9, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 5, j + 3, k + 9, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 6, j + 3, k + 9, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 7, j + 3, k + 9, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 8, j + 3, k + 9, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 9, j + 3, k + 9, PlaceDeepslate, 0, 2);
		world.setBlock(i + 10, j + 3, k + 9, PlaceDeepslate, 0, 2);
		world.setBlock(i + 11, j + 3, k + 9, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 12, j + 3, k + 9, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 13, j + 3, k + 9, NovaCraftBlocks.sculk_vein, 5, 2);
		world.setBlock(i + 14, j + 3, k + 9, NovaCraftBlocks.sculk_vein, 2, 2);
		world.setBlock(i + 15, j + 3, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 3, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 3, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 3, k + 10, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 1, j + 3, k + 10, PlaceDeepslate, 0, 2);
		world.setBlock(i + 2, j + 3, k + 10, PlaceDeepslate, 0, 2);
		world.setBlock(i + 3, j + 3, k + 10, PlaceDeepslate, 0, 2);
		world.setBlock(i + 4, j + 3, k + 10, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 5, j + 3, k + 10, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 6, j + 3, k + 10, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 7, j + 3, k + 10, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 8, j + 3, k + 10, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 9, j + 3, k + 10, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 10, j + 3, k + 10, PlaceDeepslate, 0, 2);
		world.setBlock(i + 11, j + 3, k + 10, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 12, j + 3, k + 10, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 13, j + 3, k + 10, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 14, j + 3, k + 10, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 15, j + 3, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 3, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 3, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 3, k + 11, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 1, j + 3, k + 11, PlaceDeepslate, 0, 2);
		world.setBlock(i + 2, j + 3, k + 11, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 3, j + 3, k + 11, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 4, j + 3, k + 11, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 5, j + 3, k + 11, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 6, j + 3, k + 11, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 7, j + 3, k + 11, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 8, j + 3, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 3, k + 11, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 10, j + 3, k + 11, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 11, j + 3, k + 11, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 12, j + 3, k + 11, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 13, j + 3, k + 11, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 14, j + 3, k + 11, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 15, j + 3, k + 11, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 16, j + 3, k + 11, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 17, j + 3, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 3, k + 12, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 1, j + 3, k + 12, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 2, j + 3, k + 12, NovaCraftBlocks.sculk_vein, 3, 2);
		world.setBlock(i + 3, j + 3, k + 12, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 4, j + 3, k + 12, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 5, j + 3, k + 12, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 6, j + 3, k + 12, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 7, j + 3, k + 12, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 8, j + 3, k + 12, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 9, j + 3, k + 12, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 10, j + 3, k + 12, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 11, j + 3, k + 12, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 12, j + 3, k + 12, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 13, j + 3, k + 12, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 14, j + 3, k + 12, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 15, j + 3, k + 12, PlaceDeepslate, 0, 2);
		world.setBlock(i + 16, j + 3, k + 12, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 17, j + 3, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 3, k + 13, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 1, j + 3, k + 13, PlaceDeepslate, 0, 2);
		world.setBlock(i + 2, j + 3, k + 13, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 3, j + 3, k + 13, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 4, j + 3, k + 13, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 5, j + 3, k + 13, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 6, j + 3, k + 13, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 7, j + 3, k + 13, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 8, j + 3, k + 13, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 9, j + 3, k + 13, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 10, j + 3, k + 13, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 11, j + 3, k + 13, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 12, j + 3, k + 13, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 13, j + 3, k + 13, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 14, j + 3, k + 13, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 15, j + 3, k + 13, PlaceDeepslate, 0, 2);
		world.setBlock(i + 16, j + 3, k + 13, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 17, j + 3, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 3, k + 14, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 1, j + 3, k + 14, PlaceDeepslate, 0, 2);
		world.setBlock(i + 2, j + 3, k + 14, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 3, j + 3, k + 14, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 4, j + 3, k + 14, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 5, j + 3, k + 14, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 6, j + 3, k + 14, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 7, j + 3, k + 14, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 8, j + 3, k + 14, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 9, j + 3, k + 14, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 10, j + 3, k + 14, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 11, j + 3, k + 14, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 12, j + 3, k + 14, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 13, j + 3, k + 14, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 14, j + 3, k + 14, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 15, j + 3, k + 14, PlaceDeepslate, 0, 2);
		world.setBlock(i + 16, j + 3, k + 14, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 17, j + 3, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 3, k + 15, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 1, j + 3, k + 15, PlaceDeepslate, 0, 2);
		world.setBlock(i + 2, j + 3, k + 15, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 3, j + 3, k + 15, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 4, j + 3, k + 15, PlaceDeepslate, 0, 2);
		world.setBlock(i + 5, j + 3, k + 15, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 6, j + 3, k + 15, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 7, j + 3, k + 15, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 8, j + 3, k + 15, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 9, j + 3, k + 15, PlaceDeepslate, 0, 2);
		world.setBlock(i + 10, j + 3, k + 15, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 11, j + 3, k + 15, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 12, j + 3, k + 15, PlaceDeepslate, 0, 2);
		world.setBlock(i + 13, j + 3, k + 15, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 14, j + 3, k + 15, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 15, j + 3, k + 15, PlaceDeepslate, 0, 2);
		world.setBlock(i + 16, j + 3, k + 15, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 17, j + 3, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 3, k + 16, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 1, j + 3, k + 16, PlaceDeepslate, 0, 2);
		world.setBlock(i + 2, j + 3, k + 16, PlaceDeepslateBrickStairs, 3, 2);
		world.setBlock(i + 3, j + 3, k + 16, PlaceDeepslateBrickStairs, 3, 2);
		world.setBlock(i + 4, j + 3, k + 16, PlaceDeepslate, 0, 2);
		world.setBlock(i + 5, j + 3, k + 16, PlaceDeepslateBrickStairs, 3, 2);
		world.setBlock(i + 6, j + 3, k + 16, PlaceDeepslateBrickStairs, 3, 2);
		world.setBlock(i + 7, j + 3, k + 16, PlaceDeepslate, 0, 2);
		world.setBlock(i + 8, j + 3, k + 16, PlaceDeepslateBrickStairs, 3, 2);
		world.setBlock(i + 9, j + 3, k + 16, PlaceDeepslate, 0, 2);
		world.setBlock(i + 10, j + 3, k + 16, PlaceDeepslateBrickStairs, 3, 2);
		world.setBlock(i + 11, j + 3, k + 16, PlaceDeepslateBrickStairs, 3, 2);
		world.setBlock(i + 12, j + 3, k + 16, PlaceDeepslate, 0, 2);
		world.setBlock(i + 13, j + 3, k + 16, PlaceDeepslateBrickStairs, 3, 2);
		world.setBlock(i + 14, j + 3, k + 16, PlaceDeepslateBrickStairs, 3, 2);
		world.setBlock(i + 15, j + 3, k + 16, PlaceDeepslate, 0, 2);
		world.setBlock(i + 16, j + 3, k + 16, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 17, j + 3, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 3, k + 17, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 1, j + 3, k + 17, PlaceDeepslate, 0, 2);
		world.setBlock(i + 2, j + 3, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 3, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 3, k + 17, PlaceDeepslate, 0, 2);
		world.setBlock(i + 5, j + 3, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 3, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 3, k + 17, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 8, j + 3, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 3, k + 17, PlaceDeepslate, 0, 2);
		world.setBlock(i + 10, j + 3, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 3, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 3, k + 17, PlaceDeepslate, 0, 2);
		world.setBlock(i + 13, j + 3, k + 17, NovaCraftBlocks.sculk_vein, 1, 2);
		world.setBlock(i + 14, j + 3, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 3, k + 17, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 16, j + 3, k + 17, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 17, j + 3, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 3, k + 18, PlaceDeepslate, 0, 2);
		world.setBlock(i + 1, j + 3, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 3, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 3, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 3, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 3, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 3, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 3, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 3, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 3, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 3, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 3, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 3, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 3, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 3, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 3, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 3, k + 18, NovaCraftBlocks.sculk_vein, 3, 2);
		world.setBlock(i + 17, j + 3, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 3, k + 19, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 3, k + 19, PlaceDeepslate, 0, 2);
		world.setBlock(i + 2, j + 3, k + 19, PlaceDeepslate, 0, 2);
		world.setBlock(i + 3, j + 3, k + 19, PlaceDeepslate, 0, 2);
		world.setBlock(i + 4, j + 3, k + 19, PlaceDeepslate, 0, 2);
		world.setBlock(i + 5, j + 3, k + 19, PlaceDeepslate, 0, 2);
		world.setBlock(i + 6, j + 3, k + 19, PlaceDeepslate, 0, 2);
		world.setBlock(i + 7, j + 3, k + 19, PlaceDeepslate, 0, 2);
		world.setBlock(i + 8, j + 3, k + 19, PlaceDeepslate, 0, 2);
		world.setBlock(i + 9, j + 3, k + 19, PlaceDeepslate, 0, 2);
		world.setBlock(i + 10, j + 3, k + 19, PlaceDeepslate, 0, 2);
		world.setBlock(i + 11, j + 3, k + 19, PlaceDeepslate, 0, 2);
		world.setBlock(i + 12, j + 3, k + 19, PlaceDeepslate, 0, 2);
		world.setBlock(i + 13, j + 3, k + 19, PlaceDeepslate, 0, 2);
		world.setBlock(i + 14, j + 3, k + 19, PlaceDeepslate, 0, 2);
		world.setBlock(i + 15, j + 3, k + 19, PlaceDeepslate, 0, 2);
		world.setBlock(i + 16, j + 3, k + 19, PlaceDeepslate, 0, 2);
		world.setBlock(i + 17, j + 3, k + 19, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 3, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 3, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 3, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 3, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 3, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 3, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 3, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 3, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 3, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 3, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 3, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 3, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 3, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 3, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 3, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 3, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 3, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 3, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 4, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 4, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 4, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 4, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 4, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 4, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 4, k + 0, NovaCraftBlocks.sculk_vein, 2, 2);
		world.setBlock(i + 7, j + 4, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 4, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 4, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 4, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 4, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 4, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 4, k + 0, NovaCraftBlocks.sculk_vein, 2, 2);
		world.setBlock(i + 14, j + 4, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 4, k + 0, NovaCraftBlocks.sculk_vein, 2, 2);
		world.setBlock(i + 16, j + 4, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 4, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 4, k + 1, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 1, j + 4, k + 1, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 2, j + 4, k + 1, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 3, j + 4, k + 1, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 4, j + 4, k + 1, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 5, j + 4, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 4, k + 1, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 7, j + 4, k + 1, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 8, j + 4, k + 1, NovaCraftBlocks.sculk_vein, 1, 2);
		world.setBlock(i + 9, j + 4, k + 1, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 10, j + 4, k + 1, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 11, j + 4, k + 1, NovaCraftBlocks.sculk_vein, 1, 2);
		world.setBlock(i + 12, j + 4, k + 1, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 13, j + 4, k + 1, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 14, j + 4, k + 1, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 15, j + 4, k + 1, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 16, j + 4, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 4, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 4, k + 2, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 1, j + 4, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 4, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 4, k + 2, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 4, j + 4, k + 2, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 5, j + 4, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 4, k + 2, NovaCraftBlocks.sculk_vein, 1, 2);
		world.setBlock(i + 7, j + 4, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 4, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 4, k + 2, NovaCraftBlocks.sculk_vein, 3, 2);
		world.setBlock(i + 10, j + 4, k + 2, NovaCraftBlocks.sculk_vein, 3, 2);
		world.setBlock(i + 11, j + 4, k + 2, NovaCraftBlocks.sculk_vein, 4, 2);
		world.setBlock(i + 12, j + 4, k + 2, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 13, j + 4, k + 2, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 14, j + 4, k + 2, NovaCraftBlocks.sculk_vein, 1, 2);
		world.setBlock(i + 15, j + 4, k + 2, NovaCraftBlocks.sculk_vein, 3, 2);
		world.setBlock(i + 16, j + 4, k + 2, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 17, j + 4, k + 2, NovaCraftBlocks.sculk_vein, 5, 2);
		world.setBlock(i + 0, j + 4, k + 3, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 1, j + 4, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 4, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 4, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 4, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 4, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 4, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 4, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 4, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 4, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 4, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 4, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 4, k + 3, NovaCraftBlocks.sculk_vein, 3, 2);
		world.setBlock(i + 13, j + 4, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 4, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 4, k + 3, NovaCraftBlocks.sculk_vein, 4, 2);
		world.setBlock(i + 16, j + 4, k + 3, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 17, j + 4, k + 3, NovaCraftBlocks.sculk_vein, 5, 2);
		world.setBlock(i + 0, j + 4, k + 4, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 2, j + 4, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 4, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 4, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 4, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 4, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 4, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 4, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 4, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 4, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 4, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 4, k + 4, NovaCraftBlocks.sculk_vein, 1, 2);
		world.setBlock(i + 13, j + 4, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 4, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 4, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 4, k + 4, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 17, j + 4, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 4, k + 5, PlaceDeepslate, 0, 2);
		world.setBlock(i + 1, j + 4, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 4, k + 5, NovaCraftBlocks.dim_vanite_torch, 5, 2);
		world.setBlock(i + 3, j + 4, k + 5, NovaCraftBlocks.sculk_vein, 1, 2);
		world.setBlock(i + 4, j + 4, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 4, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 4, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 4, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 4, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 4, k + 5, NovaCraftBlocks.sculk_vein, 1, 2);
		world.setBlock(i + 10, j + 4, k + 5, NovaCraftBlocks.sculk_spike, 1, 2);
		world.setBlock(i + 11, j + 4, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 4, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 4, k + 5, NovaCraftBlocks.sculk_vein, 1, 2);
		world.setBlock(i + 14, j + 4, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 4, k + 5, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 16, j + 4, k + 5, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 17, j + 4, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 4, k + 6, PlaceDeepslate, 0, 2);
		world.setBlock(i + 1, j + 4, k + 6, PlaceDeepslateBrickStairs, 2, 2);
		world.setBlock(i + 2, j + 4, k + 6, PlaceDeepslateBrickSlab, 0, 2);
		world.setBlock(i + 3, j + 4, k + 6, NovaCraftBlocks.dim_vanite_torch, 5, 2);
		world.setBlock(i + 4, j + 4, k + 6, NovaCraftBlocks.sculk_vein, 1, 2);
		world.setBlock(i + 5, j + 4, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 4, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 4, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 4, k + 6, NovaCraftBlocks.sculk_vein, 1, 2);
		world.setBlock(i + 9, j + 4, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 4, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 4, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 4, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 4, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 4, k + 6, NovaCraftBlocks.sculk_vein, 1, 2);
		world.setBlock(i + 15, j + 4, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 4, k + 6, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 17, j + 4, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 4, k + 7, PlaceDeepslate, 0, 2);
		world.setBlock(i + 1, j + 4, k + 7, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 2, j + 4, k + 7, PlaceDeepslateBrickStairs, 1, 2);
		world.setBlock(i + 3, j + 4, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 4, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 4, k + 7, NovaCraftBlocks.sculk_vein, 1, 2);
		world.setBlock(i + 6, j + 4, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 4, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 4, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 4, k + 7, NovaCraftBlocks.sculk_vein, 1, 2);
		world.setBlock(i + 10, j + 4, k + 7, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 11, j + 4, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 4, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 4, k + 7, NovaCraftBlocks.sculk_vein, 1, 2);
		world.setBlock(i + 14, j + 4, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 4, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 4, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 4, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 4, k + 8, PlaceDeepslate, 0, 2);
		world.setBlock(i + 1, j + 4, k + 8, PlaceCrackedDeepslateBricks, 1, 2);
		world.setBlock(i + 2, j + 4, k + 8, PlaceDeepslateBrickStairs, 1, 2);
		world.setBlock(i + 3, j + 4, k + 8, NovaCraftBlocks.sculk_spike, 1, 2);
		world.setBlock(i + 4, j + 4, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 4, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 4, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 4, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 4, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 4, k + 8, PlaceDeepslateBrickSlab, 1, 2);
		world.setBlock(i + 11, j + 4, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 4, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 4, k + 8, NovaCraftBlocks.sculk_vein, 1, 2);
		world.setBlock(i + 14, j + 4, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 4, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 4, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 4, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 4, k + 9, PlaceDeepslate, 0, 2);
		world.setBlock(i + 1, j + 4, k + 9, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 2, j + 4, k + 9, PlaceDeepslateBrickStairs, 1, 2);
		world.setBlock(i + 3, j + 4, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 4, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 4, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 4, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 4, k + 9, NovaCraftBlocks.sculk_vein, 1, 2);
		world.setBlock(i + 8, j + 4, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 4, k + 9, NovaCraftBlocks.sculk_vein, 1, 2);
		world.setBlock(i + 10, j + 4, k + 9, PlaceDeepslateBrickSlab, 1, 2);
		world.setBlock(i + 11, j + 4, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 4, k + 9, NovaCraftBlocks.sculk_vein, 1, 2);
		world.setBlock(i + 13, j + 4, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 4, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 4, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 4, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 4, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 4, k + 10, PlaceDeepslate, 0, 2);
		world.setBlock(i + 1, j + 4, k + 10, PlaceDeepslateBrickStairs, 3, 2);
		world.setBlock(i + 2, j + 4, k + 10, PlaceDeepslateBrickSlab, 0, 2);
		world.setBlock(i + 3, j + 4, k + 10, NovaCraftBlocks.dim_vanite_torch, 5, 2);
		world.setBlock(i + 4, j + 4, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 4, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 4, k + 10, NovaCraftBlocks.sculk_spike, 1, 2);
		world.setBlock(i + 7, j + 4, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 4, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 4, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 4, k + 10, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 11, j + 4, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 4, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 4, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 4, k + 10, NovaCraftBlocks.sculk_vein, 1, 2);
		world.setBlock(i + 15, j + 4, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 4, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 4, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 4, k + 11, PlaceDeepslate, 0, 2);
		world.setBlock(i + 1, j + 4, k + 11, NovaCraftBlocks.sculk_vein, 1, 2);
		world.setBlock(i + 2, j + 4, k + 11, NovaCraftBlocks.dim_vanite_torch, 5, 2);
		world.setBlock(i + 3, j + 4, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 4, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 4, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 4, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 4, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 4, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 4, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 4, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 4, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 4, k + 11, NovaCraftBlocks.sculk_vein, 1, 2);
		world.setBlock(i + 13, j + 4, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 4, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 4, k + 11, NovaCraftBlocks.sculk_vein, 1, 2);
		world.setBlock(i + 16, j + 4, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 4, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 4, k + 12, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 2, j + 4, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 4, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 4, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 4, k + 12, NovaCraftBlocks.sculk_vein, 1, 2);
		world.setBlock(i + 6, j + 4, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 4, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 4, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 4, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 4, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 4, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 4, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 4, k + 12, NovaCraftBlocks.sculk_vein, 1, 2);
		world.setBlock(i + 14, j + 4, k + 12, NovaCraftBlocks.sculk_vein, 1, 2);
		world.setBlock(i + 15, j + 4, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 4, k + 12, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 17, j + 4, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 4, k + 13, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 1, j + 4, k + 13, NovaCraftBlocks.sculk_vein, 1, 2);
		world.setBlock(i + 2, j + 4, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 4, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 4, k + 13, NovaCraftBlocks.sculk_vein, 1, 2);
		world.setBlock(i + 5, j + 4, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 4, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 4, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 4, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 4, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 4, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 4, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 4, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 4, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 4, k + 13, NovaCraftBlocks.sculk_vein, 1, 2);
		world.setBlock(i + 16, j + 4, k + 13, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 17, j + 4, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 4, k + 14, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 1, j + 4, k + 14, PlaceDeepslateTileStairs, 2, 2);
		world.setBlock(i + 2, j + 4, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 4, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 4, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 4, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 4, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 4, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 4, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 4, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 4, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 4, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 4, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 4, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 4, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 4, k + 14, PlaceDeepslateTileStairs, 2, 2);
		world.setBlock(i + 16, j + 4, k + 14, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 17, j + 4, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 4, k + 15, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 1, j + 4, k + 15, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 2, j + 4, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 4, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 4, k + 15, PlaceDeepslateBrickStairs, 2, 2);
		world.setBlock(i + 5, j + 4, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 4, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 4, k + 15, PlaceDeepslateBrickStairs, 2, 2);
		world.setBlock(i + 8, j + 4, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 4, k + 15, PlaceDeepslateBrickStairs, 2, 2);
		world.setBlock(i + 10, j + 4, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 4, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 4, k + 15, PlaceDeepslateBrickStairs, 2, 2);
		world.setBlock(i + 13, j + 4, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 4, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 4, k + 15, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 16, j + 4, k + 15, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 17, j + 4, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 4, k + 16, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 1, j + 4, k + 16, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 2, j + 4, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 4, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 4, k + 16, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 5, j + 4, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 4, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 4, k + 16, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 8, j + 4, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 4, k + 16, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 10, j + 4, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 4, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 4, k + 16, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 13, j + 4, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 4, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 4, k + 16, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 16, j + 4, k + 16, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 17, j + 4, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 4, k + 17, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 1, j + 4, k + 17, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 2, j + 4, k + 17, NovaCraftBlocks.sculk_vein, 5, 2);
		world.setBlock(i + 3, j + 4, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 4, k + 17, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 5, j + 4, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 4, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 4, k + 17, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 8, j + 4, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 4, k + 17, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 10, j + 4, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 4, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 4, k + 17, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 13, j + 4, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 4, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 4, k + 17, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 16, j + 4, k + 17, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 17, j + 4, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 4, k + 18, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 1, j + 4, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 4, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 4, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 4, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 4, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 4, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 4, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 4, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 4, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 4, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 4, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 4, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 4, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 4, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 4, k + 18, NovaCraftBlocks.sculk_vein, 4, 2);
		world.setBlock(i + 16, j + 4, k + 18, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 17, j + 4, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 4, k + 19, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 1, j + 4, k + 19, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 2, j + 4, k + 19, PlaceChiseledDeepslate, 4, 2);
		world.setBlock(i + 3, j + 4, k + 19, PlaceChiseledDeepslate, 4, 2);
		world.setBlock(i + 4, j + 4, k + 19, PlaceChiseledDeepslate, 4, 2);
		world.setBlock(i + 5, j + 4, k + 19, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 6, j + 4, k + 19, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 7, j + 4, k + 19, PlaceChiseledDeepslate, 4, 2);
		world.setBlock(i + 8, j + 4, k + 19, PlaceChiseledDeepslate, 4, 2);
		world.setBlock(i + 9, j + 4, k + 19, PlaceChiseledDeepslate, 4, 2);
		world.setBlock(i + 10, j + 4, k + 19, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 11, j + 4, k + 19, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 12, j + 4, k + 19, PlaceChiseledDeepslate, 4, 2);
		world.setBlock(i + 13, j + 4, k + 19, PlaceChiseledDeepslate, 4, 2);
		world.setBlock(i + 14, j + 4, k + 19, PlaceChiseledDeepslate, 4, 2);
		world.setBlock(i + 15, j + 4, k + 19, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 16, j + 4, k + 19, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 17, j + 4, k + 19, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 4, k + 20, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 1, j + 4, k + 20, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 2, j + 4, k + 20, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 3, j + 4, k + 20, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 4, j + 4, k + 20, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 5, j + 4, k + 20, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 6, j + 4, k + 20, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 7, j + 4, k + 20, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 8, j + 4, k + 20, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 9, j + 4, k + 20, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 10, j + 4, k + 20, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 11, j + 4, k + 20, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 12, j + 4, k + 20, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 13, j + 4, k + 20, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 14, j + 4, k + 20, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 15, j + 4, k + 20, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 16, j + 4, k + 20, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 17, j + 4, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 5, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 5, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 5, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 5, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 5, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 5, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 5, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 5, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 5, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 5, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 5, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 5, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 5, k + 0, NovaCraftBlocks.sculk_vein, 2, 2);
		world.setBlock(i + 13, j + 5, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 5, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 5, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 5, k + 0, NovaCraftBlocks.sculk_vein, 2, 2);
		world.setBlock(i + 17, j + 5, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 5, k + 1, PlaceDeepslate, 0, 2);
		world.setBlock(i + 1, j + 5, k + 1, PlaceDeepslate, 0, 2);
		world.setBlock(i + 2, j + 5, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 5, k + 1, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 4, j + 5, k + 1, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 5, j + 5, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 5, k + 1, NovaCraftBlocks.sculk_vein, 1, 2);
		world.setBlock(i + 7, j + 5, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 5, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 5, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 5, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 5, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 5, k + 1, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 13, j + 5, k + 1, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 14, j + 5, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 5, k + 1, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 16, j + 5, k + 1, PlaceDeepslate, 0, 2);
		world.setBlock(i + 17, j + 5, k + 1, NovaCraftBlocks.sculk_vein, 5, 2);
		world.setBlock(i + 0, j + 5, k + 2, PlaceDeepslate, 0, 2);
		world.setBlock(i + 1, j + 5, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 5, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 5, k + 2, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 4, j + 5, k + 2, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 5, j + 5, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 5, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 5, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 5, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 5, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 5, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 5, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 5, k + 2, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 13, j + 5, k + 2, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 14, j + 5, k + 2, NovaCraftBlocks.sculk_vein, 5, 2);
		world.setBlock(i + 15, j + 5, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 5, k + 2, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 17, j + 5, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 5, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 5, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 5, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 5, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 5, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 5, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 5, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 5, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 5, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 5, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 5, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 5, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 5, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 5, k + 3, NovaCraftBlocks.sculk_vein, 3, 2);
		world.setBlock(i + 14, j + 5, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 5, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 5, k + 3, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 17, j + 5, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 5, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 5, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 5, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 5, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 5, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 5, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 5, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 5, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 5, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 5, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 5, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 5, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 5, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 5, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 5, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 5, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 5, k + 4, PlaceDeepslate, 0, 2);
		world.setBlock(i + 17, j + 5, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 5, k + 5, PlaceDeepslateBrickStairs, 2, 2);
		world.setBlock(i + 1, j + 5, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 5, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 5, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 5, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 5, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 5, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 5, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 5, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 5, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 5, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 5, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 5, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 5, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 5, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 5, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 5, k + 5, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 17, j + 5, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 5, k + 6, PlaceDeepslate, 0, 2);
		world.setBlock(i + 1, j + 5, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 5, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 5, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 5, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 5, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 5, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 5, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 5, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 5, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 5, k + 6, PlaceDeepslateBrickWall, 1, 2);
		world.setBlock(i + 11, j + 5, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 5, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 5, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 5, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 5, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 5, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 5, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 5, k + 7, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 1, j + 5, k + 7, NovaCraftBlocks.dim_vanite_torch, 5, 2);
		world.setBlock(i + 2, j + 5, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 5, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 5, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 5, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 5, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 5, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 5, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 5, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 5, k + 7, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 11, j + 5, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 5, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 5, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 5, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 5, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 5, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 5, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 5, k + 8, PlaceChiseledDeepslate, 4, 2);
		world.setBlock(i + 1, j + 5, k + 8, PlaceChiseledDeepslate, 4, 2);
		world.setBlock(i + 2, j + 5, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 5, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 5, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 5, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 5, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 5, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 5, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 5, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 5, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 5, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 5, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 5, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 5, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 5, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 5, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 5, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 5, k + 9, NovaCraftBlocks.sculk_vein, 3, 2);
		world.setBlock(i + 1, j + 5, k + 9, NovaCraftBlocks.dim_vanite_torch, 5, 2);
		world.setBlock(i + 2, j + 5, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 5, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 5, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 5, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 5, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 5, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 5, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 5, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 5, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 5, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 5, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 5, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 5, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 5, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 5, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 5, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 5, k + 10, PlaceDeepslate, 0, 2);
		world.setBlock(i + 1, j + 5, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 5, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 5, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 5, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 5, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 5, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 5, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 5, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 5, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 5, k + 10, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 11, j + 5, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 5, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 5, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 5, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 5, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 5, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 5, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 5, k + 11, PlaceDeepslateBrickStairs, 3, 2);
		world.setBlock(i + 1, j + 5, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 5, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 5, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 5, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 5, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 5, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 5, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 5, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 5, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 5, k + 11, PlaceDeepslateBrickWall, 1, 2);
		world.setBlock(i + 11, j + 5, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 5, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 5, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 5, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 5, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 5, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 5, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 5, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 5, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 5, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 5, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 5, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 5, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 5, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 5, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 5, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 5, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 5, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 5, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 5, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 5, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 5, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 5, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 5, k + 12, PlaceDeepslate, 0, 2);
		world.setBlock(i + 17, j + 5, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 5, k + 13, PlaceDeepslate, 0, 2);
		world.setBlock(i + 1, j + 5, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 5, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 5, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 5, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 5, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 5, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 5, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 5, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 5, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 5, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 5, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 5, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 5, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 5, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 5, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 5, k + 13, PlaceDeepslate, 0, 2);
		world.setBlock(i + 17, j + 5, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 5, k + 14, PlaceDeepslate, 0, 2);
		world.setBlock(i + 1, j + 5, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 5, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 5, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 5, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 5, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 5, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 5, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 5, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 5, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 5, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 5, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 5, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 5, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 5, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 5, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 5, k + 14, PlaceDeepslate, 0, 2);
		world.setBlock(i + 17, j + 5, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 5, k + 15, PlaceDeepslate, 0, 2);
		world.setBlock(i + 1, j + 5, k + 15, PlaceDeepslateTileStairs, 2, 2);
		world.setBlock(i + 2, j + 5, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 5, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 5, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 5, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 5, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 5, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 5, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 5, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 5, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 5, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 5, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 5, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 5, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 5, k + 15, PlaceDeepslateTileStairs, 2, 2);
		world.setBlock(i + 16, j + 5, k + 15, PlaceDeepslate, 0, 2);
		world.setBlock(i + 17, j + 5, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 5, k + 16, PlaceDeepslate, 0, 2);
		world.setBlock(i + 1, j + 5, k + 16, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 2, j + 5, k + 16, NovaCraftBlocks.sculk_vein, 5, 2);
		world.setBlock(i + 3, j + 5, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 5, k + 16, NovaCraftBlocks.dim_vanite_torch, 5, 2);
		world.setBlock(i + 5, j + 5, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 5, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 5, k + 16, NovaCraftBlocks.dim_vanite_torch, 5, 2);
		world.setBlock(i + 8, j + 5, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 5, k + 16, NovaCraftBlocks.dim_vanite_torch, 5, 2);
		world.setBlock(i + 10, j + 5, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 5, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 5, k + 16, NovaCraftBlocks.dim_vanite_torch, 5, 2);
		world.setBlock(i + 13, j + 5, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 5, k + 16, NovaCraftBlocks.sculk_vein, 4, 2);
		world.setBlock(i + 15, j + 5, k + 16, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 16, j + 5, k + 16, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 17, j + 5, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 5, k + 17, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 1, j + 5, k + 17, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 2, j + 5, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 5, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 5, k + 17, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 5, j + 5, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 5, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 5, k + 17, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 8, j + 5, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 5, k + 17, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 10, j + 5, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 5, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 5, k + 17, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 13, j + 5, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 5, k + 17, NovaCraftBlocks.sculk_vein, 4, 2);
		world.setBlock(i + 15, j + 5, k + 17, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 16, j + 5, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 5, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 5, k + 18, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 1, j + 5, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 5, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 5, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 5, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 5, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 5, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 5, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 5, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 5, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 5, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 5, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 5, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 5, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 5, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 5, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 5, k + 18, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 17, j + 5, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 5, k + 19, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 1, j + 5, k + 19, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 2, j + 5, k + 19, NovaCraftBlocks.dim_vanite_torch, 5, 2);
		world.setBlock(i + 3, j + 5, k + 19, NovaCraftBlocks.dim_vanite_torch, 5, 2);
		world.setBlock(i + 4, j + 5, k + 19, Blocks.skull, 1, 2);
		world.setBlock(i + 5, j + 5, k + 19, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 6, j + 5, k + 19, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 7, j + 5, k + 19, NovaCraftBlocks.dim_vanite_torch, 5, 2);
		world.setBlock(i + 8, j + 5, k + 19, NovaCraftBlocks.dim_vanite_torch, 5, 2);
		world.setBlock(i + 9, j + 5, k + 19, NovaCraftBlocks.dim_vanite_torch, 5, 2);
		world.setBlock(i + 10, j + 5, k + 19, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 11, j + 5, k + 19, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 12, j + 5, k + 19, NovaCraftBlocks.dim_vanite_torch, 5, 2);
		world.setBlock(i + 13, j + 5, k + 19, NovaCraftBlocks.dim_vanite_torch, 5, 2);
		world.setBlock(i + 14, j + 5, k + 19, NovaCraftBlocks.dim_vanite_torch, 5, 2);
		world.setBlock(i + 15, j + 5, k + 19, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 16, j + 5, k + 19, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 17, j + 5, k + 19, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 5, k + 20, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 1, j + 5, k + 20, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 2, j + 5, k + 20, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 3, j + 5, k + 20, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 4, j + 5, k + 20, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 5, j + 5, k + 20, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 6, j + 5, k + 20, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 7, j + 5, k + 20, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 8, j + 5, k + 20, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 9, j + 5, k + 20, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 10, j + 5, k + 20, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 11, j + 5, k + 20, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 12, j + 5, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 5, k + 20, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 14, j + 5, k + 20, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 15, j + 5, k + 20, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 16, j + 5, k + 20, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 17, j + 5, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 6, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 6, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 6, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 6, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 6, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 6, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 6, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 6, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 6, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 6, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 6, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 6, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 6, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 6, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 6, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 6, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 6, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 17, j + 6, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 6, k + 1, PlaceDeepslate, 0, 2);
		world.setBlock(i + 1, j + 6, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 6, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 6, k + 1, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 4, j + 6, k + 1, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 5, j + 6, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 6, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 6, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 6, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 6, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 6, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 6, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 6, k + 1, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 13, j + 6, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 6, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 6, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 6, k + 1, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 17, j + 6, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 6, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 6, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 6, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 6, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 6, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 6, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 6, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 6, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 6, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 6, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 6, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 6, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 6, k + 2, Blocks.air, 0, 2);
		
		world.setBlock(i + 1, j + 4, k + 4, Blocks.chest, 5, 2);
		TileEntityChest chest = (TileEntityChest) world.getTileEntity(i + 1, j + 4, k + 4);

		for (int slot = 0; slot < 3 + random.nextInt(25); slot++) {
			chest.setInventorySlotContents(random.nextInt(chest.getSizeInventory()), this.getBasicLoot(random));
		}
		
		world.setBlock(i + 1, j + 4, k + 12, Blocks.chest, 5, 2);
		TileEntityChest chest2 = (TileEntityChest) world.getTileEntity(i + 1, j + 4, k + 12);

		for (int slot = 0; slot < 3 + random.nextInt(25); slot++) {
			chest2.setInventorySlotContents(random.nextInt(chest2.getSizeInventory()), this.getBasicLoot(random));
		}
		
		EntityWardenVessel warden = new EntityWardenVessel(world);
		warden.setPosition(i + 1, j + 6, k + 12);

		if (!world.isRemote) {
			world.spawnEntityInWorld(warden);
		}
		
		world.setBlock(i + 8, j + 4, k + 8, Blocks.mob_spawner, 0, 2);
		TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner)world.getTileEntity(i + 8, j + 4, k + 8);
        
        if (tileentitymobspawner != null)
        {
        	tileentitymobspawner.func_145881_a().setEntityName("nova_craft.sculk_incinerator");
        }
		
		world.setBlock(i + 13, j + 4, k + 13, Blocks.mob_spawner, 0, 2);
		TileEntityMobSpawner tileentitymobspawner2 = (TileEntityMobSpawner)world.getTileEntity(i + 13, j + 4, k + 13);
        
        if (tileentitymobspawner2 != null)
        {
        	tileentitymobspawner2.func_145881_a().setEntityName("nova_craft.sculk_dweller");
        }

    	return true;
    }
    
    private ItemStack getBasicLoot(Random random) {
		int item = random.nextInt(34);
		switch (item) {
			case 0:
				return new ItemStack(Items.coal, random.nextInt(9) + 6);
			case 1:
				return new ItemStack(Items.bone, random.nextInt(14) + 1);
			case 2:
				return new ItemStack(NovaCraftItems.larimar_shard, random.nextInt(2) + 1);
			case 3:
				return new ItemStack(NovaCraftItems.copartz_shard, random.nextInt(3) + 1);
			case 4:
				return new ItemStack(NovaCraftItems.tsavorokite_shard, random.nextInt(1) + 1);
			case 5:
				return new ItemStack(NovaCraftItems.yttrlinsite_shard, 1);
			case 6:
				if (Loader.isModLoaded("netherlicious")) {
					return new ItemStack(OtherModBlocks.SoulTorch, random.nextInt(14) + 1);
				}
				if (Loader.isModLoaded("etfuturum")) {
					return new ItemStack(OtherModBlocks.soul_torch, random.nextInt(14) + 1);
				}
				else {
					return new ItemStack(NovaCraftBlocks.dim_vanite_torch, random.nextInt(14) + 1);
				}
			case 7: 
				return new ItemStack(NovaCraftItems.disc_fragment_5, 1);
			case 8: 
				return new ItemStack(Items.book, random.nextInt(7) + 2);
			case 9: 
				Enchantment enchantment = Enchantment.enchantmentsBookList[random.nextInt(Enchantment.enchantmentsBookList.length)];
		        		        
				int minLevel = enchantment.getMinLevel();
		        int maxLevel = enchantment.getMaxLevel();
		        int level = MathHelper.getRandomIntegerInRange(random, minLevel, maxLevel);
		        ItemStack itemStack = Items.enchanted_book.getEnchantedItemStack(new EnchantmentData(enchantment, maxLevel));
                
                return itemStack;
			case 10: 
				Enchantment enchantment2 = Enchantment.enchantmentsBookList[random.nextInt(Enchantment.enchantmentsBookList.length)];
		        
		        int minLevel2 = enchantment2.getMinLevel();
		        int maxLevel2 = enchantment2.getMaxLevel();
		        int level2 = MathHelper.getRandomIntegerInRange(random, minLevel2, maxLevel2);		       
		        ItemStack itemStack2 = Items.enchanted_book.getEnchantedItemStack(new EnchantmentData(enchantment2, maxLevel2));
                
                return itemStack2;
                
			case 11: 
				return new ItemStack(Items.potionitem, 1, 8257);
			case 12: 
				if (Loader.isModLoaded("etfuturum")) {
					return new ItemStack(OtherModItems.amethyst_shard, random.nextInt(14) + 1);
				}
				else {
					return new ItemStack(NovaCraftItems.copartz_shard, random.nextInt(14) + 1);
				}
			case 13: 
				return new ItemStack(NovaCraftBlocks.sculk_block, random.nextInt(6) + 4);
			case 14: 
				return new ItemStack(Items.experience_bottle, random.nextInt(2) + 1);
			case 15:
				//Helmet enchants
			    Enchantment[] helmetEnchantments = {Enchantment.protection, Enchantment.projectileProtection, Enchantment.unbreaking, Enchantment.respiration};
			    Enchantment[] helmetEnchantments2 = {Enchantment.aquaAffinity, Enchantment.fireProtection, Enchantment.blastProtection};
			    Enchantment enchantment3 = helmetEnchantments[random.nextInt(helmetEnchantments.length)];
			    Enchantment enchantment33 = helmetEnchantments2[random.nextInt(helmetEnchantments2.length)];	
			    int maxLevel3 = enchantment3.getMaxLevel();			
			    int maxLevel33 = enchantment33.getMaxLevel();	
			    ItemStack itemStack3 = new ItemStack(Items.diamond_helmet);
			    
			    itemStack3.addEnchantment(enchantment3, maxLevel3);
			    itemStack3.addEnchantment(enchantment33, maxLevel33);
			    
			    return itemStack3;
			case 16:
				//Chestplate enchants
			    Enchantment[] chestplateEnchantments = {Enchantment.protection, Enchantment.blastProtection};
			    Enchantment[] chestplateEnchantments2 = {Enchantment.unbreaking, Enchantment.fireProtection, Enchantment.projectileProtection};
			    
			    //Selects a random enchantment
			    Enchantment enchantment4 = chestplateEnchantments[random.nextInt(chestplateEnchantments.length)];		    
			    int maxLevel4 = enchantment4.getMaxLevel();		    
			    
			    Enchantment enchantment44 = chestplateEnchantments2[random.nextInt(chestplateEnchantments2.length)];		    
			    int maxLevel44 = enchantment44.getMaxLevel();
			    
			    //Creates an ItemStack for diamond chestplate
			    ItemStack itemStack4 = new ItemStack(Items.diamond_chestplate);
			    
			    //Adds the enchantment
			    itemStack4.addEnchantment(enchantment4, maxLevel4);
			    itemStack4.addEnchantment(enchantment44, maxLevel44);
			    
			    return itemStack4;			
			case 17:
				//Legging enchants
			    Enchantment[] leggingsEnchantments = {Enchantment.protection, Enchantment.fireProtection};
			    Enchantment[] leggingsEnchantments2 = {Enchantment.unbreaking, Enchantment.blastProtection, Enchantment.projectileProtection};
			    Enchantment enchantment5 = leggingsEnchantments[random.nextInt(leggingsEnchantments.length)];
			    Enchantment enchantment55 = leggingsEnchantments2[random.nextInt(leggingsEnchantments2.length)];
			    int maxLevel5 = enchantment5.getMaxLevel();
			    int maxLevel55 = enchantment55.getMaxLevel();
			    ItemStack itemStack5 = new ItemStack(Items.diamond_leggings);
			    
			    itemStack5.addEnchantment(enchantment5, maxLevel5);
			    itemStack5.addEnchantment(enchantment55, maxLevel55);
			    
			    return itemStack5;
			case 18:
				//Boot enchants
				Enchantment[] bootEnchantments = {Enchantment.protection, Enchantment.unbreaking};
			    Enchantment[] bootEnchantments2 = {Enchantment.projectileProtection, Enchantment.featherFalling, Enchantment.blastProtection, Enchantment.fireProtection};
			    Enchantment enchantment6 = bootEnchantments[random.nextInt(bootEnchantments.length)];
			    Enchantment enchantment66 = bootEnchantments2[random.nextInt(bootEnchantments2.length)];
			    int maxLevel6 = enchantment6.getMaxLevel();
			    int maxLevel66 = enchantment66.getMaxLevel();
			    ItemStack itemStack6 = new ItemStack(Items.diamond_boots);
			    
			    itemStack6.addEnchantment(enchantment6, maxLevel6);
			    itemStack6.addEnchantment(enchantment66, maxLevel66);
			    
			    return itemStack6;
			case 19: 
				return new ItemStack(Items.iron_ingot, random.nextInt(14) + 7);
			case 20: 
				return new ItemStack(Items.gold_ingot, random.nextInt(7) + 3);
			case 21: 
				return new ItemStack(NovaCraftItems.vanite_ingot, random.nextInt(15) + 8);
			case 22: 
				return new ItemStack(Items.golden_apple, 1, 1);
			case 23:
				return new ItemStack(NovaCraftItems.sculk_leggings, 1);
			case 24: 
				return new ItemStack(NovaCraftItems.sculk_dweller_heart, 1);
			case 25: 
				return new ItemStack(NovaCraftItems.sculked_monitor_scales, random.nextInt(2) + 1);
			case 26: 
				return new ItemStack(NovaCraftItems.luminant_gel, random.nextInt(8) + 3);
			case 27: 
				return new ItemStack(Items.gunpowder, random.nextInt(6) + 5);
			case 28:
				if (Configs.enableTreasureCratesDropDiamonds == true) {
					return new ItemStack(Items.diamond, 1);
				}
				else {
					return new ItemStack(Items.iron_ingot, random.nextInt(14) + 7);
				}
			case 29: 
				return new ItemStack(NovaCraftItems.ancient_city_artifact, 1);
			case 30: 
				return new ItemStack(NovaCraftItems.vanite_ingot, random.nextInt(15) + 8);
			case 31: 
				return new ItemStack(NovaCraftItems.primeval_horn, 1);
			default: {
				return new ItemStack(NovaCraftBlocks.sculk_block, random.nextInt(9) + 2);
			}
		}
	}

}
