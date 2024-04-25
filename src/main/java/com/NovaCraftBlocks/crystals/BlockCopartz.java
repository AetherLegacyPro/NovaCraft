package com.NovaCraftBlocks.crystals;

import java.util.Random;

import com.NovaCraft.sounds.ModSounds;
import com.NovaCraft.sounds.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.IProjectile;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class BlockCopartz extends Block {
	
	public BlockCopartz() {
		this(Material.glass);
	}
	public BlockCopartz(Material material) {
		super(material);
		setHardness(1.5F);
		setResistance(1.5F);
		this.setStepSound(ModSounds.soundCrystal);
	}
	
	protected boolean canSilkHarvest() {
        return true;
    }
	
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return null;
    }

}
