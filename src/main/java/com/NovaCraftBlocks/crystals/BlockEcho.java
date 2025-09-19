package com.NovaCraftBlocks.crystals;

import java.util.List;
import java.util.Random;

import com.NovaCraft.NovaCraft;
import com.NovaCraft.sounds.ModSounds;
import com.NovaCraftBlocks.NovaCraftBlocks;
import com.ibm.icu.impl.duration.impl.Utils;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockEcho extends Block {

    private IIcon[] icon;
	
	public BlockEcho() {
		super(Material.glass);
		this.icon = new IIcon[1];
		this.setHardness(5F);
		this.setResistance(13);
		this.setStepSound(ModSounds.soundCrystal);
		this.setHarvestLevel("pickaxe", 3);
		setTickRandomly(true);
	}	
	
	public void registerBlockIcons(final IIconRegister iconRegister) {
        this.icon[0] = iconRegister.registerIcon("nova_craft:echo_block");
    }
	
	public IIcon getIcon(final int side, int meta) {
        if (meta < 0 || meta >= this.icon.length) {
            meta = 1;
        }
        return this.icon[meta];
    }
	    
	protected boolean canSilkHarvest() {
	    return true;
	 }
		
 	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
	  {
	    return null;
	  }
 	
 	public void updateTick(World world, int i, int j, int k, Random random) {
		
 		if (world.provider.dimensionId == 1) {
 			if (world.getBlock(i, j + 1, k) == NovaCraftBlocks.echo_cluster_2
                && world.getBlock(i, j, k + 1) == NovaCraftBlocks.budding_aether_block
                && world.getBlock(i, j, k - 1) == NovaCraftBlocks.budding_aether_block
                && world.getBlock(i + 1, j, k) == NovaCraftBlocks.budding_aether_block
                && world.getBlock(i - 1, j, k) == NovaCraftBlocks.budding_aether_block
                
                && world.getBlock(i, j + 1, k + 1) == NovaCraftBlocks.aether_cluster_2
                && world.getBlock(i, j + 1, k - 1) == NovaCraftBlocks.aether_cluster_2
                && world.getBlock(i + 1, j + 1, k) == NovaCraftBlocks.aether_cluster_2
                && world.getBlock(i - 1, j + 1, k) == NovaCraftBlocks.aether_cluster_2

                && world.getBlock(i + 1, j, k + 1) == NovaCraftBlocks.budding_yttrlinsite_block
                && world.getBlock(i + 1, j + 1, k + 1) == NovaCraftBlocks.yttrlinsite_cluster_2
                
                
                && world.getBlock(i - 1, j, k - 1) == NovaCraftBlocks.budding_tsavorokite_block
                && world.getBlock(i - 1, j + 1, k - 1) == NovaCraftBlocks.tsavorokite_cluster_2
                
                
                && world.getBlock(i + 1, j, k - 1) == NovaCraftBlocks.budding_copartz_block
                && world.getBlock(i + 1, j + 1, k - 1) == NovaCraftBlocks.copartz_cluster_2

                
                && world.getBlock(i - 1, j, k + 1) == NovaCraftBlocks.budding_larimar_block
                && world.getBlock(i - 1, j + 1, k + 1) == NovaCraftBlocks.larimar_cluster_2

                && world.getBlock(i - 2, j, k) == NovaCraftBlocks.sculk_endstone
                && world.getBlock(i - 2, j, k + 1) == NovaCraftBlocks.sculk_endstone
                && world.getBlock(i - 2, j, k - 1) == NovaCraftBlocks.sculk_endstone
                && world.getBlock(i - 2, j + 1, k) == NovaCraftBlocks.sculk_tentacle_2
                && world.getBlock(i - 2, j + 1, k + 1) == NovaCraftBlocks.sculk_tentacle_2
                && world.getBlock(i - 2, j + 1, k - 1) == NovaCraftBlocks.sculk_tentacle_2
              
                && world.getBlock(i + 2, j, k) == NovaCraftBlocks.sculk_endstone
                && world.getBlock(i + 2, j, k + 1) == NovaCraftBlocks.sculk_endstone
                && world.getBlock(i + 2, j, k - 1) == NovaCraftBlocks.sculk_endstone
                && world.getBlock(i + 2, j + 1, k) == NovaCraftBlocks.sculk_tentacle_2
                && world.getBlock(i + 2, j + 1, k + 1) == NovaCraftBlocks.sculk_tentacle_2
                && world.getBlock(i + 2, j + 1, k - 1) == NovaCraftBlocks.sculk_tentacle_2
                
                && world.getBlock(i, j, k + 2) == NovaCraftBlocks.sculk_endstone
                && world.getBlock(i + 1, j, k + 2) == NovaCraftBlocks.sculk_endstone
                && world.getBlock(i - 1, j, k + 2) == NovaCraftBlocks.sculk_endstone
                && world.getBlock(i, j + 1, k + 2) == NovaCraftBlocks.sculk_tentacle_2
                && world.getBlock(i + 1, j + 1, k + 2) == NovaCraftBlocks.sculk_tentacle_2
                && world.getBlock(i - 1, j + 1, k + 2) == NovaCraftBlocks.sculk_tentacle_2

                && world.getBlock(i, j, k + 2) == NovaCraftBlocks.sculk_endstone
                && world.getBlock(i + 1, j, k - 2) == NovaCraftBlocks.sculk_endstone
                && world.getBlock(i - 1, j, k - 2) == NovaCraftBlocks.sculk_endstone
                && world.getBlock(i, j + 1, k + 2) == NovaCraftBlocks.sculk_tentacle_2
                && world.getBlock(i + 1, j + 1, k - 2) == NovaCraftBlocks.sculk_tentacle_2
                && world.getBlock(i - 1, j + 1, k - 2) == NovaCraftBlocks.sculk_tentacle_2


                
                )
                {

                     if (true) {
                     world.spawnEntityInWorld(new EntityLightningBolt(world, i, j + 1, k));
                     
                     world.setBlock(i, j, k + 1, NovaCraftBlocks.cracked_aether_block, 0, 2);
                     world.setBlock(i, j, k - 1, NovaCraftBlocks.cracked_aether_block, 0, 2);
                     world.setBlock(i + 1, j, k, NovaCraftBlocks.cracked_aether_block, 0, 2);
                     world.setBlock(i - 1, j, k, NovaCraftBlocks.cracked_aether_block, 0, 2);
                     
                     world.setBlock(i, j + 1, k + 1, Blocks.air, 0, 2);
                     world.setBlock(i, j + 1, k - 1, Blocks.air, 0, 2);
                     world.setBlock(i + 1, j + 1, k, Blocks.air, 0, 2);
                     world.setBlock(i - 1, j + 1, k, Blocks.air, 0, 2);
                     

                     world.setBlock(i, j, k, NovaCraftBlocks.budding_null_block, 0, 2);
                     world.setBlock(i, j + 1, k, NovaCraftBlocks.null_cluster_1, 1, 2);
                     
                     world.setBlock(i, j + 1, k - 2, Blocks.fire, 0, 2);
                     world.setBlock(i + 1, j + 1, k - 2, Blocks.fire, 0, 2);
                     world.setBlock(i - 1, j + 1, k - 2, Blocks.fire, 0, 2);

                     world.setBlock(i, j + 1, k + 2, Blocks.fire, 0, 2);
                     world.setBlock(i + 1, j + 1, k + 2, Blocks.fire, 0, 2);
                     world.setBlock(i - 1, j + 1, k + 2, Blocks.fire, 0, 2);

                     world.setBlock(i + 2, j + 1, k, Blocks.fire, 0, 2);
                     world.setBlock(i + 2, j + 1, k + 1, Blocks.fire, 0, 2);
                     world.setBlock(i + 2, j + 1, k - 1, Blocks.fire, 0, 2);

                     world.setBlock(i - 2, j + 1, k, Blocks.fire, 0, 2);
                     world.setBlock(i - 2, j + 1, k + 1, Blocks.fire, 0, 2);
                     world.setBlock(i - 2, j + 1, k - 1, Blocks.fire, 0, 2);

                     world.setBlock(i + 1, j, k + 1, NovaCraftBlocks.cracked_yttrlinsite_block, 0, 2);
                     world.setBlock(i + 1, j + 1, k + 1, Blocks.air, 0, 2);
                     world.setBlock(i - 1, j, k - 1, NovaCraftBlocks.cracked_tsavorokite_block, 0, 2);
                     world.setBlock(i - 1, j + 1, k - 1, Blocks.air, 0, 2);
                     world.setBlock(i + 1, j, k - 1, NovaCraftBlocks.cracked_copartz_block, 0, 2);
                     world.setBlock(i + 1, j + 1, k - 1, Blocks.air, 0, 2);
                     world.setBlock(i - 1, j, k + 1, NovaCraftBlocks.cracked_larimar_block, 0, 2);
                     world.setBlock(i - 1, j + 1, k + 1, Blocks.air, 0, 2);

                     	}
                     }
                }

		world.scheduleBlockUpdate(i, j, k, this, this.tickRate(world));
	}
 	
 	
 	@Override
	public int getExpDrop(IBlockAccess p_149690_1_, int p_149690_5_, int p_149690_7_) {
		Random random = new Random();

		if (this.getItemDropped(p_149690_5_, random, p_149690_7_) != Item.getItemFromBlock(this)) {
			int amount = 0;	
			
				amount = MathHelper.getRandomIntegerInRange(random, 0, 2);
			

			return amount;
		}

		return 0;
	}
 	
 	@Override
	public boolean isOpaqueCube() {
		return true;
	}
 	
 	@Override
	public int tickRate(World world) {
		return 10;
	}

}
