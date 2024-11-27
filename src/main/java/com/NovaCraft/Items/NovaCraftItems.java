package com.NovaCraft.Items;

import java.util.ArrayList;
import java.util.List;

import com.NovaCraft.NovaCraft;
import com.NovaCraft.Items.Armor.ItemCrystaliteArmor;
import com.NovaCraft.Items.Armor.ItemGuardianArmor;
import com.NovaCraft.Items.Armor.ItemKlangiteBoots;
import com.NovaCraft.Items.Armor.ItemKlangiteChestplate;
import com.NovaCraft.Items.Armor.ItemKlangiteHelmet;
import com.NovaCraft.Items.Armor.ItemKlangiteLeggings;
import com.NovaCraft.Items.Armor.ItemKylaziteArmor;
import com.NovaCraft.Items.Armor.ItemOphidianArmor;
import com.NovaCraft.Items.Armor.ItemPhantomBoots;
import com.NovaCraft.Items.Armor.ItemPhantomChestplate;
import com.NovaCraft.Items.Armor.ItemPhantomHelmet;
import com.NovaCraft.Items.Armor.ItemPhantomLeggings;
import com.NovaCraft.Items.Armor.ItemPherithiumBoots;
import com.NovaCraft.Items.Armor.ItemPherithiumChestplate;
import com.NovaCraft.Items.Armor.ItemPherithiumHelmet;
import com.NovaCraft.Items.Armor.ItemPherithiumLeggings;
import com.NovaCraft.Items.Armor.ItemSculkBoots;
import com.NovaCraft.Items.Armor.ItemSculkChestplate;
import com.NovaCraft.Items.Armor.ItemSculkHelmet;
import com.NovaCraft.Items.Armor.ItemSculkLeggings;
import com.NovaCraft.Items.Armor.ItemTophiniteBoots;
import com.NovaCraft.Items.Armor.ItemTophiniteChestplate;
import com.NovaCraft.Items.Armor.ItemTophiniteHelmet;
import com.NovaCraft.Items.Armor.ItemTophiniteLeggings;
import com.NovaCraft.Items.Armor.ItemVaniteArmor;
import com.NovaCraft.Items.Armor.ItemWardenArmor;
import com.NovaCraft.Items.Armor.crown.ItemVaniteBlueCrown;
import com.NovaCraft.Items.Armor.crown.ItemVaniteDarkBlueCrown;
import com.NovaCraft.Items.Armor.crown.ItemVaniteExoticCrown;
import com.NovaCraft.Items.Armor.crown.ItemVaniteGreenCrown;
import com.NovaCraft.Items.Armor.crown.ItemVaniteMysteriousCrown;
import com.NovaCraft.Items.Armor.crown.ItemVaniteNotchedCrown;
import com.NovaCraft.Items.Armor.crown.ItemVaniteOrangeCrown;
import com.NovaCraft.Items.Armor.crown.ItemVaniteRedCrown;
import com.NovaCraft.Items.Buckets.ItemBlazliniteBucket;
import com.NovaCraft.Items.Buckets.ItemMoltenVaniteBucket;
import com.NovaCraft.Items.Buckets.ItemVaniteBucket;
import com.NovaCraft.Items.Music.ItemDisk5;
import com.NovaCraft.Items.Music.ItemDiskNegative1;
import com.NovaCraft.Items.Music.ItemDiskNegative2;
import com.NovaCraft.Items.Potions.ItemDeepfireBlend;
import com.NovaCraft.Items.Potions.ItemPotionFireResistanceExtended;
import com.NovaCraft.Items.Potions.ItemPotionHaste;
import com.NovaCraft.Items.Potions.ItemPotionHasteII;
import com.NovaCraft.Items.Potions.ItemPotionInvisibilityExtended;
import com.NovaCraft.Items.Potions.ItemPotionJumpExtended;
import com.NovaCraft.Items.Potions.ItemPotionJumpIII;
import com.NovaCraft.Items.Potions.ItemPotionNightVisionExtended;
import com.NovaCraft.Items.Potions.ItemPotionRegenExtended;
import com.NovaCraft.Items.Potions.ItemPotionRegenIII;
import com.NovaCraft.Items.Potions.ItemPotionResistance;
import com.NovaCraft.Items.Potions.ItemPotionSpeedExtended;
import com.NovaCraft.Items.Potions.ItemPotionSpeedIII;
import com.NovaCraft.Items.Potions.ItemPotionStrengthExtended;
import com.NovaCraft.Items.Potions.ItemPotionStrengthIII;
import com.NovaCraft.Items.Potions.ItemPotionWaterBreathingExtended;
import com.NovaCraft.Items.Potions.ItemVaniteBottle;
import com.NovaCraft.Items.Shards.ItemInfusedAetherShard;
import com.NovaCraft.Items.Shards.ItemInfusedCopartzShard;
import com.NovaCraft.Items.Shards.ItemInfusedLarimarShard;
import com.NovaCraft.Items.Shards.ItemInfusedTsavorokiteShard;
import com.NovaCraft.Items.Shards.ItemInfusedYttrlinsiteShard;
import com.NovaCraft.Items.Staffs.ItemCrystalGrowthStaff;
import com.NovaCraft.Items.Staffs.ItemCrystaliteBow;
import com.NovaCraft.Items.Staffs.ItemCrystallizedVaniteBow;
import com.NovaCraft.Items.Staffs.ItemDiamondBow;
import com.NovaCraft.Items.Staffs.ItemDiamondFirechargeLauncher;
import com.NovaCraft.Items.Staffs.ItemEnderLordStaff;
import com.NovaCraft.Items.Staffs.ItemIceSceptor;
import com.NovaCraft.Items.Staffs.ItemKlangiteBow;
import com.NovaCraft.Items.Staffs.ItemKlangiteFirechargeLauncher;
import com.NovaCraft.Items.Staffs.ItemKylaziteBow;
import com.NovaCraft.Items.Staffs.ItemNetheriteBow;
import com.NovaCraft.Items.Staffs.ItemOphidianBow;
import com.NovaCraft.Items.Staffs.ItemPrimevalHorn;
import com.NovaCraft.Items.Staffs.ItemSculkHorn;
import com.NovaCraft.Items.Staffs.ItemTophiniteBow;
import com.NovaCraft.Items.Staffs.ItemVaniteFirechargeLauncher;
import com.NovaCraft.Items.Staffs.ItemWardenBow;
import com.NovaCraft.Items.Tools.ItemCrystalitePickaxe;
import com.NovaCraft.Items.Tools.ItemCrystaliteSword;
import com.NovaCraft.Items.Tools.ItemCrystallizedVaniteAxe;
import com.NovaCraft.Items.Tools.ItemCrystallizedVaniteHoe;
import com.NovaCraft.Items.Tools.ItemCrystallizedVanitePickaxe;
import com.NovaCraft.Items.Tools.ItemCrystallizedVaniteShovel;
import com.NovaCraft.Items.Tools.ItemCrystallizedVaniteSword;
import com.NovaCraft.Items.Tools.ItemDiablo;
import com.NovaCraft.Items.Tools.ItemEerieSword;
import com.NovaCraft.Items.Tools.ItemKlangiteAxe;
import com.NovaCraft.Items.Tools.ItemKlangiteHoe;
import com.NovaCraft.Items.Tools.ItemKlangitePickaxe;
import com.NovaCraft.Items.Tools.ItemKlangiteShovel;
import com.NovaCraft.Items.Tools.ItemKlangiteSword;
import com.NovaCraft.Items.Tools.ItemKylaziteAxe;
import com.NovaCraft.Items.Tools.ItemKylaziteHoe;
import com.NovaCraft.Items.Tools.ItemKylazitePickaxe;
import com.NovaCraft.Items.Tools.ItemKylaziteShovel;
import com.NovaCraft.Items.Tools.ItemKylaziteSword;
import com.NovaCraft.Items.Tools.ItemOphidianAxe;
import com.NovaCraft.Items.Tools.ItemOphidianHoe;
import com.NovaCraft.Items.Tools.ItemOphidianPickaxe;
import com.NovaCraft.Items.Tools.ItemOphidianShovel;
import com.NovaCraft.Items.Tools.ItemOphidianSword;
import com.NovaCraft.Items.Tools.ItemPherithiumAxe;
import com.NovaCraft.Items.Tools.ItemPherithiumHoe;
import com.NovaCraft.Items.Tools.ItemPherithiumPickaxe;
import com.NovaCraft.Items.Tools.ItemPherithiumShickaxe;
import com.NovaCraft.Items.Tools.ItemPherithiumShovel;
import com.NovaCraft.Items.Tools.ItemPherithiumSword;
import com.NovaCraft.Items.Tools.ItemPhoenixRazor;
import com.NovaCraft.Items.Tools.ItemPrimevalMace;
import com.NovaCraft.Items.Tools.ItemReinforcedPherithiumShickaxe;
import com.NovaCraft.Items.Tools.ItemSculkedBlade;
import com.NovaCraft.Items.Tools.ItemScythe;
import com.NovaCraft.Items.Tools.ItemTophiniteAxe;
import com.NovaCraft.Items.Tools.ItemTophiniteHammer;
import com.NovaCraft.Items.Tools.ItemTophiniteHoe;
import com.NovaCraft.Items.Tools.ItemTophinitePickaxe;
import com.NovaCraft.Items.Tools.ItemTophiniteShovel;
import com.NovaCraft.Items.Tools.ItemTophiniteSword;
import com.NovaCraft.Items.Tools.ItemVaniteTrident;
import com.NovaCraft.Items.Tools.ItemWardenAxe;
import com.NovaCraft.Items.Tools.ItemWardenHoe;
import com.NovaCraft.Items.Tools.ItemWardenPickaxe;
import com.NovaCraft.Items.Tools.ItemWardenShovel;
import com.NovaCraft.Items.Tools.ItemWardenSword;
import com.NovaCraft.Items.Tools.NCToolMaterial;
import com.NovaCraft.Items.goathorn.ItemGoatHorn;
import com.NovaCraft.Items.goathorn.ItemGoatHornAdmire;
import com.NovaCraft.Items.goathorn.ItemGoatHornCall;
import com.NovaCraft.Items.goathorn.ItemGoatHornDream;
import com.NovaCraft.Items.goathorn.ItemGoatHornFeel;
import com.NovaCraft.Items.goathorn.ItemGoatHornSeek;
import com.NovaCraft.Items.goathorn.ItemGoatHornSing;
import com.NovaCraft.Items.goathorn.ItemGoatHornYearn;
import com.NovaCraft.registry.NovaCraftCreativeTabs;
import com.NovaCraftBlocks.NovaCraftBlocks;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;

