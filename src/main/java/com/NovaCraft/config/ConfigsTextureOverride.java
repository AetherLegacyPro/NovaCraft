package com.NovaCraft.config;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class ConfigsTextureOverride {

	 public static boolean override_stone_texture;
	 public static boolean override_gravel_texture;
     public static boolean override_vanilla_ore_textures;
     
     public static boolean override_raw_porkchop_texture;
     public static boolean override_cooked_porkchop_texture;
     public static boolean override_raw_beef_texture;
     public static boolean override_steak_texture;    
     public static boolean override_raw_chicken_texture;
     public static boolean override_cooked_chicken_texture;
     
	 public static void init(final File configFile) {
     final Configuration conf = new Configuration(configFile);
     try {
         conf.load();
         ConfigsTextureOverride.override_stone_texture = conf.get("Enable Stone Texture Override?", "Enables 1.14 stone texture.", ConfigsTextureOverride.override_stone_texture).getBoolean(true);
         ConfigsTextureOverride.override_gravel_texture = conf.get("Enable Gravel Texture Override?", "Enables pre 1.3 gravel texture.", ConfigsTextureOverride.override_gravel_texture).getBoolean(true);
         ConfigsTextureOverride.override_vanilla_ore_textures = conf.get("Enable Modern Ore Textures?", "Enables Post 1.17 Ore textures.", ConfigsTextureOverride.override_vanilla_ore_textures).getBoolean(true);
         
         ConfigsTextureOverride.override_raw_porkchop_texture = conf.get("Enable Raw Porkchop Texture Override?", "Enables pre 1.3 raw porkchop texture.", ConfigsTextureOverride.override_raw_porkchop_texture).getBoolean(true);
         ConfigsTextureOverride.override_cooked_porkchop_texture = conf.get("Enable Cooked Porkchop Texture Override?", "Enables pre 1.3 cooked porkchop texture.", ConfigsTextureOverride.override_cooked_porkchop_texture).getBoolean(true);   
         ConfigsTextureOverride.override_raw_beef_texture = conf.get("Enable Raw Beef Texture Override?", "Enables pre 1.3 raw beef texture.", ConfigsTextureOverride.override_raw_beef_texture).getBoolean(true);
         ConfigsTextureOverride.override_steak_texture = conf.get("Enable Cooked Porkchop Texture Override?", "Enables pre 1.3 steak texture.", ConfigsTextureOverride.override_steak_texture).getBoolean(true);
         ConfigsTextureOverride.override_raw_chicken_texture = conf.get("Enable Raw Chicken Texture Override?", "Enables pre 1.3 raw chicken texture.", ConfigsTextureOverride.override_raw_chicken_texture).getBoolean(true);
         ConfigsTextureOverride.override_cooked_chicken_texture = conf.get("Enable Cooked Chicken Texture Override?", "Enables pre 1.3 cooked chicken texture.", ConfigsTextureOverride.override_cooked_chicken_texture).getBoolean(true);

     }
     finally {
         conf.save();
     }
  }	
	 
	 static {
		 ConfigsTextureOverride.override_stone_texture = false;
		 ConfigsTextureOverride.override_gravel_texture = false;
		 ConfigsTextureOverride.override_vanilla_ore_textures = true;
		 
		 ConfigsTextureOverride.override_raw_porkchop_texture = true;
		 ConfigsTextureOverride.override_cooked_porkchop_texture = true;		 
		 ConfigsTextureOverride.override_raw_beef_texture = true;
		 ConfigsTextureOverride.override_steak_texture = true;		 
		 ConfigsTextureOverride.override_raw_chicken_texture = true;
		 ConfigsTextureOverride.override_cooked_chicken_texture = true;
  }
	
}
