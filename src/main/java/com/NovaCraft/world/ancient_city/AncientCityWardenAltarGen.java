package com.NovaCraft.world.ancient_city;

import net.minecraft.world.gen.feature.*;
import net.minecraft.block.*;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.world.*;
import java.util.*;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.config.Configs;
import com.NovaCraft.entity.EntityWardenVessel;
import com.NovaCraft.registry.OtherModBlocks;
import com.NovaCraft.registry.OtherModItems;
import com.NovaCraftBlocks.NovaCraftBlocks;

import cpw.mods.fml.common.Loader;
import net.minecraft.init.*;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.MathHelper;

public class AncientCityWardenAltarGen extends WorldGenerator
{
	public AncientCityWardenAltarGen() {

	}
	
	private static final Block sculk_block = NovaCraftBlocks.sculk_block;
	
	 public boolean generate(final World world, final Random random, final int i, final int j, final int k) {
		 
		 	world.setBlock(i + 22, j + 0, k + 22, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 24, j + 0, k + 22, NovaCraftBlocks.nullstone_tiled_stairs, 1, 2);
			world.setBlock(i + 22, j + 0, k + 23, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 23, j + 0, k + 23, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 24, j + 0, k + 23, NovaCraftBlocks.nullstone_tiled_stairs, 1, 2);
			world.setBlock(i + 22, j + 0, k + 24, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 23, j + 0, k + 24, sculk_block, 0, 2);
			world.setBlock(i + 22, j + 1, k + 21, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 23, j + 1, k + 21, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 20, j + 1, k + 22, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 21, j + 1, k + 22, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 22, j + 1, k + 22, NovaCraftBlocks.nullstone_tiled_stairs, 1, 2);
			world.setBlock(i + 20, j + 1, k + 23, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 21, j + 1, k + 23, sculk_block, 0, 2);
			world.setBlock(i + 22, j + 1, k + 23, NovaCraftBlocks.nullstone_tiled_stairs, 1, 2);
			world.setBlock(i + 20, j + 1, k + 24, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 22, j + 1, k + 24, NovaCraftBlocks.nullstone_tiled_stairs, 1, 2);
			world.setBlock(i + 22, j + 1, k + 25, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 23, j + 1, k + 25, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 20, j + 2, k + 21, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 21, j + 2, k + 21, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 22, j + 2, k + 21, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 23, j + 2, k + 21, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 18, j + 2, k + 22, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 19, j + 2, k + 22, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 20, j + 2, k + 22, NovaCraftBlocks.nullstone_tiled_stairs, 1, 2);
			world.setBlock(i + 18, j + 2, k + 23, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 19, j + 2, k + 23, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 20, j + 2, k + 23, NovaCraftBlocks.nullstone_tiled_stairs, 1, 2);
			world.setBlock(i + 18, j + 2, k + 24, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 20, j + 2, k + 24, NovaCraftBlocks.nullstone_tiled_stairs, 1, 2);
			world.setBlock(i + 20, j + 2, k + 25, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 21, j + 2, k + 25, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 22, j + 2, k + 25, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 23, j + 2, k + 25, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 18, j + 3, k + 21, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 19, j + 3, k + 21, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 20, j + 3, k + 21, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 21, j + 3, k + 21, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 22, j + 3, k + 21, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 16, j + 3, k + 22, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 17, j + 3, k + 22, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 18, j + 3, k + 22, NovaCraftBlocks.nullstone_tiled_stairs, 1, 2);
			world.setBlock(i + 16, j + 3, k + 23, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 17, j + 3, k + 23, sculk_block, 0, 2);
			world.setBlock(i + 16, j + 3, k + 24, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 18, j + 3, k + 25, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 19, j + 3, k + 25, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 20, j + 3, k + 25, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 21, j + 3, k + 25, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 22, j + 3, k + 25, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 16, j + 4, k + 21, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 17, j + 4, k + 21, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 18, j + 4, k + 21, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 19, j + 4, k + 21, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 20, j + 4, k + 21, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 14, j + 4, k + 22, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 16, j + 4, k + 22, NovaCraftBlocks.nullstone_tiled_stairs, 1, 2);
			world.setBlock(i + 14, j + 4, k + 23, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 15, j + 4, k + 23, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 16, j + 4, k + 23, NovaCraftBlocks.nullstone_tiled_stairs, 1, 2);
			world.setBlock(i + 14, j + 4, k + 24, sculk_block, 0, 2);
			world.setBlock(i + 16, j + 4, k + 24, NovaCraftBlocks.nullstone_tiled_stairs, 1, 2);
			world.setBlock(i + 16, j + 4, k + 25, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 17, j + 4, k + 25, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 18, j + 4, k + 25, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 19, j + 4, k + 25, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 20, j + 4, k + 25, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 6, j + 5, k + 14, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 7, j + 5, k + 14, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 8, j + 5, k + 14, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 5, k + 15, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 7, j + 5, k + 15, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 8, j + 5, k + 15, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 1, j + 5, k + 16, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 3, j + 5, k + 16, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 4, j + 5, k + 16, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 5, j + 5, k + 16, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 5, k + 16, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 7, j + 5, k + 16, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 8, j + 5, k + 16, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 9, j + 5, k + 16, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 10, j + 5, k + 16, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 11, j + 5, k + 16, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 12, j + 5, k + 16, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 0, j + 5, k + 17, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 1, j + 5, k + 17, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 2, j + 5, k + 17, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 3, j + 5, k + 17, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 4, j + 5, k + 17, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 6, j + 5, k + 17, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 7, j + 5, k + 17, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 8, j + 5, k + 17, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 9, j + 5, k + 17, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 11, j + 5, k + 17, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 12, j + 5, k + 17, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 13, j + 5, k + 17, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 0, j + 5, k + 18, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 1, j + 5, k + 18, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 2, j + 5, k + 18, sculk_block, 0, 2);
			world.setBlock(i + 3, j + 5, k + 18, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 4, j + 5, k + 18, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 5, j + 5, k + 18, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 5, k + 18, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 7, j + 5, k + 18, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 8, j + 5, k + 18, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 9, j + 5, k + 18, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 10, j + 5, k + 18, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 11, j + 5, k + 18, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 13, j + 5, k + 18, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 0, j + 5, k + 19, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 1, j + 5, k + 19, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 2, j + 5, k + 19, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 3, j + 5, k + 19, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 4, j + 5, k + 19, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 5, j + 5, k + 19, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 5, k + 19, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 7, j + 5, k + 19, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 8, j + 5, k + 19, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 9, j + 5, k + 19, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 10, j + 5, k + 19, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 11, j + 5, k + 19, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 12, j + 5, k + 19, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 13, j + 5, k + 19, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 0, j + 5, k + 20, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 1, j + 5, k + 20, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 2, j + 5, k + 20, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 3, j + 5, k + 20, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 4, j + 5, k + 20, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 5, j + 5, k + 20, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 6, j + 5, k + 20, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 7, j + 5, k + 20, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 8, j + 5, k + 20, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 9, j + 5, k + 20, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 10, j + 5, k + 20, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 11, j + 5, k + 20, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 12, j + 5, k + 20, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 13, j + 5, k + 20, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 0, j + 5, k + 21, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 2, j + 5, k + 21, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 3, j + 5, k + 21, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 4, j + 5, k + 21, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 5, j + 5, k + 21, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 5, k + 21, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 7, j + 5, k + 21, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 8, j + 5, k + 21, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 9, j + 5, k + 21, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 10, j + 5, k + 21, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 11, j + 5, k + 21, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 12, j + 5, k + 21, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 13, j + 5, k + 21, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 14, j + 5, k + 21, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 15, j + 5, k + 21, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 16, j + 5, k + 21, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 17, j + 5, k + 21, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 18, j + 5, k + 21, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 0, j + 5, k + 22, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 2, j + 5, k + 22, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 3, j + 5, k + 22, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 4, j + 5, k + 22, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 5, j + 5, k + 22, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 6, j + 5, k + 22, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 7, j + 5, k + 22, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 8, j + 5, k + 22, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 9, j + 5, k + 22, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 10, j + 5, k + 22, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 11, j + 5, k + 22, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 12, j + 5, k + 22, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 13, j + 5, k + 22, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 14, j + 5, k + 22, NovaCraftBlocks.nullstone_tiled_stairs, 1, 2);
			world.setBlock(i + 0, j + 5, k + 23, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 1, j + 5, k + 23, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 2, j + 5, k + 23, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 3, j + 5, k + 23, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 4, j + 5, k + 23, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 5, j + 5, k + 23, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 6, j + 5, k + 23, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 7, j + 5, k + 23, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 8, j + 5, k + 23, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 9, j + 5, k + 23, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 10, j + 5, k + 23, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 11, j + 5, k + 23, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 12, j + 5, k + 23, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 13, j + 5, k + 23, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 14, j + 5, k + 23, NovaCraftBlocks.nullstone_tiled_stairs, 1, 2);
			world.setBlock(i + 0, j + 5, k + 24, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 1, j + 5, k + 24, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 2, j + 5, k + 24, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 3, j + 5, k + 24, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 4, j + 5, k + 24, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 5, j + 5, k + 24, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 5, k + 24, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 7, j + 5, k + 24, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 8, j + 5, k + 24, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 9, j + 5, k + 24, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 10, j + 5, k + 24, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 11, j + 5, k + 24, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 13, j + 5, k + 24, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 0, j + 5, k + 25, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 1, j + 5, k + 25, sculk_block, 0, 2);
			world.setBlock(i + 2, j + 5, k + 25, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 3, j + 5, k + 25, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 4, j + 5, k + 25, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 5, j + 5, k + 25, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 6, j + 5, k + 25, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 7, j + 5, k + 25, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 8, j + 5, k + 25, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 9, j + 5, k + 25, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 10, j + 5, k + 25, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 11, j + 5, k + 25, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 12, j + 5, k + 25, sculk_block, 0, 2);
			world.setBlock(i + 13, j + 5, k + 25, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 14, j + 5, k + 25, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 15, j + 5, k + 25, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 16, j + 5, k + 25, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 17, j + 5, k + 25, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 18, j + 5, k + 25, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 0, j + 5, k + 26, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 1, j + 5, k + 26, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 2, j + 5, k + 26, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 3, j + 5, k + 26, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 4, j + 5, k + 26, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 5, j + 5, k + 26, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 5, k + 26, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 7, j + 5, k + 26, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 8, j + 5, k + 26, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 9, j + 5, k + 26, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 10, j + 5, k + 26, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 11, j + 5, k + 26, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 12, j + 5, k + 26, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 13, j + 5, k + 26, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 0, j + 5, k + 27, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 2, j + 5, k + 27, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 3, j + 5, k + 27, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 4, j + 5, k + 27, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 5, j + 5, k + 27, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 5, k + 27, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 7, j + 5, k + 27, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 8, j + 5, k + 27, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 9, j + 5, k + 27, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 10, j + 5, k + 27, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 11, j + 5, k + 27, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 12, j + 5, k + 27, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 13, j + 5, k + 27, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 1, j + 5, k + 28, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 3, j + 5, k + 28, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 4, j + 5, k + 28, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 5, j + 5, k + 28, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 5, k + 28, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 7, j + 5, k + 28, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 8, j + 5, k + 28, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 9, j + 5, k + 28, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 10, j + 5, k + 28, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 11, j + 5, k + 28, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 13, j + 5, k + 28, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 0, j + 5, k + 29, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 1, j + 5, k + 29, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 2, j + 5, k + 29, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 3, j + 5, k + 29, sculk_block, 0, 2);
			world.setBlock(i + 4, j + 5, k + 29, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 5, j + 5, k + 29, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 7, j + 5, k + 29, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 8, j + 5, k + 29, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 9, j + 5, k + 29, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 11, j + 5, k + 29, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 12, j + 5, k + 29, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 13, j + 5, k + 29, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 1, j + 5, k + 30, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 2, j + 5, k + 30, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 3, j + 5, k + 30, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 4, j + 5, k + 30, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 5, j + 5, k + 30, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 7, j + 5, k + 30, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 8, j + 5, k + 30, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 9, j + 5, k + 30, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 10, j + 5, k + 30, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 11, j + 5, k + 30, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 12, j + 5, k + 30, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 6, j + 5, k + 31, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 7, j + 5, k + 31, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 8, j + 5, k + 31, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 5, k + 32, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 7, j + 5, k + 32, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 8, j + 5, k + 32, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 6, k + 12, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 7, j + 6, k + 12, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 8, j + 6, k + 12, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 6, k + 13, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 7, j + 6, k + 13, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 8, j + 6, k + 13, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 6, j + 6, k + 14, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 7, j + 6, k + 14, NovaCraftBlocks.nullstone_tiled_stairs, 3, 2);
			world.setBlock(i + 8, j + 6, k + 14, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 6, j + 6, k + 15, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 8, j + 6, k + 15, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 1, j + 6, k + 16, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 3, j + 6, k + 16, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 4, j + 6, k + 16, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 5, j + 6, k + 16, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 6, j + 6, k + 16, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 8, j + 6, k + 16, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 9, j + 6, k + 16, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 10, j + 6, k + 16, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 11, j + 6, k + 16, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 12, j + 6, k + 16, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 0, j + 6, k + 17, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 1, j + 6, k + 17, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 12, j + 6, k + 17, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 13, j + 6, k + 17, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 0, j + 6, k + 18, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 13, j + 6, k + 18, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 0, j + 6, k + 19, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 3, j + 6, k + 19, NovaCraftBlocks.crystallized_end, 0, 2);
			world.setBlock(i + 4, j + 6, k + 19, NovaCraftBlocks.nullstone, 0, 2);
			world.setBlock(i + 5, j + 6, k + 19, NovaCraftBlocks.nullstone, 0, 2);
			world.setBlock(i + 6, j + 6, k + 19, NovaCraftBlocks.nullstone, 0, 2);
			world.setBlock(i + 8, j + 6, k + 19, NovaCraftBlocks.nullstone, 0, 2);
			world.setBlock(i + 9, j + 6, k + 19, NovaCraftBlocks.nullstone, 0, 2);
			world.setBlock(i + 10, j + 6, k + 19, NovaCraftBlocks.nullstone, 0, 2);
			world.setBlock(i + 11, j + 6, k + 19, NovaCraftBlocks.crystallized_end, 0, 2);
			world.setBlock(i + 13, j + 6, k + 19, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 0, j + 6, k + 20, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 3, j + 6, k + 20, NovaCraftBlocks.nullstone, 0, 2);
			world.setBlock(i + 4, j + 6, k + 20, sculk_block, 0, 2);
			world.setBlock(i + 5, j + 6, k + 20, sculk_block, 0, 2);
			world.setBlock(i + 6, j + 6, k + 20, sculk_block, 0, 2);
			world.setBlock(i + 7, j + 6, k + 20, sculk_block, 0, 2);
			world.setBlock(i + 8, j + 6, k + 20, sculk_block, 0, 2);
			world.setBlock(i + 9, j + 6, k + 20, sculk_block, 0, 2);
			world.setBlock(i + 10, j + 6, k + 20, sculk_block, 0, 2);
			world.setBlock(i + 11, j + 6, k + 20, NovaCraftBlocks.nullstone, 0, 2);
			world.setBlock(i + 13, j + 6, k + 20, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 0, j + 6, k + 21, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 3, j + 6, k + 21, NovaCraftBlocks.nullstone, 0, 2);
			world.setBlock(i + 4, j + 6, k + 21, sculk_block, 0, 2);
			world.setBlock(i + 5, j + 6, k + 21, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 6, j + 6, k + 21, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 9, j + 6, k + 21, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 10, j + 6, k + 21, sculk_block, 0, 2);
			world.setBlock(i + 11, j + 6, k + 21, NovaCraftBlocks.nullstone, 0, 2);
			world.setBlock(i + 13, j + 6, k + 21, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 14, j + 6, k + 21, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 15, j + 6, k + 21, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 16, j + 6, k + 21, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 3, j + 6, k + 22, NovaCraftBlocks.nullstone, 0, 2);
			world.setBlock(i + 4, j + 6, k + 22, sculk_block, 0, 2);
			world.setBlock(i + 6, j + 6, k + 22, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 7, j + 6, k + 22, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 8, j + 6, k + 22, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 9, j + 6, k + 22, NovaCraftBlocks.budding_echo_block, 0, 2);
			world.setBlock(i + 10, j + 6, k + 22, sculk_block, 0, 2);
			world.setBlock(i + 11, j + 6, k + 22, NovaCraftBlocks.nullstone, 0, 2);
			world.setBlock(i + 0, j + 6, k + 23, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 3, j + 6, k + 23, NovaCraftBlocks.block_of_vanite, 0, 2);
			world.setBlock(i + 4, j + 6, k + 23, sculk_block, 0, 2);
			world.setBlock(i + 6, j + 6, k + 23, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 7, j + 6, k + 23, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 8, j + 6, k + 23, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 10, j + 6, k + 23, sculk_block, 0, 2);
			world.setBlock(i + 11, j + 6, k + 23, NovaCraftBlocks.crystallized_end, 0, 2);
			world.setBlock(i + 0, j + 6, k + 24, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 3, j + 6, k + 24, NovaCraftBlocks.nullstone, 0, 2);
			world.setBlock(i + 4, j + 6, k + 24, sculk_block, 0, 2);
			world.setBlock(i + 6, j + 6, k + 24, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 7, j + 6, k + 24, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 8, j + 6, k + 24, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 10, j + 6, k + 24, sculk_block, 0, 2);
			world.setBlock(i + 11, j + 6, k + 24, NovaCraftBlocks.nullstone, 0, 2);
			world.setBlock(i + 0, j + 6, k + 25, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 3, j + 6, k + 25, NovaCraftBlocks.nullstone, 0, 2);
			world.setBlock(i + 4, j + 6, k + 25, sculk_block, 0, 2);
			world.setBlock(i + 5, j + 6, k + 25, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 7, j + 6, k + 25, NovaCraftBlocks.budding_echo_block, 0, 2);
			world.setBlock(i + 9, j + 6, k + 25, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 10, j + 6, k + 25, sculk_block, 0, 2);
			world.setBlock(i + 11, j + 6, k + 25, NovaCraftBlocks.nullstone, 0, 2);
			world.setBlock(i + 13, j + 6, k + 25, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 14, j + 6, k + 25, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 15, j + 6, k + 25, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 16, j + 6, k + 25, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 0, j + 6, k + 26, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 3, j + 6, k + 26, NovaCraftBlocks.nullstone, 0, 2);
			world.setBlock(i + 4, j + 6, k + 26, sculk_block, 0, 2);
			world.setBlock(i + 5, j + 6, k + 26, sculk_block, 0, 2);
			world.setBlock(i + 6, j + 6, k + 26, sculk_block, 0, 2);
			world.setBlock(i + 7, j + 6, k + 26, sculk_block, 0, 2);
			world.setBlock(i + 8, j + 6, k + 26, sculk_block, 0, 2);
			world.setBlock(i + 9, j + 6, k + 26, sculk_block, 0, 2);
			world.setBlock(i + 10, j + 6, k + 26, sculk_block, 0, 2);
			world.setBlock(i + 11, j + 6, k + 26, NovaCraftBlocks.nullstone, 0, 2);
			world.setBlock(i + 13, j + 6, k + 26, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 0, j + 6, k + 27, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 3, j + 6, k + 27, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 4, j + 6, k + 27, NovaCraftBlocks.nullstone, 0, 2);
			world.setBlock(i + 5, j + 6, k + 27, NovaCraftBlocks.nullstone, 0, 2);
			world.setBlock(i + 6, j + 6, k + 27, NovaCraftBlocks.nullstone, 0, 2);
			world.setBlock(i + 7, j + 6, k + 27, NovaCraftBlocks.crystallized_end, 0, 2);
			world.setBlock(i + 8, j + 6, k + 27, NovaCraftBlocks.nullstone, 0, 2);
			world.setBlock(i + 9, j + 6, k + 27, NovaCraftBlocks.nullstone, 0, 2);
			world.setBlock(i + 10, j + 6, k + 27, NovaCraftBlocks.nullstone, 0, 2);
			world.setBlock(i + 11, j + 6, k + 27, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 13, j + 6, k + 27, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 13, j + 6, k + 28, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 0, j + 6, k + 29, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 1, j + 6, k + 29, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 12, j + 6, k + 29, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 13, j + 6, k + 29, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 1, j + 6, k + 30, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 2, j + 6, k + 30, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 3, j + 6, k + 30, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 4, j + 6, k + 30, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 5, j + 6, k + 30, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 8, j + 6, k + 30, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 9, j + 6, k + 30, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 10, j + 6, k + 30, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 11, j + 6, k + 30, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 12, j + 6, k + 30, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 6, j + 6, k + 31, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 8, j + 6, k + 31, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 6, j + 6, k + 32, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 7, j + 6, k + 32, NovaCraftBlocks.nullstone_tiled_stairs, 2, 2);
			world.setBlock(i + 8, j + 6, k + 32, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 6, j + 6, k + 33, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 8, j + 6, k + 33, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 6, j + 6, k + 34, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 7, j + 6, k + 34, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 8, j + 6, k + 34, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 7, k + 10, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 7, j + 7, k + 10, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 8, j + 7, k + 10, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 7, j + 7, k + 11, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 8, j + 7, k + 11, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 7, k + 12, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 7, j + 7, k + 12, NovaCraftBlocks.nullstone_tiled_stairs, 3, 2);
			world.setBlock(i + 8, j + 7, k + 12, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 6, j + 7, k + 13, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 8, j + 7, k + 13, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 6, j + 7, k + 14, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 8, j + 7, k + 14, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 3, j + 7, k + 19, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 5, j + 7, k + 19, NovaCraftBlocks.null_wart, 1, 2);
			world.setBlock(i + 8, j + 7, k + 19, NovaCraftBlocks.null_wart, 1, 2);
			world.setBlock(i + 10, j + 7, k + 19, NovaCraftBlocks.null_wart, 1, 2);
			world.setBlock(i + 11, j + 7, k + 19, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 3, j + 7, k + 20, NovaCraftBlocks.null_wart, 1, 2);
			world.setBlock(i + 5, j + 7, k + 20, NovaCraftBlocks.sculk_tentacle_2, 1, 2);
			world.setBlock(i + 6, j + 7, k + 20, NovaCraftBlocks.sculk_tentacle_2, 1, 2);
			world.setBlock(i + 7, j + 7, k + 20, NovaCraftBlocks.sculk_tentacle_2, 1, 2);
			world.setBlock(i + 11, j + 7, k + 20, NovaCraftBlocks.null_wart, 1, 2);
			world.setBlock(i + 5, j + 7, k + 21, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 9, j + 7, k + 21, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 10, j + 7, k + 21, NovaCraftBlocks.sculk_tentacle_2, 1, 2);
			world.setBlock(i + 11, j + 7, k + 21, NovaCraftBlocks.null_wart, 1, 2);
			world.setBlock(i + 3, j + 7, k + 22, NovaCraftBlocks.null_wart, 1, 2);
			world.setBlock(i + 4, j + 7, k + 22, NovaCraftBlocks.sculk_tentacle_2, 1, 2);
			world.setBlock(i + 9, j + 7, k + 22, NovaCraftBlocks.echo_cluster_2, 1, 2);
			world.setBlock(i + 4, j + 7, k + 23, NovaCraftBlocks.sculk_tentacle_2, 1, 2);
			world.setBlock(i + 7, j + 7, k + 23, NovaCraftBlocks.grimstone_shrieker, 0, 2);
			world.setBlock(i + 10, j + 7, k + 23, NovaCraftBlocks.sculk_tentacle_2, 1, 2);
			world.setBlock(i + 3, j + 7, k + 25, NovaCraftBlocks.null_wart, 1, 2);
			world.setBlock(i + 4, j + 7, k + 25, NovaCraftBlocks.sculk_tentacle_2, 1, 2);
			world.setBlock(i + 5, j + 7, k + 25, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 7, j + 7, k + 25, NovaCraftBlocks.echo_cluster_2, 1, 2);
			world.setBlock(i + 9, j + 7, k + 25, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 10, j + 7, k + 25, NovaCraftBlocks.sculk_tentacle_2, 1, 2);
			world.setBlock(i + 11, j + 7, k + 25, NovaCraftBlocks.null_wart, 1, 2);
			world.setBlock(i + 6, j + 7, k + 26, NovaCraftBlocks.sculk_tentacle_2, 1, 2);
			world.setBlock(i + 7, j + 7, k + 26, NovaCraftBlocks.sculk_tentacle_2, 1, 2);
			world.setBlock(i + 10, j + 7, k + 26, NovaCraftBlocks.sculk_tentacle_2, 1, 2);
			world.setBlock(i + 3, j + 7, k + 27, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 4, j + 7, k + 27, NovaCraftBlocks.null_wart, 1, 2);
			world.setBlock(i + 5, j + 7, k + 27, NovaCraftBlocks.null_wart, 1, 2);
			world.setBlock(i + 7, j + 7, k + 27, NovaCraftBlocks.block_of_vanite, 0, 2);
			world.setBlock(i + 8, j + 7, k + 27, NovaCraftBlocks.null_wart, 1, 2);
			world.setBlock(i + 9, j + 7, k + 27, NovaCraftBlocks.null_wart, 1, 2);
			world.setBlock(i + 11, j + 7, k + 27, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 6, j + 7, k + 32, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 8, j + 7, k + 32, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 6, j + 7, k + 33, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 8, j + 7, k + 33, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 6, j + 7, k + 34, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 7, j + 7, k + 34, NovaCraftBlocks.nullstone_tiled_stairs, 2, 2);
			world.setBlock(i + 8, j + 7, k + 34, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 6, j + 7, k + 35, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 7, j + 7, k + 35, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 8, j + 7, k + 35, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 7, k + 36, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 7, j + 7, k + 36, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 8, j + 7, k + 36, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 3, j + 8, k + 0, sculk_block, 0, 2);
			world.setBlock(i + 4, j + 8, k + 0, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 5, j + 8, k + 0, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 6, j + 8, k + 0, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 7, j + 8, k + 0, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 9, j + 8, k + 0, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 10, j + 8, k + 0, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 11, j + 8, k + 0, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 2, j + 8, k + 1, sculk_block, 0, 2);
			world.setBlock(i + 3, j + 8, k + 1, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 5, j + 8, k + 1, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 6, j + 8, k + 1, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 7, j + 8, k + 1, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 8, j + 8, k + 1, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 9, j + 8, k + 1, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 10, j + 8, k + 1, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 11, j + 8, k + 1, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 12, j + 8, k + 1, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 2, j + 8, k + 2, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 3, j + 8, k + 2, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 4, j + 8, k + 2, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 5, j + 8, k + 2, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 8, k + 2, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 7, j + 8, k + 2, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 8, j + 8, k + 2, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 9, j + 8, k + 2, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 10, j + 8, k + 2, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 11, j + 8, k + 2, sculk_block, 0, 2);
			world.setBlock(i + 12, j + 8, k + 2, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 2, j + 8, k + 3, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 3, j + 8, k + 3, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 4, j + 8, k + 3, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 5, j + 8, k + 3, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 8, k + 3, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 7, j + 8, k + 3, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 8, j + 8, k + 3, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 9, j + 8, k + 3, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 10, j + 8, k + 3, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 11, j + 8, k + 3, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 12, j + 8, k + 3, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 4, j + 8, k + 4, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 5, j + 8, k + 4, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 8, k + 4, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 7, j + 8, k + 4, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 8, j + 8, k + 4, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 9, j + 8, k + 4, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 10, j + 8, k + 4, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 11, j + 8, k + 4, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 12, j + 8, k + 4, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 2, j + 8, k + 5, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 3, j + 8, k + 5, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 4, j + 8, k + 5, sculk_block, 0, 2);
			world.setBlock(i + 5, j + 8, k + 5, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 6, j + 8, k + 5, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 7, j + 8, k + 5, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 8, j + 8, k + 5, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 9, j + 8, k + 5, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 10, j + 8, k + 5, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 2, j + 8, k + 6, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 4, j + 8, k + 6, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 5, j + 8, k + 6, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 8, k + 6, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 7, j + 8, k + 6, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 8, j + 8, k + 6, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 10, j + 8, k + 6, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 11, j + 8, k + 6, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 12, j + 8, k + 6, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 3, j + 8, k + 7, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 4, j + 8, k + 7, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 5, j + 8, k + 7, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 6, j + 8, k + 7, sculk_block, 0, 2);
			world.setBlock(i + 7, j + 8, k + 7, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 8, j + 8, k + 7, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 9, j + 8, k + 7, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 10, j + 8, k + 7, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 11, j + 8, k + 7, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 12, j + 8, k + 7, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 2, j + 8, k + 8, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 3, j + 8, k + 8, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 4, j + 8, k + 8, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 5, j + 8, k + 8, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 8, k + 8, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 7, j + 8, k + 8, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 8, j + 8, k + 8, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 10, j + 8, k + 8, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 11, j + 8, k + 8, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 12, j + 8, k + 8, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 3, j + 8, k + 9, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 4, j + 8, k + 9, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 5, j + 8, k + 9, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 8, k + 9, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 7, j + 8, k + 9, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 8, j + 8, k + 9, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 9, j + 8, k + 9, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 10, j + 8, k + 9, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 11, j + 8, k + 9, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 8, k + 10, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 7, j + 8, k + 10, NovaCraftBlocks.nullstone_tiled_stairs, 3, 2);
			world.setBlock(i + 8, j + 8, k + 10, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 8, j + 8, k + 11, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 6, j + 8, k + 12, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 8, j + 8, k + 12, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 3, j + 8, k + 19, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 11, j + 8, k + 19, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 5, j + 8, k + 21, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 9, j + 8, k + 21, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 5, j + 8, k + 25, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 9, j + 8, k + 25, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 3, j + 8, k + 27, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 11, j + 8, k + 27, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 6, j + 8, k + 34, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 8, j + 8, k + 34, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 6, j + 8, k + 35, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 8, j + 8, k + 35, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 6, j + 8, k + 36, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 7, j + 8, k + 36, NovaCraftBlocks.nullstone_tiled_stairs, 2, 2);
			world.setBlock(i + 8, j + 8, k + 36, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 6, j + 8, k + 37, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 7, j + 8, k + 37, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 8, j + 8, k + 37, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 3, j + 8, k + 38, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 4, j + 8, k + 38, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 5, j + 8, k + 38, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 8, k + 38, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 7, j + 8, k + 38, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 8, j + 8, k + 38, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 9, j + 8, k + 38, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 10, j + 8, k + 38, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 11, j + 8, k + 38, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 2, j + 8, k + 39, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 3, j + 8, k + 39, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 4, j + 8, k + 39, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 5, j + 8, k + 39, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 6, j + 8, k + 39, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 8, j + 8, k + 39, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 9, j + 8, k + 39, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 10, j + 8, k + 39, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 11, j + 8, k + 39, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 12, j + 8, k + 39, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 2, j + 8, k + 40, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 4, j + 8, k + 40, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 5, j + 8, k + 40, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 8, k + 40, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 7, j + 8, k + 40, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 8, j + 8, k + 40, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 10, j + 8, k + 40, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 11, j + 8, k + 40, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 12, j + 8, k + 40, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 2, j + 8, k + 41, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 3, j + 8, k + 41, sculk_block, 0, 2);
			world.setBlock(i + 4, j + 8, k + 41, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 5, j + 8, k + 41, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 6, j + 8, k + 41, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 7, j + 8, k + 41, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 8, j + 8, k + 41, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 9, j + 8, k + 41, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 11, j + 8, k + 41, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 12, j + 8, k + 41, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 2, j + 8, k + 42, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 3, j + 8, k + 42, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 4, j + 8, k + 42, sculk_block, 0, 2);
			world.setBlock(i + 5, j + 8, k + 42, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 8, k + 42, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 7, j + 8, k + 42, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 8, j + 8, k + 42, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 9, j + 8, k + 42, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 10, j + 8, k + 42, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 11, j + 8, k + 42, sculk_block, 0, 2);
			world.setBlock(i + 12, j + 8, k + 42, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 2, j + 8, k + 43, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 3, j + 8, k + 43, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 4, j + 8, k + 43, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 5, j + 8, k + 43, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 8, k + 43, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 7, j + 8, k + 43, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 8, j + 8, k + 43, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 9, j + 8, k + 43, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 10, j + 8, k + 43, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 11, j + 8, k + 43, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 12, j + 8, k + 43, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 2, j + 8, k + 44, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 3, j + 8, k + 44, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 4, j + 8, k + 44, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 5, j + 8, k + 44, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 8, k + 44, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 7, j + 8, k + 44, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 8, j + 8, k + 44, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 9, j + 8, k + 44, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 10, j + 8, k + 44, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 11, j + 8, k + 44, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 12, j + 8, k + 44, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 2, j + 8, k + 45, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 3, j + 8, k + 45, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 5, j + 8, k + 45, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 6, j + 8, k + 45, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 7, j + 8, k + 45, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 8, j + 8, k + 45, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 9, j + 8, k + 45, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 11, j + 8, k + 45, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 12, j + 8, k + 45, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 3, j + 8, k + 46, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 4, j + 8, k + 46, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 5, j + 8, k + 46, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 6, j + 8, k + 46, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 7, j + 8, k + 46, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 8, j + 8, k + 46, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 9, j + 8, k + 46, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 10, j + 8, k + 46, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 11, j + 8, k + 46, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 3, j + 9, k + 0, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 4, j + 9, k + 0, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 5, j + 9, k + 0, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 6, j + 9, k + 0, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 7, j + 9, k + 0, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 9, j + 9, k + 0, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 10, j + 9, k + 0, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 2, j + 9, k + 1, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 3, j + 9, k + 1, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 11, j + 9, k + 1, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 12, j + 9, k + 1, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 2, j + 9, k + 2, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 5, j + 9, k + 2, NovaCraftBlocks.sculk_tiled_slab, 0, 2);
			world.setBlock(i + 6, j + 9, k + 2, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 7, j + 9, k + 2, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 8, j + 9, k + 2, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 9, j + 9, k + 2, NovaCraftBlocks.sculk_tiled_slab, 0, 2);
			world.setBlock(i + 12, j + 9, k + 2, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 2, j + 9, k + 3, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 4, j + 9, k + 3, NovaCraftBlocks.sculk_tiled_slab, 0, 2);
			world.setBlock(i + 5, j + 9, k + 3, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 6, j + 9, k + 3, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 7, j + 9, k + 3, NovaCraftBlocks.sculk_tiles, 0, 2);
			world.setBlock(i + 8, j + 9, k + 3, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 9, j + 9, k + 3, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 10, j + 9, k + 3, NovaCraftBlocks.sculk_tiled_slab, 0, 2);
			world.setBlock(i + 12, j + 9, k + 3, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 5, j + 9, k + 4, NovaCraftBlocks.sculk_tiled_slab, 0, 2);
			world.setBlock(i + 6, j + 9, k + 4, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 7, j + 9, k + 4, NovaCraftBlocks.sculk_tiled_slab, 0, 2);
			world.setBlock(i + 8, j + 9, k + 4, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 9, j + 9, k + 4, NovaCraftBlocks.sculk_tiled_slab, 0, 2);
			world.setBlock(i + 12, j + 9, k + 4, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 2, j + 9, k + 5, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 6, j + 9, k + 5, NovaCraftBlocks.sculk_tiled_slab, 0, 2);
			world.setBlock(i + 8, j + 9, k + 5, NovaCraftBlocks.sculk_tiled_slab, 0, 2);
			world.setBlock(i + 2, j + 9, k + 6, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 12, j + 9, k + 6, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 2, j + 9, k + 7, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 4, j + 9, k + 7, NovaCraftBlocks.sculk_tiles, 0, 2);
			world.setBlock(i + 10, j + 9, k + 7, NovaCraftBlocks.sculk_tiles, 0, 2);
			world.setBlock(i + 12, j + 9, k + 7, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 2, j + 9, k + 8, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 3, j + 9, k + 8, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 11, j + 9, k + 8, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 12, j + 9, k + 8, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 3, j + 9, k + 9, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 4, j + 9, k + 9, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 5, j + 9, k + 9, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 6, j + 9, k + 9, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 8, j + 9, k + 9, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 9, j + 9, k + 9, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 10, j + 9, k + 9, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 11, j + 9, k + 9, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 6, j + 9, k + 10, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 8, j + 9, k + 10, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 3, j + 9, k + 19, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 11, j + 9, k + 19, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 5, j + 9, k + 20, NovaCraftBlocks.null_cluster_2, 2, 2);
			world.setBlock(i + 4, j + 9, k + 21, NovaCraftBlocks.null_cluster_2, 4, 2);
			world.setBlock(i + 5, j + 9, k + 21, NovaCraftBlocks.budding_null_block, 0, 2);
			world.setBlock(i + 6, j + 9, k + 21, NovaCraftBlocks.null_cluster_2, 5, 2);
			world.setBlock(i + 5, j + 9, k + 22, NovaCraftBlocks.null_cluster_2, 3, 2);
			world.setBlock(i + 9, j + 9, k + 25, NovaCraftBlocks.budding_null_block, 0, 2);
			world.setBlock(i + 6, j + 9, k + 36, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 8, j + 9, k + 36, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 6, j + 9, k + 37, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 8, j + 9, k + 37, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 3, j + 9, k + 38, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 4, j + 9, k + 38, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 5, j + 9, k + 38, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 6, j + 9, k + 38, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 8, j + 9, k + 38, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 9, j + 9, k + 38, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 10, j + 9, k + 38, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 11, j + 9, k + 38, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 2, j + 9, k + 39, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 3, j + 9, k + 39, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 11, j + 9, k + 39, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 12, j + 9, k + 39, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 2, j + 9, k + 40, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 4, j + 9, k + 40, NovaCraftBlocks.sculk_tiled_wall, 0, 2);
			world.setBlock(i + 10, j + 9, k + 40, NovaCraftBlocks.sculk_tiled_wall, 0, 2);
			world.setBlock(i + 12, j + 9, k + 40, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 2, j + 9, k + 41, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 6, j + 9, k + 41, NovaCraftBlocks.sculk_tiled_slab, 0, 2);
			world.setBlock(i + 8, j + 9, k + 41, NovaCraftBlocks.sculk_tiled_slab, 0, 2);
			world.setBlock(i + 12, j + 9, k + 41, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 2, j + 9, k + 42, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 5, j + 9, k + 42, NovaCraftBlocks.sculk_tiled_slab, 0, 2);
			world.setBlock(i + 6, j + 9, k + 42, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 7, j + 9, k + 42, NovaCraftBlocks.sculk_tiled_slab, 0, 2);
			world.setBlock(i + 8, j + 9, k + 42, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 9, j + 9, k + 42, NovaCraftBlocks.sculk_tiled_slab, 0, 2);
			world.setBlock(i + 12, j + 9, k + 42, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 2, j + 9, k + 43, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 4, j + 9, k + 43, NovaCraftBlocks.sculk_tiled_slab, 0, 2);
			world.setBlock(i + 5, j + 9, k + 43, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 6, j + 9, k + 43, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 7, j + 9, k + 43, NovaCraftBlocks.sculk_tiles, 0, 2);
			world.setBlock(i + 8, j + 9, k + 43, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 9, j + 9, k + 43, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 10, j + 9, k + 43, NovaCraftBlocks.sculk_tiled_slab, 0, 2);
			world.setBlock(i + 12, j + 9, k + 43, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 2, j + 9, k + 44, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 5, j + 9, k + 44, NovaCraftBlocks.sculk_tiled_slab, 0, 2);
			world.setBlock(i + 6, j + 9, k + 44, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 7, j + 9, k + 44, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 8, j + 9, k + 44, NovaCraftBlocks.sculk_bricks, 0, 2);
			world.setBlock(i + 9, j + 9, k + 44, NovaCraftBlocks.sculk_tiled_slab, 0, 2);
			world.setBlock(i + 12, j + 9, k + 44, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 2, j + 9, k + 45, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 3, j + 9, k + 45, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 11, j + 9, k + 45, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 12, j + 9, k + 45, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 3, j + 9, k + 46, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 4, j + 9, k + 46, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 5, j + 9, k + 46, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 6, j + 9, k + 46, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 7, j + 9, k + 46, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 8, j + 9, k + 46, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 9, j + 9, k + 46, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 10, j + 9, k + 46, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 11, j + 9, k + 46, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 6, j + 10, k + 2, NovaCraftBlocks.sculk_tiles, 0, 2);
			world.setBlock(i + 7, j + 10, k + 2, NovaCraftBlocks.sculk_tiles, 0, 2);
			world.setBlock(i + 8, j + 10, k + 2, NovaCraftBlocks.sculk_tiles, 0, 2);
			world.setBlock(i + 5, j + 10, k + 3, NovaCraftBlocks.sculk_tiled_wall, 0, 2);
			world.setBlock(i + 9, j + 10, k + 3, NovaCraftBlocks.sculk_tiled_wall, 0, 2);
			world.setBlock(i + 6, j + 10, k + 4, NovaCraftBlocks.sculk_tiled_wall, 0, 2);
			world.setBlock(i + 8, j + 10, k + 4, NovaCraftBlocks.sculk_tiled_wall, 0, 2);
			if (Configs.enableTreasureCratesDropDiamonds == false) {
			world.setBlock(i + 3, j + 10, k + 19, Blocks.diamond_block, 0, 2);
			}
			world.setBlock(i + 5, j + 10, k + 21, Blocks.air, 0, 2); //1
			world.setBlock(i + 4, j + 10, k + 40, NovaCraftBlocks.dim_vanite_torch, 5, 2);
			world.setBlock(i + 10, j + 10, k + 40, NovaCraftBlocks.dim_vanite_torch, 5, 2);
			world.setBlock(i + 6, j + 10, k + 42, NovaCraftBlocks.sculk_tiled_wall, 0, 2);
			world.setBlock(i + 8, j + 10, k + 42, NovaCraftBlocks.sculk_tiled_wall, 0, 2);
			world.setBlock(i + 5, j + 10, k + 43, NovaCraftBlocks.sculk_tiled_wall, 0, 2);
			world.setBlock(i + 9, j + 10, k + 43, NovaCraftBlocks.sculk_tiled_wall, 0, 2);
			world.setBlock(i + 6, j + 10, k + 44, NovaCraftBlocks.sculk_tiles, 0, 2);
			world.setBlock(i + 7, j + 10, k + 44, NovaCraftBlocks.sculk_tiles, 0, 2);
			world.setBlock(i + 8, j + 10, k + 44, NovaCraftBlocks.sculk_tiles, 0, 2);
			world.setBlock(i + 7, j + 11, k + 2, NovaCraftBlocks.chiseled_sculk, 0, 2);
			world.setBlock(i + 5, j + 11, k + 3, NovaCraftBlocks.sculk_tiled_wall, 0, 2);
			world.setBlock(i + 9, j + 11, k + 3, NovaCraftBlocks.sculk_tiled_wall, 0, 2);
			world.setBlock(i + 6, j + 11, k + 4, NovaCraftBlocks.dim_vanite_torch, 5, 2);
			world.setBlock(i + 8, j + 11, k + 4, NovaCraftBlocks.dim_vanite_torch, 5, 2);
			world.setBlock(i + 6, j + 11, k + 42, NovaCraftBlocks.dim_vanite_torch, 5, 2);
			world.setBlock(i + 8, j + 11, k + 42, NovaCraftBlocks.dim_vanite_torch, 5, 2);
			world.setBlock(i + 5, j + 11, k + 43, NovaCraftBlocks.sculk_tiled_wall, 0, 2);
			world.setBlock(i + 9, j + 11, k + 43, NovaCraftBlocks.sculk_tiled_wall, 0, 2);
			world.setBlock(i + 7, j + 11, k + 44, NovaCraftBlocks.chiseled_sculk, 0, 2);
			
			world.setBlock(i + 12, j + 7, k + 29, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        if ((world.getBlock(i + 12, j + 8, k + 29) == Blocks.air || world.getBlock(i + 12, j + 8, k + 29) == Blocks.gravel) && world.getBlock(i + 12, j + 7, k + 29) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 12, j + 8, k + 29, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 12, j + 9, k + 29) == Blocks.air || world.getBlock(i + 12, j + 9, k + 29) == Blocks.gravel) && world.getBlock(i + 12, j + 8, k + 29) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 12, j + 9, k + 29, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 12, j + 10, k + 29) == Blocks.air || world.getBlock(i + 12, j + 10, k + 29) == Blocks.gravel) && world.getBlock(i + 12, j + 9, k + 29) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 12, j + 10, k + 29, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 12, j + 11, k + 29) == Blocks.air || world.getBlock(i + 12, j + 11, k + 29) == Blocks.gravel) && world.getBlock(i + 12, j + 10, k + 29) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 12, j + 11, k + 29, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 12, j + 12, k + 29) == Blocks.air || world.getBlock(i + 12, j + 12, k + 29) == Blocks.gravel) && world.getBlock(i + 12, j + 11, k + 29) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 12, j + 12, k + 29, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 12, j + 13, k + 29) == Blocks.air || world.getBlock(i + 12, j + 13, k + 29) == Blocks.gravel) && world.getBlock(i + 12, j + 12, k + 29) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 12, j + 13, k + 29, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 12, j + 14, k + 29) == Blocks.air || world.getBlock(i + 12, j + 14, k + 29) == Blocks.gravel) && world.getBlock(i + 12, j + 13, k + 29) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 12, j + 14, k + 29, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 12, j + 15, k + 29) == Blocks.air || world.getBlock(i + 12, j + 15, k + 29) == Blocks.gravel) && world.getBlock(i + 12, j + 14, k + 29) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 12, j + 15, k + 29, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 12, j + 16, k + 29) == Blocks.air || world.getBlock(i + 12, j + 16, k + 29) == Blocks.gravel) && world.getBlock(i + 12, j + 15, k + 29) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 12, j + 16, k + 29, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 12, j + 17, k + 29) == Blocks.air || world.getBlock(i + 12, j + 17, k + 29) == Blocks.gravel) && world.getBlock(i + 12, j + 16, k + 29) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 12, j + 17, k + 29, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 12, j + 18, k + 29) == Blocks.air || world.getBlock(i + 12, j + 18, k + 29) == Blocks.gravel) && world.getBlock(i + 12, j + 17, k + 29) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 12, j + 18, k + 29, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 12, j + 19, k + 29) == Blocks.air || world.getBlock(i + 12, j + 19, k + 29) == Blocks.gravel) && world.getBlock(i + 12, j + 18, k + 29) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 12, j + 19, k + 29, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        
	        
	        world.setBlock(i + 12, j + 7, k + 17, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        if ((world.getBlock(i + 12, j + 8, k + 17) == Blocks.air || world.getBlock(i + 12, j + 8, k + 17) == Blocks.gravel) && world.getBlock(i + 12, j + 7, k + 17) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 12, j + 8, k + 17, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 12, j + 9, k + 17) == Blocks.air || world.getBlock(i + 12, j + 9, k + 17) == Blocks.gravel) && world.getBlock(i + 12, j + 8, k + 17) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 12, j + 9, k + 17, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 12, j + 10, k + 17) == Blocks.air || world.getBlock(i + 12, j + 10, k + 17) == Blocks.gravel) && world.getBlock(i + 12, j + 9, k + 17) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 12, j + 10, k + 17, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 12, j + 11, k + 17) == Blocks.air || world.getBlock(i + 12, j + 11, k + 17) == Blocks.gravel) && world.getBlock(i + 12, j + 10, k + 17) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 12, j + 11, k + 17, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 12, j + 12, k + 17) == Blocks.air || world.getBlock(i + 12, j + 12, k + 17) == Blocks.gravel) && world.getBlock(i + 12, j + 11, k + 17) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 12, j + 12, k + 17, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 12, j + 13, k + 17) == Blocks.air || world.getBlock(i + 12, j + 13, k + 17) == Blocks.gravel) && world.getBlock(i + 12, j + 12, k + 17) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 12, j + 13, k + 17, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 12, j + 14, k + 17) == Blocks.air || world.getBlock(i + 12, j + 14, k + 17) == Blocks.gravel) && world.getBlock(i + 12, j + 13, k + 17) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 12, j + 14, k + 17, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 12, j + 15, k + 17) == Blocks.air || world.getBlock(i + 12, j + 15, k + 17) == Blocks.gravel) && world.getBlock(i + 12, j + 14, k + 17) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 12, j + 15, k + 17, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 12, j + 16, k + 17) == Blocks.air || world.getBlock(i + 12, j + 16, k + 17) == Blocks.gravel) && world.getBlock(i + 12, j + 15, k + 17) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 12, j + 16, k + 17, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 12, j + 17, k + 17) == Blocks.air || world.getBlock(i + 12, j + 17, k + 17) == Blocks.gravel) && world.getBlock(i + 12, j + 16, k + 17) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 12, j + 17, k + 17, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 12, j + 18, k + 17) == Blocks.air || world.getBlock(i + 12, j + 18, k + 17) == Blocks.gravel) && world.getBlock(i + 12, j + 17, k + 17) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 12, j + 18, k + 17, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 12, j + 19, k + 17) == Blocks.air || world.getBlock(i + 12, j + 19, k + 17) == Blocks.gravel) && world.getBlock(i + 12, j + 18, k + 17) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 12, j + 19, k + 17, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        
	        
	        world.setBlock(i + 11, j + 10, k + 8, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        if ((world.getBlock(i + 11, j + 11, k + 8) == Blocks.air || world.getBlock(i + 11, j + 11, k + 8) == Blocks.gravel) && world.getBlock(i + 11, j + 10, k + 8) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 11, j + 11, k + 8, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 11, j + 12, k + 8) == Blocks.air || world.getBlock(i + 11, j + 12, k + 8) == Blocks.gravel) && world.getBlock(i + 11, j + 11, k + 8) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 11, j + 12, k + 8, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 11, j + 13, k + 8) == Blocks.air || world.getBlock(i + 11, j + 13, k + 8) == Blocks.gravel) && world.getBlock(i + 11, j + 12, k + 8) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 11, j + 13, k + 8, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 11, j + 14, k + 8) == Blocks.air || world.getBlock(i + 11, j + 14, k + 8) == Blocks.gravel) && world.getBlock(i + 11, j + 13, k + 8) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 11, j + 14, k + 8, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 11, j + 15, k + 8) == Blocks.air || world.getBlock(i + 11, j + 15, k + 8) == Blocks.gravel) && world.getBlock(i + 11, j + 14, k + 8) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 11, j + 15, k + 8, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 11, j + 16, k + 8) == Blocks.air || world.getBlock(i + 11, j + 16, k + 8) == Blocks.gravel) && world.getBlock(i + 11, j + 15, k + 8) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 11, j + 16, k + 8, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 11, j + 17, k + 8) == Blocks.air || world.getBlock(i + 11, j + 17, k + 8) == Blocks.gravel) && world.getBlock(i + 11, j + 16, k + 8) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 11, j + 17, k + 8, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 11, j + 18, k + 8) == Blocks.air || world.getBlock(i + 11, j + 18, k + 8) == Blocks.gravel) && world.getBlock(i + 11, j + 17, k + 8) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 11, j + 18, k + 8, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 11, j + 19, k + 8) == Blocks.air || world.getBlock(i + 11, j + 19, k + 8) == Blocks.gravel) && world.getBlock(i + 11, j + 18, k + 8) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 11, j + 19, k + 8, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 11, j + 20, k + 8) == Blocks.air || world.getBlock(i + 11, j + 20, k + 8) == Blocks.gravel) && world.getBlock(i + 11, j + 19, k + 8) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 11, j + 20, k + 8, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 11, j + 21, k + 8) == Blocks.air || world.getBlock(i + 11, j + 21, k + 8) == Blocks.gravel) && world.getBlock(i + 11, j + 20, k + 8) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 11, j + 21, k + 8, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 11, j + 22, k + 8) == Blocks.air || world.getBlock(i + 11, j + 22, k + 8) == Blocks.gravel) && world.getBlock(i + 11, j + 21, k + 8) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 11, j + 22, k + 8, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        	        
	        world.setBlock(i + 1, j + 7, k + 17, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        world.setBlock(i + 1, j + 8, k + 17, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        world.setBlock(i + 1, j + 9, k + 17, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        world.setBlock(i + 1, j + 10, k + 17, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        world.setBlock(i + 1, j + 11, k + 17, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        world.setBlock(i + 1, j + 12, k + 17, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        if ((world.getBlock(i + 1, j + 13, k + 17) == Blocks.air || world.getBlock(i + 1, j + 13, k + 17) == Blocks.gravel) && world.getBlock(i + 1, j + 12, k + 17) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 1, j + 13, k + 17, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 1, j + 14, k + 17) == Blocks.air || world.getBlock(i + 1, j + 14, k + 17) == Blocks.gravel) && world.getBlock(i + 1, j + 13, k + 17) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 1, j + 14, k + 17, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 1, j + 15, k + 17) == Blocks.air || world.getBlock(i + 1, j + 15, k + 17) == Blocks.gravel) && world.getBlock(i + 1, j + 14, k + 17) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 1, j + 15, k + 17, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 1, j + 16, k + 17) == Blocks.air || world.getBlock(i + 1, j + 16, k + 17) == Blocks.gravel) && world.getBlock(i + 1, j + 15, k + 17) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 1, j + 16, k + 17, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 1, j + 17, k + 17) == Blocks.air || world.getBlock(i + 1, j + 17, k + 17) == Blocks.gravel) && world.getBlock(i + 1, j + 16, k + 17) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 1, j + 17, k + 17, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 1, j + 18, k + 17) == Blocks.air || world.getBlock(i + 1, j + 18, k + 17) == Blocks.gravel) && world.getBlock(i + 1, j + 17, k + 17) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 1, j + 18, k + 17, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 1, j + 19, k + 17) == Blocks.air || world.getBlock(i + 1, j + 19, k + 17) == Blocks.gravel) && world.getBlock(i + 1, j + 18, k + 17) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 1, j + 19, k + 17, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        
	        world.setBlock(i + 1, j + 7, k + 29, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        world.setBlock(i + 1, j + 8, k + 29, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        world.setBlock(i + 1, j + 9, k + 29, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        world.setBlock(i + 1, j + 10, k + 29, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        world.setBlock(i + 1, j + 11, k + 29, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        world.setBlock(i + 1, j + 12, k + 29, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        if ((world.getBlock(i + 1, j + 13, k + 29) == Blocks.air || world.getBlock(i + 1, j + 13, k + 29) == Blocks.gravel) && world.getBlock(i + 1, j + 12, k + 29) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 1, j + 13, k + 29, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 1, j + 14, k + 29) == Blocks.air || world.getBlock(i + 1, j + 14, k + 29) == Blocks.gravel) && world.getBlock(i + 1, j + 13, k + 29) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 1, j + 14, k + 29, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 1, j + 15, k + 29) == Blocks.air || world.getBlock(i + 1, j + 15, k + 29) == Blocks.gravel) && world.getBlock(i + 1, j + 14, k + 29) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 1, j + 15, k + 29, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 1, j + 16, k + 29) == Blocks.air || world.getBlock(i + 1, j + 16, k + 29) == Blocks.gravel) && world.getBlock(i + 1, j + 15, k + 29) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 1, j + 16, k + 29, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 1, j + 17, k + 29) == Blocks.air || world.getBlock(i + 1, j + 17, k + 29) == Blocks.gravel) && world.getBlock(i + 1, j + 16, k + 29) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 1, j + 17, k + 29, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 1, j + 18, k + 29) == Blocks.air || world.getBlock(i + 1, j + 18, k + 29) == Blocks.gravel) && world.getBlock(i + 1, j + 17, k + 29) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 1, j + 18, k + 29, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 1, j + 19, k + 29) == Blocks.air || world.getBlock(i + 1, j + 19, k + 29) == Blocks.gravel) && world.getBlock(i + 1, j + 18, k + 29) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 1, j + 19, k + 29, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        
	        world.setBlock(i + 11, j + 10, k + 45, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        world.setBlock(i + 11, j + 11, k + 45, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        world.setBlock(i + 11, j + 12, k + 45, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        world.setBlock(i + 11, j + 13, k + 45, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        world.setBlock(i + 11, j + 14, k + 45, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        world.setBlock(i + 11, j + 15, k + 45, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        if ((world.getBlock(i + 11, j + 16, k + 45) == Blocks.air || world.getBlock(i + 11, j + 16, k + 45) == Blocks.gravel) && world.getBlock(i + 11, j + 15, k + 45) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 11, j + 16, k + 45, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 11, j + 17, k + 45) == Blocks.air || world.getBlock(i + 11, j + 17, k + 45) == Blocks.gravel) && world.getBlock(i + 11, j + 16, k + 45) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 11, j + 17, k + 45, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 11, j + 18, k + 45) == Blocks.air || world.getBlock(i + 11, j + 18, k + 45) == Blocks.gravel) && world.getBlock(i + 11, j + 17, k + 45) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 11, j + 18, k + 45, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 11, j + 19, k + 45) == Blocks.air || world.getBlock(i + 11, j + 19, k + 45) == Blocks.gravel) && world.getBlock(i + 11, j + 18, k + 45) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 11, j + 19, k + 45, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 11, j + 20, k + 45) == Blocks.air || world.getBlock(i + 11, j + 20, k + 45) == Blocks.gravel) && world.getBlock(i + 11, j + 19, k + 45) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 11, j + 20, k + 45, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        
	        world.setBlock(i + 3, j + 10, k + 1, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        world.setBlock(i + 3, j + 11, k + 1, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        world.setBlock(i + 3, j + 12, k + 1, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        world.setBlock(i + 3, j + 13, k + 1, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        world.setBlock(i + 3, j + 14, k + 1, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        world.setBlock(i + 3, j + 15, k + 1, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        if ((world.getBlock(i + 3, j + 16, k + 1) == Blocks.air || world.getBlock(i + 3, j + 16, k + 1) == Blocks.gravel) && world.getBlock(i + 3, j + 15, k + 1) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 3, j + 16, k + 1, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 3, j + 17, k + 1) == Blocks.air || world.getBlock(i + 3, j + 17, k + 1) == Blocks.gravel) && world.getBlock(i + 3, j + 16, k + 1) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 3, j + 17, k + 1, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 3, j + 18, k + 1) == Blocks.air || world.getBlock(i + 3, j + 18, k + 1) == Blocks.gravel) && world.getBlock(i + 3, j + 17, k + 1) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 3, j + 18, k + 1, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 3, j + 19, k + 1) == Blocks.air || world.getBlock(i + 3, j + 19, k + 1) == Blocks.gravel) && world.getBlock(i + 3, j + 18, k + 1) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 3, j + 19, k + 1, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        if ((world.getBlock(i + 3, j + 20, k + 1) == Blocks.air || world.getBlock(i + 3, j + 20, k + 1) == Blocks.gravel) && world.getBlock(i + 3, j + 19, k + 1) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 3, j + 20, k + 1, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
	        }
	        
	        world.setBlock(i + 11, j + 7, k + 26, Blocks.mob_spawner, 0, 2);
	        TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner)world.getTileEntity(i + 11, j + 7, k + 26);
	        
	        if (tileentitymobspawner != null)
	        {
	        	tileentitymobspawner.func_145881_a().setEntityName("nova_craft.sculk_abomination");
	        }
	        
			world.setBlock(i + 4, j + 9, k + 5, Blocks.mob_spawner, 0, 2);
			TileEntityMobSpawner tileentitymobspawner2 = (TileEntityMobSpawner)world.getTileEntity(i + 4, j + 9, k + 5);
	        
	        if (tileentitymobspawner2 != null)
	        {
	        	tileentitymobspawner2.func_145881_a().setEntityName("nova_craft.sculk_dweller");
	        }
	        
			world.setBlock(i + 4, j + 9, k + 42, Blocks.mob_spawner, 0, 2);
			TileEntityMobSpawner tileentitymobspawner3 = (TileEntityMobSpawner)world.getTileEntity(i + 4, j + 9, k + 42);
	        
	        if (tileentitymobspawner3 != null)
	        {
	        	tileentitymobspawner3.func_145881_a().setEntityName("nova_craft.sculk_dweller");
	        }
	        
			world.setBlock(i + 2, j + 6, k + 18, Blocks.mob_spawner, 0, 2);
			TileEntityMobSpawner tileentitymobspawner4 = (TileEntityMobSpawner)world.getTileEntity(i + 2, j + 6, k + 18);
	        
	        if (tileentitymobspawner4 != null)
	        {
	        	tileentitymobspawner4.func_145881_a().setEntityName("nova_craft.sculk_incinerator");
	        }
			
			world.setBlock(i + 7, j + 10, k + 43, NovaCraftBlocks.unbreakable_ancient_chest, 2, 2);			
			EntityWardenVessel warden = new EntityWardenVessel(world);
			warden.setPosition(i + 7, j + 12, k + 43);

			if (!world.isRemote) {
				world.spawnEntityInWorld(warden);
			}
			
			world.setBlock(i + 7, j + 10, k + 3, NovaCraftBlocks.unbreakable_ancient_chest, 3, 2);
			EntityWardenVessel warden2 = new EntityWardenVessel(world);
			warden2.setPosition(i + 7, j + 12, k + 3);

			if (!world.isRemote) {
				world.spawnEntityInWorld(warden2);
			}
			
			
			
			world.setBlock(i + 4, j + 10, k + 7, Blocks.chest, 5, 2);
			TileEntityChest chest3 = (TileEntityChest) world.getTileEntity(i + 4, j + 10, k + 7);

			for (int slot = 0; slot < 3 + random.nextInt(25); slot++) {
				chest3.setInventorySlotContents(random.nextInt(chest3.getSizeInventory()), this.getSculkLoot(random));
			}
			
			world.setBlock(i + 10, j + 10, k + 7, Blocks.chest, 4, 2);
			TileEntityChest chest4 = (TileEntityChest) world.getTileEntity(i + 10, j + 10, k + 7);

			for (int slot = 0; slot < 3 + random.nextInt(25); slot++) {
				chest4.setInventorySlotContents(random.nextInt(chest4.getSizeInventory()), this.getSculkLoot(random));
			}
		 
			return true;
	 }
	 
	 private ItemStack getSculkLoot(Random random) {
			int item = random.nextInt(11);
			switch (item) {
				case 0:
					return new ItemStack(NovaCraftItems.sculked_shard, random.nextInt(5) + 3);
				case 1:
					return new ItemStack(NovaCraftItems.sculked_shard, random.nextInt(1) + 2);
				case 2:
					return new ItemStack(NovaCraftItems.sculk_dweller_heart, 1);
				case 3:
					return new ItemStack(NovaCraftItems.sculked_monitor_scales, random.nextInt(5) + 2);
				case 4:
					return new ItemStack(NovaCraftBlocks.sculk_bricks, random.nextInt(21) + 11);
				case 5:
					return new ItemStack(NovaCraftBlocks.sculk_block, random.nextInt(11) + 5);
				case 6:
					return new ItemStack(NovaCraftBlocks.sculk_tentacle_2, random.nextInt(2) + 3);
				case 7:
					return new ItemStack(NovaCraftBlocks.sculk_bush, random.nextInt(3) + 1);
				case 8:
					return new ItemStack(NovaCraftBlocks.sculk_bloom, random.nextInt(2) + 1);
				case 9:
					return new ItemStack(NovaCraftItems.ancient_city_artifact, 1);
				default: {
					return new ItemStack(NovaCraftBlocks.sculk_block, random.nextInt(9) + 2);
				}
			}
		}

}
