package com.NovaCraft.Items.Tools;

import com.NovaCraft.registry.NovaCraftCreativeTabs;
import com.google.common.collect.Sets;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.UseHoeEvent;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.init.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.block.Block;
import cpw.mods.fml.common.eventhandler.Event.Result;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;
import java.util.Set;
import net.minecraft.item.ItemTool;

public class ItemReinforcedPherithiumShickaxe extends ItemTool
{
    private static Set blocksEffectiveAgainst;
    
    public ItemReinforcedPherithiumShickaxe() {
        super(0.0f, NCToolMaterial.REINFORCED_PHERITHIUM_SHICKAXE, ItemReinforcedPherithiumShickaxe.blocksEffectiveAgainst);
        this.setCreativeTab((CreativeTabs)NovaCraftCreativeTabs.tools);
    }
    
    public float func_150893_a(final ItemStack itemStack, final Block block) {
        return (block.getMaterial() != Material.iron && block.getMaterial() != Material.vine && block.getMaterial() != Material.wood && block.getMaterial() != Material.plants && block.getMaterial() != Material.grass && block.getMaterial() != Material.anvil && block.getMaterial() != Material.rock) ? super.func_150893_a(itemStack, block) : this.efficiencyOnProperMaterial;
    }
    
    public boolean func_150897_b(final Block block) {
        return block == Blocks.snow_layer || block == Blocks.snow || ((block == Blocks.obsidian) ? (this.toolMaterial.getHarvestLevel() >= 3) : ((block != Blocks.diamond_block && block != Blocks.diamond_ore) ? ((block != Blocks.emerald_ore && block != Blocks.emerald_block) ? ((block != Blocks.gold_block && block != Blocks.gold_ore) ? ((block != Blocks.iron_block && block != Blocks.iron_ore) ? ((block != Blocks.lapis_block && block != Blocks.lapis_ore) ? ((block != Blocks.redstone_ore && block != Blocks.lit_redstone_ore) ? (block.getMaterial() == Material.rock || block.getMaterial() == Material.iron || block.getMaterial() == Material.anvil) : (this.toolMaterial.getHarvestLevel() >= 2)) : (this.toolMaterial.getHarvestLevel() >= 1)) : (this.toolMaterial.getHarvestLevel() >= 1)) : (this.toolMaterial.getHarvestLevel() >= 2)) : (this.toolMaterial.getHarvestLevel() >= 2)) : (this.toolMaterial.getHarvestLevel() >= 2)));
    }
    
    public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World world, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_)
    {
        if (!entityPlayer.canPlayerEdit(p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, itemStack))
        {
            return false;
        }
        else
        {
            UseHoeEvent event = new UseHoeEvent(entityPlayer, itemStack, world, p_77648_4_, p_77648_5_, p_77648_6_);
            if (MinecraftForge.EVENT_BUS.post(event))
            {
                return false;
            }

            if (event.getResult() == Result.ALLOW)
            {
                itemStack.damageItem(1, entityPlayer);
                return true;
            }

            Block block = world.getBlock(p_77648_4_, p_77648_5_, p_77648_6_);

            if (p_77648_7_ != 0 && world.getBlock(p_77648_4_, p_77648_5_ + 1, p_77648_6_).isAir(world, p_77648_4_, p_77648_5_ + 1, p_77648_6_) && (block == Blocks.grass || block == Blocks.dirt))
            {
                Block block1 = Blocks.farmland;
                world.playSoundEffect((double)((float)p_77648_4_ + 0.5F), (double)((float)p_77648_5_ + 0.5F), (double)((float)p_77648_6_ + 0.5F), block1.stepSound.getStepResourcePath(), (block1.stepSound.getVolume() + 1.0F) / 2.0F, block1.stepSound.getPitch() * 0.8F);

                if (world.isRemote)
                {
                    return true;
                }
                else
                {
                    world.setBlock(p_77648_4_, p_77648_5_, p_77648_6_, block1);
                    itemStack.damageItem(1, entityPlayer);
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
    	ItemReinforcedPherithiumShickaxe.blocksEffectiveAgainst = Sets.newHashSet((Object[])new Block[] { Blocks.cobblestone, (Block)Blocks.double_stone_slab, (Block)Blocks.stone_slab, Blocks.stone, Blocks.sandstone, Blocks.mossy_cobblestone, Blocks.iron_ore, Blocks.iron_block, Blocks.coal_ore, Blocks.gold_block, Blocks.gold_ore, Blocks.diamond_ore, Blocks.diamond_block, Blocks.ice, Blocks.netherrack, Blocks.lapis_ore, Blocks.lapis_block, Blocks.redstone_ore, Blocks.lit_redstone_ore, Blocks.rail, Blocks.detector_rail, Blocks.golden_rail, Blocks.activator_rail, Blocks.planks, Blocks.bookshelf, Blocks.log, Blocks.log2, (Block)Blocks.chest, Blocks.pumpkin, Blocks.lit_pumpkin, (Block)Blocks.grass, Blocks.dirt, (Block)Blocks.sand, Blocks.gravel, Blocks.snow_layer, Blocks.snow, Blocks.clay, Blocks.farmland, Blocks.soul_sand, (Block)Blocks.mycelium });
    }
    
    public void addInformation(final ItemStack stack, final EntityPlayer player, final List tooltip, final boolean who) {
        tooltip.add(EnumChatFormatting.GREEN + "" + StatCollector.translateToLocal("tooltip.pherithium_shickaxe.desc"));
    }
}
