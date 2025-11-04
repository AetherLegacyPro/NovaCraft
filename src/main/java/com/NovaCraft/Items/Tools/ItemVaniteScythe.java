package com.NovaCraft.Items.Tools;

import com.NovaCraft.entity.EntityCorruptist;
import com.NovaCraft.entity.EntityFireProofItemNovaCraft;
import com.NovaCraft.registry.NovaCraftCreativeTabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import java.util.List;

public class ItemVaniteScythe extends ItemSword {
    public ItemVaniteScythe() {
        super(NCToolMaterial.VANITE_SCYTHE);
        this.setCreativeTab(NovaCraftCreativeTabs.tools);
    }

    public boolean hasCustomEntity(final ItemStack stack) {
        return true;
    }

    public Entity createEntity(final World world, final Entity location, final ItemStack itemstack) {
        return (Entity)new EntityFireProofItemNovaCraft(world, location, itemstack);
    }

    public void addInformation(final ItemStack stack, final EntityPlayer player, final List tooltip, final boolean who) {
        tooltip.add(EnumChatFormatting.AQUA + "" + StatCollector.translateToLocal("tooltip.vanite_scythe.desc"));
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
        if(entity instanceof EntityLivingBase)((EntityLivingBase)entity).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 120, 2));
        if(entity instanceof EntityLivingBase)((EntityLivingBase)entity).addPotionEffect(new PotionEffect(Potion.wither.id, 40, 0));
        return false;
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase living) {
        EntityPlayer entityPlayer = (EntityPlayer) living;
        int rand = (int)(1 + Math.random() * 6);
        switch (rand) {
            case 1:
                if (entityPlayer.getHealth() < entityPlayer.getMaxHealth()) {
                    entityPlayer.heal(2.0F);
                }
                break;
            case 2:
                break;
            default:
                break;
        }
        return super.hitEntity(stack, target, living);
    }
}
