package com.NovaCraft.world.ancient_city;

import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import org.apache.commons.lang3.ArrayUtils;
import java.util.Random;

public class AncientCityFinder {
    //This is how the Echo Eye looks for the nearest Ancient City to point toward
    private static final boolean DEBUG = false;

    private static int floorDiv(int a, int b) {
        if (b <= 0) throw new IllegalArgumentException("b must be > 0");
        if (a >= 0) return a / b;
        return -(((-a) + b - 1) / b);
    }

    public static ChunkCoordinates getNearestAncientCity(World world, int playerX, int playerZ) {
        final int spacing = 750;
        final int searchRadius = 20;

        int playerRegionX = floorDiv(playerX, spacing);
        int playerRegionZ = floorDiv(playerZ, spacing);

        for (int radius = 0; radius <= searchRadius; radius++) {
            for (int rx = -radius; rx <= radius; rx++) {
                for (int rz = -radius; rz <= radius; rz++) {
                    int regionX = playerRegionX + rx;
                    int regionZ = playerRegionZ + rz;

                    Random regionRand = new Random(world.getSeed() + (long) (regionX * 341873128712L) + (long) (regionZ * 132897987541L));

                    if (regionRand.nextInt(3) != 1) {
                        if (DEBUG) System.out.println("skip: regionRand probability failed for region " + regionX + "," + regionZ);
                        continue;
                    }

                    int baseX = regionX * spacing + regionRand.nextInt(spacing);
                    int baseZ = regionZ * spacing + regionRand.nextInt(spacing);

                    if (Math.abs(baseX) < 5000 || Math.abs(baseZ) < 5000) {
                        if (DEBUG) System.out.println("skip: within 5000 for base " + baseX + "," + baseZ);
                        continue;
                    }

                    int chunkCornerX = (baseX >> 4) << 4;
                    int chunkCornerZ = (baseZ >> 4) << 4;

                    BiomeGenBase biome = world.getBiomeGenForCoords(chunkCornerX, chunkCornerZ);
                    BiomeGenBase biomePosX = world.getBiomeGenForCoords(chunkCornerX + 160, chunkCornerZ);
                    BiomeGenBase biomeNegX = world.getBiomeGenForCoords(chunkCornerX - 160, chunkCornerZ);
                    BiomeGenBase biomePosZ = world.getBiomeGenForCoords(chunkCornerX, chunkCornerZ + 150);
                    BiomeGenBase biomeNegZ = world.getBiomeGenForCoords(chunkCornerX, chunkCornerZ - 150);
                    BiomeGenBase biomePosXPosZ = world.getBiomeGenForCoords(chunkCornerX + 160, chunkCornerZ + 150);
                    BiomeGenBase biomeNegXNegZ = world.getBiomeGenForCoords(chunkCornerX - 160, chunkCornerZ - 150);
                    BiomeGenBase biomePosXNegZ = world.getBiomeGenForCoords(chunkCornerX + 160, chunkCornerZ - 150);
                    BiomeGenBase biomeNegXPosZ = world.getBiomeGenForCoords(chunkCornerX - 160, chunkCornerZ + 150);

                    Type[] biomeList = BiomeDictionary.getTypesForBiome(biome);
                    Type[] biomeListPosX = BiomeDictionary.getTypesForBiome(biomePosX);
                    Type[] biomeListNegX = BiomeDictionary.getTypesForBiome(biomeNegX);
                    Type[] biomeListPosZ = BiomeDictionary.getTypesForBiome(biomePosZ);
                    Type[] biomeListNegZ = BiomeDictionary.getTypesForBiome(biomeNegZ);
                    Type[] biomeListPosXPosZ = BiomeDictionary.getTypesForBiome(biomePosXPosZ);
                    Type[] biomeListNegXNegZ = BiomeDictionary.getTypesForBiome(biomeNegXNegZ);
                    Type[] biomeListPosXNegZ = BiomeDictionary.getTypesForBiome(biomePosXNegZ);
                    Type[] biomeListNegXPosZ = BiomeDictionary.getTypesForBiome(biomeNegXPosZ);

                    boolean bad = ArrayUtils.contains(biomeList, Type.OCEAN) || ArrayUtils.contains(biomeList, Type.BEACH) ||
                            ArrayUtils.contains(biomeList, Type.SWAMP) || ArrayUtils.contains(biomeListPosX, Type.OCEAN) ||
                            ArrayUtils.contains(biomeListPosX, Type.BEACH) || ArrayUtils.contains(biomeListPosX, Type.SWAMP) ||
                            ArrayUtils.contains(biomeListNegX, Type.OCEAN) || ArrayUtils.contains(biomeListNegX, Type.BEACH) ||
                            ArrayUtils.contains(biomeListNegX, Type.SWAMP) || ArrayUtils.contains(biomeListPosZ, Type.OCEAN) ||
                            ArrayUtils.contains(biomeListPosZ, Type.BEACH) || ArrayUtils.contains(biomeListPosZ, Type.SWAMP) ||
                            ArrayUtils.contains(biomeListNegZ, Type.OCEAN) || ArrayUtils.contains(biomeListNegZ, Type.BEACH) ||
                            ArrayUtils.contains(biomeListNegZ, Type.SWAMP) || ArrayUtils.contains(biomeListPosXPosZ, Type.OCEAN) ||
                            ArrayUtils.contains(biomeListPosXPosZ, Type.BEACH) || ArrayUtils.contains(biomeListPosXPosZ, Type.SWAMP) ||
                            ArrayUtils.contains(biomeListNegXNegZ, Type.OCEAN) || ArrayUtils.contains(biomeListNegXNegZ, Type.BEACH) ||
                            ArrayUtils.contains(biomeListNegXNegZ, Type.SWAMP)|| ArrayUtils.contains(biomeListPosXNegZ, Type.OCEAN) ||
                            ArrayUtils.contains(biomeListPosXNegZ, Type.BEACH) || ArrayUtils.contains(biomeListPosXNegZ, Type.SWAMP) ||
                            ArrayUtils.contains(biomeListNegXPosZ, Type.OCEAN) || ArrayUtils.contains(biomeListNegXPosZ, Type.BEACH) ||
                            ArrayUtils.contains(biomeListNegXPosZ, Type.SWAMP);

                    if (bad) {
                        if (DEBUG) System.out.println("skip: bad biome for chunkCorner " + chunkCornerX + "," + chunkCornerZ);
                        continue;
                    }

                    int x1 = baseX + regionRand.nextInt(8) + 8;
                    int z1 = baseZ + regionRand.nextInt(8) + 8;

                    int x2 = x1 + 36;
                    int y2 = 18;
                    int z2 = z1 + 36;

                    if (DEBUG) {
                        System.out.println("accepted region=" + regionX + "," + regionZ + " base=" + baseX + "," + baseZ + " chunkCorner=" + chunkCornerX + "," + chunkCornerZ + " final=" + x2 + "," + y2 + "," + z2);
                    }

                    return new ChunkCoordinates(x2, y2, z2);
                }
            }
        }

        return null;
    }
}
