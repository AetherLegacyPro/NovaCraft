package com.NovaCraft.world.ancient_city;

import net.minecraft.world.gen.feature.*;
import net.minecraft.block.*;
import net.minecraft.world.*;
import java.util.*;

import com.NovaCraft.config.Configs;
import com.NovaCraft.registry.OtherModBlocks;
import com.NovaCraftBlocks.NovaCraftBlocks;

import cpw.mods.fml.common.Loader;
import net.minecraft.init.*;

public class AncientCitySmallHouseGen2 extends WorldGenerator
{
	public AncientCitySmallHouseGen2() {

	}
	
	private static final Block cobbled_deepslate = OtherModBlocks.cobbled_deepslate;
	private static final Block deepslate = OtherModBlocks.deepslate;
	private static final Block sculk_block = NovaCraftBlocks.sculk_block;
	private static final Block soul_lantern = OtherModBlocks.soul_lantern; //1
	private static final Block SoulLantern = OtherModBlocks.SoulLantern;
	private static final Block soul_sand = Blocks.netherrack;
	private static final Block blue_ice = OtherModBlocks.blue_ice;
	private static final Block basalt_nether = OtherModBlocks.Basalt; //netherlicious
	private static final Block basalt_et = OtherModBlocks.basalt; //et futurum requiem
	private static final Block iron_trapdoor = OtherModBlocks.iron_trapdoor;
	
	private static final Block polished_deepslate = OtherModBlocks.polished_deepslate;
	private static final Block deepslate_brick_slab = OtherModBlocks.deepslate_brick_slab;
	private static final Block deepslate_tile_stairs = OtherModBlocks.deepslate_tile_stairs;
	private static final Block deepslate_brick_stairs = OtherModBlocks.deepslate_brick_stairs;
	private static final Block polished_deepslate_stairs = OtherModBlocks.polished_deepslate_stairs;
	private static final Block deepslate_wall = OtherModBlocks.deepslate_wall;
	private static final Block fence_dark_oak = OtherModBlocks.fence_dark_oak;	
	private static final Block deepslate_bricks = OtherModBlocks.deepslate_bricks;
	private static final Block cracked_deepslate_bricks = OtherModBlocks.deepslate_bricks;
	private static final Block deepslate_tiles = OtherModBlocks.deepslate_bricks;
	private static final Block cracked_deepslate_tiles = OtherModBlocks.deepslate_bricks;
	private static final Block chiseled_deepslate = OtherModBlocks.deepslate_bricks;
	private static final Block deepslate_brick_wall = OtherModBlocks.deepslate_brick_wall;
	
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
	private Block PlaceBlueIce;
	private Block PlaceIronTrapdoor;
	private Block PlaceBasalt;
	
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
	
	private Block determineIfBlueIceExists(World world, int x, int y, int z) {
        Block existingBlock = world.getBlock(x, y, z);

        if (Configs.disableBlueIceInAncientCity == true && (existingBlock == null || existingBlock != blue_ice)) {
            return Blocks.packed_ice;
        } else {
            return blue_ice;
        }
    }
	
