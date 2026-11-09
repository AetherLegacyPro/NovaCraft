package com.NovaCraft.Items;

import com.NovaCraft.entity.EntityFireProofItemNovaCraft;
import com.NovaCraft.registry.NovaCraftCreativeTabs;
import com.NovaCraftBlocks.NovaCraftBlocks;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemUnpoweredBedrockCleave extends Item {

    public ItemUnpoweredBedrockCleave() {
        this.setCreativeTab(NovaCraftCreativeTabs.tools);
        this.setMaxStackSize(1);
    }


    public boolean hasCustomEntity(final ItemStack stack) {
        return true;
    }

    public Entity createEntity(final World world, final Entity location, final ItemStack itemstack) {
        return (Entity)new EntityFireProofItemNovaCraft(world, location, itemstack);
    }

    @Override
    public boolean onItemUse(ItemStack heldItem, EntityPlayer player, World world, int x, int y, int z, int facing, float hitX, float hitY, float hitZ) {
        Block block = world.getBlock(x, y, z);
        int meta = world.getBlockMetadata(x, y, z);

        if (world.getBlock(x, y, z) == NovaCraftBlocks.unknown_portal_sealed) {
            world.playSoundEffect((double)x + 0.5D, (double)y + 0.5D, (double)z + 0.5D, "nova_craft:unknown.activated", 2.0F, itemRand.nextFloat() * 1.4F + 1.8F);
            --heldItem.stackSize;
            player.inventory.addItemStackToInventory(new ItemStack(NovaCraftItems.bedrock_cleave));
        }

        return true;
    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return EnumRarity.uncommon;
    }

}

