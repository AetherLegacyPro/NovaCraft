package com.NovaCraft.Item.Block;

import com.NovaCraft.entity.EntityFireProofItemNovaCraft;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemBlockFireProof extends ItemBlock {

	public ItemBlockFireProof(final Block block) {
        super(block);
        this.setMaxDamage(0);
    }
	
	public boolean hasCustomEntity(final ItemStack stack) {
        return true;
    }
    
    public Entity createEntity(final World world, final Entity location, final ItemStack itemstack) {
        return (Entity)new EntityFireProofItemNovaCraft(world, location, itemstack);
    }

}
