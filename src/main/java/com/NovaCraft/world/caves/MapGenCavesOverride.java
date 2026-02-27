package com.NovaCraft.world.caves;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.MapGenCaves;

public class MapGenCavesOverride extends MapGenCaves {
    @Override
    protected void func_151538_a(World world, int chunkX, int chunkZ, int p_151538_4_, int p_151538_5_, Block[] blocks) {
        //Restores Cave Rarity logic of release 1.6.4
        int i1 = this.rand.nextInt(this.rand.nextInt(this.rand.nextInt(40) + 1) + 1);

        if (this.rand.nextInt(7) != 0) {
            i1 = 0;
        }

        for (int j1 = 0; j1 < i1; ++j1) {
            double d0 = (double)(chunkX * 16 + this.rand.nextInt(16));
            double d1 = (double)this.rand.nextInt(this.rand.nextInt(123) + 5); //Lowers caves to generate 3 blocks further down
            double d2 = (double)(chunkZ * 16 + this.rand.nextInt(16));
            int k1 = 1;

            if (this.rand.nextInt(4) == 0) {
                this.func_151542_a(this.rand.nextLong(), p_151538_4_, p_151538_5_, blocks, d0, d1, d2);
                k1 += this.rand.nextInt(4);
            }

            for (int l1 = 0; l1 < k1; ++l1) {
                float f = this.rand.nextFloat() * (float)Math.PI * 2.0F;
                float f1 = (this.rand.nextFloat() - 0.5F) * 2.0F / 8.0F;
                float f2 = this.rand.nextFloat() * 2.0F + this.rand.nextFloat();

                if (this.rand.nextInt(10) == 0) {
                    f2 *= this.rand.nextFloat() * this.rand.nextFloat() * 3.0F + 1.0F;
                }

                this.func_151541_a(this.rand.nextLong(), p_151538_4_, p_151538_5_, blocks, d0, d1, d2, f2, f, f1, 0, 0, 1.0D);
            }
        }
    }
}
