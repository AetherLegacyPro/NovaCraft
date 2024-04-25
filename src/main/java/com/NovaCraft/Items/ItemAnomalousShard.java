package com.NovaCraft.Items;

import com.NovaCraft.achievements.AchievementsNovaCraft;
import com.NovaCraft.registry.NovaCraftCreativeTabs;
import com.NovaCraftBlocks.NovaCraftBlocks;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemAnomalousShard extends Item
{
    public ItemAnomalousShard()
    {
    	maxStackSize = 16;
        this.setCreativeTab(NovaCraftCreativeTabs.items);
    }

    @Override
	public boolean onItemUse(ItemStack heldItem, EntityPlayer player, World world, int x, int y, int z, int facing, float hitX, float hitY, float hitZ) {
		Block block = world.getBlock(x, y, z);
		
		if (world.getBlock(x, y, z) == NovaCraftBlocks.molten_vanite_cauldron) {
			
			world.setBlock(x, y, z, NovaCraftBlocks.molten_vanite_crystal_cauldron);
			player.triggerAchievement(AchievementsNovaCraft.anomalous_vanite);
			world.playSoundEffect(x, y, z, "random.fizz", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
			--heldItem.stackSize;
	}
		
		return true;
    }
}
