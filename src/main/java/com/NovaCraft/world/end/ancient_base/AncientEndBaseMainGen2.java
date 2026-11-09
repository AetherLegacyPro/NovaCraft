package com.NovaCraft.world.end.ancient_base;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.config.Configs;
import com.NovaCraft.config.ConfigsCompact;
import com.NovaCraft.entity.EntityFrontierGolem;
import com.NovaCraftBlocks.NovaCraftBlocks;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import java.util.Random;

public class AncientEndBaseMainGen2 extends WorldGenerator {

    public AncientEndBaseMainGen2() {
    }

    private Block PlaceEndstoneBricks;
    private Block PlaceEndstoneBrickWall;
    private Block PlaceEndstoneBrickStairs;
    private Block PlacePurpurPillar;
    private Block PlaceChorusFlower;
    private Block PlacePurpurBrickStairs;

    private Block determineIfEndstoneBricksExists(World world, int x, int y, int z) {
        Block existingBlock = world.getBlock(x, y, z);
        if (ConfigsCompact.enableEndstoneBricks && Loader.isModLoaded("etfuturum")) {
            try {
                Block end_bricks = GameRegistry.findBlock("etfuturum", "end_bricks");
                if (end_bricks != null && (existingBlock == null || existingBlock != end_bricks)) {
                    return end_bricks;
                }
            } catch (Exception ex) {
                if (Configs.enableDebugMode) {
                    System.out.println("Missing Endstone Bricks from Et Futurum Requiem, using Frontierslate Bricks instead...");
                }
                return NovaCraftBlocks.frontierslate_bricks;
            }
        }

        return NovaCraftBlocks.frontierslate_bricks;
    }

    private Block determineIfEndstoneBrickWallExists(World world, int x, int y, int z) {
        Block existingBlock = world.getBlock(x, y, z);
        if (ConfigsCompact.enableEndstoneBricks && Loader.isModLoaded("etfuturum")) {
            try {
                Block end_brick_wall = GameRegistry.findBlock("etfuturum", "end_brick_wall");
                if (end_brick_wall != null && (existingBlock == null || existingBlock != end_brick_wall)) {
                    return end_brick_wall;
                }
            } catch (Exception ex) {
                if (Configs.enableDebugMode) {
                    System.out.println("Missing Endstone Brick Wall from Et Futurum Requiem, using Frontierslate Brick Wall instead...");
                }
                return NovaCraftBlocks.frontierslate_brick_wall;
            }
        }

        return NovaCraftBlocks.frontierslate_brick_wall;
    }

    private Block determineIfEndstoneBrickStairsExists(World world, int x, int y, int z) {
        Block existingBlock = world.getBlock(x, y, z);
        if (ConfigsCompact.enableEndstoneBricks && Loader.isModLoaded("etfuturum")) {
            try {
                Block end_brick_stairs = GameRegistry.findBlock("etfuturum", "end_brick_stairs");
                if (end_brick_stairs != null && (existingBlock == null || existingBlock != end_brick_stairs)) {
                    return end_brick_stairs;
                }
            } catch (Exception ex) {
                if (Configs.enableDebugMode) {
                    System.out.println("Missing Endstone Brick Stairs from Et Futurum Requiem, using Frontierslate Brick Stairs instead...");
                }
                return NovaCraftBlocks.frontierslate_brick_stairs;
            }
        }

        return NovaCraftBlocks.frontierslate_brick_stairs;
    }

    private Block determineIfChorusFlowerExists(World world, int x, int y, int z) {
        Block existingBlock = world.getBlock(x, y, z);
        if (ConfigsCompact.enableChorusFlower && Loader.isModLoaded("etfuturum")) {
            try {
                Block chorus_flower = GameRegistry.findBlock("etfuturum", "chorus_flower");
                if (chorus_flower != null && (existingBlock == null || existingBlock != chorus_flower)) {
                    return chorus_flower;
                }
            } catch (Exception ex) {
                if (Configs.enableDebugMode) {
                    System.out.println("Missing Endstone Brick Stairs from Et Futurum Requiem, using Frontierslate Brick Stairs instead...");
                }
                return NovaCraftBlocks.shadow_bloom;
            }
        }

        return NovaCraftBlocks.shadow_bloom;
    }

    private Block determineIfPurpurPillarExists(World world, int x, int y, int z) {
        Block existingBlock = world.getBlock(x, y, z);
        if (ConfigsCompact.enablePurpur && Loader.isModLoaded("etfuturum")) {
            try {
                Block purpur_pillar = GameRegistry.findBlock("etfuturum", "purpur_pillar");
                if (purpur_pillar != null && (existingBlock == null || existingBlock != purpur_pillar)) {
                    return purpur_pillar;
                }
            } catch (Exception ex) {
                if (Configs.enableDebugMode) {
                    System.out.println("Missing Endstone Brick Stairs from Et Futurum Requiem, using Frontierslate Brick Stairs instead...");
                }
                return NovaCraftBlocks.polished_vanite_bricks;
            }
        }

        return NovaCraftBlocks.polished_vanite_bricks;
    }

    private Block determineIfPurpurBrickStairsExists(World world, int x, int y, int z) {
        Block existingBlock = world.getBlock(x, y, z);
        if (ConfigsCompact.enablePurpur && Loader.isModLoaded("etfuturum")) {
            try {
                Block purpur_stairs = GameRegistry.findBlock("etfuturum", "purpur_stairs");
                if (purpur_stairs != null && (existingBlock == null || existingBlock != purpur_stairs)) {
                    return purpur_stairs;
                }
            } catch (Exception ex) {
                if (Configs.enableDebugMode) {
                    System.out.println("Missing Endstone Brick Stairs from Et Futurum Requiem, using Frontierslate Brick Stairs instead...");
                }
                return NovaCraftBlocks.frontierslate_brick_stairs;
            }
        }

        return NovaCraftBlocks.frontierslate_brick_stairs;
    }

