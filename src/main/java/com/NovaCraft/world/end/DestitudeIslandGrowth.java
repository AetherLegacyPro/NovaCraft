package com.NovaCraft.world.end;

import net.minecraft.world.gen.feature.*;
import net.minecraft.block.*;
import net.minecraft.world.*;
import java.util.*;

import com.NovaCraftBlocks.NovaCraftBlocks;

import net.minecraft.init.*;

public class DestitudeIslandGrowth extends WorldGenAbstractTree
{
    Block leaves;
    int randHeight;
    boolean branches;
    
    public DestitudeIslandGrowth(final Block leafID, final int heightWeight, final boolean branchFlag) {
        super(true);
        this.leaves = leafID;
        this.randHeight = heightWeight;
        this.branches = branchFlag;
    }
    
    public boolean generate(final World world, final Random random, final int x, final int y, final int z) {
    	boolean cangen = true;
    		int rand = (int)(1 + Math.random() * 4);
    		switch (rand)
    		{
    		case 1:
    			world.setBlock(x, y, z, NovaCraftBlocks.destitude_block);
    			world.setBlock(x, y + 1, z, NovaCraftBlocks.destitude_block);
    			world.setBlock(x, y + 2, z, NovaCraftBlocks.destitude_block);
    			break;
    		case 2:
    			world.setBlock(x, y, z, NovaCraftBlocks.destitude_block);
    			world.setBlock(x, y + 1, z, NovaCraftBlocks.destitude_block);
    			break;
    		case 3:
    			world.setBlock(x, y, z, NovaCraftBlocks.destitude_block);
    			break;
    		case 4:
    			world.setBlock(x, y, z, NovaCraftBlocks.destitude_block);
    			world.setBlock(x, y + 1, z, NovaCraftBlocks.destitude_block);
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
