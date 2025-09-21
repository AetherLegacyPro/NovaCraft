package com.NovaCraft.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.NovaCraft.entity.misc.*;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.entity.item.EntityEnderEye;
import net.minecraft.init.Items;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.NovaCraft.Hardmode;
import com.NovaCraft.NovaCraft;
import com.NovaCraft.Items.ItemNovaCraftSpawnEgg;
import com.NovaCraft.config.Configs;
import com.NovaCraft.entity.DeepoidDragon.EntityDeepoidDragon;
import com.NovaCraft.entity.hardmode.EntityHardmodeCreeper;
import com.NovaCraft.entity.hardmode.EntityHardmodeGhast;
import com.NovaCraft.entity.hardmode.EntityHardmodeMagmaCube;
import com.NovaCraft.entity.hardmode.EntityHardmodeSkeleton;
import com.NovaCraft.entity.hardmode.EntityHardmodeSlime;
import com.NovaCraft.entity.hardmode.EntityHardmodeSpider;
import com.NovaCraft.entity.hardmode.EntityHardmodeZombie;
import com.NovaCraft.entity.illager.EntityIllagerChief;
import com.NovaCraft.entity.illager.EntityIllagerTrader;
import com.NovaCraft.entity.illager.EntityVindicator;

import cpw.mods.fml.common.ObfuscationReflectionHelper;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenBase.SpawnListEntry;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;

public class EntitiesNovaCraft {

	public static Map<Class<?>, String> classToStringMapping = new HashMap<Class<?>, String>();

	public static Map<Integer, Class<?>> IDtoClassMapping = new HashMap<Integer, Class<?>>();

	private static Map<Class<?>, Integer> classToIDMapping = new HashMap<Class<?>, Integer>();

	private static Map<String, Integer> stringToIDMapping = new HashMap<String, Integer>();

	private static final Logger logger = LogManager.getLogger();
	
	public static void addSpawns(){
		addEndSpawns();
	}
	
