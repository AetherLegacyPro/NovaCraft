package com.NovaCraft;

import net.minecraft.block.Block;
import net.minecraft.block.Block.SoundType;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.init.Blocks;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenBase.SpawnListEntry;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkProviderGenerate;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraft.world.storage.MapStorage;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.common.BiomeDictionary.Type;

import java.io.File;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Random;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.TileEntity.NovaCraftTileEntities;
import com.NovaCraft.TileEntity.TileEntityLegendaryBeacon;
import com.NovaCraft.achievements.AchievementsNovaCraft;
import com.NovaCraft.achievements.NovaCraftEventHandler;
import com.NovaCraft.config.Configs;
import com.NovaCraft.config.ConfigsMain;
import com.NovaCraft.config.ConfigsTextureOverride;
import com.NovaCraft.entity.EntitiesNovaCraft;
import com.NovaCraft.entity.EntityOutsider;
import com.NovaCraft.entity.EntityOutsiderEye;
import com.NovaCraft.entity.hardmode.EntityHardmodeCreeper;
import com.NovaCraft.entity.hardmode.EntityHardmodeGhast;
import com.NovaCraft.entity.hardmode.EntityHardmodeMagmaCube;
import com.NovaCraft.entity.hardmode.EntityHardmodeSkeleton;
import com.NovaCraft.entity.hardmode.EntityHardmodeSlime;
import com.NovaCraft.entity.hardmode.EntityHardmodeSpider;
import com.NovaCraft.entity.hardmode.EntityHardmodeZombie;
import com.NovaCraft.legendarybeacon.LegendaryBeaconRenderer;
import com.NovaCraft.registry.NovaCraftCreativeTabs;
import com.NovaCraft.registry.NovaCraftFuelHander;
import com.NovaCraft.registry.NovaCraftRegistries;
import com.NovaCraft.sounds.ModSounds;
import com.NovaCraft.world.NCWorldGeneratorVillages;
import com.NovaCraft.world.NCWorldGeneratorDeeperCaves;
import com.NovaCraft.world.NCWorldGeneratorPlants;
import com.NovaCraft.world.NCWorldGeneratorPost;
import com.NovaCraft.world.NCWorldGeneratorPre;
import com.NovaCraft.world.OreGenEventHandler;
import com.NovaCraft.world.PopulateChunkEventHandler;
import com.NovaCraft.world.ancient_city.AncientCityGen;
import com.NovaCraft.world.bastion.treasure.BastionGen;
import com.NovaCraft.world.end.DestitudeIslandWorldGen;
import com.NovaCraft.world.end.EndIslandWorldGen;
import com.NovaCraft.world.end.LivingEnderIslandWorldGen;
import com.NovaCraft.world.end.NCWorldGeneratorEnd;
import com.NovaCraft.world.floating_island.FloatingIslandGen;
import com.NovaCraft.world.nether.NCWorldGeneratorNether;
import com.NovaCraft.world.nether.structure.MapGenNetherBridgeNovaCraft;
import com.NovaCraft.world.nether.structure.NovaNetherBridgeGenerator;
import com.NovaCraft.world.nether.structure.StructureNovaCraftNetherBridgePieces;
import com.NovaCraft.world.sculkshaft.SculkMineshaftGenerator;
import com.NovaCraft.world.sculkshaft.StructureSculkMineshaftPieces;
import com.NovaCraft.world.sculkshaft.StructureSculkMineshaftStart;
import com.NovaCraft.world.structure.NCRavineWorldGen;
import com.NovaCraft.world.structure.WorldGenRavineInjector;
import com.NovaCraftBlocks.NovaCraftBlocks;
import com.NovaCraftBlocks.potion.NovaCraftLiquids;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.ObfuscationReflectionHelper;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLConstructionEvent;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerAboutToStartEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod(modid = NovaCraft.MOD_ID, version = "1.4.3", name = "NovaCraft")
public class NovaCraft
{
    public static final String MOD_ID = "nova_craft";
    public static final String VERSION = "1.4.3";
    public static Random rand;
    private World worldObj;
    
    @Instance(NovaCraft.MOD_ID)
    public static NovaCraft instance;
    
    public static org.apache.logging.log4j.Logger logger;
    
    @SidedProxy(clientSide = "com.NovaCraft.ClientProxy", serverSide = "com.NovaCraft.CommonProxy")
    public static CommonProxy proxy;
    public static SimpleNetworkWrapper networkWrapper;
    
