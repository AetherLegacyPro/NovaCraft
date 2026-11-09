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
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class AncientEndBaseShrine extends WorldGenerator {

    public AncientEndBaseShrine() {
    }

    private Block PlaceEndstoneBricks;
    private Block PlacePurpur;
    private Block PlaceEndRod;
    private Block PlacePurpurStairs;
    private Block PlacePurpurSlab;

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

    private Block determineIfPurpurSlabExists(World world, int x, int y, int z) {
        Block existingBlock = world.getBlock(x, y, z);
        if (ConfigsCompact.enablePurpur && Loader.isModLoaded("etfuturum")) {
            try {
                Block purpur_slab = GameRegistry.findBlock("etfuturum", "purpur_slab");
                if (purpur_slab != null && (existingBlock == null || existingBlock != purpur_slab)) {
                    return purpur_slab;
                }
            } catch (Exception ex) {
                if (Configs.enableDebugMode) {
                    System.out.println("Missing Purpur from Et Futurum Requiem, using Vanite Bricks instead...");
                }
                return NovaCraftBlocks.vanite_brick_slab;
            }
        }

        return NovaCraftBlocks.vanite_brick_slab;
    }

    private Block determineIfEndRodExists(World world, int x, int y, int z) {
        Block existingBlock = world.getBlock(x, y, z);
        if (ConfigsCompact.enableEndRod && Loader.isModLoaded("etfuturum")) {
            try {
                Block end_rod = GameRegistry.findBlock("etfuturum", "end_rod");
                if (end_rod != null && (existingBlock == null || existingBlock != end_rod)) {
                    return end_rod;
                }
            } catch (Exception ex) {
                if (Configs.enableDebugMode) {
                    System.out.println("Missing Endstone Rod from Et Futurum Requiem, using Nothing instead...");
                }
                return Blocks.air;
            }
        }

        return Blocks.air;
    }

    public boolean generate(final World world, final Random random, final int i, final int j, final int k) {
        PlaceEndstoneBricks = determineIfEndstoneBricksExists(world, i + 5, j + 5, k);
        PlacePurpur = determineIfPurpurExists(world, i + 7, j + 5, k);
        PlaceEndRod = determineIfEndRodExists(world, i + 7, j + 8, k + 7);
        PlacePurpurStairs = determineIfPurpurBrickStairsExists(world, i + 7, j + 6, k + 1);
        PlacePurpurSlab = determineIfPurpurSlabExists(world, i + 7, j + 11, k + 3);

        world.setBlock(i + 4, j, k + 4, Blocks.end_stone, 0, 2);
        world.setBlock(i + 11, j, k + 9, Blocks.end_stone, 0, 2);
        world.setBlock(i + 4, j, k + 10, Blocks.end_stone, 0, 2);
        world.setBlock(i + 10, j + 1, k + 3, Blocks.end_stone, 0, 2);
        world.setBlock(i + 4, j + 1, k + 4, Blocks.end_stone, 0, 2);
        world.setBlock(i + 11, j + 1, k + 9, Blocks.end_stone, 0, 2);
        world.setBlock(i + 12, j + 1, k + 9, Blocks.end_stone, 0, 2);
        world.setBlock(i + 4, j + 1, k + 10, Blocks.end_stone, 0, 2);
        world.setBlock(i + 4, j + 1, k + 11, Blocks.end_stone, 0, 2);
        world.setBlock(i + 4, j + 2, k + 3, Blocks.end_stone, 0, 2);
        world.setBlock(i + 9, j + 2, k + 3, Blocks.end_stone, 0, 2);
        world.setBlock(i + 10, j + 2, k + 3, Blocks.end_stone, 0, 2);
        world.setBlock(i + 4, j + 2, k + 4, Blocks.end_stone, 0, 2);
        world.setBlock(i + 10, j + 2, k + 4, Blocks.end_stone, 0, 2);
        world.setBlock(i + 6, j + 2, k + 7, Blocks.end_stone, 0, 2);
        world.setBlock(i + 11, j + 2, k + 8, Blocks.end_stone, 0, 2);
        world.setBlock(i + 1, j + 2, k + 9, Blocks.end_stone, 0, 2);
        world.setBlock(i + 10, j + 2, k + 9, Blocks.end_stone, 0, 2);
        world.setBlock(i + 11, j + 2, k + 9, Blocks.end_stone, 0, 2);
        world.setBlock(i + 12, j + 2, k + 9, Blocks.end_stone, 0, 2);
        world.setBlock(i + 4, j + 2, k + 10, Blocks.end_stone, 0, 2);
        world.setBlock(i + 4, j + 2, k + 11, Blocks.end_stone, 0, 2);
        world.setBlock(i + 9, j + 3, k + 2, Blocks.end_stone, 0, 2);
        world.setBlock(i + 10, j + 3, k + 2, Blocks.end_stone, 0, 2);
        world.setBlock(i + 4, j + 3, k + 3, Blocks.end_stone, 0, 2);
        world.setBlock(i + 9, j + 3, k + 3, Blocks.end_stone, 0, 2);
        world.setBlock(i + 10, j + 3, k + 3, Blocks.end_stone, 0, 2);
        world.setBlock(i + 4, j + 3, k + 4, Blocks.end_stone, 0, 2);
        world.setBlock(i + 5, j + 3, k + 4, Blocks.end_stone, 0, 2);
        world.setBlock(i + 10, j + 3, k + 4, Blocks.end_stone, 0, 2);
        world.setBlock(i + 5, j + 3, k + 5, Blocks.end_stone, 0, 2);
        world.setBlock(i + 6, j + 3, k + 6, Blocks.end_stone, 0, 2);
        world.setBlock(i + 6, j + 3, k + 7, Blocks.end_stone, 0, 2);
        world.setBlock(i + 7, j + 3, k + 7, Blocks.end_stone, 0, 2);
        world.setBlock(i + 11, j + 3, k + 7, Blocks.end_stone, 0, 2);
        world.setBlock(i + 1, j + 3, k + 8, Blocks.end_stone, 0, 2);
        world.setBlock(i + 2, j + 3, k + 8, Blocks.end_stone, 0, 2);
        world.setBlock(i + 10, j + 3, k + 8, Blocks.end_stone, 0, 2);
        world.setBlock(i + 11, j + 3, k + 8, Blocks.end_stone, 0, 2);
        world.setBlock(i + 12, j + 3, k + 8, Blocks.end_stone, 0, 2);
        world.setBlock(i + 1, j + 3, k + 9, Blocks.end_stone, 0, 2);
        world.setBlock(i + 2, j + 3, k + 9, Blocks.end_stone, 0, 2);
        world.setBlock(i + 9, j + 3, k + 9, Blocks.end_stone, 0, 2);
        world.setBlock(i + 10, j + 3, k + 9, Blocks.end_stone, 0, 2);
        world.setBlock(i + 11, j + 3, k + 9, Blocks.end_stone, 0, 2);
        world.setBlock(i + 12, j + 3, k + 9, Blocks.end_stone, 0, 2);
        world.setBlock(i + 4, j + 3, k + 10, Blocks.end_stone, 0, 2);
        world.setBlock(i + 10, j + 3, k + 10, Blocks.end_stone, 0, 2);
        world.setBlock(i + 11, j + 3, k + 10, Blocks.end_stone, 0, 2);
        world.setBlock(i + 12, j + 3, k + 10, Blocks.end_stone, 0, 2);
        world.setBlock(i + 4, j + 3, k + 11, Blocks.end_stone, 0, 2);
        world.setBlock(i + 5, j + 4, k + 2, Blocks.end_stone, 0, 2);
        world.setBlock(i + 9, j + 4, k + 2, Blocks.end_stone, 0, 2);
        world.setBlock(i + 10, j + 4, k + 2, Blocks.end_stone, 0, 2);
        world.setBlock(i + 3, j + 4, k + 3, Blocks.end_stone, 0, 2);
        world.setBlock(i + 4, j + 4, k + 3, Blocks.end_stone, 0, 2);
        world.setBlock(i + 5, j + 4, k + 3, Blocks.end_stone, 0, 2);
        world.setBlock(i + 6, j + 4, k + 3, Blocks.end_stone, 0, 2);
        world.setBlock(i + 9, j + 4, k + 3, Blocks.end_stone, 0, 2);
        world.setBlock(i + 10, j + 4, k + 3, Blocks.end_stone, 0, 2);
        world.setBlock(i + 2, j + 4, k + 4, Blocks.end_stone, 0, 2);
        world.setBlock(i + 3, j + 4, k + 4, Blocks.end_stone, 0, 2);
        world.setBlock(i + 4, j + 4, k + 4, Blocks.end_stone, 0, 2);
        world.setBlock(i + 5, j + 4, k + 4, Blocks.end_stone, 0, 2);
        world.setBlock(i + 6, j + 4, k + 4, Blocks.end_stone, 0, 2);
        world.setBlock(i + 8, j + 4, k + 4, Blocks.end_stone, 0, 2);
        world.setBlock(i + 9, j + 4, k + 4, Blocks.end_stone, 0, 2);
        world.setBlock(i + 10, j + 4, k + 4, Blocks.end_stone, 0, 2);
        world.setBlock(i + 11, j + 4, k + 4, Blocks.end_stone, 0, 2);
        world.setBlock(i + 3, j + 4, k + 5, Blocks.end_stone, 0, 2);
        world.setBlock(i + 4, j + 4, k + 5, Blocks.end_stone, 0, 2);
        world.setBlock(i + 5, j + 4, k + 5, Blocks.end_stone, 0, 2);
        world.setBlock(i + 10, j + 4, k + 5, Blocks.end_stone, 0, 2);
        world.setBlock(i + 11, j + 4, k + 5, Blocks.end_stone, 0, 2);
        world.setBlock(i + 5, j + 4, k + 6, Blocks.end_stone, 0, 2);
        world.setBlock(i + 6, j + 4, k + 6, Blocks.end_stone, 0, 2);
        world.setBlock(i + 10, j + 4, k + 6, Blocks.end_stone, 0, 2);
        world.setBlock(i + 11, j + 4, k + 6, Blocks.end_stone, 0, 2);
        world.setBlock(i + 12, j + 4, k + 6, Blocks.end_stone, 0, 2);
        world.setBlock(i + 13, j + 4, k + 6, Blocks.end_stone, 0, 2);
        world.setBlock(i + 6, j + 4, k + 7, Blocks.end_stone, 0, 2);
        world.setBlock(i + 7, j + 4, k + 7, Blocks.end_stone, 0, 2);
        world.setBlock(i + 9, j + 4, k + 7, Blocks.end_stone, 0, 2);
        world.setBlock(i + 10, j + 4, k + 7, Blocks.end_stone, 0, 2);
        world.setBlock(i + 11, j + 4, k + 7, Blocks.end_stone, 0, 2);
        world.setBlock(i + 12, j + 4, k + 7, Blocks.end_stone, 0, 2);
        world.setBlock(i + 13, j + 4, k + 7, Blocks.end_stone, 0, 2);
        world.setBlock(i + 1, j + 4, k + 8, Blocks.end_stone, 0, 2);
        world.setBlock(i + 2, j + 4, k + 8, Blocks.end_stone, 0, 2);
        world.setBlock(i + 6, j + 4, k + 8, Blocks.end_stone, 0, 2);
        world.setBlock(i + 8, j + 4, k + 8, Blocks.end_stone, 0, 2);
        world.setBlock(i + 9, j + 4, k + 8, Blocks.end_stone, 0, 2);
        world.setBlock(i + 10, j + 4, k + 8, Blocks.end_stone, 0, 2);
        world.setBlock(i + 11, j + 4, k + 8, Blocks.end_stone, 0, 2);
        world.setBlock(i + 12, j + 4, k + 8, Blocks.end_stone, 0, 2);
        world.setBlock(i + 13, j + 4, k + 8, Blocks.end_stone, 0, 2);
        world.setBlock(i + 1, j + 4, k + 9, Blocks.end_stone, 0, 2);
        world.setBlock(i + 2, j + 4, k + 9, Blocks.end_stone, 0, 2);
        world.setBlock(i + 3, j + 4, k + 9, Blocks.end_stone, 0, 2);
        world.setBlock(i + 4, j + 4, k + 9, Blocks.end_stone, 0, 2);
        world.setBlock(i + 8, j + 4, k + 9, Blocks.end_stone, 0, 2);
        world.setBlock(i + 9, j + 4, k + 9, Blocks.end_stone, 0, 2);
        world.setBlock(i + 10, j + 4, k + 9, Blocks.end_stone, 0, 2);
        world.setBlock(i + 11, j + 4, k + 9, Blocks.end_stone, 0, 2);
        world.setBlock(i + 12, j + 4, k + 9, Blocks.end_stone, 0, 2);
        world.setBlock(i + 13, j + 4, k + 9, Blocks.end_stone, 0, 2);
        world.setBlock(i + 3, j + 4, k + 10, Blocks.end_stone, 0, 2);
        world.setBlock(i + 4, j + 4, k + 10, Blocks.end_stone, 0, 2);
        world.setBlock(i + 5, j + 4, k + 10, Blocks.end_stone, 0, 2);
        world.setBlock(i + 8, j + 4, k + 10, Blocks.end_stone, 0, 2);
        world.setBlock(i + 9, j + 4, k + 10, Blocks.end_stone, 0, 2);
        world.setBlock(i + 10, j + 4, k + 10, Blocks.end_stone, 0, 2);
        world.setBlock(i + 11, j + 4, k + 10, Blocks.end_stone, 0, 2);
        world.setBlock(i + 12, j + 4, k + 10, Blocks.end_stone, 0, 2);
        world.setBlock(i + 13, j + 4, k + 10, Blocks.end_stone, 0, 2);
        world.setBlock(i + 3, j + 4, k + 11, Blocks.end_stone, 0, 2);
        world.setBlock(i + 4, j + 4, k + 11, Blocks.end_stone, 0, 2);
        world.setBlock(i + 5, j + 4, k + 11, Blocks.end_stone, 0, 2);
        world.setBlock(i + 6, j + 4, k + 11, Blocks.end_stone, 0, 2);
        world.setBlock(i + 9, j + 4, k + 11, Blocks.end_stone, 0, 2);
        world.setBlock(i + 10, j + 4, k + 11, Blocks.end_stone, 0, 2);
        world.setBlock(i + 11, j + 4, k + 11, Blocks.end_stone, 0, 2);
        world.setBlock(i + 12, j + 4, k + 11, Blocks.end_stone, 0, 2);
        world.setBlock(i + 4, j + 4, k + 12, Blocks.end_stone, 0, 2);
        world.setBlock(i + 5, j + 4, k + 12, Blocks.end_stone, 0, 2);
        world.setBlock(i + 6, j + 4, k + 12, Blocks.end_stone, 0, 2);
        world.setBlock(i + 10, j + 4, k + 12, Blocks.end_stone, 0, 2);
        world.setBlock(i + 5, j + 5, k, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 6, j + 5, k, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 7, j + 5, k, placePurpur(random), 0, 2);
        world.setBlock(i + 8, j + 5, k, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 9, j + 5, k, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 5, k + 1, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 4, j + 5, k + 1, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 5, j + 5, k + 1, Blocks.obsidian, 0, 2);
        world.setBlock(i + 6, j + 5, k + 1, Blocks.obsidian, 0, 2);
        world.setBlock(i + 7, j + 5, k + 1, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j + 5, k + 1, Blocks.obsidian, 0, 2);
        world.setBlock(i + 9, j + 5, k + 1, Blocks.obsidian, 0, 2);
        world.setBlock(i + 10, j + 5, k + 1, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 11, j + 5, k + 1, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 2, j + 5, k + 2, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 5, k + 2, Blocks.obsidian, 0, 2);
        world.setBlock(i + 4, j + 5, k + 2, Blocks.obsidian, 0, 2);
        world.setBlock(i + 5, j + 5, k + 2, Blocks.stained_glass, 10, 2);
        world.setBlock(i + 6, j + 5, k + 2, Blocks.obsidian, 0, 2);
        world.setBlock(i + 7, j + 5, k + 2, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j + 5, k + 2, Blocks.obsidian, 0, 2);
        world.setBlock(i + 9, j + 5, k + 2, Blocks.stained_glass, 10, 2);
        world.setBlock(i + 10, j + 5, k + 2, Blocks.obsidian, 0, 2);
        world.setBlock(i + 11, j + 5, k + 2, Blocks.obsidian, 0, 2);
        world.setBlock(i + 12, j + 5, k + 2, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 1, j + 5, k + 3, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 2, j + 5, k + 3, Blocks.obsidian, 0, 2);
        world.setBlock(i + 3, j + 5, k + 3, Blocks.stained_glass, 10, 2);
        world.setBlock(i + 4, j + 5, k + 3, Blocks.stained_glass, 2, 2);
        world.setBlock(i + 5, j + 5, k + 3, Blocks.stained_glass, 2, 2);
        world.setBlock(i + 6, j + 5, k + 3, Blocks.obsidian, 0, 2);
        world.setBlock(i + 7, j + 5, k + 3, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j + 5, k + 3, Blocks.obsidian, 0, 2);
        world.setBlock(i + 9, j + 5, k + 3, Blocks.stained_glass, 2, 2);
        world.setBlock(i + 10, j + 5, k + 3, Blocks.stained_glass, 2, 2);
        world.setBlock(i + 11, j + 5, k + 3, Blocks.stained_glass, 10, 2);
        world.setBlock(i + 12, j + 5, k + 3, Blocks.obsidian, 0, 2);
        world.setBlock(i + 13, j + 5, k + 3, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 1, j + 5, k + 4, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 2, j + 5, k + 4, Blocks.obsidian, 0, 2);
        world.setBlock(i + 3, j + 5, k + 4, Blocks.stained_glass, 2, 2);
        world.setBlock(i + 4, j + 5, k + 4, Blocks.stained_glass, 10, 2);
        world.setBlock(i + 5, j + 5, k + 4, Blocks.stained_glass, 10, 2);
        world.setBlock(i + 6, j + 5, k + 4, Blocks.obsidian, 0, 2);
        world.setBlock(i + 7, j + 5, k + 4, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j + 5, k + 4, Blocks.obsidian, 0, 2);
        world.setBlock(i + 9, j + 5, k + 4, Blocks.stained_glass, 10, 2);
        world.setBlock(i + 10, j + 5, k + 4, Blocks.stained_glass, 10, 2);
        world.setBlock(i + 11, j + 5, k + 4, Blocks.stained_glass, 2, 2);
        world.setBlock(i + 12, j + 5, k + 4, Blocks.obsidian, 0, 2);
        world.setBlock(i + 13, j + 5, k + 4, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i, j + 5, k + 5, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 1, j + 5, k + 5, Blocks.obsidian, 0, 2);
        world.setBlock(i + 2, j + 5, k + 5, Blocks.stained_glass, 10, 2);
        world.setBlock(i + 3, j + 5, k + 5, Blocks.stained_glass, 2, 2);
        world.setBlock(i + 4, j + 5, k + 5, Blocks.stained_glass, 10, 2);
        world.setBlock(i + 5, j + 5, k + 5, Blocks.obsidian, 0, 2);
        world.setBlock(i + 6, j + 5, k + 5, placePurpur(random), 0, 2);
        world.setBlock(i + 7, j + 5, k + 5, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j + 5, k + 5, placePurpur(random), 0, 2);
        world.setBlock(i + 9, j + 5, k + 5, Blocks.obsidian, 0, 2);
        world.setBlock(i + 10, j + 5, k + 5, Blocks.stained_glass, 10, 2);
        world.setBlock(i + 11, j + 5, k + 5, Blocks.stained_glass, 2, 2);
        world.setBlock(i + 12, j + 5, k + 5, Blocks.stained_glass, 10, 2);
        world.setBlock(i + 13, j + 5, k + 5, Blocks.obsidian, 0, 2);
        world.setBlock(i + 14, j + 5, k + 5, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i, j + 5, k + 6, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 1, j + 5, k + 6, Blocks.obsidian, 0, 2);
        world.setBlock(i + 2, j + 5, k + 6, Blocks.obsidian, 0, 2);
        world.setBlock(i + 3, j + 5, k + 6, Blocks.obsidian, 0, 2);
        world.setBlock(i + 4, j + 5, k + 6, Blocks.obsidian, 0, 2);
        world.setBlock(i + 5, j + 5, k + 6, placePurpur(random), 0, 2);
        world.setBlock(i + 6, j + 5, k + 6, placePurpur(random), 0, 2);
        world.setBlock(i + 7, j + 5, k + 6, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j + 5, k + 6, placePurpur(random), 0, 2);
        world.setBlock(i + 9, j + 5, k + 6, placePurpur(random), 0, 2);
        world.setBlock(i + 10, j + 5, k + 6, Blocks.obsidian, 0, 2);
        world.setBlock(i + 11, j + 5, k + 6, Blocks.obsidian, 0, 2);
        world.setBlock(i + 12, j + 5, k + 6, Blocks.obsidian, 0, 2);
        world.setBlock(i + 13, j + 5, k + 6, Blocks.obsidian, 0, 2);
        world.setBlock(i + 14, j + 5, k + 6, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i, j + 5, k + 7, placePurpur(random), 0, 2);
        world.setBlock(i + 1, j + 5, k + 7, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 2, j + 5, k + 7, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 5, k + 7, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 4, j + 5, k + 7, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 5, j + 5, k + 7, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 6, j + 5, k + 7, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 7, j + 5, k + 7, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j + 5, k + 7, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 9, j + 5, k + 7, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 10, j + 5, k + 7, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 11, j + 5, k + 7, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 12, j + 5, k + 7, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 13, j + 5, k + 7, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 14, j + 5, k + 7, placePurpur(random), 0, 2);
        world.setBlock(i, j + 5, k + 8, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 1, j + 5, k + 8, Blocks.obsidian, 0, 2);
        world.setBlock(i + 2, j + 5, k + 8, Blocks.obsidian, 0, 2);
        world.setBlock(i + 3, j + 5, k + 8, Blocks.obsidian, 0, 2);
        world.setBlock(i + 4, j + 5, k + 8, Blocks.obsidian, 0, 2);
        world.setBlock(i + 5, j + 5, k + 8, placePurpur(random), 0, 2);
        world.setBlock(i + 6, j + 5, k + 8, placePurpur(random), 0, 2);
        world.setBlock(i + 7, j + 5, k + 8, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j + 5, k + 8, placePurpur(random), 0, 2);
        world.setBlock(i + 9, j + 5, k + 8, placePurpur(random), 0, 2);
        world.setBlock(i + 10, j + 5, k + 8, Blocks.obsidian, 0, 2);
        world.setBlock(i + 11, j + 5, k + 8, Blocks.obsidian, 0, 2);
        world.setBlock(i + 12, j + 5, k + 8, Blocks.obsidian, 0, 2);
        world.setBlock(i + 13, j + 5, k + 8, Blocks.obsidian, 0, 2);
        world.setBlock(i + 14, j + 5, k + 8, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i, j + 5, k + 9, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 1, j + 5, k + 9, Blocks.obsidian, 0, 2);
        world.setBlock(i + 2, j + 5, k + 9, Blocks.stained_glass, 10, 2);
        world.setBlock(i + 3, j + 5, k + 9, Blocks.stained_glass, 2, 2);
        world.setBlock(i + 4, j + 5, k + 9, Blocks.stained_glass, 10, 2);
        world.setBlock(i + 5, j + 5, k + 9, Blocks.obsidian, 0, 2);
        world.setBlock(i + 6, j + 5, k + 9, placePurpur(random), 0, 2);
        world.setBlock(i + 7, j + 5, k + 9, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j + 5, k + 9, placePurpur(random), 0, 2);
        world.setBlock(i + 9, j + 5, k + 9, Blocks.obsidian, 0, 2);
        world.setBlock(i + 10, j + 5, k + 9, Blocks.stained_glass, 10, 2);
        world.setBlock(i + 11, j + 5, k + 9, Blocks.stained_glass, 2, 2);
        world.setBlock(i + 12, j + 5, k + 9, Blocks.stained_glass, 10, 2);
        world.setBlock(i + 13, j + 5, k + 9, Blocks.obsidian, 0, 2);
        world.setBlock(i + 14, j + 5, k + 9, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 1, j + 5, k + 10, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 2, j + 5, k + 10, Blocks.obsidian, 0, 2);
        world.setBlock(i + 3, j + 5, k + 10, Blocks.stained_glass, 2, 2);
        world.setBlock(i + 4, j + 5, k + 10, Blocks.stained_glass, 10, 2);
        world.setBlock(i + 5, j + 5, k + 10, Blocks.stained_glass, 10, 2);
        world.setBlock(i + 6, j + 5, k + 10, Blocks.obsidian, 0, 2);
        world.setBlock(i + 7, j + 5, k + 10, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j + 5, k + 10, Blocks.obsidian, 0, 2);
        world.setBlock(i + 9, j + 5, k + 10, Blocks.stained_glass, 10, 2);
        world.setBlock(i + 10, j + 5, k + 10, Blocks.stained_glass, 10, 2);
        world.setBlock(i + 11, j + 5, k + 10, Blocks.stained_glass, 2, 2);
        world.setBlock(i + 12, j + 5, k + 10, Blocks.obsidian, 0, 2);
        world.setBlock(i + 13, j + 5, k + 10, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 1, j + 5, k + 11, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 2, j + 5, k + 11, Blocks.obsidian, 0, 2);
        world.setBlock(i + 3, j + 5, k + 11, Blocks.stained_glass, 10, 2);
        world.setBlock(i + 4, j + 5, k + 11, Blocks.stained_glass, 2, 2);
        world.setBlock(i + 5, j + 5, k + 11, Blocks.stained_glass, 2, 2);
        world.setBlock(i + 6, j + 5, k + 11, Blocks.obsidian, 0, 2);
        world.setBlock(i + 7, j + 5, k + 11, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j + 5, k + 11, Blocks.obsidian, 0, 2);
        world.setBlock(i + 9, j + 5, k + 11, Blocks.stained_glass, 2, 2);
        world.setBlock(i + 10, j + 5, k + 11, Blocks.stained_glass, 2, 2);
        world.setBlock(i + 11, j + 5, k + 11, Blocks.stained_glass, 10, 2);
        world.setBlock(i + 12, j + 5, k + 11, Blocks.obsidian, 0, 2);
        world.setBlock(i + 13, j + 5, k + 11, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 2, j + 5, k + 12, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 5, k + 12, Blocks.obsidian, 0, 2);
        world.setBlock(i + 4, j + 5, k + 12, Blocks.obsidian, 0, 2);
        world.setBlock(i + 5, j + 5, k + 12, Blocks.stained_glass, 10, 2);
        world.setBlock(i + 6, j + 5, k + 12, Blocks.obsidian, 0, 2);
        world.setBlock(i + 7, j + 5, k + 12, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j + 5, k + 12, Blocks.obsidian, 0, 2);
        world.setBlock(i + 9, j + 5, k + 12, Blocks.stained_glass, 10, 2);
        world.setBlock(i + 10, j + 5, k + 12, Blocks.obsidian, 0, 2);
        world.setBlock(i + 11, j + 5, k + 12, Blocks.obsidian, 0, 2);
        world.setBlock(i + 12, j + 5, k + 12, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 5, k + 13, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 4, j + 5, k + 13, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 5, j + 5, k + 13, Blocks.obsidian, 0, 2);
        world.setBlock(i + 6, j + 5, k + 13, Blocks.obsidian, 0, 2);
        world.setBlock(i + 7, j + 5, k + 13, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j + 5, k + 13, Blocks.obsidian, 0, 2);
        world.setBlock(i + 9, j + 5, k + 13, Blocks.obsidian, 0, 2);
        world.setBlock(i + 10, j + 5, k + 13, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 11, j + 5, k + 13, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 5, j + 5, k + 14, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 6, j + 5, k + 14, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 7, j + 5, k + 14, placePurpur(random), 0, 2);
        world.setBlock(i + 8, j + 5, k + 14, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 9, j + 5, k + 14, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 7, j + 6, k, placePurpur(random), 0, 2);
        world.setBlock(i + 7, j + 6, k + 1, placePurpurStairs(random), 3, 2);
        world.setBlock(i + 7, j + 6, k + 6, placePurpurStairs(random), 2, 2);
        world.setBlock(i, j + 6, k + 7, placePurpur(random), 0, 2);
        world.setBlock(i + 1, j + 6, k + 7, placePurpurStairs(random), 1, 2);
        world.setBlock(i + 7, j + 6, k + 7, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j + 6, k + 7, placePurpurStairs(random), 1, 2);
        world.setBlock(i + 13, j + 6, k + 7, placePurpurStairs(random), 0, 2);
        world.setBlock(i + 14, j + 6, k + 7, placePurpur(random), 0, 2);
        world.setBlock(i + 7, j + 6, k + 8, placePurpurStairs(random), 3, 2);
        world.setBlock(i + 7, j + 6, k + 13, placePurpurStairs(random), 2, 2);
        world.setBlock(i + 7, j + 6, k + 14, placePurpur(random), 0, 2);
        world.setBlock(i + 7, j + 7, k, placePurpur(random), 0, 2);
        world.setBlock(i, j + 7, k + 7, placePurpur(random), 0, 2);
        world.setBlock(i + 7, j + 7, k + 7, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 14, j + 7, k + 7, placePurpur(random), 0, 2);
        world.setBlock(i + 7, j + 7, k + 14, placePurpur(random), 0, 2);
        world.setBlock(i + 7, j + 8, k, placePurpur(random), 0, 2);
        world.setBlock(i, j + 8, k + 7, placePurpur(random), 0, 2);
        world.setBlock(i + 7, j + 8, k + 7, PlaceEndRod, 1, 2);
        world.setBlock(i + 14, j + 8, k + 7, placePurpur(random), 0, 2);
        world.setBlock(i + 7, j + 8, k + 14, placePurpur(random), 0, 2);
        world.setBlock(i + 7, j + 9, k, placePurpur(random), 0, 2);
        world.setBlock(i, j + 9, k + 7, placePurpur(random), 0, 2);
        world.setBlock(i + 14, j + 9, k + 7, placePurpur(random), 0, 2);
        world.setBlock(i + 7, j + 9, k + 14, placePurpur(random), 0, 2);
        world.setBlock(i + 7, j + 10, k, placePurpur(random), 0, 2);
        world.setBlock(i + 7, j + 10, k + 1, placePurpurStairs(random), 7, 2);
        world.setBlock(i + 7, j + 10, k + 2, PlaceEndRod,  0, 2);
        world.setBlock(i, j + 10, k + 7, placePurpur(random), 0, 2);
        world.setBlock(i + 1, j + 10, k + 7, placePurpurStairs(random), 5, 2);
        world.setBlock(i + 2, j + 10, k + 7, PlaceEndRod,  0, 2);
        world.setBlock(i + 12, j + 10, k + 7, PlaceEndRod,  0, 2);
        world.setBlock(i + 13, j + 10, k + 7, placePurpurStairs(random), 4, 2);
        world.setBlock(i + 14, j + 10, k + 7, placePurpur(random), 0, 2);
        world.setBlock(i + 7, j + 10, k + 12, PlaceEndRod,  0, 2);
        world.setBlock(i + 7, j + 10, k + 13, placePurpurStairs(random), 6, 2);
        world.setBlock(i + 7, j + 10, k + 14, placePurpur(random), 0, 2);
        world.setBlock(i + 7, j + 11, k, placePurpurStairs(random), 2, 2);
        world.setBlock(i + 7, j + 11, k + 1, placePurpur(random), 0, 2);
        world.setBlock(i + 7, j + 11, k + 2, placePurpur(random), 0, 2);
        world.setBlock(i + 7, j + 11, k + 3, PlacePurpurSlab, 8, 2);
        world.setBlock(i, j + 11, k + 7, placePurpurStairs(random), 0, 2);
        world.setBlock(i + 1, j + 11, k + 7, placePurpur(random), 0, 2);
        world.setBlock(i + 2, j + 11, k + 7, placePurpur(random), 0, 2);
        world.setBlock(i + 3, j + 11, k + 7, PlacePurpurSlab, 8, 2);
        world.setBlock(i + 11, j + 11, k + 7, PlacePurpurSlab, 8, 2);
        world.setBlock(i + 12, j + 11, k + 7, placePurpur(random), 0, 2);
        world.setBlock(i + 13, j + 11, k + 7, placePurpur(random), 0, 2);
        world.setBlock(i + 14, j + 11, k + 7, placePurpurStairs(random), 1, 2);
        world.setBlock(i + 7, j + 11, k + 11, PlacePurpurSlab, 8, 2);
        world.setBlock(i + 7, j + 11, k + 12, placePurpur(random), 0, 2);
        world.setBlock(i + 7, j + 11, k + 13, placePurpur(random), 0, 2);
        world.setBlock(i + 7, j + 11, k + 14, placePurpurStairs(random), 3, 2);

        if (random.nextBoolean()) {
            EntityFrontierGolem entity = new EntityFrontierGolem(world);
            entity.setPosition(i + 4, j + 6, k + 4);

            if (!world.isRemote) {
                world.spawnEntityInWorld(entity);
            }
        }

        if (random.nextBoolean()) {
            EntityFrontierGolem entity = new EntityFrontierGolem(world);
            entity.setPosition(i + 10, j + 6, k + 10);

            if (!world.isRemote) {
                world.spawnEntityInWorld(entity);
            }
        }

        this.setBlockAndNotifyAdequately(world, i + 6, j + 6, k + 7, Blocks.chest, 4);
        TileEntity tile6 = world.getTileEntity(i + 6, j + 6, k + 7);
        if (tile6 instanceof TileEntityChest) {
            TileEntityChest chest = (TileEntityChest) tile6;

            for (int slot = 0; slot < 3 + random.nextInt(20); slot++) {
                chest.setInventorySlotContents(random.nextInt(chest.getSizeInventory()), this.getEndLoot(random));
            }
        }

        return true;
    }

    private Block placeEndStoneBricks(Random random) {
        if (random.nextDouble() < 0.70) {
            return PlaceEndstoneBricks;
        } else {
            return Blocks.air;
        }
    }
    
    private Block placePurpur(Random random) {
        if (random.nextDouble() < 0.90) {
            return PlacePurpur;
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

}
