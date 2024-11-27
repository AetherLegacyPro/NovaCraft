package com.NovaCraftBlocks.container;

import net.minecraft.block.material.*;
import net.minecraft.block.*;
import net.minecraft.world.*;
import net.minecraft.item.*;
import net.minecraft.entity.item.*;
import net.minecraft.nbt.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraftforge.common.util.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.*;
import java.util.*;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.TileEntity.TileEntityAncientChest;
import com.NovaCraft.TileEntity.TileEntityUnbreakbleAncientChest;
import com.NovaCraft.registry.NovaCraftCreativeTabs;
import com.NovaCraft.registry.OtherModBlocks;
import com.NovaCraft.registry.OtherModItems;
import com.NovaCraft.sounds.ModSounds;
import com.NovaCraftBlocks.NovaCraftBlocks;

import net.minecraft.inventory.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.client.resources.I18n;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentData;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.relauncher.*;

public class BlockUnbreakableAncientChest extends BlockContainer
{
  private final Random random;
	
  public BlockUnbreakableAncientChest(final int par2) {
      super(Material.rock);
      this.random = new Random();
      this.setBlockUnbreakable();
	  this.setResistance(300000F);
	  this.setStepSound(ModSounds.soundNullstone);
      this.setCreativeTab(null);
      this.setBlockBounds(0.0625f, 0.0f, 0.0625f, 0.9375f, 0.875f, 0.9375f);
  }
  
  public Block setIconName(final String name) {
      this.textureName = "nova_craft:" + name;
      return this.setBlockName("nova_craft:" + name);
  }
  
  public boolean isOpaqueCube() {
      return false;
  }
  
  public boolean renderAsNormalBlock() {
      return false;
  }
  
  @Override
  public int quantityDropped(Random random) {
	return 0;
  }
  
  public int getRenderType() {
      return NovaCraftBlocks.UnbreakableAncientChestRenderId;
  }
  
  public void onBlockAdded(final World par1World, final int par2, final int par3, final int par4) {
      super.onBlockAdded(par1World, par2, par3, par4);
      this.unifyAdjacentChests(par1World, par2, par3, par4);
      final Block l = par1World.getBlock(par2, par3, par4 - 1);
      final Block i1 = par1World.getBlock(par2, par3, par4 + 1);
      final Block j1 = par1World.getBlock(par2 - 1, par3, par4);
      final Block k1 = par1World.getBlock(par2 + 1, par3, par4);
      if (l == this) {
          this.unifyAdjacentChests(par1World, par2, par3, par4 - 1);
      }
      if (i1 == this) {
          this.unifyAdjacentChests(par1World, par2, par3, par4 + 1);
      }
      if (j1 == this) {
          this.unifyAdjacentChests(par1World, par2 - 1, par3, par4);
      }
      if (k1 == this) {
          this.unifyAdjacentChests(par1World, par2 + 1, par3, par4);
      }
  }
  
  public void onBlockPlacedBy(final World par1World, final int par2, final int par3, final int par4, final EntityLivingBase par5EntityLivingBase, final ItemStack par6ItemStack) {
      final Block l = par1World.getBlock(par2, par3, par4 - 1);
      final Block i1 = par1World.getBlock(par2, par3, par4 + 1);
      final Block j1 = par1World.getBlock(par2 - 1, par3, par4);
      final Block k1 = par1World.getBlock(par2 + 1, par3, par4);
      byte b0 = 0;
      final int l2 = MathHelper.floor_double(par5EntityLivingBase.rotationYaw * 4.0f / 360.0f + 0.5) & 0x3;
      if (l2 == 0) {
          b0 = 2;
      }
      if (l2 == 1) {
          b0 = 5;
      }
      if (l2 == 2) {
          b0 = 3;
      }
      if (l2 == 3) {
          b0 = 4;
      }
      if (l != this && i1 != this && j1 != this && k1 != this) {
          par1World.setBlockMetadataWithNotify(par2, par3, par4, b0, 3);
      }
      else {
          if ((l == this || i1 == this) && (b0 == 4 || b0 == 5)) {
              if (l == this) {
                  par1World.setBlockMetadataWithNotify(par2, par3, par4 - 1, b0, 3);
              }
              else {
                  par1World.setBlockMetadataWithNotify(par2, par3, par4 + 1, b0, 3);
              }
              par1World.setBlockMetadataWithNotify(par2, par3, par4, b0, 3);
          }
          if ((j1 == this || k1 == this) && (b0 == 2 || b0 == 3)) {
              if (j1 == this) {
                  par1World.setBlockMetadataWithNotify(par2 - 1, par3, par4, b0, 3);
              }
              else {
                  par1World.setBlockMetadataWithNotify(par2 + 1, par3, par4, b0, 3);
              }
              par1World.setBlockMetadataWithNotify(par2, par3, par4, b0, 3);
          }
      }
      if (par6ItemStack.hasDisplayName()) {
          ((TileEntityAncientChest)par1World.getTileEntity(par2, par3, par4)).setChestGuiName(par6ItemStack.getDisplayName());
      }
  }
  
