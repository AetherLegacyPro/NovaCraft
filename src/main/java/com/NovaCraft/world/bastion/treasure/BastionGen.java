package com.NovaCraft.world.bastion.treasure;

import java.util.Random;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;

public class BastionGen implements IWorldGenerator {

	@Override
	public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		if (world.provider.dimensionId == -1) {
	         this.generateNether(world, rand, chunkX * 16, chunkZ * 16);
	      }
	   }
	
	public void generateNether(World world, Random rand, int x, int z) {
		if(Math.abs(x) < 500 && Math.abs(z) < 500) return;
		
		
		if (rand.nextInt(500) == 25) {
		int x1 = x + rand.nextInt(16) + 8;
  	  	int y1 = 27;
  	  	int z1 = z + rand.nextInt(16) + 8;
  	  	
  	  	if (!(world.isAirBlock(x1, y1 + 4, z1)) && !(world.isAirBlock(x1 + 38, y1 + 4, z1)) && !(world.isAirBlock(x1 + 38, y1 + 4, z1 - 38)) && !(world.isAirBlock(x1, y1 + 4, z1 - 38))
  	  		&& world.getBlock(x1 - 1, y1 + 4, z1) == Blocks.lava) {
		new BastionTreasureRoomAir().generate(world, rand, x1, y1 + 5, z1);
		
		new BastionTreasureRoomGen1().generate(world, rand, x1, y1 + 5, z1);
		new BastionTreasureRoomGen2().generate(world, rand, x1, y1 + 5, z1);
		new BastionTreasureRoomGen3().generate(world, rand, x1, y1 + 5, z1);
		new BastionTreasureRoomGen4().generate(world, rand, x1, y1 + 5, z1);
		new BastionTreasureRoomGen5().generate(world, rand, x1, y1 + 5, z1);
		new BastionTreasureRoomGen6().generate(world, rand, x1, y1 + 5, z1);
		new BastionTreasureRoomGen7().generate(world, rand, x1, y1 + 5, z1);
		new BastionTreasureRoomGen8().generate(world, rand, x1, y1 + 5, z1);
		new BastionTreasureRoomGen9().generate(world, rand, x1, y1 + 5, z1);
		new BastionTreasureRoomGen10().generate(world, rand, x1, y1 + 5, z1);
		new BastionTreasureRoomGen11().generate(world, rand, x1, y1 + 5, z1);
		new BastionTreasureRoomGen12().generate(world, rand, x1, y1 + 5, z1);
		
		new BastionSerpentQueenLairGen().generate(world, rand, x1 + 11, y1 - 3, z1 + 11);
		new BastionTunnelToLairGen().generate(world, rand, x1 + 17, y1 + 1, z1 + 17);
		new BastionTunnelToLairGen().generate(world, rand, x1 + 17, y1 + 5, z1 + 17);
		
		new BastionTreasureBridgeGen1().generate(world, rand, x1 - 2, y1 + 2, z1 - 19);
		new BastionTreasureBridgeGen2().generate(world, rand, x1 - 2, y1 + 2, z1 - 19);
		new BastionTreasureBridgeGen3().generate(world, rand, x1 - 2, y1 + 2, z1 - 19);
		new BastionTreasureBridgeGen4().generate(world, rand, x1 - 2, y1 + 2, z1 - 19);
		new BastionTreasureBridgeGen5().generate(world, rand, x1 - 2, y1 + 2, z1 - 19);
		new BastionTreasureBridgeGen6().generate(world, rand, x1 - 2, y1 + 2, z1 - 19);
		new BastionTreasureBridgeGen7().generate(world, rand, x1 - 2, y1 + 2, z1 - 19);
		new BastionTreasureBridgeGen8().generate(world, rand, x1 - 2, y1 + 2, z1 - 19);
		new BastionTreasureBridgeGen9().generate(world, rand, x1 - 2, y1 + 2, z1 - 19);
		new BastionTreasureBridgeGen10().generate(world, rand, x1 - 2, y1 + 2, z1 - 19);
		
		new BastionTreasureBarracksGen1().generate(world, rand, x1 - 2, y1 + 2, z1 - 32);
		new BastionTreasureBarracksGen2().generate(world, rand, x1 - 2, y1 + 2, z1 - 32);
		new BastionTreasureBarracksGen3().generate(world, rand, x1 - 2, y1 + 2, z1 - 32);
		new BastionTreasureBarracksGen4().generate(world, rand, x1 - 2, y1 + 2, z1 - 32);
		new BastionTreasureBarracksGen5().generate(world, rand, x1 - 2, y1 + 2, z1 - 32);
		new BastionTreasureBarracksGen6().generate(world, rand, x1 - 2, y1 + 2, z1 - 32);
		new BastionTreasureBarracksGen7().generate(world, rand, x1 - 2, y1 + 2, z1 - 32);
		new BastionTreasureBarracksGen8().generate(world, rand, x1 - 2, y1 + 2, z1 - 32);
		new BastionTreasureBarracksGen9().generate(world, rand, x1 - 2, y1 + 2, z1 - 32);
		new BastionTreasureBarracksGen10().generate(world, rand, x1 - 2, y1 + 2, z1 - 32);
		new BastionTreasureBarracksGen11().generate(world, rand, x1 - 2, y1 + 2, z1 - 32);
  	  	
  	  	}
		
		}
	}
	
}
