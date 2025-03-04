package com.NovaCraft;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.config.Configs;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraft.block.BlockBed;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayer.EnumStatus;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.client.event.FOVUpdateEvent;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;
import net.minecraftforge.event.world.BlockEvent;

public class NovaCraftClientEvents {
	
	@SubscribeEvent
	public void onBowPulled(FOVUpdateEvent event) {
		EntityPlayer player = Minecraft.getMinecraft().thePlayer;

		if (player == null || (player != null && player.getCurrentEquippedItem() == null)) {
			return;
		}

		Item item = player.getCurrentEquippedItem().getItem();

		if (item == NovaCraftItems.diamond_bow || item == NovaCraftItems.tophinite_bow || item == NovaCraftItems.crystallized_vanite_bow
				|| item == NovaCraftItems.kylazite_bow || item == NovaCraftItems.warden_bow || item == NovaCraftItems.ophidian_bow	
				|| item == NovaCraftItems.klangite_bow || item == NovaCraftItems.crystalite_bow) {
			int i = player.getItemInUseDuration();
			float f1 = (float) i / 20.0F;

			if (f1 > 1.0F) {
				f1 = 1.0F;
			} else {
				f1 = f1 * f1;
			}

			float original = event.fov;

			original *= 1.0F - f1 * 0.15F;

			event.newfov = original;
		}
	   if (Loader.isModLoaded("etfuturum")) {
		if (item == NovaCraftItems.netherite_bow) {
			int i = player.getItemInUseDuration();
			float f1 = (float) i / 20.0F;

			if (f1 > 1.0F) {
				f1 = 1.0F;
			} else {
				f1 = f1 * f1;
			}

			float original = event.fov;

			original *= 1.0F - f1 * 0.15F;

			event.newfov = original;
		 }
	   }
	}
	
	@SubscribeEvent
	   public void sleepInBed(PlayerSleepInBedEvent event) {
		if (Configs.enableNoSkippingTheNight == true) {
		 EntityPlayer player = event.entityPlayer;
		    int x = event.x;
		    int y = event.y;
		    int z = event.z;
		    
		    if (player != null) {
		        player.setSpawnChunk(new ChunkCoordinates(x, y, z), true, player.worldObj.provider.dimensionId);
		        player.addChatMessage((new ChatComponentTranslation("tooltip.right_click_bed.desc", new Object[0])).setChatStyle((new ChatStyle()).setColor(EnumChatFormatting.GOLD)));
		    }
		    
		    event.result = EnumStatus.OTHER_PROBLEM;
		}
	   }
	
	@SubscribeEvent
	public void onBedBreak(BlockEvent.BreakEvent event) {
		if (event.block instanceof BlockBed && Configs.enableNoSkippingTheNight == true) {
	        EntityPlayer player = event.getPlayer();
	        if (player != null && player.getBedLocation(player.dimension) != null) {
	            ChunkCoordinates spawn = player.getBedLocation(player.dimension);
	            
	            int bedX = event.x;
	            int bedY = event.y;
	            int bedZ = event.z;
	            
	            boolean isHead = BlockBed.isBlockHeadOfBed(event.blockMetadata);
	            
	            if (!isHead) {
	                int direction = event.blockMetadata & 3;
	                switch (direction) {
	                    case 0: bedZ += 1; break; //South
	                    case 1: bedX -= 1; break; //West
	                    case 2: bedZ -= 1; break; //North
	                    case 3: bedX += 1; break; //East
	                }
	            }
	            
	            if (spawn.posX == bedX && spawn.posY == bedY && spawn.posZ == bedZ) {
	                player.setSpawnChunk(null, true, player.dimension);
	                player.addChatMessage((new ChatComponentTranslation("tooltip.bed_destroyed.desc", new Object[0])).setChatStyle((new ChatStyle()).setColor(EnumChatFormatting.RED)));
	            }
	        }
		}
	}
	
}
