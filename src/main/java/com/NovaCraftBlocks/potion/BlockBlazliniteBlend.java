package com.NovaCraftBlocks.potion;

import java.util.Random;

import com.NovaCraftBlocks.NovaCraftBlocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockBlazliniteBlend extends Block {
	
	public BlockBlazliniteBlend() {
		super(Material.rock);

		this.setHardness(3.5F);
		this.setResistance(5F);
		this.setTickRandomly(true);
		this.setStepSound(soundTypeStone);
		this.setHarvestLevel("pickaxe", 2);
	}
	
	@SideOnly(Side.CLIENT)
	private IIcon iconTop;
	private IIcon blockIconBottom;
	private IIcon blockIconTop;
	
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister registry) {
		this.blockIcon = registry.registerIcon("nova_craft:blazlinite_blend_side");
		this.blockIconTop = registry.registerIcon("nova_craft:blazlinite_blend_top");
		this.blockIconBottom = registry.registerIcon("nova_craft:blazlinite_blend_bottom");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		return side == 1 ? this.blockIconTop : (side == 0 ? this.blockIconBottom : this.blockIcon);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(IBlockAccess world, int x, int y, int z, int side) {
		if (side == 1) {
			return this.blockIconTop;
		} else if (side == 0) {
			return this.blockIconBottom;
		}

		return this.blockIcon;
	}
	
	@Override
	public void updateTick(World world, int i, int j, int k, Random random) {

		if (world.provider.dimensionId == -1) {
			if (world.getBlock(i, j, k + 1) == NovaCraftBlocks.deepfire
				&& world.getBlock(i, j, k - 1) == NovaCraftBlocks.deepfire
				&& world.getBlock(i + 1, j, k) == NovaCraftBlocks.deepfire
				&& world.getBlock(i - 1, j, k) == NovaCraftBlocks.deepfire) {
				
				world.setBlock(i, j, k, NovaCraftBlocks.blazlinite, 0, 2);
				world.playSoundEffect((double)(i + 0.5f), (double)(j + 0.5f), (double)(k + 0.5f), "random.fizz", 0.5f, 2.6f + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8f);
			}
			
		}
	}
	
	@Override
	public int tickRate(World world)
	{
		return 500;
	}
	
}
