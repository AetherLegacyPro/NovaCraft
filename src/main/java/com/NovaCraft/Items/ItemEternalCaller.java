package com.NovaCraft.Items;

import com.NovaCraft.achievements.AchievementsNovaCraft;
import com.NovaCraft.entity.EntityBloviator;
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

public class ItemEternalCaller extends Item {
	
	private IIcon[] icon;

	public ItemEternalCaller() {
		this.icon = new IIcon[1];
		maxStackSize = 1;
        this.setCreativeTab(NovaCraftCreativeTabs.items);
    }
	
	public void registerBlockIcons(final IIconRegister iconRegister) {
        this.icon[0] = iconRegister.registerIcon("nova_craft:eternal_caller");
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
        if(!world.isRemote && world.provider.dimensionId == 1) {
        		player.triggerAchievement(AchievementsNovaCraft.summoning_the_bloat);
        		EntityBloviator entity = new EntityBloviator(world);
                entity.setPosition(x, y + 15, z);
                world.playSoundEffect(x, y, z, "nova_craft:boss.summoning", 1.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
                if(world.getCollidingBoundingBoxes(entity, entity.boundingBox).isEmpty()) { 
                    world.spawnEntityInWorld(entity);
                	--heldItem.stackSize;	
                }
                
        } else {
        	if (world.isRemote) {
        	player.addChatComponentMessage(new ChatComponentText(I18n.format("gui.invaild.dimension")));
        	}
        }
        return true;
    }
	
	protected String getSummoningSound()
    {
        return "nova_craft:boss.summoning";
    }
	
}
