package com.NovaCraft.world.sculkshaft;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import com.NovaCraft.config.Configs;
import com.NovaCraft.config.ConfigsCompact;
import com.NovaCraft.config.ConfigsWorld;
import com.NovaCraft.registry.OtherModBlocks;
import com.NovaCraftBlocks.NovaCraftBlocks;
import cpw.mods.fml.common.Loader;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraftforge.common.ChestGenHooks;
import static net.minecraftforge.common.ChestGenHooks.*;

public class StructureSculkMineshaftPieces {
    public static void registerStructurePieces()
    {
        MapGenStructureIO.func_143031_a(StructureSculkMineshaftPieces.Corridor.class, "NCSMC");
        MapGenStructureIO.func_143031_a(StructureSculkMineshaftPieces.Cross.class, "NCSMX");
        MapGenStructureIO.func_143031_a(StructureSculkMineshaftPieces.Room.class, "NCSMR");
        MapGenStructureIO.func_143031_a(StructureSculkMineshaftPieces.Stairs.class, "NCSMS");
        MapGenStructureIO.registerStructure(StructureSculkMineshaftStart.class, "NCSM");
    }

    private static StructureComponent getRandomComponent(List list, Random random, int p_78815_2_, int p_78815_3_, int p_78815_4_, int p_78815_5_, int p_78815_6_)
    {
        int j1 = random.nextInt(100);
        StructureBoundingBox structureboundingbox;

        if (j1 >= 80)
        {
            structureboundingbox = StructureSculkMineshaftPieces.Cross.findValidPlacement(list, random, p_78815_2_, p_78815_3_, p_78815_4_, p_78815_5_);

            if (structureboundingbox != null)
            {
                return new StructureSculkMineshaftPieces.Cross(p_78815_6_, random, structureboundingbox, p_78815_5_);
            }
        }
        else if (j1 >= 70)
        {
            structureboundingbox = StructureSculkMineshaftPieces.Stairs.findValidPlacement(list, random, p_78815_2_, p_78815_3_, p_78815_4_, p_78815_5_);

            if (structureboundingbox != null)
            {
                return new StructureSculkMineshaftPieces.Stairs(p_78815_6_, random, structureboundingbox, p_78815_5_);
            }
        }
        else
        {
            structureboundingbox = StructureSculkMineshaftPieces.Corridor.findValidPlacement(list, random, p_78815_2_, p_78815_3_, p_78815_4_, p_78815_5_);

            if (structureboundingbox != null)
            {
                return new StructureSculkMineshaftPieces.Corridor(p_78815_6_, random, structureboundingbox, p_78815_5_);
            }
        }

        return null;
    }

    private static StructureComponent getNextMineShaftComponent(StructureComponent component, List list, Random random, int p_78817_3_, int p_78817_4_, int p_78817_5_, int p_78817_6_, int p_78817_7_)
    {
        if (p_78817_7_ > 8)
        {
            return null;
        }
        else if (Math.abs(p_78817_3_ - component.getBoundingBox().minX) <= 80 && Math.abs(p_78817_5_ - component.getBoundingBox().minZ) <= 80)
        {
            StructureComponent structurecomponent1 = getRandomComponent(list, random, p_78817_3_, p_78817_4_, p_78817_5_, p_78817_6_, p_78817_7_ + 1);

            if (structurecomponent1 != null)
            {
                list.add(structurecomponent1);
                structurecomponent1.buildComponent(component, list, random);
            }

            return structurecomponent1;
        }
        else
        {
            return null;
        }
    }

    public static class Corridor extends StructureComponent
        {
            private boolean hasRails;
            private boolean hasSculk;
            private boolean hasSculk2;
            private boolean hasSpiders;
            private boolean spawnerPlaced;
            private int sectionCount;

            public Corridor() {}

            protected void func_143012_a(NBTTagCompound compound)
            {
                compound.setBoolean("hr", this.hasRails);
                compound.setBoolean("hs", this.hasSculk);
                compound.setBoolean("hs2", this.hasSculk2);
                compound.setBoolean("sc", this.hasSpiders);
                compound.setBoolean("hps", this.spawnerPlaced);
                compound.setInteger("Num", this.sectionCount);
            }

            protected void func_143011_b(NBTTagCompound compound)
            {
                this.hasRails = compound.getBoolean("hr");
                this.hasSculk = compound.getBoolean("hs");
                this.hasSculk2 = compound.getBoolean("hs2");
                this.hasSpiders = compound.getBoolean("sc");
                this.spawnerPlaced = compound.getBoolean("hps");
                this.sectionCount = compound.getInteger("Num");
            }

            public Corridor(int p_i2035_1_, Random random, StructureBoundingBox structureBoundingBox, int p_i2035_4_)
            {
                super(p_i2035_1_);
                this.coordBaseMode = p_i2035_4_;
                this.boundingBox = structureBoundingBox;
                this.hasRails = random.nextInt(3) == 0;
                this.hasSculk = !this.hasSpiders && random.nextInt(5) == 0;
                this.hasSculk2 = !this.hasSpiders && random.nextInt(4) == 0; 
                this.hasSpiders = !this.hasRails && random.nextInt(23) == 0;

                if (this.coordBaseMode != 2 && this.coordBaseMode != 0)
                {
                    this.sectionCount = structureBoundingBox.getXSize() / 5;
                }
                else
                {
                    this.sectionCount = structureBoundingBox.getZSize() / 5;
                }
            }

            public static StructureBoundingBox findValidPlacement(List list, Random random, int p_74954_2_, int p_74954_3_, int p_74954_4_, int p_74954_5_)
            {
                StructureBoundingBox structureboundingbox = new StructureBoundingBox(p_74954_2_, p_74954_3_, p_74954_4_, p_74954_2_, p_74954_3_ + 2, p_74954_4_);
                int i1;

                for (i1 = random.nextInt(3) + 2; i1 > 0; --i1)
                {
                    int j1 = i1 * 5;

                    switch (p_74954_5_)
                    {
                        case 0:
                            structureboundingbox.maxX = p_74954_2_ + 2;
                            structureboundingbox.maxZ = p_74954_4_ + (j1 - 1);
                            break;
                        case 1:
                            structureboundingbox.minX = p_74954_2_ - (j1 - 1);
                            structureboundingbox.maxZ = p_74954_4_ + 2;
                            break;
                        case 2:
                            structureboundingbox.maxX = p_74954_2_ + 2;
                            structureboundingbox.minZ = p_74954_4_ - (j1 - 1);
                            break;
                        case 3:
                            structureboundingbox.maxX = p_74954_2_ + (j1 - 1);
                            structureboundingbox.maxZ = p_74954_4_ + 2;
                    }

                    if (StructureComponent.findIntersecting(list, structureboundingbox) == null)
                    {
                        break;
                    }
                }

                return i1 > 0 ? structureboundingbox : null;
            }

