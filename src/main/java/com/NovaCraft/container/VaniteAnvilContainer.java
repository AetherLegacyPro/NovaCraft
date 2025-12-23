package com.NovaCraft.container;

import com.NovaCraftBlocks.NovaCraftBlocks;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.*;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;

public class VaniteAnvilContainer extends Container {
    private static final Map<Block, Integer> XP_REDUCTION_BLOCKS = new HashMap<Block, Integer>();
    private long lastWorldTick = -1;
    private final IInventory outputSlot = new InventoryCraftResult();
    private final IInventory inputSlots = new InventoryBasic("Repair", true, 2) {
        @Override
        public void markDirty() {
            super.markDirty();
            VaniteAnvilContainer.this.onCraftMatrixChanged(this);
        }
    };

    static {
        XP_REDUCTION_BLOCKS.put(NovaCraftBlocks.copartz_cluster_2, 1);
        XP_REDUCTION_BLOCKS.put(NovaCraftBlocks.larimar_cluster_2, 1);
        XP_REDUCTION_BLOCKS.put(NovaCraftBlocks.tsavorokite_cluster_2, 1);
        XP_REDUCTION_BLOCKS.put(NovaCraftBlocks.yttrlinsite_cluster_2, 1);
        XP_REDUCTION_BLOCKS.put(NovaCraftBlocks.aether_cluster_2, 2);
        XP_REDUCTION_BLOCKS.put(NovaCraftBlocks.vanite_cluster, 2);
        XP_REDUCTION_BLOCKS.put(NovaCraftBlocks.echo_cluster_2, 3);
        XP_REDUCTION_BLOCKS.put(NovaCraftBlocks.null_cluster_2, 4);
    }

    private final World world;
    private final int x, y, z;
    private final EntityPlayer player;

    public int maximumCost;
    public int stackSizeToBeUsedInRepair;
    private String repairedItemName;

    public VaniteAnvilContainer(InventoryPlayer playerInv, World world, int x, int y, int z, EntityPlayer player) {
        this.world = world;
        this.x = x;
        this.y = y;
        this.z = z;
        this.player = player;

        this.addSlotToContainer(new Slot(this.inputSlots, 0, 27, 47));
        this.addSlotToContainer(new Slot(this.inputSlots, 1, 76, 47));

        this.addSlotToContainer(new Slot(this.outputSlot, 0, 134, 47) {

            @Override
            public boolean isItemValid(ItemStack stack) {
                return false;
            }

            @Override
            public boolean canTakeStack(EntityPlayer player) {
                return (player.capabilities.isCreativeMode || player.experienceLevel >= maximumCost) && maximumCost > 0 && this.getHasStack();
            }

            @Override
            public void onPickupFromSlot(EntityPlayer player, ItemStack stack) {
                ItemStack result = this.getStack();

                if (!player.capabilities.isCreativeMode) {
                    player.addExperienceLevel(-maximumCost);
                }

                float breakChance = ForgeHooks.onAnvilRepair(player, result, inputSlots.getStackInSlot(0), inputSlots.getStackInSlot(1));
                inputSlots.setInventorySlotContents(0, null);

                if (stackSizeToBeUsedInRepair > 0) {
                    ItemStack right = inputSlots.getStackInSlot(1);
                    if (right != null && right.stackSize > stackSizeToBeUsedInRepair) {
                        right.stackSize -= stackSizeToBeUsedInRepair;
                    } else {
                        right = null;
                    }
                    inputSlots.setInventorySlotContents(1, right);
                } else {
                    inputSlots.setInventorySlotContents(1, null);
                }

                maximumCost = 0;

                if (!player.capabilities.isCreativeMode && !world.isRemote && world.getBlock(x, y, z) == NovaCraftBlocks.vanite_anvil && player.getRNG().nextFloat() < breakChance / 3) {
                    int meta = world.getBlockMetadata(x, y, z);
                    int damage = meta >> 2;
                    int facing = meta & 3;
                    damage++;
                    if (damage > 2) {
                        world.setBlockToAir(x, y, z);
                        world.playAuxSFX(1020, x, y, z, 0);
                    } else {
                        world.setBlockMetadataWithNotify(x, y, z, facing | (damage << 2), 2);
                        world.playSoundEffect(x + 0.5D, y + 0.5D, z + 0.5D, "nova_craft:vanite_anvil.use", 1.0F, 1.0F);
                    }
                } else if (!world.isRemote) {
                    world.playSoundEffect(x + 0.5D, y + 0.5D, z + 0.5D, "nova_craft:vanite_anvil.use", 1.0F, 1.0F);
                }
            }
        });

        for (int row = 0; row < 3; ++row)
            for (int col = 0; col < 9; ++col)
                this.addSlotToContainer(new Slot(playerInv, col + row * 9 + 9, 8 + col * 18, 84 + row * 18));
        for (int col = 0; col < 9; ++col)
            this.addSlotToContainer(new Slot(playerInv, col, 8 + col * 18, 142));
    }

