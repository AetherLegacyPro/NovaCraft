package com.NovaCraftBlocks.plants.end;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.Random;

import com.NovaCraft.particles.ParticleHandler;
import com.NovaCraft.renderer.RenderIDs;
import com.NovaCraft.sounds.ModSounds;
import com.NovaCraftBlocks.special.IEmissiveLayerBlock;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockEnderFungusStem extends Block implements IEmissiveLayerBlock {

	public static final int[] colors = new int[]{0x9500ff};
	private IIcon infusedOverlay;
    private IIcon[] icon;
	
	public BlockEnderFungusStem() {
		super(Material.grass);
		this.icon = new IIcon[2];
		this.setTickRandomly(true);
		this.setHardness(1.2F);
		this.setResistance(0.65F);
		this.setStepSound(ModSounds.soundMoss);
		this.setHarvestLevel("axe", 0);
		this.setBlockBounds(0.3F, 0.0F, 0.3F, 0.7F, 1.0F, 0.7F);
	}
	
	protected boolean canSilkHarvest() {
	    return true;
	 }
		
 	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
	  {
	    return null;
	  }
	
	public void registerBlockIcons(final IIconRegister iconRegister) {
        this.icon[0] = iconRegister.registerIcon("nova_craft:ender_fungus_block");
        this.icon[1] = iconRegister.registerIcon("nova_craft:ender_fungus_block");
        infusedOverlay = iconRegister.registerIcon("nova_craft:ender_fungus_block_overlay");
    }
    
    public IIcon getIcon(final int side, final int meta) {
    	return this.icon[0];
    }
    
    @Override
    public int getRenderType() {
    	return RenderIDs.EMISSIVE_DOUBLE_LAYER_3D;
    }
    
    @Override
	public IIcon getSecondLayerIcon(int side, int meta) {
			return infusedOverlay;
	}

	@Override
	public int getEmissiveMinBrightness(int meta) {
		return 12;
	}
	
	@Override
	public int getEmissiveLayerColor(int meta) {
		return colors[meta % colors.length];
	}
	
	@Override
	public boolean doesEmissiveLayerHaveDirShading(int meta) {
		return false;
	}
	
	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
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
        double d1 = (double)((float)p_149734_3_ - 1.0F);
        double d2 = (double)((float)p_149734_4_ + 0.5F + (p_149734_5_.nextFloat()) - (p_149734_5_.nextFloat()));
        double d3 = 0.2199999988079071D;
        double d4 = 0.27000001072883606D;

        if (l == 1)
        {
        	ParticleHandler.ENDER.spawn(p_149734_1_, d0 - d4, d1 + d3, d2, 0.0D, 0.12D, 0.0D, 0.0f, new Object[0]);
        }
        else if (l == 2)
        {
        	ParticleHandler.ENDER.spawn(p_149734_1_, d0 - d4, d1 + d3, d2, 0.0D, 0.12D, 0.0D, 0.0f, new Object[0]);
        }
        else if (l == 3)
        {
        	ParticleHandler.ENDER.spawn(p_149734_1_, d0 - d4, d1 + d3, d2, 0.0D, 0.12D, 0.0D, 0.0f, new Object[0]);
        }
        else if (l == 4)
        {
        	ParticleHandler.ENDER.spawn(p_149734_1_, d0 - d4, d1 + d3, d2, 0.0D, 0.12D, 0.0D, 0.0f, new Object[0]);
        }
        else
        {
        	ParticleHandler.ENDER.spawn(p_149734_1_, d0 - d4, d1 + d3, d2, 0.0D, 0.12D, 0.0D, 0.0f, new Object[0]);
        }
    }


}
