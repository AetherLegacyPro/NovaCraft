package com.NovaCraft.container;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.TileEntity.TileEntityDeepoidBrewingStand;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.*;
import net.minecraft.item.ItemStack;

public class DeepoidBrewingStandContainer extends Container {
    private TileEntityDeepoidBrewingStand tileBrewingStand;
    private int brewTime;

    private final Slot ingredientSlot;

    public DeepoidBrewingStandContainer(InventoryPlayer playerInv, TileEntityDeepoidBrewingStand te) {
        this.tileBrewingStand = te;

        this.addSlotToContainer(new Potion(playerInv.player, te, 0, 56, 46));
        this.addSlotToContainer(new Potion(playerInv.player, te, 1, 79, 53));
        this.addSlotToContainer(new Potion(playerInv.player, te, 2, 102, 46));
        this.ingredientSlot = this.addSlotToContainer(new Ingredient(te, 3, 79, 17));

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlotToContainer(new Slot(playerInv, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (int i = 0; i < 9; ++i) {
            this.addSlotToContainer(new Slot(playerInv, i, 8 + i * 18, 142));
        }
    }

    @Override
    public void addCraftingToCrafters(ICrafting crafter) {
        super.addCraftingToCrafters(crafter);
        crafter.sendProgressBarUpdate(this, 0, tileBrewingStand.getBrewTime());
    }

    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();

        for (Object obj : this.crafters) {
            ICrafting crafter = (ICrafting) obj;
            if (this.brewTime != tileBrewingStand.getBrewTime()) {
                crafter.sendProgressBarUpdate(this, 0, tileBrewingStand.getBrewTime());
            }
        }

        this.brewTime = tileBrewingStand.getBrewTime();
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void updateProgressBar(int id, int value) {
        if (id == 0) {
            this.tileBrewingStand.setBrewTime(value);
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return this.tileBrewingStand.isUseableByPlayer(player);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int index) {
        ItemStack result = null;
        Slot slot = (Slot) this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack()) {
            ItemStack stack = slot.getStack();
            result = stack.copy();

            if (index >= 0 && index <= 2) {
                if (!mergeItemStack(stack, 4, 40, true)) return null;
            } else if (index == 3) {
                if (!mergeItemStack(stack, 4, 40, false)) return null;
            } else {
                if (stack.getItem() == NovaCraftItems.nullwart_blend) {
                    if (!mergeItemStack(stack, 3, 4, false)) return null;
                } else if (stack.getItem() == NovaCraftItems.vanite_bottle || stack.getItem() == NovaCraftItems.potion_fire_resistance_extended || stack.getItem() == NovaCraftItems.potion_haste
                        || stack.getItem() == NovaCraftItems.potion_haste_II || stack.getItem() == NovaCraftItems.potion_resistance || stack.getItem() == NovaCraftItems.potion_jump_extended
                        || stack.getItem() == NovaCraftItems.potion_jump_III || stack.getItem() == NovaCraftItems.potion_invisibility_extended || stack.getItem() == NovaCraftItems.potion_night_vision_extended
                        || stack.getItem() == NovaCraftItems.potion_regen_extended || stack.getItem() == NovaCraftItems.potion_regen_III || stack.getItem() == NovaCraftItems.potion_speed_extended
                        || stack.getItem() == NovaCraftItems.potion_speed_III || stack.getItem() == NovaCraftItems.potion_strength_extended || stack.getItem() == NovaCraftItems.potion_strength_III
                        || stack.getItem() == NovaCraftItems.potion_water_breathing_extended|| stack.getItem() == NovaCraftItems.awkward_potion) {
                    if (!mergeItemStack(stack, 0, 3, false)) return null;
                }
            }

            if (stack.stackSize == 0) slot.putStack(null);
            else slot.onSlotChanged();

            if (stack.stackSize == result.stackSize) return null;
            slot.onPickupFromSlot(player, stack);
        }

        return result;
    }

    class Ingredient extends Slot {
        public Ingredient(IInventory inv, int index, int x, int y) {
            super(inv, index, x, y);
        }

        @Override
        public boolean isItemValid(ItemStack stack) {
            return stack != null && (stack.getItem() == NovaCraftItems.nullwart_blend || stack.getItem() == Items.glowstone_dust
                    || stack.getItem() == NovaCraftItems.pherithium_carrot || stack.getItem() == NovaCraftItems.cave_monitor_scales
                    || stack.getItem() == NovaCraftItems.enflamed_null_cube_slimeball || stack.getItem() == NovaCraftItems.enderavis_feather
                    || stack.getItem() == NovaCraftItems.phoenix_feather || stack.getItem() == NovaCraftItems.deepoid_horn
                    || stack.getItem() == NovaCraftItems.sculk_dweller_heart || stack.getItem() == NovaCraftItems.anomalous_essence
                    || stack.getItem() == NovaCraftItems.brimstone_dust || stack.getItem() == NovaCraftItems.sea_serpent_scales
                    || stack.getItem() == NovaCraftItems.blazing_serpent_tooth || stack.getItem() == NovaCraftItems.sculked_monitor_eye
                    || stack.getItem() == NovaCraftItems.wyrmling_scales || stack.getItem() == NovaCraftItems.glow_ink_sac
                    || stack.getItem() == NovaCraftItems.wardling_dust || stack.getItem() == NovaCraftItems.relik_dust
                    || stack.getItem() == NovaCraftItems.static_essence || stack.getItem() == NovaCraftItems.destitute_tentacle);
        }

        @Override
        public int getSlotStackLimit() {
            return 64;
        }
    }

    static class Potion extends Slot {
        private EntityPlayer player;

        public Potion(EntityPlayer player, IInventory inv, int index, int x, int y) {
            super(inv, index, x, y);
            this.player = player;
        }

        @Override
        public boolean isItemValid(ItemStack stack) {
            return stack != null && (stack.getItem() == NovaCraftItems.vanite_bottle || stack.getItem() == NovaCraftItems.potion_fire_resistance_extended || stack.getItem() == NovaCraftItems.potion_haste
                    || stack.getItem() == NovaCraftItems.potion_haste_II || stack.getItem() == NovaCraftItems.potion_resistance || stack.getItem() == NovaCraftItems.potion_jump_extended
                    || stack.getItem() == NovaCraftItems.potion_jump_III || stack.getItem() == NovaCraftItems.potion_invisibility_extended || stack.getItem() == NovaCraftItems.potion_night_vision_extended
                    || stack.getItem() == NovaCraftItems.potion_regen_extended || stack.getItem() == NovaCraftItems.potion_regen_III || stack.getItem() == NovaCraftItems.potion_speed_extended
                    || stack.getItem() == NovaCraftItems.potion_speed_III || stack.getItem() == NovaCraftItems.potion_strength_extended || stack.getItem() == NovaCraftItems.potion_strength_III
                    || stack.getItem() == NovaCraftItems.potion_water_breathing_extended || stack.getItem() == NovaCraftItems.awkward_potion);
        }

        @Override
        public int getSlotStackLimit() {
            return 1;
        }
    }
}
