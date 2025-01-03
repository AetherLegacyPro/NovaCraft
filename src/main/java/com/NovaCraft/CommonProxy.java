package com.NovaCraft;

import java.util.LinkedList;
import java.util.List;

import com.NovaCraft.TileEntity.ContainerLegendaryBeacon;
import com.NovaCraft.TileEntity.TileEntityLegendaryBeacon;
import com.NovaCraft.container.AdvancedEnchantmentTableContainer;
import com.NovaCraft.container.AdvancedSmithingTableContainer;
import com.NovaCraft.container.LegendaryEnchantmentTableContainer;
import com.NovaCraft.gui.GuiAdvancedEnchantmentTable;
import com.NovaCraft.gui.GuiAdvancedSmithingTable;
import com.NovaCraft.gui.GuiLegendaryBeacon;
import com.NovaCraft.gui.GuiLegendaryEnchantmentTable;
import com.NovaCraftBlocks.NovaCraftBlocks;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenBase.SpawnListEntry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;

public class CommonProxy implements IGuiHandler
{
	public void init() {
    }
	
	public void registerRenderers() {
    }
	
	public int getBlockRender(final Block blockID) {
        return 27;
    }
	
	@Override
	public Object getClientGuiElement(final int par1, final EntityPlayer par2EntityPlayer, final World par3World, final int par4, final int par5, final int par6) {
        final TileEntity var7 = par3World.getTileEntity(par4, par5, par6);
        switch (par1) {
            default: {
                if (par1 == 1) {
                    return (par1 == 1 && par3World.getBlock(par4, par5, par6) == NovaCraftBlocks.advanced_smithing_table) ? new GuiAdvancedSmithingTable(par2EntityPlayer.inventory, par3World, par4, par5, par6) : null;
                }
                if (par1 == 2) {
                final TileEntity tileentity = par3World.getTileEntity(par4, par5, par6);
                if (tileentity instanceof TileEntityLegendaryBeacon) {
                    return new GuiLegendaryBeacon(par2EntityPlayer.inventory, (TileEntityLegendaryBeacon)tileentity);
                }
                break;
              }
                if (par1 == 3) {
        			return new GuiLegendaryEnchantmentTable(par2EntityPlayer.inventory, par2EntityPlayer.worldObj, par4, par5, par6, null);
        	  }
                if (par1 == 4) {
        			return new GuiAdvancedEnchantmentTable(par2EntityPlayer.inventory, par2EntityPlayer.worldObj, par4, par5, par6, null);
        		}
            }
        }
        
        return null;
    }
    
	@Override
    public Object getServerGuiElement(final int par1, final EntityPlayer par2EntityPlayer, final World par3World, final int par4, final int par5, final int par6) {
        final TileEntity var7 = par3World.getTileEntity(par4, par5, par6);
        switch (par1) {           
            default: {
                if (par1 == 1) {
                    return (par1 == 1 && par3World.getBlock(par4, par5, par6) == NovaCraftBlocks.advanced_smithing_table) ? new AdvancedSmithingTableContainer(par2EntityPlayer.inventory, par3World, par4, par5, par6) : null;
                }
                if (par1 == 2) {
                final TileEntity tileentity = par3World.getTileEntity(par4, par5, par6);
                if (tileentity instanceof TileEntityLegendaryBeacon) {
                    return new ContainerLegendaryBeacon(par2EntityPlayer.inventory, (TileEntityLegendaryBeacon)tileentity);
                }
                break;
              }
                if (par1 == 3) {
        			return (par1 == 3 && par3World.getBlock(par4, par5, par6) == NovaCraftBlocks.legendary_enchantment_table) ? new LegendaryEnchantmentTableContainer(par2EntityPlayer.inventory, par2EntityPlayer.worldObj, par4, par5, par6) : null;
        	  }
                if (par1 == 4) {
        			return (par1 == 4 && par3World.getBlock(par4, par5, par6) == NovaCraftBlocks.advanced_enchantment_table) ? new AdvancedEnchantmentTableContainer(par2EntityPlayer.inventory, par2EntityPlayer.worldObj, par4, par5, par6) : null;
        	  }
            }
        }
        return null;
    }
	
	public EntityPlayer getPlayer() {
		return null;
	}
	
	public static void registerEvent(Object event) {
		FMLCommonHandler.instance().bus().register(event);
		MinecraftForge.EVENT_BUS.register(event);
		
	}
	
}
