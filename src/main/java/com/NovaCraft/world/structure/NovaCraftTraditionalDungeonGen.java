package com.NovaCraft.world.structure;

import java.util.Random;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraftBlocks.NovaCraftBlocks;

import net.minecraft.block.Block;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagFloat;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.MobSpawnerBaseLogic;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class NovaCraftTraditionalDungeonGen extends WorldGenerator {
	
	public NovaCraftTraditionalDungeonGen() {

	}
	
	 public boolean generate(final World world, final Random random, final int i, final int j, final int k) {
		 
		 	world.setBlock(i + 3, j + 0, k + 0, Blocks.emerald_ore, 0, 2);
			world.setBlock(i + 0, j + 0, k + 1, Blocks.emerald_ore, 0, 2);
			world.setBlock(i + 5, j + 0, k + 1, Blocks.emerald_ore, 0, 2);
			world.setBlock(i + 3, j + 0, k + 2, Blocks.emerald_ore, 0, 2);
			world.setBlock(i + 1, j + 0, k + 3, Blocks.emerald_ore, 0, 2);
			world.setBlock(i + 5, j + 0, k + 3, Blocks.emerald_ore, 0, 2);
			world.setBlock(i + 0, j + 0, k + 5, Blocks.emerald_ore, 0, 2);
			world.setBlock(i + 6, j + 0, k + 5, Blocks.emerald_ore, 0, 2);
			world.setBlock(i + 4, j + 0, k + 6, Blocks.emerald_ore, 0, 2);
			world.setBlock(i + 5, j + 0, k + 6, Blocks.emerald_ore, 0, 2);
			world.setBlock(i + 1, j + 0, k + 7, Blocks.emerald_ore, 0, 2);
			world.setBlock(i + 5, j + 0, k + 7, Blocks.emerald_ore, 0, 2);
			
			world.setBlock(i + 4, j + 0, k + 1, NovaCraftBlocks.grimstone_emerald, 0, 2);
			world.setBlock(i + 2, j + 0, k + 3, NovaCraftBlocks.grimstone_emerald, 0, 2);
			world.setBlock(i + 3, j + 0, k + 6, NovaCraftBlocks.grimstone_emerald, 0, 2);
		 
		 	world.setBlock(i + 0, j + 0, k + 0, NovaCraftBlocks.cobbled_grimstone, 0, 2);
			world.setBlock(i + 1, j + 0, k + 0, NovaCraftBlocks.cobbled_grimstone, 0, 2);
			world.setBlock(i + 2, j + 0, k + 0, NovaCraftBlocks.cobbled_grimstone, 0, 2);
			world.setBlock(i + 4, j + 0, k + 0, NovaCraftBlocks.cobbled_grimstone, 0, 2);
			world.setBlock(i + 5, j + 0, k + 0, NovaCraftBlocks.cobbled_grimstone, 0, 2);
			world.setBlock(i + 6, j + 0, k + 0, NovaCraftBlocks.cobbled_grimstone, 0, 2);
			world.setBlock(i + 1, j + 0, k + 1, NovaCraftBlocks.cobbled_grimstone, 0, 2);
			world.setBlock(i + 2, j + 0, k + 1, NovaCraftBlocks.cobbled_grimstone, 0, 2);
			world.setBlock(i + 3, j + 0, k + 1, NovaCraftBlocks.cobbled_grimstone, 0, 2);
			world.setBlock(i + 6, j + 0, k + 1, NovaCraftBlocks.cobbled_grimstone, 0, 2);
			world.setBlock(i + 0, j + 0, k + 2, NovaCraftBlocks.cobbled_grimstone, 0, 2);
			world.setBlock(i + 1, j + 0, k + 2, NovaCraftBlocks.cobbled_grimstone, 0, 2);
			world.setBlock(i + 2, j + 0, k + 2, NovaCraftBlocks.cobbled_grimstone, 0, 2);
			world.setBlock(i + 4, j + 0, k + 2, NovaCraftBlocks.cobbled_grimstone, 0, 2);
			world.setBlock(i + 5, j + 0, k + 2, NovaCraftBlocks.cobbled_grimstone, 0, 2);
			world.setBlock(i + 6, j + 0, k + 2, NovaCraftBlocks.cobbled_grimstone, 0, 2);
			world.setBlock(i + 0, j + 0, k + 3, NovaCraftBlocks.cobbled_grimstone, 0, 2);
			world.setBlock(i + 3, j + 0, k + 3, NovaCraftBlocks.cobbled_grimstone, 0, 2);
			world.setBlock(i + 4, j + 0, k + 3, NovaCraftBlocks.cobbled_grimstone, 0, 2);
			world.setBlock(i + 6, j + 0, k + 3, NovaCraftBlocks.cobbled_grimstone, 0, 2);
			world.setBlock(i + 0, j + 0, k + 4, NovaCraftBlocks.cobbled_grimstone, 0, 2);
			world.setBlock(i + 1, j + 0, k + 4, NovaCraftBlocks.cobbled_grimstone, 0, 2);
			world.setBlock(i + 2, j + 0, k + 4, NovaCraftBlocks.cobbled_grimstone, 0, 2);
			world.setBlock(i + 3, j + 0, k + 4, NovaCraftBlocks.cobbled_grimstone, 0, 2);
			world.setBlock(i + 4, j + 0, k + 4, NovaCraftBlocks.cobbled_grimstone, 0, 2);
			world.setBlock(i + 5, j + 0, k + 4, NovaCraftBlocks.cobbled_grimstone, 0, 2);
			world.setBlock(i + 6, j + 0, k + 4, NovaCraftBlocks.cobbled_grimstone, 0, 2);
			world.setBlock(i + 1, j + 0, k + 5, NovaCraftBlocks.cobbled_grimstone, 0, 2);
			world.setBlock(i + 2, j + 0, k + 5, NovaCraftBlocks.cobbled_grimstone, 0, 2);
			world.setBlock(i + 3, j + 0, k + 5, NovaCraftBlocks.cobbled_grimstone, 0, 2);
			world.setBlock(i + 4, j + 0, k + 5, NovaCraftBlocks.cobbled_grimstone, 0, 2);
			world.setBlock(i + 5, j + 0, k + 5, NovaCraftBlocks.cobbled_grimstone, 0, 2);
			world.setBlock(i + 0, j + 0, k + 6, NovaCraftBlocks.cobbled_grimstone, 0, 2);
			world.setBlock(i + 1, j + 0, k + 6, NovaCraftBlocks.cobbled_grimstone, 0, 2);
			world.setBlock(i + 2, j + 0, k + 6, NovaCraftBlocks.cobbled_grimstone, 0, 2);
			world.setBlock(i + 6, j + 0, k + 6, NovaCraftBlocks.cobbled_grimstone, 0, 2);
			world.setBlock(i + 0, j + 0, k + 7, NovaCraftBlocks.cobbled_grimstone, 0, 2);
			world.setBlock(i + 2, j + 0, k + 7, NovaCraftBlocks.cobbled_grimstone, 0, 2);
			world.setBlock(i + 3, j + 0, k + 7, NovaCraftBlocks.cobbled_grimstone, 0, 2);
			world.setBlock(i + 4, j + 0, k + 7, NovaCraftBlocks.cobbled_grimstone, 0, 2);
			world.setBlock(i + 6, j + 0, k + 7, NovaCraftBlocks.cobbled_grimstone, 0, 2);
			world.setBlock(i + 0, j + 0, k + 8, NovaCraftBlocks.cobbled_grimstone, 0, 2);
			world.setBlock(i + 1, j + 0, k + 8, NovaCraftBlocks.cobbled_grimstone, 0, 2);
			world.setBlock(i + 2, j + 0, k + 8, NovaCraftBlocks.cobbled_grimstone, 0, 2);
			world.setBlock(i + 3, j + 0, k + 8, NovaCraftBlocks.cobbled_grimstone, 0, 2);
			world.setBlock(i + 4, j + 0, k + 8, NovaCraftBlocks.cobbled_grimstone, 0, 2);
			world.setBlock(i + 5, j + 0, k + 8, NovaCraftBlocks.cobbled_grimstone, 0, 2);
			world.setBlock(i + 6, j + 0, k + 8, NovaCraftBlocks.cobbled_grimstone, 0, 2);
			world.setBlock(i + 0, j + 1, k + 0, NovaCraftBlocks.cobbled_grimstone, 0, 2);
			world.setBlock(i + 1, j + 1, k + 0, NovaCraftBlocks.cobbled_grimstone, 0, 2);
			world.setBlock(i + 2, j + 1, k + 0, NovaCraftBlocks.cobbled_grimstone, 0, 2);
			world.setBlock(i + 3, j + 1, k + 0, Blocks.cobblestone, 0, 2);
			world.setBlock(i + 4, j + 1, k + 0, Blocks.cobblestone, 0, 2);
			world.setBlock(i + 5, j + 1, k + 0, Blocks.cobblestone, 0, 2);
			world.setBlock(i + 6, j + 1, k + 0, Blocks.cobblestone, 0, 2);
			world.setBlock(i + 0, j + 1, k + 1, Blocks.cobblestone, 0, 2);
			world.setBlock(i + 1, j + 1, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 1, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 1, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 1, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 1, k + 1, Blocks.cobblestone, 0, 2);
			world.setBlock(i + 0, j + 1, k + 2, NovaCraftBlocks.cobbled_grimstone, 0, 2);
			world.setBlock(i + 1, j + 1, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 1, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 1, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 1, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 1, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 1, k + 2, NovaCraftBlocks.cobbled_grimstone, 0, 2);
			world.setBlock(i + 0, j + 1, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 1, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 1, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 1, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 1, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 1, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 1, k + 3, Blocks.cobblestone, 0, 2);
			world.setBlock(i + 0, j + 1, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 1, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 1, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 1, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 1, k + 4, NovaCraftBlocks.cobbled_grimstone, 0, 2);
			world.setBlock(i + 0, j + 1, k + 5, NovaCraftBlocks.cobbled_grimstone, 0, 2);
			world.setBlock(i + 1, j + 1, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 1, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 1, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 1, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 1, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 1, k + 5, Blocks.cobblestone, 0, 2);
			world.setBlock(i + 0, j + 1, k + 6, NovaCraftBlocks.cobbled_grimstone, 0, 2);
			world.setBlock(i + 1, j + 1, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 1, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 1, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 1, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 1, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 1, k + 6, Blocks.cobblestone, 0, 2);
			world.setBlock(i + 0, j + 1, k + 7, NovaCraftBlocks.cobbled_grimstone, 0, 2);
			world.setBlock(i + 1, j + 1, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 1, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 1, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 1, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 1, k + 7, Blocks.cobblestone, 0, 2);
			world.setBlock(i + 0, j + 1, k + 8, Blocks.cobblestone, 0, 2);
			world.setBlock(i + 1, j + 1, k + 8, Blocks.cobblestone, 0, 2);
			world.setBlock(i + 2, j + 1, k + 8, NovaCraftBlocks.cobbled_grimstone, 0, 2);
			world.setBlock(i + 3, j + 1, k + 8, Blocks.cobblestone, 0, 2);
			world.setBlock(i + 4, j + 1, k + 8, Blocks.cobblestone, 0, 2);
			world.setBlock(i + 5, j + 1, k + 8, NovaCraftBlocks.cobbled_grimstone, 0, 2);
			world.setBlock(i + 6, j + 1, k + 8, NovaCraftBlocks.cobbled_grimstone, 0, 2);
			world.setBlock(i + 0, j + 2, k + 0, Blocks.cobblestone, 0, 2);
			world.setBlock(i + 1, j + 2, k + 0, Blocks.cobblestone, 0, 2);
			world.setBlock(i + 2, j + 2, k + 0, NovaCraftBlocks.cobbled_grimstone, 0, 2);
			world.setBlock(i + 3, j + 2, k + 0, Blocks.cobblestone, 0, 2);
			world.setBlock(i + 4, j + 2, k + 0, Blocks.cobblestone, 0, 2);
			world.setBlock(i + 5, j + 2, k + 0, Blocks.cobblestone, 0, 2);
			world.setBlock(i + 6, j + 2, k + 0, Blocks.cobblestone, 0, 2);
			world.setBlock(i + 0, j + 2, k + 1, Blocks.cobblestone, 0, 2);
			world.setBlock(i + 1, j + 2, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 2, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 2, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 2, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 2, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 2, k + 1, Blocks.cobblestone, 0, 2);
			world.setBlock(i + 0, j + 2, k + 2, NovaCraftBlocks.cobbled_grimstone, 0, 2);
			world.setBlock(i + 1, j + 2, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 2, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 2, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 2, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 2, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 2, k + 2, Blocks.cobblestone, 0, 2);
			world.setBlock(i + 0, j + 2, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 2, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 2, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 2, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 2, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 2, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 2, k + 3, NovaCraftBlocks.cobbled_grimstone, 0, 2);
			world.setBlock(i + 0, j + 2, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 2, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 2, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 2, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 2, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 2, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 2, k + 4, Blocks.cobblestone, 0, 2);
			world.setBlock(i + 0, j + 2, k + 5, Blocks.cobblestone, 0, 2);
			world.setBlock(i + 1, j + 2, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 2, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 2, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 2, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 2, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 2, k + 5, Blocks.cobblestone, 0, 2);
			world.setBlock(i + 0, j + 2, k + 6, Blocks.cobblestone, 0, 2);
			world.setBlock(i + 1, j + 2, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 2, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 2, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 2, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 2, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 2, k + 6, Blocks.cobblestone, 0, 2);
			world.setBlock(i + 0, j + 2, k + 7, Blocks.cobblestone, 0, 2);
			world.setBlock(i + 1, j + 2, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 2, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 2, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 2, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 2, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 2, k + 7, NovaCraftBlocks.cobbled_grimstone, 0, 2);
			world.setBlock(i + 0, j + 2, k + 8, Blocks.cobblestone, 0, 2);
			world.setBlock(i + 1, j + 2, k + 8, Blocks.cobblestone, 0, 2);
			world.setBlock(i + 2, j + 2, k + 8, Blocks.cobblestone, 0, 2);
			world.setBlock(i + 3, j + 2, k + 8, NovaCraftBlocks.cobbled_grimstone, 0, 2);
			world.setBlock(i + 4, j + 2, k + 8, Blocks.cobblestone, 0, 2);
			world.setBlock(i + 5, j + 2, k + 8, Blocks.cobblestone, 0, 2);
			world.setBlock(i + 6, j + 2, k + 8, NovaCraftBlocks.cobbled_grimstone, 0, 2);
			world.setBlock(i + 0, j + 3, k + 0, Blocks.cobblestone, 0, 2);
			world.setBlock(i + 1, j + 3, k + 0, Blocks.cobblestone, 0, 2);
			world.setBlock(i + 2, j + 3, k + 0, Blocks.cobblestone, 0, 2);
			world.setBlock(i + 3, j + 3, k + 0, Blocks.cobblestone, 0, 2);
			world.setBlock(i + 4, j + 3, k + 0, NovaCraftBlocks.cobbled_grimstone, 0, 2);
			world.setBlock(i + 5, j + 3, k + 0, Blocks.cobblestone, 0, 2);
			world.setBlock(i + 6, j + 3, k + 0, Blocks.cobblestone, 0, 2);
			world.setBlock(i + 0, j + 3, k + 1, NovaCraftBlocks.cobbled_grimstone, 0, 2);
			world.setBlock(i + 1, j + 3, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 3, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 3, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 3, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 3, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 3, k + 1, Blocks.cobblestone, 0, 2);
			world.setBlock(i + 0, j + 3, k + 2, Blocks.cobblestone, 0, 2);
			world.setBlock(i + 1, j + 3, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 3, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 3, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 3, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 3, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 3, k + 2, NovaCraftBlocks.cobbled_grimstone, 0, 2);
			world.setBlock(i + 0, j + 3, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 3, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 3, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 3, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 3, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 3, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 3, k + 3, Blocks.cobblestone, 0, 2);
			world.setBlock(i + 0, j + 3, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 3, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 3, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 3, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 3, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 3, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 3, k + 4, Blocks.cobblestone, 0, 2);
			world.setBlock(i + 0, j + 3, k + 5, NovaCraftBlocks.cobbled_grimstone, 0, 2);
			world.setBlock(i + 1, j + 3, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 3, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 3, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 3, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 3, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 3, k + 5, Blocks.cobblestone, 0, 2);
			world.setBlock(i + 0, j + 3, k + 6, Blocks.cobblestone, 0, 2);
			world.setBlock(i + 1, j + 3, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 3, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 3, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 3, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 3, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 3, k + 6, NovaCraftBlocks.cobbled_grimstone, 0, 2);
			world.setBlock(i + 0, j + 3, k + 7, Blocks.cobblestone, 0, 2);
			world.setBlock(i + 1, j + 3, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 3, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 3, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 3, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 3, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 3, k + 7, Blocks.cobblestone, 0, 2);
			world.setBlock(i + 0, j + 3, k + 8, Blocks.cobblestone, 0, 2);
			world.setBlock(i + 1, j + 3, k + 8, Blocks.cobblestone, 0, 2);
			world.setBlock(i + 2, j + 3, k + 8, NovaCraftBlocks.cobbled_grimstone, 0, 2);
			world.setBlock(i + 3, j + 3, k + 8, Blocks.cobblestone, 0, 2);
			world.setBlock(i + 4, j + 3, k + 8, Blocks.cobblestone, 0, 2);
			world.setBlock(i + 5, j + 3, k + 8, Blocks.cobblestone, 0, 2);
			world.setBlock(i + 6, j + 3, k + 8, Blocks.cobblestone, 0, 2);
			world.setBlock(i + 0, j + 4, k + 0, Blocks.cobblestone, 0, 2);
			world.setBlock(i + 1, j + 4, k + 0, Blocks.cobblestone, 0, 2);
			world.setBlock(i + 2, j + 4, k + 0, Blocks.cobblestone, 0, 2);
			world.setBlock(i + 3, j + 4, k + 0, Blocks.cobblestone, 0, 2);
			world.setBlock(i + 4, j + 4, k + 0, Blocks.cobblestone, 0, 2);
			world.setBlock(i + 5, j + 4, k + 0, Blocks.cobblestone, 0, 2);
			world.setBlock(i + 6, j + 4, k + 0, Blocks.cobblestone, 0, 2);
			world.setBlock(i + 0, j + 4, k + 1, Blocks.cobblestone, 0, 2);
			world.setBlock(i + 1, j + 4, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 4, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 4, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 4, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 4, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 4, k + 1, Blocks.cobblestone, 0, 2);
			world.setBlock(i + 0, j + 4, k + 2, Blocks.cobblestone, 0, 2);
			world.setBlock(i + 1, j + 4, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 4, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 4, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 4, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 4, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 4, k + 2, Blocks.cobblestone, 0, 2);
			world.setBlock(i + 0, j + 4, k + 3, NovaCraftBlocks.cobbled_grimstone, 0, 2);
			world.setBlock(i + 1, j + 4, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 4, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 4, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 4, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 4, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 4, k + 3, Blocks.cobblestone, 0, 2);
			world.setBlock(i + 0, j + 4, k + 4, NovaCraftBlocks.cobbled_grimstone, 0, 2);
			world.setBlock(i + 1, j + 4, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 4, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 4, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 4, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 4, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 4, k + 4, Blocks.cobblestone, 0, 2);
			world.setBlock(i + 0, j + 4, k + 5, Blocks.cobblestone, 0, 2);
			world.setBlock(i + 1, j + 4, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 4, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 4, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 4, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 4, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 4, k + 5, NovaCraftBlocks.cobbled_grimstone, 0, 2);
			world.setBlock(i + 0, j + 4, k + 6, NovaCraftBlocks.cobbled_grimstone, 0, 2);
			world.setBlock(i + 1, j + 4, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 4, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 4, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 4, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 4, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 4, k + 6, Blocks.cobblestone, 0, 2);
			world.setBlock(i + 0, j + 4, k + 7, Blocks.cobblestone, 0, 2);
			world.setBlock(i + 1, j + 4, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 4, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 4, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 4, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 4, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 4, k + 7, Blocks.cobblestone, 0, 2);
			world.setBlock(i + 0, j + 4, k + 8, Blocks.cobblestone, 0, 2);
			world.setBlock(i + 1, j + 4, k + 8, Blocks.cobblestone, 0, 2);
			world.setBlock(i + 2, j + 4, k + 8, Blocks.cobblestone, 0, 2);
			world.setBlock(i + 3, j + 4, k + 8, Blocks.cobblestone, 0, 2);
			world.setBlock(i + 4, j + 4, k + 8, Blocks.cobblestone, 0, 2);
			world.setBlock(i + 5, j + 4, k + 8, Blocks.cobblestone, 0, 2);
			world.setBlock(i + 6, j + 4, k + 8, Blocks.cobblestone, 0, 2);
			
			world.setBlock(i + 3, j + 1, k + 4, Blocks.mob_spawner, 0, 2);
			TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner)world.getTileEntity(i + 3, j + 1, k + 4);
			
			int rand = (int)(1 + Math.random() * 100);
			if (rand <= 25) {
				if (tileentitymobspawner != null)
				{
					tileentitymobspawner.func_145881_a().setEntityName("Zombie");

			        // Get the NBT data from the spawner
			        NBTTagCompound spawnerNBT = new NBTTagCompound();
			        tileentitymobspawner.writeToNBT(spawnerNBT);

			        // Modify SpawnData to customize the spawned zombie
			        NBTTagCompound spawnData = new NBTTagCompound();
			        spawnData.setString("id", "Zombie");

			        // ** Give the zombie a Resistance effect (reduces damage taken) **
			        NBTTagList effects = new NBTTagList();

			        NBTTagCompound resistanceEffect = new NBTTagCompound();
			        resistanceEffect.setByte("Id", (byte) 11); // Resistance effect ID
			        resistanceEffect.setByte("Amplifier", (byte) 1); // Level 2 Resistance
			        resistanceEffect.setInteger("Duration", Integer.MAX_VALUE); // Infinite duration
			        resistanceEffect.setByte("Ambient", (byte) 1);
			        resistanceEffect.setByte("ShowParticles", (byte) 0); // Invisible effect

			        effects.appendTag(resistanceEffect);
			        spawnData.setTag("ActiveEffects", effects);

			        // ** Give the zombie a weapon using Items.diamond_sword **
			        NBTTagList equipment = new NBTTagList();

			        NBTTagCompound weapon = new NBTTagCompound();
			        ItemStack sword = new ItemStack(Items.iron_sword); // Use Items.diamond_sword
			        sword.writeToNBT(weapon);
			        equipment.appendTag(weapon);

			        // ** Fill remaining slots with empty tags to prevent overwriting other equipment **
			        for (int a = 1; a < 5; a++) {
			            equipment.appendTag(new NBTTagCompound());
			        }
			        spawnData.setTag("Equipment", equipment);

			        // ** Prevent the weapon from being removed or replaced **
			        NBTTagList dropChances = new NBTTagList();
			        dropChances.appendTag(new NBTTagFloat(0.0F)); // Weapon (never drops)
			        for (int a = 1; a < 5; a++) {
			            dropChances.appendTag(new NBTTagFloat(0.085F)); // Default drop chance for empty slots
			        }
			        spawnData.setTag("DropChances", dropChances);

			        // ** Ensure the zombie does not despawn **
			        spawnData.setByte("PersistenceRequired", (byte) 1);

			        // Apply SpawnData to spawner
			        spawnerNBT.setTag("SpawnData", spawnData);

			        // Write the modified NBT data back to the spawner
			        tileentitymobspawner.readFromNBT(spawnerNBT);
				}
				
				world.setBlock(i + 3, j + 1, k + 1, Blocks.chest, 3, 2);
				world.setBlock(i + 5, j + 1, k + 4, Blocks.chest, 4, 2);
				world.setBlock(i + 3, j + 1, k + 7, Blocks.air, 0, 2);
			}
	        else if (rand > 25 && rand <= 50) {
	        	if (tileentitymobspawner != null)
				{
	        		tileentitymobspawner.func_145881_a().setEntityName("Skeleton");

			        // Get the NBT data from the spawner
			        NBTTagCompound spawnerNBT = new NBTTagCompound();
			        tileentitymobspawner.writeToNBT(spawnerNBT);

			        // Modify SpawnData to customize the spawned zombie
			        NBTTagCompound spawnData = new NBTTagCompound();
			        spawnData.setString("id", "Skeleton");

			        // ** Give the zombie a Resistance effect (reduces damage taken) **
			        NBTTagList effects = new NBTTagList();

			        NBTTagCompound resistanceEffect = new NBTTagCompound();
			        resistanceEffect.setByte("Id", (byte) 11); // Resistance effect ID
			        resistanceEffect.setByte("Amplifier", (byte) 1); // Level 2 Resistance
			        resistanceEffect.setInteger("Duration", Integer.MAX_VALUE); // Infinite duration
			        resistanceEffect.setByte("Ambient", (byte) 1);
			        resistanceEffect.setByte("ShowParticles", (byte) 0); // Invisible effect

			        effects.appendTag(resistanceEffect);
			        spawnData.setTag("ActiveEffects", effects);

			        // ** Give the zombie a weapon using Items.diamond_sword **
			        NBTTagList equipment = new NBTTagList();

			        NBTTagCompound weapon = new NBTTagCompound();
			        ItemStack sword = new ItemStack(NovaCraftItems.diamond_bow); // Use Items.diamond_sword
			        sword.writeToNBT(weapon);
			        equipment.appendTag(weapon);

			        // ** Fill remaining slots with empty tags to prevent overwriting other equipment **
			        for (int a = 1; a < 5; a++) {
			            equipment.appendTag(new NBTTagCompound());
			        }
			        spawnData.setTag("Equipment", equipment);

			        // ** Prevent the weapon from being removed or replaced **
			        NBTTagList dropChances = new NBTTagList();
			        dropChances.appendTag(new NBTTagFloat(0.0F)); // Weapon (never drops)
			        for (int a = 1; a < 5; a++) {
			            dropChances.appendTag(new NBTTagFloat(0.085F)); // Default drop chance for empty slots
			        }
			        spawnData.setTag("DropChances", dropChances);

			        // ** Ensure the zombie does not despawn **
			        spawnData.setByte("PersistenceRequired", (byte) 1);

			        // Apply SpawnData to spawner
			        spawnerNBT.setTag("SpawnData", spawnData);

			        // Write the modified NBT data back to the spawner
			        tileentitymobspawner.readFromNBT(spawnerNBT);
				}
	        	
	        	world.setBlock(i + 3, j + 1, k + 1, Blocks.chest, 3, 2);
				world.setBlock(i + 5, j + 1, k + 4, Blocks.chest, 4, 2);
				world.setBlock(i + 3, j + 1, k + 7, Blocks.air, 0, 2);
	        	
	        }
	        else if (rand > 50 && rand <= 100) {
	        	if (tileentitymobspawner != null)
				{
	        		tileentitymobspawner.func_145881_a().setEntityName("Skeleton");

			        // Get the NBT data from the spawner
			        NBTTagCompound spawnerNBT = new NBTTagCompound();
			        tileentitymobspawner.writeToNBT(spawnerNBT);

			        // Modify SpawnData to customize the spawned zombie
			        NBTTagCompound spawnData = new NBTTagCompound();
			        spawnData.setString("id", "Skeleton");

			        // ** Give the zombie a Resistance effect (reduces damage taken) **
			        NBTTagList effects = new NBTTagList();

			        NBTTagCompound resistanceEffect = new NBTTagCompound();
			        resistanceEffect.setByte("Id", (byte) 11); // Resistance effect ID
			        resistanceEffect.setByte("Amplifier", (byte) 1); // Level 2 Resistance
			        resistanceEffect.setInteger("Duration", Integer.MAX_VALUE); // Infinite duration
			        resistanceEffect.setByte("Ambient", (byte) 1);
			        resistanceEffect.setByte("ShowParticles", (byte) 0); // Invisible effect

			        effects.appendTag(resistanceEffect);
			        spawnData.setTag("ActiveEffects", effects);

			        // ** Give the zombie a weapon using Items.diamond_sword **
			        NBTTagList equipment = new NBTTagList();

			        NBTTagCompound weapon = new NBTTagCompound();
			        ItemStack sword = new ItemStack(NovaCraftItems.diamond_bow); // Use Items.diamond_sword
			        sword.writeToNBT(weapon);
			        equipment.appendTag(weapon);

			        // ** Fill remaining slots with empty tags to prevent overwriting other equipment **
			        for (int a = 1; a < 5; a++) {
			            equipment.appendTag(new NBTTagCompound());
			        }
			        spawnData.setTag("Equipment", equipment);

			        // ** Prevent the weapon from being removed or replaced **
			        NBTTagList dropChances = new NBTTagList();
			        dropChances.appendTag(new NBTTagFloat(0.0F)); // Weapon (never drops)
			        for (int a = 1; a < 5; a++) {
			            dropChances.appendTag(new NBTTagFloat(0.085F)); // Default drop chance for empty slots
			        }
			        spawnData.setTag("DropChances", dropChances);

			        // ** Ensure the zombie does not despawn **
			        spawnData.setByte("PersistenceRequired", (byte) 1);

			        // Apply SpawnData to spawner
			        spawnerNBT.setTag("SpawnData", spawnData);

			        // Write the modified NBT data back to the spawner
			        tileentitymobspawner.readFromNBT(spawnerNBT);
				}
	        	
	        	world.setBlock(i + 3, j + 1, k + 1, Blocks.chest, 3, 2);
				world.setBlock(i + 5, j + 1, k + 4, Blocks.chest, 4, 2);
				world.setBlock(i + 3, j + 1, k + 7, NovaCraftBlocks.treasure_chest, 0, 2); //2 2
	        }	
		 
		 return true;
	 }

}
