package com.NovaCraft.world.ancient_city;

import java.util.Random;

import com.NovaCraftBlocks.NovaCraftBlocks;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

public class AncientCityGen implements IWorldGenerator {
	
	@Override
	public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		if (world.provider.dimensionId == 0) {
	         this.generateOverworld(world, rand, chunkX * 16, chunkZ * 16);
	      }
	   }
		
	public void generateOverworld(World world, Random rand, int x, int z) {
		BiomeGenBase biome = world.getWorldChunkManager().getBiomeGenAt(x + 16, z + 16);
	      if (rand.nextInt(3000) == 25) {
	    	  
	    	  int x1 = x + rand.nextInt(16) + 8;
	    	  int y1 = 30;
	    	  int z1 = z + rand.nextInt(16) + 8;
	    	  
	    	  int x2 = x1 + 36;
	    	  int y2 = 18;
	    	  int z2 = z1 + 36;
	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x2, y1, z2);
	    	  new AncientCitySphereGen().generate(world, rand, x2, y1 + 3, z2);
	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x2 + 12, y1, z2);
	    	  new AncientCitySphereGen().generate(world, rand, x2 - 12, y1, z2);
	    	  new AncientCitySphereGen().generate(world, rand, x2, y1, z2 + 12);
	    	  new AncientCitySphereGen().generate(world, rand, x2, y1, z2 - 12);
	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x2 + 12, y1, z2  + 12);
	    	  new AncientCitySphereGen().generate(world, rand, x2 - 12, y1, z2  + 12);
	    	  new AncientCitySphereGen().generate(world, rand, x2 + 12, y1, z2 - 12);
	    	  new AncientCitySphereGen().generate(world, rand, x2 - 12, y1, z2 - 12);
	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x2 + 24, y1, z2  + 12);
	    	  new AncientCitySphereGen().generate(world, rand, x2 - 24, y1, z2  + 12);
	    	  new AncientCitySphereGen().generate(world, rand, x2 + 24, y1, z2 - 12);
	    	  new AncientCitySphereGen().generate(world, rand, x2 - 24, y1, z2 - 12);
	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x2 + 36, y1, z2  + 12);
	    	  new AncientCitySphereGen().generate(world, rand, x2 - 36, y1, z2  + 12);
	    	  new AncientCitySphereGen().generate(world, rand, x2 + 36, y1, z2 - 12);
	    	  new AncientCitySphereGen().generate(world, rand, x2 - 36, y1, z2 - 12);
	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x2 + 48, y1, z2  + 12);
	    	  new AncientCitySphereGen().generate(world, rand, x2 - 48, y1, z2  + 12);
	    	  new AncientCitySphereGen().generate(world, rand, x2 + 48, y1, z2 - 12);
	    	  new AncientCitySphereGen().generate(world, rand, x2 - 48, y1, z2 - 12);
	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x2 + 60, y1, z2  + 12);
	    	  new AncientCitySphereGen().generate(world, rand, x2 - 60, y1, z2  + 12);
	    	  new AncientCitySphereGen().generate(world, rand, x2 + 60, y1, z2 - 12);
	    	  new AncientCitySphereGen().generate(world, rand, x2 - 60, y1, z2 - 12);
	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x2 + 72, y1, z2  + 12);
	    	  new AncientCitySphereGen().generate(world, rand, x2 - 72, y1, z2  + 12);
	    	  new AncientCitySphereGen().generate(world, rand, x2 + 72, y1, z2 - 12);
	    	  new AncientCitySphereGen().generate(world, rand, x2 - 72, y1, z2 - 12);
	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x2 + 84, y1, z2  + 12);
	    	  new AncientCitySphereGen().generate(world, rand, x2 - 84, y1, z2  + 12);
	    	  new AncientCitySphereGen().generate(world, rand, x2 + 84, y1, z2 - 12);
	    	  new AncientCitySphereGen().generate(world, rand, x2 - 84, y1, z2 - 12);
	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x2 + 24, y1, z2);
	    	  new AncientCitySphereGen().generate(world, rand, x2 - 24, y1, z2);
	    	  new AncientCitySphereGen().generate(world, rand, x2, y1, z2 + 24);
	    	  new AncientCitySphereGen().generate(world, rand, x2, y1, z2 - 24);
	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x2 + 36, y1, z2);
	    	  new AncientCitySphereGen().generate(world, rand, x2 - 36, y1, z2);
	    	  new AncientCitySphereGen().generate(world, rand, x2, y1, z2 + 36);
	    	  new AncientCitySphereGen().generate(world, rand, x2, y1, z2 - 36);
	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x2 + 48, y1, z2);
	    	  new AncientCitySphereGen().generate(world, rand, x2 - 48, y1, z2);
	    	  new AncientCitySphereGen().generate(world, rand, x2, y1, z2 + 48);
	    	  new AncientCitySphereGen().generate(world, rand, x2, y1, z2 - 48);
	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x2 + 60, y1, z2);
	    	  new AncientCitySphereGen().generate(world, rand, x2 - 60, y1, z2);
	    	  new AncientCitySphereGen().generate(world, rand, x2, y1, z2 + 60);
	    	  new AncientCitySphereGen().generate(world, rand, x2, y1, z2 - 60);
	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x2 + 72, y1, z2);
	    	  new AncientCitySphereGen().generate(world, rand, x2 - 72, y1, z2);
	    	  new AncientCitySphereGen().generate(world, rand, x2, y1, z2 + 72);
	    	  new AncientCitySphereGen().generate(world, rand, x2, y1, z2 - 72);
	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x2 + 84, y1, z2);
	    	  new AncientCitySphereGen().generate(world, rand, x2 - 84, y1, z2);
	    	  new AncientCitySphereGen().generate(world, rand, x2, y1, z2 + 84);
	    	  new AncientCitySphereGen().generate(world, rand, x2, y1, z2 - 84);
	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x2 + 96, y1, z2);
	    	  new AncientCitySphereGen().generate(world, rand, x2 - 96, y1, z2);
	    	  new AncientCitySphereGen().generate(world, rand, x2, y1, z2 + 96);
	    	  new AncientCitySphereGen().generate(world, rand, x2, y1, z2 - 96);
	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x2 + 12, y1, z2 + 24);
	    	  new AncientCitySphereGen().generate(world, rand, x2 - 12, y1, z2 + 24);
	    	  new AncientCitySphereGen().generate(world, rand, x2 + 12, y1, z2 - 24);
	    	  new AncientCitySphereGen().generate(world, rand, x2 - 12, y1, z2 - 24);
	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x2 + 12, y1, z2 + 36);
	    	  new AncientCitySphereGen().generate(world, rand, x2 - 12, y1, z2 + 36);
	    	  new AncientCitySphereGen().generate(world, rand, x2 + 12, y1, z2 - 36);
	    	  new AncientCitySphereGen().generate(world, rand, x2 - 12, y1, z2 - 36);
	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x2 + 12, y1, z2 + 48);
	    	  new AncientCitySphereGen().generate(world, rand, x2 - 12, y1, z2 + 48);
	    	  new AncientCitySphereGen().generate(world, rand, x2 + 12, y1, z2 - 48);
	    	  new AncientCitySphereGen().generate(world, rand, x2 - 12, y1, z2 - 48);
	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x2 + 12, y1, z2 + 60);
	    	  new AncientCitySphereGen().generate(world, rand, x2 - 12, y1, z2 + 60);
	    	  new AncientCitySphereGen().generate(world, rand, x2 + 12, y1, z2 - 60);
	    	  new AncientCitySphereGen().generate(world, rand, x2 - 12, y1, z2 - 60);
	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x2 + 12, y1, z2 + 72);
	    	  new AncientCitySphereGen().generate(world, rand, x2 - 12, y1, z2 + 72);
	    	  new AncientCitySphereGen().generate(world, rand, x2 + 12, y1, z2 - 72);
	    	  new AncientCitySphereGen().generate(world, rand, x2 - 12, y1, z2 - 72);
	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x2 + 12, y1, z2 + 84);
	    	  new AncientCitySphereGen().generate(world, rand, x2 - 12, y1, z2 + 84);
	    	  new AncientCitySphereGen().generate(world, rand, x2 + 12, y1, z2 - 84);
	    	  new AncientCitySphereGen().generate(world, rand, x2 - 12, y1, z2 - 84);
	    	  	    	  	    	 	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x2 + 24, y1, z2 + 24);
	    	  new AncientCitySphereGen().generate(world, rand, x2 - 24, y1, z2 + 24);
	    	  new AncientCitySphereGen().generate(world, rand, x2 + 24, y1, z2 - 24);
	    	  new AncientCitySphereGen().generate(world, rand, x2 - 24, y1, z2 - 24);
	    	  	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x2 + 36, y1, z2 + 24);
	    	  new AncientCitySphereGen().generate(world, rand, x2 - 36, y1, z2 + 24);
	    	  new AncientCitySphereGen().generate(world, rand, x2 + 36, y1, z2 - 24);
	    	  new AncientCitySphereGen().generate(world, rand, x2 - 36, y1, z2 - 24);
	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x2 + 48, y1, z2 + 24);
	    	  new AncientCitySphereGen().generate(world, rand, x2 - 48, y1, z2 + 24);
	    	  new AncientCitySphereGen().generate(world, rand, x2 + 48, y1, z2 - 24);
	    	  new AncientCitySphereGen().generate(world, rand, x2 - 48, y1, z2 - 24);
	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x2 + 24, y1, z2 + 36);
	    	  new AncientCitySphereGen().generate(world, rand, x2 - 24, y1, z2 + 36);
	    	  new AncientCitySphereGen().generate(world, rand, x2 + 24, y1, z2 - 36);
	    	  new AncientCitySphereGen().generate(world, rand, x2 - 24, y1, z2 - 36);    	  
	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x2 + 24, y1, z2 + 48);
	    	  new AncientCitySphereGen().generate(world, rand, x2 - 24, y1, z2 + 48);
	    	  new AncientCitySphereGen().generate(world, rand, x2 + 24, y1, z2 - 48);
	    	  new AncientCitySphereGen().generate(world, rand, x2 - 24, y1, z2 - 48);
	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x2 + 24, y1, z2 + 60);
	    	  new AncientCitySphereGen().generate(world, rand, x2 - 24, y1, z2 + 60);
	    	  new AncientCitySphereGen().generate(world, rand, x2 + 24, y1, z2 - 60);
	    	  new AncientCitySphereGen().generate(world, rand, x2 - 24, y1, z2 - 60);
	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x2 + 24, y1, z2 + 72);
	    	  new AncientCitySphereGen().generate(world, rand, x2 - 24, y1, z2 + 72);
	    	  new AncientCitySphereGen().generate(world, rand, x2 + 24, y1, z2 - 72);
	    	  new AncientCitySphereGen().generate(world, rand, x2 - 24, y1, z2 - 72);
	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x2 + 24, y1, z2 + 84);
	    	  new AncientCitySphereGen().generate(world, rand, x2 - 24, y1, z2 + 84);
	    	  new AncientCitySphereGen().generate(world, rand, x2 + 24, y1, z2 - 84);
	    	  new AncientCitySphereGen().generate(world, rand, x2 - 24, y1, z2 - 84);
	    	  
	    	  	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x2 + 36, y1, z2 + 48);
	    	  new AncientCitySphereGen().generate(world, rand, x2 - 36, y1, z2 + 48);
	    	  new AncientCitySphereGen().generate(world, rand, x2 + 36, y1, z2 - 48);
	    	  new AncientCitySphereGen().generate(world, rand, x2 - 36, y1, z2 - 48);
	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x2 + 36, y1, z2 + 60);
	    	  new AncientCitySphereGen().generate(world, rand, x2 - 36, y1, z2 + 60);
	    	  new AncientCitySphereGen().generate(world, rand, x2 + 36, y1, z2 - 60);
	    	  new AncientCitySphereGen().generate(world, rand, x2 - 36, y1, z2 - 60);
	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x2 + 36, y1, z2 + 72);
	    	  new AncientCitySphereGen().generate(world, rand, x2 - 36, y1, z2 + 72);
	    	  new AncientCitySphereGen().generate(world, rand, x2 + 36, y1, z2 - 72);
	    	  new AncientCitySphereGen().generate(world, rand, x2 - 36, y1, z2 - 72);
	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x2 + 36, y1, z2 + 84);
	    	  new AncientCitySphereGen().generate(world, rand, x2 - 36, y1, z2 + 84);
	    	  new AncientCitySphereGen().generate(world, rand, x2 + 36, y1, z2 - 84);
	    	  new AncientCitySphereGen().generate(world, rand, x2 - 36, y1, z2 - 84);
	    	  
	    	  //
	    	  new AncientCitySphereGen().generate(world, rand, x2 + 48, y1, z2 + 84);
	    	  new AncientCitySphereGen().generate(world, rand, x2 - 48, y1, z2 + 84);
	    	  new AncientCitySphereGen().generate(world, rand, x2 + 48, y1, z2 - 84);
	    	  new AncientCitySphereGen().generate(world, rand, x2 - 48, y1, z2 - 84);
	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x2 + 60, y1, z2 + 84);
	    	  new AncientCitySphereGen().generate(world, rand, x2 - 60, y1, z2 + 84);
	    	  new AncientCitySphereGen().generate(world, rand, x2 + 60, y1, z2 - 84);
	    	  new AncientCitySphereGen().generate(world, rand, x2 - 60, y1, z2 - 84);
	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x2 + 72, y1, z2 + 84);
	    	  new AncientCitySphereGen().generate(world, rand, x2 - 72, y1, z2 + 84);
	    	  new AncientCitySphereGen().generate(world, rand, x2 + 72, y1, z2 - 84);
	    	  new AncientCitySphereGen().generate(world, rand, x2 - 72, y1, z2 - 84);
	    	  	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x2 + 48, y1, z2 + 72);
	    	  new AncientCitySphereGen().generate(world, rand, x2 - 48, y1, z2 + 72);
	    	  new AncientCitySphereGen().generate(world, rand, x2 + 48, y1, z2 - 72);
	    	  new AncientCitySphereGen().generate(world, rand, x2 - 48, y1, z2 - 72);
	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x2 + 60, y1, z2 + 72);
	    	  new AncientCitySphereGen().generate(world, rand, x2 - 60, y1, z2 + 72);
	    	  new AncientCitySphereGen().generate(world, rand, x2 + 60, y1, z2 - 72);
	    	  new AncientCitySphereGen().generate(world, rand, x2 - 60, y1, z2 - 72);
	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x2 + 84, y1, z2 + 48);
	    	  new AncientCitySphereGen().generate(world, rand, x2 - 84, y1, z2 + 48);
	    	  new AncientCitySphereGen().generate(world, rand, x2 + 84, y1, z2 - 48);
	    	  new AncientCitySphereGen().generate(world, rand, x2 - 84, y1, z2 - 48);
	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x2 - 84, y1, z2 + 60);
	    	  new AncientCitySphereGen().generate(world, rand, x2 - 84, y1, z2 - 60);
	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x2 - 72, y1, z2 + 60);
	    	  new AncientCitySphereGen().generate(world, rand, x2 - 72, y1, z2 - 60);
	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x2 - 60, y1, z2 + 60);
	    	  new AncientCitySphereGen().generate(world, rand, x2 - 60, y1, z2 - 60);
	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x2 - 48, y1, z2 + 60);
	    	  new AncientCitySphereGen().generate(world, rand, x2 - 48, y1, z2 - 60);
	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x2 - 108, y1, z2);
	    	 	    	  
	    	  //Ancient City Parts ------------------------------------------------------------------------------------------------
	    	  new AncientCityCenterPortalGen7().generate(world, rand, x1, y1 - 17, z1);
	    	  new AncientCityCenterPortalGen6().generate(world, rand, x1, y1 - 17, z1);
	    	  new AncientCityCenterPortalGen5().generate(world, rand, x1, y1 - 17, z1);
	    	  new AncientCityCenterPortalGen4().generate(world, rand, x1, y1 - 17, z1);
	    	  new AncientCityCenterPortalGen3().generate(world, rand, x1, y1 - 17, z1);
	    	  new AncientCityCenterPortalGen2().generate(world, rand, x1, y1 - 17, z1);
	    	  new AncientCityCenterPortalGen1().generate(world, rand, x1, y1 - 17, z1);
	    	  
	    	  new AncientCityStairsGen().generate(world, rand, x1 + 20, y1 - 7, z1 + 23);
	    	  new AncientCityWardenAltarGen().generate(world, rand, x1 - 8, y1, z1 + 10);
	    	  
	    	  //-Z
	    	  new AncientCityNegativeHallwayGen1().generate(world, rand, x1 + 16, y1 - 16, z1 - 73);
	    	  new AncientCityNegativeHallwayGen2().generate(world, rand, x1 + 16, y1 - 16, z1 - 73);
	    	  new AncientCityNegativeHallwayGen3().generate(world, rand, x1 + 16, y1 - 16, z1 - 73);
	    	  new AncientCityNegativeHallwayGen4().generate(world, rand, x1 + 16, y1 - 16, z1 - 73);
	    	  
	    	  new AncientCitySmallStructure1Gen().generate(world, rand, x1 - 4, y1 - 16, z1 - 43);
	    	  
	    	  new AncientCitySmallStructure2Gen().generate(world, rand, x1 - 4, y1 - 16, z1 - 23);
	    	  
	    	  new AncientCityCobbledDeepslateGen().generate(world, rand, x1 - 4, y1 - 16, z1 - 63);
	    	  
	    	  new AncientCityIceRoomGen1().generate(world, rand, x1 + 31, y1 - 16, z1 - 23);
	    	  new AncientCityIceRoomGen2().generate(world, rand, x1 + 31, y1 - 16, z1 - 23);
	    	  
	    	  new AncientCitySmallHouseGen1().generate(world, rand, x1 + 39, y1 - 16, z1 - 43);
	    	  new AncientCitySmallHouseGen2().generate(world, rand, x1 + 39, y1 - 16, z1 - 43); 
	    	  
	    	  new AncientCityShrineGen1().generate(world, rand, x1 + 39, y1 - 16, z1 - 68);
	    	  new AncientCityShrineGen2().generate(world, rand, x1 + 39, y1 - 16, z1 - 68);
	    	  
	    	  new AncientCityIceRoomAlternateGen1().generate(world, rand, x1 + 39, y1 - 16, z1 - 84);
	    	  new AncientCityIceRoomAlternateGen2().generate(world, rand, x1 + 39, y1 - 16, z1 - 84);	
	    	  
	    	  //+Z
	    	  new AncientCityPositiveHallwayGen1().generate(world, rand, x1 + 17, y1 - 16, z1 + 68);
	    	  new AncientCityPositiveHallwayGen2().generate(world, rand, x1 + 17, y1 - 16, z1 + 68);
	    	  new AncientCityPositiveHallwayGen3().generate(world, rand, x1 + 17, y1 - 16, z1 + 68);
	    	  new AncientCityPositiveHallwayGen4().generate(world, rand, x1 + 17, y1 - 16, z1 + 68);
	    	  
	    	  new AncientCitySmallRoomGen1().generate(world, rand, x1 - 9, y1 - 16, z1 + 78);
	    	  new AncientCitySmallRoomGen2().generate(world, rand, x1 - 9, y1 - 16, z1 + 78);
	    	  
	    	  new AncientCityCobbledDeepslateGen().generate(world, rand, x1 - 9, y1 - 16, z1 + 98);	    	  
	    	  new AncientCityCobbledDeepslateGen().generate(world, rand, x1 - 9, y1 - 16, z1 + 98);
	    	  
	    	  new AncientCityEndPortalGen1().generate(world, rand, x1 - 15, y1 - 16, z1 + 108);	    	  
	    	  new AncientCityEndPortalGen2().generate(world, rand, x1 - 15, y1 - 16, z1 + 108); 

	    	  new AncientCitySculkTentacleFarmGen().generate(world, rand, x1 - 9, y1 - 16, z1 + 124); 
	    	  
	    	  new AncientCityIceRoomGen1().generate(world, rand, x1 + 32, y1 - 16, z1 + 78);
	    	  new AncientCityIceRoomGen2().generate(world, rand, x1 + 32, y1 - 16, z1 + 78);
	    	  
	    	  new AncientCityIceRoomAlternateGen1().generate(world, rand, x1 + 32, y1 - 16, z1 + 103);
	    	  new AncientCityIceRoomAlternateGen2().generate(world, rand, x1 + 32, y1 - 16, z1 + 103);
	    	  
	    	  new AncientCityNetherPortalGen().generate(world, rand, x1 + 32, y1 - 16, z1 + 131);
	    	  
	    	  //+X
	    	  new AncientCityPositiveXHallwayGen1().generate(world, rand, x1 + 46, y1 - 16, z1 + 24);
	    	  new AncientCityPositiveXHallwayGen2().generate(world, rand, x1 + 46, y1 - 16, z1 + 24);
	    	  new AncientCityPositiveXHallwayGen3().generate(world, rand, x1 + 46, y1 - 16, z1 + 24);
	    	  new AncientCityPositiveXHallwayGen4().generate(world, rand, x1 + 46, y1 - 16, z1 + 24);
	    	  new AncientCityPositiveXHallwayGen5().generate(world, rand, x1 + 46, y1 - 16, z1 + 24);
	    	  new AncientCityPositiveXHallwayGen6().generate(world, rand, x1 + 46, y1 - 16, z1 + 24);
	    	  
	    	  new AncientCityPositiveXHallwayLeftGen1().generate(world, rand, x1 + 50, y1 - 16, z1 + 16);
	    	  new AncientCityPositiveXHallwayLeftGen2().generate(world, rand, x1 + 50, y1 - 16, z1 + 16);
	    	  new AncientCityPositiveXHallwayLeftGen3().generate(world, rand, x1 + 50, y1 - 16, z1 + 16);
	    	  new AncientCityPositiveXHallwayLeftGen4().generate(world, rand, x1 + 50, y1 - 16, z1 + 16);
	    	  new AncientCityPositiveXHallwayLeftGen5().generate(world, rand, x1 + 50, y1 - 16, z1 + 16);
	    	  
	    	  new AncientCityPositiveXLeftBranchGen1().generate(world, rand, x1 + 49, y1 - 16, z1 - 17);
	    	  new AncientCityPositiveXLeftBranchGen2().generate(world, rand, x1 + 49, y1 - 16, z1 - 17);
	    	  new AncientCityPositiveXLeftBranchGen3().generate(world, rand, x1 + 49, y1 - 16, z1 - 17);
	    	  new AncientCityPositiveXLeftBranchGen4().generate(world, rand, x1 + 49, y1 - 16, z1 - 17);
	    	  new AncientCityPositiveXLeftBranchGen5().generate(world, rand, x1 + 49, y1 - 16, z1 - 17);
	    	  new AncientCityPositiveXLeftBranchGen6().generate(world, rand, x1 + 49, y1 - 16, z1 - 17);
	    	  new AncientCityPositiveXLeftBranchGen7().generate(world, rand, x1 + 49, y1 - 16, z1 - 17);
	    	  new AncientCityPositiveXLeftBranchGen8().generate(world, rand, x1 + 49, y1 - 16, z1 - 17);
	    	  
	    	  new AncientCityPositiveXLeftBranch2Gen1().generate(world, rand, x1 + 86, y1 - 16, z1 - 26);
	    	  new AncientCityPositiveXLeftBranch2Gen2().generate(world, rand, x1 + 86, y1 - 16, z1 - 26);
	    	  new AncientCityPositiveXLeftBranch2Gen3().generate(world, rand, x1 + 86, y1 - 16, z1 - 26);
	    	  new AncientCityPositiveXLeftBranch2Gen4().generate(world, rand, x1 + 86, y1 - 16, z1 - 26);
	    	  new AncientCityPositiveXLeftBranch2Gen5().generate(world, rand, x1 + 86, y1 - 16, z1 - 26);
	    	  new AncientCityPositiveXLeftBranch2Gen6().generate(world, rand, x1 + 86, y1 - 16, z1 - 26);
	    	  new AncientCityPositiveXLeftBranch2Gen7().generate(world, rand, x1 + 86, y1 - 16, z1 - 26);
	    	  
	    	  new AncientCityPositiveXLeftBranch3Gen1().generate(world, rand, x1 + 86, y1 - 16, z1 - 62);
	    	  new AncientCityPositiveXLeftBranch3Gen2().generate(world, rand, x1 + 86, y1 - 16, z1 - 62);
	    	  new AncientCityPositiveXLeftBranch3Gen3().generate(world, rand, x1 + 86, y1 - 16, z1 - 62);
	    	  new AncientCityPositiveXLeftBranch3Gen4().generate(world, rand, x1 + 86, y1 - 16, z1 - 62);
	    	  new AncientCityPositiveXLeftBranch3Gen5().generate(world, rand, x1 + 86, y1 - 16, z1 - 62);
	    	  new AncientCityPositiveXLeftBranch3Gen6().generate(world, rand, x1 + 86, y1 - 16, z1 - 62);
	    	  new AncientCityPositiveXLeftBranch3Gen7().generate(world, rand, x1 + 86, y1 - 16, z1 - 62);
	    	  
	    	  new AncientCityPositiveXHallwayRightGen1().generate(world, rand, x1 + 50, y1 - 16, z1 + 45);
	    	  new AncientCityPositiveXHallwayRightGen2().generate(world, rand, x1 + 50, y1 - 16, z1 + 45);
	    	  new AncientCityPositiveXHallwayRightGen3().generate(world, rand, x1 + 50, y1 - 16, z1 + 45);
	    	  
	    	  new AncientCityPositiveXRightBranchGen1().generate(world, rand, x1 + 88, y1 - 16, z1 + 54);
	    	  new AncientCityPositiveXRightBranchGen2().generate(world, rand, x1 + 88, y1 - 16, z1 + 54);
	    	  new AncientCityPositiveXRightBranchGen3().generate(world, rand, x1 + 88, y1 - 16, z1 + 54);
	    	  new AncientCityPositiveXRightBranchGen4().generate(world, rand, x1 + 88, y1 - 16, z1 + 54);
	    	  
	    	  new AncientCityPositiveXRightBranch2Gen1().generate(world, rand, x1 + 51, y1 - 16, z1 + 54);
	    	  new AncientCityPositiveXRightBranch2Gen2().generate(world, rand, x1 + 51, y1 - 16, z1 + 54);
	    	  new AncientCityPositiveXRightBranch2Gen3().generate(world, rand, x1 + 51, y1 - 16, z1 + 54);
	    	  new AncientCityPositiveXRightBranch2Gen4().generate(world, rand, x1 + 51, y1 - 16, z1 + 54);
	    	  new AncientCityPositiveXRightBranch2Gen5().generate(world, rand, x1 + 51, y1 - 16, z1 + 54);
	    	  new AncientCityPositiveXRightBranch2Gen6().generate(world, rand, x1 + 51, y1 - 16, z1 + 54);
	    	  
	    	  new AncientCitySmallStructure3Gen().generate(world, rand, x1 + 78, y1 - 16, z1 + 94);
	    	  
	    	  new AncientCitySmallTowerGen1().generate(world, rand, x1 + 93, y1 - 16, z1 + 109);
	    	  new AncientCitySmallTowerGen2().generate(world, rand, x1 + 93, y1 - 16, z1 + 109);
	    	  
	    	  new AncientCityFurnaceRoomGen1().generate(world, rand, x1 + 111, y1 - 24, z1 - 59);
	    	  new AncientCityFurnaceRoomGen2().generate(world, rand, x1 + 111, y1 - 24, z1 - 59);
	    	  
	    	  
	    	  //-X
	    	  new AncientCityNegativeXHallwayGen1().generate(world, rand, x1 - 93, y1 - 16, z1 + 31);
	    	  new AncientCityNegativeXHallwayGen2().generate(world, rand, x1 - 93, y1 - 16, z1 + 31);
	    	  new AncientCityNegativeXHallwayGen3().generate(world, rand, x1 - 93, y1 - 16, z1 + 31);
	    	  new AncientCityNegativeXHallwayGen4().generate(world, rand, x1 - 93, y1 - 16, z1 + 31);
	    	  new AncientCityNegativeXHallwayGen5().generate(world, rand, x1 - 93, y1 - 16, z1 + 31);
	    	  
	    	  new AncientCityTinyShrineGen().generate(world, rand, x1 - 14, y1 - 16, z1 + 46);
	    	  
	    	  new AncientCitySmallTower2Gen1().generate(world, rand, x1 - 27, y1 - 16, z1 + 46);
	    	  new AncientCitySmallTower2Gen2().generate(world, rand, x1 - 27, y1 - 16, z1 + 46);
	    	  
	    	  new AncientCityNegativeXShrineGen1().generate(world, rand, x1 - 46, y1 - 16, z1 + 46);
	    	  new AncientCityNegativeXShrineGen2().generate(world, rand, x1 - 46, y1 - 16, z1 + 46);
	    	  
	    	  new AncientCityNegativeXLeftBranchGen1().generate(world, rand, x1 - 69, y1 - 16, z1 + 40);
	    	  new AncientCityNegativeXLeftBranchGen2().generate(world, rand, x1 - 69, y1 - 16, z1 + 40);
	    	  
	    	  new AncientCityEasyTreasureGen().generate(world, rand, x1 - 14, y1 - 16, z1 + 15);
	    	  
	    	  new AncientCitySmallStructure5Gen().generate(world, rand, x1 - 27, y1 - 16, z1 + 15);
	    	  
	    	  new AncientCitySmallStructure4Gen().generate(world, rand, x1 - 46, y1 - 16, z1 + 15);
	    	  
	    	  new AncientCityNegativeXRightBranchGen1().generate(world, rand, x1 - 69, y1 - 16, z1 - 14);
	    	  new AncientCityNegativeXRightBranchGen2().generate(world, rand, x1 - 69, y1 - 16, z1 - 14);
	    	  new AncientCityNegativeXRightBranchGen3().generate(world, rand, x1 - 69, y1 - 16, z1 - 14);
	    	  
	    	  new AncientCityOre9xGen1().generate(world, rand, x1 - 45, y1 - 16, z1 - 11);
	    	  new AncientCityOre9xGen2().generate(world, rand, x1 - 45, y1 - 16, z1 - 11);
	    	  
	    	  new AncientCityCrystalFarmGen().generate(world, rand, x1 - 68, y1 - 16, z1 - 31);
	    	  
	    	  //Additional Random Structures
	    	  new AncientCityColumnTopGen().generate(world, rand, x1 + 54, y1 + 15, z1 + 122);
	    	  new AncientCityColumnGen1().generate(world, rand, x1 + 54, y1 - 16, z1 + 122);
	    	  new AncientCityColumnGen2().generate(world, rand, x1 + 54, y1 - 16, z1 + 122);	    	  
	    	  new AncientCityColumnBottomGen().generate(world, rand, x1 + 54, y1 - 26, z1 + 122);	    	  
	    	  	    		    	  
	    	  new AncientCitySupportGen().generate(world, rand, x1 + 69, y1 - 17, z1 - 40);
	    	  new AncientCitySupportTopGen().generate(world, rand, x1 + 66, y1 + 14, z1 - 43);
	    	  
	    	  new AncientCitySupportGen().generate(world, rand, x1 - 45, y1 - 17, z1 - 36);
	    	  new AncientCitySupportTopGen().generate(world, rand, x1 - 48, y1 + 14, z1 - 39);
	    	  
	    	  new AncientCitySupportGen().generate(world, rand, x1 - 159, y1 - 17, z1 - 40);
	    	  new AncientCitySupportTopGen().generate(world, rand, x1 - 162, y1 + 14, z1 - 43);
	    	  
	    	  new AncientCitySupportGen().generate(world, rand, x1 - 56, y1 - 17, z1 + 122);
	    	  new AncientCitySupportTopGen().generate(world, rand, x1 - 69, y1 + 14, z1 + 119);
	    	  
	    	  //new AncientCitySupportGen().generate(world, rand, x1 + 228, y1 - 1, z1 - 96);	    	  
	    	  //new AncientCitySupportGen().generate(world, rand, x1 + 122, y1 - 1, z1 - 85);
	    	  
		         }
	      }

	
}
