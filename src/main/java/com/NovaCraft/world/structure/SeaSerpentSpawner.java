package com.NovaCraft.world.structure;

import net.minecraft.world.gen.feature.*;
import net.minecraft.block.*;
import net.minecraft.world.*;
import java.util.*;

import com.NovaCraft.config.Configs;
import com.NovaCraft.registry.OtherModBlocks;
import com.NovaCraftBlocks.NovaCraftBlocks;

import cpw.mods.fml.common.Loader;
import net.minecraft.init.*;
import net.minecraft.tileentity.TileEntityMobSpawner;

public class SeaSerpentSpawner extends WorldGenerator
{
	public SeaSerpentSpawner() {

	}
	
	private static final Block et_futurum_prismarine = OtherModBlocks.prismarine_block;
	private static final Block et_futurum_sea_lantern = OtherModBlocks.sea_lantern;
	private static final Block carved_vanite_block = NovaCraftBlocks.carved_vanite_bricks;
	private static final Block vanite_bricks = NovaCraftBlocks.vanite_bricks;
	private static final Block polished_vanite_bricks = NovaCraftBlocks.polished_vanite_bricks;
	private static final Block glowing_carved_vanite_bricks = NovaCraftBlocks.glowing_carved_vanite_bricks;
	
	//Et Futurum Requiem
	//prismarine_block 0   -cobbled
	//prismarine_block 1   -bricks
	//prismarine_block 2   -dark
    