    @Override
    public void onCraftMatrixChanged(IInventory inventory) {
        super.onCraftMatrixChanged(inventory);
        if (inventory == this.inputSlots) updateRepairOutput();
    }

    private int getXpReductionPoints() {
        int points = 0;

        for (int dx = -3; dx <= 3; dx++) {
            for (int dy = -3; dy <= 3; dy++) {
                for (int dz = -3; dz <= 3; dz++) {
                    if (dx == 0 && dy == 0 && dz == 0) continue;

                    Block block = world.getBlock(x + dx, y + dy, z + dz);

                    for (Map.Entry<Block, Integer> entry : XP_REDUCTION_BLOCKS.entrySet()) {
                        Block keyBlock = entry.getKey();

                        if (block.getUnlocalizedName().equals(keyBlock.getUnlocalizedName())) {
                            points += entry.getValue();

                            if (points >= 24) return 24;
                            break;
                        }
                    }
                }
            }
        }

        return points;
    }

    private float getXpMultiplier() {
        int points = getXpReductionPoints();

        if (points <= 0)
            return 1.0F;

        float multiplier = 1.0F - (points / 24.0F) * (1.0F - 0.33F);

        return Math.max(multiplier, 0.33F);
    }

    public void updateRepairOutput() {
        ItemStack left = this.inputSlots.getStackInSlot(0);
        ItemStack right = this.inputSlots.getStackInSlot(1);
        this.maximumCost = 0;
        this.stackSizeToBeUsedInRepair = 0;

        if (left == null) {
            this.outputSlot.setInventorySlotContents(0, null);
            return;
        }

        ItemStack result = left.copy();
        int baseCost = left.getRepairCost();
        int extraCost = 0;
        Map<Integer, Integer> enchants = EnchantmentHelper.getEnchantments(result);
        boolean itemChanged = false;

        if (left.getItem() == Items.enchanted_book && right != null && right.getItem() == Items.enchanted_book) {
            Map<Integer, Integer> rightEnchants = EnchantmentHelper.getEnchantments(right);
            for (Map.Entry<Integer, Integer> entry : rightEnchants.entrySet()) {
                int id = entry.getKey();
                Enchantment ench = Enchantment.enchantmentsList[id];
                int leftLvl = enchants.containsKey(id) ? enchants.get(id) : 0;
                int rightLvl = entry.getValue();
                int newLvl = leftLvl == rightLvl ? leftLvl + 1 : Math.max(leftLvl, rightLvl);
                if (newLvl > ench.getMaxLevel() + 2) newLvl = ench.getMaxLevel() + 2;
                enchants.put(id, newLvl);
                extraCost += 1 + newLvl;
                itemChanged = true;
            }
            this.stackSizeToBeUsedInRepair = 1;
        }

        //Enchanted Book + Tool/Equipment
        if (left.getItem() != Items.enchanted_book && right != null && right.getItem() == Items.enchanted_book) {
            Map<Integer, Integer> rightEnchants = EnchantmentHelper.getEnchantments(right);
            boolean applied = false;
            for (Map.Entry<Integer, Integer> entry : rightEnchants.entrySet()) {
                int id = entry.getKey();
                Enchantment ench = Enchantment.enchantmentsList[id];
                if (ench != null && ench.canApply(result)) {
                    int leftLvl = enchants.containsKey(id) ? enchants.get(id) : 0;
                    int rightLvl = entry.getValue();
                    int newLvl = leftLvl == rightLvl ? leftLvl + 1 : Math.max(leftLvl, rightLvl);
                    if (newLvl > ench.getMaxLevel() + 2) newLvl = ench.getMaxLevel() + 2;
                    enchants.put(id, newLvl);
                    extraCost += 1 + newLvl;
                    applied = true;
                    itemChanged = true;
                }
            }
            if (applied) this.stackSizeToBeUsedInRepair = 1;
        }

        //Repair Durability
        if (left.isItemStackDamageable() && right != null) {
            int leftDamage = left.getItemDamage();
            int maxRepairPerItem = Math.max(1, left.getMaxDamage() / 4);
            if (left.getItem() == right.getItem()) {
                int timesToUse = 0;
                int remainingDamage = leftDamage;
                while (remainingDamage > 0 && timesToUse < right.stackSize) {
                    int amt = Math.min(remainingDamage, maxRepairPerItem);
                    remainingDamage -= amt;
                    timesToUse++;
                }
                if (timesToUse > 0) {
                    result.setItemDamage(remainingDamage);
                    this.stackSizeToBeUsedInRepair = timesToUse;
                    extraCost += timesToUse;
                    itemChanged = true;
                }
            } else if (left.getItem().getIsRepairable(left, right)) {
                int timesToUse = 0;
                int remainingDamage = leftDamage;
                while (remainingDamage > 0 && timesToUse < right.stackSize) {
                    int amt = Math.min(remainingDamage, maxRepairPerItem);
                    remainingDamage -= amt;
                    timesToUse++;
                }
                if (timesToUse > 0) {
                    result.setItemDamage(remainingDamage);
                    this.stackSizeToBeUsedInRepair = timesToUse;
                    extraCost += timesToUse;
                    itemChanged = true;
                }
            }
        }

        //Outputs New Item
        if (itemChanged) {
            EnchantmentHelper.setEnchantments(enchants, result);
            result.setRepairCost(left.getRepairCost() + 1);
            int vanillaCost = Math.max(1, (baseCost + extraCost) * 21);
            float multiplier = getXpMultiplier();
            this.maximumCost = Math.max(1, Math.round(vanillaCost * multiplier));
            this.outputSlot.setInventorySlotContents(0, result);
        } else {
            this.outputSlot.setInventorySlotContents(0, null);
            this.maximumCost = 0;
        }
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int index) {
        ItemStack copy = null;
        Slot slot = (Slot) this.inventorySlots.get(index);
        if (slot != null && slot.getHasStack()) {
            ItemStack stack = slot.getStack();
            copy = stack.copy();
            if (index == 0) {
                if (!this.mergeItemStack(stack, 3, 39, true)) return null;
            } else if (index >= 3) {
                if (!this.mergeItemStack(stack, 0, 2, false)) return null;
            } else {
                if (!this.mergeItemStack(stack, 3, 39, false)) return null;
            }
            if (stack.stackSize == 0) slot.putStack(null);
            else slot.onSlotChanged();
            if (stack.stackSize == copy.stackSize) return null;
            slot.onPickupFromSlot(player, stack);
        }
        return copy;
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return this.world.getBlock(x, y, z) == NovaCraftBlocks.vanite_anvil && player.getDistanceSq(x + 0.5D, y + 0.5D, z + 0.5D) <= 64.0D;
    }

    @Override
    public void onContainerClosed(EntityPlayer player) {
        super.onContainerClosed(player);
        if (!this.world.isRemote) {
            for (int i = 0; i < this.inputSlots.getSizeInventory(); ++i) {
                ItemStack stack = this.inputSlots.getStackInSlotOnClosing(i);
                if (stack != null) player.dropPlayerItemWithRandomChoice(stack, false);
            }
        }
    }

    public void updateItemName(String name) {
        this.repairedItemName = name;
        this.updateRepairOutput();
    }

    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();

        updateRepairOutput();

        int xpCost = this.maximumCost;
        for (Object crafter : this.crafters) {
            ((ICrafting) crafter).sendProgressBarUpdate(this, 0, xpCost);
        }
    }

}