public class NovaCraftItems {
	
	public static Item copartz_shard;
	public static Item larimar_shard;
	public static Item tsavorokite_shard;
	public static Item yttrlinsite_shard;
	public static Item aether_shard;
	public static Item variegated_shard;
	public static Item anomalous_shard;
	public static Item null_shard;
	public static Item echo_shard;
	public static Item sculked_shard;
	public static Item crystallized_end_shard;
	public static Item nullified_vanite_alloy;
	
	public static Item brimstone_dust;
	public static Item petn_powder;
	public static Item pherithium_scraps;
	public static Item pherithium_lump;
	public static Item pherithium_ingot;
	public static Item vanite_chunk;
	public static Item vanite_ingot;
	public static Item reinforced_vanite_ingot, luminant_ingot;
	public static Item xancium_dust, small_xancium_dust;
	public static Item nullifier_core;
	public static Item xancium_ingot, xancium_pellet;
	public static Item raw_klangite, klangite_blend;
	public static Item impure_klangite_ingot, explosive_klangite_ingot, klangite_ingot;
	public static Item tophinite_gemstone;
	public static Item flaming_pitcher_petal, blazing_coal;
	
	public static Item heart_of_the_end, fractured_heart_of_the_end;
	public static Item null_cube_slime, superheated_magma_cream, enflamed_null_cube_slimeball, enhanced_enflamed_null_cube_slimeball;
	public static Item sculk_dweller_heart;
	public static Item sea_serpent_scales, sea_serpent_venom_sac;
	public static Item cave_monitor_scales, cave_monitor_tongue;
	public static Item sculked_monitor_scales, sculked_monitor_eye;
	public static Item warden_heart, warden_tentacle, warden_shard;
	public static Item blazing_serpent_scales, blazing_serpent_tooth;
	public static Item phoenix_feather, ionizatior_rod, ionizatior_powder;
	public static Item deepoid_scales;
	public static Item deep_one_scales, deep_one_bone;
	public static Item ophidian_scales;
	public static Item glow_ink_sac;
	public static Item phantom_membrane;
	public static Item nullwart, nullwart_blend;
	public static Item nullified_dust, wardling_dust;
	public static Item static_essence, destitute_tentacle;
	public static Item ancient_city_artifact, powered_ancient_city_artifact;
	
	public static Item vanite_bucket, vanite_bucket_lava, vanite_bucket_water, vanite_bucket_blazlinite, vanite_bucket_molten_vanite;
	public static Item vanite_bottle, vanite_crystal, vanite_cauldron_item, crystallized_vanite_alloy;
	public static Item deepfire_blend;
	
	public static Item potion_speed_extended, potion_speed_III;
	public static Item potion_strength_extended, potion_strength_III;
	public static Item potion_regen_extended, potion_regen_III;	
	public static Item potion_haste, potion_haste_II;
	public static Item potion_resistance;
	public static Item potion_jump_extended, potion_jump_III;
	public static Item potion_water_breathing_extended;
	public static Item potion_night_vision_extended;
	public static Item potion_invisibility_extended;
	public static Item potion_fire_resistance_extended;
	
	public static Item disc_fragment_5;
	public static Item disc_5, disc_negative1, disc_negative2;
	public static Item luminant_apple, luminant_tree_sap, luminant_gel;
	
	public static Item raw_enderavis, cooked_enderavis, enderavis_feather;
	public static Item sculk_flesh, sculked_leather;
	public static Item raw_glow_squid, cooked_glow_squid;
	public static Item raw_blazing_charger, cooked_blazing_charger;
	public static Item raw_chevon, cooked_chevon;
	public static Item pherithium_carrot;
	
