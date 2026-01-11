package com.NovaCraft.world;

import java.util.Random;

import com.NovaCraft.config.ConfigsCompact;
import com.NovaCraft.config.ConfigsWorld;
import org.apache.commons.lang3.ArrayUtils;
import com.NovaCraft.config.Configs;
import com.NovaCraft.registry.OtherModBlocks;
import com.NovaCraftBlocks.NovaCraftBlocks;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.Loader;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class NCWorldGeneratorPre implements IWorldGenerator {

	protected final WorldGenMinable grimstoneGen = new WorldGenMinable(NovaCraftBlocks.grimstone, 48, Blocks.stone);
	protected final WorldGenMinable nullstoneGen = new WorldGenMinable(NovaCraftBlocks.nullstone, 48, Blocks.stone);
	protected final WorldGenMinable etherstoneGen = new WorldGenMinable(NovaCraftBlocks.etherstone, 32, Blocks.stone);
	
	protected final WorldGenMinable basalGen = new WorldGenMinable(NovaCraftBlocks.basal, 48, Blocks.netherrack);
	
	protected final WorldGenMinable additionalDeepslateGen = new WorldGenMinable(OtherModBlocks.deepslate, 48, Blocks.stone);
	protected final WorldGenMinable additionalCalciteGen = new WorldGenMinable(OtherModBlocks.calcite, 32, Blocks.stone);
	protected final WorldGenMinable alternateTuffGen = new WorldGenMinable(OtherModBlocks.tuff, 32, Blocks.stone);
	
	protected final WorldGenMinable endstoneGen = new WorldGenMinable(Blocks.end_stone, 64, Blocks.air);
	protected final WorldGenMinable frontierslateGen = new WorldGenMinable(NovaCraftBlocks.frontierslate, 64, Blocks.air);
	protected final WorldGenMinable vaccumSandGen = new WorldGenMinable(NovaCraftBlocks.vacuum_sand, 32, Blocks.end_stone);
	
	public NCWorldGeneratorPre() {
	}
	
	@Override
	public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		
		//The 3 main stone types
		if (world.provider.dimensionId == 0 && ConfigsWorld.enableGrimstone) {
			this.generateOre(grimstoneGen, world, rand, chunkX, chunkZ, 6, 10, 24);
		} else if (ArrayUtils.contains(ConfigsCompact.DeeperCavesBlacklist, world.provider.dimensionId) == ConfigsCompact.DeeperCavesBlacklistAsWhitelist) {
			this.generateOreDeeperCaves(grimstoneGen, world, rand, chunkX, chunkZ, 6, 2, 256);	
		}
		
		if (world.provider.dimensionId == 0 && ConfigsWorld.enableNullstone) {
			this.generateOre(nullstoneGen, world, rand, chunkX, chunkZ, 5, 5, 18);
		} else if (ArrayUtils.contains(ConfigsCompact.DeeperCavesBlacklist, world.provider.dimensionId) == ConfigsCompact.DeeperCavesBlacklistAsWhitelist) {
			this.generateOreDeeperCaves(nullstoneGen, world, rand, chunkX, chunkZ, 6, 2, 256);	
		}
		
		if (world.provider.dimensionId == 0 && ConfigsWorld.enableEtherstone && !(ArrayUtils.contains(ConfigsCompact.DeeperCavesBlacklist, world.provider.dimensionId) == ConfigsCompact.DeeperCavesBlacklistAsWhitelist)) {
			if (ConfigsWorld.enableVanillaMountainBiomeAlterations && ConfigsWorld.enableVanillaBiomeAlterations) {
				this.generateOre(etherstoneGen, world, rand, chunkX, chunkZ, 6, 146, 256);
			} else {
				this.generateOre(etherstoneGen, world, rand, chunkX, chunkZ, 6, 85, 256);
			}
		}
		
		//Adds Deepslate to the DeepCave Mod Realms
		if (Loader.isModLoaded("etfuturum") && ArrayUtils.contains(ConfigsCompact.DeeperCavesBlacklist, world.provider.dimensionId) == ConfigsCompact.DeeperCavesBlacklistAsWhitelist) {
			this.generateOreDeeperCaves(additionalDeepslateGen, world, rand, chunkX, chunkZ, 6, 2, 256);	
		}
		
		//Allows Calcite to generate in mountain-esc biomes like in 1.18
		if (Loader.isModLoaded("etfuturum") && (ConfigsCompact.enableCalciteGeneration) && !(ArrayUtils.contains(ConfigsCompact.DeeperCavesBlacklist, world.provider.dimensionId) == ConfigsCompact.DeeperCavesBlacklistAsWhitelist)) {
			this.generateOre(additionalCalciteGen, world, rand, chunkX, chunkZ, 6, 70, 100);
		}
		
		//Changes up the generation of Tuff to be higher up as to have less stone types deeper underground, disable Et Futurum's generation
		if (Loader.isModLoaded("etfuturum") && (ConfigsCompact.enableNovaCraftTuffGeneration) && !(ArrayUtils.contains(ConfigsCompact.DeeperCavesBlacklist, world.provider.dimensionId) == ConfigsCompact.DeeperCavesBlacklistAsWhitelist)) {
			this.generateOre(alternateTuffGen, world, rand, chunkX, chunkZ, 6, 25, 45);
		}
		
		if (world.provider.dimensionId == 1 && ConfigsWorld.enableEndstoneBlobs && rand.nextInt(3) == 0) {
			this.generateEndStone(endstoneGen, world, rand, chunkX, chunkZ, 1, 24, 96);
		}
		
		if (world.provider.dimensionId == 1 && ConfigsWorld.enableFrontierslate && rand.nextInt(4) == 0) {
			this.generateFrontierslate(frontierslateGen, world, rand, chunkX, chunkZ, 1, 1, 24);
		}
		
		if (world.provider.dimensionId == 1 && ConfigsWorld.enableVacuumSand) {
			this.generateVacuumSand(vaccumSandGen, world, rand, chunkX, chunkZ, 3, 48, 128);
		}
		
		if (world.provider.dimensionId == -1 && ConfigsWorld.enableBasal) {
			this.generateOre(basalGen, world, rand, chunkX, chunkZ, 3, 6, 30);
		}
	}
	
	public void generateOre(WorldGenMinable gen, World world, Random random, int chunkX, int chunkZ, float chance, int minY, int maxY) {
		if (minY < 0 || maxY < minY || chance <= 0)
			return;

		for (int i = 0; i < (chance < 1 ? 1 : (int) chance); i++) {
			if (chance >= 1 || random.nextFloat() < chance) {
				int xRand = (chunkX << 4) + random.nextInt(16);
				int yRand = MathHelper.getRandomIntegerInRange(random, minY, maxY);
				int zRand = (chunkZ << 4) + random.nextInt(16);

				gen.generate(world, random, xRand, yRand, zRand);
			}
		}
	}
	
	public void generateOreDeeperCaves(WorldGenMinable gen, World world, Random random, int chunkX, int chunkZ, float chance, int minY, int maxY) {
		if (maxY <= 256 || minY < 0 || maxY < minY || chance <= 0)
			return;

		for (int i = 0; i < (chance < 1 ? 1 : (int) chance); i++) {
			if (chance >= 1 || random.nextFloat() < chance) {
				int xRand = (chunkX << 4) + random.nextInt(16);
				int yRand = MathHelper.getRandomIntegerInRange(random, minY, maxY);
				int zRand = (chunkZ << 4) + random.nextInt(16);

				gen.generate(world, random, xRand, yRand, zRand);
			}
		}
	}
	
	public void generateEndStone(WorldGenMinable gen, World world, Random random, int chunkX, int chunkZ, float chance, int minY, int maxY) {
		if (minY < 0 || maxY < minY || chance <= 0)
			return;

		for (int i = 0; i < (chance < 1 ? 1 : (int) chance); i++) {
			if (chance >= 1 || random.nextFloat() < chance) {
				int xRand = (chunkX << 4) + random.nextInt(16);
				int yRand = MathHelper.getRandomIntegerInRange(random, minY, maxY);
				int zRand = (chunkZ << 4) + random.nextInt(16);

				gen.generate(world, random, xRand, yRand, zRand);
			}
		}
	}
	
	public void generateFrontierslate(WorldGenMinable gen, World world, Random random, int chunkX, int chunkZ, float chance, int minY, int maxY) {
		if (minY < 0 || maxY < minY || chance <= 0)
			return;

		for (int i = 0; i < (chance < 1 ? 1 : (int) chance); i++) {
			if (chance >= 1 || random.nextFloat() < chance) {
				int xRand = (chunkX << 4) + random.nextInt(16);
				int yRand = MathHelper.getRandomIntegerInRange(random, minY, maxY);
				int zRand = (chunkZ << 4) + random.nextInt(16);

				gen.generate(world, random, xRand, yRand, zRand);
			}
		}
	}
	
	public void generateVacuumSand(WorldGenMinable gen, World world, Random random, int chunkX, int chunkZ, float chance, int minY, int maxY) {
		if (minY < 0 || maxY < minY || chance <= 0)
			return;

		for (int i = 0; i < (chance < 1 ? 1 : (int) chance); i++) {
			if (chance >= 1 || random.nextFloat() < chance) {
				int xRand = (chunkX << 4) + random.nextInt(16);
				int yRand = MathHelper.getRandomIntegerInRange(random, minY, maxY);
				int zRand = (chunkZ << 4) + random.nextInt(16);

				gen.generate(world, random, xRand, yRand, zRand);
			}
		}
	}
}
