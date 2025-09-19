package com.NovaCraft.world;

import static net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.DUNGEON;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.apache.commons.lang3.ArrayUtils;

import com.NovaCraft.config.Configs;
import com.NovaCraft.registry.OtherModBlocks;
import com.NovaCraft.world.structure.AetherGeoGen;
import com.NovaCraft.world.structure.CopartzGeoGen;
import com.NovaCraft.world.structure.LarimarGeoGen;
import com.NovaCraft.world.structure.NovaCraftAdvancedTraditionalDungeonGen;
import com.NovaCraft.world.structure.NovaCraftDungeonGen;
import com.NovaCraft.world.structure.NovaCraftTraditionalDungeonGen;
import com.NovaCraft.world.structure.SculkGeoDungeon;
import com.NovaCraft.world.structure.SculkGeoDungeon2;
import com.NovaCraft.world.structure.SeaSerpentSpawner;
import com.NovaCraft.world.structure.TsavorokiteGeoGen;
import com.NovaCraft.world.structure.YttrlinsiteGeoGen;
import com.NovaCraftBlocks.NovaCraftBlocks;
import com.NovaCraftBlocks.plants.LargeLuminantTreeGen;
import com.NovaCraftBlocks.plants.LuminantTreeGen;
import com.google.common.collect.Maps;

import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.Loader;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.chunk.storage.ExtendedBlockStorage;
import net.minecraft.world.gen.feature.WorldGenDungeons;
import net.minecraft.world.gen.feature.WorldGenFlowers;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.event.terraingen.TerrainGen;

public class NCWorldGeneratorDeeperCaves implements IWorldGenerator {
	
	public static final NCWorldGeneratorDeeperCaves INSTANCE = new NCWorldGeneratorDeeperCaves();
	
	protected final List<WorldGenSculkBlock> sculk_gen = new LinkedList<WorldGenSculkBlock>();
	protected final List<WorldGenSculkVeins> sculk_vein_gen = new LinkedList<WorldGenSculkVeins>();
	protected final List<WorldGenSculkGrowth> sculk_growth_gen = new LinkedList<WorldGenSculkGrowth>();
	protected final List<WorldGenSculkBush> sculk_bush_gen = new LinkedList<WorldGenSculkBush>();
	protected final List<WorldGenSculkSpike> sculk_spike_gen = new LinkedList<WorldGenSculkSpike>();
	protected final List<WorldGenSculkGrass> sculk_grass_gen = new LinkedList<WorldGenSculkGrass>();
	
	protected final List<WorldGenSculkStone> sculk_stone_gen = new LinkedList<WorldGenSculkStone>();
	protected final List<WorldGenSculkGrimstone> sculk_grimstone_gen = new LinkedList<WorldGenSculkGrimstone>();
	protected final List<WorldGenSculkNullstone> sculk_nullstone_gen = new LinkedList<WorldGenSculkNullstone>();
	
	protected final List<WorldGenCavePlants> glow_lichen_gen = new LinkedList<WorldGenCavePlants>();
	protected final List<WorldGenGrimLichen> grim_lichen_gen = new LinkedList<WorldGenGrimLichen>();
	protected final List<WorldGenDarkLichen> dark_lichen_gen = new LinkedList<WorldGenDarkLichen>();
	
	protected final List<WorldGenNovaCraftDeepFlower> deep_flower = new LinkedList<WorldGenNovaCraftDeepFlower>();
	protected final List<WorldGenNovaCraftDeepRoots> deep_roots = new LinkedList<WorldGenNovaCraftDeepRoots>();
	
	protected final List<WorldGenNovaCraftMushroom> mushroom = new LinkedList<WorldGenNovaCraftMushroom>();
	protected final List<WorldGenNovaCraftMushroom2> mushroom2 = new LinkedList<WorldGenNovaCraftMushroom2>();
	protected final List<WorldGenNovaCraftMushroom3> mushroom3 = new LinkedList<WorldGenNovaCraftMushroom3>();
	protected final List<WorldGenNovaCraftMushroom4> mushroom4 = new LinkedList<WorldGenNovaCraftMushroom4>();
	protected final List<WorldGenNovaCraftMushroom5> mushroom5 = new LinkedList<WorldGenNovaCraftMushroom5>();
	
