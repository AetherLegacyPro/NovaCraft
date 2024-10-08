package com.NovaCraft.Items;

import com.NovaCraft.registry.NovaCraftCreativeTabs;
import com.NovaCraftBlocks.NovaCraftBlocks;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemXanciumDust extends Item
{
    private static final String __OBFID = "CL_00000058";

    public ItemXanciumDust()
    {
        this.setCreativeTab(NovaCraftCreativeTabs.items);
    }
    
    public boolean onEntityItemUpdate(EntityItem item) {
		
	      if (item.posY <= 0.0D) {
	         if (!(item.worldObj.isRemote)) {
	         item.worldObj.playSoundAtEntity(item, "nova_craft:null_explosion", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + 1.0F * 0.5F);

	         float f = (item.worldObj.rand.nextFloat() - 0.5F) * 8.0F;
	         float f1 = (item.worldObj.rand.nextFloat() - 0.5F) * 4.0F;
	         float f2 = (item.worldObj.rand.nextFloat() - 0.5F) * 8.0F;
	         item.worldObj.spawnParticle("hugeexplosion", item.posX + (double)f, item.posY + 2.0D + (double)f1, item.posZ + (double)f2, 0.0D, 0.0D, 0.0D);
	         
	         item.setDead();
	         }
	      }

	      return false;	
	}

    /**
     * Callback for item usage. If the item does something special on right clicking, he will have one of those. Return
     * True if something happen and false if it don't. This is for ITEMS, not BLOCKS
     */
    public boolean onItemUse(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_)
    {
        if (p_77648_3_.getBlock(p_77648_4_, p_77648_5_, p_77648_6_) != Blocks.snow_layer)
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

            if (!p_77648_3_.isAirBlock(p_77648_4_, p_77648_5_, p_77648_6_))
            {
                return false;
            }
        }

        if (!p_77648_2_.canPlayerEdit(p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_1_))
        {
            return false;
        }
        else
        {
            if (NovaCraftBlocks.xancium_wire.canPlaceBlockAt(p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_))
            {
                --p_77648_1_.stackSize;
                p_77648_3_.setBlock(p_77648_4_, p_77648_5_, p_77648_6_, NovaCraftBlocks.xancium_wire);
            }

            return true;
        }
    }
}