	public static void initialization() {
		
		//Misc
		register(EntityFireProofItemNovaCraft.class, "EntityFireProofItemNovaCraft", 4, 64, 20, true);
		register(EntityRayfireball.class, "ender_rayfireball", 12, 64, 20, true);
		register(EntityBloviatorProjectile.class, "bloviator_projectile", 48, 64, 20, true);
		register(EntityEnderLordStaffProjectile.class, "enderlord_pearl", 15, 64, 20, true);
		register(EntitySculkHornProjectile.class, "sculkhorn_projectile", 17, 64, 20, true);
		register(EntityIceSceptorProjectile.class, "ice_staffprojectile", 20, 64, 20, true);
		register(EntityIceProjectile.class, "ice_projectile", 21, 64, 20, true);
		register(EntityWardenProjectile.class, "warden_projectile", 22, 64, 20, true);
		register(EntityDiamondFirechargeProjectile.class, "diamond_firecharge", 25, 64, 20, true);
		register(EntityVaniteFirechargeProjectile.class, "vanite_firecharge", 26, 64, 20, true);
		register(EntityKlangiteFirechargeProjectile.class, "klangite_firecharge", 27, 64, 20, true);
		register(EntityVaniteTrident.class, "vanite_trident", 32, 64, 20, true);	
		register(EntityFirefly.class, "nova_firefly", 36, 0x17181c, 0xf3ee86);
		register(EntityIonizatiorProjectile.class, "ionizator_projectile", 39, 64, 20, true);
		register(EntityDestituteTentacleProjectile.class, "destitute_projectile", 54, 64, 20, true);
		register(EntitySculkLaser.class, "sculk_laser", 56, 64, 10, true);
		register(EntityPrimevalHornProjectile.class, "primeval_projectile", 58, 64, 20, true);
		register(EntitySculkedMonitorProjectile.class, "sculked_monitor_projectile", 59, 64, 20, true);
		register(KlangiteSwordProjectile.class, "klangite_sword_projectile", 60, 150, 2, true);
		register(EntityEchoEye.class, "echo_eye", 81, 150, 2, true);
		
		//Mobs
		register(EntityPrimedXanciumTNT.class, "XTNT", 0, 64, 20, false);
		register(EntityPrimedPETN.class, "PETN", 1, 64, 20, false);
		register(EntityGlowSquid.class, "glow_squid", 2, 0x32a1a1, 0x4fc2a9);
		register(EntityPhantom.class, "phantom", 3, 0x5061a4, 0xdcd9c0);
		register(EntitySlaughter.class, "slaughter", 5, 0x4b353b, 0x6a2531);
		register(EntitySculkDweller.class, "sculk_dweller", 6, 0x193939, 0x04262a);
		register(EntityDrifter.class, "drifter", 7, 0x600606, 0xe1a581);
		register(EntityBlazingCharger.class, "blazing_charger", 8, 0x740100, 0x8f1f00);
		register(EntityEnderLord.class, "ender_lord", 9, 0x000000, 0xcb1ae0);
		register(EntityEnderAvis.class, "ender_avis", 10, 0x000000, 0xd913d8);
		register(EntityEnderRay.class, "ender_ray", 11, 0x1e0036, 0x9044a8);
		register(EntityVindicator.class, "vindicator", 13, 0x8e9393, 0x45413d);
		register(EntityIceologer.class, "iceologer", 14, 0x7c8484, 0x06445c);
		register(EntitySculkSymbiote.class, "sculk_symbiote", 19, 0x3ea19f, 0x1a4f59);
		register(EntityVoidEntity.class, "void_entity", 23, 0x040404, 0x420b6f);
		register(EntityVoidCube.class, "void_cube", 24, 0x2f2f2f, 0x7600ad);
		register(EntityNullifier.class, "nullifier", 28, 0xcc00fa, 0x090909);
		register(EntityGoat.class, "nova_goat", 29, 0xfafafa, 0xc0ac90);		
		register(EntityIllagerTrader.class, "vindicator_trader", 30, 0x85a1a1, 0x424c4e);
		register(EntityIllagerChief.class, "vindicator_chief", 31, 0x95a1a1, 0x324c4e);
		register(EntitySculkAbomination.class, "sculk_abomination", 33, 0x111b21, 0x31cde8);
		register(EntityBlazingSerpent.class, "blazing_serpent", 34, 0x54141b, 0x7c363d);
		register(EntityPhoenix.class, "nova_phoenix", 35, 0xef2a00, 0xff8805);
		register(EntitySculkHunger.class, "sculk_hunger", 37, 0x052a32, 0x266368);
		register(EntitySculkDuplicator.class, "sculk_duplicator", 38, 0x194d58, 0x3ea19f);
		register(EntityIonizatior.class, "ionizatior", 40, 0x715c88, 0x7400ff);
		register(EntityDeepoid.class, "deepoid", 41, 0x653e6b, 0x694695);
		register(EntityCaveMonitor.class, "cave_monitor", 42, 0x494c64, 0x00418b);
		register(EntitySculkedMonitor.class, "sculked_monitor", 43, 0x7badad, 0x1d4e4e);
		register(EntitySeaSerpent.class, "sea_serpent", 44, 0x123d47, 0x335e69);
		register(EntityCrystalGolem.class, "crystal_golem", 46, 0x3e3e3e, 0xd6d6d6);
		register(EntityDeathStalker.class, "death_stalker", 49, 0x535007, 0x3f3a00);
		register(EntityVargouzite.class, "vargouzite", 50, 0x31415a, 0x5ea4a8);
		register(EntityRealityDistorter.class, "reality_distorter", 51, 0x0d0d0d, 0xc2c2c2);
		register(EntityDestitumite.class, "destitumite", 52, 0x080909, 0x1b1b1b);
		register(EntityDestituteTentacle.class, "destitumite_tentacle", 53, 0x080909, 0x1b2b1c);
		register(EntitySculkIncinerator.class, "sculk_incinerator", 55, 0x4ea19f, 0x2a4f59);
		register(EntityWardenVessel.class, "warden_vessel", 61, 0x022e31, 0x226e95);
		register(EntityNitro.class, "nitro", 62, 0x890009, 0xcb868b);
		register(EntityNulk.class, "nulk", 63, 0x19141a, 0x564d61);
		register(EntityNuxx.class, "nuxx", 64, 0x07051f, 0x3d3347);
		register(EntityOutsiderEye.class, "outsider_eye", 72, 0x0b0710, 0x786f8d);
		register(EntityOutsider.class, "outsider", 73, 0x000100, 0x120e16);
		register(EntitySavageSerpent.class, "savage_serpent", 74, 0x930900, 0xe1952b);
		register(EntityCreepyCube.class, "creepy_cube", 76, 0xbebdcc, 0x010101);
		register(EntityCreaking.class, "creaking", 77, 0x423522, 0x987849);
		register(EntityFrog.class, "nova_frog", 78, 0x2f6b1e, 0x9fa64f);
		register(EntityCrystalSlime.class, "crystal_slime", 79, 0xb6b4c4, 0xeae4ea);
		register(EntitySoloid.class, "soloid", 80, 0x5f322f, 0xd38591);
		register(EntityGiantFrog.class, "giant_frog", 82, 0x3f6b1e, 0x7fa64f);
		
		//Hardmode
		register(EntityHardmodeCreeper.class, "hardmode_creeper", 65, 0x3b313a, 0xd2b5d2);
		register(EntityHardmodeSpider.class, "hardmode_spider", 66, 0x0b0c0c, 0x888585);
		register(EntityHardmodeZombie.class, "hardmode_zombie", 67, 0x3b363a, 0x9f9faf);
		register(EntityHardmodeSkeleton.class, "hardmode_skeleton", 68, 0x918491, 0xcfbcce);
		register(EntityHardmodeSlime.class, "hardmode_slime", 69, 0x8ea070, 0xc8d6b4);
		register(EntityHardmodeMagmaCube.class, "hardmode_magmacube", 70, 0x000000, 0xff3100);
		register(EntityHardmodeGhast.class, "hardmode_ghast", 71, 0xf0c6c6, 0xf9cdcd);
		
		//Bosses
		register(EntityWarden.class, "warden", 16, 0x256166, 0x171b1e);
		register(EntityDeepoidDragon.class, "deepoid_dragon", 45, 0x68395f, 0xd2323a);
		register(EntityBloviator.class, "bloviator", 47, 0x28395f, 0x12323a);
		register(EntityPrisoner.class, "prisoner", 57, 64, 20, true);
		register(EntityBlazingSerpentQueen.class, "serpent_queen", 75, 0x2d0000, 0xff0033);
		
		if (Configs.enableSpawnGlowSquid) {
		EntityRegistry.addSpawn(EntityGlowSquid.class, 10, 1, 3, EnumCreatureType.waterCreature, new BiomeGenBase[] {BiomeGenBase.beach, BiomeGenBase.ocean, BiomeGenBase.deepOcean});
		}
		
		if (Configs.enableSpawnOverworldPhantom) {
		EntityRegistry.addSpawn(EntityPhantom.class, 10, 4, 10, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(Type.MOUNTAIN));
		}
		
		if (Configs.enableSpawnSlaughter) {
		EntityRegistry.addSpawn(EntitySlaughter.class, 7, 4, 7, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(Type.NETHER));
		}
		
		if (Configs.enableSpawnDrifter) {
		EntityRegistry.addSpawn(EntityDrifter.class, 10, 4, 10, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(Type.NETHER));
		}
		
		if (Configs.enableSpawnBlazingCharger) {
		EntityRegistry.addSpawn(EntityBlazingCharger.class, 9, 2, 9, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(Type.NETHER));
		}
		
		if (Configs.enableSpawnIceologer) {
		EntityRegistry.addSpawn(EntityIceologer.class, 2, 2, 2, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(Type.MOUNTAIN));
		}
		
		if (Configs.enableSpawnGoat) {
		EntityRegistry.addSpawn(EntityGoat.class, 4, 3, 4, EnumCreatureType.creature, BiomeDictionary.getBiomesForType(Type.MOUNTAIN));
		}
		
		if (Configs.enableSpawnBlazingSerpent) {
			EntityRegistry.addSpawn(EntityBlazingSerpent.class, 6, 3, 6, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(Type.NETHER));
		}
		
		if (Configs.enableSpawnNitro) {
			EntityRegistry.addSpawn(EntityNitro.class, 6, 3, 6, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(Type.NETHER));
		}
		
		if (Configs.enableSpawnPhoenix) {
			EntityRegistry.addSpawn(EntityPhoenix.class, 10, 4, 10, EnumCreatureType.creature, BiomeDictionary.getBiomesForType(Type.NETHER));
		}
		
		if (Configs.enableSpawnDeepoid) {
			EntityRegistry.addSpawn(EntityDeepoid.class, 15, 2, 15, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(Type.NETHER));
		}
		
		if (Configs.enableSpawnDeathStalker) {
			EntityRegistry.addSpawn(EntityDeathStalker.class, 10, 4, 10, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(Type.SANDY));
		}
		
		if (Configs.enableSpawnCreepyCube) {
			EntityRegistry.addSpawn(EntityCreepyCube.class, 10, 1, 4, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(Type.MOUNTAIN));
		}
		
		if (Configs.enableSpawnCreaking) {
			EntityRegistry.addSpawn(EntityCreaking.class, 5, 1, 2, EnumCreatureType.monster, new BiomeGenBase[] {BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.taiga,
			BiomeGenBase.taigaHills, BiomeGenBase.taiga, BiomeGenBase.megaTaiga, BiomeGenBase.megaTaigaHills, BiomeGenBase.birchForest, BiomeGenBase.birchForestHills, BiomeGenBase.jungle,
			BiomeGenBase.jungleHills, BiomeGenBase.jungleEdge, BiomeGenBase.roofedForest});

			if (Configs.enableSpawnFroginModdedBiomes) {
				EntityRegistry.addSpawn(EntityCreaking.class, 5, 1, 2, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(Type.FOREST));
				EntityRegistry.addSpawn(EntityCreaking.class, 5, 1, 2, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(Type.JUNGLE));
			}
		}
		
		if (Configs.enableSpawnFrog) {
			EntityRegistry.addSpawn(EntityFrog.class, 8, 3, 6, EnumCreatureType.creature, new BiomeGenBase[] {BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.birchForest, BiomeGenBase.birchForestHills, BiomeGenBase.jungle,
			BiomeGenBase.jungleHills, BiomeGenBase.jungleEdge, BiomeGenBase.swampland, BiomeGenBase.river});
			
			if (Configs.enableSpawnFroginModdedBiomes) {
				EntityRegistry.addSpawn(EntityCreaking.class, 8, 3, 6, EnumCreatureType.creature, BiomeDictionary.getBiomesForType(Type.FOREST));
				EntityRegistry.addSpawn(EntityCreaking.class, 8, 3, 6, EnumCreatureType.creature, BiomeDictionary.getBiomesForType(Type.SWAMP));
				EntityRegistry.addSpawn(EntityCreaking.class, 8, 3, 6, EnumCreatureType.creature, BiomeDictionary.getBiomesForType(Type.JUNGLE));
			 }
			}
		
		if (Configs.enableSpawnFirefly) {
			EntityRegistry.addSpawn(EntityFirefly.class, 2, 4, 2, EnumCreatureType.ambient, BiomeDictionary.getBiomesForType(Type.SWAMP));
		
			if (Configs.enableSpawnFireflyOtherBiomes) {
				EntityRegistry.addSpawn(EntityFirefly.class, 2, 4, 2, EnumCreatureType.ambient, BiomeDictionary.getBiomesForType(Type.PLAINS));
				EntityRegistry.addSpawn(EntityFirefly.class, 2, 4, 2, EnumCreatureType.ambient, BiomeDictionary.getBiomesForType(Type.FOREST));
			}
		}
			
		//Sculk Dweller Spawn Rates
		if (Configs.enableSpawnSculkDweller) {
		EntityRegistry.addSpawn(EntitySculkDweller.class, 40, 2, 40, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(Type.WET));
		EntityRegistry.addSpawn(EntitySculkDweller.class, 40, 2, 40, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(Type.OCEAN));
		EntityRegistry.addSpawn(EntitySculkDweller.class, 40, 2, 40, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(Type.MOUNTAIN));
		
		for (int i = 0; i < BiomeGenBase.getBiomeGenArray().length; i++) {
			BiomeGenBase biome = BiomeGenBase.getBiomeGenArray()[i];
			if (biome != null){
				if (overworldBiome(biome)) {
					EntityRegistry.addSpawn(EntitySculkDweller.class, 20, 2, 20, EnumCreatureType.monster, biome);
						}
					}
				}
		}
		
		//Increases spawnrates of Hostile Nether Mobs
		if (Configs.enableIncreasedVanillaNetherMobSpawn) {
		EntityRegistry.addSpawn(EntityGhast.class, 10, 1, 10, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(Type.NETHER));
		EntityRegistry.addSpawn(EntityPigZombie.class, 9, 2, 9, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(Type.NETHER));
		EntityRegistry.addSpawn(EntityMagmaCube.class, 10, 2, 10, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(Type.NETHER));
		}
		
		if (Configs.enableIncreasedVanillaOverworldMobSpawn) {
		for (int i = 0; i < BiomeGenBase.getBiomeGenArray().length; i++) {
		BiomeGenBase biome = BiomeGenBase.getBiomeGenArray()[i];
		if (biome != null){
			if (overworldBiome(biome)) {
				EntityRegistry.addSpawn(EntityZombie.class, 15, 5, 15, EnumCreatureType.monster, biome);
				EntityRegistry.addSpawn(EntityCreeper.class, 12, 3, 12, EnumCreatureType.monster, biome);
				EntityRegistry.addSpawn(EntitySkeleton.class, 15, 5, 15, EnumCreatureType.monster, biome);
				EntityRegistry.addSpawn(EntitySpider.class, 10, 4, 10, EnumCreatureType.monster, biome);	
		
				EntityRegistry.addSpawn(EntityWitch.class, 1, 1, 1, EnumCreatureType.monster, biome);
					}
				}
			}
		}				
		
		if (Configs.enableSpawnSculkAbomination) {
		for (int i = 0; i < BiomeGenBase.getBiomeGenArray().length; i++) {
			BiomeGenBase biome = BiomeGenBase.getBiomeGenArray()[i];
			if (biome != null){
				if (overworldBiome(biome)) {
					EntityRegistry.addSpawn(EntitySculkAbomination.class, 25, 3, 25, EnumCreatureType.monster, biome);
						}
					}
				}
		}
		if (Configs.enableSpawnCaveMonitor) {
			for (int i = 0; i < BiomeGenBase.getBiomeGenArray().length; i++) {
				BiomeGenBase biome = BiomeGenBase.getBiomeGenArray()[i];
				if (biome != null){
					if (overworldBiome(biome)) {
						EntityRegistry.addSpawn(EntityCaveMonitor.class, 10, 4, 10, EnumCreatureType.monster, biome);
						}
					}
				}
		}
	}
	