	protected final List<WorldGenPherithium> pherithium_gen = new LinkedList<WorldGenPherithium>();
	protected final List<WorldGenPherithiumSmall> small_pherithium_gen = new LinkedList<WorldGenPherithiumSmall>();
	
	protected final List<WorldGenStoneStalagmite> stone_stalagmite_gen = new LinkedList<WorldGenStoneStalagmite>();
	protected final List<WorldGenLargeStoneStalagmite> large_stone_stalagmite_gen = new LinkedList<WorldGenLargeStoneStalagmite>();
	protected final List<WorldGenNullstoneStalagmite> nullstone_stalagmite_gen = new LinkedList<WorldGenNullstoneStalagmite>();
	protected final List<WorldGenLargeNullstoneStalagmite> large_nullstone_stalagmite_gen = new LinkedList<WorldGenLargeNullstoneStalagmite>();
	
	protected final List<WorldGenStoneStalactite> stone_stalactite_gen = new LinkedList<WorldGenStoneStalactite>();
	protected final List<WorldGenLargeStoneStalactite> large_stone_stalactite_gen = new LinkedList<WorldGenLargeStoneStalactite>();
	protected final List<WorldGenNullstoneStalactite> nullstone_stalactite_gen = new LinkedList<WorldGenNullstoneStalactite>();
	protected final List<WorldGenLargeNullstoneStalactite> large_nullstone_stalactite_gen = new LinkedList<WorldGenLargeNullstoneStalactite>();
	
	protected final List<WorldGenIcicle> icicle = new LinkedList<WorldGenIcicle>();
	
	protected final List<WorldGenBuddingCopartz> copartz_gen = new LinkedList<WorldGenBuddingCopartz>();
	protected final List<WorldGenBuddingLarimar> larimar_gen = new LinkedList<WorldGenBuddingLarimar>();
	protected final List<WorldGenBuddingTsavorokite> tsavorokite_gen = new LinkedList<WorldGenBuddingTsavorokite>();
	
