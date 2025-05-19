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

public class BlockGrimstoneShrieker extends Block {

	@SideOnly(Side.CLIENT)
	private IIcon iconFace, iconTop;
	
	public BlockGrimstoneShrieker() {
		super(Material.rock);
		this.setBlockUnbreakable();
		this.setResistance(600000000);
		this.setStepSound(ModSounds.soundGrimstone);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta){
		return side == 0 || side == 1 ? iconTop : meta >= 1 && side-1 == meta ? iconFace : blockIcon;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister){
		blockIcon = iconRegister.registerIcon("nova_craft:warden_altar_side");
		iconFace = iconRegister.registerIcon("nova_craft:warden_altar_top");
		iconTop = iconRegister.registerIcon("nova_craft:warden_altar_top");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int x, int y, int z, Random random) {
			float f = (float) x + 0.5F;
			float f1 = (float) y + 1.0F + (random.nextFloat() * 6F) / 16F;
			float f2 = (float) z + 0.5F;

			world.spawnParticle("smoke", f, f1, f2, 0.0D, 0.0D, 0.0D);
			world.spawnParticle("townaura", f, f1, f2, 0.0D, 0.0D, 0.0D);
			world.spawnParticle("townaura", f, f1, f2, 0.1D, 0.0D, 0.1D);
			world.spawnParticle("townaura", f, f1, f2, -0.1D, 0.0D, -0.1D);
			world.spawnParticle("townaura", f, f1, f2, -0.1D, 0.0D, 0.1D);
			world.spawnParticle("townaura", f, f1, f2, 0.1D, 0.0D, -0.1D);
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		
    	Block block = world.getBlock(x, y, z);
		int meta = world.getBlockMetadata(x, y, z);
		
		ItemStack stack = player.inventory.getCurrentItem();
        if (stack != null && stack.getItem() != null && stack.getItem() != NovaCraftItems.sculk_star) {
        	 if (world.isRemote) {	
        	player.addChatComponentMessage(new ChatComponentText(I18n.format("gui.warden_altar")));
        	 }
        }
        
        return true;
	}
	

}
