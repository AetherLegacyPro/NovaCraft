package com.NovaCraftBlocks.ores.vanilla;

import java.util.Random;
import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.registry.NovaCraftCreativeTabs;
import com.NovaCraft.sounds.ModSounds;
import com.NovaCraftBlocks.NovaCraftBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockEtherstoneOre extends Block {

    public BlockEtherstoneOre() {
        super(Material.rock);
        this.setHardness(2);
		this.setResistance(3);
		this.setStepSound(ModSounds.soundEtherstone);
        this.setCreativeTab(NovaCraftCreativeTabs.blocks);
    }

    public Item getItemDropped(int p_149650_1_, Random random, int p_149650_3_) {
        return this == NovaCraftBlocks.etherstone_coal ? Items.coal : (this == NovaCraftBlocks.etherstone_brimstone ? NovaCraftItems.brimstone_dust : (this == NovaCraftBlocks.cinnabar_brimstone ? NovaCraftItems.brimstone_dust : (this == NovaCraftBlocks.etherstone_emerald ? Items.emerald : Item.getItemFromBlock(this))));
    }

    public int quantityDropped(Random random) {
        return this == NovaCraftBlocks.etherstone_brimstone ? 2 + random.nextInt(5) : 1;
    }

    public int quantityDroppedWithBonus(int p_149679_1_, Random random) {
        if (p_149679_1_ > 0 && Item.getItemFromBlock(this) != this.getItemDropped(0, random, p_149679_1_)) {
            int j = random.nextInt(p_149679_1_ + 3) - 1;

            if (j < 0) {
                j = 0;
            }

            return this.quantityDropped(random) * (j + 2);
        }
        else {
            return this.quantityDropped(random);
        }
    }

    public void dropBlockAsItemWithChance(World world, int p_149690_2_, int p_149690_3_, int p_149690_4_, int p_149690_5_, float p_149690_6_, int p_149690_7_) {
        super.dropBlockAsItemWithChance(world, p_149690_2_, p_149690_3_, p_149690_4_, p_149690_5_, p_149690_6_, p_149690_7_);
    }

    private Random rand = new Random();
    @Override
    public int getExpDrop(IBlockAccess iBlockAccess, int p_149690_5_, int p_149690_7_) {
        if (this.getItemDropped(p_149690_5_, rand, p_149690_7_) != Item.getItemFromBlock(this)) {
            int j1 = 0;
            
             if (this == NovaCraftBlocks.etherstone_coal) {
                j1 = MathHelper.getRandomIntegerInRange(rand, 2, 4);
            }
            else if (this == NovaCraftBlocks.etherstone_emerald) {
                j1 = MathHelper.getRandomIntegerInRange(rand, 2, 5);
            }
            else if (this == NovaCraftBlocks.etherstone_brimstone || this == NovaCraftBlocks.cinnabar_brimstone) {
                j1 = MathHelper.getRandomIntegerInRange(rand, 3, 5);
            }

            return j1;
        }
        return 0;
    }    
   
}

