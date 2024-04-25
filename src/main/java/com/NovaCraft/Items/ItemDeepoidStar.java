package com.NovaCraft.Items;

import com.NovaCraft.achievements.AchievementsNovaCraft;
import com.NovaCraft.entity.EntityFireProofItemNovaCraft;
import com.NovaCraft.registry.NovaCraftCreativeTabs;
import com.NovaCraftBlocks.NovaCraftBlocks;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class ItemDeepoidStar extends Item {
	
	private IIcon[] icon;

	public ItemDeepoidStar() {
		this.icon = new IIcon[1];
		maxStackSize = 1;
        this.setCreativeTab(NovaCraftCreativeTabs.items);
    }
	
	public void registerBlockIcons(final IIconRegister iconRegister) {
        this.icon[0] = iconRegister.registerIcon("nova_craft:deepoid_star");
    }
	
	public IIcon getIcon(final int side, int meta) {
        if (meta < 0 || meta >= this.icon.length) {
            meta = 1;
        }
        return this.icon[meta];
    }
	
	public Entity createEntity(final World world, final Entity location, final ItemStack itemstack) {
        return (Entity)new EntityFireProofItemNovaCraft(world, location, itemstack);
    }
	
	@Override
	public boolean hasEffect(ItemStack stack, int pass) {
		return true;
	}
	
	@Override
	public boolean onItemUse(ItemStack heldItem, EntityPlayer player, World world, int x, int y, int z, int facing, float hitX, float hitY, float hitZ) {
		Block block = world.getBlock(x, y, z);
		int meta = world.getBlockMetadata(x, y, z);
		
	   if (world.provider.dimensionId == -1) {	
		if (world.getBlock(x, y, z) == NovaCraftBlocks.deep_one_egg) {
			
			world.setBlock(x, y, z, NovaCraftBlocks.deep_one_egg_activated);
			player.triggerAchievement(AchievementsNovaCraft.the_nether_dragon);
				
				world.playSoundEffect(x, y, z, "nova_craft:boss.DOsummoning", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
				--heldItem.stackSize;		
		 }
	   }
		return true;
	}
	
	protected String getSummoningSound()
    {
        return "nova_craft:boss.DOsummoning";
    }
	
}

