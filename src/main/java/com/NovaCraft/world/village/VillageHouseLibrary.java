package com.NovaCraft.world.village;

import java.util.Random;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.registry.OtherModBlocks;
import com.NovaCraftBlocks.NovaCraftBlocks;

import cpw.mods.fml.common.Loader;
import net.minecraft.block.Block;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class VillageHouseLibrary extends WorldGenerator
{
	private static final Block GrimstoneBrick = NovaCraftBlocks.grimstone_bricks;
	private static final Block bookshelf = Blocks.bookshelf;
	private static final Block ironBars = Blocks.iron_bars;
	private static final Block NullstoneBrick = NovaCraftBlocks.nullstone_bricks;
	private static final Block fence = Blocks.iron_bars;
	private static final Block doorWood = Blocks.iron_door;
	private static final Block oak_stairs = NovaCraftBlocks.nullstone_brick_stairs;
	private static final Block pressurePlateGrimstoneBrick = Blocks.stone_slab;
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

	public VillageHouseLibrary() { }
	
	public boolean checkAllLocations(World world, int i, int j, int k){
		if(!LocationIsValidSpawn(world, i, j, k) || !LocationIsValidSpawn(world, i + 8, j, k) || !LocationIsValidSpawn(world, i + 8, j, k + 8) || !LocationIsValidSpawn(world, i, j, k + 8) || !AirLocationIsValidSpawn(world, i, j + 7, k) || !AirLocationIsValidSpawn(world, i + 8, j + 7, k) || !AirLocationIsValidSpawn(world, i + 8, j + 7, k + 8) || !AirLocationIsValidSpawn(world, i, j + 7, k + 8))
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
		if(!LocationIsValidSpawn(world, i, j, k) || !LocationIsValidSpawn(world, i + 8, j, k) || !LocationIsValidSpawn(world, i + 8, j, k + 8) || !LocationIsValidSpawn(world, i, j, k + 8) || !AirLocationIsValidSpawn(world, i, j + 7, k) || !AirLocationIsValidSpawn(world, i + 8, j + 7, k) || !AirLocationIsValidSpawn(world, i + 8, j + 7, k + 8) || !AirLocationIsValidSpawn(world, i, j + 7, k + 8))
		{
			return false;
		}

		world.setBlock(i + 0, j + 1, k + 0, air);
		world.setBlock(i + 0, j + 1, k + 1, air);
		world.setBlock(i + 0, j + 1, k + 2, air);
		world.setBlock(i + 0, j + 1, k + 3, air);
		world.setBlock(i + 0, j + 1, k + 4, air);
		world.setBlock(i + 0, j + 1, k + 5, air);
		world.setBlock(i + 0, j + 1, k + 6, air);
		world.setBlock(i + 0, j + 1, k + 7, air);
		world.setBlock(i + 0, j + 1, k + 8, air);
		world.setBlock(i + 0, j + 2, k + 0, air);
		world.setBlock(i + 0, j + 2, k + 1, air);
		world.setBlock(i + 0, j + 2, k + 2, air);
		world.setBlock(i + 0, j + 2, k + 3, air);
		world.setBlock(i + 0, j + 2, k + 4, air);
		world.setBlock(i + 0, j + 2, k + 5, air);
		world.setBlock(i + 0, j + 2, k + 6, air);
		world.setBlock(i + 0, j + 2, k + 7, air);
		world.setBlock(i + 0, j + 2, k + 8, air);
		world.setBlock(i + 0, j + 3, k + 0, air);
		world.setBlock(i + 0, j + 3, k + 1, air);
		world.setBlock(i + 0, j + 3, k + 2, air);
		world.setBlock(i + 0, j + 3, k + 3, air);
		world.setBlock(i + 0, j + 3, k + 4, air);
		world.setBlock(i + 0, j + 3, k + 5, air);
		world.setBlock(i + 0, j + 3, k + 6, air);
		world.setBlock(i + 0, j + 3, k + 7, air);
		world.setBlock(i + 0, j + 3, k + 8, air);
		world.setBlock(i + 0, j + 4, k + 0, air);
		world.setBlock(i + 0, j + 4, k + 1, air);
		world.setBlock(i + 0, j + 4, k + 2, air);
		world.setBlock(i + 0, j + 4, k + 3, air);
		world.setBlock(i + 0, j + 4, k + 4, air);
		world.setBlock(i + 0, j + 4, k + 5, air);
		world.setBlock(i + 0, j + 4, k + 6, air);
		world.setBlock(i + 0, j + 4, k + 7, air);
		world.setBlock(i + 0, j + 4, k + 8, air);
		world.setBlock(i + 0, j + 5, k + 0, air);
		world.setBlock(i + 0, j + 5, k + 1, air);
		world.setBlock(i + 0, j + 5, k + 2, air);
		world.setBlock(i + 0, j + 5, k + 3, air);
		world.setBlock(i + 0, j + 5, k + 4, air);
		world.setBlock(i + 0, j + 5, k + 5, air);
		world.setBlock(i + 0, j + 5, k + 6, air);
		world.setBlock(i + 0, j + 5, k + 7, air);
		world.setBlock(i + 0, j + 5, k + 8, air);
		world.setBlock(i + 0, j + 6, k + 0, air);
		world.setBlock(i + 0, j + 6, k + 1, air);
		world.setBlock(i + 0, j + 6, k + 2, air);
		world.setBlock(i + 0, j + 6, k + 3, air);
		world.setBlock(i + 0, j + 6, k + 4, air);
		world.setBlock(i + 0, j + 6, k + 5, air);
		world.setBlock(i + 0, j + 6, k + 6, air);
		world.setBlock(i + 0, j + 6, k + 7, air);
		world.setBlock(i + 0, j + 6, k + 8, air);
		world.setBlock(i + 0, j + 7, k + 0, air);
		world.setBlock(i + 0, j + 7, k + 1, air);
		world.setBlock(i + 0, j + 7, k + 2, air);
		world.setBlock(i + 0, j + 7, k + 3, air);
		world.setBlock(i + 0, j + 7, k + 4, air);
		world.setBlock(i + 0, j + 7, k + 5, air);
		world.setBlock(i + 0, j + 7, k + 6, air);
		world.setBlock(i + 0, j + 7, k + 7, air);
		world.setBlock(i + 0, j + 7, k + 8, air);
		world.setBlock(i + 0, j + 8, k + 0, air);
		world.setBlock(i + 0, j + 8, k + 1, air);
		world.setBlock(i + 0, j + 8, k + 2, air);
		world.setBlock(i + 0, j + 8, k + 3, air);
		world.setBlock(i + 0, j + 8, k + 4, air);
		world.setBlock(i + 0, j + 8, k + 5, air);
		world.setBlock(i + 0, j + 8, k + 6, air);
		world.setBlock(i + 0, j + 8, k + 7, air);
		world.setBlock(i + 0, j + 8, k + 8, air);
		world.setBlock(i + 0, j + 9, k + 0, air);
		world.setBlock(i + 0, j + 9, k + 1, air);
		world.setBlock(i + 0, j + 9, k + 2, air);
		world.setBlock(i + 0, j + 9, k + 3, air);
		world.setBlock(i + 0, j + 9, k + 4, air);
		world.setBlock(i + 0, j + 9, k + 5, air);
		world.setBlock(i + 0, j + 9, k + 6, air);
		world.setBlock(i + 0, j + 9, k + 7, air);
		world.setBlock(i + 0, j + 9, k + 8, air);
		world.setBlock(i + 1, j + 1, k + 0, air);
		world.setBlock(i + 1, j + 1, k + 1, air);
		world.setBlock(i + 1, j + 1, k + 2, air);
		world.setBlock(i + 1, j + 1, k + 3, air);
		world.setBlock(i + 1, j + 1, k + 4, air);
		world.setBlock(i + 1, j + 1, k + 5, air);
		world.setBlock(i + 1, j + 1, k + 6, air);
		world.setBlock(i + 1, j + 1, k + 7, air);
		world.setBlock(i + 1, j + 1, k + 8, air);
		world.setBlock(i + 1, j + 2, k + 0, air);
		world.setBlock(i + 1, j + 2, k + 1, air);
		world.setBlock(i + 1, j + 2, k + 2, air);
		world.setBlock(i + 1, j + 2, k + 3, air);
		world.setBlock(i + 1, j + 2, k + 4, air);
		world.setBlock(i + 1, j + 2, k + 5, air);
		world.setBlock(i + 1, j + 2, k + 6, air);
		world.setBlock(i + 1, j + 2, k + 7, air);
		world.setBlock(i + 1, j + 2, k + 8, air);
		world.setBlock(i + 1, j + 3, k + 0, air);
		world.setBlock(i + 1, j + 3, k + 1, air);
		world.setBlock(i + 1, j + 3, k + 2, air);
		world.setBlock(i + 1, j + 3, k + 3, air);
		world.setBlock(i + 1, j + 3, k + 4, air);
		world.setBlock(i + 1, j + 3, k + 5, air);
		world.setBlock(i + 1, j + 3, k + 6, air);
		world.setBlock(i + 1, j + 3, k + 7, air);
		world.setBlock(i + 1, j + 3, k + 8, air);
		world.setBlock(i + 1, j + 4, k + 0, air);
		world.setBlock(i + 1, j + 4, k + 1, air);
		world.setBlock(i + 1, j + 4, k + 2, air);
		world.setBlock(i + 1, j + 4, k + 3, air);
		world.setBlock(i + 1, j + 4, k + 4, air);
		world.setBlock(i + 1, j + 4, k + 5, air);
		world.setBlock(i + 1, j + 4, k + 6, air);
		world.setBlock(i + 1, j + 4, k + 7, air);
		world.setBlock(i + 1, j + 4, k + 8, air);
		world.setBlock(i + 1, j + 5, k + 0, air);
		world.setBlock(i + 1, j + 5, k + 1, air);
		world.setBlock(i + 1, j + 5, k + 2, air);
		world.setBlock(i + 1, j + 5, k + 3, air);
		world.setBlock(i + 1, j + 5, k + 4, air);
		world.setBlock(i + 1, j + 5, k + 5, air);
		world.setBlock(i + 1, j + 5, k + 6, air);
		world.setBlock(i + 1, j + 5, k + 7, air);
		world.setBlock(i + 1, j + 5, k + 8, air);
		world.setBlock(i + 1, j + 6, k + 0, NovaCraftBlocks.nullstone_brick_stairs, 0 , 2);
		world.setBlock(i + 1, j + 6, k + 1, NovaCraftBlocks.nullstone_brick_stairs, 0 , 2);
		world.setBlock(i + 1, j + 6, k + 2, NovaCraftBlocks.nullstone_brick_stairs, 0 , 2);
		world.setBlock(i + 1, j + 6, k + 3, NovaCraftBlocks.nullstone_brick_stairs, 0 , 2);
		world.setBlock(i + 1, j + 6, k + 4, NovaCraftBlocks.nullstone_brick_stairs, 0 , 2);
		world.setBlock(i + 1, j + 6, k + 5, NovaCraftBlocks.nullstone_brick_stairs, 0 , 2);
		world.setBlock(i + 1, j + 6, k + 6, NovaCraftBlocks.nullstone_brick_stairs, 0 , 2);
		world.setBlock(i + 1, j + 6, k + 7, NovaCraftBlocks.nullstone_brick_stairs, 0 , 2);
		world.setBlock(i + 1, j + 6, k + 8, NovaCraftBlocks.nullstone_brick_stairs, 0 , 2);
		world.setBlock(i + 1, j + 7, k + 0, air);
		world.setBlock(i + 1, j + 7, k + 1, air);
		world.setBlock(i + 1, j + 7, k + 2, air);
		world.setBlock(i + 1, j + 7, k + 3, air);
		world.setBlock(i + 1, j + 7, k + 4, air);
		world.setBlock(i + 1, j + 7, k + 5, air);
		world.setBlock(i + 1, j + 7, k + 6, air);
		world.setBlock(i + 1, j + 7, k + 7, air);
		world.setBlock(i + 1, j + 7, k + 8, air);
		world.setBlock(i + 1, j + 8, k + 0, air);
		world.setBlock(i + 1, j + 8, k + 1, air);
		world.setBlock(i + 1, j + 8, k + 2, air);
		world.setBlock(i + 1, j + 8, k + 3, air);
		world.setBlock(i + 1, j + 8, k + 4, air);
		world.setBlock(i + 1, j + 8, k + 5, air);
		world.setBlock(i + 1, j + 8, k + 6, air);
		world.setBlock(i + 1, j + 8, k + 7, air);
		world.setBlock(i + 1, j + 8, k + 8, air);
		world.setBlock(i + 1, j + 9, k + 0, air);
		world.setBlock(i + 1, j + 9, k + 1, air);
		world.setBlock(i + 1, j + 9, k + 2, air);
		world.setBlock(i + 1, j + 9, k + 3, air);
		world.setBlock(i + 1, j + 9, k + 4, air);
		world.setBlock(i + 1, j + 9, k + 5, air);
		world.setBlock(i + 1, j + 9, k + 6, air);
		world.setBlock(i + 1, j + 9, k + 7, air);
		world.setBlock(i + 1, j + 9, k + 8, air);
		world.setBlock(i + 2, j + 1, k + 0, NullstoneBrick, 0 , 2);
		world.setBlock(i + 2, j + 1, k + 1, NullstoneBrick, 0 , 2);
		world.setBlock(i + 2, j + 1, k + 2, NullstoneBrick, 0 , 2);
		world.setBlock(i + 2, j + 1, k + 3, NullstoneBrick, 0 , 2);
		world.setBlock(i + 2, j + 1, k + 4, NullstoneBrick, 0 , 2);
		world.setBlock(i + 2, j + 1, k + 5, NullstoneBrick, 0 , 2);
		world.setBlock(i + 2, j + 1, k + 6, NullstoneBrick, 0 , 2);
		world.setBlock(i + 2, j + 1, k + 7, NullstoneBrick, 0 , 2);
		world.setBlock(i + 2, j + 1, k + 8, NullstoneBrick, 0 , 2);
		world.setBlock(i + 2, j + 2, k + 0, NullstoneBrick, 0 , 2);
		world.setBlock(i + 2, j + 2, k + 1, NullstoneBrick, 0 , 2);
		world.setBlock(i + 2, j + 2, k + 2, NullstoneBrick, 0 , 2);
		world.setBlock(i + 2, j + 2, k + 3, NullstoneBrick, 0 , 2);
		world.setBlock(i + 2, j + 2, k + 4, NullstoneBrick, 0 , 2);
		world.setBlock(i + 2, j + 2, k + 5, NullstoneBrick, 0 , 2);
		world.setBlock(i + 2, j + 2, k + 6, NullstoneBrick, 0 , 2);
		world.setBlock(i + 2, j + 2, k + 7, NullstoneBrick, 0 , 2);
		world.setBlock(i + 2, j + 2, k + 8, NullstoneBrick, 0 , 2);
		world.setBlock(i + 2, j + 3, k + 0, NullstoneBrick, 0 , 2);
		world.setBlock(i + 2, j + 3, k + 1, NovaCraftBlocks.grimstone_bricks, 0 , 2);
		world.setBlock(i + 2, j + 3, k + 2, NovaCraftBlocks.vanite_glass, 0 , 2); //iron
		world.setBlock(i + 2, j + 3, k + 3, NovaCraftBlocks.vanite_glass, 0 , 2); //iron
		world.setBlock(i + 2, j + 3, k + 4, NovaCraftBlocks.grimstone_bricks, 0 , 2);
		world.setBlock(i + 2, j + 3, k + 5, NovaCraftBlocks.vanite_glass, 0 , 2); //iron
		world.setBlock(i + 2, j + 3, k + 6, NovaCraftBlocks.vanite_glass, 0 , 2); //iron
		world.setBlock(i + 2, j + 3, k + 7, NovaCraftBlocks.grimstone_bricks, 0 , 2);
		world.setBlock(i + 2, j + 3, k + 8, NullstoneBrick, 0 , 2);
		world.setBlock(i + 2, j + 4, k + 0, NullstoneBrick, 0 , 2);
		world.setBlock(i + 2, j + 4, k + 1, NovaCraftBlocks.grimstone_bricks, 0 , 2);
		world.setBlock(i + 2, j + 4, k + 2, NovaCraftBlocks.grimstone_bricks, 0 , 2);
		world.setBlock(i + 2, j + 4, k + 3, NovaCraftBlocks.grimstone_bricks, 0 , 2);
		world.setBlock(i + 2, j + 4, k + 4, NovaCraftBlocks.grimstone_bricks, 0 , 2);
		world.setBlock(i + 2, j + 4, k + 5, NovaCraftBlocks.grimstone_bricks, 0 , 2);
		world.setBlock(i + 2, j + 4, k + 6, NovaCraftBlocks.grimstone_bricks, 0 , 2);
		world.setBlock(i + 2, j + 4, k + 7, NovaCraftBlocks.grimstone_bricks, 0 , 2);
		world.setBlock(i + 2, j + 4, k + 8, NullstoneBrick, 0 , 2);
		world.setBlock(i + 2, j + 5, k + 0, NullstoneBrick, 0 , 2);
		world.setBlock(i + 2, j + 5, k + 1, NovaCraftBlocks.grimstone_bricks, 0 , 2);
		world.setBlock(i + 2, j + 5, k + 2, NovaCraftBlocks.grimstone_bricks, 0 , 2);
		world.setBlock(i + 2, j + 5, k + 3, NovaCraftBlocks.grimstone_bricks, 0 , 2);
		world.setBlock(i + 2, j + 5, k + 4, NovaCraftBlocks.grimstone_bricks, 0 , 2);
		world.setBlock(i + 2, j + 5, k + 5, NovaCraftBlocks.grimstone_bricks, 0 , 2);
		world.setBlock(i + 2, j + 5, k + 6, NovaCraftBlocks.grimstone_bricks, 0 , 2);
		world.setBlock(i + 2, j + 5, k + 7, NovaCraftBlocks.grimstone_bricks, 0 , 2);
		world.setBlock(i + 2, j + 5, k + 8, NullstoneBrick, 0 , 2);
		world.setBlock(i + 2, j + 6, k + 0, NullstoneBrick, 0 , 2);
		world.setBlock(i + 2, j + 6, k + 1, NullstoneBrick, 0 , 2);
		world.setBlock(i + 2, j + 6, k + 2, NullstoneBrick, 0 , 2);
		world.setBlock(i + 2, j + 6, k + 3, NullstoneBrick, 0 , 2);
		world.setBlock(i + 2, j + 6, k + 4, NullstoneBrick, 0 , 2);
		world.setBlock(i + 2, j + 6, k + 5, NullstoneBrick, 0 , 2);
		world.setBlock(i + 2, j + 6, k + 6, NullstoneBrick, 0 , 2);
		world.setBlock(i + 2, j + 6, k + 7, NullstoneBrick, 0 , 2);
		world.setBlock(i + 2, j + 6, k + 8, NullstoneBrick, 0 , 2);
		world.setBlock(i + 2, j + 7, k + 0, NovaCraftBlocks.nullstone_brick_stairs, 0 , 2);
		world.setBlock(i + 2, j + 7, k + 1, NovaCraftBlocks.nullstone_brick_stairs, 0 , 2);
		world.setBlock(i + 2, j + 7, k + 2, NovaCraftBlocks.nullstone_brick_stairs, 0 , 2);
		world.setBlock(i + 2, j + 7, k + 3, NovaCraftBlocks.nullstone_brick_stairs, 0 , 2);
		world.setBlock(i + 2, j + 7, k + 4, NovaCraftBlocks.nullstone_brick_stairs, 0 , 2);
		world.setBlock(i + 2, j + 7, k + 5, NovaCraftBlocks.nullstone_brick_stairs, 0 , 2);
		world.setBlock(i + 2, j + 7, k + 6, NovaCraftBlocks.nullstone_brick_stairs, 0 , 2);
		world.setBlock(i + 2, j + 7, k + 7, NovaCraftBlocks.nullstone_brick_stairs, 0 , 2);
		world.setBlock(i + 2, j + 7, k + 8, NovaCraftBlocks.nullstone_brick_stairs, 0 , 2);
		world.setBlock(i + 2, j + 8, k + 0, air);
		world.setBlock(i + 2, j + 8, k + 1, air);
		world.setBlock(i + 2, j + 8, k + 2, air);
		world.setBlock(i + 2, j + 8, k + 3, air);
		world.setBlock(i + 2, j + 8, k + 4, air);
		world.setBlock(i + 2, j + 8, k + 5, air);
		world.setBlock(i + 2, j + 8, k + 6, air);
		world.setBlock(i + 2, j + 8, k + 7, air);
		world.setBlock(i + 2, j + 8, k + 8, air);
		world.setBlock(i + 2, j + 9, k + 0, air);
		world.setBlock(i + 2, j + 9, k + 1, air);
		world.setBlock(i + 2, j + 9, k + 2, air);
		world.setBlock(i + 2, j + 9, k + 3, air);
		world.setBlock(i + 2, j + 9, k + 4, air);
		world.setBlock(i + 2, j + 9, k + 5, air);
		world.setBlock(i + 2, j + 9, k + 6, air);
		world.setBlock(i + 2, j + 9, k + 7, air);
		world.setBlock(i + 2, j + 9, k + 8, air);
		world.setBlock(i + 3, j + 1, k + 0, NullstoneBrick, 0 , 2);
		world.setBlock(i + 3, j + 1, k + 1, NullstoneBrick, 0 , 2);
		world.setBlock(i + 3, j + 1, k + 2, NullstoneBrick, 0 , 2);
		world.setBlock(i + 3, j + 1, k + 3, NullstoneBrick, 0 , 2);
		world.setBlock(i + 3, j + 1, k + 4, NullstoneBrick, 0 , 2);
		world.setBlock(i + 3, j + 1, k + 5, NullstoneBrick, 0 , 2);
		world.setBlock(i + 3, j + 1, k + 6, NullstoneBrick, 0 , 2);
		world.setBlock(i + 3, j + 1, k + 7, NullstoneBrick, 0 , 2);
		world.setBlock(i + 3, j + 1, k + 8, NullstoneBrick, 0 , 2);
		world.setBlock(i + 3, j + 2, k + 0, NullstoneBrick, 0 , 2);
		world.setBlock(i + 3, j + 2, k + 1, air);
		world.setBlock(i + 3, j + 2, k + 2, air);
		//world.setBlock(i + 3, j + 2, k + 3, NovaCraftBlocks.nullstone_brick_stairs, 1 , 2);
		//world.setBlock(i + 3, j + 2, k + 4, NovaCraftBlocks.nullstone_brick_stairs, 1 , 2);
		//world.setBlock(i + 3, j + 2, k + 5, NovaCraftBlocks.nullstone_brick_stairs, 1 , 2);
		//world.setBlock(i + 3, j + 2, k + 6, NovaCraftBlocks.nullstone_brick_stairs, 1 , 2);
		world.setBlock(i + 3, j + 2, k + 7, NovaCraftBlocks.grimstone_bricks, 0 , 2);
		world.setBlock(i + 3, j + 3, k + 7, Blocks.chest, 0 , 5);
		
		TileEntityChest chest = new TileEntityChest();
		world.setTileEntity(i + 3, j + 3, k + 7, chest);
		for(int slot = 0; slot < chest.getSizeInventory(); slot++){
			int num = rand.nextInt(100);
			int rand2 = (int)(1 + Math.random() * 3);
			if(num == 0)
				chest.setInventorySlotContents(slot, new ItemStack(Items.iron_shovel));
			else if(num == 1)
				chest.setInventorySlotContents(slot, new ItemStack(NovaCraftItems.raw_glow_squid, 1 + rand2));
			else if(num == 2)
				chest.setInventorySlotContents(slot, new ItemStack(NovaCraftBlocks.sculk_block, 3 + rand2));
			else if(num == 3)
				chest.setInventorySlotContents(slot, new ItemStack(Items.bucket));
			else if(num == 4)
				chest.setInventorySlotContents(slot, new ItemStack(NovaCraftBlocks.sculk_vein, 8 + rand2));
			else if(num == 5)
				chest.setInventorySlotContents(slot, new ItemStack(NovaCraftBlocks.sculk_growth, 8 + rand2));
			else if(num == 6)
				chest.setInventorySlotContents(slot, new ItemStack(Items.rotten_flesh, 4 + rand2));
			else if(num == 7)
				chest.setInventorySlotContents(slot, new ItemStack(Items.iron_axe));
			else if(num == 8)
				chest.setInventorySlotContents(slot, new ItemStack(NovaCraftBlocks.sculk_bush, 1 + rand2));
			else if(num == 9)
				chest.setInventorySlotContents(slot, new ItemStack(NovaCraftItems.sculk_flesh, 2 + rand2));
			else if(num == 10)
				chest.setInventorySlotContents(slot, new ItemStack(NovaCraftItems.eerie_sword));
		}	
		
		world.setBlock(i + 3, j + 2, k + 8, NullstoneBrick, 0 , 2);
		world.setBlock(i + 3, j + 3, k + 0, NovaCraftBlocks.grimstone_bricks, 0 , 2);
		world.setBlock(i + 3, j + 3, k + 1, air);
		world.setBlock(i + 3, j + 3, k + 2, air);
		world.setBlock(i + 3, j + 3, k + 3, air);
		world.setBlock(i + 3, j + 3, k + 4, air);
		world.setBlock(i + 3, j + 3, k + 5, air);
		world.setBlock(i + 3, j + 3, k + 6, air);
		//world.setBlock(i + 3, j + 3, k + 7, air);
		world.setBlock(i + 3, j + 3, k + 8, NovaCraftBlocks.grimstone_bricks, 0 , 2);
		world.setBlock(i + 3, j + 4, k + 0, NovaCraftBlocks.grimstone_bricks, 0 , 2);
		//world.setBlock(i + 3, j + 4, k + 1, Blocks.bookshelf, 0 , 2);
		//world.setBlock(i + 3, j + 4, k + 2, Blocks.bookshelf, 0 , 2);
		//world.setBlock(i + 3, j + 4, k + 3, Blocks.bookshelf, 0 , 2);
		//world.setBlock(i + 3, j + 4, k + 4, Blocks.bookshelf, 0 , 2);
		//world.setBlock(i + 3, j + 4, k + 5, Blocks.bookshelf, 0 , 2);
		//world.setBlock(i + 3, j + 4, k + 6, Blocks.bookshelf, 0 , 2);
		//world.setBlock(i + 3, j + 4, k + 7, Blocks.bookshelf, 0 , 2);
		world.setBlock(i + 3, j + 4, k + 8, NovaCraftBlocks.grimstone_bricks, 0 , 2);
		world.setBlock(i + 3, j + 5, k + 0, NovaCraftBlocks.grimstone_bricks, 0 , 2);
		world.setBlock(i + 3, j + 5, k + 1, NovaCraftBlocks.grimstone_bricks, 0 , 2);
		world.setBlock(i + 3, j + 5, k + 2, NovaCraftBlocks.grimstone_bricks, 0 , 2);
		world.setBlock(i + 3, j + 5, k + 3, NovaCraftBlocks.grimstone_bricks, 0 , 2);
		world.setBlock(i + 3, j + 5, k + 4, NovaCraftBlocks.grimstone_bricks, 0 , 2);
		world.setBlock(i + 3, j + 5, k + 5, NovaCraftBlocks.grimstone_bricks, 0 , 2);
		world.setBlock(i + 3, j + 5, k + 6, NovaCraftBlocks.grimstone_bricks, 0 , 2);
		world.setBlock(i + 3, j + 5, k + 7, NovaCraftBlocks.grimstone_bricks, 0 , 2);
		world.setBlock(i + 3, j + 5, k + 8, NovaCraftBlocks.grimstone_bricks, 0 , 2);
		world.setBlock(i + 3, j + 6, k + 0, NullstoneBrick, 0 , 2);
		world.setBlock(i + 3, j + 6, k + 1, NullstoneBrick, 0 , 2);
		world.setBlock(i + 3, j + 6, k + 2, NullstoneBrick, 0 , 2);
		world.setBlock(i + 3, j + 6, k + 3, NullstoneBrick, 0 , 2);
		world.setBlock(i + 3, j + 6, k + 4, NullstoneBrick, 0 , 2);
		world.setBlock(i + 3, j + 6, k + 5, NullstoneBrick, 0 , 2);
		world.setBlock(i + 3, j + 6, k + 6, NullstoneBrick, 0 , 2);
		world.setBlock(i + 3, j + 6, k + 7, NullstoneBrick, 0 , 2);
		world.setBlock(i + 3, j + 6, k + 8, NullstoneBrick, 0 , 2);
		world.setBlock(i + 3, j + 7, k + 0, NullstoneBrick, 0 , 2);
		world.setBlock(i + 3, j + 7, k + 1, NullstoneBrick, 0 , 2);
		world.setBlock(i + 3, j + 7, k + 2, NullstoneBrick, 0 , 2);
		world.setBlock(i + 3, j + 7, k + 3, NullstoneBrick, 0 , 2);
		world.setBlock(i + 3, j + 7, k + 4, NullstoneBrick, 0 , 2);
		world.setBlock(i + 3, j + 7, k + 5, NullstoneBrick, 0 , 2);
		world.setBlock(i + 3, j + 7, k + 6, NullstoneBrick, 0 , 2);
		world.setBlock(i + 3, j + 7, k + 7, NullstoneBrick, 0 , 2);
		world.setBlock(i + 3, j + 7, k + 8, NullstoneBrick, 0 , 2);
		world.setBlock(i + 3, j + 8, k + 0, NovaCraftBlocks.nullstone_brick_stairs, 0 , 2);
		world.setBlock(i + 3, j + 8, k + 1, NovaCraftBlocks.nullstone_brick_stairs, 0 , 2);
		world.setBlock(i + 3, j + 8, k + 2, NovaCraftBlocks.nullstone_brick_stairs, 0 , 2);
		world.setBlock(i + 3, j + 8, k + 3, NovaCraftBlocks.nullstone_brick_stairs, 0 , 2);
		world.setBlock(i + 3, j + 8, k + 4, NovaCraftBlocks.nullstone_brick_stairs, 0 , 2);
		world.setBlock(i + 3, j + 8, k + 5, NovaCraftBlocks.nullstone_brick_stairs, 0 , 2);
		world.setBlock(i + 3, j + 8, k + 6, NovaCraftBlocks.nullstone_brick_stairs, 0 , 2);
		world.setBlock(i + 3, j + 8, k + 7, NovaCraftBlocks.nullstone_brick_stairs, 0 , 2);
		world.setBlock(i + 3, j + 8, k + 8, NovaCraftBlocks.nullstone_brick_stairs, 0 , 2);
		world.setBlock(i + 3, j + 9, k + 0, air);
		world.setBlock(i + 3, j + 9, k + 1, air);
		world.setBlock(i + 3, j + 9, k + 2, air);
		world.setBlock(i + 3, j + 9, k + 3, air);
		world.setBlock(i + 3, j + 9, k + 4, air);
		world.setBlock(i + 3, j + 9, k + 5, air);
		world.setBlock(i + 3, j + 9, k + 6, air);
		world.setBlock(i + 3, j + 9, k + 7, air);
		world.setBlock(i + 3, j + 9, k + 8, air);
		world.setBlock(i + 4, j + 1, k + 0, NullstoneBrick, 0 , 2);
		world.setBlock(i + 4, j + 1, k + 1, NullstoneBrick, 0 , 2);
		world.setBlock(i + 4, j + 1, k + 2, NullstoneBrick, 0 , 2);
		world.setBlock(i + 4, j + 1, k + 3, NullstoneBrick, 0 , 2);
		world.setBlock(i + 4, j + 1, k + 4, NullstoneBrick, 0 , 2);
		world.setBlock(i + 4, j + 1, k + 5, NullstoneBrick, 0 , 2);
		world.setBlock(i + 4, j + 1, k + 6, NullstoneBrick, 0 , 2);
		world.setBlock(i + 4, j + 1, k + 7, NullstoneBrick, 0 , 2);
		world.setBlock(i + 4, j + 1, k + 8, NullstoneBrick, 0 , 2);
		world.setBlock(i + 4, j + 2, k + 0, NullstoneBrick, 0 , 2);
		world.setBlock(i + 4, j + 2, k + 1, air);
		world.setBlock(i + 4, j + 2, k + 2, air);
		world.setBlock(i + 4, j + 2, k + 3, air);
		world.setBlock(i + 4, j + 2, k + 4, Blocks.iron_bars, 0 , 2);
		world.setBlock(i + 4, j + 2, k + 5, air);
		world.setBlock(i + 4, j + 2, k + 6, Blocks.iron_bars, 0 , 2);
		world.setBlock(i + 4, j + 2, k + 7, NovaCraftBlocks.nullstone_brick_stairs, 2 , 2);
		world.setBlock(i + 4, j + 2, k + 8, NullstoneBrick, 0 , 2);
		world.setBlock(i + 4, j + 3, k + 0, NovaCraftBlocks.vanite_glass, 0 , 2);
		world.setBlock(i + 4, j + 3, k + 1, air);
		world.setBlock(i + 4, j + 3, k + 2, air);
		world.setBlock(i + 4, j + 3, k + 3, air);
		world.setBlock(i + 4, j + 3, k + 5, air);
		world.setBlock(i + 4, j + 3, k + 7, air);
		world.setBlock(i + 4, j + 3, k + 8, NovaCraftBlocks.vanite_glass, 0 , 2);
		world.setBlock(i + 4, j + 4, k + 0, NovaCraftBlocks.vanite_glass, 0 , 2);
		world.setBlock(i + 4, j + 4, k + 1, air);
		world.setBlock(i + 4, j + 4, k + 2, air);
		world.setBlock(i + 4, j + 4, k + 3, air);
		world.setBlock(i + 4, j + 4, k + 4, air);
		world.setBlock(i + 4, j + 4, k + 5, air);
		world.setBlock(i + 4, j + 4, k + 6, air);
		world.setBlock(i + 4, j + 4, k + 7, air);
		world.setBlock(i + 4, j + 4, k + 8, NovaCraftBlocks.vanite_glass, 0 , 2);
		world.setBlock(i + 4, j + 5, k + 0, NovaCraftBlocks.grimstone_bricks, 0 , 2);
		world.setBlock(i + 4, j + 5, k + 1, air);
		world.setBlock(i + 4, j + 5, k + 2, air);
		world.setBlock(i + 4, j + 5, k + 3, air);
		world.setBlock(i + 4, j + 5, k + 4, air);
		world.setBlock(i + 4, j + 5, k + 5, air);
		world.setBlock(i + 4, j + 5, k + 6, air);
		world.setBlock(i + 4, j + 5, k + 7, air);
		world.setBlock(i + 4, j + 5, k + 8, NovaCraftBlocks.grimstone_bricks, 0 , 2);
		world.setBlock(i + 4, j + 6, k + 0, NullstoneBrick, 0 , 2);
		world.setBlock(i + 4, j + 6, k + 1, NullstoneBrick, 0 , 2);
		world.setBlock(i + 4, j + 6, k + 2, NullstoneBrick, 0 , 2);
		world.setBlock(i + 4, j + 6, k + 3, NullstoneBrick, 0 , 2);
		world.setBlock(i + 4, j + 6, k + 4, NullstoneBrick, 0 , 2);
		world.setBlock(i + 4, j + 6, k + 5, NullstoneBrick, 0 , 2);
		world.setBlock(i + 4, j + 6, k + 6, NullstoneBrick, 0 , 2);
		world.setBlock(i + 4, j + 6, k + 7, NullstoneBrick, 0 , 2);
		world.setBlock(i + 4, j + 6, k + 8, NullstoneBrick, 0 , 2);
		world.setBlock(i + 4, j + 7, k + 0, NullstoneBrick, 0 , 2);
		world.setBlock(i + 4, j + 7, k + 1, NullstoneBrick, 0 , 2);
		world.setBlock(i + 4, j + 7, k + 2, NullstoneBrick, 0 , 2);
		world.setBlock(i + 4, j + 7, k + 3, NullstoneBrick, 0 , 2);
		world.setBlock(i + 4, j + 7, k + 4, NullstoneBrick, 0 , 2);
		world.setBlock(i + 4, j + 7, k + 5, NullstoneBrick, 0 , 2);
		world.setBlock(i + 4, j + 7, k + 6, NullstoneBrick, 0 , 2);
		world.setBlock(i + 4, j + 7, k + 7, NullstoneBrick, 0 , 2);
		world.setBlock(i + 4, j + 7, k + 8, NullstoneBrick, 0 , 2);
		world.setBlock(i + 4, j + 8, k + 0, NullstoneBrick, 0 , 2);
		world.setBlock(i + 4, j + 8, k + 1, NullstoneBrick, 0 , 2);
		world.setBlock(i + 4, j + 8, k + 2, NullstoneBrick, 0 , 2);
		world.setBlock(i + 4, j + 8, k + 3, NullstoneBrick, 0 , 2);
		world.setBlock(i + 4, j + 8, k + 4, NullstoneBrick, 0 , 2);
		world.setBlock(i + 4, j + 8, k + 5, NullstoneBrick, 0 , 2);
		world.setBlock(i + 4, j + 8, k + 6, NullstoneBrick, 0 , 2);
		world.setBlock(i + 4, j + 8, k + 7, NullstoneBrick, 0 , 2);
		world.setBlock(i + 4, j + 8, k + 8, NullstoneBrick, 0 , 2);
		world.setBlock(i + 4, j + 9, k + 0, NovaCraftBlocks.nullstone_brick_stairs, 0 , 2);
		world.setBlock(i + 4, j + 9, k + 1, NovaCraftBlocks.nullstone_brick_stairs, 0 , 2);
		world.setBlock(i + 4, j + 9, k + 2, NovaCraftBlocks.nullstone_brick_stairs, 0 , 2);
		world.setBlock(i + 4, j + 9, k + 3, NovaCraftBlocks.nullstone_brick_stairs, 0 , 2);
		world.setBlock(i + 4, j + 9, k + 4, NovaCraftBlocks.nullstone_brick_stairs, 0 , 2);
		world.setBlock(i + 4, j + 9, k + 5, NovaCraftBlocks.nullstone_brick_stairs, 0 , 2);
		world.setBlock(i + 4, j + 9, k + 6, NovaCraftBlocks.nullstone_brick_stairs, 0 , 2);
		world.setBlock(i + 4, j + 9, k + 7, NovaCraftBlocks.nullstone_brick_stairs, 0 , 2);
		world.setBlock(i + 4, j + 9, k + 8, NovaCraftBlocks.nullstone_brick_stairs, 0 , 2);
		world.setBlock(i + 5, j + 1, k + 0, NullstoneBrick, 0 , 2);
		world.setBlock(i + 5, j + 1, k + 1, NullstoneBrick, 0 , 2);
		world.setBlock(i + 5, j + 1, k + 2, NullstoneBrick, 0 , 2);
		world.setBlock(i + 5, j + 1, k + 3, NullstoneBrick, 0 , 2);
		world.setBlock(i + 5, j + 1, k + 4, NullstoneBrick, 0 , 2);
		world.setBlock(i + 5, j + 1, k + 5, NullstoneBrick, 0 , 2);
		world.setBlock(i + 5, j + 1, k + 6, NullstoneBrick, 0 , 2);
		world.setBlock(i + 5, j + 1, k + 7, NullstoneBrick, 0 , 2);
		world.setBlock(i + 5, j + 1, k + 8, NullstoneBrick, 0 , 2);
		world.setBlock(i + 5, j + 2, k + 0, NullstoneBrick, 0 , 2);
		world.setBlock(i + 5, j + 2, k + 1, air);
		world.setBlock(i + 5, j + 2, k + 2, air);
		world.setBlock(i + 5, j + 2, k + 3, air);
		world.setBlock(i + 5, j + 2, k + 4, air);
		world.setBlock(i + 5, j + 2, k + 5, air);
		world.setBlock(i + 5, j + 2, k + 6, air);
		world.setBlock(i + 5, j + 2, k + 7, air);
		world.setBlock(i + 5, j + 2, k + 8, NullstoneBrick, 0 , 2);
		world.setBlock(i + 5, j + 3, k + 0, NovaCraftBlocks.vanite_glass, 0 , 2);
		world.setBlock(i + 5, j + 3, k + 1, air);
		world.setBlock(i + 5, j + 3, k + 2, air);
		world.setBlock(i + 5, j + 3, k + 3, air);
		world.setBlock(i + 5, j + 3, k + 4, air);
		world.setBlock(i + 5, j + 3, k + 5, air);
		world.setBlock(i + 5, j + 3, k + 6, air);
		world.setBlock(i + 5, j + 3, k + 7, air);
		world.setBlock(i + 5, j + 3, k + 8, NovaCraftBlocks.vanite_glass, 0 , 2);
		world.setBlock(i + 5, j + 4, k + 0, NovaCraftBlocks.vanite_glass, 0 , 2);
		world.setBlock(i + 5, j + 4, k + 1, air);
		world.setBlock(i + 5, j + 4, k + 2, air);
		world.setBlock(i + 5, j + 4, k + 3, air);
		world.setBlock(i + 5, j + 4, k + 4, air);
		world.setBlock(i + 5, j + 4, k + 5, air);
		world.setBlock(i + 5, j + 4, k + 6, air);
		world.setBlock(i + 5, j + 4, k + 7, air);
		world.setBlock(i + 5, j + 4, k + 8, NovaCraftBlocks.vanite_glass, 0 , 2);
		world.setBlock(i + 5, j + 5, k + 0, NovaCraftBlocks.grimstone_bricks, 0 , 2);
		world.setBlock(i + 5, j + 5, k + 1, air);
		world.setBlock(i + 5, j + 5, k + 2, air);
		world.setBlock(i + 5, j + 5, k + 3, air);
		world.setBlock(i + 5, j + 5, k + 4, air);
		world.setBlock(i + 5, j + 5, k + 5, air);
		world.setBlock(i + 5, j + 5, k + 6, air);
		world.setBlock(i + 5, j + 5, k + 7, air);
		world.setBlock(i + 5, j + 5, k + 8, NovaCraftBlocks.grimstone_bricks, 0 , 2);
		world.setBlock(i + 5, j + 6, k + 0, NullstoneBrick, 0 , 2);
		world.setBlock(i + 5, j + 6, k + 1, NullstoneBrick, 0 , 2);
		world.setBlock(i + 5, j + 6, k + 2, NullstoneBrick, 0 , 2);
		world.setBlock(i + 5, j + 6, k + 3, NullstoneBrick, 0 , 2);
		world.setBlock(i + 5, j + 6, k + 4, NullstoneBrick, 0 , 2);
		world.setBlock(i + 5, j + 6, k + 5, NullstoneBrick, 0 , 2);
		world.setBlock(i + 5, j + 6, k + 6, NullstoneBrick, 0 , 2);
		world.setBlock(i + 5, j + 6, k + 7, NullstoneBrick, 0 , 2);
		world.setBlock(i + 5, j + 6, k + 8, NullstoneBrick, 0 , 2);
		world.setBlock(i + 5, j + 7, k + 0, NullstoneBrick, 0 , 2);
		world.setBlock(i + 5, j + 7, k + 1, NullstoneBrick, 0 , 2);
		world.setBlock(i + 5, j + 7, k + 2, NullstoneBrick, 0 , 2);
		world.setBlock(i + 5, j + 7, k + 3, NullstoneBrick, 0 , 2);
		world.setBlock(i + 5, j + 7, k + 4, NullstoneBrick, 0 , 2);
		world.setBlock(i + 5, j + 7, k + 5, NullstoneBrick, 0 , 2);
		world.setBlock(i + 5, j + 7, k + 6, NullstoneBrick, 0 , 2);
		world.setBlock(i + 5, j + 7, k + 7, NullstoneBrick, 0 , 2);
		world.setBlock(i + 5, j + 7, k + 8, NullstoneBrick, 0 , 2);
		world.setBlock(i + 5, j + 8, k + 0, NullstoneBrick, 0 , 2);
		world.setBlock(i + 5, j + 8, k + 1, NullstoneBrick, 0 , 2);
		world.setBlock(i + 5, j + 8, k + 2, NullstoneBrick, 0 , 2);
		world.setBlock(i + 5, j + 8, k + 3, NullstoneBrick, 0 , 2);
		world.setBlock(i + 5, j + 8, k + 4, NullstoneBrick, 0 , 2);
		world.setBlock(i + 5, j + 8, k + 5, NullstoneBrick, 0 , 2);
		world.setBlock(i + 5, j + 8, k + 6, NullstoneBrick, 0 , 2);
		world.setBlock(i + 5, j + 8, k + 7, NullstoneBrick, 0 , 2);
		world.setBlock(i + 5, j + 8, k + 8, NullstoneBrick, 0 , 2);
		world.setBlock(i + 5, j + 9, k + 0, NovaCraftBlocks.nullstone_brick_stairs, 1 , 2);
		world.setBlock(i + 5, j + 9, k + 1, NovaCraftBlocks.nullstone_brick_stairs, 1 , 2);
		world.setBlock(i + 5, j + 9, k + 2, NovaCraftBlocks.nullstone_brick_stairs, 1 , 2);
		world.setBlock(i + 5, j + 9, k + 3, NovaCraftBlocks.nullstone_brick_stairs, 1 , 2);
		world.setBlock(i + 5, j + 9, k + 4, NovaCraftBlocks.nullstone_brick_stairs, 1 , 2);
		world.setBlock(i + 5, j + 9, k + 5, NovaCraftBlocks.nullstone_brick_stairs, 1 , 2);
		world.setBlock(i + 5, j + 9, k + 6, NovaCraftBlocks.nullstone_brick_stairs, 1 , 2);
		world.setBlock(i + 5, j + 9, k + 7, NovaCraftBlocks.nullstone_brick_stairs, 1 , 2);
		world.setBlock(i + 5, j + 9, k + 8, NovaCraftBlocks.nullstone_brick_stairs, 1 , 2);
		world.setBlock(i + 6, j + 1, k + 0, NullstoneBrick, 0 , 2);
		world.setBlock(i + 6, j + 1, k + 1, NullstoneBrick, 0 , 2);
		world.setBlock(i + 6, j + 1, k + 2, NullstoneBrick, 0 , 2);
		world.setBlock(i + 6, j + 1, k + 3, NullstoneBrick, 0 , 2);
		world.setBlock(i + 6, j + 1, k + 4, NullstoneBrick, 0 , 2);
		world.setBlock(i + 6, j + 1, k + 5, NullstoneBrick, 0 , 2);
		world.setBlock(i + 6, j + 1, k + 6, NullstoneBrick, 0 , 2);
		world.setBlock(i + 6, j + 1, k + 7, NullstoneBrick, 0 , 2);
		world.setBlock(i + 6, j + 1, k + 8, NullstoneBrick, 0 , 2);
		world.setBlock(i + 6, j + 2, k + 0, NullstoneBrick, 0 , 2);
		world.setBlock(i + 6, j + 2, k + 1, air);
		world.setBlock(i + 6, j + 2, k + 2, air);
		world.setBlock(i + 6, j + 2, k + 3, air);
		world.setBlock(i + 6, j + 2, k + 4, air);
		world.setBlock(i + 6, j + 2, k + 5, air);
		world.setBlock(i + 6, j + 2, k + 6, air);
		world.setBlock(i + 6, j + 2, k + 7, NovaCraftBlocks.sculk_block, 0 , 2);
		world.setBlock(i + 6, j + 2, k + 8, NullstoneBrick, 0 , 2);
		world.setBlock(i + 6, j + 3, k + 0, NovaCraftBlocks.grimstone_bricks, 0 , 2);
		world.setBlock(i + 6, j + 3, k + 1, air);
		world.setBlock(i + 6, j + 3, k + 2, air);
		world.setBlock(i + 6, j + 3, k + 3, air);
		world.setBlock(i + 6, j + 3, k + 4, air);
		world.setBlock(i + 6, j + 3, k + 5, air);
		world.setBlock(i + 6, j + 3, k + 6, air);
		world.setBlock(i + 6, j + 3, k + 7, air);
		world.setBlock(i + 6, j + 3, k + 8, NovaCraftBlocks.grimstone_bricks, 0 , 2);
		world.setBlock(i + 6, j + 4, k + 0, NovaCraftBlocks.grimstone_bricks, 0 , 2);
		world.setBlock(i + 6, j + 4, k + 1, air);
		world.setBlock(i + 6, j + 4, k + 2, air);
		world.setBlock(i + 6, j + 4, k + 3, air);
		world.setBlock(i + 6, j + 4, k + 4, air);
		world.setBlock(i + 6, j + 4, k + 5, air);
		world.setBlock(i + 6, j + 4, k + 6, air);
		world.setBlock(i + 6, j + 4, k + 7, air);
		world.setBlock(i + 6, j + 4, k + 8, NovaCraftBlocks.grimstone_bricks, 0 , 2);
		world.setBlock(i + 6, j + 5, k + 0, NovaCraftBlocks.grimstone_bricks, 0 , 2);
		world.setBlock(i + 6, j + 5, k + 1, NovaCraftBlocks.grimstone_bricks, 0 , 2);
		world.setBlock(i + 6, j + 5, k + 2, NovaCraftBlocks.grimstone_bricks, 0 , 2);
		world.setBlock(i + 6, j + 5, k + 3, NovaCraftBlocks.grimstone_bricks, 0 , 2);
		world.setBlock(i + 6, j + 5, k + 4, NovaCraftBlocks.grimstone_bricks, 0 , 2);
		world.setBlock(i + 6, j + 5, k + 5, NovaCraftBlocks.grimstone_bricks, 0 , 2);
		world.setBlock(i + 6, j + 5, k + 6, NovaCraftBlocks.grimstone_bricks, 0 , 2);
		world.setBlock(i + 6, j + 5, k + 7, NovaCraftBlocks.grimstone_bricks, 0 , 2);
		world.setBlock(i + 6, j + 5, k + 8, NovaCraftBlocks.grimstone_bricks, 0 , 2);
		world.setBlock(i + 6, j + 6, k + 0, NullstoneBrick, 0 , 2);
		world.setBlock(i + 6, j + 6, k + 1, NullstoneBrick, 0 , 2);
		world.setBlock(i + 6, j + 6, k + 2, NullstoneBrick, 0 , 2);
		world.setBlock(i + 6, j + 6, k + 3, NullstoneBrick, 0 , 2);
		world.setBlock(i + 6, j + 6, k + 4, NullstoneBrick, 0 , 2);
		world.setBlock(i + 6, j + 6, k + 5, NullstoneBrick, 0 , 2);
		world.setBlock(i + 6, j + 6, k + 6, NullstoneBrick, 0 , 2);
		world.setBlock(i + 6, j + 6, k + 7, NullstoneBrick, 0 , 2);
		world.setBlock(i + 6, j + 6, k + 8, NullstoneBrick, 0 , 2);
		world.setBlock(i + 6, j + 7, k + 0, NullstoneBrick, 0 , 2);
		world.setBlock(i + 6, j + 7, k + 1, NullstoneBrick, 0 , 2);
		world.setBlock(i + 6, j + 7, k + 2, NullstoneBrick, 0 , 2);
		world.setBlock(i + 6, j + 7, k + 3, NullstoneBrick, 0 , 2);
		world.setBlock(i + 6, j + 7, k + 4, NullstoneBrick, 0 , 2);
		world.setBlock(i + 6, j + 7, k + 5, NullstoneBrick, 0 , 2);
		world.setBlock(i + 6, j + 7, k + 6, NullstoneBrick, 0 , 2);
		world.setBlock(i + 6, j + 7, k + 7, NullstoneBrick, 0 , 2);
		world.setBlock(i + 6, j + 7, k + 8, NullstoneBrick, 0 , 2);
		world.setBlock(i + 6, j + 8, k + 0, NovaCraftBlocks.nullstone_brick_stairs, 1 , 2);
		world.setBlock(i + 6, j + 8, k + 1, NovaCraftBlocks.nullstone_brick_stairs, 1 , 2);
		world.setBlock(i + 6, j + 8, k + 2, NovaCraftBlocks.nullstone_brick_stairs, 1 , 2);
		world.setBlock(i + 6, j + 8, k + 3, NovaCraftBlocks.nullstone_brick_stairs, 1 , 2);
		world.setBlock(i + 6, j + 8, k + 4, NovaCraftBlocks.nullstone_brick_stairs, 1 , 2);
		world.setBlock(i + 6, j + 8, k + 5, NovaCraftBlocks.nullstone_brick_stairs, 1 , 2);
		world.setBlock(i + 6, j + 8, k + 6, NovaCraftBlocks.nullstone_brick_stairs, 1 , 2);
		world.setBlock(i + 6, j + 8, k + 7, NovaCraftBlocks.nullstone_brick_stairs, 1 , 2);
		world.setBlock(i + 6, j + 8, k + 8, NovaCraftBlocks.nullstone_brick_stairs, 1 , 2);
		world.setBlock(i + 6, j + 9, k + 0, air);
		world.setBlock(i + 6, j + 9, k + 1, air);
		world.setBlock(i + 6, j + 9, k + 2, air);
		world.setBlock(i + 6, j + 9, k + 3, air);
		world.setBlock(i + 6, j + 9, k + 4, air);
		world.setBlock(i + 6, j + 9, k + 5, air);
		world.setBlock(i + 6, j + 9, k + 6, air);
		world.setBlock(i + 6, j + 9, k + 7, air);
		world.setBlock(i + 6, j + 9, k + 8, air);
		world.setBlock(i + 7, j + 1, k + 0, NullstoneBrick, 0 , 2);
		world.setBlock(i + 7, j + 1, k + 1, NullstoneBrick, 0 , 2);
		world.setBlock(i + 7, j + 1, k + 2, NullstoneBrick, 0 , 2);
		world.setBlock(i + 7, j + 1, k + 3, NullstoneBrick, 0 , 2);
		world.setBlock(i + 7, j + 1, k + 4, NullstoneBrick, 0 , 2);
		world.setBlock(i + 7, j + 1, k + 5, NullstoneBrick, 0 , 2);
		world.setBlock(i + 7, j + 1, k + 6, NullstoneBrick, 0 , 2);
		world.setBlock(i + 7, j + 1, k + 7, NullstoneBrick, 0 , 2);
		world.setBlock(i + 7, j + 1, k + 8, NullstoneBrick, 0 , 2);
		world.setBlock(i + 7, j + 2, k + 0, NullstoneBrick, 0 , 2);
		world.setBlock(i + 7, j + 2, k + 2, NullstoneBrick, 0 , 2);
		world.setBlock(i + 7, j + 2, k + 3, NullstoneBrick, 0 , 2);
		world.setBlock(i + 7, j + 2, k + 4, NullstoneBrick, 0 , 2);
		world.setBlock(i + 7, j + 2, k + 5, NullstoneBrick, 0 , 2);
		world.setBlock(i + 7, j + 2, k + 6, NullstoneBrick, 0 , 2);
		world.setBlock(i + 7, j + 2, k + 7, NullstoneBrick, 0 , 2);
		world.setBlock(i + 7, j + 2, k + 8, NullstoneBrick, 0 , 2);
		world.setBlock(i + 7, j + 3, k + 0, NullstoneBrick, 0 , 2);
		world.setBlock(i + 7, j + 3, k + 2, NovaCraftBlocks.grimstone_bricks, 0 , 2);
		world.setBlock(i + 7, j + 3, k + 3, NovaCraftBlocks.grimstone_bricks, 0 , 2);
		world.setBlock(i + 7, j + 3, k + 4, NovaCraftBlocks.vanite_glass, 0 , 2);
		world.setBlock(i + 7, j + 3, k + 5, NovaCraftBlocks.vanite_glass, 0 , 2);
		world.setBlock(i + 7, j + 3, k + 6, NovaCraftBlocks.vanite_glass, 0 , 2);
		world.setBlock(i + 7, j + 3, k + 7, NovaCraftBlocks.grimstone_bricks, 0 , 2);
		world.setBlock(i + 7, j + 3, k + 8, NullstoneBrick, 0 , 2);
		world.setBlock(i + 7, j + 4, k + 0, NullstoneBrick, 0 , 2);
		world.setBlock(i + 7, j + 4, k + 1, NovaCraftBlocks.grimstone_bricks, 0 , 2);
		world.setBlock(i + 7, j + 4, k + 2, NovaCraftBlocks.grimstone_bricks, 0 , 2);
		world.setBlock(i + 7, j + 4, k + 3, NovaCraftBlocks.grimstone_bricks, 0 , 2);
		world.setBlock(i + 7, j + 4, k + 4, NovaCraftBlocks.vanite_glass, 0 , 2);
		world.setBlock(i + 7, j + 4, k + 5, NovaCraftBlocks.vanite_glass, 0 , 2);
		world.setBlock(i + 7, j + 4, k + 6, NovaCraftBlocks.vanite_glass, 0 , 2);
		world.setBlock(i + 7, j + 4, k + 7, NovaCraftBlocks.grimstone_bricks, 0 , 2);
		world.setBlock(i + 7, j + 4, k + 8, NullstoneBrick, 0 , 2);
		world.setBlock(i + 7, j + 5, k + 0, NullstoneBrick, 0 , 2);
		world.setBlock(i + 7, j + 5, k + 1, NovaCraftBlocks.grimstone_bricks, 0 , 2);
		world.setBlock(i + 7, j + 5, k + 2, NovaCraftBlocks.grimstone_bricks, 0 , 2);
		world.setBlock(i + 7, j + 5, k + 3, NovaCraftBlocks.grimstone_bricks, 0 , 2);
		world.setBlock(i + 7, j + 5, k + 4, NovaCraftBlocks.grimstone_bricks, 0 , 2);
		world.setBlock(i + 7, j + 5, k + 5, NovaCraftBlocks.grimstone_bricks, 0 , 2);
		world.setBlock(i + 7, j + 5, k + 6, NovaCraftBlocks.grimstone_bricks, 0 , 2);
		world.setBlock(i + 7, j + 5, k + 7, NovaCraftBlocks.grimstone_bricks, 0 , 2);
		world.setBlock(i + 7, j + 5, k + 8, NullstoneBrick, 0 , 2);
		world.setBlock(i + 7, j + 6, k + 0, NullstoneBrick, 0 , 2);
		world.setBlock(i + 7, j + 6, k + 1, NullstoneBrick, 0 , 2);
		world.setBlock(i + 7, j + 6, k + 2, NullstoneBrick, 0 , 2);
		world.setBlock(i + 7, j + 6, k + 3, NullstoneBrick, 0 , 2);
		world.setBlock(i + 7, j + 6, k + 4, NullstoneBrick, 0 , 2);
		world.setBlock(i + 7, j + 6, k + 5, NullstoneBrick, 0 , 2);
		world.setBlock(i + 7, j + 6, k + 6, NullstoneBrick, 0 , 2);
		world.setBlock(i + 7, j + 6, k + 7, NullstoneBrick, 0 , 2);
		world.setBlock(i + 7, j + 6, k + 8, NullstoneBrick, 0 , 2);
		world.setBlock(i + 7, j + 7, k + 0, NovaCraftBlocks.nullstone_brick_stairs, 1 , 2);
		world.setBlock(i + 7, j + 7, k + 1, NovaCraftBlocks.nullstone_brick_stairs, 1 , 2);
		world.setBlock(i + 7, j + 7, k + 2, NovaCraftBlocks.nullstone_brick_stairs, 1 , 2);
		world.setBlock(i + 7, j + 7, k + 3, NovaCraftBlocks.nullstone_brick_stairs, 1 , 2);
		world.setBlock(i + 7, j + 7, k + 4, NovaCraftBlocks.nullstone_brick_stairs, 1 , 2);
		world.setBlock(i + 7, j + 7, k + 5, NovaCraftBlocks.nullstone_brick_stairs, 1 , 2);
		world.setBlock(i + 7, j + 7, k + 6, NovaCraftBlocks.nullstone_brick_stairs, 1 , 2);
		world.setBlock(i + 7, j + 7, k + 7, NovaCraftBlocks.nullstone_brick_stairs, 1 , 2);
		world.setBlock(i + 7, j + 7, k + 8, NovaCraftBlocks.nullstone_brick_stairs, 1 , 2);
		world.setBlock(i + 7, j + 8, k + 0, air);
		world.setBlock(i + 7, j + 8, k + 1, air);
		world.setBlock(i + 7, j + 8, k + 2, air);
		world.setBlock(i + 7, j + 8, k + 3, air);
		world.setBlock(i + 7, j + 8, k + 4, air);
		world.setBlock(i + 7, j + 8, k + 5, air);
		world.setBlock(i + 7, j + 8, k + 6, air);
		world.setBlock(i + 7, j + 8, k + 7, air);
		world.setBlock(i + 7, j + 8, k + 8, air);
		world.setBlock(i + 7, j + 9, k + 0, air);
		world.setBlock(i + 7, j + 9, k + 1, air);
		world.setBlock(i + 7, j + 9, k + 2, air);
		world.setBlock(i + 7, j + 9, k + 3, air);
		world.setBlock(i + 7, j + 9, k + 4, air);
		world.setBlock(i + 7, j + 9, k + 5, air);
		world.setBlock(i + 7, j + 9, k + 6, air);
		world.setBlock(i + 7, j + 9, k + 7, air);
		world.setBlock(i + 7, j + 9, k + 8, air);
		world.setBlock(i + 8, j + 1, k + 0, air);
		world.setBlock(i + 8, j + 1, k + 1, NovaCraftBlocks.nullstone_brick_stairs, 1 , 2);
		world.setBlock(i + 8, j + 1, k + 2, air);
		world.setBlock(i + 8, j + 1, k + 3, air);
		world.setBlock(i + 8, j + 1, k + 4, air);
		world.setBlock(i + 8, j + 1, k + 5, air);
		world.setBlock(i + 8, j + 1, k + 6, air);
		world.setBlock(i + 8, j + 1, k + 7, air);
		world.setBlock(i + 8, j + 1, k + 8, air);
		world.setBlock(i + 8, j + 2, k + 0, air);
		world.setBlock(i + 8, j + 2, k + 1, air);
		world.setBlock(i + 8, j + 2, k + 2, air);
		world.setBlock(i + 8, j + 2, k + 3, air);
		world.setBlock(i + 8, j + 2, k + 4, air);
		world.setBlock(i + 8, j + 2, k + 5, air);
		world.setBlock(i + 8, j + 2, k + 6, air);
		world.setBlock(i + 8, j + 2, k + 7, air);
		world.setBlock(i + 8, j + 2, k + 8, air);
		world.setBlock(i + 8, j + 3, k + 0, air);
		world.setBlock(i + 8, j + 3, k + 1, air);
		world.setBlock(i + 8, j + 3, k + 2, air);
		world.setBlock(i + 8, j + 3, k + 3, air);
		world.setBlock(i + 8, j + 3, k + 4, air);
		world.setBlock(i + 8, j + 3, k + 5, air);
		world.setBlock(i + 8, j + 3, k + 6, air);
		world.setBlock(i + 8, j + 3, k + 7, air);
		world.setBlock(i + 8, j + 3, k + 8, air);
		world.setBlock(i + 8, j + 4, k + 0, air);
		world.setBlock(i + 8, j + 4, k + 1, air);
		world.setBlock(i + 8, j + 4, k + 2, air);
		world.setBlock(i + 8, j + 4, k + 3, air);
		world.setBlock(i + 8, j + 4, k + 4, air);
		world.setBlock(i + 8, j + 4, k + 5, air);
		world.setBlock(i + 8, j + 4, k + 6, air);
		world.setBlock(i + 8, j + 4, k + 7, air);
		world.setBlock(i + 8, j + 4, k + 8, air);
		world.setBlock(i + 8, j + 5, k + 0, air);
		world.setBlock(i + 8, j + 5, k + 1, air);
		world.setBlock(i + 8, j + 5, k + 2, air);
		world.setBlock(i + 8, j + 5, k + 3, air);
		world.setBlock(i + 8, j + 5, k + 4, air);
		world.setBlock(i + 8, j + 5, k + 5, air);
		world.setBlock(i + 8, j + 5, k + 6, air);
		world.setBlock(i + 8, j + 5, k + 7, air);
		world.setBlock(i + 8, j + 5, k + 8, air);
		world.setBlock(i + 8, j + 6, k + 0, NovaCraftBlocks.nullstone_brick_stairs, 1 , 2);
		world.setBlock(i + 8, j + 6, k + 1, NovaCraftBlocks.nullstone_brick_stairs, 1 , 2);
		world.setBlock(i + 8, j + 6, k + 2, NovaCraftBlocks.nullstone_brick_stairs, 1 , 2);
		world.setBlock(i + 8, j + 6, k + 3, NovaCraftBlocks.nullstone_brick_stairs, 1 , 2);
		world.setBlock(i + 8, j + 6, k + 4, NovaCraftBlocks.nullstone_brick_stairs, 1 , 2);
		world.setBlock(i + 8, j + 6, k + 5, NovaCraftBlocks.nullstone_brick_stairs, 1 , 2);
		world.setBlock(i + 8, j + 6, k + 6, NovaCraftBlocks.nullstone_brick_stairs, 1 , 2);
		world.setBlock(i + 8, j + 6, k + 7, NovaCraftBlocks.nullstone_brick_stairs, 1 , 2);
		world.setBlock(i + 8, j + 6, k + 8, NovaCraftBlocks.nullstone_brick_stairs, 1 , 2);
		world.setBlock(i + 8, j + 7, k + 0, air);
		world.setBlock(i + 8, j + 7, k + 1, air);
		world.setBlock(i + 8, j + 7, k + 2, air);
		world.setBlock(i + 8, j + 7, k + 3, air);
		world.setBlock(i + 8, j + 7, k + 4, air);
		world.setBlock(i + 8, j + 7, k + 5, air);
		world.setBlock(i + 8, j + 7, k + 6, air);
		world.setBlock(i + 8, j + 7, k + 7, air);
		world.setBlock(i + 8, j + 7, k + 8, air);
		world.setBlock(i + 8, j + 8, k + 0, air);
		world.setBlock(i + 8, j + 8, k + 1, air);
		world.setBlock(i + 8, j + 8, k + 2, air);
		world.setBlock(i + 8, j + 8, k + 3, air);
		world.setBlock(i + 8, j + 8, k + 4, air);
		world.setBlock(i + 8, j + 8, k + 5, air);
		world.setBlock(i + 8, j + 8, k + 6, air);
		world.setBlock(i + 8, j + 8, k + 7, air);
		world.setBlock(i + 8, j + 8, k + 8, air);
		world.setBlock(i + 8, j + 9, k + 0, air);
		world.setBlock(i + 8, j + 9, k + 1, air);
		world.setBlock(i + 8, j + 9, k + 2, air);
		world.setBlock(i + 8, j + 9, k + 3, air);
		world.setBlock(i + 8, j + 9, k + 4, air);
		world.setBlock(i + 8, j + 9, k + 5, air);
		world.setBlock(i + 8, j + 9, k + 6, air);
		world.setBlock(i + 8, j + 9, k + 7, air);
		world.setBlock(i + 8, j + 9, k + 8, air);
		
		world.setBlock(i + 3, j + 3, k + 2, Blocks.iron_bars, 0 , 2);
		world.setBlock(i + 3, j + 4, k + 2, Blocks.iron_bars, 0 , 2);
		world.setBlock(i + 3, j + 2, k + 2, Blocks.iron_bars, 0 , 2);
		
		world.setBlock(i + 4, j + 3, k + 2, Blocks.iron_bars, 0 , 2);
		world.setBlock(i + 4, j + 4, k + 2, Blocks.iron_bars, 0 , 2);
		world.setBlock(i + 4, j + 5, k + 2, Blocks.iron_bars, 0 , 2);
		world.setBlock(i + 4, j + 2, k + 2, Blocks.iron_bars, 0 , 2);
		
		world.setBlock(i + 4, j + 3, k + 3, Blocks.iron_bars, 0 , 2);
		world.setBlock(i + 4, j + 4, k + 3, Blocks.iron_bars, 0 , 2);
		world.setBlock(i + 4, j + 5, k + 3, Blocks.iron_bars, 0 , 2);
		world.setBlock(i + 4, j + 2, k + 3, Blocks.iron_bars, 0 , 2);
		
		world.setBlock(i + 4, j + 3, k + 4, Blocks.iron_bars, 0 , 2);
		world.setBlock(i + 4, j + 4, k + 4, Blocks.iron_bars, 0 , 2);
		world.setBlock(i + 4, j + 5, k + 4, Blocks.iron_bars, 0 , 2);
		world.setBlock(i + 4, j + 2, k + 4, Blocks.iron_bars, 0 , 2);
		
		world.setBlock(i + 3, j + 3, k + 4, Blocks.iron_bars, 0 , 2);
		world.setBlock(i + 3, j + 4, k + 4, Blocks.iron_bars, 0 , 2);
		world.setBlock(i + 3, j + 2, k + 4, Blocks.iron_bars, 0 , 2);
		
		world.setBlock(i + 4, j + 3, k + 6, Blocks.iron_bars, 0 , 2);
		world.setBlock(i + 4, j + 4, k + 6, Blocks.iron_bars, 0 , 2);
		world.setBlock(i + 4, j + 5, k + 6, Blocks.iron_bars, 0 , 2);
		world.setBlock(i + 4, j + 2, k + 6, Blocks.iron_bars, 0 , 2);
		
		world.setBlock(i + 3, j + 3, k + 6, Blocks.iron_bars, 0 , 2);
		world.setBlock(i + 3, j + 4, k + 6, Blocks.iron_bars, 0 , 2);
		world.setBlock(i + 3, j + 2, k + 6, Blocks.iron_bars, 0 , 2);
		
		world.setBlock(i + 4, j + 3, k + 5, Blocks.iron_bars, 0 , 2);
		world.setBlock(i + 4, j + 4, k + 5, Blocks.iron_bars, 0 , 2);
		world.setBlock(i + 4, j + 5, k + 5, Blocks.iron_bars, 0 , 2);
		world.setBlock(i + 4, j + 2, k + 5, Blocks.iron_bars, 0 , 2);
		
		world.setBlock(i + 7, j + 2, k + 1, Blocks.planks, 5 , 2); // 2
		world.setBlock(i + 7, j + 3, k + 1, Blocks.planks, 5 , 2); // 8
		
		{
		if (Loader.isModLoaded("etfuturum")) {
		world.setBlock(i + 8, j + 2, k + 1, OtherModBlocks.wall_sign_dark_oak, 5 , 2);
		world.setBlock(i + 8, j + 3, k + 1, OtherModBlocks.wall_sign_dark_oak, 5 , 2); 	
		}
		else {
		world.setBlock(i + 8, j + 2, k + 1, Blocks.wall_sign, 5 , 2);
		world.setBlock(i + 8, j + 3, k + 1, Blocks.wall_sign, 5 , 2); 
		 }
		}

		for(int posX = i; posX <= i + 8; posX++)
			for(int posZ = k; posZ <= k + 8; posZ++){
				int posY = j;	
				boolean isFloorFinished = false;
				while(isFloorFinished == false){				
					if(world.getBlock(posX, posY, posZ) == air || world.getBlock(posX, posY, posZ) == Blocks.tallgrass || world.getBlock(posX, posY, posZ) == Blocks.cactus || world.getBlock(posX, posY, posZ) == Blocks.red_flower || world.getBlock(posX, posY, posZ) == Blocks.yellow_flower || world.getBlock(posX, posY, posZ) == Blocks.deadbush || world.getBlock(posX, posY, posZ) == Blocks.snow || world.getBlock(posX, posY, posZ) == Blocks.water || world.getBlock(posX, posY, posZ) == Blocks.lava || world.getBlock(posX, posY, posZ) == Blocks.brown_mushroom || world.getBlock(posX, posY, posZ) == Blocks.red_mushroom || world.getBlock(posX, posY, posZ) == Blocks.waterlily){
						world.setBlock(posX, posY, posZ, NullstoneBrick, 0, 2);
						posY--;
					}
					else
						isFloorFinished = true;
				}
			}

		
		EntityVillager var5 = new EntityVillager(world);
			var5.setPosition(i + 4, j + 3, k + 3);
			world.spawnEntityInWorld(var5);

			EntityVillager var6 = new EntityVillager(world);
			var6.setPosition(i + 4, j + 3, k + 5);
			world.spawnEntityInWorld(var6);

		//if(FarlandersMod.enderGuardianSpawn == 1){
			//EntityEnderGuardian var5 = new EntityEnderGuardian(world, i+9, j+2, k, true);
			//var5.setPosition(i+9, j+2, k);
			//world.spawnEntityInWorld(var5);
	//	}

		return true;
	}
}
