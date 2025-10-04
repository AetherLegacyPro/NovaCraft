package com.NovaCraftBlocks.container;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.particles.ParticleHandler;
import com.NovaCraft.sounds.ModSounds;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.Random;

public class BlockAncientWarper extends Block {

    @SideOnly(Side.CLIENT)
    private IIcon iconFace, iconTop;

    public BlockAncientWarper() {
        super(Material.portal);
        this.setLightLevel(0.48F);
        this.setTickRandomly(true);
        this.setBlockUnbreakable();
        this.setResistance(600000000);
        this.setStepSound(ModSounds.soundNullstone);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta){
        return side == 0 || side == 1 ? iconTop : meta >= 1 && side-1 == meta ? iconFace : blockIcon;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister){
        blockIcon = iconRegister.registerIcon("nova_craft:ancient_warper_side");
        iconFace = iconRegister.registerIcon("nova_craft:ancient_warper_top");
        iconTop = iconRegister.registerIcon("nova_craft:ancient_warper_top");
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        if (world.isRemote) {
            return true;
        }

        //Get player held item
        if (player.getHeldItem() != null && (player.getHeldItem().getItem() == Items.diamond || player.getHeldItem().getItem() == Items.emerald
                || player.getHeldItem().getItem() == Items.iron_ingot || player.getHeldItem().getItem() == Items.gold_ingot
                || player.getHeldItem().getItem() == NovaCraftItems.vanite_ingot || player.getHeldItem().getItem() == NovaCraftItems.tophinite_gemstone)) {

            //Checks if the player is above the block or not
            int playerX = (int) Math.floor(player.posX);
            int playerY = (int) Math.floor(player.posY - 1);
            int playerZ = (int) Math.floor(player.posZ);

            if (playerX == x && playerY == y && playerZ == z) {

                Random rand = new Random();

                //Obtains the player's postion and telports them
                if (player.getHeldItem() != null && (player.getHeldItem().getItem() == Items.diamond || player.getHeldItem().getItem() == Items.emerald)) {
                    int offsetX = rand.nextInt(20001) - 10000;
                    int offsetZ = rand.nextInt(20001) - 10000;
                    int newX = x + offsetX;
                    int newZ = z + offsetZ;

                //Finds the top block at the location
                int newY = world.getTopSolidOrLiquidBlock(newX, newZ);

                //Teleports player
                player.setPositionAndUpdate(newX + 0.5, newY + 1, newZ + 0.5);
                } else if (player.getHeldItem() != null && (player.getHeldItem().getItem() == Items.iron_ingot || player.getHeldItem().getItem() == Items.gold_ingot)) {
                    int offsetX = rand.nextInt(20001) - 15000;
                    int offsetZ = rand.nextInt(20001) - 15000;
                    int newX = x + offsetX;
                    int newZ = z + offsetZ;

                    //Finds the top block at the location
                    int newY = world.getTopSolidOrLiquidBlock(newX, newZ);

                    //Teleports player
                    player.setPositionAndUpdate(newX + 0.5, newY + 1, newZ + 0.5);
                } else if (player.getHeldItem() != null && player.getHeldItem().getItem() == NovaCraftItems.vanite_ingot) {
                    int offsetX = rand.nextInt(20001) - 12500;
                    int offsetZ = rand.nextInt(20001) - 12500;
                    int newX = x + offsetX;
                    int newZ = z + offsetZ;

                    int newY = world.getTopSolidOrLiquidBlock(newX, newZ);

                    player.setPositionAndUpdate(newX + 0.5, newY + 1, newZ + 0.5);
                } else if (player.getHeldItem() != null && player.getHeldItem().getItem() == NovaCraftItems.tophinite_gemstone) {
                    int offsetX = rand.nextInt(20001) - 1;
                    int offsetZ = rand.nextInt(20001) - 1;
                    int newX = x + offsetX;
                    int newZ = z + offsetZ;

                    int newY = world.getTopSolidOrLiquidBlock(newX, newZ);

                    player.setPositionAndUpdate(newX + 0.5, newY + 1, newZ + 0.5);
                } else {
                    int offsetX = rand.nextInt(20001) - 10000;
                    int offsetZ = rand.nextInt(20001) - 10000;
                    int newX = x + offsetX;
                    int newZ = z + offsetZ;

                    int newY = world.getTopSolidOrLiquidBlock(newX, newZ);

                    player.setPositionAndUpdate(newX + 0.5, newY + 1, newZ + 0.5);
                }

                if (!player.capabilities.isCreativeMode) {
                    player.getHeldItem().stackSize--;
                    if (player.getHeldItem().stackSize <= 0) {
                        player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
                    }
                }

                world.playSoundEffect(player.posX, player.posY, player.posZ, "portal.portal", 1.0F, 1.0F);

                return true;
            }
        }

        return false;
    }



    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_)
    {
        if (!p_149734_1_.isRemote) {
            return;
        }

        if (net.minecraft.client.Minecraft.getMinecraft().gameSettings.particleSetting == 2) {
            return;
        }

        int l = p_149734_1_.getBlockMetadata(p_149734_2_, p_149734_3_, p_149734_4_);
        double d0 = (double)((float)p_149734_2_ + 0.5F + (p_149734_5_.nextFloat()) - (p_149734_5_.nextFloat()));
        double d1 = (double)((float)p_149734_3_ + 1.0F);
        double d2 = (double)((float)p_149734_4_ + 0.5F + (p_149734_5_.nextFloat()) - (p_149734_5_.nextFloat()));
        double d3 = 0.2199999988079071D;
        double d4 = 0.27000001072883606D;

        if (l == 1)
        {
            p_149734_1_.spawnParticle("portal", d0 - d4, d1 + d3, d2, 0.0D, 0.08D, 0.0D);
        }
        else if (l == 2)
        {
            p_149734_1_.spawnParticle("portal", d0 - d4, d1 + d3, d2, 0.0D, 0.08D, 0.0D);
        }
        else if (l == 3)
        {
            p_149734_1_.spawnParticle("portal", d0 - d4, d1 + d3, d2, 0.0D, 0.08D, 0.0D);
        }
        else if (l == 4)
        {
            p_149734_1_.spawnParticle("portal", d0 - d4, d1 + d3, d2, 0.0D, 0.08D, 0.0D);
        }
        else
        {
            p_149734_1_.spawnParticle("portal", d0 - d4, d1 + d3, d2, 0.0D, 0.08D, 0.0D);
        }
    }

}
