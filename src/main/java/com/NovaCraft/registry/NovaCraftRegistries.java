package com.NovaCraft.registry;

import java.util.Iterator;

import com.NovaCraft.Item.Block.ItemBlockFireProof;
import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.config.Configs;
import com.NovaCraftBlocks.NovaCraftBlocks;

import com.NovaCraftBlocks.ores.BlockRawDivineral;
import com.NovaCraftBlocks.ores.BlockRawNetherite;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.oredict.OreDictionary;

public class NovaCraftRegistries {


	public static void register() {
		initializeRecipes();
		initializeShapelessRecipes();
		removeRecipes();

		OreDictionary.registerOre("oreIron", NovaCraftBlocks.grimstone_iron);
		OreDictionary.registerOre("oreIron", NovaCraftBlocks.nullstone_iron);
		OreDictionary.registerOre("oreIron", NovaCraftBlocks.etherstone_iron);
		OreDictionary.registerOre("oreIron", NovaCraftBlocks.meteorite_block);

		OreDictionary.registerOre("oreDiamond", NovaCraftBlocks.grimstone_diamond);
		OreDictionary.registerOre("oreDiamond", NovaCraftBlocks.nullstone_diamond);

		OreDictionary.registerOre("oreGold", NovaCraftBlocks.grimstone_gold);
		OreDictionary.registerOre("oreGold", NovaCraftBlocks.nullstone_gold);
		OreDictionary.registerOre("oreGold", NovaCraftBlocks.etherstone_gold);

		OreDictionary.registerOre("oreRedstone", NovaCraftBlocks.grimstone_redstone);
		OreDictionary.registerOre("oreRedstone", NovaCraftBlocks.nullstone_redstone);

		OreDictionary.registerOre("oreLapis", NovaCraftBlocks.grimstone_lapis);
		OreDictionary.registerOre("oreLapis", NovaCraftBlocks.nullstone_lapis);

		OreDictionary.registerOre("oreEmerald", NovaCraftBlocks.grimstone_emerald);
		OreDictionary.registerOre("oreEmerald", NovaCraftBlocks.nullstone_emerald);
		OreDictionary.registerOre("oreEmerald", NovaCraftBlocks.etherstone_emerald);

		OreDictionary.registerOre("oreCoal", NovaCraftBlocks.etherstone_coal);

		OreDictionary.registerOre("oreVanite", NovaCraftBlocks.grimstone_vanite_ore);
		OreDictionary.registerOre("oreVanite", NovaCraftBlocks.nullstone_vanite_ore);
		OreDictionary.registerOre("oreVanite", NovaCraftItems.vanite_chunk);
		OreDictionary.registerOre("ingotVanite", NovaCraftItems.vanite_ingot);

		if (!(Configs.enableNullstone)) {
			OreDictionary.registerOre("oreKlangite", NovaCraftBlocks.stone_klangite_ore);
			OreDictionary.registerOre("oreTophinite", NovaCraftBlocks.stone_tophinite_ore);
		}
		if (!(Configs.enableGrimstone) && !(Configs.enableNullstone)) {
			OreDictionary.registerOre("oreVanite", NovaCraftBlocks.stone_vanite_ore);
		}

		OreDictionary.registerOre("oreKlangite", NovaCraftBlocks.klangite_ore);
		OreDictionary.registerOre("oreKlangite", NovaCraftBlocks.end_klangite_ore);
		OreDictionary.registerOre("oreKlangite", NovaCraftItems.raw_klangite);
		OreDictionary.registerOre("ingotKlangite", NovaCraftItems.klangite_ingot);
		OreDictionary.registerOre("ingotIridium", NovaCraftItems.iridium_ingot);

		OreDictionary.registerOre("oreIridium", NovaCraftBlocks.iridium_ore);

		OreDictionary.registerOre("oreTophinite", NovaCraftBlocks.nullstone_tophinite_ore);
		OreDictionary.registerOre("oreTophinite", NovaCraftBlocks.nether_tophinite_ore);

		OreDictionary.registerOre("oreBrimstone", NovaCraftBlocks.brimstone_ore);
		OreDictionary.registerOre("dustBrimstone", NovaCraftItems.brimstone_dust);

		OreDictionary.registerOre("orePherithium", NovaCraftBlocks.pherithium_ore);
		OreDictionary.registerOre("orePherithium", NovaCraftItems.pherithium_scraps);
		OreDictionary.registerOre("ingotPherithium", NovaCraftItems.pherithium_ingot);

		OreDictionary.registerOre("oreXancium", NovaCraftBlocks.xancium_ore);
		OreDictionary.registerOre("oreXancium", NovaCraftItems.xancium_dust);
		OreDictionary.registerOre("ingotXancium", NovaCraftItems.xancium_ingot);

		OreDictionary.registerOre("logWood", NovaCraftBlocks.lacuna_log);
		OreDictionary.registerOre("logWood", NovaCraftBlocks.luminant_log);
		OreDictionary.registerOre("plankWood", NovaCraftBlocks.lacuna_planks);
		OreDictionary.registerOre("plankWood", NovaCraftBlocks.luminant_planks);

		OreDictionary.registerOre("record", NovaCraftItems.disc_5);

		OreDictionary.registerOre("cobblestone", new ItemStack(NovaCraftBlocks.cobbled_grimstone));
		OreDictionary.registerOre("cobblestone", new ItemStack(NovaCraftBlocks.cobbled_nullstone));
		OreDictionary.registerOre("cobblestone", new ItemStack(NovaCraftBlocks.cobbled_etherstone));

		OreDictionary.registerOre("foodGlowsquidraw", new ItemStack(NovaCraftItems.raw_glow_squid));
		OreDictionary.registerOre("listAllmeatraw", new ItemStack(NovaCraftItems.raw_glow_squid));
		OreDictionary.registerOre("listAllglowsquidraw", new ItemStack(NovaCraftItems.raw_glow_squid));
		OreDictionary.registerOre("foodEnderavisraw", new ItemStack(NovaCraftItems.raw_enderavis));
		OreDictionary.registerOre("listAllmeatraw", new ItemStack(NovaCraftItems.raw_enderavis));
		OreDictionary.registerOre("listAllenderavisraw", new ItemStack(NovaCraftItems.raw_enderavis));
		OreDictionary.registerOre("foodBlazingchargerraw", new ItemStack(NovaCraftItems.raw_blazing_charger));
		OreDictionary.registerOre("listAllmeatraw", new ItemStack(NovaCraftItems.raw_blazing_charger));
		OreDictionary.registerOre("listAllblazingchargerraw", new ItemStack(NovaCraftItems.raw_blazing_charger));
		OreDictionary.registerOre("foodChevonrraw", new ItemStack(NovaCraftItems.raw_chevon));
		OreDictionary.registerOre("listAllmeatraw", new ItemStack(NovaCraftItems.raw_chevon));
		OreDictionary.registerOre("listAllchevonraw", new ItemStack(NovaCraftItems.raw_chevon));
		OreDictionary.registerOre("foodFroglegraw", new ItemStack(NovaCraftItems.raw_frog_leg));
		OreDictionary.registerOre("listAllmeatraw", new ItemStack(NovaCraftItems.raw_frog_leg));
		OreDictionary.registerOre("listAllfroglegraw", new ItemStack(NovaCraftItems.raw_frog_leg));

		OreDictionary.registerOre("foodGlowsquidcooked", new ItemStack(NovaCraftItems.cooked_glow_squid));
		OreDictionary.registerOre("listAllmeatcooked", new ItemStack(NovaCraftItems.cooked_glow_squid));
		OreDictionary.registerOre("listAllglowsquidcooked", new ItemStack(NovaCraftItems.cooked_glow_squid));
		OreDictionary.registerOre("foodEnderaviscooked", new ItemStack(NovaCraftItems.cooked_enderavis));
		OreDictionary.registerOre("listAllmeatcooked", new ItemStack(NovaCraftItems.cooked_enderavis));
		OreDictionary.registerOre("listAllenderaviscooked", new ItemStack(NovaCraftItems.cooked_enderavis));
		OreDictionary.registerOre("foodBlazingchargercooked", new ItemStack(NovaCraftItems.cooked_blazing_charger));
		OreDictionary.registerOre("listAllmeatcooked", new ItemStack(NovaCraftItems.cooked_blazing_charger));
		OreDictionary.registerOre("listAllblazingchargercooked", new ItemStack(NovaCraftItems.cooked_blazing_charger));
		OreDictionary.registerOre("foodChevoncooked", new ItemStack(NovaCraftItems.cooked_chevon));
		OreDictionary.registerOre("listAllmeatcooked", new ItemStack(NovaCraftItems.cooked_chevon));
		OreDictionary.registerOre("listAllchevoncooked", new ItemStack(NovaCraftItems.cooked_chevon));
		OreDictionary.registerOre("foodFroglegcooked", new ItemStack(NovaCraftItems.cooked_frog_leg));
		OreDictionary.registerOre("listAllmeatcooked", new ItemStack(NovaCraftItems.cooked_frog_leg));
		OreDictionary.registerOre("listAllfroglegcooked", new ItemStack(NovaCraftItems.cooked_frog_leg));
	}

