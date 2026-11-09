package com.NovaCraft.Items;

import java.util.List;
import com.NovaCraft.registry.NovaCraftCreativeTabs;
import com.NovaCraftBlocks.NovaCraftBlocks;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class ItemImpureOutsiderIngot extends Item {

	public ItemImpureOutsiderIngot()
    {
        this.setCreativeTab(NovaCraftCreativeTabs.items);
    }
	
	public void addInformation(final ItemStack stack, final EntityPlayer player, final List tooltip, final boolean who) {
        tooltip.add(EnumChatFormatting.LIGHT_PURPLE + "" + StatCollector.translateToLocal("tooltip.impure_ousider_ingot.desc"));
    }
	
	@Override
	public boolean onItemUse(ItemStack heldItem, EntityPlayer player, World world, int x, int y, int z, int facing, float hitX, float hitY, float hitZ) {
		Block block = world.getBlock(x, y, z);
		int meta = world.getBlockMetadata(x, y, z);
		
		if (world.getBlock(x, y, z) == NovaCraftBlocks.unknown_portal_sealed) {
			world.playSoundEffect((double)x + 0.5D, (double)y + 0.5D, (double)z + 0.5D, "fire.ignite", 2.0F, itemRand.nextFloat() * 0.4F + 0.8F);
			--heldItem.stackSize;
			player.inventory.addItemStackToInventory(new ItemStack(NovaCraftItems.outsider_ingot));
		}
		
		return true;
	}

}
