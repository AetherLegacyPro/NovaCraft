package com.NovaCraft.TileEntity;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.registry.DeepoidBrewingRecipes;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBrewingStand;

public class TileEntityDeepoidBrewingStand extends TileEntityBrewingStand implements ISidedInventory {

    private static final int[] INGREDIENT_SLOT = new int[]{3};
    private static final int[] BOTTLE_SLOTS = new int[]{0, 1, 2};

    private ItemStack[] inventory = new ItemStack[4];
    private int brewTime;
    private int filledSlots;
    private String customName;

    @Override
    public int getSizeInventory() {
        return inventory.length;
    }

    @Override
    public ItemStack getStackInSlot(int slot) {
        return inventory[slot];
    }

    @Override
    public ItemStack decrStackSize(int slot, int amount) {
        if (inventory[slot] == null) return null;

        if (inventory[slot].stackSize <= amount) {
            ItemStack stack = inventory[slot];
            inventory[slot] = null;
            return stack;
        } else {
            ItemStack stack = inventory[slot].splitStack(amount);
            if (inventory[slot].stackSize == 0) {
                inventory[slot] = null;
            }
            return stack;
        }
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int slot) {
        ItemStack stack = inventory[slot];
        inventory[slot] = null;
        return stack;
    }

    @Override
    public void setInventorySlotContents(int slot, ItemStack stack) {
        inventory[slot] = stack;
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public void updateEntity() {
        if (brewTime > 0) {
            brewTime--;

            if (brewTime == 0) {
                brew();
                markDirty();
            } else if (!canBrew()) {
                brewTime = 0;
                markDirty();
            }
        } else if (canBrew()) {
            brewTime = 400;
        }

        int i = getFilledSlots();
        if (i != filledSlots) {
            filledSlots = i;
            worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, i, 2);
        }
    }

    private boolean canBrew() {
        ItemStack ingredient = inventory[3];
        if (ingredient == null) return false;

        for (int i = 0; i < 3; i++) {
            ItemStack input = inventory[i];
            if (input != null &&
                    DeepoidBrewingRecipes.getResult(input, ingredient) != null) {
                return true;
            }
        }
        return false;
    }

    private void brew() {
        ItemStack ingredient = inventory[3];

        for (int i = 0; i < 3; i++) {
            ItemStack input = inventory[i];
            if (input != null) {
                ItemStack result = DeepoidBrewingRecipes.getResult(input, ingredient);
                if (result != null) {
                    inventory[i] = result;
                }
            }
        }

        ingredient.stackSize--;
        if (ingredient.stackSize <= 0) {
            inventory[3] = null;
        }
    }

    public int getBrewTime() {
        return brewTime;
    }

    @SideOnly(Side.CLIENT)
    public void setBrewTime(int time) {
        brewTime = time;
    }

    public int getFilledSlots() {
        int i = 0;
        for (int j = 0; j < 3; j++) {
            if (inventory[j] != null) {
                i |= 1 << j;
            }
        }
        return i;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer player) {
        return worldObj.getTileEntity(xCoord, yCoord, zCoord) == this && player.getDistanceSq(xCoord + 0.5D, yCoord + 0.5D, zCoord + 0.5D) <= 64.0D;
    }

    @Override
    public boolean isItemValidForSlot(int slot, ItemStack stack) {
        if (stack == null) return false;

        if (slot == 3) {
            return stack.getItem() == NovaCraftItems.nullwart_blend;
        }

        return true;
    }

    @Override
    public int[] getAccessibleSlotsFromSide(int side) {
        return side == 1 ? INGREDIENT_SLOT : BOTTLE_SLOTS;
    }

    @Override
    public boolean canInsertItem(int slot, ItemStack stack, int side) {
        return isItemValidForSlot(slot, stack);
    }

    @Override
    public boolean canExtractItem(int slot, ItemStack stack, int side) {
        return true;
    }

    @Override
    public void readFromNBT(NBTTagCompound tag) {
        super.readFromNBT(tag);

        NBTTagList list = tag.getTagList("Items", 10);
        inventory = new ItemStack[getSizeInventory()];

        for (int i = 0; i < list.tagCount(); i++) {
            NBTTagCompound entry = list.getCompoundTagAt(i);
            byte slot = entry.getByte("Slot");
            if (slot >= 0 && slot < inventory.length) {
                inventory[slot] = ItemStack.loadItemStackFromNBT(entry);
            }
        }

        brewTime = tag.getShort("BrewTime");

        if (tag.hasKey("CustomName")) {
            customName = tag.getString("CustomName");
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound tag) {
        super.writeToNBT(tag);

        tag.setShort("BrewTime", (short) brewTime);

        NBTTagList list = new NBTTagList();
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] != null) {
                NBTTagCompound entry = new NBTTagCompound();
                entry.setByte("Slot", (byte) i);
                inventory[i].writeToNBT(entry);
                list.appendTag(entry);
            }
        }
        tag.setTag("Items", list);

        if (customName != null) {
            tag.setString("CustomName", customName);
        }
    }

    @Override
    public String getInventoryName() {
        return hasCustomInventoryName() ? customName : "tooltip.deepoid_brewing_stand.desc";
    }

    @Override
    public boolean hasCustomInventoryName() {
        return customName != null && !customName.isEmpty();
    }

    @Override public void openInventory() {}
    @Override public void closeInventory() {}

    public void setCustomName(String name) {
        this.customName = name;
    }
}
