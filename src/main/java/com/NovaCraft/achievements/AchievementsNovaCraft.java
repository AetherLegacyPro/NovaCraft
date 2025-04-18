package com.NovaCraft.achievements;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraftBlocks.NovaCraftBlocks;

import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.init.Blocks;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

public class AchievementsNovaCraft {
	
	public static Achievement welcome_to_novacraft, the_strange_ore, time_to_excavate, even_better_than_iron, even_better_than_netherite, the_pink_ore, legendary_ore, 
							  geo_discovery, the_red_geo, the_blue_geo, the_orange_geo, the_green_geo, the_heavenly_geo, the_strange_plant, tnt_overhaul, the_nonburning_plant,
							  hardcore_miner, efficiency_VI, budding_block, fancy_particles, showing_off, the_glowing_tree, the_lava_plant, getting_reinforced, what_are_ya_buyin,
							  the_deep_dark, sneak_100, not_your_ordinary_geo, kill_sculk_abomination, kill_sculk_dweller, cursed_crystal, true_netherite_upgrade, cover_me_with_klangite,
							  end_traveller, echo, end_remnants, warped, netherite_upgrade, explosion, all_geos_discovered, cover_me_with_tophinite, warden_preparation, hello_darkness_my_old_friend,
							  advanced_alloying, growing_cursed_crystals, speeding_the_rates, well_this_complicates_things, end_transportation, advanced_ritual_preparation, electro_nullified,
							  summoning_an_ancient_evil, reached_for_things_I_didnt_need, the_next_upgrade, warden_insurance, ascension, end_catalyst, true_teleportation,
							  
							  lost_to_the_ages, static_ignition, history_repeats_itself, unforeseen_consequences, a_new_encounter, ancient_loot, mach_2, miners_meal, 
							  
							  a_flaming_fortess, hotter_than_fire, extreme_heat, molten_vanite, anomalous_vanite, crystallized_vanite, super_buff, the_nether_dragon, crystallized, legend,
							  shearing_the_phoenix, flying_mobs_beware, fancy_efficiency_VI, summoning_the_bloat, a_new_method_of_mining, hardcore_enchanter;
	
