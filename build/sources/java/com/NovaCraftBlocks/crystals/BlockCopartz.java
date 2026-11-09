package com.NovaCraftBlocks.crystals;

import java.util.Random;
import com.NovaCraft.sounds.ModSounds;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

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
	
	public Item getItemDropped(int p_149650_1_, Random random, int p_149650_3_)
    {
        return null;
    }

}
