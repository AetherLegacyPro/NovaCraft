package com.NovaCraft.world.caves;

import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;

//Stops Water Pools from trying to generate in desert type biomes
public class WaterPoolGenerationOverride {
    @SubscribeEvent
    public void onPopulate(PopulateChunkEvent.Populate event) {
        if (event.world.isRemote || event.world.provider.dimensionId != 0) {
            return;
        }

        if (event.type != PopulateChunkEvent.Populate.EventType.LAKE) {
            return;
        }

        int x = event.chunkX * 16 + 16;
        int z = event.chunkZ * 16 + 16;

        BiomeGenBase biome = event.world.getBiomeGenForCoords(x, z);
        if (biome == BiomeGenBase.desert || (BiomeDictionary.isBiomeOfType(biome, Type.SANDY) && BiomeDictionary.isBiomeOfType(biome, Type.DRY) && BiomeDictionary.isBiomeOfType(biome, Type.HOT))) {
            event.setResult(Result.DENY);
        }
    }
}
