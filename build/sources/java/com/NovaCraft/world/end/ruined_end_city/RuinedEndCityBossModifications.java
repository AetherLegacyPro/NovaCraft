package com.NovaCraft.world.end.ruined_end_city;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.config.Configs;
import com.NovaCraft.config.ConfigsCompact;
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

public class RuinedEndCityBossModifications extends WorldGenerator {

    public RuinedEndCityBossModifications() {
    }

    private Block PlaceEndstoneBricks;
    private Block PlaceEndstoneBrickStairs;
    private Block PlacePurpurStairs;
    private Block PlacePurpur;

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
                    System.out.println("Missing Endstone Bricks from Et Futurum Requiem, using Etherstone Bricks instead...");
                }
                return NovaCraftBlocks.etherstone_bricks;
            }
        }

        return NovaCraftBlocks.etherstone_bricks;
    }

    private Block determineIfPurpurExists(World world, int x, int y, int z) {
        Block existingBlock = world.getBlock(x, y, z);
        if (ConfigsCompact.enablePurpur && Loader.isModLoaded("etfuturum")) {
            try {
                Block purpur_block = GameRegistry.findBlock("etfuturum", "purpur_block");
                if (purpur_block != null && (existingBlock == null || existingBlock != purpur_block)) {
                    return purpur_block;
                }
            } catch (Exception ex) {
                if (Configs.enableDebugMode) {
                    System.out.println("Missing Purpur from Et Futurum Requiem, using Vanite Bricks instead...");
                }
                return NovaCraftBlocks.polished_vanite_bricks;
            }
        }

        return NovaCraftBlocks.polished_vanite_bricks;
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
                    System.out.println("Missing Endstone Bricks from Et Futurum Requiem, using Etherstone Bricks instead...");
                }
                return NovaCraftBlocks.etherstone_brick_stairs;
            }
        }

        return NovaCraftBlocks.etherstone_brick_stairs;
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
        PlaceEndstoneBrickStairs = determineIfEndstoneBrickStairsExists(world, i + 20, j + 20, k + 21);
        PlacePurpurStairs = determineIfPurpurBrickStairsExists(world, i + 20, j + 27, k + 13);
        PlacePurpur = determineIfPurpurExists(world, i + 22, j + 40, k + 15);
        PlaceEndstoneBricks = determineIfEndstoneBricksExists(world, i + 28, j + 27, k + 27);

        world.setBlock(i + 28, j + 27, k + 27, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 20, j + 20, k + 21, placeEndStoneBrickStairs(random), 2, 2);
        world.setBlock(i + 21, j + 20, k + 21, placeEndStoneBrickStairs(random), 2, 2);
        world.setBlock(i + 22, j + 20, k + 21, placeEndStoneBrickStairs(random), 2, 2);
        world.setBlock(i + 23, j + 20, k + 21, placeEndStoneBrickStairs(random), 2, 2);
        world.setBlock(i + 24, j + 20, k + 21, placeEndStoneBrickStairs(random), 2, 2);
        world.setBlock(i + 25, j + 20, k + 21, placeEndStoneBrickStairs(random), 2, 2);
        world.setBlock(i + 26, j + 20, k + 21, placeEndStoneBrickStairs(random), 1, 2);
        world.setBlock(i + 20, j + 20, k + 22, placeEndStoneBrickStairs(random), 0, 2);
        world.setBlock(i + 26, j + 20, k + 22, placeEndStoneBrickStairs(random), 1, 2);
        world.setBlock(i + 20, j + 20, k + 23, placeEndStoneBrickStairs(random), 0, 2);
        world.setBlock(i + 26, j + 20, k + 23, placeEndStoneBrickStairs(random), 1, 2);
        world.setBlock(i + 20, j + 20, k + 24, placeEndStoneBrickStairs(random), 0, 2);
        world.setBlock(i + 26, j + 20, k + 24, placeEndStoneBrickStairs(random), 1, 2);
        world.setBlock(i + 20, j + 20, k + 25, placeEndStoneBrickStairs(random), 0, 2);
        world.setBlock(i + 26, j + 20, k + 25, placeEndStoneBrickStairs(random), 1, 2);
        world.setBlock(i + 20, j + 20, k + 26, placeEndStoneBrickStairs(random), 0, 2);
        world.setBlock(i + 26, j + 20, k + 26, placeEndStoneBrickStairs(random), 1, 2);
        world.setBlock(i + 20, j + 20, k + 27, placeEndStoneBrickStairs(random), 3, 2);
        world.setBlock(i + 21, j + 20, k + 27, placeEndStoneBrickStairs(random), 3, 2);
        world.setBlock(i + 22, j + 20, k + 27, placeEndStoneBrickStairs(random), 3, 2);
        world.setBlock(i + 23, j + 20, k + 27, placeEndStoneBrickStairs(random), 3, 2);
        world.setBlock(i + 24, j + 20, k + 27, placeEndStoneBrickStairs(random), 3, 2);
        world.setBlock(i + 25, j + 20, k + 27, placeEndStoneBrickStairs(random), 3, 2);
        world.setBlock(i + 26, j + 20, k + 27, placeEndStoneBrickStairs(random), 1, 2);
        world.setBlock(i + 21, j + 21, k + 22, placeSculkTentacle(random), 1, 2);
        world.setBlock(i + 22, j + 21, k + 22, placeSculkTentacle(random), 1, 2);
        world.setBlock(i + 23, j + 21, k + 22, placeSculkTentacle(random), 1, 2);
        world.setBlock(i + 24, j + 21, k + 22, placeSculkTentacle(random), 1, 2);
        world.setBlock(i + 25, j + 21, k + 22, placeSculkTentacle(random), 1, 2);
        world.setBlock(i + 21, j + 21, k + 23, placeSculkTentacle(random), 1, 2);
        world.setBlock(i + 25, j + 21, k + 23, placeSculkTentacle(random), 1, 2);
        world.setBlock(i + 21, j + 21, k + 24, placeSculkTentacle(random), 1, 2);
        world.setBlock(i + 25, j + 21, k + 24, placeSculkTentacle(random), 1, 2);
        world.setBlock(i + 21, j + 21, k + 25, placeSculkTentacle(random), 1, 2);
        world.setBlock(i + 25, j + 21, k + 25, placeSculkTentacle(random), 1, 2);
        world.setBlock(i + 21, j + 21, k + 26, placeSculkTentacle(random), 1, 2);
        world.setBlock(i + 22, j + 21, k + 26, placeSculkTentacle(random), 1, 2);
        world.setBlock(i + 23, j + 21, k + 26, placeSculkTentacle(random), 1, 2);
        world.setBlock(i + 24, j + 21, k + 26, placeSculkTentacle(random), 1, 2);
        world.setBlock(i + 25, j + 21, k + 26, placeSculkTentacle(random), 1, 2);
        world.setBlock(i + 26, j + 26, k + 20, NovaCraftBlocks.frontierslate_brick_wall, 0, 2);
        world.setBlock(i + 20, j + 27, k + 13, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 21, j + 27, k + 13, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 25, j + 27, k + 13, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 26, j + 27, k + 13, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 16, j + 27, k + 14, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 17, j + 27, k + 14, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 18, j + 27, k + 14, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 19, j + 27, k + 14, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 21, j + 27, k + 14, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 25, j + 27, k + 14, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 27, j + 27, k + 14, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 28, j + 27, k + 14, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 29, j + 27, k + 14, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 30, j + 27, k + 14, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 14, j + 27, k + 15, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 15, j + 27, k + 15, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 21, j + 27, k + 15, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 25, j + 27, k + 15, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 31, j + 27, k + 15, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 32, j + 27, k + 15, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 14, j + 27, k + 16, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 21, j + 27, k + 16, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 25, j + 27, k + 16, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 32, j + 27, k + 16, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 13, j + 27, k + 17, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 21, j + 27, k + 17, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 25, j + 27, k + 17, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 33, j + 27, k + 17, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 13, j + 27, k + 18, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 21, j + 27, k + 18, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 25, j + 27, k + 18, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 33, j + 27, k + 18, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 13, j + 27, k + 19, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 20, j + 27, k + 19, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 26, j + 27, k + 19, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 33, j + 27, k + 19, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 13, j + 27, k + 20, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 19, j + 27, k + 20, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 27, j + 27, k + 20, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 33, j + 27, k + 20, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 12, j + 27, k + 21, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 18, j + 27, k + 21, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 28, j + 27, k + 21, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 34, j + 27, k + 21, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 12, j + 27, k + 22, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 13, j + 27, k + 22, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 14, j + 27, k + 22, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 15, j + 27, k + 22, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 16, j + 27, k + 22, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 17, j + 27, k + 22, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 29, j + 27, k + 22, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 30, j + 27, k + 22, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 31, j + 27, k + 22, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 32, j + 27, k + 22, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 33, j + 27, k + 22, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 34, j + 27, k + 22, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 12, j + 27, k + 26, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 13, j + 27, k + 26, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 14, j + 27, k + 26, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 15, j + 27, k + 26, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 16, j + 27, k + 26, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 17, j + 27, k + 26, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 29, j + 27, k + 26, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 30, j + 27, k + 26, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 31, j + 27, k + 26, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 32, j + 27, k + 26, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 33, j + 27, k + 26, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 34, j + 27, k + 26, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 12, j + 27, k + 27, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 18, j + 27, k + 27, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 34, j + 27, k + 27, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 13, j + 27, k + 28, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 19, j + 27, k + 28, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 27, j + 27, k + 28, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 33, j + 27, k + 28, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 13, j + 27, k + 29, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 20, j + 27, k + 29, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 26, j + 27, k + 29, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 33, j + 27, k + 29, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 13, j + 27, k + 30, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 21, j + 27, k + 30, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 25, j + 27, k + 30, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 33, j + 27, k + 30, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 13, j + 27, k + 31, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 21, j + 27, k + 31, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 25, j + 27, k + 31, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 33, j + 27, k + 31, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 14, j + 27, k + 32, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 21, j + 27, k + 32, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 25, j + 27, k + 32, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 32, j + 27, k + 32, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 14, j + 27, k + 33, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 15, j + 27, k + 33, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 21, j + 27, k + 33, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 25, j + 27, k + 33, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 31, j + 27, k + 33, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 32, j + 27, k + 33, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 16, j + 27, k + 34, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 17, j + 27, k + 34, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 18, j + 27, k + 34, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 19, j + 27, k + 34, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 21, j + 27, k + 34, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 25, j + 27, k + 34, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 27, j + 27, k + 34, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 28, j + 27, k + 34, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 29, j + 27, k + 34, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 30, j + 27, k + 34, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 20, j + 27, k + 35, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 21, j + 27, k + 35, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 25, j + 27, k + 35, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 26, j + 27, k + 35, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 23, j + 33, k + 34, NovaCraftBlocks.frontierslate_brick_wall, 0, 2);
        world.setBlock(i + 23, j + 34, k + 34, NovaCraftBlocks.frontierslate_brick_wall, 0, 2);
        world.setBlock(i + 23, j + 35, k + 34, NovaCraftBlocks.frontierslate_brick_wall, 0, 2);
        world.setBlock(i + 23, j + 36, k + 34, NovaCraftBlocks.frontierslate_brick_wall, 0, 2);
        world.setBlock(i + 23, j + 37, k + 34, NovaCraftBlocks.frontierslate_brick_wall, 0, 2);
        world.setBlock(i + 25, j + 37, k + 47, NovaCraftBlocks.frontierslate_brick_wall, 0, 2);
        world.setBlock(i + 21, j + 38, k + 5, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 25, j + 38, k + 5, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i, j + 38, k + 22, NovaCraftBlocks.frontierslate_brick_wall, 0, 2);
        world.setBlock(i + 4, j + 38, k + 22, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 42, j + 38, k + 22, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 4, j + 38, k + 26, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 42, j + 38, k + 26, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 21, j + 38, k + 43, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 25, j + 38, k + 43, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 25, j + 38, k + 47, NovaCraftBlocks.frontierslate_brick_wall, 0, 2);
        world.setBlock(i + 25, j + 39, k + 1, NovaCraftBlocks.frontierslate_brick_wall, 0, 2);
        world.setBlock(i + 21, j + 39, k + 4, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 25, j + 39, k + 4, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 21, j + 39, k + 5, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 22, j + 39, k + 5, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 23, j + 39, k + 5, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 24, j + 39, k + 5, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 25, j + 39, k + 5, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 23, j + 39, k + 7, NovaCraftBlocks.frontierslate_brick_stairs, 7, 2);
        world.setBlock(i, j + 39, k + 22, NovaCraftBlocks.frontierslate_brick_wall, 0, 2);
        world.setBlock(i + 3, j + 39, k + 22, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 4, j + 39, k + 22, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 42, j + 39, k + 22, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 43, j + 39, k + 22, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 4, j + 39, k + 23, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 42, j + 39, k + 23, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 4, j + 39, k + 24, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 6, j + 39, k + 24, NovaCraftBlocks.frontierslate_brick_stairs, 5, 2);
        world.setBlock(i + 40, j + 39, k + 24, NovaCraftBlocks.frontierslate_brick_stairs, 4, 2);
        world.setBlock(i + 42, j + 39, k + 24, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 4, j + 39, k + 25, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 18, j + 39, k + 25, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 42, j + 39, k + 25, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 3, j + 39, k + 26, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 4, j + 39, k + 26, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 42, j + 39, k + 26, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 43, j + 39, k + 26, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 46, j + 39, k + 26, NovaCraftBlocks.frontierslate_brick_wall, 0, 2);
        world.setBlock(i + 23, j + 39, k + 41, NovaCraftBlocks.frontierslate_brick_stairs, 6, 2);
        world.setBlock(i + 21, j + 39, k + 43, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 22, j + 39, k + 43, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 23, j + 39, k + 43, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 24, j + 39, k + 43, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 25, j + 39, k + 43, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 21, j + 39, k + 44, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 25, j + 39, k + 44, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 25, j + 39, k + 47, NovaCraftBlocks.frontierslate_brick_wall, 0, 2);
        world.setBlock(i + 22, j + 40, k + 1, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i + 23, j + 40, k + 1, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i + 24, j + 40, k + 1, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i + 22, j + 40, k + 2, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i + 23, j + 40, k + 2, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i + 24, j + 40, k + 2, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i + 22, j + 40, k + 3, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i + 23, j + 40, k + 3, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i + 24, j + 40, k + 3, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i + 22, j + 40, k + 4, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i + 23, j + 40, k + 4, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i + 24, j + 40, k + 4, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i + 22, j + 40, k + 5, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i + 23, j + 40, k + 5, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i + 24, j + 40, k + 5, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i + 22, j + 40, k + 6, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i + 23, j + 40, k + 6, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i + 24, j + 40, k + 6, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i + 21, j + 40, k + 7, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i + 22, j + 40, k + 7, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i + 23, j + 40, k + 7, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i + 24, j + 40, k + 7, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i + 25, j + 40, k + 7, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i + 21, j + 40, k + 13, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 25, j + 40, k + 13, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 18, j + 40, k + 14, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 19, j + 40, k + 14, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 20, j + 40, k + 14, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 21, j + 40, k + 14, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 25, j + 40, k + 14, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 26, j + 40, k + 14, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 27, j + 40, k + 14, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 28, j + 40, k + 14, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 14, j + 40, k + 15, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 16, j + 40, k + 15, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 17, j + 40, k + 15, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 21, j + 40, k + 15, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 22, j + 40, k + 15, placePurpur(random), 0, 2);
        world.setBlock(i + 24, j + 40, k + 15, placePurpur(random), 0, 2);
        world.setBlock(i + 25, j + 40, k + 15, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 29, j + 40, k + 15, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 30, j + 40, k + 15, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 32, j + 40, k + 15, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 15, j + 40, k + 16, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 21, j + 40, k + 16, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 22, j + 40, k + 16, placePurpur(random), 0, 2);
        world.setBlock(i + 24, j + 40, k + 16, placePurpur(random), 0, 2);
        world.setBlock(i + 25, j + 40, k + 16, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 31, j + 40, k + 16, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 14, j + 40, k + 17, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 21, j + 40, k + 17, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 22, j + 40, k + 17, placePurpur(random), 0, 2);
        world.setBlock(i + 24, j + 40, k + 17, placePurpur(random), 0, 2);
        world.setBlock(i + 25, j + 40, k + 17, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 32, j + 40, k + 17, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 14, j + 40, k + 18, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 21, j + 40, k + 18, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 22, j + 40, k + 18, placePurpur(random), 0, 2);
        world.setBlock(i + 24, j + 40, k + 18, placePurpur(random), 0, 2);
        world.setBlock(i + 25, j + 40, k + 18, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 32, j + 40, k + 18, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 13, j + 40, k + 19, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 21, j + 40, k + 19, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 22, j + 40, k + 19, placePurpur(random), 0, 2);
        world.setBlock(i + 24, j + 40, k + 19, placePurpur(random), 0, 2);
        world.setBlock(i + 25, j + 40, k + 19, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 33, j + 40, k + 19, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 13, j + 40, k + 20, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 21, j + 40, k + 20, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 25, j + 40, k + 20, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 33, j + 40, k + 20, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 13, j + 40, k + 21, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 21, j + 40, k + 21, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 25, j + 40, k + 21, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 33, j + 40, k + 21, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 6, j + 40, k + 22, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i + 12, j + 40, k + 22, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 13, j + 40, k + 22, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 14, j + 40, k + 22, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 15, j + 40, k + 22, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 16, j + 40, k + 22, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 17, j + 40, k + 22, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 18, j + 40, k + 22, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 19, j + 40, k + 22, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 20, j + 40, k + 22, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 26, j + 40, k + 22, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 27, j + 40, k + 22, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 28, j + 40, k + 22, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 29, j + 40, k + 22, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 30, j + 40, k + 22, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 31, j + 40, k + 22, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 32, j + 40, k + 22, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 33, j + 40, k + 22, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 34, j + 40, k + 22, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 40, j + 40, k + 22, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i, j + 40, k + 23, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i + 1, j + 40, k + 23, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i + 2, j + 40, k + 23, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i + 3, j + 40, k + 23, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i + 4, j + 40, k + 23, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i + 5, j + 40, k + 23, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i + 6, j + 40, k + 23, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i + 14, j + 40, k + 23, placePurpur(random), 0, 2);
        world.setBlock(i + 15, j + 40, k + 23, placePurpur(random), 0, 2);
        world.setBlock(i + 16, j + 40, k + 23, placePurpur(random), 0, 2);
        world.setBlock(i + 17, j + 40, k + 23, placePurpur(random), 0, 2);
        world.setBlock(i + 18, j + 40, k + 23, placePurpur(random), 0, 2);
        world.setBlock(i + 28, j + 40, k + 23, placePurpur(random), 0, 2);
        world.setBlock(i + 29, j + 40, k + 23, placePurpur(random), 0, 2);
        world.setBlock(i + 30, j + 40, k + 23, placePurpur(random), 0, 2);
        world.setBlock(i + 31, j + 40, k + 23, placePurpur(random), 0, 2);
        world.setBlock(i + 32, j + 40, k + 23, placePurpur(random), 0, 2);
        world.setBlock(i + 33, j + 40, k + 23, placePurpur(random), 0, 2);
        world.setBlock(i + 40, j + 40, k + 23, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i + 41, j + 40, k + 23, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i + 42, j + 40, k + 23, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i + 43, j + 40, k + 23, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i + 44, j + 40, k + 23, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i + 45, j + 40, k + 23, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i + 46, j + 40, k + 23, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i, j + 40, k + 24, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i + 1, j + 40, k + 24, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i + 2, j + 40, k + 24, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i + 3, j + 40, k + 24, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i + 4, j + 40, k + 24, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i + 5, j + 40, k + 24, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i + 6, j + 40, k + 24, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i + 40, j + 40, k + 24, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i + 41, j + 40, k + 24, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i + 42, j + 40, k + 24, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i + 43, j + 40, k + 24, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i + 44, j + 40, k + 24, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i + 45, j + 40, k + 24, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i + 46, j + 40, k + 24, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i, j + 40, k + 25, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i + 1, j + 40, k + 25, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i + 2, j + 40, k + 25, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i + 3, j + 40, k + 25, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i + 4, j + 40, k + 25, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i + 5, j + 40, k + 25, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i + 6, j + 40, k + 25, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i + 14, j + 40, k + 25, placePurpur(random), 0, 2);
        world.setBlock(i + 15, j + 40, k + 25, placePurpur(random), 0, 2);
        world.setBlock(i + 16, j + 40, k + 25, placePurpur(random), 0, 2);
        world.setBlock(i + 17, j + 40, k + 25, placePurpur(random), 0, 2);
        world.setBlock(i + 18, j + 40, k + 25, placePurpur(random), 0, 2);
        world.setBlock(i + 28, j + 40, k + 25, placePurpur(random), 0, 2);
        world.setBlock(i + 29, j + 40, k + 25, placePurpur(random), 0, 2);
        world.setBlock(i + 30, j + 40, k + 25, placePurpur(random), 0, 2);
        world.setBlock(i + 31, j + 40, k + 25, placePurpur(random), 0, 2);
        world.setBlock(i + 32, j + 40, k + 25, placePurpur(random), 0, 2);
        world.setBlock(i + 33, j + 40, k + 25, placePurpur(random), 0, 2);
        world.setBlock(i + 40, j + 40, k + 25, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i + 41, j + 40, k + 25, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i + 42, j + 40, k + 25, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i + 43, j + 40, k + 25, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i + 44, j + 40, k + 25, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i + 45, j + 40, k + 25, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i + 46, j + 40, k + 25, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i + 6, j + 40, k + 26, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i + 12, j + 40, k + 26, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 13, j + 40, k + 26, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 14, j + 40, k + 26, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 15, j + 40, k + 26, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 16, j + 40, k + 26, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 17, j + 40, k + 26, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 18, j + 40, k + 26, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 19, j + 40, k + 26, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 20, j + 40, k + 26, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 26, j + 40, k + 26, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 27, j + 40, k + 26, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 28, j + 40, k + 26, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 29, j + 40, k + 26, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 30, j + 40, k + 26, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 31, j + 40, k + 26, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 32, j + 40, k + 26, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 33, j + 40, k + 26, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 34, j + 40, k + 26, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 40, j + 40, k + 26, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i + 13, j + 40, k + 27, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 21, j + 40, k + 27, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 25, j + 40, k + 27, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 33, j + 40, k + 27, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 13, j + 40, k + 28, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 21, j + 40, k + 28, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 25, j + 40, k + 28, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 33, j + 40, k + 28, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 13, j + 40, k + 29, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 21, j + 40, k + 29, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 22, j + 40, k + 29, placePurpur(random), 0, 2);
        world.setBlock(i + 24, j + 40, k + 29, placePurpur(random), 0, 2);
        world.setBlock(i + 25, j + 40, k + 29, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 33, j + 40, k + 29, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 14, j + 40, k + 30, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 21, j + 40, k + 30, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 22, j + 40, k + 30, placePurpur(random), 0, 2);
        world.setBlock(i + 24, j + 40, k + 30, placePurpur(random), 0, 2);
        world.setBlock(i + 25, j + 40, k + 30, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 32, j + 40, k + 30, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 14, j + 40, k + 31, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 21, j + 40, k + 31, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 22, j + 40, k + 31, placePurpur(random), 0, 2);
        world.setBlock(i + 24, j + 40, k + 31, placePurpur(random), 0, 2);
        world.setBlock(i + 25, j + 40, k + 31, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 32, j + 40, k + 31, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 15, j + 40, k + 32, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 21, j + 40, k + 32, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 22, j + 40, k + 32, placePurpur(random), 0, 2);
        world.setBlock(i + 24, j + 40, k + 32, placePurpur(random), 0, 2);
        world.setBlock(i + 25, j + 40, k + 32, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 31, j + 40, k + 32, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 14, j + 40, k + 33, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 16, j + 40, k + 33, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 17, j + 40, k + 33, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 21, j + 40, k + 33, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 22, j + 40, k + 33, placePurpur(random), 0, 2);
        world.setBlock(i + 24, j + 40, k + 33, placePurpur(random), 0, 2);
        world.setBlock(i + 25, j + 40, k + 33, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 29, j + 40, k + 33, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 30, j + 40, k + 33, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 32, j + 40, k + 33, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 18, j + 40, k + 34, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 19, j + 40, k + 34, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 20, j + 40, k + 34, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 21, j + 40, k + 34, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 25, j + 40, k + 34, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 26, j + 40, k + 34, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 27, j + 40, k + 34, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 28, j + 40, k + 34, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 21, j + 40, k + 35, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 25, j + 40, k + 35, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 21, j + 40, k + 41, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i + 22, j + 40, k + 41, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i + 23, j + 40, k + 41, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i + 24, j + 40, k + 41, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i + 25, j + 40, k + 41, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i + 22, j + 40, k + 42, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i + 23, j + 40, k + 42, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i + 24, j + 40, k + 42, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i + 22, j + 40, k + 43, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i + 23, j + 40, k + 43, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i + 24, j + 40, k + 43, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i + 22, j + 40, k + 44, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i + 23, j + 40, k + 44, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i + 24, j + 40, k + 44, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i + 22, j + 40, k + 45, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i + 23, j + 40, k + 45, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i + 24, j + 40, k + 45, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i + 22, j + 40, k + 46, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i + 23, j + 40, k + 46, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i + 24, j + 40, k + 46, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i + 22, j + 40, k + 47, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i + 23, j + 40, k + 47, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i + 24, j + 40, k + 47, NovaCraftBlocks.frontierslate_brick_slab, 5, 2);
        world.setBlock(i + 21, j + 41, k + 4, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 25, j + 41, k + 4, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 21, j + 41, k + 5, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 25, j + 41, k + 5, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 22, j + 41, k + 13, placePurpurStairs(random), 0, 2);
        world.setBlock(i + 24, j + 41, k + 13, placePurpurStairs(random), 1, 2);
        world.setBlock(i + 23, j + 41, k + 14, placePurpurStairs(random), 7, 2);
        world.setBlock(i + 3, j + 41, k + 22, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 4, j + 41, k + 22, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 42, j + 41, k + 22, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 43, j + 41, k + 22, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 12, j + 41, k + 23, placePurpurStairs(random), 2, 2);
        world.setBlock(i + 34, j + 41, k + 23, placePurpurStairs(random), 2, 2);
        world.setBlock(i + 13, j + 41, k + 24, placePurpurStairs(random), 5, 2);
        world.setBlock(i + 33, j + 41, k + 24, placePurpurStairs(random), 4, 2);
        world.setBlock(i + 12, j + 41, k + 25, placePurpurStairs(random), 3, 2);
        world.setBlock(i + 34, j + 41, k + 25, placePurpurStairs(random), 3, 2);
        world.setBlock(i + 3, j + 41, k + 26, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 4, j + 41, k + 26, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 42, j + 41, k + 26, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 43, j + 41, k + 26, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 23, j + 41, k + 34, placePurpurStairs(random), 6, 2);
        world.setBlock(i + 22, j + 41, k + 35, placePurpurStairs(random), 0, 2);
        world.setBlock(i + 24, j + 41, k + 35, placePurpurStairs(random), 1, 2);
        world.setBlock(i + 21, j + 41, k + 43, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 25, j + 41, k + 43, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 21, j + 41, k + 44, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 25, j + 41, k + 44, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 21, j + 42, k + 5, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 25, j + 42, k + 5, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 4, j + 42, k + 22, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 42, j + 42, k + 22, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 4, j + 42, k + 26, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 42, j + 42, k + 26, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 21, j + 42, k + 43, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 25, j + 42, k + 43, PlaceEndstoneBricks, 0, 2);
        world.setBlock(i + 21, j + 43, k + 5, NovaCraftBlocks.dim_vanite_torch, 5, 2);
        world.setBlock(i + 25, j + 43, k + 5, NovaCraftBlocks.dim_vanite_torch, 5, 2);
        world.setBlock(i + 4, j + 43, k + 22, NovaCraftBlocks.dim_vanite_torch, 5, 2);
        world.setBlock(i + 42, j + 43, k + 22, NovaCraftBlocks.dim_vanite_torch, 5, 2);
        world.setBlock(i + 4, j + 43, k + 26, NovaCraftBlocks.dim_vanite_torch, 5, 2);
        world.setBlock(i + 42, j + 43, k + 26, NovaCraftBlocks.dim_vanite_torch, 5, 2);
        world.setBlock(i + 21, j + 43, k + 43, NovaCraftBlocks.dim_vanite_torch, 5, 2);
        world.setBlock(i + 25, j + 43, k + 43, NovaCraftBlocks.dim_vanite_torch, 5, 2);
        world.setBlock(i + 20, j + 47, k + 21, NovaCraftBlocks.frontierslate_brick_wall, 0, 2);
        world.setBlock(i + 20, j + 48, k + 21, NovaCraftBlocks.frontierslate_brick_wall, 0, 2);
        world.setBlock(i + 20, j + 49, k + 21, NovaCraftBlocks.frontierslate_brick_wall, 0, 2);
        world.setBlock(i + 23, j + 54, k + 8, Blocks.air, 0, 2);
        world.setBlock(i + 23, j + 72, k + 24, NovaCraftBlocks.dim_vanite_torch, 5, 2);
        world.setBlock(i + 41, j + 39, k + 22, placeFrontierslatePillar(random), 4, 2);
        world.setBlock(i + 21, j + 39, k + 42, placeFrontierslatePillar(random), 8, 2);
        world.setBlock(i + 21, j + 40, k + 1, placeFrontierslatePillar(random), 8, 2);
        world.setBlock(i + 25, j + 40, k + 1, placeFrontierslatePillar(random), 8, 2);
        world.setBlock(i + 21, j + 40, k + 2, placeFrontierslatePillar(random), 8, 2);
        world.setBlock(i + 25, j + 40, k + 2, placeFrontierslatePillar(random), 8, 2);
        world.setBlock(i + 21, j + 40, k + 3, placeFrontierslatePillar(random), 8, 2);
        world.setBlock(i + 25, j + 40, k + 3, placeFrontierslatePillar(random), 8, 2);
        world.setBlock(i + 21, j + 40, k + 4, placeFrontierslatePillar(random), 8, 2);
        world.setBlock(i + 25, j + 40, k + 4, placeFrontierslatePillar(random), 8, 2);
        world.setBlock(i + 21, j + 40, k + 5, placeFrontierslatePillar(random), 8, 2);
        world.setBlock(i + 25, j + 40, k + 5, placeFrontierslatePillar(random), 8, 2);
        world.setBlock(i + 21, j + 40, k + 6, placeFrontierslatePillar(random), 0, 2);
        world.setBlock(i + 25, j + 40, k + 6, placeFrontierslatePillar(random), 0, 2);
        world.setBlock(i + 23, j + 40, k + 14, placeFrontierslatePillar(random), 8, 2);
        world.setBlock(i, j + 40, k + 22, placeFrontierslatePillar(random), 4, 2);
        world.setBlock(i + 1, j + 40, k + 22, placeFrontierslatePillar(random), 4, 2);
        world.setBlock(i + 2, j + 40, k + 22, placeFrontierslatePillar(random), 4, 2);
        world.setBlock(i + 3, j + 40, k + 22, placeFrontierslatePillar(random), 4, 2);
        world.setBlock(i + 4, j + 40, k + 22, placeFrontierslatePillar(random), 4, 2);
        world.setBlock(i + 5, j + 40, k + 22, placeFrontierslatePillar(random), 0, 2);
        world.setBlock(i + 41, j + 40, k + 22, placeFrontierslatePillar(random), 0, 2);
        world.setBlock(i + 42, j + 40, k + 22, placeFrontierslatePillar(random), 4, 2);
        world.setBlock(i + 43, j + 40, k + 22, placeFrontierslatePillar(random), 4, 2);
        world.setBlock(i + 44, j + 40, k + 22, placeFrontierslatePillar(random), 4, 2);
        world.setBlock(i + 45, j + 40, k + 22, placeFrontierslatePillar(random), 4, 2);
        world.setBlock(i + 46, j + 40, k + 22, placeFrontierslatePillar(random), 4, 2);
        world.setBlock(i + 13, j + 40, k + 24, placeFrontierslatePillar(random), 4, 2);
        world.setBlock(i + 33, j + 40, k + 24, placeFrontierslatePillar(random), 4, 2);
        world.setBlock(i, j + 40, k + 26, placeFrontierslatePillar(random), 4, 2);
        world.setBlock(i + 1, j + 40, k + 26, placeFrontierslatePillar(random), 4, 2);
        world.setBlock(i + 2, j + 40, k + 26, placeFrontierslatePillar(random), 4, 2);
        world.setBlock(i + 3, j + 40, k + 26, placeFrontierslatePillar(random), 4, 2);
        world.setBlock(i + 4, j + 40, k + 26, placeFrontierslatePillar(random), 4, 2);
        world.setBlock(i + 5, j + 40, k + 26, placeFrontierslatePillar(random), 0, 2);
        world.setBlock(i + 41, j + 40, k + 26, placeFrontierslatePillar(random), 0, 2);
        world.setBlock(i + 42, j + 40, k + 26, placeFrontierslatePillar(random), 4, 2);
        world.setBlock(i + 43, j + 40, k + 26, placeFrontierslatePillar(random), 4, 2);
        world.setBlock(i + 44, j + 40, k + 26, placeFrontierslatePillar(random), 4, 2);
        world.setBlock(i + 45, j + 40, k + 26, placeFrontierslatePillar(random), 4, 2);
        world.setBlock(i + 46, j + 40, k + 26, placeFrontierslatePillar(random), 4, 2);
        world.setBlock(i + 23, j + 40, k + 34, placeFrontierslatePillar(random), 8, 2);
        world.setBlock(i + 21, j + 40, k + 42, placeFrontierslatePillar(random), 0, 2);
        world.setBlock(i + 25, j + 40, k + 42, placeFrontierslatePillar(random), 0, 2);
        world.setBlock(i + 21, j + 40, k + 43, placeFrontierslatePillar(random), 8, 2);
        world.setBlock(i + 25, j + 40, k + 43, placeFrontierslatePillar(random), 8, 2);
        world.setBlock(i + 21, j + 40, k + 44, placeFrontierslatePillar(random), 8, 2);
        world.setBlock(i + 25, j + 40, k + 44, placeFrontierslatePillar(random), 8, 2);
        world.setBlock(i + 21, j + 40, k + 45, placeFrontierslatePillar(random), 8, 2);
        world.setBlock(i + 25, j + 40, k + 45, placeFrontierslatePillar(random), 8, 2);
        world.setBlock(i + 21, j + 40, k + 46, placeFrontierslatePillar(random), 8, 2);
        world.setBlock(i + 25, j + 40, k + 46, placeFrontierslatePillar(random), 8, 2);
        world.setBlock(i + 21, j + 40, k + 47, placeFrontierslatePillar(random), 8, 2);
        world.setBlock(i + 25, j + 40, k + 47, placeFrontierslatePillar(random), 8, 2);
        world.setBlock(i + 23, j + 41, k + 12, placeFrontierslatePillar(random), 8, 2);
        world.setBlock(i + 23, j + 41, k + 13, placeFrontierslatePillar(random), 8, 2);
        world.setBlock(i + 11, j + 41, k + 24, placeFrontierslatePillar(random), 4, 2);
        world.setBlock(i + 12, j + 41, k + 24, placeFrontierslatePillar(random), 4, 2);
        world.setBlock(i + 34, j + 41, k + 24, placeFrontierslatePillar(random), 4, 2);
        world.setBlock(i + 35, j + 41, k + 24, placeFrontierslatePillar(random), 4, 2);
        world.setBlock(i + 23, j + 41, k + 35, placeFrontierslatePillar(random), 8, 2);
        world.setBlock(i + 23, j + 41, k + 36, placeFrontierslatePillar(random), 8, 2);
        world.setBlock(i + 21, j + 59, k + 22, placeFrontierslatePillar(random), 0, 2);
        world.setBlock(i + 22, j + 59, k + 22, placeFrontierslatePillar(random), 0, 2);
        world.setBlock(i + 24, j + 59, k + 22, placeFrontierslatePillar(random), 0, 2);
        world.setBlock(i + 25, j + 59, k + 22, placeFrontierslatePillar(random), 0, 2);
        world.setBlock(i + 21, j + 59, k + 23, placeFrontierslatePillar(random), 0, 2);
        world.setBlock(i + 25, j + 59, k + 23, placeFrontierslatePillar(random), 0, 2);
        world.setBlock(i + 21, j + 59, k + 25, placeFrontierslatePillar(random), 0, 2);
        world.setBlock(i + 25, j + 59, k + 25, placeFrontierslatePillar(random), 0, 2);
        world.setBlock(i + 21, j + 59, k + 26, placeFrontierslatePillar(random), 0, 2);
        world.setBlock(i + 22, j + 59, k + 26, placeFrontierslatePillar(random), 0, 2);
        world.setBlock(i + 24, j + 59, k + 26, placeFrontierslatePillar(random), 0, 2);
        world.setBlock(i + 25, j + 59, k + 26, placeFrontierslatePillar(random), 0, 2);
        world.setBlock(i + 22, j + 60, k + 23, placeFrontierslatePillar(random), 0, 2);
        world.setBlock(i + 24, j + 60, k + 23, placeFrontierslatePillar(random), 0, 2);
        world.setBlock(i + 22, j + 60, k + 25, placeFrontierslatePillar(random), 0, 2);
        world.setBlock(i + 24, j + 60, k + 25, placeFrontierslatePillar(random), 0, 2);
        world.setBlock(i + 22, j + 61, k + 23, placeFrontierslatePillar(random), 0, 2);
        world.setBlock(i + 24, j + 61, k + 23, placeFrontierslatePillar(random), 0, 2);
        world.setBlock(i + 22, j + 61, k + 25, placeFrontierslatePillar(random), 0, 2);
        world.setBlock(i + 24, j + 61, k + 25, placeFrontierslatePillar(random), 0, 2);
        world.setBlock(i + 22, j + 62, k + 23, placeFrontierslatePillar(random), 0, 2);
        world.setBlock(i + 24, j + 62, k + 23, placeFrontierslatePillar(random), 0, 2);
        world.setBlock(i + 22, j + 62, k + 25, placeFrontierslatePillar(random), 0, 2);
        world.setBlock(i + 24, j + 62, k + 25, placeFrontierslatePillar(random), 0, 2);
        world.setBlock(i + 22, j + 63, k + 23, placeFrontierslatePillar(random), 0, 2);
        world.setBlock(i + 23, j + 63, k + 23, placeFrontierslatePillar(random), 0, 2);
        world.setBlock(i + 24, j + 63, k + 23, placeFrontierslatePillar(random), 0, 2);
        world.setBlock(i + 22, j + 63, k + 24, placeFrontierslatePillar(random), 0, 2);
        world.setBlock(i + 24, j + 63, k + 24, placeFrontierslatePillar(random), 0, 2);
        world.setBlock(i + 22, j + 63, k + 25, placeFrontierslatePillar(random), 0, 2);
        world.setBlock(i + 23, j + 63, k + 25, placeFrontierslatePillar(random), 0, 2);
        world.setBlock(i + 24, j + 63, k + 25, placeFrontierslatePillar(random), 0, 2);
        world.setBlock(i + 23, j + 64, k + 23, placeFrontierslatePillar(random), 0, 2);
        world.setBlock(i + 22, j + 64, k + 24, placeFrontierslatePillar(random), 0, 2);
        world.setBlock(i + 24, j + 64, k + 24, placeFrontierslatePillar(random), 0, 2);
        world.setBlock(i + 23, j + 64, k + 25, placeFrontierslatePillar(random), 0, 2);
        world.setBlock(i + 23, j + 65, k + 23, placeFrontierslatePillar(random), 0, 2);
        world.setBlock(i + 22, j + 65, k + 24, placeFrontierslatePillar(random), 0, 2);
        world.setBlock(i + 23, j + 65, k + 24, placeFrontierslatePillar(random), 0, 2);
        world.setBlock(i + 24, j + 65, k + 24, placeFrontierslatePillar(random), 0, 2);
        world.setBlock(i + 23, j + 65, k + 25, placeFrontierslatePillar(random), 0, 2);
        world.setBlock(i + 23, j + 66, k + 23, placeFrontierslatePillar(random), 0, 2);
        world.setBlock(i + 22, j + 66, k + 24, placeFrontierslatePillar(random), 0, 2);
        world.setBlock(i + 23, j + 66, k + 24, placeFrontierslatePillar(random), 0, 2);
        world.setBlock(i + 24, j + 66, k + 24, placeFrontierslatePillar(random), 0, 2);
        world.setBlock(i + 23, j + 66, k + 25, placeFrontierslatePillar(random), 0, 2);
        world.setBlock(i + 23, j + 67, k + 23, placeFrontierslatePillar(random), 0, 2);
        world.setBlock(i + 22, j + 67, k + 24, placeFrontierslatePillar(random), 0, 2);
        world.setBlock(i + 23, j + 67, k + 24, placeFrontierslatePillar(random), 0, 2);
        world.setBlock(i + 24, j + 67, k + 24, placeFrontierslatePillar(random), 0, 2);
        world.setBlock(i + 23, j + 67, k + 25, placeFrontierslatePillar(random), 0, 2);
        world.setBlock(i + 23, j + 68, k + 24, placeFrontierslatePillar(random), 0, 2);
        world.setBlock(i + 23, j + 69, k + 24, placeFrontierslatePillar(random), 0, 2);
        world.setBlock(i + 23, j + 70, k + 24, placeFrontierslatePillar(random), 0, 2);
        world.setBlock(i + 23, j + 71, k + 24, placeFrontierslatePillar(random), 0, 2);
        world.setBlock(i + 21, j + 20, k + 22, placeSculkedEndstone(random), 0, 2);
        world.setBlock(i + 22, j + 20, k + 22, placeSculkedEndstone(random), 0, 2);
        world.setBlock(i + 23, j + 20, k + 22, placeSculkedEndstone(random), 0, 2);
        world.setBlock(i + 24, j + 20, k + 22, placeSculkedEndstone(random), 0, 2);
        world.setBlock(i + 25, j + 20, k + 22, placeSculkedEndstone(random), 0, 2);
        world.setBlock(i + 21, j + 20, k + 23, placeSculkedEndstone(random), 0, 2);
        world.setBlock(i + 25, j + 20, k + 23, placeSculkedEndstone(random), 0, 2);
        world.setBlock(i + 21, j + 20, k + 24, placeSculkedEndstone(random), 0, 2);
        world.setBlock(i + 25, j + 20, k + 24, placeSculkedEndstone(random), 0, 2);
        world.setBlock(i + 21, j + 20, k + 25, placeSculkedEndstone(random), 0, 2);
        world.setBlock(i + 25, j + 20, k + 25, placeSculkedEndstone(random), 0, 2);
        world.setBlock(i + 21, j + 20, k + 26, placeSculkedEndstone(random), 0, 2);
        world.setBlock(i + 22, j + 20, k + 26, placeSculkedEndstone(random), 0, 2);
        world.setBlock(i + 23, j + 20, k + 26, placeSculkedEndstone(random), 0, 2);
        world.setBlock(i + 24, j + 20, k + 26, placeSculkedEndstone(random), 0, 2);
        world.setBlock(i + 25, j + 20, k + 26, placeSculkedEndstone(random), 0, 2);
        world.setBlock(i + 22, j + 20, k + 23, placeBuddingTsavorkite(random), 0, 2);
        world.setBlock(i + 23, j + 20, k + 23, placeBuddingAether(random), 0, 2);
        world.setBlock(i + 24, j + 20, k + 23, placeBuddingCopartz(random), 0, 2);
        world.setBlock(i + 22, j + 20, k + 24, placeBuddingAether(random), 0, 2);
        world.setBlock(i + 24, j + 20, k + 24, placeBuddingAether(random), 0, 2);
        world.setBlock(i + 22, j + 20, k + 25, placeBuddingLarimar(random), 0, 2);
        world.setBlock(i + 23, j + 20, k + 25, placeBuddingAether(random), 0, 2);
        world.setBlock(i + 24, j + 20, k + 25, placeBuddingYttrlinsite(random), 0, 2);
        world.setBlock(i + 23, j + 20, k + 24, NovaCraftBlocks.echo_block, 0, 2);
        world.setBlock(i + 22, j + 21, k + 23, placeTsavorkiteCluster(random), 1, 2);
        world.setBlock(i + 23, j + 21, k + 23, placeAetherCluster(random), 1, 2);
        world.setBlock(i + 24, j + 21, k + 23, placeCopartzCluster(random), 1, 2);
        world.setBlock(i + 22, j + 21, k + 24, placeAetherCluster(random), 1, 2);
        world.setBlock(i + 23, j + 21, k + 24, NovaCraftBlocks.echo_cluster_2, 1, 2);
        world.setBlock(i + 24, j + 21, k + 24, placeAetherCluster(random), 1, 2);
        world.setBlock(i + 22, j + 21, k + 25, placeLarimarCluster(random), 1, 2);
        world.setBlock(i + 23, j + 21, k + 25, placeAetherCluster(random), 1, 2);
        world.setBlock(i + 24, j + 21, k + 25, placeYttrlinsiteCluster(random), 1, 2);
        world.setBlock(i + 20, j + 27, k + 14, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 26, j + 27, k + 14, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 16, j + 27, k + 15, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 17, j + 27, k + 15, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 18, j + 27, k + 15, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 19, j + 27, k + 15, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 20, j + 27, k + 15, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 26, j + 27, k + 15, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 27, j + 27, k + 15, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 28, j + 27, k + 15, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 29, j + 27, k + 15, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 30, j + 27, k + 15, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 15, j + 27, k + 16, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 16, j + 27, k + 16, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 17, j + 27, k + 16, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 18, j + 27, k + 16, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 19, j + 27, k + 16, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 20, j + 27, k + 16, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 26, j + 27, k + 16, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 27, j + 27, k + 16, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 28, j + 27, k + 16, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 29, j + 27, k + 16, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 30, j + 27, k + 16, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 31, j + 27, k + 16, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 14, j + 27, k + 17, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 15, j + 27, k + 17, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 16, j + 27, k + 17, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 17, j + 27, k + 17, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 18, j + 27, k + 17, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 19, j + 27, k + 17, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 20, j + 27, k + 17, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 26, j + 27, k + 17, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 27, j + 27, k + 17, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 28, j + 27, k + 17, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 29, j + 27, k + 17, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 30, j + 27, k + 17, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 31, j + 27, k + 17, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 32, j + 27, k + 17, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 14, j + 27, k + 18, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 15, j + 27, k + 18, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 16, j + 27, k + 18, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 17, j + 27, k + 18, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 18, j + 27, k + 18, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 19, j + 27, k + 18, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 20, j + 27, k + 18, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 26, j + 27, k + 18, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 27, j + 27, k + 18, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 28, j + 27, k + 18, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 29, j + 27, k + 18, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 30, j + 27, k + 18, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 31, j + 27, k + 18, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 32, j + 27, k + 18, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 14, j + 27, k + 19, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 15, j + 27, k + 19, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 16, j + 27, k + 19, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 17, j + 27, k + 19, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 18, j + 27, k + 19, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 19, j + 27, k + 19, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 27, j + 27, k + 19, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 28, j + 27, k + 19, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 29, j + 27, k + 19, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 30, j + 27, k + 19, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 31, j + 27, k + 19, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 32, j + 27, k + 19, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 14, j + 27, k + 20, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 15, j + 27, k + 20, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 16, j + 27, k + 20, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 17, j + 27, k + 20, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 18, j + 27, k + 20, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 28, j + 27, k + 20, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 29, j + 27, k + 20, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 30, j + 27, k + 20, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 31, j + 27, k + 20, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 32, j + 27, k + 20, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 13, j + 27, k + 21, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 14, j + 27, k + 21, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 15, j + 27, k + 21, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 16, j + 27, k + 21, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 17, j + 27, k + 21, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 29, j + 27, k + 21, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 30, j + 27, k + 21, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 31, j + 27, k + 21, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 32, j + 27, k + 21, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 33, j + 27, k + 21, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 13, j + 27, k + 27, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 14, j + 27, k + 27, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 15, j + 27, k + 27, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 16, j + 27, k + 27, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 17, j + 27, k + 27, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 29, j + 27, k + 27, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 30, j + 27, k + 27, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 31, j + 27, k + 27, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 32, j + 27, k + 27, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 33, j + 27, k + 27, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 14, j + 27, k + 28, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 15, j + 27, k + 28, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 16, j + 27, k + 28, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 17, j + 27, k + 28, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 18, j + 27, k + 28, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 28, j + 27, k + 28, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 29, j + 27, k + 28, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 30, j + 27, k + 28, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 31, j + 27, k + 28, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 32, j + 27, k + 28, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 14, j + 27, k + 29, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 15, j + 27, k + 29, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 16, j + 27, k + 29, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 17, j + 27, k + 29, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 18, j + 27, k + 29, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 19, j + 27, k + 29, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 27, j + 27, k + 29, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 28, j + 27, k + 29, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 29, j + 27, k + 29, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 30, j + 27, k + 29, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 31, j + 27, k + 29, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 32, j + 27, k + 29, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 14, j + 27, k + 30, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 15, j + 27, k + 30, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 16, j + 27, k + 30, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 17, j + 27, k + 30, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 18, j + 27, k + 30, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 19, j + 27, k + 30, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 20, j + 27, k + 30, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 26, j + 27, k + 30, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 27, j + 27, k + 30, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 28, j + 27, k + 30, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 29, j + 27, k + 30, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 30, j + 27, k + 30, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 31, j + 27, k + 30, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 32, j + 27, k + 30, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 14, j + 27, k + 31, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 15, j + 27, k + 31, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 16, j + 27, k + 31, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 17, j + 27, k + 31, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 18, j + 27, k + 31, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 19, j + 27, k + 31, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 20, j + 27, k + 31, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 26, j + 27, k + 31, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 27, j + 27, k + 31, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 28, j + 27, k + 31, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 29, j + 27, k + 31, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 30, j + 27, k + 31, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 31, j + 27, k + 31, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 32, j + 27, k + 31, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 15, j + 27, k + 32, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 16, j + 27, k + 32, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 17, j + 27, k + 32, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 18, j + 27, k + 32, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 19, j + 27, k + 32, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 20, j + 27, k + 32, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 26, j + 27, k + 32, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 27, j + 27, k + 32, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 28, j + 27, k + 32, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 29, j + 27, k + 32, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 30, j + 27, k + 32, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 31, j + 27, k + 32, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 16, j + 27, k + 33, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 17, j + 27, k + 33, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 18, j + 27, k + 33, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 19, j + 27, k + 33, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 20, j + 27, k + 33, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 26, j + 27, k + 33, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 27, j + 27, k + 33, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 28, j + 27, k + 33, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 29, j + 27, k + 33, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 30, j + 27, k + 33, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 20, j + 27, k + 34, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 26, j + 27, k + 34, placeStainedGlass(random), 2, 2);
        world.setBlock(i + 18, j + 40, k + 15, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 19, j + 40, k + 15, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 20, j + 40, k + 15, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 26, j + 40, k + 15, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 27, j + 40, k + 15, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 28, j + 40, k + 15, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 16, j + 40, k + 16, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 17, j + 40, k + 16, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 18, j + 40, k + 16, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 19, j + 40, k + 16, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 20, j + 40, k + 16, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 26, j + 40, k + 16, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 27, j + 40, k + 16, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 28, j + 40, k + 16, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 29, j + 40, k + 16, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 30, j + 40, k + 16, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 15, j + 40, k + 17, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 16, j + 40, k + 17, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 17, j + 40, k + 17, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 18, j + 40, k + 17, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 19, j + 40, k + 17, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 20, j + 40, k + 17, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 26, j + 40, k + 17, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 27, j + 40, k + 17, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 28, j + 40, k + 17, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 29, j + 40, k + 17, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 30, j + 40, k + 17, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 31, j + 40, k + 17, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 15, j + 40, k + 18, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 16, j + 40, k + 18, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 17, j + 40, k + 18, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 18, j + 40, k + 18, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 19, j + 40, k + 18, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 20, j + 40, k + 18, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 26, j + 40, k + 18, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 27, j + 40, k + 18, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 28, j + 40, k + 18, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 29, j + 40, k + 18, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 30, j + 40, k + 18, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 31, j + 40, k + 18, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 14, j + 40, k + 19, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 15, j + 40, k + 19, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 16, j + 40, k + 19, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 17, j + 40, k + 19, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 18, j + 40, k + 19, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 19, j + 40, k + 19, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 20, j + 40, k + 19, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 26, j + 40, k + 19, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 27, j + 40, k + 19, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 28, j + 40, k + 19, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 29, j + 40, k + 19, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 30, j + 40, k + 19, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 31, j + 40, k + 19, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 32, j + 40, k + 19, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 14, j + 40, k + 20, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 15, j + 40, k + 20, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 16, j + 40, k + 20, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 17, j + 40, k + 20, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 18, j + 40, k + 20, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 19, j + 40, k + 20, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 20, j + 40, k + 20, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 26, j + 40, k + 20, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 27, j + 40, k + 20, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 28, j + 40, k + 20, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 29, j + 40, k + 20, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 30, j + 40, k + 20, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 31, j + 40, k + 20, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 32, j + 40, k + 20, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 14, j + 40, k + 21, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 15, j + 40, k + 21, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 16, j + 40, k + 21, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 17, j + 40, k + 21, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 18, j + 40, k + 21, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 19, j + 40, k + 21, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 20, j + 40, k + 21, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 26, j + 40, k + 21, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 27, j + 40, k + 21, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 28, j + 40, k + 21, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 29, j + 40, k + 21, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 30, j + 40, k + 21, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 31, j + 40, k + 21, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 32, j + 40, k + 21, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 14, j + 40, k + 27, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 15, j + 40, k + 27, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 16, j + 40, k + 27, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 17, j + 40, k + 27, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 18, j + 40, k + 27, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 19, j + 40, k + 27, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 20, j + 40, k + 27, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 26, j + 40, k + 27, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 27, j + 40, k + 27, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 28, j + 40, k + 27, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 29, j + 40, k + 27, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 30, j + 40, k + 27, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 31, j + 40, k + 27, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 32, j + 40, k + 27, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 14, j + 40, k + 28, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 15, j + 40, k + 28, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 16, j + 40, k + 28, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 17, j + 40, k + 28, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 18, j + 40, k + 28, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 19, j + 40, k + 28, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 20, j + 40, k + 28, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 26, j + 40, k + 28, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 27, j + 40, k + 28, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 28, j + 40, k + 28, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 29, j + 40, k + 28, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 30, j + 40, k + 28, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 31, j + 40, k + 28, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 32, j + 40, k + 28, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 14, j + 40, k + 29, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 15, j + 40, k + 29, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 16, j + 40, k + 29, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 17, j + 40, k + 29, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 18, j + 40, k + 29, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 19, j + 40, k + 29, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 20, j + 40, k + 29, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 26, j + 40, k + 29, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 27, j + 40, k + 29, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 28, j + 40, k + 29, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 29, j + 40, k + 29, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 30, j + 40, k + 29, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 31, j + 40, k + 29, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 32, j + 40, k + 29, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 15, j + 40, k + 30, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 16, j + 40, k + 30, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 17, j + 40, k + 30, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 18, j + 40, k + 30, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 19, j + 40, k + 30, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 20, j + 40, k + 30, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 26, j + 40, k + 30, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 27, j + 40, k + 30, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 28, j + 40, k + 30, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 29, j + 40, k + 30, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 30, j + 40, k + 30, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 31, j + 40, k + 30, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 15, j + 40, k + 31, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 16, j + 40, k + 31, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 17, j + 40, k + 31, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 18, j + 40, k + 31, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 19, j + 40, k + 31, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 20, j + 40, k + 31, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 26, j + 40, k + 31, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 27, j + 40, k + 31, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 28, j + 40, k + 31, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 29, j + 40, k + 31, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 30, j + 40, k + 31, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 31, j + 40, k + 31, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 16, j + 40, k + 32, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 17, j + 40, k + 32, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 18, j + 40, k + 32, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 19, j + 40, k + 32, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 20, j + 40, k + 32, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 26, j + 40, k + 32, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 27, j + 40, k + 32, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 28, j + 40, k + 32, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 29, j + 40, k + 32, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 30, j + 40, k + 32, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 18, j + 40, k + 33, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 19, j + 40, k + 33, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 20, j + 40, k + 33, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 26, j + 40, k + 33, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 27, j + 40, k + 33, placeStainedGlass(random), 10, 2);
        world.setBlock(i + 28, j + 40, k + 33, placeStainedGlass(random), 10, 2);

        this.setBlockAndNotifyAdequately(world, i + 23, j + 60, k + 24, Blocks.chest, 2);
        TileEntity tile = world.getTileEntity(i + 23, j + 60, k + 24);
        if (tile instanceof TileEntityChest) {
            TileEntityChest chest = (TileEntityChest) tile;

            for (int slot = 0; slot < 3 + random.nextInt(20); slot++) {
                chest.setInventorySlotContents(random.nextInt(chest.getSizeInventory()), this.getEndLoot(random));
            }
        }

        if (random.nextBoolean()) {
            world.setBlock(i + 20, j + 46, k + 21, Blocks.mob_spawner, 0, 2);
            TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner) world.getTileEntity(i + 20, j + 46, k + 21);

            if (tileentitymobspawner != null) {
                tileentitymobspawner.func_145881_a().setEntityName("nova_craft.phantom");
            }
        }

        world.setBlock(i + 23, j + 64, k + 24, Blocks.mob_spawner, 0, 2);
        TileEntityMobSpawner tileentitymobspawner2 = (TileEntityMobSpawner)world.getTileEntity(i + 23, j + 64, k + 24);

        if (tileentitymobspawner2 != null) {
            tileentitymobspawner2.func_145881_a().setEntityName("nova_craft.phantom");
        }

        if (random.nextBoolean()) {
            world.setBlock(i + 46, j + 38, k + 26, Blocks.mob_spawner, 0, 2);
            TileEntityMobSpawner tileentitymobspawner3 = (TileEntityMobSpawner) world.getTileEntity(i + 46, j + 38, k + 26);

            if (tileentitymobspawner3 != null) {
                tileentitymobspawner3.func_145881_a().setEntityName("nova_craft.phantom");
            }
        }

        if (random.nextBoolean()) {
            world.setBlock(i + 25, j + 38, k + 1, Blocks.mob_spawner, 0, 2);
            TileEntityMobSpawner tileentitymobspawner4 = (TileEntityMobSpawner) world.getTileEntity(i + 25, j + 38, k + 1);

            if (tileentitymobspawner4 != null) {
                tileentitymobspawner4.func_145881_a().setEntityName("nova_craft.phantom");
            }
        }

        if (random.nextBoolean()) {
            world.setBlock(i, j + 37, k + 22, Blocks.mob_spawner, 0, 2);
            TileEntityMobSpawner tileentitymobspawner5 = (TileEntityMobSpawner) world.getTileEntity(i, j + 37, k + 22);

            if (tileentitymobspawner5 != null) {
                tileentitymobspawner5.func_145881_a().setEntityName("nova_craft.phantom");
            }
        }

        if (random.nextBoolean()) {
            world.setBlock(i + 23, j + 32, k + 34, Blocks.mob_spawner, 0, 2);
            TileEntityMobSpawner tileentitymobspawner6 = (TileEntityMobSpawner) world.getTileEntity(i + 23, j + 32, k + 34);

            if (tileentitymobspawner6 != null) {
                tileentitymobspawner6.func_145881_a().setEntityName("nova_craft.phantom");
            }
        }

        if (random.nextBoolean()) {
            world.setBlock(i + 25, j + 36, k + 47, Blocks.mob_spawner, 0, 2);
            TileEntityMobSpawner tileentitymobspawner7 = (TileEntityMobSpawner) world.getTileEntity(i + 25, j + 36, k + 47);

            if (tileentitymobspawner7 != null) {
                tileentitymobspawner7.func_145881_a().setEntityName("nova_craft.phantom");
            }
        }

        return true;
    }

    private Block placeStainedGlass(Random random) {
        if (random.nextDouble() < 0.95) {
            return Blocks.stained_glass;
        } else {
            return Blocks.air;
        }
    }

    private Block placeFrontierslatePillar(Random random) {
        if (random.nextDouble() < 0.99) {
            return NovaCraftBlocks.frontierslate_pillar;
        } else {
            return Blocks.air;
        }
    }

    private Block placePurpur(Random random) {
        if (random.nextDouble() < 0.95) {
            return PlacePurpur;
        } else {
            return Blocks.air;
        }
    }

    private Block placeEndStoneBrickStairs(Random random) {
        if (random.nextDouble() < 0.95) {
            return PlaceEndstoneBrickStairs;
        } else {
            return Blocks.air;
        }
    }

    private Block placePurpurStairs(Random random) {
        if (random.nextDouble() < 0.95) {
            return PlacePurpurStairs;
        } else {
            return Blocks.air;
        }
    }

    private Block placeSculkedEndstone(Random random) {
        if (random.nextDouble() < 0.70) {
            return NovaCraftBlocks.sculk_endstone;
        } else {
            return Blocks.end_stone;
        }
    }

    private Block placeBuddingTsavorkite(Random random) {
        if (random.nextDouble() < 0.50) {
            return NovaCraftBlocks.budding_tsavorokite_block;
        } else {
            return NovaCraftBlocks.cracked_tsavorokite_block;
        }
    }

    private Block placeTsavorkiteCluster(Random random) {
        if (random.nextDouble() < 0.90) {
            return NovaCraftBlocks.tsavorokite_cluster_2;
        } else {
            return Blocks.air;
        }
    }

    private Block placeBuddingCopartz(Random random) {
        if (random.nextDouble() < 0.50) {
            return NovaCraftBlocks.budding_copartz_block;
        } else {
            return NovaCraftBlocks.cracked_copartz_block;
        }
    }

    private Block placeCopartzCluster(Random random) {
        if (random.nextDouble() < 0.90) {
            return NovaCraftBlocks.copartz_cluster_2;
        } else {
            return Blocks.air;
        }
    }

    private Block placeBuddingLarimar(Random random) {
        if (random.nextDouble() < 0.50) {
            return NovaCraftBlocks.budding_larimar_block;
        } else {
            return NovaCraftBlocks.cracked_larimar_block;
        }
    }

    private Block placeLarimarCluster(Random random) {
        if (random.nextDouble() < 0.90) {
            return NovaCraftBlocks.larimar_cluster_2;
        } else {
            return Blocks.air;
        }
    }

    private Block placeBuddingYttrlinsite(Random random) {
        if (random.nextDouble() < 0.50) {
            return NovaCraftBlocks.budding_yttrlinsite_block;
        } else {
            return NovaCraftBlocks.cracked_yttrlinsite_block;
        }
    }

    private Block placeYttrlinsiteCluster(Random random) {
        if (random.nextDouble() < 0.90) {
            return NovaCraftBlocks.yttrlinsite_cluster_2;
        } else {
            return Blocks.air;
        }
    }

    private Block placeBuddingAether(Random random) {
        if (random.nextDouble() < 0.50) {
            return NovaCraftBlocks.budding_aether_block;
        } else {
            return NovaCraftBlocks.cracked_aether_block;
        }
    }

    private Block placeAetherCluster(Random random) {
        if (random.nextDouble() < 0.90) {
            return NovaCraftBlocks.aether_cluster_2;
        } else {
            return Blocks.air;
        }
    }

    private Block placeSculkTentacle(Random random) {
        if (random.nextDouble() < 0.50) {
            return NovaCraftBlocks.sculk_tentacle_2;
        } else {
            return Blocks.air;
        }
    }

    private ItemStack getEndLoot(Random random) {
        int item = random.nextInt(26);
        switch (item) {
            case 0:
                return new ItemStack(NovaCraftItems.small_xancium_dust, random.nextInt(15) + 8);
            case 1:
                return new ItemStack(Items.ender_pearl, random.nextInt(4) + 6);
            case 2:
                return new ItemStack(Items.ender_pearl, random.nextInt(3) + 9);
            case 3:
                return new ItemStack(NovaCraftItems.copartz_shard, random.nextInt(2) + 1);
            case 4:
                return new ItemStack(NovaCraftItems.static_essence, random.nextInt(6) + 4);
            case 5:
                return new ItemStack(NovaCraftItems.larimar_shard, random.nextInt(2) + 1);
            case 6:
                return new ItemStack(NovaCraftItems.tsavorokite_shard, random.nextInt(2) + 1);
            case 7:
                return new ItemStack(NovaCraftItems.yttrlinsite_shard, random.nextInt(2) + 1);
            case 8:
                return new ItemStack(NovaCraftItems.aether_shard, random.nextInt(2) + 1);
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
                return new ItemStack(NovaCraftItems.iridium_nugget, random.nextInt(2) + 1, 1);
            case 12:
                return new ItemStack(NovaCraftItems.diamond_nugget, random.nextInt(5) + 3, 1);
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
                return new ItemStack(NovaCraftBlocks.sculk_endstone, random.nextInt(7) + 7);
            case 22:
                return new ItemStack(NovaCraftItems.xancium_ingot, random.nextInt(2) + 1);
            case 23:
                return new ItemStack(NovaCraftItems.iridium_nugget, random.nextInt(2) + 1, 2);
            default: {
                return new ItemStack(NovaCraftItems.diamond_nugget, random.nextInt(5) + 3, 2);
            }
        }
    }
}