  public void unifyAdjacentChests(final World par1World, final int par2, final int par3, final int par4) {
      if (!par1World.isRemote) {
          final Block l = par1World.getBlock(par2, par3, par4 - 1);
          final Block i1 = par1World.getBlock(par2, par3, par4 + 1);
          final Block j1 = par1World.getBlock(par2 - 1, par3, par4);
          final Block k1 = par1World.getBlock(par2 + 1, par3, par4);
          byte b0;
          if (l != this && i1 != this) {
              if (j1 != this && k1 != this) {
                  b0 = 3;
                  if (l.isOpaqueCube() && !i1.isOpaqueCube()) {
                      b0 = 3;
                  }
                  if (i1.isOpaqueCube() && !l.isOpaqueCube()) {
                      b0 = 2;
                  }
                  if (j1.isOpaqueCube() && !k1.isOpaqueCube()) {
                      b0 = 5;
                  }
                  if (k1.isOpaqueCube() && !j1.isOpaqueCube()) {
                      b0 = 4;
                  }
              }
              else {
                  final Block l2 = par1World.getBlock((j1 == this) ? (par2 - 1) : (par2 + 1), par3, par4 - 1);
                  final Block i2 = par1World.getBlock((j1 == this) ? (par2 - 1) : (par2 + 1), par3, par4 + 1);
                  b0 = 3;
                  int j2;
                  if (j1 == this) {
                      j2 = par1World.getBlockMetadata(par2 - 1, par3, par4);
                  }
                  else {
                      j2 = par1World.getBlockMetadata(par2 + 1, par3, par4);
                  }
                  if (j2 == 2) {
                      b0 = 2;
                  }
                  if ((l.isOpaqueCube() || l2.isOpaqueCube()) && !i1.isOpaqueCube() && !i2.isOpaqueCube()) {
                      b0 = 3;
                  }
                  if ((i1.isOpaqueCube() || i2.isOpaqueCube()) && !l.isOpaqueCube() && !l2.isOpaqueCube()) {
                      b0 = 2;
                  }
              }
          }
          else {
              final Block l2 = par1World.getBlock(par2 - 1, par3, (l == this) ? (par4 - 1) : (par4 + 1));
              final Block i2 = par1World.getBlock(par2 + 1, par3, (l == this) ? (par4 - 1) : (par4 + 1));
              b0 = 5;
              int j2;
              if (l == this) {
                  j2 = par1World.getBlockMetadata(par2, par3, par4 - 1);
              }
              else {
                  j2 = par1World.getBlockMetadata(par2, par3, par4 + 1);
              }
              if (j2 == 4) {
                  b0 = 4;
              }
              if ((j1.isOpaqueCube() || l2.isOpaqueCube()) && !k1.isOpaqueCube() && !i2.isOpaqueCube()) {
                  b0 = 5;
              }
              if ((k1.isOpaqueCube() || i2.isOpaqueCube()) && !j1.isOpaqueCube() && !l2.isOpaqueCube()) {
                  b0 = 4;
              }
          }
          par1World.setBlockMetadataWithNotify(par2, par3, par4, b0, 3);
      }
  }
  
