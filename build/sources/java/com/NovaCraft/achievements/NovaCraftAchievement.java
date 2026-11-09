package com.NovaCraft.achievements;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;

public class NovaCraftAchievement extends Achievement {

	public NovaCraftAchievement(String name, String desc, int length, int width, ItemStack stack, Achievement parentAchievement) {
		super(name, desc, length, width, stack, parentAchievement);
	}

	public NovaCraftAchievement(String name, String desc, int length, int width, Item item, Achievement parentAchievement) {
		this(name, desc, length, width, new ItemStack(item), parentAchievement);
	}

	public NovaCraftAchievement(String name, String desc, int length, int width, Block block, Achievement parentAchievement) {
		this(name, desc, length, width, new ItemStack(block), parentAchievement);
	}

	@Override
	public IChatComponent func_150951_e() {
		IChatComponent ichatcomponent = super.func_150951_e();
		ichatcomponent.getChatStyle().setColor(EnumChatFormatting.DARK_AQUA);
		return ichatcomponent;
	}

}
