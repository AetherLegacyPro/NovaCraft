package com.NovaCraft.world.nether;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.ArrayUtils;

import com.NovaCraft.world.end.EndWorldProviderNovaCraft;
import com.NovaCraft.world.end.NCWorldGeneratorEnd;
import com.NovaCraft.world.end.WorldGenShadowBloom;
import com.NovaCraft.world.structure.YttrlinsiteGeoGen;
import com.NovaCraftBlocks.NovaCraftBlocks;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenFlowers;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

public class NCWorldGeneratorNether implements IWorldGenerator {
	
	public static final NCWorldGeneratorNether INSTANCE = new NCWorldGeneratorNether();
	
	protected final List<WorldGenFlamingPitcher> flaming_pitcher = new LinkedList<WorldGenFlamingPitcher>();
	
	protected final List<WorldGenFlowers> hell_piliz = new LinkedList<WorldGenFlowers>();
	protected final List<WorldGenFlowers> deepoid_mushroom = new LinkedList<WorldGenFlowers>();
	protected final List<WorldGenFlowers> ion_mushroom = new LinkedList<WorldGenFlowers>();
	
	NCWorldGeneratorNether() {
		flaming_pitcher.add(new WorldGenFlamingPitcher(NovaCraftBlocks.flaming_pitcher_bottom, 1));
		
		hell_piliz.add(new WorldGenFlowers(NovaCraftBlocks.hell_piliz));
		deepoid_mushroom.add(new WorldGenFlowers(NovaCraftBlocks.deepoid_mushroom));
		ion_mushroom.add(new WorldGenFlowers(NovaCraftBlocks.ion_mushroom));
	}
	
	@Override
	public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		if(world.provider.dimensionId == -1 && rand.nextInt(5) == 1) {
			int x4;
			int z4;
			x4 = chunkX * 16 + rand.nextInt(16) + 8;
			z4 = chunkZ * 16 + rand.nextInt(16) + 8;
			BiomeGenBase biome4;
			Type[] biomeList4;
			biome4 = world.getBiomeGenForCoords(x4, z4);
			biomeList4 = BiomeDictionary.getTypesForBiome(biome4);
			if((world.getHeightValue(x4, z4) > 0)) {							
				flaming_pitcher.get(0).generate(world, rand, x4, rand.nextInt(1) + 32, z4);	
				
				}
			
			if((world.getHeightValue(x4, z4) > 0)) {							
				hell_piliz.get(0).generate(world, rand, x4, rand.nextInt(60) + 24, z4);	
				
				}
			
			if((world.getHeightValue(x4, z4) > 0)) {							
				deepoid_mushroom.get(0).generate(world, rand, x4, rand.nextInt(24) + 8, z4);	
				
				}
			
			if((world.getHeightValue(x4, z4) > 0)) {							
				ion_mushroom.get(0).generate(world, rand, x4, rand.nextInt(32) + 32, z4);	
				
				}
			
		
		//Yttrlinsite Gen
		int x11;
		int z11;
		x11 = chunkX * 16 + rand.nextInt(16) + 8;
		z11 =chunkZ * 16 + rand.nextInt(16) + 8;
		if(rand.nextInt(250) == 1) {
			new YttrlinsiteGeoGen().generate(world, rand, x11, rand.nextInt(5) + 15, z11);
		  }
		}		
	}
}
