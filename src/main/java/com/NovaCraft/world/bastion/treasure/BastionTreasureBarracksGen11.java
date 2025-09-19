package com.NovaCraft.world.bastion.treasure;

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

public class BastionTreasureBarracksGen11 extends WorldGenerator
{
	public BastionTreasureBarracksGen11() {

	}
	
	private Block PlaceLantern;

	private Block determineIfLanternExists(World world, int x, int y, int z) {
		Block existingBlock = world.getBlock(x, y, z);

		if (!(Configs.enableEtFuturumSoulLanternInAncientCity) && Loader.isModLoaded("netherlicious")) {
			try {
				Block nether_lantern = GameRegistry.findBlock("netherlicious", "Lantern");
				if (nether_lantern != null && (existingBlock == null || existingBlock != nether_lantern)) {
					return nether_lantern;
				}
			} catch (Exception ex) {
				if (Configs.enableDebugMode) {
					System.out.println("Failed to Find Netherlicious soul lantern, trying Et Futurum Requiem...");
				}
			}
		}

		if (Loader.isModLoaded("etfuturum")) {
			try {
				Block et_lantern = GameRegistry.findBlock("etfuturum", "lantern");
				if (et_lantern != null && (existingBlock == null || existingBlock != et_lantern)) {
					return et_lantern;
				}
			} catch (Exception ex) {
				if (Configs.enableDebugMode) {
					System.out.println("Failed to Find Et Futurum Requiem soul lantern, placing glowing basal...");
				}
			}
		}

		return NovaCraftBlocks.glowing_basal;
	}
    
    public boolean generate(final World world, final Random random, final int i, final int j, final int k) {
    	PlaceLantern = determineIfLanternExists(world, i + 23, j + 26, k + 5);
    	
		world.setBlock(i + 23, j + 26, k + 5, PlaceLantern, 1, 2);
		world.setBlock(i + 26, j + 26, k + 5, PlaceLantern, 1, 2);
		world.setBlock(i + 7, j + 26, k + 9, PlaceLantern, 0, 2);
		world.setBlock(i + 20, j + 26, k + 11, PlaceLantern, 0, 2);
		world.setBlock(i + 26, j + 30, k + 11, PlaceLantern, 1, 2);
		world.setBlock(i + 1, j + 31, k + 9, PlaceLantern, 1, 2);
		world.setBlock(i + 16, j + 31, k + 11, PlaceLantern, 1, 2);
		world.setBlock(i + 9, j + 27, k + 3, PlaceLantern, 1, 2);
		world.setBlock(i + 12, j + 27, k + 3, PlaceLantern, 1, 2);
		world.setBlock(i + 20, j + 35, k + 11, PlaceLantern, 1, 2);
		world.setBlock(i + 7, j + 36, k + 9, PlaceLantern, 1, 2);
		world.setBlock(i + 16, j + 56, k + 8, PlaceLantern, 1, 2);
		world.setBlock(i + 25, j + 56, k + 8, PlaceLantern, 1, 2);
		world.setBlock(i + 2, j + 55, k + 6, PlaceLantern, 1, 2);
		world.setBlock(i + 11, j + 55, k + 6, PlaceLantern, 1, 2);
    	
    	return true;
    }
}
