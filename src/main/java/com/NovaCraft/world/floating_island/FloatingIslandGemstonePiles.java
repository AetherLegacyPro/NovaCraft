package com.NovaCraft.world.floating_island;

import net.minecraft.world.gen.feature.*;
import net.minecraft.block.*;
import net.minecraft.world.*;
import java.util.*;

import com.NovaCraftBlocks.NovaCraftBlocks;

import net.minecraft.init.*;

public class FloatingIslandGemstonePiles extends WorldGenAbstractTree
{
    
    public FloatingIslandGemstonePiles(final Block leafID, final int heightWeight, final boolean branchFlag) {
    	super(true);
    }
    
    public boolean generate(final World world, final Random random, final int x, final int y, final int z) {
    	boolean cangen = true;
    		
    		int choice = (int)(1 + Math.random() * 30);
    		int meta = (int)(0 + Math.random() * 8);
    		switch (choice) {
    		case 1: world.setBlock(x, y, z, NovaCraftBlocks.gold_pile, meta, 2);
    			break;
    		case 2: world.setBlock(x, y, z, NovaCraftBlocks.gold_pile, meta, 2);
    			break;
    		case 3: world.setBlock(x, y, z, NovaCraftBlocks.gold_pile, meta, 2);
    			break;
    		case 4: world.setBlock(x, y, z, NovaCraftBlocks.gold_pile, meta, 2);
    			break;
    		case 5: world.setBlock(x, y, z, NovaCraftBlocks.gold_pile, meta, 2);
    			break;
    		case 6: world.setBlock(x, y, z, NovaCraftBlocks.vanite_pile, meta, 2);
    			break;
    		case 7: world.setBlock(x, y, z, NovaCraftBlocks.vanite_pile, meta, 2);
    			break;
    		case 8: world.setBlock(x, y, z, NovaCraftBlocks.vanite_pile, meta, 2);
    			break;
    		case 9: world.setBlock(x, y, z, NovaCraftBlocks.lapis_pile, meta, 2);
				break;
    		case 10: world.setBlock(x, y, z, NovaCraftBlocks.lapis_pile, meta, 2);
				break;
    		case 11: world.setBlock(x, y, z, NovaCraftBlocks.emerald_pile, meta, 2);
				break;
    		case 12: world.setBlock(x, y, z, NovaCraftBlocks.emerald_pile, meta, 2);
				break;
    		case 13: world.setBlock(x, y, z, NovaCraftBlocks.iridium_pile, meta, 2);
				break;
    		case 14: world.setBlock(x, y, z, NovaCraftBlocks.diamond_pile, meta, 2);
				break;
    		case 15: world.setBlock(x, y, z, NovaCraftBlocks.crystal_pile, meta, 2);
				break;
    		default: world.setBlock(x, y, z, NovaCraftBlocks.iron_pile, meta, 2);
    			break;
    		}     
        return true;
    }
}
