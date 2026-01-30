package com.NovaCraftBlocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import com.NovaCraft.sounds.ModSounds;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockCrackedIridiumFurnace extends Block {

    @SideOnly(Side.CLIENT)
    private IIcon iconTop;
    @SideOnly(Side.CLIENT)
    public IIcon iconFront;

    public BlockCrackedIridiumFurnace()
    {
        super(Material.iron);
        this.setStepSound(ModSounds.soundNullstone);
        this.setHarvestLevel("pickaxe", 3);
        this.setHardness(20);
        this.setResistance(60000000);
    }

    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return Item.getItemFromBlock(NovaCraftBlocks.cracked_iridium_furnace);
    }

    public void onBlockAdded(World p_149726_1_, int p_149726_2_, int p_149726_3_, int p_149726_4_)
    {
        super.onBlockAdded(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_);
        this.func_149930_e(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_);
    }

    private void func_149930_e(World p_149930_1_, int p_149930_2_, int p_149930_3_, int p_149930_4_)
    {
        if (!p_149930_1_.isRemote)
        {
            Block block = p_149930_1_.getBlock(p_149930_2_, p_149930_3_, p_149930_4_ - 1);
            Block block1 = p_149930_1_.getBlock(p_149930_2_, p_149930_3_, p_149930_4_ + 1);
            Block block2 = p_149930_1_.getBlock(p_149930_2_ - 1, p_149930_3_, p_149930_4_);
            Block block3 = p_149930_1_.getBlock(p_149930_2_ + 1, p_149930_3_, p_149930_4_);
            byte b0 = 3;

            if (block.func_149730_j() && !block1.func_149730_j())
            {
                b0 = 3;
            }

            if (block1.func_149730_j() && !block.func_149730_j())
            {
                b0 = 2;
            }

            if (block2.func_149730_j() && !block3.func_149730_j())
            {
                b0 = 5;
            }

            if (block3.func_149730_j() && !block2.func_149730_j())
            {
                b0 = 4;
            }

            p_149930_1_.setBlockMetadataWithNotify(p_149930_2_, p_149930_3_, p_149930_4_, b0, 2);
        }
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(final int p_149691_1_, final int p_149691_2_) {
        return (p_149691_1_ == 1) ? this.iconTop : ((p_149691_1_ == 0) ? this.iconTop : ((p_149691_1_ != p_149691_2_) ? ((p_149691_1_ == 3 && p_149691_2_ == 0) ? this.iconFront : this.blockIcon) : this.iconFront));
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(final IIconRegister p_149651_1_) {
        this.blockIcon = p_149651_1_.registerIcon("nova_craft:cracked_iridium_furnace_side");
        this.iconTop = p_149651_1_.registerIcon("nova_craft:cracked_iridium_furnace_top");
        this.iconFront = p_149651_1_.registerIcon("nova_craft:cracked_iridium_furnace_face_off");
    }

    public void onBlockPlacedBy(World p_149689_1_, int p_149689_2_, int p_149689_3_, int p_149689_4_, EntityLivingBase p_149689_5_, ItemStack p_149689_6_) {
        int l = MathHelper.floor_double((double)(p_149689_5_.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (l == 0)
        {
            p_149689_1_.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_, p_149689_4_, 2, 2);
        }

        if (l == 1)
        {
            p_149689_1_.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_, p_149689_4_, 5, 2);
        }

        if (l == 2)
        {
            p_149689_1_.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_, p_149689_4_, 3, 2);
        }

        if (l == 3)
        {
            p_149689_1_.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_, p_149689_4_, 4, 2);
        }
    }

    @SideOnly(Side.CLIENT)
    public Item getItem(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_)
    {
        return Item.getItemFromBlock(NovaCraftBlocks.cracked_iridium_furnace);
    }
}
