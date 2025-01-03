package com.NovaCraft.world.village;

import java.util.Random;

import com.NovaCraft.config.Configs;
import com.NovaCraft.registry.OtherModBlocks;
import com.NovaCraftBlocks.NovaCraftBlocks;

import cpw.mods.fml.common.Loader;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class VindicatorWell extends WorldGenerator
{	
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

	public VindicatorWell() { }
	
	public boolean AirLocationIsValidSpawn(World world, int i, int j, int k){
		Block blockID = world.getBlock(i, j, k);
		Block blockIDAbove = world.getBlock(i, j+1, k);
		
		if (blockID != air || blockIDAbove != air){
			return false;
		}

		return true;
	}

	public boolean generate(World world, Random rand, int i, int j, int k) {
		Block cobbledGrimstone = NovaCraftBlocks.cobbled_grimstone;
		//check that each corner is one of the valid spawn blocks
		if(!LocationIsValidSpawn(world, i, j, k) || !LocationIsValidSpawn(world, i + 5, j, k) || !LocationIsValidSpawn(world, i + 5, j, k + 5) || !LocationIsValidSpawn(world, i, j, k + 5) ||          !AirLocationIsValidSpawn(world, i, j + 4, k) || !AirLocationIsValidSpawn(world, i + 5, j + 4, k) || !AirLocationIsValidSpawn(world, i + 5, j + 4, k + 5) || !AirLocationIsValidSpawn(world, i, j + 4, k + 5))
		{
			return false;
		}
		
		if(world.getBlock(i, j, k) == Blocks.sand && rand.nextInt((50 - Configs.vindicatorVillageSpawnRate) * 500) != 1)
			return false;
		
		if(new VindicatorRoad().canAllHousesSpawn(world, i, j, k) == false)
			return false;

		world.setBlock(i + 0, j + 1, k + 0, air);
		world.setBlock(i + 0, j + 1, k + 1, air);
		world.setBlock(i + 0, j + 1, k + 2, air);
		world.setBlock(i + 0, j + 1, k + 3, air);
		world.setBlock(i + 0, j + 1, k + 4, air);
		world.setBlock(i + 0, j + 1, k + 5, air);
		world.setBlock(i + 0, j + 2, k + 0, air);
		world.setBlock(i + 0, j + 2, k + 1, air);
		world.setBlock(i + 0, j + 2, k + 2, air);
		world.setBlock(i + 0, j + 2, k + 3, air);
		world.setBlock(i + 0, j + 2, k + 4, air);
		world.setBlock(i + 0, j + 2, k + 5, air);
		world.setBlock(i + 0, j + 3, k + 0, air);
		world.setBlock(i + 0, j + 3, k + 1, air);
		world.setBlock(i + 0, j + 3, k + 2, air);
		world.setBlock(i + 0, j + 3, k + 3, air);
		world.setBlock(i + 0, j + 3, k + 4, air);
		world.setBlock(i + 0, j + 3, k + 5, air);
		world.setBlock(i + 0, j + 4, k + 0, air);
		world.setBlock(i + 0, j + 4, k + 1, air);
		world.setBlock(i + 0, j + 4, k + 2, air);
		world.setBlock(i + 0, j + 4, k + 3, air);
		world.setBlock(i + 0, j + 4, k + 4, air);
		world.setBlock(i + 0, j + 4, k + 5, air);
		world.setBlock(i + 1, j + 0, k + 1, cobbledGrimstone, 0, 2);
		world.setBlock(i + 1, j + 0, k + 2, cobbledGrimstone, 0, 2);
		world.setBlock(i + 1, j + 0, k + 3, cobbledGrimstone, 0, 2);
		world.setBlock(i + 1, j + 0, k + 4, cobbledGrimstone, 0, 2);
		world.setBlock(i + 1, j + 1, k + 0, air);
		world.setBlock(i + 1, j + 1, k + 1, cobbledGrimstone, 0, 2);
		world.setBlock(i + 1, j + 1, k + 2, cobbledGrimstone, 0, 2);
		world.setBlock(i + 1, j + 1, k + 3, cobbledGrimstone, 0, 2);
		world.setBlock(i + 1, j + 1, k + 4, cobbledGrimstone, 0, 2);
		world.setBlock(i + 1, j + 1, k + 5, air);
		world.setBlock(i + 1, j + 2, k + 0, air);
		world.setBlock(i + 1, j + 2, k + 1, NovaCraftBlocks.cobbled_grimstone_wall, 0, 2);
		world.setBlock(i + 1, j + 2, k + 2, air);
		world.setBlock(i + 1, j + 2, k + 3, air);
		world.setBlock(i + 1, j + 2, k + 4, NovaCraftBlocks.cobbled_grimstone_wall, 0, 2);
		world.setBlock(i + 1, j + 2, k + 5, air);
		world.setBlock(i + 1, j + 3, k + 0, air);
		world.setBlock(i + 1, j + 3, k + 1, NovaCraftBlocks.cobbled_grimstone_wall, 0, 2);
		world.setBlock(i + 1, j + 3, k + 2, air);
		world.setBlock(i + 1, j + 3, k + 3, air);
		world.setBlock(i + 1, j + 3, k + 4, NovaCraftBlocks.cobbled_grimstone_wall, 0, 2);
		world.setBlock(i + 1, j + 3, k + 5, air);
		world.setBlock(i + 1, j + 4, k + 0, air);
		world.setBlock(i + 1, j + 4, k + 1, cobbledGrimstone, 0, 2);
		world.setBlock(i + 1, j + 4, k + 2, cobbledGrimstone, 0, 2);
		world.setBlock(i + 1, j + 4, k + 3, cobbledGrimstone, 0, 2);
		world.setBlock(i + 1, j + 4, k + 4, cobbledGrimstone, 0, 2);
		world.setBlock(i + 1, j + 4, k + 5, air);
		world.setBlock(i + 2, j + 0, k + 1, cobbledGrimstone, 0, 2);
		world.setBlock(i + 2, j + 0, k + 4, cobbledGrimstone, 0, 2);
		world.setBlock(i + 2, j + 1, k + 0, air);
		world.setBlock(i + 2, j + 1, k + 1, cobbledGrimstone, 0, 2);
		world.setBlock(i + 2, j + 1, k + 2, air);
		world.setBlock(i + 2, j + 1, k + 3, air);
		world.setBlock(i + 2, j + 1, k + 4, cobbledGrimstone, 0, 2);
		world.setBlock(i + 2, j + 1, k + 5, air);
		world.setBlock(i + 2, j + 2, k + 0, air);
		world.setBlock(i + 2, j + 2, k + 1, air);
		world.setBlock(i + 2, j + 2, k + 2, air);
		world.setBlock(i + 2, j + 2, k + 3, air);
		world.setBlock(i + 2, j + 2, k + 4, air);
		world.setBlock(i + 2, j + 2, k + 5, air);
		world.setBlock(i + 2, j + 3, k + 0, air);
		world.setBlock(i + 2, j + 3, k + 1, air);
		world.setBlock(i + 2, j + 3, k + 2, air);
		world.setBlock(i + 2, j + 3, k + 3, air);
		world.setBlock(i + 2, j + 3, k + 4, air);
		world.setBlock(i + 2, j + 3, k + 5, air);
		world.setBlock(i + 2, j + 4, k + 0, air);
		world.setBlock(i + 2, j + 4, k + 1, cobbledGrimstone, 0, 2);
		world.setBlock(i + 2, j + 4, k + 2, cobbledGrimstone, 0, 2);
		world.setBlock(i + 2, j + 4, k + 3, cobbledGrimstone, 0, 2);
		world.setBlock(i + 2, j + 4, k + 4, cobbledGrimstone, 0, 2);
		world.setBlock(i + 2, j + 4, k + 5, air);
		world.setBlock(i + 3, j + 0, k + 1, cobbledGrimstone, 0, 2);
		world.setBlock(i + 3, j + 0, k + 4, cobbledGrimstone, 0, 2);
		world.setBlock(i + 3, j + 1, k + 0, air);
		world.setBlock(i + 3, j + 1, k + 1, cobbledGrimstone, 0, 2);
		world.setBlock(i + 3, j + 1, k + 2, air);
		world.setBlock(i + 3, j + 1, k + 3, air);
		world.setBlock(i + 3, j + 1, k + 4, cobbledGrimstone, 0, 2);
		world.setBlock(i + 3, j + 1, k + 5, air);
		world.setBlock(i + 3, j + 2, k + 0, air);
		world.setBlock(i + 3, j + 2, k + 1, air);
		world.setBlock(i + 3, j + 2, k + 2, air);
		world.setBlock(i + 3, j + 2, k + 3, air);
		world.setBlock(i + 3, j + 2, k + 4, air);
		world.setBlock(i + 3, j + 2, k + 5, air);
		world.setBlock(i + 3, j + 3, k + 0, air);
		world.setBlock(i + 3, j + 3, k + 1, air);
		world.setBlock(i + 3, j + 3, k + 2, air);
		world.setBlock(i + 3, j + 3, k + 3, air);
		world.setBlock(i + 3, j + 3, k + 4, air);
		world.setBlock(i + 3, j + 3, k + 5, air);
		world.setBlock(i + 3, j + 4, k + 0, air);
		world.setBlock(i + 3, j + 4, k + 1, cobbledGrimstone, 0, 2);
		world.setBlock(i + 3, j + 4, k + 2, cobbledGrimstone, 0, 2);
		world.setBlock(i + 3, j + 4, k + 3, cobbledGrimstone, 0, 2);
		world.setBlock(i + 3, j + 4, k + 4, cobbledGrimstone, 0, 2);
		world.setBlock(i + 3, j + 4, k + 5, air);
		world.setBlock(i + 4, j + 0, k + 1, cobbledGrimstone, 0, 2);
		world.setBlock(i + 4, j + 0, k + 2, cobbledGrimstone, 0, 2);
		world.setBlock(i + 4, j + 0, k + 3, cobbledGrimstone, 0, 2);
		world.setBlock(i + 4, j + 0, k + 4, cobbledGrimstone, 0, 2);
		world.setBlock(i + 4, j + 1, k + 0, air);
		world.setBlock(i + 4, j + 1, k + 1, cobbledGrimstone, 0, 2);
		world.setBlock(i + 4, j + 1, k + 2, cobbledGrimstone, 0, 2);
		world.setBlock(i + 4, j + 1, k + 3, cobbledGrimstone, 0, 2);
		world.setBlock(i + 4, j + 1, k + 4, cobbledGrimstone, 0, 2);
		world.setBlock(i + 4, j + 1, k + 5, air);
		world.setBlock(i + 4, j + 2, k + 0, air);
		world.setBlock(i + 4, j + 2, k + 1, NovaCraftBlocks.cobbled_grimstone_wall, 0, 2);
		world.setBlock(i + 4, j + 2, k + 2, air);
		world.setBlock(i + 4, j + 2, k + 3, air);
		world.setBlock(i + 4, j + 2, k + 4, NovaCraftBlocks.cobbled_grimstone_wall, 0, 2);
		world.setBlock(i + 4, j + 2, k + 5, air);
		world.setBlock(i + 4, j + 3, k + 0, air);
		world.setBlock(i + 4, j + 3, k + 1, NovaCraftBlocks.cobbled_grimstone_wall, 0, 2);
		world.setBlock(i + 4, j + 3, k + 2, air);
		world.setBlock(i + 4, j + 3, k + 3, air);
		world.setBlock(i + 4, j + 3, k + 4, NovaCraftBlocks.cobbled_grimstone_wall, 0, 2);
		world.setBlock(i + 4, j + 3, k + 5, air);
		world.setBlock(i + 4, j + 4, k + 0, air);
		world.setBlock(i + 4, j + 4, k + 1, cobbledGrimstone, 0, 2);
		world.setBlock(i + 4, j + 4, k + 2, cobbledGrimstone, 0, 2);
		world.setBlock(i + 4, j + 4, k + 3, cobbledGrimstone, 0, 2);
		world.setBlock(i + 4, j + 4, k + 4, cobbledGrimstone, 0, 2);
		world.setBlock(i + 4, j + 4, k + 5, air);
		world.setBlock(i + 5, j + 1, k + 0, air);
		world.setBlock(i + 5, j + 1, k + 1, air);
		world.setBlock(i + 5, j + 1, k + 2, air);
		world.setBlock(i + 5, j + 1, k + 3, air);
		world.setBlock(i + 5, j + 1, k + 4, air);
		world.setBlock(i + 5, j + 1, k + 5, air);
		world.setBlock(i + 5, j + 2, k + 0, air);
		world.setBlock(i + 5, j + 2, k + 1, air);
		world.setBlock(i + 5, j + 2, k + 2, air);
		world.setBlock(i + 5, j + 2, k + 3, air);
		world.setBlock(i + 5, j + 2, k + 4, air);
		world.setBlock(i + 5, j + 2, k + 5, air);
		world.setBlock(i + 5, j + 3, k + 0, air);
		world.setBlock(i + 5, j + 3, k + 1, air);
		world.setBlock(i + 5, j + 3, k + 2, air);
		world.setBlock(i + 5, j + 3, k + 3, air);
		world.setBlock(i + 5, j + 3, k + 4, air);
		world.setBlock(i + 5, j + 3, k + 5, air);
		world.setBlock(i + 5, j + 4, k + 0, air);
		world.setBlock(i + 5, j + 4, k + 1, air);
		world.setBlock(i + 5, j + 4, k + 2, air);
		world.setBlock(i + 5, j + 4, k + 3, air);
		world.setBlock(i + 5, j + 4, k + 4, air);
		world.setBlock(i + 5, j + 4, k + 5, air);
		{
		if(Loader.isModLoaded("netherlicious")) {
		world.setBlock(i + 0, j + 0, k + 0, OtherModBlocks.Nether_Gravel, 0, 2);
		world.setBlock(i + 0, j + 0, k + 1, OtherModBlocks.Nether_Gravel, 0, 2);
		world.setBlock(i + 0, j + 0, k + 2, OtherModBlocks.Nether_Gravel, 0, 2);
		world.setBlock(i + 0, j + 0, k + 3, OtherModBlocks.Nether_Gravel, 0, 2);
		world.setBlock(i + 0, j + 0, k + 4, OtherModBlocks.Nether_Gravel, 0, 2);
		world.setBlock(i + 0, j + 0, k + 5, OtherModBlocks.Nether_Gravel, 0, 2);
		world.setBlock(i + 1, j + 0, k + 0, OtherModBlocks.Nether_Gravel, 0, 2);
		world.setBlock(i + 1, j + 0, k + 5, OtherModBlocks.Nether_Gravel, 0, 2);
		world.setBlock(i + 2, j + 0, k + 0, OtherModBlocks.Nether_Gravel, 0, 2);
		world.setBlock(i + 2, j + 0, k + 5, OtherModBlocks.Nether_Gravel, 0, 2);
		world.setBlock(i + 3, j + 0, k + 0, OtherModBlocks.Nether_Gravel, 0, 2);
		world.setBlock(i + 3, j + 0, k + 5, OtherModBlocks.Nether_Gravel, 0, 2);
		world.setBlock(i + 4, j + 0, k + 0, OtherModBlocks.Nether_Gravel, 0, 2);
		world.setBlock(i + 4, j + 0, k + 5, OtherModBlocks.Nether_Gravel, 0, 2);
		world.setBlock(i + 5, j + 0, k + 0, OtherModBlocks.Nether_Gravel, 0, 2);
		world.setBlock(i + 5, j + 0, k + 1, OtherModBlocks.Nether_Gravel, 0, 2);
		world.setBlock(i + 5, j + 0, k + 2, OtherModBlocks.Nether_Gravel, 0, 2);
		world.setBlock(i + 5, j + 0, k + 3, OtherModBlocks.Nether_Gravel, 0, 2);
		world.setBlock(i + 5, j + 0, k + 4, OtherModBlocks.Nether_Gravel, 0, 2);
		world.setBlock(i + 5, j + 0, k + 5, OtherModBlocks.Nether_Gravel, 0, 2);
		} 
		else {
			world.setBlock(i + 0, j + 0, k + 0, Blocks.gravel, 0, 2);
			world.setBlock(i + 0, j + 0, k + 1, Blocks.gravel, 0, 2);
			world.setBlock(i + 0, j + 0, k + 2, Blocks.gravel, 0, 2);
			world.setBlock(i + 0, j + 0, k + 3, Blocks.gravel, 0, 2);
			world.setBlock(i + 0, j + 0, k + 4, Blocks.gravel, 0, 2);
			world.setBlock(i + 0, j + 0, k + 5, Blocks.gravel, 0, 2);
			world.setBlock(i + 1, j + 0, k + 0, Blocks.gravel, 0, 2);
			world.setBlock(i + 1, j + 0, k + 5, Blocks.gravel, 0, 2);
			world.setBlock(i + 2, j + 0, k + 0, Blocks.gravel, 0, 2);
			world.setBlock(i + 2, j + 0, k + 5, Blocks.gravel, 0, 2);
			world.setBlock(i + 3, j + 0, k + 0, Blocks.gravel, 0, 2);
			world.setBlock(i + 3, j + 0, k + 5, Blocks.gravel, 0, 2);
			world.setBlock(i + 4, j + 0, k + 0, Blocks.gravel, 0, 2);
			world.setBlock(i + 4, j + 0, k + 5, Blocks.gravel, 0, 2);
			world.setBlock(i + 5, j + 0, k + 0, Blocks.gravel, 0, 2);
			world.setBlock(i + 5, j + 0, k + 1, Blocks.gravel, 0, 2);
			world.setBlock(i + 5, j + 0, k + 2, Blocks.gravel, 0, 2);
			world.setBlock(i + 5, j + 0, k + 3, Blocks.gravel, 0, 2);
			world.setBlock(i + 5, j + 0, k + 4, Blocks.gravel, 0, 2);
			world.setBlock(i + 5, j + 0, k + 5, Blocks.gravel, 0, 2);	
		 }
		}
		
		world.setBlock(i + 2, j - 1, k + 2, air);
		world.setBlock(i + 2, j - 1, k + 3, air);
		world.setBlock(i + 3, j - 1, k + 2, air);
		world.setBlock(i + 3, j - 1, k + 3, air);
		
		for(int posX = i; posX <= i + 5; posX++)
			for(int posZ = k; posZ <= k + 5; posZ++){
				int posY = j - 1;				
				boolean isFloorFinished = false;
				while(isFloorFinished == false){	
					if(world.getBlock(posX, posY, posZ) == air || world.getBlock(posX, posY, posZ) == Blocks.tallgrass || world.getBlock(posX, posY, posZ) == Blocks.cactus || world.getBlock(posX, posY, posZ) == Blocks.red_flower || world.getBlock(posX, posY, posZ) == Blocks.yellow_flower || world.getBlock(posX, posY, posZ) == Blocks.deadbush || world.getBlock(posX, posY, posZ) == Blocks.snow || world.getBlock(posX, posY, posZ) == Blocks.water || world.getBlock(posX, posY, posZ) == Blocks.water || world.getBlock(posX, posY, posZ) == Blocks.brown_mushroom || world.getBlock(posX, posY, posZ) == Blocks.red_mushroom || world.getBlock(posX, posY, posZ) == Blocks.waterlily){
						world.setBlock(posX, posY, posZ, cobbledGrimstone, 0, 2);
						posY--;
					}
					else
						isFloorFinished = true;
				}
			}

		world.setBlock(i + 2, j + 0, k + 2, Blocks.water, 0, 2);
		world.setBlock(i + 2, j + 0, k + 3, Blocks.water, 0, 2);
		world.setBlock(i + 3, j + 0, k + 2, Blocks.water, 0, 2);
		world.setBlock(i + 3, j + 0, k + 3, Blocks.water, 0, 2);
		world.setBlock(i + 2, j - 1, k + 2, Blocks.water, 0, 2);
		world.setBlock(i + 2, j - 1, k + 3, Blocks.water, 0, 2);
		world.setBlock(i + 3, j - 1, k + 2, Blocks.water, 0, 2);
		world.setBlock(i + 3, j - 1, k + 3, Blocks.water, 0, 2);
		world.setBlock(i + 2, j - 2, k + 2, Blocks.water, 0, 2);
		world.setBlock(i + 2, j - 2, k + 3, Blocks.water, 0, 2);
		world.setBlock(i + 3, j - 2, k + 2, Blocks.water, 0, 2);
		world.setBlock(i + 3, j - 2, k + 3, Blocks.water, 0, 2);
		
		new VindicatorRoad().generate(world, rand, i, j, k);
		
		return true;
	}
}
