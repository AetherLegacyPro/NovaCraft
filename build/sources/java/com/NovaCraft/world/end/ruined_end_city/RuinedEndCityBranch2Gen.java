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

public class RuinedEndCityBranch2Gen extends WorldGenerator {

    public RuinedEndCityBranch2Gen() {
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
        PlaceEndstoneBricks = determineIfEndstoneBricksExists(world, i + 5, j + 12, k + 12);
        PlaceEndRod = determineIfEndRodExists(world, i + 5, j + 13, k + 9);

        world.setBlock(i + 6, j + 1, k, placeFrontierslateBrickStairs(random), 4, 2);
        world.setBlock(i + 7, j + 1, k, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 1, k, placeFrontierslateBrickStairs(random), 5, 2);
        world.setBlock(i + 5, j + 2, k, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 2, k, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 7, j + 2, k, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 8, j + 2, k, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 9, j + 2, k, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 2, k + 1, placeFrontierslateBrickStairs(random), 4, 2);
        world.setBlock(i + 7, j + 2, k + 1, placeFontierslatePillar(random), 8, 2);
        world.setBlock(i + 8, j + 2, k + 1, placeFrontierslateBrickStairs(random), 5, 2);
        world.setBlock(i + 7, j + 2, k + 2, placeFontierslatePillar(random), 8, 2);
        world.setBlock(i + 5, j + 3, k, placeFrontierslateBrickStairs(random), 0, 2);
        world.setBlock(i + 6, j + 3, k, Block.getBlockById(1), 0, 2);
        world.setBlock(i + 7, j + 3, k, Block.getBlockById(1), 0, 2);
        world.setBlock(i + 8, j + 3, k, Block.getBlockById(1), 0, 2);
        world.setBlock(i + 9, j + 3, k, placeFrontierslateBrickStairs(random), 1, 2);
        world.setBlock(i + 5, j + 3, k + 1, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 3, k + 1, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 7, j + 3, k + 1, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 8, j + 3, k + 1, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 9, j + 3, k + 1, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 3, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 3, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 3, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 4, k, Block.getBlockById(1), 0, 2);
        world.setBlock(i + 7, j + 4, k, Block.getBlockById(1), 0, 2);
        world.setBlock(i + 8, j + 4, k, Block.getBlockById(1), 0, 2);
        world.setBlock(i + 5, j + 4, k + 1, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 4, k + 1, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 4, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 4, k + 2, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 7, j + 4, k + 2, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 8, j + 4, k + 2, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 9, j + 4, k + 2, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 4, k + 3, placeFrontierslateBrickStairs(random), 4, 2);
        world.setBlock(i + 7, j + 4, k + 3, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 4, k + 3, placeFrontierslateBrickStairs(random), 5, 2);
        world.setBlock(i + 5, j + 5, k + 2, placeFrontierslateBrickStairs(random), 0, 2);
        world.setBlock(i + 9, j + 5, k + 2, placeFrontierslateBrickStairs(random), 1, 2);
        world.setBlock(i + 5, j + 5, k + 3, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 5, k + 3, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 7, j + 5, k + 3, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 8, j + 5, k + 3, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 9, j + 5, k + 3, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 5, k + 4, placeFrontierslateBrickStairs(random), 4, 2);
        world.setBlock(i + 7, j + 5, k + 4, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 5, k + 4, placeFrontierslateBrickStairs(random), 5, 2);
        world.setBlock(i + 5, j + 6, k + 3, placeFrontierslateBrickStairs(random), 0, 2);
        world.setBlock(i + 9, j + 6, k + 3, placeFrontierslateBrickStairs(random), 1, 2);
        world.setBlock(i + 5, j + 6, k + 4, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 6, k + 4, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 7, j + 6, k + 4, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 8, j + 6, k + 4, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 9, j + 6, k + 4, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 6, k + 5, placeFrontierslateBrickStairs(random), 4, 2);
        world.setBlock(i + 7, j + 6, k + 5, placeFontierslatePillar(random), 8, 2);
        world.setBlock(i + 8, j + 6, k + 5, placeFrontierslateBrickStairs(random), 5, 2);
        world.setBlock(i + 7, j + 6, k + 6, placeFontierslatePillar(random), 8, 2);
        world.setBlock(i + 5, j + 7, k + 4, placeFrontierslateBrickStairs(random), 0, 2);
        world.setBlock(i + 9, j + 7, k + 4, placeFrontierslateBrickStairs(random), 1, 2);
        world.setBlock(i + 5, j + 7, k + 5, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 7, k + 5, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 7, j + 7, k + 5, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 8, j + 7, k + 5, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 9, j + 7, k + 5, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 7, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 7, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 7, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 8, k + 5, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 8, k + 5, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 8, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 8, k + 6, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 7, j + 8, k + 6, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 8, j + 8, k + 6, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 9, j + 8, k + 6, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 8, k + 7, placeFrontierslateBrickStairs(random), 4, 2);
        world.setBlock(i + 7, j + 8, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 8, k + 7, placeFrontierslateBrickStairs(random), 5, 2);
        world.setBlock(i + 5, j + 9, k + 6, placeFrontierslateBrickStairs(random), 0, 2);
        world.setBlock(i + 9, j + 9, k + 6, placeFrontierslateBrickStairs(random), 1, 2);
        world.setBlock(i + 5, j + 9, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 9, k + 7, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 7, j + 9, k + 7, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 8, j + 9, k + 7, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 9, j + 9, k + 7, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 9, k + 8, placeFrontierslateBrickStairs(random), 4, 2);
        world.setBlock(i + 7, j + 9, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 9, k + 8, placeFrontierslateBrickStairs(random), 5, 2);
        world.setBlock(i + 5, j + 10, k + 7, placeFrontierslateBrickStairs(random), 0, 2);
        world.setBlock(i + 9, j + 10, k + 7, placeFrontierslateBrickStairs(random), 1, 2);
        world.setBlock(i + 5, j + 10, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 10, k + 8, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 7, j + 10, k + 8, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 8, j + 10, k + 8, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 9, j + 10, k + 8, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 10, k + 9, placeFontierslatePillar(random), 8, 2);
        world.setBlock(i + 6, j + 10, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 10, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 10, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 11, k + 8, placeFrontierslateBrickStairs(random), 0, 2);
        world.setBlock(i + 9, j + 11, k + 8, placeFrontierslateBrickStairs(random), 1, 2);
        world.setBlock(i + 5, j + 11, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 11, k + 9, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 7, j + 11, k + 9, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 8, j + 11, k + 9, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 9, j + 11, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 11, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 11, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 11, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 11, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 11, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 11, k + 11, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 6, j + 11, k + 11, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 11, k + 11, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 11, k + 11, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 11, k + 11, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 11, k + 11, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 4, j + 11, k + 12, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 11, k + 12, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 11, k + 12, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 11, k + 12, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 11, k + 12, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 11, k + 12, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 11, k + 12, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 11, k + 12, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 11, k + 13, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 11, k + 13, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 11, k + 13, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 11, k + 13, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 11, k + 13, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 11, k + 13, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 11, k + 13, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 11, k + 13, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 11, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 11, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 11, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 11, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 11, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 11, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 11, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 11, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 11, k + 15, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 11, k + 15, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 11, k + 15, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 11, k + 15, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 11, k + 15, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 11, k + 15, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 11, k + 15, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 11, k + 15, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 11, k + 16, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 11, k + 16, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 11, k + 16, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 11, k + 16, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 11, k + 16, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 11, k + 16, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 11, k + 16, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 11, k + 16, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 11, k + 17, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 11, k + 17, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 11, k + 17, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 11, k + 17, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 11, k + 17, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 11, k + 17, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 11, k + 17, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 11, k + 17, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 11, k + 18, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 11, k + 18, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 11, k + 18, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 11, k + 18, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 11, k + 18, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 11, k + 18, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 11, k + 18, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 11, k + 18, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 11, k + 19, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 11, k + 19, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 11, k + 19, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 11, k + 19, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 11, k + 19, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 11, k + 19, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 11, k + 19, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 11, k + 19, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 12, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 12, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 12, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 12, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 12, k + 12, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 5, j + 12, k + 12, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 6, j + 12, k + 12, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 9, j + 12, k + 12, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 10, j + 12, k + 12, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 11, j + 12, k + 12, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 4, j + 12, k + 13, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 11, j + 12, k + 13, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 4, j + 12, k + 14, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 7, j + 12, k + 14, placeFrontierslateBrickSlab(random), 0, 2);
        world.setBlock(i + 11, j + 12, k + 14, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 4, j + 12, k + 15, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 7, j + 12, k + 15, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 8, j + 12, k + 15, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 12, k + 15, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 4, j + 12, k + 16, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 7, j + 12, k + 16, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 12, k + 16, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 12, k + 16, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 4, j + 12, k + 17, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 11, j + 12, k + 17, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 4, j + 12, k + 18, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 11, j + 12, k + 18, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 4, j + 12, k + 19, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 5, j + 12, k + 19, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 6, j + 12, k + 19, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 7, j + 12, k + 19, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j + 12, k + 19, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 9, j + 12, k + 19, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 10, j + 12, k + 19, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 11, j + 12, k + 19, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 5, j + 13, k + 9, PlaceEndRod, 1, 2);
        world.setBlock(i + 9, j + 13, k + 9, PlaceEndRod, 1, 2);
        world.setBlock(i + 5, j + 13, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 13, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 13, k + 12, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 5, j + 13, k + 12, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 6, j + 13, k + 12, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 9, j + 13, k + 12, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 10, j + 13, k + 12, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 11, j + 13, k + 12, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 4, j + 13, k + 13, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 11, j + 13, k + 13, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 4, j + 13, k + 14, placeVacuumGlass(random), 0, 2);
        world.setBlock(i + 11, j + 13, k + 14, placeVacuumGlass(random), 0, 2);
        world.setBlock(i + 4, j + 13, k + 15, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j + 13, k + 15, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 13, k + 15, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 4, j + 13, k + 16, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 6, j + 13, k + 16, placeFrontierslateBrickSlab(random), 0, 2);
        world.setBlock(i + 7, j + 13, k + 16, placeFrontierslateBrickStairs(random), 0, 2);
        world.setBlock(i + 8, j + 13, k + 16, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 13, k + 16, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 4, j + 13, k + 17, placeVacuumGlass(random), 0, 2);
        world.setBlock(i + 11, j + 13, k + 17, placeVacuumGlass(random), 0, 2);
        world.setBlock(i + 4, j + 13, k + 18, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 11, j + 13, k + 18, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 4, j + 13, k + 19, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 5, j + 13, k + 19, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 6, j + 13, k + 19, placeVacuumGlass(random), 0, 2);
        world.setBlock(i + 7, j + 13, k + 19, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j + 13, k + 19, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 9, j + 13, k + 19, placeVacuumGlass(random), 0, 2);
        world.setBlock(i + 10, j + 13, k + 19, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 11, j + 13, k + 19, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 5, j + 14, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 14, k + 10, placeFrontierslateBrickSlab(random), 8, 2);
        world.setBlock(i + 8, j + 14, k + 10, placeFrontierslateBrickSlab(random), 8, 2);
        world.setBlock(i + 9, j + 14, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 14, k + 12, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 5, j + 14, k + 12, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 6, j + 14, k + 12, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 9, j + 14, k + 12, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 10, j + 14, k + 12, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 11, j + 14, k + 12, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 4, j + 14, k + 13, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 11, j + 14, k + 13, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 4, j + 14, k + 14, placeVacuumGlass(random), 0, 2);
        world.setBlock(i + 11, j + 14, k + 14, placeVacuumGlass(random), 0, 2);
        world.setBlock(i + 4, j + 14, k + 15, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j + 14, k + 15, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 14, k + 15, placeFrontierslateBrickSlab(random), 8, 2);
        world.setBlock(i + 11, j + 14, k + 15, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 4, j + 14, k + 16, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j + 14, k + 16, placeFrontierslateBrickStairs(random), 3, 2);
        world.setBlock(i + 11, j + 14, k + 16, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 4, j + 14, k + 17, placeVacuumGlass(random), 0, 2);
        world.setBlock(i + 8, j + 14, k + 17, placeFrontierslateBrickSlab(random), 0, 2);
        world.setBlock(i + 11, j + 14, k + 17, placeVacuumGlass(random), 0, 2);
        world.setBlock(i + 4, j + 14, k + 18, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 11, j + 14, k + 18, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 4, j + 14, k + 19, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 5, j + 14, k + 19, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 6, j + 14, k + 19, placeVacuumGlass(random), 0, 2);
        world.setBlock(i + 7, j + 14, k + 19, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j + 14, k + 19, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 9, j + 14, k + 19, placeVacuumGlass(random), 0, 2);
        world.setBlock(i + 10, j + 14, k + 19, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 11, j + 14, k + 19, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 2, j + 15, k + 10, placeFrontierslateBrickStairs(random), 4, 2);
        world.setBlock(i + 3, j + 15, k + 10, placeFrontierslateBrickStairs(random), 6, 2);
        world.setBlock(i + 4, j + 15, k + 10, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 5, j + 15, k + 10, placeFrontierslateBrickSlab(random), 0, 2);
        world.setBlock(i + 6, j + 15, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 15, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 15, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 15, k + 10, placeFrontierslateBrickSlab(random), 0, 2);
        world.setBlock(i + 10, j + 15, k + 10, placeFrontierslateBrickStairs(random), 6, 2);
        world.setBlock(i + 11, j + 15, k + 10, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 12, j + 15, k + 10, placeFrontierslateBrickStairs(random), 6, 2);
        world.setBlock(i + 13, j + 15, k + 10, placeFrontierslateBrickStairs(random), 6, 2);
        world.setBlock(i + 2, j + 15, k + 11, placeFrontierslateBrickStairs(random), 4, 2);
        world.setBlock(i + 3, j + 15, k + 11, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 15, k + 11, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 15, k + 11, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 15, k + 11, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 15, k + 11, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 15, k + 11, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 15, k + 11, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 15, k + 11, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 15, k + 11, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 15, k + 11, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 15, k + 11, placeFrontierslateBrickStairs(random), 5, 2);
        world.setBlock(i + 2, j + 15, k + 12, placeFrontierslateBrickStairs(random), 0, 2);
        world.setBlock(i + 3, j + 15, k + 12, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 15, k + 12, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 15, k + 12, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 15, k + 12, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 15, k + 12, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 15, k + 12, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 15, k + 12, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 15, k + 12, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 15, k + 12, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 15, k + 12, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 15, k + 12, placeFrontierslateBrickStairs(random), 1, 2);
        world.setBlock(i + 2, j + 15, k + 13, placeFrontierslateBrickStairs(random), 4, 2);
        world.setBlock(i + 3, j + 15, k + 13, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 15, k + 13, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 15, k + 13, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 15, k + 13, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 15, k + 13, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 15, k + 13, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 15, k + 13, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 15, k + 13, placeFrontierslateBrickStairs(random), 5, 2);
        world.setBlock(i + 2, j + 15, k + 14, placeFrontierslateBrickStairs(random), 4, 2);
        world.setBlock(i + 3, j + 15, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 15, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 15, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 15, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 15, k + 14, placeFrontierslateBrickStairs(random), 5, 2);
        world.setBlock(i + 2, j + 15, k + 15, placeFrontierslateBrickStairs(random), 0, 2);
        world.setBlock(i + 3, j + 15, k + 15, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 15, k + 15, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 15, k + 15, placeFrontierslateBrickSlab(random), 8, 2);
        world.setBlock(i + 6, j + 15, k + 15, placeFrontierslateBrickSlab(random), 8, 2);
        world.setBlock(i + 7, j + 15, k + 15, placeFrontierslateBrickSlab(random), 8, 2);
        world.setBlock(i + 8, j + 15, k + 15, placeFrontierslateBrickStairs(random), 1, 2);
        world.setBlock(i + 11, j + 15, k + 15, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 15, k + 15, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 15, k + 15, placeFrontierslateBrickStairs(random), 1, 2);
        world.setBlock(i + 2, j + 15, k + 16, placeFrontierslateBrickStairs(random), 0, 2);
        world.setBlock(i + 3, j + 15, k + 16, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 15, k + 16, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 15, k + 16, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 15, k + 16, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 15, k + 16, placeFrontierslateBrickStairs(random), 1, 2);
        world.setBlock(i + 2, j + 15, k + 17, placeFrontierslateBrickStairs(random), 4, 2);
        world.setBlock(i + 3, j + 15, k + 17, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 15, k + 17, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 15, k + 17, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 15, k + 17, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 15, k + 17, placeFrontierslateBrickStairs(random), 5, 2);
        world.setBlock(i + 2, j + 15, k + 18, placeFrontierslateBrickStairs(random), 4, 2);
        world.setBlock(i + 3, j + 15, k + 18, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 15, k + 18, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 15, k + 18, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 15, k + 18, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 15, k + 18, placeFrontierslateBrickStairs(random), 5, 2);
        world.setBlock(i + 2, j + 15, k + 19, placeFrontierslateBrickStairs(random), 0, 2);
        world.setBlock(i + 3, j + 15, k + 19, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 15, k + 19, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 15, k + 19, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 15, k + 19, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 15, k + 19, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 15, k + 19, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 15, k + 19, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 15, k + 19, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 15, k + 19, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 15, k + 19, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 15, k + 19, placeFrontierslateBrickStairs(random), 1, 2);
        world.setBlock(i + 2, j + 15, k + 20, placeFrontierslateBrickStairs(random), 4, 2);
        world.setBlock(i + 3, j + 15, k + 20, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 15, k + 20, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 15, k + 20, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 15, k + 20, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 15, k + 20, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 15, k + 20, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 15, k + 20, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 15, k + 20, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 15, k + 20, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 15, k + 20, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 15, k + 20, placeFrontierslateBrickStairs(random), 5, 2);
        world.setBlock(i + 2, j + 15, k + 21, placeFrontierslateBrickStairs(random), 7, 2);
        world.setBlock(i + 3, j + 15, k + 21, placeFrontierslateBrickStairs(random), 7, 2);
        world.setBlock(i + 4, j + 15, k + 21, placeFrontierslateBrickStairs(random), 3, 2);
        world.setBlock(i + 5, j + 15, k + 21, placeFrontierslateBrickStairs(random), 7, 2);
        world.setBlock(i + 6, j + 15, k + 21, placeFrontierslateBrickStairs(random), 7, 2);
        world.setBlock(i + 7, j + 15, k + 21, placeFrontierslateBrickStairs(random), 3, 2);
        world.setBlock(i + 8, j + 15, k + 21, placeFrontierslateBrickStairs(random), 3, 2);
        world.setBlock(i + 9, j + 15, k + 21, placeFrontierslateBrickStairs(random), 7, 2);
        world.setBlock(i + 10, j + 15, k + 21, placeFrontierslateBrickStairs(random), 7, 2);
        world.setBlock(i + 11, j + 15, k + 21, placeFrontierslateBrickStairs(random), 3, 2);
        world.setBlock(i + 12, j + 15, k + 21, placeFrontierslateBrickStairs(random), 7, 2);
        world.setBlock(i + 13, j + 15, k + 21, placeFrontierslateBrickStairs(random), 5, 2);
        world.setBlock(i + 2, j + 16, k + 10, PlaceEndRod, 1, 2);
        world.setBlock(i + 13, j + 16, k + 10, PlaceEndRod, 1, 2);
        world.setBlock(i + 3, j + 16, k + 11, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 4, j + 16, k + 11, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 5, j + 16, k + 11, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 6, j + 16, k + 11, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 7, j + 16, k + 11, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j + 16, k + 11, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 9, j + 16, k + 11, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 10, j + 16, k + 11, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 11, j + 16, k + 11, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 12, j + 16, k + 11, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 3, j + 16, k + 12, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 5, j + 16, k + 12, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 16, k + 12, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 16, k + 12, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 16, k + 12, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 16, k + 12, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 16, k + 13, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 4, j + 16, k + 13, placeFrontierslateBrickStairs(random), 5, 2);
        world.setBlock(i + 8, j + 16, k + 13, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 16, k + 13, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 16, k + 13, placeFrontierslateBrickStairs(random), 1, 2);
        world.setBlock(i + 12, j + 16, k + 13, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 16, k + 14, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 4, j + 16, k + 14, placeFrontierslateBrickStairs(random), 5, 2);
        world.setBlock(i + 12, j + 16, k + 14, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 16, k + 15, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 12, j + 16, k + 15, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 16, k + 16, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 12, j + 16, k + 16, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 16, k + 17, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 12, j + 16, k + 17, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 16, k + 18, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 12, j + 16, k + 18, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 16, k + 19, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 12, j + 16, k + 19, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 16, k + 20, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 4, j + 16, k + 20, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 5, j + 16, k + 20, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 6, j + 16, k + 20, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 7, j + 16, k + 20, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j + 16, k + 20, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 9, j + 16, k + 20, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 10, j + 16, k + 20, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 11, j + 16, k + 20, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 12, j + 16, k + 20, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 2, j + 16, k + 21, PlaceEndRod, 1, 2);
        world.setBlock(i + 13, j + 16, k + 21, PlaceEndRod, 1, 2);
        world.setBlock(i + 3, j + 17, k + 11, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 4, j + 17, k + 11, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 5, j + 17, k + 11, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 6, j + 17, k + 11, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 7, j + 17, k + 11, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j + 17, k + 11, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 9, j + 17, k + 11, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 10, j + 17, k + 11, placeVacuumGlass(random), 0, 2);
        world.setBlock(i + 11, j + 17, k + 11, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 12, j + 17, k + 11, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 3, j + 17, k + 12, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 5, j + 17, k + 12, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 17, k + 12, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 17, k + 12, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 17, k + 12, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 17, k + 12, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 17, k + 13, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 4, j + 17, k + 13, placeFrontierslateBrickStairs(random), 1, 2);
        world.setBlock(i + 8, j + 17, k + 13, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 17, k + 13, placeFrontierslateBrickStairs(random), 1, 2);
        world.setBlock(i + 12, j + 17, k + 13, placeVacuumGlass(random), 0, 2);
        world.setBlock(i + 3, j + 17, k + 14, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 4, j + 17, k + 14, placeFrontierslateBrickStairs(random), 1, 2);
        world.setBlock(i + 12, j + 17, k + 14, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 17, k + 15, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 12, j + 17, k + 15, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 17, k + 16, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 12, j + 17, k + 16, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 17, k + 17, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 12, j + 17, k + 17, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 17, k + 18, placeVacuumGlass(random), 0, 2);
        world.setBlock(i + 12, j + 17, k + 18, placeVacuumGlass(random), 0, 2);
        world.setBlock(i + 3, j + 17, k + 19, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 12, j + 17, k + 19, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 17, k + 20, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 4, j + 17, k + 20, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 5, j + 17, k + 20, placeVacuumGlass(random), 0, 2);
        world.setBlock(i + 6, j + 17, k + 20, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 7, j + 17, k + 20, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j + 17, k + 20, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 9, j + 17, k + 20, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 10, j + 17, k + 20, placeVacuumGlass(random), 0, 2);
        world.setBlock(i + 11, j + 17, k + 20, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 12, j + 17, k + 20, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 3, j + 18, k + 11, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 4, j + 18, k + 11, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 5, j + 18, k + 11, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 6, j + 18, k + 11, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 7, j + 18, k + 11, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j + 18, k + 11, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 9, j + 18, k + 11, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 10, j + 18, k + 11, placeVacuumGlass(random), 0, 2);
        world.setBlock(i + 11, j + 18, k + 11, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 12, j + 18, k + 11, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 3, j + 18, k + 12, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 5, j + 18, k + 12, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 18, k + 12, placeFrontierslateBrickStairs(random), 1, 2);
        world.setBlock(i + 12, j + 18, k + 12, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 18, k + 13, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 4, j + 18, k + 13, placeFrontierslateBrickStairs(random), 5, 2);
        world.setBlock(i + 5, j + 18, k + 13, placeFrontierslateBrickSlab(random), 8, 2);
        world.setBlock(i + 12, j + 18, k + 13, placeVacuumGlass(random), 0, 2);
        world.setBlock(i + 3, j + 18, k + 14, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 4, j + 18, k + 14, placeFrontierslateBrickStairs(random), 5, 2);
        world.setBlock(i + 5, j + 18, k + 14, placeFrontierslateBrickSlab(random), 8, 2);
        world.setBlock(i + 12, j + 18, k + 14, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 18, k + 15, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 12, j + 18, k + 15, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 18, k + 16, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 12, j + 18, k + 16, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 18, k + 17, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 12, j + 18, k + 17, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 18, k + 18, placeVacuumGlass(random), 0, 2);
        world.setBlock(i + 12, j + 18, k + 18, placeVacuumGlass(random), 0, 2);
        world.setBlock(i + 3, j + 18, k + 19, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 12, j + 18, k + 19, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 18, k + 20, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 4, j + 18, k + 20, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 5, j + 18, k + 20, placeVacuumGlass(random), 0, 2);
        world.setBlock(i + 6, j + 18, k + 20, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 7, j + 18, k + 20, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j + 18, k + 20, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 9, j + 18, k + 20, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 10, j + 18, k + 20, placeVacuumGlass(random), 0, 2);
        world.setBlock(i + 11, j + 18, k + 20, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 12, j + 18, k + 20, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 1, j + 19, k + 9, placeFrontierslateBrickStairs(random), 4, 2);
        world.setBlock(i + 2, j + 19, k + 9, placeFrontierslateBrickStairs(random), 6, 2);
        world.setBlock(i + 3, j + 19, k + 9, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 4, j + 19, k + 9, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 5, j + 19, k + 9, placeFrontierslateBrickStairs(random), 6, 2);
        world.setBlock(i + 6, j + 19, k + 9, placeFrontierslateBrickStairs(random), 6, 2);
        world.setBlock(i + 7, j + 19, k + 9, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 8, j + 19, k + 9, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 9, j + 19, k + 9, placeFrontierslateBrickStairs(random), 6, 2);
        world.setBlock(i + 10, j + 19, k + 9, placeFrontierslateBrickStairs(random), 6, 2);
        world.setBlock(i + 11, j + 19, k + 9, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 12, j + 19, k + 9, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 13, j + 19, k + 9, placeFrontierslateBrickStairs(random), 6, 2);
        world.setBlock(i + 14, j + 19, k + 9, placeFrontierslateBrickStairs(random), 6, 2);
        world.setBlock(i + 1, j + 19, k + 10, placeFrontierslateBrickStairs(random), 4, 2);
        world.setBlock(i + 2, j + 19, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 3, j + 19, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 19, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 19, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 19, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 19, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 19, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 19, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 19, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 19, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 19, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 19, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 14, j + 19, k + 10, placeFrontierslateBrickStairs(random), 5, 2);
        world.setBlock(i + 1, j + 19, k + 11, placeFrontierslateBrickStairs(random), 0, 2);
        world.setBlock(i + 2, j + 19, k + 11, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 3, j + 19, k + 11, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 19, k + 11, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 19, k + 11, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 19, k + 11, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 19, k + 11, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 19, k + 11, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 19, k + 11, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 19, k + 11, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 19, k + 11, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 19, k + 11, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 19, k + 11, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 14, j + 19, k + 11, placeFrontierslateBrickStairs(random), 1, 2);
        world.setBlock(i + 1, j + 19, k + 12, placeFrontierslateBrickStairs(random), 0, 2);
        world.setBlock(i + 2, j + 19, k + 12, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 3, j + 19, k + 12, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 19, k + 12, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 19, k + 12, placeFrontierslateBrickStairs(random), 1, 2);
        world.setBlock(i + 12, j + 19, k + 12, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 19, k + 12, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 14, j + 19, k + 12, placeFrontierslateBrickStairs(random), 1, 2);
        world.setBlock(i + 1, j + 19, k + 13, placeFrontierslateBrickStairs(random), 4, 2);
        world.setBlock(i + 2, j + 19, k + 13, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 3, j + 19, k + 13, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 19, k + 13, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 19, k + 13, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 14, j + 19, k + 13, placeFrontierslateBrickStairs(random), 5, 2);
        world.setBlock(i + 1, j + 19, k + 14, placeFrontierslateBrickStairs(random), 4, 2);
        world.setBlock(i + 2, j + 19, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 3, j + 19, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 19, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 19, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 19, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 19, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 19, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 19, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 14, j + 19, k + 14, placeFrontierslateBrickStairs(random), 5, 2);
        world.setBlock(i + 1, j + 19, k + 15, placeFrontierslateBrickStairs(random), 0, 2);
        world.setBlock(i + 2, j + 19, k + 15, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 3, j + 19, k + 15, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 19, k + 15, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 19, k + 15, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 14, j + 19, k + 15, placeFrontierslateBrickStairs(random), 1, 2);
        world.setBlock(i + 1, j + 19, k + 16, placeFrontierslateBrickStairs(random), 0, 2);
        world.setBlock(i + 2, j + 19, k + 16, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 3, j + 19, k + 16, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 19, k + 16, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 19, k + 16, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 14, j + 19, k + 16, placeFrontierslateBrickStairs(random), 1, 2);
        world.setBlock(i + 1, j + 19, k + 17, placeFrontierslateBrickStairs(random), 4, 2);
        world.setBlock(i + 2, j + 19, k + 17, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 3, j + 19, k + 17, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 19, k + 17, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 19, k + 17, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 14, j + 19, k + 17, placeFrontierslateBrickStairs(random), 5, 2);
        world.setBlock(i + 1, j + 19, k + 18, placeFrontierslateBrickStairs(random), 4, 2);
        world.setBlock(i + 2, j + 19, k + 18, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 3, j + 19, k + 18, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 19, k + 18, PlaceEndRod, 2, 2);
        world.setBlock(i + 8, j + 19, k + 18, PlaceEndRod, 2, 2);
        world.setBlock(i + 12, j + 19, k + 18, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 19, k + 18, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 14, j + 19, k + 18, placeFrontierslateBrickStairs(random), 5, 2);
        world.setBlock(i + 1, j + 19, k + 19, placeFrontierslateBrickStairs(random), 0, 2);
        world.setBlock(i + 2, j + 19, k + 19, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 3, j + 19, k + 19, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 19, k + 19, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 19, k + 19, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 19, k + 19, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 19, k + 19, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 14, j + 19, k + 19, placeFrontierslateBrickStairs(random), 1, 2);
        world.setBlock(i + 1, j + 19, k + 20, placeFrontierslateBrickStairs(random), 0, 2);
        world.setBlock(i + 2, j + 19, k + 20, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 3, j + 19, k + 20, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 19, k + 20, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 19, k + 20, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 19, k + 20, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 19, k + 20, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 19, k + 20, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 19, k + 20, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 19, k + 20, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 19, k + 20, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 19, k + 20, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 19, k + 20, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 14, j + 19, k + 20, placeFrontierslateBrickStairs(random), 1, 2);
        world.setBlock(i + 1, j + 19, k + 21, placeFrontierslateBrickStairs(random), 4, 2);
        world.setBlock(i + 2, j + 19, k + 21, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 3, j + 19, k + 21, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 19, k + 21, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 19, k + 21, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 19, k + 21, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 19, k + 21, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 19, k + 21, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 19, k + 21, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 19, k + 21, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 19, k + 21, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 19, k + 21, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 19, k + 21, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 14, j + 19, k + 21, placeFrontierslateBrickStairs(random), 5, 2);
        world.setBlock(i + 1, j + 19, k + 22, placeFrontierslateBrickStairs(random), 7, 2);
        world.setBlock(i + 2, j + 19, k + 22, placeFrontierslateBrickStairs(random), 7, 2);
        world.setBlock(i + 3, j + 19, k + 22, placeFrontierslateBrickStairs(random), 3, 2);
        world.setBlock(i + 4, j + 19, k + 22, placeFrontierslateBrickStairs(random), 3, 2);
        world.setBlock(i + 5, j + 19, k + 22, placeFrontierslateBrickStairs(random), 7, 2);
        world.setBlock(i + 6, j + 19, k + 22, placeFrontierslateBrickStairs(random), 7, 2);
        world.setBlock(i + 7, j + 19, k + 22, placeFrontierslateBrickStairs(random), 3, 2);
        world.setBlock(i + 8, j + 19, k + 22, placeFrontierslateBrickStairs(random), 3, 2);
        world.setBlock(i + 9, j + 19, k + 22, placeFrontierslateBrickStairs(random), 7, 2);
        world.setBlock(i + 10, j + 19, k + 22, placeFrontierslateBrickStairs(random), 7, 2);
        world.setBlock(i + 11, j + 19, k + 22, placeFrontierslateBrickStairs(random), 3, 2);
        world.setBlock(i + 12, j + 19, k + 22, placeFrontierslateBrickStairs(random), 3, 2);
        world.setBlock(i + 13, j + 19, k + 22, placeFrontierslateBrickStairs(random), 7, 2);
        world.setBlock(i + 14, j + 19, k + 22, placeFrontierslateBrickStairs(random), 5, 2);
        world.setBlock(i + 1, j + 20, k + 9, PlaceEndRod, 1, 2);
        world.setBlock(i + 14, j + 20, k + 9, PlaceEndRod, 1, 2);
        world.setBlock(i + 2, j + 20, k + 10, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 3, j + 20, k + 10, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 4, j + 20, k + 10, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 5, j + 20, k + 10, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 6, j + 20, k + 10, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 7, j + 20, k + 10, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j + 20, k + 10, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 9, j + 20, k + 10, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 10, j + 20, k + 10, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 11, j + 20, k + 10, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 12, j + 20, k + 10, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 13, j + 20, k + 10, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 2, j + 20, k + 11, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 13, j + 20, k + 11, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 2, j + 20, k + 12, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 20, k + 12, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 20, k + 12, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 20, k + 12, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 2, j + 20, k + 13, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 13, j + 20, k + 13, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 2, j + 20, k + 14, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 20, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 20, k + 14, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 13, j + 20, k + 14, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 2, j + 20, k + 15, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 9, j + 20, k + 15, Blocks.ladder, 3, 2);
        world.setBlock(i + 13, j + 20, k + 15, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 2, j + 20, k + 16, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 20, k + 16, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 20, k + 16, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 2, j + 20, k + 17, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 13, j + 20, k + 17, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 2, j + 20, k + 18, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 13, j + 20, k + 18, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 2, j + 20, k + 19, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 13, j + 20, k + 19, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 2, j + 20, k + 20, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 13, j + 20, k + 20, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 2, j + 20, k + 21, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 3, j + 20, k + 21, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 4, j + 20, k + 21, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 5, j + 20, k + 21, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 6, j + 20, k + 21, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 7, j + 20, k + 21, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j + 20, k + 21, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 9, j + 20, k + 21, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 10, j + 20, k + 21, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 11, j + 20, k + 21, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 12, j + 20, k + 21, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 13, j + 20, k + 21, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 1, j + 20, k + 22, PlaceEndRod, 1, 2);
        world.setBlock(i + 14, j + 20, k + 22, PlaceEndRod, 1, 2);
        world.setBlock(i + 2, j + 21, k + 10, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 3, j + 21, k + 10, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 4, j + 21, k + 10, placeVacuumGlass(random), 0, 2);
        world.setBlock(i + 5, j + 21, k + 10, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 6, j + 21, k + 10, placeVacuumGlass(random), 0, 2);
        world.setBlock(i + 7, j + 21, k + 10, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j + 21, k + 10, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 9, j + 21, k + 10, placeVacuumGlass(random), 0, 2);
        world.setBlock(i + 10, j + 21, k + 10, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 11, j + 21, k + 10, placeVacuumGlass(random), 0, 2);
        world.setBlock(i + 12, j + 21, k + 10, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 13, j + 21, k + 10, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 2, j + 21, k + 11, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 13, j + 21, k + 11, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 2, j + 21, k + 12, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 21, k + 12, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 21, k + 12, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 21, k + 12, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 2, j + 21, k + 13, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 13, j + 21, k + 13, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 2, j + 21, k + 14, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 21, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 21, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 21, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 21, k + 14, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 13, j + 21, k + 14, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 2, j + 21, k + 15, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 9, j + 21, k + 15, Blocks.ladder, 3, 2);
        world.setBlock(i + 13, j + 21, k + 15, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 2, j + 21, k + 16, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 21, k + 16, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 21, k + 16, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 2, j + 21, k + 17, placeVacuumGlass(random), 0, 2);
        world.setBlock(i + 13, j + 21, k + 17, placeVacuumGlass(random), 0, 2);
        world.setBlock(i + 2, j + 21, k + 18, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 13, j + 21, k + 18, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 2, j + 21, k + 19, placeVacuumGlass(random), 0, 2);
        world.setBlock(i + 13, j + 21, k + 19, placeVacuumGlass(random), 0, 2);
        world.setBlock(i + 2, j + 21, k + 20, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 13, j + 21, k + 20, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 2, j + 21, k + 21, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 3, j + 21, k + 21, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 4, j + 21, k + 21, placeVacuumGlass(random), 0, 2);
        world.setBlock(i + 5, j + 21, k + 21, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 6, j + 21, k + 21, placeVacuumGlass(random), 0, 2);
        world.setBlock(i + 7, j + 21, k + 21, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j + 21, k + 21, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 9, j + 21, k + 21, placeVacuumGlass(random), 0, 2);
        world.setBlock(i + 10, j + 21, k + 21, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 11, j + 21, k + 21, placeVacuumGlass(random), 0, 2);
        world.setBlock(i + 12, j + 21, k + 21, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 13, j + 21, k + 21, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 2, j + 22, k + 10, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 3, j + 22, k + 10, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 4, j + 22, k + 10, placeVacuumGlass(random), 0, 2);
        world.setBlock(i + 5, j + 22, k + 10, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 6, j + 22, k + 10, placeVacuumGlass(random), 0, 2);
        world.setBlock(i + 7, j + 22, k + 10, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j + 22, k + 10, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 9, j + 22, k + 10, placeVacuumGlass(random), 0, 2);
        world.setBlock(i + 10, j + 22, k + 10, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 11, j + 22, k + 10, placeVacuumGlass(random), 0, 2);
        world.setBlock(i + 12, j + 22, k + 10, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 13, j + 22, k + 10, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 2, j + 22, k + 11, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 13, j + 22, k + 11, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 2, j + 22, k + 12, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 22, k + 12, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 22, k + 12, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 22, k + 12, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 2, j + 22, k + 13, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 13, j + 22, k + 13, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 2, j + 22, k + 14, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 22, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 22, k + 14, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 13, j + 22, k + 14, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 2, j + 22, k + 15, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 9, j + 22, k + 15, Blocks.ladder, 3, 2);
        world.setBlock(i + 13, j + 22, k + 15, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 2, j + 22, k + 16, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 3, j + 22, k + 16, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 22, k + 16, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 2, j + 22, k + 17, placeVacuumGlass(random), 0, 2);
        world.setBlock(i + 13, j + 22, k + 17, placeVacuumGlass(random), 0, 2);
        world.setBlock(i + 2, j + 22, k + 18, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 13, j + 22, k + 18, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 2, j + 22, k + 19, placeVacuumGlass(random), 0, 2);
        world.setBlock(i + 13, j + 22, k + 19, placeVacuumGlass(random), 0, 2);
        world.setBlock(i + 2, j + 22, k + 20, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 13, j + 22, k + 20, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 2, j + 22, k + 21, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 3, j + 22, k + 21, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 4, j + 22, k + 21, placeVacuumGlass(random), 0, 2);
        world.setBlock(i + 5, j + 22, k + 21, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 6, j + 22, k + 21, placeVacuumGlass(random), 0, 2);
        world.setBlock(i + 7, j + 22, k + 21, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 8, j + 22, k + 21, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 9, j + 22, k + 21, placeVacuumGlass(random), 0, 2);
        world.setBlock(i + 10, j + 22, k + 21, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 11, j + 22, k + 21, placeVacuumGlass(random), 0, 2);
        world.setBlock(i + 12, j + 22, k + 21, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 13, j + 22, k + 21, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i, j + 23, k + 8, placeFrontierslateBrickStairs(random), 6, 2);
        world.setBlock(i + 1, j + 23, k + 8, placeFrontierslateBrickStairs(random), 6, 2);
        world.setBlock(i + 2, j + 23, k + 8, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 3, j + 23, k + 8, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 4, j + 23, k + 8, placeFrontierslateBrickStairs(random), 6, 2);
        world.setBlock(i + 5, j + 23, k + 8, placeFrontierslateBrickStairs(random), 6, 2);
        world.setBlock(i + 6, j + 23, k + 8, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 7, j + 23, k + 8, placeFrontierslateBrickStairs(random), 6, 2);
        world.setBlock(i + 8, j + 23, k + 8, placeFrontierslateBrickStairs(random), 6, 2);
        world.setBlock(i + 9, j + 23, k + 8, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 10, j + 23, k + 8, placeFrontierslateBrickStairs(random), 6, 2);
        world.setBlock(i + 11, j + 23, k + 8, placeFrontierslateBrickStairs(random), 6, 2);
        world.setBlock(i + 12, j + 23, k + 8, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 13, j + 23, k + 8, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 14, j + 23, k + 8, placeFrontierslateBrickStairs(random), 6, 2);
        world.setBlock(i + 15, j + 23, k + 8, placeFrontierslateBrickStairs(random), 5, 2);
        world.setBlock(i, j + 23, k + 9, placeFrontierslateBrickStairs(random), 4, 2);
        world.setBlock(i + 1, j + 23, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 2, j + 23, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 3, j + 23, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 23, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 23, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 23, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 23, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 23, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 23, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 23, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 23, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 23, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 23, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 14, j + 23, k + 9, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 15, j + 23, k + 9, placeFrontierslateBrickStairs(random), 5, 2);
        world.setBlock(i, j + 23, k + 10, placeFrontierslateBrickStairs(random), 0, 2);
        world.setBlock(i + 1, j + 23, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 2, j + 23, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 3, j + 23, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 23, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 23, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 23, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 23, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 23, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 23, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 23, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 23, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 23, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 23, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 14, j + 23, k + 10, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 15, j + 23, k + 10, placeFrontierslateBrickStairs(random), 1, 2);
        world.setBlock(i, j + 23, k + 11, placeFrontierslateBrickStairs(random), 0, 2);
        world.setBlock(i + 1, j + 23, k + 11, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 2, j + 23, k + 11, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 3, j + 23, k + 11, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 23, k + 11, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 23, k + 11, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 23, k + 11, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 23, k + 11, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 23, k + 11, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 23, k + 11, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 23, k + 11, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 23, k + 11, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 23, k + 11, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 23, k + 11, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 14, j + 23, k + 11, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 15, j + 23, k + 11, placeFrontierslateBrickStairs(random), 1, 2);
        world.setBlock(i, j + 23, k + 12, placeFrontierslateBrickStairs(random), 4, 2);
        world.setBlock(i + 1, j + 23, k + 12, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 2, j + 23, k + 12, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 3, j + 23, k + 12, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 23, k + 12, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 23, k + 12, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 23, k + 12, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 23, k + 12, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 23, k + 12, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 23, k + 12, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 23, k + 12, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 23, k + 12, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 23, k + 12, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 23, k + 12, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 14, j + 23, k + 12, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 15, j + 23, k + 12, placeFrontierslateBrickStairs(random), 5, 2);
        world.setBlock(i, j + 23, k + 13, placeFrontierslateBrickStairs(random), 4, 2);
        world.setBlock(i + 1, j + 23, k + 13, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 2, j + 23, k + 13, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 3, j + 23, k + 13, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 23, k + 13, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 23, k + 13, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 23, k + 13, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 23, k + 13, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 23, k + 13, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 23, k + 13, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 23, k + 13, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 23, k + 13, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 23, k + 13, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 23, k + 13, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 14, j + 23, k + 13, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 15, j + 23, k + 13, placeFrontierslateBrickStairs(random), 5, 2);
        world.setBlock(i, j + 23, k + 14, placeFrontierslateBrickStairs(random), 0, 2);
        world.setBlock(i + 1, j + 23, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 2, j + 23, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 3, j + 23, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 23, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 23, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 23, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 23, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 23, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 23, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 23, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 23, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 23, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 23, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 14, j + 23, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 15, j + 23, k + 14, placeFrontierslateBrickStairs(random), 1, 2);
        world.setBlock(i, j + 23, k + 15, placeFrontierslateBrickStairs(random), 4, 2);
        world.setBlock(i + 1, j + 23, k + 15, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 2, j + 23, k + 15, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 3, j + 23, k + 15, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 23, k + 15, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 23, k + 15, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 23, k + 15, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 23, k + 15, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 23, k + 15, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 23, k + 15, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 23, k + 15, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 14, j + 23, k + 15, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 15, j + 23, k + 15, placeFrontierslateBrickStairs(random), 5, 2);
        world.setBlock(i, j + 23, k + 16, placeFrontierslateBrickStairs(random), 4, 2);
        world.setBlock(i + 1, j + 23, k + 16, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 2, j + 23, k + 16, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 3, j + 23, k + 16, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 23, k + 16, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 23, k + 16, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 23, k + 16, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 23, k + 16, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 23, k + 16, placeFrontierslateBrickSlab(random), 0, 2);
        world.setBlock(i + 11, j + 23, k + 16, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 23, k + 16, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 23, k + 16, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 14, j + 23, k + 16, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 15, j + 23, k + 16, placeFrontierslateBrickStairs(random), 5, 2);
        world.setBlock(i, j + 23, k + 17, placeFrontierslateBrickStairs(random), 0, 2);
        world.setBlock(i + 1, j + 23, k + 17, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 2, j + 23, k + 17, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 3, j + 23, k + 17, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 23, k + 17, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 23, k + 17, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 23, k + 17, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 23, k + 17, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 23, k + 17, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 23, k + 17, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 23, k + 17, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 14, j + 23, k + 17, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 15, j + 23, k + 17, placeFrontierslateBrickStairs(random), 1, 2);
        world.setBlock(i, j + 23, k + 18, placeFrontierslateBrickStairs(random), 4, 2);
        world.setBlock(i + 1, j + 23, k + 18, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 2, j + 23, k + 18, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 3, j + 23, k + 18, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 23, k + 18, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 23, k + 18, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 23, k + 18, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 23, k + 18, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 23, k + 18, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 23, k + 18, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 23, k + 18, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 23, k + 18, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 23, k + 18, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 23, k + 18, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 14, j + 23, k + 18, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 15, j + 23, k + 18, placeFrontierslateBrickStairs(random), 5, 2);
        world.setBlock(i, j + 23, k + 19, placeFrontierslateBrickStairs(random), 4, 2);
        world.setBlock(i + 1, j + 23, k + 19, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 2, j + 23, k + 19, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 3, j + 23, k + 19, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 23, k + 19, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 23, k + 19, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 23, k + 19, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 23, k + 19, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 23, k + 19, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 23, k + 19, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 23, k + 19, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 23, k + 19, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 23, k + 19, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 23, k + 19, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 14, j + 23, k + 19, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 15, j + 23, k + 19, placeFrontierslateBrickStairs(random), 5, 2);
        world.setBlock(i, j + 23, k + 20, placeFrontierslateBrickStairs(random), 0, 2);
        world.setBlock(i + 1, j + 23, k + 20, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 2, j + 23, k + 20, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 3, j + 23, k + 20, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 23, k + 20, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 23, k + 20, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 23, k + 20, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 23, k + 20, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 23, k + 20, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 23, k + 20, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 23, k + 20, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 23, k + 20, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 23, k + 20, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 23, k + 20, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 14, j + 23, k + 20, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 15, j + 23, k + 20, placeFrontierslateBrickStairs(random), 1, 2);
        world.setBlock(i, j + 23, k + 21, placeFrontierslateBrickStairs(random), 0, 2);
        world.setBlock(i + 1, j + 23, k + 21, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 2, j + 23, k + 21, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 3, j + 23, k + 21, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 23, k + 21, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 23, k + 21, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 23, k + 21, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 23, k + 21, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 23, k + 21, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 23, k + 21, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 23, k + 21, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 23, k + 21, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 23, k + 21, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 23, k + 21, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 14, j + 23, k + 21, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 15, j + 23, k + 21, placeFrontierslateBrickStairs(random), 1, 2);
        world.setBlock(i, j + 23, k + 22, placeFrontierslateBrickStairs(random), 4, 2);
        world.setBlock(i + 1, j + 23, k + 22, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 2, j + 23, k + 22, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 3, j + 23, k + 22, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 4, j + 23, k + 22, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 5, j + 23, k + 22, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 6, j + 23, k + 22, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 23, k + 22, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 23, k + 22, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 23, k + 22, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 23, k + 22, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 23, k + 22, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 23, k + 22, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 23, k + 22, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 14, j + 23, k + 22, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 15, j + 23, k + 22, placeFrontierslateBrickStairs(random), 5, 2);
        world.setBlock(i, j + 23, k + 23, placeFrontierslateBrickStairs(random), 4, 2);
        world.setBlock(i + 1, j + 23, k + 23, placeFrontierslateBrickStairs(random), 7, 2);
        world.setBlock(i + 2, j + 23, k + 23, placeFrontierslateBrickStairs(random), 3, 2);
        world.setBlock(i + 3, j + 23, k + 23, placeFrontierslateBrickStairs(random), 3, 2);
        world.setBlock(i + 4, j + 23, k + 23, placeFrontierslateBrickStairs(random), 7, 2);
        world.setBlock(i + 5, j + 23, k + 23, placeFrontierslateBrickStairs(random), 7, 2);
        world.setBlock(i + 6, j + 23, k + 23, placeFrontierslateBrickStairs(random), 3, 2);
        world.setBlock(i + 7, j + 23, k + 23, placeFrontierslateBrickStairs(random), 7, 2);
        world.setBlock(i + 8, j + 23, k + 23, placeFrontierslateBrickStairs(random), 7, 2);
        world.setBlock(i + 9, j + 23, k + 23, placeFrontierslateBrickStairs(random), 3, 2);
        world.setBlock(i + 10, j + 23, k + 23, placeFrontierslateBrickStairs(random), 7, 2);
        world.setBlock(i + 11, j + 23, k + 23, placeFrontierslateBrickStairs(random), 7, 2);
        world.setBlock(i + 12, j + 23, k + 23, placeFrontierslateBrickStairs(random), 3, 2);
        world.setBlock(i + 13, j + 23, k + 23, placeFrontierslateBrickStairs(random), 3, 2);
        world.setBlock(i + 14, j + 23, k + 23, placeFrontierslateBrickStairs(random), 7, 2);
        world.setBlock(i + 15, j + 23, k + 23, placeFrontierslateBrickStairs(random), 5, 2);
        world.setBlock(i + 1, j + 24, k + 9, PlaceEndRod, 1, 2);
        world.setBlock(i + 14, j + 24, k + 9, PlaceEndRod, 1, 2);
        world.setBlock(i + 8, j + 24, k + 14, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 9, j + 24, k + 14, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 10, j + 24, k + 14, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 7, j + 24, k + 15, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 11, j + 24, k + 15, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 7, j + 24, k + 16, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 11, j + 24, k + 16, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 7, j + 24, k + 17, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 9, j + 24, k + 17, placeFrontierslateBrickSlab(random), 0, 2);
        world.setBlock(i + 11, j + 24, k + 17, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 8, j + 24, k + 18, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 9, j + 24, k + 18, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 10, j + 24, k + 18, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 1, j + 24, k + 22, PlaceEndRod, 1, 2);
        world.setBlock(i + 14, j + 24, k + 22, PlaceEndRod, 1, 2);
        world.setBlock(i + 9, j + 25, k + 13, placeFrontierslateBrickStairs(random), 6, 2);
        world.setBlock(i + 8, j + 25, k + 14, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 9, j + 25, k + 14, placeFontierslatePillar(random), 8, 2);
        world.setBlock(i + 10, j + 25, k + 14, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 7, j + 25, k + 15, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 11, j + 25, k + 15, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 6, j + 25, k + 16, placeFrontierslateBrickStairs(random), 4, 2);
        world.setBlock(i + 7, j + 25, k + 16, placeFontierslatePillar(random), 4, 2);
        world.setBlock(i + 8, j + 25, k + 16, placeFrontierslateBrickSlab(random), 0, 2);
        world.setBlock(i + 11, j + 25, k + 16, placeFontierslatePillar(random), 4, 2);
        world.setBlock(i + 12, j + 25, k + 16, placeFrontierslateBrickStairs(random), 5, 2);
        world.setBlock(i + 7, j + 25, k + 17, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 11, j + 25, k + 17, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 8, j + 25, k + 18, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 9, j + 25, k + 18, placeFontierslatePillar(random), 8, 2);
        world.setBlock(i + 10, j + 25, k + 18, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 9, j + 25, k + 19, placeFrontierslateBrickStairs(random), 7, 2);
        world.setBlock(i + 8, j + 26, k + 14, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 9, j + 26, k + 14, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 10, j + 26, k + 14, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 7, j + 26, k + 15, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 9, j + 26, k + 15, placeFrontierslateBrickSlab(random), 0, 2);
        world.setBlock(i + 11, j + 26, k + 15, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 7, j + 26, k + 16, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 11, j + 26, k + 16, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 7, j + 26, k + 17, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 11, j + 26, k + 17, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 8, j + 26, k + 18, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 9, j + 26, k + 18, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 10, j + 26, k + 18, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 8, j + 27, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 27, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 27, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 27, k + 15, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 27, k + 15, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 27, k + 16, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 27, k + 16, placeFrontierslateBrickSlab(random), 0, 2);
        world.setBlock(i + 11, j + 27, k + 16, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 27, k + 17, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 27, k + 17, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 27, k + 18, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 27, k + 18, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 27, k + 18, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 28, k + 14, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 9, j + 28, k + 14, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 10, j + 28, k + 14, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 7, j + 28, k + 15, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 11, j + 28, k + 15, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 7, j + 28, k + 16, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 11, j + 28, k + 16, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 7, j + 28, k + 17, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 9, j + 28, k + 17, placeFrontierslateBrickSlab(random), 0, 2);
        world.setBlock(i + 11, j + 28, k + 17, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 8, j + 28, k + 18, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 9, j + 28, k + 18, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 10, j + 28, k + 18, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 9, j + 29, k + 13, placeFrontierslateBrickStairs(random), 6, 2);
        world.setBlock(i + 8, j + 29, k + 14, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 9, j + 29, k + 14, placeFontierslatePillar(random), 8, 2);
        world.setBlock(i + 10, j + 29, k + 14, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 7, j + 29, k + 15, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 11, j + 29, k + 15, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 6, j + 29, k + 16, placeFrontierslateBrickStairs(random), 4, 2);
        world.setBlock(i + 7, j + 29, k + 16, placeFontierslatePillar(random), 4, 2);
        world.setBlock(i + 8, j + 29, k + 16, placeFrontierslateBrickSlab(random), 0, 2);
        world.setBlock(i + 11, j + 29, k + 16, placeFontierslatePillar(random), 4, 2);
        world.setBlock(i + 12, j + 29, k + 16, placeFrontierslateBrickStairs(random), 5, 2);
        world.setBlock(i + 7, j + 29, k + 17, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 11, j + 29, k + 17, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 8, j + 29, k + 18, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 9, j + 29, k + 18, placeFontierslatePillar(random), 8, 2);
        world.setBlock(i + 10, j + 29, k + 18, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 9, j + 29, k + 19, placeFrontierslateBrickStairs(random), 7, 2);
        world.setBlock(i + 8, j + 30, k + 14, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 9, j + 30, k + 14, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 10, j + 30, k + 14, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 7, j + 30, k + 15, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 9, j + 30, k + 15, placeFrontierslateBrickSlab(random), 0, 2);
        world.setBlock(i + 11, j + 30, k + 15, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 7, j + 30, k + 16, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 11, j + 30, k + 16, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 7, j + 30, k + 17, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 11, j + 30, k + 17, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 8, j + 30, k + 18, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 9, j + 30, k + 18, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 10, j + 30, k + 18, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 8, j + 31, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 31, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 31, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 31, k + 15, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 31, k + 15, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 31, k + 16, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 31, k + 16, placeFrontierslateBrickSlab(random), 0, 2);
        world.setBlock(i + 11, j + 31, k + 16, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 31, k + 17, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 31, k + 17, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 31, k + 18, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 31, k + 18, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 31, k + 18, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 32, k + 14, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 9, j + 32, k + 14, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 10, j + 32, k + 14, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 7, j + 32, k + 15, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 11, j + 32, k + 15, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 7, j + 32, k + 16, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 11, j + 32, k + 16, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 7, j + 32, k + 17, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 9, j + 32, k + 17, placeFrontierslateBrickSlab(random), 0, 2);
        world.setBlock(i + 11, j + 32, k + 17, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 8, j + 32, k + 18, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 9, j + 32, k + 18, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 10, j + 32, k + 18, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 9, j + 33, k + 13, placeFrontierslateBrickStairs(random), 6, 2);
        world.setBlock(i + 8, j + 33, k + 14, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 9, j + 33, k + 14, placeFontierslatePillar(random), 8, 2);
        world.setBlock(i + 10, j + 33, k + 14, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 7, j + 33, k + 15, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 11, j + 33, k + 15, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 6, j + 33, k + 16, placeFrontierslateBrickStairs(random), 4, 2);
        world.setBlock(i + 7, j + 33, k + 16, placeFontierslatePillar(random), 4, 2);
        world.setBlock(i + 8, j + 33, k + 16, placeFrontierslateBrickSlab(random), 0, 2);
        world.setBlock(i + 11, j + 33, k + 16, placeFontierslatePillar(random), 4, 2);
        world.setBlock(i + 12, j + 33, k + 16, placeFrontierslateBrickStairs(random), 5, 2);
        world.setBlock(i + 7, j + 33, k + 17, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 11, j + 33, k + 17, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 8, j + 33, k + 18, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 9, j + 33, k + 18, placeFontierslatePillar(random), 8, 2);
        world.setBlock(i + 10, j + 33, k + 18, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 9, j + 33, k + 19, placeFrontierslateBrickStairs(random), 7, 2);
        world.setBlock(i + 8, j + 34, k + 14, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 9, j + 34, k + 14, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 10, j + 34, k + 14, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 7, j + 34, k + 15, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 9, j + 34, k + 15, placeFrontierslateBrickSlab(random), 0, 2);
        world.setBlock(i + 11, j + 34, k + 15, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 34, k + 16, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 11, j + 34, k + 16, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 34, k + 16, placeFontierslatePillar(random), 4, 2);
        world.setBlock(i + 13, j + 34, k + 16, placeFontierslatePillar(random), 4, 2);
        world.setBlock(i + 14, j + 34, k + 16, placeFontierslatePillar(random), 4, 2);
        world.setBlock(i + 15, j + 34, k + 16, placeFontierslatePillar(random), 4, 2);
        world.setBlock(i + 7, j + 34, k + 17, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 11, j + 34, k + 17, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 34, k + 18, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 9, j + 34, k + 18, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 10, j + 34, k + 18, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 8, j + 35, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 35, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 35, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 35, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 35, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 35, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 14, j + 35, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 15, j + 35, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 35, k + 15, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 35, k + 15, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 35, k + 15, placeFrontierslateBrickStairs(random), 1, 2);
        world.setBlock(i + 13, j + 35, k + 15, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 14, j + 35, k + 15, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 15, j + 35, k + 15, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 35, k + 16, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 35, k + 16, placeFrontierslateBrickSlab(random), 0, 2);
        world.setBlock(i + 11, j + 35, k + 16, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 35, k + 16, placeFrontierslateBrickStairs(random), 1, 2);
        world.setBlock(i + 13, j + 35, k + 16, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 14, j + 35, k + 16, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 15, j + 35, k + 16, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 35, k + 17, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 35, k + 17, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 35, k + 17, placeFrontierslateBrickStairs(random), 1, 2);
        world.setBlock(i + 13, j + 35, k + 17, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 14, j + 35, k + 17, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 15, j + 35, k + 17, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 35, k + 18, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 35, k + 18, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 35, k + 18, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 35, k + 18, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 35, k + 18, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 35, k + 18, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 14, j + 35, k + 18, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 15, j + 35, k + 18, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 36, k + 14, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 9, j + 36, k + 14, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 10, j + 36, k + 14, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 11, j + 36, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 36, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 36, k + 14, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 14, j + 36, k + 14, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 15, j + 36, k + 14, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 7, j + 36, k + 15, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 15, j + 36, k + 15, Block.getBlockById(1), 0, 2);
        world.setBlock(i + 7, j + 36, k + 16, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 15, j + 36, k + 16, Block.getBlockById(1), 0, 2);
        world.setBlock(i + 7, j + 36, k + 17, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 9, j + 36, k + 17, placeFrontierslateBrickSlab(random), 0, 2);
        world.setBlock(i + 15, j + 36, k + 17, Block.getBlockById(1), 0, 2);
        world.setBlock(i + 8, j + 36, k + 18, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 9, j + 36, k + 18, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 10, j + 36, k + 18, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 11, j + 36, k + 18, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 36, k + 18, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 36, k + 18, placeFrontierslateBrickStairs(random), 3, 2);
        world.setBlock(i + 14, j + 36, k + 18, placeFrontierslateBrickStairs(random), 3, 2);
        world.setBlock(i + 15, j + 36, k + 18, placeFrontierslateBrickStairs(random), 3, 2);
        world.setBlock(i + 9, j + 37, k + 13, placeFrontierslateBrickStairs(random), 6, 2);
        world.setBlock(i + 8, j + 37, k + 14, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 9, j + 37, k + 14, placeFontierslatePillar(random), 8, 2);
        world.setBlock(i + 10, j + 37, k + 14, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 11, j + 37, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 37, k + 14, PlaceEndRod, 1, 2);
        world.setBlock(i + 7, j + 37, k + 15, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 15, j + 37, k + 15, Block.getBlockById(1), 0, 2);
        world.setBlock(i + 6, j + 37, k + 16, placeFrontierslateBrickStairs(random), 4, 2);
        world.setBlock(i + 7, j + 37, k + 16, placeFontierslatePillar(random), 4, 2);
        world.setBlock(i + 8, j + 37, k + 16, placeFrontierslateBrickSlab(random), 0, 2);
        world.setBlock(i + 15, j + 37, k + 16, Block.getBlockById(1), 0, 2);
        world.setBlock(i + 7, j + 37, k + 17, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 15, j + 37, k + 17, Block.getBlockById(1), 0, 2);
        world.setBlock(i + 8, j + 37, k + 18, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 9, j + 37, k + 18, placeFontierslatePillar(random), 8, 2);
        world.setBlock(i + 10, j + 37, k + 18, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 11, j + 37, k + 18, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 37, k + 18, PlaceEndRod, 1, 2);
        world.setBlock(i + 9, j + 37, k + 19, placeFrontierslateBrickStairs(random), 7, 2);
        world.setBlock(i + 8, j + 38, k + 14, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 9, j + 38, k + 14, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 10, j + 38, k + 14, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 11, j + 38, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 38, k + 15, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 9, j + 38, k + 15, placeFrontierslateBrickSlab(random), 0, 2);
        world.setBlock(i + 11, j + 38, k + 15, placeFrontierslateBrickSlab(random), 8, 2);
        world.setBlock(i + 7, j + 38, k + 16, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 7, j + 38, k + 17, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 11, j + 38, k + 17, placeFrontierslateBrickSlab(random), 8, 2);
        world.setBlock(i + 8, j + 38, k + 18, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 9, j + 38, k + 18, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 10, j + 38, k + 18, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 11, j + 38, k + 18, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 39, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 39, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 39, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 39, k + 14, placeFrontierslateBrickSlab(random), 0, 2);
        world.setBlock(i + 7, j + 39, k + 15, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 39, k + 15, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 39, k + 16, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 39, k + 16, placeFrontierslateBrickSlab(random), 0, 2);
        world.setBlock(i + 11, j + 39, k + 16, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 39, k + 17, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 39, k + 17, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 39, k + 18, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 39, k + 18, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 39, k + 18, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 39, k + 18, placeFrontierslateBrickSlab(random), 0, 2);
        world.setBlock(i + 8, j + 40, k + 14, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 9, j + 40, k + 14, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 10, j + 40, k + 14, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 7, j + 40, k + 15, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 11, j + 40, k + 15, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 7, j + 40, k + 16, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 11, j + 40, k + 16, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 7, j + 40, k + 17, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 9, j + 40, k + 17, placeFrontierslateBrickSlab(random), 0, 2);
        world.setBlock(i + 11, j + 40, k + 17, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 8, j + 40, k + 18, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 9, j + 40, k + 18, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 10, j + 40, k + 18, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 9, j + 41, k + 13, placeFrontierslateBrickStairs(random), 6, 2);
        world.setBlock(i + 8, j + 41, k + 14, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 9, j + 41, k + 14, placeFontierslatePillar(random), 8, 2);
        world.setBlock(i + 10, j + 41, k + 14, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 7, j + 41, k + 15, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 11, j + 41, k + 15, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 6, j + 41, k + 16, placeFrontierslateBrickStairs(random), 4, 2);
        world.setBlock(i + 7, j + 41, k + 16, placeFontierslatePillar(random), 4, 2);
        world.setBlock(i + 8, j + 41, k + 16, placeFrontierslateBrickSlab(random), 0, 2);
        world.setBlock(i + 11, j + 41, k + 16, placeFontierslatePillar(random), 4, 2);
        world.setBlock(i + 12, j + 41, k + 16, placeFrontierslateBrickStairs(random), 5, 2);
        world.setBlock(i + 7, j + 41, k + 17, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 11, j + 41, k + 17, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 8, j + 41, k + 18, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 9, j + 41, k + 18, placeFontierslatePillar(random), 8, 2);
        world.setBlock(i + 10, j + 41, k + 18, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 9, j + 41, k + 19, placeFrontierslateBrickStairs(random), 7, 2);
        world.setBlock(i + 8, j + 42, k + 14, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 9, j + 42, k + 14, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 10, j + 42, k + 14, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 7, j + 42, k + 15, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 9, j + 42, k + 15, placeFrontierslateBrickSlab(random), 0, 2);
        world.setBlock(i + 11, j + 42, k + 15, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 7, j + 42, k + 16, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 11, j + 42, k + 16, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 7, j + 42, k + 17, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 11, j + 42, k + 17, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 8, j + 42, k + 18, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 9, j + 42, k + 18, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 10, j + 42, k + 18, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 6, j + 43, k + 13, placeFrontierslateBrickStairs(random), 6, 2);
        world.setBlock(i + 7, j + 43, k + 13, placeFrontierslateBrickStairs(random), 6, 2);
        world.setBlock(i + 8, j + 43, k + 13, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 9, j + 43, k + 13, placeFrontierslateBrickStairs(random), 6, 2);
        world.setBlock(i + 10, j + 43, k + 13, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 11, j + 43, k + 13, placeFrontierslateBrickStairs(random), 6, 2);
        world.setBlock(i + 12, j + 43, k + 13, placeFrontierslateBrickStairs(random), 5, 2);
        world.setBlock(i + 6, j + 43, k + 14, placeFrontierslateBrickStairs(random), 4, 2);
        world.setBlock(i + 7, j + 43, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 43, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 43, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 43, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 43, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 43, k + 14, placeFrontierslateBrickStairs(random), 5, 2);
        world.setBlock(i + 6, j + 43, k + 15, placeFrontierslateBrickStairs(random), 0, 2);
        world.setBlock(i + 7, j + 43, k + 15, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 43, k + 15, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 43, k + 15, placeFrontierslateBrickStairs(random), 1, 2);
        world.setBlock(i + 6, j + 43, k + 16, placeFrontierslateBrickStairs(random), 4, 2);
        world.setBlock(i + 7, j + 43, k + 16, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 43, k + 16, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 43, k + 16, placeFrontierslateBrickStairs(random), 5, 2);
        world.setBlock(i + 6, j + 43, k + 17, placeFrontierslateBrickStairs(random), 0, 2);
        world.setBlock(i + 7, j + 43, k + 17, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 43, k + 17, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 43, k + 17, placeFrontierslateBrickSlab(random), 0, 2);
        world.setBlock(i + 10, j + 43, k + 17, placeFrontierslateBrickSlab(random), 0, 2);
        world.setBlock(i + 11, j + 43, k + 17, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 43, k + 17, placeFrontierslateBrickStairs(random), 1, 2);
        world.setBlock(i + 6, j + 43, k + 18, placeFrontierslateBrickStairs(random), 4, 2);
        world.setBlock(i + 7, j + 43, k + 18, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 43, k + 18, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 43, k + 18, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 43, k + 18, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 43, k + 18, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 43, k + 18, placeFrontierslateBrickStairs(random), 5, 2);
        world.setBlock(i + 6, j + 43, k + 19, placeFrontierslateBrickStairs(random), 4, 2);
        world.setBlock(i + 7, j + 43, k + 19, placeFrontierslateBrickStairs(random), 7, 2);
        world.setBlock(i + 8, j + 43, k + 19, placeFrontierslateBrickStairs(random), 3, 2);
        world.setBlock(i + 9, j + 43, k + 19, placeFrontierslateBrickStairs(random), 7, 2);
        world.setBlock(i + 10, j + 43, k + 19, placeFrontierslateBrickStairs(random), 3, 2);
        world.setBlock(i + 11, j + 43, k + 19, placeFrontierslateBrickStairs(random), 7, 2);
        world.setBlock(i + 12, j + 43, k + 19, placeFrontierslateBrickStairs(random), 5, 2);
        world.setBlock(i + 6, j + 44, k + 13, PlaceEndRod, 1, 2);
        world.setBlock(i + 12, j + 44, k + 13, PlaceEndRod, 1, 2);
        world.setBlock(i + 7, j + 44, k + 14, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 8, j + 44, k + 14, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 9, j + 44, k + 14, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 10, j + 44, k + 14, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 11, j + 44, k + 14, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 7, j + 44, k + 15, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 11, j + 44, k + 15, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 11, j + 44, k + 16, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 11, j + 44, k + 17, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 7, j + 44, k + 18, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 8, j + 44, k + 18, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 9, j + 44, k + 18, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 10, j + 44, k + 18, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 11, j + 44, k + 18, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 6, j + 44, k + 19, PlaceEndRod, 1, 2);
        world.setBlock(i + 12, j + 44, k + 19, PlaceEndRod, 1, 2);
        world.setBlock(i + 7, j + 45, k + 14, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 8, j + 45, k + 14, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 9, j + 45, k + 14, placeVacuumGlass(random), 0, 2);
        world.setBlock(i + 10, j + 45, k + 14, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 11, j + 45, k + 14, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 7, j + 45, k + 15, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 11, j + 45, k + 15, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 11, j + 45, k + 16, placeVacuumGlass(random), 0, 2);
        world.setBlock(i + 11, j + 45, k + 17, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 7, j + 45, k + 18, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 8, j + 45, k + 18, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 9, j + 45, k + 18, placeVacuumGlass(random), 0, 2);
        world.setBlock(i + 10, j + 45, k + 18, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 11, j + 45, k + 18, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 7, j + 46, k + 14, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 8, j + 46, k + 14, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 9, j + 46, k + 14, placeVacuumGlass(random), 0, 2);
        world.setBlock(i + 10, j + 46, k + 14, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 11, j + 46, k + 14, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 7, j + 46, k + 15, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 11, j + 46, k + 15, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 7, j + 46, k + 16, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 11, j + 46, k + 16, placeVacuumGlass(random), 0, 2);
        world.setBlock(i + 7, j + 46, k + 17, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 11, j + 46, k + 17, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 7, j + 46, k + 18, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 8, j + 46, k + 18, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 9, j + 46, k + 18, placeVacuumGlass(random), 0, 2);
        world.setBlock(i + 10, j + 46, k + 18, placeEndStoneBricks(random), 0, 2);
        world.setBlock(i + 11, j + 46, k + 18, placeFontierslatePillar(random), 0, 2);
        world.setBlock(i + 5, j + 47, k + 12, placeFrontierslateBrickStairs(random), 4, 2);
        world.setBlock(i + 6, j + 47, k + 12, placeFrontierslateBrickStairs(random), 6, 2);
        world.setBlock(i + 7, j + 47, k + 12, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 8, j + 47, k + 12, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 9, j + 47, k + 12, placeFrontierslateBrickStairs(random), 6, 2);
        world.setBlock(i + 10, j + 47, k + 12, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 11, j + 47, k + 12, placeFrontierslateBrickStairs(random), 2, 2);
        world.setBlock(i + 12, j + 47, k + 12, placeFrontierslateBrickStairs(random), 6, 2);
        world.setBlock(i + 13, j + 47, k + 12, placeFrontierslateBrickStairs(random), 6, 2);
        world.setBlock(i + 5, j + 47, k + 13, placeFrontierslateBrickStairs(random), 4, 2);
        world.setBlock(i + 6, j + 47, k + 13, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 47, k + 13, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 47, k + 13, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 47, k + 13, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 47, k + 13, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 47, k + 13, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 47, k + 13, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 47, k + 13, placeFrontierslateBrickStairs(random), 5, 2);
        world.setBlock(i + 5, j + 47, k + 14, placeFrontierslateBrickStairs(random), 0, 2);
        world.setBlock(i + 6, j + 47, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 47, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 47, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 47, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 47, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 47, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 47, k + 14, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 47, k + 14, placeFrontierslateBrickStairs(random), 1, 2);
        world.setBlock(i + 5, j + 47, k + 15, placeFrontierslateBrickStairs(random), 0, 2);
        world.setBlock(i + 6, j + 47, k + 15, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 47, k + 15, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 47, k + 15, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 47, k + 15, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 47, k + 15, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 47, k + 15, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 47, k + 15, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 47, k + 15, placeFrontierslateBrickStairs(random), 1, 2);
        world.setBlock(i + 5, j + 47, k + 16, placeFrontierslateBrickStairs(random), 4, 2);
        world.setBlock(i + 6, j + 47, k + 16, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 47, k + 16, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 47, k + 16, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 47, k + 16, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 47, k + 16, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 47, k + 16, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 47, k + 16, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 47, k + 16, placeFrontierslateBrickStairs(random), 5, 2);
        world.setBlock(i + 5, j + 47, k + 17, placeFrontierslateBrickStairs(random), 0, 2);
        world.setBlock(i + 6, j + 47, k + 17, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 47, k + 17, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 47, k + 17, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 47, k + 17, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 47, k + 17, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 47, k + 17, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 47, k + 17, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 47, k + 17, placeFrontierslateBrickStairs(random), 1, 2);
        world.setBlock(i + 5, j + 47, k + 18, placeFrontierslateBrickStairs(random), 0, 2);
        world.setBlock(i + 6, j + 47, k + 18, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 47, k + 18, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 47, k + 18, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 47, k + 18, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 47, k + 18, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 47, k + 18, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 47, k + 18, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 47, k + 18, placeFrontierslateBrickStairs(random), 1, 2);
        world.setBlock(i + 5, j + 47, k + 19, placeFrontierslateBrickStairs(random), 4, 2);
        world.setBlock(i + 6, j + 47, k + 19, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 7, j + 47, k + 19, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 8, j + 47, k + 19, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 9, j + 47, k + 19, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 10, j + 47, k + 19, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 11, j + 47, k + 19, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 12, j + 47, k + 19, placeFrontierslateBricks(random), 0, 2);
        world.setBlock(i + 13, j + 47, k + 19, placeFrontierslateBrickStairs(random), 5, 2);
        world.setBlock(i + 5, j + 47, k + 20, placeFrontierslateBrickStairs(random), 7, 2);
        world.setBlock(i + 6, j + 47, k + 20, placeFrontierslateBrickStairs(random), 7, 2);
        world.setBlock(i + 7, j + 47, k + 20, placeFrontierslateBrickStairs(random), 3, 2);
        world.setBlock(i + 8, j + 47, k + 20, placeFrontierslateBrickStairs(random), 3, 2);
        world.setBlock(i + 9, j + 47, k + 20, placeFrontierslateBrickStairs(random), 7, 2);
        world.setBlock(i + 10, j + 47, k + 20, placeFrontierslateBrickStairs(random), 3, 2);
        world.setBlock(i + 11, j + 47, k + 20, placeFrontierslateBrickStairs(random), 3, 2);
        world.setBlock(i + 12, j + 47, k + 20, placeFrontierslateBrickStairs(random), 7, 2);
        world.setBlock(i + 13, j + 47, k + 20, placeFrontierslateBrickStairs(random), 5, 2);
        world.setBlock(i + 7, j + 20, k + 20, Blocks.ender_chest, 2, 2);

        world.setBlock(i + 11, j + 48, k + 17, Blocks.mob_spawner, 0, 2);
        TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner)world.getTileEntity(i + 11, j + 48, k + 17);

        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a().setEntityName("nova_craft.phantom");
        }

        this.setBlockAndNotifyAdequately(world, i + 8, j + 20, k + 20, Blocks.chest, 2);
        TileEntity tile = world.getTileEntity(i + 8, j + 20, k + 20);
        if (tile instanceof TileEntityChest) {
            TileEntityChest chest2 = (TileEntityChest) tile;

            for (int slot = 0; slot < 3 + random.nextInt(20); slot++) {
                chest2.setInventorySlotContents(random.nextInt(chest2.getSizeInventory()), this.getEquipmentLoot(random));
            }
        }

        EntityFrontierGolem entity = new EntityFrontierGolem(world);
        entity.setPosition(i + 7, j + 12, k + 11);

        if (!world.isRemote) {
            world.spawnEntityInWorld(entity);
        }

        EntityFrontierGolem entity2 = new EntityFrontierGolem(world);
        entity2.setPosition(i + 3, j + 20, k + 20);

        if (!world.isRemote) {
            world.spawnEntityInWorld(entity2);
        }

        EntityFrontierGolem entity3 = new EntityFrontierGolem(world);
        entity3.setPosition(i + 12, j + 20, k + 20);

        if (!world.isRemote) {
            world.spawnEntityInWorld(entity3);
        }

        EntityFrontierGolem entity4 = new EntityFrontierGolem(world);
        entity4.setPosition(i + 5, j + 43, k + 18);

        if (!world.isRemote) {
            world.spawnEntityInWorld(entity4);
        }

        EntityFrontierGolem entity5 = new EntityFrontierGolem(world); //5
        entity5.setPosition(i + 13, j + 43, k + 18);

        if (!world.isRemote) {
            world.spawnEntityInWorld(entity5);
        }

        EntityFrontierGolem entity6 = new EntityFrontierGolem(world); //3
        entity6.setPosition(i + 7, j + 43, k + 20);

        if (!world.isRemote) {
            world.spawnEntityInWorld(entity6);
        }

        EntityFrontierGolem entity7 = new EntityFrontierGolem(world); //3
        entity7.setPosition(i + 11, j + 43, k + 20);

        if (!world.isRemote) {
            world.spawnEntityInWorld(entity7);
        }

        EntityFrontierGolem entity8 = new EntityFrontierGolem(world); //2
        entity8.setPosition(i + 7, j + 43, k + 12);

        if (!world.isRemote) {
            world.spawnEntityInWorld(entity8);
        }

        EntityFrontierGolem entity9 = new EntityFrontierGolem(world); //2
        entity9.setPosition(i + 11, j + 43, k + 12);

        if (!world.isRemote) {
            world.spawnEntityInWorld(entity9);
        }

        EntityFrontierGolem entity10 = new EntityFrontierGolem(world); //4
        entity10.setPosition(i + 5, j + 43, k + 14);

        if (!world.isRemote) {
            world.spawnEntityInWorld(entity10);
        }

        EntityFrontierGolem entity11 = new EntityFrontierGolem(world); //5
        entity11.setPosition(i + 13, j + 43, k + 14);

        if (!world.isRemote) {
            world.spawnEntityInWorld(entity11);
        }

        EntityFrontierGolem entity12 = new EntityFrontierGolem(world); //0
        entity12.setPosition(i + 9, j + 48, k + 16);

        if (!world.isRemote) {
            world.spawnEntityInWorld(entity12);
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

    private Block placeVacuumGlass(Random random) {
        if (random.nextDouble() < 0.85) {
            return NovaCraftBlocks.vacuum_glass;
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

    private Block placeFontierslatePillar(Random random) {
        if (random.nextDouble() < 0.95) {
            return NovaCraftBlocks.frontierslate_pillar;
        } else {
            return Blocks.air;
        }
    }

    private ItemStack getEquipmentLoot(Random random) {
        int item = random.nextInt(24);
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
            default: {
                return new ItemStack(NovaCraftItems.diamond_nugget, random.nextInt(4) + 6, 2);
            }
        }
    }
}
