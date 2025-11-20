package com.NovaCraft.world.nether;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenFlamingPitcher extends WorldGenerator
{
    private Block field_150552_a;
    private int field_150551_b;

    public WorldGenFlamingPitcher(Block p_i45452_1_)
    {
        this.field_150552_a = p_i45452_1_;
        
    }

    public void func_150550_a(Block p_150550_1_, int p_150550_2_)
    {
        this.field_150552_a = p_150550_1_;
        this.field_150551_b = p_150550_2_;
    }
    
    
    private Block Pitcher;

    private int GroupSize;

    public WorldGenFlamingPitcher(Block block, int size)
    {
        this.Pitcher = block;

        this.GroupSize = size;
    }
    
    public boolean generate(World world, Random random, int x, int y, int z)
    {
    	for (int l = 0; l < this.GroupSize; ++l)
        {
            int i1 = x + random.nextInt(4) - random.nextInt(4);
            int j1 = y + random.nextInt(1) - random.nextInt(1);
            int k1 = z + random.nextInt(4) - random.nextInt(4);

            if (world.isAirBlock(i1, j1, k1) && world.getBlock(i1, j1 - 1, k1) == Blocks.lava) {
            	world.setBlock(i1, j1, k1, this.Pitcher, 1, 2);
            } 
            
        }

        return true;
    }
}
