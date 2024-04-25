package com.NovaCraftBlocks.potion;

import net.minecraft.block.*;
import net.minecraft.util.*;

import java.util.Random;

import com.NovaCraft.NovaCraft;
import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.sounds.ModSounds;
import com.NovaCraftBlocks.NovaCraftBlocks;

import cpw.mods.fml.relauncher.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;
import net.minecraft.init.*;
import net.minecraft.item.Item;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.client.renderer.texture.*;

public class BlockCrackedVaniteCauldron extends Block
{
    
    @SideOnly(Side.CLIENT)
	private IIcon iconFace, iconTop;
    
    public BlockCrackedVaniteCauldron() {
        super(Material.iron);
        this.setHardness(12);
		this.setResistance(55);
		//this.setLightOpacity(0);
		this.setStepSound(ModSounds.soundNullstone);
		setHarvestLevel("pickaxe", 3);
    }
    
    @Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta){
		return side == 0 || side == 1 ? iconTop : meta >= 1 && side-1 == meta ? iconFace : blockIcon;
	}
    
    public int quantityDropped(final Random random) {
        return 2 + random.nextInt(2);
    }
 	
 	public Item getItemDropped(final int metadata, final Random rand, final int fortune) {
        return NovaCraftItems.vanite_ingot;
    }
 	
 	@Override
 	public int quantityDroppedWithBonus(int fortune, Random random) {
 		if (fortune > 0 && Item.getItemFromBlock(this) != this.getItemDropped(0, random, fortune)) {
 			int j = random.nextInt(fortune + 2) - 1;

 			if (j < 0) {
 				j = 0;
 			}

 			return this.quantityDropped(random) * (j + 1);
 		} else {
 			return this.quantityDropped(random);
 		}
 	}
 	
 	protected boolean canSilkHarvest()
    {
    	return false;
    }
	 
	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}
    
    @Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister){
		blockIcon = iconRegister.registerIcon("nova_craft:vanite_crystal_cauldron_side");
		iconFace = iconRegister.registerIcon("nova_craft:vanite_crystal_cauldron_bottom");
		iconTop = iconRegister.registerIcon("nova_craft:vanite_crystal_cauldron_top");
	}
}
