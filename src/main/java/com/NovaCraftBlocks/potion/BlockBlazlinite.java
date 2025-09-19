package com.NovaCraftBlocks.potion;

import net.minecraft.util.*;
import net.minecraftforge.fluids.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.world.*;
import java.util.*;

import com.NovaCraft.entity.EntityBlazingSerpent;
import com.NovaCraft.entity.EntityBlazingSerpentQueen;
import com.NovaCraft.entity.EntityIonizatior;
import com.NovaCraft.entity.EntitySavageSerpent;
import com.NovaCraft.particles.ParticleHandler;
import com.NovaCraft.registry.NovaCraftCreativeTabs;
import com.NovaCraftBlocks.NovaCraftBlocks;

import net.minecraft.block.*;
import cpw.mods.fml.relauncher.*;

public class BlockBlazlinite extends BlockFluidClassic
{
    public static IIcon BlazliniteStillIcon;
    public static IIcon BlazliniteFlowingIcon;
    
    public BlockBlazlinite() {
        super(FluidRegistry.getFluid("blazlinite"), Material.lava);
        this.lightOpacity = 0;
        this.setLightLevel(1.0f);
        this.setCreativeTab(NovaCraftCreativeTabs.blocks);
    }
    
    public void registerBlockIcons(final IIconRegister iconRegister) {
    	BlockBlazlinite.BlazliniteStillIcon = iconRegister.registerIcon("nova_craft:blazlinite_still");
    	BlockBlazlinite.BlazliniteFlowingIcon = iconRegister.registerIcon("nova_craft:blazlinite_flowing");
    }
    
    public IIcon getIcon(final int side, final int meta) {
        return (side != 0 && side != 1) ? BlockBlazlinite.BlazliniteFlowingIcon : BlockBlazlinite.BlazliniteStillIcon;
    }
    
    public void updateTick(final World world, final int x, final int y, final int z, final Random rand) {
        final int currentMeta = world.getBlockMetadata(x, y, z);
        if (currentMeta > 0 && world.getBlock(x, y - 1, z).getMaterial() != Material.air) {
            int neighbourSources = 0;
            if (this.IsNeighbourSource(world, x + 1, y, z)) {
                ++neighbourSources;
            }
            if (this.IsNeighbourSource(world, x - 1, y, z)) {
                ++neighbourSources;
            }
            if (this.IsNeighbourSource(world, x, y, z + 1)) {
                ++neighbourSources;
            }
            if (this.IsNeighbourSource(world, x, y, z - 1)) {
                ++neighbourSources;
            }
        }
        super.updateTick(world, x, y, z, rand);
    }
    
    private boolean IsNeighbourSource(final World world, final int x, final int y, final int z) {
        return world.getBlock(x, y, z) == this && world.getBlockMetadata(x, y, z) == 0;
    }
    
    public void onBlockAdded(final World world, final int x, final int y, final int z) {
        super.onBlockAdded(world, x, y, z);
    }
    
    public void onNeighborBlockChange(final World world, final int x, final int y, final int z, final Block block) {
        super.onNeighborBlockChange(world, x, y, z, block);
    }
    
    @Override
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {			
		{
			if (!(entity instanceof EntityBlazingSerpentQueen)) {
				if (!(entity instanceof EntityBlazingSerpent)) {
				{
				if (!(entity instanceof EntitySavageSerpent)) {
				{
			if (!entity.isImmuneToFire()) {
			entity.attackEntityFrom(DamageSource.magic, 6.0F);
			entity.attackEntityFrom(DamageSource.lava, 10.0F);
			entity.setFire(30);
			}
			else {
			entity.attackEntityFrom(DamageSource.magic, 8.0F);
			entity.attackEntityFrom(DamageSource.generic, 8.0F);
			entity.setFire(30);	
				 }
			   }
			 }
			}
	       }
		  }
		}
		
	}
    
    @Override
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
        double d1 = (double)((float)p_149734_3_ - 1.0F);
        double d2 = (double)((float)p_149734_4_ + 0.5F + (p_149734_5_.nextFloat()) - (p_149734_5_.nextFloat()));
        double d3 = 0.2199999988079071D;
        double d4 = 0.27000001072883606D;    

        if (l == 1)
        {
        	ParticleHandler.BLAZFLAME.spawn(p_149734_1_, d0 - d4, d1 + d3, d2, 0.0D, 0.12D, 0.0D, 0.0f, new Object[0]);        	
        }
        else if (l == 2)
        {
        	ParticleHandler.BLAZFLAME.spawn(p_149734_1_, d0 - d4, d1 + d3, d2, 0.0D, 0.12D, 0.0D, 0.0f, new Object[0]);
        }
        else if (l == 3)
        {
        	ParticleHandler.BLAZFLAME.spawn(p_149734_1_, d0 - d4, d1 + d3, d2, 0.0D, 0.12D, 0.0D, 0.0f, new Object[0]);
        }
        else if (l == 4)
        {
        	ParticleHandler.BLAZFLAME.spawn(p_149734_1_, d0 - d4, d1 + d3, d2, 0.0D, 0.12D, 0.0D, 0.0f, new Object[0]);
        }
        else
        {
        	ParticleHandler.BLAZFLAME.spawn(p_149734_1_, d0 - d4, d1 + d3, d2, 0.0D, 0.12D, 0.0D, 0.0f, new Object[0]);
        }
    }
    
    @SideOnly(Side.CLIENT)
    protected void playEffects(final World world, final int x, final int y, final int z) {
        world.playSoundEffect((double)(x + 0.5f), (double)(y + 0.5f), (double)(z + 0.5f), "random.fizz", 0.5f, 2.6f + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8f);
        for (int l = 0; l < 8; ++l) {
            world.spawnParticle("largesmoke", x + Math.random(), y + 1.2, z + Math.random(), 0.0, 0.0, 0.0);
        }
    }
}
