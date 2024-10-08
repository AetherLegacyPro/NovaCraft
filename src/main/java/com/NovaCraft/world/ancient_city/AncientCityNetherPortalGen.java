package com.NovaCraft.world.ancient_city;

import net.minecraft.world.gen.feature.*;
import net.minecraft.block.*;
import net.minecraft.world.*;
import java.util.*;

import com.NovaCraft.Items.NovaCraftItems;
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
	
	private static final Block smooth_basalt = OtherModBlocks.BasaltBricks; //netherlicious 6
	private static final Block smooth_basalt1 = OtherModBlocks.smooth_basalt; //et futurum requiem

	//0 -> deepslate bricks
	//1 -> cracked deepslate bricks
	//2 -> deepslate tiles
	//3 -> cracked deepslate bricks
	//4 -> chiseled deepslate bricks
    
    public boolean generate(final World world, final Random random, final int i, final int j, final int k) {
    	
		world.setBlock(i + 1, j + 0, k + 0, deepslate_tile_stairs, 0, 2);
		world.setBlock(i + 2, j + 0, k + 0, deepslate_tile_stairs, 2, 2);
		world.setBlock(i + 3, j + 0, k + 0, deepslate_tile_stairs, 2, 2);
		world.setBlock(i + 4, j + 0, k + 0, deepslate_tile_stairs, 2, 2);
		world.setBlock(i + 5, j + 0, k + 0, deepslate_tile_stairs, 2, 2);
		world.setBlock(i + 6, j + 0, k + 0, deepslate_tile_stairs, 2, 2);
		world.setBlock(i + 7, j + 0, k + 0, deepslate_tile_stairs, 1, 2);
		world.setBlock(i + 0, j + 0, k + 1, deepslate_tile_stairs, 2, 2);
		world.setBlock(i + 1, j + 0, k + 1, deepslate_tile_stairs, 0, 2);
		world.setBlock(i + 2, j + 0, k + 1, deepslate_bricks, 0, 2);
		world.setBlock(i + 3, j + 0, k + 1, deepslate_bricks, 0, 2);
		world.setBlock(i + 4, j + 0, k + 1, deepslate_bricks, 0, 2);
		world.setBlock(i + 5, j + 0, k + 1, deepslate_bricks, 1, 2);
		world.setBlock(i + 6, j + 0, k + 1, deepslate_bricks, 0, 2);
		world.setBlock(i + 7, j + 0, k + 1, deepslate_tile_stairs, 2, 2);
		world.setBlock(i + 8, j + 0, k + 1, deepslate_tile_stairs, 1, 2);
		world.setBlock(i + 0, j + 0, k + 2, deepslate_tile_stairs, 0, 2);
		world.setBlock(i + 1, j + 0, k + 2, deepslate_bricks, 1, 2);
		world.setBlock(i + 2, j + 0, k + 2, deepslate_bricks, 0, 2);
		world.setBlock(i + 3, j + 0, k + 2, deepslate_bricks, 0, 2);
		world.setBlock(i + 4, j + 0, k + 2, deepslate_bricks, 0, 2);
		world.setBlock(i + 5, j + 0, k + 2, deepslate_bricks, 1, 2);
		world.setBlock(i + 6, j + 0, k + 2, deepslate_bricks, 0, 2);
		world.setBlock(i + 7, j + 0, k + 2, deepslate_bricks, 0, 2);
		world.setBlock(i + 8, j + 0, k + 2, deepslate_tile_stairs, 1, 2);
		world.setBlock(i + 0, j + 0, k + 3, deepslate_tile_stairs, 0, 2);
		world.setBlock(i + 1, j + 0, k + 3, deepslate_bricks, 0, 2);
		world.setBlock(i + 2, j + 0, k + 3, deepslate_bricks, 1, 2);
		world.setBlock(i + 3, j + 0, k + 3, deepslate_bricks, 0, 2);
		world.setBlock(i + 4, j + 0, k + 3, Blocks.obsidian, 0, 2);
		world.setBlock(i + 5, j + 0, k + 3, deepslate_bricks, 0, 2);
		world.setBlock(i + 6, j + 0, k + 3, deepslate_bricks, 0, 2);
		world.setBlock(i + 7, j + 0, k + 3, deepslate_bricks, 1, 2);
		world.setBlock(i + 8, j + 0, k + 3, deepslate_tile_stairs, 1, 2);
		world.setBlock(i + 0, j + 0, k + 4, deepslate_tile_stairs, 0, 2);
		world.setBlock(i + 1, j + 0, k + 4, deepslate_bricks, 0, 2);
		world.setBlock(i + 2, j + 0, k + 4, deepslate_bricks, 0, 2);
		world.setBlock(i + 3, j + 0, k + 4, deepslate_bricks, 1, 2);
		world.setBlock(i + 4, j + 0, k + 4, Blocks.obsidian, 0, 2);
		world.setBlock(i + 5, j + 0, k + 4, deepslate_bricks, 0, 2);
		world.setBlock(i + 6, j + 0, k + 4, deepslate_bricks, 0, 2);
		world.setBlock(i + 7, j + 0, k + 4, deepslate_bricks, 0, 2);
		world.setBlock(i + 8, j + 0, k + 4, deepslate_tile_stairs, 1, 2);
		world.setBlock(i + 0, j + 0, k + 5, deepslate_tile_stairs, 0, 2);
		world.setBlock(i + 1, j + 0, k + 5, deepslate_bricks, 0, 2);
		world.setBlock(i + 2, j + 0, k + 5, deepslate_bricks, 1, 2);
		world.setBlock(i + 3, j + 0, k + 5, deepslate_bricks, 0, 2);
		world.setBlock(i + 4, j + 0, k + 5, Blocks.obsidian, 0, 2);
		world.setBlock(i + 5, j + 0, k + 5, deepslate_bricks, 0, 2);
		world.setBlock(i + 6, j + 0, k + 5, deepslate_bricks, 1, 2);
		world.setBlock(i + 7, j + 0, k + 5, deepslate_bricks, 1, 2);
		world.setBlock(i + 8, j + 0, k + 5, deepslate_tile_stairs, 1, 2);
		world.setBlock(i + 0, j + 0, k + 6, deepslate_tile_stairs, 0, 2);
		world.setBlock(i + 1, j + 0, k + 6, deepslate_tile_stairs, 3, 2);
		world.setBlock(i + 2, j + 0, k + 6, deepslate_bricks, 0, 2);
		world.setBlock(i + 3, j + 0, k + 6, deepslate_bricks, 1, 2);
		world.setBlock(i + 4, j + 0, k + 6, deepslate_bricks, 0, 2);
		world.setBlock(i + 5, j + 0, k + 6, deepslate_bricks, 0, 2);
		world.setBlock(i + 6, j + 0, k + 6, deepslate_bricks, 0, 2);
		world.setBlock(i + 7, j + 0, k + 6, deepslate_tile_stairs, 1, 2);
		world.setBlock(i + 8, j + 0, k + 6, deepslate_tile_stairs, 3, 2);
		world.setBlock(i + 1, j + 0, k + 7, deepslate_tile_stairs, 0, 2);
		world.setBlock(i + 2, j + 0, k + 7, deepslate_tile_stairs, 3, 2);
		world.setBlock(i + 3, j + 0, k + 7, deepslate_tile_stairs, 3, 2);
		world.setBlock(i + 4, j + 0, k + 7, deepslate_tile_stairs, 3, 2);
		world.setBlock(i + 5, j + 0, k + 7, deepslate_tile_stairs, 3, 2);
		world.setBlock(i + 6, j + 0, k + 7, deepslate_tile_stairs, 3, 2);
		world.setBlock(i + 7, j + 0, k + 7, deepslate_tile_stairs, 3, 2);
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
		world.setBlock(i + 3, j + 4, k + 6, deepslate_brick_wall, 1, 2);
		world.setBlock(i + 4, j + 4, k + 6, Blocks.obsidian, 0, 2);
		
		world.setBlock(i + 3, j + 3, k + 6, soul_lantern, 1, 2);
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
