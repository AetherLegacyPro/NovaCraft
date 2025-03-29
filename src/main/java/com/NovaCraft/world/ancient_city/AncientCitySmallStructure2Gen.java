package com.NovaCraft.world.ancient_city;

import net.minecraft.world.gen.feature.*;
import net.minecraft.block.*;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.world.*;
import java.util.*;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.config.Configs;
import com.NovaCraft.registry.OtherModBlocks;
import com.NovaCraft.registry.OtherModItems;
import com.NovaCraftBlocks.NovaCraftBlocks;

import cpw.mods.fml.common.Loader;
import net.minecraft.init.*;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.MathHelper;

public class AncientCitySmallStructure2Gen extends WorldGenerator
{
	public AncientCitySmallStructure2Gen() {

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
	
	private Block determineIfDeepslateSlabExists(World world, int x, int y, int z) {
        Block existingBlock = world.getBlock(x, y, z);

        if (Configs.disableDeepslateBricksInAncientCity == true && (existingBlock == null || existingBlock != deepslate_brick_slab)) {
            return NovaCraftBlocks.grimstone_brick_slab;
        } else {
            return deepslate_brick_slab;
        }
    }
    
    public boolean generate(final World world, final Random random, final int i, final int j, final int k) {
    	PlaceCobbledDeepslate = determineIfCobbledDeepslateExists(world, i + 1, j + 0, k + 2);
    	PlaceDeepslateBricks = determineIfDeepslateBricksExists(world, i + 3, j + 0, k + 1);
    	PlaceCrackedDeepslateBricks = determineIfCrackedDeepslateBricksExists(world, i + 2, j + 0, k + 1);
    	PlaceDeepslateTiles = determineIfDeepslateTilesExist(world, i + 9, j + 1, k + 2);
    	PlaceCrackedDeepslateTiles = determineIfCrackedDeepslateTilesExist(world, i + 9, j + 1, k + 1);
    	PlaceChiseledDeepslate = determineIfChiseledDeepslateExist(world, i + 9, j + 3, k + 10);
    	
    	world.setBlock(i + 0, j + 0, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 0, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 0, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 0, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 0, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 0, k + 0, NovaCraftBlocks.sculk_vein, 2, 2);
		world.setBlock(i + 6, j + 0, k + 0, NovaCraftBlocks.sculk_vein, 2, 2);
		world.setBlock(i + 7, j + 0, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 0, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 0, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 0, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 0, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 0, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 0, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 0, k + 1, PlaceCrackedDeepslateBricks, 1, 2);
		world.setBlock(i + 3, j + 0, k + 1, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 4, j + 0, k + 1, NovaCraftBlocks.sculk_vein, 2, 2);
		world.setBlock(i + 5, j + 0, k + 1, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 6, j + 0, k + 1, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 7, j + 0, k + 1, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 8, j + 0, k + 1, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 9, j + 0, k + 1, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 10, j + 0, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 0, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 0, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 0, k + 2, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 2, j + 0, k + 2, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 3, j + 0, k + 2, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 4, j + 0, k + 2, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 5, j + 0, k + 2, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 6, j + 0, k + 2, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 7, j + 0, k + 2, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 8, j + 0, k + 2, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 9, j + 0, k + 2, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 10, j + 0, k + 2, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 11, j + 0, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 0, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 0, k + 3, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 2, j + 0, k + 3, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 3, j + 0, k + 3, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 4, j + 0, k + 3, NovaCraftBlocks.sculk_vein, 3, 2);
		world.setBlock(i + 5, j + 0, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 0, k + 3, NovaCraftBlocks.sculk_vein, 3, 2);
		world.setBlock(i + 7, j + 0, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 0, k + 3, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 9, j + 0, k + 3, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 10, j + 0, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 0, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 0, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 0, k + 4, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 2, j + 0, k + 4, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 3, j + 0, k + 4, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 4, j + 0, k + 4, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 5, j + 0, k + 4, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 6, j + 0, k + 4, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 7, j + 0, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 0, k + 4, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 9, j + 0, k + 4, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 10, j + 0, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 0, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 0, k + 5, NovaCraftBlocks.sculk_vein, 4, 2);
		world.setBlock(i + 1, j + 0, k + 5, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 2, j + 0, k + 5, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 3, j + 0, k + 5, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 4, j + 0, k + 5, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 5, j + 0, k + 5, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 6, j + 0, k + 5, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 7, j + 0, k + 5, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 8, j + 0, k + 5, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 9, j + 0, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 0, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 0, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 0, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 0, k + 6, NovaCraftBlocks.sculk_vein, 3, 2);
		world.setBlock(i + 2, j + 0, k + 6, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 3, j + 0, k + 6, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 4, j + 0, k + 6, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 5, j + 0, k + 6, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 6, j + 0, k + 6, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 7, j + 0, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 0, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 0, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 0, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 0, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 0, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 0, k + 7, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 2, j + 0, k + 7, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 3, j + 0, k + 7, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 4, j + 0, k + 7, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 5, j + 0, k + 7, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 6, j + 0, k + 7, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 7, j + 0, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 0, k + 7, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 9, j + 0, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 0, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 0, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 0, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 0, k + 8, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 2, j + 0, k + 8, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 3, j + 0, k + 8, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 4, j + 0, k + 8, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 5, j + 0, k + 8, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 6, j + 0, k + 8, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 7, j + 0, k + 8, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 8, j + 0, k + 8, PlaceCrackedDeepslateBricks, 1, 2);
		world.setBlock(i + 9, j + 0, k + 8, NovaCraftBlocks.sculk_vein, 5, 2);
		world.setBlock(i + 10, j + 0, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 0, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 0, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 0, k + 9, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 2, j + 0, k + 9, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 3, j + 0, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 0, k + 9, NovaCraftBlocks.sculk_vein, 2, 2);
		world.setBlock(i + 5, j + 0, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 0, k + 9, NovaCraftBlocks.sculk_vein, 2, 2);
		world.setBlock(i + 7, j + 0, k + 9, NovaCraftBlocks.sculk_vein, 3, 2);
		world.setBlock(i + 8, j + 0, k + 9, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 9, j + 0, k + 9, PlaceCrackedDeepslateBricks, 1, 2);
		world.setBlock(i + 10, j + 0, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 0, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 0, k + 10, NovaCraftBlocks.sculk_vein, 4, 2);
		world.setBlock(i + 1, j + 0, k + 10, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 2, j + 0, k + 10, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 3, j + 0, k + 10, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 4, j + 0, k + 10, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 5, j + 0, k + 10, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 6, j + 0, k + 10, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 7, j + 0, k + 10, NovaCraftBlocks.sculk_vein, 2, 2);
		world.setBlock(i + 8, j + 0, k + 10, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 9, j + 0, k + 10, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 10, j + 0, k + 10, PlaceCrackedDeepslateBricks, 1, 2);
		world.setBlock(i + 11, j + 0, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 0, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 0, k + 11, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 2, j + 0, k + 11, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 3, j + 0, k + 11, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 4, j + 0, k + 11, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 5, j + 0, k + 11, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 6, j + 0, k + 11, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 7, j + 0, k + 11, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 8, j + 0, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 0, k + 11, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 10, j + 0, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 0, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 0, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 0, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 0, k + 12, NovaCraftBlocks.sculk_vein, 3, 2);
		world.setBlock(i + 3, j + 0, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 0, k + 12, NovaCraftBlocks.sculk_vein, 3, 2);
		world.setBlock(i + 5, j + 0, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 0, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 0, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 0, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 0, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 0, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 0, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 1, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 1, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 1, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 1, k + 0, NovaCraftBlocks.sculk_vein, 2, 2);
		world.setBlock(i + 4, j + 1, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 1, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 1, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 1, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 1, k + 0, NovaCraftBlocks.sculk_vein, 2, 2);
		world.setBlock(i + 9, j + 1, k + 0, NovaCraftBlocks.sculk_vein, 2, 2);
		world.setBlock(i + 10, j + 1, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 1, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 1, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 1, k + 1, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 2, j + 1, k + 1, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 3, j + 1, k + 1, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 4, j + 1, k + 1, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 5, j + 1, k + 1, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 6, j + 1, k + 1, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 7, j + 1, k + 1, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 8, j + 1, k + 1, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 9, j + 1, k + 1, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 10, j + 1, k + 1, NovaCraftBlocks.sculk_vein, 5, 2);
		world.setBlock(i + 11, j + 1, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 1, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 1, k + 2, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 2, j + 1, k + 2, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 3, j + 1, k + 2, NovaCraftBlocks.sculk_vein, 1, 2);
		world.setBlock(i + 4, j + 1, k + 2, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 5, j + 1, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 1, k + 2, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 7, j + 1, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 1, k + 2, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 9, j + 1, k + 2, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 10, j + 1, k + 2, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 11, j + 1, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 1, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 1, k + 3, PlaceCrackedDeepslateBricks, 1, 2);
		world.setBlock(i + 2, j + 1, k + 3, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 3, j + 1, k + 3, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 4, j + 1, k + 3, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 5, j + 1, k + 3, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 6, j + 1, k + 3, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 7, j + 1, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 1, k + 3, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 9, j + 1, k + 3, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 10, j + 1, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 1, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 1, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 1, k + 4, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 2, j + 1, k + 4, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 3, j + 1, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 1, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 1, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 1, k + 4, NovaCraftBlocks.sculk_spike, 1, 2);
		world.setBlock(i + 7, j + 1, k + 4, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 8, j + 1, k + 4, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 9, j + 1, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 1, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 1, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 1, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 1, k + 5, PlaceCrackedDeepslateBricks, 1, 2);
		world.setBlock(i + 2, j + 1, k + 5, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 3, j + 1, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 1, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 1, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 1, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 1, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 1, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 1, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 1, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 1, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 1, k + 6, NovaCraftBlocks.sculk_vein, 4, 2);
		world.setBlock(i + 1, j + 1, k + 6, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 2, j + 1, k + 6, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 4, j + 1, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 1, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 1, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 1, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 1, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 1, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 1, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 1, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 1, k + 7, NovaCraftBlocks.sculk_vein, 4, 2);
		world.setBlock(i + 1, j + 1, k + 7, PlaceCrackedDeepslateBricks, 1, 2);
		world.setBlock(i + 2, j + 1, k + 7, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 3, j + 1, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 1, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 1, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 1, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 1, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 1, k + 7, NovaCraftBlocks.sculk_vein, 2, 2);
		world.setBlock(i + 9, j + 1, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 1, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 1, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 1, k + 8, NovaCraftBlocks.sculk_vein, 4, 2);
		world.setBlock(i + 1, j + 1, k + 8, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 2, j + 1, k + 8, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 3, j + 1, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 1, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 1, k + 8, NovaCraftBlocks.sculk_vein, 2, 2);
		world.setBlock(i + 7, j + 1, k + 8, NovaCraftBlocks.sculk_vein, 4, 2);
		world.setBlock(i + 8, j + 1, k + 8, PlaceCrackedDeepslateBricks, 1, 2);
		world.setBlock(i + 9, j + 1, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 1, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 1, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 1, k + 9, NovaCraftBlocks.sculk_vein, 4, 2);
		world.setBlock(i + 1, j + 1, k + 9, PlaceCrackedDeepslateBricks, 1, 2);
		world.setBlock(i + 2, j + 1, k + 9, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 3, j + 1, k + 9, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 4, j + 1, k + 9, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 5, j + 1, k + 9, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 6, j + 1, k + 9, PlaceCrackedDeepslateBricks, 1, 2);
		world.setBlock(i + 7, j + 1, k + 9, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 8, j + 1, k + 9, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 9, j + 1, k + 9, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 10, j + 1, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 1, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 1, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 1, k + 10, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 2, j + 1, k + 10, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 3, j + 1, k + 10, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 4, j + 1, k + 10, NovaCraftBlocks.sculk_vein, 1, 2);
		world.setBlock(i + 5, j + 1, k + 10, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 6, j + 1, k + 10, NovaCraftBlocks.sculk_vein, 3, 2);
		world.setBlock(i + 7, j + 1, k + 10, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 8, j + 1, k + 10, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 9, j + 1, k + 10, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 10, j + 1, k + 10, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 11, j + 1, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 1, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 1, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 1, k + 11, PlaceCrackedDeepslateBricks, 1, 2);
		world.setBlock(i + 3, j + 1, k + 11, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 4, j + 1, k + 11, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 5, j + 1, k + 11, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 6, j + 1, k + 11, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 7, j + 1, k + 11, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 8, j + 1, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 1, k + 11, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 10, j + 1, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 1, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 1, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 1, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 1, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 1, k + 12, NovaCraftBlocks.sculk_vein, 3, 2);
		world.setBlock(i + 4, j + 1, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 1, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 1, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 1, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 1, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 1, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 1, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 1, k + 12, Blocks.air, 0, 2);
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
		world.setBlock(i + 0, j + 2, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 2, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 2, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 2, k + 1, NovaCraftBlocks.sculk_vein, 1, 2);
		world.setBlock(i + 4, j + 2, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 2, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 2, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 2, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 2, k + 1, NovaCraftBlocks.sculk_vein, 1, 2);
		world.setBlock(i + 9, j + 2, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 2, k + 1, NovaCraftBlocks.sculk_vein, 2, 2);
		world.setBlock(i + 11, j + 2, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 2, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 2, k + 2, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 2, j + 2, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 2, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 2, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 2, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 2, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 2, k + 2, NovaCraftBlocks.sculk_vein, 4, 2);
		world.setBlock(i + 8, j + 2, k + 2, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 9, j + 2, k + 2, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 10, j + 2, k + 2, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 11, j + 2, k + 2, NovaCraftBlocks.sculk_vein, 5, 2);
		world.setBlock(i + 0, j + 2, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 2, k + 3, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 2, j + 2, k + 3, NovaCraftBlocks.sculk_vein, 1, 2);
		world.setBlock(i + 3, j + 2, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 2, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 2, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 2, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 2, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 2, k + 3, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 9, j + 2, k + 3, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 10, j + 2, k + 3, NovaCraftBlocks.sculk_vein, 3, 2);
		world.setBlock(i + 11, j + 2, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 2, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 2, k + 4, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 2, j + 2, k + 4, NovaCraftBlocks.sculk_vein, 5, 2);
		world.setBlock(i + 3, j + 2, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 2, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 2, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 2, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 2, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 2, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 2, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 2, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 2, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 2, k + 5, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 2, j + 2, k + 5, NovaCraftBlocks.sculk_vein, 5, 2);
		world.setBlock(i + 3, j + 2, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 2, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 2, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 2, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 2, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 2, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 2, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 2, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 2, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 2, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 2, k + 6, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 2, j + 2, k + 6, NovaCraftBlocks.sculk_vein, 1, 2);
		world.setBlock(i + 3, j + 2, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 2, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 2, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 2, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 2, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 2, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 2, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 2, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 2, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 2, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 2, k + 7, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 2, j + 2, k + 7, NovaCraftBlocks.sculk_vein, 5, 2);
		world.setBlock(i + 3, j + 2, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 2, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 2, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 2, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 2, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 2, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 2, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 2, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 2, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 2, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 2, k + 8, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 2, j + 2, k + 8, NovaCraftBlocks.sculk_vein, 5, 2);
		world.setBlock(i + 3, j + 2, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 2, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 2, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 2, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 2, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 2, k + 8, NovaCraftBlocks.sculk_vein, 1, 2);
		world.setBlock(i + 9, j + 2, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 2, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 2, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 2, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 2, k + 9, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 2, j + 2, k + 9, NovaCraftBlocks.sculk_vein, 1, 2);
		world.setBlock(i + 3, j + 2, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 2, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 2, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 2, k + 9, NovaCraftBlocks.sculk_vein, 1, 2);
		world.setBlock(i + 7, j + 2, k + 9, NovaCraftBlocks.sculk_vein, 4, 2);
		world.setBlock(i + 8, j + 2, k + 9, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 9, j + 2, k + 9, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 10, j + 2, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 2, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 2, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 2, k + 10, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 2, j + 2, k + 10, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 3, j + 2, k + 10, NovaCraftBlocks.sculk_vein, 1, 2);
		world.setBlock(i + 4, j + 2, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 2, k + 10, NovaCraftBlocks.sculk_vein, 1, 2);
		world.setBlock(i + 6, j + 2, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 2, k + 10, NovaCraftBlocks.sculk_vein, 1, 2);
		world.setBlock(i + 8, j + 2, k + 10, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 9, j + 2, k + 10, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 10, j + 2, k + 10, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 11, j + 2, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 2, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 2, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 2, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 2, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 2, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 2, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 2, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 2, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 2, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 2, k + 11, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 10, j + 2, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 2, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 2, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 2, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 2, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 2, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 2, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 2, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 2, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 2, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 2, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 2, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 2, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 2, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 3, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 3, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 3, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 3, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 3, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 3, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 3, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 3, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 3, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 3, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 3, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 3, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 3, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 3, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 3, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 3, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 3, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 3, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 3, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 3, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 3, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 3, k + 1, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 10, j + 3, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 3, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 3, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 3, k + 2, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 2, j + 3, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 3, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 3, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 3, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 3, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 3, k + 2, NovaCraftBlocks.sculk_vein, 4, 2);
		world.setBlock(i + 8, j + 3, k + 2, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 9, j + 3, k + 2, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 10, j + 3, k + 2, PlaceDeepslateTiles, 2, 2);
		world.setBlock(i + 11, j + 3, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 3, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 3, k + 3, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 2, j + 3, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 3, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 3, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 3, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 3, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 3, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 3, k + 3, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 9, j + 3, k + 3, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 10, j + 3, k + 3, NovaCraftBlocks.sculk_vein, 5, 2);
		world.setBlock(i + 11, j + 3, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 3, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 3, k + 4, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 2, j + 3, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 3, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 3, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 3, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 3, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 3, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 3, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 3, k + 4, NovaCraftBlocks.sculk_vein, 3, 2);
		world.setBlock(i + 10, j + 3, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 3, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 3, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 3, k + 5, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 2, j + 3, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 3, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 3, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 3, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 3, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 3, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 3, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 3, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 3, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 3, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 3, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 3, k + 6, PlaceCrackedDeepslateTiles, 3, 2);
		world.setBlock(i + 2, j + 3, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 3, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 3, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 3, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 3, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 3, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 3, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 3, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 3, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 3, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 3, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 3, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 3, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 3, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 3, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 3, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 3, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 3, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 3, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 3, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 3, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 3, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 3, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 3, k + 8, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 2, j + 3, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 3, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 3, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 3, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 3, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 3, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 3, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 3, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 3, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 3, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 3, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 3, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 3, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 3, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 3, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 3, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 3, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 3, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 3, k + 9, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 9, j + 3, k + 9, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 10, j + 3, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 3, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 3, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 3, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 3, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 3, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 3, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 3, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 3, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 3, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 3, k + 10, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 9, j + 3, k + 10, PlaceChiseledDeepslate, 4, 2);
		world.setBlock(i + 10, j + 3, k + 10, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 11, j + 3, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 3, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 3, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 3, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 3, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 3, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 3, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 3, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 3, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 3, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 3, k + 11, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 10, j + 3, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 3, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 3, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 3, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 3, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 3, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 3, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 3, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 3, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 3, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 3, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 3, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 3, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 3, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 4, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 4, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 4, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 4, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 4, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 4, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 4, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 4, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 4, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 4, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 4, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 4, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 4, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 4, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 4, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 4, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 4, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 4, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 4, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 4, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 4, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 4, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 4, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 4, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 4, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 4, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 4, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 4, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 4, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 4, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 4, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 4, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 4, k + 2, NovaCraftBlocks.sculk_vein, 1, 2);
		world.setBlock(i + 9, j + 4, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 4, k + 2, PlaceChiseledDeepslate, 4, 2);
		world.setBlock(i + 11, j + 4, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 4, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 4, k + 3, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 2, j + 4, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 4, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 4, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 4, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 4, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 4, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 4, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 4, k + 3, NovaCraftBlocks.sculk_vein, 1, 2);
		world.setBlock(i + 10, j + 4, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 4, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 4, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 4, k + 4, PlaceDeepslateTiles, 2, 2);
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
		world.setBlock(i + 0, j + 4, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 4, k + 5, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 2, j + 4, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 4, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 4, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 4, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 4, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 4, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 4, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 4, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 4, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 4, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 4, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 4, k + 6, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 2, j + 4, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 4, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 4, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 4, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 4, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 4, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 4, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 4, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 4, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 4, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 4, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 4, k + 7, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 2, j + 4, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 4, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 4, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 4, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 4, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 4, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 4, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 4, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 4, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 4, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 4, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 4, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 4, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 4, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 4, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 4, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 4, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 4, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 4, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 4, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 4, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 4, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 4, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 4, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 4, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 4, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 4, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 4, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 4, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 4, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 4, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 4, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 4, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 4, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 4, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 4, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 4, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 4, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 4, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 4, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 4, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 4, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 4, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 4, k + 10, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 10, j + 4, k + 10, PlaceChiseledDeepslate, 4, 2);
		world.setBlock(i + 11, j + 4, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 4, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 4, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 4, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 4, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 4, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 4, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 4, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 4, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 4, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 4, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 4, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 4, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 4, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 4, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 4, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 4, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 4, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 4, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 4, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 4, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 4, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 4, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 4, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 4, k + 12, Blocks.air, 0, 2);
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
		world.setBlock(i + 0, j + 5, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 5, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 5, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 5, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 5, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 5, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 5, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 5, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 5, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 5, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 5, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 5, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 5, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 5, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 5, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 5, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 5, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 5, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 5, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 5, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 5, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 5, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 5, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 5, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 5, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 5, k + 3, PlaceCobbledDeepslate, 0, 2);
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
		world.setBlock(i + 0, j + 5, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 5, k + 4, PlaceCobbledDeepslate, 0, 2);
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
		world.setBlock(i + 0, j + 5, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 5, k + 5, PlaceCobbledDeepslate, 0, 2);
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
		world.setBlock(i + 0, j + 5, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 5, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 5, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 5, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 5, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 5, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 5, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 5, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 5, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 5, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 5, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 5, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 5, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 5, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 5, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 5, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 5, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 5, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 5, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 5, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 5, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 5, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 5, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 5, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 5, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 5, k + 8, Blocks.air, 0, 2);
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
		world.setBlock(i + 0, j + 5, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 5, k + 9, Blocks.air, 0, 2);
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
		world.setBlock(i + 0, j + 5, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 5, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 5, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 5, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 5, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 5, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 5, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 5, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 5, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 5, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 5, k + 10, PlaceCrackedDeepslateBricks, 1, 2);
		world.setBlock(i + 11, j + 5, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 5, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 5, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 5, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 5, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 5, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 5, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 5, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 5, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 5, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 5, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 5, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 11, j + 5, k + 11, Blocks.air, 0, 2);
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
		
		world.setBlock(i + 3, j + 1, k + 6, Blocks.chest, 5, 2);
		TileEntityChest chest = (TileEntityChest) world.getTileEntity(i + 3, j + 1, k + 6);

		for (int slot = 0; slot < 3 + random.nextInt(25); slot++) {
			chest.setInventorySlotContents(random.nextInt(chest.getSizeInventory()), this.getBasicLoot(random));
		}
		
		world.setBlock(i + 4, j + 1, k + 8, Blocks.mob_spawner, 0, 2);
		TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner)world.getTileEntity(i + 4, j + 1, k + 8);
        
        if (tileentitymobspawner != null)
        {
        	tileentitymobspawner.func_145881_a().setEntityName("nova_craft.sculk_incinerator");
        }
        
        world.setBlock(i + 7, j + 2, k + 4, Blocks.mob_spawner, 0, 2);
        TileEntityMobSpawner tileentitymobspawner2 = (TileEntityMobSpawner)world.getTileEntity(i + 7, j + 2, k + 4);
        
        if (tileentitymobspawner2 != null)
        {
        	tileentitymobspawner2.func_145881_a().setEntityName("nova_craft.sculked_monitor");
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
				return new ItemStack(NovaCraftItems.ancient_city_artifact, 1);
			default: {
				return new ItemStack(NovaCraftBlocks.sculk_block, random.nextInt(9) + 2);
			}
		}
	}

}
