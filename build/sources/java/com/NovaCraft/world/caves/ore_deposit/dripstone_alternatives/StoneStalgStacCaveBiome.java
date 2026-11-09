package com.NovaCraft.world.caves.ore_deposit.dripstone_alternatives;

import com.NovaCraftBlocks.NovaCraftBlocks;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import java.util.Locale;

public class StoneStalgStacCaveBiome extends BasicUndergroundBiomeStalgStacCave {

    public static boolean useOre;
    public static double StagChance;
    public static double StacChance;

    public StoneStalgStacCaveBiome() {
        super(Blocks.stone, null, null, 0, 0, 0, true);
    }

    private static boolean canReplace(Block block) {
        if (block == null) return false;
        String name = block.getUnlocalizedName();
        return name != null && (name.toLowerCase(Locale.ROOT).contains("stone")) && !(name.toLowerCase(Locale.ROOT).contains("ore")) && !(name.toLowerCase(Locale.ROOT).contains("dirt"))
                && !(name.toLowerCase(Locale.ROOT).contains("grass"));
    }

    @Override
    public void fillCeiling(World world, int x, int y, int z, Block block) {
        if (world.canBlockSeeTheSky(x, y, z)) return;
        if (!canReplace(block)) return;

        world.setBlock(x, y, z, Blocks.stone, 0, 2);
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

        if (canSeeSky(world, x, y, z) || canSeeSky(world, x, y + 1, z) || canSeeSky(world, x, y - 1, z)) return;

        world.setBlock(x, y, z, Blocks.stone, 0, 2);

        if (!(StagChance > 0 && world.rand.nextDouble() < StagChance)) return;

        Block placeBlockBottom;
        int chance = world.rand.nextInt(120);

        switch (chance / 20) {
            case 0:
                placeBlockBottom = NovaCraftBlocks.stone_stalagmite;
                break;
            case 1:
                placeBlockBottom = NovaCraftBlocks.large_stone_stalagmite;
                break;
            case 2:
                placeBlockBottom = Blocks.brown_mushroom;
                break;
            case 3:
                int chance_pherithium = world.rand.nextInt(20);
                if (chance_pherithium == 1) {
                    placeBlockBottom = NovaCraftBlocks.large_pherithium_stalagmite;
                } else if (chance_pherithium == 2) {
                    placeBlockBottom = NovaCraftBlocks.small_pherithium_stalagmite;
                } else {
                    placeBlockBottom = NovaCraftBlocks.large_stone_stalagmite;
                }
                break;
            case 4:
                placeBlockBottom = NovaCraftBlocks.massive_stone_stalagmite_bottom;
                break;
            default:
                placeBlockBottom = NovaCraftBlocks.stone_stalagmite;
                break;
        }

        int topY = y + 1; // air above the floor block at y

        if (world.getBlock(x, topY, z).isAir(world, x, topY, z) && !canSeeSky(world, x, topY, z)) {
            if (placeBlockBottom == NovaCraftBlocks.massive_stone_stalagmite_bottom) {
                if (world.getBlock(x, topY + 1, z).isAir(world, x, topY + 1, z)) {
                    world.setBlock(x, topY, z, NovaCraftBlocks.massive_stone_stalagmite_bottom, 0, 2);
                    world.setBlock(x, topY + 1, z, NovaCraftBlocks.massive_stone_stalagmite_top, 0, 2);
                }
            } else {
                world.setBlock(x, topY, z, placeBlockBottom, 0, 2);
            }
        }

        if (!(world.rand.nextFloat() < 0.75f)) return;
        if (!(StacChance > 0 && world.rand.nextDouble() < StacChance)) return;

        Block placeBlockTop;
        int chance_top = world.rand.nextInt(120);

        if (chance_top / 20 == 0) {
            placeBlockTop = NovaCraftBlocks.stone_stalactite;
        } else if (chance_top / 20 == 1) {
            placeBlockTop = NovaCraftBlocks.massive_stone_stalactite_top;
        } else {
            placeBlockTop = NovaCraftBlocks.large_stone_stalactite;
        }

        final int maxScan = 32;
        for (int dy = 2; dy <= maxScan; dy++) {
            int ceilingY = y + dy;
            int hangY = ceilingY - 1;

            Block ceiling = world.getBlock(x, ceilingY, z);

            if (ceiling != null && ceiling.getMaterial().isSolid() && ceiling.isOpaqueCube()) {
                if (world.getBlock(x, hangY, z).isAir(world, x, hangY, z) && !canSeeSky(world, x, hangY, z)) {
                    if (placeBlockTop == NovaCraftBlocks.massive_stone_stalactite_top) {
                        world.setBlock(x, hangY, z, placeBlockTop, 0, 2);
                        world.setBlock(x, hangY - 1, z, NovaCraftBlocks.massive_stone_stalactite_bottom, 0, 2);
                    } else {
                        world.setBlock(x, hangY, z, placeBlockTop, 0, 2);
                        world.setBlock(x, hangY - 1, z, Blocks.air, 0, 2);
                    }
                }
                break;
            }
        }

        Block placeLichen = NovaCraftBlocks.glow_lichen;

        if (StagChance > 0 && world.rand.nextDouble() < StagChance) {
            int height = 3 + world.rand.nextInt(3);
            for (int i = 0; i < height; i++) {
                int yy = y + 1 + i;
                if (world.getBlock(x, y + 1, z).isAir(world, x, y + 1, z) && !canSeeSky(world, x, yy + 1, z))
                    world.setBlock(x, y + 1, z, placeLichen, 1, 2);
                else break;
            }
        }

        if (StacChance > 0 && world.rand.nextDouble() < StacChance) {
            int height = 3 + world.rand.nextInt(3);
            for (int i = 0; i < height; i++) {
                if (world.getBlock(x, y - 1, z).isAir(world, x, y - 1, z))
                    world.setBlock(x, y - 1, z, placeLichen, 0, 2);
                else break;
            }
        }
    }

    static {
        useOre = true;
        StagChance = 0.45;
        StacChance = 0.65;
    }

}
