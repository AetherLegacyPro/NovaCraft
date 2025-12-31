package com.NovaCraft.world;

import static net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.DUNGEON;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import com.NovaCraft.world.structure.*;
import org.apache.commons.lang3.ArrayUtils;

import com.NovaCraft.config.Configs;
import com.NovaCraft.registry.OtherModBlocks;
import com.NovaCraft.world.village.VindicatorRandomHouse;
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

public class NCWorldGeneratorPlants implements IWorldGenerator {
	
	public static int placementFlagType;
	
	public static final NCWorldGeneratorPlants INSTANCE = new NCWorldGeneratorPlants();
	
	protected final List<WorldGenFlowers> cyan_rose = new LinkedList<WorldGenFlowers>();
	protected final List<WorldGenFlowers> torchflower = new LinkedList<WorldGenFlowers>();
	protected final List<WorldGenFlowers> cosmos = new LinkedList<WorldGenFlowers>();
	protected final List<WorldGenFlowers> violet = new LinkedList<WorldGenFlowers>();
	protected final List<WorldGenFlowers> purple_rose = new LinkedList<WorldGenFlowers>();
	protected final List<WorldGenFlowers> desert_bloom = new LinkedList<WorldGenFlowers>();
	protected final List<WorldGenFlowers> blooming_barb = new LinkedList<WorldGenFlowers>();
	
	protected final List<WorldGenMossBlock> moss_block_gen = new LinkedList<WorldGenMossBlock>();
	protected final List<WorldGenMossBlock> arctic_moss_block_gen = new LinkedList<WorldGenMossBlock>();
	protected final List<WorldGenMossCarpet> moss_gen = new LinkedList<WorldGenMossCarpet>();
	protected final List<WorldGenMossCarpet> arctic_moss_gen = new LinkedList<WorldGenMossCarpet>();
	
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
	
