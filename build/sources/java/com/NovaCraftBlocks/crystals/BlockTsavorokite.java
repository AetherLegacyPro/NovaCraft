package com.NovaCraftBlocks.crystals;

import java.util.Random;
import com.NovaCraft.sounds.ModSounds;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class BlockTsavorokite extends Block {
	
	public BlockTsavorokite() {
		this(Material.glass);
	}
	public BlockTsavorokite(Material material) {
		super(material);
		setHardness(2.5F);
		setResistance(2.5F);
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
