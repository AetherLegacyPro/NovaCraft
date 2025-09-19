package com.NovaCraft.Items.Music;

import net.minecraft.client.renderer.texture.*;
import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import net.minecraft.block.*;
import net.minecraft.init.*;
import net.minecraft.stats.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import java.util.*;

import com.NovaCraft.registry.NovaCraftCreativeTabs;

public class ItemDisk5 extends ItemRecord
{
    public final String recordName;
    private static final Map records;
    
    public ItemDisk5(final String recordName) {
        super(recordName);
        this.recordName = recordName;
        ItemDisk5.records.put(recordName, this);
        this.maxStackSize = 1;
        this.setCreativeTab(NovaCraftCreativeTabs.items);
    }
    
    public boolean onItemUse(final ItemStack itemStack, final EntityPlayer player, final World world, final int x, final int y, final int z, final int par7, final float par8, final float par9, final float par10) {
        if (!(world.getBlock(x, y, z) instanceof BlockJukebox) || world.getBlockMetadata(x, y, z) != 0) {
            return false;
        }
        if (world.isRemote) {
            return true;
        }
        ((BlockJukebox)Blocks.jukebox).func_149926_b(world, x, y, z, itemStack);
        world.playAuxSFXAtEntity((EntityPlayer)null, 1005, x, y, z, Item.getIdFromItem((Item)this));
        --itemStack.stackSize;
        return true;
    }
    
    public void addInformation(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final List par3List, final boolean par4) {
        par3List.add(this.getRecordNameLocal());
    }
    
    public EnumRarity getRarity(final ItemStack itemStack) {
        return EnumRarity.rare;
    }
    
    public static ItemDisk5 getRecord(final String par0Str) {
        return (ItemDisk5) ItemDisk5.records.get(par0Str);
    }
    
    public ResourceLocation getRecordResource(final String name) {
        return new ResourceLocation("nova_craft:5.record");
    }
    
    static {
        records = new HashMap();
    }
}
