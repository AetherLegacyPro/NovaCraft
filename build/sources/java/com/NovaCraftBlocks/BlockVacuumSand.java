package com.NovaCraftBlocks;

import java.util.Random;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class BlockVacuumSand extends Block {

	public BlockVacuumSand() {
		super(Material.sand);

		this.setHardness(0.45F);
		this.setResistance(0.45F);
		this.setHarvestLevel("shovel", 0);
		this.setStepSound(soundTypeSand);
	}
	
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k) {
		return null;
	}
	
	@SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random random)
    {
        super.randomDisplayTick(world, p_149734_2_, p_149734_3_, p_149734_4_, random);

        if (random.nextInt(2) == 0)
        {
			world.spawnParticle("townaura", (double)((float)p_149734_2_ + random.nextFloat()), (double)((float)p_149734_3_ + 1.1F), (double)((float)p_149734_4_ + random.nextFloat()), 0.0D, 0.0D, 0.0D);
        }
    }


}