	protected final List<WorldGenAdditonalCoal> additional_coal = new LinkedList<WorldGenAdditonalCoal>();
	protected final List<WorldGenAdditonalIron> additional_iron = new LinkedList<WorldGenAdditonalIron>();
	protected final List<WorldGenAdditonalGold> additional_gold = new LinkedList<WorldGenAdditonalGold>();
	protected final List<WorldGenAdditonalRedstone> additional_redstone = new LinkedList<WorldGenAdditonalRedstone>();
	protected final List<WorldGenAdditonalLapis> additional_lapis = new LinkedList<WorldGenAdditonalLapis>();
	protected final List<WorldGenAdditonalDiamond> additional_diamond = new LinkedList<WorldGenAdditonalDiamond>();

	
	protected NCWorldGeneratorDeeperCaves() {
		
		sculk_gen.add(new WorldGenSculkBlock(NovaCraftBlocks.sculk_block, 60));
		sculk_gen.add(new WorldGenSculkBlock(NovaCraftBlocks.sculk_block, 40));
		sculk_stone_gen.add(new WorldGenSculkStone(NovaCraftBlocks.sculk_stone, 50));
		sculk_stone_gen.add(new WorldGenSculkStone(NovaCraftBlocks.sculk_stone, 30));
		sculk_grimstone_gen.add(new WorldGenSculkGrimstone(NovaCraftBlocks.sculk_grimstone, 50));
		sculk_grimstone_gen.add(new WorldGenSculkGrimstone(NovaCraftBlocks.sculk_grimstone, 30));
		sculk_nullstone_gen.add(new WorldGenSculkNullstone(NovaCraftBlocks.sculk_nullstone, 50));
		sculk_nullstone_gen.add(new WorldGenSculkNullstone(NovaCraftBlocks.sculk_nullstone, 30));
		
		sculk_spike_gen.add(new WorldGenSculkSpike(NovaCraftBlocks.sculk_spike, 20));
		sculk_spike_gen.add(new WorldGenSculkSpike(NovaCraftBlocks.sculk_spike, 22));
		sculk_vein_gen.add(new WorldGenSculkVeins(NovaCraftBlocks.sculk_vein, 35));
		sculk_growth_gen.add(new WorldGenSculkGrowth(NovaCraftBlocks.sculk_growth, 30));
		sculk_bush_gen.add(new WorldGenSculkBush(NovaCraftBlocks.sculk_bush, 20));
		sculk_grass_gen.add(new WorldGenSculkGrass(NovaCraftBlocks.sculk_sensor, 16));
		
		deep_flower.add(new WorldGenNovaCraftDeepFlower(NovaCraftBlocks.sculk_tulip, 6));
		deep_roots.add(new WorldGenNovaCraftDeepRoots(NovaCraftBlocks.deep_roots, 30));
		
		mushroom.add(new WorldGenNovaCraftMushroom(NovaCraftBlocks.hydnum_mushroom, 3));
		mushroom2.add(new WorldGenNovaCraftMushroom2(NovaCraftBlocks.calvatia_mushroom, 2));
		mushroom3.add(new WorldGenNovaCraftMushroom3(NovaCraftBlocks.lentius_mushroom, 3));
		mushroom4.add(new WorldGenNovaCraftMushroom4(NovaCraftBlocks.rozite_mushroom, 2));
		mushroom5.add(new WorldGenNovaCraftMushroom5(NovaCraftBlocks.pleurotus_mushroom, 1));
		
		pherithium_gen.add(new WorldGenPherithium(NovaCraftBlocks.large_pherithium_stalagmite, 16));
		small_pherithium_gen.add(new WorldGenPherithiumSmall(NovaCraftBlocks.small_pherithium_stalagmite, 18));
		
		stone_stalagmite_gen.add(new WorldGenStoneStalagmite(NovaCraftBlocks.stone_stalagmite, 25));
		large_stone_stalagmite_gen.add(new WorldGenLargeStoneStalagmite(NovaCraftBlocks.large_stone_stalagmite, 23));
		nullstone_stalagmite_gen.add(new WorldGenNullstoneStalagmite(NovaCraftBlocks.nullstone_stalagmite, 24));
		large_nullstone_stalagmite_gen.add(new WorldGenLargeNullstoneStalagmite(NovaCraftBlocks.large_nullstone_stalagmite, 26));
		
		stone_stalactite_gen.add(new WorldGenStoneStalactite(NovaCraftBlocks.stone_stalactite, 25));
		large_stone_stalactite_gen.add(new WorldGenLargeStoneStalactite(NovaCraftBlocks.large_stone_stalactite, 27));
		nullstone_stalactite_gen.add(new WorldGenNullstoneStalactite(NovaCraftBlocks.nullstone_stalactite, 25));
		large_nullstone_stalactite_gen.add(new WorldGenLargeNullstoneStalactite(NovaCraftBlocks.large_nullstone_stalactite, 28));
		
		icicle.add(new WorldGenIcicle(NovaCraftBlocks.icicle, 40));
		
		glow_lichen_gen.add(new WorldGenCavePlants(NovaCraftBlocks.glow_lichen, 30));
		grim_lichen_gen.add(new WorldGenGrimLichen(NovaCraftBlocks.grim_lichen, 10));
		dark_lichen_gen.add(new WorldGenDarkLichen(NovaCraftBlocks.dark_lichen, 5));
		
		copartz_gen.add(new WorldGenBuddingCopartz(NovaCraftBlocks.budding_copartz_block, 5));
		copartz_gen.add(new WorldGenBuddingCopartz(NovaCraftBlocks.budding_copartz_block, 3));
		larimar_gen.add(new WorldGenBuddingLarimar(NovaCraftBlocks.budding_larimar_block, 4));
		larimar_gen.add(new WorldGenBuddingLarimar(NovaCraftBlocks.budding_larimar_block, 3));
		tsavorokite_gen.add(new WorldGenBuddingTsavorokite(NovaCraftBlocks.budding_tsavorokite_block, 3));
		tsavorokite_gen.add(new WorldGenBuddingTsavorokite(NovaCraftBlocks.budding_tsavorokite_block, 2));
		
		additional_coal.add(new WorldGenAdditonalCoal(Blocks.coal_ore, 20));
		additional_iron.add(new WorldGenAdditonalIron(Blocks.iron_ore, 15));
		additional_gold.add(new WorldGenAdditonalGold(Blocks.gold_ore, 10));
		additional_redstone.add(new WorldGenAdditonalRedstone(Blocks.redstone_ore, 15));
		additional_lapis.add(new WorldGenAdditonalLapis(Blocks.lapis_ore, 5));
		additional_diamond.add(new WorldGenAdditonalDiamond(Blocks.diamond_ore, 4));
		
	}
	
