package com.NovaCraftBlocks;

import java.util.Random;

import com.NovaCraft.NovaCraft;
import com.NovaCraft.particles.ParticleHandler;
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

public class BlockNullstoneBuildingBlocks extends Block {
	
	public BlockNullstoneBuildingBlocks() {
		super(Material.rock);
		this.setHardness(5);
		this.setResistance(12);
		this.setStepSound(ModSounds.soundNullstoneBricks);
		this.setHarvestLevel("pickaxe", 3);
	}

}

