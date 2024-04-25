package com.NovaCraft.world.structure;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import java.util.Random;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.entity.EntitySculkedMonitor;
import com.NovaCraft.registry.OtherModBlocks;
import com.NovaCraftBlocks.NovaCraftBlocks;

import net.minecraft.world.World;
import net.minecraft.init.Blocks;
import net.minecraft.block.Block;
import net.minecraft.world.gen.feature.WorldGenerator;

public class SculkDwelling extends WorldGenerator
{
    protected Block[] GetValidSpawnBlocks() {
        return new Block[] { (Block)Blocks.grass, (Block)Blocks.dirt, (Block)Blocks.stone };
    }
    
    public boolean LocationIsValidSpawn(final World world, final int i, int j, final int k) {
        int distanceToAir = 0;
        for (Block checkID = world.getBlock(i, j, k); checkID != Blocks.air; checkID = world.getBlock(i, j + distanceToAir, k)) {
            ++distanceToAir;
        }
        if (distanceToAir > 3) {
            return false;
        }
        j += distanceToAir - 1;
        final Block blockID = world.getBlock(i, j, k);
        final Block blockIDAbove = world.getBlock(i, j + 1, k);
        final Block blockIDBelow = world.getBlock(i, j - 1, k);
        for (final Block x : this.GetValidSpawnBlocks()) {
            if (blockIDAbove != Blocks.air) {
                return false;
            }
            if (blockID == x) {
                return true;
            }
            if (blockID == Blocks.snow && blockIDBelow == x) {
                return true;
            }
        }
        return false;
    }
    
