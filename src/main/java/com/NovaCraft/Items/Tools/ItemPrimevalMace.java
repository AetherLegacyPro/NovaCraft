package com.NovaCraft.Items.Tools;

import java.util.List;

import com.NovaCraft.entity.EntityFireProofItemNovaCraft;
import com.NovaCraft.registry.NovaCraftCreativeTabs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class ItemPrimevalMace extends ItemSword
{
	public ItemPrimevalMace() {
        super(NCToolMaterial.PRIMEVAL_MACE);
        this.setCreativeTab((CreativeTabs)NovaCraftCreativeTabs.tools);
    }

	public void addInformation(final ItemStack stack, final EntityPlayer player, final List tooltip, final boolean who) {
        tooltip.add(EnumChatFormatting.AQUA + "" + StatCollector.translateToLocal("tooltip.primeval_mace.desc"));
    }
	
	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		return false;
	}
	
	
	@Override
	public boolean hitEntity(ItemStack itemstack, EntityLivingBase entityliving, EntityLivingBase entityliving1) {
		if (entityliving == null || entityliving1 == null) {
			return false;
		}

		String s = EntityList.getEntityString(entityliving);

		if (s != null && s.toLowerCase().contains("warden")) {
			if (entityliving.getHealth() > 0) {
				entityliving.attackEntityFrom(DamageSource.causeMobDamage(entityliving1), 37);
			}
		}
		
		else if (s != null && (s.toLowerCase().contains("sculk_dweller") || s.toLowerCase().contains("sculk_symbiote") || s.toLowerCase().contains("sculk_abomination") 
				|| s.toLowerCase().contains("sculk_duplicator") || s.toLowerCase().contains("sculk_hunger") || s.toLowerCase().contains("sculked_monitor") 
				|| s.toLowerCase().contains("sculk_incinerator") || s.toLowerCase().contains("warden_vessel"))) {
			if (entityliving.getHealth() > 0) {
				entityliving.attackEntityFrom(DamageSource.causeMobDamage(entityliving1), 18);
				((EntityLivingBase)entityliving).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 70, 3));
			}
		}

		return super.hitEntity(itemstack, entityliving, entityliving1);
	}
	
	public boolean hasCustomEntity(final ItemStack stack) {
        return true;
    }
    
    public Entity createEntity(final World world, final Entity location, final ItemStack itemstack) {
        return (Entity)new EntityFireProofItemNovaCraft(world, location, itemstack);
    }
    
    public EnumRarity getRarity(ItemStack itemstack) {
        return EnumRarity.epic;
    }
}
