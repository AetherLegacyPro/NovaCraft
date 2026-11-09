package com.NovaCraft.Items.Staffs;

import com.NovaCraft.Items.Tools.NCToolMaterial;
import com.NovaCraft.entity.EntityFireProofItemNovaCraft;
import com.NovaCraft.registry.NovaCraftCreativeTabs;
import com.NovaCraftBlocks.NovaCraftBlocks;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.*;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import java.util.List;

public class ItemBedrockCleave extends ItemPickaxe {

    public ItemBedrockCleave() {
        super(NCToolMaterial.BEDROCK_CLEAVE);
        this.setCreativeTab(NovaCraftCreativeTabs.tools);
    }


    public boolean hasCustomEntity(final ItemStack stack) {
        return true;
    }

    public Entity createEntity(final World world, final Entity location, final ItemStack itemstack) {
        return (Entity)new EntityFireProofItemNovaCraft(world, location, itemstack);
    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return EnumRarity.rare;
    }

    @Override
    public boolean onItemUse(ItemStack heldItem, EntityPlayer player, World world, int x, int y, int z, int facing, float hitX, float hitY, float hitZ) {
        int meta = world.getBlockMetadata(x, y, z);

        if (world.getBlock(x, y, z) == NovaCraftBlocks.unbreakable_legendary_ore & meta == 0) {
            world.playSoundEffect((double)x + 0.5D, (double)y + 0.5D, (double)z + 0.5D, "nova_craft:unknown.activated", 2.0F, itemRand.nextFloat() * 0.4F + 0.8F);
            heldItem.damageItem(1, player);
            world.setBlock(x, y, z, NovaCraftBlocks.legendary_ore, 0, 2);
            world.addWeatherEffect(new EntityLightningBolt(world, x, y + 1.0D, z));
            if (world.isRemote) {
                for (int i = 0; i < 20; ++i) {
                    double particleX = x + 0.5D + (world.rand.nextDouble() - 0.5D) * 1.5D;
                    double particleY = y + 0.5D + (world.rand.nextDouble() - 0.5D) * 1.5D;
                    double particleZ = z + 0.5D + (world.rand.nextDouble() - 0.5D) * 1.5D;
                    double motionX = (world.rand.nextDouble() - 0.5D) * 0.2D;
                    double motionY = (world.rand.nextDouble() - 0.5D) * 0.2D;
                    double motionZ = (world.rand.nextDouble() - 0.5D) * 0.2D;
                    world.spawnParticle("explode", particleX, particleY, particleZ, motionX, motionY, motionZ);
                }
            }
        } else if (world.getBlock(x, y, z) == NovaCraftBlocks.unbreakable_legendary_ore & meta == 1) {
            world.playSoundEffect((double)x + 0.5D, (double)y + 0.5D, (double)z + 0.5D, "nova_craft:unknown.activated", 2.0F, itemRand.nextFloat() * 0.4F + 0.8F);
            heldItem.damageItem(1, player);
            world.setBlock(x, y, z, NovaCraftBlocks.legendary_ore, 1, 2);
            world.addWeatherEffect(new EntityLightningBolt(world, x, y + 1.0D, z));
            if (world.isRemote) {
                for (int i = 0; i < 20; ++i) {
                    double particleX = x + 0.5D + (world.rand.nextDouble() - 0.5D) * 1.5D;
                    double particleY = y + 0.5D + (world.rand.nextDouble() - 0.5D) * 1.5D;
                    double particleZ = z + 0.5D + (world.rand.nextDouble() - 0.5D) * 1.5D;
                    double motionX = (world.rand.nextDouble() - 0.5D) * 0.2D;
                    double motionY = (world.rand.nextDouble() - 0.5D) * 0.2D;
                    double motionZ = (world.rand.nextDouble() - 0.5D) * 0.2D;
                    world.spawnParticle("explode", particleX, particleY, particleZ, motionX, motionY, motionZ);
                }
            }
        } else if (world.getBlock(x, y, z) == NovaCraftBlocks.unbreakable_legendary_ore & meta == 2) {
            world.playSoundEffect((double)x + 0.5D, (double)y + 0.5D, (double)z + 0.5D, "nova_craft:unknown.activated", 2.0F, itemRand.nextFloat() * 0.4F + 0.8F);
            heldItem.damageItem(1, player);
            world.setBlock(x, y, z, NovaCraftBlocks.legendary_ore, 2, 2);
            world.addWeatherEffect(new EntityLightningBolt(world, x, y + 1.0D, z));
            if (world.isRemote) {
                for (int i = 0; i < 20; ++i) {
                    double particleX = x + 0.5D + (world.rand.nextDouble() - 0.5D) * 1.5D;
                    double particleY = y + 0.5D + (world.rand.nextDouble() - 0.5D) * 1.5D;
                    double particleZ = z + 0.5D + (world.rand.nextDouble() - 0.5D) * 1.5D;
                    double motionX = (world.rand.nextDouble() - 0.5D) * 0.2D;
                    double motionY = (world.rand.nextDouble() - 0.5D) * 0.2D;
                    double motionZ = (world.rand.nextDouble() - 0.5D) * 0.2D;
                    world.spawnParticle("explode", particleX, particleY, particleZ, motionX, motionY, motionZ);
                }
            }
        }

        return true;
    }

    public void addInformation(final ItemStack stack, final EntityPlayer player, final List tooltip, final boolean who) {
        tooltip.add(EnumChatFormatting.LIGHT_PURPLE + "" + StatCollector.translateToLocal("tooltip.bedrock_cleave.desc"));
    }

}