	public static AchievementPage NCpage;

	
	public static void initialization() {
		
		welcome_to_novacraft = new NovaCraftAchievement("advancement.nova_craft.welcome_to_novacraft", "welcome_to_novacraft", 0, 1, NovaCraftItems.crystalite_sword, (Achievement) null).registerStat(); //+10
		time_to_excavate = new NovaCraftAchievement("advancement.nova_craft.time_to_excavate", "time_to_excavate", -2, 3, NovaCraftBlocks.brimstone_ore, welcome_to_novacraft).registerStat();
		
		
		the_strange_ore = new NovaCraftAchievement("advancement.nova_craft.the_strange_ore", "the_strange_ore", 2, 1, NovaCraftBlocks.large_pherithium_stalagmite, welcome_to_novacraft).registerStat();
		miners_meal = new NovaCraftAchievement("advancement.nova_craft.miners_meal", "miners_meal", 4, 1, NovaCraftItems.cave_stew, the_strange_ore).registerStat();
		efficiency_VI = new NovaCraftAchievement("advancement.nova_craft.efficiency_VI", "efficiency_VI", 4, -1, NovaCraftItems.pherithium_pickaxe, the_strange_ore).registerStat();
		hardcore_miner = new NovaCraftAchievement("advancement.nova_craft.hardcore_miner", "hardcore_miner", 4, 3, NovaCraftItems.pherithium_chestplate, the_strange_ore).registerStat();
		
		a_flaming_fortess = new NovaCraftAchievement("advancement.nova_craft.a_flaming_fortess", "a_flaming_fortess", -2, 12, NovaCraftItems.ionizatior_rod, welcome_to_novacraft).registerStat();
		hotter_than_fire = new NovaCraftAchievement("advancement.nova_craft.hotter_than_fire", "hotter_than_fire", -4, 12, NovaCraftItems.deepfire_blend, a_flaming_fortess).registerStat();
		extreme_heat = new NovaCraftAchievement("advancement.nova_craft.extreme_heat", "extreme_heat", -6, 12, NovaCraftItems.vanite_bucket_blazlinite, hotter_than_fire).registerStat();
		molten_vanite = new NovaCraftAchievement("advancement.nova_craft.molten_vanite", "molten_vanite", -8, 12, NovaCraftItems.vanite_cauldron_item, extreme_heat).registerStat();
		anomalous_vanite = new NovaCraftAchievement("advancement.nova_craft.anomalous_vanite", "anomalous_vanite", -10, 12, NovaCraftItems.anomalous_shard, molten_vanite).registerStat();
		crystallized_vanite = new NovaCraftAchievement("advancement.nova_craft.crystallized_vanite", "crystallized_vanite", -12, 12, NovaCraftItems.vanite_crystal, anomalous_vanite).registerStat();
		super_buff = new NovaCraftAchievement("advancement.nova_craft.super_buff", "super_buff", -12, 10, NovaCraftItems.potion_haste_II, crystallized_vanite).registerStat();
		crystallized = new NovaCraftAchievement("advancement.nova_craft.crystallized", "crystallized", -10, 14, NovaCraftItems.crystallized_vanite_pickaxe, crystallized_vanite).registerStat();
		the_nether_dragon = new NovaCraftAchievement("advancement.nova_craft.the_nether_dragon", "the_nether_dragon", -12, 16, NovaCraftItems.deepoid_star, crystallized_vanite).registerStat();
		flying_mobs_beware = new NovaCraftAchievement("advancement.nova_craft.flying_mobs_beware", "flying_mobs_beware", -12, 18, NovaCraftItems.ophidian_bow, the_nether_dragon).registerStat();
		fancy_efficiency_VI = new NovaCraftAchievement("advancement.nova_craft.fancy_efficiency_VI", "fancy_efficiency_VI", -10, 16, NovaCraftItems.reinforced_pherithium_shickaxe, the_nether_dragon).registerStat();

		
		the_strange_plant = new NovaCraftAchievement("advancement.nova_craft.the_strange_plant", "the_strange_plant", 0, -1, NovaCraftItems.nullwart, welcome_to_novacraft).registerStat();
		the_nonburning_plant = new NovaCraftAchievement("advancement.nova_craft.the_nonburning_plant", "the_nonburning_plant", 0, -3, NovaCraftBlocks.torchflower, the_strange_plant).registerStat();
		tnt_overhaul = new NovaCraftAchievement("advancement.nova_craft.tnt_overhaul", "tnt_overhaul", -2, -1, NovaCraftBlocks.PETN, the_strange_plant).registerStat();
		
		the_glowing_tree = new NovaCraftAchievement("advancement.nova_craft.the_glowing_tree", "the_glowing_tree", -4, 1, NovaCraftBlocks.luminant_sapling, welcome_to_novacraft).registerStat();
		the_lava_plant = new NovaCraftAchievement("advancement.nova_craft.the_lava_plant", "the_lava_plant", -6, 1, NovaCraftBlocks.flaming_pitcher_bottom, the_glowing_tree).registerStat();
		getting_reinforced = new NovaCraftAchievement("advancement.nova_craft.getting_reinforced", "getting_reinforced", -8, 1, NovaCraftItems.reinforced_vanite_ingot, the_lava_plant).registerStat();
		
		even_better_than_iron = new NovaCraftAchievement("advancement.nova_craft.even_better_than_iron", "even_better_than_iron", 2, 7, NovaCraftBlocks.nullstone_vanite_ore, welcome_to_novacraft).registerStat();
		fancy_particles = new NovaCraftAchievement("advancement.nova_craft.fancy_particles", "fancy_particles", 4, 7, NovaCraftBlocks.block_of_vanite, even_better_than_iron).registerStat();

		even_better_than_netherite = new NovaCraftAchievement("advancement.nova_craft.even_better_than_netherite", "even_better_than_netherite", 4, 5, NovaCraftBlocks.nether_tophinite_ore, even_better_than_iron).registerStat();
		netherite_upgrade = new NovaCraftAchievement("advancement.nova_craft.netherite_upgrade", "netherite_upgrade", 6, 4, NovaCraftItems.tophinite_sword, even_better_than_netherite).registerStat();
		cover_me_with_tophinite = new NovaCraftAchievement("advancement.nova_craft.cover_me_with_tophinite", "cover_me_with_tophinite", 8, 4, NovaCraftItems.tophinite_chestplate, netherite_upgrade).registerStat();
		budding_block = new NovaCraftAchievement("advancement.nova_craft.budding_block", "budding_block", 6, 6, NovaCraftBlocks.budding_larimar_block, even_better_than_netherite).registerStat();
		
		showing_off = new NovaCraftAchievement("advancement.nova_craft.showing_off", "showing_off", 6, 5, NovaCraftItems.vanite_blue_crown, even_better_than_netherite).registerStat();
		what_are_ya_buyin = new NovaCraftAchievement("advancement.nova_craft.what_are_ya_buyin", "what_are_ya_buyin", 8, 5, NovaCraftItems.vanite_trident, showing_off).registerStat();

		end_traveller = new NovaCraftAchievement("advancement.nova_craft.end_traveller", "end_traveller", 4, 11, NovaCraftBlocks.void_sprout, even_better_than_iron).registerStat();
		echo = new NovaCraftAchievement("advancement.nova_craft.echo", "echo", 6, 11, NovaCraftItems.echo_shard, end_traveller).registerStat();
		warped = new NovaCraftAchievement("advancement.nova_craft.warped", "warped", 3, 10, NovaCraftItems.null_cube_slime, end_traveller).registerStat();
		end_remnants = new NovaCraftAchievement("advancement.nova_craft.end_remnants", "end_remnants", 9, 7, NovaCraftBlocks.crystallized_end, echo).registerStat();		
		cursed_crystal = new NovaCraftAchievement("advancement.nova_craft.cursed_crystal", "cursed_crystal", 9, 9, NovaCraftItems.null_shard, echo).registerStat();		
		hello_darkness_my_old_friend = new NovaCraftAchievement("advancement.nova_craft.hello_darkness_my_old_friend", "hello_darkness_my_old_friend", 9, 13, NovaCraftItems.dark_essence, echo).registerStat();		
		growing_cursed_crystals = new NovaCraftAchievement("advancement.nova_craft.growing_cursed_crystals", "growing_cursed_crystals", 9, 15, NovaCraftBlocks.budding_null_block, hello_darkness_my_old_friend).registerStat();		
		warden_preparation = new NovaCraftAchievement("advancement.nova_craft.warden_preparation", "warden_preparation", 9, 11, NovaCraftBlocks.infused_vanite_block, echo).registerStat();
		advanced_ritual_preparation = new NovaCraftAchievement("advancement.nova_craft.advanced_ritual_preparation", "advanced_ritual_preparation", 11, 11, NovaCraftBlocks.null_cluster_2, warden_preparation).registerStat();
		advanced_alloying = new NovaCraftAchievement("advancement.nova_craft.advanced_alloying", "advanced_alloying", 11, 13, NovaCraftItems.klangite_ingot, hello_darkness_my_old_friend).registerStat();
		end_catalyst = new NovaCraftAchievement("advancement.nova_craft.end_catalyst", "end_catalyst", 13, 13, NovaCraftItems.heart_of_the_end, advanced_alloying).registerStat();
		true_teleportation = new NovaCraftAchievement("advancement.nova_craft.true_teleportation", "true_teleportation", 15, 13, NovaCraftItems.ender_lord_staff, end_catalyst).registerStat();

		well_this_complicates_things = new NovaCraftAchievement("advancement.nova_craft.well_this_complicates_things", "well_this_complicates_things", 6, 15, NovaCraftItems.anomalous_essence, end_traveller).registerStat();
		end_transportation = new NovaCraftAchievement("advancement.nova_craft.end_transportation", "end_transportation", 6, 17, NovaCraftItems.enderavis_feather, end_traveller).registerStat();
		electro_nullified = new NovaCraftAchievement("advancement.nova_craft.electro_nullified", "electro_nullified", 6, 19, NovaCraftItems.nullifier_core, end_traveller).registerStat();
		summoning_the_bloat = new NovaCraftAchievement("advancement.nova_craft.summoning_the_bloat", "summoning_the_bloat", 8, 19, NovaCraftItems.eternal_caller, electro_nullified).registerStat();
		a_new_method_of_mining = new NovaCraftAchievement("advancement.nova_craft.a_new_method_of_mining", "a_new_method_of_mining", 10, 19, NovaCraftItems.klangite_firecharge_launcher, summoning_the_bloat).registerStat();
		
		
		the_pink_ore = new NovaCraftAchievement("advancement.nova_craft.the_pink_ore", "the_pink_ore", 4, 9, NovaCraftBlocks.xancium_ore, end_traveller).registerStat();
		explosion = new NovaCraftAchievement("advancement.nova_craft.explosion", "explosion", 5, 8, NovaCraftBlocks.xancium_TNT, the_pink_ore).registerStat();
		
		legendary_ore = new NovaCraftAchievement("advancement.nova_craft.legendary_ore", "legendary_ore", 4, 20, NovaCraftBlocks.end_klangite_ore, end_traveller).registerStat();
		true_netherite_upgrade = new NovaCraftAchievement("advancement.nova_craft.true_netherite_upgrade", "true_netherite_upgrade", 4, 22, NovaCraftItems.klangite_sword, legendary_ore).registerStat();
		cover_me_with_klangite = new NovaCraftAchievement("advancement.nova_craft.cover_me_with_klangite", "cover_me_with_klangite", 4, 24, NovaCraftItems.klangite_chestplate, true_netherite_upgrade).registerStat();
		
		geo_discovery = new NovaCraftAchievement("advancement.nova_craft.geo_discovery", "geo_discovery", -4, 7, NovaCraftBlocks.budding_copartz_block, welcome_to_novacraft).registerStat();
		the_red_geo = new NovaCraftAchievement("advancement.nova_craft.the_red_geo", "the_red_geo", -6, 7, NovaCraftBlocks.copartz_block, geo_discovery).registerStat();
		the_blue_geo = new NovaCraftAchievement("advancement.nova_craft.the_blue_geo", "the_blue_geo", -2, 9, NovaCraftBlocks.larimar_block, geo_discovery).registerStat();
		the_orange_geo = new NovaCraftAchievement("advancement.nova_craft.the_orange_geo", "the_orange_geo", -6, 9, NovaCraftBlocks.yttrlinsite_block, geo_discovery).registerStat();
		the_green_geo = new NovaCraftAchievement("advancement.nova_craft.the_green_geo", "the_green_geo", -2, 5, NovaCraftBlocks.tsavorokite_block, geo_discovery).registerStat();
		the_heavenly_geo = new NovaCraftAchievement("advancement.nova_craft.the_heavenly_geo", "the_heavenly_geo", -6, 5, NovaCraftBlocks.aether_block, geo_discovery).registerStat();
		all_geos_discovered = new NovaCraftAchievement("advancement.nova_craft.all_geos_discovered", "all_geos_discovered", -8, 7, NovaCraftBlocks.variegated_block, the_red_geo).registerStat();
		speeding_the_rates = new NovaCraftAchievement("advancement.nova_craft.speeding_the_rates", "speeding_the_rates", -10, 7, NovaCraftItems.crystal_growth_staff, all_geos_discovered).registerStat();
		
		shearing_the_phoenix = new NovaCraftAchievement("advancement.nova_craft.shearing_the_phoenix", "shearing_the_phoenix", -8, 9, NovaCraftItems.phoenix_razor, the_orange_geo).registerStat();
		
		the_deep_dark = new NovaCraftAchievement("advancement.nova_craft.the_deep_dark", "the_deep_dark", 0, 14, NovaCraftBlocks.sculk_block, welcome_to_novacraft).registerStat();
		sneak_100 = new NovaCraftAchievement("advancement.nova_craft.sneak_100", "sneak_100", 0, 18, NovaCraftItems.sculk_boots, the_deep_dark).registerStat();
		not_your_ordinary_geo = new NovaCraftAchievement("advancement.nova_craft.not_your_ordinary_geo", "not_your_ordinary_geo", 0, 20, NovaCraftBlocks.treasure_chest, sneak_100).registerStat();
		
		kill_sculk_abomination = new NovaCraftAchievement("advancement.nova_craft.kill_sculk_abomination", "kill_sculk_abomination", 2, 16, NovaCraftItems.sculked_leather, the_deep_dark).registerStat();		
		kill_sculk_dweller = new NovaCraftAchievement("advancement.nova_craft.kill_sculk_dweller", "kill_sculk_dweller", 2, 14, NovaCraftItems.sculk_dweller_heart, the_deep_dark).registerStat();
		
		lost_to_the_ages = new NovaCraftAchievement("advancement.nova_craft.lost_to_the_ages", "lost_to_the_ages", -2, 14, NovaCraftItems.ancient_city_artifact, the_deep_dark).registerStat();		
		ancient_loot = new NovaCraftAchievement("advancement.nova_craft.ancient_loot", "ancient_loot", -2, 16, NovaCraftItems.powered_ancient_city_artifact, lost_to_the_ages).registerStat();
		mach_2 = new NovaCraftAchievement("advancement.nova_craft.mach_2", "mach_2", -2, 18, NovaCraftItems.ancient_leggings, ancient_loot).registerStat();
		
		summoning_an_ancient_evil = new NovaCraftAchievement("advancement.nova_craft.summoning_an_ancient_evil", "summoning_an_ancient_evil", -4, 14, NovaCraftBlocks.grimstone_shrieker, lost_to_the_ages).registerStat();		
		reached_for_things_I_didnt_need = new NovaCraftAchievement("advancement.nova_craft.reached_for_things_I_didnt_need", "reached_for_things_I_didnt_need", -4, 16, NovaCraftItems.warden_heart, summoning_an_ancient_evil).registerStat();
		
		legend = new NovaCraftAchievement("advancement.nova_craft.legend", "legend", -6, 17, NovaCraftBlocks.legendary_beacon, reached_for_things_I_didnt_need).registerStat();	
		the_next_upgrade = new NovaCraftAchievement("advancement.nova_craft.the_next_upgrade", "the_next_upgrade", -4, 18, NovaCraftItems.warden_shard, reached_for_things_I_didnt_need).registerStat();
		warden_insurance = new NovaCraftAchievement("advancement.nova_craft.warden_insurance", "warden_insurance", -4, 20, NovaCraftItems.warden_chestplate, the_next_upgrade).registerStat();
		ascension = new NovaCraftAchievement("advancement.nova_craft.ascension", "ascension", -4, 22, NovaCraftItems.crystalite_chestplate, warden_insurance).registerStat();		
		hardcore_enchanter = new NovaCraftAchievement("advancement.nova_craft.hardcore_enchanter", "hardcore_enchanter", -6, 15, NovaCraftBlocks.legendary_enchantment_table, reached_for_things_I_didnt_need).registerStat();
		
		static_ignition = new NovaCraftAchievement("advancement.nova_craft.static_ignition", "static_ignition", -8, 16, NovaCraftItems.static_blend, reached_for_things_I_didnt_need).registerStat();
		history_repeats_itself = new NovaCraftAchievement("advancement.nova_craft.history_repeats_itself", "history_repeats_itself", -8, 18, NovaCraftItems.warden_core, static_ignition).registerStat();		
		unforeseen_consequences = new NovaCraftAchievement("advancement.nova_craft.unforeseen_consequences", "unforeseen_consequences", -8, 20, NovaCraftItems.prisoner_eye, history_repeats_itself).registerStat();
		a_new_encounter = new NovaCraftAchievement("advancement.nova_craft.a_new_encounter", "a_new_encounter", -8, 22, NovaCraftItems.outsider_essence, unforeseen_consequences).registerStat();
		
		NCpage = new AchievementPage("NovaCraft", welcome_to_novacraft, time_to_excavate, 
				the_strange_ore, even_better_than_iron, even_better_than_netherite, the_pink_ore, legendary_ore,
				geo_discovery, the_red_geo, the_blue_geo, the_orange_geo, the_green_geo, the_heavenly_geo, the_lava_plant, the_strange_plant, tnt_overhaul, the_nonburning_plant, not_your_ordinary_geo,
				hardcore_miner, budding_block, efficiency_VI, the_glowing_tree, getting_reinforced, showing_off, fancy_particles, what_are_ya_buyin, end_traveller, echo, end_remnants, 
				netherite_upgrade, cover_me_with_tophinite, warped, the_pink_ore, all_geos_discovered, cursed_crystal, true_netherite_upgrade, cover_me_with_klangite, warden_preparation, explosion,
				the_deep_dark, kill_sculk_abomination, kill_sculk_dweller, sneak_100, hello_darkness_my_old_friend, advanced_alloying, speeding_the_rates, growing_cursed_crystals,
				well_this_complicates_things, end_transportation, advanced_ritual_preparation, electro_nullified, summoning_an_ancient_evil, reached_for_things_I_didnt_need,
				the_next_upgrade, warden_insurance, end_catalyst, true_teleportation, ascension, legend, a_flaming_fortess, hotter_than_fire, extreme_heat, molten_vanite, anomalous_vanite,
				crystallized_vanite, super_buff, crystallized, the_nether_dragon, shearing_the_phoenix, flying_mobs_beware, fancy_efficiency_VI, summoning_the_bloat, a_new_method_of_mining,
				hardcore_enchanter, lost_to_the_ages, static_ignition, history_repeats_itself, unforeseen_consequences, a_new_encounter, ancient_loot, mach_2, miners_meal 
				);	
		
	AchievementPage.registerAchievementPage(NCpage);
	FMLCommonHandler.instance().bus().register((Object)new PickUpAchievement());
	}
}
