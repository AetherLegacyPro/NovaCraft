package com.NovaCraft.world.stronghold;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.config.Configs;
import com.NovaCraftBlocks.NovaCraftBlocks;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagFloat;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;

import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraftforge.common.ChestGenHooks;
import static net.minecraftforge.common.ChestGenHooks.*;

public class NCStructureStrongholdPieces
{
    public static final String NC_TREASURE = "nova_craft:stronghold_loot";
    public static final String NC_FURNACE = "nova_craft:stronghold_furnace";

    public static void initLoot() {
        ChestGenHooks info = ChestGenHooks.getInfo(NC_TREASURE);

        info.addItem(new WeightedRandomChestContent(new ItemStack(NovaCraftItems.diamond_nugget, 1, 2), 1, 3, 10));
        info.addItem(new WeightedRandomChestContent(new ItemStack(NovaCraftItems.vanite_ingot, 1, 0), 1, 3, 10));
        info.addItem(new WeightedRandomChestContent(new ItemStack(NovaCraftItems.tsavorokite_shard, 1, 0), 1, 3, 10));
        info.addItem(new WeightedRandomChestContent(new ItemStack(Items.iron_ingot, 1, 0), 2, 3, 10));
        info.addItem(new WeightedRandomChestContent(new ItemStack(Items.gold_ingot, 1, 0), 2, 3, 10));
        info.addItem(new WeightedRandomChestContent(new ItemStack(Items.paper, 1, 0), 1, 3, 20));
        info.addItem(new WeightedRandomChestContent(new ItemStack(Items.redstone, 1, 0), 1, 3, 20));
        info.addItem(new WeightedRandomChestContent(new ItemStack(Items.diamond, 1, 0), 1, 1, 3));
        info.addItem(new WeightedRandomChestContent(new ItemStack(Items.emerald, 1, 0), 1, 1, 3));
        info.addItem(new WeightedRandomChestContent(new ItemStack(Items.ender_pearl, 2, 0), 1, 3, 5));
        info.addItem(new WeightedRandomChestContent(new ItemStack(Items.coal, 1, 0), 3, 5, 7));
        info.addItem(new WeightedRandomChestContent(new ItemStack(NovaCraftItems.blazing_coal, 1, 0), 3, 3, 5));
        info.addItem(new WeightedRandomChestContent(new ItemStack(Items.apple, 2, 0), 3, 3, 5));
        info.addItem(new WeightedRandomChestContent(new ItemStack(Items.diamond_sword, 1, 0), 1, 1, 2));
        info.addItem(new WeightedRandomChestContent(new ItemStack(NovaCraftItems.echo_shard, 1, 0), 1, 1, 2));
        info.addItem(new WeightedRandomChestContent(new ItemStack(NovaCraftItems.pherithium_pickaxe, 1, 0), 1, 1, 2));
        info.addItem(new WeightedRandomChestContent(new ItemStack(NovaCraftItems.pherithium_axe, 1, 0), 1, 1, 2));
        info.addItem(new WeightedRandomChestContent(new ItemStack(Items.bone, 1, 0), 1, 4, 6));
        info.addItem(new WeightedRandomChestContent(new ItemStack(Items.golden_apple, 1, 1), 1, 1, 2));
        info.addItem(new WeightedRandomChestContent(new ItemStack(Items.golden_apple, 1, 0), 1, 3, 4));

        info.setMin(3);
        info.setMax(7);
    }

    public static void initFurnace() {
        ChestGenHooks info = ChestGenHooks.getInfo(NC_FURNACE);

        info.addItem(new WeightedRandomChestContent(new ItemStack(Items.iron_ingot, 1, 0), 2, 3, 10));
        info.addItem(new WeightedRandomChestContent(new ItemStack(Items.gold_ingot, 1, 0), 2, 3, 10));
        info.addItem(new WeightedRandomChestContent(new ItemStack(NovaCraftItems.diamond_nugget, 1, 2), 1, 3, 10));
        info.addItem(new WeightedRandomChestContent(new ItemStack(NovaCraftItems.diamond_nugget, 1, 1), 1, 3, 10));
        info.addItem(new WeightedRandomChestContent(new ItemStack(NovaCraftItems.diamond_nugget, 1, 0), 1, 3, 10));
        info.addItem(new WeightedRandomChestContent(new ItemStack(NovaCraftItems.vanite_bucket, 1, 0), 1, 5, 7));
        info.addItem(new WeightedRandomChestContent(new ItemStack(NovaCraftItems.iridium_nugget, 1, 1), 1, 3, 10));
        info.addItem(new WeightedRandomChestContent(new ItemStack(NovaCraftItems.iridium_nugget, 1, 0), 1, 5, 14));
        info.addItem(new WeightedRandomChestContent(new ItemStack(NovaCraftItems.vanite_ingot, 1, 0), 3, 5, 7));

        info.setMin(4);
        info.setMax(8);
    }

    private static final NCStructureStrongholdPieces.PieceWeight[] pieceWeightArray = new NCStructureStrongholdPieces.PieceWeight[] {new NCStructureStrongholdPieces.PieceWeight(NCStructureStrongholdPieces.NCStraight.class, 40, 0), new NCStructureStrongholdPieces.PieceWeight(NCStructureStrongholdPieces.NCStraightAlternate.class, 20, 0), new NCStructureStrongholdPieces.PieceWeight(NCStructureStrongholdPieces.NCPrison.class, 5, 5), new NCStructureStrongholdPieces.PieceWeight(NCStructureStrongholdPieces.NCLeftTurn.class, 20, 0), new NCStructureStrongholdPieces.PieceWeight(NCStructureStrongholdPieces.NCRightTurn.class, 20, 0), new NCStructureStrongholdPieces.PieceWeight(NCStructureStrongholdPieces.NCRoomCrossing.class, 10, 6), new NCStructureStrongholdPieces.PieceWeight(NCStructureStrongholdPieces.NCStairsStraight.class, 5, 5), new NCStructureStrongholdPieces.PieceWeight(NCStructureStrongholdPieces.NCStairs.class, 5, 5), new NCStructureStrongholdPieces.PieceWeight(NCStructureStrongholdPieces.NCCrossing.class, 5, 4), new NCStructureStrongholdPieces.PieceWeight(NCStructureStrongholdPieces.NCChestNCCorridor.class, 5, 4), new NCStructureStrongholdPieces.PieceWeight(NCStructureStrongholdPieces.NCLibrary.class, 10, 2), new NCStructureStrongholdPieces.PieceWeight(NCStructureStrongholdPieces.NCTreasureRoom.class, 10, 2), new NCStructureStrongholdPieces.PieceWeight(NCStructureStrongholdPieces.NCSpawnerRoom.class, 10, 2), new NCStructureStrongholdPieces.PieceWeight(NCStructureStrongholdPieces.NCCrystalFarm.class, 10, 2), new NCStructureStrongholdPieces.PieceWeight(NCStructureStrongholdPieces.NCFurnaceRoom.class, 10, 2)
    {
        public boolean canSpawnMoreStructuresOfType(int p_75189_1_)
        {
            return super.canSpawnMoreStructuresOfType(p_75189_1_) && p_75189_1_ > 4;
        }
    }, new NCStructureStrongholdPieces.PieceWeight(NCStructureStrongholdPieces.NCPortalRoom.class, 20, 1)
    {
        public boolean canSpawnMoreStructuresOfType(int p_75189_1_)
        {
            return super.canSpawnMoreStructuresOfType(p_75189_1_) && p_75189_1_ > 5;
        }
    }
    };
    private static List structurePieceList;
    private static Class strongComponentType;
    static int totalWeight;
    private static final NCStructureStrongholdPieces.Stones strongholdStones = new NCStructureStrongholdPieces.Stones(null);

    public static void registerStrongholdPieces()
    {
        MapGenStructureIO.func_143031_a(NCStructureStrongholdPieces.NCChestNCCorridor.class, "SHCC");
        MapGenStructureIO.func_143031_a(NCStructureStrongholdPieces.NCCorridor.class, "SHFC");
        MapGenStructureIO.func_143031_a(NCStructureStrongholdPieces.NCCrossing.class, "SH5C");
        MapGenStructureIO.func_143031_a(NCStructureStrongholdPieces.NCLeftTurn.class, "SHLT");
        MapGenStructureIO.func_143031_a(NCStructureStrongholdPieces.NCLibrary.class, "SHLi");
        MapGenStructureIO.func_143031_a(NCStructureStrongholdPieces.NCCrystalFarm.class, "SHCr");
        MapGenStructureIO.func_143031_a(NCStructureStrongholdPieces.NCPortalRoom.class, "SHPR");
        MapGenStructureIO.func_143031_a(NCStructureStrongholdPieces.NCFurnaceRoom.class, "SHFR");
        MapGenStructureIO.func_143031_a(NCStructureStrongholdPieces.NCSpawnerRoom.class, "SHSR");
        MapGenStructureIO.func_143031_a(NCStructureStrongholdPieces.NCTreasureRoom.class, "SHTR");
        MapGenStructureIO.func_143031_a(NCStructureStrongholdPieces.NCPrison.class, "SHPH");
        MapGenStructureIO.func_143031_a(NCStructureStrongholdPieces.NCRightTurn.class, "SHRT");
        MapGenStructureIO.func_143031_a(NCStructureStrongholdPieces.NCRoomCrossing.class, "SHRC");
        MapGenStructureIO.func_143031_a(NCStructureStrongholdPieces.NCStairs.class, "SHSD");
        MapGenStructureIO.func_143031_a(NCStructureStrongholdPieces.NCStairs2.class, "SHStart");
        MapGenStructureIO.func_143031_a(NCStructureStrongholdPieces.NCStraight.class, "SHS");
        MapGenStructureIO.func_143031_a(NCStructureStrongholdPieces.NCStraightAlternate.class, "SHSA");
        MapGenStructureIO.func_143031_a(NCStructureStrongholdPieces.NCStairsStraight.class, "SHSSD");
    }

    public static void prepareStructurePieces()
    {
        structurePieceList = new ArrayList();
        NCStructureStrongholdPieces.PieceWeight[] apieceweight = pieceWeightArray;
        int i = apieceweight.length;

        for (int j = 0; j < i; ++j)
        {
            NCStructureStrongholdPieces.PieceWeight pieceweight = apieceweight[j];
            pieceweight.instancesSpawned = 0;
            structurePieceList.add(pieceweight);
        }

        strongComponentType = null;
    }

    private static boolean canAddStructurePieces()
    {
        boolean flag = false;
        totalWeight = 0;
        NCStructureStrongholdPieces.PieceWeight pieceweight;

        for (Iterator iterator = structurePieceList.iterator(); iterator.hasNext(); totalWeight += pieceweight.pieceWeight)
        {
            pieceweight = (NCStructureStrongholdPieces.PieceWeight)iterator.next();

            if (pieceweight.instancesLimit > 0 && pieceweight.instancesSpawned < pieceweight.instancesLimit)
            {
                flag = true;
            }
        }

        return flag;
    }

    private static NCStructureStrongholdPieces.Stronghold getStrongholdComponentFromWeightedPiece(Class p_75200_0_, List p_75200_1_, Random p_75200_2_, int p_75200_3_, int p_75200_4_, int p_75200_5_, int p_75200_6_, int p_75200_7_)
    {
        Object object = null;

        if (p_75200_0_ == NCStructureStrongholdPieces.NCStraight.class)
        {
            object = NCStructureStrongholdPieces.NCStraight.findValidPlacement(p_75200_1_, p_75200_2_, p_75200_3_, p_75200_4_, p_75200_5_, p_75200_6_, p_75200_7_);
        }
        else if (p_75200_0_ == NCStructureStrongholdPieces.NCStraightAlternate.class)
        {
            object = NCStructureStrongholdPieces.NCStraightAlternate.findValidPlacement(p_75200_1_, p_75200_2_, p_75200_3_, p_75200_4_, p_75200_5_, p_75200_6_, p_75200_7_);
        }
        else if (p_75200_0_ == NCStructureStrongholdPieces.NCPrison.class)
        {
            object = NCStructureStrongholdPieces.NCPrison.findValidPlacement(p_75200_1_, p_75200_2_, p_75200_3_, p_75200_4_, p_75200_5_, p_75200_6_, p_75200_7_);
        }
        else if (p_75200_0_ == NCStructureStrongholdPieces.NCLeftTurn.class)
        {
            object = NCStructureStrongholdPieces.NCLeftTurn.findValidPlacement(p_75200_1_, p_75200_2_, p_75200_3_, p_75200_4_, p_75200_5_, p_75200_6_, p_75200_7_);
        }
        else if (p_75200_0_ == NCStructureStrongholdPieces.NCRightTurn.class)
        {
            object = NCStructureStrongholdPieces.NCRightTurn.findValidPlacement(p_75200_1_, p_75200_2_, p_75200_3_, p_75200_4_, p_75200_5_, p_75200_6_, p_75200_7_);
        }
        else if (p_75200_0_ == NCStructureStrongholdPieces.NCRoomCrossing.class)
        {
            object = NCStructureStrongholdPieces.NCRoomCrossing.findValidPlacement(p_75200_1_, p_75200_2_, p_75200_3_, p_75200_4_, p_75200_5_, p_75200_6_, p_75200_7_);
        }
        else if (p_75200_0_ == NCStructureStrongholdPieces.NCStairsStraight.class)
        {
            object = NCStructureStrongholdPieces.NCStairsStraight.findValidPlacement(p_75200_1_, p_75200_2_, p_75200_3_, p_75200_4_, p_75200_5_, p_75200_6_, p_75200_7_);
        }
        else if (p_75200_0_ == NCStructureStrongholdPieces.NCStairs.class)
        {
            object = NCStructureStrongholdPieces.NCStairs.getStrongholdStairsComponent(p_75200_1_, p_75200_2_, p_75200_3_, p_75200_4_, p_75200_5_, p_75200_6_, p_75200_7_);
        }
        else if (p_75200_0_ == NCStructureStrongholdPieces.NCCrossing.class)
        {
            object = NCStructureStrongholdPieces.NCCrossing.findValidPlacement(p_75200_1_, p_75200_2_, p_75200_3_, p_75200_4_, p_75200_5_, p_75200_6_, p_75200_7_);
        }
        else if (p_75200_0_ == NCStructureStrongholdPieces.NCChestNCCorridor.class)
        {
            object = NCStructureStrongholdPieces.NCChestNCCorridor.findValidPlacement(p_75200_1_, p_75200_2_, p_75200_3_, p_75200_4_, p_75200_5_, p_75200_6_, p_75200_7_);
        }
        else if (p_75200_0_ == NCStructureStrongholdPieces.NCLibrary.class)
        {
            object = NCStructureStrongholdPieces.NCLibrary.findValidPlacement(p_75200_1_, p_75200_2_, p_75200_3_, p_75200_4_, p_75200_5_, p_75200_6_, p_75200_7_);
        }
        else if (p_75200_0_ == NCStructureStrongholdPieces.NCCrystalFarm.class)
        {
            object = NCStructureStrongholdPieces.NCCrystalFarm.findValidPlacement(p_75200_1_, p_75200_2_, p_75200_3_, p_75200_4_, p_75200_5_, p_75200_6_, p_75200_7_);
        }
        else if (p_75200_0_ == NCStructureStrongholdPieces.NCPortalRoom.class)
        {
            object = NCStructureStrongholdPieces.NCPortalRoom.findValidPlacement(p_75200_1_, p_75200_2_, p_75200_3_, p_75200_4_, p_75200_5_, p_75200_6_, p_75200_7_);
        }
        else if (p_75200_0_ == NCStructureStrongholdPieces.NCFurnaceRoom.class)
        {
            object = NCStructureStrongholdPieces.NCFurnaceRoom.findValidPlacement(p_75200_1_, p_75200_2_, p_75200_3_, p_75200_4_, p_75200_5_, p_75200_6_, p_75200_7_);
        }
        else if (p_75200_0_ == NCStructureStrongholdPieces.NCSpawnerRoom.class)
        {
            object = NCStructureStrongholdPieces.NCSpawnerRoom.findValidPlacement(p_75200_1_, p_75200_2_, p_75200_3_, p_75200_4_, p_75200_5_, p_75200_6_, p_75200_7_);
        }
        else if (p_75200_0_ == NCStructureStrongholdPieces.NCTreasureRoom.class)
        {
            object = NCStructureStrongholdPieces.NCTreasureRoom.findValidPlacement(p_75200_1_, p_75200_2_, p_75200_3_, p_75200_4_, p_75200_5_, p_75200_6_, p_75200_7_);
        }

        return (NCStructureStrongholdPieces.Stronghold)object;
    }

    private static NCStructureStrongholdPieces.Stronghold getNextComponent(NCStructureStrongholdPieces.NCStairs2 p_75201_0_, List p_75201_1_, Random p_75201_2_, int p_75201_3_, int p_75201_4_, int p_75201_5_, int p_75201_6_, int p_75201_7_)
    {
        if (!canAddStructurePieces())
        {
            return null;
        }
        else
        {
            if (strongComponentType != null)
            {
                NCStructureStrongholdPieces.Stronghold stronghold = getStrongholdComponentFromWeightedPiece(strongComponentType, p_75201_1_, p_75201_2_, p_75201_3_, p_75201_4_, p_75201_5_, p_75201_6_, p_75201_7_);
                strongComponentType = null;

                if (stronghold != null)
                {
                    return stronghold;
                }
            }

            int k1 = 0;

            while (k1 < 5)
            {
                ++k1;
                int j1 = p_75201_2_.nextInt(totalWeight);
                Iterator iterator = structurePieceList.iterator();

                while (iterator.hasNext())
                {
                    NCStructureStrongholdPieces.PieceWeight pieceweight = (NCStructureStrongholdPieces.PieceWeight)iterator.next();
                    j1 -= pieceweight.pieceWeight;

                    if (j1 < 0)
                    {
                        if (!pieceweight.canSpawnMoreStructuresOfType(p_75201_7_) || pieceweight == p_75201_0_.strongholdPieceWeight)
                        {
                            break;
                        }

                        NCStructureStrongholdPieces.Stronghold stronghold1 = getStrongholdComponentFromWeightedPiece(pieceweight.pieceClass, p_75201_1_, p_75201_2_, p_75201_3_, p_75201_4_, p_75201_5_, p_75201_6_, p_75201_7_);

                        if (stronghold1 != null)
                        {
                            ++pieceweight.instancesSpawned;
                            p_75201_0_.strongholdPieceWeight = pieceweight;

                            if (!pieceweight.canSpawnMoreStructures())
                            {
                                structurePieceList.remove(pieceweight);
                            }

                            return stronghold1;
                        }
                    }
                }
            }

            StructureBoundingBox structureboundingbox = NCStructureStrongholdPieces.NCCorridor.func_74992_a(p_75201_1_, p_75201_2_, p_75201_3_, p_75201_4_, p_75201_5_, p_75201_6_);

            if (structureboundingbox != null && structureboundingbox.minY > 1)
            {
                return new NCStructureStrongholdPieces.NCCorridor(p_75201_7_, p_75201_2_, structureboundingbox, p_75201_6_);
            }
            else
            {
                return null;
            }
        }
    }

    private static StructureComponent getNextValidComponent(NCStructureStrongholdPieces.NCStairs2 p_75196_0_, List p_75196_1_, Random p_75196_2_, int p_75196_3_, int p_75196_4_, int p_75196_5_, int p_75196_6_, int p_75196_7_)
    {
        if (p_75196_7_ > 50)
        {
            return null;
        }
        else if (Math.abs(p_75196_3_ - p_75196_0_.getBoundingBox().minX) <= 112 && Math.abs(p_75196_5_ - p_75196_0_.getBoundingBox().minZ) <= 112)
        {
            NCStructureStrongholdPieces.Stronghold stronghold = getNextComponent(p_75196_0_, p_75196_1_, p_75196_2_, p_75196_3_, p_75196_4_, p_75196_5_, p_75196_6_, p_75196_7_ + 1);

            if (stronghold != null)
            {
                p_75196_1_.add(stronghold);
                p_75196_0_.field_75026_c.add(stronghold);
            }

            return stronghold;
        }
        else
        {
            return null;
        }
    }

