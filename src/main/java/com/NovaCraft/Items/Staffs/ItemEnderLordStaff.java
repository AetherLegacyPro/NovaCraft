package com.NovaCraft.Items.Staffs;

import java.util.List;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.achievements.AchievementsNovaCraft;
import com.NovaCraft.entity.EntityEnderLordStaffProjectile;
import com.NovaCraft.registry.NovaCraftCreativeTabs;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class ItemEnderLordStaff extends ItemSword {

	public ItemEnderLordStaff() {
		super(ToolMaterial.EMERALD);
		this.setCreativeTab(NovaCraftCreativeTabs.tools);
		this.setMaxDamage(5861);
	}

	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		return repair.getItem() == NovaCraftItems.fractured_heart_of_the_end;
	}
	
	public void addInformation(final ItemStack stack, final EntityPlayer player, final List tooltip, final boolean who) {
        tooltip.add(EnumChatFormatting.DARK_AQUA + "" + StatCollector.translateToLocal("tooltip.end_staff.desc"));
    }

	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, final EntityPlayer par3EntityPlayer) {

		boolean flag = par3EntityPlayer.capabilities.isCreativeMode
				|| EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, par1ItemStack) > 0;

		if (flag || par3EntityPlayer.inventory.hasItem(Items.ender_pearl)) {
			float f = 1.5F;

			EntityEnderLordStaffProjectile entityarrow = new EntityEnderLordStaffProjectile(par2World, par3EntityPlayer, f * 2.0F) {


				public void onUpdate() {
					super.onUpdate();
					int i = MathHelper.floor_double(this.boundingBox.minX + 0.001D);
					int j = MathHelper.floor_double(this.boundingBox.minY + 0.001D);
					int k = MathHelper.floor_double(this.boundingBox.minZ + 0.001D);
					World world = this.worldObj;
					Entity entity = (Entity) par3EntityPlayer;

					if (this.worldObj.getBlock(i, j, k) != Blocks.air || this.worldObj.getBlock(i, j - 1, k) != Blocks.air
							|| this.worldObj.getBlock(i, j + 1, k) != Blocks.air || this.worldObj.getBlock(i + 1, j, k) != Blocks.air
							|| this.worldObj.getBlock(i - 1, j, k) != Blocks.air || this.worldObj.getBlock(i, j, k + 1) != Blocks.air
							|| this.worldObj.getBlock(i, j, k - 1) != Blocks.air
							
							|| this.worldObj.getBlock(i + 1, j, k - 1) != Blocks.air
							|| this.worldObj.getBlock(i - 1, j, k - 1) != Blocks.air
							|| this.worldObj.getBlock(i, j + 1, k - 1) != Blocks.air
							|| this.worldObj.getBlock(i, j - 1, k - 1) != Blocks.air
							
							|| this.worldObj.getBlock(i + 1, j, k + 1) != Blocks.air
							|| this.worldObj.getBlock(i - 1, j, k + 1) != Blocks.air
							|| this.worldObj.getBlock(i, j + 1, k + 1) != Blocks.air
							|| this.worldObj.getBlock(i, j - 1, k + 1) != Blocks.air) {

						if (true) {
							if (entity instanceof EntityPlayer)
								((EntityPlayer) entity).setPositionAndUpdate(i, j, k);
						}

						this.kill();
					}

				}

			};

			par1ItemStack.damageItem(1, par3EntityPlayer);
			par3EntityPlayer.triggerAchievement(AchievementsNovaCraft.true_teleportation);
			par2World.playSoundAtEntity(par3EntityPlayer, "portal.portal", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);

			if (flag) {
				//entityarrow.canBePickedUp = 2;
			} else {
				par3EntityPlayer.inventory.consumeInventoryItem(Items.ender_pearl);
			}

			if (!par2World.isRemote) {
				par2World.spawnEntityInWorld(entityarrow);
			}
			World world = par2World;
			EntityPlayer entity = par3EntityPlayer;
			int i = (int) entity.posX;
			int j = (int) entity.posY;
			int k = (int) entity.posZ;

		}

		return par1ItemStack;
	}

}
