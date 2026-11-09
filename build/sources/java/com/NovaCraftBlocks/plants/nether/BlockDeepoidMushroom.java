package com.NovaCraftBlocks.plants.nether;

import java.util.Random;
import com.NovaCraft.particles.ParticleHandler;
import com.NovaCraft.registry.OtherModBlocks;
import com.NovaCraftBlocks.NovaCraftBlocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockMushroom;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class BlockDeepoidMushroom extends BlockMushroom {
	
	public BlockDeepoidMushroom() {
		super();
		this.setHardness(0.1F);
		this.setResistance(0.1F);
		this.setStepSound(soundTypeGrass);
		this.setHarvestLevel("axe", 0);
		this.setBlockBounds(0.3F, 0.0F, 0.3F, 0.7F, 0.3F, 0.7F);
	}
	
	protected boolean canPlaceBlockOn(Block block)
	  {
	       return (block == Blocks.netherrack || block == NovaCraftBlocks.basal || block == OtherModBlocks.Basalt || block == OtherModBlocks.Blackstone
	       || block == OtherModBlocks.CrimsonNylium || block == OtherModBlocks.FoxfireNylium || block == OtherModBlocks.WarpedNylium);
	  }
	
	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	
	public int getRenderType() {    
		return 1;
	  }
	
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k) {
		return null;
	}
	
	@SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random random)
    {
        super.randomDisplayTick(world, p_149734_2_, p_149734_3_, p_149734_4_, random);

        if (random.nextInt(15) == 0)
        {
        	ParticleHandler.SMALLIONFLAME.spawn(world, p_149734_2_ + random.nextFloat(), p_149734_3_ + 0.1f, p_149734_4_ + random.nextFloat(), 0.0, 0.0, 0.0, 0.0f, new Object[0]);
            ParticleHandler.SMALLIONFLAME.spawn(world, p_149734_2_ + random.nextFloat(), p_149734_3_ + 0.4f, p_149734_4_ + random.nextFloat(), 0.0, 0.0, 0.0, 0.0f, new Object[0]);
            ParticleHandler.SMALLIONFLAME.spawn(world, p_149734_2_ + random.nextFloat(), p_149734_3_ + 0.6f, p_149734_4_ + random.nextFloat(), 0.0, 0.0, 0.0, 0.0f, new Object[0]);
            ParticleHandler.SMALLIONFLAME.spawn(world, p_149734_2_ + random.nextFloat(), p_149734_3_ + 0.9f, p_149734_4_ + random.nextFloat(), 0.0, 0.0, 0.0, 0.0f, new Object[0]);
            ParticleHandler.SMALLIONFLAME.spawn(world, p_149734_2_ + random.nextFloat(), p_149734_3_ + 1.1f, p_149734_4_ + random.nextFloat(), 0.0, 0.0, 0.0, 0.0f, new Object[0]);

            ParticleHandler.SMALLIONFLAME.spawn(world, p_149734_2_ + random.nextFloat(), p_149734_3_ + 1.1f, p_149734_4_ + random.nextFloat(), 0.0, 0.0, 0.0, 0.0f, new Object[0]);
            ParticleHandler.SMALLIONFLAME.spawn(world, p_149734_2_ + random.nextFloat(), p_149734_3_ + 1.4f, p_149734_4_ + random.nextFloat(), 0.0, 0.0, 0.0, 0.0f, new Object[0]);
            ParticleHandler.SMALLIONFLAME.spawn(world, p_149734_2_ + random.nextFloat(), p_149734_3_ + 1.6f, p_149734_4_ + random.nextFloat(), 0.0, 0.0, 0.0, 0.0f, new Object[0]);
            ParticleHandler.SMALLIONFLAME.spawn(world, p_149734_2_ + random.nextFloat(), p_149734_3_ + 1.9f, p_149734_4_ + random.nextFloat(), 0.0, 0.0, 0.0, 0.0f, new Object[0]);
            ParticleHandler.SMALLIONFLAME.spawn(world, p_149734_2_ + random.nextFloat(), p_149734_3_ + 2.1f, p_149734_4_ + random.nextFloat(), 0.0, 0.0, 0.0, 0.0f, new Object[0]);
        }
    }

}
