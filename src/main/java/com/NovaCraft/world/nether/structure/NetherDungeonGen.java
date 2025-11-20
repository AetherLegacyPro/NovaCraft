package com.NovaCraft.world.nether.structure;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.world.gen.feature.*;
import net.minecraft.block.*;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.world.*;
import java.util.*;
import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.config.Configs;
import com.NovaCraft.registry.OtherModItems;
import com.NovaCraftBlocks.NovaCraftBlocks;
import cpw.mods.fml.common.Loader;
import net.minecraft.init.*;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityMobSpawner;

public class NetherDungeonGen extends WorldGenerator
{
	public NetherDungeonGen() {

	}
	private Block PlacePolishedBlackstone;
	private Block PlaceCrackedPolishedBlackstone;
	private Block PlaceGildedBlackstone;
	private Block PlaceChiseledBlackstone;

	private Block determineIfPolishedBlackstoneBricksExists(World world, int x, int y, int z) {
		Block existingBlock = world.getBlock(x, y, z);
		if (Configs.enableBlackstoneBricksInNetherStructures && Loader.isModLoaded("netherlicious")) {
			try {
				Block Blackstone = GameRegistry.findBlock("netherlicious", "Blackstone");
				if (Blackstone != null && (existingBlock == null || existingBlock != Blackstone)) {
					return Blackstone;
				}
			} catch (Exception ex) {
				if (Configs.enableDebugMode) {
					System.out.println("Missing Polished Blackstone from Netherlicious, using Basal instead...");
				}
				return NovaCraftBlocks.basal_bricks;
			}
		}

		return NovaCraftBlocks.basal_bricks;
	}

	private Block determineIfCrackedBlackstoneBricksExists(World world, int x, int y, int z) {
		Block existingBlock = world.getBlock(x, y, z);
		if (Configs.enableBlackstoneBricksInNetherStructures && Loader.isModLoaded("netherlicious")) {
			try {
				Block Blackstone = GameRegistry.findBlock("netherlicious", "Blackstone");
				if (Blackstone != null && (existingBlock == null || existingBlock != Blackstone)) {
					return Blackstone;
				}
			} catch (Exception ex) {
				if (Configs.enableDebugMode) {
					System.out.println("Missing Cracked Blackstone from Netherlicious, using Basal instead...");
				}
				return NovaCraftBlocks.cracked_basal_bricks;
			}
		}

		return NovaCraftBlocks.cracked_basal_bricks;
	}

	private Block determineIfGildedBlackstoneExists(World world, int x, int y, int z) {
		Block existingBlock = world.getBlock(x, y, z);
		if (Configs.enableBlackstoneBricksInNetherStructures && Loader.isModLoaded("netherlicious")) {
			try {
				Block Blackstone = GameRegistry.findBlock("netherlicious", "Blackstone");
				if (Blackstone != null && (existingBlock == null || existingBlock != Blackstone)) {
					return Blackstone;
				}
			} catch (Exception ex) {
				if (Configs.enableDebugMode) {
					System.out.println("Missing Gilded Blackstone from Netherlicious, using Basal instead...");
				}
				return NovaCraftBlocks.glowing_basal;
			}
		}

		return NovaCraftBlocks.glowing_basal;
	}

	private Block determineIfChiseledBlackstoneExists(World world, int x, int y, int z) {
		Block existingBlock = world.getBlock(x, y, z);
		if (Configs.enableBlackstoneBricksInNetherStructures && Loader.isModLoaded("netherlicious")) {
			try {
				Block Blackstone = GameRegistry.findBlock("netherlicious", "Blackstone");
				if (Blackstone != null && (existingBlock == null || existingBlock != Blackstone)) {
					return Blackstone;
				}
			} catch (Exception ex) {
				if (Configs.enableDebugMode) {
					System.out.println("Missing Chiseled Blackstone from Netherlicious, using Basal instead...");
				}
				return NovaCraftBlocks.chiseled_basal;
			}
		}

		return NovaCraftBlocks.chiseled_basal;
	}
	
