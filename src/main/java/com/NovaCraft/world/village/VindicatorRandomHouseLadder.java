package com.NovaCraft.world.village;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class VindicatorRandomHouseLadder  extends WorldGenerator
{	

	public VindicatorRandomHouseLadder() { 
		
	}

	public boolean generate(World world, Random rand, int i, int j, int k) {
		
	world.setBlock(i, j, k, Blocks.air, 0, 2);
	world.setBlock(i + 1, j, k, Blocks.cobblestone, 0, 2);
	world.setBlock(i + 2, j, k, Blocks.cobblestone, 0, 2);
	world.setBlock(i, j, k + 1, Blocks.cobblestone, 0, 2);
	world.setBlock(i + 1, j, k + 1, Blocks.ladder, 3, 2);
	world.setBlock(i + 2, j, k + 1, Blocks.cobblestone, 0, 2);
	world.setBlock(i, j, k + 2, Blocks.cobblestone, 0, 2);
	world.setBlock(i + 1, j, k + 2, Blocks.cobblestone, 0, 2);
	world.setBlock(i + 2, j, k + 2, Blocks.cobblestone, 0, 2);
	world.setBlock(i, j + 1, k, Blocks.cobblestone, 0, 2);
	world.setBlock(i + 1, j + 1, k, Blocks.cobblestone, 0, 2);
	world.setBlock(i + 2, j + 1, k, Blocks.cobblestone, 0, 2);
	world.setBlock(i, j + 1, k + 1, Blocks.cobblestone, 0, 2);
	world.setBlock(i + 1, j + 1, k + 1, Blocks.ladder, 3, 2);
	world.setBlock(i + 2, j + 1, k + 1, Blocks.cobblestone, 0, 2);
	world.setBlock(i, j + 1, k + 2, Blocks.cobblestone, 0, 2);
	world.setBlock(i + 1, j + 1, k + 2, Blocks.cobblestone, 0, 2);
	world.setBlock(i + 2, j + 1, k + 2, Blocks.cobblestone, 0, 2);
	world.setBlock(i, j + 2, k, Blocks.cobblestone, 0, 2);
	world.setBlock(i + 1, j + 2, k, Blocks.cobblestone, 0, 2);
	world.setBlock(i + 2, j + 2, k, Blocks.cobblestone, 0, 2);
	world.setBlock(i, j + 2, k + 1, Blocks.cobblestone, 0, 2);
	world.setBlock(i + 1, j + 2, k + 1, Blocks.ladder, 3, 2);
	world.setBlock(i + 2, j + 2, k + 1, Blocks.cobblestone, 0, 2);
	world.setBlock(i, j + 2, k + 2, Blocks.cobblestone, 0, 2);
	world.setBlock(i + 1, j + 2, k + 2, Blocks.cobblestone, 0, 2);
	world.setBlock(i + 2, j + 2, k + 2, Blocks.cobblestone, 0, 2);
	world.setBlock(i, j + 3, k, Blocks.cobblestone, 0, 2);
	world.setBlock(i + 1, j + 3, k, Blocks.cobblestone, 0, 2);
	world.setBlock(i + 2, j + 3, k, Blocks.cobblestone, 0, 2);
	world.setBlock(i, j + 3, k + 1, Blocks.cobblestone, 0, 2);
	world.setBlock(i + 1, j + 3, k + 1, Blocks.ladder, 3, 2);
	world.setBlock(i + 2, j + 3, k + 1, Blocks.cobblestone, 0, 2);
	world.setBlock(i, j + 3, k + 2, Blocks.cobblestone, 0, 2);
	world.setBlock(i + 1, j + 3, k + 2, Blocks.cobblestone, 0, 2);
	world.setBlock(i + 2, j + 3, k + 2, Blocks.cobblestone, 0, 2);
	world.setBlock(i, j + 4, k, Blocks.cobblestone, 0, 2);
	world.setBlock(i + 1, j + 4, k, Blocks.cobblestone, 0, 2);
	world.setBlock(i + 2, j + 4, k, Blocks.cobblestone, 0, 2);
	world.setBlock(i, j + 4, k + 1, Blocks.cobblestone, 0, 2);
	world.setBlock(i + 1, j + 4, k + 1, Blocks.ladder, 3, 2);
	world.setBlock(i + 2, j + 4, k + 1, Blocks.cobblestone, 0, 2);
	world.setBlock(i, j + 4, k + 2, Blocks.cobblestone, 0, 2);
	world.setBlock(i + 1, j + 4, k + 2, Blocks.cobblestone, 0, 2);
	world.setBlock(i + 2, j + 4, k + 2, Blocks.cobblestone, 0, 2);
	
	return true;
	}

}
