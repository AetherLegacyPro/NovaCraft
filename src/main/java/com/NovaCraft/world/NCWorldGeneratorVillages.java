package com.NovaCraft.world;

import java.util.Random;

import org.apache.commons.lang3.ArrayUtils;

import com.NovaCraft.config.Configs;
import com.NovaCraft.registry.OtherModBlocks;
import com.NovaCraft.world.ancient_city.AncientCityPositiveHallwayGen1;
import com.NovaCraft.world.village.VindicatorWell;
import com.NovaCraftBlocks.NovaCraftBlocks;

import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.Loader;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSand;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

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

				 if(Configs.vindicatorVillageSpawnRate != 0) {
					 
					 if(world.getWorldInfo().getTerrainType().getWorldTypeID() == 1)
							num = rand.nextInt(((100 - Configs.vindicatorVillageSpawnRate) * 2) + 250);
						else
							num = rand.nextInt((100 - Configs.vindicatorVillageSpawnRate* 2) + 125);
					 
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
