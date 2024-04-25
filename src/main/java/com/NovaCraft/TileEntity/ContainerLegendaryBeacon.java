package com.NovaCraft.TileEntity;

import net.minecraft.tileentity.*;
import net.minecraft.inventory.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;

public class ContainerLegendaryBeacon extends ContainerBeacon
{
    private TileEntityLegendaryBeacon tileBeacon;
    private final LegendaryBeaconSlot beaconSlot;
    private int field_82865_g;
    private int field_82867_h;
    private int field_82868_i;
    
    public ContainerLegendaryBeacon(final InventoryPlayer p_i1802_1_, final TileEntityLegendaryBeacon p_i1802_2_) {
        super(p_i1802_1_, (TileEntityBeacon)p_i1802_2_);
        this.tileBeacon = p_i1802_2_;
        this.addSlotToContainer((Slot)(this.beaconSlot = new LegendaryBeaconSlot((IInventory)p_i1802_2_, 0, 136, 110)));
        final byte b0 = 36;
        final short short1 = 137;
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlotToContainer(new Slot((IInventory)p_i1802_1_, j + i * 9 + 9, b0 + j * 18, short1 + i * 18));
            }
        }
        for (int i = 0; i < 9; ++i) {
            this.addSlotToContainer(new Slot((IInventory)p_i1802_1_, i, b0 + i * 18, 58 + short1));
        }
        this.field_82865_g = this.tileBeacon.getLevels();
        this.field_82867_h = this.tileBeacon.getPrimaryEffect();
        this.field_82868_i = this.tileBeacon.getSecondaryEffect();
    }
    
    public void addCraftingToCrafters(final ICrafting p_75132_1_) {
        this.field_82865_g = this.tileBeacon.getLevels();
        this.field_82867_h = this.tileBeacon.getPrimaryEffect();
        this.field_82868_i = this.tileBeacon.getSecondaryEffect();
        super.addCraftingToCrafters(p_75132_1_);
        p_75132_1_.sendProgressBarUpdate((Container)this, 0, this.field_82865_g);
        p_75132_1_.sendProgressBarUpdate((Container)this, 1, this.field_82867_h);
        p_75132_1_.sendProgressBarUpdate((Container)this, 2, this.field_82868_i);
    }
    
    @SideOnly(Side.CLIENT)
    public void updateProgressBar(final int p_75137_1_, final int p_75137_2_) {
        if (p_75137_1_ == 0) {
            this.tileBeacon.func_146005_c(p_75137_2_);
        }
        if (p_75137_1_ == 1) {
            this.tileBeacon.setPrimaryEffect(p_75137_2_);
        }
        if (p_75137_1_ == 2) {
            this.tileBeacon.setSecondaryEffect(p_75137_2_);
        }
    }
    
    public TileEntityLegendaryBeacon func_148327_e() {
        return this.tileBeacon;
    }
    
    public boolean canInteractWith(final EntityPlayer p_75145_1_) {
        return this.tileBeacon.isUseableByPlayer(p_75145_1_);
    }
    
    public ItemStack transferStackInSlot(final EntityPlayer p_82846_1_, final int p_82846_2_) {
        ItemStack itemstack = null;
        final Slot slot = (Slot) this.inventorySlots.get(p_82846_2_);
        if (slot != null && slot.getHasStack()) {
            final ItemStack itemstack2 = slot.getStack();
            itemstack = itemstack2.copy();
            if (p_82846_2_ == 0) {
                if (!this.mergeItemStack(itemstack2, 1, 37, true)) {
                    return null;
                }
                slot.onSlotChange(itemstack2, itemstack);
            }
            else if (!this.beaconSlot.getHasStack() && this.beaconSlot.isItemValid(itemstack2) && itemstack2.stackSize == 1) {
                if (!this.mergeItemStack(itemstack2, 0, 1, false)) {
                    return null;
                }
            }
            else if (p_82846_2_ >= 1 && p_82846_2_ < 28) {
                if (!this.mergeItemStack(itemstack2, 28, 37, false)) {
                    return null;
                }
            }
            else if (p_82846_2_ >= 28 && p_82846_2_ < 37) {
                if (!this.mergeItemStack(itemstack2, 1, 28, false)) {
                    return null;
                }
            }
            else if (!this.mergeItemStack(itemstack2, 1, 37, false)) {
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
    
    class LegendaryBeaconSlot extends Slot
    {
        public LegendaryBeaconSlot(final IInventory p_i1801_2_, final int p_i1801_3_, final int p_i1801_4_, final int p_i1801_5_) {
            super(p_i1801_2_, p_i1801_3_, p_i1801_4_, p_i1801_5_);
        }
        
        public boolean isItemValid(final ItemStack p_75214_1_) {
            return p_75214_1_ != null && p_75214_1_.getItem() != null && p_75214_1_.getItem().isBeaconPayment(p_75214_1_);
        }
        
        public int getSlotStackLimit() {
            return 1;
        }
    }
}

