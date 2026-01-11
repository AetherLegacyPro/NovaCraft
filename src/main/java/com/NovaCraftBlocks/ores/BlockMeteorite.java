package com.NovaCraftBlocks.ores;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.NovaCraft.NovaCraft;
import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.config.Configs;
import com.NovaCraft.config.ConfigsCompact;
import com.NovaCraft.entity.EntityFireProofItemNovaCraft;
import com.NovaCraft.registry.OtherModItems;
import com.NovaCraft.sounds.ModSounds;
import com.NovaCraftBlocks.NovaCraftBlocks;
import com.ibm.icu.impl.duration.impl.Utils;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockMeteorite extends Block {

	@SideOnly(Side.CLIENT)
	private IIcon iconFace, iconTop;
	
	public BlockMeteorite() {
		super(Material.iron);
		this.setHardness(10);
		this.setResistance(35);
		this.setStepSound(ModSounds.soundNullstone);
		this.setHarvestLevel("pickaxe", 2);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta){
		return side == 0 || side == 1 ? iconTop : meta >= 1 && side-1 == meta ? iconFace : blockIcon;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister){
		blockIcon = iconRegister.registerIcon("nova_craft:meteorite_block");
		iconFace = iconRegister.registerIcon("nova_craft:meteorite_block");
		iconTop = iconRegister.registerIcon("nova_craft:meteorite_block");
	}
    
    @Override
    public boolean canSilkHarvest(World world, EntityPlayer player, int x, int y, int z, int metadata) {
        return true;
    }

    @Override
    public ItemStack createStackedBlock(int metadata) {
        return new ItemStack(this, 1, 1);
    }

    @Override
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
        ArrayList<ItemStack> drops = new ArrayList<ItemStack>();
        Random rand = world.rand;

        if (ConfigsCompact.enableRawOreBlocks && Loader.isModLoaded("etfuturum")) {
            int chance = rand.nextInt(100);
            int meta = chance < 70 ? 1 : 2;
            drops.add(new ItemStack(OtherModItems.raw_ore, 1, meta));
        } else {
            drops.add(new ItemStack(this, 1, 1));
        }

        return drops;
    }

	
    @Override
    public int getExpDrop(IBlockAccess world, int metadata, int fortune) {
        Random rand = new Random();

        if (ConfigsCompact.enableRawOreBlocks) {
            return MathHelper.getRandomIntegerInRange(rand, 1, 4);
        }

        return 0;
    }
	
}