	private static void initializeRecipes() {

		GameRegistry.addSmelting(new ItemStack(NovaCraftBlocks.grimstone_iron), new ItemStack(Items.iron_ingot), .05F);
		GameRegistry.addSmelting(new ItemStack(NovaCraftBlocks.grimstone_gold), new ItemStack(Items.gold_ingot), .1F);
		GameRegistry.addSmelting(new ItemStack(NovaCraftBlocks.nullstone_iron), new ItemStack(Items.iron_ingot), .05F);
		GameRegistry.addSmelting(new ItemStack(NovaCraftBlocks.nullstone_gold), new ItemStack(Items.gold_ingot), .1F);
		GameRegistry.addSmelting(new ItemStack(NovaCraftBlocks.etherstone_iron), new ItemStack(Items.iron_ingot), .05F);
		GameRegistry.addSmelting(new ItemStack(NovaCraftBlocks.etherstone_gold), new ItemStack(Items.gold_ingot), .1F);
		GameRegistry.addSmelting(new ItemStack(NovaCraftItems.disc_fragment_5), new ItemStack(NovaCraftItems.vanite_ingot), .1F);

		GameRegistry.addSmelting(new ItemStack(NovaCraftBlocks.meteorite_block), new ItemStack(Items.iron_ingot), .05F);

		if (!(Configs.enableGrimstone) && !(Configs.enableNullstone)) {
			GameRegistry.addSmelting(new ItemStack(NovaCraftBlocks.stone_vanite_ore), new ItemStack(NovaCraftItems.vanite_chunk), .05F);
		}

		if (!(Configs.enableNullstone)) {
			GameRegistry.addSmelting(new ItemStack(NovaCraftBlocks.stone_klangite_ore), new ItemStack(NovaCraftItems.raw_klangite), .25F);
			GameRegistry.addSmelting(new ItemStack(NovaCraftBlocks.stone_tophinite_ore), new ItemStack(NovaCraftItems.tophinite_gemstone), .15F);
		}

		GameRegistry.addSmelting(new ItemStack(NovaCraftBlocks.nether_tophinite_ore), new ItemStack(NovaCraftItems.tophinite_gemstone), .15F);
		GameRegistry.addSmelting(new ItemStack(NovaCraftBlocks.nullstone_tophinite_ore), new ItemStack(NovaCraftItems.tophinite_gemstone), .15F);
		GameRegistry.addSmelting(new ItemStack(NovaCraftBlocks.klangite_ore), new ItemStack(NovaCraftItems.raw_klangite), .25F);
		GameRegistry.addSmelting(new ItemStack(NovaCraftBlocks.end_klangite_ore), new ItemStack(NovaCraftItems.raw_klangite), .25F);
		GameRegistry.addSmelting(new ItemStack(NovaCraftBlocks.grimstone_vanite_ore), new ItemStack(NovaCraftItems.vanite_chunk), .2F);
		GameRegistry.addSmelting(new ItemStack(NovaCraftBlocks.nullstone_vanite_ore), new ItemStack(NovaCraftItems.vanite_chunk), .2F);
		GameRegistry.addSmelting(new ItemStack(NovaCraftItems.vanite_chunk), new ItemStack(NovaCraftItems.vanite_ingot), .1F);
		GameRegistry.addSmelting(new ItemStack(NovaCraftItems.null_cube_slime), new ItemStack(Items.slime_ball), .1F);
		GameRegistry.addSmelting(new ItemStack(NovaCraftItems.klangite_blend), new ItemStack(NovaCraftItems.impure_klangite_ingot), 1F);
		GameRegistry.addSmelting(new ItemStack(NovaCraftBlocks.iridium_ore), new ItemStack(NovaCraftItems.raw_iridium), .1F);
		GameRegistry.addSmelting(new ItemStack(NovaCraftItems.raw_iridium), new ItemStack(NovaCraftItems.iridium_nugget, 0, 0), .2F);

		GameRegistry.addSmelting(new ItemStack(NovaCraftItems.raw_frog_leg), new ItemStack(NovaCraftItems.cooked_frog_leg), .01F);
		GameRegistry.addSmelting(new ItemStack(NovaCraftItems.raw_glow_squid), new ItemStack(NovaCraftItems.cooked_glow_squid), .01F);
		GameRegistry.addSmelting(new ItemStack(NovaCraftItems.raw_enderavis), new ItemStack(NovaCraftItems.cooked_enderavis), .01F);
		GameRegistry.addSmelting(new ItemStack(NovaCraftItems.raw_blazing_charger), new ItemStack(NovaCraftItems.cooked_blazing_charger), .01F);
		GameRegistry.addSmelting(new ItemStack(NovaCraftItems.raw_chevon), new ItemStack(NovaCraftItems.cooked_chevon), .01F);
		GameRegistry.addSmelting(new ItemStack(NovaCraftItems.sculked_leather), new ItemStack(Items.leather), .01F);
		GameRegistry.addSmelting(new ItemStack(NovaCraftBlocks.vacuum_sand), new ItemStack(NovaCraftBlocks.vacuum_glass), .01F);
		GameRegistry.addSmelting(new ItemStack(NovaCraftBlocks.inked_vacuum_sand), new ItemStack(NovaCraftBlocks.vacuum_glass), .01F);
		GameRegistry.addSmelting(new ItemStack(NovaCraftItems.luminant_tree_sap), new ItemStack(NovaCraftItems.luminant_gel), .01F);

		GameRegistry.addSmelting(new ItemStack(NovaCraftBlocks.cobbled_grimstone), new ItemStack(NovaCraftBlocks.grimstone), .01F);
		GameRegistry.addSmelting(new ItemStack(NovaCraftBlocks.cobbled_nullstone), new ItemStack(NovaCraftBlocks.nullstone), .01F);
		GameRegistry.addSmelting(new ItemStack(NovaCraftBlocks.cobbled_etherstone), new ItemStack(NovaCraftBlocks.etherstone), .01F);

		GameRegistry.addSmelting(new ItemStack(NovaCraftBlocks.grimstone_tiles), new ItemStack(NovaCraftBlocks.cracked_grimstone_tiles), .01F);
		GameRegistry.addSmelting(new ItemStack(NovaCraftBlocks.etherstone_tiles), new ItemStack(NovaCraftBlocks.cracked_etherstone_tiles), .01F);
		GameRegistry.addSmelting(new ItemStack(NovaCraftBlocks.nullstone_tiles), new ItemStack(NovaCraftBlocks.cracked_nullstone_tiles), .01F);
		GameRegistry.addSmelting(new ItemStack(NovaCraftBlocks.sculk_tiles), new ItemStack(NovaCraftBlocks.cracked_sculk_tiles), .01F);

		GameRegistry.addSmelting(new ItemStack(NovaCraftBlocks.grimstone_bricks), new ItemStack(NovaCraftBlocks.cracked_grimstone_bricks), .01F);
		GameRegistry.addSmelting(new ItemStack(NovaCraftBlocks.etherstone_bricks), new ItemStack(NovaCraftBlocks.cracked_etherstone_bricks), .01F);
		GameRegistry.addSmelting(new ItemStack(NovaCraftBlocks.nullstone_bricks), new ItemStack(NovaCraftBlocks.cracked_nullstone_bricks), .01F);
		GameRegistry.addSmelting(new ItemStack(NovaCraftBlocks.sculk_bricks), new ItemStack(NovaCraftBlocks.cracked_sculk_bricks), .01F);
		GameRegistry.addSmelting(new ItemStack(NovaCraftBlocks.vanite_bricks), new ItemStack(NovaCraftBlocks.polished_vanite_bricks), .01F);

		GameRegistry.addSmelting(new ItemStack(NovaCraftItems.pherithium_lump), new ItemStack(NovaCraftItems.pherithium_ingot), .1F);
		register("pherithium_lump", new ItemStack(NovaCraftItems.pherithium_lump, 1), "ZZZ", "ZZZ", 'Z', new ItemStack(NovaCraftItems.pherithium_scraps));
		register("sculked_leather", new ItemStack(NovaCraftItems.sculked_leather), "XXX", "XXX", "XXX", 'X', NovaCraftItems.sculk_flesh);

		register("pherithium_helmet", new ItemStack(NovaCraftItems.pherithium_helmet, 1), "XXX", "X X", 'X', NovaCraftItems.pherithium_ingot);
		register("pherithium_chestplate", new ItemStack(NovaCraftItems.pherithium_chestplate, 1), "X X", "XXX", "XXX", 'X', NovaCraftItems.pherithium_ingot);
		register("pherithium_leggings", new ItemStack(NovaCraftItems.pherithium_leggings, 1), "XXX", "X X", "X X", 'X', NovaCraftItems.pherithium_ingot);
		register("pherithium_boots", new ItemStack(NovaCraftItems.pherithium_boots, 1), "X X", "X X", 'X', NovaCraftItems.pherithium_ingot);
		register("pherithium_pickaxe", new ItemStack(NovaCraftItems.pherithium_pickaxe, 1), "ZZZ", " Y ", " Y ", 'Z', NovaCraftItems.pherithium_ingot, 'Y', Items.stick);
		register("pherithium_axe", new ItemStack(NovaCraftItems.pherithium_axe, 1), "ZZ", "ZY", " Y", 'Z', NovaCraftItems.pherithium_ingot, 'Y', Items.stick);
		register("pherithium_shovel", new ItemStack(NovaCraftItems.pherithium_shovel, 1), "Z", "Y", "Y", 'Z', NovaCraftItems.pherithium_ingot, 'Y', Items.stick);
		register("pherithium_sword", new ItemStack(NovaCraftItems.pherithium_sword, 1), "Z", "Z", "Y", 'Z', NovaCraftItems.pherithium_ingot, 'Y', Items.stick);
		register("pherithium_hoe", new ItemStack(NovaCraftItems.pherithium_hoe, 1, 0),  "XX ", " Y ", " Y ", 'X', NovaCraftItems.pherithium_ingot, 'Y', Items.stick );

		register("phantom_helmet", new ItemStack(NovaCraftItems.phantom_helmet, 1), "XXX", "X X", 'X', NovaCraftItems.phantom_membrane);
		register("phantom_chestplate", new ItemStack(NovaCraftItems.phantom_chestplate, 1), "X X", "XXX", "XXX", 'X', NovaCraftItems.phantom_membrane);
		register("phantom_leggings", new ItemStack(NovaCraftItems.phantom_leggings, 1), "XXX", "X X", "X X", 'X', NovaCraftItems.phantom_membrane);
		register("phantom_boots", new ItemStack(NovaCraftItems.phantom_boots, 1), "X X", "X X", 'X', NovaCraftItems.phantom_membrane);

		register("sculk_star", new ItemStack(NovaCraftItems.sculk_star), "XXX", "XYX", "XXX", 'X', NovaCraftItems.corrupted_essence, 'Y', Items.nether_star);

		//Normal Blocks
		register("grimstone_bricks", new ItemStack(NovaCraftBlocks.grimstone_bricks, 4), "XX", "XX", 'X', NovaCraftBlocks.grimstone);
		register("grimstone_tiles", new ItemStack(NovaCraftBlocks.grimstone_tiles, 4), "XX", "XX", 'X', NovaCraftBlocks.grimstone_bricks);

		register("etherstone_bricks", new ItemStack(NovaCraftBlocks.etherstone_bricks, 4), "XX", "XX", 'X', NovaCraftBlocks.etherstone);
		register("etherstone_tiles", new ItemStack(NovaCraftBlocks.etherstone_tiles, 4), "XX", "XX", 'X', NovaCraftBlocks.etherstone_bricks);

		register("nullstone_bricks", new ItemStack(NovaCraftBlocks.nullstone_bricks, 4), "XX", "XX", 'X', NovaCraftBlocks.nullstone);
		register("nullstone_tiles", new ItemStack(NovaCraftBlocks.nullstone_tiles, 4), "XX", "XX", 'X', NovaCraftBlocks.nullstone_bricks);

		register("basal_bricks", new ItemStack(NovaCraftBlocks.basal_bricks, 4), "XX", "XX", 'X', NovaCraftBlocks.basal);

		if (Loader.isModLoaded("etfuturum") && Configs.enableTuffBrickRecipe) {
			try {
				Block tuff = GameRegistry.findBlock("etfuturum", "tuff");
				if (tuff != null) {
					GameRegistry.addSmelting(new ItemStack(NovaCraftBlocks.tuff_tiles), new ItemStack(NovaCraftBlocks.cracked_tuff_tiles), .01F);
					GameRegistry.addSmelting(new ItemStack(NovaCraftBlocks.tuff_bricks), new ItemStack(NovaCraftBlocks.cracked_tuff_bricks), .01F);
					register("tuff_bricks", new ItemStack(NovaCraftBlocks.tuff_bricks, 4), "XX", "XX", 'X', OtherModBlocks.tuff);
					register("tuff_tiles", new ItemStack(NovaCraftBlocks.tuff_tiles, 4), "XX", "XX", 'X', NovaCraftBlocks.tuff_bricks);
					register("tuff_brick_stairs", new ItemStack(NovaCraftBlocks.tuff_brick_stairs, 4), "Z  ", "ZZ ", "ZZZ", 'Z', new ItemStack(NovaCraftBlocks.tuff_bricks));
					register("tuff_tiled_stairs", new ItemStack(NovaCraftBlocks.tuff_tiled_stairs, 4), "Z  ", "ZZ ", "ZZZ", 'Z', new ItemStack(NovaCraftBlocks.tuff_tiles));
					register("tuff_brick_wall", new ItemStack(NovaCraftBlocks.tuff_brick_wall, 6), "ZZZ", "ZZZ", 'Z', new ItemStack(NovaCraftBlocks.tuff_bricks));
					register("tuff_tiled_wall", new ItemStack(NovaCraftBlocks.tuff_tiled_wall, 6), "ZZZ", "ZZZ", 'Z', new ItemStack(NovaCraftBlocks.tuff_tiles));
					register("tuff_brick_slab", new ItemStack(NovaCraftBlocks.tuff_brick_slab, 6), "ZZZ", 'Z', new ItemStack(NovaCraftBlocks.tuff_bricks));
					register("tuff_tiled_slab", new ItemStack(NovaCraftBlocks.tuff_tiled_slab, 6), "ZZZ", 'Z', new ItemStack(NovaCraftBlocks.tuff_tiles));
				}
			} catch (Exception ex) {
				if (Configs.enableDebugMode) {
					System.out.println("Tuff from Et Futurum Requiem is missing, skipping Tuff Building Blocks Recipes...");
				}
			}
		}

		if (Loader.isModLoaded("etfuturum") && Configs.enableCalciteBrickRecipe) {
			try {
				Block calcite = GameRegistry.findBlock("etfuturum", "calcite");
				if (calcite != null) {
					GameRegistry.addSmelting(new ItemStack(NovaCraftBlocks.calcite_bricks), new ItemStack(NovaCraftBlocks.cracked_calcite_bricks), .01F);
					GameRegistry.addSmelting(new ItemStack(NovaCraftBlocks.calcite_tiles), new ItemStack(NovaCraftBlocks.cracked_calcite_tiles), .01F);
					register("calcite_bricks", new ItemStack(NovaCraftBlocks.calcite_bricks, 4), "XX", "XX", 'X', OtherModBlocks.calcite);
					register("calcite_tiles", new ItemStack(NovaCraftBlocks.calcite_tiles, 4), "XX", "XX", 'X', NovaCraftBlocks.calcite_bricks);
					register("calcite_brick_stairs", new ItemStack(NovaCraftBlocks.calcite_brick_stairs, 4), "Z  ", "ZZ ", "ZZZ", 'Z', new ItemStack(NovaCraftBlocks.calcite_bricks));
					register("calcite_tiled_stairs", new ItemStack(NovaCraftBlocks.calcite_tiled_stairs, 4), "Z  ", "ZZ ", "ZZZ", 'Z', new ItemStack(NovaCraftBlocks.calcite_tiles));
					register("calcite_brick_wall", new ItemStack(NovaCraftBlocks.calcite_brick_wall, 6), "ZZZ", "ZZZ", 'Z', new ItemStack(NovaCraftBlocks.calcite_bricks));
					register("calcite_tiled_wall", new ItemStack(NovaCraftBlocks.calcite_tiled_wall, 6), "ZZZ", "ZZZ", 'Z', new ItemStack(NovaCraftBlocks.calcite_tiles));
					register("calcite_brick_slab", new ItemStack(NovaCraftBlocks.calcite_brick_slab, 6), "ZZZ", 'Z', new ItemStack(NovaCraftBlocks.calcite_bricks));
					register("calcite_tiled_slab", new ItemStack(NovaCraftBlocks.calcite_tiled_slab, 6), "ZZZ", 'Z', new ItemStack(NovaCraftBlocks.calcite_tiles));
				}
			} catch (Exception ex) {
				if (Configs.enableDebugMode) {
					System.out.println("Calcite from Et Futurum Requiem is missing, skipping Calcite Building Blocks Recipes...");
				}
			}
		}

		register("sculk_tiles", new ItemStack(NovaCraftBlocks.sculk_tiles, 4), "XX", "XX", 'X', NovaCraftBlocks.sculk_bricks);

		register("polished_grimstone", new ItemStack(NovaCraftBlocks.polished_grimstone, 4), "XX", "XX", 'X', NovaCraftBlocks.cobbled_grimstone);
		register("polished_nullstone", new ItemStack(NovaCraftBlocks.polished_nullstone, 4), "XX", "XX", 'X', NovaCraftBlocks.cobbled_nullstone);

		register("frontierslate_bricks", new ItemStack(NovaCraftBlocks.frontierslate_bricks, 4), "XX", "XX", 'X', NovaCraftBlocks.frontierslate);

		register("chiseled_etherstone", new ItemStack(NovaCraftBlocks.chiseled_etherstone, 1), "X", "X", 'X', NovaCraftBlocks.etherstone_brick_slab);
		register("chiseled_grimstone", new ItemStack(NovaCraftBlocks.chiseled_grimstone, 1), "X", "X", 'X', NovaCraftBlocks.grimstone_brick_slab);
		register("chiseled_nullstone", new ItemStack(NovaCraftBlocks.chiseled_nullstone, 1), "X", "X", 'X', NovaCraftBlocks.nullstone_brick_slab);
		register("chiseled_sculk", new ItemStack(NovaCraftBlocks.chiseled_sculk, 1), "X", "X", 'X', NovaCraftBlocks.sculk_brick_slab);
		register("carved_frontierslate_bricks", new ItemStack(NovaCraftBlocks.carved_frontierslate_bricks, 1), "X", "X", 'X', NovaCraftBlocks.frontierslate_brick_slab);
		register("chiseled_basal", new ItemStack(NovaCraftBlocks.chiseled_basal, 1), "X", "X", 'X', NovaCraftBlocks.basal_brick_slab);

		register("sculk_bricks", new ItemStack(NovaCraftBlocks.sculk_bricks, 2), "XXX", "XYX", "XXX", 'X', NovaCraftBlocks.sculk_vein, 'Y', NovaCraftBlocks.grimstone_bricks);
		register("sculk_bricks", new ItemStack(NovaCraftBlocks.sculk_bricks, 3), " X ", "XYX", " X ", 'X', NovaCraftBlocks.sculk_tentacle_2, 'Y', NovaCraftBlocks.grimstone_bricks);

		register("xancium_tnt", new ItemStack(NovaCraftBlocks.xancium_TNT), "XWX", "XZX", "XYX", 'X', NovaCraftItems.xancium_ingot, 'Y', NovaCraftItems.nullifier_core, 'W', NovaCraftBlocks.block_of_xancium, 'Z', NovaCraftBlocks.PETN);
		register("PETN", new ItemStack(NovaCraftBlocks.PETN), "XXX", "XZX", "XXX", 'X', NovaCraftItems.petn_powder, 'Z', Blocks.tnt);
		register("xancium_ingot", new ItemStack(NovaCraftItems.xancium_ingot), "XXX", "XZX", "XXX", 'X', NovaCraftItems.xancium_dust, 'Z', NovaCraftItems.echo_shard);
		register("explosive_klangite_ingot", new ItemStack(NovaCraftItems.explosive_klangite_ingot), "XXX", "XZX", "XXX", 'X', NovaCraftItems.xancium_dust, 'Z', NovaCraftItems.impure_klangite_ingot);

		register("copartz_block", new ItemStack(NovaCraftBlocks.copartz_block), "XXX", "XZX", "XXX", 'X', NovaCraftItems.copartz_shard, 'Z', NovaCraftBlocks.cracked_copartz_block);
		register("larimar_block", new ItemStack(NovaCraftBlocks.larimar_block), "XXX", "XZX", "XXX", 'X', NovaCraftItems.larimar_shard, 'Z', NovaCraftBlocks.cracked_larimar_block);
		register("tsavorokite_block", new ItemStack(NovaCraftBlocks.tsavorokite_block), "XXX", "XZX", "XXX", 'X', NovaCraftItems.tsavorokite_shard, 'Z', NovaCraftBlocks.cracked_tsavorokite_block);
		register("yttrlinsite_block", new ItemStack(NovaCraftBlocks.yttrlinsite_block), "XXX", "XZX", "XXX", 'X', NovaCraftItems.yttrlinsite_shard, 'Z', NovaCraftBlocks.cracked_yttrlinsite_block);
		register("aether_block", new ItemStack(NovaCraftBlocks.aether_block), "XXX", "XZX", "XXX", 'X', NovaCraftItems.aether_shard, 'Z', NovaCraftBlocks.cracked_aether_block);


		register("nullwart_bricks", new ItemStack(NovaCraftBlocks.nullwart_bricks, 2), "XXX", "XZX", "XXX", 'X', NovaCraftItems.nullwart, 'Z', Blocks.nether_brick);
		register("vanite_bricks", new ItemStack(NovaCraftBlocks.vanite_bricks, 4), " X ", "XZX", " X ", 'Z', NovaCraftItems.vanite_ingot, 'X', Blocks.nether_brick);
		register("vanite_bricks", new ItemStack(NovaCraftBlocks.vanite_bricks, 4), " X ", "XZX", " X ", 'Z', NovaCraftItems.vanite_ingot, 'X', NovaCraftBlocks.nullwart_bricks);
		register("carved_vanite_bricks", new ItemStack(NovaCraftBlocks.carved_vanite_bricks, 4), "XX", "XX", 'X', NovaCraftBlocks.vanite_bricks);

		register("ender_fungus_block", new ItemStack(NovaCraftBlocks.ender_fungus_block), "XX", "XX", 'X', NovaCraftBlocks.ender_fungus_stem);

		register("dimensional_sealent", new ItemStack(NovaCraftItems.dimensional_sealent), "XXX", "ZYW", "XXX", 'X', NovaCraftItems.static_essence, 'Y', NovaCraftItems.powered_ancient_city_artifact, 'Z', NovaCraftItems.nulk_dust, 'W', NovaCraftItems.warden_dust);

		register("crystallized_end", new ItemStack(NovaCraftBlocks.crystallized_end), "XXX", "XXX", "XXX", 'X', NovaCraftItems.crystallized_end_shard);
		register("klangite_ingot", new ItemStack(NovaCraftItems.klangite_ingot, 9), "X", 'X', NovaCraftBlocks.block_of_klangite);
		register("klangite_block", new ItemStack(NovaCraftBlocks.block_of_klangite), "XXX", "XXX", "XXX", 'X', NovaCraftItems.klangite_ingot);
		register("tophinite_gemstone", new ItemStack(NovaCraftItems.tophinite_gemstone, 9), "X", 'X', NovaCraftBlocks.block_of_tophinite);
		register("tophinite_block", new ItemStack(NovaCraftBlocks.block_of_tophinite), "XXX", "XXX", "XXX", 'X', NovaCraftItems.tophinite_gemstone);
		register("raw_klangite", new ItemStack(NovaCraftItems.raw_klangite, 9), "X", 'X', NovaCraftBlocks.block_of_raw_klangite);
		register("block_of_raw_klangite", new ItemStack(NovaCraftBlocks.block_of_raw_klangite), "XXX", "XXX", "XXX", 'X', NovaCraftItems.raw_klangite);
		register("xancium_dust", new ItemStack(NovaCraftItems.xancium_dust), "XXX", "XXX", "XXX", 'X', NovaCraftItems.small_xancium_dust);
		register("xancium_ingot", new ItemStack(NovaCraftItems.xancium_ingot, 9), "X", 'X', NovaCraftBlocks.block_of_xancium);
		register("xancium_pellet", new ItemStack(NovaCraftItems.xancium_pellet, 8), "X", 'X', NovaCraftItems.xancium_ingot);
		register("block_of_xancium", new ItemStack(NovaCraftBlocks.block_of_xancium), "XXX", "XXX", "XXX", 'X', NovaCraftItems.xancium_ingot);
		register("reinforced_vanite_ingot", new ItemStack(NovaCraftItems.reinforced_vanite_ingot, 9), "X", 'X', NovaCraftBlocks.block_of_reinforced_vanite);
		register("block_of_reinforced_vanite", new ItemStack(NovaCraftBlocks.block_of_reinforced_vanite), "XXX", "XXX", "XXX", 'X', NovaCraftItems.reinforced_vanite_ingot);
		register("vanite_ingot", new ItemStack(NovaCraftItems.vanite_ingot, 9), "X", 'X', NovaCraftBlocks.block_of_vanite);
		register("vanite_crystal", new ItemStack(NovaCraftItems.vanite_crystal, 9), "X", 'X', NovaCraftBlocks.crystallized_vanite);
		register("block_of_vanite", new ItemStack(NovaCraftBlocks.block_of_vanite), "XXX", "XXX", "XXX", 'X', NovaCraftItems.vanite_ingot);
		register("brimstone_dust", new ItemStack(NovaCraftItems.brimstone_dust, 9), "X", 'X', NovaCraftBlocks.block_of_brimstone);
		register("block_of_brimstone", new ItemStack(NovaCraftBlocks.block_of_brimstone), "XXX", "XXX", "XXX", 'X', NovaCraftItems.brimstone_dust);
		register("pherithium_ingot", new ItemStack(NovaCraftItems.pherithium_ingot, 9), "X", 'X', NovaCraftBlocks.block_of_pherithium);
		register("block_of_pherithium", new ItemStack(NovaCraftBlocks.block_of_pherithium), "XXX", "XXX", "XXX", 'X', NovaCraftItems.pherithium_ingot);
		register("nullcube_slime_block", new ItemStack(NovaCraftBlocks.nullcube_slime_block), "XXX", "XXX", "XXX", 'X', NovaCraftItems.null_cube_slime);
		register("null_cube_slime", new ItemStack(NovaCraftItems.null_cube_slime, 9), "X", 'X', NovaCraftBlocks.nullcube_slime_block);
		register("crystallized_vanite", new ItemStack(NovaCraftBlocks.crystallized_vanite), "XXX", "XXX", "XXX", 'X', NovaCraftItems.vanite_crystal);
		register("pherithium_carrot", new ItemStack(NovaCraftItems.pherithium_carrot), "XXX", "XYX", "XXX", 'X', NovaCraftItems.pherithium_scraps, 'Y', Items.golden_carrot);
		register("warden_dust", new ItemStack(NovaCraftItems.warden_dust, 9), "X", 'X', NovaCraftItems.warden_shard);
		register("blazing_coal", new ItemStack(NovaCraftItems.blazing_coal, 9), "X", 'X', NovaCraftBlocks.blazing_coal_block);
		register("blazing_coal_block", new ItemStack(NovaCraftBlocks.blazing_coal_block), "XXX", "XXX", "XXX", 'X', NovaCraftItems.blazing_coal);
		register("iridium_ingot", new ItemStack(NovaCraftItems.iridium_ingot, 9), "X", 'X', NovaCraftBlocks.block_of_iridium);
		register("block_of_iridium", new ItemStack(NovaCraftBlocks.block_of_iridium), "XXX", "XXX", "XXX", 'X', NovaCraftItems.iridium_ingot);

		register("iridium_nugget", new ItemStack(NovaCraftItems.iridium_nugget, 9, 0), "X", 'X', NovaCraftItems.iridium_ingot);
		register("iridium_ingot", new ItemStack(NovaCraftItems.iridium_ingot), "XXX", "XXX", "XXX", 'X', new ItemStack(NovaCraftItems.iridium_nugget, 0, 0));
		register("vanite_nugget", new ItemStack(NovaCraftItems.iridium_nugget, 9, 1), "X", 'X', NovaCraftItems.vanite_ingot);
		register("vanite_ingot", new ItemStack(NovaCraftItems.vanite_ingot), "XXX", "XXX", "XXX", 'X', new ItemStack(NovaCraftItems.iridium_nugget, 0, 1));
		register("diamond_nugget", new ItemStack(NovaCraftItems.diamond_nugget, 9, 0), "X", 'X', Items.diamond);
		register("diamond", new ItemStack(Items.diamond), "XXX", "XXX", "XXX", 'X', new ItemStack(NovaCraftItems.diamond_nugget, 0, 0));
		register("emerald_nugget", new ItemStack(NovaCraftItems.diamond_nugget, 9, 1), "X", 'X', Items.diamond);
		register("emerald", new ItemStack(Items.emerald), "XXX", "XXX", "XXX", 'X', new ItemStack(NovaCraftItems.diamond_nugget, 0, 1));

		register("legendary_beacon", new ItemStack(NovaCraftBlocks.legendary_beacon), "XXX", "XYX", "ZZZ", 'X', new ItemStack(NovaCraftBlocks.vanite_glass), 'Y', NovaCraftItems.warden_core, 'Z', new ItemStack(NovaCraftBlocks.crystallized_end));
		register("warden_core", new ItemStack(NovaCraftItems.warden_core), "XZX", "ZYZ", "XZX", 'Z', NovaCraftItems.sculk_star, 'Y', NovaCraftItems.warden_heart, 'X', new ItemStack(NovaCraftBlocks.nullified_vanite));

		if(Configs.enableAncientCityTotem) {
			register("ancient_city_totem", new ItemStack(NovaCraftItems.ancient_city_totem), "VYV", "XXX", "XZX", 'X', NovaCraftItems.reinforced_vanite_ingot, 'Y', NovaCraftItems.sculked_monitor_eye, 'Z', NovaCraftItems.copartz_shard, 'V', NovaCraftItems.anomalous_essence);
		}

		register("sculked_shard", new ItemStack(NovaCraftItems.sculked_shard, 9), "X", 'X', NovaCraftBlocks.crystallized_sculk);
		register("crystallized_sculk", new ItemStack(NovaCraftBlocks.crystallized_sculk), "XXX", "XXX", "XXX", 'X', NovaCraftItems.sculked_shard);

		register("nullified_vanite", new ItemStack(NovaCraftBlocks.nullified_vanite), "XXX", "XXX", "XXX", 'X', NovaCraftItems.nullified_vanite_alloy);
		register("nullified_vanite_alloy", new ItemStack(NovaCraftItems.nullified_vanite_alloy, 3), "XYX", "YXY", "XYX", 'X', NovaCraftItems.crystallized_vanite_alloy, 'Y', NovaCraftItems.null_shard);

		register("potion_strength_extended", new ItemStack(NovaCraftItems.potion_strength_extended), "   ", " W ", "XYZ", 'X', new ItemStack(Items.potionitem, 1, 8265), 'Y', NovaCraftItems.vanite_bottle, 'Z', Items.blaze_powder, 'W', NovaCraftItems.nullwart_blend);
		register("potion_strength_III", new ItemStack(NovaCraftItems.potion_strength_III), "   ", " W ", "XYZ", 'X', new ItemStack(Items.potionitem, 1, 8233), 'Y', NovaCraftItems.vanite_bottle, 'Z', NovaCraftItems.deepoid_horn, 'W', NovaCraftItems.nullwart_blend);

		register("potion_speed_extended", new ItemStack(NovaCraftItems.potion_speed_extended), "   ", " W ", "XYZ", 'X', new ItemStack(Items.potionitem, 1, 8258), 'Y', NovaCraftItems.vanite_bottle, 'Z', Items.sugar, 'W', NovaCraftItems.nullwart_blend);
		register("potion_speed_III", new ItemStack(NovaCraftItems.potion_speed_III), "   ", " W ", "XYZ", 'X', new ItemStack(Items.potionitem, 1, 8226), 'Y', NovaCraftItems.vanite_bottle, 'Z', NovaCraftItems.enderavis_feather, 'W', NovaCraftItems.nullwart_blend);

		register("potion_regen_extended", new ItemStack(NovaCraftItems.potion_regen_extended), "   ", " W ", "XYZ", 'X', new ItemStack(Items.potionitem, 1, 8257), 'Y', NovaCraftItems.vanite_bottle, 'Z', Items.ghast_tear, 'W', NovaCraftItems.nullwart_blend);
		register("potion_regen_III", new ItemStack(NovaCraftItems.potion_regen_III), "   ", " W ", "XYZ", 'X', new ItemStack(Items.potionitem, 1, 8225), 'Y', NovaCraftItems.vanite_bottle, 'Z', NovaCraftItems.sculk_dweller_heart, 'W', NovaCraftItems.nullwart_blend);

		register("potion_jump_III", new ItemStack(NovaCraftItems.potion_jump_III), "   ", " W ", "XYZ", 'X', new ItemStack(Items.potionitem, 1, 8235), 'Y', NovaCraftItems.vanite_bottle, 'Z', NovaCraftItems.phoenix_feather, 'W', NovaCraftItems.nullwart_blend);

		register("potion_haste", new ItemStack(NovaCraftItems.potion_haste), " W ", "XYZ", " V ", 'X', new ItemStack(Items.potionitem, 1, 16), 'Y', NovaCraftItems.vanite_bottle, 'Z', NovaCraftItems.pherithium_carrot, 'W', NovaCraftItems.nullwart_blend, 'V', Items.blaze_powder);
		register("potion_haste_II", new ItemStack(NovaCraftItems.potion_haste_II), " W ", "XYZ", " V ", 'X', new ItemStack(Items.potionitem, 1, 16), 'Y', NovaCraftItems.vanite_bottle, 'Z', NovaCraftItems.pherithium_carrot, 'W', NovaCraftItems.nullwart_blend, 'V', NovaCraftItems.cave_monitor_scales);

		register("potion_resistance", new ItemStack(NovaCraftItems.potion_resistance), " W ", "XYZ", " V ", 'X', new ItemStack(Items.potionitem, 1, 16), 'Y', NovaCraftItems.vanite_bottle, 'Z', NovaCraftItems.enhanced_enflamed_null_cube_slimeball, 'W', NovaCraftItems.nullwart_blend, 'V', Items.blaze_powder);
		register("potion_resistance", new ItemStack(NovaCraftItems.potion_resistance), " W ", "XYZ", " V ", 'X', new ItemStack(Items.potionitem, 1, 16), 'Y', NovaCraftItems.vanite_bottle, 'Z', NovaCraftItems.warden_tentacle, 'W', NovaCraftItems.nullwart_blend, 'V', Items.blaze_powder);

		register("potion_water_breathing_extended", new ItemStack(NovaCraftItems.potion_water_breathing_extended), "   ", " W ", "XYZ", 'X', new ItemStack(Items.potionitem, 1, 8269), 'Y', NovaCraftItems.vanite_bottle, 'Z', new ItemStack(Items.fish, 1, 3), 'W', NovaCraftItems.nullwart_blend);
		register("potion_night_vision_extended", new ItemStack(NovaCraftItems.potion_night_vision_extended), "   ", " W ", "XYZ", 'X', new ItemStack(Items.potionitem, 1, 8262), 'Y', NovaCraftItems.vanite_bottle, 'Z', Items.golden_carrot, 'W', NovaCraftItems.nullwart_blend);
		register("potion_invisibility_extended", new ItemStack(NovaCraftItems.potion_invisibility_extended), "   ", " W ", "XYZ", 'X', new ItemStack(Items.potionitem, 1, 8270), 'Y', NovaCraftItems.vanite_bottle, 'Z', Items.fermented_spider_eye, 'W', NovaCraftItems.nullwart_blend);
		register("potion_fire_resistance_extended", new ItemStack(NovaCraftItems.potion_fire_resistance_extended), "   ", " W ", "XYZ", 'X', new ItemStack(Items.potionitem, 1, 8259), 'Y', NovaCraftItems.vanite_bottle, 'Z', NovaCraftItems.blazing_serpent_tooth, 'W', NovaCraftItems.nullwart_blend);

		register("ophidian_scales", new ItemStack(NovaCraftItems.ophidian_scales, 3), "AZB", "XYX", "CZD", 'X', new ItemStack(NovaCraftItems.deep_one_scales), 'Y', NovaCraftItems.corrupted_essence, 'Z', NovaCraftItems.deepoid_scales, 'A', NovaCraftItems.sea_serpent_scales, 'B', NovaCraftItems.sculked_monitor_scales, 'C', NovaCraftItems.cave_monitor_scales, 'D', NovaCraftItems.blazing_serpent_scales);

		register("ophidian_helmet", new ItemStack(NovaCraftItems.ophidian_helmet), "ZXZ", "XYX", "ZXZ", 'X', NovaCraftItems.ophidian_scales, 'Y', NovaCraftItems.crystallized_vanite_helmet, 'Z', NovaCraftItems.anomalous_essence);
		register("ophidian_chestplate", new ItemStack(NovaCraftItems.ophidian_chestplate), "ZXZ", "XYX", "ZXZ", 'X', NovaCraftItems.ophidian_scales, 'Y', NovaCraftItems.crystallized_vanite_chestplate, 'Z', NovaCraftItems.anomalous_essence);
		register("ophidian_leggings", new ItemStack(NovaCraftItems.ophidian_leggings), "ZXZ", "XYX", "ZXZ", 'X', NovaCraftItems.ophidian_scales, 'Y', NovaCraftItems.crystallized_vanite_leggings, 'Z', NovaCraftItems.anomalous_essence);
		register("ophidian_boots", new ItemStack(NovaCraftItems.ophidian_boots), "ZXZ", "XYX", "ZXZ", 'X', NovaCraftItems.ophidian_scales, 'Y', NovaCraftItems.crystallized_vanite_boots, 'Z', NovaCraftItems.anomalous_essence);

		register("ophidian_sword", new ItemStack(NovaCraftItems.ophidian_sword), "  W", "XY ", "ZX ", 'X', NovaCraftItems.enflamed_null_cube_slimeball, 'Y', NovaCraftItems.crystallized_vanite_sword, 'Z', NovaCraftItems.deep_one_bone, 'W', NovaCraftItems.corrupted_essence);
		register("ophidian_pickaxe", new ItemStack(NovaCraftItems.ophidian_pickaxe), "  W", "XY ", "ZX ", 'X', NovaCraftItems.enflamed_null_cube_slimeball, 'Y', NovaCraftItems.crystallized_vanite_pickaxe, 'Z', NovaCraftItems.deep_one_bone, 'W', NovaCraftItems.corrupted_essence);
		register("ophidian_shovel", new ItemStack(NovaCraftItems.ophidian_shovel), "  W", "XY ", "ZX ", 'X', NovaCraftItems.enflamed_null_cube_slimeball, 'Y', NovaCraftItems.crystallized_vanite_shovel, 'Z', NovaCraftItems.deep_one_bone, 'W', NovaCraftItems.corrupted_essence);
		register("ophidian_axe", new ItemStack(NovaCraftItems.ophidian_axe), "  W", "XY ", "ZX ", 'X', NovaCraftItems.enflamed_null_cube_slimeball, 'Y', NovaCraftItems.crystallized_vanite_axe, 'Z', NovaCraftItems.deep_one_bone, 'W', NovaCraftItems.corrupted_essence);
		register("ophidian_hoe", new ItemStack(NovaCraftItems.ophidian_hoe), "  W", "XY ", "ZX ", 'X', NovaCraftItems.enflamed_null_cube_slimeball, 'Y', NovaCraftItems.crystallized_vanite_hoe, 'Z', NovaCraftItems.deep_one_bone, 'W', NovaCraftItems.corrupted_essence);
		register("ophidian_bow", new ItemStack(NovaCraftItems.ophidian_bow), " XW", "ZYX", " XW", 'X', NovaCraftItems.ophidian_scales , 'Y', NovaCraftItems.crystallized_vanite_bow, 'Z', NovaCraftItems.deep_one_bone, 'W', NovaCraftItems.enflamed_null_cube_slimeball);

		register("deepoid_star", new ItemStack(NovaCraftItems.deepoid_star), "ZWZ", "XYX", "ZWZ", 'X', NovaCraftItems.deepoid_scales, 'Y', Items.nether_star, 'Z', NovaCraftItems.anomalous_essence, 'W', NovaCraftItems.vanite_crystal);

		register("phoenix_razor", new ItemStack(NovaCraftItems.phoenix_razor), " X ", "WYX", "ZW ", 'X', NovaCraftItems.yttrlinsite_shard, 'Y', NovaCraftItems.tophinite_gemstone, 'Z', NovaCraftItems.ionizatior_rod, 'W', NovaCraftItems.phoenix_feather);

		register("tophinite_hammer", new ItemStack(NovaCraftItems.tophinite_hammer), " WV", "XYW", "ZX ", 'X', NovaCraftItems.superheated_magma_cream, 'Y', NovaCraftItems.ionizatior_rod, 'Z', NovaCraftItems.deep_one_bone, 'W', NovaCraftItems.deepoid_horn, 'V', new ItemStack(NovaCraftBlocks.block_of_tophinite));

		register("pherithium_shickaxe", new ItemStack(NovaCraftItems.pherithium_shickaxe), "UXU", "YZW", "UVU", 'X', NovaCraftItems.pherithium_pickaxe, 'Y', NovaCraftItems.pherithium_axe, 'Z', NovaCraftItems.reinforced_vanite_ingot, 'W', NovaCraftItems.pherithium_shovel, 'V', NovaCraftItems.pherithium_hoe, 'U', Items.magma_cream);
		register("reinforced_pherithium_shickaxe", new ItemStack(NovaCraftItems.reinforced_pherithium_shickaxe), " XY", "ZWX", "UZ ", 'X', NovaCraftItems.deepoid_horn, 'Y', NovaCraftItems.superheated_magma_cream, 'Z', NovaCraftItems.sculked_shard, 'W', NovaCraftItems.pherithium_shickaxe, 'U', NovaCraftItems.deep_one_bone);

		register("diablo", new ItemStack(NovaCraftItems.diablo), "WVW", "ZYU", "XZW", 'X', NovaCraftItems.deep_one_bone, 'Y', NovaCraftItems.scythe, 'Z', NovaCraftItems.ophidian_scales, 'W', NovaCraftItems.ionizatior_powder, 'U', NovaCraftItems.superheated_magma_cream, 'V', NovaCraftItems.blazing_serpent_tooth);

		register("kylazite_sword", new ItemStack(NovaCraftItems.kylazite_sword), "XWV", "ZYW", "XZX", 'X', NovaCraftItems.crystallized_end_shard , 'Y', NovaCraftItems.klangite_sword, 'Z', NovaCraftItems.enflamed_null_cube_slimeball, 'W', NovaCraftItems.nullified_dust, 'V', NovaCraftItems.corrupted_essence);
		register("kylazite_pickaxe", new ItemStack(NovaCraftItems.kylazite_pickaxe), "XWV", "ZYW", "XZX", 'X', NovaCraftItems.crystallized_end_shard , 'Y', NovaCraftItems.klangite_pickaxe, 'Z', NovaCraftItems.enflamed_null_cube_slimeball, 'W', NovaCraftItems.nullified_dust, 'V', NovaCraftItems.corrupted_essence);
		register("kylazite_shovel", new ItemStack(NovaCraftItems.kylazite_shovel), "XWV", "ZYW", "XZX", 'X', NovaCraftItems.crystallized_end_shard , 'Y', NovaCraftItems.klangite_shovel, 'Z', NovaCraftItems.enflamed_null_cube_slimeball, 'W', NovaCraftItems.nullified_dust, 'V', NovaCraftItems.corrupted_essence);
		register("kylazite_axe", new ItemStack(NovaCraftItems.kylazite_axe), "XWV", "ZYW", "XZX", 'X', NovaCraftItems.crystallized_end_shard , 'Y', NovaCraftItems.klangite_axe, 'Z', NovaCraftItems.enflamed_null_cube_slimeball, 'W', NovaCraftItems.nullified_dust, 'V', NovaCraftItems.corrupted_essence);
		register("kylazite_hoe", new ItemStack(NovaCraftItems.kylazite_hoe), "XWV", "ZYW", "XZX", 'X', NovaCraftItems.crystallized_end_shard , 'Y', NovaCraftItems.klangite_hoe, 'Z', NovaCraftItems.enflamed_null_cube_slimeball, 'W', NovaCraftItems.nullified_dust, 'V', NovaCraftItems.corrupted_essence);
		register("kylazite_bow", new ItemStack(NovaCraftItems.kylazite_bow), "XZW", "VYZ", "XZW", 'X', NovaCraftItems.nullified_dust , 'Y', NovaCraftItems.klangite_bow, 'Z', NovaCraftItems.crystallized_end_shard, 'W', NovaCraftItems.enflamed_null_cube_slimeball, 'V', NovaCraftItems.corrupted_essence);

		register("kylazite_helmet", new ItemStack(NovaCraftItems.kylazite_helmet), "XWV", "ZYW", "XZX", 'X', NovaCraftItems.crystallized_end_shard , 'Y', NovaCraftItems.klangite_helmet, 'Z', NovaCraftItems.enflamed_null_cube_slimeball, 'W', NovaCraftItems.nullified_dust, 'V', NovaCraftItems.corrupted_essence);
		register("kylazite_chestplate", new ItemStack(NovaCraftItems.kylazite_chestplate), "XWV", "ZYW", "XZX", 'X', NovaCraftItems.crystallized_end_shard , 'Y', NovaCraftItems.klangite_chestplate, 'Z', NovaCraftItems.enflamed_null_cube_slimeball, 'W', NovaCraftItems.nullified_dust, 'V', NovaCraftItems.corrupted_essence);
		register("kylazite_leggings", new ItemStack(NovaCraftItems.kylazite_leggings), "XWV", "ZYW", "XZX", 'X', NovaCraftItems.crystallized_end_shard , 'Y', NovaCraftItems.klangite_leggings, 'Z', NovaCraftItems.enflamed_null_cube_slimeball, 'W', NovaCraftItems.nullified_dust, 'V', NovaCraftItems.corrupted_essence);
		register("kylazite_boots", new ItemStack(NovaCraftItems.kylazite_boots), "XWV", "ZYW", "XZX", 'X', NovaCraftItems.crystallized_end_shard , 'Y', NovaCraftItems.klangite_boots, 'Z', NovaCraftItems.enflamed_null_cube_slimeball, 'W', NovaCraftItems.nullified_dust, 'V', NovaCraftItems.corrupted_essence);

		register("powered_ancient_city_artifact", new ItemStack(NovaCraftItems.powered_ancient_city_artifact), "XVX", "VYV", "XZX", 'X', NovaCraftItems.static_essence, 'Y', NovaCraftItems.sculked_monitor_eye, 'Z', NovaCraftItems.ancient_city_artifact, 'V', NovaCraftItems.wardling_dust);

		if (Loader.isModLoaded("etfuturum")) {
			try {
				Block ancient_debris = GameRegistry.findBlock("etfuturum", "ancient_debris");
				if (ancient_debris != null && Configs.enableBlockOfRawNetheriteRecipe) {
					register("netherite_scrap", new ItemStack(OtherModItems.netherite_scrap, 9), "X", 'X', NovaCraftBlocks.raw_netherite);
					register("raw_netherite", new ItemStack(NovaCraftBlocks.raw_netherite), "XXX", "XXX", "XXX", 'X', OtherModItems.netherite_scrap);
				}
			} catch (Exception ex) {
				if (Configs.enableDebugMode) {
					System.out.println("Netherite from Et Futurum Requiem is missing, skipping Raw Netherite Recipes...");
				}
			}
		}

		if (Loader.isModLoaded("etfuturum")) {
			try {
				Item rabbit_foot = GameRegistry.findItem("etfuturum", "rabbit_foot");
				if (rabbit_foot != null && Configs.enableAlternateAmpJumpPotionRecipe) {
					register("potion_jump_extended", new ItemStack(NovaCraftItems.potion_jump_extended), "   ", " W ", "XYZ", 'X', new ItemStack(Items.potionitem, 1, 8267), 'Y', NovaCraftItems.vanite_bottle, 'Z', OtherModItems.rabbit_foot, 'W', NovaCraftItems.nullwart_blend);
				}
				else {
					register("potion_jump_extended", new ItemStack(NovaCraftItems.potion_jump_extended), "   ", " W ", "XYZ", 'X', new ItemStack(Items.potionitem, 1, 8267), 'Y', NovaCraftItems.vanite_bottle, 'Z', NovaCraftItems.tsavorokite_shard, 'W', NovaCraftItems.nullwart_blend);
				}
			} catch (Exception ex) {
				if (Configs.enableDebugMode) {
					System.out.println("Rabbit's Foot from Et Futurum Requiem is missing, using alternate recipe...");
				}
				register("potion_jump_extended", new ItemStack(NovaCraftItems.potion_jump_extended), "   ", " W ", "XYZ", 'X', new ItemStack(Items.potionitem, 1, 8267), 'Y', NovaCraftItems.vanite_bottle, 'Z', NovaCraftItems.tsavorokite_shard, 'W', NovaCraftItems.nullwart_blend);
			}
		} else {
			register("potion_jump_extended", new ItemStack(NovaCraftItems.potion_jump_extended), "   ", " W ", "XYZ", 'X', new ItemStack(Items.potionitem, 1, 8267), 'Y', NovaCraftItems.vanite_bottle, 'Z', NovaCraftItems.tsavorokite_shard, 'W', NovaCraftItems.nullwart_blend);
		}

		if (Loader.isModLoaded("aether_legacy") && Configs.enableRawDivineral) {
			try {
				Item enchanted_divineral = GameRegistry.findItem("aether_legacy", "enchanted_divineral");
				if (enchanted_divineral != null) {
					register("enchanted_divineral", new ItemStack(OtherModItems.enchanted_divineral, 9), "X", 'X', NovaCraftBlocks.raw_divineral);
					register("raw_divineral", new ItemStack(NovaCraftBlocks.raw_divineral), "XXX", "XXX", "XXX", 'X', OtherModItems.enchanted_divineral);
				}
			} catch (Exception ex) {
				if (Configs.enableDebugMode) {
					System.out.println("Item not found for recipe, skipping...");
				}
			}
		}

		if (Loader.isModLoaded("aether_legacy") && Configs.enableNovaCraftGloves) {
			try {
				Item vanite_gloves = GameRegistry.findItem("aether_legacy", "vanite_gloves");
				if (vanite_gloves != null) {
					register("pherithium_gloves", new ItemStack(OtherModItems.pherithium_gloves), "C C", 'C', NovaCraftItems.pherithium_ingot);
					register("vanite_gloves", new ItemStack(OtherModItems.vanite_gloves), "C C", 'C', NovaCraftItems.vanite_ingot);
					register("klangite_gloves", new ItemStack(OtherModItems.klangite_gloves), "C C", 'C', NovaCraftItems.klangite_ingot);
				}
			} catch (Exception ex) {
				if (Configs.enableDebugMode) {
					System.out.println("Item not found for recipe, skipping...");
				}
			}
		}

		register("fractured_heart_of_the_end", new ItemStack(NovaCraftItems.fractured_heart_of_the_end, 4), "X", 'X', NovaCraftItems.heart_of_the_end);
		register("disk_5", new ItemStack(NovaCraftItems.disc_5), "XXX", "XXX", "XXX", 'X', NovaCraftItems.disc_fragment_5);

		register("vanite_bottle", new ItemStack(NovaCraftItems.vanite_bottle, 16), "X X", "XYX", " X ", 'X', NovaCraftBlocks.vanite_glass, 'Y', NovaCraftItems.reinforced_vanite_ingot);

		register("copartz_block", new ItemStack(NovaCraftBlocks.copartz_block), "XXX", "XXX", "XXX", 'X', NovaCraftItems.copartz_shard);
		register("larimar_block", new ItemStack(NovaCraftBlocks.larimar_block), "XXX", "XXX", "XXX", 'X', NovaCraftItems.larimar_shard);
		register("tsavorokite_block", new ItemStack(NovaCraftBlocks.tsavorokite_block), "XXX", "XXX", "XXX", 'X', NovaCraftItems.tsavorokite_shard);
		register("yttrlinsite_block", new ItemStack(NovaCraftBlocks.yttrlinsite_block), "XXX", "XXX", "XXX", 'X', NovaCraftItems.yttrlinsite_shard);
		register("aether_block", new ItemStack(NovaCraftBlocks.aether_block), "XXX", "XXX", "XXX", 'X', NovaCraftItems.aether_shard);
		register("echo_block", new ItemStack(NovaCraftBlocks.echo_block), "XXX", "XXX", "XXX", 'X', NovaCraftItems.echo_shard);
		register("null_block", new ItemStack(NovaCraftBlocks.null_block), "XXX", "XXX", "XXX", 'X', NovaCraftItems.null_shard);
		register("variegated_block", new ItemStack(NovaCraftBlocks.variegated_block), "XXX", "XXX", "XXX", 'X', NovaCraftItems.variegated_shard);
		register("luminant_ingot", new ItemStack(NovaCraftItems.luminant_ingot), "ZXX", "XYX", "XXZ", 'X', NovaCraftItems.luminant_gel, 'Y', Items.gold_ingot, 'Z', NovaCraftItems.flaming_pitcher_petal);

		register("pherithium_glass", new ItemStack(NovaCraftBlocks.pherithium_glass, 2), "XXX", "XYX", "ZZZ", 'X', NovaCraftItems.pherithium_scraps, 'Y', NovaCraftItems.copartz_shard, 'Z', Blocks.obsidian);
		register("pherithium_glass", new ItemStack(NovaCraftBlocks.pherithium_glass, 2), "XXX", "XYX", "ZZZ", 'X', NovaCraftItems.pherithium_scraps, 'Y', NovaCraftItems.larimar_shard, 'Z', Blocks.obsidian);
		register("pherithium_glass", new ItemStack(NovaCraftBlocks.pherithium_glass, 2), "XXX", "XYX", "ZZZ", 'X', NovaCraftItems.pherithium_scraps, 'Y', NovaCraftItems.tsavorokite_shard, 'Z', Blocks.obsidian);
		register("pherithium_glass", new ItemStack(NovaCraftBlocks.pherithium_glass, 2), "XXX", "XYX", "ZZZ", 'X', NovaCraftItems.pherithium_scraps, 'Y', NovaCraftItems.yttrlinsite_shard, 'Z', Blocks.obsidian);

		register("vanite_glass", new ItemStack(NovaCraftBlocks.vanite_glass, 4), "XXX", "XYX", "XXX", 'X', NovaCraftItems.vanite_ingot, 'Y', NovaCraftBlocks.pherithium_glass);
		register("vanite_bucket", new ItemStack(NovaCraftItems.vanite_bucket), "   ", "X X", " X ", 'X', NovaCraftItems.vanite_ingot);

		register("anomalous_shard", new ItemStack(NovaCraftItems.anomalous_shard, 2), "XYX", "Y Y", "XYX", 'X', NovaCraftItems.anomalous_essence, 'Y', NovaCraftItems.variegated_shard);
		register("blazlinite_blend", new ItemStack(NovaCraftBlocks.blazlinite_blend), "XXX", "XXX", "XXX", 'X', NovaCraftItems.blazinite_powder);

		register("sculked_shard", new ItemStack(NovaCraftItems.sculked_shard, 2), "ZYZ", "YXY", "ZYZ", 'X', NovaCraftItems.echo_shard, 'Y', new ItemStack(NovaCraftBlocks.sculk_tentacle_2, 1, 6), 'Z', NovaCraftItems.superheated_magma_cream);
		register("eternal_caller", new ItemStack(NovaCraftItems.eternal_caller), "ZYZ", "YXY", "ZWZ", 'X', Items.nether_star, 'Y', NovaCraftItems.anomalous_essence, 'Z', NovaCraftItems.sculked_shard, 'W', NovaCraftItems.nullifier_core);

		register("budding_copartz", new ItemStack(NovaCraftBlocks.budding_copartz_block, 2), "XXX", "XYX", "ZZZ", 'X', NovaCraftBlocks.copartz_block, 'Y', NovaCraftItems.tophinite_gemstone, 'Z', NovaCraftBlocks.cobbled_grimstone);
		register("budding_larimar", new ItemStack(NovaCraftBlocks.budding_larimar_block, 2), "XXX", "XYX", "ZZZ", 'X', NovaCraftBlocks.larimar_block, 'Y', NovaCraftItems.tophinite_gemstone, 'Z', NovaCraftBlocks.cobbled_grimstone);
		register("budding_tsavorokite", new ItemStack(NovaCraftBlocks.budding_tsavorokite_block, 2), "XXX", "XYX", "ZZZ", 'X', NovaCraftBlocks.tsavorokite_block, 'Y', NovaCraftItems.tophinite_gemstone, 'Z', NovaCraftBlocks.cobbled_grimstone);
		register("budding_yttrlinsite", new ItemStack(NovaCraftBlocks.budding_yttrlinsite_block, 2), "XXX", "XYX", "ZZZ", 'X', NovaCraftBlocks.yttrlinsite_block, 'Y', NovaCraftItems.tophinite_gemstone, 'Z', NovaCraftBlocks.basal);
		register("budding_aether", new ItemStack(NovaCraftBlocks.budding_aether_block, 2), "XXX", "XYX", "ZZZ", 'X', NovaCraftBlocks.aether_block, 'Y', NovaCraftItems.tophinite_gemstone, 'Z', NovaCraftBlocks.cobbled_etherstone);
		register("budding_echo", new ItemStack(NovaCraftBlocks.budding_echo_block, 2), "XXX", "XYX", "ZZZ", 'X', NovaCraftBlocks.echo_block, 'Y', NovaCraftItems.xancium_ingot, 'Z', NovaCraftBlocks.frontierslate);
		register("budding_null", new ItemStack(NovaCraftBlocks.budding_null_block, 2), "XXX", "XYX", "ZZZ", 'X', NovaCraftBlocks.null_block, 'Y', NovaCraftItems.dark_essence, 'Z', NovaCraftBlocks.frontierslate);

		register("enflamed_null_cube_slimeball", new ItemStack(NovaCraftItems.enflamed_null_cube_slimeball, 2), "WXZ", "XYX", "ZXW", 'X', NovaCraftItems.superheated_magma_cream, 'Y', NovaCraftItems.null_cube_slime, 'Z', NovaCraftItems.yttrlinsite_shard, 'W', NovaCraftItems.dark_essence);
		register("crystallized_vanite_alloy", new ItemStack(NovaCraftItems.crystallized_vanite_alloy, 3), "ZXZ", "XYX", "ZXZ", 'X', NovaCraftItems.vanite_crystal, 'Y', NovaCraftItems.raw_klangite, 'Z', NovaCraftItems.superheated_magma_cream);

		register("arrow", new ItemStack(Items.arrow, 4), "X  ", "Y  ", "Z  ", 'X', NovaCraftItems.enderavis_feather, 'Y', Items.stick, 'Z', Items.flint);
		register("arrow", new ItemStack(Items.arrow, 4), "X  ", "Y  ", "Z  ", 'X', NovaCraftItems.phoenix_feather, 'Y', Items.stick, 'Z', Items.flint);
		register("torch", new ItemStack(Blocks.torch, 16), "X  ", "Y  ", "Y  ", 'X', NovaCraftItems.blazing_coal, 'Y', Items.stick);

		register("glow_torch", new ItemStack(NovaCraftBlocks.glow_torch, 4), "X  ", "Z  ", "Y  ", 'X', NovaCraftItems.glow_ink_sac, 'Z', Items.coal, 'Y', Items.stick);
		register("vanite_torch", new ItemStack(NovaCraftBlocks.vanite_torch, 4), "X  ", "Z  ", "Y  ", 'X', NovaCraftItems.ionizatior_powder, 'Z', Items.coal, 'Y', NovaCraftItems.vanite_ingot);
		register("dim_vanite_torch", new ItemStack(NovaCraftBlocks.dim_vanite_torch, 4), "X  ", "Z  ", "Y  ", 'X', Items.blaze_powder, 'Z', Items.coal, 'Y', NovaCraftItems.vanite_ingot);

		register("deepoid_bricks", new ItemStack(NovaCraftBlocks.deepoid_bricks, 4), "XYX", "YZY", "XYX", 'X', NovaCraftBlocks.block_of_vanite, 'Y', NovaCraftItems.deepoid_scales, 'Z', NovaCraftItems.copartz_shard);
		register("deepoid_power_core", new ItemStack(NovaCraftBlocks.deepoid_power_core, 2), "XYX", "YZY", "XYX", 'X', NovaCraftBlocks.blazlinite_blend, 'Y', NovaCraftItems.blazing_serpent_scales, 'Z', NovaCraftItems.vanite_bucket_molten_vanite);

		//Stairs
		register("grimstone_stairs", new ItemStack(NovaCraftBlocks.grimstone_stairs, 4), "Z  ", "ZZ ", "ZZZ", 'Z', new ItemStack(NovaCraftBlocks.grimstone));
		register("cobbled_grimstone_stairs", new ItemStack(NovaCraftBlocks.cobbled_grimstone_stairs, 4), "Z  ", "ZZ ", "ZZZ", 'Z', new ItemStack(NovaCraftBlocks.cobbled_grimstone));
		register("grimstone_brick_stairs", new ItemStack(NovaCraftBlocks.grimstone_brick_stairs, 4), "Z  ", "ZZ ", "ZZZ", 'Z', new ItemStack(NovaCraftBlocks.grimstone_bricks));
		register("grimstone_tiled_stairs", new ItemStack(NovaCraftBlocks.grimstone_tiled_stairs, 4), "Z  ", "ZZ ", "ZZZ", 'Z', new ItemStack(NovaCraftBlocks.grimstone_tiles));

		register("nullstone_stairs", new ItemStack(NovaCraftBlocks.nullstone_stairs, 4), "Z  ", "ZZ ", "ZZZ", 'Z', new ItemStack(NovaCraftBlocks.nullstone));
		register("cobbled_nullstone_stairs", new ItemStack(NovaCraftBlocks.cobbled_nullstone_stairs, 4), "Z  ", "ZZ ", "ZZZ", 'Z', new ItemStack(NovaCraftBlocks.cobbled_nullstone));
		register("nullstone_brick_stairs", new ItemStack(NovaCraftBlocks.nullstone_brick_stairs, 4), "Z  ", "ZZ ", "ZZZ", 'Z', new ItemStack(NovaCraftBlocks.nullstone_bricks));
		register("nullstone_tiled_stairs", new ItemStack(NovaCraftBlocks.nullstone_tiled_stairs, 4), "Z  ", "ZZ ", "ZZZ", 'Z', new ItemStack(NovaCraftBlocks.nullstone_tiles));

		register("etherstone_stairs", new ItemStack(NovaCraftBlocks.etherstone_stairs, 4), "Z  ", "ZZ ", "ZZZ", 'Z', new ItemStack(NovaCraftBlocks.etherstone));
		register("cobbled_etherstone_stairs", new ItemStack(NovaCraftBlocks.cobbled_etherstone_stairs, 4), "Z  ", "ZZ ", "ZZZ", 'Z', new ItemStack(NovaCraftBlocks.cobbled_etherstone));
		register("etherstone_brick_stairs", new ItemStack(NovaCraftBlocks.etherstone_brick_stairs, 4), "Z  ", "ZZ ", "ZZZ", 'Z', new ItemStack(NovaCraftBlocks.etherstone_bricks));
		register("etherstone_tiled_stairs", new ItemStack(NovaCraftBlocks.etherstone_tiled_stairs, 4), "Z  ", "ZZ ", "ZZZ", 'Z', new ItemStack(NovaCraftBlocks.etherstone_tiles));

		register("sculk_brick_stairs", new ItemStack(NovaCraftBlocks.sculk_brick_stairs, 4), "Z  ", "ZZ ", "ZZZ", 'Z', new ItemStack(NovaCraftBlocks.sculk_bricks));
		register("sculk_tiled_stairs", new ItemStack(NovaCraftBlocks.sculk_tiled_stairs, 4), "Z  ", "ZZ ", "ZZZ", 'Z', new ItemStack(NovaCraftBlocks.sculk_tiles));

		register("frontierslate_stairs", new ItemStack(NovaCraftBlocks.frontierslate_stairs, 4), "Z  ", "ZZ ", "ZZZ", 'Z', new ItemStack(NovaCraftBlocks.frontierslate));
		register("frontierslate_brick_stairs", new ItemStack(NovaCraftBlocks.frontierslate_brick_stairs, 4), "Z  ", "ZZ ", "ZZZ", 'Z', new ItemStack(NovaCraftBlocks.frontierslate_bricks));

		register("nullwart_brick_stairs", new ItemStack(NovaCraftBlocks.nullwart_brick_stairs, 4), "Z  ", "ZZ ", "ZZZ", 'Z', new ItemStack(NovaCraftBlocks.nullwart_bricks));
		register("vanite_brick_stairs", new ItemStack(NovaCraftBlocks.vanite_brick_stairs, 4), "Z  ", "ZZ ", "ZZZ", 'Z', new ItemStack(NovaCraftBlocks.vanite_bricks));
		register("carved_vanite_brick_stairs", new ItemStack(NovaCraftBlocks.carved_vanite_brick_stairs, 4), "Z  ", "ZZ ", "ZZZ", 'Z', new ItemStack(NovaCraftBlocks.carved_vanite_bricks));

		register("lacuna_stairs", new ItemStack(NovaCraftBlocks.lacuna_stairs, 4), "Z  ", "ZZ ", "ZZZ", 'Z', new ItemStack(NovaCraftBlocks.lacuna_planks));
		register("luminant_stairs", new ItemStack(NovaCraftBlocks.luminant_stairs, 4), "Z  ", "ZZ ", "ZZZ", 'Z', new ItemStack(NovaCraftBlocks.luminant_planks));

		register("basal_stairs", new ItemStack(NovaCraftBlocks.basal_stairs, 4), "Z  ", "ZZ ", "ZZZ", 'Z', new ItemStack(NovaCraftBlocks.basal));
		register("basal_brick_stairs", new ItemStack(NovaCraftBlocks.basal_brick_stairs, 4), "Z  ", "ZZ ", "ZZZ", 'Z', new ItemStack(NovaCraftBlocks.basal_bricks));

		//Walls
		register("grimstone_wall", new ItemStack(NovaCraftBlocks.grimstone_wall, 6), "ZZZ", "ZZZ", 'Z', new ItemStack(NovaCraftBlocks.grimstone));
		register("cobbled_grimstone_wall", new ItemStack(NovaCraftBlocks.cobbled_grimstone_wall, 6), "ZZZ", "ZZZ", 'Z', new ItemStack(NovaCraftBlocks.cobbled_grimstone));
		register("grimstone_brick_wall", new ItemStack(NovaCraftBlocks.grimstone_brick_wall, 6), "ZZZ", "ZZZ", 'Z', new ItemStack(NovaCraftBlocks.grimstone_bricks));
		register("grimstone_tiled_wall", new ItemStack(NovaCraftBlocks.grimstone_tiled_wall, 6), "ZZZ", "ZZZ", 'Z', new ItemStack(NovaCraftBlocks.grimstone_tiles));
		register("moss_block", new ItemStack(NovaCraftBlocks.moss_block, 1), "ZZZ", "ZZZ", 'Z', new ItemStack(NovaCraftBlocks.moss_carpet));
		register("arctic_moss_block", new ItemStack(NovaCraftBlocks.arctic_moss_block, 1), "ZZZ", "ZZZ", 'Z', new ItemStack(NovaCraftBlocks.arctic_moss_carpet));

		register("nullstone_wall", new ItemStack(NovaCraftBlocks.nullstone_wall, 6), "ZZZ", "ZZZ", 'Z', new ItemStack(NovaCraftBlocks.nullstone));
		register("cobbled_nullstone_wall", new ItemStack(NovaCraftBlocks.cobbled_nullstone_wall, 6), "ZZZ", "ZZZ", 'Z', new ItemStack(NovaCraftBlocks.cobbled_nullstone));
		register("nullstone_brick_wall", new ItemStack(NovaCraftBlocks.nullstone_brick_wall, 6), "ZZZ", "ZZZ", 'Z', new ItemStack(NovaCraftBlocks.nullstone_bricks));
		register("nullstone_tiled_wall", new ItemStack(NovaCraftBlocks.nullstone_tiled_wall, 6), "ZZZ", "ZZZ", 'Z', new ItemStack(NovaCraftBlocks.nullstone_tiles));

		register("sculk_brick_wall", new ItemStack(NovaCraftBlocks.sculk_brick_wall, 6), "ZZZ", "ZZZ", 'Z', new ItemStack(NovaCraftBlocks.sculk_bricks));
		register("sculk_tiled_wall", new ItemStack(NovaCraftBlocks.sculk_tiled_wall, 6), "ZZZ", "ZZZ", 'Z', new ItemStack(NovaCraftBlocks.sculk_tiles));

		register("basal_wall", new ItemStack(NovaCraftBlocks.basal_wall, 6), "ZZZ", "ZZZ", 'Z', new ItemStack(NovaCraftBlocks.basal));
		register("basal_brick_wall", new ItemStack(NovaCraftBlocks.basal_brick_wall, 6), "ZZZ", "ZZZ", 'Z', new ItemStack(NovaCraftBlocks.basal_bricks));

		register("nullwart_bricks_wall", new ItemStack(NovaCraftBlocks.nullwart_brick_wall, 6), "ZZZ", "ZZZ", 'Z', new ItemStack(NovaCraftBlocks.nullwart_bricks));
		register("vanite_brick_wall", new ItemStack(NovaCraftBlocks.vanite_brick_wall, 6), "ZZZ", "ZZZ", 'Z', new ItemStack(NovaCraftBlocks.vanite_bricks));
		register("carved_vanite_brick_wall", new ItemStack(NovaCraftBlocks.carved_vanite_brick_wall, 6), "ZZZ", "ZZZ", 'Z', new ItemStack(NovaCraftBlocks.carved_vanite_bricks));

		register("etherstone_wall", new ItemStack(NovaCraftBlocks.etherstone_wall, 6), "ZZZ", "ZZZ", 'Z', new ItemStack(NovaCraftBlocks.etherstone));
		register("cobbled_etherstone_wall", new ItemStack(NovaCraftBlocks.cobbled_etherstone_wall, 6), "ZZZ", "ZZZ", 'Z', new ItemStack(NovaCraftBlocks.cobbled_etherstone));
		register("etherstone_brick_wall", new ItemStack(NovaCraftBlocks.etherstone_brick_wall, 6), "ZZZ", "ZZZ", 'Z', new ItemStack(NovaCraftBlocks.etherstone_bricks));
		register("etherstone_tiled_wall", new ItemStack(NovaCraftBlocks.etherstone_tiled_wall, 6), "ZZZ", "ZZZ", 'Z', new ItemStack(NovaCraftBlocks.etherstone_tiles));


		register("frontierslate_wall", new ItemStack(NovaCraftBlocks.frontierslate_wall, 6), "ZZZ", "ZZZ", 'Z', new ItemStack(NovaCraftBlocks.frontierslate));
		register("frontierslate_brick_wall", new ItemStack(NovaCraftBlocks.frontierslate_brick_wall, 6), "ZZZ", "ZZZ", 'Z', new ItemStack(NovaCraftBlocks.frontierslate_bricks));

		//Slabs
		register("grimstone_slab", new ItemStack(NovaCraftBlocks.grimstone_slab, 6), "ZZZ", 'Z', new ItemStack(NovaCraftBlocks.grimstone));
		register("cobbled_grimstone_slab", new ItemStack(NovaCraftBlocks.cobbled_grimstone_slab, 6), "ZZZ", 'Z', new ItemStack(NovaCraftBlocks.cobbled_grimstone));
		register("grimstone_brick_slab", new ItemStack(NovaCraftBlocks.grimstone_brick_slab, 6), "ZZZ", 'Z', new ItemStack(NovaCraftBlocks.grimstone_bricks));
		register("grimstone_tiled_slab", new ItemStack(NovaCraftBlocks.grimstone_tiled_slab, 6), "ZZZ", 'Z', new ItemStack(NovaCraftBlocks.grimstone_tiles));

		register("nullstone_slab", new ItemStack(NovaCraftBlocks.nullstone_slab, 6), "ZZZ", 'Z', new ItemStack(NovaCraftBlocks.nullstone));
		register("cobbled_nullstone_slab", new ItemStack(NovaCraftBlocks.cobbled_nullstone_slab, 6), "ZZZ", 'Z', new ItemStack(NovaCraftBlocks.cobbled_nullstone));
		register("nullstone_brick_slab", new ItemStack(NovaCraftBlocks.nullstone_brick_slab, 6), "ZZZ", 'Z', new ItemStack(NovaCraftBlocks.nullstone_bricks));
		register("nullstone_tiled_slab", new ItemStack(NovaCraftBlocks.nullstone_tiled_slab, 6), "ZZZ", 'Z', new ItemStack(NovaCraftBlocks.nullstone_tiles));

		register("etherstone_slab", new ItemStack(NovaCraftBlocks.etherstone_slab, 6), "ZZZ", 'Z', new ItemStack(NovaCraftBlocks.etherstone));
		register("cobbled_etherstone_slab", new ItemStack(NovaCraftBlocks.cobbled_etherstone_slab, 6), "ZZZ", 'Z', new ItemStack(NovaCraftBlocks.cobbled_etherstone));
		register("etherstone_brick_slab", new ItemStack(NovaCraftBlocks.etherstone_brick_slab, 6), "ZZZ", 'Z', new ItemStack(NovaCraftBlocks.etherstone_bricks));
		register("etherstone_tiled_slab", new ItemStack(NovaCraftBlocks.etherstone_tiled_slab, 6), "ZZZ", 'Z', new ItemStack(NovaCraftBlocks.etherstone_tiles));

		register("basal_slab", new ItemStack(NovaCraftBlocks.basal_slab, 6), "ZZZ", 'Z', new ItemStack(NovaCraftBlocks.basal));
		register("basal_brick_slab", new ItemStack(NovaCraftBlocks.basal_brick_slab, 6), "ZZZ", 'Z', new ItemStack(NovaCraftBlocks.basal_bricks));

		register("sculk_brick_slab", new ItemStack(NovaCraftBlocks.sculk_brick_slab, 6), "ZZZ", 'Z', new ItemStack(NovaCraftBlocks.sculk_bricks));
		register("sculk_tiled_slab", new ItemStack(NovaCraftBlocks.sculk_tiled_slab, 6), "ZZZ", 'Z', new ItemStack(NovaCraftBlocks.sculk_tiles));

		register("frontierslate_slab", new ItemStack(NovaCraftBlocks.frontierslate_slab, 6), "ZZZ", 'Z', new ItemStack(NovaCraftBlocks.frontierslate));
		register("frontierslate_brick_slab", new ItemStack(NovaCraftBlocks.frontierslate_brick_slab, 6), "ZZZ", 'Z', new ItemStack(NovaCraftBlocks.frontierslate_bricks));

		register("nullwart_brick_slab", new ItemStack(NovaCraftBlocks.nullwart_brick_slab, 6), "ZZZ", 'Z', new ItemStack(NovaCraftBlocks.nullwart_bricks));
		register("vanite_brick_slab", new ItemStack(NovaCraftBlocks.vanite_brick_slab, 6), "ZZZ", 'Z', new ItemStack(NovaCraftBlocks.vanite_bricks));
		register("carved_vanite_brick_slab", new ItemStack(NovaCraftBlocks.carved_vanite_brick_slab, 6), "ZZZ", 'Z', new ItemStack(NovaCraftBlocks.carved_vanite_bricks));

		register("lacuna_slab", new ItemStack(NovaCraftBlocks.lacuna_slab, 6), "ZZZ", 'Z', new ItemStack(NovaCraftBlocks.lacuna_planks));
		register("luminant_slab", new ItemStack(NovaCraftBlocks.luminant_slab, 6), "ZZZ", 'Z', new ItemStack(NovaCraftBlocks.luminant_planks));

		register("moss_carpet", new ItemStack(NovaCraftBlocks.moss_carpet, 6), "ZZZ", 'Z', new ItemStack(NovaCraftBlocks.moss_block));
		register("arctic_moss_carpet", new ItemStack(NovaCraftBlocks.arctic_moss_carpet, 6), "ZZZ", 'Z', new ItemStack(NovaCraftBlocks.arctic_moss_block));

		register("diamond_firecharge_launcher", new ItemStack(NovaCraftItems.diamond_firecharge_launcher), " Z ", "ZYZ", " ZX", 'Z', new ItemStack(NovaCraftItems.reinforced_vanite_ingot), 'Y', new ItemStack(Blocks.diamond_block), 'X', new ItemStack(Items.quartz));
		register("vanite_firecharge_launcher", new ItemStack(NovaCraftItems.vanite_firecharge_launcher), " ZY", "ZXW", "YWU", 'Z', new ItemStack(NovaCraftItems.reinforced_vanite_ingot), 'Y', new ItemStack(Items.blaze_powder), 'X', new ItemStack(NovaCraftBlocks.block_of_reinforced_vanite), 'W', new ItemStack(NovaCraftItems.enflamed_null_cube_slimeball), 'U', new ItemStack(NovaCraftItems.variegated_shard));
		register("klangite_firecharge_launcher", new ItemStack(NovaCraftItems.klangite_firecharge_launcher), " ZY", "ZXW", "YWV", 'Z', new ItemStack(NovaCraftItems.reinforced_vanite_ingot), 'Y', new ItemStack(NovaCraftItems.corrupted_essence), 'X', new ItemStack(NovaCraftItems.klangite_ingot), 'W', new ItemStack(NovaCraftItems.enhanced_enflamed_null_cube_slimeball), 'V', new ItemStack(NovaCraftItems.nullified_dust));

		register("advanced_enchantment_table", new ItemStack(NovaCraftBlocks.advanced_enchantment_table), "VUV", "WZW", "XYX", 'Z', new ItemStack(NovaCraftItems.copartz_shard), 'Y', new ItemStack(NovaCraftItems.sculk_dweller_heart), 'X', new ItemStack(Blocks.obsidian), 'W', new ItemStack(NovaCraftItems.tophinite_gemstone), 'V', new ItemStack(NovaCraftItems.ionizatior_powder), 'U', new ItemStack(Items.book));
		register("advanced_enchantment_table", new ItemStack(NovaCraftBlocks.advanced_enchantment_table), "VUV", "WZW", "XYX", 'Z', new ItemStack(NovaCraftItems.larimar_shard), 'Y', new ItemStack(NovaCraftItems.sculk_dweller_heart), 'X', new ItemStack(Blocks.obsidian), 'W', new ItemStack(NovaCraftItems.tophinite_gemstone), 'V', new ItemStack(NovaCraftItems.ionizatior_powder), 'U', new ItemStack(Items.book));
		register("advanced_enchantment_table", new ItemStack(NovaCraftBlocks.advanced_enchantment_table), "VUV", "WZW", "XYX", 'Z', new ItemStack(NovaCraftItems.tsavorokite_shard), 'Y', new ItemStack(NovaCraftItems.sculk_dweller_heart), 'X', new ItemStack(Blocks.obsidian), 'W', new ItemStack(NovaCraftItems.tophinite_gemstone), 'V', new ItemStack(NovaCraftItems.ionizatior_powder), 'U', new ItemStack(Items.book));
		register("advanced_enchantment_table", new ItemStack(NovaCraftBlocks.advanced_enchantment_table), "VUV", "WZW", "XYX", 'Z', new ItemStack(NovaCraftItems.aether_shard), 'Y', new ItemStack(NovaCraftItems.sculk_dweller_heart), 'X', new ItemStack(Blocks.obsidian), 'W', new ItemStack(NovaCraftItems.tophinite_gemstone), 'V', new ItemStack(NovaCraftItems.ionizatior_powder), 'U', new ItemStack(Items.book));
		register("legendary_enchantment_table", new ItemStack(NovaCraftBlocks.legendary_enchantment_table), "VUV", "WZW", "XYX", 'Z', new ItemStack(NovaCraftBlocks.nullified_vanite), 'Y', new ItemStack(NovaCraftItems.warden_heart), 'X', new ItemStack(NovaCraftBlocks.crystallized_end), 'W', new ItemStack(NovaCraftItems.tophinite_gemstone), 'V', new ItemStack(NovaCraftItems.nullified_dust), 'U', new ItemStack(Items.book));

		register("nullwart_brick_bookshelf", new ItemStack(NovaCraftBlocks.nullwart_brick_bookshelf), "XYX", "WUV", "XZX", 'Z', new ItemStack(NovaCraftItems.blazing_serpent_tooth), 'Y', new ItemStack(Items.blaze_rod), 'X', new ItemStack(NovaCraftBlocks.nullwart_bricks), 'W', new ItemStack(Items.potionitem, 1, 8225), 'V', new ItemStack(Items.potionitem, 1, 8233), 'U', new ItemStack(Blocks.bookshelf));
		register("sculk_brick_bookshelf", new ItemStack(NovaCraftBlocks.sculk_brick_bookshelf), "XYX", "WUV", "XZX", 'Z', new ItemStack(NovaCraftItems.sculked_shard), 'Y', new ItemStack(NovaCraftItems.ionizatior_rod), 'X', new ItemStack(NovaCraftBlocks.sculk_tiles), 'W', new ItemStack(NovaCraftItems.potion_regen_III), 'V', new ItemStack(NovaCraftItems.potion_strength_III), 'U', new ItemStack(Blocks.bookshelf));
		register("deepoid_furnace", new ItemStack(NovaCraftBlocks.deepoid_furnace), "XYX", "YZY", "XWX", 'Z', new ItemStack(NovaCraftBlocks.deepoid_power_core), 'Y', new ItemStack(NovaCraftItems.copartz_shard), 'X', new ItemStack(NovaCraftBlocks.deepoid_bricks), 'W', new ItemStack(NovaCraftItems.tophinite_gemstone));

		register("warden_sword", new ItemStack(NovaCraftItems.warden_sword), "ZYY", "XAY", "BXZ", 'A', new ItemStack(NovaCraftItems.iridium_sword), 'Z', new ItemStack(NovaCraftItems.corrupted_essence), 'Y', new ItemStack(NovaCraftItems.warden_shard), 'X', new ItemStack(NovaCraftItems.enhanced_enflamed_null_cube_slimeball), 'B', new ItemStack(NovaCraftBlocks.block_of_reinforced_vanite));
		register("warden_pickaxe", new ItemStack(NovaCraftItems.warden_pickaxe), "ZYY", "XAY", "BXZ", 'A', new ItemStack(NovaCraftItems.iridium_pickaxe), 'Z', new ItemStack(NovaCraftItems.corrupted_essence), 'Y', new ItemStack(NovaCraftItems.warden_shard), 'X', new ItemStack(NovaCraftItems.enhanced_enflamed_null_cube_slimeball), 'B', new ItemStack(NovaCraftBlocks.block_of_reinforced_vanite));
		register("warden_shovel", new ItemStack(NovaCraftItems.warden_shovel), "ZYY", "XAY", "BXZ", 'A', new ItemStack(NovaCraftItems.iridium_shovel), 'Z', new ItemStack(NovaCraftItems.corrupted_essence), 'Y', new ItemStack(NovaCraftItems.warden_shard), 'X', new ItemStack(NovaCraftItems.enhanced_enflamed_null_cube_slimeball), 'B', new ItemStack(NovaCraftBlocks.block_of_reinforced_vanite));
		register("warden_axe", new ItemStack(NovaCraftItems.warden_axe), "ZYY", "XAY", "BXZ", 'A', new ItemStack(NovaCraftItems.iridium_axe), 'Z', new ItemStack(NovaCraftItems.corrupted_essence), 'Y', new ItemStack(NovaCraftItems.warden_shard), 'X', new ItemStack(NovaCraftItems.enhanced_enflamed_null_cube_slimeball), 'B', new ItemStack(NovaCraftBlocks.block_of_reinforced_vanite));
		register("warden_hoe", new ItemStack(NovaCraftItems.warden_hoe), "ZYY", "XAY", "BXZ", 'A', new ItemStack(NovaCraftItems.iridium_hoe), 'Z', new ItemStack(NovaCraftItems.corrupted_essence), 'Y', new ItemStack(NovaCraftItems.warden_shard), 'X', new ItemStack(NovaCraftItems.enhanced_enflamed_null_cube_slimeball), 'B', new ItemStack(NovaCraftBlocks.block_of_reinforced_vanite));
		register("warden_bow", new ItemStack(NovaCraftItems.warden_bow), "ZYY", "XAY", "BXZ", 'A', new ItemStack(NovaCraftItems.klangite_bow), 'Z', new ItemStack(NovaCraftItems.corrupted_essence), 'Y', new ItemStack(NovaCraftItems.warden_shard), 'X', new ItemStack(NovaCraftItems.enhanced_enflamed_null_cube_slimeball), 'B', new ItemStack(NovaCraftBlocks.block_of_reinforced_vanite));

		register("warden_helmet", new ItemStack(NovaCraftItems.warden_helmet), "ZDZ", "ABC", "YEY", 'D', new ItemStack(NovaCraftItems.klangite_ingot), 'C', new ItemStack(NovaCraftItems.iridium_helmet), 'B', new ItemStack(NovaCraftItems.sculk_dweller_heart), 'A', new ItemStack(NovaCraftItems.sculk_helmet), 'Z', new ItemStack(NovaCraftBlocks.block_of_reinforced_vanite), 'Y', new ItemStack(NovaCraftItems.dark_essence), 'E', new ItemStack(NovaCraftItems.warden_shard));
		register("warden_chestplate", new ItemStack(NovaCraftItems.warden_chestplate), "ZDZ", "ABC", "YEY", 'D', new ItemStack(NovaCraftItems.klangite_ingot), 'C', new ItemStack(NovaCraftItems.iridium_chestplate), 'B', new ItemStack(NovaCraftItems.sculk_dweller_heart), 'A', new ItemStack(NovaCraftItems.sculk_chestplate), 'Z', new ItemStack(NovaCraftBlocks.block_of_reinforced_vanite), 'Y', new ItemStack(NovaCraftItems.dark_essence), 'E', new ItemStack(NovaCraftItems.warden_shard));
		register("warden_leggings", new ItemStack(NovaCraftItems.warden_leggings), "ZDZ", "ABC", "YEY", 'D', new ItemStack(NovaCraftItems.klangite_ingot), 'C', new ItemStack(NovaCraftItems.iridium_leggings), 'B', new ItemStack(NovaCraftItems.sculk_dweller_heart), 'A', new ItemStack(NovaCraftItems.sculk_leggings), 'Z', new ItemStack(NovaCraftBlocks.block_of_reinforced_vanite), 'Y', new ItemStack(NovaCraftItems.dark_essence), 'E', new ItemStack(NovaCraftItems.warden_shard));
		register("warden_boots", new ItemStack(NovaCraftItems.warden_boots), "ZDZ", "ABC", "YEY", 'D', new ItemStack(NovaCraftItems.klangite_ingot), 'C', new ItemStack(NovaCraftItems.iridium_boots), 'B', new ItemStack(NovaCraftItems.sculk_dweller_heart), 'A', new ItemStack(NovaCraftItems.sculk_boots), 'Z', new ItemStack(NovaCraftBlocks.block_of_reinforced_vanite), 'Y', new ItemStack(NovaCraftItems.dark_essence), 'E', new ItemStack(NovaCraftItems.warden_shard));

		register("sculk_helmet", new ItemStack(NovaCraftItems.sculk_helmet), "ZXZ", "XYX", 'Z', new ItemStack(NovaCraftBlocks.inked_sculk_block), 'Y', new ItemStack(NovaCraftItems.sculk_dweller_heart), 'X', new ItemStack(NovaCraftItems.sculked_leather));
		register("sculk_chestplate", new ItemStack(NovaCraftItems.sculk_chestplate), "ZYZ", "XZX", "XXX", 'Z', new ItemStack(NovaCraftBlocks.inked_sculk_block), 'Y', new ItemStack(NovaCraftItems.sculk_dweller_heart), 'X', new ItemStack(NovaCraftItems.sculked_leather));
		register("sculk_leggings", new ItemStack(NovaCraftItems.sculk_leggings), "ZXZ", "XYX", "X X", 'Z', new ItemStack(NovaCraftBlocks.inked_sculk_block), 'Y', new ItemStack(NovaCraftItems.sculk_dweller_heart), 'X', new ItemStack(NovaCraftItems.sculked_leather));
		register("sculk_boots", new ItemStack(NovaCraftItems.sculk_boots), " Y ", "Z Z", "X X", 'Z', new ItemStack(NovaCraftBlocks.inked_sculk_block), 'Y', new ItemStack(NovaCraftItems.sculk_dweller_heart), 'X', new ItemStack(NovaCraftItems.sculked_leather));


		register("vanite_blue_crown", new ItemStack(NovaCraftItems.vanite_blue_crown), "XZX", "ZYZ", "Z Z", 'Z', new ItemStack(NovaCraftItems.vanite_ingot), 'Y', new ItemStack(NovaCraftItems.larimar_shard), 'X', new ItemStack(NovaCraftItems.tophinite_gemstone));
		register("vanite_red_crown", new ItemStack(NovaCraftItems.vanite_red_crown), "XZX", "ZYZ", "Z Z", 'Z', new ItemStack(NovaCraftItems.vanite_ingot), 'Y', new ItemStack(NovaCraftItems.copartz_shard), 'X', new ItemStack(NovaCraftItems.tophinite_gemstone));
		register("vanite_green_crown", new ItemStack(NovaCraftItems.vanite_green_crown), "XZX", "ZYZ", "Z Z", 'Z', new ItemStack(NovaCraftItems.vanite_ingot), 'Y', new ItemStack(NovaCraftItems.tsavorokite_shard), 'X', new ItemStack(NovaCraftItems.tophinite_gemstone));
		register("vanite_orange_crown", new ItemStack(NovaCraftItems.vanite_orange_crown), "XZX", "ZYZ", "Z Z", 'Z', new ItemStack(NovaCraftItems.vanite_ingot), 'Y', new ItemStack(NovaCraftItems.yttrlinsite_shard), 'X', new ItemStack(NovaCraftItems.tophinite_gemstone));
		register("vanite_dark_blue_crown", new ItemStack(NovaCraftItems.vanite_dark_blue_crown), "XZX", "ZYZ", "Z Z", 'Z', new ItemStack(NovaCraftItems.vanite_ingot), 'Y', new ItemStack(NovaCraftItems.echo_shard), 'X', new ItemStack(NovaCraftItems.tophinite_gemstone));
		register("vanite_notched_crown", new ItemStack(NovaCraftItems.vanite_notched_crown), "XZX", "ZYZ", "Z Z", 'Z', new ItemStack(NovaCraftItems.vanite_ingot), 'Y', new ItemStack(NovaCraftItems.aether_shard), 'X', new ItemStack(NovaCraftItems.tophinite_gemstone));
		register("vanite_exotic_crown", new ItemStack(NovaCraftItems.vanite_exotic_crown), "XZX", "ZYZ", "Z Z", 'Z', new ItemStack(NovaCraftItems.vanite_ingot), 'Y', new ItemStack(NovaCraftItems.null_shard), 'X', new ItemStack(NovaCraftItems.tophinite_gemstone));
		register("vanite_mysterious_crown", new ItemStack(NovaCraftItems.vanite_mysterious_crown), "XZX", "ZYZ", "Z Z", 'Z', new ItemStack(NovaCraftItems.vanite_ingot), 'Y', new ItemStack(NovaCraftItems.warden_shard), 'X', new ItemStack(NovaCraftItems.tophinite_gemstone));


		register("vanite_cauldron_item", new ItemStack(NovaCraftItems.vanite_cauldron_item), "X X", "XYX", "XXX", 'X', new ItemStack(NovaCraftItems.vanite_ingot), 'Y', new ItemStack(NovaCraftBlocks.block_of_reinforced_vanite));

		register("diamond_bow", new ItemStack(NovaCraftItems.diamond_bow), " YX", "YZW", " YX", 'Y', new ItemStack(Items.diamond), 'X', new ItemStack(Items.string), 'Z', new ItemStack(Items.bow), 'W', new ItemStack(Items.iron_ingot));
		register("crystallized_vanite_bow", new ItemStack(NovaCraftItems.crystallized_vanite_bow), " WX", "YZW", " WX", 'Y', new ItemStack(NovaCraftItems.crystallized_vanite_alloy), 'X', new ItemStack(NovaCraftItems.superheated_magma_cream), 'Z', new ItemStack(NovaCraftItems.tophinite_bow), 'W', new ItemStack(NovaCraftItems.ionizatior_powder));

		if (Loader.isModLoaded("etfuturum")) {
			try {
				Item netherite_ingot = GameRegistry.findItem("etfuturum", "netherite_ingot");
				if (netherite_ingot != null && Configs.enableNetheriteInRecipes) {
					register("netherite_bow", new ItemStack(NovaCraftItems.netherite_bow), " WX", "YZW", " WX", 'Y', new ItemStack(OtherModItems.netherite_ingot), 'X', new ItemStack(Items.string), 'Z', new ItemStack(NovaCraftItems.diamond_bow), 'W', new ItemStack(Items.gold_ingot));
					register("crystallized_vanite_bow", new ItemStack(NovaCraftItems.crystallized_vanite_bow), " WX", "YZW", " WX", 'Y', new ItemStack(NovaCraftItems.crystallized_vanite_alloy), 'X', new ItemStack(NovaCraftItems.superheated_magma_cream), 'Z', new ItemStack(NovaCraftItems.netherite_bow), 'W', new ItemStack(NovaCraftItems.ionizatior_powder));
					register("tophinite_bow", new ItemStack(NovaCraftItems.tophinite_bow), " WX", "YZW", " WX", 'Y', new ItemStack(NovaCraftItems.tophinite_gemstone), 'X', new ItemStack(Items.magma_cream), 'Z', new ItemStack(NovaCraftItems.netherite_bow), 'W', new ItemStack(NovaCraftItems.reinforced_vanite_ingot));
					register("klangite_bow", new ItemStack(NovaCraftItems.klangite_bow), " WX", "YZW", " WX", 'Y', new ItemStack(NovaCraftItems.klangite_ingot), 'X', new ItemStack(NovaCraftItems.enflamed_null_cube_slimeball), 'Z', new ItemStack(NovaCraftItems.netherite_bow), 'W', new ItemStack(NovaCraftItems.reinforced_vanite_ingot));
				} else {
					register("tophinite_bow", new ItemStack(NovaCraftItems.tophinite_bow), " WX", "YZW", " WX", 'Y', new ItemStack(NovaCraftItems.tophinite_gemstone), 'X', new ItemStack(Items.magma_cream), 'Z', new ItemStack(NovaCraftItems.diamond_bow), 'W', new ItemStack(NovaCraftItems.reinforced_vanite_ingot));
					register("klangite_bow", new ItemStack(NovaCraftItems.klangite_bow), " WX", "YZW", " WX", 'Y', new ItemStack(NovaCraftItems.klangite_ingot), 'X', new ItemStack(NovaCraftItems.enflamed_null_cube_slimeball), 'Z', new ItemStack(NovaCraftItems.diamond_bow), 'W', new ItemStack(NovaCraftItems.reinforced_vanite_ingot));
					register("crystallized_vanite_bow", new ItemStack(NovaCraftItems.crystallized_vanite_bow), " WX", "YZW", " WX", 'Y', new ItemStack(NovaCraftItems.crystallized_vanite_alloy), 'X', new ItemStack(NovaCraftItems.superheated_magma_cream), 'Z', new ItemStack(NovaCraftItems.diamond_bow), 'W', new ItemStack(NovaCraftItems.ionizatior_powder));
				}
			} catch (Exception ex) {
				if (Configs.enableDebugMode) {
					System.out.println("Item not found, skipping...");
				}
				register("tophinite_bow", new ItemStack(NovaCraftItems.tophinite_bow), " WX", "YZW", " WX", 'Y', new ItemStack(NovaCraftItems.tophinite_gemstone), 'X', new ItemStack(Items.magma_cream), 'Z', new ItemStack(NovaCraftItems.diamond_bow), 'W', new ItemStack(NovaCraftItems.reinforced_vanite_ingot));
				register("klangite_bow", new ItemStack(NovaCraftItems.klangite_bow), " WX", "YZW", " WX", 'Y', new ItemStack(NovaCraftItems.klangite_ingot), 'X', new ItemStack(NovaCraftItems.enflamed_null_cube_slimeball), 'Z', new ItemStack(NovaCraftItems.diamond_bow), 'W', new ItemStack(NovaCraftItems.reinforced_vanite_ingot));
				register("crystallized_vanite_bow", new ItemStack(NovaCraftItems.crystallized_vanite_bow), " WX", "YZW", " WX", 'Y', new ItemStack(NovaCraftItems.crystallized_vanite_alloy), 'X', new ItemStack(NovaCraftItems.superheated_magma_cream), 'Z', new ItemStack(NovaCraftItems.diamond_bow), 'W', new ItemStack(NovaCraftItems.ionizatior_powder));
			}
		} else {
			register("tophinite_bow", new ItemStack(NovaCraftItems.tophinite_bow), " WX", "YZW", " WX", 'Y', new ItemStack(NovaCraftItems.tophinite_gemstone), 'X', new ItemStack(Items.magma_cream), 'Z', new ItemStack(NovaCraftItems.diamond_bow), 'W', new ItemStack(NovaCraftItems.reinforced_vanite_ingot));
			register("klangite_bow", new ItemStack(NovaCraftItems.klangite_bow), " WX", "YZW", " WX", 'Y', new ItemStack(NovaCraftItems.klangite_ingot), 'X', new ItemStack(NovaCraftItems.enflamed_null_cube_slimeball), 'Z', new ItemStack(NovaCraftItems.diamond_bow), 'W', new ItemStack(NovaCraftItems.reinforced_vanite_ingot));
			register("crystallized_vanite_bow", new ItemStack(NovaCraftItems.crystallized_vanite_bow), " WX", "YZW", " WX", 'Y', new ItemStack(NovaCraftItems.crystallized_vanite_alloy), 'X', new ItemStack(NovaCraftItems.superheated_magma_cream), 'Z', new ItemStack(NovaCraftItems.diamond_bow), 'W', new ItemStack(NovaCraftItems.ionizatior_powder));
		}

		register("enhanced_enflamed_null_cube_slimeball", new ItemStack(NovaCraftItems.enhanced_enflamed_null_cube_slimeball, 2), "ZYZ", "XWX", "ZYZ", 'Z', new ItemStack(NovaCraftItems.flaming_pitcher_petal), 'Y', new ItemStack(Items.blaze_powder), 'X', new ItemStack(NovaCraftItems.enflamed_null_cube_slimeball), 'W', new ItemStack(NovaCraftItems.variegated_shard));

		register("crystalite_sword", new ItemStack(NovaCraftItems.crystalite_sword), "AZY", "XWZ", "VUA", 'Z', new ItemStack(NovaCraftBlocks.variegated_block), 'Y', new ItemStack(NovaCraftBlocks.block_of_reinforced_vanite), 'X', new ItemStack(NovaCraftItems.sculk_star), 'W', new ItemStack(NovaCraftItems.warden_sword), 'V', new ItemStack(NovaCraftItems.heart_of_the_end), 'U', new ItemStack(NovaCraftItems.warden_heart), 'A', new ItemStack(NovaCraftItems.enflamed_null_cube_slimeball));
		register("crystalite_helmet", new ItemStack(NovaCraftItems.crystalite_helmet), "AZY", "XWZ", "VUA", 'Z', new ItemStack(NovaCraftBlocks.variegated_block), 'Y', new ItemStack(NovaCraftBlocks.block_of_reinforced_vanite), 'X', new ItemStack(NovaCraftItems.sculk_star), 'W', new ItemStack(NovaCraftItems.warden_helmet), 'V', new ItemStack(NovaCraftItems.heart_of_the_end), 'U', new ItemStack(NovaCraftItems.warden_heart), 'A', new ItemStack(NovaCraftItems.enflamed_null_cube_slimeball));
		register("crystalite_chestplate", new ItemStack(NovaCraftItems.crystalite_chestplate), "AZY", "XWZ", "VUA", 'Z', new ItemStack(NovaCraftBlocks.variegated_block), 'Y', new ItemStack(NovaCraftBlocks.block_of_reinforced_vanite), 'X', new ItemStack(NovaCraftItems.sculk_star), 'W', new ItemStack(NovaCraftItems.warden_chestplate), 'V', new ItemStack(NovaCraftItems.heart_of_the_end), 'U', new ItemStack(NovaCraftItems.warden_heart), 'A', new ItemStack(NovaCraftItems.enflamed_null_cube_slimeball));
		register("crystalite_leggings", new ItemStack(NovaCraftItems.crystalite_leggings), "AZY", "XWZ", "VUA", 'Z', new ItemStack(NovaCraftBlocks.variegated_block), 'Y', new ItemStack(NovaCraftBlocks.block_of_reinforced_vanite), 'X', new ItemStack(NovaCraftItems.sculk_star), 'W', new ItemStack(NovaCraftItems.warden_leggings), 'V', new ItemStack(NovaCraftItems.heart_of_the_end), 'U', new ItemStack(NovaCraftItems.warden_heart), 'A', new ItemStack(NovaCraftItems.enflamed_null_cube_slimeball));
		register("crystalite_boots", new ItemStack(NovaCraftItems.crystalite_boots), "AZY", "XWZ", "VUA", 'Z', new ItemStack(NovaCraftBlocks.variegated_block), 'Y', new ItemStack(NovaCraftBlocks.block_of_reinforced_vanite), 'X', new ItemStack(NovaCraftItems.sculk_star), 'W', new ItemStack(NovaCraftItems.warden_boots), 'V', new ItemStack(NovaCraftItems.heart_of_the_end), 'U', new ItemStack(NovaCraftItems.warden_heart), 'A', new ItemStack(NovaCraftItems.enflamed_null_cube_slimeball));
		register("crystalite_pickaxe", new ItemStack(NovaCraftItems.crystalite_pickaxe), "ZYZ", "XWV", "UTS", 'Z', new ItemStack(NovaCraftBlocks.variegated_block), 'Y', new ItemStack(NovaCraftBlocks.block_of_reinforced_vanite), 'X', new ItemStack(NovaCraftItems.warden_axe), 'W', new ItemStack(NovaCraftItems.sculk_star), 'V', new ItemStack(NovaCraftItems.warden_shovel), 'U', new ItemStack(NovaCraftItems.warden_heart), 'T', new ItemStack(NovaCraftItems.warden_pickaxe), 'S', new ItemStack(NovaCraftItems.heart_of_the_end));
		register("crystalite_bow", new ItemStack(NovaCraftItems.crystalite_bow), "AZY", "XWZ", "VUA", 'Z', new ItemStack(NovaCraftBlocks.variegated_block), 'Y', new ItemStack(NovaCraftBlocks.block_of_reinforced_vanite), 'X', new ItemStack(NovaCraftItems.sculk_star), 'W', new ItemStack(NovaCraftItems.warden_bow), 'V', new ItemStack(NovaCraftItems.heart_of_the_end), 'U', new ItemStack(NovaCraftItems.warden_heart), 'A', new ItemStack(NovaCraftItems.enflamed_null_cube_slimeball));


		register("sculk_horn", new ItemStack(NovaCraftItems.sculk_horn), "XWV", "ZYZ", "ABA", 'Z', new ItemStack(NovaCraftItems.warden_tentacle), 'Y', new ItemStack(NovaCraftItems.goat_horn_admire), 'X', new ItemStack(NovaCraftItems.variegated_shard), 'W', new ItemStack(NovaCraftItems.klangite_ingot), 'V', new ItemStack(NovaCraftItems.heart_of_the_end), 'A', new ItemStack(NovaCraftItems.dark_essence), 'B', new ItemStack(NovaCraftItems.warden_shard));
		register("sculk_horn", new ItemStack(NovaCraftItems.sculk_horn), "XWV", "ZYZ", "ABA", 'Z', new ItemStack(NovaCraftItems.warden_tentacle), 'Y', new ItemStack(NovaCraftItems.goat_horn_call), 'X', new ItemStack(NovaCraftItems.variegated_shard), 'W', new ItemStack(NovaCraftItems.klangite_ingot), 'V', new ItemStack(NovaCraftItems.heart_of_the_end), 'A', new ItemStack(NovaCraftItems.dark_essence), 'B', new ItemStack(NovaCraftItems.warden_shard));
		register("sculk_horn", new ItemStack(NovaCraftItems.sculk_horn), "XWV", "ZYZ", "ABA", 'Z', new ItemStack(NovaCraftItems.warden_tentacle), 'Y', new ItemStack(NovaCraftItems.goat_horn_dream), 'X', new ItemStack(NovaCraftItems.variegated_shard), 'W', new ItemStack(NovaCraftItems.klangite_ingot), 'V', new ItemStack(NovaCraftItems.heart_of_the_end), 'A', new ItemStack(NovaCraftItems.dark_essence), 'B', new ItemStack(NovaCraftItems.warden_shard));
		register("sculk_horn", new ItemStack(NovaCraftItems.sculk_horn), "XWV", "ZYZ", "ABA", 'Z', new ItemStack(NovaCraftItems.warden_tentacle), 'Y', new ItemStack(NovaCraftItems.goat_horn_feel), 'X', new ItemStack(NovaCraftItems.variegated_shard), 'W', new ItemStack(NovaCraftItems.klangite_ingot), 'V', new ItemStack(NovaCraftItems.heart_of_the_end), 'A', new ItemStack(NovaCraftItems.dark_essence), 'B', new ItemStack(NovaCraftItems.warden_shard));
		register("sculk_horn", new ItemStack(NovaCraftItems.sculk_horn), "XWV", "ZYZ", "ABA", 'Z', new ItemStack(NovaCraftItems.warden_tentacle), 'Y', new ItemStack(NovaCraftItems.goat_horn_ponder), 'X', new ItemStack(NovaCraftItems.variegated_shard), 'W', new ItemStack(NovaCraftItems.klangite_ingot), 'V', new ItemStack(NovaCraftItems.heart_of_the_end), 'A', new ItemStack(NovaCraftItems.dark_essence), 'B', new ItemStack(NovaCraftItems.warden_shard));
		register("sculk_horn", new ItemStack(NovaCraftItems.sculk_horn), "XWV", "ZYZ", "ABA", 'Z', new ItemStack(NovaCraftItems.warden_tentacle), 'Y', new ItemStack(NovaCraftItems.goat_horn_seek), 'X', new ItemStack(NovaCraftItems.variegated_shard), 'W', new ItemStack(NovaCraftItems.klangite_ingot), 'V', new ItemStack(NovaCraftItems.heart_of_the_end), 'A', new ItemStack(NovaCraftItems.dark_essence), 'B', new ItemStack(NovaCraftItems.warden_shard));
		register("sculk_horn", new ItemStack(NovaCraftItems.sculk_horn), "XWV", "ZYZ", "ABA", 'Z', new ItemStack(NovaCraftItems.warden_tentacle), 'Y', new ItemStack(NovaCraftItems.goat_horn_sing), 'X', new ItemStack(NovaCraftItems.variegated_shard), 'W', new ItemStack(NovaCraftItems.klangite_ingot), 'V', new ItemStack(NovaCraftItems.heart_of_the_end), 'A', new ItemStack(NovaCraftItems.dark_essence), 'B', new ItemStack(NovaCraftItems.warden_shard));
		register("sculk_horn", new ItemStack(NovaCraftItems.sculk_horn), "XWV", "ZYZ", "ABA", 'Z', new ItemStack(NovaCraftItems.warden_tentacle), 'Y', new ItemStack(NovaCraftItems.goat_horn_yearn), 'X', new ItemStack(NovaCraftItems.variegated_shard), 'W', new ItemStack(NovaCraftItems.klangite_ingot), 'V', new ItemStack(NovaCraftItems.heart_of_the_end), 'A', new ItemStack(NovaCraftItems.dark_essence), 'B', new ItemStack(NovaCraftItems.warden_shard));

		register("ender_lord_staff", new ItemStack(NovaCraftItems.ender_lord_staff), " ZY", "XWZ", "VX ", 'Z', new ItemStack(NovaCraftItems.corrupted_essence), 'Y', new ItemStack(NovaCraftItems.heart_of_the_end), 'X', new ItemStack(NovaCraftItems.reinforced_vanite_ingot), 'W', new ItemStack(NovaCraftItems.ancient_city_artifact), 'V', new ItemStack(NovaCraftItems.klangite_ingot));
		register("crystal_growth_staff", new ItemStack(NovaCraftItems.crystal_growth_staff), "ZYX", "WTY", "VWU", 'Z', new ItemStack(NovaCraftItems.variegated_shard), 'Y', new ItemStack(NovaCraftItems.null_shard), 'X', new ItemStack(NovaCraftItems.heart_of_the_end), 'W', new ItemStack(NovaCraftItems.dark_essence), 'V', new ItemStack(NovaCraftItems.reinforced_vanite_ingot), 'U', new ItemStack(NovaCraftItems.sculked_shard), 'T', new ItemStack(NovaCraftItems.ancient_city_artifact));

		register("static_blend", new ItemStack(NovaCraftItems.static_blend, 5), "XZX", "VXY", "XUX", 'X', new ItemStack(NovaCraftItems.deepfire_blend), 'Y', new ItemStack(NovaCraftItems.wardling_dust), 'Z', new ItemStack(NovaCraftItems.static_essence), 'U', new ItemStack(NovaCraftItems.crystallized_end_shard), 'V', new ItemStack(NovaCraftItems.warden_dust));

		register("impure_outsider_ingot", new ItemStack(NovaCraftItems.impure_outsider_ingot, 1), "XYX", "YZY", "WUW", 'X', new ItemStack(NovaCraftItems.enhanced_enflamed_null_cube_slimeball), 'Y', new ItemStack(NovaCraftItems.outsider_essence), 'Z', new ItemStack(NovaCraftItems.klangite_ingot), 'U', new ItemStack(NovaCraftItems.warden_dust), 'W', new ItemStack(NovaCraftItems.nulk_dust));

	}

