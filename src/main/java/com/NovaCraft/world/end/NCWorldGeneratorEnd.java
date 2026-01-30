package com.NovaCraft.world.end;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import com.NovaCraft.config.ConfigsStructures;
import com.NovaCraft.config.ConfigsWorld;
import com.NovaCraft.world.structure.YttrlinsiteGeoGen;
import com.NovaCraftBlocks.NovaCraftBlocks;
import com.NovaCraftBlocks.plants.end.BlockLacunaFruit;
import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;

public class NCWorldGeneratorEnd implements IWorldGenerator {
	
	public static final NCWorldGeneratorEnd INSTANCE = new NCWorldGeneratorEnd();
	
	protected final List<WorldGenChorusGrass> chorus_grass = new LinkedList<WorldGenChorusGrass>();
	protected final List<WorldGenVoidSprout> void_sprout = new LinkedList<WorldGenVoidSprout>();
	protected final List<WorldGenShadowBloom> shadow_bloom = new LinkedList<WorldGenShadowBloom>();
	
	NCWorldGeneratorEnd() {
		chorus_grass.add(new WorldGenChorusGrass(NovaCraftBlocks.chorus_grass, 40));
		void_sprout.add(new WorldGenVoidSprout(NovaCraftBlocks.void_sprout, 10));
		shadow_bloom.add(new WorldGenShadowBloom(NovaCraftBlocks.shadow_bloom, 8));
		
	}
	
	@Override
	public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		if(world.provider.dimensionId == 1) {
		
			if (!(world.provider instanceof EndWorldProviderNovaCraft) && ConfigsWorld.enableEndFlora) {
				int x = chunkX * 16 + rand.nextInt(8) + 8;
				int y = 128;
				int z = chunkZ * 16 + rand.nextInt(8) + 8;
				for (; y > 0; y--) {
					if (!world.getBlock(x, y, z).isAir(world, x, y, z)) {
						chorus_grass.get(0).generate(world, rand, x, rand.nextInt(40) + 15, z);
					}
				}
			}
			if (!(world.provider instanceof EndWorldProviderNovaCraft) && ConfigsWorld.enableEndFlora) {
				int x = chunkX * 16 + rand.nextInt(8) + 8;
				int y = 128;
				int z = chunkZ * 16 + rand.nextInt(8) + 8;
				for (; y > 0; y--) {
					if (!world.getBlock(x, y, z).isAir(world, x, y, z)) {
						void_sprout.get(0).generate(world, rand, x, rand.nextInt(30) + 30, z);
					}
				}
			}
			if (!(world.provider instanceof EndWorldProviderNovaCraft) && rand.nextInt(3) == 1 && ConfigsWorld.enableEndFlora) {
				int x = chunkX * 16 + rand.nextInt(8) + 8;
				int y = 128;
				int z = chunkZ * 16 + rand.nextInt(8) + 8;
				for (; y > 0; y--) {
					if (!world.getBlock(x, y, z).isAir(world, x, y, z)) {
						shadow_bloom.get(0).generate(world, rand, x, rand.nextInt(40) + 30, z);
					}
				}
			}
			if (ConfigsStructures.enableLacunaTreeGeneration) {
				if (!(world.provider instanceof EndWorldProviderNovaCraft) && rand.nextInt(5) == 1) {
					int x = chunkX * 16 + rand.nextInt(8) + 8;
					int y = 256;
					int z = chunkZ * 16 + rand.nextInt(8) + 8;
					for (; y > 0; y--) {
						if (!world.getBlock(x, y, z).isAir(world, x, y, z)) {
							if (y > 0 && BlockLacunaFruit.canPlantStay(world, x, y + 1, z)) {
								BlockLacunaFruit.generatePlant(world, x, y + 1, z, rand, 6);
								break;
							}
						}
					}
				}
			}
			int x;
			int z;
			x = chunkX * 16 + rand.nextInt(8) + 8;
			z = chunkZ * 16 + rand.nextInt(8) + 8;
			if(rand.nextInt(250) == 0 && ConfigsStructures.enableEndDungeon && (Math.abs(x) >= 500 || Math.abs(z) >= 500)) {
				new EndDungeonGen().generate(world, rand, x, rand.nextInt(40) + 20, z);
			}
						
		}			
	}

}
