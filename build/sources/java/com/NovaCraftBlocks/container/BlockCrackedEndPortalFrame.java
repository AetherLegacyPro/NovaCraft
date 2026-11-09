package com.NovaCraftBlocks.container;

import com.NovaCraft.registry.NovaCraftCreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import java.util.Random;
import net.minecraft.block.BlockEndPortalFrame;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockCrackedEndPortalFrame extends BlockEndPortalFrame {
    @SideOnly(Side.CLIENT)
    private IIcon iconEndPortalFrameTop;
    @SideOnly(Side.CLIENT)
    private IIcon iconEndPortalFrameEye;
    @SideOnly(Side.CLIENT)
    private IIcon iconBottom;

    public BlockCrackedEndPortalFrame() {
        super();
        this.setBlockUnbreakable();
        this.setLightLevel(0.3775F);
        this.setCreativeTab(NovaCraftCreativeTabs.blocks);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        if (side == 1) {
            return this.iconEndPortalFrameTop;
        }
        if (side == 0) {
            return this.iconBottom;
        }
        return this.blockIcon;
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon("nova_craft:cracked_endstone_frame_side");
        this.iconEndPortalFrameTop = iconRegister.registerIcon("nova_craft:cracked_endstone_frame_top");
        this.iconBottom = iconRegister.registerIcon("nova_craft:cracked_endstone_frame_bottom");
        this.iconEndPortalFrameEye = iconRegister.registerIcon("endframe_eye");
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIconEndPortalFrameEye()
    {
        return this.iconEndPortalFrameEye;
    }


    public boolean isOpaqueCube() {
        return false;
    }


    public int getRenderType() {
        return 26;
    }

    public void setBlockBoundsForItemRender() {
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.8125F, 1.0F);
    }

    public void addCollisionBoxesToList(World world, int p_149743_2_, int p_149743_3_, int p_149743_4_, AxisAlignedBB p_149743_5_, List p_149743_6_, Entity p_149743_7_) {
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.8125F, 1.0F);
        super.addCollisionBoxesToList(world, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
        int l = world.getBlockMetadata(p_149743_2_, p_149743_3_, p_149743_4_);

        if (isEnderEyeInserted(l))
        {
            this.setBlockBounds(0.3125F, 0.8125F, 0.3125F, 0.6875F, 1.0F, 0.6875F);
            super.addCollisionBoxesToList(world, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
        }

        this.setBlockBoundsForItemRender();
    }

    public static boolean isEnderEyeInserted(int p_150020_0_) {
        return (p_150020_0_ & 4) != 0;
    }

    public Item getItemDropped(int p_149650_1_, Random random, int p_149650_3_) {
        return null;
    }

    public void onBlockPlacedBy(World world, int p_149689_2_, int p_149689_3_, int p_149689_4_, EntityLivingBase entityLivingBase, ItemStack itemStack) {
        int l = ((MathHelper.floor_double((double)(entityLivingBase.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3) + 2) % 4;
        world.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_, p_149689_4_, l, 2);
    }

    public boolean hasComparatorInputOverride() {
        return true;
    }

    public int getComparatorInputOverride(World world, int p_149736_2_, int p_149736_3_, int p_149736_4_, int p_149736_5_) {
        int i1 = world.getBlockMetadata(p_149736_2_, p_149736_3_, p_149736_4_);
        return isEnderEyeInserted(i1) ? 15 : 0;
    }
}
