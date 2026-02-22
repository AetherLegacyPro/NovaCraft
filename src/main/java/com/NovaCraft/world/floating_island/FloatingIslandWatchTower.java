package com.NovaCraft.world.floating_island;

import com.NovaCraft.Items.NovaCraftItems;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.world.gen.feature.*;
import net.minecraft.block.*;
import net.minecraft.world.*;
import java.util.*;

import com.NovaCraftBlocks.NovaCraftBlocks;

import net.minecraft.init.*;

public class FloatingIslandWatchTower extends WorldGenAbstractTree
{

    public FloatingIslandWatchTower(final Block leafID, final int heightWeight, final boolean branchFlag) {
        super(true);
    }

    public boolean generate(final World world, final Random random, final int i, final int j, final int k) {


        world.setBlock(i + 1, j, k, NovaCraftBlocks.rich_etherstone, 0, 2);
        world.setBlock(i, j, k + 1, NovaCraftBlocks.rich_etherstone, 0, 2);
        world.setBlock(i + 5, j, k + 1, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 6, j, k + 1, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 7, j, k + 1, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j, k + 1, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 5, j, k + 2, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 6, j, k + 2, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 7, j, k + 2, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j, k + 2, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 9, j, k + 2, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 5, j, k + 3, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 6, j, k + 3, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 7, j, k + 3, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j, k + 3, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 9, j, k + 3, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i, j, k + 4, NovaCraftBlocks.rich_etherstone, 0, 2);
        world.setBlock(i + 5, j, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 6, j, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 7, j, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 1, j, k + 5, NovaCraftBlocks.rich_etherstone, 0, 2);
        world.setBlock(i + 1, j + 1, k, NovaCraftBlocks.etherstone_brick_wall, 0, 2);
        world.setBlock(i, j + 1, k + 1, NovaCraftBlocks.etherstone_brick_wall, 0, 2);
        world.setBlock(i + 5, j + 1, k + 1, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 6, j + 1, k + 1, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 7, j + 1, k + 1, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j + 1, k + 1, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 7, j + 1, k + 2, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j + 1, k + 2, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 9, j + 1, k + 2, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 7, j + 1, k + 3, placeEtherStoneBrickStairs(random), 0, 2);
        world.setBlock(i + 8, j + 1, k + 3, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 9, j + 1, k + 3, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i, j + 1, k + 4, NovaCraftBlocks.etherstone_brick_wall, 0, 2);
        world.setBlock(i + 5, j + 1, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 6, j + 1, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 7, j + 1, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j + 1, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 1, j + 1, k + 5, NovaCraftBlocks.etherstone_brick_wall, 0, 2);
        world.setBlock(i + 1, j + 2, k, NovaCraftBlocks.etherstone_brick_wall, 0, 2);
        world.setBlock(i, j + 2, k + 1, NovaCraftBlocks.etherstone_brick_wall, 0, 2);
        world.setBlock(i + 5, j + 2, k + 1, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 6, j + 2, k + 1, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 7, j + 2, k + 1, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j + 2, k + 1, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 7, j + 2, k + 2, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j + 2, k + 2, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 9, j + 2, k + 2, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j + 2, k + 3, placeEtherStoneBrickStairs(random), 0, 2);
        world.setBlock(i + 9, j + 2, k + 3, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i, j + 2, k + 4, NovaCraftBlocks.etherstone_brick_wall, 0, 2);
        world.setBlock(i + 5, j + 2, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 6, j + 2, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 7, j + 2, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j + 2, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 1, j + 2, k + 5, NovaCraftBlocks.etherstone_brick_wall, 0, 2);
        world.setBlock(i + 1, j + 3, k, NovaCraftBlocks.etherstone_brick_wall, 0, 2);
        world.setBlock(i, j + 3, k + 1, NovaCraftBlocks.etherstone_brick_wall, 0, 2);
        world.setBlock(i + 5, j + 3, k + 1, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 6, j + 3, k + 1, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 7, j + 3, k + 1, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j + 3, k + 1, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 5, j + 3, k + 2, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 7, j + 3, k + 2, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j + 3, k + 2, placeEtherStoneBrickStairs(random), 3, 2);
        world.setBlock(i + 9, j + 3, k + 2, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 5, j + 3, k + 3, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 9, j + 3, k + 3, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i, j + 3, k + 4, NovaCraftBlocks.etherstone_brick_wall, 0, 2);
        world.setBlock(i + 5, j + 3, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 6, j + 3, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 7, j + 3, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j + 3, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 1, j + 3, k + 5, NovaCraftBlocks.etherstone_brick_wall, 0, 2);
        world.setBlock(i + 1, j + 4, k, NovaCraftBlocks.etherstone_brick_wall, 0, 2);
        world.setBlock(i, j + 4, k + 1, NovaCraftBlocks.etherstone_brick_wall, 0, 2);
        world.setBlock(i + 5, j + 4, k + 1, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 6, j + 4, k + 1, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 7, j + 4, k + 1, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j + 4, k + 1, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 5, j + 4, k + 2, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 6, j + 4, k + 2, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 7, j + 4, k + 2, placeEtherStoneBrickStairs(random), 1, 2);
        world.setBlock(i + 9, j + 4, k + 2, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 5, j + 4, k + 3, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 9, j + 4, k + 3, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i, j + 4, k + 4, NovaCraftBlocks.etherstone_brick_wall, 0, 2);
        world.setBlock(i + 5, j + 4, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 6, j + 4, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 7, j + 4, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j + 4, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 1, j + 4, k + 5, NovaCraftBlocks.etherstone_brick_wall, 0, 2);
        world.setBlock(i + 1, j + 5, k, NovaCraftBlocks.etherstone_brick_wall, 0, 2);
        world.setBlock(i, j + 5, k + 1, NovaCraftBlocks.etherstone_brick_wall, 0, 2);
        world.setBlock(i + 5, j + 5, k + 1, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 6, j + 5, k + 1, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 7, j + 5, k + 1, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j + 5, k + 1, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 5, j + 5, k + 2, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 6, j + 5, k + 2, placeEtherStoneBrickStairs(random), 1, 2);
        world.setBlock(i + 9, j + 5, k + 2, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 5, j + 5, k + 3, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 6, j + 5, k + 3, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 9, j + 5, k + 3, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i, j + 5, k + 4, NovaCraftBlocks.etherstone_brick_wall, 0, 2);
        world.setBlock(i + 5, j + 5, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 6, j + 5, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 7, j + 5, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j + 5, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 1, j + 5, k + 5, NovaCraftBlocks.etherstone_brick_wall, 0, 2);
        world.setBlock(i + 1, j + 6, k, NovaCraftBlocks.etherstone_brick_wall, 0, 2);
        world.setBlock(i, j + 6, k + 1, NovaCraftBlocks.etherstone_brick_wall, 0, 2);
        world.setBlock(i + 5, j + 6, k + 1, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 6, j + 6, k + 1, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 7, j + 6, k + 1, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j + 6, k + 1, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 5, j + 6, k + 2, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 9, j + 6, k + 2, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 5, j + 6, k + 3, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 6, j + 6, k + 3, placeEtherStoneBrickStairs(random), 2, 2);
        world.setBlock(i + 7, j + 6, k + 3, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 9, j + 6, k + 3, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i, j + 6, k + 4, NovaCraftBlocks.etherstone_brick_wall, 0, 2);
        world.setBlock(i + 5, j + 6, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 6, j + 6, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 7, j + 6, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j + 6, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 1, j + 6, k + 5, NovaCraftBlocks.etherstone_brick_wall, 0, 2);
        world.setBlock(i + 1, j + 7, k, NovaCraftBlocks.etherstone_brick_wall, 0, 2);
        world.setBlock(i, j + 7, k + 1, NovaCraftBlocks.etherstone_brick_wall, 0, 2);
        world.setBlock(i + 5, j + 7, k + 1, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 6, j + 7, k + 1, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 7, j + 7, k + 1, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j + 7, k + 1, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 5, j + 7, k + 2, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 9, j + 7, k + 2, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 5, j + 7, k + 3, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 7, j + 7, k + 3, placeEtherStoneBrickStairs(random), 0, 2);
        world.setBlock(i + 8, j + 7, k + 3, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 9, j + 7, k + 3, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i, j + 7, k + 4, NovaCraftBlocks.etherstone_brick_wall, 0, 2);
        world.setBlock(i + 5, j + 7, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 6, j + 7, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 7, j + 7, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j + 7, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 1, j + 7, k + 5, NovaCraftBlocks.etherstone_brick_wall, 0, 2);
        world.setBlock(i + 1, j + 8, k, NovaCraftBlocks.etherstone_brick_wall, 0, 2);
        world.setBlock(i, j + 8, k + 1, NovaCraftBlocks.etherstone_brick_wall, 0, 2);
        world.setBlock(i + 5, j + 8, k + 1, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 6, j + 8, k + 1, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 7, j + 8, k + 1, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j + 8, k + 1, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 5, j + 8, k + 2, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j + 8, k + 2, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 9, j + 8, k + 2, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 5, j + 8, k + 3, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j + 8, k + 3, placeEtherStoneBrickStairs(random), 0, 2);
        world.setBlock(i + 9, j + 8, k + 3, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i, j + 8, k + 4, NovaCraftBlocks.etherstone_brick_wall, 0, 2);
        world.setBlock(i + 5, j + 8, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 6, j + 8, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 7, j + 8, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j + 8, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 1, j + 8, k + 5, NovaCraftBlocks.etherstone_brick_wall, 0, 2);
        world.setBlock(i + 1, j + 9, k, NovaCraftBlocks.etherstone_brick_wall, 0, 2);
        world.setBlock(i, j + 9, k + 1, NovaCraftBlocks.etherstone_brick_wall, 0, 2);
        world.setBlock(i + 5, j + 9, k + 1, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 6, j + 9, k + 1, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 7, j + 9, k + 1, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j + 9, k + 1, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 5, j + 9, k + 2, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 7, j + 9, k + 2, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j + 9, k + 2, placeEtherStoneBrickStairs(random), 3, 2);
        world.setBlock(i + 9, j + 9, k + 2, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 5, j + 9, k + 3, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 9, j + 9, k + 3, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i, j + 9, k + 4, NovaCraftBlocks.etherstone_brick_wall, 0, 2);
        world.setBlock(i + 5, j + 9, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 6, j + 9, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 7, j + 9, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j + 9, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 1, j + 9, k + 5, NovaCraftBlocks.etherstone_brick_wall, 0, 2);
        world.setBlock(i + 1, j + 10, k, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 2, j + 10, k, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 10, k, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 4, j + 10, k, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 5, j + 10, k, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i, j + 10, k + 1, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 1, j + 10, k + 1, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 2, j + 10, k + 1, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 10, k + 1, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 4, j + 10, k + 1, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 5, j + 10, k + 1, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 6, j + 10, k + 1, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 7, j + 10, k + 1, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j + 10, k + 1, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i, j + 10, k + 2, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 1, j + 10, k + 2, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 2, j + 10, k + 2, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 10, k + 2, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 4, j + 10, k + 2, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 5, j + 10, k + 2, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 6, j + 10, k + 2, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 7, j + 10, k + 2, placeEtherStoneBrickStairs(random), 1, 2);
        world.setBlock(i + 9, j + 10, k + 2, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i, j + 10, k + 3, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 1, j + 10, k + 3, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 2, j + 10, k + 3, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 10, k + 3, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 4, j + 10, k + 3, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 5, j + 10, k + 3, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 9, j + 10, k + 3, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i, j + 10, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 1, j + 10, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 2, j + 10, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 10, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 4, j + 10, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 5, j + 10, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 6, j + 10, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 7, j + 10, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j + 10, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 1, j + 10, k + 5, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 2, j + 10, k + 5, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 10, k + 5, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 4, j + 10, k + 5, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 5, j + 10, k + 5, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 1, j + 11, k, NovaCraftBlocks.etherstone_brick_wall, 0, 2);
        world.setBlock(i + 2, j + 11, k, NovaCraftBlocks.etherstone_brick_wall, 0, 2);
        world.setBlock(i + 3, j + 11, k, NovaCraftBlocks.etherstone_brick_wall, 0, 2);
        world.setBlock(i + 4, j + 11, k, NovaCraftBlocks.etherstone_brick_wall, 0, 2);
        world.setBlock(i + 5, j + 11, k, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i, j + 11, k + 1, NovaCraftBlocks.etherstone_brick_wall, 0, 2);
        world.setBlock(i + 1, j + 11, k + 1, NovaCraftBlocks.etherstone_brick_wall, 0, 2);
        world.setBlock(i + 5, j + 11, k + 1, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 6, j + 11, k + 1, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 7, j + 11, k + 1, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j + 11, k + 1, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i, j + 11, k + 2, NovaCraftBlocks.etherstone_brick_wall, 0, 2);
        world.setBlock(i + 9, j + 11, k + 2, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i, j + 11, k + 3, NovaCraftBlocks.etherstone_brick_wall, 0, 2);
        world.setBlock(i + 9, j + 11, k + 3, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i, j + 11, k + 4, NovaCraftBlocks.etherstone_brick_wall, 0, 2);
        world.setBlock(i + 1, j + 11, k + 4, NovaCraftBlocks.etherstone_brick_wall, 0, 2);
        world.setBlock(i + 2, j + 11, k + 4, placeEtherStoneBrickStairs(random), 1, 2);
        world.setBlock(i + 4, j + 11, k + 4, placeEtherStoneBrickStairs(random), 0, 2);
        world.setBlock(i + 5, j + 11, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 6, j + 11, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 7, j + 11, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j + 11, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 1, j + 11, k + 5, NovaCraftBlocks.etherstone_brick_wall, 0, 2);
        world.setBlock(i + 2, j + 11, k + 5, NovaCraftBlocks.etherstone_brick_wall, 0, 2);
        world.setBlock(i + 3, j + 11, k + 5, NovaCraftBlocks.etherstone_brick_wall, 0, 2);
        world.setBlock(i + 4, j + 11, k + 5, NovaCraftBlocks.etherstone_brick_wall, 0, 2);
        world.setBlock(i + 5, j + 11, k + 5, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 5, j + 12, k, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 5, j + 12, k + 1, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 6, j + 12, k + 1, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 7, j + 12, k + 1, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j + 12, k + 1, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 9, j + 12, k + 2, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 9, j + 12, k + 3, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 5, j + 12, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 6, j + 12, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 7, j + 12, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j + 12, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 5, j + 12, k + 5, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 4, j + 13, k, placeEtherStoneBrickStairs(random), 6, 2);
        world.setBlock(i + 5, j + 13, k, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 4, j + 13, k + 1, placeEtherStoneBrickStairs(random), 4, 2);
        world.setBlock(i + 5, j + 13, k + 1, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 6, j + 13, k + 1, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 7, j + 13, k + 1, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j + 13, k + 1, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 4, j + 13, k + 2, placeEtherStoneBrickStairs(random), 4, 2);
        world.setBlock(i + 5, j + 13, k + 2, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 6, j + 13, k + 2, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 7, j + 13, k + 2, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j + 13, k + 2, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 9, j + 13, k + 2, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 4, j + 13, k + 3, placeEtherStoneBrickStairs(random), 4, 2);
        world.setBlock(i + 5, j + 13, k + 3, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 6, j + 13, k + 3, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 7, j + 13, k + 3, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j + 13, k + 3, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 9, j + 13, k + 3, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 4, j + 13, k + 4, placeEtherStoneBrickStairs(random), 4, 2);
        world.setBlock(i + 5, j + 13, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 6, j + 13, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 7, j + 13, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j + 13, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 4, j + 13, k + 5, placeEtherStoneBrickStairs(random), 7, 2);
        world.setBlock(i + 5, j + 13, k + 5, placeEtherStoneBricks(random), 0, 2);

        world.setBlock(i + 2, j + 11, k + 1, Blocks.chest, 3, 2);
        TileEntityChest chest = (TileEntityChest) world.getTileEntity(i + 2, j + 11, k + 1);

        for (int slot = 0; slot < 3 + random.nextInt(20); slot++) {
            chest.setInventorySlotContents(random.nextInt(chest.getSizeInventory()), this.getChestLoot(random));
        }

        world.setBlock(i + 3, j + 11, k + 1, Blocks.chest, 3, 2);
        TileEntityChest chest2 = (TileEntityChest) world.getTileEntity(i + 3, j + 11, k + 1);

        for (int slot = 0; slot < 3 + random.nextInt(20); slot++) {
            chest2.setInventorySlotContents(random.nextInt(chest2.getSizeInventory()), this.getChestLoot(random));
        }

        return true;
    }

