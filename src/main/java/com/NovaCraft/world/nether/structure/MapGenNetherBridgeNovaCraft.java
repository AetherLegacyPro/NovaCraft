package com.NovaCraft.world.nether.structure;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.MapGenStructure;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureStart;

public class MapGenNetherBridgeNovaCraft extends MapGenStructure
{
    private List spawnList = new ArrayList();
    
    @Override
    public String func_143025_a()
    {
        return "NovaFortress";
    }

    public List getSpawnList()
    {
        return this.spawnList;
    }

    protected boolean canSpawnStructureAtCoords(int p_75047_1_, int p_75047_2_)
    {
        int k = p_75047_1_ >> 4; // no idea what these values do exactly
        int l = p_75047_2_ >> 4; //4
        this.rand.setSeed((long)(k ^ l << 4) ^ this.worldObj.getSeed());
        this.rand.nextInt();
        return this.rand.nextInt(8) != 0 ? false : (p_75047_1_ != (k << 4) + 4 + this.rand.nextInt(8) ? false : p_75047_2_ == (l << 4) + 4 + this.rand.nextInt(8)); //these alter the placement from my testing, makes it so they do not generate over standard fortresses
        						//3																	//8															//8
        						//7																	//12														//12
        						//18																//8															//18
    }

    protected StructureStart getStructureStart(int p_75049_1_, int p_75049_2_)
    {
        return new MapGenNetherBridgeNovaCraft.Start(this.worldObj, this.rand, p_75049_1_, p_75049_2_);
    }

    public static class Start extends StructureStart {

            public Start() {}

            public Start(World p_i2040_1_, Random p_i2040_2_, int p_i2040_3_, int p_i2040_4_)
            {
                super(p_i2040_3_, p_i2040_4_);
                StructureNovaCraftNetherBridgePieces.Start start = new StructureNovaCraftNetherBridgePieces.Start(p_i2040_2_, (p_i2040_3_ << 4) + 2, (p_i2040_4_ << 4) + 2);
                this.components.add(start);
                start.buildComponent(start, this.components, p_i2040_2_);
                ArrayList arraylist = start.field_74967_d;

                while (!arraylist.isEmpty())
                {
                    int k = p_i2040_2_.nextInt(arraylist.size());
                    StructureComponent structurecomponent = (StructureComponent)arraylist.remove(k);
                    structurecomponent.buildComponent(start, this.components, p_i2040_2_);
                }

                this.updateBoundingBox();
                this.setRandomHeight(p_i2040_1_, p_i2040_2_, 23, 45); //48 70
            }
        }
}
