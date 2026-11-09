package com.NovaCraft.container;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import java.util.Random;
import com.NovaCraftBlocks.NovaCraftBlocks;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;

public class AdvancedEnchantmentTableContainer extends Container {
    public IInventory tableInventory = new InventoryBasic("Enchant", true, 1) {

        public int getInventoryStackLimit()
        {
            return 1;
        }

        public void markDirty()
        {
            super.markDirty();
            AdvancedEnchantmentTableContainer.this.onCraftMatrixChanged(this);
        }
    };
    private World worldPointer;
    private int posX;
    private int posY;
    private int posZ;
    private Random rand = new Random();
    public long nameSeed;
    public int[] enchantLevels = new int[6];

    public AdvancedEnchantmentTableContainer(InventoryPlayer inventory, World world, int x, int y, int z)
    {
        this.worldPointer = world;
        this.posX = x;
        this.posY = y;
        this.posZ = z;
        this.addSlotToContainer(new Slot(this.tableInventory, 0, 25, 47) {
            public boolean isItemValid(ItemStack p_75214_1_)
            {
                return true;
            }
        });
        
        int l;

        for (l = 0; l < 3; ++l) 
        {
            for (int i1 = 0; i1 < 9; ++i1)
            {
                this.addSlotToContainer(new Slot(inventory, i1 + l * 9 + 9, 8 + i1 * 18, 84 + l * 18));
            }
        }

        for (l = 0; l < 9; ++l)
        {
            this.addSlotToContainer(new Slot(inventory, l, 8 + l * 18, 142));
        }
    }

    public void addCraftingToCrafters(ICrafting crafting)
    {
        super.addCraftingToCrafters(crafting);
        crafting.sendProgressBarUpdate(this, 0, this.enchantLevels[0]);
        crafting.sendProgressBarUpdate(this, 1, this.enchantLevels[1]);
        crafting.sendProgressBarUpdate(this, 2, this.enchantLevels[2]);
    }

    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();

