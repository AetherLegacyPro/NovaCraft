package com.NovaCraftBlocks;

import java.util.Random;

import com.NovaCraft.NovaCraft;
import com.NovaCraft.sounds.ModSounds;
import com.ibm.icu.impl.duration.impl.Utils;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockEtherstone extends Block {

	@SideOnly(Side.CLIENT)
	private IIcon iconFace, iconTop;
	
	public BlockEtherstone() {
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
		blockIcon = iconRegister.registerIcon("nova_craft:etherstone_side");
		iconFace = iconRegister.registerIcon("nova_craft:etherstone_top");
		iconTop = iconRegister.registerIcon("nova_craft:etherstone_top");
	}
	
	public Item getItemDropped(final int metadata, final Random rand, final int fortune) {
        return Item.getItemFromBlock(NovaCraftBlocks.cobbled_etherstone);
    }

}