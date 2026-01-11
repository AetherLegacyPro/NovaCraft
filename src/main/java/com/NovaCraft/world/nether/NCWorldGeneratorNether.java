package com.NovaCraft.world.nether;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import com.NovaCraft.config.ConfigsStructures;
import com.NovaCraft.config.ConfigsWorld;
import com.NovaCraft.world.nether.structure.BlazingSerpentDungeonGen;
import com.NovaCraft.world.nether.structure.NetherDungeonGen;
import com.NovaCraft.world.structure.YttrlinsiteGeoGen;
import com.NovaCraftBlocks.NovaCraftBlocks;
import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.world.World;
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
			
			int x;
			int z;
			x = chunkX * 16 + rand.nextInt(8) + 8;
			z = chunkZ * 16 + rand.nextInt(8) + 8;

			if((world.getHeightValue(x, z) > 0) && ConfigsWorld.enableFlamingPitcherGeneration) {
				flaming_pitcher.get(0).generate(world, rand, x, rand.nextInt(1) + 32, z);
				
				}
			
			if((world.getHeightValue(x, z) > 0) && ConfigsWorld.enableNetherFlora) {
				hell_piliz.get(0).generate(world, rand, x, rand.nextInt(60) + 24, z);
				
				}
			
			if((world.getHeightValue(x, z) > 0) && ConfigsWorld.enableNetherFlora) {
				deepoid_mushroom.get(0).generate(world, rand, x, rand.nextInt(24) + 8, z);
				
				}
			
			if((world.getHeightValue(x, z) > 0) && ConfigsWorld.enableNetherFlora) {
				ion_mushroom.get(0).generate(world, rand, x, rand.nextInt(32) + 32, z);
				
				}
		}
		
		if(world.provider.dimensionId == -1) {
			//Yttrlinsite Gen
			int x1;
			int z1;
			x1 = chunkX * 16 + rand.nextInt(8) + 8;
			z1 = chunkZ * 16 + rand.nextInt(8) + 8;
			if(rand.nextInt(250) == 1 && ConfigsStructures.enableNetherYttrlinisteGeodes) {
				new YttrlinsiteGeoGen().generate(world, rand, x1, rand.nextInt(5) + 15, z1);
			 }
				
			//Nether Dungeon Gen
			int x2;
			int z2;
			x2 = chunkX * 16 + rand.nextInt(8) + 8;
			z2 = chunkZ * 16 + rand.nextInt(8) + 8;
			if(rand.nextInt(300) == 3 && ConfigsStructures.enableTraditionalNetherDungeons) {
				new NetherDungeonGen().generate(world, rand, x2, rand.nextInt(10) + 8, z2);
			}
			
			//Blazing Serpent Dungeon Gen
			int x3;
			int z3;
			x3 = chunkX * 16 + rand.nextInt(8) + 8;
			z3 = chunkZ * 16 + rand.nextInt(8) + 8;
			if(rand.nextInt(280) == 2 && ConfigsStructures.enableBlazingSerpentDungeons) {
				new BlazingSerpentDungeonGen().generate(world, rand, x3, 31, z3);
			}
		}
	}
}
