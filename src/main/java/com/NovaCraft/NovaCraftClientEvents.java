package com.NovaCraft;


import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.config.Configs;
import com.NovaCraft.world.caves.MapGenCavesOverride;
import com.NovaCraftBlocks.NovaCraftBlocks;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.relauncher.ReflectionHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBed;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayer.EnumStatus;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.util.*;
import net.minecraft.world.World;
import net.minecraftforge.client.event.FOVUpdateEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingHealEvent;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;
import net.minecraftforge.event.terraingen.InitMapGenEvent;
import net.minecraftforge.event.world.BlockEvent;

import java.lang.reflect.Field;

public class NovaCraftClientEvents {

	@SubscribeEvent
	public void onInitMapGen(InitMapGenEvent event) {
		if ((event.type == InitMapGenEvent.EventType.CAVE) && Configs.enableOldCaveGeneration) {
			event.newGen = new MapGenCavesOverride();
		}
	}

	@SubscribeEvent
	   public void sleepInBed(PlayerSleepInBedEvent event) {
		if (Configs.enableNoSkippingTheNight) {
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
	public void onCreeperUpdate(LivingEvent.LivingUpdateEvent event) {
		if (!Configs.enableCreeperAlterations) return;
		if (!(event.entityLiving instanceof EntityCreeper)) return;

		EntityCreeper creeper = (EntityCreeper) event.entityLiving;
		World world = creeper.worldObj;
		if (world.isRemote) return;

		try {
			int fuseTime = ReflectionHelper.getPrivateValue(EntityCreeper.class, creeper, "fuseTime", "field_82225_f");
			int timeSinceIgnited = ReflectionHelper.getPrivateValue(EntityCreeper.class, creeper, "timeSinceIgnited", "field_70833_d");

			if (timeSinceIgnited >= fuseTime) {
				float healthPercent = creeper.getHealth() / creeper.getMaxHealth();
				float radius = 3.0F + (1.0F - healthPercent);

				if (creeper.getPowered()) {
					radius *= 2.0F;
				}

				boolean mobGriefing = world.getGameRules().getGameRuleBooleanValue("mobGriefing");
				world.createExplosion(creeper, creeper.posX, creeper.posY, creeper.posZ, radius, mobGriefing);

				creeper.setDead();

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SubscribeEvent
	public void onJoin(EntityJoinWorldEvent event) {
		if (!Configs.enableEndermanAlterations) return;

		if (event.entity instanceof EntityEnderman) {

			EntityEnderman enderman = (EntityEnderman) event.entity;
			enderman.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(14.0D);
		}
	}

	@SubscribeEvent
	public void onLivingUpdate(LivingEvent.LivingUpdateEvent event) {
		if (!Configs.enableEndermanAlterations) return;

		if (!(event.entityLiving instanceof EntityEnderman))
			return;

		EntityEnderman enderman = (EntityEnderman) event.entityLiving;

		if (enderman.worldObj.isRemote)
			return;

		if (enderman.getAttackTarget() != null) {
			if (enderman.getRNG().nextInt(10) == 0) {

				double x = enderman.posX + (enderman.getRNG().nextDouble() - 0.5D) * 32D;
				double y = enderman.posY + (enderman.getRNG().nextInt(16) - 8);
				double z = enderman.posZ + (enderman.getRNG().nextDouble() - 0.5D) * 32D;
				EnderTeleportEvent teleport = new EnderTeleportEvent(enderman, x, y, z, 0);

				if (!MinecraftForge.EVENT_BUS.post(teleport)) {
					enderman.setPositionAndUpdate(teleport.targetX, teleport.targetY, teleport.targetZ);
				}
			}
		}
	}
	
	@SubscribeEvent
	public void onBedBreak(BlockEvent.BreakEvent event) {
		if (event.block instanceof BlockBed && Configs.enableNoSkippingTheNight) {
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
	
	@SideOnly(Side.CLIENT)
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
	public void onWorldTick(TickEvent.WorldTickEvent event) {
	    if (Configs.enableGlowingObsidian) { //Sure there is a better way to do this but it just works for now
	    	
	    if (event.phase != TickEvent.Phase.END || event.world.isRemote) return;
	    
	    int radius = 6;	    
	    int radiusSq = radius * radius;

	    for (Object obj : event.world.playerEntities) {
	        EntityPlayer player = (EntityPlayer) obj;

	        int px = (int) player.posX;
	        int py = (int) player.posY;
	        int pz = (int) player.posZ;

	        for (int x = px - radius; x <= px + radius; x++) {
	            for (int y = py - radius; y <= py + radius; y++) {
	                for (int z = pz - radius; z <= pz + radius; z++) {
	                    int dx = x - px;
	                    int dy = y - py;
	                    int dz = z - pz;

	                    if (dx * dx + dy * dy + dz * dz <= radiusSq) {
	                        Block block = event.world.getBlock(x, y, z);
	                        if (block == Blocks.obsidian) {
	                            Block below = event.world.getBlock(x, y - 1, z);
	                            int meta = event.world.getBlockMetadata(x, y - 1, z);
	                            if (below == Blocks.lava && meta == 0) {
	                                event.world.setBlock(x, y, z, NovaCraftBlocks.glowing_obsidian);
	                            }
	                        }
	                    }
	                }
	            }
	        }
	    }
	  }
	}
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onClientWorldTick(TickEvent.WorldTickEvent event) {

		if (!Configs.enableNewCaveSounds) return;
		if (event.phase != TickEvent.Phase.END) return;
		if (!event.world.isRemote) return;

		Minecraft mc = Minecraft.getMinecraft();
		EntityPlayer player = mc.thePlayer;
		if (player == null) return;

		if (player.dimension == -1 || player.dimension == 1) return;

		int x = MathHelper.floor_double(player.posX);
		int y = MathHelper.floor_double(player.posY);
		int z = MathHelper.floor_double(player.posZ);

		if (event.world.rand.nextInt(22000) == 0) {
			if (event.world.getBlockLightValue(x, y, z) <= 0 && y < 32) {

				String[] NewCaveSounds = {"nova_craft:ambient.cave_new1", "nova_craft:ambient.cave_new2", "nova_craft:ambient.cave_new3",
						"nova_craft:ambient.cave_new4", "nova_craft:ambient.cave_new5", "nova_craft:ambient.cave_new6", "nova_craft:ambient.cave_new7",
						"nova_craft:ambient.cave_new8", "nova_craft:ambient.cave_new9", "nova_craft:ambient.cave_new10", "nova_craft:ambient.cave_new11",
						"nova_craft:ambient.cave_new12", "nova_craft:ambient.cave_new13"};

				String chosen = NewCaveSounds[event.world.rand.nextInt(NewCaveSounds.length)];
				player.playSound(chosen, 1.0F, 1.0F);
			}
		}
	}

	@SubscribeEvent
	public void onLivingHeal(LivingHealEvent event) {
		if (!(event.entity instanceof EntityPlayer)) return;
		if (!(Configs.enableHalfNaturalRegenInEnd)) return;

		EntityPlayer player = (EntityPlayer) event.entity;
		if (player.worldObj.provider.dimensionId != 1) return;

		if (event.amount == 1.0F && player.getFoodStats().getFoodLevel() >= 18 && !player.isPotionActive(Potion.regeneration)) {
			if (player.worldObj.rand.nextInt(8) <= 3) {
				event.setCanceled(true);
			}
		}
	}
}