    public static class NCChestNCCorridor extends NCStructureStrongholdPieces.Stronghold
    {
        public static final WeightedRandomChestContent[] strongholdChestContents = new WeightedRandomChestContent[] {new WeightedRandomChestContent(Items.ender_pearl, 0, 1, 1, 10), new WeightedRandomChestContent(Items.diamond, 0, 1, 3, 3), new WeightedRandomChestContent(Items.iron_ingot, 0, 1, 5, 10), new WeightedRandomChestContent(Items.gold_ingot, 0, 1, 3, 5), new WeightedRandomChestContent(NovaCraftItems.larimar_shard, 0, 4, 9, 5), new WeightedRandomChestContent(NovaCraftItems.iridium_nugget, 0, 1, 3, 15), new WeightedRandomChestContent(Items.apple, 0, 1, 3, 15), new WeightedRandomChestContent(Items.diamond_pickaxe, 0, 1, 1, 5), new WeightedRandomChestContent(Items.diamond_sword, 0, 1, 1, 5), new WeightedRandomChestContent(Items.diamond_chestplate, 0, 1, 1, 5), new WeightedRandomChestContent(Items.diamond_helmet, 0, 1, 1, 5), new WeightedRandomChestContent(Items.diamond_leggings, 0, 1, 1, 5), new WeightedRandomChestContent(Items.diamond_boots, 0, 1, 1, 5), new WeightedRandomChestContent(Items.golden_apple, 0, 1, 1, 1), new WeightedRandomChestContent(NovaCraftItems.echo_shard, 0, 1, 1, 1), new WeightedRandomChestContent(NovaCraftItems.luminant_apple, 0, 1, 1, 1), new WeightedRandomChestContent(NovaCraftItems.anomalous_essence, 0, 1, 1, 1), new WeightedRandomChestContent(NovaCraftItems.tsavorokite_shard, 0, 1, 1, 1)};
        private boolean hasMadeChest;

        public NCChestNCCorridor() {}

        public NCChestNCCorridor(int p_i2071_1_, Random p_i2071_2_, StructureBoundingBox p_i2071_3_, int p_i2071_4_)
        {
            super(p_i2071_1_);
            this.coordBaseMode = p_i2071_4_;
            this.field_143013_d = this.getRandomDoor(p_i2071_2_);
            this.boundingBox = p_i2071_3_;
        }

        protected void func_143012_a(NBTTagCompound p_143012_1_)
        {
            super.func_143012_a(p_143012_1_);
            p_143012_1_.setBoolean("Chest", this.hasMadeChest);
        }

        protected void func_143011_b(NBTTagCompound p_143011_1_)
        {
            super.func_143011_b(p_143011_1_);
            this.hasMadeChest = p_143011_1_.getBoolean("Chest");
        }

        public void buildComponent(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_)
        {
            this.getNextComponentNormal((NCStructureStrongholdPieces.NCStairs2)p_74861_1_, p_74861_2_, p_74861_3_, 1, 1);
        }

        public static NCStructureStrongholdPieces.NCChestNCCorridor findValidPlacement(List p_75000_0_, Random p_75000_1_, int p_75000_2_, int p_75000_3_, int p_75000_4_, int p_75000_5_, int p_75000_6_) {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_75000_2_, p_75000_3_, p_75000_4_, -1, -1, 0, 5, 5, 7, p_75000_5_);

            return canStrongholdGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(p_75000_0_, structureboundingbox) == null ? new NCStructureStrongholdPieces.NCChestNCCorridor(p_75000_6_, p_75000_1_, structureboundingbox, p_75000_5_) : null;
        }

