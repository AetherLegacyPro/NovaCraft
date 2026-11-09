package com.NovaCraft.Items;

import com.NovaCraft.entity.misc.EntityCrimsonEye;
import com.NovaCraft.registry.NovaCraftCreativeTabs;
import com.NovaCraft.world.floating_island.FloatingIslandFinder;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import java.util.List;

public class ItemCrimsonEye extends Item {

    public ItemCrimsonEye() {
        this.setMaxStackSize(16);
        this.setCreativeTab(NovaCraftCreativeTabs.items);
    }

    @Override
    public boolean hasEffect(ItemStack stack, int pass) {
        return true;
    }

    @Override public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
        if (!world.isRemote) {
            ChunkCoordinates coords = FloatingIslandFinder.getNearestAncientCity(world, (int)player.posX, (int)player.posZ);
            if (coords != null) {
                EntityCrimsonEye eye = new EntityCrimsonEye(world, player.posX, player.posY + 1.62D, player.posZ);
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
        tooltip.add(EnumChatFormatting.RED + "" + StatCollector.translateToLocal("tooltip.crimson_eye.desc"));
    }
}
