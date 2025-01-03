package com.NovaCraft.Items.Armor;

import cpw.mods.fml.common.FMLLog;

import java.util.List;
import java.util.Random;

import org.apache.logging.log4j.Level;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.particles.ParticleHandler;
import com.NovaCraft.registry.NovaCraftCreativeTabs;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemArmor;

public class ItemAncientLeggings extends ItemArmor
{
	
    public ItemAncientLeggings() {
        super(NCArmorMaterial.ANCIENT, 0, 2);
        this.setCreativeTab(NovaCraftCreativeTabs.tools);
    }

	public String getArmorTexture(final ItemStack stack, final Entity entity, final int slot, final String type) {
        if (stack.getItem() == NovaCraftItems.ancient_leggings) {
            return "nova_craft:textures/armor/ancient_leggings_layer_2.png";
        }
        FMLLog.log(Level.ERROR, "Invaild Texture for Ancient Leggings", new Object[0]);
        return null;
    }
    
    public void addInformation(final ItemStack stack, final EntityPlayer player, final List tooltip, final boolean who) {
 	   tooltip.add(EnumChatFormatting.AQUA + "" + StatCollector.translateToLocal("tooltip.ancient_leggings.desc"));
 	}
    
    public Multimap getItemAttributeModifiers() {
        Multimap multimap = HashMultimap.create();
        multimap.put(SharedMonsterAttributes.movementSpeed.getAttributeUnlocalizedName(), new AttributeModifier(field_111210_e, "speed_boost", 1.00D, 2));
        return multimap;
     }
    
    public EnumRarity getRarity(ItemStack itemstack) {
        return EnumRarity.epic;
    }
}
