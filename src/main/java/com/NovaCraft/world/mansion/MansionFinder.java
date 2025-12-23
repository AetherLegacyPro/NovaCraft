package com.NovaCraft.world.mansion;

import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Random;

public class MansionFinder {

    private static int floorDiv(int a, int b) {
        return a >= 0 ? a / b : -((-a + b - 1) / b);
    }

    public static ChunkCoordinates getNearestMansion(World world, int playerX, int playerZ) {

        final int spacing = 500; // same as generator
        int playerRegionX = floorDiv(playerX, spacing);
        int playerRegionZ = floorDiv(playerZ, spacing);

        ChunkCoordinates closest = null;
        double bestDist = Double.MAX_VALUE;

        for (int radius = 0; radius <= 20; radius++) {
            for (int rx = -radius; rx <= radius; rx++) {
                for (int rz = -radius; rz <= radius; rz++) {

                    int regionX = playerRegionX + rx;
                    int regionZ = playerRegionZ + rz;

                    Random regionRand = new Random(world.getSeed() + (long) regionX * 341873128712L + (long) regionZ * 132897987541L);
                    if (regionRand.nextInt(2) != 1) continue; // same 50% chance as generator

                    int baseX = regionX * spacing + regionRand.nextInt(spacing);
                    int baseZ = regionZ * spacing + regionRand.nextInt(spacing);

                    if (Math.abs(baseX) < 12000 || Math.abs(baseZ) < 12000) continue;

                    int chunkCornerX = baseX >> 4 << 4;
                    int chunkCornerZ = baseZ >> 4 << 4;

                    BiomeGenBase biome = world.getBiomeGenForCoords(chunkCornerX, chunkCornerZ);
                    Type[] biomeTypes = BiomeDictionary.getTypesForBiome(biome);

                    BiomeGenBase biomePosX = world.getBiomeGenForCoords(chunkCornerX + 60, chunkCornerZ);
                    Type[] biomeTypesPosX = BiomeDictionary.getTypesForBiome(biomePosX);

                    BiomeGenBase biomePosZ = world.getBiomeGenForCoords(chunkCornerX, chunkCornerZ + 76);
                    Type[] biomeTypesPosZ = BiomeDictionary.getTypesForBiome(biomePosZ);

                    BiomeGenBase biomePosXPosZ = world.getBiomeGenForCoords(chunkCornerX + 60, chunkCornerZ + 76);
                    Type[] biomeTypesPosXPosZ = BiomeDictionary.getTypesForBiome(biomePosXPosZ);

                    if (!ArrayUtils.contains(biomeTypes, Type.FOREST) || !ArrayUtils.contains(biomeTypesPosX, Type.FOREST)
                            || !ArrayUtils.contains(biomeTypesPosZ, Type.FOREST) || !ArrayUtils.contains(biomeTypesPosXPosZ, Type.FOREST)) {
                        continue;
                    }

                    // Exact offsets used in MansionGen
                    int x1 = baseX + regionRand.nextInt(8) + 8;
                    int z1 = baseZ + regionRand.nextInt(8) + 8;
                    int x2 = x1 + 36;
                    int z2 = z1 + 36;

                    double dx = x2 - playerX;
                    double dz = z2 - playerZ;
                    double dist = dx * dx + dz * dz;

                    if (dist < bestDist) {
                        bestDist = dist;
                        closest = new ChunkCoordinates(x2, 90, z2); // y is arbitrary for the Eye
                    }
                }
            }
        }

        return closest;
    }
}
