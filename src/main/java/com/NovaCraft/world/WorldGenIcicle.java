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

public class WorldGenIcicle extends WorldGenerator
{
    private Block field_150552_a;
    private int field_150551_b;
    private static final String __OBFID = "CL_00000410";

    public WorldGenIcicle(Block p_i45452_1_)
    {
        this.field_150552_a = p_i45452_1_;
        
    }

    public void func_150550_a(Block p_150550_1_, int p_150550_2_)
    {
        this.field_150552_a = p_150550_1_;
        this.field_150551_b = p_150550_2_;
    }
    
    
    private Block Icicle;

    private int GroupSize;

    public WorldGenIcicle(Block block, int size)
    {
        this.Icicle = block;

        this.GroupSize = size;
    }
    
    public boolean generate(World world, Random random, int x, int y, int z)
    {
    	for (int l = 0; l < this.GroupSize; ++l)
        {
    		int i1 = x + random.nextInt(8) - random.nextInt(8);
            int j1 = y + random.nextInt(4) - random.nextInt(4);
            int k1 = z + random.nextInt(8) - random.nextInt(8);

            if ((world.isAirBlock(i1, j1, k1) && world.getBlock(i1, j1 +1, k1) == Blocks.stone || world.isAirBlock(i1, j1, k1) && world.getBlock(i1, j1 +1, k1) == Blocks.dirt || world.isAirBlock(i1, j1, k1) && world.getBlock(i1, j1 +1, k1) == Blocks.grass || world.isAirBlock(i1, j1, k1) && world.getBlock(i1, j1 +1, k1) == Blocks.ice || world.isAirBlock(i1, j1, k1) || world.getBlock(i1, j1 +1, k1) == NovaCraftBlocks.etherstone || world.getBlock(i1, j1 +1, k1) == Blocks.leaves || world.getBlock(i1, j1 +1, k1) == Blocks.packed_ice) && world.getBlock(i1, j1 +1, k1).isSideSolid(world, i1, j1 +1, k1, ForgeDirection.getOrientation(1))) {
            	world.setBlock(i1, j1, k1, this.Icicle, 1, 2); //7
            } 
            
        }

        return true;
    }
}