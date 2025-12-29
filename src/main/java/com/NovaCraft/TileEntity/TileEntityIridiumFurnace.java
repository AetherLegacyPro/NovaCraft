package com.NovaCraft.TileEntity;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.registry.OtherModItems;
import com.NovaCraftBlocks.NovaCraftBlocks;
import com.NovaCraftBlocks.container.BlockIridiumFurnace;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TileEntityIridiumFurnace extends TileEntity implements ISidedInventory
{
    private static final int[] slotsTop = new int[] {0};
    private static final int[] slotsBottom = new int[] {2, 1};
    private static final int[] slotsSides = new int[] {1};
    private ItemStack[] furnaceItemStacks = new ItemStack[4];
    public int furnaceBurnTime;
    public int currentItemBurnTime;
    public int furnaceCookTime;
    private String field_145958_o;
    private boolean blazlinitePlaced = false;

    //Added this, so it would check the metadata in the custom recipes
    private static final Map<ItemMetaKey, ItemStack> CUSTOM_FURNACE_RECIPES = new HashMap<>();

    private static class ItemMetaKey {
        private final Item item;
        private final int meta;

        public ItemMetaKey(Item item, int meta) {
            this.item = item;
            this.meta = meta;
        }

        @Override
        public boolean equals(Object object) {
            if (this == object) return true;
            if (!(object instanceof ItemMetaKey)) return false;
            ItemMetaKey key = (ItemMetaKey) object;
            return meta == key.meta && item.equals(key.item);
        }

        @Override
        public int hashCode() {
            return 31 * item.hashCode() + meta;
        }
    }

    static {
        //Custom recipes that override the ones from the main smelting list.
        //No Idea why it would not work with items if I did not do this but this was the only workaround I found.
        CUSTOM_FURNACE_RECIPES.put(new ItemMetaKey(NovaCraftItems.raw_iridium, 0), new ItemStack(NovaCraftItems.iridium_nugget, 1, 0));
        CUSTOM_FURNACE_RECIPES.put(new ItemMetaKey(NovaCraftItems.vanite_chunk, 0), new ItemStack(NovaCraftItems.vanite_ingot, 1, 0));
        CUSTOM_FURNACE_RECIPES.put(new ItemMetaKey(NovaCraftItems.klangite_blend, 0), new ItemStack(NovaCraftItems.impure_klangite_ingot, 1, 0));
        CUSTOM_FURNACE_RECIPES.put(new ItemMetaKey(NovaCraftItems.pherithium_lump, 0), new ItemStack(NovaCraftItems.pherithium_ingot, 1, 0));

        CUSTOM_FURNACE_RECIPES.put(new ItemMetaKey(OtherModItems.raw_ore, 0), new ItemStack(OtherModItems.copper_ingot, 1, 0));
        CUSTOM_FURNACE_RECIPES.put(new ItemMetaKey(OtherModItems.raw_ore, 1), new ItemStack(Items.iron_ingot, 1, 0));
        CUSTOM_FURNACE_RECIPES.put(new ItemMetaKey(OtherModItems.raw_ore, 2), new ItemStack(Items.gold_ingot, 1, 0));
    }

    //Positions of the 9 blazlinite blocks in the furnace based on the metadata of the furnace.
    private static final int[][] BLAZLINITE_POSITIONS_POSZ = {
            {0, 0, 2}, {0, 0, 3}, {0, 0, 4},
            {-1, 0, 2}, {1, 0, 2},
            {-1, 0, 3}, {1, 0, 3},
            {-1, 0, 4}, {1, 0, 4}
    };

    private static final int[][] BLAZLINITE_POSITIONS_NEGZ = {
            {0, 0, -2}, {0, 0, -3}, {0, 0, -4},
            {-1, 0, -2}, {1, 0, -2},
            {-1, 0, -3}, {1, 0, -3},
            {-1, 0, -4}, {1, 0, -4}
    };

    private static final int[][] BLAZLINITE_POSITIONS_POSX = {
            {2, 0, 0}, {3, 0, 0}, {4, 0, 0},
            {2, 0, -1}, {2, 0, 1},
            {3, 0, -1}, {3, 0, 1},
            {4, 0, -1}, {4, 0, 1}
    };

    private static final int[][] BLAZLINITE_POSITIONS_NEGX = {
            {-2, 0, 0}, {-3, 0, 0}, {-4, 0, 0},
            {-2, 0, -1}, {-2, 0, 1},
            {-3, 0, -1}, {-3, 0, 1},
            {-4, 0, -1}, {-4, 0, 1}
    };

    //Checks if the block in the smelting slot is from the HashSet Possible Ores in BlockIridiumFurnace.
    private boolean isValidOreBlock(ItemStack stack) {
        if (stack == null) return false;
        if (!(stack.getItem() instanceof ItemBlock)) return false;

        Block block = Block.getBlockFromItem(stack.getItem());
        return BlockIridiumFurnace.PossibleOres.contains(block);
    }

    public int getSizeInventory() {
        return this.furnaceItemStacks.length;
    }

    public ItemStack getStackInSlot(int p_70301_1_) {
        return this.furnaceItemStacks[p_70301_1_];
    }

    public ItemStack decrStackSize(int p_70298_1_, int p_70298_2_)
    {
        if (this.furnaceItemStacks[p_70298_1_] != null)
        {
            ItemStack itemstack;

            if (this.furnaceItemStacks[p_70298_1_].stackSize <= p_70298_2_)
            {
                itemstack = this.furnaceItemStacks[p_70298_1_];
                this.furnaceItemStacks[p_70298_1_] = null;
                return itemstack;
            }
            else
            {
                itemstack = this.furnaceItemStacks[p_70298_1_].splitStack(p_70298_2_);

                if (this.furnaceItemStacks[p_70298_1_].stackSize == 0)
                {
                    this.furnaceItemStacks[p_70298_1_] = null;
                }

                return itemstack;
            }
        }
        else
        {
            return null;
        }
    }

    public ItemStack getStackInSlotOnClosing(int p_70304_1_) {
        if (this.furnaceItemStacks[p_70304_1_] != null)
        {
            ItemStack itemstack = this.furnaceItemStacks[p_70304_1_];
            this.furnaceItemStacks[p_70304_1_] = null;
            return itemstack;
        }
        else
        {
            return null;
        }
    }

    public void setInventorySlotContents(int p_70299_1_, ItemStack p_70299_2_) {
        this.furnaceItemStacks[p_70299_1_] = p_70299_2_;

        if (p_70299_2_ != null && p_70299_2_.stackSize > this.getInventoryStackLimit())
        {
            p_70299_2_.stackSize = this.getInventoryStackLimit();
        }
    }

    public String getInventoryName() {
        return this.hasCustomInventoryName() ? this.field_145958_o : "tooltip.iridium_furnace.desc";
    }

    public boolean hasCustomInventoryName() {
        return this.field_145958_o != null && this.field_145958_o.length() > 0;
    }

    public void func_145951_a(String p_145951_1_) {
        this.field_145958_o = p_145951_1_;
    }

    public void readFromNBT(NBTTagCompound p_145839_1_) {
        super.readFromNBT(p_145839_1_);
        NBTTagList nbttaglist = p_145839_1_.getTagList("Items", 10);
        this.furnaceItemStacks = new ItemStack[this.getSizeInventory()];

        for (int i = 0; i < nbttaglist.tagCount(); ++i)
        {
            NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
            byte b0 = nbttagcompound1.getByte("Slot");

            if (b0 >= 0 && b0 < this.furnaceItemStacks.length)
            {
                this.furnaceItemStacks[b0] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
            }
        }

        this.furnaceBurnTime = p_145839_1_.getShort("BurnTime");
        this.furnaceCookTime = p_145839_1_.getShort("CookTime");
        this.currentItemBurnTime = getItemBurnTime(this.furnaceItemStacks[1]);

        if (p_145839_1_.hasKey("CustomName", 8))
        {
            this.field_145958_o = p_145839_1_.getString("CustomName");
        }
    }

    public void writeToNBT(NBTTagCompound p_145841_1_) {
        super.writeToNBT(p_145841_1_);
        p_145841_1_.setShort("BurnTime", (short)this.furnaceBurnTime);
        p_145841_1_.setShort("CookTime", (short)this.furnaceCookTime);
        NBTTagList nbttaglist = new NBTTagList();

        for (int i = 0; i < this.furnaceItemStacks.length; ++i)
        {
            if (this.furnaceItemStacks[i] != null)
            {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.setByte("Slot", (byte)i);
                this.furnaceItemStacks[i].writeToNBT(nbttagcompound1);
                nbttaglist.appendTag(nbttagcompound1);
            }
        }

        p_145841_1_.setTag("Items", nbttaglist);

        if (this.hasCustomInventoryName())
        {
            p_145841_1_.setString("CustomName", this.field_145958_o);
        }
    }

    //Determine if infused iridium bricks are placed at the correct locations to determine if an additional output is possible.
    private ItemStack checkPositionPosZ() {
        World world = this.worldObj;
        int x = this.xCoord;
        int y = this.yCoord;
        int z = this.zCoord;

        int[][] POSITIONPOSZ = {
                { 0, 1, 5 },
                { 2, 1, 4 },
                { -2, 1, 4 },
                { 2, 1, 2 },
                { -2, 1, 2 },
                { 0, 1, 1 }
        };

        int requiredMeta = -1;

        for (int[] p : POSITIONPOSZ) {
            int px = x + p[0];
            int py = y + p[1];
            int pz = z + p[2];

            if (world.getBlock(px, py, pz) != NovaCraftBlocks.infused_iridium_bricks) {
                return null;
            }

            int meta = world.getBlockMetadata(px, py, pz);

            if (requiredMeta == -1) {
                requiredMeta = meta;
            } else if (meta != requiredMeta) {
                return null;
            }
        }

        return getSpecialItemFromMeta(requiredMeta);
    }

    private ItemStack checkPositionNegZ() {

        World world = this.worldObj;
        int x = this.xCoord;
        int y = this.yCoord;
        int z = this.zCoord;

        int[][] POSITIONNEGZ = {
                { 0, 1, -5 },
                { 2, 1, -4 },
                { -2, 1, -4 },
                { 2, 1, -2 },
                { -2, 1, -2 },
                { 0, 1, -1 }
        };

        int requiredMeta = -1;

        for (int[] p : POSITIONNEGZ) {
            int px = x + p[0];
            int py = y + p[1];
            int pz = z + p[2];

            if (world.getBlock(px, py, pz) != NovaCraftBlocks.infused_iridium_bricks) {
                return null;
            }

            int meta = world.getBlockMetadata(px, py, pz);

            if (requiredMeta == -1) {
                requiredMeta = meta;
            } else if (meta != requiredMeta) {
                return null;
            }
        }

        return getSpecialItemFromMeta(requiredMeta);
    }

    private ItemStack checkPositionPosX() {

        World world = this.worldObj;
        int x = this.xCoord;
        int y = this.yCoord;
        int z = this.zCoord;

        int[][] POSITIONPOSX = {
                { 5, 1, 0 },
                { 4, 1, 2 },
                { 4, 1, -2 },
                { 2, 1, 2 },
                { 2, 1, -2 },
                { 1, 1, 0 }
        };

        int requiredMeta = -1;

        for (int[] p : POSITIONPOSX) {
            int px = x + p[0];
            int py = y + p[1];
            int pz = z + p[2];

            if (world.getBlock(px, py, pz) != NovaCraftBlocks.infused_iridium_bricks) {
                return null;
            }

            int meta = world.getBlockMetadata(px, py, pz);

            if (requiredMeta == -1) {
                requiredMeta = meta;
            } else if (meta != requiredMeta) {
                return null;
            }
        }

        return getSpecialItemFromMeta(requiredMeta);
    }

    private ItemStack checkPositionNegX() {

        World world = this.worldObj;
        int x = this.xCoord;
        int y = this.yCoord;
        int z = this.zCoord;

        int[][] POSITIONNEGX = {
                { -5, 1, 0 },
                { -4, 1, 2 },
                { -4, 1, -2 },
                { -2, 1, 2 },
                { -2, 1, -2 },
                { -1, 1, 0 }
        };

        int requiredMeta = -1;

        for (int[] p : POSITIONNEGX) {
            int px = x + p[0];
            int py = y + p[1];
            int pz = z + p[2];

            if (world.getBlock(px, py, pz) != NovaCraftBlocks.infused_iridium_bricks) {
                return null;
            }

            int meta = world.getBlockMetadata(px, py, pz);

            if (requiredMeta == -1) {
                requiredMeta = meta;
            } else if (meta != requiredMeta) {
                return null;
            }
        }

        return getSpecialItemFromMeta(requiredMeta);
    }

    //Output for the additional item if infused iridium bricks are placed in the correct locations.
    private ItemStack getSecondaryOutput() {
        ItemStack input = furnaceItemStacks[0];

        if (!isValidOreBlock(input)) {
            return null;
        }

        ItemStack output;

        output = checkPositionPosZ();
        if (output != null) return output;

        output = checkPositionNegZ();
        if (output != null) return output;

        output = checkPositionPosX();
        if (output != null) return output;

        output = checkPositionNegX();
        if (output != null) return output;

        return null;
    }

    private ItemStack getSpecialItemFromMeta(int meta) {
        Random rand;
        switch (meta) {
            case 0:
                return new ItemStack(Items.redstone, 1 + worldObj.rand.nextInt(2));
            case 1:
                return new ItemStack(Items.dye, 1 + worldObj.rand.nextInt(2), 4);
            case 2:
                return new ItemStack(NovaCraftItems.diamond_nugget, 1, 1);
            case 3:
                return new ItemStack(Items.iron_ingot);
            case 4:
                return new ItemStack(Items.diamond);
            case 5:
                return new ItemStack(NovaCraftItems.iridium_nugget, 1, 0);
            case 6:
                return new ItemStack(NovaCraftItems.vanite_ingot);
            default:
                return null;
        }
    }

    public int getInventoryStackLimit() {
        return 64;
    }

    //3x the time to smelt one item compared to the regular furnace.
    @SideOnly(Side.CLIENT)
    public int getCookProgressScaled(int p_145953_1_) {
        return this.furnaceCookTime * p_145953_1_ / 600;
    }

    @SideOnly(Side.CLIENT)
    public int getBurnTimeRemainingScaled(int p_145955_1_) {
        if (this.currentItemBurnTime == 0)
        {
            this.currentItemBurnTime = 600;
        }

        return this.furnaceBurnTime * p_145955_1_ / this.currentItemBurnTime;
    }

    public boolean isBurning() {
        return this.furnaceBurnTime > 0;
    }

    public void updateEntity() {
        boolean wasBurning = furnaceBurnTime > 0;
        boolean dirty = false;

        if (!worldObj.isRemote) {

            if (furnaceBurnTime > 0) {
                --furnaceBurnTime;
            }

            // Places the Blazlinite at the positions from above based on the metadata of the Iridium Furnace.
            if (!blazlinitePlaced && furnaceBurnTime > 0 && worldObj.getBlockMetadata(xCoord, yCoord, zCoord) == 2) {
                for (int[] pos : BLAZLINITE_POSITIONS_POSZ) {
                    int x = xCoord + pos[0];
                    int y = yCoord + pos[1];
                    int z = zCoord + pos[2];

                    if (worldObj.isAirBlock(x, y, z)) {
                        worldObj.setBlock(x, y, z, NovaCraftBlocks.blazlinite);
                        worldObj.setBlock(x, y, z + 1, NovaCraftBlocks.blazlinite);
                        worldObj.setBlock(x, y, z + 2, NovaCraftBlocks.blazlinite);
                        worldObj.setBlock(x + 1, y, z, NovaCraftBlocks.blazlinite);
                        worldObj.setBlock(x - 1, y, z, NovaCraftBlocks.blazlinite);
                        worldObj.setBlock(x + 1, y, z + 1, NovaCraftBlocks.blazlinite);
                        worldObj.setBlock(x - 1, y, z + 1, NovaCraftBlocks.blazlinite);
                        worldObj.setBlock(x + 1, y, z + 2, NovaCraftBlocks.blazlinite);
                        worldObj.setBlock(x - 1, y, z + 2, NovaCraftBlocks.blazlinite);
                        blazlinitePlaced = true;
                        break;
                    }
                }
            } if (!blazlinitePlaced && furnaceBurnTime > 0 && worldObj.getBlockMetadata(xCoord, yCoord, zCoord) == 3) {
                for (int[] pos : BLAZLINITE_POSITIONS_NEGZ) {
                    int x = xCoord + pos[0];
                    int y = yCoord + pos[1];
                    int z = zCoord + pos[2];

                    if (worldObj.isAirBlock(x, y, z)) {
                        worldObj.setBlock(x, y, z, NovaCraftBlocks.blazlinite);
                        worldObj.setBlock(x, y, z - 1, NovaCraftBlocks.blazlinite);
                        worldObj.setBlock(x, y, z - 2, NovaCraftBlocks.blazlinite);
                        worldObj.setBlock(x + 1, y, z, NovaCraftBlocks.blazlinite);
                        worldObj.setBlock(x - 1, y, z, NovaCraftBlocks.blazlinite);
                        worldObj.setBlock(x + 1, y, z - 1, NovaCraftBlocks.blazlinite);
                        worldObj.setBlock(x - 1, y, z - 1, NovaCraftBlocks.blazlinite);
                        worldObj.setBlock(x + 1, y, z - 2, NovaCraftBlocks.blazlinite);
                        worldObj.setBlock(x - 1, y, z - 2, NovaCraftBlocks.blazlinite);
                        blazlinitePlaced = true;
                        break;
                    }
                }
            } if (!blazlinitePlaced && furnaceBurnTime > 0 && worldObj.getBlockMetadata(xCoord, yCoord, zCoord) == 4) {
                for (int[] pos : BLAZLINITE_POSITIONS_POSX) {
                    int x = xCoord + pos[0];
                    int y = yCoord + pos[1];
                    int z = zCoord + pos[2];

                    if (worldObj.isAirBlock(x, y, z)) {
                        worldObj.setBlock(x, y, z, NovaCraftBlocks.blazlinite);
                        worldObj.setBlock(x + 1, y, z, NovaCraftBlocks.blazlinite);
                        worldObj.setBlock(x + 2, y, z, NovaCraftBlocks.blazlinite);
                        worldObj.setBlock(x, y, z + 1, NovaCraftBlocks.blazlinite);
                        worldObj.setBlock(x, y, z - 1, NovaCraftBlocks.blazlinite);
                        worldObj.setBlock(x + 1, y, z + 1, NovaCraftBlocks.blazlinite);
                        worldObj.setBlock(x + 1, y, z - 1, NovaCraftBlocks.blazlinite);
                        worldObj.setBlock(x + 2, y, z + 1, NovaCraftBlocks.blazlinite);
                        worldObj.setBlock(x + 2, y, z - 1, NovaCraftBlocks.blazlinite);
                        blazlinitePlaced = true;
                        break;
                    }
                }
            } if (!blazlinitePlaced && furnaceBurnTime > 0 && worldObj.getBlockMetadata(xCoord, yCoord, zCoord) == 5) {
                for (int[] pos : BLAZLINITE_POSITIONS_NEGX) {
                    int x = xCoord + pos[0];
                    int y = yCoord + pos[1];
                    int z = zCoord + pos[2];

                    if (worldObj.isAirBlock(x, y, z)) {
                        worldObj.setBlock(x, y, z, NovaCraftBlocks.blazlinite);
                        worldObj.setBlock(x - 1, y, z, NovaCraftBlocks.blazlinite);
                        worldObj.setBlock(x - 2, y, z, NovaCraftBlocks.blazlinite);
                        worldObj.setBlock(x, y, z + 1, NovaCraftBlocks.blazlinite);
                        worldObj.setBlock(x, y, z - 1, NovaCraftBlocks.blazlinite);
                        worldObj.setBlock(x - 1, y, z + 1, NovaCraftBlocks.blazlinite);
                        worldObj.setBlock(x - 1, y, z - 1, NovaCraftBlocks.blazlinite);
                        worldObj.setBlock(x - 2, y, z + 1, NovaCraftBlocks.blazlinite);
                        worldObj.setBlock(x - 2, y, z - 1, NovaCraftBlocks.blazlinite);
                        blazlinitePlaced = true;
                        break;
                    }
                }
            }

            //Removes the blazlinite in the furnace when the fuel timer ends.
            if (blazlinitePlaced && furnaceBurnTime <= 0) {
                for (int[] pos : BLAZLINITE_POSITIONS_POSZ) {
                    int x = xCoord + pos[0];
                    int y = yCoord + pos[1];
                    int z = zCoord + pos[2];

                    if (worldObj.getBlock(x, y, z) == NovaCraftBlocks.blazlinite) {
                        worldObj.setBlockToAir(x, y, z);
                        blazlinitePlaced = false;
                        break;
                    }
                }
                for (int[] pos : BLAZLINITE_POSITIONS_POSX) {
                    int x = xCoord + pos[0];
                    int y = yCoord + pos[1];
                    int z = zCoord + pos[2];

                    if (worldObj.getBlock(x, y, z) == NovaCraftBlocks.blazlinite) {
                        worldObj.setBlockToAir(x, y, z);
                        blazlinitePlaced = false;
                        break;
                    }
                }
                for (int[] pos : BLAZLINITE_POSITIONS_NEGZ) {
                    int x = xCoord + pos[0];
                    int y = yCoord + pos[1];
                    int z = zCoord + pos[2];

                    if (worldObj.getBlock(x, y, z) == NovaCraftBlocks.blazlinite) {
                        worldObj.setBlockToAir(x, y, z);
                        blazlinitePlaced = false;
                        break;
                    }
                }
                for (int[] pos : BLAZLINITE_POSITIONS_NEGX) {
                    int x = xCoord + pos[0];
                    int y = yCoord + pos[1];
                    int z = zCoord + pos[2];

                    if (worldObj.getBlock(x, y, z) == NovaCraftBlocks.blazlinite) {
                        worldObj.setBlockToAir(x, y, z);
                        blazlinitePlaced = false;
                        break;
                    }
                }
            }

            if (canSmelt()) {
                ++furnaceCookTime;

                if (furnaceCookTime >= 600) {
                    furnaceCookTime = 0;
                    smeltItem();
                    dirty = true;
                }
            } else {
                furnaceCookTime = 0;
            }

            if (furnaceBurnTime == 0 && canSmelt() && furnaceItemStacks[1] != null) {
                furnaceBurnTime = currentItemBurnTime = getItemBurnTime(furnaceItemStacks[1]);
                if (furnaceBurnTime > 0) {
                    --furnaceItemStacks[1].stackSize;
                    if (furnaceItemStacks[1].stackSize <= 0) {
                        furnaceItemStacks[1] = furnaceItemStacks[1].getItem().getContainerItem(furnaceItemStacks[1]);
                    }
                    dirty = true;
                }
            }

            if (wasBurning != furnaceBurnTime > 0) {
                BlockIridiumFurnace.updateFurnaceBlockState(furnaceBurnTime > 0, worldObj, xCoord, yCoord, zCoord);
                dirty = true;
            }
        }

        if (dirty) markDirty();
    }

    private boolean canSmelt() {
        if (furnaceItemStacks[0] == null) return false;

        ItemStack input = furnaceItemStacks[0];
        ItemStack result;

        boolean isCustom = isCustomRecipe(input);
        if (isCustom) {
            result = getCustomRecipeResult(input).copy();
            if (result == null) return false;
        } else {
            result = FurnaceRecipes.smelting().getSmeltingResult(input);
            if (result == null) return false;
        }

        //Determine the multipler for the item/block in the smelting slot.
        int multiplier;
        if (isCustom) {
            multiplier = 2; //Items in the static above always give 2.
        } else if (isValidOreBlock(input)) {
            multiplier = 3; //Blocks from the Hash
        } else {
            multiplier = 1; //Otherwise only output 1.
        }

        int outputSize = result.stackSize * multiplier;
        if (furnaceItemStacks[2] != null) {
            if (!furnaceItemStacks[2].isItemEqual(result)) return false;
            if (furnaceItemStacks[2].stackSize + outputSize > getInventoryStackLimit()) return false;
        }

        if (!isCustom && isValidOreBlock(input)) {
            ItemStack secondary = getSecondaryOutput();
            if (secondary != null) {
                if (furnaceItemStacks[3] != null) {
                    if (!furnaceItemStacks[3].isItemEqual(secondary)) return false;
                    if (furnaceItemStacks[3].stackSize + secondary.stackSize > getInventoryStackLimit()) return false;
                }
            }
        }

        return true;
    }

    public void smeltItem() {
        if (!this.canSmelt()) return;

        ItemStack input = this.furnaceItemStacks[0];
        ItemStack result;

        boolean isCustom = isCustomRecipe(input);
        if (isCustom) {
            result = getCustomRecipeResult(input).copy();
        } else {
            result = FurnaceRecipes.smelting().getSmeltingResult(input);
            if (result == null) return;
        }

        int multiplier;
        if (isCustom) {
            multiplier = 2;
        } else if (isValidOreBlock(input)) {
            multiplier = 3;
        } else {
            multiplier = 1;
        }

        ItemStack primary = result.copy();
        primary.stackSize *= multiplier;

        if (this.furnaceItemStacks[2] == null) {
            this.furnaceItemStacks[2] = primary;
        } else if (this.furnaceItemStacks[2].isItemEqual(primary)) {
            this.furnaceItemStacks[2].stackSize += primary.stackSize;
        }

        if (!isCustom && isValidOreBlock(input)) {
            ItemStack secondary = getSecondaryOutput();

            if (secondary != null && this.worldObj.rand.nextBoolean()) {
                if (this.furnaceItemStacks[3] == null) {
                    this.furnaceItemStacks[3] = secondary.copy();
                } else if (this.furnaceItemStacks[3].isItemEqual(secondary)
                        && this.furnaceItemStacks[3].stackSize + secondary.stackSize
                        <= this.getInventoryStackLimit()) {

                    this.furnaceItemStacks[3].stackSize += secondary.stackSize;
                }
            }
        }

        --input.stackSize;
        if (input.stackSize <= 0) {
            this.furnaceItemStacks[0] = null;
        }
    }

    private boolean isCustomRecipe(ItemStack input) {
        if (input == null) return false;
        ItemMetaKey key = new ItemMetaKey(input.getItem(), input.getItemDamage());
        return CUSTOM_FURNACE_RECIPES.containsKey(key);
    }

    private ItemStack getCustomRecipeResult(ItemStack stack) {
        if (stack == null) return null;
        ItemMetaKey key = new ItemMetaKey(stack.getItem(), stack.getItemDamage());
        return CUSTOM_FURNACE_RECIPES.getOrDefault(key, null);
    }

    public static int getItemBurnTime(final ItemStack p_145952_0_) {
        if (p_145952_0_ == null) {
            return 0;
        }
        final Item item = p_145952_0_.getItem();

        if (item == NovaCraftItems.vanite_bucket_blazlinite) {
            return 20240;
        }

        return GameRegistry.getFuelValue(p_145952_0_)*3;
    }

    public static boolean isItemFuel(ItemStack p_145954_0_) {
        return getItemBurnTime(p_145954_0_) > 0;
    }

    public boolean isUseableByPlayer(EntityPlayer p_70300_1_) {
        return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : p_70300_1_.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
    }

    public void openInventory() {}

    public void closeInventory() {}

    public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_) {
        return p_94041_1_ == 2 ? false : (p_94041_1_ == 1 ? isItemFuel(p_94041_2_) : true);
    }

    public int[] getAccessibleSlotsFromSide(int p_94128_1_) {
        return p_94128_1_ == 0 ? slotsBottom : (p_94128_1_ == 1 ? slotsTop : slotsSides);
    }

    public boolean canInsertItem(int p_102007_1_, ItemStack p_102007_2_, int p_102007_3_) {
        return this.isItemValidForSlot(p_102007_1_, p_102007_2_);
    }

    public boolean canExtractItem(int p_102008_1_, ItemStack p_102008_2_, int p_102008_3_) {
        return p_102008_3_ != 0 || p_102008_1_ != 1 || p_102008_2_.getItem() == Items.bucket;
    }
}
