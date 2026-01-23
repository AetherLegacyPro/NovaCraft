package com.NovaCraft.world.ancient_city;

import java.util.Random;

import org.apache.commons.lang3.ArrayUtils;

import com.NovaCraft.world.ancient_city.prisoner.AncientCityLargeHangingStructureGen;
import com.NovaCraft.world.ancient_city.prisoner.AncientCityMediumHangingStructureGen;
import com.NovaCraft.world.ancient_city.prisoner.AncientCitySmallHangingStructure1Gen;
import com.NovaCraft.world.ancient_city.prisoner.AncientCitySmallHangingStructure2Gen;
import com.NovaCraft.world.ancient_city.prisoner.AncientCitySmallHangingStructure3Gen;
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

	@Override //Need to add config option at some point, so they can generate in other dimensions
	public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		if (world.provider.dimensionId == 0) {
	         this.generateOverworld(world, rand, chunkX * 16, chunkZ * 16);
	      }
	   }

	   //When the echo eye is trying to find the ancient city it points to locations where there are no ancient cities in the negative quadrants
	   //Without this if x<0 or z<0 it chooses the wrong quadrant as the true position and position the echo eye points to become misaligned due to a truncation error
	   //-((-a + b - 1) / b) is added to make sure it rounds toward a negative integer instead of toward 0 as this is what truncating does in java for some reason
	private static int floorDiv(int a, int b) {
		if (a >= 0) return a / b;
		return - ((-a + b - 1) / b);
	}
	public void generateOverworld(World world, Random rand, int x, int z) {
		//If x and z coords are less than 5k fail to generate
		if (Math.abs(x) >= 5000 || Math.abs(z) >= 5000) {

			int chunkX = x + rand.nextInt(8) + 8;
			int chunkZ = z + rand.nextInt(8) + 8;


			//Need to check for invalid biomes due to lack of vertical space in 1.7.10: Mainly only an issue for Deep Oceans, Oceans, and Swamps
			//The Ancient City is Massive(About 400 blocks across) Need to check along the plane and in the diagonals for invaild biomes
			BiomeGenBase biome = world.getBiomeGenForCoords(x, z);
			Type[] biomeList = BiomeDictionary.getTypesForBiome(biome);

			BiomeGenBase biomePosX = world.getBiomeGenForCoords(x + 160, z);
			Type[] biomeListPosX = BiomeDictionary.getTypesForBiome(biomePosX);

			BiomeGenBase biomeNegX = world.getBiomeGenForCoords(x - 160, z);
			Type[] biomeListNegX = BiomeDictionary.getTypesForBiome(biomeNegX);

			BiomeGenBase biomePosZ = world.getBiomeGenForCoords(x, z + 150);
			Type[] biomeListPosZ = BiomeDictionary.getTypesForBiome(biomePosZ);

			BiomeGenBase biomeNegZ = world.getBiomeGenForCoords(x, z - 150);
			Type[] biomeListNegZ = BiomeDictionary.getTypesForBiome(biomeNegZ);

			BiomeGenBase biomePosXPosZ = world.getBiomeGenForCoords(x + 160, z + 150);
			Type[] biomeListPosXPosZ = BiomeDictionary.getTypesForBiome(biomePosXPosZ);

			BiomeGenBase biomeNegXNegZ = world.getBiomeGenForCoords(x - 160, z - 150);
			Type[] biomeListNegXNegZ = BiomeDictionary.getTypesForBiome(biomeNegXNegZ);

			BiomeGenBase biomePosXNegZ = world.getBiomeGenForCoords(x + 160, z - 150);
			Type[] biomeListPosXNegZ = BiomeDictionary.getTypesForBiome(biomePosXNegZ);

			BiomeGenBase biomeNegXPosZ = world.getBiomeGenForCoords(x - 160, z + 150);
			Type[] biomeListNegXPosZ = BiomeDictionary.getTypesForBiome(biomeNegXPosZ);

			//The minimum distance between Ancient Cities, so they do not overlap
			final int spacing = 750;

			int regionX = floorDiv(x, spacing);
			int regionZ = floorDiv(z, spacing);

			//Tie the generation to the world seed
			Random regionRand = new Random(world.getSeed() + (long) (regionX * 341873128712L) + (long) (regionZ * 132897987541L));

			if (regionRand.nextInt(3) == 1
					&& !ArrayUtils.contains(biomeList, Type.OCEAN) && !ArrayUtils.contains(biomeList, Type.BEACH) && !ArrayUtils.contains(biomeList, Type.SWAMP)
					&& !ArrayUtils.contains(biomeListPosX, Type.OCEAN) && !ArrayUtils.contains(biomeListPosX, Type.BEACH) && !ArrayUtils.contains(biomeListPosX, Type.SWAMP)
					&& !ArrayUtils.contains(biomeListNegX, Type.OCEAN) && !ArrayUtils.contains(biomeListNegX, Type.BEACH) && !ArrayUtils.contains(biomeListNegX, Type.SWAMP)
					&& !ArrayUtils.contains(biomeListPosZ, Type.OCEAN) && !ArrayUtils.contains(biomeListPosZ, Type.BEACH) && !ArrayUtils.contains(biomeListPosZ, Type.SWAMP)
					&& !ArrayUtils.contains(biomeListNegZ, Type.OCEAN) && !ArrayUtils.contains(biomeListNegZ, Type.BEACH) && !ArrayUtils.contains(biomeListNegZ, Type.SWAMP)
					&& !ArrayUtils.contains(biomeListPosXPosZ, Type.OCEAN) && !ArrayUtils.contains(biomeListPosXPosZ, Type.BEACH) && !ArrayUtils.contains(biomeListPosXPosZ, Type.SWAMP)
					&& !ArrayUtils.contains(biomeListNegXNegZ, Type.OCEAN) && !ArrayUtils.contains(biomeListNegXNegZ, Type.BEACH) && !ArrayUtils.contains(biomeListNegXNegZ, Type.SWAMP)
					&& !ArrayUtils.contains(biomeListPosXNegZ, Type.OCEAN) && !ArrayUtils.contains(biomeListPosXNegZ, Type.BEACH) && !ArrayUtils.contains(biomeListPosXNegZ, Type.SWAMP)
					&& !ArrayUtils.contains(biomeListNegXPosZ, Type.OCEAN) && !ArrayUtils.contains(biomeListNegXPosZ, Type.BEACH) && !ArrayUtils.contains(biomeListNegXPosZ, Type.SWAMP)) {

				int baseX = regionX * spacing + regionRand.nextInt(spacing);
				int baseZ = regionZ * spacing + regionRand.nextInt(spacing);
				int yBase = 30;

				//Make sure generator runs only in the chunk containing baseX/baseZ
				if ((x >> 4) == (baseX >> 4) && (z >> 4) == (baseZ >> 4)) {
					//If baseX and baseZ coords are less than 5k in x or z fail to generate
					if (Math.abs(baseX) < 5000 && Math.abs(baseZ) < 5000) return;

					int x1 = baseX + regionRand.nextInt(8) + 8;
					int y1 = yBase;
					int z1 = baseZ + regionRand.nextInt(8) + 8;

					int x2 = x1 + 36;
					int y2 = 18;
					int z2 = z1 + 36;

					System.out.println("Ancient City generating at (X:" + x2 + ", Z:" + z2 + ")");

					//There are way better ways to do this but for now this works, first clears out a regions with air blocks so the structure can be placed
					new AncientCitySphereGen().generate(world, rand, x2, y1, z2);
					new AncientCitySphereGen().generate(world, rand, x2, y1 + 3, z2);

					new AncientCitySphereGen().generate(world, rand, x2 + 12, y1, z2);
					new AncientCitySphereGen().generate(world, rand, x2 - 12, y1, z2);
					new AncientCitySphereGen().generate(world, rand, x2, y1, z2 + 12);
					new AncientCitySphereGen().generate(world, rand, x2, y1, z2 - 12);

					new AncientCitySphereGen().generate(world, rand, x2 + 12, y1, z2 + 12);
					new AncientCitySphereGen().generate(world, rand, x2 - 12, y1, z2 + 12);
					new AncientCitySphereGen().generate(world, rand, x2 + 12, y1, z2 - 12);
					new AncientCitySphereGen().generate(world, rand, x2 - 12, y1, z2 - 12);

					new AncientCitySphereGen().generate(world, rand, x2 + 24, y1, z2 + 12);
					new AncientCitySphereGen().generate(world, rand, x2 - 24, y1, z2 + 12);
					new AncientCitySphereGen().generate(world, rand, x2 + 24, y1, z2 - 12);
					new AncientCitySphereGen().generate(world, rand, x2 - 24, y1, z2 - 12);

					new AncientCitySphereGen().generate(world, rand, x2 + 36, y1, z2 + 12);
					new AncientCitySphereGen().generate(world, rand, x2 - 36, y1, z2 + 12);
					new AncientCitySphereGen().generate(world, rand, x2 + 36, y1, z2 - 12);
					new AncientCitySphereGen().generate(world, rand, x2 - 36, y1, z2 - 12);

					new AncientCitySphereGen().generate(world, rand, x2 + 48, y1, z2 + 12);
					new AncientCitySphereGen().generate(world, rand, x2 - 48, y1, z2 + 12);
					new AncientCitySphereGen().generate(world, rand, x2 + 48, y1, z2 - 12);
					new AncientCitySphereGen().generate(world, rand, x2 - 48, y1, z2 - 12);

					new AncientCitySphereGen().generate(world, rand, x2 + 60, y1, z2 + 12);
					new AncientCitySphereGen().generate(world, rand, x2 - 60, y1, z2 + 12);
					new AncientCitySphereGen().generate(world, rand, x2 + 60, y1, z2 - 12);
					new AncientCitySphereGen().generate(world, rand, x2 - 60, y1, z2 - 12);

					new AncientCitySphereGen().generate(world, rand, x2 + 72, y1, z2 + 12);
					new AncientCitySphereGen().generate(world, rand, x2 - 72, y1, z2 + 12);
					new AncientCitySphereGen().generate(world, rand, x2 + 72, y1, z2 - 12);
					new AncientCitySphereGen().generate(world, rand, x2 - 72, y1, z2 - 12);

					new AncientCitySphereGen().generate(world, rand, x2 + 84, y1, z2 + 12);
					new AncientCitySphereGen().generate(world, rand, x2 - 84, y1, z2 + 12);
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

					new AncientCityCelingSculkGen().generate(world, rand, x1 + 7, y1 + 14, z1 + 9);
					new AncientCitySculkPortalGen().generate(world, rand, x1 + 14, y1 - 10, z1 + 14);
					new AncientCityUnknownActivationGen().generate(world, rand, x1 + 19, y1 - 3, z1 + 30);

					new AncientCityLargeHangingStructureGen().generate(world, rand, x1 + 75, y1 + 3, z1 + 29);
					new AncientCitySmallHangingStructure1Gen().generate(world, rand, x1 + 63, y1 + 2, z1 + 68);
					new AncientCitySmallHangingStructure2Gen().generate(world, rand, x1 + 63, y1 + 2, z1);
					new AncientCitySmallHangingStructure3Gen().generate(world, rand, x1 + 27, y1 + 3, z1 + 77);
					new AncientCityMediumHangingStructureGen().generate(world, rand, x1 + 25, y1 + 3, z1 - 18);

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

					new AncientCityCrystalFarmGen().generate(world, rand, x1 - 68, y1 - 16, z1 - 31); //DONE

					//Additional Random Structures
					new AncientCityColumnTopGen().generate(world, rand, x1 + 54, y1 + 15, z1 + 122);
					new AncientCityColumnGen1().generate(world, rand, x1 + 54, y1 - 16, z1 + 122);
					new AncientCityColumnGen2().generate(world, rand, x1 + 54, y1 - 16, z1 + 122);
					new AncientCityColumnGen3().generate(world, rand, x1 + 54, y1 - 16, z1 + 122);
					new AncientCityColumnBottomGen().generate(world, rand, x1 + 54, y1 - 26, z1 + 122);

					new AncientCitySupportGen().generate(world, rand, x1 + 69, y1 - 17, z1 - 40);
					new AncientCitySupportTopGen().generate(world, rand, x1 + 66, y1 + 14, z1 - 43);

					new AncientCitySupportGen().generate(world, rand, x1 - 45, y1 - 17, z1 - 36);
					new AncientCitySupportTopGen().generate(world, rand, x1 - 48, y1 + 14, z1 - 39);

					new AncientCitySupportGen().generate(world, rand, x1 - 159, y1 - 17, z1 - 40);
					new AncientCitySupportTopGen().generate(world, rand, x1 - 162, y1 + 14, z1 - 43);

					new AncientCitySupportGen().generate(world, rand, x1 - 56, y1 - 17, z1 + 122);
					new AncientCitySupportTopGen().generate(world, rand, x1 - 69, y1 + 14, z1 + 119);

					new AncientCitySculkPatchGen().generate(world, rand, x1 - 59, y1 - 17, z1 - 31);
					new AncientCitySculkPatchGen2().generate(world, rand, x1 - 22, y1 - 17, z1 - 57);
					new AncientCitySculkPatchGen3().generate(world, rand, x1 + 108, y1 - 17, z1 + 62);

					new AncientCitySculkCeilingGen().generate(world, rand, x1 - 52, y1 + 16, z1 + 40);
					new AncientCitySculkCeilingGen().generate(world, rand, x1 + 82, y1 + 16, z1 + 20);
					new AncientCitySculkCeiling2Gen().generate(world, rand, x1 - 48, y1 + 16, z1 + 5);
					new AncientCitySculkCeiling2Gen().generate(world, rand, x1 - 11, y1 + 16, z1 - 66);
					new AncientCitySculkCeiling3Gen().generate(world, rand, x1 - 15, y1 + 16, z1 + 84);

					new AncientCityObservationTowerGen().generate(world, rand, x1 - 52, y1 - 17, z1 + 80);

					new AncientCitySculkWallNegXPosZGen().generate(world, rand, x1 + 139, y1 - 10, z1 - 83);

					new AncientCitySculkWallPosXGen().generate(world, rand, x1 + 20, y1 - 16, z1 + 151);

					new AncientCitySculkWallNegZGen1().generate(world, rand, x1 - 51, y1 - 17, z1 - 107);
					new AncientCitySculkWallNegZGen2().generate(world, rand, x1 - 51, y1 - 17, z1 - 107);

					new AncientCitySculkWallNegXGen().generate(world, rand, x1 - 129, y1 - 15, z1 + 15);

					new AncientCitySculkWallPosX2Gen().generate(world, rand, x1 + 144, y1 - 15, z1 + 21);

				}
			}
		}
	}
}
