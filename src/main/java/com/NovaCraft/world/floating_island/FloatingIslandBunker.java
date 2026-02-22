package com.NovaCraft.world.floating_island;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraftBlocks.NovaCraftBlocks;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import java.util.Random;

public class FloatingIslandBunker extends WorldGenAbstractTree
{

    public FloatingIslandBunker(final Block block, final int height, final boolean branch) {
        super(true);
    }

    public boolean generate(final World world, final Random random, final int i, final int j, final int k) {

        world.setBlock(i + 3, j, k, NovaCraftBlocks.cracked_etherstone_bricks, 0, 2);
        world.setBlock(i + 4, j, k, NovaCraftBlocks.etherstone_bricks, 0, 2);
        world.setBlock(i + 5, j, k, NovaCraftBlocks.cracked_etherstone_bricks, 0, 2);
        world.setBlock(i + 6, j, k, NovaCraftBlocks.cracked_etherstone_bricks, 0, 2);
        world.setBlock(i + 7, j, k, NovaCraftBlocks.etherstone_bricks, 0, 2);
        world.setBlock(i + 8, j, k, NovaCraftBlocks.cracked_etherstone_bricks, 0, 2);
        world.setBlock(i + 9, j, k, NovaCraftBlocks.etherstone_bricks, 0, 2);
        world.setBlock(i + 3, j, k + 1, NovaCraftBlocks.cracked_etherstone_bricks, 0, 2);
        world.setBlock(i + 4, j, k + 1, NovaCraftBlocks.etherstone_bricks, 0, 2);
        world.setBlock(i + 5, j, k + 1, Blocks.carpet, 8, 2);
        world.setBlock(i + 6, j, k + 1, Blocks.air, 0, 2);
        world.setBlock(i + 7, j, k + 1, Blocks.carpet, 8, 2);
        world.setBlock(i + 9, j, k + 1, NovaCraftBlocks.etherstone_bricks, 0, 2);
        world.setBlock(i + 1, j, k + 2, NovaCraftBlocks.cracked_etherstone_bricks, 0, 2);
        world.setBlock(i + 2, j, k + 2, NovaCraftBlocks.etherstone_bricks, 0, 2);
        world.setBlock(i + 3, j, k + 2, NovaCraftBlocks.cracked_etherstone_bricks, 3, 2);
        world.setBlock(i + 4, j, k + 2, Blocks.air, 0, 2);
        world.setBlock(i + 5, j, k + 2, Blocks.carpet, 8, 2);
        world.setBlock(i + 6, j, k + 2, Blocks.air, 0, 2);
        world.setBlock(i + 7, j, k + 2, Blocks.carpet, 8, 2);
        world.setBlock(i + 8, j, k + 2, Blocks.air, 0, 2);
        world.setBlock(i + 9, j, k + 2, NovaCraftBlocks.etherstone_bricks, 0, 2);
        world.setBlock(i, j, k + 3, NovaCraftBlocks.etherstone_bricks, 0, 2);
        world.setBlock(i + 1, j, k + 3, placeLadder(random), 5, 2);
        world.setBlock(i + 2, j, k + 3, Blocks.air, 0, 2);
        world.setBlock(i + 3, j, k + 3, Blocks.air, 0, 2);
        world.setBlock(i + 4, j, k + 3, Blocks.air, 0, 2);
        world.setBlock(i + 5, j, k + 3, Blocks.air, 0, 2);
        world.setBlock(i + 6, j, k + 3, Blocks.air, 0, 2);
        world.setBlock(i + 7, j, k + 3, Blocks.air, 0, 2);
        world.setBlock(i + 8, j, k + 3, Blocks.air, 0, 2);
        world.setBlock(i + 9, j, k + 3, NovaCraftBlocks.etherstone_bricks, 0, 2);
        world.setBlock(i + 1, j, k + 4, NovaCraftBlocks.cracked_etherstone_bricks, 0, 2);
        world.setBlock(i + 2, j, k + 4, NovaCraftBlocks.etherstone_bricks, 0, 2);
        world.setBlock(i + 3, j, k + 4, Blocks.air, 0, 2);
        world.setBlock(i + 4, j, k + 4, Blocks.carpet, 8, 2);
        world.setBlock(i + 5, j, k + 4, Blocks.air, 0, 2);
        world.setBlock(i + 6, j, k + 4, Blocks.carpet, 8, 2);
        world.setBlock(i + 7, j, k + 4, Blocks.air, 0, 2);
        world.setBlock(i + 8, j, k + 4, Blocks.carpet, 8, 2);
        world.setBlock(i + 9, j, k + 4, NovaCraftBlocks.cracked_etherstone_bricks, 0, 2);
        world.setBlock(i + 3, j, k + 5, NovaCraftBlocks.etherstone_bricks, 0, 2);
        world.setBlock(i + 4, j, k + 5, Blocks.carpet, 8, 2);
        world.setBlock(i + 5, j, k + 5, Blocks.air, 0, 2);
        world.setBlock(i + 6, j, k + 5, Blocks.carpet, 8, 2);
        world.setBlock(i + 7, j, k + 5, Blocks.air, 0, 2);
        world.setBlock(i + 8, j, k + 5, Blocks.carpet, 8, 2);
        world.setBlock(i + 9, j, k + 5, NovaCraftBlocks.cracked_etherstone_bricks, 0, 2);
        world.setBlock(i + 3, j, k + 6, NovaCraftBlocks.etherstone_bricks, 0, 2);
        world.setBlock(i + 4, j, k + 6, NovaCraftBlocks.etherstone_bricks, 0, 2);
        world.setBlock(i + 5, j, k + 6, NovaCraftBlocks.cracked_etherstone_bricks, 0, 2);
        world.setBlock(i + 6, j, k + 6, NovaCraftBlocks.etherstone_bricks, 0, 2);
        world.setBlock(i + 7, j, k + 6, NovaCraftBlocks.cracked_etherstone_bricks, 0, 2);
        world.setBlock(i + 8, j, k + 6, NovaCraftBlocks.etherstone_bricks, 0, 2);
        world.setBlock(i + 9, j, k + 6, NovaCraftBlocks.etherstone_bricks, 0, 2);
        world.setBlock(i + 3, j + 1, k, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 4, j + 1, k, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 5, j + 1, k, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 6, j + 1, k, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 7, j + 1, k, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j + 1, k, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 9, j + 1, k, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 1, k + 1, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 5, j + 1, k + 1, Blocks.air, 0, 2);
        world.setBlock(i + 6, j + 1, k + 1, Blocks.air, 0, 2);
        world.setBlock(i + 7, j + 1, k + 1, Blocks.air, 0, 2);
        world.setBlock(i + 8, j + 1, k + 1, Blocks.air, 0, 2);
        world.setBlock(i + 9, j + 1, k + 1, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 1, j + 1, k + 2, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 2, j + 1, k + 2, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 1, k + 2, Blocks.air, 0, 2);
        world.setBlock(i + 4, j + 1, k + 2, Blocks.air, 0, 2);
        world.setBlock(i + 5, j + 1, k + 2, Blocks.air, 0, 2);
        world.setBlock(i + 6, j + 1, k + 2, Blocks.air, 0, 2);
        world.setBlock(i + 7, j + 1, k + 2, Blocks.air, 0, 2);
        world.setBlock(i + 8, j + 1, k + 2, Blocks.air, 0, 2);
        world.setBlock(i + 9, j + 1, k + 2, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i, j + 1, k + 3, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 1, j + 1, k + 3, placeLadder(random), 5, 2);
        world.setBlock(i + 2, j + 1, k + 3, Blocks.air, 0, 2);
        world.setBlock(i + 3, j + 1, k + 3, Blocks.air, 0, 2);
        world.setBlock(i + 4, j + 1, k + 3, Blocks.air, 0, 2);
        world.setBlock(i + 5, j + 1, k + 3, Blocks.air, 0, 2);
        world.setBlock(i + 6, j + 1, k + 3, Blocks.air, 0, 2);
        world.setBlock(i + 7, j + 1, k + 3, Blocks.air, 0, 2);
        world.setBlock(i + 8, j + 1, k + 3, Blocks.air, 0, 2);
        world.setBlock(i + 9, j + 1, k + 3, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 1, j + 1, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 2, j + 1, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 1, k + 4, Blocks.air, 0, 2);
        world.setBlock(i + 4, j + 1, k + 4, Blocks.air, 0, 2);
        world.setBlock(i + 5, j + 1, k + 4, Blocks.air, 0, 2);
        world.setBlock(i + 6, j + 1, k + 4, Blocks.air, 0, 2);
        world.setBlock(i + 7, j + 1, k + 4, Blocks.air, 0, 2);
        world.setBlock(i + 8, j + 1, k + 4, Blocks.air, 0, 2);
        world.setBlock(i + 9, j + 1, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 1, k + 5, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 4, j + 1, k + 5, Blocks.air, 0, 2);
        world.setBlock(i + 5, j + 1, k + 5, Blocks.air, 0, 2);
        world.setBlock(i + 6, j + 1, k + 5, Blocks.air, 0, 2);
        world.setBlock(i + 7, j + 1, k + 5, Blocks.air, 0, 2);
        world.setBlock(i + 8, j + 1, k + 5, Blocks.air, 0, 2);
        world.setBlock(i + 9, j + 1, k + 5, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 1, k + 6, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 4, j + 1, k + 6, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 5, j + 1, k + 6, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 6, j + 1, k + 6, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 7, j + 1, k + 6, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j + 1, k + 6, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 9, j + 1, k + 6, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 2, k, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 4, j + 2, k, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 5, j + 2, k, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 6, j + 2, k, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 7, j + 2, k, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j + 2, k, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 9, j + 2, k, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 2, k + 1, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 4, j + 2, k + 1, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 5, j + 2, k + 1, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 6, j + 2, k + 1, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 7, j + 2, k + 1, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j + 2, k + 1, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 9, j + 2, k + 1, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 1, j + 2, k + 2, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 2, j + 2, k + 2, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 2, k + 2, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 4, j + 2, k + 2, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 5, j + 2, k + 2, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 6, j + 2, k + 2, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 7, j + 2, k + 2, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j + 2, k + 2, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 9, j + 2, k + 2, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i, j + 2, k + 3, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 1, j + 2, k + 3, placeLadder(random), 5, 2);
        world.setBlock(i + 2, j + 2, k + 3, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 2, k + 3, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 4, j + 2, k + 3, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 5, j + 2, k + 3, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 6, j + 2, k + 3, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 7, j + 2, k + 3, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j + 2, k + 3, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 9, j + 2, k + 3, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 1, j + 2, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 2, j + 2, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 2, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 4, j + 2, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 5, j + 2, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 6, j + 2, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 7, j + 2, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j + 2, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 9, j + 2, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 2, k + 5, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 4, j + 2, k + 5, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 5, j + 2, k + 5, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 6, j + 2, k + 5, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 7, j + 2, k + 5, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j + 2, k + 5, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 9, j + 2, k + 5, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 2, k + 6, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 4, j + 2, k + 6, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 5, j + 2, k + 6, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 6, j + 2, k + 6, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 7, j + 2, k + 6, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j + 2, k + 6, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 9, j + 2, k + 6, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 1, j + 3, k + 2, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i, j + 3, k + 3, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 1, j + 3, k + 3, placeLadder(random), 5, 2);
        world.setBlock(i + 2, j + 3, k + 3, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 1, j + 3, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 1, j + 4, k + 2, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i, j + 4, k + 3, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 1, j + 4, k + 3, placeLadder(random), 5, 2);
        world.setBlock(i + 2, j + 4, k + 3, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 1, j + 4, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 1, j + 5, k + 1, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 2, j + 5, k + 1, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 5, k + 1, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 4, j + 5, k + 1, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 5, j + 5, k + 1, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i, j + 5, k + 2, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 1, j + 5, k + 2, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 2, j + 5, k + 2, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 5, k + 2, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 4, j + 5, k + 2, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 5, j + 5, k + 2, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 6, j + 5, k + 2, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i, j + 5, k + 3, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 1, j + 5, k + 3, Blocks.trapdoor, 11, 2);
        world.setBlock(i + 2, j + 5, k + 3, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 5, k + 3, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 4, j + 5, k + 3, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 5, j + 5, k + 3, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 6, j + 5, k + 3, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i, j + 5, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 1, j + 5, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 2, j + 5, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 5, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 4, j + 5, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 5, j + 5, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 6, j + 5, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 1, j + 5, k + 5, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 2, j + 5, k + 5, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 5, k + 5, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 4, j + 5, k + 5, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 5, j + 5, k + 5, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 1, j + 6, k + 1, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 2, j + 6, k + 1, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 6, k + 1, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 4, j + 6, k + 1, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 5, j + 6, k + 1, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i, j + 6, k + 2, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 1, j + 6, k + 2, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 6, k + 2, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 4, j + 6, k + 2, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 5, j + 6, k + 2, placeEtherStoneTileStairs(random), 0, 2);
        world.setBlock(i + 6, j + 6, k + 2, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i, j + 6, k + 3, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 1, j + 6, k + 3, Blocks.air, 0, 2);
        world.setBlock(i + 2, j + 6, k + 3, Blocks.air, 0, 2);
        world.setBlock(i + 3, j + 6, k + 3, Blocks.air, 0, 2);
        world.setBlock(i + 4, j + 6, k + 3, Blocks.air, 0, 2);
        world.setBlock(i + 5, j + 6, k + 3, Blocks.air, 0, 2);
        world.setBlock(i + 6, j + 6, k + 3, Blocks.air, 0, 2);
        world.setBlock(i, j + 6, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 1, j + 6, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 2, j + 6, k + 4, placeEtherStoneTileStairs(random), 1, 2);
        world.setBlock(i + 3, j + 6, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 4, j + 6, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 5, j + 6, k + 4, placeEtherStoneTileStairs(random), 0, 2);
        world.setBlock(i + 6, j + 6, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 1, j + 6, k + 5, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 2, j + 6, k + 5, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 6, k + 5, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 4, j + 6, k + 5, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 5, j + 6, k + 5, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 1, j + 7, k + 1, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 2, j + 7, k + 1, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 7, k + 1, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 4, j + 7, k + 1, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 5, j + 7, k + 1, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i, j + 7, k + 2, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 1, j + 7, k + 2, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 2, j + 7, k + 2, Blocks.air, 0, 2);
        world.setBlock(i + 3, j + 7, k + 2, Blocks.air, 0, 2);
        world.setBlock(i + 4, j + 7, k + 2, Blocks.air, 0, 2);
        world.setBlock(i + 5, j + 7, k + 2, Blocks.air, 0, 2);
        world.setBlock(i + 6, j + 7, k + 2, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i, j + 7, k + 3, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 1, j + 7, k + 3, Blocks.air, 0, 2);
        world.setBlock(i + 2, j + 7, k + 3, Blocks.air, 0, 2);
        world.setBlock(i + 3, j + 7, k + 3, Blocks.air, 0, 2);
        world.setBlock(i + 4, j + 7, k + 3, Blocks.air, 0, 2);
        world.setBlock(i + 5, j + 7, k + 3, Blocks.air, 0, 2);
        world.setBlock(i + 6, j + 7, k + 3, Blocks.air, 0, 2);
        world.setBlock(i, j + 7, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 1, j + 7, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 2, j + 7, k + 4, Blocks.air, 0, 2);
        world.setBlock(i + 3, j + 7, k + 4, Blocks.air, 0, 2);
        world.setBlock(i + 4, j + 7, k + 4, Blocks.air, 0, 2);
        world.setBlock(i + 5, j + 7, k + 4, Blocks.air, 0, 2);
        world.setBlock(i + 6, j + 7, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 1, j + 7, k + 5, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 2, j + 7, k + 5, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 7, k + 5, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 4, j + 7, k + 5, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 5, j + 7, k + 5, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i, j + 8, k + 2, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 1, j + 8, k + 2, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 2, j + 8, k + 2, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 8, k + 2, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 4, j + 8, k + 2, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 5, j + 8, k + 2, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 6, j + 8, k + 2, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i, j + 8, k + 3, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 1, j + 8, k + 3, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 2, j + 8, k + 3, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 8, k + 3, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 4, j + 8, k + 3, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 5, j + 8, k + 3, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 6, j + 8, k + 3, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i, j + 8, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 1, j + 8, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 2, j + 8, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 8, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 4, j + 8, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 5, j + 8, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 6, j + 8, k + 4, placeEtherStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j, k, NovaCraftBlocks.etherstone_bricks, 0, 2);

        world.setBlock(i + 2, j + 6, k + 2, Blocks.mob_spawner, 0, 2);
        TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner)world.getTileEntity(i + 2, j + 6, k + 2);

