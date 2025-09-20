package com.NovaCraftBlocks;

import java.util.ArrayList;
import java.util.List;

import com.NovaCraft.NovaCraft;
import com.NovaCraft.Item.Block.ItemAetherCluster;
import com.NovaCraft.Item.Block.ItemBlockFireProof;
import com.NovaCraft.Item.Block.ItemCopartzCluster;
import com.NovaCraft.Item.Block.ItemEchoCluster;
import com.NovaCraft.Item.Block.ItemLarimarCluster;
import com.NovaCraft.Item.Block.ItemNullCluster;
import com.NovaCraft.Item.Block.ItemTsavorokiteCluster;
import com.NovaCraft.Item.Block.ItemYttrlinsiteCluster;
import com.NovaCraft.config.Configs;
import com.NovaCraft.registry.NovaCraftCreativeTabs;
import com.NovaCraft.registry.OtherModBlocks;
import com.NovaCraft.registry.OtherModItems;
import com.NovaCraftBlocks.container.BlockAdvancedEnchantmentTable;
import com.NovaCraftBlocks.container.BlockAdvancedSmithingTable;
import com.NovaCraftBlocks.container.BlockAncientChest;
import com.NovaCraftBlocks.container.BlockDeepoidFurnace;
import com.NovaCraftBlocks.container.BlockFloodedChest;
import com.NovaCraftBlocks.container.BlockLegendaryBeacon;
import com.NovaCraftBlocks.container.BlockLegendaryEnchantmentTable;
import com.NovaCraftBlocks.container.BlockMineshaftChest;
import com.NovaCraftBlocks.container.BlockNetherChest;
import com.NovaCraftBlocks.container.BlockNullwartBrickBookshelf;
import com.NovaCraftBlocks.container.BlockSculkBrickBookshelf;
import com.NovaCraftBlocks.container.BlockSculkChest;
import com.NovaCraftBlocks.container.BlockTreasureChest;
import com.NovaCraftBlocks.container.BlockUnbreakableAncientChest;
import com.NovaCraftBlocks.crystals.BlockAether;
import com.NovaCraftBlocks.crystals.BlockAetherCluster;
import com.NovaCraftBlocks.crystals.BlockBuddingAether;
import com.NovaCraftBlocks.crystals.BlockBuddingCopartz;
import com.NovaCraftBlocks.crystals.BlockBuddingEcho;
import com.NovaCraftBlocks.crystals.BlockBuddingLarimar;
import com.NovaCraftBlocks.crystals.BlockBuddingNull;
import com.NovaCraftBlocks.crystals.BlockBuddingTsavorokite;
import com.NovaCraftBlocks.crystals.BlockBuddingYttrlinsite;
import com.NovaCraftBlocks.crystals.BlockCopartz;
import com.NovaCraftBlocks.crystals.BlockCopartzCluster;
import com.NovaCraftBlocks.crystals.BlockEcho;
import com.NovaCraftBlocks.crystals.BlockEchoCluster;
import com.NovaCraftBlocks.crystals.BlockLarimar;
import com.NovaCraftBlocks.crystals.BlockLarimarCluster;
import com.NovaCraftBlocks.crystals.BlockNull;
import com.NovaCraftBlocks.crystals.BlockNullCluster;
import com.NovaCraftBlocks.crystals.BlockTsavorokite;
import com.NovaCraftBlocks.crystals.BlockTsavorokiteCluster;
import com.NovaCraftBlocks.crystals.BlockVariegatedShard;
import com.NovaCraftBlocks.crystals.BlockYttrlinsite;
import com.NovaCraftBlocks.crystals.BlockYttrlinsiteCluster;
import com.NovaCraftBlocks.decorative.BlockNovaCraftStairs;
import com.NovaCraftBlocks.decorative.BlockNovaCraftWall;
import com.NovaCraftBlocks.decorative.BlocksNovaCraftSlab;
import com.NovaCraftBlocks.decorative.ItemNovaCraftSlab;
import com.NovaCraftBlocks.explosives.BlockBrimstone;
import com.NovaCraftBlocks.explosives.BlockBrimstoneWire;
import com.NovaCraftBlocks.explosives.BlockPETN;
import com.NovaCraftBlocks.explosives.BlockPETNWire;
import com.NovaCraftBlocks.explosives.BlockXanciumTNT;
import com.NovaCraftBlocks.explosives.BlockXanciumWire;
import com.NovaCraftBlocks.ores.BlockBrimstoneOre;
import com.NovaCraftBlocks.ores.BlockCrystallizedEnd;
import com.NovaCraftBlocks.ores.BlockDeepslateKlangiteOre;
import com.NovaCraftBlocks.ores.BlockDeepslateTophiniteOre;
import com.NovaCraftBlocks.ores.BlockDeepslateVaniteOre;
import com.NovaCraftBlocks.ores.BlockEndKlangiteOre;
import com.NovaCraftBlocks.ores.BlockFrontierslateKlangiteOre;
import com.NovaCraftBlocks.ores.BlockGrimstoneVaniteOre;
import com.NovaCraftBlocks.ores.BlockInfusedVaniteBlock;
import com.NovaCraftBlocks.ores.BlockInfusedVaniteBlockNatural;
import com.NovaCraftBlocks.ores.BlockIridium;
import com.NovaCraftBlocks.ores.BlockIridiumOre;
import com.NovaCraftBlocks.ores.BlockKlangite;
import com.NovaCraftBlocks.ores.BlockKlangiteOre;
import com.NovaCraftBlocks.ores.BlockMeteorite;
import com.NovaCraftBlocks.ores.BlockNetherTophiniteOre;
import com.NovaCraftBlocks.ores.BlockNullstoneTophiniteOre;
import com.NovaCraftBlocks.ores.BlockNullstoneVaniteOre;
import com.NovaCraftBlocks.ores.BlockPherithiumOre;
import com.NovaCraftBlocks.ores.BlockRawDivineral;
import com.NovaCraftBlocks.ores.BlockRawKlangite;
import com.NovaCraftBlocks.ores.BlockRawNetherite;
import com.NovaCraftBlocks.ores.BlockReinforcedVanite;
import com.NovaCraftBlocks.ores.BlockStoneKlangiteOre;
import com.NovaCraftBlocks.ores.BlockStoneTophiniteOre;
import com.NovaCraftBlocks.ores.BlockStoneVaniteOre;
import com.NovaCraftBlocks.ores.BlockTophinite;
import com.NovaCraftBlocks.ores.BlockVanite;
import com.NovaCraftBlocks.ores.BlockVaniteBuildingBlocks;
import com.NovaCraftBlocks.ores.BlockXancium;
import com.NovaCraftBlocks.ores.BlockXanciumOre;
import com.NovaCraftBlocks.ores.piles.BlockCrystalPile;
import com.NovaCraftBlocks.ores.piles.BlockDiamondPile;
import com.NovaCraftBlocks.ores.piles.BlockEmeraldPile;
import com.NovaCraftBlocks.ores.piles.BlockGoldPile;
import com.NovaCraftBlocks.ores.piles.BlockIridiumPile;
import com.NovaCraftBlocks.ores.piles.BlockIronPile;
import com.NovaCraftBlocks.ores.piles.BlockLapisPile;
import com.NovaCraftBlocks.ores.piles.BlockVanitePile;
import com.NovaCraftBlocks.ores.vanilla.BlockEtherstoneOre;
import com.NovaCraftBlocks.ores.vanilla.BlockGrimstoneOre;
import com.NovaCraftBlocks.ores.vanilla.BlockGrimstoneRedstone;
import com.NovaCraftBlocks.ores.vanilla.BlockNullstoneOre;
import com.NovaCraftBlocks.ores.vanilla.BlockNullstoneRedstone;
import com.NovaCraftBlocks.plants.BlockArcticMoss;
import com.NovaCraftBlocks.plants.BlockArcticMossCarpet;
import com.NovaCraftBlocks.plants.BlockBloomingBarb;
import com.NovaCraftBlocks.plants.BlockBrightLichen;
import com.NovaCraftBlocks.plants.BlockDarkLichen;
import com.NovaCraftBlocks.plants.BlockDeepRoot;
import com.NovaCraftBlocks.plants.BlockGlowLichen;
import com.NovaCraftBlocks.plants.BlockGrimLichen;
import com.NovaCraftBlocks.plants.BlockLuminantLeaves;
import com.NovaCraftBlocks.plants.BlockLuminantLog;
import com.NovaCraftBlocks.plants.BlockLuminantPlanks;
import com.NovaCraftBlocks.plants.BlockLuminantSapling;
import com.NovaCraftBlocks.plants.BlockMoss;
import com.NovaCraftBlocks.plants.BlockMossCarpet;
import com.NovaCraftBlocks.plants.BlockNovaCraftMushroom;
import com.NovaCraftBlocks.plants.BlockNullWart;
import com.NovaCraftBlocks.plants.BlockOverworldFlower;
import com.NovaCraftBlocks.plants.BlockRichEtherstone;
import com.NovaCraftBlocks.plants.BlockRichEtherstoneSpike;
import com.NovaCraftBlocks.plants.BlockTorchFlower;
import com.NovaCraftBlocks.plants.LuminantTreeGen;
import com.NovaCraftBlocks.plants.end.BlockChorusGrass;
import com.NovaCraftBlocks.plants.end.BlockDarkLotus;
import com.NovaCraftBlocks.plants.end.BlockDestitude;
import com.NovaCraftBlocks.plants.end.BlockDestitudeBloom;
import com.NovaCraftBlocks.plants.end.BlockDestitudeGrowth;
import com.NovaCraftBlocks.plants.end.BlockDestituteVein;
import com.NovaCraftBlocks.plants.end.BlockEnderBloom;
import com.NovaCraftBlocks.plants.end.BlockEnderBrain;
import com.NovaCraftBlocks.plants.end.BlockEnderFungus;
import com.NovaCraftBlocks.plants.end.BlockEnderFungusBlock;
import com.NovaCraftBlocks.plants.end.BlockEnderFungusStem;
import com.NovaCraftBlocks.plants.end.BlockLacunaFruit;
import com.NovaCraftBlocks.plants.end.BlockLacunaLog;
import com.NovaCraftBlocks.plants.end.BlockLacunaPlanks;
import com.NovaCraftBlocks.plants.end.BlockLivingEnder;
import com.NovaCraftBlocks.plants.end.BlockShadowBloom;
import com.NovaCraftBlocks.plants.end.BlockVoidSprout;
import com.NovaCraftBlocks.plants.nether.BlockDeepoidMushroom;
import com.NovaCraftBlocks.plants.nether.BlockFlamingPitcherBottom;
import com.NovaCraftBlocks.plants.nether.BlockFlamingPitcherTop;
import com.NovaCraftBlocks.plants.nether.BlockHellPiliz;
import com.NovaCraftBlocks.plants.nether.BlockIonMushroom;
import com.NovaCraftBlocks.potion.BlockBlazlinite;
import com.NovaCraftBlocks.potion.BlockBlazliniteBlend;
import com.NovaCraftBlocks.potion.BlockCrackedVaniteCauldron;
import com.NovaCraftBlocks.potion.BlockCrystallizedVanite;
import com.NovaCraftBlocks.potion.BlockDeepFire;
import com.NovaCraftBlocks.potion.BlockDeepOneEgg;
import com.NovaCraftBlocks.potion.BlockDeepOneEggActivated;
import com.NovaCraftBlocks.potion.BlockMoltenVanite;
import com.NovaCraftBlocks.potion.BlockMoltenVaniteCauldron;
import com.NovaCraftBlocks.potion.BlockMoltenVaniteCrystalCauldron;
import com.NovaCraftBlocks.potion.BlockVaniteCauldron;
import com.NovaCraftBlocks.potion.BlockVaniteCluster;
import com.NovaCraftBlocks.sculk.BlockActivatedGrimstoneShrieker;
import com.NovaCraftBlocks.sculk.BlockActivatedReinforcedNullstone;
import com.NovaCraftBlocks.sculk.BlockActivatedUnknownPortalActivator;
import com.NovaCraftBlocks.sculk.BlockCrackedNullstoneDeactivator;
import com.NovaCraftBlocks.sculk.BlockGrimstoneShrieker;
import com.NovaCraftBlocks.sculk.BlockInkedSculk;
import com.NovaCraftBlocks.sculk.BlockNullstoneDeactivator;
import com.NovaCraftBlocks.sculk.BlockReinforcedNullstone;
import com.NovaCraftBlocks.sculk.BlockSculk;
import com.NovaCraftBlocks.sculk.BlockSculkBloom;
import com.NovaCraftBlocks.sculk.BlockSculkBush;
import com.NovaCraftBlocks.sculk.BlockSculkDeepslate;
import com.NovaCraftBlocks.sculk.BlockSculkEndstone;
import com.NovaCraftBlocks.sculk.BlockSculkGrimstone;
import com.NovaCraftBlocks.sculk.BlockSculkGrowth;
import com.NovaCraftBlocks.sculk.BlockSculkNullstone;
import com.NovaCraftBlocks.sculk.BlockSculkSensor;
import com.NovaCraftBlocks.sculk.BlockSculkSpike;
import com.NovaCraftBlocks.sculk.BlockSculkStone;
import com.NovaCraftBlocks.sculk.BlockSculkTendrils;
import com.NovaCraftBlocks.sculk.BlockSculkTentacle;
import com.NovaCraftBlocks.sculk.BlockSculkTulip;
import com.NovaCraftBlocks.sculk.BlockSculkVein;
import com.NovaCraftBlocks.sculk.BlockUnknownPortal;
import com.NovaCraftBlocks.sculk.BlockUnknownPortalActivator;
import com.NovaCraftBlocks.sculk.BlockUnknownPortalSealed;
import com.NovaCraftBlocks.stalactites.BlockIcicle;
import com.NovaCraftBlocks.stalactites.BlockLargeNullstoneStalactite;
import com.NovaCraftBlocks.stalactites.BlockLargeStoneStalactite;
import com.NovaCraftBlocks.stalactites.BlockNullstoneStalactite;
import com.NovaCraftBlocks.stalactites.BlockStoneStalactite;
import com.NovaCraftBlocks.stalagmites.BlockLargeNullstoneStalagmite;
import com.NovaCraftBlocks.stalagmites.BlockLargePherithiumStalagmite;
import com.NovaCraftBlocks.stalagmites.BlockLargeStoneStalagmite;
import com.NovaCraftBlocks.stalagmites.BlockNullstoneStalagmite;
import com.NovaCraftBlocks.stalagmites.BlockPherithium;
import com.NovaCraftBlocks.stalagmites.BlockSmallPherithiumStalagmite;
import com.NovaCraftBlocks.stalagmites.BlockStoneStalagmite;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.*;
import net.minecraft.world.IBlockAccess;

