package com.NovaCraft.config;

import java.io.File;
import net.minecraftforge.common.config.Configuration;

public class ConfigsTextureOverride {
    public static boolean override_stone_texture = false;
    public static boolean override_gravel_texture = false;
    public static boolean override_vanilla_ore_textures = true;
    public static boolean override_raw_porkchop_texture = true;
    public static boolean override_cooked_porkchop_texture = true;
    public static boolean override_raw_beef_texture = true;
    public static boolean override_steak_texture = true;
    public static boolean override_raw_chicken_texture = true;
    public static boolean override_cooked_chicken_texture = true;

    public static void init(File configFile) {
        Configuration conf = new Configuration(configFile);

        try {
            conf.load();
            override_stone_texture = conf.get("Enable Stone Texture Override?", "Enables 1.14 stone texture.", override_stone_texture).getBoolean(true);
            override_gravel_texture = conf.get("Enable Gravel Texture Override?", "Enables pre 1.3 gravel texture.", override_gravel_texture).getBoolean(true);
            override_vanilla_ore_textures = conf.get("Enable Modern Ore Textures?", "Enables Post 1.17 Ore textures.", override_vanilla_ore_textures).getBoolean(true);
            override_raw_porkchop_texture = conf.get("Enable Raw Porkchop Texture Override?", "Enables pre 1.3 raw porkchop texture.", override_raw_porkchop_texture).getBoolean(true);
            override_cooked_porkchop_texture = conf.get("Enable Cooked Porkchop Texture Override?", "Enables pre 1.3 cooked porkchop texture.", override_cooked_porkchop_texture).getBoolean(true);
            override_raw_beef_texture = conf.get("Enable Raw Beef Texture Override?", "Enables pre 1.3 raw beef texture.", override_raw_beef_texture).getBoolean(true);
            override_steak_texture = conf.get("Enable Steak Texture Override?", "Enables pre 1.3 steak texture.", override_steak_texture).getBoolean(true);
            override_raw_chicken_texture = conf.get("Enable Raw Chicken Texture Override?", "Enables pre 1.3 raw chicken texture.", override_raw_chicken_texture).getBoolean(true);
            override_cooked_chicken_texture = conf.get("Enable Cooked Chicken Texture Override?", "Enables pre 1.3 cooked chicken texture.", override_cooked_chicken_texture).getBoolean(true);
        } finally {
            conf.save();
        }

    }
}

