package com.NovaCraft.Items.Buckets;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.registry.NovaCraftCreativeTabs;
import com.NovaCraftBlocks.NovaCraftBlocks;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemMercuryVaniteBucket extends Item {

    public ItemMercuryVaniteBucket(Block block) {
        super();
        this.maxStackSize = 1;
        this.setCreativeTab(NovaCraftCreativeTabs.items);
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {

        if (side == 0) {
            --y;
        }

        if (side == 1) {
            ++y;
        }

        if (side == 2) {
            --z;
        }

        if (side == 3) {
            ++z;
        }

        if (side == 4) {
            --x;
        }

        if (side == 5) {
            ++x;
        }

        if (!player.canPlayerEdit(x, y, z, side, stack)) {
            return false;
        }

        Block targetBlock = world.getBlock(x, y, z);
        int targetMeta = world.getBlockMetadata(x, y, z);
        boolean targetIsAir = world.isAirBlock(x, y, z);
        boolean targetIsReplaceable = targetBlock.isReplaceable(world, x, y, z);
        boolean targetIsFlowingMercury = targetBlock == NovaCraftBlocks.mercury && targetMeta != 0;

        if (!targetIsAir && !targetIsReplaceable && !targetIsFlowingMercury) {
            return false;
        }

        if (targetBlock == NovaCraftBlocks.mercury && targetMeta == 0) {
            return false;
        }

        if (!world.isRemote) {

            world.setBlock(x, y, z, NovaCraftBlocks.mercury, 0, 3);

            if (!player.capabilities.isCreativeMode) {
                player.inventory.setInventorySlotContents(player.inventory.currentItem, new ItemStack(NovaCraftItems.vanite_bucket));
                player.inventory.markDirty();
            }

            world.playSoundEffect((double) x + 0.5D, (double) y + 0.5D, (double) z + 0.5D, "liquid.lavapop", 2.0F, itemRand.nextFloat() * 5.4F + 0.8F);
        }

        return true;
    }
}