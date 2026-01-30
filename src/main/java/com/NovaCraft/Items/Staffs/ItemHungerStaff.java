package com.NovaCraft.Items.Staffs;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.registry.NovaCraftCreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

public class ItemHungerStaff extends ItemSword {

    private final Random rand = new Random();

    public ItemHungerStaff() {
        super(ToolMaterial.EMERALD);
        this.setCreativeTab(NovaCraftCreativeTabs.tools);
        this.setMaxDamage(1361);
    }

    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        return repair.getItem() == NovaCraftItems.variegated_shard;
    }

    public void addInformation(final ItemStack stack, final EntityPlayer player, final List tooltip, final boolean who) {
        tooltip.add(EnumChatFormatting.GREEN + "" + StatCollector.translateToLocal("tooltip.hunger_staff.desc"));
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {

        if (!world.isRemote) {
            int foodLevel = player.getFoodStats().getFoodLevel();

            if (foodLevel < 17) {

                world.playSoundAtEntity(player, "random.burp", 0.5F, 0.9F + rand.nextFloat() * 0.2F);
                player.getFoodStats().addStats(1, 0.4F);

                if (rand.nextBoolean()) {
                    stack.damageItem(1, player);
                }
            }
        }

        return stack;
    }

}
