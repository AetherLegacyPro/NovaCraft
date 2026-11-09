package com.NovaCraft.Items;

import com.NovaCraft.entity.misc.EntityVindicatorEye;
import com.NovaCraft.registry.NovaCraftCreativeTabs;
import com.NovaCraft.world.mansion.MansionFinder;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import java.util.List;

public class ItemVindicatorInsignia extends Item {

    public ItemVindicatorInsignia() {
        this.setMaxStackSize(16);
        this.setCreativeTab(NovaCraftCreativeTabs.items);
    }

    @Override
    public boolean hasEffect(ItemStack stack, int pass) {
        return true;
    }

    @Override public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
        if (!world.isRemote) {
            ChunkCoordinates coords = MansionFinder.getNearestMansion(world, (int)player.posX, (int)player.posZ);
            if (coords != null) {
                EntityVindicatorEye eye = new EntityVindicatorEye(world, player.posX, player.posY + 1.62D, player.posZ);
                eye.moveTowards(coords.posX, coords.posY, coords.posZ);
                world.spawnEntityInWorld(eye); world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
            }
        }
        if (!player.capabilities.isCreativeMode) {
            stack.stackSize--;
        }
        return stack;
    }

    public void addInformation(final ItemStack stack, final EntityPlayer player, final List tooltip, final boolean who) {
        tooltip.add(EnumChatFormatting.GREEN + "" + StatCollector.translateToLocal("tooltip.vindicator_insignia.desc"));
    }
}