	@SubscribeEvent
	public void onSpecialSpawn(LivingSpawnEvent.SpecialSpawn event) {
	    if (!(event.entity instanceof EntityCreaking)) return;

	    EntityCreaking creaking = (EntityCreaking) event.entity;
	    World world = creaking.worldObj;
	    int x = (int) creaking.posX;
	    int y = (int) creaking.posY;
	    int z = (int) creaking.posZ;

	    BiomeGenBase biome = world.getBiomeGenForCoords(x, z);

	    if (biome == BiomeGenBase.forest || biome == BiomeGenBase.forestHills) {
	        creaking.setType(0);
	    } else if (biome == BiomeGenBase.birchForest || biome == BiomeGenBase.birchForestHills) {
	        creaking.setType(1);
	    } else if (biome == BiomeGenBase.taiga || biome == BiomeGenBase.taigaHills || biome == BiomeGenBase.megaTaiga || biome == BiomeGenBase.megaTaigaHills) {
	        creaking.setType(2);
	    } else if (biome == BiomeGenBase.jungle || biome == BiomeGenBase.jungleHills || biome == BiomeGenBase.jungleEdge) {
	        creaking.setType(3);
	    } else if (biome == BiomeGenBase.roofedForest) {
	        creaking.setType(4);
	    } else {
			creaking.setType(0);
		}
	}
	
