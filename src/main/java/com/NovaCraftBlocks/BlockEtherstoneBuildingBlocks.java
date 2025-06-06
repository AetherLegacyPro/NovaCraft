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

public class BlockEtherstoneBuildingBlocks extends Block {
	
	public BlockEtherstoneBuildingBlocks() {
		super(Material.rock);
		this.setHardness(2);
		this.setResistance(3);
		this.setStepSound(ModSounds.soundEtherstoneBricks);
		this.setHarvestLevel("pickaxe", 1);
	}

}
