package com.NovaCraft.Items.goathorn;

import com.NovaCraft.NovaCraft;
import com.NovaCraft.registry.NovaCraftCreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;
import java.util.List;

public class ItemGoldGoatHorn extends ItemBow {
    @SideOnly(Side.CLIENT)
    private IIcon[] textures;
    private static final String[] types;

    public ItemGoldGoatHorn() {
        super();
        this.setHasSubtypes(true);
        this.maxStackSize = 1;
        this.setMaxDamage(0);
        this.setFull3D();
        this.setTextureName(NovaCraft.find("gold_goat_horn"));
        this.setCreativeTab(NovaCraftCreativeTabs.tools);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getItemIconForUseDuration(int stage) {
        return this.itemIcon;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining) {
        return this.getIconFromDamage(stack.getItemDamage());
    }

    public void getSubItems(final Item item, final CreativeTabs creativeTabs, final List list) {
        for (int meta = 0; meta < ItemGoldGoatHorn.types.length; ++meta) {
            list.add(new ItemStack(item, 1, meta));
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        this.textures = new IIcon[types.length];
        for (int i = 0; i < types.length; ++i) {
            this.textures[i] = iconRegister.registerIcon("nova_craft:" + types[i]);
        }

        this.itemIcon = this.textures[0];
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int meta) {
        if (meta < 0 || meta >= this.textures.length) {
            meta = 0;
        }

        return this.textures[meta];
    }

    @Override
    public void onPlayerStoppedUsing(ItemStack stack, World worldIn, EntityPlayer entityLiving, int timeLeft) {
        int meta = stack.getItemDamage();
        if (entityLiving != null) {
            int i = this.getMaxItemUseDuration(stack) - timeLeft;
            ArrowLooseEvent event = new ArrowLooseEvent(entityLiving, stack, i);
            MinecraftForge.EVENT_BUS.post(event);
            if (meta == 0) {
                worldIn.playSound(((EntityPlayer) entityLiving).posX, ((EntityPlayer) entityLiving).posY, ((EntityPlayer) entityLiving).posZ, "nova_craft:goat.bass.0", 5.0F, 0.8F + this.itemRand.nextFloat() * 0.3F, false);
            }
            else if (meta == 1) {
                worldIn.playSound(((EntityPlayer) entityLiving).posX, ((EntityPlayer) entityLiving).posY, ((EntityPlayer) entityLiving).posZ, "nova_craft:goat.bass.1", 5.0F, 0.8F + this.itemRand.nextFloat() * 0.3F, false);
            }
            else if (meta == 2) {
                worldIn.playSound(((EntityPlayer) entityLiving).posX, ((EntityPlayer) entityLiving).posY, ((EntityPlayer) entityLiving).posZ, "nova_craft:goat.bass.5", 5.0F, 0.8F + this.itemRand.nextFloat() * 0.3F, false);
            }
            else if (meta == 3) {
                worldIn.playSound(((EntityPlayer) entityLiving).posX, ((EntityPlayer) entityLiving).posY, ((EntityPlayer) entityLiving).posZ, "nova_craft:goat.bass.7", 5.0F, 0.8F + this.itemRand.nextFloat() * 0.3F, false);
            }
            else if (meta == 4) {
                worldIn.playSound(((EntityPlayer) entityLiving).posX, ((EntityPlayer) entityLiving).posY, ((EntityPlayer) entityLiving).posZ, "nova_craft:goat.bass.8", 5.0F, 0.8F + this.itemRand.nextFloat() * 0.3F, false);
            }
            else if (meta == 5) {
                worldIn.playSound(((EntityPlayer) entityLiving).posX, ((EntityPlayer) entityLiving).posY, ((EntityPlayer) entityLiving).posZ, "nova_craft:goat.harmony.0", 5.0F, 0.8F + this.itemRand.nextFloat() * 0.3F, false);
            }
            else if (meta == 6) {
                worldIn.playSound(((EntityPlayer) entityLiving).posX, ((EntityPlayer) entityLiving).posY, ((EntityPlayer) entityLiving).posZ, "nova_craft:goat.harmony.1", 5.0F, 0.8F + this.itemRand.nextFloat() * 0.3F, false);
            }
            else if (meta == 7) {
                worldIn.playSound(((EntityPlayer) entityLiving).posX, ((EntityPlayer) entityLiving).posY, ((EntityPlayer) entityLiving).posZ, "nova_craft:goat.harmony.4", 5.0F, 0.8F + this.itemRand.nextFloat() * 0.3F, false);
            }
            else if (meta == 8) {
                worldIn.playSound(((EntityPlayer) entityLiving).posX, ((EntityPlayer) entityLiving).posY, ((EntityPlayer) entityLiving).posZ, "nova_craft:goat.harmony.6", 5.0F, 0.8F + this.itemRand.nextFloat() * 0.3F, false);
            }
            else if (meta == 9) {
                worldIn.playSound(((EntityPlayer) entityLiving).posX, ((EntityPlayer) entityLiving).posY, ((EntityPlayer) entityLiving).posZ, "nova_craft:goat.harmony.9", 5.0F, 0.8F + this.itemRand.nextFloat() * 0.3F, false);
            }
            else if (meta == 10) {
                worldIn.playSound(((EntityPlayer) entityLiving).posX, ((EntityPlayer) entityLiving).posY, ((EntityPlayer) entityLiving).posZ, "nova_craft:goat.melody.0", 5.0F, 0.8F + this.itemRand.nextFloat() * 0.3F, false);
            }
            else if (meta == 11) {
                worldIn.playSound(((EntityPlayer) entityLiving).posX, ((EntityPlayer) entityLiving).posY, ((EntityPlayer) entityLiving).posZ, "nova_craft:goat.melody.1", 5.0F, 0.8F + this.itemRand.nextFloat() * 0.3F, false);
            }
            else if (meta == 12) {
                worldIn.playSound(((EntityPlayer) entityLiving).posX, ((EntityPlayer) entityLiving).posY, ((EntityPlayer) entityLiving).posZ, "nova_craft:goat.melody.5", 5.0F, 0.8F + this.itemRand.nextFloat() * 0.3F, false);
            }
            else if (meta == 13) {
                worldIn.playSound(((EntityPlayer) entityLiving).posX, ((EntityPlayer) entityLiving).posY, ((EntityPlayer) entityLiving).posZ, "nova_craft:goat.melody.7", 5.0F, 0.8F + this.itemRand.nextFloat() * 0.3F, false);
            }
            else if (meta == 14) {
                worldIn.playSound(((EntityPlayer) entityLiving).posX, ((EntityPlayer) entityLiving).posY, ((EntityPlayer) entityLiving).posZ, "nova_craft:goat.melody.8", 5.0F, 0.8F + this.itemRand.nextFloat() * 0.3F, false);
            }
            else if (meta == 15) {
                worldIn.playSound(((EntityPlayer) entityLiving).posX, ((EntityPlayer) entityLiving).posY, ((EntityPlayer) entityLiving).posZ, "nova_craft:goat.melody.9", 5.0F, 0.8F + this.itemRand.nextFloat() * 0.3F, false);
            }
        }
    }

    public String getUnlocalizedName(final ItemStack itemstack) {
        int meta = itemstack.getItemDamage();
        if (meta < 0 || meta >= ItemGoldGoatHorn.types.length) {
            meta = 0;
        }
        return super.getUnlocalizedName() + "." + ItemGoldGoatHorn.types[meta];
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
        ArrowNockEvent event = new ArrowNockEvent(playerIn, heldItem);
        MinecraftForge.EVENT_BUS.post(event);
        if (event.isCanceled()) {
            return event.result;
        }

        playerIn.setItemInUse(heldItem, this.getMaxItemUseDuration(heldItem));
        return heldItem;
    }

    protected float getSoundVolume() {
        return 3.0F;
    }

    static {
        types = new String[] { "gold_goat_horn_black", "gold_goat_horn_red", "gold_goat_horn_green", "gold_goat_horn_brown", "gold_goat_horn_blue", "gold_goat_horn_purple", "gold_goat_horn_cyan", "gold_goat_horn_light_gray", "gold_goat_horn_gray", "gold_goat_horn_pink", "gold_goat_horn_lime", "gold_goat_horn_yellow", "gold_goat_horn_light_blue", "gold_goat_horn_magenta", "gold_goat_horn_orange", "gold_goat_horn_white" };
    }

}