  public boolean canPlaceBlockAt(final World par1World, final int par2, final int par3, final int par4) {
      int l = 0;
      if (par1World.getBlock(par2 - 1, par3, par4) == this) {
          ++l;
      }
      if (par1World.getBlock(par2 + 1, par3, par4) == this) {
          ++l;
      }
      if (par1World.getBlock(par2, par3, par4 - 1) == this) {
          ++l;
      }
      if (par1World.getBlock(par2, par3, par4 + 1) == this) {
          ++l;
      }
      return l <= 1 && !this.isThereANeighborChest(par1World, par2 - 1, par3, par4) && !this.isThereANeighborChest(par1World, par2 + 1, par3, par4) && !this.isThereANeighborChest(par1World, par2, par3, par4 - 1) && !this.isThereANeighborChest(par1World, par2, par3, par4 + 1);
  }
  
  private boolean isThereANeighborChest(final World par1World, final int par2, final int par3, final int par4) {
      return par1World.getBlock(par2, par3, par4) == this && (par1World.getBlock(par2 - 1, par3, par4) == this || par1World.getBlock(par2 + 1, par3, par4) == this || par1World.getBlock(par2, par3, par4 - 1) == this || par1World.getBlock(par2, par3, par4 + 1) == this);
  }
  
  public void onNeighborBlockChange(final World par1World, final int par2, final int par3, final int par4, final Block par5) {
      super.onNeighborBlockChange(par1World, par2, par3, par4, par5);
      final TileEntityAncientChest TileEntityAncientChest = (TileEntityAncientChest)par1World.getTileEntity(par2, par3, par4);
      if (TileEntityAncientChest != null) {
          TileEntityAncientChest.updateContainingBlockInfo();
      }
  }
  
  public void setBlockBoundsBasedOnState(final IBlockAccess par1IBlockAccess, final int par2, final int par3, final int par4) {
      if (par1IBlockAccess.getBlock(par2, par3, par4 - 1) == this) {
          this.setBlockBounds(0.0625f, 0.0f, 0.0f, 0.9375f, 0.875f, 0.9375f);
      }
      else if (par1IBlockAccess.getBlock(par2, par3, par4 + 1) == this) {
          this.setBlockBounds(0.0625f, 0.0f, 0.0625f, 0.9375f, 0.875f, 1.0f);
      }
      else if (par1IBlockAccess.getBlock(par2 - 1, par3, par4) == this) {
          this.setBlockBounds(0.0f, 0.0f, 0.0625f, 0.9375f, 0.875f, 0.9375f);
      }
      else if (par1IBlockAccess.getBlock(par2 + 1, par3, par4) == this) {
          this.setBlockBounds(0.0625f, 0.0f, 0.0625f, 1.0f, 0.875f, 0.9375f);
      }
      else {
          this.setBlockBounds(0.0625f, 0.0f, 0.0625f, 0.9375f, 0.875f, 0.9375f);
      }
  }
  
  public boolean onBlockActivated(final World world, final int x, final int y, final int z, final EntityPlayer par5EntityPlayer, final int par6, final float par7, final float par8, final float par9) {
      if (world.isRemote) {
          return true;
      }
      int meta = world.getBlockMetadata(x, y, z);
      ItemStack stack = par5EntityPlayer.inventory.getCurrentItem();
      if (stack != null && stack.getItem() != null && stack.getItem() == NovaCraftItems.powered_ancient_city_artifact) {
    	  --stack.stackSize;
    	  world.playSoundEffect(x, y, z, "nova_craft:chest.unlock", 1.5f, world.rand.nextFloat() - world.rand.nextFloat() * 0.1f + 0.9f);
    	  world.setBlock(x, y, z, NovaCraftBlocks.ancient_chest, meta, 2);
    	  TileEntityAncientChest chest = (TileEntityAncientChest) world.getTileEntity(x, y, z);
    	  
  		for (int slot = 0; slot < 3 + random.nextInt(25); slot++) {
  			chest.setInventorySlotContents(random.nextInt(chest.getSizeInventory()), this.getSpecialLoot(random));
  			chest.setInventorySlotContents(random.nextInt(chest.getSizeInventory()), this.getSpecialLoot(random));
  		}
      }
      else {
    	  par5EntityPlayer.addChatComponentMessage(new ChatComponentText(I18n.format("gui.ancient_city_chest")));
      }
      return true;
  }
  
