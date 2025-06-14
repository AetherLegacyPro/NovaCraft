package com.NovaCraft.config;

import java.io.File;

import com.NovaCraft.NovaCraft;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

public class Configs
{
    public static boolean disableRegularVanillaGen;
    public static boolean disableRegularVanillaOres;
    public static boolean disableCustom;
    public static boolean disableDirt;
    public static boolean disableGravel;
    public static boolean disableCoal;
    public static boolean disableDiamond;
    public static boolean disableGold;
    public static boolean disableIron;
    public static boolean disableLapis;
    public static boolean disableRedstone;
    public static boolean disableNetherQuartz;
    public static boolean disableEmerald;
    public static boolean disableMonsterEgg;
    
    public static boolean enableGrimstone;
    public static boolean enableEndstoneBlobs;
    public static boolean enableFrontierslate;
    public static boolean enableVacuumSand;
    
    public static boolean enableBasal;
    
    public static int[] DeeperCavesBlacklist;
	public static boolean DeeperCavesBlacklistAsWhitelist;
    
    public static boolean enableGrimstoneDiamond;
    public static boolean enableGrimstoneIron;
    public static boolean enableGrimstoneGold;
    public static boolean enableGrimstoneLapis;
    public static boolean enableGrimstoneRedstone;
    public static boolean enableGrimstoneEmerald;
    
    public static boolean enableNullstone;
    public static boolean enableNullstoneDiamond;
    public static boolean enableNullstoneIron;
    public static boolean enableNullstoneGold;
    public static boolean enableNullstoneLapis;
    public static boolean enableNullstoneRedstone;
    public static boolean enableNullstoneEmerald;
    
    public static boolean enableEtherstone;
    public static boolean enableEtherstoneGold;
    public static boolean enableEtherstoneIron;
    public static boolean enableEtherstoneEmerald;
    public static boolean enableEtherstoneCoal;
    
    public static boolean enableMountainOres;
    public static boolean enableExtraEmeraldOreGeneration;    
    public static boolean enableAdditonalDiamondOreGeneration;
    public static boolean enableAdditonalCoalOreGeneration;
    public static boolean enableAdditonalIronOreGeneration;
    public static boolean enableAdditonalGoldOreGeneration;
    public static boolean enableAdditonalRedstoneOreGeneration;
    public static boolean enableAdditonalLapisOreGeneration;
    
    public static boolean enableBrimstoneOre;
    
    public static boolean enableSculkGeneration;
    public static boolean enableSculkGenerationAllBiomes;
    public static boolean enableStalagAndStalacGeneration;
    public static boolean enableMossGeneration;
    public static boolean enableRareCrystalGeneration;
    public static boolean enablePherithiumGeneration;
    public static boolean enablePherithiumOreGeneration;
    public static boolean enableLichenGeneration;
    public static boolean enableGlowLichenGeneration;
    public static boolean enableNovaMushrooomGeneration;
    public static boolean enableYttrlinisteOverworldGeneration;
    
    public static int[] WorldGenDimensionBlacklist;
	public static boolean WorldGenDimensionBlacklistAsWhitelist;
    
    public static boolean enableGlowSquidParticles;
    public static boolean enableEnderLordParticles;
    public static boolean enableWardenParticles;
    public static boolean enableVoidEntityParticles;
    public static boolean enableFireflyParticles;
    public static boolean enableIonizatiorParticles;
    
    public static boolean enableCalciteGeneration;
    public static boolean enableNovaCraftTuffGeneration;
    public static boolean enableDripstoneGeneration;
    public static boolean enableDeepslateOreGeneration;
    public static boolean enableRawOreBlocksStructures;
    public static boolean enableCalciteBrickRecipe;
    public static boolean enableTuffBrickRecipe;
    public static boolean enablePrismarineInStructures;
    
    public static boolean enableBlockOfRawNetheriteRecipe;
    public static boolean enableAlternateAmpJumpPotionRecipe;
    public static boolean enableNetheriteInRecipes;
    public static boolean enableCrystalGolemAura;
    public static boolean enableLuminantLeavesGlow;
    public static boolean enableAncientCityTotem;
    public static boolean enableSculkStoneSpreading;
    
