package com.NovaCraftBlocks.plants;

import net.minecraft.world.gen.feature.*;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.world.*;
import java.util.*;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.entity.EntityCreaking;
import com.NovaCraftBlocks.NovaCraftBlocks;

import net.minecraft.init.*;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;

public class LargeLuminantTreeGen extends WorldGenAbstractTree
{
    Block leaves;
    Block fruit;
    int fruitChance;
    int randHeight;
    boolean branches;
    
    public LargeLuminantTreeGen(final Block leafID, final Block fruitMeta, final int fruitChance, final int heightWeight, final boolean branchFlag) {
        super(true);
        this.leaves = leafID;
        this.fruit = fruitMeta;
        this.fruitChance = fruitChance;
        this.randHeight = heightWeight;
        this.branches = branchFlag;
    }
    
    public boolean generate(final World world, final Random random, final int x, final int y, final int z) {
        boolean cangen = true;
        final int height = random.nextInt(this.randHeight) + (this.branches ? 8 : 6);
        for (int x2 = x - 3; x2 < x + 3; ++x2) {
            for (int y2 = y + 1; y2 < y + (height + 2); ++y2) {
                for (int z2 = z - 3; z2 < z + 3; ++z2) {
                    if (world.getBlock(x2, y2, z2) != Blocks.air) {
                        cangen = false;
                    }
                }
            }
        }
        if (y + (height + 4) > world.getHeight() || !cangen) {
            return false;
        }
        final Block y3 = world.getBlock(x, y - 1, z);
        if (y3 != Blocks.grass && y3 != Blocks.dirt && y3 != NovaCraftBlocks.moss_block && y3 != NovaCraftBlocks.rich_etherstone) {
            return false;
        }
        world.setBlock(x, y - 1, z, Blocks.dirt);
        for (int y4 = y; y4 <= y + height; ++y4) {
            world.setBlock(x, y4, z, NovaCraftBlocks.luminant_log);
        }
        this.setBlockAirCheck(world, x, y + (height + 1), z, this.leaves, (random.nextInt(this.fruitChance) == 0) ? this.fruit : Blocks.air);
        this.setBlockAirCheck(world, x, y + (height + 2), z, this.leaves, (random.nextInt(this.fruitChance) == 0) ? this.fruit : Blocks.air);
        for (int y4 = y + 2; y4 <= y + (height + 1); ++y4) {
            this.setBlockAirCheck(world, x + 1, y4, z, this.leaves, (random.nextInt(this.fruitChance) == 0) ? this.fruit : Blocks.air);
            this.setBlockAirCheck(world, x - 1, y4, z, this.leaves, (random.nextInt(this.fruitChance) == 0) ? this.fruit : Blocks.air);
            this.setBlockAirCheck(world, x, y4, z + 1, this.leaves, (random.nextInt(this.fruitChance) == 0) ? this.fruit : Blocks.air);
            this.setBlockAirCheck(world, x, y4, z - 1, this.leaves, (random.nextInt(this.fruitChance) == 0) ? this.fruit : Blocks.air);
        }
        for (int y4 = y + 3; y4 <= y + height; y4 += 2) {
            this.setBlockAirCheck(world, x + 1, y4, z + 1, this.leaves, (random.nextInt(this.fruitChance) == 0) ? this.fruit : Blocks.air);
            this.setBlockAirCheck(world, x - 1, y4, z - 1, this.leaves, (random.nextInt(this.fruitChance) == 0) ? this.fruit : Blocks.air);
            this.setBlockAirCheck(world, x + 1, y4, z - 1, this.leaves, (random.nextInt(this.fruitChance) == 0) ? this.fruit : Blocks.air);
            this.setBlockAirCheck(world, x - 1, y4, z + 1, this.leaves, (random.nextInt(this.fruitChance) == 0) ? this.fruit : Blocks.air);
            this.setBlockAirCheck(world, x + 2, y4, z, this.leaves, (random.nextInt(this.fruitChance) == 0) ? this.fruit : Blocks.air);
            this.setBlockAirCheck(world, x - 2, y4, z, this.leaves, (random.nextInt(this.fruitChance) == 0) ? this.fruit : Blocks.air);
            this.setBlockAirCheck(world, x, y4, z + 2, this.leaves, (random.nextInt(this.fruitChance) == 0) ? this.fruit : Blocks.air);
            this.setBlockAirCheck(world, x, y4, z - 2, this.leaves, (random.nextInt(this.fruitChance) == 0) ? this.fruit : Blocks.air);
        }
        if (this.branches) {
            int side = random.nextInt(3);
            for (int y5 = y + (random.nextInt(2) + 3); y5 <= y + height - 2; y5 += 1 + random.nextInt(3)) {
                final int chance = Math.max(1, Math.max(1, y * (y5 - y)) / y5);
                final int branchLength = random.nextInt(2) + 1;
                switch (side) {
                    case 0: {
                        for (int x3 = x; x3 <= x + branchLength; ++x3) {
                            world.setBlock(x3, y5, z, NovaCraftBlocks.luminant_log);
                            this.setBlockAirCheck(world, x3, y5 + 1, z, this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                            this.setBlockAirCheck(world, x3, y5 - 1, z, this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                            this.setBlockAirCheck(world, x3 + 1, y5, z + 1, this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                            this.setBlockAirCheck(world, x3 - 1, y5, z - 1, this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        }
                        world.setBlock(x + (branchLength + 1), y5 + 1, z, NovaCraftBlocks.luminant_log);
                        world.setBlock(x + (branchLength + 2), y5 + 2, z, NovaCraftBlocks.luminant_log);
                        world.setBlock(x + (branchLength + 2), y5 + 3, z, NovaCraftBlocks.luminant_log);
                        this.setBlockAirCheck(world, x + (branchLength + 1), y5 + 2, z, this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x + (branchLength + 1), y5 + 3, z, this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x + (branchLength + 2), y5 + 4, z, this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x + (branchLength + 3), y5 + 2, z, this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x + (branchLength + 3), y5 + 3, z, this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x + (branchLength + 2), y5 + 2, z - 1, this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x + (branchLength + 2), y5 + 3, z - 1, this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x + (branchLength + 2), y5 + 2, z + 1, this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x + (branchLength + 2), y5 + 3, z + 1, this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x + (branchLength + 1), y5 + 1, z - 1, this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x + (branchLength + 1), y5 + 2, z - 1, this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x + (branchLength + 1), y5 + 1, z + 1, this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x + (branchLength + 1), y5 + 2, z + 1, this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x + branchLength, y5, z - 1, this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x + branchLength, y5 + 1, z - 1, this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x + branchLength, y5, z + 1, this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x + branchLength, y5 + 1, z + 1, this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x + (branchLength - 1), y5, z - 1, this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x + (branchLength - 1), y5, z + 1, this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x + (branchLength - 2), y5 - 1, z, this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x + (branchLength - 1), y5 - 1, z, this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x + branchLength, y5 - 1, z, this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x + (branchLength + 1), y5, z, this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x + (branchLength + 2), y5 + 1, z, this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        break;
                    }
                    case 1: {
                        for (int x4 = x; x4 >= x - branchLength; --x4) {
                            world.setBlock(x4, y5, z, NovaCraftBlocks.luminant_log);
                            this.setBlockAirCheck(world, x4, y5 + 1, z, this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                            this.setBlockAirCheck(world, x4, y5 - 1, z, this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                            this.setBlockAirCheck(world, x4 + 1, y5, z + 1, this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                            this.setBlockAirCheck(world, x4 - 1, y5, z - 1, this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        }
                        world.setBlock(x - (branchLength + 1), y5 + 1, z, NovaCraftBlocks.luminant_log);
                        world.setBlock(x - (branchLength + 2), y5 + 2, z, NovaCraftBlocks.luminant_log);
                        world.setBlock(x - (branchLength + 2), y5 + 3, z, NovaCraftBlocks.luminant_log);
                        this.setBlockAirCheck(world, x - (branchLength + 1), y5 + 2, z, this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x - (branchLength + 1), y5 + 3, z, this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x - (branchLength + 2), y5 + 4, z, this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x - (branchLength + 3), y5 + 2, z, this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x - (branchLength + 3), y5 + 3, z, this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x - (branchLength + 2), y5 + 2, z - 1, this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x - (branchLength + 2), y5 + 3, z - 1, this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x - (branchLength + 2), y5 + 2, z + 1, this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x - (branchLength + 2), y5 + 3, z + 1, this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x - (branchLength + 1), y5 + 1, z - 1, this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x - (branchLength + 1), y5 + 2, z - 1, this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x - (branchLength + 1), y5 + 1, z + 1, this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x - (branchLength + 1), y5 + 2, z + 1, this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x - branchLength, y5, z - 1, this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x - branchLength, y5 + 1, z - 1, this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x - branchLength, y5, z + 1, this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x - branchLength, y5 + 1, z + 1, this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x - (branchLength - 1), y5, z - 1, this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x - (branchLength - 1), y5, z + 1, this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x - (branchLength - 2), y5 - 1, z, this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x - (branchLength - 1), y5 - 1, z, this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x - branchLength, y5 - 1, z, this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x - (branchLength + 1), y5, z, this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x - (branchLength + 2), y5 + 1, z, this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        break;
                    }
                    case 2: {
                        for (int z3 = z; z3 <= z + branchLength; ++z3) {
                            world.setBlock(x, y5, z3, NovaCraftBlocks.luminant_log);
                            this.setBlockAirCheck(world, x, y5 + 1, z3, this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                            this.setBlockAirCheck(world, x, y5 - 1, z3, this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                            this.setBlockAirCheck(world, x + 1, y5, z3, this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                            this.setBlockAirCheck(world, x - 1, y5, z3, this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        }
                        world.setBlock(x, y5 + 1, z + (branchLength + 1), NovaCraftBlocks.luminant_log);
                        world.setBlock(x, y5 + 2, z + (branchLength + 2), NovaCraftBlocks.luminant_log);
                        world.setBlock(x, y5 + 3, z + (branchLength + 2), NovaCraftBlocks.luminant_log);
                        this.setBlockAirCheck(world, x, y5 + 2, z + (branchLength + 1), this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x, y5 + 3, z + (branchLength + 1), this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x, y5 + 4, z + (branchLength + 2), this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x, y5 + 2, z + (branchLength + 3), this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x, y5 + 3, z + (branchLength + 3), this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x - 1, y5 + 2, z + (branchLength + 2), this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x - 1, y5 + 3, z + (branchLength + 2), this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x + 1, y5 + 2, z + (branchLength + 2), this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x + 1, y5 + 3, z + (branchLength + 2), this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x - 1, y5 + 1, z + (branchLength + 1), this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x - 1, y5 + 2, z + (branchLength + 1), this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x + 1, y5 + 1, z + (branchLength + 1), this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x + 1, y5 + 2, z + (branchLength + 1), this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x - 1, y5, z + branchLength, this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x - 1, y5 + 1, z + branchLength, this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x + 1, y5, z + branchLength, this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x + 1, y5 + 1, z + branchLength, this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x - 1, y5, z + (branchLength - 1), this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x + 1, y5, z + (branchLength - 1), this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x, y5 - 1, z + (branchLength - 2), this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x, y5 - 1, z + (branchLength - 1), this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x, y5 - 1, z + branchLength, this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x, y5, z + (branchLength + 1), this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x, y5 + 1, z + (branchLength + 2), this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        break;
                    }
                    case 3: {
                        for (int z4 = z; z4 >= z - branchLength; --z4) {
                            world.setBlock(x, y5, z4, NovaCraftBlocks.luminant_log);
                            this.setBlockAirCheck(world, x, y5 + 1, z4, this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                            this.setBlockAirCheck(world, x, y5 - 1, z4, this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                            this.setBlockAirCheck(world, x + 1, y5, z4, this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                            this.setBlockAirCheck(world, x - 1, y5, z4, this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        }
                        world.setBlock(x, y5 + 1, z - (branchLength + 1), NovaCraftBlocks.luminant_log);
                        world.setBlock(x, y5 + 2, z - (branchLength + 2), NovaCraftBlocks.luminant_log);
                        world.setBlock(x, y5 + 3, z - (branchLength + 2), NovaCraftBlocks.luminant_log);
                        this.setBlockAirCheck(world, x, y5 + 2, z - (branchLength + 1), this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x, y5 + 3, z - (branchLength + 1), this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x, y5 + 4, z - (branchLength + 2), this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x, y5 + 2, z - (branchLength + 3), this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x, y5 + 3, z - (branchLength + 3), this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x - 1, y5 + 2, z - (branchLength + 2), this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x - 1, y5 + 3, z - (branchLength + 2), this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x + 1, y5 + 2, z - (branchLength + 2), this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x + 1, y5 + 3, z - (branchLength + 2), this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x - 1, y5 + 1, z - (branchLength + 1), this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x - 1, y5 + 2, z - (branchLength + 1), this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x + 1, y5 + 1, z - (branchLength + 1), this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x + 1, y5 + 2, z - (branchLength + 1), this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x - 1, y5, z - branchLength, this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x - 1, y5 + 1, z - branchLength, this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x + 1, y5, z - branchLength, this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x + 1, y5 + 1, z - branchLength, this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x - 1, y5, z - (branchLength - 1), this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x + 1, y5, z - (branchLength - 1), this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x, y5 - 1, z - (branchLength - 2), this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x, y5 - 1, z - (branchLength - 1), this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x, y5 - 1, z - branchLength, this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x, y5, z - (branchLength + 1), this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        this.setBlockAirCheck(world, x, y5 + 1, z - (branchLength + 2), this.leaves, (random.nextInt(chance) == 0) ? this.fruit : Blocks.air);
                        break;
                    }
                }
                if (++side > 3) {
                    side = 0;
                }
            }
            
            if (!world.isRemote) {
                final EntityCreaking creaking = new EntityCreaking(world);
                creaking.setLocationAndAngles((double)(x + 2), (double)(y + 2), (double)(z), 0.0f, 0.0f);
                world.spawnEntityInWorld((Entity)creaking);
                creaking.setType(5);
            }
            
            if (!world.isRemote) {
                final EntityCreaking creaking2 = new EntityCreaking(world);
                creaking2.setLocationAndAngles((double)(x - 2), (double)(y + 2), (double)(z), 0.0f, 0.0f);
                world.spawnEntityInWorld((Entity)creaking2);
                creaking2.setType(5);
            }
            
            if (!world.isRemote) {
                final EntityCreaking creaking3 = new EntityCreaking(world);
                creaking3.setLocationAndAngles((double)(x), (double)(y + 2), (double)(z + 2), 0.0f, 0.0f);
                world.spawnEntityInWorld((Entity)creaking3);
                creaking3.setType(5);
            }
            
            if (!world.isRemote) {
                final EntityCreaking creaking4 = new EntityCreaking(world);
                creaking4.setLocationAndAngles((double)(x), (double)(y + 2), (double)(z - 2), 0.0f, 0.0f);
                world.spawnEntityInWorld((Entity)creaking4);
                creaking4.setType(5);
            }
            int rand = (int)(1 + Math.random() * 2);
            if (rand == 2) {
            	world.setBlock(x + 1, y, z, Blocks.chest, 5, 2);
            	TileEntityChest chest = (TileEntityChest) world.getTileEntity(x + 1, y, z);

            	for (int slot = 0; slot < 3 + random.nextInt(25); slot++) {
            		chest.setInventorySlotContents(random.nextInt(chest.getSizeInventory()), this.getTreeLoot(random));
            	}
            }
        }
        return true;
    }
    
    public void setBlockAirCheck(final World world, final int x, final int y, final int z, final Block blockID) {
        if (world.getBlock(x, y, z) == Blocks.air) {
            world.setBlock(x, y, z, blockID);
        }
    }
    
    public void setBlockAirCheck(final World world, final int x, final int y, final int z, final Block blockID, final Block leaveID) {
        if (world.getBlock(x, y, z) == Blocks.air) {
            if (leaveID == Blocks.air) {
                world.setBlock(x, y, z, blockID);
            }
            else {
                world.setBlock(x, y, z, leaveID);
            }
        }
    }
    
    private ItemStack getTreeLoot(Random random) {
		int item = random.nextInt(10);
		switch (item) {
			case 0:
				return new ItemStack(Items.stick, random.nextInt(8) + 7);
			case 1:
				return new ItemStack(NovaCraftItems.luminant_ingot, random.nextInt(2) + 1);
			case 2:
				return new ItemStack(NovaCraftItems.luminant_gel, random.nextInt(5) + 7);
			case 3:
				return new ItemStack(NovaCraftItems.luminant_apple, random.nextInt(1) + 1);
			case 4:
				return new ItemStack(NovaCraftItems.luminant_tree_sap, random.nextInt(7) + 6);
			case 5:
				return new ItemStack(NovaCraftBlocks.luminant_sapling, random.nextInt(3) + 1);
			case 6:
				return new ItemStack(NovaCraftBlocks.luminant_log, random.nextInt(3) + 2);
			default:
				return new ItemStack(NovaCraftBlocks.luminant_log, random.nextInt(3) + 2);
		}
	}
}
