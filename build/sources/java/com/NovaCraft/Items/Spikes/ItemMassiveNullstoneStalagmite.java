package com.NovaCraft.Items.Spikes;

import com.NovaCraft.registry.NovaCraftCreativeTabs;
import com.NovaCraftBlocks.NovaCraftBlocks;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class ItemMassiveNullstoneStalagmite extends Item {

    public ItemMassiveNullstoneStalagmite() {
        this.setCreativeTab(NovaCraftCreativeTabs.items);
        this.maxStackSize = 64;
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
        if (side != 1) {
            return false;
        }

        if (!world.isSideSolid(x, y, z, ForgeDirection.UP)) {
            return false;
        }

        int lowerY = y + 1;
        int upperY = y + 2;

        if (!world.isAirBlock(x, lowerY, z) || !world.isAirBlock(x, upperY, z)) {
            return false;
        }

        if (!player.canPlayerEdit(x, lowerY, z, side, stack) || !player.canPlayerEdit(x, upperY, z, side, stack)) {
            return false;
        }

        Block lowerBlock = NovaCraftBlocks.massive_nullstone_stalagmite_bottom;
        Block upperBlock = NovaCraftBlocks.massive_nullstone_stalagmite_top;

        if (lowerBlock == null || upperBlock == null) {
            return false;
        }

        if (!world.isRemote) {
            world.setBlock(x, lowerY, z, lowerBlock, 0, 3);
            world.setBlock(x, upperY, z, upperBlock, 0, 3);

            world.playSoundEffect(x + 0.5D, lowerY + 0.5D, z + 0.5D, lowerBlock.stepSound.func_150496_b(), (lowerBlock.stepSound.getVolume() + 1.0F) / 2.0F, lowerBlock.stepSound.getPitch() * 0.8F);

            if (!player.capabilities.isCreativeMode) {
                --stack.stackSize;
            }
        }

        return true;
    }
}
