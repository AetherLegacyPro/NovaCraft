package com.NovaCraft.Items.Potions;

import java.util.List;

import com.NovaCraft.Items.ItemNovaCraftFood;
import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.achievements.AchievementsNovaCraft;
import com.NovaCraft.registry.NovaCraftCreativeTabs;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class ItemAwkwardPotion extends ItemNovaCraftFood {

    private static final String[] types;
    private IIcon[] textures;

    public ItemAwkwardPotion() {
        super(0);
        this.setHasSubtypes(true);
        this.setMaxStackSize(4);
        this.setCreativeTab(NovaCraftCreativeTabs.potions);
        this.setAlwaysEdible();
    }

    public int getMetadata(final int meta) {
        return meta;
    }

    public void registerIcons(final IIconRegister iconRegister) {
        this.textures = new IIcon[ItemAwkwardPotion.types.length];
        for (int i = 0; i < ItemAwkwardPotion.types.length; ++i) {
            this.textures[i] = iconRegister.registerIcon("nova_craft:" + ItemAwkwardPotion.types[i]);
        }
    }

    public IIcon getIconFromDamage(int meta) {
        if (meta < 0 || meta >= this.textures.length) {
            meta = 0;
        }
        return this.textures[meta];
    }

    public String getUnlocalizedName(final ItemStack itemstack) {
        int meta = itemstack.getItemDamage();
        if (meta < 0 || meta >= ItemAwkwardPotion.types.length) {
            meta = 0;
        }
        return super.getUnlocalizedName() + "." + ItemAwkwardPotion.types[meta];
    }

    public void getSubItems(final Item item, final CreativeTabs creativeTabs, final List list) {
        for (int meta = 0; meta < ItemAwkwardPotion.types.length; ++meta) {
            list.add(new ItemStack(item, 1, meta));
        }
    }

    static {
        types = new String[] { "awkward_potion", "mundane_haste_potion", "thick_haste_potion", "mundane_resistance_potion", "thick_speed_potion", "thick_regen_potion", "thick_strength_potion", "thick_jump_potion",
        "mundane_strength_potion", "mundane_speed_potion", "mundane_water_breathing_potion", "mundane_fire_resistance_potion",
                "mundane_night_vision_potion", "mundane_regen_potion", "mundane_invisibility_potion", "mundane_jump_potion", "mundane_blindness_potion", "blindness_potion"};
    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return EnumRarity.rare;
    }

    @Override
    public boolean hasEffect(ItemStack stack, int pass) {
        return true;
    }

    @Override
    protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
        int meta = stack.getItemDamage();
        if (meta == 17) {
            player.addPotionEffect(new PotionEffect(Potion.blindness.id, 3600, 0));
        }
    }

    public ItemStack onEaten(ItemStack p_77654_1_, World p_77654_2_, EntityPlayer p_77654_3_)
    {
        super.onEaten(p_77654_1_, p_77654_2_, p_77654_3_);
        p_77654_3_.triggerAchievement(AchievementsNovaCraft.super_buff);

        if (p_77654_1_.stackSize >= 1) {
            p_77654_3_.inventory.addItemStackToInventory(new ItemStack(NovaCraftItems.vanite_bottle));

        }
        return p_77654_1_.stackSize <= 0 ? new ItemStack(NovaCraftItems.vanite_bottle) : p_77654_1_;
    }

    public EnumAction getItemUseAction(ItemStack p_77661_1_)
    {
        return EnumAction.drink;
    }

    public void addInformation(final ItemStack stack, final EntityPlayer player, final List tooltip, final boolean who) {
        int meta = stack.getItemDamage();
        if (meta == 1) {
            tooltip.add(EnumChatFormatting.GRAY + "" + StatCollector.translateToLocal("tooltip.potion.mundane_haste.recipe.desc"));
            tooltip.add(EnumChatFormatting.GRAY + "" + StatCollector.translateToLocal("tooltip.no_effect.desc"));
        }
        else if (meta == 2) {
            tooltip.add(EnumChatFormatting.GRAY + "" + StatCollector.translateToLocal("tooltip.potion.thick_haste.recipe.desc"));
            tooltip.add(EnumChatFormatting.GRAY + "" + StatCollector.translateToLocal("tooltip.no_effect.desc"));
        }
        else if (meta == 3) {
            tooltip.add(EnumChatFormatting.GRAY + "" + StatCollector.translateToLocal("tooltip.potion.mundane_resist.recipe.desc"));
            tooltip.add(EnumChatFormatting.GRAY + "" + StatCollector.translateToLocal("tooltip.no_effect.desc"));
        }
        else if (meta == 4) {
            tooltip.add(EnumChatFormatting.GRAY + "" + StatCollector.translateToLocal("tooltip.potion.thick_speed.recipe.desc"));
            tooltip.add(EnumChatFormatting.GRAY + "" + StatCollector.translateToLocal("tooltip.no_effect.desc"));
        }
        else if (meta == 5) {
            tooltip.add(EnumChatFormatting.GRAY + "" + StatCollector.translateToLocal("tooltip.potion.thick_regen.recipe.desc"));
            tooltip.add(EnumChatFormatting.GRAY + "" + StatCollector.translateToLocal("tooltip.no_effect.desc"));
        }
        else if (meta == 6) {
            tooltip.add(EnumChatFormatting.GRAY + "" + StatCollector.translateToLocal("tooltip.potion.thick_strength.recipe.desc"));
            tooltip.add(EnumChatFormatting.GRAY + "" + StatCollector.translateToLocal("tooltip.no_effect.desc"));
        }
        else if (meta == 7) {
            tooltip.add(EnumChatFormatting.GRAY + "" + StatCollector.translateToLocal("tooltip.potion.thick_jump.recipe.desc"));
            tooltip.add(EnumChatFormatting.GRAY + "" + StatCollector.translateToLocal("tooltip.no_effect.desc"));
        }
        else if (meta == 8) {
            tooltip.add(EnumChatFormatting.GRAY + "" + StatCollector.translateToLocal("tooltip.potion.mundane_strength.recipe.desc"));
            tooltip.add(EnumChatFormatting.GRAY + "" + StatCollector.translateToLocal("tooltip.no_effect.desc"));
        }
        else if (meta == 9) {
            tooltip.add(EnumChatFormatting.GRAY + "" + StatCollector.translateToLocal("tooltip.potion.mundane_speed.recipe.desc"));
            tooltip.add(EnumChatFormatting.GRAY + "" + StatCollector.translateToLocal("tooltip.no_effect.desc"));
        }
        else if (meta == 10) {
            tooltip.add(EnumChatFormatting.GRAY + "" + StatCollector.translateToLocal("tooltip.potion.mundane_water.recipe.desc"));
            tooltip.add(EnumChatFormatting.GRAY + "" + StatCollector.translateToLocal("tooltip.no_effect.desc"));
        }
        else if (meta == 11) {
            tooltip.add(EnumChatFormatting.GRAY + "" + StatCollector.translateToLocal("tooltip.potion.mundane_fire.recipe.desc"));
            tooltip.add(EnumChatFormatting.GRAY + "" + StatCollector.translateToLocal("tooltip.no_effect.desc"));
        }
        else if (meta == 12) {
            tooltip.add(EnumChatFormatting.GRAY + "" + StatCollector.translateToLocal("tooltip.potion.mundane_night.recipe.desc"));
            tooltip.add(EnumChatFormatting.GRAY + "" + StatCollector.translateToLocal("tooltip.no_effect.desc"));
        }
        else if (meta == 13) {
            tooltip.add(EnumChatFormatting.GRAY + "" + StatCollector.translateToLocal("tooltip.potion.mundane_regen.recipe.desc"));
            tooltip.add(EnumChatFormatting.GRAY + "" + StatCollector.translateToLocal("tooltip.no_effect.desc"));
        }
        else if (meta == 14) {
            tooltip.add(EnumChatFormatting.GRAY + "" + StatCollector.translateToLocal("tooltip.potion.mundane_invis.recipe.desc"));
            tooltip.add(EnumChatFormatting.GRAY + "" + StatCollector.translateToLocal("tooltip.no_effect.desc"));
        }
        else if (meta == 15) {
            tooltip.add(EnumChatFormatting.GRAY + "" + StatCollector.translateToLocal("tooltip.potion.mundane_jump.recipe.desc"));
            tooltip.add(EnumChatFormatting.GRAY + "" + StatCollector.translateToLocal("tooltip.no_effect.desc"));
        }
        else if (meta == 16) {
            tooltip.add(EnumChatFormatting.GRAY + "" + StatCollector.translateToLocal("tooltip.potion.mundane_blindness.recipe.desc"));
            tooltip.add(EnumChatFormatting.GRAY + "" + StatCollector.translateToLocal("tooltip.potion.mundane_blindness_other.recipe.desc"));
            tooltip.add(EnumChatFormatting.GRAY + "" + StatCollector.translateToLocal("tooltip.no_effect.desc"));
        }
        else if (meta == 17) {
            tooltip.add(EnumChatFormatting.GRAY + "" + StatCollector.translateToLocal("tooltip.potion.blindness.recipe.desc"));
            tooltip.add(EnumChatFormatting.GRAY + "" + StatCollector.translateToLocal("tooltip.potion.blindness.desc"));
            tooltip.add(EnumChatFormatting.GRAY + "" + StatCollector.translateToLocal("tooltip.potion.warden.desc"));
        } else {
            tooltip.add(EnumChatFormatting.GRAY + "" + StatCollector.translateToLocal("tooltip.no_effect.desc"));
        }
    }

}
