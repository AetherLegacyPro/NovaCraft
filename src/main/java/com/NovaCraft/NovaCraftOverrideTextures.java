package com.NovaCraft;

import com.NovaCraft.config.ConfigsTextureOverride;

import net.minecraft.init.Blocks;

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
    }
}