    //Spawning
    public static boolean enableSpawnGlowSquid;
    public static boolean enableSpawnPhantom;
    public static boolean enableSpawnOverworldPhantom;
    public static boolean enableSpawnSlaughter;
    public static boolean enableSpawnDrifter;
    public static boolean enableSpawnSculkDweller;
    public static boolean enableSpawnBlazingCharger;
    public static boolean enableSpawnEnderLord;
    public static boolean enableSpawnEnderAvis;
    public static boolean enableSpawnEnderRay;
    public static boolean enableSpawnIceologer;
    public static boolean enableSpawnVindicator;
    public static boolean enableSpawnVoidEntity;
    public static boolean enableSpawnVoidCube;
    public static boolean enableSpawnNullifier;
    public static boolean enableSpawnGoat;
    public static boolean enableSpawnSculkAbomination;
    public static boolean enableSpawnBlazingSerpent;
    public static boolean enableSpawnPhoenix;
    public static boolean enableSpawnFirefly;
    public static boolean enableSpawnDeepoid;
    public static boolean enableSpawnCaveMonitor;
    public static boolean enableSpawnDeathStalker;
    public static boolean enableSpawnRealityDistorter;
    public static boolean enableSpawnDestituteTentacle;
    public static boolean enableSpawnNitro;
    
    public static boolean enableSpawnFireflyOtherBiomes;
    public static boolean enableNoDespawnFirefly;
    
    public static boolean enableIncreasedVanillaNetherMobSpawn;
    public static boolean enableIncreasedVanillaOverworldMobSpawn;
    
    public static boolean enableWardenBlindness;
    public static boolean enableWardenSlowness;
    public static boolean enableWardenWeakness;
    
    public static boolean enableAetherLegacyDepartureItems;
    public static boolean enableRawDivineral;
    public static boolean enableNovaCraftGloves;
    
    public static boolean enableWeaponsToAllignWithVanilla;
    public static boolean enableHardmode;
    public static boolean enableGlowingObsidian;
    
    public static boolean enableTreasureCratesDropDiamonds;
    public static boolean enableNoSkippingTheNight;
    public static boolean disableEnchantedGoldenAppleRecipe;
    
    public static boolean enableUniqueLegendaryBeaconBeam;
    
    public static boolean enableLuminantTreeGeneration;
    public static boolean enableLacunaTreeGeneration;
    
    public static int vindicatorVillageSpawnRate;
    public static int endIslandSpawnRate;
    public static int destituteIslandSpawnRate;
    public static boolean enableDeepoidFortress;
    public static boolean enableSculkInfestedMineshaft;
    public static boolean enableBlackstoneBricksInNetherStructures;
    public static boolean enableInfestedBastion;
    
    public static boolean enableAncientCity;
    public static boolean disableDarkOakFenceInAncientCity;
    public static boolean disableDeepslateInAncientCity;
    public static boolean disableDeepslateBricksInAncientCity;
    public static boolean disableEtFuturumSoulLanternInAncientCity;
    public static boolean disableCobbledDeepslateInAncientCity;   
    public static boolean disableEtFuturumSoulFireInAncientCity;
    public static boolean disableBlueIceInAncientCity;
    public static boolean disableIronTrapdoorInAncientCity;
    public static boolean disableNetherliciousBasaltInAncientCity;
    public static boolean disableNetherliciousSmoothBasaltInAncientCity;
    public static boolean disableMagmaBlock;
    public static boolean disableChain;
    
    public static final String catAncientCity = "Ancient City Customization";
    public static final String catGeneration = "New generation";
    public static final String catParticles = "New particles";
    public static final String catEtFuturum = "Et Futurum Requiem Options";
    public static final String catMobs = "Mobs";
    public static final String catFirefly = "Firefly";
    public static final String catAetherLegacy = "Aether Legacy Options";
    public static final String catMisc = "Misc";
    public static final String catWarden = "Warden Options";
    public static final String catServer = "Server Options";
    
