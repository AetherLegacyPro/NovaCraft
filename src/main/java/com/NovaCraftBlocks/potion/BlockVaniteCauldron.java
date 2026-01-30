package com.NovaCraftBlocks.potion;

import java.util.List;
import java.util.Random;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.renderer.RenderIDs;
import com.NovaCraft.sounds.ModSounds;
import com.NovaCraftBlocks.NovaCraftBlocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCauldron;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockVaniteCauldron extends Block {
	
	@SideOnly(Side.CLIENT)
	public IIcon inner, top, bottom, side;
    
	public BlockVaniteCauldron() {
		super(Material.iron);
		this.setHardness(12);
		this.setResistance(55);
		this.setTickRandomly(true);
		this.setStepSound(ModSounds.soundNullstone);
		setHarvestLevel("pickaxe", 3);
		this.setCreativeTab((CreativeTabs)null);
	}
	
	protected boolean canSilkHarvest() {
	    return false;
	 }
	
	public Item getItemDropped(final int metadata, final Random rand, final int fortune) {
        return NovaCraftItems.vanite_cauldron_item;
    }
	
	@SideOnly(Side.CLIENT)
    public Item getItem(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_)
    {
        return NovaCraftItems.vanite_cauldron_item;
    }

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
	    if (side == 1) return this.top;
	    if (side == 0) return this.bottom;
	    return this.side;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister register) {
	    this.inner = register.registerIcon("nova_craft:vanite_cauldron_inner");
	    this.top = register.registerIcon("nova_craft:vanite_cauldron_top");
	    this.bottom = register.registerIcon("nova_craft:vanite_cauldron_bottom");
	    this.side = register.registerIcon("nova_craft:vanite_cauldron_side");

	    this.blockIcon = this.side;
	}
    
	@SideOnly(Side.CLIENT)
	public static IIcon getVaniteCauldronIcon(String name) {
	    BlockVaniteCauldron block = (BlockVaniteCauldron) NovaCraftBlocks.vanite_cauldron;

	    if (name.equals("inner")) return block.inner;
	    if (name.equals("bottom")) return block.bottom;

	    return null;
	}
	
	@Override
	public int tickRate(World world)
	{
		return 100;
	}
	
	@Override
	public boolean isOpaqueCube()
    {
        return false;
    }
	
	@Override
	public boolean renderAsNormalBlock()
    {
        return false;
    }
	
	@Override
	public void updateTick(World world, int i, int j, int k, Random random) {

		if (world.provider.dimensionId == -1) {
			if (world.getBlock(i, j, k + 1) == NovaCraftBlocks.blazlinite
				&& world.getBlock(i, j, k - 1) == NovaCraftBlocks.blazlinite
				&& world.getBlock(i + 1, j, k) == NovaCraftBlocks.blazlinite
				&& world.getBlock(i - 1, j, k) == NovaCraftBlocks.blazlinite
				&& world.getBlock(i, j - 1, k) == NovaCraftBlocks.deepfire) {
                world.setBlock(i, j, k, NovaCraftBlocks.molten_vanite_cauldron, 0, 2);
                world.playSoundEffect((double)(i + 0.5f), (double)(j + 0.5f), (double)(k + 0.5f), "random.fizz", 0.5f, 2.6f + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8f);
           }
		}
	}
	
	public void randomDisplayTick(World world, int i, int j, int k, Random random) {
		World par1World = world;
		int par2 = i;
		int par3 = j;
		int par4 = k;
		Random par5Random = random;
		if (true)
			for (int l = 0; l < 4; ++l) {
				double d0 = (double) ((float) par2 + par5Random.nextFloat());
				double d1 = (double) ((float) par3 + par5Random.nextFloat());
				double d2 = (double) ((float) par4 + par5Random.nextFloat());
				double d3 = 0.0D;
				double d4 = 0.0D;
				double d5 = 0.0D;
				int i1 = par5Random.nextInt(2) * 2 - 1;
				d3 = ((double) par5Random.nextFloat() - 0.5D) * 0.5D;
				d4 = ((double) par5Random.nextFloat() - 0.5D) * 0.5D;
				d5 = ((double) par5Random.nextFloat() - 0.5D) * 0.5D;
				par1World.spawnParticle("reddust", d0, d1, d2, d3, d4, d5);
			}

	}
	
	@Override
	public int getRenderType() { return RenderIDs.VANITE_CAULDRON; } //24

}
