package com.NovaCraftBlocks.ores;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.entity.EntityBlazingSerpentQueen;
import com.NovaCraft.entity.EntityDistortion;
import com.NovaCraft.registry.NovaCraftCreativeTabs;
import com.NovaCraft.sounds.ModSounds;
import com.NovaCraftBlocks.NovaCraftBlocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BlockLegendaryOre extends Block {

    private IIcon[] icons = new IIcon[3];
    private static final String[] types;

    public BlockLegendaryOre() {
        super(Material.iron);
        this.setHardness(60);
        this.setResistance(60000000);
        this.setStepSound(ModSounds.soundNullstone);
        this.setCreativeTab(NovaCraftCreativeTabs.blocks);
        this.setHarvestLevel("pickaxe", 3);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(final IIconRegister iconRegister) {
        this.icons[0] = iconRegister.registerIcon("nova_craft:breakable_trillint_ore");
        this.icons[1] = iconRegister.registerIcon("nova_craft:breakable_kreenovite_ore");
        this.icons[2] = iconRegister.registerIcon("nova_craft:breakable_xifesonite_ore");
    }
    @Override
    public IIcon getIcon(final int side, int meta) {
        if (meta < 0 || meta >= this.icons.length) {
            meta = 1;
        }
        return this.icons[meta];
    }

    public void getSubBlocks(final Item block, final CreativeTabs creativeTabs, final List list) {
        for (int i = 0; i < BlockLegendaryOre.types.length; ++i) {
            list.add(new ItemStack(block, 1, i));
        }
    }

    public int damageDropped(final int meta) {
        return meta;
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
        return true;
    }

    public Item getItemDropped(final int metadata, final Random rand, final int fortune) {
        return NovaCraftItems.legendary_resource;
    }

    @Override
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
        ArrayList<ItemStack> drops = new ArrayList<ItemStack>();

        if (metadata == 0) {
            drops.add(new ItemStack(NovaCraftItems.legendary_resource, 1, 0));
        } else if (metadata == 1) {
            drops.add(new ItemStack(NovaCraftItems.legendary_resource, 1, 3));
        } else {
            drops.add(new ItemStack(NovaCraftItems.legendary_resource, 1, 4));
        }

        return drops;
    }

    public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int p_149664_5_) {
        if (!world.isRemote) {
            if (world.rand.nextBoolean()) {
                world.playSoundEffect(x, y, z, "nova_craft:ambient.cave_new12", 2.0F, 0.8F + world.rand.nextFloat() * 0.4F);
            }
            else if (world.rand.nextBoolean()) {
                world.playSoundEffect(x, y, z, "nova_craft:ambient.cave_new11", 2.0F, 0.8F + world.rand.nextFloat() * 0.4F);
            }
            else {
                world.playSoundEffect(x, y, z, "nova_craft:ambient.cave_new10", 2.0F, 0.8F + world.rand.nextFloat() * 0.4F);
            }

            if (world.rand.nextBoolean()) {
                world.setBlock(x, y, z, Blocks.air, 0, 2);
                EntityDistortion distortion = new EntityDistortion(world);
                distortion.setLocationAndAngles(x, y + 1, z, 0.0F, 0.0F);
                world.spawnEntityInWorld(distortion);
                distortion.spawnExplosionParticle();
            }
        }
    }

    @Override
    public int getExpDrop(IBlockAccess iBlockAccess, int p_149690_5_, int p_149690_7_) {
        Random random = new Random();

        if (this.getItemDropped(p_149690_5_, random, p_149690_7_) != Item.getItemFromBlock(this)) {
            int amount = 0;

            amount = MathHelper.getRandomIntegerInRange(random, 128, 256);


            return amount;
        }

        return 0;
    }

}
