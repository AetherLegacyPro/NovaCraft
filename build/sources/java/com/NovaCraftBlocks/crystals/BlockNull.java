package com.NovaCraftBlocks.crystals;

import java.util.Random;
import com.NovaCraft.sounds.ModSounds;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class BlockNull extends Block {
	
	public BlockNull() {
		this(Material.glass);
	}
	public BlockNull(Material material) {
		super(material);
		setHardness(4.5F);
		setResistance(4.5F);
		this.setStepSound(ModSounds.soundCrystal);
	}
	
	protected boolean canSilkHarvest() {
        return false;
    }
	
	public Item getItemDropped(int p_149650_1_, Random random, int p_149650_3_)
    {
        return null;
    }

}
