package com.NovaCraftBlocks;

import com.NovaCraft.sounds.ModSounds;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockCinnabar extends Block {

    public BlockCinnabar() {
        super(Material.rock);
        this.setHardness(1.5F);
        this.setResistance(2F);
        this.setStepSound(ModSounds.soundEtherstone);
        this.setHarvestLevel("pickaxe", 1);
    }
}