public class NovaCraftBlocks {
	
	//Overworld Building/World Gen Blocks
	public static Block grimstone, cobbled_grimstone, grimstone_bricks, cracked_grimstone_bricks, grimstone_tiles, cracked_grimstone_tiles, chiseled_grimstone, polished_grimstone;
	public static Block nullstone, cobbled_nullstone, nullstone_bricks, cracked_nullstone_bricks, nullstone_tiles, cracked_nullstone_tiles, chiseled_nullstone, polished_nullstone;
	public static Block etherstone, cobbled_etherstone, etherstone_bricks, cracked_etherstone_bricks, etherstone_tiles, cracked_etherstone_tiles, chiseled_etherstone;
	public static Block basal, basal_bricks, cracked_basal_bricks, glowing_basal, chiseled_basal, basal_scrap;
	public static Block sculk_bricks, cracked_sculk_bricks, sculk_tiles, cracked_sculk_tiles, chiseled_sculk;
	public static Block tuff_bricks, cracked_tuff_bricks, tuff_tiles, cracked_tuff_tiles, chiseled_tuff;
	public static Block calcite_bricks, cracked_calcite_bricks, calcite_tiles, cracked_calcite_tiles, chiseled_calcite;
	public static Block dripstone_bricks, cracked_dripstone_bricks, dripstone_tiles, cracked_dripstone_tiles, chiseled_dripstone;
	public static Block nullwart_bricks, flaming_nullwart_bricks;
	public static Block luminant_log, luminant_sapling, luminant_leaves, luminant_planks;
	public static Block luminant_slab, luminant_double_slab, luminant_stairs, luminant_fence, luminant_fence_gate;
	public static Block glow_torch, vanite_torch, dim_vanite_torch;
	public static Block blazing_coal_block, glowing_obsidian;
	
	//Decoration Blocks
	public static Block grimstone_slab, grimstone_double_slab, grimstone_stairs, grimstone_wall;
	public static Block grimstone_brick_slab, grimstone_brick_double_slab, grimstone_brick_stairs, grimstone_brick_wall;
	public static Block cobbled_grimstone_slab, cobbled_grimstone_double_slab, cobbled_grimstone_stairs, cobbled_grimstone_wall;
	public static Block grimstone_tiled_slab, grimstone_tiled_double_slab, grimstone_tiled_stairs, grimstone_tiled_wall;
	
	public static Block nullstone_slab, nullstone_double_slab, nullstone_stairs, nullstone_wall;
	public static Block nullstone_brick_slab, nullstone_brick_double_slab, nullstone_brick_stairs, nullstone_brick_wall;
	public static Block cobbled_nullstone_slab, cobbled_nullstone_double_slab, cobbled_nullstone_stairs, cobbled_nullstone_wall;
	public static Block nullstone_tiled_slab, nullstone_tiled_double_slab, nullstone_tiled_stairs, nullstone_tiled_wall;
	public static Block nullwart_brick_slab, nullwart_brick_double_slab, nullwart_brick_stairs, nullwart_brick_wall;
	
	public static Block etherstone_slab, etherstone_double_slab, etherstone_stairs, etherstone_wall;
	public static Block etherstone_brick_slab, etherstone_brick_double_slab, etherstone_brick_stairs, etherstone_brick_wall;
	public static Block cobbled_etherstone_slab, cobbled_etherstone_double_slab, cobbled_etherstone_stairs, cobbled_etherstone_wall;
	public static Block etherstone_tiled_slab, etherstone_tiled_double_slab, etherstone_tiled_stairs, etherstone_tiled_wall;
	
	public static Block basal_slab, basal_double_slab, basal_stairs, basal_wall;
	public static Block basal_brick_slab, basal_brick_double_slab, basal_brick_stairs, basal_brick_wall;
	
	public static Block sculk_brick_slab, sculk_brick_double_slab, sculk_brick_stairs, sculk_brick_wall;
	public static Block sculk_tiled_slab, sculk_tiled_double_slab, sculk_tiled_stairs, sculk_tiled_wall;
	public static Block tuff_brick_slab, tuff_brick_double_slab, tuff_brick_stairs, tuff_brick_wall;
	public static Block tuff_tiled_slab, tuff_tiled_double_slab, tuff_tiled_stairs, tuff_tiled_wall;	
	public static Block calcite_brick_slab, calcite_brick_double_slab, calcite_brick_stairs, calcite_brick_wall;
	public static Block calcite_tiled_slab, calcite_tiled_double_slab, calcite_tiled_stairs, calcite_tiled_wall;	
	public static Block dripstone_brick_slab, dripstone_brick_double_slab, dripstone_brick_stairs, dripstone_brick_wall;
	public static Block dripstone_tiled_slab, dripstone_tiled_double_slab, dripstone_tiled_stairs, dripstone_tiled_wall;
		
	//Crystals
	public static Block cracked_copartz_block, copartz_block, budding_copartz_block, copartz_cluster_1, copartz_cluster_2;
	public static Block cracked_larimar_block, larimar_block, budding_larimar_block, larimar_cluster_1, larimar_cluster_2;
	public static Block cracked_tsavorokite_block, tsavorokite_block, budding_tsavorokite_block, tsavorokite_cluster_1, tsavorokite_cluster_2;
	public static Block cracked_yttrlinsite_block, yttrlinsite_block, budding_yttrlinsite_block, yttrlinsite_cluster_1, yttrlinsite_cluster_2;
	public static Block cracked_aether_block, aether_block, budding_aether_block, aether_cluster_1, aether_cluster_2;
	public static Block echo_block, budding_echo_block, echo_cluster_1, echo_cluster_2;
	public static Block null_block, budding_null_block, null_cluster_1, null_cluster_2;
	public static Block variegated_block, crystallized_vanite, vanite_cluster, crystallized_sculk;
	
	//Vanite
	public static Block stone_vanite_ore, deepslate_vanite_ore, grimstone_vanite_ore, nullstone_vanite_ore, block_of_vanite, block_of_reinforced_vanite, vanite_glass;
	public static Block vanite_bricks, carved_vanite_bricks, glowing_carved_vanite_bricks, polished_vanite_bricks;
	public static Block vanite_brick_slab, vanite_brick_double_slab, vanite_brick_stairs, vanite_brick_wall;
	public static Block carved_vanite_brick_slab, carved_vanite_brick_double_slab, carved_vanite_brick_stairs, carved_vanite_brick_wall;
	public static Block infused_vanite_block, infused_vanite_block_natural, nullified_vanite;
	
	//Iridium
	public static Block meteorite_block, iridium_ore, block_of_iridium;
	
	//Explosives
	public static Block brimstone_ore, block_of_brimstone, brimstone_wire, PETN, PETN_wire;
	public static Block xancium_ore, block_of_xancium, xancium_TNT, xancium_wire;
	
	//Tophinite & Klangite
	public static Block stone_tophinite_ore, deepslate_tophinite_ore, nullstone_tophinite_ore, nether_tophinite_ore, block_of_tophinite;		
	public static Block stone_klangite_ore, deepslate_klangite_ore, klangite_ore, block_of_raw_klangite, block_of_klangite, end_klangite_ore, frontierslate_klangite_ore;
	
	//Vanilla Ores
	public static Block grimstone_diamond, grimstone_emerald, grimstone_gold, grimstone_iron, grimstone_lapis;
	public static Block grimstone_redstone, lit_grimstone_redstone;	
	public static Block nullstone_diamond, nullstone_emerald, nullstone_gold, nullstone_iron, nullstone_lapis;
	public static Block nullstone_redstone, lit_nullstone_redstone;
	public static Block etherstone_coal, etherstone_emerald, etherstone_gold, etherstone_iron, etherstone_brimstone;
	
	public static Block iron_pile, gold_pile, diamond_pile, lapis_pile, emerald_pile, vanite_pile, iridium_pile, crystal_pile;
	
	
	//End Building/World Gen Blocks
	public static Block frontierslate, frontierslate_bricks, carved_frontierslate_bricks;	
	public static Block frontierslate_slab, frontierslate_double_slab, frontierslate_stairs, frontierslate_wall;
	public static Block frontierslate_brick_slab, frontierslate_brick_double_slab, frontierslate_brick_stairs, frontierslate_brick_wall;
	public static Block lacuna_log, lacuna_fruit, lacuna_planks;
	public static Block lacuna_slab, lacuna_double_slab, lacuna_stairs, lacuna_fence, lacuna_fence_gate;
	public static Block vacuum_sand, vacuum_glass, inked_vacuum_sand, inked_vacuum_glass;
	public static Block nullcube_slime_block, crystallized_end;
	
	//End Plants or Life
	public static Block chorus_grass, void_sprout, shadow_bloom;
	public static Block destitude_growth, destitude_block, destitude_bloom, destitude_vein;
	public static Block living_ender, ender_fungus_block, ender_fungus_stem, dark_lotus, ender_sprout, ender_fungus, ender_brain;
	
	//Sculk
	public static Block sculk_block, inked_sculk_block, sculk_vein, sculk_growth;
	public static Block sculk_tentacle_1, sculk_tentacle_2, sculk_tendrils;
	public static Block sculk_bush, sculk_bloom, sculk_tulip;
	public static Block sculk_spike, sculk_sensor;	
	public static Block sculk_stone, sculk_grimstone, sculk_nullstone, sculk_endstone, sculk_deepslate;
	
	//Cave Plants
	public static Block glow_lichen, grim_lichen, dark_lichen, bright_lichen;
	public static Block moss_block, moss_carpet, arctic_moss_block, arctic_moss_carpet;
	public static Block null_wart, deep_roots; 
	public static Block calvatia_mushroom, hydnum_mushroom, lentius_mushroom, rozite_mushroom, pleurotus_mushroom;
	
	//Cave Decoration
	public static Block large_pherithium_stalagmite, small_pherithium_stalagmite, block_of_pherithium, pherithium_glass, pherithium_ore;	
	public static Block stone_stalagmite, stone_stalactite, large_stone_stalagmite, large_stone_stalactite; 	
	public static Block nullstone_stalagmite, nullstone_stalactite, large_nullstone_stalagmite, large_nullstone_stalactite;	
	public static Block icicle;
	
	//Surface Plants
	public static Block rich_etherstone, rich_etherstone_spike;
	public static Block cyan_rose, torchflower, cosmos, violet, blooming_barb, purple_rose, desert_bloom;
	
	//Nether Plants
	public static Block flaming_pitcher_bottom, flaming_pitcher_top;
	public static Block hell_piliz, deepoid_mushroom, ion_mushroom;
	
	//Treasure Chests
	public static Block treasure_chest, flooded_chest, mineshaft_chest, nether_chest, sculk_chest;
	
	//Boss Summoning
	public static Block grimstone_shrieker, activated_grimstone_shrieker;
	public static Block deep_one_egg, deep_one_egg_activated;
	public static Block reinforced_nullstone, activated_reinforced_nullstone, unknown_portal_activator, activated_unknown_portal_activator;
	public static Block unknown_portal_sealed, unknown_portal, cracked_nullstone_deactivator, nullstone_deactivator;
	public static Block trap_tophinite;
	
	//Special
	public static Block advanced_enchantment_table, legendary_beacon, legendary_enchantment_table;
	public static Block unbreakable_ancient_chest, ancient_chest;
	public static Block nullwart_brick_bookshelf, sculk_brick_bookshelf;
	public static Block deepoid_bricks, deepoid_power_core, deepoid_furnace, lit_deepoid_furnace;
	
	//9x Duplication Structure
	public static Block raw_divineral, raw_netherite;
	
	//Amplified Potions
	public static Block deepfire, blazlinite_blend, blazlinite, molten_vanite;	
	public static Block vanite_cauldron, molten_vanite_cauldron, molten_vanite_crystal_cauldron, cracked_vanite_crystal_cauldron;
	
	//Tile Entity Renders
	public static int UnbreakableAncientChestRenderId;
	public static int AncientChestRenderId;
	
	//Unused
	public static Block advanced_smithing_table;
	
