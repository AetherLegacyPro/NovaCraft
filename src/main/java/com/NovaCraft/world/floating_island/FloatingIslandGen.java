package com.NovaCraft.world.floating_island;

import cpw.mods.fml.common.IWorldGenerator;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import org.apache.commons.lang3.ArrayUtils;

public class FloatingIslandGen implements IWorldGenerator {

    @Override
    public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {

        if (world.provider.dimensionId == 0) {
            generateSurface(world, rand, chunkX * 16, chunkZ * 16);
        }
    }

    private static int floorDiv(int a, int b) {
        if (a >= 0) return a / b;
        return -((-a + b - 1) / b);
    }

    private void generateSurface(World world, Random rand, int x, int z) {
        if (Math.abs(x) >= 12000 && Math.abs(z) >= 12000) {
            final int spacing = 1000;

            int regionX = floorDiv(x, spacing);
            int regionZ = floorDiv(z, spacing);

            Random regionRand = new Random(world.getSeed() + (long) (regionX * 341873128712L) + (long) (regionZ * 132897987541L));

            if (regionRand.nextInt(2) != 0) return;

            int baseX = regionX * spacing + regionRand.nextInt(spacing);
            int baseZ = regionZ * spacing + regionRand.nextInt(spacing);

            if ((x >> 4) != (baseX >> 4) || (z >> 4) != (baseZ >> 4)) return;

            BiomeGenBase biome = world.getBiomeGenForCoords(baseX, baseZ);
            Type[] biomeTypes = BiomeDictionary.getTypesForBiome(biome);

            BiomeGenBase biomePosX = world.getBiomeGenForCoords(baseX + 150, baseZ);
            Type[] biomeTypesPosX = BiomeDictionary.getTypesForBiome(biomePosX);

            BiomeGenBase biomeNegX = world.getBiomeGenForCoords(baseX - 150, baseZ);
            Type[] biomeTypesNegX = BiomeDictionary.getTypesForBiome(biomeNegX);

            BiomeGenBase biomePosZ = world.getBiomeGenForCoords(baseX, baseZ + 150);
            Type[] biomeTypesPosZ = BiomeDictionary.getTypesForBiome(biomePosZ);

            BiomeGenBase biomeNegZ = world.getBiomeGenForCoords(baseX, baseZ - 150);
            Type[] biomeTypesNegZ = BiomeDictionary.getTypesForBiome(biomeNegZ);

            if (ArrayUtils.contains(biomeTypes, Type.OCEAN) && ArrayUtils.contains(biomeTypesPosX, Type.OCEAN) && ArrayUtils.contains(biomeTypesNegX, Type.OCEAN)
                    && ArrayUtils.contains(biomeTypesPosZ, Type.OCEAN) && ArrayUtils.contains(biomeTypesNegZ, Type.OCEAN)) {

                int minBumps = 75, maxBumps = 95;
                int blocksPerBumpMin = 2, blocksPerBumpMax = 4;
                int minHeight = 120, heightVariation = 16;

                int islandX = baseX;
                int islandY = regionRand.nextInt(heightVariation) + minHeight;
                int islandZ = baseZ;

                int bumpsWide = randInRange(regionRand, minBumps, maxBumps);
                int bumpsLong = randInRange(regionRand, minBumps, maxBumps);

                int bumpHeightVarTop = randInRange(regionRand, 4, 6);
                int bumpHeightVarBottom = randInRange(regionRand, 3, 6);
                int bumpHeightMinTop = 3;
                int bumpHeightMinBottom = 3;

                int blocksPerBumpX = randInRange(regionRand, blocksPerBumpMin, blocksPerBumpMax);
                int blocksPerBumpZ = randInRange(regionRand, blocksPerBumpMin, blocksPerBumpMax);

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

                System.out.println("Floating Island generating at (X:" + islandX + ", Z:" + islandZ + ")");

                new WorldGenFloatingIsland(bumpsWide, bumpsLong, bumpHeightVarTop, bumpHeightVarBottom, bumpHeightMinTop, bumpHeightMinBottom, blocksPerBumpX, blocksPerBumpZ, 1, 1, blurPassesTop, blurPassesBottom, spikeHeightVarTop, spikeHeightVarBottom, radialSamples, radialMin, radialVar, radialScaling, radialBlur, genOre).generate(world, regionRand, islandX, islandY, islandZ);

                new FloatingIslandAltar().generate(world, regionRand, islandX + 40, islandY + 2, islandZ + 70);
            }
        }
    }

    private int randInRange(Random rand, int min, int max) {
        return (max <= min) ? min : rand.nextInt(max - min) + min;
    }
}