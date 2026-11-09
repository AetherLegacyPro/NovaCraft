package com.NovaCraft.world;

import java.util.Random;
import com.NovaCraft.config.ConfigsStructures;
import com.NovaCraft.world.village.VindicatorWell;
import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;

public class NCWorldGeneratorVillages implements IWorldGenerator {
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		if (world.provider.dimensionId == 0) {
			this.generateOverworldStructures(world, random, chunkX*16, chunkZ*16);
     	}
	}
	 	
	 	public void generateOverworldStructures(World world, Random rand, int x, int z) {
	 		//Vindicator Villages
			int i, j, k, num;
			i = j = k = -1;
			num = 0;
			BiomeGenBase biomegenbase = world.getWorldChunkManager().getBiomeGenAt(x, z);
			if(world.getWorldInfo().getTerrainType().getWorldTypeID() != 1){

				 if(ConfigsStructures.vindicatorVillageSpawnRate != 0) {
					 
					 if(world.getWorldInfo().getTerrainType().getWorldTypeID() == 1) {
						 num = rand.nextInt(((100 - ConfigsStructures.vindicatorVillageSpawnRate) * 2) + 1000);
					 } else {
						 num = rand.nextInt((100 - ConfigsStructures.vindicatorVillageSpawnRate * 2) + 500);
					 }
					if(num == 1){
						i = x + rand.nextInt(16) + 8;
						j = z + rand.nextInt(16) + 8;
						k = world.getTopSolidOrLiquidBlock(i, j);
						if (k <= 0);
						new VindicatorWell().generate(world, rand, i, k, j);
					}
				}
				 
		    }
	 	}
}
