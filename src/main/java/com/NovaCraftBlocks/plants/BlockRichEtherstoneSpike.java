package com.NovaCraftBlocks.plants;

import java.util.Random;
import com.NovaCraft.entity.EntityCrystalSlime;
import com.NovaCraft.entity.EntitySoloid;
import com.NovaCraft.particles.ParticleHandler;
import com.NovaCraftBlocks.NovaCraftBlocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

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

	public void onEntityCollidedWithBlock(World world, int p_149670_2_, int p_149670_3_, int p_149670_4_, Entity entity) {
		if (!(entity instanceof EntityCrystalSlime) && !(entity instanceof EntitySoloid)) {
			int rand = (int) (1 + Math.random() * 10);
			if (rand == 1) {
				entity.attackEntityFrom(DamageSource.cactus, 2.0F);
			}
			entity.motionY = 2.0D;
		}
	}

	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random random)
	{
		if (!world.isRemote) {
			return;
		}

		if (net.minecraft.client.Minecraft.getMinecraft().gameSettings.particleSetting == 2) {
			return;
		}

		int l = world.getBlockMetadata(p_149734_2_, p_149734_3_, p_149734_4_);
		double d0 = (double)((float)p_149734_2_ + 0.5F + (random.nextFloat()) - (random.nextFloat()));
		double d1 = (double)((float)p_149734_3_ - 1.0F);
		double d2 = (double)((float)p_149734_4_ + 0.5F + (random.nextFloat()) - (random.nextFloat()));
		double d3 = 0.2199999988079071D;
		double d4 = 0.27000001072883606D;

		if (l == 1)
		{
			ParticleHandler.TREASURE_SMALL.spawn(world, d0 - d4, d1 + d3, d2, 0.0D, 0.48D, 0.0D, 0.0f, new Object[0]);
		}
		else if (l == 2)
		{
			ParticleHandler.TREASURE_SMALL.spawn(world, d0 - d4, d1 + d3, d2, 0.0D, 0.48D, 0.0D, 0.0f, new Object[0]);
		}
		else if (l == 3)
		{
			ParticleHandler.TREASURE_SMALL.spawn(world, d0 - d4, d1 + d3, d2, 0.0D, 0.48D, 0.0D, 0.0f, new Object[0]);
		}
		else if (l == 4)
		{
			ParticleHandler.TREASURE_SMALL.spawn(world, d0 - d4, d1 + d3, d2, 0.0D, 0.48D, 0.0D, 0.0f, new Object[0]);
		}
		else
		{
			ParticleHandler.TREASURE_SMALL.spawn(world, d0 - d4, d1 + d3, d2, 0.0D, 0.48D, 0.0D, 0.0f, new Object[0]);
		}
	}

	public int getRenderType() {    
		return 1;
	}
	
	public Item getItemDropped(int p_149650_1_, Random random, int p_149650_3_)
    {
        return null;
    }
	
	protected boolean canSilkHarvest() {
	    return true;
	 }
	
}
