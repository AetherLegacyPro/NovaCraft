package com.NovaCraft.world.end.ancient_base;

import com.NovaCraft.config.Configs;
import com.NovaCraft.config.ConfigsCompact;
import com.NovaCraftBlocks.NovaCraftBlocks;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import java.util.Random;

public class AncientEndBaseUnknownEntityStatue extends WorldGenerator {

    public AncientEndBaseUnknownEntityStatue() {
    }

    private Block PlaceEndRod;

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
        PlaceEndRod = determineIfEndRodExists(world, i, j + 1, k);
        
        world.setBlock(i, j, k, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 8, j, k, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i, j, k + 8, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 8, j, k + 8, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i, j + 1, k, NovaCraftBlocks.vanite_torch, 5, 2);
        world.setBlock(i + 8, j + 1, k, NovaCraftBlocks.vanite_torch, 5, 2);
        world.setBlock(i, j + 1, k + 8, NovaCraftBlocks.vanite_torch, 5, 2);
        world.setBlock(i + 8, j + 1, k + 8, NovaCraftBlocks.vanite_torch, 5, 2);
        world.setBlock(i + 2, j + 2, k + 2, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 3, j + 2, k + 2, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 4, j + 2, k + 2, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 5, j + 2, k + 2, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 6, j + 2, k + 2, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 2, j + 2, k + 3, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 3, j + 2, k + 3, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 4, j + 2, k + 3, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 5, j + 2, k + 3, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 6, j + 2, k + 3, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 2, j + 2, k + 4, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 3, j + 2, k + 4, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 4, j + 2, k + 4, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 5, j + 2, k + 4, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 6, j + 2, k + 4, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 2, j + 2, k + 5, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 3, j + 2, k + 5, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 4, j + 2, k + 5, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 5, j + 2, k + 5, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 6, j + 2, k + 5, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 2, j + 2, k + 6, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 3, j + 2, k + 6, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 4, j + 2, k + 6, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 5, j + 2, k + 6, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 6, j + 2, k + 6, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 2, j + 3, k + 2, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 3, j + 3, k + 2, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 4, j + 3, k + 2, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 5, j + 3, k + 2, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 6, j + 3, k + 2, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 2, j + 3, k + 3, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 6, j + 3, k + 3, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 2, j + 3, k + 4, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 6, j + 3, k + 4, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 2, j + 3, k + 5, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 4, j + 3, k + 5, NovaCraftBlocks.frontierslate_bricks, 0, 2);
        world.setBlock(i + 6, j + 3, k + 5, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 2, j + 3, k + 6, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 3, j + 3, k + 6, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 4, j + 3, k + 6, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 5, j + 3, k + 6, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 6, j + 3, k + 6, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 2, j + 4, k + 2, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 3, j + 4, k + 2, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 4, j + 4, k + 2, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 5, j + 4, k + 2, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 6, j + 4, k + 2, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 2, j + 4, k + 3, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 6, j + 4, k + 3, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 2, j + 4, k + 4, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 6, j + 4, k + 4, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 2, j + 4, k + 5, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 4, j + 4, k + 5, Blocks.pumpkin, 2, 2);
        world.setBlock(i + 6, j + 4, k + 5, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 2, j + 4, k + 6, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 3, j + 4, k + 6, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 4, j + 4, k + 6, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 5, j + 4, k + 6, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 6, j + 4, k + 6, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 2, j + 5, k + 2, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 3, j + 5, k + 2, NovaCraftBlocks.crystallized_end, 0, 2);
        world.setBlock(i + 4, j + 5, k + 2, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 5, j + 5, k + 2, NovaCraftBlocks.crystallized_end, 0, 2);
        world.setBlock(i + 6, j + 5, k + 2, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 2, j + 5, k + 3, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 6, j + 5, k + 3, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 2, j + 5, k + 4, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 6, j + 5, k + 4, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 2, j + 5, k + 5, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 3, j + 5, k + 5, PlaceEndRod, 0, 2);
        world.setBlock(i + 5, j + 5, k + 5, PlaceEndRod, 0, 2);
        world.setBlock(i + 6, j + 5, k + 5, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 2, j + 5, k + 6, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 3, j + 5, k + 6, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 4, j + 5, k + 6, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 5, j + 5, k + 6, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 6, j + 5, k + 6, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 2, j + 6, k + 2, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 3, j + 6, k + 2, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 4, j + 6, k + 2, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 5, j + 6, k + 2, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 6, j + 6, k + 2, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 2, j + 6, k + 3, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 3, j + 6, k + 3, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 4, j + 6, k + 3, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 5, j + 6, k + 3, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 6, j + 6, k + 3, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 2, j + 6, k + 4, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 3, j + 6, k + 4, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 4, j + 6, k + 4, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 5, j + 6, k + 4, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 6, j + 6, k + 4, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 2, j + 6, k + 5, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 3, j + 6, k + 5, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 4, j + 6, k + 5, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 5, j + 6, k + 5, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 6, j + 6, k + 5, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 2, j + 6, k + 6, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 3, j + 6, k + 6, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 4, j + 6, k + 6, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 5, j + 6, k + 6, NovaCraftBlocks.frontierslate, 0, 2);
        world.setBlock(i + 6, j + 6, k + 6, NovaCraftBlocks.frontierslate, 0, 2);

        return true;
    }
}
