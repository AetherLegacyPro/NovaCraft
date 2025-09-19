package com.NovaCraft.world.structure;

import static net.minecraftforge.common.ChestGenHooks.DUNGEON_CHEST;

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
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.ChestGenHooks;

public class NovaCraftTraditionalDungeonGen extends WorldGenerator {
	
	
	public NovaCraftTraditionalDungeonGen() {

	}
	
	 public boolean generate(final World world, final Random random, final int i, final int j, final int k) {
		 
		 	int randore = (int)(1 + Math.random() * 100);
		 	if (randore <= 25) {
		 		world.setBlock(i + 3, j + 0, k + 0, Blocks.iron_ore, 0, 2);
		 		world.setBlock(i + 0, j + 0, k + 1, Blocks.iron_ore, 0, 2);
				world.setBlock(i + 5, j + 0, k + 1, Blocks.iron_ore, 0, 2);
				world.setBlock(i + 3, j + 0, k + 2, Blocks.iron_ore, 0, 2);
				world.setBlock(i + 1, j + 0, k + 3, Blocks.iron_ore, 0, 2);
				world.setBlock(i + 5, j + 0, k + 3, Blocks.iron_ore, 0, 2);
				world.setBlock(i + 0, j + 0, k + 5, Blocks.iron_ore, 0, 2);
				world.setBlock(i + 6, j + 0, k + 5, Blocks.iron_ore, 0, 2);
				world.setBlock(i + 4, j + 0, k + 6, Blocks.iron_ore, 0, 2);
				world.setBlock(i + 5, j + 0, k + 6, Blocks.iron_ore, 0, 2);
				world.setBlock(i + 1, j + 0, k + 7, Blocks.iron_ore, 0, 2);
				world.setBlock(i + 5, j + 0, k + 7, Blocks.iron_ore, 0, 2);
			
				world.setBlock(i + 4, j + 0, k + 1, NovaCraftBlocks.grimstone_iron, 0, 2);
				world.setBlock(i + 2, j + 0, k + 3, NovaCraftBlocks.grimstone_iron, 0, 2);
				world.setBlock(i + 3, j + 0, k + 6, NovaCraftBlocks.grimstone_iron, 0, 2);
		 	} else if (randore > 25 && randore <= 50) {
		 		world.setBlock(i + 3, j + 0, k + 0, Blocks.gold_ore, 0, 2);
				world.setBlock(i + 0, j + 0, k + 1, Blocks.gold_ore, 0, 2);
				world.setBlock(i + 5, j + 0, k + 1, Blocks.gold_ore, 0, 2);
				world.setBlock(i + 3, j + 0, k + 2, Blocks.gold_ore, 0, 2);
				world.setBlock(i + 1, j + 0, k + 3, Blocks.gold_ore, 0, 2);
				world.setBlock(i + 5, j + 0, k + 3, Blocks.gold_ore, 0, 2);
				world.setBlock(i + 0, j + 0, k + 5, Blocks.gold_ore, 0, 2);
				world.setBlock(i + 6, j + 0, k + 5, Blocks.gold_ore, 0, 2);
				world.setBlock(i + 4, j + 0, k + 6, Blocks.gold_ore, 0, 2);
				world.setBlock(i + 5, j + 0, k + 6, Blocks.gold_ore, 0, 2);
				world.setBlock(i + 1, j + 0, k + 7, Blocks.gold_ore, 0, 2);
				world.setBlock(i + 5, j + 0, k + 7, Blocks.gold_ore, 0, 2);
				
				world.setBlock(i + 4, j + 0, k + 1, NovaCraftBlocks.grimstone_gold, 0, 2);
				world.setBlock(i + 2, j + 0, k + 3, NovaCraftBlocks.grimstone_gold, 0, 2);
				world.setBlock(i + 3, j + 0, k + 6, NovaCraftBlocks.grimstone_gold, 0, 2);
		 	} else if (randore > 50 && randore <= 75) {
		 		world.setBlock(i + 3, j + 0, k + 0, Blocks.redstone_ore, 0, 2);
				world.setBlock(i + 0, j + 0, k + 1, Blocks.redstone_ore, 0, 2);
				world.setBlock(i + 5, j + 0, k + 1, Blocks.redstone_ore, 0, 2);
				world.setBlock(i + 3, j + 0, k + 2, Blocks.redstone_ore, 0, 2);
				world.setBlock(i + 1, j + 0, k + 3, Blocks.redstone_ore, 0, 2);
				world.setBlock(i + 5, j + 0, k + 3, Blocks.redstone_ore, 0, 2);
				world.setBlock(i + 0, j + 0, k + 5, Blocks.redstone_ore, 0, 2);
				world.setBlock(i + 6, j + 0, k + 5, Blocks.redstone_ore, 0, 2);
				world.setBlock(i + 4, j + 0, k + 6, Blocks.redstone_ore, 0, 2);
				world.setBlock(i + 5, j + 0, k + 6, Blocks.redstone_ore, 0, 2);
				world.setBlock(i + 1, j + 0, k + 7, Blocks.redstone_ore, 0, 2);
				world.setBlock(i + 5, j + 0, k + 7, Blocks.redstone_ore, 0, 2);
				
				world.setBlock(i + 4, j + 0, k + 1, NovaCraftBlocks.grimstone_redstone, 0, 2);
				world.setBlock(i + 2, j + 0, k + 3, NovaCraftBlocks.grimstone_redstone, 0, 2);
				world.setBlock(i + 3, j + 0, k + 6, NovaCraftBlocks.grimstone_redstone, 0, 2);
		 	} else if (randore > 75 && randore <= 100) {
		 		world.setBlock(i + 3, j + 0, k + 0, Blocks.lapis_ore, 0, 2);
				world.setBlock(i + 0, j + 0, k + 1, Blocks.lapis_ore, 0, 2);
				world.setBlock(i + 5, j + 0, k + 1, Blocks.lapis_ore, 0, 2);
				world.setBlock(i + 3, j + 0, k + 2, Blocks.lapis_ore, 0, 2);
				world.setBlock(i + 1, j + 0, k + 3, Blocks.lapis_ore, 0, 2);
				world.setBlock(i + 5, j + 0, k + 3, Blocks.lapis_ore, 0, 2);
				world.setBlock(i + 0, j + 0, k + 5, Blocks.lapis_ore, 0, 2);
				world.setBlock(i + 6, j + 0, k + 5, Blocks.lapis_ore, 0, 2);
				world.setBlock(i + 4, j + 0, k + 6, Blocks.lapis_ore, 0, 2);
				world.setBlock(i + 5, j + 0, k + 6, Blocks.lapis_ore, 0, 2);
				world.setBlock(i + 1, j + 0, k + 7, Blocks.lapis_ore, 0, 2);
				world.setBlock(i + 5, j + 0, k + 7, Blocks.lapis_ore, 0, 2);
				
				world.setBlock(i + 4, j + 0, k + 1, NovaCraftBlocks.grimstone_lapis, 0, 2);
				world.setBlock(i + 2, j + 0, k + 3, NovaCraftBlocks.grimstone_lapis, 0, 2);
				world.setBlock(i + 3, j + 0, k + 6, NovaCraftBlocks.grimstone_lapis, 0, 2);
		 	}
		 
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
			
			int rand = (int)(1 + Math.random() * 150);
			if (rand <= 25) {
				if (tileentitymobspawner != null)
				{
					tileentitymobspawner.func_145881_a().setEntityName("Zombie");

			        //Get the NBT data from the spawner
			        NBTTagCompound spawnerNBT = new NBTTagCompound();
			        tileentitymobspawner.writeToNBT(spawnerNBT);

			        //Modify SpawnData to customize the spawned zombie
			        NBTTagCompound spawnData = new NBTTagCompound();
			        spawnData.setString("id", "Zombie");

			        //Give the mob a Resistance effect
			        NBTTagList effects = new NBTTagList();

			        NBTTagCompound resistanceEffect = new NBTTagCompound();
			        resistanceEffect.setByte("Id", (byte) 11); //Resistance effect ID
			        resistanceEffect.setByte("Amplifier", (byte) 1); //Level 2 Resistance
			        resistanceEffect.setInteger("Duration", Integer.MAX_VALUE); //Infinite duration
			        resistanceEffect.setByte("Ambient", (byte) 1);
			        resistanceEffect.setByte("ShowParticles", (byte) 0); //Invisible effect???

			        effects.appendTag(resistanceEffect);
			        spawnData.setTag("ActiveEffects", effects);

			        //Gives weapon
			        NBTTagList equipment = new NBTTagList();

			        NBTTagCompound weapon = new NBTTagCompound();
			        ItemStack sword = new ItemStack(Items.iron_sword);
			        sword.writeToNBT(weapon);
			        equipment.appendTag(weapon);

			        //Fill remaining slots with empty tags to prevent overwriting other equipment
			        for (int a = 1; a < 5; a++) {
			            equipment.appendTag(new NBTTagCompound());
			        }
			        spawnData.setTag("Equipment", equipment);

			        //Prevent the weapon from being removed or replaced
			        NBTTagList dropChances = new NBTTagList();
			        dropChances.appendTag(new NBTTagFloat(0.0F)); //Weapon (never drops)
			        for (int a = 1; a < 5; a++) {
			            dropChances.appendTag(new NBTTagFloat(0.085F)); //Default drop chance for empty slots
			        }
			        spawnData.setTag("DropChances", dropChances);

			        //Apply SpawnData to spawner
			        spawnerNBT.setTag("SpawnData", spawnData);

			        //Write the modified NBT data back to the spawner
			        tileentitymobspawner.readFromNBT(spawnerNBT);
				}
				
				world.setBlock(i + 3, j + 1, k + 1, Blocks.chest, 3, 2);
	        	TileEntityChest tileentitychest = (TileEntityChest)world.getTileEntity(i + 3, j + 1, k + 1);

                if (tileentitychest != null)
                {
                    WeightedRandomChestContent.generateChestContents(random, ChestGenHooks.getItems(DUNGEON_CHEST, random), tileentitychest, ChestGenHooks.getCount(DUNGEON_CHEST, random));
                                       
                }
                
				world.setBlock(i + 5, j + 1, k + 4, Blocks.chest, 4, 2);
				TileEntityChest tileentitychest2 = (TileEntityChest)world.getTileEntity(i + 5, j + 1, k + 4);

                if (tileentitychest2 != null)
                {
                    WeightedRandomChestContent.generateChestContents(random, ChestGenHooks.getItems(DUNGEON_CHEST, random), tileentitychest2, ChestGenHooks.getCount(DUNGEON_CHEST, random));
                                       
                }
				world.setBlock(i + 3, j + 1, k + 7, Blocks.air, 0, 2);
			}
	        else if (rand > 25 && rand <= 50) {
	        	if (tileentitymobspawner != null)
				{
	        		tileentitymobspawner.func_145881_a().setEntityName("Skeleton");

			        NBTTagCompound spawnerNBT = new NBTTagCompound();
			        tileentitymobspawner.writeToNBT(spawnerNBT);

			        NBTTagCompound spawnData = new NBTTagCompound();
			        spawnData.setString("id", "Skeleton");

			        NBTTagList effects = new NBTTagList();

			        NBTTagCompound resistanceEffect = new NBTTagCompound();
			        resistanceEffect.setByte("Id", (byte) 11);
			        resistanceEffect.setByte("Amplifier", (byte) 1); 
			        resistanceEffect.setInteger("Duration", Integer.MAX_VALUE);
			        resistanceEffect.setByte("Ambient", (byte) 1);
			        resistanceEffect.setByte("ShowParticles", (byte) 0);

			        effects.appendTag(resistanceEffect);
			        spawnData.setTag("ActiveEffects", effects);

			        NBTTagList equipment = new NBTTagList();

			        NBTTagCompound weapon = new NBTTagCompound();
			        ItemStack sword = new ItemStack(Items.bow);
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
	        	
	        	world.setBlock(i + 3, j + 1, k + 1, Blocks.chest, 3, 2);
	        	TileEntityChest tileentitychest = (TileEntityChest)world.getTileEntity(i + 3, j + 1, k + 1);

                if (tileentitychest != null)
                {
                    WeightedRandomChestContent.generateChestContents(random, ChestGenHooks.getItems(DUNGEON_CHEST, random), tileentitychest, ChestGenHooks.getCount(DUNGEON_CHEST, random));
                                       
                }
                
				world.setBlock(i + 5, j + 1, k + 4, Blocks.chest, 4, 2);
				TileEntityChest tileentitychest2 = (TileEntityChest)world.getTileEntity(i + 5, j + 1, k + 4);

                if (tileentitychest2 != null)
                {
                    WeightedRandomChestContent.generateChestContents(random, ChestGenHooks.getItems(DUNGEON_CHEST, random), tileentitychest2, ChestGenHooks.getCount(DUNGEON_CHEST, random));
                                       
                }
				world.setBlock(i + 3, j + 1, k + 7, Blocks.air, 0, 2);
	        	
	        }
	        else if (rand > 50 && rand <= 100) {
	        	if (tileentitymobspawner != null)
				{
	        		tileentitymobspawner.func_145881_a().setEntityName("Skeleton");

			        NBTTagCompound spawnerNBT = new NBTTagCompound();
			        tileentitymobspawner.writeToNBT(spawnerNBT);

			        NBTTagCompound spawnData = new NBTTagCompound();
			        spawnData.setString("id", "Skeleton");

			        NBTTagList effects = new NBTTagList();

			        NBTTagCompound resistanceEffect = new NBTTagCompound();
			        resistanceEffect.setByte("Id", (byte) 11);
			        resistanceEffect.setByte("Amplifier", (byte) 1); 
			        resistanceEffect.setInteger("Duration", Integer.MAX_VALUE);
			        resistanceEffect.setByte("Ambient", (byte) 1);
			        resistanceEffect.setByte("ShowParticles", (byte) 0);

			        effects.appendTag(resistanceEffect);
			        spawnData.setTag("ActiveEffects", effects);

			        NBTTagList equipment = new NBTTagList();

			        NBTTagCompound weapon = new NBTTagCompound();
			        ItemStack sword = new ItemStack(Items.bowl);
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
	        	
	        	world.setBlock(i + 3, j + 1, k + 1, Blocks.chest, 3, 2);
	        	TileEntityChest tileentitychest = (TileEntityChest)world.getTileEntity(i + 3, j + 1, k + 1);

                if (tileentitychest != null)
                {
                    WeightedRandomChestContent.generateChestContents(random, ChestGenHooks.getItems(DUNGEON_CHEST, random), tileentitychest, ChestGenHooks.getCount(DUNGEON_CHEST, random));
                                       
                }
                
				world.setBlock(i + 5, j + 1, k + 4, Blocks.chest, 4, 2);
				TileEntityChest tileentitychest2 = (TileEntityChest)world.getTileEntity(i + 5, j + 1, k + 4);

                if (tileentitychest2 != null)
                {
                    WeightedRandomChestContent.generateChestContents(random, ChestGenHooks.getItems(DUNGEON_CHEST, random), tileentitychest2, ChestGenHooks.getCount(DUNGEON_CHEST, random));
                                       
                }
                
				world.setBlock(i + 3, j + 1, k + 7, NovaCraftBlocks.treasure_chest, 0, 2); //2 2
	        }
			
	        else if (rand > 100) {
	        	if (tileentitymobspawner != null)
				{
	        		tileentitymobspawner.func_145881_a().setEntityName("Spider");

			        NBTTagCompound spawnerNBT = new NBTTagCompound();
			        tileentitymobspawner.writeToNBT(spawnerNBT);

			        NBTTagCompound spawnData = new NBTTagCompound();
			        spawnData.setString("id", "Spider");

			        NBTTagList effects = new NBTTagList();

			        NBTTagCompound resistanceEffect = new NBTTagCompound();
			        resistanceEffect.setByte("Id", (byte) 11);
			        resistanceEffect.setByte("Amplifier", (byte) 2);
			        resistanceEffect.setInteger("Duration", Integer.MAX_VALUE);
			        resistanceEffect.setByte("Ambient", (byte) 1);
			        resistanceEffect.setByte("ShowParticles", (byte) 0);

			        effects.appendTag(resistanceEffect);
			        spawnData.setTag("ActiveEffects", effects);
			        
			        spawnerNBT.setTag("SpawnData", spawnData);

			        tileentitymobspawner.readFromNBT(spawnerNBT);
				}
	        	
	        	world.setBlock(i + 3, j + 1, k + 1, Blocks.air, 0, 2);
				world.setBlock(i + 5, j + 1, k + 4, Blocks.chest, 4, 2);
				TileEntityChest tileentitychest2 = (TileEntityChest)world.getTileEntity(i + 5, j + 1, k + 4);

                if (tileentitychest2 != null)
                {
                    WeightedRandomChestContent.generateChestContents(random, ChestGenHooks.getItems(DUNGEON_CHEST, random), tileentitychest2, ChestGenHooks.getCount(DUNGEON_CHEST, random));
                                       
                }
				world.setBlock(i + 3, j + 1, k + 7, NovaCraftBlocks.treasure_chest, 0, 2); //2 2
	        }
		 
		 return true;
	 }

}
