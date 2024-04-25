package com.NovaCraftBlocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;

import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockInkedVacuumGlass extends BlockBreakable
{
	@SideOnly(Side.CLIENT)
	private IIcon iconFace, iconTop;
	
    private static final String __OBFID = "CL_00000249";

    public BlockInkedVacuumGlass(Material p_i45408_1_, boolean p_i45408_2_)
    {
        super("vacuum_glass", p_i45408_1_, p_i45408_2_);
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

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random p_149745_1_)
    {
        return 0;
    }

    /**
     * Returns which pass should this block be rendered on. 0 for solids and 1 for alpha
     */
    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass()
    {
        return 0;
    }

    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    /**
     * Return true if a player with Silk Touch can harvest this block directly, and not its normal drops.
     */
    protected boolean canSilkHarvest()
    {
        return true;
    }
}
