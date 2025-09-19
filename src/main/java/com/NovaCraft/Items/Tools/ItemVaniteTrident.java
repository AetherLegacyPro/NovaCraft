package com.NovaCraft.Items.Tools;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;

import java.util.List;

import com.NovaCraft.NovaCraft;
import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.entity.EntityFireProofItemNovaCraft;
import com.NovaCraft.entity.misc.EntityVaniteTrident;
import com.NovaCraft.registry.NovaCraftCreativeTabs;
import com.google.common.collect.Multimap;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemVaniteTrident extends ItemBow {

	@SideOnly(Side.CLIENT)
	private IIcon[] iconArray;
	private float field_150934_a;
	private final Item.ToolMaterial field_150933_b;

	public ItemVaniteTrident(Item.ToolMaterial p_i45356_1_) {
		super();
		this.maxStackSize = 1;
		this.setFull3D();
		this.setTextureName(NovaCraft.find("vanite_trident"));
		this.setCreativeTab(NovaCraftCreativeTabs.tools);
		this.field_150933_b = p_i45356_1_;
		this.field_150934_a = 8.0F + p_i45356_1_.getDamageVsEntity();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getItemIconForUseDuration(int p_94599_1_) {
		return this.iconArray[p_94599_1_];
	}
	
	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		return repair.getItem() == NovaCraftItems.reinforced_vanite_ingot;
	}
	
	public void addInformation(final ItemStack stack, final EntityPlayer player, final List tooltip, final boolean who) {
        tooltip.add(EnumChatFormatting.LIGHT_PURPLE + "" + StatCollector.translateToLocal("tooltip.vanite_trident.desc"));
    }

	@Override
	public IIcon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining) {
		if (usingItem != null && stack.getItem() == NovaCraftItems.vanite_trident) {
			int j = stack.getMaxItemUseDuration() - useRemaining;

			if (j >= 18) {
				return this.getItemIconForUseDuration(2);
			}

			if (j > 13) {
				return this.getItemIconForUseDuration(1);
			}

			if (j > 0) {
				return this.getItemIconForUseDuration(0);
			}
		}

		return getIcon(stack, renderPass);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister p_94581_1_) {
		this.itemIcon = p_94581_1_.registerIcon(NovaCraft.find("vanite_trident"));
		this.iconArray = new IIcon[bowPullIconNameArray.length];

		for (int i = 0; i < this.iconArray.length; ++i) {
			this.iconArray[i] = p_94581_1_.registerIcon(this.getIconString() + "_" + bowPullIconNameArray[i]);
		}
	}

	private ItemStack findAmmo(EntityPlayer player) {
		for (int i = 0; i < player.inventory.getSizeInventory(); ++i) {
			ItemStack itemstack = player.inventory.getStackInSlot(i);

			if (this.isArrow(itemstack)) {
				return itemstack;
			}
		}

		return null;
	}

	protected boolean isArrow(ItemStack stack) {
		return stack != null && stack.getItem() == NovaCraftItems.vanite_trident;
	}

	@Override
	public void onPlayerStoppedUsing(ItemStack stack, World worldIn, EntityPlayer entityLiving, int timeLeft) {
		if (entityLiving instanceof EntityPlayer) {
			EntityPlayer entityplayer = (EntityPlayer) entityLiving;

			ItemStack itemstack = this.findAmmo(entityplayer);

			int i = this.getMaxItemUseDuration(stack) - timeLeft;
			ArrowLooseEvent event = new ArrowLooseEvent(entityplayer, stack, i);
			MinecraftForge.EVENT_BUS.post(event);

			if (event.isCanceled()) {
				return;
			}

			i = event.charge;
			if (i < 0) return;

			if (itemstack != null) {  
				
				itemstack = new ItemStack(NovaCraftItems.vanite_trident);

				float f = getArrowVelocity(i);

				if ((double) f >= 0.1D) {
					boolean flag1 = entityplayer.capabilities.isCreativeMode;

					if (!worldIn.isRemote) {
						EntityVaniteTrident entitytrident = this.createArrow(worldIn, f * 1.5F, itemstack, entityplayer);
						
						entitytrident.setDamage(entitytrident.getDamage() + (double) f * 1.0D + 1.0D);

						int j = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, stack);

						if (j > 0) {
							entitytrident.setDamage(entitytrident.getDamage() + (double) j * 0.6D + 0.6D);
						}

						int k = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, stack);

						int l = EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, stack);

						if (l > 0)
						{
							entitytrident.setFire(2400);
						}

						if (flag1) {
							entitytrident.canBePickedUp = 1;
						}

						worldIn.spawnEntityInWorld(entitytrident);
					}

					worldIn.playSoundAtEntity(entityLiving, "nova_craft:trident.thrown", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);

					entityplayer.inventory.consumeInventoryItem(itemstack.getItem());
				}
			}
		}
	}

	public EntityVaniteTrident createArrow(World worldIn, float distance, ItemStack stack, EntityLivingBase shooter) {
		EntityVaniteTrident entityVaniteTrident = new EntityVaniteTrident(worldIn, shooter, distance);

		return entityVaniteTrident;
	}

	public static float getArrowVelocity(int charge) {
		float f = (float) charge / 20.0F;
		f = (f * f + f * 2.0F) / 3.0F;

		if (f > 1.0F) {
			f = 1.0F;
		}

		return f;
	}

	@Override
	public int getMaxItemUseDuration(ItemStack stack) {
		return 72000;
	}

	@Override
	public EnumAction getItemUseAction(ItemStack stack) {
		return EnumAction.bow;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack heldItem, World worldIn, EntityPlayer playerIn) {
		boolean flag = this.findAmmo(playerIn) != null;

		ArrowNockEvent event = new ArrowNockEvent(playerIn, heldItem);
		MinecraftForge.EVENT_BUS.post(event);
		if (event.isCanceled()) {
			return event.result;
		}

		if (flag) {
			playerIn.setItemInUse(heldItem, this.getMaxItemUseDuration(heldItem));
		}

		return heldItem;
	}
	
	 public Multimap getItemAttributeModifiers()
	    {
	        Multimap multimap = super.getItemAttributeModifiers();
	        multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(field_111210_e, "Weapon modifier", (double)this.field_150934_a, 0));
	        return multimap;
	    }
	
	public boolean hasCustomEntity(final ItemStack stack) {
        return true;
    }
    
    public Entity createEntity(final World world, final Entity location, final ItemStack itemstack) {
        return (Entity)new EntityFireProofItemNovaCraft(world, location, itemstack);
    }

	@Override
	public int getItemEnchantability() {
		return 1;
	}
	
	protected String getThrownSound()
    {
        return "nova_craft:trident.thrown";
    }

}

