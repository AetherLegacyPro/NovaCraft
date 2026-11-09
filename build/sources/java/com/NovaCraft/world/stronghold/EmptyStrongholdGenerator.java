package com.NovaCraft.world.stronghold;

import net.minecraft.world.gen.structure.MapGenStronghold;
import net.minecraft.world.gen.structure.StructureStart;

//An empty class so technically the stronghold still generates, but it generates nothing
//Trying to remove it caused worlds to crash on startup so this is a workaround
public class EmptyStrongholdGenerator extends MapGenStronghold {

    //Vanilla constructor
    public EmptyStrongholdGenerator() {
        super();
    }

    //Never allow generation
    @Override
    protected boolean canSpawnStructureAtCoords(int x, int z) {
        return false;
    }

    //No structure
    @Override
    protected StructureStart getStructureStart(int x, int z) {
        return null;
    }
}
