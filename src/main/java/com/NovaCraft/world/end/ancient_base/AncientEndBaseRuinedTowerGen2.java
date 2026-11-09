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

public class AncientEndBaseRuinedTowerGen2 extends WorldGenerator {

    public AncientEndBaseRuinedTowerGen2() {
    }

    private Block PlaceEndstoneBricks;
    private Block PlaceEndRod;

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
        PlaceEndstoneBricks = determineIfEndstoneBricksExists(world, i + 4, j + 42, k + 2);
        PlaceEndRod = determineIfEndRodExists(world, i + 11, j + 39, k + 5);
        
        world.setBlock(i + 13, j + 38, k + 11, Blocks.obsidian, 0, 2);
        world.setBlock(i + 6, j + 38, k + 12, Blocks.obsidian, 0, 2);
        world.setBlock(i + 7, j + 38, k + 12, Blocks.obsidian, 0, 2);
        world.setBlock(i + 8, j + 38, k + 12, placeFrontierslateBrickSlab(random), 0, 2);
        world.setBlock(i + 11, j + 38, k + 12, Blocks.obsidian, 0, 2);
        world.setBlock(i + 12, j + 38, k + 12, Blocks.obsidian, 0, 2);
        world.setBlock(i + 8, j + 38, k + 13, Blocks.obsidian, 0, 2);
        world.setBlock(i + 9, j + 38, k + 13, Blocks.obsidian, 0, 2);
        world.setBlock(i + 10, j + 38, k + 13, Blocks.obsidian, 0, 2);
        world.setBlock(i + 9, j + 39, k + 2, placeFrontierslateBrickStairs(random), 6, 2);
        world.setBlock(i + 8, j + 39, k + 3, Blocks.obsidian, 0, 2);
        world.setBlock(i + 9, j + 39, k + 3, Blocks.obsidian, 8, 2);
        world.setBlock(i + 10, j + 39, k + 3, Blocks.obsidian, 0, 2);
        world.setBlock(i + 6, j + 39, k + 4, Blocks.obsidian, 0, 2);
        world.setBlock(i + 7, j + 39, k + 4, Blocks.obsidian, 0, 2);
        world.setBlock(i + 11, j + 39, k + 4, Blocks.obsidian, 0, 2);
        world.setBlock(i + 12, j + 39, k + 4, Blocks.obsidian, 0, 2);
        world.setBlock(i + 5, j + 39, k + 5, Blocks.obsidian, 0, 2);
        world.setBlock(i + 11, j + 39, k + 5, PlaceEndRod, 3, 2);
        world.setBlock(i + 13, j + 39, k + 5, Blocks.obsidian, 0, 2);
        world.setBlock(i + 5, j + 39, k + 6, Blocks.obsidian, 0, 2);
        world.setBlock(i + 13, j + 39, k + 6, Blocks.obsidian, 0, 2);
        world.setBlock(i + 4, j + 39, k + 7, Blocks.obsidian, 0, 2);
        world.setBlock(i + 14, j + 39, k + 7, Blocks.obsidian, 0, 2);
        world.setBlock(i + 3, j + 39, k + 8, placeFrontierslateBrickStairs(random), 4, 2);
        world.setBlock(i + 4, j + 39, k + 8, Blocks.obsidian, 4, 2);
        world.setBlock(i + 14, j + 39, k + 8, Blocks.obsidian, 4, 2);
        world.setBlock(i + 15, j + 39, k + 8, placeFrontierslateBrickStairs(random), 5, 2);
        world.setBlock(i + 4, j + 39, k + 9, Blocks.obsidian, 0, 2);
        world.setBlock(i + 14, j + 39, k + 9, Blocks.obsidian, 0, 2);
        world.setBlock(i + 5, j + 39, k + 10, Blocks.obsidian, 0, 2);
        world.setBlock(i + 13, j + 39, k + 10, Blocks.obsidian, 0, 2);
        world.setBlock(i + 5, j + 39, k + 11, Blocks.obsidian, 0, 2);
        world.setBlock(i + 7, j + 39, k + 11, PlaceEndRod, 2, 2);
        world.setBlock(i + 13, j + 39, k + 11, Blocks.obsidian, 0, 2);
        world.setBlock(i + 6, j + 39, k + 12, Blocks.obsidian, 0, 2);
        world.setBlock(i + 7, j + 39, k + 12, Blocks.obsidian, 0, 2);
        world.setBlock(i + 11, j + 39, k + 12, Blocks.obsidian, 0, 2);
        world.setBlock(i + 12, j + 39, k + 12, Blocks.obsidian, 0, 2);
        world.setBlock(i + 8, j + 39, k + 13, Blocks.obsidian, 0, 2);
        world.setBlock(i + 9, j + 39, k + 13, Blocks.obsidian, 8, 2);
        world.setBlock(i + 10, j + 39, k + 13, Blocks.obsidian, 0, 2);
        world.setBlock(i + 9, j + 39, k + 14, placeFrontierslateBrickStairs(random), 7, 2);
        world.setBlock(i + 9, j + 40, k + 2, Blocks.obsidian, 8, 2);
        world.setBlock(i + 8, j + 40, k + 3, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 40, k + 3, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 40, k + 3, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 40, k + 4, Blocks.obsidian, 0, 2);
        world.setBlock(i + 7, j + 40, k + 4, Blocks.obsidian, 0, 2);
        world.setBlock(i + 11, j + 40, k + 4, Blocks.obsidian, 0, 2);
        world.setBlock(i + 12, j + 40, k + 4, Blocks.obsidian, 0, 2);
        world.setBlock(i + 5, j + 40, k + 5, Blocks.obsidian, 0, 2);
        world.setBlock(i + 13, j + 40, k + 5, Blocks.obsidian, 0, 2);
        world.setBlock(i + 5, j + 40, k + 6, Blocks.obsidian, 0, 2);
        world.setBlock(i + 12, j + 40, k + 6, PlaceEndRod, 4, 2);
        world.setBlock(i + 13, j + 40, k + 6, Blocks.obsidian, 0, 2);
        world.setBlock(i + 4, j + 40, k + 7, Blocks.obsidian, 0, 2);
        world.setBlock(i + 14, j + 40, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 40, k + 8, Blocks.obsidian, 0, 2);
        world.setBlock(i + 14, j + 40, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 15, j + 40, k + 8, Blocks.obsidian, 4, 2);
        world.setBlock(i + 4, j + 40, k + 9, Blocks.obsidian, 0, 2);
        world.setBlock(i + 14, j + 40, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 40, k + 10, Blocks.obsidian, 0, 2);
        world.setBlock(i + 6, j + 40, k + 10, PlaceEndRod, 5, 2);
        world.setBlock(i + 13, j + 40, k + 10, Blocks.obsidian, 0, 2);
        world.setBlock(i + 5, j + 40, k + 11, Blocks.obsidian, 0, 2);
        world.setBlock(i + 13, j + 40, k + 11, Blocks.obsidian, 0, 2);
        world.setBlock(i + 6, j + 40, k + 12, Blocks.obsidian, 0, 2);
        world.setBlock(i + 7, j + 40, k + 12, Blocks.obsidian, 0, 2);
        world.setBlock(i + 11, j + 40, k + 12, Blocks.obsidian, 0, 2);
        world.setBlock(i + 12, j + 40, k + 12, Blocks.obsidian, 0, 2);
        world.setBlock(i + 8, j + 40, k + 13, Blocks.obsidian, 0, 2);
        world.setBlock(i + 9, j + 40, k + 13, Blocks.obsidian, 0, 2);
        world.setBlock(i + 10, j + 40, k + 13, Blocks.obsidian, 0, 2);
        world.setBlock(i + 2, j + 41, k + 1, placeFrontierslateBrickStairs(random), 4, 2);
        world.setBlock(i + 3, j + 41, k + 1, placeFrontierslateBrickStairs(random), 6, 2);
        world.setBlock(i + 4, j + 41, k + 1, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 5, j + 41, k + 1, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 6, j + 41, k + 1, placeFrontierslateBrickStairs(random), 6, 2);
        world.setBlock(i + 7, j + 41, k + 1, placeFrontierslateBrickStairs(random), 6, 2);
        world.setBlock(i + 8, j + 41, k + 1, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 9, j + 41, k + 1, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 10, j + 41, k + 1, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 11, j + 41, k + 1, placeFrontierslateBrickStairs(random), 6, 2);
        world.setBlock(i + 12, j + 41, k + 1, placeFrontierslateBrickStairs(random), 6, 2);
        world.setBlock(i + 13, j + 41, k + 1, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 14, j + 41, k + 1, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 15, j + 41, k + 1, placeFrontierslateBrickStairs(random), 6, 2);
        world.setBlock(i + 16, j + 41, k + 1, placeFrontierslateBrickStairs(random), 6, 2);
        world.setBlock(i + 2, j + 41, k + 2, placeFrontierslateBrickStairs(random), 4, 2);
        world.setBlock(i + 3, j + 41, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 41, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 41, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 41, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 41, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 41, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 41, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 41, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 41, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 41, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 41, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 14, j + 41, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 15, j + 41, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 16, j + 41, k + 2, placeFrontierslateBrickStairs(random), 5, 2);
        world.setBlock(i + 2, j + 41, k + 3, placeFrontierslateBrickStairs(random), 0, 2);
        world.setBlock(i + 3, j + 41, k + 3, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 41, k + 3, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 41, k + 3, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 41, k + 3, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 41, k + 3, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 41, k + 3, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 41, k + 3, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 41, k + 3, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 41, k + 3, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 41, k + 3, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 41, k + 3, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 14, j + 41, k + 3, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 15, j + 41, k + 3, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 16, j + 41, k + 3, placeFrontierslateBrickStairs(random), 1, 2);
        world.setBlock(i + 2, j + 41, k + 4, placeFrontierslateBrickStairs(random), 0, 2);
        world.setBlock(i + 3, j + 41, k + 4, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 41, k + 4, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 41, k + 4, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 41, k + 4, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 41, k + 4, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 41, k + 4, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 41, k + 4, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 41, k + 4, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 41, k + 4, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 14, j + 41, k + 4, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 15, j + 41, k + 4, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 16, j + 41, k + 4, placeFrontierslateBrickStairs(random), 1, 2);
        world.setBlock(i + 2, j + 41, k + 5, placeFrontierslateBrickStairs(random), 4, 2);
        world.setBlock(i + 3, j + 41, k + 5, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 41, k + 5, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 41, k + 5, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 41, k + 5, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 41, k + 5, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 41, k + 5, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 41, k + 5, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 14, j + 41, k + 5, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 15, j + 41, k + 5, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 16, j + 41, k + 5, placeFrontierslateBrickStairs(random), 5, 2);
        world.setBlock(i + 2, j + 41, k + 6, placeFrontierslateBrickStairs(random), 4, 2);
        world.setBlock(i + 3, j + 41, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 41, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 41, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 41, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 41, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 41, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 41, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 14, j + 41, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 15, j + 41, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 16, j + 41, k + 6, placeFrontierslateBrickStairs(random), 5, 2);
        world.setBlock(i + 2, j + 41, k + 7, placeFrontierslateBrickStairs(random), 0, 2);
        world.setBlock(i + 3, j + 41, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 41, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 41, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 41, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 41, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 41, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 41, k + 7, placeFrontierslateBrickSlab(random), 0, 2);
        world.setBlock(i + 14, j + 41, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 15, j + 41, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 16, j + 41, k + 7, placeFrontierslateBrickStairs(random), 1, 2);
        world.setBlock(i + 2, j + 41, k + 8, placeFrontierslateBrickStairs(random), 0, 2);
        world.setBlock(i + 3, j + 41, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 41, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 14, j + 41, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 15, j + 41, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 16, j + 41, k + 8, placeFrontierslateBrickStairs(random), 1, 2);
        world.setBlock(i + 2, j + 41, k + 9, placeFrontierslateBrickStairs(random), 0, 2);
        world.setBlock(i + 3, j + 41, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 41, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 41, k + 9, placeFrontierslateBrickSlab(random), 0, 2);
        world.setBlock(i + 10, j + 41, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 41, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 41, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 41, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 14, j + 41, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 15, j + 41, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 16, j + 41, k + 9, placeFrontierslateBrickStairs(random), 1, 2);
        world.setBlock(i + 2, j + 41, k + 10, placeFrontierslateBrickStairs(random), 4, 2);
        world.setBlock(i + 3, j + 41, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 41, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 41, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 41, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 41, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 41, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 41, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 14, j + 41, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 15, j + 41, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 16, j + 41, k + 10, placeFrontierslateBrickStairs(random), 5, 2);
        world.setBlock(i + 2, j + 41, k + 11, placeFrontierslateBrickStairs(random), 4, 2);
        world.setBlock(i + 3, j + 41, k + 11, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 41, k + 11, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 41, k + 11, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 41, k + 11, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 41, k + 11, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 41, k + 11, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 41, k + 11, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 14, j + 41, k + 11, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 15, j + 41, k + 11, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 16, j + 41, k + 11, placeFrontierslateBrickStairs(random), 5, 2);
        world.setBlock(i + 2, j + 41, k + 12, placeFrontierslateBrickStairs(random), 0, 2);
        world.setBlock(i + 3, j + 41, k + 12, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 41, k + 12, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 41, k + 12, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 41, k + 12, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 41, k + 12, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 41, k + 12, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 41, k + 12, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 41, k + 12, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 41, k + 12, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 14, j + 41, k + 12, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 15, j + 41, k + 12, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 16, j + 41, k + 12, placeFrontierslateBrickStairs(random), 1, 2);
        world.setBlock(i + 2, j + 41, k + 13, placeFrontierslateBrickStairs(random), 0, 2);
        world.setBlock(i + 3, j + 41, k + 13, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 41, k + 13, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 41, k + 13, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 41, k + 13, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 41, k + 13, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 41, k + 13, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 41, k + 13, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 41, k + 13, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 41, k + 13, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 41, k + 13, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 41, k + 13, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 14, j + 41, k + 13, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 15, j + 41, k + 13, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 16, j + 41, k + 13, placeFrontierslateBrickStairs(random), 1, 2);
        world.setBlock(i + 2, j + 41, k + 14, placeFrontierslateBrickStairs(random), 4, 2);
        world.setBlock(i + 3, j + 41, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 41, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 41, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 41, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 41, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 41, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 41, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 41, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 41, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 41, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 41, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 14, j + 41, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 15, j + 41, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 16, j + 41, k + 14, placeFrontierslateBrickStairs(random), 5, 2);
        world.setBlock(i + 2, j + 41, k + 15, placeFrontierslateBrickStairs(random), 7, 2);
        world.setBlock(i + 3, j + 41, k + 15, placeFrontierslateBrickStairs(random), 7, 2);
        world.setBlock(i + 4, j + 41, k + 15, placeFrontierslateBrickStairs(random), 3, 2);
        world.setBlock(i + 5, j + 41, k + 15, placeFrontierslateBrickStairs(random), 3, 2);
        world.setBlock(i + 6, j + 41, k + 15, placeFrontierslateBrickStairs(random), 7, 2);
        world.setBlock(i + 7, j + 41, k + 15, placeFrontierslateBrickStairs(random), 7, 2);
        world.setBlock(i + 8, j + 41, k + 15, placeFrontierslateBrickStairs(random), 3, 2);
        world.setBlock(i + 9, j + 41, k + 15, placeFrontierslateBrickStairs(random), 3, 2);
        world.setBlock(i + 10, j + 41, k + 15, placeFrontierslateBrickStairs(random), 3, 2);
        world.setBlock(i + 11, j + 41, k + 15, placeFrontierslateBrickStairs(random), 7, 2);
        world.setBlock(i + 12, j + 41, k + 15, placeFrontierslateBrickStairs(random), 7, 2);
        world.setBlock(i + 13, j + 41, k + 15, placeFrontierslateBrickStairs(random), 3, 2);
        world.setBlock(i + 14, j + 41, k + 15, placeFrontierslateBrickStairs(random), 3, 2);
        world.setBlock(i + 15, j + 41, k + 15, placeFrontierslateBrickStairs(random), 7, 2);
        world.setBlock(i + 16, j + 41, k + 15, placeFrontierslateBrickStairs(random), 5, 2);
        world.setBlock(i + 2, j + 42, k + 1, PlaceEndRod, 1, 2);
        world.setBlock(i + 16, j + 42, k + 1, PlaceEndRod, 1, 2);
        world.setBlock(i + 3, j + 42, k + 2, Blocks.obsidian, 0, 2);
        world.setBlock(i + 4, j + 42, k + 2, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 5, j + 42, k + 2, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 6, j + 42, k + 2, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 7, j + 42, k + 2, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j + 42, k + 2, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 9, j + 42, k + 2, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 10, j + 42, k + 2, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 11, j + 42, k + 2, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 12, j + 42, k + 2, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 13, j + 42, k + 2, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 14, j + 42, k + 2, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 15, j + 42, k + 2, Blocks.obsidian, 0, 2);
        world.setBlock(i + 3, j + 42, k + 3, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 15, j + 42, k + 3, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 42, k + 4, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 15, j + 42, k + 4, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 42, k + 5, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 15, j + 42, k + 5, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 42, k + 6, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 15, j + 42, k + 6, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 42, k + 7, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j + 42, k + 7, Blocks.obsidian, 0, 2);
        world.setBlock(i + 14, j + 42, k + 7, placeFrontierslateBrickSlab(random), 0, 2);
        world.setBlock(i + 15, j + 42, k + 7, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 42, k + 8, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 14, j + 42, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 15, j + 42, k + 8, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 42, k + 9, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 10, j + 42, k + 9, Blocks.obsidian, 0, 2);
        world.setBlock(i + 14, j + 42, k + 9, placeFrontierslateBrickSlab(random), 8, 2);
        world.setBlock(i + 15, j + 42, k + 9, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 42, k + 10, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 15, j + 42, k + 10, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 42, k + 11, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 15, j + 42, k + 11, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 42, k + 12, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 15, j + 42, k + 12, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 42, k + 13, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 15, j + 42, k + 13, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 42, k + 14, Blocks.obsidian, 0, 2);
        world.setBlock(i + 4, j + 42, k + 14, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 5, j + 42, k + 14, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 6, j + 42, k + 14, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 7, j + 42, k + 14, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j + 42, k + 14, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 9, j + 42, k + 14, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 10, j + 42, k + 14, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 11, j + 42, k + 14, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 12, j + 42, k + 14, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 13, j + 42, k + 14, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 14, j + 42, k + 14, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 15, j + 42, k + 14, Blocks.obsidian, 0, 2);
        world.setBlock(i + 2, j + 42, k + 15, PlaceEndRod, 1, 2);
        world.setBlock(i + 16, j + 42, k + 15, PlaceEndRod, 1, 2);
        world.setBlock(i + 3, j + 43, k + 2, Blocks.obsidian, 0, 2);
        world.setBlock(i + 4, j + 43, k + 2, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 5, j + 43, k + 2, NovaCraftBlocks.vacuum_glass, 0, 2);
        world.setBlock(i + 6, j + 43, k + 2, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 7, j + 43, k + 2, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j + 43, k + 2, NovaCraftBlocks.vacuum_glass, 0, 2);
        world.setBlock(i + 9, j + 43, k + 2, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 10, j + 43, k + 2, NovaCraftBlocks.vacuum_glass, 0, 2);
        world.setBlock(i + 11, j + 43, k + 2, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 12, j + 43, k + 2, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 13, j + 43, k + 2, NovaCraftBlocks.vacuum_glass, 0, 2);
        world.setBlock(i + 14, j + 43, k + 2, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 15, j + 43, k + 2, Blocks.obsidian, 0, 2);
        world.setBlock(i + 3, j + 43, k + 3, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 15, j + 43, k + 3, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 43, k + 4, NovaCraftBlocks.vacuum_glass, 0, 2);
        world.setBlock(i + 15, j + 43, k + 4, NovaCraftBlocks.vacuum_glass, 0, 2);
        world.setBlock(i + 3, j + 43, k + 5, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 15, j + 43, k + 5, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 43, k + 6, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 15, j + 43, k + 6, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 43, k + 7, NovaCraftBlocks.vacuum_glass, 0, 2);
        world.setBlock(i + 8, j + 43, k + 7, Blocks.obsidian, 0, 2);
        world.setBlock(i + 15, j + 43, k + 7, NovaCraftBlocks.vacuum_glass, 0, 2);
        world.setBlock(i + 3, j + 43, k + 8, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 15, j + 43, k + 8, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 43, k + 9, NovaCraftBlocks.vacuum_glass, 0, 2);
        world.setBlock(i + 10, j + 43, k + 9, Blocks.obsidian, 0, 2);
        world.setBlock(i + 14, j + 43, k + 9, placeFrontierslateBrickSlab(random), 0, 2);
        world.setBlock(i + 15, j + 43, k + 9, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 43, k + 10, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 14, j + 43, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 15, j + 43, k + 10, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 43, k + 11, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 14, j + 43, k + 11, placeFrontierslateBrickSlab(random), 8, 2);
        world.setBlock(i + 15, j + 43, k + 11, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 43, k + 12, NovaCraftBlocks.vacuum_glass, 0, 2);
        world.setBlock(i + 15, j + 43, k + 12, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 43, k + 13, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 15, j + 43, k + 13, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 43, k + 14, Blocks.obsidian, 0, 2);
        world.setBlock(i + 4, j + 43, k + 14, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 5, j + 43, k + 14, NovaCraftBlocks.vacuum_glass, 0, 2);
        world.setBlock(i + 6, j + 43, k + 14, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 7, j + 43, k + 14, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j + 43, k + 14, NovaCraftBlocks.vacuum_glass, 0, 2);
        world.setBlock(i + 9, j + 43, k + 14, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 10, j + 43, k + 14, NovaCraftBlocks.vacuum_glass, 0, 2);
        world.setBlock(i + 11, j + 43, k + 14, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 12, j + 43, k + 14, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 13, j + 43, k + 14, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 14, j + 43, k + 14, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 15, j + 43, k + 14, Blocks.obsidian, 0, 2);
        world.setBlock(i + 3, j + 44, k + 2, Blocks.obsidian, 0, 2);
        world.setBlock(i + 4, j + 44, k + 2, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 5, j + 44, k + 2, NovaCraftBlocks.vacuum_glass, 0, 2);
        world.setBlock(i + 6, j + 44, k + 2, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 7, j + 44, k + 2, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j + 44, k + 2, NovaCraftBlocks.vacuum_glass, 0, 2);
        world.setBlock(i + 9, j + 44, k + 2, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 10, j + 44, k + 2, NovaCraftBlocks.vacuum_glass, 0, 2);
        world.setBlock(i + 11, j + 44, k + 2, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 12, j + 44, k + 2, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 13, j + 44, k + 2, NovaCraftBlocks.vacuum_glass, 0, 2);
        world.setBlock(i + 14, j + 44, k + 2, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 15, j + 44, k + 2, Blocks.obsidian, 0, 2);
        world.setBlock(i + 3, j + 44, k + 3, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 15, j + 44, k + 3, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 44, k + 4, NovaCraftBlocks.vacuum_glass, 0, 2);
        world.setBlock(i + 15, j + 44, k + 4, NovaCraftBlocks.vacuum_glass, 0, 2);
        world.setBlock(i + 3, j + 44, k + 5, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 15, j + 44, k + 5, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 44, k + 6, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 15, j + 44, k + 6, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 44, k + 7, NovaCraftBlocks.vacuum_glass, 0, 2);
        world.setBlock(i + 8, j + 44, k + 7, Blocks.obsidian, 0, 2);
        world.setBlock(i + 15, j + 44, k + 7, NovaCraftBlocks.vacuum_glass, 0, 2);
        world.setBlock(i + 3, j + 44, k + 8, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 15, j + 44, k + 8, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 44, k + 9, NovaCraftBlocks.vacuum_glass, 0, 2);
        world.setBlock(i + 10, j + 44, k + 9, Blocks.obsidian, 0, 2);
        world.setBlock(i + 15, j + 44, k + 9, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 44, k + 10, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 15, j + 44, k + 10, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 44, k + 11, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 14, j + 44, k + 11, placeFrontierslateBrickSlab(random), 0, 2);
        world.setBlock(i + 15, j + 44, k + 11, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 44, k + 12, NovaCraftBlocks.vacuum_glass, 0, 2);
        world.setBlock(i + 14, j + 44, k + 12, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 15, j + 44, k + 12, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 44, k + 13, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 14, j + 44, k + 13, placeFrontierslateBrickSlab(random), 8, 2);
        world.setBlock(i + 15, j + 44, k + 13, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 44, k + 14, Blocks.obsidian, 0, 2);
        world.setBlock(i + 4, j + 44, k + 14, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 5, j + 44, k + 14, NovaCraftBlocks.vacuum_glass, 0, 2);
        world.setBlock(i + 6, j + 44, k + 14, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 7, j + 44, k + 14, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j + 44, k + 14, NovaCraftBlocks.vacuum_glass, 0, 2);
        world.setBlock(i + 9, j + 44, k + 14, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 10, j + 44, k + 14, NovaCraftBlocks.vacuum_glass, 0, 2);
        world.setBlock(i + 11, j + 44, k + 14, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 12, j + 44, k + 14, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 13, j + 44, k + 14, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 14, j + 44, k + 14, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 15, j + 44, k + 14, Blocks.obsidian, 0, 2);
        world.setBlock(i + 1, j + 45, k, placeFrontierslateBrickStairs(random), 4, 2);
        world.setBlock(i + 2, j + 45, k, placeFrontierslateBrickStairs(random), 6, 2);
        world.setBlock(i + 3, j + 45, k, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 4, j + 45, k, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 5, j + 45, k, placeFrontierslateBrickStairs(random), 6, 2);
        world.setBlock(i + 6, j + 45, k, placeFrontierslateBrickStairs(random), 6, 2);
        world.setBlock(i + 7, j + 45, k, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 8, j + 45, k, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 9, j + 45, k, placeFrontierslateBrickStairs(random), 6, 2);
        world.setBlock(i + 10, j + 45, k, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 11, j + 45, k, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 12, j + 45, k, placeFrontierslateBrickStairs(random), 6, 2);
        world.setBlock(i + 13, j + 45, k, placeFrontierslateBrickStairs(random), 6, 2);
        world.setBlock(i + 14, j + 45, k, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 15, j + 45, k, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 16, j + 45, k, placeFrontierslateBrickStairs(random), 6, 2);
        world.setBlock(i + 17, j + 45, k, placeFrontierslateBrickStairs(random), 6, 2);
        world.setBlock(i + 1, j + 45, k + 1, placeFrontierslateBrickStairs(random), 4, 2);
        world.setBlock(i + 2, j + 45, k + 1, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 3, j + 45, k + 1, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 45, k + 1, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 45, k + 1, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 45, k + 1, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 45, k + 1, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 45, k + 1, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 45, k + 1, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 45, k + 1, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 45, k + 1, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 45, k + 1, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 45, k + 1, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 14, j + 45, k + 1, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 15, j + 45, k + 1, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 16, j + 45, k + 1, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 17, j + 45, k + 1, placeFrontierslateBrickStairs(random), 5, 2);
        world.setBlock(i + 1, j + 45, k + 2, placeFrontierslateBrickStairs(random), 0, 2);
        world.setBlock(i + 2, j + 45, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 3, j + 45, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 45, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 45, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 45, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 45, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 45, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 45, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 45, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 45, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 45, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 45, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 14, j + 45, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 15, j + 45, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 16, j + 45, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 17, j + 45, k + 2, placeFrontierslateBrickStairs(random), 1, 2);
        world.setBlock(i + 1, j + 45, k + 3, placeFrontierslateBrickStairs(random), 0, 2);
        world.setBlock(i + 2, j + 45, k + 3, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 3, j + 45, k + 3, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 45, k + 3, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 45, k + 3, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 45, k + 3, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 45, k + 3, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 45, k + 3, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 45, k + 3, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 45, k + 3, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 45, k + 3, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 45, k + 3, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 45, k + 3, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 14, j + 45, k + 3, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 15, j + 45, k + 3, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 16, j + 45, k + 3, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 17, j + 45, k + 3, placeFrontierslateBrickStairs(random), 1, 2);
        world.setBlock(i + 1, j + 45, k + 4, placeFrontierslateBrickStairs(random), 4, 2);
        world.setBlock(i + 2, j + 45, k + 4, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 3, j + 45, k + 4, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 45, k + 4, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 45, k + 4, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 45, k + 4, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 45, k + 4, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 45, k + 4, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 45, k + 4, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 45, k + 4, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 45, k + 4, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 45, k + 4, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 45, k + 4, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 14, j + 45, k + 4, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 15, j + 45, k + 4, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 16, j + 45, k + 4, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 17, j + 45, k + 4, placeFrontierslateBrickStairs(random), 5, 2);
        world.setBlock(i + 1, j + 45, k + 5, placeFrontierslateBrickStairs(random), 4, 2);
        world.setBlock(i + 2, j + 45, k + 5, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 3, j + 45, k + 5, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 45, k + 5, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 45, k + 5, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 45, k + 5, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 45, k + 5, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 45, k + 5, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 45, k + 5, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 45, k + 5, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 45, k + 5, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 45, k + 5, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 45, k + 5, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 14, j + 45, k + 5, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 15, j + 45, k + 5, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 16, j + 45, k + 5, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 17, j + 45, k + 5, placeFrontierslateBrickStairs(random), 5, 2);
        world.setBlock(i + 1, j + 45, k + 6, placeFrontierslateBrickStairs(random), 0, 2);
        world.setBlock(i + 2, j + 45, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 3, j + 45, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 45, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 45, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 45, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 45, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 45, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 45, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 45, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 45, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 45, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 45, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 14, j + 45, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 15, j + 45, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 16, j + 45, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 17, j + 45, k + 6, placeFrontierslateBrickStairs(random), 1, 2);
        world.setBlock(i + 1, j + 45, k + 7, placeFrontierslateBrickStairs(random), 0, 2);
        world.setBlock(i + 2, j + 45, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 3, j + 45, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 45, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 45, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 45, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 45, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 45, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 45, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 45, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 45, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 45, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 45, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 14, j + 45, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 15, j + 45, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 16, j + 45, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 17, j + 45, k + 7, placeFrontierslateBrickStairs(random), 1, 2);
        world.setBlock(i + 1, j + 45, k + 8, placeFrontierslateBrickStairs(random), 4, 2);
        world.setBlock(i + 2, j + 45, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 3, j + 45, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 45, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 45, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 45, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 45, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 45, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 45, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 45, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 45, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 45, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 45, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 15, j + 45, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 16, j + 45, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 17, j + 45, k + 8, placeFrontierslateBrickStairs(random), 5, 2);
        world.setBlock(i + 1, j + 45, k + 9, placeFrontierslateBrickStairs(random), 0, 2);
        world.setBlock(i + 2, j + 45, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 3, j + 45, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 45, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 45, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 45, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 45, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 45, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 45, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 45, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 45, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 45, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 45, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 15, j + 45, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 16, j + 45, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 17, j + 45, k + 9, placeFrontierslateBrickStairs(random), 1, 2);
        world.setBlock(i + 1, j + 45, k + 10, placeFrontierslateBrickStairs(random), 0, 2);
        world.setBlock(i + 2, j + 45, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 3, j + 45, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 45, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 45, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 45, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 45, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 45, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 45, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 45, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 45, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 45, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 45, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 15, j + 45, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 16, j + 45, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 17, j + 45, k + 10, placeFrontierslateBrickStairs(random), 1, 2);
        world.setBlock(i + 1, j + 45, k + 11, placeFrontierslateBrickStairs(random), 4, 2);
        world.setBlock(i + 2, j + 45, k + 11, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 3, j + 45, k + 11, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 45, k + 11, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 45, k + 11, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 45, k + 11, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 45, k + 11, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 45, k + 11, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 45, k + 11, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 45, k + 11, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 45, k + 11, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 45, k + 11, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 45, k + 11, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 15, j + 45, k + 11, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 16, j + 45, k + 11, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 17, j + 45, k + 11, placeFrontierslateBrickStairs(random), 5, 2);
        world.setBlock(i + 1, j + 45, k + 12, placeFrontierslateBrickStairs(random), 4, 2);
        world.setBlock(i + 2, j + 45, k + 12, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 3, j + 45, k + 12, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 45, k + 12, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 45, k + 12, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 45, k + 12, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 45, k + 12, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 45, k + 12, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 45, k + 12, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 45, k + 12, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 45, k + 12, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 45, k + 12, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 45, k + 12, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 15, j + 45, k + 12, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 16, j + 45, k + 12, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 17, j + 45, k + 12, placeFrontierslateBrickStairs(random), 5, 2);
        world.setBlock(i + 1, j + 45, k + 13, placeFrontierslateBrickStairs(random), 0, 2);
        world.setBlock(i + 2, j + 45, k + 13, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 3, j + 45, k + 13, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 45, k + 13, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 45, k + 13, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 45, k + 13, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 45, k + 13, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 45, k + 13, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 45, k + 13, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 45, k + 13, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 45, k + 13, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 45, k + 13, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 45, k + 13, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 14, j + 45, k + 13, placeFrontierslateBrickSlab(random), 0, 2);
        world.setBlock(i + 15, j + 45, k + 13, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 16, j + 45, k + 13, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 17, j + 45, k + 13, placeFrontierslateBrickStairs(random), 1, 2);
        world.setBlock(i + 1, j + 45, k + 14, placeFrontierslateBrickStairs(random), 0, 2);
        world.setBlock(i + 2, j + 45, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 3, j + 45, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 45, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 45, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 45, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 45, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 45, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 45, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 45, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 45, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 45, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 45, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 14, j + 45, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 15, j + 45, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 16, j + 45, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 17, j + 45, k + 14, placeFrontierslateBrickStairs(random), 1, 2);
        world.setBlock(i + 1, j + 45, k + 15, placeFrontierslateBrickStairs(random), 4, 2);
        world.setBlock(i + 2, j + 45, k + 15, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 3, j + 45, k + 15, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 45, k + 15, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 45, k + 15, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 45, k + 15, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 45, k + 15, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 45, k + 15, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 45, k + 15, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 45, k + 15, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 45, k + 15, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 45, k + 15, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 45, k + 15, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 14, j + 45, k + 15, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 15, j + 45, k + 15, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 16, j + 45, k + 15, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 17, j + 45, k + 15, placeFrontierslateBrickStairs(random), 5, 2);
        world.setBlock(i + 1, j + 45, k + 16, placeFrontierslateBrickStairs(random), 7, 2);
        world.setBlock(i + 2, j + 45, k + 16, placeFrontierslateBrickStairs(random), 7, 2);
        world.setBlock(i + 3, j + 45, k + 16, placeFrontierslateBrickStairs(random), 3, 2);
        world.setBlock(i + 4, j + 45, k + 16, placeFrontierslateBrickStairs(random), 3, 2);
        world.setBlock(i + 5, j + 45, k + 16, placeFrontierslateBrickStairs(random), 7, 2);
        world.setBlock(i + 6, j + 45, k + 16, placeFrontierslateBrickStairs(random), 7, 2);
        world.setBlock(i + 7, j + 45, k + 16, placeFrontierslateBrickStairs(random), 3, 2);
        world.setBlock(i + 8, j + 45, k + 16, placeFrontierslateBrickStairs(random), 3, 2);
        world.setBlock(i + 9, j + 45, k + 16, placeFrontierslateBrickStairs(random), 7, 2);
        world.setBlock(i + 10, j + 45, k + 16, placeFrontierslateBrickStairs(random), 3, 2);
        world.setBlock(i + 11, j + 45, k + 16, placeFrontierslateBrickStairs(random), 3, 2);
        world.setBlock(i + 12, j + 45, k + 16, placeFrontierslateBrickStairs(random), 7, 2);
        world.setBlock(i + 13, j + 45, k + 16, placeFrontierslateBrickStairs(random), 7, 2);
        world.setBlock(i + 14, j + 45, k + 16, placeFrontierslateBrickStairs(random), 3, 2);
        world.setBlock(i + 15, j + 45, k + 16, placeFrontierslateBrickStairs(random), 3, 2);
        world.setBlock(i + 16, j + 45, k + 16, placeFrontierslateBrickStairs(random), 7, 2);
        world.setBlock(i + 17, j + 45, k + 16, placeFrontierslateBrickStairs(random), 5, 2);
        world.setBlock(i + 13, j + 46, k + 7, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 14, j + 46, k + 7, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 15, j + 46, k + 7, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 13, j + 46, k + 8, placeFrontierslateBrickStairs(random), 0, 2);
        world.setBlock(i + 15, j + 46, k + 8, placeFrontierslateBrickStairs(random), 1, 2);
        world.setBlock(i + 13, j + 46, k + 9, placeFrontierslateBrickStairs(random), 0, 2);
        world.setBlock(i + 15, j + 46, k + 9, placeFrontierslateBrickStairs(random), 1, 2);
        world.setBlock(i + 13, j + 46, k + 10, placeFrontierslateBrickStairs(random), 0, 2);
        world.setBlock(i + 15, j + 46, k + 10, placeFrontierslateBrickStairs(random), 1, 2);
        world.setBlock(i + 13, j + 46, k + 11, placeFrontierslateBrickStairs(random), 0, 2);
        world.setBlock(i + 15, j + 46, k + 11, placeFrontierslateBrickStairs(random), 1, 2);

