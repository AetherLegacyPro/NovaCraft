package com.NovaCraft.world.structure;

import static net.minecraftforge.common.ChestGenHooks.DUNGEON_CHEST;

import java.util.Random;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.config.Configs;
import com.NovaCraft.registry.OtherModBlocks;
import com.NovaCraftBlocks.NovaCraftBlocks;

import net.minecraft.block.Block;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagFloat;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.MobSpawnerBaseLogic;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.ChestGenHooks;

public class NovaCraftAdvancedTraditionalDungeonGen extends WorldGenerator {
	
	
	public NovaCraftAdvancedTraditionalDungeonGen() {

	}
	
	private static final Block cobbled_deepslate = OtherModBlocks.cobbled_deepslate;
	
	private Block PlaceCobbledDeepslate;
	
	private Block determineIfCobbledDeepslateExists(World world, int x, int y, int z) {
        Block existingBlock = world.getBlock(x, y, z);

        if (existingBlock == null || existingBlock != cobbled_deepslate) {
            return NovaCraftBlocks.cobbled_nullstone;
        } else {
            return cobbled_deepslate;
        }
    }
	
	public boolean generate(final World world, final Random random, final int i, final int j, final int k) {
		PlaceCobbledDeepslate = determineIfCobbledDeepslateExists(world, i + 0, j + 0, k + 0);
		
		int randore = (int)(1 + Math.random() * 75);
	 	if (randore <= 25) {
	 		world.setBlock(i + 1, j + 0, k + 0, NovaCraftBlocks.nullstone_diamond, 0, 2);
	 		world.setBlock(i + 2, j + 0, k + 0, NovaCraftBlocks.nullstone_emerald, 0, 2);
	 		world.setBlock(i + 4, j + 0, k + 0, NovaCraftBlocks.nullstone_emerald, 0, 2);
	 		world.setBlock(i + 8, j + 0, k + 0, NovaCraftBlocks.nullstone_emerald, 0, 2);
	 		world.setBlock(i + 10, j + 0, k + 0, NovaCraftBlocks.nullstone_emerald, 0, 2);
	 		world.setBlock(i + 1, j + 0, k + 1, NovaCraftBlocks.nullstone_emerald, 0, 2);
			world.setBlock(i + 8, j + 0, k + 1, NovaCraftBlocks.nullstone_emerald, 0, 2);
			world.setBlock(i + 9, j + 0, k + 1, NovaCraftBlocks.nullstone_diamond, 0, 2);
			world.setBlock(i + 2, j + 0, k + 2, NovaCraftBlocks.nullstone_emerald, 0, 2);
			world.setBlock(i + 3, j + 0, k + 2, NovaCraftBlocks.nullstone_emerald, 0, 2);
			world.setBlock(i + 5, j + 0, k + 2, NovaCraftBlocks.nullstone_emerald, 0, 2);
			world.setBlock(i + 6, j + 0, k + 2, NovaCraftBlocks.nullstone_emerald, 0, 2);
			world.setBlock(i + 9, j + 0, k + 2, NovaCraftBlocks.nullstone_diamond, 0, 2);
			world.setBlock(i + 1, j + 0, k + 3, NovaCraftBlocks.nullstone_emerald, 0, 2);
			world.setBlock(i + 4, j + 0, k + 3, NovaCraftBlocks.nullstone_emerald, 0, 2);
			world.setBlock(i + 5, j + 0, k + 3, NovaCraftBlocks.nullstone_emerald, 0, 2);
			world.setBlock(i + 6, j + 0, k + 3, NovaCraftBlocks.nullstone_emerald, 0, 2);
			world.setBlock(i + 10, j + 0, k + 3, NovaCraftBlocks.nullstone_emerald, 0, 2);
			world.setBlock(i + 6, j + 0, k + 4, NovaCraftBlocks.nullstone_emerald, 0, 2);
			world.setBlock(i + 9, j + 0, k + 4, NovaCraftBlocks.nullstone_emerald, 0, 2);
			world.setBlock(i + 3, j + 0, k + 5, NovaCraftBlocks.nullstone_emerald, 0, 2);
			world.setBlock(i + 4, j + 0, k + 5, NovaCraftBlocks.nullstone_diamond, 0, 2);
			world.setBlock(i + 8, j + 0, k + 5, NovaCraftBlocks.nullstone_emerald, 0, 2);
			world.setBlock(i + 1, j + 0, k + 6, NovaCraftBlocks.nullstone_emerald, 0, 2);
			world.setBlock(i + 2, j + 0, k + 6, NovaCraftBlocks.nullstone_emerald, 0, 2);
			world.setBlock(i + 4, j + 0, k + 6, NovaCraftBlocks.nullstone_emerald, 0, 2);
			world.setBlock(i + 2, j + 0, k + 7, NovaCraftBlocks.nullstone_emerald, 0, 2);
			world.setBlock(i + 5, j + 0, k + 7, NovaCraftBlocks.nullstone_emerald, 0, 2);
			world.setBlock(i + 6, j + 0, k + 7, NovaCraftBlocks.nullstone_emerald, 0, 2);
			world.setBlock(i + 9, j + 0, k + 7, NovaCraftBlocks.nullstone_diamond, 0, 2);
			world.setBlock(i + 2, j + 0, k + 8, NovaCraftBlocks.nullstone_diamond, 0, 2);
			world.setBlock(i + 3, j + 0, k + 8, NovaCraftBlocks.nullstone_emerald, 0, 2);
			world.setBlock(i + 5, j + 0, k + 8, NovaCraftBlocks.nullstone_emerald, 0, 2);
			world.setBlock(i + 6, j + 0, k + 8, NovaCraftBlocks.nullstone_emerald, 0, 2);
			world.setBlock(i + 1, j + 0, k + 9, NovaCraftBlocks.nullstone_emerald, 0, 2);
			world.setBlock(i + 3, j + 0, k + 9, NovaCraftBlocks.nullstone_emerald, 0, 2);
			world.setBlock(i + 7, j + 0, k + 9, NovaCraftBlocks.nullstone_emerald, 0, 2);
			world.setBlock(i + 10, j + 0, k + 9, NovaCraftBlocks.nullstone_diamond, 0, 2);
			world.setBlock(i + 2, j + 0, k + 10, NovaCraftBlocks.nullstone_emerald, 0, 2);
			world.setBlock(i + 3, j + 0, k + 10, NovaCraftBlocks.nullstone_emerald, 0, 2);
			world.setBlock(i + 9, j + 0, k + 10, NovaCraftBlocks.nullstone_emerald, 0, 2);
			world.setBlock(i + 0, j + 0, k + 11, NovaCraftBlocks.nullstone_diamond, 0, 2);
			world.setBlock(i + 5, j + 0, k + 11, NovaCraftBlocks.nullstone_emerald, 0, 2);
			world.setBlock(i + 7, j + 0, k + 11, NovaCraftBlocks.nullstone_emerald, 0, 2);
			world.setBlock(i + 3, j + 0, k + 12, NovaCraftBlocks.nullstone_emerald, 0, 2);
	 	} else if (randore > 25 && randore <= 50) {
	 		world.setBlock(i + 1, j + 0, k + 0, NovaCraftBlocks.nullstone_iron, 0, 2);
			world.setBlock(i + 2, j + 0, k + 0, NovaCraftBlocks.nullstone_iron, 0, 2);
			world.setBlock(i + 4, j + 0, k + 0, NovaCraftBlocks.nullstone_iron, 0, 2);
			world.setBlock(i + 8, j + 0, k + 0, NovaCraftBlocks.nullstone_iron, 0, 2);
			world.setBlock(i + 10, j + 0, k + 0, NovaCraftBlocks.nullstone_iron, 0, 2);
			world.setBlock(i + 1, j + 0, k + 1, NovaCraftBlocks.nullstone_iron, 0, 2);
			world.setBlock(i + 8, j + 0, k + 1, NovaCraftBlocks.nullstone_iron, 0, 2);
			world.setBlock(i + 9, j + 0, k + 1, NovaCraftBlocks.nullstone_iron, 0, 2);
			world.setBlock(i + 2, j + 0, k + 2, NovaCraftBlocks.nullstone_iron, 0, 2);
			world.setBlock(i + 3, j + 0, k + 2, NovaCraftBlocks.nullstone_iron, 0, 2);
			world.setBlock(i + 5, j + 0, k + 2, NovaCraftBlocks.nullstone_iron, 0, 2);
			world.setBlock(i + 6, j + 0, k + 2, NovaCraftBlocks.nullstone_iron, 0, 2);
			world.setBlock(i + 9, j + 0, k + 2, NovaCraftBlocks.nullstone_iron, 0, 2);
			world.setBlock(i + 1, j + 0, k + 3, NovaCraftBlocks.nullstone_iron, 0, 2);
			world.setBlock(i + 4, j + 0, k + 3, NovaCraftBlocks.nullstone_iron, 0, 2);
			world.setBlock(i + 5, j + 0, k + 3, NovaCraftBlocks.nullstone_iron, 0, 2);
			world.setBlock(i + 6, j + 0, k + 3, NovaCraftBlocks.nullstone_iron, 0, 2);
			world.setBlock(i + 10, j + 0, k + 3, NovaCraftBlocks.nullstone_iron, 0, 2);
			world.setBlock(i + 6, j + 0, k + 4, NovaCraftBlocks.nullstone_iron, 0, 2);
			world.setBlock(i + 9, j + 0, k + 4, NovaCraftBlocks.nullstone_iron, 0, 2);
			world.setBlock(i + 3, j + 0, k + 5, NovaCraftBlocks.nullstone_iron, 0, 2);
			world.setBlock(i + 4, j + 0, k + 5, NovaCraftBlocks.nullstone_iron, 0, 2);
			world.setBlock(i + 8, j + 0, k + 5, NovaCraftBlocks.nullstone_iron, 0, 2);
			world.setBlock(i + 1, j + 0, k + 6, NovaCraftBlocks.nullstone_iron, 0, 2);
			world.setBlock(i + 2, j + 0, k + 6, NovaCraftBlocks.nullstone_iron, 0, 2);
			world.setBlock(i + 4, j + 0, k + 6, NovaCraftBlocks.nullstone_iron, 0, 2);
			world.setBlock(i + 2, j + 0, k + 7, NovaCraftBlocks.nullstone_iron, 0, 2);
			world.setBlock(i + 5, j + 0, k + 7, NovaCraftBlocks.nullstone_iron, 0, 2);
			world.setBlock(i + 6, j + 0, k + 7, NovaCraftBlocks.nullstone_iron, 0, 2);
			world.setBlock(i + 9, j + 0, k + 7, NovaCraftBlocks.nullstone_iron, 0, 2);
			world.setBlock(i + 2, j + 0, k + 8, NovaCraftBlocks.nullstone_iron, 0, 2);
			world.setBlock(i + 3, j + 0, k + 8, NovaCraftBlocks.nullstone_iron, 0, 2);
			world.setBlock(i + 5, j + 0, k + 8, NovaCraftBlocks.nullstone_iron, 0, 2);
			world.setBlock(i + 6, j + 0, k + 8, NovaCraftBlocks.nullstone_iron, 0, 2);
			world.setBlock(i + 1, j + 0, k + 9, NovaCraftBlocks.nullstone_iron, 0, 2);
			world.setBlock(i + 3, j + 0, k + 9, NovaCraftBlocks.nullstone_iron, 0, 2);
			world.setBlock(i + 7, j + 0, k + 9, NovaCraftBlocks.nullstone_iron, 0, 2);
			world.setBlock(i + 10, j + 0, k + 9, NovaCraftBlocks.nullstone_iron, 0, 2);
			world.setBlock(i + 2, j + 0, k + 10, NovaCraftBlocks.nullstone_iron, 0, 2);
			world.setBlock(i + 3, j + 0, k + 10, NovaCraftBlocks.nullstone_iron, 0, 2);
			world.setBlock(i + 9, j + 0, k + 10, NovaCraftBlocks.nullstone_iron, 0, 2);
			world.setBlock(i + 0, j + 0, k + 11, NovaCraftBlocks.nullstone_iron, 0, 2);
			world.setBlock(i + 5, j + 0, k + 11, NovaCraftBlocks.nullstone_iron, 0, 2);
			world.setBlock(i + 7, j + 0, k + 11, NovaCraftBlocks.nullstone_iron, 0, 2);
			world.setBlock(i + 3, j + 0, k + 12, NovaCraftBlocks.nullstone_iron, 0, 2);
	 	} else if (randore > 50 && randore <= 75) {
	 		world.setBlock(i + 1, j + 0, k + 0, NovaCraftBlocks.nullstone_gold, 0, 2);
			world.setBlock(i + 2, j + 0, k + 0, NovaCraftBlocks.nullstone_gold, 0, 2);
			world.setBlock(i + 4, j + 0, k + 0, NovaCraftBlocks.nullstone_gold, 0, 2);
			world.setBlock(i + 8, j + 0, k + 0, NovaCraftBlocks.nullstone_gold, 0, 2);
			world.setBlock(i + 10, j + 0, k + 0, NovaCraftBlocks.nullstone_gold, 0, 2);
			world.setBlock(i + 1, j + 0, k + 1, NovaCraftBlocks.nullstone_gold, 0, 2);
			world.setBlock(i + 8, j + 0, k + 1, NovaCraftBlocks.nullstone_gold, 0, 2);
			world.setBlock(i + 9, j + 0, k + 1, NovaCraftBlocks.nullstone_gold, 0, 2);
			world.setBlock(i + 2, j + 0, k + 2, NovaCraftBlocks.nullstone_gold, 0, 2);
			world.setBlock(i + 3, j + 0, k + 2, NovaCraftBlocks.nullstone_gold, 0, 2);
			world.setBlock(i + 5, j + 0, k + 2, NovaCraftBlocks.nullstone_gold, 0, 2);
			world.setBlock(i + 6, j + 0, k + 2, NovaCraftBlocks.nullstone_gold, 0, 2);
			world.setBlock(i + 9, j + 0, k + 2, NovaCraftBlocks.nullstone_gold, 0, 2);
			world.setBlock(i + 1, j + 0, k + 3, NovaCraftBlocks.nullstone_gold, 0, 2);
			world.setBlock(i + 4, j + 0, k + 3, NovaCraftBlocks.nullstone_gold, 0, 2);
			world.setBlock(i + 5, j + 0, k + 3, NovaCraftBlocks.nullstone_gold, 0, 2);
			world.setBlock(i + 6, j + 0, k + 3, NovaCraftBlocks.nullstone_gold, 0, 2);
			world.setBlock(i + 10, j + 0, k + 3, NovaCraftBlocks.nullstone_gold, 0, 2);
			world.setBlock(i + 6, j + 0, k + 4, NovaCraftBlocks.nullstone_gold, 0, 2);
			world.setBlock(i + 9, j + 0, k + 4, NovaCraftBlocks.nullstone_gold, 0, 2);
			world.setBlock(i + 3, j + 0, k + 5, NovaCraftBlocks.nullstone_gold, 0, 2);
			world.setBlock(i + 4, j + 0, k + 5, NovaCraftBlocks.nullstone_gold, 0, 2);
			world.setBlock(i + 8, j + 0, k + 5, NovaCraftBlocks.nullstone_gold, 0, 2);
			world.setBlock(i + 1, j + 0, k + 6, NovaCraftBlocks.nullstone_gold, 0, 2);
			world.setBlock(i + 2, j + 0, k + 6, NovaCraftBlocks.nullstone_gold, 0, 2);
			world.setBlock(i + 4, j + 0, k + 6, NovaCraftBlocks.nullstone_gold, 0, 2);
			world.setBlock(i + 2, j + 0, k + 7, NovaCraftBlocks.nullstone_gold, 0, 2);
			world.setBlock(i + 5, j + 0, k + 7, NovaCraftBlocks.nullstone_gold, 0, 2);
			world.setBlock(i + 6, j + 0, k + 7, NovaCraftBlocks.nullstone_gold, 0, 2);
			world.setBlock(i + 9, j + 0, k + 7, NovaCraftBlocks.nullstone_gold, 0, 2);
			world.setBlock(i + 2, j + 0, k + 8, NovaCraftBlocks.nullstone_gold, 0, 2);
			world.setBlock(i + 3, j + 0, k + 8, NovaCraftBlocks.nullstone_gold, 0, 2);
			world.setBlock(i + 5, j + 0, k + 8, NovaCraftBlocks.nullstone_gold, 0, 2);
			world.setBlock(i + 6, j + 0, k + 8, NovaCraftBlocks.nullstone_gold, 0, 2);
			world.setBlock(i + 1, j + 0, k + 9, NovaCraftBlocks.nullstone_gold, 0, 2);
			world.setBlock(i + 3, j + 0, k + 9, NovaCraftBlocks.nullstone_gold, 0, 2);
			world.setBlock(i + 7, j + 0, k + 9, NovaCraftBlocks.nullstone_gold, 0, 2);
			world.setBlock(i + 10, j + 0, k + 9, NovaCraftBlocks.nullstone_gold, 0, 2);
			world.setBlock(i + 2, j + 0, k + 10, NovaCraftBlocks.nullstone_gold, 0, 2);
			world.setBlock(i + 3, j + 0, k + 10, NovaCraftBlocks.nullstone_gold, 0, 2);
			world.setBlock(i + 9, j + 0, k + 10, NovaCraftBlocks.nullstone_gold, 0, 2);
			world.setBlock(i + 0, j + 0, k + 11, NovaCraftBlocks.nullstone_gold, 0, 2);
			world.setBlock(i + 5, j + 0, k + 11, NovaCraftBlocks.nullstone_gold, 0, 2);
			world.setBlock(i + 7, j + 0, k + 11, NovaCraftBlocks.nullstone_gold, 0, 2);
			world.setBlock(i + 3, j + 0, k + 12, NovaCraftBlocks.nullstone_gold, 0, 2);
	 	}
		
		world.setBlock(i + 0, j + 0, k + 0, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 3, j + 0, k + 0, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 5, j + 0, k + 0, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 6, j + 0, k + 0, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 7, j + 0, k + 0, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 9, j + 0, k + 0, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 0, j + 0, k + 1, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 2, j + 0, k + 1, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 3, j + 0, k + 1, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 4, j + 0, k + 1, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 5, j + 0, k + 1, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 6, j + 0, k + 1, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 7, j + 0, k + 1, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 10, j + 0, k + 1, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 0, j + 0, k + 2, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 1, j + 0, k + 2, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 4, j + 0, k + 2, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 7, j + 0, k + 2, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 8, j + 0, k + 2, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 10, j + 0, k + 2, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 0, j + 0, k + 3, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 2, j + 0, k + 3, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 3, j + 0, k + 3, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 7, j + 0, k + 3, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 8, j + 0, k + 3, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 9, j + 0, k + 3, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 0, j + 0, k + 4, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 1, j + 0, k + 4, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 2, j + 0, k + 4, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 3, j + 0, k + 4, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 4, j + 0, k + 4, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 5, j + 0, k + 4, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 7, j + 0, k + 4, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 8, j + 0, k + 4, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 10, j + 0, k + 4, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 0, j + 0, k + 5, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 1, j + 0, k + 5, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 2, j + 0, k + 5, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 5, j + 0, k + 5, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 6, j + 0, k + 5, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 7, j + 0, k + 5, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 9, j + 0, k + 5, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 10, j + 0, k + 5, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 0, j + 0, k + 6, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 3, j + 0, k + 6, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 5, j + 0, k + 6, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 6, j + 0, k + 6, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 7, j + 0, k + 6, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 8, j + 0, k + 6, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 9, j + 0, k + 6, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 10, j + 0, k + 6, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 0, j + 0, k + 7, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 1, j + 0, k + 7, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 3, j + 0, k + 7, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 4, j + 0, k + 7, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 7, j + 0, k + 7, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 8, j + 0, k + 7, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 10, j + 0, k + 7, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 0, j + 0, k + 8, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 1, j + 0, k + 8, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 4, j + 0, k + 8, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 7, j + 0, k + 8, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 8, j + 0, k + 8, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 9, j + 0, k + 8, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 10, j + 0, k + 8, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 0, j + 0, k + 9, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 2, j + 0, k + 9, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 4, j + 0, k + 9, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 5, j + 0, k + 9, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 6, j + 0, k + 9, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 8, j + 0, k + 9, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 9, j + 0, k + 9, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 0, j + 0, k + 10, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 1, j + 0, k + 10, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 4, j + 0, k + 10, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 5, j + 0, k + 10, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 6, j + 0, k + 10, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 7, j + 0, k + 10, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 8, j + 0, k + 10, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 10, j + 0, k + 10, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 1, j + 0, k + 11, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 2, j + 0, k + 11, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 3, j + 0, k + 11, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 4, j + 0, k + 11, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 6, j + 0, k + 11, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 8, j + 0, k + 11, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 9, j + 0, k + 11, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 10, j + 0, k + 11, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 0, j + 0, k + 12, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 1, j + 0, k + 12, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 2, j + 0, k + 12, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 4, j + 0, k + 12, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 5, j + 0, k + 12, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 6, j + 0, k + 12, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 7, j + 0, k + 12, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 8, j + 0, k + 12, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 9, j + 0, k + 12, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 10, j + 0, k + 12, PlaceCobbledDeepslate, 0, 2);
		world.setBlock(i + 0, j + 1, k + 0, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 1, j + 1, k + 0, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 2, j + 1, k + 0, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 3, j + 1, k + 0, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 4, j + 1, k + 0, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 5, j + 1, k + 0, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 6, j + 1, k + 0, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 7, j + 1, k + 0, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 8, j + 1, k + 0, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 9, j + 1, k + 0, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 10, j + 1, k + 0, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 0, j + 1, k + 1, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 1, j + 1, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 1, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 1, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 1, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 1, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 1, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 1, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 1, k + 1, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 0, j + 1, k + 2, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 1, j + 1, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 1, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 1, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 1, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 1, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 1, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 1, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 1, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 1, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 1, k + 2, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 0, j + 1, k + 3, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 1, j + 1, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 1, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 1, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 1, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 1, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 1, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 1, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 1, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 1, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 1, k + 3, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 0, j + 1, k + 4, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 1, j + 1, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 1, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 1, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 1, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 1, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 1, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 1, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 1, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 1, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 1, k + 4, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 0, j + 1, k + 5, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 2, j + 1, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 1, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 1, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 1, k + 5, NovaCraftBlocks.vanite_glass, 0, 2);
		world.setBlock(i + 6, j + 1, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 1, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 1, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 1, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 1, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 1, k + 6, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 1, j + 1, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 1, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 1, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 1, k + 6, NovaCraftBlocks.vanite_glass, 0, 2);
		world.setBlock(i + 6, j + 1, k + 6, NovaCraftBlocks.vanite_glass, 0, 2);
		world.setBlock(i + 7, j + 1, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 1, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 1, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 1, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 1, k + 7, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 1, j + 1, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 1, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 1, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 1, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 1, k + 7, NovaCraftBlocks.vanite_glass, 0, 2);
		world.setBlock(i + 6, j + 1, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 1, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 1, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 1, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 1, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 1, k + 8, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 1, j + 1, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 1, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 1, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 1, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 1, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 1, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 1, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 1, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 1, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 1, k + 8, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 0, j + 1, k + 9, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 1, j + 1, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 1, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 1, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 1, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 1, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 1, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 1, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 1, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 1, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 1, k + 9, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 0, j + 1, k + 10, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 1, j + 1, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 1, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 1, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 1, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 1, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 1, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 1, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 1, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 1, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 1, k + 10, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 0, j + 1, k + 11, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 1, j + 1, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 1, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 1, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 1, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 1, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 1, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 1, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 1, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 1, k + 11, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 0, j + 1, k + 12, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 1, j + 1, k + 12, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 2, j + 1, k + 12, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 3, j + 1, k + 12, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 4, j + 1, k + 12, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 5, j + 1, k + 12, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 6, j + 1, k + 12, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 7, j + 1, k + 12, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 8, j + 1, k + 12, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 9, j + 1, k + 12, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 10, j + 1, k + 12, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 0, j + 2, k + 0, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 1, j + 2, k + 0, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 2, j + 2, k + 0, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 3, j + 2, k + 0, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 4, j + 2, k + 0, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 5, j + 2, k + 0, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 6, j + 2, k + 0, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 7, j + 2, k + 0, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 8, j + 2, k + 0, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 9, j + 2, k + 0, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 10, j + 2, k + 0, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 0, j + 2, k + 1, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 1, j + 2, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 2, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 2, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 2, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 2, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 2, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 2, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 2, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 2, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 2, k + 1, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 0, j + 2, k + 2, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 1, j + 2, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 2, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 2, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 2, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 2, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 2, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 2, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 2, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 2, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 2, k + 2, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 0, j + 2, k + 3, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 1, j + 2, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 2, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 2, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 2, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 2, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 2, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 2, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 2, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 2, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 2, k + 3, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 0, j + 2, k + 4, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 1, j + 2, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 2, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 2, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 2, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 2, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 2, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 2, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 2, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 2, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 2, k + 4, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 0, j + 2, k + 5, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 1, j + 2, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 2, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 2, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 2, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 2, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 2, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 2, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 2, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 2, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 2, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 2, k + 6, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 1, j + 2, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 2, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 2, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 2, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 2, k + 6, NovaCraftBlocks.vanite_glass, 0, 2);
		world.setBlock(i + 6, j + 2, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 2, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 2, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 2, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 2, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 2, k + 7, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 1, j + 2, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 2, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 2, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 2, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 2, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 2, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 2, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 2, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 2, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 2, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 2, k + 8, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 1, j + 2, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 2, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 2, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 2, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 2, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 2, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 2, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 2, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 2, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 2, k + 8, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 0, j + 2, k + 9, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 1, j + 2, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 2, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 2, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 2, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 2, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 2, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 2, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 2, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 2, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 2, k + 9, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 0, j + 2, k + 10, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 1, j + 2, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 2, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 2, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 2, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 2, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 2, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 2, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 2, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 2, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 2, k + 10, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 0, j + 2, k + 11, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 1, j + 2, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 2, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 2, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 2, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 2, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 2, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 2, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 2, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 2, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 2, k + 11, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 0, j + 2, k + 12, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 1, j + 2, k + 12, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 2, j + 2, k + 12, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 3, j + 2, k + 12, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 4, j + 2, k + 12, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 5, j + 2, k + 12, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 6, j + 2, k + 12, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 7, j + 2, k + 12, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 8, j + 2, k + 12, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 9, j + 2, k + 12, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 10, j + 2, k + 12, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 0, j + 3, k + 0, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 1, j + 3, k + 0, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 2, j + 3, k + 0, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 3, j + 3, k + 0, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 4, j + 3, k + 0, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 5, j + 3, k + 0, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 6, j + 3, k + 0, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 7, j + 3, k + 0, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 8, j + 3, k + 0, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 9, j + 3, k + 0, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 10, j + 3, k + 0, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 0, j + 3, k + 1, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 1, j + 3, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 3, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 3, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 3, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 3, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 3, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 3, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 3, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 3, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 3, k + 1, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 0, j + 3, k + 2, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 1, j + 3, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 3, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 3, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 3, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 3, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 3, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 3, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 3, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 3, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 3, k + 2, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 0, j + 3, k + 3, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 1, j + 3, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 3, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 3, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 3, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 3, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 3, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 3, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 3, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 3, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 3, k + 3, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 0, j + 3, k + 4, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 1, j + 3, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 3, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 3, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 3, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 3, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 3, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 3, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 3, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 3, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 3, k + 4, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 0, j + 3, k + 5, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 1, j + 3, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 3, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 3, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 3, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 3, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 3, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 3, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 3, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 3, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 3, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 3, k + 6, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 1, j + 3, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 3, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 3, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 3, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 3, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 3, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 3, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 3, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 3, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 3, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 3, k + 7, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 1, j + 3, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 3, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 3, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 3, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 3, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 3, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 3, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 3, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 3, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 3, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 0, j + 3, k + 8, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 1, j + 3, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 3, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 3, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 3, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 3, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 3, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 3, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 3, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 3, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 3, k + 8, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 0, j + 3, k + 9, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 1, j + 3, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 3, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 3, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 3, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 3, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 3, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 3, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 3, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 3, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 3, k + 9, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 0, j + 3, k + 10, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 1, j + 3, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 3, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 3, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 3, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 3, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 3, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 3, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 3, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 3, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 3, k + 10, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 0, j + 3, k + 11, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 1, j + 3, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 3, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 3, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 3, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 3, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 3, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 3, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 3, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 3, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 3, k + 11, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 0, j + 3, k + 12, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 1, j + 3, k + 12, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 2, j + 3, k + 12, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 3, j + 3, k + 12, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 4, j + 3, k + 12, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 5, j + 3, k + 12, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 6, j + 3, k + 12, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 7, j + 3, k + 12, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 8, j + 3, k + 12, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 9, j + 3, k + 12, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 10, j + 3, k + 12, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 0, j + 4, k + 0, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 1, j + 4, k + 0, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 2, j + 4, k + 0, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 3, j + 4, k + 0, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 4, j + 4, k + 0, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 5, j + 4, k + 0, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 6, j + 4, k + 0, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 7, j + 4, k + 0, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 8, j + 4, k + 0, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 9, j + 4, k + 0, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 10, j + 4, k + 0, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 0, j + 4, k + 1, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 1, j + 4, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 4, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 4, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 4, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 4, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 4, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 4, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 4, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 4, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 4, k + 1, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 0, j + 4, k + 2, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 1, j + 4, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 4, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 4, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 4, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 4, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 4, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 4, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 4, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 4, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 4, k + 2, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 0, j + 4, k + 3, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 1, j + 4, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 4, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 4, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 4, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 4, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 4, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 4, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 4, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 4, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 4, k + 3, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 0, j + 4, k + 4, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 1, j + 4, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 4, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 4, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 4, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 4, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 4, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 4, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 4, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 4, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 4, k + 4, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 0, j + 4, k + 5, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 1, j + 4, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 4, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 4, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 4, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 4, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 4, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 4, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 4, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 4, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 4, k + 5, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 0, j + 4, k + 6, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 1, j + 4, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 4, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 4, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 4, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 4, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 4, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 4, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 4, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 4, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 4, k + 6, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 0, j + 4, k + 7, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 1, j + 4, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 4, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 4, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 4, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 4, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 4, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 4, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 4, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 4, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 4, k + 7, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 0, j + 4, k + 8, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 1, j + 4, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 4, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 4, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 4, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 4, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 4, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 4, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 4, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 4, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 4, k + 8, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 0, j + 4, k + 9, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 1, j + 4, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 4, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 4, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 4, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 4, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 4, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 4, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 4, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 4, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 4, k + 9, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 0, j + 4, k + 10, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 1, j + 4, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 4, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 4, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 4, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 4, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 4, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 4, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 4, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 4, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 4, k + 10, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 0, j + 4, k + 11, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 1, j + 4, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 4, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 4, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 4, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 4, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 4, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 4, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 4, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 4, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 4, k + 11, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 0, j + 4, k + 12, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 1, j + 4, k + 12, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 2, j + 4, k + 12, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 3, j + 4, k + 12, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 4, j + 4, k + 12, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 5, j + 4, k + 12, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 6, j + 4, k + 12, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 7, j + 4, k + 12, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 8, j + 4, k + 12, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 9, j + 4, k + 12, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 10, j + 4, k + 12, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 0, j + 5, k + 0, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 1, j + 5, k + 0, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 2, j + 5, k + 0, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 3, j + 5, k + 0, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 4, j + 5, k + 0, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 5, j + 5, k + 0, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 6, j + 5, k + 0, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 7, j + 5, k + 0, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 8, j + 5, k + 0, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 9, j + 5, k + 0, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 10, j + 5, k + 0, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 0, j + 5, k + 1, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 1, j + 5, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 5, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 5, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 5, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 5, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 5, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 5, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 5, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 5, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 5, k + 1, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 0, j + 5, k + 2, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 1, j + 5, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 5, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 5, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 5, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 5, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 5, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 5, k + 2, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 0, j + 5, k + 3, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 1, j + 5, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 5, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 5, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 5, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 5, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 5, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 5, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 5, k + 3, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 0, j + 5, k + 4, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 1, j + 5, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 5, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 5, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 5, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 5, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 5, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 5, k + 4, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 0, j + 5, k + 5, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 1, j + 5, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 5, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 5, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 5, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 5, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 5, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 5, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 5, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 5, k + 5, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 5, k + 5, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 0, j + 5, k + 6, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 1, j + 5, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 5, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 5, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 5, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 5, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 5, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 5, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 5, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 5, k + 6, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 5, k + 6, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 0, j + 5, k + 7, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 1, j + 5, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 5, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 5, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 5, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 5, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 5, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 5, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 5, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 5, k + 7, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 5, k + 7, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 0, j + 5, k + 8, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 1, j + 5, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 5, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 5, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 5, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 5, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 5, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 5, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 5, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 5, k + 8, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 5, k + 8, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 0, j + 5, k + 9, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 1, j + 5, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 5, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 5, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 5, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 5, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 5, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 5, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 5, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 5, k + 9, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 5, k + 9, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 0, j + 5, k + 10, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 1, j + 5, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 5, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 5, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 5, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 5, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 5, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 5, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 5, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 5, k + 10, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 5, k + 10, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 0, j + 5, k + 11, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 1, j + 5, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 5, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 5, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 5, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 5, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 6, j + 5, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 7, j + 5, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 8, j + 5, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 9, j + 5, k + 11, Blocks.air, 0, 2);
		world.setBlock(i + 10, j + 5, k + 11, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 0, j + 5, k + 12, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 1, j + 5, k + 12, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 2, j + 5, k + 12, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 3, j + 5, k + 12, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 4, j + 5, k + 12, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 5, j + 5, k + 12, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 6, j + 5, k + 12, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 7, j + 5, k + 12, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 8, j + 5, k + 12, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 9, j + 5, k + 12, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 10, j + 5, k + 12, NovaCraftBlocks.cobbled_grimstone, 0, 2);
		world.setBlock(i + 3, j + 5, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 5, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 5, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 5, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 5, k + 3, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 5, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 4, j + 5, k + 4, Blocks.air, 0, 2);
		world.setBlock(i + 5, j + 5, k + 4, Blocks.air, 0, 2);
		
		world.setBlock(i + 3, j + 1, k + 1, Blocks.chest, 3, 2);
		TileEntityChest tileentitychest = (TileEntityChest)world.getTileEntity(i + 3, j + 1, k + 1);

        if (tileentitychest != null)
        {
            WeightedRandomChestContent.generateChestContents(random, ChestGenHooks.getItems(DUNGEON_CHEST, random), tileentitychest, ChestGenHooks.getCount(DUNGEON_CHEST, random));
                               
        }
        
		world.setBlock(i + 7, j + 1, k + 1, Blocks.chest, 3, 2);
		TileEntityChest tileentitychest2 = (TileEntityChest)world.getTileEntity(i + 7, j + 1, k + 1);

        if (tileentitychest2 != null)
        {
            WeightedRandomChestContent.generateChestContents(random, ChestGenHooks.getItems(DUNGEON_CHEST, random), tileentitychest2, ChestGenHooks.getCount(DUNGEON_CHEST, random));
                               
        }
        
		world.setBlock(i + 1, j + 1, k + 5, Blocks.chest, 5, 2);
		TileEntityChest tileentitychest3 = (TileEntityChest)world.getTileEntity(i + 1, j + 1, k + 5);

        if (tileentitychest3 != null)
        {
            WeightedRandomChestContent.generateChestContents(random, ChestGenHooks.getItems(DUNGEON_CHEST, random), tileentitychest3, ChestGenHooks.getCount(DUNGEON_CHEST, random));
                               
        }
        
		world.setBlock(i + 5, j + 1, k + 11, Blocks.chest, 2, 2);
		TileEntityChest tileentitychest4 = (TileEntityChest)world.getTileEntity(i + 5, j + 1, k + 11);

        if (tileentitychest4 != null)
        {
            WeightedRandomChestContent.generateChestContents(random, ChestGenHooks.getItems(DUNGEON_CHEST, random), tileentitychest4, ChestGenHooks.getCount(DUNGEON_CHEST, random));
                               
        }
		
		world.setBlock(i + 5, j + 1, k + 6, Blocks.mob_spawner, 0, 2);
		TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner)world.getTileEntity(i + 5, j + 1, k + 6);
		
