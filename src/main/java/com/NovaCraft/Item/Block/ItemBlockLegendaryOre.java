package com.NovaCraft.Item.Block;

import com.NovaCraft.entity.EntityFireProofItemNovaCraft;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.item.*;
import net.minecraft.world.World;

public class ItemBlockLegendaryOre extends ItemBlock
{
    public static final String[] types;

    public ItemBlockLegendaryOre(final Block block) {
        super(block);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    public int getMetadata(final int meta) {
        return meta;
    }

    public String getUnlocalizedName(final ItemStack itemstack) {
        int meta = itemstack.getItemDamage();
        if (meta < 0 || meta >= ItemBlockLegendaryOre.types.length) {
            meta = 0;
        }
        return super.getUnlocalizedName() + "_" + ItemBlockLegendaryOre.types[meta];
    }

    public boolean hasCustomEntity(final ItemStack stack) {
        return true;
    }

    public Entity createEntity(final World world, final Entity location, final ItemStack itemstack) {
        return (Entity)new EntityFireProofItemNovaCraft(world, location, itemstack);
    }

    static {
        types = new String[] { "trillint_ore", "kreenovite_ore", "xifesonite_ore" };
    }
}
