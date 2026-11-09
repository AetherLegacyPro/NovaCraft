package com.NovaCraft;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraftBlocks.potion.NovaCraftLiquids;
import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class NovaCraftBucketFillEvent {

    @SubscribeEvent
    public void handleBucketFillEvent(final FillBucketEvent event) {
        final ItemStack bucket = new ItemStack(NovaCraftItems.bucket_mercury);
        final World world = event.world;
        final int x = event.target.blockX;
        final int y = event.target.blockY;
        final int z = event.target.blockZ;
        final int meta = world.getBlockMetadata(x, y, z);
        final Fluid fluid = FluidRegistry.lookupFluidForBlock(world.getBlock(x, y, z));
        if (fluid != null && fluid == NovaCraftLiquids.mercury && meta == 0) {
            world.setBlockToAir(x, y, z);
            event.result = bucket;
            event.setResult(Event.Result.ALLOW);
        }
    }
}