        EntityFrontierGolem entity = new EntityFrontierGolem(world);
        entity.setPosition(i + 5, j + 39, k + 8);

        if (!world.isRemote) {
            world.spawnEntityInWorld(entity);
        }

        EntityFrontierGolem entity2 = new EntityFrontierGolem(world);
        entity2.setPosition(i + 13, j + 39, k + 8);

        if (!world.isRemote) {
            world.spawnEntityInWorld(entity2);
        }

        EntityFrontierGolem entity3 = new EntityFrontierGolem(world);
        entity3.setPosition(i + 12, j + 42, k + 12);

        if (!world.isRemote) {
            world.spawnEntityInWorld(entity3);
        }

        EntityFrontierGolem entity4 = new EntityFrontierGolem(world);
        entity4.setPosition(i + 17, j + 39, k + 8);

        if (!world.isRemote) {
            world.spawnEntityInWorld(entity4);
        }

        EntityFrontierGolem entity5 = new EntityFrontierGolem(world);
        entity5.setPosition(i - 17, j + 39, k + 8);

        if (!world.isRemote) {
            world.spawnEntityInWorld(entity5);
        }

        EntityFrontierGolem entity6 = new EntityFrontierGolem(world);
        entity6.setPosition(i + 5, j + 22, k + 16);

