package com.NovaCraft.Items;

import java.util.List;

import com.NovaCraft.registry.NovaCraftCreativeTabs;
import com.NovaCraftBlocks.NovaCraftBlocks;

import net.minecraft.block.Block;
import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class ItemDimensionalSealent extends Item {
	
	public ItemDimensionalSealent() {
		this.setCreativeTab(NovaCraftCreativeTabs.items);
		maxStackSize = 1;
	}
	
	public void addInformation(final ItemStack stack, final EntityPlayer player, final List tooltip, final boolean who) {
			tooltip.add(EnumChatFormatting.LIGHT_PURPLE + "" + StatCollector.translateToLocal("tooltip.dimensional_sealent.desc"));
			tooltip.add(EnumChatFormatting.LIGHT_PURPLE + "" + StatCollector.translateToLocal("tooltip.dimensional_sealent2.desc"));	
		}
	
	@Override
	public boolean onItemUse(ItemStack heldItem, EntityPlayer player, World world, int x, int y, int z, int facing, float hitX, float hitY, float hitZ) {
		Block block = world.getBlock(x, y, z);
		int meta = world.getBlockMetadata(x, y, z);
		
		if (world.getBlock(x, y, z) == NovaCraftBlocks.cracked_nullstone_deactivator) {
			
			world.playSoundEffect(x, y, z, "nova_craft:unknown.activated", 1.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
			world.setBlock(x, y, z, NovaCraftBlocks.nullstone_deactivator);
		}
		
		if (world.getBlock(x, y, z) == NovaCraftBlocks.activated_unknown_portal_activator && (world.getBlock(x + 59, y + 7, z) != NovaCraftBlocks.nullstone_deactivator
				|| world.getBlock(x + 8, y + 8, z - 47) != NovaCraftBlocks.nullstone_deactivator || world.getBlock(x + 8, y + 5, z + 46) != NovaCraftBlocks.nullstone_deactivator
				|| world.getBlock(x + 44, y + 4, z + 37) != NovaCraftBlocks.nullstone_deactivator || world.getBlock(x + 44, y + 4, z - 31) != NovaCraftBlocks.nullstone_deactivator)) {
			player.addChatComponentMessage(new ChatComponentText(I18n.format("tooltip.nullstone_deactivators_cracked.desc")));
		}
		
		if (world.getBlock(x, y, z) == NovaCraftBlocks.activated_unknown_portal_activator && world.getBlock(x + 59, y + 7, z) == NovaCraftBlocks.nullstone_deactivator
			&& world.getBlock(x + 8, y + 8, z - 47) == NovaCraftBlocks.nullstone_deactivator && world.getBlock(x + 8, y + 5, z + 46) == NovaCraftBlocks.nullstone_deactivator
			&& world.getBlock(x + 44, y + 4, z + 37) == NovaCraftBlocks.nullstone_deactivator && world.getBlock(x + 44, y + 4, z - 31) == NovaCraftBlocks.nullstone_deactivator) {
				world.playSoundEffect(x, y, z, "nova_craft:unknown.activated", 1.1F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
				world.setBlock(x, y, z, NovaCraftBlocks.unknown_portal_activator);
				
				world.setBlock(x - 3, y - 1, z, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y - 1, z + 1, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y - 1, z + 2, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y - 1, z + 3, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y - 1, z + 4, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y - 1, z + 5, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y - 1, z + 6, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y - 1, z + 7, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y - 1, z + 8, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y - 1, z + 9, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y - 1, z + 10, NovaCraftBlocks.unknown_portal_sealed);			
				world.setBlock(x - 3, y - 1, z - 1, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y - 1, z - 2, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y - 1, z - 3, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y - 1, z - 4, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y - 1, z - 5, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y - 1, z - 6, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y - 1, z - 7, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y - 1, z - 8, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y - 1, z - 9, NovaCraftBlocks.unknown_portal_sealed);
				
				world.setBlock(x - 3, y, z, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y, z + 1, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y, z + 2, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y, z + 3, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y, z + 4, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y, z + 5, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y, z + 6, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y, z + 7, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y, z + 8, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y, z + 9, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y, z + 10, NovaCraftBlocks.unknown_portal_sealed);			
				world.setBlock(x - 3, y, z - 1, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y, z - 2, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y, z - 3, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y, z - 4, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y, z - 5, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y, z - 6, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y, z - 7, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y, z - 8, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y, z - 9, NovaCraftBlocks.unknown_portal_sealed);
				
				world.setBlock(x - 3, y + 1, z, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y + 1, z + 1, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y + 1, z + 2, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y + 1, z + 3, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y + 1, z + 4, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y + 1, z + 5, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y + 1, z + 6, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y + 1, z + 7, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y + 1, z + 8, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y + 1, z + 9, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y + 1, z + 10, NovaCraftBlocks.unknown_portal_sealed);			
				world.setBlock(x - 3, y + 1, z - 1, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y + 1, z - 2, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y + 1, z - 3, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y + 1, z - 4, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y + 1, z - 5, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y + 1, z - 6, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y + 1, z - 7, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y + 1, z - 8, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y + 1, z - 9, NovaCraftBlocks.unknown_portal_sealed);
				
				world.setBlock(x - 3, y + 2, z, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y + 2, z + 1, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y + 2, z + 2, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y + 2, z + 3, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y + 2, z + 4, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y + 2, z + 5, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y + 2, z + 6, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y + 2, z + 7, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y + 2, z + 8, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y + 2, z + 9, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y + 2, z + 10, NovaCraftBlocks.unknown_portal_sealed);			
				world.setBlock(x - 3, y + 2, z - 1, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y + 2, z - 2, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y + 2, z - 3, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y + 2, z - 4, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y + 2, z - 5, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y + 2, z - 6, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y + 2, z - 7, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y + 2, z - 8, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y + 2, z - 9, NovaCraftBlocks.unknown_portal_sealed);
				
				world.setBlock(x - 3, y + 3, z, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y + 3, z + 1, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y + 3, z + 2, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y + 3, z + 3, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y + 3, z + 4, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y + 3, z + 5, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y + 3, z + 6, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y + 3, z + 7, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y + 3, z + 8, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y + 3, z + 9, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y + 3, z + 10, NovaCraftBlocks.unknown_portal_sealed);			
				world.setBlock(x - 3, y + 3, z - 1, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y + 3, z - 2, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y + 3, z - 3, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y + 3, z - 4, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y + 3, z - 5, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y + 3, z - 6, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y + 3, z - 7, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y + 3, z - 8, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y + 3, z - 9, NovaCraftBlocks.unknown_portal_sealed);
				
				world.setBlock(x - 3, y + 4, z, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y + 4, z + 1, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y + 4, z + 2, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y + 4, z + 3, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y + 4, z + 4, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y + 4, z + 5, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y + 4, z + 6, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y + 4, z + 7, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y + 4, z + 8, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y + 4, z + 9, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y + 4, z + 10, NovaCraftBlocks.unknown_portal_sealed);			
				world.setBlock(x - 3, y + 4, z - 1, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y + 4, z - 2, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y + 4, z - 3, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y + 4, z - 4, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y + 4, z - 5, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y + 4, z - 6, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y + 4, z - 7, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y + 4, z - 8, NovaCraftBlocks.unknown_portal_sealed);
				world.setBlock(x - 3, y + 4, z - 9, NovaCraftBlocks.unknown_portal_sealed);
				
				world.setBlock(x + 59, y + 7, z, NovaCraftBlocks.cracked_nullstone_deactivator);
				world.setBlock(x + 8, y + 8, z - 47, NovaCraftBlocks.cracked_nullstone_deactivator);
				world.setBlock(x + 8, y + 5, z + 46, NovaCraftBlocks.cracked_nullstone_deactivator);
				world.setBlock(x + 44, y + 4, z + 37, NovaCraftBlocks.cracked_nullstone_deactivator);
				world.setBlock(x + 44, y + 4, z - 31, NovaCraftBlocks.cracked_nullstone_deactivator);
				
			}
		
		return true;
	}

}
