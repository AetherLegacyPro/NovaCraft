package com.NovaCraftBlocks.container;

import com.NovaCraft.TileEntity.TileEntityIridiumFurnace;
import com.NovaCraft.particles.ParticleHandler;
import com.NovaCraft.registry.OtherModBlocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import com.NovaCraft.NovaCraft;
import com.NovaCraft.sounds.ModSounds;
import com.NovaCraftBlocks.NovaCraftBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockIridiumFurnace extends BlockContainer
{
    private final Random rand = new Random();
    private final boolean smelting;

    public static final Set<Block> PossibleOres = new HashSet<>();

    static {
        PossibleOres.add(Blocks.coal_ore);
        PossibleOres.add(Blocks.iron_ore);
        PossibleOres.add(Blocks.gold_ore);
        PossibleOres.add(Blocks.redstone_ore);
        PossibleOres.add(Blocks.emerald_ore);
        PossibleOres.add(Blocks.lapis_ore);
        PossibleOres.add(Blocks.diamond_ore);
        PossibleOres.add(NovaCraftBlocks.brimstone_ore);
        PossibleOres.add(NovaCraftBlocks.grimstone_vanite_ore);
        PossibleOres.add(NovaCraftBlocks.nullstone_vanite_ore);
        PossibleOres.add(NovaCraftBlocks.nether_tophinite_ore);
        PossibleOres.add(NovaCraftBlocks.frontierslate_klangite_ore);
        PossibleOres.add(NovaCraftBlocks.end_klangite_ore);
        PossibleOres.add(NovaCraftBlocks.xancium_ore);
        PossibleOres.add(NovaCraftBlocks.iridium_ore);
        PossibleOres.add(NovaCraftBlocks.grimstone_iron);
        PossibleOres.add(NovaCraftBlocks.grimstone_gold);
        PossibleOres.add(NovaCraftBlocks.grimstone_lapis);
        PossibleOres.add(NovaCraftBlocks.grimstone_redstone);
        PossibleOres.add(NovaCraftBlocks.grimstone_diamond);
        PossibleOres.add(NovaCraftBlocks.grimstone_emerald);
        PossibleOres.add(NovaCraftBlocks.nullstone_iron);
        PossibleOres.add(NovaCraftBlocks.nullstone_gold);
        PossibleOres.add(NovaCraftBlocks.nullstone_lapis);
        PossibleOres.add(NovaCraftBlocks.nullstone_redstone);
        PossibleOres.add(NovaCraftBlocks.nullstone_diamond);
        PossibleOres.add(NovaCraftBlocks.nullstone_emerald);
        PossibleOres.add(NovaCraftBlocks.etherstone_iron);
        PossibleOres.add(NovaCraftBlocks.etherstone_gold);
        PossibleOres.add(NovaCraftBlocks.etherstone_coal);
        PossibleOres.add(NovaCraftBlocks.etherstone_brimstone);
        PossibleOres.add(NovaCraftBlocks.etherstone_emerald);

        //Divine RPG
        PossibleOres.add(OtherModBlocks.arlemiteOre);
        PossibleOres.add(OtherModBlocks.rupeeOre);

        //Et Futurum Requiem
        PossibleOres.add(OtherModBlocks.copper_ore);
        PossibleOres.add(OtherModBlocks.deepslate_coal_ore);
        PossibleOres.add(OtherModBlocks.deepslate_iron_ore);
        PossibleOres.add(OtherModBlocks.deepslate_lapis_ore);
        PossibleOres.add(OtherModBlocks.deepslate_gold_ore);
        PossibleOres.add(OtherModBlocks.deepslate_redstone_ore);
        PossibleOres.add(OtherModBlocks.deepslate_emerald_ore);
        PossibleOres.add(OtherModBlocks.deepslate_diamond_ore);
    }

    @SideOnly(Side.CLIENT)
    private IIcon iconTop;
    @SideOnly(Side.CLIENT)
    public IIcon iconFront;
    private static boolean field_149934_M;

    public BlockIridiumFurnace(boolean smelting)
    {
        super(Material.iron);
        this.setStepSound(ModSounds.soundNullstone);
        this.smelting = smelting;
        this.setHarvestLevel("pickaxe", 3);
        this.setHardness(60);
        this.setResistance(60000000);
    }

    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return Item.getItemFromBlock(NovaCraftBlocks.iridium_furnace);
    }

    public void onBlockAdded(World p_149726_1_, int p_149726_2_, int p_149726_3_, int p_149726_4_)
    {
        super.onBlockAdded(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_);
        this.func_149930_e(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_);
    }

    private void func_149930_e(World p_149930_1_, int p_149930_2_, int p_149930_3_, int p_149930_4_)
    {
        if (!p_149930_1_.isRemote)
        {
            Block block = p_149930_1_.getBlock(p_149930_2_, p_149930_3_, p_149930_4_ - 1);
            Block block1 = p_149930_1_.getBlock(p_149930_2_, p_149930_3_, p_149930_4_ + 1);
            Block block2 = p_149930_1_.getBlock(p_149930_2_ - 1, p_149930_3_, p_149930_4_);
            Block block3 = p_149930_1_.getBlock(p_149930_2_ + 1, p_149930_3_, p_149930_4_);
            byte b0 = 3;

            if (block.func_149730_j() && !block1.func_149730_j())
            {
                b0 = 3;
            }

            if (block1.func_149730_j() && !block.func_149730_j())
            {
                b0 = 2;
            }

            if (block2.func_149730_j() && !block3.func_149730_j())
            {
                b0 = 5;
            }

            if (block3.func_149730_j() && !block2.func_149730_j())
            {
                b0 = 4;
            }

            p_149930_1_.setBlockMetadataWithNotify(p_149930_2_, p_149930_3_, p_149930_4_, b0, 2);
        }
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(final int p_149691_1_, final int p_149691_2_) {
        return (p_149691_1_ == 1) ? this.iconTop : ((p_149691_1_ == 0) ? this.iconTop : ((p_149691_1_ != p_149691_2_) ? ((p_149691_1_ == 3 && p_149691_2_ == 0) ? this.iconFront : this.blockIcon) : this.iconFront));
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(final IIconRegister p_149651_1_) {
        this.blockIcon = p_149651_1_.registerIcon("nova_craft:iridium_furnace_side");
        this.iconTop = p_149651_1_.registerIcon("nova_craft:iridium_furnace_top");
        if (this.smelting) {
            this.iconFront = p_149651_1_.registerIcon("nova_craft:iridium_furnace_face_on");
        }
        else {
            this.iconFront = p_149651_1_.registerIcon("nova_craft:iridium_furnace_face_off");
        }
    }

    //Make sure the furnace has the proper structure around it otherwise GUI will not open
    public boolean onBlockActivated(final World world, final int x, final int y, final int z, final EntityPlayer player, final int p_149727_6_, final float p_149727_7_, final float p_149727_8_, final float p_149727_9_) {
        final TileEntityIridiumFurnace furnace = (TileEntityIridiumFurnace)world.getTileEntity(x, y, z);

        if ((furnace != null) && (world.getBlock(x + 1, y - 1, z) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x - 1, y - 1, z) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x, y, z + 1) == NovaCraftBlocks.iridium_power_core) && (world.getBlock(x - 1, y, z + 1) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x + 1, y, z + 1) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x - 1, y - 1, z + 1) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x + 1, y - 1, z + 1) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x, y - 1, z + 1) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x - 2, y - 1, z + 1) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x + 2, y - 1, z + 1) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x + 1, y + 1, z + 1) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x - 1, y + 1, z + 1) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x + 3, y - 1, z + 2) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x - 3, y - 1, z + 2) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x + 3, y - 1, z + 3) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x - 3, y - 1, z + 3) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x + 3, y - 1, z + 4) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x - 3, y - 1, z + 4) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x + 2, y - 1, z + 4) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x + 2, y - 1, z + 3) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x + 2, y - 1, z + 2) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x - 2, y - 1, z + 4) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x - 2, y - 1, z + 3) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x - 2, y - 1, z + 2) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x + 1, y - 1, z + 4) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x + 1, y - 1, z + 3) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x + 1, y - 1, z + 2) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x - 1, y - 1, z + 4) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x - 1, y - 1, z + 3) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x - 1, y - 1, z + 2) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x, y - 1, z + 4) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x, y - 1, z + 3) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x, y - 1, z + 2) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x, y - 1, z + 5) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x - 1, y - 1, z + 5) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x + 1, y - 1, z + 5) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x + 2, y - 1, z + 5) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x - 2, y - 1, z + 5) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x, y - 1, z + 6) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x + 1, y - 1, z + 6) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x - 1, y - 1, z + 6) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x - 2, y, z + 2) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x - 2, y, z + 3) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x - 2, y, z + 4) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x + 2, y, z + 2) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x + 2, y, z + 3) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x + 2, y, z + 4) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x, y, z + 5) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x - 1, y, z + 5) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x + 1, y, z + 5) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x + 1, y + 1, z + 5) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x - 1, y + 1, z + 5) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x + 2, y + 1, z + 3) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x - 2, y + 1, z + 3) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x, y + 1, z + 2) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x, y + 1, z + 3) == NovaCraftBlocks.iridium_trapdoor) && (world.getBlock(x, y + 1, z + 4) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x - 1, y + 1, z + 2) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x + 1, y + 1, z + 2) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x - 1, y + 1, z + 3) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x + 1, y + 1, z + 3) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x - 1, y + 1, z + 4) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x + 1, y + 1, z + 4) == NovaCraftBlocks.iridium_bricks)

                && (world.getBlock(x, y + 1, z + 5) == NovaCraftBlocks.iridium_bricks || world.getBlock(x, y + 1, z + 5) == NovaCraftBlocks.infused_iridium_bricks)
                && (world.getBlock(x + 2, y + 1, z + 4) == NovaCraftBlocks.iridium_bricks || world.getBlock(x + 2, y + 1, z + 4) == NovaCraftBlocks.infused_iridium_bricks)
                && (world.getBlock(x - 2, y + 1, z + 4) == NovaCraftBlocks.iridium_bricks || world.getBlock(x - 2, y + 1, z + 4) == NovaCraftBlocks.infused_iridium_bricks)
                && (world.getBlock(x + 2, y + 1, z + 2) == NovaCraftBlocks.iridium_bricks || world.getBlock(x + 2, y + 1, z + 2) == NovaCraftBlocks.infused_iridium_bricks)
                && (world.getBlock(x - 2, y + 1, z + 2) == NovaCraftBlocks.iridium_bricks || world.getBlock(x - 2, y + 1, z + 2) == NovaCraftBlocks.infused_iridium_bricks)
                && (world.getBlock(x, y + 1, z + 1) == NovaCraftBlocks.iridium_bricks || world.getBlock(x, y + 1, z + 1) == NovaCraftBlocks.infused_iridium_bricks)) {

                player.openGui((Object)NovaCraft.instance, 7, world, x, y, z);
                return true;
        } else if ((furnace != null) && (world.getBlock(x + 1, y - 1, z) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x - 1, y - 1, z) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x, y, z - 1) == NovaCraftBlocks.iridium_power_core) && (world.getBlock(x - 1, y, z - 1) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x + 1, y, z - 1) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x - 1, y - 1, z - 1) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x + 1, y - 1, z - 1) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x, y - 1, z - 1) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x - 2, y - 1, z - 1) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x + 2, y - 1, z - 1) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x + 1, y + 1, z - 1) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x - 1, y + 1, z - 1) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x + 3, y - 1, z - 2) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x - 3, y - 1, z - 2) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x + 3, y - 1, z - 3) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x - 3, y - 1, z - 3) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x + 3, y - 1, z - 4) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x - 3, y - 1, z - 4) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x + 2, y - 1, z - 4) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x + 2, y - 1, z - 3) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x + 2, y - 1, z - 2) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x - 2, y - 1, z - 4) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x - 2, y - 1, z - 3) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x - 2, y - 1, z - 2) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x + 1, y - 1, z - 4) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x + 1, y - 1, z - 3) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x + 1, y - 1, z - 2) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x - 1, y - 1, z - 4) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x - 1, y - 1, z - 3) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x - 1, y - 1, z - 2) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x, y - 1, z - 4) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x, y - 1, z - 3) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x, y - 1, z - 2) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x, y - 1, z - 5) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x - 1, y - 1, z - 5) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x + 1, y - 1, z - 5) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x + 2, y - 1, z - 5) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x - 2, y - 1, z - 5) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x, y - 1, z - 6) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x + 1, y - 1, z - 6) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x - 1, y - 1, z - 6) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x - 2, y, z - 2) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x - 2, y, z - 3) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x - 2, y, z - 4) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x + 2, y, z - 2) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x + 2, y, z - 3) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x + 2, y, z - 4) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x, y, z - 5) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x - 1, y, z - 5) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x + 1, y, z - 5) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x + 1, y + 1, z - 5) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x - 1, y + 1, z - 5) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x + 2, y + 1, z - 3) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x - 2, y + 1, z - 3) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x, y + 1, z - 2) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x, y + 1, z - 3) == NovaCraftBlocks.iridium_trapdoor) && (world.getBlock(x, y + 1, z - 4) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x - 1, y + 1, z - 2) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x + 1, y + 1, z - 2) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x - 1, y + 1, z - 3) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x + 1, y + 1, z - 3) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x - 1, y + 1, z - 4) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x + 1, y + 1, z - 4) == NovaCraftBlocks.iridium_bricks)

                && (world.getBlock(x, y + 1, z - 5) == NovaCraftBlocks.iridium_bricks || world.getBlock(x, y + 1, z - 5) == NovaCraftBlocks.infused_iridium_bricks)
                && (world.getBlock(x + 2, y + 1, z - 4) == NovaCraftBlocks.iridium_bricks || world.getBlock(x + 2, y + 1, z - 4) == NovaCraftBlocks.infused_iridium_bricks)
                && (world.getBlock(x - 2, y + 1, z - 4) == NovaCraftBlocks.iridium_bricks || world.getBlock(x - 2, y + 1, z - 4) == NovaCraftBlocks.infused_iridium_bricks)
                && (world.getBlock(x + 2, y + 1, z - 2) == NovaCraftBlocks.iridium_bricks || world.getBlock(x + 2, y + 1, z - 2) == NovaCraftBlocks.infused_iridium_bricks)
                && (world.getBlock(x - 2, y + 1, z - 2) == NovaCraftBlocks.iridium_bricks || world.getBlock(x - 2, y + 1, z - 2) == NovaCraftBlocks.infused_iridium_bricks)
                && (world.getBlock(x, y + 1, z - 1) == NovaCraftBlocks.iridium_bricks || world.getBlock(x, y + 1, z - 1) == NovaCraftBlocks.infused_iridium_bricks)) {

            player.openGui((Object)NovaCraft.instance, 7, world, x, y, z);
            return true;
        } else if ((furnace != null) && (world.getBlock(x, y - 1, z + 1) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x, y - 1, z - 1) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x - 1, y, z) == NovaCraftBlocks.iridium_power_core) && (world.getBlock(x - 1, y, z - 1) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x - 1, y, z + 1) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x - 1, y - 1, z - 1) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x - 1, y - 1, z + 1) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x - 1, y - 1, z) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x - 1, y - 1, z - 2) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x - 1, y - 1, z + 2) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x - 1, y + 1, z + 1) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x - 1, y + 1, z - 1) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x - 2, y - 1, z + 3) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x - 2, y - 1, z - 3) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x - 3, y - 1, z + 3) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x - 3, y - 1, z - 3) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x - 4, y - 1, z + 3) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x - 4, y - 1, z - 3) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x - 4, y - 1, z + 2) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x - 3, y - 1, z + 2) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x - 2, y - 1, z + 2) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x - 4, y - 1, z - 2) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x - 3, y - 1, z - 2) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x - 2, y - 1, z - 2) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x - 4, y - 1, z + 1) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x - 3, y - 1, z + 1) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x - 2, y - 1, z + 1) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x - 4, y - 1, z - 1) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x - 3, y - 1, z - 1) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x - 2, y - 1, z - 1) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x - 4, y - 1, z) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x - 3, y - 1, z) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x - 2, y - 1, z) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x - 5, y - 1, z) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x - 5, y - 1, z - 1) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x - 5, y - 1, z + 1) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x - 5, y - 1, z + 2) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x - 5, y - 1, z - 2) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x - 6, y - 1, z) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x - 6, y - 1, z + 1) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x - 6, y - 1, z - 1) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x - 2, y, z - 2) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x - 3, y, z - 2) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x - 4, y, z - 2) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x - 2, y, z + 2) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x - 3, y, z + 2) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x - 4, y, z + 2) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x - 5, y, z) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x - 5, y, z - 1) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x - 5, y, z + 1) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x - 5, y + 1, z + 1) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x - 5, y + 1, z - 1) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x - 3, y + 1, z + 2) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x - 3, y + 1, z - 2) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x - 2, y + 1, z) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x - 3, y + 1, z) == NovaCraftBlocks.iridium_trapdoor) && (world.getBlock(x - 4, y + 1, z) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x - 2, y + 1, z - 1) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x - 2, y + 1, z + 1) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x - 3, y + 1, z - 1) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x - 3, y + 1, z + 1) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x - 4, y + 1, z - 1) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x - 4, y + 1, z + 1) == NovaCraftBlocks.iridium_bricks)

                && (world.getBlock(x - 5, y + 1, z) == NovaCraftBlocks.iridium_bricks || world.getBlock(x - 5, y + 1, z) == NovaCraftBlocks.infused_iridium_bricks)
                && (world.getBlock(x - 4, y + 1, z + 2) == NovaCraftBlocks.iridium_bricks || world.getBlock(x - 4, y + 1, z + 2) == NovaCraftBlocks.infused_iridium_bricks)
                && (world.getBlock(x - 4, y + 1, z - 2) == NovaCraftBlocks.iridium_bricks || world.getBlock(x - 4, y + 1, z - 2) == NovaCraftBlocks.infused_iridium_bricks)
                && (world.getBlock(x - 2, y + 1, z + 2) == NovaCraftBlocks.iridium_bricks || world.getBlock(x - 2, y + 1, z + 2) == NovaCraftBlocks.infused_iridium_bricks)
                && (world.getBlock(x - 2, y + 1, z - 2) == NovaCraftBlocks.iridium_bricks || world.getBlock(x - 2, y + 1, z - 2) == NovaCraftBlocks.infused_iridium_bricks)
                && (world.getBlock(x - 1, y + 1, z) == NovaCraftBlocks.iridium_bricks || world.getBlock(x - 1, y + 1, z) == NovaCraftBlocks.infused_iridium_bricks)) {

            player.openGui((Object)NovaCraft.instance, 7, world, x, y, z);
            return true;
        } else if ((furnace != null) && (world.getBlock(x, y - 1, z + 1) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x, y - 1, z - 1) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x + 1, y, z) == NovaCraftBlocks.iridium_power_core) && (world.getBlock(x + 1, y, z - 1) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x + 1, y, z + 1) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x + 1, y - 1, z - 1) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x + 1, y - 1, z + 1) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x + 1, y - 1, z) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x + 1, y - 1, z - 2) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x + 1, y - 1, z + 2) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x + 1, y + 1, z + 1) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x + 1, y + 1, z - 1) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x + 2, y - 1, z + 3) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x + 2, y - 1, z - 3) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x + 3, y - 1, z + 3) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x + 3, y - 1, z - 3) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x + 4, y - 1, z + 3) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x + 4, y - 1, z - 3) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x + 4, y - 1, z + 2) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x + 3, y - 1, z + 2) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x + 2, y - 1, z + 2) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x + 4, y - 1, z - 2) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x + 3, y - 1, z - 2) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x + 2, y - 1, z - 2) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x + 4, y - 1, z + 1) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x + 3, y - 1, z + 1) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x + 2, y - 1, z + 1) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x + 4, y - 1, z - 1) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x + 3, y - 1, z - 1) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x + 2, y - 1, z - 1) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x + 4, y - 1, z) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x + 3, y - 1, z) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x + 2, y - 1, z) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x + 5, y - 1, z) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x + 5, y - 1, z - 1) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x + 5, y - 1, z + 1) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x + 5, y - 1, z + 2) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x + 5, y - 1, z - 2) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x + 6, y - 1, z) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x + 6, y - 1, z + 1) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x + 6, y - 1, z - 1) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x + 2, y, z - 2) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x + 3, y, z - 2) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x + 4, y, z - 2) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x + 2, y, z + 2) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x + 3, y, z + 2) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x + 4, y, z + 2) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x + 5, y, z) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x + 5, y, z - 1) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x + 5, y, z + 1) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x + 5, y + 1, z + 1) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x + 5, y + 1, z - 1) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x + 3, y + 1, z + 2) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x + 3, y + 1, z - 2) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x + 2, y + 1, z) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x + 3, y + 1, z) == NovaCraftBlocks.iridium_trapdoor) && (world.getBlock(x + 4, y + 1, z) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x + 2, y + 1, z - 1) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x + 2, y + 1, z + 1) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x + 3, y + 1, z - 1) == NovaCraftBlocks.iridium_bricks)
                && (world.getBlock(x + 3, y + 1, z + 1) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x + 4, y + 1, z - 1) == NovaCraftBlocks.iridium_bricks) && (world.getBlock(x + 4, y + 1, z + 1) == NovaCraftBlocks.iridium_bricks)

                && (world.getBlock(x + 5, y + 1, z) == NovaCraftBlocks.iridium_bricks || world.getBlock(x + 5, y + 1, z) == NovaCraftBlocks.infused_iridium_bricks)
                && (world.getBlock(x + 4, y + 1, z + 2) == NovaCraftBlocks.iridium_bricks || world.getBlock(x + 4, y + 1, z + 2) == NovaCraftBlocks.infused_iridium_bricks)
                && (world.getBlock(x + 4, y + 1, z - 2) == NovaCraftBlocks.iridium_bricks || world.getBlock(x + 4, y + 1, z - 2) == NovaCraftBlocks.infused_iridium_bricks)
                && (world.getBlock(x + 2, y + 1, z + 2) == NovaCraftBlocks.iridium_bricks || world.getBlock(x + 2, y + 1, z + 2) == NovaCraftBlocks.infused_iridium_bricks)
                && (world.getBlock(x + 2, y + 1, z - 2) == NovaCraftBlocks.iridium_bricks || world.getBlock(x + 2, y + 1, z - 2) == NovaCraftBlocks.infused_iridium_bricks)
                && (world.getBlock(x + 1, y + 1, z) == NovaCraftBlocks.iridium_bricks || world.getBlock(x + 1, y + 1, z) == NovaCraftBlocks.infused_iridium_bricks)) {

            player.openGui((Object)NovaCraft.instance, 7, world, x, y, z);
            return true;
        } else {
            if (world.isRemote) {
                player.addChatComponentMessage(new ChatComponentText(I18n.format("gui.iridium_furnace.invalid_structure")));
            }
            return false;
        }
    }

    public static void updateFurnaceBlockState(boolean p_149931_0_, World p_149931_1_, int p_149931_2_, int p_149931_3_, int p_149931_4_) {
        int l = p_149931_1_.getBlockMetadata(p_149931_2_, p_149931_3_, p_149931_4_);
        TileEntity tileentity = p_149931_1_.getTileEntity(p_149931_2_, p_149931_3_, p_149931_4_);
        field_149934_M = true;

        if (p_149931_0_)
        {
            p_149931_1_.setBlock(p_149931_2_, p_149931_3_, p_149931_4_, NovaCraftBlocks.lit_iridium_furnace);
        }
        else
        {
            p_149931_1_.setBlock(p_149931_2_, p_149931_3_, p_149931_4_, NovaCraftBlocks.iridium_furnace);
        }

        field_149934_M = false;
        p_149931_1_.setBlockMetadataWithNotify(p_149931_2_, p_149931_3_, p_149931_4_, l, 2);

        if (tileentity != null)
        {
            tileentity.validate();
            p_149931_1_.setTileEntity(p_149931_2_, p_149931_3_, p_149931_4_, tileentity);
        }
    }

    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TileEntityIridiumFurnace();
    }

    public void onBlockPlacedBy(World p_149689_1_, int p_149689_2_, int p_149689_3_, int p_149689_4_, EntityLivingBase p_149689_5_, ItemStack p_149689_6_) {
        int l = MathHelper.floor_double((double)(p_149689_5_.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (l == 0)
        {
            p_149689_1_.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_, p_149689_4_, 2, 2);
        }

        if (l == 1)
        {
            p_149689_1_.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_, p_149689_4_, 5, 2);
        }

        if (l == 2)
        {
            p_149689_1_.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_, p_149689_4_, 3, 2);
        }

        if (l == 3)
        {
            p_149689_1_.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_, p_149689_4_, 4, 2);
        }

        ((TileEntityIridiumFurnace)p_149689_1_.getTileEntity(p_149689_2_, p_149689_3_, p_149689_4_)).func_145951_a(p_149689_6_.getDisplayName());
    }

    @Override
    public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
        if (!field_149934_M) {
            TileEntityIridiumFurnace furnace = (TileEntityIridiumFurnace) world.getTileEntity(x, y, z);

            if (furnace != null) {
                //If furnace is broken, remove blazinite in furnace.
                for (int i = 0; i < furnace.getSizeInventory(); ++i) {
                    ItemStack itemstack = furnace.getStackInSlot(i);
                    if (itemstack != null) {
                        float f = rand.nextFloat() * 0.8F + 0.1F;
                        float f1 = rand.nextFloat() * 0.8F + 0.1F;
                        float f2 = rand.nextFloat() * 0.8F + 0.1F;

                        while (itemstack.stackSize > 0) {
                            int j = rand.nextInt(21) + 10;
                            if (j > itemstack.stackSize) j = itemstack.stackSize;

                            itemstack.stackSize -= j;
                            ItemStack drop = itemstack.copy();
                            drop.stackSize = j;

                            EntityItem entity = new EntityItem(world, x + f, y + f1, z + f2, drop);
                            world.spawnEntityInWorld(entity);
                        }
                    }
                }

                removeSurroundingBlazinite(world, x, y, z);
                world.func_147453_f(x, y, z, block);
            }
        }

        super.breakBlock(world, x, y, z, block, meta);
    }

    //removes blazlinite around the furnace
    private void removeSurroundingBlazinite(World world, int x, int y, int z) {
        int radius = 4;

        for (int dx = -radius; dx <= radius; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                for (int dz = -radius; dz <= radius; dz++) {
                    Block block = world.getBlock(x + dx, y + dy, z + dz);

                    if (block == NovaCraftBlocks.blazlinite) {
                        world.setBlockToAir(x + dx, y + dy, z + dz);
                    }
                }
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_) {
        if (this.smelting)
        {
            int l = p_149734_1_.getBlockMetadata(p_149734_2_, p_149734_3_, p_149734_4_);
            float f = (float)p_149734_2_ + 0.5F;
            float f1 = (float)p_149734_3_ + 0.0F + p_149734_5_.nextFloat() * 6.0F / 16.0F;
            float f2 = (float)p_149734_4_ + 0.5F;
            float f3 = 0.52F;
            float f4 = p_149734_5_.nextFloat() * 0.6F - 0.3F;

            if (l == 4)
            {
                p_149734_1_.spawnParticle("smoke", (double)(f - f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
                ParticleHandler.BLUEFLAME.spawn(p_149734_1_, (double)(f - f3), (double)f1, (double)(f2 + f4), 0.0, 0.0, 0.0, 0.0f, new Object[0]);
            }
            else if (l == 5)
            {
                p_149734_1_.spawnParticle("smoke", (double)(f + f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
                ParticleHandler.BLUEFLAME.spawn(p_149734_1_, (double)(f + f3), (double)f1, (double)(f2 + f4), 0.0, 0.0, 0.0, 0.0f, new Object[0]);
            }
            else if (l == 2)
            {
                p_149734_1_.spawnParticle("smoke", (double)(f + f4), (double)f1, (double)(f2 - f3), 0.0D, 0.0D, 0.0D);
                ParticleHandler.BLUEFLAME.spawn(p_149734_1_, (double)(f + f4), (double)f1, (double)(f2 - f3), 0.0, 0.0, 0.0, 0.0f, new Object[0]);
            }
            else if (l == 3)
            {
                p_149734_1_.spawnParticle("smoke", (double)(f + f4), (double)f1, (double)(f2 + f3), 0.0D, 0.0D, 0.0D);
                ParticleHandler.BLUEFLAME.spawn(p_149734_1_, (double)(f + f4), (double)f1, (double)(f2 + f3), 0.0, 0.0, 0.0, 0.0f, new Object[0]);
            }
        }
    }

    public boolean hasComparatorInputOverride()
    {
        return true;
    }

    public int getComparatorInputOverride(World p_149736_1_, int p_149736_2_, int p_149736_3_, int p_149736_4_, int p_149736_5_)
    {
        return Container.calcRedstoneFromInventory((IInventory)p_149736_1_.getTileEntity(p_149736_2_, p_149736_3_, p_149736_4_));
    }

    @SideOnly(Side.CLIENT)
    public Item getItem(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_)
    {
        return Item.getItemFromBlock(NovaCraftBlocks.iridium_furnace);
    }
}
