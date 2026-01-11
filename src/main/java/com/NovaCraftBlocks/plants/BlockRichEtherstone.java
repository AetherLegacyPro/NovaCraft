package com.NovaCraftBlocks.plants;

import java.util.ArrayList;
import java.util.Random;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.config.Configs;
import com.NovaCraft.config.ConfigsCompact;
import com.NovaCraft.particles.ParticleHandler;
import com.NovaCraft.registry.OtherModItems;
import com.NovaCraftBlocks.NovaCraftBlocks;

import cpw.mods.fml.common.Loader;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockRichEtherstone extends Block {

	@SideOnly(Side.CLIENT)
	private IIcon[] topIcons;
	private IIcon sideIcon;

	public BlockRichEtherstone() {
		super(Material.iron);
		this.setHardness(2.45F);
		this.setResistance(11.45F);
		this.setStepSound(soundTypeMetal);
		this.setHarvestLevel("pickaxe", 2);
	}

	protected boolean canSilkHarvest() {
		return true;
	}

	@Override
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
		ArrayList<ItemStack> drops = new ArrayList<ItemStack>();
		Random random = world.rand;
		int choice = random.nextInt(40);

		if (choice == 20) {
			drops.add(new ItemStack(Items.dye, 1, 4));
		} else if (choice < 20 && choice >= 15) {
			drops.add(new ItemStack(Items.gold_nugget));
		} else if (choice < 10 && choice > 5) {
			drops.add(new ItemStack(NovaCraftItems.iridium_nugget, 1, 1));
		} else if (choice == 5) {
			drops.add(new ItemStack(NovaCraftItems.iridium_nugget, 1, 0));
		} else if (choice == 4 && Configs.enableTreasureCratesDropDiamonds) {
			drops.add(new ItemStack(NovaCraftItems.diamond_nugget, 1, 0));
		} else if (choice == 3) {
			drops.add(new ItemStack(NovaCraftItems.diamond_nugget, 1, 1));
		} else if (choice == 2) {
			drops.add(new ItemStack(NovaCraftItems.copartz_shard));
		} else if (choice == 1) {
			drops.add(new ItemStack(NovaCraftItems.tsavorokite_shard));
		} else if (choice == 0) {
			drops.add(new ItemStack(NovaCraftItems.larimar_shard));
		} else if (choice < 15 && choice >= 10 && Loader.isModLoaded("etfuturum")) {
			if (ConfigsCompact.enableIronNugget) {
				drops.add(new ItemStack(OtherModItems.nugget_iron, 1, 0));
			}  else {
				drops.add(new ItemStack(Item.getItemFromBlock(NovaCraftBlocks.cobbled_etherstone)));
			}
		} else {
			drops.add(new ItemStack(Item.getItemFromBlock(NovaCraftBlocks.cobbled_etherstone)));
		}

		return drops;
	}

	@Override
	public int quantityDroppedWithBonus(int fortune, Random random) {
		if (fortune > 0 && Item.getItemFromBlock(this) != this.getItemDropped(0, random, fortune)) {
			int j = random.nextInt(fortune + 1) - 1;

			if (j < 0) {
				j = 0;
			}

			return this.quantityDropped(random) * (j + 1);
		} else {
			return this.quantityDropped(random);
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister registry) {
		this.topIcons = new IIcon[4];
		for (int i = 0; i < 4; i++) {
			this.topIcons[i] = registry.registerIcon("nova_craft:rich_etherstone_top_" + i);
		}
		this.sideIcon = registry.registerIcon("nova_craft:rich_etherstone_side");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(IBlockAccess world, int x, int y, int z, int side) {
		if (side == 1) {
			int hash = x * 3129871 ^ z * 116129781 ^ y;
			hash = hash * hash * 42317861 + hash * 11;
			int rotation = (hash >> 16) & 3;
			return this.topIcons[rotation];
		} else if (side == 0) {
			return NovaCraftBlocks.cobbled_etherstone.getBlockTextureFromSide(side);
		} else {
			return this.sideIcon;
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		if (side == 1) return topIcons[0];
		if (side == 0) return NovaCraftBlocks.cobbled_etherstone.getBlockTextureFromSide(side);
		return sideIcon;
	}
	
	@SideOnly(Side.CLIENT)
    public void randomDisplayTick(World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_)
    {		
		if (!p_149734_1_.isRemote) {
			return;
		}

		if (net.minecraft.client.Minecraft.getMinecraft().gameSettings.particleSetting == 2) {
			return;
		}
		
		if (p_149734_5_.nextInt(25) == 0) {
        int l = p_149734_1_.getBlockMetadata(p_149734_2_, p_149734_3_, p_149734_4_);
        double d0 = (double)((float)p_149734_2_ + 0.5F + (p_149734_5_.nextFloat()) - (p_149734_5_.nextFloat()));
        double d1 = (double)((float)p_149734_3_ + 1.01F);
        double d2 = (double)((float)p_149734_4_ + 0.5F + (p_149734_5_.nextFloat()) - (p_149734_5_.nextFloat()));
        double d3 = 0.2199999988079071D;
        double d4 = 0.27000001072883606D;

        if (l == 1)
        {
        	ParticleHandler.TREASURE_SMALL.spawn(p_149734_1_, d0 - d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D, 0.0f, new Object[0]);
        }
        else if (l == 2)
        {
        	ParticleHandler.TREASURE_SMALL.spawn(p_149734_1_, d0 - d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D, 0.0f, new Object[0]);
        }
        else if (l == 3)
        {
        	ParticleHandler.TREASURE_SMALL.spawn(p_149734_1_, d0 - d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D, 0.0f, new Object[0]);
        }
        else if (l == 4)
        {
        	ParticleHandler.TREASURE_SMALL.spawn(p_149734_1_, d0 - d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D, 0.0f, new Object[0]);
        }
        else
        {
        	ParticleHandler.TREASURE_SMALL.spawn(p_149734_1_, d0 - d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D, 0.0f, new Object[0]);
        }
		}
    }
}