	public static boolean overworldBiome(BiomeGenBase biome) {
	    List<SpawnListEntry> monsterList = ObfuscationReflectionHelper.getPrivateValue(BiomeGenBase.class, biome, "as", "field_76761_J", "spawnableMonsterList");
	    for(SpawnListEntry entity : monsterList) {
	        if(entity.entityClass == EntityZombie.class) return true;
	    }
	    return false;
	}
	
	public static void addEndSpawns() {
		for (int i = 0; i < BiomeGenBase.getBiomeGenArray().length; i++) {
			BiomeGenBase biome = BiomeGenBase.getBiomeGenArray()[i];
			if (biome != null){
				if (BiomeDictionary.isBiomeOfType(biome, Type.END)) {
					if (Configs.enableSpawnPhantom) {
						EntityRegistry.addSpawn(EntityPhantom.class, 3, 2, 3, EnumCreatureType.monster, biome);
					}
					if (Configs.enableSpawnEnderLord) {
						EntityRegistry.addSpawn(EntityEnderLord.class, 2, 1, 4, EnumCreatureType.monster, biome);
					}					
					if (Configs.enableSpawnEnderAvis) {
						EntityRegistry.addSpawn(EntityEnderAvis.class, 2, 1, 2, EnumCreatureType.creature, biome);
					}						
					if (Configs.enableSpawnEnderRay) {
					    EntityRegistry.addSpawn(EntityEnderRay.class, 1, 1, 1, EnumCreatureType.monster, biome);
					}
					if (Configs.enableSpawnVoidEntity) {
						EntityRegistry.addSpawn(EntityVoidEntity.class, 3, 4, 3, EnumCreatureType.monster, biome);
					}					
					if (Configs.enableSpawnVoidCube) {
						EntityRegistry.addSpawn(EntityVoidCube.class, 6, 3, 6, EnumCreatureType.monster, biome);
					}					
					if (Configs.enableSpawnNullifier) {
						EntityRegistry.addSpawn(EntityNullifier.class, 4, 4, 4, EnumCreatureType.monster, biome);
					}
					if (Configs.enableSpawnRealityDistorter) {
						EntityRegistry.addSpawn(EntityRealityDistorter.class, 4, 4, 4, EnumCreatureType.monster, biome);
					}
					if (Configs.enableSpawnDestituteTentacle) {
						EntityRegistry.addSpawn(EntityDestituteTentacle.class, 3, 4, 4, EnumCreatureType.monster, biome);
					}	
					
				}
			}
		}
	}
	