    public boolean generate(final World world, final Random rand, final int i, final int j, final int k) {
        if (!this.LocationIsValidSpawn(world, i, j, k) || !this.LocationIsValidSpawn(world, i + 8, j, k) || !this.LocationIsValidSpawn(world, i + 8, j, k + 4) || !this.LocationIsValidSpawn(world, i, j, k + 4)) {
            return false;
        }
        for (int j2 = -15; j2 < 1; ++j2) {
            for (int i2 = 0; i2 < 5; ++i2) {
                for (int k2 = 0; k2 < 5; ++k2) {
                    final int h = rand.nextInt(5);
                    if (h >= 0 || h <= 2) {
                        world.setBlock(i + i2, j + j2, k + k2, NovaCraftBlocks.sculk_bricks);
                    }
                    if (h == 3) {
                        world.setBlock(i + i2, j + j2, k + k2, NovaCraftBlocks.sculk_block);
                    }
                    if (h == 4) {
                        world.setBlock(i + i2, j + j2, k + k2, NovaCraftBlocks.nullstone_bricks);
                    }
                }
            }
        }
        for (int j3 = -12; j3 < 0; ++j3) {
            for (int i3 = 1; i3 < 4; ++i3) {
                for (int k3 = 1; k3 < 4; ++k3) {
                    world.setBlock(i + i3, j + j3, k + k3, Blocks.air);
                }
            }
        }
        for (int j4 = -15; j4 < -8; ++j4) {
            for (int i4 = 13; i4 < 25; ++i4) {
                for (int k4 = -4; k4 < 32; ++k4) {
                    final int h = rand.nextInt(5);
                    if (h >= 0 || h <= 2) {
                        world.setBlock(i + i4, j + j4, k + k4, NovaCraftBlocks.sculk_bricks);
                    }
                    if (h == 3) {
                        world.setBlock(i + i4, j + j4, k + k4, NovaCraftBlocks.sculk_block);
                    }
                    if (h == 4) {
                        world.setBlock(i + i4, j + j4, k + k4, NovaCraftBlocks.nullstone_bricks);
                    }
                }
            }
        }
        for (int j5 = -15; j5 < -8; ++j5) {
            for (int i5 = 0; i5 < 23; ++i5) {
                for (int k5 = -4; k5 < 9; ++k5) {
                    final int h = rand.nextInt(5);
                    if (h >= 0 || h <= 2) {
                        world.setBlock(i + i5, j + j5, k + k5, NovaCraftBlocks.sculk_bricks);
                    }
                    if (h == 3) {
                        world.setBlock(i + i5, j + j5, k + k5, NovaCraftBlocks.sculk_block);
                    }
                    if (h == 4) {
                        world.setBlock(i + i5, j + j5, k + k5, NovaCraftBlocks.nullstone_bricks);
                    }
                }
            }
        }
        world.setBlock(i + 0, j + 1, k + 2, NovaCraftBlocks.sculk_bricks);
        world.setBlock(i + 1, j + 0, k + 2, Blocks.air);
        world.setBlock(i + 1, j - 10, k + 1, Blocks.air);
        world.setBlock(i + 3, j - 10, k + 2, Blocks.air);
        world.setBlock(i + 1, j - 10, k + 3, Blocks.air);
        world.setBlock(i + 2, j - 10, k + 1, Blocks.air);
        world.setBlock(i + 2, j - 10, k + 2, Blocks.air);
        world.setBlock(i + 2, j - 10, k + 3, Blocks.air);
        world.setBlock(i + 3, j - 10, k + 1, Blocks.air);
        world.setBlock(i + 3, j - 10, k + 3, Blocks.air);
        world.setBlock(i + 1, j - 9, k + 1, Blocks.air);
        world.setBlock(i + 3, j - 9, k + 2, Blocks.air);
        world.setBlock(i + 1, j - 9, k + 3, Blocks.air);
        world.setBlock(i + 2, j - 9, k + 1, Blocks.air);
        world.setBlock(i + 2, j - 9, k + 2, Blocks.air);
        world.setBlock(i + 2, j - 9, k + 3, Blocks.air);
        world.setBlock(i + 3, j - 9, k + 1, Blocks.air);
        world.setBlock(i + 3, j - 9, k + 3, Blocks.air);
        world.setBlock(i + 2, j - 14, k - 0, Blocks.air);
        world.setBlock(i + 2, j - 14, k - 0, Blocks.water);
        world.setBlock(i + 2, j - 14, k - 1, Blocks.air);
        world.setBlock(i + 2, j - 14, k - 1, Blocks.water);
        world.setBlock(i + 2, j - 13, k - 2, Blocks.air);
        world.setBlock(i + 2, j - 13, k - 2, Blocks.water);
        world.setBlock(i + 2, j - 13, k - 3, Blocks.air);
        world.setBlock(i + 2, j - 13, k - 3, Blocks.iron_bars);
        world.setBlock(i + 2, j - 13, k - 4, Blocks.air);
        world.setBlock(i + 2, j - 13, k - 4, (Block)Blocks.chest);
        final TileEntityChest tileentitychest = new TileEntityChest();
        world.setTileEntity(i + 2, j - 13, k - 4, (TileEntity)tileentitychest);
        for (int p1 = 0; p1 < 6; ++p1) {
            final ItemStack itemstack2 = this.pickCheckLootItem(rand);
            if (itemstack2 != null) {
                tileentitychest.setInventorySlotContents(rand.nextInt(tileentitychest.getSizeInventory()), itemstack2);
            }
        }
        world.setBlock(i + 19, j - 14, k - 0, Blocks.air);
        world.setBlock(i + 19, j - 14, k - 0, Blocks.water);
        world.setBlock(i + 19, j - 14, k - 1, Blocks.air);
        world.setBlock(i + 19, j - 14, k - 1, Blocks.water);
        world.setBlock(i + 19, j - 13, k - 2, Blocks.air);
        world.setBlock(i + 19, j - 13, k - 2, Blocks.water);
        world.setBlock(i + 19, j - 13, k - 3, Blocks.air);
        world.setBlock(i + 19, j - 13, k - 3, Blocks.iron_bars);
        world.setBlock(i + 19, j - 13, k - 4, Blocks.air);
        for (int j6 = -15; j6 < -8; ++j6) {
            for (int i6 = 8; i6 < 15; ++i6) {
                for (int k6 = -8; k6 < 0; ++k6) {
                    final int h2 = rand.nextInt(5);
                    if (h2 >= 0 || h2 <= 2) {
                        world.setBlock(i + i6, j + j6, k + k6, NovaCraftBlocks.sculk_bricks);
                    }
                    if (h2 == 3) {
                        world.setBlock(i + i6, j + j6, k + k6, NovaCraftBlocks.sculk_block);
                    }
                    if (h2 == 4) {
                        world.setBlock(i + i6, j + j6, k + k6, NovaCraftBlocks.nullstone_bricks);
                    }
                }
            }
        }
        for (int j6 = -13; j6 < -10; ++j6) {
            for (int i6 = 10; i6 < 13; ++i6) {
                for (int k6 = -5; k6 < -2; ++k6) {
                    world.setBlock(i + i6, j + j6, k + k6, Blocks.air);
                }
            }
        }
        //world.setBlock(i + 10, j - 11, k - 2, Blocks.iron_bars);
        //world.setBlock(i + 11, j - 11, k - 2, Blocks.iron_bars);
        //world.setBlock(i + 12, j - 11, k - 2, Blocks.iron_bars);
        //world.setBlock(i + 10, j - 12, k - 2, Blocks.iron_bars);
        //world.setBlock(i + 11, j - 12, k - 2, Blocks.iron_bars);
        //world.setBlock(i + 12, j - 12, k - 2, Blocks.iron_bars);
        //world.setBlock(i + 10, j - 13, k - 2, Blocks.iron_bars);
        //world.setBlock(i + 11, j - 13, k - 2, Blocks.iron_bars);
        //world.setBlock(i + 12, j - 13, k - 2, Blocks.iron_bars);
        world.setBlock(i + 11, j - 14, k - 0, Blocks.air);
        world.setBlock(i + 11, j - 14, k - 0, Blocks.water);
        world.setBlock(i + 11, j - 14, k - 1, Blocks.air);
        world.setBlock(i + 11, j - 14, k - 1, Blocks.water);
        world.setBlock(i + 11, j - 14, k - 2, Blocks.air);
        world.setBlock(i + 11, j - 14, k - 2, Blocks.water);
        world.setBlock(i + 11, j - 14, k - 3, Blocks.air);
        world.setBlock(i + 11, j - 14, k - 3, Blocks.water);
        world.setBlock(i + 11, j - 14, k - 4, Blocks.air);
        world.setBlock(i + 11, j - 14, k - 4, Blocks.water);
        world.setBlock(i + 11, j - 14, k - 5, Blocks.air);
        world.setBlock(i + 11, j - 14, k - 5, Blocks.water);
        world.setBlock(i + 11, j - 12, k - 6, Blocks.air);
        world.setBlock(i + 11, j - 12, k - 6, Blocks.water);
        world.setBlock(i + 11, j - 12, k - 7, Blocks.air);
        //world.setBlock(i + 11, j - 12, k - 7, Blocks.iron_bars);
        
        world.setBlock(i + 14, j - 12, k - 3, Blocks.mob_spawner, 0, 2);
        TileEntityMobSpawner tileentitymobspawner2 = (TileEntityMobSpawner)world.getTileEntity(i + 14, j - 12, k - 3);

        if (tileentitymobspawner2 != null)
        {
        	tileentitymobspawner2.func_145881_a().setEntityName("nova_craft.sculk_symbiote");
        }
        
        
        world.setBlock(i + 8, j - 12, k - 3, Blocks.mob_spawner, 0, 2);
        TileEntityMobSpawner tileentitymobspawner3 = (TileEntityMobSpawner)world.getTileEntity(i + 8, j - 12, k - 3);

        if (tileentitymobspawner3 != null)
        {
        	tileentitymobspawner3.func_145881_a().setEntityName("nova_craft.sculk_hunger");
        }
        
        world.setBlock(i + 19, j - 13, k - 4, (Block)Blocks.chest);
        final TileEntityChest tileentitychest2 = new TileEntityChest();
        world.setTileEntity(i + 19, j - 13, k - 4, (TileEntity)tileentitychest2);
        for (int p2 = 0; p2 < 6; ++p2) {
            final ItemStack itemstack3 = this.pickCheckLootItem(rand);
            if (itemstack3 != null) {
                tileentitychest2.setInventorySlotContents(rand.nextInt(tileentitychest.getSizeInventory()), itemstack3);
            }
        }
        for (int i7 = 16; i7 < 23; ++i7) {
            for (int k7 = 23; k7 < 30; ++k7) {
                world.setBlock(i + i7, j - 10, k + k7, Blocks.air);
            }
        }
        for (int j7 = -20; j7 < -10; ++j7) {
            for (int i8 = 21; i8 < 28; ++i8) {
                for (int k8 = -3; k8 < 8; ++k8) {
                    final int h3 = rand.nextInt(5);
                    if (h3 >= 0 || h3 <= 2) {
                        world.setBlock(i + i8, j + j7, k + k8, NovaCraftBlocks.sculk_bricks);
                    }
                    if (h3 == 3) {
                        world.setBlock(i + i8, j + j7, k + k8, NovaCraftBlocks.sculk_block);
                    }
                    if (h3 == 4) {
                        world.setBlock(i + i8, j + j7, k + k8, NovaCraftBlocks.nullstone_bricks);
                    }
                }
            }
        }
        for (int j7 = -20; j7 < -13; ++j7) {
            for (int i8 = 23; i8 < 46; ++i8) {
                for (int k8 = -4; k8 < 9; ++k8) {
                    final int h3 = rand.nextInt(5);
                    if (h3 >= 0 || h3 <= 2) {
                        world.setBlock(i + i8, j + j7, k + k8, NovaCraftBlocks.sculk_bricks);
                    }
                    if (h3 == 3) {
                        world.setBlock(i + i8, j + j7, k + k8, NovaCraftBlocks.sculk_block);
                    }
                    if (h3 == 4) {
                        world.setBlock(i + i8, j + j7, k + k8, NovaCraftBlocks.nullstone_bricks);
                    }
                }
            }
        }
        for (int j8 = -14; j8 < -13; ++j8) {
            for (int i9 = 2; i9 < 25; ++i9) {
                for (int k9 = 1; k9 < 4; ++k9) {
                    world.setBlock(i + i9, j + j8, k + k9, Blocks.air);
                    world.setBlock(i + i9, j + j8, k + k9, NovaCraftBlocks.sculk_block);
                }
            }
        }       
        for (int j8 = -14; j8 < -13; ++j8) {
            for (int i9 = 2; i9 < 25; ++i9) {
                for (int k9 = 2; k9 < 3; ++k9) {
                    world.setBlock(i + i9, j + j8, k + k9, Blocks.water);
                }
            }
        }
        for (int j9 = -14; j9 < -13; ++j9) {
            for (int i10 = 18; i10 < 21; ++i10) {
                for (int k10 = 1; k10 < 21; ++k10) {
                    world.setBlock(i + i10, j + j9, k + k10, Blocks.air);
                    world.setBlock(i + i10, j + j9, k + k10, NovaCraftBlocks.sculk_block);
                }
            }
        }       
        for (int j9 = -14; j9 < -13; ++j9) {
            for (int i10 = 19; i10 < 20; ++i10) {
                for (int k10 = 1; k10 < 21; ++k10) {
                    world.setBlock(i + i10, j + j9, k + k10, Blocks.water);
                }
            }
        }      
        for (int j8 = -19; j8 < -18; ++j8) {
            for (int i9 = 23; i9 < 46; ++i9) {
                for (int k9 = 1; k9 < 4; ++k9) {
                    world.setBlock(i + i9, j + j8, k + k9, Blocks.air);
                    world.setBlock(i + i9, j + j8, k + k9, NovaCraftBlocks.sculk_block);
                }
            }
        }
        for (int j8 = -19; j8 < -18; ++j8) {
            for (int i9 = 23; i9 < 46; ++i9) {
                for (int k9 = 2; k9 < 3; ++k9) {
                    world.setBlock(i + i9, j + j8, k + k9, Blocks.water);
                }
            }
        }
        for (int j10 = -13; j10 < -10; ++j10) {
            for (int i11 = 1; i11 < 23; ++i11) {
                for (int k11 = -1; k11 < 6; ++k11) {
                    world.setBlock(i + i11, j + j10, k + k11, Blocks.air);
                }
            }
        }
        for (int j11 = -13; j11 < -10; ++j11) {
            for (int i12 = 16; i12 < 23; ++i12) {
                for (int k12 = -1; k12 < 30; ++k12) {
                    world.setBlock(i + i12, j + j11, k + k12, Blocks.air);
                }
            }
        }
        for (int j10 = -18; j10 < -15; ++j10) {
            for (int i11 = 23; i11 < 46; ++i11) {
                for (int k11 = -1; k11 < 6; ++k11) {
                    world.setBlock(i + i11, j + j10, k + k11, Blocks.air);
                }
            }
        }
        for (int j11 = -18; j11 < -10; ++j11) {
            for (int i12 = 23; i12 < 26; ++i12) {
                for (int k12 = -1; k12 < 6; ++k12) {
                    world.setBlock(i + i12, j + j11, k + k12, Blocks.air);
                }
            }
        }
        for (int j8 = -13; j8 < 1; ++j8) {
            world.setBlock(i + 1, j + j8, k + 2, Blocks.ladder);
            world.setBlockMetadataWithNotify(i + 1, j + j8, k + 2, 5, 2);
        }
        
        world.setBlock(i + 16, j - 13, k + 22, NovaCraftBlocks.sculk_block);
        world.setBlock(i + 16, j - 12, k + 22, NovaCraftBlocks.sculk_bricks);
        world.setBlock(i + 16, j - 11, k + 22, NovaCraftBlocks.sculk_bricks);
        world.setBlock(i + 17, j - 13, k + 22, NovaCraftBlocks.sculk_bricks);
        world.setBlock(i + 17, j - 12, k + 22, NovaCraftBlocks.sculk_bricks);
        world.setBlock(i + 17, j - 11, k + 22, NovaCraftBlocks.sculk_block);
        //world.setBlock(i + 18, j - 11, k + 22, Blocks.iron_bars);
        //world.setBlock(i + 18, j - 12, k + 22, Blocks.iron_bars);
        //world.setBlock(i + 18, j - 13, k + 22, Blocks.iron_bars);
        //world.setBlock(i + 19, j - 11, k + 22, Blocks.iron_bars);
        //world.setBlock(i + 19, j - 12, k + 22, Blocks.iron_bars);
        //world.setBlock(i + 19, j - 13, k + 22, Blocks.iron_bars);
        //world.setBlock(i + 20, j - 11, k + 22, Blocks.iron_bars);
        //world.setBlock(i + 20, j - 12, k + 22, Blocks.iron_bars);
        //world.setBlock(i + 20, j - 13, k + 22, Blocks.iron_bars);
        world.setBlock(i + 21, j - 13, k + 22, NovaCraftBlocks.sculk_bricks);
        world.setBlock(i + 21, j - 12, k + 22, NovaCraftBlocks.sculk_bricks);
        world.setBlock(i + 21, j - 11, k + 22, NovaCraftBlocks.sculk_block);
        world.setBlock(i + 22, j - 13, k + 22, NovaCraftBlocks.sculk_bricks);
        world.setBlock(i + 22, j - 12, k + 22, NovaCraftBlocks.sculk_bricks);
        world.setBlock(i + 22, j - 11, k + 22, NovaCraftBlocks.nullstone_bricks);
        
        world.setBlock(i + 18, j - 14, k + 2, Blocks.water);
        world.setBlock(i + 20, j - 14, k + 2, Blocks.water);
        
        world.setBlock(i + 45, j - 19, k + 2, NovaCraftBlocks.nullstone_bricks);
        world.setBlock(i + 45, j - 18, k + 2, NovaCraftBlocks.block_of_vanite);
        world.setBlock(i + 45, j - 17, k + 2, NovaCraftBlocks.treasure_chest);
        
        world.setBlock(i + 45, j - 14, k + 2, Blocks.mob_spawner, 0, 2);
        TileEntityMobSpawner tileentitymobspawner1 = (TileEntityMobSpawner)world.getTileEntity(i + 45, j - 14, k + 2);

        if (tileentitymobspawner1 != null)
        {
        	tileentitymobspawner1.func_145881_a().setEntityName("nova_craft.sculk_dweller");
        }
        
        world.setBlock(i + 44, j - 18, k + 3, NovaCraftBlocks.sculk_bush);
        world.setBlock(i + 44, j - 18, k + 1, NovaCraftBlocks.sculk_bush);
        
        world.setBlock(i + 1, j, k + 2, NovaCraftBlocks.vanite_glass);
        
        if (!world.isRemote) {
            final EntitySculkedMonitor monitor = new EntitySculkedMonitor(world);
            monitor.setLocationAndAngles((double)(i + 17), (double)(j - 12), (double)(k + 24), 0.0f, 0.0f);
            world.spawnEntityInWorld((Entity)monitor);
            
            int rand2 = (int)(1 + Math.random() * 4);
    		switch (rand2)
            {
            case 1: 
            	 final EntitySculkedMonitor monitor2 = new EntitySculkedMonitor(world);
                 monitor2.setLocationAndAngles((double)(i + 17), (double)(j - 12), (double)(k + 24), 0.0f, 0.0f);
                 world.spawnEntityInWorld((Entity)monitor2);
                 break;
            case 2:
            	final EntitySculkedMonitor monitor3 = new EntitySculkedMonitor(world);
            	monitor3.setLocationAndAngles((double)(i + 21), (double)(j - 12), (double)(k + 24), 0.0f, 0.0f);
                world.spawnEntityInWorld((Entity)monitor3);
                final EntitySculkedMonitor monitor4 = new EntitySculkedMonitor(world);
                monitor4.setLocationAndAngles((double)(i + 17), (double)(j - 12), (double)(k + 26), 0.0f, 0.0f);
                world.spawnEntityInWorld((Entity)monitor4);
                final EntitySculkedMonitor monitor5 = new EntitySculkedMonitor(world);
                monitor5.setLocationAndAngles((double)(i + 21), (double)(j - 12), (double)(k + 26), 0.0f, 0.0f);
                world.spawnEntityInWorld((Entity)monitor5);
                break;
            case 3:
            	final EntitySculkedMonitor monitor6 = new EntitySculkedMonitor(world);
            	monitor6.setLocationAndAngles((double)(i + 21), (double)(j - 12), (double)(k + 24), 0.0f, 0.0f);
                world.spawnEntityInWorld((Entity)monitor6);
                final EntitySculkedMonitor monitor7 = new EntitySculkedMonitor(world);
                monitor7.setLocationAndAngles((double)(i + 17), (double)(j - 12), (double)(k + 26), 0.0f, 0.0f);
                world.spawnEntityInWorld((Entity)monitor7);
                break;
            case 4:
            	break;
            }
        }
        
        return true;
    }
    
