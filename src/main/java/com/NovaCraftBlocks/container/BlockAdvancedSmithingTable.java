package com.NovaCraftBlocks.container;

import net.minecraft.block.*;
import net.minecraft.util.*;

import com.NovaCraft.NovaCraft;

import cpw.mods.fml.relauncher.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;
import net.minecraft.init.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.client.renderer.texture.*;

public class BlockAdvancedSmithingTable extends Block
{
    @SideOnly(Side.CLIENT)
    private IIcon field_150035_a;
    @SideOnly(Side.CLIENT)
    private IIcon field_150034_b;
    
    @SideOnly(Side.CLIENT)
	private IIcon iconFace, iconTop;
    
    public BlockAdvancedSmithingTable() {
        super(Material.wood);
        this.setHardness(2.5f);
        this.setStepSound(Block.soundTypeWood);
    }
    
    public boolean onBlockActivated(final World par1World, final int p_149727_2_, final int p_149727_3_, final int p_149727_4_, final EntityPlayer par5EntityPlayer, final int p_149727_6_, final float p_149727_7_, final float p_149727_8_, final float p_149727_9_) {
        if (par5EntityPlayer.isSneaking()) {
            return false;
        }
        if (par1World.isRemote) {
            return true;
        }
        par5EntityPlayer.openGui((Object)NovaCraft.instance, 1, par1World, p_149727_2_, p_149727_3_, p_149727_4_);
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
		blockIcon = iconRegister.registerIcon("nova_craft:smithing_side");
		iconFace = iconRegister.registerIcon("nova_craft:smithing_bottom");
		iconTop = iconRegister.registerIcon("nova_craft:smithing_top");
	}
}