    public CommonProxy guiHandler;
    public static File configFile;

    public NovaCraft() {
        this.guiHandler = new CommonProxy();
    }
    
    @Mod.EventHandler
    public void preInit(final FMLPreInitializationEvent event) {
    	
        event.getModMetadata().autogenerated = false;
        event.getModMetadata().name = EnumChatFormatting.DARK_AQUA + "NovaCraft"+ EnumChatFormatting.DARK_PURPLE;
        event.getModMetadata().version = EnumChatFormatting.BLUE + "1.4";
        event.getModMetadata().credits = EnumChatFormatting.AQUA + " Special thanks to Roadhog360 " + ", Delirus" + " & rrogalski ";
        event.getModMetadata().authorList.add(EnumChatFormatting.BLUE + "Wojak");
        event.getModMetadata().url = EnumChatFormatting.GRAY + "https://www.curseforge.com/minecraft/mc-mods/novacraft";
        event.getModMetadata().description = EnumChatFormatting.GREEN + "A 1.7.10 mod that looks to complement/enhance the base game";
        
        NovaCraft.instance = this;
        
        logger = event.getModLog();
        ConfigsMain.loadConfigs(NovaCraft.configFile = new File(event.getModConfigurationDirectory(), "NovaCraft"));
        NovaCraftOverrideTextures.init();
        
        FMLCommonHandler.instance().bus().register((Object)this);
        
        NovaCraftLiquids.preInit();
        NovaCraftItems.initialization();
    	NovaCraftBlocks.initialization();
    	NovaCraftBlocks.initializeHarvestLevels();
    	
    	if (Configs.enableVanillaBiomeAlterations) {
    	BiomeAlterations.applyTweaks();
    	}
        MinecraftForge.TERRAIN_GEN_BUS.register((Object)this);        
        MinecraftForge.ORE_GEN_BUS.register(new OreGenEventHandler());
        MinecraftForge.EVENT_BUS.register(new PopulateChunkEventHandler());
        
        GameRegistry.registerWorldGenerator((IWorldGenerator)new NCWorldGeneratorPre(), Integer.MAX_VALUE);
        //GameRegistry.registerWorldGenerator((IWorldGenerator)new FloatingIslandGen(), Integer.MAX_VALUE);
        
        if (Configs.enableSculkInfestedMineshaft) {
        GameRegistry.registerWorldGenerator(new SculkMineshaftGenerator(), 0);
        MapGenStructureIO.registerStructure(StructureSculkMineshaftStart.class, "SculkMineshaft");
        StructureSculkMineshaftPieces.registerStructurePieces();
        }
        
        if (Configs.enableDeepoidFortress) {
        GameRegistry.registerWorldGenerator(new NovaNetherBridgeGenerator(), 0);
		MapGenStructureIO.registerStructure(MapGenNetherBridgeNovaCraft.Start.class, "NovaFortress");
		StructureNovaCraftNetherBridgePieces.registerStructureNovaCraftNetherBridgePieces();
        }
        
        if (Configs.enableAncientCity) {
    	GameRegistry.registerWorldGenerator((IWorldGenerator)new AncientCityGen(), Integer.MAX_VALUE);
        }
        
        if (Configs.enableInfestedBastion) {
        GameRegistry.registerWorldGenerator((IWorldGenerator)new BastionGen(), Integer.MAX_VALUE);
        }
        
    }
    
    @EventHandler
	public void init(FMLInitializationEvent event) {
    	if (FMLCommonHandler.instance().getEffectiveSide().isClient() && Configs.enableGammaAlterations) {
    	MinecraftForge.EVENT_BUS.register(new LightningAlterations());
    	}
    	MinecraftForge.EVENT_BUS.register(new WorldGenRavineInjector());
        GameRegistry.registerWorldGenerator((IWorldGenerator)new NCWorldGeneratorVillages(), 0);

    	EntitiesNovaCraft.initialization();
    	EntitiesNovaCraft.addSpawns();
    	NovaCraftCreativeTabs.initialization();
    	NovaCraftRegistries.register();
    	GameRegistry.registerFuelHandler(new NovaCraftFuelHander());
    	AchievementsNovaCraft.initialization();
    	NovaCraftTileEntities.initialization();
    	
    	GameRegistry.registerWorldGenerator((IWorldGenerator)new EndIslandWorldGen(), Integer.MAX_VALUE);
    	//GameRegistry.registerWorldGenerator((IWorldGenerator)new LivingEnderIslandWorldGen(), Integer.MAX_VALUE);
    	GameRegistry.registerWorldGenerator((IWorldGenerator)new DestitudeIslandWorldGen(), Integer.MAX_VALUE);
    	
    	NetworkRegistry.INSTANCE.registerGuiHandler((Object)NovaCraft.instance, (IGuiHandler)new CommonProxy());
    	
    	proxy.init();
    	proxy.registerRenderers();
    	CommonProxy.registerEvent(new NovaCraftClientEvents());
    	CommonProxy.registerEvent(new NovaCraftEventHandler());
  
    }
    
