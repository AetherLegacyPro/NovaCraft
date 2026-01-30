package com.NovaCraft.config;

import com.NovaCraft.NovaCraft;
import java.io.File;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

public class Configs {
    //Important Options
    public static float gammaAlterations;
    public static boolean enableGammaAlterations;
    public static boolean enableDebugMode;
    public static boolean enableGlowingObsidian;
    public static boolean enableNoSkippingTheNight;
    public static boolean disableEnchantedGoldenAppleRecipe;
    public static boolean enableWeaponsToAllignWithVanilla;
    public static boolean enableHalfNaturalRegenInEnd;

    //Vanilla Ore Generation Alterations
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

    //Particles
    public static boolean enableGlowSquidParticles;
    public static boolean enableEnderLordParticles;
    public static boolean enableWardenParticles;
    public static boolean enableVoidEntityParticles;
    public static boolean enableFireflyParticles;
    public static boolean enableIonizatiorParticles;

    //Misc
    public static boolean enableCrystalGolemAura;
    public static boolean enableLuminantLeavesGlow;
    public static boolean enableAncientCityTotem;
    public static boolean enableSculkStoneSpreading;
    public static boolean enableHardmode;
    public static boolean enableTreasureCratesDropDiamonds;
    public static boolean enableUniqueLegendaryBeaconBeam;
    public static boolean enableWardenBlindness;
    public static boolean enableWardenSlowness;
    public static boolean enableWardenWeakness;
    public static boolean enableWitherBossAlterations;
    public static boolean enableNewCaveSounds;
    public static boolean enableStrongholdAlterations;
    public static boolean enableMaxStrongholdSpawners;
    public static boolean enableCrackedEndPortalFrame;
    public static boolean enableAlternateEndPortalSealentRecipe;

    public static final String catVanillaChanges = "Important Options";
    public static final String catGeneration = "New generation";
    public static final String catParticles = "New particles";

