package com.NovaCraftBlocks.plants;

import java.util.ArrayList;
import java.util.Random;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.particles.ParticleHandler;
import com.NovaCraftBlocks.NovaCraftBlocks;

import net.minecraft.block.BlockLeaves;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockLuminantLeaves extends BlockLeaves {

	@SideOnly(Side.CLIENT)
	private IIcon fastIcon;

	@SideOnly(Side.CLIENT)
	private IIcon fancyIcon;

	public BlockLuminantLeaves() {
		super();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getBlockColor() {
		return 16777215;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getRenderColor(int meta) {
		return 16777215;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int colorMultiplier(IBlockAccess world, int x, int y, int z) {
		return 16777215;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public Item getItemDropped(int meta, Random random, int fortune) {
		return this == NovaCraftBlocks.luminant_leaves ? (NovaCraftItems.luminant_tree_sap) : null ;
	}
	
	public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int l) {
		int rand2 = (int)(1 + Math.random() * 12);
		switch (rand2) {
		
		case 1: if (!world.isRemote) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(NovaCraftItems.luminant_apple, 1));

			world.spawnEntityInWorld(entityItem);
		  }
		case 2: if (!world.isRemote) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(NovaCraftBlocks.luminant_sapling, 1));

			world.spawnEntityInWorld(entityItem);
		  }
		case 3: if (!world.isRemote) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(NovaCraftBlocks.luminant_sapling, 1));

			world.spawnEntityInWorld(entityItem);
		  }
		case 4: if (!world.isRemote) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(NovaCraftItems.luminant_tree_sap, 1));

			world.spawnEntityInWorld(entityItem);
		  }
		default :
		
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister p_149651_1_)
	{
		this.fancyIcon = p_149651_1_.registerIcon(this.getTextureName());
		this.fastIcon = p_149651_1_.registerIcon(this.getTextureName() + "_opaque");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		if (Minecraft.getMinecraft().gameSettings.fancyGraphics)
		{
			return fancyIcon;
		}
		else
		{
			return fastIcon;
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
        	ParticleHandler.LUMINANT.spawn(p_149734_1_, d0 - d4, d1 + d3, d2, 0.0D, -0.08D, 0.0D, 0.0f, new Object[0]);
        }
        else if (l == 2)
        {
        	ParticleHandler.LUMINANT.spawn(p_149734_1_, d0 - d4, d1 + d3, d2, 0.0D, -0.08D, 0.0D, 0.0f, new Object[0]);
        }
        else if (l == 3)
        {
        	ParticleHandler.LUMINANT.spawn(p_149734_1_, d0 - d4, d1 + d3, d2, 0.0D, -0.08D, 0.0D, 0.0f, new Object[0]);
        }
        else if (l == 4)
        {
        	ParticleHandler.LUMINANT.spawn(p_149734_1_, d0 - d4, d1 + d3, d2, 0.0D, -0.08D, 0.0D, 0.0f, new Object[0]);
        }
        else
        {
        	ParticleHandler.LUMINANT.spawn(p_149734_1_, d0 - d4, d1 + d3, d2, 0.0D, -0.08D, 0.0D, 0.0f, new Object[0]);
        }
    }

	@Override
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockAccess p_149646_1_, int p_149646_2_, int p_149646_3_, int p_149646_4_, int p_149646_5_) {
		return true;
	}

	@Override
	public String[] func_150125_e() {
		return new String[]{this.getUnlocalizedName()};
	}

}