	private Block determineIfIronTrapdoorExists(World world, int x, int y, int z) {
        Block existingBlock = world.getBlock(x, y, z);

        if (Configs.disableIronTrapdoorInAncientCity == true && (existingBlock == null || existingBlock != iron_trapdoor)) {
            return Blocks.trapdoor;
        } else {
            return iron_trapdoor;
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
	
	private Block determineIfBasaltExists(World world, int x, int y, int z) {
        Block existingBlock = world.getBlock(x, y, z);
        
        if (Configs.disableNetherliciousBasaltInAncientCity == true && Loader.isModLoaded("etfuturum") && (existingBlock == null || existingBlock != basalt_et)) {
    		return basalt_et;
        } else if (Loader.isModLoaded("netherlicious") && (existingBlock == null || existingBlock != basalt_nether)) {
        	return basalt_nether;
    	} else {
    		return NovaCraftBlocks.polished_vanite_bricks;
    	}
    }
    
    public boolean generate(final World world, final Random random, final int i, final int j, final int k) {
    	PlaceDeepslateBricks = determineIfDeepslateBricksExists(world, i + 1, j + 10, k + 1);
    	PlaceCrackedDeepslateBricks = determineIfCrackedDeepslateBricksExists(world, i + 8, j + 10, k + 1);
    	PlaceDeepslateTiles = determineIfDeepslateTilesExist(world, i + 0, j + 11, k + 0);
    	PlaceCrackedDeepslateTiles = determineIfCrackedDeepslateTilesExist(world, i + 1, j + 11, k + 0);
    	
    	PlaceDeepslateTileStairs = determineIfDeepslateTileStairsExists(world, i + 0, j + 12, k + 1);
    	PlaceSoulLantern = determineIfSoulLanternExists(world, i + 4, j + 10, k + 3);
    	
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
		world.setBlock(i + 0, j + 10, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 10, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 10, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 10, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 10, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 10, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 10, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 10, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 10, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 10, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 10, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 10, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 10, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 10, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 10, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 10, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 10, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 10, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 10, k + 1, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 2, j + 10, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 10, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 10, k + 1, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 5, j + 10, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 10, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 10, k + 1, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 8, j + 10, k + 1, PlaceCrackedDeepslateBricks, 1, 2);
		world.setBlock(i + 9, j + 10, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 10, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 10, k + 1, PlaceCrackedDeepslateBricks, 1, 2);
		world.setBlock(i + 12, j + 10, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 10, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 10, k + 1, PlaceCrackedDeepslateBricks, 1, 2);
		world.setBlock(i + 15, j + 10, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 10, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 10, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 10, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 10, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 10, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 10, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 10, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 10, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 10, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 10, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 10, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 10, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 10, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 10, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 10, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 10, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 10, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 10, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 10, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 10, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 10, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 10, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 10, k + 3, PlaceSoulLantern, 0, 2);
		world.setBlock(i + 5, j + 10, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 10, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 10, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 10, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 10, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 10, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 10, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 10, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 10, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 10, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 10, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 10, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 10, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 10, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 10, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 10, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 10, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 10, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 10, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 10, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 10, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 10, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 10, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 10, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 10, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 10, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 10, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 10, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 10, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 10, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 10, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 10, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 10, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 10, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 10, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 10, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 10, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 10, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 10, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 10, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 10, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 10, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 10, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 10, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 10, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 10, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 10, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 10, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 10, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 10, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 10, k + 6, PlaceSoulLantern, 0, 2);
		world.setBlock(i + 5, j + 10, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 10, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 10, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 10, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 10, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 10, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 10, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 10, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 10, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 10, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 10, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 10, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 10, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 10, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 10, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 10, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 10, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 10, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 10, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 10, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 10, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 10, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 10, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 10, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 10, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 10, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 10, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 10, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 10, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 10, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 10, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 10, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 10, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 10, k + 8, PlaceSoulLantern, 0, 2);
		world.setBlock(i + 5, j + 10, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 10, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 10, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 10, k + 8, PlaceSoulLantern, 0, 2);
		world.setBlock(i + 9, j + 10, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 10, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 10, k + 8, PlaceSoulLantern, 0, 2);
		world.setBlock(i + 12, j + 10, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 10, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 10, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 10, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 10, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 10, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 10, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 10, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 10, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 10, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 10, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 10, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 10, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 10, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 10, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 10, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 10, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 10, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 10, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 10, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 10, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 10, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 10, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 10, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 10, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 10, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 10, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 10, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 10, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 10, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 10, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 10, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 10, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 10, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 10, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 10, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 10, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 10, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 10, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 10, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 10, k + 11, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 2, j + 10, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 10, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 10, k + 11, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 5, j + 10, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 10, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 10, k + 11, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 8, j + 10, k + 11, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 9, j + 10, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 10, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 10, k + 11, PlaceCrackedDeepslateBricks, 1, 2);
		world.setBlock(i + 12, j + 10, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 10, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 10, k + 11, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 15, j + 10, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 10, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 10, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 10, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 10, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 10, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 10, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 10, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 10, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 10, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 10, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 10, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 10, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 10, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 10, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 10, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 10, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 10, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 10, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 10, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 10, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 10, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 10, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 10, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 10, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 10, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 10, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 10, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 10, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 10, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 10, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 10, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 10, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 10, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 10, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 10, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 11, k + 0, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 1, j + 11, k + 0, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 2, j + 11, k + 0, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 3, j + 11, k + 0, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 4, j + 11, k + 0, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 5, j + 11, k + 0, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 6, j + 11, k + 0, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 7, j + 11, k + 0, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 8, j + 11, k + 0, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 9, j + 11, k + 0, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 10, j + 11, k + 0, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 11, j + 11, k + 0, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 12, j + 11, k + 0, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 13, j + 11, k + 0, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 14, j + 11, k + 0, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 15, j + 11, k + 0, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 16, j + 11, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 11, k + 1, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 1, j + 11, k + 1, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 2, j + 11, k + 1, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 3, j + 11, k + 1, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 4, j + 11, k + 1, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 5, j + 11, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 11, k + 1, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 7, j + 11, k + 1, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 8, j + 11, k + 1, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 9, j + 11, k + 1, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 10, j + 11, k + 1, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 11, j + 11, k + 1, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 12, j + 11, k + 1, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 13, j + 11, k + 1, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 14, j + 11, k + 1, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 15, j + 11, k + 1, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 16, j + 11, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 11, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 11, k + 2, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 2, j + 11, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 11, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 11, k + 2, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 5, j + 11, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 11, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 11, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 11, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 11, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 11, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 11, k + 2, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 12, j + 11, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 11, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 11, k + 2, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 15, j + 11, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 11, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 11, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 11, k + 3, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 2, j + 11, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 11, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 11, k + 3, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 5, j + 11, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 11, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 11, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 11, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 11, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 11, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 11, k + 3, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 12, j + 11, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 11, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 11, k + 3, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 15, j + 11, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 11, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 11, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 11, k + 4, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 2, j + 11, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 11, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 11, k + 4, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 5, j + 11, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 11, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 11, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 11, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 11, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 11, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 11, k + 4, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 12, j + 11, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 11, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 11, k + 4, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 15, j + 11, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 11, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 11, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 11, k + 5, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 2, j + 11, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 11, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 11, k + 5, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 5, j + 11, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 11, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 11, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 11, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 11, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 11, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 11, k + 5, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 12, j + 11, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 11, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 11, k + 5, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 15, j + 11, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 11, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 11, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 11, k + 6, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 2, j + 11, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 11, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 11, k + 6, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 5, j + 11, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 11, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 11, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 11, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 11, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 11, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 11, k + 6, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 12, j + 11, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 11, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 11, k + 6, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 15, j + 11, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 11, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 11, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 11, k + 7, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 2, j + 11, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 11, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 11, k + 7, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 5, j + 11, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 11, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 11, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 11, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 11, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 11, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 11, k + 7, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 12, j + 11, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 11, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 11, k + 7, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 15, j + 11, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 11, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 11, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 11, k + 8, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 2, j + 11, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 11, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 11, k + 8, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 5, j + 11, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 11, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 11, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 11, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 11, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 11, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 11, k + 8, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 12, j + 11, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 11, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 11, k + 8, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 15, j + 11, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 11, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 11, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 11, k + 9, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 2, j + 11, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 11, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 11, k + 9, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 5, j + 11, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 11, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 11, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 11, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 11, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 11, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 11, k + 9, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 12, j + 11, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 11, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 11, k + 9, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 15, j + 11, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 11, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 11, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 11, k + 10, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 2, j + 11, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 11, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 11, k + 10, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 5, j + 11, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 11, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 11, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 11, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 11, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 11, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 11, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 11, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 11, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 11, k + 10, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 15, j + 11, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 11, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 11, k + 11, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 1, j + 11, k + 11, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 2, j + 11, k + 11, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 3, j + 11, k + 11, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 4, j + 11, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 11, k + 11, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 6, j + 11, k + 11, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 7, j + 11, k + 11, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 8, j + 11, k + 11, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 9, j + 11, k + 11, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 10, j + 11, k + 11, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 11, j + 11, k + 11, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 12, j + 11, k + 11, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 13, j + 11, k + 11, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 14, j + 11, k + 11, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 15, j + 11, k + 11, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 16, j + 11, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 11, k + 12, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 1, j + 11, k + 12, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 2, j + 11, k + 12, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 3, j + 11, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 11, k + 12, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 5, j + 11, k + 12, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 6, j + 11, k + 12, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 7, j + 11, k + 12, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 8, j + 11, k + 12, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 9, j + 11, k + 12, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 10, j + 11, k + 12, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 11, j + 11, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 11, k + 12, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 13, j + 11, k + 12, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 14, j + 11, k + 12, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 15, j + 11, k + 12, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 16, j + 11, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 11, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 11, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 11, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 11, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 11, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 11, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 11, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 11, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 11, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 11, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 11, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 11, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 11, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 11, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 11, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 11, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 11, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 12, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 12, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 12, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 12, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 12, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 12, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 12, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 12, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 12, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 12, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 12, k + 0, NovaCraftBlocks.sculk_vein, 1, 2);
		world.setBlock(i + 11, j + 12, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 12, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 12, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 12, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 12, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 12, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 12, k + 1, PlaceDeepslateTileStairs, 2, 2);
		world.setBlock(i + 1, j + 12, k + 1, PlaceDeepslateTileStairs, 2, 2);
		world.setBlock(i + 2, j + 12, k + 1, PlaceDeepslateTileStairs, 2, 2);
		world.setBlock(i + 3, j + 12, k + 1, PlaceDeepslateTileStairs, 2, 2);
		world.setBlock(i + 4, j + 12, k + 1, PlaceDeepslateTileStairs, 2, 2);
		world.setBlock(i + 5, j + 12, k + 1, PlaceDeepslateTileStairs, 2, 2);
		world.setBlock(i + 6, j + 12, k + 1, PlaceDeepslateTileStairs, 2, 2);
		world.setBlock(i + 7, j + 12, k + 1, PlaceDeepslateTileStairs, 2, 2);
		world.setBlock(i + 8, j + 12, k + 1, PlaceDeepslateTileStairs, 2, 2);
		world.setBlock(i + 9, j + 12, k + 1, PlaceDeepslateTileStairs, 2, 2);
		world.setBlock(i + 10, j + 12, k + 1, PlaceDeepslateTileStairs, 2, 2);
		world.setBlock(i + 11, j + 12, k + 1, PlaceDeepslateTileStairs, 2, 2);
		world.setBlock(i + 12, j + 12, k + 1, PlaceDeepslateTileStairs, 2, 2);
		world.setBlock(i + 13, j + 12, k + 1, PlaceDeepslateTileStairs, 2, 2);
		world.setBlock(i + 14, j + 12, k + 1, PlaceDeepslateTileStairs, 2, 2);
		world.setBlock(i + 15, j + 12, k + 1, PlaceDeepslateTileStairs, 2, 2);
		world.setBlock(i + 16, j + 12, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 12, k + 2, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 1, j + 12, k + 2, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 2, j + 12, k + 2, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 3, j + 12, k + 2, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 4, j + 12, k + 2, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 5, j + 12, k + 2, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 6, j + 12, k + 2, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 7, j + 12, k + 2, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 8, j + 12, k + 2, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 9, j + 12, k + 2, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 10, j + 12, k + 2, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 11, j + 12, k + 2, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 12, j + 12, k + 2, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 13, j + 12, k + 2, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 14, j + 12, k + 2, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 15, j + 12, k + 2, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 16, j + 12, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 12, k + 3, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 1, j + 12, k + 3, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 2, j + 12, k + 3, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 3, j + 12, k + 3, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 4, j + 12, k + 3, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 5, j + 12, k + 3, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 6, j + 12, k + 3, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 7, j + 12, k + 3, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 8, j + 12, k + 3, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 9, j + 12, k + 3, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 10, j + 12, k + 3, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 11, j + 12, k + 3, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 12, j + 12, k + 3, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 13, j + 12, k + 3, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 14, j + 12, k + 3, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 15, j + 12, k + 3, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 16, j + 12, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 12, k + 4, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 1, j + 12, k + 4, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 2, j + 12, k + 4, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 3, j + 12, k + 4, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 4, j + 12, k + 4, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 5, j + 12, k + 4, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 6, j + 12, k + 4, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 7, j + 12, k + 4, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 8, j + 12, k + 4, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 9, j + 12, k + 4, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 10, j + 12, k + 4, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 11, j + 12, k + 4, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 12, j + 12, k + 4, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 13, j + 12, k + 4, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 14, j + 12, k + 4, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 15, j + 12, k + 4, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 16, j + 12, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 12, k + 5, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 1, j + 12, k + 5, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 2, j + 12, k + 5, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 3, j + 12, k + 5, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 4, j + 12, k + 5, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 5, j + 12, k + 5, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 6, j + 12, k + 5, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 7, j + 12, k + 5, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 8, j + 12, k + 5, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 9, j + 12, k + 5, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 10, j + 12, k + 5, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 11, j + 12, k + 5, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 12, j + 12, k + 5, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 13, j + 12, k + 5, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 14, j + 12, k + 5, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 15, j + 12, k + 5, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 16, j + 12, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 12, k + 6, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 1, j + 12, k + 6, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 2, j + 12, k + 6, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 3, j + 12, k + 6, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 4, j + 12, k + 6, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 5, j + 12, k + 6, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 6, j + 12, k + 6, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 7, j + 12, k + 6, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 8, j + 12, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 12, k + 6, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 10, j + 12, k + 6, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 11, j + 12, k + 6, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 12, j + 12, k + 6, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 13, j + 12, k + 6, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 14, j + 12, k + 6, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 15, j + 12, k + 6, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 16, j + 12, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 12, k + 7, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 1, j + 12, k + 7, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 2, j + 12, k + 7, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 3, j + 12, k + 7, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 4, j + 12, k + 7, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 5, j + 12, k + 7, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 6, j + 12, k + 7, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 7, j + 12, k + 7, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 8, j + 12, k + 7, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 9, j + 12, k + 7, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 10, j + 12, k + 7, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 11, j + 12, k + 7, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 12, j + 12, k + 7, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 13, j + 12, k + 7, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 14, j + 12, k + 7, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 15, j + 12, k + 7, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 16, j + 12, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 12, k + 8, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 1, j + 12, k + 8, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 2, j + 12, k + 8, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 3, j + 12, k + 8, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 4, j + 12, k + 8, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 5, j + 12, k + 8, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 6, j + 12, k + 8, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 7, j + 12, k + 8, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 8, j + 12, k + 8, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 9, j + 12, k + 8, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 10, j + 12, k + 8, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 11, j + 12, k + 8, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 12, j + 12, k + 8, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 13, j + 12, k + 8, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 14, j + 12, k + 8, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 15, j + 12, k + 8, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 16, j + 12, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 12, k + 9, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 1, j + 12, k + 9, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 2, j + 12, k + 9, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 3, j + 12, k + 9, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 4, j + 12, k + 9, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 5, j + 12, k + 9, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 6, j + 12, k + 9, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 7, j + 12, k + 9, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 8, j + 12, k + 9, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 9, j + 12, k + 9, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 10, j + 12, k + 9, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 11, j + 12, k + 9, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 12, j + 12, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 12, k + 9, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 14, j + 12, k + 9, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 15, j + 12, k + 9, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 16, j + 12, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 12, k + 10, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 1, j + 12, k + 10, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 2, j + 12, k + 10, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 3, j + 12, k + 10, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 4, j + 12, k + 10, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 5, j + 12, k + 10, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 6, j + 12, k + 10, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 7, j + 12, k + 10, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 8, j + 12, k + 10, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 9, j + 12, k + 10, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 10, j + 12, k + 10, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 11, j + 12, k + 10, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 12, j + 12, k + 10, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 13, j + 12, k + 10, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 14, j + 12, k + 10, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 15, j + 12, k + 10, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 16, j + 12, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 12, k + 11, PlaceDeepslateTileStairs, 3, 2);
		world.setBlock(i + 1, j + 12, k + 11, PlaceDeepslateTileStairs, 3, 2);
		world.setBlock(i + 2, j + 12, k + 11, PlaceDeepslateTileStairs, 3, 2);
		world.setBlock(i + 3, j + 12, k + 11, PlaceDeepslateTileStairs, 3, 2);
		world.setBlock(i + 4, j + 12, k + 11, PlaceDeepslateTileStairs, 3, 2);
		world.setBlock(i + 5, j + 12, k + 11, PlaceDeepslateTileStairs, 3, 2);
		world.setBlock(i + 6, j + 12, k + 11, PlaceDeepslateTileStairs, 3, 2);
		world.setBlock(i + 7, j + 12, k + 11, PlaceDeepslateTileStairs, 3, 2);
		world.setBlock(i + 8, j + 12, k + 11, PlaceDeepslateTileStairs, 3, 2);
		world.setBlock(i + 9, j + 12, k + 11, PlaceDeepslateTileStairs, 3, 2);
		world.setBlock(i + 10, j + 12, k + 11, PlaceDeepslateTileStairs, 3, 2);
		world.setBlock(i + 11, j + 12, k + 11, PlaceDeepslateTileStairs, 3, 2);
		world.setBlock(i + 12, j + 12, k + 11, PlaceDeepslateTileStairs, 3, 2);
		world.setBlock(i + 13, j + 12, k + 11, PlaceDeepslateTileStairs, 3, 2);
		world.setBlock(i + 14, j + 12, k + 11, PlaceDeepslateTileStairs, 3, 2);
		world.setBlock(i + 15, j + 12, k + 11, PlaceDeepslateTileStairs, 3, 2);
		world.setBlock(i + 16, j + 12, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 12, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 12, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 12, k + 12, NovaCraftBlocks.sculk_vein, 1, 2);
		world.setBlock(i + 3, j + 12, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 12, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 12, k + 12, NovaCraftBlocks.sculk_vein, 1, 2);
		world.setBlock(i + 6, j + 12, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 12, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 12, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 12, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 12, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 12, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 12, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 12, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 12, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 12, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 12, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 12, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 12, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 12, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 12, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 12, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 12, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 12, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 12, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 12, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 12, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 12, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 12, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 12, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 12, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 12, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 12, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 12, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 13, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 13, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 13, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 13, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 13, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 13, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 13, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 13, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 13, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 13, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 13, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 13, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 13, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 13, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 13, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 13, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 13, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 13, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 13, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 13, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 13, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 13, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 13, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 13, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 13, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 13, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 13, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 13, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 13, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 13, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 13, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 13, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 13, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 13, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 13, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 13, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 13, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 13, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 13, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 13, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 13, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 13, k + 2, NovaCraftBlocks.sculk_vein, 1, 2);
		world.setBlock(i + 8, j + 13, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 13, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 13, k + 2, NovaCraftBlocks.sculk_vein, 1, 2);
		world.setBlock(i + 11, j + 13, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 13, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 13, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 13, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 13, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 13, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 13, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 13, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 13, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 13, k + 3, NovaCraftBlocks.sculk_vein, 1, 2);
		world.setBlock(i + 4, j + 13, k + 3, NovaCraftBlocks.sculk_vein, 1, 2);
		world.setBlock(i + 5, j + 13, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 13, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 13, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 13, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 13, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 13, k + 3, NovaCraftBlocks.sculk_vein, 1, 2);
		world.setBlock(i + 11, j + 13, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 13, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 13, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 13, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 13, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 13, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 13, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 13, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 13, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 13, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 13, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 13, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 13, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 13, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 13, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 13, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 13, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 13, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 13, k + 4, NovaCraftBlocks.sculk_vein, 1, 2);
		world.setBlock(i + 13, j + 13, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 13, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 13, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 13, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 13, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 13, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 13, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 13, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 13, k + 5, NovaCraftBlocks.sculk_spike, 1, 2);
		world.setBlock(i + 5, j + 13, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 13, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 13, k + 5, NovaCraftBlocks.sculk_vein, 1, 2);
		world.setBlock(i + 8, j + 13, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 13, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 13, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 13, k + 5, NovaCraftBlocks.sculk_vein, 1, 2);
		world.setBlock(i + 12, j + 13, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 13, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 13, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 13, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 13, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 13, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 13, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 13, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 13, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 13, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 13, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 13, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 13, k + 6, NovaCraftBlocks.sculk_vein, 1, 2);
		world.setBlock(i + 8, j + 13, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 13, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 13, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 13, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 13, k + 6, NovaCraftBlocks.sculk_vein, 1, 2);
		world.setBlock(i + 13, j + 13, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 13, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 13, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 13, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 13, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 13, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 13, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 13, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 13, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 13, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 13, k + 7, NovaCraftBlocks.sculk_vein, 1, 2);
		world.setBlock(i + 7, j + 13, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 13, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 13, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 13, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 13, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 13, k + 7, NovaCraftBlocks.sculk_spike, 1, 2);
		world.setBlock(i + 13, j + 13, k + 7, NovaCraftBlocks.sculk_vein, 1, 2);
		world.setBlock(i + 14, j + 13, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 13, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 13, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 13, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 13, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 13, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 13, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 13, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 13, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 13, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 13, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 13, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 13, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 13, k + 8, NovaCraftBlocks.sculk_vein, 1, 2);
		world.setBlock(i + 11, j + 13, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 13, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 13, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 13, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 13, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 13, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 13, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 13, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 13, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 13, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 13, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 13, k + 9, NovaCraftBlocks.sculk_spike, 1, 2);
		world.setBlock(i + 6, j + 13, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 13, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 13, k + 9, NovaCraftBlocks.sculk_vein, 1, 2);
		world.setBlock(i + 9, j + 13, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 13, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 13, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 13, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 13, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 13, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 13, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 13, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 13, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 13, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 13, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 13, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 13, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 13, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 13, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 13, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 13, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 13, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 13, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 13, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 13, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 13, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 13, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 13, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 13, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 13, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 13, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 13, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 13, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 13, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 13, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 13, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 13, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 13, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 13, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 13, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 13, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 12, j + 13, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 13, j + 13, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 14, j + 13, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 15, j + 13, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 13, k + 11, Blocks.air, 0, 2);
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
		world.setBlock(i + 15, j + 13, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 13, k + 12, Blocks.air, 0, 2);
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
		world.setBlock(i + 15, j + 13, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 16, j + 13, k + 13, Blocks.air, 0, 2);
    	
    	return true;
    }

}
