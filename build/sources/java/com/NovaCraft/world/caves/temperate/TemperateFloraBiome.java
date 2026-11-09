package com.NovaCraft.world.caves.temperate;

import com.NovaCraft.world.caves.cold.BasicUndergroundBiomeNearSurface;
import com.NovaCraftBlocks.NovaCraftBlocks;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

import java.util.Locale;

public class TemperateFloraBiome extends BasicUndergroundBiomeNearSurface {

    public static boolean useMoss;
    public static double FloraChance;
    public static double TorchFlowerChance;
    public static double VineChance;
    public static double OtherBlocksChance;

    public TemperateFloraBiome() {
        super(NovaCraftBlocks.moss_block, null, null, 0, 0, 0, true);
    }

    private static boolean canReplace(Block block) {
        if (block == null) return false;
        String name = block.getUnlocalizedName();
        return name != null && (name.toLowerCase(Locale.ROOT).contains("stone") || name.toLowerCase(Locale.ROOT).contains("dirt") || name.toLowerCase(Locale.ROOT).contains("tuff")
                || name.toLowerCase(Locale.ROOT).contains("andesite") || name.toLowerCase(Locale.ROOT).contains("granite") || name.toLowerCase(Locale.ROOT).contains("diorite")) && !(name.toLowerCase(Locale.ROOT).contains("ore"));
    }

    @Override
    public void fillCeiling(World world, int x, int y, int z, Block block) {
        if (world.canBlockSeeTheSky(x, y, z)) return;
        if (!canReplace(block)) return;

        world.setBlock(x, y, z, NovaCraftBlocks.moss_block, 0, 2);
    }

    @Override
    public void fillWall(World world, int x, int y, int z, Block block) {
        if (world.canBlockSeeTheSky(x, y, z)) return;
        if (!canReplace(block)) return;

        fillCeiling(world, x, y, z, block);
    }

    private static boolean canSeeSky(World world, int x, int y, int z) {
        return world.canBlockSeeTheSky(x, y, z);
    }

