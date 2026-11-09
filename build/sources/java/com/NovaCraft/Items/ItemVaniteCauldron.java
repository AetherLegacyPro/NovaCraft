package com.NovaCraft.Items;

import com.NovaCraft.registry.NovaCraftCreativeTabs;
import com.NovaCraftBlocks.NovaCraftBlocks;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemVaniteCauldron extends Item
{

    public ItemVaniteCauldron()
    {
        this.setCreativeTab(NovaCraftCreativeTabs.potions);
    }

    public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_)
    {
        if (world.getBlock(p_77648_4_, p_77648_5_, p_77648_6_) != Blocks.snow_layer)
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

            if (!world.isAirBlock(p_77648_4_, p_77648_5_, p_77648_6_))
            {
                return false;
            }
        }

        if (!player.canPlayerEdit(p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, itemStack))
        {
            return false;
        }
        else
        {
            if (NovaCraftBlocks.vanite_cauldron.canPlaceBlockAt(world, p_77648_4_, p_77648_5_, p_77648_6_))
            {
                --itemStack.stackSize;
                world.setBlock(p_77648_4_, p_77648_5_, p_77648_6_, NovaCraftBlocks.lava_vanite_cauldron, 0, 3);
                world.playSoundEffect(p_77648_4_, p_77648_5_, p_77648_6_, "nova_craft:grimstone_bricks.place", 1.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
            }

            return true;
        }
    }
    
}