	public static void initialization() {
		
		//Normal Blocks
		grimstone = register("grimstone", new BlockGrimstone());
		cobbled_grimstone = register("cobbled_grimstone", new BlockCobbledGrimstone());
		grimstone_bricks = register("grimstone_bricks", new BlockGrimstoneBuildingBlocks().setBlockTextureName(NovaCraft.find("grimstone_bricks")));
		cracked_grimstone_bricks = register("cracked_grimstone_bricks", new BlockGrimstoneBuildingBlocks().setBlockTextureName(NovaCraft.find("cracked_grimstone_bricks")));
		grimstone_tiles = register("grimstone_tiles", new BlockGrimstoneBuildingBlocks().setBlockTextureName(NovaCraft.find("grimstone_tiles")));
		cracked_grimstone_tiles = register("cracked_grimstone_tiles", new BlockGrimstoneBuildingBlocks().setBlockTextureName(NovaCraft.find("cracked_grimstone_tiles")));
		polished_grimstone = register("polished_grimstone", new BlockGrimstoneBuildingBlocks()).setBlockTextureName(NovaCraft.find("polished_grimstone"));
		chiseled_grimstone = register("chiseled_grimstone", new BlockChiseledGrimstone());
		
		grimstone_diamond = register("grimstone_diamond", new BlockGrimstoneOre().setBlockTextureName(NovaCraft.find("grimstone_diamond_ore")));
		grimstone_emerald = register("grimstone_emerald", new BlockGrimstoneOre().setBlockTextureName(NovaCraft.find("grimstone_emerald_ore")));
		grimstone_gold = register("grimstone_gold", new BlockGrimstoneOre().setBlockTextureName(NovaCraft.find("grimstone_gold_ore")));
		grimstone_iron = register("grimstone_iron", new BlockGrimstoneOre().setBlockTextureName(NovaCraft.find("grimstone_iron_ore")));
		grimstone_lapis = register("grimstone_lapis", new BlockGrimstoneOre().setBlockTextureName(NovaCraft.find("grimstone_lapis_ore")));		
		grimstone_redstone = register("grimstone_redstone", new BlockGrimstoneRedstone(false).setBlockTextureName(NovaCraft.find("grimstone_redstone_ore")));
		lit_grimstone_redstone = registerHidden("lit_grimstone_redstone", new BlockGrimstoneRedstone(true).setLightLevel(0.625F).setBlockTextureName(NovaCraft.find("grimstone_redstone_ore")).setCreativeTab(null));
		
		nullstone = register("nullstone", new BlockNullstone());
		cobbled_nullstone = register("cobbled_nullstone", new BlockCobbledNullstone());
		nullstone_bricks = register("nullstone_bricks", new BlockNullstoneBuildingBlocks().setBlockTextureName(NovaCraft.find("nullstone_bricks")));	
		cracked_nullstone_bricks = register("cracked_nullstone_bricks", new BlockNullstoneBuildingBlocks().setBlockTextureName(NovaCraft.find("cracked_nullstone_bricks")));
		nullstone_tiles = register("nullstone_tiles", new BlockNullstoneBuildingBlocks().setBlockTextureName(NovaCraft.find("nullstone_tiles")));
		cracked_nullstone_tiles = register("cracked_nullstone_tiles", new BlockNullstoneBuildingBlocks().setBlockTextureName(NovaCraft.find("cracked_nullstone_tiles")));
		polished_nullstone = register("polished_nullstone", new BlockNullstoneBuildingBlocks()).setBlockTextureName(NovaCraft.find("polished_nullstone"));
		reinforced_nullstone = register("reinforced_nullstone", new BlockReinforcedNullstone());
		activated_reinforced_nullstone = registerHidden("activated_reinforced_nullstone", new BlockActivatedReinforcedNullstone()).setCreativeTab(null);
		unknown_portal_activator = register("unknown_portal_activator", new BlockUnknownPortalActivator());
		activated_unknown_portal_activator = registerHidden("activated_unknown_portal_activator", new BlockActivatedUnknownPortalActivator()).setCreativeTab(null);
		cracked_nullstone_deactivator = register("cracked_nullstone_deactivator", new BlockCrackedNullstoneDeactivator());
		nullstone_deactivator = register("nullstone_deactivator", new BlockNullstoneDeactivator());
		chiseled_nullstone = register("chiseled_nullstone", new BlockChiseledNullstone());
		
		nullstone_diamond = register("nullstone_diamond", new BlockNullstoneOre().setBlockTextureName(NovaCraft.find("nullstone_diamond_ore")));
		nullstone_emerald = register("nullstone_emerald", new BlockNullstoneOre().setBlockTextureName(NovaCraft.find("nullstone_emerald_ore")));
		nullstone_gold = register("nullstone_gold", new BlockNullstoneOre().setBlockTextureName(NovaCraft.find("nullstone_gold_ore")));
		nullstone_iron = register("nullstone_iron", new BlockNullstoneOre().setBlockTextureName(NovaCraft.find("nullstone_iron_ore")));
		nullstone_lapis = register("nullstone_lapis", new BlockNullstoneOre().setBlockTextureName(NovaCraft.find("nullstone_lapis_ore")));		
		nullstone_redstone = register("nullstone_redstone", new BlockNullstoneRedstone(false).setBlockTextureName(NovaCraft.find("nullstone_redstone_ore")));
		lit_nullstone_redstone = registerHidden("lit_nullstone_redstone", new BlockNullstoneRedstone(true).setLightLevel(0.625F).setBlockTextureName(NovaCraft.find("nullstone_redstone_ore")).setCreativeTab(null));
		
		etherstone = register("etherstone", new BlockEtherstone());
		cobbled_etherstone = register("cobbled_etherstone", new BlockCobbledEtherstone());	
		etherstone_bricks = register("etherstone_bricks", new BlockEtherstoneBuildingBlocks().setBlockTextureName(NovaCraft.find("etherstone_bricks")));
		cracked_etherstone_bricks = register("cracked_etherstone_bricks", new BlockEtherstoneBuildingBlocks().setBlockTextureName(NovaCraft.find("cracked_etherstone_bricks")));
		etherstone_tiles = register("etherstone_tiles", new BlockEtherstoneBuildingBlocks().setBlockTextureName(NovaCraft.find("etherstone_tiles")));
		cracked_etherstone_tiles = register("cracked_etherstone_tiles", new BlockEtherstoneBuildingBlocks().setBlockTextureName(NovaCraft.find("cracked_etherstone_tiles")));
		chiseled_etherstone = register("chiseled_etherstone", new BlockChiseledEtherstone());
		
		etherstone_coal = register("etherstone_coal", new BlockEtherstoneOre().setBlockTextureName(NovaCraft.find("etherstone_coal_ore")));
		etherstone_emerald = register("etherstone_emerald", new BlockEtherstoneOre().setBlockTextureName(NovaCraft.find("etherstone_emerald_ore")));
		etherstone_gold = register("etherstone_gold", new BlockEtherstoneOre().setBlockTextureName(NovaCraft.find("etherstone_gold_ore")));
		etherstone_iron = register("etherstone_iron", new BlockEtherstoneOre().setBlockTextureName(NovaCraft.find("etherstone_iron_ore")));
		etherstone_brimstone = register("etherstone_brimstone", new BlockEtherstoneOre().setBlockTextureName(NovaCraft.find("etherstone_brimstone_ore")));
		
		glowing_obsidian = registerMeta("glowing_obsidian", new BlockGlowingObsidian());
		
		basal = register("basal", new BlockBasal());
		basal_bricks = register("basal_bricks", new BlockBasalBuildingBlocks().setBlockTextureName(NovaCraft.find("basal_bricks")));
		cracked_basal_bricks = register("cracked_basal_bricks", new BlockBasalBuildingBlocks().setBlockTextureName(NovaCraft.find("cracked_basal_bricks")));
		chiseled_basal = register("chiseled_basal", new BlockBasalBuildingBlocks().setBlockTextureName(NovaCraft.find("chiseled_basal")));
		glowing_basal = register("glowing_basal", new BlockGlowingBasal().setLightLevel(0.7775F).setBlockTextureName(NovaCraft.find("glowing_basal")));
		basal_scrap = registerMeta("basal_scrap", new BlockBasalScrap().setBlockTextureName(NovaCraft.find("basal_scrap")));

		if (Loader.isModLoaded("etfuturum")) {
			try {
				Block tuff = GameRegistry.findBlock("etfuturum", "tuff");
				if (tuff != null) {
					tuff_bricks = register("tuff_bricks", new BlockTuffBuildingBlocks().setBlockTextureName(NovaCraft.find("tuff_bricks")));
					cracked_tuff_bricks = register("cracked_tuff_bricks", new BlockTuffBuildingBlocks().setBlockTextureName(NovaCraft.find("cracked_tuff_bricks")));
					tuff_tiles = register("tuff_tiles", new BlockTuffBuildingBlocks().setBlockTextureName(NovaCraft.find("tuff_tiles")));
					cracked_tuff_tiles = register("cracked_tuff_tiles", new BlockTuffBuildingBlocks().setBlockTextureName(NovaCraft.find("cracked_tuff_tiles")));
				}
			} catch (Exception ex) {
				if (Configs.enableDebugMode) {
					System.out.println("Tuff from Et Futurum Requiem is missing, skipping Tuff Building Blocks...");
				}
			}
		}

		if (Loader.isModLoaded("etfuturum")) {
			try {
				Block calcite = GameRegistry.findBlock("etfuturum", "calcite");
				if (calcite != null) {
					calcite_bricks = register("calcite_bricks", new BlockCalciteBuildingBlocks().setBlockTextureName(NovaCraft.find("calcite_bricks")));
					cracked_calcite_bricks = register("cracked_calcite_bricks", new BlockCalciteBuildingBlocks().setBlockTextureName(NovaCraft.find("cracked_calcite_bricks")));
					calcite_tiles = register("calcite_tiles", new BlockCalciteBuildingBlocks().setBlockTextureName(NovaCraft.find("calcite_tiles")));
					cracked_calcite_tiles = register("cracked_calcite_tiles", new BlockCalciteBuildingBlocks().setBlockTextureName(NovaCraft.find("cracked_calcite_tiles")));
				}
			} catch (Exception ex) {
				if (Configs.enableDebugMode) {
					System.out.println("Calcite from Et Futurum Requiem is missing, skipping Calcite Building Blocks...");
				}
			}
		}
		
		frontierslate = register("frontierslate", new BlockFrontierslate().setBlockTextureName(NovaCraft.find("frontierslate")));
		frontierslate_bricks = register("frontierslate_bricks", new BlockFrontierslateBricks().setBlockTextureName(NovaCraft.find("frontierslate_bricks")));
		carved_frontierslate_bricks = register("carved_frontierslate_bricks", new BlockCarvedFrontierslateBricks());
		
		crystallized_end = register("crystallized_end", new BlockCrystallizedEnd());
		
		vacuum_sand = register("vacuum_sand", new BlockVacuumSand().setBlockTextureName(NovaCraft.find("vacuum_sand")));
		vacuum_glass = register("vacuum_glass", new BlockVacuumGlass(Material.glass, false).setBlockTextureName(NovaCraft.find("vacuum_glass")));
		inked_vacuum_sand = register("inked_vacuum_sand", new BlockInkedVacuumSand().setBlockTextureName(NovaCraft.find("vacuum_sand")));
		inked_vacuum_glass = register("inked_vacuum_glass", new BlockInkedVacuumGlass(Material.glass, false).setBlockTextureName(NovaCraft.find("vacuum_glass")));
		
		brimstone_ore = register("brimstone_ore", new BlockBrimstoneOre().setBlockTextureName(NovaCraft.find("brimstone_ore")));
		block_of_brimstone = register("block_of_brimstone", new BlockBrimstone().setBlockTextureName(NovaCraft.find("brimstone_block")));
		brimstone_wire = registerHidden("brimstone_wire", new BlockBrimstoneWire().setBlockTextureName(NovaCraft.find("brimstone_dust_block")));
		
		if (!(Configs.enableGrimstone) && !(Configs.enableNullstone) && !(Configs.enableDeepslateOreGeneration)) {
		stone_vanite_ore = registerItemBlock("stone_vanite_ore", new BlockStoneVaniteOre(), ItemBlockFireProof.class).setBlockTextureName(NovaCraft.find("stone_vanite_ore"));		
		}
		
		if (!(Configs.enableGrimstone) && !(Configs.enableNullstone) && Loader.isModLoaded("etfuturum") && Configs.enableDeepslateOreGeneration) {
		deepslate_vanite_ore = registerItemBlock("deepslate_vanite_ore", new BlockDeepslateVaniteOre(), ItemBlockFireProof.class).setBlockTextureName(NovaCraft.find("deepslate_vanite_ore"));	
		}
		
		grimstone_vanite_ore = registerItemBlock("grimstone_vanite_ore", new BlockGrimstoneVaniteOre(), ItemBlockFireProof.class).setBlockTextureName(NovaCraft.find("grimstone_vanite_ore"));		
		nullstone_vanite_ore = registerItemBlock("nullstone_vanite_ore", new BlockNullstoneVaniteOre(), ItemBlockFireProof.class).setBlockTextureName(NovaCraft.find("nullstone_vanite_ore"));			
		block_of_vanite = registerItemBlock("block_of_vanite", new BlockVanite(), ItemBlockFireProof.class).setBlockTextureName(NovaCraft.find("block_of_vanite"));
		block_of_reinforced_vanite = registerItemBlock("block_of_reinforced_vanite", new BlockReinforcedVanite(), ItemBlockFireProof.class).setBlockTextureName(NovaCraft.find("block_of_reinforced_vanite"));		
		infused_vanite_block_natural = registerItemBlock("infused_vanite_block_natural", new BlockInfusedVaniteBlockNatural(), ItemBlockFireProof.class);
		infused_vanite_block = registerItemBlock("infused_vanite_block", new BlockInfusedVaniteBlock(), ItemBlockFireProof.class);				
		vanite_glass = register("vanite_glass", new BlockVaniteGlass(Material.glass, false).setBlockTextureName(NovaCraft.find("vanite_glass")));
		molten_vanite = registerHidden("molten_vanite", new BlockMoltenVanite());		
		vanite_bricks = registerItemBlock("vanite_bricks", new BlockVaniteBuildingBlocks(), ItemBlockFireProof.class).setBlockTextureName(NovaCraft.find("vanite_bricks"));	
		polished_vanite_bricks = registerItemBlock("polished_vanite_bricks", new BlockVaniteBuildingBlocks(), ItemBlockFireProof.class).setBlockTextureName(NovaCraft.find("polished_vanite_bricks"));	
		carved_vanite_bricks = registerItemBlock("carved_vanite_bricks", new BlockVaniteBuildingBlocks(), ItemBlockFireProof.class).setBlockTextureName(NovaCraft.find("carved_vanite_bricks"));		
		glowing_carved_vanite_bricks = registerItemBlock("glowing_carved_vanite_bricks", new BlockVaniteBuildingBlocks(), ItemBlockFireProof.class).setLightLevel(1.0F).setBlockTextureName(NovaCraft.find("glowing_carved_vanite_bricks"));		

		glow_torch = register("glow_torch", new BlockGlowTorch().setBlockTextureName(NovaCraft.find("glow_torch")));
		vanite_torch = register("vanite_torch", new BlockVaniteTorch().setBlockTextureName(NovaCraft.find("vanite_torch")));
		dim_vanite_torch = register("dim_vanite_torch", new BlockDimVaniteTorch().setBlockTextureName(NovaCraft.find("dim_vanite_torch")));
		
		if (!(Configs.enableNullstone) && !(Configs.enableDeepslateOreGeneration)) {
		stone_tophinite_ore = registerItemBlock("stone_tophinite_ore", new BlockStoneTophiniteOre(), ItemBlockFireProof.class).setBlockTextureName(NovaCraft.find("stone_tophinite_ore"));		
		}
		
		if (!(Configs.enableNullstone) && Loader.isModLoaded("etfuturum") && !(Configs.enableDeepslateOreGeneration)) {
		deepslate_tophinite_ore = registerItemBlock("deepslate_tophinite_ore", new BlockDeepslateTophiniteOre(), ItemBlockFireProof.class).setBlockTextureName(NovaCraft.find("deepslate_tophinite_ore"));			
		}
		
		nullstone_tophinite_ore = registerItemBlock("nullstone_tophinite_ore", new BlockNullstoneTophiniteOre(), ItemBlockFireProof.class).setBlockTextureName(NovaCraft.find("nullstone_tophinite_ore"));		
		nether_tophinite_ore = registerItemBlock("nether_tophinite_ore", new BlockNetherTophiniteOre(), ItemBlockFireProof.class).setBlockTextureName(NovaCraft.find("nether_tophinite_ore"));				
		block_of_tophinite = registerItemBlock("block_of_tophinite", new BlockTophinite(), ItemBlockFireProof.class);
		
		trap_tophinite = registerHidden("trap_tophinite", new BlockTrapTophinite());
		blazing_coal_block = register("blazing_coal_block", new BlockBlazingCoal().setBlockTextureName(NovaCraft.find("blazing_coal_block")));
		
		deepfire = registerHidden("deepfire", new BlockDeepFire().setCreativeTab(null));
		blazlinite_blend = register("blazlinite_blend", new BlockBlazliniteBlend().setBlockTextureName(NovaCraft.find("blazlinite_blend")));
		blazlinite = registerHidden("blazlinite", new BlockBlazlinite().setCreativeTab(null));
		vanite_cauldron = registerHidden("vanite_cauldron", new BlockVaniteCauldron().setCreativeTab(null));
		molten_vanite_cauldron = registerHidden("molten_vanite_cauldron", new BlockMoltenVaniteCauldron().setCreativeTab(null));
		molten_vanite_crystal_cauldron = registerHidden("molten_vanite_crystal_cauldron", new BlockMoltenVaniteCrystalCauldron().setCreativeTab(null));
		cracked_vanite_crystal_cauldron = registerHidden("cracked_vanite_crystal_cauldron", new BlockCrackedVaniteCauldron().setCreativeTab(null));
		
		crystallized_vanite = register("crystallized_vanite", new BlockCrystallizedVanite().setBlockTextureName(NovaCraft.find("crystallized_vanite")));
		vanite_cluster = registerMeta("vanite_cluster", new BlockVaniteCluster(0));
		nullified_vanite = register("nullified_vanite", new BlockCrystallizedVanite().setBlockTextureName(NovaCraft.find("nullified_vanite")));

		meteorite_block = registerItemBlock("meteorite_block", new BlockMeteorite(), ItemBlockFireProof.class);
		iridium_ore = registerItemBlock("iridium_ore", new BlockIridiumOre(), ItemBlockFireProof.class);	
		block_of_iridium = registerItemBlock("block_of_iridium", new BlockIridium(), ItemBlockFireProof.class);
		
		iron_pile = registerMeta("iron_pile", new BlockIronPile());
		gold_pile = registerMeta("gold_pile", new BlockGoldPile());
		lapis_pile = registerMeta("lapis_pile", new BlockLapisPile());
		emerald_pile = registerMeta("emerald_pile", new BlockEmeraldPile());
		diamond_pile = registerMeta("diamond_pile", new BlockDiamondPile());
		vanite_pile = registerMeta("vanite_pile", new BlockVanitePile());
		iridium_pile = registerMeta("iridium_pile", new BlockIridiumPile());
		crystal_pile = registerMeta("crystal_pile", new BlockCrystalPile());
		
		deepoid_bricks = registerItemBlock("deepoid_bricks", new BlockVaniteBuildingBlocks(), ItemBlockFireProof.class).setBlockTextureName(NovaCraft.find("deepoid_bricks"));
		deepoid_power_core = register("deepoid_power_core", new BlockDeepoidPowerCore().setLightLevel(0.9775F).setBlockTextureName(NovaCraft.find("deepoid_power_core")));		
		deepoid_furnace = register("deepoid_furnace", new BlockDeepoidFurnace(false).setBlockTextureName(NovaCraft.find("deepoid_furnace")));
		lit_deepoid_furnace = registerHidden("lit_deepoid_furnace", new BlockDeepoidFurnace(true).setLightLevel(0.9775F).setCreativeTab(null));
		
		deep_one_egg = register("deep_one_egg", new BlockDeepOneEgg().setBlockTextureName(NovaCraft.find("deep_one_egg")));
		deep_one_egg_activated = registerHidden("deep_one_egg_activated", new BlockDeepOneEggActivated().setBlockTextureName(NovaCraft.find("deep_one_egg_activated")));
		
		PETN = register("PETN", new BlockPETN());
		PETN_wire = registerHidden("PETN_wire", new BlockPETNWire().setBlockTextureName(NovaCraft.find("PETN_dust_block")));
		
		xancium_ore = register("xancium_ore", new BlockXanciumOre());
		block_of_xancium = register("block_of_xancium", new BlockXancium());
		xancium_TNT = register("xancium_TNT", new BlockXanciumTNT());
		xancium_wire = registerHidden("xancium_wire", new BlockXanciumWire().setBlockTextureName(NovaCraft.find("xancium_dust_cross")));
		
		if (!(Configs.enableNullstone) && !(Configs.enableDeepslateOreGeneration)) {
		stone_klangite_ore = registerItemBlock("stone_klangite_ore", new BlockStoneKlangiteOre(), ItemBlockFireProof.class);	
		}
		
		if (!(Configs.enableNullstone) && Loader.isModLoaded("etfuturum") && Configs.enableDeepslateOreGeneration) {
		deepslate_klangite_ore = registerItemBlock("deepslate_klangite_ore", new BlockDeepslateKlangiteOre(), ItemBlockFireProof.class);	
		}
		
		klangite_ore = registerItemBlock("klangite_ore", new BlockKlangiteOre(), ItemBlockFireProof.class);		
		end_klangite_ore = registerItemBlock("end_klangite_ore", new BlockEndKlangiteOre(), ItemBlockFireProof.class);
		frontierslate_klangite_ore = registerItemBlock("frontierslate_klangite_ore", new BlockFrontierslateKlangiteOre(), ItemBlockFireProof.class);
		block_of_raw_klangite = registerItemBlock("block_of_raw_klangite", new BlockRawKlangite(), ItemBlockFireProof.class);
		block_of_klangite = registerItemBlock("block_of_klangite", new BlockKlangite(), ItemBlockFireProof.class);

		if (Loader.isModLoaded("aether_legacy") && Configs.enableRawDivineral) {
			try {
				Item enchanted_divineral = GameRegistry.findItem("aether_legacy", "enchanted_divineral");
				if (enchanted_divineral != null) {
					raw_divineral = registerItemBlock("raw_divineral", new BlockRawDivineral(), ItemBlockFireProof.class);
				}
			} catch (Exception ex) {
				if (Configs.enableDebugMode) {
					System.out.println("Item not found, skipping...");
				}
			}
		}
		
		if (Loader.isModLoaded("etfuturum") && Configs.enableNetheriteInRecipes) {
			try {
				Block ancient_debris = GameRegistry.findBlock("etfuturum", "ancient_debris");
				if (ancient_debris != null) {
					raw_netherite = registerItemBlock("raw_netherite", new BlockRawNetherite(), ItemBlockFireProof.class);
				}
			} catch (Exception ex) {
				if (Configs.enableDebugMode) {
					System.out.println("Netherite from Et Futurum Requiem is missing, skipping Raw Netherite...");
				}
			}
		}
		
		//Sculk
		sculk_block = register("sculk_block", new BlockSculk());
		inked_sculk_block = register("inked_sculk_block", new BlockInkedSculk());	
		sculk_bricks = register("sculk_bricks", new BlockSculkBuildingBlocks().setBlockTextureName(NovaCraft.find("sculk_bricks")));
		cracked_sculk_bricks = register("cracked_sculk_bricks", new BlockSculkBuildingBlocks().setBlockTextureName(NovaCraft.find("cracked_sculk_bricks")));
		sculk_tiles = register("sculk_tiles", new BlockSculkBuildingBlocks().setBlockTextureName(NovaCraft.find("sculk_tiles")));
		cracked_sculk_tiles = register("cracked_sculk_tiles", new BlockSculkBuildingBlocks().setBlockTextureName(NovaCraft.find("cracked_sculk_tiles")));
		chiseled_sculk = register("chiseled_sculk", new BlockChiseledSculk());
		
		grimstone_shrieker = register("grimstone_shrieker", new BlockGrimstoneShrieker());
		activated_grimstone_shrieker = registerHidden("activated_grimstone_shrieker", new BlockActivatedGrimstoneShrieker());
		
		sculk_stone = register("sculk_stone", new BlockSculkStone());
		sculk_grimstone = register("sculk_grimstone", new BlockSculkGrimstone());
		sculk_nullstone = register("sculk_nullstone", new BlockSculkNullstone());
		sculk_endstone = register("sculk_endstone", new BlockSculkEndstone());
		
		unknown_portal = register("unknown_portal", new BlockUnknownPortal().setBlockTextureName(NovaCraft.find("unknown_portal")));
		unknown_portal_sealed = register("unknown_portal_sealed", new BlockUnknownPortalSealed().setBlockTextureName(NovaCraft.find("unknown_portal_sealed")));
		
		if (Loader.isModLoaded("etfuturum") && Configs.enableDeepslateOreGeneration) {
			try {
				Block deepslate = GameRegistry.findBlock("etfuturum", "deepslate");
				if (deepslate != null) {
					sculk_deepslate = register("sculk_deepslate", new BlockSculkDeepslate());
				}
			} catch (Exception ex) {
				if (Configs.enableDebugMode) {
					System.out.println("Deepslate from Et Futurum Requiem is missing, skipping Sculked Deepslate...");
				}
			}
		}
		
		deep_roots = register("deep_roots", new BlockDeepRoot().setBlockTextureName(NovaCraft.find("deep_roots")));
		
		sculk_vein = register("sculk_vein", new BlockSculkVein());
		sculk_growth = register("sculk_growth", new BlockSculkGrowth());
		sculk_tentacle_1 = registerMeta("sculk_tentacle_1", new BlockSculkTentacle(0));
		sculk_tentacle_2 = registerMeta("sculk_tentacle_2", new BlockSculkTentacle(1));
		sculk_bush = register("sculk_bush", new BlockSculkBush().setBlockTextureName(NovaCraft.find("sculk_bush")));		
		sculk_spike = registerMeta("sculk_spike", new BlockSculkSpike(0));
		sculk_sensor = registerMeta("sculk_sensor", new BlockSculkSensor().setBlockTextureName(NovaCraft.find("sculk_sensor")));
		sculk_bloom = register("sculk_bloom", new BlockSculkBloom(0));
		sculk_tendrils = register("sculk_tendrils", new BlockSculkTendrils(0));
		sculk_tulip = register("sculk_tulip", new BlockSculkTulip().setBlockTextureName(NovaCraft.find("sculk_tulip")));
		
		//Plants
		moss_block = registerMeta("moss_block", new BlockMoss().setBlockTextureName(NovaCraft.find("vibrant_moss_block")));
		moss_carpet = registerMeta("moss_carpet", new BlockMossCarpet().setBlockTextureName(NovaCraft.find("vibrant_moss_block")));
		arctic_moss_block = registerMeta("arctic_moss_block", new BlockArcticMoss().setBlockTextureName(NovaCraft.find("arctic_moss_block")));
		arctic_moss_carpet = registerMeta("arctic_moss_carpet", new BlockArcticMossCarpet().setBlockTextureName(NovaCraft.find("arctic_moss_block")));
		
		glow_lichen = registerMeta("glow_lichen", new BlockGlowLichen().setBlockTextureName(NovaCraft.find("glow_lichen")));
		grim_lichen = registerMeta("grim_lichen", new BlockGrimLichen().setBlockTextureName(NovaCraft.find("grim_lichen")));
		dark_lichen = registerMeta("dark_lichen", new BlockDarkLichen().setBlockTextureName(NovaCraft.find("dark_lichen")));	
		bright_lichen = registerMeta("bright_lichen", new BlockBrightLichen().setBlockTextureName(NovaCraft.find("bright_lichen")));
		
		rich_etherstone = register("rich_etherstone", new BlockRichEtherstone());
		rich_etherstone_spike = register("rich_etherstone_spike", new BlockRichEtherstoneSpike().setBlockTextureName(NovaCraft.find("rich_etherstone_spike")));
		cyan_rose = registerMeta("cyan_rose", new BlockOverworldFlower().setBlockTextureName(NovaCraft.find("cyan_rose")));
		purple_rose = registerMeta("purple_rose", new BlockOverworldFlower().setBlockTextureName(NovaCraft.find("purple_rose")));
		torchflower = registerMeta("torchflower", new BlockTorchFlower().setBlockTextureName(NovaCraft.find("torchflower")));		
		cosmos = registerMeta("cosmos", new BlockOverworldFlower().setBlockTextureName(NovaCraft.find("cosmos")));
		violet = registerMeta("violet", new BlockOverworldFlower().setBlockTextureName(NovaCraft.find("violet")));
		desert_bloom = registerMeta("desert_bloom", new BlockOverworldFlower().setBlockTextureName(NovaCraft.find("desert_bloom")));
		blooming_barb = registerMeta("blooming_barb", new BlockBloomingBarb().setBlockTextureName(NovaCraft.find("blooming_barb")));
		
		calvatia_mushroom = registerMeta("calvatia_mushroom", new BlockNovaCraftMushroom().setBlockTextureName(NovaCraft.find("calvatia_mushroom")));
		hydnum_mushroom = registerMeta("hydnum_mushroom", new BlockNovaCraftMushroom().setBlockTextureName(NovaCraft.find("hydnum_mushroom")));
		lentius_mushroom = registerMeta("lentius_mushroom", new BlockNovaCraftMushroom().setBlockTextureName(NovaCraft.find("lentius_mushroom")));
		rozite_mushroom = registerMeta("rozite_mushroom", new BlockNovaCraftMushroom().setBlockTextureName(NovaCraft.find("rozite_mushroom")));
		pleurotus_mushroom = registerMeta("pleurotus_mushroom", new BlockNovaCraftMushroom().setBlockTextureName(NovaCraft.find("pleurotus_mushroom")));
		
		null_wart = registerMetaHidden("null_wart", new BlockNullWart().setBlockTextureName(NovaCraft.find("null_wart")));
		nullwart_bricks = registerMeta("nullwart_bricks", new BlockNullwartBricks().setBlockTextureName(NovaCraft.find("nullwart_bricks")));
		flaming_nullwart_bricks = registerMetaHidden("flaming_nullwart_bricks", new BlockFlamingNullwartBricks().setBlockTextureName(NovaCraft.find("flaming_nullwart_bricks")));
		
		luminant_log = registerMeta("luminant_log", new BlockLuminantLog().setBlockTextureName(NovaCraft.find("luminant_log")));
		luminant_planks = registerMeta("luminant_planks", new BlockLuminantPlanks().setBlockTextureName(NovaCraft.find("luminant_planks")));
		
		if (Configs.enableLuminantLeavesGlow) {
			luminant_leaves = registerMeta("luminant_leaves", new BlockLuminantLeaves().setLightLevel(0.2775F).setBlockTextureName(NovaCraft.find("luminant_leaves")));
		} else {
			luminant_leaves = registerMeta("luminant_leaves", new BlockLuminantLeaves().setBlockTextureName(NovaCraft.find("luminant_leaves")));
		}
		
		luminant_sapling = registerMeta("luminant_sapling", new BlockLuminantSapling(new LuminantTreeGen(NovaCraftBlocks.luminant_leaves, NovaCraftBlocks.luminant_leaves, 50, 5, true)).setBlockTextureName(NovaCraft.find("luminant_sapling")));
		
		flaming_pitcher_bottom = registerMeta("flaming_pitcher_bottom", new BlockFlamingPitcherBottom().setBlockTextureName(NovaCraft.find("flaming_pitcher")));
		flaming_pitcher_top = registerMetaHidden("flaming_pitcher_top", new BlockFlamingPitcherTop().setBlockTextureName(NovaCraft.find("pitcher_top"))).setCreativeTab(null);
		hell_piliz = registerMeta("hell_piliz", new BlockHellPiliz().setBlockTextureName(NovaCraft.find("hell_piliz")));
		deepoid_mushroom = registerMeta("deepoid_mushroom", new BlockDeepoidMushroom().setBlockTextureName(NovaCraft.find("deepoid_mushroom")));
		ion_mushroom = registerMeta("ion_mushroom", new BlockIonMushroom().setBlockTextureName(NovaCraft.find("ion_mushroom")));
		
		chorus_grass = registerMeta("chorus_grass", new BlockChorusGrass().setBlockTextureName(NovaCraft.find("chorus_grass")));
		void_sprout = registerMeta("void_sprout", new BlockVoidSprout().setBlockTextureName(NovaCraft.find("void_sprout")));
		shadow_bloom = registerMeta("shadow_bloom", new BlockShadowBloom().setBlockTextureName(NovaCraft.find("shadow_bloom")));
		
		destitude_growth = register("destitude_growth", new BlockDestitudeGrowth());
		destitude_block = register("destitude_block", new BlockDestitude());
		destitude_bloom = register("destitude_bloom", new BlockDestitudeBloom().setBlockTextureName(NovaCraft.find("destitute_bloom")));
		destitude_vein = register("destitude_vein", new BlockDestituteVein());
		
		living_ender = register("living_ender", new BlockLivingEnder());
		ender_fungus_block = register("ender_fungus_block", new BlockEnderFungusBlock());
		ender_fungus_stem = register("ender_fungus_stem", new BlockEnderFungusStem());
		dark_lotus = registerMeta("dark_lotus", new BlockDarkLotus().setBlockTextureName(NovaCraft.find("dark_lotus")));
		ender_sprout = registerMeta("ender_sprout", new BlockEnderBloom().setBlockTextureName(NovaCraft.find("ender_sprout")));
		ender_fungus = registerMeta("ender_fungus", new BlockEnderFungus().setBlockTextureName(NovaCraft.find("ender_fungus")));
		ender_brain = registerMeta("ender_brain", new BlockEnderBrain().setBlockTextureName(NovaCraft.find("ender_brain")));
		
		lacuna_fruit = registerMeta("lacuna_fruit", new BlockLacunaFruit().setBlockTextureName(NovaCraft.find("lacuna_fruit")));
		lacuna_log = registerMeta("lacuna_log", new BlockLacunaLog());
		lacuna_planks = registerMeta("lacuna_planks", new BlockLacunaPlanks().setBlockTextureName(NovaCraft.find("lacuna_planks")));
		
		nullcube_slime_block = registerMeta("nullcube_slime_block", new BlockNullcubeSlime().setBlockTextureName(NovaCraft.find("nullcube_slime_block")));
			
		//Blocks With GUIS
		advanced_smithing_table = registerMetaHidden("advanced_smithing_table", new BlockAdvancedSmithingTable());
		treasure_chest = register("treasure_chest", new BlockTreasureChest());
		flooded_chest = register("flooded_chest", new BlockFloodedChest());
		mineshaft_chest = register("mineshaft_chest", new BlockMineshaftChest());
		nether_chest = register("nether_chest", new BlockNetherChest());
		sculk_chest = register("sculk_chest", new BlockSculkChest());
		unbreakable_ancient_chest = registerHidden("unbreakable_ancient_chest", new BlockUnbreakableAncientChest(0));
		ancient_chest = register("ancient_chest", new BlockAncientChest(0));
		advanced_enchantment_table = register("advanced_enchantment_table", new BlockAdvancedEnchantmentTable());
		legendary_beacon = register("legendary_beacon", new BlockLegendaryBeacon());
		legendary_enchantment_table = register("legendary_enchantment_table", new BlockLegendaryEnchantmentTable());
		
		nullwart_brick_bookshelf = register("nullwart_brick_bookshelf", new BlockNullwartBrickBookshelf());
		sculk_brick_bookshelf = register("sculk_brick_bookshelf", new BlockSculkBrickBookshelf());
		
		//Crystals
		cracked_copartz_block = register("cracked_copartz_block", new BlockCopartz().setBlockTextureName(NovaCraft.find("cracked_copartz_block")));
		copartz_block = register("copartz_block", new BlockCopartz().setBlockTextureName(NovaCraft.find("copartz_block")));
		budding_copartz_block = register("budding_copartz_block", new BlockBuddingCopartz().setBlockTextureName(NovaCraft.find("budding_copartz")));
		copartz_cluster_1 = registerItemBlock("copartz_cluster_1", new BlockCopartzCluster(0), ItemCopartzCluster.class);
		copartz_cluster_2 = registerItemBlock("copartz_cluster_2", new BlockCopartzCluster(1), ItemCopartzCluster.class);
		
		cracked_larimar_block = register("cracked_larimar_block", new BlockLarimar().setBlockTextureName(NovaCraft.find("cracked_larimar_block")));
		larimar_block = register("larimar_block", new BlockLarimar().setBlockTextureName(NovaCraft.find("larimar_block")));
		budding_larimar_block = register("budding_larimar_block", new BlockBuddingLarimar().setBlockTextureName(NovaCraft.find("budding_larimar")));
		larimar_cluster_1 = registerItemBlock("larimar_cluster_1", new BlockLarimarCluster(0), ItemLarimarCluster.class);
		larimar_cluster_2 = registerItemBlock("larimar_cluster_2", new BlockLarimarCluster(1), ItemLarimarCluster.class);
		
		cracked_tsavorokite_block = register("cracked_tsavorokite_block", new BlockTsavorokite().setBlockTextureName(NovaCraft.find("cracked_tsavorokite_block")));
		tsavorokite_block = register("tsavorokite_block", new BlockTsavorokite().setBlockTextureName(NovaCraft.find("tsavorokite_block")));
		budding_tsavorokite_block = register("budding_tsavorokite_block", new BlockBuddingTsavorokite().setBlockTextureName(NovaCraft.find("budding_tsavorokite_block")));
		tsavorokite_cluster_1 = registerItemBlock("tsavorokite_cluster_1", new BlockTsavorokiteCluster(0), ItemTsavorokiteCluster.class);
		tsavorokite_cluster_2 = registerItemBlock("tsavorokite_cluster_2", new BlockTsavorokiteCluster(1), ItemTsavorokiteCluster.class);
		
		cracked_yttrlinsite_block = register("cracked_yttrlinsite_block", new BlockYttrlinsite().setBlockTextureName(NovaCraft.find("cracked_yttrlinsite_block")));
		yttrlinsite_block = register("yttrlinsite_block", new BlockYttrlinsite().setBlockTextureName(NovaCraft.find("yttrlinsite_block")));
		budding_yttrlinsite_block = register("budding_yttrlinsite_block", new BlockBuddingYttrlinsite().setBlockTextureName(NovaCraft.find("budding_yttrlinsite")));
		yttrlinsite_cluster_1 = registerItemBlock("yttrlinsite_cluster_1", new BlockYttrlinsiteCluster(0), ItemYttrlinsiteCluster.class);
		yttrlinsite_cluster_2 = registerItemBlock("yttrlinsite_cluster_2", new BlockYttrlinsiteCluster(1), ItemYttrlinsiteCluster.class);
		
		cracked_aether_block = register("cracked_aether_block", new BlockAether().setBlockTextureName(NovaCraft.find("cracked_block_of_aether")));
		aether_block = register("aether_block", new BlockAether().setBlockTextureName(NovaCraft.find("block_of_aether")));
		budding_aether_block = register("budding_aether_block", new BlockBuddingAether().setBlockTextureName(NovaCraft.find("budding_aether")));
		aether_cluster_1 = registerItemBlock("aether_cluster_1", new BlockAetherCluster(0), ItemAetherCluster.class);
		aether_cluster_2 = registerItemBlock("aether_cluster_2", new BlockAetherCluster(1), ItemAetherCluster.class);
		
		variegated_block = register("variegated_block", new BlockVariegatedShard().setBlockTextureName(NovaCraft.find("block_of_variegated_shard")));
		
		echo_block = register("echo_block", new BlockEcho());
		budding_echo_block = register("budding_echo_block", new BlockBuddingEcho());
		echo_cluster_1 = registerItemBlock("echo_cluster_1", new BlockEchoCluster(0), ItemEchoCluster.class);
		echo_cluster_2 = registerItemBlock("echo_cluster_2", new BlockEchoCluster(1), ItemEchoCluster.class);
		
		crystallized_sculk = register("crystallized_sculk", new BlockAether().setBlockTextureName(NovaCraft.find("crystallized_sculk")));
		
		null_block = register("null_block", new BlockNull().setBlockTextureName(NovaCraft.find("block_of_null")));
		budding_null_block = register("budding_null_block", new BlockBuddingNull().setBlockTextureName(NovaCraft.find("budding_null")));
		null_cluster_1 = registerItemBlock("null_cluster_1", new BlockNullCluster(0), ItemNullCluster.class);
		null_cluster_2 = registerItemBlock("null_cluster_2", new BlockNullCluster(1), ItemNullCluster.class);
		
		//Stalagmites and Stalactites
		pherithium_ore = registerHidden("pherithium_ore", new BlockPherithiumOre().setBlockTextureName(NovaCraft.find("pherithium_ore")));
		large_pherithium_stalagmite = register("large_pherithium_stalagmite", new BlockLargePherithiumStalagmite().setBlockTextureName(NovaCraft.find("pherithium_stalagmite_large")));
		small_pherithium_stalagmite = register("small_pherithium_stalagmite", new BlockSmallPherithiumStalagmite().setBlockTextureName(NovaCraft.find("small_pherithium_stalagmite")));
		block_of_pherithium = register("block_of_pherithium", new BlockPherithium().setBlockTextureName(NovaCraft.find("block_of_pherithium")));
		pherithium_glass = register("pherithium_glass", new BlockPherithiumGlass(Material.glass, false).setBlockTextureName(NovaCraft.find("pherithium_glass")));
		
		stone_stalagmite = register("stone_stalagmite", new BlockStoneStalagmite().setBlockTextureName(NovaCraft.find("stone_stalagmite")));
		stone_stalactite = register("stone_stalactite", new BlockStoneStalactite().setBlockTextureName(NovaCraft.find("stone_stalactite")));
		large_stone_stalagmite = register("large_stone_stalagmite", new BlockLargeStoneStalagmite().setBlockTextureName(NovaCraft.find("large_stone_stalagmite")));
		large_stone_stalactite = register("large_stone_stalactite", new BlockLargeStoneStalactite().setBlockTextureName(NovaCraft.find("large_stone_stalactite")));		
		nullstone_stalagmite = register("nullstone_stalagmite", new BlockNullstoneStalagmite().setBlockTextureName(NovaCraft.find("nullstone_stalagmite")));
		nullstone_stalactite = register("nullstone_stalactite", new BlockNullstoneStalactite().setBlockTextureName(NovaCraft.find("nullstone_stalactite")));		
		large_nullstone_stalagmite = register("large_nullstone_stalagmite", new BlockLargeNullstoneStalagmite().setBlockTextureName(NovaCraft.find("large_nullstone_stalagmite")));
		large_nullstone_stalactite = register("large_nullstone_stalactite", new BlockLargeNullstoneStalactite().setBlockTextureName(NovaCraft.find("large_nullstone_stalactite")));
		icicle = register("icicle", new BlockIcicle().setBlockTextureName(NovaCraft.find("icicle")));
		
		//Stairs
		grimstone_stairs = register("grimstone_stairs", new BlockNovaCraftStairs(grimstone));
		cobbled_grimstone_stairs = register("cobbled_grimstone_stairs", new BlockNovaCraftStairs(cobbled_grimstone));
		grimstone_brick_stairs = register("grimstone_brick_stairs", new BlockNovaCraftStairs(grimstone_bricks));
		grimstone_tiled_stairs = register("grimstone_tiled_stairs", new BlockNovaCraftStairs(grimstone_tiles));		
		
		nullstone_stairs = register("nullstone_stairs", new BlockNovaCraftStairs(nullstone));
		cobbled_nullstone_stairs = register("cobbled_nullstone_stairs", new BlockNovaCraftStairs(cobbled_nullstone));
		nullstone_brick_stairs = register("nullstone_brick_stairs", new BlockNovaCraftStairs(nullstone_bricks));
		nullstone_tiled_stairs = register("nullstone_tiled_stairs", new BlockNovaCraftStairs(nullstone_tiles));
		
		etherstone_stairs = register("etherstone_stairs", new BlockNovaCraftStairs(etherstone));
		cobbled_etherstone_stairs = register("cobbled_etherstone_stairs", new BlockNovaCraftStairs(cobbled_etherstone));
		etherstone_brick_stairs = register("etherstone_brick_stairs", new BlockNovaCraftStairs(etherstone_bricks));
		etherstone_tiled_stairs = register("etherstone_tiled_stairs", new BlockNovaCraftStairs(etherstone_tiles));
		
		basal_stairs = register("basal_stairs", new BlockNovaCraftStairs(basal));
		basal_brick_stairs = register("basal_brick_stairs", new BlockNovaCraftStairs(basal_bricks));

		if (Loader.isModLoaded("etfuturum")) {
			try {
				Block tuff = GameRegistry.findBlock("etfuturum", "tuff");
				if (tuff != null) {
					tuff_brick_stairs = register("tuff_brick_stairs", new BlockNovaCraftStairs(tuff_bricks));
					tuff_tiled_stairs = register("tuff_tiled_stairs", new BlockNovaCraftStairs(tuff_tiles));
				}
			} catch (Exception ex) {
				if (Configs.enableDebugMode) {
					System.out.println("Tuff from Et Futurum Requiem is missing, skipping Tuff Building Blocks...");
				}
			}
		}

		if (Loader.isModLoaded("etfuturum")) {
			try {
				Block calcite = GameRegistry.findBlock("etfuturum", "calcite");
				if (calcite != null) {
					calcite_brick_stairs = register("calcite_brick_stairs", new BlockNovaCraftStairs(calcite_bricks));
					calcite_tiled_stairs = register("calcite_tiled_stairs", new BlockNovaCraftStairs(calcite_tiles));
				}
			} catch (Exception ex) {
				if (Configs.enableDebugMode) {
					System.out.println("Calcite from Et Futurum Requiem is missing, skipping Calcite Building Blocks...");
				}
			}
		}
		
		sculk_brick_stairs = register("sculk_brick_stairs", new BlockNovaCraftStairs(sculk_bricks));
		sculk_tiled_stairs = register("sculk_tiled_stairs", new BlockNovaCraftStairs(sculk_tiles));
		
		frontierslate_stairs = register("frontierslate_stairs", new BlockNovaCraftStairs(frontierslate));
		frontierslate_brick_stairs = register("frontierslate_brick_stairs", new BlockNovaCraftStairs(frontierslate_bricks));
		
		nullwart_brick_stairs = register("nullwart_brick_stairs", new BlockNovaCraftStairs(nullwart_bricks));
		vanite_brick_stairs = register("vanite_brick_stairs", new BlockNovaCraftStairs(vanite_bricks));
		carved_vanite_brick_stairs = register("carved_vanite_brick_stairs", new BlockNovaCraftStairs(carved_vanite_bricks));
		
		luminant_stairs = register("luminant_stairs", new BlockNovaCraftStairs(luminant_planks));
		lacuna_stairs = register("lacuna_stairs", new BlockNovaCraftStairs(lacuna_planks));
		
		
		//Walls
		grimstone_wall = register("grimstone_wall", new BlockNovaCraftWall(grimstone));
		cobbled_grimstone_wall = register("cobbled_grimstone_wall", new BlockNovaCraftWall(cobbled_grimstone));
		grimstone_brick_wall = register("grimstone_brick_wall", new BlockNovaCraftWall(grimstone_bricks));
		grimstone_tiled_wall = register("grimstone_tiled_wall", new BlockNovaCraftWall(grimstone_tiles));
		
		nullstone_wall = register("nullstone_wall", new BlockNovaCraftWall(nullstone));
		cobbled_nullstone_wall = register("cobbled_nullstone_wall", new BlockNovaCraftWall(cobbled_nullstone));
		nullstone_brick_wall = register("nullstone_brick_wall", new BlockNovaCraftWall(nullstone_bricks));
		nullstone_tiled_wall = register("nullstone_tiled_wall", new BlockNovaCraftWall(nullstone_tiles));
		
		etherstone_wall = register("etherstone_wall", new BlockNovaCraftWall(etherstone));
		cobbled_etherstone_wall = register("cobbled_etherstone_wall", new BlockNovaCraftWall(cobbled_etherstone));
		etherstone_brick_wall = register("etherstone_brick_wall", new BlockNovaCraftWall(etherstone_bricks));
		etherstone_tiled_wall = register("etherstone_tiled_wall", new BlockNovaCraftWall(etherstone_tiles));
		
		basal_wall = register("basal_wall", new BlockNovaCraftWall(basal));
		basal_brick_wall = register("basal_brick_wall", new BlockNovaCraftWall(basal_bricks));
		
		sculk_brick_wall = register("sculk_brick_wall", new BlockNovaCraftWall(sculk_bricks));
		sculk_tiled_wall = register("sculk_tiled_wall", new BlockNovaCraftWall(sculk_tiles));

		if (Loader.isModLoaded("etfuturum")) {
			try {
				Block tuff = GameRegistry.findBlock("etfuturum", "tuff");
				if (tuff != null) {
					tuff_brick_wall = register("tuff_brick_wall", new BlockNovaCraftWall(tuff_bricks));
					tuff_tiled_wall = register("tuff_tiled_wall", new BlockNovaCraftWall(tuff_tiles));
				}
			} catch (Exception ex) {
				if (Configs.enableDebugMode) {
					System.out.println("Tuff from Et Futurum Requiem is missing, skipping Tuff Building Blocks...");
				}
			}
		}

		if (Loader.isModLoaded("etfuturum")) {
			try {
				Block calcite = GameRegistry.findBlock("etfuturum", "calcite");
				if (calcite != null) {
					calcite_brick_wall = register("calcite_brick_wall", new BlockNovaCraftWall(calcite_bricks));
					calcite_tiled_wall = register("calcite_tiled_wall", new BlockNovaCraftWall(calcite_tiles));
				}
			} catch (Exception ex) {
				if (Configs.enableDebugMode) {
					System.out.println("Calcite from Et Futurum Requiem is missing, skipping Calcite Building Blocks...");
				}
			}
		}
		
		frontierslate_wall = register("frontierslate_wall", new BlockNovaCraftWall(frontierslate));
		frontierslate_brick_wall = register("frontierslate_brick_wall", new BlockNovaCraftWall(frontierslate_bricks));
		
		nullwart_brick_wall = register("nullwart_brick_wall", new BlockNovaCraftWall(nullwart_bricks));
		vanite_brick_wall = register("vanite_brick_wall", new BlockNovaCraftWall(vanite_bricks));
		carved_vanite_brick_wall = register("carved_vanite_brick_wall", new BlockNovaCraftWall(carved_vanite_bricks));
		
		//Slabs
		grimstone_double_slab = register("grimstone_double_slab", new BlocksNovaCraftSlab("grimstone_double_slab", true, Material.rock).setBlockTextureName(NovaCraft.find("grimstonenew_top")).setHardness(3.0F).setResistance(6.0F)).setCreativeTab(null);
		grimstone_slab = registerSlab("grimstone_slab", new BlocksNovaCraftSlab("grimstone_slab", false, Material.rock).setBlockTextureName(NovaCraft.find("grimstonenew_top")).setHardness(3.0F).setResistance(6.0F), grimstone_double_slab);		
		cobbled_grimstone_double_slab = register("cobbled_grimstone_double_slab", new BlocksNovaCraftSlab("cobbled_grimstone_double_slab", true, Material.rock).setBlockTextureName(NovaCraft.find("cobbled_grimstone")).setHardness(3.0F).setResistance(6.0F)).setCreativeTab(null);
		cobbled_grimstone_slab = registerSlab("cobbled_grimstone_slab", new BlocksNovaCraftSlab("cobbled_grimstone_slab", false, Material.rock).setBlockTextureName(NovaCraft.find("cobbled_grimstone")).setHardness(3.0F).setResistance(6.0F), cobbled_grimstone_double_slab);		
		grimstone_brick_double_slab = register("grimstone_brick_double_slab", new BlocksNovaCraftSlab("grimstone_brick_double_slab", true, Material.rock).setBlockTextureName(NovaCraft.find("grimstone_bricks")).setHardness(3.0F).setResistance(6.0F)).setCreativeTab(null);
		grimstone_brick_slab = registerSlab("grimstone_brick_slab", new BlocksNovaCraftSlab("grimstone_brick_slab", false, Material.rock).setBlockTextureName(NovaCraft.find("grimstone_bricks")).setHardness(3.0F).setResistance(6.0F), grimstone_brick_double_slab);		
		grimstone_tiled_double_slab = register("grimstone_tiled_double_slab", new BlocksNovaCraftSlab("grimstone_tiled_double_slab", true, Material.rock).setBlockTextureName(NovaCraft.find("grimstone_tiles")).setHardness(3.0F).setResistance(6.0F)).setCreativeTab(null);
		grimstone_tiled_slab = registerSlab("grimstone_tiled_slab", new BlocksNovaCraftSlab("grimstone_tiled_slab", false, Material.rock).setBlockTextureName(NovaCraft.find("grimstone_tiles")).setHardness(3.0F).setResistance(6.0F), grimstone_tiled_double_slab);
			
		cobbled_nullstone_double_slab = register("cobbled_nullstone_double_slab", new BlocksNovaCraftSlab("cobbled_nullstone_double_slab", true, Material.rock).setBlockTextureName(NovaCraft.find("cobbled_nullstone")).setHardness(5.0F).setResistance(12.0F)).setCreativeTab(null);
		cobbled_nullstone_slab = registerSlab("cobbled_nullstone_slab", new BlocksNovaCraftSlab("cobbled_nullstone_slab", false, Material.rock).setBlockTextureName(NovaCraft.find("cobbled_nullstone")).setHardness(5.0F).setResistance(12.0F), cobbled_nullstone_double_slab);		
		nullstone_double_slab = register("nullstone_double_slab", new BlocksNovaCraftSlab("nullstone_double_slab", true, Material.rock).setBlockTextureName(NovaCraft.find("nullstone")).setHardness(5.0F).setResistance(12.0F)).setCreativeTab(null);
		nullstone_slab = registerSlab("nullstone_slab", new BlocksNovaCraftSlab("nullstone_slab", false, Material.rock).setBlockTextureName(NovaCraft.find("nullstone")).setHardness(5.0F).setResistance(12.0F), nullstone_double_slab);		
		nullstone_brick_double_slab = register("nullstone_brick_double_slab", new BlocksNovaCraftSlab("nullstone_brick_double_slab", true, Material.rock).setBlockTextureName(NovaCraft.find("nullstone_bricks")).setHardness(5.0F).setResistance(12.0F)).setCreativeTab(null);
		nullstone_brick_slab = registerSlab("nullstone_brick_slab", new BlocksNovaCraftSlab("nullstone_brick_slab", false, Material.rock).setBlockTextureName(NovaCraft.find("nullstone_bricks")).setHardness(5.0F).setResistance(12.0F), nullstone_brick_double_slab);
		nullstone_tiled_double_slab = register("nullstone_tiled_double_slab", new BlocksNovaCraftSlab("nullstone_tiled_double_slab", true, Material.rock).setBlockTextureName(NovaCraft.find("nullstone_tiles")).setHardness(5.0F).setResistance(12.0F)).setCreativeTab(null);
		nullstone_tiled_slab = registerSlab("nullstone_tiled_slab", new BlocksNovaCraftSlab("nullstone_tiled_slab", false, Material.rock).setBlockTextureName(NovaCraft.find("nullstone_tiles")).setHardness(5.0F).setResistance(12.0F), nullstone_tiled_double_slab);
		
		nullwart_brick_double_slab = register("nullwart_brick_double_slab", new BlocksNovaCraftSlab("nullwart_brick_double_slab", true, Material.rock).setBlockTextureName(NovaCraft.find("nullwart_brick")).setHardness(1.5F).setResistance(3.0F)).setCreativeTab(null);
		nullwart_brick_slab = registerSlab("nullwart_brick_slab", new BlocksNovaCraftSlab("nullwart_brick_slab", false, Material.rock).setBlockTextureName(NovaCraft.find("nullwart_brick")).setHardness(1.5F).setResistance(3.0F), nullwart_brick_double_slab);
		
		basal_double_slab = register("basal_double_slab", new BlocksNovaCraftSlab("basal_double_slab", true, Material.rock).setBlockTextureName(NovaCraft.find("basal")).setHardness(1.5F).setResistance(12.0F)).setCreativeTab(null);
		basal_slab = registerSlab("basal_slab", new BlocksNovaCraftSlab("basal_slab", false, Material.rock).setBlockTextureName(NovaCraft.find("basal")).setHardness(1.5F).setResistance(12.0F), basal_double_slab);		
		basal_brick_double_slab = register("basal_brick_double_slab", new BlocksNovaCraftSlab("basal_brick_double_slab", true, Material.rock).setBlockTextureName(NovaCraft.find("basal_bricks")).setHardness(1.5F).setResistance(12.0F)).setCreativeTab(null);
		basal_brick_slab = registerSlab("basal_brick_slab", new BlocksNovaCraftSlab("basal_brick_slab", false, Material.rock).setBlockTextureName(NovaCraft.find("basal_bricks")).setHardness(1.5F).setResistance(12.0F), basal_brick_double_slab);
		
		vanite_brick_double_slab = register("vanite_brick_double_slab", new BlocksNovaCraftSlab("vanite_brick_double_slab", true, Material.rock).setBlockTextureName(NovaCraft.find("vanite_bricks")).setHardness(3.5F).setResistance(3.0F)).setCreativeTab(null);
		vanite_brick_slab = registerSlab("vanite_brick_slab", new BlocksNovaCraftSlab("vanite_brick_slab", false, Material.rock).setBlockTextureName(NovaCraft.find("vanite_bricks")).setHardness(1.5F).setResistance(6.0F), vanite_brick_double_slab);
		
		carved_vanite_brick_double_slab = register("carved_vanite_brick_double_slab", new BlocksNovaCraftSlab("carved_vanite_brick_double_slab", true, Material.rock).setBlockTextureName(NovaCraft.find("carved_vanite_bricks")).setHardness(3.5F).setResistance(6.0F)).setCreativeTab(null);
		carved_vanite_brick_slab = registerSlab("carved_vanite_brick_slab", new BlocksNovaCraftSlab("carved_vanite_brick_slab", false, Material.rock).setBlockTextureName(NovaCraft.find("carved_vanite_bricks")).setHardness(3.5F).setResistance(6.0F), carved_vanite_brick_double_slab);
					
		luminant_double_slab = register("luminant_double_slab", new BlocksNovaCraftSlab("luminant_double_slab", true, Material.wood).setBlockTextureName(NovaCraft.find("luminant_planks")).setHardness(3.0F).setResistance(1.5F)).setCreativeTab(null);
		luminant_slab = registerSlab("luminant_slab", new BlocksNovaCraftSlab("luminant_slab", false, Material.wood).setBlockTextureName(NovaCraft.find("luminant_planks")).setHardness(3.0F).setResistance(1.5F), luminant_double_slab);
		
		lacuna_double_slab = register("lacuna_double_slab", new BlocksNovaCraftSlab("lacuna_double_slab", true, Material.wood).setBlockTextureName(NovaCraft.find("lacuna_planks")).setHardness(3.0F).setResistance(1.0F)).setCreativeTab(null);
		lacuna_slab = registerSlab("lacuna_slab", new BlocksNovaCraftSlab("lacuna_slab", false, Material.wood).setBlockTextureName(NovaCraft.find("lacuna_planks")).setHardness(3.0F).setResistance(1.0F), lacuna_double_slab);
		
		sculk_brick_double_slab = register("sculk_brick_double_slab", new BlocksNovaCraftSlab("sculk_brick_double_slab", true, Material.rock).setBlockTextureName(NovaCraft.find("sculk_bricks")).setHardness(3.0F).setResistance(6.0F)).setCreativeTab(null);
		sculk_brick_slab = registerSlab("sculk_brick_slab", new BlocksNovaCraftSlab("sculk_brick_slab", false, Material.rock).setBlockTextureName(NovaCraft.find("sculk_bricks")).setHardness(3.0F).setResistance(6.0F), sculk_brick_double_slab);
		sculk_tiled_double_slab = register("sculk_tiled_double_slab", new BlocksNovaCraftSlab("sculk_tiled_double_slab", true, Material.rock).setBlockTextureName(NovaCraft.find("sculk_tiles")).setHardness(3.0F).setResistance(6.0F)).setCreativeTab(null);
		sculk_tiled_slab = registerSlab("sculk_tiled_slab", new BlocksNovaCraftSlab("sculk_tiled_slab", false, Material.rock).setBlockTextureName(NovaCraft.find("sculk_tiles")).setHardness(3.0F).setResistance(6.0F), sculk_tiled_double_slab);

		if (Loader.isModLoaded("etfuturum")) {
			try {
				Block tuff = GameRegistry.findBlock("etfuturum", "tuff");
				if (tuff != null) {
					tuff_brick_double_slab = register("tuff_brick_double_slab", new BlocksNovaCraftSlab("tuff_brick_double_slab", true, Material.rock).setBlockTextureName(NovaCraft.find("tuff_bricks")).setHardness(0.75F).setResistance(1.0F)).setCreativeTab(null);
					tuff_brick_slab = registerSlab("tuff_brick_slab", new BlocksNovaCraftSlab("tuff_brick_slab", false, Material.rock).setBlockTextureName(NovaCraft.find("tuff_bricks")).setHardness(0.75F).setResistance(1.0F), tuff_brick_double_slab);
					tuff_tiled_double_slab = register("tuff_tiled_double_slab", new BlocksNovaCraftSlab("tuff_tiled_double_slab", true, Material.rock).setBlockTextureName(NovaCraft.find("tuff_tiles")).setHardness(0.75F).setResistance(1.0F)).setCreativeTab(null);
					tuff_tiled_slab = registerSlab("tuff_tiled_slab", new BlocksNovaCraftSlab("tuff_tiled_slab", false, Material.rock).setBlockTextureName(NovaCraft.find("tuff_tiles")).setHardness(0.75F).setResistance(1.0F), tuff_tiled_double_slab);
				}
			} catch (Exception ex) {
				if (Configs.enableDebugMode) {
					System.out.println("Tuff from Et Futurum Requiem is missing, skipping Tuff Building Blocks...");
				}
			}
		}

		if (Loader.isModLoaded("etfuturum")) {
			try {
				Block calcite = GameRegistry.findBlock("etfuturum", "calcite");
				if (calcite != null) {
					calcite_brick_double_slab = register("calcite_brick_double_slab", new BlocksNovaCraftSlab("calcite_brick_double_slab", true, Material.rock).setBlockTextureName(NovaCraft.find("calcite_bricks")).setHardness(0.75F).setResistance(2.0F)).setCreativeTab(null);
					calcite_brick_slab = registerSlab("calcite_brick_slab", new BlocksNovaCraftSlab("calcite_brick_slab", false, Material.rock).setBlockTextureName(NovaCraft.find("calcite_bricks")).setHardness(0.75F).setResistance(2.0F), calcite_brick_double_slab);
					calcite_tiled_double_slab = register("calcite_tiled_double_slab", new BlocksNovaCraftSlab("calcite_tiled_double_slab", true, Material.rock).setBlockTextureName(NovaCraft.find("calcite_tiles")).setHardness(0.75F).setResistance(2.0F)).setCreativeTab(null);
					calcite_tiled_slab = registerSlab("calcite_tiled_slab", new BlocksNovaCraftSlab("calcite_tiled_slab", false, Material.rock).setBlockTextureName(NovaCraft.find("calcite_tiles")).setHardness(0.75F).setResistance(2.0F), calcite_tiled_double_slab);
				}
			} catch (Exception ex) {
				if (Configs.enableDebugMode) {
					System.out.println("Calcite from Et Futurum Requiem is missing, skipping Calcite Building Blocks...");
				}
			}
		}
		
		etherstone_double_slab = register("etherstone_double_slab", new BlocksNovaCraftSlab("etherstone_double_slab", true, Material.rock).setBlockTextureName(NovaCraft.find("etherstone_top")).setHardness(2.0F).setResistance(3.0F)).setCreativeTab(null);
		etherstone_slab = registerSlab("etherstone_slab", new BlocksNovaCraftSlab("etherstone_slab", false, Material.rock).setBlockTextureName(NovaCraft.find("etherstone_top")).setHardness(2.0F).setResistance(3.0F), etherstone_double_slab);		
		cobbled_etherstone_double_slab = register("cobbled_etherstone_double_slab", new BlocksNovaCraftSlab("cobbled_etherstone_double_slab", true, Material.rock).setBlockTextureName(NovaCraft.find("cobbbled_etherstone")).setHardness(2.0F).setResistance(3.0F)).setCreativeTab(null);
		cobbled_etherstone_slab = registerSlab("cobbled_etherstone_slab", new BlocksNovaCraftSlab("cobbled_etherstone_slab", false, Material.rock).setBlockTextureName(NovaCraft.find("cobbbled_etherstone")).setHardness(2.0F).setResistance(3.0F), cobbled_etherstone_double_slab);		
		etherstone_brick_double_slab = register("etherstone_brick_double_slab", new BlocksNovaCraftSlab("etherstone_brick_double_slab", true, Material.rock).setBlockTextureName(NovaCraft.find("etherstone_bricks")).setHardness(2.0F).setResistance(3.0F)).setCreativeTab(null);
		etherstone_brick_slab = registerSlab("etherstone_brick_slab", new BlocksNovaCraftSlab("etherstone_brick_slab", false, Material.rock).setBlockTextureName(NovaCraft.find("etherstone_bricks")).setHardness(2.0F).setResistance(3.0F), etherstone_brick_double_slab);			
		etherstone_tiled_double_slab = register("etherstone_tiled_double_slab", new BlocksNovaCraftSlab("etherstone_tiled_double_slab", true, Material.rock).setBlockTextureName(NovaCraft.find("etherstone_tiles")).setHardness(2.0F).setResistance(3.0F)).setCreativeTab(null);
		etherstone_tiled_slab = registerSlab("etherstone_tiled_slab", new BlocksNovaCraftSlab("etherstone_tiled_slab", false, Material.rock).setBlockTextureName(NovaCraft.find("etherstone_tiles")).setHardness(2.0F).setResistance(3.0F), etherstone_tiled_double_slab);	
		
		
		frontierslate_double_slab = register("frontierslate_double_slab", new BlocksNovaCraftSlab("frontierslate_double_slab", true, Material.rock).setBlockTextureName(NovaCraft.find("frontierslate")).setHardness(8.0F).setResistance(15.0F)).setCreativeTab(null);
		frontierslate_slab = registerSlab("frontierslate_slab", new BlocksNovaCraftSlab("frontierslate_slab", false, Material.rock).setBlockTextureName(NovaCraft.find("frontierslate")).setHardness(8.0F).setResistance(15.0F), frontierslate_double_slab);
		
		frontierslate_brick_double_slab = register("frontierslate_brick_double_slab", new BlocksNovaCraftSlab("frontierslate_brick_double_slab", true, Material.rock).setBlockTextureName(NovaCraft.find("frontierslate_bricks")).setHardness(8.0F).setResistance(15.0F)).setCreativeTab(null);
		frontierslate_brick_slab = registerSlab("frontierslate_brick_slab", new BlocksNovaCraftSlab("frontierslate_brick_slab", false, Material.rock).setBlockTextureName(NovaCraft.find("frontierslate_bricks")).setHardness(8.0F).setResistance(15.0F), frontierslate_brick_double_slab);
		
	}