	 public boolean generate(final World world, final Random random, final int i, final int j, final int k) {
		 PlacePolishedBlackstone = determineIfPolishedBlackstoneBricksExists(world, i, j, k);
		 PlaceCrackedPolishedBlackstone = determineIfCrackedBlackstoneBricksExists(world, i + 3, j, k);
		 PlaceGildedBlackstone = determineIfGildedBlackstoneExists(world, i + 3, j, k);
		 PlaceChiseledBlackstone = determineIfChiseledBlackstoneExists(world, i + 2, j + 3, k + 7);
		 
		 	world.setBlock(i, j, k, PlacePolishedBlackstone, 3, 2);
			world.setBlock(i + 1, j, k, PlacePolishedBlackstone, 3, 2);
			world.setBlock(i + 2, j, k, PlaceGildedBlackstone, 5, 2);
			world.setBlock(i + 3, j, k, PlaceCrackedPolishedBlackstone, 4, 2);
			world.setBlock(i + 4, j, k, PlaceCrackedPolishedBlackstone, 4, 2);
			world.setBlock(i + 5, j, k, PlaceGildedBlackstone, 5, 2);
			world.setBlock(i + 6, j, k, PlaceCrackedPolishedBlackstone, 4, 2);
			world.setBlock(i, j, k + 1, PlaceGildedBlackstone, 5, 2);
			world.setBlock(i + 1, j, k + 1, PlacePolishedBlackstone, 3, 2);
			world.setBlock(i + 2, j, k + 1, PlacePolishedBlackstone, 3, 2);
			world.setBlock(i + 3, j, k + 1, PlaceCrackedPolishedBlackstone, 4, 2);
			world.setBlock(i + 4, j, k + 1, PlacePolishedBlackstone, 3, 2);
			world.setBlock(i + 5, j, k + 1, PlaceCrackedPolishedBlackstone, 4, 2);
			world.setBlock(i + 6, j, k + 1, PlacePolishedBlackstone, 3, 2);
			world.setBlock(i, j, k + 2, PlacePolishedBlackstone, 3, 2);
			world.setBlock(i + 1, j, k + 2, PlaceCrackedPolishedBlackstone, 4, 2);
			world.setBlock(i + 2, j, k + 2, PlaceGildedBlackstone, 5, 2);
			world.setBlock(i + 3, j, k + 2, PlacePolishedBlackstone, 3, 2);
			world.setBlock(i + 4, j, k + 2, PlacePolishedBlackstone, 3, 2);
			world.setBlock(i + 5, j, k + 2, PlacePolishedBlackstone, 3, 2);
			world.setBlock(i + 6, j, k + 2, PlacePolishedBlackstone, 3, 2);
			world.setBlock(i, j, k + 3, PlaceGildedBlackstone, 5, 2);
			world.setBlock(i + 1, j, k + 3, PlacePolishedBlackstone, 3, 2);
			world.setBlock(i + 2, j, k + 3, PlacePolishedBlackstone, 3, 2);
			world.setBlock(i + 3, j, k + 3, PlaceCrackedPolishedBlackstone, 4, 2);
			world.setBlock(i + 4, j, k + 3, PlaceGildedBlackstone, 5, 2);
			world.setBlock(i + 5, j, k + 3, PlacePolishedBlackstone, 3, 2);
			world.setBlock(i + 6, j, k + 3, PlacePolishedBlackstone, 3, 2);
			world.setBlock(i, j, k + 4, PlaceGildedBlackstone, 5, 2);
			world.setBlock(i + 1, j, k + 4, PlaceGildedBlackstone, 5, 2);
			world.setBlock(i + 2, j, k + 4, PlaceGildedBlackstone, 5, 2);
			world.setBlock(i + 3, j, k + 4, Blocks.obsidian, 0, 2);
			world.setBlock(i + 4, j, k + 4, PlaceCrackedPolishedBlackstone, 4, 2);
			world.setBlock(i + 5, j, k + 4, PlaceCrackedPolishedBlackstone, 4, 2);
			world.setBlock(i + 6, j, k + 4, PlaceCrackedPolishedBlackstone, 4, 2);
			world.setBlock(i, j, k + 5, PlaceGildedBlackstone, 5, 2);
			world.setBlock(i + 1, j, k + 5, PlacePolishedBlackstone, 3, 2);
			world.setBlock(i + 2, j, k + 5, PlacePolishedBlackstone, 3, 2);
			world.setBlock(i + 3, j, k + 5, PlacePolishedBlackstone, 3, 2);
			world.setBlock(i + 4, j, k + 5, PlaceGildedBlackstone, 5, 2);
			world.setBlock(i + 5, j, k + 5, PlaceCrackedPolishedBlackstone, 4, 2);
			world.setBlock(i + 6, j, k + 5, PlaceCrackedPolishedBlackstone, 4, 2);
			world.setBlock(i, j, k + 6, PlaceCrackedPolishedBlackstone, 4, 2);
			world.setBlock(i + 1, j, k + 6, PlaceCrackedPolishedBlackstone, 4, 2);
			world.setBlock(i + 2, j, k + 6, PlacePolishedBlackstone, 3, 2);
			world.setBlock(i + 3, j, k + 6, PlacePolishedBlackstone, 3, 2);
			world.setBlock(i + 4, j, k + 6, PlacePolishedBlackstone, 3, 2);
			world.setBlock(i + 5, j, k + 6, PlaceCrackedPolishedBlackstone, 4, 2);
			world.setBlock(i + 6, j, k + 6, PlacePolishedBlackstone, 3, 2);
			world.setBlock(i, j, k + 7, PlaceCrackedPolishedBlackstone, 4, 2);
			world.setBlock(i + 1, j, k + 7, PlacePolishedBlackstone, 3, 2);
			world.setBlock(i + 2, j, k + 7, PlacePolishedBlackstone, 3, 2);
			world.setBlock(i + 3, j, k + 7, PlaceCrackedPolishedBlackstone, 4, 2);
			world.setBlock(i + 4, j, k + 7, PlacePolishedBlackstone, 3, 2);
			world.setBlock(i + 5, j, k + 7, PlaceGildedBlackstone, 5, 2);
			world.setBlock(i + 6, j, k + 7, PlacePolishedBlackstone, 3, 2);
			world.setBlock(i, j, k + 8, PlacePolishedBlackstone, 3, 2);
			world.setBlock(i + 1, j, k + 8, PlaceGildedBlackstone, 5, 2);
			world.setBlock(i + 2, j, k + 8, PlaceGildedBlackstone, 5, 2);
			world.setBlock(i + 3, j, k + 8, PlaceCrackedPolishedBlackstone, 4, 2);
			world.setBlock(i + 4, j, k + 8, PlacePolishedBlackstone, 3, 2);
			world.setBlock(i + 5, j, k + 8, PlacePolishedBlackstone, 3, 2);
			world.setBlock(i + 6, j, k + 8, PlacePolishedBlackstone, 3, 2);
			world.setBlock(i, j + 1, k, PlaceGildedBlackstone, 5, 2);
			world.setBlock(i + 1, j + 1, k, PlacePolishedBlackstone, 3, 2);
			world.setBlock(i + 2, j + 1, k, PlacePolishedBlackstone, 3, 2);
			world.setBlock(i + 3, j + 1, k, PlaceCrackedPolishedBlackstone, 4, 2);
			world.setBlock(i + 4, j + 1, k, PlacePolishedBlackstone, 3, 2);
			world.setBlock(i + 5, j + 1, k, PlacePolishedBlackstone, 3, 2);
			world.setBlock(i + 6, j + 1, k, PlacePolishedBlackstone, 3, 2);
			world.setBlock(i, j + 1, k + 1, PlaceCrackedPolishedBlackstone, 4, 2);
			world.setBlock(i + 1, j + 1, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 1, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 1, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 1, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 1, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 1, k + 1, PlaceCrackedPolishedBlackstone, 4, 2);
			world.setBlock(i, j + 1, k + 2, PlaceCrackedPolishedBlackstone, 4, 2);
			world.setBlock(i + 1, j + 1, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 1, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 1, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 1, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 1, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 1, k + 2, PlacePolishedBlackstone, 3, 2);
			world.setBlock(i, j + 1, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 1, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 1, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 1, k + 3, Blocks.obsidian, 0, 2);
			world.setBlock(i + 4, j + 1, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 1, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 1, k + 3, PlaceGildedBlackstone, 5, 2);
			world.setBlock(i, j + 1, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 1, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 1, k + 4, Blocks.obsidian, 0, 2);
			world.setBlock(i + 4, j + 1, k + 4, Blocks.obsidian, 0, 2);
			world.setBlock(i + 5, j + 1, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 1, k + 4, PlacePolishedBlackstone, 3, 2);
			world.setBlock(i, j + 1, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 1, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 1, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 1, k + 5, Blocks.obsidian, 0, 2);
			world.setBlock(i + 4, j + 1, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 1, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 1, k + 5, PlaceGildedBlackstone, 5, 2);
			world.setBlock(i, j + 1, k + 6, PlaceCrackedPolishedBlackstone, 4, 2);
			world.setBlock(i + 1, j + 1, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 1, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 1, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 1, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 1, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 1, k + 6, PlacePolishedBlackstone, 3, 2);
			world.setBlock(i, j + 1, k + 7, PlaceGildedBlackstone, 5, 2);
			world.setBlock(i + 1, j + 1, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 1, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 1, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 1, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 1, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 1, k + 7, PlaceCrackedPolishedBlackstone, 4, 2);
			world.setBlock(i, j + 1, k + 8, PlacePolishedBlackstone, 3, 2);
			world.setBlock(i + 1, j + 1, k + 8, PlaceCrackedPolishedBlackstone, 4, 2);
			world.setBlock(i + 2, j + 1, k + 8, PlacePolishedBlackstone, 3, 2);
			world.setBlock(i + 3, j + 1, k + 8, PlaceGildedBlackstone, 5, 2);
			world.setBlock(i + 4, j + 1, k + 8, PlacePolishedBlackstone, 3, 2);
			world.setBlock(i + 5, j + 1, k + 8, PlacePolishedBlackstone, 3, 2);
			world.setBlock(i + 6, j + 1, k + 8, PlacePolishedBlackstone, 3, 2);
			world.setBlock(i, j + 2, k, PlaceCrackedPolishedBlackstone, 4, 2);
			world.setBlock(i + 1, j + 2, k, PlacePolishedBlackstone, 3, 2);
			world.setBlock(i + 2, j + 2, k, PlaceCrackedPolishedBlackstone, 4, 2);
			world.setBlock(i + 3, j + 2, k, PlaceCrackedPolishedBlackstone, 4, 2);
			world.setBlock(i + 4, j + 2, k, PlaceGildedBlackstone, 5, 2);
			world.setBlock(i + 5, j + 2, k, PlaceCrackedPolishedBlackstone, 4, 2);
			world.setBlock(i + 6, j + 2, k, PlaceGildedBlackstone, 5, 2);
			world.setBlock(i, j + 2, k + 1, PlaceCrackedPolishedBlackstone, 4, 2);
			world.setBlock(i + 1, j + 2, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 2, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 2, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 2, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 2, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 2, k + 1, PlacePolishedBlackstone, 3, 2);
			world.setBlock(i, j + 2, k + 2, PlaceGildedBlackstone, 5, 2);
			world.setBlock(i + 1, j + 2, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 2, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 2, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 2, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 2, k + 2, Blocks.gold_block, 0, 2);
			world.setBlock(i + 6, j + 2, k + 2, PlaceGildedBlackstone, 5, 2);
			world.setBlock(i, j + 2, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 2, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 2, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 2, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 2, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 2, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 2, k + 3, PlaceGildedBlackstone, 5, 2);
			world.setBlock(i, j + 2, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 2, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 2, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 2, k + 4, Blocks.obsidian, 0, 2);
			world.setBlock(i + 4, j + 2, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 2, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 2, k + 4, PlaceCrackedPolishedBlackstone, 4, 2);
			world.setBlock(i, j + 2, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 2, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 2, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 2, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 2, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 2, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 2, k + 5, PlacePolishedBlackstone, 3, 2);
			world.setBlock(i, j + 2, k + 6, PlacePolishedBlackstone, 3, 2);
			world.setBlock(i + 1, j + 2, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 2, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 2, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 2, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 2, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 2, k + 6, PlaceGildedBlackstone, 5, 2);
			world.setBlock(i, j + 2, k + 7, PlaceCrackedPolishedBlackstone, 4, 2);
			world.setBlock(i + 1, j + 2, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 2, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 2, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 2, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 2, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 2, k + 7, PlacePolishedBlackstone, 3, 2);
			world.setBlock(i, j + 2, k + 8, PlaceGildedBlackstone, 5, 2);
			world.setBlock(i + 1, j + 2, k + 8, PlacePolishedBlackstone, 3, 2);
			world.setBlock(i + 2, j + 2, k + 8, PlaceGildedBlackstone, 5, 2);
			world.setBlock(i + 3, j + 2, k + 8, PlacePolishedBlackstone, 3, 2);
			world.setBlock(i + 4, j + 2, k + 8, PlaceGildedBlackstone, 5, 2);
			world.setBlock(i + 5, j + 2, k + 8, PlacePolishedBlackstone, 3, 2);
			world.setBlock(i + 6, j + 2, k + 8, PlaceGildedBlackstone, 5, 2);
			world.setBlock(i, j + 3, k, PlaceCrackedPolishedBlackstone, 4, 2);
			world.setBlock(i + 1, j + 3, k, PlacePolishedBlackstone, 3, 2);
			world.setBlock(i + 2, j + 3, k, PlacePolishedBlackstone, 3, 2);
			world.setBlock(i + 3, j + 3, k, PlaceGildedBlackstone, 5, 2);
			world.setBlock(i + 4, j + 3, k, PlacePolishedBlackstone, 3, 2);
			world.setBlock(i + 5, j + 3, k, PlacePolishedBlackstone, 3, 2);
			world.setBlock(i + 6, j + 3, k, PlaceCrackedPolishedBlackstone, 4, 2);
			world.setBlock(i, j + 3, k + 1, PlacePolishedBlackstone, 3, 2);
			world.setBlock(i + 1, j + 3, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 3, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 3, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 3, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 3, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 3, k + 1, PlaceGildedBlackstone, 5, 2);
			world.setBlock(i, j + 3, k + 2, PlacePolishedBlackstone, 3, 2);
			world.setBlock(i + 1, j + 3, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 3, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 3, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 3, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 3, k + 2, PlacePolishedBlackstone, 3, 2);
			world.setBlock(i, j + 3, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 3, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 3, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 3, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 3, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 3, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 3, k + 3, PlacePolishedBlackstone, 3, 2);
			world.setBlock(i, j + 3, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 3, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 3, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 3, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 3, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 3, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 3, k + 4, PlaceGildedBlackstone, 5, 2);
			world.setBlock(i, j + 3, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 3, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 3, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 3, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 3, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 3, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 3, k + 5, PlacePolishedBlackstone, 3, 2);
			world.setBlock(i, j + 3, k + 6, PlaceGildedBlackstone, 5, 2);
			world.setBlock(i + 1, j + 3, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 3, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 3, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 3, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 3, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 3, k + 6, PlaceGildedBlackstone, 5, 2);
			world.setBlock(i, j + 3, k + 7, PlaceCrackedPolishedBlackstone, 4, 2);
			world.setBlock(i + 1, j + 3, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 3, k + 7, PlaceChiseledBlackstone, 2, 2);
			world.setBlock(i + 3, j + 3, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 3, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 3, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 3, k + 7, PlacePolishedBlackstone, 3, 2);
			world.setBlock(i, j + 3, k + 8, PlaceCrackedPolishedBlackstone, 4, 2);
			world.setBlock(i + 1, j + 3, k + 8, PlaceGildedBlackstone, 5, 2);
			world.setBlock(i + 2, j + 3, k + 8, PlacePolishedBlackstone, 3, 2);
			world.setBlock(i + 3, j + 3, k + 8, PlacePolishedBlackstone, 3, 2);
			world.setBlock(i + 4, j + 3, k + 8, PlacePolishedBlackstone, 3, 2);
			world.setBlock(i + 5, j + 3, k + 8, PlaceGildedBlackstone, 5, 2);
			world.setBlock(i + 6, j + 3, k + 8, PlacePolishedBlackstone, 3, 2);
			world.setBlock(i, j + 4, k, PlacePolishedBlackstone, 3, 2);
			world.setBlock(i + 1, j + 4, k, PlacePolishedBlackstone, 3, 2);
			world.setBlock(i + 2, j + 4, k, PlacePolishedBlackstone, 3, 2);
			world.setBlock(i + 3, j + 4, k, PlaceCrackedPolishedBlackstone, 4, 2);
			world.setBlock(i + 4, j + 4, k, PlaceGildedBlackstone, 5, 2);
			world.setBlock(i + 5, j + 4, k, PlaceCrackedPolishedBlackstone, 4, 2);
			world.setBlock(i + 6, j + 4, k, PlacePolishedBlackstone, 3, 2);
			world.setBlock(i, j + 4, k + 1, PlaceGildedBlackstone, 5, 2);
			world.setBlock(i + 1, j + 4, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 4, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 4, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 4, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 4, k + 1, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 4, k + 1, PlacePolishedBlackstone, 3, 2);
			world.setBlock(i, j + 4, k + 2, PlaceGildedBlackstone, 5, 2);
			world.setBlock(i + 1, j + 4, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 4, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 4, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 4, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 4, k + 2, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 4, k + 2, PlacePolishedBlackstone, 3, 2);
			world.setBlock(i, j + 4, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 4, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 4, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 4, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 4, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 4, k + 3, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 4, k + 3, PlaceGildedBlackstone, 5, 2);
			world.setBlock(i, j + 4, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 4, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 4, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 4, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 4, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 4, k + 4, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 4, k + 4, PlaceCrackedPolishedBlackstone, 4, 2);
			world.setBlock(i, j + 4, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 1, j + 4, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 4, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 4, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 4, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 4, k + 5, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 4, k + 5, PlaceGildedBlackstone, 5, 2);
			world.setBlock(i, j + 4, k + 6, PlacePolishedBlackstone, 3, 2);
			world.setBlock(i + 1, j + 4, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 2, j + 4, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 4, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 4, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 4, k + 6, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 4, k + 6, PlaceCrackedPolishedBlackstone, 4, 2);
			world.setBlock(i, j + 4, k + 7, PlacePolishedBlackstone, 3, 2);
			world.setBlock(i + 1, j + 4, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 3, j + 4, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 4, j + 4, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 5, j + 4, k + 7, Blocks.air, 0, 2);
			world.setBlock(i + 6, j + 4, k + 7, PlaceGildedBlackstone, 5, 2);
			world.setBlock(i, j + 4, k + 8, PlacePolishedBlackstone, 3, 2);
			world.setBlock(i + 1, j + 4, k + 8, PlaceCrackedPolishedBlackstone, 4, 2);
			world.setBlock(i + 2, j + 4, k + 8, PlacePolishedBlackstone, 3, 2);
			world.setBlock(i + 3, j + 4, k + 8, PlaceGildedBlackstone, 5, 2);
			world.setBlock(i + 4, j + 4, k + 8, PlaceCrackedPolishedBlackstone, 4, 2);
			world.setBlock(i + 5, j + 4, k + 8, PlacePolishedBlackstone, 3, 2);
			world.setBlock(i + 6, j + 4, k + 8, PlacePolishedBlackstone, 3, 2);
			
			world.setBlock(i + 3, j + 1, k + 4, Blocks.mob_spawner, 0, 2);
			TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner)world.getTileEntity(i + 3, j + 1, k + 4);
			
