package com.NovaCraft.Items;

import java.util.List;
import java.util.Random;

import com.NovaCraft.particles.ParticleHandler;
import com.NovaCraft.registry.NovaCraftCreativeTabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class ItemVoidExplosive extends Item {

	public ItemVoidExplosive()
    {
        this.setCreativeTab(NovaCraftCreativeTabs.items);
    }
	
	public boolean onEntityItemUpdate(EntityItem item) {
		
	      if (item.posY <= 0.0D) {
	         if (!(item.worldObj.isRemote)) {
	         item.worldObj.playSoundAtEntity(item, "nova_craft:null_explosion", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + 1.0F * 0.5F);

	         float f = (item.worldObj.rand.nextFloat() - 0.5F) * 8.0F;
	         float f1 = (item.worldObj.rand.nextFloat() - 0.5F) * 4.0F;
	         float f2 = (item.worldObj.rand.nextFloat() - 0.5F) * 8.0F;
	         item.worldObj.spawnParticle("hugeexplosion", item.posX + (double)f, item.posY + 2.0D + (double)f1, item.posZ + (double)f2, 0.0D, 0.0D, 0.0D);
	         
	         item.setDead();
	         }
	      }

	      return false;	
	}

}
