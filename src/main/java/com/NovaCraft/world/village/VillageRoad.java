package com.NovaCraft.world.village;

import java.util.Random;

import com.NovaCraft.registry.OtherModBlocks;

import cpw.mods.fml.common.Loader;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class VillageRoad extends WorldGenerator
{
	public VillageRoad() { }

	public boolean generate(World world, Random rand, int i, int j, int k) {
		int posX, posY, posZ;

		/**
		 * Starts in one of the gravel extremes of the well
		 * position (0, 0, 0)
		 */
		/**
		 * Left road
		 */
		for(posX = i + 1; posX <= (i + 4); posX++)
			for(posZ = k - 1; posZ >= (k - 16); posZ--){
				if(world.getBlock(posX, j, posZ) != Blocks.air && world.getBlock(posX, j, posZ) != Blocks.tallgrass && world.getBlock(posX, j, posZ) != Blocks.sapling && world.getBlock(posX, j, posZ) != Blocks.deadbush && world.getBlock(posX, j, posZ) != Blocks.cactus && world.getBlock(posX, j, posZ) != Blocks.red_flower && world.getBlock(posX, j, posZ) != Blocks.yellow_flower && world.getBlock(posX, j, posZ) != Blocks.water && world.getBlock(posX, j, posZ) != Blocks.lava && world.getBlock(posX, j, posZ) != Blocks.log && world.getBlock(posX, j, posZ) != Blocks.leaves && world.getBlock(posX, j, posZ) != Blocks.vine && world.getBlock(posX, j, posZ) != Blocks.snow && (world.getBlock(posX, j + 1, posZ) == Blocks.air || world.getBlock(posX, j + 1, posZ) == Blocks.tallgrass || world.getBlock(posX, j + 1, posZ) == Blocks.sapling || world.getBlock(posX, j + 1, posZ) == Blocks.deadbush || world.getBlock(posX, j + 1, posZ) == Blocks.cactus || world.getBlock(posX, j + 1, posZ) == Blocks.red_flower || world.getBlock(posX, j + 1, posZ) == Blocks.yellow_flower || world.getBlock(posX, j + 1, posZ) == Blocks.log || world.getBlock(posX, j + 1, posZ) == Blocks.leaves || world.getBlock(posX, j + 1, posZ) == Blocks.vine || world.getBlock(posX, j + 1, posZ) == Blocks.snow))
				{
				  {
					if(Loader.isModLoaded("netherlicious")) {
					world.setBlock(posX, j, posZ, OtherModBlocks.Nether_Gravel, 0, 2);
					}
					else {
					world.setBlock(posX, j, posZ, Blocks.gravel, 0, 2);	
					}
				  }
				}
				else if(world.getBlock(posX, j, posZ) == Blocks.air || world.getBlock(posX, j, posZ) == Blocks.tallgrass || world.getBlock(posX, j, posZ) == Blocks.sapling || world.getBlock(posX, j, posZ) == Blocks.deadbush || world.getBlock(posX, j, posZ) == Blocks.cactus || world.getBlock(posX, j, posZ) == Blocks.red_flower || world.getBlock(posX, j, posZ) == Blocks.yellow_flower && world.getBlock(posX, j, posZ) == Blocks.log && world.getBlock(posX, j, posZ) == Blocks.leaves && world.getBlock(posX, j, posZ) == Blocks.vine && world.getBlock(posX, j, posZ) == Blocks.snow){
					boolean canMoveOn = false;
					posY = j - 1;
					while(canMoveOn == false){
						if(world.getBlock(posX, posY, posZ) == Blocks.water || world.getBlock(posX, posY, posZ) == Blocks.lava)
							canMoveOn = true;
						else if(world.getBlock(posX, posY, posZ) == Blocks.air || world.getBlock(posX, posY, posZ) == Blocks.tallgrass || world.getBlock(posX, posY, posZ) == Blocks.sapling || world.getBlock(posX, posY, posZ) == Blocks.deadbush || world.getBlock(posX, posY, posZ) == Blocks.cactus || world.getBlock(posX, posY, posZ) == Blocks.red_flower || world.getBlock(posX, posY, posZ) == Blocks.yellow_flower || world.getBlock(posX, posY, posZ) == Blocks.log || world.getBlock(posX, posY, posZ) == Blocks.leaves || world.getBlock(posX, posY, posZ) == Blocks.vine || world.getBlock(posX, posY, posZ) == Blocks.snow)
							posY--;
						else{
							 {
							if(Loader.isModLoaded("netherlicious")) {
							world.setBlock(posX, posY, posZ, OtherModBlocks.Nether_Gravel, 0, 2);
							canMoveOn = true;
							 }
							else{
								 {
								if(Loader.isModLoaded("netherlicious")) {
								world.setBlock(posX, posY, posZ, OtherModBlocks.Nether_Gravel, 0, 2);
								canMoveOn = true;
								 }
								else {
								world.setBlock(posX, posY, posZ, Blocks.gravel, 0, 2);
								canMoveOn = true;
								 }
								}
							}
							}
						}
					}
				}
				else if(world.getBlock(posX, j, posZ) != Blocks.air && world.getBlock(posX, j, posZ) != Blocks.tallgrass && world.getBlock(posX, j, posZ) != Blocks.sapling && world.getBlock(posX, j, posZ) != Blocks.deadbush && world.getBlock(posX, j, posZ) != Blocks.cactus && world.getBlock(posX, j, posZ) != Blocks.red_flower && world.getBlock(posX, j, posZ) != Blocks.yellow_flower && world.getBlock(posX, j, posZ) != Blocks.water && world.getBlock(posX, j, posZ) != Blocks.lava && world.getBlock(posX, j, posZ) != Blocks.log && world.getBlock(posX, j, posZ) != Blocks.leaves && world.getBlock(posX, j, posZ) != Blocks.vine && world.getBlock(posX, j, posZ) != Blocks.snow && world.getBlock(posX, j + 1, posZ) != Blocks.air && world.getBlock(posX, j + 1, posZ) != Blocks.tallgrass && world.getBlock(posX, j + 1, posZ) != Blocks.sapling && world.getBlock(posX, j + 1, posZ) != Blocks.deadbush && world.getBlock(posX, j + 1, posZ) != Blocks.cactus && world.getBlock(posX, j + 1, posZ) != Blocks.red_flower && world.getBlock(posX, j + 1, posZ) != Blocks.yellow_flower && world.getBlock(posX, j + 1, posZ) != Blocks.log && world.getBlock(posX, j + 1, posZ) != Blocks.leaves && world.getBlock(posX, j + 1, posZ) != Blocks.vine && world.getBlock(posX, j + 1, posZ) != Blocks.snow){
					boolean canMoveOn = false;
					posY = j + 1;
					while(canMoveOn == false){
						if(world.getBlock(posX, posY, posZ) == Blocks.water || world.getBlock(posX, posY, posZ) == Blocks.lava || world.getBlock(posX, posY + 1, posZ) == Blocks.water || world.getBlock(posX, posY + 1, posZ) == Blocks.lava)
							canMoveOn = true;
						else if((world.getBlock(posX, posY, posZ) != Blocks.air && world.getBlock(posX, posY, posZ) != Blocks.tallgrass && world.getBlock(posX, posY, posZ) != Blocks.sapling && world.getBlock(posX, posY, posZ) != Blocks.deadbush && world.getBlock(posX, posY, posZ) != Blocks.cactus && world.getBlock(posX, posY, posZ) != Blocks.red_flower && world.getBlock(posX, posY, posZ) != Blocks.yellow_flower && world.getBlock(posX, posY, posZ) != Blocks.water && world.getBlock(posX, posY, posZ) != Blocks.lava && world.getBlock(posX, posY, posZ) != Blocks.log && world.getBlock(posX, posY, posZ) != Blocks.leaves && world.getBlock(posX, posY, posZ) != Blocks.vine && world.getBlock(posX, posY, posZ) != Blocks.snow) && (world.getBlock(posX, posY + 1, posZ) != Blocks.air && world.getBlock(posX, posY + 1, posZ) != Blocks.tallgrass && world.getBlock(posX, posY + 1, posZ) != Blocks.sapling && world.getBlock(posX, posY + 1, posZ) != Blocks.deadbush && world.getBlock(posX, posY + 1, posZ) != Blocks.cactus && world.getBlock(posX, posY + 1, posZ) != Blocks.red_flower && world.getBlock(posX, posY + 1, posZ) != Blocks.yellow_flower && world.getBlock(posX, posY + 1, posZ) != Blocks.water && world.getBlock(posX, posY + 1, posZ) != Blocks.lava && world.getBlock(posX, posY + 1, posZ) != Blocks.log && world.getBlock(posX, posY + 1, posZ) != Blocks.leaves && world.getBlock(posX, posY + 1, posZ) != Blocks.vine && world.getBlock(posX, posY + 1, posZ) != Blocks.snow))
							posY++;
						else{
							 {
							if(Loader.isModLoaded("netherlicious")) {
							world.setBlock(posX, posY, posZ, OtherModBlocks.Nether_Gravel, 0, 2);
							canMoveOn = true;
							 }
							else{
								 {
								if(Loader.isModLoaded("netherlicious")) {
								world.setBlock(posX, posY, posZ, OtherModBlocks.Nether_Gravel, 0, 2);
								canMoveOn = true;
								 }
								else {
								world.setBlock(posX, posY, posZ, Blocks.gravel, 0, 2);
								canMoveOn = true;
								 }
								}
							}
							}
						}
					}
				}
			}

		/**
		 * Right road
		 */
		for(posX = i + 1; posX <= (i + 4); posX++)
			for(posZ = k + 6; posZ <= (k + 26); posZ++){
				if(world.getBlock(posX, j, posZ) != Blocks.air && world.getBlock(posX, j, posZ) != Blocks.tallgrass && world.getBlock(posX, j, posZ) != Blocks.sapling && world.getBlock(posX, j, posZ) != Blocks.deadbush && world.getBlock(posX, j, posZ) != Blocks.cactus && world.getBlock(posX, j, posZ) != Blocks.red_flower && world.getBlock(posX, j, posZ) != Blocks.yellow_flower && world.getBlock(posX, j, posZ) != Blocks.water && world.getBlock(posX, j, posZ) != Blocks.lava && world.getBlock(posX, j, posZ) != Blocks.log && world.getBlock(posX, j, posZ) != Blocks.leaves && world.getBlock(posX, j, posZ) != Blocks.vine && world.getBlock(posX, j, posZ) != Blocks.snow && (world.getBlock(posX, j + 1, posZ) == Blocks.air || world.getBlock(posX, j + 1, posZ) == Blocks.tallgrass || world.getBlock(posX, j + 1, posZ) == Blocks.sapling || world.getBlock(posX, j + 1, posZ) == Blocks.deadbush || world.getBlock(posX, j + 1, posZ) == Blocks.cactus || world.getBlock(posX, j + 1, posZ) == Blocks.red_flower || world.getBlock(posX, j + 1, posZ) == Blocks.yellow_flower || world.getBlock(posX, j + 1, posZ) == Blocks.log || world.getBlock(posX, j + 1, posZ) == Blocks.leaves || world.getBlock(posX, j + 1, posZ) == Blocks.vine || world.getBlock(posX, j + 1, posZ) == Blocks.snow))
				   {
					if(Loader.isModLoaded("netherlicious")) {
					world.setBlock(posX, j, posZ, OtherModBlocks.Nether_Gravel, 0, 2);
					}
					else {
					world.setBlock(posX, j, posZ, Blocks.gravel, 0, 2);	
					}
				  }
				else if(world.getBlock(posX, j, posZ) == Blocks.air || world.getBlock(posX, j, posZ) == Blocks.tallgrass || world.getBlock(posX, j, posZ) == Blocks.sapling || world.getBlock(posX, j, posZ) == Blocks.deadbush || world.getBlock(posX, j, posZ) == Blocks.cactus || world.getBlock(posX, j, posZ) == Blocks.red_flower || world.getBlock(posX, j, posZ) == Blocks.yellow_flower && world.getBlock(posX, j, posZ) == Blocks.log && world.getBlock(posX, j, posZ) == Blocks.leaves && world.getBlock(posX, j, posZ) == Blocks.vine && world.getBlock(posX, j, posZ) == Blocks.snow){
					boolean canMoveOn = false;
					posY = j - 1;
					while(canMoveOn == false){
						if(world.getBlock(posX, posY, posZ) == Blocks.water || world.getBlock(posX, posY, posZ) == Blocks.lava)
							canMoveOn = true;
						else if(world.getBlock(posX, posY, posZ) == Blocks.air || world.getBlock(posX, posY, posZ) == Blocks.tallgrass || world.getBlock(posX, posY, posZ) == Blocks.sapling || world.getBlock(posX, posY, posZ) == Blocks.deadbush || world.getBlock(posX, posY, posZ) == Blocks.cactus || world.getBlock(posX, posY, posZ) == Blocks.red_flower || world.getBlock(posX, posY, posZ) == Blocks.yellow_flower || world.getBlock(posX, posY, posZ) == Blocks.log || world.getBlock(posX, posY, posZ) == Blocks.leaves || world.getBlock(posX, posY, posZ) == Blocks.vine || world.getBlock(posX, posY, posZ) == Blocks.snow)
							posY--;
						else{
							 {
							if(Loader.isModLoaded("netherlicious")) {
							world.setBlock(posX, posY, posZ, OtherModBlocks.Nether_Gravel, 0, 2);
							canMoveOn = true;
							 }
							else {
							world.setBlock(posX, posY, posZ, Blocks.gravel, 0, 2);
							canMoveOn = true;
							 }
							}
						}
					}
				}
				else if(world.getBlock(posX, j, posZ) != Blocks.air && world.getBlock(posX, j, posZ) != Blocks.tallgrass && world.getBlock(posX, j, posZ) != Blocks.sapling && world.getBlock(posX, j, posZ) != Blocks.deadbush && world.getBlock(posX, j, posZ) != Blocks.cactus && world.getBlock(posX, j, posZ) != Blocks.red_flower && world.getBlock(posX, j, posZ) != Blocks.yellow_flower && world.getBlock(posX, j, posZ) != Blocks.water && world.getBlock(posX, j, posZ) != Blocks.lava && world.getBlock(posX, j, posZ) != Blocks.log && world.getBlock(posX, j, posZ) != Blocks.leaves && world.getBlock(posX, j, posZ) != Blocks.vine && world.getBlock(posX, j, posZ) != Blocks.snow && world.getBlock(posX, j + 1, posZ) != Blocks.air && world.getBlock(posX, j + 1, posZ) != Blocks.tallgrass && world.getBlock(posX, j + 1, posZ) != Blocks.sapling && world.getBlock(posX, j + 1, posZ) != Blocks.deadbush && world.getBlock(posX, j + 1, posZ) != Blocks.cactus && world.getBlock(posX, j + 1, posZ) != Blocks.red_flower && world.getBlock(posX, j + 1, posZ) != Blocks.yellow_flower && world.getBlock(posX, j + 1, posZ) != Blocks.log && world.getBlock(posX, j + 1, posZ) != Blocks.leaves && world.getBlock(posX, j + 1, posZ) != Blocks.vine && world.getBlock(posX, j + 1, posZ) != Blocks.snow){
					boolean canMoveOn = false;
					posY = j + 1;
					while(canMoveOn == false){
						if(world.getBlock(posX, posY, posZ) == Blocks.water || world.getBlock(posX, posY, posZ) == Blocks.lava || world.getBlock(posX, posY + 1, posZ) == Blocks.water || world.getBlock(posX, posY + 1, posZ) == Blocks.lava)
							canMoveOn = true;
						else if((world.getBlock(posX, posY, posZ) != Blocks.air && world.getBlock(posX, posY, posZ) != Blocks.tallgrass && world.getBlock(posX, posY, posZ) != Blocks.sapling && world.getBlock(posX, posY, posZ) != Blocks.deadbush && world.getBlock(posX, posY, posZ) != Blocks.cactus && world.getBlock(posX, posY, posZ) != Blocks.red_flower && world.getBlock(posX, posY, posZ) != Blocks.yellow_flower && world.getBlock(posX, posY, posZ) != Blocks.water && world.getBlock(posX, posY, posZ) != Blocks.lava && world.getBlock(posX, posY, posZ) != Blocks.log && world.getBlock(posX, posY, posZ) != Blocks.leaves && world.getBlock(posX, posY, posZ) != Blocks.vine && world.getBlock(posX, posY, posZ) != Blocks.snow) && (world.getBlock(posX, posY + 1, posZ) != Blocks.air && world.getBlock(posX, posY + 1, posZ) != Blocks.tallgrass && world.getBlock(posX, posY + 1, posZ) != Blocks.sapling && world.getBlock(posX, posY + 1, posZ) != Blocks.deadbush && world.getBlock(posX, posY + 1, posZ) != Blocks.cactus && world.getBlock(posX, posY + 1, posZ) != Blocks.red_flower && world.getBlock(posX, posY + 1, posZ) != Blocks.yellow_flower && world.getBlock(posX, posY + 1, posZ) != Blocks.water && world.getBlock(posX, posY + 1, posZ) != Blocks.lava && world.getBlock(posX, posY + 1, posZ) != Blocks.log && world.getBlock(posX, posY + 1, posZ) != Blocks.leaves && world.getBlock(posX, posY + 1, posZ) != Blocks.vine && world.getBlock(posX, posY + 1, posZ) != Blocks.snow))
							posY++;
						else{
							 {
							if(Loader.isModLoaded("netherlicious")) {
							world.setBlock(posX, posY, posZ, OtherModBlocks.Nether_Gravel, 0, 2);
							canMoveOn = true;
							 }
							else {
							world.setBlock(posX, posY, posZ, Blocks.gravel, 0, 2);
							canMoveOn = true;
							 }
							}
						}
					}
				}
			}

		/**
		 * Back road
		 */
		for(posZ = k + 1; posZ <= (k + 4); posZ++)
			for(posX = i - 1; posX >= (i - 25); posX--){
				if(world.getBlock(posX, j, posZ) != Blocks.air && world.getBlock(posX, j, posZ) != Blocks.tallgrass && world.getBlock(posX, j, posZ) != Blocks.sapling && world.getBlock(posX, j, posZ) != Blocks.deadbush && world.getBlock(posX, j, posZ) != Blocks.cactus && world.getBlock(posX, j, posZ) != Blocks.red_flower && world.getBlock(posX, j, posZ) != Blocks.yellow_flower && world.getBlock(posX, j, posZ) != Blocks.water && world.getBlock(posX, j, posZ) != Blocks.lava && world.getBlock(posX, j, posZ) != Blocks.log && world.getBlock(posX, j, posZ) != Blocks.leaves && world.getBlock(posX, j, posZ) != Blocks.vine && world.getBlock(posX, j, posZ) != Blocks.snow && (world.getBlock(posX, j + 1, posZ) == Blocks.air || world.getBlock(posX, j + 1, posZ) == Blocks.tallgrass || world.getBlock(posX, j + 1, posZ) == Blocks.sapling || world.getBlock(posX, j + 1, posZ) == Blocks.deadbush || world.getBlock(posX, j + 1, posZ) == Blocks.cactus || world.getBlock(posX, j + 1, posZ) == Blocks.red_flower || world.getBlock(posX, j + 1, posZ) == Blocks.yellow_flower || world.getBlock(posX, j + 1, posZ) == Blocks.log || world.getBlock(posX, j + 1, posZ) == Blocks.leaves || world.getBlock(posX, j + 1, posZ) == Blocks.vine || world.getBlock(posX, j + 1, posZ) == Blocks.snow))
				  {
					if(Loader.isModLoaded("netherlicious")) {
					world.setBlock(posX, j, posZ, OtherModBlocks.Nether_Gravel, 0, 2);
					}
					else {
					world.setBlock(posX, j, posZ, Blocks.gravel, 0, 2);	
					}
				  }
				else if(world.getBlock(posX, j, posZ) == Blocks.air || world.getBlock(posX, j, posZ) == Blocks.tallgrass || world.getBlock(posX, j, posZ) == Blocks.sapling || world.getBlock(posX, j, posZ) == Blocks.deadbush || world.getBlock(posX, j, posZ) == Blocks.cactus || world.getBlock(posX, j, posZ) == Blocks.red_flower || world.getBlock(posX, j, posZ) == Blocks.yellow_flower && world.getBlock(posX, j, posZ) == Blocks.log && world.getBlock(posX, j, posZ) == Blocks.leaves && world.getBlock(posX, j, posZ) == Blocks.vine && world.getBlock(posX, j, posZ) == Blocks.snow){
					boolean canMoveOn = false;
					posY = j - 1;
					while(canMoveOn == false){
						if(world.getBlock(posX, posY, posZ) == Blocks.water || world.getBlock(posX, posY, posZ) == Blocks.lava)
							canMoveOn = true;
						else if(world.getBlock(posX, posY, posZ) == Blocks.air || world.getBlock(posX, posY, posZ) == Blocks.tallgrass || world.getBlock(posX, posY, posZ) == Blocks.sapling || world.getBlock(posX, posY, posZ) == Blocks.deadbush || world.getBlock(posX, posY, posZ) == Blocks.cactus || world.getBlock(posX, posY, posZ) == Blocks.red_flower || world.getBlock(posX, posY, posZ) == Blocks.yellow_flower || world.getBlock(posX, posY, posZ) == Blocks.log || world.getBlock(posX, posY, posZ) == Blocks.leaves || world.getBlock(posX, posY, posZ) == Blocks.vine || world.getBlock(posX, posY, posZ) == Blocks.snow)
							posY--;
						else{
							 {
							if(Loader.isModLoaded("netherlicious")) {
							world.setBlock(posX, posY, posZ, OtherModBlocks.Nether_Gravel, 0, 2);
							canMoveOn = true;
							 }
							else {
							world.setBlock(posX, posY, posZ, Blocks.gravel, 0, 2);
							canMoveOn = true;
							 }
							}
						}
					}
				}
				else if(world.getBlock(posX, j, posZ) != Blocks.air && world.getBlock(posX, j, posZ) != Blocks.tallgrass && world.getBlock(posX, j, posZ) != Blocks.sapling && world.getBlock(posX, j, posZ) != Blocks.deadbush && world.getBlock(posX, j, posZ) != Blocks.cactus && world.getBlock(posX, j, posZ) != Blocks.red_flower && world.getBlock(posX, j, posZ) != Blocks.yellow_flower && world.getBlock(posX, j, posZ) != Blocks.water && world.getBlock(posX, j, posZ) != Blocks.lava && world.getBlock(posX, j, posZ) != Blocks.log && world.getBlock(posX, j, posZ) != Blocks.leaves && world.getBlock(posX, j, posZ) != Blocks.vine && world.getBlock(posX, j, posZ) != Blocks.snow && world.getBlock(posX, j + 1, posZ) != Blocks.air && world.getBlock(posX, j + 1, posZ) != Blocks.tallgrass && world.getBlock(posX, j + 1, posZ) != Blocks.sapling && world.getBlock(posX, j + 1, posZ) != Blocks.deadbush && world.getBlock(posX, j + 1, posZ) != Blocks.cactus && world.getBlock(posX, j + 1, posZ) != Blocks.red_flower && world.getBlock(posX, j + 1, posZ) != Blocks.yellow_flower && world.getBlock(posX, j + 1, posZ) != Blocks.log && world.getBlock(posX, j + 1, posZ) != Blocks.leaves && world.getBlock(posX, j + 1, posZ) != Blocks.vine && world.getBlock(posX, j + 1, posZ) != Blocks.snow){
					boolean canMoveOn = false;
					posY = j + 1;
					while(canMoveOn == false){
						if(world.getBlock(posX, posY, posZ) == Blocks.water || world.getBlock(posX, posY, posZ) == Blocks.lava || world.getBlock(posX, posY + 1, posZ) == Blocks.water || world.getBlock(posX, posY + 1, posZ) == Blocks.lava)
							canMoveOn = true;
						else if((world.getBlock(posX, posY, posZ) != Blocks.air && world.getBlock(posX, posY, posZ) != Blocks.tallgrass && world.getBlock(posX, posY, posZ) != Blocks.sapling && world.getBlock(posX, posY, posZ) != Blocks.deadbush && world.getBlock(posX, posY, posZ) != Blocks.cactus && world.getBlock(posX, posY, posZ) != Blocks.red_flower && world.getBlock(posX, posY, posZ) != Blocks.yellow_flower && world.getBlock(posX, posY, posZ) != Blocks.water && world.getBlock(posX, posY, posZ) != Blocks.lava && world.getBlock(posX, posY, posZ) != Blocks.log && world.getBlock(posX, posY, posZ) != Blocks.leaves && world.getBlock(posX, posY, posZ) != Blocks.vine && world.getBlock(posX, posY, posZ) != Blocks.snow) && (world.getBlock(posX, posY + 1, posZ) != Blocks.air && world.getBlock(posX, posY + 1, posZ) != Blocks.tallgrass && world.getBlock(posX, posY + 1, posZ) != Blocks.sapling && world.getBlock(posX, posY + 1, posZ) != Blocks.deadbush && world.getBlock(posX, posY + 1, posZ) != Blocks.cactus && world.getBlock(posX, posY + 1, posZ) != Blocks.red_flower && world.getBlock(posX, posY + 1, posZ) != Blocks.yellow_flower && world.getBlock(posX, posY + 1, posZ) != Blocks.water && world.getBlock(posX, posY + 1, posZ) != Blocks.lava && world.getBlock(posX, posY + 1, posZ) != Blocks.log && world.getBlock(posX, posY + 1, posZ) != Blocks.leaves && world.getBlock(posX, posY + 1, posZ) != Blocks.vine && world.getBlock(posX, posY + 1, posZ) != Blocks.snow))
							posY++;
						else{
							 {
							if(Loader.isModLoaded("netherlicious")) {
							world.setBlock(posX, posY, posZ, OtherModBlocks.Nether_Gravel, 0, 2);
							canMoveOn = true;
							 }
							else {
							world.setBlock(posX, posY, posZ, Blocks.gravel, 0, 2);
							canMoveOn = true;
							 }
							}
						}
					}
				}
			}

		/**
		 * Front road
		 */
		for(posZ = k + 1; posZ <= (k + 4); posZ++)
			for(posX = i + 6; posX <= (i + 25); posX++){
				if(world.getBlock(posX, j, posZ) != Blocks.air && world.getBlock(posX, j, posZ) != Blocks.tallgrass && world.getBlock(posX, j, posZ) != Blocks.sapling && world.getBlock(posX, j, posZ) != Blocks.deadbush && world.getBlock(posX, j, posZ) != Blocks.cactus && world.getBlock(posX, j, posZ) != Blocks.red_flower && world.getBlock(posX, j, posZ) != Blocks.yellow_flower && world.getBlock(posX, j, posZ) != Blocks.water && world.getBlock(posX, j, posZ) != Blocks.lava && world.getBlock(posX, j, posZ) != Blocks.log && world.getBlock(posX, j, posZ) != Blocks.leaves && world.getBlock(posX, j, posZ) != Blocks.vine && world.getBlock(posX, j, posZ) != Blocks.snow && (world.getBlock(posX, j + 1, posZ) == Blocks.air || world.getBlock(posX, j + 1, posZ) == Blocks.tallgrass || world.getBlock(posX, j + 1, posZ) == Blocks.sapling || world.getBlock(posX, j + 1, posZ) == Blocks.deadbush || world.getBlock(posX, j + 1, posZ) == Blocks.cactus || world.getBlock(posX, j + 1, posZ) == Blocks.red_flower || world.getBlock(posX, j + 1, posZ) == Blocks.yellow_flower || world.getBlock(posX, j + 1, posZ) == Blocks.log || world.getBlock(posX, j + 1, posZ) == Blocks.leaves || world.getBlock(posX, j + 1, posZ) == Blocks.vine || world.getBlock(posX, j + 1, posZ) == Blocks.snow))
				  {
					if(Loader.isModLoaded("netherlicious")) {
					world.setBlock(posX, j, posZ, OtherModBlocks.Nether_Gravel, 0, 2);
					}
					else {
					world.setBlock(posX, j, posZ, Blocks.gravel, 0, 2);	
					}
				  }
				else if(world.getBlock(posX, j, posZ) == Blocks.air || world.getBlock(posX, j, posZ) == Blocks.tallgrass || world.getBlock(posX, j, posZ) == Blocks.sapling || world.getBlock(posX, j, posZ) == Blocks.deadbush || world.getBlock(posX, j, posZ) == Blocks.cactus || world.getBlock(posX, j, posZ) == Blocks.red_flower || world.getBlock(posX, j, posZ) == Blocks.yellow_flower && world.getBlock(posX, j, posZ) == Blocks.log && world.getBlock(posX, j, posZ) == Blocks.leaves && world.getBlock(posX, j, posZ) == Blocks.vine && world.getBlock(posX, j, posZ) == Blocks.snow){
					boolean canMoveOn = false;
					posY = j - 1;
					while(canMoveOn == false){
						if(world.getBlock(posX, posY, posZ) == Blocks.water || world.getBlock(posX, posY, posZ) == Blocks.lava)
							canMoveOn = true;
						else if(world.getBlock(posX, posY, posZ) == Blocks.air || world.getBlock(posX, posY, posZ) == Blocks.tallgrass || world.getBlock(posX, posY, posZ) == Blocks.sapling || world.getBlock(posX, posY, posZ) == Blocks.deadbush || world.getBlock(posX, posY, posZ) == Blocks.cactus || world.getBlock(posX, posY, posZ) == Blocks.red_flower || world.getBlock(posX, posY, posZ) == Blocks.yellow_flower || world.getBlock(posX, posY, posZ) == Blocks.log || world.getBlock(posX, posY, posZ) == Blocks.leaves || world.getBlock(posX, posY, posZ) == Blocks.vine || world.getBlock(posX, posY, posZ) == Blocks.snow)
							posY--;
						else{
							 {
							if(Loader.isModLoaded("netherlicious")) {
							world.setBlock(posX, posY, posZ, OtherModBlocks.Nether_Gravel, 0, 2);
							canMoveOn = true;
							 }
							else {
							world.setBlock(posX, posY, posZ, Blocks.gravel, 0, 2);
							canMoveOn = true;
							 }
							}
						}
					}
				}
				else if(world.getBlock(posX, j, posZ) != Blocks.air && world.getBlock(posX, j, posZ) != Blocks.tallgrass && world.getBlock(posX, j, posZ) != Blocks.sapling && world.getBlock(posX, j, posZ) != Blocks.deadbush && world.getBlock(posX, j, posZ) != Blocks.cactus && world.getBlock(posX, j, posZ) != Blocks.red_flower && world.getBlock(posX, j, posZ) != Blocks.yellow_flower && world.getBlock(posX, j, posZ) != Blocks.water && world.getBlock(posX, j, posZ) != Blocks.lava && world.getBlock(posX, j, posZ) != Blocks.log && world.getBlock(posX, j, posZ) != Blocks.leaves && world.getBlock(posX, j, posZ) != Blocks.vine && world.getBlock(posX, j, posZ) != Blocks.snow && world.getBlock(posX, j + 1, posZ) != Blocks.air && world.getBlock(posX, j + 1, posZ) != Blocks.tallgrass && world.getBlock(posX, j + 1, posZ) != Blocks.sapling && world.getBlock(posX, j + 1, posZ) != Blocks.deadbush && world.getBlock(posX, j + 1, posZ) != Blocks.cactus && world.getBlock(posX, j + 1, posZ) != Blocks.red_flower && world.getBlock(posX, j + 1, posZ) != Blocks.yellow_flower && world.getBlock(posX, j + 1, posZ) != Blocks.log && world.getBlock(posX, j + 1, posZ) != Blocks.leaves && world.getBlock(posX, j + 1, posZ) != Blocks.vine && world.getBlock(posX, j + 1, posZ) != Blocks.snow){
					boolean canMoveOn = false;
					posY = j + 1;
					while(canMoveOn == false){
						if(world.getBlock(posX, posY, posZ) == Blocks.water || world.getBlock(posX, posY, posZ) == Blocks.lava || world.getBlock(posX, posY + 1, posZ) == Blocks.water || world.getBlock(posX, posY + 1, posZ) == Blocks.lava)
							canMoveOn = true;
						else if((world.getBlock(posX, posY, posZ) != Blocks.air && world.getBlock(posX, posY, posZ) != Blocks.tallgrass && world.getBlock(posX, posY, posZ) != Blocks.sapling && world.getBlock(posX, posY, posZ) != Blocks.deadbush && world.getBlock(posX, posY, posZ) != Blocks.cactus && world.getBlock(posX, posY, posZ) != Blocks.red_flower && world.getBlock(posX, posY, posZ) != Blocks.yellow_flower && world.getBlock(posX, posY, posZ) != Blocks.water && world.getBlock(posX, posY, posZ) != Blocks.lava && world.getBlock(posX, posY, posZ) != Blocks.log && world.getBlock(posX, posY, posZ) != Blocks.leaves && world.getBlock(posX, posY, posZ) != Blocks.vine && world.getBlock(posX, posY, posZ) != Blocks.snow) && (world.getBlock(posX, posY + 1, posZ) != Blocks.air && world.getBlock(posX, posY + 1, posZ) != Blocks.tallgrass && world.getBlock(posX, posY + 1, posZ) != Blocks.sapling && world.getBlock(posX, posY + 1, posZ) != Blocks.deadbush && world.getBlock(posX, posY + 1, posZ) != Blocks.cactus && world.getBlock(posX, posY + 1, posZ) != Blocks.red_flower && world.getBlock(posX, posY + 1, posZ) != Blocks.yellow_flower && world.getBlock(posX, posY + 1, posZ) != Blocks.water && world.getBlock(posX, posY + 1, posZ) != Blocks.lava && world.getBlock(posX, posY + 1, posZ) != Blocks.log && world.getBlock(posX, posY + 1, posZ) != Blocks.leaves && world.getBlock(posX, posY + 1, posZ) != Blocks.vine && world.getBlock(posX, posY + 1, posZ) != Blocks.snow))
							posY++;
						else{
							 {
							if(Loader.isModLoaded("netherlicious")) {
							world.setBlock(posX, posY, posZ, OtherModBlocks.Nether_Gravel, 0, 2);
							canMoveOn = true;
							 }
							else {
							world.setBlock(posX, posY, posZ, Blocks.gravel, 0, 2);
							canMoveOn = true;
							 }
							}
						}
					}
				}
			}

		/**
		 * Front Road
		 */
		new VillageHouseMedium().generate(world, rand, i + 13, j - 1, k - 11);	
		new VillageHouseSmallNoDoor().generate(world, rand, i + 15 , j - 1, k + 5);

		/**
		 * Back Road
		 */
		new VillageChurch().generate(world, rand, i - 18, j - 1, k - 9);
		new VillageHouseSmallNoDoor().generate(world, rand, i - 7 , j - 1, k + 5);	
		new VillageFarm().generate(world, rand, i - 22 , j, k + 5);	

		/**
		 * Left Road
		 */
		new VillageHouseSmallLadder().generate(world, rand, i + 5, j, k - 6);
		new VillageLargeHouse().generate(world, rand, i - 11 , j - 1, k - 11);
		new VillageHouseSmallDoor().generate(world, rand, i + 5, j - 1, k - 12);

		/**
		 * Right Road
		 */
		new VillageHouseLibrary().generate(world, rand, i - 8, j - 1, k + 13);		
		new VillageHouseSmallDoor().generate(world, rand, i + 5, j - 1, k + 20);
		new VillageBlacksmith().generate(world, rand, i + 5, j - 1, k + 8);	

		return true;
	}

	public boolean canAllHousesSpawn(World world, int i, int j, int k){
		if(	new VillageLargeHouse().checkAllLocations(world, i - 11 , j - 1, k - 11) &&
			new VillageHouseLibrary().checkAllLocations(world, i - 8, j - 1, k + 13))
			return true;
		else
			return false;		
	}
}
