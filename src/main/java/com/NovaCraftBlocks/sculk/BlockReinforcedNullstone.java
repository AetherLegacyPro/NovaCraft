package com.NovaCraftBlocks.sculk;

import java.util.Random;

import com.NovaCraft.NovaCraft;
import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.TileEntity.TileEntityAncientChest;
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

public class BlockReinforcedNullstone extends Block {

	@SideOnly(Side.CLIENT)
	private IIcon iconTop;
	private IIcon blockIconBottom;
	private IIcon blockIconTop;
	
	public BlockReinforcedNullstone() {
		super(Material.rock);
		this.setBlockUnbreakable();
		this.setResistance(10000000);
		this.setStepSound(ModSounds.soundNullstoneBricks);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister registry) {
		this.blockIcon = registry.registerIcon("nova_craft:reinforced_nullstone_side");
		this.blockIconTop = registry.registerIcon("nova_craft:reinforced_nullstone_top");
		this.blockIconBottom = registry.registerIcon("nova_craft:reinforced_nullstone_top");
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
	
	public boolean onBlockActivated(final World world, final int x, final int y, final int z, final EntityPlayer par5EntityPlayer, final int par6, final float par7, final float par8, final float par9) {
	      if (world.isRemote) {
	          return true;
	      }
	      int meta = world.getBlockMetadata(x, y, z);
	      ItemStack stack = par5EntityPlayer.inventory.getCurrentItem();
	      if (stack != null && stack.getItem() != null && stack.getItem() == NovaCraftItems.static_blend) {
	    	  --stack.stackSize;
	    	  world.playSoundEffect(x, y, z, "nova_craft:blend.use", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
	    	  world.setBlock(x, y, z, NovaCraftBlocks.activated_reinforced_nullstone, 0, 2);
	      }
	      else {
	    	  par5EntityPlayer.addChatComponentMessage(new ChatComponentText(I18n.format("gui.reinforced_nullstone")));
	      }
	      return true;
	  }

}
