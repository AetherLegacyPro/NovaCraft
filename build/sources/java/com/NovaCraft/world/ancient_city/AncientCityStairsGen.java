package com.NovaCraft.world.ancient_city;

import net.minecraft.world.gen.feature.*;
import net.minecraft.block.*;
import net.minecraft.world.*;
import java.util.*;
import com.NovaCraftBlocks.NovaCraftBlocks;
import net.minecraft.init.*;

public class AncientCityStairsGen extends WorldGenerator
{
	public AncientCityStairsGen() {

	}
	
	 public boolean generate(final World world, final Random random, final int i, final int j, final int k) {
		 
			world.setBlock(i + 1, j, k + 5, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 1, j, k + 6, NovaCraftBlocks.nullstone_tiled_stairs, 3, 2);
			world.setBlock(i + 1, j, k + 15, NovaCraftBlocks.nullstone_tiled_stairs, 2, 2);
			world.setBlock(i + 1, j, k + 16, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 1, j + 1, k + 4, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 1, j + 1, k + 5, NovaCraftBlocks.nullstone_tiled_stairs, 3, 2);
			world.setBlock(i + 1, j + 1, k + 16, NovaCraftBlocks.nullstone_tiled_stairs, 2, 2);
			world.setBlock(i + 1, j + 1, k + 17, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 1, j + 2, k + 3, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 1, j + 2, k + 4, NovaCraftBlocks.nullstone_tiled_stairs, 3, 2);
			world.setBlock(i + 1, j + 2, k + 17, NovaCraftBlocks.nullstone_tiled_stairs, 2, 2);
			world.setBlock(i + 1, j + 2, k + 18, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 1, j + 3, k + 1, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 1, j + 3, k + 2, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 1, j + 3, k + 3, NovaCraftBlocks.nullstone_tiled_stairs, 3, 2);
			world.setBlock(i + 1, j + 3, k + 18, NovaCraftBlocks.nullstone_tiled_stairs, 2, 2);
			world.setBlock(i + 1, j + 3, k + 19, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 1, j + 3, k + 20, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 1, j + 4, k, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 1, j + 4, k + 1, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 1, j + 4, k + 2, NovaCraftBlocks.nullstone_tiled_stairs, 3, 2);
			world.setBlock(i + 1, j + 4, k + 19, NovaCraftBlocks.nullstone_tiled_stairs, 2, 2);
			world.setBlock(i + 1, j + 4, k + 20, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 1, j + 4, k + 21, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 1, j + 5, k, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 1, j + 5, k + 1, NovaCraftBlocks.nullstone_tiled_stairs, 3, 2);
			world.setBlock(i + 1, j + 5, k + 20, NovaCraftBlocks.nullstone_tiled_stairs, 2, 2);
			world.setBlock(i + 1, j + 5, k + 21, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 1, j + 6, k, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i, j + 6, k + 1, NovaCraftBlocks.nullstone_tiled_stairs, 1, 2);
			world.setBlock(i, j + 6, k + 20, NovaCraftBlocks.nullstone_tiled_stairs, 1, 2);
			world.setBlock(i + 1, j + 6, k + 21, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 1, j + 7, k, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 1, j + 7, k + 21, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 1, j + 8, k, NovaCraftBlocks.dim_vanite_torch, 5, 2);
			world.setBlock(i + 1, j + 8, k + 21, NovaCraftBlocks.dim_vanite_torch, 5, 2);
		 
			return true;
	 }

}
