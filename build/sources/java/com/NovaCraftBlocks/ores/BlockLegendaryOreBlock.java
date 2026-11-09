package com.NovaCraftBlocks.ores;

import com.NovaCraft.registry.NovaCraftCreativeTabs;
import com.NovaCraft.sounds.ModSounds;
import com.NovaCraftBlocks.NovaCraftBlocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import java.util.ArrayList;
import java.util.List;

public class BlockLegendaryOreBlock extends Block {

    private IIcon[] icons = new IIcon[3];
    private static final String[] types;

    public BlockLegendaryOreBlock() {
        super(Material.iron);
        this.setHardness(60);
        this.setResistance(60000000);
        this.setStepSound(ModSounds.soundNullstone);
        this.setCreativeTab(NovaCraftCreativeTabs.blocks);
        this.setHarvestLevel("pickaxe", 3);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(final IIconRegister iconRegister) {
        this.icons[0] = iconRegister.registerIcon("nova_craft:trillint_block");
        this.icons[1] = iconRegister.registerIcon("nova_craft:kreenovite_block");
        this.icons[2] = iconRegister.registerIcon("nova_craft:xifesonite_block");
    }
    @Override
    public IIcon getIcon(final int side, int meta) {
        if (meta < 0 || meta >= this.icons.length) {
            meta = 1;
        }
        return this.icons[meta];
    }

    public void getSubBlocks(final Item block, final CreativeTabs creativeTabs, final List list) {
        for (int i = 0; i < BlockLegendaryOreBlock.types.length; ++i) {
            list.add(new ItemStack(block, 1, i));
        }
    }

    protected boolean canSilkHarvest() {
        return false;
    }

    public boolean canDropFromExplosion(Explosion p_149659_1_) {
        return false;
    }

    public int damageDropped(final int meta) {
        return meta;
    }

    @Override
    public int getLightValue(IBlockAccess world, int x, int y, int z) {
        int meta = world.getBlockMetadata(x, y, z);

        if (meta == 1) {
            return 14;
        }

        return 0;
    }

    static {
        types = new String[]{"trillint_block", "kreenovite_block", "xifesonite_block"};
    }

    @Override
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
        ArrayList<ItemStack> drops = new ArrayList<ItemStack>();

        if (metadata == 0) {
            drops.add(new ItemStack(NovaCraftBlocks.legendary_ore, 1, 0));
        } else if (metadata == 1) {
            drops.add(new ItemStack(NovaCraftBlocks.legendary_ore, 1, 1));
        } else {
            drops.add(new ItemStack(NovaCraftBlocks.legendary_ore, 1, 2));
        }

        return drops;
    }

}
