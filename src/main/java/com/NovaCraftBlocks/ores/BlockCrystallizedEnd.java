package com.NovaCraftBlocks.ores;

import java.util.Random;

import com.NovaCraft.NovaCraft;
import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.entity.EntityWarden;
import com.NovaCraft.registry.OtherModBlocks;
import com.NovaCraft.sounds.ModSounds;
import com.NovaCraftBlocks.NovaCraftBlocks;
import com.ibm.icu.impl.duration.impl.Utils;

import cpw.mods.fml.common.Loader;
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
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCrystallizedEnd extends Block {
	
	public BlockCrystallizedEnd() {
		super(Material.glass);
		this.setHardness(40F);
		this.setResistance(100F);
		this.setStepSound(ModSounds.soundVoid);
		this.setHarvestLevel("pickaxe", 3);
		this.setTickRandomly(true);
	}
	
	public void registerBlockIcons(final IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon("nova_craft:crystallized_end");
    }

	
	@SideOnly(Side.CLIENT)
    public void randomDisplayTick(World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_)
    {
        super.randomDisplayTick(p_149734_1_, p_149734_2_, p_149734_3_, p_149734_4_, p_149734_5_);

        if (p_149734_5_.nextInt(2) == 0)
        {
            p_149734_1_.spawnParticle("townaura", (double)((float)p_149734_2_ + p_149734_5_.nextFloat()), (double)((float)p_149734_3_ + 1.1F), (double)((float)p_149734_4_ + p_149734_5_.nextFloat()), 0.0D, 0.0D, 0.0D);
        }
    } 
	
	protected boolean canSilkHarvest() {
	    return true;
	 }
	
	 public int quantityDropped(final Random random) {
	       return 2 + random.nextInt(2);
	   }
		
	public Item getItemDropped(final int metadata, final Random rand, final int fortune) {
	       return NovaCraftItems.crystallized_end_shard;
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
			
				amount = MathHelper.getRandomIntegerInRange(random, 2, 6);
			

			return amount;
		}

		return 0;
	}
	
	public void updateTick(World world, int i, int j, int k, Random random) {
					//Ore -> Block Structure
					//Iron Ore
		 			if (world.getBlock(i, j + 1, k) == NovaCraftBlocks.null_cluster_2
		 				&& world.getBlock(i, j + 4, k) == NovaCraftBlocks.sculk_nullstone
		 				&& world.getBlock(i, j + 5, k) == NovaCraftBlocks.sculk_tentacle_2
		 				
		 				&& world.getBlock(i - 1, j, k + 1) == NovaCraftBlocks.nullstone_bricks
		                && world.getBlock(i - 1, j + 1, k + 1) == NovaCraftBlocks.larimar_block
		                && world.getBlock(i - 1, j + 2, k + 1) == NovaCraftBlocks.larimar_block
		                && world.getBlock(i - 1, j + 3, k + 1) == NovaCraftBlocks.larimar_block
		                
		                && world.getBlock(i + 1, j, k - 1) == NovaCraftBlocks.nullstone_bricks 
		                && world.getBlock(i + 1, j + 1, k - 1) == NovaCraftBlocks.copartz_block
		                && world.getBlock(i + 1, j + 2, k - 1) == NovaCraftBlocks.copartz_block
		                && world.getBlock(i + 1, j + 3, k - 1) == NovaCraftBlocks.copartz_block
		                
		              	&& world.getBlock(i + 1, j, k + 1) == NovaCraftBlocks.nullstone_bricks
		                && world.getBlock(i + 1, j + 1, k + 1) == NovaCraftBlocks.tsavorokite_block
		                && world.getBlock(i + 1, j + 2, k + 1) == NovaCraftBlocks.tsavorokite_block
		                && world.getBlock(i + 1, j + 3, k + 1) == NovaCraftBlocks.tsavorokite_block
		                
		                && world.getBlock(i - 1, j, k - 1) == NovaCraftBlocks.nullstone_bricks
		                && world.getBlock(i - 1, j + 1, k - 1) == NovaCraftBlocks.yttrlinsite_block
		                && world.getBlock(i - 1, j + 2, k - 1) == NovaCraftBlocks.yttrlinsite_block
		                && world.getBlock(i - 1, j + 3, k - 1) == NovaCraftBlocks.yttrlinsite_block
		                
		                && world.getBlock(i + 2, j, k + 2) == NovaCraftBlocks.nullstone
		                && world.getBlock(i + 2, j + 1, k + 2) == NovaCraftBlocks.null_wart
		                
		                && world.getBlock(i - 2, j, k - 2) == NovaCraftBlocks.nullstone
		                && world.getBlock(i - 2, j + 1, k - 2) == NovaCraftBlocks.null_wart
		                
		                && world.getBlock(i - 2, j, k + 2) == NovaCraftBlocks.nullstone
		                && world.getBlock(i - 2, j + 1, k + 2) == NovaCraftBlocks.null_wart
		                
		                && world.getBlock(i + 2, j, k - 2) == NovaCraftBlocks.nullstone
		                && world.getBlock(i + 2, j + 1, k - 2) == NovaCraftBlocks.null_wart
		                
		                && world.getBlock(i + 3, j, k + 3) == NovaCraftBlocks.nullstone_bricks
		                && world.getBlock(i + 3, j + 1, k + 3) == NovaCraftBlocks.nullstone_bricks
		                && world.getBlock(i + 3, j + 2, k + 3) == NovaCraftBlocks.nullstone_bricks
		                && world.getBlock(i + 3, j + 3, k + 3) == NovaCraftBlocks.nullstone_bricks
		                && world.getBlock(i + 3, j + 4, k + 3) == NovaCraftBlocks.nullstone_bricks
		                && world.getBlock(i + 3, j + 5, k + 3) == NovaCraftBlocks.block_of_reinforced_vanite
		                
		                && world.getBlock(i - 3, j, k + 3) == NovaCraftBlocks.nullstone_bricks
		                && world.getBlock(i - 3, j + 1, k + 3) == NovaCraftBlocks.nullstone_bricks
		                && world.getBlock(i - 3, j + 2, k + 3) == NovaCraftBlocks.nullstone_bricks
		                && world.getBlock(i - 3, j + 3, k + 3) == NovaCraftBlocks.nullstone_bricks
		                && world.getBlock(i - 3, j + 4, k + 3) == NovaCraftBlocks.nullstone_bricks
		                && world.getBlock(i - 3, j + 5, k + 3) == NovaCraftBlocks.block_of_reinforced_vanite
		                
		                && world.getBlock(i + 3, j, k - 3) == NovaCraftBlocks.nullstone_bricks
		                && world.getBlock(i + 3, j + 1, k - 3) == NovaCraftBlocks.nullstone_bricks
		                && world.getBlock(i + 3, j + 2, k - 3) == NovaCraftBlocks.nullstone_bricks
		                && world.getBlock(i + 3, j + 3, k - 3) == NovaCraftBlocks.nullstone_bricks
		                && world.getBlock(i + 3, j + 4, k - 3) == NovaCraftBlocks.nullstone_bricks
		                && world.getBlock(i + 3, j + 5, k - 3) == NovaCraftBlocks.block_of_reinforced_vanite
		                
		                && world.getBlock(i - 3, j, k - 3) == NovaCraftBlocks.nullstone_bricks
		                && world.getBlock(i - 3, j + 1, k - 3) == NovaCraftBlocks.nullstone_bricks
		                && world.getBlock(i - 3, j + 2, k - 3) == NovaCraftBlocks.nullstone_bricks
		                && world.getBlock(i - 3, j + 3, k - 3) == NovaCraftBlocks.nullstone_bricks
		                && world.getBlock(i - 3, j + 4, k - 3) == NovaCraftBlocks.nullstone_bricks
		                && world.getBlock(i - 3, j + 5, k - 3) == NovaCraftBlocks.block_of_reinforced_vanite
		                
		                && (world.getBlock(i, j + 2, k) == Blocks.iron_ore || world.getBlock(i, j + 2, k) == NovaCraftBlocks.grimstone_iron || world.getBlock(i, j + 2, k) == NovaCraftBlocks.nullstone_iron)
		                && (world.getBlock(i, j + 3, k) == Blocks.iron_ore || world.getBlock(i, j + 3, k) == NovaCraftBlocks.grimstone_iron || world.getBlock(i, j + 3, k) == NovaCraftBlocks.nullstone_iron)
		                                                
		                )
		                {

		                     if (true) {
		                     world.spawnEntityInWorld(new EntityLightningBolt(world, i, j + 2, k));
		                     
		                     world.setBlock(i, j, k, NovaCraftBlocks.cobbled_nullstone);
		                     world.setBlock(i, j + 2, k, Blocks.iron_block);
		                     world.setBlock(i, j + 3, k, Blocks.iron_block);
		                     
		                     int rand = (int)(1 + Math.random() * 4);
		            		 switch (rand)
		            	     {
		            	     case 1:
		            	     break;
		            	     
		            	     case 2:
		            	     world.setBlock(i, j + 1, k, Blocks.air); 
		            	     break;
		            	     
		            	     case 3:
		            	     world.setBlock(i, j + 1, k, Blocks.air);
		            	     break;
		            	     
		            	     case 4:
		            	     world.setBlock(i, j + 1, k, NovaCraftBlocks.null_cluster_1);
			            	 break;
		                     }
		                     
		                     world.setBlock(i, j + 4, k,  NovaCraftBlocks.nullstone);
		     		 		 world.setBlock(i, j + 5, k, Blocks.air);
		     		 		 
		     		 		 
		     		 		world.setBlock(i - 1, j + 1, k + 1, NovaCraftBlocks.cracked_larimar_block);
		     		 		world.setBlock(i - 1, j + 2, k + 1, NovaCraftBlocks.cracked_larimar_block);
		     		 		world.setBlock(i - 1, j + 3, k + 1, NovaCraftBlocks.cracked_larimar_block);
		     		 		
		     		 		world.setBlock(i + 1, j + 1, k - 1, NovaCraftBlocks.cracked_copartz_block);
		     		 		world.setBlock(i + 1, j + 2, k - 1, NovaCraftBlocks.cracked_copartz_block);
		     		 		world.setBlock(i + 1, j + 3, k - 1, NovaCraftBlocks.cracked_copartz_block);
		     		 		
		     		 		world.setBlock(i + 1, j + 1, k + 1, NovaCraftBlocks.cracked_tsavorokite_block);
		     		 		world.setBlock(i + 1, j + 2, k + 1, NovaCraftBlocks.cracked_tsavorokite_block);
		     		 		world.setBlock(i + 1, j + 3, k + 1, NovaCraftBlocks.cracked_tsavorokite_block);
		     		 		
		     		 		world.setBlock(i - 1, j + 1, k - 1, NovaCraftBlocks.cracked_yttrlinsite_block);
		     		 		world.setBlock(i - 1, j + 2, k - 1, NovaCraftBlocks.cracked_yttrlinsite_block);
		     		 		world.setBlock(i - 1, j + 3, k - 1, NovaCraftBlocks.cracked_yttrlinsite_block);
		     		 		
		     		 		world.setBlock(i + 2, j + 1, k + 2, Blocks.air);
		     		 		world.setBlock(i - 2, j + 1, k - 2, Blocks.air);
		     		 		world.setBlock(i - 2, j + 1, k + 2, Blocks.air);
		     		 		world.setBlock(i + 2, j + 1, k - 2, Blocks.air);
		     		 		
		     		 		world.setBlock(i + 3, j + 5, k + 3, Blocks.air);
		     		 		world.setBlock(i - 3, j + 5, k - 3, Blocks.air);
		     		 		
		     		 		
		     		 		int rand2 = (int)(1 + Math.random() * 4);
		            		 switch (rand2)
		            	     {
		            	     case 1:
		            	     world.setBlock(i - 3, j + 5, k + 3, Blocks.air);
			            	 break;
			            	 
		            	     case 2:
		            	     world.setBlock(i + 3, j + 5, k - 3, Blocks.air);
				             break;
				             
		            	     case 3:
		            	     world.setBlock(i - 3, j + 5, k + 3, Blocks.air);
			            	 world.setBlock(i + 3, j + 5, k - 3, Blocks.air);
					         break;
					         
		            	     case 4:
				             break;
		            	     }

		                     	}
		                     }
		 			
		 			//Diamond Ore
		 			if (world.getBlock(i, j + 1, k) == NovaCraftBlocks.null_cluster_2
			 				&& world.getBlock(i, j + 4, k) == NovaCraftBlocks.sculk_nullstone
			 				&& world.getBlock(i, j + 5, k) == NovaCraftBlocks.sculk_tentacle_2
			 				
			 				&& world.getBlock(i - 1, j, k + 1) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 1, j + 1, k + 1) == NovaCraftBlocks.larimar_block
			                && world.getBlock(i - 1, j + 2, k + 1) == NovaCraftBlocks.larimar_block
			                && world.getBlock(i - 1, j + 3, k + 1) == NovaCraftBlocks.larimar_block
			                
			                && world.getBlock(i + 1, j, k - 1) == NovaCraftBlocks.nullstone_bricks 
			                && world.getBlock(i + 1, j + 1, k - 1) == NovaCraftBlocks.copartz_block
			                && world.getBlock(i + 1, j + 2, k - 1) == NovaCraftBlocks.copartz_block
			                && world.getBlock(i + 1, j + 3, k - 1) == NovaCraftBlocks.copartz_block
			                
			              	&& world.getBlock(i + 1, j, k + 1) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 1, j + 1, k + 1) == NovaCraftBlocks.tsavorokite_block
			                && world.getBlock(i + 1, j + 2, k + 1) == NovaCraftBlocks.tsavorokite_block
			                && world.getBlock(i + 1, j + 3, k + 1) == NovaCraftBlocks.tsavorokite_block
			                
			                && world.getBlock(i - 1, j, k - 1) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 1, j + 1, k - 1) == NovaCraftBlocks.yttrlinsite_block
			                && world.getBlock(i - 1, j + 2, k - 1) == NovaCraftBlocks.yttrlinsite_block
			                && world.getBlock(i - 1, j + 3, k - 1) == NovaCraftBlocks.yttrlinsite_block
			                
			                && world.getBlock(i + 2, j, k + 2) == NovaCraftBlocks.nullstone
			                && world.getBlock(i + 2, j + 1, k + 2) == NovaCraftBlocks.null_wart
			                
			                && world.getBlock(i - 2, j, k - 2) == NovaCraftBlocks.nullstone
			                && world.getBlock(i - 2, j + 1, k - 2) == NovaCraftBlocks.null_wart
			                
			                && world.getBlock(i - 2, j, k + 2) == NovaCraftBlocks.nullstone
			                && world.getBlock(i - 2, j + 1, k + 2) == NovaCraftBlocks.null_wart
			                
			                && world.getBlock(i + 2, j, k - 2) == NovaCraftBlocks.nullstone
			                && world.getBlock(i + 2, j + 1, k - 2) == NovaCraftBlocks.null_wart
			                
			                && world.getBlock(i + 3, j, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 1, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 2, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 3, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 4, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 5, k + 3) == NovaCraftBlocks.block_of_reinforced_vanite
			                
			                && world.getBlock(i - 3, j, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 1, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 2, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 3, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 4, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 5, k + 3) == NovaCraftBlocks.block_of_reinforced_vanite
			                
			                && world.getBlock(i + 3, j, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 1, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 2, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 3, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 4, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 5, k - 3) == NovaCraftBlocks.block_of_reinforced_vanite
			                
			                && world.getBlock(i - 3, j, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 1, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 2, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 3, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 4, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 5, k - 3) == NovaCraftBlocks.block_of_reinforced_vanite
			                
			                && (world.getBlock(i, j + 2, k) == Blocks.diamond_ore || world.getBlock(i, j + 2, k) == NovaCraftBlocks.grimstone_diamond || world.getBlock(i, j + 2, k) == NovaCraftBlocks.nullstone_diamond)
			                && (world.getBlock(i, j + 3, k) == Blocks.diamond_ore || world.getBlock(i, j + 3, k) == NovaCraftBlocks.grimstone_diamond || world.getBlock(i, j + 3, k) == NovaCraftBlocks.nullstone_diamond)
			                                                
			                )
			                {

			                     if (true) {
			                     world.spawnEntityInWorld(new EntityLightningBolt(world, i, j + 2, k));
			                     
			                     world.setBlock(i, j, k, NovaCraftBlocks.cobbled_nullstone);
			                     world.setBlock(i, j + 2, k, Blocks.diamond_block);
			                     world.setBlock(i, j + 3, k, Blocks.diamond_block);
			                     
			                     int rand = (int)(1 + Math.random() * 4);
			            		 switch (rand)
			            	     {
			            	     case 1:
			            	     break;
			            	     
			            	     case 2:
			            	     world.setBlock(i, j + 1, k, Blocks.air); 
			            	     break;
			            	     
			            	     case 3:
			            	     world.setBlock(i, j + 1, k, Blocks.air);
			            	     break;
			            	     
			            	     case 4:
			            	     world.setBlock(i, j + 1, k, NovaCraftBlocks.null_cluster_1);
				            	 break;
			                     }
			                     
			                     world.setBlock(i, j + 4, k,  NovaCraftBlocks.nullstone);
			     		 		 world.setBlock(i, j + 5, k, Blocks.air);
			     		 		 
			     		 		 
			     		 		world.setBlock(i - 1, j + 1, k + 1, NovaCraftBlocks.cracked_larimar_block);
			     		 		world.setBlock(i - 1, j + 2, k + 1, NovaCraftBlocks.cracked_larimar_block);
			     		 		world.setBlock(i - 1, j + 3, k + 1, NovaCraftBlocks.cracked_larimar_block);
			     		 		
			     		 		world.setBlock(i + 1, j + 1, k - 1, NovaCraftBlocks.cracked_copartz_block);
			     		 		world.setBlock(i + 1, j + 2, k - 1, NovaCraftBlocks.cracked_copartz_block);
			     		 		world.setBlock(i + 1, j + 3, k - 1, NovaCraftBlocks.cracked_copartz_block);
			     		 		
			     		 		world.setBlock(i + 1, j + 1, k + 1, NovaCraftBlocks.cracked_tsavorokite_block);
			     		 		world.setBlock(i + 1, j + 2, k + 1, NovaCraftBlocks.cracked_tsavorokite_block);
			     		 		world.setBlock(i + 1, j + 3, k + 1, NovaCraftBlocks.cracked_tsavorokite_block);
			     		 		
			     		 		world.setBlock(i - 1, j + 1, k - 1, NovaCraftBlocks.cracked_yttrlinsite_block);
			     		 		world.setBlock(i - 1, j + 2, k - 1, NovaCraftBlocks.cracked_yttrlinsite_block);
			     		 		world.setBlock(i - 1, j + 3, k - 1, NovaCraftBlocks.cracked_yttrlinsite_block);
			     		 		
			     		 		world.setBlock(i + 2, j + 1, k + 2, Blocks.air);
			     		 		world.setBlock(i - 2, j + 1, k - 2, Blocks.air);
			     		 		world.setBlock(i - 2, j + 1, k + 2, Blocks.air);
			     		 		world.setBlock(i + 2, j + 1, k - 2, Blocks.air);
			     		 		
			     		 		world.setBlock(i + 3, j + 5, k + 3, Blocks.air);
			     		 		world.setBlock(i - 3, j + 5, k - 3, Blocks.air);
			     		 		
			     		 		
			     		 		int rand2 = (int)(1 + Math.random() * 4);
			            		 switch (rand2)
			            	     {
			            	     case 1:
			            	     world.setBlock(i - 3, j + 5, k + 3, Blocks.air);
				            	 break;
				            	 
			            	     case 2:
			            	     world.setBlock(i + 3, j + 5, k - 3, Blocks.air);
					             break;
					             
			            	     case 3:
			            	     world.setBlock(i - 3, j + 5, k + 3, Blocks.air);
				            	 world.setBlock(i + 3, j + 5, k - 3, Blocks.air);
						         break;
						         
			            	     case 4:
					             break;
			            	     }

			                     	}
			                     }
		 			//Gold Ore
		 			if (world.getBlock(i, j + 1, k) == NovaCraftBlocks.null_cluster_2
			 				&& world.getBlock(i, j + 4, k) == NovaCraftBlocks.sculk_nullstone
			 				&& world.getBlock(i, j + 5, k) == NovaCraftBlocks.sculk_tentacle_2
			 				
			 				&& world.getBlock(i - 1, j, k + 1) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 1, j + 1, k + 1) == NovaCraftBlocks.larimar_block
			                && world.getBlock(i - 1, j + 2, k + 1) == NovaCraftBlocks.larimar_block
			                && world.getBlock(i - 1, j + 3, k + 1) == NovaCraftBlocks.larimar_block
			                
			                && world.getBlock(i + 1, j, k - 1) == NovaCraftBlocks.nullstone_bricks 
			                && world.getBlock(i + 1, j + 1, k - 1) == NovaCraftBlocks.copartz_block
			                && world.getBlock(i + 1, j + 2, k - 1) == NovaCraftBlocks.copartz_block
			                && world.getBlock(i + 1, j + 3, k - 1) == NovaCraftBlocks.copartz_block
			                
			              	&& world.getBlock(i + 1, j, k + 1) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 1, j + 1, k + 1) == NovaCraftBlocks.tsavorokite_block
			                && world.getBlock(i + 1, j + 2, k + 1) == NovaCraftBlocks.tsavorokite_block
			                && world.getBlock(i + 1, j + 3, k + 1) == NovaCraftBlocks.tsavorokite_block
			                
			                && world.getBlock(i - 1, j, k - 1) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 1, j + 1, k - 1) == NovaCraftBlocks.yttrlinsite_block
			                && world.getBlock(i - 1, j + 2, k - 1) == NovaCraftBlocks.yttrlinsite_block
			                && world.getBlock(i - 1, j + 3, k - 1) == NovaCraftBlocks.yttrlinsite_block
			                
			                && world.getBlock(i + 2, j, k + 2) == NovaCraftBlocks.nullstone
			                && world.getBlock(i + 2, j + 1, k + 2) == NovaCraftBlocks.null_wart
			                
			                && world.getBlock(i - 2, j, k - 2) == NovaCraftBlocks.nullstone
			                && world.getBlock(i - 2, j + 1, k - 2) == NovaCraftBlocks.null_wart
			                
			                && world.getBlock(i - 2, j, k + 2) == NovaCraftBlocks.nullstone
			                && world.getBlock(i - 2, j + 1, k + 2) == NovaCraftBlocks.null_wart
			                
			                && world.getBlock(i + 2, j, k - 2) == NovaCraftBlocks.nullstone
			                && world.getBlock(i + 2, j + 1, k - 2) == NovaCraftBlocks.null_wart
			                
			                && world.getBlock(i + 3, j, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 1, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 2, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 3, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 4, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 5, k + 3) == NovaCraftBlocks.block_of_reinforced_vanite
			                
			                && world.getBlock(i - 3, j, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 1, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 2, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 3, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 4, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 5, k + 3) == NovaCraftBlocks.block_of_reinforced_vanite
			                
			                && world.getBlock(i + 3, j, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 1, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 2, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 3, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 4, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 5, k - 3) == NovaCraftBlocks.block_of_reinforced_vanite
			                
			                && world.getBlock(i - 3, j, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 1, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 2, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 3, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 4, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 5, k - 3) == NovaCraftBlocks.block_of_reinforced_vanite
			                
			                && (world.getBlock(i, j + 2, k) == Blocks.gold_ore || world.getBlock(i, j + 2, k) == NovaCraftBlocks.grimstone_gold || world.getBlock(i, j + 2, k) == NovaCraftBlocks.nullstone_gold)
			                && (world.getBlock(i, j + 3, k) == Blocks.gold_ore || world.getBlock(i, j + 3, k) == NovaCraftBlocks.grimstone_gold || world.getBlock(i, j + 3, k) == NovaCraftBlocks.nullstone_gold)
			                                                
			                )
			                {

			                     if (true) {
			                     world.spawnEntityInWorld(new EntityLightningBolt(world, i, j + 2, k));
			                     
			                     world.setBlock(i, j, k, NovaCraftBlocks.cobbled_nullstone);
			                     world.setBlock(i, j + 2, k, Blocks.gold_block);
			                     world.setBlock(i, j + 3, k, Blocks.gold_block);
			                     
			                     int rand = (int)(1 + Math.random() * 4);
			            		 switch (rand)
			            	     {
			            	     case 1:
			            	     break;
			            	     
			            	     case 2:
			            	     world.setBlock(i, j + 1, k, Blocks.air); 
			            	     break;
			            	     
			            	     case 3:
			            	     world.setBlock(i, j + 1, k, Blocks.air);
			            	     break;
			            	     
			            	     case 4:
			            	     world.setBlock(i, j + 1, k, NovaCraftBlocks.null_cluster_1);
				            	 break;
			                     }
			                     
			                     world.setBlock(i, j + 4, k,  NovaCraftBlocks.nullstone);
			     		 		 world.setBlock(i, j + 5, k, Blocks.air);
			     		 		 
			     		 		 
			     		 		world.setBlock(i - 1, j + 1, k + 1, NovaCraftBlocks.cracked_larimar_block);
			     		 		world.setBlock(i - 1, j + 2, k + 1, NovaCraftBlocks.cracked_larimar_block);
			     		 		world.setBlock(i - 1, j + 3, k + 1, NovaCraftBlocks.cracked_larimar_block);
			     		 		
			     		 		world.setBlock(i + 1, j + 1, k - 1, NovaCraftBlocks.cracked_copartz_block);
			     		 		world.setBlock(i + 1, j + 2, k - 1, NovaCraftBlocks.cracked_copartz_block);
			     		 		world.setBlock(i + 1, j + 3, k - 1, NovaCraftBlocks.cracked_copartz_block);
			     		 		
			     		 		world.setBlock(i + 1, j + 1, k + 1, NovaCraftBlocks.cracked_tsavorokite_block);
			     		 		world.setBlock(i + 1, j + 2, k + 1, NovaCraftBlocks.cracked_tsavorokite_block);
			     		 		world.setBlock(i + 1, j + 3, k + 1, NovaCraftBlocks.cracked_tsavorokite_block);
			     		 		
			     		 		world.setBlock(i - 1, j + 1, k - 1, NovaCraftBlocks.cracked_yttrlinsite_block);
			     		 		world.setBlock(i - 1, j + 2, k - 1, NovaCraftBlocks.cracked_yttrlinsite_block);
			     		 		world.setBlock(i - 1, j + 3, k - 1, NovaCraftBlocks.cracked_yttrlinsite_block);
			     		 		
			     		 		world.setBlock(i + 2, j + 1, k + 2, Blocks.air);
			     		 		world.setBlock(i - 2, j + 1, k - 2, Blocks.air);
			     		 		world.setBlock(i - 2, j + 1, k + 2, Blocks.air);
			     		 		world.setBlock(i + 2, j + 1, k - 2, Blocks.air);
			     		 		
			     		 		world.setBlock(i + 3, j + 5, k + 3, Blocks.air);
			     		 		world.setBlock(i - 3, j + 5, k - 3, Blocks.air);
			     		 		
			     		 		
			     		 		int rand2 = (int)(1 + Math.random() * 4);
			            		 switch (rand2)
			            	     {
			            	     case 1:
			            	     world.setBlock(i - 3, j + 5, k + 3, Blocks.air);
				            	 break;
				            	 
			            	     case 2:
			            	     world.setBlock(i + 3, j + 5, k - 3, Blocks.air);
					             break;
					             
			            	     case 3:
			            	     world.setBlock(i - 3, j + 5, k + 3, Blocks.air);
				            	 world.setBlock(i + 3, j + 5, k - 3, Blocks.air);
						         break;
						         
			            	     case 4:
					             break;
			            	     }

			                     	}
			                     }
		 			//Emerald Ore
		 			if (world.getBlock(i, j + 1, k) == NovaCraftBlocks.null_cluster_2
			 				&& world.getBlock(i, j + 4, k) == NovaCraftBlocks.sculk_nullstone
			 				&& world.getBlock(i, j + 5, k) == NovaCraftBlocks.sculk_tentacle_2
			 				
			 				&& world.getBlock(i - 1, j, k + 1) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 1, j + 1, k + 1) == NovaCraftBlocks.larimar_block
			                && world.getBlock(i - 1, j + 2, k + 1) == NovaCraftBlocks.larimar_block
			                && world.getBlock(i - 1, j + 3, k + 1) == NovaCraftBlocks.larimar_block
			                
			                && world.getBlock(i + 1, j, k - 1) == NovaCraftBlocks.nullstone_bricks 
			                && world.getBlock(i + 1, j + 1, k - 1) == NovaCraftBlocks.copartz_block
			                && world.getBlock(i + 1, j + 2, k - 1) == NovaCraftBlocks.copartz_block
			                && world.getBlock(i + 1, j + 3, k - 1) == NovaCraftBlocks.copartz_block
			                
			              	&& world.getBlock(i + 1, j, k + 1) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 1, j + 1, k + 1) == NovaCraftBlocks.tsavorokite_block
			                && world.getBlock(i + 1, j + 2, k + 1) == NovaCraftBlocks.tsavorokite_block
			                && world.getBlock(i + 1, j + 3, k + 1) == NovaCraftBlocks.tsavorokite_block
			                
			                && world.getBlock(i - 1, j, k - 1) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 1, j + 1, k - 1) == NovaCraftBlocks.yttrlinsite_block
			                && world.getBlock(i - 1, j + 2, k - 1) == NovaCraftBlocks.yttrlinsite_block
			                && world.getBlock(i - 1, j + 3, k - 1) == NovaCraftBlocks.yttrlinsite_block
			                
			                && world.getBlock(i + 2, j, k + 2) == NovaCraftBlocks.nullstone
			                && world.getBlock(i + 2, j + 1, k + 2) == NovaCraftBlocks.null_wart
			                
			                && world.getBlock(i - 2, j, k - 2) == NovaCraftBlocks.nullstone
			                && world.getBlock(i - 2, j + 1, k - 2) == NovaCraftBlocks.null_wart
			                
			                && world.getBlock(i - 2, j, k + 2) == NovaCraftBlocks.nullstone
			                && world.getBlock(i - 2, j + 1, k + 2) == NovaCraftBlocks.null_wart
			                
			                && world.getBlock(i + 2, j, k - 2) == NovaCraftBlocks.nullstone
			                && world.getBlock(i + 2, j + 1, k - 2) == NovaCraftBlocks.null_wart
			                
			                && world.getBlock(i + 3, j, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 1, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 2, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 3, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 4, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 5, k + 3) == NovaCraftBlocks.block_of_reinforced_vanite
			                
			                && world.getBlock(i - 3, j, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 1, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 2, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 3, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 4, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 5, k + 3) == NovaCraftBlocks.block_of_reinforced_vanite
			                
			                && world.getBlock(i + 3, j, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 1, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 2, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 3, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 4, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 5, k - 3) == NovaCraftBlocks.block_of_reinforced_vanite
			                
			                && world.getBlock(i - 3, j, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 1, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 2, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 3, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 4, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 5, k - 3) == NovaCraftBlocks.block_of_reinforced_vanite
			                
			                && (world.getBlock(i, j + 2, k) == Blocks.emerald_ore || world.getBlock(i, j + 2, k) == NovaCraftBlocks.grimstone_emerald || world.getBlock(i, j + 2, k) == NovaCraftBlocks.nullstone_emerald)
			                && (world.getBlock(i, j + 3, k) == Blocks.emerald_ore || world.getBlock(i, j + 3, k) == NovaCraftBlocks.grimstone_emerald || world.getBlock(i, j + 3, k) == NovaCraftBlocks.nullstone_emerald)
			                                                
			                )
			                {

			                     if (true) {
			                     world.spawnEntityInWorld(new EntityLightningBolt(world, i, j + 2, k));
			                     
			                     world.setBlock(i, j, k, NovaCraftBlocks.cobbled_nullstone);
			                     world.setBlock(i, j + 2, k, Blocks.emerald_block);
			                     world.setBlock(i, j + 3, k, Blocks.emerald_block);
			                     
			                     int rand = (int)(1 + Math.random() * 4);
			            		 switch (rand)
			            	     {
			            	     case 1:
			            	     break;
			            	     
			            	     case 2:
			            	     world.setBlock(i, j + 1, k, Blocks.air); 
			            	     break;
			            	     
			            	     case 3:
			            	     world.setBlock(i, j + 1, k, Blocks.air);
			            	     break;
			            	     
			            	     case 4:
			            	     world.setBlock(i, j + 1, k, NovaCraftBlocks.null_cluster_1);
				            	 break;
			                     }
			                     
			                     world.setBlock(i, j + 4, k,  NovaCraftBlocks.nullstone);
			     		 		 world.setBlock(i, j + 5, k, Blocks.air);
			     		 		 
			     		 		 
			     		 		world.setBlock(i - 1, j + 1, k + 1, NovaCraftBlocks.cracked_larimar_block);
			     		 		world.setBlock(i - 1, j + 2, k + 1, NovaCraftBlocks.cracked_larimar_block);
			     		 		world.setBlock(i - 1, j + 3, k + 1, NovaCraftBlocks.cracked_larimar_block);
			     		 		
			     		 		world.setBlock(i + 1, j + 1, k - 1, NovaCraftBlocks.cracked_copartz_block);
			     		 		world.setBlock(i + 1, j + 2, k - 1, NovaCraftBlocks.cracked_copartz_block);
			     		 		world.setBlock(i + 1, j + 3, k - 1, NovaCraftBlocks.cracked_copartz_block);
			     		 		
			     		 		world.setBlock(i + 1, j + 1, k + 1, NovaCraftBlocks.cracked_tsavorokite_block);
			     		 		world.setBlock(i + 1, j + 2, k + 1, NovaCraftBlocks.cracked_tsavorokite_block);
			     		 		world.setBlock(i + 1, j + 3, k + 1, NovaCraftBlocks.cracked_tsavorokite_block);
			     		 		
			     		 		world.setBlock(i - 1, j + 1, k - 1, NovaCraftBlocks.cracked_yttrlinsite_block);
			     		 		world.setBlock(i - 1, j + 2, k - 1, NovaCraftBlocks.cracked_yttrlinsite_block);
			     		 		world.setBlock(i - 1, j + 3, k - 1, NovaCraftBlocks.cracked_yttrlinsite_block);
			     		 		
			     		 		world.setBlock(i + 2, j + 1, k + 2, Blocks.air);
			     		 		world.setBlock(i - 2, j + 1, k - 2, Blocks.air);
			     		 		world.setBlock(i - 2, j + 1, k + 2, Blocks.air);
			     		 		world.setBlock(i + 2, j + 1, k - 2, Blocks.air);
			     		 		
			     		 		world.setBlock(i + 3, j + 5, k + 3, Blocks.air);
			     		 		world.setBlock(i - 3, j + 5, k - 3, Blocks.air);
			     		 		
			     		 		
			     		 		int rand2 = (int)(1 + Math.random() * 4);
			            		 switch (rand2)
			            	     {
			            	     case 1:
			            	     world.setBlock(i - 3, j + 5, k + 3, Blocks.air);
				            	 break;
				            	 
			            	     case 2:
			            	     world.setBlock(i + 3, j + 5, k - 3, Blocks.air);
					             break;
					             
			            	     case 3:
			            	     world.setBlock(i - 3, j + 5, k + 3, Blocks.air);
				            	 world.setBlock(i + 3, j + 5, k - 3, Blocks.air);
						         break;
						         
			            	     case 4:
					             break;
			            	     }

			                     	}
			                     }
		 			//Klangite Ore
		 			if (world.getBlock(i, j + 1, k) == NovaCraftBlocks.null_cluster_2
			 				&& world.getBlock(i, j + 4, k) == NovaCraftBlocks.sculk_nullstone
			 				&& world.getBlock(i, j + 5, k) == NovaCraftBlocks.sculk_tentacle_2
			 				
			 				&& world.getBlock(i - 1, j, k + 1) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 1, j + 1, k + 1) == NovaCraftBlocks.larimar_block
			                && world.getBlock(i - 1, j + 2, k + 1) == NovaCraftBlocks.larimar_block
			                && world.getBlock(i - 1, j + 3, k + 1) == NovaCraftBlocks.larimar_block
			                
			                && world.getBlock(i + 1, j, k - 1) == NovaCraftBlocks.nullstone_bricks 
			                && world.getBlock(i + 1, j + 1, k - 1) == NovaCraftBlocks.copartz_block
			                && world.getBlock(i + 1, j + 2, k - 1) == NovaCraftBlocks.copartz_block
			                && world.getBlock(i + 1, j + 3, k - 1) == NovaCraftBlocks.copartz_block
			                
			              	&& world.getBlock(i + 1, j, k + 1) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 1, j + 1, k + 1) == NovaCraftBlocks.tsavorokite_block
			                && world.getBlock(i + 1, j + 2, k + 1) == NovaCraftBlocks.tsavorokite_block
			                && world.getBlock(i + 1, j + 3, k + 1) == NovaCraftBlocks.tsavorokite_block
			                
			                && world.getBlock(i - 1, j, k - 1) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 1, j + 1, k - 1) == NovaCraftBlocks.yttrlinsite_block
			                && world.getBlock(i - 1, j + 2, k - 1) == NovaCraftBlocks.yttrlinsite_block
			                && world.getBlock(i - 1, j + 3, k - 1) == NovaCraftBlocks.yttrlinsite_block
			                
			                && world.getBlock(i + 2, j, k + 2) == NovaCraftBlocks.nullstone
			                && world.getBlock(i + 2, j + 1, k + 2) == NovaCraftBlocks.null_wart
			                
			                && world.getBlock(i - 2, j, k - 2) == NovaCraftBlocks.nullstone
			                && world.getBlock(i - 2, j + 1, k - 2) == NovaCraftBlocks.null_wart
			                
			                && world.getBlock(i - 2, j, k + 2) == NovaCraftBlocks.nullstone
			                && world.getBlock(i - 2, j + 1, k + 2) == NovaCraftBlocks.null_wart
			                
			                && world.getBlock(i + 2, j, k - 2) == NovaCraftBlocks.nullstone
			                && world.getBlock(i + 2, j + 1, k - 2) == NovaCraftBlocks.null_wart
			                
			                && world.getBlock(i + 3, j, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 1, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 2, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 3, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 4, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 5, k + 3) == NovaCraftBlocks.block_of_reinforced_vanite
			                
			                && world.getBlock(i - 3, j, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 1, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 2, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 3, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 4, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 5, k + 3) == NovaCraftBlocks.block_of_reinforced_vanite
			                
			                && world.getBlock(i + 3, j, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 1, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 2, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 3, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 4, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 5, k - 3) == NovaCraftBlocks.block_of_reinforced_vanite
			                
			                && world.getBlock(i - 3, j, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 1, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 2, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 3, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 4, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 5, k - 3) == NovaCraftBlocks.block_of_reinforced_vanite
			                
			                && (world.getBlock(i, j + 2, k) == NovaCraftBlocks.klangite_ore || world.getBlock(i, j + 2, k) == NovaCraftBlocks.end_klangite_ore || world.getBlock(i, j + 2, k) == NovaCraftBlocks.frontierslate_klangite_ore || world.getBlock(i, j + 2, k) == NovaCraftBlocks.deepslate_klangite_ore || world.getBlock(i, j + 2, k) == NovaCraftBlocks.stone_klangite_ore)
			                && (world.getBlock(i, j + 3, k) == NovaCraftBlocks.klangite_ore || world.getBlock(i, j + 3, k) == NovaCraftBlocks.end_klangite_ore || world.getBlock(i, j + 3, k) == NovaCraftBlocks.frontierslate_klangite_ore || world.getBlock(i, j + 3, k) == NovaCraftBlocks.deepslate_klangite_ore || world.getBlock(i, j + 3, k) == NovaCraftBlocks.stone_klangite_ore)
			                                                
			                )
			                {

			                     if (true) {
			                     world.spawnEntityInWorld(new EntityLightningBolt(world, i, j + 2, k));
			                     
			                     world.setBlock(i, j, k, NovaCraftBlocks.cobbled_nullstone);
			                     world.setBlock(i, j + 2, k, NovaCraftBlocks.block_of_raw_klangite);
			                     world.setBlock(i, j + 3, k, NovaCraftBlocks.block_of_raw_klangite);
			                     
			                     int rand = (int)(1 + Math.random() * 4);
			            		 switch (rand)
			            	     {
			            	     case 1:
			            	     break;
			            	     
			            	     case 2:
			            	     world.setBlock(i, j + 1, k, Blocks.air); 
			            	     break;
			            	     
			            	     case 3:
			            	     world.setBlock(i, j + 1, k, Blocks.air);
			            	     break;
			            	     
			            	     case 4:
			            	     world.setBlock(i, j + 1, k, NovaCraftBlocks.null_cluster_1);
				            	 break;
			                     }
			                     
			                     world.setBlock(i, j + 4, k,  NovaCraftBlocks.nullstone);
			     		 		 world.setBlock(i, j + 5, k, Blocks.air);
			     		 		 
			     		 		 
			     		 		world.setBlock(i - 1, j + 1, k + 1, NovaCraftBlocks.cracked_larimar_block);
			     		 		world.setBlock(i - 1, j + 2, k + 1, NovaCraftBlocks.cracked_larimar_block);
			     		 		world.setBlock(i - 1, j + 3, k + 1, NovaCraftBlocks.cracked_larimar_block);
			     		 		
			     		 		world.setBlock(i + 1, j + 1, k - 1, NovaCraftBlocks.cracked_copartz_block);
			     		 		world.setBlock(i + 1, j + 2, k - 1, NovaCraftBlocks.cracked_copartz_block);
			     		 		world.setBlock(i + 1, j + 3, k - 1, NovaCraftBlocks.cracked_copartz_block);
			     		 		
			     		 		world.setBlock(i + 1, j + 1, k + 1, NovaCraftBlocks.cracked_tsavorokite_block);
			     		 		world.setBlock(i + 1, j + 2, k + 1, NovaCraftBlocks.cracked_tsavorokite_block);
			     		 		world.setBlock(i + 1, j + 3, k + 1, NovaCraftBlocks.cracked_tsavorokite_block);
			     		 		
			     		 		world.setBlock(i - 1, j + 1, k - 1, NovaCraftBlocks.cracked_yttrlinsite_block);
			     		 		world.setBlock(i - 1, j + 2, k - 1, NovaCraftBlocks.cracked_yttrlinsite_block);
			     		 		world.setBlock(i - 1, j + 3, k - 1, NovaCraftBlocks.cracked_yttrlinsite_block);
			     		 		
			     		 		world.setBlock(i + 2, j + 1, k + 2, Blocks.air);
			     		 		world.setBlock(i - 2, j + 1, k - 2, Blocks.air);
			     		 		world.setBlock(i - 2, j + 1, k + 2, Blocks.air);
			     		 		world.setBlock(i + 2, j + 1, k - 2, Blocks.air);
			     		 		
			     		 		world.setBlock(i + 3, j + 5, k + 3, Blocks.air);
			     		 		world.setBlock(i - 3, j + 5, k - 3, Blocks.air);
			     		 		
			     		 		
			     		 		int rand2 = (int)(1 + Math.random() * 4);
			            		 switch (rand2)
			            	     {
			            	     case 1:
			            	     world.setBlock(i - 3, j + 5, k + 3, Blocks.air);
				            	 break;
				            	 
			            	     case 2:
			            	     world.setBlock(i + 3, j + 5, k - 3, Blocks.air);
					             break;
					             
			            	     case 3:
			            	     world.setBlock(i - 3, j + 5, k + 3, Blocks.air);
				            	 world.setBlock(i + 3, j + 5, k - 3, Blocks.air);
						         break;
						         
			            	     case 4:
					             break;
			            	     }

			                     	}
			                     }
		 			
		 			//Vanite Ore
		 			if (world.getBlock(i, j + 1, k) == NovaCraftBlocks.null_cluster_2
			 				&& world.getBlock(i, j + 4, k) == NovaCraftBlocks.sculk_nullstone
			 				&& world.getBlock(i, j + 5, k) == NovaCraftBlocks.sculk_tentacle_2
			 				
			 				&& world.getBlock(i - 1, j, k + 1) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 1, j + 1, k + 1) == NovaCraftBlocks.larimar_block
			                && world.getBlock(i - 1, j + 2, k + 1) == NovaCraftBlocks.larimar_block
			                && world.getBlock(i - 1, j + 3, k + 1) == NovaCraftBlocks.larimar_block
			                
			                && world.getBlock(i + 1, j, k - 1) == NovaCraftBlocks.nullstone_bricks 
			                && world.getBlock(i + 1, j + 1, k - 1) == NovaCraftBlocks.copartz_block
			                && world.getBlock(i + 1, j + 2, k - 1) == NovaCraftBlocks.copartz_block
			                && world.getBlock(i + 1, j + 3, k - 1) == NovaCraftBlocks.copartz_block
			                
			              	&& world.getBlock(i + 1, j, k + 1) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 1, j + 1, k + 1) == NovaCraftBlocks.tsavorokite_block
			                && world.getBlock(i + 1, j + 2, k + 1) == NovaCraftBlocks.tsavorokite_block
			                && world.getBlock(i + 1, j + 3, k + 1) == NovaCraftBlocks.tsavorokite_block
			                
			                && world.getBlock(i - 1, j, k - 1) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 1, j + 1, k - 1) == NovaCraftBlocks.yttrlinsite_block
			                && world.getBlock(i - 1, j + 2, k - 1) == NovaCraftBlocks.yttrlinsite_block
			                && world.getBlock(i - 1, j + 3, k - 1) == NovaCraftBlocks.yttrlinsite_block
			                
			                && world.getBlock(i + 2, j, k + 2) == NovaCraftBlocks.nullstone
			                && world.getBlock(i + 2, j + 1, k + 2) == NovaCraftBlocks.null_wart
			                
			                && world.getBlock(i - 2, j, k - 2) == NovaCraftBlocks.nullstone
			                && world.getBlock(i - 2, j + 1, k - 2) == NovaCraftBlocks.null_wart
			                
			                && world.getBlock(i - 2, j, k + 2) == NovaCraftBlocks.nullstone
			                && world.getBlock(i - 2, j + 1, k + 2) == NovaCraftBlocks.null_wart
			                
			                && world.getBlock(i + 2, j, k - 2) == NovaCraftBlocks.nullstone
			                && world.getBlock(i + 2, j + 1, k - 2) == NovaCraftBlocks.null_wart
			                
			                && world.getBlock(i + 3, j, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 1, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 2, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 3, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 4, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 5, k + 3) == NovaCraftBlocks.block_of_reinforced_vanite
			                
			                && world.getBlock(i - 3, j, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 1, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 2, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 3, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 4, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 5, k + 3) == NovaCraftBlocks.block_of_reinforced_vanite
			                
			                && world.getBlock(i + 3, j, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 1, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 2, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 3, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 4, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 5, k - 3) == NovaCraftBlocks.block_of_reinforced_vanite
			                
			                && world.getBlock(i - 3, j, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 1, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 2, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 3, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 4, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 5, k - 3) == NovaCraftBlocks.block_of_reinforced_vanite
			                
			                && (world.getBlock(i, j + 2, k) == NovaCraftBlocks.grimstone_vanite_ore || world.getBlock(i, j + 2, k) == NovaCraftBlocks.nullstone_vanite_ore || world.getBlock(i, j + 2, k) == NovaCraftBlocks.deepslate_vanite_ore || world.getBlock(i, j + 2, k) == NovaCraftBlocks.stone_vanite_ore)
			                && (world.getBlock(i, j + 3, k) == NovaCraftBlocks.grimstone_vanite_ore || world.getBlock(i, j + 3, k) == NovaCraftBlocks.nullstone_vanite_ore|| world.getBlock(i, j + 3, k) == NovaCraftBlocks.deepslate_vanite_ore || world.getBlock(i, j + 3, k) == NovaCraftBlocks.stone_vanite_ore)
			                                                
			                )
			                {

			                     if (true) {
			                     world.spawnEntityInWorld(new EntityLightningBolt(world, i, j + 2, k));
			                     
			                     world.setBlock(i, j, k, NovaCraftBlocks.cobbled_nullstone);
			                     world.setBlock(i, j + 2, k, NovaCraftBlocks.block_of_vanite);
			                     world.setBlock(i, j + 3, k, NovaCraftBlocks.block_of_vanite);
			                     
			                     int rand = (int)(1 + Math.random() * 4);
			            		 switch (rand)
			            	     {
			            	     case 1:
			            	     break;
			            	     
			            	     case 2:
			            	     world.setBlock(i, j + 1, k, Blocks.air); 
			            	     break;
			            	     
			            	     case 3:
			            	     world.setBlock(i, j + 1, k, Blocks.air);
			            	     break;
			            	     
			            	     case 4:
			            	     world.setBlock(i, j + 1, k, NovaCraftBlocks.null_cluster_1);
				            	 break;
			                     }
			                     
			                     world.setBlock(i, j + 4, k,  NovaCraftBlocks.nullstone);
			     		 		 world.setBlock(i, j + 5, k, Blocks.air);
			     		 		 
			     		 		 
			     		 		world.setBlock(i - 1, j + 1, k + 1, NovaCraftBlocks.cracked_larimar_block);
			     		 		world.setBlock(i - 1, j + 2, k + 1, NovaCraftBlocks.cracked_larimar_block);
			     		 		world.setBlock(i - 1, j + 3, k + 1, NovaCraftBlocks.cracked_larimar_block);
			     		 		
			     		 		world.setBlock(i + 1, j + 1, k - 1, NovaCraftBlocks.cracked_copartz_block);
			     		 		world.setBlock(i + 1, j + 2, k - 1, NovaCraftBlocks.cracked_copartz_block);
			     		 		world.setBlock(i + 1, j + 3, k - 1, NovaCraftBlocks.cracked_copartz_block);
			     		 		
			     		 		world.setBlock(i + 1, j + 1, k + 1, NovaCraftBlocks.cracked_tsavorokite_block);
			     		 		world.setBlock(i + 1, j + 2, k + 1, NovaCraftBlocks.cracked_tsavorokite_block);
			     		 		world.setBlock(i + 1, j + 3, k + 1, NovaCraftBlocks.cracked_tsavorokite_block);
			     		 		
			     		 		world.setBlock(i - 1, j + 1, k - 1, NovaCraftBlocks.cracked_yttrlinsite_block);
			     		 		world.setBlock(i - 1, j + 2, k - 1, NovaCraftBlocks.cracked_yttrlinsite_block);
			     		 		world.setBlock(i - 1, j + 3, k - 1, NovaCraftBlocks.cracked_yttrlinsite_block);
			     		 		
			     		 		world.setBlock(i + 2, j + 1, k + 2, Blocks.air);
			     		 		world.setBlock(i - 2, j + 1, k - 2, Blocks.air);
			     		 		world.setBlock(i - 2, j + 1, k + 2, Blocks.air);
			     		 		world.setBlock(i + 2, j + 1, k - 2, Blocks.air);
			     		 		
			     		 		world.setBlock(i + 3, j + 5, k + 3, Blocks.air);
			     		 		world.setBlock(i - 3, j + 5, k - 3, Blocks.air);
			     		 		
			     		 		
			     		 		int rand2 = (int)(1 + Math.random() * 4);
			            		 switch (rand2)
			            	     {
			            	     case 1:
			            	     world.setBlock(i - 3, j + 5, k + 3, Blocks.air);
				            	 break;
				            	 
			            	     case 2:
			            	     world.setBlock(i + 3, j + 5, k - 3, Blocks.air);
					             break;
					             
			            	     case 3:
			            	     world.setBlock(i - 3, j + 5, k + 3, Blocks.air);
				            	 world.setBlock(i + 3, j + 5, k - 3, Blocks.air);
						         break;
						         
			            	     case 4:
					             break;
			            	     }

			                     	}
			                     }
		 			//Tophinite Ore
		 			if (world.getBlock(i, j + 1, k) == NovaCraftBlocks.null_cluster_2
			 				&& world.getBlock(i, j + 4, k) == NovaCraftBlocks.sculk_nullstone
			 				&& world.getBlock(i, j + 5, k) == NovaCraftBlocks.sculk_tentacle_2
			 				
			 				&& world.getBlock(i - 1, j, k + 1) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 1, j + 1, k + 1) == NovaCraftBlocks.larimar_block
			                && world.getBlock(i - 1, j + 2, k + 1) == NovaCraftBlocks.larimar_block
			                && world.getBlock(i - 1, j + 3, k + 1) == NovaCraftBlocks.larimar_block
			                
			                && world.getBlock(i + 1, j, k - 1) == NovaCraftBlocks.nullstone_bricks 
			                && world.getBlock(i + 1, j + 1, k - 1) == NovaCraftBlocks.copartz_block
			                && world.getBlock(i + 1, j + 2, k - 1) == NovaCraftBlocks.copartz_block
			                && world.getBlock(i + 1, j + 3, k - 1) == NovaCraftBlocks.copartz_block
			                
			              	&& world.getBlock(i + 1, j, k + 1) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 1, j + 1, k + 1) == NovaCraftBlocks.tsavorokite_block
			                && world.getBlock(i + 1, j + 2, k + 1) == NovaCraftBlocks.tsavorokite_block
			                && world.getBlock(i + 1, j + 3, k + 1) == NovaCraftBlocks.tsavorokite_block
			                
			                && world.getBlock(i - 1, j, k - 1) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 1, j + 1, k - 1) == NovaCraftBlocks.yttrlinsite_block
			                && world.getBlock(i - 1, j + 2, k - 1) == NovaCraftBlocks.yttrlinsite_block
			                && world.getBlock(i - 1, j + 3, k - 1) == NovaCraftBlocks.yttrlinsite_block
			                
			                && world.getBlock(i + 2, j, k + 2) == NovaCraftBlocks.nullstone
			                && world.getBlock(i + 2, j + 1, k + 2) == NovaCraftBlocks.null_wart
			                
			                && world.getBlock(i - 2, j, k - 2) == NovaCraftBlocks.nullstone
			                && world.getBlock(i - 2, j + 1, k - 2) == NovaCraftBlocks.null_wart
			                
			                && world.getBlock(i - 2, j, k + 2) == NovaCraftBlocks.nullstone
			                && world.getBlock(i - 2, j + 1, k + 2) == NovaCraftBlocks.null_wart
			                
			                && world.getBlock(i + 2, j, k - 2) == NovaCraftBlocks.nullstone
			                && world.getBlock(i + 2, j + 1, k - 2) == NovaCraftBlocks.null_wart
			                
			                && world.getBlock(i + 3, j, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 1, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 2, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 3, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 4, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 5, k + 3) == NovaCraftBlocks.block_of_reinforced_vanite
			                
			                && world.getBlock(i - 3, j, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 1, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 2, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 3, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 4, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 5, k + 3) == NovaCraftBlocks.block_of_reinforced_vanite
			                
			                && world.getBlock(i + 3, j, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 1, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 2, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 3, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 4, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 5, k - 3) == NovaCraftBlocks.block_of_reinforced_vanite
			                
			                && world.getBlock(i - 3, j, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 1, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 2, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 3, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 4, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 5, k - 3) == NovaCraftBlocks.block_of_reinforced_vanite
			                
			                && (world.getBlock(i, j + 2, k) == NovaCraftBlocks.stone_tophinite_ore || world.getBlock(i, j + 2, k) == NovaCraftBlocks.deepslate_tophinite_ore || world.getBlock(i, j + 2, k) == NovaCraftBlocks.nullstone_tophinite_ore || world.getBlock(i, j + 2, k) == NovaCraftBlocks.nether_tophinite_ore)
			                && (world.getBlock(i, j + 3, k) == NovaCraftBlocks.stone_tophinite_ore || world.getBlock(i, j + 3, k) == NovaCraftBlocks.deepslate_tophinite_ore || world.getBlock(i, j + 3, k) == NovaCraftBlocks.nullstone_tophinite_ore || world.getBlock(i, j + 3, k) == NovaCraftBlocks.nether_tophinite_ore)
			                                                
			                )
			                {

			                     if (true) {
			                     world.spawnEntityInWorld(new EntityLightningBolt(world, i, j + 2, k));
			                     
			                     world.setBlock(i, j, k, NovaCraftBlocks.cobbled_nullstone);
			                     world.setBlock(i, j + 2, k, NovaCraftBlocks.block_of_tophinite);
			                     world.setBlock(i, j + 3, k, NovaCraftBlocks.block_of_tophinite);
			                     
			                     int rand = (int)(1 + Math.random() * 4);
			            		 switch (rand)
			            	     {
			            	     case 1:
			            	     break;
			            	     
			            	     case 2:
			            	     world.setBlock(i, j + 1, k, Blocks.air); 
			            	     break;
			            	     
			            	     case 3:
			            	     world.setBlock(i, j + 1, k, Blocks.air);
			            	     break;
			            	     
			            	     case 4:
			            	     world.setBlock(i, j + 1, k, NovaCraftBlocks.null_cluster_1);
				            	 break;
			                     }
			                     
			                     world.setBlock(i, j + 4, k,  NovaCraftBlocks.nullstone);
			     		 		 world.setBlock(i, j + 5, k, Blocks.air);
			     		 		 
			     		 		 
			     		 		world.setBlock(i - 1, j + 1, k + 1, NovaCraftBlocks.cracked_larimar_block);
			     		 		world.setBlock(i - 1, j + 2, k + 1, NovaCraftBlocks.cracked_larimar_block);
			     		 		world.setBlock(i - 1, j + 3, k + 1, NovaCraftBlocks.cracked_larimar_block);
			     		 		
			     		 		world.setBlock(i + 1, j + 1, k - 1, NovaCraftBlocks.cracked_copartz_block);
			     		 		world.setBlock(i + 1, j + 2, k - 1, NovaCraftBlocks.cracked_copartz_block);
			     		 		world.setBlock(i + 1, j + 3, k - 1, NovaCraftBlocks.cracked_copartz_block);
			     		 		
			     		 		world.setBlock(i + 1, j + 1, k + 1, NovaCraftBlocks.cracked_tsavorokite_block);
			     		 		world.setBlock(i + 1, j + 2, k + 1, NovaCraftBlocks.cracked_tsavorokite_block);
			     		 		world.setBlock(i + 1, j + 3, k + 1, NovaCraftBlocks.cracked_tsavorokite_block);
			     		 		
			     		 		world.setBlock(i - 1, j + 1, k - 1, NovaCraftBlocks.cracked_yttrlinsite_block);
			     		 		world.setBlock(i - 1, j + 2, k - 1, NovaCraftBlocks.cracked_yttrlinsite_block);
			     		 		world.setBlock(i - 1, j + 3, k - 1, NovaCraftBlocks.cracked_yttrlinsite_block);
			     		 		
			     		 		world.setBlock(i + 2, j + 1, k + 2, Blocks.air);
			     		 		world.setBlock(i - 2, j + 1, k - 2, Blocks.air);
			     		 		world.setBlock(i - 2, j + 1, k + 2, Blocks.air);
			     		 		world.setBlock(i + 2, j + 1, k - 2, Blocks.air);
			     		 		
			     		 		world.setBlock(i + 3, j + 5, k + 3, Blocks.air);
			     		 		world.setBlock(i - 3, j + 5, k - 3, Blocks.air);
			     		 		
			     		 		
			     		 		int rand2 = (int)(1 + Math.random() * 4);
			            		 switch (rand2)
			            	     {
			            	     case 1:
			            	     world.setBlock(i - 3, j + 5, k + 3, Blocks.air);
				            	 break;
				            	 
			            	     case 2:
			            	     world.setBlock(i + 3, j + 5, k - 3, Blocks.air);
					             break;
					             
			            	     case 3:
			            	     world.setBlock(i - 3, j + 5, k + 3, Blocks.air);
				            	 world.setBlock(i + 3, j + 5, k - 3, Blocks.air);
						         break;
						         
			            	     case 4:
					             break;
			            	     }

			                     	}
			                     }
		 			//--------------------------------------------------------------------- HEE Ores
		 			//Endium Ore
		 			if (Loader.isModLoaded("HardcoreEnderExpansion")) {
		 				if (world.getBlock(i, j + 1, k) == NovaCraftBlocks.null_cluster_2
			 				&& world.getBlock(i, j + 4, k) == NovaCraftBlocks.sculk_nullstone
			 				&& world.getBlock(i, j + 5, k) == NovaCraftBlocks.sculk_tentacle_2
			 				
			 				&& world.getBlock(i - 1, j, k + 1) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 1, j + 1, k + 1) == NovaCraftBlocks.larimar_block
			                && world.getBlock(i - 1, j + 2, k + 1) == NovaCraftBlocks.larimar_block
			                && world.getBlock(i - 1, j + 3, k + 1) == NovaCraftBlocks.larimar_block
			                
			                && world.getBlock(i + 1, j, k - 1) == NovaCraftBlocks.nullstone_bricks 
			                && world.getBlock(i + 1, j + 1, k - 1) == NovaCraftBlocks.copartz_block
			                && world.getBlock(i + 1, j + 2, k - 1) == NovaCraftBlocks.copartz_block
			                && world.getBlock(i + 1, j + 3, k - 1) == NovaCraftBlocks.copartz_block
			                
			              	&& world.getBlock(i + 1, j, k + 1) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 1, j + 1, k + 1) == NovaCraftBlocks.tsavorokite_block
			                && world.getBlock(i + 1, j + 2, k + 1) == NovaCraftBlocks.tsavorokite_block
			                && world.getBlock(i + 1, j + 3, k + 1) == NovaCraftBlocks.tsavorokite_block
			                
			                && world.getBlock(i - 1, j, k - 1) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 1, j + 1, k - 1) == NovaCraftBlocks.yttrlinsite_block
			                && world.getBlock(i - 1, j + 2, k - 1) == NovaCraftBlocks.yttrlinsite_block
			                && world.getBlock(i - 1, j + 3, k - 1) == NovaCraftBlocks.yttrlinsite_block
			                
			                && world.getBlock(i + 2, j, k + 2) == NovaCraftBlocks.nullstone
			                && world.getBlock(i + 2, j + 1, k + 2) == NovaCraftBlocks.null_wart
			                
			                && world.getBlock(i - 2, j, k - 2) == NovaCraftBlocks.nullstone
			                && world.getBlock(i - 2, j + 1, k - 2) == NovaCraftBlocks.null_wart
			                
			                && world.getBlock(i - 2, j, k + 2) == NovaCraftBlocks.nullstone
			                && world.getBlock(i - 2, j + 1, k + 2) == NovaCraftBlocks.null_wart
			                
			                && world.getBlock(i + 2, j, k - 2) == NovaCraftBlocks.nullstone
			                && world.getBlock(i + 2, j + 1, k - 2) == NovaCraftBlocks.null_wart
			                
			                && world.getBlock(i + 3, j, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 1, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 2, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 3, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 4, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 5, k + 3) == NovaCraftBlocks.block_of_reinforced_vanite
			                
			                && world.getBlock(i - 3, j, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 1, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 2, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 3, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 4, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 5, k + 3) == NovaCraftBlocks.block_of_reinforced_vanite
			                
			                && world.getBlock(i + 3, j, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 1, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 2, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 3, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 4, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 5, k - 3) == NovaCraftBlocks.block_of_reinforced_vanite
			                
			                && world.getBlock(i - 3, j, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 1, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 2, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 3, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 4, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 5, k - 3) == NovaCraftBlocks.block_of_reinforced_vanite
			                
			                && (world.getBlock(i, j + 2, k) == OtherModBlocks.endium_ore)
			                && (world.getBlock(i, j + 3, k) == OtherModBlocks.endium_ore)
			                                                
			                )
			                {

			                     if (true) {
			                     world.spawnEntityInWorld(new EntityLightningBolt(world, i, j + 2, k));
			                     
			                     world.setBlock(i, j, k, NovaCraftBlocks.cobbled_nullstone);
			                     world.setBlock(i, j + 2, k, OtherModBlocks.endium_block);
			                     world.setBlock(i, j + 3, k, OtherModBlocks.endium_block);
			                     
			                     int rand = (int)(1 + Math.random() * 4);
			            		 switch (rand)
			            	     {
			            	     case 1:
			            	     break;
			            	     
			            	     case 2:
			            	     world.setBlock(i, j + 1, k, Blocks.air); 
			            	     break;
			            	     
			            	     case 3:
			            	     world.setBlock(i, j + 1, k, Blocks.air);
			            	     break;
			            	     
			            	     case 4:
			            	     world.setBlock(i, j + 1, k, NovaCraftBlocks.null_cluster_1);
				            	 break;
			                     }
			                     
			                     world.setBlock(i, j + 4, k,  NovaCraftBlocks.nullstone);
			     		 		 world.setBlock(i, j + 5, k, Blocks.air);
			     		 		 
			     		 		 
			     		 		world.setBlock(i - 1, j + 1, k + 1, NovaCraftBlocks.cracked_larimar_block);
			     		 		world.setBlock(i - 1, j + 2, k + 1, NovaCraftBlocks.cracked_larimar_block);
			     		 		world.setBlock(i - 1, j + 3, k + 1, NovaCraftBlocks.cracked_larimar_block);
			     		 		
			     		 		world.setBlock(i + 1, j + 1, k - 1, NovaCraftBlocks.cracked_copartz_block);
			     		 		world.setBlock(i + 1, j + 2, k - 1, NovaCraftBlocks.cracked_copartz_block);
			     		 		world.setBlock(i + 1, j + 3, k - 1, NovaCraftBlocks.cracked_copartz_block);
			     		 		
			     		 		world.setBlock(i + 1, j + 1, k + 1, NovaCraftBlocks.cracked_tsavorokite_block);
			     		 		world.setBlock(i + 1, j + 2, k + 1, NovaCraftBlocks.cracked_tsavorokite_block);
			     		 		world.setBlock(i + 1, j + 3, k + 1, NovaCraftBlocks.cracked_tsavorokite_block);
			     		 		
			     		 		world.setBlock(i - 1, j + 1, k - 1, NovaCraftBlocks.cracked_yttrlinsite_block);
			     		 		world.setBlock(i - 1, j + 2, k - 1, NovaCraftBlocks.cracked_yttrlinsite_block);
			     		 		world.setBlock(i - 1, j + 3, k - 1, NovaCraftBlocks.cracked_yttrlinsite_block);
			     		 		
			     		 		world.setBlock(i + 2, j + 1, k + 2, Blocks.air);
			     		 		world.setBlock(i - 2, j + 1, k - 2, Blocks.air);
			     		 		world.setBlock(i - 2, j + 1, k + 2, Blocks.air);
			     		 		world.setBlock(i + 2, j + 1, k - 2, Blocks.air);
			     		 		
			     		 		world.setBlock(i + 3, j + 5, k + 3, Blocks.air);
			     		 		world.setBlock(i - 3, j + 5, k - 3, Blocks.air);
			     		 		
			     		 		
			     		 		int rand2 = (int)(1 + Math.random() * 4);
			            		 switch (rand2)
			            	     {
			            	     case 1:
			            	     world.setBlock(i - 3, j + 5, k + 3, Blocks.air);
				            	 break;
				            	 
			            	     case 2:
			            	     world.setBlock(i + 3, j + 5, k - 3, Blocks.air);
					             break;
					             
			            	     case 3:
			            	     world.setBlock(i - 3, j + 5, k + 3, Blocks.air);
				            	 world.setBlock(i + 3, j + 5, k - 3, Blocks.air);
						         break;
						         
			            	     case 4:
					             break;
			            	     }

			                     	}
			                     }
		 			}
		 			
		 			//--------------------------------------------------------------------- Aether Legacy Ores
		 			//Zanite Ore
		 			if (Loader.isModLoaded("aether_legacy")) {
		 				if (world.getBlock(i, j + 1, k) == NovaCraftBlocks.null_cluster_2
			 				&& world.getBlock(i, j + 4, k) == NovaCraftBlocks.sculk_nullstone
			 				&& world.getBlock(i, j + 5, k) == NovaCraftBlocks.sculk_tentacle_2
			 				
			 				&& world.getBlock(i - 1, j, k + 1) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 1, j + 1, k + 1) == NovaCraftBlocks.larimar_block
			                && world.getBlock(i - 1, j + 2, k + 1) == NovaCraftBlocks.larimar_block
			                && world.getBlock(i - 1, j + 3, k + 1) == NovaCraftBlocks.larimar_block
			                
			                && world.getBlock(i + 1, j, k - 1) == NovaCraftBlocks.nullstone_bricks 
			                && world.getBlock(i + 1, j + 1, k - 1) == NovaCraftBlocks.copartz_block
			                && world.getBlock(i + 1, j + 2, k - 1) == NovaCraftBlocks.copartz_block
			                && world.getBlock(i + 1, j + 3, k - 1) == NovaCraftBlocks.copartz_block
			                
			              	&& world.getBlock(i + 1, j, k + 1) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 1, j + 1, k + 1) == NovaCraftBlocks.tsavorokite_block
			                && world.getBlock(i + 1, j + 2, k + 1) == NovaCraftBlocks.tsavorokite_block
			                && world.getBlock(i + 1, j + 3, k + 1) == NovaCraftBlocks.tsavorokite_block
			                
			                && world.getBlock(i - 1, j, k - 1) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 1, j + 1, k - 1) == NovaCraftBlocks.yttrlinsite_block
			                && world.getBlock(i - 1, j + 2, k - 1) == NovaCraftBlocks.yttrlinsite_block
			                && world.getBlock(i - 1, j + 3, k - 1) == NovaCraftBlocks.yttrlinsite_block
			                
			                && world.getBlock(i + 2, j, k + 2) == NovaCraftBlocks.nullstone
			                && world.getBlock(i + 2, j + 1, k + 2) == NovaCraftBlocks.null_wart
			                
			                && world.getBlock(i - 2, j, k - 2) == NovaCraftBlocks.nullstone
			                && world.getBlock(i - 2, j + 1, k - 2) == NovaCraftBlocks.null_wart
			                
			                && world.getBlock(i - 2, j, k + 2) == NovaCraftBlocks.nullstone
			                && world.getBlock(i - 2, j + 1, k + 2) == NovaCraftBlocks.null_wart
			                
			                && world.getBlock(i + 2, j, k - 2) == NovaCraftBlocks.nullstone
			                && world.getBlock(i + 2, j + 1, k - 2) == NovaCraftBlocks.null_wart
			                
			                && world.getBlock(i + 3, j, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 1, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 2, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 3, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 4, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 5, k + 3) == NovaCraftBlocks.block_of_reinforced_vanite
			                
			                && world.getBlock(i - 3, j, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 1, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 2, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 3, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 4, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 5, k + 3) == NovaCraftBlocks.block_of_reinforced_vanite
			                
			                && world.getBlock(i + 3, j, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 1, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 2, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 3, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 4, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 5, k - 3) == NovaCraftBlocks.block_of_reinforced_vanite
			                
			                && world.getBlock(i - 3, j, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 1, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 2, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 3, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 4, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 5, k - 3) == NovaCraftBlocks.block_of_reinforced_vanite
			                
			                && (world.getBlock(i, j + 2, k) == OtherModBlocks.zanite_ore)
			                && (world.getBlock(i, j + 3, k) == OtherModBlocks.zanite_ore)
			                                                
			                )
			                {

			                     if (true) {
			                     world.spawnEntityInWorld(new EntityLightningBolt(world, i, j + 2, k));
			                     
			                     world.setBlock(i, j, k, NovaCraftBlocks.cobbled_nullstone);
			                     world.setBlock(i, j + 2, k, OtherModBlocks.zanite_block);
			                     world.setBlock(i, j + 3, k, OtherModBlocks.zanite_block);
			                     
			                     int rand = (int)(1 + Math.random() * 4);
			            		 switch (rand)
			            	     {
			            	     case 1:
			            	     break;
			            	     
			            	     case 2:
			            	     world.setBlock(i, j + 1, k, Blocks.air); 
			            	     break;
			            	     
			            	     case 3:
			            	     world.setBlock(i, j + 1, k, Blocks.air);
			            	     break;
			            	     
			            	     case 4:
			            	     world.setBlock(i, j + 1, k, NovaCraftBlocks.null_cluster_1);
				            	 break;
			                     }
			                     
			                     world.setBlock(i, j + 4, k,  NovaCraftBlocks.nullstone);
			     		 		 world.setBlock(i, j + 5, k, Blocks.air);
			     		 		 
			     		 		 
			     		 		world.setBlock(i - 1, j + 1, k + 1, NovaCraftBlocks.cracked_larimar_block);
			     		 		world.setBlock(i - 1, j + 2, k + 1, NovaCraftBlocks.cracked_larimar_block);
			     		 		world.setBlock(i - 1, j + 3, k + 1, NovaCraftBlocks.cracked_larimar_block);
			     		 		
			     		 		world.setBlock(i + 1, j + 1, k - 1, NovaCraftBlocks.cracked_copartz_block);
			     		 		world.setBlock(i + 1, j + 2, k - 1, NovaCraftBlocks.cracked_copartz_block);
			     		 		world.setBlock(i + 1, j + 3, k - 1, NovaCraftBlocks.cracked_copartz_block);
			     		 		
			     		 		world.setBlock(i + 1, j + 1, k + 1, NovaCraftBlocks.cracked_tsavorokite_block);
			     		 		world.setBlock(i + 1, j + 2, k + 1, NovaCraftBlocks.cracked_tsavorokite_block);
			     		 		world.setBlock(i + 1, j + 3, k + 1, NovaCraftBlocks.cracked_tsavorokite_block);
			     		 		
			     		 		world.setBlock(i - 1, j + 1, k - 1, NovaCraftBlocks.cracked_yttrlinsite_block);
			     		 		world.setBlock(i - 1, j + 2, k - 1, NovaCraftBlocks.cracked_yttrlinsite_block);
			     		 		world.setBlock(i - 1, j + 3, k - 1, NovaCraftBlocks.cracked_yttrlinsite_block);
			     		 		
			     		 		world.setBlock(i + 2, j + 1, k + 2, Blocks.air);
			     		 		world.setBlock(i - 2, j + 1, k - 2, Blocks.air);
			     		 		world.setBlock(i - 2, j + 1, k + 2, Blocks.air);
			     		 		world.setBlock(i + 2, j + 1, k - 2, Blocks.air);
			     		 		
			     		 		world.setBlock(i + 3, j + 5, k + 3, Blocks.air);
			     		 		world.setBlock(i - 3, j + 5, k - 3, Blocks.air);
			     		 		
			     		 		
			     		 		int rand2 = (int)(1 + Math.random() * 4);
			            		 switch (rand2)
			            	     {
			            	     case 1:
			            	     world.setBlock(i - 3, j + 5, k + 3, Blocks.air);
				            	 break;
				            	 
			            	     case 2:
			            	     world.setBlock(i + 3, j + 5, k - 3, Blocks.air);
					             break;
					             
			            	     case 3:
			            	     world.setBlock(i - 3, j + 5, k + 3, Blocks.air);
				            	 world.setBlock(i + 3, j + 5, k - 3, Blocks.air);
						         break;
						         
			            	     case 4:
					             break;
			            	     }

			                     	}
			                     }
		 				//Arkenium Ore
		 				if (world.getBlock(i, j + 1, k) == NovaCraftBlocks.null_cluster_2
				 				&& world.getBlock(i, j + 4, k) == NovaCraftBlocks.sculk_nullstone
				 				&& world.getBlock(i, j + 5, k) == NovaCraftBlocks.sculk_tentacle_2
				 				
				 				&& world.getBlock(i - 1, j, k + 1) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i - 1, j + 1, k + 1) == NovaCraftBlocks.larimar_block
				                && world.getBlock(i - 1, j + 2, k + 1) == NovaCraftBlocks.larimar_block
				                && world.getBlock(i - 1, j + 3, k + 1) == NovaCraftBlocks.larimar_block
				                
				                && world.getBlock(i + 1, j, k - 1) == NovaCraftBlocks.nullstone_bricks 
				                && world.getBlock(i + 1, j + 1, k - 1) == NovaCraftBlocks.copartz_block
				                && world.getBlock(i + 1, j + 2, k - 1) == NovaCraftBlocks.copartz_block
				                && world.getBlock(i + 1, j + 3, k - 1) == NovaCraftBlocks.copartz_block
				                
				              	&& world.getBlock(i + 1, j, k + 1) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i + 1, j + 1, k + 1) == NovaCraftBlocks.tsavorokite_block
				                && world.getBlock(i + 1, j + 2, k + 1) == NovaCraftBlocks.tsavorokite_block
				                && world.getBlock(i + 1, j + 3, k + 1) == NovaCraftBlocks.tsavorokite_block
				                
				                && world.getBlock(i - 1, j, k - 1) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i - 1, j + 1, k - 1) == NovaCraftBlocks.yttrlinsite_block
				                && world.getBlock(i - 1, j + 2, k - 1) == NovaCraftBlocks.yttrlinsite_block
				                && world.getBlock(i - 1, j + 3, k - 1) == NovaCraftBlocks.yttrlinsite_block
				                
				                && world.getBlock(i + 2, j, k + 2) == NovaCraftBlocks.nullstone
				                && world.getBlock(i + 2, j + 1, k + 2) == NovaCraftBlocks.null_wart
				                
				                && world.getBlock(i - 2, j, k - 2) == NovaCraftBlocks.nullstone
				                && world.getBlock(i - 2, j + 1, k - 2) == NovaCraftBlocks.null_wart
				                
				                && world.getBlock(i - 2, j, k + 2) == NovaCraftBlocks.nullstone
				                && world.getBlock(i - 2, j + 1, k + 2) == NovaCraftBlocks.null_wart
				                
				                && world.getBlock(i + 2, j, k - 2) == NovaCraftBlocks.nullstone
				                && world.getBlock(i + 2, j + 1, k - 2) == NovaCraftBlocks.null_wart
				                
				                && world.getBlock(i + 3, j, k + 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i + 3, j + 1, k + 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i + 3, j + 2, k + 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i + 3, j + 3, k + 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i + 3, j + 4, k + 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i + 3, j + 5, k + 3) == NovaCraftBlocks.block_of_reinforced_vanite
				                
				                && world.getBlock(i - 3, j, k + 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i - 3, j + 1, k + 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i - 3, j + 2, k + 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i - 3, j + 3, k + 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i - 3, j + 4, k + 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i - 3, j + 5, k + 3) == NovaCraftBlocks.block_of_reinforced_vanite
				                
				                && world.getBlock(i + 3, j, k - 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i + 3, j + 1, k - 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i + 3, j + 2, k - 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i + 3, j + 3, k - 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i + 3, j + 4, k - 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i + 3, j + 5, k - 3) == NovaCraftBlocks.block_of_reinforced_vanite
				                
				                && world.getBlock(i - 3, j, k - 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i - 3, j + 1, k - 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i - 3, j + 2, k - 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i - 3, j + 3, k - 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i - 3, j + 4, k - 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i - 3, j + 5, k - 3) == NovaCraftBlocks.block_of_reinforced_vanite
				                
				                && (world.getBlock(i, j + 2, k) == OtherModBlocks.arkenium_ore)
				                && (world.getBlock(i, j + 3, k) == OtherModBlocks.arkenium_ore)
				                                                
				                )
				                {

				                     if (true) {
				                     world.spawnEntityInWorld(new EntityLightningBolt(world, i, j + 2, k));
				                     
				                     world.setBlock(i, j, k, NovaCraftBlocks.cobbled_nullstone);
				                     world.setBlock(i, j + 2, k, OtherModBlocks.arkenium_block);
				                     world.setBlock(i, j + 3, k, OtherModBlocks.arkenium_block);
				                     
				                     int rand = (int)(1 + Math.random() * 4);
				            		 switch (rand)
				            	     {
				            	     case 1:
				            	     break;
				            	     
				            	     case 2:
				            	     world.setBlock(i, j + 1, k, Blocks.air); 
				            	     break;
				            	     
				            	     case 3:
				            	     world.setBlock(i, j + 1, k, Blocks.air);
				            	     break;
				            	     
				            	     case 4:
				            	     world.setBlock(i, j + 1, k, NovaCraftBlocks.null_cluster_1);
					            	 break;
				                     }
				                     
				                     world.setBlock(i, j + 4, k,  NovaCraftBlocks.nullstone);
				     		 		 world.setBlock(i, j + 5, k, Blocks.air);
				     		 		 
				     		 		 
				     		 		world.setBlock(i - 1, j + 1, k + 1, NovaCraftBlocks.cracked_larimar_block);
				     		 		world.setBlock(i - 1, j + 2, k + 1, NovaCraftBlocks.cracked_larimar_block);
				     		 		world.setBlock(i - 1, j + 3, k + 1, NovaCraftBlocks.cracked_larimar_block);
				     		 		
				     		 		world.setBlock(i + 1, j + 1, k - 1, NovaCraftBlocks.cracked_copartz_block);
				     		 		world.setBlock(i + 1, j + 2, k - 1, NovaCraftBlocks.cracked_copartz_block);
				     		 		world.setBlock(i + 1, j + 3, k - 1, NovaCraftBlocks.cracked_copartz_block);
				     		 		
				     		 		world.setBlock(i + 1, j + 1, k + 1, NovaCraftBlocks.cracked_tsavorokite_block);
				     		 		world.setBlock(i + 1, j + 2, k + 1, NovaCraftBlocks.cracked_tsavorokite_block);
				     		 		world.setBlock(i + 1, j + 3, k + 1, NovaCraftBlocks.cracked_tsavorokite_block);
				     		 		
				     		 		world.setBlock(i - 1, j + 1, k - 1, NovaCraftBlocks.cracked_yttrlinsite_block);
				     		 		world.setBlock(i - 1, j + 2, k - 1, NovaCraftBlocks.cracked_yttrlinsite_block);
				     		 		world.setBlock(i - 1, j + 3, k - 1, NovaCraftBlocks.cracked_yttrlinsite_block);
				     		 		
				     		 		world.setBlock(i + 2, j + 1, k + 2, Blocks.air);
				     		 		world.setBlock(i - 2, j + 1, k - 2, Blocks.air);
				     		 		world.setBlock(i - 2, j + 1, k + 2, Blocks.air);
				     		 		world.setBlock(i + 2, j + 1, k - 2, Blocks.air);
				     		 		
				     		 		world.setBlock(i + 3, j + 5, k + 3, Blocks.air);
				     		 		world.setBlock(i - 3, j + 5, k - 3, Blocks.air);
				     		 		
				     		 		
				     		 		int rand2 = (int)(1 + Math.random() * 4);
				            		 switch (rand2)
				            	     {
				            	     case 1:
				            	     world.setBlock(i - 3, j + 5, k + 3, Blocks.air);
					            	 break;
					            	 
				            	     case 2:
				            	     world.setBlock(i + 3, j + 5, k - 3, Blocks.air);
						             break;
						             
				            	     case 3:
				            	     world.setBlock(i - 3, j + 5, k + 3, Blocks.air);
					            	 world.setBlock(i + 3, j + 5, k - 3, Blocks.air);
							         break;
							         
				            	     case 4:
						             break;
				            	     }

				                     	}
				                     }
		 				
		 				//Continuum Ore
		 				if (world.getBlock(i, j + 1, k) == NovaCraftBlocks.null_cluster_2
				 				&& world.getBlock(i, j + 4, k) == NovaCraftBlocks.sculk_nullstone
				 				&& world.getBlock(i, j + 5, k) == NovaCraftBlocks.sculk_tentacle_2
				 				
				 				&& world.getBlock(i - 1, j, k + 1) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i - 1, j + 1, k + 1) == NovaCraftBlocks.larimar_block
				                && world.getBlock(i - 1, j + 2, k + 1) == NovaCraftBlocks.larimar_block
				                && world.getBlock(i - 1, j + 3, k + 1) == NovaCraftBlocks.larimar_block
				                
				                && world.getBlock(i + 1, j, k - 1) == NovaCraftBlocks.nullstone_bricks 
				                && world.getBlock(i + 1, j + 1, k - 1) == NovaCraftBlocks.copartz_block
				                && world.getBlock(i + 1, j + 2, k - 1) == NovaCraftBlocks.copartz_block
				                && world.getBlock(i + 1, j + 3, k - 1) == NovaCraftBlocks.copartz_block
				                
				              	&& world.getBlock(i + 1, j, k + 1) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i + 1, j + 1, k + 1) == NovaCraftBlocks.tsavorokite_block
				                && world.getBlock(i + 1, j + 2, k + 1) == NovaCraftBlocks.tsavorokite_block
				                && world.getBlock(i + 1, j + 3, k + 1) == NovaCraftBlocks.tsavorokite_block
				                
				                && world.getBlock(i - 1, j, k - 1) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i - 1, j + 1, k - 1) == NovaCraftBlocks.yttrlinsite_block
				                && world.getBlock(i - 1, j + 2, k - 1) == NovaCraftBlocks.yttrlinsite_block
				                && world.getBlock(i - 1, j + 3, k - 1) == NovaCraftBlocks.yttrlinsite_block
				                
				                && world.getBlock(i + 2, j, k + 2) == NovaCraftBlocks.nullstone
				                && world.getBlock(i + 2, j + 1, k + 2) == NovaCraftBlocks.null_wart
				                
				                && world.getBlock(i - 2, j, k - 2) == NovaCraftBlocks.nullstone
				                && world.getBlock(i - 2, j + 1, k - 2) == NovaCraftBlocks.null_wart
				                
				                && world.getBlock(i - 2, j, k + 2) == NovaCraftBlocks.nullstone
				                && world.getBlock(i - 2, j + 1, k + 2) == NovaCraftBlocks.null_wart
				                
				                && world.getBlock(i + 2, j, k - 2) == NovaCraftBlocks.nullstone
				                && world.getBlock(i + 2, j + 1, k - 2) == NovaCraftBlocks.null_wart
				                
				                && world.getBlock(i + 3, j, k + 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i + 3, j + 1, k + 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i + 3, j + 2, k + 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i + 3, j + 3, k + 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i + 3, j + 4, k + 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i + 3, j + 5, k + 3) == NovaCraftBlocks.block_of_reinforced_vanite
				                
				                && world.getBlock(i - 3, j, k + 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i - 3, j + 1, k + 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i - 3, j + 2, k + 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i - 3, j + 3, k + 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i - 3, j + 4, k + 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i - 3, j + 5, k + 3) == NovaCraftBlocks.block_of_reinforced_vanite
				                
				                && world.getBlock(i + 3, j, k - 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i + 3, j + 1, k - 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i + 3, j + 2, k - 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i + 3, j + 3, k - 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i + 3, j + 4, k - 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i + 3, j + 5, k - 3) == NovaCraftBlocks.block_of_reinforced_vanite
				                
				                && world.getBlock(i - 3, j, k - 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i - 3, j + 1, k - 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i - 3, j + 2, k - 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i - 3, j + 3, k - 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i - 3, j + 4, k - 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i - 3, j + 5, k - 3) == NovaCraftBlocks.block_of_reinforced_vanite
				                
				                && (world.getBlock(i, j + 2, k) == OtherModBlocks.continuum_ore)
				                && (world.getBlock(i, j + 3, k) == OtherModBlocks.continuum_ore)
				                                                
				                )
				                {

				                     if (true) {
				                     world.spawnEntityInWorld(new EntityLightningBolt(world, i, j + 2, k));
				                     
				                     world.setBlock(i, j, k, NovaCraftBlocks.cobbled_nullstone);
				                     world.setBlock(i, j + 2, k, OtherModBlocks.continuum_block);
				                     world.setBlock(i, j + 3, k, OtherModBlocks.continuum_block);
				                     
				                     int rand = (int)(1 + Math.random() * 4);
				            		 switch (rand)
				            	     {
				            	     case 1:
				            	     break;
				            	     
				            	     case 2:
				            	     world.setBlock(i, j + 1, k, Blocks.air); 
				            	     break;
				            	     
				            	     case 3:
				            	     world.setBlock(i, j + 1, k, Blocks.air);
				            	     break;
				            	     
				            	     case 4:
				            	     world.setBlock(i, j + 1, k, NovaCraftBlocks.null_cluster_1);
					            	 break;
				                     }
				                     
				                     world.setBlock(i, j + 4, k,  NovaCraftBlocks.nullstone);
				     		 		 world.setBlock(i, j + 5, k, Blocks.air);
				     		 		 
				     		 		 
				     		 		world.setBlock(i - 1, j + 1, k + 1, NovaCraftBlocks.cracked_larimar_block);
				     		 		world.setBlock(i - 1, j + 2, k + 1, NovaCraftBlocks.cracked_larimar_block);
				     		 		world.setBlock(i - 1, j + 3, k + 1, NovaCraftBlocks.cracked_larimar_block);
				     		 		
				     		 		world.setBlock(i + 1, j + 1, k - 1, NovaCraftBlocks.cracked_copartz_block);
				     		 		world.setBlock(i + 1, j + 2, k - 1, NovaCraftBlocks.cracked_copartz_block);
				     		 		world.setBlock(i + 1, j + 3, k - 1, NovaCraftBlocks.cracked_copartz_block);
				     		 		
				     		 		world.setBlock(i + 1, j + 1, k + 1, NovaCraftBlocks.cracked_tsavorokite_block);
				     		 		world.setBlock(i + 1, j + 2, k + 1, NovaCraftBlocks.cracked_tsavorokite_block);
				     		 		world.setBlock(i + 1, j + 3, k + 1, NovaCraftBlocks.cracked_tsavorokite_block);
				     		 		
				     		 		world.setBlock(i - 1, j + 1, k - 1, NovaCraftBlocks.cracked_yttrlinsite_block);
				     		 		world.setBlock(i - 1, j + 2, k - 1, NovaCraftBlocks.cracked_yttrlinsite_block);
				     		 		world.setBlock(i - 1, j + 3, k - 1, NovaCraftBlocks.cracked_yttrlinsite_block);
				     		 		
				     		 		world.setBlock(i + 2, j + 1, k + 2, Blocks.air);
				     		 		world.setBlock(i - 2, j + 1, k - 2, Blocks.air);
				     		 		world.setBlock(i - 2, j + 1, k + 2, Blocks.air);
				     		 		world.setBlock(i + 2, j + 1, k - 2, Blocks.air);
				     		 		
				     		 		world.setBlock(i + 3, j + 5, k + 3, Blocks.air);
				     		 		world.setBlock(i - 3, j + 5, k - 3, Blocks.air);
				     		 		
				     		 		
				     		 		int rand2 = (int)(1 + Math.random() * 4);
				            		 switch (rand2)
				            	     {
				            	     case 1:
				            	     world.setBlock(i - 3, j + 5, k + 3, Blocks.air);
					            	 break;
					            	 
				            	     case 2:
				            	     world.setBlock(i + 3, j + 5, k - 3, Blocks.air);
						             break;
						             
				            	     case 3:
				            	     world.setBlock(i - 3, j + 5, k + 3, Blocks.air);
					            	 world.setBlock(i + 3, j + 5, k - 3, Blocks.air);
							         break;
							         
				            	     case 4:
						             break;
				            	     }

				                     	}
				                     }
		 				
		 				
		 				//Divineral
		 				if (world.getBlock(i, j + 1, k) == NovaCraftBlocks.null_cluster_2
				 				&& world.getBlock(i, j + 4, k) == NovaCraftBlocks.sculk_nullstone
				 				&& world.getBlock(i, j + 5, k) == NovaCraftBlocks.sculk_tentacle_2
				 				
				 				&& world.getBlock(i - 1, j, k + 1) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i - 1, j + 1, k + 1) == NovaCraftBlocks.larimar_block
				                && world.getBlock(i - 1, j + 2, k + 1) == NovaCraftBlocks.larimar_block
				                && world.getBlock(i - 1, j + 3, k + 1) == NovaCraftBlocks.larimar_block
				                
				                && world.getBlock(i + 1, j, k - 1) == NovaCraftBlocks.nullstone_bricks 
				                && world.getBlock(i + 1, j + 1, k - 1) == NovaCraftBlocks.copartz_block
				                && world.getBlock(i + 1, j + 2, k - 1) == NovaCraftBlocks.copartz_block
				                && world.getBlock(i + 1, j + 3, k - 1) == NovaCraftBlocks.copartz_block
				                
				              	&& world.getBlock(i + 1, j, k + 1) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i + 1, j + 1, k + 1) == NovaCraftBlocks.tsavorokite_block
				                && world.getBlock(i + 1, j + 2, k + 1) == NovaCraftBlocks.tsavorokite_block
				                && world.getBlock(i + 1, j + 3, k + 1) == NovaCraftBlocks.tsavorokite_block
				                
				                && world.getBlock(i - 1, j, k - 1) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i - 1, j + 1, k - 1) == NovaCraftBlocks.yttrlinsite_block
				                && world.getBlock(i - 1, j + 2, k - 1) == NovaCraftBlocks.yttrlinsite_block
				                && world.getBlock(i - 1, j + 3, k - 1) == NovaCraftBlocks.yttrlinsite_block
				                
				                && world.getBlock(i + 2, j, k + 2) == NovaCraftBlocks.nullstone
				                && world.getBlock(i + 2, j + 1, k + 2) == NovaCraftBlocks.null_wart
				                
				                && world.getBlock(i - 2, j, k - 2) == NovaCraftBlocks.nullstone
				                && world.getBlock(i - 2, j + 1, k - 2) == NovaCraftBlocks.null_wart
				                
				                && world.getBlock(i - 2, j, k + 2) == NovaCraftBlocks.nullstone
				                && world.getBlock(i - 2, j + 1, k + 2) == NovaCraftBlocks.null_wart
				                
				                && world.getBlock(i + 2, j, k - 2) == NovaCraftBlocks.nullstone
				                && world.getBlock(i + 2, j + 1, k - 2) == NovaCraftBlocks.null_wart
				                
				                && world.getBlock(i + 3, j, k + 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i + 3, j + 1, k + 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i + 3, j + 2, k + 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i + 3, j + 3, k + 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i + 3, j + 4, k + 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i + 3, j + 5, k + 3) == NovaCraftBlocks.block_of_reinforced_vanite
				                
				                && world.getBlock(i - 3, j, k + 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i - 3, j + 1, k + 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i - 3, j + 2, k + 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i - 3, j + 3, k + 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i - 3, j + 4, k + 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i - 3, j + 5, k + 3) == NovaCraftBlocks.block_of_reinforced_vanite
				                
				                && world.getBlock(i + 3, j, k - 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i + 3, j + 1, k - 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i + 3, j + 2, k - 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i + 3, j + 3, k - 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i + 3, j + 4, k - 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i + 3, j + 5, k - 3) == NovaCraftBlocks.block_of_reinforced_vanite
				                
				                && world.getBlock(i - 3, j, k - 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i - 3, j + 1, k - 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i - 3, j + 2, k - 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i - 3, j + 3, k - 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i - 3, j + 4, k - 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i - 3, j + 5, k - 3) == NovaCraftBlocks.block_of_reinforced_vanite
				                
				                && (world.getBlock(i, j + 2, k) == OtherModBlocks.primeval_artifact)
				                && (world.getBlock(i, j + 3, k) == OtherModBlocks.primeval_artifact)
				                                                
				                )
				                {

				                     if (true) {
				                     world.spawnEntityInWorld(new EntityLightningBolt(world, i, j + 2, k));
				                     
				                     world.setBlock(i, j, k, NovaCraftBlocks.cobbled_nullstone);
				                     world.setBlock(i, j + 2, k, NovaCraftBlocks.raw_divineral);
				                     world.setBlock(i, j + 3, k, NovaCraftBlocks.raw_divineral);
				                     
				                     int rand = (int)(1 + Math.random() * 4);
				            		 switch (rand)
				            	     {
				            	     case 1:
				            	     break;
				            	     
				            	     case 2:
				            	     world.setBlock(i, j + 1, k, Blocks.air); 
				            	     break;
				            	     
				            	     case 3:
				            	     world.setBlock(i, j + 1, k, Blocks.air);
				            	     break;
				            	     
				            	     case 4:
				            	     world.setBlock(i, j + 1, k, NovaCraftBlocks.null_cluster_1);
					            	 break;
				                     }
				                     
				                     world.setBlock(i, j + 4, k,  NovaCraftBlocks.nullstone);
				     		 		 world.setBlock(i, j + 5, k, Blocks.air);
				     		 		 
				     		 		 
				     		 		world.setBlock(i - 1, j + 1, k + 1, NovaCraftBlocks.cracked_larimar_block);
				     		 		world.setBlock(i - 1, j + 2, k + 1, NovaCraftBlocks.cracked_larimar_block);
				     		 		world.setBlock(i - 1, j + 3, k + 1, NovaCraftBlocks.cracked_larimar_block);
				     		 		
				     		 		world.setBlock(i + 1, j + 1, k - 1, NovaCraftBlocks.cracked_copartz_block);
				     		 		world.setBlock(i + 1, j + 2, k - 1, NovaCraftBlocks.cracked_copartz_block);
				     		 		world.setBlock(i + 1, j + 3, k - 1, NovaCraftBlocks.cracked_copartz_block);
				     		 		
				     		 		world.setBlock(i + 1, j + 1, k + 1, NovaCraftBlocks.cracked_tsavorokite_block);
				     		 		world.setBlock(i + 1, j + 2, k + 1, NovaCraftBlocks.cracked_tsavorokite_block);
				     		 		world.setBlock(i + 1, j + 3, k + 1, NovaCraftBlocks.cracked_tsavorokite_block);
				     		 		
				     		 		world.setBlock(i - 1, j + 1, k - 1, NovaCraftBlocks.cracked_yttrlinsite_block);
				     		 		world.setBlock(i - 1, j + 2, k - 1, NovaCraftBlocks.cracked_yttrlinsite_block);
				     		 		world.setBlock(i - 1, j + 3, k - 1, NovaCraftBlocks.cracked_yttrlinsite_block);
				     		 		
				     		 		world.setBlock(i + 2, j + 1, k + 2, Blocks.air);
				     		 		world.setBlock(i - 2, j + 1, k - 2, Blocks.air);
				     		 		world.setBlock(i - 2, j + 1, k + 2, Blocks.air);
				     		 		world.setBlock(i + 2, j + 1, k - 2, Blocks.air);
				     		 		
				     		 		world.setBlock(i + 3, j + 5, k + 3, Blocks.air);
				     		 		world.setBlock(i - 3, j + 5, k - 3, Blocks.air);
				     		 		
				     		 		
				     		 		int rand2 = (int)(1 + Math.random() * 4);
				            		 switch (rand2)
				            	     {
				            	     case 1:
				            	     world.setBlock(i - 3, j + 5, k + 3, Blocks.air);
					            	 break;
					            	 
				            	     case 2:
				            	     world.setBlock(i + 3, j + 5, k - 3, Blocks.air);
						             break;
						             
				            	     case 3:
				            	     world.setBlock(i - 3, j + 5, k + 3, Blocks.air);
					            	 world.setBlock(i + 3, j + 5, k - 3, Blocks.air);
							         break;
							         
				            	     case 4:
						             break;
				            	     }

				                     	}
				                     }
		 			}
		 			
		 			//--------------------------------------------------------------------- Divine RPG Ores
		 			//Arlemite Ore
		 			if (Loader.isModLoaded("divinerpg")) {
		 				if (world.getBlock(i, j + 1, k) == NovaCraftBlocks.null_cluster_2
			 				&& world.getBlock(i, j + 4, k) == NovaCraftBlocks.sculk_nullstone
			 				&& world.getBlock(i, j + 5, k) == NovaCraftBlocks.sculk_tentacle_2
			 				
			 				&& world.getBlock(i - 1, j, k + 1) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 1, j + 1, k + 1) == NovaCraftBlocks.larimar_block
			                && world.getBlock(i - 1, j + 2, k + 1) == NovaCraftBlocks.larimar_block
			                && world.getBlock(i - 1, j + 3, k + 1) == NovaCraftBlocks.larimar_block
			                
			                && world.getBlock(i + 1, j, k - 1) == NovaCraftBlocks.nullstone_bricks 
			                && world.getBlock(i + 1, j + 1, k - 1) == NovaCraftBlocks.copartz_block
			                && world.getBlock(i + 1, j + 2, k - 1) == NovaCraftBlocks.copartz_block
			                && world.getBlock(i + 1, j + 3, k - 1) == NovaCraftBlocks.copartz_block
			                
			              	&& world.getBlock(i + 1, j, k + 1) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 1, j + 1, k + 1) == NovaCraftBlocks.tsavorokite_block
			                && world.getBlock(i + 1, j + 2, k + 1) == NovaCraftBlocks.tsavorokite_block
			                && world.getBlock(i + 1, j + 3, k + 1) == NovaCraftBlocks.tsavorokite_block
			                
			                && world.getBlock(i - 1, j, k - 1) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 1, j + 1, k - 1) == NovaCraftBlocks.yttrlinsite_block
			                && world.getBlock(i - 1, j + 2, k - 1) == NovaCraftBlocks.yttrlinsite_block
			                && world.getBlock(i - 1, j + 3, k - 1) == NovaCraftBlocks.yttrlinsite_block
			                
			                && world.getBlock(i + 2, j, k + 2) == NovaCraftBlocks.nullstone
			                && world.getBlock(i + 2, j + 1, k + 2) == NovaCraftBlocks.null_wart
			                
			                && world.getBlock(i - 2, j, k - 2) == NovaCraftBlocks.nullstone
			                && world.getBlock(i - 2, j + 1, k - 2) == NovaCraftBlocks.null_wart
			                
			                && world.getBlock(i - 2, j, k + 2) == NovaCraftBlocks.nullstone
			                && world.getBlock(i - 2, j + 1, k + 2) == NovaCraftBlocks.null_wart
			                
			                && world.getBlock(i + 2, j, k - 2) == NovaCraftBlocks.nullstone
			                && world.getBlock(i + 2, j + 1, k - 2) == NovaCraftBlocks.null_wart
			                
			                && world.getBlock(i + 3, j, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 1, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 2, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 3, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 4, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 5, k + 3) == NovaCraftBlocks.block_of_reinforced_vanite
			                
			                && world.getBlock(i - 3, j, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 1, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 2, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 3, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 4, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 5, k + 3) == NovaCraftBlocks.block_of_reinforced_vanite
			                
			                && world.getBlock(i + 3, j, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 1, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 2, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 3, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 4, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 5, k - 3) == NovaCraftBlocks.block_of_reinforced_vanite
			                
			                && world.getBlock(i - 3, j, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 1, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 2, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 3, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 4, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 5, k - 3) == NovaCraftBlocks.block_of_reinforced_vanite
			                
			                && (world.getBlock(i, j + 2, k) == OtherModBlocks.arlemiteOre)
			                && (world.getBlock(i, j + 3, k) == OtherModBlocks.arlemiteOre)
			                                                
			                )
			                {

			                     if (true) {
			                     world.spawnEntityInWorld(new EntityLightningBolt(world, i, j + 2, k));
			                     
			                     world.setBlock(i, j, k, NovaCraftBlocks.cobbled_nullstone);
			                     world.setBlock(i, j + 2, k, OtherModBlocks.arlemiteBlock);
			                     world.setBlock(i, j + 3, k, OtherModBlocks.arlemiteBlock);
			                     
			                     int rand = (int)(1 + Math.random() * 4);
			            		 switch (rand)
			            	     {
			            	     case 1:
			            	     break;
			            	     
			            	     case 2:
			            	     world.setBlock(i, j + 1, k, Blocks.air); 
			            	     break;
			            	     
			            	     case 3:
			            	     world.setBlock(i, j + 1, k, Blocks.air);
			            	     break;
			            	     
			            	     case 4:
			            	     world.setBlock(i, j + 1, k, NovaCraftBlocks.null_cluster_1);
				            	 break;
			                     }
			                     
			                     world.setBlock(i, j + 4, k,  NovaCraftBlocks.nullstone);
			     		 		 world.setBlock(i, j + 5, k, Blocks.air);
			     		 		 
			     		 		 
			     		 		world.setBlock(i - 1, j + 1, k + 1, NovaCraftBlocks.cracked_larimar_block);
			     		 		world.setBlock(i - 1, j + 2, k + 1, NovaCraftBlocks.cracked_larimar_block);
			     		 		world.setBlock(i - 1, j + 3, k + 1, NovaCraftBlocks.cracked_larimar_block);
			     		 		
			     		 		world.setBlock(i + 1, j + 1, k - 1, NovaCraftBlocks.cracked_copartz_block);
			     		 		world.setBlock(i + 1, j + 2, k - 1, NovaCraftBlocks.cracked_copartz_block);
			     		 		world.setBlock(i + 1, j + 3, k - 1, NovaCraftBlocks.cracked_copartz_block);
			     		 		
			     		 		world.setBlock(i + 1, j + 1, k + 1, NovaCraftBlocks.cracked_tsavorokite_block);
			     		 		world.setBlock(i + 1, j + 2, k + 1, NovaCraftBlocks.cracked_tsavorokite_block);
			     		 		world.setBlock(i + 1, j + 3, k + 1, NovaCraftBlocks.cracked_tsavorokite_block);
			     		 		
			     		 		world.setBlock(i - 1, j + 1, k - 1, NovaCraftBlocks.cracked_yttrlinsite_block);
			     		 		world.setBlock(i - 1, j + 2, k - 1, NovaCraftBlocks.cracked_yttrlinsite_block);
			     		 		world.setBlock(i - 1, j + 3, k - 1, NovaCraftBlocks.cracked_yttrlinsite_block);
			     		 		
			     		 		world.setBlock(i + 2, j + 1, k + 2, Blocks.air);
			     		 		world.setBlock(i - 2, j + 1, k - 2, Blocks.air);
			     		 		world.setBlock(i - 2, j + 1, k + 2, Blocks.air);
			     		 		world.setBlock(i + 2, j + 1, k - 2, Blocks.air);
			     		 		
			     		 		world.setBlock(i + 3, j + 5, k + 3, Blocks.air);
			     		 		world.setBlock(i - 3, j + 5, k - 3, Blocks.air);
			     		 		
			     		 		
			     		 		int rand2 = (int)(1 + Math.random() * 4);
			            		 switch (rand2)
			            	     {
			            	     case 1:
			            	     world.setBlock(i - 3, j + 5, k + 3, Blocks.air);
				            	 break;
				            	 
			            	     case 2:
			            	     world.setBlock(i + 3, j + 5, k - 3, Blocks.air);
					             break;
					             
			            	     case 3:
			            	     world.setBlock(i - 3, j + 5, k + 3, Blocks.air);
				            	 world.setBlock(i + 3, j + 5, k - 3, Blocks.air);
						         break;
						         
			            	     case 4:
					             break;
			            	     }

			                     	}
			                     }
		 				//Rupee Ore
		 				if (world.getBlock(i, j + 1, k) == NovaCraftBlocks.null_cluster_2
				 				&& world.getBlock(i, j + 4, k) == NovaCraftBlocks.sculk_nullstone
				 				&& world.getBlock(i, j + 5, k) == NovaCraftBlocks.sculk_tentacle_2
				 				
				 				&& world.getBlock(i - 1, j, k + 1) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i - 1, j + 1, k + 1) == NovaCraftBlocks.larimar_block
				                && world.getBlock(i - 1, j + 2, k + 1) == NovaCraftBlocks.larimar_block
				                && world.getBlock(i - 1, j + 3, k + 1) == NovaCraftBlocks.larimar_block
				                
				                && world.getBlock(i + 1, j, k - 1) == NovaCraftBlocks.nullstone_bricks 
				                && world.getBlock(i + 1, j + 1, k - 1) == NovaCraftBlocks.copartz_block
				                && world.getBlock(i + 1, j + 2, k - 1) == NovaCraftBlocks.copartz_block
				                && world.getBlock(i + 1, j + 3, k - 1) == NovaCraftBlocks.copartz_block
				                
				              	&& world.getBlock(i + 1, j, k + 1) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i + 1, j + 1, k + 1) == NovaCraftBlocks.tsavorokite_block
				                && world.getBlock(i + 1, j + 2, k + 1) == NovaCraftBlocks.tsavorokite_block
				                && world.getBlock(i + 1, j + 3, k + 1) == NovaCraftBlocks.tsavorokite_block
				                
				                && world.getBlock(i - 1, j, k - 1) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i - 1, j + 1, k - 1) == NovaCraftBlocks.yttrlinsite_block
				                && world.getBlock(i - 1, j + 2, k - 1) == NovaCraftBlocks.yttrlinsite_block
				                && world.getBlock(i - 1, j + 3, k - 1) == NovaCraftBlocks.yttrlinsite_block
				                
				                && world.getBlock(i + 2, j, k + 2) == NovaCraftBlocks.nullstone
				                && world.getBlock(i + 2, j + 1, k + 2) == NovaCraftBlocks.null_wart
				                
				                && world.getBlock(i - 2, j, k - 2) == NovaCraftBlocks.nullstone
				                && world.getBlock(i - 2, j + 1, k - 2) == NovaCraftBlocks.null_wart
				                
				                && world.getBlock(i - 2, j, k + 2) == NovaCraftBlocks.nullstone
				                && world.getBlock(i - 2, j + 1, k + 2) == NovaCraftBlocks.null_wart
				                
				                && world.getBlock(i + 2, j, k - 2) == NovaCraftBlocks.nullstone
				                && world.getBlock(i + 2, j + 1, k - 2) == NovaCraftBlocks.null_wart
				                
				                && world.getBlock(i + 3, j, k + 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i + 3, j + 1, k + 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i + 3, j + 2, k + 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i + 3, j + 3, k + 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i + 3, j + 4, k + 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i + 3, j + 5, k + 3) == NovaCraftBlocks.block_of_reinforced_vanite
				                
				                && world.getBlock(i - 3, j, k + 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i - 3, j + 1, k + 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i - 3, j + 2, k + 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i - 3, j + 3, k + 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i - 3, j + 4, k + 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i - 3, j + 5, k + 3) == NovaCraftBlocks.block_of_reinforced_vanite
				                
				                && world.getBlock(i + 3, j, k - 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i + 3, j + 1, k - 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i + 3, j + 2, k - 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i + 3, j + 3, k - 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i + 3, j + 4, k - 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i + 3, j + 5, k - 3) == NovaCraftBlocks.block_of_reinforced_vanite
				                
				                && world.getBlock(i - 3, j, k - 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i - 3, j + 1, k - 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i - 3, j + 2, k - 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i - 3, j + 3, k - 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i - 3, j + 4, k - 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i - 3, j + 5, k - 3) == NovaCraftBlocks.block_of_reinforced_vanite
				                
				                && (world.getBlock(i, j + 2, k) == OtherModBlocks.rupeeOre)
				                && (world.getBlock(i, j + 3, k) == OtherModBlocks.rupeeOre)
				                                                
				                )
				                {

				                     if (true) {
				                     world.spawnEntityInWorld(new EntityLightningBolt(world, i, j + 2, k));
				                     
				                     world.setBlock(i, j, k, NovaCraftBlocks.cobbled_nullstone);
				                     world.setBlock(i, j + 2, k, OtherModBlocks.rupeeBlock);
				                     world.setBlock(i, j + 3, k, OtherModBlocks.rupeeBlock);
				                     
				                     int rand = (int)(1 + Math.random() * 4);
				            		 switch (rand)
				            	     {
				            	     case 1:
				            	     break;
				            	     
				            	     case 2:
				            	     world.setBlock(i, j + 1, k, Blocks.air); 
				            	     break;
				            	     
				            	     case 3:
				            	     world.setBlock(i, j + 1, k, Blocks.air);
				            	     break;
				            	     
				            	     case 4:
				            	     world.setBlock(i, j + 1, k, NovaCraftBlocks.null_cluster_1);
					            	 break;
				                     }
				                     
				                     world.setBlock(i, j + 4, k,  NovaCraftBlocks.nullstone);
				     		 		 world.setBlock(i, j + 5, k, Blocks.air);
				     		 		 
				     		 		 
				     		 		world.setBlock(i - 1, j + 1, k + 1, NovaCraftBlocks.cracked_larimar_block);
				     		 		world.setBlock(i - 1, j + 2, k + 1, NovaCraftBlocks.cracked_larimar_block);
				     		 		world.setBlock(i - 1, j + 3, k + 1, NovaCraftBlocks.cracked_larimar_block);
				     		 		
				     		 		world.setBlock(i + 1, j + 1, k - 1, NovaCraftBlocks.cracked_copartz_block);
				     		 		world.setBlock(i + 1, j + 2, k - 1, NovaCraftBlocks.cracked_copartz_block);
				     		 		world.setBlock(i + 1, j + 3, k - 1, NovaCraftBlocks.cracked_copartz_block);
				     		 		
				     		 		world.setBlock(i + 1, j + 1, k + 1, NovaCraftBlocks.cracked_tsavorokite_block);
				     		 		world.setBlock(i + 1, j + 2, k + 1, NovaCraftBlocks.cracked_tsavorokite_block);
				     		 		world.setBlock(i + 1, j + 3, k + 1, NovaCraftBlocks.cracked_tsavorokite_block);
				     		 		
				     		 		world.setBlock(i - 1, j + 1, k - 1, NovaCraftBlocks.cracked_yttrlinsite_block);
				     		 		world.setBlock(i - 1, j + 2, k - 1, NovaCraftBlocks.cracked_yttrlinsite_block);
				     		 		world.setBlock(i - 1, j + 3, k - 1, NovaCraftBlocks.cracked_yttrlinsite_block);
				     		 		
				     		 		world.setBlock(i + 2, j + 1, k + 2, Blocks.air);
				     		 		world.setBlock(i - 2, j + 1, k - 2, Blocks.air);
				     		 		world.setBlock(i - 2, j + 1, k + 2, Blocks.air);
				     		 		world.setBlock(i + 2, j + 1, k - 2, Blocks.air);
				     		 		
				     		 		world.setBlock(i + 3, j + 5, k + 3, Blocks.air);
				     		 		world.setBlock(i - 3, j + 5, k - 3, Blocks.air);
				     		 		
				     		 		
				     		 		int rand2 = (int)(1 + Math.random() * 4);
				            		 switch (rand2)
				            	     {
				            	     case 1:
				            	     world.setBlock(i - 3, j + 5, k + 3, Blocks.air);
					            	 break;
					            	 
				            	     case 2:
				            	     world.setBlock(i + 3, j + 5, k - 3, Blocks.air);
						             break;
						             
				            	     case 3:
				            	     world.setBlock(i - 3, j + 5, k + 3, Blocks.air);
					            	 world.setBlock(i + 3, j + 5, k - 3, Blocks.air);
							         break;
							         
				            	     case 4:
						             break;
				            	     }

				                     	}
				                     }
		 				
		 				//Realmite Ore
		 				if (world.getBlock(i, j + 1, k) == NovaCraftBlocks.null_cluster_2
				 				&& world.getBlock(i, j + 4, k) == NovaCraftBlocks.sculk_nullstone
				 				&& world.getBlock(i, j + 5, k) == NovaCraftBlocks.sculk_tentacle_2
				 				
				 				&& world.getBlock(i - 1, j, k + 1) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i - 1, j + 1, k + 1) == NovaCraftBlocks.larimar_block
				                && world.getBlock(i - 1, j + 2, k + 1) == NovaCraftBlocks.larimar_block
				                && world.getBlock(i - 1, j + 3, k + 1) == NovaCraftBlocks.larimar_block
				                
				                && world.getBlock(i + 1, j, k - 1) == NovaCraftBlocks.nullstone_bricks 
				                && world.getBlock(i + 1, j + 1, k - 1) == NovaCraftBlocks.copartz_block
				                && world.getBlock(i + 1, j + 2, k - 1) == NovaCraftBlocks.copartz_block
				                && world.getBlock(i + 1, j + 3, k - 1) == NovaCraftBlocks.copartz_block
				                
				              	&& world.getBlock(i + 1, j, k + 1) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i + 1, j + 1, k + 1) == NovaCraftBlocks.tsavorokite_block
				                && world.getBlock(i + 1, j + 2, k + 1) == NovaCraftBlocks.tsavorokite_block
				                && world.getBlock(i + 1, j + 3, k + 1) == NovaCraftBlocks.tsavorokite_block
				                
				                && world.getBlock(i - 1, j, k - 1) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i - 1, j + 1, k - 1) == NovaCraftBlocks.yttrlinsite_block
				                && world.getBlock(i - 1, j + 2, k - 1) == NovaCraftBlocks.yttrlinsite_block
				                && world.getBlock(i - 1, j + 3, k - 1) == NovaCraftBlocks.yttrlinsite_block
				                
				                && world.getBlock(i + 2, j, k + 2) == NovaCraftBlocks.nullstone
				                && world.getBlock(i + 2, j + 1, k + 2) == NovaCraftBlocks.null_wart
				                
				                && world.getBlock(i - 2, j, k - 2) == NovaCraftBlocks.nullstone
				                && world.getBlock(i - 2, j + 1, k - 2) == NovaCraftBlocks.null_wart
				                
				                && world.getBlock(i - 2, j, k + 2) == NovaCraftBlocks.nullstone
				                && world.getBlock(i - 2, j + 1, k + 2) == NovaCraftBlocks.null_wart
				                
				                && world.getBlock(i + 2, j, k - 2) == NovaCraftBlocks.nullstone
				                && world.getBlock(i + 2, j + 1, k - 2) == NovaCraftBlocks.null_wart
				                
				                && world.getBlock(i + 3, j, k + 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i + 3, j + 1, k + 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i + 3, j + 2, k + 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i + 3, j + 3, k + 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i + 3, j + 4, k + 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i + 3, j + 5, k + 3) == NovaCraftBlocks.block_of_reinforced_vanite
				                
				                && world.getBlock(i - 3, j, k + 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i - 3, j + 1, k + 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i - 3, j + 2, k + 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i - 3, j + 3, k + 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i - 3, j + 4, k + 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i - 3, j + 5, k + 3) == NovaCraftBlocks.block_of_reinforced_vanite
				                
				                && world.getBlock(i + 3, j, k - 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i + 3, j + 1, k - 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i + 3, j + 2, k - 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i + 3, j + 3, k - 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i + 3, j + 4, k - 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i + 3, j + 5, k - 3) == NovaCraftBlocks.block_of_reinforced_vanite
				                
				                && world.getBlock(i - 3, j, k - 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i - 3, j + 1, k - 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i - 3, j + 2, k - 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i - 3, j + 3, k - 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i - 3, j + 4, k - 3) == NovaCraftBlocks.nullstone_bricks
				                && world.getBlock(i - 3, j + 5, k - 3) == NovaCraftBlocks.block_of_reinforced_vanite
				                
				                && (world.getBlock(i, j + 2, k) == OtherModBlocks.realmiteOre)
				                && (world.getBlock(i, j + 3, k) == OtherModBlocks.realmiteOre)
				                                                
				                )
				                {

				                     if (true) {
				                     world.spawnEntityInWorld(new EntityLightningBolt(world, i, j + 2, k));
				                     
				                     world.setBlock(i, j, k, NovaCraftBlocks.cobbled_nullstone);
				                     world.setBlock(i, j + 2, k, OtherModBlocks.realmiteBlock);
				                     world.setBlock(i, j + 3, k, OtherModBlocks.realmiteBlock);
				                     
				                     int rand = (int)(1 + Math.random() * 4);
				            		 switch (rand)
				            	     {
				            	     case 1:
				            	     break;
				            	     
				            	     case 2:
				            	     world.setBlock(i, j + 1, k, Blocks.air); 
				            	     break;
				            	     
				            	     case 3:
				            	     world.setBlock(i, j + 1, k, Blocks.air);
				            	     break;
				            	     
				            	     case 4:
				            	     world.setBlock(i, j + 1, k, NovaCraftBlocks.null_cluster_1);
					            	 break;
				                     }
				                     
				                     world.setBlock(i, j + 4, k,  NovaCraftBlocks.nullstone);
				     		 		 world.setBlock(i, j + 5, k, Blocks.air);
				     		 		 
				     		 		 
				     		 		world.setBlock(i - 1, j + 1, k + 1, NovaCraftBlocks.cracked_larimar_block);
				     		 		world.setBlock(i - 1, j + 2, k + 1, NovaCraftBlocks.cracked_larimar_block);
				     		 		world.setBlock(i - 1, j + 3, k + 1, NovaCraftBlocks.cracked_larimar_block);
				     		 		
				     		 		world.setBlock(i + 1, j + 1, k - 1, NovaCraftBlocks.cracked_copartz_block);
				     		 		world.setBlock(i + 1, j + 2, k - 1, NovaCraftBlocks.cracked_copartz_block);
				     		 		world.setBlock(i + 1, j + 3, k - 1, NovaCraftBlocks.cracked_copartz_block);
				     		 		
				     		 		world.setBlock(i + 1, j + 1, k + 1, NovaCraftBlocks.cracked_tsavorokite_block);
				     		 		world.setBlock(i + 1, j + 2, k + 1, NovaCraftBlocks.cracked_tsavorokite_block);
				     		 		world.setBlock(i + 1, j + 3, k + 1, NovaCraftBlocks.cracked_tsavorokite_block);
				     		 		
				     		 		world.setBlock(i - 1, j + 1, k - 1, NovaCraftBlocks.cracked_yttrlinsite_block);
				     		 		world.setBlock(i - 1, j + 2, k - 1, NovaCraftBlocks.cracked_yttrlinsite_block);
				     		 		world.setBlock(i - 1, j + 3, k - 1, NovaCraftBlocks.cracked_yttrlinsite_block);
				     		 		
				     		 		world.setBlock(i + 2, j + 1, k + 2, Blocks.air);
				     		 		world.setBlock(i - 2, j + 1, k - 2, Blocks.air);
				     		 		world.setBlock(i - 2, j + 1, k + 2, Blocks.air);
				     		 		world.setBlock(i + 2, j + 1, k - 2, Blocks.air);
				     		 		
				     		 		world.setBlock(i + 3, j + 5, k + 3, Blocks.air);
				     		 		world.setBlock(i - 3, j + 5, k - 3, Blocks.air);
				     		 		
				     		 		
				     		 		int rand2 = (int)(1 + Math.random() * 4);
				            		 switch (rand2)
				            	     {
				            	     case 1:
				            	     world.setBlock(i - 3, j + 5, k + 3, Blocks.air);
					            	 break;
					            	 
				            	     case 2:
				            	     world.setBlock(i + 3, j + 5, k - 3, Blocks.air);
						             break;
						             
				            	     case 3:
				            	     world.setBlock(i - 3, j + 5, k + 3, Blocks.air);
					            	 world.setBlock(i + 3, j + 5, k - 3, Blocks.air);
							         break;
							         
				            	     case 4:
						             break;
				            	     }

				                     	}
				                     }
		 			}
		 			//--------------------------------------------------------------------- Et Futurum Requiem Ores
		 			//Netherite
		 			if (Loader.isModLoaded("etfuturum")) {
	 				if (world.getBlock(i, j + 1, k) == NovaCraftBlocks.null_cluster_2
			 				&& world.getBlock(i, j + 4, k) == NovaCraftBlocks.sculk_nullstone
			 				&& world.getBlock(i, j + 5, k) == NovaCraftBlocks.sculk_tentacle_2
			 				
			 				&& world.getBlock(i - 1, j, k + 1) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 1, j + 1, k + 1) == NovaCraftBlocks.larimar_block
			                && world.getBlock(i - 1, j + 2, k + 1) == NovaCraftBlocks.larimar_block
			                && world.getBlock(i - 1, j + 3, k + 1) == NovaCraftBlocks.larimar_block
			                
			                && world.getBlock(i + 1, j, k - 1) == NovaCraftBlocks.nullstone_bricks 
			                && world.getBlock(i + 1, j + 1, k - 1) == NovaCraftBlocks.copartz_block
			                && world.getBlock(i + 1, j + 2, k - 1) == NovaCraftBlocks.copartz_block
			                && world.getBlock(i + 1, j + 3, k - 1) == NovaCraftBlocks.copartz_block
			                
			              	&& world.getBlock(i + 1, j, k + 1) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 1, j + 1, k + 1) == NovaCraftBlocks.tsavorokite_block
			                && world.getBlock(i + 1, j + 2, k + 1) == NovaCraftBlocks.tsavorokite_block
			                && world.getBlock(i + 1, j + 3, k + 1) == NovaCraftBlocks.tsavorokite_block
			                
			                && world.getBlock(i - 1, j, k - 1) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 1, j + 1, k - 1) == NovaCraftBlocks.yttrlinsite_block
			                && world.getBlock(i - 1, j + 2, k - 1) == NovaCraftBlocks.yttrlinsite_block
			                && world.getBlock(i - 1, j + 3, k - 1) == NovaCraftBlocks.yttrlinsite_block
			                
			                && world.getBlock(i + 2, j, k + 2) == NovaCraftBlocks.nullstone
			                && world.getBlock(i + 2, j + 1, k + 2) == NovaCraftBlocks.null_wart
			                
			                && world.getBlock(i - 2, j, k - 2) == NovaCraftBlocks.nullstone
			                && world.getBlock(i - 2, j + 1, k - 2) == NovaCraftBlocks.null_wart
			                
			                && world.getBlock(i - 2, j, k + 2) == NovaCraftBlocks.nullstone
			                && world.getBlock(i - 2, j + 1, k + 2) == NovaCraftBlocks.null_wart
			                
			                && world.getBlock(i + 2, j, k - 2) == NovaCraftBlocks.nullstone
			                && world.getBlock(i + 2, j + 1, k - 2) == NovaCraftBlocks.null_wart
			                
			                && world.getBlock(i + 3, j, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 1, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 2, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 3, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 4, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 5, k + 3) == NovaCraftBlocks.block_of_reinforced_vanite
			                
			                && world.getBlock(i - 3, j, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 1, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 2, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 3, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 4, k + 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 5, k + 3) == NovaCraftBlocks.block_of_reinforced_vanite
			                
			                && world.getBlock(i + 3, j, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 1, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 2, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 3, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 4, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i + 3, j + 5, k - 3) == NovaCraftBlocks.block_of_reinforced_vanite
			                
			                && world.getBlock(i - 3, j, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 1, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 2, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 3, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 4, k - 3) == NovaCraftBlocks.nullstone_bricks
			                && world.getBlock(i - 3, j + 5, k - 3) == NovaCraftBlocks.block_of_reinforced_vanite
			                
			                && (world.getBlock(i, j + 2, k) == OtherModBlocks.ancient_debris)
			                && (world.getBlock(i, j + 3, k) == OtherModBlocks.ancient_debris)
			                                                
			                )
			                {

			                     if (true) {
			                     world.spawnEntityInWorld(new EntityLightningBolt(world, i, j + 2, k));
			                     
			                     world.setBlock(i, j, k, NovaCraftBlocks.cobbled_nullstone);
			                     world.setBlock(i, j + 2, k, NovaCraftBlocks.raw_netherite);
			                     world.setBlock(i, j + 3, k, NovaCraftBlocks.raw_netherite);
			                     
			                     int rand = (int)(1 + Math.random() * 4);
			            		 switch (rand)
			            	     {
			            	     case 1:
			            	     break;
			            	     
			            	     case 2:
			            	     world.setBlock(i, j + 1, k, Blocks.air); 
			            	     break;
			            	     
			            	     case 3:
			            	     world.setBlock(i, j + 1, k, Blocks.air);
			            	     break;
			            	     
			            	     case 4:
			            	     world.setBlock(i, j + 1, k, NovaCraftBlocks.null_cluster_1);
				            	 break;
			                     }
			                     
			                     world.setBlock(i, j + 4, k,  NovaCraftBlocks.nullstone);
			     		 		 world.setBlock(i, j + 5, k, Blocks.air);
			     		 		 
			     		 		 
			     		 		world.setBlock(i - 1, j + 1, k + 1, NovaCraftBlocks.cracked_larimar_block);
			     		 		world.setBlock(i - 1, j + 2, k + 1, NovaCraftBlocks.cracked_larimar_block);
			     		 		world.setBlock(i - 1, j + 3, k + 1, NovaCraftBlocks.cracked_larimar_block);
			     		 		
			     		 		world.setBlock(i + 1, j + 1, k - 1, NovaCraftBlocks.cracked_copartz_block);
			     		 		world.setBlock(i + 1, j + 2, k - 1, NovaCraftBlocks.cracked_copartz_block);
			     		 		world.setBlock(i + 1, j + 3, k - 1, NovaCraftBlocks.cracked_copartz_block);
			     		 		
			     		 		world.setBlock(i + 1, j + 1, k + 1, NovaCraftBlocks.cracked_tsavorokite_block);
			     		 		world.setBlock(i + 1, j + 2, k + 1, NovaCraftBlocks.cracked_tsavorokite_block);
			     		 		world.setBlock(i + 1, j + 3, k + 1, NovaCraftBlocks.cracked_tsavorokite_block);
			     		 		
			     		 		world.setBlock(i - 1, j + 1, k - 1, NovaCraftBlocks.cracked_yttrlinsite_block);
			     		 		world.setBlock(i - 1, j + 2, k - 1, NovaCraftBlocks.cracked_yttrlinsite_block);
			     		 		world.setBlock(i - 1, j + 3, k - 1, NovaCraftBlocks.cracked_yttrlinsite_block);
			     		 		
			     		 		world.setBlock(i + 2, j + 1, k + 2, Blocks.air);
			     		 		world.setBlock(i - 2, j + 1, k - 2, Blocks.air);
			     		 		world.setBlock(i - 2, j + 1, k + 2, Blocks.air);
			     		 		world.setBlock(i + 2, j + 1, k - 2, Blocks.air);
			     		 		
			     		 		world.setBlock(i + 3, j + 5, k + 3, Blocks.air);
			     		 		world.setBlock(i - 3, j + 5, k - 3, Blocks.air);
			     		 		
			     		 		
			     		 		int rand2 = (int)(1 + Math.random() * 4);
			            		 switch (rand2)
			            	     {
			            	     case 1:
			            	     world.setBlock(i - 3, j + 5, k + 3, Blocks.air);
				            	 break;
				            	 
			            	     case 2:
			            	     world.setBlock(i + 3, j + 5, k - 3, Blocks.air);
					             break;
					             
			            	     case 3:
			            	     world.setBlock(i - 3, j + 5, k + 3, Blocks.air);
				            	 world.setBlock(i + 3, j + 5, k - 3, Blocks.air);
						         break;
						         
			            	     case 4:
					             break;
			            	     }

			                     	}
			                     }
		 			}

				world.scheduleBlockUpdate(i, j, k, this, this.tickRate(world));
	}
	
	@Override
	public int tickRate(World world) {
		return 20;
	}
	
}
