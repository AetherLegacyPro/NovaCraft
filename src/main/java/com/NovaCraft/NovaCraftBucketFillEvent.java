package com.NovaCraft;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.achievements.AchievementsNovaCraft;
import com.NovaCraftBlocks.potion.NovaCraftLiquids;
import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class NovaCraftBucketFillEvent {

    @SubscribeEvent
    public void handleBucketFillEvent(final FillBucketEvent event) {
        if (event.isCanceled() || event.target == null || event.target.typeOfHit != MovingObjectPosition.MovingObjectType.BLOCK) {
            return;
        }

        final World world = event.world;
        final int x = event.target.blockX;
        final int y = event.target.blockY;
        final int z = event.target.blockZ;

        final int meta = world.getBlockMetadata(x, y, z);
        final Fluid fluid = FluidRegistry.lookupFluidForBlock(world.getBlock(x, y, z));
        if (fluid == null || fluid != NovaCraftLiquids.mercury || meta != 0) {
            return;
        }

        if (!world.isRemote) {
            if (!world.setBlockToAir(x, y, z)) {
                return;
            }

            event.entityPlayer.triggerAchievement(AchievementsNovaCraft.liquid_metal);
        }

        event.result = new ItemStack(NovaCraftItems.bucket_mercury);
        event.setResult(Event.Result.ALLOW);
    }
}