	public static void register(Class<? extends Entity> entityClass, String entityName, int entityID, int trackingRange, int updateFrequency, boolean sendsVelocityUpdates) {
		EntityRegistry.registerModEntity(entityClass, entityName, entityID, NovaCraft.instance, trackingRange, updateFrequency, sendsVelocityUpdates);
	}

	public static void register(Class<? extends Entity> entityClass, String entityName, int entityID, int primaryEggColor, int secondaryEggColor) {
		addMapping(entityClass, entityName, entityID, primaryEggColor, secondaryEggColor);
		EntityRegistry.registerModEntity(entityClass, entityName, entityID, NovaCraft.instance, 80, 3, true);
	}
	
	private static void addMapping(Class<?> entityClass, String entityName, int entityID, int primaryEggColor, int secondaryEggColor) {
		if (IDtoClassMapping.containsKey(Integer.valueOf(entityID))) {
			throw new IllegalArgumentException("ID is already registered: " + entityID);
		} else {
			classToStringMapping.put(entityClass, entityName);
			IDtoClassMapping.put(Integer.valueOf(entityID), entityClass);
			classToIDMapping.put(entityClass, Integer.valueOf(entityID));
			stringToIDMapping.put(entityName, Integer.valueOf(entityID));
			ItemNovaCraftSpawnEgg.entityEggs.put(Integer.valueOf(entityID), new NovaCraftEggInfo(entityID, primaryEggColor, secondaryEggColor));
		}
	}
	