    public boolean generate(final World world, final Random random, final int i, final int j, final int k) {
        PlaceEndstoneBricks = determineIfEndstoneBricksExists(world, i + 26, j + 4, k + 47);
        PlaceEndstoneBrickWall = determineIfEndstoneBrickWallExists(world, i + 30, j + 5, k);
        PlaceEndstoneBrickStairs = determineIfEndstoneBrickStairsExists(world, i + 27, j + 5, k + 1);
        PlacePurpurPillar = determineIfPurpurPillarExists(world, i + 29, j + 5, k + 20);
        PlaceChorusFlower = determineIfChorusFlowerExists(world, i + 38, j + 6, k + 35);
        PlacePurpurBrickStairs = determineIfPurpurBrickStairsExists(world, i + 27, j + 9, k + 20);

        world.setBlock(i + 40, j + 4, k + 46, Blocks.end_stone, 0, 2);
        world.setBlock(i + 41, j + 4, k + 46, Blocks.obsidian, 0, 2);
        world.setBlock(i + 24, j + 4, k + 47, Blocks.obsidian, 0, 2);
        world.setBlock(i + 25, j + 4, k + 47, Blocks.end_stone, 0, 2);
        world.setBlock(i + 26, j + 4, k + 47, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 27, j + 4, k + 47, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 28, j + 4, k + 47, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 29, j + 4, k + 47, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 30, j + 4, k + 47, Blocks.end_stone, 0, 2);
        world.setBlock(i + 31, j + 4, k + 47, Blocks.obsidian, 0, 2);
        world.setBlock(i + 33, j + 4, k + 47, Blocks.obsidian, 0, 2);
        world.setBlock(i + 34, j + 4, k + 47, Blocks.end_stone, 0, 2);
        world.setBlock(i + 35, j + 4, k + 47, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 36, j + 4, k + 47, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 37, j + 4, k + 47, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 38, j + 4, k + 47, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 39, j + 4, k + 47, Blocks.end_stone, 0, 2);
        world.setBlock(i + 40, j + 4, k + 47, Blocks.obsidian, 0, 2);
        world.setBlock(i + 25, j + 4, k + 48, Blocks.obsidian, 0, 2);
        world.setBlock(i + 26, j + 4, k + 48, Blocks.end_stone, 0, 2);
        world.setBlock(i + 27, j + 4, k + 48, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 28, j + 4, k + 48, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 29, j + 4, k + 48, Blocks.end_stone, 0, 2);
        world.setBlock(i + 30, j + 4, k + 48, Blocks.obsidian, 0, 2);
        world.setBlock(i + 34, j + 4, k + 48, Blocks.obsidian, 0, 2);
        world.setBlock(i + 35, j + 4, k + 48, Blocks.end_stone, 0, 2);
        world.setBlock(i + 36, j + 4, k + 48, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 37, j + 4, k + 48, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 38, j + 4, k + 48, Blocks.end_stone, 0, 2);
        world.setBlock(i + 39, j + 4, k + 48, Blocks.obsidian, 0, 2);
        world.setBlock(i + 26, j + 4, k + 49, Blocks.obsidian, 0, 2);
        world.setBlock(i + 27, j + 4, k + 49, Blocks.end_stone, 0, 2);
        world.setBlock(i + 28, j + 4, k + 49, Blocks.end_stone, 0, 2);
        world.setBlock(i + 29, j + 4, k + 49, Blocks.obsidian, 0, 2);
        world.setBlock(i + 35, j + 4, k + 49, Blocks.obsidian, 0, 2);
        world.setBlock(i + 36, j + 4, k + 49, Blocks.end_stone, 0, 2);
        world.setBlock(i + 37, j + 4, k + 49, Blocks.end_stone, 0, 2);
        world.setBlock(i + 38, j + 4, k + 49, Blocks.obsidian, 0, 2);
        world.setBlock(i + 27, j + 4, k + 50, Blocks.obsidian, 0, 2);
        world.setBlock(i + 28, j + 4, k + 50, Blocks.obsidian, 0, 2);
        world.setBlock(i + 36, j + 4, k + 50, Blocks.obsidian, 0, 2);
        world.setBlock(i + 37, j + 4, k + 50, Blocks.obsidian, 0, 2);
        world.setBlock(i + 30, j + 5, k, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 27, j + 5, k + 1, placeEndStoneBrickStairs(random), 3, 2);
        world.setBlock(i + 30, j + 5, k + 2, placeEndStoneBrickStairs(random), 0, 2);
        world.setBlock(i + 29, j + 5, k + 5, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 13, j + 5, k + 7, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 19, j + 5, k + 7, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 44, j + 5, k + 8, Blocks.end_stone, 0, 2);
        world.setBlock(i + 45, j + 5, k + 8, Blocks.end_stone, 0, 2);
        world.setBlock(i + 46, j + 5, k + 8, Blocks.end_stone, 0, 2);
        world.setBlock(i + 47, j + 5, k + 8, Blocks.end_stone, 0, 2);
        world.setBlock(i + 48, j + 5, k + 8, Blocks.end_stone, 0, 2);
        world.setBlock(i + 43, j + 5, k + 9, Blocks.end_stone, 0, 2);
        world.setBlock(i + 46, j + 5, k + 9, Blocks.carpet, 10, 2);
        world.setBlock(i + 47, j + 5, k + 9, Blocks.carpet, 10, 2);
        world.setBlock(i + 48, j + 5, k + 9, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 49, j + 5, k + 9, Blocks.end_stone, 0, 2);
        world.setBlock(i + 42, j + 5, k + 10, Blocks.end_stone, 0, 2);
        world.setBlock(i + 46, j + 5, k + 10, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 47, j + 5, k + 10, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 49, j + 5, k + 10, Blocks.ladder, 4, 2);
        world.setBlock(i + 50, j + 5, k + 10, Blocks.end_stone, 0, 2);
        world.setBlock(i + 23, j + 5, k + 11, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 41, j + 5, k + 11, Blocks.end_stone, 0, 2);
        world.setBlock(i + 42, j + 5, k + 11, Blocks.packed_ice, 0, 2);
        world.setBlock(i + 43, j + 5, k + 11, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 49, j + 5, k + 11, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 50, j + 5, k + 11, Blocks.carpet, 10, 2);
        world.setBlock(i + 51, j + 5, k + 11, Blocks.end_stone, 0, 2);
        world.setBlock(i + 15, j + 5, k + 12, placeEndStoneBrickStairs(random), 1, 2);
        world.setBlock(i + 23, j + 5, k + 12, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 41, j + 5, k + 12, Blocks.end_stone, 0, 2);
        world.setBlock(i + 42, j + 5, k + 12, Blocks.packed_ice, 0, 2);
        world.setBlock(i + 43, j + 5, k + 12, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 49, j + 5, k + 12, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 50, j + 5, k + 12, Blocks.carpet, 10, 2);
        world.setBlock(i + 51, j + 5, k + 12, Blocks.end_stone, 0, 2);
        world.setBlock(i + 13, j + 5, k + 13, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 23, j + 5, k + 13, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 41, j + 5, k + 13, Blocks.end_stone, 0, 2);
        world.setBlock(i + 42, j + 5, k + 13, Blocks.packed_ice, 0, 2);
        world.setBlock(i + 43, j + 5, k + 13, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 51, j + 5, k + 13, Blocks.end_stone, 0, 2);
        world.setBlock(i + 23, j + 5, k + 14, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 41, j + 5, k + 14, Blocks.end_stone, 0, 2);
        world.setBlock(i + 42, j + 5, k + 14, Blocks.packed_ice, 0, 2);
        world.setBlock(i + 43, j + 5, k + 14, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 49, j + 5, k + 14, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 50, j + 5, k + 14, Blocks.carpet, 10, 2);
        world.setBlock(i + 51, j + 5, k + 14, Blocks.end_stone, 0, 2);
        world.setBlock(i + 23, j + 5, k + 15, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 41, j + 5, k + 15, Blocks.end_stone, 0, 2);
        world.setBlock(i + 42, j + 5, k + 15, Blocks.packed_ice, 0, 2);
        world.setBlock(i + 43, j + 5, k + 15, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 49, j + 5, k + 15, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 50, j + 5, k + 15, Blocks.carpet, 10, 2);
        world.setBlock(i + 51, j + 5, k + 15, Blocks.end_stone, 0, 2);
        world.setBlock(i + 20, j + 5, k + 16, placeEndStoneBrickStairs(random), 2, 2);
        world.setBlock(i + 41, j + 5, k + 16, Blocks.end_stone, 0, 2);
        world.setBlock(i + 42, j + 5, k + 16, Blocks.end_stone, 0, 2);
        world.setBlock(i + 43, j + 5, k + 16, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 45, j + 5, k + 16, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 46, j + 5, k + 16, Blocks.carpet, 10, 2);
        world.setBlock(i + 47, j + 5, k + 16, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 48, j + 5, k + 16, Blocks.carpet, 10, 2);
        world.setBlock(i + 49, j + 5, k + 16, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 50, j + 5, k + 16, Blocks.end_stone, 0, 2);
        world.setBlock(i + 17, j + 5, k + 17, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 21, j + 5, k + 17, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 38, j + 5, k + 17, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 42, j + 5, k + 17, Blocks.iron_door, 0, 2);
        world.setBlock(i + 45, j + 5, k + 17, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 46, j + 5, k + 17, Blocks.carpet, 10, 2);
        world.setBlock(i + 47, j + 5, k + 17, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 48, j + 5, k + 17, Blocks.carpet, 10, 2);
        world.setBlock(i + 49, j + 5, k + 17, Blocks.end_stone, 0, 2);
        world.setBlock(i + 37, j + 5, k + 18, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 42, j + 5, k + 18, Blocks.end_stone, 0, 2);
        world.setBlock(i + 43, j + 5, k + 18, Blocks.end_stone, 0, 2);
        world.setBlock(i + 44, j + 5, k + 18, Blocks.end_stone, 0, 2);
        world.setBlock(i + 45, j + 5, k + 18, Blocks.end_stone, 0, 2);
        world.setBlock(i + 46, j + 5, k + 18, Blocks.end_stone, 0, 2);
        world.setBlock(i + 47, j + 5, k + 18, Blocks.end_stone, 0, 2);
        world.setBlock(i + 48, j + 5, k + 18, Blocks.end_stone, 0, 2);
        world.setBlock(i + 36, j + 5, k + 19, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 29, j + 5, k + 20, PlacePurpurPillar, 0, 2);
        world.setBlock(i + 35, j + 5, k + 20, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 41, j + 5, k + 20, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 42, j + 5, k + 20, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 43, j + 5, k + 20, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 4, j + 5, k + 21, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 5, j + 5, k + 21, placeEndStoneBrickStairs(random), 1, 2);
        world.setBlock(i + 11, j + 5, k + 21, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 32, j + 5, k + 21, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 30, j + 5, k + 22, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 34, j + 5, k + 22, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 9, j + 5, k + 23, placeEndStoneBrickStairs(random), 2, 2);
        world.setBlock(i + 26, j + 5, k + 23, PlacePurpurPillar, 0, 2);
        world.setBlock(i + 8, j + 5, k + 24, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 28, j + 5, k + 24, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 29, j + 5, k + 24, placeEndStoneBrickStairs(random), 1, 2);
        world.setBlock(i + 31, j + 5, k + 24, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 18, j + 5, k + 25, placeEndStoneBrickStairs(random), 3, 2);
        world.setBlock(i + 36, j + 5, k + 25, placeEndStoneBrickStairs(random), 0, 2);
        world.setBlock(i + 27, j + 5, k + 26, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 28, j + 5, k + 26, placeEndStoneBrickStairs(random), 1, 2);
        world.setBlock(i + 36, j + 5, k + 26, placeEndStoneBrickStairs(random), 0, 2);
        world.setBlock(i + 37, j + 5, k + 26, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 30, j + 5, k + 27, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 28, j + 5, k + 28, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 32, j + 5, k + 28, placeEndStoneBrickStairs(random), 2, 2);
        world.setBlock(i + 36, j + 5, k + 28, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 15, j + 5, k + 29, placeEndStoneBrickStairs(random), 2, 2);
        world.setBlock(i + 37, j + 5, k + 29, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 26, j + 5, k + 30, PlacePurpurPillar, 0, 2);
        world.setBlock(i + 30, j + 5, k + 30, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 38, j + 5, k + 30, PlacePurpurPillar, 0, 2);
        world.setBlock(i + 32, j + 5, k + 31, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 28, j + 5, k + 32, PlacePurpurPillar, 0, 2);
        world.setBlock(i + 30, j + 5, k + 32, Blocks.end_stone, 0, 2);
        world.setBlock(i + 34, j + 5, k + 32, Blocks.end_stone, 0, 2);
        world.setBlock(i + 35, j + 5, k + 32, Blocks.end_stone, 0, 2);
        world.setBlock(i + 36, j + 5, k + 32, PlacePurpurPillar, 0, 2);
        world.setBlock(i + 28, j + 5, k + 33, Blocks.end_stone, 0, 2);
        world.setBlock(i + 29, j + 5, k + 33, Blocks.end_stone, 0, 2);
        world.setBlock(i + 30, j + 5, k + 33, Blocks.end_stone, 0, 2);
        world.setBlock(i + 31, j + 5, k + 33, Blocks.end_stone, 0, 2);
        world.setBlock(i + 32, j + 5, k + 33, Blocks.end_stone, 0, 2);
        world.setBlock(i + 33, j + 5, k + 33, Blocks.end_stone, 0, 2);
        world.setBlock(i + 34, j + 5, k + 33, Blocks.end_stone, 0, 2);
        world.setBlock(i + 35, j + 5, k + 33, Blocks.end_stone, 0, 2);
        world.setBlock(i + 36, j + 5, k + 33, Blocks.end_stone, 0, 2);
        world.setBlock(i + 41, j + 5, k + 33, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 27, j + 5, k + 34, Blocks.end_stone, 0, 2);
        world.setBlock(i + 28, j + 5, k + 34, Blocks.end_stone, 0, 2);
        world.setBlock(i + 29, j + 5, k + 34, Blocks.end_stone, 0, 2);
        world.setBlock(i + 30, j + 5, k + 34, Blocks.end_stone, 0, 2);
        world.setBlock(i + 31, j + 5, k + 34, Blocks.end_stone, 0, 2);
        world.setBlock(i + 32, j + 5, k + 34, Blocks.end_stone, 0, 2);
        world.setBlock(i + 33, j + 5, k + 34, Blocks.end_stone, 0, 2);
        world.setBlock(i + 34, j + 5, k + 34, Blocks.end_stone, 0, 2);
        world.setBlock(i + 35, j + 5, k + 34, Blocks.end_stone, 0, 2);
        world.setBlock(i + 36, j + 5, k + 34, Blocks.end_stone, 0, 2);
        world.setBlock(i + 37, j + 5, k + 34, Blocks.end_stone, 0, 2);
        world.setBlock(i + 42, j + 5, k + 34, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 26, j + 5, k + 35, Blocks.end_stone, 0, 2);
        world.setBlock(i + 27, j + 5, k + 35, Blocks.end_stone, 0, 2);
        world.setBlock(i + 28, j + 5, k + 35, Blocks.end_stone, 0, 2);
        world.setBlock(i + 29, j + 5, k + 35, Blocks.end_stone, 0, 2);
        world.setBlock(i + 30, j + 5, k + 35, Blocks.end_stone, 0, 2);
        world.setBlock(i + 31, j + 5, k + 35, Blocks.end_stone, 0, 2);
        world.setBlock(i + 32, j + 5, k + 35, Blocks.end_stone, 0, 2);
        world.setBlock(i + 33, j + 5, k + 35, Blocks.end_stone, 0, 2);
        world.setBlock(i + 34, j + 5, k + 35, Blocks.end_stone, 0, 2);
        world.setBlock(i + 35, j + 5, k + 35, Blocks.end_stone, 0, 2);
        world.setBlock(i + 36, j + 5, k + 35, Blocks.end_stone, 0, 2);
        world.setBlock(i + 37, j + 5, k + 35, Blocks.end_stone, 0, 2);
        world.setBlock(i + 38, j + 5, k + 35, Blocks.end_stone, 0, 2);
        world.setBlock(i + 43, j + 5, k + 35, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 5, j + 5, k + 36, Blocks.end_stone, 0, 2);
        world.setBlock(i + 6, j + 5, k + 36, Blocks.end_stone, 0, 2);
        world.setBlock(i + 7, j + 5, k + 36, Blocks.end_stone, 0, 2);
        world.setBlock(i + 8, j + 5, k + 36, Blocks.end_stone, 0, 2);
        world.setBlock(i + 25, j + 5, k + 36, Blocks.end_stone, 0, 2);
        world.setBlock(i + 26, j + 5, k + 36, Blocks.end_stone, 0, 2);
        world.setBlock(i + 27, j + 5, k + 36, Blocks.end_stone, 0, 2);
        world.setBlock(i + 28, j + 5, k + 36, Blocks.end_stone, 0, 2);
        world.setBlock(i + 29, j + 5, k + 36, Blocks.end_stone, 0, 2);
        world.setBlock(i + 30, j + 5, k + 36, Blocks.end_stone, 0, 2);
        world.setBlock(i + 31, j + 5, k + 36, Blocks.end_stone, 0, 2);
        world.setBlock(i + 32, j + 5, k + 36, Blocks.end_stone, 0, 2);
        world.setBlock(i + 33, j + 5, k + 36, Blocks.end_stone, 0, 2);
        world.setBlock(i + 34, j + 5, k + 36, Blocks.end_stone, 0, 2);
        world.setBlock(i + 35, j + 5, k + 36, Blocks.end_stone, 0, 2);
        world.setBlock(i + 36, j + 5, k + 36, Blocks.end_stone, 0, 2);
        world.setBlock(i + 37, j + 5, k + 36, Blocks.end_stone, 0, 2);
        world.setBlock(i + 38, j + 5, k + 36, Blocks.end_stone, 0, 2);
        world.setBlock(i + 39, j + 5, k + 36, Blocks.end_stone, 0, 2);
        world.setBlock(i + 4, j + 5, k + 37, Blocks.end_stone, 0, 2);
        world.setBlock(i + 9, j + 5, k + 37, Blocks.end_stone, 0, 2);
        world.setBlock(i + 26, j + 5, k + 37, Blocks.end_stone, 0, 2);
        world.setBlock(i + 27, j + 5, k + 37, Blocks.end_stone, 0, 2);
        world.setBlock(i + 28, j + 5, k + 37, Blocks.end_stone, 0, 2);
        world.setBlock(i + 29, j + 5, k + 37, Blocks.end_stone, 0, 2);
        world.setBlock(i + 30, j + 5, k + 37, Blocks.end_stone, 0, 2);
        world.setBlock(i + 31, j + 5, k + 37, Blocks.end_stone, 0, 2);
        world.setBlock(i + 32, j + 5, k + 37, Blocks.end_stone, 0, 2);
        world.setBlock(i + 33, j + 5, k + 37, Blocks.end_stone, 0, 2);
        world.setBlock(i + 34, j + 5, k + 37, Blocks.end_stone, 0, 2);
        world.setBlock(i + 35, j + 5, k + 37, Blocks.end_stone, 0, 2);
        world.setBlock(i + 36, j + 5, k + 37, Blocks.end_stone, 0, 2);
        world.setBlock(i + 37, j + 5, k + 37, Blocks.end_stone, 0, 2);
        world.setBlock(i + 38, j + 5, k + 37, Blocks.end_stone, 0, 2);
        world.setBlock(i + 43, j + 5, k + 37, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 3, j + 5, k + 38, Blocks.end_stone, 0, 2);
        world.setBlock(i + 10, j + 5, k + 38, Blocks.end_stone, 0, 2);
        world.setBlock(i + 14, j + 5, k + 38, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 15, j + 5, k + 38, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 16, j + 5, k + 38, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 17, j + 5, k + 38, PlacePurpurPillar, 0, 2);
        world.setBlock(i + 18, j + 5, k + 38, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 19, j + 5, k + 38, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 21, j + 5, k + 38, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 27, j + 5, k + 38, Blocks.end_stone, 0, 2);
        world.setBlock(i + 28, j + 5, k + 38, Blocks.end_stone, 0, 2);
        world.setBlock(i + 29, j + 5, k + 38, Blocks.end_stone, 0, 2);
        world.setBlock(i + 30, j + 5, k + 38, Blocks.end_stone, 0, 2);
        world.setBlock(i + 31, j + 5, k + 38, Blocks.end_stone, 0, 2);
        world.setBlock(i + 32, j + 5, k + 38, Blocks.end_stone, 0, 2);
        world.setBlock(i + 33, j + 5, k + 38, Blocks.end_stone, 0, 2);
        world.setBlock(i + 34, j + 5, k + 38, Blocks.end_stone, 0, 2);
        world.setBlock(i + 35, j + 5, k + 38, Blocks.end_stone, 0, 2);
        world.setBlock(i + 36, j + 5, k + 38, Blocks.end_stone, 0, 2);
        world.setBlock(i + 37, j + 5, k + 38, Blocks.end_stone, 0, 2);
        world.setBlock(i + 3, j + 5, k + 39, Blocks.end_stone, 0, 2);
        world.setBlock(i + 10, j + 5, k + 39, Blocks.end_stone, 0, 2);
        world.setBlock(i + 28, j + 5, k + 39, Blocks.end_stone, 0, 2);
        world.setBlock(i + 29, j + 5, k + 39, Blocks.end_stone, 0, 2);
        world.setBlock(i + 30, j + 5, k + 39, Blocks.end_stone, 0, 2);
        world.setBlock(i + 31, j + 5, k + 39, Blocks.end_stone, 0, 2);
        world.setBlock(i + 32, j + 5, k + 39, Blocks.end_stone, 0, 2);
        world.setBlock(i + 33, j + 5, k + 39, Blocks.end_stone, 0, 2);
        world.setBlock(i + 34, j + 5, k + 39, Blocks.end_stone, 0, 2);
        world.setBlock(i + 35, j + 5, k + 39, Blocks.end_stone, 0, 2);
        world.setBlock(i + 36, j + 5, k + 39, Blocks.end_stone, 0, 2);
        world.setBlock(i + 38, j + 5, k + 39, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 3, j + 5, k + 40, Blocks.end_stone, 0, 2);
        world.setBlock(i + 10, j + 5, k + 40, Blocks.iron_door, 2, 2);
        world.setBlock(i + 26, j + 5, k + 40, placeEndStoneBrickStairs(random), 0, 2);
        world.setBlock(i + 29, j + 5, k + 40, Blocks.end_stone, 0, 2);
        world.setBlock(i + 30, j + 5, k + 40, Blocks.end_stone, 0, 2);
        world.setBlock(i + 31, j + 5, k + 40, Blocks.end_stone, 0, 2);
        world.setBlock(i + 32, j + 5, k + 40, Blocks.end_stone, 0, 2);
        world.setBlock(i + 33, j + 5, k + 40, Blocks.end_stone, 0, 2);
        world.setBlock(i + 34, j + 5, k + 40, Blocks.end_stone, 0, 2);
        world.setBlock(i + 35, j + 5, k + 40, Blocks.end_stone, 0, 2);
        world.setBlock(i + 44, j + 5, k + 40, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 3, j + 5, k + 41, Blocks.end_stone, 0, 2);
        world.setBlock(i + 10, j + 5, k + 41, Blocks.end_stone, 0, 2);
        world.setBlock(i + 30, j + 5, k + 41, Blocks.end_stone, 0, 2);
        world.setBlock(i + 31, j + 5, k + 41, Blocks.end_stone, 0, 2);
        world.setBlock(i + 32, j + 5, k + 41, Blocks.end_stone, 0, 2);
        world.setBlock(i + 33, j + 5, k + 41, Blocks.end_stone, 0, 2);
        world.setBlock(i + 34, j + 5, k + 41, Blocks.end_stone, 0, 2);
        world.setBlock(i + 42, j + 5, k + 41, placeEndStoneBrickStairs(random), 0, 2);
        world.setBlock(i + 44, j + 5, k + 41, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 3, j + 5, k + 42, Blocks.end_stone, 0, 2);
        world.setBlock(i + 10, j + 5, k + 42, Blocks.end_stone, 0, 2);
        world.setBlock(i + 14, j + 5, k + 42, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 15, j + 5, k + 42, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 16, j + 5, k + 42, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 17, j + 5, k + 42, PlacePurpurPillar, 0, 2);
        world.setBlock(i + 21, j + 5, k + 42, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 36, j + 5, k + 42, placeEndStoneBrickStairs(random), 1, 2);
        world.setBlock(i + 44, j + 5, k + 42, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 4, j + 5, k + 43, Blocks.end_stone, 0, 2);
        world.setBlock(i + 9, j + 5, k + 43, Blocks.end_stone, 0, 2);
        world.setBlock(i + 29, j + 5, k + 43, placeEndStoneBrickStairs(random), 0, 2);
        world.setBlock(i + 44, j + 5, k + 43, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 5, j + 5, k + 44, Blocks.end_stone, 0, 2);
        world.setBlock(i + 6, j + 5, k + 44, Blocks.end_stone, 0, 2);
        world.setBlock(i + 7, j + 5, k + 44, Blocks.end_stone, 0, 2);
        world.setBlock(i + 8, j + 5, k + 44, Blocks.end_stone, 0, 2);
        world.setBlock(i + 21, j + 5, k + 44, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 42, j + 5, k + 44, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 22, j + 5, k + 45, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 30, j + 5, k + 45, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 40, j + 5, k + 45, placeEndStoneBrickStairs(random), 2, 2);
        world.setBlock(i + 23, j + 5, k + 46, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 25, j + 5, k + 46, placeEndStoneBrickStairs(random), 2, 2);
        world.setBlock(i + 34, j + 5, k + 46, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 26, j + 5, k + 47, placeEndStoneBrickStairs(random), 2, 2);
        world.setBlock(i + 39, j + 5, k + 47, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 36, j + 5, k + 48, placeEndStoneBrickStairs(random), 2, 2);
        world.setBlock(i + 37, j + 5, k + 48, placeEndStoneBrickStairs(random), 2, 2);
        world.setBlock(i + 30, j + 6, k, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 29, j + 6, k + 5, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 13, j + 6, k + 7, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 19, j + 6, k + 7, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 44, j + 6, k + 8, Blocks.end_stone, 0, 2);
        world.setBlock(i + 45, j + 6, k + 8, Blocks.end_stone, 0, 2);
        world.setBlock(i + 46, j + 6, k + 8, Blocks.end_stone, 0, 2);
        world.setBlock(i + 47, j + 6, k + 8, Blocks.end_stone, 0, 2);
        world.setBlock(i + 48, j + 6, k + 8, Blocks.end_stone, 0, 2);
        world.setBlock(i + 43, j + 6, k + 9, Blocks.end_stone, 0, 2);
        world.setBlock(i + 48, j + 6, k + 9, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 49, j + 6, k + 9, Blocks.end_stone, 0, 2);
        world.setBlock(i + 42, j + 6, k + 10, Blocks.end_stone, 0, 2);
        world.setBlock(i + 46, j + 6, k + 10, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 47, j + 6, k + 10, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 49, j + 6, k + 10, Blocks.ladder, 4, 2);
        world.setBlock(i + 50, j + 6, k + 10, Blocks.end_stone, 0, 2);
        world.setBlock(i + 23, j + 6, k + 11, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 41, j + 6, k + 11, Blocks.end_stone, 0, 2);
        world.setBlock(i + 49, j + 6, k + 11, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 51, j + 6, k + 11, Blocks.end_stone, 0, 2);
        world.setBlock(i + 41, j + 6, k + 12, Blocks.end_stone, 0, 2);
        world.setBlock(i + 49, j + 6, k + 12, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 51, j + 6, k + 12, Blocks.end_stone, 0, 2);
        world.setBlock(i + 13, j + 6, k + 13, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 41, j + 6, k + 13, Blocks.end_stone, 0, 2);
        world.setBlock(i + 51, j + 6, k + 13, Blocks.end_stone, 0, 2);
        world.setBlock(i + 41, j + 6, k + 14, Blocks.end_stone, 0, 2);
        world.setBlock(i + 49, j + 6, k + 14, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 51, j + 6, k + 14, Blocks.end_stone, 0, 2);
        world.setBlock(i + 23, j + 6, k + 15, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 41, j + 6, k + 15, Blocks.end_stone, 0, 2);
        world.setBlock(i + 49, j + 6, k + 15, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 51, j + 6, k + 15, Blocks.end_stone, 0, 2);
        world.setBlock(i + 41, j + 6, k + 16, Blocks.end_stone, 0, 2);
        world.setBlock(i + 42, j + 6, k + 16, Blocks.end_stone, 0, 2);
        world.setBlock(i + 43, j + 6, k + 16, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 45, j + 6, k + 16, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 47, j + 6, k + 16, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 49, j + 6, k + 16, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 50, j + 6, k + 16, Blocks.end_stone, 0, 2);
        world.setBlock(i + 21, j + 6, k + 17, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 38, j + 6, k + 17, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 42, j + 6, k + 17, Blocks.iron_door, 8, 2);
        world.setBlock(i + 43, j + 6, k + 17, Blocks.stone_button, 3, 2);
        world.setBlock(i + 45, j + 6, k + 17, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 47, j + 6, k + 17, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 49, j + 6, k + 17, Blocks.end_stone, 0, 2);
        world.setBlock(i + 37, j + 6, k + 18, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 41, j + 6, k + 18, Blocks.stone_button, 2, 2);
        world.setBlock(i + 42, j + 6, k + 18, Blocks.end_stone, 0, 2);
        world.setBlock(i + 43, j + 6, k + 18, Blocks.end_stone, 0, 2);
        world.setBlock(i + 44, j + 6, k + 18, Blocks.end_stone, 0, 2);
        world.setBlock(i + 45, j + 6, k + 18, Blocks.end_stone, 0, 2);
        world.setBlock(i + 46, j + 6, k + 18, Blocks.end_stone, 0, 2);
        world.setBlock(i + 47, j + 6, k + 18, Blocks.end_stone, 0, 2);
        world.setBlock(i + 48, j + 6, k + 18, Blocks.end_stone, 0, 2);
        world.setBlock(i + 36, j + 6, k + 19, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 29, j + 6, k + 20, PlacePurpurPillar, 0, 2);
        world.setBlock(i + 4, j + 6, k + 21, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 11, j + 6, k + 21, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 32, j + 6, k + 21, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 26, j + 6, k + 23, PlacePurpurPillar, 0, 2);
        world.setBlock(i + 8, j + 6, k + 24, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 27, j + 6, k + 26, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 37, j + 6, k + 26, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 36, j + 6, k + 28, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 26, j + 6, k + 30, PlacePurpurPillar, 0, 2);
        world.setBlock(i + 38, j + 6, k + 30, PlacePurpurPillar, 0, 2);
        world.setBlock(i + 32, j + 6, k + 31, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 28, j + 6, k + 32, PlacePurpurPillar, 0, 2);
        world.setBlock(i + 36, j + 6, k + 32, PlacePurpurPillar, 0, 2);
        world.setBlock(i + 29, j + 6, k + 33, Blocks.end_stone, 0, 2);
        world.setBlock(i + 30, j + 6, k + 33, Blocks.end_stone, 0, 2);
        world.setBlock(i + 31, j + 6, k + 33, Blocks.end_stone, 0, 2);
        world.setBlock(i + 32, j + 6, k + 33, Blocks.end_stone, 0, 2);
        world.setBlock(i + 33, j + 6, k + 33, Blocks.end_stone, 0, 2);
        world.setBlock(i + 34, j + 6, k + 33, Blocks.end_stone, 0, 2);
        world.setBlock(i + 35, j + 6, k + 33, Blocks.end_stone, 0, 2);
        world.setBlock(i + 29, j + 6, k + 34, Blocks.end_stone, 0, 2);
        world.setBlock(i + 30, j + 6, k + 34, Blocks.end_stone, 0, 2);
        world.setBlock(i + 31, j + 6, k + 34, Blocks.end_stone, 0, 2);
        world.setBlock(i + 32, j + 6, k + 34, Blocks.end_stone, 0, 2);
        world.setBlock(i + 33, j + 6, k + 34, Blocks.end_stone, 0, 2);
        world.setBlock(i + 34, j + 6, k + 34, Blocks.end_stone, 0, 2);
        world.setBlock(i + 35, j + 6, k + 34, Blocks.end_stone, 0, 2);
        world.setBlock(i + 36, j + 6, k + 34, Blocks.end_stone, 0, 2);
        world.setBlock(i + 27, j + 6, k + 35, Blocks.end_stone, 0, 2);
        world.setBlock(i + 28, j + 6, k + 35, Blocks.end_stone, 0, 2);
        world.setBlock(i + 29, j + 6, k + 35, Blocks.end_stone, 0, 2);
        world.setBlock(i + 30, j + 6, k + 35, Blocks.end_stone, 0, 2);
        world.setBlock(i + 31, j + 6, k + 35, Blocks.end_stone, 0, 2);
        world.setBlock(i + 32, j + 6, k + 35, Blocks.end_stone, 0, 2);
        world.setBlock(i + 33, j + 6, k + 35, Blocks.end_stone, 0, 2);
        world.setBlock(i + 34, j + 6, k + 35, Blocks.end_stone, 0, 2);
        world.setBlock(i + 35, j + 6, k + 35, Blocks.end_stone, 0, 2);
        world.setBlock(i + 36, j + 6, k + 35, Blocks.end_stone, 0, 2);
        world.setBlock(i + 37, j + 6, k + 35, Blocks.end_stone, 0, 2);
        world.setBlock(i + 38, j + 6, k + 35, placeChorusFlower(random), 0, 2);
        world.setBlock(i + 5, j + 6, k + 36, Blocks.end_stone, 0, 2);
        world.setBlock(i + 6, j + 6, k + 36, Blocks.end_stone, 0, 2);
        world.setBlock(i + 7, j + 6, k + 36, Blocks.end_stone, 0, 2);
        world.setBlock(i + 8, j + 6, k + 36, Blocks.end_stone, 0, 2);
        world.setBlock(i + 27, j + 6, k + 36, Blocks.end_stone, 0, 2);
        world.setBlock(i + 28, j + 6, k + 36, Blocks.end_stone, 0, 2);
        world.setBlock(i + 29, j + 6, k + 36, Blocks.end_stone, 0, 2);
        world.setBlock(i + 30, j + 6, k + 36, Blocks.end_stone, 0, 2);
        world.setBlock(i + 31, j + 6, k + 36, Blocks.end_stone, 0, 2);
        world.setBlock(i + 32, j + 6, k + 36, Blocks.end_stone, 0, 2);
        world.setBlock(i + 33, j + 6, k + 36, Blocks.end_stone, 0, 2);
        world.setBlock(i + 34, j + 6, k + 36, Blocks.end_stone, 0, 2);
        world.setBlock(i + 35, j + 6, k + 36, Blocks.end_stone, 0, 2);
        world.setBlock(i + 36, j + 6, k + 36, Blocks.end_stone, 0, 2);
        world.setBlock(i + 37, j + 6, k + 36, Blocks.end_stone, 0, 2);
        world.setBlock(i + 38, j + 6, k + 36, Blocks.end_stone, 0, 2);
        world.setBlock(i + 4, j + 6, k + 37, Blocks.end_stone, 0, 2);
        world.setBlock(i + 9, j + 6, k + 37, Blocks.end_stone, 0, 2);
        world.setBlock(i + 27, j + 6, k + 37, Blocks.end_stone, 0, 2);
        world.setBlock(i + 28, j + 6, k + 37, Blocks.end_stone, 0, 2);
        world.setBlock(i + 29, j + 6, k + 37, Blocks.end_stone, 0, 2);
        world.setBlock(i + 30, j + 6, k + 37, Blocks.end_stone, 0, 2);
        world.setBlock(i + 31, j + 6, k + 37, Blocks.end_stone, 0, 2);
        world.setBlock(i + 32, j + 6, k + 37, Blocks.end_stone, 0, 2);
        world.setBlock(i + 34, j + 6, k + 37, Blocks.end_stone, 0, 2);
        world.setBlock(i + 35, j + 6, k + 37, Blocks.end_stone, 0, 2);
        world.setBlock(i + 36, j + 6, k + 37, Blocks.end_stone, 0, 2);
        world.setBlock(i + 37, j + 6, k + 37, Blocks.end_stone, 0, 2);
        world.setBlock(i + 3, j + 6, k + 38, Blocks.end_stone, 0, 2);
        world.setBlock(i + 5, j + 6, k + 38, Blocks.glowstone, 0, 2);
        world.setBlock(i + 10, j + 6, k + 38, Blocks.end_stone, 0, 2);
        world.setBlock(i + 17, j + 6, k + 38, PlacePurpurPillar, 0, 2);
        world.setBlock(i + 21, j + 6, k + 38, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 28, j + 6, k + 38, Blocks.end_stone, 0, 2);
        world.setBlock(i + 29, j + 6, k + 38, Blocks.end_stone, 0, 2);
        world.setBlock(i + 30, j + 6, k + 38, Blocks.end_stone, 0, 2);
        world.setBlock(i + 31, j + 6, k + 38, Blocks.end_stone, 0, 2);
        world.setBlock(i + 32, j + 6, k + 38, Blocks.end_stone, 0, 2);
        world.setBlock(i + 33, j + 6, k + 38, Blocks.end_stone, 0, 2);
        world.setBlock(i + 34, j + 6, k + 38, Blocks.end_stone, 0, 2);
        world.setBlock(i + 35, j + 6, k + 38, Blocks.end_stone, 0, 2);
        world.setBlock(i + 36, j + 6, k + 38, Blocks.end_stone, 0, 2);
        world.setBlock(i + 3, j + 6, k + 39, Blocks.end_stone, 0, 2);
        world.setBlock(i + 10, j + 6, k + 39, Blocks.end_stone, 0, 2);
        world.setBlock(i + 11, j + 6, k + 39, Blocks.stone_button, 1, 2);
        world.setBlock(i + 29, j + 6, k + 39, Blocks.end_stone, 0, 2);
        world.setBlock(i + 30, j + 6, k + 39, Blocks.end_stone, 0, 2);
        world.setBlock(i + 31, j + 6, k + 39, Blocks.end_stone, 0, 2);
        world.setBlock(i + 32, j + 6, k + 39, Blocks.end_stone, 0, 2);
        world.setBlock(i + 33, j + 6, k + 39, Blocks.end_stone, 0, 2);
        world.setBlock(i + 34, j + 6, k + 39, Blocks.end_stone, 0, 2);
        world.setBlock(i + 35, j + 6, k + 39, Blocks.end_stone, 0, 2);
        world.setBlock(i + 36, j + 6, k + 39, Blocks.end_stone, 0, 2);
        world.setBlock(i + 38, j + 6, k + 39, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 3, j + 6, k + 40, Blocks.end_stone, 0, 2);
        world.setBlock(i + 10, j + 6, k + 40, Blocks.iron_door, 8, 2);
        world.setBlock(i + 29, j + 6, k + 40, Blocks.end_stone, 0, 2);
        world.setBlock(i + 30, j + 6, k + 40, Blocks.end_stone, 0, 2);
        world.setBlock(i + 31, j + 6, k + 40, Blocks.end_stone, 0, 2);
        world.setBlock(i + 32, j + 6, k + 40, Blocks.end_stone, 0, 2);
        world.setBlock(i + 33, j + 6, k + 40, Blocks.end_stone, 0, 2);
        world.setBlock(i + 34, j + 6, k + 40, Blocks.end_stone, 0, 2);
        world.setBlock(i + 3, j + 6, k + 41, Blocks.end_stone, 0, 2);
        world.setBlock(i + 9, j + 6, k + 41, Blocks.stone_button, 2, 2);
        world.setBlock(i + 10, j + 6, k + 41, Blocks.end_stone, 0, 2);
        world.setBlock(i + 3, j + 6, k + 42, Blocks.end_stone, 0, 2);
        world.setBlock(i + 10, j + 6, k + 42, Blocks.end_stone, 0, 2);
        world.setBlock(i + 17, j + 6, k + 42, PlacePurpurPillar, 0, 2);
        world.setBlock(i + 21, j + 6, k + 42, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 4, j + 6, k + 43, Blocks.end_stone, 0, 2);
        world.setBlock(i + 9, j + 6, k + 43, Blocks.end_stone, 0, 2);
        world.setBlock(i + 44, j + 6, k + 43, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 5, j + 6, k + 44, Blocks.end_stone, 0, 2);
        world.setBlock(i + 6, j + 6, k + 44, Blocks.end_stone, 0, 2);
        world.setBlock(i + 7, j + 6, k + 44, Blocks.end_stone, 0, 2);
        world.setBlock(i + 8, j + 6, k + 44, Blocks.end_stone, 0, 2);
        world.setBlock(i + 21, j + 6, k + 44, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 42, j + 6, k + 44, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 30, j + 6, k + 45, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 34, j + 6, k + 46, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 39, j + 6, k + 47, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 30, j + 7, k, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 13, j + 7, k + 7, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 19, j + 7, k + 7, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 44, j + 7, k + 7, Blocks.end_stone, 0, 2);
        world.setBlock(i + 45, j + 7, k + 7, Blocks.end_stone, 0, 2);
        world.setBlock(i + 46, j + 7, k + 7, Blocks.end_stone, 0, 2);
        world.setBlock(i + 47, j + 7, k + 7, Blocks.end_stone, 0, 2);
        world.setBlock(i + 48, j + 7, k + 7, Blocks.end_stone, 0, 2);
        world.setBlock(i + 43, j + 7, k + 8, Blocks.end_stone, 0, 2);
        world.setBlock(i + 44, j + 7, k + 8, Blocks.end_stone, 0, 2);
        world.setBlock(i + 45, j + 7, k + 8, Blocks.end_stone, 0, 2);
        world.setBlock(i + 46, j + 7, k + 8, Blocks.end_stone, 0, 2);
        world.setBlock(i + 47, j + 7, k + 8, Blocks.end_stone, 0, 2);
        world.setBlock(i + 48, j + 7, k + 8, Blocks.end_stone, 0, 2);
        world.setBlock(i + 49, j + 7, k + 8, Blocks.end_stone, 0, 2);
        world.setBlock(i + 42, j + 7, k + 9, Blocks.end_stone, 0, 2);
        world.setBlock(i + 43, j + 7, k + 9, Blocks.end_stone, 0, 2);
        world.setBlock(i + 44, j + 7, k + 9, Blocks.end_stone, 0, 2);
        world.setBlock(i + 45, j + 7, k + 9, Blocks.end_stone, 0, 2);
        world.setBlock(i + 46, j + 7, k + 9, Blocks.end_stone, 0, 2);
        world.setBlock(i + 47, j + 7, k + 9, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 48, j + 7, k + 9, Blocks.end_stone, 0, 2);
        world.setBlock(i + 49, j + 7, k + 9, Blocks.end_stone, 0, 2);
        world.setBlock(i + 50, j + 7, k + 9, Blocks.end_stone, 0, 2);
        world.setBlock(i + 41, j + 7, k + 10, Blocks.end_stone, 0, 2);
        world.setBlock(i + 42, j + 7, k + 10, Blocks.end_stone, 0, 2);
        world.setBlock(i + 43, j + 7, k + 10, Blocks.end_stone, 0, 2);
        world.setBlock(i + 44, j + 7, k + 10, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 45, j + 7, k + 10, Blocks.end_stone, 0, 2);
        world.setBlock(i + 46, j + 7, k + 10, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 47, j + 7, k + 10, Blocks.end_stone, 0, 2);
        world.setBlock(i + 48, j + 7, k + 10, Blocks.end_stone, 0, 2);
        world.setBlock(i + 49, j + 7, k + 10, Blocks.ladder, 4, 2);
        world.setBlock(i + 50, j + 7, k + 10, Blocks.end_stone, 0, 2);
        world.setBlock(i + 51, j + 7, k + 10, Blocks.end_stone, 0, 2);
        world.setBlock(i + 23, j + 7, k + 11, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 40, j + 7, k + 11, Blocks.end_stone, 0, 2);
        world.setBlock(i + 41, j + 7, k + 11, Blocks.end_stone, 0, 2);
        world.setBlock(i + 42, j + 7, k + 11, Blocks.end_stone, 0, 2);
        world.setBlock(i + 43, j + 7, k + 11, Blocks.end_stone, 0, 2);
        world.setBlock(i + 44, j + 7, k + 11, Blocks.end_stone, 0, 2);
        world.setBlock(i + 45, j + 7, k + 11, Blocks.end_stone, 0, 2);
        world.setBlock(i + 46, j + 7, k + 11, Blocks.end_stone, 0, 2);
        world.setBlock(i + 47, j + 7, k + 11, Blocks.end_stone, 0, 2);
        world.setBlock(i + 48, j + 7, k + 11, Blocks.end_stone, 0, 2);
        world.setBlock(i + 49, j + 7, k + 11, Blocks.end_stone, 0, 2);
        world.setBlock(i + 50, j + 7, k + 11, Blocks.end_stone, 0, 2);
        world.setBlock(i + 51, j + 7, k + 11, Blocks.end_stone, 0, 2);
        world.setBlock(i + 40, j + 7, k + 12, Blocks.end_stone, 0, 2);
        world.setBlock(i + 41, j + 7, k + 12, Blocks.end_stone, 0, 2);
        world.setBlock(i + 42, j + 7, k + 12, Blocks.end_stone, 0, 2);
        world.setBlock(i + 43, j + 7, k + 12, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 44, j + 7, k + 12, Blocks.end_stone, 0, 2);
        world.setBlock(i + 45, j + 7, k + 12, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 46, j + 7, k + 12, Blocks.end_stone, 0, 2);
        world.setBlock(i + 47, j + 7, k + 12, Blocks.end_stone, 0, 2);
        world.setBlock(i + 48, j + 7, k + 12, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 49, j + 7, k + 12, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 50, j + 7, k + 12, Blocks.end_stone, 0, 2);
        world.setBlock(i + 51, j + 7, k + 12, Blocks.end_stone, 0, 2);
        world.setBlock(i + 52, j + 7, k + 12, Blocks.end_stone, 0, 2);
        world.setBlock(i + 13, j + 7, k + 13, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 40, j + 7, k + 13, Blocks.end_stone, 0, 2);
        world.setBlock(i + 41, j + 7, k + 13, Blocks.end_stone, 0, 2);
        world.setBlock(i + 42, j + 7, k + 13, Blocks.end_stone, 0, 2);
        world.setBlock(i + 43, j + 7, k + 13, Blocks.end_stone, 0, 2);
        world.setBlock(i + 44, j + 7, k + 13, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 45, j + 7, k + 13, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 46, j + 7, k + 13, Blocks.end_stone, 0, 2);
        world.setBlock(i + 47, j + 7, k + 13, Blocks.end_stone, 0, 2);
        world.setBlock(i + 48, j + 7, k + 13, Blocks.end_stone, 0, 2);
        world.setBlock(i + 49, j + 7, k + 13, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 50, j + 7, k + 13, Blocks.end_stone, 0, 2);
        world.setBlock(i + 51, j + 7, k + 13, Blocks.end_stone, 0, 2);
        world.setBlock(i + 52, j + 7, k + 13, Blocks.end_stone, 0, 2);
        world.setBlock(i + 40, j + 7, k + 14, Blocks.end_stone, 0, 2);
        world.setBlock(i + 41, j + 7, k + 14, Blocks.end_stone, 0, 2);
        world.setBlock(i + 42, j + 7, k + 14, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 43, j + 7, k + 14, Blocks.end_stone, 0, 2);
        world.setBlock(i + 44, j + 7, k + 14, Blocks.end_stone, 0, 2);
        world.setBlock(i + 45, j + 7, k + 14, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 46, j + 7, k + 14, Blocks.end_stone, 0, 2);
        world.setBlock(i + 47, j + 7, k + 14, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 48, j + 7, k + 14, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 49, j + 7, k + 14, Blocks.end_stone, 0, 2);
        world.setBlock(i + 50, j + 7, k + 14, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 51, j + 7, k + 14, Blocks.end_stone, 0, 2);
        world.setBlock(i + 52, j + 7, k + 14, Blocks.end_stone, 0, 2);
        world.setBlock(i + 23, j + 7, k + 15, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 40, j + 7, k + 15, Blocks.end_stone, 0, 2);
        world.setBlock(i + 41, j + 7, k + 15, Blocks.end_stone, 0, 2);
        world.setBlock(i + 42, j + 7, k + 15, Blocks.end_stone, 0, 2);
        world.setBlock(i + 43, j + 7, k + 15, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 44, j + 7, k + 15, Blocks.end_stone, 0, 2);
        world.setBlock(i + 45, j + 7, k + 15, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 46, j + 7, k + 15, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 47, j + 7, k + 15, Blocks.end_stone, 0, 2);
        world.setBlock(i + 48, j + 7, k + 15, Blocks.end_stone, 0, 2);
        world.setBlock(i + 49, j + 7, k + 15, Blocks.end_stone, 0, 2);
        world.setBlock(i + 50, j + 7, k + 15, Blocks.end_stone, 0, 2);
        world.setBlock(i + 51, j + 7, k + 15, Blocks.end_stone, 0, 2);
        world.setBlock(i + 52, j + 7, k + 15, Blocks.end_stone, 0, 2);
        world.setBlock(i + 40, j + 7, k + 16, Blocks.end_stone, 0, 2);
        world.setBlock(i + 41, j + 7, k + 16, Blocks.end_stone, 0, 2);
        world.setBlock(i + 42, j + 7, k + 16, Blocks.end_stone, 0, 2);
        world.setBlock(i + 43, j + 7, k + 16, Blocks.end_stone, 0, 2);
        world.setBlock(i + 44, j + 7, k + 16, Blocks.end_stone, 0, 2);
        world.setBlock(i + 45, j + 7, k + 16, Blocks.end_stone, 0, 2);
        world.setBlock(i + 46, j + 7, k + 16, Blocks.end_stone, 0, 2);
        world.setBlock(i + 47, j + 7, k + 16, Blocks.end_stone, 0, 2);
        world.setBlock(i + 48, j + 7, k + 16, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 49, j + 7, k + 16, Blocks.end_stone, 0, 2);
        world.setBlock(i + 50, j + 7, k + 16, Blocks.end_stone, 0, 2);
        world.setBlock(i + 51, j + 7, k + 16, Blocks.end_stone, 0, 2);
        world.setBlock(i + 21, j + 7, k + 17, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 40, j + 7, k + 17, Blocks.end_stone, 0, 2);
        world.setBlock(i + 41, j + 7, k + 17, Blocks.end_stone, 0, 2);
        world.setBlock(i + 42, j + 7, k + 17, Blocks.end_stone, 0, 2);
        world.setBlock(i + 43, j + 7, k + 17, Blocks.end_stone, 0, 2);
        world.setBlock(i + 44, j + 7, k + 17, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 45, j + 7, k + 17, Blocks.end_stone, 0, 2);
        world.setBlock(i + 46, j + 7, k + 17, Blocks.end_stone, 0, 2);
        world.setBlock(i + 47, j + 7, k + 17, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 48, j + 7, k + 17, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 49, j + 7, k + 17, Blocks.end_stone, 0, 2);
        world.setBlock(i + 50, j + 7, k + 17, Blocks.end_stone, 0, 2);
        world.setBlock(i + 37, j + 7, k + 18, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 40, j + 7, k + 18, Blocks.end_stone, 0, 2);
        world.setBlock(i + 41, j + 7, k + 18, Blocks.end_stone, 0, 2);
        world.setBlock(i + 42, j + 7, k + 18, Blocks.end_stone, 0, 2);
        world.setBlock(i + 43, j + 7, k + 18, Blocks.end_stone, 0, 2);
        world.setBlock(i + 44, j + 7, k + 18, Blocks.end_stone, 0, 2);
        world.setBlock(i + 45, j + 7, k + 18, Blocks.end_stone, 0, 2);
        world.setBlock(i + 46, j + 7, k + 18, Blocks.end_stone, 0, 2);
        world.setBlock(i + 47, j + 7, k + 18, Blocks.end_stone, 0, 2);
        world.setBlock(i + 48, j + 7, k + 18, Blocks.end_stone, 0, 2);
        world.setBlock(i + 49, j + 7, k + 18, Blocks.end_stone, 0, 2);
        world.setBlock(i + 41, j + 7, k + 19, Blocks.end_stone, 0, 2);
        world.setBlock(i + 42, j + 7, k + 19, Blocks.end_stone, 0, 2);
        world.setBlock(i + 43, j + 7, k + 19, Blocks.end_stone, 0, 2);
        world.setBlock(i + 44, j + 7, k + 19, Blocks.end_stone, 0, 2);
        world.setBlock(i + 45, j + 7, k + 19, Blocks.end_stone, 0, 2);
        world.setBlock(i + 46, j + 7, k + 19, Blocks.end_stone, 0, 2);
        world.setBlock(i + 47, j + 7, k + 19, Blocks.end_stone, 0, 2);
        world.setBlock(i + 48, j + 7, k + 19, Blocks.end_stone, 0, 2);
        world.setBlock(i + 29, j + 7, k + 20, PlacePurpurPillar, 0, 2);
        world.setBlock(i + 4, j + 7, k + 21, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 32, j + 7, k + 21, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 26, j + 7, k + 23, PlacePurpurPillar, 0, 2);
        world.setBlock(i + 8, j + 7, k + 24, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 27, j + 7, k + 26, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 37, j + 7, k + 26, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 26, j + 7, k + 30, PlacePurpurPillar, 0, 2);
        world.setBlock(i + 38, j + 7, k + 30, PlacePurpurPillar, 0, 2);
        world.setBlock(i + 32, j + 7, k + 31, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 28, j + 7, k + 32, PlacePurpurPillar, 0, 2);
        world.setBlock(i + 36, j + 7, k + 32, PlacePurpurPillar, 0, 2);
        world.setBlock(i + 32, j + 7, k + 33, placeChorusFlower(random), 0, 2);
        world.setBlock(i + 30, j + 7, k + 34, Blocks.end_stone, 0, 2);
        world.setBlock(i + 31, j + 7, k + 34, Blocks.end_stone, 0, 2);
        world.setBlock(i + 32, j + 7, k + 34, Blocks.end_stone, 0, 2);
        world.setBlock(i + 33, j + 7, k + 34, Blocks.end_stone, 0, 2);
        world.setBlock(i + 34, j + 7, k + 34, Blocks.end_stone, 0, 2);
        world.setBlock(i + 35, j + 7, k + 34, Blocks.end_stone, 0, 2);
        world.setBlock(i + 36, j + 7, k + 34, Blocks.end_stone, 0, 2);
        world.setBlock(i + 30, j + 7, k + 35, Blocks.end_stone, 0, 2);
        world.setBlock(i + 31, j + 7, k + 35, Blocks.end_stone, 0, 2);
        world.setBlock(i + 32, j + 7, k + 35, Blocks.end_stone, 0, 2);
        world.setBlock(i + 33, j + 7, k + 35, Blocks.end_stone, 0, 2);
        world.setBlock(i + 34, j + 7, k + 35, Blocks.end_stone, 0, 2);
        world.setBlock(i + 35, j + 7, k + 35, Blocks.end_stone, 0, 2);
        world.setBlock(i + 36, j + 7, k + 35, Blocks.end_stone, 0, 2);
        world.setBlock(i + 5, j + 7, k + 36, Blocks.end_stone, 0, 2);
        world.setBlock(i + 6, j + 7, k + 36, Blocks.end_stone, 0, 2);
        world.setBlock(i + 7, j + 7, k + 36, Blocks.end_stone, 0, 2);
        world.setBlock(i + 8, j + 7, k + 36, Blocks.end_stone, 0, 2);
        world.setBlock(i + 28, j + 7, k + 36, placeChorusFlower(random), 0, 2);
        world.setBlock(i + 30, j + 7, k + 36, Blocks.end_stone, 0, 2);
        world.setBlock(i + 31, j + 7, k + 36, Blocks.end_stone, 0, 2);
        world.setBlock(i + 32, j + 7, k + 36, Blocks.end_stone, 0, 2);
        world.setBlock(i + 33, j + 7, k + 36, Blocks.end_stone, 0, 2);
        world.setBlock(i + 34, j + 7, k + 36, Blocks.end_stone, 0, 2);
        world.setBlock(i + 35, j + 7, k + 36, Blocks.end_stone, 0, 2);
        world.setBlock(i + 36, j + 7, k + 36, Blocks.end_stone, 0, 2);
        world.setBlock(i + 4, j + 7, k + 37, Blocks.end_stone, 0, 2);
        world.setBlock(i + 9, j + 7, k + 37, Blocks.end_stone, 0, 2);
        world.setBlock(i + 30, j + 7, k + 37, Blocks.end_stone, 0, 2);
        world.setBlock(i + 31, j + 7, k + 37, Blocks.end_stone, 0, 2);
        world.setBlock(i + 32, j + 7, k + 37, Blocks.end_stone, 0, 2);
        world.setBlock(i + 33, j + 7, k + 37, Blocks.end_stone, 0, 2);
        world.setBlock(i + 34, j + 7, k + 37, Blocks.end_stone, 0, 2);
        world.setBlock(i + 35, j + 7, k + 37, Blocks.end_stone, 0, 2);
        world.setBlock(i + 36, j + 7, k + 37, Blocks.end_stone, 0, 2);
        world.setBlock(i + 3, j + 7, k + 38, Blocks.end_stone, 0, 2);
        world.setBlock(i + 5, j + 7, k + 38, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 10, j + 7, k + 38, Blocks.end_stone, 0, 2);
        world.setBlock(i + 17, j + 7, k + 38, PlacePurpurPillar, 0, 2);
        world.setBlock(i + 30, j + 7, k + 38, Blocks.end_stone, 0, 2);
        world.setBlock(i + 31, j + 7, k + 38, Blocks.end_stone, 0, 2);
        world.setBlock(i + 32, j + 7, k + 38, Blocks.end_stone, 0, 2);
        world.setBlock(i + 33, j + 7, k + 38, Blocks.end_stone, 0, 2);
        world.setBlock(i + 34, j + 7, k + 38, Blocks.end_stone, 0, 2);
        world.setBlock(i + 35, j + 7, k + 38, Blocks.end_stone, 0, 2);
        world.setBlock(i + 36, j + 7, k + 38, Blocks.end_stone, 0, 2);
        world.setBlock(i + 3, j + 7, k + 39, Blocks.end_stone, 0, 2);
        world.setBlock(i + 10, j + 7, k + 39, Blocks.end_stone, 0, 2);
        world.setBlock(i + 30, j + 7, k + 39, Blocks.end_stone, 0, 2);
        world.setBlock(i + 31, j + 7, k + 39, Blocks.end_stone, 0, 2);
        world.setBlock(i + 32, j + 7, k + 39, Blocks.end_stone, 0, 2);
        world.setBlock(i + 33, j + 7, k + 39, Blocks.end_stone, 0, 2);
        world.setBlock(i + 34, j + 7, k + 39, Blocks.end_stone, 0, 2);
        world.setBlock(i + 35, j + 7, k + 39, Blocks.end_stone, 0, 2);
        world.setBlock(i + 36, j + 7, k + 39, Blocks.end_stone, 0, 2);
        world.setBlock(i + 38, j + 7, k + 39, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 3, j + 7, k + 40, Blocks.end_stone, 0, 2);
        world.setBlock(i + 8, j + 7, k + 40, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 10, j + 7, k + 40, Blocks.end_stone, 0, 2);
        world.setBlock(i + 29, j + 7, k + 40, placeChorusFlower(random), 0, 2);
        world.setBlock(i + 3, j + 7, k + 41, Blocks.end_stone, 0, 2);
        world.setBlock(i + 10, j + 7, k + 41, Blocks.end_stone, 0, 2);
        world.setBlock(i + 3, j + 7, k + 42, Blocks.end_stone, 0, 2);
        world.setBlock(i + 5, j + 7, k + 42, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 10, j + 7, k + 42, Blocks.end_stone, 0, 2);
        world.setBlock(i + 17, j + 7, k + 42, PlacePurpurPillar, 0, 2);
        world.setBlock(i + 21, j + 7, k + 42, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 4, j + 7, k + 43, Blocks.end_stone, 0, 2);
        world.setBlock(i + 9, j + 7, k + 43, Blocks.end_stone, 0, 2);
        world.setBlock(i + 5, j + 7, k + 44, Blocks.end_stone, 0, 2);
        world.setBlock(i + 6, j + 7, k + 44, Blocks.end_stone, 0, 2);
        world.setBlock(i + 7, j + 7, k + 44, Blocks.end_stone, 0, 2);
        world.setBlock(i + 8, j + 7, k + 44, Blocks.end_stone, 0, 2);
        world.setBlock(i + 42, j + 7, k + 44, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 34, j + 7, k + 46, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 13, j + 8, k + 7, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 14, j + 8, k + 7, NovaCraftBlocks.frontierslate_brick_stairs, 5, 2);
        world.setBlock(i + 19, j + 8, k + 7, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 44, j + 8, k + 8, Blocks.end_stone, 0, 2);
        world.setBlock(i + 45, j + 8, k + 8, Blocks.end_stone, 0, 2);
        world.setBlock(i + 46, j + 8, k + 8, Blocks.end_stone, 0, 2);
        world.setBlock(i + 47, j + 8, k + 8, Blocks.end_stone, 0, 2);
        world.setBlock(i + 48, j + 8, k + 8, Blocks.end_stone, 0, 2);
        world.setBlock(i + 43, j + 8, k + 9, Blocks.end_stone, 0, 2);
        world.setBlock(i + 44, j + 8, k + 9, Blocks.carpet, 10, 2);
        world.setBlock(i + 45, j + 8, k + 9, Blocks.carpet, 10, 2);
        world.setBlock(i + 47, j + 8, k + 9, Blocks.carpet, 10, 2);
        world.setBlock(i + 48, j + 8, k + 9, Blocks.carpet, 10, 2);
        world.setBlock(i + 49, j + 8, k + 9, Blocks.end_stone, 0, 2);
        world.setBlock(i + 42, j + 8, k + 10, Blocks.end_stone, 0, 2);
        world.setBlock(i + 43, j + 8, k + 10, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 44, j + 8, k + 10, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 45, j + 8, k + 10, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 47, j + 8, k + 10, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 48, j + 8, k + 10, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 49, j + 8, k + 10, Blocks.ladder, 4, 2);
        world.setBlock(i + 50, j + 8, k + 10, Blocks.end_stone, 0, 2);
        world.setBlock(i + 23, j + 8, k + 11, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 41, j + 8, k + 11, Blocks.end_stone, 0, 2);
        world.setBlock(i + 42, j + 8, k + 11, Blocks.packed_ice, 0, 2);
        world.setBlock(i + 43, j + 8, k + 11, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 44, j + 8, k + 11, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 45, j + 8, k + 11, NovaCraftBlocks.frontierslate_brick_stairs, 0, 2);
        world.setBlock(i + 51, j + 8, k + 11, Blocks.end_stone, 0, 2);
        world.setBlock(i + 41, j + 8, k + 12, Blocks.end_stone, 0, 2);
        world.setBlock(i + 42, j + 8, k + 12, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 43, j + 8, k + 12, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 51, j + 8, k + 12, Blocks.end_stone, 0, 2);
        world.setBlock(i + 13, j + 8, k + 13, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 41, j + 8, k + 13, Blocks.end_stone, 0, 2);
        world.setBlock(i + 51, j + 8, k + 13, Blocks.end_stone, 0, 2);
        world.setBlock(i + 40, j + 8, k + 14, placeChorusFlower(random), 0, 2);
        world.setBlock(i + 41, j + 8, k + 14, Blocks.end_stone, 0, 2);
        world.setBlock(i + 49, j + 8, k + 14, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 50, j + 8, k + 14, Blocks.carpet, 10, 2);
        world.setBlock(i + 51, j + 8, k + 14, Blocks.end_stone, 0, 2);
        world.setBlock(i + 41, j + 8, k + 15, Blocks.end_stone, 0, 2);
        world.setBlock(i + 42, j + 8, k + 15, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 43, j + 8, k + 15, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 47, j + 8, k + 15, NovaCraftBlocks.frontierslate_brick_stairs, 1, 2);
        world.setBlock(i + 48, j + 8, k + 15, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 49, j + 8, k + 15, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 50, j + 8, k + 15, Blocks.carpet, 10, 2);
        world.setBlock(i + 51, j + 8, k + 15, Blocks.end_stone, 0, 2);
        world.setBlock(i + 41, j + 8, k + 16, Blocks.end_stone, 0, 2);
        world.setBlock(i + 42, j + 8, k + 16, Blocks.packed_ice, 0, 2);
        world.setBlock(i + 43, j + 8, k + 16, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 44, j + 8, k + 16, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 47, j + 8, k + 16, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 48, j + 8, k + 16, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 49, j + 8, k + 16, Blocks.end_stone, 0, 2);
        world.setBlock(i + 50, j + 8, k + 16, Blocks.end_stone, 0, 2);
        world.setBlock(i + 18, j + 8, k + 17, NovaCraftBlocks.frontierslate_brick_stairs, 5, 2);
        world.setBlock(i + 21, j + 8, k + 17, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 41, j + 8, k + 17, Blocks.end_stone, 0, 2);
        world.setBlock(i + 42, j + 8, k + 17, Blocks.end_stone, 0, 2);
        world.setBlock(i + 43, j + 8, k + 17, Blocks.carpet, 10, 2);
        world.setBlock(i + 44, j + 8, k + 17, Blocks.carpet, 10, 2);
        world.setBlock(i + 47, j + 8, k + 17, Blocks.carpet, 10, 2);
        world.setBlock(i + 48, j + 8, k + 17, Blocks.carpet, 10, 2);
        world.setBlock(i + 49, j + 8, k + 17, Blocks.end_stone, 0, 2);
        world.setBlock(i + 42, j + 8, k + 18, Blocks.end_stone, 0, 2);
        world.setBlock(i + 43, j + 8, k + 18, Blocks.end_stone, 0, 2);
        world.setBlock(i + 44, j + 8, k + 18, Blocks.end_stone, 0, 2);
        world.setBlock(i + 45, j + 8, k + 18, Blocks.end_stone, 0, 2);
        world.setBlock(i + 46, j + 8, k + 18, Blocks.end_stone, 0, 2);
        world.setBlock(i + 47, j + 8, k + 18, Blocks.end_stone, 0, 2);
        world.setBlock(i + 48, j + 8, k + 18, Blocks.end_stone, 0, 2);
        world.setBlock(i + 29, j + 8, k + 20, PlacePurpurPillar, 0, 2);
        world.setBlock(i + 32, j + 8, k + 21, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 26, j + 8, k + 23, PlacePurpurPillar, 0, 2);
        world.setBlock(i + 8, j + 8, k + 24, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 27, j + 8, k + 26, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 37, j + 8, k + 26, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 26, j + 8, k + 30, PlacePurpurPillar, 0, 2);
        world.setBlock(i + 38, j + 8, k + 30, PlacePurpurPillar, 0, 2);
        world.setBlock(i + 32, j + 8, k + 31, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 28, j + 8, k + 32, PlacePurpurPillar, 0, 2);
        world.setBlock(i + 36, j + 8, k + 32, PlacePurpurPillar, 0, 2);
        world.setBlock(i + 31, j + 8, k + 35, Blocks.end_stone, 0, 2);
        world.setBlock(i + 32, j + 8, k + 35, Blocks.end_stone, 0, 2);
        world.setBlock(i + 33, j + 8, k + 35, Blocks.end_stone, 0, 2);
        world.setBlock(i + 5, j + 8, k + 36, Blocks.end_stone, 0, 2);
        world.setBlock(i + 6, j + 8, k + 36, Blocks.end_stone, 0, 2);
        world.setBlock(i + 7, j + 8, k + 36, Blocks.end_stone, 0, 2);
        world.setBlock(i + 8, j + 8, k + 36, Blocks.end_stone, 0, 2);
        world.setBlock(i + 31, j + 8, k + 36, Blocks.end_stone, 0, 2);
        world.setBlock(i + 32, j + 8, k + 36, Blocks.end_stone, 0, 2);
        world.setBlock(i + 33, j + 8, k + 36, Blocks.end_stone, 0, 2);
        world.setBlock(i + 36, j + 8, k + 36, placeChorusFlower(random), 0, 2);
        world.setBlock(i + 4, j + 8, k + 37, Blocks.end_stone, 0, 2);
        world.setBlock(i + 5, j + 8, k + 37, Blocks.end_stone, 0, 2);
        world.setBlock(i + 6, j + 8, k + 37, Blocks.end_stone, 0, 2);
        world.setBlock(i + 7, j + 8, k + 37, Blocks.end_stone, 0, 2);
        world.setBlock(i + 8, j + 8, k + 37, Blocks.end_stone, 0, 2);
        world.setBlock(i + 9, j + 8, k + 37, Blocks.end_stone, 0, 2);
        world.setBlock(i + 31, j + 8, k + 37, Blocks.end_stone, 0, 2);
        world.setBlock(i + 32, j + 8, k + 37, Blocks.end_stone, 0, 2);
        world.setBlock(i + 33, j + 8, k + 37, Blocks.end_stone, 0, 2);
        world.setBlock(i + 34, j + 8, k + 37, Blocks.end_stone, 0, 2);
        world.setBlock(i + 3, j + 8, k + 38, Blocks.end_stone, 0, 2);
        world.setBlock(i + 4, j + 8, k + 38, Blocks.end_stone, 0, 2);
        world.setBlock(i + 5, j + 8, k + 38, Blocks.end_stone, 0, 2);
        world.setBlock(i + 6, j + 8, k + 38, Blocks.end_stone, 0, 2);
        world.setBlock(i + 7, j + 8, k + 38, Blocks.end_stone, 0, 2);
        world.setBlock(i + 8, j + 8, k + 38, Blocks.end_stone, 0, 2);
        world.setBlock(i + 9, j + 8, k + 38, Blocks.end_stone, 0, 2);
        world.setBlock(i + 10, j + 8, k + 38, Blocks.end_stone, 0, 2);
        world.setBlock(i + 17, j + 8, k + 38, PlacePurpurPillar, 0, 2);
        world.setBlock(i + 31, j + 8, k + 38, Blocks.end_stone, 0, 2);
        world.setBlock(i + 32, j + 8, k + 38, Blocks.end_stone, 0, 2);
        world.setBlock(i + 33, j + 8, k + 38, Blocks.end_stone, 0, 2);
        world.setBlock(i + 2, j + 8, k + 39, Blocks.end_stone, 0, 2);
        world.setBlock(i + 3, j + 8, k + 39, Blocks.end_stone, 0, 2);
        world.setBlock(i + 4, j + 8, k + 39, Blocks.end_stone, 0, 2);
        world.setBlock(i + 5, j + 8, k + 39, Blocks.end_stone, 0, 2);
        world.setBlock(i + 6, j + 8, k + 39, Blocks.end_stone, 0, 2);
        world.setBlock(i + 7, j + 8, k + 39, Blocks.end_stone, 0, 2);
        world.setBlock(i + 8, j + 8, k + 39, Blocks.end_stone, 0, 2);
        world.setBlock(i + 9, j + 8, k + 39, Blocks.end_stone, 0, 2);
        world.setBlock(i + 10, j + 8, k + 39, Blocks.end_stone, 0, 2);
        world.setBlock(i + 11, j + 8, k + 39, Blocks.end_stone, 0, 2);
        world.setBlock(i + 34, j + 8, k + 39, placeChorusFlower(random), 0, 2);
        world.setBlock(i + 2, j + 8, k + 40, Blocks.end_stone, 0, 2);
        world.setBlock(i + 3, j + 8, k + 40, Blocks.end_stone, 0, 2);
        world.setBlock(i + 4, j + 8, k + 40, Blocks.end_stone, 0, 2);
        world.setBlock(i + 5, j + 8, k + 40, Blocks.end_stone, 0, 2);
        world.setBlock(i + 6, j + 8, k + 40, Blocks.end_stone, 0, 2);
        world.setBlock(i + 7, j + 8, k + 40, Blocks.end_stone, 0, 2);
        world.setBlock(i + 8, j + 8, k + 40, Blocks.end_stone, 0, 2);
        world.setBlock(i + 9, j + 8, k + 40, Blocks.end_stone, 0, 2);
        world.setBlock(i + 10, j + 8, k + 40, Blocks.end_stone, 0, 2);
        world.setBlock(i + 11, j + 8, k + 40, Blocks.end_stone, 0, 2);
        world.setBlock(i + 2, j + 8, k + 41, Blocks.end_stone, 0, 2);
        world.setBlock(i + 3, j + 8, k + 41, Blocks.end_stone, 0, 2);
        world.setBlock(i + 4, j + 8, k + 41, Blocks.end_stone, 0, 2);
        world.setBlock(i + 5, j + 8, k + 41, Blocks.end_stone, 0, 2);
        world.setBlock(i + 6, j + 8, k + 41, Blocks.end_stone, 0, 2);
        world.setBlock(i + 7, j + 8, k + 41, Blocks.end_stone, 0, 2);
        world.setBlock(i + 8, j + 8, k + 41, Blocks.end_stone, 0, 2);
        world.setBlock(i + 9, j + 8, k + 41, Blocks.end_stone, 0, 2);
        world.setBlock(i + 10, j + 8, k + 41, Blocks.end_stone, 0, 2);
        world.setBlock(i + 11, j + 8, k + 41, Blocks.end_stone, 0, 2);
        world.setBlock(i + 3, j + 8, k + 42, Blocks.end_stone, 0, 2);
        world.setBlock(i + 4, j + 8, k + 42, Blocks.end_stone, 0, 2);
        world.setBlock(i + 5, j + 8, k + 42, Blocks.end_stone, 0, 2);
        world.setBlock(i + 6, j + 8, k + 42, Blocks.end_stone, 0, 2);
        world.setBlock(i + 7, j + 8, k + 42, Blocks.end_stone, 0, 2);
        world.setBlock(i + 8, j + 8, k + 42, Blocks.end_stone, 0, 2);
        world.setBlock(i + 9, j + 8, k + 42, Blocks.end_stone, 0, 2);
        world.setBlock(i + 10, j + 8, k + 42, Blocks.end_stone, 0, 2);
        world.setBlock(i + 17, j + 8, k + 42, PlacePurpurPillar, 0, 2);
        world.setBlock(i + 21, j + 8, k + 42, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 4, j + 8, k + 43, Blocks.end_stone, 0, 2);
        world.setBlock(i + 5, j + 8, k + 43, Blocks.end_stone, 0, 2);
        world.setBlock(i + 6, j + 8, k + 43, Blocks.end_stone, 0, 2);
        world.setBlock(i + 7, j + 8, k + 43, Blocks.end_stone, 0, 2);
        world.setBlock(i + 8, j + 8, k + 43, Blocks.end_stone, 0, 2);
        world.setBlock(i + 9, j + 8, k + 43, Blocks.end_stone, 0, 2);
        world.setBlock(i + 5, j + 8, k + 44, Blocks.end_stone, 0, 2);
        world.setBlock(i + 6, j + 8, k + 44, Blocks.end_stone, 0, 2);
        world.setBlock(i + 7, j + 8, k + 44, Blocks.end_stone, 0, 2);
        world.setBlock(i + 8, j + 8, k + 44, Blocks.end_stone, 0, 2);
        world.setBlock(i + 42, j + 8, k + 44, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 17, j + 9, k + 7, NovaCraftBlocks.frontierslate_brick_stairs, 4, 2);
        world.setBlock(i + 18, j + 9, k + 7, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 44, j + 9, k + 8, Blocks.end_stone, 0, 2);
        world.setBlock(i + 45, j + 9, k + 8, Blocks.end_stone, 0, 2);
        world.setBlock(i + 46, j + 9, k + 8, Blocks.end_stone, 0, 2);
        world.setBlock(i + 47, j + 9, k + 8, Blocks.end_stone, 0, 2);
        world.setBlock(i + 48, j + 9, k + 8, Blocks.end_stone, 0, 2);
        world.setBlock(i + 43, j + 9, k + 9, Blocks.end_stone, 0, 2);
        world.setBlock(i + 49, j + 9, k + 9, Blocks.end_stone, 0, 2);
        world.setBlock(i + 42, j + 9, k + 10, Blocks.end_stone, 0, 2);
        world.setBlock(i + 43, j + 9, k + 10, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 44, j + 9, k + 10, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 45, j + 9, k + 10, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 47, j + 9, k + 10, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 48, j + 9, k + 10, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 49, j + 9, k + 10, Blocks.ladder, 4, 2);
        world.setBlock(i + 50, j + 9, k + 10, Blocks.end_stone, 0, 2);
        world.setBlock(i + 41, j + 9, k + 11, Blocks.end_stone, 0, 2);
        world.setBlock(i + 43, j + 9, k + 11, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 51, j + 9, k + 11, Blocks.end_stone, 0, 2);
        world.setBlock(i + 41, j + 9, k + 12, Blocks.end_stone, 0, 2);
        world.setBlock(i + 43, j + 9, k + 12, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 51, j + 9, k + 12, Blocks.end_stone, 0, 2);
        world.setBlock(i + 13, j + 9, k + 13, NovaCraftBlocks.frontierslate_brick_stairs, 3, 2);
        world.setBlock(i + 41, j + 9, k + 13, Blocks.end_stone, 0, 2);
        world.setBlock(i + 51, j + 9, k + 13, Blocks.end_stone, 0, 2);
        world.setBlock(i + 41, j + 9, k + 14, Blocks.end_stone, 0, 2);
        world.setBlock(i + 49, j + 9, k + 14, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 51, j + 9, k + 14, Blocks.end_stone, 0, 2);
        world.setBlock(i + 41, j + 9, k + 15, Blocks.end_stone, 0, 2);
        world.setBlock(i + 43, j + 9, k + 15, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 49, j + 9, k + 15, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 51, j + 9, k + 15, Blocks.end_stone, 0, 2);
        world.setBlock(i + 41, j + 9, k + 16, Blocks.end_stone, 0, 2);
        world.setBlock(i + 43, j + 9, k + 16, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 44, j + 9, k + 16, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 47, j + 9, k + 16, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 48, j + 9, k + 16, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 49, j + 9, k + 16, Blocks.end_stone, 0, 2);
        world.setBlock(i + 50, j + 9, k + 16, Blocks.end_stone, 0, 2);
        world.setBlock(i + 17, j + 9, k + 17, NovaCraftBlocks.frontierslate_brick_stairs, 0, 2);
        world.setBlock(i + 18, j + 9, k + 17, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 19, j + 9, k + 17, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 20, j + 9, k + 17, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 21, j + 9, k + 17, NovaCraftBlocks.frontierslate_brick_stairs, 1, 2);
        world.setBlock(i + 41, j + 9, k + 17, Blocks.end_stone, 0, 2);
        world.setBlock(i + 42, j + 9, k + 17, Blocks.end_stone, 0, 2);
        world.setBlock(i + 49, j + 9, k + 17, Blocks.end_stone, 0, 2);
        world.setBlock(i + 42, j + 9, k + 18, Blocks.end_stone, 0, 2);
        world.setBlock(i + 43, j + 9, k + 18, Blocks.end_stone, 0, 2);
        world.setBlock(i + 44, j + 9, k + 18, Blocks.end_stone, 0, 2);
        world.setBlock(i + 45, j + 9, k + 18, Blocks.end_stone, 0, 2);
        world.setBlock(i + 46, j + 9, k + 18, Blocks.end_stone, 0, 2);
        world.setBlock(i + 47, j + 9, k + 18, Blocks.end_stone, 0, 2);
        world.setBlock(i + 48, j + 9, k + 18, Blocks.end_stone, 0, 2);
        world.setBlock(i + 27, j + 9, k + 20, PlacePurpurBrickStairs, 6, 2);
        world.setBlock(i + 28, j + 9, k + 20, PlacePurpurBrickStairs, 6, 2);
        world.setBlock(i + 29, j + 9, k + 20, PlacePurpurPillar, 0, 2);
        world.setBlock(i + 26, j + 9, k + 21, PlacePurpurBrickStairs, 4, 2);
        world.setBlock(i + 27, j + 9, k + 21, Blocks.glowstone, 0, 2);
        world.setBlock(i + 28, j + 9, k + 21, Blocks.glowstone, 0, 2);
        world.setBlock(i + 29, j + 9, k + 21, PlacePurpurBrickStairs, 5, 2);
        world.setBlock(i + 32, j + 9, k + 21, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 26, j + 9, k + 22, PlacePurpurBrickStairs, 4, 2);
        world.setBlock(i + 27, j + 9, k + 22, Blocks.glowstone, 0, 2);
        world.setBlock(i + 28, j + 9, k + 22, Blocks.glowstone, 0, 2);
        world.setBlock(i + 29, j + 9, k + 22, PlacePurpurBrickStairs, 5, 2);
        world.setBlock(i + 26, j + 9, k + 23, PlacePurpurPillar, 0, 2);
        world.setBlock(i + 27, j + 9, k + 23, PlacePurpurBrickStairs, 7, 2);
        world.setBlock(i + 28, j + 9, k + 23, PlacePurpurBrickStairs, 7, 2);
        world.setBlock(i + 8, j + 9, k + 24, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 32, j + 9, k + 24, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 27, j + 9, k + 26, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 30, j + 9, k + 26, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 34, j + 9, k + 26, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 37, j + 9, k + 26, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 32, j + 9, k + 28, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 26, j + 9, k + 30, PlacePurpurPillar, 0, 2);
        world.setBlock(i + 27, j + 9, k + 30, PlacePurpurBrickStairs, 6, 2);
        world.setBlock(i + 37, j + 9, k + 30, PlacePurpurBrickStairs, 6, 2);
        world.setBlock(i + 38, j + 9, k + 30, PlacePurpurPillar, 0, 2);
        world.setBlock(i + 26, j + 9, k + 31, PlacePurpurBrickStairs, 4, 2);
        world.setBlock(i + 27, j + 9, k + 31, Blocks.glowstone, 0, 2);
        world.setBlock(i + 28, j + 9, k + 31, PlacePurpurBrickStairs, 5, 2);
        world.setBlock(i + 32, j + 9, k + 31, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 36, j + 9, k + 31, PlacePurpurBrickStairs, 4, 2);
        world.setBlock(i + 37, j + 9, k + 31, Blocks.glowstone, 0, 2);
        world.setBlock(i + 38, j + 9, k + 31, PlacePurpurBrickStairs, 5, 2);
        world.setBlock(i + 27, j + 9, k + 32, PlacePurpurBrickStairs, 7, 2);
        world.setBlock(i + 28, j + 9, k + 32, PlacePurpurPillar, 0, 2);
        world.setBlock(i + 36, j + 9, k + 32, PlacePurpurPillar, 0, 2);
        world.setBlock(i + 37, j + 9, k + 32, PlacePurpurBrickStairs, 7, 2);
        world.setBlock(i + 8, j + 9, k + 36, placeChorusFlower(random), 0, 2);
        world.setBlock(i + 32, j + 9, k + 36, Blocks.end_stone, 0, 2);
        world.setBlock(i + 33, j + 9, k + 36, Blocks.end_stone, 0, 2);
        world.setBlock(i + 32, j + 9, k + 37, Blocks.end_stone, 0, 2);
        world.setBlock(i + 33, j + 9, k + 37, Blocks.end_stone, 0, 2);
        world.setBlock(i + 4, j + 9, k + 38, Blocks.end_stone, 0, 2);
        world.setBlock(i + 5, j + 9, k + 38, Blocks.end_stone, 0, 2);
        world.setBlock(i + 6, j + 9, k + 38, Blocks.end_stone, 0, 2);
        world.setBlock(i + 7, j + 9, k + 38, Blocks.end_stone, 0, 2);
        world.setBlock(i + 8, j + 9, k + 38, Blocks.end_stone, 0, 2);
        world.setBlock(i + 16, j + 9, k + 38, PlacePurpurBrickStairs, 6, 2);
        world.setBlock(i + 17, j + 9, k + 38, PlacePurpurPillar, 0, 2);
        world.setBlock(i + 18, j + 9, k + 38, PlacePurpurBrickStairs, 6, 2);
        world.setBlock(i + 33, j + 9, k + 38, Blocks.end_stone, 0, 2);
        world.setBlock(i + 3, j + 9, k + 39, Blocks.end_stone, 0, 2);
        world.setBlock(i + 4, j + 9, k + 39, Blocks.end_stone, 0, 2);
        world.setBlock(i + 5, j + 9, k + 39, Blocks.end_stone, 0, 2);
        world.setBlock(i + 6, j + 9, k + 39, Blocks.end_stone, 0, 2);
        world.setBlock(i + 7, j + 9, k + 39, Blocks.end_stone, 0, 2);
        world.setBlock(i + 8, j + 9, k + 39, Blocks.end_stone, 0, 2);
        world.setBlock(i + 9, j + 9, k + 39, Blocks.end_stone, 0, 2);
        world.setBlock(i + 16, j + 9, k + 39, PlacePurpurBrickStairs, 4, 2);
        world.setBlock(i + 17, j + 9, k + 39, Blocks.glowstone, 0, 2);
        world.setBlock(i + 18, j + 9, k + 39, PlacePurpurBrickStairs, 5, 2);
        world.setBlock(i + 3, j + 9, k + 40, Blocks.end_stone, 0, 2);
        world.setBlock(i + 4, j + 9, k + 40, Blocks.end_stone, 0, 2);
        world.setBlock(i + 5, j + 9, k + 40, Blocks.end_stone, 0, 2);
        world.setBlock(i + 6, j + 9, k + 40, Blocks.end_stone, 0, 2);
        world.setBlock(i + 7, j + 9, k + 40, Blocks.end_stone, 0, 2);
        world.setBlock(i + 8, j + 9, k + 40, Blocks.end_stone, 0, 2);
        world.setBlock(i + 9, j + 9, k + 40, Blocks.end_stone, 0, 2);
        world.setBlock(i + 16, j + 9, k + 40, PlacePurpurBrickStairs, 4, 2);
        world.setBlock(i + 17, j + 9, k + 40, Blocks.glowstone, 0, 2);
        world.setBlock(i + 18, j + 9, k + 40, PlacePurpurBrickStairs, 5, 2);
        world.setBlock(i + 4, j + 9, k + 41, Blocks.end_stone, 0, 2);
        world.setBlock(i + 5, j + 9, k + 41, Blocks.end_stone, 0, 2);
        world.setBlock(i + 6, j + 9, k + 41, Blocks.end_stone, 0, 2);
        world.setBlock(i + 7, j + 9, k + 41, Blocks.end_stone, 0, 2);
        world.setBlock(i + 8, j + 9, k + 41, Blocks.end_stone, 0, 2);
        world.setBlock(i + 10, j + 9, k + 41, placeChorusFlower(random), 0, 2);
        world.setBlock(i + 16, j + 9, k + 41, PlacePurpurBrickStairs, 4, 2);
        world.setBlock(i + 17, j + 9, k + 41, Blocks.glowstone, 0, 2);
        world.setBlock(i + 18, j + 9, k + 41, PlacePurpurBrickStairs, 5, 2);
        world.setBlock(i + 4, j + 9, k + 42, Blocks.end_stone, 0, 2);
        world.setBlock(i + 5, j + 9, k + 42, Blocks.end_stone, 0, 2);
        world.setBlock(i + 6, j + 9, k + 42, Blocks.end_stone, 0, 2);
        world.setBlock(i + 7, j + 9, k + 42, Blocks.end_stone, 0, 2);
        world.setBlock(i + 8, j + 9, k + 42, Blocks.end_stone, 0, 2);
        world.setBlock(i + 16, j + 9, k + 42, PlacePurpurBrickStairs, 7, 2);
        world.setBlock(i + 17, j + 9, k + 42, PlacePurpurPillar, 0, 2);
        world.setBlock(i + 18, j + 9, k + 42, PlacePurpurBrickStairs, 7, 2);
        world.setBlock(i + 21, j + 9, k + 42, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 6, j + 9, k + 43, Blocks.end_stone, 0, 2);
        world.setBlock(i + 7, j + 9, k + 43, Blocks.end_stone, 0, 2);
        world.setBlock(i + 6, j + 9, k + 44, placeChorusFlower(random), 0, 2);
        world.setBlock(i + 41, j + 9, k + 44, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 42, j + 9, k + 44, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 44, j + 10, k + 8, Blocks.end_stone, 0, 2);
        world.setBlock(i + 45, j + 10, k + 8, Blocks.end_stone, 0, 2);
        world.setBlock(i + 46, j + 10, k + 8, Blocks.end_stone, 0, 2);
        world.setBlock(i + 47, j + 10, k + 8, Blocks.end_stone, 0, 2);
        world.setBlock(i + 48, j + 10, k + 8, Blocks.end_stone, 0, 2);
        world.setBlock(i + 43, j + 10, k + 9, Blocks.end_stone, 0, 2);
        world.setBlock(i + 44, j + 10, k + 9, Blocks.end_stone, 0, 2);
        world.setBlock(i + 45, j + 10, k + 9, Blocks.end_stone, 0, 2);
        world.setBlock(i + 46, j + 10, k + 9, Blocks.end_stone, 0, 2);
        world.setBlock(i + 47, j + 10, k + 9, Blocks.end_stone, 0, 2);
        world.setBlock(i + 48, j + 10, k + 9, Blocks.end_stone, 0, 2);
        world.setBlock(i + 49, j + 10, k + 9, Blocks.end_stone, 0, 2);
        world.setBlock(i + 42, j + 10, k + 10, Blocks.end_stone, 0, 2);
        world.setBlock(i + 43, j + 10, k + 10, Blocks.end_stone, 0, 2);
        world.setBlock(i + 44, j + 10, k + 10, Blocks.end_stone, 0, 2);
        world.setBlock(i + 45, j + 10, k + 10, Blocks.end_stone, 0, 2);
        world.setBlock(i + 46, j + 10, k + 10, Blocks.end_stone, 0, 2);
        world.setBlock(i + 47, j + 10, k + 10, Blocks.end_stone, 0, 2);
        world.setBlock(i + 48, j + 10, k + 10, Blocks.end_stone, 0, 2);
        world.setBlock(i + 49, j + 10, k + 10, Blocks.end_stone, 0, 2);
        world.setBlock(i + 50, j + 10, k + 10, Blocks.end_stone, 0, 2);
        world.setBlock(i + 41, j + 10, k + 11, Blocks.end_stone, 0, 2);
        world.setBlock(i + 42, j + 10, k + 11, Blocks.end_stone, 0, 2);
        world.setBlock(i + 43, j + 10, k + 11, Blocks.end_stone, 0, 2);
        world.setBlock(i + 44, j + 10, k + 11, Blocks.end_stone, 0, 2);
        world.setBlock(i + 45, j + 10, k + 11, Blocks.end_stone, 0, 2);
        world.setBlock(i + 46, j + 10, k + 11, Blocks.end_stone, 0, 2);
        world.setBlock(i + 47, j + 10, k + 11, Blocks.end_stone, 0, 2);
        world.setBlock(i + 48, j + 10, k + 11, Blocks.end_stone, 0, 2);
        world.setBlock(i + 49, j + 10, k + 11, Blocks.end_stone, 0, 2);
        world.setBlock(i + 50, j + 10, k + 11, Blocks.end_stone, 0, 2);
        world.setBlock(i + 51, j + 10, k + 11, Blocks.end_stone, 0, 2);
        world.setBlock(i + 41, j + 10, k + 12, Blocks.end_stone, 0, 2);
        world.setBlock(i + 42, j + 10, k + 12, Blocks.end_stone, 0, 2);
        world.setBlock(i + 43, j + 10, k + 12, Blocks.end_stone, 0, 2);
        world.setBlock(i + 44, j + 10, k + 12, Blocks.end_stone, 0, 2);
        world.setBlock(i + 45, j + 10, k + 12, Blocks.end_stone, 0, 2);
        world.setBlock(i + 46, j + 10, k + 12, Blocks.end_stone, 0, 2);
        world.setBlock(i + 47, j + 10, k + 12, Blocks.end_stone, 0, 2);
        world.setBlock(i + 48, j + 10, k + 12, Blocks.end_stone, 0, 2);
        world.setBlock(i + 49, j + 10, k + 12, Blocks.end_stone, 0, 2);
        world.setBlock(i + 50, j + 10, k + 12, Blocks.end_stone, 0, 2);
        world.setBlock(i + 51, j + 10, k + 12, Blocks.end_stone, 0, 2);
        world.setBlock(i + 41, j + 10, k + 13, Blocks.end_stone, 0, 2);
        world.setBlock(i + 42, j + 10, k + 13, Blocks.end_stone, 0, 2);
        world.setBlock(i + 43, j + 10, k + 13, Blocks.end_stone, 0, 2);
        world.setBlock(i + 44, j + 10, k + 13, Blocks.end_stone, 0, 2);
        world.setBlock(i + 45, j + 10, k + 13, Blocks.end_stone, 0, 2);
        world.setBlock(i + 46, j + 10, k + 13, Blocks.end_stone, 0, 2);
        world.setBlock(i + 47, j + 10, k + 13, Blocks.end_stone, 0, 2);
        world.setBlock(i + 48, j + 10, k + 13, Blocks.end_stone, 0, 2);
        world.setBlock(i + 49, j + 10, k + 13, Blocks.end_stone, 0, 2);
        world.setBlock(i + 50, j + 10, k + 13, Blocks.end_stone, 0, 2);
        world.setBlock(i + 51, j + 10, k + 13, Blocks.end_stone, 0, 2);
        world.setBlock(i + 41, j + 10, k + 14, Blocks.end_stone, 0, 2);
        world.setBlock(i + 42, j + 10, k + 14, Blocks.end_stone, 0, 2);
        world.setBlock(i + 43, j + 10, k + 14, Blocks.end_stone, 0, 2);
        world.setBlock(i + 44, j + 10, k + 14, Blocks.end_stone, 0, 2);
        world.setBlock(i + 45, j + 10, k + 14, Blocks.end_stone, 0, 2);
        world.setBlock(i + 46, j + 10, k + 14, Blocks.end_stone, 0, 2);
        world.setBlock(i + 47, j + 10, k + 14, Blocks.end_stone, 0, 2);
        world.setBlock(i + 48, j + 10, k + 14, Blocks.end_stone, 0, 2);
        world.setBlock(i + 49, j + 10, k + 14, Blocks.end_stone, 0, 2);
        world.setBlock(i + 50, j + 10, k + 14, Blocks.end_stone, 0, 2);
        world.setBlock(i + 51, j + 10, k + 14, Blocks.end_stone, 0, 2);
        world.setBlock(i + 41, j + 10, k + 15, Blocks.end_stone, 0, 2);
        world.setBlock(i + 42, j + 10, k + 15, Blocks.end_stone, 0, 2);
        world.setBlock(i + 43, j + 10, k + 15, Blocks.end_stone, 0, 2);
        world.setBlock(i + 44, j + 10, k + 15, Blocks.end_stone, 0, 2);
        world.setBlock(i + 45, j + 10, k + 15, Blocks.end_stone, 0, 2);
        world.setBlock(i + 46, j + 10, k + 15, Blocks.end_stone, 0, 2);
        world.setBlock(i + 47, j + 10, k + 15, Blocks.end_stone, 0, 2);
        world.setBlock(i + 48, j + 10, k + 15, Blocks.end_stone, 0, 2);
        world.setBlock(i + 49, j + 10, k + 15, Blocks.end_stone, 0, 2);
        world.setBlock(i + 50, j + 10, k + 15, Blocks.end_stone, 0, 2);
        world.setBlock(i + 51, j + 10, k + 15, Blocks.end_stone, 0, 2);
        world.setBlock(i + 41, j + 10, k + 16, Blocks.end_stone, 0, 2);
        world.setBlock(i + 42, j + 10, k + 16, Blocks.end_stone, 0, 2);
        world.setBlock(i + 43, j + 10, k + 16, Blocks.end_stone, 0, 2);
        world.setBlock(i + 44, j + 10, k + 16, Blocks.end_stone, 0, 2);
        world.setBlock(i + 45, j + 10, k + 16, Blocks.end_stone, 0, 2);
        world.setBlock(i + 46, j + 10, k + 16, Blocks.end_stone, 0, 2);
        world.setBlock(i + 47, j + 10, k + 16, Blocks.end_stone, 0, 2);
        world.setBlock(i + 48, j + 10, k + 16, Blocks.end_stone, 0, 2);
        world.setBlock(i + 49, j + 10, k + 16, Blocks.end_stone, 0, 2);
        world.setBlock(i + 50, j + 10, k + 16, Blocks.end_stone, 0, 2);
        world.setBlock(i + 19, j + 10, k + 17, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 20, j + 10, k + 17, NovaCraftBlocks.frontierslate_brick_stairs, 1, 2);
        world.setBlock(i + 41, j + 10, k + 17, Blocks.end_stone, 0, 2);
        world.setBlock(i + 42, j + 10, k + 17, Blocks.end_stone, 0, 2);
        world.setBlock(i + 43, j + 10, k + 17, Blocks.end_stone, 0, 2);
        world.setBlock(i + 44, j + 10, k + 17, Blocks.end_stone, 0, 2);
        world.setBlock(i + 45, j + 10, k + 17, Blocks.end_stone, 0, 2);
        world.setBlock(i + 46, j + 10, k + 17, Blocks.end_stone, 0, 2);
        world.setBlock(i + 47, j + 10, k + 17, Blocks.end_stone, 0, 2);
        world.setBlock(i + 48, j + 10, k + 17, Blocks.end_stone, 0, 2);
        world.setBlock(i + 49, j + 10, k + 17, Blocks.end_stone, 0, 2);
        world.setBlock(i + 42, j + 10, k + 18, Blocks.end_stone, 0, 2);
        world.setBlock(i + 43, j + 10, k + 18, Blocks.end_stone, 0, 2);
        world.setBlock(i + 44, j + 10, k + 18, Blocks.end_stone, 0, 2);
        world.setBlock(i + 45, j + 10, k + 18, Blocks.end_stone, 0, 2);
        world.setBlock(i + 46, j + 10, k + 18, Blocks.end_stone, 0, 2);
        world.setBlock(i + 47, j + 10, k + 18, Blocks.end_stone, 0, 2);
        world.setBlock(i + 48, j + 10, k + 18, Blocks.end_stone, 0, 2);
        world.setBlock(i + 27, j + 10, k + 20, PlacePurpurBrickStairs, 2, 2);
        world.setBlock(i + 28, j + 10, k + 20, PlacePurpurBrickStairs, 2, 2);
        world.setBlock(i + 29, j + 10, k + 20, PlacePurpurBrickStairs, 2, 2);
        world.setBlock(i + 26, j + 10, k + 21, PlacePurpurBrickStairs, 0, 2);
        world.setBlock(i + 27, j + 10, k + 21, Blocks.obsidian, 0, 2);
        world.setBlock(i + 28, j + 10, k + 21, Blocks.obsidian, 0, 2);
        world.setBlock(i + 29, j + 10, k + 21, PlacePurpurBrickStairs, 1, 2);
        world.setBlock(i + 32, j + 10, k + 21, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 26, j + 10, k + 22, PlacePurpurBrickStairs, 0, 2);
        world.setBlock(i + 27, j + 10, k + 22, Blocks.obsidian, 0, 2);
        world.setBlock(i + 28, j + 10, k + 22, Blocks.obsidian, 0, 2);
        world.setBlock(i + 29, j + 10, k + 22, PlacePurpurBrickStairs, 1, 2);
        world.setBlock(i + 26, j + 10, k + 23, PlacePurpurBrickStairs, 3, 2);
        world.setBlock(i + 27, j + 10, k + 23, PlacePurpurBrickStairs, 3, 2);
        world.setBlock(i + 28, j + 10, k + 23, PlacePurpurBrickStairs, 3, 2);
        world.setBlock(i + 32, j + 10, k + 24, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 32, j + 10, k + 25, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 27, j + 10, k + 26, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 30, j + 10, k + 26, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 31, j + 10, k + 26, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 32, j + 10, k + 26, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 33, j + 10, k + 26, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 34, j + 10, k + 26, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 37, j + 10, k + 26, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 32, j + 10, k + 27, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 32, j + 10, k + 28, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 26, j + 10, k + 30, PlacePurpurBrickStairs, 0, 2);
        world.setBlock(i + 27, j + 10, k + 30, PlacePurpurBrickStairs, 2, 2);
        world.setBlock(i + 37, j + 10, k + 30, PlacePurpurBrickStairs, 2, 2);
        world.setBlock(i + 38, j + 10, k + 30, PlacePurpurBrickStairs, 2, 2);
        world.setBlock(i + 26, j + 10, k + 31, PlacePurpurBrickStairs, 0, 2);
        world.setBlock(i + 27, j + 10, k + 31, Blocks.obsidian, 0, 2);
        world.setBlock(i + 28, j + 10, k + 31, PlacePurpurBrickStairs, 1, 2);
        world.setBlock(i + 32, j + 10, k + 31, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 36, j + 10, k + 31, PlacePurpurBrickStairs, 0, 2);
        world.setBlock(i + 37, j + 10, k + 31, Blocks.obsidian, 0, 2);
        world.setBlock(i + 38, j + 10, k + 31, PlacePurpurBrickStairs, 1, 2);
        world.setBlock(i + 27, j + 10, k + 32, PlacePurpurBrickStairs, 3, 2);
        world.setBlock(i + 28, j + 10, k + 32, PlacePurpurBrickStairs, 1, 2);
        world.setBlock(i + 36, j + 10, k + 32, PlacePurpurBrickStairs, 0, 2);
        world.setBlock(i + 37, j + 10, k + 32, PlacePurpurBrickStairs, 3, 2);
        world.setBlock(i + 32, j + 10, k + 36, placeChorusFlower(random), 0, 2);
        world.setBlock(i + 5, j + 10, k + 38, Blocks.end_stone, 0, 2);
        world.setBlock(i + 6, j + 10, k + 38, Blocks.end_stone, 0, 2);
        world.setBlock(i + 17, j + 10, k + 38, PlacePurpurBrickStairs, 2, 2);
        world.setBlock(i + 5, j + 10, k + 39, Blocks.end_stone, 0, 2);
        world.setBlock(i + 6, j + 10, k + 39, Blocks.end_stone, 0, 2);
        world.setBlock(i + 7, j + 10, k + 39, Blocks.end_stone, 0, 2);
        world.setBlock(i + 16, j + 10, k + 39, PlacePurpurBrickStairs, 0, 2);
        world.setBlock(i + 17, j + 10, k + 39, Blocks.obsidian, 0, 2);
        world.setBlock(i + 18, j + 10, k + 39, PlacePurpurBrickStairs, 1, 2);
        world.setBlock(i + 3, j + 10, k + 40, placeChorusFlower(random), 0, 2);
        world.setBlock(i + 5, j + 10, k + 40, Blocks.end_stone, 0, 2);
        world.setBlock(i + 6, j + 10, k + 40, Blocks.end_stone, 0, 2);
        world.setBlock(i + 7, j + 10, k + 40, Blocks.end_stone, 0, 2);
        world.setBlock(i + 16, j + 10, k + 40, PlacePurpurBrickStairs, 0, 2);
        world.setBlock(i + 17, j + 10, k + 40, Blocks.obsidian, 0, 2);
        world.setBlock(i + 18, j + 10, k + 40, PlacePurpurBrickStairs, 1, 2);
        world.setBlock(i + 4, j + 10, k + 41, Blocks.end_stone, 0, 2);
        world.setBlock(i + 5, j + 10, k + 41, Blocks.end_stone, 0, 2);
        world.setBlock(i + 6, j + 10, k + 41, Blocks.end_stone, 0, 2);
        world.setBlock(i + 7, j + 10, k + 41, Blocks.end_stone, 0, 2);
        world.setBlock(i + 16, j + 10, k + 41, PlacePurpurBrickStairs, 0, 2);
        world.setBlock(i + 17, j + 10, k + 41, Blocks.obsidian, 0, 2);
        world.setBlock(i + 18, j + 10, k + 41, PlacePurpurBrickStairs, 1, 2);
        world.setBlock(i + 5, j + 10, k + 42, Blocks.end_stone, 0, 2);
        world.setBlock(i + 6, j + 10, k + 42, Blocks.end_stone, 0, 2);
        world.setBlock(i + 17, j + 10, k + 42, PlacePurpurBrickStairs, 3, 2);
        world.setBlock(i + 48, j + 11, k + 8, placeChorusFlower(random), 0, 2);
        world.setBlock(i + 44, j + 11, k + 9, Blocks.end_stone, 0, 2);
        world.setBlock(i + 45, j + 11, k + 9, Blocks.end_stone, 0, 2);
        world.setBlock(i + 46, j + 11, k + 9, Blocks.end_stone, 0, 2);
        world.setBlock(i + 47, j + 11, k + 9, Blocks.end_stone, 0, 2);
        world.setBlock(i + 48, j + 11, k + 9, Blocks.end_stone, 0, 2);
        world.setBlock(i + 43, j + 11, k + 10, Blocks.end_stone, 0, 2);
        world.setBlock(i + 44, j + 11, k + 10, Blocks.end_stone, 0, 2);
        world.setBlock(i + 45, j + 11, k + 10, Blocks.end_stone, 0, 2);
        world.setBlock(i + 46, j + 11, k + 10, Blocks.end_stone, 0, 2);
        world.setBlock(i + 47, j + 11, k + 10, Blocks.end_stone, 0, 2);
        world.setBlock(i + 48, j + 11, k + 10, Blocks.end_stone, 0, 2);
        world.setBlock(i + 49, j + 11, k + 10, Blocks.end_stone, 0, 2);
        world.setBlock(i + 42, j + 11, k + 11, Blocks.end_stone, 0, 2);
        world.setBlock(i + 43, j + 11, k + 11, Blocks.end_stone, 0, 2);
        world.setBlock(i + 44, j + 11, k + 11, Blocks.end_stone, 0, 2);
        world.setBlock(i + 45, j + 11, k + 11, Blocks.end_stone, 0, 2);
        world.setBlock(i + 46, j + 11, k + 11, Blocks.end_stone, 0, 2);
        world.setBlock(i + 47, j + 11, k + 11, Blocks.end_stone, 0, 2);
        world.setBlock(i + 48, j + 11, k + 11, Blocks.end_stone, 0, 2);
        world.setBlock(i + 49, j + 11, k + 11, Blocks.end_stone, 0, 2);
        world.setBlock(i + 50, j + 11, k + 11, Blocks.end_stone, 0, 2);
        world.setBlock(i + 42, j + 11, k + 12, Blocks.end_stone, 0, 2);
        world.setBlock(i + 43, j + 11, k + 12, Blocks.end_stone, 0, 2);
        world.setBlock(i + 44, j + 11, k + 12, Blocks.end_stone, 0, 2);
        world.setBlock(i + 45, j + 11, k + 12, Blocks.end_stone, 0, 2);
        world.setBlock(i + 46, j + 11, k + 12, Blocks.end_stone, 0, 2);
        world.setBlock(i + 47, j + 11, k + 12, Blocks.end_stone, 0, 2);
        world.setBlock(i + 48, j + 11, k + 12, Blocks.end_stone, 0, 2);
        world.setBlock(i + 49, j + 11, k + 12, Blocks.end_stone, 0, 2);
        world.setBlock(i + 50, j + 11, k + 12, Blocks.end_stone, 0, 2);
        world.setBlock(i + 42, j + 11, k + 13, Blocks.end_stone, 0, 2);
        world.setBlock(i + 43, j + 11, k + 13, Blocks.end_stone, 0, 2);
        world.setBlock(i + 44, j + 11, k + 13, Blocks.end_stone, 0, 2);
        world.setBlock(i + 45, j + 11, k + 13, Blocks.end_stone, 0, 2);
        world.setBlock(i + 46, j + 11, k + 13, Blocks.end_stone, 0, 2);
        world.setBlock(i + 47, j + 11, k + 13, Blocks.end_stone, 0, 2);
        world.setBlock(i + 48, j + 11, k + 13, Blocks.end_stone, 0, 2);
        world.setBlock(i + 49, j + 11, k + 13, Blocks.end_stone, 0, 2);
        world.setBlock(i + 50, j + 11, k + 13, Blocks.end_stone, 0, 2);
        world.setBlock(i + 42, j + 11, k + 14, Blocks.end_stone, 0, 2);
        world.setBlock(i + 43, j + 11, k + 14, Blocks.end_stone, 0, 2);
        world.setBlock(i + 44, j + 11, k + 14, Blocks.end_stone, 0, 2);
        world.setBlock(i + 45, j + 11, k + 14, Blocks.end_stone, 0, 2);
        world.setBlock(i + 46, j + 11, k + 14, Blocks.end_stone, 0, 2);
        world.setBlock(i + 47, j + 11, k + 14, Blocks.end_stone, 0, 2);
        world.setBlock(i + 48, j + 11, k + 14, Blocks.end_stone, 0, 2);
        world.setBlock(i + 49, j + 11, k + 14, Blocks.end_stone, 0, 2);
        world.setBlock(i + 50, j + 11, k + 14, Blocks.end_stone, 0, 2);
        world.setBlock(i + 42, j + 11, k + 15, Blocks.end_stone, 0, 2);
        world.setBlock(i + 43, j + 11, k + 15, Blocks.end_stone, 0, 2);
        world.setBlock(i + 44, j + 11, k + 15, Blocks.end_stone, 0, 2);
        world.setBlock(i + 45, j + 11, k + 15, Blocks.end_stone, 0, 2);
        world.setBlock(i + 46, j + 11, k + 15, Blocks.end_stone, 0, 2);
        world.setBlock(i + 47, j + 11, k + 15, Blocks.end_stone, 0, 2);
        world.setBlock(i + 48, j + 11, k + 15, Blocks.end_stone, 0, 2);
        world.setBlock(i + 49, j + 11, k + 15, Blocks.end_stone, 0, 2);
        world.setBlock(i + 50, j + 11, k + 15, Blocks.end_stone, 0, 2);
        world.setBlock(i + 51, j + 11, k + 15, placeChorusFlower(random), 0, 2);
        world.setBlock(i + 42, j + 11, k + 16, Blocks.end_stone, 0, 2);
        world.setBlock(i + 43, j + 11, k + 16, Blocks.end_stone, 0, 2);
        world.setBlock(i + 44, j + 11, k + 16, Blocks.end_stone, 0, 2);
        world.setBlock(i + 45, j + 11, k + 16, Blocks.end_stone, 0, 2);
        world.setBlock(i + 46, j + 11, k + 16, Blocks.end_stone, 0, 2);
        world.setBlock(i + 47, j + 11, k + 16, Blocks.end_stone, 0, 2);
        world.setBlock(i + 48, j + 11, k + 16, Blocks.end_stone, 0, 2);
        world.setBlock(i + 49, j + 11, k + 16, Blocks.end_stone, 0, 2);
        world.setBlock(i + 42, j + 11, k + 17, Blocks.end_stone, 0, 2);
        world.setBlock(i + 43, j + 11, k + 17, Blocks.end_stone, 0, 2);
        world.setBlock(i + 44, j + 11, k + 17, Blocks.end_stone, 0, 2);
        world.setBlock(i + 45, j + 11, k + 17, Blocks.end_stone, 0, 2);
        world.setBlock(i + 46, j + 11, k + 17, Blocks.end_stone, 0, 2);
        world.setBlock(i + 47, j + 11, k + 17, Blocks.end_stone, 0, 2);
        world.setBlock(i + 48, j + 11, k + 17, Blocks.end_stone, 0, 2);
        world.setBlock(i + 32, j + 11, k + 21, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 32, j + 11, k + 22, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 27, j + 11, k + 26, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 28, j + 11, k + 26, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 32, j + 11, k + 26, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 36, j + 11, k + 26, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 37, j + 11, k + 26, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 32, j + 11, k + 31, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 6, j + 11, k + 40, placeChorusFlower(random), 0, 2);
        world.setBlock(i + 44, j + 12, k + 10, Blocks.end_stone, 0, 2);
        world.setBlock(i + 45, j + 12, k + 10, Blocks.end_stone, 0, 2);
        world.setBlock(i + 46, j + 12, k + 10, Blocks.end_stone, 0, 2);
        world.setBlock(i + 47, j + 12, k + 10, Blocks.end_stone, 0, 2);
        world.setBlock(i + 48, j + 12, k + 10, Blocks.end_stone, 0, 2);
        world.setBlock(i + 43, j + 12, k + 11, Blocks.end_stone, 0, 2);
        world.setBlock(i + 44, j + 12, k + 11, Blocks.end_stone, 0, 2);
        world.setBlock(i + 45, j + 12, k + 11, Blocks.end_stone, 0, 2);
        world.setBlock(i + 46, j + 12, k + 11, Blocks.end_stone, 0, 2);
        world.setBlock(i + 47, j + 12, k + 11, Blocks.end_stone, 0, 2);
        world.setBlock(i + 48, j + 12, k + 11, Blocks.end_stone, 0, 2);
        world.setBlock(i + 49, j + 12, k + 11, Blocks.end_stone, 0, 2);
        world.setBlock(i + 42, j + 12, k + 12, Blocks.end_stone, 0, 2);
        world.setBlock(i + 43, j + 12, k + 12, Blocks.end_stone, 0, 2);
        world.setBlock(i + 44, j + 12, k + 12, Blocks.end_stone, 0, 2);
        world.setBlock(i + 45, j + 12, k + 12, Blocks.end_stone, 0, 2);
        world.setBlock(i + 46, j + 12, k + 12, Blocks.end_stone, 0, 2);
        world.setBlock(i + 47, j + 12, k + 12, Blocks.end_stone, 0, 2);
        world.setBlock(i + 48, j + 12, k + 12, Blocks.end_stone, 0, 2);
        world.setBlock(i + 49, j + 12, k + 12, Blocks.end_stone, 0, 2);
        world.setBlock(i + 43, j + 12, k + 13, Blocks.end_stone, 0, 2);
        world.setBlock(i + 44, j + 12, k + 13, Blocks.end_stone, 0, 2);
        world.setBlock(i + 45, j + 12, k + 13, Blocks.end_stone, 0, 2);
        world.setBlock(i + 46, j + 12, k + 13, Blocks.end_stone, 0, 2);
        world.setBlock(i + 47, j + 12, k + 13, Blocks.end_stone, 0, 2);
        world.setBlock(i + 48, j + 12, k + 13, Blocks.end_stone, 0, 2);
        world.setBlock(i + 49, j + 12, k + 13, Blocks.end_stone, 0, 2);
        world.setBlock(i + 43, j + 12, k + 14, Blocks.end_stone, 0, 2);
        world.setBlock(i + 44, j + 12, k + 14, Blocks.end_stone, 0, 2);
        world.setBlock(i + 45, j + 12, k + 14, Blocks.end_stone, 0, 2);
        world.setBlock(i + 46, j + 12, k + 14, Blocks.end_stone, 0, 2);
        world.setBlock(i + 47, j + 12, k + 14, Blocks.end_stone, 0, 2);
        world.setBlock(i + 48, j + 12, k + 14, Blocks.end_stone, 0, 2);
        world.setBlock(i + 49, j + 12, k + 14, Blocks.end_stone, 0, 2);
        world.setBlock(i + 43, j + 12, k + 15, Blocks.end_stone, 0, 2);
        world.setBlock(i + 44, j + 12, k + 15, Blocks.end_stone, 0, 2);
        world.setBlock(i + 45, j + 12, k + 15, Blocks.end_stone, 0, 2);
        world.setBlock(i + 46, j + 12, k + 15, Blocks.end_stone, 0, 2);
        world.setBlock(i + 47, j + 12, k + 15, Blocks.end_stone, 0, 2);
        world.setBlock(i + 48, j + 12, k + 15, Blocks.end_stone, 0, 2);
        world.setBlock(i + 49, j + 12, k + 15, Blocks.end_stone, 0, 2);
        world.setBlock(i + 43, j + 12, k + 16, Blocks.end_stone, 0, 2);
        world.setBlock(i + 44, j + 12, k + 16, Blocks.end_stone, 0, 2);
        world.setBlock(i + 45, j + 12, k + 16, Blocks.end_stone, 0, 2);
        world.setBlock(i + 46, j + 12, k + 16, Blocks.end_stone, 0, 2);
        world.setBlock(i + 47, j + 12, k + 16, Blocks.end_stone, 0, 2);
        world.setBlock(i + 48, j + 12, k + 16, Blocks.end_stone, 0, 2);
        world.setBlock(i + 44, j + 12, k + 17, Blocks.end_stone, 0, 2);
        world.setBlock(i + 47, j + 12, k + 17, placeChorusFlower(random), 0, 2);
        world.setBlock(i + 32, j + 12, k + 22, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 32, j + 12, k + 23, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 28, j + 12, k + 26, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 29, j + 12, k + 26, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 32, j + 12, k + 26, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 35, j + 12, k + 26, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 36, j + 12, k + 26, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 32, j + 12, k + 29, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 32, j + 12, k + 30, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 32, j + 12, k + 31, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 44, j + 13, k + 10, placeChorusFlower(random), 0, 2);
        world.setBlock(i + 45, j + 13, k + 10, Blocks.end_stone, 0, 2);
        world.setBlock(i + 44, j + 13, k + 11, Blocks.end_stone, 0, 2);
        world.setBlock(i + 45, j + 13, k + 11, Blocks.end_stone, 0, 2);
        world.setBlock(i + 46, j + 13, k + 11, Blocks.end_stone, 0, 2);
        world.setBlock(i + 47, j + 13, k + 11, Blocks.end_stone, 0, 2);
        world.setBlock(i + 44, j + 13, k + 12, Blocks.end_stone, 0, 2);
        world.setBlock(i + 45, j + 13, k + 12, Blocks.end_stone, 0, 2);
        world.setBlock(i + 46, j + 13, k + 12, Blocks.end_stone, 0, 2);
        world.setBlock(i + 47, j + 13, k + 12, Blocks.end_stone, 0, 2);
        world.setBlock(i + 48, j + 13, k + 12, Blocks.end_stone, 0, 2);
        world.setBlock(i + 44, j + 13, k + 13, Blocks.end_stone, 0, 2);
        world.setBlock(i + 45, j + 13, k + 13, Blocks.end_stone, 0, 2);
        world.setBlock(i + 46, j + 13, k + 13, Blocks.end_stone, 0, 2);
        world.setBlock(i + 47, j + 13, k + 13, Blocks.end_stone, 0, 2);
        world.setBlock(i + 48, j + 13, k + 13, Blocks.end_stone, 0, 2);
        world.setBlock(i + 49, j + 13, k + 13, placeChorusFlower(random), 0, 2);
        world.setBlock(i + 44, j + 13, k + 14, Blocks.end_stone, 0, 2);
        world.setBlock(i + 45, j + 13, k + 14, Blocks.end_stone, 0, 2);
        world.setBlock(i + 46, j + 13, k + 14, Blocks.end_stone, 0, 2);
        world.setBlock(i + 47, j + 13, k + 14, Blocks.end_stone, 0, 2);
        world.setBlock(i + 48, j + 13, k + 14, Blocks.end_stone, 0, 2);
        world.setBlock(i + 43, j + 13, k + 15, placeChorusFlower(random), 0, 2);
        world.setBlock(i + 44, j + 13, k + 15, Blocks.end_stone, 0, 2);
        world.setBlock(i + 45, j + 13, k + 15, Blocks.end_stone, 0, 2);
        world.setBlock(i + 46, j + 13, k + 15, Blocks.end_stone, 0, 2);
        world.setBlock(i + 47, j + 13, k + 15, Blocks.end_stone, 0, 2);
        world.setBlock(i + 30, j + 13, k + 23, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 31, j + 13, k + 23, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 32, j + 13, k + 23, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 33, j + 13, k + 23, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 34, j + 13, k + 23, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 29, j + 13, k + 24, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 30, j + 13, k + 24, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 32, j + 13, k + 24, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 34, j + 13, k + 24, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 35, j + 13, k + 24, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 29, j + 13, k + 25, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 32, j + 13, k + 25, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 34, j + 13, k + 25, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 29, j + 13, k + 26, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 30, j + 13, k + 26, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 31, j + 13, k + 26, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 32, j + 13, k + 26, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 33, j + 13, k + 26, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 34, j + 13, k + 26, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 35, j + 13, k + 26, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 29, j + 13, k + 27, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 32, j + 13, k + 27, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 34, j + 13, k + 27, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 29, j + 13, k + 28, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 30, j + 13, k + 28, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 32, j + 13, k + 28, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 34, j + 13, k + 28, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 30, j + 13, k + 29, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 31, j + 13, k + 29, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 32, j + 13, k + 29, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 33, j + 13, k + 29, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 34, j + 13, k + 29, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 35, j + 13, k + 29, PlaceEndstoneBrickWall, 0, 2);
        world.setBlock(i + 45, j + 14, k + 12, Blocks.end_stone, 0, 2);
        world.setBlock(i + 46, j + 14, k + 12, Blocks.end_stone, 0, 2);
        world.setBlock(i + 47, j + 14, k + 12, Blocks.end_stone, 0, 2);
        world.setBlock(i + 45, j + 14, k + 13, Blocks.end_stone, 0, 2);
        world.setBlock(i + 46, j + 14, k + 13, Blocks.end_stone, 0, 2);
        world.setBlock(i + 47, j + 14, k + 13, Blocks.end_stone, 0, 2);
        world.setBlock(i + 44, j + 14, k + 14, Blocks.end_stone, 0, 2);
        world.setBlock(i + 45, j + 14, k + 14, Blocks.end_stone, 0, 2);
        world.setBlock(i + 46, j + 14, k + 14, Blocks.end_stone, 0, 2);
        world.setBlock(i + 47, j + 14, k + 14, Blocks.end_stone, 0, 2);
        world.setBlock(i + 46, j + 15, k + 13, Blocks.end_stone, 0, 2);
        world.setBlock(i + 46, j + 15, k + 14, Blocks.end_stone, 0, 2);
        world.setBlock(i + 47, j + 15, k + 14, Blocks.end_stone, 0, 2);
        world.setBlock(i + 46, j + 16, k + 13, placeChorusFlower(random), 0, 2);

        this.setBlockAndNotifyAdequately(world, i + 30, j + 5, k + 4, Blocks.chest, 4);
        TileEntity tile = world.getTileEntity(i + 30, j + 5, k + 4);
        if (tile instanceof TileEntityChest) {
            TileEntityChest chest = (TileEntityChest) tile;

            for (int slot = 0; slot < 3 + random.nextInt(20); slot++) {
                chest.setInventorySlotContents(random.nextInt(chest.getSizeInventory()), this.getEndLoot(random));
            }
        }

        this.setBlockAndNotifyAdequately(world, i + 43, j + 5, k + 10, Blocks.chest, 5);
        TileEntity tile2 = world.getTileEntity(i + 43, j + 5, k + 10);
        if (tile2 instanceof TileEntityChest) {
            TileEntityChest chest = (TileEntityChest) tile2;

            for (int slot = 0; slot < 3 + random.nextInt(20); slot++) {
                chest.setInventorySlotContents(random.nextInt(chest.getSizeInventory()), this.getOverworldLoot(random));
            }
        }

        this.setBlockAndNotifyAdequately(world, i + 6, j + 5, k + 19, Blocks.chest, 5);
        TileEntity tile3 = world.getTileEntity(i + 6, j + 5, k + 19);
        if (tile3 instanceof TileEntityChest) {
            TileEntityChest chest = (TileEntityChest) tile3;

            for (int slot = 0; slot < 3 + random.nextInt(20); slot++) {
                chest.setInventorySlotContents(random.nextInt(chest.getSizeInventory()), this.getEndLoot(random));
            }
        }

        this.setBlockAndNotifyAdequately(world, i + 4, j + 5, k + 42, Blocks.chest, 2);
        TileEntity tile4 = world.getTileEntity(i + 4, j + 5, k + 42);
        if (tile4 instanceof TileEntityChest) {
            TileEntityChest chest = (TileEntityChest) tile4;

            for (int slot = 0; slot < 3 + random.nextInt(20); slot++) {
                chest.setInventorySlotContents(random.nextInt(chest.getSizeInventory()), this.getOverworldLoot(random));
            }
        }

        this.setBlockAndNotifyAdequately(world, i + 39, j + 5, k + 45, Blocks.chest, 2);
        TileEntity tile5 = world.getTileEntity(i + 39, j + 5, k + 45);
        if (tile5 instanceof TileEntityChest) {
            TileEntityChest chest = (TileEntityChest) tile5;

            for (int slot = 0; slot < 3 + random.nextInt(20); slot++) {
                chest.setInventorySlotContents(random.nextInt(chest.getSizeInventory()), this.getEndLoot(random));
            }
        }

        this.setBlockAndNotifyAdequately(world, i + 27, j + 5, k + 48, Blocks.chest, 2);
        TileEntity tile6 = world.getTileEntity(i + 27, j + 5, k + 48);
        if (tile6 instanceof TileEntityChest) {
            TileEntityChest chest = (TileEntityChest) tile6;

            for (int slot = 0; slot < 3 + random.nextInt(20); slot++) {
                chest.setInventorySlotContents(random.nextInt(chest.getSizeInventory()), this.getEndLoot(random));
            }
        }

        this.setBlockAndNotifyAdequately(world, i + 50, j + 8, k + 11, Blocks.chest, 4);
        TileEntity tile7 = world.getTileEntity(i + 50, j + 8, k + 11);
        if (tile7 instanceof TileEntityChest) {
            TileEntityChest chest = (TileEntityChest) tile7;

            for (int slot = 0; slot < 3 + random.nextInt(20); slot++) {
                chest.setInventorySlotContents(random.nextInt(chest.getSizeInventory()), this.getOverworldLoot(random));
            }
        }

        this.setBlockAndNotifyAdequately(world, i + 50, j + 8, k + 12, Blocks.chest, 4);
        TileEntity tile8 = world.getTileEntity(i + 50, j + 8, k + 12);
        if (tile8 instanceof TileEntityChest) {
            TileEntityChest chest = (TileEntityChest) tile8;

            for (int slot = 0; slot < 3 + random.nextInt(20); slot++) {
                chest.setInventorySlotContents(random.nextInt(chest.getSizeInventory()), this.getOverworldLoot(random));
            }
        }

        world.setBlock(i + 25, j + 5, k + 3, Blocks.mob_spawner, 0, 2);
        TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner)world.getTileEntity(i + 25, j + 5, k + 3);

