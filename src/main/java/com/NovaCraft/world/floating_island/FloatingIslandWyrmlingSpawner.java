package com.NovaCraft.world.floating_island;

import java.util.Random;

import com.NovaCraftBlocks.NovaCraftBlocks;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class FloatingIslandWyrmlingSpawner extends WorldGenAbstractTree
{
    
    public FloatingIslandWyrmlingSpawner(final Block block, final int height, final boolean branch) {
        super(true);
    }
	
	public boolean generate(final World world, final Random random, final int i, final int j, final int k) {
		
		world.setBlock(i + 3, j - 1, k + 0, NovaCraftBlocks.etherstone_bricks, 0, 2);
		world.setBlock(i + 2, j - 1, k + 1, NovaCraftBlocks.etherstone_bricks, 0, 2);
		world.setBlock(i + 3, j - 1, k + 1, NovaCraftBlocks.etherstone_bricks, 0, 2);
		world.setBlock(i + 4, j - 1, k + 1, NovaCraftBlocks.etherstone_bricks, 0, 2);
		world.setBlock(i + 1, j - 1, k + 2, NovaCraftBlocks.cracked_etherstone_bricks, 0, 2);
		world.setBlock(i + 2, j - 1, k + 2, NovaCraftBlocks.cracked_etherstone_tiles, 0, 2);
		world.setBlock(i + 3, j - 1, k + 2, NovaCraftBlocks.etherstone_tiles, 0, 2);
		world.setBlock(i + 4, j - 1, k + 2, NovaCraftBlocks.cracked_etherstone_tiles, 0, 2);
		world.setBlock(i + 5, j - 1, k + 2, NovaCraftBlocks.cracked_etherstone_bricks, 0, 2);
		world.setBlock(i + 0, j - 1, k + 3, NovaCraftBlocks.etherstone_bricks, 0, 2);
		world.setBlock(i + 1, j - 1, k + 3, NovaCraftBlocks.etherstone_bricks, 0, 2);
		world.setBlock(i + 2, j - 1, k + 3, NovaCraftBlocks.etherstone_tiles, 0, 2);
		world.setBlock(i + 3, j - 1, k + 3, NovaCraftBlocks.cracked_etherstone_tiles, 0, 2);
		world.setBlock(i + 4, j - 1, k + 3, NovaCraftBlocks.etherstone_tiles, 0, 2);
		world.setBlock(i + 5, j - 1, k + 3, NovaCraftBlocks.etherstone_bricks, 0, 2);
		world.setBlock(i + 6, j - 1, k + 3, NovaCraftBlocks.etherstone_bricks, 0, 2);
		world.setBlock(i + 1, j - 1, k + 4, NovaCraftBlocks.cracked_etherstone_bricks, 0, 2);
		world.setBlock(i + 2, j - 1, k + 4, NovaCraftBlocks.etherstone_tiles, 0, 2);
		world.setBlock(i + 3, j - 1, k + 4, NovaCraftBlocks.cracked_etherstone_tiles, 0, 2);
		world.setBlock(i + 4, j - 1, k + 4, NovaCraftBlocks.cracked_etherstone_tiles, 0, 2);
		world.setBlock(i + 5, j - 1, k + 4, NovaCraftBlocks.cracked_etherstone_bricks, 0, 2);
		world.setBlock(i + 2, j - 1, k + 5, NovaCraftBlocks.etherstone_bricks, 0, 2);
		world.setBlock(i + 3, j - 1, k + 5, NovaCraftBlocks.etherstone_bricks, 0, 2);
		world.setBlock(i + 4, j - 1, k + 5, NovaCraftBlocks.etherstone_bricks, 0, 2);
		world.setBlock(i + 3, j - 1, k + 6, NovaCraftBlocks.etherstone_bricks, 0, 2);
		world.setBlock(i + 3, j, k + 0, NovaCraftBlocks.cracked_etherstone_bricks, 0, 2);
		world.setBlock(i + 3, j, k + 1, NovaCraftBlocks.etherstone_brick_stairs, 3, 2);
		world.setBlock(i + 0, j, k + 3, NovaCraftBlocks.cracked_etherstone_bricks, 0, 2);
		world.setBlock(i + 1, j, k + 3, NovaCraftBlocks.etherstone_brick_stairs, 1, 2);
		world.setBlock(i + 5, j, k + 3, NovaCraftBlocks.etherstone_brick_stairs, 0, 2);
		world.setBlock(i + 6, j, k + 3, NovaCraftBlocks.cracked_etherstone_bricks, 0, 2);
		world.setBlock(i + 3, j, k + 5, NovaCraftBlocks.etherstone_brick_stairs, 2, 2);
		world.setBlock(i + 3, j, k + 6, NovaCraftBlocks.cracked_etherstone_bricks, 0, 2);
		world.setBlock(i + 3, j + 1, k + 0, NovaCraftBlocks.etherstone_bricks, 0, 2);
		world.setBlock(i + 0, j + 1, k + 3, NovaCraftBlocks.etherstone_bricks, 0, 2);
		world.setBlock(i + 6, j + 1, k + 3, NovaCraftBlocks.cracked_etherstone_bricks, 0, 2);
		world.setBlock(i + 3, j + 1, k + 6, NovaCraftBlocks.etherstone_bricks, 0, 2);
		world.setBlock(i + 3, j + 2, k + 0, NovaCraftBlocks.etherstone_bricks, 0, 2);
		world.setBlock(i + 3, j + 2, k + 1, NovaCraftBlocks.etherstone_brick_stairs, 7, 2);
		world.setBlock(i + 0, j + 2, k + 3, NovaCraftBlocks.cracked_etherstone_bricks, 0, 2);
		world.setBlock(i + 1, j + 2, k + 3, NovaCraftBlocks.etherstone_brick_stairs, 5, 2);
		world.setBlock(i + 5, j + 2, k + 3, NovaCraftBlocks.etherstone_brick_stairs, 4, 2);
		world.setBlock(i + 6, j + 2, k + 3, NovaCraftBlocks.etherstone_bricks, 0, 2);
		world.setBlock(i + 3, j + 2, k + 5, NovaCraftBlocks.etherstone_brick_stairs, 6, 2);
		world.setBlock(i + 3, j + 2, k + 6, NovaCraftBlocks.cracked_etherstone_bricks, 0, 2);
		world.setBlock(i + 3, j + 3, k + 1, NovaCraftBlocks.cracked_etherstone_bricks, 0, 2);
		world.setBlock(i + 3, j + 3, k + 2, NovaCraftBlocks.etherstone_brick_stairs, 7, 2);
		world.setBlock(i + 1, j + 3, k + 3, NovaCraftBlocks.cracked_etherstone_bricks, 0, 2);
		world.setBlock(i + 2, j + 3, k + 3, NovaCraftBlocks.etherstone_brick_stairs, 5, 2);
		world.setBlock(i + 3, j + 3, k + 3, NovaCraftBlocks.cracked_etherstone_bricks, 0, 2);
		world.setBlock(i + 4, j + 3, k + 3, NovaCraftBlocks.etherstone_brick_stairs, 4, 2);
		world.setBlock(i + 5, j + 3, k + 3, NovaCraftBlocks.cracked_etherstone_bricks, 0, 2);
		world.setBlock(i + 3, j + 3, k + 4, NovaCraftBlocks.etherstone_brick_stairs, 6, 2);
		world.setBlock(i + 3, j + 3, k + 5, NovaCraftBlocks.etherstone_bricks, 0, 2);
		world.setBlock(i + 3, j + 4, k + 2, NovaCraftBlocks.etherstone_bricks, 0, 2);
		world.setBlock(i + 2, j + 4, k + 3, NovaCraftBlocks.etherstone_bricks, 0, 2);
		world.setBlock(i + 3, j + 4, k + 3, NovaCraftBlocks.etherstone_bricks, 0, 2);
		world.setBlock(i + 4, j + 4, k + 3, NovaCraftBlocks.etherstone_bricks, 0, 2);
		world.setBlock(i + 3, j + 4, k + 4, NovaCraftBlocks.cracked_etherstone_bricks, 0, 2);

		world.setBlock(i + 3, j + 2, k + 3, Blocks.mob_spawner, 0, 2);
		TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner)world.getTileEntity(i + 3, j + 2, k + 3);

		if (tileentitymobspawner != null)
		{
			tileentitymobspawner.func_145881_a().setEntityName("nova_craft.soloid");
		}

		return true;
	}

}
