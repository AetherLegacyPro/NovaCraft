package com.NovaCraft.world.end;

import net.minecraft.world.gen.feature.*;
import net.minecraft.block.*;
import net.minecraft.world.*;
import java.util.*;
import com.NovaCraftBlocks.NovaCraftBlocks;
import net.minecraft.init.*;
import net.minecraft.tileentity.TileEntityMobSpawner;

public class DestitudeIslandSpecialBlock2 extends WorldGenAbstractTree {

    public DestitudeIslandSpecialBlock2(final Block leafID, final int heightWeight, final boolean branchFlag) {
        super(true);
    }

    public boolean generate(final World world, final Random random, final int i, final int j, final int k) {
        world.setBlock(i + 3, j, k, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 4, j, k, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 5, j, k, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 2, j, k + 1, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 3, j, k + 1, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 4, j, k + 1, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i, j, k + 2, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 1, j, k + 2, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 2, j, k + 2, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 3, j, k + 2, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 4, j, k + 2, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 5, j, k + 2, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i, j, k + 3, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 1, j, k + 3, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 2, j, k + 3, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 3, j, k + 3, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 4, j, k + 3, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 5, j, k + 3, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 6, j, k + 3, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 1, j, k + 4, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 2, j, k + 4, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 3, j, k + 4, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 4, j, k + 4, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 5, j, k + 4, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 2, j, k + 5, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 3, j, k + 5, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 4, j, k + 5, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 3, j + 1, k + 2, NovaCraftBlocks.destitude_block, 0, 2);
        world.setBlock(i + 2, j + 1, k + 3, NovaCraftBlocks.destitude_block, 0, 2);
        world.setBlock(i + 4, j + 1, k + 3, NovaCraftBlocks.destitude_block, 0, 2);
        world.setBlock(i + 3, j + 1, k + 4, NovaCraftBlocks.destitude_block, 0, 2);
        world.setBlock(i + 3, j + 2, k + 3, NovaCraftBlocks.destitude_block, 0, 2);

        int chance_special = (int)(1 + Math.random() * 2);
        if (chance_special == 0) {
            world.setBlock(i + 3, j + 1, k + 3, NovaCraftBlocks.crystallized_end, 0, 2);
        } else {
            world.setBlock(i + 3, j + 1, k + 3, NovaCraftBlocks.infused_vanite_block_natural, 0, 2);
        }
        return true;
    }
}