			int rand = (int)(1 + Math.random() * 100);
			if (rand <= 25) {
				if (tileentitymobspawner != null)
				{
					tileentitymobspawner.func_145881_a().setEntityName("nova_craft.slaughter");
				}
			}
	        else if (rand <= 50) {
	        	if (tileentitymobspawner != null)
				{
	        		final EntitySkeleton skeleton = new EntitySkeleton(world);
					tileentitymobspawner.func_145881_a().setEntityName("Skeleton");
					skeleton.setHealth(40);
				}
	        } else {
	        	if (tileentitymobspawner != null)
				{
					tileentitymobspawner.func_145881_a().setEntityName("nova_craft.drifter");
				}
	        }
			
			world.setBlock(i + 5, j + 3, k + 2, Blocks.chest, 4, 2);
			TileEntityChest chest = (TileEntityChest) world.getTileEntity(i + 5, j + 3, k + 2);

			for (int slot = 0; slot < 3 + random.nextInt(25); slot++) {
				chest.setInventorySlotContents(random.nextInt(chest.getSizeInventory()), this.getDungeonLoot(random));
			}
			
			world.setBlock(i + 2, j + 4, k + 7, Blocks.chest, 2, 2);
			TileEntityChest chest2 = (TileEntityChest) world.getTileEntity(i + 2, j + 4, k + 7);

