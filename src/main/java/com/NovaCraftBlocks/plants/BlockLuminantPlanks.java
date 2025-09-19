package com.NovaCraftBlocks.plants;

import java.util.Random;

import com.NovaCraft.NovaCraft;
import com.NovaCraft.sounds.ModSounds;
import com.NovaCraftBlocks.NovaCraftBlocks;
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

public class BlockLuminantPlanks extends Block {

	@SideOnly(Side.CLIENT)
	private IIcon iconFace, iconTop;
	
	public BlockLuminantPlanks() {
		super(Material.wood);
		this.setHardness(3);
		this.setResistance(1.5F);
		this.setLightLevel(0.3375F);
		this.setStepSound(soundTypeWood);
		this.setHarvestLevel("axe", 3);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta){
		return side == 0 || side == 1 ? iconTop : meta >= 1 && side-1 == meta ? iconFace : blockIcon;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister){
		blockIcon = iconRegister.registerIcon("nova_craft:luminant_planks");
		iconFace = iconRegister.registerIcon("nova_craft:luminant_planks");
		iconTop = iconRegister.registerIcon("nova_craft:luminant_planks");
	}
	
	public Item getItemDropped(final int metadata, final Random rand, final int fortune) {
        return Item.getItemFromBlock(NovaCraftBlocks.luminant_planks);
    }

}

