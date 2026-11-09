package com.NovaCraft.Items;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import com.NovaCraft.entity.EntitiesNovaCraft;
import com.NovaCraft.entity.EntitiesNovaCraft.NovaCraftEggInfo;
import com.NovaCraft.registry.NovaCraftCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Facing;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemNovaCraftSpawnEgg extends Item {

	public static HashMap<Integer, NovaCraftEggInfo> entityEggs = new LinkedHashMap<Integer, NovaCraftEggInfo>();

	@SideOnly(Side.CLIENT)
	private IIcon theIcon;

	public ItemNovaCraftSpawnEgg() {
		this.setHasSubtypes(true);
		this.setCreativeTab(NovaCraftCreativeTabs.items);
	}

	@Override
	public String getItemStackDisplayName(ItemStack stack) {
		String s = ("" + StatCollector.translateToLocal(this.getUnlocalizedName() + ".name")).trim();
		String s1 = EntitiesNovaCraft.getStringFromID(stack.getItemDamage());

		if (s1 != null) {
			s = s + " " + StatCollector.translateToLocal("entity." + s1 + ".name");
		}

		return s;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getColorFromItemStack(ItemStack itemStack, int p_82790_2_) {
		NovaCraftEggInfo entityegginfo = entityEggs.get(Integer.valueOf(itemStack.getItemDamage()));

		return entityegginfo != null ? (p_82790_2_ == 0 ? entityegginfo.primaryColor : entityegginfo.secondaryColor) : 16777215;
	}

	@Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
		if (world.isRemote) {
			return true;
		} else {
			Block block = world.getBlock(p_77648_4_, p_77648_5_, p_77648_6_);
			p_77648_4_ += Facing.offsetsXForSide[p_77648_7_];
			p_77648_5_ += Facing.offsetsYForSide[p_77648_7_];
			p_77648_6_ += Facing.offsetsZForSide[p_77648_7_];
			double d0 = 0.0D;

			if (p_77648_7_ == 1 && block.getRenderType() == 11) {
				d0 = 0.5D;
			}

			Entity entity = spawnCreature(world, itemStack.getItemDamage(), (double) p_77648_4_ + 0.5D, (double) p_77648_5_ + d0, (double) p_77648_6_ + 0.5D);

			if (entity != null) {
				if (entity instanceof EntityLivingBase && itemStack.hasDisplayName()) {
					((EntityLiving) entity).setCustomNameTag(itemStack.getDisplayName());
				}

				if (!player.capabilities.isCreativeMode) {
					--itemStack.stackSize;
				}
			}

			return true;
		}
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
		if (world.isRemote) {
			return itemStack;
		} else {
			MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(world, player, true);

			if (movingobjectposition == null) {
				return itemStack;
			} else {
				if (movingobjectposition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
					int i = movingobjectposition.blockX;
					int j = movingobjectposition.blockY;
					int k = movingobjectposition.blockZ;

					if (!world.canMineBlock(player, i, j, k)) {
						return itemStack;
					}

					if (!player.canPlayerEdit(i, j, k, movingobjectposition.sideHit, itemStack)) {
						return itemStack;
					}

					if (world.getBlock(i, j, k) instanceof BlockLiquid) {
						Entity entity = spawnCreature(world, itemStack.getItemDamage(), (double) i, (double) j, (double) k);

						if (entity != null) {
							if (entity instanceof EntityLivingBase && itemStack.hasDisplayName()) {
								((EntityLiving) entity).setCustomNameTag(itemStack.getDisplayName());
							}

							if (!player.capabilities.isCreativeMode) {
								--itemStack.stackSize;
							}
						}
					}
				}

				return itemStack;
			}
		}
	}

	public static Entity spawnCreature(World world, int p_77840_1_, double p_77840_2_, double p_77840_4_, double p_77840_6_) {
		if (!entityEggs.containsKey(Integer.valueOf(p_77840_1_))) {
			return null;
		} else {
			Entity entity = null;

			for (int j = 0; j < 1; ++j) {
				entity = EntitiesNovaCraft.createEntityByID(p_77840_1_, world);

				if (entity != null && entity instanceof EntityLivingBase) {
					EntityLiving entityliving = (EntityLiving) entity;
					entity.setLocationAndAngles(p_77840_2_, p_77840_4_, p_77840_6_, MathHelper.wrapAngleTo180_float(world.rand.nextFloat() * 360.0F), 0.0F);
					entityliving.rotationYawHead = entityliving.rotationYaw;
					entityliving.renderYawOffset = entityliving.rotationYaw;
					entityliving.onSpawnWithEgg((IEntityLivingData) null);
					world.spawnEntityInWorld(entity);
					entityliving.playLivingSound();
				}
			}

			return entity;
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean requiresMultipleRenderPasses() {
		return true;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamageForRenderPass(int p_77618_1_, int p_77618_2_) {
		return p_77618_2_ > 0 ? this.theIcon : super.getIconFromDamageForRenderPass(p_77618_1_, p_77618_2_);
	}

	@Override
	@SideOnly(Side.CLIENT)
	@SuppressWarnings({"unchecked", "rawtypes"})
	public void getSubItems(Item item, CreativeTabs tabs, List p_150895_3_) {
		Iterator<NovaCraftEggInfo> iterator = entityEggs.values().iterator();

		while (iterator.hasNext()) {
			NovaCraftEggInfo entityegginfo = iterator.next();
			p_150895_3_.add(new ItemStack(item, 1, entityegginfo.spawnedID));
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {
		super.registerIcons(iconRegister);
		this.theIcon = iconRegister.registerIcon(this.getIconString() + "_overlay");
	}

}
