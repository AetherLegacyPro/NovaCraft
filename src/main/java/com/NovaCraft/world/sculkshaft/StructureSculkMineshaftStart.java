package com.NovaCraft.world.sculkshaft;

import java.util.LinkedList;
import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureMineshaftStart;
import net.minecraft.world.gen.structure.StructureStart;

public class StructureSculkMineshaftStart extends StructureStart {

		public StructureSculkMineshaftStart() {}

		@SuppressWarnings("unchecked")
		public StructureSculkMineshaftStart(World par1World, Random par2Random, int par3, int par4) {
			super(par3, par4);
			StructureSculkMineshaftPieces.Room room = new StructureSculkMineshaftPieces.Room(0, par2Random, (par3 << 4) + 2, (par4 << 4) + 2);
			components.add(room);
			room.buildComponent(room, components, par2Random);
			updateBoundingBox();
			markAvailableHeight(par1World, par2Random, 10);
		}

}
