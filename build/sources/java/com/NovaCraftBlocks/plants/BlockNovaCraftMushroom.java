package com.NovaCraftBlocks.plants;

import com.NovaCraft.registry.OtherModBlocks;
import com.NovaCraftBlocks.NovaCraftBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockMushroom;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class BlockNovaCraftMushroom extends BlockMushroom {
	
	public BlockNovaCraftMushroom() {
		super();
		this.setHardness(0.1F);
		this.setResistance(0.1F);
		this.setStepSound(soundTypeGrass);
		this.setHarvestLevel("pickaxe", 2);
		this.setBlockBounds(0.3F, 0.0F, 0.3F, 0.7F, 0.3F, 0.7F);
	}
	
	protected boolean canPlaceBlockOn(Block block)
	  {
	       return (block == Blocks.stone || block == OtherModBlocks.deepslate || block == NovaCraftBlocks.grimstone || block == NovaCraftBlocks.nullstone);
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

}
