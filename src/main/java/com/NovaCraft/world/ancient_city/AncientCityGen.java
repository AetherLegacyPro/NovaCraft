package com.NovaCraft.world.ancient_city;

import java.util.Random;

import com.NovaCraft.world.end.endcamp.EnderCampCenterGen;

import cpw.mods.fml.common.IWorldGenerator;
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
	    	  int y1 = 18;
	    	  int z1 = z + rand.nextInt(16) + 8;
	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x1, y1, z1);
	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x1 + 12, y1, z1);
	    	  new AncientCitySphereGen().generate(world, rand, x1 - 12, y1, z1);
	    	  new AncientCitySphereGen().generate(world, rand, x1, y1, z1 + 12);
	    	  new AncientCitySphereGen().generate(world, rand, x1, y1, z1 - 12);
	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x1 + 12, y1, z1  + 12);
	    	  new AncientCitySphereGen().generate(world, rand, x1 - 12, y1, z1  + 12);
	    	  new AncientCitySphereGen().generate(world, rand, x1 + 12, y1, z1 - 12);
	    	  new AncientCitySphereGen().generate(world, rand, x1 - 12, y1, z1 - 12);
	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x1 + 24, y1, z1 + 12);
	    	  new AncientCitySphereGen().generate(world, rand, x1 - 24, y1, z1 + 12);
	    	  new AncientCitySphereGen().generate(world, rand, x1 + 24, y1, z1 - 12);
	    	  new AncientCitySphereGen().generate(world, rand, x1 - 24, y1, z1 - 12);
	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x1 + 12, y1, z1 + 24);
	    	  new AncientCitySphereGen().generate(world, rand, x1 - 12, y1, z1 + 24);
	    	  new AncientCitySphereGen().generate(world, rand, x1 + 12, y1, z1 - 24);
	    	  new AncientCitySphereGen().generate(world, rand, x1 - 12, y1, z1 - 24); 	  
	    	  	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x1 + 24, y1, z1);
	    	  new AncientCitySphereGen().generate(world, rand, x1 - 24, y1, z1);
	    	  new AncientCitySphereGen().generate(world, rand, x1, y1, z1 + 24);
	    	  new AncientCitySphereGen().generate(world, rand, x1, y1, z1 - 24);
	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x1 + 24, y1, z1  + 24);
	    	  new AncientCitySphereGen().generate(world, rand, x1 - 24, y1, z1  + 24);
	    	  new AncientCitySphereGen().generate(world, rand, x1 + 24, y1, z1 - 24);
	    	  new AncientCitySphereGen().generate(world, rand, x1 - 24, y1, z1 - 24);
	    	  	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x1 + 36, y1, z1);
	    	  new AncientCitySphereGen().generate(world, rand, x1 - 36, y1, z1);
	    	  new AncientCitySphereGen().generate(world, rand, x1, y1, z1 + 36);
	    	  new AncientCitySphereGen().generate(world, rand, x1, y1, z1 - 36);
	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x1 + 36, y1, z1 + 36);
	    	  new AncientCitySphereGen().generate(world, rand, x1 - 36, y1, z1 + 36);
	    	  new AncientCitySphereGen().generate(world, rand, x1 + 36, y1, z1 - 36);
	    	  new AncientCitySphereGen().generate(world, rand, x1 - 36, y1, z1 - 36);
	    	  	    	      	 	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x1 + 48, y1, z1);
	    	  new AncientCitySphereGen().generate(world, rand, x1 - 48, y1, z1);
	    	  new AncientCitySphereGen().generate(world, rand, x1, y1, z1 + 48);
	    	  new AncientCitySphereGen().generate(world, rand, x1, y1, z1 - 48);
	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x1 + 48, y1, z1 + 24);
	    	  new AncientCitySphereGen().generate(world, rand, x1 - 48, y1, z1 + 24);    	  
	    	  new AncientCitySphereGen().generate(world, rand, x1 + 48, y1, z1 - 24);
	    	  new AncientCitySphereGen().generate(world, rand, x1 - 48, y1, z1 - 24);
	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x1 + 24, y1, z1 + 48);
	    	  new AncientCitySphereGen().generate(world, rand, x1 + 24, y1, z1 - 48);	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x1 - 24, y1, z1 + 48);
	    	  new AncientCitySphereGen().generate(world, rand, x1 - 24, y1, z1 - 48);
	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x1 + 36, y1, z1 + 48);
	    	  new AncientCitySphereGen().generate(world, rand, x1 + 36, y1, z1 - 48);	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x1 - 36, y1, z1 + 48);
	    	  new AncientCitySphereGen().generate(world, rand, x1 - 36, y1, z1 - 48);
	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x1 + 48, y1, z1 + 48);
	    	  new AncientCitySphereGen().generate(world, rand, x1 - 48, y1, z1 + 48);    	  
	    	  new AncientCitySphereGen().generate(world, rand, x1 + 48, y1, z1 - 48);
	    	  new AncientCitySphereGen().generate(world, rand, x1 - 48, y1, z1 - 48);
	    	  	    	  	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x1 + 60, y1, z1);
	    	  new AncientCitySphereGen().generate(world, rand, x1 - 60, y1, z1);
	    	  new AncientCitySphereGen().generate(world, rand, x1, y1, z1 + 60);
	    	  new AncientCitySphereGen().generate(world, rand, x1, y1, z1 - 60);
	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x1 + 60, y1, z1 + 24);
	    	  new AncientCitySphereGen().generate(world, rand, x1 - 60, y1, z1 + 24);    	  
	    	  new AncientCitySphereGen().generate(world, rand, x1 + 60, y1, z1 - 24);
	    	  new AncientCitySphereGen().generate(world, rand, x1 - 60, y1, z1 - 24);
	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x1 + 24, y1, z1 + 60);
	    	  new AncientCitySphereGen().generate(world, rand, x1 + 24, y1, z1 - 60);	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x1 - 24, y1, z1 + 60);
	    	  new AncientCitySphereGen().generate(world, rand, x1 - 24, y1, z1 - 60);
	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x1 + 60, y1, z1 + 36);
	    	  new AncientCitySphereGen().generate(world, rand, x1 - 60, y1, z1 + 36);    	  
	    	  new AncientCitySphereGen().generate(world, rand, x1 + 60, y1, z1 - 36);
	    	  new AncientCitySphereGen().generate(world, rand, x1 - 60, y1, z1 - 36);
	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x1 + 36, y1, z1 + 60);
	    	  new AncientCitySphereGen().generate(world, rand, x1 + 36, y1, z1 - 60);	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x1 - 36, y1, z1 + 60);
	    	  new AncientCitySphereGen().generate(world, rand, x1 - 36, y1, z1 - 60);
	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x1 + 60, y1, z1 + 48);
	    	  new AncientCitySphereGen().generate(world, rand, x1 - 60, y1, z1 + 48);    	  
	    	  new AncientCitySphereGen().generate(world, rand, x1 + 60, y1, z1 - 48);
	    	  new AncientCitySphereGen().generate(world, rand, x1 - 60, y1, z1 - 48);
	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x1 + 48, y1, z1 + 60);
	    	  new AncientCitySphereGen().generate(world, rand, x1 + 48, y1, z1 - 60);	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x1 - 48, y1, z1 + 60);
	    	  new AncientCitySphereGen().generate(world, rand, x1 - 48, y1, z1 - 60);
	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x1 + 60, y1, z1 + 60);
	    	  new AncientCitySphereGen().generate(world, rand, x1 - 60, y1, z1 + 60);    	  
	    	  new AncientCitySphereGen().generate(world, rand, x1 + 60, y1, z1 - 60);
	    	  new AncientCitySphereGen().generate(world, rand, x1 - 60, y1, z1 - 60);
	    	      	  	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x1 + 72, y1, z1);
	    	  new AncientCitySphereGen().generate(world, rand, x1 - 72, y1, z1);
	    	  new AncientCitySphereGen().generate(world, rand, x1, y1, z1 + 72);
	    	  new AncientCitySphereGen().generate(world, rand, x1, y1, z1 - 72);
	    	  	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x1 + 84, y1, z1);
	    	  new AncientCitySphereGen().generate(world, rand, x1 - 84, y1, z1);
	    	  new AncientCitySphereGen().generate(world, rand, x1, y1, z1 + 84);
	    	  new AncientCitySphereGen().generate(world, rand, x1, y1, z1 - 84);
	    	  
	    	  
	    	  
	    	  //removes the strange blocks that are not deleted first
	    	  new AncientCitySphereGen().generate(world, rand, x1, y1, z1);
	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x1 + 12, y1, z1);
	    	  new AncientCitySphereGen().generate(world, rand, x1 - 12, y1, z1);
	    	  new AncientCitySphereGen().generate(world, rand, x1, y1, z1 + 12);
	    	  new AncientCitySphereGen().generate(world, rand, x1, y1, z1 - 12);
	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x1 + 12, y1, z1 + 12);
	    	  new AncientCitySphereGen().generate(world, rand, x1 - 12, y1, z1 + 12);
	    	  new AncientCitySphereGen().generate(world, rand, x1 + 12, y1, z1 - 12);
	    	  new AncientCitySphereGen().generate(world, rand, x1 - 12, y1, z1 - 12);
	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x1 + 24, y1, z1 + 12);
	    	  new AncientCitySphereGen().generate(world, rand, x1 - 24, y1, z1 + 12);
	    	  new AncientCitySphereGen().generate(world, rand, x1 + 24, y1, z1 - 12);
	    	  new AncientCitySphereGen().generate(world, rand, x1 - 24, y1, z1 - 12);
	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x1 + 12, y1, z1 + 24);
	    	  new AncientCitySphereGen().generate(world, rand, x1 - 12, y1, z1 + 24);
	    	  new AncientCitySphereGen().generate(world, rand, x1 + 12, y1, z1 - 24);
	    	  new AncientCitySphereGen().generate(world, rand, x1 - 12, y1, z1 - 24); 	  
	    	  	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x1 + 24, y1, z1);
	    	  new AncientCitySphereGen().generate(world, rand, x1 - 24, y1, z1);
	    	  new AncientCitySphereGen().generate(world, rand, x1, y1, z1 + 24);
	    	  new AncientCitySphereGen().generate(world, rand, x1, y1, z1 - 24);
	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x1 + 24, y1, z1  + 24);
	    	  new AncientCitySphereGen().generate(world, rand, x1 - 24, y1, z1  + 24);
	    	  new AncientCitySphereGen().generate(world, rand, x1 + 24, y1, z1 - 24);
	    	  new AncientCitySphereGen().generate(world, rand, x1 - 24, y1, z1 - 24);
	    	  	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x1 + 36, y1, z1);
	    	  new AncientCitySphereGen().generate(world, rand, x1 - 36, y1, z1);
	    	  new AncientCitySphereGen().generate(world, rand, x1, y1, z1 + 36);
	    	  new AncientCitySphereGen().generate(world, rand, x1, y1, z1 - 36);
	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x1 + 36, y1, z1 + 36);
	    	  new AncientCitySphereGen().generate(world, rand, x1 - 36, y1, z1 + 36);
	    	  new AncientCitySphereGen().generate(world, rand, x1 + 36, y1, z1 - 36);
	    	  new AncientCitySphereGen().generate(world, rand, x1 - 36, y1, z1 - 36);
	    	  	    	      	 	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x1 + 48, y1, z1);
	    	  new AncientCitySphereGen().generate(world, rand, x1 - 48, y1, z1);
	    	  new AncientCitySphereGen().generate(world, rand, x1, y1, z1 + 48);
	    	  new AncientCitySphereGen().generate(world, rand, x1, y1, z1 - 48);
	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x1 + 48, y1, z1 + 24);
	    	  new AncientCitySphereGen().generate(world, rand, x1 - 48, y1, z1 + 24);    	  
	    	  new AncientCitySphereGen().generate(world, rand, x1 + 48, y1, z1 - 24);
	    	  new AncientCitySphereGen().generate(world, rand, x1 - 48, y1, z1 - 24);
	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x1 + 24, y1, z1 + 48);
	    	  new AncientCitySphereGen().generate(world, rand, x1 + 24, y1, z1 - 48);	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x1 - 24, y1, z1 + 48);
	    	  new AncientCitySphereGen().generate(world, rand, x1 - 24, y1, z1 - 48);
	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x1 + 36, y1, z1 + 48);
	    	  new AncientCitySphereGen().generate(world, rand, x1 + 36, y1, z1 - 48);	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x1 - 36, y1, z1 + 48);
	    	  new AncientCitySphereGen().generate(world, rand, x1 - 36, y1, z1 - 48);
	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x1 + 48, y1, z1 + 48);
	    	  new AncientCitySphereGen().generate(world, rand, x1 - 48, y1, z1 + 48);    	  
	    	  new AncientCitySphereGen().generate(world, rand, x1 + 48, y1, z1 - 48);
	    	  new AncientCitySphereGen().generate(world, rand, x1 - 48, y1, z1 - 48);
	    	  	    	  	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x1 + 60, y1, z1);
	    	  new AncientCitySphereGen().generate(world, rand, x1 - 60, y1, z1);
	    	  new AncientCitySphereGen().generate(world, rand, x1, y1, z1 + 60);
	    	  new AncientCitySphereGen().generate(world, rand, x1, y1, z1 - 60);
	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x1 + 60, y1, z1 + 24);
	    	  new AncientCitySphereGen().generate(world, rand, x1 - 60, y1, z1 + 24);    	  
	    	  new AncientCitySphereGen().generate(world, rand, x1 + 60, y1, z1 - 24);
	    	  new AncientCitySphereGen().generate(world, rand, x1 - 60, y1, z1 - 24);
	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x1 + 24, y1, z1 + 60);
	    	  new AncientCitySphereGen().generate(world, rand, x1 + 24, y1, z1 - 60);	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x1 - 24, y1, z1 + 60);
	    	  new AncientCitySphereGen().generate(world, rand, x1 - 24, y1, z1 - 60);
	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x1 + 60, y1, z1 + 36);
	    	  new AncientCitySphereGen().generate(world, rand, x1 - 60, y1, z1 + 36);    	  
	    	  new AncientCitySphereGen().generate(world, rand, x1 + 60, y1, z1 - 36);
	    	  new AncientCitySphereGen().generate(world, rand, x1 - 60, y1, z1 - 36);
	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x1 + 36, y1, z1 + 60);
	    	  new AncientCitySphereGen().generate(world, rand, x1 + 36, y1, z1 - 60);	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x1 - 36, y1, z1 + 60);
	    	  new AncientCitySphereGen().generate(world, rand, x1 - 36, y1, z1 - 60);
	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x1 + 60, y1, z1 + 48);
	    	  new AncientCitySphereGen().generate(world, rand, x1 - 60, y1, z1 + 48);    	  
	    	  new AncientCitySphereGen().generate(world, rand, x1 + 60, y1, z1 - 48);
	    	  new AncientCitySphereGen().generate(world, rand, x1 - 60, y1, z1 - 48);
	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x1 + 48, y1, z1 + 60);
	    	  new AncientCitySphereGen().generate(world, rand, x1 + 48, y1, z1 - 60);	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x1 - 48, y1, z1 + 60);
	    	  new AncientCitySphereGen().generate(world, rand, x1 - 48, y1, z1 - 60);
	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x1 + 60, y1, z1 + 60);
	    	  new AncientCitySphereGen().generate(world, rand, x1 - 60, y1, z1 + 60);    	  
	    	  new AncientCitySphereGen().generate(world, rand, x1 + 60, y1, z1 - 60);
	    	  new AncientCitySphereGen().generate(world, rand, x1 - 60, y1, z1 - 60);
	    	      	  	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x1 + 72, y1, z1);
	    	  new AncientCitySphereGen().generate(world, rand, x1 - 72, y1, z1);
	    	  new AncientCitySphereGen().generate(world, rand, x1, y1, z1 + 72);
	    	  new AncientCitySphereGen().generate(world, rand, x1, y1, z1 - 72);
	    	  	    	  
	    	  new AncientCitySphereGen().generate(world, rand, x1 + 84, y1, z1);
	    	  new AncientCitySphereGen().generate(world, rand, x1 - 84, y1, z1);
	    	  new AncientCitySphereGen().generate(world, rand, x1, y1, z1 + 84);
	    	  new AncientCitySphereGen().generate(world, rand, x1, y1, z1 - 84);
	    	  
	    	  
	    	  
	    	  //Ancient City Parts
	    	  new AncientCityCenterPortalGen7().generate(world, rand, x1, y1 - 13, z1);
	    	  new AncientCityCenterPortalGen6().generate(world, rand, x1, y1 - 13, z1);
	    	  new AncientCityCenterPortalGen5().generate(world, rand, x1, y1 - 13, z1);
	    	  new AncientCityCenterPortalGen4().generate(world, rand, x1, y1 - 13, z1);
	    	  new AncientCityCenterPortalGen3().generate(world, rand, x1, y1 - 13, z1);
	    	  new AncientCityCenterPortalGen2().generate(world, rand, x1, y1 - 13, z1);
	    	  new AncientCityCenterPortalGen1().generate(world, rand, x1, y1 - 13, z1);
	    	  
	    	  new AncientCityNegativeHallwayGen1().generate(world, rand, x1 + 16, y1 - 12, z1 - 73);
	    	  new AncientCityNegativeHallwayGen2().generate(world, rand, x1 + 16, y1 - 12, z1 - 73);
	    	  new AncientCityNegativeHallwayGen3().generate(world, rand, x1 + 16, y1 - 12, z1 - 73);
	    	  new AncientCityNegativeHallwayGen4().generate(world, rand, x1 + 16, y1 - 12, z1 - 73);
	      }							
	 }
	
	
	
}
