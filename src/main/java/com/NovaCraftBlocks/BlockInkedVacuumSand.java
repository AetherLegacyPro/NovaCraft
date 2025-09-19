package com.NovaCraftBlocks;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class BlockInkedVacuumSand extends Block {

	public BlockInkedVacuumSand() {
		super(Material.sand);

		this.setHardness(0.45F);
		this.setResistance(0.45F);
		this.setHarvestLevel("shovel", 0);
		this.setStepSound(soundTypeSand);
	}

}
