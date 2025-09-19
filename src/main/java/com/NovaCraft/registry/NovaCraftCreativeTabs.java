package com.NovaCraft.registry;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraftBlocks.NovaCraftBlocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class NovaCraftCreativeTabs {

	public static NovacraftTab blocks = new NovacraftTab("novacraft_blocks"),
			items = new NovacraftTab("novacraft_items"),
			tools = new NovacraftTab("novacraft_tools"),
			potions = new NovacraftTab("novacraft_potions");

	public static void initialization() {
		blocks.setIcon(new ItemStack(NovaCraftBlocks.nullstone));
		items.setIcon(new ItemStack(NovaCraftItems.copartz_shard));
		tools.setIcon(new ItemStack(NovaCraftItems.scythe));
		potions.setIcon(new ItemStack(NovaCraftItems.vanite_crystal));
	}

	public static class NovacraftTab extends CreativeTabs {

		private ItemStack stack;

		public NovacraftTab(String unlocalizedName) {
			super(unlocalizedName);
		}

		public NovacraftTab(String unlocalizedName, ItemStack stack) {
			super(unlocalizedName);
			this.stack = stack;
		}

		public void setIcon(ItemStack stack) {
			this.stack = stack;
		}

		@SideOnly(Side.CLIENT)
		public String getTranslatedTabLabel() {
			return "tab." + this.getTabLabel();
		}

		@Override
		public ItemStack getIconItemStack() {
			return stack;
		}

		@Override
		public Item getTabIconItem() {
			return stack.getItem();
		}

	}

}
