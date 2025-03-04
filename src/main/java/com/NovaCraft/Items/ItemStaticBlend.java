package com.NovaCraft.Items;

import com.NovaCraft.registry.NovaCraftCreativeTabs;
import com.NovaCraftBlocks.NovaCraftBlocks;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemStaticBlend extends Item
{
    public ItemStaticBlend()
    {
    	maxStackSize = 16;
        this.setCreativeTab(NovaCraftCreativeTabs.items);
    }
    
    @Override
	public boolean hasEffect(ItemStack stack, int pass) {
		return true;
	}
    
    @Override
	public boolean onItemUse(ItemStack heldItem, EntityPlayer player, World world, int x, int y, int z, int facing, float hitX, float hitY, float hitZ) {
		Block block = world.getBlock(x, y, z);
		int meta = world.getBlockMetadata(x, y, z);
		
		if (world.getBlock(x, y, z) == NovaCraftBlocks.activated_unknown_portal_activator && world.getBlock(x + 59, y + 7, z) == NovaCraftBlocks.nullstone_deactivator
			&& world.getBlock(x + 8, y + 8, z - 47) == NovaCraftBlocks.nullstone_deactivator && world.getBlock(x + 8, y + 5, z + 46) == NovaCraftBlocks.nullstone_deactivator
			&& world.getBlock(x + 44, y + 4, z + 37) == NovaCraftBlocks.nullstone_deactivator && world.getBlock(x + 44, y + 4, z - 31) == NovaCraftBlocks.nullstone_deactivator) {			
			world.setBlock(x, y, z, Blocks.diamond_block);
		}
		
		
		return true;
    }   
}
