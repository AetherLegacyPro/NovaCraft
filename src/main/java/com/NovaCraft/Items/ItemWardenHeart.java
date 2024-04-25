package com.NovaCraft.Items;

import com.NovaCraft.registry.NovaCraftCreativeTabs;
import com.NovaCraftBlocks.NovaCraftBlocks;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemWardenHeart extends Item
{
    public ItemWardenHeart()
    {
    	maxStackSize = 1;
        this.setCreativeTab(NovaCraftCreativeTabs.items);
    }

}
