package com.NovaCraft.world.end;

import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.world.gen.feature.*;
import net.minecraft.block.*;
import net.minecraft.world.*;
import java.util.*;
import com.NovaCraftBlocks.NovaCraftBlocks;
import net.minecraft.init.*;

public class DestitudeIslandEchoCluster extends WorldGenAbstractTree {
    
    public DestitudeIslandEchoCluster(final Block leafID, final int heightWeight, final boolean branchFlag) {
        super(true);
    }
    
    public boolean generate(final World world, final Random random, final int i, final int j, final int k) {
        world.setBlock(i + 1, j, k, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 2, j, k, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 3, j, k , NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 4, j, k, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i, j, k + 1, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 1, j, k + 1, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 2, j, k + 1, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 3, j, k + 1, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 4, j, k + 1, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 5, j, k + 1, NovaCraftBlocks.frontierslate, 0, 2);
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
        world.setBlock(i + 5, j, k + 3, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i, j, k + 4, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 1, j, k + 4, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 2, j, k + 4, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 3, j, k + 4, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 4, j, k + 4, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 5, j, k + 4, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 1, j, k + 5, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 2, j, k + 5, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 3, j, k + 5, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 4, j, k + 5, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 2, j + 1, k + 1, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 3, j + 1, k + 1, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 4, j + 1, k + 1, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 3, j + 1, k + 2, NovaCraftBlocks.budding_echo_block, 0, 2);
        world.setBlock(i + 4, j + 1, k + 2, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 3, j + 1, k + 3, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 4, j + 1, k + 3, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 2, j + 1, k + 4, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 3, j + 1, k + 4, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 4, j + 1, k + 4, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 2, j + 2, k + 1, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 3, j + 2, k + 1, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 3, j + 2, k + 2, NovaCraftBlocks.echo_cluster_2, 7, 2);
        world.setBlock(i + 3, j + 2, k + 3, NovaCraftBlocks.budding_echo_block, 0, 2);
        world.setBlock(i + 4, j + 2, k + 3, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 3, j + 2, k + 4, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 4, j + 2, k + 4, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 3, j + 3, k + 3, NovaCraftBlocks.echo_cluster_2, 7, 2);
        world.setBlock(i + 4, j + 3, k + 3, NovaCraftBlocks.frontierslate_bricks, 0, 2);

        world.setBlock(i + 1, j + 1, k + 3, Blocks.mob_spawner, 0, 2);
        TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner)world.getTileEntity(i + 1, j + 1, k + 3);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a().setEntityName("nova_craft.reality_distorter");
        }

        return true;
    }
}
