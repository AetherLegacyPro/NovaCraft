package com.NovaCraft.world.end;

import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;

public final class DestituteIslandFinder {

    private DestituteIslandFinder() {
    }

    public static ChunkCoordinates getNearestDestitudeIsland(World world, int playerX, int playerZ) {
        if (world.isRemote || world.provider.dimensionId != 1) {
            return null;
        }

        int playerChunkX = playerX >> 4;
        int playerChunkZ = playerZ >> 4;

        ChunkCoordinates closest = null;
        double closestDistanceSq = Double.MAX_VALUE;

        for (int radius = 0; radius <= 128; ++radius) {
            for (int offsetX = -radius; offsetX <= radius; ++offsetX) {
                for (int offsetZ = -radius; offsetZ <= radius; ++offsetZ) {
                    if (Math.abs(offsetX) != radius && Math.abs(offsetZ) != radius) {
                        continue;
                    }

                    ChunkCoordinates candidate = DestituteIslandPlacement.getIslandPosition(world, playerChunkX + offsetX, playerChunkZ + offsetZ);
                    if (candidate == null) {
                        continue;
                    }

                    double differenceX = (double)candidate.posX - playerX;
                    double differenceZ = (double)candidate.posZ - playerZ;
                    double distanceSq = differenceX * differenceX + differenceZ * differenceZ;
                    if (distanceSq < closestDistanceSq) {
                        closestDistanceSq = distanceSq;
                        closest = candidate;
                    }
                }
            }
        }

        return closest;
    }
}