            public void buildComponent(StructureComponent component, List list, Random random)
            {
                int i = this.getComponentType();
                int j = random.nextInt(4);

                switch (this.coordBaseMode)
                {
                    case 0:
                        if (j <= 1)
                        {
                            StructureSculkMineshaftPieces.getNextMineShaftComponent(component, list, random, this.boundingBox.minX, this.boundingBox.minY - 1 + random.nextInt(3), this.boundingBox.maxZ + 1, this.coordBaseMode, i);
                        }
                        else if (j == 2)
                        {
                            StructureSculkMineshaftPieces.getNextMineShaftComponent(component, list, random, this.boundingBox.minX - 1, this.boundingBox.minY - 1 + random.nextInt(3), this.boundingBox.maxZ - 3, 1, i);
                        }
                        else
                        {
                            StructureSculkMineshaftPieces.getNextMineShaftComponent(component, list, random, this.boundingBox.maxX + 1, this.boundingBox.minY - 1 + random.nextInt(3), this.boundingBox.maxZ - 3, 3, i);
                        }

                        break;
                    case 1:
                        if (j <= 1)
                        {
                            StructureSculkMineshaftPieces.getNextMineShaftComponent(component, list, random, this.boundingBox.minX - 1, this.boundingBox.minY - 1 + random.nextInt(3), this.boundingBox.minZ, this.coordBaseMode, i);
                        }
                        else if (j == 2)
                        {
                            StructureSculkMineshaftPieces.getNextMineShaftComponent(component, list, random, this.boundingBox.minX, this.boundingBox.minY - 1 + random.nextInt(3), this.boundingBox.minZ - 1, 2, i);
                        }
                        else
                        {
                            StructureSculkMineshaftPieces.getNextMineShaftComponent(component, list, random, this.boundingBox.minX, this.boundingBox.minY - 1 + random.nextInt(3), this.boundingBox.maxZ + 1, 0, i);
                        }

                        break;
                    case 2:
                        if (j <= 1)
                        {
                            StructureSculkMineshaftPieces.getNextMineShaftComponent(component, list, random, this.boundingBox.minX, this.boundingBox.minY - 1 + random.nextInt(3), this.boundingBox.minZ - 1, this.coordBaseMode, i);
                        }
                        else if (j == 2)
                        {
                            StructureSculkMineshaftPieces.getNextMineShaftComponent(component, list, random, this.boundingBox.minX - 1, this.boundingBox.minY - 1 + random.nextInt(3), this.boundingBox.minZ, 1, i);
                        }
                        else
                        {
                            StructureSculkMineshaftPieces.getNextMineShaftComponent(component, list, random, this.boundingBox.maxX + 1, this.boundingBox.minY - 1 + random.nextInt(3), this.boundingBox.minZ, 3, i);
                        }

                        break;
                    case 3:
                        if (j <= 1)
                        {
                            StructureSculkMineshaftPieces.getNextMineShaftComponent(component, list, random, this.boundingBox.maxX + 1, this.boundingBox.minY - 1 + random.nextInt(3), this.boundingBox.minZ, this.coordBaseMode, i);
                        }
                        else if (j == 2)
                        {
                            StructureSculkMineshaftPieces.getNextMineShaftComponent(component, list, random, this.boundingBox.maxX - 3, this.boundingBox.minY - 1 + random.nextInt(3), this.boundingBox.minZ - 1, 2, i);
                        }
                        else
                        {
                            StructureSculkMineshaftPieces.getNextMineShaftComponent(component, list, random, this.boundingBox.maxX - 3, this.boundingBox.minY - 1 + random.nextInt(3), this.boundingBox.maxZ + 1, 0, i);
                        }
                }

                if (i < 8)
                {
                    int k;
                    int l;

                    if (this.coordBaseMode != 2 && this.coordBaseMode != 0)
                    {
                        for (k = this.boundingBox.minX + 3; k + 3 <= this.boundingBox.maxX; k += 5)
                        {
                            l = random.nextInt(5);

                            if (l == 0)
                            {
                                StructureSculkMineshaftPieces.getNextMineShaftComponent(component, list, random, k, this.boundingBox.minY, this.boundingBox.minZ - 1, 2, i + 1);
                            }
                            else if (l == 1)
                            {
                                StructureSculkMineshaftPieces.getNextMineShaftComponent(component, list, random, k, this.boundingBox.minY, this.boundingBox.maxZ + 1, 0, i + 1);
                            }
                        }
                    }
                    else
                    {
                        for (k = this.boundingBox.minZ + 3; k + 3 <= this.boundingBox.maxZ; k += 5)
                        {
                            l = random.nextInt(5);

                            if (l == 0)
                            {
                                StructureSculkMineshaftPieces.getNextMineShaftComponent(component, list, random, this.boundingBox.minX - 1, this.boundingBox.minY, k, 1, i + 1);
                            }
                            else if (l == 1)
                            {
                                StructureSculkMineshaftPieces.getNextMineShaftComponent(component, list, random, this.boundingBox.maxX + 1, this.boundingBox.minY, k, 3, i + 1);
                            }
                        }
                    }
                }
            }

            protected boolean generateStructureChestContents(World world, StructureBoundingBox structureBoundingBox, Random random, int p_74879_4_, int p_74879_5_, int p_74879_6_, WeightedRandomChestContent[] p_74879_7_, int p_74879_8_)
            {
                int i1 = this.getXWithOffset(p_74879_4_, p_74879_6_);
                int j1 = this.getYWithOffset(p_74879_5_);
                int k1 = this.getZWithOffset(p_74879_4_, p_74879_6_);

                if (structureBoundingBox.isVecInside(i1, j1, k1) && world.getBlock(i1, j1, k1).getMaterial() == Material.air)
                {
                    world.setBlock(i1, j1, k1, NovaCraftBlocks.mineshaft_chest, 0, 0);            
                	                   
            		return true;
                }
                else
                {
                    return false;
                }
               
            }

