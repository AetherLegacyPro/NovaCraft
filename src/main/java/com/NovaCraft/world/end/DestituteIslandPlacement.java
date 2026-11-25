package com.NovaCraft.world.end;

import java.util.Random;
import com.NovaCraft.config.ConfigsStructures;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

public final class DestituteIslandPlacement {

    private DestituteIslandPlacement() {
    }

    public static ChunkCoordinates getIslandPosition(World world, int chunkX, int chunkZ) {
        if (world.provider.dimensionId != 1) {
            return null;
        }

        int spawnRate = ConfigsStructures.destituteIslandSpawnRate;
        if (spawnRate <= 17) {
            return null;
        }

        int originX = chunkX * 16;
        int originZ = chunkZ * 16;
        if (Math.abs((long)originX) < 1000L || Math.abs((long)originZ) < 1000L) {
            return null;
        }

        BiomeGenBase biome = world.getWorldChunkManager().getBiomeGenAt(originX + 16, originZ + 16);
        if (biome != BiomeGenBase.sky && !BiomeDictionary.isBiomeOfType(biome, Type.END)) {
            return null;
        }

        long seed = world.getSeed() ^ ((long)chunkX * 341873128712L) ^ ((long)chunkZ * 132897987541L) ^ 734287391L;
        Random random = new Random(seed);
        if (random.nextInt(spawnRate) != 17 || random.nextInt(35) != 0) {
            return null;
        }

        int x = originX + random.nextInt(16) + 8;
        int y = random.nextInt(10) + 20;
        int z = originZ + random.nextInt(16) + 8;

        return new ChunkCoordinates(x, y, z);
    }
}
