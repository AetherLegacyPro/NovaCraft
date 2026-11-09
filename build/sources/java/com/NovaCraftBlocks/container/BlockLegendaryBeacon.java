package com.NovaCraftBlocks.container;

import com.NovaCraft.NovaCraft;
import com.NovaCraft.TileEntity.TileEntityLegendaryBeacon;
import com.NovaCraft.registry.NovaCraftCreativeTabs;
import com.NovaCraft.renderer.RenderIDs;
import net.minecraft.block.*;
import net.minecraft.world.*;
import net.minecraft.tileentity.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;

public class BlockLegendaryBeacon extends BlockBeacon
{
    public BlockLegendaryBeacon() {
        this.setHardness(55);
		this.setResistance(100);
		this.setLightLevel(1.0f);
        this.setCreativeTab(NovaCraftCreativeTabs.blocks);
    }
    
    public TileEntity createNewTileEntity(final World world, final int p_149915_2_) {
        return (TileEntity)new TileEntityLegendaryBeacon();
    }
    
    public boolean onBlockActivated(final World world, final int x, final int y, final int z, final EntityPlayer player, final int p_149727_6_, final float p_149727_7_, final float p_149727_8_, final float p_149727_9_) {
        if (world.isRemote) {
            return true;
        }
        player.openGui((Object)NovaCraft.instance, 2, world, x, y, z);
        return true;
    }
    
    public boolean isOpaqueCube() {
        return false;
    }
    
    public boolean renderAsNormalBlock() {
        return false;
    }
    
    public int getRenderType() {
        return RenderIDs.LEGENDARY_BEACON;
    }
    
    public void onBlockPlacedBy(final World world, final int p_149689_2_, final int p_149689_3_, final int p_149689_4_, final EntityLivingBase entityLivingBase, final ItemStack stack) {
        super.onBlockPlacedBy(world, p_149689_2_, p_149689_3_, p_149689_4_, entityLivingBase, stack);
        if (stack.hasDisplayName()) {
            ((TileEntityLegendaryBeacon)world.getTileEntity(p_149689_2_, p_149689_3_, p_149689_4_)).func_145999_a(stack.getDisplayName());
        }
    }
}
