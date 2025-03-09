package com.NovaCraft.Items;

import com.NovaCraft.achievements.AchievementsNovaCraft;
import com.NovaCraft.entity.EntityFireProofItemNovaCraft;
import com.NovaCraft.entity.EntityPrisoner;
import com.NovaCraft.registry.NovaCraftCreativeTabs;
import com.NovaCraftBlocks.NovaCraftBlocks;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class ItemWardenCore extends Item {
	
	private IIcon[] icon;

	public ItemWardenCore() {
		this.icon = new IIcon[1];
		maxStackSize = 1;
        this.setCreativeTab(NovaCraftCreativeTabs.items);
    }
	
	public void registerBlockIcons(final IIconRegister iconRegister) {
        this.icon[0] = iconRegister.registerIcon("nova_craft:warden_core");
    }
	
	public IIcon getIcon(final int side, int meta) {
        if (meta < 0 || meta >= this.icon.length) {
            meta = 1;
        }
        return this.icon[meta];
    }
	
	@Override
	public boolean hasEffect(ItemStack stack, int pass) {
		return true;
	}
	
	public Entity createEntity(final World world, final Entity location, final ItemStack itemstack) {
        return (Entity)new EntityFireProofItemNovaCraft(world, location, itemstack);
    }
	
	@Override
	public boolean onItemUse(ItemStack heldItem, EntityPlayer player, World world, int x, int y, int z, int facing, float hitX, float hitY, float hitZ) {
		Block block = world.getBlock(x, y, z);
		int meta = world.getBlockMetadata(x, y, z);
			
		if (world.getBlock(x, y, z) == NovaCraftBlocks.unknown_portal_activator
				//Blocks directly surrounding the activator
				&& world.getBlock(x, y - 1, z) == NovaCraftBlocks.activated_reinforced_nullstone
				&& world.getBlock(x, y - 1, z + 1) == NovaCraftBlocks.activated_reinforced_nullstone
				&& world.getBlock(x, y - 1, z - 1) == NovaCraftBlocks.activated_reinforced_nullstone
				&& world.getBlock(x + 1, y - 1, z) == NovaCraftBlocks.activated_reinforced_nullstone
				&& world.getBlock(x - 1, y - 1, z) == NovaCraftBlocks.activated_reinforced_nullstone
				&& world.getBlock(x + 1, y - 1, z + 1) == NovaCraftBlocks.activated_reinforced_nullstone
				&& world.getBlock(x + 1, y - 1, z - 1) == NovaCraftBlocks.activated_reinforced_nullstone
				&& world.getBlock(x - 1, y - 1, z + 1) == NovaCraftBlocks.activated_reinforced_nullstone
				&& world.getBlock(x - 1, y - 1, z - 1) == NovaCraftBlocks.activated_reinforced_nullstone
				
				&& world.getBlock(x - 2, y - 2, z) == NovaCraftBlocks.activated_reinforced_nullstone
				&& world.getBlock(x - 3, y - 2, z) == NovaCraftBlocks.activated_reinforced_nullstone
				
				//Bottom Portal Part
				&& world.getBlock(x - 3, y - 2, z + 1) == NovaCraftBlocks.activated_reinforced_nullstone
				&& world.getBlock(x - 3, y - 2, z + 2) == NovaCraftBlocks.activated_reinforced_nullstone
				&& world.getBlock(x - 3, y - 2, z + 3) == NovaCraftBlocks.activated_reinforced_nullstone
				&& world.getBlock(x - 3, y - 2, z + 4) == NovaCraftBlocks.activated_reinforced_nullstone
				&& world.getBlock(x - 3, y - 2, z + 5) == NovaCraftBlocks.activated_reinforced_nullstone
				&& world.getBlock(x - 3, y - 2, z + 6) == NovaCraftBlocks.activated_reinforced_nullstone
				&& world.getBlock(x - 3, y - 2, z + 7) == NovaCraftBlocks.activated_reinforced_nullstone
				&& world.getBlock(x - 3, y - 2, z + 8) == NovaCraftBlocks.activated_reinforced_nullstone
				&& world.getBlock(x - 3, y - 2, z + 9) == NovaCraftBlocks.activated_reinforced_nullstone
				&& world.getBlock(x - 3, y - 2, z + 10) == NovaCraftBlocks.activated_reinforced_nullstone
				&& world.getBlock(x - 3, y - 2, z + 11) == NovaCraftBlocks.activated_reinforced_nullstone
				
				&& world.getBlock(x - 3, y - 2, z - 1) == NovaCraftBlocks.activated_reinforced_nullstone
				&& world.getBlock(x - 3, y - 2, z - 2) == NovaCraftBlocks.activated_reinforced_nullstone
				&& world.getBlock(x - 3, y - 2, z - 3) == NovaCraftBlocks.activated_reinforced_nullstone
				&& world.getBlock(x - 3, y - 2, z - 4) == NovaCraftBlocks.activated_reinforced_nullstone
				&& world.getBlock(x - 3, y - 2, z - 5) == NovaCraftBlocks.activated_reinforced_nullstone
				&& world.getBlock(x - 3, y - 2, z - 6) == NovaCraftBlocks.activated_reinforced_nullstone
				&& world.getBlock(x - 3, y - 2, z - 7) == NovaCraftBlocks.activated_reinforced_nullstone
				&& world.getBlock(x - 3, y - 2, z - 8) == NovaCraftBlocks.activated_reinforced_nullstone
				&& world.getBlock(x - 3, y - 2, z - 9) == NovaCraftBlocks.activated_reinforced_nullstone
				&& world.getBlock(x - 3, y - 2, z - 10) == NovaCraftBlocks.activated_reinforced_nullstone
				
				//+Z Side Portal Part
				&& world.getBlock(x - 3, y - 1, z + 11) == NovaCraftBlocks.activated_reinforced_nullstone
				&& world.getBlock(x - 3, y, z + 11) == NovaCraftBlocks.activated_reinforced_nullstone
				&& world.getBlock(x - 3, y + 1, z + 11) == NovaCraftBlocks.activated_reinforced_nullstone
				&& world.getBlock(x - 3, y + 2, z + 11) == NovaCraftBlocks.activated_reinforced_nullstone
				&& world.getBlock(x - 3, y + 3, z + 11) == NovaCraftBlocks.activated_reinforced_nullstone
				&& world.getBlock(x - 3, y + 4, z + 11) == NovaCraftBlocks.activated_reinforced_nullstone
				&& world.getBlock(x - 3, y + 5, z + 11) == NovaCraftBlocks.activated_reinforced_nullstone
			
				//-Z Side Portal Part
				&& world.getBlock(x - 3, y - 1, z - 10) == NovaCraftBlocks.activated_reinforced_nullstone
				&& world.getBlock(x - 3, y, z - 10) == NovaCraftBlocks.activated_reinforced_nullstone
				&& world.getBlock(x - 3, y + 1, z - 10) == NovaCraftBlocks.activated_reinforced_nullstone
				&& world.getBlock(x - 3, y + 2, z - 10) == NovaCraftBlocks.activated_reinforced_nullstone
				&& world.getBlock(x - 3, y + 3, z - 10) == NovaCraftBlocks.activated_reinforced_nullstone
				&& world.getBlock(x - 3, y + 4, z - 10) == NovaCraftBlocks.activated_reinforced_nullstone
				&& world.getBlock(x - 3, y + 5, z - 10) == NovaCraftBlocks.activated_reinforced_nullstone
				
				//Top Portal Part
				&& world.getBlock(x - 3, y + 5, z) == NovaCraftBlocks.activated_reinforced_nullstone
				&& world.getBlock(x - 3, y + 5, z + 1) == NovaCraftBlocks.activated_reinforced_nullstone
				&& world.getBlock(x - 3, y + 5, z + 2) == NovaCraftBlocks.activated_reinforced_nullstone
				&& world.getBlock(x - 3, y + 5, z + 3) == NovaCraftBlocks.activated_reinforced_nullstone
				&& world.getBlock(x - 3, y + 5, z + 4) == NovaCraftBlocks.activated_reinforced_nullstone
				&& world.getBlock(x - 3, y + 5, z + 5) == NovaCraftBlocks.activated_reinforced_nullstone
				&& world.getBlock(x - 3, y + 5, z + 6) == NovaCraftBlocks.activated_reinforced_nullstone
				&& world.getBlock(x - 3, y + 5, z + 7) == NovaCraftBlocks.activated_reinforced_nullstone
				&& world.getBlock(x - 3, y + 5, z + 8) == NovaCraftBlocks.activated_reinforced_nullstone
				&& world.getBlock(x - 3, y + 5, z + 9) == NovaCraftBlocks.activated_reinforced_nullstone
				&& world.getBlock(x - 3, y + 5, z + 10) == NovaCraftBlocks.activated_reinforced_nullstone
				
				&& world.getBlock(x - 3, y + 5, z - 1) == NovaCraftBlocks.activated_reinforced_nullstone
				&& world.getBlock(x - 3, y + 5, z - 2) == NovaCraftBlocks.activated_reinforced_nullstone
				&& world.getBlock(x - 3, y + 5, z - 3) == NovaCraftBlocks.activated_reinforced_nullstone
				&& world.getBlock(x - 3, y + 5, z - 4) == NovaCraftBlocks.activated_reinforced_nullstone
				&& world.getBlock(x - 3, y + 5, z - 5) == NovaCraftBlocks.activated_reinforced_nullstone
				&& world.getBlock(x - 3, y + 5, z - 6) == NovaCraftBlocks.activated_reinforced_nullstone
				&& world.getBlock(x - 3, y + 5, z - 7) == NovaCraftBlocks.activated_reinforced_nullstone
				&& world.getBlock(x - 3, y + 5, z - 8) == NovaCraftBlocks.activated_reinforced_nullstone
				&& world.getBlock(x - 3, y + 5, z - 9) == NovaCraftBlocks.activated_reinforced_nullstone
				&& world.getBlock(x - 3, y + 5, z - 10) == NovaCraftBlocks.activated_reinforced_nullstone
				
				) {

			world.setBlock(x - 3, y - 1, z, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y - 1, z + 1, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y - 1, z + 2, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y - 1, z + 3, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y - 1, z + 4, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y - 1, z + 5, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y - 1, z + 6, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y - 1, z + 7, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y - 1, z + 8, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y - 1, z + 9, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y - 1, z + 10, NovaCraftBlocks.unknown_portal);			
			world.setBlock(x - 3, y - 1, z - 1, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y - 1, z - 2, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y - 1, z - 3, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y - 1, z - 4, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y - 1, z - 5, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y - 1, z - 6, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y - 1, z - 7, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y - 1, z - 8, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y - 1, z - 9, NovaCraftBlocks.unknown_portal);
			
			world.setBlock(x - 3, y, z, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y, z + 1, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y, z + 2, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y, z + 3, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y, z + 4, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y, z + 5, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y, z + 6, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y, z + 7, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y, z + 8, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y, z + 9, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y, z + 10, NovaCraftBlocks.unknown_portal);			
			world.setBlock(x - 3, y, z - 1, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y, z - 2, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y, z - 3, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y, z - 4, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y, z - 5, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y, z - 6, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y, z - 7, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y, z - 8, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y, z - 9, NovaCraftBlocks.unknown_portal);
			
			world.setBlock(x - 3, y + 1, z, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y + 1, z + 1, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y + 1, z + 2, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y + 1, z + 3, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y + 1, z + 4, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y + 1, z + 5, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y + 1, z + 6, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y + 1, z + 7, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y + 1, z + 8, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y + 1, z + 9, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y + 1, z + 10, NovaCraftBlocks.unknown_portal);			
			world.setBlock(x - 3, y + 1, z - 1, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y + 1, z - 2, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y + 1, z - 3, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y + 1, z - 4, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y + 1, z - 5, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y + 1, z - 6, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y + 1, z - 7, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y + 1, z - 8, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y + 1, z - 9, NovaCraftBlocks.unknown_portal);
			
			world.setBlock(x - 3, y + 2, z, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y + 2, z + 1, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y + 2, z + 2, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y + 2, z + 3, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y + 2, z + 4, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y + 2, z + 5, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y + 2, z + 6, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y + 2, z + 7, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y + 2, z + 8, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y + 2, z + 9, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y + 2, z + 10, NovaCraftBlocks.unknown_portal);			
			world.setBlock(x - 3, y + 2, z - 1, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y + 2, z - 2, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y + 2, z - 3, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y + 2, z - 4, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y + 2, z - 5, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y + 2, z - 6, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y + 2, z - 7, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y + 2, z - 8, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y + 2, z - 9, NovaCraftBlocks.unknown_portal);
			
			world.setBlock(x - 3, y + 3, z, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y + 3, z + 1, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y + 3, z + 2, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y + 3, z + 3, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y + 3, z + 4, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y + 3, z + 5, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y + 3, z + 6, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y + 3, z + 7, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y + 3, z + 8, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y + 3, z + 9, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y + 3, z + 10, NovaCraftBlocks.unknown_portal);			
			world.setBlock(x - 3, y + 3, z - 1, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y + 3, z - 2, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y + 3, z - 3, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y + 3, z - 4, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y + 3, z - 5, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y + 3, z - 6, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y + 3, z - 7, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y + 3, z - 8, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y + 3, z - 9, NovaCraftBlocks.unknown_portal);
			
			world.setBlock(x - 3, y + 4, z, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y + 4, z + 1, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y + 4, z + 2, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y + 4, z + 3, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y + 4, z + 4, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y + 4, z + 5, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y + 4, z + 6, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y + 4, z + 7, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y + 4, z + 8, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y + 4, z + 9, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y + 4, z + 10, NovaCraftBlocks.unknown_portal);			
			world.setBlock(x - 3, y + 4, z - 1, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y + 4, z - 2, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y + 4, z - 3, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y + 4, z - 4, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y + 4, z - 5, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y + 4, z - 6, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y + 4, z - 7, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y + 4, z - 8, NovaCraftBlocks.unknown_portal);
			world.setBlock(x - 3, y + 4, z - 9, NovaCraftBlocks.unknown_portal);
			
			if(!world.isRemote) {
			EntityPrisoner prisoner = new EntityPrisoner(world);
				if (!player.capabilities.isCreativeMode) {
					prisoner.setAttackTarget(player);
				}
			prisoner.setPosition((double) x - 2.5D, (double) y + 1.5D, (double) z + 1D);
			world.spawnEntityInWorld(prisoner);
			
			 }
							
			world.playSoundEffect(x, y, z, "nova_craft:unknown.ignite", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
			player.addChatComponentMessage(new ChatComponentText(I18n.format("gui.unknown_portal_activated")));
			
			world.setBlock(x, y, z, NovaCraftBlocks.activated_unknown_portal_activator);
			--heldItem.stackSize;		
		 }
		return true;
	}
	
}