        if (tileentitymobspawner != null && random.nextBoolean()) {
            tileentitymobspawner.func_145881_a().setEntityName("nova_craft.void_cube");
        }
        else {
            tileentitymobspawner.func_145881_a().setEntityName("nova_craft.void_entity");
        }

        if (random.nextBoolean()) {
            EntityFrontierGolem entity = new EntityFrontierGolem(world);
            entity.setPosition(i + 25, j + 10, k + 3);

            if (!world.isRemote) {
                world.spawnEntityInWorld(entity);
            }
        }

        world.setBlock(i + 47, j + 5, k + 13, Blocks.mob_spawner, 0, 2);
        TileEntityMobSpawner tileentitymobspawner2 = (TileEntityMobSpawner)world.getTileEntity(i + 47, j + 5, k + 13);

        if (tileentitymobspawner2 != null) {
            tileentitymobspawner2.func_145881_a().setEntityName("nova_craft.void_entity");
        }

        world.setBlock(i + 6, j + 5, k + 23, Blocks.mob_spawner, 0, 2);
        TileEntityMobSpawner tileentitymobspawner3 = (TileEntityMobSpawner)world.getTileEntity(i + 6, j + 5, k + 23);

        if (tileentitymobspawner3 != null) {
            tileentitymobspawner3.func_145881_a().setEntityName("nova_craft.ender_ray");
        }

