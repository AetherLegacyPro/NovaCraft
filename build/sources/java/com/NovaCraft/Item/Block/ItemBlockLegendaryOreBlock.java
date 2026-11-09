package com.NovaCraft.Item.Block;

import com.NovaCraft.entity.EntityFireProofItemNovaCraft;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.item.*;
import net.minecraft.world.World;

public class ItemBlockLegendaryOreBlock extends ItemBlock
{
    public static final String[] types;

    public ItemBlockLegendaryOreBlock(final Block block) {
        super(block);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    public int getMetadata(final int meta) {
        return meta;
    }

    public String getUnlocalizedName(final ItemStack itemstack) {
        int meta = itemstack.getItemDamage();
        if (meta < 0 || meta >= ItemBlockLegendaryOreBlock.types.length) {
            meta = 0;
        }
        return super.getUnlocalizedName() + "_" + ItemBlockLegendaryOreBlock.types[meta];
    }

    public boolean hasCustomEntity(final ItemStack stack) {
        return true;
    }

    public Entity createEntity(final World world, final Entity location, final ItemStack itemstack) {
        return (Entity)new EntityFireProofItemNovaCraft(world, location, itemstack);
    }

    static {
        types = new String[] { "trillint_block", "kreenovite_block", "xifesonite_block" };
    }
}