	protected NCWorldGeneratorPlants() {
		
		moss_block_gen.add(new WorldGenMossBlock(NovaCraftBlocks.moss_block, 20));
		moss_block_gen.add(new WorldGenMossBlock(NovaCraftBlocks.moss_block, 10));
		arctic_moss_block_gen.add(new WorldGenMossBlock(NovaCraftBlocks.arctic_moss_block, 18));
		arctic_moss_block_gen.add(new WorldGenMossBlock(NovaCraftBlocks.arctic_moss_block, 15));
		
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
		
		cyan_rose.add(new WorldGenFlowers(NovaCraftBlocks.cyan_rose));
		torchflower.add(new WorldGenFlowers(NovaCraftBlocks.torchflower));
		cosmos.add(new WorldGenFlowers(NovaCraftBlocks.cosmos));
		violet.add(new WorldGenFlowers(NovaCraftBlocks.violet));
		blooming_barb.add(new WorldGenFlowers(NovaCraftBlocks.blooming_barb));
		purple_rose.add(new WorldGenFlowers(NovaCraftBlocks.purple_rose));
		desert_bloom.add(new WorldGenFlowers(NovaCraftBlocks.desert_bloom));
		
		moss_gen.add(new WorldGenMossCarpet(NovaCraftBlocks.moss_carpet, 3));
		arctic_moss_gen.add(new WorldGenMossCarpet(NovaCraftBlocks.arctic_moss_carpet, 4));
		
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
	private static LuminantTreeGen tree = new LuminantTreeGen(NovaCraftBlocks.luminant_leaves, NovaCraftBlocks.luminant_leaves, 50, 5, true);
	private static LargeLuminantTreeGen tree2 = new LargeLuminantTreeGen(NovaCraftBlocks.luminant_leaves, NovaCraftBlocks.luminant_leaves, 50, 12, true);
	@Override
	public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		if((world.getWorldInfo().getTerrainType() != WorldType.FLAT || world.getWorldInfo().getGeneratorOptions().contains("decoration")) && (ArrayUtils.contains(Configs.WorldGenDimensionBlacklist, world.provider.dimensionId) == Configs.WorldGenDimensionBlacklistAsWhitelist)) {
			
			//NovaCraft Dungeon
			int x13;
			int z13;
			x13 = chunkX * 16 + rand.nextInt(8) + 8;
			z13 = chunkZ * 16 + rand.nextInt(8) + 8;
			if(rand.nextInt(8) == 0) {
				new NovaCraftDungeonGen().generate(world, rand, x13, rand.nextInt(25) + 9, z13);
			}
					
			//Copartz Geo
			int x8;
			int z8;
			x8 = chunkX * 16 + rand.nextInt(8) + 8;
			z8 = chunkZ * 16 + rand.nextInt(8) + 8;
			if(rand.nextInt(212) == 0) {
				new CopartzGeoGen().generate(world, rand, x8, rand.nextInt(18) + 27, z8);
			}
			
			//Larimar Geo
			int x9;
			int z9;
			x9 = chunkX * 16 + rand.nextInt(8) + 8;
			z9 = chunkZ * 16 + rand.nextInt(8) + 8;
			if(rand.nextInt(312) == 0) {
				new LarimarGeoGen().generate(world, rand, x9, rand.nextInt(14) + 27, z9);
			}
			
			//Tsavorokite Geo
			int x10;
			int z10;
			x10 = chunkX * 16 + rand.nextInt(8) + 8;
			z10 = chunkZ * 16 + rand.nextInt(8) + 8;
			if(rand.nextInt(332) == 0) {
				new TsavorokiteGeoGen().generate(world, rand, x10, rand.nextInt(10) + 25, z10);
			}
			
			//Yttrlinsite Geo
			if (Configs.enableYttrlinisteOverworldGeneration) {
			int x11;
			int z11;
			x11 = chunkX * 16 + rand.nextInt(8) + 8;
			z11 = chunkZ * 16 + rand.nextInt(8) + 8;
			if(rand.nextInt(1032) == 0) {
				new YttrlinsiteGeoGen().generate(world, rand, x11, rand.nextInt(5) + 10, z11);
				}
			}
			
			//Aether Geo
			int x12;
			int z12;
			x12 = chunkX * 16 + rand.nextInt(8) + 8;
			z12 = chunkZ * 16 + rand.nextInt(8) + 8;
			if(rand.nextInt(832) == 0) {
				new AetherGeoGen().generate(world, rand, x12, rand.nextInt(5) + 30, z12);
			}
			
			//NovaCraft Traditional Dungeon
			int x20;
			int z20;
			x20 = chunkX * 16 + rand.nextInt(8) + 8;
			z20 = chunkZ * 16 + rand.nextInt(8) + 8;
			BiomeGenBase biome20;
			biome20 = world.getBiomeGenForCoords(x20, z20);
			if(!(BiomeDictionary.isBiomeOfType(biome20, BiomeDictionary.Type.OCEAN)) && rand.nextInt(210) == 0) {
				new NovaCraftTraditionalDungeonGen().generate(world, rand, x20, rand.nextInt(20) + 25, z20);
			}
			
			//NovaCraft Traditional Dungeon
			int x21;
			int z21;
			x21 = chunkX * 16 + rand.nextInt(8) + 8;
			z21 = chunkZ * 16 + rand.nextInt(8) + 8;
			if(rand.nextInt(330) == 1) {
				new NovaCraftAdvancedTraditionalDungeonGen().generate(world, rand, x21, rand.nextInt(10) + 10, z21);
			}
			
			//Sea Serpent Spawner
			int x15;
			int z15;
			x15 = chunkX * 16 + rand.nextInt(8) + 8;
			z15 = chunkZ * 16 + rand.nextInt(8) + 8;	
			BiomeGenBase biome15;
			biome15 = world.getBiomeGenForCoords(x15, z15);
			if(BiomeDictionary.isBiomeOfType(biome15, BiomeDictionary.Type.OCEAN) && rand.nextInt(85) == 0 && Configs.enableOceanDungeonsGeneration) {
				new SeaSerpentSpawner().generate(world, rand, x15, rand.nextInt(2) + 30, z15);
			}
			
			//Vindicator House
			int x17;
			int y17;
			int z17;
			x17 = chunkX * 16 + rand.nextInt(8) + 8;
			z17 = chunkZ * 16 + rand.nextInt(8) + 8;
			y17 = world.getTopSolidOrLiquidBlock(x17, z17);
			BiomeGenBase biome17;
			biome17 = world.getBiomeGenForCoords(x17, z17);
			if(BiomeDictionary.isBiomeOfType(biome17, BiomeDictionary.Type.FOREST) && rand.nextInt(250) == 0 && Configs.enableVindicatorForestHouseGeneration) {
				new VindicatorRandomHouse().generate(world, rand, x17, y17 - 1, z17);
			}
			
			//Lumiant Tree
			int x16;
			int z16;
			x16 = chunkX * 16 + rand.nextInt(8) + 8;
			z16 = chunkZ * 16 + rand.nextInt(8) + 8;	
			BiomeGenBase biome9;
			biome9 = world.getBiomeGenForCoords(x16, z16);
			if (rand.nextInt(20) == 2) {
			if(BiomeDictionary.isBiomeOfType(biome9, BiomeDictionary.Type.FOREST) && rand.nextInt(8) == 1) {
				int posX = x16 + rand.nextInt(8) + 8;
				int posZ = z16 + rand.nextInt(8) + 8;
				int posY = world.getHeightValue(posX, posZ);
				if(Configs.enableLargeLuminantTreeGeneration) tree2.generate(world, rand, posX, 60 + rand.nextInt(10), posZ);
			}
			else {
				if (BiomeDictionary.isBiomeOfType(biome9, BiomeDictionary.Type.FOREST)) {
				int posX = x16 + rand.nextInt(8) + 8;
				int posZ = z16 + rand.nextInt(8) + 8;
				int posY = world.getHeightValue(posX, posZ);				
				if(Configs.enableLuminantTreeGeneration) tree.generate(world, rand, posX, 60 + rand.nextInt(10), posZ);
				}
			 }
			}

			//Desert Creeper Statue
			int x18;
			int z18;
			x18 = chunkX * 16 + rand.nextInt(8) + 8;
			z18 = chunkZ * 16 + rand.nextInt(8) + 8;
			int y18 = world.getHeightValue(x18, z18);
			BiomeGenBase biome18;
			biome18 = world.getBiomeGenForCoords(x18, z18);
			if(BiomeDictionary.isBiomeOfType(biome18, Type.SANDY) && rand.nextInt(1160) == 0 && Configs.enableDesertCreeperStatueGeneration) {
				new DesertCreeperStructureGen().generate(world, rand, x18, y18 - 16 + rand.nextInt(6), z18);
			}

			//Slime Statue
			int x19;
			int z19;
			x19 = chunkX * 16 + rand.nextInt(8) + 8;
			z19 = chunkZ * 16 + rand.nextInt(8) + 8;
			int y19 = world.getHeightValue(x19, z19);
			BiomeGenBase biome19;
			biome19 = world.getBiomeGenForCoords(x19, z19);
			if(BiomeDictionary.isBiomeOfType(biome19, Type.SWAMP) && rand.nextInt(260) == 0 && Configs.enableSlimeStatueGeneration) {
				new SlimeStructureGen().generate(world, rand, x19, y19 - 4 + rand.nextInt(2), z19);
			}

			int x22 = chunkX * 16 + rand.nextInt(8) + 8;
			int z22 = chunkZ * 16 + rand.nextInt(8) + 8;
			if (rand.nextInt(3) == 0) {
				new VoidTempleGen().generate(world, rand, x22, 2, z22);
			}
			
			//Sculk Gen
			if (Configs.enableSculkGeneration && rand.nextInt(5) == 1) {
			int x1;
			int z1;
			x1 = chunkX * 16 + rand.nextInt(8) + 8;
			z1 = chunkZ * 16 + rand.nextInt(8) + 8;
			BiomeGenBase biome1;
			biome1 = world.getBiomeGenForCoords(x1, z1);
			if((world.getHeightValue(x1, z1) > 0) && BiomeDictionary.isBiomeOfType(biome1, BiomeDictionary.Type.MOUNTAIN)) {
				sculk_gen.get(0).generate(world, rand, x1, rand.nextInt(5) + 20, z1);
				sculk_gen.get(0).generate(world, rand, x1, rand.nextInt(10) + 15, z1);
				
				sculk_stone_gen.get(0).generate(world, rand, x1, rand.nextInt(5) + 20, z1);
				sculk_stone_gen.get(0).generate(world, rand, x1, rand.nextInt(10) + 15, z1);			
				sculk_grimstone_gen.get(0).generate(world, rand, x1, rand.nextInt(5) + 20, z1);
				sculk_grimstone_gen.get(0).generate(world, rand, x1, rand.nextInt(10) + 15, z1);
				sculk_nullstone_gen.get(0).generate(world, rand, x1, rand.nextInt(5) + 20, z1);
				sculk_nullstone_gen.get(0).generate(world, rand, x1, rand.nextInt(15) + 5, z1);
				sculk_nullstone_gen.get(0).generate(world, rand, x1, rand.nextInt(10) + 15, z1);
				
				sculk_spike_gen.get(0).generate(world, rand, x1, rand.nextInt(12) + 8, z1);
				sculk_spike_gen.get(0).generate(world, rand, x1, rand.nextInt(8) + 15, z1);
				
				sculk_bush_gen.get(0).generate(world, rand, x1, rand.nextInt(15) + 10, z1);
				sculk_bush_gen.get(0).generate(world, rand, x1, rand.nextInt(10) + 5, z1);
				
				sculk_vein_gen.get(0).generate(world, rand, x1, rand.nextInt(15) + 6, z1);
				sculk_vein_gen.get(0).generate(world, rand, x1, rand.nextInt(10) + 21, z1);
				
				sculk_growth_gen.get(0).generate(world, rand, x1, rand.nextInt(15) + 8, z1);
				sculk_growth_gen.get(0).generate(world, rand, x1, rand.nextInt(10) + 20, z1);
				
				sculk_grass_gen.get(0).generate(world, rand, x1, rand.nextInt(15) + 9, z1);
				sculk_grass_gen.get(0).generate(world, rand, x1, rand.nextInt(10) + 19, z1);
				
				deep_flower.get(0).generate(world, rand, x1, rand.nextInt(8) + 5, z1);
				deep_flower.get(0).generate(world, rand, x1, rand.nextInt(10) + 15, z1);
				deep_flower.get(0).generate(world, rand, x1, rand.nextInt(12) + 10, z1);
				deep_flower.get(0).generate(world, rand, x1, rand.nextInt(14) + 16, z1);
				
				}
			
			if((world.getHeightValue(x1, z1) > 0) && Configs.enableSculkGenerationAllBiomes && rand.nextInt(7) == 1) {
				sculk_gen.get(0).generate(world, rand, x1, rand.nextInt(5) + 20, z1);
				sculk_gen.get(0).generate(world, rand, x1, rand.nextInt(10) + 15, z1);
				
				sculk_grimstone_gen.get(0).generate(world, rand, x1, rand.nextInt(10) + 15, z1);
				sculk_nullstone_gen.get(0).generate(world, rand, x1, rand.nextInt(15) + 5, z1);
				
				sculk_spike_gen.get(0).generate(world, rand, x1, rand.nextInt(12) + 8, z1);
				sculk_spike_gen.get(0).generate(world, rand, x1, rand.nextInt(8) + 15, z1);
				
				sculk_bush_gen.get(0).generate(world, rand, x1, rand.nextInt(15) + 10, z1);
				sculk_bush_gen.get(0).generate(world, rand, x1, rand.nextInt(10) + 5, z1);
				
				sculk_vein_gen.get(0).generate(world, rand, x1, rand.nextInt(15) + 6, z1);
				sculk_vein_gen.get(0).generate(world, rand, x1, rand.nextInt(10) + 21, z1);
				
				sculk_growth_gen.get(0).generate(world, rand, x1, rand.nextInt(15) + 8, z1);
				sculk_growth_gen.get(0).generate(world, rand, x1, rand.nextInt(10) + 20, z1);
				
				sculk_grass_gen.get(0).generate(world, rand, x1, rand.nextInt(15) + 9, z1);
				sculk_grass_gen.get(0).generate(world, rand, x1, rand.nextInt(10) + 19, z1);
				
				deep_flower.get(0).generate(world, rand, x1, rand.nextInt(8) + 5, z1);
				deep_flower.get(0).generate(world, rand, x1, rand.nextInt(10) + 15, z1);
				deep_flower.get(0).generate(world, rand, x1, rand.nextInt(12) + 10, z1);
				deep_flower.get(0).generate(world, rand, x1, rand.nextInt(14) + 16, z1);
				
				}
			
			}
			
			if (Configs.enableRareCrystalGeneration && rand.nextInt(15) == 1) {
			//Copartz Gen
			int x2;
			int z2;
			x2 = chunkX * 16 + rand.nextInt(8) + 8;
			z2 = chunkZ * 16 + rand.nextInt(8) + 8;
			BiomeGenBase biome2;
			Type[] biomeList2;
			biome2 = world.getBiomeGenForCoords(x2, z2);
			biomeList2 = BiomeDictionary.getTypesForBiome(biome2);
			if((world.getHeightValue(x2, z2) > 0)) {							
				copartz_gen.get(0).generate(world, rand, x2, rand.nextInt(15) + 40, z2);
				copartz_gen.get(0).generate(world, rand, x2, rand.nextInt(10) + 45, z2);	
				
				}
			
			//Larimar Gen
			int x3;
			int z3;
			x3 = chunkX * 16 + rand.nextInt(8) + 8;
			z3 = chunkZ * 16 + rand.nextInt(8) + 8;
			BiomeGenBase biome3;
			Type[] biomeList3;
			biome3 = world.getBiomeGenForCoords(x3, z3);
			biomeList3 = BiomeDictionary.getTypesForBiome(biome3);
			if((world.getHeightValue(x3, z3) > 0)) {							
				larimar_gen.get(0).generate(world, rand, x3, rand.nextInt(15) + 35, z3);
				larimar_gen.get(0).generate(world, rand, x3, rand.nextInt(10) + 40, z3);	
				
				}
			
			//Tsavorokite Gen
			int x4;
			int z4;
			x4 = chunkX * 16 + rand.nextInt(8) + 8;
			z4 = chunkZ * 16 + rand.nextInt(8) + 8;
			BiomeGenBase biome4;
			Type[] biomeList4;
			biome4 = world.getBiomeGenForCoords(x4, z4);
			biomeList4 = BiomeDictionary.getTypesForBiome(biome4);
			if((world.getHeightValue(x4, z4) > 0)) {							
				tsavorokite_gen.get(0).generate(world, rand, x4, rand.nextInt(15) + 30, z4);
				tsavorokite_gen.get(0).generate(world, rand, x4, rand.nextInt(5) + 35, z4);	
				
				}
			}
			
			//Underground Flora
			int x;
			int z;
			BiomeGenBase biome;
			Type[] biomeList;			
			x = chunkX * 16 + rand.nextInt(8) + 8;
			z = chunkZ * 16 + rand.nextInt(8) + 8;
			biome = world.getBiomeGenForCoords(x, z);
			biomeList = BiomeDictionary.getTypesForBiome(biome);
						
			if((world.getHeightValue(x, z) > 0) && rand.nextInt(3) == 1) {
				
				if (Configs.enableMossGeneration && !(ArrayUtils.contains(Configs.DeeperCavesBlacklist, world.provider.dimensionId) == Configs.DeeperCavesBlacklistAsWhitelist)) {
				
				if(!(BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.COLD) || BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.HOT))) {
				moss_block_gen.get(0).generate(world, rand, x, rand.nextInt(40) + 40, z);
				moss_gen.get(0).generate(world, rand, x, rand.nextInt(20) + 50, z);
				}
				
				if(BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.COLD)) {
				arctic_moss_block_gen.get(0).generate(world, rand, x, rand.nextInt(42) + 30, z);
				arctic_moss_block_gen.get(0).generate(world, rand, x, rand.nextInt(40) + 30, z);
				arctic_moss_gen.get(0).generate(world, rand, x, rand.nextInt(40) + 30, z);
				
				icicle.get(0).generate(world, rand, x, rand.nextInt(10) + 75, z);
				icicle.get(0).generate(world, rand, x, rand.nextInt(5) + 60, z);
				icicle.get(0).generate(world, rand, x, rand.nextInt(15) + 40, z);
					}
				}			
				
