package com.NovaCraft.world.caves;

import com.NovaCraftBlocks.NovaCraftBlocks;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.world.World;

import java.util.Locale;

public class DeepDarkBiome extends BasicUndergroundBiome {
    public static boolean useSculk;
    public static double FloraChance;
    public static double SculkedStoneChance;

    public DeepDarkBiome() { super(NovaCraftBlocks.sculk_block, null, null, 0, 0, 0, true);}

    private static boolean canReplace(Block block) {
        if (block == null) return false;
        String name = block.getUnlocalizedName();
        return name != null && (name.toLowerCase(Locale.ROOT).contains("stone") || name.toLowerCase(Locale.ROOT).contains("slate") || name.toLowerCase(Locale.ROOT).contains("tuff")
                || name.toLowerCase(Locale.ROOT).contains("andesite") || name.toLowerCase(Locale.ROOT).contains("granite") || name.toLowerCase(Locale.ROOT).contains("diorite")) && !(name.toLowerCase(Locale.ROOT).contains("ore"));
    }

    @Override
    public void fillCeiling(World world, int x, int y, int z, Block block) {
        if (!canReplace(block)) return;
        world.setBlock(x, y, z, NovaCraftBlocks.sculk_block, 0, 2);
    }

    @Override
    public void fillWall(World world, int x, int y, int z, Block block) {
        if (!canReplace(block)) return;
        fillCeiling(world, x, y, z, block);
    }

    @Override
    public void fillFloor(World world, int x, int y, int z, Block block) {
        if (!canReplace(block)) return;

        Block placeBlock;
        int chance = world.rand.nextInt(120);

        switch (chance / 20) {
            case 0:
                placeBlock = NovaCraftBlocks.sculk_tentacle_2;
                break;
            case 1:
                placeBlock = NovaCraftBlocks.sculk_spike;
                break;
            case 2:
                placeBlock = NovaCraftBlocks.sculk_growth;
                break;
            case 3:
                placeBlock = NovaCraftBlocks.sculk_tulip;
                break;
            case 4:
                placeBlock = NovaCraftBlocks.sculk_tendrils;
                break;
            case 5:
                placeBlock = NovaCraftBlocks.sculk_sensor;
                break;
            default:
                placeBlock = NovaCraftBlocks.sculk_vein;
                break;
        }

        world.setBlock(x, y, z, NovaCraftBlocks.sculk_block, 0, 2);

        if (FloraChance > 0 && world.rand.nextDouble() < FloraChance) {
            int height = 3 + world.rand.nextInt(3);
            for (int i = 0; i < height; i++) {
                if (world.getBlock(x, y + 1, z).isAir(world, x, y + 1, z))
                    world.setBlock(x, y + 1, z, placeBlock, 1, 2);
                else break;
            }
        }

        Block placeBlockSculkStone = NovaCraftBlocks.sculk_grimstone;
        int chance_alternate = world.rand.nextInt(80);

        switch (chance_alternate / 100) {
            case 0:
                placeBlockSculkStone = NovaCraftBlocks.sculk_nullstone;
                break;
            case 1:
                placeBlockSculkStone = NovaCraftBlocks.sculk_stone;
                break;
            case 2:
                try {
                    Block deepslate = GameRegistry.findBlock("etfuturum", "deepslate");
                    if (deepslate != null) {
                        placeBlockSculkStone = NovaCraftBlocks.sculk_deepslate;
                    }
                } catch (Exception ex) {
                    placeBlockSculkStone = NovaCraftBlocks.sculk_grimstone;
                }
                break;
            default:
                placeBlockSculkStone = NovaCraftBlocks.sculk_grimstone;
                break;
        }

        if (SculkedStoneChance > 0 && world.rand.nextDouble() < SculkedStoneChance) {
            int height = 3 + world.rand.nextInt(3);
            for (int i = 0; i < height; i++) {
                if (world.getBlock(x, y + 1, z).isAir(world, x, y + 1, z))
                    world.setBlock(x, y, z, placeBlockSculkStone, 0, 2);
                else break;
            }
        }
    }

    static {
        useSculk = true;
        FloraChance = 0.11;
        SculkedStoneChance = 0.045;
    }
}
