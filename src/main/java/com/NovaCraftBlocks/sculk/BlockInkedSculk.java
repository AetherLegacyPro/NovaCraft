package com.NovaCraftBlocks.sculk;

import java.util.List;
import java.util.Random;

import com.NovaCraft.NovaCraft;
import com.NovaCraft.particles.ParticleDarkLichenThree;
import com.NovaCraft.particles.ParticleGlowLichen;
import com.NovaCraft.particles.ParticleHandler;
import com.NovaCraft.sounds.ModSounds;
import com.NovaCraftBlocks.NovaCraftBlocks;
import com.NovaCraftBlocks.crystals.BlockLarimarCluster;
import com.ibm.icu.impl.duration.impl.Utils;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockInkedSculk extends Block {

    private IIcon[] icons;
	
	public BlockInkedSculk() {
		super(Material.grass);
		this.setHardness(0.3F);
		this.setResistance(1);
		this.setStepSound(ModSounds.soundSculk);
		this.setHarvestLevel("shovel", 0);
	}


	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister registry) {
		this.icons = new IIcon[4];
		this.icons[0] = registry.registerIcon("nova_craft:sculk_0");
		this.icons[1] = registry.registerIcon("nova_craft:sculk_1");
		this.icons[2] = registry.registerIcon("nova_craft:sculk_2");
		this.icons[3] = registry.registerIcon("nova_craft:sculk_3");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(IBlockAccess world, int x, int y, int z, int side) {
		int hash = x * 3129871 ^ z * 116129781 ^ y;
		hash = hash * hash * 42317861 + hash * 11;
		int choice = (hash >> 16) & 3;

		return this.icons[choice % this.icons.length];
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		return icons[0];
	}
	    
	protected boolean canSilkHarvest() {
	    return true;
	 }
		
 	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
	  {
	    return null;
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
 	
 	
 	@Override
	public boolean isOpaqueCube() {
		return true;
	}
 	
 	@Override
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(final World p_149734_1_, final int p_149734_2_, final int p_149734_3_, final int p_149734_4_, final Random p_149734_5_) {
        super.randomDisplayTick(p_149734_1_, p_149734_2_, p_149734_3_, p_149734_4_, p_149734_5_);
        if (p_149734_5_.nextInt(15) == 0) {
            ParticleHandler.SCULK.spawn(p_149734_1_, p_149734_2_ + p_149734_5_.nextFloat(), p_149734_3_ + 0.1f, p_149734_4_ + p_149734_5_.nextFloat(), 0.0, 0.0, 0.0, 0.0f, new Object[0]);
            ParticleHandler.SCULK.spawn(p_149734_1_, p_149734_2_ + p_149734_5_.nextFloat(), p_149734_3_ + 0.4f, p_149734_4_ + p_149734_5_.nextFloat(), 0.0, 0.0, 0.0, 0.0f, new Object[0]);
            ParticleHandler.SCULK.spawn(p_149734_1_, p_149734_2_ + p_149734_5_.nextFloat(), p_149734_3_ + 0.6f, p_149734_4_ + p_149734_5_.nextFloat(), 0.0, 0.0, 0.0, 0.0f, new Object[0]);
            ParticleHandler.SCULK.spawn(p_149734_1_, p_149734_2_ + p_149734_5_.nextFloat(), p_149734_3_ + 0.9f, p_149734_4_ + p_149734_5_.nextFloat(), 0.0, 0.0, 0.0, 0.0f, new Object[0]);
            ParticleHandler.SCULK.spawn(p_149734_1_, p_149734_2_ + p_149734_5_.nextFloat(), p_149734_3_ + 1.1f, p_149734_4_ + p_149734_5_.nextFloat(), 0.0, 0.0, 0.0, 0.0f, new Object[0]);
        }	
        
    }

}
