package com.NovaCraft.container;

import net.minecraft.world.*;
import net.minecraft.inventory.*;

import com.NovaCraft.crafting.CraftingAdvancedSmithingTable;
import com.NovaCraftBlocks.NovaCraftBlocks;

import net.minecraft.entity.player.*;
import net.minecraft.item.*;

public class AdvancedSmithingTableContainer extends Container
{
    public InventoryCrafting craftMatrix;
    public IInventory craftResult;
    private final World worldObj;
    private final int posX;
    private final int posY;
    private final int posZ;
    
    public AdvancedSmithingTableContainer(final InventoryPlayer p_i1808_1_, final World p_i1808_2_, final int p_i1808_3_, final int p_i1808_4_, final int p_i1808_5_) {
        this.craftMatrix = new InventoryCrafting((Container)this, 3, 3);
        this.craftResult = (IInventory)new InventoryCraftResult();
        this.worldObj = p_i1808_2_;
        this.posX = p_i1808_3_;
        this.posY = p_i1808_4_;
        this.posZ = p_i1808_5_;
        this.addSlotToContainer((Slot)new SlotCrafting(p_i1808_1_.player, (IInventory)this.craftMatrix, this.craftResult, 0, 124, 35));
        for (int l = 0; l < 3; ++l) {
            for (int i1 = 0; i1 < 3; ++i1) {
                this.addSlotToContainer(new Slot((IInventory)this.craftMatrix, i1 + l * 3, 30 + i1 * 18, 17 + l * 18));
            }
        }
        for (int l = 0; l < 3; ++l) {
            for (int i1 = 0; i1 < 9; ++i1) {
                this.addSlotToContainer(new Slot((IInventory)p_i1808_1_, i1 + l * 9 + 9, 8 + i1 * 18, 84 + l * 18));
            }
        }
        for (int l = 0; l < 9; ++l) {
            this.addSlotToContainer(new Slot((IInventory)p_i1808_1_, l, 8 + l * 18, 142));
        }
        this.onCraftMatrixChanged((IInventory)this.craftMatrix);
    }
    
    public boolean canInteractWith(final EntityPlayer p_75145_1_) {
        return this.worldObj.getBlock(this.posX, this.posY, this.posZ) == NovaCraftBlocks.advanced_smithing_table && p_75145_1_.getDistanceSq(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5) <= 64.0;
    }
    
    public boolean func_94530_a(final ItemStack p_94530_1_, final Slot p_94530_2_) {
        return p_94530_2_.inventory != this.craftResult && super.func_94530_a(p_94530_1_, p_94530_2_);
    }
    
    public void onContainerClosed(final EntityPlayer p_75134_1_) {
        super.onContainerClosed(p_75134_1_);
        if (!this.worldObj.isRemote) {
            for (int i = 0; i < 9; ++i) {
                final ItemStack itemstack = this.craftMatrix.getStackInSlotOnClosing(i);
                if (itemstack != null) {
                    p_75134_1_.dropPlayerItemWithRandomChoice(itemstack, false);
                }
            }
        }
    }
    
    public void onCraftMatrixChanged(final IInventory p_75130_1_) {
        this.craftResult.setInventorySlotContents(0, CraftingAdvancedSmithingTable.getInstance().findMatchingRecipe(this.craftMatrix, this.worldObj));
    }
    
    public ItemStack transferStackInSlot(final EntityPlayer p_82846_1_, final int p_82846_2_) {
        ItemStack itemstack = null;
        final Slot slot = (Slot) this.inventorySlots.get(p_82846_2_);
        if (slot != null && slot.getHasStack()) {
            final ItemStack itemstack2 = slot.getStack();
            itemstack = itemstack2.copy();
            if (p_82846_2_ == 0) {
                if (!this.mergeItemStack(itemstack2, 10, 46, true)) {
                    return null;
                }
                slot.onSlotChange(itemstack2, itemstack);
            }
            else if (p_82846_2_ >= 10 && p_82846_2_ < 37) {
                if (!this.mergeItemStack(itemstack2, 37, 46, false)) {
                    return null;
                }
            }
            else if (p_82846_2_ >= 37 && p_82846_2_ < 46) {
                if (!this.mergeItemStack(itemstack2, 10, 37, false)) {
                    return null;
                }
            }
            else if (!this.mergeItemStack(itemstack2, 10, 46, false)) {
                return null;
            }
            if (itemstack2.stackSize == 0) {
                slot.putStack((ItemStack)null);
            }
            else {
                slot.onSlotChanged();
            }
            if (itemstack2.stackSize == itemstack.stackSize) {
                return null;
            }
            slot.onPickupFromSlot(p_82846_1_, itemstack2);
        }
        return itemstack;
    }
}

