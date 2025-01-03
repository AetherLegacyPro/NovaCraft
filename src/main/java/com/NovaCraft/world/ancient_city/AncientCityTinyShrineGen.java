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

public class AncientCityTinyShrineGen extends WorldGenerator
{
	public AncientCityTinyShrineGen() {

	}
	
	private static final Block cobbled_deepslate = OtherModBlocks.cobbled_deepslate;
	private static final Block deepslate = OtherModBlocks.deepslate;
	private static final Block sculk_block = NovaCraftBlocks.sculk_block;
	private static final Block soul_lantern = OtherModBlocks.soul_lantern; //1
	private static final Block SoulLantern = OtherModBlocks.SoulLantern;
	private static final Block soul_sand = Blocks.soul_sand;
	private static final Block basalt_nether = OtherModBlocks.Basalt; //netherlicious
	private static final Block basalt_et = OtherModBlocks.basalt; //et futurum requiem	
	private static final Block smooth_basalt_nether = OtherModBlocks.BasaltBricks; //netherlicious 6
	private static final Block smooth_basalt_et = OtherModBlocks.smooth_basalt; //et futurum requiem
	
	private static final Block polished_deepslate = OtherModBlocks.polished_deepslate;
	private static final Block deepslate_brick_slab = OtherModBlocks.deepslate_brick_slab;
	private static final Block deepslate_tile_stairs = OtherModBlocks.deepslate_tile_stairs;
	private static final Block deepslate_brick_stairs = OtherModBlocks.deepslate_brick_stairs;
	private static final Block polished_deepslate_stairs = OtherModBlocks.polished_deepslate_stairs;
	private static final Block cobbled_deepslate_stairs = OtherModBlocks.cobbled_deepslate_stairs;
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
	
	private Block determineIfCobbledDeepslateStairsExists(World world, int x, int y, int z) {
        Block existingBlock = world.getBlock(x, y, z);

        if (Configs.disableCobbledDeepslateInAncientCity == true && (existingBlock == null || existingBlock != cobbled_deepslate_stairs)) {
            return NovaCraftBlocks.cobbled_grimstone_stairs;
        } else {
            return cobbled_deepslate_stairs;
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
	
	private Block determineIfShouldPlaceSoulSand(World world, int x, int y, int z) {
        Block existingBlock = world.getBlock(x, y, z);

        if (Configs.disableEtFuturumSoulFireInAncientCity == true && Loader.isModLoaded("netherlicious") && (existingBlock == null || existingBlock != soul_sand)) {
    		return soul_sand;
        } else if (Loader.isModLoaded("etfuturum") && (existingBlock == null || existingBlock != soul_sand)) {
        	 return soul_sand;	
         }	else {
        	 return Blocks.netherrack;	     	
        }
    }
	
	private Block determineIfSmoothBasaltExists(World world, int x, int y, int z) {
        Block existingBlock = world.getBlock(x, y, z);
        
        if (Configs.disableNetherliciousSmoothBasaltInAncientCity == true && Loader.isModLoaded("etfuturum") && (existingBlock == null || existingBlock != smooth_basalt_et)) {
    		return smooth_basalt_et;
        } else if (Loader.isModLoaded("netherlicious") && (existingBlock == null || existingBlock != smooth_basalt_nether)) {
        	return smooth_basalt_nether;
    	} else {
    		return NovaCraftBlocks.polished_vanite_bricks;
    	}
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