    public static void loadConfigs(File configFile) {
        NovaCraft.logger.info("Loading configuration...");
        Configuration conf = new Configuration(configFile);
        conf.load();
        String category = "vanilla";
        Property prop = conf.get(category, "disableRegularVanillaGen", true);
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
        prop = conf.get(category, "disableEmerald", false);
        prop.comment = "Disables Emerald Ore generation in Extreme Hills biomes. NOTE: This will be done after chunk population by replacing all Emerald ore with Stone.";
        disableEmerald = prop.getBoolean();
        prop = conf.get(category, "disableMonsterEgg", true);
        prop.comment = "Disables Monster Egg (= Silverfish block) generation in Extreme Hills biomes. NOTE: This will be done after chunk population by replacing all Monster Eggs with Stone.";
        disableMonsterEgg = prop.getBoolean();

        //Particles
        enableGlowSquidParticles = conf.getBoolean("enableGlowSquidParticles", "New particles", true, "Enables Glow Squid Particles");
        enableEnderLordParticles = conf.getBoolean("enableEnderLordParticles", "New particles", true, "Enables Ender Lord Particles");
        enableWardenParticles = conf.getBoolean("enableWardenParticles", "New particles", true, "Enables Warden Particles");
        enableVoidEntityParticles = conf.getBoolean("enableVoidEntityParticles", "New particles", true, "Enables Void Entity Particles");
        enableFireflyParticles = conf.getBoolean("enableFireflyParticles", "New particles", true, "Enables FireFly Particles");
        enableIonizatiorParticles = conf.getBoolean("enableIonizatiorParticles", "New particles", true, "Enables Ionizatior Particles");

        //Misc
        enableWeaponsToAllignWithVanilla = conf.getBoolean("enableWeaponsToAllignWithVanilla", "Important Options", true, "Enables weapons from novacraft to allign with vanilla in terms of damage/durability more rather than other RPG like mods.");
        enableTreasureCratesDropDiamonds = conf.getBoolean("enableTreasureCratesDropDiamonds", "Misc", true, "Enables diamonds in novacraft loot tables");
        enableCrystalGolemAura = conf.getBoolean("enableCrystalGolemAura", "Misc", true, "Enables the auras of the various crystal golems.");
        enableWitherBossAlterations = conf.getBoolean("enableWitherBossAlterations", "Misc", true, "Enables the Wither Boss to be more similar to the Bedrock one - makes the fight more difficult.");
        enableLuminantLeavesGlow = conf.getBoolean("enableLuminantLeavesGlow", "Misc", true, "Enables luminant leaves to have a slight glow effect.(Disable this if you use dynamic leaves)");
        enableAncientCityTotem = conf.getBoolean("enableAncientCityTotem", "Misc", true, "Enables crafting recipe for Ancient City Totem");
        enableSculkStoneSpreading = conf.getBoolean("enableSculkStoneSpreading", "Misc", false, "Enables sculk stone to spread to nearby stone type blocks like grass.");
        enableNoSkippingTheNight = conf.getBoolean("enableNoSkippingTheNight", "Important Options", true, "Beds will only set the player's spawnpoint and will not allow them to skip the night.");
        enableHardmode = conf.getBoolean("enableHardmode", "Misc", false, "Enables Hardmode");
        disableEnchantedGoldenAppleRecipe = conf.getBoolean("disableEnchantedGoldenAppleRecipe", "Important Options", true, "Disables recipe for Enchanted Golden Apples.");
        enableGlowingObsidian = conf.getBoolean("enableGlowingObsidian", "Important Options", true, "Obsidian Blocks that are directly above a lava source block convert to Glowing Obsidian.");
        enableUniqueLegendaryBeaconBeam = conf.getBoolean("enableUniqueLegendaryBeaconBeam", "Misc", false, "Enables a unique beacon beam for the legendary beacon.");
        enableWardenBlindness = conf.getBoolean("enableWardenBlindness", "Misc", true, "Enables the Warden Applying blindess to the player when within 5 Blocks: Note if False the Player will be given Slowness II Instead");
        enableWardenSlowness = conf.getBoolean("enableWardenSlowness", "Misc", true, "Enables the Warden Applying slowness II to the player when within 5 Blocks");
        enableWardenWeakness = conf.getBoolean("enableWardenWeakness", "Misc", false, "Enables the Warden Applying weakness I to the player when within 5 Blocks");
        gammaAlterations = (float)conf.get("Gamma Alterations | Range:-1 - 1", "Important Options", 0.0D).getDouble();
        enableGammaAlterations = conf.getBoolean("enableGammaAlterations", "Important Options", true, "Locks the gamma of the game to be whatever is set in gammaAlterations: -0.25 is 25% darker etc");
        enableDebugMode = conf.getBoolean("enableDebugMode", "Important Options", false, "Enables log messages for location of structures generating or if a crash was prevented.");
        enableNewCaveSounds = conf.getBoolean("enableNewCaveSounds", "Important Options", true, "Enables New Cave Sounds.");
        enableHalfNaturalRegenInEnd = conf.getBoolean("enableHalfNaturalRegenInEnd", "Important Options", true, "Enables Half Natural Regeneration speed for the player while in the End.");
        enableStrongholdAlterations = conf.getBoolean("enableStrongholdAlterations", "Important Options", true, "Enables Stronghold Alterations.");
        enableMaxStrongholdSpawners = conf.getBoolean("enableMaxStrongholdSpawners", "Misc", false, "Enables that most rooms in the stronghold have a spawner in them.");
        enableCrackedEndPortalFrame = conf.getBoolean("enableCrackedEndPortalFrame", "Misc", true, "Enables that several end portal frames are cracked and must be repaired in the Stronghold.");
        enableAlternateEndPortalSealentRecipe = conf.getBoolean("enableAlternateEndPortalSealentRecipe", "Misc", false, "Enables a standard crafting recipe for the End Portal Sealent instead of using the vanite cauldron.");


        if (conf.hasChanged()) {
            conf.save();
        }

    }
}

