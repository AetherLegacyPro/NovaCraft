package com.NovaCraft.world.mansion;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class MansionBasementAirGen extends WorldGenerator
{
    public MansionBasementAirGen() {

    }

    @Override
    public boolean generate(final World world, final Random random, final int x, final int y, final int z) {
        int sizeX = 55; //64
        int sizeY = 9; //32
        int sizeZ = 56; //82
        for (int dx = 0; dx < sizeX; dx++) {
            for (int dy = 0; dy < sizeY; dy++) {
                for (int dz = 0; dz < sizeZ; dz++) {
                    world.setBlock(x + dx, y + dy, z + dz, Blocks.air);
                }
            }
        }
        return true;
    }

}