    public static void loadConfigs(File configFile)
    {
    	NovaCraft.logger.info("Loading configuration...");

        Configuration conf = new Configuration(configFile);
        conf.load();

        Property prop;
        String category = "vanilla";      

        prop = conf.get(category, "disableRegularVanillaGen", true);
        prop.comment = "Disables all \"regular\" vanilla generation. NOTE: This includes Dirt and Gravel pockets inside stone, but not Emeralds in Extreme Hills biomes.";
        disableRegularVanillaGen = prop.getBoolean();

        prop = conf.get(category, "disableRegularVanillaOres", true);
        prop.comment = "Disables \"regular\" vanilla _ore_ generation, not including Nether Quartz. This does not include Emeralds in Extreme Hills biomes, which are not part of the regular ore generation.";
        disableRegularVanillaOres = prop.getBoolean();

        prop = conf.get(category, "disableCustom", false);
        prop.comment = "Disables custom ore generation. NOTE: Very few mods actually use the OreGenEvent.GenerateMinable event though, and this only works with those that do.";
        disableCustom = prop.getBoolean();

        prop = conf.get(category, "disableDirt", false);
        prop.comment = "Disables Dirt pocket generation inside stone.";
        disableDirt = prop.getBoolean() || disableRegularVanillaGen;

        prop = conf.get(category, "disableGravel", false);
        prop.comment = "Disables Gravel pocket generation inside stone.";
        disableGravel = prop.getBoolean() || disableRegularVanillaGen;

        prop = conf.get(category, "disableCoal", false);
        prop.comment = "Disables Coal Ore generation.";
        disableCoal = prop.getBoolean() || disableRegularVanillaOres;

        prop = conf.get(category, "disableDiamond", false);
        prop.comment = "Disables Diamond Ore generation.";
        disableDiamond = prop.getBoolean() || disableRegularVanillaOres;

        prop = conf.get(category, "disableGold", false);
        prop.comment = "Disables Gold Ore generation.";
        disableGold = prop.getBoolean() || disableRegularVanillaOres;

        prop = conf.get(category, "disableIron", false);
        prop.comment = "Disables Iron Ore generation.";
        disableIron = prop.getBoolean() || disableRegularVanillaOres;

        prop = conf.get(category, "disableLapis", false);
        prop.comment = "Disables Lapis Ore generation.";
        disableLapis = prop.getBoolean() || disableRegularVanillaOres;

        prop = conf.get(category, "disableNetherQuartz", false);
        prop.comment = "Disables Nether Quartz Ore generation.";
        disableNetherQuartz = prop.getBoolean();

        prop = conf.get(category, "disableRedstone", false);
        prop.comment = "Disables Redstone Ore generation.";
        disableRedstone = prop.getBoolean() || disableRegularVanillaOres;

        // Special ores, not part of regular ore generation
        prop = conf.get(category, "disableEmerald", false);
        prop.comment = "Disables Emerald Ore generation in Extreme Hills biomes. NOTE: This will be done after chunk population by replacing all Emerald ore with Stone.";
        disableEmerald = prop.getBoolean();

        prop = conf.get(category, "disableMonsterEgg", true);
        prop.comment = "Disables Monster Egg (= Silverfish block) generation in Extreme Hills biomes. NOTE: This will be done after chunk population by replacing all Monster Eggs with Stone.";
        disableMonsterEgg = prop.getBoolean();
        
        //Grimstone Ores              
        enableGrimstoneRedstone = conf.getBoolean("enableGrimstoneRedstone", catGeneration, true, "Enables Grimstone Redstone Ore generation");
        enableGrimstoneLapis = conf.getBoolean("enableGrimstoneLapis", catGeneration, true, "Enables Grimstone Lapis Ore generation");
        enableGrimstoneIron = conf.getBoolean("enableGrimstoneIron", catGeneration, true, "Enables Grimstone Iron Ore generation");
        enableGrimstoneGold = conf.getBoolean("enableGrimstoneGold", catGeneration, true, "Enables Grimstone Gold Ore generation");
        enableGrimstoneDiamond = conf.getBoolean("enableGrimstoneDiamond", catGeneration, true, "Enables Grimstone Diamond Ore generation");
        enableGrimstoneEmerald = conf.getBoolean("enableGrimstoneEmerald", catGeneration, true, "Enables Grimstone Emerald Ore generation");
        
        //Nullstone Ores
        enableNullstoneRedstone = conf.getBoolean("enableNullstoneRedstone", catGeneration, true, "Enables Nullstone Redstone Ore generation");
        enableNullstoneLapis = conf.getBoolean("enableNullstoneLapis", catGeneration, true, "Enables Nullstone Lapis Ore generation");
        enableNullstoneIron = conf.getBoolean("enableNullstoneIron", catGeneration, true, "Enables Nullstone Iron Ore generation");
        enableNullstoneGold = conf.getBoolean("enableNullstoneGold", catGeneration, true, "Enables Nullstone Gold Ore generation");
        enableNullstoneDiamond = conf.getBoolean("enableNullstoneDiamond", catGeneration, true, "Enables Nullstone Diamond Ore generation");
        enableNullstoneEmerald = conf.getBoolean("enableNullstoneEmerald", catGeneration, true, "Enables Nullstone Emerald Ore generation");
        
        //Etherstone Ores
        enableEtherstoneIron = conf.getBoolean("enableEtherstoneIron", catGeneration, true, "Enables Etherstone Iron Ore generation");
        enableEtherstoneGold = conf.getBoolean("enableEtherstoneGold", catGeneration, true, "Enables Etherstone Gold Ore generation");
        enableEtherstoneEmerald = conf.getBoolean("enableEtherstoneEmerald", catGeneration, true, "Enables Etherstone Emerald Ore generation");
        enableEtherstoneCoal = conf.getBoolean("enableEtherstoneCoal", catGeneration, true, "Enables Etherstone Coal Ore generation");
        
        //Ores
        enableBrimstoneOre = conf.getBoolean("enableBrimstoneOre", catGeneration, true, "Enables Brimstone Ore generation");
        
        //Additonal Ore Gen in Caves
        enableAdditonalDiamondOreGeneration = conf.getBoolean("enableAdditonalDiamondOreGeneration", catGeneration, false, "Enables More Diamond Ore to generate within Caves.(Enable if you wants diamonds rarer than vanilla but not as rare as in NovaCraft.)");
        enableAdditonalLapisOreGeneration = conf.getBoolean("enableAdditonalLapisOreGeneration", catGeneration, false, "Enables More Lapis Ore to generate within Caves.(Not sure why you want more lapis but it here if you want more in world gen.)");
        enableAdditonalIronOreGeneration = conf.getBoolean("enableAdditonalIronOreGeneration", catGeneration, true, "Enables More Iron Ore to generate within Caves.");
        enableAdditonalGoldOreGeneration = conf.getBoolean("enableAdditonalGoldOreGeneration", catGeneration, false, "Enables More Gold Ore to generate within Caves.");
        enableAdditonalRedstoneOreGeneration = conf.getBoolean("enableAdditonalRedstoneOreGeneration", catGeneration, false, "Enables More Redstone Ore to generate within Caves.");
        enableAdditonalCoalOreGeneration = conf.getBoolean("enableAdditonalCoalOreGeneration", catGeneration, true, "Enables More Coal Ore to generate within Caves.");
        
        //Random World Gen
        Property WorldGenlistProp = conf.get(catGeneration, "WorldGenDimensionBlacklist", new int[] {0});
        WorldGenlistProp.comment = "The dimensions NovaCraft Flora and Geos should not spawn in.";
		WorldGenDimensionBlacklist = WorldGenlistProp.getIntList();
		WorldGenDimensionBlacklistAsWhitelist = conf.getBoolean("WorldGenDimensionBlacklistAsWhitelist", catGeneration, true, "Treat the NovaCraft Flora and Geos dimension blacklist as a whitelist instead, so NovaCraft Flora and Geos will ONLY generate in those dimensions, instead of excluding those dimensions from generation.");
        
        enableGrimstone = conf.getBoolean("enableGrimstone", catGeneration, true, "Enables Grimstone generation");
        enableEndstoneBlobs = conf.getBoolean("enableEndstoneBlobs", catGeneration, true, "Enables Endstone Blobs to generate throughout the End, if you use HEE or Enderlious this should not be necessary.");
        enableFrontierslate = conf.getBoolean("enableFrontierslate", catGeneration, true, "Enables Frontierslate to generate throughout the End.");
        enableVacuumSand = conf.getBoolean("enableVacuumSand", catGeneration, true, "Enables Vacuum Sand to generate throughout the End.");
        
        Property DeeperCavesWorldGenlistProp = conf.get(catGeneration, "DeeperCavesBlacklist", new int[] {});
        DeeperCavesWorldGenlistProp.comment = "Meant for those who play with the Deeper Caves Mod, Grimstone and Nullstone can Generate from y=8 to y=256.";
        DeeperCavesBlacklist = DeeperCavesWorldGenlistProp.getIntList();
        DeeperCavesBlacklistAsWhitelist = conf.getBoolean("DeeperCavesBlacklistAsWhitelist", catGeneration, true, "Treat the Grimstone and Nullstone Generation dimension blacklist as a whitelist instead, so Grimstone and Nullstone can Generate from y=8 to y=256 and will ONLY generate in those dimensions, instead of excluding those dimensions from generation.");
        
        enableNullstone = conf.getBoolean("enableNullstone", catGeneration, true, "Enables Nullstone generation");
        enableEtherstone = conf.getBoolean("enableEtherstone", catGeneration, true, "Enables Etherstone generation");
        enableBasal = conf.getBoolean("enableBasal", catGeneration, true, "Enables Basal generation");
        
        enableMountainOres = conf.getBoolean("enableMountainOres", catGeneration, true, "Enables Coal, Iron, Gold, and Emerald generating above y = 90.");
        enableExtraEmeraldOreGeneration = conf.getBoolean("enableExtraEmeraldOreGeneration", catGeneration, true, "Enables Emerald Ore to rarely generate in all biomes from y = 0 to y = 90");
        enableSculkGeneration = conf.getBoolean("enableSculkGeneration", catGeneration, true, "Enables Sculk and it's variations to generate outside sculk geos/dungeons.");
        enableSculkGenerationAllBiomes = conf.getBoolean("enableSculkGenerationAllBiomes", catGeneration, true, "Enables Sculk and it's variations to generate outside sculk geos/dungeons in all overworld biomes.");
        enableStalagAndStalacGeneration = conf.getBoolean("enableStalagAndStalacGeneration", catGeneration, true, "Enables Stalagmites and Stalactites in world generation.");
        enableRareCrystalGeneration = conf.getBoolean("enableRareCrystalGeneration", catGeneration, false, "Enables the various crystals to very rarely generate in caves outside their geos -> for modpacks with insane cave generation due to lack of spawning spaces.");
        enableMossGeneration = conf.getBoolean("enableMossGeneration", catGeneration, true, "Enables moss blocks and carpets to generate on the surface and in caves close to the surface.");
        enablePherithiumGeneration = conf.getBoolean("enablePherithiumGeneration", catGeneration, true, "Enables pherithium stalagmites and stalagtites generation.");
        enablePherithiumOreGeneration = conf.getBoolean("enablePherithiumOreGeneration", catGeneration, false, "Enables pherithium ore to generate, by default it is set to false.");
        enableLichenGeneration = conf.getBoolean("enableLichenGeneration", catGeneration, true, "Enables Dark and Grim lichen generation.");
        enableGlowLichenGeneration = conf.getBoolean("enableGlowLichenGeneration", catGeneration, true, "Enables Glow lichen generation.");
        enableNovaMushrooomGeneration = conf.getBoolean("enableNovaMushrooomGeneration", catGeneration, true, "Enables all the new types of mushrooms to generate.");
        enableYttrlinisteOverworldGeneration = conf.getBoolean("enableYttrlinisteOverworldGeneration", catGeneration, false, "Enables Yttrlinsite Geos to generate in the Overworld instead of only in the Nether.");
        enableLacunaTreeGeneration = conf.getBoolean("enableLacunaTreeGeneration", catGeneration, true, "Enables Lacuna Trees Generating In the End(May crash when generating with Neodymium; fix unknown).");
      
        enableLuminantTreeGeneration = conf.getBoolean("enableLuminantTreeGeneration", catGeneration, true, "Enables luminant tree generation.");
        vindicatorVillageSpawnRate = conf.get("Spawn Rate - Vindicator Villages", catGeneration, 25).getInt();
        enableDeepoidFortress = conf.getBoolean("enableDeepoidFortress", catGeneration, true, "Enables Deepoid Fortress Generation in the Nether.");
        enableSculkInfestedMineshaft = conf.getBoolean("enableSculkInfestedMineshaft", catGeneration, true, "Enables Sculk Infested Mineshafts to generate within Mountain Type Biomes.");
        endIslandSpawnRate = conf.get("Spawn Rate - End Islands", catGeneration, 121).getInt();
        destituteIslandSpawnRate = conf.get("Spawn Rate - Destitute Islands", catGeneration, 300).getInt();
        
        enableBlackstoneBricksInNetherStructures = conf.getBoolean("enableBlackstoneBricksInNetherStructures", catGeneration, true, "Use Blackstone Bricks from Netherlicious instead use Nullstone Bricks.");
        enableInfestedBastion = conf.getBoolean("enableInfestedBastion", catGeneration, true, "Enables infested bastion to generate in the Nether.");
        
        //Particles
        enableGlowSquidParticles = conf.getBoolean("enableGlowSquidParticles", catParticles, true, "Enables Glow Squid Particles(Causing the log to freak out if Dragon API is installed)");
        enableEnderLordParticles = conf.getBoolean("enableEnderLordParticles", catParticles, true, "Enables Ender Lord Particles(Causing the log to freak out if Dragon API is installed)");
        enableWardenParticles = conf.getBoolean("enableWardenParticles", catParticles, true, "Enables Warden Particles(Causing the log to freak out if Dragon API is installed)");
        enableVoidEntityParticles = conf.getBoolean("enableVoidEntityParticles", catParticles, true, "Enables Void Entity Particles(Causing the log to freak out if Dragon API is installed)");
        enableFireflyParticles = conf.getBoolean("enableFireflyParticles", catParticles, true, "Enables FireFly Particles");
        enableIonizatiorParticles = conf.getBoolean("enableIonizatiorParticles", catParticles, true, "Enables Ionizatior Particles");

        
        //Et Futurum Options
        enableCalciteGeneration = conf.getBoolean("enableCalciteGeneration", catEtFuturum, true, "Enables Calcite from Et Futurum to generate from y=70 to y=100.");
        enableNovaCraftTuffGeneration = conf.getBoolean("enableNovaCraftTuffGeneration", catEtFuturum, false, "Enables Tuff Generation from Et Futurum to generate from y=25 to y=45, instead of at lower y levels.(Disable the Tuff generation in Et Futurum before setting this to true.)");
        enableDeepslateOreGeneration = conf.getBoolean("enableDeepslateOreGeneration", catEtFuturum, false, "Enables Klangite, Tophinite, & Vanite to generate within deepslate from Et Futurum Requiem instead within stone and has a deepslate texture to compensate for it.");
        enableRawOreBlocksStructures = conf.getBoolean("enableRawOreBlocksStructures", catEtFuturum, true, "Enables Raw Copper, Iron, and Gold Blocks from Et Futurum Requiem to generate instead of Iron and Gold Ore Blocks in Sculk Infested Mineshafts.");
        enableCalciteBrickRecipe = conf.getBoolean("enableCalciteBrickRecipe", catEtFuturum, true, "Enables the recipe for Calcite Bricks: DISABLE if calcite is disabled in Et Futurum Requiem.");
        enableTuffBrickRecipe = conf.getBoolean("enableTuffBrickRecipe", catEtFuturum, true, "Enables the recipe for Tuff Bricks: DISABLE if calcite is disabled in Et Futurum Requiem.");
        enablePrismarineInStructures = conf.getBoolean("enablePrismarineInStructures", catEtFuturum, true, "Enables the use of Prismarine in structures: DISABLE if prismarine is disabled in Et Futurum Requiem.");
        
        enableBlockOfRawNetheriteRecipe = conf.getBoolean("enableBlockOfRawNetheriteRecipe", catEtFuturum, true, "Enables the crafting recipe of Blocks of Raw Netherite.(DISABLE if you disabled Netherite in Et Futurum Requiem)");
        enableAlternateAmpJumpPotionRecipe = conf.getBoolean("enableAlternateAmpJumpPotionRecipe", catEtFuturum, true, "Changes Recipe of the extended jump potion to require rabbit foot from Et Futurum.(DISABLE if you disabled rabbits/rabbit foot in Et Futurum Requiem)");
        enableNetheriteInRecipes = conf.getBoolean("enableNetheriteInRecipes", catEtFuturum, true, "Changes Various Recipes to require netherite in their recipes from Et Futurum.(DISABLE if you disabled netherite in Et Futurum Requiem)");
        
        //Ancient City Options
        enableAncientCity = conf.getBoolean("enableAncientCity", catAncientCity, true, "Enables Ancient Cities to start generating 5k from spawn.");
        disableDarkOakFenceInAncientCity = conf.getBoolean("disableDarkOakFenceInAncientCity", catAncientCity, false, "Do not use Dark Oak Fence from Et Futurum Requiem instead use regular Fences in The Ancient City.");
        disableCobbledDeepslateInAncientCity = conf.getBoolean("disableCobbledDeepslateInAncientCity", catAncientCity, false, "Do not use Cobbled Deepslate from Et Futurum Requiem instead use Cobbled Grimstone in The Ancient City.");
        disableDeepslateInAncientCity = conf.getBoolean("disableDeepslateInAncientCity", catAncientCity, false, "Do not use Deepslate from Et Futurum Requiem instead use Grimstone Blocks in The Ancient City.");
        disableDeepslateBricksInAncientCity = conf.getBoolean("disableDeepslateBricksInAncientCity", catAncientCity, false, "Do not use Deepslate Bricks and building blocks from Et Futurum Requiem instead use Grimstone Bricks in The Ancient City.");       
        disableEtFuturumSoulLanternInAncientCity = conf.getBoolean("disableEtFuturumSoulLanternInAncientCity", catAncientCity, false, "Do not use Et Futurum Requiem soul lanterns and instead use the ones from Netherlicious, if those do not exist then there will be nothing.");        
        disableEtFuturumSoulFireInAncientCity = conf.getBoolean("disableEtFuturumSoulFireInAncientCity", catAncientCity, false, "Do not use Et Futurum Requiem soul fire and instead use the ones from Netherlicious, if those do not exist then use Deepfire.");
        disableBlueIceInAncientCity = conf.getBoolean("disableBlueIceInAncientCity", catAncientCity, false, "Do not use Blue Ice from Et Futurum Requiem instead use Packed Ice in The Ancient City.");
        disableIronTrapdoorInAncientCity = conf.getBoolean("disableIronTrapdoorInAncientCity", catAncientCity, false, "Do not use Iron Trapdoor from Et Futurum Requiem instead use regular trapdoor in The Ancient City.");
        disableNetherliciousBasaltInAncientCity = conf.getBoolean("disableNetherliciousBasaltInAncientCity", catAncientCity, true, "Do not use Netherlicious basalt and instead use the one from Et Futurum Requiem, if those do not exist then use Polished Vanite Bricks.");
        disableNetherliciousSmoothBasaltInAncientCity = conf.getBoolean("disableNetherliciousSmoothBasaltInAncientCity", catAncientCity, true, "Do not use Netherlicious smooth basalt and instead use the one from Et Futurum Requiem, if those do not exist then use Polished Vanite Bricks.");
        disableMagmaBlock = conf.getBoolean("disableMagmaBlock", catEtFuturum, false, "Enables the use of Magma Block in structures: DISABLE if magma blocks are disabled in Et Futurum Requiem.");
        disableChain = conf.getBoolean("disableChain", catEtFuturum, false, "Enables the use of Chains in structures: DISABLE if chains are disabled in Et Futurum Requiem.");

        
        //Mobs
        enableSpawnGlowSquid = conf.getBoolean("enableSpawnGlowSquid", catMobs, true, "Enables the Spawning of Glow Squids");
        enableSpawnPhantom = conf.getBoolean("enableSpawnPhantom", catMobs, true, "Enables the Spawning of Phantoms");
        enableSpawnOverworldPhantom = conf.getBoolean("enableSpawnOverworldPhantom", catMobs, false, "Enables the Spawning of Phantoms in the Mountain Biomes");
        enableSpawnSlaughter = conf.getBoolean("enableSpawnSlaughter", catMobs, true, "Enables the Spawning of Slaughters");
        enableSpawnSculkDweller = conf.getBoolean("enableSpawnSculkDweller", catMobs, true, "Enables the Spawning of Sculk Dweller");
        enableSpawnDrifter = conf.getBoolean("enableSpawnDrifter", catMobs, true, "Enables the Spawning of Drifters");
        enableSpawnBlazingCharger = conf.getBoolean("enableSpawnBlazingCharger", catMobs, true, "Enables the Spawning of Blazing Chargers");
        enableSpawnEnderLord = conf.getBoolean("enableSpawnEnderLord", catMobs, true, "Enables the Spawning of Enderlords");
        enableSpawnEnderAvis = conf.getBoolean("enableSpawnEnderAvis", catMobs, true, "Enables the Spawning of Ender Avis");
        enableSpawnEnderRay = conf.getBoolean("enableSpawnEnderRay", catMobs, true, "Enables the Spawning of Ender Rays");
        enableSpawnIceologer = conf.getBoolean("enableSpawnIceologer", catMobs, true, "Enables the Spawning of Iceologer");
        enableSpawnVindicator = conf.getBoolean("enableSpawnVindicator", catMobs, true, "Enables the Spawning of Vindicator");
        enableSpawnVoidEntity = conf.getBoolean("enableSpawnVoidEntity", catMobs, true, "Enables the Spawning of Void Entity");
        enableSpawnVoidCube = conf.getBoolean("enableSpawnVoidCube", catMobs, true, "Enables the Spawning of Void Cube");
        enableSpawnNullifier = conf.getBoolean("enableSpawnNullifier", catMobs, true, "Enables the Spawning of Nullifier");
        enableSpawnGoat = conf.getBoolean("enableSpawnGoat", catMobs, true, "Enables the Spawning of 1.17 Goat");
        enableSpawnBlazingSerpent = conf.getBoolean("enableSpawnBlazingSerpent", catMobs, true, "Enables the Spawning of Blazing Serpent");
        enableSpawnSculkAbomination = conf.getBoolean("enableSpawnSculkAbomination", catMobs, true, "Enables the Spawning of the Sculk Abomination");
        enableSpawnPhoenix = conf.getBoolean("enableSpawnPhoenix", catMobs, true, "Enables the Spawning of the Phoenix");
        enableSpawnFirefly = conf.getBoolean("enableSpawnFirefly", catMobs, true, "Enables the Spawning of the Firefly");
        enableSpawnDeepoid = conf.getBoolean("enableSpawnDeepoid", catMobs, true, "Enables the Spawning of the Deepoid");
        enableSpawnCaveMonitor = conf.getBoolean("enableSpawnCaveMonitor", catMobs, true, "Enables the Spawning of the Cave Monitor");
        enableSpawnDeathStalker = conf.getBoolean("enableSpawnDeathStalker", catMobs, true, "Enables the Spawning of the Death Stalker");
        enableSpawnRealityDistorter = conf.getBoolean("enableSpawnRealityDistorter", catMobs, true, "Enables the Spawning of the Reality Distorter");
        enableSpawnDestituteTentacle = conf.getBoolean("enableSpawnDestituteTentacle", catMobs, true, "Enables the Spawning of the Destitute Tentacle");
        enableSpawnNitro = conf.getBoolean("enableSpawnNitro", catMobs, true, "Enables the Spawning of the Nitro");

        enableIncreasedVanillaNetherMobSpawn = conf.getBoolean("enableIncreasedVanillaNetherMobSpawn", catMobs, true, "Enables increased spawning of Zombie Pigmen, Magma Cubes, and Ghasts in all Nether Biomes");
        enableIncreasedVanillaOverworldMobSpawn = conf.getBoolean("enableIncreasedVanillaOverworldMobSpawn", catMobs, true, "Enables increased spawning of Skeletons, Creepers, Zombies, and Witches.");

        //FireFly Options
        enableSpawnFireflyOtherBiomes = conf.getBoolean("enableSpawnFireflyOtherBiomes", catFirefly, false, "Enables the Spawning of the Firefly in biomes with Plains or Forest tags.");
        enableNoDespawnFirefly = conf.getBoolean("enableNoDespawnFirefly", catFirefly, false, "Disables the despawning of Fireflies after a certian amount of time; they still despawn natually though.");
        
        //Aether Legacy Options
        enableAetherLegacyDepartureItems = conf.getBoolean("enableAetherLegacyDepartureItems", catAetherLegacy, false, "Enables crates to drop of items from my custom fork of Aether Legacy Departure.");
        enableRawDivineral = conf.getBoolean("enableRawDivineral", catAetherLegacy, false, "Enables the Raw Divineral Block.");
        enableNovaCraftGloves = conf.getBoolean("enableNovaCraftGloves", catAetherLegacy, false, "Enables the recipe for NovaCraft gloves from Aether Departure.");
        
        //Misc
        enableWeaponsToAllignWithVanilla = conf.getBoolean("enableWeaponsToAllignWithVanilla", catMisc, true, "Enables weapons from novacraft to allign with vanilla in terms of damage/durability more rather than other RPG like mods.");       
        enableTreasureCratesDropDiamonds = conf.getBoolean("enableTreasureCratesDropDiamonds", catMisc, true, "Enables diamonds in novacraft loot tables");
        enableCrystalGolemAura = conf.getBoolean("enableCrystalGolemAura", catMisc, true, "Enables the auras of the various crystal golems.");
        enableLuminantLeavesGlow = conf.getBoolean("enableLuminantLeavesGlow", catMisc, true, "Enables luminant leaves to have a slight glow effect.(Disable this if you use dynamic leaves)");
        enableAncientCityTotem = conf.getBoolean("enableAncientCityTotem", catMisc, true, "Enables crafting recipe for Ancient City Totem");
        enableSculkStoneSpreading = conf.getBoolean("enableSculkStoneSpreading", catMisc, false, "Enables sculk stone to spread to nearby stone type blocks like grass.");       
        enableNoSkippingTheNight = conf.getBoolean("enableNoSkippingTheNight", catMisc, true, "Beds will only set the player's spawnpoint and will not allow them to skip the night.");
        enableHardmode = conf.getBoolean("enableHardmode", catMisc, false, "Enables Hardmode");
        disableEnchantedGoldenAppleRecipe = conf.getBoolean("disableEnchantedGoldenAppleRecipe", catMisc, true, "Disables recipe for Enchanted Golden Apples.");
        enableGlowingObsidian = conf.getBoolean("enableGlowingObsidian", catMisc, true, "Obsidian Blocks that are directly above a lava source block convert to Glowing Obsidian.");

        //Warden Options
        enableWardenBlindness = conf.getBoolean("enableWardenBlindness", catWarden, true, "Enables the Warden Applying blindess to the player when within 5 Blocks: Note if False the Player will be given Slowness II Instead");
        enableWardenSlowness = conf.getBoolean("enableWardenSlowness", catWarden, true, "Enables the Warden Applying slowness II to the player when within 5 Blocks");
        enableWardenWeakness = conf.getBoolean("enableWardenWeakness", catWarden, false, "Enables the Warden Applying weakness I to the player when within 5 Blocks");
        
        enableUniqueLegendaryBeaconBeam = conf.getBoolean("enableUniqueLegendaryBeaconBeam", catServer, false, "Enables a unique beacon beam for the legendary beacon.");
        
        if (conf.hasChanged() == true)
        {
            conf.save();
        }              
          
    }
    
}

