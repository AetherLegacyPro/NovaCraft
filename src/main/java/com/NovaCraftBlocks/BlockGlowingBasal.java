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
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockGlowingBasal extends Block {
	
	public BlockGlowingBasal() {
		super(Material.rock);
		this.setTickRandomly(true);
		this.setHardness(1.5F);
		this.setResistance(12F);
		this.setStepSound(ModSounds.soundGrimstone);
		this.setHarvestLevel("pickaxe", 2);
	}
	
	@Override
	public void onEntityWalking(World world, int x, int y, int z, Entity entity) {
 		if (entity instanceof EntityPlayer && world.provider.dimensionId == -1) {
			EntityPlayer player = (EntityPlayer) entity;

			entity.attackEntityFrom(DamageSource.inFire, 1.0F);
			entity.setFire(7);
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

        if (l == 1)
        {
        	ParticleHandler.REGULARFLAME.spawn(p_149734_1_, d0 - d4, d1 + d3, d2, 0.0D, 0.08D, 0.0D, 0.0f, new Object[0]);
        }
        else if (l == 2)
        {
        	ParticleHandler.REGULARFLAME.spawn(p_149734_1_, d0 - d4, d1 + d3, d2, 0.0D, 0.08D, 0.0D, 0.0f, new Object[0]);
        }
        else if (l == 3)
        {
        	ParticleHandler.REGULARFLAME.spawn(p_149734_1_, d0 - d4, d1 + d3, d2, 0.0D, 0.08D, 0.0D, 0.0f, new Object[0]);
        }
        else if (l == 4)
        {
        	ParticleHandler.REGULARFLAME.spawn(p_149734_1_, d0 - d4, d1 + d3, d2, 0.0D, 0.08D, 0.0D, 0.0f, new Object[0]);
        }
        else
        {
        	ParticleHandler.REGULARFLAME.spawn(p_149734_1_, d0 - d4, d1 + d3, d2, 0.0D, 0.08D, 0.0D, 0.0f, new Object[0]);
        }
    }

}
