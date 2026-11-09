package com.NovaCraft.world.caves.ore_deposit.deep;

import com.NovaCraftBlocks.NovaCraftBlocks;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import java.util.Locale;

public class GoldDeposit extends BasicUndergroundBiomeDeepOreDeposit {

    public static boolean useOre;
    public static double FloraChance;
    public static double OtherBlocksChance;

    public GoldDeposit() {
        super(NovaCraftBlocks.grimstone_gold, null, null, 0, 0, 0, true);
    }

    private static boolean canReplace(Block block) {
        if (block == null) return false;
        String name = block.getUnlocalizedName();
        return name != null && (name.toLowerCase(Locale.ROOT).contains("stone") || name.toLowerCase(Locale.ROOT).contains("dirt") || name.toLowerCase(Locale.ROOT).contains("tuff") || name.toLowerCase(Locale.ROOT).contains("brick") || name.toLowerCase(Locale.ROOT).contains("tile")
                || name.toLowerCase(Locale.ROOT).contains("andesite") || name.toLowerCase(Locale.ROOT).contains("granite") || name.toLowerCase(Locale.ROOT).contains("diorite")) && !(name.toLowerCase(Locale.ROOT).contains("ore"));
    }

    @Override
    public void fillCeiling(World world, int x, int y, int z, Block block) {
        if (!canReplace(block)) return;

        world.setBlock(x, y, z, NovaCraftBlocks.grimstone_gold, 0, 2);
    }

    @Override
    public void fillWall(World world, int x, int y, int z, Block block) {
        if (!canReplace(block)) return;
        fillCeiling(world, x, y, z, block);
    }

    @Override
    public void fillFloor(World world, int x, int y, int z, Block block) {
        if (!canReplace(block)) return;

        Block placeBlockFloor;
        int chance = 1 + world.rand.nextInt(3);

        if (chance == 1) {
            placeBlockFloor = NovaCraftBlocks.pleurotus_mushroom;
        } else {
            placeBlockFloor = NovaCraftBlocks.grim_lichen;
        }

        world.setBlock(x, y, z, NovaCraftBlocks.grimstone_gold, 0, 2);

        if (FloraChance > 0 && world.rand.nextDouble() < FloraChance) {
            int height = 3 + world.rand.nextInt(3);
            for (int i = 0; i < height; i++) {
                if (world.getBlock(x, y + 1, z).isAir(world, x, y + 1, z))
                    world.setBlock(x, y + 1, z, placeBlockFloor, 1, 2);
                else break;
            }
        }

        Block placeBlockCeiling;
        placeBlockCeiling = NovaCraftBlocks.grim_lichen;

        if (FloraChance > 0 && world.rand.nextDouble() < FloraChance) {
            int height = 3 + world.rand.nextInt(3);
            for (int i = 0; i < height; i++) {
                if (world.getBlock(x, y - 1, z).isAir(world, x, y - 1, z))
                    world.setBlock(x, y - 1, z, placeBlockCeiling, 0, 2);
                else break;
            }
        }

        Block placeBlockAlternate = Blocks.gold_ore;
        int chance_alternate = 1 + world.rand.nextInt(4);

        switch (chance_alternate) {
            case 1:
                placeBlockAlternate = NovaCraftBlocks.nullstone_gold;
                break;
            case 2:
                placeBlockAlternate = NovaCraftBlocks.nullstone;
                break;
            default:
                placeBlockAlternate = NovaCraftBlocks.grimstone;
                break;
        }

        if (OtherBlocksChance > 0 && world.rand.nextDouble() < OtherBlocksChance) {
            int height = 2 + world.rand.nextInt(1);
            for (int i = 0; i < height; i++) {
                if (world.getBlock(x, y + 1, z).isAir(world, x, y + 1, z))
                    world.setBlock(x, y, z, placeBlockAlternate, 0, 2);
                else break;
            }
        }
    }

    static {
        useOre = true;
        FloraChance = 0.01;
        OtherBlocksChance = 0.015;
    }

}
