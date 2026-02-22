package com.NovaCraftBlocks.ores;

import com.NovaCraft.registry.NovaCraftCreativeTabs;
import com.NovaCraft.sounds.ModSounds;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockIridiumBricks extends Block {

    public BlockIridiumBricks() {
        super(Material.iron);
        this.setHardness(60);
        this.setResistance(60000000);
        this.setStepSound(ModSounds.soundNullstone);
        this.setHarvestLevel("pickaxe", 3);
        this.setCreativeTab(NovaCraftCreativeTabs.blocks);
    }

}
