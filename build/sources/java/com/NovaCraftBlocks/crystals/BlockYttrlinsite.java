package com.NovaCraftBlocks.crystals;

import java.util.Random;
import com.NovaCraft.sounds.ModSounds;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class BlockYttrlinsite extends Block {
	
	public BlockYttrlinsite() {
		this(Material.glass);
	}
	public BlockYttrlinsite(Material material) {
		super(material);
		setHardness(1.5F);
		setResistance(1.5F);
		this.setLightLevel(0.6375F);
		this.setStepSound(ModSounds.soundCrystal);
	}
	
	protected boolean canSilkHarvest() {
        return true;
    }
	
	public Item getItemDropped(int p_149650_1_, Random random, int p_149650_3_)
    {
        return null;
    }

}