	public static Item pherithium_sword, pherithium_pickaxe, pherithium_shovel, pherithium_axe, pherithium_hoe;
	public static Item diamond_bow, netherite_bow;
	public static Item tophinite_sword, tophinite_pickaxe, tophinite_bow, tophinite_shovel, tophinite_axe, tophinite_hoe, tophinite_hammer;
	public static Item crystallized_vanite_sword, crystallized_vanite_pickaxe, crystallized_vanite_bow, crystallized_vanite_shovel, crystallized_vanite_axe, crystallized_vanite_hoe;
	public static Item ophidian_sword, ophidian_pickaxe, ophidian_bow, ophidian_shovel, ophidian_axe, ophidian_hoe;
	public static Item klangite_sword, klangite_pickaxe, klangite_bow, klangite_shovel, klangite_axe, klangite_hoe;
	public static Item warden_sword, warden_pickaxe, warden_bow, warden_shovel, warden_axe, warden_hoe;
	public static Item kylazite_sword, kylazite_pickaxe, kylazite_bow, kylazite_shovel, kylazite_axe, kylazite_hoe;
	public static Item crystalite_sword, crystalite_pickaxe, crystalite_bow;
	
	public static Item pherithium_shickaxe, reinforced_pherithium_shickaxe;
	
	public static Item diamond_firecharge_launcher, klangite_firecharge_launcher, vanite_firecharge_launcher;
	public static Item goat_horn_ponder, goat_horn_sing, goat_horn_seek, goat_horn_feel, goat_horn_admire, goat_horn_call, goat_horn_yearn, goat_horn_dream;
	public static Item deepoid_horn, primeval_horn;
	
	public static Item sculk_helmet, sculk_chestplate, sculk_leggings, sculk_boots;
	public static Item pherithium_helmet, pherithium_chestplate, pherithium_leggings, pherithium_boots;	
	public static Item tophinite_helmet, tophinite_chestplate, tophinite_leggings, tophinite_boots;
	public static Item crystallized_vanite_helmet, crystallized_vanite_chestplate, crystallized_vanite_leggings, crystallized_vanite_boots;
	public static Item ophidian_helmet, ophidian_chestplate, ophidian_leggings, ophidian_boots;	
	public static Item klangite_helmet, klangite_chestplate, klangite_leggings, klangite_boots;
	public static Item kylazite_helmet, kylazite_chestplate, kylazite_leggings, kylazite_boots;
	public static Item warden_helmet, warden_chestplate, warden_leggings, warden_boots;
	public static Item crystalite_helmet, crystalite_chestplate, crystalite_leggings, crystalite_boots;
	public static Item guardian_helmet, guardian_chestplate, guardian_leggings, guardian_boots;
	
	public static Item vanite_blue_crown, vanite_red_crown, vanite_green_crown, vanite_orange_crown, vanite_mysterious_crown, vanite_exotic_crown, vanite_notched_crown, vanite_dark_blue_crown;
	
	public static Item eerie_sword, sculked_blade, scythe, diablo, sculk_horn, vanite_trident;
	
	public static Item ender_lord_staff, crystal_growth_staff, ice_sceptor, phoenix_razor, primeval_mace;
	
	public static Item phantom_helmet, phantom_chestplate, phantom_leggings, phantom_boots;
	
	public static Item novacraft_spawn_egg, xancium_firecharge;
	
	public static Item sculk_star, dark_essence, anomalous_essence, corrupted_essence;
	
	public static Item deepoid_star, eternal_caller, warden_core;
	
	public static Item infused_copartz_shard, infused_larimar_shard, infused_tsavorokite_shard, infused_yttrlinsite_shard, infused_aether_shard;
	
