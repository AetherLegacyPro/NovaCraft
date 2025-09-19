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
		
	world.setBlock(i + 0, j + 0, k + 0, Blocks.air, 0, 2);
	world.setBlock(i + 1, j + 0, k + 0, Blocks.cobblestone, 0, 2);
	world.setBlock(i + 2, j + 0, k + 0, Blocks.cobblestone, 0, 2);
	world.setBlock(i + 0, j + 0, k + 1, Blocks.cobblestone, 0, 2);
	world.setBlock(i + 1, j + 0, k + 1, Blocks.ladder, 3, 2);
	world.setBlock(i + 2, j + 0, k + 1, Blocks.cobblestone, 0, 2);
	world.setBlock(i + 0, j + 0, k + 2, Blocks.cobblestone, 0, 2);
	world.setBlock(i + 1, j + 0, k + 2, Blocks.cobblestone, 0, 2);
	world.setBlock(i + 2, j + 0, k + 2, Blocks.cobblestone, 0, 2);
	world.setBlock(i + 0, j + 1, k + 0, Blocks.cobblestone, 0, 2);
	world.setBlock(i + 1, j + 1, k + 0, Blocks.cobblestone, 0, 2);
	world.setBlock(i + 2, j + 1, k + 0, Blocks.cobblestone, 0, 2);
	world.setBlock(i + 0, j + 1, k + 1, Blocks.cobblestone, 0, 2);
	world.setBlock(i + 1, j + 1, k + 1, Blocks.ladder, 3, 2);
	world.setBlock(i + 2, j + 1, k + 1, Blocks.cobblestone, 0, 2);
	world.setBlock(i + 0, j + 1, k + 2, Blocks.cobblestone, 0, 2);
	world.setBlock(i + 1, j + 1, k + 2, Blocks.cobblestone, 0, 2);
	world.setBlock(i + 2, j + 1, k + 2, Blocks.cobblestone, 0, 2);
	world.setBlock(i + 0, j + 2, k + 0, Blocks.cobblestone, 0, 2);
	world.setBlock(i + 1, j + 2, k + 0, Blocks.cobblestone, 0, 2);
	world.setBlock(i + 2, j + 2, k + 0, Blocks.cobblestone, 0, 2);
	world.setBlock(i + 0, j + 2, k + 1, Blocks.cobblestone, 0, 2);
	world.setBlock(i + 1, j + 2, k + 1, Blocks.ladder, 3, 2);
	world.setBlock(i + 2, j + 2, k + 1, Blocks.cobblestone, 0, 2);
	world.setBlock(i + 0, j + 2, k + 2, Blocks.cobblestone, 0, 2);
	world.setBlock(i + 1, j + 2, k + 2, Blocks.cobblestone, 0, 2);
	world.setBlock(i + 2, j + 2, k + 2, Blocks.cobblestone, 0, 2);
	world.setBlock(i + 0, j + 3, k + 0, Blocks.cobblestone, 0, 2);
	world.setBlock(i + 1, j + 3, k + 0, Blocks.cobblestone, 0, 2);
	world.setBlock(i + 2, j + 3, k + 0, Blocks.cobblestone, 0, 2);
	world.setBlock(i + 0, j + 3, k + 1, Blocks.cobblestone, 0, 2);
	world.setBlock(i + 1, j + 3, k + 1, Blocks.ladder, 3, 2);
	world.setBlock(i + 2, j + 3, k + 1, Blocks.cobblestone, 0, 2);
	world.setBlock(i + 0, j + 3, k + 2, Blocks.cobblestone, 0, 2);
	world.setBlock(i + 1, j + 3, k + 2, Blocks.cobblestone, 0, 2);
	world.setBlock(i + 2, j + 3, k + 2, Blocks.cobblestone, 0, 2);
	world.setBlock(i + 0, j + 4, k + 0, Blocks.cobblestone, 0, 2);
	world.setBlock(i + 1, j + 4, k + 0, Blocks.cobblestone, 0, 2);
	world.setBlock(i + 2, j + 4, k + 0, Blocks.cobblestone, 0, 2);
	world.setBlock(i + 0, j + 4, k + 1, Blocks.cobblestone, 0, 2);
	world.setBlock(i + 1, j + 4, k + 1, Blocks.ladder, 3, 2);
	world.setBlock(i + 2, j + 4, k + 1, Blocks.cobblestone, 0, 2);
	world.setBlock(i + 0, j + 4, k + 2, Blocks.cobblestone, 0, 2);
	world.setBlock(i + 1, j + 4, k + 2, Blocks.cobblestone, 0, 2);
	world.setBlock(i + 2, j + 4, k + 2, Blocks.cobblestone, 0, 2);
	
	return true;
	}

}
