package com.NovaCraft.world;

import java.util.Random;

import org.apache.commons.lang3.ArrayUtils;

import com.NovaCraft.config.Configs;
import com.NovaCraft.registry.OtherModBlocks;
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

public class NCWorldGenerator implements IWorldGenerator {
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
	if ((ArrayUtils.contains(Configs.DeeperCavesBlacklist, world.provider.dimensionId) == Configs.DeeperCavesBlacklistAsWhitelist)) {
			generateOverworld(world, random, chunkX, chunkZ);
		}  else {
			switch (world.provider.dimensionId) {
			case 1:
				generateEnd(world, random, chunkX, chunkZ);
				break;
			case 0:
				generateOverworld(world, random, chunkX, chunkZ);
				break;
			case -1:
				generateNether(world, random, chunkX, chunkZ);
				break;
			}
		}
	}
	
	public void generateNether(World world, Random rand, int x, int z) {
		
	}
	
	public void generateEnd(World world, Random rand, int x, int z) {
		if (Configs.enableEndstoneBlobs && rand.nextInt(3) == 2) {
			generateOre(Blocks.end_stone, world, rand, x, z, 1, 100, 1, 1, 96,
				Blocks.air);
			}
		
		if (rand.nextInt(10) == 1) {
			generateOre(NovaCraftBlocks.frontierslate, world, rand, x, z, 1, 100, 2, 0, 10,
					Blocks.air);
			}
		
		generateOre(NovaCraftBlocks.crystallized_end, world, rand, x, z, 5, 6, 10, 0, 16,
				NovaCraftBlocks.frontierslate);
		
		generateOre(NovaCraftBlocks.frontierslate, world, rand, x, z, 1, 100, 1, 1, 44,
				Blocks.end_stone);
		
		generateOre(NovaCraftBlocks.vacuum_sand, world, rand, x, z, 1, 50, 1, 48, 128,
				Blocks.end_stone);
	}
	    
	    //generates grimstone and nullstone into the world
	 	public void generateOre(Block block, World world, Random random,
				int chunkX, int chunkZ, int minVienSize, int maxVienSize,
				int chance, int minY, int maxY, Block generateIn) {
			int VienSize = minVienSize + random.nextInt(maxVienSize - minVienSize);
			int hightRange = maxY - minY;
			WorldGenMinable gen = new WorldGenMinable(block, VienSize, generateIn);
			for (int i = 0; i < chance; i++) {
				int xRand = chunkX * 16 + random.nextInt(16);
				int yRand = random.nextInt(hightRange) + minY;
				int zRand = chunkZ * 16 + random.nextInt(16);
				gen.generate(world, random, xRand, yRand, zRand);
			}
		}
	 	
	 	public void generateOverworld(World world, Random rand, int x, int z) {
	 		if (Configs.enableGrimstone == true) {
			generateOre(NovaCraftBlocks.grimstone, world, rand, x, z, 1, 100, 1, 8, 24,
					Blocks.stone);
			if (ArrayUtils.contains(Configs.DeeperCavesBlacklist, world.provider.dimensionId) == Configs.DeeperCavesBlacklistAsWhitelist) {
			generateOre(NovaCraftBlocks.grimstone, world, rand, x, z, 1, 100, 1, 8, 256,
					Blocks.stone);	
				}
	 		}
			
			if (Configs.enableNullstone == true) {
			generateOre(NovaCraftBlocks.nullstone, world, rand, x, z, 1, 90, 2, 0, 18,
					Blocks.stone);
			if (ArrayUtils.contains(Configs.DeeperCavesBlacklist, world.provider.dimensionId) == Configs.DeeperCavesBlacklistAsWhitelist) {
			generateOre(NovaCraftBlocks.nullstone, world, rand, x, z, 1, 80, 2, 0, 256,
					Blocks.stone);
				}
			}
			
			if (Loader.isModLoaded("etfuturum") && ArrayUtils.contains(Configs.DeeperCavesBlacklist, world.provider.dimensionId) == Configs.DeeperCavesBlacklistAsWhitelist) {
			generateOre(OtherModBlocks.deepslate, world, rand, x, z, 1, 30, 2, 26, 226,
					Blocks.stone);
			}
								
			if (Configs.enableEtherstone == true && !(ArrayUtils.contains(Configs.DeeperCavesBlacklist, world.provider.dimensionId) == Configs.DeeperCavesBlacklistAsWhitelist)) {
			generateOre(NovaCraftBlocks.etherstone, world, rand, x, z, 1, 90, 2, 85, 256,
					Blocks.stone);
			}
			
			if (Loader.isModLoaded("etfuturum") && (Configs.enableCalciteGeneration) && !(ArrayUtils.contains(Configs.DeeperCavesBlacklist, world.provider.dimensionId) == Configs.DeeperCavesBlacklistAsWhitelist)) {
			generateOre(OtherModBlocks.calcite, world, rand, x, z, 1, 90, 2, 70, 100,
					Blocks.stone);
			}
			
			if (Loader.isModLoaded("etfuturum") && (Configs.enableNovaCraftTuffGeneration) && !(ArrayUtils.contains(Configs.DeeperCavesBlacklist, world.provider.dimensionId) == Configs.DeeperCavesBlacklistAsWhitelist)) {
				generateOre(OtherModBlocks.tuff, world, rand, x, z, 1, 35, 2, 25, 45,
						Blocks.stone);
				}			
			
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
						new VillageWell().generate(world, rand, i, k, j);
			 }
		   }										
		  }
	   	   
	 	}
}
