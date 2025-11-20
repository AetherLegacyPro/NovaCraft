package com.NovaCraft.world.sculkshaft;

import static net.minecraftforge.event.terraingen.InitMapGenEvent.EventType.CUSTOM;
import java.util.Random;
import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.event.terraingen.TerrainGen;

public class SculkMineshaftGenerator implements IWorldGenerator {

	public static MapGenSculkMineshaft getMineshaftGenerator()
	{
		return MineshaftGenerator;
	}
	
	public static MapGenSculkMineshaft MineshaftGenerator = new MapGenSculkMineshaft();
	
	@Override
	public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		
		Block[] ablock = new Block[65536];
		
		if (
				(world.provider.dimensionId == 0)
				&& (world.getWorldInfo().isMapFeaturesEnabled())
				)
			{

			MineshaftGenerator = (MapGenSculkMineshaft) TerrainGen.getModdedMapGen(new MapGenSculkMineshaft(), CUSTOM);
				
				int chunkOffset = 2;
				for (int OM_x = -chunkOffset; OM_x <= chunkOffset-1; OM_x++) {
					for (int OM_z = -chunkOffset; OM_z <= chunkOffset-1; OM_z++) {
						
						this.MineshaftGenerator.func_151539_a(world.getChunkProvider(), world, chunkX, chunkZ, ablock);
						
						try {
							boolean generateInChunk = this.MineshaftGenerator.generateStructuresInChunk(world, rand, chunkX+OM_x, chunkZ+OM_z);
		                }
		                catch (Exception e) {
		                }
						
					}
				}
		}

	}
	
}
