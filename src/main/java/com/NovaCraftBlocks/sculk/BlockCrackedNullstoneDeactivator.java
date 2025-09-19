package com.NovaCraftBlocks.sculk;

import java.util.Random;

import com.NovaCraft.NovaCraft;
import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.sounds.ModSounds;
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

public class BlockCrackedNullstoneDeactivator extends Block {

	@SideOnly(Side.CLIENT)
	private IIcon iconFace, iconTop;
	
	public BlockCrackedNullstoneDeactivator() {
		super(Material.rock);
		this.setBlockUnbreakable();
		this.setResistance(10000000);
		this.setStepSound(ModSounds.soundNullstoneBricks);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta){
		return side == 0 || side == 1 ? iconTop : meta >= 1 && side-1 == meta ? iconFace : blockIcon;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister){
		blockIcon = iconRegister.registerIcon("nova_craft:cracked_nullstone_deactivator");
		iconFace = iconRegister.registerIcon("nova_craft:cracked_nullstone_deactivator");
		iconTop = iconRegister.registerIcon("nova_craft:cracked_nullstone_deactivator");
	}
	
	public boolean onBlockActivated(final World world, final int x, final int y, final int z, final EntityPlayer par5EntityPlayer, final int par6, final float par7, final float par8, final float par9) {
	      int meta = world.getBlockMetadata(x, y, z);
	      ItemStack stack = par5EntityPlayer.inventory.getCurrentItem();
	      if (stack != null && stack.getItem() != null && stack.getItem() != NovaCraftItems.dimensional_sealent) {
	    	  if (world.isRemote) {
	    	  par5EntityPlayer.addChatComponentMessage(new ChatComponentText(I18n.format("tooltip.nullstone_deactivator.desc")));
	    	  }
	      }
		
		return true;
	}

}
