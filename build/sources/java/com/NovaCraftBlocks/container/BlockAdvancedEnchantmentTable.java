package com.NovaCraftBlocks.container;

import net.minecraft.block.*;
import net.minecraft.util.*;
import java.util.Random;
import com.NovaCraft.NovaCraft;
import com.NovaCraft.TileEntity.TileEntityAdvancedEnchantmentTable;
import com.NovaCraft.registry.NovaCraftCreativeTabs;
import com.NovaCraftBlocks.NovaCraftBlocks;
import cpw.mods.fml.relauncher.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.client.resources.I18n;
import net.minecraft.world.*;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.*;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class BlockAdvancedEnchantmentTable extends BlockEnchantmentTable
{
    
	@SideOnly(Side.CLIENT)
    private IIcon field_94385_a;
    @SideOnly(Side.CLIENT)
    private IIcon field_94384_b;
    
    public BlockAdvancedEnchantmentTable()
    {
        super();
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.75F, 1.0F);
        this.setHardness(25F);
		this.setResistance(30000F);
        this.setLightOpacity(0);
        this.setCreativeTab(NovaCraftCreativeTabs.blocks);
        this.setHarvestLevel("pickaxe", 2);
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(final int par1, final int par2) {
        return (par1 == 1) ? this.field_94385_a : ((par1 == 0) ? Blocks.obsidian.getBlockTextureFromSide(par1): ((par1 != 2 && par1 != 4) ? this.blockIcon : this.field_94384_b));
    }
    
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(final IIconRegister par1IIconRegister) {
        this.blockIcon = par1IIconRegister.registerIcon("nova_craft:advanced_enchanting_table_side");
        this.field_94385_a = par1IIconRegister.registerIcon("nova_craft:advanced_enchanting_table_top");
        this.field_94384_b = par1IIconRegister.registerIcon("nova_craft:advanced_enchanting_table_side");
    }
    
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random random)
    {
        super.randomDisplayTick(world, p_149734_2_, p_149734_3_, p_149734_4_, random);

        for (int l = p_149734_2_ - 2; l <= p_149734_2_ + 2; ++l)
        {
            for (int i1 = p_149734_4_ - 2; i1 <= p_149734_4_ + 2; ++i1)
            {
                if (l > p_149734_2_ - 2 && l < p_149734_2_ + 2 && i1 == p_149734_4_ - 1)
                {
                    i1 = p_149734_4_ + 2;
                }

                if (random.nextInt(16) == 0)
                {
                    for (int j1 = p_149734_3_; j1 <= p_149734_3_ + 1; ++j1)
                    {
                        if (world.getBlock(l, j1, i1) == NovaCraftBlocks.nullwart_brick_bookshelf)
                        {
                            if (!world.isAirBlock((l - p_149734_2_) / 2 + p_149734_2_, j1, (i1 - p_149734_4_) / 2 + p_149734_4_))
                            {
                                break;
                            }

                            world.spawnParticle("enchantmenttable", (double)p_149734_2_ + 0.5D, (double)p_149734_3_ + 2.0D, (double)p_149734_4_ + 0.5D, (double)((float)(l - p_149734_2_) + random.nextFloat()) - 0.5D, (double)((float)(j1 - p_149734_3_) - random.nextFloat() - 1.0F), (double)((float)(i1 - p_149734_4_) + random.nextFloat()) - 0.5D);
                        }
                    }
                }
            }
        }
    }
    
    public boolean onBlockActivated(final World world, final int x, final int y, final int z, final EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        
        if ((world.getBlock(x + 2, y, z - 1) == NovaCraftBlocks.nullwart_brick_bookshelf
            && world.getBlock(x + 2, y, z - 2) == NovaCraftBlocks.nullwart_brick_bookshelf
        	&& world.getBlock(x + 2, y, z + 1) == NovaCraftBlocks.nullwart_brick_bookshelf
        	&& world.getBlock(x + 2, y, z + 2) == NovaCraftBlocks.nullwart_brick_bookshelf
        
        	&& world.getBlock(x - 2, y, z - 1) == NovaCraftBlocks.nullwart_brick_bookshelf
            && world.getBlock(x - 2, y, z - 2) == NovaCraftBlocks.nullwart_brick_bookshelf
        	&& world.getBlock(x - 2, y, z + 1) == NovaCraftBlocks.nullwart_brick_bookshelf
        	&& world.getBlock(x - 2, y, z + 2) == NovaCraftBlocks.nullwart_brick_bookshelf
        	
            && world.getBlock(x - 1, y, z + 2) == NovaCraftBlocks.nullwart_brick_bookshelf
            && world.getBlock(x - 2, y, z + 2) == NovaCraftBlocks.nullwart_brick_bookshelf
        	&& world.getBlock(x + 1, y, z + 2) == NovaCraftBlocks.nullwart_brick_bookshelf
        	&& world.getBlock(x + 2, y, z + 2) == NovaCraftBlocks.nullwart_brick_bookshelf
        	
        	&& world.getBlock(x - 1, y, z - 2) == NovaCraftBlocks.nullwart_brick_bookshelf
            && world.getBlock(x - 2, y, z - 2) == NovaCraftBlocks.nullwart_brick_bookshelf
        	&& world.getBlock(x + 1, y, z - 2) == NovaCraftBlocks.nullwart_brick_bookshelf
        	&& world.getBlock(x + 2, y, z - 2) == NovaCraftBlocks.nullwart_brick_bookshelf
        	
        	&& world.getBlock(x + 2, y, z) == NovaCraftBlocks.nullwart_brick_bookshelf 
        	&& world.getBlock(x - 2, y, z) == NovaCraftBlocks.nullwart_brick_bookshelf 
        	&& world.getBlock(x, y, z + 2) == NovaCraftBlocks.nullwart_brick_bookshelf)
        		
        	|| (world.getBlock(x + 2, y, z - 1) == NovaCraftBlocks.nullwart_brick_bookshelf
            && world.getBlock(x + 2, y, z - 2) == NovaCraftBlocks.nullwart_brick_bookshelf
        	&& world.getBlock(x + 2, y, z + 1) == NovaCraftBlocks.nullwart_brick_bookshelf
        	&& world.getBlock(x + 2, y, z + 2) == NovaCraftBlocks.nullwart_brick_bookshelf
        
        	&& world.getBlock(x - 2, y, z - 1) == NovaCraftBlocks.nullwart_brick_bookshelf
            && world.getBlock(x - 2, y, z - 2) == NovaCraftBlocks.nullwart_brick_bookshelf
        	&& world.getBlock(x - 2, y, z + 1) == NovaCraftBlocks.nullwart_brick_bookshelf
        	&& world.getBlock(x - 2, y, z + 2) == NovaCraftBlocks.nullwart_brick_bookshelf
        	
            && world.getBlock(x - 1, y, z + 2) == NovaCraftBlocks.nullwart_brick_bookshelf
            && world.getBlock(x - 2, y, z + 2) == NovaCraftBlocks.nullwart_brick_bookshelf
        	&& world.getBlock(x + 1, y, z + 2) == NovaCraftBlocks.nullwart_brick_bookshelf
        	&& world.getBlock(x + 2, y, z + 2) == NovaCraftBlocks.nullwart_brick_bookshelf
        	
        	&& world.getBlock(x - 1, y, z - 2) == NovaCraftBlocks.nullwart_brick_bookshelf
            && world.getBlock(x - 2, y, z - 2) == NovaCraftBlocks.nullwart_brick_bookshelf
        	&& world.getBlock(x + 1, y, z - 2) == NovaCraftBlocks.nullwart_brick_bookshelf
        	&& world.getBlock(x + 2, y, z - 2) == NovaCraftBlocks.nullwart_brick_bookshelf
        	
        	&& world.getBlock(x + 2, y, z) == NovaCraftBlocks.nullwart_brick_bookshelf 
        	&& world.getBlock(x - 2, y, z) == NovaCraftBlocks.nullwart_brick_bookshelf 
        	&& world.getBlock(x, y, z - 2) == NovaCraftBlocks.nullwart_brick_bookshelf)
        	
        	|| (world.getBlock(x + 2, y, z - 1) == NovaCraftBlocks.nullwart_brick_bookshelf
            && world.getBlock(x + 2, y, z - 2) == NovaCraftBlocks.nullwart_brick_bookshelf
        	&& world.getBlock(x + 2, y, z + 1) == NovaCraftBlocks.nullwart_brick_bookshelf
        	&& world.getBlock(x + 2, y, z + 2) == NovaCraftBlocks.nullwart_brick_bookshelf
        
        	&& world.getBlock(x - 2, y, z - 1) == NovaCraftBlocks.nullwart_brick_bookshelf
            && world.getBlock(x - 2, y, z - 2) == NovaCraftBlocks.nullwart_brick_bookshelf
        	&& world.getBlock(x - 2, y, z + 1) == NovaCraftBlocks.nullwart_brick_bookshelf
        	&& world.getBlock(x - 2, y, z + 2) == NovaCraftBlocks.nullwart_brick_bookshelf
        	
            && world.getBlock(x - 1, y, z + 2) == NovaCraftBlocks.nullwart_brick_bookshelf
            && world.getBlock(x - 2, y, z + 2) == NovaCraftBlocks.nullwart_brick_bookshelf
        	&& world.getBlock(x + 1, y, z + 2) == NovaCraftBlocks.nullwart_brick_bookshelf
        	&& world.getBlock(x + 2, y, z + 2) == NovaCraftBlocks.nullwart_brick_bookshelf
        	
        	&& world.getBlock(x - 1, y, z - 2) == NovaCraftBlocks.nullwart_brick_bookshelf
            && world.getBlock(x - 2, y, z - 2) == NovaCraftBlocks.nullwart_brick_bookshelf
        	&& world.getBlock(x + 1, y, z - 2) == NovaCraftBlocks.nullwart_brick_bookshelf
        	&& world.getBlock(x + 2, y, z - 2) == NovaCraftBlocks.nullwart_brick_bookshelf
        	
        	&& world.getBlock(x + 2, y, z) == NovaCraftBlocks.nullwart_brick_bookshelf 
        	&& world.getBlock(x, y, z - 2) == NovaCraftBlocks.nullwart_brick_bookshelf 
        	&& world.getBlock(x, y, z + 2) == NovaCraftBlocks.nullwart_brick_bookshelf)
        	
        	|| (world.getBlock(x + 2, y, z - 1) == NovaCraftBlocks.nullwart_brick_bookshelf
            && world.getBlock(x + 2, y, z - 2) == NovaCraftBlocks.nullwart_brick_bookshelf
        	&& world.getBlock(x + 2, y, z + 1) == NovaCraftBlocks.nullwart_brick_bookshelf
        	&& world.getBlock(x + 2, y, z + 2) == NovaCraftBlocks.nullwart_brick_bookshelf
        
        	&& world.getBlock(x - 2, y, z - 1) == NovaCraftBlocks.nullwart_brick_bookshelf
            && world.getBlock(x - 2, y, z - 2) == NovaCraftBlocks.nullwart_brick_bookshelf
        	&& world.getBlock(x - 2, y, z + 1) == NovaCraftBlocks.nullwart_brick_bookshelf
        	&& world.getBlock(x - 2, y, z + 2) == NovaCraftBlocks.nullwart_brick_bookshelf
        	
            && world.getBlock(x - 1, y, z + 2) == NovaCraftBlocks.nullwart_brick_bookshelf
            && world.getBlock(x - 2, y, z + 2) == NovaCraftBlocks.nullwart_brick_bookshelf
        	&& world.getBlock(x + 1, y, z + 2) == NovaCraftBlocks.nullwart_brick_bookshelf
        	&& world.getBlock(x + 2, y, z + 2) == NovaCraftBlocks.nullwart_brick_bookshelf
        	
        	&& world.getBlock(x - 1, y, z - 2) == NovaCraftBlocks.nullwart_brick_bookshelf
            && world.getBlock(x - 2, y, z - 2) == NovaCraftBlocks.nullwart_brick_bookshelf
        	&& world.getBlock(x + 1, y, z - 2) == NovaCraftBlocks.nullwart_brick_bookshelf
        	&& world.getBlock(x + 2, y, z - 2) == NovaCraftBlocks.nullwart_brick_bookshelf
        	
        	&& world.getBlock(x, y, z + 2) == NovaCraftBlocks.nullwart_brick_bookshelf 
        	&& world.getBlock(x, y, z - 2) == NovaCraftBlocks.nullwart_brick_bookshelf 
        	&& world.getBlock(x - 2, y, z) == NovaCraftBlocks.nullwart_brick_bookshelf)) {
        	
       
        final int guiID = 4;
        player.openGui((Object)NovaCraft.instance, guiID, world, x, y, z);
        return true;
        }
        
        else {
        	if (world.isRemote) {
        	player.addChatComponentMessage(new ChatComponentText(I18n.format("gui.advanced_et.invalid_structure")));
        	}
        	return false;
        }
    }
    
    public TileEntity createNewTileEntity(World world, int p_149915_2_)
    {
        return new TileEntityAdvancedEnchantmentTable();
    }
    
    public void onBlockPlacedBy(World world, int p_149689_2_, int p_149689_3_, int p_149689_4_, EntityLivingBase p_149689_5_, ItemStack p_149689_6_)
    {
        super.onBlockPlacedBy(world, p_149689_2_, p_149689_3_, p_149689_4_, p_149689_5_, p_149689_6_);

        if (p_149689_6_.hasDisplayName())
        {
            ((TileEntityAdvancedEnchantmentTable)world.getTileEntity(p_149689_2_, p_149689_3_, p_149689_4_)).func_145920_a(p_149689_6_.getDisplayName());
        }
    }
    
    @Override
	@SideOnly(Side.CLIENT)
	public int getRenderBlockPass() {
		return 1;
	}
}	
