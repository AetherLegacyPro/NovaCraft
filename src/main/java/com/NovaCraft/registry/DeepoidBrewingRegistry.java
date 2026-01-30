package com.NovaCraft.registry;

import com.NovaCraft.Items.NovaCraftItems;
import net.minecraft.item.ItemStack;

public class DeepoidBrewingRegistry {

    public static void init() {
        DeepoidBrewingRecipes.register(new DeepoidBrewingRecipeHandler(NovaCraftItems.awkward_potion, 9, NovaCraftItems.nullwart_blend, NovaCraftItems.potion_speed_extended, 0));
        DeepoidBrewingRecipes.register(new DeepoidBrewingRecipeHandler(NovaCraftItems.awkward_potion, 11, NovaCraftItems.nullwart_blend, NovaCraftItems.potion_fire_resistance_extended, 0));
        DeepoidBrewingRecipes.register(new DeepoidBrewingRecipeHandler(NovaCraftItems.awkward_potion, 14, NovaCraftItems.nullwart_blend, NovaCraftItems.potion_invisibility_extended, 0));
        DeepoidBrewingRecipes.register(new DeepoidBrewingRecipeHandler(NovaCraftItems.awkward_potion, 10, NovaCraftItems.nullwart_blend, NovaCraftItems.potion_water_breathing_extended, 0));
        DeepoidBrewingRecipes.register(new DeepoidBrewingRecipeHandler(NovaCraftItems.awkward_potion, 15, NovaCraftItems.nullwart_blend, NovaCraftItems.potion_jump_extended, 0));
        DeepoidBrewingRecipes.register(new DeepoidBrewingRecipeHandler(NovaCraftItems.awkward_potion, 8, NovaCraftItems.nullwart_blend, NovaCraftItems.potion_strength_extended, 0));
        DeepoidBrewingRecipes.register(new DeepoidBrewingRecipeHandler(NovaCraftItems.awkward_potion, 12, NovaCraftItems.nullwart_blend, NovaCraftItems.potion_night_vision_extended, 0));
        DeepoidBrewingRecipes.register(new DeepoidBrewingRecipeHandler(NovaCraftItems.awkward_potion, 13, NovaCraftItems.nullwart_blend, NovaCraftItems.potion_regen_extended, 0));

        //haste
        DeepoidBrewingRecipes.register(new DeepoidBrewingRecipeHandler(NovaCraftItems.awkward_potion, 0, NovaCraftItems.pherithium_carrot, NovaCraftItems.awkward_potion, 1));
        DeepoidBrewingRecipes.register(new DeepoidBrewingRecipeHandler(NovaCraftItems.awkward_potion, 1, NovaCraftItems.cave_monitor_scales, NovaCraftItems.awkward_potion, 2));
        DeepoidBrewingRecipes.register(new DeepoidBrewingRecipeHandler(NovaCraftItems.awkward_potion, 1, NovaCraftItems.nullwart_blend, NovaCraftItems.potion_haste, 0));
        DeepoidBrewingRecipes.register(new DeepoidBrewingRecipeHandler(NovaCraftItems.awkward_potion, 2, NovaCraftItems.nullwart_blend, NovaCraftItems.potion_haste_II, 0));

        DeepoidBrewingRecipes.register(new DeepoidBrewingRecipeHandler(NovaCraftItems.potion_strength_extended, 1, NovaCraftItems.anomalous_essence, NovaCraftItems.awkward_potion, 8));
        DeepoidBrewingRecipes.register(new DeepoidBrewingRecipeHandler(NovaCraftItems.potion_speed_extended, 1, NovaCraftItems.brimstone_dust, NovaCraftItems.awkward_potion, 9));
        DeepoidBrewingRecipes.register(new DeepoidBrewingRecipeHandler(NovaCraftItems.potion_water_breathing_extended, 1, NovaCraftItems.sea_serpent_scales, NovaCraftItems.awkward_potion, 10));
        DeepoidBrewingRecipes.register(new DeepoidBrewingRecipeHandler(NovaCraftItems.potion_fire_resistance_extended, 1, NovaCraftItems.blazing_serpent_tooth, NovaCraftItems.awkward_potion, 11));
        DeepoidBrewingRecipes.register(new DeepoidBrewingRecipeHandler(NovaCraftItems.potion_night_vision_extended, 1, NovaCraftItems.sculked_monitor_eye, NovaCraftItems.awkward_potion, 12));
        DeepoidBrewingRecipes.register(new DeepoidBrewingRecipeHandler(NovaCraftItems.potion_regen_extended, 1, NovaCraftItems.wyrmling_scales, NovaCraftItems.awkward_potion, 13));
        DeepoidBrewingRecipes.register(new DeepoidBrewingRecipeHandler(NovaCraftItems.potion_invisibility_extended, 1, NovaCraftItems.wardling_dust, NovaCraftItems.awkward_potion, 14));
        DeepoidBrewingRecipes.register(new DeepoidBrewingRecipeHandler(NovaCraftItems.potion_jump_extended, 1, NovaCraftItems.glow_ink_sac, NovaCraftItems.awkward_potion, 15));

        DeepoidBrewingRecipes.register(new DeepoidBrewingRecipeHandler(NovaCraftItems.potion_strength_extended, 0, NovaCraftItems.deepoid_horn, NovaCraftItems.potion_strength_III, 0));
        DeepoidBrewingRecipes.register(new DeepoidBrewingRecipeHandler(NovaCraftItems.potion_speed_extended, 0, NovaCraftItems.enderavis_feather, NovaCraftItems.potion_speed_III, 0));
        DeepoidBrewingRecipes.register(new DeepoidBrewingRecipeHandler(NovaCraftItems.potion_regen_extended, 0, NovaCraftItems.sculk_dweller_heart, NovaCraftItems.potion_regen_III, 0));
        DeepoidBrewingRecipes.register(new DeepoidBrewingRecipeHandler(NovaCraftItems.potion_jump_extended, 0, NovaCraftItems.phoenix_feather, NovaCraftItems.potion_jump_III, 0));

        //Blindness
        DeepoidBrewingRecipes.register(new DeepoidBrewingRecipeHandler(NovaCraftItems.awkward_potion, 0, NovaCraftItems.static_essence, NovaCraftItems.awkward_potion, 16));
        DeepoidBrewingRecipes.register(new DeepoidBrewingRecipeHandler(NovaCraftItems.awkward_potion, 0, NovaCraftItems.relik_dust, NovaCraftItems.awkward_potion, 16));
        DeepoidBrewingRecipes.register(new DeepoidBrewingRecipeHandler(NovaCraftItems.awkward_potion, 16, NovaCraftItems.nullwart_blend, NovaCraftItems.awkward_potion, 17));

        //resistance
        DeepoidBrewingRecipes.register(new DeepoidBrewingRecipeHandler(NovaCraftItems.awkward_potion, 0, NovaCraftItems.enflamed_null_cube_slimeball, NovaCraftItems.awkward_potion, 3));
        DeepoidBrewingRecipes.register(new DeepoidBrewingRecipeHandler(NovaCraftItems.awkward_potion, 3, NovaCraftItems.nullwart_blend, NovaCraftItems.potion_resistance, 0));

        DeepoidBrewingRecipes.register(new DeepoidBrewingRecipeHandler(NovaCraftItems.potion_speed_III, 1, NovaCraftItems.enderavis_feather, NovaCraftItems.awkward_potion, 4));
        DeepoidBrewingRecipes.register(new DeepoidBrewingRecipeHandler(NovaCraftItems.potion_strength_III, 1, NovaCraftItems.deepoid_horn, NovaCraftItems.awkward_potion, 6));
        DeepoidBrewingRecipes.register(new DeepoidBrewingRecipeHandler(NovaCraftItems.potion_regen_III, 1, NovaCraftItems.sculk_dweller_heart, NovaCraftItems.awkward_potion, 5));
        DeepoidBrewingRecipes.register(new DeepoidBrewingRecipeHandler(NovaCraftItems.potion_jump_III, 1, NovaCraftItems.phoenix_feather, NovaCraftItems.awkward_potion, 7));

        DeepoidBrewingRecipes.register(new DeepoidBrewingRecipeHandler(NovaCraftItems.awkward_potion, 4, NovaCraftItems.nullwart_blend, NovaCraftItems.potion_speed_III, 0));
        DeepoidBrewingRecipes.register(new DeepoidBrewingRecipeHandler(NovaCraftItems.awkward_potion, 6, NovaCraftItems.nullwart_blend, NovaCraftItems.potion_strength_III, 0));
        DeepoidBrewingRecipes.register(new DeepoidBrewingRecipeHandler(NovaCraftItems.awkward_potion, 5, NovaCraftItems.nullwart_blend, NovaCraftItems.potion_regen_III, 0));
        DeepoidBrewingRecipes.register(new DeepoidBrewingRecipeHandler(NovaCraftItems.awkward_potion, 7, NovaCraftItems.nullwart_blend, NovaCraftItems.potion_jump_III, 0));

    }

    public static ItemStack getResult(ItemStack input, ItemStack ingredient) {
        return DeepoidBrewingRecipes.getResult(input, ingredient);
    }
}

