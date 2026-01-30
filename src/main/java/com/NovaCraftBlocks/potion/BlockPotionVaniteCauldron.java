package com.NovaCraftBlocks.potion;

import java.util.Random;
import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.particles.ParticleHandler;
import com.NovaCraft.renderer.RenderIDs;
import com.NovaCraftBlocks.NovaCraftBlocks;
import com.NovaCraftBlocks.ores.BlockReinforcedVanite;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCauldron;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockPotionVaniteCauldron extends BlockCauldron {

    @SideOnly(Side.CLIENT)
    public IIcon inner, top, bottom, side;

    public static IIcon Ytrlinisite_Potion;
    public static IIcon Completed_Deepoid_Potion;

    public static IIcon Crystallized_End_Potion;
    public static IIcon Wardling_Dust_Potion;
    public static IIcon Warden_Dust_Potion;
    public static IIcon Static_Blend_Potion;

    public BlockPotionVaniteCauldron() {
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
    public Item getItem(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_)
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
        int meta = world.getBlockMetadata(x, y, z);

        if (meta == 0 || meta == 3) {
            return 7;
        }
        else if (meta == 1 || meta == 4) {
            return 10;
        }
        else if (meta == 2 || meta == 5) {
            return 14;
        }
        else {
            return 0;
        }
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

        BlockPotionVaniteCauldron.Ytrlinisite_Potion = register.registerIcon("nova_craft:yttrlinisite_potion");
        BlockPotionVaniteCauldron.Completed_Deepoid_Potion = register.registerIcon("nova_craft:complete_deepoid_blend");
        BlockPotionVaniteCauldron.Crystallized_End_Potion = register.registerIcon("nova_craft:crystallized_end_blend");
        BlockPotionVaniteCauldron.Wardling_Dust_Potion = register.registerIcon("nova_craft:wardling_dust_blend");
        BlockPotionVaniteCauldron.Warden_Dust_Potion = register.registerIcon("nova_craft:warden_dust_blend");
        BlockPotionVaniteCauldron.Static_Blend_Potion = register.registerIcon("nova_craft:static_essence_blend");
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

        if ((held.getItem() == NovaCraftItems.deepoid_horn) && meta == 0) {

            if (!world.isRemote) {

                world.setBlockMetadataWithNotify(x, y, z, 3, 3);

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

        else if ((held.getItem() == NovaCraftItems.deepoid_horn) && meta == 1) {

            if (!world.isRemote) {

                world.setBlockMetadataWithNotify(x, y, z, 4, 3);

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

        if ((held.getItem() == NovaCraftItems.deepoid_horn) && meta == 2) {

            if (!world.isRemote) {

                world.setBlockMetadataWithNotify(x, y, z, 5, 3);

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

        else if (held.getItem() == (NovaCraftItems.vanite_bottle) && meta == 3) {

            if (!world.isRemote) {

                world.setBlock(x, y, z, NovaCraftBlocks.lava_vanite_cauldron, 0, 3);

                ItemStack potion = new ItemStack(NovaCraftItems.deepfire_blend, 1, 0);

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

        else if (held.getItem() == (NovaCraftItems.vanite_bottle) && meta == 4) {

            if (!world.isRemote) {

                world.setBlockMetadataWithNotify(x, y, z, 3, 3);

                // Give correct empty bucket
                ItemStack potion = new ItemStack(NovaCraftItems.deepfire_blend, 1, 0);

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

        else if (held.getItem() == (NovaCraftItems.vanite_bottle) && meta == 5) {

            if (!world.isRemote) {

                world.setBlockMetadataWithNotify(x, y, z, 4, 3);

                ItemStack potion = new ItemStack(NovaCraftItems.deepfire_blend, 1, 0);

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

        else if (held.getItem() == (NovaCraftItems.crystallized_end_shard) && meta == 3) {

            if (!world.isRemote) {

                world.setBlockMetadataWithNotify(x, y, z, 6, 3);

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

        else if (held.getItem() == (NovaCraftItems.crystallized_end_shard) && meta == 4) {

            if (!world.isRemote) {

                world.setBlockMetadataWithNotify(x, y, z, 7, 3);

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

        else if (held.getItem() == (NovaCraftItems.crystallized_end_shard) && meta == 5) {

            if (!world.isRemote) {

                world.setBlockMetadataWithNotify(x, y, z, 8, 3);

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

        else if (held.getItem() == (NovaCraftItems.wardling_dust) && meta == 6) {

            if (!world.isRemote) {

                world.setBlockMetadataWithNotify(x, y, z, 9, 3);

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

        else if (held.getItem() == (NovaCraftItems.wardling_dust) && meta == 7) {

            if (!world.isRemote) {

                world.setBlockMetadataWithNotify(x, y, z, 10, 3);

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

        else if (held.getItem() == (NovaCraftItems.wardling_dust) && meta == 8) {

            if (!world.isRemote) {

                world.setBlockMetadataWithNotify(x, y, z, 11, 3);

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

        else if (held.getItem() == (NovaCraftItems.warden_dust) && meta == 9) {

            if (!world.isRemote) {

                world.setBlockMetadataWithNotify(x, y, z, 12, 3);

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

        else if (held.getItem() == (NovaCraftItems.warden_dust) && meta == 10) {

            if (!world.isRemote) {

                world.setBlockMetadataWithNotify(x, y, z, 13, 3);

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

        else if (held.getItem() == (NovaCraftItems.warden_dust) && meta == 11) {

            if (!world.isRemote) {

                world.setBlockMetadataWithNotify(x, y, z, 14, 3);

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

        else if (held.getItem() == (NovaCraftItems.static_essence) && meta == 12) {

            if (!world.isRemote) {

                world.setBlockMetadataWithNotify(x, y, z, 15, 3);

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

        else if (held.getItem() == (NovaCraftItems.static_essence) && meta == 13) {

            if (!world.isRemote) {

                world.setBlock(x, y, z, NovaCraftBlocks.lava_vanite_cauldron, 14, 3);

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

        else if ((held.getItem() == NovaCraftItems.static_essence) && meta == 14) {

            if (!world.isRemote) {

                world.setBlock(x, y, z, NovaCraftBlocks.lava_vanite_cauldron, 15, 3);

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

        else if (held.getItem() == (NovaCraftItems.vanite_bottle) && meta == 15) {

            if (!world.isRemote) {

                world.setBlock(x, y, z, NovaCraftBlocks.lava_vanite_cauldron, 0, 3);

                ItemStack potion = new ItemStack(NovaCraftItems.static_blend, 1, 0);

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

        return false;
    }


    @Override
    public int getRenderType()
    {
        return RenderIDs.POTION_VANITE_CAULDRON;
    }

    @SideOnly(Side.CLIENT)
    public static float getRenderLiquidLevel(int p_150025_0_)
    {
        int j = MathHelper.clamp_int(p_150025_0_, 0, 3);
        return (float)(6 + 3 * j) / 16.0F;
    }

}