        world.setBlock(i + 34, j + 5, k + 25, Blocks.mob_spawner, 0, 2);
        TileEntityMobSpawner tileentitymobspawner4 = (TileEntityMobSpawner)world.getTileEntity(i + 34, j + 5, k + 25);

        if (tileentitymobspawner4 != null && random.nextBoolean()) {
            tileentitymobspawner4.func_145881_a().setEntityName("nova_craft.void_cube");
        }
        else {
            tileentitymobspawner4.func_145881_a().setEntityName("nova_craft.void_entity");
        }

        world.setBlock(i + 18, j + 5, k + 27, Blocks.mob_spawner, 0, 2);
        TileEntityMobSpawner tileentitymobspawner5 = (TileEntityMobSpawner)world.getTileEntity(i + 18, j + 5, k + 27);

        if (tileentitymobspawner5 != null && random.nextBoolean()) {
            tileentitymobspawner5.func_145881_a().setEntityName("nova_craft.void_cube");
        }
        else {
            tileentitymobspawner5.func_145881_a().setEntityName("nova_craft.void_entity");
        }

        world.setBlock(i + 44, j + 8, k + 15, Blocks.mob_spawner, 0, 2);
        TileEntityMobSpawner tileentitymobspawner6 = (TileEntityMobSpawner)world.getTileEntity(i + 44, j + 8, k + 15);