			  	if (Configs.enableStalagAndStalacGeneration) {
				stone_stalagmite_gen.get(0).generate(world, rand, x, rand.nextInt(10) + 35, z);
				stone_stalagmite_gen.get(0).generate(world, rand, x, rand.nextInt(10) + 30, z);
				large_stone_stalagmite_gen.get(0).generate(world, rand, x, rand.nextInt(10) + 33, z);
				large_stone_stalagmite_gen.get(0).generate(world, rand, x, rand.nextInt(10) + 28, z);
				nullstone_stalagmite_gen.get(0).generate(world, rand, x, rand.nextInt(20) + 15, z);
				nullstone_stalagmite_gen.get(0).generate(world, rand, x, rand.nextInt(10) + 5, z);
				large_nullstone_stalagmite_gen.get(0).generate(world, rand, x, rand.nextInt(20) + 13, z);
				large_nullstone_stalagmite_gen.get(0).generate(world, rand, x, rand.nextInt(10) + 4, z);
				
				stone_stalactite_gen.get(0).generate(world, rand, x, rand.nextInt(10) + 35, z);
			    stone_stalactite_gen.get(0).generate(world, rand, x, rand.nextInt(10) + 30, z);
				large_stone_stalactite_gen.get(0).generate(world, rand, x, rand.nextInt(10) + 30, z);
				large_stone_stalactite_gen.get(0).generate(world, rand, x, rand.nextInt(15) + 25, z);
				nullstone_stalactite_gen.get(0).generate(world, rand, x, rand.nextInt(15) + 10, z);
				nullstone_stalactite_gen.get(0).generate(world, rand, x, rand.nextInt(10) + 8, z);
				nullstone_stalactite_gen.get(0).generate(world, rand, x, rand.nextInt(10) + 5, z);
				large_nullstone_stalactite_gen.get(0).generate(world, rand, x, rand.nextInt(15) + 8, z);
				large_nullstone_stalactite_gen.get(0).generate(world, rand, x, rand.nextInt(10) + 7, z);
				large_nullstone_stalactite_gen.get(0).generate(world, rand, x, rand.nextInt(15) + 8, z);
				 }
				
