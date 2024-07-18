package com.NovaCraft.registry;

import net.minecraft.block.*;
import net.minecraft.item.*;
import cpw.mods.fml.common.registry.*;

public class OtherModBlocks
{
	//Et Futurum Requiem
    public static Block deepslate;
    public static Block cobbled_deepslate;
    public static Block calcite;
    public static Block tuff;
    public static Block wall_sign_dark_oak;
    public static Block dripstone;   
    public static Block ancient_debris;
    public static Block beacon;
    public static Block raw_ore_block;
    public static Block red_netherbrick;
    public static Block red_nether_brick_wall;
    public static Block red_netherbrick_stairs;
    public static Block red_netherbrick_slab;
    public static Block end_bricks;    
    public static Block end_brick_slab;
    public static Block end_brick_stairs;    
    public static Block purpur_block;
    public static Block purpur_slab;
    public static Block purpur_stairs;
    public static Block purpur_pillar;
    public static Block end_rod;
    public static Block chorus_flower;
    public static Block deepslate_bricks;
    public static Block polished_deepslate;
    public static Block deepslate_brick_slab;
    public static Block deepslate_brick_stairs;
    public static Block deepslate_tile_stairs;
    public static Block polished_deepslate_stairs;   
    public static Block deepslate_wall;
    public static Block soul_lantern;
    public static Block fence_dark_oak;
    
    //Netherlicious
    public static Block Nether_Gravel;
    public static Block Blackstone;
    public static Block CryingObsidian;
    public static Block Netherbricks;
    public static Block FoxfireNylium;
    public static Block WarpedNylium;
    public static Block CrimsonNylium;
    public static Block Basalt;
    
    //Aether Legacy
    public static Block enchanted_gravitite;
    public static Block zanite_ore;
    public static Block zanite_block;
    public static Block gravitite_ore;
    
    //My Fork of Aether Legacy
    public static Block arkenium_ore;
    public static Block continuum_ore;
    public static Block continuum_block;
    public static Block arkenium_block;
    public static Block primeval_artifact;
    
    //Divine RPG
    public static Block rupeeOre;
    public static Block rupeeBlock;
    public static Block arlemiteOre;
    public static Block arlemiteBlock;
    public static Block realmiteOre;
    public static Block realmiteBlock;
    
    //Hardcore Ender Expansion
    public static Block endium_ore;
    public static Block endium_block;
    public static Block obsidian_special;
    