        if (tileentitymobspawner6 != null && random.nextBoolean()) {
            tileentitymobspawner6.func_145881_a().setEntityName("nova_craft.void_cube");
        }
        else {
            tileentitymobspawner6.func_145881_a().setEntityName("nova_craft.void_entity");
        }

        if (random.nextBoolean()) {
            EntityFrontierGolem entity = new EntityFrontierGolem(world);
            entity.setPosition(i + 44, j + 15, k + 15);

            if (!world.isRemote) {
                world.spawnEntityInWorld(entity);
            }
        }

        int ore_type = (int)(1 + Math.random() * 8);
        if (ore_type <= 6) {
            world.setBlock(i + 33, j + 6, k + 37, NovaCraftBlocks.klangite_ore, 0, 2);
        } else {
            world.setBlock(i + 33, j + 6, k + 37, NovaCraftBlocks.legendary_ore, 2, 2);
        }

        if (random.nextBoolean()) {
            EntityFrontierGolem entity = new EntityFrontierGolem(world);
            entity.setPosition(i + 33, j + 12, k + 37);

            if (!world.isRemote) {
                world.spawnEntityInWorld(entity);
            }
        }

        return true;
    }

    private Block placeEndStoneBricks(Random random) {
        if (random.nextDouble() < 0.98) {
            return PlaceEndstoneBricks;
        } else {
            return Blocks.air;
        }
    }

    private Block placeChorusFlower(Random random) {
        if (random.nextDouble() < 0.30) {
            return PlaceChorusFlower;
        } else {
            return Blocks.air;
        }
    }

    private Block placeEndStoneBrickStairs(Random random) {
        if (random.nextDouble() < 0.50) {
            return PlaceEndstoneBrickStairs;
        } else {
            return Blocks.air;
        }
    }

    private ItemStack getEndLoot(Random random) {
        int item = random.nextInt(35);
        switch (item) {
            case 0:
                return new ItemStack(NovaCraftItems.small_xancium_dust, random.nextInt(15) + 8);
            case 1:
                return new ItemStack(Items.ender_pearl, random.nextInt(4) + 6);
            case 2:
                return new ItemStack(Items.ender_pearl, random.nextInt(3) + 9);
            case 3:
                return new ItemStack(NovaCraftItems.vanite_bucket, random.nextInt(2) + 1);
            case 4:
                return new ItemStack(NovaCraftItems.static_essence, random.nextInt(6) + 4);
            case 5:
                return new ItemStack(NovaCraftItems.destitute_tentacle, 1);
            case 6:
                return new ItemStack(NovaCraftItems.crystallized_end_shard, 1);
            case 7:
                return new ItemStack(NovaCraftItems.anomalous_essence, random.nextInt(6) + 2);
            case 8:
                return new ItemStack(NovaCraftItems.tsavorokite_shard, random.nextInt(2) + 1);
            case 9:
                Enchantment enchantment = Enchantment.enchantmentsBookList[random.nextInt(Enchantment.enchantmentsBookList.length)];
                int maxLevel = enchantment.getMaxLevel();
                ItemStack itemStack = Items.enchanted_book.getEnchantedItemStack(new EnchantmentData(enchantment, maxLevel));

                return itemStack;
            case 10:
                Enchantment enchantment2 = Enchantment.enchantmentsBookList[random.nextInt(Enchantment.enchantmentsBookList.length)];
                int maxLevel2 = enchantment2.getMaxLevel();
                ItemStack itemStack2 = Items.enchanted_book.getEnchantedItemStack(new EnchantmentData(enchantment2, maxLevel2));

                return itemStack2;

            case 11:
                return new ItemStack(NovaCraftItems.copartz_shard, random.nextInt(2) + 1);
            case 12:
                return new ItemStack(NovaCraftItems.larimar_shard, random.nextInt(2) + 1);
            case 13:
                return new ItemStack(Items.experience_bottle, random.nextInt(4) + 3);
            case 14:
                return new ItemStack(Items.iron_ingot, random.nextInt(2) + 3);
            case 15:
                return new ItemStack(Items.gold_ingot, random.nextInt(2) + 3);
            case 16:
                return new ItemStack(NovaCraftItems.vanite_ingot, random.nextInt(3) + 3);
            case 17:
                return new ItemStack(Items.golden_apple, 1, 0);
            case 18:
                return new ItemStack(NovaCraftItems.relik_dust, random.nextInt(2) + 1);
            case 19:
                return new ItemStack(Items.ender_eye, random.nextInt(3) + 1);
            case 20:
                return new ItemStack(NovaCraftBlocks.frontierslate, random.nextInt(40) + 24);
            case 21:
                return new ItemStack(Blocks.end_stone, random.nextInt(40) + 24);
            case 22:
                return new ItemStack(Blocks.obsidian, random.nextInt(12) + 1);
            case 23:
                return new ItemStack(NovaCraftItems.iridium_nugget, random.nextInt(2) + 1, 2);
            default: {
                return new ItemStack(Blocks.end_stone, random.nextInt(40) + 24);
            }
        }
    }

    private ItemStack getOverworldLoot(Random random) {
        int item = random.nextInt(35);
        switch (item) {
            case 0:
                return new ItemStack(Items.rotten_flesh, random.nextInt(15) + 8);
            case 1:
                return new ItemStack(Items.bone, random.nextInt(12) + 15);
            case 2:
                return new ItemStack(Items.arrow, random.nextInt(12) + 12);
            case 3:
                return new ItemStack(Items.redstone, random.nextInt(3) + 3);
            case 4:
                return new ItemStack(Items.iron_ingot, random.nextInt(6) + 4);
            case 5:
                return new ItemStack(Blocks.dirt, random.nextInt(6) + 4);
            case 6:
                return new ItemStack(Blocks.log, random.nextInt(3) + 2, 0);
            case 7:
                return new ItemStack(Items.golden_apple, random.nextInt(6) + 2, 0);
            case 8:
                return new ItemStack(Items.flint_and_steel, 1);
            case 9:
                return new ItemStack(Blocks.netherrack, random.nextInt(3) + 1);
            case 10:
                return new ItemStack(NovaCraftItems.cave_stew, 1, 4);
            case 11:
                return new ItemStack(NovaCraftItems.cave_stew, 1, 4);
            case 12:
                return new ItemStack(Blocks.ice, random.nextInt(3) + 1);
            case 13:
                return new ItemStack(Items.bucket, 1);
            case 14:
                return new ItemStack(Items.iron_sword, 1);
            case 15:
                return new ItemStack(Items.iron_pickaxe, 1);
            case 16:
                return new ItemStack(Items.coal, random.nextInt(5) + 2);
            case 17:
                return new ItemStack(NovaCraftItems.potion_regen_extended, random.nextInt(1) + 1);
            default: {
                return new ItemStack(Blocks.cobblestone, random.nextInt(40) + 24);
            }
        }
    }
}
