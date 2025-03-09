package com.NovaCraft.world.ancient_city.prisoner;

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
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagFloat;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.MathHelper;

public class AncientCityLargeHangingStructureGen extends WorldGenerator
{
	public AncientCityLargeHangingStructureGen() {

	}
	
	 public boolean generate(final World world, final Random random, final int i, final int j, final int k) {
		 
			world.setBlock(i + 5, j + 1, k + 4, NovaCraftBlocks.vanite_brick_wall, 0, 2);
			world.setBlock(i + 2, j + 2, k + 3, NovaCraftBlocks.vanite_brick_wall, 0, 2);
			world.setBlock(i + 5, j + 2, k + 4, NovaCraftBlocks.vanite_brick_wall, 0, 2);
			world.setBlock(i + 4, j + 3, k + 1, NovaCraftBlocks.vanite_brick_wall, 0, 2);
			world.setBlock(i + 7, j + 3, k + 2, NovaCraftBlocks.vanite_brick_wall, 0, 2);
			world.setBlock(i + 2, j + 3, k + 3, NovaCraftBlocks.vanite_brick_wall, 0, 2);
			world.setBlock(i + 5, j + 3, k + 4, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 5, j + 3, k + 7, NovaCraftBlocks.vanite_brick_wall, 0, 2);
			world.setBlock(i + 4, j + 4, k + 1, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 5, j + 4, k + 1, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 4, k + 1, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 3, j + 4, k + 2, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 7, j + 4, k + 2, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 2, j + 4, k + 3, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 5, j + 4, k + 3, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 8, j + 4, k + 3, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 1, j + 4, k + 4, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 4, j + 4, k + 4, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 5, j + 4, k + 4, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 4, k + 4, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 8, j + 4, k + 4, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 2, j + 4, k + 5, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 5, j + 4, k + 5, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 8, j + 4, k + 5, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 3, j + 4, k + 6, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 7, j + 4, k + 6, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 4, j + 4, k + 7, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 5, j + 4, k + 7, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 4, k + 7, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 4, j + 5, k + 0, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 5, j + 5, k + 0, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 5, k + 0, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 3, j + 5, k + 1, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 4, j + 5, k + 1, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 5, j + 5, k + 1, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 5, k + 1, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 7, j + 5, k + 1, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 2, j + 5, k + 2, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 3, j + 5, k + 2, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 4, j + 5, k + 2, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 5, j + 5, k + 2, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 5, k + 2, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 7, j + 5, k + 2, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 8, j + 5, k + 2, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 1, j + 5, k + 3, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 2, j + 5, k + 3, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 3, j + 5, k + 3, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 4, j + 5, k + 3, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 5, j + 5, k + 3, NovaCraftBlocks.glowing_carved_vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 5, k + 3, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 7, j + 5, k + 3, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 8, j + 5, k + 3, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 9, j + 5, k + 3, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 0, j + 5, k + 4, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 1, j + 5, k + 4, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 2, j + 5, k + 4, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 3, j + 5, k + 4, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 4, j + 5, k + 4, NovaCraftBlocks.glowing_carved_vanite_bricks, 0, 2);
			world.setBlock(i + 5, j + 5, k + 4, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 5, k + 4, NovaCraftBlocks.glowing_carved_vanite_bricks, 0, 2);
			world.setBlock(i + 7, j + 5, k + 4, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 8, j + 5, k + 4, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 9, j + 5, k + 4, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 1, j + 5, k + 5, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 2, j + 5, k + 5, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 3, j + 5, k + 5, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 4, j + 5, k + 5, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 5, j + 5, k + 5, NovaCraftBlocks.glowing_carved_vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 5, k + 5, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 7, j + 5, k + 5, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 8, j + 5, k + 5, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 9, j + 5, k + 5, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 2, j + 5, k + 6, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 3, j + 5, k + 6, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 4, j + 5, k + 6, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 5, j + 5, k + 6, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 5, k + 6, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 7, j + 5, k + 6, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 8, j + 5, k + 6, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 3, j + 5, k + 7, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 4, j + 5, k + 7, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 5, j + 5, k + 7, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 5, k + 7, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 7, j + 5, k + 7, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 4, j + 5, k + 8, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 5, j + 5, k + 8, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 5, k + 8, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 4, j + 6, k + 0, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
			world.setBlock(i + 5, j + 6, k + 0, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 6, k + 0, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
			world.setBlock(i + 3, j + 6, k + 1, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
			world.setBlock(i + 7, j + 6, k + 1, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
			world.setBlock(i + 2, j + 6, k + 2, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
			world.setBlock(i + 8, j + 6, k + 2, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
			world.setBlock(i + 1, j + 6, k + 3, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
			world.setBlock(i + 9, j + 6, k + 3, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
			world.setBlock(i + 9, j + 6, k + 4, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
			world.setBlock(i + 1, j + 6, k + 5, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
			world.setBlock(i + 9, j + 6, k + 5, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
			world.setBlock(i + 2, j + 6, k + 6, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
			world.setBlock(i + 8, j + 6, k + 6, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
			world.setBlock(i + 3, j + 6, k + 7, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
			world.setBlock(i + 7, j + 6, k + 7, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
			world.setBlock(i + 4, j + 6, k + 8, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
			world.setBlock(i + 5, j + 6, k + 8, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 6, k + 8, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
			world.setBlock(i + 4, j + 7, k + 0, NovaCraftBlocks.vanite_brick_wall, 0, 2);
			world.setBlock(i + 6, j + 7, k + 0, NovaCraftBlocks.vanite_brick_wall, 0, 2);
			world.setBlock(i + 3, j + 7, k + 1, NovaCraftBlocks.vanite_brick_wall, 0, 2);
			world.setBlock(i + 7, j + 7, k + 1, NovaCraftBlocks.vanite_brick_wall, 0, 2);
			world.setBlock(i + 2, j + 7, k + 2, NovaCraftBlocks.vanite_brick_wall, 0, 2);
			world.setBlock(i + 8, j + 7, k + 2, NovaCraftBlocks.vanite_brick_wall, 0, 2);
			world.setBlock(i + 1, j + 7, k + 3, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
			world.setBlock(i + 9, j + 7, k + 3, NovaCraftBlocks.vanite_brick_wall, 0, 2);
			world.setBlock(i + 1, j + 7, k + 5, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
			world.setBlock(i + 9, j + 7, k + 5, NovaCraftBlocks.vanite_brick_wall, 0, 2);
			world.setBlock(i + 2, j + 7, k + 6, NovaCraftBlocks.vanite_brick_wall, 0, 2);
			world.setBlock(i + 8, j + 7, k + 6, NovaCraftBlocks.vanite_brick_wall, 0, 2);
			world.setBlock(i + 3, j + 7, k + 7, NovaCraftBlocks.vanite_brick_wall, 0, 2);
			world.setBlock(i + 7, j + 7, k + 7, NovaCraftBlocks.vanite_brick_wall, 0, 2);
			world.setBlock(i + 4, j + 7, k + 8, NovaCraftBlocks.vanite_brick_wall, 0, 2);
			world.setBlock(i + 6, j + 7, k + 8, NovaCraftBlocks.vanite_brick_wall, 0, 2);
			world.setBlock(i + 4, j + 8, k + 0, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
			world.setBlock(i + 5, j + 8, k + 0, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 8, k + 0, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
			world.setBlock(i + 3, j + 8, k + 1, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
			world.setBlock(i + 7, j + 8, k + 1, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
			world.setBlock(i + 2, j + 8, k + 2, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
			world.setBlock(i + 8, j + 8, k + 2, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
			world.setBlock(i + 1, j + 8, k + 3, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
			world.setBlock(i + 9, j + 8, k + 3, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
			world.setBlock(i + 1, j + 8, k + 4, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 9, j + 8, k + 4, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
			world.setBlock(i + 1, j + 8, k + 5, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
			world.setBlock(i + 9, j + 8, k + 5, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
			world.setBlock(i + 2, j + 8, k + 6, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
			world.setBlock(i + 8, j + 8, k + 6, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
			world.setBlock(i + 3, j + 8, k + 7, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
			world.setBlock(i + 7, j + 8, k + 7, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
			world.setBlock(i + 4, j + 8, k + 8, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
			world.setBlock(i + 5, j + 8, k + 8, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 8, k + 8, NovaCraftBlocks.polished_vanite_bricks, 0, 2);
			world.setBlock(i + 4, j + 9, k + 0, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 5, j + 9, k + 0, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 9, k + 0, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 3, j + 9, k + 1, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 4, j + 9, k + 1, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 5, j + 9, k + 1, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 9, k + 1, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 7, j + 9, k + 1, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 2, j + 9, k + 2, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 3, j + 9, k + 2, NovaCraftBlocks.glowing_carved_vanite_bricks, 0, 2);
			world.setBlock(i + 4, j + 9, k + 2, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 5, j + 9, k + 2, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 9, k + 2, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 7, j + 9, k + 2, NovaCraftBlocks.glowing_carved_vanite_bricks, 0, 2);
			world.setBlock(i + 8, j + 9, k + 2, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 1, j + 9, k + 3, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 2, j + 9, k + 3, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 3, j + 9, k + 3, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 4, j + 9, k + 3, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 5, j + 9, k + 3, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 9, k + 3, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 7, j + 9, k + 3, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 8, j + 9, k + 3, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 9, j + 9, k + 3, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 1, j + 9, k + 4, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 2, j + 9, k + 4, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 3, j + 9, k + 4, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 4, j + 9, k + 4, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 5, j + 9, k + 4, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 9, k + 4, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 7, j + 9, k + 4, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 8, j + 9, k + 4, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 9, j + 9, k + 4, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 1, j + 9, k + 5, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 2, j + 9, k + 5, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 3, j + 9, k + 5, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 4, j + 9, k + 5, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 5, j + 9, k + 5, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 9, k + 5, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 7, j + 9, k + 5, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 8, j + 9, k + 5, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 9, j + 9, k + 5, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 2, j + 9, k + 6, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 3, j + 9, k + 6, NovaCraftBlocks.glowing_carved_vanite_bricks, 0, 2);
			world.setBlock(i + 4, j + 9, k + 6, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 5, j + 9, k + 6, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 9, k + 6, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 7, j + 9, k + 6, NovaCraftBlocks.glowing_carved_vanite_bricks, 0, 2);
			world.setBlock(i + 8, j + 9, k + 6, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 3, j + 9, k + 7, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 4, j + 9, k + 7, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 5, j + 9, k + 7, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 9, k + 7, NovaCraftBlocks.carved_vanite_bricks, 0, 2);
			world.setBlock(i + 7, j + 9, k + 7, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 4, j + 9, k + 8, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 5, j + 9, k + 8, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 9, k + 8, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 4, j + 10, k + 1, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 5, j + 10, k + 1, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 10, k + 1, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 4, j + 10, k + 2, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 5, j + 10, k + 2, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 10, k + 2, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 2, j + 10, k + 3, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 3, j + 10, k + 3, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 4, j + 10, k + 3, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 5, j + 10, k + 3, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 10, k + 3, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 7, j + 10, k + 3, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 8, j + 10, k + 3, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 2, j + 10, k + 4, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 3, j + 10, k + 4, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 4, j + 10, k + 4, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 5, j + 10, k + 4, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 10, k + 4, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 7, j + 10, k + 4, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 8, j + 10, k + 4, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 2, j + 10, k + 5, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 3, j + 10, k + 5, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 4, j + 10, k + 5, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 5, j + 10, k + 5, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 10, k + 5, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 7, j + 10, k + 5, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 8, j + 10, k + 5, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 4, j + 10, k + 6, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 5, j + 10, k + 6, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 10, k + 6, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 4, j + 10, k + 7, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 5, j + 10, k + 7, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 6, j + 10, k + 7, NovaCraftBlocks.vanite_bricks, 0, 2);
			world.setBlock(i + 4, j + 11, k + 1, NovaCraftBlocks.vanite_brick_wall, 0, 2);
			world.setBlock(i + 6, j + 11, k + 1, NovaCraftBlocks.vanite_brick_wall, 0, 2);
			world.setBlock(i + 2, j + 11, k + 3, NovaCraftBlocks.vanite_brick_wall, 0, 2);
			world.setBlock(i + 5, j + 11, k + 3, NovaCraftBlocks.carved_vanite_brick_wall, 0, 2);
			world.setBlock(i + 8, j + 11, k + 3, NovaCraftBlocks.vanite_brick_wall, 0, 2);
			world.setBlock(i + 4, j + 11, k + 4, NovaCraftBlocks.carved_vanite_brick_wall, 0, 2);
			world.setBlock(i + 6, j + 11, k + 4, NovaCraftBlocks.carved_vanite_brick_wall, 0, 2);
			world.setBlock(i + 2, j + 11, k + 5, NovaCraftBlocks.vanite_brick_wall, 0, 2);
			world.setBlock(i + 5, j + 11, k + 5, NovaCraftBlocks.carved_vanite_brick_wall, 0, 2);
			world.setBlock(i + 8, j + 11, k + 5, NovaCraftBlocks.vanite_brick_wall, 0, 2);
			world.setBlock(i + 4, j + 11, k + 7, NovaCraftBlocks.vanite_brick_wall, 0, 2);
			world.setBlock(i + 6, j + 11, k + 7, NovaCraftBlocks.vanite_brick_wall, 0, 2);
			world.setBlock(i + 4, j + 12, k + 1, NovaCraftBlocks.vanite_brick_wall, 0, 2);
			world.setBlock(i + 5, j + 12, k + 1, NovaCraftBlocks.vanite_brick_wall, 0, 2);
			world.setBlock(i + 6, j + 12, k + 1, NovaCraftBlocks.vanite_brick_wall, 0, 2);
			world.setBlock(i + 2, j + 12, k + 3, NovaCraftBlocks.vanite_brick_wall, 0, 2);
			world.setBlock(i + 5, j + 12, k + 3, NovaCraftBlocks.carved_vanite_brick_wall, 0, 2);
			world.setBlock(i + 8, j + 12, k + 3, NovaCraftBlocks.vanite_brick_wall, 0, 2);
			world.setBlock(i + 2, j + 12, k + 4, NovaCraftBlocks.vanite_brick_wall, 0, 2);
			world.setBlock(i + 4, j + 12, k + 4, NovaCraftBlocks.carved_vanite_brick_wall, 0, 2);
			world.setBlock(i + 5, j + 12, k + 4, NovaCraftBlocks.vanite_brick_wall, 0, 2);
			world.setBlock(i + 6, j + 12, k + 4, NovaCraftBlocks.carved_vanite_brick_wall, 0, 2);
			world.setBlock(i + 8, j + 12, k + 4, NovaCraftBlocks.vanite_brick_wall, 0, 2);
			world.setBlock(i + 2, j + 12, k + 5, NovaCraftBlocks.vanite_brick_wall, 0, 2);
			world.setBlock(i + 5, j + 12, k + 5, NovaCraftBlocks.carved_vanite_brick_wall, 0, 2);
			world.setBlock(i + 8, j + 12, k + 5, NovaCraftBlocks.vanite_brick_wall, 0, 2);
			world.setBlock(i + 4, j + 12, k + 7, NovaCraftBlocks.vanite_brick_wall, 0, 2);
			world.setBlock(i + 5, j + 12, k + 7, NovaCraftBlocks.vanite_brick_wall, 0, 2);
			world.setBlock(i + 6, j + 12, k + 7, NovaCraftBlocks.vanite_brick_wall, 0, 2);
			
			world.setBlock(i + 5, j + 13, k + 1, NovaCraftBlocks.vanite_brick_wall, 0, 2);
			if ((world.getBlock(i + 5, j + 14, k + 1) == Blocks.air || world.getBlock(i + 5, j + 14, k + 1) == Blocks.gravel) && world.getBlock(i + 5, j + 13, k + 1) == NovaCraftBlocks.vanite_brick_wall) {
	            world.setBlock(i + 5, j + 14, k + 1, NovaCraftBlocks.vanite_brick_wall, 0, 2);
	        } if ((world.getBlock(i + 5, j + 15, k + 1) == Blocks.air || world.getBlock(i + 5, j + 15, k + 1) == Blocks.gravel) && world.getBlock(i + 5, j + 14, k + 1) == NovaCraftBlocks.vanite_brick_wall) {
	            world.setBlock(i + 5, j + 15, k + 1, NovaCraftBlocks.vanite_brick_wall, 0, 2);
	        } if ((world.getBlock(i + 5, j + 16, k + 1) == Blocks.air || world.getBlock(i + 5, j + 16, k + 1) == Blocks.gravel) && world.getBlock(i + 5, j + 15, k + 1) == NovaCraftBlocks.vanite_brick_wall) {
	            world.setBlock(i + 5, j + 16, k + 1, NovaCraftBlocks.vanite_brick_wall, 0, 2);
	        } if ((world.getBlock(i + 5, j + 17, k + 1) == Blocks.air || world.getBlock(i + 5, j + 17, k + 1) == Blocks.gravel) && world.getBlock(i + 5, j + 16, k + 1) == NovaCraftBlocks.vanite_brick_wall) {
	            world.setBlock(i + 5, j + 17, k + 1, NovaCraftBlocks.vanite_brick_wall, 0, 2);
	        } if ((world.getBlock(i + 5, j + 18, k + 1) == Blocks.air || world.getBlock(i + 5, j + 18, k + 1) == Blocks.gravel) && world.getBlock(i + 5, j + 17, k + 1) == NovaCraftBlocks.vanite_brick_wall) {
	            world.setBlock(i + 5, j + 18, k + 1, NovaCraftBlocks.vanite_brick_wall, 0, 2);
	        }
						
			world.setBlock(i + 2, j + 13, k + 4, NovaCraftBlocks.vanite_brick_wall, 0, 2);
			if ((world.getBlock(i + 2, j + 14, k + 4) == Blocks.air || world.getBlock(i + 2, j + 14, k + 4) == Blocks.gravel) && world.getBlock(i + 2, j + 13, k + 4) == NovaCraftBlocks.vanite_brick_wall) {
	            world.setBlock(i + 2, j + 14, k + 4, NovaCraftBlocks.vanite_brick_wall, 0, 2);	            
	        } if ((world.getBlock(i + 2, j + 15, k + 4) == Blocks.air || world.getBlock(i + 2, j + 15, k + 4) == Blocks.gravel) && world.getBlock(i + 2, j + 14, k + 4) == NovaCraftBlocks.vanite_brick_wall) {
	            world.setBlock(i + 2, j + 15, k + 4, NovaCraftBlocks.vanite_brick_wall, 0, 2);	            
	        } if ((world.getBlock(i + 2, j + 16, k + 4) == Blocks.air || world.getBlock(i + 2, j + 16, k + 4) == Blocks.gravel) && world.getBlock(i + 2, j + 15, k + 4) == NovaCraftBlocks.vanite_brick_wall) {
	            world.setBlock(i + 2, j + 16, k + 4, NovaCraftBlocks.vanite_brick_wall, 0, 2);	            
	        } if ((world.getBlock(i + 2, j + 17, k + 4) == Blocks.air || world.getBlock(i + 2, j + 17, k + 4) == Blocks.gravel) && world.getBlock(i + 2, j + 16, k + 4) == NovaCraftBlocks.vanite_brick_wall) {
	            world.setBlock(i + 2, j + 17, k + 4, NovaCraftBlocks.vanite_brick_wall, 0, 2);	            
	        } if ((world.getBlock(i + 2, j + 18, k + 4) == Blocks.air || world.getBlock(i + 2, j + 18, k + 4) == Blocks.gravel) && world.getBlock(i + 2, j + 17, k + 4) == NovaCraftBlocks.vanite_brick_wall) {
	            world.setBlock(i + 2, j + 18, k + 4, NovaCraftBlocks.vanite_brick_wall, 0, 2);	            
	        }
						
			world.setBlock(i + 5, j + 13, k + 4, NovaCraftBlocks.vanite_brick_wall, 0, 2);
			if ((world.getBlock(i + 5, j + 14, k + 4) == Blocks.air || world.getBlock(i + 5, j + 14, k + 4) == Blocks.gravel) && world.getBlock(i + 5, j + 13, k + 4) == NovaCraftBlocks.vanite_brick_wall) {
	            world.setBlock(i + 5, j + 14, k + 4, NovaCraftBlocks.vanite_brick_wall, 0, 2);	            
	        } if ((world.getBlock(i + 5, j + 15, k + 4) == Blocks.air || world.getBlock(i + 5, j + 15, k + 4) == Blocks.gravel) && world.getBlock(i + 5, j + 14, k + 4) == NovaCraftBlocks.vanite_brick_wall) {
	            world.setBlock(i + 5, j + 15, k + 4, NovaCraftBlocks.vanite_brick_wall, 0, 2);	            
	        } if ((world.getBlock(i + 5, j + 16, k + 4) == Blocks.air || world.getBlock(i + 5, j + 16, k + 4) == Blocks.gravel) && world.getBlock(i + 5, j + 15, k + 4) == NovaCraftBlocks.vanite_brick_wall) {
	            world.setBlock(i + 5, j + 16, k + 4, NovaCraftBlocks.vanite_brick_wall, 0, 2);	            
	        } if ((world.getBlock(i + 5, j + 17, k + 4) == Blocks.air || world.getBlock(i + 5, j + 17, k + 4) == Blocks.gravel) && world.getBlock(i + 5, j + 16, k + 4) == NovaCraftBlocks.vanite_brick_wall) {
	            world.setBlock(i + 5, j + 17, k + 4, NovaCraftBlocks.vanite_brick_wall, 0, 2);	            
	        } if ((world.getBlock(i + 5, j + 18, k + 4) == Blocks.air || world.getBlock(i + 5, j + 18, k + 4) == Blocks.gravel) && world.getBlock(i + 5, j + 17, k + 4) == NovaCraftBlocks.vanite_brick_wall) {
	            world.setBlock(i + 5, j + 18, k + 4, NovaCraftBlocks.vanite_brick_wall, 0, 2);	            
	        }
						
			world.setBlock(i + 8, j + 13, k + 4, NovaCraftBlocks.vanite_brick_wall, 0, 2);
			if ((world.getBlock(i + 8, j + 14, k + 4) == Blocks.air || world.getBlock(i + 8, j + 14, k + 4) == Blocks.gravel) && world.getBlock(i + 8, j + 13, k + 4) == NovaCraftBlocks.vanite_brick_wall) {
	            world.setBlock(i + 8, j + 14, k + 4, NovaCraftBlocks.vanite_brick_wall, 0, 2);	            
	        } if ((world.getBlock(i + 8, j + 15, k + 4) == Blocks.air || world.getBlock(i + 8, j + 15, k + 4) == Blocks.gravel) && world.getBlock(i + 8, j + 14, k + 4) == NovaCraftBlocks.vanite_brick_wall) {
	            world.setBlock(i + 8, j + 15, k + 4, NovaCraftBlocks.vanite_brick_wall, 0, 2);	            
	        } if ((world.getBlock(i + 8, j + 16, k + 4) == Blocks.air || world.getBlock(i + 8, j + 16, k + 4) == Blocks.gravel) && world.getBlock(i + 8, j + 15, k + 4) == NovaCraftBlocks.vanite_brick_wall) {
	            world.setBlock(i + 8, j + 16, k + 4, NovaCraftBlocks.vanite_brick_wall, 0, 2);	            
	        } if ((world.getBlock(i + 8, j + 17, k + 4) == Blocks.air || world.getBlock(i + 8, j + 17, k + 4) == Blocks.gravel) && world.getBlock(i + 8, j + 16, k + 4) == NovaCraftBlocks.vanite_brick_wall) {
	            world.setBlock(i + 8, j + 17, k + 4, NovaCraftBlocks.vanite_brick_wall, 0, 2);	            
	        } if ((world.getBlock(i + 8, j + 18, k + 4) == Blocks.air || world.getBlock(i + 8, j + 18, k + 4) == Blocks.gravel) && world.getBlock(i + 8, j + 17, k + 4) == NovaCraftBlocks.vanite_brick_wall) {
	            world.setBlock(i + 8, j + 18, k + 4, NovaCraftBlocks.vanite_brick_wall, 0, 2);	            
	        }
								
			world.setBlock(i + 5, j + 13, k + 7, NovaCraftBlocks.vanite_brick_wall, 0, 2);
			if ((world.getBlock(i + 5, j + 14, k + 7) == Blocks.air || world.getBlock(i + 5, j + 14, k + 7) == Blocks.gravel) && world.getBlock(i + 5, j + 13, k + 7) == NovaCraftBlocks.vanite_brick_wall) {
	            world.setBlock(i + 5, j + 14, k + 7, NovaCraftBlocks.vanite_brick_wall, 0, 2);	            
	        } if ((world.getBlock(i + 5, j + 15, k + 7) == Blocks.air || world.getBlock(i + 5, j + 15, k + 7) == Blocks.gravel) && world.getBlock(i + 5, j + 14, k + 7) == NovaCraftBlocks.vanite_brick_wall) {
	            world.setBlock(i + 5, j + 15, k + 7, NovaCraftBlocks.vanite_brick_wall, 0, 2);	            
	        } if ((world.getBlock(i + 5, j + 16, k + 7) == Blocks.air || world.getBlock(i + 5, j + 16, k + 7) == Blocks.gravel) && world.getBlock(i + 5, j + 15, k + 7) == NovaCraftBlocks.vanite_brick_wall) {
	            world.setBlock(i + 5, j + 16, k + 7, NovaCraftBlocks.vanite_brick_wall, 0, 2);	            
	        } if ((world.getBlock(i + 5, j + 17, k + 7) == Blocks.air || world.getBlock(i + 5, j + 17, k + 7) == Blocks.gravel) && world.getBlock(i + 5, j + 16, k + 7) == NovaCraftBlocks.vanite_brick_wall) {
	            world.setBlock(i + 5, j + 17, k + 7, NovaCraftBlocks.vanite_brick_wall, 0, 2);	            
	        } if ((world.getBlock(i + 5, j + 18, k + 7) == Blocks.air || world.getBlock(i + 5, j + 18, k + 7) == Blocks.gravel) && world.getBlock(i + 5, j + 17, k + 7) == NovaCraftBlocks.vanite_brick_wall) {
	            world.setBlock(i + 5, j + 18, k + 7, NovaCraftBlocks.vanite_brick_wall, 0, 2);	            
	        }			 
			
			world.setBlock(i + 5, j + 6, k + 4, NovaCraftBlocks.cracked_nullstone_deactivator, 0, 2);
			
			world.setBlock(i + 8, j + 6, k + 4, Blocks.chest, 4, 2);
			TileEntityChest chest = (TileEntityChest) world.getTileEntity(i + 8, j + 6, k + 4);

			for (int slot = 0; slot < 3 + random.nextInt(25); slot++) {
				chest.setInventorySlotContents(random.nextInt(chest.getSizeInventory()), this.getBasicLoot(random));
			}
			
			world.setBlock(i + 5, j + 0, k + 4, Blocks.mob_spawner, 0, 2);
			TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner)world.getTileEntity(i + 5, j + 0, k + 4);
			
			    if (tileentitymobspawner != null) {
			    	tileentitymobspawner.func_145881_a().setEntityName("nova_craft.sculk_incinerator");

			        NBTTagCompound spawnerNBT = new NBTTagCompound();
			        tileentitymobspawner.writeToNBT(spawnerNBT);

			        NBTTagCompound spawnData = new NBTTagCompound();
			        spawnData.setString("id", "nova_craft.sculk_incinerator");

			        NBTTagList effects = new NBTTagList();

			        NBTTagCompound resistanceEffect = new NBTTagCompound();
			        resistanceEffect.setByte("Id", (byte) 1);
			        resistanceEffect.setByte("Amplifier", (byte) 1);
			        resistanceEffect.setInteger("Duration", Integer.MAX_VALUE);
			        resistanceEffect.setByte("Ambient", (byte) 1);
			        resistanceEffect.setByte("ShowParticles", (byte) 0);

			        effects.appendTag(resistanceEffect);
			        spawnData.setTag("ActiveEffects", effects);

			        NBTTagList equipment = new NBTTagList();

			        NBTTagCompound weapon = new NBTTagCompound();
			        ItemStack sword = new ItemStack(NovaCraftItems.eerie_sword);
			        sword.writeToNBT(weapon);
			        equipment.appendTag(weapon);

			        for (int a = 1; a < 5; a++) {
			            equipment.appendTag(new NBTTagCompound());
			        }
			        spawnData.setTag("Equipment", equipment);

			        NBTTagList dropChances = new NBTTagList();
			        dropChances.appendTag(new NBTTagFloat(0.0F));
			        for (int a = 1; a < 5; a++) {
			            dropChances.appendTag(new NBTTagFloat(0.085F));
			        }
			        spawnData.setTag("DropChances", dropChances);

			        spawnerNBT.setTag("SpawnData", spawnData);

			        tileentitymobspawner.readFromNBT(spawnerNBT);
			    }
			    
			world.setBlock(i + 2, j + 1, k + 3, Blocks.mob_spawner, 0, 2);
			TileEntityMobSpawner tileentitymobspawner2 = (TileEntityMobSpawner)world.getTileEntity(i + 2, j + 1, k + 3);
			
				if (tileentitymobspawner2 != null)
				{
        		tileentitymobspawner2.func_145881_a().setEntityName("nova_craft.sculk_incinerator");

		        NBTTagCompound spawnerNBT2 = new NBTTagCompound();
		        tileentitymobspawner2.writeToNBT(spawnerNBT2);

		        NBTTagCompound spawnData2 = new NBTTagCompound();
		        spawnData2.setString("id", "nova_craft.sculk_incinerator");

		        NBTTagList effects2 = new NBTTagList();

		        NBTTagCompound resistanceEffect2 = new NBTTagCompound();
		        resistanceEffect2.setByte("Id", (byte) 11);
		        resistanceEffect2.setByte("Amplifier", (byte) 1);
		        resistanceEffect2.setInteger("Duration", Integer.MAX_VALUE);
		        resistanceEffect2.setByte("Ambient", (byte) 1);
		        resistanceEffect2.setByte("ShowParticles", (byte) 0);

		        effects2.appendTag(resistanceEffect2);
		        spawnData2.setTag("ActiveEffects", effects2);
		        
		        spawnerNBT2.setTag("SpawnData", spawnData2);

		        tileentitymobspawner2.readFromNBT(spawnerNBT2);
				}
		 
		 return true;
	 }
	 
	 private ItemStack getBasicLoot(Random random) {
			int item = random.nextInt(32);
			switch (item) {
				case 0:
					return new ItemStack(Items.coal, random.nextInt(9) + 6);
				case 1:
					return new ItemStack(Items.bone, random.nextInt(14) + 1);
				case 2:
					return new ItemStack(NovaCraftItems.larimar_shard, random.nextInt(2) + 1);
				case 3:
					return new ItemStack(NovaCraftItems.copartz_shard, random.nextInt(3) + 1);
				case 4:
					return new ItemStack(NovaCraftItems.tsavorokite_shard, random.nextInt(1) + 1);
				case 5:
					return new ItemStack(NovaCraftItems.yttrlinsite_shard, 1);
				case 6:
					if (Loader.isModLoaded("netherlicious")) {
						return new ItemStack(OtherModBlocks.SoulTorch, random.nextInt(14) + 1);
					}
					if (Loader.isModLoaded("etfuturum")) {
						return new ItemStack(OtherModBlocks.soul_torch, random.nextInt(14) + 1);
					}
					else {
						return new ItemStack(NovaCraftBlocks.dim_vanite_torch, random.nextInt(14) + 1);
					}
				case 7: 
					return new ItemStack(NovaCraftItems.disc_fragment_5, 1);
				case 8: 
					return new ItemStack(Items.book, random.nextInt(7) + 2);
				case 9: 
					Enchantment enchantment = Enchantment.enchantmentsBookList[random.nextInt(Enchantment.enchantmentsBookList.length)];
			        		        
					int minLevel = enchantment.getMinLevel();
			        int maxLevel = enchantment.getMaxLevel();
			        int level = MathHelper.getRandomIntegerInRange(random, minLevel, maxLevel);
			        ItemStack itemStack = Items.enchanted_book.getEnchantedItemStack(new EnchantmentData(enchantment, maxLevel));
	                
	                return itemStack;
				case 10: 
					Enchantment enchantment2 = Enchantment.enchantmentsBookList[random.nextInt(Enchantment.enchantmentsBookList.length)];
			        
			        int minLevel2 = enchantment2.getMinLevel();
			        int maxLevel2 = enchantment2.getMaxLevel();
			        int level2 = MathHelper.getRandomIntegerInRange(random, minLevel2, maxLevel2);		       
			        ItemStack itemStack2 = Items.enchanted_book.getEnchantedItemStack(new EnchantmentData(enchantment2, maxLevel2));
	                
	                return itemStack2;
	                
				case 11: 
					return new ItemStack(Items.potionitem, 1, 8257);
				case 12: 
					if (Loader.isModLoaded("etfuturum")) {
						return new ItemStack(OtherModItems.amethyst_shard, random.nextInt(14) + 1);
					}
					else {
						return new ItemStack(NovaCraftItems.copartz_shard, random.nextInt(14) + 1);
					}
				case 13: 
					return new ItemStack(NovaCraftBlocks.sculk_block, random.nextInt(6) + 4);
				case 14: 
					return new ItemStack(Items.experience_bottle, random.nextInt(2) + 1);
				case 15:
					//Hoe enchants
				    Enchantment[] helmetEnchantments = {Enchantment.efficiency, Enchantment.unbreaking};
				    Enchantment[] helmetEnchantments2 = {Enchantment.silkTouch};
				    Enchantment enchantment3 = helmetEnchantments[random.nextInt(helmetEnchantments.length)];
				    Enchantment enchantment33 = helmetEnchantments2[random.nextInt(helmetEnchantments2.length)];	
				    int maxLevel3 = enchantment3.getMaxLevel();			
				    int maxLevel33 = enchantment33.getMaxLevel();	
				    ItemStack itemStack3 = new ItemStack(Items.diamond_hoe);
				    
				    itemStack3.addEnchantment(enchantment3, maxLevel3);
				    itemStack3.addEnchantment(enchantment33, maxLevel33);
				    
				    return itemStack3;
				case 16: 
					return new ItemStack(Items.iron_ingot, random.nextInt(14) + 7);
				case 17: 
					return new ItemStack(Items.gold_ingot, random.nextInt(7) + 3);
				case 18: 
					return new ItemStack(NovaCraftItems.vanite_ingot, random.nextInt(15) + 8);
				case 19: 
					return new ItemStack(Items.golden_apple, 0, 1);
				case 20:
					return new ItemStack(NovaCraftItems.sculk_boots, 1);
				case 21: 
					return new ItemStack(NovaCraftItems.sculk_dweller_heart, 1);
				case 22: 
					return new ItemStack(NovaCraftItems.sculked_monitor_scales, random.nextInt(2) + 1);
				case 23: 
					return new ItemStack(NovaCraftItems.luminant_gel, random.nextInt(8) + 3);
				case 24: 
					return new ItemStack(Items.gunpowder, random.nextInt(6) + 5);
				case 25: 
					return new ItemStack(Items.diamond, 1);
				case 26: 
					return new ItemStack(NovaCraftItems.ancient_city_artifact, 1);
				case 27: 
					return new ItemStack(NovaCraftItems.vanite_ingot, random.nextInt(15) + 8);
				case 28: 
					return new ItemStack(Items.experience_bottle, random.nextInt(2) + 1);
				default: {
					return new ItemStack(NovaCraftBlocks.sculk_block, random.nextInt(9) + 2);
				}
			}
		}

}
