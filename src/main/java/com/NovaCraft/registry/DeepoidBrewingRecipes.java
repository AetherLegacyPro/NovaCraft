package com.NovaCraft.registry;

import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class DeepoidBrewingRecipes {

    private static final List<DeepoidBrewingRecipeHandler> RECIPES = new ArrayList<DeepoidBrewingRecipeHandler>();

    public static void register(DeepoidBrewingRecipeHandler recipe) {
        RECIPES.add(recipe);
    }

    public static ItemStack getResult(ItemStack input, ItemStack ingredient) {
        for (DeepoidBrewingRecipeHandler recipe : RECIPES) {
            if (recipe.matches(input, ingredient)) {
                return recipe.getResult();
            }
        }
        return null;
    }
}

