package com.NovaCraft.Items;

import java.util.List;
import java.util.Random;

import com.NovaCraft.Items.Staffs.ItemDiamondFirechargeLauncher;
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

public class ItemExplosiveKlagniteIngot extends Item {

	public ItemExplosiveKlagniteIngot()
    {
        this.setCreativeTab(NovaCraftCreativeTabs.items);
    }
	
	public boolean onEntityItemUpdate(EntityItem item) {
		
	      if (item.posY <= 0.0D && item.getEntityItem().getItem().equals(NovaCraftItems.explosive_klangite_ingot)) {
	         int i = item.getEntityItem().stackSize;
	         if (!(item.worldObj.isRemote)) {
	         item.worldObj.spawnEntityInWorld(new EntityItem(item.worldObj, item.posX, 1.0D, item.posZ, new ItemStack(NovaCraftItems.klangite_ingot, i)));
	         item.motionY = 12.0D;
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
	
	public void addInformation(final ItemStack stack, final EntityPlayer player, final List tooltip, final boolean who) {
        tooltip.add(EnumChatFormatting.LIGHT_PURPLE + "" + StatCollector.translateToLocal("tooltip.explosive_ingot.desc"));
    }

}