	private static void initializeShapelessRecipes() {

		registerShapeless("bright_lichen", new ItemStack(NovaCraftBlocks.bright_lichen), new ItemStack(NovaCraftBlocks.glow_lichen), new ItemStack(NovaCraftItems.glow_ink_sac));
		registerShapeless("inked_sculk_block", new ItemStack(NovaCraftBlocks.inked_sculk_block), new ItemStack(NovaCraftBlocks.sculk_block), new ItemStack(NovaCraftItems.glow_ink_sac));
		registerShapeless("sculk_bricks", new ItemStack(NovaCraftBlocks.sculk_bricks, 2), new ItemStack(NovaCraftBlocks.grimstone_bricks), new ItemStack(NovaCraftBlocks.sculk_block));
		registerShapeless("inked_vacuum_sand", new ItemStack(NovaCraftBlocks.inked_vacuum_sand), new ItemStack(NovaCraftBlocks.vacuum_sand), new ItemStack(NovaCraftItems.glow_ink_sac));
		registerShapeless("inked_vacuum_glass", new ItemStack(NovaCraftBlocks.inked_vacuum_glass), new ItemStack(NovaCraftBlocks.vacuum_glass), new ItemStack(NovaCraftItems.glow_ink_sac));

		registerShapeless("lacuna_planks", new ItemStack(NovaCraftBlocks.lacuna_planks, 2), new ItemStack(NovaCraftBlocks.lacuna_log));
		registerShapeless("luminant_planks", new ItemStack(NovaCraftBlocks.luminant_planks, 4), new ItemStack(NovaCraftBlocks.luminant_log));

		registerShapeless("dye", new ItemStack(Items.dye, 2, 8), new ItemStack(NovaCraftBlocks.shadow_bloom));
		registerShapeless("dye", new ItemStack(Items.dye, 1, 6), new ItemStack(NovaCraftBlocks.cyan_rose));
		registerShapeless("dye", new ItemStack(Items.dye, 1, 11), new ItemStack(NovaCraftBlocks.desert_bloom));
		registerShapeless("dye", new ItemStack(Items.dye, 2, 14), new ItemStack(NovaCraftBlocks.torchflower));
		registerShapeless("lapis", new ItemStack(Items.dye, 2, 4), new ItemStack(NovaCraftBlocks.sculk_bloom));
		registerShapeless("dye", new ItemStack(Items.dye, 1, 12), new ItemStack(NovaCraftBlocks.cosmos));
		registerShapeless("dye", new ItemStack(Items.dye, 1, 5), new ItemStack(NovaCraftBlocks.violet));
		registerShapeless("dye", new ItemStack(Items.dye, 1, 5), new ItemStack(NovaCraftBlocks.purple_rose));
		registerShapeless("dye", new ItemStack(Items.dye, 1, 1), new ItemStack(NovaCraftBlocks.blooming_barb));

		registerShapeless("dye", new ItemStack(Items.dye, 1, 1), new ItemStack(NovaCraftBlocks.lentius_mushroom));
		registerShapeless("dye", new ItemStack(Items.dye, 1, 12), new ItemStack(NovaCraftBlocks.rozite_mushroom));
		registerShapeless("dye", new ItemStack(Items.dye, 2, 12), new ItemStack(NovaCraftBlocks.sculk_tulip));
		registerShapeless("dye", new ItemStack(Items.dye, 2, 12), new ItemStack(NovaCraftBlocks.sculk_bush));
		registerShapeless("dye", new ItemStack(Items.dye, 1, 5), new ItemStack(NovaCraftBlocks.hydnum_mushroom));
		registerShapeless("dye", new ItemStack(Items.dye, 1, 13), new ItemStack(NovaCraftBlocks.calvatia_mushroom));
		registerShapeless("dye", new ItemStack(Items.redstone, 2, 0), new ItemStack(NovaCraftBlocks.pleurotus_mushroom));

		registerShapeless("echo_eye", new ItemStack(NovaCraftItems.echo_eye), new ItemStack(Items.ender_eye), new ItemStack(NovaCraftItems.fractured_heart_of_the_end), new ItemStack(NovaCraftItems.echo_shard));

		registerShapeless("gunpowder", new ItemStack(Items.gunpowder), new ItemStack(NovaCraftItems.brimstone_dust), new ItemStack(NovaCraftItems.brimstone_dust), new ItemStack(Items.coal));
		registerShapeless("gunpowder", new ItemStack(Items.gunpowder), new ItemStack(NovaCraftItems.brimstone_dust), new ItemStack(NovaCraftItems.brimstone_dust), new ItemStack(Items.coal, 1, 1));

		registerShapeless("variegated_shard", new ItemStack(NovaCraftItems.variegated_shard, 2), new ItemStack(NovaCraftItems.aether_shard), new ItemStack(NovaCraftItems.copartz_shard), new ItemStack(NovaCraftItems.larimar_shard), new ItemStack(NovaCraftItems.tsavorokite_shard), new ItemStack(NovaCraftItems.yttrlinsite_shard), new ItemStack(NovaCraftItems.copartz_shard), new ItemStack(NovaCraftItems.larimar_shard), new ItemStack(NovaCraftItems.tsavorokite_shard), new ItemStack(NovaCraftItems.yttrlinsite_shard));
		registerShapeless("xancium_firecharge", new ItemStack(NovaCraftItems.xancium_firecharge, 3), new ItemStack(NovaCraftItems.xancium_dust), new ItemStack(Items.fire_charge), new ItemStack(NovaCraftItems.echo_shard), new ItemStack(NovaCraftItems.flaming_pitcher_petal));

		registerShapeless("heart_of_the_end", new ItemStack(NovaCraftItems.heart_of_the_end, 1), new ItemStack(NovaCraftItems.fractured_heart_of_the_end), new ItemStack(NovaCraftItems.fractured_heart_of_the_end), new ItemStack(NovaCraftItems.fractured_heart_of_the_end), new ItemStack(NovaCraftItems.fractured_heart_of_the_end));

		registerShapeless("infused_copartz_shard", new ItemStack(NovaCraftItems.infused_copartz_shard), new ItemStack(NovaCraftItems.copartz_shard), new ItemStack(NovaCraftItems.dark_essence), new ItemStack(NovaCraftItems.anomalous_essence));
		registerShapeless("infused_larimar_shard", new ItemStack(NovaCraftItems.infused_larimar_shard), new ItemStack(NovaCraftItems.larimar_shard), new ItemStack(NovaCraftItems.dark_essence), new ItemStack(NovaCraftItems.anomalous_essence));
		registerShapeless("infused_tsavorokite_shard", new ItemStack(NovaCraftItems.infused_tsavorokite_shard), new ItemStack(NovaCraftItems.tsavorokite_shard), new ItemStack(NovaCraftItems.dark_essence), new ItemStack(NovaCraftItems.anomalous_essence));
		registerShapeless("infused_aether_shard", new ItemStack(NovaCraftItems.infused_aether_shard), new ItemStack(NovaCraftItems.aether_shard), new ItemStack(NovaCraftItems.dark_essence), new ItemStack(NovaCraftItems.anomalous_essence));
		registerShapeless("infused_yttrlinsite_shard", new ItemStack(NovaCraftItems.infused_yttrlinsite_shard), new ItemStack(NovaCraftItems.yttrlinsite_shard), new ItemStack(NovaCraftItems.dark_essence), new ItemStack(NovaCraftItems.anomalous_essence));

		registerShapeless("corrupted_essence", new ItemStack(NovaCraftItems.corrupted_essence), new ItemStack(NovaCraftItems.dark_essence), new ItemStack(NovaCraftItems.raw_klangite), new ItemStack(NovaCraftItems.anomalous_essence), new ItemStack(Items.diamond), new ItemStack(NovaCraftItems.variegated_shard), new ItemStack(NovaCraftItems.sculked_shard), new ItemStack(NovaCraftItems.null_shard), new ItemStack(NovaCraftItems.reinforced_vanite_ingot), new ItemStack(NovaCraftItems.xancium_ingot));

		registerShapeless("petn_powder", new ItemStack(NovaCraftItems.petn_powder, 2), new ItemStack(Items.gunpowder), new ItemStack(Items.gunpowder), new ItemStack(Items.redstone), new ItemStack(Items.redstone), new ItemStack(Items.glowstone_dust), new ItemStack(Items.glowstone_dust), new ItemStack(NovaCraftItems.nullwart));

		registerShapeless("klangite_blend", new ItemStack(NovaCraftItems.klangite_blend), new ItemStack(NovaCraftItems.raw_klangite), new ItemStack(NovaCraftItems.raw_klangite), new ItemStack(NovaCraftItems.raw_klangite), new ItemStack(NovaCraftItems.raw_klangite), new ItemStack(NovaCraftItems.variegated_shard), new ItemStack(NovaCraftItems.null_shard), new ItemStack(NovaCraftItems.sculked_shard), new ItemStack(NovaCraftItems.dark_essence), new ItemStack(Items.diamond));

		registerShapeless("reinforced_vanite_ingot", new ItemStack(NovaCraftItems.reinforced_vanite_ingot, 2), new ItemStack(NovaCraftItems.vanite_ingot), new ItemStack(NovaCraftItems.vanite_ingot), new ItemStack(NovaCraftItems.vanite_ingot), new ItemStack(NovaCraftItems.vanite_ingot), new ItemStack(NovaCraftItems.vanite_ingot), new ItemStack(Items.diamond), new ItemStack(NovaCraftItems.luminant_ingot), new ItemStack(NovaCraftItems.luminant_ingot), new ItemStack(NovaCraftItems.luminant_ingot));

		registerShapeless("anomalous_essence", new ItemStack(NovaCraftItems.anomalous_essence), new ItemStack(NovaCraftItems.static_essence), new ItemStack(Items.dye, 1, 1), new ItemStack(Items.dye, 1, 2), new ItemStack(Items.dye, 1, 3), new ItemStack(Items.dye, 1, 0), new ItemStack(Items.dye, 1, 4), new ItemStack(Items.dye, 1, 5), new ItemStack(Items.dye, 1, 11), new ItemStack(Items.dye, 1, 15));

		registerShapeless("glowing_basal", new ItemStack(NovaCraftBlocks.glowing_basal), new ItemStack(NovaCraftBlocks.basal), new ItemStack(NovaCraftItems.yttrlinsite_shard), new ItemStack(Items.blaze_powder));

		registerShapeless("reinforced_iridium_ingot", new ItemStack(NovaCraftItems.reinforced_iridium_ingot), new ItemStack(NovaCraftItems.iridium_ingot), new ItemStack(NovaCraftItems.reinforced_vanite_ingot), new ItemStack(NovaCraftItems.sculked_shard));

		registerShapeless("blazing_coal", new ItemStack(NovaCraftItems.blazing_coal), new ItemStack(NovaCraftItems.flaming_pitcher_petal), new ItemStack(Items.coal), new ItemStack(Items.blaze_powder));
		registerShapeless("nullwart_blend", new ItemStack(NovaCraftItems.nullwart_blend, 3), new ItemStack(NovaCraftItems.vanite_crystal), new ItemStack(NovaCraftItems.ionizatior_powder), new ItemStack(NovaCraftItems.nullwart));
		registerShapeless("superheated_magma_cream", new ItemStack(NovaCraftItems.superheated_magma_cream, 2), new ItemStack(Items.magma_cream), new ItemStack(NovaCraftItems.ionizatior_powder), new ItemStack(NovaCraftItems.phoenix_feather));

		registerShapeless("glowing_carved_vanite_bricks", new ItemStack(NovaCraftBlocks.glowing_carved_vanite_bricks), new ItemStack(NovaCraftBlocks.carved_vanite_bricks), new ItemStack(NovaCraftItems.ionizatior_powder), new ItemStack(Items.glowstone_dust));

		registerShapeless("ionizatior_powder", new ItemStack(NovaCraftItems.ionizatior_powder, 2), new ItemStack(NovaCraftItems.ionizatior_rod));
		registerShapeless("deepfire_blend", new ItemStack(NovaCraftItems.deepfire_blend), new ItemStack(NovaCraftItems.vanite_bottle), new ItemStack(NovaCraftItems.deepoid_horn), new ItemStack(NovaCraftItems.yttrlinsite_shard));
		registerShapeless("blazinite_powder", new ItemStack(NovaCraftItems.blazinite_powder), new ItemStack(NovaCraftItems.ionizatior_powder), new ItemStack(Items.blaze_powder), new ItemStack(NovaCraftItems.yttrlinsite_shard));

		registerShapeless("crystallized_vanite_helmet", new ItemStack(NovaCraftItems.crystallized_vanite_helmet), new ItemStack(NovaCraftItems.tophinite_helmet), new ItemStack(NovaCraftItems.crystallized_vanite_alloy), new ItemStack(NovaCraftItems.crystallized_vanite_alloy), new ItemStack(Items.diamond));
		registerShapeless("crystallized_vanite_chestplate", new ItemStack(NovaCraftItems.crystallized_vanite_chestplate), new ItemStack(NovaCraftItems.tophinite_chestplate), new ItemStack(NovaCraftItems.crystallized_vanite_alloy), new ItemStack(NovaCraftItems.crystallized_vanite_alloy), new ItemStack(Items.diamond));
		registerShapeless("crystallized_vanite_leggings", new ItemStack(NovaCraftItems.crystallized_vanite_leggings), new ItemStack(NovaCraftItems.tophinite_leggings), new ItemStack(NovaCraftItems.crystallized_vanite_alloy), new ItemStack(NovaCraftItems.crystallized_vanite_alloy), new ItemStack(Items.diamond));
		registerShapeless("crystallized_vanite_boots", new ItemStack(NovaCraftItems.crystallized_vanite_boots), new ItemStack(NovaCraftItems.tophinite_boots), new ItemStack(NovaCraftItems.crystallized_vanite_alloy), new ItemStack(NovaCraftItems.crystallized_vanite_alloy), new ItemStack(Items.diamond));

		if (Loader.isModLoaded("etfuturum")) {
			try {
				Block ancient_debris = GameRegistry.findBlock("etfuturum", "ancient_debris");
				if (ancient_debris != null && Configs.enableNetheriteInRecipes) {
					registerShapeless("iridium_sword", new ItemStack(NovaCraftItems.iridium_sword), new ItemStack(OtherModItems.netherite_sword), new ItemStack(NovaCraftItems.reinforced_iridium_ingot), new ItemStack(NovaCraftItems.larimar_shard));
					registerShapeless("iridium_pickaxe", new ItemStack(NovaCraftItems.iridium_pickaxe), new ItemStack(OtherModItems.netherite_pickaxe), new ItemStack(NovaCraftItems.reinforced_iridium_ingot), new ItemStack(NovaCraftItems.larimar_shard));
					registerShapeless("iridium_shovel", new ItemStack(NovaCraftItems.iridium_shovel), new ItemStack(OtherModItems.netherite_spade), new ItemStack(NovaCraftItems.reinforced_iridium_ingot), new ItemStack(NovaCraftItems.larimar_shard));
					registerShapeless("iridium_axe", new ItemStack(NovaCraftItems.iridium_axe), new ItemStack(OtherModItems.netherite_axe), new ItemStack(NovaCraftItems.reinforced_iridium_ingot), new ItemStack(NovaCraftItems.larimar_shard));
					registerShapeless("iridium_hoe", new ItemStack(NovaCraftItems.iridium_hoe), new ItemStack(OtherModItems.netherite_hoe), new ItemStack(NovaCraftItems.reinforced_iridium_ingot), new ItemStack(NovaCraftItems.larimar_shard));

					registerShapeless("iridium_helmet", new ItemStack(NovaCraftItems.iridium_helmet), new ItemStack(OtherModItems.netherite_helmet), new ItemStack(NovaCraftItems.reinforced_iridium_ingot), new ItemStack(NovaCraftItems.larimar_shard));
					registerShapeless("iridium_chestplate", new ItemStack(NovaCraftItems.iridium_chestplate), new ItemStack(OtherModItems.netherite_chestplate), new ItemStack(NovaCraftItems.reinforced_iridium_ingot), new ItemStack(NovaCraftItems.larimar_shard));
					registerShapeless("iridium_leggings", new ItemStack(NovaCraftItems.iridium_leggings), new ItemStack(OtherModItems.netherite_leggings), new ItemStack(NovaCraftItems.reinforced_iridium_ingot), new ItemStack(NovaCraftItems.larimar_shard));
					registerShapeless("iridium_boots", new ItemStack(NovaCraftItems.iridium_boots), new ItemStack(OtherModItems.netherite_boots), new ItemStack(NovaCraftItems.reinforced_iridium_ingot), new ItemStack(NovaCraftItems.larimar_shard));

					registerShapeless("klangite_helmet", new ItemStack(NovaCraftItems.klangite_helmet), new ItemStack(OtherModItems.netherite_helmet), new ItemStack(NovaCraftItems.klangite_ingot), new ItemStack(NovaCraftItems.reinforced_vanite_ingot));
					registerShapeless("klangite_chestplate", new ItemStack(NovaCraftItems.klangite_chestplate), new ItemStack(OtherModItems.netherite_chestplate), new ItemStack(NovaCraftItems.klangite_ingot), new ItemStack(NovaCraftItems.reinforced_vanite_ingot));
					registerShapeless("klangite_leggings", new ItemStack(NovaCraftItems.klangite_leggings), new ItemStack(OtherModItems.netherite_leggings), new ItemStack(NovaCraftItems.klangite_ingot), new ItemStack(NovaCraftItems.reinforced_vanite_ingot));
					registerShapeless("klangite_boots", new ItemStack(NovaCraftItems.klangite_boots), new ItemStack(OtherModItems.netherite_boots), new ItemStack(NovaCraftItems.klangite_ingot), new ItemStack(NovaCraftItems.reinforced_vanite_ingot));

					registerShapeless("klangite_sword", new ItemStack(NovaCraftItems.klangite_sword), new ItemStack(OtherModItems.netherite_sword), new ItemStack(NovaCraftItems.klangite_ingot), new ItemStack(NovaCraftItems.reinforced_vanite_ingot));
					registerShapeless("klangite_pickaxe", new ItemStack(NovaCraftItems.klangite_pickaxe), new ItemStack(OtherModItems.netherite_pickaxe), new ItemStack(NovaCraftItems.klangite_ingot), new ItemStack(NovaCraftItems.reinforced_vanite_ingot));
					registerShapeless("klangite_shovel", new ItemStack(NovaCraftItems.klangite_shovel), new ItemStack(OtherModItems.netherite_spade), new ItemStack(NovaCraftItems.klangite_ingot), new ItemStack(NovaCraftItems.reinforced_vanite_ingot));
					registerShapeless("klangite_axe", new ItemStack(NovaCraftItems.klangite_axe), new ItemStack(OtherModItems.netherite_axe), new ItemStack(NovaCraftItems.klangite_ingot), new ItemStack(NovaCraftItems.reinforced_vanite_ingot));
					registerShapeless("klangite_hoe", new ItemStack(NovaCraftItems.klangite_hoe), new ItemStack(OtherModItems.netherite_hoe), new ItemStack(NovaCraftItems.klangite_ingot), new ItemStack(NovaCraftItems.reinforced_vanite_ingot));

					registerShapeless("tophinite_sword", new ItemStack(NovaCraftItems.tophinite_sword), new ItemStack(OtherModItems.netherite_sword), new ItemStack(NovaCraftItems.tophinite_gemstone), new ItemStack(NovaCraftItems.reinforced_vanite_ingot));
					registerShapeless("tophinite_pickaxe", new ItemStack(NovaCraftItems.tophinite_pickaxe), new ItemStack(OtherModItems.netherite_pickaxe), new ItemStack(NovaCraftItems.tophinite_gemstone), new ItemStack(NovaCraftItems.reinforced_vanite_ingot));
					registerShapeless("tophinite_shovel", new ItemStack(NovaCraftItems.tophinite_shovel), new ItemStack(OtherModItems.netherite_spade), new ItemStack(NovaCraftItems.tophinite_gemstone), new ItemStack(NovaCraftItems.reinforced_vanite_ingot));
					registerShapeless("tophinite_axe", new ItemStack(NovaCraftItems.tophinite_axe), new ItemStack(OtherModItems.netherite_axe), new ItemStack(NovaCraftItems.tophinite_gemstone), new ItemStack(NovaCraftItems.reinforced_vanite_ingot));
					registerShapeless("tophinite_hoe", new ItemStack(NovaCraftItems.tophinite_hoe), new ItemStack(OtherModItems.netherite_hoe), new ItemStack(NovaCraftItems.tophinite_gemstone), new ItemStack(NovaCraftItems.reinforced_vanite_ingot));

					registerShapeless("tophinite_helmet", new ItemStack(NovaCraftItems.tophinite_helmet), new ItemStack(OtherModItems.netherite_helmet), new ItemStack(NovaCraftItems.tophinite_gemstone), new ItemStack(NovaCraftItems.reinforced_vanite_ingot));
					registerShapeless("tophinite_chestplate", new ItemStack(NovaCraftItems.tophinite_chestplate), new ItemStack(OtherModItems.netherite_chestplate), new ItemStack(NovaCraftItems.tophinite_gemstone), new ItemStack(NovaCraftItems.reinforced_vanite_ingot));
					registerShapeless("tophinite_leggings", new ItemStack(NovaCraftItems.tophinite_leggings), new ItemStack(OtherModItems.netherite_leggings), new ItemStack(NovaCraftItems.tophinite_gemstone), new ItemStack(NovaCraftItems.reinforced_vanite_ingot));
					registerShapeless("tophinite_boots", new ItemStack(NovaCraftItems.tophinite_boots), new ItemStack(OtherModItems.netherite_boots), new ItemStack(NovaCraftItems.tophinite_gemstone), new ItemStack(NovaCraftItems.reinforced_vanite_ingot));

					registerShapeless("crystallized_vanite_sword", new ItemStack(NovaCraftItems.crystallized_vanite_sword), new ItemStack(OtherModItems.netherite_sword), new ItemStack(NovaCraftItems.crystallized_vanite_alloy), new ItemStack(NovaCraftItems.crystallized_vanite_alloy), new ItemStack(NovaCraftItems.ionizatior_powder));
					registerShapeless("crystallized_vanite_pickaxe", new ItemStack(NovaCraftItems.crystallized_vanite_pickaxe), new ItemStack(OtherModItems.netherite_pickaxe), new ItemStack(NovaCraftItems.crystallized_vanite_alloy), new ItemStack(NovaCraftItems.crystallized_vanite_alloy), new ItemStack(NovaCraftItems.ionizatior_powder));
					registerShapeless("crystallized_vanite_shovel", new ItemStack(NovaCraftItems.crystallized_vanite_shovel), new ItemStack(OtherModItems.netherite_spade), new ItemStack(NovaCraftItems.crystallized_vanite_alloy), new ItemStack(NovaCraftItems.crystallized_vanite_alloy), new ItemStack(NovaCraftItems.ionizatior_powder));
					registerShapeless("crystallized_vanite_axe", new ItemStack(NovaCraftItems.crystallized_vanite_axe), new ItemStack(OtherModItems.netherite_axe), new ItemStack(NovaCraftItems.crystallized_vanite_alloy), new ItemStack(NovaCraftItems.crystallized_vanite_alloy), new ItemStack(NovaCraftItems.ionizatior_powder));
					registerShapeless("crystallized_vanite_hoe", new ItemStack(NovaCraftItems.crystallized_vanite_hoe), new ItemStack(OtherModItems.netherite_hoe), new ItemStack(NovaCraftItems.crystallized_vanite_alloy), new ItemStack(NovaCraftItems.crystallized_vanite_alloy), new ItemStack(NovaCraftItems.ionizatior_powder));

					registerShapeless("crystallized_vanite_helmet", new ItemStack(NovaCraftItems.crystallized_vanite_helmet), new ItemStack(OtherModItems.netherite_helmet), new ItemStack(NovaCraftItems.crystallized_vanite_alloy), new ItemStack(NovaCraftItems.crystallized_vanite_alloy), new ItemStack(Items.diamond));
					registerShapeless("crystallized_vanite_chestplate", new ItemStack(NovaCraftItems.crystallized_vanite_chestplate), new ItemStack(OtherModItems.netherite_chestplate), new ItemStack(NovaCraftItems.crystallized_vanite_alloy), new ItemStack(NovaCraftItems.crystallized_vanite_alloy), new ItemStack(Items.diamond));
					registerShapeless("crystallized_vanite_leggings", new ItemStack(NovaCraftItems.crystallized_vanite_leggings), new ItemStack(OtherModItems.netherite_leggings), new ItemStack(NovaCraftItems.crystallized_vanite_alloy), new ItemStack(NovaCraftItems.crystallized_vanite_alloy), new ItemStack(Items.diamond));
					registerShapeless("crystallized_vanite_boots", new ItemStack(NovaCraftItems.crystallized_vanite_boots), new ItemStack(OtherModItems.netherite_boots), new ItemStack(NovaCraftItems.crystallized_vanite_alloy), new ItemStack(NovaCraftItems.crystallized_vanite_alloy), new ItemStack(Items.diamond));
				} else {
					registerShapeless("iridium_sword", new ItemStack(NovaCraftItems.iridium_sword), new ItemStack(Items.diamond_sword), new ItemStack(NovaCraftItems.reinforced_iridium_ingot), new ItemStack(NovaCraftItems.larimar_shard));
					registerShapeless("iridium_pickaxe", new ItemStack(NovaCraftItems.iridium_pickaxe), new ItemStack(Items.diamond_pickaxe), new ItemStack(NovaCraftItems.reinforced_iridium_ingot), new ItemStack(NovaCraftItems.larimar_shard));
					registerShapeless("iridium_shovel", new ItemStack(NovaCraftItems.iridium_shovel), new ItemStack(Items.diamond_shovel), new ItemStack(NovaCraftItems.reinforced_iridium_ingot), new ItemStack(NovaCraftItems.larimar_shard));
					registerShapeless("iridium_axe", new ItemStack(NovaCraftItems.iridium_axe), new ItemStack(Items.diamond_axe), new ItemStack(NovaCraftItems.reinforced_iridium_ingot), new ItemStack(NovaCraftItems.larimar_shard));
					registerShapeless("iridium_hoe", new ItemStack(NovaCraftItems.iridium_hoe), new ItemStack(Items.diamond_hoe), new ItemStack(NovaCraftItems.reinforced_iridium_ingot), new ItemStack(NovaCraftItems.larimar_shard));

					registerShapeless("iridium_helmet", new ItemStack(NovaCraftItems.iridium_helmet), new ItemStack(Items.diamond_helmet), new ItemStack(NovaCraftItems.reinforced_iridium_ingot), new ItemStack(NovaCraftItems.larimar_shard));
					registerShapeless("iridium_chestplate", new ItemStack(NovaCraftItems.iridium_chestplate), new ItemStack(Items.diamond_chestplate), new ItemStack(NovaCraftItems.reinforced_iridium_ingot), new ItemStack(NovaCraftItems.larimar_shard));
					registerShapeless("iridium_leggings", new ItemStack(NovaCraftItems.iridium_leggings), new ItemStack(Items.diamond_leggings), new ItemStack(NovaCraftItems.reinforced_iridium_ingot), new ItemStack(NovaCraftItems.larimar_shard));
					registerShapeless("iridium_boots", new ItemStack(NovaCraftItems.iridium_boots), new ItemStack(Items.diamond_boots), new ItemStack(NovaCraftItems.reinforced_iridium_ingot), new ItemStack(NovaCraftItems.larimar_shard));

					registerShapeless("klangite_helmet", new ItemStack(NovaCraftItems.klangite_helmet), new ItemStack(Items.diamond_helmet), new ItemStack(NovaCraftItems.klangite_ingot), new ItemStack(NovaCraftItems.reinforced_vanite_ingot));
					registerShapeless("klangite_chestplate", new ItemStack(NovaCraftItems.klangite_chestplate), new ItemStack(Items.diamond_chestplate), new ItemStack(NovaCraftItems.klangite_ingot), new ItemStack(NovaCraftItems.reinforced_vanite_ingot));
					registerShapeless("klangite_leggings", new ItemStack(NovaCraftItems.klangite_leggings), new ItemStack(Items.diamond_leggings), new ItemStack(NovaCraftItems.klangite_ingot), new ItemStack(NovaCraftItems.reinforced_vanite_ingot));
					registerShapeless("klangite_boots", new ItemStack(NovaCraftItems.klangite_boots), new ItemStack(Items.diamond_boots), new ItemStack(NovaCraftItems.klangite_ingot), new ItemStack(NovaCraftItems.reinforced_vanite_ingot));

					registerShapeless("klangite_sword", new ItemStack(NovaCraftItems.klangite_sword), new ItemStack(Items.diamond_sword), new ItemStack(NovaCraftItems.klangite_ingot), new ItemStack(NovaCraftItems.reinforced_vanite_ingot));
					registerShapeless("klangite_pickaxe", new ItemStack(NovaCraftItems.klangite_pickaxe), new ItemStack(Items.diamond_pickaxe), new ItemStack(NovaCraftItems.klangite_ingot), new ItemStack(NovaCraftItems.reinforced_vanite_ingot));
					registerShapeless("klangite_shovel", new ItemStack(NovaCraftItems.klangite_shovel), new ItemStack(Items.diamond_shovel), new ItemStack(NovaCraftItems.klangite_ingot), new ItemStack(NovaCraftItems.reinforced_vanite_ingot));
					registerShapeless("klangite_axe", new ItemStack(NovaCraftItems.klangite_axe), new ItemStack(Items.diamond_axe), new ItemStack(NovaCraftItems.klangite_ingot), new ItemStack(NovaCraftItems.reinforced_vanite_ingot));
					registerShapeless("klangite_hoe", new ItemStack(NovaCraftItems.klangite_hoe), new ItemStack(Items.diamond_hoe), new ItemStack(NovaCraftItems.klangite_ingot), new ItemStack(NovaCraftItems.reinforced_vanite_ingot));

					registerShapeless("tophinite_sword", new ItemStack(NovaCraftItems.tophinite_sword), new ItemStack(Items.diamond_sword), new ItemStack(NovaCraftItems.tophinite_gemstone), new ItemStack(NovaCraftItems.reinforced_vanite_ingot));
					registerShapeless("tophinite_pickaxe", new ItemStack(NovaCraftItems.tophinite_pickaxe), new ItemStack(Items.diamond_pickaxe), new ItemStack(NovaCraftItems.tophinite_gemstone), new ItemStack(NovaCraftItems.reinforced_vanite_ingot));
					registerShapeless("tophinite_shovel", new ItemStack(NovaCraftItems.tophinite_shovel), new ItemStack(Items.diamond_shovel), new ItemStack(NovaCraftItems.tophinite_gemstone), new ItemStack(NovaCraftItems.reinforced_vanite_ingot));
					registerShapeless("tophinite_axe", new ItemStack(NovaCraftItems.tophinite_axe), new ItemStack(Items.diamond_axe), new ItemStack(NovaCraftItems.tophinite_gemstone), new ItemStack(NovaCraftItems.reinforced_vanite_ingot));
					registerShapeless("tophinite_hoe", new ItemStack(NovaCraftItems.tophinite_hoe), new ItemStack(Items.diamond_hoe), new ItemStack(NovaCraftItems.tophinite_gemstone), new ItemStack(NovaCraftItems.reinforced_vanite_ingot));

					registerShapeless("tophinite_helmet", new ItemStack(NovaCraftItems.tophinite_helmet), new ItemStack(Items.diamond_helmet), new ItemStack(NovaCraftItems.tophinite_gemstone), new ItemStack(NovaCraftItems.reinforced_vanite_ingot));
					registerShapeless("tophinite_chestplate", new ItemStack(NovaCraftItems.tophinite_chestplate), new ItemStack(Items.diamond_chestplate), new ItemStack(NovaCraftItems.tophinite_gemstone), new ItemStack(NovaCraftItems.reinforced_vanite_ingot));
					registerShapeless("tophinite_leggings", new ItemStack(NovaCraftItems.tophinite_leggings), new ItemStack(Items.diamond_leggings), new ItemStack(NovaCraftItems.tophinite_gemstone), new ItemStack(NovaCraftItems.reinforced_vanite_ingot));
					registerShapeless("tophinite_boots", new ItemStack(NovaCraftItems.tophinite_boots), new ItemStack(Items.diamond_boots), new ItemStack(NovaCraftItems.tophinite_gemstone), new ItemStack(NovaCraftItems.reinforced_vanite_ingot));

					registerShapeless("crystallized_vanite_sword", new ItemStack(NovaCraftItems.crystallized_vanite_sword), new ItemStack(Items.diamond_sword), new ItemStack(NovaCraftItems.crystallized_vanite_alloy), new ItemStack(NovaCraftItems.crystallized_vanite_alloy), new ItemStack(NovaCraftItems.ionizatior_powder));
					registerShapeless("crystallized_vanite_pickaxe", new ItemStack(NovaCraftItems.crystallized_vanite_pickaxe), new ItemStack(Items.diamond_pickaxe), new ItemStack(NovaCraftItems.crystallized_vanite_alloy), new ItemStack(NovaCraftItems.crystallized_vanite_alloy), new ItemStack(NovaCraftItems.ionizatior_powder));
					registerShapeless("crystallized_vanite_shovel", new ItemStack(NovaCraftItems.crystallized_vanite_shovel), new ItemStack(Items.diamond_shovel), new ItemStack(NovaCraftItems.crystallized_vanite_alloy), new ItemStack(NovaCraftItems.crystallized_vanite_alloy), new ItemStack(NovaCraftItems.ionizatior_powder));
					registerShapeless("crystallized_vanite_axe", new ItemStack(NovaCraftItems.crystallized_vanite_axe), new ItemStack(Items.diamond_axe), new ItemStack(NovaCraftItems.crystallized_vanite_alloy), new ItemStack(NovaCraftItems.crystallized_vanite_alloy), new ItemStack(NovaCraftItems.ionizatior_powder));
					registerShapeless("crystallized_vanite_hoe", new ItemStack(NovaCraftItems.crystallized_vanite_hoe), new ItemStack(Items.diamond_hoe), new ItemStack(NovaCraftItems.crystallized_vanite_alloy), new ItemStack(NovaCraftItems.crystallized_vanite_alloy), new ItemStack(NovaCraftItems.ionizatior_powder));

					registerShapeless("crystallized_vanite_helmet", new ItemStack(NovaCraftItems.crystallized_vanite_helmet), new ItemStack(Items.diamond_helmet), new ItemStack(NovaCraftItems.crystallized_vanite_alloy), new ItemStack(NovaCraftItems.crystallized_vanite_alloy), new ItemStack(Items.diamond));
					registerShapeless("crystallized_vanite_chestplate", new ItemStack(NovaCraftItems.crystallized_vanite_chestplate), new ItemStack(Items.diamond_chestplate), new ItemStack(NovaCraftItems.crystallized_vanite_alloy), new ItemStack(NovaCraftItems.crystallized_vanite_alloy), new ItemStack(Items.diamond));
					registerShapeless("crystallized_vanite_leggings", new ItemStack(NovaCraftItems.crystallized_vanite_leggings), new ItemStack(Items.diamond_leggings), new ItemStack(NovaCraftItems.crystallized_vanite_alloy), new ItemStack(NovaCraftItems.crystallized_vanite_alloy), new ItemStack(Items.diamond));
					registerShapeless("crystallized_vanite_boots", new ItemStack(NovaCraftItems.crystallized_vanite_boots), new ItemStack(Items.diamond_boots), new ItemStack(NovaCraftItems.crystallized_vanite_alloy), new ItemStack(NovaCraftItems.crystallized_vanite_alloy), new ItemStack(Items.diamond));
				}
			} catch (Exception ex) {
				if (Configs.enableDebugMode) {
					System.out.println("Netherite from Et Futurum Requiem is missing, using alternate recipe...");
				}
				registerShapeless("iridium_sword", new ItemStack(NovaCraftItems.iridium_sword), new ItemStack(Items.diamond_sword), new ItemStack(NovaCraftItems.reinforced_iridium_ingot), new ItemStack(NovaCraftItems.larimar_shard));
				registerShapeless("iridium_pickaxe", new ItemStack(NovaCraftItems.iridium_pickaxe), new ItemStack(Items.diamond_pickaxe), new ItemStack(NovaCraftItems.reinforced_iridium_ingot), new ItemStack(NovaCraftItems.larimar_shard));
				registerShapeless("iridium_shovel", new ItemStack(NovaCraftItems.iridium_shovel), new ItemStack(Items.diamond_shovel), new ItemStack(NovaCraftItems.reinforced_iridium_ingot), new ItemStack(NovaCraftItems.larimar_shard));
				registerShapeless("iridium_axe", new ItemStack(NovaCraftItems.iridium_axe), new ItemStack(Items.diamond_axe), new ItemStack(NovaCraftItems.reinforced_iridium_ingot), new ItemStack(NovaCraftItems.larimar_shard));
				registerShapeless("iridium_hoe", new ItemStack(NovaCraftItems.iridium_hoe), new ItemStack(Items.diamond_hoe), new ItemStack(NovaCraftItems.reinforced_iridium_ingot), new ItemStack(NovaCraftItems.larimar_shard));

				registerShapeless("iridium_helmet", new ItemStack(NovaCraftItems.iridium_helmet), new ItemStack(Items.diamond_helmet), new ItemStack(NovaCraftItems.reinforced_iridium_ingot), new ItemStack(NovaCraftItems.larimar_shard));
				registerShapeless("iridium_chestplate", new ItemStack(NovaCraftItems.iridium_chestplate), new ItemStack(Items.diamond_chestplate), new ItemStack(NovaCraftItems.reinforced_iridium_ingot), new ItemStack(NovaCraftItems.larimar_shard));
				registerShapeless("iridium_leggings", new ItemStack(NovaCraftItems.iridium_leggings), new ItemStack(Items.diamond_leggings), new ItemStack(NovaCraftItems.reinforced_iridium_ingot), new ItemStack(NovaCraftItems.larimar_shard));
				registerShapeless("iridium_boots", new ItemStack(NovaCraftItems.iridium_boots), new ItemStack(Items.diamond_boots), new ItemStack(NovaCraftItems.reinforced_iridium_ingot), new ItemStack(NovaCraftItems.larimar_shard));

				registerShapeless("klangite_helmet", new ItemStack(NovaCraftItems.klangite_helmet), new ItemStack(Items.diamond_helmet), new ItemStack(NovaCraftItems.klangite_ingot), new ItemStack(NovaCraftItems.reinforced_vanite_ingot));
				registerShapeless("klangite_chestplate", new ItemStack(NovaCraftItems.klangite_chestplate), new ItemStack(Items.diamond_chestplate), new ItemStack(NovaCraftItems.klangite_ingot), new ItemStack(NovaCraftItems.reinforced_vanite_ingot));
				registerShapeless("klangite_leggings", new ItemStack(NovaCraftItems.klangite_leggings), new ItemStack(Items.diamond_leggings), new ItemStack(NovaCraftItems.klangite_ingot), new ItemStack(NovaCraftItems.reinforced_vanite_ingot));
				registerShapeless("klangite_boots", new ItemStack(NovaCraftItems.klangite_boots), new ItemStack(Items.diamond_boots), new ItemStack(NovaCraftItems.klangite_ingot), new ItemStack(NovaCraftItems.reinforced_vanite_ingot));

				registerShapeless("klangite_sword", new ItemStack(NovaCraftItems.klangite_sword), new ItemStack(Items.diamond_sword), new ItemStack(NovaCraftItems.klangite_ingot), new ItemStack(NovaCraftItems.reinforced_vanite_ingot));
				registerShapeless("klangite_pickaxe", new ItemStack(NovaCraftItems.klangite_pickaxe), new ItemStack(Items.diamond_pickaxe), new ItemStack(NovaCraftItems.klangite_ingot), new ItemStack(NovaCraftItems.reinforced_vanite_ingot));
				registerShapeless("klangite_shovel", new ItemStack(NovaCraftItems.klangite_shovel), new ItemStack(Items.diamond_shovel), new ItemStack(NovaCraftItems.klangite_ingot), new ItemStack(NovaCraftItems.reinforced_vanite_ingot));
				registerShapeless("klangite_axe", new ItemStack(NovaCraftItems.klangite_axe), new ItemStack(Items.diamond_axe), new ItemStack(NovaCraftItems.klangite_ingot), new ItemStack(NovaCraftItems.reinforced_vanite_ingot));
				registerShapeless("klangite_hoe", new ItemStack(NovaCraftItems.klangite_hoe), new ItemStack(Items.diamond_hoe), new ItemStack(NovaCraftItems.klangite_ingot), new ItemStack(NovaCraftItems.reinforced_vanite_ingot));

				registerShapeless("tophinite_sword", new ItemStack(NovaCraftItems.tophinite_sword), new ItemStack(Items.diamond_sword), new ItemStack(NovaCraftItems.tophinite_gemstone), new ItemStack(NovaCraftItems.reinforced_vanite_ingot));
				registerShapeless("tophinite_pickaxe", new ItemStack(NovaCraftItems.tophinite_pickaxe), new ItemStack(Items.diamond_pickaxe), new ItemStack(NovaCraftItems.tophinite_gemstone), new ItemStack(NovaCraftItems.reinforced_vanite_ingot));
				registerShapeless("tophinite_shovel", new ItemStack(NovaCraftItems.tophinite_shovel), new ItemStack(Items.diamond_shovel), new ItemStack(NovaCraftItems.tophinite_gemstone), new ItemStack(NovaCraftItems.reinforced_vanite_ingot));
				registerShapeless("tophinite_axe", new ItemStack(NovaCraftItems.tophinite_axe), new ItemStack(Items.diamond_axe), new ItemStack(NovaCraftItems.tophinite_gemstone), new ItemStack(NovaCraftItems.reinforced_vanite_ingot));
				registerShapeless("tophinite_hoe", new ItemStack(NovaCraftItems.tophinite_hoe), new ItemStack(Items.diamond_hoe), new ItemStack(NovaCraftItems.tophinite_gemstone), new ItemStack(NovaCraftItems.reinforced_vanite_ingot));

				registerShapeless("tophinite_helmet", new ItemStack(NovaCraftItems.tophinite_helmet), new ItemStack(Items.diamond_helmet), new ItemStack(NovaCraftItems.tophinite_gemstone), new ItemStack(NovaCraftItems.reinforced_vanite_ingot));
				registerShapeless("tophinite_chestplate", new ItemStack(NovaCraftItems.tophinite_chestplate), new ItemStack(Items.diamond_chestplate), new ItemStack(NovaCraftItems.tophinite_gemstone), new ItemStack(NovaCraftItems.reinforced_vanite_ingot));
				registerShapeless("tophinite_leggings", new ItemStack(NovaCraftItems.tophinite_leggings), new ItemStack(Items.diamond_leggings), new ItemStack(NovaCraftItems.tophinite_gemstone), new ItemStack(NovaCraftItems.reinforced_vanite_ingot));
				registerShapeless("tophinite_boots", new ItemStack(NovaCraftItems.tophinite_boots), new ItemStack(Items.diamond_boots), new ItemStack(NovaCraftItems.tophinite_gemstone), new ItemStack(NovaCraftItems.reinforced_vanite_ingot));

				registerShapeless("crystallized_vanite_sword", new ItemStack(NovaCraftItems.crystallized_vanite_sword), new ItemStack(Items.diamond_sword), new ItemStack(NovaCraftItems.crystallized_vanite_alloy), new ItemStack(NovaCraftItems.crystallized_vanite_alloy), new ItemStack(NovaCraftItems.ionizatior_powder));
				registerShapeless("crystallized_vanite_pickaxe", new ItemStack(NovaCraftItems.crystallized_vanite_pickaxe), new ItemStack(Items.diamond_pickaxe), new ItemStack(NovaCraftItems.crystallized_vanite_alloy), new ItemStack(NovaCraftItems.crystallized_vanite_alloy), new ItemStack(NovaCraftItems.ionizatior_powder));
				registerShapeless("crystallized_vanite_shovel", new ItemStack(NovaCraftItems.crystallized_vanite_shovel), new ItemStack(Items.diamond_shovel), new ItemStack(NovaCraftItems.crystallized_vanite_alloy), new ItemStack(NovaCraftItems.crystallized_vanite_alloy), new ItemStack(NovaCraftItems.ionizatior_powder));
				registerShapeless("crystallized_vanite_axe", new ItemStack(NovaCraftItems.crystallized_vanite_axe), new ItemStack(Items.diamond_axe), new ItemStack(NovaCraftItems.crystallized_vanite_alloy), new ItemStack(NovaCraftItems.crystallized_vanite_alloy), new ItemStack(NovaCraftItems.ionizatior_powder));
				registerShapeless("crystallized_vanite_hoe", new ItemStack(NovaCraftItems.crystallized_vanite_hoe), new ItemStack(Items.diamond_hoe), new ItemStack(NovaCraftItems.crystallized_vanite_alloy), new ItemStack(NovaCraftItems.crystallized_vanite_alloy), new ItemStack(NovaCraftItems.ionizatior_powder));

				registerShapeless("crystallized_vanite_helmet", new ItemStack(NovaCraftItems.crystallized_vanite_helmet), new ItemStack(Items.diamond_helmet), new ItemStack(NovaCraftItems.crystallized_vanite_alloy), new ItemStack(NovaCraftItems.crystallized_vanite_alloy), new ItemStack(Items.diamond));
				registerShapeless("crystallized_vanite_chestplate", new ItemStack(NovaCraftItems.crystallized_vanite_chestplate), new ItemStack(Items.diamond_chestplate), new ItemStack(NovaCraftItems.crystallized_vanite_alloy), new ItemStack(NovaCraftItems.crystallized_vanite_alloy), new ItemStack(Items.diamond));
				registerShapeless("crystallized_vanite_leggings", new ItemStack(NovaCraftItems.crystallized_vanite_leggings), new ItemStack(Items.diamond_leggings), new ItemStack(NovaCraftItems.crystallized_vanite_alloy), new ItemStack(NovaCraftItems.crystallized_vanite_alloy), new ItemStack(Items.diamond));
				registerShapeless("crystallized_vanite_boots", new ItemStack(NovaCraftItems.crystallized_vanite_boots), new ItemStack(Items.diamond_boots), new ItemStack(NovaCraftItems.crystallized_vanite_alloy), new ItemStack(NovaCraftItems.crystallized_vanite_alloy), new ItemStack(Items.diamond));
			}
		} else {
			registerShapeless("iridium_sword", new ItemStack(NovaCraftItems.iridium_sword), new ItemStack(Items.diamond_sword), new ItemStack(NovaCraftItems.reinforced_iridium_ingot), new ItemStack(NovaCraftItems.larimar_shard));
			registerShapeless("iridium_pickaxe", new ItemStack(NovaCraftItems.iridium_pickaxe), new ItemStack(Items.diamond_pickaxe), new ItemStack(NovaCraftItems.reinforced_iridium_ingot), new ItemStack(NovaCraftItems.larimar_shard));
			registerShapeless("iridium_shovel", new ItemStack(NovaCraftItems.iridium_shovel), new ItemStack(Items.diamond_shovel), new ItemStack(NovaCraftItems.reinforced_iridium_ingot), new ItemStack(NovaCraftItems.larimar_shard));
			registerShapeless("iridium_axe", new ItemStack(NovaCraftItems.iridium_axe), new ItemStack(Items.diamond_axe), new ItemStack(NovaCraftItems.reinforced_iridium_ingot), new ItemStack(NovaCraftItems.larimar_shard));
			registerShapeless("iridium_hoe", new ItemStack(NovaCraftItems.iridium_hoe), new ItemStack(Items.diamond_hoe), new ItemStack(NovaCraftItems.reinforced_iridium_ingot), new ItemStack(NovaCraftItems.larimar_shard));

			registerShapeless("iridium_helmet", new ItemStack(NovaCraftItems.iridium_helmet), new ItemStack(Items.diamond_helmet), new ItemStack(NovaCraftItems.reinforced_iridium_ingot), new ItemStack(NovaCraftItems.larimar_shard));
			registerShapeless("iridium_chestplate", new ItemStack(NovaCraftItems.iridium_chestplate), new ItemStack(Items.diamond_chestplate), new ItemStack(NovaCraftItems.reinforced_iridium_ingot), new ItemStack(NovaCraftItems.larimar_shard));
			registerShapeless("iridium_leggings", new ItemStack(NovaCraftItems.iridium_leggings), new ItemStack(Items.diamond_leggings), new ItemStack(NovaCraftItems.reinforced_iridium_ingot), new ItemStack(NovaCraftItems.larimar_shard));
			registerShapeless("iridium_boots", new ItemStack(NovaCraftItems.iridium_boots), new ItemStack(Items.diamond_boots), new ItemStack(NovaCraftItems.reinforced_iridium_ingot), new ItemStack(NovaCraftItems.larimar_shard));

			registerShapeless("klangite_helmet", new ItemStack(NovaCraftItems.klangite_helmet), new ItemStack(Items.diamond_helmet), new ItemStack(NovaCraftItems.klangite_ingot), new ItemStack(NovaCraftItems.reinforced_vanite_ingot));
			registerShapeless("klangite_chestplate", new ItemStack(NovaCraftItems.klangite_chestplate), new ItemStack(Items.diamond_chestplate), new ItemStack(NovaCraftItems.klangite_ingot), new ItemStack(NovaCraftItems.reinforced_vanite_ingot));
			registerShapeless("klangite_leggings", new ItemStack(NovaCraftItems.klangite_leggings), new ItemStack(Items.diamond_leggings), new ItemStack(NovaCraftItems.klangite_ingot), new ItemStack(NovaCraftItems.reinforced_vanite_ingot));
			registerShapeless("klangite_boots", new ItemStack(NovaCraftItems.klangite_boots), new ItemStack(Items.diamond_boots), new ItemStack(NovaCraftItems.klangite_ingot), new ItemStack(NovaCraftItems.reinforced_vanite_ingot));

			registerShapeless("klangite_sword", new ItemStack(NovaCraftItems.klangite_sword), new ItemStack(Items.diamond_sword), new ItemStack(NovaCraftItems.klangite_ingot), new ItemStack(NovaCraftItems.reinforced_vanite_ingot));
			registerShapeless("klangite_pickaxe", new ItemStack(NovaCraftItems.klangite_pickaxe), new ItemStack(Items.diamond_pickaxe), new ItemStack(NovaCraftItems.klangite_ingot), new ItemStack(NovaCraftItems.reinforced_vanite_ingot));
			registerShapeless("klangite_shovel", new ItemStack(NovaCraftItems.klangite_shovel), new ItemStack(Items.diamond_shovel), new ItemStack(NovaCraftItems.klangite_ingot), new ItemStack(NovaCraftItems.reinforced_vanite_ingot));
			registerShapeless("klangite_axe", new ItemStack(NovaCraftItems.klangite_axe), new ItemStack(Items.diamond_axe), new ItemStack(NovaCraftItems.klangite_ingot), new ItemStack(NovaCraftItems.reinforced_vanite_ingot));
			registerShapeless("klangite_hoe", new ItemStack(NovaCraftItems.klangite_hoe), new ItemStack(Items.diamond_hoe), new ItemStack(NovaCraftItems.klangite_ingot), new ItemStack(NovaCraftItems.reinforced_vanite_ingot));

			registerShapeless("tophinite_sword", new ItemStack(NovaCraftItems.tophinite_sword), new ItemStack(Items.diamond_sword), new ItemStack(NovaCraftItems.tophinite_gemstone), new ItemStack(NovaCraftItems.reinforced_vanite_ingot));
			registerShapeless("tophinite_pickaxe", new ItemStack(NovaCraftItems.tophinite_pickaxe), new ItemStack(Items.diamond_pickaxe), new ItemStack(NovaCraftItems.tophinite_gemstone), new ItemStack(NovaCraftItems.reinforced_vanite_ingot));
			registerShapeless("tophinite_shovel", new ItemStack(NovaCraftItems.tophinite_shovel), new ItemStack(Items.diamond_shovel), new ItemStack(NovaCraftItems.tophinite_gemstone), new ItemStack(NovaCraftItems.reinforced_vanite_ingot));
			registerShapeless("tophinite_axe", new ItemStack(NovaCraftItems.tophinite_axe), new ItemStack(Items.diamond_axe), new ItemStack(NovaCraftItems.tophinite_gemstone), new ItemStack(NovaCraftItems.reinforced_vanite_ingot));
			registerShapeless("tophinite_hoe", new ItemStack(NovaCraftItems.tophinite_hoe), new ItemStack(Items.diamond_hoe), new ItemStack(NovaCraftItems.tophinite_gemstone), new ItemStack(NovaCraftItems.reinforced_vanite_ingot));

			registerShapeless("tophinite_helmet", new ItemStack(NovaCraftItems.tophinite_helmet), new ItemStack(Items.diamond_helmet), new ItemStack(NovaCraftItems.tophinite_gemstone), new ItemStack(NovaCraftItems.reinforced_vanite_ingot));
			registerShapeless("tophinite_chestplate", new ItemStack(NovaCraftItems.tophinite_chestplate), new ItemStack(Items.diamond_chestplate), new ItemStack(NovaCraftItems.tophinite_gemstone), new ItemStack(NovaCraftItems.reinforced_vanite_ingot));
			registerShapeless("tophinite_leggings", new ItemStack(NovaCraftItems.tophinite_leggings), new ItemStack(Items.diamond_leggings), new ItemStack(NovaCraftItems.tophinite_gemstone), new ItemStack(NovaCraftItems.reinforced_vanite_ingot));
			registerShapeless("tophinite_boots", new ItemStack(NovaCraftItems.tophinite_boots), new ItemStack(Items.diamond_boots), new ItemStack(NovaCraftItems.tophinite_gemstone), new ItemStack(NovaCraftItems.reinforced_vanite_ingot));

			registerShapeless("crystallized_vanite_sword", new ItemStack(NovaCraftItems.crystallized_vanite_sword), new ItemStack(Items.diamond_sword), new ItemStack(NovaCraftItems.crystallized_vanite_alloy), new ItemStack(NovaCraftItems.crystallized_vanite_alloy), new ItemStack(NovaCraftItems.ionizatior_powder));
			registerShapeless("crystallized_vanite_pickaxe", new ItemStack(NovaCraftItems.crystallized_vanite_pickaxe), new ItemStack(Items.diamond_pickaxe), new ItemStack(NovaCraftItems.crystallized_vanite_alloy), new ItemStack(NovaCraftItems.crystallized_vanite_alloy), new ItemStack(NovaCraftItems.ionizatior_powder));
			registerShapeless("crystallized_vanite_shovel", new ItemStack(NovaCraftItems.crystallized_vanite_shovel), new ItemStack(Items.diamond_shovel), new ItemStack(NovaCraftItems.crystallized_vanite_alloy), new ItemStack(NovaCraftItems.crystallized_vanite_alloy), new ItemStack(NovaCraftItems.ionizatior_powder));
			registerShapeless("crystallized_vanite_axe", new ItemStack(NovaCraftItems.crystallized_vanite_axe), new ItemStack(Items.diamond_axe), new ItemStack(NovaCraftItems.crystallized_vanite_alloy), new ItemStack(NovaCraftItems.crystallized_vanite_alloy), new ItemStack(NovaCraftItems.ionizatior_powder));
			registerShapeless("crystallized_vanite_hoe", new ItemStack(NovaCraftItems.crystallized_vanite_hoe), new ItemStack(Items.diamond_hoe), new ItemStack(NovaCraftItems.crystallized_vanite_alloy), new ItemStack(NovaCraftItems.crystallized_vanite_alloy), new ItemStack(NovaCraftItems.ionizatior_powder));

			registerShapeless("crystallized_vanite_helmet", new ItemStack(NovaCraftItems.crystallized_vanite_helmet), new ItemStack(Items.diamond_helmet), new ItemStack(NovaCraftItems.crystallized_vanite_alloy), new ItemStack(NovaCraftItems.crystallized_vanite_alloy), new ItemStack(Items.diamond));
			registerShapeless("crystallized_vanite_chestplate", new ItemStack(NovaCraftItems.crystallized_vanite_chestplate), new ItemStack(Items.diamond_chestplate), new ItemStack(NovaCraftItems.crystallized_vanite_alloy), new ItemStack(NovaCraftItems.crystallized_vanite_alloy), new ItemStack(Items.diamond));
			registerShapeless("crystallized_vanite_leggings", new ItemStack(NovaCraftItems.crystallized_vanite_leggings), new ItemStack(Items.diamond_leggings), new ItemStack(NovaCraftItems.crystallized_vanite_alloy), new ItemStack(NovaCraftItems.crystallized_vanite_alloy), new ItemStack(Items.diamond));
			registerShapeless("crystallized_vanite_boots", new ItemStack(NovaCraftItems.crystallized_vanite_boots), new ItemStack(Items.diamond_boots), new ItemStack(NovaCraftItems.crystallized_vanite_alloy), new ItemStack(NovaCraftItems.crystallized_vanite_alloy), new ItemStack(Items.diamond));
		}

		registerShapeless("end_stew", new ItemStack(NovaCraftItems.cave_stew, 2, 4), new ItemStack(NovaCraftBlocks.ender_brain), new ItemStack(NovaCraftBlocks.ender_fungus), new ItemStack(NovaCraftBlocks.ender_sprout), new ItemStack(Items.mushroom_stew), new ItemStack(Items.bowl));
		registerShapeless("nether_stew", new ItemStack(NovaCraftItems.cave_stew, 2, 3), new ItemStack(NovaCraftBlocks.hell_piliz), new ItemStack(NovaCraftBlocks.ion_mushroom), new ItemStack(NovaCraftBlocks.deepoid_mushroom), new ItemStack(Items.mushroom_stew), new ItemStack(Items.bowl));
		registerShapeless("sculk_stew", new ItemStack(NovaCraftItems.cave_stew, 2, 2), new ItemStack(NovaCraftBlocks.hydnum_mushroom), new ItemStack(NovaCraftItems.sculk_flesh), new ItemStack(NovaCraftItems.cave_monitor_tongue), new ItemStack(Items.mushroom_stew), new ItemStack(Items.bowl));
		registerShapeless("deep_stew", new ItemStack(NovaCraftItems.cave_stew, 2, 1), new ItemStack(NovaCraftBlocks.pleurotus_mushroom), new ItemStack(NovaCraftItems.pherithium_carrot), new ItemStack(NovaCraftBlocks.deep_roots), new ItemStack(Items.mushroom_stew), new ItemStack(Items.bowl));
		registerShapeless("cave_stew", new ItemStack(NovaCraftItems.cave_stew, 2, 0), new ItemStack(NovaCraftBlocks.calvatia_mushroom), new ItemStack(NovaCraftBlocks.glow_lichen), new ItemStack(NovaCraftItems.pherithium_carrot), new ItemStack(Items.mushroom_stew), new ItemStack(Items.bowl));

		registerShapeless("miners_stew", new ItemStack(NovaCraftItems.cave_stew, 2, 5), new ItemStack(NovaCraftBlocks.calvatia_mushroom), new ItemStack(NovaCraftBlocks.pleurotus_mushroom), new ItemStack(NovaCraftBlocks.hydnum_mushroom), new ItemStack(NovaCraftBlocks.lentius_mushroom), new ItemStack(NovaCraftBlocks.rozite_mushroom), new ItemStack(NovaCraftItems.pherithium_carrot), new ItemStack(NovaCraftItems.cave_monitor_tongue), new ItemStack(Items.mushroom_stew), new ItemStack(Items.bowl));

	}

