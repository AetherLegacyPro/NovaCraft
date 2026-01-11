package com.NovaCraft.Items;

import com.NovaCraft.registry.NovaCraftCreativeTabs;
import com.NovaCraftBlocks.NovaCraftBlocks;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemEndPortalSealent extends Item {

    public ItemEndPortalSealent()
    {
        maxStackSize = 16;
        this.setCreativeTab(NovaCraftCreativeTabs.items);
    }

    @Override
    public boolean onItemUse(ItemStack heldItem, EntityPlayer player, World world, int x, int y, int z, int facing, float hitX, float hitY, float hitZ) {
        int meta = world.getBlockMetadata(x, y, z);

        if ((world.getBlock(x, y, z) == NovaCraftBlocks.cracked_end_portal_frame)) {

            world.playSoundEffect((double)x + 0.5D, (double)y + 0.5D, (double)z + 0.5D, "random.fizz", 2.0F, itemRand.nextFloat() * 0.4F + 0.8F);
            world.playSoundEffect((double)x + 0.5D, (double)y + 0.5D, (double)z + 0.5D, "dig.glass", 2.0F, itemRand.nextFloat() * 0.4F + 0.8F);
            --heldItem.stackSize;

            if (itemRand.nextBoolean()) {
                world.setBlock(x, y, z, Blocks.end_portal_frame, meta, 2);
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean hasEffect(ItemStack stack, int pass) {
        return true;
    }
}