	public static Entity createEntityByID(int id, World p_75616_1_) {
		Entity entity = null;

		try {
			Class<?> oclass = getClassFromID(id);

			if (oclass != null) {
				entity = (Entity) oclass.getConstructor(new Class[]{World.class}).newInstance(new Object[]{p_75616_1_});
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}

		if (entity == null) {
			logger.warn("Skipping NovaCraft Entity with id " + id);
		}

		return entity;
	}

	public static int getEntityID(Entity p_75619_0_) {
		Class<?> oclass = p_75619_0_.getClass();
		return classToIDMapping.containsKey(oclass) ? ((Integer) classToIDMapping.get(oclass)).intValue() : -1;
	}

	public static Class<?> getClassFromID(int p_90035_0_) {
		return (Class<?>) IDtoClassMapping.get(Integer.valueOf(p_90035_0_));
	}

	public static String getStringFromID(int p_75617_0_) {
		Class<?> oclass = getClassFromID(p_75617_0_);

		return oclass != null ? (String) classToStringMapping.get(oclass) : null;
	}
	
	public static class NovaCraftEggInfo
	{
		public final int spawnedID;
		public final int primaryColor;
		public final int secondaryColor;

		public NovaCraftEggInfo(int spawnedID, int primaryColor, int secondaryColor)
		{
			this.spawnedID = spawnedID;
			this.primaryColor = primaryColor;
			this.secondaryColor = secondaryColor;
		}
	}
}
