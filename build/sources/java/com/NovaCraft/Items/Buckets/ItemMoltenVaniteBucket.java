package com.NovaCraft.Items.Buckets;

import com.NovaCraft.registry.NovaCraftCreativeTabs;
import com.NovaCraftBlocks.NovaCraftBlocks;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemMoltenVaniteBucket extends Item {

	
	public ItemMoltenVaniteBucket(Block block) {
		super();
		maxStackSize = 1;
        this.setCreativeTab(NovaCraftCreativeTabs.items);
	}

	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
    {
        if (side == 0)
        {
            --y;
        }

        if (side == 1)
        {
            ++y;
        }

        if (side == 2)
        {
            --z;
        }

        if (side == 3)
        {
            ++z;
        }

        if (side == 4)
        {
            --x;
        }

        if (side == 5)
        {
            ++x;
        }

        if (!player.canPlayerEdit(x, y, z, side, stack))
        {
            return false;
        }
        else
        {
        	if (world.isAirBlock(x, y, z) && world.provider.dimensionId == -1)
        	{
                world.setBlock(x, y, z, NovaCraftBlocks.molten_vanite);
        	}
        	else {
                world.setBlock(x, y, z, NovaCraftBlocks.block_of_reinforced_vanite);
        	}

        		--stack.stackSize;
                world.playSoundEffect((double)x + 0.5D, (double)y + 0.5D, (double)z + 0.5D, "random.fizz", 2.0F, itemRand.nextFloat() * 0.4F + 0.8F);
                world.playSoundEffect((double)x + 0.5D, (double)y + 0.5D, (double)z + 0.5D, "nova_craft:crystal.break", 2.0F, itemRand.nextFloat() * 0.4F + 0.8F);
        		return true;
        }
    }
	
}
