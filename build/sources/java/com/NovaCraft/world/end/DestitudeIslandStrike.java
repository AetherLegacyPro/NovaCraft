package com.NovaCraft.world.end;

import com.NovaCraftBlocks.NovaCraftBlocks;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import java.util.Random;

public class DestitudeIslandStrike extends WorldGenAbstractTree {

    public DestitudeIslandStrike(final Block leafID, final int heightWeight, final boolean branchFlag) {
        super(true);
    }

    public boolean generate(final World world, final Random random, final int i, final int j, final int k) {
        world.setBlock(i + 2, j, k, NovaCraftBlocks.destitude_block, 0, 2);
        world.setBlock(i + 2, j, k + 1, NovaCraftBlocks.destitude_block, 0, 2);
        world.setBlock(i, j, k + 2, NovaCraftBlocks.destitude_block, 0, 2);
        world.setBlock(i + 1, j, k + 2, NovaCraftBlocks.destitude_block, 0, 2);
        world.setBlock(i + 2, j, k + 2, NovaCraftBlocks.destitude_block, 0, 2);
        world.setBlock(i + 3, j, k + 2, NovaCraftBlocks.destitude_block, 0, 2);
        world.setBlock(i + 4, j, k + 2, NovaCraftBlocks.destitude_block, 0, 2);
        world.setBlock(i + 2, j, k + 3, NovaCraftBlocks.destitude_block, 0, 2);
        world.setBlock(i + 2, j, k + 4, NovaCraftBlocks.destitude_block, 0, 2);
        world.setBlock(i + 2, j + 1, k + 1, NovaCraftBlocks.destitude_block, 0, 2);
        world.setBlock(i + 1, j + 1, k + 2, NovaCraftBlocks.destitude_block, 0, 2);
        world.setBlock(i + 2, j + 1, k + 2, NovaCraftBlocks.destitude_block, 0, 2);
        world.setBlock(i + 3, j + 1, k + 2, NovaCraftBlocks.destitude_block, 0, 2);
        world.setBlock(i + 2, j + 1, k + 3, NovaCraftBlocks.destitude_block, 0, 2);
        world.setBlock(i + 2, j + 2, k + 1, NovaCraftBlocks.destitude_block, 0, 2);
        world.setBlock(i + 1, j + 2, k + 2, NovaCraftBlocks.destitude_block, 0, 2);
        world.setBlock(i + 2, j + 2, k + 2, NovaCraftBlocks.destitude_block, 0, 2);
        world.setBlock(i + 3, j + 2, k + 2, NovaCraftBlocks.destitude_block, 0, 2);
        world.setBlock(i + 2, j + 2, k + 3, NovaCraftBlocks.destitude_block, 0, 2);
        world.setBlock(i + 2, j + 3, k + 2, NovaCraftBlocks.destitude_block, 0, 2);
        world.setBlock(i + 2, j + 4, k + 2, NovaCraftBlocks.destitude_block, 0, 2);
        world.setBlock(i + 2, j + 5, k + 2, NovaCraftBlocks.destitude_block, 0, 2);
        world.setBlock(i + 2, j + 6, k + 2, NovaCraftBlocks.destitude_block, 0, 2);
        world.setBlock(i + 2, j + 7, k + 2, NovaCraftBlocks.destitude_block, 0, 2);
        world.setBlock(i + 2, j + 8, k + 2, NovaCraftBlocks.nullified_frontierslate, 0, 2);

        return true;
    }
}
