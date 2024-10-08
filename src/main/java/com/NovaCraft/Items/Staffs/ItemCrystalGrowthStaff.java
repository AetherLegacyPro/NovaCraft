package com.NovaCraft.Items.Staffs;

import java.util.List;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.achievements.AchievementsNovaCraft;
import com.NovaCraft.entity.EntityEnderLordStaffProjectile;
import com.NovaCraft.registry.NovaCraftCreativeTabs;
import com.NovaCraftBlocks.NovaCraftBlocks;

import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class ItemCrystalGrowthStaff extends ItemSword {

	public ItemCrystalGrowthStaff() {
		super(ToolMaterial.EMERALD);
		this.setCreativeTab(NovaCraftCreativeTabs.tools);
		this.setMaxDamage(2361);
	}

	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		return repair.getItem() == NovaCraftItems.fractured_heart_of_the_end;
	}
	
	public void addInformation(final ItemStack stack, final EntityPlayer player, final List tooltip, final boolean who) {
        tooltip.add(EnumChatFormatting.LIGHT_PURPLE + "" + StatCollector.translateToLocal("tooltip.crystal_staff.desc"));
    }

	@Override
	public boolean onItemUse(ItemStack heldItem, EntityPlayer player, World world, int x, int y, int z, int facing, float hitX, float hitY, float hitZ) {
		Block block = world.getBlock(x, y, z);
		int meta = world.getBlockMetadata(x, y, z);
//----------------------------------------------------------------------------------------------------------------
		if (world.getBlock(x, y, z) == NovaCraftBlocks.copartz_cluster_1 && meta == 1) {
			
				world.setBlock(x, y, z, NovaCraftBlocks.copartz_cluster_1, 7, 7);
				world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
				heldItem.damageItem(4, player);
				player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
		}
		
		else if (world.getBlock(x, y, z) == NovaCraftBlocks.copartz_cluster_1 && meta == 7) {
			
			world.setBlock(x, y, z, NovaCraftBlocks.copartz_cluster_2, 1, 1);
			world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
			heldItem.damageItem(4, player);
			player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
		}
		
		else if (world.getBlock(x, y, z) == NovaCraftBlocks.copartz_cluster_2 && meta == 1) {
			
			world.setBlock(x, y, z, NovaCraftBlocks.copartz_cluster_2, 7, 7);
			world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
			heldItem.damageItem(4, player);
			player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
		}
		//side 1	
		else if (world.getBlock(x, y, z) == NovaCraftBlocks.copartz_cluster_1 && meta == 4) {
				
				world.setBlock(x, y, z, NovaCraftBlocks.copartz_cluster_1, 10, 10);
				world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
				heldItem.damageItem(4, player);
				player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
		}
		
		else if (world.getBlock(x, y, z) == NovaCraftBlocks.copartz_cluster_1 && meta == 10) {
			
			world.setBlock(x, y, z, NovaCraftBlocks.copartz_cluster_2, 4, 4);
			world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
			heldItem.damageItem(4, player);
			player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
		}
		
		else if (world.getBlock(x, y, z) == NovaCraftBlocks.copartz_cluster_2 && meta == 4) {
			
			world.setBlock(x, y, z, NovaCraftBlocks.copartz_cluster_2, 10, 10);
			world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
			heldItem.damageItem(4, player);
			player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
		}
		
			//side 2		
			else if (world.getBlock(x, y, z) == NovaCraftBlocks.copartz_cluster_1 && meta == 5) {
						
					world.setBlock(x, y, z, NovaCraftBlocks.copartz_cluster_1, 11, 11);
					world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
					heldItem.damageItem(4, player);
			player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
			}
				
			else if (world.getBlock(x, y, z) == NovaCraftBlocks.copartz_cluster_1 && meta == 11) {
					
				world.setBlock(x, y, z, NovaCraftBlocks.copartz_cluster_2, 5, 5);
				world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
				heldItem.damageItem(4, player);
				player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
			}
				
			else if (world.getBlock(x, y, z) == NovaCraftBlocks.copartz_cluster_2 && meta == 5) {
					
				world.setBlock(x, y, z, NovaCraftBlocks.copartz_cluster_2, 11, 11);
				world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
				heldItem.damageItem(4, player);
				player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
			}
			
			//top		
			else if (world.getBlock(x, y, z) == NovaCraftBlocks.copartz_cluster_1 && meta == 0) {
						
					world.setBlock(x, y, z, NovaCraftBlocks.copartz_cluster_1, 6, 6);
					world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
					heldItem.damageItem(4, player);
					player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
			}
				
			else if (world.getBlock(x, y, z) == NovaCraftBlocks.copartz_cluster_1 && meta == 6) {
					
				world.setBlock(x, y, z, NovaCraftBlocks.copartz_cluster_2, 0, 0);
				world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
				heldItem.damageItem(4, player);
				player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
			}
				
			else if (world.getBlock(x, y, z) == NovaCraftBlocks.copartz_cluster_2 && meta == 0) {
					
				world.setBlock(x, y, z, NovaCraftBlocks.copartz_cluster_2, 6, 6);
				world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
				heldItem.damageItem(4, player);
				player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
			}
						
		//side		
			else if (world.getBlock(x, y, z) == NovaCraftBlocks.copartz_cluster_1 && meta == 3) {
						
					world.setBlock(x, y, z, NovaCraftBlocks.copartz_cluster_1, 9, 9);
					world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
					heldItem.damageItem(4, player);
					player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
			}
				
			else if (world.getBlock(x, y, z) == NovaCraftBlocks.copartz_cluster_1 && meta == 9) {
					
				world.setBlock(x, y, z, NovaCraftBlocks.copartz_cluster_2, 3, 3);
				world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
				heldItem.damageItem(4, player);
				player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
			}
				
			else if (world.getBlock(x, y, z) == NovaCraftBlocks.copartz_cluster_2 && meta == 3) {
					
				world.setBlock(x, y, z, NovaCraftBlocks.copartz_cluster_2, 9, 9);
				world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
				heldItem.damageItem(4, player);
				player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
			}
			
		//side		
			else if (world.getBlock(x, y, z) == NovaCraftBlocks.copartz_cluster_1 && meta == 2) {
						
					world.setBlock(x, y, z, NovaCraftBlocks.copartz_cluster_1, 8, 89);
					world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
					heldItem.damageItem(4, player);
					player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
			}
				
			else if (world.getBlock(x, y, z) == NovaCraftBlocks.copartz_cluster_1 && meta == 8) {
					
				world.setBlock(x, y, z, NovaCraftBlocks.copartz_cluster_2, 2, 2);
				world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
				heldItem.damageItem(4, player);
				player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
			}
				
			else if (world.getBlock(x, y, z) == NovaCraftBlocks.copartz_cluster_2 && meta == 2) {
					
				world.setBlock(x, y, z, NovaCraftBlocks.copartz_cluster_2, 8, 8);
				world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
				heldItem.damageItem(4, player);
				player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
			}
				
//----------------------------------------------------------------------------------------------------------------
				if (world.getBlock(x, y, z) == NovaCraftBlocks.larimar_cluster_1 && meta == 1) {
					
						world.setBlock(x, y, z, NovaCraftBlocks.larimar_cluster_1, 7, 7);
						world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
						heldItem.damageItem(5, player);
						player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
				}
				
				else if (world.getBlock(x, y, z) == NovaCraftBlocks.larimar_cluster_1 && meta == 7) {
					
					world.setBlock(x, y, z, NovaCraftBlocks.larimar_cluster_2, 1, 1);
					world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
					heldItem.damageItem(5, player);
					player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
				}
				
				else if (world.getBlock(x, y, z) == NovaCraftBlocks.larimar_cluster_2 && meta == 1) {
					
					world.setBlock(x, y, z, NovaCraftBlocks.larimar_cluster_2, 7, 7);
					world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
					heldItem.damageItem(5, player);
					player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
				}
				//side 1	
				else if (world.getBlock(x, y, z) == NovaCraftBlocks.larimar_cluster_1 && meta == 4) {
						
						world.setBlock(x, y, z, NovaCraftBlocks.larimar_cluster_1, 10, 10);
						world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
						heldItem.damageItem(5, player);
						player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
				}
				
				else if (world.getBlock(x, y, z) == NovaCraftBlocks.larimar_cluster_1 && meta == 10) {
					
					world.setBlock(x, y, z, NovaCraftBlocks.larimar_cluster_2, 4, 4);
					world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
					heldItem.damageItem(5, player);
					player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
				}
				
				else if (world.getBlock(x, y, z) == NovaCraftBlocks.larimar_cluster_2 && meta == 4) {
					
					world.setBlock(x, y, z, NovaCraftBlocks.larimar_cluster_2, 10, 10);
					world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
					heldItem.damageItem(5, player);
					player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
				}
				
					//side 2		
					else if (world.getBlock(x, y, z) == NovaCraftBlocks.larimar_cluster_1 && meta == 5) {
								
							world.setBlock(x, y, z, NovaCraftBlocks.larimar_cluster_1, 11, 11);
							world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
							heldItem.damageItem(5, player);
							player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
					}
						
					else if (world.getBlock(x, y, z) == NovaCraftBlocks.larimar_cluster_1 && meta == 11) {
							
						world.setBlock(x, y, z, NovaCraftBlocks.larimar_cluster_2, 5, 5);
						world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
						heldItem.damageItem(5, player);
						player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
					}
						
					else if (world.getBlock(x, y, z) == NovaCraftBlocks.larimar_cluster_2 && meta == 5) {
							
						world.setBlock(x, y, z, NovaCraftBlocks.larimar_cluster_2, 11, 11);
						world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
						heldItem.damageItem(5, player);
						player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
					}
					
					//top		
					else if (world.getBlock(x, y, z) == NovaCraftBlocks.larimar_cluster_1 && meta == 0) {
								
							world.setBlock(x, y, z, NovaCraftBlocks.larimar_cluster_1, 6, 6);
							world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
							heldItem.damageItem(5, player);
							player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
					}
						
					else if (world.getBlock(x, y, z) == NovaCraftBlocks.larimar_cluster_1 && meta == 6) {
							
						world.setBlock(x, y, z, NovaCraftBlocks.larimar_cluster_2, 0, 0);
						world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
						heldItem.damageItem(5, player);
						player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
					}
						
					else if (world.getBlock(x, y, z) == NovaCraftBlocks.larimar_cluster_2 && meta == 0) {
							
						world.setBlock(x, y, z, NovaCraftBlocks.larimar_cluster_2, 6, 6);
						world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
						heldItem.damageItem(5, player);
						player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
					}
								
				//side		
					else if (world.getBlock(x, y, z) == NovaCraftBlocks.larimar_cluster_1 && meta == 3) {
								
							world.setBlock(x, y, z, NovaCraftBlocks.larimar_cluster_1, 9, 9);
							world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
							heldItem.damageItem(5, player);
							player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
					}
						
					else if (world.getBlock(x, y, z) == NovaCraftBlocks.larimar_cluster_1 && meta == 9) {
							
						world.setBlock(x, y, z, NovaCraftBlocks.larimar_cluster_2, 3, 3);
						world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
						heldItem.damageItem(5, player);
						player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
					}
						
					else if (world.getBlock(x, y, z) == NovaCraftBlocks.larimar_cluster_2 && meta == 3) {
							
						world.setBlock(x, y, z, NovaCraftBlocks.larimar_cluster_2, 9, 9);
						world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
						heldItem.damageItem(5, player);
						player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
					}
					
				//side		
					else if (world.getBlock(x, y, z) == NovaCraftBlocks.larimar_cluster_1 && meta == 2) {
								
							world.setBlock(x, y, z, NovaCraftBlocks.larimar_cluster_1, 8, 89);
							world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
							heldItem.damageItem(5, player);
							player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
					}
						
					else if (world.getBlock(x, y, z) == NovaCraftBlocks.larimar_cluster_1 && meta == 8) {
							
						world.setBlock(x, y, z, NovaCraftBlocks.larimar_cluster_2, 2, 2);
						world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
						heldItem.damageItem(5, player);
						player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
					}
						
					else if (world.getBlock(x, y, z) == NovaCraftBlocks.larimar_cluster_2 && meta == 2) {
							
						world.setBlock(x, y, z, NovaCraftBlocks.larimar_cluster_2, 8, 8);
						world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
						heldItem.damageItem(5, player);
						player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
					}
								
//----------------------------------------------------------------------------------------------------------------
				if (world.getBlock(x, y, z) == NovaCraftBlocks.tsavorokite_cluster_1 && meta == 1) {
					
						world.setBlock(x, y, z, NovaCraftBlocks.tsavorokite_cluster_1, 7, 7);
						world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
						heldItem.damageItem(6, player);
						player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
				}
				
				else if (world.getBlock(x, y, z) == NovaCraftBlocks.tsavorokite_cluster_1 && meta == 7) {
					
					world.setBlock(x, y, z, NovaCraftBlocks.tsavorokite_cluster_2, 1, 1);
					world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
					heldItem.damageItem(6, player);
					player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
				}
				
				else if (world.getBlock(x, y, z) == NovaCraftBlocks.tsavorokite_cluster_2 && meta == 1) {
					
					world.setBlock(x, y, z, NovaCraftBlocks.tsavorokite_cluster_2, 7, 7);
					world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
					heldItem.damageItem(6, player);
					player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
				}
				//side 1	
				else if (world.getBlock(x, y, z) == NovaCraftBlocks.tsavorokite_cluster_1 && meta == 4) {
						
						world.setBlock(x, y, z, NovaCraftBlocks.tsavorokite_cluster_1, 10, 10);
						world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
						heldItem.damageItem(6, player);
						player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
				}
				
				else if (world.getBlock(x, y, z) == NovaCraftBlocks.tsavorokite_cluster_1 && meta == 10) {
					
					world.setBlock(x, y, z, NovaCraftBlocks.tsavorokite_cluster_2, 4, 4);
					world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
					heldItem.damageItem(6, player);
					player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
				}
				
				else if (world.getBlock(x, y, z) == NovaCraftBlocks.tsavorokite_cluster_2 && meta == 4) {
					
					world.setBlock(x, y, z, NovaCraftBlocks.tsavorokite_cluster_2, 10, 10);
					world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
					heldItem.damageItem(6, player);
					player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
				}
				
					//side 2		
					else if (world.getBlock(x, y, z) == NovaCraftBlocks.tsavorokite_cluster_1 && meta == 5) {
								
							world.setBlock(x, y, z, NovaCraftBlocks.tsavorokite_cluster_1, 11, 11);
							world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
							heldItem.damageItem(6, player);
							player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
					}
						
					else if (world.getBlock(x, y, z) == NovaCraftBlocks.tsavorokite_cluster_1 && meta == 11) {
							
						world.setBlock(x, y, z, NovaCraftBlocks.tsavorokite_cluster_2, 5, 5);
						world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
						heldItem.damageItem(6, player);
						player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
					}
						
					else if (world.getBlock(x, y, z) == NovaCraftBlocks.tsavorokite_cluster_2 && meta == 5) {
							
						world.setBlock(x, y, z, NovaCraftBlocks.tsavorokite_cluster_2, 11, 11);
						world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
						heldItem.damageItem(6, player);
						player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
					}
					
					//top		
					else if (world.getBlock(x, y, z) == NovaCraftBlocks.tsavorokite_cluster_1 && meta == 0) {
								
							world.setBlock(x, y, z, NovaCraftBlocks.tsavorokite_cluster_1, 6, 6);
							world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
							heldItem.damageItem(6, player);
							player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
					}
						
					else if (world.getBlock(x, y, z) == NovaCraftBlocks.tsavorokite_cluster_1 && meta == 6) {
							
						world.setBlock(x, y, z, NovaCraftBlocks.tsavorokite_cluster_2, 0, 0);
						world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
						heldItem.damageItem(6, player);
						player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
					}
						
					else if (world.getBlock(x, y, z) == NovaCraftBlocks.tsavorokite_cluster_2 && meta == 0) {
							
						world.setBlock(x, y, z, NovaCraftBlocks.tsavorokite_cluster_2, 6, 6);
						world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
						heldItem.damageItem(6, player);
						player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
					}
								
				//side		
					else if (world.getBlock(x, y, z) == NovaCraftBlocks.tsavorokite_cluster_1 && meta == 3) {
								
							world.setBlock(x, y, z, NovaCraftBlocks.tsavorokite_cluster_1, 9, 9);
							world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
							heldItem.damageItem(6, player);
							player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
					}
						
					else if (world.getBlock(x, y, z) == NovaCraftBlocks.tsavorokite_cluster_1 && meta == 9) {
							
						world.setBlock(x, y, z, NovaCraftBlocks.tsavorokite_cluster_2, 3, 3);
						world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
						heldItem.damageItem(6, player);
						player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
					}
						
					else if (world.getBlock(x, y, z) == NovaCraftBlocks.tsavorokite_cluster_2 && meta == 3) {
							
						world.setBlock(x, y, z, NovaCraftBlocks.tsavorokite_cluster_2, 9, 9);
						world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
						heldItem.damageItem(6, player);
						player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
					}
					
				//side		
					else if (world.getBlock(x, y, z) == NovaCraftBlocks.tsavorokite_cluster_1 && meta == 2) {
								
							world.setBlock(x, y, z, NovaCraftBlocks.tsavorokite_cluster_1, 8, 89);
							world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
							heldItem.damageItem(6, player);
							player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
					}
						
					else if (world.getBlock(x, y, z) == NovaCraftBlocks.tsavorokite_cluster_1 && meta == 8) {
							
						world.setBlock(x, y, z, NovaCraftBlocks.tsavorokite_cluster_2, 2, 2);
						world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
						heldItem.damageItem(6, player);
						player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
					}
						
					else if (world.getBlock(x, y, z) == NovaCraftBlocks.tsavorokite_cluster_2 && meta == 2) {
							
						world.setBlock(x, y, z, NovaCraftBlocks.tsavorokite_cluster_2, 8, 8);
						world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
						heldItem.damageItem(6, player);
						player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
					}											
//----------------------------------------------------------------------------------------------------------------
				if (world.getBlock(x, y, z) == NovaCraftBlocks.yttrlinsite_cluster_1 && meta == 1) {
					
						world.setBlock(x, y, z, NovaCraftBlocks.yttrlinsite_cluster_1, 7, 7);
						world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
						heldItem.damageItem(7, player);
						player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
				}
				
				else if (world.getBlock(x, y, z) == NovaCraftBlocks.yttrlinsite_cluster_1 && meta == 7) {
					
					world.setBlock(x, y, z, NovaCraftBlocks.yttrlinsite_cluster_2, 1, 1);
					world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
					heldItem.damageItem(7, player);
					player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
				}
				
				else if (world.getBlock(x, y, z) == NovaCraftBlocks.yttrlinsite_cluster_2 && meta == 1) {
					
					world.setBlock(x, y, z, NovaCraftBlocks.yttrlinsite_cluster_2, 7, 7);
					world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
					heldItem.damageItem(7, player);
					player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
				}
				//side 1	
				else if (world.getBlock(x, y, z) == NovaCraftBlocks.yttrlinsite_cluster_1 && meta == 4) {
						
						world.setBlock(x, y, z, NovaCraftBlocks.yttrlinsite_cluster_1, 10, 10);
						world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
						heldItem.damageItem(7, player);
						player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
				}
				
				else if (world.getBlock(x, y, z) == NovaCraftBlocks.yttrlinsite_cluster_1 && meta == 10) {
					
					world.setBlock(x, y, z, NovaCraftBlocks.yttrlinsite_cluster_2, 4, 4);
					world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
					heldItem.damageItem(7, player);
					player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
				}
				
				else if (world.getBlock(x, y, z) == NovaCraftBlocks.yttrlinsite_cluster_2 && meta == 4) {
					
					world.setBlock(x, y, z, NovaCraftBlocks.yttrlinsite_cluster_2, 10, 10);
					world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
					heldItem.damageItem(7, player);
					player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
				}
				
					//side 2		
					else if (world.getBlock(x, y, z) == NovaCraftBlocks.yttrlinsite_cluster_1 && meta == 5) {
								
							world.setBlock(x, y, z, NovaCraftBlocks.yttrlinsite_cluster_1, 11, 11);
							world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
							heldItem.damageItem(7, player);
							player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
					}
						
					else if (world.getBlock(x, y, z) == NovaCraftBlocks.yttrlinsite_cluster_1 && meta == 11) {
							
						world.setBlock(x, y, z, NovaCraftBlocks.yttrlinsite_cluster_2, 5, 5);
						world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
						heldItem.damageItem(7, player);
						player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
					}
						
					else if (world.getBlock(x, y, z) == NovaCraftBlocks.yttrlinsite_cluster_2 && meta == 5) {
							
						world.setBlock(x, y, z, NovaCraftBlocks.yttrlinsite_cluster_2, 11, 11);
						world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
						heldItem.damageItem(7, player);
						player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
					}
					
					//top		
					else if (world.getBlock(x, y, z) == NovaCraftBlocks.yttrlinsite_cluster_1 && meta == 0) {
								
							world.setBlock(x, y, z, NovaCraftBlocks.yttrlinsite_cluster_1, 6, 6);
							world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
							heldItem.damageItem(7, player);
							player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
					}
						
					else if (world.getBlock(x, y, z) == NovaCraftBlocks.yttrlinsite_cluster_1 && meta == 6) {
							
						world.setBlock(x, y, z, NovaCraftBlocks.yttrlinsite_cluster_2, 0, 0);
						world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
						heldItem.damageItem(7, player);
						player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
					}
						
					else if (world.getBlock(x, y, z) == NovaCraftBlocks.yttrlinsite_cluster_2 && meta == 0) {
							
						world.setBlock(x, y, z, NovaCraftBlocks.yttrlinsite_cluster_2, 6, 6);
						world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
						heldItem.damageItem(7, player);
						player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
					}
								
				//side		
					else if (world.getBlock(x, y, z) == NovaCraftBlocks.yttrlinsite_cluster_1 && meta == 3) {
								
							world.setBlock(x, y, z, NovaCraftBlocks.yttrlinsite_cluster_1, 9, 9);
							world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
							heldItem.damageItem(7, player);
							player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
					}
						
					else if (world.getBlock(x, y, z) == NovaCraftBlocks.yttrlinsite_cluster_1 && meta == 9) {
							
						world.setBlock(x, y, z, NovaCraftBlocks.yttrlinsite_cluster_2, 3, 3);
						world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
						heldItem.damageItem(7, player);
						player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
					}
						
					else if (world.getBlock(x, y, z) == NovaCraftBlocks.yttrlinsite_cluster_2 && meta == 3) {
							
						world.setBlock(x, y, z, NovaCraftBlocks.yttrlinsite_cluster_2, 9, 9);
						world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
						heldItem.damageItem(7, player);
						player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
					}
					
				//side		
					else if (world.getBlock(x, y, z) == NovaCraftBlocks.yttrlinsite_cluster_1 && meta == 2) {
								
							world.setBlock(x, y, z, NovaCraftBlocks.yttrlinsite_cluster_1, 8, 89);
							world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
							heldItem.damageItem(7, player);
							player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
					}
						
					else if (world.getBlock(x, y, z) == NovaCraftBlocks.yttrlinsite_cluster_1 && meta == 8) {
							
						world.setBlock(x, y, z, NovaCraftBlocks.yttrlinsite_cluster_2, 2, 2);
						world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
						heldItem.damageItem(7, player);
						player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
					}
						
					else if (world.getBlock(x, y, z) == NovaCraftBlocks.yttrlinsite_cluster_2 && meta == 2) {
							
						world.setBlock(x, y, z, NovaCraftBlocks.yttrlinsite_cluster_2, 8, 8);
						world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
						heldItem.damageItem(7, player);
						player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
					}											
//----------------------------------------------------------------------------------------------------------------
				if (world.getBlock(x, y, z) == NovaCraftBlocks.aether_cluster_1 && meta == 1 && world.provider.dimensionId == 0) {
					
						world.setBlock(x, y, z, NovaCraftBlocks.aether_cluster_1, 7, 7);
						world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
						heldItem.damageItem(10, player);
						player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
				}
				
				else if (world.getBlock(x, y, z) == NovaCraftBlocks.aether_cluster_1 && meta == 7 && world.provider.dimensionId == 0) {
					
					world.setBlock(x, y, z, NovaCraftBlocks.aether_cluster_2, 1, 1);
					world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
					heldItem.damageItem(10, player);
					player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
				}
				
				else if (world.getBlock(x, y, z) == NovaCraftBlocks.aether_cluster_2 && meta == 1 && world.provider.dimensionId == 0) {
					
					world.setBlock(x, y, z, NovaCraftBlocks.aether_cluster_2, 7, 7);
					world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
					heldItem.damageItem(10, player);
					player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
				}
				//side 1	
				else if (world.getBlock(x, y, z) == NovaCraftBlocks.aether_cluster_1 && meta == 4 && world.provider.dimensionId == 0) {
						
						world.setBlock(x, y, z, NovaCraftBlocks.aether_cluster_1, 10, 10);
						world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
						heldItem.damageItem(10, player);
						player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
				}
				
				else if (world.getBlock(x, y, z) == NovaCraftBlocks.aether_cluster_1 && meta == 10 && world.provider.dimensionId == 0) {
					
					world.setBlock(x, y, z, NovaCraftBlocks.aether_cluster_2, 4, 4);
					world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
					heldItem.damageItem(10, player);
					player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
				}
				
				else if (world.getBlock(x, y, z) == NovaCraftBlocks.aether_cluster_2 && meta == 4 && world.provider.dimensionId == 0) {
					
					world.setBlock(x, y, z, NovaCraftBlocks.aether_cluster_2, 10, 10);
					world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
					heldItem.damageItem(10, player);
					player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
				}
				
					//side 2		
					else if (world.getBlock(x, y, z) == NovaCraftBlocks.aether_cluster_1 && meta == 5 && world.provider.dimensionId == 0) {
								
							world.setBlock(x, y, z, NovaCraftBlocks.aether_cluster_1, 11, 11);
							world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
							heldItem.damageItem(10, player);
							player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
					}
						
					else if (world.getBlock(x, y, z) == NovaCraftBlocks.aether_cluster_1 && meta == 11 && world.provider.dimensionId == 0) {
							
						world.setBlock(x, y, z, NovaCraftBlocks.aether_cluster_2, 5, 5);
						world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
						heldItem.damageItem(10, player);
						player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
					}
						
					else if (world.getBlock(x, y, z) == NovaCraftBlocks.aether_cluster_2 && meta == 5 && world.provider.dimensionId == 0) {
							
						world.setBlock(x, y, z, NovaCraftBlocks.aether_cluster_2, 11, 11);
						world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
						heldItem.damageItem(10, player);
						player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
					}
					
					//top		
					else if (world.getBlock(x, y, z) == NovaCraftBlocks.aether_cluster_1 && meta == 0 && world.provider.dimensionId == 0) {
								
							world.setBlock(x, y, z, NovaCraftBlocks.aether_cluster_1, 6, 6);
							world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
							heldItem.damageItem(10, player);
							player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
					}
						
					else if (world.getBlock(x, y, z) == NovaCraftBlocks.aether_cluster_1 && meta == 6 && world.provider.dimensionId == 0) {
							
						world.setBlock(x, y, z, NovaCraftBlocks.aether_cluster_2, 0, 0);
						world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
						heldItem.damageItem(10, player);
						player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
					}
						
					else if (world.getBlock(x, y, z) == NovaCraftBlocks.aether_cluster_2 && meta == 0 && world.provider.dimensionId == 0) {
							
						world.setBlock(x, y, z, NovaCraftBlocks.aether_cluster_2, 6, 6);
						world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
						heldItem.damageItem(10, player);
						player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
					}
								
				//side		
					else if (world.getBlock(x, y, z) == NovaCraftBlocks.aether_cluster_1 && meta == 3 && world.provider.dimensionId == 0) {
								
							world.setBlock(x, y, z, NovaCraftBlocks.aether_cluster_1, 9, 9);
							world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
							heldItem.damageItem(10, player);
							player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
					}
						
					else if (world.getBlock(x, y, z) == NovaCraftBlocks.aether_cluster_1 && meta == 9 && world.provider.dimensionId == 0) {
							
						world.setBlock(x, y, z, NovaCraftBlocks.aether_cluster_2, 3, 3);
						world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
						heldItem.damageItem(10, player);
						player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
					}
						
					else if (world.getBlock(x, y, z) == NovaCraftBlocks.aether_cluster_2 && meta == 3 && world.provider.dimensionId == 0) {
							
						world.setBlock(x, y, z, NovaCraftBlocks.aether_cluster_2, 9, 9);
						world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
						heldItem.damageItem(10, player);
						player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
					}
					
				//side		
					else if (world.getBlock(x, y, z) == NovaCraftBlocks.aether_cluster_1 && meta == 2 && world.provider.dimensionId == 0) {
								
							world.setBlock(x, y, z, NovaCraftBlocks.aether_cluster_1, 8, 89);
							world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
							heldItem.damageItem(10, player);
							player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
					}
						
					else if (world.getBlock(x, y, z) == NovaCraftBlocks.aether_cluster_1 && meta == 8 && world.provider.dimensionId == 0) {
							
						world.setBlock(x, y, z, NovaCraftBlocks.aether_cluster_2, 2, 2);
						world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
						heldItem.damageItem(10, player);
						player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
					}
						
					else if (world.getBlock(x, y, z) == NovaCraftBlocks.aether_cluster_2 && meta == 2 && world.provider.dimensionId == 0) {
							
						world.setBlock(x, y, z, NovaCraftBlocks.aether_cluster_2, 8, 8);
						world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
						heldItem.damageItem(10, player);
						player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
					}									
//----------------------------------------------------------------------------------------------------------------
				if (world.getBlock(x, y, z) == NovaCraftBlocks.echo_cluster_1 && meta == 1 && world.provider.dimensionId == 1) {
					
						world.setBlock(x, y, z, NovaCraftBlocks.echo_cluster_1, 7, 7);
						world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
						heldItem.damageItem(5, player);
						player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
				}
				
				else if (world.getBlock(x, y, z) == NovaCraftBlocks.echo_cluster_1 && meta == 7 && world.provider.dimensionId == 1) {
					
					world.setBlock(x, y, z, NovaCraftBlocks.echo_cluster_2, 1, 1);
					world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
					heldItem.damageItem(5, player);
					player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
				}
				
				else if (world.getBlock(x, y, z) == NovaCraftBlocks.echo_cluster_2 && meta == 1 && world.provider.dimensionId == 1) {
					
					world.setBlock(x, y, z, NovaCraftBlocks.echo_cluster_2, 7, 7);
					world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
					heldItem.damageItem(5, player);
					player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
				}
				//side 1	
				else if (world.getBlock(x, y, z) == NovaCraftBlocks.echo_cluster_1 && meta == 4 && world.provider.dimensionId == 1) {
						
						world.setBlock(x, y, z, NovaCraftBlocks.echo_cluster_1, 10, 10);
						world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
						heldItem.damageItem(5, player);
						player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
				}
				
				else if (world.getBlock(x, y, z) == NovaCraftBlocks.echo_cluster_1 && meta == 10 && world.provider.dimensionId == 1) {
					
					world.setBlock(x, y, z, NovaCraftBlocks.echo_cluster_2, 4, 4);
					world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
					heldItem.damageItem(5, player);
					player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
				}
				
				else if (world.getBlock(x, y, z) == NovaCraftBlocks.echo_cluster_2 && meta == 4 && world.provider.dimensionId == 1) {
					
					world.setBlock(x, y, z, NovaCraftBlocks.echo_cluster_2, 10, 10);
					world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
					heldItem.damageItem(5, player);
					player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
					}
				
					//side 2		
					else if (world.getBlock(x, y, z) == NovaCraftBlocks.echo_cluster_1 && meta == 5 && world.provider.dimensionId == 1) {
								
							world.setBlock(x, y, z, NovaCraftBlocks.echo_cluster_1, 11, 11);
							world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
							heldItem.damageItem(5, player);
							player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
					}
						
					else if (world.getBlock(x, y, z) == NovaCraftBlocks.echo_cluster_1 && meta == 11 && world.provider.dimensionId == 1) {
							
						world.setBlock(x, y, z, NovaCraftBlocks.echo_cluster_2, 5, 5);
						world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
						heldItem.damageItem(5, player);
						player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
					}
						
					else if (world.getBlock(x, y, z) == NovaCraftBlocks.echo_cluster_2 && meta == 5 && world.provider.dimensionId == 1) {
							
						world.setBlock(x, y, z, NovaCraftBlocks.echo_cluster_2, 11, 11);
						world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
						heldItem.damageItem(5, player);
						player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
					}
					
					//top		
					else if (world.getBlock(x, y, z) == NovaCraftBlocks.echo_cluster_1 && meta == 0 && world.provider.dimensionId == 1) {
								
							world.setBlock(x, y, z, NovaCraftBlocks.echo_cluster_1, 6, 6);
							world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
							heldItem.damageItem(5, player);
							player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
					}
						
					else if (world.getBlock(x, y, z) == NovaCraftBlocks.echo_cluster_1 && meta == 6 && world.provider.dimensionId == 1) {
							
						world.setBlock(x, y, z, NovaCraftBlocks.echo_cluster_2, 0, 0);
						world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
						heldItem.damageItem(5, player);
						player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
					}
						
					else if (world.getBlock(x, y, z) == NovaCraftBlocks.echo_cluster_2 && meta == 0 && world.provider.dimensionId == 1) {
							
						world.setBlock(x, y, z, NovaCraftBlocks.echo_cluster_2, 6, 6);
						world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
						heldItem.damageItem(5, player);
						player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
					}
								
				//side		
					else if (world.getBlock(x, y, z) == NovaCraftBlocks.echo_cluster_1 && meta == 3 && world.provider.dimensionId == 1) {
								
							world.setBlock(x, y, z, NovaCraftBlocks.echo_cluster_1, 9, 9);
							world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
							heldItem.damageItem(5, player);
							player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
					}
						
					else if (world.getBlock(x, y, z) == NovaCraftBlocks.echo_cluster_1 && meta == 9 && world.provider.dimensionId == 1) {
							
						world.setBlock(x, y, z, NovaCraftBlocks.echo_cluster_2, 3, 3);
						world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
						heldItem.damageItem(5, player);
						player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
					}
						
					else if (world.getBlock(x, y, z) == NovaCraftBlocks.echo_cluster_2 && meta == 3 && world.provider.dimensionId == 1) {
							
						world.setBlock(x, y, z, NovaCraftBlocks.echo_cluster_2, 9, 9);
						world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
						heldItem.damageItem(5, player);
						player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
					}
					
				//side		
					else if (world.getBlock(x, y, z) == NovaCraftBlocks.echo_cluster_1 && meta == 2 && world.provider.dimensionId == 1) {
								
							world.setBlock(x, y, z, NovaCraftBlocks.echo_cluster_1, 8, 89);
							world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
							heldItem.damageItem(5, player);
							player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
					}
						
					else if (world.getBlock(x, y, z) == NovaCraftBlocks.echo_cluster_1 && meta == 8 && world.provider.dimensionId == 1) {
							
						world.setBlock(x, y, z, NovaCraftBlocks.echo_cluster_2, 2, 2);
						world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
						heldItem.damageItem(5, player);
						player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
					}
						
					else if (world.getBlock(x, y, z) == NovaCraftBlocks.echo_cluster_2 && meta == 2 && world.provider.dimensionId == 1) {
							
						world.setBlock(x, y, z, NovaCraftBlocks.echo_cluster_2, 8, 8);
						world.playSoundEffect(x, y, z, "nova_craft:crystal.shimmer", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
						heldItem.damageItem(5, player);
						player.triggerAchievement(AchievementsNovaCraft.speeding_the_rates);
					}
		
		return true;
		
	}
	
	protected String getShimmerSound() {
        return "nova_craft:crystal.shimmer";
    }

}
