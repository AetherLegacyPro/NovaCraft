package com.NovaCraft.config;

import com.NovaCraft.NovaCraft;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

import java.io.File;

public class ConfigsCompact {

    //Aether Legacy
    public static boolean enableAetherLegacyCompact;
    public static boolean enableRawDivineral;
    public static boolean enableNovaCraftGloves;

    //Et Futurum Requiem
    public static boolean enableCalciteGeneration;
    public static boolean enableCalciteBrickRecipe;
    public static boolean enableNovaCraftTuffGeneration;
    public static boolean enableTuffBrickRecipe;
    public static boolean enableBanners;
    public static boolean enableBlueIce;
    public static boolean enableIronTrapdoor;
    public static boolean enableIronNugget;
    public static boolean enablePrismarine;
    public static boolean enableDeepslateOreGeneration;
    public static boolean enableRawOreBlocks;
    public static boolean enableBlockOfRawNetheriteRecipe;
    public static boolean enableNetheriteInRecipes;
    public static boolean enableAlternateAmpJumpPotionRecipe;
    public static boolean enableDarkOakFence;
    public static boolean enableDeepslate;
    public static boolean enableDeepslateBricks;
    public static boolean disableMagmaBlock;
    public static boolean disableChain;
    public static boolean enableSoulFire;
    public static boolean enableSoulLantern;
    public static boolean enableCobbledDeepslate;
    public static boolean disableBasalt;
    public static boolean disableSmoothBasalt;

    //Netherlicious
    public static boolean enableBlackstoneBricks;

    //Deeper Caves Compact
    public static boolean WorldGenDimensionBlacklistAsWhitelist;
    public static int[] DeeperCavesBlacklist;
    public static boolean DeeperCavesBlacklistAsWhitelist;
    public static int[] WorldGenDimensionBlacklist;

    public static final String catTheAetherLegacyCompact = "The Aether Legacy Compact";
    public static final String catDeeperCavesCompact = "Deeper Caves Compact";
    public static final String catEtFuturumRequiem = "Et Futurum Requiem Compact";
    public static final String catNetherlicious = "Netherlicious Compact";

