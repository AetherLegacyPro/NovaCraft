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
    	
    	int radius = 25;
    	int centre = radius / 2, squareDistance;
    	int x1, y1, z1;

    	for(x1 = centre - radius; x1 < (centre + radius) * 20; x1++){
    		for(y1 = centre - radius; y1 < centre + radius; y1++){
    			for(z1 = centre - radius; z1 < (centre + radius) * 20; z1++) {
    				squareDistance = (x1 -centre) * (x1 -centre) + (y1-centre) * (y1-centre) + (z1-centre) * (z1-centre);
    				if(squareDistance <= (radius) * (radius))
    					world.setBlock(x + x1, y + y1, z + z1, Blocks.air, 0, 2);
    			}
    		}
    	}
    	
    	
    	return true;
    }

}
