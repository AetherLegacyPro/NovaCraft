package com.NovaCraft.world.nether.structure;

import java.util.Random;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraftBlocks.NovaCraftBlocks;

import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.DungeonHooks;
import static net.minecraftforge.common.ChestGenHooks.DUNGEON_CHEST;;

public class NetherDungeon extends WorldGenerator
{
    public static final WeightedRandomChestContent[] field_111189_a = new WeightedRandomChestContent[] {new WeightedRandomChestContent(Items.saddle, 0, 1, 1, 10), new WeightedRandomChestContent(Items.gold_ingot, 0, 1, 4, 10), new WeightedRandomChestContent(NovaCraftItems.pherithium_lump, 0, 1, 1, 10), new WeightedRandomChestContent(NovaCraftItems.copartz_shard, 0, 1, 4, 10), new WeightedRandomChestContent(NovaCraftItems.vanite_chunk, 0, 1, 4, 10), new WeightedRandomChestContent(NovaCraftItems.larimar_shard, 0, 1, 4, 10), new WeightedRandomChestContent(NovaCraftItems.raw_klangite, 0, 1, 1, 10), new WeightedRandomChestContent(Items.golden_apple, 0, 1, 1, 1), new WeightedRandomChestContent(Items.diamond, 0, 1, 4, 10), new WeightedRandomChestContent(NovaCraftItems.disc_fragment_5, 0, 1, 1, 10), new WeightedRandomChestContent(NovaCraftItems.nullwart, 0, 1, 1, 10), new WeightedRandomChestContent(Items.name_tag, 0, 1, 1, 10), new WeightedRandomChestContent(NovaCraftItems.pherithium_chestplate, 0, 1, 1, 2), new WeightedRandomChestContent(NovaCraftItems.pherithium_pickaxe, 0, 1, 1, 5), new WeightedRandomChestContent(NovaCraftItems.pherithium_shovel, 0, 1, 1, 1)};
    private static final String __OBFID = "CL_00000425";

