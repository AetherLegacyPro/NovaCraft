package com.NovaCraft.world;

import java.util.Random;

import com.NovaCraft.config.Configs;
import com.NovaCraft.registry.OtherModBlocks;
import com.NovaCraft.world.structure.SculkDwelling;
import com.NovaCraft.world.village.VillageWell;
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

public class NCWorldGeneratorPre implements IWorldGenerator {

	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch (world.provider.dimensionId) {
		case -1:
			generateNether(world, random, chunkX*16, chunkZ*16);
			break;
		case 0:
			generateOverworld(world, random, chunkX*16, chunkZ*16);
			break;
		}
	}

	public void generateOverworld(World world, Random rand, int x, int z) {			
			int i, j, k, num;
			i = j = k = -1;
			num = 0;		
			
			BiomeGenBase biomegenbase = world.getWorldChunkManager().getBiomeGenAt(x, z);
			if(world.getWorldInfo().getTerrainType().getWorldTypeID() != 1){

				/**
				 * Villages generation
				 */if(Configs.vindicatorVillageSpawnRate != 0) {
					if(world.getWorldInfo().getTerrainType().getWorldTypeID() == 1)
						num = rand.nextInt(((100 - Configs.vindicatorVillageSpawnRate) * 2) + 250);
					else
						num = rand.nextInt((100 - Configs.vindicatorVillageSpawnRate* 2) + 125);

					if(num == 1){
						i = x + rand.nextInt(16) + 8;
						j = z + rand.nextInt(16) + 8;
						k = world.getTopSolidOrLiquidBlock(i, j);
						if (k <= 0);
						new VillageWell().generate(world, rand, i, k, j);
			 }
		   }										
		  }
			if(Configs.sculkDwellingSpawnRate != 0) {
			final int num2 = rand.nextInt(80);
	        if (num2 == 1) {
	            final int X2 = x + rand.nextInt(16);
	            final int Y2 = 64 + rand.nextInt(6);
	            final int Z2 = z + rand.nextInt(16);
	            new SculkDwelling().generate(world, rand, X2, Y2, Z2);
	        }
	   	   
	   }
	}
	
	public void generateNether(World world, Random rand, int x, int z) {
		
	}
}

