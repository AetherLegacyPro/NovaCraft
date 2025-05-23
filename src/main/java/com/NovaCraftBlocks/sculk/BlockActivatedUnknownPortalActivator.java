package com.NovaCraftBlocks.sculk;

import java.util.Random;

import com.NovaCraft.NovaCraft;
import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.TileEntity.TileEntityAncientChest;
import com.NovaCraft.particles.ParticleHandler;
import com.NovaCraft.sounds.ModSounds;
import com.NovaCraftBlocks.NovaCraftBlocks;
import com.ibm.icu.impl.duration.impl.Utils;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockActivatedUnknownPortalActivator extends Block {

	@SideOnly(Side.CLIENT)
	private IIcon iconTop;
	private IIcon blockIconBottom;
	private IIcon blockIconTop;
	
	public BlockActivatedUnknownPortalActivator() {
		super(Material.rock);
		this.setBlockUnbreakable();
		this.setResistance(10000000);
		this.setStepSound(ModSounds.soundNullstoneBricks);
		this.setLightLevel(0.975F);
		this.setTickRandomly(true);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister registry) {
		this.blockIcon = registry.registerIcon("nova_craft:unknown_portal_activator_side");
		this.blockIconTop = registry.registerIcon("nova_craft:unknown_portal_activator_top");
		this.blockIconBottom = registry.registerIcon("nova_craft:unknown_portal_activator_top");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		return side == 1 ? this.blockIconTop : (side == 0 ? this.blockIconBottom : this.blockIcon);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(IBlockAccess world, int x, int y, int z, int side) {
		if (side == 1) {
			return this.blockIconTop;
		} else if (side == 0) {
			return this.blockIconBottom;
		}

		return this.blockIcon;
	}
	
	@SideOnly(Side.CLIENT)
    public void randomDisplayTick(final World p_149734_1_, final int p_149734_2_, final int p_149734_3_, final int p_149734_4_, final Random p_149734_5_) {
        final int l = p_149734_1_.getBlockMetadata(p_149734_2_, p_149734_3_, p_149734_4_);
        final double d0 = p_149734_2_ + 0.51f;
        final double d2 = p_149734_3_ + 1.07f;
        final double d3 = p_149734_4_ + 0.55f;
        final double d4 = 0.0199999988079071;
        final double d5 = 0.07000001072883606;
        
        final double d6x = p_149734_2_ + 0.51f;
        final double d7y = p_149734_3_ - 0.03f;
        final double d8z = p_149734_4_ + 0.55f;
        
        final double d9x = p_149734_2_ + 1.07f;
        final double d10y = p_149734_3_ + 0.55f;
        final double d11z = p_149734_4_ + 0.55f;
        
        final double d12x = p_149734_2_ - 0.03f;
        final double d13y = p_149734_3_ + 0.55f;
        final double d14z = p_149734_4_ + 0.55f;
        
        final double d15x = p_149734_2_ + 0.51f;
        final double d16y = p_149734_3_ + 0.55f;
        final double d17z = p_149734_4_ - 0.03f;
        
        final double d18x = p_149734_2_ + 0.51f;
        final double d19y = p_149734_3_ + 0.55f;
        final double d20z = p_149734_4_ + 1.03f;
        
        if (l == 1) {
        	ParticleHandler.IONFLAMEHUGE.spawn(p_149734_1_, d0 - d5, d2 + d4, d3, 0.0, 0.0, 0.0, 0.0f, new Object[0]);
        	ParticleHandler.IONFLAMEHUGE.spawn(p_149734_1_, d6x - d5, d7y - d4, d8z, 0.0, 0.0, 0.0, 0.0f, new Object[0]);
        	
        	ParticleHandler.IONFLAMEHUGE.spawn(p_149734_1_, d9x - d5, d10y + d4, d11z, 0.0, 0.0, 0.0, 0.0f, new Object[0]);
        	ParticleHandler.IONFLAMEHUGE.spawn(p_149734_1_, d12x + d5, d13y + d4, d14z, 0.0, 0.0, 0.0, 0.0f, new Object[0]);
        	
        	ParticleHandler.IONFLAMEHUGE.spawn(p_149734_1_, d15x - d5, d16y + d4, d17z, 0.0, 0.0, 0.0, 0.0f, new Object[0]);
        	ParticleHandler.IONFLAMEHUGE.spawn(p_149734_1_, d18x - d5, d19y + d4, d20z, 0.0, 0.0, 0.0, 0.0f, new Object[0]);
        }
        else if (l == 2) {
            ParticleHandler.IONFLAMEHUGE.spawn(p_149734_1_, d0 + d5, d2 + d4, d3, 0.0, 0.0, 0.0, 0.0f, new Object[0]);
            ParticleHandler.IONFLAMEHUGE.spawn(p_149734_1_, d6x + d5, d7y - d4, d8z, 0.0, 0.0, 0.0, 0.0f, new Object[0]);
            
            ParticleHandler.IONFLAMEHUGE.spawn(p_149734_1_, d9x + d5, d10y + d4, d11z, 0.0, 0.0, 0.0, 0.0f, new Object[0]);
            ParticleHandler.IONFLAMEHUGE.spawn(p_149734_1_, d12x - d5, d13y + d4, d14z, 0.0, 0.0, 0.0, 0.0f, new Object[0]);
            
            ParticleHandler.IONFLAMEHUGE.spawn(p_149734_1_, d15x + d5, d16y + d4, d17z, 0.0, 0.0, 0.0, 0.0f, new Object[0]);
            ParticleHandler.IONFLAMEHUGE.spawn(p_149734_1_, d18x + d5, d19y + d4, d20z, 0.0, 0.0, 0.0, 0.0f, new Object[0]);
        }
        else if (l == 3) {
            ParticleHandler.IONFLAMEHUGE.spawn(p_149734_1_, d0, d2 + d4, d3 - d5, 0.0, 0.0, 0.0, 0.0f, new Object[0]);
            ParticleHandler.IONFLAMEHUGE.spawn(p_149734_1_, d6x, d7y - d4, d8z - d5, 0.0, 0.0, 0.0, 0.0f, new Object[0]);
            
            ParticleHandler.IONFLAMEHUGE.spawn(p_149734_1_, d9x, d10y + d4, d11z - d5, 0.0, 0.0, 0.0, 0.0f, new Object[0]);
            ParticleHandler.IONFLAMEHUGE.spawn(p_149734_1_, d12x, d13y + d4, d14z - d5, 0.0, 0.0, 0.0, 0.0f, new Object[0]);
            
            ParticleHandler.IONFLAMEHUGE.spawn(p_149734_1_, d15x, d16y + d4, d17z - d5, 0.0, 0.0, 0.0, 0.0f, new Object[0]);
            ParticleHandler.IONFLAMEHUGE.spawn(p_149734_1_, d18x, d19y + d4, d20z - d5, 0.0, 0.0, 0.0, 0.0f, new Object[0]);
        }
        else if (l == 4) {
            ParticleHandler.IONFLAMEHUGE.spawn(p_149734_1_, d0, d2 + d4, d3 + d5, 0.0, 0.0, 0.0, 0.0f, new Object[0]);
            ParticleHandler.IONFLAMEHUGE.spawn(p_149734_1_, d6x, d7y - d4, d8z + d5, 0.0, 0.0, 0.0, 0.0f, new Object[0]);
            
            ParticleHandler.IONFLAMEHUGE.spawn(p_149734_1_, d9x, d10y + d4, d11z + d5, 0.0, 0.0, 0.0, 0.0f, new Object[0]);
            ParticleHandler.IONFLAMEHUGE.spawn(p_149734_1_, d12x, d13y + d4, d14z - d5, 0.0, 0.0, 0.0, 0.0f, new Object[0]);
            
            ParticleHandler.IONFLAMEHUGE.spawn(p_149734_1_, d15x, d16y + d4, d17z + d5, 0.0, 0.0, 0.0, 0.0f, new Object[0]);
            ParticleHandler.IONFLAMEHUGE.spawn(p_149734_1_, d18x, d19y + d4, d20z + d5, 0.0, 0.0, 0.0, 0.0f, new Object[0]);
        }
        else {
            ParticleHandler.IONFLAMEHUGE.spawn(p_149734_1_, d0, d2, d3, 0.0, 0.0, 0.0, 0.0f, new Object[0]);
            ParticleHandler.IONFLAMEHUGE.spawn(p_149734_1_, d6x, d7y, d8z, 0.0, 0.0, 0.0, 0.0f, new Object[0]);
            ParticleHandler.IONFLAMEHUGE.spawn(p_149734_1_, d9x, d10y, d11z, 0.0, 0.0, 0.0, 0.0f, new Object[0]);
            ParticleHandler.IONFLAMEHUGE.spawn(p_149734_1_, d12x, d13y, d14z, 0.0, 0.0, 0.0, 0.0f, new Object[0]);
            ParticleHandler.IONFLAMEHUGE.spawn(p_149734_1_, d15x, d16y, d17z, 0.0, 0.0, 0.0, 0.0f, new Object[0]);
            ParticleHandler.IONFLAMEHUGE.spawn(p_149734_1_, d18x, d19y, d20z, 0.0, 0.0, 0.0, 0.0f, new Object[0]);
        }
    }
	
	public boolean onBlockActivated(final World world, final int x, final int y, final int z, final EntityPlayer par5EntityPlayer, final int par6, final float par7, final float par8, final float par9) {
		
	      int meta = world.getBlockMetadata(x, y, z);
	      ItemStack stack = par5EntityPlayer.inventory.getCurrentItem();
	      if (stack != null && stack.getItem() != null && stack.getItem() != NovaCraftItems.dimensional_sealent) {
	    	  if (world.isRemote) {
	    	  par5EntityPlayer.addChatComponentMessage(new ChatComponentText(I18n.format("tooltip.activated_unknown_portal_activator.desc")));
	    	  }
	      }
	    	  
		
		return true;
	}

}
