package com.NovaCraft.entity.misc;

import java.util.Random;

import com.NovaCraft.Items.NovaCraftItems;

import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public abstract class EntityNovaCraftAnimal extends EntityAnimal {

	Random random = new Random();

	public EntityNovaCraftAnimal(World worldIn) {
		super(worldIn);
	}

	@Override
	public boolean isBreedingItem(ItemStack stack) {
		return stack.getItem() == NovaCraftItems.nullwart;
	}

}