        for (int i = 0; i < this.crafters.size(); ++i)
        {
            ICrafting icrafting = (ICrafting)this.crafters.get(i);
            icrafting.sendProgressBarUpdate(this, 0, this.enchantLevels[0]);
            icrafting.sendProgressBarUpdate(this, 1, this.enchantLevels[1]);
            icrafting.sendProgressBarUpdate(this, 2, this.enchantLevels[2]);
        }
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int p_75137_1_, int p_75137_2_)
    {
        if (p_75137_1_ >= 0 && p_75137_1_ <= 2)
        {
            this.enchantLevels[p_75137_1_] = 50;
        }
        else
        {
            super.updateProgressBar(p_75137_1_, p_75137_2_);
        }
    }

    public void onCraftMatrixChanged(IInventory p_75130_1_)
    {
        if (p_75130_1_ == this.tableInventory)
        {
            ItemStack itemstack = p_75130_1_.getStackInSlot(0);
            int i;

            if (itemstack != null && itemstack.isItemEnchantable())
            {
                this.nameSeed = this.rand.nextLong();

                if (!this.worldPointer.isRemote)
                {
                    i = 0;
                    int j;
                    float power = 0;
                    //Checking for bookshelves and getting the bonus to levels?
                    for (j = -1; j <= 1; ++j) 
                    {
                        for (int k = -1; k <= 1; ++k)
                        {
                            if ((j != 0 || k != 0) && this.worldPointer.isAirBlock(this.posX + k, this.posY, this.posZ + j) && this.worldPointer.isAirBlock(this.posX + k, this.posY + 1, this.posZ + j))
                            {
                                power += ForgeHooks.getEnchantPower(worldPointer, posX + k * 2, posY,     posZ + j * 2);
                                power += ForgeHooks.getEnchantPower(worldPointer, posX + k * 2, posY + 1, posZ + j * 2);

                                if (k != 0 && j != 0)
                                {
                                    power += ForgeHooks.getEnchantPower(worldPointer, posX + k * 2, posY,     posZ + j    );
                                    power += ForgeHooks.getEnchantPower(worldPointer, posX + k * 2, posY + 1, posZ + j    );
                                    power += ForgeHooks.getEnchantPower(worldPointer, posX + k,     posY,     posZ + j * 2);
                                    power += ForgeHooks.getEnchantPower(worldPointer, posX + k,     posY + 1, posZ + j * 2);
                                }
                            }
                        }
                    }

                    for (j = 0; j < 6; ++j) //Bookshelf Bonus
                    {
                        this.enchantLevels[j] = EnchantmentHelper.calcItemStackEnchantability(this.rand, j * 2, (int)power * 2, itemstack); //
                    }

                    this.detectAndSendChanges();
                }
            }
            else
            {
                for (i = 0; i < 6; ++i) //Not sure what this does
                {
                    this.enchantLevels[i] = 0; 
                }
            }
        }
    }

    public boolean enchantItem(EntityPlayer p_75140_1_, int p_75140_2_)
    {
        ItemStack itemstack = this.tableInventory.getStackInSlot(0);

        if (this.enchantLevels[p_75140_2_] > 0 && itemstack != null && (p_75140_1_.experienceLevel >= 50 || p_75140_1_.capabilities.isCreativeMode))
        {
            if (!this.worldPointer.isRemote)
            {
                List list = EnchantmentHelper.buildEnchantmentList(this.rand, itemstack, this.enchantLevels[p_75140_2_]);
                boolean flag = itemstack.getItem() == Items.book;

                if (list != null)
                {
                    p_75140_1_.addExperienceLevel(-50);
 
                    if (flag)
                    {
                        itemstack.func_150996_a(Items.enchanted_book);
                    }

                    int j = flag && list.size() > 1 ? this.rand.nextInt(list.size()) : -1;

                    for (int k = 0; k < list.size(); ++k)
                    {
                       EnchantmentData enchantmentdata = (EnchantmentData)list.get(k);

                        if (!flag || k != j)
                        {
                            if (flag)
                            {
                                Items.enchanted_book.addEnchantment(itemstack, enchantmentdata);
                            }
                            else
                            {
                                itemstack.addEnchantment(enchantmentdata.enchantmentobj, RandomLevel());
                            }
                       }
                    }
                    
                    this.onCraftMatrixChanged(this.tableInventory);
                }
            }
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public int RandomLevel() {
    	int randlevel = (int)(1 + Math.random() * 5);
    	switch (randlevel)
        {
         case 1: randlevel = 3;
    		break;
         case 2: randlevel = 3;
        	break;
         case 3: randlevel = 3;
     		break;
         case 4: randlevel = 4;
     		break;
         case 5: randlevel = 4;
     	   	break;
        }
		return randlevel;
    	
    }

    public void onContainerClosed(EntityPlayer p_75134_1_)
    {
        super.onContainerClosed(p_75134_1_);

        if (!this.worldPointer.isRemote)
        {
            ItemStack itemstack = this.tableInventory.getStackInSlotOnClosing(0);

            if (itemstack != null)
            {
                p_75134_1_.dropPlayerItemWithRandomChoice(itemstack, false);
            }
        }
    }

    public boolean canInteractWith(EntityPlayer p_75145_1_)
    {
        return this.worldPointer.getBlock(this.posX, this.posY, this.posZ) != NovaCraftBlocks.advanced_enchantment_table ? false : p_75145_1_.getDistanceSq((double)this.posX + 0.5D, (double)this.posY + 0.5D, (double)this.posZ + 0.5D) <= 64.0D;
    }

    public ItemStack transferStackInSlot(EntityPlayer p_82846_1_, int p_82846_2_)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(p_82846_2_);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (p_82846_2_ == 0)
            {
                if (!this.mergeItemStack(itemstack1, 1, 37, true))
                {
                    return null;
                }
            }
            else
            {
                if (((Slot)this.inventorySlots.get(0)).getHasStack() || !((Slot)this.inventorySlots.get(0)).isItemValid(itemstack1))
                {
                    return null;
                }

                if (itemstack1.hasTagCompound() && itemstack1.stackSize == 1)
                {
                    ((Slot)this.inventorySlots.get(0)).putStack(itemstack1.copy());
                    itemstack1.stackSize = 0;
                }
                else if (itemstack1.stackSize >= 1)
                {
                    ((Slot)this.inventorySlots.get(0)).putStack(new ItemStack(itemstack1.getItem(), 1, itemstack1.getItemDamage()));
                    --itemstack1.stackSize;
                }
            }

            if (itemstack1.stackSize == 0)
            {
                slot.putStack((ItemStack)null);
            }
            else
            {
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == itemstack.stackSize)
            {
                return null;
            }

            slot.onPickupFromSlot(p_82846_1_, itemstack1);
        }

        return itemstack;
    }
}
