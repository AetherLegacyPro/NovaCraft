package com.NovaCraft.registry;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class DeepoidBrewingRecipeHandler {

    public final Item inputItem;
    public final int inputMeta;
    public final Item ingredient;
    public final Item outputItem;
    public final int outputMeta;

    public DeepoidBrewingRecipeHandler(Item inputItem, int inputMeta, Item ingredient, Item outputItem, int outputMeta) {

        this.inputItem = inputItem;
        this.inputMeta = inputMeta;
        this.ingredient = ingredient;
        this.outputItem = outputItem;
        this.outputMeta = outputMeta;
    }

    public boolean matches(ItemStack input, ItemStack ingredientStack) {
        return input != null && ingredientStack != null && input.getItem() == inputItem && input.getItemDamage() == inputMeta && ingredientStack.getItem() == ingredient;
    }

    public ItemStack getResult() {
        return new ItemStack(outputItem, 1, outputMeta);
    }
}

