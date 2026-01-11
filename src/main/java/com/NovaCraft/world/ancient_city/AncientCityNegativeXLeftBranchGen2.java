package com.NovaCraft.world.ancient_city;

import com.NovaCraft.config.ConfigsCompact;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.world.gen.feature.*;
import net.minecraft.block.*;
import net.minecraft.world.*;
import java.util.*;

import com.NovaCraft.config.Configs;
import com.NovaCraft.registry.OtherModBlocks;
import com.NovaCraftBlocks.NovaCraftBlocks;

import cpw.mods.fml.common.Loader;
import net.minecraft.init.*;

public class AncientCityNegativeXLeftBranchGen2 extends WorldGenerator
{
	public AncientCityNegativeXLeftBranchGen2() {

	}

	private Block PlaceDeepslateBricks;
	private Block PlaceCrackedDeepslateBricks;
	private Block PlaceChiseledDeepslate;
	private Block PlacePolishedDeepslate;
	private Block PlaceSoulLantern;

	private Block determineIfDeepslateBricksExists(World world, int x, int y, int z) {
		Block existingBlock = world.getBlock(x, y, z);
		if (ConfigsCompact.enableDeepslateBricks && Loader.isModLoaded("etfuturum")) {
			try {
				Block deepslate_bricks = GameRegistry.findBlock("etfuturum", "deepslate_bricks");
				if (deepslate_bricks != null && (existingBlock == null || existingBlock != deepslate_bricks)) {
					return deepslate_bricks;
				}
			} catch (Exception ex) {
				if (Configs.enableDebugMode) {
					System.out.println("Missing Deepslate Bricks from Et Futurum Requiem, using Grimstone Bricks instead...");
				}
				return NovaCraftBlocks.grimstone_bricks;
			}
		}

		return NovaCraftBlocks.grimstone_bricks;
	}

	private Block determineIfCrackedDeepslateBricksExists(World world, int x, int y, int z) {
		Block existingBlock = world.getBlock(x, y, z);
		if (ConfigsCompact.enableDeepslateBricks && Loader.isModLoaded("etfuturum")) {
			try {
				Block deepslate_bricks = GameRegistry.findBlock("etfuturum", "deepslate_bricks");
				if (deepslate_bricks != null && (existingBlock == null || existingBlock != deepslate_bricks)) {
					return deepslate_bricks;
				}
			} catch (Exception ex) {
				if (Configs.enableDebugMode) {
					System.out.println("Missing Cracked Deepslate Bricks from Et Futurum Requiem, using Cracked Grimstone Bricks instead...");
				}
				return NovaCraftBlocks.cracked_grimstone_bricks;
			}
		}

		return NovaCraftBlocks.cracked_grimstone_bricks;
	}

	private Block determineIfPolishedDeepslateExists(World world, int x, int y, int z) {
		Block existingBlock = world.getBlock(x, y, z);
		if (ConfigsCompact.enableDeepslateBricks && Loader.isModLoaded("etfuturum")) {
			try {
				Block polished_deepslate = GameRegistry.findBlock("etfuturum", "polished_deepslate");
				if (polished_deepslate != null && (existingBlock == null || existingBlock != polished_deepslate)) {
					return polished_deepslate;
				}
			} catch (Exception ex) {
				if (Configs.enableDebugMode) {
					System.out.println("Missing Polished Deepslate from Et Futurum Requiem, using Polished Grimstone instead...");
				}
				return NovaCraftBlocks.polished_grimstone;
			}
		}

		return NovaCraftBlocks.polished_grimstone;
	}

	private Block determineIfChiseledDeepslateExist(World world, int x, int y, int z) {
		Block existingBlock = world.getBlock(x, y, z);
		if (ConfigsCompact.enableDeepslateBricks && Loader.isModLoaded("etfuturum")) {
			try {
				Block deepslate_bricks = GameRegistry.findBlock("etfuturum", "deepslate_bricks");
				if (deepslate_bricks != null && (existingBlock == null || existingBlock != deepslate_bricks)) {
					return deepslate_bricks;
				}
			} catch (Exception ex) {
				if (Configs.enableDebugMode) {
					System.out.println("Missing Chiseled Deepslate from Et Futurum Requiem, using Chiseled Grimstone instead...");
				}
				return NovaCraftBlocks.chiseled_grimstone;
			}
		}

		return NovaCraftBlocks.chiseled_grimstone;
	}

