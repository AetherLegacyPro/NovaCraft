package com.NovaCraft.Items;

import java.util.List;
import com.NovaCraft.entity.EntityFireProofItemNovaCraft;
import com.NovaCraft.registry.NovaCraftCreativeTabs;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class ItemLegendaryResource extends Item {

    private static final String[] types;
    private IIcon[] textures;

    public ItemLegendaryResource() {

        this.setHasSubtypes(true);
        this.setCreativeTab(NovaCraftCreativeTabs.items);
    }

    public int getMetadata(final int meta) {
        return meta;
    }

    public void registerIcons(final IIconRegister iconRegister) {
        this.textures = new IIcon[ItemLegendaryResource.types.length];
        for (int i = 0; i < ItemLegendaryResource.types.length; ++i) {
            this.textures[i] = iconRegister.registerIcon("nova_craft:" + ItemLegendaryResource.types[i]);
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
        if (meta < 0 || meta >= ItemLegendaryResource.types.length) {
            meta = 0;
        }
        return super.getUnlocalizedName() + "." + ItemLegendaryResource.types[meta];
    }

    public void getSubItems(final Item item, final CreativeTabs creativeTabs, final List list) {
        for (int meta = 0; meta < ItemLegendaryResource.types.length; ++meta) {
            list.add(new ItemStack(item, 1, meta));
        }
    }

    static {
        types = new String[] { "trillint_gemstone", "kreenovite_ingot", "xifersonite_gemstone", "raw_kreenovite", "raw_xifersonite", "explosive_xifersonite" };
    }

    public EnumRarity getRarity(ItemStack stack) {
        return EnumRarity.epic;
    }

    public boolean hasCustomEntity(final ItemStack stack) {
        return true;
    }

    public Entity createEntity(final World world, final Entity location, final ItemStack itemstack) {
        return (Entity)new EntityFireProofItemNovaCraft(world, location, itemstack);
    }

    public void addInformation(final ItemStack stack, final EntityPlayer player, final List tooltip, final boolean who) {
        int meta = stack.getItemDamage();
        if (meta == 3) {
            tooltip.add(EnumChatFormatting.RED + "" + StatCollector.translateToLocal("tooltip.raw_kreenovite_tooltip.desc"));
        }
        else if (meta == 5) {
            tooltip.add(EnumChatFormatting.LIGHT_PURPLE + "" + StatCollector.translateToLocal("tooltip.explosive_ingot.desc"));
        }
    }

    public boolean onEntityItemUpdate(EntityItem item) {
        if (item.posY <= 0.0D && item.getEntityItem().getItem().equals(NovaCraftItems.legendary_resource)  && item.getEntityItem().getItemDamage() == 5) {
            int i = item.getEntityItem().stackSize;
            if (!(item.worldObj.isRemote)) {
                item.worldObj.spawnEntityInWorld(new EntityItem(item.worldObj, item.posX, 1.0D, item.posZ, new ItemStack(NovaCraftItems.legendary_resource, i, 2)));
                item.motionY = 48.0D;
                item.worldObj.playSoundAtEntity(item, "nova_craft:null_explosion", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + 1.0F * 0.5F);

                float f = (item.worldObj.rand.nextFloat() - 0.5F) * 8.0F;
                float f1 = (item.worldObj.rand.nextFloat() - 0.5F) * 4.0F;
                float f2 = (item.worldObj.rand.nextFloat() - 0.5F) * 8.0F;
                item.worldObj.spawnParticle("hugeexplosion", item.posX + (double)f, item.posY + 2.0D + (double)f1, item.posZ + (double)f2, 0.0D, 0.0D, 0.0D);

                item.setDead();
            }
        }

        return false;
    }

}
