package com.NovaCraftBlocks.ores;

import com.NovaCraft.registry.NovaCraftCreativeTabs;
import com.NovaCraft.sounds.ModSounds;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

public class BlockInfusedIridiumBricks extends Block {

    @SideOnly(Side.CLIENT)
    private IIcon[] icon;
    private static final String[] types;

    public BlockInfusedIridiumBricks() {
        super(Material.iron);
        this.icon = new IIcon[7];
        this.setHardness(60);
        this.setResistance(60000000);
        this.setStepSound(ModSounds.soundNullstone);
        this.setCreativeTab(NovaCraftCreativeTabs.blocks);
        this.setHarvestLevel("pickaxe", 3);
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(final IIconRegister iconRegister) {
        this.icon[0] = iconRegister.registerIcon("nova_craft:copartz_infused_iridium_bricks");
        this.icon[1] = iconRegister.registerIcon("nova_craft:larimar_infused_iridium_bricks");
        this.icon[2] = iconRegister.registerIcon("nova_craft:tsavorokite_infused_iridium_bricks");
        this.icon[3] = iconRegister.registerIcon("nova_craft:yttrlinsite_infused_iridium_bricks");
        this.icon[4] = iconRegister.registerIcon("nova_craft:aether_infused_iridium_bricks");
        this.icon[5] = iconRegister.registerIcon("nova_craft:null_infused_iridium_bricks");
        this.icon[6] = iconRegister.registerIcon("nova_craft:echo_infused_iridium_bricks");
    }

    public IIcon getIcon(final int side, int meta) {
        if (meta < 0 || meta >= this.icon.length) {
            meta = 1;
        }
        return this.icon[meta];
    }

    public void getSubBlocks(final Item block, final CreativeTabs creativeTabs, final List list) {
        for (int i = 0; i < BlockInfusedIridiumBricks.types.length; ++i) {
            list.add(new ItemStack(block, 1, i));
        }
    }

    public int damageDropped(final int meta) {
        return meta;
    }

    static {
        types = new String[] { "copartz_infused_iridium_bricks", "larimar_infused_iridium_bricks", "tsavorokite_infused_iridium_bricks", "yttrlinsite_infused_iridium_bricks", "aether_infused_iridium_bricks", "null_infused_iridium_bricks", "echo_infused_iridium_bricks" };
    }

    public boolean isOpaqueCube()
    {
        return true;
    }

}