	public static void initialization() {
		
		copartz_shard = register("copartz_shard", new ItemNovaCraft(NovaCraftCreativeTabs.items).setTextureName(NovaCraft.find("copartz_shard")));		
		larimar_shard = register("larimar_shard", new ItemNovaCraft(NovaCraftCreativeTabs.items).setTextureName(NovaCraft.find("larimar_shard")));
		tsavorokite_shard = register("tsavorokite_shard", new ItemNovaCraft(NovaCraftCreativeTabs.items).setTextureName(NovaCraft.find("tsavorokite_shard")));
		yttrlinsite_shard = register("yttrlinsite_shard", new ItemNovaCraft(NovaCraftCreativeTabs.items).setTextureName(NovaCraft.find("yttrlinsite_shard")));
		variegated_shard = register("variegated_shard", new ItemNovaCraft(NovaCraftCreativeTabs.items).setTextureName(NovaCraft.find("variegated_shard")));
		anomalous_shard = register("anomalous_shard", new ItemAnomalousShard().setTextureName(NovaCraft.find("anomalous_shard")));
		aether_shard = register("aether_shard", new ItemNovaCraft(NovaCraftCreativeTabs.items).setTextureName(NovaCraft.find("aether_shard")));
		null_shard = register("null_shard", new ItemNovaCraft(NovaCraftCreativeTabs.items).setTextureName(NovaCraft.find("null_shard")));
		echo_shard = register("echo_shard", new ItemNovaCraft(NovaCraftCreativeTabs.items).setTextureName(NovaCraft.find("echo_shard")));
		sculked_shard = register("sculked_shard", new ItemNovaCraft(NovaCraftCreativeTabs.items).setTextureName(NovaCraft.find("sculked_shard")));
		crystallized_end_shard = register("crystallized_end_shard", new ItemNovaCraft(NovaCraftCreativeTabs.items).setTextureName(NovaCraft.find("crystallized_end_shard")));
		
		infused_copartz_shard = register("infused_copartz_shard", new ItemInfusedCopartzShard().setTextureName(NovaCraft.find("darkcopartz")));		
		infused_larimar_shard = register("infused_larimar_shard", new ItemInfusedLarimarShard().setTextureName(NovaCraft.find("darklarimar")));
		infused_tsavorokite_shard = register("infused_tsavorokite_shard", new ItemInfusedTsavorokiteShard().setTextureName(NovaCraft.find("darktsavorokite")));
		infused_yttrlinsite_shard = register("infused_yttrlinsite_shard", new ItemInfusedYttrlinsiteShard().setTextureName(NovaCraft.find("darkyttrillnite")));
		infused_aether_shard = register("infused_aether_shard", new ItemInfusedAetherShard().setTextureName(NovaCraft.find("darkaether")));
				
		brimstone_dust = register("brimstone_dust", new ItemBrimstonePowder().setTextureName(NovaCraft.find("brimstone_dust")));
		petn_powder = register("petn_powder", new ItemPETNPowder().setTextureName(NovaCraft.find("petn_powder")));
		pherithium_scraps = register("pherithium_scraps", new ItemNovaCraft(NovaCraftCreativeTabs.items).setTextureName(NovaCraft.find("pherithium_scraps")));
		pherithium_lump = register("pherithium_lump", new ItemNovaCraft(NovaCraftCreativeTabs.items).setTextureName(NovaCraft.find("pherithium_lump")));
		pherithium_ingot = register("pherithium_ingot", new ItemNovaCraft(NovaCraftCreativeTabs.items).setTextureName(NovaCraft.find("pherithium_ingot")));
		vanite_chunk = register("vanite_chunk", new ItemFireproof().setTextureName(NovaCraft.find("vanite_chunk")));
		vanite_ingot = register("vanite_ingot", new ItemFireproof().setTextureName(NovaCraft.find("vanite_ingot")));		
		tophinite_gemstone = register("tophinite_gemstone", new ItemNovaCraft(NovaCraftCreativeTabs.items).setTextureName(NovaCraft.find("tophinite_gemstone")));		
		reinforced_vanite_ingot = register("reinforced_vanite_ingot", new ItemFireproof().setTextureName(NovaCraft.find("reinforced_vanite_ingot")));
		small_xancium_dust = register("small_xancium_dust", new ItemVoidExplosive().setTextureName(NovaCraft.find("small_xancium_dust")));
		xancium_dust = register("xancium_dust", new ItemXanciumDust().setTextureName(NovaCraft.find("xancium_dust_item")));
		xancium_ingot = register("xancium_ingot", new ItemVoidExplosive().setTextureName(NovaCraft.find("xancium_ingot")));
		xancium_pellet = register("xancium_pellet", new ItemVoidExplosive().setTextureName(NovaCraft.find("xancium_pellet")));
		xancium_firecharge = register("xancium_firecharge", new ItemNovaCraft(NovaCraftCreativeTabs.items).setTextureName(NovaCraft.find("xancium_firecharge")));
		nullifier_core = register("nullifier_core", new ItemNovaCraft(NovaCraftCreativeTabs.items).setTextureName(NovaCraft.find("nullifier_core")));
		raw_klangite = register("raw_klangite", new ItemNovaCraft(NovaCraftCreativeTabs.items).setTextureName(NovaCraft.find("raw_klangite")));		
		klangite_blend = register("klangite_blend", new ItemNovaCraft(NovaCraftCreativeTabs.items).setTextureName(NovaCraft.find("klangite_blend")));
		impure_klangite_ingot = register("impure_klangite_ingot", new ItemNovaCraft(NovaCraftCreativeTabs.items).setTextureName(NovaCraft.find("impure_klangite_ingot")));
		explosive_klangite_ingot = register("explosive_klangite_ingot", new ItemExplosiveKlagniteIngot().setTextureName(NovaCraft.find("explosive_klangite_ingot")));		
		klangite_ingot = register("klangite_ingot", new ItemKlagniteIngot().setTextureName(NovaCraft.find("klangite_ingot")));
		heart_of_the_end = register("heart_of_the_end", new ItemHeartOfTheEnd(NovaCraftCreativeTabs.items).setTextureName(NovaCraft.find("heart_of_the_end")));
		nullified_dust = register("nullified_dust", new ItemNullifiedDust().setTextureName(NovaCraft.find("nullified_dust")));
		fractured_heart_of_the_end = register("fractured_heart_of_the_end", new ItemNovaCraft(NovaCraftCreativeTabs.items).setTextureName(NovaCraft.find("fractured_heart_of_the_end")));
		null_cube_slime = register("null_cube_slime", new ItemNovaCraft(NovaCraftCreativeTabs.items).setTextureName(NovaCraft.find("null_cube_slime")));		
		superheated_magma_cream = register("superheated_magma_cream", new ItemFireproof().setTextureName(NovaCraft.find("superheated_magma_cream")));
		enflamed_null_cube_slimeball = register("enflamed_null_cube_slimeball", new ItemFireproof().setTextureName(NovaCraft.find("enflamed_null_cube_slimeball")));		
		enhanced_enflamed_null_cube_slimeball = register("enhanced_enflamed_null_cube_slimeball", new ItemFireproof().setTextureName(NovaCraft.find("enhanced_enflamed_null_cube_slimeball")));		
		sculk_dweller_heart = register("sculk_dweller_heart", new ItemNovaCraft(NovaCraftCreativeTabs.items).setTextureName(NovaCraft.find("sculk_dweller_heart")));
		warden_heart = register("warden_heart", new ItemWardenHeart().setTextureName(NovaCraft.find("warden_heart")));
		warden_tentacle = register("warden_tentacle", new ItemNovaCraft(NovaCraftCreativeTabs.items).setTextureName(NovaCraft.find("warden_tentacle")));
		warden_shard = register("warden_shard", new ItemNullifiedVaniteAlloy().setTextureName(NovaCraft.find("warden_shard")));
		sculked_leather = register("sculked_leather", new ItemNovaCraft(NovaCraftCreativeTabs.items).setTextureName(NovaCraft.find("sculked_leather")));		
		sea_serpent_scales = register("sea_serpent_scales", new ItemNovaCraft(NovaCraftCreativeTabs.items).setTextureName(NovaCraft.find("sea_serpent_scales")));
		sea_serpent_venom_sac = register("sea_serpent_venom_sac", new ItemNovaCraft(NovaCraftCreativeTabs.items).setTextureName(NovaCraft.find("sea_serpent_venom_sac")));		
		cave_monitor_scales = register("cave_monitor_scales", new ItemNovaCraft(NovaCraftCreativeTabs.items).setTextureName(NovaCraft.find("cave_monitor_scales")));
		cave_monitor_tongue = register("cave_monitor_tongue", new ItemNovaCraft(NovaCraftCreativeTabs.items).setTextureName(NovaCraft.find("cave_monitor_tongue")));		
		sculked_monitor_scales = register("sculked_monitor_scales", new ItemNovaCraft(NovaCraftCreativeTabs.items).setTextureName(NovaCraft.find("sculked_monitor_scales")));
		sculked_monitor_eye = register("sculked_monitor_eye", new ItemNovaCraft(NovaCraftCreativeTabs.items).setTextureName(NovaCraft.find("sculked_monitor_eye")));	
		flaming_pitcher_petal = register("flaming_pitcher_petal", new ItemFireproof().setTextureName(NovaCraft.find("flaming_pitcher_petal")));
		blazing_coal = register("blazing_coal", new ItemFireproof().setTextureName(NovaCraft.find("blazing_coal")));
		blazing_serpent_scales = register("blazing_serpent_scales", new ItemFireproof().setTextureName(NovaCraft.find("blazing_serpent_scales")));
		blazing_serpent_tooth = register("blazing_serpent_tooth", new ItemFireproof().setTextureName(NovaCraft.find("blazing_serpent_tooth")));
		phoenix_feather = register("phoenix_feather", new ItemFireproof().setTextureName(NovaCraft.find("phoenix_feather")));
		ionizatior_rod = register("ionizatior_rod", new ItemFireproof().setTextureName(NovaCraft.find("ionizatior_rod")));
		ionizatior_powder = register("ionizatior_powder", new ItemFireproof().setTextureName(NovaCraft.find("ionizatior_powder")));
		deepoid_scales = register("deepoid_scales", new ItemFireproof().setTextureName(NovaCraft.find("deepoid_scales")));
		deepoid_horn = register("deepoid_horn", new ItemFireproof().setTextureName(NovaCraft.find("deepoid_horn")));
		deep_one_scales = register("deep_one_scales", new ItemFireproof().setTextureName(NovaCraft.find("deep_one_scales")));
		deep_one_bone = register("deep_one_bone", new ItemFireproof().setTextureName(NovaCraft.find("deep_one_bone")));
		ophidian_scales = register("ophidian_scales", new ItemFireproof().setTextureName(NovaCraft.find("ophidian_scales")));
		destitute_tentacle = register("destitute_tentacle", new ItemNovaCraft(NovaCraftCreativeTabs.items).setTextureName(NovaCraft.find("destitute_tentacle")));
		static_essence = register("static_essence", new ItemNovaCraft(NovaCraftCreativeTabs.items).setTextureName(NovaCraft.find("static_essence")));		
		wardling_dust = register("wardling_dust", new ItemNullifiedDust().setTextureName(NovaCraft.find("wardling_dust")));
		ancient_city_artifact = register("ancient_city_artifact", new ItemNovaCraft(NovaCraftCreativeTabs.items).setMaxStackSize(1).setTextureName(NovaCraft.find("ancient_city_artifact")));
		powered_ancient_city_artifact = register("powered_ancient_city_artifact", new ItemPoweredAncientCityArtifact().setTextureName(NovaCraft.find("powered_ancient_city_artifact")));
		
		vanite_bucket = register("vanite_bucket", new ItemVaniteBucket(Blocks.air).setMaxStackSize(16).setTextureName(NovaCraft.find("vanite_bucket")));
		vanite_bucket_water = register("vanite_bucket_water", new ItemVaniteBucket(Blocks.flowing_water).setTextureName(NovaCraft.find("vanite_bucket_water")));
		vanite_bucket_lava = register("vanite_bucket_lava", new ItemVaniteBucket(Blocks.flowing_lava).setTextureName(NovaCraft.find("vanite_bucket_lava")));
		vanite_bucket_blazlinite = register("vanite_bucket_blazlinite", new ItemBlazliniteBucket(NovaCraftBlocks.blazlinite).setTextureName(NovaCraft.find("vanite_bucket_blazlinite")));
		vanite_bucket_molten_vanite = register("vanite_bucket_molten_vanite", new ItemMoltenVaniteBucket(NovaCraftBlocks.molten_vanite).setTextureName(NovaCraft.find("vanite_bucket_molten_vanite")));
		
		vanite_crystal = register("vanite_crystal", new ItemNovaCraft(NovaCraftCreativeTabs.potions).setTextureName(NovaCraft.find("vanite_crystal")));
		crystallized_vanite_alloy = register("crystallized_vanite_alloy", new ItemNovaCraft(NovaCraftCreativeTabs.items).setTextureName(NovaCraft.find("crystallized_vanite_alloy")));
		nullified_vanite_alloy = register("nullified_vanite_alloy", new ItemNullifiedVaniteAlloy().setTextureName(NovaCraft.find("nullified_vanite_alloy")));
		vanite_cauldron_item = register("vanite_cauldron_item", new ItemVaniteCauldron().setTextureName(NovaCraft.find("vanite_cauldron")));
		nullwart_blend = register("nullwart_blend", new ItemNovaCraft(NovaCraftCreativeTabs.potions).setTextureName(NovaCraft.find("nullwart_blend")));
		vanite_bottle = register("vanite_bottle", new ItemVaniteBottle().setTextureName(NovaCraft.find("vanite_bottle")));
		deepfire_blend = register("deepfire_blend", new ItemDeepfireBlend().setTextureName(NovaCraft.find("deepfire_blend")));
		
		potion_speed_extended = register("potion_speed_extended", new ItemPotionSpeedExtended().setTextureName(NovaCraft.find("potion_speed")));
		potion_speed_III = register("potion_speed_III", new ItemPotionSpeedIII().setTextureName(NovaCraft.find("potion_speed")));		
		potion_strength_extended = register("potion_strength_extended", new ItemPotionStrengthExtended().setTextureName(NovaCraft.find("potion_strength")));
		potion_strength_III = register("potion_strength_III", new ItemPotionStrengthIII().setTextureName(NovaCraft.find("potion_strength")));		
		potion_regen_extended = register("potion_regen_extended", new ItemPotionRegenExtended().setTextureName(NovaCraft.find("potion_regen")));
		potion_regen_III = register("potion_regen_III", new ItemPotionRegenIII().setTextureName(NovaCraft.find("potion_regen")));		
		potion_jump_extended = register("potion_jump_extended", new ItemPotionJumpExtended().setTextureName(NovaCraft.find("potion_jump")));
		potion_jump_III = register("potion_jump_III", new ItemPotionJumpIII().setTextureName(NovaCraft.find("potion_jump")));		
		potion_water_breathing_extended = register("potion_water_breathing_extended", new ItemPotionWaterBreathingExtended().setTextureName(NovaCraft.find("potion_water_breathing")));
		potion_night_vision_extended = register("potion_night_vision_extended", new ItemPotionNightVisionExtended().setTextureName(NovaCraft.find("potion_night_vision")));
		potion_invisibility_extended = register("potion_invisibility_extended", new ItemPotionInvisibilityExtended().setTextureName(NovaCraft.find("potion_invisibility")));
		potion_fire_resistance_extended = register("potion_fire_resistance_extended", new ItemPotionFireResistanceExtended().setTextureName(NovaCraft.find("potion_fire_resistance")));		
		potion_haste = register("potion_haste", new ItemPotionHaste().setTextureName(NovaCraft.find("potion_haste")));
		potion_haste_II = register("potion_haste_II", new ItemPotionHasteII().setTextureName(NovaCraft.find("potion_haste")));
		potion_resistance = register("potion_resistance", new ItemPotionResistance().setTextureName(NovaCraft.find("potion_resistance")));
		
		dark_essence = register("dark_essence", new ItemDarkEssence().setTextureName(NovaCraft.find("dark_essence")));
		eternal_caller = register("eternal_caller", new ItemEternalCaller().setTextureName(NovaCraft.find("eternal_caller")));
		deepoid_star = register("deepoid_star", new ItemDeepoidStar().setTextureName(NovaCraft.find("deepoid_star")));
		sculk_star = register("sculk_star", new ItemSculkStar().setTextureName(NovaCraft.find("NewSculkStar")));
		warden_core = register("warden_core", new ItemWardenCore().setTextureName(NovaCraft.find("warden_core")));
		anomalous_essence = register("anomalous_essence", new ItemDarkEssence().setTextureName(NovaCraft.find("anomalous_essence")));
		corrupted_essence = register("corrupted_essence", new ItemDarkEssence().setTextureName(NovaCraft.find("corrupted_essence")));
		
		glow_ink_sac = register("glow_ink_sac", new ItemNovaCraft(NovaCraftCreativeTabs.items).setTextureName(NovaCraft.find("glow_ink_sac")));
		pherithium_carrot = register("pherithium_carrot", new ItemPherithiumCarrot().setTextureName(NovaCraft.find("pherithium_carrot")));
		raw_glow_squid = register("raw_glow_squid", new ItemRawGlowSquid().setTextureName(NovaCraft.find("raw_glowsquid")));
		cooked_glow_squid = register("cooked_glow_squid", new ItemCookedGlowSquid().setTextureName(NovaCraft.find("cooked_glowsquid")));		
		raw_chevon = register("raw_chevon", new ItemRawChevon().setTextureName(NovaCraft.find("raw_chevon")));
		cooked_chevon = register("cooked_chevon", new ItemCookedChevon().setTextureName(NovaCraft.find("cooked_chevon")));
		
		phantom_membrane = register("phantom_membrane", new ItemNovaCraft(NovaCraftCreativeTabs.items).setTextureName(NovaCraft.find("phantom_membrane")));
		nullwart = register("nullwart", new ItemNullWart().setTextureName(NovaCraft.find("nullwart")));
		disc_fragment_5 = register("disc_fragment_5", new ItemNovaCraft(NovaCraftCreativeTabs.items).setTextureName(NovaCraft.find("disc_fragment_5")));
		
		disc_5 = register("disc_5", new ItemDisk5("5").setTextureName(NovaCraft.find("music_disc_5")));		
		disc_negative1 = register("disc_negative1", new ItemDiskNegative1("-1").setTextureName(NovaCraft.find("music_disc_negative1")));
		disc_negative2 = register("disc_negative2", new ItemDiskNegative2("-2").setTextureName(NovaCraft.find("music_disc_negative2")));
		
		luminant_apple = register("luminant_apple", new ItemLuminantApple().setTextureName(NovaCraft.find("luminant_apple")));
		luminant_tree_sap = register("luminant_tree_sap", new ItemNovaCraft(NovaCraftCreativeTabs.items).setTextureName(NovaCraft.find("luminant_tree_sap")));
		luminant_gel = register("luminant_gel", new ItemNovaCraft(NovaCraftCreativeTabs.items).setTextureName(NovaCraft.find("luminant_gel")));
		luminant_ingot = register("luminant_ingot", new ItemNovaCraft(NovaCraftCreativeTabs.items).setTextureName(NovaCraft.find("luminant_ingot")));
		
		enderavis_feather = register("enderavis_feather", new ItemNovaCraft(NovaCraftCreativeTabs.items).setTextureName(NovaCraft.find("avis_feather")));
		raw_enderavis = register("raw_enderavis", new ItemRawEnderAvis().setTextureName(NovaCraft.find("raw_enderavis")));
		cooked_enderavis = register("cooked_enderavis", new ItemCookedEnderAvis().setTextureName(NovaCraft.find("cooked_enderavis")));
		
		raw_blazing_charger = register("raw_blazing_charger", new ItemRawBlazingCharger().setTextureName(NovaCraft.find("raw_blazing_charger")));
		cooked_blazing_charger = register("cooked_blazing_charger", new ItemCookedBlazingCharger().setTextureName(NovaCraft.find("cooked_blazing_charger")));
		
		pherithium_sword = register("pherithium_sword", new ItemPherithiumSword().setTextureName(NovaCraft.find("pherithium_sword")));
		pherithium_pickaxe = register("pherithium_pickaxe", new ItemPherithiumPickaxe().setTextureName(NovaCraft.find("pherithium_pickaxe")));
		pherithium_axe = register("pherithium_axe", new ItemPherithiumAxe().setTextureName(NovaCraft.find("pherithium_axe")));
		pherithium_shovel = register("pherithium_shovel", new ItemPherithiumShovel().setTextureName(NovaCraft.find("pherithium_shovel")));
		pherithium_hoe = register("pherithium_hoe", new ItemPherithiumHoe().setTextureName(NovaCraft.find("pherithium_hoe")));
		pherithium_shickaxe = register("pherithium_shickaxe", new ItemPherithiumShickaxe().setTextureName(NovaCraft.find("pherithium_shickaxe")));
		reinforced_pherithium_shickaxe = register("reinforced_pherithium_shickaxe", new ItemReinforcedPherithiumShickaxe().setTextureName(NovaCraft.find("reinforced_pherithium_shickaxe")));
		
		pherithium_helmet = register("pherithium_helmet", new ItemPherithiumHelmet().setTextureName(NovaCraft.find("pherithium_helmet")));
		pherithium_chestplate = register("pherithium_chestplate", new ItemPherithiumChestplate().setTextureName(NovaCraft.find("pherithium_chestplate")));
		pherithium_leggings = register("pherithium_leggings", new ItemPherithiumLeggings().setTextureName(NovaCraft.find("pherithium_leggings")));
		pherithium_boots = register("pherithium_boots", new ItemPherithiumBoots().setTextureName(NovaCraft.find("pherithium_boots")));
		
		diamond_bow = register("diamond_bow", new ItemDiamondBow());
		diamond_firecharge_launcher = register("diamond_firecharge_launcher", new ItemDiamondFirechargeLauncher());
		
		vanite_firecharge_launcher = register("vanite_firecharge_launcher", new ItemVaniteFirechargeLauncher());
		
		if (Loader.isModLoaded("etfuturum")) {
		netherite_bow = register("netherite_bow", new ItemNetheriteBow());
		}
		
		tophinite_sword = register("tophinite_sword", new ItemTophiniteSword().setTextureName(NovaCraft.find("tophinite_sword")));
		tophinite_bow = register("tophinite_bow", new ItemTophiniteBow());
		tophinite_pickaxe = register("tophinite_pickaxe", new ItemTophinitePickaxe().setTextureName(NovaCraft.find("tophinite_pickaxe")));
		tophinite_axe = register("tophinite_axe", new ItemTophiniteAxe().setTextureName(NovaCraft.find("tophinite_axe")));
		tophinite_shovel = register("tophinite_shovel", new ItemTophiniteShovel().setTextureName(NovaCraft.find("tophinite_shovel")));
		tophinite_hoe = register("tophinite_hoe", new ItemTophiniteHoe().setTextureName(NovaCraft.find("tophinite_hoe")));
		tophinite_hammer = register("tophinite_hammer", new ItemTophiniteHammer().setTextureName(NovaCraft.find("tophinite_hammer")));
		
		tophinite_helmet = register("tophinite_helmet", new ItemTophiniteHelmet().setTextureName(NovaCraft.find("tophinite_helmet")));
		tophinite_chestplate = register("tophinite_chestplate", new ItemTophiniteChestplate().setTextureName(NovaCraft.find("tophinite_chestplate")));
		tophinite_leggings = register("tophinite_leggings", new ItemTophiniteLeggings().setTextureName(NovaCraft.find("tophinite_leggings")));
		tophinite_boots = register("tophinite_boots", new ItemTophiniteBoots().setTextureName(NovaCraft.find("tophinite_boots")));
		
		crystallized_vanite_sword = register("crystallized_vanite_sword", new ItemCrystallizedVaniteSword().setTextureName(NovaCraft.find("crystallized_vanite_sword")));
		crystallized_vanite_bow = register("crystallized_vanite_bow", new ItemCrystallizedVaniteBow());
		crystallized_vanite_pickaxe = register("crystallized_vanite_pickaxe", new ItemCrystallizedVanitePickaxe().setTextureName(NovaCraft.find("crystallized_vanite_pickaxe")));
		crystallized_vanite_axe = register("crystallized_vanite_axe", new ItemCrystallizedVaniteAxe().setTextureName(NovaCraft.find("crystallized_vanite_axe")));
		crystallized_vanite_shovel = register("crystallized_vanite_shovel", new ItemCrystallizedVaniteShovel().setTextureName(NovaCraft.find("crystallized_vanite_shovel")));
		crystallized_vanite_hoe = register("crystallized_vanite_hoe", new ItemCrystallizedVaniteHoe().setTextureName(NovaCraft.find("crystallized_vanite_hoe")));
		
		crystallized_vanite_helmet = register("crystallized_vanite_helmet", new ItemVaniteArmor(0, ArmorMaterial.DIAMOND, "crystallized_vanite", null).setMaxDamage(2257).setTextureName(NovaCraft.find("crystallized_vanite_helmet")));
		crystallized_vanite_chestplate = register("crystallized_vanite_chestplate", new ItemVaniteArmor(1, ArmorMaterial.DIAMOND, "crystallized_vanite", null).setMaxDamage(2313).setTextureName(NovaCraft.find("crystallized_vanite_chestplate")));
		crystallized_vanite_leggings = register("crystallized_vanite_leggings", new ItemVaniteArmor(2, ArmorMaterial.DIAMOND, "crystallized_vanite", null).setMaxDamage(2300).setTextureName(NovaCraft.find("crystallized_vanite_leggings")));
		crystallized_vanite_boots = register("crystallized_vanite_boots", new ItemVaniteArmor(3, ArmorMaterial.DIAMOND, "crystallized_vanite", null).setMaxDamage(2277).setTextureName(NovaCraft.find("crystallized_vanite_boots")));
		
		ophidian_sword = register("ophidian_sword", new ItemOphidianSword().setTextureName(NovaCraft.find("ophidian_sword")));
		ophidian_bow = register("ophidian_bow", new ItemOphidianBow());
		ophidian_pickaxe = register("ophidian_pickaxe", new ItemOphidianPickaxe().setTextureName(NovaCraft.find("ophidian_pickaxe")));
		ophidian_axe = register("ophidian_axe", new ItemOphidianAxe().setTextureName(NovaCraft.find("ophidian_axe")));
		ophidian_shovel = register("ophidian_shovel", new ItemOphidianShovel().setTextureName(NovaCraft.find("ophidian_shovel")));
		ophidian_hoe = register("ophidian_hoe", new ItemOphidianHoe().setTextureName(NovaCraft.find("ophidian_hoe")));
		
		ophidian_helmet = register("ophidian_helmet", new ItemOphidianArmor(0, ArmorMaterial.DIAMOND, "ophidian", null).setMaxDamage(7747).setTextureName(NovaCraft.find("ophidian_helmet")));
		ophidian_chestplate = register("ophidian_chestplate", new ItemOphidianArmor(1, ArmorMaterial.DIAMOND, "ophidian", null).setMaxDamage(8089).setTextureName(NovaCraft.find("ophidian_chestplate")));
		ophidian_leggings = register("ophidian_leggings", new ItemOphidianArmor(2, ArmorMaterial.DIAMOND, "ophidian", null).setMaxDamage(8014).setTextureName(NovaCraft.find("ophidian_leggings")));
		ophidian_boots = register("ophidian_boots", new ItemOphidianArmor(3, ArmorMaterial.DIAMOND, "ophidian", null).setMaxDamage(7878).setTextureName(NovaCraft.find("ophidian_boots")));	
		
		klangite_sword = register("klangite_sword", new ItemKlangiteSword().setTextureName(NovaCraft.find("klangite_sword")));
		klangite_bow = register("klangite_bow", new ItemKlangiteBow());
		klangite_firecharge_launcher = register("klangite_firecharge_launcher", new ItemKlangiteFirechargeLauncher());
		klangite_pickaxe = register("klangite_pickaxe", new ItemKlangitePickaxe().setTextureName(NovaCraft.find("klangite_pickaxe")));
		klangite_axe = register("klangite_axe", new ItemKlangiteAxe().setTextureName(NovaCraft.find("klangite_axe")));
		klangite_shovel = register("klangite_shovel", new ItemKlangiteShovel().setTextureName(NovaCraft.find("klangite_shovel")));
		klangite_hoe = register("klangite_hoe", new ItemKlangiteHoe().setTextureName(NovaCraft.find("klangite_hoe")));
		
		klangite_helmet = register("klangite_helmet", new ItemKlangiteHelmet().setTextureName(NovaCraft.find("klangite_helmet")));
		klangite_chestplate = register("klangite_chestplate", new ItemKlangiteChestplate().setTextureName(NovaCraft.find("klangite_chestplate")));
		klangite_leggings = register("klangite_leggings", new ItemKlangiteLeggings().setTextureName(NovaCraft.find("klangite_leggings")));
		klangite_boots = register("klangite_boots", new ItemKlangiteBoots().setTextureName(NovaCraft.find("klangite_boots")));
				
		kylazite_sword = register("kylazite_sword", new ItemKylaziteSword().setTextureName(NovaCraft.find("kylazite_sword")));
		kylazite_bow = register("kylazite_bow", new ItemKylaziteBow());
		kylazite_pickaxe = register("kylazite_pickaxe", new ItemKylazitePickaxe().setTextureName(NovaCraft.find("kylazite_pickaxe")));
		kylazite_axe = register("kylazite_axe", new ItemKylaziteAxe().setTextureName(NovaCraft.find("kylazite_axe")));
		kylazite_shovel = register("kylazite_shovel", new ItemKylaziteShovel().setTextureName(NovaCraft.find("kylazite_shovel")));
		kylazite_hoe = register("kylazite_hoe", new ItemKylaziteHoe().setTextureName(NovaCraft.find("kylazite_hoe")));
		
		kylazite_helmet = register("kylazite_helmet", new ItemKylaziteArmor(0, ArmorMaterial.DIAMOND, "kylazite", null).setMaxDamage(8747).setTextureName(NovaCraft.find("kylazite_helmet")));
		kylazite_chestplate = register("kylazite_chestplate", new ItemKylaziteArmor(1, ArmorMaterial.DIAMOND, "kylazite", null).setMaxDamage(9089).setTextureName(NovaCraft.find("kylazite_chestplate")));
		kylazite_leggings = register("kylazite_leggings", new ItemKylaziteArmor(2, ArmorMaterial.DIAMOND, "kylazite", null).setMaxDamage(9014).setTextureName(NovaCraft.find("kylazite_leggings")));
		kylazite_boots = register("kylazite_boots", new ItemKylaziteArmor(3, ArmorMaterial.DIAMOND, "kylazite", null).setMaxDamage(8878).setTextureName(NovaCraft.find("kylazite_boots")));
					
		warden_sword = register("warden_sword", new ItemWardenSword().setTextureName(NovaCraft.find("warden_sword")));
		warden_bow = register("warden_bow", new ItemWardenBow());
		warden_pickaxe = register("warden_pickaxe", new ItemWardenPickaxe().setTextureName(NovaCraft.find("warden_pickaxe")));
		warden_axe = register("warden_axe", new ItemWardenAxe().setTextureName(NovaCraft.find("warden_axe")));
		warden_shovel = register("warden_shovel", new ItemWardenShovel().setTextureName(NovaCraft.find("warden_shovel")));
		warden_hoe = register("warden_hoe", new ItemWardenHoe().setTextureName(NovaCraft.find("warden_hoe")));
		
		warden_helmet = register("warden_helmet", new ItemWardenArmor(0, ArmorMaterial.DIAMOND, "warden", null).setMaxDamage(12747).setTextureName(NovaCraft.find("warden_helmet")));
		warden_chestplate = register("warden_chestplate", new ItemWardenArmor(1, ArmorMaterial.DIAMOND, "warden", null).setMaxDamage(13089).setTextureName(NovaCraft.find("warden_chestplate")));
		warden_leggings = register("warden_leggings", new ItemWardenArmor(2, ArmorMaterial.DIAMOND, "warden", null).setMaxDamage(13014).setTextureName(NovaCraft.find("warden_leggings")));
		warden_boots = register("warden_boots", new ItemWardenArmor(3, ArmorMaterial.DIAMOND, "warden", null).setMaxDamage(12878).setTextureName(NovaCraft.find("warden_boots")));
		
		crystalite_sword = register("crystalite_sword", new ItemCrystaliteSword().setTextureName(NovaCraft.find("crystalite_sword")));
		crystalite_bow = register("crystalite_bow", new ItemCrystaliteBow());
		crystalite_pickaxe = register("crystalite_pickaxe", new ItemCrystalitePickaxe().setTextureName(NovaCraft.find("crystalite_pickaxe")));
		
		crystalite_helmet = register("crystalite_helmet", new ItemCrystaliteArmor(0, ArmorMaterial.DIAMOND, "crystalite", null).setMaxDamage(15257).setTextureName(NovaCraft.find("crystalite_helmet")));
		crystalite_chestplate = register("crystalite_chestplate", new ItemCrystaliteArmor(1, ArmorMaterial.DIAMOND, "crystalite", null).setMaxDamage(15313).setTextureName(NovaCraft.find("crystalite_chestplate")));
		crystalite_leggings = register("crystalite_leggings", new ItemCrystaliteArmor(2, ArmorMaterial.DIAMOND, "crystalite", null).setMaxDamage(15300).setTextureName(NovaCraft.find("crystalite_leggings")));
		crystalite_boots = register("crystalite_boots", new ItemCrystaliteArmor(3, ArmorMaterial.DIAMOND, "crystalite", null).setMaxDamage(15277).setTextureName(NovaCraft.find("crystalite_boots")));
		
		vanite_trident = register("vanite_trident", new ItemVaniteTrident(NCToolMaterial.VANITE_TRIDENT).setTextureName(NovaCraft.find("vanite_trident")));
		eerie_sword = register("eerie_sword", new ItemEerieSword().setTextureName(NovaCraft.find("eerie_sword")));
		sculked_blade = register("sculked_blade", new ItemSculkedBlade().setTextureName(NovaCraft.find("sculked_blade")));		
		primeval_mace = register("primeval_mace", new ItemPrimevalMace().setTextureName(NovaCraft.find("primeval_mace")));		
		scythe = register("scythe", new ItemScythe().setTextureName(NovaCraft.find("scythe")));
		diablo = register("diablo", new ItemDiablo().setTextureName(NovaCraft.find("diablo")));
		phoenix_razor = register("phoenix_razor", new ItemPhoenixRazor().setTextureName(NovaCraft.find("phoenix_razor")));
		primeval_horn = register("primeval_horn", new ItemPrimevalHorn().setTextureName(NovaCraft.find("primeval_horn")));
		sculk_horn = register("sculk_horn", new ItemSculkHorn().setTextureName(NovaCraft.find("sculk_horn")));
		
		goat_horn_ponder = register("goat_horn_ponder", new ItemGoatHorn());
		goat_horn_sing = register("goat_horn_sing", new ItemGoatHornSing());
		goat_horn_seek = register("goat_horn_seek", new ItemGoatHornSeek());
		goat_horn_feel = register("goat_horn_feel", new ItemGoatHornFeel());
		goat_horn_admire = register("goat_horn_admire", new ItemGoatHornAdmire());
		goat_horn_call = register("goat_horn_call", new ItemGoatHornCall());
		goat_horn_yearn = register("goat_horn_yearn", new ItemGoatHornYearn());
		goat_horn_dream = register("goat_horn_dream", new ItemGoatHornDream());
		
		ice_sceptor = register("ice_sceptor", new ItemIceSceptor().setTextureName(NovaCraft.find("ice_sceptor")));
		ender_lord_staff = register("ender_lord_staff", new ItemEnderLordStaff().setTextureName(NovaCraft.find("ender_lord_staff")));
		crystal_growth_staff = register("crystal_growth_staff", new ItemCrystalGrowthStaff().setTextureName(NovaCraft.find("crystal_growth_staff")));
		
		vanite_blue_crown = register("vanite_blue_crown", new ItemVaniteBlueCrown(0, ArmorMaterial.DIAMOND, "vanite_blue", null).setMaxDamage(757).setTextureName(NovaCraft.find("vanite_blue_crown")));
		vanite_red_crown = register("vanite_red_crown", new ItemVaniteRedCrown(0, ArmorMaterial.DIAMOND, "vanite_red", null).setMaxDamage(757).setTextureName(NovaCraft.find("vanite_red_crown")));
		vanite_green_crown = register("vanite_green_crown", new ItemVaniteGreenCrown(0, ArmorMaterial.DIAMOND, "vanite_green", null).setMaxDamage(757).setTextureName(NovaCraft.find("vanite_green_crown")));
		vanite_orange_crown = register("vanite_orange_crown", new ItemVaniteOrangeCrown(0, ArmorMaterial.DIAMOND, "vanite_orange", null).setMaxDamage(757).setTextureName(NovaCraft.find("vanite_orange_crown")));
		vanite_dark_blue_crown = register("vanite_dark_blue_crown", new ItemVaniteDarkBlueCrown(0, ArmorMaterial.DIAMOND, "vanite_dark_blue", null).setMaxDamage(557).setTextureName(NovaCraft.find("vanite_dark_blue_crown")));
		vanite_notched_crown = register("vanite_notched_crown", new ItemVaniteNotchedCrown(0, ArmorMaterial.DIAMOND, "vanite_notched", null).setMaxDamage(857).setTextureName(NovaCraft.find("vanite_notched_crown")));
		vanite_exotic_crown = register("vanite_exotic_crown", new ItemVaniteExoticCrown(0, ArmorMaterial.DIAMOND, "vanite_exotic", null).setMaxDamage(1007).setTextureName(NovaCraft.find("vanite_exotic_crown")));
		vanite_mysterious_crown = register("vanite_mysterious_crown", new ItemVaniteMysteriousCrown(0, ArmorMaterial.DIAMOND, "vanite_mysterious", null).setMaxDamage(1407).setTextureName(NovaCraft.find("vanite_mysterious_crown")));
		
		sculk_helmet = register("sculk_helmet", new ItemSculkHelmet().setTextureName(NovaCraft.find("sculk_helmet")));
		sculk_chestplate = register("sculk_chestplate", new ItemSculkChestplate().setTextureName(NovaCraft.find("sculk_chestplate")));
		sculk_leggings = register("sculk_leggings", new ItemSculkLeggings().setTextureName(NovaCraft.find("sculk_leggings")));
		sculk_boots = register("sculk_boots", new ItemSculkBoots().setTextureName(NovaCraft.find("sculk_boots")));
		
		phantom_helmet = register("phantom_helmet", new ItemPhantomHelmet().setTextureName(NovaCraft.find("phantom_helmet")));
		phantom_chestplate = register("phantom_chestplate", new ItemPhantomChestplate().setTextureName(NovaCraft.find("phantom_chestplate")));
		phantom_leggings = register("phantom_leggings", new ItemPhantomLeggings().setTextureName(NovaCraft.find("phantom_leggings")));
		phantom_boots = register("phantom_boots", new ItemPhantomBoots().setTextureName(NovaCraft.find("phantom_boots")));
		
		guardian_helmet = register("guardian_helmet", new ItemGuardianArmor(0, ArmorMaterial.DIAMOND, "guardian", null).setMaxDamage(20257).setTextureName(NovaCraft.find("guardianhelmet")));
		guardian_chestplate = register("guardian_chestplate", new ItemGuardianArmor(1, ArmorMaterial.DIAMOND, "guardian", null).setMaxDamage(20313).setTextureName(NovaCraft.find("guardianchestplate")));
		guardian_leggings = register("guardian_leggings", new ItemGuardianArmor(2, ArmorMaterial.DIAMOND, "guardian", null).setMaxDamage(20300).setTextureName(NovaCraft.find("guardianlegginings")));
		guardian_boots = register("guardian_boots", new ItemGuardianArmor(3, ArmorMaterial.DIAMOND, "guardian", null).setMaxDamage(20277).setTextureName(NovaCraft.find("guardianboots")));
		
		sculk_flesh = register("sculk_flesh", new ItemSculkFlesh().setTextureName(NovaCraft.find("sculk_flesh")));
		
		novacraft_spawn_egg = register("novacraft_spawn_egg", new ItemNovaCraftSpawnEgg().setTextureName("spawn_egg"));
			
	}
	
	public static Item register(String name, Item item) {
		item.setUnlocalizedName(name);
		GameRegistry.registerItem(item, name, NovaCraft.MOD_ID);

		return item;
	}

}
