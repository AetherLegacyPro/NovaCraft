package com.NovaCraft.world.village;

import java.util.Random;

import com.NovaCraft.entity.illager.EntityIllagerTrader;
import com.NovaCraftBlocks.NovaCraftBlocks;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class VindicatorFarm extends WorldGenerator
{
	private static final Block wood = NovaCraftBlocks.luminant_log;
	private static final Block tilledField = Blocks.farmland;
	private static final Block wheat = Blocks.wheat;
	private static final Block potato = Blocks.potatoes;
	private static final Block water = Blocks.water;
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

	public VindicatorFarm() { }
	
	public boolean checkAllLocations(World world, int i, int j, int k){
		if(!LocationIsValidSpawn(world, i, j, k) || !LocationIsValidSpawn(world, i + 12, j, k) || !LocationIsValidSpawn(world, i + 12, j, k + 8) || !LocationIsValidSpawn(world, i, j, k + 8))
		{
			return false;
		}
		
		return true;
	}

	public boolean generate(World world, Random rand, int i, int j, int k) {
		//check that each corner is one of the valid spawn blocks
		if(!LocationIsValidSpawn(world, i, j, k) || !LocationIsValidSpawn(world, i + 12, j, k) || !LocationIsValidSpawn(world, i + 12, j, k + 8) || !LocationIsValidSpawn(world, i, j, k + 8))
		{
			return false;
		}

		world.setBlock(i + 0, j + 0, k + 0, wood, 0, 2);
		world.setBlock(i + 0, j + 0, k + 1, wood, 0, 2);
		world.setBlock(i + 0, j + 0, k + 2, wood, 0, 2);
		world.setBlock(i + 0, j + 0, k + 3, wood, 0, 2);
		world.setBlock(i + 0, j + 0, k + 4, wood, 0, 2);
		world.setBlock(i + 0, j + 0, k + 5, wood, 0, 2);
		world.setBlock(i + 0, j + 0, k + 6, wood, 0, 2);
		world.setBlock(i + 0, j + 0, k + 7, wood, 0, 2);
		world.setBlock(i + 0, j + 0, k + 8, wood, 0, 2);
		world.setBlock(i + 0, j + 1, k + 0, air);
		world.setBlock(i + 0, j + 1, k + 1, air);
		world.setBlock(i + 0, j + 1, k + 2, air);
		world.setBlock(i + 0, j + 1, k + 3, air);
		world.setBlock(i + 0, j + 1, k + 4, air);
		world.setBlock(i + 0, j + 1, k + 5, air);
		world.setBlock(i + 0, j + 1, k + 6, air);
		world.setBlock(i + 0, j + 1, k + 7, air);
		world.setBlock(i + 0, j + 1, k + 8, air);
		world.setBlock(i + 1, j + 0, k + 0, wood, 0, 2);
		world.setBlock(i + 1, j + 0, k + 1, tilledField, 7, 2);
		world.setBlock(i + 1, j + 0, k + 2, tilledField, 7, 2);
		world.setBlock(i + 1, j + 0, k + 3, tilledField, 0, 2);
		world.setBlock(i + 1, j + 0, k + 4, tilledField, 0, 2);
		world.setBlock(i + 1, j + 0, k + 5, tilledField, 7, 2);
		world.setBlock(i + 1, j + 0, k + 6, tilledField, 7, 2);
		world.setBlock(i + 1, j + 0, k + 7, tilledField, 7, 2);
		world.setBlock(i + 1, j + 0, k + 8, wood, 0, 2);
		world.setBlock(i + 1, j + 1, k + 0, air);
		world.setBlock(i + 1, j + 1, k + 8, air);
		world.setBlock(i + 2, j + 0, k + 0, wood, 0, 2);
		world.setBlock(i + 2, j + 0, k + 1, tilledField, 0, 2);
		world.setBlock(i + 2, j + 0, k + 2, tilledField, 0, 2);
		world.setBlock(i + 2, j + 0, k + 3, tilledField, 0, 2);
		world.setBlock(i + 2, j + 0, k + 4, tilledField, 7, 2);
		world.setBlock(i + 2, j + 0, k + 5, tilledField, 0, 2);
		world.setBlock(i + 2, j + 0, k + 6, tilledField, 7, 2);
		world.setBlock(i + 2, j + 0, k + 7, tilledField, 7, 2);
		world.setBlock(i + 2, j + 0, k + 8, wood, 0, 2);
		world.setBlock(i + 2, j + 1, k + 0, air);
		world.setBlock(i + 2, j + 1, k + 8, air);
		world.setBlock(i + 3, j + 0, k + 0, wood, 0, 2);
		world.setBlock(i + 3, j + 0, k + 8, wood, 0, 2);
		world.setBlock(i + 3, j + 1, k + 0, air);
		world.setBlock(i + 3, j + 1, k + 1, air);
		world.setBlock(i + 3, j + 1, k + 2, air);
		world.setBlock(i + 3, j + 1, k + 3, air);
		world.setBlock(i + 3, j + 1, k + 4, air);
		world.setBlock(i + 3, j + 1, k + 5, air);
		world.setBlock(i + 3, j + 1, k + 6, air);
		world.setBlock(i + 3, j + 1, k + 7, air);
		world.setBlock(i + 3, j + 1, k + 8, air);
		world.setBlock(i + 4, j + 0, k + 0, wood, 0, 2);
		world.setBlock(i + 4, j + 0, k + 1, tilledField, 7, 2);
		world.setBlock(i + 4, j + 0, k + 2, tilledField, 0, 2);
		world.setBlock(i + 4, j + 0, k + 3, tilledField, 7, 2);
		world.setBlock(i + 4, j + 0, k + 4, tilledField, 7, 2);
		world.setBlock(i + 4, j + 0, k + 5, tilledField, 7, 2);
		world.setBlock(i + 4, j + 0, k + 6, tilledField, 7, 2);
		world.setBlock(i + 4, j + 0, k + 7, tilledField, 7, 2);
		world.setBlock(i + 4, j + 0, k + 8, wood, 0, 2);
		world.setBlock(i + 4, j + 1, k + 0, air);
		world.setBlock(i + 4, j + 1, k + 8, air);
		world.setBlock(i + 5, j + 0, k + 0, wood, 0, 2);
		world.setBlock(i + 5, j + 0, k + 1, tilledField, 7, 2);
		world.setBlock(i + 5, j + 0, k + 2, tilledField, 7, 2);
		world.setBlock(i + 5, j + 0, k + 3, tilledField, 7, 2);
		world.setBlock(i + 5, j + 0, k + 4, tilledField, 7, 2);
		world.setBlock(i + 5, j + 0, k + 5, tilledField, 0, 2);
		world.setBlock(i + 5, j + 0, k + 6, tilledField, 7, 2);
		world.setBlock(i + 5, j + 0, k + 7, tilledField, 7, 2);
		world.setBlock(i + 5, j + 0, k + 8, wood, 0, 2);
		world.setBlock(i + 5, j + 1, k + 0, air);
		world.setBlock(i + 5, j + 1, k + 8, air);
		world.setBlock(i + 6, j + 0, k + 0, wood, 0, 2);
		world.setBlock(i + 6, j + 0, k + 1, wood, 0, 2);
		world.setBlock(i + 6, j + 0, k + 2, wood, 0, 2);
		world.setBlock(i + 6, j + 0, k + 3, wood, 0, 2);
		world.setBlock(i + 6, j + 0, k + 4, wood, 0, 2);
		world.setBlock(i + 6, j + 0, k + 5, wood, 0, 2);
		world.setBlock(i + 6, j + 0, k + 6, wood, 0, 2);
		world.setBlock(i + 6, j + 0, k + 7, wood, 0, 2);
		world.setBlock(i + 6, j + 0, k + 8, wood, 0, 2);
		world.setBlock(i + 6, j + 1, k + 0, air);
		world.setBlock(i + 6, j + 1, k + 1, air);
		world.setBlock(i + 6, j + 1, k + 2, air);
		world.setBlock(i + 6, j + 1, k + 3, air);
		world.setBlock(i + 6, j + 1, k + 4, air);
		world.setBlock(i + 6, j + 1, k + 5, air);
		world.setBlock(i + 6, j + 1, k + 6, air);
		world.setBlock(i + 6, j + 1, k + 7, air);
		world.setBlock(i + 6, j + 1, k + 8, air);
		world.setBlock(i + 7, j + 0, k + 0, wood, 0, 2);
		world.setBlock(i + 7, j + 0, k + 1, tilledField, 0, 2);
		world.setBlock(i + 7, j + 0, k + 2, tilledField, 7, 2);
		world.setBlock(i + 7, j + 0, k + 3, tilledField, 0, 2);
		world.setBlock(i + 7, j + 0, k + 4, tilledField, 7, 2);
		world.setBlock(i + 7, j + 0, k + 5, tilledField, 7, 2);
		world.setBlock(i + 7, j + 0, k + 6, tilledField, 0, 2);
		world.setBlock(i + 7, j + 0, k + 7, tilledField, 7, 2);
		world.setBlock(i + 7, j + 0, k + 8, wood, 0, 2);
		world.setBlock(i + 7, j + 1, k + 0, air);
		world.setBlock(i + 7, j + 1, k + 8, air);
		world.setBlock(i + 8, j + 0, k + 0, wood, 0, 2);
		world.setBlock(i + 8, j + 0, k + 1, tilledField, 7, 2);
		world.setBlock(i + 8, j + 0, k + 2, tilledField, 7, 2);
		world.setBlock(i + 8, j + 0, k + 3, tilledField, 7, 2);
		world.setBlock(i + 8, j + 0, k + 4, tilledField, 7, 2);
		world.setBlock(i + 8, j + 0, k + 5, tilledField, 7, 2);
		world.setBlock(i + 8, j + 0, k + 6, tilledField, 7, 2);
		world.setBlock(i + 8, j + 0, k + 7, tilledField, 0, 2);
		world.setBlock(i + 8, j + 0, k + 8, wood, 0, 2);
		world.setBlock(i + 8, j + 1, k + 0, air);
		world.setBlock(i + 8, j + 1, k + 8, air);
		world.setBlock(i + 9, j + 0, k + 0, wood, 0, 2);
		world.setBlock(i + 9, j + 0, k + 8, wood, 0, 2);
		world.setBlock(i + 9, j + 1, k + 0, air);
		world.setBlock(i + 9, j + 1, k + 1, air);
		world.setBlock(i + 9, j + 1, k + 2, air);
		world.setBlock(i + 9, j + 1, k + 3, air);
		world.setBlock(i + 9, j + 1, k + 4, air);
		world.setBlock(i + 9, j + 1, k + 5, air);
		world.setBlock(i + 9, j + 1, k + 6, air);
		world.setBlock(i + 9, j + 1, k + 7, air);
		world.setBlock(i + 9, j + 1, k + 8, air);
		world.setBlock(i + 10, j + 0, k + 0, wood, 0, 2);
		world.setBlock(i + 10, j + 0, k + 1, tilledField, 7, 2);
		world.setBlock(i + 10, j + 0, k + 2, tilledField, 7, 2);
		world.setBlock(i + 10, j + 0, k + 3, tilledField, 7, 2);
		world.setBlock(i + 10, j + 0, k + 4, tilledField, 7, 2);
		world.setBlock(i + 10, j + 0, k + 5, tilledField, 7, 2);
		world.setBlock(i + 10, j + 0, k + 6, tilledField, 0, 2);
		world.setBlock(i + 10, j + 0, k + 7, tilledField, 0, 2);
		world.setBlock(i + 10, j + 0, k + 8, wood, 0, 2);
		world.setBlock(i + 10, j + 1, k + 0, air);
		world.setBlock(i + 10, j + 1, k + 8, air);
		world.setBlock(i + 11, j + 0, k + 0, wood, 0, 2);
		world.setBlock(i + 11, j + 0, k + 1, tilledField, 7, 2);
		world.setBlock(i + 11, j + 0, k + 2, tilledField, 7, 2);
		world.setBlock(i + 11, j + 0, k + 3, tilledField, 7, 2);
		world.setBlock(i + 11, j + 0, k + 4, tilledField, 0, 2);
		world.setBlock(i + 11, j + 0, k + 5, tilledField, 7, 2);
		world.setBlock(i + 11, j + 0, k + 6, tilledField, 0, 2);
		world.setBlock(i + 11, j + 0, k + 7, tilledField, 0, 2);
		world.setBlock(i + 11, j + 0, k + 8, wood, 0, 2);
		world.setBlock(i + 11, j + 1, k + 0, air);
		world.setBlock(i + 11, j + 1, k + 8, air);
		world.setBlock(i + 12, j + 0, k + 0, wood, 0, 2);
		world.setBlock(i + 12, j + 0, k + 1, wood, 0, 2);
		world.setBlock(i + 12, j + 0, k + 2, wood, 0, 2);
		world.setBlock(i + 12, j + 0, k + 3, wood, 0, 2);
		world.setBlock(i + 12, j + 0, k + 4, wood, 0, 2);
		world.setBlock(i + 12, j + 0, k + 5, wood, 0, 2);
		world.setBlock(i + 12, j + 0, k + 6, wood, 0, 2);
		world.setBlock(i + 12, j + 0, k + 7, wood, 0, 2);
		world.setBlock(i + 12, j + 0, k + 8, wood, 0, 2);
		world.setBlock(i + 12, j + 1, k + 0, air);
		world.setBlock(i + 12, j + 1, k + 1, air);
		world.setBlock(i + 12, j + 1, k + 2, air);
		world.setBlock(i + 12, j + 1, k + 3, air);
		world.setBlock(i + 12, j + 1, k + 4, air);
		world.setBlock(i + 12, j + 1, k + 5, air);
		world.setBlock(i + 12, j + 1, k + 6, air);
		world.setBlock(i + 12, j + 1, k + 7, air);
		world.setBlock(i + 12, j + 1, k + 8, air);
		world.setBlock(i + 1, j + 1, k + 1, wheat, 4, 2);
		world.setBlock(i + 1, j + 1, k + 2, wheat, 2, 2);
		world.setBlock(i + 1, j + 1, k + 3, wheat, 3, 2);
		world.setBlock(i + 1, j + 1, k + 4, wheat, 5, 2);
		world.setBlock(i + 1, j + 1, k + 5, wheat, 6, 2);
		world.setBlock(i + 1, j + 1, k + 6, wheat, 2, 2);
		world.setBlock(i + 1, j + 1, k + 7, potato, 7, 2);
		world.setBlock(i + 2, j + 1, k + 1, potato, 7, 2);
		world.setBlock(i + 2, j + 1, k + 2, potato, 4, 2);
		world.setBlock(i + 2, j + 1, k + 3, potato, 4, 2);
		world.setBlock(i + 2, j + 1, k + 4, potato, 4, 2);
		world.setBlock(i + 2, j + 1, k + 5, potato, 4, 2);
		world.setBlock(i + 2, j + 1, k + 6, potato, 7, 2);
		world.setBlock(i + 2, j + 1, k + 7, potato, 2, 2);
		world.setBlock(i + 3, j + 0, k + 1, water, 0, 2);
		world.setBlock(i + 3, j + 0, k + 2, water, 0, 2);
		world.setBlock(i + 3, j + 0, k + 3, water, 0, 2);
		world.setBlock(i + 3, j + 0, k + 4, water, 0, 2);
		world.setBlock(i + 3, j + 0, k + 5, water, 0, 2);
		world.setBlock(i + 3, j + 0, k + 6, water, 0, 2);
		world.setBlock(i + 3, j + 0, k + 7, water, 0, 2);
		world.setBlock(i + 4, j + 1, k + 1, potato, 2, 2);
		world.setBlock(i + 4, j + 1, k + 2, potato, 4, 2);
		world.setBlock(i + 4, j + 1, k + 3, potato, 5, 2);
		world.setBlock(i + 4, j + 1, k + 4, potato, 4, 2);
		world.setBlock(i + 4, j + 1, k + 5, wheat, 2, 2);
		world.setBlock(i + 4, j + 1, k + 6, wheat, 3, 2);
		world.setBlock(i + 4, j + 1, k + 7, wheat, 4, 2);
		world.setBlock(i + 5, j + 1, k + 1, wheat, 2, 2);
		world.setBlock(i + 5, j + 1, k + 2, wheat, 5, 2);
		world.setBlock(i + 5, j + 1, k + 3, wheat, 6, 2);
		world.setBlock(i + 5, j + 1, k + 4, wheat, 2, 2);
		world.setBlock(i + 5, j + 1, k + 5, wheat, 3, 2);
		world.setBlock(i + 5, j + 1, k + 6, wheat, 2, 2);
		world.setBlock(i + 5, j + 1, k + 7, wheat, 7, 2);
		world.setBlock(i + 7, j + 1, k + 1, wheat, 3, 2);
		world.setBlock(i + 7, j + 1, k + 2, wheat, 2, 2);
		world.setBlock(i + 7, j + 1, k + 3, wheat, 7, 2);
		world.setBlock(i + 7, j + 1, k + 4, wheat, 4, 2);
		world.setBlock(i + 7, j + 1, k + 5, wheat, 2, 2);
		world.setBlock(i + 7, j + 1, k + 6, wheat, 4, 2);
		world.setBlock(i + 7, j + 1, k + 7, wheat, 5, 2);
		world.setBlock(i + 8, j + 1, k + 1, wheat, 3, 2);
		world.setBlock(i + 8, j + 1, k + 2, wheat, 7, 2);
		world.setBlock(i + 8, j + 1, k + 3, wheat, 7, 2);
		world.setBlock(i + 8, j + 1, k + 4, wheat, 4, 2);
		world.setBlock(i + 8, j + 1, k + 5, wheat, 5, 2);
		world.setBlock(i + 8, j + 1, k + 6, wheat, 3, 2);
		world.setBlock(i + 8, j + 1, k + 7, wheat, 6, 2);
		world.setBlock(i + 9, j + 0, k + 1, water, 0, 2);
		world.setBlock(i + 9, j + 0, k + 2, water, 0, 2);
		world.setBlock(i + 9, j + 0, k + 3, water, 0, 2);
		world.setBlock(i + 9, j + 0, k + 4, water, 0, 2);
		world.setBlock(i + 9, j + 0, k + 5, water, 0, 2);
		world.setBlock(i + 9, j + 0, k + 6, water, 0, 2);
		world.setBlock(i + 9, j + 0, k + 7, water, 0, 2);
		world.setBlock(i + 10, j + 1, k + 1, potato, 4, 2);
		world.setBlock(i + 10, j + 1, k + 2, potato, 3, 2);
		world.setBlock(i + 10, j + 1, k + 3, potato, 4, 2);
		world.setBlock(i + 10, j + 1, k + 4, potato, 4, 2);
		world.setBlock(i + 10, j + 1, k + 5, potato, 2, 2);
		world.setBlock(i + 10, j + 1, k + 6, potato, 3, 2);
		world.setBlock(i + 10, j + 1, k + 7, potato, 3, 2);
		world.setBlock(i + 11, j + 1, k + 1, potato, 7, 2);
		world.setBlock(i + 11, j + 1, k + 2, wheat, 7, 2);
		world.setBlock(i + 11, j + 1, k + 3, potato, 5, 2);
		world.setBlock(i + 11, j + 1, k + 4, potato, 5, 2);
		world.setBlock(i + 11, j + 1, k + 5, wheat, 5, 2);
		world.setBlock(i + 11, j + 1, k + 6, wheat, 3, 2);
		world.setBlock(i + 11, j + 1, k + 7, wheat, 7, 2);
		
		for(int posX = i; posX <= i + 12; posX++)
			for(int posZ = k; posZ <= k + 8; posZ++){
				int posY = j - 1;	
				boolean isFloorFinished = false;
				while(isFloorFinished == false){					
					if(world.getBlock(posX, posY, posZ) == air || world.getBlock(posX, posY, posZ) == Blocks.tallgrass || world.getBlock(posX, posY, posZ) == Blocks.cactus || world.getBlock(posX, posY, posZ) == Blocks.red_flower || world.getBlock(posX, posY, posZ) == Blocks.yellow_flower || world.getBlock(posX, posY, posZ) == Blocks.deadbush || world.getBlock(posX, posY, posZ) == Blocks.snow || world.getBlock(posX, posY, posZ) == Blocks.water || world.getBlock(posX, posY, posZ) == Blocks.lava || world.getBlock(posX, posY, posZ) == Blocks.brown_mushroom || world.getBlock(posX, posY, posZ) == Blocks.red_mushroom || world.getBlock(posX, posY, posZ) == Blocks.waterlily){
						world.setBlock(posX, posY, posZ, Blocks.dirt, 0, 2);
						posY--;
					}
					else
						isFloorFinished = true;
				}	
			}
		
			EntityIllagerTrader var5 = new EntityIllagerTrader(world);
			var5.setPosition(i+7, j+2, k+4);
			world.spawnEntityInWorld(var5);
		
		return true;
	}
}