        if (!world.isRemote) {
            world.spawnEntityInWorld(entity6);
        }

        EntityFrontierGolem entity7 = new EntityFrontierGolem(world);
        entity7.setPosition(i - 5, j + 22, k + 16);

        if (!world.isRemote) {
            world.spawnEntityInWorld(entity7);
        }

        EntityFrontierGolem entity8 = new EntityFrontierGolem(world);
        entity8.setPosition(i + 5, j + 50, k + 8);

        if (!world.isRemote) {
            world.spawnEntityInWorld(entity8);
        }

        EntityFrontierGolem entity9 = new EntityFrontierGolem(world);
        entity9.setPosition(i - 5, j + 50, k + 16);

        if (!world.isRemote) {
            world.spawnEntityInWorld(entity9);
        }
        
        this.setBlockAndNotifyAdequately(world, i + 6, j + 42, k + 3, Blocks.chest, 3);
        TileEntity tile = world.getTileEntity(i + 6, j + 42, k + 3);
        if (tile instanceof TileEntityChest) {
            TileEntityChest chest2 = (TileEntityChest) tile;

            for (int slot = 0; slot < 3 + random.nextInt(20); slot++) {
                chest2.setInventorySlotContents(random.nextInt(chest2.getSizeInventory()), this.getEquipmentLoot(random));
            }
        }
        
