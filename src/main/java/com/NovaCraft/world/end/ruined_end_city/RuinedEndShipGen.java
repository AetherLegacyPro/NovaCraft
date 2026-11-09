package com.NovaCraft.world.end.ruined_end_city;

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

public class RuinedEndShipGen extends WorldGenerator {

    public RuinedEndShipGen() {
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
                    System.out.println("Missing Endstone Bricks from Et Futurum Requiem, using Etherstone Bricks instead...");
                }
                return NovaCraftBlocks.etherstone_bricks;
            }
        }

        return NovaCraftBlocks.etherstone_bricks;
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
        PlaceEndstoneBricks = determineIfEndstoneBricksExists(world, i + 3, j + 6, k + 2);
        PlaceEndRod = determineIfEndRodExists(world, i + 1, j + 6, k + 1);
        
        world.setBlock(i + 5, j, k + 6, placeFontierslatePillar(random), 4, 2);
        world.setBlock(i + 6, j, k + 6, placeFontierslatePillar(random), 4, 2);
        world.setBlock(i + 7, j, k + 6, placeFontierslatePillar(random), 4, 2);
        world.setBlock(i + 8, j, k + 6, placeFontierslatePillar(random), 4, 2);
        world.setBlock(i + 9, j, k + 6, placeFontierslatePillar(random), 4, 2);
        world.setBlock(i + 10, j, k + 6, placeFontierslatePillar(random), 4, 2);
        world.setBlock(i + 11, j, k + 6, placeFontierslatePillar(random), 4, 2);
        world.setBlock(i + 12, j, k + 6, placeFontierslatePillar(random), 4, 2);
        world.setBlock(i + 13, j, k + 6, placeFontierslatePillar(random), 4, 2);
        world.setBlock(i + 14, j, k + 6, placeFontierslatePillar(random), 4, 2);
        world.setBlock(i + 15, j, k + 6, placeFontierslatePillar(random), 4, 2);
        world.setBlock(i + 16, j, k + 6, placeFontierslatePillar(random), 4, 2);
        world.setBlock(i + 17, j, k + 6, placeFontierslatePillar(random), 4, 2);
        world.setBlock(i + 7, j + 1, k + 4, placeFrontierslateBrickStairs(random), 6, 2);
        world.setBlock(i + 11, j + 1, k + 4, placeFrontierslateBrickStairs(random), 6, 2);
        world.setBlock(i + 15, j + 1, k + 4, placeFrontierslateBrickStairs(random), 6, 2);
        world.setBlock(i + 4, j + 1, k + 5, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 1, k + 5, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 1, k + 5, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 1, k + 5, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 1, k + 5, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 1, k + 5, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 1, k + 5, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 1, k + 5, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 1, k + 5, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 1, k + 5, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 14, j + 1, k + 5, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 15, j + 1, k + 5, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 16, j + 1, k + 5, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 1, k + 6, placeFontierslatePillar(random), 4, 2);
        world.setBlock(i + 5, j + 1, k + 6, placeFontierslatePillar(random), 4, 2);
        world.setBlock(i + 6, j + 1, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 1, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 1, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 1, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 1, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 1, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 1, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 1, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 14, j + 1, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 15, j + 1, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 16, j + 1, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 17, j + 1, k + 6, placeFontierslatePillar(random), 4, 2);
        world.setBlock(i + 18, j + 1, k + 6, placeFontierslatePillar(random), 4, 2);
        world.setBlock(i + 19, j + 1, k + 6, placeFontierslatePillar(random), 4, 2);
        world.setBlock(i + 20, j + 1, k + 6, placeFontierslatePillar(random), 4, 2);
        world.setBlock(i + 4, j + 1, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 1, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 1, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 1, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 1, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 1, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 1, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 1, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 1, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 1, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 14, j + 1, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 15, j + 1, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 16, j + 1, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 1, k + 8, placeFrontierslateBrickStairs(random), 7, 2);
        world.setBlock(i + 11, j + 1, k + 8, placeFrontierslateBrickStairs(random), 7, 2);
        world.setBlock(i + 15, j + 1, k + 8, placeFrontierslateBrickStairs(random), 7, 2);
        world.setBlock(i + 7, j + 2, k + 3, placeFrontierslateBrickStairs(random), 6, 2);
        world.setBlock(i + 11, j + 2, k + 3, placeFrontierslateBrickStairs(random), 6, 2);
        world.setBlock(i + 15, j + 2, k + 3, placeFrontierslateBrickStairs(random), 6, 2);
        world.setBlock(i + 7, j + 2, k + 4, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 2, k + 4, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 2, k + 4, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 2, k + 4, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 2, k + 4, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 2, k + 4, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 2, k + 4, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 14, j + 2, k + 4, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 15, j + 2, k + 4, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 16, j + 2, k + 4, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 17, j + 2, k + 4, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 2, k + 5, Blocks.obsidian, 0, 2);
        world.setBlock(i + 5, j + 2, k + 5, Blocks.obsidian, 0, 2);
        world.setBlock(i + 6, j + 2, k + 5, Blocks.obsidian, 0, 2);
        world.setBlock(i + 7, j + 2, k + 5, Blocks.obsidian, 0, 2);
        world.setBlock(i + 8, j + 2, k + 5, Blocks.obsidian, 0, 2);
        world.setBlock(i + 9, j + 2, k + 5, Blocks.obsidian, 0, 2);
        world.setBlock(i + 10, j + 2, k + 5, Blocks.obsidian, 0, 2);
        world.setBlock(i + 11, j + 2, k + 5, Blocks.obsidian, 0, 2);
        world.setBlock(i + 12, j + 2, k + 5, Blocks.obsidian, 0, 2);
        world.setBlock(i + 13, j + 2, k + 5, Blocks.obsidian, 0, 2);
        world.setBlock(i + 14, j + 2, k + 5, Blocks.obsidian, 0, 2);
        world.setBlock(i + 15, j + 2, k + 5, Blocks.obsidian, 0, 2);
        world.setBlock(i + 16, j + 2, k + 5, Blocks.obsidian, 0, 2);
        world.setBlock(i + 17, j + 2, k + 5, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 18, j + 2, k + 5, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 20, j + 2, k + 5, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 3, j + 2, k + 6, placeFontierslatePillar(random), 4, 2);
        world.setBlock(i + 4, j + 2, k + 6, placeFontierslatePillar(random), 4, 2);
        world.setBlock(i + 5, j + 2, k + 6, placeFontierslatePillar(random), 4, 2);
        world.setBlock(i + 6, j + 2, k + 6, placeFontierslatePillar(random), 4, 2);
        world.setBlock(i + 7, j + 2, k + 6, placeFontierslatePillar(random), 4, 2);
        world.setBlock(i + 8, j + 2, k + 6, placeFontierslatePillar(random), 4, 2);
        world.setBlock(i + 9, j + 2, k + 6, placeFontierslatePillar(random), 4, 2);
        world.setBlock(i + 10, j + 2, k + 6, placeFontierslatePillar(random), 4, 2);
        world.setBlock(i + 11, j + 2, k + 6, placeFontierslatePillar(random), 4, 2);
        world.setBlock(i + 12, j + 2, k + 6, placeFontierslatePillar(random), 4, 2);
        world.setBlock(i + 13, j + 2, k + 6, placeFontierslatePillar(random), 4, 2);
        world.setBlock(i + 14, j + 2, k + 6, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 15, j + 2, k + 6, placeFontierslatePillar(random), 4, 2);
        world.setBlock(i + 16, j + 2, k + 6, placeFontierslatePillar(random), 4, 2);
        world.setBlock(i + 17, j + 2, k + 6, placeFontierslatePillar(random), 4, 2);
        world.setBlock(i + 18, j + 2, k + 6, placeFontierslatePillar(random), 4, 2);
        world.setBlock(i + 19, j + 2, k + 6, placeFontierslatePillar(random), 4, 2);
        world.setBlock(i + 20, j + 2, k + 6, placeFontierslatePillar(random), 4, 2);
        world.setBlock(i + 21, j + 2, k + 6, placeFontierslatePillar(random), 4, 2);
        world.setBlock(i + 22, j + 2, k + 6, placeFontierslatePillar(random), 4, 2);
        world.setBlock(i + 3, j + 2, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 2, k + 7, Blocks.obsidian, 0, 2);
        world.setBlock(i + 5, j + 2, k + 7, Blocks.obsidian, 0, 2);
        world.setBlock(i + 6, j + 2, k + 7, Blocks.obsidian, 0, 2);
        world.setBlock(i + 7, j + 2, k + 7, Blocks.obsidian, 0, 2);
        world.setBlock(i + 8, j + 2, k + 7, Blocks.obsidian, 0, 2);
        world.setBlock(i + 9, j + 2, k + 7, Blocks.obsidian, 0, 2);
        world.setBlock(i + 10, j + 2, k + 7, Blocks.obsidian, 0, 2);
        world.setBlock(i + 11, j + 2, k + 7, Blocks.obsidian, 0, 2);
        world.setBlock(i + 12, j + 2, k + 7, Blocks.obsidian, 0, 2);
        world.setBlock(i + 13, j + 2, k + 7, Blocks.obsidian, 0, 2);
        world.setBlock(i + 14, j + 2, k + 7, Blocks.obsidian, 0, 2);
        world.setBlock(i + 15, j + 2, k + 7, Blocks.obsidian, 0, 2);
        world.setBlock(i + 16, j + 2, k + 7, Blocks.obsidian, 0, 2);
        world.setBlock(i + 17, j + 2, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 18, j + 2, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 19, j + 2, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 20, j + 2, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 3, j + 2, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 2, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 2, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 2, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 2, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 2, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 2, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 2, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 2, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 2, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 2, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 14, j + 2, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 15, j + 2, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 16, j + 2, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 17, j + 2, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 18, j + 2, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 3, j + 2, k + 9, placeFrontierslateBrickStairs(random), 7, 2);
        world.setBlock(i + 7, j + 2, k + 9, placeFrontierslateBrickStairs(random), 7, 2);
        world.setBlock(i + 11, j + 2, k + 9, placeFrontierslateBrickStairs(random), 7, 2);
        world.setBlock(i + 15, j + 2, k + 9, placeFrontierslateBrickStairs(random), 7, 2);
        world.setBlock(i + 10, j + 3, k + 1, NovaCraftBlocks.frontierslate_brick_wall, 0, 2);
        world.setBlock(i + 7, j + 3, k + 2, placeFrontierslateBrickStairs(random), 6, 2);
        world.setBlock(i + 11, j + 3, k + 2, placeFrontierslateBrickStairs(random), 6, 2);
        world.setBlock(i + 15, j + 3, k + 2, placeFrontierslateBrickStairs(random), 6, 2);
        world.setBlock(i + 7, j + 3, k + 3, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 3, k + 3, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 3, k + 3, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 3, k + 3, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 3, k + 3, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 3, k + 3, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 3, k + 3, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 14, j + 3, k + 3, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 15, j + 3, k + 3, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 16, j + 3, k + 3, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 17, j + 3, k + 3, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 3, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 3, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 3, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 14, j + 3, k + 6, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 20, j + 3, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 22, j + 3, k + 6, placeFontierslatePillar(random), 4, 2);
        world.setBlock(i + 23, j + 3, k + 6, placeFontierslatePillar(random), 4, 2);
        world.setBlock(i + 3, j + 3, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 3, k + 7, Blocks.packed_ice, 0, 2);
        world.setBlock(i + 5, j + 3, k + 7, Blocks.packed_ice, 0, 2);
        world.setBlock(i + 6, j + 3, k + 7, Blocks.packed_ice, 0, 2);
        world.setBlock(i + 7, j + 3, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 20, j + 3, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 21, j + 3, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 3, j + 3, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 3, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 3, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 3, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 3, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 3, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 3, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 14, j + 3, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 19, j + 3, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 20, j + 3, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 3, j + 3, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 3, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 3, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 3, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 3, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 3, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 3, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 15, j + 3, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 16, j + 3, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 17, j + 3, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 18, j + 3, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 3, j + 3, k + 10, placeFrontierslateBrickStairs(random), 7, 2);
        world.setBlock(i + 7, j + 3, k + 10, placeFrontierslateBrickStairs(random), 7, 2);
        world.setBlock(i + 11, j + 3, k + 10, placeFrontierslateBrickStairs(random), 7, 2);
        world.setBlock(i + 15, j + 3, k + 10, placeFrontierslateBrickStairs(random), 7, 2);
        world.setBlock(i + 19, j + 3, k + 10, NovaCraftBlocks.frontierslate_brick_wall, 0, 2);
        world.setBlock(i + 10, j + 4, k + 1, NovaCraftBlocks.frontierslate_brick_wall, 0, 2);
        world.setBlock(i + 6, j + 4, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 4, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 4, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 4, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 4, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 4, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 4, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 4, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 14, j + 4, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 15, j + 4, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 16, j + 4, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 17, j + 4, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 4, k + 3, Blocks.carpet, 10, 2);
        world.setBlock(i + 5, j + 4, k + 3, Blocks.carpet, 10, 2);
        world.setBlock(i + 6, j + 4, k + 3, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 7, j + 4, k + 3, Blocks.carpet, 10, 2);
        world.setBlock(i + 8, j + 4, k + 3, Blocks.carpet, 10, 2);
        world.setBlock(i + 14, j + 4, k + 6, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 21, j + 4, k + 6, Blocks.carpet, 10, 2);
        world.setBlock(i + 22, j + 4, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 23, j + 4, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 3, j + 4, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 21, j + 4, k + 7, Blocks.carpet, 10, 2);
        world.setBlock(i + 22, j + 4, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 3, j + 4, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 4, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 4, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 4, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 4, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 4, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 4, k + 8, placeFrontierslateBrickStairs(random), 1, 2);
        world.setBlock(i + 20, j + 4, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 21, j + 4, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 3, j + 4, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 4, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 4, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 4, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 4, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 4, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 4, k + 9, placeFrontierslateBrickStairs(random), 1, 2);
        world.setBlock(i + 18, j + 4, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 19, j + 4, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 2, j + 4, k + 10, placeFrontierslateBrickStairs(random), 4, 2);
        world.setBlock(i + 3, j + 4, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 4, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 4, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 4, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 4, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 4, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 4, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 15, j + 4, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 16, j + 4, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 17, j + 4, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 19, j + 4, k + 10, NovaCraftBlocks.frontierslate_brick_wall, 0, 2);
        world.setBlock(i + 1, j + 5, k + 1, placeFrontierslateBrickStairs(random), 6, 2);
        world.setBlock(i + 2, j + 5, k + 1, placeFrontierslateBrickStairs(random), 6, 2);
        world.setBlock(i + 3, j + 5, k + 1, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 4, j + 5, k + 1, placeFrontierslateBrickStairs(random), 6, 2);
        world.setBlock(i + 5, j + 5, k + 1, placeFrontierslateBrickStairs(random), 6, 2);
        world.setBlock(i + 6, j + 5, k + 1, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 7, j + 5, k + 1, placeFrontierslateBrickStairs(random), 6, 2);
        world.setBlock(i + 8, j + 5, k + 1, placeFrontierslateBrickStairs(random), 5, 2);
        world.setBlock(i + 10, j + 5, k + 1, NovaCraftBlocks.frontierslate_brick_wall, 0, 2);
        world.setBlock(i + 12, j + 5, k + 1, placeFrontierslateBrickStairs(random), 6, 2);
        world.setBlock(i + 15, j + 5, k + 1, placeFrontierslateBrickStairs(random), 6, 2);
        world.setBlock(i + 1, j + 5, k + 2, placeFrontierslateBrickStairs(random), 4, 2);
        world.setBlock(i + 2, j + 5, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 3, j + 5, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 5, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 5, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 5, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 5, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 5, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 5, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 5, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 5, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 5, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 5, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 14, j + 5, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 15, j + 5, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 16, j + 5, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 17, j + 5, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 1, j + 5, k + 3, placeFrontierslateBrickStairs(random), 0, 2);
        world.setBlock(i + 2, j + 5, k + 3, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 3, j + 5, k + 3, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 5, k + 3, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 5, k + 3, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 5, k + 3, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 5, k + 3, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 18, j + 5, k + 3, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 1, j + 5, k + 4, placeFrontierslateBrickStairs(random), 4, 2);
        world.setBlock(i + 2, j + 5, k + 4, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 5, k + 4, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 5, k + 4, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 5, k + 4, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 5, k + 4, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 1, j + 5, k + 5, placeFrontierslateBrickStairs(random), 4, 2);
        world.setBlock(i + 2, j + 5, k + 5, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 5, k + 5, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 5, k + 5, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 5, k + 5, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 5, k + 5, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 1, j + 5, k + 6, placeFrontierslateBrickStairs(random), 0, 2);
        world.setBlock(i + 2, j + 5, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 3, j + 5, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 5, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 5, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 5, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 5, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 5, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 14, j + 5, k + 6, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 22, j + 5, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 23, j + 5, k + 6, placeFontierslatePillar(random), 4, 2);
        world.setBlock(i + 24, j + 5, k + 6, placeFontierslatePillar(random), 4, 2);
        world.setBlock(i + 1, j + 5, k + 7, placeFrontierslateBrickStairs(random), 4, 2);
        world.setBlock(i + 2, j + 5, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 3, j + 5, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 5, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 5, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 5, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 5, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 5, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 22, j + 5, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 1, j + 5, k + 8, placeFrontierslateBrickStairs(random), 4, 2);
        world.setBlock(i + 2, j + 5, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 3, j + 5, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 5, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 5, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 5, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 5, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 5, k + 8, placeFrontierslateBrickStairs(random), 1, 2);
        world.setBlock(i + 20, j + 5, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 21, j + 5, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 1, j + 5, k + 9, placeFrontierslateBrickStairs(random), 4, 2);
        world.setBlock(i + 2, j + 5, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 3, j + 5, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 5, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 5, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 5, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 5, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 5, k + 9, placeFrontierslateBrickStairs(random), 1, 2);
        world.setBlock(i + 18, j + 5, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 19, j + 5, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 1, j + 5, k + 10, placeFrontierslateBrickStairs(random), 4, 2);
        world.setBlock(i + 2, j + 5, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 3, j + 5, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 5, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 5, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 5, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 5, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 5, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 5, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 15, j + 5, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 16, j + 5, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 17, j + 5, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 19, j + 5, k + 10, NovaCraftBlocks.frontierslate_brick_wall, 0, 2);
        world.setBlock(i + 1, j + 5, k + 11, placeFrontierslateBrickStairs(random), 4, 2);
        world.setBlock(i + 2, j + 5, k + 11, placeFrontierslateBrickStairs(random), 7, 2);
        world.setBlock(i + 3, j + 5, k + 11, placeFrontierslateBrickStairs(random), 3, 2);
        world.setBlock(i + 4, j + 5, k + 11, placeFrontierslateBrickStairs(random), 7, 2);
        world.setBlock(i + 5, j + 5, k + 11, placeFrontierslateBrickStairs(random), 7, 2);
        world.setBlock(i + 6, j + 5, k + 11, placeFrontierslateBrickStairs(random), 3, 2);
        world.setBlock(i + 7, j + 5, k + 11, placeFrontierslateBrickStairs(random), 7, 2);
        world.setBlock(i + 8, j + 5, k + 11, placeFrontierslateBrickStairs(random), 5, 2);
        world.setBlock(i + 12, j + 5, k + 11, placeFrontierslateBrickStairs(random), 7, 2);
        world.setBlock(i + 15, j + 5, k + 11, placeFrontierslateBrickStairs(random), 7, 2);
        world.setBlock(i + 1, j + 6, k + 1, placeEndRod(random), 1, 2);
        world.setBlock(i + 2, j + 6, k + 2, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 3, j + 6, k + 2, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 4, j + 6, k + 2, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 5, j + 6, k + 2, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 6, j + 6, k + 2, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 7, j + 6, k + 2, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 8, j + 6, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 6, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 6, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 6, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 6, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 14, j + 6, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 16, j + 6, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 17, j + 6, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 2, j + 6, k + 3, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 6, k + 3, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 4, j + 6, k + 3, placeFrontierslateBrickStairs(random), 3, 2);
        world.setBlock(i + 5, j + 6, k + 3, placeFrontierslateBrickStairs(random), 3, 2);
        world.setBlock(i + 7, j + 6, k + 3, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 6, k + 3, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 6, k + 3, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 18, j + 6, k + 3, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 2, j + 6, k + 4, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j + 6, k + 4, placeFrontierslateBrickStairs(random), 0, 2);
        world.setBlock(i + 9, j + 6, k + 4, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 2, j + 6, k + 5, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j + 6, k + 5, placeFrontierslateBrickStairs(random), 0, 2);
        world.setBlock(i + 9, j + 6, k + 5, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 2, j + 6, k + 6, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 7, j + 6, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 6, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 6, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 14, j + 6, k + 6, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 22, j + 6, k + 6, placeEndRod(random), 4, 2);
        world.setBlock(i + 24, j + 6, k + 6, placeFontierslatePillar(random), 4, 2);
        world.setBlock(i + 25, j + 6, k + 6, placeFontierslatePillar(random), 4, 2);
        world.setBlock(i + 2, j + 6, k + 7, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 7, j + 6, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 6, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 6, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 22, j + 6, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 2, j + 6, k + 8, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 20, j + 6, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 21, j + 6, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 2, j + 6, k + 9, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 6, k + 9, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 4, j + 6, k + 9, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 5, j + 6, k + 9, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 18, j + 6, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 19, j + 6, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 2, j + 6, k + 10, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 3, j + 6, k + 10, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 4, j + 6, k + 10, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 5, j + 6, k + 10, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 6, j + 6, k + 10, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 7, j + 6, k + 10, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 8, j + 6, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 6, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 6, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 14, j + 6, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 16, j + 6, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 17, j + 6, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 1, j + 6, k + 11, placeEndRod(random), 1, 2);
        world.setBlock(i + 2, j + 7, k + 2, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 3, j + 7, k + 2, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 4, j + 7, k + 2, placeVacuumGlass(random), 0, 2);
        world.setBlock(i + 5, j + 7, k + 2, placeVacuumGlass(random), 0, 2);
        world.setBlock(i + 6, j + 7, k + 2, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 7, j + 7, k + 2, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 8, j + 7, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 7, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 7, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 7, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 7, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 7, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 14, j + 7, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 15, j + 7, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 16, j + 7, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 17, j + 7, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 18, j + 7, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 2, j + 7, k + 3, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 7, j + 7, k + 3, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 7, k + 3, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 7, k + 3, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 7, k + 3, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 7, k + 3, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 7, k + 3, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 7, k + 3, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 14, j + 7, k + 3, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 15, j + 7, k + 3, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 16, j + 7, k + 3, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 17, j + 7, k + 3, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 18, j + 7, k + 3, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 19, j + 7, k + 3, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 7, k + 4, placeFrontierslateBrickStairs(random), 0, 2);
        world.setBlock(i + 10, j + 7, k + 4, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 7, k + 4, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 7, k + 4, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 7, k + 4, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 14, j + 7, k + 4, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 15, j + 7, k + 4, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 16, j + 7, k + 4, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 17, j + 7, k + 4, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 18, j + 7, k + 4, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 19, j + 7, k + 4, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 20, j + 7, k + 4, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 2, j + 7, k + 5, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 9, j + 7, k + 5, placeFrontierslateBrickStairs(random), 0, 2);
        world.setBlock(i + 10, j + 7, k + 5, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 7, k + 5, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 7, k + 5, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 7, k + 5, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 14, j + 7, k + 5, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 15, j + 7, k + 5, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 16, j + 7, k + 5, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 17, j + 7, k + 5, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 18, j + 7, k + 5, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 19, j + 7, k + 5, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 20, j + 7, k + 5, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 21, j + 7, k + 5, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 22, j + 7, k + 5, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 2, j + 7, k + 4, placeVacuumGlass(random), 0, 2);
        world.setBlock(i + 2, j + 7, k + 6, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 7, j + 7, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 7, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 7, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 7, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 7, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 7, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 7, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 14, j + 7, k + 6, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 15, j + 7, k + 6, placeVacuumGlass(random), 0, 2);
        world.setBlock(i + 16, j + 7, k + 6, placeFontierslatePillar(random), 4, 2);
        world.setBlock(i + 17, j + 7, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 18, j + 7, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 19, j + 7, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 20, j + 7, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 21, j + 7, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 22, j + 7, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 23, j + 7, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 24, j + 7, k + 6, placeFontierslatePillar(random), 4, 2);
        world.setBlock(i + 25, j + 7, k + 6, placeFontierslatePillar(random), 4, 2);
        world.setBlock(i + 26, j + 7, k + 6, placeFontierslatePillar(random), 4, 2);
        world.setBlock(i + 27, j + 7, k + 6, placeFontierslatePillar(random), 4, 2);
        world.setBlock(i + 2, j + 7, k + 7, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 7, j + 7, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 7, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 7, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 7, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 7, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 7, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 7, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 14, j + 7, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 15, j + 7, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 16, j + 7, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 17, j + 7, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 18, j + 7, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 19, j + 7, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 20, j + 7, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 21, j + 7, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 22, j + 7, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 23, j + 7, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 2, j + 7, k + 8, placeVacuumGlass(random), 0, 2);
        world.setBlock(i + 10, j + 7, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 7, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 7, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 7, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 14, j + 7, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 15, j + 7, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 16, j + 7, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 17, j + 7, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 18, j + 7, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 19, j + 7, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 20, j + 7, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 21, j + 7, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 22, j + 7, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 2, j + 7, k + 9, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 10, j + 7, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 7, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 7, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 7, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 14, j + 7, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 15, j + 7, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 16, j + 7, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 17, j + 7, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 18, j + 7, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 19, j + 7, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 20, j + 7, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 2, j + 7, k + 10, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 3, j + 7, k + 10, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 4, j + 7, k + 10, placeVacuumGlass(random), 0, 2);
        world.setBlock(i + 5, j + 7, k + 10, placeVacuumGlass(random), 0, 2);
        world.setBlock(i + 6, j + 7, k + 10, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 7, j + 7, k + 10, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 8, j + 7, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 7, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 7, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 7, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 7, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 7, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 14, j + 7, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 15, j + 7, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 16, j + 7, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 17, j + 7, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 18, j + 7, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 2, j + 8, k + 2, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 3, j + 8, k + 2, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 4, j + 8, k + 2, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 5, j + 8, k + 2, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 6, j + 8, k + 2, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 7, j + 8, k + 2, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 8, j + 8, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 8, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 8, k + 2, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 11, j + 8, k + 2, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 12, j + 8, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 8, k + 2, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 14, j + 8, k + 2, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 15, j + 8, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 16, j + 8, k + 2, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 17, j + 8, k + 2, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 18, j + 8, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 2, j + 8, k + 3, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 7, j + 8, k + 3, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 2, j + 8, k + 4, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 2, j + 8, k + 5, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 2, j + 8, k + 6, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 7, j + 8, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 8, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 8, k + 6, placeLadder(random), 4, 2);
        world.setBlock(i + 14, j + 8, k + 6, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 16, j + 8, k + 6, placeFrontierslateBrickStairs(random), 0, 2);
        world.setBlock(i + 17, j + 8, k + 6, placeFontierslatePillar(random), 4, 2);
        world.setBlock(i + 18, j + 8, k + 6, placeFontierslatePillar(random), 4, 2);
        world.setBlock(i + 24, j + 8, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 27, j + 8, k + 6, placeFrontierslateBrickStairs(random), 0, 2);
        world.setBlock(i + 2, j + 8, k + 7, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 7, j + 8, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 8, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 23, j + 8, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 2, j + 8, k + 8, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 7, j + 8, k + 8, placeFrontierslateBrickStairs(random), 4, 2);
        world.setBlock(i + 8, j + 8, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 8, k + 8, placeFrontierslateBrickStairs(random), 1, 2);
        world.setBlock(i + 20, j + 8, k + 8, placeFrontierslateBrickStairs(random), 1, 2);
        world.setBlock(i + 21, j + 8, k + 8, placeFrontierslateBrickStairs(random), 3, 2);
        world.setBlock(i + 22, j + 8, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 2, j + 8, k + 9, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 7, j + 8, k + 9, placeFrontierslateBrickStairs(random), 4, 2);
        world.setBlock(i + 8, j + 8, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 8, k + 9, placeFrontierslateBrickStairs(random), 1, 2);
        world.setBlock(i + 18, j + 8, k + 9, placeFrontierslateBrickStairs(random), 1, 2);
        world.setBlock(i + 19, j + 8, k + 9, placeFrontierslateBrickStairs(random), 3, 2);
        world.setBlock(i + 20, j + 8, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 2, j + 8, k + 10, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 3, j + 8, k + 10, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 4, j + 8, k + 10, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 5, j + 8, k + 10, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 6, j + 8, k + 10, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 7, j + 8, k + 10, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 8, j + 8, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 8, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 8, k + 10, placeFrontierslateBrickStairs(random), 3, 2);
        world.setBlock(i + 11, j + 8, k + 10, placeFrontierslateBrickStairs(random), 3, 2);
        world.setBlock(i + 12, j + 8, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 8, k + 10, placeFrontierslateBrickStairs(random), 3, 2);
        world.setBlock(i + 14, j + 8, k + 10, placeFrontierslateBrickStairs(random), 3, 2);
        world.setBlock(i + 15, j + 8, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 16, j + 8, k + 10, placeFrontierslateBrickStairs(random), 3, 2);
        world.setBlock(i + 17, j + 8, k + 10, placeFrontierslateBrickStairs(random), 3, 2);
        world.setBlock(i + 18, j + 8, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i, j + 9, k, placeFrontierslateBrickStairs(random), 4, 2);
        world.setBlock(i + 1, j + 9, k, placeFrontierslateBrickStairs(random), 6, 2);
        world.setBlock(i + 2, j + 9, k, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 3, j + 9, k, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 4, j + 9, k, placeFrontierslateBrickStairs(random), 6, 2);
        world.setBlock(i + 5, j + 9, k, placeFrontierslateBrickStairs(random), 6, 2);
        world.setBlock(i + 6, j + 9, k, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 7, j + 9, k, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 8, j + 9, k, placeFrontierslateBrickStairs(random), 6, 2);
        world.setBlock(i + 9, j + 9, k, placeFrontierslateBrickStairs(random), 6, 2);
        world.setBlock(i, j + 9, k + 1, placeFrontierslateBrickStairs(random), 4, 2);
        world.setBlock(i + 1, j + 9, k + 1, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 2, j + 9, k + 1, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 3, j + 9, k + 1, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 9, k + 1, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 9, k + 1, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 9, k + 1, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 9, k + 1, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 9, k + 1, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 9, k + 1, placeFrontierslateBrickStairs(random), 5, 2);
        world.setBlock(i, j + 9, k + 2, placeFrontierslateBrickStairs(random), 0, 2);
        world.setBlock(i + 1, j + 9, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 2, j + 9, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 3, j + 9, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 9, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 9, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 9, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 9, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 9, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 9, k + 2, placeFrontierslateBrickStairs(random), 5, 2);
        world.setBlock(i + 12, j + 9, k + 2, placeEndRod(random), 1, 2);
        world.setBlock(i + 18, j + 9, k + 2, placeEndRod(random), 1, 2);
        world.setBlock(i, j + 9, k + 3, placeFrontierslateBrickStairs(random), 0, 2);
        world.setBlock(i + 1, j + 9, k + 3, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 2, j + 9, k + 3, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 3, j + 9, k + 3, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 9, k + 3, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 9, k + 3, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 9, k + 3, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 9, k + 3, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 9, k + 3, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 9, k + 3, placeFrontierslateBrickStairs(random), 5, 2);
        world.setBlock(i, j + 9, k + 4, placeFrontierslateBrickStairs(random), 4, 2);
        world.setBlock(i + 1, j + 9, k + 4, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 2, j + 9, k + 4, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 3, j + 9, k + 4, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 9, k + 4, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 9, k + 4, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 9, k + 4, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 9, k + 4, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i, j + 9, k + 5, placeFrontierslateBrickStairs(random), 4, 2);
        world.setBlock(i + 1, j + 9, k + 5, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 2, j + 9, k + 5, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 3, j + 9, k + 5, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 9, k + 5, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 9, k + 5, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 9, k + 5, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 9, k + 5, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i, j + 9, k + 6, placeFrontierslateBrickStairs(random), 0, 2);
        world.setBlock(i + 1, j + 9, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 2, j + 9, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 3, j + 9, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 9, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 9, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 9, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 9, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 9, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 9, k + 6, placeLadder(random), 4, 2);
        world.setBlock(i + 14, j + 9, k + 6, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 18, j + 9, k + 6, placeFrontierslateBrickStairs(random), 0, 2);
        world.setBlock(i + 19, j + 9, k + 6, placeFontierslatePillar(random), 4, 2);
        world.setBlock(i + 20, j + 9, k + 6, placeFontierslatePillar(random), 4, 2);
        world.setBlock(i + 24, j + 9, k + 6, placeEndRod(random), 1, 2);
        world.setBlock(i, j + 9, k + 7, placeFrontierslateBrickStairs(random), 4, 2);
        world.setBlock(i + 1, j + 9, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 2, j + 9, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 3, j + 9, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 9, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 9, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 9, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 9, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 9, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i, j + 9, k + 8, placeFrontierslateBrickStairs(random), 4, 2);
        world.setBlock(i + 1, j + 9, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 2, j + 9, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 3, j + 9, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 9, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 9, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 9, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 9, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 9, k + 8, placeFrontierslateBrickStairs(random), 1, 2);
        world.setBlock(i, j + 9, k + 9, placeFrontierslateBrickStairs(random), 0, 2);
        world.setBlock(i + 1, j + 9, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 2, j + 9, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 3, j + 9, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 9, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 9, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 9, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 9, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 9, k + 9, placeFrontierslateBrickStairs(random), 1, 2);
        world.setBlock(i, j + 9, k + 10, placeFrontierslateBrickStairs(random), 0, 2);
        world.setBlock(i + 1, j + 9, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 2, j + 9, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 3, j + 9, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 9, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 9, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 9, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 9, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 9, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 9, k + 10, placeEndRod(random), 1, 2);
        world.setBlock(i + 18, j + 9, k + 10, placeEndRod(random), 1, 2);
        world.setBlock(i, j + 9, k + 11, placeFrontierslateBrickStairs(random), 4, 2);
        world.setBlock(i + 1, j + 9, k + 11, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 2, j + 9, k + 11, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 3, j + 9, k + 11, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 9, k + 11, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 9, k + 11, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 9, k + 11, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 9, k + 11, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 9, k + 11, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 9, k + 11, placeFrontierslateBrickStairs(random), 5, 2);
        world.setBlock(i, j + 9, k + 12, placeFrontierslateBrickStairs(random), 7, 2);
        world.setBlock(i + 1, j + 9, k + 12, placeFrontierslateBrickStairs(random), 7, 2);
        world.setBlock(i + 2, j + 9, k + 12, placeFrontierslateBrickStairs(random), 3, 2);
        world.setBlock(i + 3, j + 9, k + 12, placeFrontierslateBrickStairs(random), 3, 2);
        world.setBlock(i + 4, j + 9, k + 12, placeFrontierslateBrickStairs(random), 7, 2);
        world.setBlock(i + 5, j + 9, k + 12, placeFrontierslateBrickStairs(random), 7, 2);
        world.setBlock(i + 6, j + 9, k + 12, placeFrontierslateBrickStairs(random), 3, 2);
        world.setBlock(i + 7, j + 9, k + 12, placeFrontierslateBrickStairs(random), 3, 2);
        world.setBlock(i + 8, j + 9, k + 12, placeFrontierslateBrickStairs(random), 7, 2);
        world.setBlock(i + 9, j + 9, k + 12, placeFrontierslateBrickStairs(random), 5, 2);
        world.setBlock(i + 1, j + 10, k + 1, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 2, j + 10, k + 1, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 3, j + 10, k + 1, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 4, j + 10, k + 1, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 5, j + 10, k + 1, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 6, j + 10, k + 1, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 7, j + 10, k + 1, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 8, j + 10, k + 1, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 1, j + 10, k + 2, placeFrontierslateBrickStairs(random), 0, 2);
        world.setBlock(i + 8, j + 10, k + 2, placeFrontierslateBrickStairs(random), 1, 2);
        world.setBlock(i + 1, j + 10, k + 3, placeFrontierslateBrickStairs(random), 0, 2);
        world.setBlock(i + 7, j + 10, k + 3, placeFrontierslateBrickStairs(random), 3, 2);
        world.setBlock(i + 8, j + 10, k + 3, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 1, j + 10, k + 4, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 2, j + 10, k + 4, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 7, j + 10, k + 4, placeFrontierslateBrickStairs(random), 1, 2);
        world.setBlock(i + 1, j + 10, k + 5, placeFrontierslateBrickStairs(random), 0, 2);
        world.setBlock(i + 2, j + 10, k + 5, placeFrontierslateBrickStairs(random), 1, 2);
        world.setBlock(i + 7, j + 10, k + 5, placeFrontierslateBrickStairs(random), 1, 2);
        world.setBlock(i + 1, j + 10, k + 6, placeFrontierslateBrickStairs(random), 0, 2);
        world.setBlock(i + 2, j + 10, k + 6, placeFrontierslateBrickStairs(random), 1, 2);
        world.setBlock(i + 7, j + 10, k + 6, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 8, j + 10, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 10, k + 6, placeLadder(random), 4, 2);
        world.setBlock(i + 14, j + 10, k + 6, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 20, j + 10, k + 6, placeFrontierslateBrickStairs(random), 0, 2);
        world.setBlock(i + 21, j + 10, k + 6, placeFontierslatePillar(random), 4, 2);
        world.setBlock(i + 22, j + 10, k + 6, placeFontierslatePillar(random), 4, 2);
        world.setBlock(i + 1, j + 10, k + 7, placeFrontierslateBrickStairs(random), 0, 2);
        world.setBlock(i + 2, j + 10, k + 7, placeFrontierslateBrickStairs(random), 1, 2);
        world.setBlock(i + 8, j + 10, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 1, j + 10, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 2, j + 10, k + 8, placeFrontierslateBrickStairs(random), 3, 2);
        world.setBlock(i + 1, j + 10, k + 9, placeFrontierslateBrickStairs(random), 0, 2);
        world.setBlock(i + 1, j + 10, k + 10, placeFrontierslateBrickStairs(random), 0, 2);
        world.setBlock(i + 8, j + 10, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 1, j + 10, k + 11, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 2, j + 10, k + 11, placeFrontierslateBrickStairs(random), 3, 2);
        world.setBlock(i + 3, j + 10, k + 11, placeFrontierslateBrickStairs(random), 3, 2);
        world.setBlock(i + 4, j + 10, k + 11, placeFrontierslateBrickStairs(random), 3, 2);
        world.setBlock(i + 5, j + 10, k + 11, placeFrontierslateBrickStairs(random), 3, 2);
        world.setBlock(i + 6, j + 10, k + 11, placeFrontierslateBrickStairs(random), 3, 2);
        world.setBlock(i + 7, j + 10, k + 11, placeFrontierslateBrickStairs(random), 3, 2);
        world.setBlock(i + 8, j + 10, k + 11, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 1, j + 11, k + 1, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 8, j + 11, k + 1, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 13, j + 11, k + 6, placeLadder(random), 4, 2);
        world.setBlock(i + 14, j + 11, k + 6, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 22, j + 11, k + 6, placeFrontierslateBrickStairs(random), 0, 2);
        world.setBlock(i + 23, j + 11, k + 6, placeFontierslatePillar(random), 4, 2);
        world.setBlock(i + 24, j + 11, k + 6, placeFontierslatePillar(random), 4, 2);
        world.setBlock(i + 1, j + 11, k + 11, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 8, j + 11, k + 11, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 1, j + 12, k + 1, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 8, j + 12, k + 1, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 13, j + 12, k + 6, placeLadder(random), 4, 2);
        world.setBlock(i + 14, j + 12, k + 6, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 24, j + 12, k + 6, placeFrontierslateBrickStairs(random), 0, 2);
        world.setBlock(i + 25, j + 12, k + 6, placeFontierslatePillar(random), 4, 2);
        world.setBlock(i + 26, j + 12, k + 6, placeFontierslatePillar(random), 4, 2);
        world.setBlock(i + 27, j + 12, k + 6, placeFrontierslateBrickSlab(random), 8, 2);
        world.setBlock(i + 1, j + 12, k + 11, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 8, j + 12, k + 11, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 1, j + 13, k + 1, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 8, j + 13, k + 1, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 13, j + 13, k + 6, placeLadder(random), 4, 2);
        world.setBlock(i + 14, j + 13, k + 6, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 1, j + 13, k + 11, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 8, j + 13, k + 11, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 1, j + 14, k, placeFrontierslateBrickStairs(random), 6, 2);
        world.setBlock(i + 8, j + 14, k, placeFrontierslateBrickStairs(random), 6, 2);
        world.setBlock(i, j + 14, k + 1, placeFrontierslateBrickStairs(random), 4, 2);
        world.setBlock(i + 1, j + 14, k + 1, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 2, j + 14, k + 1, placeFrontierslateBrickStairs(random), 5, 2);
        world.setBlock(i + 7, j + 14, k + 1, placeFrontierslateBrickStairs(random), 4, 2);
        world.setBlock(i + 8, j + 14, k + 1, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 9, j + 14, k + 1, placeFrontierslateBrickStairs(random), 5, 2);
        world.setBlock(i + 1, j + 14, k + 2, placeFrontierslateBrickStairs(random), 7, 2);
        world.setBlock(i + 8, j + 14, k + 2, placeFrontierslateBrickStairs(random), 7, 2);
        world.setBlock(i + 13, j + 14, k + 6, placeLadder(random), 4, 2);
        world.setBlock(i + 14, j + 14, k + 6, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 1, j + 14, k + 10, placeFrontierslateBrickStairs(random), 6, 2);
        world.setBlock(i + 8, j + 14, k + 10, placeFrontierslateBrickStairs(random), 6, 2);
        world.setBlock(i, j + 14, k + 11, placeFrontierslateBrickStairs(random), 4, 2);
        world.setBlock(i + 1, j + 14, k + 11, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 2, j + 14, k + 11, placeFrontierslateBrickStairs(random), 5, 2);
        world.setBlock(i + 7, j + 14, k + 11, placeFrontierslateBrickStairs(random), 4, 2);
        world.setBlock(i + 8, j + 14, k + 11, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 9, j + 14, k + 11, placeFrontierslateBrickStairs(random), 5, 2);
        world.setBlock(i + 1, j + 14, k + 12, placeFrontierslateBrickStairs(random), 7, 2);
        world.setBlock(i + 8, j + 14, k + 12, placeFrontierslateBrickStairs(random), 7, 2);
        world.setBlock(i + 1, j + 15, k + 1, placeEndRod(random), 1, 2);
        world.setBlock(i + 8, j + 15, k + 1, placeEndRod(random), 1, 2);
        world.setBlock(i + 13, j + 15, k + 6, placeLadder(random), 4, 2);
        world.setBlock(i + 14, j + 15, k + 6, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 1, j + 15, k + 11, placeEndRod(random), 1, 2);
        world.setBlock(i + 8, j + 15, k + 11, placeEndRod(random), 1, 2);
        world.setBlock(i + 13, j + 16, k + 6, placeLadder(random), 4, 2);
        world.setBlock(i + 14, j + 16, k + 6, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 13, j + 17, k + 6, placeLadder(random), 4, 2);
        world.setBlock(i + 14, j + 17, k + 6, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 13, j + 18, k + 6, placeLadder(random), 4, 2);
        world.setBlock(i + 14, j + 18, k + 6, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 13, j + 19, k + 6, placeLadder(random), 4, 2);
        world.setBlock(i + 14, j + 19, k + 6, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 16, j + 19, k + 6, placeEndRod(random), 0, 2);
        world.setBlock(i + 13, j + 20, k + 5, placeFrontierslateBrickSlab(random), 8, 2);
        world.setBlock(i + 14, j + 20, k + 5, placeFrontierslateBrickSlab(random), 8, 2);
        world.setBlock(i + 15, j + 20, k + 5, placeFrontierslateBrickSlab(random), 8, 2);
        world.setBlock(i + 16, j + 20, k + 5, placeFrontierslateBrickSlab(random), 8, 2);
        world.setBlock(i + 13, j + 20, k + 6, placeLadder(random), 4, 2);
        world.setBlock(i + 14, j + 20, k + 6, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 15, j + 20, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 16, j + 20, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 20, k + 7, placeFrontierslateBrickSlab(random), 8, 2);
        world.setBlock(i + 14, j + 20, k + 7, placeFrontierslateBrickSlab(random), 8, 2);
        world.setBlock(i + 15, j + 20, k + 7, placeFrontierslateBrickSlab(random), 8, 2);
        world.setBlock(i + 16, j + 20, k + 7, placeFrontierslateBrickSlab(random), 8, 2);
        world.setBlock(i + 12, j + 21, k + 4, placeFrontierslateBrickStairs(random), 6, 2);
        world.setBlock(i + 13, j + 21, k + 4, placeFrontierslateBrickStairs(random), 6, 2);
        world.setBlock(i + 14, j + 21, k + 4, placeFrontierslateBrickStairs(random), 6, 2);
        world.setBlock(i + 15, j + 21, k + 4, placeFrontierslateBrickStairs(random), 6, 2);
        world.setBlock(i + 16, j + 21, k + 4, placeFrontierslateBrickStairs(random), 6, 2);
        world.setBlock(i + 17, j + 21, k + 4, placeFrontierslateBrickStairs(random), 6, 2);
        world.setBlock(i + 12, j + 21, k + 5, placeFrontierslateBrickStairs(random), 4, 2);
        world.setBlock(i + 16, j + 21, k + 5, Blocks.carpet, 10, 2);
        world.setBlock(i + 17, j + 21, k + 5, placeFrontierslateBrickStairs(random), 5, 2);
        world.setBlock(i + 12, j + 21, k + 6, placeFrontierslateBrickStairs(random), 4, 2);
        world.setBlock(i + 13, j + 21, k + 6, placeLadder(random), 4, 2);
        world.setBlock(i + 14, j + 21, k + 6, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 15, j + 21, k + 6, placeLadder(random), 5, 2);
        world.setBlock(i + 16, j + 21, k + 6, Blocks.carpet, 10, 2);
        world.setBlock(i + 17, j + 21, k + 6, placeFrontierslateBrickStairs(random), 5, 2);
        world.setBlock(i + 12, j + 21, k + 7, placeFrontierslateBrickStairs(random), 4, 2);
        world.setBlock(i + 17, j + 21, k + 7, placeFrontierslateBrickStairs(random), 5, 2);
        world.setBlock(i + 12, j + 21, k + 8, placeFrontierslateBrickStairs(random), 4, 2);
        world.setBlock(i + 13, j + 21, k + 8, placeFrontierslateBrickStairs(random), 7, 2);
        world.setBlock(i + 14, j + 21, k + 8, placeFrontierslateBrickStairs(random), 7, 2);
        world.setBlock(i + 15, j + 21, k + 8, placeFrontierslateBrickStairs(random), 7, 2);
        world.setBlock(i + 16, j + 21, k + 8, placeFrontierslateBrickStairs(random), 7, 2);
        world.setBlock(i + 17, j + 21, k + 8, placeFrontierslateBrickStairs(random), 7, 2);
        world.setBlock(i + 12, j + 22, k + 4, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 17, j + 22, k + 4, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 14, j + 22, k + 6, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 15, j + 22, k + 6, placeLadder(random), 5, 2);
        world.setBlock(i + 12, j + 22, k + 8, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 17, j + 22, k + 8, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 12, j + 23, k + 4, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 13, j + 23, k + 4, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 14, j + 23, k + 4, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 15, j + 23, k + 4, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 16, j + 23, k + 4, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 17, j + 23, k + 4, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 12, j + 23, k + 5, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 17, j + 23, k + 5, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 23, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 14, j + 23, k + 6, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 15, j + 23, k + 6, placeLadder(random), 5, 2);
        world.setBlock(i + 17, j + 23, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 23, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 17, j + 23, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 23, k + 8, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 13, j + 23, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 14, j + 23, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 15, j + 23, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 16, j + 23, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 17, j + 23, k + 8, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 12, j + 24, k + 4, placeFrontierslateBrickStairs(random), 6, 2);
        world.setBlock(i + 13, j + 24, k + 4, placeFrontierslateBrickStairs(random), 6, 2);
        world.setBlock(i + 14, j + 24, k + 4, placeFrontierslateBrickStairs(random), 6, 2);
        world.setBlock(i + 15, j + 24, k + 4, placeFrontierslateBrickStairs(random), 6, 2);
        world.setBlock(i + 16, j + 24, k + 4, placeFrontierslateBrickStairs(random), 6, 2);
        world.setBlock(i + 17, j + 24, k + 4, placeFrontierslateBrickStairs(random), 5, 2);
        world.setBlock(i + 12, j + 24, k + 5, placeFrontierslateBrickStairs(random), 4, 2);
        world.setBlock(i + 17, j + 24, k + 5, placeFrontierslateBrickStairs(random), 5, 2);
        world.setBlock(i + 12, j + 24, k + 6, placeFrontierslateBrickStairs(random), 4, 2);
        world.setBlock(i + 14, j + 24, k + 6, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 15, j + 24, k + 6, placeLadder(random), 5, 2);
        world.setBlock(i + 17, j + 24, k + 6, placeFrontierslateBrickStairs(random), 5, 2);
        world.setBlock(i + 12, j + 24, k + 7, placeFrontierslateBrickStairs(random), 4, 2);
        world.setBlock(i + 17, j + 24, k + 7, placeFrontierslateBrickStairs(random), 5, 2);
        world.setBlock(i + 12, j + 24, k + 8, placeFrontierslateBrickStairs(random), 4, 2);
        world.setBlock(i + 13, j + 24, k + 8, placeFrontierslateBrickStairs(random), 7, 2);
        world.setBlock(i + 14, j + 24, k + 8, placeFrontierslateBrickStairs(random), 7, 2);
        world.setBlock(i + 15, j + 24, k + 8, placeFrontierslateBrickStairs(random), 7, 2);
        world.setBlock(i + 16, j + 24, k + 8, placeFrontierslateBrickStairs(random), 7, 2);
        world.setBlock(i + 17, j + 24, k + 8, placeFrontierslateBrickStairs(random), 7, 2);
        world.setBlock(i + 12, j + 25, k + 4, placeFrontierslateBrickStairs(random), 0, 2);
        world.setBlock(i + 13, j + 25, k + 4, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 14, j + 25, k + 4, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 15, j + 25, k + 4, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 16, j + 25, k + 4, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 17, j + 25, k + 4, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 12, j + 25, k + 5, placeFrontierslateBrickStairs(random), 0, 2);
        world.setBlock(i + 13, j + 25, k + 5, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 14, j + 25, k + 5, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 15, j + 25, k + 5, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 16, j + 25, k + 5, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 17, j + 25, k + 5, placeFrontierslateBrickStairs(random), 1, 2);
        world.setBlock(i + 12, j + 25, k + 6, placeFrontierslateBrickStairs(random), 0, 2);
        world.setBlock(i + 13, j + 25, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 14, j + 25, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 15, j + 25, k + 6, placeLadder(random), 5, 2);
        world.setBlock(i + 16, j + 25, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 17, j + 25, k + 6, placeFrontierslateBrickStairs(random), 1, 2);
        world.setBlock(i + 12, j + 25, k + 7, placeFrontierslateBrickStairs(random), 0, 2);
        world.setBlock(i + 13, j + 25, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 14, j + 25, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 15, j + 25, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 16, j + 25, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 17, j + 25, k + 7, placeFrontierslateBrickStairs(random), 1, 2);
        world.setBlock(i + 12, j + 25, k + 8, placeFrontierslateBrickStairs(random), 0, 2);
        world.setBlock(i + 13, j + 25, k + 8, placeFrontierslateBrickStairs(random), 3, 2);
        world.setBlock(i + 14, j + 25, k + 8, placeFrontierslateBrickStairs(random), 3, 2);
        world.setBlock(i + 15, j + 25, k + 8, placeFrontierslateBrickStairs(random), 3, 2);
        world.setBlock(i + 16, j + 25, k + 8, placeFrontierslateBrickStairs(random), 3, 2);
        world.setBlock(i + 17, j + 25, k + 8, placeFrontierslateBrickStairs(random), 1, 2);
        world.setBlock(i + 13, j + 26, k + 5, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 14, j + 26, k + 5, placeFrontierslateBrickStairs(random), 3, 2);
        world.setBlock(i + 15, j + 26, k + 5, placeFrontierslateBrickStairs(random), 3, 2);
        world.setBlock(i + 16, j + 26, k + 5, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 13, j + 26, k + 6, placeFrontierslateBrickStairs(random), 1, 2);
        world.setBlock(i + 16, j + 26, k + 6, placeFrontierslateBrickStairs(random), 0, 2);
        world.setBlock(i + 13, j + 26, k + 7, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 14, j + 26, k + 7, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 15, j + 26, k + 7, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 16, j + 26, k + 7, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 2, j + 7, k + 4, placeVacuumGlass(random), 0, 2);
        world.setBlock(i + 21, j + 3, k + 5, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 13, j + 27, k + 5, placeEndRod(random), 1, 2);
        world.setBlock(i + 16, j + 27, k + 5, placeEndRod(random), 1, 2);
        world.setBlock(i + 13, j + 27, k + 7, placeEndRod(random), 1, 2);
        world.setBlock(i + 16, j + 27, k + 7, placeEndRod(random), 1, 2);

        if (random.nextBoolean()) {
            EntityFrontierGolem entity = new EntityFrontierGolem(world);
            entity.setPosition(i + 14, j + 29, k + 6);

            if (!world.isRemote) {
                world.spawnEntityInWorld(entity);
            }
        }

        if (random.nextBoolean()) {
            EntityFrontierGolem entity = new EntityFrontierGolem(world);
            entity.setPosition(i + 4, j + 10, k + 9);

            if (!world.isRemote) {
                world.spawnEntityInWorld(entity);
            }
        }

        if (random.nextBoolean()) {
            EntityFrontierGolem entity = new EntityFrontierGolem(world);
            entity.setPosition(i + 4, j + 10, k + 4);

            if (!world.isRemote) {
                world.spawnEntityInWorld(entity);
            }
        }

        if (random.nextBoolean()) {
            EntityFrontierGolem entity = new EntityFrontierGolem(world);
            entity.setPosition(i + 11, j + 3, k + 5);

            if (!world.isRemote) {
                world.spawnEntityInWorld(entity);
            }
        }

        if (random.nextBoolean()) {
            EntityFrontierGolem entity = new EntityFrontierGolem(world);
            entity.setPosition(i + 17, j + 3, k + 5);

            if (!world.isRemote) {
                world.spawnEntityInWorld(entity);
            }
        }

        if (random.nextBoolean()) {
            EntityFrontierGolem entity = new EntityFrontierGolem(world);
            entity.setPosition(i + 17, j + 3, k + 7);

            if (!world.isRemote) {
                world.spawnEntityInWorld(entity);
            }
        }

        if (random.nextBoolean()) {
            EntityFrontierGolem entity = new EntityFrontierGolem(world);
            entity.setPosition(i + 11, j + 8, k + 6);

            if (!world.isRemote) {
                world.spawnEntityInWorld(entity);
            }
        }

        if (random.nextBoolean()) {
            EntityFrontierGolem entity = new EntityFrontierGolem(world);
            entity.setPosition(i + 27, j + 13, k + 6);

            if (!world.isRemote) {
                world.spawnEntityInWorld(entity);
            }
        }

        if (random.nextBoolean()) {
            world.setBlock(i + 3, j + 2, k + 3, placeFrontierslateBrickStairs(random), 6, 2);
            world.setBlock(i + 3, j + 2, k + 4, placeFrontierslateBricks(random), 0, 2);
            world.setBlock(i + 4, j + 2, k + 4, placeFrontierslateBricks(random), 0, 2);
            world.setBlock(i + 5, j + 2, k + 4, placeFrontierslateBricks(random), 0, 2);
            world.setBlock(i + 6, j + 2, k + 4, placeFrontierslateBricks(random), 0, 2);
            world.setBlock(i + 3, j + 2, k + 5, placeFrontierslateBricks(random), 0, 2);
            world.setBlock(i + 3, j + 3, k + 2, placeFrontierslateBrickStairs(random), 6, 2);
            world.setBlock(i + 3, j + 3, k + 3, placeFrontierslateBricks(random), 0, 2);
            world.setBlock(i + 4, j + 3, k + 3, placeFrontierslateBricks(random), 0, 2);
            world.setBlock(i + 5, j + 3, k + 3, placeFrontierslateBricks(random), 0, 2);
            world.setBlock(i + 6, j + 3, k + 3, placeFrontierslateBricks(random), 0, 2);
            world.setBlock(i + 3, j + 3, k + 4, placeFrontierslateBricks(random), 0, 2);
            world.setBlock(i + 3, j + 3, k + 5, placeFrontierslateBricks(random), 0, 2);
            world.setBlock(i + 3, j + 3, k + 6, placeFrontierslateBricks(random), 0, 2);
            world.setBlock(i + 2, j + 4, k + 2, placeFrontierslateBrickStairs(random), 4, 2);
            world.setBlock(i + 3, j + 4, k + 2, placeFrontierslateBricks(random), 0, 2);
            world.setBlock(i + 4, j + 4, k + 2, placeFrontierslateBricks(random), 0, 2);
            world.setBlock(i + 5, j + 4, k + 2, placeFrontierslateBricks(random), 0, 2);
            world.setBlock(i + 3, j + 4, k + 3, placeFrontierslateBricks(random), 0, 2);
            world.setBlock(i + 3, j + 4, k + 4, placeFrontierslateBricks(random), 0, 2);
            world.setBlock(i + 3, j + 4, k + 5, placeFrontierslateBricks(random), 0, 2);
            world.setBlock(i + 2, j + 4, k + 6, placeFrontierslateBrickStairs(random), 4, 2);
            world.setBlock(i + 3, j + 4, k + 6, placeFrontierslateBricks(random), 0, 2);
            world.setBlock(i + 4, j + 5, k + 3, placeFrontierslateBricks(random), 0, 2);
            world.setBlock(i + 3, j + 5, k + 4, placeFrontierslateBricks(random), 0, 2);
            world.setBlock(i + 4, j + 5, k + 4, placeFrontierslateBricks(random), 0, 2);
            world.setBlock(i + 3, j + 5, k + 5, placeFrontierslateBricks(random), 0, 2);
            world.setBlock(i + 4, j + 5, k + 5, placeFrontierslateBricks(random), 0, 2);
        } else {
            world.setBlock(i + 3, j + 2, k + 3, Blocks.air, 0, 2);
            world.setBlock(i + 3, j + 2, k + 4, Blocks.air, 0, 2);
            world.setBlock(i + 4, j + 2, k + 4, Blocks.air, 0, 2);
            world.setBlock(i + 5, j + 2, k + 4, Blocks.air, 0, 2);
            world.setBlock(i + 6, j + 2, k + 4, Blocks.air, 0, 2);
            world.setBlock(i + 3, j + 2, k + 5, Blocks.air, 0, 2);
            world.setBlock(i + 3, j + 3, k + 2, Blocks.air, 0, 2);
            world.setBlock(i + 3, j + 3, k + 3, Blocks.air, 0, 2);
            world.setBlock(i + 4, j + 3, k + 3, Blocks.air, 0, 2);
            world.setBlock(i + 5, j + 3, k + 3, Blocks.air, 0, 2);
            world.setBlock(i + 6, j + 3, k + 3, Blocks.air, 0, 2);
            world.setBlock(i + 3, j + 3, k + 4, Blocks.air, 0, 2);
            world.setBlock(i + 3, j + 3, k + 5, Blocks.air, 0, 2);
            world.setBlock(i + 3, j + 3, k + 6, Blocks.air, 0, 2);
            world.setBlock(i + 2, j + 4, k + 2, Blocks.air, 0, 2);
            world.setBlock(i + 3, j + 4, k + 2, Blocks.air, 0, 2);
            world.setBlock(i + 4, j + 4, k + 2, Blocks.air, 0, 2);
            world.setBlock(i + 5, j + 4, k + 2, Blocks.air, 0, 2);
            world.setBlock(i + 3, j + 4, k + 3, Blocks.air, 0, 2);
            world.setBlock(i + 3, j + 4, k + 4, Blocks.air, 0, 2);
            world.setBlock(i + 3, j + 4, k + 5, Blocks.air, 0, 2);
            world.setBlock(i + 2, j + 4, k + 6, Blocks.air, 0, 2);
            world.setBlock(i + 3, j + 4, k + 6, Blocks.air, 0, 2);
            world.setBlock(i + 4, j + 5, k + 3, Blocks.air, 0, 2);
            world.setBlock(i + 3, j + 5, k + 4, Blocks.air, 0, 2);
            world.setBlock(i + 4, j + 5, k + 4, Blocks.air, 0, 2);
            world.setBlock(i + 3, j + 5, k + 5, Blocks.air, 0, 2);
            world.setBlock(i + 4, j + 5, k + 5, Blocks.air, 0, 2);
        }

        if (random.nextBoolean()) {
            world.setBlock(i + 11, j + 6, k + 10, placeFrontierslateBricks(random), 0, 2);
            world.setBlock(i + 13, j + 6, k + 10, placeFrontierslateBricks(random), 0, 2);
            world.setBlock(i + 21, j + 3, k + 6, placeFrontierslateBricks(random), 0, 2);
            world.setBlock(i + 10, j + 3, k + 8, placeFrontierslateBricks(random), 0, 2);
            world.setBlock(i + 11, j + 3, k + 8, placeFrontierslateBricks(random), 0, 2);
            world.setBlock(i + 12, j + 3, k + 8, placeFrontierslateBricks(random), 0, 2);
            world.setBlock(i + 13, j + 3, k + 8, placeFrontierslateBricks(random), 0, 2);
            world.setBlock(i + 10, j + 3, k + 9, placeFrontierslateBricks(random), 0, 2);
            world.setBlock(i + 11, j + 3, k + 9, placeFrontierslateBricks(random), 0, 2);
            world.setBlock(i + 12, j + 3, k + 9, placeFrontierslateBricks(random), 0, 2);
            world.setBlock(i + 13, j + 3, k + 9, placeFrontierslateBricks(random), 0, 2);
            world.setBlock(i + 14, j + 3, k + 9, placeFrontierslateBricks(random), 0, 2);
            world.setBlock(i + 10, j + 4, k + 10, placeFrontierslateBricks(random), 0, 2);
            world.setBlock(i + 11, j + 4, k + 10, placeFrontierslateBricks(random), 0, 2);
            world.setBlock(i + 12, j + 4, k + 10, placeFrontierslateBricks(random), 0, 2);
            world.setBlock(i + 13, j + 4, k + 10, placeFrontierslateBricks(random), 0, 2);
            world.setBlock(i + 14, j + 4, k + 10, placeFrontierslateBricks(random), 0, 2);
            world.setBlock(i + 10, j + 5, k + 10, placeFrontierslateBricks(random), 0, 2);
            world.setBlock(i + 11, j + 5, k + 10, placeFrontierslateBricks(random), 0, 2);
            world.setBlock(i + 12, j + 5, k + 10, placeFrontierslateBricks(random), 0, 2);
            world.setBlock(i + 13, j + 5, k + 10, placeFrontierslateBricks(random), 0, 2);
            world.setBlock(i + 14, j + 5, k + 10, placeFrontierslateBricks(random), 0, 2);
            world.setBlock(i + 11, j + 6, k + 10, placeFrontierslateBricks(random), 0, 2);
            world.setBlock(i + 13, j + 6, k + 10, placeFrontierslateBricks(random), 0, 2);
        } else {
            world.setBlock(i + 11, j + 6, k + 10, Blocks.air, 0, 2);
            world.setBlock(i + 13, j + 6, k + 10, Blocks.air, 0, 2);
            world.setBlock(i + 21, j + 3, k + 6, Blocks.air, 0, 2);
            world.setBlock(i + 10, j + 3, k + 8, Blocks.air, 0, 2);
            world.setBlock(i + 11, j + 3, k + 8, Blocks.air, 0, 2);
            world.setBlock(i + 12, j + 3, k + 8, Blocks.air, 0, 2);
            world.setBlock(i + 13, j + 3, k + 8, Blocks.air, 0, 2);
            world.setBlock(i + 10, j + 3, k + 9, Blocks.air, 0, 2);
            world.setBlock(i + 11, j + 3, k + 9, Blocks.air, 0, 2);
            world.setBlock(i + 12, j + 3, k + 9, Blocks.air, 0, 2);
            world.setBlock(i + 13, j + 3, k + 9, Blocks.air, 0, 2);
            world.setBlock(i + 14, j + 3, k + 9, Blocks.air, 0, 2);
            world.setBlock(i + 10, j + 4, k + 10, Blocks.air, 0, 2);
            world.setBlock(i + 11, j + 4, k + 10, Blocks.air, 0, 2);
            world.setBlock(i + 12, j + 4, k + 10, Blocks.air, 0, 2);
            world.setBlock(i + 13, j + 4, k + 10, Blocks.air, 0, 2);
            world.setBlock(i + 14, j + 4, k + 10, Blocks.air, 0, 2);
            world.setBlock(i + 10, j + 5, k + 10, Blocks.air, 0, 2);
            world.setBlock(i + 11, j + 5, k + 10, Blocks.air, 0, 2);
            world.setBlock(i + 12, j + 5, k + 10, Blocks.air, 0, 2);
            world.setBlock(i + 13, j + 5, k + 10, Blocks.air, 0, 2);
            world.setBlock(i + 14, j + 5, k + 10, Blocks.air, 0, 2);
            world.setBlock(i + 11, j + 6, k + 10, Blocks.air, 0, 2);
            world.setBlock(i + 13, j + 6, k + 10, Blocks.air, 0, 2);
        }

        if (random.nextBoolean()) {
            world.setBlock(i + 18, j + 8, k + 3, placeFrontierslateBrickStairs(random), 1, 2);
            world.setBlock(i + 19, j + 8, k + 3, placeFrontierslateBrickStairs(random), 2, 2);
            world.setBlock(i + 20, j + 8, k + 4, placeFrontierslateBrickStairs(random), 1, 2);
            world.setBlock(i + 21, j + 8, k + 4, placeFrontierslateBrickStairs(random), 2, 2);
            world.setBlock(i + 18, j + 4, k + 3, placeFrontierslateBricks(random), 0, 2);
            world.setBlock(i + 19, j + 4, k + 3, placeFrontierslateBricks(random), 0, 2);
            world.setBlock(i + 20, j + 4, k + 4, placeFrontierslateBricks(random), 0, 2);
            world.setBlock(i + 21, j + 4, k + 4, placeFrontierslateBricks(random), 0, 2);
            world.setBlock(i + 22, j + 4, k + 5, placeFrontierslateBricks(random), 0, 2);
            world.setBlock(i + 19, j + 5, k + 3, placeFrontierslateBricks(random), 0, 2);
            world.setBlock(i + 20, j + 5, k + 4, placeFrontierslateBricks(random), 0, 2);
            world.setBlock(i + 21, j + 5, k + 4, placeFrontierslateBricks(random), 0, 2);
            world.setBlock(i + 22, j + 5, k + 5, placeFrontierslateBricks(random), 0, 2);
            world.setBlock(i + 19, j + 6, k + 3, placeFrontierslateBricks(random), 0, 2);
            world.setBlock(i + 20, j + 6, k + 4, placeFrontierslateBricks(random), 0, 2);
            world.setBlock(i + 21, j + 6, k + 4, placeFrontierslateBricks(random), 0, 2);
            world.setBlock(i + 22, j + 6, k + 5, placeFrontierslateBricks(random), 0, 2);
            world.setBlock(i + 23, j + 6, k + 6, placeFrontierslateBricks(random), 0, 2);
            world.setBlock(i + 20, j + 7, k + 3, placeFrontierslateBricks(random), 0, 2);
            world.setBlock(i + 18, j + 2, k + 4, placeFrontierslateBricks(random), 0, 2);
            world.setBlock(i + 19, j + 2, k + 5, placeFrontierslateBricks(random), 0, 2);
            world.setBlock(i + 18, j + 3, k + 3, placeFrontierslateBricks(random), 0, 2);
            world.setBlock(i + 19, j + 3, k + 4, placeFrontierslateBricks(random), 0, 2);
            world.setBlock(i + 20, j + 3, k + 4, placeFrontierslateBricks(random), 0, 2);
            world.setBlock(i + 20, j + 3, k + 5, placeFrontierslateBricks(random), 0, 2);
            world.setBlock(i + 21, j + 3, k + 5, placeFrontierslateBricks(random), 0, 2);
            world.setBlock(i + 21, j + 7, k + 4, placeFrontierslateBricks(random), 0, 2);
            world.setBlock(i + 22, j + 7, k + 4, placeFrontierslateBricks(random), 0, 2);
            world.setBlock(i + 23, j + 7, k + 5, placeFrontierslateBricks(random), 0, 2);
            world.setBlock(i + 22, j + 8, k + 4, placeFrontierslateBricks(random), 0, 2);
            world.setBlock(i + 20, j + 8, k + 3, placeFrontierslateBricks(random), 0, 2);
            world.setBlock(i + 23, j + 8, k + 5, placeFrontierslateBricks(random), 0, 2);
            world.setBlock(i + 19, j + 6, k + 3, placeFrontierslateBricks(random), 0, 2);
            world.setBlock(i + 20, j + 6, k + 4, placeFrontierslateBricks(random), 0, 2);
            world.setBlock(i + 21, j + 6, k + 4, placeFrontierslateBricks(random), 0, 2);
            world.setBlock(i + 22, j + 6, k + 5, placeFrontierslateBricks(random), 0, 2);
            world.setBlock(i + 23, j + 6, k + 6, placeFrontierslateBricks(random), 0, 2);
            world.setBlock(i + 20, j + 7, k + 3, placeFrontierslateBricks(random), 0, 2);
            world.setBlock(i + 21, j + 7, k + 4, placeFrontierslateBricks(random), 0, 2);
            world.setBlock(i + 22, j + 7, k + 4, placeFrontierslateBricks(random), 0, 2);
            world.setBlock(i + 23, j + 7, k + 5, placeFrontierslateBricks(random), 0, 2);
        } else {
            world.setBlock(i + 18, j + 8, k + 3, Blocks.air, 0, 2);
            world.setBlock(i + 19, j + 8, k + 3, Blocks.air, 0, 2);
            world.setBlock(i + 20, j + 8, k + 4, Blocks.air, 0, 2);
            world.setBlock(i + 21, j + 8, k + 4, Blocks.air, 0, 2);
            world.setBlock(i + 18, j + 4, k + 3, Blocks.air, 0, 2);
            world.setBlock(i + 19, j + 4, k + 3, Blocks.air, 0, 2);
            world.setBlock(i + 20, j + 4, k + 4, Blocks.air, 0, 2);
            world.setBlock(i + 21, j + 4, k + 4, Blocks.air, 0, 2);
            world.setBlock(i + 22, j + 4, k + 5, Blocks.air, 0, 2);
            world.setBlock(i + 19, j + 5, k + 3, Blocks.air, 0, 2);
            world.setBlock(i + 20, j + 5, k + 4, Blocks.air, 0, 2);
            world.setBlock(i + 21, j + 5, k + 4, Blocks.air, 0, 2);
            world.setBlock(i + 22, j + 5, k + 5, Blocks.air, 0, 2);
            world.setBlock(i + 19, j + 6, k + 3, Blocks.air, 0, 2);
            world.setBlock(i + 20, j + 6, k + 4, Blocks.air, 0, 2);
            world.setBlock(i + 21, j + 6, k + 4, Blocks.air, 0, 2);
            world.setBlock(i + 22, j + 6, k + 5, Blocks.air, 0, 2);
            world.setBlock(i + 23, j + 6, k + 6, Blocks.air, 0, 2);
            world.setBlock(i + 20, j + 7, k + 3, Blocks.air, 0, 2);
            world.setBlock(i + 18, j + 2, k + 4, Blocks.air, 0, 2);
            world.setBlock(i + 19, j + 2, k + 5, Blocks.air, 0, 2);
            world.setBlock(i + 18, j + 3, k + 3, Blocks.air, 0, 2);
            world.setBlock(i + 19, j + 3, k + 4, Blocks.air, 0, 2);
            world.setBlock(i + 20, j + 3, k + 4, Blocks.air, 0, 2);
            world.setBlock(i + 20, j + 3, k + 5, Blocks.air, 0, 2);
            world.setBlock(i + 21, j + 3, k + 5, Blocks.air, 0, 2);
            world.setBlock(i + 21, j + 7, k + 4, Blocks.air, 0, 2);
            world.setBlock(i + 22, j + 7, k + 4, Blocks.air, 0, 2);
            world.setBlock(i + 23, j + 7, k + 5, Blocks.air, 0, 2);
            world.setBlock(i + 22, j + 8, k + 4, Blocks.air, 0, 2);
            world.setBlock(i + 20, j + 8, k + 3, Blocks.air, 0, 2);
            world.setBlock(i + 23, j + 8, k + 5, Blocks.air, 0, 2);
            world.setBlock(i + 19, j + 6, k + 3, Blocks.air, 0, 2);
            world.setBlock(i + 20, j + 6, k + 4, Blocks.air, 0, 2);
            world.setBlock(i + 21, j + 6, k + 4, Blocks.air, 0, 2);
            world.setBlock(i + 22, j + 6, k + 5, Blocks.air, 0, 2);
            world.setBlock(i + 23, j + 6, k + 6, Blocks.air, 0, 2);
            world.setBlock(i + 20, j + 7, k + 3, Blocks.air, 0, 2);
            world.setBlock(i + 21, j + 7, k + 4, Blocks.air, 0, 2);
            world.setBlock(i + 22, j + 7, k + 4, Blocks.air, 0, 2);
            world.setBlock(i + 23, j + 7, k + 5, Blocks.air, 0, 2);
        }

        world.setBlock(i + 10, j + 2, k + 1, Blocks.mob_spawner, 0, 2);
        TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner)world.getTileEntity(i + 10, j + 2, k + 1);

        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a().setEntityName("nova_craft.phantom");
        }

        if (random.nextBoolean()) {
            world.setBlock(i + 19, j + 2, k + 10, Blocks.mob_spawner, 0, 2);
            TileEntityMobSpawner tileentitymobspawner2 = (TileEntityMobSpawner) world.getTileEntity(i + 19, j + 2, k + 10);

            if (tileentitymobspawner2 != null) {
                tileentitymobspawner2.func_145881_a().setEntityName("nova_craft.phantom");
            }
        }

        this.setBlockAndNotifyAdequately(world, i + 8, j + 3, k + 7, Blocks.chest, 2);
        TileEntity tile8 = world.getTileEntity(i + 8, j + 3, k + 7);
        if (tile8 instanceof TileEntityChest) {
            TileEntityChest chest = (TileEntityChest) tile8;

            for (int slot = 0; slot < 3 + random.nextInt(20); slot++) {
                chest.setInventorySlotContents(random.nextInt(chest.getSizeInventory()), this.getOverworldLoot(random));
            }
        }

        this.setBlockAndNotifyAdequately(world, i + 21, j + 4, k + 5, Blocks.chest, 4);
        TileEntity tile9 = world.getTileEntity(i + 21, j + 4, k + 5);
        if (tile9 instanceof TileEntityChest) {
            TileEntityChest chest = (TileEntityChest) tile9;

            for (int slot = 0; slot < 3 + random.nextInt(20); slot++) {
                chest.setInventorySlotContents(random.nextInt(chest.getSizeInventory()), this.getEquipmentLoot(random));
            }
        }

        this.setBlockAndNotifyAdequately(world, i + 3, j + 6, k + 6, Blocks.chest, 5);
        TileEntity tile = world.getTileEntity(i + 3, j + 6, k + 6);
        if (tile instanceof TileEntityChest) {
            TileEntityChest chest = (TileEntityChest) tile;

            for (int slot = 0; slot < 3 + random.nextInt(20); slot++) {
                chest.setInventorySlotContents(random.nextInt(chest.getSizeInventory()), this.getEquipmentLoot(random));
            }
        }

        return true;
    }

    private Block placeLadder(Random random) {
        if (random.nextDouble() < 0.75) {
            return Blocks.ladder;
        } else {
            return Blocks.air;
        }
    }

    private Block placeFontierslatePillar(Random random) {
        if (random.nextDouble() < 0.92) {
            return NovaCraftBlocks.frontierslate_pillar;
        } else {
            return Blocks.air;
        }
    }

    private Block placeFrontierslateBricks(Random random) {
        if (random.nextDouble() < 0.95) {
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

    private Block placeVacuumGlass(Random random) {
        if (random.nextDouble() < 0.88) {
            return NovaCraftBlocks.vacuum_glass;
        } else {
            return Blocks.air;
        }
    }

    private Block placeEndStoneBricks(Random random) {
        if (random.nextDouble() < 0.95) {
            return PlaceEndstoneBricks;
        } else {
            return Blocks.air;
        }
    }

    private Block placeEndRod(Random random) {
        if (random.nextDouble() < 0.95) {
            return PlaceEndRod;
        } else {
            return Blocks.air;
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

    private ItemStack getEquipmentLoot(Random random) {
        int item = random.nextInt(25);
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
                Enchantment[] helmetEnchantments = {Enchantment.protection, Enchantment.unbreaking, Enchantment.respiration};
                Enchantment[] helmetEnchantments2 = {Enchantment.projectileProtection, Enchantment.fireProtection, Enchantment.blastProtection};
                Enchantment enchantment31 = helmetEnchantments[random.nextInt(helmetEnchantments.length)];
                Enchantment enchantment331 = helmetEnchantments2[random.nextInt(helmetEnchantments2.length)];
                int maxLevel31 = enchantment31.getMaxLevel() - 1;
                int maxLevel331 = enchantment331.getMaxLevel() - 1;
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
                int maxLevel41 = enchantment41.getMaxLevel() - 1;

                Enchantment enchantment441 = chestplateEnchantments2[random.nextInt(chestplateEnchantments2.length)];
                int maxLevel441 = enchantment441.getMaxLevel() - 1;

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
                int maxLevel51 = enchantment51.getMaxLevel() - 1;
                int maxLevel551 = enchantment551.getMaxLevel() - 1;
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
                int maxLevel6 = enchantment6.getMaxLevel() - 1;
                int maxLevel66 = enchantment66.getMaxLevel() - 1;
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
                int maxLevel311 = enchantment311.getMaxLevel() - 1;
                int maxLevel3311 = enchantment3311.getMaxLevel() - 1;
                ItemStack itemStack311 = new ItemStack(NovaCraftItems.tophinite_sword);

                itemStack311.addEnchantment(enchantment311, maxLevel311);
                itemStack311.addEnchantment(enchantment3311, maxLevel3311);

                return itemStack311;
            case 15:
                return new ItemStack(NovaCraftItems.prospector_pickaxe, 1);
            default: {
                return new ItemStack(NovaCraftItems.diamond_nugget, random.nextInt(4) + 6, 2);
            }
        }
    }
}
