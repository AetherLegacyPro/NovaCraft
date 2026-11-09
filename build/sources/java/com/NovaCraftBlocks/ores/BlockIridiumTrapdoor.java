package com.NovaCraftBlocks.ores;

import com.NovaCraft.registry.NovaCraftCreativeTabs;
import com.NovaCraft.sounds.ModSounds;
import net.minecraft.block.BlockTrapDoor;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class BlockIridiumTrapdoor extends BlockTrapDoor {

    public BlockIridiumTrapdoor() {
        super(Material.iron);
        this.setHardness(60);
        this.setResistance(60000000);
        this.setStepSound(ModSounds.soundNullstone);
        this.setHarvestLevel("pickaxe", 3);
        this.setCreativeTab(NovaCraftCreativeTabs.blocks);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        return false;
    }
}
