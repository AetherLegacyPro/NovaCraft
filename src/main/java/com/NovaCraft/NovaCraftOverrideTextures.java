package com.NovaCraft;

import com.NovaCraft.config.ConfigsTextureOverride;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;

public class NovaCraftOverrideTextures {

	public static void init() {
        if (ConfigsTextureOverride.override_vanilla_ore_textures) {
            Blocks.diamond_ore.setBlockTextureName("nova_craft:diamond_ore");
            Blocks.emerald_ore.setBlockTextureName("nova_craft:emerald_ore");
            Blocks.coal_ore.setBlockTextureName("nova_craft:coal_ore");
            Blocks.gold_ore.setBlockTextureName("nova_craft:gold_ore");
            Blocks.iron_ore.setBlockTextureName("nova_craft:iron_ore");
            Blocks.lapis_ore.setBlockTextureName("nova_craft:lapis_ore");
            Blocks.redstone_ore.setBlockTextureName("nova_craft:redstone_ore");
            Blocks.lit_redstone_ore.setBlockTextureName("nova_craft:redstone_ore");
        }
        if (ConfigsTextureOverride.override_stone_texture) {
            Blocks.stone.setBlockTextureName("nova_craft:stone");
        }
        if (ConfigsTextureOverride.override_gravel_texture) {
            Blocks.gravel.setBlockTextureName("nova_craft:gravel");
        }
        
        if (ConfigsTextureOverride.override_raw_porkchop_texture) {
        Items.porkchop.setTextureName("nova_craft:porkchop_raw");
        }
        if (ConfigsTextureOverride.override_cooked_porkchop_texture) {
        Items.cooked_porkchop.setTextureName("nova_craft:porkchop_cooked");
        }
        if (ConfigsTextureOverride.override_raw_beef_texture) {
        Items.beef.setTextureName("nova_craft:beef_raw");
        }
        if (ConfigsTextureOverride.override_steak_texture) {
        Items.cooked_beef.setTextureName("nova_craft:beef_cooked"); 
        }
        if (ConfigsTextureOverride.override_raw_chicken_texture) {
        Items.chicken.setTextureName("nova_craft:chicken_raw");
        }
        if (ConfigsTextureOverride.override_cooked_chicken_texture) {
        Items.cooked_chicken.setTextureName("nova_craft:chicken_cooked");
        }
    }
}
