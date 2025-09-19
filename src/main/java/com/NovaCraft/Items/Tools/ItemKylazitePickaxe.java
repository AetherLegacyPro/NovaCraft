package com.NovaCraft.Items.Tools;

import java.util.List;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.config.Configs;
import com.NovaCraft.entity.EntityFireProofItemNovaCraft;
import com.NovaCraft.registry.NovaCraftCreativeTabs;
import com.NovaCraft.registry.OtherModBlocks;
import com.NovaCraft.registry.OtherModItems;
import com.NovaCraftBlocks.NovaCraftBlocks;

import cpw.mods.fml.common.Loader;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class ItemKylazitePickaxe extends ItemPickaxe
{
    public ItemKylazitePickaxe() {
        super(NCToolMaterial.KYLAZITE);
        this.setCreativeTab((CreativeTabs)NovaCraftCreativeTabs.tools);
    }
    
    public boolean hasCustomEntity(final ItemStack stack) {
        return true;
    }
    
    public Entity createEntity(final World world, final Entity location, final ItemStack itemstack) {
        return (Entity)new EntityFireProofItemNovaCraft(world, location, itemstack);
    }
    
    @Override
   	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
   		return repair.getItem() == NovaCraftItems.nullified_dust;
   	}
    
    @Override
	public boolean onBlockDestroyed(ItemStack item, World world, Block block, int x, int y, int z, EntityLivingBase living)
    {		
	  boolean silkTouchModifier = EnchantmentHelper.getSilkTouchModifier(living);
	  if (silkTouchModifier == false) {
		//----------------------------------Aether Legacy--------------------------------
        if (world.getBlock(x, y, z) == OtherModBlocks.ambrosium_ore) {       
        	
        	if (!world.isRemote) {
        	EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(OtherModItems.ambrosium_shard, 2));
        	world.spawnEntityInWorld(entityItem);
        	}
        }
        if (world.getBlock(x, y, z) == OtherModBlocks.zanite_ore) {
        	   	
             if (!world.isRemote) {
             EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(OtherModItems.zanite_gemstone, 2));
             world.spawnEntityInWorld(entityItem);
             }
        }
        if (world.getBlock(x, y, z) == OtherModBlocks.arkenium_ore && Configs.enableAetherLegacyDepartureItems) {
        	          	
              if (!world.isRemote) {
              EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(OtherModItems.arkenium_fragement, 2));
              world.spawnEntityInWorld(entityItem);
              }
        }
        if (world.getBlock(x, y, z) == OtherModBlocks.gravitite_ore && Configs.enableAetherLegacyDepartureItems) {
           world.setBlock(x, y, z, Blocks.air);                  	
                             	
              if (!world.isRemote) {
              EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(OtherModItems.raw_gravitite, 2));
              world.spawnEntityInWorld(entityItem);
              }
        }
        if (world.getBlock(x, y, z) == OtherModBlocks.primeval_artifact && Configs.enableAetherLegacyDepartureItems) {        	
        	world.setBlock(x, y, z, Blocks.air);                  	
        	                  	
              if (!world.isRemote) {
              EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(OtherModItems.divineral_nugget, 14));
              world.spawnEntityInWorld(entityItem);
              }
        }
        
        
        //----------------------------------------------Vanilla-----------------------------------------------
        if (world.getBlock(x, y, z) == Blocks.coal_ore || world.getBlock(x, y, z) == OtherModBlocks.deepslate_coal_ore) {                               
        	                    	
              if (!world.isRemote) {
              EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(Items.coal, 2));
              world.spawnEntityInWorld(entityItem);
              }
        }
        {
        if (Loader.isModLoaded("etfuturum")) {
            if (world.getBlock(x, y, z) == Blocks.iron_ore || world.getBlock(x, y, z) == OtherModBlocks.deepslate_iron_ore) {
                  
            	  world.setBlock(x, y, z, Blocks.air);
            	                    	
                  if (!world.isRemote) {
                  EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(OtherModItems.raw_ore, 2, 1));
                  world.spawnEntityInWorld(entityItem);
                  }
             }
            }
            else {
            if (world.getBlock(x, y, z) == Blocks.iron_ore || world.getBlock(x, y, z) == OtherModBlocks.deepslate_iron_ore) { 
          	    world.setBlock(x, y, z, Blocks.air);
          	                    	
                if (!world.isRemote) {
                EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(Items.iron_ingot, 2));
                world.spawnEntityInWorld(entityItem);
                }
            }
         }
        }
        {
        if (Loader.isModLoaded("etfuturum")) {
            if (world.getBlock(x, y, z) == Blocks.gold_ore || world.getBlock(x, y, z) == OtherModBlocks.deepslate_gold_ore) {
                  
            	  world.setBlock(x, y, z, Blocks.air);
            	                    	
                  if (!world.isRemote) {
                  EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(OtherModItems.raw_ore, 2, 2));
                  world.spawnEntityInWorld(entityItem);
                  }
             }
            }
            else {
            if (world.getBlock(x, y, z) == Blocks.gold_ore || world.getBlock(x, y, z) == OtherModBlocks.deepslate_gold_ore) { 
          	    world.setBlock(x, y, z, Blocks.air);
          	                      	
                if (!world.isRemote) {
                EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(Items.gold_ingot, 2));
                world.spawnEntityInWorld(entityItem);
                }
            }
         }
        }
        if (world.getBlock(x, y, z) == Blocks.redstone_ore || world.getBlock(x, y, z) == Blocks.lit_redstone_ore  
        || world.getBlock(x, y, z) == OtherModBlocks.deepslate_redstone_ore || world.getBlock(x, y, z) == OtherModBlocks.deepslate_lit_redstone_ore) {
        	                  	
            if (!world.isRemote) {
            EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(Items.redstone, 4));
            world.spawnEntityInWorld(entityItem);
            }
        }
        if (world.getBlock(x, y, z) == Blocks.lapis_ore || world.getBlock(x, y, z) == OtherModBlocks.deepslate_lapis_ore) {
        	                  	
            if (!world.isRemote) {
            EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(Items.dye, 4, 4));
            world.spawnEntityInWorld(entityItem);
            }
       }
       if (world.getBlock(x, y, z) == Blocks.diamond_ore || world.getBlock(x, y, z) == OtherModBlocks.deepslate_diamond_ore) {
    	                      	
            if (!world.isRemote) {
            EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(Items.diamond, 1));
            world.spawnEntityInWorld(entityItem);
            }
       }
       if (world.getBlock(x, y, z) == Blocks.emerald_ore || world.getBlock(x, y, z) == OtherModBlocks.deepslate_emerald_ore) {
    	                     	
           if (!world.isRemote) {
           EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(Items.emerald, 1));
           world.spawnEntityInWorld(entityItem);
           }
      }
       if (world.getBlock(x, y, z) == Blocks.quartz_ore) {
    	                     	
           if (!world.isRemote) {
           EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(Items.quartz, 3));
           world.spawnEntityInWorld(entityItem);
           }
      }
      //----------------------------------------------Et Futurum Requiem-----------------------------------------------
       if (world.getBlock(x, y, z) == OtherModBlocks.ancient_debris) {
          
    	   world.setBlock(x, y, z, Blocks.air);
    	                     	
           if (!world.isRemote) {
           EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(OtherModItems.netherite_scrap, 2));
           world.spawnEntityInWorld(entityItem);
           }
      }
      if (world.getBlock(x, y, z) == OtherModBlocks.copper_ore || world.getBlock(x, y, z) == OtherModBlocks.deepslate_copper_ore) {
           
    	  world.setBlock(x, y, z, Blocks.air);
    	                    	
          if (!world.isRemote) {
          EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(OtherModItems.raw_ore, 3, 0));
          world.spawnEntityInWorld(entityItem);
          }
       }
      //----------------------------------------------Netherlicious----------------------------------------------------
      if (world.getBlock(x, y, z) == OtherModBlocks.EfrineOre) {         
    	                     	
          if (!world.isRemote) {
          EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(OtherModItems.Nugget, 4, 1));
          world.spawnEntityInWorld(entityItem);
          }
       } 
      //----------------------------------------------Divine RPG-------------------------------------------------------
      if (world.getBlock(x, y, z) == OtherModBlocks.realmiteOre) {
          
    	  world.setBlock(x, y, z, Blocks.air);
    	                     	
          if (!world.isRemote) {
          EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(OtherModItems.realmiteIngot, 2));
          world.spawnEntityInWorld(entityItem);
          }
       }
      if (world.getBlock(x, y, z) == OtherModBlocks.rupeeOre) {
          
    	  world.setBlock(x, y, z, Blocks.air);
    	                     	
          if (!world.isRemote) {
          EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(OtherModItems.rupeeIngot, 2));
          world.spawnEntityInWorld(entityItem);
          }
       }
      if (world.getBlock(x, y, z) == OtherModBlocks.arlemiteOre) {
          
    	  world.setBlock(x, y, z, Blocks.air);
    	                     	
          if (!world.isRemote) {
          EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(OtherModItems.arlemiteIngot, 2));
          world.spawnEntityInWorld(entityItem);
          }
       }
      
      //----------------------------------------------NovaCraft--------------------------------------------------------
      if (world.getBlock(x, y, z) == NovaCraftBlocks.etherstone_coal) {     	
    	                    	
          if (!world.isRemote) {
          EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(Items.coal, 2));
          world.spawnEntityInWorld(entityItem);
          }
    }
    {
    if (Loader.isModLoaded("etfuturum")) {
    	if (world.getBlock(x, y, z) == NovaCraftBlocks.etherstone_iron || world.getBlock(x, y, z) == NovaCraftBlocks.nullstone_iron 
    	        || world.getBlock(x, y, z) == NovaCraftBlocks.grimstone_iron) { 

        	  world.setBlock(x, y, z, Blocks.air);
        	                  	
              if (!world.isRemote) {
              EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(OtherModItems.raw_ore, 2, 1));
              world.spawnEntityInWorld(entityItem);
              }
         }
        }
        else {
        	if (world.getBlock(x, y, z) == NovaCraftBlocks.etherstone_iron || world.getBlock(x, y, z) == NovaCraftBlocks.nullstone_iron 
        	    || world.getBlock(x, y, z) == NovaCraftBlocks.grimstone_iron) {  
      	    world.setBlock(x, y, z, Blocks.air);
      	               	
            if (!world.isRemote) {
            EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(Items.iron_ingot, 2));
            world.spawnEntityInWorld(entityItem);
            }
        }
     }
    }
    {
    if (Loader.isModLoaded("etfuturum")) {
    	if (world.getBlock(x, y, z) == NovaCraftBlocks.etherstone_gold || world.getBlock(x, y, z) == NovaCraftBlocks.nullstone_gold 
    	        || world.getBlock(x, y, z) == NovaCraftBlocks.grimstone_gold) { 
              
        	  world.setBlock(x, y, z, Blocks.air);
        	                	
              if (!world.isRemote) {
              EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(OtherModItems.raw_ore, 2, 2));
              world.spawnEntityInWorld(entityItem);
              }
         }
        }
        else {
        if (world.getBlock(x, y, z) == NovaCraftBlocks.etherstone_gold || world.getBlock(x, y, z) == NovaCraftBlocks.nullstone_gold 
        || world.getBlock(x, y, z) == NovaCraftBlocks.grimstone_gold) { 
      	    world.setBlock(x, y, z, Blocks.air);
      	              	
            if (!world.isRemote) {
            EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(Items.gold_ingot, 2));
            world.spawnEntityInWorld(entityItem);
            }
        }
     }
    }
    if (world.getBlock(x, y, z) == NovaCraftBlocks.grimstone_redstone || world.getBlock(x, y, z) == NovaCraftBlocks.lit_grimstone_redstone
    || world.getBlock(x, y, z) == NovaCraftBlocks.lit_nullstone_redstone || world.getBlock(x, y, z) == NovaCraftBlocks.nullstone_redstone) {
    	               	
        if (!world.isRemote) {
        EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(Items.redstone, 4));
        world.spawnEntityInWorld(entityItem);
        }
    }
    if (world.getBlock(x, y, z) == NovaCraftBlocks.grimstone_lapis
    || world.getBlock(x, y, z) == NovaCraftBlocks.nullstone_lapis) {
    	                	
        if (!world.isRemote) {
        EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(Items.dye, 4, 4));
        world.spawnEntityInWorld(entityItem);
        }
   }
   if (world.getBlock(x, y, z) == NovaCraftBlocks.grimstone_diamond || world.getBlock(x, y, z) == NovaCraftBlocks.nullstone_diamond) {
	                    	
        if (!world.isRemote) {
        EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(Items.diamond, 1));
        world.spawnEntityInWorld(entityItem);
        }
   }
   if (world.getBlock(x, y, z) == NovaCraftBlocks.etherstone_emerald || world.getBlock(x, y, z) == NovaCraftBlocks.grimstone_emerald
   || world.getBlock(x, y, z) == NovaCraftBlocks.nullstone_emerald) {
	                	
       if (!world.isRemote) {
       EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(Items.emerald, 1));
       world.spawnEntityInWorld(entityItem);
       	    }
   	   }
   
   if (world.getBlock(x, y, z) == NovaCraftBlocks.deepslate_vanite_ore || world.getBlock(x, y, z) == NovaCraftBlocks.grimstone_vanite_ore
   || world.getBlock(x, y, z) == NovaCraftBlocks.nullstone_vanite_ore || world.getBlock(x, y, z) == NovaCraftBlocks.stone_vanite_ore) {
	                    	
		       if (!world.isRemote) {
		       EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(NovaCraftItems.vanite_chunk, 1));
		       world.spawnEntityInWorld(entityItem);
	   }
   }   
   if (world.getBlock(x, y, z) == NovaCraftBlocks.brimstone_ore || world.getBlock(x, y, z) == NovaCraftBlocks.etherstone_brimstone) {
		       
	   
	   if (!world.isRemote) {
	   EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(NovaCraftItems.brimstone_dust, 2));
	   world.spawnEntityInWorld(entityItem);
	   }
   }
   if (world.getBlock(x, y, z) == NovaCraftBlocks.deepslate_tophinite_ore || world.getBlock(x, y, z) == NovaCraftBlocks.nether_tophinite_ore
   || world.getBlock(x, y, z) == NovaCraftBlocks.nullstone_tophinite_ore || world.getBlock(x, y, z) == NovaCraftBlocks.stone_tophinite_ore) {
	   
	                      	
       if (!world.isRemote) {
       EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(NovaCraftItems.tophinite_gemstone, 1));
       world.spawnEntityInWorld(entityItem);
       }
  }
  if (world.getBlock(x, y, z) == NovaCraftBlocks.small_pherithium_stalagmite || world.getBlock(x, y, z) == NovaCraftBlocks.large_pherithium_stalagmite) {
	   
	                     	
       if (!world.isRemote) {
       EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(NovaCraftItems.pherithium_scraps, 3));
       world.spawnEntityInWorld(entityItem);
       }
  }
  if (world.getBlock(x, y, z) == NovaCraftBlocks.klangite_ore || world.getBlock(x, y, z) == NovaCraftBlocks.deepslate_klangite_ore
  || world.getBlock(x, y, z) == NovaCraftBlocks.end_klangite_ore || world.getBlock(x, y, z) == NovaCraftBlocks.frontierslate_klangite_ore
  || world.getBlock(x, y, z) == NovaCraftBlocks.stone_klangite_ore) {
		
	  
	  if (!world.isRemote) {
	  EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(NovaCraftItems.raw_klangite, 1));
	  world.spawnEntityInWorld(entityItem);
	  }
  }
  if (world.getBlock(x, y, z) == NovaCraftBlocks.xancium_ore) {
	  
	  
				                         	
	  if (!world.isRemote) {
	  EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(NovaCraftItems.xancium_dust, 2));
	  world.spawnEntityInWorld(entityItem);
		}
	}
  
  	
		  }
	  
	  Durability(item, living);
	  
	  
      return true;
    }
	
	public boolean Durability(ItemStack item, EntityLivingBase living) {
		int rand = (int)(1 + Math.random() * 100);
        if (rand < 50) {
		item.damageItem(1, living);
        }
        
		return true;
	 }
	
	public void addInformation(final ItemStack stack, final EntityPlayer player, final List tooltip, final boolean who) {
        tooltip.add(EnumChatFormatting.DARK_PURPLE + "" + StatCollector.translateToLocal("tooltip.kylazite_pickaxe.desc"));
    }
}
