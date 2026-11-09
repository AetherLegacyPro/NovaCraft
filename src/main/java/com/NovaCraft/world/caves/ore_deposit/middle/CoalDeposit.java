package com.NovaCraft.world.caves.ore_deposit.middle;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import java.util.Locale;

public class CoalDeposit extends BasicUndergroundBiomeIronOreDeposit {

    public static boolean useOre;

    public CoalDeposit() {
        super(Blocks.coal_ore, null, null, 0, 0, 0, true);
    }

    private static boolean canReplace(Block block) {
        if (block == null) return false;
        String name = block.getUnlocalizedName();
        return name != null && (name.toLowerCase(Locale.ROOT).contains("stone") || name.toLowerCase(Locale.ROOT).contains("calcite") || name.toLowerCase(Locale.ROOT).contains("tuff") || name.toLowerCase(Locale.ROOT).contains("brick") || name.toLowerCase(Locale.ROOT).contains("tile")
                || name.toLowerCase(Locale.ROOT).contains("andesite") || name.toLowerCase(Locale.ROOT).contains("granite") || name.toLowerCase(Locale.ROOT).contains("diorite")) && !(name.toLowerCase(Locale.ROOT).contains("ore")) && !(name.toLowerCase(Locale.ROOT).contains("dirt"))
                && !(name.toLowerCase(Locale.ROOT).contains("grass")) && !(name.toLowerCase(Locale.ROOT).contains("sand") && !(name.toLowerCase(Locale.ROOT).contains("log")) && !(name.toLowerCase(Locale.ROOT).contains("leaves")));
    }

    @Override
    public void fillCeiling(World world, int x, int y, int z, Block block) {
        if (!canReplace(block)) return;

        world.setBlock(x, y, z, Blocks.coal_ore, 0, 2);
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
            placeBlockFloor = Blocks.brown_mushroom;
        } else {
            placeBlockFloor = Blocks.red_mushroom;
        }

        world.setBlock(x, y, z, Blocks.coal_ore, 0, 2);
    }

    static {
        useOre = true;
    }

}
