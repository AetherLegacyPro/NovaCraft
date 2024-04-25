package com.NovaCraft.world.village;

import java.util.Random;

import com.NovaCraft.entity.illager.EntityIllagerTrader;
import com.NovaCraftBlocks.NovaCraftBlocks;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class VillageHouseSmallDoor extends WorldGenerator
{
	private static final Block planks = NovaCraftBlocks.luminant_planks;
	private static final Block wood = NovaCraftBlocks.luminant_log;
	private static final Block thinGlass = Blocks.glass_pane;
	private static final Block cobbledGrimstone = NovaCraftBlocks.cobbled_grimstone;
	private static final Block fence = NovaCraftBlocks.cobbled_nullstone_wall;
	private static final Block doorWood = Blocks.wooden_door;
	private static final Block cobblestone = NovaCraftBlocks.cobbled_grimstone;
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

	public VillageHouseSmallDoor() { }

	public boolean checkAllLocations(World world, int i, int j, int k){
		if(!LocationIsValidSpawn(world, i, j, k) || !LocationIsValidSpawn(world, i + 5, j, k) || !LocationIsValidSpawn(world, i + 5, j, k + 3) || !LocationIsValidSpawn(world, i, j, k + 3) || !AirLocationIsValidSpawn(world, i, j + 6, k) || !AirLocationIsValidSpawn(world, i + 5, j + 6, k) || !AirLocationIsValidSpawn(world, i + 5, j + 6, k + 3) || !AirLocationIsValidSpawn(world, i, j + 6, k + 3))
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
		if(!LocationIsValidSpawn(world, i, j, k) || !LocationIsValidSpawn(world, i + 5, j, k) || !LocationIsValidSpawn(world, i + 5, j, k + 3) || !LocationIsValidSpawn(world, i, j, k + 3) || !AirLocationIsValidSpawn(world, i, j + 6, k) || !AirLocationIsValidSpawn(world, i + 5, j + 6, k) || !AirLocationIsValidSpawn(world, i + 5, j + 6, k + 3) || !AirLocationIsValidSpawn(world, i, j + 6, k + 3))
		{
			return false;
		}

		world.setBlock(i + 0, j + 1, k + 0, air);
		world.setBlock(i + 0, j + 1, k + 1, NovaCraftBlocks.cobbled_grimstone_stairs, 0, 2);
		world.setBlock(i + 0, j + 1, k + 2, air);
		world.setBlock(i + 0, j + 1, k + 3, air);
		world.setBlock(i + 0, j + 2, k + 0, air);
		world.setBlock(i + 0, j + 2, k + 1, air);
		world.setBlock(i + 0, j + 2, k + 2, air);
		world.setBlock(i + 0, j + 2, k + 3, air);
		world.setBlock(i + 0, j + 3, k + 0, air);
		world.setBlock(i + 0, j + 3, k + 1, air);
		world.setBlock(i + 0, j + 3, k + 2, air);
		world.setBlock(i + 0, j + 3, k + 3, air);
		world.setBlock(i + 0, j + 4, k + 0, air);
		world.setBlock(i + 0, j + 4, k + 1, air);
		world.setBlock(i + 0, j + 4, k + 2, air);
		world.setBlock(i + 0, j + 4, k + 3, air);
		world.setBlock(i + 0, j + 5, k + 0, air);
		world.setBlock(i + 0, j + 5, k + 1, air);
		world.setBlock(i + 0, j + 5, k + 2, air);
		world.setBlock(i + 0, j + 5, k + 3, air);
		world.setBlock(i + 0, j + 6, k + 0, air);
		world.setBlock(i + 0, j + 6, k + 1, air);
		world.setBlock(i + 0, j + 6, k + 2, air);
		world.setBlock(i + 0, j + 6, k + 3, air);
		world.setBlock(i + 1, j + 1, k + 0, cobbledGrimstone, 0, 2);
		world.setBlock(i + 1, j + 1, k + 1, cobbledGrimstone, 0, 2);
		world.setBlock(i + 1, j + 1, k + 2, cobbledGrimstone, 0, 2);
		world.setBlock(i + 1, j + 1, k + 3, cobbledGrimstone, 0, 2);
		world.setBlock(i + 1, j + 2, k + 0, wood, 0, 2);
		world.setBlock(i + 1, j + 2, k + 2, planks, 0, 2);
		world.setBlock(i + 1, j + 2, k + 3, wood, 0, 2);
		world.setBlock(i + 1, j + 3, k + 0, wood, 0, 2);
		world.setBlock(i + 1, j + 3, k + 2, planks, 0, 2);
		world.setBlock(i + 1, j + 3, k + 3, wood, 0, 2);
		world.setBlock(i + 1, j + 4, k + 0, wood, 0, 2);
		world.setBlock(i + 1, j + 4, k + 1, planks, 0, 2);
		world.setBlock(i + 1, j + 4, k + 2, planks, 0, 2);
		world.setBlock(i + 1, j + 4, k + 3, wood, 0, 2);
		world.setBlock(i + 1, j + 5, k + 0, air);
		world.setBlock(i + 1, j + 5, k + 1, wood, 0, 2);
		world.setBlock(i + 1, j + 5, k + 2, wood, 0, 2);
		world.setBlock(i + 1, j + 5, k + 3, air);
		world.setBlock(i + 1, j + 6, k + 0, air);
		world.setBlock(i + 1, j + 6, k + 1, air);
		world.setBlock(i + 1, j + 6, k + 2, air);
		world.setBlock(i + 1, j + 6, k + 3, air);
		world.setBlock(i + 2, j + 1, k + 0, cobbledGrimstone, 0, 2);
		world.setBlock(i + 2, j + 1, k + 3, cobbledGrimstone, 0, 2);
		world.setBlock(i + 2, j + 2, k + 0, planks, 0, 2);
		world.setBlock(i + 2, j + 2, k + 1, air);
		world.setBlock(i + 2, j + 2, k + 2, air);
		world.setBlock(i + 2, j + 2, k + 3, planks, 0, 2);
		world.setBlock(i + 2, j + 3, k + 0, planks, 0, 2);
		world.setBlock(i + 2, j + 3, k + 1, air);
		world.setBlock(i + 2, j + 3, k + 2, air);
		world.setBlock(i + 2, j + 3, k + 3, planks, 0, 2);
		world.setBlock(i + 2, j + 4, k + 0, planks, 0, 2);
		world.setBlock(i + 2, j + 4, k + 1, air);
		world.setBlock(i + 2, j + 4, k + 2, air);
		world.setBlock(i + 2, j + 4, k + 3, planks, 0, 2);
		world.setBlock(i + 2, j + 5, k + 0, wood, 0, 2);
		world.setBlock(i + 2, j + 5, k + 1, air);
		world.setBlock(i + 2, j + 5, k + 2, air);
		world.setBlock(i + 2, j + 5, k + 3, wood, 0, 2);
		world.setBlock(i + 2, j + 6, k + 0, air);
		world.setBlock(i + 2, j + 6, k + 1, wood, 0, 2);
		world.setBlock(i + 2, j + 6, k + 2, wood, 0, 2);
		world.setBlock(i + 2, j + 6, k + 3, air);
		world.setBlock(i + 3, j + 1, k + 0, cobbledGrimstone, 0, 2);
		world.setBlock(i + 3, j + 1, k + 3, cobbledGrimstone, 0, 2);
		world.setBlock(i + 3, j + 2, k + 0, planks, 0, 2);
		world.setBlock(i + 3, j + 2, k + 1, air);
		world.setBlock(i + 3, j + 2, k + 2, air);
		world.setBlock(i + 3, j + 2, k + 3, planks, 0, 2);
		world.setBlock(i + 3, j + 3, k + 0, thinGlass, 0, 2);
		world.setBlock(i + 3, j + 3, k + 1, air);
		world.setBlock(i + 3, j + 3, k + 2, air);
		world.setBlock(i + 3, j + 3, k + 3, thinGlass, 0, 2);
		world.setBlock(i + 3, j + 4, k + 0, planks, 0, 2);
		world.setBlock(i + 3, j + 4, k + 1, air);
		world.setBlock(i + 3, j + 4, k + 2, air);
		world.setBlock(i + 3, j + 4, k + 3, planks, 0, 2);
		world.setBlock(i + 3, j + 5, k + 0, wood, 0, 2);
		world.setBlock(i + 3, j + 5, k + 1, air);
		world.setBlock(i + 3, j + 5, k + 2, air);
		world.setBlock(i + 3, j + 5, k + 3, wood, 0, 2);
		world.setBlock(i + 3, j + 6, k + 0, air);
		world.setBlock(i + 3, j + 6, k + 1, wood, 0, 2);
		world.setBlock(i + 3, j + 6, k + 2, wood, 0, 2);
		world.setBlock(i + 3, j + 6, k + 3, air);
		world.setBlock(i + 4, j + 1, k + 0, cobbledGrimstone, 0, 2);
		world.setBlock(i + 4, j + 1, k + 3, cobbledGrimstone, 0, 2);
		world.setBlock(i + 4, j + 2, k + 0, planks, 0, 2);
		world.setBlock(i + 4, j + 2, k + 1, air);
		world.setBlock(i + 4, j + 2, k + 2, fence, 0, 2);
		world.setBlock(i + 4, j + 2, k + 3, planks, 0, 2);
		world.setBlock(i + 4, j + 3, k + 0, planks, 0, 2);
		world.setBlock(i + 4, j + 3, k + 1, air);
		world.setBlock(i + 4, j + 3, k + 3, planks, 0, 2);
		world.setBlock(i + 4, j + 4, k + 0, planks, 0, 2);
		world.setBlock(i + 4, j + 4, k + 1, air);
		world.setBlock(i + 4, j + 4, k + 2, air);
		world.setBlock(i + 4, j + 4, k + 3, planks, 0, 2);
		world.setBlock(i + 4, j + 5, k + 0, wood, 0, 2);
		world.setBlock(i + 4, j + 5, k + 1, air);
		world.setBlock(i + 4, j + 5, k + 2, air);
		world.setBlock(i + 4, j + 5, k + 3, wood, 0, 2);
		world.setBlock(i + 4, j + 6, k + 0, air);
		world.setBlock(i + 4, j + 6, k + 1, wood, 0, 2);
		world.setBlock(i + 4, j + 6, k + 2, wood, 0, 2);
		world.setBlock(i + 4, j + 6, k + 3, air);
		world.setBlock(i + 5, j + 1, k + 0, cobbledGrimstone, 0, 2);
		world.setBlock(i + 5, j + 1, k + 1, cobbledGrimstone, 0, 2);
		world.setBlock(i + 5, j + 1, k + 2, cobbledGrimstone, 0, 2);
		world.setBlock(i + 5, j + 1, k + 3, cobbledGrimstone, 0, 2);
		world.setBlock(i + 5, j + 2, k + 0, wood, 0, 2);
		world.setBlock(i + 5, j + 2, k + 1, planks, 0, 2);
		world.setBlock(i + 5, j + 2, k + 2, planks, 0, 2);
		world.setBlock(i + 5, j + 2, k + 3, wood, 0, 2);
		world.setBlock(i + 5, j + 3, k + 0, wood, 0, 2);
		world.setBlock(i + 5, j + 3, k + 1, planks, 0, 2);
		world.setBlock(i + 5, j + 3, k + 2, planks, 0, 2);
		world.setBlock(i + 5, j + 3, k + 3, wood, 0, 2);
		world.setBlock(i + 5, j + 4, k + 0, wood, 0, 2);
		world.setBlock(i + 5, j + 4, k + 1, planks, 0, 2);
		world.setBlock(i + 5, j + 4, k + 2, planks, 0, 2);
		world.setBlock(i + 5, j + 4, k + 3, wood, 0, 2);
		world.setBlock(i + 5, j + 5, k + 0, air);
		world.setBlock(i + 5, j + 5, k + 1, wood, 0, 2);
		world.setBlock(i + 5, j + 5, k + 2, wood, 0, 2);
		world.setBlock(i + 5, j + 5, k + 3, air);
		world.setBlock(i + 5, j + 6, k + 0, air);
		world.setBlock(i + 5, j + 6, k + 1, air);
		world.setBlock(i + 5, j + 6, k + 2, air);
		world.setBlock(i + 5, j + 6, k + 3, air);
		world.setBlock(i + 2, j + 1, k + 1, cobblestone);
		world.setBlock(i + 2, j + 1, k + 2, cobblestone);
		world.setBlock(i + 3, j + 1, k + 1, cobblestone);
		world.setBlock(i + 3, j + 1, k + 2, cobblestone);
		world.setBlock(i + 4, j + 1, k + 1, cobblestone);
		world.setBlock(i + 4, j + 1, k + 2, cobblestone);
		world.setBlock(i + 1, j + 2, k + 1, doorWood, 0, 2);
		world.setBlock(i + 1, j + 3, k + 1, doorWood, 8, 2);
		world.setBlock(i + 4, j + 3, k + 2, NovaCraftBlocks.cobbled_grimstone_slab, 0, 2);

		for(int posX = i; posX <= i + 5; posX++)
			for(int posZ = k; posZ <= k + 3; posZ++){
				int posY = j;		
				boolean isFloorFinished = false;
				while(isFloorFinished == false){				
					if(world.getBlock(posX, posY, posZ) == air || world.getBlock(posX, posY, posZ) == Blocks.tallgrass || world.getBlock(posX, posY, posZ) == Blocks.cactus || world.getBlock(posX, posY, posZ) == Blocks.red_flower || world.getBlock(posX, posY, posZ) == Blocks.yellow_flower || world.getBlock(posX, posY, posZ) == Blocks.deadbush || world.getBlock(posX, posY, posZ) == Blocks.snow || world.getBlock(posX, posY, posZ) == Blocks.water || world.getBlock(posX, posY, posZ) == Blocks.lava || world.getBlock(posX, posY, posZ) == Blocks.brown_mushroom || world.getBlock(posX, posY, posZ) == Blocks.red_mushroom || world.getBlock(posX, posY, posZ) == Blocks.waterlily){
						world.setBlock(posX, posY, posZ, cobbledGrimstone, 0, 2);
						posY--;
					}
					else
						isFloorFinished = true;
				}
			}

			EntityIllagerTrader var5 = new EntityIllagerTrader(world);
			var5.setPosition(i-1, j+2, k+1);
			world.spawnEntityInWorld(var5);

			EntityIllagerTrader var6 = new EntityIllagerTrader(world);
			var6.setPosition(i-1, j+2, k);
			world.spawnEntityInWorld(var6);

		return true;
	}
}
