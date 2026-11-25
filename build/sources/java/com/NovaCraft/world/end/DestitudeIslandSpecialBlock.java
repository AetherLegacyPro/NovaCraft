package com.NovaCraft.world.end;

import net.minecraft.world.gen.feature.*;
import net.minecraft.block.*;
import net.minecraft.world.*;
import java.util.*;
import com.NovaCraftBlocks.NovaCraftBlocks;
import net.minecraft.init.*;
import net.minecraft.tileentity.TileEntityMobSpawner;

public class DestitudeIslandSpecialBlock extends WorldGenAbstractTree {
    
    public DestitudeIslandSpecialBlock(final Block leafID, final int heightWeight, final boolean branchFlag) {
        super(true);
    }
    
    public boolean generate(final World world, final Random random, final int x, final int y, final int z) {
    	world.setBlock(x + 1, y, z, NovaCraftBlocks.destitude_block);
    	world.setBlock(x - 1, y, z, NovaCraftBlocks.destitude_block);
    	world.setBlock(x, y, z + 1, NovaCraftBlocks.destitude_block);
    	world.setBlock(x, y, z - 1, NovaCraftBlocks.destitude_block);
    	
    	int rand = (int)(1 + Math.random() * 4);
		switch (rand)
        {
		case 1: world.setBlock(x, y + 1, z, NovaCraftBlocks.crystallized_end);
		world.setBlock(x, y, z, Blocks.mob_spawner);
        TileEntityMobSpawner tileentitymobspawner2 = (TileEntityMobSpawner)world.getTileEntity(x, y, z);
        
        if (tileentitymobspawner2 != null)
        {
        	tileentitymobspawner2.func_145881_a().setEntityName("nova_craft.destitumite_tentacle");
        }
		break;
		case 2: world.setBlock(x, y + 1, z, NovaCraftBlocks.infused_vanite_block_natural);
		world.setBlock(x, y, z, Blocks.mob_spawner);
        TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner)world.getTileEntity(x, y, z);
        
        if (tileentitymobspawner != null)
        {
        	tileentitymobspawner.func_145881_a().setEntityName("nova_craft.reality_distorter");
        }
		break;
		case 3: world.setBlock(x, y + 1, z, NovaCraftBlocks.infused_vanite_block_natural);
		world.setBlock(x, y, z, Blocks.mob_spawner);
        TileEntityMobSpawner tileentitymobspawner3 = (TileEntityMobSpawner)world.getTileEntity(x, y, z);
        
        if (tileentitymobspawner3 != null)
        {
        	tileentitymobspawner3.func_145881_a().setEntityName("nova_craft.reality_distorter");
        }
		break;
		case 4: world.setBlock(x, y + 1, z, NovaCraftBlocks.crystallized_end);
		world.setBlock(x, y, z, Blocks.mob_spawner);
        TileEntityMobSpawner tileentitymobspawner4 = (TileEntityMobSpawner)world.getTileEntity(x, y, z);
        
        if (tileentitymobspawner4 != null)
        {
        	tileentitymobspawner4.func_145881_a().setEntityName("nova_craft.void_cube");
        }
		break;
        }
        	
        return true;
    }
}
