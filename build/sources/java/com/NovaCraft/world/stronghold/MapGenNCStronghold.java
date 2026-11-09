package com.NovaCraft.world.stronghold;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import com.NovaCraft.config.Configs;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.structure.MapGenStronghold;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureStart;

public class MapGenNCStronghold extends MapGenStronghold {
    public static ArrayList<BiomeGenBase> allowedBiomes = new ArrayList<BiomeGenBase>(Arrays.asList(BiomeGenBase.desert, BiomeGenBase.forest,BiomeGenBase.extremeHills));
    private BiomeGenBase[] allowedBiomeGenBases;

    private boolean ranBiomeCheck;
    private ChunkCoordIntPair[] structureCoords;
    private double field_82671_h;
    private int field_82672_i;

    public MapGenNCStronghold() {
        allowedBiomeGenBases = allowedBiomes.toArray(new BiomeGenBase[0]);
        structureCoords = new ChunkCoordIntPair[3]; //Three Strongholds per world
        field_82671_h = 128.0D;
        field_82672_i = 3;
    }

    @SuppressWarnings("rawtypes")
    public MapGenNCStronghold(Map par1Map) {
        this();
        Iterator var2 = par1Map.entrySet().iterator();

        while (var2.hasNext()) {
            Entry var3 = (Entry)var2.next();

            if (((String)var3.getKey()).equals("distance"))
                field_82671_h = MathHelper.parseDoubleWithDefaultAndMax((String)var3.getValue(), field_82671_h, 1.0D);
            else if (((String)var3.getKey()).equals("count"))
                structureCoords = new ChunkCoordIntPair[MathHelper.parseIntWithDefaultAndMax((String)var3.getValue(), structureCoords.length, 1)];
            else if (((String)var3.getKey()).equals("spread"))
                field_82672_i = MathHelper.parseIntWithDefaultAndMax((String)var3.getValue(), field_82672_i, 1);
        }
    }


    @Override
    public String func_143025_a() {
        return "Stronghold";
    }

    @Override
    protected boolean canSpawnStructureAtCoords(int chunkX, int chunkZ) {
        if (worldObj == null || worldObj.provider.dimensionId != 0) {
            return false;
        }

        initializeStructureCoords();

        for (ChunkCoordIntPair coord : structureCoords) {
            if (coord != null && chunkX == coord.chunkXPos && chunkZ == coord.chunkZPos) {
                return true;
            }
        }

        return false;
    }

    @Override
    @SuppressWarnings({ "rawtypes", "unchecked" })
    protected List getCoordList()
    {
        initializeStructureCoords();

        List coordinates = new ArrayList();

        for (ChunkCoordIntPair coord : structureCoords)
        {
            if (coord != null)
            {
                coordinates.add(coord.func_151349_a(64));
            }
        }

        return coordinates;
    }

    @Override
    protected StructureStart getStructureStart(int par1, int par2) {
        MapGenNCStronghold.Start start;

        for (start = new MapGenNCStronghold.Start(worldObj, rand, par1, par2); start.getComponents().isEmpty() || ((NCStructureStrongholdPieces.NCStairs2)start.getComponents().get(0)).strongholdNCPortalRoom == null; start = new MapGenNCStronghold.Start(worldObj, rand, par1, par2)) ;

        return start;
    }

    public static class Start extends StructureStart {

        public Start() {}

        @SuppressWarnings({ "unchecked", "rawtypes" })
        public Start(World par1World, Random par2Random, int par3, int par4) {
            super(par3, par4);
            NCStructureStrongholdPieces.prepareStructurePieces();
            NCStructureStrongholdPieces.NCStairs2 stairs2 = new NCStructureStrongholdPieces.NCStairs2(0, par2Random, (par3 << 4) + 2, (par4 << 4) + 2);
            components.add(stairs2);
            stairs2.buildComponent(stairs2, components, par2Random);
            List list = stairs2.field_75026_c;

            while (!list.isEmpty()) {
                int k = par2Random.nextInt(list.size());
                StructureComponent structurecomponent = (StructureComponent)list.remove(k);
                structurecomponent.buildComponent(stairs2, components, par2Random);
            }

            updateBoundingBox();
        }
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    private void initializeStructureCoords() {
        if (ranBiomeCheck || worldObj == null) {
            return;
        }

        Random random = new Random(worldObj.getSeed());
        double angle = random.nextDouble() * Math.PI * 2.0D;
        int ring = 1;
        int spread = field_82672_i;

        ArrayList biomeList = new ArrayList();
        biomeList.addAll(Arrays.asList(allowedBiomeGenBases));

        for (int index = 0; index < structureCoords.length; ++index) {

            //Make it so the strongholds can only generate beyond 2k from 0,0
            double distanceChunks = 125.0D + random.nextDouble() * field_82671_h;

            int chunkX = (int)Math.round(Math.cos(angle) * distanceChunks);

            int chunkZ = (int)Math.round(Math.sin(angle) * distanceChunks);

            ChunkPosition biomePosition = worldObj.getWorldChunkManager().findBiomePosition((chunkX << 4) + 8, (chunkZ << 4) + 8, 112, biomeList, random);

            if (biomePosition != null) {
                chunkX = biomePosition.chunkPosX >> 4;
                chunkZ = biomePosition.chunkPosY >> 4;
            }

            structureCoords[index] = new ChunkCoordIntPair(chunkX, chunkZ);

            if (Configs.enableDebugMode) {
                System.out.println("NC stronghold position: chunk " + chunkX + ", " + chunkZ + "; block " + ((chunkX << 4) + 8) + ", " + ((chunkZ << 4) + 8));
            }

            angle += Math.PI * 2.0D * ring / spread;

            if (index == spread) {
                ring += 2 + random.nextInt(5);
                spread += 1 + random.nextInt(2);
            }
        }

        ranBiomeCheck = true;
    }
}
