package com.NovaCraft;

import java.lang.reflect.Field;
import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.config.Configs;
import com.NovaCraft.world.caves.MapGenCavesOverride;
import com.NovaCraftBlocks.NovaCraftBlocks;
import com.NovaCraftBlocks.potion.NovaCraftLiquids;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.relauncher.ReflectionHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockBed;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayer.EnumStatus;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.util.*;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.client.event.FOVUpdateEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingHealEvent;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;
import net.minecraftforge.event.terraingen.InitMapGenEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class NovaCraftClientEvents {

	private static final Field CREEPER_FUSE_TIME = ReflectionHelper.findField(EntityCreeper.class, "fuseTime", "field_82225_f");
	private static final Field CREEPER_TIME_SINCE_IGNITED = ReflectionHelper.findField(EntityCreeper.class, "timeSinceIgnited", "field_70833_d");

	private static final String[] CAVE_SOUNDS = {"nova_craft:ambient.cave_new1", "nova_craft:ambient.cave_new2", "nova_craft:ambient.cave_new3",
			"nova_craft:ambient.cave_new4", "nova_craft:ambient.cave_new5", "nova_craft:ambient.cave_new6", "nova_craft:ambient.cave_new7",
			"nova_craft:ambient.cave_new8", "nova_craft:ambient.cave_new9", "nova_craft:ambient.cave_new10", "nova_craft:ambient.cave_new11",
			"nova_craft:ambient.cave_new12", "nova_craft:ambient.cave_new13"};


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
			int fuseTime = CREEPER_FUSE_TIME.getInt(creeper);
			int timeSinceIgnited = CREEPER_TIME_SINCE_IGNITED.getInt(creeper);

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
		if (!Configs.enableGlowingObsidian || event.phase != TickEvent.Phase.END || event.world.isRemote) return;

		World world = event.world;
		long time = world.getTotalWorldTime();

		for (Object obj : world.playerEntities) {
			EntityPlayer player = (EntityPlayer) obj;
			int dy = (int) ((time + player.getEntityId()) % 13) - 6;
			int y = (int) player.posY + dy;
			if (y < 1 || y > 255) continue;

			int px = (int) player.posX;
			int pz = (int) player.posZ;
			int layerRadiusSq = 36 - dy * dy;

			for (int x = px - 6; x <= px + 6; x++) {
				int remaining = layerRadiusSq - (x - px) * (x - px);
				if (remaining < 0) continue;

				for (int z = pz - 6; z <= pz + 6; z++) {
					if ((z - pz) * (z - pz) > remaining) continue;

					Chunk chunk = world.getChunkFromBlockCoords(x, z);
					int cx = x & 15;
					int cz = z & 15;

					if (chunk.getBlock(cx, y, cz) == Blocks.obsidian && chunk.getBlock(cx, y - 1, cz) == Blocks.lava && chunk.getBlockMetadata(cx, y - 1, cz) == 0) {
						world.setBlock(x, y, z, NovaCraftBlocks.glowing_obsidian);
					}
				}
			}
		}
	}

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onClientTick(TickEvent.ClientTickEvent event) {
		if (!Configs.enableNewCaveSounds || event.phase != TickEvent.Phase.END) return;

		Minecraft mc = Minecraft.getMinecraft();
		EntityPlayer player = mc.thePlayer;
		if (player == null || mc.theWorld == null || mc.isGamePaused()) return;

		if (player.dimension == -1 || player.dimension == 1) return;

		if (mc.theWorld.rand.nextInt(22000) == 0) {
			int x = MathHelper.floor_double(player.posX);
			int y = MathHelper.floor_double(player.posY);
			int z = MathHelper.floor_double(player.posZ);

			if (mc.theWorld.getBlockLightValue(x, y, z) <= 0 && y < 32) {
				player.playSound(CAVE_SOUNDS[mc.theWorld.rand.nextInt(CAVE_SOUNDS.length)], 1.0F, 1.0F);
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

	@SubscribeEvent
	public void handleBucketFillEvent(final FillBucketEvent event) {
		final ItemStack bucket = new ItemStack(NovaCraftItems.bucket_mercury);
		final World world = event.world;
		final int x = event.target.blockX;
		final int y = event.target.blockY;
		final int z = event.target.blockZ;
		final int meta = world.getBlockMetadata(x, y, z);
		final Fluid fluid = FluidRegistry.lookupFluidForBlock(world.getBlock(x, y, z));
		if (fluid != null && fluid == NovaCraftLiquids.mercury && meta == 0) {
			world.setBlockToAir(x, y, z);
			event.result = bucket;
			event.setResult(Event.Result.ALLOW);
		}
	}
}