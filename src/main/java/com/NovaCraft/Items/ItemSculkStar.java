package com.NovaCraft.Items;

import com.NovaCraft.achievements.AchievementsNovaCraft;
import com.NovaCraft.entity.EntityFireProofItemNovaCraft;
import com.NovaCraft.registry.NovaCraftCreativeTabs;
import com.NovaCraftBlocks.NovaCraftBlocks;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class ItemSculkStar extends Item {
	
	private IIcon[] icon;

	public ItemSculkStar() {
		this.icon = new IIcon[1];
		maxStackSize = 1;
        this.setCreativeTab(NovaCraftCreativeTabs.items);
    }
	
	public void registerBlockIcons(final IIconRegister iconRegister) {
        this.icon[0] = iconRegister.registerIcon("nova_craft:NewSculkStar");
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
		
		if ((world.getBlock(x, y, z) == NovaCraftBlocks.grimstone_shrieker)
			
			&& (world.getBlock(x + 1, y - 1, z) == NovaCraftBlocks.sculk_bricks)
			&& (world.getBlock(x - 1, y - 1, z) == NovaCraftBlocks.sculk_bricks)
			&& (world.getBlock(x, y - 1, z - 1) == NovaCraftBlocks.sculk_bricks)
			&& (world.getBlock(x, y - 1, z + 1) == NovaCraftBlocks.sculk_bricks)
			&& (world.getBlock(x + 1, y - 1, z - 1) == NovaCraftBlocks.sculk_bricks)
			&& (world.getBlock(x + 1, y - 1, z + 1) == NovaCraftBlocks.sculk_bricks)
			&& (world.getBlock(x - 1, y - 1, z + 1) == NovaCraftBlocks.sculk_bricks)
			&& (world.getBlock(x - 1, y - 1, z + 1) == NovaCraftBlocks.sculk_bricks)
						
			&& (world.getBlock(x + 2, y - 1, z) == NovaCraftBlocks.budding_echo_block)
			&& (world.getBlock(x + 2, y - 1, z + 1) == NovaCraftBlocks.budding_echo_block)
			&& (world.getBlock(x + 2, y - 1, z - 1) == NovaCraftBlocks.budding_echo_block)						
			&& (world.getBlock(x - 2, y - 1, z) == NovaCraftBlocks.budding_echo_block)
			&& (world.getBlock(x - 2, y - 1, z + 1) == NovaCraftBlocks.budding_echo_block)
			&& (world.getBlock(x - 2, y - 1, z - 1) == NovaCraftBlocks.budding_echo_block)			
			&& (world.getBlock(x, y - 1, z - 2) == NovaCraftBlocks.budding_echo_block)
			&& (world.getBlock(x + 1, y - 1, z - 2) == NovaCraftBlocks.budding_echo_block)
			&& (world.getBlock(x - 1, y - 1, z - 2) == NovaCraftBlocks.budding_echo_block)									
			&& (world.getBlock(x, y - 1, z + 2) == NovaCraftBlocks.budding_echo_block)
			&& (world.getBlock(x + 1, y - 1, z + 2) == NovaCraftBlocks.budding_echo_block)
			&& (world.getBlock(x - 1, y - 1, z + 2) == NovaCraftBlocks.budding_echo_block)
			
			&& (world.getBlock(x + 2, y, z) == NovaCraftBlocks.echo_cluster_2)
			&& (world.getBlock(x + 2, y, z + 1) == NovaCraftBlocks.echo_cluster_2)
			&& (world.getBlock(x + 2, y, z - 1) == NovaCraftBlocks.echo_cluster_2)						
			&& (world.getBlock(x - 2, y, z) == NovaCraftBlocks.echo_cluster_2)
			&& (world.getBlock(x - 2, y, z + 1) == NovaCraftBlocks.echo_cluster_2)
			&& (world.getBlock(x - 2, y, z - 1) == NovaCraftBlocks.echo_cluster_2)			
			&& (world.getBlock(x, y, z - 2) == NovaCraftBlocks.echo_cluster_2)
			&& (world.getBlock(x + 1, y, z - 2) == NovaCraftBlocks.echo_cluster_2)
			&& (world.getBlock(x - 1, y, z - 2) == NovaCraftBlocks.echo_cluster_2)									
			&& (world.getBlock(x, y, z + 2) == NovaCraftBlocks.echo_cluster_2)
			&& (world.getBlock(x + 1, y, z + 2) == NovaCraftBlocks.echo_cluster_2)
			&& (world.getBlock(x - 1, y, z + 2) == NovaCraftBlocks.echo_cluster_2)
			
			&& (world.getBlock(x + 2, y, z + 2) == NovaCraftBlocks.sculk_bricks)
			&& (world.getBlock(x - 2, y, z - 2) == NovaCraftBlocks.sculk_bricks)
			&& (world.getBlock(x + 2, y, z - 2) == NovaCraftBlocks.sculk_bricks)
			&& (world.getBlock(x - 2, y, z + 2) == NovaCraftBlocks.sculk_bricks)			
			&& (world.getBlock(x + 2, y + 1, z + 2) == NovaCraftBlocks.sculk_bricks)
			&& (world.getBlock(x - 2, y + 1, z - 2) == NovaCraftBlocks.sculk_bricks)
			&& (world.getBlock(x + 2, y + 1, z - 2) == NovaCraftBlocks.sculk_bricks)
			&& (world.getBlock(x - 2, y + 1, z + 2) == NovaCraftBlocks.sculk_bricks)
			
			&& (world.getBlock(x + 2, y + 2, z + 2) == NovaCraftBlocks.budding_null_block)
			&& (world.getBlock(x - 2, y + 2, z - 2) == NovaCraftBlocks.budding_null_block)
			&& (world.getBlock(x + 2, y + 2, z - 2) == NovaCraftBlocks.budding_null_block)
			&& (world.getBlock(x - 2, y + 2, z + 2) == NovaCraftBlocks.budding_null_block)
			
			&& (world.getBlock(x + 2, y + 3, z + 2) == NovaCraftBlocks.null_cluster_2)
			&& (world.getBlock(x + 2, y + 2, z + 3) == NovaCraftBlocks.null_cluster_2)
			&& (world.getBlock(x + 2, y + 2, z + 1) == NovaCraftBlocks.null_cluster_2)
			&& (world.getBlock(x + 1, y + 2, z + 2) == NovaCraftBlocks.null_cluster_2)
			&& (world.getBlock(x + 3, y + 2, z + 2) == NovaCraftBlocks.null_cluster_2)						
			&& (world.getBlock(x - 2, y + 3, z - 2) == NovaCraftBlocks.null_cluster_2)
			&& (world.getBlock(x - 2, y + 2, z - 3) == NovaCraftBlocks.null_cluster_2)
			&& (world.getBlock(x - 2, y + 2, z - 1) == NovaCraftBlocks.null_cluster_2)
			&& (world.getBlock(x - 3, y + 2, z - 2) == NovaCraftBlocks.null_cluster_2)
			&& (world.getBlock(x - 1, y + 2, z - 2) == NovaCraftBlocks.null_cluster_2)					
			&& (world.getBlock(x + 2, y + 3, z - 2) == NovaCraftBlocks.null_cluster_2)
			&& (world.getBlock(x + 2, y + 2, z - 3) == NovaCraftBlocks.null_cluster_2)
			&& (world.getBlock(x + 2, y + 2, z - 1) == NovaCraftBlocks.null_cluster_2)
			&& (world.getBlock(x + 1, y + 2, z - 2) == NovaCraftBlocks.null_cluster_2)
			&& (world.getBlock(x + 3, y + 2, z - 2) == NovaCraftBlocks.null_cluster_2)			
			&& (world.getBlock(x - 2, y + 3, z + 2) == NovaCraftBlocks.null_cluster_2)
			&& (world.getBlock(x - 2, y + 2, z + 3) == NovaCraftBlocks.null_cluster_2)
			&& (world.getBlock(x - 2, y + 2, z + 1) == NovaCraftBlocks.null_cluster_2)
			&& (world.getBlock(x - 1, y + 2, z + 2) == NovaCraftBlocks.null_cluster_2)
			&& (world.getBlock(x - 3, y + 2, z + 2) == NovaCraftBlocks.null_cluster_2)
			
			&& (world.getBlock(x + 4, y, z) == NovaCraftBlocks.infused_vanite_block)
			&& (world.getBlock(x - 4, y, z) == NovaCraftBlocks.infused_vanite_block)
			&& (world.getBlock(x, y, z - 4) == NovaCraftBlocks.infused_vanite_block)
			&& (world.getBlock(x, y, z + 4) == NovaCraftBlocks.infused_vanite_block)
			
			&& (world.getBlock(x + 4, y - 1, z) == NovaCraftBlocks.crystallized_end)
			&& (world.getBlock(x - 4, y - 1, z) == NovaCraftBlocks.crystallized_end)
			&& (world.getBlock(x, y - 1, z - 4) == NovaCraftBlocks.crystallized_end)
			&& (world.getBlock(x, y - 1, z + 4) == NovaCraftBlocks.crystallized_end)
			
			&& (world.getBlock(x + 3, y - 1, z) == NovaCraftBlocks.sculk_block)
			&& (world.getBlock(x + 3, y - 1, z + 1) == NovaCraftBlocks.sculk_block)
			&& (world.getBlock(x + 3, y - 1, z + 2) == NovaCraftBlocks.sculk_block)
			&& (world.getBlock(x + 3, y - 1, z - 1) == NovaCraftBlocks.sculk_block)
			&& (world.getBlock(x + 3, y - 1, z - 2) == NovaCraftBlocks.sculk_block)
			&& (world.getBlock(x + 3, y - 1, z - 3) == NovaCraftBlocks.sculk_block)						
			&& (world.getBlock(x - 3, y - 1, z) == NovaCraftBlocks.sculk_block)
			&& (world.getBlock(x - 3, y - 1, z + 1) == NovaCraftBlocks.sculk_block)
			&& (world.getBlock(x - 3, y - 1, z + 2) == NovaCraftBlocks.sculk_block)
			&& (world.getBlock(x - 3, y - 1, z - 1) == NovaCraftBlocks.sculk_block)
			&& (world.getBlock(x - 3, y - 1, z - 2) == NovaCraftBlocks.sculk_block)
			&& (world.getBlock(x - 3, y - 1, z - 3) == NovaCraftBlocks.sculk_block)						
			&& (world.getBlock(x, y - 1, z - 3) == NovaCraftBlocks.sculk_block)
			&& (world.getBlock(x + 1, y - 1, z - 3) == NovaCraftBlocks.sculk_block)
			&& (world.getBlock(x + 2, y - 1, z - 3) == NovaCraftBlocks.sculk_block)
			&& (world.getBlock(x - 1, y - 1, z - 3) == NovaCraftBlocks.sculk_block)
			&& (world.getBlock(x - 2, y - 1, z - 3) == NovaCraftBlocks.sculk_block)
			&& (world.getBlock(x - 3, y - 1, z - 3) == NovaCraftBlocks.sculk_block)						
			&& (world.getBlock(x, y - 1, z + 3) == NovaCraftBlocks.sculk_block)
			&& (world.getBlock(x + 1, y - 1, z + 3) == NovaCraftBlocks.sculk_block)
			&& (world.getBlock(x + 2, y - 1, z + 3) == NovaCraftBlocks.sculk_block)
			&& (world.getBlock(x - 1, y - 1, z + 3) == NovaCraftBlocks.sculk_block)
			&& (world.getBlock(x - 2, y - 1, z + 3) == NovaCraftBlocks.sculk_block)
			&& (world.getBlock(x - 3, y - 1, z + 3) == NovaCraftBlocks.sculk_block)
								
			&& (world.getBlock(x + 3, y, z) == NovaCraftBlocks.sculk_tentacle_2)
			&& (world.getBlock(x + 3, y, z + 1) == NovaCraftBlocks.sculk_tentacle_2)
			&& (world.getBlock(x + 3, y, z + 2) == NovaCraftBlocks.sculk_tentacle_2)
			&& (world.getBlock(x + 3, y, z - 1) == NovaCraftBlocks.sculk_tentacle_2)
			&& (world.getBlock(x + 3, y, z - 2) == NovaCraftBlocks.sculk_tentacle_2)
			&& (world.getBlock(x + 3, y, z - 3) == NovaCraftBlocks.sculk_tentacle_2)						
			&& (world.getBlock(x - 3, y, z) == NovaCraftBlocks.sculk_tentacle_2)
			&& (world.getBlock(x - 3, y, z + 1) == NovaCraftBlocks.sculk_tentacle_2)
			&& (world.getBlock(x - 3, y, z + 2) == NovaCraftBlocks.sculk_tentacle_2)
			&& (world.getBlock(x - 3, y, z - 1) == NovaCraftBlocks.sculk_tentacle_2)
			&& (world.getBlock(x - 3, y, z - 2) == NovaCraftBlocks.sculk_tentacle_2)
			&& (world.getBlock(x - 3, y, z - 3) == NovaCraftBlocks.sculk_tentacle_2)						
			&& (world.getBlock(x, y, z - 3) == NovaCraftBlocks.sculk_tentacle_2)
			&& (world.getBlock(x + 1, y, z - 3) == NovaCraftBlocks.sculk_tentacle_2)
			&& (world.getBlock(x + 2, y, z - 3) == NovaCraftBlocks.sculk_tentacle_2)
			&& (world.getBlock(x - 1, y, z - 3) == NovaCraftBlocks.sculk_tentacle_2)
			&& (world.getBlock(x - 2, y, z - 3) == NovaCraftBlocks.sculk_tentacle_2)
			&& (world.getBlock(x - 3, y, z - 3) == NovaCraftBlocks.sculk_tentacle_2)						
			&& (world.getBlock(x, y, z + 3) == NovaCraftBlocks.sculk_tentacle_2)
			&& (world.getBlock(x + 1, y, z + 3) == NovaCraftBlocks.sculk_tentacle_2)
			&& (world.getBlock(x + 2, y, z + 3) == NovaCraftBlocks.sculk_tentacle_2)
			&& (world.getBlock(x - 1, y, z + 3) == NovaCraftBlocks.sculk_tentacle_2)
			&& (world.getBlock(x - 2, y, z + 3) == NovaCraftBlocks.sculk_tentacle_2)
			&& (world.getBlock(x - 3, y, z + 3) == NovaCraftBlocks.sculk_tentacle_2)
			
			
			&& (world.getBlock(x + 4, y, z + 1) == NovaCraftBlocks.null_wart)
			&& (world.getBlock(x + 4, y, z + 2) == NovaCraftBlocks.null_wart)
			&& (world.getBlock(x + 4, y, z + 3) == NovaCraftBlocks.null_wart)
			&& (world.getBlock(x + 4, y, z - 1) == NovaCraftBlocks.null_wart)
			&& (world.getBlock(x + 4, y, z - 2) == NovaCraftBlocks.null_wart)
			&& (world.getBlock(x + 4, y, z - 3) == NovaCraftBlocks.null_wart)
						
			&& (world.getBlock(x - 4, y, z + 1) == NovaCraftBlocks.null_wart)
			&& (world.getBlock(x - 4, y, z + 2) == NovaCraftBlocks.null_wart)
			&& (world.getBlock(x - 4, y, z + 3) == NovaCraftBlocks.null_wart)
			&& (world.getBlock(x - 4, y, z - 1) == NovaCraftBlocks.null_wart)
			&& (world.getBlock(x - 4, y, z - 2) == NovaCraftBlocks.null_wart)
			&& (world.getBlock(x - 4, y, z - 3) == NovaCraftBlocks.null_wart)
								
			&& (world.getBlock(x + 1, y, z - 4) == NovaCraftBlocks.null_wart)
			&& (world.getBlock(x + 2, y, z - 4) == NovaCraftBlocks.null_wart)
			&& (world.getBlock(x + 3, y, z - 4) == NovaCraftBlocks.null_wart)
			&& (world.getBlock(x - 1, y, z - 4) == NovaCraftBlocks.null_wart)
			&& (world.getBlock(x - 2, y, z - 4) == NovaCraftBlocks.null_wart)
			&& (world.getBlock(x - 3, y, z - 4) == NovaCraftBlocks.null_wart)						
			
			&& (world.getBlock(x + 1, y, z + 4) == NovaCraftBlocks.null_wart)
			&& (world.getBlock(x + 2, y, z + 4) == NovaCraftBlocks.null_wart)
			&& (world.getBlock(x + 3, y, z + 4) == NovaCraftBlocks.null_wart)
			&& (world.getBlock(x - 1, y, z + 4) == NovaCraftBlocks.null_wart)
			&& (world.getBlock(x - 2, y, z + 4) == NovaCraftBlocks.null_wart)
			&& (world.getBlock(x - 3, y, z + 4) == NovaCraftBlocks.null_wart)
			
			&& (world.getBlock(x + 4, y - 1, z + 4) == NovaCraftBlocks.crystallized_end)
			&& (world.getBlock(x + 4, y, z + 4) == NovaCraftBlocks.nullstone_bricks)
			&& (world.getBlock(x + 4, y + 1, z + 4) == NovaCraftBlocks.nullstone_bricks)
			&& (world.getBlock(x + 4, y + 2, z + 4) == NovaCraftBlocks.nullstone_bricks)
			&& (world.getBlock(x + 4, y + 3, z + 4) == Blocks.diamond_block)
			
			&& (world.getBlock(x - 4, y - 1, z - 4) == NovaCraftBlocks.crystallized_end)
			&& (world.getBlock(x - 4, y, z - 4) == NovaCraftBlocks.nullstone_bricks)
			&& (world.getBlock(x - 4, y + 1, z - 4) == NovaCraftBlocks.nullstone_bricks)
			&& (world.getBlock(x - 4, y + 2, z - 4) == NovaCraftBlocks.nullstone_bricks)
			&& (world.getBlock(x - 4, y + 3, z - 4) == Blocks.diamond_block)
			
			&& (world.getBlock(x + 4, y - 1, z - 4) == NovaCraftBlocks.crystallized_end)
			&& (world.getBlock(x + 4, y, z - 4) == NovaCraftBlocks.nullstone_bricks)
			&& (world.getBlock(x + 4, y + 1, z - 4) == NovaCraftBlocks.nullstone_bricks)
			&& (world.getBlock(x + 4, y + 2, z - 4) == NovaCraftBlocks.nullstone_bricks)
			&& (world.getBlock(x + 4, y + 3, z - 4) == Blocks.diamond_block)
			
			&& (world.getBlock(x - 4, y - 1, z + 4) == NovaCraftBlocks.crystallized_end)
			&& (world.getBlock(x - 4, y, z + 4) == NovaCraftBlocks.nullstone_bricks)
			&& (world.getBlock(x - 4, y + 1, z + 4) == NovaCraftBlocks.nullstone_bricks)
			&& (world.getBlock(x - 4, y + 2, z + 4) == NovaCraftBlocks.nullstone_bricks)
			&& (world.getBlock(x - 4, y + 3, z + 4) == Blocks.diamond_block)
			
			
				
				
				
				
				) {
				player.triggerAchievement(AchievementsNovaCraft.summoning_an_ancient_evil);
				world.setBlock(x, y, z, NovaCraftBlocks.activated_grimstone_shrieker);
				
				world.setBlock(x + 1, y - 1, z, NovaCraftBlocks.cracked_grimstone_bricks);
				world.setBlock(x - 1, y - 1, z, NovaCraftBlocks.cracked_grimstone_bricks);
				world.setBlock(x, y - 1, z - 1, NovaCraftBlocks.cracked_grimstone_bricks);
				world.setBlock(x, y - 1, z + 1, NovaCraftBlocks.cracked_grimstone_bricks);
				world.setBlock(x + 1, y - 1, z - 1, NovaCraftBlocks.cracked_grimstone_bricks);
				world.setBlock(x + 1, y - 1, z + 1, NovaCraftBlocks.cracked_grimstone_bricks);
				world.setBlock(x - 1, y - 1, z + 1, NovaCraftBlocks.cracked_grimstone_bricks);
				world.setBlock(x - 1, y - 1, z + 1, NovaCraftBlocks.cracked_grimstone_bricks);
				
				world.setBlock(x + 4, y - 1, z + 4, Blocks.air);
				world.setBlock(x - 4, y - 1, z - 4, Blocks.air);
				world.setBlock(x + 4, y - 1, z - 4, Blocks.air);
				world.setBlock(x - 4, y - 1, z + 4, Blocks.air);
				
				world.setBlock(x + 4, y - 1, z, Blocks.air);
				world.setBlock(x - 4, y - 1, z, Blocks.air);
				world.setBlock(x, y - 1, z + 4, Blocks.air);
				world.setBlock(x, y - 1, z - 4, Blocks.air);
				
				world.setBlock(x + 2, y - 1, z, Blocks.air);
				world.setBlock(x + 2, y - 1, z + 1, Blocks.air);
				world.setBlock(x + 2, y - 1, z - 1, Blocks.air);					
				world.setBlock(x - 2, y - 1, z, Blocks.air);
				world.setBlock(x - 2, y - 1, z + 1, Blocks.air);
				world.setBlock(x - 2, y - 1, z - 1, Blocks.air);		
				world.setBlock(x, y - 1, z - 2, Blocks.air);
				world.setBlock(x + 1, y - 1, z - 2, Blocks.air);
				world.setBlock(x - 1, y - 1, z - 2, Blocks.air);								
				world.setBlock(x, y - 1, z + 2, Blocks.air);
				world.setBlock(x + 1, y - 1, z + 2, Blocks.air);
				world.setBlock(x - 1, y - 1, z + 2, Blocks.air);				
				world.setBlock(x + 2, y, z, Blocks.air);
				world.setBlock(x + 2, y, z + 1, Blocks.air);
				world.setBlock(x + 2, y, z - 1, Blocks.air);					
				world.setBlock(x - 2, y, z, Blocks.air);
				world.setBlock(x - 2, y, z + 1, Blocks.air);
				world.setBlock(x - 2, y, z - 1, Blocks.air);	
				world.setBlock(x, y, z - 2, Blocks.air);
				world.setBlock(x + 1, y, z - 2, Blocks.air);
				world.setBlock(x - 1, y, z - 2, Blocks.air);								
				world.setBlock(x, y, z + 2, Blocks.air);
				world.setBlock(x + 1, y, z + 2, Blocks.air);
				world.setBlock(x - 1, y, z + 2, Blocks.air);
				
				world.setBlock(x + 2, y, z + 2, NovaCraftBlocks.cracked_grimstone_bricks);
				world.setBlock(x - 2, y, z - 2, NovaCraftBlocks.cracked_grimstone_bricks);
				world.setBlock(x + 2, y, z - 2, NovaCraftBlocks.cracked_grimstone_bricks);
				world.setBlock(x - 2, y, z + 2, NovaCraftBlocks.cracked_grimstone_bricks);			
				world.setBlock(x + 2, y + 1, z + 2, NovaCraftBlocks.cracked_grimstone_bricks);
				world.setBlock(x - 2, y + 1, z - 2, NovaCraftBlocks.cracked_grimstone_bricks);
				world.setBlock(x + 2, y + 1, z - 2, NovaCraftBlocks.cracked_grimstone_bricks);
				world.setBlock(x - 2, y + 1, z + 2, NovaCraftBlocks.cracked_grimstone_bricks);
				
				world.setBlock(x + 2, y + 2, z + 2, Blocks.fire);
				world.setBlock(x - 2, y + 2, z - 2, Blocks.fire);
				world.setBlock(x + 2, y + 2, z - 2, Blocks.fire);
				world.setBlock(x - 2, y + 2, z + 2, Blocks.fire);
				
				world.setBlock(x + 2, y + 3, z + 2, Blocks.air);
				world.setBlock(x + 2, y + 2, z + 3, Blocks.air);
				world.setBlock(x + 2, y + 2, z + 1, Blocks.air);
				world.setBlock(x + 1, y + 2, z + 2, Blocks.air);
				world.setBlock(x + 3, y + 2, z + 2, Blocks.air);						
				world.setBlock(x - 2, y + 3, z - 2, Blocks.air);
				world.setBlock(x - 2, y + 2, z - 3, Blocks.air);
				world.setBlock(x - 2, y + 2, z - 1, Blocks.air);
				world.setBlock(x - 3, y + 2, z - 2, Blocks.air);
				world.setBlock(x - 1, y + 2, z - 2, Blocks.air);				
				world.setBlock(x + 2, y + 3, z - 2, Blocks.air);
				world.setBlock(x + 2, y + 2, z - 3, Blocks.air);
				world.setBlock(x + 2, y + 2, z - 1, Blocks.air);
				world.setBlock(x + 1, y + 2, z - 2, Blocks.air);
				world.setBlock(x + 3, y + 2, z - 2, Blocks.air);		
				world.setBlock(x - 2, y + 3, z + 2, Blocks.air);
				world.setBlock(x - 2, y + 2, z + 3, Blocks.air);
				world.setBlock(x - 2, y + 2, z + 1, Blocks.air);
				world.setBlock(x - 1, y + 2, z + 2, Blocks.air);
				world.setBlock(x - 3, y + 2, z + 2, Blocks.air);
				
				world.setBlock(x + 4, y, z, Blocks.air);
				world.setBlock(x - 4, y, z, Blocks.air);
				world.setBlock(x, y, z - 4, Blocks.air);
				world.setBlock(x, y, z + 4, Blocks.air);
				
				world.setBlock(x + 3, y - 1, z, Blocks.air);
				world.setBlock(x + 3, y - 1, z + 1, Blocks.air);
				world.setBlock(x + 3, y - 1, z + 2, Blocks.air);
				world.setBlock(x + 3, y - 1, z - 1, Blocks.air);
				world.setBlock(x + 3, y - 1, z - 2, Blocks.air);
				world.setBlock(x + 3, y - 1, z - 3, Blocks.air);						
				world.setBlock(x - 3, y - 1, z, Blocks.air);
				world.setBlock(x - 3, y - 1, z + 1, Blocks.air);
				world.setBlock(x - 3, y - 1, z + 2, Blocks.air);
				world.setBlock(x - 3, y - 1, z - 1, Blocks.air);
				world.setBlock(x - 3, y - 1, z - 2, Blocks.air);
				world.setBlock(x - 3, y - 1, z - 3, Blocks.air);						
				world.setBlock(x, y - 1, z - 3, Blocks.air);
				world.setBlock(x + 1, y - 1, z - 3, Blocks.air);
				world.setBlock(x + 2, y - 1, z - 3, Blocks.air);
				world.setBlock(x - 1, y - 1, z - 3, Blocks.air);
				world.setBlock(x - 2, y - 1, z - 3, Blocks.air);
				world.setBlock(x - 3, y - 1, z - 3, Blocks.air);						
				world.setBlock(x, y - 1, z + 3, Blocks.air);
				world.setBlock(x + 1, y - 1, z + 3, Blocks.air);
				world.setBlock(x + 2, y - 1, z + 3, Blocks.air);
				world.setBlock(x - 1, y - 1, z + 3, Blocks.air);
				world.setBlock(x - 2, y - 1, z + 3, Blocks.air);
				world.setBlock(x - 3, y - 1, z + 3, Blocks.air);
				
				world.setBlock(x + 3, y, z, Blocks.air);
				world.setBlock(x + 3, y, z + 1, Blocks.air);
				world.setBlock(x + 3, y, z + 2, Blocks.air);
				world.setBlock(x + 3, y, z - 1, Blocks.air);
				world.setBlock(x + 3, y, z - 2, Blocks.air);
				world.setBlock(x + 3, y, z - 3, Blocks.air);						
				world.setBlock(x - 3, y, z, Blocks.air);
				world.setBlock(x - 3, y, z + 1, Blocks.air);
				world.setBlock(x - 3, y, z + 2, Blocks.air);
				world.setBlock(x - 3, y, z - 1, Blocks.air);
				world.setBlock(x - 3, y, z - 2, Blocks.air);
				world.setBlock(x - 3, y, z - 3, Blocks.air);						
				world.setBlock(x, y, z - 3, Blocks.air);
				world.setBlock(x + 1, y, z - 3, Blocks.air);
				world.setBlock(x + 2, y, z - 3, Blocks.air);
				world.setBlock(x - 1, y, z - 3, Blocks.air);
				world.setBlock(x - 2, y, z - 3, Blocks.air);
				world.setBlock(x - 3, y, z - 3, Blocks.air);						
				world.setBlock(x, y, z + 3, Blocks.air);
				world.setBlock(x + 1, y, z + 3, Blocks.air);
				world.setBlock(x + 2, y, z + 3, Blocks.air);
				world.setBlock(x - 1, y, z + 3, Blocks.air);
				world.setBlock(x - 2, y, z + 3, Blocks.air);
				world.setBlock(x - 3, y, z + 3, Blocks.air);
				
				world.setBlock(x + 4, y, z + 1, Blocks.fire);
				world.setBlock(x + 4, y, z + 2, Blocks.fire);
				world.setBlock(x + 4, y, z + 3, Blocks.fire);
				world.setBlock(x + 4, y, z - 1, Blocks.fire);
				world.setBlock(x + 4, y, z - 2, Blocks.fire);
				world.setBlock(x + 4, y, z - 3, Blocks.fire);
							
				world.setBlock(x - 4, y, z + 1, Blocks.fire);
				world.setBlock(x - 4, y, z + 2, Blocks.fire);
				world.setBlock(x - 4, y, z + 3, Blocks.fire);
				world.setBlock(x - 4, y, z - 1, Blocks.fire);
				world.setBlock(x - 4, y, z - 2, Blocks.fire);
				world.setBlock(x - 4, y, z - 3, Blocks.fire);
									
				world.setBlock(x + 1, y, z - 4, Blocks.fire);
				world.setBlock(x + 2, y, z - 4, Blocks.fire);
				world.setBlock(x + 3, y, z - 4, Blocks.fire);
				world.setBlock(x - 1, y, z - 4, Blocks.fire);
				world.setBlock(x - 2, y, z - 4, Blocks.fire);
				world.setBlock(x - 3, y, z - 4, Blocks.fire);						
				
				world.setBlock(x + 1, y, z + 4, Blocks.fire);
				world.setBlock(x + 2, y, z + 4, Blocks.fire);
				world.setBlock(x + 3, y, z + 4, Blocks.fire);
				world.setBlock(x - 1, y, z + 4, Blocks.fire);
				world.setBlock(x - 2, y, z + 4, Blocks.fire);
				world.setBlock(x - 3, y, z + 4, Blocks.fire);
				
				world.setBlock(x + 4, y, z + 4, NovaCraftBlocks.cracked_grimstone_bricks);
				world.setBlock(x + 4, y + 1, z + 4, NovaCraftBlocks.cracked_grimstone_bricks);
				world.setBlock(x + 4, y + 2, z + 4, NovaCraftBlocks.cracked_grimstone_bricks);
				world.setBlock(x - 4, y, z - 4, NovaCraftBlocks.cracked_grimstone_bricks);
				world.setBlock(x - 4, y + 1, z - 4, NovaCraftBlocks.cracked_grimstone_bricks);
				world.setBlock(x - 4, y + 2, z - 4, NovaCraftBlocks.cracked_grimstone_bricks);
				world.setBlock(x + 4, y, z - 4, NovaCraftBlocks.cracked_grimstone_bricks);
				world.setBlock(x + 4, y + 1, z - 4, NovaCraftBlocks.cracked_grimstone_bricks);
				world.setBlock(x + 4, y + 2, z - 4, NovaCraftBlocks.cracked_grimstone_bricks);
				world.setBlock(x - 4, y, z + 4, NovaCraftBlocks.cracked_grimstone_bricks);
				world.setBlock(x - 4, y + 1, z + 4, NovaCraftBlocks.cracked_grimstone_bricks);
				world.setBlock(x - 4, y + 2, z + 4, NovaCraftBlocks.cracked_grimstone_bricks);
				
				world.setBlock(x + 4, y + 3, z + 4, Blocks.fire);
				world.setBlock(x - 4, y + 3, z - 4, Blocks.fire);
				world.setBlock(x + 4, y + 3, z - 4, Blocks.fire);
				world.setBlock(x - 4, y + 3, z + 4, Blocks.fire);
				
				world.playSoundEffect(x, y, z, "nova_craft:warden_altar.shriek", 1.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
				--heldItem.stackSize;
		}
		else {
			if (world.isRemote) {
		          return true;
		      }
			else {
			player.addChatComponentMessage(new ChatComponentText(I18n.format("gui.warden_altar_invaild_structure")));
			}
		}
		
		return true;
	}
	
	protected String getShriekerSound()
    {
        return "nova_craft:warden_altar.shriek";
    }
	
}