	public static void initializeHarvestLevels()
	{
		//Regular Blocks	
		NovaCraftBlocks.grimstone_diamond.setHarvestLevel("pickaxe", 2);
		NovaCraftBlocks.grimstone_emerald.setHarvestLevel("pickaxe", 2);
		NovaCraftBlocks.grimstone_gold.setHarvestLevel("pickaxe", 2);
		NovaCraftBlocks.grimstone_iron.setHarvestLevel("pickaxe", 1);
		NovaCraftBlocks.grimstone_lapis.setHarvestLevel("pickaxe", 1);		
		NovaCraftBlocks.grimstone_redstone.setHarvestLevel("pickaxe", 2);
		NovaCraftBlocks.lit_grimstone_redstone.setHarvestLevel("pickaxe", 2);
		
		NovaCraftBlocks.pherithium_glass.setHarvestLevel("pickaxe", 2);
		NovaCraftBlocks.vanite_glass.setHarvestLevel("pickaxe", 3);
		
		NovaCraftBlocks.large_pherithium_stalagmite.setHarvestLevel("pickaxe", 2);
		NovaCraftBlocks.small_pherithium_stalagmite.setHarvestLevel("pickaxe", 2);
		NovaCraftBlocks.stone_stalagmite.setHarvestLevel("pickaxe", 0);
		NovaCraftBlocks.stone_stalactite.setHarvestLevel("pickaxe", 0);
		NovaCraftBlocks.large_stone_stalagmite.setHarvestLevel("pickaxe", 0);
		NovaCraftBlocks.large_stone_stalactite.setHarvestLevel("pickaxe", 0);
		NovaCraftBlocks.nullstone_stalagmite.setHarvestLevel("pickaxe", 3);
		NovaCraftBlocks.nullstone_stalactite.setHarvestLevel("pickaxe", 3);
		NovaCraftBlocks.large_nullstone_stalagmite.setHarvestLevel("pickaxe", 3);
		NovaCraftBlocks.large_nullstone_stalactite.setHarvestLevel("pickaxe", 3);
		NovaCraftBlocks.block_of_pherithium.setHarvestLevel("pickaxe", 2);
		NovaCraftBlocks.pherithium_ore.setHarvestLevel("pickaxe", 2);
		
		NovaCraftBlocks.nullstone_diamond.setHarvestLevel("pickaxe", 3);
		NovaCraftBlocks.nullstone_emerald.setHarvestLevel("pickaxe", 3);
		NovaCraftBlocks.nullstone_gold.setHarvestLevel("pickaxe", 3);
		NovaCraftBlocks.nullstone_iron.setHarvestLevel("pickaxe", 3);
		NovaCraftBlocks.nullstone_lapis.setHarvestLevel("pickaxe", 3);		
		NovaCraftBlocks.nullstone_redstone.setHarvestLevel("pickaxe", 3);
		NovaCraftBlocks.lit_nullstone_redstone.setHarvestLevel("pickaxe", 3);
		
		NovaCraftBlocks.etherstone_gold.setHarvestLevel("pickaxe", 2);
		NovaCraftBlocks.etherstone_emerald.setHarvestLevel("pickaxe", 2);
		NovaCraftBlocks.etherstone_brimstone.setHarvestLevel("pickaxe", 2);
		NovaCraftBlocks.etherstone_coal.setHarvestLevel("pickaxe", 1);
		NovaCraftBlocks.etherstone_iron.setHarvestLevel("pickaxe", 1);
		
		NovaCraftBlocks.brimstone_ore.setHarvestLevel("pickaxe", 2);
		
		NovaCraftBlocks.grimstone_vanite_ore.setHarvestLevel("pickaxe", 3);
		NovaCraftBlocks.nullstone_vanite_ore.setHarvestLevel("pickaxe", 3);
		NovaCraftBlocks.block_of_vanite.setHarvestLevel("pickaxe", 3);
		
		NovaCraftBlocks.xancium_ore.setHarvestLevel("pickaxe", 3);
		
		NovaCraftBlocks.klangite_ore.setHarvestLevel("pickaxe", 3);
		NovaCraftBlocks.end_klangite_ore.setHarvestLevel("pickaxe", 3);
		
		//Stairs
		NovaCraftBlocks.grimstone_stairs.setHarvestLevel("pickaxe", 1);
		NovaCraftBlocks.cobbled_grimstone_stairs.setHarvestLevel("pickaxe", 1);
		NovaCraftBlocks.grimstone_brick_stairs.setHarvestLevel("pickaxe", 1);
		NovaCraftBlocks.grimstone_tiled_stairs.setHarvestLevel("pickaxe", 1);
		
		NovaCraftBlocks.cobbled_nullstone_stairs.setHarvestLevel("pickaxe", 3);
		NovaCraftBlocks.nullstone_stairs.setHarvestLevel("pickaxe", 3);
		NovaCraftBlocks.nullstone_brick_stairs.setHarvestLevel("pickaxe", 3);
		NovaCraftBlocks.nullstone_tiled_stairs.setHarvestLevel("pickaxe", 3);
		
		NovaCraftBlocks.etherstone_stairs.setHarvestLevel("pickaxe", 1);
		NovaCraftBlocks.cobbled_etherstone_stairs.setHarvestLevel("pickaxe", 1);
		NovaCraftBlocks.etherstone_brick_stairs.setHarvestLevel("pickaxe", 1);
		NovaCraftBlocks.etherstone_tiled_stairs.setHarvestLevel("pickaxe", 1);
		
		NovaCraftBlocks.sculk_brick_stairs.setHarvestLevel("pickaxe", 2);
		NovaCraftBlocks.sculk_tiled_stairs.setHarvestLevel("pickaxe", 2);
		
		NovaCraftBlocks.frontierslate_stairs.setHarvestLevel("pickaxe", 3);
		NovaCraftBlocks.frontierslate_brick_stairs.setHarvestLevel("pickaxe", 3);
		
		NovaCraftBlocks.nullwart_brick_stairs.setHarvestLevel("pickaxe", 1);
		
		//Walls
		NovaCraftBlocks.grimstone_wall.setHarvestLevel("pickaxe", 1);
		NovaCraftBlocks.cobbled_grimstone_wall.setHarvestLevel("pickaxe", 1);
		NovaCraftBlocks.grimstone_brick_wall.setHarvestLevel("pickaxe", 1);
		NovaCraftBlocks.grimstone_tiled_wall.setHarvestLevel("pickaxe", 1);
				
		NovaCraftBlocks.cobbled_nullstone_wall.setHarvestLevel("pickaxe", 3);
		NovaCraftBlocks.nullstone_wall.setHarvestLevel("pickaxe", 3);
		NovaCraftBlocks.nullstone_brick_wall.setHarvestLevel("pickaxe", 3);
		NovaCraftBlocks.nullstone_tiled_wall.setHarvestLevel("pickaxe", 3);
		
		NovaCraftBlocks.etherstone_wall.setHarvestLevel("pickaxe", 1);
		NovaCraftBlocks.cobbled_etherstone_wall.setHarvestLevel("pickaxe", 1);
		NovaCraftBlocks.etherstone_brick_wall.setHarvestLevel("pickaxe", 1);
		NovaCraftBlocks.etherstone_tiled_wall.setHarvestLevel("pickaxe", 1);
		
		NovaCraftBlocks.sculk_brick_wall.setHarvestLevel("pickaxe", 2);
		NovaCraftBlocks.sculk_tiled_wall.setHarvestLevel("pickaxe", 2);
		
		NovaCraftBlocks.frontierslate_wall.setHarvestLevel("pickaxe", 3);
		NovaCraftBlocks.frontierslate_brick_wall.setHarvestLevel("pickaxe", 3);
		
		NovaCraftBlocks.nullwart_brick_wall.setHarvestLevel("pickaxe", 1);
					
			
		//Slabs	
		NovaCraftBlocks.cobbled_grimstone_slab.setHarvestLevel("pickaxe", 1);
		NovaCraftBlocks.grimstone_slab.setHarvestLevel("pickaxe", 1);
		NovaCraftBlocks.grimstone_brick_slab.setHarvestLevel("pickaxe", 1);
		NovaCraftBlocks.grimstone_tiled_slab.setHarvestLevel("pickaxe", 1);
		NovaCraftBlocks.cobbled_nullstone_slab.setHarvestLevel("pickaxe", 3);	
		NovaCraftBlocks.nullstone_slab.setHarvestLevel("pickaxe", 3);
		NovaCraftBlocks.cobbled_etherstone_slab.setHarvestLevel("pickaxe", 1);	
		NovaCraftBlocks.etherstone_slab.setHarvestLevel("pickaxe", 1);
		NovaCraftBlocks.etherstone_brick_slab.setHarvestLevel("pickaxe", 1);
		NovaCraftBlocks.etherstone_tiled_slab.setHarvestLevel("pickaxe", 1);
		NovaCraftBlocks.frontierslate_slab.setHarvestLevel("pickaxe", 3);
		NovaCraftBlocks.frontierslate_brick_slab.setHarvestLevel("pickaxe", 3);
		NovaCraftBlocks.nullstone_brick_slab.setHarvestLevel("pickaxe", 3);
		NovaCraftBlocks.nullstone_tiled_slab.setHarvestLevel("pickaxe", 3);
		NovaCraftBlocks.sculk_tiled_slab.setHarvestLevel("pickaxe", 2);
		NovaCraftBlocks.sculk_brick_slab.setHarvestLevel("pickaxe", 2);
		NovaCraftBlocks.nullwart_brick_slab.setHarvestLevel("pickaxe", 1);
		
		//Double Slabs
		NovaCraftBlocks.cobbled_grimstone_double_slab.setHarvestLevel("pickaxe", 1);	
		NovaCraftBlocks.grimstone_double_slab.setHarvestLevel("pickaxe", 1);
		NovaCraftBlocks.grimstone_brick_double_slab.setHarvestLevel("pickaxe", 1);
		NovaCraftBlocks.grimstone_tiled_double_slab.setHarvestLevel("pickaxe", 1);
		NovaCraftBlocks.cobbled_nullstone_double_slab.setHarvestLevel("pickaxe", 3);	
		NovaCraftBlocks.nullstone_double_slab.setHarvestLevel("pickaxe", 3);
		NovaCraftBlocks.cobbled_etherstone_double_slab.setHarvestLevel("pickaxe", 1);	
		NovaCraftBlocks.etherstone_double_slab.setHarvestLevel("pickaxe", 1);
		NovaCraftBlocks.etherstone_brick_double_slab.setHarvestLevel("pickaxe", 1);
		NovaCraftBlocks.etherstone_tiled_double_slab.setHarvestLevel("pickaxe", 1);
		NovaCraftBlocks.frontierslate_double_slab.setHarvestLevel("pickaxe", 3);
		NovaCraftBlocks.frontierslate_brick_double_slab.setHarvestLevel("pickaxe", 3);
		NovaCraftBlocks.nullstone_brick_double_slab.setHarvestLevel("pickaxe", 3);
		NovaCraftBlocks.nullstone_tiled_double_slab.setHarvestLevel("pickaxe", 3);
		NovaCraftBlocks.sculk_brick_double_slab.setHarvestLevel("pickaxe", 2);
		NovaCraftBlocks.sculk_tiled_double_slab.setHarvestLevel("pickaxe", 2);
		NovaCraftBlocks.nullwart_brick_double_slab.setHarvestLevel("pickaxe", 1);
	}
	
