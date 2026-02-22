package com.NovaCraft.world.floating_island;

import com.NovaCraftBlocks.NovaCraftBlocks;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import java.util.Random;

public class FloatingIslandIridiumFurnace extends WorldGenAbstractTree {

    public FloatingIslandIridiumFurnace(final Block block, final int height, final boolean branch) {
        super(true);
    }

    public boolean generate(final World world, final Random random, final int i, final int j, final int k) {
        
        world.setBlock(i, j, k, Blocks.air, 0, 2);
        world.setBlock(i + 1, j, k, Blocks.air, 0, 2);
        world.setBlock(i + 2, j, k, placeIridiumBricks(random), 0, 2);
        world.setBlock(i + 3, j, k, placeIridiumBricks(random), 0, 2);
        world.setBlock(i + 4, j, k, placeIridiumBricks(random), 0, 2);
        world.setBlock(i + 5, j, k, Blocks.air, 0, 2);
        world.setBlock(i + 6, j, k, Blocks.air, 0, 2);
        world.setBlock(i, j, k + 1, Blocks.air, 0, 2);
        world.setBlock(i + 1, j, k + 1, placeIridiumBricks(random), 0, 2);
        world.setBlock(i + 2, j, k + 1, placeIridiumBricks(random), 0, 2);
        world.setBlock(i + 3, j, k + 1, NovaCraftBlocks.cracked_iridium_bricks, 0, 2);
        world.setBlock(i + 4, j, k + 1, NovaCraftBlocks.cracked_iridium_bricks, 0, 2);
        world.setBlock(i + 5, j, k + 1, placeIridiumBricks(random), 0, 2);
        world.setBlock(i + 6, j, k + 1, Blocks.air, 0, 2);
        world.setBlock(i, j, k + 2, placeIridiumBricks(random), 0, 2);
        world.setBlock(i + 1, j, k + 2, NovaCraftBlocks.cracked_iridium_bricks, 0, 2);
        world.setBlock(i + 2, j, k + 2, placeIridiumBricks(random), 0, 2);
        world.setBlock(i + 3, j, k + 2, NovaCraftBlocks.cracked_iridium_bricks, 0, 2);
        world.setBlock(i + 4, j, k + 2, placeIridiumBricks(random), 0, 2);
        world.setBlock(i + 5, j, k + 2, placeIridiumBricks(random), 0, 2);
        world.setBlock(i + 6, j, k + 2, placeIridiumBricks(random), 0, 2);
        world.setBlock(i, j, k + 3, placeIridiumBricks(random), 0, 2);
        world.setBlock(i + 1, j, k + 3, placeIridiumBricks(random), 0, 2);
        world.setBlock(i + 2, j, k + 3, NovaCraftBlocks.cracked_iridium_bricks, 0, 2);
        world.setBlock(i + 3, j, k + 3, placeIridiumBricks(random), 0, 2);
        world.setBlock(i + 4, j, k + 3, placeIridiumBricks(random), 0, 2);
        world.setBlock(i + 5, j, k + 3, NovaCraftBlocks.cracked_iridium_bricks, 0, 2);
        world.setBlock(i + 6, j, k + 3, placeIridiumBricks(random), 0, 2);
        world.setBlock(i, j, k + 4, placeIridiumBricks(random), 0, 2);
        world.setBlock(i + 1, j, k + 4, NovaCraftBlocks.cracked_iridium_bricks, 0, 2);
        world.setBlock(i + 2, j, k + 4, placeIridiumBricks(random), 0, 2);
        world.setBlock(i + 3, j, k + 4, placeIridiumBricks(random), 0, 2);
        world.setBlock(i + 4, j, k + 4, NovaCraftBlocks.cracked_iridium_bricks, 0, 2);
        world.setBlock(i + 5, j, k + 4, NovaCraftBlocks.cracked_iridium_bricks, 0, 2);
        world.setBlock(i + 6, j, k + 4, placeIridiumBricks(random), 0, 2);
        world.setBlock(i, j, k + 5, Blocks.air, 0, 2);
        world.setBlock(i + 1, j, k + 5, placeIridiumBricks(random), 0, 2);
        world.setBlock(i + 2, j, k + 5, placeIridiumBricks(random), 0, 2);
        world.setBlock(i + 3, j, k + 5, NovaCraftBlocks.cracked_iridium_bricks, 0, 2);
        world.setBlock(i + 4, j, k + 5, NovaCraftBlocks.cracked_iridium_bricks, 0, 2);
        world.setBlock(i + 5, j, k + 5, placeIridiumBricks(random), 0, 2);
        world.setBlock(i + 6, j, k + 5, Blocks.air, 0, 2);
        world.setBlock(i, j, k + 6, Blocks.air, 0, 2);
        world.setBlock(i + 1, j, k + 6, Blocks.air, 0, 2);
        world.setBlock(i + 2, j, k + 6, placeIridiumBricks(random), 0, 2);
        world.setBlock(i + 3, j, k + 6, placeIridiumBricks(random), 0, 2);
        world.setBlock(i + 4, j, k + 6, placeIridiumBricks(random), 0, 2);
        world.setBlock(i + 5, j, k + 6, Blocks.air, 0, 2);
        world.setBlock(i + 6, j, k + 6, Blocks.air, 0, 2);
        world.setBlock(i, j + 1, k, Blocks.air, 0, 2);
        world.setBlock(i + 1, j + 1, k, Blocks.air, 0, 2);
        world.setBlock(i + 2, j + 1, k, Blocks.air, 0, 2);
        world.setBlock(i + 3, j + 1, k, Blocks.air, 0, 2);
        world.setBlock(i + 4, j + 1, k, Blocks.air, 0, 2);
        world.setBlock(i + 5, j + 1, k, Blocks.air, 0, 2);
        world.setBlock(i + 6, j + 1, k, Blocks.air, 0, 2);
        world.setBlock(i, j + 1, k + 1, Blocks.air, 0, 2);
        world.setBlock(i + 1, j + 1, k + 1, Blocks.air, 0, 2);
        world.setBlock(i + 2, j + 1, k + 1, placeIridiumBricks(random), 0, 2);
        world.setBlock(i + 3, j + 1, k + 1, placeIridiumBricks(random), 0, 2);
        world.setBlock(i + 4, j + 1, k + 1, NovaCraftBlocks.cracked_iridium_bricks, 0, 2);
        world.setBlock(i + 5, j + 1, k + 1, Blocks.air, 0, 2);
        world.setBlock(i + 6, j + 1, k + 1, Blocks.air, 0, 2);
        world.setBlock(i, j + 1, k + 2, Blocks.air, 0, 2);
        world.setBlock(i + 1, j + 1, k + 2, placeIridiumBricks(random), 0, 2);
        world.setBlock(i + 2, j + 1, k + 2, Blocks.air, 0, 2);
        world.setBlock(i + 3, j + 1, k + 2, Blocks.air, 0, 2);
        world.setBlock(i + 4, j + 1, k + 2, Blocks.air, 0, 2);
        world.setBlock(i + 5, j + 1, k + 2, placeIridiumBricks(random), 0, 2);
        world.setBlock(i + 6, j + 1, k + 2, Blocks.air, 0, 2);
        world.setBlock(i, j + 1, k + 3, Blocks.air, 0, 2);
        world.setBlock(i + 1, j + 1, k + 3, placeIridiumBricks(random), 0, 2);
        world.setBlock(i + 2, j + 1, k + 3, Blocks.air, 0, 2);
        world.setBlock(i + 3, j + 1, k + 3, Blocks.air, 0, 2);
        world.setBlock(i + 4, j + 1, k + 3, Blocks.air, 0, 2);
        world.setBlock(i + 5, j + 1, k + 3, placeIridiumBricks(random), 0, 2);
        world.setBlock(i + 6, j + 1, k + 3, Blocks.air, 0, 2);
        world.setBlock(i, j + 1, k + 4, Blocks.air, 0, 2);
        world.setBlock(i + 1, j + 1, k + 4, NovaCraftBlocks.cracked_iridium_bricks, 0, 2);
        world.setBlock(i + 2, j + 1, k + 4, Blocks.air, 0, 2);
        world.setBlock(i + 3, j + 1, k + 4, Blocks.air, 0, 2);
        world.setBlock(i + 4, j + 1, k + 4, Blocks.air, 0, 2);
        world.setBlock(i + 5, j + 1, k + 4, placeIridiumBricks(random), 0, 2);
        world.setBlock(i + 6, j + 1, k + 4, Blocks.air, 0, 2);
        world.setBlock(i, j + 1, k + 5, Blocks.air, 0, 2);
        world.setBlock(i + 1, j + 1, k + 5, Blocks.air, 0, 2);
        world.setBlock(i + 2, j + 1, k + 5, placeIridiumBricks(random), 0, 2);
        world.setBlock(i + 3, j + 1, k + 5, placeIridiumBricks(random), 0, 2);
        world.setBlock(i + 4, j + 1, k + 5, placeIridiumBricks(random), 0, 2);
        world.setBlock(i + 5, j + 1, k + 5, Blocks.air, 0, 2);
        world.setBlock(i + 6, j + 1, k + 5, Blocks.air, 0, 2);
        world.setBlock(i, j + 1, k + 6, Blocks.air, 0, 2);
        world.setBlock(i + 1, j + 1, k + 6, Blocks.air, 0, 2);
        world.setBlock(i + 2, j + 1, k + 6, Blocks.air, 0, 2);
        world.setBlock(i + 4, j + 1, k + 6, Blocks.air, 0, 2);
        world.setBlock(i + 5, j + 1, k + 6, Blocks.air, 0, 2);
        world.setBlock(i + 6, j + 1, k + 6, Blocks.air, 0, 2);
        world.setBlock(i, j + 2, k, Blocks.air, 0, 2);
        world.setBlock(i + 1, j + 2, k, Blocks.air, 0, 2);
        world.setBlock(i + 2, j + 2, k, Blocks.air, 0, 2);
        world.setBlock(i + 3, j + 2, k, Blocks.air, 0, 2);
        world.setBlock(i + 4, j + 2, k, Blocks.air, 0, 2);
        world.setBlock(i + 5, j + 2, k, Blocks.air, 0, 2);
        world.setBlock(i + 6, j + 2, k, Blocks.air, 0, 2);
        world.setBlock(i, j + 2, k + 1, Blocks.air, 0, 2);
        world.setBlock(i + 1, j + 2, k + 1, Blocks.air, 0, 2);
        world.setBlock(i + 2, j + 2, k + 1, placeIridiumBricks(random), 0, 2);
        world.setBlock(i + 3, j + 2, k + 1, placeIridiumBricks(random), 0, 2);
        world.setBlock(i + 4, j + 2, k + 1, placeIridiumBricks(random), 0, 2);
        world.setBlock(i + 5, j + 2, k + 1, Blocks.air, 0, 2);
        world.setBlock(i + 6, j + 2, k + 1, Blocks.air, 0, 2);
        world.setBlock(i, j + 2, k + 2, Blocks.air, 0, 2);
        world.setBlock(i + 1, j + 2, k + 2, placeIridiumBricks(random), 0, 2);
        world.setBlock(i + 2, j + 2, k + 2, Blocks.air, 0, 2);
        world.setBlock(i + 3, j + 2, k + 2, Blocks.air, 0, 2);
        world.setBlock(i + 4, j + 2, k + 2, Blocks.air, 0, 2);
        world.setBlock(i + 5, j + 2, k + 2, placeIridiumBricks(random), 0, 2);
        world.setBlock(i + 6, j + 2, k + 2, Blocks.air, 0, 2);
        world.setBlock(i, j + 2, k + 3, Blocks.air, 0, 2);
        world.setBlock(i + 1, j + 2, k + 3, placeIridiumBricks(random), 0, 2);
        world.setBlock(i + 2, j + 2, k + 3, Blocks.air, 0, 2);
        world.setBlock(i + 3, j + 2, k + 3, Blocks.air, 0, 2);
        world.setBlock(i + 4, j + 2, k + 3, Blocks.air, 0, 2);
        world.setBlock(i + 5, j + 2, k + 3, placeIridiumBricks(random), 0, 2);
        world.setBlock(i + 6, j + 2, k + 3, Blocks.air, 0, 2);
        world.setBlock(i, j + 2, k + 4, Blocks.air, 0, 2);
        world.setBlock(i + 1, j + 2, k + 4, placeIridiumBricks(random), 0, 2);
        world.setBlock(i + 2, j + 2, k + 4, Blocks.air, 0, 2);
        world.setBlock(i + 3, j + 2, k + 4, Blocks.air, 0, 2);
        world.setBlock(i + 4, j + 2, k + 4, Blocks.air, 0, 2);
        world.setBlock(i + 5, j + 2, k + 4, placeIridiumBricks(random), 0, 2);
        world.setBlock(i + 6, j + 2, k + 4, Blocks.air, 0, 2);
        world.setBlock(i, j + 2, k + 5, Blocks.air, 0, 2);
        world.setBlock(i + 1, j + 2, k + 5, Blocks.air, 0, 2);
        world.setBlock(i + 2, j + 2, k + 5, placeIridiumBricks(random), 0, 2);
        world.setBlock(i + 3, j + 2, k + 5, placeIridiumBricks(random), 0, 2);
        world.setBlock(i + 4, j + 2, k + 5, placeIridiumBricks(random), 0, 2);
        world.setBlock(i + 5, j + 2, k + 5, Blocks.air, 0, 2);
        world.setBlock(i + 6, j + 2, k + 5, Blocks.air, 0, 2);
        world.setBlock(i, j + 2, k + 6, Blocks.air, 0, 2);
        world.setBlock(i + 1, j + 2, k + 6, Blocks.air, 0, 2);
        world.setBlock(i + 2, j + 2, k + 6, Blocks.air, 0, 2);
        world.setBlock(i + 3, j + 2, k + 6, Blocks.air, 0, 2);
        world.setBlock(i + 4, j + 2, k + 6, Blocks.air, 0, 2);
        world.setBlock(i + 5, j + 2, k + 6, Blocks.air, 0, 2);
        world.setBlock(i + 6, j + 2, k + 6, Blocks.air, 0, 2);
        world.setBlock(i + 3, j + 1, k + 6, NovaCraftBlocks.cracked_iridium_furnace, 3, 2);
        world.setBlock(i + 3, j, k + 6, NovaCraftBlocks.cracked_iridium_bricks, 0, 2);
        return true;
    }

    private Block placeIridiumBricks(Random random) {
        if (random.nextDouble() < 0.04) {
            return NovaCraftBlocks.cracked_iridium_bricks;
        } else if (random.nextDouble() >= 0.04 && random.nextDouble() <= 0.05) {
            return NovaCraftBlocks.iridium_bricks;
        } else {
            return Blocks.air;
        }
    }
}
