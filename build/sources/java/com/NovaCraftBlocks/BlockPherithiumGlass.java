package com.NovaCraftBlocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import com.NovaCraft.registry.NovaCraftCreativeTabs;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class BlockPherithiumGlass extends BlockBreakable
{
	@SideOnly(Side.CLIENT)
	private IIcon iconFace, iconTop;

    public BlockPherithiumGlass(Material material, boolean p_i45408_2_)
    {
        super("pherithium_glass", material, p_i45408_2_);
        this.setCreativeTab(NovaCraftCreativeTabs.blocks);
        this.setHardness(7);
		this.setResistance(4);
		this.setLightOpacity(255);
    }

    public int quantityDropped(Random random)
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
		blockIcon = iconRegister.registerIcon("nova_craft:pherithium_glass");
		iconFace = iconRegister.registerIcon("nova_craft:pherithium_glass");
		iconTop = iconRegister.registerIcon("nova_craft:pherithium_glass");
	}
}