	public static Block registerSlab(String name, Block slab1, Block slab2) {
		slab1.setBlockName(name);
		slab1.setCreativeTab(NovaCraftCreativeTabs.blocks);

		GameRegistry.registerBlock(slab1, ItemNovaCraftSlab.class, name, (BlocksNovaCraftSlab) slab1, (BlocksNovaCraftSlab) slab2, false);

		return slab1;
	}
	
	 public static Block registerItemBlock(String name, final Block block, final Class<? extends ItemBlock> itemBlockClass) {
		 	block.setBlockName(name);
			block.setCreativeTab(NovaCraftCreativeTabs.blocks);
			
	        GameRegistry.registerBlock(block, (Class)itemBlockClass, block.getUnlocalizedName().replace("tile.", ""));
	        return block;
	    }

	public static Block register(String name, Block block) {
		block.setBlockName(name);
		block.setCreativeTab(NovaCraftCreativeTabs.blocks);

		GameRegistry.registerBlock(block, name);

		return block;
	}
	
	public static Block registerHidden(String name, Block block) {
		block.setBlockName(name);

		GameRegistry.registerBlock(block, name);

		return block;
	}
	
	public static Block registerRarity(String name, Block block, EnumRarity rarity) {
		block.setBlockName(name);
		block.setCreativeTab(NovaCraftCreativeTabs.blocks);

		GameRegistry.registerBlock(block, ItemBlockRarity.class, name, rarity);

		return block;
	}
	
	public static Block registerMeta(String name, Block block) {
		block.setBlockName(name);
		block.setCreativeTab(NovaCraftCreativeTabs.blocks);

		GameRegistry.registerBlock(block, ItemBlockMetadata.class, name);

		return block;
	}
	
	public static Block registerMetaHidden(String name, Block block) {
		block.setBlockName(name);

		GameRegistry.registerBlock(block, ItemBlockMetadata.class, name);

		return block;
	}
	
	public static interface ISubBlocksBlock {
		Class<? extends ItemBlock> getItemBlockClass();
	}

}
