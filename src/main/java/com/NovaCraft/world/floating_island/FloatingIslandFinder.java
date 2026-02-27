package com.NovaCraft.world.floating_island;

import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import org.apache.commons.lang3.ArrayUtils;
import java.util.Random;

public class FloatingIslandFinder {
    private static final boolean DEBUG = false;

    private static int floorDiv(int a, int b) {
        if (b <= 0) {
            throw new IllegalArgumentException("b must be > 0");
        } else {
            return a >= 0 ? a / b : -((-a + b - 1) / b);
        }
    }

    public static ChunkCoordinates getNearestAncientCity(World world, int playerX, int playerZ) {
        int spacing = 1000;
        int searchRadius = 20;
        int playerRegionX = floorDiv(playerX, spacing);
        int playerRegionZ = floorDiv(playerZ, spacing);

        for(int radius = 0; radius <= searchRadius; ++radius) {
            for(int rx = -radius; rx <= radius; ++rx) {
                for(int rz = -radius; rz <= radius; ++rz) {
                    int regionX = playerRegionX + rx;
                    int regionZ = playerRegionZ + rz;
                    Random regionRand = new Random(world.getSeed() + (long)regionX * 341873128712L + (long)regionZ * 132897987541L);
                    if (regionRand.nextInt(2) == 0) {
                        int baseX = regionX * 1000 + regionRand.nextInt(spacing);
                        int baseZ = regionZ * 1000 + regionRand.nextInt(spacing);
                        if (Math.abs(baseX) >= 12000 && Math.abs(baseZ) >= 12000) {
                            int chunkCornerX = baseX >> 4 << 4;
                            int chunkCornerZ = baseZ >> 4 << 4;

                            BiomeGenBase biome = world.getBiomeGenForCoords(chunkCornerX, chunkCornerZ);
                            BiomeGenBase biomePosX = world.getBiomeGenForCoords(chunkCornerX + 150, chunkCornerZ);
                            BiomeGenBase biomeNegX = world.getBiomeGenForCoords(chunkCornerX - 150, chunkCornerZ);
                            BiomeGenBase biomePosZ = world.getBiomeGenForCoords(chunkCornerX, chunkCornerZ + 150);
                            BiomeGenBase biomeNegZ = world.getBiomeGenForCoords(chunkCornerX, chunkCornerZ - 150);

                            Type[] biomeList = BiomeDictionary.getTypesForBiome(biome);
                            Type[] biomePosXList = BiomeDictionary.getTypesForBiome(biomePosX);
                            Type[] biomeNegXList = BiomeDictionary.getTypesForBiome(biomeNegX);
                            Type[] biomePosZList = BiomeDictionary.getTypesForBiome(biomePosZ);
                            Type[] biomeNegZList = BiomeDictionary.getTypesForBiome(biomeNegZ);

                            boolean good = ArrayUtils.contains(biomeList, Type.OCEAN) && ArrayUtils.contains(biomePosXList, Type.OCEAN) && ArrayUtils.contains(biomeNegXList, Type.OCEAN)
                            && ArrayUtils.contains(biomePosZList, Type.OCEAN) && ArrayUtils.contains(biomeNegZList, Type.OCEAN);
                            if (good) {
                                int y = 128;
                                return new ChunkCoordinates(baseX + 50, y, baseZ + 50);
                            }
                        }
                    }
                }
            }
        }

        return null;
    }
}