    static {
    	OtherModBlocks.deepslate = GameRegistry.findBlock("etfuturum", "deepslate");
    	OtherModBlocks.cobbled_deepslate = GameRegistry.findBlock("etfuturum", "cobbled_deepslate");
    	OtherModBlocks.calcite = GameRegistry.findBlock("etfuturum", "calcite");
    	OtherModBlocks.tuff = GameRegistry.findBlock("etfuturum", "tuff");
    	OtherModBlocks.dripstone = GameRegistry.findBlock("etfuturum", "dripstone");
    	OtherModBlocks.wall_sign_dark_oak = GameRegistry.findBlock("etfuturum", "wall_sign_dark_oak");
    	OtherModBlocks.ancient_debris = GameRegistry.findBlock("etfuturum", "ancient_debris");
    	OtherModBlocks.beacon = GameRegistry.findBlock("etfuturum", "beacon");
    	OtherModBlocks.raw_ore_block = GameRegistry.findBlock("etfuturum", "raw_ore_block");
    	OtherModBlocks.red_netherbrick = GameRegistry.findBlock("etfuturum", "red_netherbrick");
    	OtherModBlocks.red_nether_brick_wall = GameRegistry.findBlock("etfuturum", "red_nether_brick_wall");
    	OtherModBlocks.red_netherbrick_stairs = GameRegistry.findBlock("etfuturum", "red_netherbrick_stairs");
    	OtherModBlocks.red_netherbrick_slab = GameRegistry.findBlock("etfuturum", "red_netherbrick_slab");    	
    	OtherModBlocks.end_bricks = GameRegistry.findBlock("etfuturum", "end_bricks");
    	OtherModBlocks.purpur_block = GameRegistry.findBlock("etfuturum", "purpur_block");
    	OtherModBlocks.purpur_pillar = GameRegistry.findBlock("etfuturum", "purpur_pillar");
    	OtherModBlocks.purpur_slab = GameRegistry.findBlock("etfuturum", "purpur_slab");
    	OtherModBlocks.purpur_stairs = GameRegistry.findBlock("etfuturum", "purpur_stairs");
    	OtherModBlocks.end_rod = GameRegistry.findBlock("etfuturum", "end_rod");   	
    	OtherModBlocks.end_brick_slab = GameRegistry.findBlock("etfuturum", "end_brick_slab");
    	OtherModBlocks.end_brick_stairs = GameRegistry.findBlock("etfuturum", "end_brick_stairs");  	
    	OtherModBlocks.chorus_flower = GameRegistry.findBlock("etfuturum", "chorus_flower");  	
    	OtherModBlocks.deepslate_bricks = GameRegistry.findBlock("etfuturum", "deepslate_bricks");
    	OtherModBlocks.polished_deepslate = GameRegistry.findBlock("etfuturum", "polished_deepslate");
    	OtherModBlocks.deepslate_brick_slab = GameRegistry.findBlock("etfuturum", "deepslate_brick_slab");
    	OtherModBlocks.deepslate_tile_stairs = GameRegistry.findBlock("etfuturum", "deepslate_tile_stairs");
    	OtherModBlocks.polished_deepslate_stairs = GameRegistry.findBlock("etfuturum", "polished_deepslate_stairs");   	
    	OtherModBlocks.deepslate_brick_stairs = GameRegistry.findBlock("etfuturum", "deepslate_brick_stairs"); 	
    	OtherModBlocks.deepslate_wall = GameRegistry.findBlock("etfuturum", "deepslate_wall");
    	OtherModBlocks.soul_lantern = GameRegistry.findBlock("etfuturum", "soul_lantern");    	
    	OtherModBlocks.fence_dark_oak = GameRegistry.findBlock("etfuturum", "fence_dark_oak");
    	
    	OtherModBlocks.Nether_Gravel = GameRegistry.findBlock("netherlicious", "Nether_Gravel");
    	OtherModBlocks.Blackstone = GameRegistry.findBlock("netherlicious", "Blackstone");    	
    	OtherModBlocks.Basalt = GameRegistry.findBlock("netherlicious", "Basalt");
    	OtherModBlocks.FoxfireNylium = GameRegistry.findBlock("netherlicious", "FoxfireNylium");
    	OtherModBlocks.WarpedNylium = GameRegistry.findBlock("netherlicious", "WarpedNylium");
    	OtherModBlocks.CrimsonNylium = GameRegistry.findBlock("netherlicious", "CrimsonNylium");
    	OtherModBlocks.CryingObsidian = GameRegistry.findBlock("netherlicious", "CryingObsidian");
    	
    	OtherModBlocks.enchanted_gravitite = GameRegistry.findBlock("aether_legacy", "enchanted_gravitite");
    	OtherModBlocks.zanite_ore = GameRegistry.findBlock("aether_legacy", "zanite_ore");
    	OtherModBlocks.zanite_block = GameRegistry.findBlock("aether_legacy", "zanite_block");
    	OtherModBlocks.gravitite_ore = GameRegistry.findBlock("aether_legacy", "gravitite_ore");
    	OtherModBlocks.arkenium_ore = GameRegistry.findBlock("aether_legacy", "arkenium_ore");
    	OtherModBlocks.arkenium_block = GameRegistry.findBlock("aether_legacy", "arkenium_block");
    	OtherModBlocks.continuum_ore = GameRegistry.findBlock("aether_legacy", "continuum_ore");
    	OtherModBlocks.continuum_block = GameRegistry.findBlock("aether_legacy", "continuum_block");
    	OtherModBlocks.primeval_artifact = GameRegistry.findBlock("aether_legacy", "primeval_artifact");
    	
    	OtherModBlocks.rupeeOre = GameRegistry.findBlock("divinerpg", "rupeeOre");
    	OtherModBlocks.rupeeBlock = GameRegistry.findBlock("divinerpg", "rupeeBlock");
    	OtherModBlocks.arlemiteOre = GameRegistry.findBlock("divinerpg", "arlemiteOre");
    	OtherModBlocks.arlemiteBlock = GameRegistry.findBlock("divinerpg", "arlemiteBlock");
    	OtherModBlocks.realmiteOre = GameRegistry.findBlock("divinerpg", "realmiteOre");
    	OtherModBlocks.realmiteBlock = GameRegistry.findBlock("divinerpg", "realmiteBlock");
    	
    	OtherModBlocks.endium_ore = GameRegistry.findBlock("HardcoreEnderExpansion", "endium_ore");
    	OtherModBlocks.endium_block = GameRegistry.findBlock("HardcoreEnderExpansion", "endium_block");
    	OtherModBlocks.obsidian_special = GameRegistry.findBlock("HardcoreEnderExpansion", "obsidian_special");
    }
}
