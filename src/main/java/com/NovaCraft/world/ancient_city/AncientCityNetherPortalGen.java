package com.NovaCraft.world.ancient_city;

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
	
	private static final Block cobbled_deepslate = OtherModBlocks.cobbled_deepslate;
	private static final Block deepslate = OtherModBlocks.deepslate;
	private static final Block sculk_block = NovaCraftBlocks.sculk_block;
	private static final Block soul_lantern = OtherModBlocks.soul_lantern; //1
	private static final Block SoulLantern = OtherModBlocks.SoulLantern;
	private static final Block soul_sand = Blocks.netherrack;
	
	private static final Block polished_deepslate = OtherModBlocks.polished_deepslate;
	private static final Block deepslate_brick_slab = OtherModBlocks.deepslate_brick_slab;
	private static final Block deepslate_tile_stairs = OtherModBlocks.deepslate_tile_stairs;
	private static final Block deepslate_brick_stairs = OtherModBlocks.deepslate_brick_stairs;
	private static final Block polished_deepslate_stairs = OtherModBlocks.polished_deepslate_stairs;
	private static final Block deepslate_wall = OtherModBlocks.deepslate_wall;
	private static final Block deepslate_brick_wall = OtherModBlocks.deepslate_brick_wall;
	private static final Block fence_dark_oak = OtherModBlocks.fence_dark_oak;	
	private static final Block deepslate_bricks = OtherModBlocks.deepslate_bricks;
	private static final Block cracked_deepslate_bricks = OtherModBlocks.deepslate_bricks;
	private static final Block deepslate_tiles = OtherModBlocks.deepslate_bricks;
	private static final Block cracked_deepslate_tiles = OtherModBlocks.deepslate_bricks;
	private static final Block chiseled_deepslate = OtherModBlocks.deepslate_bricks;
	
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
	
	private Block PlaceDeepslateBrickSlab;
	private Block PlaceDeepslateTileStairs;
	private Block PlaceDeepslateBrickStairs;
	private Block PlacePolishedDeepslateStairs;
	private Block PlaceDeepslateWall;
	private Block PlaceDeepslateBrickWall;
	
	private Block determineIfDarkOakFenceExists(World world, int x, int y, int z) {
        Block existingBlock = world.getBlock(x, y, z);

        if (Configs.disableDarkOakFenceInAncientCity == true && (existingBlock == null || existingBlock != fence_dark_oak)) {
            return Blocks.fence;
        } else {
            return fence_dark_oak;
        }
    }
	
	private Block determineIfCobbledDeepslateExists(World world, int x, int y, int z) {
        Block existingBlock = world.getBlock(x, y, z);

        if (Configs.disableCobbledDeepslateInAncientCity == true && (existingBlock == null || existingBlock != cobbled_deepslate)) {
            return NovaCraftBlocks.cobbled_grimstone; // Fallback to grimstone
        } else {
            return cobbled_deepslate; // Default to deepslate
        }
    }
	
	private Block determineIfDeepslateExists(World world, int x, int y, int z) {
        Block existingBlock = world.getBlock(x, y, z);

        if (Configs.disableDeepslateInAncientCity == true && (existingBlock == null || existingBlock != deepslate)) {
            return NovaCraftBlocks.grimstone; 
        } else {
            return deepslate;
        }
    }
	
	private Block determineIfDeepslateBricksExists(World world, int x, int y, int z) {
        Block existingBlock = world.getBlock(x, y, z);

        if (Configs.disableDeepslateBricksInAncientCity == true && (existingBlock == null || existingBlock != deepslate_bricks)) {
            return NovaCraftBlocks.grimstone_bricks;
        } else {
            return deepslate_bricks;
        }
    }
	
	private Block determineIfCrackedDeepslateBricksExists(World world, int x, int y, int z) {
        Block existingBlock = world.getBlock(x, y, z);

        if (Configs.disableDeepslateBricksInAncientCity == true && (existingBlock == null || existingBlock != cracked_deepslate_bricks)) {
            return NovaCraftBlocks.cracked_grimstone_bricks;
        } else {
            return cracked_deepslate_bricks;
        }
    }
	
	private Block determineIfDeepslateTilesExist(World world, int x, int y, int z) {
        Block existingBlock = world.getBlock(x, y, z);

        if (Configs.disableDeepslateBricksInAncientCity == true && (existingBlock == null || existingBlock != deepslate_tiles)) {
            return NovaCraftBlocks.grimstone_tiles;
        } else {
            return deepslate_tiles;
        }
    }
	
	private Block determineIfCrackedDeepslateTilesExist(World world, int x, int y, int z) {
        Block existingBlock = world.getBlock(x, y, z);

        if (Configs.disableDeepslateBricksInAncientCity == true && (existingBlock == null || existingBlock != cracked_deepslate_tiles)) {
            return NovaCraftBlocks.cracked_grimstone_tiles;
        } else {
            return cracked_deepslate_tiles;
        }
    }
	
	private Block determineIfPolishedDeepslateExists(World world, int x, int y, int z) {
        Block existingBlock = world.getBlock(x, y, z);

        if (Configs.disableDeepslateBricksInAncientCity == true && (existingBlock == null || existingBlock != polished_deepslate)) {
            return NovaCraftBlocks.polished_grimstone;
        } else {
            return polished_deepslate;
        }
    }
	
	private Block determineIfChiseledDeepslateExist(World world, int x, int y, int z) {
        Block existingBlock = world.getBlock(x, y, z);

        if (Configs.disableDeepslateBricksInAncientCity == true && (existingBlock == null || existingBlock != chiseled_deepslate)) {
            return NovaCraftBlocks.chiseled_grimstone;
        } else {
            return chiseled_deepslate;
        }
    }
	
	
	//Slabs, Walls, and Stairs
	private Block determineIfDeepslateTileStairsExists(World world, int x, int y, int z) {
        Block existingBlock = world.getBlock(x, y, z);

        if (Configs.disableDeepslateBricksInAncientCity == true && (existingBlock == null || existingBlock != deepslate_tile_stairs)) {
            return NovaCraftBlocks.grimstone_tiled_stairs;
        } else {
            return deepslate_tile_stairs;
        }
    }
	
	private Block determineIfDeepslateBrickStairsExists(World world, int x, int y, int z) {
        Block existingBlock = world.getBlock(x, y, z);

        if (Configs.disableDeepslateBricksInAncientCity == true && (existingBlock == null || existingBlock != deepslate_brick_stairs)) {
            return NovaCraftBlocks.grimstone_brick_stairs;
        } else {
            return deepslate_brick_stairs;
        }
    }
	
	private Block determineIfPolishedDeepslateStairsExists(World world, int x, int y, int z) {
        Block existingBlock = world.getBlock(x, y, z);

        if (Configs.disableDeepslateBricksInAncientCity == true && (existingBlock == null || existingBlock != polished_deepslate_stairs)) {
            return NovaCraftBlocks.grimstone_stairs;
        } else {
            return polished_deepslate_stairs;
        }
    }
	
	private Block determineIfDeepslateWallExists(World world, int x, int y, int z) {
        Block existingBlock = world.getBlock(x, y, z);

        if (Configs.disableDeepslateBricksInAncientCity == true && (existingBlock == null || existingBlock != deepslate_wall)) {
            return NovaCraftBlocks.cobbled_grimstone_wall;
        } else {
            return deepslate_wall;
        }
    }
	
	private Block determineIfDeepslateBrickWallExists(World world, int x, int y, int z) {
        Block existingBlock = world.getBlock(x, y, z);

        if (Configs.disableDeepslateBricksInAncientCity == true && (existingBlock == null || existingBlock != deepslate_brick_wall)) {
            return NovaCraftBlocks.grimstone_brick_wall;
        } else {
            return deepslate_brick_wall;
        }
    }
	
	private Block determineIfDeepslateSlabExists(World world, int x, int y, int z) {
        Block existingBlock = world.getBlock(x, y, z);

        if (Configs.disableDeepslateBricksInAncientCity == true && (existingBlock == null || existingBlock != deepslate_brick_slab)) {
            return NovaCraftBlocks.grimstone_brick_slab;
        } else {
            return deepslate_brick_slab;
        }
    }
	
	private Block determineIfSoulLanternExists(World world, int x, int y, int z) {
        Block existingBlock = world.getBlock(x, y, z);

        if (Configs.disableEtFuturumSoulLanternInAncientCity == true && Loader.isModLoaded("netherlicious") && (existingBlock == null || existingBlock != soul_lantern)) {
        		return SoulLantern;
        } else if (Loader.isModLoaded("etfuturum") && (existingBlock == null || existingBlock != SoulLantern)) {
            return soul_lantern;
        } else {
        	return Blocks.air;
        }
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
