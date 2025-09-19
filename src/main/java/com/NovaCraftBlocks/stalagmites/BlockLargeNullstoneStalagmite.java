package com.NovaCraftBlocks.stalagmites;

import java.util.Random;

import com.NovaCraft.NovaCraft;
import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.sounds.ModSounds;
import com.NovaCraftBlocks.BlockNullstone;
import com.NovaCraftBlocks.NovaCraftBlocks;
import com.ibm.icu.impl.duration.impl.Utils;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockLargeNullstoneStalagmite extends BlockNullstone {

	@SideOnly(Side.CLIENT)
	private IIcon iconFace, iconTop;
	
	public BlockLargeNullstoneStalagmite() {
		super();
		this.setHardness(0.3F);
		this.setResistance(0.3F);
		float f = 0.5F;
		this.setBlockBounds(0.2F, 0.0F, 0.9F, 0.8F, 0.6F, 0.8F);
		this.setHarvestLevel("pickaxe", 3);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta){
		return side == 0 || side == 1 ? iconTop : meta >= 1 && side-1 == meta ? iconFace : blockIcon;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister){
		blockIcon = iconRegister.registerIcon("nova_craft:large_nullstone_stalagmite");
		iconFace = iconRegister.registerIcon("nova_craft:large_nullstone_stalagmite");
		iconTop = iconRegister.registerIcon("nova_craft:large_nullstone_stalagmite");
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
	
	protected boolean canSilkHarvest()
    {
    	return true;
    }
	
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
	  {
	       return null;
	  }
	
	
	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_)
    {
        return null;
    }

}
