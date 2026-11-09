package com.NovaCraft.world.end.ancient_base;

import com.NovaCraft.entity.EntityFrontierGolem;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import java.util.Random;

public class AncientEndBasePlatformGen extends WorldGenerator {

    public AncientEndBasePlatformGen() {
    }

    public boolean generate(final World world, final Random random, final int i, final int j, final int k) {

        world.setBlock(i, j, k, Blocks.air, 0, 2);
        world.setBlock(i + 1, j, k, Blocks.air, 0, 2);
        world.setBlock(i + 2, j, k, Blocks.air, 0, 2);
        world.setBlock(i + 3, j, k, Blocks.air, 0, 2);
        world.setBlock(i + 4, j, k, Blocks.air, 0, 2);
        world.setBlock(i, j, k + 1, Blocks.air, 0, 2);
        world.setBlock(i + 1, j, k + 1, Blocks.end_stone, 0, 2);
        world.setBlock(i + 2, j, k + 1, Blocks.end_stone, 0, 2);
        world.setBlock(i + 3, j, k + 1, Blocks.end_stone, 0, 2);
        world.setBlock(i + 4, j, k + 1, Blocks.air, 0, 2);
        world.setBlock(i, j, k + 2, Blocks.air, 0, 2);
        world.setBlock(i + 1, j, k + 2, Blocks.end_stone, 0, 2);
        world.setBlock(i + 2, j, k + 2, Blocks.end_stone, 0, 2);
        world.setBlock(i + 3, j , k + 2, Blocks.end_stone, 0, 2);
        world.setBlock(i + 4, j, k + 2, Blocks.air, 0, 2);
        world.setBlock(i, j, k + 3, Blocks.air, 0, 2);
        world.setBlock(i + 1, j, k + 3, Blocks.end_stone, 0, 2);
        world.setBlock(i + 2, j, k + 3, Blocks.end_stone, 0, 2);
        world.setBlock(i + 3, j, k + 3, Blocks.end_stone, 0, 2);
        world.setBlock(i + 4, j, k + 3, Blocks.air, 0, 2);
        world.setBlock(i, j, k + 4, Blocks.air, 0, 2);
        world.setBlock(i + 1, j, k + 4, Blocks.air, 0, 2);
        world.setBlock(i + 2, j , k + 4, Blocks.air, 0, 2);
        world.setBlock(i + 3, j, k + 4, Blocks.air, 0, 2);
        world.setBlock(i + 4, j, k + 4, Blocks.air, 0, 2);
        world.setBlock(i, j + 1, k, Blocks.air, 0, 2);
        world.setBlock(i + 1, j + 1, k, Blocks.obsidian, 0, 2);
        world.setBlock(i + 2, j + 1, k, Blocks.obsidian, 0, 2);
        world.setBlock(i + 3, j + 1, k, Blocks.obsidian, 0, 2);
        world.setBlock(i + 4, j + 1, k, Blocks.air, 0, 2);
        world.setBlock(i, j + 1, k + 1, Blocks.obsidian, 0, 2);
        world.setBlock(i + 1, j + 1, k + 1, Blocks.end_stone, 0, 2);
        world.setBlock(i + 2, j + 1, k + 1, Blocks.end_stone, 0, 2);
        world.setBlock(i + 3, j + 1, k + 1, Blocks.end_stone, 0, 2);
        world.setBlock(i + 4, j + 1, k + 1, Blocks.obsidian, 0, 2);
        world.setBlock(i, j + 1, k + 2, Blocks.obsidian, 0, 2);
        world.setBlock(i + 1, j + 1, k + 2, Blocks.end_stone, 0, 2);
        world.setBlock(i + 2, j + 1, k + 2, Blocks.end_stone, 0, 2);
        world.setBlock(i + 3, j + 1, k + 2, Blocks.end_stone, 0, 2);
        world.setBlock(i + 4, j + 1, k + 2, Blocks.obsidian, 0, 2);
        world.setBlock(i, j + 1, k + 3, Blocks.obsidian, 0, 2);
        world.setBlock(i + 1, j + 1, k + 3, Blocks.end_stone, 0, 2);
        world.setBlock(i + 2, j + 1, k + 3, Blocks.end_stone, 0, 2);
        world.setBlock(i + 3, j + 1, k + 3, Blocks.end_stone, 0, 2);
        world.setBlock(i + 4, j + 1, k + 3, Blocks.obsidian, 0, 2);
        world.setBlock(i, j + 1, k + 4, Blocks.air, 0, 2);
        world.setBlock(i + 1, j + 1, k + 4, Blocks.obsidian, 0, 2);
        world.setBlock(i + 2, j + 1, k + 4, Blocks.obsidian, 0, 2);
        world.setBlock(i + 3, j + 1, k + 4, Blocks.obsidian, 0, 2);
        world.setBlock(i + 4, j + 1, k + 4, Blocks.air, 0, 2);

        if (random.nextBoolean()) {
            EntityFrontierGolem entity = new EntityFrontierGolem(world);
            entity.setPosition(i + 2, j + 5, k + 2);

            if (!world.isRemote) {
                world.spawnEntityInWorld(entity);
            }
        }

        return true;
    }
}
