package com.NovaCraft.Items;

import com.NovaCraft.entity.EntityFireProofItemNovaCraft;
import com.NovaCraft.registry.NovaCraftCreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import java.util.List;

public class ItemMercuridiumIngot extends Item {

    public ItemMercuridiumIngot() {
        this.setCreativeTab(NovaCraftCreativeTabs.items);
    }

    public boolean hasCustomEntity(final ItemStack stack) {
        return true;
    }

    public Entity createEntity(final World world, final Entity location, final ItemStack itemstack) {
        return (Entity)new EntityFireProofItemNovaCraft(world, location, itemstack);
    }

    public void addInformation(final ItemStack stack, final EntityPlayer player, final List tooltip, final boolean who) {
        tooltip.add(EnumChatFormatting.GOLD + "" + StatCollector.translateToLocal("gui.mercuridium_ingot.desc"));
        tooltip.add(EnumChatFormatting.GOLD + "" + StatCollector.translateToLocal("gui.mercuridium_ingot2.desc"));
        tooltip.add(EnumChatFormatting.GOLD + "" + StatCollector.translateToLocal("gui.mercuridium_ingot3.desc"));
        tooltip.add(EnumChatFormatting.GOLD + "" + StatCollector.translateToLocal("gui.mercuridium_ingot4.desc"));
    }

}
