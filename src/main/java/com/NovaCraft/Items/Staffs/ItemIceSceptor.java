package com.NovaCraft.Items.Staffs;

import java.util.List;

import com.NovaCraft.entity.EntityIceSceptorProjectile;
import com.NovaCraft.registry.NovaCraftCreativeTabs;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class ItemIceSceptor extends ItemSword {
	
	public ItemIceSceptor() {
		super(ToolMaterial.IRON);
		this.setCreativeTab(NovaCraftCreativeTabs.tools);
		this.setMaxDamage(561);
	}
	
	public void addInformation(final ItemStack stack, final EntityPlayer player, final List tooltip, final boolean who) {
        tooltip.add(EnumChatFormatting.WHITE + "" + StatCollector.translateToLocal("tooltip.ice_sceptor.desc"));
    }
	
	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, final EntityPlayer par3EntityPlayer) {

		boolean flag = par3EntityPlayer.capabilities.isCreativeMode
				|| EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, par1ItemStack) > 0;

		if (flag || par3EntityPlayer.inventory.hasItem(Items.snowball)) {
			float f = 2.0F;

			EntityIceSceptorProjectile entityarrow = new EntityIceSceptorProjectile(par2World, par3EntityPlayer, f * 1.0F) {

				public void onCollideWithPlayer(EntityPlayer entity) {
					super.onCollideWithPlayer(entity);
					int i = MathHelper.floor_double(this.boundingBox.minX + 0.001D);
					int j = MathHelper.floor_double(this.boundingBox.minY + 0.001D);
					int k = MathHelper.floor_double(this.boundingBox.minZ + 0.001D);
					World world = this.worldObj;

					if (true) {
						if (entity instanceof EntityLivingBase)
							((EntityLivingBase) entity).addPotionEffect(new PotionEffect(1, 60, 1));
					}

				}

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
							|| this.worldObj.getBlock(i, j, k - 1) != Blocks.air) {

						this.kill();
					}

				}

			};

			entityarrow.setIsCritical(false);
			entityarrow.setDamage(0.0);
			entityarrow.setKnockbackStrength(3);

			par1ItemStack.damageItem(1, par3EntityPlayer);
			par2World.playSoundAtEntity(par3EntityPlayer, "nova_craft:snow_projectile.step", 2.0F, 2.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);

			if (flag) {
				//entityarrow.canBePickedUp = 2;
			} else {
				par3EntityPlayer.inventory.consumeInventoryItem(Items.snowball);
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
	
	protected String getSnowSound() {
        return "nova_craft:snow_projectile.step";
    }

}
