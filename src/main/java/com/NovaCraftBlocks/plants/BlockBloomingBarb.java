package com.NovaCraftBlocks.plants;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class BlockBloomingBarb extends BlockBush {

	public AxisAlignedBB FLOWER_AABB = AxisAlignedBB.getBoundingBox(0.30000001192092896D, 0.0D, 0.30000001192092896D, 0.699999988079071D, 0.6000000238418579D, 0.699999988079071D);

	public BlockBloomingBarb() {
		this.setHardness(0.0F);
		this.setTickRandomly(true);
		this.setStepSound(soundTypeGrass);
		this.setBlockBounds(0.5F - 0.2F, 0.0F, 0.5F - 0.2F, 0.5F + 0.2F, 0.2F * 3.0F, 0.5F + 0.2F);
	}

	@Override
	public boolean canPlaceBlockAt(World world, int x, int y, int z) {
		Block soil = world.getBlock(x, y - 1, z);
		return (soil == Blocks.sand || soil == Blocks.sandstone);
	}

	@Override
	public boolean canBlockStay(World world, int x, int y, int z) {
		Block soil = world.getBlock(x, y - 1, z);
		return (soil != null && this.canPlaceBlockAt(world, x, y, z));
	}

	public int getRenderType() {    
		return 1;
	  }
	
	public void onEntityCollidedWithBlock(World world, int p_149670_2_, int p_149670_3_, int p_149670_4_, Entity entity)
    {
		int rand = (int)(1 + Math.random() * 40);		
		if (rand == 1) {
			entity.attackEntityFrom(DamageSource.cactus, 1.0F);
		}
    }
	
}
