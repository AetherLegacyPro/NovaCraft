package com.NovaCraft.world.nether.structure;

import static net.minecraftforge.event.terraingen.InitMapGenEvent.EventType.CUSTOM;

import java.util.Random;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.event.terraingen.TerrainGen;

public class NovaNetherBridgeGenerator implements IWorldGenerator {

	public static MapGenNetherBridgeNovaCraft getForestressGenerator()
	{
		return ForestressGenerator;
	}
	
	public static MapGenNetherBridgeNovaCraft ForestressGenerator = new MapGenNetherBridgeNovaCraft();
	
	@Override
	public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		
		Block[] ablock = new Block[65536];
		
		if (
				(world.provider.dimensionId == -1)
				&& (world.getWorldInfo().isMapFeaturesEnabled())
				)
			{

			ForestressGenerator = (MapGenNetherBridgeNovaCraft) TerrainGen.getModdedMapGen(new MapGenNetherBridgeNovaCraft(), CUSTOM);
				
				int chunkOffset = 2;
				for (int OM_x = -chunkOffset; OM_x <= chunkOffset-1; OM_x++) {
					for (int OM_z = -chunkOffset; OM_z <= chunkOffset-1; OM_z++) {
						
						this.ForestressGenerator.func_151539_a(world.getChunkProvider(), world, chunkX, chunkZ, ablock);
						
						try {
							boolean generateInChunk = this.ForestressGenerator.generateStructuresInChunk(world, rand, chunkX+OM_x, chunkZ+OM_z);
		                }
		                catch (Exception e) {
		                }
						
					}
				}
		}

	}
	
}
