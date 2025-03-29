package com.NovaCraft.achievements;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraftBlocks.NovaCraftBlocks;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;
import net.minecraft.item.Item;

public class NovaCraftEventHandler {
	
	@SubscribeEvent
	public void onCrafting(ItemCraftedEvent event) {
		if (event.crafting.getItem() == Item.getItemFromBlock(NovaCraftBlocks.budding_aether_block)) {
			event.player.triggerAchievement(AchievementsNovaCraft.budding_block);
		}
		if (event.crafting.getItem() == Item.getItemFromBlock(NovaCraftBlocks.budding_copartz_block)) {
			event.player.triggerAchievement(AchievementsNovaCraft.budding_block);
		}
		if (event.crafting.getItem() == Item.getItemFromBlock(NovaCraftBlocks.budding_larimar_block)) {
			event.player.triggerAchievement(AchievementsNovaCraft.budding_block);
		}
		if (event.crafting.getItem() == Item.getItemFromBlock(NovaCraftBlocks.budding_tsavorokite_block)) {
			event.player.triggerAchievement(AchievementsNovaCraft.budding_block);
		}
		if (event.crafting.getItem() == Item.getItemFromBlock(NovaCraftBlocks.budding_yttrlinsite_block)) {
			event.player.triggerAchievement(AchievementsNovaCraft.budding_block);
		}
		if (event.crafting.getItem() == Item.getItemFromBlock(NovaCraftBlocks.variegated_block)) {
			event.player.triggerAchievement(AchievementsNovaCraft.all_geos_discovered);
		}
		if (event.crafting.getItem() == (NovaCraftItems.pherithium_pickaxe)) {
			event.player.triggerAchievement(AchievementsNovaCraft.efficiency_VI);
		}
		if (event.crafting.getItem() == (NovaCraftItems.pherithium_shovel)) {
			event.player.triggerAchievement(AchievementsNovaCraft.efficiency_VI);
		}	
		if (event.crafting.getItem() == (NovaCraftItems.pherithium_axe)) {
			event.player.triggerAchievement(AchievementsNovaCraft.efficiency_VI);
		}
		if (event.crafting.getItem() == (NovaCraftItems.reinforced_vanite_ingot)) {
			event.player.triggerAchievement(AchievementsNovaCraft.getting_reinforced);
		}
		if (event.crafting.getItem() == Item.getItemFromBlock(NovaCraftBlocks.block_of_vanite)) {
			event.player.triggerAchievement(AchievementsNovaCraft.fancy_particles);
		}
		if (event.crafting.getItem() == Item.getItemFromBlock(NovaCraftBlocks.PETN)) {
			event.player.triggerAchievement(AchievementsNovaCraft.tnt_overhaul);
		}
		if (event.crafting.getItem() == Item.getItemFromBlock(NovaCraftBlocks.nullcube_slime_block)) {
			event.player.triggerAchievement(AchievementsNovaCraft.warped);
		}
		if (event.crafting.getItem() == Item.getItemFromBlock(NovaCraftBlocks.xancium_TNT)) {
			event.player.triggerAchievement(AchievementsNovaCraft.explosion);
		}
		if (event.crafting.getItem() == Item.getItemFromBlock(NovaCraftBlocks.budding_null_block)) {
			event.player.triggerAchievement(AchievementsNovaCraft.growing_cursed_crystals);
		}
		if (event.crafting.getItem() == (NovaCraftItems.tophinite_sword)) {
			event.player.triggerAchievement(AchievementsNovaCraft.netherite_upgrade);
		}
		if (event.crafting.getItem() == (NovaCraftItems.tophinite_pickaxe)) {
			event.player.triggerAchievement(AchievementsNovaCraft.netherite_upgrade);
		}
		if (event.crafting.getItem() == (NovaCraftItems.tophinite_shovel)) {
			event.player.triggerAchievement(AchievementsNovaCraft.netherite_upgrade);
		}
		if (event.crafting.getItem() == (NovaCraftItems.tophinite_axe)) {
			event.player.triggerAchievement(AchievementsNovaCraft.netherite_upgrade);
		}
		if (event.crafting.getItem() == (NovaCraftItems.tophinite_hoe)) {
			event.player.triggerAchievement(AchievementsNovaCraft.netherite_upgrade);
		}
		if (event.crafting.getItem() == (NovaCraftItems.tophinite_bow)) {
			event.player.triggerAchievement(AchievementsNovaCraft.netherite_upgrade);
		}
		if (event.crafting.getItem() == (NovaCraftItems.tophinite_helmet)) {
			event.player.triggerAchievement(AchievementsNovaCraft.netherite_upgrade);
		}
		if (event.crafting.getItem() == (NovaCraftItems.tophinite_chestplate)) {
			event.player.triggerAchievement(AchievementsNovaCraft.netherite_upgrade);
		}
		if (event.crafting.getItem() == (NovaCraftItems.tophinite_leggings)) {
			event.player.triggerAchievement(AchievementsNovaCraft.netherite_upgrade);
		}
		if (event.crafting.getItem() == (NovaCraftItems.tophinite_boots)) {
			event.player.triggerAchievement(AchievementsNovaCraft.netherite_upgrade);
		}		
		if (event.crafting.getItem() == (NovaCraftItems.klangite_sword)) {
			event.player.triggerAchievement(AchievementsNovaCraft.true_netherite_upgrade);
		}
		if (event.crafting.getItem() == (NovaCraftItems.klangite_pickaxe)) {
			event.player.triggerAchievement(AchievementsNovaCraft.true_netherite_upgrade);
		}
		if (event.crafting.getItem() == (NovaCraftItems.klangite_shovel)) {
			event.player.triggerAchievement(AchievementsNovaCraft.true_netherite_upgrade);
		}
		if (event.crafting.getItem() == (NovaCraftItems.klangite_axe)) {
			event.player.triggerAchievement(AchievementsNovaCraft.true_netherite_upgrade);
		}
		if (event.crafting.getItem() == (NovaCraftItems.klangite_hoe)) {
			event.player.triggerAchievement(AchievementsNovaCraft.true_netherite_upgrade);
		}
		if (event.crafting.getItem() == (NovaCraftItems.klangite_bow)) {
			event.player.triggerAchievement(AchievementsNovaCraft.true_netherite_upgrade);
		}
		if (event.crafting.getItem() == (NovaCraftItems.klangite_helmet)) {
			event.player.triggerAchievement(AchievementsNovaCraft.true_netherite_upgrade);
		}
		if (event.crafting.getItem() == (NovaCraftItems.klangite_chestplate)) {
			event.player.triggerAchievement(AchievementsNovaCraft.true_netherite_upgrade);
		}
		if (event.crafting.getItem() == (NovaCraftItems.klangite_leggings)) {
			event.player.triggerAchievement(AchievementsNovaCraft.true_netherite_upgrade);
		}
		if (event.crafting.getItem() == (NovaCraftItems.klangite_boots)) {
			event.player.triggerAchievement(AchievementsNovaCraft.true_netherite_upgrade);
		}
		if (event.crafting.getItem() == (NovaCraftItems.klangite_ingot)) {
			event.player.triggerAchievement(AchievementsNovaCraft.advanced_alloying);
		}				
		if (event.crafting.getItem() == (NovaCraftItems.warden_sword)) {
			event.player.triggerAchievement(AchievementsNovaCraft.the_next_upgrade);
		}
		if (event.crafting.getItem() == (NovaCraftItems.warden_pickaxe)) {
			event.player.triggerAchievement(AchievementsNovaCraft.the_next_upgrade);
		}
		if (event.crafting.getItem() == (NovaCraftItems.warden_shovel)) {
			event.player.triggerAchievement(AchievementsNovaCraft.the_next_upgrade);
		}
		if (event.crafting.getItem() == (NovaCraftItems.warden_axe)) {
			event.player.triggerAchievement(AchievementsNovaCraft.the_next_upgrade);
		}
		if (event.crafting.getItem() == (NovaCraftItems.warden_hoe)) {
			event.player.triggerAchievement(AchievementsNovaCraft.the_next_upgrade);
		}
		if (event.crafting.getItem() == (NovaCraftItems.warden_bow)) {
			event.player.triggerAchievement(AchievementsNovaCraft.the_next_upgrade);
		}
		if (event.crafting.getItem() == (NovaCraftItems.warden_helmet)) {
			event.player.triggerAchievement(AchievementsNovaCraft.the_next_upgrade);
		}
		if (event.crafting.getItem() == (NovaCraftItems.warden_chestplate)) {
			event.player.triggerAchievement(AchievementsNovaCraft.the_next_upgrade);
		}
		if (event.crafting.getItem() == (NovaCraftItems.warden_leggings)) {
			event.player.triggerAchievement(AchievementsNovaCraft.the_next_upgrade);
		}
		if (event.crafting.getItem() == (NovaCraftItems.warden_boots)) {
			event.player.triggerAchievement(AchievementsNovaCraft.the_next_upgrade);
		}						
		if (event.crafting.getItem() == (NovaCraftItems.crystallized_vanite_sword)) {
			event.player.triggerAchievement(AchievementsNovaCraft.crystallized);
		}
		if (event.crafting.getItem() == (NovaCraftItems.crystallized_vanite_pickaxe)) {
			event.player.triggerAchievement(AchievementsNovaCraft.crystallized);
		}
		if (event.crafting.getItem() == (NovaCraftItems.crystallized_vanite_shovel)) {
			event.player.triggerAchievement(AchievementsNovaCraft.crystallized);
		}
		if (event.crafting.getItem() == (NovaCraftItems.crystallized_vanite_axe)) {
			event.player.triggerAchievement(AchievementsNovaCraft.crystallized);
		}
		if (event.crafting.getItem() == (NovaCraftItems.crystallized_vanite_hoe)) {
			event.player.triggerAchievement(AchievementsNovaCraft.crystallized);
		}
		if (event.crafting.getItem() == (NovaCraftItems.crystallized_vanite_bow)) {
			event.player.triggerAchievement(AchievementsNovaCraft.crystallized);
		}
		if (event.crafting.getItem() == (NovaCraftItems.crystallized_vanite_helmet)) {
			event.player.triggerAchievement(AchievementsNovaCraft.crystallized);
		}
		if (event.crafting.getItem() == (NovaCraftItems.crystallized_vanite_chestplate)) {
			event.player.triggerAchievement(AchievementsNovaCraft.crystallized);
		}
		if (event.crafting.getItem() == (NovaCraftItems.crystallized_vanite_leggings)) {
			event.player.triggerAchievement(AchievementsNovaCraft.crystallized);
		}
		if (event.crafting.getItem() == (NovaCraftItems.crystallized_vanite_boots)) {
			event.player.triggerAchievement(AchievementsNovaCraft.crystallized);
		}
		if (event.crafting.getItem() == (NovaCraftItems.ophidian_bow)) {
			event.player.triggerAchievement(AchievementsNovaCraft.flying_mobs_beware);
		}
		if (event.crafting.getItem() == (NovaCraftItems.reinforced_pherithium_shickaxe)) {
			event.player.triggerAchievement(AchievementsNovaCraft.fancy_efficiency_VI);
		}
		if (event.crafting.getItem() == (NovaCraftItems.klangite_firecharge_launcher)) {
			event.player.triggerAchievement(AchievementsNovaCraft.a_new_method_of_mining);
		}
		if (event.crafting.getItem() == Item.getItemFromBlock(NovaCraftBlocks.legendary_beacon)) {
			event.player.triggerAchievement(AchievementsNovaCraft.legend);
		}
		if (event.crafting.getItem() == (NovaCraftItems.static_blend)) {
			event.player.triggerAchievement(AchievementsNovaCraft.static_ignition);
		}
	}

}