        this.setBlockAndNotifyAdequately(world, i + 4, j + 42, k + 5, Blocks.chest, 5);
        TileEntity tile2 = world.getTileEntity(i + 4, j + 42, k + 5);
        if (tile2 instanceof TileEntityChest) {
            TileEntityChest chest2 = (TileEntityChest) tile2;

            for (int slot = 0; slot < 3 + random.nextInt(20); slot++) {
                chest2.setInventorySlotContents(random.nextInt(chest2.getSizeInventory()), this.getEquipmentLoot(random));
            }
        }

        return true;
    }

    private Block placeFrontierslateBricks(Random random) {
        if (random.nextDouble() < 0.90) {
            return NovaCraftBlocks.frontierslate_bricks;
        } else {
            return Blocks.air;
        }
    }

    private Block placeFrontierslateBrickStairs(Random random) {
        if (random.nextDouble() < 0.95) {
            return NovaCraftBlocks.frontierslate_brick_stairs;
        } else {
            return Blocks.air;
        }
    }

    private Block placeFrontierslateBrickSlab(Random random) {
        if (random.nextDouble() < 0.95) {
            return NovaCraftBlocks.frontierslate_brick_slab;
        } else {
            return Blocks.air;
        }
    }

    private Block placeEndStoneBricks(Random random) {
        if (random.nextDouble() < 0.75) {
            return PlaceEndstoneBricks;
        } else {
            return Blocks.air;
        }
    }

    private ItemStack getEquipmentLoot(Random random) {
        int item = random.nextInt(18);
        switch (item) {
            case 0:
                return new ItemStack(NovaCraftItems.vanite_ingot, random.nextInt(15) + 8);
            case 1:
                return new ItemStack(NovaCraftItems.static_essence, random.nextInt(4) + 6);
            case 2:
                return new ItemStack(NovaCraftItems.crystallized_end_shard, random.nextInt(2) + 1);
            case 3:
                Enchantment enchantment = Enchantment.enchantmentsBookList[random.nextInt(Enchantment.enchantmentsBookList.length)];
                int maxLevel = enchantment.getMaxLevel();
                ItemStack itemStack = Items.enchanted_book.getEnchantedItemStack(new EnchantmentData(enchantment, maxLevel));

                return itemStack;
            case 4:
                Enchantment enchantment2 = Enchantment.enchantmentsBookList[random.nextInt(Enchantment.enchantmentsBookList.length)];
                int maxLevel2 = enchantment2.getMaxLevel();
                ItemStack itemStack2 = Items.enchanted_book.getEnchantedItemStack(new EnchantmentData(enchantment2, maxLevel2));

                return itemStack2;

            case 5:
                //Pick enchants
                Enchantment[] pickEnchantments = {Enchantment.efficiency, Enchantment.unbreaking};
                Enchantment[] pickEnchantments2 = {Enchantment.silkTouch};
                Enchantment enchantment3 = pickEnchantments[random.nextInt(pickEnchantments.length)];
                Enchantment enchantment33 = pickEnchantments2[random.nextInt(pickEnchantments2.length)];
                int maxLevel3 = enchantment3.getMaxLevel() - 1;
                int maxLevel33 = enchantment33.getMaxLevel();
                ItemStack itemStack3 = new ItemStack(Items.diamond_pickaxe);

                itemStack3.addEnchantment(enchantment3, maxLevel3);
                itemStack3.addEnchantment(enchantment33, maxLevel33);

                return itemStack3;
            case 6:
                //shovel enchants
                Enchantment[] pickEnchantments3 = {Enchantment.efficiency, Enchantment.unbreaking};
                Enchantment[] pickEnchantments4 = {Enchantment.silkTouch};
                Enchantment enchantment4 = pickEnchantments3[random.nextInt(pickEnchantments3.length)];
                Enchantment enchantment44 = pickEnchantments4[random.nextInt(pickEnchantments4.length)];
                int maxLevel4 = enchantment4.getMaxLevel() - 1;
                int maxLevel44 = enchantment44.getMaxLevel();
                ItemStack itemStack4 = new ItemStack(Items.diamond_shovel);

                itemStack4.addEnchantment(enchantment4, maxLevel4);
                itemStack4.addEnchantment(enchantment44, maxLevel44);

                return itemStack4;
            case 7:
                //Pick enchants
                Enchantment[] pickEnchantments5 = {Enchantment.efficiency, Enchantment.unbreaking};
                Enchantment[] pickEnchantments6 = {Enchantment.silkTouch, Enchantment.fortune};
                Enchantment enchantment5 = pickEnchantments5[random.nextInt(pickEnchantments5.length)];
                Enchantment enchantment55 = pickEnchantments6[random.nextInt(pickEnchantments6.length)];
                int maxLevel5 = enchantment5.getMaxLevel() - 1;
                int maxLevel55 = enchantment55.getMaxLevel();
                ItemStack itemStack5 = new ItemStack(NovaCraftItems.tophinite_pickaxe);

                itemStack5.addEnchantment(enchantment5, maxLevel5);
                itemStack5.addEnchantment(enchantment55, maxLevel55);

                return itemStack5;
            case 8:
                //Helmet enchants
                Enchantment[] helmetEnchantments = {Enchantment.protection, Enchantment.projectileProtection, Enchantment.unbreaking, Enchantment.respiration};
                Enchantment[] helmetEnchantments2 = {Enchantment.aquaAffinity, Enchantment.fireProtection, Enchantment.blastProtection};
                Enchantment enchantment31 = helmetEnchantments[random.nextInt(helmetEnchantments.length)];
                Enchantment enchantment331 = helmetEnchantments2[random.nextInt(helmetEnchantments2.length)];
                int maxLevel31 = enchantment31.getMaxLevel();
                int maxLevel331 = enchantment331.getMaxLevel();
                ItemStack itemStack31 = new ItemStack(Items.diamond_helmet);

                itemStack31.addEnchantment(enchantment31, maxLevel31);
                itemStack31.addEnchantment(enchantment331, maxLevel331);

                return itemStack31;
            case 9:
                //Chestplate enchants
                Enchantment[] chestplateEnchantments = {Enchantment.protection, Enchantment.blastProtection};
                Enchantment[] chestplateEnchantments2 = {Enchantment.unbreaking, Enchantment.fireProtection, Enchantment.projectileProtection};

                //Selects a random enchantment
                Enchantment enchantment41 = chestplateEnchantments[random.nextInt(chestplateEnchantments.length)];
                int maxLevel41 = enchantment41.getMaxLevel();

                Enchantment enchantment441 = chestplateEnchantments2[random.nextInt(chestplateEnchantments2.length)];
                int maxLevel441 = enchantment441.getMaxLevel();

                //Creates an ItemStack for diamond chestplate
                ItemStack itemStack41 = new ItemStack(Items.diamond_chestplate);

                //Adds the enchantment
                itemStack41.addEnchantment(enchantment41, maxLevel41);
                itemStack41.addEnchantment(enchantment441, maxLevel441);

                return itemStack41;
            case 10:
                //Legging enchants
                Enchantment[] leggingsEnchantments = {Enchantment.protection, Enchantment.fireProtection};
                Enchantment[] leggingsEnchantments2 = {Enchantment.unbreaking, Enchantment.blastProtection, Enchantment.projectileProtection};
                Enchantment enchantment51 = leggingsEnchantments[random.nextInt(leggingsEnchantments.length)];
                Enchantment enchantment551 = leggingsEnchantments2[random.nextInt(leggingsEnchantments2.length)];
                int maxLevel51 = enchantment51.getMaxLevel();
                int maxLevel551 = enchantment551.getMaxLevel();
                ItemStack itemStack51 = new ItemStack(Items.diamond_leggings);

                itemStack51.addEnchantment(enchantment51, maxLevel51);
                itemStack51.addEnchantment(enchantment551, maxLevel551);

                return itemStack51;
            case 11:
                //Boot enchants
                Enchantment[] bootEnchantments = {Enchantment.protection, Enchantment.unbreaking};
                Enchantment[] bootEnchantments2 = {Enchantment.projectileProtection, Enchantment.featherFalling, Enchantment.blastProtection, Enchantment.fireProtection};
                Enchantment enchantment6 = bootEnchantments[random.nextInt(bootEnchantments.length)];
                Enchantment enchantment66 = bootEnchantments2[random.nextInt(bootEnchantments2.length)];
                int maxLevel6 = enchantment6.getMaxLevel();
                int maxLevel66 = enchantment66.getMaxLevel();
                ItemStack itemStack6 = new ItemStack(Items.diamond_boots);

                itemStack6.addEnchantment(enchantment6, maxLevel6);
                itemStack6.addEnchantment(enchantment66, maxLevel66);

                return itemStack6;
            case 12:
                //Chestplate enchants
                Enchantment[] chestplateEnchantments1 = {Enchantment.protection, Enchantment.blastProtection};
                Enchantment[] chestplateEnchantments21 = {Enchantment.unbreaking, Enchantment.fireProtection, Enchantment.projectileProtection};

                //Selects a random enchantment
                Enchantment enchantment411 = chestplateEnchantments1[random.nextInt(chestplateEnchantments1.length)];
                int maxLevel411 = enchantment411.getMaxLevel() - 1;

                Enchantment enchantment4411 = chestplateEnchantments21[random.nextInt(chestplateEnchantments21.length)];
                int maxLevel4411 = enchantment4411.getMaxLevel() - 1;

                //Creates an ItemStack for diamond chestplate
                ItemStack itemStack411 = new ItemStack(NovaCraftItems.iridium_chestplate);

                //Adds the enchantment
                itemStack411.addEnchantment(enchantment411, maxLevel411);
                itemStack411.addEnchantment(enchantment4411, maxLevel4411);

                return itemStack411;
            case 13:
                return new ItemStack(NovaCraftItems.iridium_nugget, random.nextInt(2) + 1, 2);
            case 14:
                //Sword enchants
                Enchantment[] pickEnchantments1 = {Enchantment.looting, Enchantment.unbreaking};
                Enchantment[] pickEnchantments21 = {Enchantment.sharpness, Enchantment.smite, Enchantment.fireAspect};
                Enchantment enchantment311 = pickEnchantments1[random.nextInt(pickEnchantments1.length)];
                Enchantment enchantment3311 = pickEnchantments21[random.nextInt(pickEnchantments21.length)];
                int maxLevel311 = enchantment311.getMaxLevel();
                int maxLevel3311 = enchantment3311.getMaxLevel();
                ItemStack itemStack311 = new ItemStack(NovaCraftItems.tophinite_sword);

                itemStack311.addEnchantment(enchantment311, maxLevel311);
                itemStack311.addEnchantment(enchantment3311, maxLevel3311);

                return itemStack311;
            default: {
                return new ItemStack(NovaCraftItems.diamond_nugget, random.nextInt(4) + 6, 2);
            }
        }
    }
}
