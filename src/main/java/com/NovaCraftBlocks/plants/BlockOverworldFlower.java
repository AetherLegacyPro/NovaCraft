package com.NovaCraftBlocks.plants;

import java.util.ArrayList;
import java.util.Random;

import com.NovaCraftBlocks.NovaCraftBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;

public class BlockOverworldFlower extends BlockBush {

	public AxisAlignedBB FLOWER_AABB = AxisAlignedBB.getBoundingBox(0.30000001192092896D, 0.0D, 0.30000001192092896D, 0.699999988079071D, 0.6000000238418579D, 0.699999988079071D);

	public BlockOverworldFlower() {
		this.setHardness(0.0F);
		this.setTickRandomly(true);
		this.setStepSound(soundTypeGrass);
		this.setBlockBounds(0.5F - 0.2F, 0.0F, 0.5F - 0.2F, 0.5F + 0.2F, 0.2F * 3.0F, 0.5F + 0.2F);
	}

	@Override
	public boolean canPlaceBlockAt(World world, int x, int y, int z) {
		Block soil = world.getBlock(x, y - 1, z);
		return soil == Blocks.grass || soil == Blocks.dirt || soil == Blocks.mycelium || soil == NovaCraftBlocks.moss_block;
	}

	@Override
	public boolean canBlockStay(World world, int x, int y, int z) {
		Block soil = world.getBlock(x, y - 1, z);
		return (soil != null && this.canPlaceBlockAt(world, x, y, z));
	}

	public int getRenderType() {    
		return 1;
	  }
	
}

