package com.NovaCraft.world.end;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.ArrayUtils;

import com.NovaCraft.config.Configs;
import com.NovaCraftBlocks.NovaCraftBlocks;
import com.NovaCraftBlocks.plants.end.BlockChorusGrass;
import com.NovaCraftBlocks.plants.end.BlockLacunaFruit;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

public class NCWorldGeneratorEnd implements IWorldGenerator {
	
	private Random rand;
	
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
		
			if (!(world.provider instanceof EndWorldProviderNovaCraft)) {
				int x = chunkX * 16 + rand.nextInt(8) + 8;
				int y = 128;
				int z = chunkZ * 16 + rand.nextInt(8) + 8;
				for (; y > 0; y--) {
					if (!world.getBlock(x, y, z).isAir(world, x, y, z)) {
						chorus_grass.get(0).generate(world, rand, x, rand.nextInt(40) + 15, z);
					}
				}
			}
			if (!(world.provider instanceof EndWorldProviderNovaCraft)) {
				int x = chunkX * 16 + rand.nextInt(8) + 8;
				int y = 128;
				int z = chunkZ * 16 + rand.nextInt(8) + 8;
				for (; y > 0; y--) {
					if (!world.getBlock(x, y, z).isAir(world, x, y, z)) {
						void_sprout.get(0).generate(world, rand, x, rand.nextInt(30) + 30, z);
					}
				}
			}
			if (!(world.provider instanceof EndWorldProviderNovaCraft) && rand.nextInt(3) == 1) {
				int x = chunkX * 16 + rand.nextInt(8) + 8;
				int y = 128;
				int z = chunkZ * 16 + rand.nextInt(8) + 8;
				for (; y > 0; y--) {
					if (!world.getBlock(x, y, z).isAir(world, x, y, z)) {
						shadow_bloom.get(0).generate(world, rand, x, rand.nextInt(40) + 30, z);
					}
				}
			}
			if (Configs.enableLacunaTreeGeneration) {
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
						
		}			
	}
		
	protected int nextHeightInt(Random rand, int i) {
		if (i <= 1)
			return 1;
		return rand.nextInt(i);
	}
		
	public static int getNumEmptyBlocks(final World world, final int x, int y, final int z) {
	       int dist;
	       for (dist = 0; y > 5 && !world.isBlockNormalCubeDefault(x, y, z, true) && world.isAirBlock(x, y, z); --y, ++dist) {}
	       return dist;
	}
		
	public static int randomChoice(final int... val) {
		    final Random random = new Random();
		    return val[random.nextInt(val.length)];
   }

}
