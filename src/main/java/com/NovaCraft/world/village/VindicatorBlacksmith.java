package com.NovaCraft.world.village;

import java.util.Random;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.config.Configs;
import com.NovaCraft.entity.illager.EntityIllagerTrader;
import com.NovaCraftBlocks.NovaCraftBlocks;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class VindicatorBlacksmith extends WorldGenerator
{
	private static final Block luminant_planks = NovaCraftBlocks.luminant_planks;
	private static final Block luminant_log = NovaCraftBlocks.luminant_log;
	private static final Block thinGlass = Blocks.glass_pane;
	private static final Block stoneSingleSlab = NovaCraftBlocks.cobbled_nullstone_slab;
	private static final Block nullStone = NovaCraftBlocks.nullstone_bricks;
	private static final Block stairsCobblestone = NovaCraftBlocks.nullstone_brick_stairs;
	private static final Block fenceIron = Blocks.iron_bars;
	private static final Block fence = NovaCraftBlocks.cobbled_nullstone_wall;
	private static final Block door = Blocks.wooden_door;
	private static final Block furnaceIdle = Blocks.furnace;
	private static final Block stairs2 = NovaCraftBlocks.nullstone_brick_stairs;
	private static final Block lavaStill = Blocks.lava;
	private static final Block air = Blocks.air;
	
	protected Block[] GetValidSpawnBlocks() {
		return new Block[] {
				Blocks.snow,
				Blocks.sand,
				Blocks.stone,
				Blocks.grass
		};
	}

	public boolean LocationIsValidSpawn(World world, int i, int j, int k){
		int distanceToAir = 0;
		Block checkID = world.getBlock(i, j, k);

		while (checkID != air){
			distanceToAir++;
			checkID = world.getBlock(i, j + distanceToAir, k);
		}

		if (distanceToAir > 2){
			return false;
		}
		j += distanceToAir - 1;

		Block blockID = world.getBlock(i, j, k);
		Block blockIDAbove = world.getBlock(i, j+1, k);
		Block blockIDBelow = world.getBlock(i, j-1, k);
		for (Block x : GetValidSpawnBlocks()){
			if (blockIDAbove != air){
				return false;
			}
			if ((blockID == Blocks.snow && blockIDBelow == x) || (blockID == Blocks.tallgrass && blockIDBelow == x) || (blockID == Blocks.red_flower && blockIDBelow == x) || (blockID == Blocks.yellow_flower && blockIDBelow == x) || (blockID == Blocks.deadbush && blockIDBelow == x) || (blockID == Blocks.cactus && blockIDBelow == x) || (blockID == Blocks.brown_mushroom && blockIDBelow == x) || (blockID == Blocks.red_mushroom && blockIDBelow == x)){
				return true;
			}
			else if (blockID == x){
				return true;
			}
		}
		return false;
	}

	public VindicatorBlacksmith() { }
	
	public boolean checkAllLocations(World world, int i, int j, int k){
		if(!LocationIsValidSpawn(world, i, j, k) || !LocationIsValidSpawn(world, i + 7, j, k) || !LocationIsValidSpawn(world, i + 7, j, k + 9) || !LocationIsValidSpawn(world, i, j, k + 9) || !AirLocationIsValidSpawn(world, i, j + 6, k) || !AirLocationIsValidSpawn(world, i + 7, j + 6, k) || !AirLocationIsValidSpawn(world, i + 7, j + 6, k + 9) || !AirLocationIsValidSpawn(world, i, j + 6, k + 9))
		{
			return false;
		}
		
		return true;
	}
	
	public boolean AirLocationIsValidSpawn(World world, int i, int j, int k){
		Block blockID = world.getBlock(i, j, k);
		Block blockIDAbove = world.getBlock(i, j+1, k);
		
		if (blockID != air || blockIDAbove != air){
			return false;
		}

		return true;
	}

	public boolean generate(World world, Random rand, int i, int j, int k) {
		//check that each corner is one of the valid spawn blocks
		if(!LocationIsValidSpawn(world, i, j, k) || !LocationIsValidSpawn(world, i + 7, j, k) || !LocationIsValidSpawn(world, i + 7, j, k + 9) || !LocationIsValidSpawn(world, i, j, k + 9) || !AirLocationIsValidSpawn(world, i, j + 6, k) || !AirLocationIsValidSpawn(world, i + 7, j + 6, k) || !AirLocationIsValidSpawn(world, i + 7, j + 6, k + 9) || !AirLocationIsValidSpawn(world, i, j + 6, k + 9))
		{
			return false;
		}

		world.setBlock(i + 0, j + 1, k + 0, air);
		world.setBlock(i + 0, j + 1, k + 1, air);
		world.setBlock(i + 0, j + 1, k + 2, air);
		world.setBlock(i + 0, j + 1, k + 3, air);
		world.setBlock(i + 0, j + 1, k + 4, air);
		world.setBlock(i + 0, j + 1, k + 5, air);
		world.setBlock(i + 0, j + 1, k + 6, stairsCobblestone, 0, 2);
		world.setBlock(i + 0, j + 1, k + 7, stairsCobblestone, 0, 2);
		world.setBlock(i + 0, j + 1, k + 8, stairsCobblestone, 0, 2);
		world.setBlock(i + 0, j + 1, k + 9, air);
		world.setBlock(i + 0, j + 2, k + 0, air);
		world.setBlock(i + 0, j + 2, k + 1, air);
		world.setBlock(i + 0, j + 2, k + 2, air);
		world.setBlock(i + 0, j + 2, k + 3, air);
		world.setBlock(i + 0, j + 2, k + 4, air);
		world.setBlock(i + 0, j + 2, k + 5, air);
		world.setBlock(i + 0, j + 2, k + 6, air);
		world.setBlock(i + 0, j + 2, k + 7, air);
		world.setBlock(i + 0, j + 2, k + 8, air);
		world.setBlock(i + 0, j + 2, k + 9, air);
		world.setBlock(i + 0, j + 3, k + 0, air);
		world.setBlock(i + 0, j + 3, k + 1, air);
		world.setBlock(i + 0, j + 3, k + 2, air);
		world.setBlock(i + 0, j + 3, k + 3, air);
		world.setBlock(i + 0, j + 3, k + 4, air);
		world.setBlock(i + 0, j + 3, k + 5, air);
		world.setBlock(i + 0, j + 3, k + 6, air);
		world.setBlock(i + 0, j + 3, k + 7, air);
		world.setBlock(i + 0, j + 3, k + 8, air);
		world.setBlock(i + 0, j + 3, k + 9, air);
		world.setBlock(i + 0, j + 4, k + 0, air);
		world.setBlock(i + 0, j + 4, k + 1, air);
		world.setBlock(i + 0, j + 4, k + 2, air);
		world.setBlock(i + 0, j + 4, k + 3, air);
		world.setBlock(i + 0, j + 4, k + 4, air);
		world.setBlock(i + 0, j + 4, k + 5, air);
		world.setBlock(i + 0, j + 4, k + 6, air);
		world.setBlock(i + 0, j + 4, k + 7, air);
		world.setBlock(i + 0, j + 4, k + 8, air);
		world.setBlock(i + 0, j + 4, k + 9, air);
		world.setBlock(i + 0, j + 5, k + 0, air);
		world.setBlock(i + 0, j + 5, k + 1, air);
		world.setBlock(i + 0, j + 5, k + 2, air);
		world.setBlock(i + 0, j + 5, k + 3, air);
		world.setBlock(i + 0, j + 5, k + 4, air);
		world.setBlock(i + 0, j + 5, k + 5, air);
		world.setBlock(i + 0, j + 5, k + 6, air);
		world.setBlock(i + 0, j + 5, k + 7, air);
		world.setBlock(i + 0, j + 5, k + 8, air);
		world.setBlock(i + 0, j + 5, k + 9, air);
		world.setBlock(i + 0, j + 6, k + 0, air);
		world.setBlock(i + 0, j + 6, k + 1, air);
		world.setBlock(i + 0, j + 6, k + 2, air);
		world.setBlock(i + 0, j + 6, k + 3, air);
		world.setBlock(i + 0, j + 6, k + 4, air);
		world.setBlock(i + 0, j + 6, k + 5, air);
		world.setBlock(i + 0, j + 6, k + 6, air);
		world.setBlock(i + 0, j + 6, k + 7, air);
		world.setBlock(i + 0, j + 6, k + 8, air);
		world.setBlock(i + 0, j + 6, k + 9, air);
		world.setBlock(i + 1, j + 1, k + 0, nullStone, 0, 2);
		world.setBlock(i + 1, j + 1, k + 1, nullStone, 0, 2);
		world.setBlock(i + 1, j + 1, k + 2, nullStone, 0, 2);
		world.setBlock(i + 1, j + 1, k + 3, nullStone, 0, 2);
		world.setBlock(i + 1, j + 1, k + 4, nullStone, 0, 2);
		world.setBlock(i + 1, j + 1, k + 5, nullStone, 0, 2);
		world.setBlock(i + 1, j + 1, k + 6, nullStone, 0, 2);
		world.setBlock(i + 1, j + 1, k + 7, nullStone, 0, 2);
		world.setBlock(i + 1, j + 1, k + 8, nullStone, 0, 2);
		world.setBlock(i + 1, j + 1, k + 9, nullStone, 0, 2);
		world.setBlock(i + 1, j + 2, k + 0, luminant_log, 0, 2);
		world.setBlock(i + 1, j + 2, k + 1, luminant_planks, 0, 2);
		world.setBlock(i + 1, j + 2, k + 2, luminant_planks, 0, 2);
		world.setBlock(i + 1, j + 2, k + 3, luminant_log, 0, 2);
		world.setBlock(i + 1, j + 2, k + 4, air);
		world.setBlock(i + 1, j + 2, k + 5, fence, 0, 2);
		world.setBlock(i + 1, j + 2, k + 6, air);
		world.setBlock(i + 1, j + 2, k + 7, air);
		world.setBlock(i + 1, j + 2, k + 8, air);
		world.setBlock(i + 1, j + 2, k + 9, fence, 0, 2);
		world.setBlock(i + 1, j + 3, k + 0, luminant_log, 0, 2);
		world.setBlock(i + 1, j + 3, k + 1, luminant_planks, 0, 2);
		world.setBlock(i + 1, j + 3, k + 2, luminant_planks, 0, 2);
		world.setBlock(i + 1, j + 3, k + 3, luminant_log, 0, 2);
		world.setBlock(i + 1, j + 3, k + 4, air);
		world.setBlock(i + 1, j + 3, k + 5, fence, 0, 2);
		world.setBlock(i + 1, j + 3, k + 6, air);
		world.setBlock(i + 1, j + 3, k + 7, air);
		world.setBlock(i + 1, j + 3, k + 8, air);
		world.setBlock(i + 1, j + 3, k + 9, fence, 0, 2);
		world.setBlock(i + 1, j + 4, k + 0, luminant_log, 0, 2);
		world.setBlock(i + 1, j + 4, k + 1, luminant_planks, 0, 2);
		world.setBlock(i + 1, j + 4, k + 2, luminant_planks, 0, 2);
		world.setBlock(i + 1, j + 4, k + 3, luminant_log, 0, 2);
		world.setBlock(i + 1, j + 4, k + 4, air);
		world.setBlock(i + 1, j + 4, k + 5, fence, 0, 2);
		world.setBlock(i + 1, j + 4, k + 6, air);
		world.setBlock(i + 1, j + 4, k + 7, air);
		world.setBlock(i + 1, j + 4, k + 8, air);
		world.setBlock(i + 1, j + 4, k + 9, fence, 0, 2);
		world.setBlock(i + 1, j + 5, k + 0, luminant_log, 0, 2);
		world.setBlock(i + 1, j + 5, k + 1, nullStone, 0, 2);
		world.setBlock(i + 1, j + 5, k + 2, nullStone, 0, 2);
		world.setBlock(i + 1, j + 5, k + 3, luminant_log, 0, 2);
		world.setBlock(i + 1, j + 5, k + 4, nullStone, 0, 2);
		world.setBlock(i + 1, j + 5, k + 5, nullStone, 0, 2);
		world.setBlock(i + 1, j + 5, k + 6, nullStone, 0, 2);
		world.setBlock(i + 1, j + 5, k + 7, nullStone, 0, 2);
		world.setBlock(i + 1, j + 5, k + 8, nullStone, 0, 2);
		world.setBlock(i + 1, j + 5, k + 9, nullStone, 0, 2);
		world.setBlock(i + 1, j + 6, k + 0, stoneSingleSlab, 0, 2);
		world.setBlock(i + 1, j + 6, k + 1, stoneSingleSlab, 0, 2);
		world.setBlock(i + 1, j + 6, k + 2, stoneSingleSlab, 0, 2);
		world.setBlock(i + 1, j + 6, k + 3, stoneSingleSlab, 0, 2);
		world.setBlock(i + 1, j + 6, k + 4, stoneSingleSlab, 0, 2);
		world.setBlock(i + 1, j + 6, k + 5, stoneSingleSlab, 0, 2);
		world.setBlock(i + 1, j + 6, k + 6, stoneSingleSlab, 0, 2);
		world.setBlock(i + 1, j + 6, k + 7, stoneSingleSlab, 0, 2);
		world.setBlock(i + 1, j + 6, k + 8, stoneSingleSlab, 0, 2);
		world.setBlock(i + 1, j + 6, k + 9, stoneSingleSlab, 0, 2);
		world.setBlock(i + 2, j + 1, k + 0, nullStone, 0, 2);
		world.setBlock(i + 2, j + 1, k + 1, nullStone, 0, 2);
		world.setBlock(i + 2, j + 1, k + 2, nullStone, 0, 2);
		world.setBlock(i + 2, j + 1, k + 3, nullStone, 0, 2);
		world.setBlock(i + 2, j + 1, k + 4, nullStone, 0, 2);
		world.setBlock(i + 2, j + 1, k + 5, nullStone, 0, 2);
		world.setBlock(i + 2, j + 1, k + 6, nullStone, 0, 2);
		world.setBlock(i + 2, j + 1, k + 7, nullStone, 0, 2);
		world.setBlock(i + 2, j + 1, k + 8, nullStone, 0, 2);
		world.setBlock(i + 2, j + 1, k + 9, nullStone, 0, 2);
		world.setBlock(i + 2, j + 2, k + 0, luminant_planks, 0, 2);
		world.setBlock(i + 2, j + 2, k + 1, air);
		world.setBlock(i + 2, j + 2, k + 2, air);
		world.setBlock(i + 2, j + 2, k + 3, air);
		world.setBlock(i + 2, j + 2, k + 4, air);
		world.setBlock(i + 2, j + 2, k + 5, air);
		world.setBlock(i + 2, j + 2, k + 6, air);
		world.setBlock(i + 2, j + 2, k + 7, air);
		world.setBlock(i + 2, j + 2, k + 8, Blocks.anvil, 2, 2);
		world.setBlock(i + 2, j + 2, k + 9, air);
		world.setBlock(i + 2, j + 3, k + 0, luminant_planks, 0, 2);
		world.setBlock(i + 2, j + 3, k + 1, air);
		world.setBlock(i + 2, j + 3, k + 2, air);
		world.setBlock(i + 2, j + 3, k + 3, air);
		world.setBlock(i + 2, j + 3, k + 4, air);
		world.setBlock(i + 2, j + 3, k + 5, air);
		world.setBlock(i + 2, j + 3, k + 6, air);
		world.setBlock(i + 2, j + 3, k + 7, air);
		world.setBlock(i + 2, j + 3, k + 8, air);
		world.setBlock(i + 2, j + 3, k + 9, air);
		world.setBlock(i + 2, j + 4, k + 0, luminant_planks, 0, 2);
		world.setBlock(i + 2, j + 4, k + 1, air);
		world.setBlock(i + 2, j + 4, k + 2, air);
		world.setBlock(i + 2, j + 4, k + 3, luminant_planks, 0, 2);
		world.setBlock(i + 2, j + 4, k + 4, air);
		world.setBlock(i + 2, j + 4, k + 5, air);
		world.setBlock(i + 2, j + 4, k + 6, air);
		world.setBlock(i + 2, j + 4, k + 7, air);
		world.setBlock(i + 2, j + 4, k + 8, air);
		world.setBlock(i + 2, j + 4, k + 9, air);
		world.setBlock(i + 2, j + 5, k + 0, nullStone, 0, 2);
		world.setBlock(i + 2, j + 5, k + 1, nullStone, 0, 2);
		world.setBlock(i + 2, j + 5, k + 2, nullStone, 0, 2);
		world.setBlock(i + 2, j + 5, k + 3, nullStone, 0, 2);
		world.setBlock(i + 2, j + 5, k + 4, nullStone, 0, 2);
		world.setBlock(i + 2, j + 5, k + 5, nullStone, 0, 2);
		world.setBlock(i + 2, j + 5, k + 6, nullStone, 0, 2);
		world.setBlock(i + 2, j + 5, k + 7, nullStone, 0, 2);
		world.setBlock(i + 2, j + 5, k + 8, nullStone, 0, 2);
		world.setBlock(i + 2, j + 5, k + 9, nullStone, 0, 2);
		world.setBlock(i + 2, j + 6, k + 0, stoneSingleSlab, 0, 2);
		world.setBlock(i + 2, j + 6, k + 1, air);
		world.setBlock(i + 2, j + 6, k + 2, air);
		world.setBlock(i + 2, j + 6, k + 3, air);
		world.setBlock(i + 2, j + 6, k + 4, air);
		world.setBlock(i + 2, j + 6, k + 5, air);
		world.setBlock(i + 2, j + 6, k + 6, air);
		world.setBlock(i + 2, j + 6, k + 7, air);
		world.setBlock(i + 2, j + 6, k + 8, air);
		world.setBlock(i + 2, j + 6, k + 9, stoneSingleSlab, 0, 2);
		world.setBlock(i + 3, j + 1, k + 0, nullStone, 0, 2);
		world.setBlock(i + 3, j + 1, k + 1, nullStone, 0, 2);
		world.setBlock(i + 3, j + 1, k + 2, nullStone, 0, 2);
		world.setBlock(i + 3, j + 1, k + 3, nullStone, 0, 2);
		world.setBlock(i + 3, j + 1, k + 4, nullStone, 0, 2);
		world.setBlock(i + 3, j + 1, k + 5, nullStone, 0, 2);
		world.setBlock(i + 3, j + 1, k + 6, nullStone, 0, 2);
		world.setBlock(i + 3, j + 1, k + 7, nullStone, 0, 2);
		world.setBlock(i + 3, j + 1, k + 8, nullStone, 0, 2);
		world.setBlock(i + 3, j + 1, k + 9, nullStone, 0, 2);
		world.setBlock(i + 3, j + 2, k + 0, luminant_planks, 0, 2);
		world.setBlock(i + 3, j + 2, k + 1, air);
		world.setBlock(i + 3, j + 2, k + 2, air);
		world.setBlock(i + 3, j + 2, k + 3, luminant_planks, 0, 2);
		world.setBlock(i + 3, j + 2, k + 4, air);
		world.setBlock(i + 3, j + 2, k + 5, air);
		world.setBlock(i + 3, j + 2, k + 6, air);
		world.setBlock(i + 3, j + 2, k + 7, air);
		world.setBlock(i + 3, j + 2, k + 8, air);
		world.setBlock(i + 3, j + 2, k + 9, air);
		world.setBlock(i + 3, j + 3, k + 0, thinGlass, 0, 2);
		world.setBlock(i + 3, j + 3, k + 1, air);
		world.setBlock(i + 3, j + 3, k + 2, air);
		world.setBlock(i + 3, j + 3, k + 3, luminant_planks, 0, 2);
		world.setBlock(i + 3, j + 3, k + 4, air);
		world.setBlock(i + 3, j + 3, k + 5, air);
		world.setBlock(i + 3, j + 3, k + 6, air);
		world.setBlock(i + 3, j + 3, k + 7, air);
		world.setBlock(i + 3, j + 3, k + 8, air);
		world.setBlock(i + 3, j + 3, k + 9, air);
		world.setBlock(i + 3, j + 4, k + 0, luminant_planks, 0, 2);
		world.setBlock(i + 3, j + 4, k + 1, air);
		world.setBlock(i + 3, j + 4, k + 2, air);
		world.setBlock(i + 3, j + 4, k + 3, luminant_planks, 0, 2);
		world.setBlock(i + 3, j + 4, k + 4, air);
		world.setBlock(i + 3, j + 4, k + 5, air);
		world.setBlock(i + 3, j + 4, k + 6, air);
		world.setBlock(i + 3, j + 4, k + 7, air);
		world.setBlock(i + 3, j + 4, k + 8, air);
		world.setBlock(i + 3, j + 4, k + 9, air);
		world.setBlock(i + 3, j + 5, k + 0, nullStone, 0, 2);
		world.setBlock(i + 3, j + 5, k + 1, nullStone, 0, 2);
		world.setBlock(i + 3, j + 5, k + 2, nullStone, 0, 2);
		world.setBlock(i + 3, j + 5, k + 3, nullStone, 0, 2);
		world.setBlock(i + 3, j + 5, k + 4, nullStone, 0, 2);
		world.setBlock(i + 3, j + 5, k + 5, nullStone, 0, 2);
		world.setBlock(i + 3, j + 5, k + 6, nullStone, 0, 2);
		world.setBlock(i + 3, j + 5, k + 7, nullStone, 0, 2);
		world.setBlock(i + 3, j + 5, k + 8, nullStone, 0, 2);
		world.setBlock(i + 3, j + 5, k + 9, nullStone, 0, 2);
		world.setBlock(i + 3, j + 6, k + 0, stoneSingleSlab, 0, 2);
		world.setBlock(i + 3, j + 6, k + 1, air);
		world.setBlock(i + 3, j + 6, k + 2, air);
		world.setBlock(i + 3, j + 6, k + 3, air);
		world.setBlock(i + 3, j + 6, k + 4, air);
		world.setBlock(i + 3, j + 6, k + 5, air);
		world.setBlock(i + 3, j + 6, k + 6, air);
		world.setBlock(i + 3, j + 6, k + 7, air);
		world.setBlock(i + 3, j + 6, k + 8, air);
		world.setBlock(i + 3, j + 6, k + 9, stoneSingleSlab, 0, 2);
		world.setBlock(i + 4, j + 1, k + 0, nullStone, 0, 2);
		world.setBlock(i + 4, j + 1, k + 1, nullStone, 0, 2);
		world.setBlock(i + 4, j + 1, k + 2, nullStone, 0, 2);
		world.setBlock(i + 4, j + 1, k + 3, nullStone, 0, 2);
		world.setBlock(i + 4, j + 1, k + 4, nullStone, 0, 2);
		world.setBlock(i + 4, j + 1, k + 5, nullStone, 0, 2);
		world.setBlock(i + 4, j + 1, k + 6, nullStone, 0, 2);
		world.setBlock(i + 4, j + 1, k + 7, nullStone, 0, 2);
		world.setBlock(i + 4, j + 1, k + 8, nullStone, 0, 2);
		world.setBlock(i + 4, j + 1, k + 9, nullStone, 0, 2);
		world.setBlock(i + 4, j + 2, k + 0, luminant_planks, 0, 2);
		world.setBlock(i + 4, j + 2, k + 1, air);
		world.setBlock(i + 4, j + 2, k + 2, air);
		world.setBlock(i + 4, j + 2, k + 3, air);
		world.setBlock(i + 4, j + 2, k + 4, luminant_planks, 0, 2);
		world.setBlock(i + 4, j + 2, k + 5, luminant_planks, 0, 2);
		world.setBlock(i + 4, j + 2, k + 6, nullStone, 0, 2);
		world.setBlock(i + 4, j + 2, k + 7, air);
		world.setBlock(i + 4, j + 2, k + 8, air);
		world.setBlock(i + 4, j + 2, k + 9, air);
		world.setBlock(i + 4, j + 3, k + 0, luminant_planks, 0, 2);
		world.setBlock(i + 4, j + 3, k + 1, air);
		world.setBlock(i + 4, j + 3, k + 2, air);
		world.setBlock(i + 4, j + 3, k + 3, air);
		world.setBlock(i + 4, j + 3, k + 4, luminant_planks, 0, 2);
		world.setBlock(i + 4, j + 3, k + 5, luminant_planks, 0, 2);
		world.setBlock(i + 4, j + 3, k + 6, furnaceIdle, 3, 2);
		world.setBlock(i + 2, j + 2, k + 3, door, 3, 2);
		world.setBlock(i + 2, j + 3, k + 3, door, 8, 2);		
		world.setBlock(i + 4, j + 3, k + 7, air);
		world.setBlock(i + 4, j + 3, k + 8, air);
		world.setBlock(i + 4, j + 3, k + 9, air);
		world.setBlock(i + 4, j + 4, k + 0, luminant_planks, 0, 2);
		world.setBlock(i + 4, j + 4, k + 1, air);
		world.setBlock(i + 4, j + 4, k + 2, air);
		world.setBlock(i + 4, j + 4, k + 3, air);
		world.setBlock(i + 4, j + 4, k + 4, luminant_planks, 0, 2);
		world.setBlock(i + 4, j + 4, k + 5, luminant_planks, 0, 2);
		world.setBlock(i + 4, j + 4, k + 6, furnaceIdle, 3, 2);
		world.setBlock(i + 4, j + 4, k + 7, air);
		world.setBlock(i + 4, j + 4, k + 8, air);
		world.setBlock(i + 4, j + 4, k + 9, air);
		world.setBlock(i + 4, j + 5, k + 0, nullStone, 0, 2);
		world.setBlock(i + 4, j + 5, k + 1, nullStone, 0, 2);
		world.setBlock(i + 4, j + 5, k + 2, nullStone, 0, 2);
		world.setBlock(i + 4, j + 5, k + 3, nullStone, 0, 2);
		world.setBlock(i + 4, j + 5, k + 4, nullStone, 0, 2);
		world.setBlock(i + 4, j + 5, k + 5, nullStone, 0, 2);
		world.setBlock(i + 4, j + 5, k + 6, nullStone, 0, 2);
		world.setBlock(i + 4, j + 5, k + 7, nullStone, 0, 2);
		world.setBlock(i + 4, j + 5, k + 8, nullStone, 0, 2);
		world.setBlock(i + 4, j + 5, k + 9, nullStone, 0, 2);
		world.setBlock(i + 4, j + 6, k + 0, stoneSingleSlab, 0, 2);
		world.setBlock(i + 4, j + 6, k + 1, air);
		world.setBlock(i + 4, j + 6, k + 2, air);
		world.setBlock(i + 4, j + 6, k + 3, air);
		world.setBlock(i + 4, j + 6, k + 4, air);
		world.setBlock(i + 4, j + 6, k + 5, air);
		world.setBlock(i + 4, j + 6, k + 6, air);
		world.setBlock(i + 4, j + 6, k + 7, air);
		world.setBlock(i + 4, j + 6, k + 8, air);
		world.setBlock(i + 4, j + 6, k + 9, stoneSingleSlab, 0, 2);
		world.setBlock(i + 5, j + 1, k + 0, nullStone, 0, 2);
		world.setBlock(i + 5, j + 1, k + 1, nullStone, 0, 2);
		world.setBlock(i + 5, j + 1, k + 2, nullStone, 0, 2);
		world.setBlock(i + 5, j + 1, k + 3, nullStone, 0, 2);
		world.setBlock(i + 5, j + 1, k + 4, nullStone, 0, 2);
		world.setBlock(i + 5, j + 1, k + 5, nullStone, 0, 2);
		world.setBlock(i + 5, j + 1, k + 6, nullStone, 0, 2);
		world.setBlock(i + 5, j + 1, k + 7, nullStone, 0, 2);
		world.setBlock(i + 5, j + 1, k + 8, nullStone, 0, 2);
		world.setBlock(i + 5, j + 1, k + 9, nullStone, 0, 2);
		world.setBlock(i + 5, j + 2, k + 0, luminant_planks, 0, 2);
		world.setBlock(i + 5, j + 2, k + 1, stairs2, 3, 2);
		world.setBlock(i + 5, j + 2, k + 2, fence, 0, 2);
		world.setBlock(i + 5, j + 2, k + 3, air);
		world.setBlock(i + 5, j + 2, k + 4, air);
		world.setBlock(i + 5, j + 2, k + 5, air);
		world.setBlock(i + 5, j + 2, k + 6, nullStone, 0, 2);
		world.setBlock(i + 5, j + 2, k + 7, nullStone, 0, 2);
		world.setBlock(i + 5, j + 2, k + 8, nullStone, 0, 2);
		world.setBlock(i + 5, j + 2, k + 9, nullStone, 0, 2);
		world.setBlock(i + 5, j + 3, k + 0, thinGlass, 0, 2);
		world.setBlock(i + 5, j + 3, k + 1, air);
		world.setBlock(i + 5, j + 3, k + 3, air);
		world.setBlock(i + 5, j + 3, k + 4, air);
		world.setBlock(i + 5, j + 3, k + 5, air);
		world.setBlock(i + 5, j + 3, k + 6, nullStone, 0, 2);
		world.setBlock(i + 5, j + 3, k + 7, air);
		world.setBlock(i + 5, j + 3, k + 8, air);
		world.setBlock(i + 5, j + 3, k + 9, fenceIron, 0, 2);
		world.setBlock(i + 5, j + 4, k + 0, luminant_planks, 0, 2);
		world.setBlock(i + 5, j + 4, k + 1, air);
		world.setBlock(i + 5, j + 4, k + 2, air);
		world.setBlock(i + 5, j + 4, k + 3, air);
		world.setBlock(i + 5, j + 4, k + 4, air);
		world.setBlock(i + 5, j + 4, k + 5, air);
		world.setBlock(i + 5, j + 4, k + 6, nullStone, 0, 2);
		world.setBlock(i + 5, j + 4, k + 7, nullStone, 0, 2);
		world.setBlock(i + 5, j + 4, k + 8, nullStone, 0, 2);
		world.setBlock(i + 5, j + 4, k + 9, nullStone, 0, 2);
		world.setBlock(i + 5, j + 5, k + 0, nullStone, 0, 2);
		world.setBlock(i + 5, j + 5, k + 1, nullStone, 0, 2);
		world.setBlock(i + 5, j + 5, k + 2, nullStone, 0, 2);
		world.setBlock(i + 5, j + 5, k + 3, nullStone, 0, 2);
		world.setBlock(i + 5, j + 5, k + 4, nullStone, 0, 2);
		world.setBlock(i + 5, j + 5, k + 5, nullStone, 0, 2);
		world.setBlock(i + 5, j + 5, k + 6, nullStone, 0, 2);
		world.setBlock(i + 5, j + 5, k + 7, nullStone, 0, 2);
		world.setBlock(i + 5, j + 5, k + 8, nullStone, 0, 2);
		world.setBlock(i + 5, j + 5, k + 9, nullStone, 0, 2);
		world.setBlock(i + 5, j + 6, k + 0, stoneSingleSlab, 0, 2);
		world.setBlock(i + 5, j + 6, k + 1, air);
		world.setBlock(i + 5, j + 6, k + 2, air);
		world.setBlock(i + 5, j + 6, k + 3, air);
		world.setBlock(i + 5, j + 6, k + 4, air);
		world.setBlock(i + 5, j + 6, k + 5, air);
		world.setBlock(i + 5, j + 6, k + 6, air);
		world.setBlock(i + 5, j + 6, k + 7, air);
		world.setBlock(i + 5, j + 6, k + 8, air);
		world.setBlock(i + 5, j + 6, k + 9, stoneSingleSlab, 0, 2);
		world.setBlock(i + 6, j + 1, k + 0, nullStone, 0, 2);
		world.setBlock(i + 6, j + 1, k + 1, nullStone, 0, 2);
		world.setBlock(i + 6, j + 1, k + 2, nullStone, 0, 2);
		world.setBlock(i + 6, j + 1, k + 3, nullStone, 0, 2);
		world.setBlock(i + 6, j + 1, k + 4, nullStone, 0, 2);
		world.setBlock(i + 6, j + 1, k + 5, nullStone, 0, 2);
		world.setBlock(i + 6, j + 1, k + 6, nullStone, 0, 2);
		world.setBlock(i + 6, j + 1, k + 7, nullStone, 0, 2);
		world.setBlock(i + 6, j + 1, k + 8, nullStone, 0, 2);
		world.setBlock(i + 6, j + 1, k + 9, nullStone, 0, 2);
		world.setBlock(i + 6, j + 2, k + 0, luminant_planks, 0, 2);
		world.setBlock(i + 6, j + 2, k + 1, luminant_planks, 0, 2);
		world.setBlock(i + 6, j + 2, k + 2, stairs2, 0, 2);
		world.setBlock(i + 6, j + 2, k + 3, air);
		world.setBlock(i + 6, j + 2, k + 4, air);		
		world.setBlock(i + 6, j + 2, k + 5, Blocks.chest, 2, 2);
		TileEntityChest chest = (TileEntityChest) world.getTileEntity(i + 6, j + 2, k + 5);

		for (int slot = 0; slot < 3 + rand.nextInt(25); slot++) {
			chest.setInventorySlotContents(rand.nextInt(chest.getSizeInventory()), this.getBlacksmithLoot(rand));
		}		
		world.setBlock(i + 6, j + 2, k + 6, nullStone, 0, 2);
		world.setBlock(i + 6, j + 2, k + 9, nullStone, 0, 2);
		world.setBlock(i + 6, j + 3, k + 0, luminant_planks, 0, 2);
		world.setBlock(i + 6, j + 3, k + 1, air);
		world.setBlock(i + 6, j + 3, k + 2, air);
		world.setBlock(i + 6, j + 3, k + 3, air);
		world.setBlock(i + 6, j + 3, k + 4, air);
		world.setBlock(i + 6, j + 3, k + 5, air);
		world.setBlock(i + 6, j + 3, k + 6, nullStone, 0, 2);
		world.setBlock(i + 6, j + 3, k + 7, air);
		world.setBlock(i + 6, j + 3, k + 8, air);
		world.setBlock(i + 6, j + 3, k + 9, fenceIron, 0, 2);
		world.setBlock(i + 6, j + 4, k + 0, luminant_planks, 0, 2);
		world.setBlock(i + 6, j + 4, k + 1, air);
		world.setBlock(i + 6, j + 4, k + 2, air);
		world.setBlock(i + 6, j + 4, k + 3, air);
		world.setBlock(i + 6, j + 4, k + 4, air);
		world.setBlock(i + 6, j + 4, k + 5, air);
		world.setBlock(i + 6, j + 4, k + 6, nullStone, 0, 2);
		world.setBlock(i + 6, j + 4, k + 7, nullStone, 0, 2);
		world.setBlock(i + 6, j + 4, k + 8, nullStone, 0, 2);
		world.setBlock(i + 6, j + 4, k + 9, nullStone, 0, 2);
		world.setBlock(i + 6, j + 5, k + 0, nullStone, 0, 2);
		world.setBlock(i + 6, j + 5, k + 1, nullStone, 0, 2);
		world.setBlock(i + 6, j + 5, k + 2, nullStone, 0, 2);
		world.setBlock(i + 6, j + 5, k + 3, nullStone, 0, 2);
		world.setBlock(i + 6, j + 5, k + 4, nullStone, 0, 2);
		world.setBlock(i + 6, j + 5, k + 5, nullStone, 0, 2);
		world.setBlock(i + 6, j + 5, k + 6, nullStone, 0, 2);
		world.setBlock(i + 6, j + 5, k + 7, nullStone, 0, 2);
		world.setBlock(i + 6, j + 5, k + 8, nullStone, 0, 2);
		world.setBlock(i + 6, j + 5, k + 9, nullStone, 0, 2);
		world.setBlock(i + 6, j + 6, k + 0, stoneSingleSlab, 0, 2);
		world.setBlock(i + 6, j + 6, k + 1, air);
		world.setBlock(i + 6, j + 6, k + 2, air);
		world.setBlock(i + 6, j + 6, k + 3, air);
		world.setBlock(i + 6, j + 6, k + 4, air);
		world.setBlock(i + 6, j + 6, k + 5, air);
		world.setBlock(i + 6, j + 6, k + 6, air);
		world.setBlock(i + 6, j + 6, k + 7, air);
		world.setBlock(i + 6, j + 6, k + 8, air);
		world.setBlock(i + 6, j + 6, k + 9, stoneSingleSlab, 0, 2);
		world.setBlock(i + 7, j + 1, k + 0, nullStone, 0, 2);
		world.setBlock(i + 7, j + 1, k + 1, nullStone, 0, 2);
		world.setBlock(i + 7, j + 1, k + 2, nullStone, 0, 2);
		world.setBlock(i + 7, j + 1, k + 3, nullStone, 0, 2);
		world.setBlock(i + 7, j + 1, k + 4, nullStone, 0, 2);
		world.setBlock(i + 7, j + 1, k + 5, nullStone, 0, 2);
		world.setBlock(i + 7, j + 1, k + 6, nullStone, 0, 2);
		world.setBlock(i + 7, j + 1, k + 7, nullStone, 0, 2);
		world.setBlock(i + 7, j + 1, k + 8, nullStone, 0, 2);
		world.setBlock(i + 7, j + 1, k + 9, nullStone, 0, 2);
		world.setBlock(i + 7, j + 2, k + 0, luminant_log, 0, 2);
		world.setBlock(i + 7, j + 2, k + 1, luminant_planks, 0, 2);
		world.setBlock(i + 7, j + 2, k + 2, luminant_planks, 0, 2);
		world.setBlock(i + 7, j + 2, k + 3, luminant_planks, 0, 2);
		world.setBlock(i + 7, j + 2, k + 4, luminant_planks, 0, 2);
		world.setBlock(i + 7, j + 2, k + 5, luminant_planks, 0, 2);
		world.setBlock(i + 7, j + 2, k + 6, nullStone, 0, 2);
		world.setBlock(i + 7, j + 2, k + 7, nullStone, 0, 2);
		world.setBlock(i + 7, j + 2, k + 8, nullStone, 0, 2);
		world.setBlock(i + 7, j + 2, k + 9, nullStone, 0, 2);
		world.setBlock(i + 7, j + 3, k + 0, luminant_log, 0, 2);
		world.setBlock(i + 7, j + 3, k + 1, luminant_planks, 0, 2);
		world.setBlock(i + 7, j + 3, k + 2, thinGlass, 0, 2);
		world.setBlock(i + 7, j + 3, k + 3, luminant_planks, 0, 2);
		world.setBlock(i + 7, j + 3, k + 4, thinGlass, 0, 2);
		world.setBlock(i + 7, j + 3, k + 5, luminant_planks, 0, 2);
		world.setBlock(i + 7, j + 3, k + 6, nullStone, 0, 2);
		world.setBlock(i + 7, j + 3, k + 7, nullStone, 0, 2);
		world.setBlock(i + 7, j + 3, k + 8, nullStone, 0, 2);
		world.setBlock(i + 7, j + 3, k + 9, nullStone, 0, 2);
		world.setBlock(i + 7, j + 4, k + 0, luminant_log, 0, 2);
		world.setBlock(i + 7, j + 4, k + 1, luminant_planks, 0, 2);
		world.setBlock(i + 7, j + 4, k + 2, luminant_planks, 0, 2);
		world.setBlock(i + 7, j + 4, k + 3, luminant_planks, 0, 2);
		world.setBlock(i + 7, j + 4, k + 4, luminant_planks, 0, 2);
		world.setBlock(i + 7, j + 4, k + 5, luminant_planks, 0, 2);
		world.setBlock(i + 7, j + 4, k + 6, nullStone, 0, 2);
		world.setBlock(i + 7, j + 4, k + 7, nullStone, 0, 2);
		world.setBlock(i + 7, j + 4, k + 8, nullStone, 0, 2);
		world.setBlock(i + 7, j + 4, k + 9, nullStone, 0, 2);
		world.setBlock(i + 7, j + 5, k + 0, luminant_log, 0, 2);
		world.setBlock(i + 7, j + 5, k + 1, nullStone, 0, 2);
		world.setBlock(i + 7, j + 5, k + 2, nullStone, 0, 2);
		world.setBlock(i + 7, j + 5, k + 3, nullStone, 0, 2);
		world.setBlock(i + 7, j + 5, k + 4, nullStone, 0, 2);
		world.setBlock(i + 7, j + 5, k + 5, nullStone, 0, 2);
		world.setBlock(i + 7, j + 5, k + 6, nullStone, 0, 2);
		world.setBlock(i + 7, j + 5, k + 7, nullStone, 0, 2);
		world.setBlock(i + 7, j + 5, k + 8, nullStone, 0, 2);
		world.setBlock(i + 7, j + 5, k + 9, nullStone, 0, 2);
		world.setBlock(i + 7, j + 6, k + 0, stoneSingleSlab, 0, 2);
		world.setBlock(i + 7, j + 6, k + 1, stoneSingleSlab, 0, 2);
		world.setBlock(i + 7, j + 6, k + 2, stoneSingleSlab, 0, 2);
		world.setBlock(i + 7, j + 6, k + 3, stoneSingleSlab, 0, 2);
		world.setBlock(i + 7, j + 6, k + 4, stoneSingleSlab, 0, 2);
		world.setBlock(i + 7, j + 6, k + 5, stoneSingleSlab, 0, 2);
		world.setBlock(i + 7, j + 6, k + 6, stoneSingleSlab, 0, 2);
		world.setBlock(i + 7, j + 6, k + 7, stoneSingleSlab, 0, 2);
		world.setBlock(i + 7, j + 6, k + 8, stoneSingleSlab, 0, 2);
		world.setBlock(i + 7, j + 6, k + 9, stoneSingleSlab, 0, 2);
		world.setBlock(i + 5, j + 3, k + 2, Blocks.stone_slab, 0, 2);
		world.setBlock(i + 6, j + 2, k + 7, lavaStill, 0, 2);
		world.setBlock(i + 6, j + 2, k + 8, lavaStill, 0, 2);
		
		for(int posX = i; posX <= i + 7; posX++)
			for(int posZ = k; posZ <= k + 9; posZ++){
				int posY = j;
					boolean isFloorFinished = false;
				while(isFloorFinished == false){					
					if(world.getBlock(posX, posY, posZ) == air || world.getBlock(posX, posY, posZ) == Blocks.tallgrass || world.getBlock(posX, posY, posZ) == Blocks.cactus || world.getBlock(posX, posY, posZ) == Blocks.red_flower || world.getBlock(posX, posY, posZ) == Blocks.yellow_flower || world.getBlock(posX, posY, posZ) == Blocks.deadbush || world.getBlock(posX, posY, posZ) == Blocks.snow || world.getBlock(posX, posY, posZ) == Blocks.water || world.getBlock(posX, posY, posZ) == Blocks.lava || world.getBlock(posX, posY, posZ) == Blocks.brown_mushroom || world.getBlock(posX, posY, posZ) == Blocks.red_mushroom || world.getBlock(posX, posY, posZ) == Blocks.waterlily){
						world.setBlock(posX, posY, posZ, nullStone, 0, 2);
						posY--;
					}
					else
						isFloorFinished = true;
				}
			}

			EntityIllagerTrader var5 = new EntityIllagerTrader(world);
			var5.setPosition(i+2, j+2, k+5);
			world.spawnEntityInWorld(var5);

			EntityIllagerTrader var6 = new EntityIllagerTrader(world);
			var6.setPosition(i+2, j+2, k+6);
			world.spawnEntityInWorld(var6);

		return true;
	}
	
	private ItemStack getBlacksmithLoot(Random random) {
		int item = random.nextInt(25);
		switch (item) {
			case 0:
				return new ItemStack(Items.iron_ingot, random.nextInt(5) + 11);
			case 1:
				return new ItemStack(Items.gold_ingot, random.nextInt(2) + 2);
			case 2:
				return new ItemStack(Items.coal, random.nextInt(12) + 18);
			case 3:
				return new ItemStack(Items.bucket, 1);
			case 4:
				return new ItemStack(Items.iron_helmet, 1);
			case 5:
				return new ItemStack(Items.iron_chestplate, 1);
			case 6:
				return new ItemStack(Items.iron_leggings, 1);
			case 7: 
				return new ItemStack(Items.iron_boots, 1);
			case 8: 
				return new ItemStack(NovaCraftItems.luminant_tree_sap, random.nextInt(7) + 5);
			case 9: 
				return new ItemStack(NovaCraftItems.brimstone_dust, random.nextInt(3) + 2);
			case 10: 
				return new ItemStack(NovaCraftItems.pherithium_scraps, random.nextInt(5) + 4);	
			case 11: 
				return new ItemStack(Items.chainmail_helmet, 1);	
			case 12: 
				return new ItemStack(Items.chainmail_chestplate, 1);	
			case 13: 
				return new ItemStack(Items.chainmail_leggings, 1);	
			case 14: 
				return new ItemStack(Items.chainmail_boots, 1);
			case 15: 
				return new ItemStack(Items.iron_pickaxe, 1);	
			case 16: 
				return new ItemStack(Items.iron_shovel, 1);	
			case 17: 
				return new ItemStack(Items.iron_axe, 1);	
			case 18: 
				return new ItemStack(Items.iron_sword, 1);
			case 19: 
				return new ItemStack(NovaCraftItems.pherithium_axe, 1);	
			case 20: 
				return new ItemStack(NovaCraftItems.pherithium_shovel, 1);
			case 21: 
				if (Configs.enableTreasureCratesDropDiamonds == true) {
					return new ItemStack(Items.diamond, 1);
				}
				else {
					return new ItemStack(NovaCraftItems.vanite_ingot, random.nextInt(8) + 8);
				}
			case 22:
				return new ItemStack(NovaCraftItems.pherithium_pickaxe, 1);
			default: {
				return new ItemStack(NovaCraftItems.vanite_ingot, random.nextInt(8) + 8);
			}
		}
	}

}