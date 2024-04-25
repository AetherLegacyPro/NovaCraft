package com.NovaCraft.config;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class ConfigsTextureOverride {

	 public static boolean override_stone_texture;
	 public static boolean override_gravel_texture;
     public static boolean override_vanilla_ore_textures;
     
	 public static void init(final File configFile) {
     final Configuration conf = new Configuration(configFile);
     try {
         conf.load();
         ConfigsTextureOverride.override_stone_texture = conf.get("Enable Stone Texture Override?", "Enables 1.14 stone texture.", ConfigsTextureOverride.override_stone_texture).getBoolean(true);
         ConfigsTextureOverride.override_gravel_texture = conf.get("Enable Stone Texture Override?", "Enables pre 1.3 gravel texture.", ConfigsTextureOverride.override_gravel_texture).getBoolean(true);
         ConfigsTextureOverride.override_vanilla_ore_textures = conf.get("Enable Modern Ore Textures?", "Enables Post 1.17 Ore textures.", ConfigsTextureOverride.override_vanilla_ore_textures).getBoolean(true);
     }
     finally {
         conf.save();
     }
  }	
	 
	 static {
		 ConfigsTextureOverride.override_stone_texture = false;
		 ConfigsTextureOverride.override_gravel_texture = true;
		 ConfigsTextureOverride.override_vanilla_ore_textures = true;
  }
	
}
