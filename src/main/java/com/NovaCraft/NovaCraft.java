package com.NovaCraft;

import net.minecraft.block.Block;
import net.minecraft.block.Block.SoundType;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;

import java.io.File;
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
import com.NovaCraft.legendarybeacon.LegendaryBeaconRenderer;
import com.NovaCraft.registry.NovaCraftCreativeTabs;
import com.NovaCraft.registry.NovaCraftFuelHander;
import com.NovaCraft.registry.NovaCraftRegistries;
import com.NovaCraft.sounds.ModSounds;
import com.NovaCraft.world.NCWorldGenerator;
import com.NovaCraft.world.NCWorldGeneratorPlants;
import com.NovaCraft.world.NCWorldGeneratorPost;
import com.NovaCraft.world.NCWorldGeneratorPre;
import com.NovaCraft.world.OreGenEventHandler;
import com.NovaCraft.world.PopulateChunkEventHandler;
import com.NovaCraft.world.ancient_city.AncientCityGen;
import com.NovaCraft.world.end.DestitudeIslandWorldGen;
import com.NovaCraft.world.end.EndIslandWorldGen;
import com.NovaCraft.world.end.LivingEnderIslandWorldGen;
import com.NovaCraft.world.end.NCWorldGeneratorEnd;
import com.NovaCraft.world.nether.NCWorldGeneratorNether;
import com.NovaCraft.world.nether.structure.MapGenNetherBridgeNovaCraft;
import com.NovaCraft.world.nether.structure.NovaNetherBridgeGenerator;
import com.NovaCraft.world.nether.structure.StructureNovaCraftNetherBridgePieces;
import com.NovaCraft.world.sculkshaft.SculkMineshaftGenerator;
import com.NovaCraft.world.sculkshaft.StructureSculkMineshaftPieces;
import com.NovaCraft.world.sculkshaft.StructureSculkMineshaftStart;
import com.NovaCraftBlocks.NovaCraftBlocks;
import com.NovaCraftBlocks.potion.NovaCraftLiquids;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLConstructionEvent;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerAboutToStartEvent;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod(modid = NovaCraft.MOD_ID, version = "1.3.5", name = "NovaCraft")
public class NovaCraft
{
    public static final String MOD_ID = "nova_craft";
    public static final String VERSION = "1.3.5";
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
        event.getModMetadata().version = EnumChatFormatting.BLUE + "1.3.5";
        event.getModMetadata().credits = EnumChatFormatting.AQUA + " Special thanks to Roadhog360 " + ", Delirus" + " & rrogalski ";
        event.getModMetadata().authorList.add(EnumChatFormatting.BLUE + "Wojak");
        event.getModMetadata().url = EnumChatFormatting.GRAY + "https://www.curseforge.com/minecraft/mc-mods/novacraft";
        event.getModMetadata().description = EnumChatFormatting.GREEN + "A 1.7.10 mod that looks to complement/enhance the base game";
        
        NovaCraft.instance = this;
        
        logger = event.getModLog();
        ConfigsMain.loadConfigs(NovaCraft.configFile = new File(event.getModConfigurationDirectory(), "NovaCraft"));
        NovaCraftOverrideTextures.init();
        
        FMLCommonHandler.instance().bus().register((Object)this);
        MinecraftForge.TERRAIN_GEN_BUS.register((Object)this);
        
        MinecraftForge.ORE_GEN_BUS.register(new OreGenEventHandler());
        MinecraftForge.EVENT_BUS.register(new PopulateChunkEventHandler());
        
        NovaCraftLiquids.preInit();
        GameRegistry.registerWorldGenerator(new NCWorldGeneratorPre(), 0);
        
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
        
        NovaCraftItems.initialization();
    	NovaCraftBlocks.initialization();
    	NovaCraftBlocks.initializeHarvestLevels();
             
    	GameRegistry.registerWorldGenerator((IWorldGenerator)new AncientCityGen(), Integer.MAX_VALUE);
    }
    
    @EventHandler
	public void init(FMLInitializationEvent event) {
    	EntitiesNovaCraft.initialization();
    	EntitiesNovaCraft.addSpawns();
    	NovaCraftCreativeTabs.initialization();
    	NovaCraftRegistries.register();
    	GameRegistry.registerFuelHandler(new NovaCraftFuelHander());
    	AchievementsNovaCraft.initialization();
    	NovaCraftTileEntities.initialization();
    	
    	GameRegistry.registerWorldGenerator((IWorldGenerator)new EndIslandWorldGen(), Integer.MAX_VALUE);
    	GameRegistry.registerWorldGenerator((IWorldGenerator)new LivingEnderIslandWorldGen(), Integer.MAX_VALUE);
    	GameRegistry.registerWorldGenerator((IWorldGenerator)new DestitudeIslandWorldGen(), Integer.MAX_VALUE);
    	
    	NetworkRegistry.INSTANCE.registerGuiHandler((Object)NovaCraft.instance, (IGuiHandler)new CommonProxy());
    	
    	proxy.registerRenderers();
    	CommonProxy.registerEvent(new PlayerNovaCraftEvents());
    	CommonProxy.registerEvent(new NovaCraftEventHandler());
  
    }
    
    @EventHandler
	public void postInit(FMLPostInitializationEvent event) {
    	
    	GameRegistry.registerWorldGenerator((IWorldGenerator)new NCWorldGenerator(), 0);
    	GameRegistry.registerWorldGenerator(NCWorldGeneratorNether.INSTANCE, Integer.MAX_VALUE);
    	GameRegistry.registerWorldGenerator(NCWorldGeneratorEnd.INSTANCE, Integer.MAX_VALUE);
      	GameRegistry.registerWorldGenerator((IWorldGenerator)new NCWorldGeneratorPost(), 2);
      	GameRegistry.registerWorldGenerator(NCWorldGeneratorPlants.INSTANCE, Integer.MAX_VALUE);
      	
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
