package com.NovaCraftBlocks;

import java.util.Random;

import com.NovaCraft.NovaCraft;
import com.NovaCraft.particles.ParticleHandler;
import com.NovaCraft.sounds.ModSounds;
import com.ibm.icu.impl.duration.impl.Utils;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockGlowingObsidian extends Block {
	
	public BlockGlowingObsidian() {
		super(Material.rock);
		this.setTickRandomly(true);
		this.setLightLevel(0.38F);
		this.setHardness(50F);
		this.setResistance(6000F);
		this.setStepSound(soundTypeStone);
		this.setHarvestLevel("pickaxe", 3);
	}
	
	@Override
	public void onEntityWalking(World world, int x, int y, int z, Entity entity) {
 		if (!entity.isImmuneToFire()) {
			entity.setFire(3);
 		}
	}

    public void onEntityCollidedWithBlock(World p_149670_1_, int p_149670_2_, int p_149670_3_, int p_149670_4_, Entity p_149670_5_)
    {	
        p_149670_5_.motionX *= 0.75D;
        p_149670_5_.motionZ *= 0.75D;
    }
    
    public Item getItemDropped(final int metadata, final Random rand, final int fortune) {
        return Item.getItemFromBlock(Blocks.obsidian);
    }
    
    protected boolean canSilkHarvest() {
        return false;
    }
    
    @Override
	public void updateTick(World world, int i, int j, int k, Random random) {
    	
    	if (world.getBlock(i, j - 1, k) != Blocks.lava) {   		
    		world.setBlock(i, j, k, Blocks.obsidian, 0, 2);
            world.playSoundEffect((double)(i + 0.5f), (double)(j + 0.5f), (double)(k + 0.5f), "random.fizz", 0.5f, 2.6f + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8f);    		
    	}
    	
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
		
        int l = p_149734_1_.getBlockMetadata(p_149734_2_, p_149734_3_, p_149734_4_);
        double d0 = (double)((float)p_149734_2_ + 0.5F + (p_149734_5_.nextFloat()) - (p_149734_5_.nextFloat()));
        double d1 = (double)((float)p_149734_3_ + 1.0F);
        double d2 = (double)((float)p_149734_4_ + 0.5F + (p_149734_5_.nextFloat()) - (p_149734_5_.nextFloat()));
        double d3 = 0.2199999988079071D;
        double d4 = 0.27000001072883606D;

        if (p_149734_1_.getBlock(p_149734_2_, p_149734_3_ + 1, p_149734_4_) == Blocks.water || p_149734_1_.getBlock(p_149734_2_, p_149734_3_ + 1, p_149734_4_) == Blocks.flowing_water) {
        	  
        	p_149734_1_.spawnParticle("largesmoke", (double)p_149734_2_ + Math.random(), (double)p_149734_3_ + 1.2D, (double)p_149734_4_ + Math.random(), 0.0D, 0.0D, 0.0D);

        }
    }

}
