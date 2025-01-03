package com.NovaCraft.world.ancient_city;

import net.minecraft.world.gen.feature.*;
import net.minecraft.block.*;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.world.*;
import java.util.*;

import com.NovaCraft.Items.NovaCraftItems;
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

public class AncientCityUnknownActivationGen extends WorldGenerator
{
	public AncientCityUnknownActivationGen() {

	}
	
	private static final Block nullstone_bricks = NovaCraftBlocks.nullstone_bricks;
	private static final Block nullstone_tiles = NovaCraftBlocks.nullstone_tiles;
	private static final Block sculk_block = NovaCraftBlocks.sculk_block;
	
	 public boolean generate(final World world, final Random random, final int i, final int j, final int k) {
		 
		 	world.setBlock(i + 2, j + 0, k + 1, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
		 	world.setBlock(i + 3, j + 0, k + 1, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 3, j + 0, k + 2, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 3, j + 1, k + 1, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 5, j + 1, k + 3, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 3, j + 2, k + 1, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 3, j + 2, k + 3, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 5, j + 2, k + 3, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 3, j + 2, k + 5, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 0, j + 3, k + 0, NovaCraftBlocks.nullstone_tiled_stairs, 2, 2);
			world.setBlock(i + 0, j + 3, k + 1, nullstone_tiles, 0, 2);
			world.setBlock(i + 1, j + 3, k + 1, nullstone_tiles, 0, 2);
			world.setBlock(i + 2, j + 3, k + 1, nullstone_tiles, 0, 2);
			world.setBlock(i + 3, j + 3, k + 1, nullstone_tiles, 0, 2);
			world.setBlock(i + 0, j + 3, k + 2, nullstone_bricks, 0, 2);
			world.setBlock(i + 1, j + 3, k + 2, nullstone_bricks, 0, 2);
			world.setBlock(i + 2, j + 3, k + 2, nullstone_bricks, 0, 2);
			world.setBlock(i + 3, j + 3, k + 2, nullstone_bricks, 0, 2);
			world.setBlock(i + 4, j + 3, k + 2, nullstone_tiles, 0, 2);
			world.setBlock(i + 0, j + 3, k + 3, NovaCraftBlocks.reinforced_nullstone, 0, 2);
			world.setBlock(i + 1, j + 3, k + 3, nullstone_bricks, 0, 2);
			world.setBlock(i + 2, j + 3, k + 3, nullstone_bricks, 0, 2);
			world.setBlock(i + 3, j + 3, k + 3, nullstone_bricks, 0, 2);
			world.setBlock(i + 4, j + 3, k + 3, nullstone_tiles, 0, 2);
			world.setBlock(i + 5, j + 3, k + 3, nullstone_tiles, 0, 2);
			world.setBlock(i + 0, j + 3, k + 4, nullstone_bricks, 0, 2);
			world.setBlock(i + 1, j + 3, k + 4, nullstone_bricks, 0, 2);
			world.setBlock(i + 2, j + 3, k + 4, nullstone_bricks, 0, 2);
			world.setBlock(i + 3, j + 3, k + 4, nullstone_bricks, 0, 2);
			world.setBlock(i + 4, j + 3, k + 4, nullstone_tiles, 0, 2);
			world.setBlock(i + 0, j + 3, k + 5, nullstone_tiles, 0, 2);
			world.setBlock(i + 1, j + 3, k + 5, nullstone_tiles, 0, 2);
			world.setBlock(i + 2, j + 3, k + 5, nullstone_tiles, 0, 2);
			world.setBlock(i + 3, j + 3, k + 5, nullstone_tiles, 0, 2);
			world.setBlock(i + 0, j + 3, k + 6, NovaCraftBlocks.nullstone_tiled_stairs, 3, 2);
			world.setBlock(i + 1, j + 4, k + 1, nullstone_bricks, 0, 2);
			world.setBlock(i + 2, j + 4, k + 1, nullstone_bricks, 0, 2);
			world.setBlock(i + 3, j + 4, k + 1, nullstone_bricks, 0, 2);
			world.setBlock(i + 1, j + 4, k + 2, NovaCraftBlocks.activated_reinforced_nullstone, 0, 2);
			world.setBlock(i + 2, j + 4, k + 2, NovaCraftBlocks.reinforced_nullstone, 0, 2);
			world.setBlock(i + 3, j + 4, k + 2, NovaCraftBlocks.reinforced_nullstone, 0, 2);
			world.setBlock(i + 4, j + 4, k + 2, nullstone_bricks, 0, 2);
			world.setBlock(i + 1, j + 4, k + 3, NovaCraftBlocks.reinforced_nullstone, 0, 2);
			world.setBlock(i + 2, j + 4, k + 3, NovaCraftBlocks.activated_reinforced_nullstone, 0, 2);
			world.setBlock(i + 3, j + 4, k + 3, NovaCraftBlocks.activated_reinforced_nullstone, 0, 2);
			world.setBlock(i + 4, j + 4, k + 3, nullstone_bricks, 0, 2);
			world.setBlock(i + 5, j + 4, k + 3, nullstone_bricks, 0, 2);
			world.setBlock(i + 1, j + 4, k + 4, NovaCraftBlocks.reinforced_nullstone, 0, 2);
			world.setBlock(i + 2, j + 4, k + 4, NovaCraftBlocks.reinforced_nullstone, 0, 2);
			world.setBlock(i + 3, j + 4, k + 4, NovaCraftBlocks.reinforced_nullstone, 0, 2);
			world.setBlock(i + 4, j + 4, k + 4, nullstone_bricks, 0, 2);
			world.setBlock(i + 1, j + 4, k + 5, nullstone_bricks, 0, 2);
			world.setBlock(i + 2, j + 4, k + 5, nullstone_bricks, 0, 2);
			world.setBlock(i + 3, j + 4, k + 5, nullstone_bricks, 0, 2);
			world.setBlock(i + 1, j + 5, k + 1, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 2, j + 5, k + 1, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 3, j + 5, k + 1, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 4, j + 5, k + 2, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 2, j + 5, k + 3, NovaCraftBlocks.unknown_portal_activator, 0, 2);
			world.setBlock(i + 5, j + 5, k + 3, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 4, j + 5, k + 4, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 1, j + 5, k + 5, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 2, j + 5, k + 5, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 3, j + 5, k + 5, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 1, j + 6, k + 1, NovaCraftBlocks.dim_vanite_torch, 5, 2);
			world.setBlock(i + 3, j + 6, k + 1, NovaCraftBlocks.dim_vanite_torch, 5, 2);
			world.setBlock(i + 4, j + 6, k + 2, NovaCraftBlocks.dim_vanite_torch, 5, 2);
			world.setBlock(i + 5, j + 6, k + 3, NovaCraftBlocks.dim_vanite_torch, 5, 2);
			world.setBlock(i + 4, j + 6, k + 4, NovaCraftBlocks.dim_vanite_torch, 5, 2);
			world.setBlock(i + 1, j + 6, k + 5, NovaCraftBlocks.dim_vanite_torch, 5, 2);
			world.setBlock(i + 3, j + 6, k + 5, NovaCraftBlocks.dim_vanite_torch, 5, 2);
			
			world.setBlock(i + 3, j + 1, k + 3, Blocks.mob_spawner, 0, 2);
			TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner)world.getTileEntity(i + 3, j + 1, k + 3);
	        
	        if (tileentitymobspawner != null)
	        {
	        	tileentitymobspawner.func_145881_a().setEntityName("nova_craft.sculk_dweller");
	        }
			
			world.setBlock(i + 4, j + 5, k + 3, NovaCraftBlocks.unbreakable_ancient_chest, 4, 2);
		 
		 return true;
	 }

}
