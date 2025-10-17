package com.NovaCraft.world.floating_island;

import com.NovaCraftBlocks.NovaCraftBlocks;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import java.util.Random;

public class FloatingIslandSmallSpawner extends WorldGenAbstractTree
{

    public FloatingIslandSmallSpawner(final Block block, final int height, final boolean branch) {
        super(true);
    }

    public boolean generate(final World world, final Random random, final int i, final int j, final int k) {

        world.setBlock(i + 1, j + 0, k + 0, NovaCraftBlocks.etherstone_tiled_slab);
        world.setBlock(i + 0, j + 0, k + 1, NovaCraftBlocks.etherstone_tiled_slab);
        world.setBlock(i + 1, j + 0, k + 1, NovaCraftBlocks.etherstone_tiles, 0, 2);
        world.setBlock(i + 2, j + 0, k + 1, NovaCraftBlocks.etherstone_tiled_slab);
        world.setBlock(i + 0, j + 0, k + 2, NovaCraftBlocks.etherstone_tiles, 0, 2);
        world.setBlock(i + 1, j + 0, k + 2, NovaCraftBlocks.cracked_etherstone_tiles, 0, 2);
        world.setBlock(i + 2, j + 0, k + 2, NovaCraftBlocks.etherstone_tiles, 0, 2);
        world.setBlock(i + 1, j + 0, k + 3, NovaCraftBlocks.etherstone_tiles, 0, 2);
        world.setBlock(i + 2, j + 0, k + 3, NovaCraftBlocks.cracked_etherstone_tiles, 0, 2);

        world.setBlock(i + 1, j + 1, k + 2, Blocks.mob_spawner, 0, 2);
        TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner)world.getTileEntity(i + 1, j + 1, k + 2);

        if (tileentitymobspawner != null)
        {
            int choice = (int)(1 + Math.random() * 30);
            if (choice <= 15) {
                tileentitymobspawner.func_145881_a().setEntityName("nova_craft.crystal_slime");
            } else {
                tileentitymobspawner.func_145881_a().setEntityName("nova_craft.wyrmling");
            }
        }

        return true;
    }
}
