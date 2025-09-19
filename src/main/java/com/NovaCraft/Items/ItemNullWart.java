package com.NovaCraft.Items;

import net.minecraft.client.renderer.texture.*;
import net.minecraft.item.*;
import net.minecraft.entity.player.*;
import java.util.*;

import com.NovaCraft.registry.NovaCraftCreativeTabs;
import com.NovaCraftBlocks.NovaCraftBlocks;

import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraft.init.*;
import net.minecraft.creativetab.*;

public class ItemNullWart extends Item
{
    public ItemNullWart() {
        this.setCreativeTab(NovaCraftCreativeTabs.items);
    }
    
    
    
    public boolean onItemUse(final ItemStack stack, final EntityPlayer player, final World world, final int x, int y, final int z, final int side, final float hitX, final float hitY, final float hitZ) {
        if (side != 1) {
            return false;
        }
        ++y;
        if (world.getBlock(x, y - 1, z) != NovaCraftBlocks.nullstone) {
            return false;
        }
        if (world.getBlock(x, y, z) == Blocks.air) {
            world.setBlock(x, y, z, NovaCraftBlocks.null_wart, 0, 2);
            --stack.stackSize;
            world.playSoundEffect((double)(x + 0.5f), (double)(y + 0.5f), (double)(z + 0.5f), Blocks.tallgrass.stepSound.func_150496_b(), (Blocks.tallgrass.stepSound.getVolume() + 1.0f) / 2.0f, Blocks.tallgrass.stepSound.getPitch() * 0.8f);
            return true;
        }
        return false;
    }
    
    
}
