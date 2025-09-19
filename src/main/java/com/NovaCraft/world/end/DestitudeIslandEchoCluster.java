package com.NovaCraft.world.end;

import net.minecraft.world.gen.feature.*;
import net.minecraft.block.*;
import net.minecraft.world.*;
import java.util.*;

import com.NovaCraftBlocks.NovaCraftBlocks;

import net.minecraft.init.*;

public class DestitudeIslandEchoCluster extends WorldGenAbstractTree
{
    Block leaves;
    int randHeight;
    boolean branches;
    
    public DestitudeIslandEchoCluster(final Block leafID, final int heightWeight, final boolean branchFlag) {
        super(true);
        this.leaves = leafID;
        this.randHeight = heightWeight;
        this.branches = branchFlag;
    }
    
    public boolean generate(final World world, final Random random, final int x, final int y, final int z) {
    	boolean cangen = true;
    	world.setBlock(x, y - 1, z, NovaCraftBlocks.budding_echo_block);
		world.setBlock(x, y, z, NovaCraftBlocks.echo_cluster_2, 7, 7);
        	
        return true;
    }
    
    public void setBlockAirCheck(final World world, final int x, final int y, final int z, final Block blockID) {
        if (world.getBlock(x, y, z) == Blocks.air) {
            world.setBlock(x, y, z, blockID);
        }
    }
}
