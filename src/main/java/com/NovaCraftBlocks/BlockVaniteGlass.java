package com.NovaCraftBlocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;

import com.NovaCraft.registry.NovaCraftCreativeTabs;

import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;

public class BlockVaniteGlass extends BlockBreakable
{
	@SideOnly(Side.CLIENT)
	private IIcon iconFace, iconTop;

    public BlockVaniteGlass(Material p_i45408_1_, boolean p_i45408_2_)
    {
        super("vanite_glass", p_i45408_1_, p_i45408_2_);
        this.setCreativeTab(NovaCraftCreativeTabs.blocks);
        this.setHardness(15);
		this.setResistance(25000);
		this.setLightOpacity(255);
    }

    public int quantityDropped(Random p_149745_1_)
    {
        return 1;
    }

    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass()
    {
        return 0;
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }

    protected boolean canSilkHarvest()
    {
        return true;
    }
    
    @Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta){
		return side == 0 || side == 1 ? iconTop : meta >= 1 && side-1 == meta ? iconFace : blockIcon;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister){
		blockIcon = iconRegister.registerIcon("nova_craft:vanite_glass");
		iconFace = iconRegister.registerIcon("nova_craft:vanite_glass");
		iconTop = iconRegister.registerIcon("nova_craft:vanite_glass");
	}
}
