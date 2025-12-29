package com.NovaCraft.container;

import com.NovaCraft.TileEntity.TileEntityIridiumFurnace;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

public class IridiumFurnaceContainer extends Container {

    private TileEntityIridiumFurnace tileFurnace;
    private int lastCookTime;
    private int lastBurnTime;
    private int lastItemBurnTime;

    public IridiumFurnaceContainer(InventoryPlayer playerInv, TileEntityIridiumFurnace tile) {
        this.tileFurnace = tile;

        //Smelting Slot
        this.addSlotToContainer(new Slot(tile, 0, 56, 17));

        //Fuel Slot
        this.addSlotToContainer(new Slot(tile, 1, 56, 53));

        //Main Output
        this.addSlotToContainer(new SlotFurnace(playerInv.player, tile, 2, 116, 35));

        //Special Output
        this.addSlotToContainer(new SlotFurnace(playerInv.player, tile, 3, 147, 35));

        //Inventory
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlotToContainer(
                        new Slot(playerInv, j + i * 9 + 9, 8 + j * 18, 84 + i * 18)
                );
            }
        }

        //Hotbar
        for (int i = 0; i < 9; ++i) {
            this.addSlotToContainer(new Slot(playerInv, i, 8 + i * 18, 142));
        }
    }

    @Override
    public void addCraftingToCrafters(ICrafting crafter) {
        super.addCraftingToCrafters(crafter);
        crafter.sendProgressBarUpdate(this, 0, tileFurnace.furnaceCookTime);
        crafter.sendProgressBarUpdate(this, 1, tileFurnace.furnaceBurnTime);
        crafter.sendProgressBarUpdate(this, 2, tileFurnace.currentItemBurnTime);
    }

    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();

        for (Object obj : this.crafters) {
            ICrafting crafter = (ICrafting) obj;

            if (lastCookTime != tileFurnace.furnaceCookTime)
                crafter.sendProgressBarUpdate(this, 0, tileFurnace.furnaceCookTime);

            if (lastBurnTime != tileFurnace.furnaceBurnTime)
                crafter.sendProgressBarUpdate(this, 1, tileFurnace.furnaceBurnTime);

            if (lastItemBurnTime != tileFurnace.currentItemBurnTime)
                crafter.sendProgressBarUpdate(this, 2, tileFurnace.currentItemBurnTime);
        }

        lastCookTime = tileFurnace.furnaceCookTime;
        lastBurnTime = tileFurnace.furnaceBurnTime;
        lastItemBurnTime = tileFurnace.currentItemBurnTime;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void updateProgressBar(int id, int value) {
        if (id == 0) tileFurnace.furnaceCookTime = value;
        if (id == 1) tileFurnace.furnaceBurnTime = value;
        if (id == 2) tileFurnace.currentItemBurnTime = value;
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return tileFurnace.isUseableByPlayer(player);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int index) {
        ItemStack stack = null;
        Slot slot = (Slot) this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack()) {
            ItemStack stackInSlot = slot.getStack();
            stack = stackInSlot.copy();

            //Outputs
            if (index == 2 || index == 3) {
                if (!this.mergeItemStack(stackInSlot, 4, 40, true))
                    return null;
                slot.onSlotChange(stackInSlot, stack);
            }
            //Input
            else if (index == 0 || index == 1) {
                if (!this.mergeItemStack(stackInSlot, 4, 40, false))
                    return null;
            }
            //Inventory
            else {
                if (FurnaceRecipes.smelting().getSmeltingResult(stackInSlot) != null) {
                    if (!this.mergeItemStack(stackInSlot, 0, 1, false))
                        return null;
                } else if (TileEntityIridiumFurnace.isItemFuel(stackInSlot)) {
                    if (!this.mergeItemStack(stackInSlot, 1, 2, false))
                        return null;
                } else if (index < 31) {
                    if (!this.mergeItemStack(stackInSlot, 31, 40, false))
                        return null;
                } else if (!this.mergeItemStack(stackInSlot, 4, 31, false)) {
                    return null;
                }
            }

            if (stackInSlot.stackSize == 0) {
                slot.putStack(null);
            } else {
                slot.onSlotChanged();
            }

            if (stackInSlot.stackSize == stack.stackSize)
                return null;

            slot.onPickupFromSlot(player, stackInSlot);
        }

        return stack;
    }
}
