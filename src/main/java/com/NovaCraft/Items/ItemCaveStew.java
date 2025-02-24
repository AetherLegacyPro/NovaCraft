package com.NovaCraft.Items;

import net.minecraft.util.*;
import net.minecraft.world.World;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.item.*;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.creativetab.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;

import java.util.*;

import com.NovaCraft.achievements.AchievementsNovaCraft;
import com.NovaCraft.registry.NovaCraftCreativeTabs;

public class ItemCaveStew extends ItemNovaCraftFood
{
    private static final String[] types;
    private IIcon[] textures;
    
    public ItemCaveStew() {
    	super(8);
    	this.setMaxStackSize(16);
        this.setHasSubtypes(true);
        this.setCreativeTab(NovaCraftCreativeTabs.items);
    }
    
    @Override
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.uncommon;
	}
    
    public int getMetadata(final int meta) {
        return meta;
    }
    
    public void registerIcons(final IIconRegister iconRegister) {
        this.textures = new IIcon[ItemCaveStew.types.length];
        for (int i = 0; i < ItemCaveStew.types.length; ++i) {
            this.textures[i] = iconRegister.registerIcon("nova_craft:" + ItemCaveStew.types[i]);
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
        if (meta < 0 || meta >= ItemCaveStew.types.length) {
            meta = 0;
        }
        return super.getUnlocalizedName() + "." + ItemCaveStew.types[meta];
    }
    
    public void getSubItems(final Item item, final CreativeTabs creativeTabs, final List list) {
        for (int meta = 0; meta < ItemCaveStew.types.length; ++meta) {
            list.add(new ItemStack(item, 1, meta));
        }
    }
    
    static {
        types = new String[] { "cave_stew", "deep_stew", "sculk_stew", "nether_stew", "end_stew", "miners_stew" };
    }
    
    @Override
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
    	int meta = stack.getItemDamage();
    	
    	if (meta == 0) {
    		player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 4800, 0));
    		player.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 4800, 0));
    	} 
    	else if (meta == 1) {
    		player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 4800, 0));
    		player.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 4800, 0));
    	}
    	else if (meta == 2) {
    		player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 4800, 0));
    		player.addPotionEffect(new PotionEffect(Potion.resistance.id, 4800, 0));
    	}
    	else if (meta == 3) {
    		player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 4800, 0));
    	}
    	else if (meta == 4) {
    		player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 4800, 0));
    		player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 2400, 0));
    	}
    	else if (meta == 5) {
    		player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 9600, 0));
    		player.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 9600, 0));
    	}
	}

	public ItemStack onEaten(ItemStack p_77654_1_, World p_77654_2_, EntityPlayer p_77654_3_)
	{
	    super.onEaten(p_77654_1_, p_77654_2_, p_77654_3_);
	    
	    if (p_77654_1_.stackSize >= 1) {	    	
	    p_77654_3_.inventory.addItemStackToInventory(new ItemStack(Items.bowl));
	    
	    }
	    return p_77654_1_.stackSize <= 0 ? new ItemStack(Items.bowl) : p_77654_1_;
	}
	
	public void addInformation(final ItemStack stack, final EntityPlayer player, final List tooltip, final boolean who) {
		int meta = stack.getItemDamage();
		
		if (meta == 0) {
			tooltip.add(EnumChatFormatting.GRAY + "" + StatCollector.translateToLocal("tooltip.cave_stew2.desc"));
			tooltip.add(EnumChatFormatting.GRAY + "" + StatCollector.translateToLocal("tooltip.cave_stew.desc"));
    	} 
    	else if (meta == 1) {
    		tooltip.add(EnumChatFormatting.GRAY + "" + StatCollector.translateToLocal("tooltip.deep_stew2.desc"));
    		tooltip.add(EnumChatFormatting.GRAY + "" + StatCollector.translateToLocal("tooltip.deep_stew.desc"));
    	}
    	else if (meta == 2) {
    		tooltip.add(EnumChatFormatting.GRAY + "" + StatCollector.translateToLocal("tooltip.sculk_stew2.desc"));
    		tooltip.add(EnumChatFormatting.GRAY + "" + StatCollector.translateToLocal("tooltip.sculk_stew.desc"));
    	}
    	else if (meta == 3) {
    		tooltip.add(EnumChatFormatting.GRAY + "" + StatCollector.translateToLocal("tooltip.nether_stew.desc"));
    	}
    	else if (meta == 4) {
    		tooltip.add(EnumChatFormatting.GRAY + "" + StatCollector.translateToLocal("tooltip.end_stew2.desc"));
    		tooltip.add(EnumChatFormatting.GRAY + "" + StatCollector.translateToLocal("tooltip.end_stew.desc"));
    	}
    	else if (meta == 5) {
    		tooltip.add(EnumChatFormatting.GRAY + "" + StatCollector.translateToLocal("tooltip.miners_stew2.desc"));
    		tooltip.add(EnumChatFormatting.GRAY + "" + StatCollector.translateToLocal("tooltip.miners_stew.desc"));
    	}
		
    }
	
	public EnumAction getItemUseAction(ItemStack p_77661_1_)
    {
        return EnumAction.eat;
    }
}
