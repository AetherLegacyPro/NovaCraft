package com.NovaCraft.world;

import java.util.Random;

import com.NovaCraftBlocks.NovaCraftBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.util.ForgeDirection;

public class WorldGenAdditonalGold extends WorldGenerator
{
    private Block field_150552_a;
    private int field_150551_b;
    private static final String __OBFID = "CL_00000410";

    public WorldGenAdditonalGold(Block p_i45452_1_)
    {
        this.field_150552_a = p_i45452_1_;
        
    }

    public void func_150550_a(Block p_150550_1_, int p_150550_2_)
    {
        this.field_150552_a = p_150550_1_;
        this.field_150551_b = p_150550_2_;
    }
    
    
    private Block Ore;

    private int GroupSize;

    public WorldGenAdditonalGold(Block block, int size)
    {
        this.Ore = block;

        this.GroupSize = size;
    }
    
    public boolean generate(World world, Random random, int x, int y, int z)
    {
        for (int l = 0; l < this.GroupSize; ++l)
        {
        	int i1 = x + random.nextInt(8) - random.nextInt(8);
            int j1 = y + random.nextInt(4) - random.nextInt(4);
            int k1 = z + random.nextInt(8) - random.nextInt(8);

            if (world.isAirBlock(i1, j1, k1) && (world.getBlock(i1, j1 +1, k1) != Blocks.gold_ore || world.getBlock(i1, j1 +1, k1) != Blocks.mob_spawner || world.getBlock(i1, j1 +1, k1) != Blocks.end_portal_frame) && world.getBlock(i1, j1 +1, k1).isSideSolid(world, i1, j1 +1, k1, ForgeDirection.getOrientation(0))) {
            	world.setBlock(i1, j1 + 1, k1, this.Ore, 0, 2); //1
            }
            
            else if (world.isAirBlock(i1, j1, k1) && (world.getBlock(i1, j1 -1, k1) != Blocks.gold_ore || world.getBlock(i1, j1 -1, k1) != Blocks.mob_spawner || world.getBlock(i1, j1 -1, k1) != Blocks.end_portal_frame) && world.getBlock(i1, j1 -1, k1).isSideSolid(world, i1, j1 -1, k1, ForgeDirection.getOrientation(0))) {
            	world.setBlock(i1, j1 - 1, k1, this.Ore, 0, 2); //7
            }
            
            else if (world.isAirBlock(i1, j1, k1) && (world.getBlock(i1, j1 , k1 +1) != Blocks.gold_ore || world.getBlock(i1, j1 , k1 +1) != Blocks.mob_spawner || world.getBlock(i1, j1 , k1 +1) != Blocks.end_portal_frame) && world.getBlock(i1, j1 , k1 +1).isSideSolid(world, i1, j1 , k1 +1, ForgeDirection.getOrientation(0))) {
            	world.setBlock(i1, j1, k1 + 1, this.Ore, 0, 2); //8
            }
            
            else if (world.isAirBlock(i1, j1, k1) && (world.getBlock(i1, j1 , k1 -1) != Blocks.gold_ore || world.getBlock(i1, j1 , k1 -1) != Blocks.mob_spawner || world.getBlock(i1, j1 , k1 -1) != Blocks.end_portal_frame) && world.getBlock(i1, j1 , k1 -1).isSideSolid(world, i1, j1 , k1 -1, ForgeDirection.getOrientation(0))) {
            	world.setBlock(i1, j1, k1 - 1, this.Ore, 0, 2); //9
            }
            
            else if (world.isAirBlock(i1, j1, k1) && (world.getBlock(i1 +1, j1 , k1) != Blocks.gold_ore || world.getBlock(i1 +1, j1 , k1) != Blocks.mob_spawner || world.getBlock(i1 +1, j1 , k1) != Blocks.end_portal_frame) && world.getBlock(i1+1, j1 , k1).isSideSolid(world, i1+1, j1 , k1, ForgeDirection.getOrientation(0))) {
            	world.setBlock(i1 + 1, j1, k1, this.Ore, 0, 2); //10
            }
            
            else if (world.isAirBlock(i1, j1, k1) && (world.getBlock(i1 -1, j1 , k1) != Blocks.gold_ore || world.getBlock(i1 -1, j1 , k1) != Blocks.mob_spawner || world.getBlock(i1 -1, j1 , k1) != Blocks.end_portal_frame) && world.getBlock(i1-1, j1 , k1).isSideSolid(world, i1-1, j1 , k1, ForgeDirection.getOrientation(0))) {
            	world.setBlock(i1 - 1, j1, k1, this.Ore, 0, 2); //11
            }
            
        }

        return true;
    }
}
