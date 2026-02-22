package com.NovaCraft.Items;

import com.NovaCraft.achievements.AchievementsNovaCraft;
import com.NovaCraft.entity.CrimsonDragon.EntityCrimsonDragon;
import com.NovaCraft.entity.EntityFireProofItemNovaCraft;
import com.NovaCraft.registry.NovaCraftCreativeTabs;
import com.NovaCraftBlocks.NovaCraftBlocks;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class ItemCrimsonStar extends Item {

    private IIcon[] icon;

    public ItemCrimsonStar() {
        this.icon = new IIcon[1];
        maxStackSize = 1;
        this.setCreativeTab(NovaCraftCreativeTabs.items);
    }

    public void registerBlockIcons(final IIconRegister iconRegister) {
        this.icon[0] = iconRegister.registerIcon("nova_craft:crimson_star");
    }

    public IIcon getIcon(final int side, int meta) {
        if (meta < 0 || meta >= this.icon.length) {
            meta = 1;
        }
        return this.icon[meta];
    }

    public Entity createEntity(final World world, final Entity location, final ItemStack itemstack) {
        return (Entity)new EntityFireProofItemNovaCraft(world, location, itemstack);
    }

    @Override
    public boolean hasEffect(ItemStack stack, int pass) {
        return true;
    }

    @Override
    public boolean onItemUse(ItemStack heldItem, EntityPlayer player, World world, int x, int y, int z, int facing, float hitX, float hitY, float hitZ) {

        if (world.provider.dimensionId == 0) {
            if (world.getBlock(x, y, z) == NovaCraftBlocks.deep_one_egg_activated) {

                //player.triggerAchievement(AchievementsNovaCraft.the_nether_dragon);
                world.playSoundEffect(x, y, z, "nova_craft:boss.DOsummoning", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
                --heldItem.stackSize;

                if (!world.isRemote)
                {
                    EntityCrimsonDragon dragon = new EntityCrimsonDragon(world);
                    dragon.setLocationAndAngles((double)x + 0.5D, (double)y + 20D, (double)z + 0.5D, 0.0F, 0.0F);
                    world.spawnEntityInWorld(dragon);
                    dragon.spawnExplosionParticle();
                }

                world.setBlock(x, y, z, Blocks.air, 0, 2);
            }
        }
        return true;
    }

}