            public boolean addComponentParts(World world, Random random, StructureBoundingBox structureBoundingBox)
            {
                if (this.isLiquidInStructureBoundingBox(world, structureBoundingBox))
                {
                    return false;
                }
                else
                {
                    boolean flag = false;
                    boolean flag1 = true;
                    boolean flag2 = false;
                    boolean flag3 = true;
                    int i = this.sectionCount * 5 - 1;
                    this.fillWithBlocks(world, structureBoundingBox, 0, 0, 0, 2, 1, i, Blocks.air, Blocks.air, false);
                    this.randomlyFillWithBlocks(world, structureBoundingBox, random, 0.8F, 0, 2, 0, 2, 2, i, Blocks.air, Blocks.air, false);

                    if (this.hasSpiders)
                    {
                        this.randomlyFillWithBlocks(world, structureBoundingBox, random, 0.6F, 0, 0, 0, 2, 1, i, NovaCraftBlocks.sculk_block, Blocks.air, false);
                    }

                    int j;
                    int k;

                    for (j = 0; j < this.sectionCount; ++j)
                    {
                        k = 2 + j * 5;
                        this.fillWithBlocks(world, structureBoundingBox, 0, 0, k, 0, 1, k, NovaCraftBlocks.grimstone_brick_wall, Blocks.air, false);
                        this.fillWithBlocks(world, structureBoundingBox, 2, 0, k, 2, 1, k, NovaCraftBlocks.grimstone_brick_wall, Blocks.air, false);

                        if (random.nextInt(4) == 0)
                        {
                            this.fillWithBlocks(world, structureBoundingBox, 0, 2, k, 0, 2, k, NovaCraftBlocks.grimstone_bricks, Blocks.air, false);
                            this.fillWithBlocks(world, structureBoundingBox, 2, 2, k, 2, 2, k, NovaCraftBlocks.grimstone_bricks, Blocks.air, false);
                        }
                        else
                        {
                            this.fillWithBlocks(world, structureBoundingBox, 0, 2, k, 2, 2, k, NovaCraftBlocks.grimstone_bricks, Blocks.air, false);
                        }

                        this.func_151552_a(world, structureBoundingBox, random, 0.3F, 0, 2, k - 1, NovaCraftBlocks.sculk_block, 0);
                        this.func_151552_a(world, structureBoundingBox, random, 0.3F, 2, 2, k - 1, NovaCraftBlocks.sculk_block, 0);
                        this.func_151552_a(world, structureBoundingBox, random, 0.3F, 0, 2, k + 1, NovaCraftBlocks.sculk_block, 0);
                        this.func_151552_a(world, structureBoundingBox, random, 0.3F, 2, 2, k + 1, NovaCraftBlocks.sculk_block, 0);
                        
                        this.func_151552_a(world, structureBoundingBox, random, 0.3F, 0, j - 3, k - 1, NovaCraftBlocks.sculk_block, 0); //new
                        this.func_151552_a(world, structureBoundingBox, random, 0.3F, 2, j - 3, k - 1, NovaCraftBlocks.sculk_block, 0);
                        this.func_151552_a(world, structureBoundingBox, random, 0.3F, 0, j - 3, k + 1, NovaCraftBlocks.sculk_block, 0);
                        this.func_151552_a(world, structureBoundingBox, random, 0.3F, 2, j - 3, k + 1, NovaCraftBlocks.sculk_block, 0);
                        
                        this.func_151552_a(world, structureBoundingBox, random, 0.3F, 0, j - 3, k - 2, NovaCraftBlocks.sculk_block, 0); //new
                        this.func_151552_a(world, structureBoundingBox, random, 0.3F, 2, j - 3, k - 2, NovaCraftBlocks.sculk_block, 0);
                        this.func_151552_a(world, structureBoundingBox, random, 0.3F, 0, j - 3, k + 2, NovaCraftBlocks.sculk_block, 0);
                        this.func_151552_a(world, structureBoundingBox, random, 0.3F, 2, j - 3, k + 2, NovaCraftBlocks.sculk_block, 0);
                        
                        this.func_151552_a(world, structureBoundingBox, random, 0.1F, 0, j - 2, k - 2, NovaCraftBlocks.sculk_block, 0); //new
                        this.func_151552_a(world, structureBoundingBox, random, 0.1F, 2, j - 2, k - 2, NovaCraftBlocks.sculk_block, 0);
                        this.func_151552_a(world, structureBoundingBox, random, 0.1F, 0, j - 2, k + 2, NovaCraftBlocks.sculk_block, 0);
                        this.func_151552_a(world, structureBoundingBox, random, 0.1F, 2, j - 2, k + 2, NovaCraftBlocks.sculk_block, 0);
                        
                        this.func_151552_a(world, structureBoundingBox, random, 0.1F, i - 2, j - 2, 0, NovaCraftBlocks.sculk_block, 0); //new
                        this.func_151552_a(world, structureBoundingBox, random, 0.1F, i - 2, j - 2, 2, NovaCraftBlocks.sculk_block, 0);
                        this.func_151552_a(world, structureBoundingBox, random, 0.1F, i + 2, j - 2, 0, NovaCraftBlocks.sculk_block, 0);
                        this.func_151552_a(world, structureBoundingBox, random, 0.1F, i + 2, j - 2, 2, NovaCraftBlocks.sculk_block, 0);
                        
                        {
                        if (ConfigsWorld.enableBrimstoneOre) {
                        	this.func_151552_a(world, structureBoundingBox, random, 0.08F, 0, j - 3, k - 3, NovaCraftBlocks.brimstone_ore, 0); //new
                        	this.func_151552_a(world, structureBoundingBox, random, 0.08F, 2, j - 3, k - 3, NovaCraftBlocks.brimstone_ore, 0);
                        	this.func_151552_a(world, structureBoundingBox, random, 0.08F, 0, j - 3, k + 3, NovaCraftBlocks.brimstone_ore, 0);
                        	this.func_151552_a(world, structureBoundingBox, random, 0.08F, 2, j - 3, k + 3, NovaCraftBlocks.brimstone_ore, 0);
                        
                        	this.func_151552_a(world, structureBoundingBox, random, 0.08F, 0, j - 4, k - 2, NovaCraftBlocks.brimstone_ore, 0); //new
                        	this.func_151552_a(world, structureBoundingBox, random, 0.08F, 2, j - 4, k - 2, NovaCraftBlocks.brimstone_ore, 0);
                        	this.func_151552_a(world, structureBoundingBox, random, 0.08F, 0, j - 4, k + 2, NovaCraftBlocks.brimstone_ore, 0);
                        	this.func_151552_a(world, structureBoundingBox, random, 0.08F, 2, j - 4, k + 2, NovaCraftBlocks.brimstone_ore, 0);
                        }
                        else {
                        	this.func_151552_a(world, structureBoundingBox, random, 0.08F, 0, j - 3, k - 3, Blocks.iron_ore, 0); //new
                        	this.func_151552_a(world, structureBoundingBox, random, 0.08F, 2, j - 3, k - 3, Blocks.iron_ore, 0);
                        	this.func_151552_a(world, structureBoundingBox, random, 0.08F, 0, j - 3, k + 3, Blocks.iron_ore, 0);
                            this.func_151552_a(world, structureBoundingBox, random, 0.08F, 2, j - 3, k + 3, Blocks.iron_ore, 0);
                            
                            this.func_151552_a(world, structureBoundingBox, random, 0.08F, 0, j - 4, k - 2, Blocks.iron_ore, 0); //new
                            this.func_151552_a(world, structureBoundingBox, random, 0.08F, 2, j - 4, k - 2, Blocks.iron_ore, 0);
                            this.func_151552_a(world, structureBoundingBox, random, 0.08F, 0, j - 4, k + 2, Blocks.iron_ore, 0);
                            this.func_151552_a(world, structureBoundingBox, random, 0.08F, 2, j - 4, k + 2, Blocks.iron_ore, 0);	
                         }
                        }
                        
                        {
                            try {
                                if (Loader.isModLoaded("etfuturum") && ConfigsCompact.enableRawOreBlocks) {
                                    this.func_151552_a(world, structureBoundingBox, random, 0.05F, 0, j + 3, k - 3, OtherModBlocks.raw_ore_block, 0);
                                    this.func_151552_a(world, structureBoundingBox, random, 0.05F, 2, j + 3, k - 3, OtherModBlocks.raw_ore_block, 1);
                                    this.func_151552_a(world, structureBoundingBox, random, 0.05F, 0, j + 3, k + 3, OtherModBlocks.raw_ore_block, 1);
                                    this.func_151552_a(world, structureBoundingBox, random, 0.05F, 2, j + 3, k + 3, OtherModBlocks.raw_ore_block, 2);

                                    this.func_151552_a(world, structureBoundingBox, random, 0.05F, 0, -1, k - 2, OtherModBlocks.raw_ore_block, 0);
                                    this.func_151552_a(world, structureBoundingBox, random, 0.05F, 2, -1, k - 2, OtherModBlocks.raw_ore_block, 1);
                                    this.func_151552_a(world, structureBoundingBox, random, 0.05F, 0, -1, k + 2, OtherModBlocks.raw_ore_block, 1);
                                    this.func_151552_a(world, structureBoundingBox, random, 0.05F, 2, -1, k + 2, OtherModBlocks.raw_ore_block, 2);
                                } else {
                                    this.func_151552_a(world, structureBoundingBox, random, 0.05F, 0, j + 3, k - 3, Blocks.iron_ore, 0);
                                    this.func_151552_a(world, structureBoundingBox, random, 0.05F, 2, j + 3, k - 3, Blocks.iron_ore, 0);
                                    this.func_151552_a(world, structureBoundingBox, random, 0.05F, 0, j + 3, k + 3, Blocks.iron_ore, 0);
                                    this.func_151552_a(world, structureBoundingBox, random, 0.05F, 2, j + 3, k + 3, Blocks.gold_ore, 0);

                                    this.func_151552_a(world, structureBoundingBox, random, 0.05F, 0, -1, k - 2, Blocks.iron_ore, 0);
                                    this.func_151552_a(world, structureBoundingBox, random, 0.05F, 2, -1, k - 2, Blocks.iron_ore, 0);
                                    this.func_151552_a(world, structureBoundingBox, random, 0.05F, 0, -1, k + 2, Blocks.iron_ore, 0);
                                    this.func_151552_a(world, structureBoundingBox, random, 0.05F, 2, -1, k + 2, Blocks.gold_ore, 0);
                                }
                            } catch (Exception ex) {
                                if (Configs.enableDebugMode) {
                                    System.out.println("Missing Raw Ore Blocks from Et Futurum Requiem, using Vanilla Ores instead...");
                                }
                                this.func_151552_a(world, structureBoundingBox, random, 0.05F, 0, j + 3, k - 3, Blocks.iron_ore, 0);
                                this.func_151552_a(world, structureBoundingBox, random, 0.05F, 2, j + 3, k - 3, Blocks.iron_ore, 0);
                                this.func_151552_a(world, structureBoundingBox, random, 0.05F, 0, j + 3, k + 3, Blocks.iron_ore, 0);
                                this.func_151552_a(world, structureBoundingBox, random, 0.05F, 2, j + 3, k + 3, Blocks.gold_ore, 0);

                                this.func_151552_a(world, structureBoundingBox, random, 0.05F, 0, -1, k - 2, Blocks.iron_ore, 0);
                                this.func_151552_a(world, structureBoundingBox, random, 0.05F, 2, -1, k - 2, Blocks.iron_ore, 0);
                                this.func_151552_a(world, structureBoundingBox, random, 0.05F, 0, -1, k + 2, Blocks.iron_ore, 0);
                                this.func_151552_a(world, structureBoundingBox, random, 0.05F, 2, -1, k + 2, Blocks.gold_ore, 0);
                            }
                        }
                        
                        this.func_151552_a(world, structureBoundingBox, random, 0.05F, 0, 2, k - 2, NovaCraftBlocks.sculk_block, 0);
                        this.func_151552_a(world, structureBoundingBox, random, 0.05F, 2, 2, k - 2, NovaCraftBlocks.sculk_block, 0);
                        this.func_151552_a(world, structureBoundingBox, random, 0.05F, 0, 2, k + 2, NovaCraftBlocks.sculk_block, 0);
                        this.func_151552_a(world, structureBoundingBox, random, 0.05F, 2, 2, k + 2, NovaCraftBlocks.sculk_block, 0);
                        
                        this.func_151552_a(world, structureBoundingBox, random, 0.05F, 1, 2, k - 1, NovaCraftBlocks.sculk_spike, 0);
                        this.func_151552_a(world, structureBoundingBox, random, 0.05F, 1, 2, k + 1, NovaCraftBlocks.sculk_spike, 0);
                        
                        this.func_151552_a(world, structureBoundingBox, random, 0.07F, 1, 2, k + 1, NovaCraftBlocks.sculk_tendrils, 0);

                        int chance = random.nextInt(15) + 1;
                		switch (chance) {
                        case 1:
                        	this.func_151552_a(world, structureBoundingBox, random, 0.6F, 1, -1, k + 1, NovaCraftBlocks.sculk_stone, 0);
                            break;
                        case 2:
                        	this.func_151552_a(world, structureBoundingBox, random, 0.4F, 1, 0, k + 1, NovaCraftBlocks.sculk_tentacle_2, 1);
                            break;
                        case 3:
                        	this.func_151552_a(world, structureBoundingBox, random, 0.1F, 1, 0, k + 1, NovaCraftBlocks.sculk_bloom, 0);
                        	this.func_151552_a(world, structureBoundingBox, random, 1.0F, 1, -1, k + 1, NovaCraftBlocks.sculk_block, 0);
                            break;
                        case 4:
                        	this.func_151552_a(world, structureBoundingBox, random, 1.0F, 1, 0, k + 1, NovaCraftBlocks.sculk_spike, 1);
                            break;
                        case 5:
                        	this.func_151552_a(world, structureBoundingBox, random, 1.0F, 1, 0, k + 1, NovaCraftBlocks.sculk_spike, 1);
                            break;
                        case 6:
                        	this.func_151552_a(world, structureBoundingBox, random, 1.0F, 1, 0, k + 1, NovaCraftBlocks.sculk_vein, 1);
                            break;
                        case 7:
                        	this.func_151552_a(world, structureBoundingBox, random, 1.0F, 1, 0, k + 1, NovaCraftBlocks.sculk_growth, 1);
                            break;
                        case 8:
                        	this.func_151552_a(world, structureBoundingBox, random, 0.8F, 1, 0, k + 1, NovaCraftBlocks.sculk_tendrils, 0);
                        	this.func_151552_a(world, structureBoundingBox, random, 1.0F, 1, 1, k + 1, NovaCraftBlocks.sculk_tendrils, 0);
                        	this.func_151552_a(world, structureBoundingBox, random, 1.0F, 1, 2, k + 1, NovaCraftBlocks.sculk_tendrils, 0);
                            break;
                        case 9:
                        	this.func_151552_a(world, structureBoundingBox, random, 1.0F, 1, 0, k + 1, NovaCraftBlocks.sculk_tendrils, 0);
                        	this.func_151552_a(world, structureBoundingBox, random, 1.0F, 1, 1, k + 1, NovaCraftBlocks.sculk_tendrils, 0);
                        	this.func_151552_a(world, structureBoundingBox, random, 0.8F, 1, 2, k + 1, NovaCraftBlocks.sculk_tendrils, 0);
                            break;
                        case 10:
                        	this.func_151552_a(world, structureBoundingBox, random, 1.0F, 1, 0, k + 2, NovaCraftBlocks.sculk_tendrils, 0);
                        	this.func_151552_a(world, structureBoundingBox, random, 1.0F, 1, 1, k + 2, NovaCraftBlocks.sculk_tendrils, 0);
                        	this.func_151552_a(world, structureBoundingBox, random, 0.8F, 1, 2, k + 2, NovaCraftBlocks.sculk_tendrils, 0);
                            break;
                            default:
                                this.func_151552_a(world, structureBoundingBox, random, 1.0F, 1, 0, k + 1, NovaCraftBlocks.sculk_vein, 1);
                                break;
                        }
                		
                		ChestGenHooks info = ChestGenHooks.getInfo(MINESHAFT_CORRIDOR);                    
                        int k3;
                        k3 = 2 + j * 5;
                        if (random.nextInt(50) == 0)
                        {
                            this.generateStructureChestContents(world, structureBoundingBox, random, 2, 0, k3 - 1, info.getItems(random), info.getCount(random));
                        }
                        
                        if (random.nextInt(50) == 0)
                        {
                        	this.generateStructureChestContents(world, structureBoundingBox, random, 2, 0, k3 - 1, info.getItems(random), info.getCount(random));
                        }

                        if (this.hasSpiders && !this.spawnerPlaced)
                        {
                            int chance2 = random.nextInt(2) + 1;
                    		switch (chance2)
                            {
                    		case 1:
                            int l = this.getYWithOffset(0);
                            int i1 = k - 1 + random.nextInt(3);
                            int j1 = this.getXWithOffset(1, i1);
                            i1 = this.getZWithOffset(1, i1);

                            if (structureBoundingBox.isVecInside(j1, l, i1))
                            {
                                this.spawnerPlaced = true;
                                world.setBlock(j1, l, i1, Blocks.mob_spawner, 0, 2);
                                TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner)world.getTileEntity(j1, l, i1);
                                if (tileentitymobspawner != null)
                                {
                                    tileentitymobspawner.func_145881_a().setEntityName("nova_craft.sculk_symbiote");
                                }
                                
                                world.setBlock(j1, l + 1, i1, Blocks.mob_spawner, 0, 2);
                                TileEntityMobSpawner tileentitymobspawner3 = (TileEntityMobSpawner)world.getTileEntity(j1, l + 1, i1);
                                if (tileentitymobspawner3 != null)
                                {
                                    tileentitymobspawner3.func_145881_a().setEntityName("nova_craft.sculk_duplicator");
                                }
                                world.setBlock(j1, l + 2, i1, NovaCraftBlocks.treasure_chest, 0, 2);
                            }
                            break;
                            
                    		case 2:
                                int l2 = this.getYWithOffset(0);
                                int i12 = k - 1 + random.nextInt(3);
                                int j12 = this.getXWithOffset(1, i12);
                                i1 = this.getZWithOffset(1, i12);

                                if (structureBoundingBox.isVecInside(j12, l2, i12))
                                {
                                    this.spawnerPlaced = true;
                                    world.setBlock(j12, l2, i12, Blocks.mob_spawner, 0, 2);
                                    TileEntityMobSpawner tileentitymobspawner2 = (TileEntityMobSpawner)world.getTileEntity(j12, l2, i12);
                                    if (tileentitymobspawner2 != null)
                                    {
                                        tileentitymobspawner2.func_145881_a().setEntityName("nova_craft.sculk_duplicator");
                                    }
                                    world.setBlock(j12, l2 + 1, i12, NovaCraftBlocks.treasure_chest, 0, 2);
                                }
                                break;
                            }
                        }
                        
                    }

                    for (j = 0; j <= 2; ++j)
                    {
                        for (k = 0; k <= i; ++k)
                        {
                            byte b0 = -1;
                            Block block1 = this.getBlockAtCurrentPosition(world, j, b0, k, structureBoundingBox);

                            if (block1.getMaterial() == Material.air)
                            {
                                byte b1 = -1;
                                this.placeBlockAtCurrentPosition(world, NovaCraftBlocks.cobbled_grimstone, 0, j, b1, k, structureBoundingBox);
                            }
                        }
                    }

                    if (this.hasRails)
                    {
                        for (j = 0; j <= i; ++j)
                        {
                            Block block = this.getBlockAtCurrentPosition(world, 1, -1, j, structureBoundingBox);

                            if (block.getMaterial() != Material.air && block.func_149730_j())
                            {
                                this.func_151552_a(world, structureBoundingBox, random, 0.7F, 1, 0, j, Blocks.rail, this.getMetadataWithOffset(Blocks.rail, 0));
                            }
                        }
                    }
                    
                    if (this.hasSculk)
                    {
                        for (j = 0; j <= i; ++j)
                        {
                            Block block = this.getBlockAtCurrentPosition(world, 1, -1, j, structureBoundingBox);

                            if (block.getMaterial() != Material.air && block.func_149730_j())
                            {
                                this.func_151552_a(world, structureBoundingBox, random, 0.6F, 1, 0, j, NovaCraftBlocks.sculk_vein, this.getMetadataWithOffset(NovaCraftBlocks.sculk_vein, 1));
                            }
                        }
                    }
                    
                    if (this.hasSculk2)
                    {
                        for (j = 0; j <= i; ++j)
                        {
                            Block block = this.getBlockAtCurrentPosition(world, 1, -1, j, structureBoundingBox);

                            if (block.getMaterial() != Material.air && block.func_149730_j())
                            {
                                this.func_151552_a(world, structureBoundingBox, random, 0.5F, 1, 0, j, NovaCraftBlocks.sculk_growth, this.getMetadataWithOffset(NovaCraftBlocks.sculk_growth, 1));
                            }
                        }
                    }

                    return true;
                }
            }
        }

    public static class Cross extends StructureComponent {
            private int corridorDirection;
            private boolean isMultipleFloors;

            public Cross() {}

            protected void func_143012_a(NBTTagCompound compound)
            {
                compound.setBoolean("tf", this.isMultipleFloors);
                compound.setInteger("D", this.corridorDirection);
            }

            protected void func_143011_b(NBTTagCompound compound)
            {
                this.isMultipleFloors = compound.getBoolean("tf");
                this.corridorDirection = compound.getInteger("D");
            }

            public Cross(int p_i2036_1_, Random random, StructureBoundingBox structureBoundingBox, int p_i2036_4_)
            {
                super(p_i2036_1_);
                this.corridorDirection = p_i2036_4_;
                this.boundingBox = structureBoundingBox;
                this.isMultipleFloors = structureBoundingBox.getYSize() > 4;
            }

            public static StructureBoundingBox findValidPlacement(List list, Random random, int p_74951_2_, int p_74951_3_, int p_74951_4_, int p_74951_5_)
            {
                StructureBoundingBox structureboundingbox = new StructureBoundingBox(p_74951_2_, p_74951_3_, p_74951_4_, p_74951_2_, p_74951_3_ + 2, p_74951_4_);

                if (random.nextInt(4) == 0)
                {
                    structureboundingbox.maxY += 4;
                }

                switch (p_74951_5_)
                {
                    case 0:
                        structureboundingbox.minX = p_74951_2_ - 1;
                        structureboundingbox.maxX = p_74951_2_ + 3;
                        structureboundingbox.maxZ = p_74951_4_ + 4;
                        break;
                    case 1:
                        structureboundingbox.minX = p_74951_2_ - 4;
                        structureboundingbox.minZ = p_74951_4_ - 1;
                        structureboundingbox.maxZ = p_74951_4_ + 3;
                        break;
                    case 2:
                        structureboundingbox.minX = p_74951_2_ - 1;
                        structureboundingbox.maxX = p_74951_2_ + 3;
                        structureboundingbox.minZ = p_74951_4_ - 4;
                        break;
                    case 3:
                        structureboundingbox.maxX = p_74951_2_ + 4;
                        structureboundingbox.minZ = p_74951_4_ - 1;
                        structureboundingbox.maxZ = p_74951_4_ + 3;
                }

                return StructureComponent.findIntersecting(list, structureboundingbox) != null ? null : structureboundingbox;
            }

            public void buildComponent(StructureComponent component, List list, Random random)
            {
                int i = this.getComponentType();

                switch (this.corridorDirection)
                {
                    case 0:
                        StructureSculkMineshaftPieces.getNextMineShaftComponent(component, list, random, this.boundingBox.minX + 1, this.boundingBox.minY, this.boundingBox.maxZ + 1, 0, i);
                        StructureSculkMineshaftPieces.getNextMineShaftComponent(component, list, random, this.boundingBox.minX - 1, this.boundingBox.minY, this.boundingBox.minZ + 1, 1, i);
                        StructureSculkMineshaftPieces.getNextMineShaftComponent(component, list, random, this.boundingBox.maxX + 1, this.boundingBox.minY, this.boundingBox.minZ + 1, 3, i);
                        break;
                    case 1:
                        StructureSculkMineshaftPieces.getNextMineShaftComponent(component, list, random, this.boundingBox.minX + 1, this.boundingBox.minY, this.boundingBox.minZ - 1, 2, i);
                        StructureSculkMineshaftPieces.getNextMineShaftComponent(component, list, random, this.boundingBox.minX + 1, this.boundingBox.minY, this.boundingBox.maxZ + 1, 0, i);
                        StructureSculkMineshaftPieces.getNextMineShaftComponent(component, list, random, this.boundingBox.minX - 1, this.boundingBox.minY, this.boundingBox.minZ + 1, 1, i);
                        break;
                    case 2:
                        StructureSculkMineshaftPieces.getNextMineShaftComponent(component, list, random, this.boundingBox.minX + 1, this.boundingBox.minY, this.boundingBox.minZ - 1, 2, i);
                        StructureSculkMineshaftPieces.getNextMineShaftComponent(component, list, random, this.boundingBox.minX - 1, this.boundingBox.minY, this.boundingBox.minZ + 1, 1, i);
                        StructureSculkMineshaftPieces.getNextMineShaftComponent(component, list, random, this.boundingBox.maxX + 1, this.boundingBox.minY, this.boundingBox.minZ + 1, 3, i);
                        break;
                    case 3:
                        StructureSculkMineshaftPieces.getNextMineShaftComponent(component, list, random, this.boundingBox.minX + 1, this.boundingBox.minY, this.boundingBox.minZ - 1, 2, i);
                        StructureSculkMineshaftPieces.getNextMineShaftComponent(component, list, random, this.boundingBox.minX + 1, this.boundingBox.minY, this.boundingBox.maxZ + 1, 0, i);
                        StructureSculkMineshaftPieces.getNextMineShaftComponent(component, list, random, this.boundingBox.maxX + 1, this.boundingBox.minY, this.boundingBox.minZ + 1, 3, i);
                }

                if (this.isMultipleFloors)
                {
                    if (random.nextBoolean())
                    {
                        StructureSculkMineshaftPieces.getNextMineShaftComponent(component, list, random, this.boundingBox.minX + 1, this.boundingBox.minY + 3 + 1, this.boundingBox.minZ - 1, 2, i);
                    }

                    if (random.nextBoolean())
                    {
                        StructureSculkMineshaftPieces.getNextMineShaftComponent(component, list, random, this.boundingBox.minX - 1, this.boundingBox.minY + 3 + 1, this.boundingBox.minZ + 1, 1, i);
                    }

                    if (random.nextBoolean())
                    {
                        StructureSculkMineshaftPieces.getNextMineShaftComponent(component, list, random, this.boundingBox.maxX + 1, this.boundingBox.minY + 3 + 1, this.boundingBox.minZ + 1, 3, i);
                    }

                    if (random.nextBoolean())
                    {
                        StructureSculkMineshaftPieces.getNextMineShaftComponent(component, list, random, this.boundingBox.minX + 1, this.boundingBox.minY + 3 + 1, this.boundingBox.maxZ + 1, 0, i);
                    }
                }
            }

            public boolean addComponentParts(World world, Random random, StructureBoundingBox structureBoundingBox)
            {
                if (this.isLiquidInStructureBoundingBox(world, structureBoundingBox))
                {
                    return false;
                }
                else
                {
                    if (this.isMultipleFloors)
                    {
                        this.fillWithBlocks(world, structureBoundingBox, this.boundingBox.minX + 1, this.boundingBox.minY, this.boundingBox.minZ, this.boundingBox.maxX - 1, this.boundingBox.minY + 3 - 1, this.boundingBox.maxZ, Blocks.air, Blocks.air, false);
                        this.fillWithBlocks(world, structureBoundingBox, this.boundingBox.minX, this.boundingBox.minY, this.boundingBox.minZ + 1, this.boundingBox.maxX, this.boundingBox.minY + 3 - 1, this.boundingBox.maxZ - 1, Blocks.air, Blocks.air, false);
                        this.fillWithBlocks(world, structureBoundingBox, this.boundingBox.minX + 1, this.boundingBox.maxY - 2, this.boundingBox.minZ, this.boundingBox.maxX - 1, this.boundingBox.maxY, this.boundingBox.maxZ, Blocks.air, Blocks.air, false);
                        this.fillWithBlocks(world, structureBoundingBox, this.boundingBox.minX, this.boundingBox.maxY - 2, this.boundingBox.minZ + 1, this.boundingBox.maxX, this.boundingBox.maxY, this.boundingBox.maxZ - 1, Blocks.air, Blocks.air, false);
                        this.fillWithBlocks(world, structureBoundingBox, this.boundingBox.minX + 1, this.boundingBox.minY + 3, this.boundingBox.minZ + 1, this.boundingBox.maxX - 1, this.boundingBox.minY + 3, this.boundingBox.maxZ - 1, Blocks.air, Blocks.air, false);
                    }
                    else
                    {
                        this.fillWithBlocks(world, structureBoundingBox, this.boundingBox.minX + 1, this.boundingBox.minY, this.boundingBox.minZ, this.boundingBox.maxX - 1, this.boundingBox.maxY, this.boundingBox.maxZ, Blocks.air, Blocks.air, false);
                        this.fillWithBlocks(world, structureBoundingBox, this.boundingBox.minX, this.boundingBox.minY, this.boundingBox.minZ + 1, this.boundingBox.maxX, this.boundingBox.maxY, this.boundingBox.maxZ - 1, Blocks.air, Blocks.air, false);
                    }

                    this.fillWithBlocks(world, structureBoundingBox, this.boundingBox.minX + 1, this.boundingBox.minY, this.boundingBox.minZ + 1, this.boundingBox.minX + 1, this.boundingBox.maxY, this.boundingBox.minZ + 1, NovaCraftBlocks.grimstone_bricks, Blocks.air, false);
                    this.fillWithBlocks(world, structureBoundingBox, this.boundingBox.minX + 1, this.boundingBox.minY, this.boundingBox.maxZ - 1, this.boundingBox.minX + 1, this.boundingBox.maxY, this.boundingBox.maxZ - 1, NovaCraftBlocks.grimstone_bricks, Blocks.air, false);
                    this.fillWithBlocks(world, structureBoundingBox, this.boundingBox.maxX - 1, this.boundingBox.minY, this.boundingBox.minZ + 1, this.boundingBox.maxX - 1, this.boundingBox.maxY, this.boundingBox.minZ + 1, NovaCraftBlocks.grimstone_bricks, Blocks.air, false);
                    this.fillWithBlocks(world, structureBoundingBox, this.boundingBox.maxX - 1, this.boundingBox.minY, this.boundingBox.maxZ - 1, this.boundingBox.maxX - 1, this.boundingBox.maxY, this.boundingBox.maxZ - 1, NovaCraftBlocks.grimstone_bricks, Blocks.air, false);

                    for (int i = this.boundingBox.minX; i <= this.boundingBox.maxX; ++i)
                    {
                        for (int j = this.boundingBox.minZ; j <= this.boundingBox.maxZ; ++j)
                        {
                            if (this.getBlockAtCurrentPosition(world, i, this.boundingBox.minY - 1, j, structureBoundingBox).getMaterial() == Material.air)
                            {
                                this.placeBlockAtCurrentPosition(world, NovaCraftBlocks.grimstone_bricks, 0, i, this.boundingBox.minY - 1, j, structureBoundingBox);
                            }
                        }
                    }

                    return true;
                }
            }
        }

    public static class Room extends StructureComponent
        {
            private List roomsLinkedToTheRoom = new ArrayList();

            public Room() {}

            public Room(int p_i2037_1_, Random random, int p_i2037_3_, int p_i2037_4_)
            {
                super(p_i2037_1_);
                this.boundingBox = new StructureBoundingBox(p_i2037_3_, 50, p_i2037_4_, p_i2037_3_ + 7 + random.nextInt(6), 54 + random.nextInt(6), p_i2037_4_ + 7 + random.nextInt(6));
            }

            public void buildComponent(StructureComponent component, List list, Random random)
            {
                int i = this.getComponentType();
                int k = this.boundingBox.getYSize() - 3 - 1;

                if (k <= 0)
                {
                    k = 1;
                }

                int j;
                StructureComponent structurecomponent1;
                StructureBoundingBox structureboundingbox;

                for (j = 0; j < this.boundingBox.getXSize(); j += 4)
                {
                    j += random.nextInt(this.boundingBox.getXSize());

                    if (j + 3 > this.boundingBox.getXSize())
                    {
                        break;
                    }

                    structurecomponent1 = StructureSculkMineshaftPieces.getNextMineShaftComponent(component, list, random, this.boundingBox.minX + j, this.boundingBox.minY + random.nextInt(k) + 1, this.boundingBox.minZ - 1, 2, i);

                    if (structurecomponent1 != null)
                    {
                        structureboundingbox = structurecomponent1.getBoundingBox();
                        this.roomsLinkedToTheRoom.add(new StructureBoundingBox(structureboundingbox.minX, structureboundingbox.minY, this.boundingBox.minZ, structureboundingbox.maxX, structureboundingbox.maxY, this.boundingBox.minZ + 1));
                    }
                }

                for (j = 0; j < this.boundingBox.getXSize(); j += 4)
                {
                    j += random.nextInt(this.boundingBox.getXSize());

                    if (j + 3 > this.boundingBox.getXSize())
                    {
                        break;
                    }

                    structurecomponent1 = StructureSculkMineshaftPieces.getNextMineShaftComponent(component, list, random, this.boundingBox.minX + j, this.boundingBox.minY + random.nextInt(k) + 1, this.boundingBox.maxZ + 1, 0, i);

                    if (structurecomponent1 != null)
                    {
                        structureboundingbox = structurecomponent1.getBoundingBox();
                        this.roomsLinkedToTheRoom.add(new StructureBoundingBox(structureboundingbox.minX, structureboundingbox.minY, this.boundingBox.maxZ - 1, structureboundingbox.maxX, structureboundingbox.maxY, this.boundingBox.maxZ));
                    }
                }

                for (j = 0; j < this.boundingBox.getZSize(); j += 4)
                {
                    j += random.nextInt(this.boundingBox.getZSize());

                    if (j + 3 > this.boundingBox.getZSize())
                    {
                        break;
                    }

                    structurecomponent1 = StructureSculkMineshaftPieces.getNextMineShaftComponent(component, list, random, this.boundingBox.minX - 1, this.boundingBox.minY + random.nextInt(k) + 1, this.boundingBox.minZ + j, 1, i);

                    if (structurecomponent1 != null)
                    {
                        structureboundingbox = structurecomponent1.getBoundingBox();
                        this.roomsLinkedToTheRoom.add(new StructureBoundingBox(this.boundingBox.minX, structureboundingbox.minY, structureboundingbox.minZ, this.boundingBox.minX + 1, structureboundingbox.maxY, structureboundingbox.maxZ));
                    }
                }

                for (j = 0; j < this.boundingBox.getZSize(); j += 4)
                {
                    j += random.nextInt(this.boundingBox.getZSize());

                    if (j + 3 > this.boundingBox.getZSize())
                    {
                        break;
                    }

                    structurecomponent1 = StructureSculkMineshaftPieces.getNextMineShaftComponent(component, list, random, this.boundingBox.maxX + 1, this.boundingBox.minY + random.nextInt(k) + 1, this.boundingBox.minZ + j, 3, i);

                    if (structurecomponent1 != null)
                    {
                        structureboundingbox = structurecomponent1.getBoundingBox();
                        this.roomsLinkedToTheRoom.add(new StructureBoundingBox(this.boundingBox.maxX - 1, structureboundingbox.minY, structureboundingbox.minZ, this.boundingBox.maxX, structureboundingbox.maxY, structureboundingbox.maxZ));
                    }
                }
            }

            public boolean addComponentParts(World world, Random random, StructureBoundingBox structureBoundingBox)
            {
                if (this.isLiquidInStructureBoundingBox(world, structureBoundingBox))
                {
                    return false;
                }
                else
                {
                    this.fillWithBlocks(world, structureBoundingBox, this.boundingBox.minX, this.boundingBox.minY, this.boundingBox.minZ, this.boundingBox.maxX, this.boundingBox.minY, this.boundingBox.maxZ, NovaCraftBlocks.sculk_block, Blocks.air, true);
                    this.fillWithBlocks(world, structureBoundingBox, this.boundingBox.minX, this.boundingBox.minY + 1, this.boundingBox.minZ, this.boundingBox.maxX, Math.min(this.boundingBox.minY + 3, this.boundingBox.maxY), this.boundingBox.maxZ, Blocks.air, Blocks.air, false);
                    Iterator iterator = this.roomsLinkedToTheRoom.iterator();

                    while (iterator.hasNext())
                    {
                        StructureBoundingBox structureboundingbox1 = (StructureBoundingBox)iterator.next();
                        this.fillWithBlocks(world, structureBoundingBox, structureboundingbox1.minX, structureboundingbox1.maxY - 2, structureboundingbox1.minZ, structureboundingbox1.maxX, structureboundingbox1.maxY, structureboundingbox1.maxZ, Blocks.air, Blocks.air, false);
                    }

                    this.func_151547_a(world, structureBoundingBox, this.boundingBox.minX, this.boundingBox.minY + 4, this.boundingBox.minZ, this.boundingBox.maxX, this.boundingBox.maxY, this.boundingBox.maxZ, Blocks.air, false);
                    return true;
                }
            }

            protected void func_143012_a(NBTTagCompound compound) {
                NBTTagList nbttaglist = new NBTTagList();
                Iterator iterator = this.roomsLinkedToTheRoom.iterator();

                while (iterator.hasNext())
                {
                    StructureBoundingBox structureboundingbox = (StructureBoundingBox)iterator.next();
                    nbttaglist.appendTag(structureboundingbox.func_151535_h());
                }

                compound.setTag("Entrances", nbttaglist);
            }

            protected void func_143011_b(NBTTagCompound compound)
            {
                NBTTagList nbttaglist = compound.getTagList("Entrances", 11);

                for (int i = 0; i < nbttaglist.tagCount(); ++i)
                {
                    this.roomsLinkedToTheRoom.add(new StructureBoundingBox(nbttaglist.func_150306_c(i)));
                }
            }

            protected void offset(int x, int y, int z) {
    			super.getBoundingBox().offset(x, y, z);
    		}
        }

    public static class Stairs extends StructureComponent {

            public Stairs() {}

            public Stairs(int p_i2038_1_, Random random, StructureBoundingBox structureBoundingBox, int p_i2038_4_)
            {
                super(p_i2038_1_);
                this.coordBaseMode = p_i2038_4_;
                this.boundingBox = structureBoundingBox;
            }

            protected void func_143012_a(NBTTagCompound compound) {}

            protected void func_143011_b(NBTTagCompound compound) {}

            public static StructureBoundingBox findValidPlacement(List list, Random random, int p_74950_2_, int p_74950_3_, int p_74950_4_, int p_74950_5_)
            {
                StructureBoundingBox structureboundingbox = new StructureBoundingBox(p_74950_2_, p_74950_3_ - 5, p_74950_4_, p_74950_2_, p_74950_3_ + 2, p_74950_4_);

                switch (p_74950_5_)
                {
                    case 0:
                        structureboundingbox.maxX = p_74950_2_ + 2;
                        structureboundingbox.maxZ = p_74950_4_ + 8;
                        break;
                    case 1:
                        structureboundingbox.minX = p_74950_2_ - 8;
                        structureboundingbox.maxZ = p_74950_4_ + 2;
                        break;
                    case 2:
                        structureboundingbox.maxX = p_74950_2_ + 2;
                        structureboundingbox.minZ = p_74950_4_ - 8;
                        break;
                    case 3:
                        structureboundingbox.maxX = p_74950_2_ + 8;
                        structureboundingbox.maxZ = p_74950_4_ + 2;
                }

                return StructureComponent.findIntersecting(list, structureboundingbox) != null ? null : structureboundingbox;
            }

            public void buildComponent(StructureComponent component, List list, Random random)
            {
                int i = this.getComponentType();

                switch (this.coordBaseMode)
                {
                    case 0:
                        StructureSculkMineshaftPieces.getNextMineShaftComponent(component, list, random, this.boundingBox.minX, this.boundingBox.minY, this.boundingBox.maxZ + 1, 0, i);
                        break;
                    case 1:
                        StructureSculkMineshaftPieces.getNextMineShaftComponent(component, list, random, this.boundingBox.minX - 1, this.boundingBox.minY, this.boundingBox.minZ, 1, i);
                        break;
                    case 2:
                        StructureSculkMineshaftPieces.getNextMineShaftComponent(component, list, random, this.boundingBox.minX, this.boundingBox.minY, this.boundingBox.minZ - 1, 2, i);
                        break;
                    case 3:
                        StructureSculkMineshaftPieces.getNextMineShaftComponent(component, list, random, this.boundingBox.maxX + 1, this.boundingBox.minY, this.boundingBox.minZ, 3, i);
                }
            }

            public boolean addComponentParts(World world, Random random, StructureBoundingBox structureBoundingBox)
            {
                if (this.isLiquidInStructureBoundingBox(world, structureBoundingBox))
                {
                    return false;
                }
                else
                {
                    this.fillWithBlocks(world, structureBoundingBox, 0, 5, 0, 2, 7, 1, Blocks.air, Blocks.air, false);
                    this.fillWithBlocks(world, structureBoundingBox, 0, 0, 7, 2, 2, 8, Blocks.air, Blocks.air, false);

                    for (int i = 0; i < 5; ++i)
                    {
                        this.fillWithBlocks(world, structureBoundingBox, 0, 5 - i - (i < 4 ? 1 : 0), 2 + i, 2, 7 - i, 2 + i, Blocks.air, Blocks.air, false);
                    }

                    return true;
                }
            }
            
            
        }
		
}
