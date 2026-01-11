package com.NovaCraft.config;

import com.NovaCraft.NovaCraft;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigsStructures {

    public static boolean enableAncientCity;
    public static boolean enableInfestedBastion;
    public static boolean enableMansion;
    public static boolean enableDeepoidFortress;
    public static boolean enableSculkInfestedMineshaft;
    public static boolean enableMassiveCraters;
    public static boolean enableCraters;
    public static int vindicatorVillageSpawnRate;
    public static boolean enableLuminantTreeGeneration;
    public static boolean enableLargeLuminantTreeGeneration;
    public static boolean enableLacunaTreeGeneration;
    public static boolean enableVindicatorForestHouseGeneration;
    public static boolean enableOceanDungeonsGeneration;
    public static boolean enableDesertCreeperStatueGeneration;
    public static boolean enableSlimeStatueGeneration;
    public static int endIslandSpawnRate;
    public static int destituteIslandSpawnRate;
    public static boolean enableTraditionalNetherDungeons;
    public static boolean enableBlazingSerpentDungeons;
    public static boolean enableNetherYttrlinisteGeodes;
    public static boolean enableCopartzGeodes;
    public static boolean enableLarimarGeodes;
    public static boolean enableTsavorokiteGeodes;
    public static boolean enableAetherGeodes;
    public static boolean enableYttrlinisteGeodes;
    public static boolean enableTraditionalOverworldDungeons;
    public static boolean enableAdvancedTraditionalOverworldDungeons;
    public static boolean enableVoidTemples;

    public static final String catStructureOverworld = "Overworld Structures";
    public static final String catStructureNether = "Nether Structures";
    public static final String catStructureEnd = "End Structures";

    public static void loadConfigs(File configFile) {
        NovaCraft.logger.info("Loading Structure configuration...");
        Configuration conf = new Configuration(configFile);
        conf.load();

        enableAncientCity = conf.getBoolean("enableAncientCity", "Overworld Structures", true, "Enables Ancient Cities to start generating 5k from spawn.");
        enableMansion = conf.getBoolean("enableMansion", "Overworld Structures", true, "Enables Mansions to start generating 12k from spawn.");
        enableSculkInfestedMineshaft = conf.getBoolean("enableSculkInfestedMineshaft", "Overworld Structures", true, "Enables Sculk Infested Mineshafts generation.");
        enableCraters = conf.getBoolean("enableCraters", "Overworld Structures", true, "Enables small craters in world generation.");
        enableMassiveCraters = conf.getBoolean("enableMassiveCraters", "Overworld Structures", true, "Enables massive craters in world generation.");
        vindicatorVillageSpawnRate = conf.get("Spawn Rate - Vindicator Villages", "Overworld Structures", 25).getInt();
        enableLuminantTreeGeneration = conf.getBoolean("enableLuminantTreeGeneration", "Overworld Structures", true, "Enables luminant tree generation.");
        enableLargeLuminantTreeGeneration = conf.getBoolean("enableLargeLuminantTreeGeneration", "Overworld Structures", true, "Enables large luminant tree generation.");
        enableDesertCreeperStatueGeneration = conf.getBoolean("enableDesertCreeperStatueGeneration", "Overworld Structures", true, "Enables Sandstone Creeper Statue generation.");
        enableSlimeStatueGeneration = conf.getBoolean("enableSlimeStatueGeneration", "Overworld Structures", true, "Enables Stone Slime Statue generation.");
        enableVindicatorForestHouseGeneration = conf.getBoolean("enableVindicatorForestHouseGeneration", "Overworld Structures", true, "Enables random small Vindicator houses in Forests.");
        enableOceanDungeonsGeneration = conf.getBoolean("enableOceanDungeonsGeneration", "Overworld Structures", true, "Enables small dungeons with sea serpent spawners to generate at the bottom of oceans.");
        enableYttrlinisteGeodes = conf.getBoolean("enableYttrlinisteGeodes", "Overworld Structures", false, "Enables Yttrlinsite Geodes to generate in the Overworld.");
        enableCopartzGeodes = conf.getBoolean("enableCopartzGeodes", "Overworld Structures", true, "Enables Copartz Geodes to generate in the Overworld.");
        enableLarimarGeodes = conf.getBoolean("enableLarimarGeodes", "Overworld Structures", true, "Enables Larimar Geodes to generate in the Overworld.");
        enableTsavorokiteGeodes = conf.getBoolean("enableTsavorokiteGeodes", "Overworld Structures", true, "Enables Tsavorokite Geodes to generate in the Overworld.");
        enableAetherGeodes = conf.getBoolean("enableAetherGeodes", "Overworld Structures", true, "Enables Aether Geodes to generate in the Overworld.");
        enableTraditionalOverworldDungeons = conf.getBoolean("enableTraditionalOverworldDungeons", "Overworld Structures", true, "Enables new traditional dungeons to generate in the Overworld.");
        enableAdvancedTraditionalOverworldDungeons = conf.getBoolean("enableAdvancedTraditionalOverworldDungeons", "Overworld Structures", true, "Enables advanced traditional dungeons to generate in the Overworld.");
        enableVoidTemples = conf.getBoolean("enableVoidTemples", "Overworld Structures", true, "Enables Void Temple Generation.");


        enableDeepoidFortress = conf.getBoolean("enableDeepoidFortress", "Nether Structures", true, "Enables Deepoid Fortress Generation in the Nether.");
        enableInfestedBastion = conf.getBoolean("enableInfestedBastion", "Nether Structures", true, "Enables infested bastion to generate in the Nether.");
        enableTraditionalNetherDungeons = conf.getBoolean("enableTraditionalNetherDungeons", "Nether Structures", true, "Enables traditional nether dungeons to generate in the Nether.");
        enableBlazingSerpentDungeons = conf.getBoolean("enableBlazingSerpentDungeons", "Nether Structures", true, "Enables traditional blazing serpent dungeons to generate in the Nether.");
        enableNetherYttrlinisteGeodes = conf.getBoolean("enableNetherYttrlinisteGeodes", "Nether Structures", true, "Enables yttrliniste geodes to generate in the Nether(This is the intended location of them).");


        enableLacunaTreeGeneration = conf.getBoolean("enableLacunaTreeGeneration", "End Structures", true, "Enables Lacuna Trees Generating In the End.");
        endIslandSpawnRate = conf.get("Spawn Rate - End Islands", "End Structures", 121).getInt();
        destituteIslandSpawnRate = conf.get("Spawn Rate - Destitute Islands", "End Structures", 300).getInt();

        if (conf.hasChanged()) {
            conf.save();
        }
    }
}
