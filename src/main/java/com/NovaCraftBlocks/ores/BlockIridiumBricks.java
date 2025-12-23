package com.NovaCraftBlocks.ores;

import com.NovaCraft.sounds.ModSounds;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

public class BlockIridiumBricks extends Block {

    @SideOnly(Side.CLIENT)
    private IIcon iconFace, iconTop;

    public BlockIridiumBricks() {
        super(Material.iron);
        this.setHardness(60);
        this.setResistance(60000000);
        this.setStepSound(ModSounds.soundNullstone);
        this.setHarvestLevel("pickaxe", 3);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta){
        return side == 0 || side == 1 ? iconTop : meta >= 1 && side-1 == meta ? iconFace : blockIcon;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister){
        blockIcon = iconRegister.registerIcon("nova_craft:iridium_bricks");
        iconFace = iconRegister.registerIcon("nova_craft:iridium_bricks");
        iconTop = iconRegister.registerIcon("nova_craft:iridium_bricks");
    }

}