	@Override
	public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		if((world.getWorldInfo().getTerrainType() != WorldType.FLAT || world.getWorldInfo().getGeneratorOptions().contains("decoration")) && (ArrayUtils.contains(Configs.WorldGenDimensionBlacklist, world.provider.dimensionId) == Configs.WorldGenDimensionBlacklistAsWhitelist)) {
		   if (ArrayUtils.contains(Configs.DeeperCavesBlacklist, world.provider.dimensionId) == Configs.DeeperCavesBlacklistAsWhitelist) {	
			
			 //Sculk Dungeon
			int x7;
			int z7;
			x7 = chunkX * 16 + rand.nextInt(8) + 8;
			z7 = chunkZ * 16 + rand.nextInt(8) + 8;
			if(rand.nextInt(256) == 0) {
				new SculkGeoDungeon().generate(world, rand, x7, rand.nextInt(200) + 9, z7);
			}
				
			//NovaCraft Dungeon
			int x13;
			int z13;
			x13 = chunkX * 16 + rand.nextInt(8) + 8;
			z13 = chunkZ * 16 + rand.nextInt(8) + 8;
			if(rand.nextInt(8) == 0) {
				new NovaCraftDungeonGen().generate(world, rand, x13, rand.nextInt(240) + 9, z13);
			}
				
			//Sculk Dungeon
			int x14;
			int z14;
			x14 = chunkX * 16 + rand.nextInt(8) + 8;
			z14 = chunkZ * 16 + rand.nextInt(8) + 8;
			if(rand.nextInt(256) == 0) {
				new SculkGeoDungeon2().generate(world, rand, x14, rand.nextInt(150) + 9, z14);
			}
						
			//Copartz Geo
			int x8;
			int z8;
			x8 = chunkX * 16 + rand.nextInt(8) + 8;
			z8 = chunkZ * 16 + rand.nextInt(8) + 8;
			if(rand.nextInt(212) == 0) {
				new CopartzGeoGen().generate(world, rand, x8, rand.nextInt(200) + 27, z8);
			}
				
			//Larimar Geo
			int x9;
			int z9;
			x9 = chunkX * 16 + rand.nextInt(8) + 8;
			z9 = chunkZ * 16 + rand.nextInt(8) + 8;
			if(rand.nextInt(312) == 0) {
				new LarimarGeoGen().generate(world, rand, x9, rand.nextInt(200) + 27, z9);
			}
				
			//Tsavorokite Geo
			int x10;
			int z10;
			x10 = chunkX * 16 + rand.nextInt(8) + 8;
			z10 = chunkZ * 16 + rand.nextInt(8) + 8;
			if(rand.nextInt(332) == 0) {
				new TsavorokiteGeoGen().generate(world, rand, x10, rand.nextInt(200) + 25, z10);
			}
				
			//Yttrlinsite Geo
			if (Configs.enableYttrlinisteOverworldGeneration) {
			int x11;
			int z11;
			x11 = chunkX * 16 + rand.nextInt(8) + 8;
			z11 = chunkZ * 16 + rand.nextInt(8) + 8;
			if(rand.nextInt(1032) == 0) {
				new YttrlinsiteGeoGen().generate(world, rand, x11, rand.nextInt(150) + 10, z11);
				}
			}
				
			//Aether Geo
			int x12;
			int z12;
			x12 = chunkX * 16 + rand.nextInt(8) + 8;
			z12 = chunkZ * 16 + rand.nextInt(8) + 8;
			if(rand.nextInt(832) == 0) {
				new AetherGeoGen().generate(world, rand, x12, rand.nextInt(200) + 30, z12);
			}
				
			//NovaCraft Traditional Dungeon
			int x20;
			int z20;
			x20 = chunkX * 16 + rand.nextInt(8) + 8;
			z20 = chunkZ * 16 + rand.nextInt(8) + 8;
			BiomeGenBase biome20;
			Type[] biomeList20;
			biome20 = world.getBiomeGenForCoords(x20, z20);
			biomeList20 = BiomeDictionary.getTypesForBiome(biome20);
			if(!(BiomeDictionary.isBiomeOfType(biome20, BiomeDictionary.Type.OCEAN)) && rand.nextInt(210) == 0) {
				new NovaCraftTraditionalDungeonGen().generate(world, rand, x20, rand.nextInt(120) + 25, z20);
			}
				
			//NovaCraft Traditional Dungeon
			int x21;
			int z21;
			x21 = chunkX * 16 + rand.nextInt(8) + 8;
			z21 = chunkZ * 16 + rand.nextInt(8) + 8;
			if(rand.nextInt(330) == 1) {
				new NovaCraftAdvancedTraditionalDungeonGen().generate(world, rand, x21, rand.nextInt(200) + 10, z21);
			}   
			   
			   
			   
			if (Configs.enableSculkGeneration && rand.nextInt(5) == 1) {
			int x1;
			int z1;
			x1 = chunkX * 16 + rand.nextInt(8) + 8;
			z1 = chunkZ * 16 + rand.nextInt(8) + 8;
			BiomeGenBase biome1;
			Type[] biomeList1;
			biome1 = world.getBiomeGenForCoords(x1, z1);
			biomeList1 = BiomeDictionary.getTypesForBiome(biome1);
			
			sculk_gen.get(0).generate(world, rand, x1, rand.nextInt(100) + 0, z1);
			sculk_gen.get(0).generate(world, rand, x1, rand.nextInt(100) + 55, z1);
				
			sculk_grimstone_gen.get(0).generate(world, rand, x1, rand.nextInt(100) + 5, z1);
			sculk_nullstone_gen.get(0).generate(world, rand, x1, rand.nextInt(150) + 25, z1);
				
			sculk_spike_gen.get(0).generate(world, rand, x1, rand.nextInt(120) + 8, z1);
			sculk_spike_gen.get(0).generate(world, rand, x1, rand.nextInt(180) + 55, z1);
				
			sculk_bush_gen.get(0).generate(world, rand, x1, rand.nextInt(150) + 10, z1);
			sculk_bush_gen.get(0).generate(world, rand, x1, rand.nextInt(100) + 25, z1);
				
			sculk_vein_gen.get(0).generate(world, rand, x1, rand.nextInt(150) + 6, z1);
			sculk_vein_gen.get(0).generate(world, rand, x1, rand.nextInt(100) + 51, z1);
				
			sculk_growth_gen.get(0).generate(world, rand, x1, rand.nextInt(150) + 8, z1);
			sculk_growth_gen.get(0).generate(world, rand, x1, rand.nextInt(100) + 50, z1);
				
			sculk_grass_gen.get(0).generate(world, rand, x1, rand.nextInt(150) + 9, z1);
			sculk_grass_gen.get(0).generate(world, rand, x1, rand.nextInt(100) + 59, z1);
				
			deep_flower.get(0).generate(world, rand, x1, rand.nextInt(80) + 5, z1);
			deep_flower.get(0).generate(world, rand, x1, rand.nextInt(100) + 15, z1);
			deep_flower.get(0).generate(world, rand, x1, rand.nextInt(120) + 10, z1);
			deep_flower.get(0).generate(world, rand, x1, rand.nextInt(140) + 56, z1);
		   }
		   		   
		   	//Stalagmite and Statactites
			int x;
			int z;
			BiomeGenBase biome;
			Type[] biomeList;			
			x = chunkX * 16 + rand.nextInt(8) + 8;
			z = chunkZ * 16 + rand.nextInt(8) + 8;
			biome = world.getBiomeGenForCoords(x, z);
			biomeList = BiomeDictionary.getTypesForBiome(biome);
		    if (Configs.enablePherithiumGeneration) {
				pherithium_gen.get(0).generate(world, rand, x, rand.nextInt(25) + 15, z);
				small_pherithium_gen.get(0).generate(world, rand, x, rand.nextInt(23) + 15, z);
			}
		    
				if (Configs.enableStalagAndStalacGeneration) {
				stone_stalagmite_gen.get(0).generate(world, rand, x, rand.nextInt(110) + 35, z);
				stone_stalagmite_gen.get(0).generate(world, rand, x, rand.nextInt(110) + 30, z);
				large_stone_stalagmite_gen.get(0).generate(world, rand, x, rand.nextInt(140) + 33, z);
				large_stone_stalagmite_gen.get(0).generate(world, rand, x, rand.nextInt(130) + 28, z);
				nullstone_stalagmite_gen.get(0).generate(world, rand, x, rand.nextInt(140) + 15, z);
				nullstone_stalagmite_gen.get(0).generate(world, rand, x, rand.nextInt(10) + 5, z);
				large_nullstone_stalagmite_gen.get(0).generate(world, rand, x, rand.nextInt(40) + 13, z);
				large_nullstone_stalagmite_gen.get(0).generate(world, rand, x, rand.nextInt(10) + 4, z);
				
				stone_stalactite_gen.get(0).generate(world, rand, x, rand.nextInt(110) + 35, z);
			    stone_stalactite_gen.get(0).generate(world, rand, x, rand.nextInt(110) + 30, z);
				large_stone_stalactite_gen.get(0).generate(world, rand, x, rand.nextInt(160) + 30, z);
				large_stone_stalactite_gen.get(0).generate(world, rand, x, rand.nextInt(115) + 25, z);
				nullstone_stalactite_gen.get(0).generate(world, rand, x, rand.nextInt(115) + 10, z);
				nullstone_stalactite_gen.get(0).generate(world, rand, x, rand.nextInt(50) + 8, z);
				nullstone_stalactite_gen.get(0).generate(world, rand, x, rand.nextInt(10) + 5, z);
				large_nullstone_stalactite_gen.get(0).generate(world, rand, x, rand.nextInt(115) + 8, z);
				large_nullstone_stalactite_gen.get(0).generate(world, rand, x, rand.nextInt(50) + 7, z);
				large_nullstone_stalactite_gen.get(0).generate(world, rand, x, rand.nextInt(15) + 8, z);
				 }
				
				if (Configs.enableGlowLichenGeneration) {				
				glow_lichen_gen.get(0).generate(world, rand, x, rand.nextInt(120) + 15, z);
				glow_lichen_gen.get(0).generate(world, rand, x, rand.nextInt(50) + 15, z);
				 }
				
				if (Configs.enableLichenGeneration) {
				grim_lichen_gen.get(0).generate(world, rand, x, rand.nextInt(90) + 15, z);
				grim_lichen_gen.get(0).generate(world, rand, x, rand.nextInt(30) + 5, z);
				    }
				
				if((world.getHeightValue(x, z) > 0)) {
					if (Configs.enableLichenGeneration && rand.nextInt(4) == 1) {
					dark_lichen_gen.get(0).generate(world, rand, x, rand.nextInt(100) + 60, z);
					dark_lichen_gen.get(0).generate(world, rand, x, rand.nextInt(20) + 5, z);
					}
					
					if (Configs.enableNovaMushrooomGeneration && rand.nextInt(3) == 1) {
					mushroom.get(0).generate(world, rand, x, rand.nextInt(120) + 5, z);
					mushroom.get(0).generate(world, rand, x, rand.nextInt(30) + 5, z);
					
					mushroom2.get(0).generate(world, rand, x, rand.nextInt(115) + 5, z);
					mushroom2.get(0).generate(world, rand, x, rand.nextInt(30) + 2, z);
					
					mushroom3.get(0).generate(world, rand, x, rand.nextInt(120) + 5, z);
					mushroom3.get(0).generate(world, rand, x, rand.nextInt(30) + 5, z);
					
					mushroom4.get(0).generate(world, rand, x, rand.nextInt(110) + 5, z);
					mushroom4.get(0).generate(world, rand, x, rand.nextInt(20) + 5, z);
					
					mushroom5.get(0).generate(world, rand, x, rand.nextInt(118) + 5, z);
					mushroom5.get(0).generate(world, rand, x, rand.nextInt(18) + 5, z);
					
					}
				  }
				
				if (rand.nextInt(4) == 3) {
					deep_roots.get(0).generate(world, rand, x, rand.nextInt(20) + 35, z);
					deep_roots.get(0).generate(world, rand, x, rand.nextInt(18) + 55, z);
					deep_roots.get(0).generate(world, rand, x, rand.nextInt(15) + 90, z);
					deep_roots.get(0).generate(world, rand, x, rand.nextInt(10) + 152, z);
					deep_roots.get(0).generate(world, rand, x, rand.nextInt(5) + 182, z);	
				}
				
				
		   }
			
		}
	}
}
