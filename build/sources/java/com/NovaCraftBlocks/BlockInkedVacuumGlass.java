package com.NovaCraftBlocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;

public class BlockInkedVacuumGlass extends BlockBreakable
{
	@SideOnly(Side.CLIENT)
	private IIcon iconFace, iconTop;

    public BlockInkedVacuumGlass(Material material, boolean p_i45408_2_)
    {
        super("vacuum_glass", material, p_i45408_2_);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setHardness(0.45F);
		this.setResistance(0.45F);
		this.setHarvestLevel("pickaxe", 0);
		this.setStepSound(soundTypeGlass);
    }
    
    @Override
   	@SideOnly(Side.CLIENT)
   	public IIcon getIcon(int side, int meta){
   		return side == 0 || side == 1 ? iconTop : meta >= 1 && side-1 == meta ? iconFace : blockIcon;
   	}

   	@Override
   	@SideOnly(Side.CLIENT)
   	public void registerBlockIcons(IIconRegister iconRegister){
   		blockIcon = iconRegister.registerIcon("nova_craft:vacuum_glass");
   		iconFace = iconRegister.registerIcon("nova_craft:vacuum_glass");
   		iconTop = iconRegister.registerIcon("nova_craft:vacuum_glass");
   	}

    public int quantityDropped(Random random)
    {
        return 0;
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
}
