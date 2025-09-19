package com.NovaCraft.Items.Buckets;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.entity.EntityFireProofItemNovaCraft;
import com.NovaCraft.registry.NovaCraftCreativeTabs;
import com.NovaCraftBlocks.NovaCraftBlocks;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class ItemMoltenVaniteBucket extends Item {

	
	public ItemMoltenVaniteBucket(Block p_i45331_1_) {
		super();
		maxStackSize = 1;
        this.setCreativeTab(NovaCraftCreativeTabs.items);
	}

	public boolean onItemUse(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_)
    {
        if (p_77648_7_ == 0)
        {
            --p_77648_5_;
        }

        if (p_77648_7_ == 1)
        {
            ++p_77648_5_;
        }

        if (p_77648_7_ == 2)
        {
            --p_77648_6_;
        }

        if (p_77648_7_ == 3)
        {
            ++p_77648_6_;
        }

        if (p_77648_7_ == 4)
        {
            --p_77648_4_;
        }

        if (p_77648_7_ == 5)
        {
            ++p_77648_4_;
        }

        if (!p_77648_2_.canPlayerEdit(p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_1_))
        {
            return false;
        }
        else
        {
        	if (p_77648_3_.isAirBlock(p_77648_4_, p_77648_5_, p_77648_6_) && p_77648_3_.provider.dimensionId == -1)
        	{
        		p_77648_3_.setBlock(p_77648_4_, p_77648_5_, p_77648_6_, NovaCraftBlocks.molten_vanite);
        	}
        	else {
        		p_77648_3_.setBlock(p_77648_4_, p_77648_5_, p_77648_6_, NovaCraftBlocks.block_of_reinforced_vanite);
        	}

        		--p_77648_1_.stackSize;
        		p_77648_3_.playSoundEffect((double)p_77648_4_ + 0.5D, (double)p_77648_5_ + 0.5D, (double)p_77648_6_ + 0.5D, "random.fizz", 2.0F, itemRand.nextFloat() * 0.4F + 0.8F);
        		p_77648_3_.playSoundEffect((double)p_77648_4_ + 0.5D, (double)p_77648_5_ + 0.5D, (double)p_77648_6_ + 0.5D, "nova_craft:crystal.break", 2.0F, itemRand.nextFloat() * 0.4F + 0.8F);
        		return true;
        }
    }
	
}
