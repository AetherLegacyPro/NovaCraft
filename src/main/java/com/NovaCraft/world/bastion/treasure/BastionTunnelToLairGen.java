package com.NovaCraft.world.bastion.treasure;

import net.minecraft.world.gen.feature.*;
import net.minecraft.block.*;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.world.*;
import java.util.*;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.config.Configs;
import com.NovaCraft.registry.OtherModBlocks;
import com.NovaCraft.registry.OtherModItems;
import com.NovaCraftBlocks.NovaCraftBlocks;

import cpw.mods.fml.common.Loader;
import net.minecraft.init.*;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.MathHelper;

public class BastionTunnelToLairGen extends WorldGenerator
{
	public BastionTunnelToLairGen() {

	}
	
	public boolean generate(final World world, final Random random, final int i, final int j, final int k) {
		
		world.setBlock(i + 0, j + 0, k + 0, NovaCraftBlocks.basal_bricks, 0, 2);
		world.setBlock(i + 1, j + 0, k + 0, NovaCraftBlocks.glowing_basal, 0, 2);
		world.setBlock(i + 2, j + 0, k + 0, NovaCraftBlocks.basal_bricks, 0, 2);
		world.setBlock(i + 3, j + 0, k + 0, NovaCraftBlocks.basal_bricks, 0, 2);
		world.setBlock(i + 0, j + 0, k + 1, NovaCraftBlocks.basal_bricks, 0, 2);
		world.setBlock(i + 1, j + 0, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 0, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 0, k + 1, NovaCraftBlocks.basal_bricks, 0, 2);
		world.setBlock(i + 0, j + 0, k + 2, NovaCraftBlocks.basal_bricks, 0, 2);
		world.setBlock(i + 1, j + 0, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 0, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 0, k + 2, NovaCraftBlocks.basal_bricks, 0, 2);
		world.setBlock(i + 0, j + 0, k + 3, NovaCraftBlocks.basal_bricks, 0, 2);
		world.setBlock(i + 1, j + 0, k + 3, NovaCraftBlocks.basal_bricks, 0, 2);
		world.setBlock(i + 2, j + 0, k + 3, NovaCraftBlocks.basal_bricks, 0, 2);
		world.setBlock(i + 3, j + 0, k + 3, NovaCraftBlocks.basal_bricks, 0, 2);
		world.setBlock(i + 0, j + 1, k + 0, NovaCraftBlocks.basal_bricks, 0, 2);
		world.setBlock(i + 1, j + 1, k + 0, NovaCraftBlocks.cracked_basal_bricks, 0, 2);
		world.setBlock(i + 2, j + 1, k + 0, NovaCraftBlocks.basal_bricks, 0, 2);
		world.setBlock(i + 3, j + 1, k + 0, NovaCraftBlocks.basal_bricks, 0, 2);
		world.setBlock(i + 0, j + 1, k + 1, NovaCraftBlocks.glowing_basal, 0, 2);
		world.setBlock(i + 1, j + 1, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 1, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 1, k + 1, NovaCraftBlocks.cracked_basal_bricks, 0, 2);
		world.setBlock(i + 0, j + 1, k + 2, NovaCraftBlocks.basal_bricks, 0, 2);
		world.setBlock(i + 1, j + 1, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 1, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 1, k + 2, NovaCraftBlocks.glowing_basal, 0, 2);
		world.setBlock(i + 0, j + 1, k + 3, NovaCraftBlocks.basal_bricks, 0, 2);
		world.setBlock(i + 1, j + 1, k + 3, NovaCraftBlocks.basal_bricks, 0, 2);
		world.setBlock(i + 2, j + 1, k + 3, NovaCraftBlocks.basal_bricks, 0, 2);
		world.setBlock(i + 3, j + 1, k + 3, NovaCraftBlocks.basal_bricks, 0, 2);
		world.setBlock(i + 0, j + 2, k + 0, NovaCraftBlocks.basal_bricks, 0, 2);
		world.setBlock(i + 1, j + 2, k + 0, NovaCraftBlocks.basal_bricks, 0, 2);
		world.setBlock(i + 2, j + 2, k + 0, NovaCraftBlocks.glowing_basal, 0, 2);
		world.setBlock(i + 3, j + 2, k + 0, NovaCraftBlocks.basal_bricks, 0, 2);
		world.setBlock(i + 0, j + 2, k + 1, NovaCraftBlocks.basal_bricks, 0, 2);
		world.setBlock(i + 1, j + 2, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 2, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 2, k + 1, NovaCraftBlocks.basal_bricks, 0, 2);
		world.setBlock(i + 0, j + 2, k + 2, NovaCraftBlocks.cracked_basal_bricks, 0, 2);
		world.setBlock(i + 1, j + 2, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 2, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 2, k + 2, NovaCraftBlocks.basal_bricks, 0, 2);
		world.setBlock(i + 0, j + 2, k + 3, NovaCraftBlocks.basal_bricks, 0, 2);
		world.setBlock(i + 1, j + 2, k + 3, NovaCraftBlocks.glowing_basal, 0, 2);
		world.setBlock(i + 2, j + 2, k + 3, NovaCraftBlocks.basal_bricks, 0, 2);
		world.setBlock(i + 3, j + 2, k + 3, NovaCraftBlocks.basal_bricks, 0, 2);
		world.setBlock(i + 0, j + 3, k + 0, NovaCraftBlocks.basal_bricks, 0, 2);
		world.setBlock(i + 1, j + 3, k + 0, NovaCraftBlocks.basal_bricks, 0, 2);
		world.setBlock(i + 2, j + 3, k + 0, NovaCraftBlocks.basal_bricks, 0, 2);
		world.setBlock(i + 3, j + 3, k + 0, NovaCraftBlocks.cracked_basal_bricks, 0, 2);
		world.setBlock(i + 0, j + 3, k + 1, NovaCraftBlocks.cracked_basal_bricks, 0, 2);
		world.setBlock(i + 1, j + 3, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 3, k + 1, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 3, k + 1, NovaCraftBlocks.glowing_basal, 0, 2);
		world.setBlock(i + 0, j + 3, k + 2, NovaCraftBlocks.basal_bricks, 0, 2);
		world.setBlock(i + 1, j + 3, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 2, j + 3, k + 2, Blocks.air, 0, 2);
		world.setBlock(i + 3, j + 3, k + 2, NovaCraftBlocks.basal_bricks, 0, 2);
		world.setBlock(i + 0, j + 3, k + 3, NovaCraftBlocks.basal_bricks, 0, 2);
		world.setBlock(i + 1, j + 3, k + 3, NovaCraftBlocks.basal_bricks, 0, 2);
		world.setBlock(i + 2, j + 3, k + 3, NovaCraftBlocks.cracked_basal_bricks, 0, 2);
		world.setBlock(i + 3, j + 3, k + 3, NovaCraftBlocks.basal_bricks, 0, 2);
		
		return true;
	}

}
