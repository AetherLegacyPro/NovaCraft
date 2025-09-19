package com.NovaCraft.Items.Shards;

import com.NovaCraft.registry.NovaCraftCreativeTabs;
import com.NovaCraftBlocks.NovaCraftBlocks;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemInfusedTsavorokiteShard extends Item
{
    public ItemInfusedTsavorokiteShard()
    {
    	maxStackSize = 16;
        this.setCreativeTab(NovaCraftCreativeTabs.items);
    }

    @Override
	public boolean onItemUse(ItemStack heldItem, EntityPlayer player, World world, int x, int y, int z, int facing, float hitX, float hitY, float hitZ) {
		Block block = world.getBlock(x, y, z);
		
		if (world.getBlock(x, y, z) == NovaCraftBlocks.cracked_tsavorokite_block) {
			
			world.setBlock(x, y, z, NovaCraftBlocks.tsavorokite_block);
			world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
			--heldItem.stackSize;
	}
		
		return true;
    }
}
