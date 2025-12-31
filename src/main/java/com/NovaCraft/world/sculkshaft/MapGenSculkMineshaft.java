package com.NovaCraft.world.sculkshaft;

import java.util.Random;
import net.minecraft.world.gen.structure.MapGenMineshaft;
import net.minecraft.world.gen.structure.StructureStart;

public class MapGenSculkMineshaft extends MapGenMineshaft {

	@Override
	protected StructureStart getStructureStart(int chunkX, int chunkZ) {
		Random rand = new Random(this.worldObj.getSeed() ^ ((long)chunkX << 32) ^ chunkZ);

		if (rand.nextInt(4) == 0) {
			return new StructureSculkMineshaftStart(this.worldObj, rand, chunkX, chunkZ);
		}

		return super.getStructureStart(chunkX, chunkZ);
	}
}