    @Override
    public boolean generate(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_)
    {
        byte b0 = 3;
        int l = p_76484_2_.nextInt(6) + 4;
        int i1 = p_76484_2_.nextInt(6) + 4;
        int j1 = 0;
        int k1;
        int l1;
        int i2;

        for (k1 = p_76484_3_ - l - 1; k1 <= p_76484_3_ + l + 1; ++k1)
        {
            for (l1 = p_76484_4_ - 1; l1 <= p_76484_4_ + b0 + 1; ++l1)
            {
                for (i2 = p_76484_5_ - i1 - 1; i2 <= p_76484_5_ + i1 + 1; ++i2)
                {
                    Material material = p_76484_1_.getBlock(k1, l1, i2).getMaterial();

                    if (l1 == p_76484_4_ - 1 && !material.isSolid())
                    {
                        return false; //false
                    }

                    if (l1 == p_76484_4_ + b0 + 1 && !material.isSolid())
                    {
                        return false; //false
                    }

                    if ((k1 == p_76484_3_ - l - 1 || k1 == p_76484_3_ + l + 1 || i2 == p_76484_5_ - i1 - 1 || i2 == p_76484_5_ + i1 + 1) && l1 == p_76484_4_ && p_76484_1_.isAirBlock(k1, l1, i2) && p_76484_1_.isAirBlock(k1, l1 + 1, i2))
                    {
                        ++j1;
                    }
                }
            }
        }

        if (j1 >= 1 && j1 <= 5) //5
        {
            for (k1 = p_76484_3_ - l - 1; k1 <= p_76484_3_ + l + 1; ++k1)
            {
                for (l1 = p_76484_4_ + b0; l1 >= p_76484_4_ - 1; --l1)
                {
                    for (i2 = p_76484_5_ - i1 - 1; i2 <= p_76484_5_ + i1 + 1; ++i2)
                    {
                        if (k1 != p_76484_3_ - l - 1 && l1 != p_76484_4_ - 1 && i2 != p_76484_5_ - i1 - 1 && k1 != p_76484_3_ + l + 1 && l1 != p_76484_4_ + b0 + 1 && i2 != p_76484_5_ + i1 + 1)
                        {
                            p_76484_1_.setBlockToAir(k1, l1, i2);
                        }
                        else if (l1 >= 0 && !p_76484_1_.getBlock(k1, l1 - 1, i2).getMaterial().isSolid())
                        {
                            p_76484_1_.setBlockToAir(k1, l1, i2);
                        }
                        else if (p_76484_1_.getBlock(k1, l1, i2).getMaterial().isSolid())
                        {
                            if (l1 == p_76484_4_ - 1 && p_76484_2_.nextInt(4) != 0)
                            {
                                p_76484_1_.setBlock(k1, l1, i2, NovaCraftBlocks.nullstone, 0, 2);
                            }
                            else
                            {
                                p_76484_1_.setBlock(k1, l1, i2, NovaCraftBlocks.cobbled_grimstone, 0, 2);
                            }
                        }
                    }
                }
            }

            k1 = 0;

            while (k1 < 2)
            {
                l1 = 0;

                while (true)
                {
                    if (l1 < 3)
                    {
                        label197:
                        {
                            i2 = p_76484_3_ + p_76484_2_.nextInt(l * 2 + 1) - l;
                            int j2 = p_76484_5_ + p_76484_2_.nextInt(i1 * 2 + 1) - i1;

                            if (p_76484_1_.isAirBlock(i2, p_76484_4_, j2))
                            {
                                int k2 = 0;

                                if (p_76484_1_.getBlock(i2 - 1, p_76484_4_, j2).getMaterial().isSolid())
                                {
                                    ++k2;
                                }

                                if (p_76484_1_.getBlock(i2 + 1, p_76484_4_, j2).getMaterial().isSolid())
                                {
                                    ++k2;
                                }

                                if (p_76484_1_.getBlock(i2, p_76484_4_, j2 - 1).getMaterial().isSolid())
                                {
                                    ++k2;
                                }

                                if (p_76484_1_.getBlock(i2, p_76484_4_, j2 + 1).getMaterial().isSolid())
                                {
                                    ++k2;
                                }

                                if (k2 == 1)
                                {
                                    p_76484_1_.setBlock(i2, p_76484_4_, j2, Blocks.chest, 0, 2);
                                    TileEntityChest tileentitychest = (TileEntityChest)p_76484_1_.getTileEntity(i2, p_76484_4_, j2);

                                    if (tileentitychest != null)
                                    {
                                        WeightedRandomChestContent.generateChestContents(p_76484_2_, ChestGenHooks.getItems(DUNGEON_CHEST, p_76484_2_), tileentitychest, ChestGenHooks.getCount(DUNGEON_CHEST, p_76484_2_));
                                        
                                        //tileentitychest.setInventorySlotContents(p_76484_2_.nextInt(tileentitychest.getSizeInventory()), this.getNormalLoot(p_76484_2_));
                                    }

                                    break label197;
                                }
                            }
                            
                            if (p_76484_1_.isAirBlock(i2, p_76484_4_, j2))
                            {
                                int k2 = 1;

                                if (p_76484_1_.getBlock(i2 - 1, p_76484_4_, j2).getMaterial().isSolid())
                                {
                                    ++k2;
                                }

                                if (p_76484_1_.getBlock(i2 + 1, p_76484_4_, j2).getMaterial().isSolid())
                                {
                                    ++k2;
                                }

                                if (p_76484_1_.getBlock(i2, p_76484_4_, j2 - 1).getMaterial().isSolid())
                                {
                                    ++k2;
                                }

                                if (p_76484_1_.getBlock(i2, p_76484_4_, j2 + 1).getMaterial().isSolid())
                                {
                                    ++k2;
                                }

                                if (k2 == 1)
                                {
                                    p_76484_1_.setBlock(i2, p_76484_4_, j2, Blocks.chest, 0, 2);
                                    TileEntityChest tileentitychest = (TileEntityChest)p_76484_1_.getTileEntity(i2, p_76484_4_, j2);

                                    if (tileentitychest != null)
                                    {
                                        WeightedRandomChestContent.generateChestContents(p_76484_2_, ChestGenHooks.getItems(DUNGEON_CHEST, p_76484_2_), tileentitychest, ChestGenHooks.getCount(DUNGEON_CHEST, p_76484_2_));
                                        
                                        ///tileentitychest.setInventorySlotContents(p_76484_2_.nextInt(tileentitychest.getSizeInventory()), this.getNormalLoot(p_76484_2_));
                                    }

                                    break label197;
                                }
                            }

                            ++l1;
                            continue;
                        }
                    }

                    ++k1;
                    break;
                }
            }
            p_76484_1_.setBlock(p_76484_3_, p_76484_4_ + 1, p_76484_5_, Blocks.obsidian, 0, 2);
            p_76484_1_.setBlock(p_76484_3_, p_76484_4_, p_76484_5_ + 1, Blocks.obsidian, 0, 2);
            p_76484_1_.setBlock(p_76484_3_, p_76484_4_, p_76484_5_ - 1, Blocks.obsidian, 0, 2);
            p_76484_1_.setBlock(p_76484_3_ + 1, p_76484_4_, p_76484_5_, Blocks.obsidian, 0, 2);
            p_76484_1_.setBlock(p_76484_3_ - 1, p_76484_4_, p_76484_5_, Blocks.obsidian, 0, 2);
            
            p_76484_1_.setBlock(p_76484_3_ - 1, p_76484_4_, p_76484_5_ + 5, NovaCraftBlocks.treasure_chest, 0, 2);
            p_76484_1_.setBlock(p_76484_3_ - 4, p_76484_4_, p_76484_5_ + 1, NovaCraftBlocks.treasure_chest, 0, 2);
            
            p_76484_1_.setBlock(p_76484_3_ + 3, p_76484_4_ - 1, p_76484_5_ + 3, NovaCraftBlocks.nullstone, 0, 2);
            p_76484_1_.setBlock(p_76484_3_ + 3, p_76484_4_, p_76484_5_ + 3, NovaCraftBlocks.null_wart, 0, 2);
            
            p_76484_1_.setBlock(p_76484_3_ - 3, p_76484_4_ - 1, p_76484_5_ - 3, NovaCraftBlocks.nullstone, 0, 2);
            p_76484_1_.setBlock(p_76484_3_ - 3, p_76484_4_, p_76484_5_ - 3, NovaCraftBlocks.null_wart, 0, 2);
            
            p_76484_1_.setBlock(p_76484_3_, p_76484_4_, p_76484_5_, Blocks.mob_spawner, 0, 2);
            TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner)p_76484_1_.getTileEntity(p_76484_3_, p_76484_4_, p_76484_5_);

            if (tileentitymobspawner != null)
            {
            	tileentitymobspawner.func_145881_a().setEntityName("nova_craft.sculk_dweller");
            }
            
            p_76484_1_.setBlock(p_76484_3_, p_76484_4_, p_76484_5_ + 2, Blocks.mob_spawner, 0, 2);
            TileEntityMobSpawner tileentitymobspawner2 = (TileEntityMobSpawner)p_76484_1_.getTileEntity(p_76484_3_, p_76484_4_, p_76484_5_ + 2);

            if (tileentitymobspawner2 != null)
            {
            	tileentitymobspawner2.func_145881_a().setEntityName("nova_craft.sculk_symbiote");
            }
            
            p_76484_1_.setBlock(p_76484_3_, p_76484_4_, p_76484_5_ - 2, Blocks.mob_spawner, 0, 2);
            TileEntityMobSpawner tileentitymobspawner3 = (TileEntityMobSpawner)p_76484_1_.getTileEntity(p_76484_3_, p_76484_4_, p_76484_5_ - 2);

            if (tileentitymobspawner3 != null)
            {
            	tileentitymobspawner3.func_145881_a().setEntityName("nova_craft.sculk_abomination");
            }
            
            else
            {
                System.err.println("Failed to fetch mob spawner entity at (" + p_76484_3_ + ", " + p_76484_4_ + ", " + p_76484_5_ + ")");
            }

            return true;
        }
        else
        {
            return false;
        }
    }
    
    private ItemStack getNormalLoot(Random random) {
		int item = random.nextInt(15);
		switch (item) {
			case 0:
				return new ItemStack(Items.iron_ingot);
			case 1:
				return new ItemStack(Items.experience_bottle, random.nextInt(4) + 1);
			case 2:
				return new ItemStack(Items.gold_ingot, random.nextInt(6) + 1);
			case 3:
				return new ItemStack(NovaCraftItems.pherithium_scraps, random.nextInt(6) + 1);
			case 4:
				return new ItemStack(NovaCraftItems.vanite_chunk, random.nextInt(7) + 1);
			case 5:
				return new ItemStack(NovaCraftBlocks.sculk_vein, random.nextInt(8) + 1);
			case 6: {
				if (random.nextInt(20) == 0) {
					return new ItemStack(Items.diamond, random.nextInt(3) + 2);
				}

				break;
			}
			case 7:
				return new ItemStack(NovaCraftItems.brimstone_dust, random.nextInt(3) + 1);
			case 8: {
				if (random.nextInt(10) == 0) {
					return new ItemStack(NovaCraftBlocks.sculk_bricks, random.nextInt(20) + 1);
				}

				break;
			}
			case 9: {
				if (random.nextInt(10) == 0) {
					return new ItemStack(NovaCraftItems.copartz_shard);
				}
				break;
			}
			case 10: {
				if (random.nextInt(5) == 0) {
					return new ItemStack(NovaCraftItems.pherithium_pickaxe);
				}
				break;
			}
		}
		return new ItemStack(NovaCraftBlocks.sculk_block, random.nextInt(2) + 2);
	}

    /**
     * Randomly decides which spawner to use in a dungeon
     */
    private String pickMobSpawner(Random p_76543_1_)
    {
        return DungeonHooks.getRandomDungeonMob(p_76543_1_);
    }
}

