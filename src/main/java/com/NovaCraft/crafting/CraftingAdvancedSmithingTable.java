package com.NovaCraft.crafting;

import net.minecraft.init.*;

import net.minecraft.item.crafting.*;
import java.util.*;
import net.minecraft.item.*;
import net.minecraft.block.*;
import net.minecraft.inventory.*;
import net.minecraft.world.*;

public class CraftingAdvancedSmithingTable
{
    private static final CraftingAdvancedSmithingTable instance;
    private final List recipes;
    
    public static final CraftingAdvancedSmithingTable getInstance() {
        return CraftingAdvancedSmithingTable.instance;
    }
    
    public CraftingAdvancedSmithingTable() {
        this.recipes = new ArrayList();
        this.addRecipe(new ItemStack(Blocks.nether_brick_fence, 6), "###", "###", '#', Blocks.nether_brick);
        this.addRecipe(new ItemStack(Blocks.glowstone, 1), "##", "##", '#', Items.glowstone_dust);
        this.addRecipe(new ItemStack(Blocks.quartz_block, 1), "##", "##", '#', Items.quartz);
        this.addRecipe(new ItemStack(Blocks.nether_brick_stairs, 4), "#  ", "## ", "###", '#', Blocks.nether_brick);
        this.addRecipe(new ItemStack(Blocks.quartz_stairs, 4), "#  ", "## ", "###", '#', Blocks.quartz_block);
        this.addShapelessRecipe(new ItemStack(Items.flint_and_steel, 1), new ItemStack(Items.iron_ingot, 1), new ItemStack(Items.flint, 1));
        Collections.sort((List<Object>)this.recipes, new Comparator() {
            public int compare(final IRecipe p_compare_1_, final IRecipe p_compare_2_) {
                return (p_compare_1_ instanceof ShapelessRecipes && p_compare_2_ instanceof ShapedRecipes) ? 1 : ((p_compare_2_ instanceof ShapelessRecipes && p_compare_1_ instanceof ShapedRecipes) ? -1 : ((p_compare_2_.getRecipeSize() < p_compare_1_.getRecipeSize()) ? -1 : ((p_compare_2_.getRecipeSize() > p_compare_1_.getRecipeSize()) ? 1 : 0)));
            }
            
            @Override
            public int compare(final Object p_compare_1_, final Object p_compare_2_) {
                return this.compare((IRecipe)p_compare_1_, (IRecipe)p_compare_2_);
            }
        });
    }
    
    public ShapedRecipes addRecipe(final ItemStack p_92103_1_, final Object... p_92103_2_) {
        String s = "";
        int i = 0;
        int j = 0;
        int k = 0;
        if (p_92103_2_[i] instanceof String[]) {
            final String[] astring = (String[])p_92103_2_[i++];
            for (int l = 0; l < astring.length; ++l) {
                final String s2 = astring[l];
                ++k;
                j = s2.length();
                s += s2;
            }
        }
        else {
            while (p_92103_2_[i] instanceof String) {
                final String s3 = (String)p_92103_2_[i++];
                ++k;
                j = s3.length();
                s += s3;
            }
        }
        final HashMap hashmap = new HashMap();
        while (i < p_92103_2_.length) {
            final Character character = (Character)p_92103_2_[i];
            ItemStack itemstack1 = null;
            if (p_92103_2_[i + 1] instanceof Item) {
                itemstack1 = new ItemStack((Item)p_92103_2_[i + 1]);
            }
            else if (p_92103_2_[i + 1] instanceof Block) {
                itemstack1 = new ItemStack((Block)p_92103_2_[i + 1], 1, 32767);
            }
            else if (p_92103_2_[i + 1] instanceof ItemStack) {
                itemstack1 = (ItemStack)p_92103_2_[i + 1];
            }
            hashmap.put(character, itemstack1);
            i += 2;
        }
        final ItemStack[] aitemstack = new ItemStack[j * k];
        for (int i2 = 0; i2 < j * k; ++i2) {
            final char c0 = s.charAt(i2);
            if (hashmap.containsKey(c0)) {
                aitemstack[i2] = ((ItemStack) hashmap.get(c0)).copy();
            }
            else {
                aitemstack[i2] = null;
            }
        }
        final ShapedRecipes shapedrecipes = new ShapedRecipes(j, k, aitemstack, p_92103_1_);
        this.recipes.add(shapedrecipes);
        return shapedrecipes;
    }
    
    public void addShapelessRecipe(final ItemStack p_77596_1_, final Object... p_77596_2_) {
        final ArrayList arraylist = new ArrayList();
        final Object[] aobject = p_77596_2_;
        for (int i = p_77596_2_.length, j = 0; j < i; ++j) {
            final Object object1 = aobject[j];
            if (object1 instanceof ItemStack) {
                arraylist.add(((ItemStack)object1).copy());
            }
            else if (object1 instanceof Item) {
                arraylist.add(new ItemStack((Item)object1));
            }
            else {
                if (!(object1 instanceof Block)) {
                    throw new RuntimeException("Invalid shapeless recipy!");
                }
                arraylist.add(new ItemStack((Block)object1));
            }
        }
        this.recipes.add(new ShapelessRecipes(p_77596_1_, (List)arraylist));
    }
    
    public ItemStack findMatchingRecipe(final InventoryCrafting p_82787_1_, final World p_82787_2_) {
        int i = 0;
        ItemStack itemstack = null;
        ItemStack itemstack2 = null;
        for (int j = 0; j < p_82787_1_.getSizeInventory(); ++j) {
            final ItemStack itemstack3 = p_82787_1_.getStackInSlot(j);
            if (itemstack3 != null) {
                if (i == 0) {
                    itemstack = itemstack3;
                }
                if (i == 1) {
                    itemstack2 = itemstack3;
                }
                ++i;
            }
        }
        if (i == 2 && itemstack.getItem() == itemstack2.getItem() && itemstack.stackSize == 1 && itemstack2.stackSize == 1 && itemstack.getItem().isRepairable()) {
            final Item item = itemstack.getItem();
            final int j2 = item.getMaxDamage() - itemstack.getItemDamageForDisplay();
            final int k = item.getMaxDamage() - itemstack2.getItemDamageForDisplay();
            final int l = j2 + k + item.getMaxDamage() * 5 / 100;
            int i2 = item.getMaxDamage() - l;
            if (i2 < 0) {
                i2 = 0;
            }
            return new ItemStack(itemstack.getItem(), 1, i2);
        }
        for (int j = 0; j < this.recipes.size(); ++j) {
            final IRecipe irecipe = (IRecipe) this.recipes.get(j);
            if (irecipe.matches(p_82787_1_, p_82787_2_)) {
                return irecipe.getCraftingResult(p_82787_1_);
            }
        }
        return null;
    }
    
    public List getRecipeList() {
        return this.recipes;
    }
    
    static {
        instance = new CraftingAdvancedSmithingTable();
    }
}