    @Override
    public void fillFloor(World world, int x, int y, int z, Block block) {
        if (!canReplace(block)) return;

        if (canSeeSky(world, x, y, z) || canSeeSky(world, x, y + 1, z) || canSeeSky(world, x, y - 1, z)) {
            return;
        }

        world.setBlock(x, y, z, NovaCraftBlocks.moss_block, 0, 2);

        Block placeVinesPosZ;
        placeVinesPosZ = NovaCraftBlocks.bloomed_glow_vines;

        if (VineChance > 0 && world.rand.nextDouble() < VineChance) {
            int height = 3 + world.rand.nextInt(2);
            for (int i = 0; i < height; i++) {
                int yy = y + 1 + i;
                if (world.getBlock(x, y, z - 1).isAir(world, x, y, z - 1) && world.getBlock(x,y,z) != Blocks.air && !canSeeSky(world, x, yy, z - 1))
                    world.setBlock(x, y, z, placeVinesPosZ, 1, 2);
                else break;
            }
        }

        Block placeVinesNegZ;
        placeVinesNegZ = NovaCraftBlocks.bloomed_glow_vines;

        if (VineChance > 0 && world.rand.nextDouble() < VineChance) {
            int height = 3 + world.rand.nextInt(2);
            for (int i = 0; i < height; i++) {
                int yy = y + 1 + i;
                if (world.getBlock(x, y, z + 1).isAir(world, x, y, z + 1) && world.getBlock(x,y,z) != Blocks.air && !canSeeSky(world, x, yy, z + 1))
                    world.setBlock(x, y, z, placeVinesNegZ, 4, 2);
                else break;
            }
        }

        Block placeVinesPosX;
        placeVinesPosX = NovaCraftBlocks.bloomed_glow_vines;

        if (VineChance > 0 && world.rand.nextDouble() < VineChance) {
            int height = 3 + world.rand.nextInt(2);
            for (int i = 0; i < height; i++) {
                int yy = y + 1 + i;
                if (world.getBlock(x - 1, y, z).isAir(world, x - 1, y, z) && world.getBlock(x,y,z) != Blocks.air && !canSeeSky(world, x - 1, yy, z))
                    world.setBlock(x, y, z, placeVinesPosX, 8, 2);
                else break;
            }
        }

        Block placeVinesNegX;
        placeVinesNegX = NovaCraftBlocks.bloomed_glow_vines;

        if (VineChance > 0 && world.rand.nextDouble() < VineChance) {
            int height = 3 + world.rand.nextInt(2);
            for (int i = 0; i < height; i++) {
                int yy = y + 1 + i;
                if (world.getBlock(x + 1, y, z).isAir(world, x + 1, y, z) && world.getBlock(x,y,z) != Blocks.air && !canSeeSky(world, x + 1, yy, z))
                    world.setBlock(x, y, z, placeVinesNegX, 2, 2);
                else break;
            }
        }

        Block placeBlockFloor;
        int chance = 1 + world.rand.nextInt(12);

        switch (chance) {
            case 1:
                placeBlockFloor = NovaCraftBlocks.moss_carpet;
                break;
            case 2:
                placeBlockFloor = NovaCraftBlocks.cave_bloom;
                break;
            case 3:
                placeBlockFloor = NovaCraftBlocks.cyan_rose;
                break;
            case 4:
                placeBlockFloor = NovaCraftBlocks.violet;
                break;
            case 5:
                placeBlockFloor = NovaCraftBlocks.purple_rose;
                break;
            case 6:
                placeBlockFloor = NovaCraftBlocks.blue_cave_bloom;
                break;
            default:
                placeBlockFloor = NovaCraftBlocks.glow_lichen;
                break;
        }

        if (FloraChance > 0 && world.rand.nextDouble() < FloraChance) {
            int height = 3 + world.rand.nextInt(3);
            for (int i = 0; i < height; i++) {
                int yy = y + 1 + i;
                if (world.getBlock(x, y + 1, z).isAir(world, x, y + 1, z) && !canSeeSky(world, x, yy + 1, z))
                    world.setBlock(x, y + 1, z, placeBlockFloor, 1, 2);
                else break;
            }
        }

        Block placeTorchflower;
        int chanceTorchFlower = 1 + world.rand.nextInt(24);

        if (chanceTorchFlower == 2) {
            placeTorchflower = NovaCraftBlocks.torchflower;

        if (TorchFlowerChance > 0 && world.rand.nextDouble() < TorchFlowerChance) {
            int height = 3 + world.rand.nextInt(2);
            for (int i = 0; i < height; i++) {
                int yy = y + 1 + i;
                if (world.getBlock(x, y + 1, z).isAir(world, x, y + 1, z) && !canSeeSky(world, x, yy + 1, z))
                    world.setBlock(x, y + 1, z, placeTorchflower, 0, 2);
                else break;
                 }
            }
        }

        Block placeBlockCeiling;
        int chanceCeiling = 1 + world.rand.nextInt(6);

        switch (chanceCeiling) {
            case 1:
                placeBlockCeiling = NovaCraftBlocks.moss_carpet;
                break;
            case 2:
                placeBlockCeiling = NovaCraftBlocks.large_stone_stalactite;
                break;
            default:
                placeBlockCeiling = NovaCraftBlocks.glow_lichen;
                break;
        }

        if (FloraChance > 0 && world.rand.nextDouble() < FloraChance) {
            int height = 3 + world.rand.nextInt(3);
            for (int i = 0; i < height; i++) {
                int yy = y + 1 + i;
                if (world.getBlock(x, y - 1, z).isAir(world, x, y - 1, z) && !canSeeSky(world, x, yy - 1, z))
                    world.setBlock(x, y - 1, z, placeBlockCeiling, 0, 2);
                else break;
            }
        }

        Block placeBlockAlternate = Blocks.gravel;
        int chance_alternate = 1 + world.rand.nextInt(4);

        switch (chance_alternate) {
            case 1:
                placeBlockAlternate = Blocks.gravel;
                break;
            case 2:
                if (Loader.isModLoaded("etfuturum")) {
                    try {
                        Block coarse_dirt = GameRegistry.findBlock("etfuturum", "coarse_dirt");
                        placeBlockAlternate = coarse_dirt != null ? coarse_dirt : Blocks.dirt;
                    } catch (Exception ignored) {
                        placeBlockAlternate = Blocks.dirt;
                    }
                } else {
                    placeBlockAlternate = Blocks.dirt;
                }
                break;
            default:
                placeBlockAlternate = Blocks.cobblestone;
                break;
        }

        if (OtherBlocksChance > 0 && world.rand.nextDouble() < OtherBlocksChance) {
            int height = 3 + world.rand.nextInt(4);
            for (int i = 0; i < height; i++) {
                int yy = y + 1 + i;
                if (world.getBlock(x, y + 1, z).isAir(world, x, y + 1, z) && !canSeeSky(world, x, yy + 1, z))
                    world.setBlock(x, y, z, placeBlockAlternate, 0, 2);
                else break;
            }
        }
    }

    static {
        useMoss = true;
        FloraChance = 0.35;
        VineChance = 0.25;
        TorchFlowerChance = 0.02;
        OtherBlocksChance = 0.12;
    }

}
