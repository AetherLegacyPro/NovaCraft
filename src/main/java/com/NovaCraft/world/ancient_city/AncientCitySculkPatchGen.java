package com.NovaCraft.world.ancient_city;

import net.minecraft.world.gen.feature.*;
import net.minecraft.block.*;
import net.minecraft.world.*;
import java.util.*;

import com.NovaCraft.registry.OtherModBlocks;
import com.NovaCraftBlocks.NovaCraftBlocks;

import cpw.mods.fml.common.Loader;
import net.minecraft.init.*;

public class AncientCitySculkPatchGen extends WorldGenerator
{
	public AncientCitySculkPatchGen() {

	}
	
	private static final Block grimstone = NovaCraftBlocks.grimstone;
	private static final Block sculk_grimstone = NovaCraftBlocks.sculk_grimstone;
	private static final Block sculk_block = NovaCraftBlocks.sculk_block;
	private static final Block sculk_tulip = NovaCraftBlocks.sculk_tulip;
	private static final Block sculk_tendrils = NovaCraftBlocks.sculk_tendrils;
    
    public boolean generate(final World world, final Random random, final int i, final int j, final int k) {
    	
    	world.setBlock(i + 6, j + 0, k + 0, grimstone, 0, 2);
		world.setBlock(i + 9, j + 0, k + 0, grimstone, 0, 2);
		world.setBlock(i + 4, j + 0, k + 1, grimstone, 0, 2);
		world.setBlock(i + 6, j + 0, k + 1, sculk_grimstone, 0, 2);
		world.setBlock(i + 7, j + 0, k + 1, sculk_grimstone, 0, 2);
		world.setBlock(i + 8, j + 0, k + 1, sculk_grimstone, 0, 2);
		world.setBlock(i + 11, j + 0, k + 1, grimstone, 0, 2);
		world.setBlock(i + 2, j + 0, k + 2, grimstone, 0, 2);
		world.setBlock(i + 5, j + 0, k + 2, sculk_grimstone, 0, 2);
		world.setBlock(i + 6, j + 0, k + 2, sculk_block, 0, 2);
		world.setBlock(i + 7, j + 0, k + 2, sculk_block, 0, 2);
		world.setBlock(i + 8, j + 0, k + 2, sculk_block, 0, 2);
		world.setBlock(i + 9, j + 0, k + 2, sculk_grimstone, 0, 2);
		world.setBlock(i + 4, j + 0, k + 3, sculk_grimstone, 0, 2);
		world.setBlock(i + 5, j + 0, k + 3, sculk_block, 0, 2);
		world.setBlock(i + 6, j + 0, k + 3, sculk_block, 0, 2);
		world.setBlock(i + 7, j + 0, k + 3, sculk_block, 0, 2);
		world.setBlock(i + 8, j + 0, k + 3, sculk_block, 0, 2);
		world.setBlock(i + 9, j + 0, k + 3, sculk_block, 0, 2);
		world.setBlock(i + 10, j + 0, k + 3, sculk_grimstone, 0, 2);
		world.setBlock(i + 0, j + 0, k + 4, grimstone, 0, 2);
		world.setBlock(i + 3, j + 0, k + 4, sculk_grimstone, 0, 2);
		world.setBlock(i + 4, j + 0, k + 4, sculk_block, 0, 2);
		world.setBlock(i + 5, j + 0, k + 4, sculk_block, 0, 2);
		world.setBlock(i + 6, j + 0, k + 4, sculk_block, 0, 2);
		world.setBlock(i + 7, j + 0, k + 4, sculk_block, 0, 2);
		world.setBlock(i + 8, j + 0, k + 4, sculk_block, 0, 2);
		world.setBlock(i + 9, j + 0, k + 4, sculk_block, 0, 2);
		world.setBlock(i + 10, j + 0, k + 4, sculk_grimstone, 0, 2);
		world.setBlock(i + 11, j + 0, k + 4, grimstone, 0, 2);
		world.setBlock(i + 3, j + 0, k + 5, sculk_grimstone, 0, 2);
		world.setBlock(i + 4, j + 0, k + 5, sculk_block, 0, 2);
		world.setBlock(i + 5, j + 0, k + 5, sculk_block, 0, 2);
		world.setBlock(i + 6, j + 0, k + 5, sculk_block, 0, 2);
		world.setBlock(i + 7, j + 0, k + 5, sculk_block, 0, 2);
		world.setBlock(i + 8, j + 0, k + 5, sculk_grimstone, 0, 2);
		world.setBlock(i + 9, j + 0, k + 5, sculk_grimstone, 0, 2);
		world.setBlock(i + 2, j + 0, k + 6, sculk_grimstone, 0, 2);
		world.setBlock(i + 3, j + 0, k + 6, sculk_block, 0, 2);
		world.setBlock(i + 4, j + 0, k + 6, sculk_block, 0, 2);
		world.setBlock(i + 5, j + 0, k + 6, sculk_block, 0, 2);
		world.setBlock(i + 6, j + 0, k + 6, sculk_block, 0, 2);
		world.setBlock(i + 7, j + 0, k + 6, sculk_grimstone, 0, 2);
		world.setBlock(i + 11, j + 0, k + 6, grimstone, 0, 2);
		world.setBlock(i + 2, j + 0, k + 7, sculk_grimstone, 0, 2);
		world.setBlock(i + 3, j + 0, k + 7, sculk_block, 0, 2);
		world.setBlock(i + 4, j + 0, k + 7, sculk_block, 0, 2);
		world.setBlock(i + 5, j + 0, k + 7, sculk_block, 0, 2);
		world.setBlock(i + 6, j + 0, k + 7, sculk_block, 0, 2);
		world.setBlock(i + 7, j + 0, k + 7, sculk_grimstone, 0, 2);
		world.setBlock(i + 9, j + 0, k + 7, grimstone, 0, 2);
		world.setBlock(i + 0, j + 0, k + 8, grimstone, 0, 2);
		world.setBlock(i + 3, j + 0, k + 8, sculk_grimstone, 0, 2);
		world.setBlock(i + 4, j + 0, k + 8, sculk_block, 0, 2);
		world.setBlock(i + 5, j + 0, k + 8, sculk_block, 0, 2);
		world.setBlock(i + 6, j + 0, k + 8, sculk_grimstone, 0, 2);
		world.setBlock(i + 3, j + 0, k + 9, sculk_grimstone, 0, 2);
		world.setBlock(i + 4, j + 0, k + 9, sculk_block, 0, 2);
		world.setBlock(i + 5, j + 0, k + 9, sculk_block, 0, 2);
		world.setBlock(i + 6, j + 0, k + 9, sculk_grimstone, 0, 2);
		world.setBlock(i + 8, j + 0, k + 9, grimstone, 0, 2);
		world.setBlock(i + 4, j + 0, k + 10, sculk_grimstone, 0, 2);
		world.setBlock(i + 5, j + 0, k + 10, sculk_grimstone, 0, 2);
		world.setBlock(i + 2, j + 0, k + 11, grimstone, 0, 2);
		world.setBlock(i + 6, j + 0, k + 12, grimstone, 0, 2);
		world.setBlock(i + 6, j + 1, k + 0, NovaCraftBlocks.grim_lichen, 1, 2);
		world.setBlock(i + 9, j + 1, k + 0, NovaCraftBlocks.grim_lichen, 1, 2);
		world.setBlock(i + 4, j + 1, k + 1, NovaCraftBlocks.grim_lichen, 1, 2);
		world.setBlock(i + 11, j + 1, k + 1, NovaCraftBlocks.grim_lichen, 1, 2);
		world.setBlock(i + 2, j + 1, k + 2, NovaCraftBlocks.grim_lichen, 1, 2);
		world.setBlock(i + 6, j + 1, k + 2, sculk_tulip, 0, 2);
		world.setBlock(i + 7, j + 1, k + 2, sculk_tendrils, 0, 2);
		world.setBlock(i + 5, j + 1, k + 3, NovaCraftBlocks.sculk_tentacle_2, 1, 2);
		world.setBlock(i + 7, j + 1, k + 3, NovaCraftBlocks.sculk_tentacle_2, 1, 2);
		world.setBlock(i + 8, j + 1, k + 3, sculk_tendrils, 0, 2);
		world.setBlock(i + 9, j + 1, k + 3, sculk_tulip, 0, 2);
		world.setBlock(i + 0, j + 1, k + 4, NovaCraftBlocks.grim_lichen, 1, 2);
		world.setBlock(i + 5, j + 1, k + 4, sculk_tendrils, 0, 2);
		world.setBlock(i + 7, j + 1, k + 4, NovaCraftBlocks.sculk_tentacle_2, 1, 2);
		world.setBlock(i + 11, j + 1, k + 4, NovaCraftBlocks.grim_lichen, 1, 2);
		world.setBlock(i + 5, j + 1, k + 5, sculk_tulip, 0, 2);
		world.setBlock(i + 3, j + 1, k + 6, NovaCraftBlocks.sculk_tentacle_2, 1, 2);
		world.setBlock(i + 6, j + 1, k + 6, sculk_tendrils, 0, 2);
		world.setBlock(i + 11, j + 1, k + 6, NovaCraftBlocks.grim_lichen, 1, 2);
		world.setBlock(i + 4, j + 1, k + 7, sculk_tendrils, 0, 2);
		world.setBlock(i + 9, j + 1, k + 7, NovaCraftBlocks.grim_lichen, 1, 2);
		world.setBlock(i + 0, j + 1, k + 8, NovaCraftBlocks.grim_lichen, 1, 2);
		world.setBlock(i + 5, j + 1, k + 8, NovaCraftBlocks.sculk_tentacle_2, 1, 2);
		world.setBlock(i + 8, j + 1, k + 9, NovaCraftBlocks.grim_lichen, 1, 2);
		world.setBlock(i + 2, j + 1, k + 11, NovaCraftBlocks.grim_lichen, 1, 2);
		world.setBlock(i + 6, j + 1, k + 12, NovaCraftBlocks.grim_lichen, 1, 2);
		world.setBlock(i + 7, j + 2, k + 2, sculk_tendrils, 0, 2);
		world.setBlock(i + 5, j + 2, k + 4, sculk_tendrils, 0, 2);
		world.setBlock(i + 4, j + 2, k + 7, sculk_tendrils, 0, 2);
		world.setBlock(i + 5, j + 3, k + 4, sculk_tendrils, 0, 2);
    	
    	return true;
    	
    }

}
