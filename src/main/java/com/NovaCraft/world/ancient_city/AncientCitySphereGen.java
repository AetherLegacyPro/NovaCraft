package com.NovaCraft.world.ancient_city;

import net.minecraft.world.gen.feature.*;
import net.minecraft.block.*;
import net.minecraft.world.*;
import java.util.*;

import com.NovaCraft.registry.OtherModBlocks;
import com.NovaCraftBlocks.NovaCraftBlocks;

import net.minecraft.init.*;

public class AncientCitySphereGen extends WorldGenerator
{
	public AncientCitySphereGen() {

	}
    
    public boolean generate(final World world, final Random random, final int x, final int y, final int z) {
    	
    	//int centerX = x;
        //int centerY = y;
        //int centerZ = z;

        for (int x1 = - 55; x1 <= 55; x1++) {
            for (int y1 = - 17; y1 <=  17; y1++) {
                for (int z1 = - 55; z1 <= 55; z1++) {
                    // Calculate the ellipsoid formula
                    double ellipsoidEquation = (Math.pow(x1, 2) / Math.pow(55, 2)) +
                                               (Math.pow(y1, 2) / Math.pow(17, 2)) +
                                               (Math.pow(z1, 2) / Math.pow(55, 2));
                    
                    // Check if the point is inside the ellipsoid
                    if (ellipsoidEquation <= 1.0) {
                        world.setBlock(x + x1, y + y1, z + z1, Blocks.air);
                    }
                }
            }
        }
    	
    	
    	return true;
    }

}