			for (int slot = 0; slot < 3 + random.nextInt(25); slot++) {
				chest2.setInventorySlotContents(random.nextInt(chest.getSizeInventory()), this.getDungeonLoot(random));
			}
		 
		 return true;
	 }
	 
	 private ItemStack getDungeonLoot(Random random) {
			int item = random.nextInt(23);
			switch (item) {
				case 0:
					return new ItemStack(NovaCraftItems.phoenix_feather, random.nextInt(2) + 1);
				case 1:
					return new ItemStack(Items.ghast_tear, 1);
				case 2:
					return new ItemStack(Items.magma_cream, random.nextInt(3) + 1);
				case 3:
					return new ItemStack(Items.quartz, random.nextInt(12) + 18);
				case 4:
					return new ItemStack(Items.gold_nugget, random.nextInt(35) + 18);
				case 5:
					return new ItemStack(Items.iron_ingot, random.nextInt(12) + 18);
				case 6:
					return new ItemStack(Items.gold_ingot, random.nextInt(4) + 8);
				case 7: 
					return new ItemStack(NovaCraftItems.vanite_chunk, random.nextInt(3) + 4);
				case 8: 
					return new ItemStack(NovaCraftItems.flaming_pitcher_petal, 1);
				case 9: 
					return new ItemStack(NovaCraftItems.blazing_coal, random.nextInt(4) + 7);
				case 10: 
					return new ItemStack(Items.glowstone_dust, random.nextInt(4) + 8);
				case 11: 
					return new ItemStack(Items.golden_apple, 1);
				case 12: 
					return new ItemStack(NovaCraftBlocks.ion_mushroom, random.nextInt(3) + 1);
				case 13: 
					return new ItemStack(NovaCraftBlocks.deepoid_mushroom, random.nextInt(3) + 1);
				case 14: 
					return new ItemStack(NovaCraftBlocks.hell_piliz, random.nextInt(3) + 1);
				case 15:
					if (Loader.isModLoaded("netherlicious")) {
						return new ItemStack(OtherModItems.VoidQuartzItem, random.nextInt(3) + 7);
					}
					else {
						return new ItemStack(Items.gold_nugget, random.nextInt(35) + 18);
					}
				case 16: 
					if (Loader.isModLoaded("divinerpg")) {
						return new ItemStack(OtherModItems.netheriteIngot, random.nextInt(3) + 2);
					}
					else {
						return new ItemStack(Items.iron_ingot, random.nextInt(12) + 18);
					 }
				case 17:
					if (Loader.isModLoaded("etfuturum") && Configs.enableNetheriteInRecipes) {
						return new ItemStack(OtherModItems.netherite_scrap, 1);
					}
					else {
						return new ItemStack(Items.ghast_tear, 1);
					}
				case 18: 
					return new ItemStack(NovaCraftItems.yttrlinsite_shard, random.nextInt(2) + 1);
				case 19: 
					return new ItemStack(NovaCraftItems.scythe, 1);
				case 20: 
					return new ItemStack(Items.diamond, 1);
					
				default: {
					return new ItemStack(Items.quartz, random.nextInt(12) + 18);
				}
			}
		}
}

