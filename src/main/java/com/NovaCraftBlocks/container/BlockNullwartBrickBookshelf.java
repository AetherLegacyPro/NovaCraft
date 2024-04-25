package com.NovaCraftBlocks.container;

import java.util.Random;

import com.NovaCraft.NovaCraft;
import com.NovaCraft.sounds.ModSounds;
import com.NovaCraftBlocks.NovaCraftBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockNullwartBrickBookshelf extends Block {

	public BlockNullwartBrickBookshelf() {
		super(Material.rock);

		this.setHardness(10F);
		this.setResistance(12F);
		this.setHarvestLevel("pickaxe", 2);
		this.setStepSound(ModSounds.soundNullstone);
		this.setBlockTextureName(NovaCraft.find("nullwart_brick_bookshelf"));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int p_149691_1_, int p_149691_2_) {
		return p_149691_1_ != 1 && p_149691_1_ != 0 ? super.getIcon(p_149691_1_, p_149691_2_) : NovaCraftBlocks.nullwart_bricks.getBlockTextureFromSide(p_149691_1_);
	}

	@Override
	public float getEnchantPowerBonus(World world, int x, int y, int z) {
		return 2;
	}
	
}
