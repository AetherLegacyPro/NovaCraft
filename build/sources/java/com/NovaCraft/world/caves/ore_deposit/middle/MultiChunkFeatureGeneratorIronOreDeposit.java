package com.NovaCraft.world.caves.ore_deposit.middle;

import java.util.Random;
import java.util.function.Consumer;
import com.NovaCraft.world.caves.BlockPos;
import net.minecraft.world.World;

public abstract class MultiChunkFeatureGeneratorIronOreDeposit {

    public void generate(int chunkX, int chunkZ, World world) {
        if (!canGenerate(world)) return;

        int radius = getFeatureRadius();
        int chunkRadius = (int) Math.ceil(radius / 16.0);

        long worldSeed = modifyWorldSeed(world.getSeed());
        Random worldRandom = new Random(worldSeed);
        long xSeed = worldRandom.nextLong() >> 2 + 1;
        long zSeed = worldRandom.nextLong() >> 2 + 1;

        long ourChunkSeed = (xSeed * chunkX + zSeed * chunkZ) ^ worldSeed;

        for (int x = chunkX - chunkRadius; x <= chunkX + chunkRadius; x++)
            for (int z = chunkZ - chunkRadius; z <= chunkZ + chunkRadius; z++) {
                long chunkSeed = (xSeed * x + zSeed * z) ^ worldSeed;
                Random chunkRandom = new Random(chunkSeed);

                BlockPos[] sources = getSourcesInChunk(chunkRandom, x, z);
                for (BlockPos source : sources) if (source != null && isSourceValid(world, source))
                    generateChunkPart(source, chunkRandom, chunkX, chunkZ, world);
            }
    }

    public long modifyWorldSeed(long seed) {
        return seed;
    }

    public boolean isSourceValid(World world, BlockPos pos) {
        return true;
    }

    public boolean canGenerate(World world) {
        return world.provider.dimensionId == 0;
    }

    public boolean shouldOffset() {
        return true;
    }

    public abstract int getFeatureRadius();

    public abstract void generateChunkPart(BlockPos src, Random random, int chunkX, int chunkZ, World world);

    public abstract BlockPos[] getSourcesInChunk(Random random, int chunkX, int chunkZ);

    public void forEachChunkBlock(int chunkX, int chunkZ, int minY, int maxY, Consumer<BlockPos> func) {
        BlockPos first = new BlockPos(chunkX * 16, 0, chunkZ * 16);
        minY = Math.max(1, minY);
        maxY = Math.min(255, maxY);

        if (shouldOffset()) first = first.add(8, 0, 8);

        for (int x = 0; x < 16; x++)
            for (int y = minY; y < maxY; y++) for (int z = 0; z < 16; z++) func.accept(first.add(x, y, z));
    }

}
