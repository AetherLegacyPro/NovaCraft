package com.NovaCraft.config;

import java.io.File;

import net.minecraftforge.common.MinecraftForge;

public class ConfigsMain {

	public static void loadConfigs(File configFile) {
	Configs.loadConfigs(new File(configFile, "NovaCraft_Base.cfg"));
    MinecraftForge.EVENT_BUS.register((Object)new Configs());

    ConfigsTextureOverride.init(new File(configFile, "Texture_Overrides.cfg"));
    MinecraftForge.EVENT_BUS.register((Object)new ConfigsTextureOverride());

    ConfigsEntities.loadConfigs(new File(configFile, "NovaCraft_Entities.cfg"));
    MinecraftForge.EVENT_BUS.register((Object)new ConfigsEntities());

    ConfigsCompact.loadConfigs(new File(configFile, "NovaCraft_Compact.cfg"));
    MinecraftForge.EVENT_BUS.register((Object)new ConfigsCompact());

    ConfigsStructures.loadConfigs(new File(configFile, "NovaCraft_Structures.cfg"));
    MinecraftForge.EVENT_BUS.register((Object)new ConfigsStructures());

    ConfigsWorld.loadConfigs(new File(configFile, "NovaCraft_World.cfg"));
    MinecraftForge.EVENT_BUS.register((Object)new ConfigsWorld());
	}
}
