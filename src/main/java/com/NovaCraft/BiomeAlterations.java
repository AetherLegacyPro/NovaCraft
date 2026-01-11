package com.NovaCraft;

import com.NovaCraft.config.ConfigsWorld;
import net.minecraft.world.biome.BiomeGenBase;

import java.util.HashMap;
import java.util.Map;

import com.NovaCraft.config.Configs;

public class BiomeAlterations {

    private static final Map<BiomeGenBase, float[]> BIOME_HEIGHTS = new HashMap<BiomeGenBase, float[]>();

    static {
        													
    	if (ConfigsWorld.enableVanillaHillBiomeAlterations) {			//height variation
    		BIOME_HEIGHTS.put(BiomeGenBase.birchForestHills, new float[]{0.9F, 0.4F});
    		BIOME_HEIGHTS.put(BiomeGenBase.forestHills, new float[]{0.9F, 0.4F});
    		BIOME_HEIGHTS.put(BiomeGenBase.coldTaigaHills, new float[]{0.9F, 0.4F});
    		BIOME_HEIGHTS.put(BiomeGenBase.desertHills, new float[]{0.9F, 0.4F});
    		BIOME_HEIGHTS.put(BiomeGenBase.jungleHills, new float[]{0.9F, 0.4F});
    		BIOME_HEIGHTS.put(BiomeGenBase.megaTaigaHills, new float[]{1.0F, 0.4F});
    		BIOME_HEIGHTS.put(BiomeGenBase.taigaHills, new float[]{0.9F, 0.4F});
        	BIOME_HEIGHTS.put(BiomeGenBase.iceMountains, new float[]{2.0F, 0.8F});
        	BIOME_HEIGHTS.put(BiomeGenBase.savannaPlateau, new float[]{2.0F, 0.05F});
    	}
    	if (ConfigsWorld.enableVanillaMountainBiomeAlterations) {
    		BIOME_HEIGHTS.put(BiomeGenBase.extremeHillsEdge, new float[]{1.2F, 0.8F});
    		BIOME_HEIGHTS.put(BiomeGenBase.extremeHills, new float[]{2.0F, 0.8F});
    		BIOME_HEIGHTS.put(BiomeGenBase.extremeHillsPlus, new float[]{4.0F, 0.8F});
    		BIOME_HEIGHTS.put(BiomeGenBase.stoneBeach, new float[]{0.15F, 0.8F});
    	}
    	if (ConfigsWorld.enableDesertBiomeAlterations) {
    		BIOME_HEIGHTS.put(BiomeGenBase.desert, new float[]{0.175F, 0.01F});
    	}
        if (ConfigsWorld.enablePlainsBiomeAlterations) {
        	BIOME_HEIGHTS.put(BiomeGenBase.plains, new float[]{0.175F, 0.01F});        
        	BIOME_HEIGHTS.put(BiomeGenBase.icePlains, new float[]{0.175F, 0.01F});
        }
        if (ConfigsWorld.enableMiscBiomeAlterations) {
        	BIOME_HEIGHTS.put(BiomeGenBase.jungleEdge, new float[]{0.25F, 0.1F});
        	BIOME_HEIGHTS.put(BiomeGenBase.savanna, new float[]{0.225F, 0.1F});
        	BIOME_HEIGHTS.put(BiomeGenBase.forest, new float[]{0.15F, 0.3F});
        	BIOME_HEIGHTS.put(BiomeGenBase.taiga, new float[]{0.25F, 0.3F});
        	BIOME_HEIGHTS.put(BiomeGenBase.coldTaiga, new float[]{0.25F, 0.3F});
        	BIOME_HEIGHTS.put(BiomeGenBase.roofedForest, new float[]{0.2F, 0.3F});
        	BIOME_HEIGHTS.put(BiomeGenBase.jungle, new float[]{0.25F, 0.5F});
        	BIOME_HEIGHTS.put(BiomeGenBase.mushroomIsland, new float[]{0.25F, 0.4F});        
        	BIOME_HEIGHTS.put(BiomeGenBase.mesa, new float[]{0.15F, 0.3F});
        	BIOME_HEIGHTS.put(BiomeGenBase.mesaPlateau, new float[]{1.6F, 0.03F});
        	BIOME_HEIGHTS.put(BiomeGenBase.mesaPlateau_F, new float[]{1.6F, 0.03F});
        }
        if (ConfigsWorld.enableWaterBiomeAlterations) {
        	BIOME_HEIGHTS.put(BiomeGenBase.swampland, new float[]{-0.25F, 0.2F});
        	BIOME_HEIGHTS.put(BiomeGenBase.river, new float[]{-0.6F, 0.0F});
        	BIOME_HEIGHTS.put(BiomeGenBase.frozenRiver, new float[]{-0.6F, 0.0F});
        	BIOME_HEIGHTS.put(BiomeGenBase.ocean, new float[]{-1.1F, 0.15F});
        	BIOME_HEIGHTS.put(BiomeGenBase.frozenOcean, new float[]{-1.1F, 0.15F});
        }        
        if (ConfigsWorld.enableBeachBiomeAlterations) {
        	BIOME_HEIGHTS.put(BiomeGenBase.beach, new float[]{0.1F, 0.025F});
        	BIOME_HEIGHTS.put(BiomeGenBase.coldBeach, new float[]{0.1F, 0.025F});
        	BIOME_HEIGHTS.put(BiomeGenBase.mushroomIslandShore, new float[]{0.1F, 0.025F});
        }
    }

    public static void applyTweaks() {
        for (Map.Entry<BiomeGenBase, float[]> entry : BIOME_HEIGHTS.entrySet()) {
            BiomeGenBase biome = entry.getKey();
            float[] newHeights = entry.getValue();

            float oldRoot = biome.rootHeight;
            float oldVar = biome.heightVariation;
            biome.rootHeight = newHeights[0];
            biome.heightVariation = newHeights[1];
        }
    }
}

