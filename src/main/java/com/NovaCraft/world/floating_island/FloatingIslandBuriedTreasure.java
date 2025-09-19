package com.NovaCraft.world.floating_island;
import com.NovaCraftBlocks.NovaCraftBlocks;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import java.util.Random;

public class FloatingIslandBuriedTreasure extends WorldGenAbstractTree
{

    public FloatingIslandBuriedTreasure(final Block block, final int height, final boolean branch) {
        super(true);
    }

    public boolean generate(final World world, final Random random, final int i, final int j, final int k) {

        world.setBlock(i + 2, j - 4, k + 1, NovaCraftBlocks.rich_etherstone, 0, 2);
        world.setBlock(i + 1, j - 4, k + 2, NovaCraftBlocks.rich_etherstone, 0, 2);
        world.setBlock(i + 2, j - 4, k + 2, NovaCraftBlocks.rich_etherstone, 0, 2);
        world.setBlock(i + 3, j - 4, k + 2, NovaCraftBlocks.rich_etherstone, 0, 2);
        world.setBlock(i + 2, j - 4, k + 3, NovaCraftBlocks.rich_etherstone, 0, 2);
        world.setBlock(i + 2, j - 3, k + 0, NovaCraftBlocks.cracked_etherstone_bricks, 0, 2);
        world.setBlock(i + 1, j - 3, k + 1, NovaCraftBlocks.etherstone_bricks, 0, 2);
        world.setBlock(i + 2, j - 3, k + 1, NovaCraftBlocks.rich_etherstone_spike, 0, 2);
        world.setBlock(i + 3, j - 3, k + 1, NovaCraftBlocks.etherstone_bricks, 0, 2);
        world.setBlock(i + 0, j - 3, k + 2, NovaCraftBlocks.etherstone_bricks, 0, 2);
        world.setBlock(i + 1, j - 3, k + 2, NovaCraftBlocks.rich_etherstone_spike, 0, 2);
        world.setBlock(i + 3, j - 3, k + 2, NovaCraftBlocks.rich_etherstone_spike, 0, 2);
        world.setBlock(i + 4, j - 3, k + 2, NovaCraftBlocks.etherstone_bricks, 0, 2);
        world.setBlock(i + 1, j - 3, k + 3, NovaCraftBlocks.etherstone_bricks, 0, 2);
        world.setBlock(i + 2, j - 3, k + 3, NovaCraftBlocks.rich_etherstone_spike, 0, 2);
        world.setBlock(i + 3, j - 3, k + 3, NovaCraftBlocks.cracked_etherstone_bricks, 0, 2);
        world.setBlock(i + 2, j - 3, k + 4, NovaCraftBlocks.etherstone_bricks, 0, 2);
        world.setBlock(i + 2, j - 2, k + 0, NovaCraftBlocks.etherstone_bricks, 0, 2);
        world.setBlock(i + 1, j - 2, k + 1, NovaCraftBlocks.etherstone_bricks, 0, 2);
        world.setBlock(i + 2, j - 2, k + 1, Blocks.air, 0, 2);
        world.setBlock(i + 3, j - 2, k + 1, NovaCraftBlocks.etherstone_bricks, 0, 2);
        world.setBlock(i + 0, j - 2, k + 2, NovaCraftBlocks.cracked_etherstone_bricks, 0, 2);
        world.setBlock(i + 1, j - 2, k + 2, Blocks.air, 0, 2);
        world.setBlock(i + 2, j - 2, k + 2, Blocks.air, 0, 2);
        world.setBlock(i + 3, j - 2, k + 2, Blocks.air, 0, 2);
        world.setBlock(i + 4, j - 2, k + 2, NovaCraftBlocks.etherstone_bricks, 0, 2);
        world.setBlock(i + 1, j - 2, k + 3, NovaCraftBlocks.etherstone_bricks, 0, 2);
        world.setBlock(i + 2, j - 2, k + 3, Blocks.air, 0, 2);
        world.setBlock(i + 3, j - 2, k + 3, NovaCraftBlocks.etherstone_bricks, 0, 2);
        world.setBlock(i + 2, j - 2, k + 4, NovaCraftBlocks.cracked_etherstone_bricks, 0, 2);
        world.setBlock(i + 2, j - 1, k + 0, NovaCraftBlocks.rich_etherstone, 0, 2);
        world.setBlock(i + 1, j - 1, k + 1, NovaCraftBlocks.rich_etherstone, 0, 2);
        world.setBlock(i + 2, j - 1, k + 1, NovaCraftBlocks.cracked_etherstone_bricks, 0, 2);
        world.setBlock(i + 3, j - 1, k + 1, NovaCraftBlocks.rich_etherstone, 0, 2);
        world.setBlock(i + 0, j - 1, k + 2, NovaCraftBlocks.rich_etherstone, 0, 2);
        world.setBlock(i + 1, j - 1, k + 2, NovaCraftBlocks.cracked_etherstone_bricks, 0, 2);
        world.setBlock(i + 2, j - 1, k + 2, NovaCraftBlocks.etherstone_bricks, 0, 2);
        world.setBlock(i + 3, j - 1, k + 2, NovaCraftBlocks.cracked_etherstone_bricks, 0, 2);
        world.setBlock(i + 4, j - 1, k + 2, NovaCraftBlocks.rich_etherstone, 0, 2);
        world.setBlock(i + 1, j - 1, k + 3, NovaCraftBlocks.rich_etherstone, 0, 2);
        world.setBlock(i + 2, j - 1, k + 3, NovaCraftBlocks.etherstone_bricks, 0, 2);
        world.setBlock(i + 3, j - 1, k + 3, NovaCraftBlocks.rich_etherstone, 0, 2);
        world.setBlock(i + 2, j - 1, k + 4, NovaCraftBlocks.rich_etherstone, 0, 2);

        int rand = (int)(1 + Math.random() * 8);
        switch (rand) {
            case 1: world.setBlock(i + 2, j - 3, k + 2, NovaCraftBlocks.iridium_pile, 7, 2);
                    world.setBlock(i + 2, j, k + 2, NovaCraftBlocks.iridium_pile, 0, 2);
                    break;
            case 2: world.setBlock(i + 2, j - 3, k + 2, NovaCraftBlocks.diamond_pile, 7, 2);
                    world.setBlock(i + 2, j, k + 2, NovaCraftBlocks.diamond_pile, 0, 2);
                    break;
            case 3: world.setBlock(i + 2, j - 3, k + 2, NovaCraftBlocks.emerald_pile, 7, 2);
                    world.setBlock(i + 2, j, k + 2, NovaCraftBlocks.emerald_pile, 0, 2);
                    break;
            case 4: world.setBlock(i + 2, j - 3, k + 2, NovaCraftBlocks.crystal_pile, 7, 2);
                    world.setBlock(i + 2, j, k + 2, NovaCraftBlocks.crystal_pile, 0, 2);
                    break;
            default: world.setBlock(i + 2, j - 3, k + 2, NovaCraftBlocks.iridium_pile, 7, 2);
                     world.setBlock(i + 2, j, k + 2, NovaCraftBlocks.iridium_pile, 0, 2);
                     break;
        }

        return true;
    }
}
