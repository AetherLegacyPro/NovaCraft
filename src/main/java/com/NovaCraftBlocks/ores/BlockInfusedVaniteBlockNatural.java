package com.NovaCraftBlocks.ores;

import java.util.Random;

import com.NovaCraft.NovaCraft;
import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.entity.EntityFireProofItemNovaCraft;
import com.NovaCraft.particles.ParticleHandler;
import com.NovaCraft.registry.OtherModBlocks;
import com.NovaCraft.sounds.ModSounds;
import com.NovaCraftBlocks.NovaCraftBlocks;
import com.ibm.icu.impl.duration.impl.Utils;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockInfusedVaniteBlockNatural extends Block {
	
	public BlockInfusedVaniteBlockNatural() {
		super(Material.iron);
		this.setHardness(60);
		this.setResistance(60000000);
		this.setStepSound(ModSounds.soundSculk);
		this.setHarvestLevel("pickaxe", 3);
	}
	
	@Override
    @SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int i, int j, int k, Random random) {
		World par1World = world;
		int par2 = i;
		int par3 = j;
		int par4 = k;
		Random par5Random = random;
		if (true)
			for (int l = 0; l < 8; ++l) {
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
		for (int l = 0; l < 8; ++l) {
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
			par1World.spawnParticle("townaura", d0, d1, d2, d3, d4, d5);
		}
		
		super.randomDisplayTick(world, i, j, k, random);
        if (random.nextInt(5) == 0) {
        	ParticleHandler.WARDEN.spawn(world, i + random.nextFloat(), j + 0.1f, k + random.nextFloat(), 0.0, 0.0, 0.0, 0.0f, new Object[0]);
        	ParticleHandler.WARDEN.spawn(world, i + random.nextFloat(), j + 0.4f, k + random.nextFloat(), 0.0, 0.0, 0.0, 0.0f, new Object[0]);
            ParticleHandler.WARDEN.spawn(world, i + random.nextFloat(), j + 0.6f, k + random.nextFloat(), 0.0, 0.0, 0.0, 0.0f, new Object[0]);
        }

	}

	public void registerBlockIcons(final IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon("nova_craft:darkanimate_alternate");
    }
	
	protected boolean canSilkHarvest() {
	    return true;
	 }
	
	
	public int quantityDropped(final Random random) {
        return 1;
    }
	
	public Item getItemDropped(final int metadata, final Random rand, final int fortune) {
        return NovaCraftItems.dark_essence;
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
			
				amount = MathHelper.getRandomIntegerInRange(random, 12, 24);
			

			return amount;
		}

		return 0;
	}
	
}
