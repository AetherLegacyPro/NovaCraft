package com.NovaCraft.Items.Tools;

import com.NovaCraft.registry.NovaCraftCreativeTabs;
import com.google.common.collect.Sets;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.UseHoeEvent;
import net.minecraft.item.EnumRarity;
import net.minecraft.util.StatCollector;
import net.minecraft.init.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.block.Block;
import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;
import java.util.Set;
import net.minecraft.item.ItemTool;

public class ItemPherithiumShickaxe extends ItemTool
{
    private static Set blocksEffectiveAgainst;
    
    public ItemPherithiumShickaxe() {
        super(0.0f, NCToolMaterial.PHERITHIUM_SHICKAXE, ItemPherithiumShickaxe.blocksEffectiveAgainst);
        this.setCreativeTab((CreativeTabs)NovaCraftCreativeTabs.tools);
    }
    
    public float func_150893_a(final ItemStack p_150893_1_, final Block p_150893_2_) {
        return (p_150893_2_.getMaterial() != Material.iron && p_150893_2_.getMaterial() != Material.vine && p_150893_2_.getMaterial() != Material.wood && p_150893_2_.getMaterial() != Material.plants && p_150893_2_.getMaterial() != Material.grass && p_150893_2_.getMaterial() != Material.anvil && p_150893_2_.getMaterial() != Material.rock) ? super.func_150893_a(p_150893_1_, p_150893_2_) : this.efficiencyOnProperMaterial;
    }
    
    public boolean func_150897_b(final Block p_150897_1_) {
        return p_150897_1_ == Blocks.snow_layer || p_150897_1_ == Blocks.snow || ((p_150897_1_ == Blocks.iron_block) ? (this.toolMaterial.getHarvestLevel() <= 2) : ((p_150897_1_ != Blocks.diamond_block && p_150897_1_ != Blocks.diamond_ore) ? ((p_150897_1_ != Blocks.emerald_ore && p_150897_1_ != Blocks.emerald_block) ? ((p_150897_1_ != Blocks.gold_block && p_150897_1_ != Blocks.gold_ore) ? ((p_150897_1_ != Blocks.iron_block && p_150897_1_ != Blocks.iron_ore) ? ((p_150897_1_ != Blocks.lapis_block && p_150897_1_ != Blocks.lapis_ore) ? ((p_150897_1_ != Blocks.redstone_ore && p_150897_1_ != Blocks.lit_redstone_ore) ? (p_150897_1_.getMaterial() == Material.rock || p_150897_1_.getMaterial() == Material.iron || p_150897_1_.getMaterial() == Material.anvil) : (this.toolMaterial.getHarvestLevel() == 2)) : (this.toolMaterial.getHarvestLevel() >= 1)) : (this.toolMaterial.getHarvestLevel() >= 1)) : (this.toolMaterial.getHarvestLevel()  >= 2)) : (this.toolMaterial.getHarvestLevel()  >= 2)) : (this.toolMaterial.getHarvestLevel() >= 2)));
    }
    
    public boolean onItemUse(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_)
    {
        if (!p_77648_2_.canPlayerEdit(p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_1_))
        {
            return false;
        }
        else
        {
            UseHoeEvent event = new UseHoeEvent(p_77648_2_, p_77648_1_, p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_);
            if (MinecraftForge.EVENT_BUS.post(event))
            {
                return false;
            }

            if (event.getResult() == Result.ALLOW)
            {
                p_77648_1_.damageItem(1, p_77648_2_);
                return true;
            }

            Block block = p_77648_3_.getBlock(p_77648_4_, p_77648_5_, p_77648_6_);

            if (p_77648_7_ != 0 && p_77648_3_.getBlock(p_77648_4_, p_77648_5_ + 1, p_77648_6_).isAir(p_77648_3_, p_77648_4_, p_77648_5_ + 1, p_77648_6_) && (block == Blocks.grass || block == Blocks.dirt))
            {
                Block block1 = Blocks.farmland;
                p_77648_3_.playSoundEffect((double)((float)p_77648_4_ + 0.5F), (double)((float)p_77648_5_ + 0.5F), (double)((float)p_77648_6_ + 0.5F), block1.stepSound.getStepResourcePath(), (block1.stepSound.getVolume() + 1.0F) / 2.0F, block1.stepSound.getPitch() * 0.8F);

                if (p_77648_3_.isRemote)
                {
                    return true;
                }
                else
                {
                    p_77648_3_.setBlock(p_77648_4_, p_77648_5_, p_77648_6_, block1);
                    p_77648_1_.damageItem(1, p_77648_2_);
                    return true;
                }
            }
            else
            {
                return false;
            }
        }
    }
    
    static {
    	ItemPherithiumShickaxe.blocksEffectiveAgainst = Sets.newHashSet((Object[])new Block[] { Blocks.cobblestone, (Block)Blocks.double_stone_slab, (Block)Blocks.stone_slab, Blocks.stone, Blocks.sandstone, Blocks.mossy_cobblestone, Blocks.iron_ore, Blocks.iron_block, Blocks.coal_ore, Blocks.gold_block, Blocks.gold_ore, Blocks.diamond_ore, Blocks.diamond_block, Blocks.ice, Blocks.netherrack, Blocks.lapis_ore, Blocks.lapis_block, Blocks.redstone_ore, Blocks.lit_redstone_ore, Blocks.rail, Blocks.detector_rail, Blocks.golden_rail, Blocks.activator_rail, Blocks.planks, Blocks.bookshelf, Blocks.log, Blocks.log2, (Block)Blocks.chest, Blocks.pumpkin, Blocks.lit_pumpkin, (Block)Blocks.grass, Blocks.dirt, (Block)Blocks.sand, Blocks.gravel, Blocks.snow_layer, Blocks.snow, Blocks.clay, Blocks.farmland, Blocks.soul_sand, (Block)Blocks.mycelium });
    }
}

