package com.NovaCraft.world.floating_island;

import com.NovaCraft.config.Configs;
import cpw.mods.fml.common.IWorldGenerator;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;

public class FloatingIslandGen implements IWorldGenerator {

    @Override
    public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        this.generateSurface(world, rand, chunkX * 16, chunkZ * 16);
    }

    private void generateSurface(World world, Random rand, int x, int z) {
        BiomeGenBase biome = world.getWorldChunkManager().getBiomeGenAt(x + 16, z + 16);
        if ((biome == BiomeGenBase.ocean || biome == BiomeGenBase.deepOcean) && rand.nextInt(2400) == 0) {

            // Slightly wider island
            int minBumps = 55, maxBumps = 75;
            int blocksPerBumpMin = 2, blocksPerBumpMax = 4;

            int minHeight = 120, heightVariation = 16;

            int islandX = x + rand.nextInt(16) + 8;
            int islandY = rand.nextInt(heightVariation) + minHeight;
            int islandZ = z + rand.nextInt(16) + 8;

            int bumpsWide = randInRange(rand, minBumps, maxBumps);
            int bumpsLong = randInRange(rand, minBumps, maxBumps);

            // Slightly taller top and bottom for bump realism
            int bumpHeightVarTop = randInRange(rand, 4, 6);
            int bumpHeightVarBottom = randInRange(rand, 3, 6);
            int bumpHeightMinTop = 3;
            int bumpHeightMinBottom = 3;

            int blocksPerBumpX = randInRange(rand, blocksPerBumpMin, blocksPerBumpMax);
            int blocksPerBumpZ = randInRange(rand, blocksPerBumpMin, blocksPerBumpMax);
            int blocksPerBumpTopY = 1;
            int blocksPerBumpBottomY = 1;

            int blurPassesTop = 5;
            int blurPassesBottom = 4;

            int spikeHeightVarTop = 1;
            int spikeHeightVarBottom = 3;

            int radialSamples = 20;
            double radialMin = 0.0;
            double radialVar = 1.0;
            int radialScaling = 5;
            int radialBlur = 4;

            Block genOre = Blocks.gold_block;

            //if (Configs.enableDebugMode) {
                System.out.println("Island generated at (X:" + islandX + ", Z:" + islandZ + ")");
            //}

            new WorldGenFloatingIsland(bumpsWide, bumpsLong, bumpHeightVarTop, bumpHeightVarBottom, bumpHeightMinTop, bumpHeightMinBottom, blocksPerBumpX, blocksPerBumpZ, blocksPerBumpTopY, blocksPerBumpBottomY, blurPassesTop, blurPassesBottom, spikeHeightVarTop, spikeHeightVarBottom, radialSamples, radialMin, radialVar, radialScaling, radialBlur, genOre).generate(world, rand, islandX, islandY, islandZ);
            new FloatingIslandAltar().generate(world, rand, islandX + 40, islandY + 2, islandZ + 70);
        }
    }

    private int randInRange(Random rand, int min, int max) {
        return (max <= min) ? min : rand.nextInt(max - min) + min;
    }
}
