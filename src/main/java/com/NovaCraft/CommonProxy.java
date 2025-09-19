package com.NovaCraft;

import java.util.LinkedList;
import java.util.List;

import com.NovaCraft.TileEntity.ContainerLegendaryBeacon;
import com.NovaCraft.TileEntity.TileEntityDeepoidFurnace;
import com.NovaCraft.TileEntity.TileEntityLegendaryBeacon;
import com.NovaCraft.container.AdvancedEnchantmentTableContainer;
import com.NovaCraft.container.AdvancedSmithingTableContainer;
import com.NovaCraft.container.DeepoidFurnaceContainer;
import com.NovaCraft.container.LegendaryEnchantmentTableContainer;
import com.NovaCraft.gui.GuiAdvancedEnchantmentTable;
import com.NovaCraft.gui.GuiAdvancedSmithingTable;
import com.NovaCraft.gui.GuiDeepoidFurnace;
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
	public Object getClientGuiElement(final int id, final EntityPlayer player, final World world, final int x, final int y, final int z) {
        final TileEntity tile_entity = world.getTileEntity(x, y, z);
        switch (id) {
        	case 1: {
                return (world.getBlock(x, y, z) == NovaCraftBlocks.advanced_smithing_table) ? new GuiAdvancedSmithingTable(player.inventory, world, x, y, z) : null;
            }
        	case 2: {
                final TileEntity tileentity = world.getTileEntity(x, y, z);
                if (tileentity instanceof TileEntityLegendaryBeacon) {
                    return new GuiLegendaryBeacon(player.inventory, (TileEntityLegendaryBeacon)tileentity);
                }
                break;
            }
        	case 3: {
        		return new GuiLegendaryEnchantmentTable(player.inventory, player.worldObj, x, y, z, null);
        	}
        	case 4: {
        		return new GuiAdvancedEnchantmentTable(player.inventory, player.worldObj, x, y, z, null);
        		}
        	case 5: {
        		return new GuiDeepoidFurnace(player.inventory, (TileEntityDeepoidFurnace)tile_entity);
        		}
            }
        
        return null;
    }
    
	@Override
    public Object getServerGuiElement(final int id, final EntityPlayer player, final World world, final int x, final int y, final int z) {
        final TileEntity tile_entity = world.getTileEntity(x, y, z);
        switch (id) {           
        	case 1: {
                    return (world.getBlock(x, y, z) == NovaCraftBlocks.advanced_smithing_table) ? new AdvancedSmithingTableContainer(player.inventory, world, x, y, z) : null;
                }
        	case 2: {
                final TileEntity tileentity = world.getTileEntity(x, y, z);
                if (tileentity instanceof TileEntityLegendaryBeacon) {
                    return new ContainerLegendaryBeacon(player.inventory, (TileEntityLegendaryBeacon)tileentity);
                }
                break;
              }
        	case 3: {
        			return (world.getBlock(x, y, z) == NovaCraftBlocks.legendary_enchantment_table) ? new LegendaryEnchantmentTableContainer(player.inventory, player.worldObj, x, y, z) : null;
        	  }
        	case 4: {
        			return (world.getBlock(x, y, z) == NovaCraftBlocks.advanced_enchantment_table) ? new AdvancedEnchantmentTableContainer(player.inventory, player.worldObj, x, y, z) : null;
        	  } 
        	case 5: {
        		return new DeepoidFurnaceContainer(player.inventory, (TileEntityDeepoidFurnace)tile_entity);
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