    private Block placeEtherStoneBricks(Random random) {
        if (random.nextDouble() < 0.65) {
            return NovaCraftBlocks.etherstone_bricks;
        } else if (random.nextDouble() < 0.85) {
            return NovaCraftBlocks.cracked_etherstone_bricks;
        } else {
            return Blocks.air;
        }
    }

    private Block placeEtherStoneBrickStairs(Random random) {
        if (random.nextDouble() < 0.65) {
            return NovaCraftBlocks.etherstone_brick_stairs;
        } else {
            return Blocks.air;
        }
    }

    private ItemStack getChestLoot(Random random) {
        int item = random.nextInt(15);
        switch (item) {
            case 0:
                return new ItemStack(Items.iron_ingot, random.nextInt(4) + 3);
            case 1:
                return new ItemStack(NovaCraftBlocks.cobbled_etherstone, random.nextInt(8) + 3);
            case 2:
                return new ItemStack(NovaCraftItems.aether_shard);
            case 3:
                return new ItemStack(NovaCraftItems.vanite_ingot, random.nextInt(5) + 4);
            case 4:
                return new ItemStack(NovaCraftItems.iridium_nugget, random.nextInt(4) + 3, 0);
            case 5:
                return new ItemStack(NovaCraftItems.copartz_shard, random.nextInt(3) + 1);
            case 6:
                return new ItemStack(NovaCraftItems.tsavorokite_shard, random.nextInt(2) + 1);
            case 7:
                return new ItemStack(NovaCraftItems.larimar_shard, random.nextInt(2) + 1);
            case 8:
                return new ItemStack(NovaCraftItems.diamond_nugget, random.nextInt(7) + 5, 2);
            default: {
                return new ItemStack(Items.gold_ingot, random.nextInt(9) + 3);
            }
        }
    }
}