    public boolean generate(final World world, final Random random, final int i, final int j, final int k) {

    	if ((world.getBlock(i, j - 1, k) != Blocks.water && world.getBlock(i, j - 1, k) != Blocks.air) && world.getBlock(i, j + 4, k) == Blocks.water) {
    	
    {
		try {
			if (Loader.isModLoaded("etfuturum") && Configs.enablePrismarineInStructures) {
				world.setBlock(i + 1, j + 0, k + 1, et_futurum_prismarine, 2, 2);
				world.setBlock(i + 5, j + 0, k + 1, et_futurum_prismarine, 2, 2);
				world.setBlock(i + 3, j + 0, k + 2, et_futurum_prismarine, 2, 2);
				world.setBlock(i + 2, j + 0, k + 3, et_futurum_prismarine, 2, 2);
				world.setBlock(i + 4, j + 0, k + 3, et_futurum_prismarine, 2, 2);
				world.setBlock(i + 3, j + 0, k + 4, et_futurum_prismarine, 2, 2);
				world.setBlock(i + 1, j + 0, k + 5, et_futurum_prismarine, 2, 2);
				world.setBlock(i + 5, j + 0, k + 5, et_futurum_prismarine, 2, 2);
			} else {
				world.setBlock(i + 1, j + 0, k + 1, vanite_bricks, 0, 2);
				world.setBlock(i + 5, j + 0, k + 1, vanite_bricks, 0, 2);
				world.setBlock(i + 3, j + 0, k + 2, vanite_bricks, 0, 2);
				world.setBlock(i + 2, j + 0, k + 3, vanite_bricks, 0, 2);
				world.setBlock(i + 4, j + 0, k + 3, vanite_bricks, 0, 2);
				world.setBlock(i + 3, j + 0, k + 4, vanite_bricks, 0, 2);
				world.setBlock(i + 1, j + 0, k + 5, vanite_bricks, 0, 2);
				world.setBlock(i + 5, j + 0, k + 5, vanite_bricks, 0, 2);
			}
		} catch (Exception ex) {
			if (Configs.enableDebugMode) {
				System.out.println("Missing Prismarine from Et Futurum Requiem, using Vanite Bricks instead...");
			}
			world.setBlock(i + 1, j + 0, k + 1, vanite_bricks, 0, 2);
			world.setBlock(i + 5, j + 0, k + 1, vanite_bricks, 0, 2);
			world.setBlock(i + 3, j + 0, k + 2, vanite_bricks, 0, 2);
			world.setBlock(i + 2, j + 0, k + 3, vanite_bricks, 0, 2);
			world.setBlock(i + 4, j + 0, k + 3, vanite_bricks, 0, 2);
			world.setBlock(i + 3, j + 0, k + 4, vanite_bricks, 0, 2);
			world.setBlock(i + 1, j + 0, k + 5, vanite_bricks, 0, 2);
			world.setBlock(i + 5, j + 0, k + 5, vanite_bricks, 0, 2);
		}
    }
		
	{
		try {
			if (Loader.isModLoaded("etfuturum") && Configs.enablePrismarineInStructures) {
				world.setBlock(i + 2, j + 0, k + 2, et_futurum_prismarine, 1, 2);
				world.setBlock(i + 4, j + 0, k + 2, et_futurum_prismarine, 1, 2);
				world.setBlock(i + 3, j + 0, k + 3, et_futurum_prismarine, 1, 2);
				world.setBlock(i + 2, j + 0, k + 4, et_futurum_prismarine, 1, 2);
				world.setBlock(i + 4, j + 0, k + 4, et_futurum_prismarine, 1, 2);
				world.setBlock(i + 1, j + 1, k + 1, et_futurum_prismarine, 1, 2);
				world.setBlock(i + 5, j + 1, k + 1, et_futurum_prismarine, 1, 2);
				world.setBlock(i + 1, j + 1, k + 5, et_futurum_prismarine, 1, 2);
				world.setBlock(i + 5, j + 1, k + 5, et_futurum_prismarine, 1, 2);
				world.setBlock(i + 5, j + 2, k + 1, et_futurum_prismarine, 1, 2);
				world.setBlock(i + 1, j + 2, k + 5, et_futurum_prismarine, 1, 2);
			} else {
				world.setBlock(i + 2, j + 0, k + 2, polished_vanite_bricks, 0, 2);
				world.setBlock(i + 4, j + 0, k + 2, polished_vanite_bricks, 0, 2);
				world.setBlock(i + 3, j + 0, k + 3, polished_vanite_bricks, 0, 2);
				world.setBlock(i + 2, j + 0, k + 4, polished_vanite_bricks, 0, 2);
				world.setBlock(i + 4, j + 0, k + 4, polished_vanite_bricks, 0, 2);
				world.setBlock(i + 1, j + 1, k + 1, polished_vanite_bricks, 0, 2);
				world.setBlock(i + 5, j + 1, k + 1, polished_vanite_bricks, 0, 2);
				world.setBlock(i + 1, j + 1, k + 5, polished_vanite_bricks, 0, 2);
				world.setBlock(i + 5, j + 1, k + 5, polished_vanite_bricks, 0, 2);
				world.setBlock(i + 5, j + 2, k + 1, polished_vanite_bricks, 0, 2);
				world.setBlock(i + 1, j + 2, k + 5, polished_vanite_bricks, 0, 2);
			}
		} catch (Exception ex) {
			if (Configs.enableDebugMode) {
				System.out.println("Missing Prismarine from Et Futurum Requiem, using Vanite Bricks instead...");
			}
			world.setBlock(i + 2, j + 0, k + 2, polished_vanite_bricks, 0, 2);
			world.setBlock(i + 4, j + 0, k + 2, polished_vanite_bricks, 0, 2);
			world.setBlock(i + 3, j + 0, k + 3, polished_vanite_bricks, 0, 2);
			world.setBlock(i + 2, j + 0, k + 4, polished_vanite_bricks, 0, 2);
			world.setBlock(i + 4, j + 0, k + 4, polished_vanite_bricks, 0, 2);
			world.setBlock(i + 1, j + 1, k + 1, polished_vanite_bricks, 0, 2);
			world.setBlock(i + 5, j + 1, k + 1, polished_vanite_bricks, 0, 2);
			world.setBlock(i + 1, j + 1, k + 5, polished_vanite_bricks, 0, 2);
			world.setBlock(i + 5, j + 1, k + 5, polished_vanite_bricks, 0, 2);
			world.setBlock(i + 5, j + 2, k + 1, polished_vanite_bricks, 0, 2);
			world.setBlock(i + 1, j + 2, k + 5, polished_vanite_bricks, 0, 2);
		}
    }
		
	{
		try {
			if (Loader.isModLoaded("etfuturum") && Configs.enablePrismarineInStructures) {
				world.setBlock(i + 5, j + 2, k + 5, et_futurum_prismarine, 0, 2);
				world.setBlock(i + 3, j + 0, k + 0, et_futurum_prismarine, 0, 2);
				world.setBlock(i + 2, j + 0, k + 1, et_futurum_prismarine, 0, 2);
				world.setBlock(i + 3, j + 0, k + 1, et_futurum_prismarine, 0, 2);
				world.setBlock(i + 4, j + 0, k + 1, et_futurum_prismarine, 0, 2);
				world.setBlock(i + 1, j + 0, k + 2, et_futurum_prismarine, 0, 2);
				world.setBlock(i + 5, j + 0, k + 2, et_futurum_prismarine, 0, 2);
				world.setBlock(i + 0, j + 0, k + 3, et_futurum_prismarine, 0, 2);
				world.setBlock(i + 1, j + 0, k + 3, et_futurum_prismarine, 0, 2);
				world.setBlock(i + 5, j + 0, k + 3, et_futurum_prismarine, 0, 2);
				world.setBlock(i + 6, j + 0, k + 3, et_futurum_prismarine, 0, 2);
				world.setBlock(i + 1, j + 0, k + 4, et_futurum_prismarine, 0, 2);
				world.setBlock(i + 5, j + 0, k + 4, et_futurum_prismarine, 0, 2);
				world.setBlock(i + 2, j + 0, k + 5, et_futurum_prismarine, 0, 2);
				world.setBlock(i + 3, j + 0, k + 5, et_futurum_prismarine, 0, 2);
				world.setBlock(i + 4, j + 0, k + 5, et_futurum_prismarine, 0, 2);
				world.setBlock(i + 3, j + 0, k + 6, et_futurum_prismarine, 0, 2);
				world.setBlock(i + 1, j + 2, k + 1, et_futurum_prismarine, 0, 2);
				world.setBlock(i + 1, j + 3, k + 5, et_futurum_prismarine, 0, 2);
			} else {
				world.setBlock(i + 5, j + 2, k + 5, carved_vanite_block, 0, 2);
				world.setBlock(i + 3, j + 0, k + 0, carved_vanite_block, 0, 2);
				world.setBlock(i + 2, j + 0, k + 1, carved_vanite_block, 0, 2);
				world.setBlock(i + 3, j + 0, k + 1, carved_vanite_block, 0, 2);
				world.setBlock(i + 4, j + 0, k + 1, carved_vanite_block, 0, 2);
				world.setBlock(i + 1, j + 0, k + 2, carved_vanite_block, 0, 2);
				world.setBlock(i + 5, j + 0, k + 2, carved_vanite_block, 0, 2);
				world.setBlock(i + 0, j + 0, k + 3, carved_vanite_block, 0, 2);
				world.setBlock(i + 1, j + 0, k + 3, carved_vanite_block, 0, 2);
				world.setBlock(i + 5, j + 0, k + 3, carved_vanite_block, 0, 2);
				world.setBlock(i + 6, j + 0, k + 3, carved_vanite_block, 0, 2);
				world.setBlock(i + 1, j + 0, k + 4, carved_vanite_block, 0, 2);
				world.setBlock(i + 5, j + 0, k + 4, carved_vanite_block, 0, 2);
				world.setBlock(i + 2, j + 0, k + 5, carved_vanite_block, 0, 2);
				world.setBlock(i + 3, j + 0, k + 5, carved_vanite_block, 0, 2);
				world.setBlock(i + 4, j + 0, k + 5, carved_vanite_block, 0, 2);
				world.setBlock(i + 3, j + 0, k + 6, carved_vanite_block, 0, 2);
				world.setBlock(i + 1, j + 2, k + 1, carved_vanite_block, 0, 2);
				world.setBlock(i + 1, j + 3, k + 5, carved_vanite_block, 0, 2);
			}
		}  catch (Exception ex) {
			if (Configs.enableDebugMode) {
				System.out.println("Missing Prismarine from Et Futurum Requiem, using Vanite Bricks instead...");
			}
			world.setBlock(i + 5, j + 2, k + 5, carved_vanite_block, 0, 2);
			world.setBlock(i + 3, j + 0, k + 0, carved_vanite_block, 0, 2);
			world.setBlock(i + 2, j + 0, k + 1, carved_vanite_block, 0, 2);
			world.setBlock(i + 3, j + 0, k + 1, carved_vanite_block, 0, 2);
			world.setBlock(i + 4, j + 0, k + 1, carved_vanite_block, 0, 2);
			world.setBlock(i + 1, j + 0, k + 2, carved_vanite_block, 0, 2);
			world.setBlock(i + 5, j + 0, k + 2, carved_vanite_block, 0, 2);
			world.setBlock(i + 0, j + 0, k + 3, carved_vanite_block, 0, 2);
			world.setBlock(i + 1, j + 0, k + 3, carved_vanite_block, 0, 2);
			world.setBlock(i + 5, j + 0, k + 3, carved_vanite_block, 0, 2);
			world.setBlock(i + 6, j + 0, k + 3, carved_vanite_block, 0, 2);
			world.setBlock(i + 1, j + 0, k + 4, carved_vanite_block, 0, 2);
			world.setBlock(i + 5, j + 0, k + 4, carved_vanite_block, 0, 2);
			world.setBlock(i + 2, j + 0, k + 5, carved_vanite_block, 0, 2);
			world.setBlock(i + 3, j + 0, k + 5, carved_vanite_block, 0, 2);
			world.setBlock(i + 4, j + 0, k + 5, carved_vanite_block, 0, 2);
			world.setBlock(i + 3, j + 0, k + 6, carved_vanite_block, 0, 2);
			world.setBlock(i + 1, j + 2, k + 1, carved_vanite_block, 0, 2);
			world.setBlock(i + 1, j + 3, k + 5, carved_vanite_block, 0, 2);
		}
	}	
		
	{
		try {
			if (Loader.isModLoaded("etfuturum") && Configs.enablePrismarineInStructures) {
				world.setBlock(i + 1, j + 3, k + 1, et_futurum_sea_lantern, 0, 2);
			} else {
				world.setBlock(i + 1, j + 3, k + 1, glowing_carved_vanite_bricks, 0, 2);
			}
		} catch (Exception ex) {
			if (Configs.enableDebugMode) {
				System.out.println("Missing Prismarine from Et Futurum Requiem, using Vanite Bricks instead...");
			}
			world.setBlock(i + 1, j + 3, k + 1, glowing_carved_vanite_bricks, 0, 2);
		}
    }	
		world.setBlock(i + 5, j + 3, k + 1, NovaCraftBlocks.flooded_chest, 0, 2);
		
		world.setBlock(i + 3, j + 1, k + 3, Blocks.mob_spawner, 0, 2);
		TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner)world.getTileEntity(i + 3, j + 1, k + 3);
        
        if (tileentitymobspawner != null)
        {
        	tileentitymobspawner.func_145881_a().setEntityName("nova_craft.sea_serpent");
        }
    	
    	return true;
    }
    	return false;
    }

}
