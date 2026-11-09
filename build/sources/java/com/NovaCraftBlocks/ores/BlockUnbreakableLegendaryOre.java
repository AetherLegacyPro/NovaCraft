package com.NovaCraftBlocks.ores;

import com.NovaCraft.Items.Staffs.ItemBedrockCleave;
import com.NovaCraft.sounds.ModSounds;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class BlockUnbreakableLegendaryOre extends Block {

    private IIcon[] icons = new IIcon[3];
    private static final String[] types;

    public BlockUnbreakableLegendaryOre() {
        super(Material.iron);
        this.setBlockUnbreakable();
        this.setResistance(60000000);
        this.setStepSound(ModSounds.soundNullstone);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(final IIconRegister iconRegister) {
        this.icons[0] = iconRegister.registerIcon("nova_craft:trillint_ore");
        this.icons[1] = iconRegister.registerIcon("nova_craft:kreenovite_ore");
        this.icons[2] = iconRegister.registerIcon("nova_craft:xifesonite_ore");
    }
    @Override
    public IIcon getIcon(final int side, int meta) {
        if (meta < 0 || meta >= this.icons.length) {
            meta = 1;
        }
        return this.icons[meta];
    }

    public void getSubBlocks(final Item block, final CreativeTabs creativeTabs, final List list) {
        for (int i = 0; i < BlockUnbreakableLegendaryOre.types.length; ++i) {
            list.add(new ItemStack(block, 1, i));
        }
    }

    @Override
    public int getLightValue(IBlockAccess world, int x, int y, int z) {
        int meta = world.getBlockMetadata(x, y, z);

        if (meta == 1) {
            return 14;
        }

        return 0;
    }

    static {
        types = new String[] { "trillint_ore", "kreenovite_ore", "xifesonite_ore" };
    }

    @Override
    public boolean canSilkHarvest(World world, EntityPlayer player, int x, int y, int z, int metadata) {
        return false;
    }

    public Item getItemDropped(final int metadata, final Random rand, final int fortune) {
        return null;
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        ItemStack heldItem = player.getCurrentEquippedItem();
        if (heldItem != null && heldItem.getItem() instanceof ItemBedrockCleave) {
            return false;
        }

        if (!world.isRemote) {
            return false;
        }

        int metadata = world.getBlockMetadata(x, y, z);
        String chatMessage;

        if (metadata == 0) {
            chatMessage = "gui.legendary_ore_right_click_overworld.desc";
        }
        else if (metadata == 1) {
            chatMessage = "gui.legendary_ore_right_click_nether.desc";
        }
        else {
            chatMessage = "gui.legendary_ore_right_click_end.desc";
        }

        player.addChatComponentMessage(new ChatComponentText(I18n.format(chatMessage)));

        return true;
    }

    @Override
    public void onBlockClicked(World world, int x, int y, int z, EntityPlayer player) {
        super.onBlockClicked(world, x, y, z, player);

        ItemStack stack = player.inventory.getCurrentItem();
        if (!isPickaxe(stack)) {
            return;
        }

        if (world.isRemote) {
            player.addChatComponentMessage(new ChatComponentText(I18n.format("gui.legendary_ore_hit.desc")));
        }

    }

    private boolean isPickaxe(ItemStack stack) {
        if (stack == null || stack.getItem() == null) {
            return false;
        }

        Item item = stack.getItem();
        if (item instanceof ItemPickaxe) {
            return true;
        }

        String displayName = stack.getDisplayName();
        return displayName != null && displayName.toLowerCase(Locale.ENGLISH).contains("pick");
    }

}
