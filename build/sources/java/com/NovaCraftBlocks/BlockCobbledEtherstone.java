package com.NovaCraftBlocks;

import com.NovaCraft.sounds.ModSounds;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class BlockCobbledEtherstone extends Block {

	@SideOnly(Side.CLIENT)
	private IIcon iconFace, iconTop;
	
	public BlockCobbledEtherstone() {
		super(Material.rock);
		this.setHardness(2);
		this.setResistance(3);
		this.setStepSound(ModSounds.soundEtherstone);
		this.setHarvestLevel("pickaxe", 1);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta){
		return side == 0 || side == 1 ? iconTop : meta >= 1 && side-1 == meta ? iconFace : blockIcon;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister){
		blockIcon = iconRegister.registerIcon("nova_craft:cobbbled_etherstone");
		iconFace = iconRegister.registerIcon("nova_craft:cobbbled_etherstone");
		iconTop = iconRegister.registerIcon("nova_craft:cobbbled_etherstone");
	}

}
