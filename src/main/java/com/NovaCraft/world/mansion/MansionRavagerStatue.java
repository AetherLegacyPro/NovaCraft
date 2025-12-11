package com.NovaCraft.world.mansion;

import com.NovaCraftBlocks.NovaCraftBlocks;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class MansionRavagerStatue extends WorldGenerator
{
    public MansionRavagerStatue() {

    }

    @Override
    public boolean generate(final World world, final Random random, final int i, final int j, final int k) {

        world.setBlock(i, j, k + 3, Blocks.stonebrick, 0, 2);
        world.setBlock(i + 1, j, k + 3, Blocks.stonebrick, 0, 2);
        world.setBlock(i + 5, j, k + 3, Blocks.stonebrick, 0, 2);
        world.setBlock(i + 6, j, k + 3, Blocks.stonebrick, 0, 2);
        world.setBlock(i, j, k + 4, Blocks.stonebrick, 0, 2);
        world.setBlock(i + 1, j, k + 4, Blocks.stonebrick, 0, 2);
        world.setBlock(i + 5, j, k + 4, Blocks.stonebrick, 0, 2);
        world.setBlock(i + 6, j, k + 4, Blocks.stonebrick, 0, 2);
        world.setBlock(i, j, k + 8, Blocks.stonebrick, 0, 2);
        world.setBlock(i + 1, j, k + 8, Blocks.stonebrick, 0, 2);
        world.setBlock(i + 5, j, k + 8, Blocks.stonebrick, 0, 2);
        world.setBlock(i + 6, j, k + 8, Blocks.stonebrick, 0, 2);
        world.setBlock(i, j, k + 9, Blocks.stonebrick, 0, 2);
        world.setBlock(i + 1, j, k + 9, Blocks.stonebrick, 0, 2);
        world.setBlock(i + 5, j, k + 9, Blocks.stonebrick, 0, 2);
        world.setBlock(i + 6, j, k + 9, Blocks.stonebrick, 0, 2);
        world.setBlock(i, j + 1, k + 3, Blocks.stonebrick, 0, 2);
        world.setBlock(i + 1, j + 1, k + 3, Blocks.stonebrick, 0, 2);
        world.setBlock(i + 5, j + 1, k + 3, Blocks.stonebrick, 0, 2);
        world.setBlock(i + 6, j + 1, k + 3, Blocks.stonebrick, 0, 2);
        world.setBlock(i, j + 1, k + 4, Blocks.stonebrick, 0, 2);
        world.setBlock(i + 1, j + 1, k + 4, Blocks.stonebrick, 0, 2);
        world.setBlock(i + 2, j + 1, k + 4, NovaCraftBlocks.nullstone_bricks, 0, 2);
        world.setBlock(i + 3, j + 1, k + 4, NovaCraftBlocks.nullstone_bricks, 0, 2);
        world.setBlock(i + 4, j + 1, k + 4, NovaCraftBlocks.nullstone_bricks, 0, 2);
        world.setBlock(i + 5, j + 1, k + 4, Blocks.stonebrick, 0, 2);
        world.setBlock(i + 6, j + 1, k + 4, Blocks.stonebrick, 0, 2);
        world.setBlock(i + 1, j + 1, k + 5, Blocks.stonebrick, 0, 2);
        world.setBlock(i + 5, j + 1, k + 5, Blocks.stonebrick, 0, 2);
        world.setBlock(i + 1, j + 1, k + 7, Blocks.stonebrick, 0, 2);
        world.setBlock(i + 5, j + 1, k + 7, Blocks.stonebrick, 0, 2);
        world.setBlock(i, j + 1, k + 8, Blocks.stonebrick, 0, 2);
        world.setBlock(i + 1, j + 1, k + 8, Blocks.stonebrick, 0, 2);
        world.setBlock(i + 5, j + 1, k + 8, Blocks.stonebrick, 0, 2);
        world.setBlock(i + 6, j + 1, k + 8, Blocks.stonebrick, 0, 2);
        world.setBlock(i, j + 1, k + 9, Blocks.stonebrick, 0, 2);
        world.setBlock(i + 1, j + 1, k + 9, Blocks.stonebrick, 0, 2);
        world.setBlock(i + 5, j + 1, k + 9, Blocks.stonebrick, 0, 2);
        world.setBlock(i + 6, j + 1, k + 9, Blocks.stonebrick, 0, 2);
        world.setBlock(i + 3, j + 2, k + 1, NovaCraftBlocks.nullstone_bricks, 0, 2);
        world.setBlock(i, j + 2, k + 3, Blocks.stonebrick, 0, 2);
        world.setBlock(i + 1, j + 2, k + 3, Blocks.stonebrick, 0, 2);
        world.setBlock(i + 2, j + 2, k + 3, NovaCraftBlocks.nullstone_bricks, 0, 2);
        world.setBlock(i + 3, j + 2, k + 3, NovaCraftBlocks.nullstone_bricks, 0, 2);
        world.setBlock(i + 4, j + 2, k + 3, NovaCraftBlocks.nullstone_bricks, 0, 2);
        world.setBlock(i + 5, j + 2, k + 3, Blocks.stonebrick, 0, 2);
        world.setBlock(i + 6, j + 2, k + 3, Blocks.stonebrick, 0, 2);
        world.setBlock(i, j + 2, k + 4, Blocks.stonebrick, 0, 2);
        world.setBlock(i + 1, j + 2, k + 4, Blocks.stonebrick, 0, 2);
        world.setBlock(i + 2, j + 2, k + 4, NovaCraftBlocks.nullstone_bricks, 0, 2);
        world.setBlock(i + 3, j + 2, k + 4, NovaCraftBlocks.nullstone_bricks, 0, 2);
        world.setBlock(i + 4, j + 2, k + 4, NovaCraftBlocks.nullstone_bricks, 0, 2);
        world.setBlock(i + 5, j + 2, k + 4, Blocks.stonebrick, 0, 2);
        world.setBlock(i + 6, j + 2, k + 4, Blocks.stonebrick, 0, 2);
        world.setBlock(i + 1, j + 2, k + 5, Blocks.stonebrick, 0, 2);
        world.setBlock(i + 5, j + 2, k + 5, Blocks.stonebrick, 0, 2);
        world.setBlock(i + 1, j + 2, k + 7, Blocks.stonebrick, 0, 2);
        world.setBlock(i + 5, j + 2, k + 7, Blocks.stonebrick, 0, 2);
        world.setBlock(i, j + 2, k + 8, Blocks.stonebrick, 0, 2);
        world.setBlock(i + 1, j + 2, k + 8, Blocks.stonebrick, 0, 2);
        world.setBlock(i + 5, j + 2, k + 8, Blocks.stonebrick, 0, 2);
        world.setBlock(i + 6, j + 2, k + 8, Blocks.stonebrick, 0, 2);
        world.setBlock(i, j + 2, k + 9, Blocks.stonebrick, 0, 2);
        world.setBlock(i + 1, j + 2, k + 9, Blocks.stonebrick, 0, 2);
        world.setBlock(i + 5, j + 2, k + 9, Blocks.stonebrick, 0, 2);
        world.setBlock(i + 6, j + 2, k + 9, Blocks.stonebrick, 0, 2);
        world.setBlock(i + 3, j + 3, k + 1, NovaCraftBlocks.nullstone_bricks, 0, 2);
        world.setBlock(i + 2, j + 3, k + 2, NovaCraftBlocks.nullstone_bricks, 0, 2);
        world.setBlock(i + 3, j + 3, k + 2, NovaCraftBlocks.nullstone_bricks, 0, 2);
        world.setBlock(i + 4, j + 3, k + 2, NovaCraftBlocks.nullstone_bricks, 0, 2);
        world.setBlock(i, j + 3, k + 3, NovaCraftBlocks.grimstone_bricks, 0, 2);
        world.setBlock(i + 1, j + 3, k + 3, NovaCraftBlocks.grimstone_bricks, 0, 2);
        world.setBlock(i + 2, j + 3, k + 3, NovaCraftBlocks.nullstone_bricks, 0, 2);
        world.setBlock(i + 3, j + 3, k + 3, NovaCraftBlocks.nullstone_bricks, 0, 2);
        world.setBlock(i + 4, j + 3, k + 3, NovaCraftBlocks.nullstone_bricks, 0, 2);
        world.setBlock(i + 5, j + 3, k + 3, NovaCraftBlocks.grimstone_bricks, 0, 2);
        world.setBlock(i + 6, j + 3, k + 3, NovaCraftBlocks.grimstone_bricks, 0, 2);
        world.setBlock(i, j + 3, k + 4, NovaCraftBlocks.grimstone_bricks, 0, 2);
        world.setBlock(i + 1, j + 3, k + 4, NovaCraftBlocks.grimstone_bricks, 0, 2);
        world.setBlock(i + 5, j + 3, k + 4, NovaCraftBlocks.grimstone_bricks, 0, 2);
        world.setBlock(i + 6, j + 3, k + 4, NovaCraftBlocks.grimstone_bricks, 0, 2);
        world.setBlock(i, j + 3, k + 8, NovaCraftBlocks.grimstone_bricks, 0, 2);
        world.setBlock(i + 1, j + 3, k + 8, NovaCraftBlocks.grimstone_bricks, 0, 2);
        world.setBlock(i + 5, j + 3, k + 8, NovaCraftBlocks.grimstone_bricks, 0, 2);
        world.setBlock(i + 6, j + 3, k + 8, NovaCraftBlocks.grimstone_bricks, 0, 2);
        world.setBlock(i, j + 3, k + 9, NovaCraftBlocks.grimstone_bricks, 0, 2);
        world.setBlock(i + 1, j + 3, k + 9, NovaCraftBlocks.grimstone_bricks, 0, 2);
        world.setBlock(i + 5, j + 3, k + 9, NovaCraftBlocks.grimstone_bricks, 0, 2);
        world.setBlock(i + 6, j + 3, k + 9, NovaCraftBlocks.grimstone_bricks, 0, 2);
        world.setBlock(i + 2, j + 4, k + 2, NovaCraftBlocks.nullstone_bricks, 0, 2);
        world.setBlock(i + 4, j + 4, k + 2, NovaCraftBlocks.nullstone_bricks, 0, 2);
        world.setBlock(i + 1, j + 5, k + 2, Blocks.iron_block, 0, 2);
        world.setBlock(i + 2, j + 5, k + 2, NovaCraftBlocks.nullstone_bricks, 0, 2);
        world.setBlock(i + 3, j + 5, k + 2, NovaCraftBlocks.vanite_pumpkin, 2, 2);
        world.setBlock(i + 4, j + 5, k + 2, NovaCraftBlocks.nullstone_bricks, 0, 2);
        world.setBlock(i + 5, j + 5, k + 2, Blocks.iron_block, 0, 2);
        world.setBlock(i + 1, j + 6, k, Blocks.iron_block, 0, 2);
        world.setBlock(i + 5, j + 6, k, Blocks.iron_block, 0, 2);
        world.setBlock(i + 1, j + 6, k + 1, Blocks.iron_block, 0, 2);
        world.setBlock(i + 5, j + 6, k + 1, Blocks.iron_block, 0, 2);

        int vanite_chance = 1 + random.nextInt(8);
        if (vanite_chance < 3) {
            world.setBlock(i + 3, j + 1, k + 6, NovaCraftBlocks.block_of_vanite, 0, 2);
            world.setBlock(i + 3, j + 4, k + 2, NovaCraftBlocks.block_of_vanite, 0, 2);
        } else if (vanite_chance <= 5) {
            world.setBlock(i + 3, j + 1, k + 6, NovaCraftBlocks.block_of_vanite, 0, 2);
            world.setBlock(i + 3, j + 2, k + 6, NovaCraftBlocks.block_of_vanite, 0, 2);
        } else {
            world.setBlock(i + 3, j + 4, k + 2, NovaCraftBlocks.block_of_vanite, 0, 2);
        }

        world.setBlock(i + 2, j + 1, k + 5, placeGoldBlock(random), 0, 2);
        world.setBlock(i + 3, j + 1, k + 5, placeGoldBlock(random), 0, 2);
        world.setBlock(i + 4, j + 1, k + 5, placeGoldBlock(random), 0, 2);
        world.setBlock(i + 2, j + 1, k + 6, placeGoldBlock(random), 0, 2);
        world.setBlock(i + 4, j + 1, k + 6, placeGoldBlock(random), 0, 2);
        world.setBlock(i + 2, j + 1, k + 7, placeGoldBlock(random), 0, 2);
        world.setBlock(i + 3, j + 1, k + 7, placeGoldBlock(random), 0, 2);
        world.setBlock(i + 4, j + 1, k + 7, placeGoldBlock(random), 0, 2);
        world.setBlock(i + 2, j + 2, k + 5, placeGoldBlock(random), 0, 2);
        world.setBlock(i + 3, j + 2, k + 5, placeGoldBlock(random), 0, 2);
        world.setBlock(i + 4, j + 2, k + 5, placeGoldBlock(random), 0, 2);
        world.setBlock(i + 2, j + 2, k + 6, placeGoldBlock(random), 0, 2);
        world.setBlock(i + 4, j + 2, k + 6, placeGoldBlock(random), 0, 2);
        world.setBlock(i + 2, j + 2, k + 7, placeGoldBlock(random), 0, 2);
        world.setBlock(i + 3, j + 2, k + 7, placeGoldBlock(random), 0, 2);
        world.setBlock(i + 4, j + 2, k + 7, placeGoldBlock(random), 0, 2);
        
        return true;
    }

    private Block placeGoldBlock(Random random) {
        if (random.nextDouble() < 0.20) {
            return Blocks.gold_block;
        } else {
            return Blocks.air;
        }
    }
}