    private ItemStack pickCheckLootItem(final Random random) {
        final int i = random.nextInt(21);
        if (i == 0) {
            return new ItemStack(NovaCraftItems.sculked_leather, random.nextInt(2) + 1);
        }
        if (i == 1) {
            return new ItemStack(NovaCraftItems.goat_horn_feel, 1);
        }
        if (i == 2) {
        	return new ItemStack(Items.feather, random.nextInt(4) + 1);
        }
        if (i == 3) {
        	return new ItemStack(Items.gold_ingot, random.nextInt(4) + 1);
        }
        if (i == 4) {
            return new ItemStack(Items.bone, random.nextInt(12) + 3);
        }
        if (i == 5) {
            return new ItemStack(NovaCraftBlocks.sculk_block, random.nextInt(4) + 1);
        }
        if (i == 6) {
            return new ItemStack(Items.experience_bottle, random.nextInt(20) + 1);
        }
        if (i == 7 && random.nextInt(5) == 0) {
            return new ItemStack(Items.name_tag, 1);
        }
        if (i == 8) {
            return new ItemStack(Items.gold_ingot, random.nextInt(4) + 1);
        }
        if (i == 9 && random.nextInt(10) == 0) {
            return new ItemStack(NovaCraftItems.disc_fragment_5, 1);
        }
        if (i == 10) {
            return new ItemStack(Items.iron_ingot, random.nextInt(4) + 1);
        }
        if (i == 11 && random.nextInt(20) == 0) {
            return new ItemStack(NovaCraftItems.sculk_boots, 1);
        }
        if (i == 12 && random.nextInt(20) == 0) {
            return new ItemStack(NovaCraftItems.sculk_leggings, 1);
        }
        if (i == 13 && random.nextInt(20) == 0) {
            return new ItemStack(NovaCraftItems.sculk_chestplate, 1);
        }
        if (i == 14 && random.nextInt(20) == 0) {
            return new ItemStack(NovaCraftItems.sculk_helmet, 1);
        }
        if (i == 15) {
            return new ItemStack(NovaCraftItems.vanite_chunk, random.nextInt(4) + 1);
        }
        if (i == 16 && random.nextInt(10) == 0) {
            return new ItemStack(NovaCraftBlocks.sculk_bush, random.nextInt(1) + 1);
        }
        if (i == 17 && random.nextInt(10) == 0) {
            return new ItemStack(NovaCraftBlocks.sculk_vein, random.nextInt(4) + 1);
        }
        if (i == 18) {
            return new ItemStack(Items.arrow, random.nextInt(8)+ 8);
        }
        if (i == 19) {
            return new ItemStack(Items.golden_apple, 1);
        }
        if (i == 20) {
            return new ItemStack(Items.slime_ball, 4);
        }
        return null;
    }
}
