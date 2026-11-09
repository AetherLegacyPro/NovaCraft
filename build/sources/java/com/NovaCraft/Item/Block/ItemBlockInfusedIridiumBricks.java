package com.NovaCraft.Item.Block;

import com.NovaCraft.entity.EntityFireProofItemNovaCraft;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.item.*;
import net.minecraft.world.World;

public class ItemBlockInfusedIridiumBricks extends ItemBlock
{
    public static final String[] types;

    public ItemBlockInfusedIridiumBricks(final Block block) {
        super(block);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    public int getMetadata(final int meta) {
        return meta;
    }

    public String getUnlocalizedName(final ItemStack itemstack) {
        int meta = itemstack.getItemDamage();
        if (meta < 0 || meta >= ItemBlockInfusedIridiumBricks.types.length) {
            meta = 0;
        }
        return super.getUnlocalizedName() + "_" + ItemBlockInfusedIridiumBricks.types[meta];
    }

    public boolean hasCustomEntity(final ItemStack stack) {
        return true;
    }

    public Entity createEntity(final World world, final Entity location, final ItemStack itemstack) {
        return (Entity)new EntityFireProofItemNovaCraft(world, location, itemstack);
    }

    static {
        types = new String[] { "copartz_infused_iridium_bricks", "larimar_infused_iridium_bricks", "tsavorokite_infused_iridium_bricks", "yttrlinsite_infused_iridium_bricks", "aether_infused_iridium_bricks", "null_infused_iridium_bricks", "echo_infused_iridium_bricks" };
    }
}
