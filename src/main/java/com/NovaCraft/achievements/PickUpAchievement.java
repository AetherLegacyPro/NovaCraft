package com.NovaCraft.achievements;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraftBlocks.NovaCraftBlocks;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatBase;

public class PickUpAchievement {
	
	@SubscribeEvent
    public void PickUp(final PlayerEvent.ItemPickupEvent event) {
	if (event.pickedUp.getEntityItem().isItemEqual(new ItemStack(NovaCraftBlocks.cyan_rose))) {
        event.player.addStat((StatBase)AchievementsNovaCraft.welcome_to_novacraft, 1);
        }
	if (event.pickedUp.getEntityItem().isItemEqual(new ItemStack(NovaCraftBlocks.cobbled_etherstone))) {
        event.player.addStat((StatBase)AchievementsNovaCraft.welcome_to_novacraft, 1);
        }
	if (event.pickedUp.getEntityItem().isItemEqual(new ItemStack(NovaCraftBlocks.cobbled_grimstone))) {
        event.player.addStat((StatBase)AchievementsNovaCraft.welcome_to_novacraft, 1);
        }
	if (event.pickedUp.getEntityItem().isItemEqual(new ItemStack(NovaCraftBlocks.cobbled_nullstone))) {
        event.player.addStat((StatBase)AchievementsNovaCraft.welcome_to_novacraft, 1);
        }
	if (event.pickedUp.getEntityItem().isItemEqual(new ItemStack(NovaCraftItems.brimstone_dust))) {
        event.player.addStat((StatBase)AchievementsNovaCraft.time_to_excavate, 1);
        }
	if (event.pickedUp.getEntityItem().isItemEqual(new ItemStack(NovaCraftItems.pherithium_scraps))) {
        event.player.addStat((StatBase)AchievementsNovaCraft.welcome_to_novacraft, 1);
        event.player.addStat((StatBase)AchievementsNovaCraft.the_strange_ore, 1);
        }
	if (event.pickedUp.getEntityItem().isItemEqual(new ItemStack(NovaCraftItems.vanite_chunk))) {
        event.player.addStat((StatBase)AchievementsNovaCraft.even_better_than_iron, 1);
        }
	if (event.pickedUp.getEntityItem().isItemEqual(new ItemStack(NovaCraftItems.tophinite_gemstone))) {
        event.player.addStat((StatBase)AchievementsNovaCraft.even_better_than_netherite, 1);
        }
	if (event.pickedUp.getEntityItem().isItemEqual(new ItemStack(NovaCraftItems.xancium_dust))) {
        event.player.addStat((StatBase)AchievementsNovaCraft.the_pink_ore, 1);
        }
	if (event.pickedUp.getEntityItem().isItemEqual(new ItemStack(NovaCraftItems.raw_klangite))) {
        event.player.addStat((StatBase)AchievementsNovaCraft.legendary_ore, 1);
        }
	if (event.pickedUp.getEntityItem().isItemEqual(new ItemStack(NovaCraftItems.copartz_shard))) {
		event.player.addStat((StatBase)AchievementsNovaCraft.geo_discovery, 1);
        event.player.addStat((StatBase)AchievementsNovaCraft.the_red_geo, 1);
        }
	if (event.pickedUp.getEntityItem().isItemEqual(new ItemStack(NovaCraftItems.tsavorokite_shard))) {
		event.player.addStat((StatBase)AchievementsNovaCraft.geo_discovery, 1);
        event.player.addStat((StatBase)AchievementsNovaCraft.the_green_geo, 1);
        }
	if (event.pickedUp.getEntityItem().isItemEqual(new ItemStack(NovaCraftItems.larimar_shard))) {
		event.player.addStat((StatBase)AchievementsNovaCraft.geo_discovery, 1);
        event.player.addStat((StatBase)AchievementsNovaCraft.the_blue_geo, 1);
        }
	if (event.pickedUp.getEntityItem().isItemEqual(new ItemStack(NovaCraftItems.yttrlinsite_shard))) {
		event.player.addStat((StatBase)AchievementsNovaCraft.geo_discovery, 1);
        event.player.addStat((StatBase)AchievementsNovaCraft.the_orange_geo, 1);
        }
	if (event.pickedUp.getEntityItem().isItemEqual(new ItemStack(NovaCraftItems.aether_shard))) {
		event.player.addStat((StatBase)AchievementsNovaCraft.geo_discovery, 1);
        event.player.addStat((StatBase)AchievementsNovaCraft.the_heavenly_geo, 1);
        }
	if (event.pickedUp.getEntityItem().isItemEqual(new ItemStack(NovaCraftBlocks.luminant_log))) {
		event.player.addStat((StatBase)AchievementsNovaCraft.welcome_to_novacraft, 1);
		event.player.addStat((StatBase)AchievementsNovaCraft.the_glowing_tree, 1);
        }
	if (event.pickedUp.getEntityItem().isItemEqual(new ItemStack(NovaCraftBlocks.flaming_pitcher_bottom))) {
		event.player.addStat((StatBase)AchievementsNovaCraft.the_lava_plant, 1);
        }
	if (event.pickedUp.getEntityItem().isItemEqual(new ItemStack(NovaCraftItems.flaming_pitcher_petal))) {
		event.player.addStat((StatBase)AchievementsNovaCraft.the_lava_plant, 1);
        }
	if (event.pickedUp.getEntityItem().isItemEqual(new ItemStack(NovaCraftItems.nullwart))) {
		event.player.addStat((StatBase)AchievementsNovaCraft.the_strange_plant, 1);
        }
	if (event.pickedUp.getEntityItem().isItemEqual(new ItemStack(NovaCraftBlocks.torchflower))) {
		event.player.addStat((StatBase)AchievementsNovaCraft.the_nonburning_plant, 1);
        }
	if (event.pickedUp.getEntityItem().isItemEqual(new ItemStack(NovaCraftBlocks.lacuna_log))) {
		event.player.addStat((StatBase)AchievementsNovaCraft.end_traveller, 1);
        }
	if (event.pickedUp.getEntityItem().isItemEqual(new ItemStack(NovaCraftBlocks.void_sprout))) {
		event.player.addStat((StatBase)AchievementsNovaCraft.end_traveller, 1);
        }
	if (event.pickedUp.getEntityItem().isItemEqual(new ItemStack(NovaCraftBlocks.chorus_grass))) {
		event.player.addStat((StatBase)AchievementsNovaCraft.end_traveller, 1);
        }
	if (event.pickedUp.getEntityItem().isItemEqual(new ItemStack(NovaCraftBlocks.shadow_bloom))) {
		event.player.addStat((StatBase)AchievementsNovaCraft.end_traveller, 1);
        }
	if (event.pickedUp.getEntityItem().isItemEqual(new ItemStack(NovaCraftItems.echo_shard))) {
		event.player.addStat((StatBase)AchievementsNovaCraft.echo, 1);
        }
	if (event.pickedUp.getEntityItem().isItemEqual(new ItemStack(NovaCraftItems.disc_negative1))) {
		event.player.addStat((StatBase)AchievementsNovaCraft.not_your_ordinary_geo, 1);
        }
	if (event.pickedUp.getEntityItem().isItemEqual(new ItemStack(NovaCraftBlocks.crystallized_end))) {
		event.player.addStat((StatBase)AchievementsNovaCraft.end_remnants, 1);
        }
	if (event.pickedUp.getEntityItem().isItemEqual(new ItemStack(NovaCraftItems.null_shard))) {
		event.player.addStat((StatBase)AchievementsNovaCraft.cursed_crystal, 1);
        }
	if (event.pickedUp.getEntityItem().isItemEqual(new ItemStack(NovaCraftBlocks.infused_vanite_block))) {
		event.player.addStat((StatBase)AchievementsNovaCraft.warden_preparation, 1);
        }
	if (event.pickedUp.getEntityItem().isItemEqual(new ItemStack(NovaCraftItems.dark_essence))) {
		event.player.addStat((StatBase)AchievementsNovaCraft.hello_darkness_my_old_friend, 1);
        }
	if (event.pickedUp.getEntityItem().isItemEqual(new ItemStack(NovaCraftBlocks.null_cluster_2))) {
		event.player.addStat((StatBase)AchievementsNovaCraft.advanced_ritual_preparation, 1);
        }
	if (event.pickedUp.getEntityItem().isItemEqual(new ItemStack(NovaCraftItems.heart_of_the_end))) {
		event.player.addStat((StatBase)AchievementsNovaCraft.end_catalyst, 1);
        }
	if (event.pickedUp.getEntityItem().isItemEqual(new ItemStack(NovaCraftItems.ionizatior_rod))) {
		event.player.addStat((StatBase)AchievementsNovaCraft.a_flaming_fortess, 1);
        }
	if (event.pickedUp.getEntityItem().isItemEqual(new ItemStack(NovaCraftItems.vanite_crystal))) {
		event.player.addStat((StatBase)AchievementsNovaCraft.crystallized_vanite, 1);
        }
	}

}
