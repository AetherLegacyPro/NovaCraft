package com.NovaCraftBlocks;

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
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockGrimstoneBuildingBlocks extends Block {
	
	public BlockGrimstoneBuildingBlocks() {
		super(Material.rock);
		this.setHardness(3);
		this.setResistance(6);
		this.setStepSound(ModSounds.soundGrimstoneBricks);
		this.setHarvestLevel("pickaxe", 1);
	}

}
