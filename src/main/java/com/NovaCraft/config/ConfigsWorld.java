package com.NovaCraft.config;

import com.NovaCraft.NovaCraft;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigsWorld {

    //Vanilla Biome Alterations
    public static boolean enableVanillaBiomeAlterations;
    public static boolean enableVanillaHillBiomeAlterations;
    public static boolean enableVanillaMountainBiomeAlterations;
    public static boolean enablePlainsBiomeAlterations;
    public static boolean enableDesertBiomeAlterations;
    public static boolean enableBeachBiomeAlterations;
    public static boolean enableWaterBiomeAlterations;
    public static boolean enableMiscBiomeAlterations;

    //Grimstone Generation
    public static boolean enableGrimstone;
    public static boolean enableGrimstoneDiamond;
    public static boolean enableGrimstoneIron;
    public static boolean enableGrimstoneGold;
    public static boolean enableGrimstoneLapis;
    public static boolean enableGrimstoneRedstone;
    public static boolean enableGrimstoneEmerald;

    //Nullstone Generation
    public static boolean enableNullstone;
    public static boolean enableNullstoneDiamond;
    public static boolean enableNullstoneIron;
    public static boolean enableNullstoneGold;
    public static boolean enableNullstoneLapis;
    public static boolean enableNullstoneRedstone;
    public static boolean enableNullstoneEmerald;

    //Etherstone Generation
    public static boolean enableEtherstone;
    public static boolean enableEtherstoneGold;
    public static boolean enableEtherstoneIron;
    public static boolean enableEtherstoneEmerald;
    public static boolean enableEtherstoneCoal;

    //Additional Vanilla Ore Generation
    public static boolean enableExtraEmeraldOreGeneration;
    public static boolean enableAdditonalDiamondOreGeneration;
    public static boolean enableAdditonalCoalOreGeneration;
    public static boolean enableAdditonalIronOreGeneration;
    public static boolean enableAdditonalGoldOreGeneration;
    public static boolean enableAdditonalRedstoneOreGeneration;
    public static boolean enableAdditonalLapisOreGeneration;
    public static boolean enableMountainOres;

    public static boolean enableMossGeneration;
    public static boolean enableGlowLichenGeneration;
    public static boolean enableGrimLichenGeneration;
    public static boolean enableDarkLichenGeneration;
    public static boolean enableOverworldMushrooomGeneration;
    public static boolean enableSculkGeneration;
    public static boolean enableSculkGenerationAllBiomes;
    public static boolean enableStalagAndStalacGeneration;
    public static boolean enableIcicleGeneration;
    public static boolean enableOverworldFlowersGeneration;
    public static boolean enableTorchflowerGeneration;
    public static boolean enableDeeprootGeneration;

    public static boolean enableXanciumOre;
    public static boolean enableTophiniteOre;
    public static boolean enableKlangiteOre;
    public static boolean enableCrystallizedEnd;
    public static boolean enableFlamingPitcherGeneration;
    public static boolean enableNetherFlora;
    public static boolean enableEndFlora;

    //New Ore Generation and Decoration
    public static boolean enableBrimstoneOre;
    public static boolean enableVaniteOre;
    public static boolean enablePherithiumGeneration;
    public static boolean enablePherithiumOreGeneration;

    public static boolean enableBasal;
    public static boolean enableEndstoneBlobs;
    public static boolean enableFrontierslate;
    public static boolean enableVacuumSand;

    public static boolean enableRareOverworldKlangiteOre;
    public static boolean enableRareOverworldTophiniteOre;
    public static boolean enableRareCrystalGeneration;

    public static final String catBiomeAlterations = "Biome Alterations";
    public static final String catDecorationOverworld = "Overworld Decoration";
    public static final String catDecorationNether = "Nether Decoration";
    public static final String catDecorationEnd = "End Decoration";

    public static void loadConfigs(File configFile) {
        NovaCraft.logger.info("Loading Structure configuration...");
        Configuration conf = new Configuration(configFile);
        conf.load();

        //Biome Alterations
        enableVanillaBiomeAlterations = conf.getBoolean("enableVanillaBiomeAlterations", "Biome Alterations", true, "Enables height changes and randomness to Vanilla Biomes");
        enableVanillaHillBiomeAlterations = conf.getBoolean("enableVanillaHillBiomeAlterations", "Biome Alterations", true, "Enables hill subtype biome changes: ForestHills, TagiaHills etc");
        enableVanillaMountainBiomeAlterations = conf.getBoolean("enableVanillaMountainBiomeAlterations", "Biome Alterations", true, "Enables extreme hill biome changes: ExtremeHills, ExtremeHillsPlus etc");
        enablePlainsBiomeAlterations = conf.getBoolean("enablePlainsBiomeAlterations", "Biome Alterations", true, "Enables plains and ice plains to be flatter in generation.");
        enableDesertBiomeAlterations = conf.getBoolean("enableDesertBiomeAlterations", "Biome Alterations", true, "Enables deserts to be flatter in generation.");
        enableBeachBiomeAlterations = conf.getBoolean("enableBeachBiomeAlterations", "Biome Alterations", true, "Enables beach biomes to be more pronounce and taller along coastlines.");
        enableWaterBiomeAlterations = conf.getBoolean("enableWaterBiomeAlterations", "Biome Alterations", true, "Enables rivers, swamps, and oceans to be a bit deeper in world generation.");
        enableMiscBiomeAlterations = conf.getBoolean("enableMiscBiomeAlterations", "Biome Alterations", true, "Enables regular biomes to have a slightly higher average height and randomness.");

        //Grimstone
        enableGrimstone = conf.getBoolean("enableGrimstone", "Overworld Decoration", true, "Enables Grimstone generation");
        enableGrimstoneRedstone = conf.getBoolean("enableGrimstoneRedstone", "Overworld Decoration", true, "Enables Grimstone Redstone Ore generation");
        enableGrimstoneLapis = conf.getBoolean("enableGrimstoneLapis", "Overworld Decoration", true, "Enables Grimstone Lapis Ore generation");
        enableGrimstoneIron = conf.getBoolean("enableGrimstoneIron", "Overworld Decoration", true, "Enables Grimstone Iron Ore generation");
        enableGrimstoneGold = conf.getBoolean("enableGrimstoneGold", "Overworld Decoration", true, "Enables Grimstone Gold Ore generation");
        enableGrimstoneDiamond = conf.getBoolean("enableGrimstoneDiamond", "Overworld Decoration", true, "Enables Grimstone Diamond Ore generation");
        enableGrimstoneEmerald = conf.getBoolean("enableGrimstoneEmerald", "Overworld Decoration", true, "Enables Grimstone Emerald Ore generation");

        //Nullstone
        enableNullstone = conf.getBoolean("enableNullstone", "Overworld Decoration", true, "Enables Nullstone generation");
        enableNullstoneRedstone = conf.getBoolean("enableNullstoneRedstone", "Overworld Decoration", true, "Enables Nullstone Redstone Ore generation");
        enableNullstoneLapis = conf.getBoolean("enableNullstoneLapis", "Overworld Decoration", true, "Enables Nullstone Lapis Ore generation");
        enableNullstoneIron = conf.getBoolean("enableNullstoneIron", "Overworld Decoration", true, "Enables Nullstone Iron Ore generation");
        enableNullstoneGold = conf.getBoolean("enableNullstoneGold", "Overworld Decoration", true, "Enables Nullstone Gold Ore generation");
        enableNullstoneDiamond = conf.getBoolean("enableNullstoneDiamond", "Overworld Decoration", true, "Enables Nullstone Diamond Ore generation");
        enableNullstoneEmerald = conf.getBoolean("enableNullstoneEmerald", "Overworld Decoration", true, "Enables Nullstone Emerald Ore generation");

        //Etherstone
        enableEtherstone = conf.getBoolean("enableEtherstone", "Overworld Decoration", true, "Enables Etherstone generation");
        enableEtherstoneIron = conf.getBoolean("enableEtherstoneIron", "Overworld Decoration", true, "Enables Etherstone Iron Ore generation");
        enableEtherstoneGold = conf.getBoolean("enableEtherstoneGold", "Overworld Decoration", true, "Enables Etherstone Gold Ore generation");
        enableEtherstoneEmerald = conf.getBoolean("enableEtherstoneEmerald", "Overworld Decoration", true, "Enables Etherstone Emerald Ore generation");
        enableEtherstoneCoal = conf.getBoolean("enableEtherstoneCoal", "Overworld Decoration", true, "Enables Etherstone Coal Ore generation");

        enableAdditonalDiamondOreGeneration = conf.getBoolean("enableAdditonalDiamondOreGeneration", "Overworld Decoration", false, "Enables More Diamond Ore to generate within Caves.(Enable if you wants diamonds rarer than vanilla but not as rare as in NovaCraft.)");
        enableAdditonalLapisOreGeneration = conf.getBoolean("enableAdditonalLapisOreGeneration", "Overworld Decoration", false, "Enables More Lapis Ore to generate within Caves.(Not sure why you want more lapis but it here if you want more in world gen.)");
        enableAdditonalIronOreGeneration = conf.getBoolean("enableAdditonalIronOreGeneration", "Overworld Decoration", true, "Enables More Iron Ore to generate within Caves.");
        enableAdditonalGoldOreGeneration = conf.getBoolean("enableAdditonalGoldOreGeneration", "Overworld Decoration", false, "Enables More Gold Ore to generate within Caves.");
        enableAdditonalRedstoneOreGeneration = conf.getBoolean("enableAdditonalRedstoneOreGeneration", "Overworld Decoration", false, "Enables More Redstone Ore to generate within Caves.");
        enableAdditonalCoalOreGeneration = conf.getBoolean("enableAdditonalCoalOreGeneration", "Overworld Decoration", true, "Enables More Coal Ore to generate within Caves.");

        enableMountainOres = conf.getBoolean("enableMountainOres", "Overworld Decoration", true, "Enables Coal, Iron, Gold, and Emerald generating above y = 90.");
        enableSculkGeneration = conf.getBoolean("enableSculkGeneration", "Overworld Decoration", true, "Enables Sculk and it's variations to generate outside sculk geos/dungeons.");
        enableSculkGenerationAllBiomes = conf.getBoolean("enableSculkGenerationAllBiomes", "Overworld Decoration", true, "Enables Sculk and it's variations to generate outside sculk geos/dungeons in all overworld biomes.");
        enableGrimLichenGeneration = conf.getBoolean("enableGrimLichenGeneration", "Overworld Decoration", true, "Enables Grim lichen generation.");
        enableGlowLichenGeneration = conf.getBoolean("enableGlowLichenGeneration", "Overworld Decoration", true, "Enables Glow lichen generation.");
        enableDarkLichenGeneration = conf.getBoolean("enableDarkLichenGeneration", "Overworld Decoration", true, "Enables Dark lichen generation.");
        enableStalagAndStalacGeneration = conf.getBoolean("enableStalagAndStalacGeneration", "Overworld Decoration", true, "Enables Stalagmites and Stalactites in world generation.");
        enableMossGeneration = conf.getBoolean("enableMossGeneration", "Overworld Decoration", true, "Enables moss blocks and carpets to generate on the surface and in caves close to the surface.");
        enableOverworldMushrooomGeneration = conf.getBoolean("enableOverworldMushrooomGeneration", "Overworld Decoration", true, "Enables all the new types of mushrooms to generate.");
        enableIcicleGeneration = conf.getBoolean("enableIcicleGeneration", "Overworld Decoration", true, "Enables icicle generation in cold biomes.");
        enableOverworldFlowersGeneration = conf.getBoolean("enableOverworldFlowersGeneration", "Overworld Decoration", true, "Enables surface flowers to generate.");
        enableTorchflowerGeneration = conf.getBoolean("enableTorchflowerGeneration", "Overworld Decoration", true, "Enables Torch Flowers to generate.");
        enableDeeprootGeneration = conf.getBoolean("enableDeeprootGeneration", "Overworld Decoration", true, "Enables Deep Roots to generate.");

        enableExtraEmeraldOreGeneration = conf.getBoolean("enableExtraEmeraldOreGeneration", "Overworld Decoration", true, "Enables Emerald Ore to rarely generate in all biomes from y = 0 to y = 90");
        enableBrimstoneOre = conf.getBoolean("enableBrimstoneOre", "Overworld Decoration", true, "Enables Brimstone Ore generation");
        enableVaniteOre = conf.getBoolean("enableVaniteOre", "Overworld Decoration", true, "Enables Vanite Ore generation");
        enablePherithiumGeneration = conf.getBoolean("enablePherithiumGeneration", "Overworld Decoration", true, "Enables pherithium stalagmites and stalagtites generation.");
        enablePherithiumOreGeneration = conf.getBoolean("enablePherithiumOreGeneration", "Overworld Decoration", false, "Enables pherithium ore to generate, by default it is set to false.");
        enableRareCrystalGeneration = conf.getBoolean("enableRareCrystalGeneration", "Overworld Decoration", false, "Enables the various crystals to very rarely generate in caves outside their geos -> for modpacks with insane cave generation due to lack of spawning spaces.");
        enableRareOverworldKlangiteOre = conf.getBoolean("enableRareOverworldKlangiteOre", "Overworld Decoration", false, "Enables Klangite Ore to also generate in the Overworld.");
        enableRareOverworldTophiniteOre = conf.getBoolean("enableRareOverworldTophiniteOre", "Overworld Decoration", false, "Enables Tophinite Ore to also generate in the Overworld.");

        enableFlamingPitcherGeneration = conf.getBoolean("enableFlamingPitcherGeneration", "Nether Decoration", true, "Enables flaming pitcher plants to generate on lava lakes in the Nether.");
        enableNetherFlora = conf.getBoolean("enableNetherFlora", "Nether Decoration", true, "Enables all the new types of nether mushrooms to generate.");
        enableTophiniteOre = conf.getBoolean("enableTophiniteOre", "Nether Decoration", true, "Enables Tophinite Ore generation");
        enableBasal = conf.getBoolean("enableBasal", "Nether Decoration", true, "Enables Basal generation");

        enableXanciumOre = conf.getBoolean("enableXanciumOre", "End Decoration", true, "Enables Xancium Ore Generation.");
        enableKlangiteOre = conf.getBoolean("enableKlangiteOre", "End Decoration", true, "Enables Klangite Ore Generation.");
        enableCrystallizedEnd = conf.getBoolean("enableCrystallizedEnd", "End Decoration", true, "Enables Crystallized End Generation.");
        enableEndstoneBlobs = conf.getBoolean("enableEndstoneBlobs", "End Decoration", true, "Enables Endstone Blobs to generate throughout the End, if you use HEE or Enderlious this should not be necessary.");
        enableFrontierslate = conf.getBoolean("enableFrontierslate", "End Decoration", true, "Enables Frontierslate to generate throughout the End.");
        enableVacuumSand = conf.getBoolean("enableVacuumSand", "End Decoration", true, "Enables Vacuum Sand to generate throughout the End.");
        enableEndFlora = conf.getBoolean("enableEndFlora", "End Decoration", true, "Enables End Flora to generate throughout the End.");


        if (conf.hasChanged()) {
            conf.save();
        }
    }
}
