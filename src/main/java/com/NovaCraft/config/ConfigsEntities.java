package com.NovaCraft.config;

import com.NovaCraft.NovaCraft;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigsEntities {

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
    public static boolean enableSpawnWyrmling;
    public static boolean enableSpawnCreepyCube;
    public static boolean enableSpawnCreaking;
    public static boolean enableSpawnCreakinginModdedBiomes;
    public static boolean enableSpawnFrog;
    public static boolean enableSpawnFroginModdedBiomes;
    public static boolean enableSpawnGiantFrog;
    public static boolean enableIncreasedVanillaNetherMobSpawn;
    public static boolean enableIncreasedVanillaOverworldMobSpawn;
    public static boolean enableSpawnHardmodeSlime;
    public static boolean enableSpawnHardmodeSpider;
    public static boolean enableSpawnHardmodeSkeleton;
    public static boolean enableSpawnHardmodeZombie;
    public static boolean enableSpawnHardmodeCreeper;
    public static boolean enableSpawnHardmodeMagmaCube;
    public static boolean enableSpawnHardmodeGhast;
    public static boolean enableSpawnFireflyOtherBiomes;
    public static boolean enableNoDespawnFirefly;
    public static boolean enableSpawnOctoqus;
    public static boolean enableSpawnRelik;

    public static final String catMobs = "Mobs";

    public static void loadConfigs(File configFile) {
        NovaCraft.logger.info("Loading Entity configuration...");
        Configuration conf = new Configuration(configFile);
        conf.load();

        //Mob Spawning
        enableSpawnGlowSquid = conf.getBoolean("enableSpawnGlowSquid", "Mobs", true, "Enables the Spawning of Glow Squids");
        enableSpawnPhantom = conf.getBoolean("enableSpawnPhantom", "Mobs", true, "Enables the Spawning of Phantoms");
        enableSpawnOverworldPhantom = conf.getBoolean("enableSpawnOverworldPhantom", "Mobs", false, "Enables the Spawning of Phantoms in the Mountain Biomes");
        enableSpawnSlaughter = conf.getBoolean("enableSpawnSlaughter", "Mobs", true, "Enables the Spawning of Slaughters");
        enableSpawnSculkDweller = conf.getBoolean("enableSpawnSculkDweller", "Mobs", true, "Enables the Spawning of Sculk Dweller");
        enableSpawnDrifter = conf.getBoolean("enableSpawnDrifter", "Mobs", true, "Enables the Spawning of Drifters");
        enableSpawnBlazingCharger = conf.getBoolean("enableSpawnBlazingCharger", "Mobs", true, "Enables the Spawning of Blazing Chargers");
        enableSpawnEnderLord = conf.getBoolean("enableSpawnEnderLord", "Mobs", true, "Enables the Spawning of Enderlords");
        enableSpawnEnderAvis = conf.getBoolean("enableSpawnEnderAvis", "Mobs", true, "Enables the Spawning of Ender Avis");
        enableSpawnEnderRay = conf.getBoolean("enableSpawnEnderRay", "Mobs", true, "Enables the Spawning of Ender Rays");
        enableSpawnIceologer = conf.getBoolean("enableSpawnIceologer", "Mobs", true, "Enables the Spawning of Iceologer");
        enableSpawnVoidEntity = conf.getBoolean("enableSpawnVoidEntity", "Mobs", true, "Enables the Spawning of Void Entity");
        enableSpawnVoidCube = conf.getBoolean("enableSpawnVoidCube", "Mobs", true, "Enables the Spawning of Void Cube");
        enableSpawnNullifier = conf.getBoolean("enableSpawnNullifier", "Mobs", true, "Enables the Spawning of Nullifier");
        enableSpawnGoat = conf.getBoolean("enableSpawnGoat", "Mobs", true, "Enables the Spawning of 1.17 Goat");
        enableSpawnOctoqus = conf.getBoolean("enableSpawnOctoqus", "Mobs", true, "Enables the Spawning of Octoqus");
        enableSpawnBlazingSerpent = conf.getBoolean("enableSpawnBlazingSerpent", "Mobs", true, "Enables the Spawning of Blazing Serpent");
        enableSpawnSculkAbomination = conf.getBoolean("enableSpawnSculkAbomination", "Mobs", true, "Enables the Spawning of the Sculk Abomination");
        enableSpawnPhoenix = conf.getBoolean("enableSpawnPhoenix", "Mobs", true, "Enables the Spawning of the Phoenix");
        enableSpawnFirefly = conf.getBoolean("enableSpawnFirefly", "Mobs", true, "Enables the Spawning of the Firefly");
        enableSpawnDeepoid = conf.getBoolean("enableSpawnDeepoid", "Mobs", true, "Enables the Spawning of the Deepoid");
        enableSpawnCaveMonitor = conf.getBoolean("enableSpawnCaveMonitor", "Mobs", true, "Enables the Spawning of the Cave Monitor");
        enableSpawnDeathStalker = conf.getBoolean("enableSpawnDeathStalker", "Mobs", true, "Enables the Spawning of the Death Stalker");
        enableSpawnRealityDistorter = conf.getBoolean("enableSpawnRealityDistorter", "Mobs", true, "Enables the Spawning of the Reality Distorter");
        enableSpawnDestituteTentacle = conf.getBoolean("enableSpawnDestituteTentacle", "Mobs", true, "Enables the Spawning of the Destitute Tentacle");
        enableSpawnNitro = conf.getBoolean("enableSpawnNitro", "Mobs", true, "Enables the Spawning of the Nitro");
        enableSpawnCreepyCube = conf.getBoolean("enableSpawnCreepyCube", "Mobs", true, "Enables the Spawning of the Creepy Cube");
        enableSpawnCreaking = conf.getBoolean("enableSpawnCreaking", "Mobs", true, "Enables the Spawning of the Creaking");
        enableSpawnCreakinginModdedBiomes = conf.getBoolean("enableSpawnCreakinginModdedBiomes", "Mobs", false, "Enables the Spawning of the Creaking in Modded Biomes; will spawn all variants at random as it only works with vanilla biomes.");
        enableSpawnFrog = conf.getBoolean("enableSpawnFrog", "Mobs", true, "Enables the Spawning of Frogs");
        enableSpawnFroginModdedBiomes = conf.getBoolean("enableSpawnFroginModdedBiomes", "Mobs", false, "Enables the Spawning of the Frog in Modded Biomes; will spawn all variants at random as it only works with vanilla biomes.");
        enableSpawnGiantFrog = conf.getBoolean("enableSpawnGiantFrog", "Mobs", true, "Enables the Spawning of Giant Frogs");
        enableSpawnHardmodeZombie = conf.getBoolean("enableSpawnHardmodeZombie", "Mobs", true, "Enables the Spawning of Hardmode Zombies once HardMode is enabled.");
        enableSpawnHardmodeSkeleton = conf.getBoolean("enableSpawnHardmodeSkeleton", "Mobs", true, "Enables the Spawning of Hardmode Skeletons once HardMode is enabled.");
        enableSpawnHardmodeCreeper = conf.getBoolean("enableSpawnHardmodeCreeper", "Mobs", true, "Enables the Spawning of Hardmode Creepers once HardMode is enabled.");
        enableSpawnHardmodeSpider = conf.getBoolean("enableSpawnHardmodeSpider", "Mobs", true, "Enables the Spawning of Hardmode Spider once HardMode is enabled.");
        enableSpawnHardmodeMagmaCube = conf.getBoolean("enableSpawnHardmodeMagmaCube", "Mobs", true, "Enables the Spawning of Hardmode MagmaCubes once HardMode is enabled.");
        enableSpawnHardmodeGhast = conf.getBoolean("enableSpawnHardmodeGhast", "Mobs", true, "Enables the Spawning of Hardmode Ghasts once HardMode is enabled.");
        enableSpawnHardmodeSlime = conf.getBoolean("enableSpawnHardmodeSlime", "Mobs", true, "Enables the Spawning of Hardmode Slimes once HardMode is enabled.");
        enableIncreasedVanillaNetherMobSpawn = conf.getBoolean("enableIncreasedVanillaNetherMobSpawn", "Mobs", true, "Enables increased spawning of Zombie Pigmen, Magma Cubes, and Ghasts in all Nether Biomes");
        enableSpawnWyrmling = conf.getBoolean("enableSpawnWyrmling", "Mobs", true, "Enables the Spawning of Wyrmlings.");
        enableSpawnRelik = conf.getBoolean("enableSpawnRelik", "Mobs", true, "Enables the natural spawning of Reliks in Strongholds.");
        enableIncreasedVanillaOverworldMobSpawn = conf.getBoolean("enableIncreasedVanillaOverworldMobSpawn", "Mobs", true, "Enables increased spawning of Skeletons, Creepers, Zombies, and Witches.");
        enableSpawnFireflyOtherBiomes = conf.getBoolean("enableSpawnFireflyOtherBiomes", "Firefly", false, "Enables the Spawning of the Firefly in biomes with Plains or Forest tags.");
        enableNoDespawnFirefly = conf.getBoolean("enableNoDespawnFirefly", "Firefly", false, "Disables the despawning of Fireflies after a certian amount of time; they still despawn natually though.");

        if (conf.hasChanged()) {
            conf.save();
        }
    }
}
