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

public class BlockInfusedVaniteBlock extends Block {
	
	public BlockInfusedVaniteBlock() {
		super(Material.iron);
		this.setHardness(60);
		this.setResistance(60000000);
		this.setStepSound(ModSounds.soundSculk);
		this.setHarvestLevel("pickaxe", 3);
		setTickRandomly(true);
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
        this.blockIcon = iconRegister.registerIcon("nova_craft:darkanimate");
    }
	
	protected boolean canSilkHarvest() {
	    return true;
	 }
	
	
	public int quantityDropped(final Random random) {
        return 4 + random.nextInt(16);
    }
	
	public Item getItemDropped(final int metadata, final Random rand, final int fortune) {
        return NovaCraftItems.dark_essence;
    }
	
	@Override
	public int quantityDroppedWithBonus(int fortune, Random random) {
		if (fortune > 0 && Item.getItemFromBlock(this) != this.getItemDropped(0, random, fortune)) {
			int j = random.nextInt(fortune + 3) - 1;

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
			
				amount = MathHelper.getRandomIntegerInRange(random, 24, 48);
			

			return amount;
		}

		return 0;
	}
	
    public void updateTick(World world, int i, int j, int k, Random random) {
		
 		if (world.provider.dimensionId == 1 || world.provider.dimensionId == 0) {
 			if (world.getBlock(i, j, k + 2) == NovaCraftBlocks.budding_aether_block
                && world.getBlock(i, j, k - 2) == NovaCraftBlocks.budding_aether_block
                && world.getBlock(i, j + 1, k - 2) == NovaCraftBlocks.aether_cluster_2
                && world.getBlock(i, j + 1, k + 2) == NovaCraftBlocks.aether_cluster_2
                
                && world.getBlock(i - 2, j, k) == NovaCraftBlocks.budding_null_block
                && world.getBlock(i + 2, j, k) == NovaCraftBlocks.budding_null_block
                && world.getBlock(i - 2, j + 1, k) == NovaCraftBlocks.null_cluster_2
                && world.getBlock(i + 2, j + 1, k) == NovaCraftBlocks.null_cluster_2
                
                && world.getBlock(i, j - 1, k) == NovaCraftBlocks.crystallized_end                
                && world.getBlock(i, j - 1, k - 1) == NovaCraftBlocks.crystallized_end
                && world.getBlock(i, j - 1, k + 1) == NovaCraftBlocks.crystallized_end
                && world.getBlock(i - 1, j - 1, k) == NovaCraftBlocks.crystallized_end
                && world.getBlock(i + 1, j - 1, k) == NovaCraftBlocks.crystallized_end
                && world.getBlock(i + 1, j - 1, k - 1) == NovaCraftBlocks.crystallized_end
                && world.getBlock(i + 1, j - 1, k + 1) == NovaCraftBlocks.crystallized_end
                && world.getBlock(i - 1, j - 1, k - 1) == NovaCraftBlocks.crystallized_end
                && world.getBlock(i - 1, j - 1, k + 1) == NovaCraftBlocks.crystallized_end
                
                && world.getBlock(i + 2, j - 1, k) == Blocks.end_stone
                && world.getBlock(i + 2, j - 1, k + 1) == Blocks.end_stone
                && world.getBlock(i + 2, j - 1, k - 1) == Blocks.end_stone
                
                && world.getBlock(i - 2, j - 1, k) == Blocks.end_stone
                && world.getBlock(i - 2, j - 1, k + 1) == Blocks.end_stone
                && world.getBlock(i - 2, j - 1, k - 1) == Blocks.end_stone
                
                && world.getBlock(i, j - 1, k - 2) == Blocks.end_stone
                && world.getBlock(i - 1, j - 1, k - 2) == Blocks.end_stone
                && world.getBlock(i + 1, j - 1, k - 2) == Blocks.end_stone
                
                && world.getBlock(i, j - 1, k + 2) == Blocks.end_stone
                && world.getBlock(i - 1, j - 1, k + 2) == Blocks.end_stone
                && world.getBlock(i + 1, j - 1, k + 2) == Blocks.end_stone
                
                && world.getBlock(i - 2, j - 1, k + 2) == NovaCraftBlocks.larimar_block
                && world.getBlock(i - 2, j, k + 2) == NovaCraftBlocks.larimar_block
                && world.getBlock(i - 2, j + 1, k + 2) == NovaCraftBlocks.larimar_block
                && world.getBlock(i - 2, j + 2, k + 2) == NovaCraftBlocks.larimar_block
                && world.getBlock(i - 2, j + 3, k + 2) == NovaCraftBlocks.larimar_block
                && world.getBlock(i - 2, j + 4, k + 2) == NovaCraftBlocks.budding_larimar_block
                && world.getBlock(i - 2, j + 5, k + 2) == NovaCraftBlocks.larimar_cluster_2
                
                && world.getBlock(i - 2, j - 1, k - 2) == NovaCraftBlocks.yttrlinsite_block
                && world.getBlock(i - 2, j, k - 2) == NovaCraftBlocks.yttrlinsite_block
                && world.getBlock(i - 2, j + 1, k - 2) == NovaCraftBlocks.yttrlinsite_block
                && world.getBlock(i - 2, j + 2, k - 2) == NovaCraftBlocks.yttrlinsite_block
                && world.getBlock(i - 2, j + 3, k - 2) == NovaCraftBlocks.yttrlinsite_block
                && world.getBlock(i - 2, j + 4, k - 2) == NovaCraftBlocks.budding_yttrlinsite_block
                && world.getBlock(i - 2, j + 5, k - 2) == NovaCraftBlocks.yttrlinsite_cluster_2
                
                && world.getBlock(i + 2, j - 1, k + 2) == NovaCraftBlocks.tsavorokite_block
                && world.getBlock(i + 2, j, k + 2) == NovaCraftBlocks.tsavorokite_block
                && world.getBlock(i + 2, j + 1, k + 2) == NovaCraftBlocks.tsavorokite_block
                && world.getBlock(i + 2, j + 2, k + 2) == NovaCraftBlocks.tsavorokite_block
                && world.getBlock(i + 2, j + 3, k + 2) == NovaCraftBlocks.tsavorokite_block
                && world.getBlock(i + 2, j + 4, k + 2) == NovaCraftBlocks.budding_tsavorokite_block
                && world.getBlock(i + 2, j + 5, k + 2) == NovaCraftBlocks.tsavorokite_cluster_2
                
                && world.getBlock(i + 2, j - 1, k - 2) == NovaCraftBlocks.copartz_block
                && world.getBlock(i + 2, j, k - 2) == NovaCraftBlocks.copartz_block
                && world.getBlock(i + 2, j + 1, k - 2) == NovaCraftBlocks.copartz_block
                && world.getBlock(i + 2, j + 2, k - 2) == NovaCraftBlocks.copartz_block
                && world.getBlock(i + 2, j + 3, k - 2) == NovaCraftBlocks.copartz_block
                && world.getBlock(i + 2, j + 4, k - 2) == NovaCraftBlocks.budding_copartz_block
                && world.getBlock(i + 2, j + 5, k - 2) == NovaCraftBlocks.copartz_cluster_2
                
                && world.getBlock(i + 3, j - 2, k) == NovaCraftBlocks.sculk_endstone
                && world.getBlock(i + 3, j - 2, k + 1) == NovaCraftBlocks.sculk_endstone
                && world.getBlock(i + 3, j - 2, k + 2) == NovaCraftBlocks.sculk_endstone
                && world.getBlock(i + 3, j - 2, k - 1) == NovaCraftBlocks.sculk_endstone
                && world.getBlock(i + 3, j - 2, k - 2) == NovaCraftBlocks.sculk_endstone             
                && world.getBlock(i + 3, j - 1, k) == NovaCraftBlocks.sculk_tentacle_2
                && world.getBlock(i + 3, j - 1, k + 1) == NovaCraftBlocks.sculk_tentacle_2
                && world.getBlock(i + 3, j - 1, k + 2) == NovaCraftBlocks.sculk_tentacle_2
                && world.getBlock(i + 3, j - 1, k - 1) == NovaCraftBlocks.sculk_tentacle_2
                && world.getBlock(i + 3, j - 1, k - 2) == NovaCraftBlocks.sculk_tentacle_2
                
                && world.getBlock(i - 3, j - 2, k) == NovaCraftBlocks.sculk_endstone
                && world.getBlock(i - 3, j - 2, k + 1) == NovaCraftBlocks.sculk_endstone
                && world.getBlock(i - 3, j - 2, k + 2) == NovaCraftBlocks.sculk_endstone
                && world.getBlock(i - 3, j - 2, k - 1) == NovaCraftBlocks.sculk_endstone
                && world.getBlock(i - 3, j - 2, k - 2) == NovaCraftBlocks.sculk_endstone             
                && world.getBlock(i - 3, j - 1, k) == NovaCraftBlocks.sculk_tentacle_2
                && world.getBlock(i - 3, j - 1, k + 1) == NovaCraftBlocks.sculk_tentacle_2
                && world.getBlock(i - 3, j - 1, k + 2) == NovaCraftBlocks.sculk_tentacle_2
                && world.getBlock(i - 3, j - 1, k - 1) == NovaCraftBlocks.sculk_tentacle_2
                && world.getBlock(i - 3, j - 1, k - 2) == NovaCraftBlocks.sculk_tentacle_2
                
                && world.getBlock(i, j - 2, k - 3) == NovaCraftBlocks.sculk_endstone
                && world.getBlock(i + 1, j - 2, k - 3) == NovaCraftBlocks.sculk_endstone
                && world.getBlock(i + 2, j - 2, k - 3) == NovaCraftBlocks.sculk_endstone
                && world.getBlock(i - 1, j - 2, k - 3) == NovaCraftBlocks.sculk_endstone
                && world.getBlock(i - 2, j - 2, k - 3) == NovaCraftBlocks.sculk_endstone             
                && world.getBlock(i, j - 1, k - 3) == NovaCraftBlocks.sculk_tentacle_2
                && world.getBlock(i - 1, j - 1, k - 3) == NovaCraftBlocks.sculk_tentacle_2
                && world.getBlock(i - 2, j - 1, k - 3) == NovaCraftBlocks.sculk_tentacle_2
                && world.getBlock(i + 1, j - 1, k - 3) == NovaCraftBlocks.sculk_tentacle_2
                && world.getBlock(i + 2, j - 1, k - 3) == NovaCraftBlocks.sculk_tentacle_2
                
                && world.getBlock(i, j - 2, k + 3) == NovaCraftBlocks.sculk_endstone
                && world.getBlock(i + 1, j - 2, k + 3) == NovaCraftBlocks.sculk_endstone
                && world.getBlock(i + 2, j - 2, k + 3) == NovaCraftBlocks.sculk_endstone
                && world.getBlock(i - 1, j - 2, k + 3) == NovaCraftBlocks.sculk_endstone
                && world.getBlock(i - 2, j - 2, k + 3) == NovaCraftBlocks.sculk_endstone             
                && world.getBlock(i, j - 1, k + 3) == NovaCraftBlocks.sculk_tentacle_2
                && world.getBlock(i - 1, j - 1, k + 3) == NovaCraftBlocks.sculk_tentacle_2
                && world.getBlock(i - 2, j - 1, k + 3) == NovaCraftBlocks.sculk_tentacle_2
                && world.getBlock(i + 1, j - 1, k + 3) == NovaCraftBlocks.sculk_tentacle_2
                && world.getBlock(i + 2, j - 1, k + 3) == NovaCraftBlocks.sculk_tentacle_2
                
                && (world.getBlock(i + 3, j - 2, k + 3) == Blocks.beacon || world.getBlock(i + 3, j - 2, k + 3) == OtherModBlocks.beacon)               
                && world.getBlock(i + 3, j - 3, k + 3) == NovaCraftBlocks.block_of_vanite                
                && world.getBlock(i + 4, j - 3, k + 3) == NovaCraftBlocks.block_of_vanite
                && world.getBlock(i + 2, j - 3, k + 3) == NovaCraftBlocks.block_of_vanite                
                && world.getBlock(i + 3, j - 3, k + 4) == NovaCraftBlocks.block_of_vanite
                && world.getBlock(i + 3, j - 3, k + 2) == NovaCraftBlocks.block_of_vanite              
               
                && world.getBlock(i + 2, j - 3, k + 2) == NovaCraftBlocks.block_of_vanite
                && world.getBlock(i + 4, j - 3, k + 4) == NovaCraftBlocks.block_of_vanite
                && world.getBlock(i + 2, j - 3, k + 4) == NovaCraftBlocks.block_of_vanite
                && world.getBlock(i + 4, j - 3, k + 2) == NovaCraftBlocks.block_of_vanite
                
                && (world.getBlock(i + 3, j - 2, k - 3) == Blocks.beacon || world.getBlock(i + 3, j - 2, k - 3) == OtherModBlocks.beacon)            
                && world.getBlock(i + 3, j - 3, k - 3) == NovaCraftBlocks.block_of_vanite
                && world.getBlock(i + 2, j - 3, k - 3) == NovaCraftBlocks.block_of_vanite
                && world.getBlock(i + 4, j - 3, k - 3) == NovaCraftBlocks.block_of_vanite
                && world.getBlock(i + 3, j - 3, k - 4) == NovaCraftBlocks.block_of_vanite
                && world.getBlock(i + 3, j - 3, k - 2) == NovaCraftBlocks.block_of_vanite
                
                && world.getBlock(i + 4, j - 3, k - 2) == NovaCraftBlocks.block_of_vanite
                && world.getBlock(i + 2, j - 3, k - 4) == NovaCraftBlocks.block_of_vanite
                && world.getBlock(i + 4, j - 3, k - 2) == NovaCraftBlocks.block_of_vanite
                && world.getBlock(i + 2, j - 3, k - 4) == NovaCraftBlocks.block_of_vanite
                
                && (world.getBlock(i - 3, j - 2, k + 3) == Blocks.beacon || world.getBlock(i - 3, j - 2, k + 3) == OtherModBlocks.beacon)
                && world.getBlock(i - 3, j - 3, k + 3) == NovaCraftBlocks.block_of_vanite               		
                && world.getBlock(i - 4, j - 3, k + 3) == NovaCraftBlocks.block_of_vanite
                && world.getBlock(i - 2, j - 3, k + 3) == NovaCraftBlocks.block_of_vanite
                && world.getBlock(i - 3, j - 3, k + 2) == NovaCraftBlocks.block_of_vanite
                && world.getBlock(i - 3, j - 3, k + 4) == NovaCraftBlocks.block_of_vanite
                
                && world.getBlock(i - 4, j - 3, k + 2) == NovaCraftBlocks.block_of_vanite
                && world.getBlock(i - 2, j - 3, k + 4) == NovaCraftBlocks.block_of_vanite
                && world.getBlock(i - 2, j - 3, k + 2) == NovaCraftBlocks.block_of_vanite
                && world.getBlock(i - 4, j - 3, k + 2) == NovaCraftBlocks.block_of_vanite
                               
                && (world.getBlock(i - 3, j - 2, k - 3) == Blocks.beacon || world.getBlock(i - 3, j - 2, k - 3) == OtherModBlocks.beacon)
                && world.getBlock(i - 3, j - 3, k - 3) == NovaCraftBlocks.block_of_vanite               
                && world.getBlock(i - 4, j - 3, k - 3) == NovaCraftBlocks.block_of_vanite
                && world.getBlock(i - 2, j - 3, k - 3) == NovaCraftBlocks.block_of_vanite
                && world.getBlock(i - 3, j - 3, k - 2) == NovaCraftBlocks.block_of_vanite
                && world.getBlock(i - 3, j - 3, k - 4) == NovaCraftBlocks.block_of_vanite
                
                && world.getBlock(i - 4, j - 3, k - 4) == NovaCraftBlocks.block_of_vanite
                && world.getBlock(i - 2, j - 3, k - 2) == NovaCraftBlocks.block_of_vanite
                && world.getBlock(i - 2, j - 3, k - 4) == NovaCraftBlocks.block_of_vanite
                && world.getBlock(i - 4, j - 3, k - 2) == NovaCraftBlocks.block_of_vanite
                
                && world.getBlock(i - 4, j - 2, k) == NovaCraftBlocks.null_wart
                && world.getBlock(i - 4, j - 2, k + 1) == NovaCraftBlocks.null_wart
                && world.getBlock(i - 4, j - 2, k - 1) == NovaCraftBlocks.null_wart
                
                && world.getBlock(i + 4, j - 2, k) == NovaCraftBlocks.null_wart
                && world.getBlock(i + 4, j - 2, k + 1) == NovaCraftBlocks.null_wart
                && world.getBlock(i + 4, j - 2, k - 1) == NovaCraftBlocks.null_wart
                
                && world.getBlock(i, j - 2, k + 4) == NovaCraftBlocks.null_wart
                && world.getBlock(i - 1, j - 2, k + 4) == NovaCraftBlocks.null_wart
                && world.getBlock(i + 1, j - 2, k + 4) == NovaCraftBlocks.null_wart
                
                && world.getBlock(i, j - 2, k - 4) == NovaCraftBlocks.null_wart
                && world.getBlock(i - 1, j - 2, k - 4) == NovaCraftBlocks.null_wart
                && world.getBlock(i + 1, j - 2, k - 4) == NovaCraftBlocks.null_wart
                
                )
                {

                     if (true) {
                     world.spawnEntityInWorld(new EntityLightningBolt(world, i, j + 1, k));
                     
                     world.setBlock(i, j, k, Blocks.air, 0, 2);
                     
                     world.setBlock(i, j, k + 2, Blocks.air, 0, 2); //aether buds
                     world.setBlock(i, j, k - 2, Blocks.air, 0, 2);
                     world.setBlock(i, j + 1, k - 2, Blocks.air, 0, 2);
                     world.setBlock(i, j + 1, k + 2, Blocks.air, 0, 2);
                     
                     world.setBlock(i - 2, j, k, Blocks.air, 0, 2); //null buds
                     world.setBlock(i + 2, j, k, Blocks.air, 0, 2);
                     world.setBlock(i - 2, j + 1, k, Blocks.air, 0, 2);
                     world.setBlock(i + 2, j + 1, k, Blocks.air, 0, 2);
                     
                     world.setBlock(i, j - 1, k, Blocks.air, 0, 2); //crystalized end
                     world.setBlock(i, j - 1, k - 1, Blocks.air, 0, 2);
                     world.setBlock(i, j - 1, k + 1, Blocks.air, 0, 2);
                     world.setBlock(i - 1, j - 1, k, Blocks.air, 0, 2);                    
                     world.setBlock(i + 1, j - 1, k, Blocks.air, 0, 2);
                     world.setBlock(i + 1, j - 1, k - 1, Blocks.air, 0, 2);
                     world.setBlock(i + 1, j - 1, k + 1, Blocks.air, 0, 2);
                     world.setBlock(i - 1, j - 1, k - 1, Blocks.air, 0, 2);
                     world.setBlock(i - 1, j - 1, k + 1, Blocks.air, 0, 2);                   
                     

                     world.setBlock(i + 2, j - 1, k, Blocks.end_portal_frame, 1, 2); //endstone
                     world.setBlock(i + 2, j - 1, k + 1, Blocks.end_portal_frame, 1, 2);
                     world.setBlock(i + 2, j - 1, k - 1, Blocks.end_portal_frame, 1, 2);
                     
                     world.setBlock(i - 2, j - 1, k, Blocks.end_portal_frame, 3, 2);
                     world.setBlock(i - 2, j - 1, k + 1, Blocks.end_portal_frame, 3, 2);
                     world.setBlock(i - 2, j - 1, k - 1, Blocks.end_portal_frame, 3, 2);
                     
                     world.setBlock(i, j - 1, k - 2, Blocks.end_portal_frame, 0, 2);
                     world.setBlock(i + 1, j - 1, k - 2, Blocks.end_portal_frame, 0, 2);
                     world.setBlock(i - 1, j - 1, k - 2, Blocks.end_portal_frame, 0, 2);
                     
                     world.setBlock(i, j - 1, k + 2, Blocks.end_portal_frame, 2, 2);
                     world.setBlock(i + 1, j - 1, k + 2, Blocks.end_portal_frame, 2, 2);
                     world.setBlock(i - 1, j - 1, k + 2, Blocks.end_portal_frame, 2, 2);
                     
                     
                     world.setBlock(i - 2, j - 1, k + 2, NovaCraftBlocks.cracked_larimar_block, 0, 2);
                     world.setBlock(i - 2, j, k + 2, NovaCraftBlocks.cracked_larimar_block, 0, 2);
                     world.setBlock(i - 2, j + 1, k + 2, NovaCraftBlocks.cracked_larimar_block, 0, 2);
                     world.setBlock(i - 2, j + 2, k + 2, NovaCraftBlocks.cracked_larimar_block, 0, 2);                    
                     world.setBlock(i - 2, j + 3, k + 2, NovaCraftBlocks.cracked_larimar_block, 0, 2);
                     world.setBlock(i - 2, j + 4, k + 2, NovaCraftBlocks.cracked_larimar_block, 0, 2);
                     world.setBlock(i - 2, j + 5, k + 2, Blocks.fire, 0, 2);
                     
                     world.setBlock(i - 2, j - 1, k - 2, NovaCraftBlocks.cracked_yttrlinsite_block, 0, 2);
                     world.setBlock(i - 2, j, k - 2, NovaCraftBlocks.cracked_yttrlinsite_block, 0, 2);
                     world.setBlock(i - 2, j + 1, k - 2, NovaCraftBlocks.cracked_yttrlinsite_block, 0, 2);
                     world.setBlock(i - 2, j + 2, k - 2, NovaCraftBlocks.cracked_yttrlinsite_block, 0, 2);                    
                     world.setBlock(i - 2, j + 3, k - 2, NovaCraftBlocks.cracked_yttrlinsite_block, 0, 2);
                     world.setBlock(i - 2, j + 4, k - 2, NovaCraftBlocks.cracked_yttrlinsite_block, 0, 2);
                     world.setBlock(i - 2, j + 5, k - 2, Blocks.fire, 0, 2);
                     
                     world.setBlock(i + 2, j - 1, k + 2, NovaCraftBlocks.cracked_tsavorokite_block, 0, 2);
                     world.setBlock(i + 2, j, k + 2, NovaCraftBlocks.cracked_tsavorokite_block, 0, 2);
                     world.setBlock(i + 2, j + 1, k + 2, NovaCraftBlocks.cracked_tsavorokite_block, 0, 2);
                     world.setBlock(i + 2, j + 2, k + 2, NovaCraftBlocks.cracked_tsavorokite_block, 0, 2);                    
                     world.setBlock(i + 2, j + 3, k + 2, NovaCraftBlocks.cracked_tsavorokite_block, 0, 2);
                     world.setBlock(i + 2, j + 4, k + 2, NovaCraftBlocks.cracked_tsavorokite_block, 0, 2);
                     world.setBlock(i + 2, j + 5, k + 2, Blocks.fire, 0, 2);
                                                            
                     world.setBlock(i + 2, j - 1, k - 2, NovaCraftBlocks.cracked_copartz_block, 0, 2);
                     world.setBlock(i + 2, j, k - 2, NovaCraftBlocks.cracked_copartz_block, 0, 2);
                     world.setBlock(i + 2, j + 1, k - 2, NovaCraftBlocks.cracked_copartz_block, 0, 2);
                     world.setBlock(i + 2, j + 2, k - 2, NovaCraftBlocks.cracked_copartz_block, 0, 2);                    
                     world.setBlock(i + 2, j + 3, k - 2, NovaCraftBlocks.cracked_copartz_block, 0, 2);
                     world.setBlock(i + 2, j + 4, k - 2, NovaCraftBlocks.cracked_copartz_block, 0, 2);
                     world.setBlock(i + 2, j + 5, k - 2, Blocks.fire, 0, 2);
                     
                     
                     world.setBlock(i + 3, j - 2, k, Blocks.air, 0, 2); //sculk endstone and sculk tentacles 
                     world.setBlock(i + 3, j - 2, k + 1, Blocks.air, 0, 2);
                     world.setBlock(i + 3, j - 2, k + 2, Blocks.air, 0, 2);
                     world.setBlock(i + 3, j - 2, k - 1, Blocks.air, 0, 2);
                     world.setBlock(i + 3, j - 2, k - 2, Blocks.air, 0, 2);                   
                     world.setBlock(i + 3, j - 1, k, Blocks.air, 0, 2);
                     world.setBlock(i + 3, j - 1, k + 1, Blocks.air, 0, 2);
                     world.setBlock(i + 3, j - 1, k + 2, Blocks.air, 0, 2);
                     world.setBlock(i + 3, j - 1, k - 1, Blocks.air, 0, 2);
                     world.setBlock(i + 3, j - 1, k - 2, Blocks.air, 0, 2);
                     
                     world.setBlock(i - 3, j - 2, k, Blocks.air, 0, 2);
                     world.setBlock(i - 3, j - 2, k + 1, Blocks.air, 0, 2);
                     world.setBlock(i - 3, j - 2, k + 2, Blocks.air, 0, 2);
                     world.setBlock(i - 3, j - 2, k - 1, Blocks.air, 0, 2);
                     world.setBlock(i - 3, j - 2, k - 2, Blocks.air, 0, 2);                   
                     world.setBlock(i - 3, j - 1, k, Blocks.air, 0, 2);
                     world.setBlock(i - 3, j - 1, k + 1, Blocks.air, 0, 2);
                     world.setBlock(i - 3, j - 1, k + 2, Blocks.air, 0, 2);
                     world.setBlock(i - 3, j - 1, k - 1, Blocks.air, 0, 2);
                     world.setBlock(i - 3, j - 1, k - 2, Blocks.air, 0, 2);
                     
                     world.setBlock(i, j - 2, k - 3, Blocks.air, 0, 2);
                     world.setBlock(i + 1, j - 2, k - 3, Blocks.air, 0, 2);
                     world.setBlock(i + 2, j - 2, k - 3, Blocks.air, 0, 2);
                     world.setBlock(i - 1, j - 2, k - 3, Blocks.air, 0, 2);
                     world.setBlock(i - 2, j - 2, k - 3, Blocks.air, 0, 2);                      
                     world.setBlock(i, j - 1, k - 3, Blocks.air, 0, 2);
                     world.setBlock(i - 1, j - 1, k - 3, Blocks.air, 0, 2);
                     world.setBlock(i - 2, j - 1, k - 3, Blocks.air, 0, 2);
                     world.setBlock(i + 1, j - 1, k - 3, Blocks.air, 0, 2);
                     world.setBlock(i + 2, j - 1, k - 3, Blocks.air, 0, 2);
                     
                     world.setBlock(i, j - 2, k + 3, Blocks.air, 0, 2);
                     world.setBlock(i + 1, j - 2, k + 3, Blocks.air, 0, 2);
                     world.setBlock(i + 2, j - 2, k + 3, Blocks.air, 0, 2);
                     world.setBlock(i - 1, j - 2, k + 3, Blocks.air, 0, 2);
                     world.setBlock(i - 2, j - 2, k + 3, Blocks.air, 0, 2);                      
                     world.setBlock(i, j - 1, k + 3, Blocks.air, 0, 2);
                     world.setBlock(i - 1, j - 1, k + 3, Blocks.air, 0, 2);
                     world.setBlock(i - 2, j - 1, k + 3, Blocks.air, 0, 2);
                     world.setBlock(i + 1, j - 1, k + 3, Blocks.air, 0, 2);
                     world.setBlock(i + 2, j - 1, k + 3, Blocks.air, 0, 2);
                                                                                                            
                     world.setBlock(i - 3, j - 2, k - 3, Blocks.air, 0, 2); //beacons
                     world.setBlock(i + 3, j - 2, k + 3, Blocks.air, 0, 2); 
                     world.setBlock(i - 3, j - 2, k + 3, Blocks.air, 0, 2); 
                     world.setBlock(i + 3, j - 3, k - 3, Blocks.air, 0, 2);
                     
                     world.setBlock(i + 3, j - 3, k + 3, Blocks.air, 0, 2); //vanite blocks
                     world.setBlock(i + 4, j - 3, k + 3, Blocks.air, 0, 2);
                     world.setBlock(i + 2, j - 3, k + 3, Blocks.air, 0, 2);
                     world.setBlock(i + 3, j - 3, k + 4, Blocks.air, 0, 2);
                     world.setBlock(i + 3, j - 3, k + 2, Blocks.air, 0, 2);                     
                     world.setBlock(i + 2, j - 3, k + 2, Blocks.air, 0, 2);
                     world.setBlock(i + 4, j - 3, k + 4, Blocks.air, 0, 2);
                     world.setBlock(i + 2, j - 3, k + 4, Blocks.air, 0, 2);
                     world.setBlock(i + 4, j - 3, k + 2, Blocks.air, 0, 2);
                                         
                     world.setBlock(i + 3, j - 3, k - 3, Blocks.air, 0, 2);
                     world.setBlock(i + 2, j - 3, k - 3, Blocks.air, 0, 2);
                     world.setBlock(i + 4, j - 3, k - 3, Blocks.air, 0, 2);
                     world.setBlock(i + 3, j - 3, k - 4, Blocks.air, 0, 2);
                     world.setBlock(i + 3, j - 3, k - 2, Blocks.air, 0, 2);                     
                     world.setBlock(i + 4, j - 3, k - 2, Blocks.air, 0, 2);
                     world.setBlock(i + 2, j - 3, k - 4, Blocks.air, 0, 2);
                     world.setBlock(i + 4, j - 3, k - 2, Blocks.air, 0, 2);
                     world.setBlock(i + 2, j - 3, k - 4, Blocks.air, 0, 2);
                     
                     world.setBlock(i - 3, j - 3, k + 3, Blocks.air, 0, 2);
                     world.setBlock(i - 4, j - 3, k + 3, Blocks.air, 0, 2);
                     world.setBlock(i - 2, j - 3, k + 3, Blocks.air, 0, 2);
                     world.setBlock(i - 3, j - 3, k + 2, Blocks.air, 0, 2);
                     world.setBlock(i - 3, j - 3, k + 4, Blocks.air, 0, 2);                    
                     world.setBlock(i - 4, j - 3, k + 2, Blocks.air, 0, 2);
                     world.setBlock(i - 2, j - 3, k + 4, Blocks.air, 0, 2);
                     world.setBlock(i - 2, j - 3, k + 2, Blocks.air, 0, 2);
                     world.setBlock(i - 4, j - 3, k + 2, Blocks.air, 0, 2);
                     
                     world.setBlock(i - 3, j - 3, k - 3, Blocks.air, 0, 2);
                     world.setBlock(i - 4, j - 3, k - 3, Blocks.air, 0, 2);
                     world.setBlock(i - 2, j - 3, k - 3, Blocks.air, 0, 2);
                     world.setBlock(i - 3, j - 3, k - 2, Blocks.air, 0, 2);
                     world.setBlock(i - 3, j - 3, k - 4, Blocks.air, 0, 2);                    
                     world.setBlock(i - 4, j - 3, k - 2, Blocks.air, 0, 2);
                     world.setBlock(i - 2, j - 3, k - 4, Blocks.air, 0, 2);
                     world.setBlock(i - 2, j - 3, k - 2, Blocks.air, 0, 2);
                     world.setBlock(i - 4, j - 3, k - 2, Blocks.air, 0, 2);   
                     
                     world.setBlock(i - 4, j - 3, k + 4, Blocks.air, 0, 2);
                     world.setBlock(i - 4, j - 3, k - 4, Blocks.air, 0, 2);
                     
                     world.setBlock(i + 3, j - 2, k - 3, Blocks.air, 0, 2);
                     world.setBlock(i + 4, j - 3, k - 4, Blocks.air, 0, 2);
                     world.setBlock(i + 2, j - 3, k - 2, Blocks.air, 0, 2);
                                        
                     world.setBlock(i - 4, j - 2, k, Blocks.air, 0, 2); //nullwart
                     world.setBlock(i - 4, j - 2, k + 1, Blocks.air, 0, 2);
                     world.setBlock(i - 4, j - 2, k - 1, Blocks.air, 0, 2);
                     
                     world.setBlock(i + 4, j - 2, k, Blocks.air, 0, 2);
                     world.setBlock(i + 4, j - 2, k + 1, Blocks.air, 0, 2);
                     world.setBlock(i + 4, j - 2, k - 1, Blocks.air, 0, 2);
                     
                     world.setBlock(i, j - 2, k + 4, Blocks.air, 0, 2);
                     world.setBlock(i - 1, j - 2, k + 4, Blocks.air, 0, 2);
                     world.setBlock(i + 1, j - 2, k + 4, Blocks.air, 0, 2);
                     
                     world.setBlock(i, j - 2, k - 4, Blocks.air, 0, 2);
                     world.setBlock(i - 1, j - 2, k - 4, Blocks.air, 0, 2);
                     world.setBlock(i + 1, j - 2, k - 4, Blocks.air, 0, 2);
                     

                     

                     	}
                     }
                }

		world.scheduleBlockUpdate(i, j, k, this, this.tickRate(world));
	}
	
	@Override
	public int tickRate(World world) {
		return 100;
	}
	
	
}
