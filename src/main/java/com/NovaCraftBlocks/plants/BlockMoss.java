package com.NovaCraftBlocks.plants;

import java.util.Random;

import com.NovaCraft.NovaCraft;
import com.NovaCraft.sounds.ModSounds;
import com.NovaCraftBlocks.NovaCraftBlocks;
import com.ibm.icu.impl.duration.impl.Utils;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockMoss extends Block implements IGrowable {

	@SideOnly(Side.CLIENT)
	private IIcon iconFace, iconTop;
	
	public BlockMoss() {
		super(Material.grass);
		this.setHardness(0.5f);
		this.setResistance(0.5f);
		this.setStepSound(ModSounds.soundMoss);
		this.setHarvestLevel("shovel", 0);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta){
		return side == 0 || side == 1 ? iconTop : meta >= 1 && side-1 == meta ? iconFace : blockIcon;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister){
		blockIcon = iconRegister.registerIcon("nova_craft:vibrant_moss_block");
		iconFace = iconRegister.registerIcon("nova_craft:vibrant_moss_block");
		iconTop = iconRegister.registerIcon("nova_craft:vibrant_moss_block");
	}
	
	@Override
	public boolean func_149851_a(World p_149851_1_, int p_149851_2_, int p_149851_3_, int p_149851_4_, boolean p_149851_5_) {
		return true;
	}

	@Override
	public boolean func_149852_a(World p_149852_1_, Random p_149852_2_, int p_149852_3_, int p_149852_4_, int p_149852_5_) {
		return true;
	}
	
	@Override
	public void func_149853_b(World p_149853_1_, Random p_149853_2_, int p_149853_3_, int p_149853_4_, int p_149853_5_) {
		int l = 0;

		while (l < 128) {
			int i1 = p_149853_3_;
			int j1 = p_149853_4_ + 1;
			int k1 = p_149853_5_;
			int l1 = 0;

			while (true) {
				if (l1 < l / 16) {
					i1 += p_149853_2_.nextInt(3) - 1;
					j1 += (p_149853_2_.nextInt(3) - 1) * p_149853_2_.nextInt(3) / 2;
					k1 += p_149853_2_.nextInt(3) - 1;

					if (p_149853_1_.getBlock(i1, j1 - 1, k1) == NovaCraftBlocks.moss_block && !p_149853_1_.getBlock(i1, j1, k1).isNormalCube()) {
						++l1;
						continue;
					}
				} else if (p_149853_1_.isAirBlock(i1, j1, k1)) {
					if (p_149853_2_.nextInt(3) != 0) {
						if (NovaCraftBlocks.moss_carpet.canBlockStay(p_149853_1_, i1, j1, k1)) {
							p_149853_1_.setBlock(i1, j1, k1, NovaCraftBlocks.moss_carpet, 1, 3);
						}
					} else if (p_149853_2_.nextInt(5) != 0) {
						if (Blocks.tallgrass.canBlockStay(p_149853_1_, i1, j1, k1)) {
							p_149853_1_.setBlock(i1, j1, k1, Blocks.tallgrass, 0, 2);
						}
					} else if (p_149853_2_.nextInt(6) != 0) {
						if (NovaCraftBlocks.cyan_rose.canBlockStay(p_149853_1_, i1, j1, k1)) {
							p_149853_1_.setBlock(i1, j1, k1, NovaCraftBlocks.cyan_rose, 0, 0);
						}
					} else if (p_149853_2_.nextInt(7) != 0) {
						if (Blocks.red_flower.canBlockStay(p_149853_1_, i1, j1, k1)) {
							p_149853_1_.setBlock(i1, j1, k1, Blocks.red_flower, 0, 0);
						}
					} else if (p_149853_2_.nextInt(7) != 0) {
						if (Blocks.yellow_flower.canBlockStay(p_149853_1_, i1, j1, k1)) {
							p_149853_1_.setBlock(i1, j1, k1, Blocks.yellow_flower, 0, 0);
						}
				    } else if (p_149853_2_.nextInt(10) != 0) {
						if (NovaCraftBlocks.calvatia_mushroom.canBlockStay(p_149853_1_, i1, j1, k1)) {
							p_149853_1_.setBlock(i1, j1, k1, NovaCraftBlocks.calvatia_mushroom, 0, 0);
						}
				    } else if (p_149853_2_.nextInt(14) != 0) {
						if (NovaCraftBlocks.pleurotus_mushroom.canBlockStay(p_149853_1_, i1, j1, k1)) {
							p_149853_1_.setBlock(i1, j1, k1, NovaCraftBlocks.pleurotus_mushroom, 0, 0);
						}
				    }
					else {
						if (NovaCraftBlocks.moss_carpet.canBlockStay(p_149853_1_, i1, j1, k1)) {
							p_149853_1_.setBlock(i1, j1, k1, NovaCraftBlocks.moss_carpet, 1, 3);
						}
					}
				}

				++l;
				break;
			}
		}
	}
	
}
