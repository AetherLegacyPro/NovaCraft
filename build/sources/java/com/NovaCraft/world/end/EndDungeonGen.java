package com.NovaCraft.world.end;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.config.ConfigsWorld;
import com.NovaCraftBlocks.NovaCraftBlocks;
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
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class EndDungeonGen extends WorldGenerator {

    public EndDungeonGen() {

    }

    @Override
    public boolean generate(final World world, final Random random, final int x, final int y, final int z) {

        world.setBlock(x + 8, y, z + 4, placeEndStone(random), 0, 2);
        world.setBlock(x + 8, y, z + 6, placeEndStone(random), 0, 2);
        world.setBlock(x + 6, y + 1, z + 1, placeEndStone(random), 0, 2);
        world.setBlock(x + 5, y + 1, z + 3, placeEndStone(random), 0, 2);
        world.setBlock(x + 6, y + 1, z + 3, placeEndStone(random), 0, 2);
        world.setBlock(x + 2, y + 1, z + 4, placeEndStone(random), 0, 2);
        world.setBlock(x + 4, y + 1, z + 4, placeEndStone(random), 0, 2);
        world.setBlock(x + 8, y + 1, z + 4, placeEndStone(random), 0, 2);
        world.setBlock(x + 9, y + 1, z + 5, placeEndStone(random), 0, 2);
        world.setBlock(x + 3, y + 1, z + 6, placeEndStone(random), 0, 2);
        world.setBlock(x + 5, y + 1, z + 6, placeEndStone(random), 0, 2);
        world.setBlock(x + 6, y + 1, z + 6, placeEndStone(random), 0, 2);
        world.setBlock(x + 8, y + 1, z + 6, placeEndStone(random), 0, 2);
        world.setBlock(x + 9, y + 1, z + 6, placeEndStone(random), 0, 2);
        world.setBlock(x + 11, y + 1, z + 6, placeEndStone(random), 0, 2);
        world.setBlock(x + 7, y + 1, z + 7, placeEndStone(random), 0, 2);
        world.setBlock(x + 9, y + 1, z + 7, placeEndStone(random), 0, 2);
        world.setBlock(x + 6, y + 1, z + 8, placeEndStone(random), 0, 2);
        world.setBlock(x + 6, y + 2, z + 1, placeEndStone(random), 0, 2);
        world.setBlock(x + 6, y + 2, z + 2, placeEndStone(random), 0, 2);
        world.setBlock(x + 7, y + 2, z + 2, placeEndStone(random), 0, 2);
        world.setBlock(x + 5, y + 2, z + 3, placeEndStone(random), 0, 2);
        world.setBlock(x + 6, y + 2, z + 3, placeEndStone(random), 0, 2);
        world.setBlock(x + 7, y + 2, z + 3, placeEndStone(random), 0, 2);
        world.setBlock(x + 2, y + 2, z + 4, placeEndStone(random), 0, 2);
        world.setBlock(x + 3, y + 2, z + 4, placeEndStone(random), 0, 2);
        world.setBlock(x + 4, y + 2, z + 4, placeEndStone(random), 0, 2);
        world.setBlock(x + 6, y + 2, z + 4, placeEndStone(random), 0, 2);
        world.setBlock(x + 7, y + 2, z + 4, placeEndStone(random), 0, 2);
        world.setBlock(x + 8, y + 2, z + 4, placeEndStone(random), 0, 2);
        world.setBlock(x + 9, y + 2, z + 4, placeEndStone(random), 0, 2);
        world.setBlock(x + 5, y + 2, z + 5, placeEndStone(random), 0, 2);
        world.setBlock(x + 6, y + 2, z + 5, placeEndStone(random), 0, 2);
        world.setBlock(x + 7, y + 2, z + 5, placeEndStone(random), 0, 2);
        world.setBlock(x + 8, y + 2, z + 5, placeEndStone(random), 0, 2);
        world.setBlock(x + 9, y + 2, z + 5, placeEndStone(random), 0, 2);
        world.setBlock(x + 2, y + 2, z + 6, placeEndStone(random), 0, 2);
        world.setBlock(x + 3, y + 2, z + 6, placeEndStone(random), 0, 2);
        world.setBlock(x + 4, y + 2, z + 6, placeEndStone(random), 0, 2);
        world.setBlock(x + 6, y + 2, z + 6, placeEndStone(random), 0, 2);
        world.setBlock(x + 7, y + 2, z + 6, placeEndStone(random), 0, 2);
        world.setBlock(x + 8, y + 2, z + 6, placeEndStone(random), 0, 2);
        world.setBlock(x + 9, y + 2, z + 6, placeEndStone(random), 0, 2);
        world.setBlock(x + 10, y + 2, z + 6, placeEndStone(random), 0, 2);
        world.setBlock(x + 11, y + 2, z + 6, placeEndStone(random), 0, 2);
        world.setBlock(x + 3, y + 2, z + 7, placeEndStone(random), 0, 2);
        world.setBlock(x + 5, y + 2, z + 7, placeEndStone(random), 0, 2);
        world.setBlock(x + 7, y + 2, z + 7, placeEndStone(random), 0, 2);
        world.setBlock(x + 9, y + 2, z + 7, placeEndStone(random), 0, 2);
        world.setBlock(x + 4, y + 2, z + 8, placeEndStone(random), 0, 2);
        world.setBlock(x + 6, y + 2, z + 8, placeEndStone(random), 0, 2);
        world.setBlock(x + 7, y + 2, z + 8, placeEndStone(random), 0, 2);
        world.setBlock(x + 8, y + 2, z + 8, placeEndStone(random), 0, 2);
        world.setBlock(x + 5, y + 2, z + 9, placeEndStone(random), 0, 2);
        world.setBlock(x + 6, y + 2, z + 9, placeEndStone(random), 0, 2);
        world.setBlock(x + 7, y + 2, z + 9, placeEndStone(random), 0, 2);
        world.setBlock(x + 5, y + 2, z + 10, placeEndStone(random), 0, 2);
        world.setBlock(x + 6, y + 3, z, placeEndStone(random), 0, 2);
        world.setBlock(x + 6, y + 3, z + 1, placeEndStone(random), 0, 2);
        world.setBlock(x + 5, y + 3, z + 2, placeEndStone(random), 0, 2);
        world.setBlock(x + 6, y + 3, z + 2, placeEndStone(random), 0, 2);
        world.setBlock(x + 7, y + 3, z + 2, placeEndStone(random), 0, 2);
        world.setBlock(x + 3, y + 3, z + 3, placeEndStone(random), 0, 2);
        world.setBlock(x + 4, y + 3, z + 3, placeEndStone(random), 0, 2);
        world.setBlock(x + 5, y + 3, z + 3, placeEndStone(random), 0, 2);
        world.setBlock(x + 6, y + 3, z + 3, placeEndStone(random), 0, 2);
        world.setBlock(x + 7, y + 3, z + 3, placeEndStone(random), 0, 2);
        world.setBlock(x + 8, y + 3, z + 3, placeEndStone(random), 0, 2);
        world.setBlock(x + 2, y + 3, z + 4, placeEndStone(random), 0, 2);
        world.setBlock(x + 3, y + 3, z + 4, placeEndStone(random), 0, 2);
        world.setBlock(x + 4, y + 3, z + 4, placeEndStone(random), 0, 2);
        world.setBlock(x + 5, y + 3, z + 4, placeEndStone(random), 0, 2);
        world.setBlock(x + 6, y + 3, z + 4, placeEndStone(random), 0, 2);
        world.setBlock(x + 7, y + 3, z + 4, placeEndStone(random), 0, 2);
        world.setBlock(x + 8, y + 3, z + 4, placeEndStone(random), 0, 2);
        world.setBlock(x + 9, y + 3, z + 4, placeEndStone(random), 0, 2);
        world.setBlock(x + 2, y + 3, z + 5, placeEndStone(random), 0, 2);
        world.setBlock(x + 3, y + 3, z + 5, placeEndStone(random), 0, 2);
        world.setBlock(x + 4, y + 3, z + 5, placeEndStone(random), 0, 2);
        world.setBlock(x + 5, y + 3, z + 5, placeEndStone(random), 0, 2);
        world.setBlock(x + 6, y + 3, z + 5, placeEndStone(random), 0, 2);
        world.setBlock(x + 7, y + 3, z + 5, placeEndStone(random), 0, 2);
        world.setBlock(x + 8, y + 3, z + 5, placeEndStone(random), 0, 2);
        world.setBlock(x + 9, y + 3, z + 5, placeEndStone(random), 0, 2);
        world.setBlock(x + 10, y + 3, z + 5, placeEndStone(random), 0, 2);
        world.setBlock(x + 1, y + 3, z + 6, placeEndStone(random), 0, 2);
        world.setBlock(x + 2, y + 3, z + 6, placeEndStone(random), 0, 2);
        world.setBlock(x + 3, y + 3, z + 6, placeEndStone(random), 0, 2);
        world.setBlock(x + 4, y + 3, z + 6, placeEndStone(random), 0, 2);
        world.setBlock(x + 5, y + 3, z + 6, placeEndStone(random), 0, 2);
        world.setBlock(x + 6, y + 3, z + 6, placeEndStone(random), 0, 2);
        world.setBlock(x + 7, y + 3, z + 6, placeEndStone(random), 0, 2);
        world.setBlock(x + 8, y + 3, z + 6, placeEndStone(random), 0, 2);
        world.setBlock(x + 9, y + 3, z + 6, placeEndStone(random), 0, 2);
        world.setBlock(x + 10, y + 3, z + 6, placeEndStone(random), 0, 2);
        world.setBlock(x + 11, y + 3, z + 6, placeEndStone(random), 0, 2);
        world.setBlock(x + 12, y + 3, z + 6, placeEndStone(random), 0, 2);
        world.setBlock(x + 2, y + 3, z + 7, placeEndStone(random), 0, 2);
        world.setBlock(x + 3, y + 3, z + 7, placeEndStone(random), 0, 2);
        world.setBlock(x + 4, y + 3, z + 7, placeEndStone(random), 0, 2);
        world.setBlock(x + 5, y + 3, z + 7, placeEndStone(random), 0, 2);
        world.setBlock(x + 6, y + 3, z + 7, placeEndStone(random), 0, 2);
        world.setBlock(x + 7, y + 3, z + 7, placeEndStone(random), 0, 2);
        world.setBlock(x + 8, y + 3, z + 7, placeEndStone(random), 0, 2);
        world.setBlock(x + 9, y + 3, z + 7, placeEndStone(random), 0, 2);
        world.setBlock(x + 10, y + 3, z + 7, placeEndStone(random), 0, 2);
        world.setBlock(x + 11, y + 3, z + 7, placeEndStone(random), 0, 2);
        world.setBlock(x + 3, y + 3, z + 8, placeEndStone(random), 0, 2);
        world.setBlock(x + 4, y + 3, z + 8, placeEndStone(random), 0, 2);
        world.setBlock(x + 5, y + 3, z + 8, placeEndStone(random), 0, 2);
        world.setBlock(x + 6, y + 3, z + 8, placeEndStone(random), 0, 2);
        world.setBlock(x + 7, y + 3, z + 8, placeEndStone(random), 0, 2);
        world.setBlock(x + 8, y + 3, z + 8, placeEndStone(random), 0, 2);
        world.setBlock(x + 9, y + 3, z + 8, placeEndStone(random), 0, 2);
        world.setBlock(x + 4, y + 3, z + 9, placeEndStone(random), 0, 2);
        world.setBlock(x + 5, y + 3, z + 9, placeEndStone(random), 0, 2);
        world.setBlock(x + 6, y + 3, z + 9, placeEndStone(random), 0, 2);
        world.setBlock(x + 7, y + 3, z + 9, placeEndStone(random), 0, 2);
        world.setBlock(x + 8, y + 3, z + 9, placeEndStone(random), 0, 2);
        world.setBlock(x + 5, y + 3, z + 10, placeEndStone(random), 0, 2);
        world.setBlock(x + 6, y + 3, z + 10, placeEndStone(random), 0, 2);
        world.setBlock(x + 7, y + 3, z + 10, placeEndStone(random), 0, 2);
        world.setBlock(x + 6, y + 3, z + 11, placeEndStone(random), 0, 2);
        world.setBlock(x + 6, y + 4, z, placeEndStone(random), 0, 2);
        world.setBlock(x + 5, y + 4, z + 1, placeEndStone(random), 0, 2);
        world.setBlock(x + 6, y + 4, z + 1, placeEndStone(random), 0, 2);
        world.setBlock(x + 7, y + 4, z + 1, placeEndStone(random), 0, 2);
        world.setBlock(x + 4, y + 4, z + 2, placeEndStone(random), 0, 2);
        world.setBlock(x + 5, y + 4, z + 2, placeEndStone(random), 0, 2);
        world.setBlock(x + 6, y + 4, z + 2, placeEndStone(random), 0, 2);
        world.setBlock(x + 7, y + 4, z + 2, placeEndStone(random), 0, 2);
        world.setBlock(x + 8, y + 4, z + 2, placeEndStone(random), 0, 2);
        world.setBlock(x + 3, y + 4, z + 3, placeEndStone(random), 0, 2);
        world.setBlock(x + 4, y + 4, z + 3, placeEndStone(random), 0, 2);
        world.setBlock(x + 5, y + 4, z + 3, placeEndStone(random), 0, 2);
        world.setBlock(x + 6, y + 4, z + 3, placeEndStone(random), 0, 2);
        world.setBlock(x + 7, y + 4, z + 3, placeEndStone(random), 0, 2);
        world.setBlock(x + 8, y + 4, z + 3, placeEndStone(random), 0, 2);
        world.setBlock(x + 9, y + 4, z + 3, placeEndStone(random), 0, 2);
        world.setBlock(x + 2, y + 4, z + 4, placeEndStone(random), 0, 2);
        world.setBlock(x + 3, y + 4, z + 4, placeEndStone(random), 0, 2);
        world.setBlock(x + 4, y + 4, z + 4, placeEndStone(random), 0, 2);
        world.setBlock(x + 5, y + 4, z + 4, placeEndStone(random), 0, 2);
        world.setBlock(x + 6, y + 4, z + 4, placeEndStone(random), 0, 2);
        world.setBlock(x + 7, y + 4, z + 4, placeEndStone(random), 0, 2);
        world.setBlock(x + 8, y + 4, z + 4, placeEndStone(random), 0, 2);
        world.setBlock(x + 9, y + 4, z + 4, placeEndStone(random), 0, 2);
        world.setBlock(x + 10, y + 4, z + 4, placeEndStone(random), 0, 2);
        world.setBlock(x + 1, y + 4, z + 5, placeEndStone(random), 0, 2);
        world.setBlock(x + 2, y + 4, z + 5, placeEndStone(random), 0, 2);
        world.setBlock(x + 3, y + 4, z + 5, placeEndStone(random), 0, 2);
        world.setBlock(x + 4, y + 4, z + 5, placeEndStone(random), 0, 2);
        world.setBlock(x + 5, y + 4, z + 5, placeEndStone(random), 0, 2);
        world.setBlock(x + 6, y + 4, z + 5, placeEndStone(random), 0, 2);
        world.setBlock(x + 7, y + 4, z + 5, placeEndStone(random), 0, 2);
        world.setBlock(x + 8, y + 4, z + 5, placeEndStone(random), 0, 2);
        world.setBlock(x + 9, y + 4, z + 5, placeEndStone(random), 0, 2);
        world.setBlock(x + 10, y + 4, z + 5, placeEndStone(random), 0, 2);
        world.setBlock(x + 11, y + 4, z + 5, placeEndStone(random), 0, 2);
        world.setBlock(x, y + 4, z + 6, placeEndStone(random), 0, 2);
        world.setBlock(x + 1, y + 4, z + 6, placeEndStone(random), 0, 2);
        world.setBlock(x + 2, y + 4, z + 6, placeEndStone(random), 0, 2);
        world.setBlock(x + 3, y + 4, z + 6, placeEndStone(random), 0, 2);
        world.setBlock(x + 4, y + 4, z + 6, placeEndStone(random), 0, 2);
        world.setBlock(x + 5, y + 4, z + 6, placeEndStone(random), 0, 2);
        world.setBlock(x + 6, y + 4, z + 6, placeEndStone(random), 0, 2);
        world.setBlock(x + 7, y + 4, z + 6, placeEndStone(random), 0, 2);
        world.setBlock(x + 8, y + 4, z + 6, placeEndStone(random), 0, 2);
        world.setBlock(x + 9, y + 4, z + 6, placeEndStone(random), 0, 2);
        world.setBlock(x + 10, y + 4, z + 6, placeEndStoneBricks(random), 0, 2);
        world.setBlock(x + 11, y + 4, z + 6, placeEndStone(random), 0, 2);
        world.setBlock(x + 12, y + 4, z + 6, placeEndStone(random), 0, 2);
        world.setBlock(x + 1, y + 4, z + 7, placeEndStone(random), 0, 2);
        world.setBlock(x + 2, y + 4, z + 7, placeEndStone(random), 0, 2);
        world.setBlock(x + 3, y + 4, z + 7, placeEndStone(random), 0, 2);
        world.setBlock(x + 4, y + 4, z + 7, placeEndStone(random), 0, 2);
        world.setBlock(x + 5, y + 4, z + 7, placeEndStone(random), 0, 2);
        world.setBlock(x + 6, y + 4, z + 7, placeEndStone(random), 0, 2);
        world.setBlock(x + 7, y + 4, z + 7, placeEndStone(random), 0, 2);
        world.setBlock(x + 8, y + 4, z + 7, placeEndStone(random), 0, 2);
        world.setBlock(x + 9, y + 4, z + 7, placeEndStone(random), 0, 2);
        world.setBlock(x + 10, y + 4, z + 7, placeEndStone(random), 0, 2);
        world.setBlock(x + 11, y + 4, z + 7, placeEndStone(random), 0, 2);
        world.setBlock(x + 2, y + 4, z + 8, placeEndStone(random), 0, 2);
        world.setBlock(x + 3, y + 4, z + 8, placeEndStone(random), 0, 2);
        world.setBlock(x + 4, y + 4, z + 8, placeEndStone(random), 0, 2);
        world.setBlock(x + 5, y + 4, z + 8, placeEndStone(random), 0, 2);
        world.setBlock(x + 6, y + 4, z + 8, placeEndStone(random), 0, 2);
        world.setBlock(x + 7, y + 4, z + 8, placeEndStone(random), 0, 2);
        world.setBlock(x + 8, y + 4, z + 8, placeEndStoneBricks(random), 0, 2);
        world.setBlock(x + 9, y + 4, z + 8, placeEndStone(random), 0, 2);
        world.setBlock(x + 10, y + 4, z + 8, placeEndStone(random), 0, 2);
        world.setBlock(x + 3, y + 4, z + 9, placeEndStone(random), 0, 2);
        world.setBlock(x + 4, y + 4, z + 9, placeEndStone(random), 0, 2);
        world.setBlock(x + 5, y + 4, z + 9, placeEndStone(random), 0, 2);
        world.setBlock(x + 6, y + 4, z + 9, placeEndStone(random), 0, 2);
        world.setBlock(x + 7, y + 4, z + 9, placeEndStone(random), 0, 2);
        world.setBlock(x + 8, y + 4, z + 9, placeEndStone(random), 0, 2);
        world.setBlock(x + 9, y + 4, z + 9, placeEndStone(random), 0, 2);
        world.setBlock(x + 4, y + 4, z + 10, placeEndStone(random), 0, 2);
        world.setBlock(x + 5, y + 4, z + 10, placeEndStone(random), 0, 2);
        world.setBlock(x + 6, y + 4, z + 10, placeEndStone(random), 0, 2);
        world.setBlock(x + 7, y + 4, z + 10, placeEndStone(random), 0, 2);
        world.setBlock(x + 8, y + 4, z + 10, placeEndStone(random), 0, 2);
        world.setBlock(x + 5, y + 4, z + 11, placeEndStone(random), 0, 2);
        world.setBlock(x + 6, y + 4, z + 11, placeEndStone(random), 0, 2);
        world.setBlock(x + 7, y + 4, z + 11, placeEndStone(random), 0, 2);
        world.setBlock(x + 6, y + 4, z + 12, placeEndStone(random), 0, 2);
        world.setBlock(x + 6, y + 5, z, Blocks.obsidian, 0, 2);
        world.setBlock(x + 5, y + 5, z + 1, Blocks.obsidian, 0, 2);
        world.setBlock(x + 6, y + 5, z + 1, placeEndStoneBricks(random), 0, 2);
        world.setBlock(x + 7, y + 5, z + 1, Blocks.obsidian, 0, 2);
        world.setBlock(x + 4, y + 5, z + 2, Blocks.obsidian, 0, 2);
        world.setBlock(x + 5, y + 5, z + 2, placeEndStoneBricks(random), 0, 2);
        world.setBlock(x + 6, y + 5, z + 2, placeEndStoneBricks(random), 0, 2);
        world.setBlock(x + 7, y + 5, z + 2, placeEndStoneBricks(random), 0, 2);
        world.setBlock(x + 8, y + 5, z + 2, Blocks.obsidian, 0, 2);
        world.setBlock(x + 3, y + 5, z + 3, Blocks.obsidian, 0, 2);
        world.setBlock(x + 4, y + 5, z + 3, placeEndStoneBricks(random), 0, 2);
        world.setBlock(x + 5, y + 5, z + 3, placeEndStoneBricks(random), 0, 2);
        world.setBlock(x + 6, y + 5, z + 3, placeEndStoneBricks(random), 0, 2);
        world.setBlock(x + 7, y + 5, z + 3, placeEndStone(random), 0, 2);
        world.setBlock(x + 8, y + 5, z + 3, placeEndStone(random), 0, 2);
        world.setBlock(x + 9, y + 5, z + 3, Blocks.obsidian, 0, 2);
        world.setBlock(x + 2, y + 5, z + 4, Blocks.obsidian, 0, 2);
        world.setBlock(x + 3, y + 5, z + 4, placeEndStone(random), 0, 2);
        world.setBlock(x + 4, y + 5, z + 4, placeEndStoneBricks(random), 0, 2);
        world.setBlock(x + 5, y + 5, z + 4, placeEndStone(random), 0, 2);
        world.setBlock(x + 6, y + 5, z + 4, placeEndStone(random), 0, 2);
        world.setBlock(x + 7, y + 5, z + 4, placeEndStoneBricks(random), 0, 2);
        world.setBlock(x + 8, y + 5, z + 4, placeEndStone(random), 0, 2);
        world.setBlock(x + 9, y + 5, z + 4, placeEndStone(random), 0, 2);
        world.setBlock(x + 10, y + 5, z + 4, Blocks.obsidian, 0, 2);
        world.setBlock(x + 1, y + 5, z + 5, Blocks.obsidian, 0, 2);
        world.setBlock(x + 2, y + 5, z + 5, placeEndStoneBricks(random), 0, 2);
        world.setBlock(x + 3, y + 5, z + 5, placeEndStone(random), 0, 2);
        world.setBlock(x + 4, y + 5, z + 5, placeEndStoneBricks(random), 0, 2);
        world.setBlock(x + 5, y + 5, z + 5, placeEndStoneBricks(random), 0, 2);
        world.setBlock(x + 6, y + 5, z + 5, Blocks.obsidian, 0, 2);
        world.setBlock(x + 7, y + 5, z + 5, placeEndStone(random), 0, 2);
        world.setBlock(x + 8, y + 5, z + 5, placeEndStoneBricks(random), 0, 2);
        world.setBlock(x + 9, y + 5, z + 5, placeEndStoneBricks(random), 0, 2);
        world.setBlock(x + 10, y + 5, z + 5, placeEndStoneBricks(random), 0, 2);
        world.setBlock(x + 11, y + 5, z + 5, Blocks.obsidian, 0, 2);
        world.setBlock(x, y + 5, z + 6, Blocks.obsidian, 0, 2);
        world.setBlock(x + 1, y + 5, z + 6, placeEndStoneBricks(random), 0, 2);
        world.setBlock(x + 2, y + 5, z + 6, placeEndStoneBricks(random), 0, 2);
        world.setBlock(x + 3, y + 5, z + 6, placeEndStoneBricks(random), 0, 2);
        world.setBlock(x + 4, y + 5, z + 6, placeEndStoneBricks(random), 0, 2);
        world.setBlock(x + 5, y + 5, z + 6, Blocks.obsidian, 0, 2);
        world.setBlock(x + 6, y + 5, z + 6, placeEndStone(random), 0, 2);
        world.setBlock(x + 7, y + 5, z + 6, Blocks.obsidian, 0, 2);
        world.setBlock(x + 8, y + 5, z + 6, placeEndStoneBricks(random), 0, 2);
        world.setBlock(x + 9, y + 5, z + 6, placeEndStone(random), 0, 2);
        world.setBlock(x + 10, y + 5, z + 6, placeEndStoneBricks(random), 0, 2);
        world.setBlock(x + 11, y + 5, z + 6, placeEndStoneBricks(random), 0, 2);
        world.setBlock(x + 12, y + 5, z + 6, Blocks.obsidian, 0, 2);
        world.setBlock(x + 1, y + 5, z + 7, Blocks.obsidian, 0, 2);
        world.setBlock(x + 2, y + 5, z + 7, placeEndStoneBricks(random), 0, 2);
        world.setBlock(x + 3, y + 5, z + 7, placeEndStone(random), 0, 2);
        world.setBlock(x + 4, y + 5, z + 7, placeEndStone(random), 0, 2);
        world.setBlock(x + 5, y + 5, z + 7, placeEndStoneBricks(random), 0, 2);
        world.setBlock(x + 6, y + 5, z + 7, Blocks.obsidian, 0, 2);
        world.setBlock(x + 7, y + 5, z + 7, placeEndStoneBricks(random), 0, 2);
        world.setBlock(x + 8, y + 5, z + 7, placeEndStoneBricks(random), 0, 2);
        world.setBlock(x + 9, y + 5, z + 7, placeEndStoneBricks(random), 0, 2);
        world.setBlock(x + 10, y + 5, z + 7, placeEndStoneBricks(random), 0, 2);
        world.setBlock(x + 11, y + 5, z + 7, Blocks.obsidian, 0, 2);
        world.setBlock(x + 2, y + 5, z + 8, Blocks.obsidian, 0, 2);
        world.setBlock(x + 3, y + 5, z + 8, placeEndStoneBricks(random), 0, 2);
        world.setBlock(x + 4, y + 5, z + 8, placeEndStoneBricks(random), 0, 2);
        world.setBlock(x + 5, y + 5, z + 8, placeEndStone(random), 0, 2);
        world.setBlock(x + 6, y + 5, z + 8, placeEndStone(random), 0, 2);
        world.setBlock(x + 7, y + 5, z + 8, placeEndStone(random), 0, 2);
        world.setBlock(x + 8, y + 5, z + 8, placeEndStoneBricks(random), 0, 2);
        world.setBlock(x + 9, y + 5, z + 8, placeEndStone(random), 0, 2);
        world.setBlock(x + 10, y + 5, z + 8, Blocks.obsidian, 0, 2);
        world.setBlock(x + 3, y + 5, z + 9, Blocks.obsidian, 0, 2);
        world.setBlock(x + 4, y + 5, z + 9, placeEndStone(random), 0, 2);
        world.setBlock(x + 5, y + 5, z + 9, placeEndStoneBricks(random), 0, 2);
        world.setBlock(x + 6, y + 5, z + 9, placeEndStoneBricks(random), 0, 2);
        world.setBlock(x + 7, y + 5, z + 9, placeEndStoneBricks(random), 0, 2);
        world.setBlock(x + 8, y + 5, z + 9, placeEndStoneBricks(random), 0, 2);
        world.setBlock(x + 9, y + 5, z + 9, Blocks.obsidian, 0, 2);
        world.setBlock(x + 4, y + 5, z + 10, Blocks.obsidian, 0, 2);
        world.setBlock(x + 5, y + 5, z + 10, placeEndStoneBricks(random), 0, 2);
        world.setBlock(x + 6, y + 5, z + 10, placeEndStoneBricks(random), 0, 2);
        world.setBlock(x + 7, y + 5, z + 10, placeEndStone(random), 0, 2);
        world.setBlock(x + 8, y + 5, z + 10, Blocks.obsidian, 0, 2);
        world.setBlock(x + 5, y + 5, z + 11, Blocks.obsidian, 0, 2);
        world.setBlock(x + 6, y + 5, z + 11, placeEndStoneBricks(random), 0, 2);
        world.setBlock(x + 7, y + 5, z + 11, Blocks.obsidian, 0, 2);
        world.setBlock(x + 6, y + 5, z + 12, Blocks.obsidian, 0, 2);
        world.setBlock(x + 6, y + 6, z + 1, placeEndStoneBrickWall(random), 0, 2);
        world.setBlock(x + 4, y + 6, z + 2, placeEndStoneBrickWall(random), 0, 2);
        world.setBlock(x + 8, y + 6, z + 2, placeEndStoneBrickWall(random), 0, 2);
        world.setBlock(x + 8, y + 6, z + 3, placeEndStoneBrickStairs(random), 0, 2);
        world.setBlock(x + 2, y + 6, z + 4, placeEndStoneBrickWall(random), 0, 2);
        world.setBlock(x + 3, y + 6, z + 4, placeEndStoneBrickStairs(random), 1, 2);
        world.setBlock(x + 5, y + 6, z + 4, placeEndStoneBrickWall(random), 0, 2);
        world.setBlock(x + 10, y + 6, z + 4, placeEndStoneBrickWall(random), 0, 2);
        world.setBlock(x + 10, y + 6, z + 5, placeEndStoneBrickStairs(random), 0, 2);
        world.setBlock(x + 1, y + 6, z + 6, placeEndStoneBrickWall(random), 0, 2);
        world.setBlock(x + 2, y + 6, z + 6, placeEndStoneBrickStairs(random), 1, 2);
        world.setBlock(x + 11, y + 6, z + 6, placeEndStoneBrickWall(random), 0, 2);
        world.setBlock(x + 4, y + 6, z + 7, placeEndStoneBrickWall(random), 0, 2);
        world.setBlock(x + 2, y + 6, z + 8, placeEndStoneBrickWall(random), 0, 2);
        world.setBlock(x + 6, y + 6, z + 8, placeEndStoneBrickStairs(random), 2, 2);
        world.setBlock(x + 10, y + 6, z + 8, placeEndStoneBrickStairs(random), 2, 2);
        world.setBlock(x + 4, y + 6, z + 9, placeEndStoneBrickStairs(random), 2, 2);
        world.setBlock(x + 4, y + 6, z + 10, placeEndStoneBrickWall(random), 0, 2);
        world.setBlock(x + 7, y + 6, z + 10, placeEndStoneBrickStairs(random), 2, 2);
        world.setBlock(x + 8, y + 6, z + 10, placeEndStoneBrickWall(random), 0, 2);
        world.setBlock(x + 6, y + 6, z + 11, placeEndStoneBrickWall(random), 0, 2);
        world.setBlock(x + 6, y + 7, z + 1, placeEndStoneBrickWall(random), 0, 2);
        world.setBlock(x + 1, y + 7, z + 6, placeEndStoneBrickWall(random), 0, 2);
        world.setBlock(x + 11, y + 7, z + 6, placeEndStoneBrickWall(random), 0, 2);
        world.setBlock(x + 8, y + 7, z + 10, placeEndStoneBrickWall(random), 0, 2);
        world.setBlock(x + 6, y + 7, z + 11, placeEndStoneBrickWall(random), 0, 2);
        world.setBlock(x + 6, y + 8, z + 1, placeEndStoneBrickWall(random), 0, 2);
        world.setBlock(x + 1, y + 8, z + 6, placeEndStoneBrickWall(random), 0, 2);
        world.setBlock(x + 11, y + 8, z + 6, placeEndStoneBrickWall(random), 0, 2);
        world.setBlock(x + 6, y + 8, z + 11, placeEndStoneBrickWall(random), 0, 2);
        world.setBlock(x + 6, y + 9, z + 1, placeEndStoneBrickWall(random), 0, 2);
        world.setBlock(x + 1, y + 9, z + 6, placeEndStoneBrickWall(random), 0, 2);
        world.setBlock(x + 11, y + 9, z + 6, placeEndStoneBrickWall(random), 0, 2);
        world.setBlock(x + 6, y + 9, z + 11, placeEndStoneBrickWall(random), 0, 2);
        world.setBlock(x + 6, y + 10, z + 1, placeEndStoneBrickWall(random), 0, 2);
        world.setBlock(x + 1, y + 10, z + 6, placeEndStoneBrickWall(random), 0, 2);
        world.setBlock(x + 6, y + 10, z + 6, placeEndStoneBrickWall(random), 0, 2);
        world.setBlock(x + 11, y + 10, z + 6, placeEndStoneBrickWall(random), 0, 2);
        world.setBlock(x + 6, y + 10, z + 11, placeEndStoneBrickWall(random), 0, 2);
        world.setBlock(x + 6, y + 11, z + 1, placeEndStoneBrickWall(random), 0, 2);
        world.setBlock(x + 1, y + 11, z + 6, placeEndStoneBrickWall(random), 0, 2);
        world.setBlock(x + 6, y + 11, z + 6, placeEndStoneBrickWall(random), 0, 2);
        world.setBlock(x + 11, y + 11, z + 6, placeEndStoneBrickWall(random), 0, 2);
        world.setBlock(x + 6, y + 11, z + 11, placeEndStoneBrickWall(random), 0, 2);
        world.setBlock(x + 6, y + 12, z + 1, placeEndStoneBrickWall(random), 0, 2);
        world.setBlock(x + 6, y + 12, z + 2, placeEndStoneBrickWall(random), 0, 2);
        world.setBlock(x + 1, y + 12, z + 6, placeEndStoneBrickWall(random), 0, 2);
        world.setBlock(x + 2, y + 12, z + 6, placeEndStoneBrickWall(random), 0, 2);
        world.setBlock(x + 6, y + 12, z + 6, placeEndStoneBrickWall(random), 0, 2);
        world.setBlock(x + 10, y + 12, z + 6, placeEndStoneBrickWall(random), 0, 2);
        world.setBlock(x + 11, y + 12, z + 6, placeEndStoneBrickWall(random), 0, 2);
        world.setBlock(x + 6, y + 12, z + 10, placeEndStoneBrickWall(random), 0, 2);
        world.setBlock(x + 6, y + 12, z + 11, placeEndStoneBrickWall(random), 0, 2);
        world.setBlock(x + 6, y + 13, z + 2, placeEndStoneBrickWall(random), 0, 2);
        world.setBlock(x + 6, y + 13, z + 3, placeEndStoneBrickWall(random), 0, 2);
        world.setBlock(x + 2, y + 13, z + 6, placeEndStoneBrickWall(random), 0, 2);
        world.setBlock(x + 3, y + 13, z + 6, placeEndStoneBrickWall(random), 0, 2);
        world.setBlock(x + 6, y + 13, z + 6, placeEndStoneBrickWall(random), 0, 2);
        world.setBlock(x + 9, y + 13, z + 6, placeEndStoneBrickWall(random), 0, 2);
        world.setBlock(x + 10, y + 13, z + 6, placeEndStoneBrickWall(random), 0, 2);
        world.setBlock(x + 6, y + 13, z + 9, placeEndStoneBrickWall(random), 0, 2);
        world.setBlock(x + 6, y + 13, z + 10, placeEndStoneBrickWall(random), 0, 2);
        world.setBlock(x + 4, y + 14, z + 3, placeEndStoneBrickWall(random), 0, 2);
        world.setBlock(x + 5, y + 14, z + 3, placeEndStoneBrickWall(random), 0, 2);
        world.setBlock(x + 6, y + 14, z + 3, placeEndStoneBrickWall(random), 0, 2);
        world.setBlock(x + 7, y + 14, z + 3, placeEndStoneBrickWall(random), 0, 2);
        world.setBlock(x + 8, y + 14, z + 3, placeEndStoneBrickWall(random), 0, 2);
        world.setBlock(x + 3, y + 14, z + 4, placeEndStoneBrickWall(random), 0, 2);
        world.setBlock(x + 4, y + 14, z + 4, placeEndStoneBrickWall(random), 0, 2);
        world.setBlock(x + 6, y + 14, z + 4, placeEndStoneBrickWall(random), 0, 2);
        world.setBlock(x + 8, y + 14, z + 4, placeEndStoneBrickWall(random), 0, 2);
        world.setBlock(x + 9, y + 14, z + 4, placeEndStoneBrickWall(random), 0, 2);
        world.setBlock(x + 3, y + 14, z + 5, placeEndStoneBrickWall(random), 0, 2);
        world.setBlock(x + 6, y + 14, z + 5, placeEndStoneBrickWall(random), 0, 2);
        world.setBlock(x + 9, y + 14, z + 5, placeEndStoneBrickWall(random), 0, 2);
        world.setBlock(x + 3, y + 14, z + 6, placeEndStoneBrickWall(random), 0, 2);
        world.setBlock(x + 4, y + 14, z + 6, placeEndStoneBrickWall(random), 0, 2);
        world.setBlock(x + 5, y + 14, z + 6, placeEndStoneBrickWall(random), 0, 2);
        world.setBlock(x + 6, y + 14, z + 6, placeEndStoneBrickWall(random), 0, 2);
        world.setBlock(x + 7, y + 14, z + 6, placeEndStoneBrickWall(random), 0, 2);
        world.setBlock(x + 8, y + 14, z + 6, placeEndStoneBrickWall(random), 0, 2);
        world.setBlock(x + 9, y + 14, z + 6, placeEndStoneBrickWall(random), 0, 2);
        world.setBlock(x + 3, y + 14, z + 7, placeEndStoneBrickWall(random), 0, 2);
        world.setBlock(x + 6, y + 14, z + 7, placeEndStoneBrickWall(random), 0, 2);
        world.setBlock(x + 9, y + 14, z + 7, placeEndStoneBrickWall(random), 0, 2);
        world.setBlock(x + 3, y + 14, z + 8, placeEndStoneBrickWall(random), 0, 2);
        world.setBlock(x + 4, y + 14, z + 8, placeEndStoneBrickWall(random), 0, 2);
        world.setBlock(x + 6, y + 14, z + 8, placeEndStoneBrickWall(random), 0, 2);
        world.setBlock(x + 8, y + 14, z + 8, placeEndStoneBrickWall(random), 0, 2);
        world.setBlock(x + 9, y + 14, z + 8, placeEndStoneBrickWall(random), 0, 2);
        world.setBlock(x + 4, y + 14, z + 9, placeEndStoneBrickWall(random), 0, 2);
        world.setBlock(x + 5, y + 14, z + 9, placeEndStoneBrickWall(random), 0, 2);
        world.setBlock(x + 6, y + 14, z + 9, placeEndStoneBrickWall(random), 0, 2);
        world.setBlock(x + 7, y + 14, z + 9, placeEndStoneBrickWall(random), 0, 2);
        world.setBlock(x + 8, y + 14, z + 9, placeEndStoneBrickWall(random), 0, 2);

        int center_block = random.nextInt(5);
        if (center_block <= 2 && ConfigsWorld.enableXanciumOre) {
            world.setBlock(x + 6, y + 6, z + 6, NovaCraftBlocks.xancium_ore, 0, 2);
        }
        else if (center_block == 3 && ConfigsWorld.enableKlangiteOre) {
            world.setBlock(x + 6, y + 6, z + 6, NovaCraftBlocks.klangite_ore, 0, 2);
        }
        else {
            world.setBlock(x + 6, y + 6, z + 6, NovaCraftBlocks.crystallized_end, 0, 2);
        }

        world.setBlock(x + 6, y + 9, z + 6, Blocks.mob_spawner, 0, 2);
        TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner)world.getTileEntity(x + 6, y + 9, z + 6);

        if (tileentitymobspawner != null && random.nextBoolean()) {
            tileentitymobspawner.func_145881_a().setEntityName("nova_craft.void_cube");
        }
         else {
            tileentitymobspawner.func_145881_a().setEntityName("nova_craft.void_entity");
        }

        this.setBlockAndNotifyAdequately(world, x + 6, y + 6, z + 10, Blocks.chest, 2);
        TileEntity tile = world.getTileEntity(x + 6, y + 6, z + 10);
        if (tile instanceof TileEntityChest) {
            TileEntityChest chest = (TileEntityChest) tile;

            for (int slot = 0; slot < 3 + random.nextInt(20); slot++) {
                chest.setInventorySlotContents(random.nextInt(chest.getSizeInventory()), this.getEndLoot(random));
            }
        }

        this.setBlockAndNotifyAdequately(world, x + 6, y + 6, z + 2, Blocks.chest, 3);
        TileEntity tile2 = world.getTileEntity(x + 6, y + 6, z + 2);
        if (tile2 instanceof TileEntityChest) {
            TileEntityChest chest2 = (TileEntityChest) tile2;

            for (int slot = 0; slot < 3 + random.nextInt(20); slot++) {
                chest2.setInventorySlotContents(random.nextInt(chest2.getSizeInventory()), this.getOverworldLoot(random));
            }
        }

        return true;
    }

    private static Block placeEndStone(Random random) {
        if (random.nextDouble() < 0.95) {
            return Blocks.end_stone;
        } else {
            return Blocks.air;
        }
    }

    private static Block placeEndStoneBricks(Random random) {
        try {
            Block end_bricks = GameRegistry.findBlock("etfuturum", "end_bricks");
            if (end_bricks != null ) {
                return end_bricks;
            }
        } catch (Exception ex) {
            return NovaCraftBlocks.frontierslate_bricks;
        }
        return NovaCraftBlocks.frontierslate_bricks;
    }

    private static Block placeEndStoneBrickWall(Random random) {
        if (random.nextDouble() < 0.99) {
            try {
                Block end_brick_wall = GameRegistry.findBlock("etfuturum", "end_brick_wall");
                if (end_brick_wall != null) {
                    return end_brick_wall;
                }
            } catch (Exception ex) {
                return NovaCraftBlocks.frontierslate_brick_wall;
            }
        } else {
            return Blocks.air;
        }

        return NovaCraftBlocks.frontierslate_brick_wall;
    }

    private static Block placeEndStoneBrickStairs(Random random) {
        if (random.nextDouble() < 0.65) {
            try {
                Block end_brick_stairs = GameRegistry.findBlock("etfuturum", "end_brick_stairs");
                if (end_brick_stairs != null) {
                    return end_brick_stairs;
                }
            } catch (Exception ex) {
                return NovaCraftBlocks.frontierslate_stairs;
            }
        } else {
            return Blocks.air;
        }

        return NovaCraftBlocks.frontierslate_stairs;
    }

    private ItemStack getEndLoot(Random random) {
        int item = random.nextInt(29);
        switch (item) {
            case 0:
                return new ItemStack(NovaCraftItems.small_xancium_dust, random.nextInt(15) + 8);
            case 1:
                return new ItemStack(Items.ender_pearl, random.nextInt(4) + 6);
            case 2:
                return new ItemStack(Items.ender_pearl, random.nextInt(3) + 9);
            case 3:
                return new ItemStack(NovaCraftItems.vanite_bucket, random.nextInt(2) + 1);
            case 4:
                return new ItemStack(NovaCraftItems.static_essence, random.nextInt(6) + 4);
            case 5:
                return new ItemStack(NovaCraftItems.destitute_tentacle, 1);
            case 6:
                return new ItemStack(NovaCraftItems.crystallized_end_shard, 1);
            case 7:
                return new ItemStack(NovaCraftItems.anomalous_essence, random.nextInt(6) + 2);
            case 8:
                return new ItemStack(NovaCraftItems.tsavorokite_shard, random.nextInt(2) + 1);
            case 9:
                Enchantment enchantment = Enchantment.enchantmentsBookList[random.nextInt(Enchantment.enchantmentsBookList.length)];

                int minLevel = enchantment.getMinLevel();
                int maxLevel = enchantment.getMaxLevel();
                int level = MathHelper.getRandomIntegerInRange(random, minLevel, maxLevel);
                ItemStack itemStack = Items.enchanted_book.getEnchantedItemStack(new EnchantmentData(enchantment, maxLevel));

                return itemStack;
            case 10:
                Enchantment enchantment2 = Enchantment.enchantmentsBookList[random.nextInt(Enchantment.enchantmentsBookList.length)];

                int minLevel2 = enchantment2.getMinLevel();
                int maxLevel2 = enchantment2.getMaxLevel();
                int level2 = MathHelper.getRandomIntegerInRange(random, minLevel2, maxLevel2);
                ItemStack itemStack2 = Items.enchanted_book.getEnchantedItemStack(new EnchantmentData(enchantment2, maxLevel2));

                return itemStack2;

            case 11:
                return new ItemStack(NovaCraftItems.copartz_shard, random.nextInt(2) + 1);
            case 12:
                return new ItemStack(NovaCraftItems.larimar_shard, random.nextInt(2) + 1);
            case 13:
                return new ItemStack(Items.experience_bottle, random.nextInt(4) + 3);
            case 14:
                return new ItemStack(Items.iron_ingot, random.nextInt(2) + 3);
            case 15:
                return new ItemStack(Items.gold_ingot, random.nextInt(2) + 3);
            case 16:
                return new ItemStack(NovaCraftItems.vanite_ingot, random.nextInt(3) + 3);
            case 17:
                return new ItemStack(Items.golden_apple, 1, 0);
            case 18:
                return new ItemStack(NovaCraftItems.relik_dust, random.nextInt(2) + 1);
            case 19:
                return new ItemStack(Items.ender_eye, random.nextInt(3) + 1);
            case 20:
                return new ItemStack(NovaCraftBlocks.frontierslate, random.nextInt(40) + 24);
            case 21:
                return new ItemStack(Blocks.end_stone, random.nextInt(40) + 24);
            case 22:
                return new ItemStack(Blocks.obsidian, random.nextInt(12) + 1);
            case 23:
                return new ItemStack(NovaCraftItems.iridium_nugget, random.nextInt(2) + 1, 2);
            default: {
                return new ItemStack(Blocks.end_stone, random.nextInt(40) + 24);
            }
        }
    }


    private ItemStack getOverworldLoot(Random random) {
        int item = random.nextInt(28);
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

}