  public TileEntity createNewTileEntity(final World par1World, final int i) {
      final TileEntityUnbreakbleAncientChest TileEntityAncientChest = new TileEntityUnbreakbleAncientChest();
      return TileEntityAncientChest;
  }
  
  @SideOnly(Side.CLIENT)
  public void registerBlockIcons(final IIconRegister iconRegister) {
      this.blockIcon = iconRegister.registerIcon("nova_craft:nullstone");
  }
  
  private ItemStack getSpecialLoot(Random random) {
		int item = random.nextInt(30);
		switch (item) {
			case 0:
				return new ItemStack(Items.diamond, random.nextInt(3) + 2);
			case 1:
				return new ItemStack(Items.skull, 1, 1);
			case 2:
				return new ItemStack(NovaCraftItems.larimar_shard, random.nextInt(15) + 3);
			case 3:
				return new ItemStack(NovaCraftItems.copartz_shard, random.nextInt(15) + 3);
			case 4:
				return new ItemStack(NovaCraftItems.tsavorokite_shard, random.nextInt(15) + 5);
			case 5:
				return new ItemStack(NovaCraftItems.yttrlinsite_shard,  random.nextInt(15) + 5);
			case 6: 
				return new ItemStack(Items.skull, 1, 1);
			case 7: 
				Enchantment enchantment = Enchantment.enchantmentsBookList[random.nextInt(Enchantment.enchantmentsBookList.length)];
		        		        
				int minLevel = enchantment.getMinLevel();
		        int maxLevel = enchantment.getMaxLevel();
		        int level = MathHelper.getRandomIntegerInRange(random, minLevel, maxLevel);
		        ItemStack itemStack = Items.enchanted_book.getEnchantedItemStack(new EnchantmentData(enchantment, maxLevel));
              
              return itemStack;
			case 8: 
				Enchantment enchantment2 = Enchantment.enchantmentsBookList[random.nextInt(Enchantment.enchantmentsBookList.length)];
		        
		        int minLevel2 = enchantment2.getMinLevel();
		        int maxLevel2 = enchantment2.getMaxLevel();
		        int level2 = MathHelper.getRandomIntegerInRange(random, minLevel2, maxLevel2);		       
		        ItemStack itemStack2 = Items.enchanted_book.getEnchantedItemStack(new EnchantmentData(enchantment2, maxLevel2));
              
              return itemStack2;
              
			case 9: 
				return new ItemStack(Items.diamond, random.nextInt(3) + 2);
			case 10: 
				return new ItemStack(NovaCraftItems.primeval_mace, 1);
			case 11: 
				return new ItemStack(Items.experience_bottle, random.nextInt(12) + 5);
			case 12:
				//Helmet enchants
			    Enchantment[] helmetEnchantments = {Enchantment.protection, Enchantment.projectileProtection, Enchantment.unbreaking, Enchantment.respiration};
			    Enchantment[] helmetEnchantments2 = {Enchantment.aquaAffinity, Enchantment.fireProtection, Enchantment.blastProtection};
			    Enchantment enchantment3 = helmetEnchantments[random.nextInt(helmetEnchantments.length)];
			    Enchantment enchantment33 = helmetEnchantments2[random.nextInt(helmetEnchantments2.length)];	
			    int maxLevel3 = enchantment3.getMaxLevel() + 1 + random.nextInt(1);			
			    int maxLevel33 = enchantment33.getMaxLevel() + 1 + random.nextInt(1);	
			    ItemStack itemStack3 = new ItemStack(NovaCraftItems.tophinite_helmet);
			    
			    itemStack3.addEnchantment(enchantment3, maxLevel3);
			    itemStack3.addEnchantment(enchantment33, maxLevel33);
			    
			    return itemStack3;
			case 13:
				//Chestplate enchants
			    Enchantment[] chestplateEnchantments = {Enchantment.protection, Enchantment.blastProtection};
			    Enchantment[] chestplateEnchantments2 = {Enchantment.unbreaking, Enchantment.fireProtection, Enchantment.projectileProtection};
			    
			    //Selects a random enchantment
			    Enchantment enchantment4 = chestplateEnchantments[random.nextInt(chestplateEnchantments.length)];		    
			    int maxLevel4 = enchantment4.getMaxLevel() + 1 + random.nextInt(1);		    
			    
			    Enchantment enchantment44 = chestplateEnchantments2[random.nextInt(chestplateEnchantments2.length)];		    
			    int maxLevel44 = enchantment44.getMaxLevel() + 1 + random.nextInt(1);
			    
			    //Creates an ItemStack for diamond chestplate
			    ItemStack itemStack4 = new ItemStack(NovaCraftItems.tophinite_chestplate);
			    
			    //Adds the enchantment
			    itemStack4.addEnchantment(enchantment4, maxLevel4);
			    itemStack4.addEnchantment(enchantment44, maxLevel44);
			    
			    return itemStack4;			
			case 14:
				//Legging enchants
			    Enchantment[] leggingsEnchantments = {Enchantment.protection, Enchantment.fireProtection};
			    Enchantment[] leggingsEnchantments2 = {Enchantment.unbreaking, Enchantment.blastProtection, Enchantment.projectileProtection};
			    Enchantment enchantment5 = leggingsEnchantments[random.nextInt(leggingsEnchantments.length)];
			    Enchantment enchantment55 = leggingsEnchantments2[random.nextInt(leggingsEnchantments2.length)];
			    int maxLevel5 = enchantment5.getMaxLevel() + 1 + random.nextInt(1);
			    int maxLevel55 = enchantment55.getMaxLevel() + 1 + random.nextInt(1);
			    ItemStack itemStack5 = new ItemStack(NovaCraftItems.tophinite_leggings);
			    
			    itemStack5.addEnchantment(enchantment5, maxLevel5);
			    itemStack5.addEnchantment(enchantment55, maxLevel55);
			    
			    return itemStack5;
			case 15:
				//Boot enchants
				Enchantment[] bootEnchantments = {Enchantment.protection, Enchantment.unbreaking};
			    Enchantment[] bootEnchantments2 = {Enchantment.projectileProtection, Enchantment.featherFalling, Enchantment.blastProtection, Enchantment.fireProtection};
			    Enchantment enchantment6 = bootEnchantments[random.nextInt(bootEnchantments.length)];
			    Enchantment enchantment66 = bootEnchantments2[random.nextInt(bootEnchantments2.length)];
			    int maxLevel6 = enchantment6.getMaxLevel() + 1 + random.nextInt(1);
			    int maxLevel66 = enchantment66.getMaxLevel() + 1 + random.nextInt(1);
			    ItemStack itemStack6 = new ItemStack(NovaCraftItems.tophinite_boots);
			    
			    itemStack6.addEnchantment(enchantment6, maxLevel6);
			    itemStack6.addEnchantment(enchantment66, maxLevel66);
			    
			    return itemStack6;
			case 16: 
				return new ItemStack(Blocks.iron_block, random.nextInt(18) + 8);
			case 17: 
				return new ItemStack(Blocks.gold_block, random.nextInt(13) + 11);
			case 18: 
				return new ItemStack(NovaCraftItems.vanite_ingot, random.nextInt(30) + 18);
			case 19: 
				return new ItemStack(Items.golden_apple, 1, 1);
			case 20: 
				return new ItemStack(Blocks.iron_block, random.nextInt(18) + 25);
			case 21: 
				return new ItemStack(NovaCraftItems.primeval_mace, 1);
			case 22: 
				return new ItemStack(NovaCraftItems.raw_klangite, random.nextInt(4) + 2);
			case 23: 
				return new ItemStack(NovaCraftItems.sculked_shard, random.nextInt(5) + 1);				
			case 24:
				//Helmet enchants
			    Enchantment[] helmetEnchantmentsB = {Enchantment.protection, Enchantment.projectileProtection, Enchantment.unbreaking, Enchantment.respiration};
			    Enchantment[] helmetEnchantments2B = {Enchantment.aquaAffinity, Enchantment.fireProtection, Enchantment.blastProtection};
			    Enchantment enchantment31 = helmetEnchantmentsB[random.nextInt(helmetEnchantmentsB.length)];
			    Enchantment enchantment331 = helmetEnchantments2B[random.nextInt(helmetEnchantments2B.length)];	
			    int maxLevel31 = enchantment31.getMaxLevel() + 1 + random.nextInt(1);			
			    int maxLevel331 = enchantment331.getMaxLevel() + 1 + random.nextInt(1);	
			    ItemStack itemStack31 = new ItemStack(NovaCraftItems.klangite_helmet);
			    
			    itemStack31.addEnchantment(enchantment31, maxLevel31);
			    itemStack31.addEnchantment(enchantment331, maxLevel331);
			    
			    return itemStack31;
			case 25:
				//Chestplate enchants
			    Enchantment[] chestplateEnchantmentsB = {Enchantment.protection, Enchantment.blastProtection};
			    Enchantment[] chestplateEnchantments2B = {Enchantment.unbreaking, Enchantment.fireProtection, Enchantment.projectileProtection};
			    
			    //Selects a random enchantment
			    Enchantment enchantment4B = chestplateEnchantmentsB[random.nextInt(chestplateEnchantmentsB.length)];		    
			    int maxLevel4B = enchantment4B.getMaxLevel() + 1 + random.nextInt(1);		    
			    
			    Enchantment enchantment44B = chestplateEnchantments2B[random.nextInt(chestplateEnchantments2B.length)];		    
			    int maxLevel44B = enchantment44B.getMaxLevel() + 1 + random.nextInt(1);
			    
			    //Creates an ItemStack for diamond chestplate
			    ItemStack itemStack4B = new ItemStack(NovaCraftItems.klangite_chestplate);
			    
			    //Adds the enchantment
			    itemStack4B.addEnchantment(enchantment4B, maxLevel4B);
			    itemStack4B.addEnchantment(enchantment44B, maxLevel44B);
			    
			    return itemStack4B;			
			case 26:
				//Legging enchants
			    Enchantment[] leggingsEnchantmentsB = {Enchantment.protection, Enchantment.fireProtection};
			    Enchantment[] leggingsEnchantments2B = {Enchantment.unbreaking, Enchantment.blastProtection, Enchantment.projectileProtection};
			    Enchantment enchantment5B = leggingsEnchantmentsB[random.nextInt(leggingsEnchantmentsB.length)];
			    Enchantment enchantment55B = leggingsEnchantments2B[random.nextInt(leggingsEnchantments2B.length)];
			    int maxLevel5B = enchantment5B.getMaxLevel() + 1 + random.nextInt(1);
			    int maxLevel55B = enchantment55B.getMaxLevel() + 1 + random.nextInt(1);
			    ItemStack itemStack5B = new ItemStack(NovaCraftItems.klangite_leggings);
			    
			    itemStack5B.addEnchantment(enchantment5B, maxLevel5B);
			    itemStack5B.addEnchantment(enchantment55B, maxLevel55B);
			    
			    return itemStack5B;
			case 27:
				//Boot enchants
				Enchantment[] bootEnchantmentsB = {Enchantment.protection, Enchantment.unbreaking};
			    Enchantment[] bootEnchantments2B = {Enchantment.projectileProtection, Enchantment.featherFalling, Enchantment.blastProtection, Enchantment.fireProtection};
			    Enchantment enchantment6B = bootEnchantmentsB[random.nextInt(bootEnchantmentsB.length)];
			    Enchantment enchantment66B = bootEnchantments2B[random.nextInt(bootEnchantments2B.length)];
			    int maxLevel6B = enchantment6B.getMaxLevel() + 1 + random.nextInt(1);
			    int maxLevel66B = enchantment66B.getMaxLevel() + 1 + random.nextInt(1);
			    ItemStack itemStack6B = new ItemStack(NovaCraftItems.klangite_boots);
			    
			    itemStack6B.addEnchantment(enchantment6B, maxLevel6B);
			    itemStack6B.addEnchantment(enchantment66B, maxLevel66B);
			    
			    return itemStack6B;
			case 28: 
				return new ItemStack(NovaCraftItems.dark_essence, random.nextInt(5) + 1);	
			    				
			default: {
				return new ItemStack(NovaCraftItems.blazing_coal, random.nextInt(26) + 12);
			}
		}
	}
}