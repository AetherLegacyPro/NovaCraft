package com.NovaCraft.world.caves.hot;

import com.NovaCraft.world.NCWorldGeneratorPre;
import com.NovaCraft.world.caves.cold.BasicUndergroundBiomeNearSurface;
import com.NovaCraftBlocks.NovaCraftBlocks;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

import java.util.Locale;

public class MercuryCaveBiome extends BasicUndergroundBiomeNearSurface {

    public static boolean useOre;
    public static double StagChance;
    public static double StacChance;
    public static double CinnabarBlobChance = 0.33D;
    public static double StibniteBlobChance = 0.24D;

    public MercuryCaveBiome() {
        super(NovaCraftBlocks.cinnabar, null, null, 0, 0, 0, true);
    }

    private static boolean canReplace(Block block) {
        if (block == null) return false;
        String name = block.getUnlocalizedName();
        return name != null && (name.toLowerCase(Locale.ROOT).contains("stone") || name.toLowerCase(Locale.ROOT).contains("dirt") || name.toLowerCase(Locale.ROOT).contains("gravel")) && !(name.toLowerCase(Locale.ROOT).contains("ore")) && !(name.toLowerCase(Locale.ROOT).contains("brimstone")) && !(name.toLowerCase(Locale.ROOT).contains("dirt"))
                && !(name.toLowerCase(Locale.ROOT).contains("grass")) && !(name.toLowerCase(Locale.ROOT).contains("spawner")) && !(name.toLowerCase(Locale.ROOT).contains("portal")) && !(name.toLowerCase(Locale.ROOT).contains("moss"));
    }

    @Override
    public void fillCeiling(World world, int x, int y, int z, Block block) {
        if (world.canBlockSeeTheSky(x, y, z)) return;
        if (!canReplace(block)) return;

        world.setBlock(x, y, z, NovaCraftBlocks.cinnabar, 0, 2);
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

        if (tryGenerateCinnabar(world, x, y, z)) {
            return;
        }

        if (tryGenerateStibnite(world, x, y, z)) {
            return;
        }

        world.setBlock(x, y, z, NovaCraftBlocks.cinnabar, 0, 2);

        if (!(StagChance > 0 && world.rand.nextDouble() < StagChance)) return;

        Block placeBlockBottom;
        int chance = world.rand.nextInt(120);

        switch (chance / 20) {
            case 0:
                placeBlockBottom = NovaCraftBlocks.large_cinnabar_stalagmite;
                break;
            case 1:
                placeBlockBottom = NovaCraftBlocks.cinnabar_brimstone;
                break;
            case 2:
                placeBlockBottom = NovaCraftBlocks.cinnabar_pherithium_stalagmite;
                break;
            case 3:
                placeBlockBottom = NovaCraftBlocks.bright_lichen;
                break;
            case 4:
                placeBlockBottom = NovaCraftBlocks.mercury;
                break;
            default:
                placeBlockBottom = NovaCraftBlocks.cinnabar_stalagmite;
                break;
        }

        int topY = y + 1;

        if (world.getBlock(x, topY, z).isAir(world, x, topY, z) && !canSeeSky(world, x, topY, z)) {
            if (placeBlockBottom == NovaCraftBlocks.cinnabar_brimstone) {
                if (world.getBlock(x, topY + 1, z).isAir(world, x, topY + 1, z)) {
                    world.setBlock(x, topY - 1, z, NovaCraftBlocks.cinnabar_brimstone, 0, 2);
                }
            } else if (placeBlockBottom == NovaCraftBlocks.bright_lichen) {
                world.setBlock(x, topY, z, placeBlockBottom, 1, 2);
            } else if (placeBlockBottom == NovaCraftBlocks.mercury) {
                world.setBlock(x, topY - 1, z, placeBlockBottom, 0, 2);
                world.setBlock(x, topY - 2, z, NovaCraftBlocks.cinnabar, 0, 2);
                world.setBlock(x, topY - 1, z + 1, NovaCraftBlocks.cinnabar, 0, 2);
                world.setBlock(x, topY - 1, z - 1, NovaCraftBlocks.cinnabar, 0, 2);
                world.setBlock(x + 1, topY - 1, z, NovaCraftBlocks.cinnabar, 0, 2);
                world.setBlock(x - 1, topY - 1, z, NovaCraftBlocks.cinnabar, 0, 2);

                if (world.getBlock(x + 1, topY, z) == Blocks.air && world.getBlock(x + 1, topY - 2, z) != Blocks.air && world.getBlock(x + 2, topY, z) != Blocks.air) {
                    world.setBlock(x + 1, topY - 1, z, placeBlockBottom, 0, 2);
                }

                if (world.getBlock(x - 1, topY, z) == Blocks.air && world.getBlock(x - 1, topY - 2, z) != Blocks.air && world.getBlock(x - 2, topY, z) != Blocks.air) {
                    world.setBlock(x - 1, topY - 1, z, placeBlockBottom, 0, 2);
                }

                if (world.getBlock(x, topY, z + 1) == Blocks.air && world.getBlock(x, topY - 2, z + 1) != Blocks.air && world.getBlock(x, topY, z + 2) != Blocks.air) {
                    world.setBlock(x, topY - 1, z + 1, placeBlockBottom, 0, 2);
                }

                if (world.getBlock(x, topY, z - 1) == Blocks.air && world.getBlock(x, topY - 2, z - 1) != Blocks.air && world.getBlock(x, topY, z - 2) != Blocks.air) {
                    world.setBlock(x, topY - 1, z - 1, placeBlockBottom, 0, 2);
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
            placeBlockTop = NovaCraftBlocks.cinnabar_pherithium_stalactite;
        } else if (chance_top / 20 == 1) {
            placeBlockTop = NovaCraftBlocks.cinnabar;
        } else {
            placeBlockTop = NovaCraftBlocks.cinnabar_stalactite;
        }

        final int maxScan = 32;
        for (int dy = 2; dy <= maxScan; dy++) {
            int ceilingY = y + dy;
            int hangY = ceilingY - 1;

            Block ceiling = world.getBlock(x, ceilingY, z);

            if (ceiling != null && ceiling.getMaterial().isSolid() && ceiling.isOpaqueCube()) {
                if (world.getBlock(x, hangY, z).isAir(world, x, hangY, z) && !canSeeSky(world, x, hangY, z)) {
                        world.setBlock(x, hangY, z, placeBlockTop, 0, 2);
                        world.setBlock(x, hangY - 1, z, Blocks.air, 0, 2);
                }
                break;
            }
        }

        Block placeLichen = NovaCraftBlocks.bright_lichen;

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

    private static boolean tryGenerateCinnabar(World world, int x, int y, int z) {
        if (!useOre) return false;

        if (world.rand.nextDouble() >= CinnabarBlobChance) return false;

        if (world.getBlock(x, y, z) != Blocks.stone) return false;

        return NCWorldGeneratorPre.cinnabarGen.generate(world, world.rand, x, y, z);
    }

    private static boolean tryGenerateStibnite(World world, int x, int y, int z) {
        if (!useOre) return false;

        if (world.rand.nextDouble() >= StibniteBlobChance) return false;

        if (world.getBlock(x, y, z) != Blocks.stone) return false;

        return NCWorldGeneratorPre.stibniteGen.generate(world, world.rand, x, y, z);
    }

    static {
        useOre = true;
        StagChance = 0.45;
        StacChance = 0.65;
    }

}