        public boolean addComponentParts(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_)
        {
            if (this.isLiquidInStructureBoundingBox(p_74875_1_, p_74875_3_))
            {
                return false;
            }
            else
            {
                this.fillWithRandomizedBlocks(p_74875_1_, p_74875_3_, 0, 0, 0, 4, 4, 6, true, p_74875_2_, NCStructureStrongholdPieces.strongholdStones);
                this.placeDoor(p_74875_1_, p_74875_2_, p_74875_3_, this.field_143013_d, 1, 1, 0);
                this.placeDoor(p_74875_1_, p_74875_2_, p_74875_3_, NCStructureStrongholdPieces.Stronghold.Door.OPENING, 1, 1, 6);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 3, 1, 2, 3, 1, 4, Blocks.stonebrick, Blocks.stonebrick, false);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.stone_slab, 5, 3, 1, 1, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.stone_slab, 5, 3, 1, 5, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.stone_slab, 5, 3, 2, 2, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.stone_slab, 5, 3, 2, 4, p_74875_3_);

                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.stonebrick, 0, 3, 1, 5, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.stone_slab, 5, 3, 2, 5, p_74875_3_);

                int i;

                for (i = 2; i <= 4; ++i)
                {
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.stone_slab, 5, 2, 1, i, p_74875_3_);
                }

                if (!this.hasMadeChest)
                {
                    i = this.getYWithOffset(2);
                    int j = this.getXWithOffset(3, 3);
                    int k = this.getZWithOffset(3, 3);

                    if (p_74875_3_.isVecInside(j, i, k))
                    {
                        this.hasMadeChest = true;
                        this.generateStructureChestContents(p_74875_1_, p_74875_3_, p_74875_2_, 3, 2, 3, ChestGenHooks.getItems(STRONGHOLD_CORRIDOR, p_74875_2_), ChestGenHooks.getCount(STRONGHOLD_CORRIDOR, p_74875_2_));
                        this.generateStructureChestContents(p_74875_1_, p_74875_3_, p_74875_2_, 3, 2, 4, ChestGenHooks.getItems(NC_TREASURE, p_74875_2_), ChestGenHooks.getCount(NC_TREASURE, p_74875_2_));
                    }
                }

                return true;
            }
        }
    }

    public static class NCCorridor extends NCStructureStrongholdPieces.Stronghold
    {
        private int field_74993_a;

        public NCCorridor() {}

        public NCCorridor(int p_i2072_1_, Random p_i2072_2_, StructureBoundingBox p_i2072_3_, int p_i2072_4_)
        {
            super(p_i2072_1_);
            this.coordBaseMode = p_i2072_4_;
            this.boundingBox = p_i2072_3_;
            this.field_74993_a = p_i2072_4_ != 2 && p_i2072_4_ != 0 ? p_i2072_3_.getXSize() : p_i2072_3_.getZSize();
        }

        protected void func_143012_a(NBTTagCompound p_143012_1_)
        {
            super.func_143012_a(p_143012_1_);
            p_143012_1_.setInteger("Steps", this.field_74993_a);
        }

        protected void func_143011_b(NBTTagCompound p_143011_1_)
        {
            super.func_143011_b(p_143011_1_);
            this.field_74993_a = p_143011_1_.getInteger("Steps");
        }

        public static StructureBoundingBox func_74992_a(List p_74992_0_, Random p_74992_1_, int p_74992_2_, int p_74992_3_, int p_74992_4_, int p_74992_5_)
        {
            boolean flag = true;
            StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_74992_2_, p_74992_3_, p_74992_4_, -1, -1, 0, 5, 5, 4, p_74992_5_);
            StructureComponent structurecomponent = StructureComponent.findIntersecting(p_74992_0_, structureboundingbox);

            if (structurecomponent == null)
            {
                return null;
            }
            else
            {
                if (structurecomponent.getBoundingBox().minY == structureboundingbox.minY)
                {
                    for (int i1 = 3; i1 >= 1; --i1)
                    {
                        structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_74992_2_, p_74992_3_, p_74992_4_, -1, -1, 0, 5, 5, i1 - 1, p_74992_5_);

                        if (!structurecomponent.getBoundingBox().intersectsWith(structureboundingbox))
                        {
                            return StructureBoundingBox.getComponentToAddBoundingBox(p_74992_2_, p_74992_3_, p_74992_4_, -1, -1, 0, 5, 5, i1, p_74992_5_);
                        }
                    }
                }

                return null;
            }
        }

        public boolean addComponentParts(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_)
        {
            if (this.isLiquidInStructureBoundingBox(p_74875_1_, p_74875_3_))
            {
                return false;
            }
            else
            {
                for (int i = 0; i < this.field_74993_a; ++i)
                {
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.stonebrick, 0, 0, 0, i, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.stonebrick, 0, 1, 0, i, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.stonebrick, 0, 2, 0, i, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.stonebrick, 0, 3, 0, i, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.stonebrick, 0, 4, 0, i, p_74875_3_);

                    for (int j = 1; j <= 3; ++j)
                    {
                        this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.stonebrick, 0, 0, j, i, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.air, 0, 1, j, i, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.air, 0, 2, j, i, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.air, 0, 3, j, i, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.stonebrick, 0, 4, j, i, p_74875_3_);
                    }

                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.stonebrick, 0, 0, 4, i, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.stonebrick, 0, 1, 4, i, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.stonebrick, 0, 2, 4, i, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.stonebrick, 0, 3, 4, i, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.stonebrick, 0, 4, 4, i, p_74875_3_);
                }

                return true;
            }
        }
    }

    public static class NCCrossing extends NCStructureStrongholdPieces.Stronghold
    {
        private boolean field_74996_b;
        private boolean field_74997_c;
        private boolean field_74995_d;
        private boolean field_74999_h;

        public NCCrossing() {}

        public NCCrossing(int p_i2073_1_, Random p_i2073_2_, StructureBoundingBox p_i2073_3_, int p_i2073_4_)
        {
            super(p_i2073_1_);
            this.coordBaseMode = p_i2073_4_;
            this.field_143013_d = this.getRandomDoor(p_i2073_2_);
            this.boundingBox = p_i2073_3_;
            this.field_74996_b = p_i2073_2_.nextBoolean();
            this.field_74997_c = p_i2073_2_.nextBoolean();
            this.field_74995_d = p_i2073_2_.nextBoolean();
            this.field_74999_h = p_i2073_2_.nextInt(3) > 0;
        }

        protected void func_143012_a(NBTTagCompound p_143012_1_)
        {
            super.func_143012_a(p_143012_1_);
            p_143012_1_.setBoolean("leftLow", this.field_74996_b);
            p_143012_1_.setBoolean("leftHigh", this.field_74997_c);
            p_143012_1_.setBoolean("rightLow", this.field_74995_d);
            p_143012_1_.setBoolean("rightHigh", this.field_74999_h);
        }

        protected void func_143011_b(NBTTagCompound p_143011_1_)
        {
            super.func_143011_b(p_143011_1_);
            this.field_74996_b = p_143011_1_.getBoolean("leftLow");
            this.field_74997_c = p_143011_1_.getBoolean("leftHigh");
            this.field_74995_d = p_143011_1_.getBoolean("rightLow");
            this.field_74999_h = p_143011_1_.getBoolean("rightHigh");
        }


        public void buildComponent(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_)
        {
            int i = 3;
            int j = 5;

            if (this.coordBaseMode == 1 || this.coordBaseMode == 2)
            {
                i = 8 - i;
                j = 8 - j;
            }

            this.getNextComponentNormal((NCStructureStrongholdPieces.NCStairs2)p_74861_1_, p_74861_2_, p_74861_3_, 5, 1);

            if (this.field_74996_b)
            {
                this.getNextComponentX((NCStructureStrongholdPieces.NCStairs2)p_74861_1_, p_74861_2_, p_74861_3_, i, 1);
            }

            if (this.field_74997_c)
            {
                this.getNextComponentX((NCStructureStrongholdPieces.NCStairs2)p_74861_1_, p_74861_2_, p_74861_3_, j, 7);
            }

            if (this.field_74995_d)
            {
                this.getNextComponentZ((NCStructureStrongholdPieces.NCStairs2)p_74861_1_, p_74861_2_, p_74861_3_, i, 1);
            }

            if (this.field_74999_h)
            {
                this.getNextComponentZ((NCStructureStrongholdPieces.NCStairs2)p_74861_1_, p_74861_2_, p_74861_3_, j, 7);
            }
        }

        public static NCStructureStrongholdPieces.NCCrossing findValidPlacement(List p_74994_0_, Random p_74994_1_, int p_74994_2_, int p_74994_3_, int p_74994_4_, int p_74994_5_, int p_74994_6_)
        {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_74994_2_, p_74994_3_, p_74994_4_, -4, -3, 0, 10, 9, 11, p_74994_5_);

            return canStrongholdGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(p_74994_0_, structureboundingbox) == null ? new NCStructureStrongholdPieces.NCCrossing(p_74994_6_, p_74994_1_, structureboundingbox, p_74994_5_) : null;
        }


        public boolean addComponentParts(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_)
        {
            if (this.isLiquidInStructureBoundingBox(p_74875_1_, p_74875_3_))
            {
                return false;
            }
            else
            {
                this.fillWithRandomizedBlocks(p_74875_1_, p_74875_3_, 0, 0, 0, 9, 8, 10, true, p_74875_2_, NCStructureStrongholdPieces.strongholdStones);
                this.placeDoor(p_74875_1_, p_74875_2_, p_74875_3_, this.field_143013_d, 4, 3, 0);

                if (this.field_74996_b)
                {
                    this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 3, 1, 0, 5, 3, Blocks.air, Blocks.air, false);
                }

                if (this.field_74995_d)
                {
                    this.fillWithBlocks(p_74875_1_, p_74875_3_, 9, 3, 1, 9, 5, 3, Blocks.air, Blocks.air, false);
                }

                if (this.field_74997_c)
                {
                    this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 5, 7, 0, 7, 9, Blocks.air, Blocks.air, false);
                }

                if (this.field_74999_h)
                {
                    this.fillWithBlocks(p_74875_1_, p_74875_3_, 9, 5, 7, 9, 7, 9, Blocks.air, Blocks.air, false);
                }

                this.fillWithBlocks(p_74875_1_, p_74875_3_, 5, 1, 10, 7, 3, 10, Blocks.air, Blocks.air, false);
                this.fillWithRandomizedBlocks(p_74875_1_, p_74875_3_, 1, 2, 1, 8, 2, 6, false, p_74875_2_, NCStructureStrongholdPieces.strongholdStones);
                this.fillWithRandomizedBlocks(p_74875_1_, p_74875_3_, 4, 1, 5, 4, 4, 9, false, p_74875_2_, NCStructureStrongholdPieces.strongholdStones);
                this.fillWithRandomizedBlocks(p_74875_1_, p_74875_3_, 8, 1, 5, 8, 4, 9, false, p_74875_2_, NCStructureStrongholdPieces.strongholdStones);
                this.fillWithRandomizedBlocks(p_74875_1_, p_74875_3_, 1, 4, 7, 3, 4, 9, false, p_74875_2_, NCStructureStrongholdPieces.strongholdStones);
                this.fillWithRandomizedBlocks(p_74875_1_, p_74875_3_, 1, 3, 5, 3, 3, 6, false, p_74875_2_, NCStructureStrongholdPieces.strongholdStones);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 1, 3, 4, 3, 3, 4, Blocks.stone_slab, Blocks.stone_slab, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 1, 4, 6, 3, 4, 6, Blocks.stone_slab, Blocks.stone_slab, false);
                this.fillWithRandomizedBlocks(p_74875_1_, p_74875_3_, 5, 1, 7, 7, 1, 8, false, p_74875_2_, NCStructureStrongholdPieces.strongholdStones);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 5, 1, 9, 7, 1, 9, Blocks.stone_slab, Blocks.stone_slab, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 5, 2, 7, 7, 2, 7, Blocks.stone_slab, Blocks.stone_slab, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 4, 5, 7, 4, 5, 9, Blocks.stone_slab, Blocks.stone_slab, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 8, 5, 7, 8, 5, 9, Blocks.stone_slab, Blocks.stone_slab, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 5, 5, 7, 7, 5, 9, Blocks.double_stone_slab, Blocks.double_stone_slab, false);
                return true;
            }
        }
    }

    public static class NCLeftTurn extends NCStructureStrongholdPieces.Stronghold {
        private boolean hasSpawner;

        protected void func_143012_a(NBTTagCompound p_143012_1_)
        {
            super.func_143012_a(p_143012_1_);
            p_143012_1_.setBoolean("Mob", this.hasSpawner);
        }

        protected void func_143011_b(NBTTagCompound p_143011_1_)
        {
            super.func_143011_b(p_143011_1_);
            this.hasSpawner = p_143011_1_.getBoolean("Mob");
        }


        public NCLeftTurn() {}

        public NCLeftTurn(int p_i2074_1_, Random p_i2074_2_, StructureBoundingBox p_i2074_3_, int p_i2074_4_)
        {
            super(p_i2074_1_);
            this.coordBaseMode = p_i2074_4_;
            this.field_143013_d = this.getRandomDoor(p_i2074_2_);
            this.boundingBox = p_i2074_3_;
        }


        public void buildComponent(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_)
        {
            if (this.coordBaseMode != 2 && this.coordBaseMode != 3)
            {
                this.getNextComponentZ((NCStructureStrongholdPieces.NCStairs2)p_74861_1_, p_74861_2_, p_74861_3_, 1, 1);
            }
            else
            {
                this.getNextComponentX((NCStructureStrongholdPieces.NCStairs2)p_74861_1_, p_74861_2_, p_74861_3_, 1, 1);
            }
        }

        public static NCStructureStrongholdPieces.NCLeftTurn findValidPlacement(List p_75010_0_, Random p_75010_1_, int p_75010_2_, int p_75010_3_, int p_75010_4_, int p_75010_5_, int p_75010_6_)
        {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_75010_2_, p_75010_3_, p_75010_4_, -1, -1, 0, 5, 5, 5, p_75010_5_);

            return canStrongholdGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(p_75010_0_, structureboundingbox) == null ? new NCStructureStrongholdPieces.NCLeftTurn(p_75010_6_, p_75010_1_, structureboundingbox, p_75010_5_) : null;
        }


        public boolean addComponentParts(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_)
        {
            if (this.isLiquidInStructureBoundingBox(p_74875_1_, p_74875_3_))
            {
                return false;
            }
            else
            {
                this.fillWithRandomizedBlocks(p_74875_1_, p_74875_3_, 0, 0, 0, 4, 4, 4, true, p_74875_2_, NCStructureStrongholdPieces.strongholdStones);
                this.placeDoor(p_74875_1_, p_74875_2_, p_74875_3_, this.field_143013_d, 1, 1, 0);

                if (this.coordBaseMode != 2 && this.coordBaseMode != 3)
                {
                    this.fillWithBlocks(p_74875_1_, p_74875_3_, 4, 1, 1, 4, 3, 3, Blocks.air, Blocks.air, false);

                    int spawner_chance = p_74875_2_.nextInt(5);
                    if (!this.hasSpawner && (Configs.enableMaxStrongholdSpawners || spawner_chance == 0)) {
                        int i1 = this.getYWithOffset(1);
                        int k = this.getXWithOffset(4, 1);
                        int l = this.getZWithOffset(4, 1);

                        if (p_74875_3_.isVecInside(k, i1, l))
                        {
                            this.hasSpawner = true;
                            p_74875_1_.setBlock(k, i1, l, Blocks.mob_spawner, 0, 2);
                            TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner)p_74875_1_.getTileEntity(k, i1, l);

                            if (tileentitymobspawner != null && p_74875_2_.nextBoolean()) {
                                tileentitymobspawner.func_145881_a().setEntityName("Zombie");

                                //Get the NBT data from the spawner
                                NBTTagCompound spawnerNBT = new NBTTagCompound();
                                tileentitymobspawner.writeToNBT(spawnerNBT);

                                //Modify SpawnData to customize the spawned zombie
                                NBTTagCompound spawnData = new NBTTagCompound();
                                spawnData.setString("id", "Zombie");

                                //Give the mob a Resistance effect
                                NBTTagList effects = new NBTTagList();

                                NBTTagCompound resistanceEffect = new NBTTagCompound();
                                resistanceEffect.setByte("Id", (byte) 11); //Resistance effect ID
                                resistanceEffect.setByte("Amplifier", (byte) 2); //Level 2 Resistance
                                resistanceEffect.setInteger("Duration", Integer.MAX_VALUE); //Infinite duration
                                resistanceEffect.setByte("Ambient", (byte) 1);
                                resistanceEffect.setByte("ShowParticles", (byte) 0); //Invisible effect???

                                effects.appendTag(resistanceEffect);
                                spawnData.setTag("ActiveEffects", effects);

                                //Gives weapon
                                NBTTagList equipment = new NBTTagList();

                                NBTTagCompound weapon = new NBTTagCompound();
                                ItemStack sword = new ItemStack(Items.iron_sword);
                                sword.writeToNBT(weapon);
                                equipment.appendTag(weapon);

                                //Fill remaining slots with empty tags to prevent overwriting other equipment
                                for (int a = 1; a < 5; a++) {
                                    equipment.appendTag(new NBTTagCompound());
                                }
                                spawnData.setTag("Equipment", equipment);

                                //Prevent the weapon from being removed or replaced
                                NBTTagList dropChances = new NBTTagList();
                                dropChances.appendTag(new NBTTagFloat(0.0F)); //Weapon (never drops)
                                for (int a = 1; a < 5; a++) {
                                    dropChances.appendTag(new NBTTagFloat(0.085F)); //Default drop chance for empty slots
                                }
                                spawnData.setTag("DropChances", dropChances);

                                //Apply SpawnData to spawner
                                spawnerNBT.setTag("SpawnData", spawnData);

                                //Write the modified NBT data back to the spawner
                                tileentitymobspawner.readFromNBT(spawnerNBT);
                            } else {
                                tileentitymobspawner.func_145881_a().setEntityName("Skeleton");

                                NBTTagCompound spawnerNBT = new NBTTagCompound();
                                tileentitymobspawner.writeToNBT(spawnerNBT);

                                NBTTagCompound spawnData = new NBTTagCompound();
                                spawnData.setString("id", "Skeleton");

                                NBTTagList effects = new NBTTagList();

                                NBTTagCompound resistanceEffect = new NBTTagCompound();
                                resistanceEffect.setByte("Id", (byte) 11);
                                resistanceEffect.setByte("Amplifier", (byte) 2);
                                resistanceEffect.setInteger("Duration", Integer.MAX_VALUE);
                                resistanceEffect.setByte("Ambient", (byte) 1);
                                resistanceEffect.setByte("ShowParticles", (byte) 0);

                                effects.appendTag(resistanceEffect);
                                spawnData.setTag("ActiveEffects", effects);

                                NBTTagList equipment = new NBTTagList();

                                NBTTagCompound weapon = new NBTTagCompound();
                                ItemStack sword = new ItemStack(Items.bow);
                                sword.writeToNBT(weapon);
                                equipment.appendTag(weapon);

                                for (int a = 1; a < 5; a++) {
                                    equipment.appendTag(new NBTTagCompound());
                                }
                                spawnData.setTag("Equipment", equipment);

                                NBTTagList dropChances = new NBTTagList();
                                dropChances.appendTag(new NBTTagFloat(0.0F));
                                for (int a = 1; a < 5; a++) {
                                    dropChances.appendTag(new NBTTagFloat(0.085F));
                                }
                                spawnData.setTag("DropChances", dropChances);

                                spawnerNBT.setTag("SpawnData", spawnData);

                                tileentitymobspawner.readFromNBT(spawnerNBT);
                            }
                        }
                    }
                }
                else
                {
                    this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 1, 1, 0, 3, 3, Blocks.air, Blocks.air, false);

                    int spawner_chance = p_74875_2_.nextInt(5);
                    if (!this.hasSpawner && (Configs.enableMaxStrongholdSpawners || spawner_chance == 0)) {
                        int i1 = this.getYWithOffset(1);
                        int k = this.getXWithOffset(0, 1);
                        int l = this.getZWithOffset(0, 1);

                        if (p_74875_3_.isVecInside(k, i1, l))
                        {
                            this.hasSpawner = true;
                            p_74875_1_.setBlock(k, i1, l, Blocks.mob_spawner, 0, 2);
                            TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner)p_74875_1_.getTileEntity(k, i1, l);

                            if (tileentitymobspawner != null && p_74875_2_.nextBoolean()) {
                                tileentitymobspawner.func_145881_a().setEntityName("Zombie");

                                //Get the NBT data from the spawner
                                NBTTagCompound spawnerNBT = new NBTTagCompound();
                                tileentitymobspawner.writeToNBT(spawnerNBT);

                                //Modify SpawnData to customize the spawned zombie
                                NBTTagCompound spawnData = new NBTTagCompound();
                                spawnData.setString("id", "Zombie");

                                //Give the mob a Resistance effect
                                NBTTagList effects = new NBTTagList();

                                NBTTagCompound resistanceEffect = new NBTTagCompound();
                                resistanceEffect.setByte("Id", (byte) 11); //Resistance effect ID
                                resistanceEffect.setByte("Amplifier", (byte) 2); //Level 2 Resistance
                                resistanceEffect.setInteger("Duration", Integer.MAX_VALUE); //Infinite duration
                                resistanceEffect.setByte("Ambient", (byte) 1);
                                resistanceEffect.setByte("ShowParticles", (byte) 0); //Invisible effect???

                                effects.appendTag(resistanceEffect);
                                spawnData.setTag("ActiveEffects", effects);

                                //Gives weapon
                                NBTTagList equipment = new NBTTagList();

                                NBTTagCompound weapon = new NBTTagCompound();
                                ItemStack sword = new ItemStack(Items.iron_sword);
                                sword.writeToNBT(weapon);
                                equipment.appendTag(weapon);

                                //Fill remaining slots with empty tags to prevent overwriting other equipment
                                for (int a = 1; a < 5; a++) {
                                    equipment.appendTag(new NBTTagCompound());
                                }
                                spawnData.setTag("Equipment", equipment);

                                //Prevent the weapon from being removed or replaced
                                NBTTagList dropChances = new NBTTagList();
                                dropChances.appendTag(new NBTTagFloat(0.0F)); //Weapon (never drops)
                                for (int a = 1; a < 5; a++) {
                                    dropChances.appendTag(new NBTTagFloat(0.085F)); //Default drop chance for empty slots
                                }
                                spawnData.setTag("DropChances", dropChances);

                                //Apply SpawnData to spawner
                                spawnerNBT.setTag("SpawnData", spawnData);

                                //Write the modified NBT data back to the spawner
                                tileentitymobspawner.readFromNBT(spawnerNBT);
                            } else {
                                tileentitymobspawner.func_145881_a().setEntityName("Skeleton");

                                NBTTagCompound spawnerNBT = new NBTTagCompound();
                                tileentitymobspawner.writeToNBT(spawnerNBT);

                                NBTTagCompound spawnData = new NBTTagCompound();
                                spawnData.setString("id", "Skeleton");

                                NBTTagList effects = new NBTTagList();

                                NBTTagCompound resistanceEffect = new NBTTagCompound();
                                resistanceEffect.setByte("Id", (byte) 11);
                                resistanceEffect.setByte("Amplifier", (byte) 2);
                                resistanceEffect.setInteger("Duration", Integer.MAX_VALUE);
                                resistanceEffect.setByte("Ambient", (byte) 1);
                                resistanceEffect.setByte("ShowParticles", (byte) 0);

                                effects.appendTag(resistanceEffect);
                                spawnData.setTag("ActiveEffects", effects);

                                NBTTagList equipment = new NBTTagList();

                                NBTTagCompound weapon = new NBTTagCompound();
                                ItemStack sword = new ItemStack(Items.bow);
                                sword.writeToNBT(weapon);
                                equipment.appendTag(weapon);

                                for (int a = 1; a < 5; a++) {
                                    equipment.appendTag(new NBTTagCompound());
                                }
                                spawnData.setTag("Equipment", equipment);

                                NBTTagList dropChances = new NBTTagList();
                                dropChances.appendTag(new NBTTagFloat(0.0F));
                                for (int a = 1; a < 5; a++) {
                                    dropChances.appendTag(new NBTTagFloat(0.085F));
                                }
                                spawnData.setTag("DropChances", dropChances);

                                spawnerNBT.setTag("SpawnData", spawnData);

                                tileentitymobspawner.readFromNBT(spawnerNBT);
                            }
                        }
                    }
                }

                return true;
            }
        }
    }

    public static class NCLibrary extends NCStructureStrongholdPieces.Stronghold {

        private boolean isLargeRoom;

        public NCLibrary() {}

        public NCLibrary(int p_i2075_1_, Random p_i2075_2_, StructureBoundingBox p_i2075_3_, int p_i2075_4_)
        {
            super(p_i2075_1_);
            this.coordBaseMode = p_i2075_4_;
            this.field_143013_d = this.getRandomDoor(p_i2075_2_);
            this.boundingBox = p_i2075_3_;
            this.isLargeRoom = p_i2075_3_.getYSize() > 6;
        }

        protected void func_143012_a(NBTTagCompound p_143012_1_)
        {
            super.func_143012_a(p_143012_1_);
            p_143012_1_.setBoolean("Tall", this.isLargeRoom);
        }

        protected void func_143011_b(NBTTagCompound p_143011_1_)
        {
            super.func_143011_b(p_143011_1_);
            this.isLargeRoom = p_143011_1_.getBoolean("Tall");
        }

        public static NCStructureStrongholdPieces.NCLibrary findValidPlacement(List p_75006_0_, Random p_75006_1_, int p_75006_2_, int p_75006_3_, int p_75006_4_, int p_75006_5_, int p_75006_6_)
        {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_75006_2_, p_75006_3_, p_75006_4_, -4, -1, 0, 14, 11, 15, p_75006_5_);

            if (!canStrongholdGoDeeper(structureboundingbox) || StructureComponent.findIntersecting(p_75006_0_, structureboundingbox) != null)
            {
                structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_75006_2_, p_75006_3_, p_75006_4_, -4, -1, 0, 14, 6, 15, p_75006_5_);

                if (!canStrongholdGoDeeper(structureboundingbox) || StructureComponent.findIntersecting(p_75006_0_, structureboundingbox) != null)
                {
                    return null;
                }
            }

            return new NCStructureStrongholdPieces.NCLibrary(p_75006_6_, p_75006_1_, structureboundingbox, p_75006_5_);
        }


        public boolean addComponentParts(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_)
        {
            if (this.isLiquidInStructureBoundingBox(p_74875_1_, p_74875_3_))
            {
                return false;
            }
            else
            {
                byte b0 = 11;

                if (!this.isLargeRoom)
                {
                    b0 = 6;
                }

                this.fillWithRandomizedBlocks(p_74875_1_, p_74875_3_, 0, 0, 0, 13, b0 - 1, 14, true, p_74875_2_, NCStructureStrongholdPieces.strongholdStones);
                this.placeDoor(p_74875_1_, p_74875_2_, p_74875_3_, this.field_143013_d, 4, 1, 0);
                this.randomlyFillWithBlocks(p_74875_1_, p_74875_3_, p_74875_2_, 0.07F, 2, 1, 1, 11, 4, 13, Blocks.web, Blocks.web, false);
                int i;

                for (i = 1; i <= 13; ++i)
                {
                    if ((i - 1) % 4 == 0)
                    {
                        this.fillWithBlocks(p_74875_1_, p_74875_3_, 1, 1, i, 1, 4, i, Blocks.planks, Blocks.planks, false);
                        this.fillWithBlocks(p_74875_1_, p_74875_3_, 12, 1, i, 12, 4, i, Blocks.planks, Blocks.planks, false);

                        if (this.isLargeRoom)
                        {
                            this.fillWithBlocks(p_74875_1_, p_74875_3_, 1, 6, i, 1, 9, i, Blocks.planks, Blocks.planks, false);
                            this.fillWithBlocks(p_74875_1_, p_74875_3_, 12, 6, i, 12, 9, i, Blocks.planks, Blocks.planks, false);
                        }
                    }
                    else
                    {
                        this.fillWithBlocks(p_74875_1_, p_74875_3_, 1, 1, i, 1, 4, i, Blocks.bookshelf, Blocks.bookshelf, false);
                        this.fillWithBlocks(p_74875_1_, p_74875_3_, 12, 1, i, 12, 4, i, Blocks.bookshelf, Blocks.bookshelf, false);

                        if (this.isLargeRoom)
                        {
                            this.fillWithBlocks(p_74875_1_, p_74875_3_, 1, 6, i, 1, 9, i, Blocks.bookshelf, Blocks.bookshelf, false);
                            this.fillWithBlocks(p_74875_1_, p_74875_3_, 12, 6, i, 12, 9, i, Blocks.bookshelf, Blocks.bookshelf, false);
                        }
                    }
                }

                for (i = 3; i < 12; i += 2)
                {
                    this.fillWithBlocks(p_74875_1_, p_74875_3_, 3, 1, i, 4, 3, i, Blocks.bookshelf, Blocks.bookshelf, false);
                    this.fillWithBlocks(p_74875_1_, p_74875_3_, 6, 1, i, 7, 3, i, Blocks.bookshelf, Blocks.bookshelf, false);
                    this.fillWithBlocks(p_74875_1_, p_74875_3_, 9, 1, i, 10, 3, i, Blocks.bookshelf, Blocks.bookshelf, false);
                }

                if (this.isLargeRoom)
                {
                    this.fillWithBlocks(p_74875_1_, p_74875_3_, 1, 5, 1, 3, 5, 13, Blocks.planks, Blocks.planks, false);
                    this.fillWithBlocks(p_74875_1_, p_74875_3_, 10, 5, 1, 12, 5, 13, Blocks.planks, Blocks.planks, false);
                    this.fillWithBlocks(p_74875_1_, p_74875_3_, 4, 5, 1, 9, 5, 2, Blocks.planks, Blocks.planks, false);
                    this.fillWithBlocks(p_74875_1_, p_74875_3_, 4, 5, 12, 9, 5, 13, Blocks.planks, Blocks.planks, false);
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.planks, 0, 9, 5, 11, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.planks, 0, 8, 5, 11, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.planks, 0, 9, 5, 10, p_74875_3_);
                    this.fillWithBlocks(p_74875_1_, p_74875_3_, 3, 6, 2, 3, 6, 12, Blocks.fence, Blocks.fence, false);
                    this.fillWithBlocks(p_74875_1_, p_74875_3_, 10, 6, 2, 10, 6, 10, Blocks.fence, Blocks.fence, false);
                    this.fillWithBlocks(p_74875_1_, p_74875_3_, 4, 6, 2, 9, 6, 2, Blocks.fence, Blocks.fence, false);
                    this.fillWithBlocks(p_74875_1_, p_74875_3_, 4, 6, 12, 8, 6, 12, Blocks.fence, Blocks.fence, false);
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.fence, 0, 9, 6, 11, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.fence, 0, 8, 6, 11, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.fence, 0, 9, 6, 10, p_74875_3_);
                    i = this.getMetadataWithOffset(Blocks.ladder, 3);
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.ladder, i, 10, 1, 13, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.ladder, i, 10, 2, 13, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.ladder, i, 10, 3, 13, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.ladder, i, 10, 4, 13, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.ladder, i, 10, 5, 13, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.ladder, i, 10, 6, 13, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.ladder, i, 10, 7, 13, p_74875_3_);
                    byte b1 = 7;
                    byte b2 = 7;
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.fence, 0, b1 - 1, 9, b2, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.fence, 0, b1, 9, b2, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.fence, 0, b1 - 1, 8, b2, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.fence, 0, b1, 8, b2, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.fence, 0, b1 - 1, 7, b2, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.fence, 0, b1, 7, b2, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.fence, 0, b1 - 2, 7, b2, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.fence, 0, b1 + 1, 7, b2, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.fence, 0, b1 - 1, 7, b2 - 1, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.fence, 0, b1 - 1, 7, b2 + 1, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.fence, 0, b1, 7, b2 - 1, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.fence, 0, b1, 7, b2 + 1, p_74875_3_);
                }

                ChestGenHooks info = ChestGenHooks.getInfo(STRONGHOLD_LIBRARY);

                this.generateStructureChestContents(p_74875_1_, p_74875_3_, p_74875_2_, 3, 3, 5, info.getItems(p_74875_2_), info.getCount(p_74875_2_));

                this.generateStructureChestContents(p_74875_1_, p_74875_3_, p_74875_2_, 7, 3, 11, info.getItems(p_74875_2_), info.getCount(p_74875_2_));

                if (this.isLargeRoom)
                {
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.air, 0, 12, 9, 1, p_74875_3_);
                    this.generateStructureChestContents(p_74875_1_, p_74875_3_, p_74875_2_, 12, 8, 1, info.getItems(p_74875_2_), info.getCount(p_74875_2_));
                }

                return true;
            }
        }
    }

    public static class NCCrystalFarm extends NCStructureStrongholdPieces.Stronghold {

        private boolean isLargeRoom;
        private boolean hasSpawner;

        public NCCrystalFarm() {}

        public NCCrystalFarm(int p_i2075_1_, Random p_i2075_2_, StructureBoundingBox p_i2075_3_, int p_i2075_4_)
        {
            super(p_i2075_1_);
            this.coordBaseMode = p_i2075_4_;
            this.field_143013_d = this.getRandomDoor(p_i2075_2_);
            this.boundingBox = p_i2075_3_;
            this.isLargeRoom = p_i2075_3_.getYSize() > 6;
        }

        protected void func_143012_a(NBTTagCompound p_143012_1_)
        {
            super.func_143012_a(p_143012_1_);
            p_143012_1_.setBoolean("Tall", this.isLargeRoom);
            p_143012_1_.setBoolean("Mob", this.hasSpawner);
        }

        protected void func_143011_b(NBTTagCompound p_143011_1_)
        {
            super.func_143011_b(p_143011_1_);
            this.isLargeRoom = p_143011_1_.getBoolean("Tall");
        }

        public static NCStructureStrongholdPieces.NCCrystalFarm findValidPlacement(List p_75006_0_, Random p_75006_1_, int p_75006_2_, int p_75006_3_, int p_75006_4_, int p_75006_5_, int p_75006_6_)
        {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_75006_2_, p_75006_3_, p_75006_4_, -4, -1, 0, 14, 11, 15, p_75006_5_);

            if (!canStrongholdGoDeeper(structureboundingbox) || StructureComponent.findIntersecting(p_75006_0_, structureboundingbox) != null)
            {
                structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_75006_2_, p_75006_3_, p_75006_4_, -4, -1, 0, 14, 6, 15, p_75006_5_);

                if (!canStrongholdGoDeeper(structureboundingbox) || StructureComponent.findIntersecting(p_75006_0_, structureboundingbox) != null)
                {
                    return null;
                }
            }

            return new NCStructureStrongholdPieces.NCCrystalFarm(p_75006_6_, p_75006_1_, structureboundingbox, p_75006_5_);
        }


        public boolean addComponentParts(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_)
        {
            if (this.isLiquidInStructureBoundingBox(p_74875_1_, p_74875_3_))
            {
                return false;
            }
            else {
                byte b0 = 11;

                if (!this.isLargeRoom) {
                    b0 = 6;
                }

                this.fillWithRandomizedBlocks(p_74875_1_, p_74875_3_, 0, 0, 0, 13, b0 - 1, 14, true, p_74875_2_, NCStructureStrongholdPieces.strongholdStones);
                this.placeDoor(p_74875_1_, p_74875_2_, p_74875_3_, this.field_143013_d, 4, 1, 0);

                this.randomlyFillWithBlocks(p_74875_1_, p_74875_3_, p_74875_2_, 0.10F, 2, 0, 1, 11, 0, 13, NovaCraftBlocks.sculk_block, NovaCraftBlocks.sculk_block, false);

                //this.placeBlockAtCurrentPosition(p_74875_1_, NovaCraftBlocks.ancient_warper, 0, 8, 1, 4, p_74875_3_);
                //this.placeBlockAtCurrentPosition(p_74875_1_, NovaCraftBlocks.grimstone_brick_slab, 0, 7, 1, 4, p_74875_3_);
                //this.placeBlockAtCurrentPosition(p_74875_1_, NovaCraftBlocks.grimstone_brick_slab, 0, 9, 1, 4, p_74875_3_);
                //this.placeBlockAtCurrentPosition(p_74875_1_, NovaCraftBlocks.grimstone_brick_slab, 0, 8, 1, 5, p_74875_3_);
                //this.placeBlockAtCurrentPosition(p_74875_1_, NovaCraftBlocks.grimstone_brick_slab, 0, 8, 1, 3, p_74875_3_);

                int i;

                for (i = 1; i <= 13; ++i)
                {
                    if ((i - 1) % 4 == 0)
                    {
                        this.fillWithBlocks(p_74875_1_, p_74875_3_, 1, 1, i, 1, 4, i, NovaCraftBlocks.grimstone_bricks, NovaCraftBlocks.grimstone_bricks, false);
                        this.fillWithBlocks(p_74875_1_, p_74875_3_, 12, 1, i, 12, 4, i, NovaCraftBlocks.grimstone_bricks, NovaCraftBlocks.grimstone_bricks, false);

                        if (this.isLargeRoom)
                        {
                            this.fillWithBlocks(p_74875_1_, p_74875_3_, 1, 6, i, 1, 9, i, NovaCraftBlocks.grimstone_bricks, NovaCraftBlocks.grimstone_bricks, false);
                            this.fillWithBlocks(p_74875_1_, p_74875_3_, 12, 6, i, 12, 9, i, NovaCraftBlocks.grimstone_bricks, NovaCraftBlocks.grimstone_bricks, false);
                        }
                    }
                    else
                    {
                        this.fillWithBlocks(p_74875_1_, p_74875_3_, 1, 1, i, 1, 1, i, NovaCraftBlocks.cobbled_grimstone, NovaCraftBlocks.cobbled_grimstone, false);
                        this.fillWithBlocks(p_74875_1_, p_74875_3_, 12, 1, i, 12, 1, i, NovaCraftBlocks.cobbled_grimstone, NovaCraftBlocks.cobbled_grimstone, false);

                        int type_chance = (int) (1 + Math.random() * 10);
                        switch (type_chance) {
                            case 1:
                                this.fillWithMetadataBlocks(p_74875_1_, p_74875_3_, 1, 2, i, 1, 2, i, NovaCraftBlocks.copartz_cluster_2, 7, NovaCraftBlocks.copartz_cluster_2, 7, false);
                                this.fillWithMetadataBlocks(p_74875_1_, p_74875_3_, 12, 2, i, 12, 2, i, NovaCraftBlocks.copartz_cluster_2, 7, NovaCraftBlocks.copartz_cluster_2, 7, false);

                                if (this.isLargeRoom) {
                                    this.fillWithMetadataBlocks(p_74875_1_, p_74875_3_, 1, 7, i, 1, 7, i, NovaCraftBlocks.copartz_cluster_2, 7, NovaCraftBlocks.copartz_cluster_2, 7, false);
                                    this.fillWithMetadataBlocks(p_74875_1_, p_74875_3_, 12, 7, i, 12, 7, i, NovaCraftBlocks.copartz_cluster_2, 7, NovaCraftBlocks.copartz_cluster_2, 7, false);
                                }
                                break;
                            case 2:
                                this.fillWithMetadataBlocks(p_74875_1_, p_74875_3_, 1, 2, i, 1, 2, i, NovaCraftBlocks.larimar_cluster_2, 7, NovaCraftBlocks.larimar_cluster_2, 7, false);
                                this.fillWithMetadataBlocks(p_74875_1_, p_74875_3_, 12, 2, i, 12, 2, i, NovaCraftBlocks.larimar_cluster_2, 7, NovaCraftBlocks.larimar_cluster_2, 7, false);

                                if (this.isLargeRoom) {
                                    this.fillWithMetadataBlocks(p_74875_1_, p_74875_3_, 1, 7, i, 1, 7, i, NovaCraftBlocks.larimar_cluster_2, 7, NovaCraftBlocks.larimar_cluster_2, 7, false);
                                    this.fillWithMetadataBlocks(p_74875_1_, p_74875_3_, 12, 7, i, 12, 7, i, NovaCraftBlocks.larimar_cluster_2, 7, NovaCraftBlocks.larimar_cluster_2, 7, false);
                                }
                                break;
                            case 3:
                                this.fillWithMetadataBlocks(p_74875_1_, p_74875_3_, 1, 2, i, 1, 2, i, NovaCraftBlocks.tsavorokite_cluster_2, 7, NovaCraftBlocks.tsavorokite_cluster_2, 7, false);
                                this.fillWithMetadataBlocks(p_74875_1_, p_74875_3_, 12, 2, i, 12, 2, i, NovaCraftBlocks.tsavorokite_cluster_2, 7, NovaCraftBlocks.tsavorokite_cluster_2, 7, false);

                                if (this.isLargeRoom) {
                                    this.fillWithMetadataBlocks(p_74875_1_, p_74875_3_, 1, 7, i, 1, 7, i, NovaCraftBlocks.tsavorokite_cluster_2, 7, NovaCraftBlocks.tsavorokite_cluster_2, 7, false);
                                    this.fillWithMetadataBlocks(p_74875_1_, p_74875_3_, 12, 7, i, 12, 7, i, NovaCraftBlocks.tsavorokite_cluster_2, 7, NovaCraftBlocks.tsavorokite_cluster_2, 7, false);
                                }
                                break;
                            case 4:
                                this.fillWithMetadataBlocks(p_74875_1_, p_74875_3_, 1, 2, i, 1, 2, i, NovaCraftBlocks.yttrlinsite_cluster_2, 7, NovaCraftBlocks.yttrlinsite_cluster_2, 7, false);
                                this.fillWithMetadataBlocks(p_74875_1_, p_74875_3_, 12, 2, i, 12, 2, i, NovaCraftBlocks.yttrlinsite_cluster_2, 7, NovaCraftBlocks.yttrlinsite_cluster_2, 7, false);

                                if (this.isLargeRoom) {
                                    this.fillWithMetadataBlocks(p_74875_1_, p_74875_3_, 1, 7, i, 1, 7, i, NovaCraftBlocks.yttrlinsite_cluster_2, 7, NovaCraftBlocks.yttrlinsite_cluster_2, 7, false);
                                    this.fillWithMetadataBlocks(p_74875_1_, p_74875_3_, 12, 7, i, 12, 7, i, NovaCraftBlocks.yttrlinsite_cluster_2, 7, NovaCraftBlocks.yttrlinsite_cluster_2, 7, false);
                                }
                                break;
                            case 5:
                                this.fillWithMetadataBlocks(p_74875_1_, p_74875_3_, 1, 2, i, 1, 2, i, NovaCraftBlocks.aether_cluster_2, 1, NovaCraftBlocks.aether_cluster_2, 1, false);
                                this.fillWithMetadataBlocks(p_74875_1_, p_74875_3_, 12, 2, i, 12, 2, i, NovaCraftBlocks.aether_cluster_2, 1, NovaCraftBlocks.aether_cluster_2, 1, false);

                                if (this.isLargeRoom) {
                                    this.fillWithMetadataBlocks(p_74875_1_, p_74875_3_, 1, 7, i, 1, 7, i, NovaCraftBlocks.aether_cluster_2, 1, NovaCraftBlocks.aether_cluster_2, 1, false);
                                    this.fillWithMetadataBlocks(p_74875_1_, p_74875_3_, 12, 7, i, 12, 7, i, NovaCraftBlocks.aether_cluster_2, 1, NovaCraftBlocks.aether_cluster_2, 1, false);
                                }
                                break;
                            default:
                                break;
                        }

                        if (this.isLargeRoom)
                        {
                            this.fillWithBlocks(p_74875_1_, p_74875_3_, 1, 6, i, 1, 6, i, NovaCraftBlocks.cobbled_grimstone, NovaCraftBlocks.cobbled_grimstone, false);
                            this.fillWithBlocks(p_74875_1_, p_74875_3_, 12, 6, i, 12, 6, i, NovaCraftBlocks.cobbled_grimstone, NovaCraftBlocks.cobbled_grimstone, false);
                        }
                    }
                }

                if (this.isLargeRoom)
                {
                    this.fillWithBlocks(p_74875_1_, p_74875_3_, 1, 5, 1, 3, 5, 13, NovaCraftBlocks.grimstone_bricks, NovaCraftBlocks.grimstone_bricks, false);
                    this.fillWithBlocks(p_74875_1_, p_74875_3_, 10, 5, 1, 12, 5, 13, NovaCraftBlocks.grimstone_bricks, NovaCraftBlocks.grimstone_bricks, false);
                    this.fillWithBlocks(p_74875_1_, p_74875_3_, 4, 5, 1, 9, 5, 2, NovaCraftBlocks.grimstone_bricks, NovaCraftBlocks.grimstone_bricks, false);
                    this.fillWithBlocks(p_74875_1_, p_74875_3_, 4, 5, 12, 9, 5, 13, NovaCraftBlocks.grimstone_bricks, NovaCraftBlocks.grimstone_bricks, false);
                    this.placeBlockAtCurrentPosition(p_74875_1_, NovaCraftBlocks.grimstone_bricks, 0, 9, 5, 11, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, NovaCraftBlocks.grimstone_bricks, 0, 8, 5, 11, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, NovaCraftBlocks.grimstone_bricks, 0, 9, 5, 10, p_74875_3_);
                    this.fillWithBlocks(p_74875_1_, p_74875_3_, 3, 6, 2, 3, 6, 12, NovaCraftBlocks.cobbled_grimstone_wall, NovaCraftBlocks.cobbled_grimstone_wall, false);
                    this.fillWithBlocks(p_74875_1_, p_74875_3_, 10, 6, 2, 10, 6, 10, NovaCraftBlocks.cobbled_grimstone_wall, NovaCraftBlocks.cobbled_grimstone_wall, false);
                    this.fillWithBlocks(p_74875_1_, p_74875_3_, 4, 6, 2, 9, 6, 2, NovaCraftBlocks.cobbled_grimstone_wall, NovaCraftBlocks.cobbled_grimstone_wall, false);
                    this.fillWithBlocks(p_74875_1_, p_74875_3_, 4, 6, 12, 8, 6, 12, NovaCraftBlocks.cobbled_grimstone_wall, NovaCraftBlocks.cobbled_grimstone_wall, false);
                    this.placeBlockAtCurrentPosition(p_74875_1_, NovaCraftBlocks.cobbled_grimstone_wall, 0, 9, 6, 11, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, NovaCraftBlocks.cobbled_grimstone_wall, 0, 8, 6, 11, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, NovaCraftBlocks.cobbled_grimstone_wall, 0, 9, 6, 10, p_74875_3_);
                    i = this.getMetadataWithOffset(Blocks.ladder, 3);
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.ladder, i, 10, 1, 13, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.ladder, i, 10, 2, 13, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.ladder, i, 10, 3, 13, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.ladder, i, 10, 4, 13, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.ladder, i, 10, 5, 13, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.ladder, i, 10, 6, 13, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.ladder, i, 10, 7, 13, p_74875_3_);

                }

                if (this.isLargeRoom && !p_74875_1_.isRemote) {
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.air, 0, 12, 9, 1, p_74875_3_);
                    this.generateStructureChestContents(p_74875_1_, p_74875_3_, p_74875_2_, 12, 8, 1, ChestGenHooks.getItems(NC_TREASURE, p_74875_2_), ChestGenHooks.getCount(NC_TREASURE, p_74875_2_));

                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.air, i, 12, 9, 13, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, NovaCraftBlocks.treasure_chest, i, 12, 8, 13, p_74875_3_);
                }

                if (!this.hasSpawner) {
                    int i1 = this.getYWithOffset(1);
                    int k = this.getXWithOffset(8, 4);
                    int l = this.getZWithOffset(8, 4);
                    if (p_74875_3_.isVecInside(k, i1, l))
                    {
                        this.hasSpawner = true;
                        p_74875_1_.setBlock(k, i1, l, Blocks.mob_spawner, 0, 2);
                        TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner)p_74875_1_.getTileEntity(k, i1, l);

                        if (tileentitymobspawner != null)
                        {
                            tileentitymobspawner.func_145881_a().setEntityName("nova_craft.relik");
                        }
                    }
                }

                return true;
            }
        }
    }

    public static class NCFurnaceRoom extends NCStructureStrongholdPieces.Stronghold {
        private boolean hasSpawner;

        public NCFurnaceRoom() {}

        public NCFurnaceRoom(int p_i2075_1_, Random p_i2075_2_, StructureBoundingBox p_i2075_3_, int p_i2075_4_)
        {
            super(p_i2075_1_);
            this.coordBaseMode = p_i2075_4_;
            this.field_143013_d = this.getRandomDoor(p_i2075_2_);
            this.boundingBox = p_i2075_3_;
        }

        protected void func_143012_a(NBTTagCompound p_143012_1_) {
            super.func_143012_a(p_143012_1_);
            p_143012_1_.setBoolean("Mob", this.hasSpawner);
        }

        protected void func_143011_b(NBTTagCompound p_143011_1_)
        {
            super.func_143011_b(p_143011_1_);
        }

        public static NCStructureStrongholdPieces.NCFurnaceRoom findValidPlacement(List p_75006_0_, Random p_75006_1_, int p_75006_2_, int p_75006_3_, int p_75006_4_, int p_75006_5_, int p_75006_6_)
        {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_75006_2_, p_75006_3_, p_75006_4_, -4, -1, 0, 14, 11, 15, p_75006_5_);

            if (!canStrongholdGoDeeper(structureboundingbox) || StructureComponent.findIntersecting(p_75006_0_, structureboundingbox) != null)
            {
                structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_75006_2_, p_75006_3_, p_75006_4_, -4, -1, 0, 14, 6, 15, p_75006_5_);

                if (!canStrongholdGoDeeper(structureboundingbox) || StructureComponent.findIntersecting(p_75006_0_, structureboundingbox) != null)
                {
                    return null;
                }
            }

            return new NCStructureStrongholdPieces.NCFurnaceRoom(p_75006_6_, p_75006_1_, structureboundingbox, p_75006_5_);
        }


        public boolean addComponentParts(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_)
        {
            if (this.isLiquidInStructureBoundingBox(p_74875_1_, p_74875_3_))
            {
                return false;
            }
            else
            {

                int b0 = 6;

                this.fillWithRandomizedBlocks(p_74875_1_, p_74875_3_, 0, 0, 0, 13, b0 - 1, 14, true, p_74875_2_, NCStructureStrongholdPieces.strongholdStones);
                this.placeDoor(p_74875_1_, p_74875_2_, p_74875_3_, this.field_143013_d, 4, 1, 0);
                int i;

                for (i = 1; i <= 13; ++i)
                {
                    if ((i - 1) % 4 == 0)
                    {
                        this.fillWithBlocks(p_74875_1_, p_74875_3_, 1, 1, i, 1, 4, i, NovaCraftBlocks.etherstone_bricks, NovaCraftBlocks.etherstone_bricks, false);
                        this.fillWithBlocks(p_74875_1_, p_74875_3_, 12, 1, i, 12, 4, i, NovaCraftBlocks.etherstone_bricks, NovaCraftBlocks.etherstone_bricks, false);

                    }
                    else
                    {
                        this.fillWithBlocks(p_74875_1_, p_74875_3_, 1, 1, i, 1, 1, i, NovaCraftBlocks.cobbled_etherstone, NovaCraftBlocks.cobbled_etherstone, false);
                        this.fillWithBlocks(p_74875_1_, p_74875_3_, 12, 1, i, 12, 1, i, NovaCraftBlocks.cobbled_etherstone, NovaCraftBlocks.cobbled_etherstone, false);
                    }
                }

                if (!p_74875_1_.isRemote) {
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.air, 0, 12, 4, 1, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.air, 0, 12, 3, 1, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, NovaCraftBlocks.cobbled_etherstone, 0, 12, 1, 1, p_74875_3_);
                    this.generateStructureChestContents(p_74875_1_, p_74875_3_, p_74875_2_, 12, 2, 1, ChestGenHooks.getItems(NC_FURNACE, p_74875_2_), ChestGenHooks.getCount(NC_FURNACE, p_74875_2_));

                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.air, 0, 12, 4, 13, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.air, 0, 12, 3, 13, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, NovaCraftBlocks.cobbled_etherstone, 0, 12, 1, 13, p_74875_3_);
                    this.generateStructureChestContents(p_74875_1_, p_74875_3_, p_74875_2_, 12, 2, 13, ChestGenHooks.getItems(NC_FURNACE, p_74875_2_), ChestGenHooks.getCount(NC_FURNACE, p_74875_2_));
                }

                this.placeBlockAtCurrentPosition(p_74875_1_, placeIridiumBricks(p_74875_2_), 0, 5, 2, 6, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, placeIridiumBricks(p_74875_2_), 0, 6, 2, 6, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, placeIridiumBricks(p_74875_2_), 0, 7, 2, 6, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, placeIridiumBricks(p_74875_2_), 0, 5, 2, 10, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, placeIridiumBricks(p_74875_2_), 0, 6, 2, 10, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, placeIridiumBricks(p_74875_2_), 0, 7, 2, 10, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, placeIridiumBricks(p_74875_2_), 0, 4, 2, 7, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, placeIridiumBricks(p_74875_2_), 0, 4, 2, 8, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, placeIridiumBricks(p_74875_2_), 0, 4, 2, 9, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, placeIridiumBricks(p_74875_2_), 0, 8, 2, 7, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, placeIridiumBricks(p_74875_2_), 0, 8, 2, 8, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, placeIridiumBricks(p_74875_2_), 0, 8, 2, 9, p_74875_3_);

                //this.placeBlockAtCurrentPosition(p_74875_1_, placeIridiumBricks(p_74875_2_), 0, 5, 3, 6, p_74875_3_);
                //this.placeBlockAtCurrentPosition(p_74875_1_, placeIridiumBricks(p_74875_2_), 0, 6, 3, 6, p_74875_3_);
                //this.placeBlockAtCurrentPosition(p_74875_1_, placeIridiumBricks(p_74875_2_), 0, 7, 3, 6, p_74875_3_);
                //this.placeBlockAtCurrentPosition(p_74875_1_, placeIridiumBricks(p_74875_2_), 0, 5, 3, 10, p_74875_3_);
                //this.placeBlockAtCurrentPosition(p_74875_1_, placeIridiumBricks(p_74875_2_), 0, 6, 3, 10, p_74875_3_);
                //this.placeBlockAtCurrentPosition(p_74875_1_, placeIridiumBricks(p_74875_2_), 0, 7, 3, 10, p_74875_3_);
                //this.placeBlockAtCurrentPosition(p_74875_1_, placeIridiumBricks(p_74875_2_), 0, 4, 3, 7, p_74875_3_);
                //this.placeBlockAtCurrentPosition(p_74875_1_, placeIridiumBricks(p_74875_2_), 0, 4, 3, 8, p_74875_3_); //
                //this.placeBlockAtCurrentPosition(p_74875_1_, placeIridiumBricks(p_74875_2_), 0, 4, 3, 9, p_74875_3_);
                //this.placeBlockAtCurrentPosition(p_74875_1_, placeIridiumBricks(p_74875_2_), 0, 8, 3, 7, p_74875_3_);
                //this.placeBlockAtCurrentPosition(p_74875_1_, placeIridiumBricks(p_74875_2_), 0, 8, 3, 8, p_74875_3_); //
                //this.placeBlockAtCurrentPosition(p_74875_1_, placeIridiumBricks(p_74875_2_), 0, 8, 3, 9, p_74875_3_);

                this.placeBlockAtCurrentPosition(p_74875_1_, NovaCraftBlocks.iridium_furnace, 2, 6, 2, 5, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, NovaCraftBlocks.iridium_bricks, 0, 6, 1, 5, p_74875_3_);

                this.placeBlockAtCurrentPosition(p_74875_1_, NovaCraftBlocks.iridium_bricks, 0, 5, 1, 5, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, placeIridiumBricks(p_74875_2_), 0, 7, 1, 5, p_74875_3_);

                this.placeBlockAtCurrentPosition(p_74875_1_, placeIridiumBricks(p_74875_2_), 0, 6, 1, 6, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, NovaCraftBlocks.iridium_bricks, 0, 6, 1, 7, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, NovaCraftBlocks.iridium_bricks, 0, 6, 1, 8, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, placeIridiumBricks(p_74875_2_), 0, 6, 1, 9, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, NovaCraftBlocks.iridium_bricks, 0, 6, 1, 10, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, NovaCraftBlocks.iridium_bricks, 0, 6, 1, 11, p_74875_3_);

                this.placeBlockAtCurrentPosition(p_74875_1_, NovaCraftBlocks.iridium_bricks, 0, 7, 1, 6, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, placeIridiumBricks(p_74875_2_), 0, 7, 1, 7, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, NovaCraftBlocks.iridium_bricks, 0, 7, 1, 8, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, NovaCraftBlocks.iridium_bricks, 0, 7, 1, 9, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, NovaCraftBlocks.iridium_bricks, 0, 7, 1, 10, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, NovaCraftBlocks.iridium_bricks, 0, 7, 1, 11, p_74875_3_);

                this.placeBlockAtCurrentPosition(p_74875_1_, placeIridiumBricks(p_74875_2_), 0, 5, 1, 6, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, NovaCraftBlocks.iridium_bricks, 0, 5, 1, 7, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, NovaCraftBlocks.iridium_bricks, 0, 5, 1, 8, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, placeIridiumBricks(p_74875_2_), 0, 5, 1, 9, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, NovaCraftBlocks.iridium_bricks, 0, 5, 1, 10, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, NovaCraftBlocks.iridium_bricks, 0, 5, 1, 11, p_74875_3_);

                this.placeBlockAtCurrentPosition(p_74875_1_, NovaCraftBlocks.iridium_bricks, 0, 4, 1, 6, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, placeIridiumBricks(p_74875_2_), 0, 4, 1, 7, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, NovaCraftBlocks.iridium_bricks, 0, 4, 1, 8, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, NovaCraftBlocks.iridium_bricks, 0, 4, 1, 9, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, NovaCraftBlocks.iridium_bricks, 0, 4, 1, 10, p_74875_3_);

                this.placeBlockAtCurrentPosition(p_74875_1_, NovaCraftBlocks.iridium_bricks, 0, 8, 1, 6, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, NovaCraftBlocks.iridium_bricks, 0, 8, 1, 7, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, placeIridiumBricks(p_74875_2_), 0, 8, 1, 8, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, placeIridiumBricks(p_74875_2_), 0, 8, 1, 9, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, NovaCraftBlocks.iridium_bricks, 0, 8, 1, 10, p_74875_3_);

                this.placeBlockAtCurrentPosition(p_74875_1_, placeIridiumBricks(p_74875_2_), 0, 3, 1, 7, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, NovaCraftBlocks.iridium_bricks, 0, 3, 1, 8, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, NovaCraftBlocks.iridium_bricks, 0, 3, 1, 9, p_74875_3_);

                this.placeBlockAtCurrentPosition(p_74875_1_, NovaCraftBlocks.iridium_bricks, 0, 9, 1, 7, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, placeIridiumBricks(p_74875_2_), 0, 9, 1, 8, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, placeIridiumBricks(p_74875_2_), 0, 9, 1, 9, p_74875_3_);

                //this.placeBlockAtCurrentPosition(p_74875_1_, placeIridiumBricks(p_74875_2_), 0, 6, 3, 7, p_74875_3_);
                //this.placeBlockAtCurrentPosition(p_74875_1_, placeIridiumBricks(p_74875_2_), 0, 6, 3, 9, p_74875_3_);
                //this.placeBlockAtCurrentPosition(p_74875_1_, placeIridiumBricks(p_74875_2_), 0, 5, 3, 7, p_74875_3_);
                //this.placeBlockAtCurrentPosition(p_74875_1_, placeIridiumBricks(p_74875_2_), 0, 5, 3, 8, p_74875_3_);
                //this.placeBlockAtCurrentPosition(p_74875_1_, placeIridiumBricks(p_74875_2_), 0, 5, 3, 9, p_74875_3_);
                //this.placeBlockAtCurrentPosition(p_74875_1_, placeIridiumBricks(p_74875_2_), 0, 7, 3, 7, p_74875_3_);
                //this.placeBlockAtCurrentPosition(p_74875_1_, placeIridiumBricks(p_74875_2_), 0, 7, 3, 8, p_74875_3_);
                //this.placeBlockAtCurrentPosition(p_74875_1_, placeIridiumBricks(p_74875_2_), 0, 7, 3, 9, p_74875_3_);

                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.anvil, 2, 11, 1, 5, p_74875_3_);

                if (!this.hasSpawner) {
                    int i1 = this.getYWithOffset(1);
                    int k = this.getXWithOffset(4, 3);
                    int l = this.getZWithOffset(4, 3);

                    if (p_74875_3_.isVecInside(k, i1, l))
                    {
                        this.hasSpawner = true;
                        p_74875_1_.setBlock(k, i1, l, Blocks.mob_spawner, 0, 2);
                        TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner)p_74875_1_.getTileEntity(k, i1, l);

                        if (tileentitymobspawner != null)
                        {
                            tileentitymobspawner.func_145881_a().setEntityName("nova_craft.relik");
                        }
                    }
                }

                return true;
            }
        }
    }

    public static class NCSpawnerRoom extends NCStructureStrongholdPieces.Stronghold {
        private boolean hasSpawner;

        public NCSpawnerRoom() {}

        public NCSpawnerRoom(int p_i2075_1_, Random p_i2075_2_, StructureBoundingBox p_i2075_3_, int p_i2075_4_)
        {
            super(p_i2075_1_);
            this.coordBaseMode = p_i2075_4_;
            this.field_143013_d = this.getRandomDoor(p_i2075_2_);
            this.boundingBox = p_i2075_3_;
        }

        protected void func_143012_a(NBTTagCompound p_143012_1_) {
            super.func_143012_a(p_143012_1_);
            p_143012_1_.setBoolean("Mob", this.hasSpawner);
        }

        protected void func_143011_b(NBTTagCompound p_143011_1_)
        {
            super.func_143011_b(p_143011_1_);
        }

        public static NCStructureStrongholdPieces.NCSpawnerRoom findValidPlacement(List p_75006_0_, Random p_75006_1_, int p_75006_2_, int p_75006_3_, int p_75006_4_, int p_75006_5_, int p_75006_6_)
        {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_75006_2_, p_75006_3_, p_75006_4_, -4, -1, 0, 14, 11, 15, p_75006_5_);

            if (!canStrongholdGoDeeper(structureboundingbox) || StructureComponent.findIntersecting(p_75006_0_, structureboundingbox) != null)
            {
                structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_75006_2_, p_75006_3_, p_75006_4_, -4, -1, 0, 14, 6, 15, p_75006_5_);

                if (!canStrongholdGoDeeper(structureboundingbox) || StructureComponent.findIntersecting(p_75006_0_, structureboundingbox) != null)
                {
                    return null;
                }
            }

            return new NCStructureStrongholdPieces.NCSpawnerRoom(p_75006_6_, p_75006_1_, structureboundingbox, p_75006_5_);
        }


        public boolean addComponentParts(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_)
        {
            if (this.isLiquidInStructureBoundingBox(p_74875_1_, p_74875_3_))
            {
                return false;
            }
            else
            {

                int b0 = 6;

                this.fillWithRandomizedBlocks(p_74875_1_, p_74875_3_, 0, 0, 0, 13, b0 - 1, 14, true, p_74875_2_, NCStructureStrongholdPieces.strongholdStones);
                this.placeDoor(p_74875_1_, p_74875_2_, p_74875_3_, this.field_143013_d, 4, 1, 0);
                this.randomlyFillWithBlocks(p_74875_1_, p_74875_3_, p_74875_2_, 0.11F, 2, 1, 1, 11, 1, 13, Blocks.web, Blocks.web, false);
                int i;

                int metadata = (int)(Math.random() * 3);

                for (i = 1; i <= 13; ++i)
                {
                    if ((i - 1) % 4 == 0)
                    {
                        this.fillWithMetadataBlocks(p_74875_1_, p_74875_3_, 1, 1, i, 1, 4, i, Blocks.stonebrick, metadata, Blocks.stonebrick, metadata, false);
                        this.fillWithMetadataBlocks(p_74875_1_, p_74875_3_, 12, 1, i, 12, 4, i, Blocks.stonebrick, metadata, Blocks.stonebrick, metadata, false);

                    }
                    else
                    {
                        this.fillWithMetadataBlocks(p_74875_1_, p_74875_3_, 1, 1, i, 1, 3, i, Blocks.iron_bars, metadata, Blocks.iron_bars, metadata, false);
                        this.fillWithMetadataBlocks(p_74875_1_, p_74875_3_, 12, 1, i, 12, 3, i, Blocks.iron_bars, metadata, Blocks.iron_bars, metadata, false);
                    }
                }

                if (!p_74875_1_.isRemote) {
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.air, 0, 12, 4, 1, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.air, 0, 12, 3, 1, p_74875_3_);

                    this.generateStructureChestContents(p_74875_1_, p_74875_3_, p_74875_2_, 9, 1, 3, ChestGenHooks.getItems(NC_TREASURE, p_74875_2_), ChestGenHooks.getCount(NC_TREASURE, p_74875_2_));

                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.air, 0, 12, 4, 13, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.air, 0, 12, 3, 13, p_74875_3_);

                    this.generateStructureChestContents(p_74875_1_, p_74875_3_, p_74875_2_, 4, 1, 9, ChestGenHooks.getItems(NC_TREASURE, p_74875_2_), ChestGenHooks.getCount(NC_TREASURE, p_74875_2_));
                }

                if (!this.hasSpawner) {
                    int i1 = this.getYWithOffset(1);
                    int k = this.getXWithOffset(6, 5);
                    int l = this.getZWithOffset(6, 5);

                    if (p_74875_3_.isVecInside(k, i1, l))
                    {
                        this.hasSpawner = true;
                        p_74875_1_.setBlock(k, i1, l, Blocks.mob_spawner, 0, 2);
                        TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner)p_74875_1_.getTileEntity(k, i1, l);

                        if (tileentitymobspawner != null && p_74875_2_.nextBoolean()) {
                            tileentitymobspawner.func_145881_a().setEntityName("Zombie");

                            //Get the NBT data from the spawner
                            NBTTagCompound spawnerNBT = new NBTTagCompound();
                            tileentitymobspawner.writeToNBT(spawnerNBT);

                            //Modify SpawnData to customize the spawned zombie
                            NBTTagCompound spawnData = new NBTTagCompound();
                            spawnData.setString("id", "Zombie");

                            //Give the mob a Resistance effect
                            NBTTagList effects = new NBTTagList();

                            NBTTagCompound resistanceEffect = new NBTTagCompound();
                            resistanceEffect.setByte("Id", (byte) 11); //Resistance effect ID
                            resistanceEffect.setByte("Amplifier", (byte) 2); //Level 2 Resistance
                            resistanceEffect.setInteger("Duration", Integer.MAX_VALUE); //Infinite duration
                            resistanceEffect.setByte("Ambient", (byte) 1);
                            resistanceEffect.setByte("ShowParticles", (byte) 0); //Invisible effect???

                            effects.appendTag(resistanceEffect);
                            spawnData.setTag("ActiveEffects", effects);

                            //Gives weapon
                            NBTTagList equipment = new NBTTagList();

                            NBTTagCompound weapon = new NBTTagCompound();
                            ItemStack sword = new ItemStack(Items.diamond_sword);
                            sword.writeToNBT(weapon);
                            equipment.appendTag(weapon);

                            //Fill remaining slots with empty tags to prevent overwriting other equipment
                            for (int a = 1; a < 5; a++) {
                                equipment.appendTag(new NBTTagCompound());
                            }
                            spawnData.setTag("Equipment", equipment);

                            //Prevent the weapon from being removed or replaced
                            NBTTagList dropChances = new NBTTagList();
                            dropChances.appendTag(new NBTTagFloat(0.0F)); //Weapon (never drops)
                            for (int a = 1; a < 5; a++) {
                                dropChances.appendTag(new NBTTagFloat(0.085F)); //Default drop chance for empty slots
                            }
                            spawnData.setTag("DropChances", dropChances);

                            //Apply SpawnData to spawner
                            spawnerNBT.setTag("SpawnData", spawnData);

                            //Write the modified NBT data back to the spawner
                            tileentitymobspawner.readFromNBT(spawnerNBT);
                        } else {
                            tileentitymobspawner.func_145881_a().setEntityName("Skeleton");

                            NBTTagCompound spawnerNBT = new NBTTagCompound();
                            tileentitymobspawner.writeToNBT(spawnerNBT);

                            NBTTagCompound spawnData = new NBTTagCompound();
                            spawnData.setString("id", "Skeleton");

                            NBTTagList effects = new NBTTagList();

                            NBTTagCompound resistanceEffect = new NBTTagCompound();
                            resistanceEffect.setByte("Id", (byte) 11);
                            resistanceEffect.setByte("Amplifier", (byte) 2);
                            resistanceEffect.setInteger("Duration", Integer.MAX_VALUE);
                            resistanceEffect.setByte("Ambient", (byte) 1);
                            resistanceEffect.setByte("ShowParticles", (byte) 0);

                            effects.appendTag(resistanceEffect);
                            spawnData.setTag("ActiveEffects", effects);

                            NBTTagList equipment = new NBTTagList();

                            NBTTagCompound weapon = new NBTTagCompound();
                            ItemStack sword = new ItemStack(Items.bow);
                            sword.writeToNBT(weapon);
                            equipment.appendTag(weapon);

                            for (int a = 1; a < 5; a++) {
                                equipment.appendTag(new NBTTagCompound());
                            }
                            spawnData.setTag("Equipment", equipment);

                            NBTTagList dropChances = new NBTTagList();
                            dropChances.appendTag(new NBTTagFloat(0.0F));
                            for (int a = 1; a < 5; a++) {
                                dropChances.appendTag(new NBTTagFloat(0.085F));
                            }
                            spawnData.setTag("DropChances", dropChances);

                            spawnerNBT.setTag("SpawnData", spawnData);

                            tileentitymobspawner.readFromNBT(spawnerNBT);
                        }
                    }
                    int i12 = this.getYWithOffset(1);
                    int k2 = this.getXWithOffset(11, 3);
                    int l2 = this.getZWithOffset(11, 3);

                    if (p_74875_3_.isVecInside(k2, i12, l2))
                    {
                        this.hasSpawner = true;
                        p_74875_1_.setBlock(k2, i12, l2, Blocks.mob_spawner, 0, 2);
                        TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner)p_74875_1_.getTileEntity(k2, i12, l2);

                        if (tileentitymobspawner != null)
                        {
                            tileentitymobspawner.func_145881_a().setEntityName("nova_craft.relik");
                        }
                    }
                }

                return true;
            }
        }
    }

    public static class NCTreasureRoom extends NCStructureStrongholdPieces.Stronghold {
        private boolean hasSpawner;

        public NCTreasureRoom() {}

        public NCTreasureRoom(int p_i2075_1_, Random p_i2075_2_, StructureBoundingBox p_i2075_3_, int p_i2075_4_)
        {
            super(p_i2075_1_);
            this.coordBaseMode = p_i2075_4_;
            this.field_143013_d = this.getRandomDoor(p_i2075_2_);
            this.boundingBox = p_i2075_3_;
        }

        protected void func_143012_a(NBTTagCompound p_143012_1_) {
            super.func_143012_a(p_143012_1_);
            p_143012_1_.setBoolean("Mob", this.hasSpawner);
        }

        protected void func_143011_b(NBTTagCompound p_143011_1_)
        {
            super.func_143011_b(p_143011_1_);
        }

        public static NCStructureStrongholdPieces.NCTreasureRoom findValidPlacement(List p_75006_0_, Random p_75006_1_, int p_75006_2_, int p_75006_3_, int p_75006_4_, int p_75006_5_, int p_75006_6_)
        {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_75006_2_, p_75006_3_, p_75006_4_, -4, -1, 0, 14, 11, 15, p_75006_5_);

            if (!canStrongholdGoDeeper(structureboundingbox) || StructureComponent.findIntersecting(p_75006_0_, structureboundingbox) != null)
            {
                structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_75006_2_, p_75006_3_, p_75006_4_, -4, -1, 0, 14, 6, 15, p_75006_5_);

                if (!canStrongholdGoDeeper(structureboundingbox) || StructureComponent.findIntersecting(p_75006_0_, structureboundingbox) != null)
                {
                    return null;
                }
            }

            return new NCStructureStrongholdPieces.NCTreasureRoom(p_75006_6_, p_75006_1_, structureboundingbox, p_75006_5_);
        }


        public boolean addComponentParts(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_)
        {
            if (this.isLiquidInStructureBoundingBox(p_74875_1_, p_74875_3_))
            {
                return false;
            }
            else
            {

                int b0 = 6;

                this.fillWithRandomizedBlocks(p_74875_1_, p_74875_3_, 0, 0, 0, 13, b0 - 1, 14, true, p_74875_2_, NCStructureStrongholdPieces.strongholdStones);
                this.placeDoor(p_74875_1_, p_74875_2_, p_74875_3_, this.field_143013_d, 4, 1, 0);
                int i;

                for (i = 1; i <= 13; ++i)
                {
                    if ((i - 1) % 4 == 0)
                    {

                    }
                    else
                    {
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 11, 1, 12, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 10, 1, 12, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 9, 1, 12, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 8, 1, 12, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 7, 1, 12, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 6, 1, 12, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 5, 1, 12, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 4, 1, 12, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 3, 1, 12, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 2, 1, 12, p_74875_3_);

                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 11, 1, 11, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 10, 1, 11, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 9, 1, 11, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 8, 1, 11, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 7, 1, 11, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 6, 1, 11, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 5, 1, 11, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 4, 1, 11, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 3, 1, 11, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 2, 1, 11, p_74875_3_);

                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 11, 1, 10, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 10, 1, 10, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 9, 1, 10, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 8, 1, 10, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 7, 1, 10, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 6, 1, 10, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 5, 1, 10, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 4, 1, 10, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 3, 1, 10, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 2, 1, 10, p_74875_3_);

                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 11, 1, 9, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 10, 1, 9, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 9, 1, 9, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 8, 1, 9, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 7, 1, 9, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 6, 1, 9, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 5, 1, 9, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 4, 1, 9, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 3, 1, 9, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 2, 1, 9, p_74875_3_);

                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 11, 1, 8, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 10, 1, 8, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 9, 1, 8, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 8, 1, 8, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 7, 1, 8, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 6, 1, 8, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 5, 1, 8, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 4, 1, 8, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 3, 1, 8, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 2, 1, 8, p_74875_3_);

                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 11, 1, 7, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 10, 1, 7, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 9, 1, 7, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 8, 1, 7, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 7, 1, 7, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 6, 1, 7, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 5, 1, 7, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 4, 1, 7, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 3, 1, 7, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 2, 1, 7, p_74875_3_);

                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 11, 1, 6, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 10, 1, 6, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 9, 1, 6, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 8, 1, 6, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 7, 1, 6, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 6, 1, 6, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 5, 1, 6, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 4, 1, 6, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 3, 1, 6, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 2, 1, 6, p_74875_3_);

                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 11, 1, 5, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 10, 1, 5, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 9, 1, 5, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 8, 1, 5, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 7, 1, 5, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 6, 1, 5, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 5, 1, 5, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 4, 1, 5, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 3, 1, 5, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 2, 1, 5, p_74875_3_);

                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 11, 1, 4, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 10, 1, 4, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 9, 1, 4, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 8, 1, 4, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 7, 1, 4, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 6, 1, 4, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 5, 1, 4, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 4, 1, 4, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 3, 1, 4, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 2, 1, 4, p_74875_3_);

                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 11, 1, 3, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 10, 1, 3, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 9, 1, 3, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 8, 1, 3, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 7, 1, 3, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 6, 1, 3, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 5, 1, 3, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 4, 1, 3, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 3, 1, 3, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 2, 1, 3, p_74875_3_);

                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 11, 1, 2, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 10, 1, 2, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 9, 1, 2, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 8, 1, 2, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 7, 1, 2, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 6, 1, 2, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 5, 1, 2, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 4, 1, 2, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 3, 1, 2, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, placeGemstonePile(p_74875_2_), p_74875_2_.nextInt(8), 2, 1, 2, p_74875_3_);

                    }
                }

                if (!this.hasSpawner) {
                    int i1 = this.getYWithOffset(1);
                    int k = this.getXWithOffset(12, 5);
                    int l = this.getZWithOffset(12, 5);

                    if (p_74875_3_.isVecInside(k, i1, l))
                    {
                        this.hasSpawner = true;
                        p_74875_1_.setBlock(k, i1, l, Blocks.mob_spawner, 0, 2);
                        TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner)p_74875_1_.getTileEntity(k, i1, l);

                        if (tileentitymobspawner != null) {
                            tileentitymobspawner.func_145881_a().setEntityName("nova_craft.relik");
                        }
                    }

                    int i12 = this.getYWithOffset(1);
                    int k2 = this.getXWithOffset(7, 12);
                    int l2 = this.getZWithOffset(7, 12);

                    if (p_74875_3_.isVecInside(k2, i12, l2))
                    {
                        this.hasSpawner = true;
                        p_74875_1_.setBlock(k2, i12, l2, Blocks.mob_spawner, 0, 2);
                        TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner)p_74875_1_.getTileEntity(k2, i12, l2);

                        if (tileentitymobspawner != null) {
                            tileentitymobspawner.func_145881_a().setEntityName("nova_craft.relik");
                        }
                    }
                }

                return true;
            }
        }
    }

    private static Block placeIridiumBricks(Random random) {
        if (random.nextDouble() < 0.15) {
            return NovaCraftBlocks.iridium_bricks;
        } else {
            return Blocks.air;
        }
    }

    private static Block placeGemstonePile(Random random) {
        if (random.nextDouble() < 0.15) {
            return NovaCraftBlocks.iron_pile;
        } else if (random.nextDouble() >= 0.15 && random.nextDouble() < 0.20) {
            return NovaCraftBlocks.lapis_pile;
        } else if (random.nextDouble() >= 0.20 && random.nextDouble() < 0.35) {
            return NovaCraftBlocks.gold_pile;
        } else if (random.nextDouble() >= 0.35 && random.nextDouble() < 0.50) {
            return NovaCraftBlocks.crystal_pile;
        } else if (random.nextDouble() >= 0.50 && random.nextDouble() < 0.65) {
            return NovaCraftBlocks.vanite_pile;
        } else if (random.nextDouble() >= 0.65 && random.nextDouble() < 0.80) {
            if (Configs.enableTreasureCratesDropDiamonds) {
                return NovaCraftBlocks.diamond_pile;
            } else {
                return NovaCraftBlocks.crystal_pile;
            }
        } else {
            return Blocks.air;
        }
    }

    static class PieceWeight
    {
        public Class pieceClass;
        public final int pieceWeight;
        public int instancesSpawned;
        public int instancesLimit;

        public PieceWeight(Class p_i2076_1_, int p_i2076_2_, int p_i2076_3_)
        {
            this.pieceClass = p_i2076_1_;
            this.pieceWeight = p_i2076_2_;
            this.instancesLimit = p_i2076_3_;
        }

        public boolean canSpawnMoreStructuresOfType(int p_75189_1_)
        {
            return this.instancesLimit == 0 || this.instancesSpawned < this.instancesLimit;
        }

        public boolean canSpawnMoreStructures()
        {
            return this.instancesLimit == 0 || this.instancesSpawned < this.instancesLimit;
        }
    }

    public static class NCPortalRoom extends NCStructureStrongholdPieces.Stronghold
    {
        private boolean hasSpawner;

        public NCPortalRoom() {}

        public NCPortalRoom(int p_i2077_1_, Random p_i2077_2_, StructureBoundingBox p_i2077_3_, int p_i2077_4_)
        {
            super(p_i2077_1_);
            this.coordBaseMode = p_i2077_4_;
            this.boundingBox = p_i2077_3_;
        }

        protected void func_143012_a(NBTTagCompound p_143012_1_)
        {
            super.func_143012_a(p_143012_1_);
            p_143012_1_.setBoolean("Mob", this.hasSpawner);
        }

        protected void func_143011_b(NBTTagCompound p_143011_1_)
        {
            super.func_143011_b(p_143011_1_);
            this.hasSpawner = p_143011_1_.getBoolean("Mob");
        }


        public void buildComponent(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_)
        {
            if (p_74861_1_ != null)
            {
                ((NCStructureStrongholdPieces.NCStairs2)p_74861_1_).strongholdNCPortalRoom = this;
            }
        }

        public static NCStructureStrongholdPieces.NCPortalRoom findValidPlacement(List p_75004_0_, Random p_75004_1_, int p_75004_2_, int p_75004_3_, int p_75004_4_, int p_75004_5_, int p_75004_6_)
        {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_75004_2_, p_75004_3_, p_75004_4_, -4, -1, 0, 11, 8, 16, p_75004_5_);

            return canStrongholdGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(p_75004_0_, structureboundingbox) == null ? new NCStructureStrongholdPieces.NCPortalRoom(p_75004_6_, p_75004_1_, structureboundingbox, p_75004_5_) : null;
        }


        public boolean addComponentParts(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_)
        {
            this.fillWithRandomizedBlocks(p_74875_1_, p_74875_3_, 0, 0, 0, 10, 7, 15, false, p_74875_2_, NCStructureStrongholdPieces.strongholdStones);
            this.placeDoor(p_74875_1_, p_74875_2_, p_74875_3_, NCStructureStrongholdPieces.Stronghold.Door.GRATES, 4, 1, 0);
            byte b0 = 6;
            this.fillWithRandomizedBlocks(p_74875_1_, p_74875_3_, 1, b0, 1, 1, b0, 14, false, p_74875_2_, NCStructureStrongholdPieces.strongholdStones);
            this.fillWithRandomizedBlocks(p_74875_1_, p_74875_3_, 9, b0, 1, 9, b0, 14, false, p_74875_2_, NCStructureStrongholdPieces.strongholdStones);
            this.fillWithRandomizedBlocks(p_74875_1_, p_74875_3_, 2, b0, 1, 8, b0, 2, false, p_74875_2_, NCStructureStrongholdPieces.strongholdStones);
            this.fillWithRandomizedBlocks(p_74875_1_, p_74875_3_, 2, b0, 14, 8, b0, 14, false, p_74875_2_, NCStructureStrongholdPieces.strongholdStones);
            this.fillWithRandomizedBlocks(p_74875_1_, p_74875_3_, 1, 1, 1, 2, 1, 4, false, p_74875_2_, NCStructureStrongholdPieces.strongholdStones);
            this.fillWithRandomizedBlocks(p_74875_1_, p_74875_3_, 8, 1, 1, 9, 1, 4, false, p_74875_2_, NCStructureStrongholdPieces.strongholdStones);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 1, 1, 1, 1, 1, 3, Blocks.flowing_lava, Blocks.flowing_lava, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 9, 1, 1, 9, 1, 3, Blocks.flowing_lava, Blocks.flowing_lava, false);
            this.fillWithRandomizedBlocks(p_74875_1_, p_74875_3_, 3, 1, 8, 7, 1, 12, false, p_74875_2_, NCStructureStrongholdPieces.strongholdStones);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 4, 1, 9, 6, 1, 11, Blocks.flowing_lava, Blocks.flowing_lava, false);
            int i;

            for (i = 3; i < 14; i += 2)
            {
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 3, i, 0, 4, i, Blocks.iron_bars, Blocks.iron_bars, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 10, 3, i, 10, 4, i, Blocks.iron_bars, Blocks.iron_bars, false);
            }

            for (i = 2; i < 9; i += 2)
            {
                this.fillWithBlocks(p_74875_1_, p_74875_3_, i, 3, 15, i, 4, 15, Blocks.iron_bars, Blocks.iron_bars, false);
            }

            i = this.getMetadataWithOffset(Blocks.stone_brick_stairs, 3);
            this.fillWithRandomizedBlocks(p_74875_1_, p_74875_3_, 4, 1, 5, 6, 1, 7, false, p_74875_2_, NCStructureStrongholdPieces.strongholdStones);
            this.fillWithRandomizedBlocks(p_74875_1_, p_74875_3_, 4, 2, 6, 6, 2, 7, false, p_74875_2_, NCStructureStrongholdPieces.strongholdStones);
            this.fillWithRandomizedBlocks(p_74875_1_, p_74875_3_, 4, 3, 7, 6, 3, 7, false, p_74875_2_, NCStructureStrongholdPieces.strongholdStones);

            for (int j = 4; j <= 6; ++j)
            {
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.stone_brick_stairs, i, j, 1, 4, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.stone_brick_stairs, i, j, 2, 5, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.stone_brick_stairs, i, j, 3, 6, p_74875_3_);
            }

            byte b4 = 2;
            byte b1 = 0;
            byte b2 = 3;
            byte b3 = 1;

            switch (this.coordBaseMode)
            {
                case 0:
                    b4 = 0;
                    b1 = 2;
                    break;
                case 1:
                    b4 = 1;
                    b1 = 3;
                    b2 = 0;
                    b3 = 2;
                case 2:
                default:
                    break;
                case 3:
                    b4 = 3;
                    b1 = 1;
                    b2 = 0;
                    b3 = 2;
            }
            if (Configs.enableCrackedEndPortalFrame) {
                int chance = p_74875_2_.nextInt(15) + 1;
                if (chance < 5) {
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.end_portal_frame, b4 + (p_74875_2_.nextFloat() > 0.9F ? 4 : 0), 4, 3, 8, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, NovaCraftBlocks.cracked_end_portal_frame, b4 + (p_74875_2_.nextFloat() > 0.9F ? 4 : 0), 5, 3, 8, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, NovaCraftBlocks.cracked_end_portal_frame, b4 + (p_74875_2_.nextFloat() > 0.9F ? 4 : 0), 6, 3, 8, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, NovaCraftBlocks.cracked_end_portal_frame, b1 + (p_74875_2_.nextFloat() > 0.9F ? 4 : 0), 4, 3, 12, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.end_portal_frame, b1 + (p_74875_2_.nextFloat() > 0.9F ? 4 : 0), 5, 3, 12, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, NovaCraftBlocks.cracked_end_portal_frame, b1 + (p_74875_2_.nextFloat() > 0.9F ? 4 : 0), 6, 3, 12, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, NovaCraftBlocks.cracked_end_portal_frame, b2 + (p_74875_2_.nextFloat() > 0.9F ? 4 : 0), 3, 3, 9, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.end_portal_frame, b2 + (p_74875_2_.nextFloat() > 0.9F ? 4 : 0), 3, 3, 10, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, NovaCraftBlocks.cracked_end_portal_frame, b2 + (p_74875_2_.nextFloat() > 0.9F ? 4 : 0), 3, 3, 11, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, NovaCraftBlocks.cracked_end_portal_frame, b3 + (p_74875_2_.nextFloat() > 0.9F ? 4 : 0), 7, 3, 9, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, NovaCraftBlocks.cracked_end_portal_frame, b3 + (p_74875_2_.nextFloat() > 0.9F ? 4 : 0), 7, 3, 10, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.end_portal_frame, b3 + (p_74875_2_.nextFloat() > 0.9F ? 4 : 0), 7, 3, 11, p_74875_3_);
                } else if (chance < 10) {
                    this.placeBlockAtCurrentPosition(p_74875_1_, NovaCraftBlocks.cracked_end_portal_frame, b4 + (p_74875_2_.nextFloat() > 0.9F ? 4 : 0), 4, 3, 8, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, NovaCraftBlocks.cracked_end_portal_frame, b4 + (p_74875_2_.nextFloat() > 0.9F ? 4 : 0), 5, 3, 8, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, NovaCraftBlocks.cracked_end_portal_frame, b4 + (p_74875_2_.nextFloat() > 0.9F ? 4 : 0), 6, 3, 8, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.end_portal_frame, b1 + (p_74875_2_.nextFloat() > 0.9F ? 4 : 0), 4, 3, 12, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, NovaCraftBlocks.cracked_end_portal_frame, b1 + (p_74875_2_.nextFloat() > 0.9F ? 4 : 0), 5, 3, 12, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, NovaCraftBlocks.cracked_end_portal_frame, b1 + (p_74875_2_.nextFloat() > 0.9F ? 4 : 0), 6, 3, 12, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.end_portal_frame, b2 + (p_74875_2_.nextFloat() > 0.9F ? 4 : 0), 3, 3, 9, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, NovaCraftBlocks.cracked_end_portal_frame, b2 + (p_74875_2_.nextFloat() > 0.9F ? 4 : 0), 3, 3, 10, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, NovaCraftBlocks.cracked_end_portal_frame, b2 + (p_74875_2_.nextFloat() > 0.9F ? 4 : 0), 3, 3, 11, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.end_portal_frame, b3 + (p_74875_2_.nextFloat() > 0.9F ? 4 : 0), 7, 3, 9, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, NovaCraftBlocks.cracked_end_portal_frame, b3 + (p_74875_2_.nextFloat() > 0.9F ? 4 : 0), 7, 3, 10, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, NovaCraftBlocks.cracked_end_portal_frame, b3 + (p_74875_2_.nextFloat() > 0.9F ? 4 : 0), 7, 3, 11, p_74875_3_);
                } else {
                    this.placeBlockAtCurrentPosition(p_74875_1_, NovaCraftBlocks.cracked_end_portal_frame, b4 + (p_74875_2_.nextFloat() > 0.9F ? 4 : 0), 4, 3, 8, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.end_portal_frame, b4 + (p_74875_2_.nextFloat() > 0.9F ? 4 : 0), 5, 3, 8, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, NovaCraftBlocks.cracked_end_portal_frame, b4 + (p_74875_2_.nextFloat() > 0.9F ? 4 : 0), 6, 3, 8, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, NovaCraftBlocks.cracked_end_portal_frame, b1 + (p_74875_2_.nextFloat() > 0.9F ? 4 : 0), 4, 3, 12, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, NovaCraftBlocks.cracked_end_portal_frame, b1 + (p_74875_2_.nextFloat() > 0.9F ? 4 : 0), 5, 3, 12, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, NovaCraftBlocks.cracked_end_portal_frame, b1 + (p_74875_2_.nextFloat() > 0.9F ? 4 : 0), 6, 3, 12, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, NovaCraftBlocks.cracked_end_portal_frame, b2 + (p_74875_2_.nextFloat() > 0.9F ? 4 : 0), 3, 3, 9, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.end_portal_frame, b2 + (p_74875_2_.nextFloat() > 0.9F ? 4 : 0), 3, 3, 10, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, NovaCraftBlocks.cracked_end_portal_frame, b2 + (p_74875_2_.nextFloat() > 0.9F ? 4 : 0), 3, 3, 11, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, NovaCraftBlocks.cracked_end_portal_frame, b3 + (p_74875_2_.nextFloat() > 0.9F ? 4 : 0), 7, 3, 9, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.end_portal_frame, b3 + (p_74875_2_.nextFloat() > 0.9F ? 4 : 0), 7, 3, 10, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, NovaCraftBlocks.cracked_end_portal_frame, b3 + (p_74875_2_.nextFloat() > 0.9F ? 4 : 0), 7, 3, 11, p_74875_3_);
                }
            } else {
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.end_portal_frame, b4 + (p_74875_2_.nextFloat() > 0.9F ? 4 : 0), 4, 3, 8, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.end_portal_frame, b4 + (p_74875_2_.nextFloat() > 0.9F ? 4 : 0), 5, 3, 8, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.end_portal_frame, b4 + (p_74875_2_.nextFloat() > 0.9F ? 4 : 0), 6, 3, 8, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.end_portal_frame, b1 + (p_74875_2_.nextFloat() > 0.9F ? 4 : 0), 4, 3, 12, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.end_portal_frame, b1 + (p_74875_2_.nextFloat() > 0.9F ? 4 : 0), 5, 3, 12, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.end_portal_frame, b1 + (p_74875_2_.nextFloat() > 0.9F ? 4 : 0), 6, 3, 12, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.end_portal_frame, b2 + (p_74875_2_.nextFloat() > 0.9F ? 4 : 0), 3, 3, 9, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.end_portal_frame, b2 + (p_74875_2_.nextFloat() > 0.9F ? 4 : 0), 3, 3, 10, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.end_portal_frame, b2 + (p_74875_2_.nextFloat() > 0.9F ? 4 : 0), 3, 3, 11, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.end_portal_frame, b3 + (p_74875_2_.nextFloat() > 0.9F ? 4 : 0), 7, 3, 9, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.end_portal_frame, b3 + (p_74875_2_.nextFloat() > 0.9F ? 4 : 0), 7, 3, 10, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.end_portal_frame, b3 + (p_74875_2_.nextFloat() > 0.9F ? 4 : 0), 7, 3, 11, p_74875_3_);
            }

            if (!this.hasSpawner)
            {
                int i1 = this.getYWithOffset(3);
                int k = this.getXWithOffset(5, 6);
                int l = this.getZWithOffset(5, 6);

                if (p_74875_3_.isVecInside(k, i1, l))
                {
                    this.hasSpawner = true;
                    p_74875_1_.setBlock(k, i1, l, Blocks.mob_spawner, 0, 2);
                    TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner)p_74875_1_.getTileEntity(k, i1, l);

                    if (tileentitymobspawner != null)
                    {
                        tileentitymobspawner.func_145881_a().setEntityName("Silverfish");
                    }
                }
            }

            return true;
        }
    }

    public static class NCPrison extends NCStructureStrongholdPieces.Stronghold
    {

        public NCPrison() {}

        public NCPrison(int p_i2078_1_, Random p_i2078_2_, StructureBoundingBox p_i2078_3_, int p_i2078_4_)
        {
            super(p_i2078_1_);
            this.coordBaseMode = p_i2078_4_;
            this.field_143013_d = this.getRandomDoor(p_i2078_2_);
            this.boundingBox = p_i2078_3_;
        }

        public void buildComponent(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_)
        {
            this.getNextComponentNormal((NCStructureStrongholdPieces.NCStairs2)p_74861_1_, p_74861_2_, p_74861_3_, 1, 1);
        }

        public static NCStructureStrongholdPieces.NCPrison findValidPlacement(List p_75016_0_, Random p_75016_1_, int p_75016_2_, int p_75016_3_, int p_75016_4_, int p_75016_5_, int p_75016_6_)
        {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_75016_2_, p_75016_3_, p_75016_4_, -1, -1, 0, 9, 5, 11, p_75016_5_);

            return canStrongholdGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(p_75016_0_, structureboundingbox) == null ? new NCStructureStrongholdPieces.NCPrison(p_75016_6_, p_75016_1_, structureboundingbox, p_75016_5_) : null;
        }


        public boolean addComponentParts(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_)
        {
            if (this.isLiquidInStructureBoundingBox(p_74875_1_, p_74875_3_))
            {
                return false;
            }
            else
            {
                this.fillWithRandomizedBlocks(p_74875_1_, p_74875_3_, 0, 0, 0, 8, 4, 10, true, p_74875_2_, NCStructureStrongholdPieces.strongholdStones);
                this.placeDoor(p_74875_1_, p_74875_2_, p_74875_3_, this.field_143013_d, 1, 1, 0);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 1, 1, 10, 3, 3, 10, Blocks.air, Blocks.air, false);
                this.fillWithRandomizedBlocks(p_74875_1_, p_74875_3_, 4, 1, 1, 4, 3, 1, false, p_74875_2_, NCStructureStrongholdPieces.strongholdStones);
                this.fillWithRandomizedBlocks(p_74875_1_, p_74875_3_, 4, 1, 3, 4, 3, 3, false, p_74875_2_, NCStructureStrongholdPieces.strongholdStones);
                this.fillWithRandomizedBlocks(p_74875_1_, p_74875_3_, 4, 1, 7, 4, 3, 7, false, p_74875_2_, NCStructureStrongholdPieces.strongholdStones);
                this.fillWithRandomizedBlocks(p_74875_1_, p_74875_3_, 4, 1, 9, 4, 3, 9, false, p_74875_2_, NCStructureStrongholdPieces.strongholdStones);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 4, 1, 4, 4, 3, 6, Blocks.iron_bars, Blocks.iron_bars, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 5, 1, 5, 7, 3, 5, Blocks.iron_bars, Blocks.iron_bars, false);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.iron_bars, 0, 4, 3, 2, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.iron_bars, 0, 4, 3, 8, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.iron_door, this.getMetadataWithOffset(Blocks.iron_door, 3), 4, 1, 2, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.iron_door, this.getMetadataWithOffset(Blocks.iron_door, 3) + 8, 4, 2, 2, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.iron_door, this.getMetadataWithOffset(Blocks.iron_door, 3), 4, 1, 8, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.iron_door, this.getMetadataWithOffset(Blocks.iron_door, 3) + 8, 4, 2, 8, p_74875_3_);
                return true;
            }
        }
    }

    public static class NCRightTurn extends NCStructureStrongholdPieces.NCLeftTurn
    {

        public void buildComponent(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_)
        {
            if (this.coordBaseMode != 2 && this.coordBaseMode != 3)
            {
                this.getNextComponentX((NCStructureStrongholdPieces.NCStairs2)p_74861_1_, p_74861_2_, p_74861_3_, 1, 1);
            }
            else
            {
                this.getNextComponentZ((NCStructureStrongholdPieces.NCStairs2)p_74861_1_, p_74861_2_, p_74861_3_, 1, 1);
            }
        }


        public boolean addComponentParts(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_)
        {
            if (this.isLiquidInStructureBoundingBox(p_74875_1_, p_74875_3_))
            {
                return false;
            }
            else
            {
                this.fillWithRandomizedBlocks(p_74875_1_, p_74875_3_, 0, 0, 0, 4, 4, 4, true, p_74875_2_, NCStructureStrongholdPieces.strongholdStones);
                this.placeDoor(p_74875_1_, p_74875_2_, p_74875_3_, this.field_143013_d, 1, 1, 0);

                if (this.coordBaseMode != 2 && this.coordBaseMode != 3)
                {
                    this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 1, 1, 0, 3, 3, Blocks.air, Blocks.air, false);
                }
                else
                {
                    this.fillWithBlocks(p_74875_1_, p_74875_3_, 4, 1, 1, 4, 3, 3, Blocks.air, Blocks.air, false);
                }

                return true;
            }
        }
    }

    public static class NCRoomCrossing extends NCStructureStrongholdPieces.Stronghold {

        private boolean hasSpawner;

        public static final WeightedRandomChestContent[] strongholdNCRoomCrossingChestContents = new WeightedRandomChestContent[] {new WeightedRandomChestContent(Items.iron_ingot, 0, 1, 5, 10), new WeightedRandomChestContent(Items.gold_ingot, 0, 1, 3, 5), new WeightedRandomChestContent(Items.redstone, 0, 14, 22, 5), new WeightedRandomChestContent(NovaCraftItems.blazing_coal, 0, 3, 8, 10), new WeightedRandomChestContent(NovaCraftItems.vanite_ingot, 0, 1, 3, 15), new WeightedRandomChestContent(Items.apple, 0, 1, 3, 15), new WeightedRandomChestContent(Items.diamond_pickaxe, 0, 1, 1, 1)};
        protected int roomType;

        public NCRoomCrossing() {}

        public NCRoomCrossing(int p_i2079_1_, Random p_i2079_2_, StructureBoundingBox p_i2079_3_, int p_i2079_4_)
        {
            super(p_i2079_1_);
            this.coordBaseMode = p_i2079_4_;
            this.field_143013_d = this.getRandomDoor(p_i2079_2_);
            this.boundingBox = p_i2079_3_;
            this.roomType = p_i2079_2_.nextInt(5);
        }

        protected void func_143012_a(NBTTagCompound p_143012_1_)
        {
            super.func_143012_a(p_143012_1_);
            p_143012_1_.setInteger("Type", this.roomType);
            p_143012_1_.setBoolean("Mob", this.hasSpawner);
        }

        protected void func_143011_b(NBTTagCompound p_143011_1_)
        {
            super.func_143011_b(p_143011_1_);
            this.roomType = p_143011_1_.getInteger("Type");
            this.hasSpawner = p_143011_1_.getBoolean("Mob");
        }


        public void buildComponent(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_)
        {
            this.getNextComponentNormal((NCStructureStrongholdPieces.NCStairs2)p_74861_1_, p_74861_2_, p_74861_3_, 4, 1);
            this.getNextComponentX((NCStructureStrongholdPieces.NCStairs2)p_74861_1_, p_74861_2_, p_74861_3_, 1, 4);
            this.getNextComponentZ((NCStructureStrongholdPieces.NCStairs2)p_74861_1_, p_74861_2_, p_74861_3_, 1, 4);
        }

        public static NCStructureStrongholdPieces.NCRoomCrossing findValidPlacement(List p_75012_0_, Random p_75012_1_, int p_75012_2_, int p_75012_3_, int p_75012_4_, int p_75012_5_, int p_75012_6_)
        {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_75012_2_, p_75012_3_, p_75012_4_, -4, -1, 0, 11, 7, 11, p_75012_5_);

            return canStrongholdGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(p_75012_0_, structureboundingbox) == null ? new NCStructureStrongholdPieces.NCRoomCrossing(p_75012_6_, p_75012_1_, structureboundingbox, p_75012_5_) : null;
        }


        public boolean addComponentParts(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {

            if (this.isLiquidInStructureBoundingBox(p_74875_1_, p_74875_3_))
            {
                return false;
            }
            else
            {
                this.fillWithRandomizedBlocks(p_74875_1_, p_74875_3_, 0, 0, 0, 10, 6, 10, true, p_74875_2_, NCStructureStrongholdPieces.strongholdStones);
                this.placeDoor(p_74875_1_, p_74875_2_, p_74875_3_, this.field_143013_d, 4, 1, 0);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 4, 1, 10, 6, 3, 10, Blocks.air, Blocks.air, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 1, 4, 0, 3, 6, Blocks.air, Blocks.air, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 10, 1, 4, 10, 3, 6, Blocks.air, Blocks.air, false);
                int i;

                switch (this.roomType)
                {
                    case 0:
                        this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.stonebrick, 0, 5, 1, 5, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.stonebrick, 0, 5, 2, 5, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.stonebrick, 0, 5, 3, 5, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.stone_slab, 0, 4, 1, 4, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.stone_slab, 0, 4, 1, 5, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.stone_slab, 0, 4, 1, 6, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.stone_slab, 0, 6, 1, 4, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.stone_slab, 0, 6, 1, 5, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.stone_slab, 0, 6, 1, 6, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.stone_slab, 0, 5, 1, 4, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.stone_slab, 0, 5, 1, 6, p_74875_3_);
                        break;
                    case 1:
                        for (i = 0; i < 5; ++i)
                        {
                            this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.stonebrick, 0, 3, 1, 3 + i, p_74875_3_);
                            this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.stonebrick, 0, 7, 1, 3 + i, p_74875_3_);
                            this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.stonebrick, 0, 3 + i, 1, 3, p_74875_3_);
                            this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.stonebrick, 0, 3 + i, 1, 7, p_74875_3_);
                        }

                        this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.stonebrick, 0, 5, 1, 5, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.stonebrick, 0, 5, 2, 5, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.stonebrick, 0, 5, 3, 5, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.flowing_water, 0, 5, 4, 5, p_74875_3_);
                        break;
                    case 2:
                        for (i = 1; i <= 9; ++i)
                        {
                            this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.cobblestone, 0, 1, 3, i, p_74875_3_);
                            this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.cobblestone, 0, 9, 3, i, p_74875_3_);
                        }

                        for (i = 1; i <= 9; ++i)
                        {
                            this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.cobblestone, 0, i, 3, 1, p_74875_3_);
                            this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.cobblestone, 0, i, 3, 9, p_74875_3_);
                        }

                        this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.cobblestone, 0, 5, 1, 4, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.cobblestone, 0, 5, 1, 6, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.cobblestone, 0, 5, 3, 4, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.cobblestone, 0, 5, 3, 6, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.cobblestone, 0, 4, 1, 5, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.cobblestone, 0, 6, 1, 5, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.cobblestone, 0, 4, 3, 5, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.cobblestone, 0, 6, 3, 5, p_74875_3_);

                        for (i = 1; i <= 3; ++i)
                        {
                            this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.cobblestone, 0, 4, i, 4, p_74875_3_);
                            this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.cobblestone, 0, 6, i, 4, p_74875_3_);
                            this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.cobblestone, 0, 4, i, 6, p_74875_3_);
                            this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.cobblestone, 0, 6, i, 6, p_74875_3_);
                        }

                        for (i = 2; i <= 8; ++i)
                        {
                            this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.planks, 0, 2, 3, i, p_74875_3_);
                            this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.planks, 0, 3, 3, i, p_74875_3_);

                            if (i <= 3 || i >= 7)
                            {
                                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.planks, 0, 4, 3, i, p_74875_3_);
                                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.planks, 0, 5, 3, i, p_74875_3_);
                                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.planks, 0, 6, 3, i, p_74875_3_);
                            }

                            this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.planks, 0, 7, 3, i, p_74875_3_);
                            this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.planks, 0, 8, 3, i, p_74875_3_);
                        }

                        this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.ladder, this.getMetadataWithOffset(Blocks.ladder, 4), 9, 1, 3, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.ladder, this.getMetadataWithOffset(Blocks.ladder, 4), 9, 2, 3, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.ladder, this.getMetadataWithOffset(Blocks.ladder, 4), 9, 3, 3, p_74875_3_);
                        this.generateStructureChestContents(p_74875_1_, p_74875_3_, p_74875_2_, 3, 4, 8, ChestGenHooks.getItems(STRONGHOLD_CROSSING, p_74875_2_), ChestGenHooks.getCount(STRONGHOLD_CROSSING, p_74875_2_));
                        this.generateStructureChestContents(p_74875_1_, p_74875_3_, p_74875_2_, 4, 4, 8, ChestGenHooks.getItems(NC_TREASURE, p_74875_2_), ChestGenHooks.getCount(NC_TREASURE, p_74875_2_));

                }
                int spawner_chance = p_74875_2_.nextInt(5);
                if (!this.hasSpawner && (Configs.enableMaxStrongholdSpawners || spawner_chance == 0))
                {
                    int i1 = this.getYWithOffset(2);
                    int k = this.getXWithOffset(5, 3);
                    int l = this.getZWithOffset(5, 3);

                    if (p_74875_3_.isVecInside(k, i1, l)) {
                        this.hasSpawner = true;
                        this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.stonebrick, 0, 5, 1, 3, p_74875_3_);
                        p_74875_1_.setBlock(k, i1, l, Blocks.mob_spawner, 0, 2);
                        TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner) p_74875_1_.getTileEntity(k, i1, l);

                        if (tileentitymobspawner != null && p_74875_2_.nextBoolean()) {
                            tileentitymobspawner.func_145881_a().setEntityName("Zombie");

                            //Get the NBT data from the spawner
                            NBTTagCompound spawnerNBT = new NBTTagCompound();
                            tileentitymobspawner.writeToNBT(spawnerNBT);

                            //Modify SpawnData to customize the spawned zombie
                            NBTTagCompound spawnData = new NBTTagCompound();
                            spawnData.setString("id", "Zombie");

                            //Give the mob a Resistance effect
                            NBTTagList effects = new NBTTagList();

                            NBTTagCompound resistanceEffect = new NBTTagCompound();
                            resistanceEffect.setByte("Id", (byte) 11); //Resistance effect ID
                            resistanceEffect.setByte("Amplifier", (byte) 2); //Level 2 Resistance
                            resistanceEffect.setInteger("Duration", Integer.MAX_VALUE); //Infinite duration
                            resistanceEffect.setByte("Ambient", (byte) 1);
                            resistanceEffect.setByte("ShowParticles", (byte) 0); //Invisible effect???

                            effects.appendTag(resistanceEffect);
                            spawnData.setTag("ActiveEffects", effects);

                            //Gives weapon
                            NBTTagList equipment = new NBTTagList();

                            NBTTagCompound weapon = new NBTTagCompound();
                            ItemStack sword = new ItemStack(Items.iron_sword);
                            sword.writeToNBT(weapon);
                            equipment.appendTag(weapon);

                            //Fill remaining slots with empty tags to prevent overwriting other equipment
                            for (int a = 1; a < 5; a++) {
                                equipment.appendTag(new NBTTagCompound());
                            }
                            spawnData.setTag("Equipment", equipment);

                            //Prevent the weapon from being removed or replaced
                            NBTTagList dropChances = new NBTTagList();
                            dropChances.appendTag(new NBTTagFloat(0.0F)); //Weapon (never drops)
                            for (int a = 1; a < 5; a++) {
                                dropChances.appendTag(new NBTTagFloat(0.085F)); //Default drop chance for empty slots
                            }
                            spawnData.setTag("DropChances", dropChances);

                            //Apply SpawnData to spawner
                            spawnerNBT.setTag("SpawnData", spawnData);

                            //Write the modified NBT data back to the spawner
                            tileentitymobspawner.readFromNBT(spawnerNBT);
                        } else {
                            tileentitymobspawner.func_145881_a().setEntityName("Skeleton");

                            NBTTagCompound spawnerNBT = new NBTTagCompound();
                            tileentitymobspawner.writeToNBT(spawnerNBT);

                            NBTTagCompound spawnData = new NBTTagCompound();
                            spawnData.setString("id", "Skeleton");

                            NBTTagList effects = new NBTTagList();

                            NBTTagCompound resistanceEffect = new NBTTagCompound();
                            resistanceEffect.setByte("Id", (byte) 11);
                            resistanceEffect.setByte("Amplifier", (byte) 2);
                            resistanceEffect.setInteger("Duration", Integer.MAX_VALUE);
                            resistanceEffect.setByte("Ambient", (byte) 1);
                            resistanceEffect.setByte("ShowParticles", (byte) 0);

                            effects.appendTag(resistanceEffect);
                            spawnData.setTag("ActiveEffects", effects);

                            NBTTagList equipment = new NBTTagList();

                            NBTTagCompound weapon = new NBTTagCompound();
                            ItemStack sword = new ItemStack(Items.bow);
                            sword.writeToNBT(weapon);
                            equipment.appendTag(weapon);

                            for (int a = 1; a < 5; a++) {
                                equipment.appendTag(new NBTTagCompound());
                            }
                            spawnData.setTag("Equipment", equipment);

                            NBTTagList dropChances = new NBTTagList();
                            dropChances.appendTag(new NBTTagFloat(0.0F));
                            for (int a = 1; a < 5; a++) {
                                dropChances.appendTag(new NBTTagFloat(0.085F));
                            }
                            spawnData.setTag("DropChances", dropChances);

                            spawnerNBT.setTag("SpawnData", spawnData);

                            tileentitymobspawner.readFromNBT(spawnerNBT);
                        }
                    }
                }

                return true;
            }
        }
    }

    public static class NCStairs extends NCStructureStrongholdPieces.Stronghold {
        private boolean field_75024_a;

        public NCStairs() {}

        public NCStairs(int p_i2081_1_, Random p_i2081_2_, int p_i2081_3_, int p_i2081_4_)
        {
            super(p_i2081_1_);
            this.field_75024_a = true;
            this.coordBaseMode = p_i2081_2_.nextInt(4);
            this.field_143013_d = NCStructureStrongholdPieces.Stronghold.Door.OPENING;

            switch (this.coordBaseMode)
            {
                case 0:
                case 2:
                    this.boundingBox = new StructureBoundingBox(p_i2081_3_, 34, p_i2081_4_, p_i2081_3_ + 5 - 1, 44, p_i2081_4_ + 5 - 1);
                    break;
                default:
                    this.boundingBox = new StructureBoundingBox(p_i2081_3_, 34, p_i2081_4_, p_i2081_3_ + 5 - 1, 44, p_i2081_4_ + 5 - 1);
            }
        }

        public NCStairs(int p_i2082_1_, Random p_i2082_2_, StructureBoundingBox p_i2082_3_, int p_i2082_4_)
        {
            super(p_i2082_1_);
            this.field_75024_a = false;
            this.coordBaseMode = p_i2082_4_;
            this.field_143013_d = this.getRandomDoor(p_i2082_2_);
            this.boundingBox = p_i2082_3_;
        }

        protected void func_143012_a(NBTTagCompound p_143012_1_)
        {
            super.func_143012_a(p_143012_1_);
            p_143012_1_.setBoolean("Source", this.field_75024_a);
        }

        protected void func_143011_b(NBTTagCompound p_143011_1_)
        {
            super.func_143011_b(p_143011_1_);
            this.field_75024_a = p_143011_1_.getBoolean("Source");
        }


        public void buildComponent(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_)
        {
            if (this.field_75024_a)
            {
                NCStructureStrongholdPieces.strongComponentType = NCStructureStrongholdPieces.NCCrossing.class;
            }

            this.getNextComponentNormal((NCStructureStrongholdPieces.NCStairs2)p_74861_1_, p_74861_2_, p_74861_3_, 1, 1);
        }


        public static NCStructureStrongholdPieces.NCStairs getStrongholdStairsComponent(List p_75022_0_, Random p_75022_1_, int p_75022_2_, int p_75022_3_, int p_75022_4_, int p_75022_5_, int p_75022_6_)
        {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_75022_2_, p_75022_3_, p_75022_4_, -1, -7, 0, 5, 11, 5, p_75022_5_);

            return canStrongholdGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(p_75022_0_, structureboundingbox) == null ? new NCStructureStrongholdPieces.NCStairs(p_75022_6_, p_75022_1_, structureboundingbox, p_75022_5_) : null;
        }

        public boolean addComponentParts(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_)
        {
            if (this.isLiquidInStructureBoundingBox(p_74875_1_, p_74875_3_))
            {
                return false;
            }
            else
            {
                this.fillWithRandomizedBlocks(p_74875_1_, p_74875_3_, 0, 0, 0, 4, 10, 4, true, p_74875_2_, NCStructureStrongholdPieces.strongholdStones);
                this.placeDoor(p_74875_1_, p_74875_2_, p_74875_3_, this.field_143013_d, 1, 7, 0);
                this.placeDoor(p_74875_1_, p_74875_2_, p_74875_3_, NCStructureStrongholdPieces.Stronghold.Door.OPENING, 1, 1, 4);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.stonebrick, 0, 2, 6, 1, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.stonebrick, 0, 1, 5, 1, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.stone_slab, 0, 1, 6, 1, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.stonebrick, 0, 1, 5, 2, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.stonebrick, 0, 1, 4, 3, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.stone_slab, 0, 1, 5, 3, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.stonebrick, 0, 2, 4, 3, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.stonebrick, 0, 3, 3, 3, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.stone_slab, 0, 3, 4, 3, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.stonebrick, 0, 3, 3, 2, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.stonebrick, 0, 3, 2, 1, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.stone_slab, 0, 3, 3, 1, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.stonebrick, 0, 2, 2, 1, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.stonebrick, 0, 1, 1, 1, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.stone_slab, 0, 1, 2, 1, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.stonebrick, 0, 1, 1, 2, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.stone_slab, 0, 1, 1, 3, p_74875_3_);
                return true;
            }
        }
    }

    public static class NCStairs2 extends NCStructureStrongholdPieces.NCStairs
    {
        public NCStructureStrongholdPieces.PieceWeight strongholdPieceWeight;
        public NCStructureStrongholdPieces.NCPortalRoom strongholdNCPortalRoom;
        public List field_75026_c = new ArrayList();

        public NCStairs2() {}

        public NCStairs2(int p_i2083_1_, Random p_i2083_2_, int p_i2083_3_, int p_i2083_4_)
        {
            super(0, p_i2083_2_, p_i2083_3_, p_i2083_4_);
        }

        public ChunkPosition func_151553_a()
        {
            return this.strongholdNCPortalRoom != null ? this.strongholdNCPortalRoom.func_151553_a() : super.func_151553_a();
        }
    }

    public static class NCStairsStraight extends NCStructureStrongholdPieces.Stronghold
    {

        public NCStairsStraight() {}

        public NCStairsStraight(int p_i2085_1_, Random p_i2085_2_, StructureBoundingBox p_i2085_3_, int p_i2085_4_)
        {
            super(p_i2085_1_);
            this.coordBaseMode = p_i2085_4_;
            this.field_143013_d = this.getRandomDoor(p_i2085_2_);
            this.boundingBox = p_i2085_3_;
        }

        public void buildComponent(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_)
        {
            this.getNextComponentNormal((NCStructureStrongholdPieces.NCStairs2)p_74861_1_, p_74861_2_, p_74861_3_, 1, 1);
        }

        public static NCStructureStrongholdPieces.NCStairsStraight findValidPlacement(List p_75028_0_, Random p_75028_1_, int p_75028_2_, int p_75028_3_, int p_75028_4_, int p_75028_5_, int p_75028_6_)
        {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_75028_2_, p_75028_3_, p_75028_4_, -1, -7, 0, 5, 11, 8, p_75028_5_);

            return canStrongholdGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(p_75028_0_, structureboundingbox) == null ? new NCStructureStrongholdPieces.NCStairsStraight(p_75028_6_, p_75028_1_, structureboundingbox, p_75028_5_) : null;
        }

        public boolean addComponentParts(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_)
        {
            if (this.isLiquidInStructureBoundingBox(p_74875_1_, p_74875_3_))
            {
                return false;
            }
            else
            {
                this.fillWithRandomizedBlocks(p_74875_1_, p_74875_3_, 0, 0, 0, 4, 10, 7, true, p_74875_2_, NCStructureStrongholdPieces.strongholdStones);
                this.placeDoor(p_74875_1_, p_74875_2_, p_74875_3_, this.field_143013_d, 1, 7, 0);
                this.placeDoor(p_74875_1_, p_74875_2_, p_74875_3_, NCStructureStrongholdPieces.Stronghold.Door.OPENING, 1, 1, 7);
                int i = this.getMetadataWithOffset(Blocks.stone_stairs, 2);

                for (int j = 0; j < 6; ++j)
                {
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.stone_stairs, i, 1, 6 - j, 1 + j, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.stone_stairs, i, 2, 6 - j, 1 + j, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.stone_stairs, i, 3, 6 - j, 1 + j, p_74875_3_);

                    if (j < 5)
                    {
                        this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.stonebrick, 0, 1, 5 - j, 1 + j, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.stonebrick, 0, 2, 5 - j, 1 + j, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.stonebrick, 0, 3, 5 - j, 1 + j, p_74875_3_);
                    }
                }

                return true;
            }
        }
    }

    static class Stones extends StructureComponent.BlockSelector
    {

        private Stones() {}

        public void selectBlocks(Random p_75062_1_, int p_75062_2_, int p_75062_3_, int p_75062_4_, boolean p_75062_5_)
        {
            if (p_75062_5_)
            {
                this.field_151562_a = Blocks.stonebrick;
                float f = p_75062_1_.nextFloat();

                if (f < 0.2F)
                {
                    this.selectedBlockMetaData = 2;
                }
                else if (f < 0.5F)
                {
                    this.selectedBlockMetaData = 1;
                }
                else if (f < 0.55F)
                {
                    this.field_151562_a = Blocks.monster_egg;
                    this.selectedBlockMetaData = 2;
                }
                else
                {
                    this.selectedBlockMetaData = 0;
                }
            }
            else
            {
                this.field_151562_a = Blocks.air;
                this.selectedBlockMetaData = 0;
            }
        }

        Stones(Object p_i2080_1_)
        {
            this();
        }
    }

    public static class NCStraight extends NCStructureStrongholdPieces.Stronghold
    {
        private boolean expandsX;
        private boolean expandsZ;

        public NCStraight() {}

        public NCStraight(int p_i2084_1_, Random p_i2084_2_, StructureBoundingBox p_i2084_3_, int p_i2084_4_)
        {
            super(p_i2084_1_);
            this.coordBaseMode = p_i2084_4_;
            this.field_143013_d = this.getRandomDoor(p_i2084_2_);
            this.boundingBox = p_i2084_3_;
            this.expandsX = p_i2084_2_.nextInt(2) == 0;
            this.expandsZ = p_i2084_2_.nextInt(2) == 0;
        }

        protected void func_143012_a(NBTTagCompound p_143012_1_)
        {
            super.func_143012_a(p_143012_1_);
            p_143012_1_.setBoolean("Left", this.expandsX);
            p_143012_1_.setBoolean("Right", this.expandsZ);
        }

        protected void func_143011_b(NBTTagCompound p_143011_1_)
        {
            super.func_143011_b(p_143011_1_);
            this.expandsX = p_143011_1_.getBoolean("Left");
            this.expandsZ = p_143011_1_.getBoolean("Right");
        }


        public void buildComponent(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_)
        {
            this.getNextComponentNormal((NCStructureStrongholdPieces.NCStairs2)p_74861_1_, p_74861_2_, p_74861_3_, 1, 1);

            if (this.expandsX)
            {
                this.getNextComponentX((NCStructureStrongholdPieces.NCStairs2)p_74861_1_, p_74861_2_, p_74861_3_, 1, 2);
            }

            if (this.expandsZ)
            {
                this.getNextComponentZ((NCStructureStrongholdPieces.NCStairs2)p_74861_1_, p_74861_2_, p_74861_3_, 1, 2);
            }
        }

        public static NCStructureStrongholdPieces.NCStraight findValidPlacement(List p_75018_0_, Random p_75018_1_, int p_75018_2_, int p_75018_3_, int p_75018_4_, int p_75018_5_, int p_75018_6_)
        {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_75018_2_, p_75018_3_, p_75018_4_, -1, -1, 0, 5, 5, 7, p_75018_5_);

            return canStrongholdGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(p_75018_0_, structureboundingbox) == null ? new NCStructureStrongholdPieces.NCStraight(p_75018_6_, p_75018_1_, structureboundingbox, p_75018_5_) : null;
        }


        public boolean addComponentParts(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_)
        {
            if (this.isLiquidInStructureBoundingBox(p_74875_1_, p_74875_3_))
            {
                return false;
            }
            else
            {
                this.fillWithRandomizedBlocks(p_74875_1_, p_74875_3_, 0, 0, 0, 4, 4, 6, true, p_74875_2_, NCStructureStrongholdPieces.strongholdStones);
                this.placeDoor(p_74875_1_, p_74875_2_, p_74875_3_, this.field_143013_d, 1, 1, 0);
                this.placeDoor(p_74875_1_, p_74875_2_, p_74875_3_, NCStructureStrongholdPieces.Stronghold.Door.OPENING, 1, 1, 6);

                if (this.expandsX)
                {
                    this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 1, 2, 0, 3, 4, Blocks.air, Blocks.air, false);


                }

                if (this.expandsZ)
                {
                    this.fillWithBlocks(p_74875_1_, p_74875_3_, 4, 1, 2, 4, 3, 4, Blocks.air, Blocks.air, false);
                }

                return true;
            }
        }
    }

    public static class NCStraightAlternate extends NCStructureStrongholdPieces.Stronghold
    {
        private boolean expandsX;
        private boolean expandsZ;
        private boolean hasSpawner;

        public NCStraightAlternate() {}

        public NCStraightAlternate(int p_i2084_1_, Random p_i2084_2_, StructureBoundingBox p_i2084_3_, int p_i2084_4_)
        {
            super(p_i2084_1_);
            this.coordBaseMode = p_i2084_4_;
            this.field_143013_d = this.getRandomDoor(p_i2084_2_);
            this.boundingBox = p_i2084_3_;
            this.expandsX = p_i2084_2_.nextInt(2) == 0;
            this.expandsZ = p_i2084_2_.nextInt(2) == 0;
        }

        protected void func_143012_a(NBTTagCompound p_143012_1_)
        {
            super.func_143012_a(p_143012_1_);
            p_143012_1_.setBoolean("Left", this.expandsX);
            p_143012_1_.setBoolean("Right", this.expandsZ);
            p_143012_1_.setBoolean("Mob", this.hasSpawner);
        }

        protected void func_143011_b(NBTTagCompound p_143011_1_)
        {
            super.func_143011_b(p_143011_1_);
            this.expandsX = p_143011_1_.getBoolean("Left");
            this.expandsZ = p_143011_1_.getBoolean("Right");
            this.hasSpawner = p_143011_1_.getBoolean("Mob");
        }


        public void buildComponent(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_)
        {
            this.getNextComponentNormal((NCStructureStrongholdPieces.NCStairs2)p_74861_1_, p_74861_2_, p_74861_3_, 1, 1);

            if (this.expandsX)
            {
                this.getNextComponentX((NCStructureStrongholdPieces.NCStairs2)p_74861_1_, p_74861_2_, p_74861_3_, 1, 2);
            }

            if (this.expandsZ)
            {
                this.getNextComponentZ((NCStructureStrongholdPieces.NCStairs2)p_74861_1_, p_74861_2_, p_74861_3_, 1, 2);
            }
        }

        public static NCStructureStrongholdPieces.NCStraightAlternate findValidPlacement(List p_75018_0_, Random p_75018_1_, int p_75018_2_, int p_75018_3_, int p_75018_4_, int p_75018_5_, int p_75018_6_)
        {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_75018_2_, p_75018_3_, p_75018_4_, -1, -1, 0, 5, 5, 7, p_75018_5_);

            return canStrongholdGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(p_75018_0_, structureboundingbox) == null ? new NCStructureStrongholdPieces.NCStraightAlternate(p_75018_6_, p_75018_1_, structureboundingbox, p_75018_5_) : null;
        }


        public boolean addComponentParts(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_)
        {
            if (this.isLiquidInStructureBoundingBox(p_74875_1_, p_74875_3_))
            {
                return false;
            }
            else
            {
                this.fillWithRandomizedBlocks(p_74875_1_, p_74875_3_, 0, 0, 0, 4, 4, 6, true, p_74875_2_, NCStructureStrongholdPieces.strongholdStones);
                this.placeDoor(p_74875_1_, p_74875_2_, p_74875_3_, this.field_143013_d, 1, 1, 0);
                this.placeDoor(p_74875_1_, p_74875_2_, p_74875_3_, NCStructureStrongholdPieces.Stronghold.Door.OPENING, 1, 1, 6);

                if (this.expandsX)
                {
                    this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 1, 2, 0, 3, 4, Blocks.air, Blocks.air, false);

                    int spawner_chance = p_74875_2_.nextInt(3);
                    if (!this.hasSpawner && (Configs.enableMaxStrongholdSpawners || spawner_chance == 0)) {
                        int i1 = this.getYWithOffset(1);
                        int k = this.getXWithOffset(0, 2);
                        int l = this.getZWithOffset(0, 2);

                        if (p_74875_3_.isVecInside(k, i1, l)) {
                            this.hasSpawner = true;
                            p_74875_1_.setBlock(k, i1, l, Blocks.mob_spawner, 0, 2);
                            TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner) p_74875_1_.getTileEntity(k, i1, l);

                            if (tileentitymobspawner != null) {
                                if(p_74875_2_.nextInt(8) >= 6) {
                                    tileentitymobspawner.func_145881_a().setEntityName("Silverfish");
                                }
                                else {
                                    tileentitymobspawner.func_145881_a().setEntityName("nova_craft.relik");
                                }
                            }
                        }
                    }
                }

                if (this.expandsZ)
                {
                    this.fillWithBlocks(p_74875_1_, p_74875_3_, 4, 1, 2, 4, 3, 4, Blocks.air, Blocks.air, false);

                    int spawner_chance = p_74875_2_.nextInt(2);
                    if (!this.hasSpawner && (Configs.enableMaxStrongholdSpawners || spawner_chance == 0)) {
                        int i1 = this.getYWithOffset(1);
                        int k = this.getXWithOffset(4, 2);
                        int l = this.getZWithOffset(4, 2);

                        if (p_74875_3_.isVecInside(k, i1, l)) {
                            this.hasSpawner = true;
                            p_74875_1_.setBlock(k, i1, l, Blocks.mob_spawner, 0, 2);
                            TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner) p_74875_1_.getTileEntity(k, i1, l);

                            if (tileentitymobspawner != null) {
                                if(p_74875_2_.nextInt(8) >= 6) {
                                    tileentitymobspawner.func_145881_a().setEntityName("Silverfish");
                                }
                                else {
                                    tileentitymobspawner.func_145881_a().setEntityName("nova_craft.relik");
                                }
                            }
                        }
                    }
                }

                return true;
            }
        }
    }

    public abstract static class Stronghold extends StructureComponent
    {
        protected NCStructureStrongholdPieces.Stronghold.Door field_143013_d;

        public Stronghold()
        {
            this.field_143013_d = NCStructureStrongholdPieces.Stronghold.Door.OPENING;
        }

        protected Stronghold(int p_i2087_1_)
        {
            super(p_i2087_1_);
            this.field_143013_d = NCStructureStrongholdPieces.Stronghold.Door.OPENING;
        }

        protected void func_143012_a(NBTTagCompound p_143012_1_)
        {
            p_143012_1_.setString("EntryDoor", this.field_143013_d.name());
        }

        protected void func_143011_b(NBTTagCompound p_143011_1_)
        {
            this.field_143013_d = NCStructureStrongholdPieces.Stronghold.Door.valueOf(p_143011_1_.getString("EntryDoor"));
        }


        protected void placeDoor(World p_74990_1_, Random p_74990_2_, StructureBoundingBox p_74990_3_, NCStructureStrongholdPieces.Stronghold.Door p_74990_4_, int p_74990_5_, int p_74990_6_, int p_74990_7_)
        {
            switch (NCStructureStrongholdPieces.SwitchDoor.doorEnum[p_74990_4_.ordinal()])
            {
                case 1:
                default:
                    this.fillWithBlocks(p_74990_1_, p_74990_3_, p_74990_5_, p_74990_6_, p_74990_7_, p_74990_5_ + 3 - 1, p_74990_6_ + 3 - 1, p_74990_7_, Blocks.air, Blocks.air, false);
                    break;
                case 2:
                    this.placeBlockAtCurrentPosition(p_74990_1_, Blocks.stonebrick, 0, p_74990_5_, p_74990_6_, p_74990_7_, p_74990_3_);
                    this.placeBlockAtCurrentPosition(p_74990_1_, Blocks.stonebrick, 0, p_74990_5_, p_74990_6_ + 1, p_74990_7_, p_74990_3_);
                    this.placeBlockAtCurrentPosition(p_74990_1_, Blocks.stonebrick, 0, p_74990_5_, p_74990_6_ + 2, p_74990_7_, p_74990_3_);
                    this.placeBlockAtCurrentPosition(p_74990_1_, Blocks.stonebrick, 0, p_74990_5_ + 1, p_74990_6_ + 2, p_74990_7_, p_74990_3_);
                    this.placeBlockAtCurrentPosition(p_74990_1_, Blocks.stonebrick, 0, p_74990_5_ + 2, p_74990_6_ + 2, p_74990_7_, p_74990_3_);
                    this.placeBlockAtCurrentPosition(p_74990_1_, Blocks.stonebrick, 0, p_74990_5_ + 2, p_74990_6_ + 1, p_74990_7_, p_74990_3_);
                    this.placeBlockAtCurrentPosition(p_74990_1_, Blocks.stonebrick, 0, p_74990_5_ + 2, p_74990_6_, p_74990_7_, p_74990_3_);
                    this.placeBlockAtCurrentPosition(p_74990_1_, Blocks.wooden_door, 0, p_74990_5_ + 1, p_74990_6_, p_74990_7_, p_74990_3_);
                    this.placeBlockAtCurrentPosition(p_74990_1_, Blocks.wooden_door, 8, p_74990_5_ + 1, p_74990_6_ + 1, p_74990_7_, p_74990_3_);
                    break;
                case 3:
                    this.placeBlockAtCurrentPosition(p_74990_1_, Blocks.air, 0, p_74990_5_ + 1, p_74990_6_, p_74990_7_, p_74990_3_);
                    this.placeBlockAtCurrentPosition(p_74990_1_, Blocks.air, 0, p_74990_5_ + 1, p_74990_6_ + 1, p_74990_7_, p_74990_3_);
                    this.placeBlockAtCurrentPosition(p_74990_1_, Blocks.iron_bars, 0, p_74990_5_, p_74990_6_, p_74990_7_, p_74990_3_);
                    this.placeBlockAtCurrentPosition(p_74990_1_, Blocks.iron_bars, 0, p_74990_5_, p_74990_6_ + 1, p_74990_7_, p_74990_3_);
                    this.placeBlockAtCurrentPosition(p_74990_1_, Blocks.iron_bars, 0, p_74990_5_, p_74990_6_ + 2, p_74990_7_, p_74990_3_);
                    this.placeBlockAtCurrentPosition(p_74990_1_, Blocks.iron_bars, 0, p_74990_5_ + 1, p_74990_6_ + 2, p_74990_7_, p_74990_3_);
                    this.placeBlockAtCurrentPosition(p_74990_1_, Blocks.iron_bars, 0, p_74990_5_ + 2, p_74990_6_ + 2, p_74990_7_, p_74990_3_);
                    this.placeBlockAtCurrentPosition(p_74990_1_, Blocks.iron_bars, 0, p_74990_5_ + 2, p_74990_6_ + 1, p_74990_7_, p_74990_3_);
                    this.placeBlockAtCurrentPosition(p_74990_1_, Blocks.iron_bars, 0, p_74990_5_ + 2, p_74990_6_, p_74990_7_, p_74990_3_);
                    break;
                case 4:
                    this.placeBlockAtCurrentPosition(p_74990_1_, Blocks.stonebrick, 0, p_74990_5_, p_74990_6_, p_74990_7_, p_74990_3_);
                    this.placeBlockAtCurrentPosition(p_74990_1_, Blocks.stonebrick, 0, p_74990_5_, p_74990_6_ + 1, p_74990_7_, p_74990_3_);
                    this.placeBlockAtCurrentPosition(p_74990_1_, Blocks.stonebrick, 0, p_74990_5_, p_74990_6_ + 2, p_74990_7_, p_74990_3_);
                    this.placeBlockAtCurrentPosition(p_74990_1_, Blocks.stonebrick, 0, p_74990_5_ + 1, p_74990_6_ + 2, p_74990_7_, p_74990_3_);
                    this.placeBlockAtCurrentPosition(p_74990_1_, Blocks.stonebrick, 0, p_74990_5_ + 2, p_74990_6_ + 2, p_74990_7_, p_74990_3_);
                    this.placeBlockAtCurrentPosition(p_74990_1_, Blocks.stonebrick, 0, p_74990_5_ + 2, p_74990_6_ + 1, p_74990_7_, p_74990_3_);
                    this.placeBlockAtCurrentPosition(p_74990_1_, Blocks.stonebrick, 0, p_74990_5_ + 2, p_74990_6_, p_74990_7_, p_74990_3_);
                    this.placeBlockAtCurrentPosition(p_74990_1_, Blocks.iron_door, 0, p_74990_5_ + 1, p_74990_6_, p_74990_7_, p_74990_3_);
                    this.placeBlockAtCurrentPosition(p_74990_1_, Blocks.iron_door, 8, p_74990_5_ + 1, p_74990_6_ + 1, p_74990_7_, p_74990_3_);
                    this.placeBlockAtCurrentPosition(p_74990_1_, Blocks.stone_button, this.getMetadataWithOffset(Blocks.stone_button, 4), p_74990_5_ + 2, p_74990_6_ + 1, p_74990_7_ + 1, p_74990_3_);
                    this.placeBlockAtCurrentPosition(p_74990_1_, Blocks.stone_button, this.getMetadataWithOffset(Blocks.stone_button, 3), p_74990_5_ + 2, p_74990_6_ + 1, p_74990_7_ - 1, p_74990_3_);
            }
        }

        protected NCStructureStrongholdPieces.Stronghold.Door getRandomDoor(Random p_74988_1_)
        {
            int i = p_74988_1_.nextInt(5);

            switch (i)
            {
                case 0:
                case 1:
                default:
                    return NCStructureStrongholdPieces.Stronghold.Door.OPENING;
                case 2:
                    return NCStructureStrongholdPieces.Stronghold.Door.WOOD_DOOR;
                case 3:
                    return NCStructureStrongholdPieces.Stronghold.Door.GRATES;
                case 4:
                    return NCStructureStrongholdPieces.Stronghold.Door.IRON_DOOR;
            }
        }

        protected StructureComponent getNextComponentNormal(NCStructureStrongholdPieces.NCStairs2 p_74986_1_, List p_74986_2_, Random p_74986_3_, int p_74986_4_, int p_74986_5_)
        {
            switch (this.coordBaseMode)
            {
                case 0:
                    return NCStructureStrongholdPieces.getNextValidComponent(p_74986_1_, p_74986_2_, p_74986_3_, this.boundingBox.minX + p_74986_4_, this.boundingBox.minY + p_74986_5_, this.boundingBox.maxZ + 1, this.coordBaseMode, this.getComponentType());
                case 1:
                    return NCStructureStrongholdPieces.getNextValidComponent(p_74986_1_, p_74986_2_, p_74986_3_, this.boundingBox.minX - 1, this.boundingBox.minY + p_74986_5_, this.boundingBox.minZ + p_74986_4_, this.coordBaseMode, this.getComponentType());
                case 2:
                    return NCStructureStrongholdPieces.getNextValidComponent(p_74986_1_, p_74986_2_, p_74986_3_, this.boundingBox.minX + p_74986_4_, this.boundingBox.minY + p_74986_5_, this.boundingBox.minZ - 1, this.coordBaseMode, this.getComponentType());
                case 3:
                    return NCStructureStrongholdPieces.getNextValidComponent(p_74986_1_, p_74986_2_, p_74986_3_, this.boundingBox.maxX + 1, this.boundingBox.minY + p_74986_5_, this.boundingBox.minZ + p_74986_4_, this.coordBaseMode, this.getComponentType());
                default:
                    return null;
            }
        }

        protected StructureComponent getNextComponentX(NCStructureStrongholdPieces.NCStairs2 p_74989_1_, List p_74989_2_, Random p_74989_3_, int p_74989_4_, int p_74989_5_)
        {
            switch (this.coordBaseMode)
            {
                case 0:
                    return NCStructureStrongholdPieces.getNextValidComponent(p_74989_1_, p_74989_2_, p_74989_3_, this.boundingBox.minX - 1, this.boundingBox.minY + p_74989_4_, this.boundingBox.minZ + p_74989_5_, 1, this.getComponentType());
                case 1:
                    return NCStructureStrongholdPieces.getNextValidComponent(p_74989_1_, p_74989_2_, p_74989_3_, this.boundingBox.minX + p_74989_5_, this.boundingBox.minY + p_74989_4_, this.boundingBox.minZ - 1, 2, this.getComponentType());
                case 2:
                    return NCStructureStrongholdPieces.getNextValidComponent(p_74989_1_, p_74989_2_, p_74989_3_, this.boundingBox.minX - 1, this.boundingBox.minY + p_74989_4_, this.boundingBox.minZ + p_74989_5_, 1, this.getComponentType());
                case 3:
                    return NCStructureStrongholdPieces.getNextValidComponent(p_74989_1_, p_74989_2_, p_74989_3_, this.boundingBox.minX + p_74989_5_, this.boundingBox.minY + p_74989_4_, this.boundingBox.minZ - 1, 2, this.getComponentType());
                default:
                    return null;
            }
        }

        protected StructureComponent getNextComponentZ(NCStructureStrongholdPieces.NCStairs2 p_74987_1_, List p_74987_2_, Random p_74987_3_, int p_74987_4_, int p_74987_5_)
        {
            switch (this.coordBaseMode)
            {
                case 0:
                    return NCStructureStrongholdPieces.getNextValidComponent(p_74987_1_, p_74987_2_, p_74987_3_, this.boundingBox.maxX + 1, this.boundingBox.minY + p_74987_4_, this.boundingBox.minZ + p_74987_5_, 3, this.getComponentType());
                case 1:
                    return NCStructureStrongholdPieces.getNextValidComponent(p_74987_1_, p_74987_2_, p_74987_3_, this.boundingBox.minX + p_74987_5_, this.boundingBox.minY + p_74987_4_, this.boundingBox.maxZ + 1, 0, this.getComponentType());
                case 2:
                    return NCStructureStrongholdPieces.getNextValidComponent(p_74987_1_, p_74987_2_, p_74987_3_, this.boundingBox.maxX + 1, this.boundingBox.minY + p_74987_4_, this.boundingBox.minZ + p_74987_5_, 3, this.getComponentType());
                case 3:
                    return NCStructureStrongholdPieces.getNextValidComponent(p_74987_1_, p_74987_2_, p_74987_3_, this.boundingBox.minX + p_74987_5_, this.boundingBox.minY + p_74987_4_, this.boundingBox.maxZ + 1, 0, this.getComponentType());
                default:
                    return null;
            }
        }

        protected static boolean canStrongholdGoDeeper(StructureBoundingBox p_74991_0_)
        {
            return p_74991_0_ != null && p_74991_0_.minY > 10;
        }

        public static enum Door
        {
            OPENING,
            WOOD_DOOR,
            GRATES,
            IRON_DOOR;

        }
    }

    static final class SwitchDoor
    {
        static final int[] doorEnum = new int[NCStructureStrongholdPieces.Stronghold.Door.values().length];

        static
        {
            try
            {
                doorEnum[NCStructureStrongholdPieces.Stronghold.Door.OPENING.ordinal()] = 1;
            }
            catch (NoSuchFieldError var4)
            {
                ;
            }

            try
            {
                doorEnum[NCStructureStrongholdPieces.Stronghold.Door.WOOD_DOOR.ordinal()] = 2;
            }
            catch (NoSuchFieldError var3)
            {
                ;
            }

            try
            {
                doorEnum[NCStructureStrongholdPieces.Stronghold.Door.GRATES.ordinal()] = 3;
            }
            catch (NoSuchFieldError var2)
            {
                ;
            }

            try
            {
                doorEnum[NCStructureStrongholdPieces.Stronghold.Door.IRON_DOOR.ordinal()] = 4;
            }
            catch (NoSuchFieldError var1)
            {
                ;
            }
        }
    }
}
