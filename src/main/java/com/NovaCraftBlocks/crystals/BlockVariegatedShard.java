package com.NovaCraftBlocks.crystals;

import com.NovaCraft.sounds.ModSounds;
import com.NovaCraft.sounds.Reference;
import com.NovaCraftBlocks.NovaCraftBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlockVariegatedShard extends Block {
	
	public BlockVariegatedShard() {
		this(Material.glass);
	}
	public BlockVariegatedShard(Material material) {
		super(material);
		setHardness(7.5F);
		setResistance(7.5F);
		this.setStepSound(ModSounds.soundCrystal);
	}

}
