package com.NovaCraftBlocks.container;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.NovaCraft;
import com.NovaCraft.TileEntity.TileEntityDeepoidBrewingStand;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockBrewingStand;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.Random;

public class BlockDeepoidBrewingStand extends BlockBrewingStand {
    @SideOnly(Side.CLIENT)
    private IIcon standIcon;

    @SideOnly(Side.CLIENT)
    private IIcon baseIcon;

    public BlockDeepoidBrewingStand() {
        super();
        this.setLightLevel(0.825F);
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        return new TileEntityDeepoidBrewingStand();
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            player.openGui(NovaCraft.instance, 8, world, x, y, z);
        }
        return true;
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLivingBase, ItemStack stack) {
        if (stack.hasDisplayName()) {
            TileEntity tileEntity = world.getTileEntity(x, y, z);
            if (tileEntity instanceof TileEntityDeepoidBrewingStand) {
                ((TileEntityDeepoidBrewingStand) tileEntity).setCustomName(stack.getDisplayName());
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public Item getItem(World world, int p_149694_2_, int p_149694_3_, int p_149694_4_)
    {
        return NovaCraftItems.deepoid_brewing_stand_item;
    }

    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return NovaCraftItems.deepoid_brewing_stand_item;
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister register) {
        super.registerBlockIcons(register);
        this.baseIcon = register.registerIcon("nova_craft:deepoid_brewing_stand_base");
        this.standIcon = register.registerIcon("nova_craft:deepoid_brewing_stand");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return standIcon;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconBrewingStandBase()
    {
        return this.baseIcon;
    }

    @Override
    public int getRenderType() {
        return 25;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

}
