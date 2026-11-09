package com.NovaCraftBlocks.potion;

import java.util.Random;
import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.renderer.RenderIDs;
import com.NovaCraftBlocks.NovaCraftBlocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockCauldron;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockMercuryVaniteCauldron extends BlockCauldron {

    @SideOnly(Side.CLIENT)
    public IIcon inner, top, bottom, side;

    public static IIcon Mercury;
    public static IIcon Strength;
    public static IIcon Essence;
    public static IIcon Pherithium;
    public static IIcon Iridium;

    public BlockMercuryVaniteCauldron() {
        super();
        this.setHardness(12);
        this.setResistance(15);
        this.setTickRandomly(true);
        this.setCreativeTab((CreativeTabs)null);
    }

    protected boolean canSilkHarvest() {
        return false;
    }

    public Item getItemDropped(final int metadata, final Random rand, final int fortune) {
        return NovaCraftItems.vanite_cauldron_item;
    }

    @SideOnly(Side.CLIENT)
    public Item getItem(World world, int p_149694_2_, int p_149694_3_, int p_149694_4_)
    {
        return NovaCraftItems.vanite_cauldron_item;
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    @Override
    public int getLightValue(IBlockAccess world, int x, int y, int z) {
        return 0;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        if (side == 1) return this.top;
        if (side == 0) return this.bottom;
        return this.side;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister register) {
        this.inner = register.registerIcon("nova_craft:vanite_cauldron_inner");
        this.top = register.registerIcon("nova_craft:vanite_cauldron_top");
        this.bottom = register.registerIcon("nova_craft:vanite_cauldron_bottom");
        this.side = register.registerIcon("nova_craft:vanite_cauldron_side");

        this.blockIcon = this.side;

        BlockMercuryVaniteCauldron.Mercury = register.registerIcon("nova_craft:mercury_still");
        BlockMercuryVaniteCauldron.Strength = register.registerIcon("nova_craft:hg_strength");
        BlockMercuryVaniteCauldron.Essence = register.registerIcon("nova_craft:hg_essence");
        BlockMercuryVaniteCauldron.Pherithium = register.registerIcon("nova_craft:hg_pherithium");
        BlockMercuryVaniteCauldron.Iridium = register.registerIcon("nova_craft:hg_iridium");
    }

    @SideOnly(Side.CLIENT)
    public static IIcon getVaniteCauldronIcon(String name) {
        BlockMoltenVaniteCauldron block = (BlockMoltenVaniteCauldron) NovaCraftBlocks.vanite_cauldron;

        if (name.equals("inner")) return block.inner;
        if (name.equals("bottom")) return block.bottom;

        return null;
    }

    @Override
    public int tickRate(World world)
    {
        return 0;
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        int meta = world.getBlockMetadata(x, y, z);
        ItemStack held = player.getCurrentEquippedItem();
        if (held == null) return false;

        if (held.getItem() == (NovaCraftItems.vanite_bucket) && meta == 1) {
            if (!world.isRemote) {
                world.setBlock(x, y, z, NovaCraftBlocks.lava_vanite_cauldron, 0, 3);
                world.playSoundEffect((double)(x + 0.5f), (double)(y + 0.5f), (double)(z + 0.5f), "random.fizz", 0.5f, 2.6f + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8f);

                ItemStack potion = new ItemStack(NovaCraftItems.vanite_bucket_mercury, 1, 0);

                if (!player.inventory.addItemStackToInventory(potion)) {
                    player.dropPlayerItemWithRandomChoice(potion, false);
                }

                if (!player.capabilities.isCreativeMode) {
                    held.stackSize--;
                    if (held.stackSize <= 0) {
                        player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
                    }
                }

                player.inventory.markDirty();
                player.inventoryContainer.detectAndSendChanges();
            }

            return true;
        }

        else if (held.getItem() == (Items.bucket) && meta == 1) {
            if (!world.isRemote) {
                world.setBlock(x, y, z, NovaCraftBlocks.lava_vanite_cauldron, 0, 3);
                world.playSoundEffect((double)(x + 0.5f), (double)(y + 0.5f), (double)(z + 0.5f), "random.fizz", 0.5f, 2.6f + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8f);

                ItemStack potion = new ItemStack(NovaCraftItems.bucket_mercury, 1, 0);

                if (!player.inventory.addItemStackToInventory(potion)) {
                    player.dropPlayerItemWithRandomChoice(potion, false);
                }

                if (!player.capabilities.isCreativeMode) {
                    held.stackSize--;
                    if (held.stackSize <= 0) {
                        player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
                    }
                }

                player.inventory.markDirty();
                player.inventoryContainer.detectAndSendChanges();
            }

            return true;
        }

        if (held.getItem() == (NovaCraftItems.vanite_bottle) && meta == 1) {
            if (!world.isRemote) {
                world.setBlock(x, y, z, NovaCraftBlocks.mercury_vanite_cauldron, 2, 3);
                world.playSoundEffect((double)(x + 0.5f), (double)(y + 0.5f), (double)(z + 0.5f), "liquid.water", 0.5f, 2.6f + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8f);

                ItemStack potion = new ItemStack(NovaCraftItems.bottle_of_mercury, 1, 0);

                if (!player.inventory.addItemStackToInventory(potion)) {
                    player.dropPlayerItemWithRandomChoice(potion, false);
                }

                if (!player.capabilities.isCreativeMode) {
                    held.stackSize--;
                    if (held.stackSize <= 0) {
                        player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
                    }
                }

                player.inventory.markDirty();
                player.inventoryContainer.detectAndSendChanges();
            }

            return true;
        }

        if (held.getItem() == (NovaCraftItems.vanite_bottle) && meta == 2) {
            if (!world.isRemote) {
                world.setBlock(x, y, z, NovaCraftBlocks.mercury_vanite_cauldron, 3, 3);
                world.playSoundEffect((double)(x + 0.5f), (double)(y + 0.5f), (double)(z + 0.5f), "liquid.water", 0.5f, 2.6f + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8f);

                ItemStack potion = new ItemStack(NovaCraftItems.bottle_of_mercury, 1, 0);

                if (!player.inventory.addItemStackToInventory(potion)) {
                    player.dropPlayerItemWithRandomChoice(potion, false);
                }

                if (!player.capabilities.isCreativeMode) {
                    held.stackSize--;
                    if (held.stackSize <= 0) {
                        player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
                    }
                }

                player.inventory.markDirty();
                player.inventoryContainer.detectAndSendChanges();
            }

            return true;
        }

        if (held.getItem() == (NovaCraftItems.vanite_bottle) && meta == 3) {
            if (!world.isRemote) {
                world.setBlock(x, y, z, NovaCraftBlocks.lava_vanite_cauldron, 0, 3);
                world.playSoundEffect((double)(x + 0.5f), (double)(y + 0.5f), (double)(z + 0.5f), "liquid.water", 0.5f, 2.6f + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8f);

                ItemStack potion = new ItemStack(NovaCraftItems.bottle_of_mercury, 1, 0);

                if (!player.inventory.addItemStackToInventory(potion)) {
                    player.dropPlayerItemWithRandomChoice(potion, false);
                }

                if (!player.capabilities.isCreativeMode) {
                    held.stackSize--;
                    if (held.stackSize <= 0) {
                        player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
                    }
                }

                player.inventory.markDirty();
                player.inventoryContainer.detectAndSendChanges();
            }

            return true;
        }

        if (held.getItem() == (NovaCraftItems.bottle_of_mercury) && meta == 2) {
            if (!world.isRemote) {
                world.setBlock(x, y, z, NovaCraftBlocks.mercury_vanite_cauldron, 1, 3);
                world.playSoundEffect((double)(x + 0.5f), (double)(y + 0.5f), (double)(z + 0.5f), "liquid.water", 0.5f, 2.6f + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8f);

                ItemStack potion = new ItemStack(NovaCraftItems.vanite_bottle, 1, 0);

                if (!player.inventory.addItemStackToInventory(potion)) {
                    player.dropPlayerItemWithRandomChoice(potion, false);
                }

                if (!player.capabilities.isCreativeMode) {
                    held.stackSize--;
                    if (held.stackSize <= 0) {
                        player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
                    }
                }

                player.inventory.markDirty();
                player.inventoryContainer.detectAndSendChanges();
            }

            return true;
        }

        if (held.getItem() == (NovaCraftItems.bottle_of_mercury) && meta == 3) {
            if (!world.isRemote) {
                world.setBlock(x, y, z, NovaCraftBlocks.mercury_vanite_cauldron, 2, 3);
                world.playSoundEffect((double)(x + 0.5f), (double)(y + 0.5f), (double)(z + 0.5f), "liquid.water", 0.5f, 2.6f + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8f);

                ItemStack potion = new ItemStack(NovaCraftItems.vanite_bottle, 1, 0);

                if (!player.inventory.addItemStackToInventory(potion)) {
                    player.dropPlayerItemWithRandomChoice(potion, false);
                }

                if (!player.capabilities.isCreativeMode) {
                    held.stackSize--;
                    if (held.stackSize <= 0) {
                        player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
                    }
                }

                player.inventory.markDirty();
                player.inventoryContainer.detectAndSendChanges();
            }

            return true;
        }

        if (held.getItem() == (Items.glass_bottle) && meta == 1) {
            if (!world.isRemote) {
                world.setBlock(x, y, z, NovaCraftBlocks.mercury_vanite_cauldron, 2, 3);
                world.playSoundEffect((double)(x + 0.5f), (double)(y + 0.5f), (double)(z + 0.5f), "liquid.water", 0.5f, 2.6f + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8f);

                ItemStack potion = new ItemStack(NovaCraftItems.glass_bottle_of_mercury, 1, 0);

                if (!player.inventory.addItemStackToInventory(potion)) {
                    player.dropPlayerItemWithRandomChoice(potion, false);
                }

                if (!player.capabilities.isCreativeMode) {
                    held.stackSize--;
                    if (held.stackSize <= 0) {
                        player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
                    }
                }

                player.inventory.markDirty();
                player.inventoryContainer.detectAndSendChanges();
            }

            return true;
        }

        if (held.getItem() == (Items.glass_bottle) && meta == 2) {
            if (!world.isRemote) {
                world.setBlock(x, y, z, NovaCraftBlocks.mercury_vanite_cauldron, 3, 3);
                world.playSoundEffect((double)(x + 0.5f), (double)(y + 0.5f), (double)(z + 0.5f), "liquid.water", 0.5f, 2.6f + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8f);

                ItemStack potion = new ItemStack(NovaCraftItems.glass_bottle_of_mercury, 1, 0);

                if (!player.inventory.addItemStackToInventory(potion)) {
                    player.dropPlayerItemWithRandomChoice(potion, false);
                }

                if (!player.capabilities.isCreativeMode) {
                    held.stackSize--;
                    if (held.stackSize <= 0) {
                        player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
                    }
                }

                player.inventory.markDirty();
                player.inventoryContainer.detectAndSendChanges();
            }

            return true;
        }

        if (held.getItem() == (Items.glass_bottle) && meta == 3) {
            if (!world.isRemote) {
                world.setBlock(x, y, z, NovaCraftBlocks.lava_vanite_cauldron, 0, 3);
                world.playSoundEffect((double)(x + 0.5f), (double)(y + 0.5f), (double)(z + 0.5f), "liquid.water", 0.5f, 2.6f + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8f);

                ItemStack potion = new ItemStack(NovaCraftItems.glass_bottle_of_mercury, 1, 0);

                if (!player.inventory.addItemStackToInventory(potion)) {
                    player.dropPlayerItemWithRandomChoice(potion, false);
                }

                if (!player.capabilities.isCreativeMode) {
                    held.stackSize--;
                    if (held.stackSize <= 0) {
                        player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
                    }
                }

                player.inventory.markDirty();
                player.inventoryContainer.detectAndSendChanges();
            }

            return true;
        }

        if (held.getItem() == (NovaCraftItems.glass_bottle_of_mercury) && meta == 2) {
            if (!world.isRemote) {
                world.setBlock(x, y, z, NovaCraftBlocks.mercury_vanite_cauldron, 1, 3);
                world.playSoundEffect((double)(x + 0.5f), (double)(y + 0.5f), (double)(z + 0.5f), "liquid.water", 0.5f, 2.6f + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8f);

                ItemStack potion = new ItemStack(Items.glass_bottle, 1, 0);

                if (!player.inventory.addItemStackToInventory(potion)) {
                    player.dropPlayerItemWithRandomChoice(potion, false);
                }

                if (!player.capabilities.isCreativeMode) {
                    held.stackSize--;
                    if (held.stackSize <= 0) {
                        player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
                    }
                }

                player.inventory.markDirty();
                player.inventoryContainer.detectAndSendChanges();
            }

            return true;
        }

        if (held.getItem() == (NovaCraftItems.glass_bottle_of_mercury) && meta == 3) {
            if (!world.isRemote) {
                world.setBlock(x, y, z, NovaCraftBlocks.mercury_vanite_cauldron, 2, 3);
                world.playSoundEffect((double)(x + 0.5f), (double)(y + 0.5f), (double)(z + 0.5f), "liquid.water", 0.5f, 2.6f + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8f);

                ItemStack potion = new ItemStack(Items.glass_bottle, 1, 0);

                if (!player.inventory.addItemStackToInventory(potion)) {
                    player.dropPlayerItemWithRandomChoice(potion, false);
                }

                if (!player.capabilities.isCreativeMode) {
                    held.stackSize--;
                    if (held.stackSize <= 0) {
                        player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
                    }
                }

                player.inventory.markDirty();
                player.inventoryContainer.detectAndSendChanges();
            }

            return true;
        }

        if (held.getItem() == (NovaCraftItems.potion_strength_extended) && meta == 1) {
            if (!world.isRemote) {
                world.setBlock(x, y, z, NovaCraftBlocks.mercury_vanite_cauldron, 4, 3);
                world.playSoundEffect((double)(x + 0.5f), (double)(y + 0.5f), (double)(z + 0.5f), "liquid.water", 0.5f, 2.6f + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8f);

                ItemStack potion = new ItemStack(NovaCraftItems.vanite_bottle, 1, 0);

                if (!player.inventory.addItemStackToInventory(potion)) {
                    player.dropPlayerItemWithRandomChoice(potion, false);
                }

                if (!player.capabilities.isCreativeMode) {
                    held.stackSize--;
                    if (held.stackSize <= 0) {
                        player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
                    }
                }

                player.inventory.markDirty();
                player.inventoryContainer.detectAndSendChanges();
            }

            return true;
        }

        if (held.getItem() == (Items.potionitem) && held.getItemDamage() == 8265 && meta == 1) {
            if (!world.isRemote) {
                world.setBlock(x, y, z, NovaCraftBlocks.mercury_vanite_cauldron, 4, 3);
                world.playSoundEffect((double)(x + 0.5f), (double)(y + 0.5f), (double)(z + 0.5f), "liquid.water", 0.5f, 2.6f + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8f);

                ItemStack potion = new ItemStack(Items.glass_bottle, 1, 0);

                if (!player.inventory.addItemStackToInventory(potion)) {
                    player.dropPlayerItemWithRandomChoice(potion, false);
                }

                if (!player.capabilities.isCreativeMode) {
                    held.stackSize--;
                    if (held.stackSize <= 0) {
                        player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
                    }
                }

                player.inventory.markDirty();
                player.inventoryContainer.detectAndSendChanges();
            }

            return true;
        }

        if ((held.getItem() == NovaCraftItems.anomalous_essence) && meta == 4) {
            if (!world.isRemote) {
                world.setBlock(x, y, z, NovaCraftBlocks.mercury_vanite_cauldron, 5, 3);
                world.playSoundEffect((double)(x + 0.5f), (double)(y + 0.5f), (double)(z + 0.5f), "liquid.water", 0.5f, 2.6f + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8f);

                if (!player.capabilities.isCreativeMode) {
                    held.stackSize--;
                    if (held.stackSize <= 0) {
                        player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
                    }
                }

                player.inventory.markDirty();
                player.inventoryContainer.detectAndSendChanges();
            }

            return true;
        }

        if ((held.getItem() == NovaCraftItems.pherithium_ingot) && meta == 5) {
            if (!world.isRemote) {
                world.setBlock(x, y, z, NovaCraftBlocks.mercury_vanite_cauldron, 6, 3);
                world.playSoundEffect((double)(x + 0.5f), (double)(y + 0.5f), (double)(z + 0.5f), "liquid.water", 0.5f, 2.6f + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8f);

                if (!player.capabilities.isCreativeMode) {
                    held.stackSize--;
                    if (held.stackSize <= 0) {
                        player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
                    }
                }

                player.inventory.markDirty();
                player.inventoryContainer.detectAndSendChanges();
            }

            return true;
        }

        if ((held.getItem() == NovaCraftItems.iridium_nugget) && held.getItemDamage() == 0 && meta == 6) {
            if (!world.isRemote) {
                world.setBlock(x, y, z, NovaCraftBlocks.mercury_vanite_cauldron, 7, 3);
                world.playSoundEffect((double)(x + 0.5f), (double)(y + 0.5f), (double)(z + 0.5f), "liquid.water", 0.5f, 2.6f + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8f);

                if (!player.capabilities.isCreativeMode) {
                    held.stackSize--;
                    if (held.stackSize <= 0) {
                        player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
                    }
                }

                player.inventory.markDirty();
                player.inventoryContainer.detectAndSendChanges();
            }

            return true;
        }

        if ((held.getItem() == NovaCraftItems.wyrmling_scales) && meta == 7) {
            if (!world.isRemote) {
                world.setBlock(x, y, z, NovaCraftBlocks.cracked_mercuridium_cauldron, 0, 3);
                world.playSoundEffect((double)(x + 0.5f), (double)(y + 0.5f), (double)(z + 0.5f), "random.fizz", 0.5f, 2.6f + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8f);
                if (!player.capabilities.isCreativeMode) {
                    held.stackSize--;
                    if (held.stackSize <= 0) {
                        player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
                    }
                }

                player.inventory.markDirty();
                player.inventoryContainer.detectAndSendChanges();
            }

            return true;
        }

        return false;
    }




    @Override
    public int getRenderType()
    {
        return RenderIDs.MERCURY_VANITE_CAULDRON;
    }

    @SideOnly(Side.CLIENT)
    public static float getRenderLiquidLevel(int p_150025_0_)
    {
        int j = MathHelper.clamp_int(p_150025_0_, 0, 3);
        return (float)(6 + 3 * j) / 16.0F;
    }

}