    public static void loadConfigs(File configFile) {
        NovaCraft.logger.info("Loading Compact configuration...");
        Configuration conf = new Configuration(configFile);
        conf.load();

        //Aether Legacy
        enableAetherLegacyCompact = conf.getBoolean("enableAetherLegacyCompact", "The Aether Legacy Compact", false, "Enables Aether Legacy items to drop of items from Crates.");
        enableRawDivineral = conf.getBoolean("enableRawDivineral", "The Aether Legacy Compact", false, "Enables the Raw Divineral Block.");
        enableNovaCraftGloves = conf.getBoolean("enableNovaCraftGloves", "The Aether Legacy Compact", false, "Enables the recipe for NovaCraft gloves in Aether Legacy.");

        //Et Futurum Requiem
        enableCalciteGeneration = conf.getBoolean("enableCalciteGeneration", "Et Futurum Requiem Compact", false, "Enables Calcite from Et Futurum to generate from y=70 to y=100.");
        enableNovaCraftTuffGeneration = conf.getBoolean("enableNovaCraftTuffGeneration", "Et Futurum Requiem Compact", false, "Enables Tuff Generation from Et Futurum to generate from y=25 to y=45, instead of at lower y levels.(Disable the Tuff generation in Et Futurum before setting this to true.)");
        enableCalciteBrickRecipe = conf.getBoolean("enableCalciteBrickRecipe", "Et Futurum Requiem Compact", false, "Enables the recipe for Calcite Bricks: DISABLE if calcite is disabled in Et Futurum Requiem.");
        enableTuffBrickRecipe = conf.getBoolean("enableTuffBrickRecipe", "Et Futurum Requiem Compact", false, "Enables the recipe for Tuff Bricks: DISABLE if calcite is disabled in Et Futurum Requiem.");
        enableBanners = conf.getBoolean("enableBanners", "Et Futurum Requiem Compact", true, "Enables the use of Banners from Et Futurum Requiem in structures.");
        enableBlueIce = conf.getBoolean("enableBlueIce", "Et Futurum Requiem Compact", true, "Enables the use of Blue Ice from Et Futurum Requiem in structures.");
        enableIronTrapdoor = conf.getBoolean("enableIronTrapdoor", "Et Futurum Requiem Compact", true, "Enables the use of Iron Trapdoor from Et Futurum Requiem in structures.");
        enableIronNugget = conf.getBoolean("enableIronNugget", "Et Futurum Requiem Compact", true, "Allows recipes and blocks from NovaCraft to use and drop iron nuggets from Et Futurum Requiem");
        enablePrismarine = conf.getBoolean("enablePrismarine", "Et Futurum Requiem Compact", true, "Enables the use of Prismarine from Et Futurum Requiem in structures.");
        enableDeepslateOreGeneration = conf.getBoolean("enableDeepslateOreGeneration", "Et Futurum Requiem Compact", false, "Enables Vanite to generate within deepslate from Et Futurum Requiem instead within stone and has a deepslate texture to compensate for it.");
        enableRawOreBlocks = conf.getBoolean("enableRawOreBlocks", "Et Futurum Requiem Compact", true, "Enables Raw Copper, Iron, and Gold Blocks from Et Futurum Requiem to generate instead of Iron and Gold Ore Blocks in Sculk Infested Mineshafts.");
        enableBlockOfRawNetheriteRecipe = conf.getBoolean("enableBlockOfRawNetheriteRecipe", "Et Futurum Requiem Compact", true, "Enables the crafting recipe of Blocks of Raw Netherite.");
        enableNetheriteInRecipes = conf.getBoolean("enableNetheriteInRecipes", "Et Futurum Requiem Compact", true, "Enables use of netherite from Et Futurum Requiem in structures and recipes.");
        enableAlternateAmpJumpPotionRecipe = conf.getBoolean("enableAlternateAmpJumpPotionRecipe", "Et Futurum Requiem Compact", true, "Changes Recipe of the extended jump potion to require rabbit foot from Et Futurum.");
        enableDarkOakFence = conf.getBoolean("enableDarkOakFence", "Et Futurum Requiem Compact", true, "Enables the use of Dark Oak Fence from Et Futurum Requiem in structures.");
        enableDeepslate = conf.getBoolean("enableDeepslate", "Et Futurum Requiem Compact", true, "Enables the use of Deepslate from Et Futurum Requiem otherwise use Grimstone.");
        enableDeepslateBricks = conf.getBoolean("enableDeepslateBricks", "Et Futurum Requiem Compact", true, "Enables the use of Deepslate Bricks from Et Futurum Requiem otherwise use Grimstone Bricks.");
        enableCobbledDeepslate = conf.getBoolean("enableCobbledDeepslate", "Et Futurum Requiem Compact", true, "Enables the use of Cobbled Deepslate from Et Futurum Requiem otherwise use Cobbled Grimstone.");
        enableSoulLantern = conf.getBoolean("enableSoulLantern", "Et Futurum Requiem Compact", true, "Do not use Et Futurum Requiem soul lanterns and instead use the ones from Netherlicious, if those do not exist then there will be nothing.");
        disableMagmaBlock = conf.getBoolean("disableMagmaBlock", "Et Futurum Requiem Compact", false, "Disables the use of Magma from Et Futurum Requiem in structures.");
        disableChain = conf.getBoolean("disableChain", "Et Futurum Requiem Compact", false, "Disables the use of Chains from Et Futurum Requiem in structures.");

        //Netherlicious Compact
        enableSoulFire = conf.getBoolean("enableSoulFire", "Netherlicious Compact", true, "Do not use Et Futurum Requiem soul fire and instead use the ones from Netherlicious, if those do not exist then use Deepfire.");
        enableBlackstoneBricks = conf.getBoolean("enableBlackstoneBricks", "Netherlicious Compact", true, "Use Blackstone Bricks from Netherlicious instead use Nullstone Bricks.");
        disableBasalt = conf.getBoolean("disableBasalt", "Netherlicious Compact", true, "Do not use Netherlicious basalt and instead use the one from Et Futurum Requiem, if those do not exist then use Polished Vanite Bricks.");
        disableSmoothBasalt = conf.getBoolean("disableSmoothBasalt", "Netherlicious Compact", true, "Do not use Netherlicious smooth basalt and instead use the one from Et Futurum Requiem, if those do not exist then use Polished Vanite Bricks.");

        //Deeper Caves Compact
        Property WorldGenlistProp = conf.get("Deeper Caves Compact", "WorldGenDimensionBlacklist", new int[]{0});
        WorldGenlistProp.comment = "The dimensions NovaCraft Flora and Geos should not spawn in.";
        WorldGenDimensionBlacklist = WorldGenlistProp.getIntList();
        WorldGenDimensionBlacklistAsWhitelist = conf.getBoolean("WorldGenDimensionBlacklistAsWhitelist", "Deeper Caves Compact", true, "Treat the NovaCraft Flora and Geos dimension blacklist as a whitelist instead, so NovaCraft Flora and Geos will ONLY generate in those dimensions, instead of excluding those dimensions from generation.");

        Property DeeperCavesWorldGenlistProp = conf.get("Deeper Caves Compact", "DeeperCavesBlacklist", new int[0]);
        DeeperCavesWorldGenlistProp.comment = "Meant for those who play with the Deeper Caves Mod, Grimstone and Nullstone can Generate from y=8 to y=256.";
        DeeperCavesBlacklist = DeeperCavesWorldGenlistProp.getIntList();
        DeeperCavesBlacklistAsWhitelist = conf.getBoolean("DeeperCavesBlacklistAsWhitelist", "Deeper Caves Compact", true, "Treat the Grimstone and Nullstone Generation dimension blacklist as a whitelist instead, so Grimstone and Nullstone can Generate from y=8 to y=256 and will ONLY generate in those dimensions, instead of excluding those dimensions from generation.");

        if (conf.hasChanged()) {
            conf.save();
        }
    }
}
