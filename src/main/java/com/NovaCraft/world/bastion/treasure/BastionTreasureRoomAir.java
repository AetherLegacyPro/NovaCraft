package com.NovaCraft.world.bastion.treasure;

import net.minecraft.world.gen.feature.*;
import net.minecraft.block.*;
import net.minecraft.world.*;
import java.util.*;

import com.NovaCraft.registry.OtherModBlocks;
import com.NovaCraftBlocks.NovaCraftBlocks;

import net.minecraft.init.*;

public class BastionTreasureRoomAir extends WorldGenerator
{
	public BastionTreasureRoomAir() {

	}
    
	@Override
    public boolean generate(final World world, final Random random, final int x, final int y, final int z) {
        int sizeX = 38;
        int sizeY = 48;
        int sizeZ = 38;

        for (int dx = 0; dx < sizeX; dx++) {
            for (int dy = 0; dy < sizeY; dy++) {
                for (int dz = 0; dz < sizeZ; dz++) {
                    world.setBlock(x + dx, y + dy, z + dz, Blocks.air);
                }
            }
        }

        return true;
    }

}
