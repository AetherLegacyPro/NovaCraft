package com.NovaCraftBlocks.plants;

import java.util.ArrayList;
import java.util.Random;

import com.NovaCraft.entity.EntityCrystalSlime;
import com.NovaCraft.entity.EntitySoloid;
import com.NovaCraft.particles.ParticleHandler;
import com.NovaCraftBlocks.NovaCraftBlocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;

public class BlockRichEtherstoneSpike extends BlockBush {

	public AxisAlignedBB FLOWER_AABB = AxisAlignedBB.getBoundingBox(0.30000001192092896D, 0.0D, 0.30000001192092896D, 0.699999988079071D, 0.6000000238418579D, 0.699999988079071D);

	public BlockRichEtherstoneSpike() {
		this.setHardness(1.3F);
		this.setResistance(5.3F);
		this.setStepSound(soundTypeMetal);
		this.setBlockBounds(0.5F - 0.2F, 0.0F, 0.5F - 0.2F, 0.5F + 0.2F, 0.2F * 3.0F, 0.5F + 0.2F);
	}

	@Override
	public boolean canPlaceBlockAt(World world, int x, int y, int z) {
		Block soil = world.getBlock(x, y - 1, z);
		return soil == NovaCraftBlocks.rich_etherstone;
	}

	@Override
	public boolean canBlockStay(World world, int x, int y, int z) {
		Block soil = world.getBlock(x, y - 1, z);
		return (soil != null && this.canPlaceBlockAt(world, x, y, z));
	}

	public void onEntityCollidedWithBlock(World p_149670_1_, int p_149670_2_, int p_149670_3_, int p_149670_4_, Entity p_149670_5_) {
		if (!(p_149670_5_ instanceof EntityCrystalSlime) && !(p_149670_5_ instanceof EntitySoloid)) {
			int rand = (int) (1 + Math.random() * 10);
			if (rand == 1) {
				p_149670_5_.attackEntityFrom(DamageSource.cactus, 2.0F);
			}
			p_149670_5_.motionY = 2.0D;
		}
	}

	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_)
	{
		if (!p_149734_1_.isRemote) {
			return;
		}

		if (net.minecraft.client.Minecraft.getMinecraft().gameSettings.particleSetting == 2) {
			return;
		}

		int l = p_149734_1_.getBlockMetadata(p_149734_2_, p_149734_3_, p_149734_4_);
		double d0 = (double)((float)p_149734_2_ + 0.5F + (p_149734_5_.nextFloat()) - (p_149734_5_.nextFloat()));
		double d1 = (double)((float)p_149734_3_ - 1.0F);
		double d2 = (double)((float)p_149734_4_ + 0.5F + (p_149734_5_.nextFloat()) - (p_149734_5_.nextFloat()));
		double d3 = 0.2199999988079071D;
		double d4 = 0.27000001072883606D;

		if (l == 1)
		{
			ParticleHandler.TREASURE_SMALL.spawn(p_149734_1_, d0 - d4, d1 + d3, d2, 0.0D, 0.48D, 0.0D, 0.0f, new Object[0]);
		}
		else if (l == 2)
		{
			ParticleHandler.TREASURE_SMALL.spawn(p_149734_1_, d0 - d4, d1 + d3, d2, 0.0D, 0.48D, 0.0D, 0.0f, new Object[0]);
		}
		else if (l == 3)
		{
			ParticleHandler.TREASURE_SMALL.spawn(p_149734_1_, d0 - d4, d1 + d3, d2, 0.0D, 0.48D, 0.0D, 0.0f, new Object[0]);
		}
		else if (l == 4)
		{
			ParticleHandler.TREASURE_SMALL.spawn(p_149734_1_, d0 - d4, d1 + d3, d2, 0.0D, 0.48D, 0.0D, 0.0f, new Object[0]);
		}
		else
		{
			ParticleHandler.TREASURE_SMALL.spawn(p_149734_1_, d0 - d4, d1 + d3, d2, 0.0D, 0.48D, 0.0D, 0.0f, new Object[0]);
		}
	}

	public int getRenderType() {    
		return 1;
	}
	
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return null;
    }
	
	protected boolean canSilkHarvest() {
	    return true;
	 }
	
}