    @EventHandler
	public void postInit(FMLPostInitializationEvent event) {
    	
    	GameRegistry.registerWorldGenerator(NCWorldGeneratorNether.INSTANCE, Integer.MAX_VALUE);
    	GameRegistry.registerWorldGenerator(NCWorldGeneratorEnd.INSTANCE, Integer.MAX_VALUE);
      	GameRegistry.registerWorldGenerator((IWorldGenerator)new NCWorldGeneratorPost(), Integer.MAX_VALUE);
      	GameRegistry.registerWorldGenerator(NCWorldGeneratorPlants.INSTANCE, Integer.MAX_VALUE);
      	GameRegistry.registerWorldGenerator(NCWorldGeneratorDeeperCaves.INSTANCE, Integer.MAX_VALUE);
      	
    }
    
    @EventHandler
    public void serverStarting(FMLServerStartingEvent event) {
        World world = MinecraftServer.getServer().worldServers[0];
        Hardmode data = Hardmode.get(world);

        if (data.getHardmode()) {
            System.out.println("Hardmode is active! Spawning hardmode mobs...");
            registerHardmodeMobs(world);
        }
    }

    
    public void registerHardmodeMobs(World world) {
        for (int i = 0; i < BiomeGenBase.getBiomeGenArray().length; i++) {
            BiomeGenBase biome = BiomeGenBase.getBiomeGenArray()[i];

            if (biome != null && overworldBiome(biome)) {
                EntityRegistry.addSpawn(EntityHardmodeCreeper.class, 12, 3, 12, EnumCreatureType.monster, biome);
                EntityRegistry.addSpawn(EntityHardmodeSpider.class, 10, 4, 10, EnumCreatureType.monster, biome);
                EntityRegistry.addSpawn(EntityHardmodeZombie.class, 15, 5, 15, EnumCreatureType.monster, biome);
                EntityRegistry.addSpawn(EntityHardmodeSkeleton.class, 15, 5, 15, EnumCreatureType.monster, biome);
                EntityRegistry.addSpawn(EntityHardmodeSlime.class, 2, 3, 2, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(Type.SWAMP));
                EntityRegistry.addSpawn(EntityOutsiderEye.class, 2, 2, 2, EnumCreatureType.monster, biome);
                EntityRegistry.addSpawn(EntityOutsider.class, 2, 2, 2, EnumCreatureType.monster, biome);
            }
            
            if (biome != null) {
            EntityRegistry.addSpawn(EntityHardmodeMagmaCube.class, 8, 2, 8, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(Type.NETHER));
            EntityRegistry.addSpawn(EntityHardmodeGhast.class, 10, 1, 10, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(Type.NETHER));
            EntityRegistry.addSpawn(EntityOutsiderEye.class, 2, 2, 2, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(Type.NETHER));
            EntityRegistry.addSpawn(EntityOutsider.class, 2, 2, 2, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(Type.NETHER));
            
            EntityRegistry.addSpawn(EntityOutsiderEye.class, 2, 2, 2, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(Type.END));
            EntityRegistry.addSpawn(EntityOutsider.class, 2, 2, 2, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(Type.END));
            }
        }
        
    }
    
    public static boolean overworldBiome(BiomeGenBase biome) {
	    List<SpawnListEntry> monsterList = ObfuscationReflectionHelper.getPrivateValue(BiomeGenBase.class, biome, "as", "field_76761_J", "spawnableMonsterList");
	    for(SpawnListEntry entity : monsterList) {
	        if(entity.entityClass == EntityZombie.class) return true;
	    }
	    return false;
	}
    
    public static ResourceLocation locate(String location) {
		return new ResourceLocation(MOD_ID, location);
	}
    
    public static String find(String location) {
		return modAddress() + location;
	}
    
    public static String modAddress() {
		return MOD_ID + ":";
	}

}
