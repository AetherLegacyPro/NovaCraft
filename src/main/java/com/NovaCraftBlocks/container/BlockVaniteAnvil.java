package com.NovaCraftBlocks.container;

import com.NovaCraft.NovaCraft;
import com.NovaCraft.registry.NovaCraftCreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List; import net.minecraft.block.BlockAnvil;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockVaniteAnvil extends BlockAnvil {

    static final String[] anvilDamageNames = new String[] {"intact", "slightlyDamaged", "veryDamaged"};
    private static final String[] anvilIconNames = new String[] {"nova_craft:vanite_anvil_top_damaged_0", "nova_craft:vanite_anvil_top_damaged_1", "nova_craft:vanite_anvil_top_damaged_2"};
    @SideOnly(Side.CLIENT) public int anvilRenderSide;
    @SideOnly(Side.CLIENT) private IIcon[] anvilIcons;

    public BlockVaniteAnvil() {
        super();
        this.setLightOpacity(0);
        this.setCreativeTab(NovaCraftCreativeTabs.blocks);
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_) {

        if (this.anvilRenderSide == 3 && p_149691_1_ == 1) {
            int k = (p_149691_2_ >> 2) % this.anvilIcons.length;
            return this.anvilIcons[k];
        } else {
            return this.blockIcon;
        }
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_) {

        this.blockIcon = p_149651_1_.registerIcon("nova_craft:vanite_anvil_base");
        this.anvilIcons = new IIcon[anvilIconNames.length]; for (int i = 0; i < this.anvilIcons.length; ++i)

        { this.anvilIcons[i] = p_149651_1_.registerIcon(anvilIconNames[i]);}
    }

    @Override
    public void onBlockAdded(World world, int x, int y, int z) {
        super.onBlockAdded(world, x, y, z);

        if (!world.isRemote) {
            world.playAuxSFX(1022, x, y, z, 0);
        }
    }

    public void onBlockPlacedBy(World p_149689_1_, int p_149689_2_, int p_149689_3_, int p_149689_4_, EntityLivingBase p_149689_5_, ItemStack p_149689_6_) {
        int l = MathHelper.floor_double((double)(p_149689_5_.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
        int i1 = p_149689_1_.getBlockMetadata(p_149689_2_, p_149689_3_, p_149689_4_) >> 2; ++l; l %= 4;
        if (l == 0) { p_149689_1_.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_, p_149689_4_, 2 | i1 << 2, 2); }
        if (l == 1) { p_149689_1_.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_, p_149689_4_, 3 | i1 << 2, 2); }
        if (l == 2) { p_149689_1_.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_, p_149689_4_, 0 | i1 << 2, 2); }
        if (l == 3) { p_149689_1_.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_, p_149689_4_, 1 | i1 << 2, 2); }
    }

    @Override
    public boolean onBlockActivated(final World world, final int x, final int y, final int z, final EntityPlayer player, final int p_149727_6_, final float p_149727_7_, final float p_149727_8_, final float p_149727_9_) {
        if (player.isSneaking()) {
            return false;
        }

        if (world.isRemote) {
            return true;
        }

        player.openGui((Object)NovaCraft.instance, 6, world, x, y, z); return true;
    }

    @SideOnly(Side.CLIENT) public void getSubBlocks(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_) {
        p_149666_3_.add(new ItemStack(p_149666_1_, 1, 0));
    }

    public void func_149828_a(World world, int x, int y, int z, int meta) {
        world.playAuxSFX(1022, x, y, z, 0);
    }
}