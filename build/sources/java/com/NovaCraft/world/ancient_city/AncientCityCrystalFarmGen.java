package com.NovaCraft.world.ancient_city;

import net.minecraft.world.gen.feature.*;
import net.minecraft.block.*;
import net.minecraft.world.*;
import java.util.*;
import com.NovaCraftBlocks.NovaCraftBlocks;
import net.minecraft.init.*;

public class AncientCityCrystalFarmGen extends WorldGenerator
{
	public AncientCityCrystalFarmGen() {

	}
	
	 public boolean generate(final World world, final Random random, final int i, final int j, final int k) {
		 
		 	world.setBlock(i, j, k, NovaCraftBlocks.vanite_brick_stairs, 2, 2);
			world.setBlock(i + 1, j, k, NovaCraftBlocks.vanite_brick_stairs, 2, 2);
			world.setBlock(i + 2, j, k, NovaCraftBlocks.vanite_brick_stairs, 2, 2);
			world.setBlock(i + 3, j, k, NovaCraftBlocks.vanite_brick_stairs, 2, 2);
			world.setBlock(i + 4, j, k, NovaCraftBlocks.vanite_brick_stairs, 2, 2);
			world.setBlock(i + 5, j, k, NovaCraftBlocks.vanite_brick_stairs, 2, 2);
			world.setBlock(i + 6, j, k, NovaCraftBlocks.vanite_brick_stairs, 2, 2);
			world.setBlock(i, j, k + 1, NovaCraftBlocks.vanite_brick_stairs, 0, 2);
			world.setBlock(i + 1, j, k + 1, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 3, j, k + 1, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 4, j, k + 1, NovaCraftBlocks.sculk_block, 0, 2);
			world.setBlock(i + 5, j, k + 1, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 6, j, k + 1, NovaCraftBlocks.vanite_brick_stairs, 1, 2);
			world.setBlock(i, j, k + 2, NovaCraftBlocks.vanite_brick_stairs, 0, 2);
			world.setBlock(i + 1, j, k + 2, NovaCraftBlocks.sculk_block, 0, 2);
			world.setBlock(i + 4, j, k + 2, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 5, j, k + 2, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 6, j, k + 2, NovaCraftBlocks.vanite_brick_stairs, 1, 2);
			world.setBlock(i, j, k + 3, NovaCraftBlocks.vanite_brick_stairs, 0, 2);
			world.setBlock(i + 6, j, k + 3, NovaCraftBlocks.vanite_brick_stairs, 1, 2);
			world.setBlock(i, j, k + 4, NovaCraftBlocks.vanite_brick_stairs, 0, 2);
			world.setBlock(i + 1, j, k + 4, NovaCraftBlocks.sculk_block, 0, 2);
			world.setBlock(i + 5, j, k + 4, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 6, j, k + 4, NovaCraftBlocks.vanite_brick_stairs, 1, 2);
			world.setBlock(i, j, k + 5, NovaCraftBlocks.vanite_brick_stairs, 0, 2);
			world.setBlock(i + 1, j, k + 5, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 2, j, k + 5, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 5, j, k + 5, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 6, j, k + 5, NovaCraftBlocks.vanite_brick_stairs, 1, 2);
			world.setBlock(i, j, k + 6, NovaCraftBlocks.vanite_brick_stairs, 3, 2);
			world.setBlock(i + 1, j, k + 6, NovaCraftBlocks.vanite_brick_stairs, 3, 2);
			world.setBlock(i + 2, j, k + 6, NovaCraftBlocks.vanite_brick_stairs, 3, 2);
			world.setBlock(i + 3, j, k + 6, NovaCraftBlocks.vanite_brick_stairs, 3, 2);
			world.setBlock(i + 4, j, k + 6, NovaCraftBlocks.vanite_brick_stairs, 3, 2);
			world.setBlock(i + 5, j, k + 6, NovaCraftBlocks.vanite_brick_stairs, 3, 2);
			world.setBlock(i + 6, j, k + 6, NovaCraftBlocks.vanite_brick_stairs, 1, 2);
			world.setBlock(i, j + 1, k, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 1, k, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 1, k, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 1, k, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 1, k, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 1, k, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 1, k, Blocks.air, 0, 2);
			world.setBlock(i, j + 1, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 1, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 1, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 1, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 1, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 1, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 1, k + 1, Blocks.air, 0, 2);
			world.setBlock(i, j + 1, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 1, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 1, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 1, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 1, k + 2, Blocks.air, 0, 2);
			world.setBlock(i, j + 1, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 1, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 1, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 1, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 1, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 1, k + 3, Blocks.air, 0, 2);
			world.setBlock(i, j + 1, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 1, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 1, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 1, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 1, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 1, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 1, k + 4, Blocks.air, 0, 2);
			world.setBlock(i, j + 1, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 1, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 1, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 1, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 1, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 1, k + 5, Blocks.air, 0, 2);
			world.setBlock(i, j + 1, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 1, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 1, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 1, k + 6, Blocks.air, 0, 2);
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
			world.setBlock(i + 2, j + 2, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 2, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 2, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 2, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 2, k + 1, Blocks.air, 0, 2);
			world.setBlock(i, j + 2, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 2, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 2, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 2, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 2, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 2, k + 2, Blocks.air, 0, 2);
			world.setBlock(i, j + 2, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 2, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 2, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 2, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 2, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 2, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 2, k + 3, Blocks.air, 0, 2);
			world.setBlock(i, j + 2, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 2, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 2, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 2, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 2, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 2, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 2, k + 4, Blocks.air, 0, 2);
			world.setBlock(i, j + 2, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 2, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 2, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 2, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 2, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 2, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 2, k + 5, Blocks.air, 0, 2);
			world.setBlock(i, j + 2, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 2, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 2, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 2, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 2, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 2, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 2, k + 6, Blocks.air, 0, 2);
			
			int rand = (int)(1 + Math.random() * 100);

			if (rand >= 25 && rand <= 50) {
	        	world.setBlock(i + 4, j + 1, k + 2, NovaCraftBlocks.budding_copartz_block, 0, 2);
				world.setBlock(i + 2, j, k + 2, NovaCraftBlocks.budding_copartz_block, 0, 2);
				world.setBlock(i + 3, j, k + 3, NovaCraftBlocks.budding_copartz_block, 0, 2);
				world.setBlock(i + 4, j, k + 5, NovaCraftBlocks.budding_copartz_block, 0, 2);			
				world.setBlock(i + 2, j, k + 1, NovaCraftBlocks.copartz_block, 0, 2);
				world.setBlock(i + 3, j, k + 2, NovaCraftBlocks.copartz_block, 0, 2);
				world.setBlock(i + 1, j, k + 3, NovaCraftBlocks.copartz_block, 0, 2);
				world.setBlock(i + 2, j, k + 3, NovaCraftBlocks.copartz_block, 0, 2);		
				world.setBlock(i + 4, j, k + 3, NovaCraftBlocks.copartz_block, 0, 2);
				world.setBlock(i + 5, j, k + 3, NovaCraftBlocks.copartz_block, 0, 2);
				world.setBlock(i + 2, j, k + 4, NovaCraftBlocks.copartz_block, 0, 2);
				world.setBlock(i + 3, j, k + 4, NovaCraftBlocks.copartz_block, 0, 2);
				world.setBlock(i + 4, j, k + 4, NovaCraftBlocks.copartz_block, 0, 2);
				world.setBlock(i + 3, j, k + 5, NovaCraftBlocks.copartz_block, 0, 2);			
				world.setBlock(i + 3, j + 1, k + 3, NovaCraftBlocks.copartz_cluster_2, 7, 2);
				world.setBlock(i + 4, j + 1, k + 5, NovaCraftBlocks.copartz_cluster_2, 7, 2);
				world.setBlock(i + 4, j + 2, k + 2, NovaCraftBlocks.copartz_cluster_2, 7, 2);
				world.setBlock(i + 2, j + 1, k + 2, NovaCraftBlocks.copartz_cluster_2, 7, 2);
			}
			else if (rand > 50 && rand < 75) {		
				world.setBlock(i + 4, j + 1, k + 2, NovaCraftBlocks.budding_larimar_block, 0, 2);
				world.setBlock(i + 2, j, k + 2, NovaCraftBlocks.budding_larimar_block, 0, 2);
				world.setBlock(i + 3, j, k + 3, NovaCraftBlocks.budding_larimar_block, 0, 2);
				world.setBlock(i + 4, j, k + 5, NovaCraftBlocks.budding_larimar_block, 0, 2);			
				world.setBlock(i + 2, j, k + 1, NovaCraftBlocks.larimar_block, 0, 2);
				world.setBlock(i + 3, j, k + 2, NovaCraftBlocks.larimar_block, 0, 2);
				world.setBlock(i + 1, j, k + 3, NovaCraftBlocks.larimar_block, 0, 2);
				world.setBlock(i + 2, j, k + 3, NovaCraftBlocks.larimar_block, 0, 2);		
				world.setBlock(i + 4, j, k + 3, NovaCraftBlocks.larimar_block, 0, 2);
				world.setBlock(i + 5, j, k + 3, NovaCraftBlocks.larimar_block, 0, 2);
				world.setBlock(i + 2, j, k + 4, NovaCraftBlocks.larimar_block, 0, 2);
				world.setBlock(i + 3, j, k + 4, NovaCraftBlocks.larimar_block, 0, 2);
				world.setBlock(i + 4, j, k + 4, NovaCraftBlocks.larimar_block, 0, 2);
				world.setBlock(i + 3, j, k + 5, NovaCraftBlocks.larimar_block, 0, 2);			
				world.setBlock(i + 3, j + 1, k + 3, NovaCraftBlocks.larimar_cluster_2, 7, 2);
				world.setBlock(i + 4, j + 1, k + 5, NovaCraftBlocks.larimar_cluster_2, 7, 2);
				world.setBlock(i + 4, j + 2, k + 2, NovaCraftBlocks.larimar_cluster_2, 7, 2);
				world.setBlock(i + 2, j + 1, k + 2, NovaCraftBlocks.larimar_cluster_2, 7, 2);
			}
			else if (rand >= 75 && rand <= 100) {			
				world.setBlock(i + 4, j + 1, k + 2, NovaCraftBlocks.budding_tsavorokite_block, 0, 2);
				world.setBlock(i + 2, j, k + 2, NovaCraftBlocks.budding_tsavorokite_block, 0, 2);
				world.setBlock(i + 3, j, k + 3, NovaCraftBlocks.budding_tsavorokite_block, 0, 2);
				world.setBlock(i + 4, j, k + 5, NovaCraftBlocks.budding_tsavorokite_block, 0, 2);			
				world.setBlock(i + 2, j, k + 1, NovaCraftBlocks.tsavorokite_block, 0, 2);
				world.setBlock(i + 3, j, k + 2, NovaCraftBlocks.tsavorokite_block, 0, 2);
				world.setBlock(i + 1, j, k + 3, NovaCraftBlocks.tsavorokite_block, 0, 2);
				world.setBlock(i + 2, j, k + 3, NovaCraftBlocks.tsavorokite_block, 0, 2);		
				world.setBlock(i + 4, j, k + 3, NovaCraftBlocks.tsavorokite_block, 0, 2);
				world.setBlock(i + 5, j, k + 3, NovaCraftBlocks.tsavorokite_block, 0, 2);
				world.setBlock(i + 2, j, k + 4, NovaCraftBlocks.tsavorokite_block, 0, 2);
				world.setBlock(i + 3, j, k + 4, NovaCraftBlocks.tsavorokite_block, 0, 2);
				world.setBlock(i + 4, j, k + 4, NovaCraftBlocks.tsavorokite_block, 0, 2);
				world.setBlock(i + 3, j, k + 5, NovaCraftBlocks.tsavorokite_block, 0, 2);			
				world.setBlock(i + 3, j + 1, k + 3, NovaCraftBlocks.tsavorokite_cluster_2, 7, 2);
				world.setBlock(i + 4, j + 1, k + 5, NovaCraftBlocks.tsavorokite_cluster_2, 7, 2);
				world.setBlock(i + 4, j + 2, k + 2, NovaCraftBlocks.tsavorokite_cluster_2, 7, 2);
				world.setBlock(i + 2, j + 1, k + 2, NovaCraftBlocks.tsavorokite_cluster_2, 7, 2);
			}
			else if (rand >= 0 && rand < 25) {				
				world.setBlock(i + 4, j + 1, k + 2, NovaCraftBlocks.budding_yttrlinsite_block, 0, 2);
				world.setBlock(i + 2, j, k + 2, NovaCraftBlocks.budding_yttrlinsite_block, 0, 2);
				world.setBlock(i + 3, j, k + 3, NovaCraftBlocks.budding_yttrlinsite_block, 0, 2);
				world.setBlock(i + 4, j, k + 5, NovaCraftBlocks.budding_yttrlinsite_block, 0, 2);			
				world.setBlock(i + 2, j, k + 1, NovaCraftBlocks.yttrlinsite_block, 0, 2);
				world.setBlock(i + 3, j, k + 2, NovaCraftBlocks.yttrlinsite_block, 0, 2);
				world.setBlock(i + 1, j, k + 3, NovaCraftBlocks.yttrlinsite_block, 0, 2);
				world.setBlock(i + 2, j, k + 3, NovaCraftBlocks.yttrlinsite_block, 0, 2);		
				world.setBlock(i + 4, j, k + 3, NovaCraftBlocks.yttrlinsite_block, 0, 2);
				world.setBlock(i + 5, j, k + 3, NovaCraftBlocks.yttrlinsite_block, 0, 2);
				world.setBlock(i + 2, j, k + 4, NovaCraftBlocks.yttrlinsite_block, 0, 2);
				world.setBlock(i + 3, j, k + 4, NovaCraftBlocks.yttrlinsite_block, 0, 2);
				world.setBlock(i + 4, j, k + 4, NovaCraftBlocks.yttrlinsite_block, 0, 2);
				world.setBlock(i + 3, j, k + 5, NovaCraftBlocks.yttrlinsite_block, 0, 2);			
				world.setBlock(i + 3, j + 1, k + 3, NovaCraftBlocks.yttrlinsite_cluster_2, 7, 2);
				world.setBlock(i + 4, j + 1, k + 5, NovaCraftBlocks.yttrlinsite_cluster_2, 7, 2);
				world.setBlock(i + 4, j + 2, k + 2, NovaCraftBlocks.yttrlinsite_cluster_2, 7, 2);
				world.setBlock(i + 2, j + 1, k + 2, NovaCraftBlocks.yttrlinsite_cluster_2, 7, 2);
	        }
		 
		 return true;
	 }

}