        if (tileentitymobspawner != null)
        {
            tileentitymobspawner.func_145881_a().setEntityName("nova_craft.crystal_slime");
        }

        world.setBlock(i + 8, j, k + 1, Blocks.chest, 3, 2);
        TileEntityChest chest = (TileEntityChest) world.getTileEntity(i + 8, j, k + 1);

        for (int slot = 0; slot < 3 + random.nextInt(20); slot++) {
            chest.setInventorySlotContents(random.nextInt(chest.getSizeInventory()), this.getChestLoot(random));
        }

        int choice = (int)(1 + Math.random() * 30);
        if (choice <= 15) {
            world.setBlock(i + 4, j + 1, k + 1, Blocks.skull, 0, 2);
        } else {
            world.setBlock(i + 4, j + 1, k + 1, Blocks.skull, 4, 2);
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

    private Block placeEtherStoneTileStairs(Random random) {
        if (random.nextDouble() < 0.65) {
            return NovaCraftBlocks.etherstone_tiled_stairs;
        } else {
            return Blocks.air;
        }
    }

    private Block placeLadder(Random random) {
        if (random.nextDouble() < 0.75) {
            return Blocks.ladder;
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
                return new ItemStack(Items.gold_ingot, random.nextInt(9) + 3);
            default: {
                return new ItemStack(NovaCraftItems.diamond_nugget, random.nextInt(7) + 5, 2);
            }
        }
    }
}