	private static void removeRecipes() {
		if (Configs.disableEnchantedGoldenAppleRecipe) {
			removeFirstRecipeFor(Items.golden_apple, 1);
		}
	}


	private static void register(String name, ItemStack stack, Object... recipe) {
		GameRegistry.addRecipe(stack, recipe);
	}

	private static void registerShapeless(String name, ItemStack stack, Object... recipe) {
		GameRegistry.addShapelessRecipe(stack, recipe);
	}

	private static void removeFirstRecipeFor(Block block) {
		removeFirstRecipeFor(Item.getItemFromBlock(block));
	}

	private static void removeFirstRecipeFor(Item item) {
		removeFirstRecipeFor(item, OreDictionary.WILDCARD_VALUE);
	}

	private static void removeFirstRecipeFor(Item item, int meta) {
		Iterator<IRecipe> iterator = (Iterator<IRecipe>) CraftingManager.getInstance().getRecipeList().iterator();
		while (iterator.hasNext()) {
			IRecipe recipe = iterator.next();
			if (recipe != null) {
				ItemStack stack = recipe.getRecipeOutput();
				if (stack != null && stack.getItem() != null && stack.getItem() == item && (meta == OreDictionary.WILDCARD_VALUE || meta == stack.getItemDamage())) {
					iterator.remove();
					return;
				}
			}
		}
	}



}