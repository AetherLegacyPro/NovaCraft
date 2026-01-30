package com.NovaCraftBlocks.potion;

import java.util.Random;
import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.config.Configs;
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

public class BlockLavaVaniteCauldron extends BlockCauldron {

    @SideOnly(Side.CLIENT)
    public IIcon inner, top, bottom, side;

    public static IIcon Lava;
    public static IIcon Healing_PotionII;
    public static IIcon Relik_Potion;
    public static IIcon Ender_Potion;
    public static IIcon Completed_Potion;

    public BlockLavaVaniteCauldron() {
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

        if (meta == 1) {
            return 15;
        }

        return 0;
    }

    @Override
    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
        boolean flag = (int)entity.prevPosX != (int)entity.posX || (int)entity.prevPosY != (int)entity.posY || (int)entity.prevPosZ != (int)entity.posZ;
        int meta = world.getBlockMetadata(x, y, z);

        if (meta == 1) {
            if ((flag || entity.ticksExisted % 25 == 0)) {
                entity.motionY = 0.20000000298023224D;
                entity.motionX = (world.rand.nextFloat() - world.rand.nextFloat()) * 0.2F;
                entity.motionZ = (world.rand.nextFloat() - world.rand.nextFloat()) * 0.2F;
                entity.playSound("random.fizz", 0.4F, 2.0F + world.rand.nextFloat() * 0.4F);
            }
            if (!world.isRemote) {
                entity.attackEntityFrom(DamageSource.lava, 2.0F);
                entity.setFire(10);
            }
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

        BlockLavaVaniteCauldron.Lava = register.registerIcon("minecraft:lava_still");
        BlockLavaVaniteCauldron.Healing_PotionII = register.registerIcon("nova_craft:healing_potion");
        BlockLavaVaniteCauldron.Relik_Potion = register.registerIcon("nova_craft:relik_potion");
        BlockLavaVaniteCauldron.Ender_Potion = register.registerIcon("nova_craft:ender_potion");
        BlockLavaVaniteCauldron.Completed_Potion = register.registerIcon("nova_craft:complete_darkness_potion");
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
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, int i, int j, int k, Random random) {
        float min = 0.125F;
        float max = 0.875F;
        double d0 = i + (min + random.nextFloat() * (max - min));
        double d1 = k + (min + random.nextFloat() * (max - min));
        int meta = world.getBlockMetadata(i, j, k);

        if (meta == 1) {
            if (world.canBlockSeeTheSky(i, j + 1, k) && world.isRaining()) {
                world.spawnParticle("smoke", d0, j + 0.9375F, d1, 0.0D, 0.0D, 0.0D);
            }
            if (random.nextInt(100) == 0) {
                world.spawnParticle("lava", d0, j + 0.9375F, d1, 0.0D, 0.0D, 0.0D);
                world.playSound(i + .5, j + 1, k + 0.5, "liquid.lavapop", 0.2F + random.nextFloat() * 0.2F, 0.9F + random.nextFloat() * 0.15F, false);
            }
            if (random.nextInt(200) == 0) {
                world.playSound(i + .5, j + 1, k + 0.5, "liquid.lava", 0.2F + random.nextFloat() * 0.2F, 0.9F + random.nextFloat() * 0.15F, false);
            }
        }

    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        int meta = world.getBlockMetadata(x, y, z);
        ItemStack held = player.getCurrentEquippedItem();
        if (held == null) return false;

        if (held.getItem() == Items.lava_bucket || held.getItem() == NovaCraftItems.vanite_bucket_lava) {

            if (!world.isRemote) {

                // Change block metadata
                world.setBlockMetadataWithNotify(x, y, z, 1, 3);

                // Give correct empty bucket
                ItemStack bucket = (held.getItem() == Items.lava_bucket) ? new ItemStack(Items.bucket) : new ItemStack(NovaCraftItems.vanite_bucket);

                if (!player.inventory.addItemStackToInventory(bucket)) {
                    player.dropPlayerItemWithRandomChoice(bucket, false);
                }

                // Consume one lava bucket
                if (!player.capabilities.isCreativeMode) {
                    held.stackSize--;
                    if (held.stackSize <= 0) {
                        player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
                    }
                }

                world.playSoundEffect((double)((float)x + 0.5F), (double)((float)y + 0.5F), (double)((float)z + 0.5F), "random.fizz", 0.5F, 2.6F + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8F);
                player.inventory.markDirty();
                player.inventoryContainer.detectAndSendChanges();
            }

            return true;
        }

        else if ((held.getItem() == Items.bucket || held.getItem() == NovaCraftItems.vanite_bucket) && meta == 1) {

            if (!world.isRemote) {

                // Change block metadata
                world.setBlockMetadataWithNotify(x, y, z, 0, 3);

                // Give correct empty bucket
                ItemStack bucket = (held.getItem() == Items.bucket) ? new ItemStack(Items.lava_bucket) : new ItemStack(NovaCraftItems.vanite_bucket_lava);

                if (!player.inventory.addItemStackToInventory(bucket)) {
                    player.dropPlayerItemWithRandomChoice(bucket, false);
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

        else if ((held.getItem() == Items.bucket) && meta == 1) {

            if (!world.isRemote) {

                // Change block metadata
                world.setBlockMetadataWithNotify(x, y, z, 0, 3);

                // Give correct empty bucket
                ItemStack bucket = (held.getItem() == Items.bucket) ? new ItemStack(Items.lava_bucket) : new ItemStack(NovaCraftItems.vanite_bucket_lava);

                if (!player.inventory.addItemStackToInventory(bucket)) {
                    player.dropPlayerItemWithRandomChoice(bucket, false);
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

        else if (held.getItem() instanceof ItemBlock) {
            ItemBlock itemBlock = (ItemBlock) held.getItem();
            Block block = itemBlock.field_150939_a;

            if (block == NovaCraftBlocks.block_of_reinforced_vanite) {

                if (!world.isRemote) {
                    world.setBlock(x, y, z, NovaCraftBlocks.vanite_cauldron, 0, 3);

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
        }

        else if (held.getItem() == (Items.potionitem) && held.getItemDamage() == 8229 && meta == 0) {

            if (!world.isRemote) {

                // Change block metadata
                world.setBlockMetadataWithNotify(x, y, z, 2, 3);

                // Give correct empty bucket
                ItemStack potion = new ItemStack(Items.glass_bottle);

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

        else if (held.getItem() == (Items.potionitem) && held.getItemDamage() == 8229 && meta == 2) {

            if (!world.isRemote) {

                // Change block metadata
                world.setBlockMetadataWithNotify(x, y, z, 3, 3);

                // Give correct empty bucket
                ItemStack potion = new ItemStack(Items.glass_bottle);

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

        else if (held.getItem() == (Items.potionitem) && held.getItemDamage() == 8229 && meta == 3) {

            if (!world.isRemote) {

                // Change block metadata
                world.setBlockMetadataWithNotify(x, y, z, 4, 3);

                // Give correct empty bucket
                ItemStack potion = new ItemStack(Items.glass_bottle);

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

        else if (held.getItem() == (Items.glass_bottle) && meta == 4) {

            if (!world.isRemote) {

                // Change block metadata
                world.setBlockMetadataWithNotify(x, y, z, 3, 3);

                // Give correct empty bucket
                ItemStack potion = new ItemStack(Items.potionitem, 1, 8229);

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

        else if (held.getItem() == (Items.glass_bottle) && meta == 3) {

            if (!world.isRemote) {

                // Change block metadata
                world.setBlockMetadataWithNotify(x, y, z, 2, 3);

                // Give correct empty bucket
                ItemStack potion = new ItemStack(Items.potionitem, 1, 8229);

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

        else if (held.getItem() == (Items.glass_bottle) && meta == 2) {

            if (!world.isRemote) {

                // Change block metadata
                world.setBlockMetadataWithNotify(x, y, z, 0, 3);

                // Give correct empty bucket
                ItemStack potion = new ItemStack(Items.potionitem, 1, 8229);

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

        else if ((held.getItem() == NovaCraftItems.relik_dust || held.getItem() == NovaCraftItems.static_essence) && !Configs.enableAlternateEndPortalSealentRecipe && meta == 2) {

            if (!world.isRemote) {

                // Change block metadata
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

        else if ((held.getItem() == NovaCraftItems.relik_dust || held.getItem() == NovaCraftItems.static_essence) && !Configs.enableAlternateEndPortalSealentRecipe && meta == 3) {

            if (!world.isRemote) {

                // Change block metadata
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

        else if ((held.getItem() == NovaCraftItems.relik_dust || held.getItem() == NovaCraftItems.static_essence) && !Configs.enableAlternateEndPortalSealentRecipe && meta == 4) {

            if (!world.isRemote) {

                // Change block metadata
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

        else if (held.getItem() == (NovaCraftItems.vanite_bottle) && meta == 11) {

            if (!world.isRemote) {

                // Change block metadata
                world.setBlockMetadataWithNotify(x, y, z, 0, 3);

                // Give correct empty bucket
                ItemStack potion = new ItemStack(NovaCraftItems.end_portal_sealent, 1, 0);

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

        else if (held.getItem() == (NovaCraftItems.vanite_bottle) && meta == 12) {

            if (!world.isRemote) {

                // Change block metadata
                world.setBlockMetadataWithNotify(x, y, z, 11, 3);

                // Give correct empty bucket
                ItemStack potion = new ItemStack(NovaCraftItems.end_portal_sealent, 1, 0);

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

        else if (held.getItem() == (NovaCraftItems.vanite_bottle) && meta == 13) {

            if (!world.isRemote) {

                // Change block metadata
                world.setBlockMetadataWithNotify(x, y, z, 12, 3);

                // Give correct empty bucket
                ItemStack potion = new ItemStack(NovaCraftItems.end_portal_sealent, 1, 0);

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

        else if ((held.getItem() == Items.ender_pearl) && meta == 5) {

            if (!world.isRemote) {

                // Change block metadata
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

        else if ((held.getItem() == Items.ender_pearl) && meta == 6) {

            if (!world.isRemote) {

                // Change block metadata
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

        else if ((held.getItem() == Items.ender_pearl) && meta == 7) {

            if (!world.isRemote) {

                // Change block metadata
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

        else if ((held.getItem() == NovaCraftItems.diamond_nugget) && held.getItemDamage() == 2 && meta == 8) {

            if (!world.isRemote) {

                // Change block metadata
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

        else if ((held.getItem() == NovaCraftItems.diamond_nugget) && held.getItemDamage() == 2 && meta == 9) {

            if (!world.isRemote) {

                // Change block metadata
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

        else if ((held.getItem() == NovaCraftItems.diamond_nugget) && held.getItemDamage() == 2 && meta == 10) {

            if (!world.isRemote) {

                // Change block metadata
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

        else if ((held.getItem() == NovaCraftItems.yttrlinsite_shard) && meta == 2) {

            if (!world.isRemote) {

                // Change block metadata
                world.setBlock(x, y, z, NovaCraftBlocks.potion_vanite_cauldron, 0, 3);

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

        else if ((held.getItem() == NovaCraftItems.yttrlinsite_shard) && meta == 3) {

            if (!world.isRemote) {

                // Change block metadata
                world.setBlock(x, y, z, NovaCraftBlocks.potion_vanite_cauldron, 1, 3);

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

        else if ((held.getItem() == NovaCraftItems.yttrlinsite_shard) && meta == 4) {

            if (!world.isRemote) {

                world.setBlock(x, y, z, NovaCraftBlocks.potion_vanite_cauldron, 2, 3);

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

        else if (held.getItem() == (NovaCraftItems.vanite_bottle) && meta == 14) {

            if (!world.isRemote) {

                world.setBlock(x, y, z, NovaCraftBlocks.potion_vanite_cauldron, 15, 3);

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

        else if (held.getItem() == (NovaCraftItems.vanite_bottle) && meta == 15) {

            if (!world.isRemote) {

                world.setBlockMetadataWithNotify(x, y, z, 14, 3);

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
        return RenderIDs.LAVA_VANITE_CAULDRON;
    }

    @SideOnly(Side.CLIENT)
    public static float getRenderLiquidLevel(int p_150025_0_)
    {
        int j = MathHelper.clamp_int(p_150025_0_, 0, 3);
        return (float)(6 + 3 * j) / 16.0F;
    }

}