				if (Configs.enableGlowLichenGeneration) {
				glow_lichen_gen.get(0).generate(world, rand, x, rand.nextInt(40) + 20, z);
				glow_lichen_gen.get(0).generate(world, rand, x, rand.nextInt(40) + 15, z);
				
				glow_lichen_gen.get(0).generate(world, rand, x, rand.nextInt(20) + 15, z);
				glow_lichen_gen.get(0).generate(world, rand, x, rand.nextInt(10) + 15, z);
				 }
				
				if (Configs.enableLichenGeneration) {
				grim_lichen_gen.get(0).generate(world, rand, x, rand.nextInt(30) + 15, z);
				grim_lichen_gen.get(0).generate(world, rand, x, rand.nextInt(30) + 5, z);
				  }	
																				
				if (Configs.enableAdditonalCoalOreGeneration && !(ArrayUtils.contains(Configs.DeeperCavesBlacklist, world.provider.dimensionId) == Configs.DeeperCavesBlacklistAsWhitelist)) {
				additional_coal.get(0).generate(world, rand, x, rand.nextInt(25) + 30, z);
				}
				if (Configs.enableAdditonalIronOreGeneration && !(ArrayUtils.contains(Configs.DeeperCavesBlacklist, world.provider.dimensionId) == Configs.DeeperCavesBlacklistAsWhitelist)) {
				additional_iron.get(0).generate(world, rand, x, rand.nextInt(15) + 25, z);
				}
				if (Configs.enableAdditonalGoldOreGeneration && !(ArrayUtils.contains(Configs.DeeperCavesBlacklist, world.provider.dimensionId) == Configs.DeeperCavesBlacklistAsWhitelist)) {
				additional_gold.get(0).generate(world, rand, x, rand.nextInt(20) + 6, z);
				}
				if (Configs.enableAdditonalRedstoneOreGeneration && !(ArrayUtils.contains(Configs.DeeperCavesBlacklist, world.provider.dimensionId) == Configs.DeeperCavesBlacklistAsWhitelist)) {
				additional_redstone.get(0).generate(world, rand, x, rand.nextInt(25) + 6, z);
				}
				if (Configs.enableAdditonalLapisOreGeneration && !(ArrayUtils.contains(Configs.DeeperCavesBlacklist, world.provider.dimensionId) == Configs.DeeperCavesBlacklistAsWhitelist)) {
				additional_lapis.get(0).generate(world, rand, x, rand.nextInt(5) + 20, z);
				}
				if (Configs.enableAdditonalDiamondOreGeneration && !(ArrayUtils.contains(Configs.DeeperCavesBlacklist, world.provider.dimensionId) == Configs.DeeperCavesBlacklistAsWhitelist)) {
				additional_diamond.get(0).generate(world, rand, x, rand.nextInt(15) + 6, z);
				}
						
			}
			
			if (Configs.enablePherithiumGeneration == true) {
				pherithium_gen.get(0).generate(world, rand, x, rand.nextInt(25) + 15, z);
				small_pherithium_gen.get(0).generate(world, rand, x, rand.nextInt(23) + 15, z);
				}
			
			if ((world.getHeightValue(x, z) > 0) && rand.nextInt(2) == 1) {
			deep_roots.get(0).generate(world, rand, x, rand.nextInt(20) + 5, z);
			deep_roots.get(0).generate(world, rand, x, rand.nextInt(18) + 5, z);
			deep_roots.get(0).generate(world, rand, x, rand.nextInt(15) + 5, z);
			deep_roots.get(0).generate(world, rand, x, rand.nextInt(10) + 2, z);
			deep_roots.get(0).generate(world, rand, x, rand.nextInt(5) + 2, z);
			}			
			
			if((world.getHeightValue(x, z) > 0)) {
				if (Configs.enableLichenGeneration && rand.nextInt(4) == 1) {
				dark_lichen_gen.get(0).generate(world, rand, x, rand.nextInt(10) + 20, z);
				dark_lichen_gen.get(0).generate(world, rand, x, rand.nextInt(20) + 5, z);
				}
				
				if (Configs.enableNovaMushrooomGeneration && rand.nextInt(3) == 1) {
				mushroom.get(0).generate(world, rand, x, rand.nextInt(20) + 5, z);
				mushroom.get(0).generate(world, rand, x, rand.nextInt(30) + 5, z);
				
				mushroom2.get(0).generate(world, rand, x, rand.nextInt(15) + 5, z);
				mushroom2.get(0).generate(world, rand, x, rand.nextInt(30) + 2, z);
				
				mushroom3.get(0).generate(world, rand, x, rand.nextInt(20) + 5, z);
				mushroom3.get(0).generate(world, rand, x, rand.nextInt(30) + 5, z);
				
				mushroom4.get(0).generate(world, rand, x, rand.nextInt(10) + 5, z);
				mushroom4.get(0).generate(world, rand, x, rand.nextInt(20) + 5, z);
				
				mushroom5.get(0).generate(world, rand, x, rand.nextInt(8) + 5, z);
				mushroom5.get(0).generate(world, rand, x, rand.nextInt(18) + 5, z);
				}
				
				}
			
			{ 
			  //Surface Flowers
			  if (rand.nextInt(4) == 1) {
			  x = chunkX * 16 + rand.nextInt(8) + 8;
			  z = chunkZ * 16 + rand.nextInt(8) + 8;
			  biome = world.getBiomeGenForCoords(x, z);
			  biomeList = BiomeDictionary.getTypesForBiome(biome);
			  if((ArrayUtils.contains(biomeList, Type.PLAINS) || (ArrayUtils.contains(biomeList, Type.PLAINS) && ArrayUtils.contains(biomeList, Type.SNOWY))) && world.getHeightValue(x, z) > 0) {
			 	  cyan_rose.get(0).generate(world, rand, x, nextHeightInt(rand, world.getHeightValue(x, z) * 2), z);
			  		}			  
			  if(ArrayUtils.contains(biomeList, Type.FOREST) && !ArrayUtils.contains(biomeList, Type.SNOWY) && world.getHeightValue(x, z) > 0) {
				  violet.get(0).generate(world, rand, x, nextHeightInt(rand, world.getHeightValue(x, z) * 2), z);
			  		}
			  if(ArrayUtils.contains(biomeList, Type.HOT) && !ArrayUtils.contains(biomeList, Type.SNOWY) && world.getHeightValue(x, z) > 0) {
				  desert_bloom.get(0).generate(world, rand, x, nextHeightInt(rand, world.getHeightValue(x, z) * 2), z);
			  		}
			  if(ArrayUtils.contains(biomeList, Type.JUNGLE) || ArrayUtils.contains(biomeList, Type.SWAMP) && !ArrayUtils.contains(biomeList, Type.SNOWY) && world.getHeightValue(x, z) > 0) {
				  purple_rose.get(0).generate(world, rand, x, nextHeightInt(rand, world.getHeightValue(x, z) * 2), z);
			  		}
			  if(ArrayUtils.contains(biomeList, Type.MOUNTAIN) && !ArrayUtils.contains(biomeList, Type.PLAINS) && world.getHeightValue(x, z) > 0) {
				  cosmos.get(0).generate(world, rand, x, nextHeightInt(rand, world.getHeightValue(x, z) * 2), z);
			  		}
			  if(ArrayUtils.contains(biomeList, Type.SANDY) && !ArrayUtils.contains(biomeList, Type.COLD) && world.getHeightValue(x, z) > 0) {
				  blooming_barb.get(0).generate(world, rand, x, nextHeightInt(rand, world.getHeightValue(x, z) * 2), z);
			  		}
				}
			}
			
			{ 
			//TorchFlowers
			if (rand.nextInt(3) == 1) {
			 x = chunkX * 16 + rand.nextInt(8) + 8;
			 z = chunkZ * 16 + rand.nextInt(8) + 8;
			 biome = world.getBiomeGenForCoords(x, z);
			 biomeList = BiomeDictionary.getTypesForBiome(biome);
			 if( biome.biomeID == 132 || (ArrayUtils.contains(biomeList, Type.MAGICAL) && !ArrayUtils.contains(biomeList, Type.LUSH) && !ArrayUtils.contains(biomeList, Type.JUNGLE) && world.getHeightValue(x, z) > 0)) {
				 torchflower.get(0).generate(world, rand, x, nextHeightInt(rand, world.getHeightValue(x, z) * 2), z);
			 		}
				}
			}
				
			}
		}
	
	
	static {
		NCWorldGeneratorPlants.placementFlagType = 2;
    }
	
	
	protected int nextHeightInt(Random rand, int i) {
		if (i <= 1)
			return 1;
		return rand.nextInt(i);
	}

}