	private Block determineIfSoulLanternExists(World world, int x, int y, int z) {
		Block existingBlock = world.getBlock(x, y, z);

		if (!(ConfigsCompact.enableSoulLantern) && Loader.isModLoaded("netherlicious")) {
			try {
				Block SoulLantern = GameRegistry.findBlock("netherlicious", "SoulLantern");
				if (SoulLantern != null && (existingBlock == null || existingBlock != SoulLantern)) {
					return SoulLantern;
				}
			} catch (Exception ex) {
				if (Configs.enableDebugMode) {
					System.out.println("Failed to Find Netherlicious soul lantern, trying Et Futurum Requiem...");
				}
			}
		}

		if (Loader.isModLoaded("etfuturum")) {
			try {
				Block soul_lantern = GameRegistry.findBlock("etfuturum", "soul_lantern");
				if (soul_lantern != null && (existingBlock == null || existingBlock != soul_lantern)) {
					return soul_lantern;
				}
			} catch (Exception ex) {
				if (Configs.enableDebugMode) {
					System.out.println("Failed to Find Et Futurum Requiem soul lantern, placing nothing...");
				}
			}
		}

		return Blocks.air;
	}
    
    public boolean generate(final World world, final Random random, final int i, final int j, final int k) {  	
    	PlaceDeepslateBricks = determineIfDeepslateBricksExists(world, i + 7, j + 5, k + 9);
    	PlaceCrackedDeepslateBricks = determineIfCrackedDeepslateBricksExists(world, i + 0, j + 5, k + 11);
    	PlaceChiseledDeepslate = determineIfChiseledDeepslateExist(world, i + 1, j + 5, k + 16);
    	PlacePolishedDeepslate = determineIfPolishedDeepslateExists(world, i + 4, j + 6, k + 0);    	
    	PlaceSoulLantern = determineIfSoulLanternExists(world, i + 1, j + 4, k + 3);
    	
    	world.setBlock(i + 5, j + 5, k + 9, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 6, j + 5, k + 9, Blocks.wool, 7, 2);
		world.setBlock(i + 7, j + 5, k + 9, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 8, j + 5, k + 9, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 9, j + 5, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 5, k + 10, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 1, j + 5, k + 10, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 2, j + 5, k + 10, Blocks.wool, 7, 2);
		world.setBlock(i + 3, j + 5, k + 10, Blocks.wool, 7, 2);
		world.setBlock(i + 4, j + 5, k + 10, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 5, j + 5, k + 10, Blocks.wool, 7, 2);
		world.setBlock(i + 6, j + 5, k + 10, Blocks.wool, 7, 2);
		world.setBlock(i + 7, j + 5, k + 10, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 8, j + 5, k + 10, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 9, j + 5, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 5, k + 11, PlaceCrackedDeepslateBricks, 1, 2);
		world.setBlock(i + 1, j + 5, k + 11, PlaceCrackedDeepslateBricks, 1, 2);
		world.setBlock(i + 2, j + 5, k + 11, Blocks.wool, 7, 2);
		world.setBlock(i + 3, j + 5, k + 11, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 4, j + 5, k + 11, PlaceCrackedDeepslateBricks, 1, 2);
		world.setBlock(i + 5, j + 5, k + 11, Blocks.wool, 7, 2);
		world.setBlock(i + 6, j + 5, k + 11, Blocks.wool, 7, 2);
		world.setBlock(i + 7, j + 5, k + 11, PlaceCrackedDeepslateBricks, 1, 2);
		world.setBlock(i + 8, j + 5, k + 11, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 9, j + 5, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 5, k + 12, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 1, j + 5, k + 12, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 2, j + 5, k + 12, Blocks.wool, 7, 2);
		world.setBlock(i + 3, j + 5, k + 12, Blocks.wool, 7, 2);
		world.setBlock(i + 4, j + 5, k + 12, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 5, j + 5, k + 12, Blocks.wool, 7, 2);
		world.setBlock(i + 6, j + 5, k + 12, Blocks.wool, 7, 2);
		world.setBlock(i + 7, j + 5, k + 12, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 8, j + 5, k + 12, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 9, j + 5, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 5, k + 13, PlaceCrackedDeepslateBricks, 1, 2);
		world.setBlock(i + 1, j + 5, k + 13, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 2, j + 5, k + 13, Blocks.wool, 7, 2);
		world.setBlock(i + 3, j + 5, k + 13, Blocks.wool, 7, 2);
		world.setBlock(i + 4, j + 5, k + 13, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 5, j + 5, k + 13, Blocks.wool, 7, 2);
		world.setBlock(i + 6, j + 5, k + 13, Blocks.wool, 7, 2);
		world.setBlock(i + 7, j + 5, k + 13, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 8, j + 5, k + 13, PlaceCrackedDeepslateBricks, 1, 2);
		world.setBlock(i + 9, j + 5, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 5, k + 14, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 1, j + 5, k + 14, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 2, j + 5, k + 14, Blocks.wool, 7, 2);
		world.setBlock(i + 3, j + 5, k + 14, Blocks.wool, 7, 2);
		world.setBlock(i + 4, j + 5, k + 14, PlaceCrackedDeepslateBricks, 1, 2);
		world.setBlock(i + 5, j + 5, k + 14, Blocks.wool, 7, 2);
		world.setBlock(i + 6, j + 5, k + 14, Blocks.wool, 7, 2);
		world.setBlock(i + 7, j + 5, k + 14, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 8, j + 5, k + 14, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 9, j + 5, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 5, k + 15, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 1, j + 5, k + 15, PlaceCrackedDeepslateBricks, 1, 2);
		world.setBlock(i + 2, j + 5, k + 15, Blocks.wool, 7, 2);
		world.setBlock(i + 3, j + 5, k + 15, Blocks.wool, 7, 2);
		world.setBlock(i + 4, j + 5, k + 15, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 5, j + 5, k + 15, Blocks.wool, 7, 2);
		world.setBlock(i + 6, j + 5, k + 15, Blocks.wool, 7, 2);
		world.setBlock(i + 7, j + 5, k + 15, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 8, j + 5, k + 15, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 9, j + 5, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 5, k + 16, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 1, j + 5, k + 16, PlaceChiseledDeepslate, 4, 2);
		world.setBlock(i + 2, j + 5, k + 16, Blocks.wool, 7, 2);
		world.setBlock(i + 3, j + 5, k + 16, Blocks.wool, 7, 2);
		world.setBlock(i + 4, j + 5, k + 16, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 5, j + 5, k + 16, Blocks.wool, 7, 2);
		world.setBlock(i + 6, j + 5, k + 16, Blocks.wool, 7, 2);
		world.setBlock(i + 7, j + 5, k + 16, PlaceChiseledDeepslate, 4, 2);
		world.setBlock(i + 8, j + 5, k + 16, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 9, j + 5, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 5, k + 17, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 1, j + 5, k + 17, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 2, j + 5, k + 17, Blocks.wool, 7, 2);
		world.setBlock(i + 3, j + 5, k + 17, Blocks.wool, 7, 2);
		world.setBlock(i + 4, j + 5, k + 17, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 5, j + 5, k + 17, Blocks.wool, 7, 2);
		world.setBlock(i + 6, j + 5, k + 17, Blocks.wool, 7, 2);
		world.setBlock(i + 7, j + 5, k + 17, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 8, j + 5, k + 17, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 9, j + 5, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 5, k + 18, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 1, j + 5, k + 18, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 2, j + 5, k + 18, Blocks.wool, 7, 2);
		world.setBlock(i + 3, j + 5, k + 18, Blocks.wool, 7, 2);
		world.setBlock(i + 4, j + 5, k + 18, PlaceCrackedDeepslateBricks, 1, 2);
		world.setBlock(i + 5, j + 5, k + 18, Blocks.wool, 7, 2);
		world.setBlock(i + 6, j + 5, k + 18, Blocks.wool, 7, 2);
		world.setBlock(i + 7, j + 5, k + 18, PlaceCrackedDeepslateBricks, 1, 2);
		world.setBlock(i + 8, j + 5, k + 18, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 9, j + 5, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 5, k + 19, PlaceCrackedDeepslateBricks, 1, 2);
		world.setBlock(i + 1, j + 5, k + 19, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 5, k + 19, Blocks.wool, 7, 2);
		world.setBlock(i + 3, j + 5, k + 19, Blocks.wool, 7, 2);
		world.setBlock(i + 4, j + 5, k + 19, PlaceCrackedDeepslateBricks, 1, 2);
		world.setBlock(i + 5, j + 5, k + 19, Blocks.wool, 7, 2);
		world.setBlock(i + 6, j + 5, k + 19, Blocks.wool, 7, 2);
		world.setBlock(i + 7, j + 5, k + 19, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 5, k + 19, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 9, j + 5, k + 19, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 5, k + 20, PlaceCrackedDeepslateBricks, 1, 2);
		world.setBlock(i + 1, j + 5, k + 20, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 2, j + 5, k + 20, Blocks.wool, 7, 2);
		world.setBlock(i + 3, j + 5, k + 20, Blocks.wool, 7, 2);
		world.setBlock(i + 4, j + 5, k + 20, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 5, j + 5, k + 20, Blocks.wool, 7, 2);
		world.setBlock(i + 6, j + 5, k + 20, Blocks.wool, 7, 2);
		world.setBlock(i + 7, j + 5, k + 20, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 8, j + 5, k + 20, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 9, j + 5, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 5, k + 21, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 1, j + 5, k + 21, PlaceCrackedDeepslateBricks, 1, 2);
		world.setBlock(i + 2, j + 5, k + 21, Blocks.wool, 7, 2);
		world.setBlock(i + 3, j + 5, k + 21, Blocks.wool, 7, 2);
		world.setBlock(i + 4, j + 5, k + 21, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 5, j + 5, k + 21, NovaCraftBlocks.sculk_block, 0, 2);
		world.setBlock(i + 6, j + 5, k + 21, Blocks.wool, 7, 2);
		world.setBlock(i + 7, j + 5, k + 21, PlaceCrackedDeepslateBricks, 1, 2);
		world.setBlock(i + 8, j + 5, k + 21, PlaceCrackedDeepslateBricks, 1, 2);
		world.setBlock(i + 9, j + 5, k + 21, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 5, k + 22, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 1, j + 5, k + 22, PlaceCrackedDeepslateBricks, 1, 2);
		world.setBlock(i + 2, j + 5, k + 22, Blocks.wool, 7, 2);
		world.setBlock(i + 3, j + 5, k + 22, Blocks.wool, 7, 2);
		world.setBlock(i + 4, j + 5, k + 22, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 5, j + 5, k + 22, Blocks.wool, 7, 2);
		world.setBlock(i + 6, j + 5, k + 22, Blocks.wool, 7, 2);
		world.setBlock(i + 7, j + 5, k + 22, PlaceCrackedDeepslateBricks, 1, 2);
		world.setBlock(i + 8, j + 5, k + 22, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 9, j + 5, k + 22, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 5, k + 23, PlaceCrackedDeepslateBricks, 1, 2);
		world.setBlock(i + 1, j + 5, k + 23, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 2, j + 5, k + 23, Blocks.wool, 7, 2);
		world.setBlock(i + 3, j + 5, k + 23, Blocks.wool, 7, 2);
		world.setBlock(i + 4, j + 5, k + 23, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 5, j + 5, k + 23, Blocks.wool, 7, 2);
		world.setBlock(i + 6, j + 5, k + 23, Blocks.wool, 7, 2);
		world.setBlock(i + 7, j + 5, k + 23, PlaceCrackedDeepslateBricks, 1, 2);
		world.setBlock(i + 8, j + 5, k + 23, PlaceCrackedDeepslateBricks, 1, 2);
		world.setBlock(i + 9, j + 5, k + 23, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 5, k + 24, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 1, j + 5, k + 24, PlaceCrackedDeepslateBricks, 1, 2);
		world.setBlock(i + 2, j + 5, k + 24, Blocks.wool, 7, 2);
		world.setBlock(i + 3, j + 5, k + 24, Blocks.wool, 7, 2);
		world.setBlock(i + 4, j + 5, k + 24, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 5, j + 5, k + 24, Blocks.wool, 7, 2);
		world.setBlock(i + 6, j + 5, k + 24, Blocks.wool, 7, 2);
		world.setBlock(i + 7, j + 5, k + 24, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 8, j + 5, k + 24, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 9, j + 5, k + 24, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 5, k + 25, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 1, j + 5, k + 25, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 2, j + 5, k + 25, Blocks.wool, 7, 2);
		world.setBlock(i + 3, j + 5, k + 25, Blocks.wool, 7, 2);
		world.setBlock(i + 4, j + 5, k + 25, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 5, j + 5, k + 25, Blocks.wool, 7, 2);
		world.setBlock(i + 6, j + 5, k + 25, Blocks.wool, 7, 2);
		world.setBlock(i + 7, j + 5, k + 25, PlaceChiseledDeepslate, 4, 2);
		world.setBlock(i + 8, j + 5, k + 25, PlaceCrackedDeepslateBricks, 1, 2);
		world.setBlock(i + 9, j + 5, k + 25, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 5, k + 26, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 1, j + 5, k + 26, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 2, j + 5, k + 26, Blocks.wool, 7, 2);
		world.setBlock(i + 3, j + 5, k + 26, Blocks.wool, 7, 2);
		world.setBlock(i + 4, j + 5, k + 26, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 5, j + 5, k + 26, Blocks.wool, 7, 2);
		world.setBlock(i + 6, j + 5, k + 26, Blocks.wool, 7, 2);
		world.setBlock(i + 7, j + 5, k + 26, PlaceCrackedDeepslateBricks, 1, 2);
		world.setBlock(i + 8, j + 5, k + 26, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 9, j + 5, k + 26, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 5, k + 27, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 1, j + 5, k + 27, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 2, j + 5, k + 27, Blocks.wool, 7, 2);
		world.setBlock(i + 3, j + 5, k + 27, Blocks.wool, 7, 2);
		world.setBlock(i + 4, j + 5, k + 27, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 5, k + 27, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 5, k + 27, Blocks.wool, 7, 2);
		world.setBlock(i + 7, j + 5, k + 27, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 8, j + 5, k + 27, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 9, j + 5, k + 27, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 5, k + 28, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 1, j + 5, k + 28, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 2, j + 5, k + 28, Blocks.wool, 7, 2);
		world.setBlock(i + 3, j + 5, k + 28, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 5, k + 28, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 5, k + 28, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 5, k + 28, Blocks.wool, 7, 2);
		world.setBlock(i + 7, j + 5, k + 28, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 8, j + 5, k + 28, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 9, j + 5, k + 28, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 5, k + 29, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 5, k + 29, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 5, k + 29, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 5, k + 29, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 5, k + 29, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 5, k + 29, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 5, k + 29, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 5, k + 29, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 5, k + 29, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 5, k + 29, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 5, k + 30, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 5, k + 30, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 5, k + 30, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 5, k + 30, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 5, k + 30, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 5, k + 30, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 5, k + 30, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 5, k + 30, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 5, k + 30, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 5, k + 30, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 5, k + 31, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 5, k + 31, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 5, k + 31, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 5, k + 31, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 5, k + 31, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 5, k + 31, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 5, k + 31, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 5, k + 31, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 5, k + 31, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 5, k + 31, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 5, k + 32, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 5, k + 32, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 5, k + 32, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 5, k + 32, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 5, k + 32, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 5, k + 32, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 5, k + 32, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 5, k + 32, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 5, k + 32, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 5, k + 32, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 5, k + 33, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 5, k + 33, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 5, k + 33, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 5, k + 33, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 5, k + 33, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 5, k + 33, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 5, k + 33, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 5, k + 33, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 5, k + 33, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 5, k + 33, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 5, k + 34, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 5, k + 34, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 5, k + 34, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 5, k + 34, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 5, k + 34, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 5, k + 34, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 5, k + 34, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 5, k + 34, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 5, k + 34, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 5, k + 34, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 5, k + 35, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 5, k + 35, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 5, k + 35, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 5, k + 35, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 5, k + 35, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 5, k + 35, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 5, k + 35, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 5, k + 35, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 5, k + 35, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 5, k + 35, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 5, k + 36, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 5, k + 36, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 5, k + 36, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 5, k + 36, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 5, k + 36, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 5, k + 36, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 5, k + 36, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 5, k + 36, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 5, k + 36, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 5, k + 36, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 5, k + 37, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 5, k + 37, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 5, k + 37, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 5, k + 37, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 5, k + 37, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 5, k + 37, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 5, k + 37, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 5, k + 37, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 5, k + 37, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 5, k + 37, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 5, k + 38, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 5, k + 38, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 5, k + 38, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 5, k + 38, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 5, k + 38, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 5, k + 38, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 5, k + 38, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 5, k + 38, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 5, k + 38, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 5, k + 38, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 5, k + 39, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 5, k + 39, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 5, k + 39, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 5, k + 39, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 5, k + 39, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 5, k + 39, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 5, k + 39, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 5, k + 39, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 5, k + 39, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 5, k + 39, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 5, k + 40, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 1, j + 5, k + 40, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 2, j + 5, k + 40, Blocks.wool, 7, 2);
		world.setBlock(i + 3, j + 5, k + 40, Blocks.wool, 7, 2);
		world.setBlock(i + 4, j + 5, k + 40, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 5, j + 5, k + 40, Blocks.wool, 7, 2);
		world.setBlock(i + 6, j + 5, k + 40, Blocks.wool, 7, 2);
		world.setBlock(i + 7, j + 5, k + 40, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 8, j + 5, k + 40, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 9, j + 5, k + 40, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 5, k + 41, PlaceCrackedDeepslateBricks, 1, 2);
		world.setBlock(i + 1, j + 5, k + 41, PlaceCrackedDeepslateBricks, 1, 2);
		world.setBlock(i + 2, j + 5, k + 41, Blocks.wool, 7, 2);
		world.setBlock(i + 3, j + 5, k + 41, Blocks.wool, 7, 2);
		world.setBlock(i + 4, j + 5, k + 41, PlaceCrackedDeepslateBricks, 1, 2);
		world.setBlock(i + 5, j + 5, k + 41, Blocks.wool, 7, 2);
		world.setBlock(i + 6, j + 5, k + 41, Blocks.wool, 7, 2);
		world.setBlock(i + 7, j + 5, k + 41, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 8, j + 5, k + 41, PlaceCrackedDeepslateBricks, 1, 2);
		world.setBlock(i + 9, j + 5, k + 41, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 6, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 6, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 6, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 6, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 6, k + 0, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 5, j + 6, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 6, k + 0, Blocks.carpet, 3, 2);
		world.setBlock(i + 7, j + 6, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 6, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 6, k + 0, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 6, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 6, k + 1, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 2, j + 6, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 6, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 6, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 6, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 6, k + 1, Blocks.carpet, 3, 2);
		world.setBlock(i + 7, j + 6, k + 1, PlaceCrackedDeepslateBricks, 1, 2);
		world.setBlock(i + 8, j + 6, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 6, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 6, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 6, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 6, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 6, k + 2, Blocks.carpet, 3, 2);
		world.setBlock(i + 4, j + 6, k + 2, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 5, j + 6, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 6, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 6, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 6, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 6, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 6, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 6, k + 3, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 2, j + 6, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 6, k + 3, Blocks.carpet, 3, 2);
		world.setBlock(i + 4, j + 6, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 6, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 6, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 6, k + 3, PlaceCrackedDeepslateBricks, 1, 2);
		world.setBlock(i + 8, j + 6, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 6, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 6, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 6, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 6, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 6, k + 4, Blocks.carpet, 3, 2);
		world.setBlock(i + 4, j + 6, k + 4, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 5, j + 6, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 6, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 6, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 6, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 6, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 6, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 6, k + 5, PlaceCrackedDeepslateBricks, 1, 2);
		world.setBlock(i + 2, j + 6, k + 5, Blocks.carpet, 3, 2);
		world.setBlock(i + 3, j + 6, k + 5, Blocks.carpet, 3, 2);
		world.setBlock(i + 4, j + 6, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 6, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 6, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 6, k + 5, PlaceCrackedDeepslateBricks, 1, 2);
		world.setBlock(i + 8, j + 6, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 6, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 6, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 6, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 6, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 6, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 6, k + 6, PlaceChiseledDeepslate, 4, 2);
		world.setBlock(i + 5, j + 6, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 6, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 6, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 6, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 6, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 6, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 6, k + 7, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 2, j + 6, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 6, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 6, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 6, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 6, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 6, k + 7, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 8, j + 6, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 6, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 6, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 6, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 6, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 6, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 6, k + 8, PlaceChiseledDeepslate, 4, 2);
		world.setBlock(i + 5, j + 6, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 6, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 6, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 6, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 6, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 6, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 6, k + 9, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 2, j + 6, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 6, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 6, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 6, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 6, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 6, k + 9, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 8, j + 6, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 6, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 6, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 6, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 6, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 6, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 6, k + 10, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 5, j + 6, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 6, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 6, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 6, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 6, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 6, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 6, k + 11, PlaceCrackedDeepslateBricks, 1, 2);
		world.setBlock(i + 2, j + 6, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 6, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 6, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 6, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 6, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 6, k + 11, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 8, j + 6, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 6, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 6, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 6, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 6, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 6, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 6, k + 12, PlaceChiseledDeepslate, 4, 2);
		world.setBlock(i + 5, j + 6, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 6, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 6, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 6, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 6, k + 12, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 6, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 6, k + 13, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 2, j + 6, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 6, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 6, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 6, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 6, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 6, k + 13, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 8, j + 6, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 6, k + 13, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 6, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 6, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 6, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 6, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 6, k + 14, PlaceChiseledDeepslate, 4, 2);
		world.setBlock(i + 5, j + 6, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 6, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 6, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 6, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 6, k + 14, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 6, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 6, k + 15, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 2, j + 6, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 6, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 6, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 6, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 6, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 6, k + 15, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 8, j + 6, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 6, k + 15, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 6, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 6, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 6, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 6, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 6, k + 16, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 5, j + 6, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 6, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 6, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 6, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 6, k + 16, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 6, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 6, k + 17, PlaceCrackedDeepslateBricks, 1, 2);
		world.setBlock(i + 2, j + 6, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 6, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 6, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 6, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 6, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 6, k + 17, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 8, j + 6, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 6, k + 17, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 6, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 6, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 6, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 6, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 6, k + 18, PlaceChiseledDeepslate, 4, 2);
		world.setBlock(i + 5, j + 6, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 6, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 6, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 6, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 6, k + 18, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 6, k + 19, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 6, k + 19, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 2, j + 6, k + 19, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 6, k + 19, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 6, k + 19, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 6, k + 19, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 6, k + 19, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 6, k + 19, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 8, j + 6, k + 19, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 6, k + 19, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 6, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 6, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 6, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 6, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 6, k + 20, PlaceChiseledDeepslate, 4, 2);
		world.setBlock(i + 5, j + 6, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 6, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 6, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 6, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 6, k + 20, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 6, k + 21, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 6, k + 21, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 2, j + 6, k + 21, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 6, k + 21, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 6, k + 21, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 6, k + 21, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 6, k + 21, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 6, k + 21, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 8, j + 6, k + 21, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 6, k + 21, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 6, k + 22, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 6, k + 22, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 6, k + 22, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 6, k + 22, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 6, k + 22, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 5, j + 6, k + 22, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 6, k + 22, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 6, k + 22, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 6, k + 22, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 6, k + 22, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 6, k + 23, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 6, k + 23, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 2, j + 6, k + 23, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 6, k + 23, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 6, k + 23, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 6, k + 23, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 6, k + 23, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 6, k + 23, PlaceCrackedDeepslateBricks, 1, 2);
		world.setBlock(i + 8, j + 6, k + 23, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 6, k + 23, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 6, k + 24, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 6, k + 24, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 2, j + 6, k + 24, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 6, k + 24, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 6, k + 24, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 6, k + 24, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 6, k + 24, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 6, k + 24, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 8, j + 6, k + 24, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 6, k + 24, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 6, k + 25, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 6, k + 25, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 6, k + 25, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 6, k + 25, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 6, k + 25, PlacePolishedDeepslate, 0, 2);
		world.setBlock(i + 5, j + 6, k + 25, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 6, k + 25, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 6, k + 25, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 6, k + 25, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 6, k + 25, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 6, k + 26, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 6, k + 26, PlaceCrackedDeepslateBricks, 1, 2);
		world.setBlock(i + 2, j + 6, k + 26, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 6, k + 26, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 6, k + 26, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 6, k + 26, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 6, k + 26, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 6, k + 26, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 8, j + 6, k + 26, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 6, k + 26, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 6, k + 27, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 6, k + 27, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 6, k + 27, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 6, k + 27, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 6, k + 27, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 6, k + 27, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 6, k + 27, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 6, k + 27, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 6, k + 27, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 6, k + 27, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 6, k + 28, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 6, k + 28, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 2, j + 6, k + 28, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 6, k + 28, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 6, k + 28, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 6, k + 28, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 6, k + 28, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 6, k + 28, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 6, k + 28, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 6, k + 28, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 6, k + 29, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 6, k + 29, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 6, k + 29, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 6, k + 29, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 6, k + 29, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 6, k + 29, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 6, k + 29, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 6, k + 29, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 6, k + 29, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 6, k + 29, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 6, k + 30, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 6, k + 30, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 6, k + 30, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 6, k + 30, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 6, k + 30, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 6, k + 30, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 6, k + 30, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 6, k + 30, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 6, k + 30, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 6, k + 30, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 6, k + 31, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 6, k + 31, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 6, k + 31, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 6, k + 31, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 6, k + 31, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 6, k + 31, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 6, k + 31, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 6, k + 31, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 6, k + 31, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 6, k + 31, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 6, k + 32, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 6, k + 32, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 6, k + 32, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 6, k + 32, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 6, k + 32, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 6, k + 32, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 6, k + 32, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 6, k + 32, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 6, k + 32, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 6, k + 32, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 6, k + 33, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 6, k + 33, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 6, k + 33, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 6, k + 33, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 6, k + 33, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 6, k + 33, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 6, k + 33, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 6, k + 33, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 6, k + 33, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 6, k + 33, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 6, k + 34, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 6, k + 34, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 6, k + 34, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 6, k + 34, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 6, k + 34, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 6, k + 34, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 6, k + 34, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 6, k + 34, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 6, k + 34, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 6, k + 34, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 6, k + 35, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 6, k + 35, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 6, k + 35, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 6, k + 35, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 6, k + 35, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 6, k + 35, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 6, k + 35, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 6, k + 35, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 6, k + 35, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 6, k + 35, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 6, k + 36, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 6, k + 36, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 6, k + 36, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 6, k + 36, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 6, k + 36, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 6, k + 36, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 6, k + 36, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 6, k + 36, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 6, k + 36, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 6, k + 36, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 6, k + 37, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 6, k + 37, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 6, k + 37, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 6, k + 37, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 6, k + 37, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 6, k + 37, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 6, k + 37, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 6, k + 37, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 6, k + 37, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 6, k + 37, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 6, k + 38, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 6, k + 38, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 6, k + 38, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 6, k + 38, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 6, k + 38, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 6, k + 38, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 6, k + 38, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 6, k + 38, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 6, k + 38, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 6, k + 38, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 6, k + 39, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 6, k + 39, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 6, k + 39, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 6, k + 39, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 6, k + 39, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 6, k + 39, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 6, k + 39, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 6, k + 39, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 6, k + 39, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 6, k + 39, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 6, k + 40, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 6, k + 40, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 6, k + 40, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 6, k + 40, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 6, k + 40, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 6, k + 40, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 6, k + 40, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 6, k + 40, PlaceDeepslateBricks, 0, 2);
		world.setBlock(i + 8, j + 6, k + 40, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 6, k + 40, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 6, k + 41, Blocks.air, 0, 2);
		world.setBlock(i + 1, j + 6, k + 41, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 6, k + 41, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 6, k + 41, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 6, k + 41, PlaceChiseledDeepslate, 4, 2);
		world.setBlock(i + 5, j + 6, k + 41, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 6, k + 41, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 6, k + 41, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 6, k + 41, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 6, k + 41, Blocks.air, 0, 2);
		
		world.setBlock(i + 1, j + 4, k + 3, PlaceSoulLantern, 1, 2);
		world.setBlock(i + 7, j + 4, k + 3, PlaceSoulLantern, 1, 2);
		world.setBlock(i + 1, j + 4, k + 16, PlaceSoulLantern, 1, 2);
		world.setBlock(i + 7, j + 4, k + 16, PlaceSoulLantern, 1, 2);
		world.setBlock(i + 7, j + 4, k + 25, PlaceSoulLantern, 1, 2);
    	
    	return true;
    }

}
