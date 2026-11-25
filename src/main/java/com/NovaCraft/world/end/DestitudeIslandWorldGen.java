package com.NovaCraft.world.end;

import java.util.Random;

import com.NovaCraft.config.Configs;
import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;

public class DestitudeIslandWorldGen implements IWorldGenerator {
	@Override
	public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		if (world.provider.dimensionId == 1) {
			this.generateEnd(world, rand, chunkX * 16, chunkZ * 16);
		}
	}

	public void generateEnd(World world, Random rand, int x, int z) {
		ChunkCoordinates position = DestituteIslandPlacement.getIslandPosition(world, x >> 4, z >> 4);
		if (position == null) {
			return;
		}

		int x1 = position.posX;
		int y1 = position.posY;
		int z1 = position.posZ;

		int bumpsWideMin = 20;
		int bumpsWideMax = 35;
		int bumpsLongMin = 20;
		int bumpsLongMax = 35;

		int bumpHeightVarTopMin = 2;
		int bumpHeightVarTopMax = 3;
		int bumpHeightVarBottomMin = 5;
		int bumpHeightVarBottomMax = 7;
		int bumpHeightMinTop = 2;
		int bumpHeightMinBottom = 2;
		int blocksPerBumpXMin = 2;
		int blocksPerBumpXMax = 5;
		int blocksPerBumpZMin = rand.nextInt(3) + 2;
		int blocksPerBumpZMax = 5;
		int blocksPerBumpTopYMin = 1;
		int blocksPerBumpTopYMax = 1;
		int blocksPerBumpBottomYMin = 2;
		int blocksPerBumpBottomYMax = 4;
		int blurPassesTop = 5;
		int blurPassesBottom = 5;

		int spikeHeightVarTop = 1;
		int spikeHeightVarBottom = 3;

		int radialDistanceSamples = 18;
		double radialDistanceMin = 0.0D;
		double radialDistanceVar = 1.0D;
		int radialDistanceScaling = 5;
		int radialDistanceBlurPasses = 5;

		int bumpsWide = this.randomBetween(rand, bumpsWideMin, bumpsWideMax);
		int bumpsLong = this.randomBetween(rand, bumpsLongMin, bumpsLongMax);
		int bumpHeightVarTop = this.randomBetween(rand, bumpHeightVarTopMin, bumpHeightVarTopMax);
		int bumpHeightVarBottom = this.randomBetween(rand, bumpHeightVarBottomMin, bumpHeightVarBottomMax);
		int blocksPerBumpX = this.randomBetween(rand, blocksPerBumpXMin, blocksPerBumpXMax);
		int blocksPerBumpZ = this.randomBetween(rand, blocksPerBumpZMin, blocksPerBumpZMax);
		int blocksPerBumpTopY = this.randomBetween(rand, blocksPerBumpTopYMin, blocksPerBumpTopYMax);
		int blocksPerBumpBottomY = this.randomBetween(rand, blocksPerBumpBottomYMin, blocksPerBumpBottomYMax);

		//if (Configs.enableDebugMode) {
			System.out.println("Destitude island generating at (X:" + x1 + ", Y:" + y1 + ", Z:" + z1 + ")");
			System.out.println("May take a moment; be patient!");
		//}

		Block islandBlock = Blocks.obsidian;
		int[][] offsets = {{0, 0}, {-32, 32}, {32, -32}, {-32, -32}, {32, 32}};
		for (int[] offset : offsets) {
			new DestitudeIsland(bumpsWide, bumpsLong, bumpHeightVarTop, bumpHeightVarBottom, bumpHeightMinTop, bumpHeightMinBottom, blocksPerBumpX, blocksPerBumpZ, blocksPerBumpTopY, blocksPerBumpBottomY, blurPassesTop, blurPassesBottom, spikeHeightVarTop, spikeHeightVarBottom, radialDistanceSamples, radialDistanceMin, radialDistanceVar, radialDistanceScaling, radialDistanceBlurPasses, islandBlock).generate(world, rand, x1 + offset[0], y1, z1 + offset[1]);
		}
	}

	private int randomBetween(Random random, int minimum, int maximum) {
		if (maximum <= minimum) {
			return minimum;
		}

		return minimum + random.nextInt(maximum - minimum);
	}
}