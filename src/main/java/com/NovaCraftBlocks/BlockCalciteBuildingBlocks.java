package com.NovaCraftBlocks;

import com.NovaCraft.NovaCraft;
import com.NovaCraft.sounds.ModSounds;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCalciteBuildingBlocks extends Block {

	public BlockCalciteBuildingBlocks() {
		super(Material.rock);
		this.setHardness(0.75F);
		this.setResistance(2);
		this.setStepSound(ModSounds.soundSculkBricks);
		this.setHarvestLevel("pickaxe", 0);
	}

}