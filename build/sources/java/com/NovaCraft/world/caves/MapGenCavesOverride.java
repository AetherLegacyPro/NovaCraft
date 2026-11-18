package com.NovaCraft.world.caves;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.MapGenCaves;
import java.util.Random;

public class MapGenCavesOverride extends MapGenCaves {
    public MapGenCavesOverride() {
        this.range = 12; //Makes the tunnels 50% larger on average
    }

    private int getExtendedCaveLength(long seed) {
        Random lengthRandom = new Random(seed);
        int originalMaximumLength = 8 * 16 - 16;
        int originalLength = originalMaximumLength - lengthRandom.nextInt(originalMaximumLength / 4);
        return Math.round(originalLength * 2.0F);
    }

    @Override
    protected void func_151542_a(long seed, int targetChunkX, int targetChunkZ, Block[] blocks, double x, double y, double z) {
        float roomSize = (1.0F + this.rand.nextFloat() * 6.0F) * 2.0F;
        this.func_151541_a(seed, targetChunkX, targetChunkZ, blocks, x, y, z, roomSize, 0.0F, 0.0F, -1, this.getExtendedCaveLength(seed), 0.5D);
    }

    //Original release 1.6.4-style cave frequency.
    @Override
    protected void func_151538_a(World world, int chunkX, int chunkZ, int targetChunkX, int targetChunkZ, Block[] blocks) {
        int caveCount = this.rand.nextInt(this.rand.nextInt(this.rand.nextInt(16) + 1) + 1);
        if (this.rand.nextInt(5) != 0) {
            caveCount = 0;
        }

        if (caveCount > 0) {
            int additionalCaves = caveCount / 2;
            if (caveCount % 2 != 0 && this.rand.nextBoolean()) {
                ++additionalCaves;
            }

            caveCount += additionalCaves;
        }

        for (int cave = 0; cave < caveCount; ++cave) {
            double x = chunkX * 16 + this.rand.nextInt(16);
            double y = this.rand.nextInt(this.rand.nextInt(123) + 5);
            double z = chunkZ * 16 + this.rand.nextInt(16);

            int tunnelCount = 1;
            if (this.rand.nextInt(4) == 0) {
                this.func_151542_a(this.rand.nextLong(), targetChunkX, targetChunkZ, blocks, x, y, z);
                tunnelCount += this.rand.nextInt(4);
            }

            for (int tunnel = 0; tunnel < tunnelCount; ++tunnel) {
                float yaw = this.rand.nextFloat() * (float)Math.PI * 2.0F;
                float pitch = (this.rand.nextFloat() - 0.5F) * 2.0F / 8.0F;
                float tunnelSize = this.rand.nextFloat() * 2.0F + this.rand.nextFloat();

                if (this.rand.nextInt(10) == 0) {
                    tunnelSize *= this.rand.nextFloat() * this.rand.nextFloat() * 3.0F + 1.0F;
                }

                tunnelSize *= 2.0F;
                long tunnelSeed = this.rand.nextLong();
                this.func_151541_a(tunnelSeed, targetChunkX, targetChunkZ, blocks, x, y, z, tunnelSize, yaw, pitch, 0, this.getExtendedCaveLength(tunnelSeed), 1.0D);
            }
        }

        if (this.rand.nextInt(40) == 0) {
            this.generateVerticalShaft(this.rand.nextLong(), chunkX, chunkZ, targetChunkX, targetChunkZ, blocks);
        }
    }

    private void generateVerticalShaft(long seed, int sourceChunkX, int sourceChunkZ, int targetChunkX, int targetChunkZ, Block[] blocks) {
        Random shaftRandom = new Random(seed);
        double x = sourceChunkX * 16 + shaftRandom.nextInt(16);
        double z = sourceChunkZ * 16 + shaftRandom.nextInt(16);

        int startY = 196;
        int bottomY = 12 + shaftRandom.nextInt(5);
        float shaftSize = 32.0F + shaftRandom.nextFloat() * 24.0F;
        double driftYaw = shaftRandom.nextDouble() * Math.PI * 2.0D;
        int step = 0;

        for (int y = startY; y >= bottomY; y -= 2) {
            driftYaw += (shaftRandom.nextDouble() - 0.5D) * 0.35D;

            x += Math.cos(driftYaw) * 0.25D;
            z += Math.sin(driftYaw) * 0.25D;

            this.carveShaftSection(shaftRandom.nextLong(), targetChunkX, targetChunkZ, blocks, x, bottomY, z, 32.0F + shaftRandom.nextFloat() * 24.0F);

            if (y <= 70 && step > 0 && step % 6 == 0 && shaftRandom.nextBoolean()) {
                float yaw = shaftRandom.nextFloat() * (float)Math.PI * 2.0F;
                float pitch = (shaftRandom.nextFloat() - 0.5F) * 0.2F;
                int length = 25 + shaftRandom.nextInt(26);

                this.func_151541_a(shaftRandom.nextLong(), targetChunkX, targetChunkZ, blocks, x, y, z, 1.5F + shaftRandom.nextFloat() * 1.5F, yaw, pitch, 0, length, 1.0D);
            }

            ++step;
        }

        this.carveShaftSection(shaftRandom.nextLong(), targetChunkX, targetChunkZ, blocks, x, bottomY, z, shaftSize);
        this.carveShaftSection(shaftRandom.nextLong(), targetChunkX, targetChunkZ, blocks, x, bottomY, z, 4.0F + shaftRandom.nextFloat() * 2.0F);

        int branchCount = 4 + shaftRandom.nextInt(4);
        float startingYaw = shaftRandom.nextFloat() * (float)Math.PI * 2.0F;

        for (int branch = 0; branch < branchCount; ++branch) {
            float yaw = startingYaw + branch * ((float)Math.PI * 2.0F / branchCount) + (shaftRandom.nextFloat() - 0.5F) * 0.35F;
            float pitch = shaftRandom.nextFloat() * 0.12F;
            int length = 45 + shaftRandom.nextInt(36);

            this.func_151541_a(shaftRandom.nextLong(), targetChunkX, targetChunkZ, blocks, x, bottomY, z, 2.0F + shaftRandom.nextFloat() * 2.0F, yaw, pitch, 0, length, 1.0D);
        }
    }

    /**
     * Uses vanilla's single-chamber carving mode.
     * Closely spaced chambers overlap into a continuous vertical shaft.
     */
    private void carveShaftSection(long seed, int targetChunkX, int targetChunkZ, Block[] blocks, double x, double y, double z, float size) {
        this.func_151541_a(seed, targetChunkX, targetChunkZ, blocks, x, y, z, size, 0.0F, 0.0F, -1, 1, 1.0D);
    }
}