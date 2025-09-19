package com.NovaCraft.world.ancient_city;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.world.gen.feature.*;
import net.minecraft.block.*;
import net.minecraft.world.*;
import java.util.*;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.config.Configs;
import com.NovaCraft.registry.OtherModBlocks;
import com.NovaCraftBlocks.NovaCraftBlocks;

import cpw.mods.fml.common.Loader;
import net.minecraft.init.*;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;

public class AncientCityNetherPortalGen extends WorldGenerator
{
	public AncientCityNetherPortalGen() {

	}
	private Block PlaceDeepslateBricks;
	private Block PlaceCrackedDeepslateBricks;
	private Block PlaceSoulLantern;
	private Block PlaceDeepslateTileStairs;
	private Block PlaceDeepslateBrickWall;

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
					System.out.println("Missing Deepslate from Et Futurum Requiem, using Grimstone instead...");
				}
				return NovaCraftBlocks.grimstone_brick_wall;
			}
		}

		return NovaCraftBlocks.grimstone_brick_wall;
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

	private Block determineIfSoulLanternExists(World world, int x, int y, int z) {
		Block existingBlock = world.getBlock(x, y, z);

		if (!(Configs.enableEtFuturumSoulLanternInAncientCity) && Loader.isModLoaded("netherlicious")) {
			try {
				Block SoulLantern = GameRegistry.findBlock("netherlicious", "SoulLantern");
				if (SoulLantern != null && (existingBlock == null || existingBlock != SoulLantern)) {
					return SoulLantern;
				}
			} catch (Exception ex) {
				if (Configs.enableDebugMode) {
					System.out.println("Failed to Find Netherlicious soul lantern, trying Et Futurum Requiem...");
				}
			}
		}

		if (Loader.isModLoaded("etfuturum")) {
			try {
				Block soul_lantern = GameRegistry.findBlock("etfuturum", "soul_lantern");
				if (soul_lantern != null && (existingBlock == null || existingBlock != soul_lantern)) {
					return soul_lantern;
				}
			} catch (Exception ex) {
				if (Configs.enableDebugMode) {
					System.out.println("Failed to Find Et Futurum Requiem soul lantern, placing nothing...");
				}
			}
		}

		return Blocks.air;
	}
    
    public boolean generate(final World world, final Random random, final int i, final int j, final int k) {
    	PlaceDeepslateBricks = determineIfDeepslateBricksExists(world, i + 2, j + 0, k + 1);
    	PlaceCrackedDeepslateBricks = determineIfCrackedDeepslateBricksExists(world, i + 5, j + 0, k + 1);
    	PlaceDeepslateBrickWall = determineIfDeepslateBrickWallExists(world, i + 3, j + 4, k + 6);
    	PlaceDeepslateTileStairs = determineIfDeepslateTileStairsExists(world, i + 1, j + 0, k + 0);
    	PlaceSoulLantern = determineIfSoulLanternExists(world, i + 3, j + 3, k + 6);
    	
		world.setBlock(i + 1, j + 0, k + 0, PlaceDeepslateTileStairs, 0, 2);
		world.setBlock(i + 2, j + 0, k + 0, PlaceDeepslateTileStairs, 2, 2);
		world.setBlock(i + 3, j + 0, k + 0, PlaceDeepslateTileStairs, 2, 2);
		world.setBlock(i + 4, j + 0, k + 0, PlaceDeepslateTileStairs, 2, 2);
		world.setBlock(i + 5, j + 0, k + 0, PlaceDeepslateTileStairs, 2, 2);
		world.setBlock(i + 6, j + 0, k + 0, PlaceDeepslateTileStairs, 2, 2);
		world.setBlock(i + 7, j + 0, k + 0, PlaceDeepslateTileStairs, 1, 2);
		world.setBlock(i + 0, j + 0, k + 1, PlaceDeepslateTileStairs, 2, 2);
		world.setBlock(i + 1, j + 0, k + 1, PlaceDeepslateTileStairs, 0, 2);
		world.setBlock(i + 2, j + 0, k + 1, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 3, j + 0, k + 1, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 4, j + 0, k + 1, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 5, j + 0, k + 1, PlaceCrackedDeepslateBricks, 1, 2);
		world.setBlock(i + 6, j + 0, k + 1, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 7, j + 0, k + 1, PlaceDeepslateTileStairs, 2, 2);
		world.setBlock(i + 8, j + 0, k + 1, PlaceDeepslateTileStairs, 1, 2);
		world.setBlock(i + 0, j + 0, k + 2, PlaceDeepslateTileStairs, 0, 2);
		world.setBlock(i + 1, j + 0, k + 2, PlaceCrackedDeepslateBricks, 1, 2);
		world.setBlock(i + 2, j + 0, k + 2, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 3, j + 0, k + 2, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 4, j + 0, k + 2, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 5, j + 0, k + 2, PlaceCrackedDeepslateBricks, 1, 2);
		world.setBlock(i + 6, j + 0, k + 2, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 7, j + 0, k + 2, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 8, j + 0, k + 2, PlaceDeepslateTileStairs, 1, 2);
		world.setBlock(i + 0, j + 0, k + 3, PlaceDeepslateTileStairs, 0, 2);
		world.setBlock(i + 1, j + 0, k + 3, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 2, j + 0, k + 3, PlaceCrackedDeepslateBricks, 1, 2);
		world.setBlock(i + 3, j + 0, k + 3, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 4, j + 0, k + 3, Blocks.obsidian, 0, 2);
		world.setBlock(i + 5, j + 0, k + 3, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 6, j + 0, k + 3, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 7, j + 0, k + 3, PlaceCrackedDeepslateBricks, 1, 2);
		world.setBlock(i + 8, j + 0, k + 3, PlaceDeepslateTileStairs, 1, 2);
		world.setBlock(i + 0, j + 0, k + 4, PlaceDeepslateTileStairs, 0, 2);
		world.setBlock(i + 1, j + 0, k + 4, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 2, j + 0, k + 4, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 3, j + 0, k + 4, PlaceCrackedDeepslateBricks, 1, 2);
		world.setBlock(i + 4, j + 0, k + 4, Blocks.obsidian, 0, 2);
		world.setBlock(i + 5, j + 0, k + 4, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 6, j + 0, k + 4, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 7, j + 0, k + 4, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 8, j + 0, k + 4, PlaceDeepslateTileStairs, 1, 2);
		world.setBlock(i + 0, j + 0, k + 5, PlaceDeepslateTileStairs, 0, 2);
		world.setBlock(i + 1, j + 0, k + 5, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 2, j + 0, k + 5, PlaceCrackedDeepslateBricks, 1, 2);
		world.setBlock(i + 3, j + 0, k + 5, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 4, j + 0, k + 5, Blocks.obsidian, 0, 2);
		world.setBlock(i + 5, j + 0, k + 5, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 6, j + 0, k + 5, PlaceCrackedDeepslateBricks, 1, 2);
		world.setBlock(i + 7, j + 0, k + 5, PlaceCrackedDeepslateBricks, 1, 2);
		world.setBlock(i + 8, j + 0, k + 5, PlaceDeepslateTileStairs, 1, 2);
		world.setBlock(i + 0, j + 0, k + 6, PlaceDeepslateTileStairs, 0, 2);
		world.setBlock(i + 1, j + 0, k + 6, PlaceDeepslateTileStairs, 3, 2);
		world.setBlock(i + 2, j + 0, k + 6, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 3, j + 0, k + 6, PlaceCrackedDeepslateBricks, 1, 2);
		world.setBlock(i + 4, j + 0, k + 6, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 5, j + 0, k + 6, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 6, j + 0, k + 6, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 7, j + 0, k + 6, PlaceDeepslateTileStairs, 1, 2);
		world.setBlock(i + 8, j + 0, k + 6, PlaceDeepslateTileStairs, 3, 2);
		world.setBlock(i + 1, j + 0, k + 7, PlaceDeepslateTileStairs, 0, 2);
		world.setBlock(i + 2, j + 0, k + 7, PlaceDeepslateTileStairs, 3, 2);
		world.setBlock(i + 3, j + 0, k + 7, PlaceDeepslateTileStairs, 3, 2);
		world.setBlock(i + 4, j + 0, k + 7, PlaceDeepslateTileStairs, 3, 2);
		world.setBlock(i + 5, j + 0, k + 7, PlaceDeepslateTileStairs, 3, 2);
		world.setBlock(i + 6, j + 0, k + 7, PlaceDeepslateTileStairs, 3, 2);
		world.setBlock(i + 7, j + 0, k + 7, PlaceDeepslateTileStairs, 3, 2);
		world.setBlock(i + 4, j + 1, k + 1, Blocks.obsidian, 0, 2);
		world.setBlock(i + 6, j + 1, k + 1, NovaCraftBlocks.sculk_vein, 1, 2);
		world.setBlock(i + 4, j + 1, k + 2, Blocks.obsidian, 0, 2);
		world.setBlock(i + 1, j + 1, k + 4, NovaCraftBlocks.sculk_vein, 1, 2);
		world.setBlock(i + 4, j + 1, k + 4, Blocks.obsidian, 0, 2);
		world.setBlock(i + 4, j + 1, k + 5, Blocks.obsidian, 0, 2);
		world.setBlock(i + 6, j + 1, k + 5, NovaCraftBlocks.sculk_vein, 1, 2);
		world.setBlock(i + 4, j + 1, k + 6, Blocks.obsidian, 0, 2);
		world.setBlock(i + 4, j + 2, k + 2, Blocks.obsidian, 0, 2);
		world.setBlock(i + 4, j + 2, k + 6, Blocks.obsidian, 0, 2);
		world.setBlock(i + 5, j + 2, k + 6, NovaCraftBlocks.sculk_vein, 5, 2);
		world.setBlock(i + 4, j + 3, k + 2, Blocks.obsidian, 0, 2);
		world.setBlock(i + 4, j + 3, k + 6, Blocks.obsidian, 0, 2);
		world.setBlock(i + 4, j + 4, k + 3, Blocks.obsidian, 0, 2);
		world.setBlock(i + 3, j + 4, k + 6, PlaceDeepslateBrickWall, 1, 2);
		world.setBlock(i + 4, j + 4, k + 6, Blocks.obsidian, 0, 2);
		
		world.setBlock(i + 3, j + 3, k + 6, PlaceSoulLantern, 1, 2);
		world.setBlock(i + 3, j + 1, k + 1, Blocks.chest, 4, 2);		
		TileEntityChest chest = (TileEntityChest) world.getTileEntity(i + 3, j + 1, k + 1);

		for (int slot = 0; slot < 3 + random.nextInt(20); slot++) {
			chest.setInventorySlotContents(random.nextInt(chest.getSizeInventory()), this.getNetherPortalLoot(random));
		}
    	
    	return true;
    }
    
    private ItemStack getNetherPortalLoot(Random random) {
		int item = random.nextInt(15);
		switch (item) {
			case 0:
				return new ItemStack(Items.glowstone_dust, random.nextInt(2) + 1);
			case 1:
				return new ItemStack(Blocks.netherrack, random.nextInt(8) + 3);
			case 2:
				return new ItemStack(NovaCraftItems.potion_fire_resistance_extended);
			case 3:
				return new ItemStack(Items.flint, random.nextInt(2) + 1);
			case 4:
				return new ItemStack(Items.lava_bucket);
			case 5:
				return new ItemStack(Items.magma_cream, random.nextInt(3) + 1);
			case 6:
				return new ItemStack(Items.magma_cream, random.nextInt(2) + 1);
			case 7: {
				if (random.nextInt(2) == 1) {
					return new ItemStack(NovaCraftItems.phoenix_feather, random.nextInt(2) + 1);
				}

				break;
			}
			default: {
				return new ItemStack(Blocks.netherrack, random.nextInt(9) + 2);
			}
		}
		return new ItemStack(Blocks.netherrack, random.nextInt(9) + 2);
	}

}
