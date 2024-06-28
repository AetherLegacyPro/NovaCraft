package com.NovaCraft.world.end;

import net.minecraft.world.gen.feature.*;
import net.minecraft.block.*;
import net.minecraft.world.*;
import java.util.*;

import com.NovaCraftBlocks.NovaCraftBlocks;

import net.minecraft.init.*;

public class LivingEnderEndgusGen extends WorldGenAbstractTree
{
    Block leaves;
    int randHeight;
    boolean branches;
    
    public LivingEnderEndgusGen(final Block leafID, final int heightWeight, final boolean branchFlag) {
        super(true);
        this.leaves = leafID;
        this.randHeight = heightWeight;
        this.branches = branchFlag;
    }
    
    public boolean generate(final World world, final Random random, final int x, final int y, final int z) {
    	boolean cangen = true;
    	
    		world.setBlock(x, y - 1, z, NovaCraftBlocks.ender_fungus_block);
    		world.setBlock(x, y, z, NovaCraftBlocks.ender_fungus_stem);
    		world.setBlock(x, y + 1, z, NovaCraftBlocks.ender_fungus_stem);
    		world.setBlock(x, y + 2, z, NovaCraftBlocks.ender_fungus_stem);
    		world.setBlock(x, y + 3, z, NovaCraftBlocks.ender_fungus_stem);
    		world.setBlock(x, y + 4, z, NovaCraftBlocks.ender_fungus_stem);
    		
    		int rand = (int)(1 + Math.random() * 11);
    		switch (rand)
            {
            case 1:
            	world.setBlock(x, y -1, z + 1, NovaCraftBlocks.ender_fungus_block);
            	world.setBlock(x, y -1, z - 1, NovaCraftBlocks.ender_fungus_block);
            break;
            case 2:
            	world.setBlock(x + 1, y -1, z, NovaCraftBlocks.ender_fungus_block);
            	world.setBlock(x - 1, y -1, z, NovaCraftBlocks.ender_fungus_block);
    		break;
            case 3:
            	world.setBlock(x + 1, y -1, z, NovaCraftBlocks.ender_fungus_block);
    		break;
            case 4:
            	world.setBlock(x - 1, y -1, z, NovaCraftBlocks.ender_fungus_block);
    		break;
            case 5:
            	world.setBlock(x, y -1, z + 1, NovaCraftBlocks.ender_fungus_block);
            break;
            case 6:
            	world.setBlock(x, y -1, z - 1, NovaCraftBlocks.ender_fungus_block);
            break;
            case 7:
            	world.setBlock(x, y -1, z + 1, NovaCraftBlocks.ender_fungus_block);
            	world.setBlock(x, y -1, z - 1, NovaCraftBlocks.ender_fungus_block);            	
            	world.setBlock(x + 1, y -1, z, NovaCraftBlocks.ender_fungus_block);
            	world.setBlock(x - 1, y -1, z, NovaCraftBlocks.ender_fungus_block);
            break;
            case 8:
            	world.setBlock(x, y -2, z + 1, NovaCraftBlocks.ender_fungus_block);
            	world.setBlock(x, y -1, z - 1, NovaCraftBlocks.ender_fungus_block);            	
            	world.setBlock(x + 1, y -1, z, NovaCraftBlocks.ender_fungus_block);
            	world.setBlock(x - 2, y -1, z, NovaCraftBlocks.ender_fungus_block);
            break;
            case 9:
            	world.setBlock(x, y -1, z + 1, NovaCraftBlocks.ender_fungus_block);
            	world.setBlock(x, y -1, z - 2, NovaCraftBlocks.ender_fungus_block);            	
            	world.setBlock(x + 1, y -1, z, NovaCraftBlocks.ender_fungus_block);
            	world.setBlock(x - 2, y -1, z, NovaCraftBlocks.ender_fungus_block);
            break;
            case 10:
            	world.setBlock(x, y -1, z + 1, NovaCraftBlocks.ender_fungus_block);
            	world.setBlock(x, y -1, z - 2, NovaCraftBlocks.ender_fungus_block);            	
            	world.setBlock(x + 2, y -1, z, NovaCraftBlocks.ender_fungus_block);
            	world.setBlock(x - 1, y -1, z, NovaCraftBlocks.ender_fungus_block);
            break;
            case 11:
            	world.setBlock(x, y -1, z + 2, NovaCraftBlocks.ender_fungus_block);
            	world.setBlock(x, y -1, z - 1, NovaCraftBlocks.ender_fungus_block);            	
            	world.setBlock(x + 1, y -1, z, NovaCraftBlocks.ender_fungus_block);
            	world.setBlock(x - 2, y -1, z, NovaCraftBlocks.ender_fungus_block);
            break;
            }
        	
        return true;
    }
    
    public void setBlockAirCheck(final World world, final int x, final int y, final int z, final Block blockID) {
        if (world.getBlock(x, y, z) == Blocks.air) {
            world.setBlock(x, y, z, blockID);
        }
    }
}