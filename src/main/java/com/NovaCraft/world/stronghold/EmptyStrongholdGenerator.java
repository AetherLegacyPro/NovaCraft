package com.NovaCraft.world.stronghold;

import net.minecraft.world.World;
import net.minecraft.world.gen.structure.MapGenStronghold;
import net.minecraft.world.gen.structure.MapGenStructure;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureStart;
import java.util.Random;

//An empty class so technically the stronghold still generates, but it generates nothing
//Trying to remove it caused worlds to crash on startup so this is a workaround
public class EmptyStrongholdGenerator extends MapGenStronghold {

    public EmptyStrongholdGenerator() {
        super(); // vanilla constructor
    }

    @Override
    protected boolean canSpawnStructureAtCoords(int x, int z) {
        return false; // never allow generation
    }

    @Override
    protected StructureStart getStructureStart(int x, int z) {
        return null; // no structure
    }
}
