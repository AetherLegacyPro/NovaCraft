package com.NovaCraftBlocks;

import java.util.ArrayList;
import java.util.Random;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.particles.ParticleHandler;
import com.NovaCraft.sounds.ModSounds;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLog;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraftforge.event.ForgeEventFactory;

public class BlockBasalScrap extends Block {
	
	@SideOnly(Side.CLIENT)
	private IIcon iconFace, iconTop;
	
	public BlockBasalScrap() {
		super(Material.rock);
		this.setHardness(4);
		this.setResistance(200F);
		this.setLightLevel(0.15F);
		this.setStepSound(ModSounds.soundGrimstoneBricks);
		this.setHarvestLevel("pickaxe", 3);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta){
		return side == 0 || side == 1 ? iconTop : meta >= 1 && side-1 == meta ? iconFace : blockIcon;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister){
		blockIcon = iconRegister.registerIcon("nova_craft:basal_scrap_side");
		iconFace = iconRegister.registerIcon("nova_craft:basal_scrap_top");
		iconTop = iconRegister.registerIcon("nova_craft:basal_scrap_top");
	}
	
	public void randomDisplayTick(World world, int i, int j, int k, Random random) {
		World par1World = world;
		int par2 = i;
		int par3 = j;
		int par4 = k;
		Random par5Random = random;
		if (true)
			for (int l = 0; l < 4; ++l) {
				double d0 = (double) ((float) par2 + par5Random.nextFloat());
				double d1 = (double) ((float) par3 + par5Random.nextFloat());
				double d2 = (double) ((float) par4 + par5Random.nextFloat());
				double d3 = 0.0D;
				double d4 = 0.0D;
				double d5 = 0.0D;
				int i1 = par5Random.nextInt(2) * 2 - 1;
				d3 = ((double) par5Random.nextFloat() - 0.5D) * 0.5D;
				d4 = ((double) par5Random.nextFloat() - 0.5D) * 0.5D;
				d5 = ((double) par5Random.nextFloat() - 0.5D) * 0.5D;
				par1World.spawnParticle("reddust", d0, d1, d2, d3, d4, d5);
			}

	}
	
	protected boolean canSilkHarvest() {
	    return true;
	 }
	
	 public int quantityDropped(final Random random) {
		 int a = random.nextInt(10);
		 if (a <= 3) {
			 return 1;
		 }
		 else {
			 return 0; 
		 }
		}
		
	public Item getItemDropped(final int metadata, final Random rand, final int fortune) {
	       return NovaCraftItems.vanite_chunk;
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
	public int getExpDrop(IBlockAccess p_149690_1_, int p_149690_5_, int p_149690_7_) {
		Random random = new Random();

		if (this.getItemDropped(p_149690_5_, random, p_149690_7_) != Item.getItemFromBlock(this)) {
			int amount = 0;	
			
				amount = MathHelper.getRandomIntegerInRange(random, 0, 1);
			

			return amount;
		}

		return 0;
	}

}
