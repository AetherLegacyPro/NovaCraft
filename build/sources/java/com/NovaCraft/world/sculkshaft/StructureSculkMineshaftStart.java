package com.NovaCraft.world.sculkshaft;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureStart;

public class StructureSculkMineshaftStart extends StructureStart {

	public StructureSculkMineshaftStart() {
	}

	public StructureSculkMineshaftStart(World world, Random rand, int chunkX, int chunkZ) {
		super(chunkX, chunkZ);

		StructureSculkMineshaftPieces.registerStructurePieces();

		StructureSculkMineshaftPieces.Room room = new StructureSculkMineshaftPieces.Room(0, rand, (chunkX << 4) + 2, (chunkZ << 4) + 2);

		this.components.add(room);

		room.buildComponent(room, this.components, rand);

		this.updateBoundingBox();

		this.markAvailableHeight(world, rand, 10);
	}
}