		int rand = (int)(1 + Math.random() * 125);
		if (rand <= 25) {
		    if (tileentitymobspawner != null) {
		    	tileentitymobspawner.func_145881_a().setEntityName("Zombie");

		        //Get the NBT data from the spawner
		        NBTTagCompound spawnerNBT = new NBTTagCompound();
		        tileentitymobspawner.writeToNBT(spawnerNBT);

		        //Modify SpawnData to customize the spawned zombie
		        NBTTagCompound spawnData = new NBTTagCompound();
		        spawnData.setString("id", "Zombie");

		        //Give the mob a Resistance effect
		        NBTTagList effects = new NBTTagList();

		        NBTTagCompound resistanceEffect = new NBTTagCompound();
		        resistanceEffect.setByte("Id", (byte) 11); //Resistance effect ID
		        resistanceEffect.setByte("Amplifier", (byte) 2); //Level 2 Resistance
		        resistanceEffect.setInteger("Duration", Integer.MAX_VALUE); //Infinite duration
		        resistanceEffect.setByte("Ambient", (byte) 1);
		        resistanceEffect.setByte("ShowParticles", (byte) 0); //Invisible effect???

		        effects.appendTag(resistanceEffect);
		        spawnData.setTag("ActiveEffects", effects);

		        //Gives weapon
		        NBTTagList equipment = new NBTTagList();

		        NBTTagCompound weapon = new NBTTagCompound();
		        ItemStack sword = new ItemStack(Items.iron_sword);
		        sword.writeToNBT(weapon);
		        equipment.appendTag(weapon);

		        //Fill remaining slots with empty tags to prevent overwriting other equipment
		        for (int a = 1; a < 5; a++) {
		            equipment.appendTag(new NBTTagCompound());
		        }
		        spawnData.setTag("Equipment", equipment);

		        //Prevent the weapon from being removed or replaced
		        NBTTagList dropChances = new NBTTagList();
		        dropChances.appendTag(new NBTTagFloat(0.0F)); //Weapon (never drops)
		        for (int a = 1; a < 5; a++) {
		            dropChances.appendTag(new NBTTagFloat(0.085F)); //Default drop chance for empty slots
		        }
		        spawnData.setTag("DropChances", dropChances);

		        //Apply SpawnData to spawner
		        spawnerNBT.setTag("SpawnData", spawnData);

		        //Write the modified NBT data back to the spawner
		        tileentitymobspawner.readFromNBT(spawnerNBT);
		    }
		} else if (rand > 25 && rand <= 50) {
			if (tileentitymobspawner != null) {
		    	tileentitymobspawner.func_145881_a().setEntityName("Zombie");

		        NBTTagCompound spawnerNBT = new NBTTagCompound();
		        tileentitymobspawner.writeToNBT(spawnerNBT);

		        NBTTagCompound spawnData = new NBTTagCompound();
		        spawnData.setString("id", "Zombie");

		        NBTTagList effects = new NBTTagList();

		        NBTTagCompound resistanceEffect = new NBTTagCompound();
		        resistanceEffect.setByte("Id", (byte) 11);
		        resistanceEffect.setByte("Amplifier", (byte) 2); 
		        resistanceEffect.setInteger("Duration", Integer.MAX_VALUE);
		        resistanceEffect.setByte("Ambient", (byte) 1);
		        resistanceEffect.setByte("ShowParticles", (byte) 0);

		        effects.appendTag(resistanceEffect);
		        spawnData.setTag("ActiveEffects", effects);

		        NBTTagList equipment = new NBTTagList();

		        NBTTagCompound weapon = new NBTTagCompound();
		        ItemStack sword = new ItemStack(Items.diamond_sword);
		        sword.writeToNBT(weapon);
		        equipment.appendTag(weapon);

		        for (int a = 1; a < 5; a++) {
		            equipment.appendTag(new NBTTagCompound());
		        }
		        spawnData.setTag("Equipment", equipment);

		        NBTTagList dropChances = new NBTTagList();
		        dropChances.appendTag(new NBTTagFloat(0.0F));
		        for (int a = 1; a < 5; a++) {
		            dropChances.appendTag(new NBTTagFloat(0.085F)); 
		        }
		        spawnData.setTag("DropChances", dropChances);

		        spawnerNBT.setTag("SpawnData", spawnData);

		        tileentitymobspawner.readFromNBT(spawnerNBT);
		    }
		} else if (rand > 50 && rand <= 75) {
			if (tileentitymobspawner != null) {
		    	tileentitymobspawner.func_145881_a().setEntityName("Skeleton");

		        NBTTagCompound spawnerNBT = new NBTTagCompound();
		        tileentitymobspawner.writeToNBT(spawnerNBT);

		        NBTTagCompound spawnData = new NBTTagCompound();
		        spawnData.setString("id", "Skeleton");

		        NBTTagList effects = new NBTTagList();

		        NBTTagCompound resistanceEffect = new NBTTagCompound();
		        resistanceEffect.setByte("Id", (byte) 11);
		        resistanceEffect.setByte("Amplifier", (byte) 2);
		        resistanceEffect.setInteger("Duration", Integer.MAX_VALUE); 
		        resistanceEffect.setByte("Ambient", (byte) 1);
		        resistanceEffect.setByte("ShowParticles", (byte) 0);

		        effects.appendTag(resistanceEffect);
		        spawnData.setTag("ActiveEffects", effects);

		        NBTTagList equipment = new NBTTagList();

		        NBTTagCompound weapon = new NBTTagCompound();
		        ItemStack sword = new ItemStack(Items.bow);
		        sword.writeToNBT(weapon);
		        equipment.appendTag(weapon);

		        for (int a = 1; a < 5; a++) {
		            equipment.appendTag(new NBTTagCompound());
		        }
		        spawnData.setTag("Equipment", equipment);

		        NBTTagList dropChances = new NBTTagList();
		        dropChances.appendTag(new NBTTagFloat(0.0F));
		        for (int a = 1; a < 5; a++) {
		            dropChances.appendTag(new NBTTagFloat(0.085F));
		        }
		        spawnData.setTag("DropChances", dropChances);

		        spawnerNBT.setTag("SpawnData", spawnData);

		        tileentitymobspawner.readFromNBT(spawnerNBT);
		    }
		} else if (rand > 75 && rand <= 100) {
			if (tileentitymobspawner != null) {
		    	tileentitymobspawner.func_145881_a().setEntityName("Spider");

		        NBTTagCompound spawnerNBT = new NBTTagCompound();
		        tileentitymobspawner.writeToNBT(spawnerNBT);

		        NBTTagCompound spawnData = new NBTTagCompound();
		        spawnData.setString("id", "Spider");

		        NBTTagList effects = new NBTTagList();

		        NBTTagCompound resistanceEffect = new NBTTagCompound();
		        resistanceEffect.setByte("Id", (byte) 11);
		        resistanceEffect.setByte("Amplifier", (byte) 3);
		        resistanceEffect.setInteger("Duration", Integer.MAX_VALUE);
		        resistanceEffect.setByte("Ambient", (byte) 1);
		        resistanceEffect.setByte("ShowParticles", (byte) 0);

		        effects.appendTag(resistanceEffect);
		        spawnData.setTag("ActiveEffects", effects);

		        spawnerNBT.setTag("SpawnData", spawnData);

		        tileentitymobspawner.readFromNBT(spawnerNBT);
		    }
		} else if (rand > 100 && rand <= 125) {
			if (tileentitymobspawner != null) {
		    	tileentitymobspawner.func_145881_a().setEntityName("CaveSpider");

		        NBTTagCompound spawnerNBT = new NBTTagCompound();
		        tileentitymobspawner.writeToNBT(spawnerNBT);

		        NBTTagCompound spawnData = new NBTTagCompound();
		        spawnData.setString("id", "CaveSpider");

		        NBTTagList effects = new NBTTagList();

		        NBTTagCompound resistanceEffect = new NBTTagCompound();
		        resistanceEffect.setByte("Id", (byte) 11);
		        resistanceEffect.setByte("Amplifier", (byte) 3);
		        resistanceEffect.setInteger("Duration", Integer.MAX_VALUE);
		        resistanceEffect.setByte("Ambient", (byte) 1);
		        resistanceEffect.setByte("ShowParticles", (byte) 0);

		        effects.appendTag(resistanceEffect);
		        spawnData.setTag("ActiveEffects", effects);

		        spawnerNBT.setTag("SpawnData", spawnData);

		        tileentitymobspawner.readFromNBT(spawnerNBT);
		    }
		}
		
		return true;
	}

}
