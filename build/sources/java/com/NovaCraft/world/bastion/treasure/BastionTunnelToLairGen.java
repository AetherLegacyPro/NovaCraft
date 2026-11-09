package com.NovaCraft.world.bastion.treasure;

import net.minecraft.world.gen.feature.*;
import net.minecraft.world.*;
import java.util.*;
import com.NovaCraftBlocks.NovaCraftBlocks;
import net.minecraft.init.*;

public class BastionTunnelToLairGen extends WorldGenerator
{
	public BastionTunnelToLairGen() {

	}
	
	public boolean generate(final World world, final Random random, final int i, final int j, final int k) {
		
		world.setBlock(i, j, k, NovaCraftBlocks.basal_bricks, 0, 2);
		world.setBlock(i + 1, j, k, NovaCraftBlocks.glowing_basal, 0, 2);
		world.setBlock(i + 2, j, k, NovaCraftBlocks.basal_bricks, 0, 2);
		world.setBlock(i + 3, j, k, NovaCraftBlocks.basal_bricks, 0, 2);
		world.setBlock(i, j, k + 1, NovaCraftBlocks.basal_bricks, 0, 2);
		world.setBlock(i + 1, j, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 2, j, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 3, j, k + 1, NovaCraftBlocks.basal_bricks, 0, 2);
		world.setBlock(i, j, k + 2, NovaCraftBlocks.basal_bricks, 0, 2);
		world.setBlock(i + 1, j, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 2, j, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 3, j, k + 2, NovaCraftBlocks.basal_bricks, 0, 2);
		world.setBlock(i, j, k + 3, NovaCraftBlocks.basal_bricks, 0, 2);
		world.setBlock(i + 1, j, k + 3, NovaCraftBlocks.basal_bricks, 0, 2);
		world.setBlock(i + 2, j, k + 3, NovaCraftBlocks.basal_bricks, 0, 2);
		world.setBlock(i + 3, j, k + 3, NovaCraftBlocks.basal_bricks, 0, 2);
		world.setBlock(i, j + 1, k, NovaCraftBlocks.basal_bricks, 0, 2);
		world.setBlock(i + 1, j + 1, k, NovaCraftBlocks.cracked_basal_bricks, 0, 2);
		world.setBlock(i + 2, j + 1, k, NovaCraftBlocks.basal_bricks, 0, 2);
		world.setBlock(i + 3, j + 1, k, NovaCraftBlocks.basal_bricks, 0, 2);
		world.setBlock(i, j + 1, k + 1, NovaCraftBlocks.glowing_basal, 0, 2);
		world.setBlock(i + 1, j + 1, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 1, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 1, k + 1, NovaCraftBlocks.cracked_basal_bricks, 0, 2);
		world.setBlock(i, j + 1, k + 2, NovaCraftBlocks.basal_bricks, 0, 2);
		world.setBlock(i + 1, j + 1, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 1, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 1, k + 2, NovaCraftBlocks.glowing_basal, 0, 2);
		world.setBlock(i, j + 1, k + 3, NovaCraftBlocks.basal_bricks, 0, 2);
		world.setBlock(i + 1, j + 1, k + 3, NovaCraftBlocks.basal_bricks, 0, 2);
		world.setBlock(i + 2, j + 1, k + 3, NovaCraftBlocks.basal_bricks, 0, 2);
		world.setBlock(i + 3, j + 1, k + 3, NovaCraftBlocks.basal_bricks, 0, 2);
		world.setBlock(i, j + 2, k, NovaCraftBlocks.basal_bricks, 0, 2);
		world.setBlock(i + 1, j + 2, k, NovaCraftBlocks.basal_bricks, 0, 2);
		world.setBlock(i + 2, j + 2, k, NovaCraftBlocks.glowing_basal, 0, 2);
		world.setBlock(i + 3, j + 2, k, NovaCraftBlocks.basal_bricks, 0, 2);
		world.setBlock(i, j + 2, k + 1, NovaCraftBlocks.basal_bricks, 0, 2);
		world.setBlock(i + 1, j + 2, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 2, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 2, k + 1, NovaCraftBlocks.basal_bricks, 0, 2);
		world.setBlock(i, j + 2, k + 2, NovaCraftBlocks.cracked_basal_bricks, 0, 2);
		world.setBlock(i + 1, j + 2, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 2, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 2, k + 2, NovaCraftBlocks.basal_bricks, 0, 2);
		world.setBlock(i, j + 2, k + 3, NovaCraftBlocks.basal_bricks, 0, 2);
		world.setBlock(i + 1, j + 2, k + 3, NovaCraftBlocks.glowing_basal, 0, 2);
		world.setBlock(i + 2, j + 2, k + 3, NovaCraftBlocks.basal_bricks, 0, 2);
		world.setBlock(i + 3, j + 2, k + 3, NovaCraftBlocks.basal_bricks, 0, 2);
		world.setBlock(i, j + 3, k, NovaCraftBlocks.basal_bricks, 0, 2);
		world.setBlock(i + 1, j + 3, k, NovaCraftBlocks.basal_bricks, 0, 2);
		world.setBlock(i + 2, j + 3, k, NovaCraftBlocks.basal_bricks, 0, 2);
		world.setBlock(i + 3, j + 3, k, NovaCraftBlocks.cracked_basal_bricks, 0, 2);
		world.setBlock(i, j + 3, k + 1, NovaCraftBlocks.cracked_basal_bricks, 0, 2);
		world.setBlock(i + 1, j + 3, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 3, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 3, k + 1, NovaCraftBlocks.glowing_basal, 0, 2);
		world.setBlock(i, j + 3, k + 2, NovaCraftBlocks.basal_bricks, 0, 2);
		world.setBlock(i + 1, j + 3, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 3, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 3, k + 2, NovaCraftBlocks.basal_bricks, 0, 2);
		world.setBlock(i, j + 3, k + 3, NovaCraftBlocks.basal_bricks, 0, 2);
		world.setBlock(i + 1, j + 3, k + 3, NovaCraftBlocks.basal_bricks, 0, 2);
		world.setBlock(i + 2, j + 3, k + 3, NovaCraftBlocks.cracked_basal_bricks, 0, 2);
		world.setBlock(i + 3, j + 3, k + 3, NovaCraftBlocks.basal_bricks, 0, 2);
		
		return true;
	}

}
