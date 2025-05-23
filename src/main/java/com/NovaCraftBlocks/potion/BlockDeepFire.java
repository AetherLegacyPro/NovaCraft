package com.NovaCraftBlocks.potion;

import net.minecraft.client.renderer.texture.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.client.particle.*;
import net.minecraft.init.*;
import net.minecraftforge.common.util.*;
import java.util.*;

import com.NovaCraft.entity.EntityDeepoid;
import com.NovaCraft.entity.EntityIonizatior;
import com.NovaCraft.particles.ParticleHandler;
import com.NovaCraftBlocks.NovaCraftBlocks;

import net.minecraft.block.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.world.*;

public class BlockDeepFire extends BlockFire
{
    private IIcon[] field_149850_M;
    
    public BlockDeepFire() {
        this.setLightLevel(1.0f);
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.015625f, 1.0f);
    }
    
    public AxisAlignedBB getCollisionBoundingBoxFromPool(final World p_149668_1_, final int p_149668_2_, final int p_149668_3_, final int p_149668_4_) {
        return null;
    }
    
    public boolean isCollidable() {
        return true;
    }
    
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(final IIconRegister p_149651_1_) {
    	this.field_149850_M = new IIcon[] { p_149651_1_.registerIcon("nova_craft:deepfire_0"), p_149651_1_.registerIcon("nova_craft:deepfire_1") };
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(final int i1, final int i2) {
        return this.field_149850_M[0];
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon getFireIcon(final int i1) {
        return this.field_149850_M[i1];
    }
    
    @SideOnly(Side.CLIENT)
    public boolean addDestroyEffects(final World world, final int x, final int y, final int z, final int meta, final EffectRenderer effectRenderer) {
        return true;
    }
    
    private boolean canNeighborBurn(final World world, final int x, final int y, final int z) {
        return Blocks.fire.canCatchFire((IBlockAccess)world, x + 1, y, z, ForgeDirection.WEST) || Blocks.fire.canCatchFire((IBlockAccess)world, x - 1, y, z, ForgeDirection.EAST) || Blocks.fire.canCatchFire((IBlockAccess)world, x, y - 1, z, ForgeDirection.UP) || Blocks.fire.canCatchFire((IBlockAccess)world, x, y + 1, z, ForgeDirection.DOWN) || Blocks.fire.canCatchFire((IBlockAccess)world, x, y, z - 1, ForgeDirection.SOUTH) || Blocks.fire.canCatchFire((IBlockAccess)world, x, y, z + 1, ForgeDirection.NORTH);
    }
    
    private void tryCatchFire(final World world, final int x, final int y, final int z, final int i1, final Random rand, final int i2, final ForgeDirection face) {
        final int j1 = world.getBlock(x, y, z).getFlammability((IBlockAccess)world, x, y, z, face);
        if (rand.nextInt(i1) < j1) {
            final boolean flag = world.getBlock(x, y, z) == Blocks.tnt;
            int k1 = i2 + rand.nextInt(5) / 4;
            if (k1 > 15) {
                k1 = 15;
            }
            world.setBlock(x, y, z, (Block)Blocks.fire, k1, 3);
            if (flag) {
                Blocks.tnt.onBlockDestroyedByPlayer(world, x, y, z, 1);
            }
        }
    }
    
    public ItemStack getPickBlock(final MovingObjectPosition target, final World world, final int x, final int y, final int z, final EntityPlayer player) {
        return null;
    }
    
    @Override
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
		if (!(entity instanceof EntityIonizatior)) {
			
			{
				if (!entity.isImmuneToFire()) {
				entity.attackEntityFrom(DamageSource.magic, 2.0F);
				entity.attackEntityFrom(DamageSource.lava, 2.0F);
				entity.setFire(30);
				}
				else {
				entity.attackEntityFrom(DamageSource.magic, 2.0F);
				entity.attackEntityFrom(DamageSource.generic, 2.0F);
				entity.setFire(30);	
				}
			}
		
		}				
	}
    
    private int getChanceOfNeighborsEncouragingFire(final World world, final int x, final int y, final int z) {
        final byte b0 = 0;
        if (!world.isAirBlock(x, y, z)) {
            return 0;
        }
        int l = b0;
        l = this.getChanceToEncourageFire((IBlockAccess)world, x + 1, y, z, l, ForgeDirection.WEST);
        l = this.getChanceToEncourageFire((IBlockAccess)world, x - 1, y, z, l, ForgeDirection.EAST);
        l = this.getChanceToEncourageFire((IBlockAccess)world, x, y - 1, z, l, ForgeDirection.UP);
        l = this.getChanceToEncourageFire((IBlockAccess)world, x, y + 1, z, l, ForgeDirection.DOWN);
        l = this.getChanceToEncourageFire((IBlockAccess)world, x, y, z - 1, l, ForgeDirection.SOUTH);
        l = this.getChanceToEncourageFire((IBlockAccess)world, x, y, z + 1, l, ForgeDirection.NORTH);
        return l;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(final World p_149734_1_, final int p_149734_2_, final int p_149734_3_, final int p_149734_4_, final Random p_149734_5_) {
        super.randomDisplayTick(p_149734_1_, p_149734_2_, p_149734_3_, p_149734_4_, p_149734_5_);
        if (p_149734_5_.nextInt(15) == 0) {
        	p_149734_1_.playSound((double)((float)p_149734_2_ + 0.5F), (double)((float)p_149734_3_ + 0.5F), (double)((float)p_149734_4_ + 0.5F), "nova_craft:deepfire", 1.0F + p_149734_5_.nextFloat(), p_149734_5_.nextFloat() * 0.7F + 0.3F, false);
        	float f;
            float f1;
            float f2;
            
        	 for (int i = 0; i < 2; ++i)
        	    {       		 
        		 f = (float)p_149734_2_ + p_149734_5_.nextFloat() * 0.1F;
                 f1 = (float)p_149734_3_ + p_149734_5_.nextFloat();
                 f2 = (float)p_149734_4_ + p_149734_5_.nextFloat();
                 p_149734_1_.spawnParticle("smoke", (double)f, (double)f1, (double)f2, 0.0D, 0.0D, 0.0D);
                 p_149734_1_.spawnParticle("smoke", (double)f, (double)f1, (double)f2, 0.0D, 0.0D, 0.0D);
                 p_149734_1_.spawnParticle("smoke", (double)f, (double)f1, (double)f2, 0.0D, 0.0D, 0.0D);
             }        	    
        }
        
        World par1World = p_149734_1_;
		int par2 = p_149734_2_;
		int par3 = p_149734_3_;
		int par4 = p_149734_4_;
		Random par5Random = p_149734_5_;
		if (true)
			for (int l = 0; l < 8; ++l) {
				double d0 = (double) ((float) par2 + par5Random.nextFloat());
				double d1 = (double) ((float) par3 + par5Random.nextFloat());
				double d2 = (double) ((float) par4 + par5Random.nextFloat());
				double d3 = 0.0D;
				double d4 = 0.0D;
				double d5 = 0.0D;
				int i1 = par5Random.nextInt(2) * 2 - 1;
				d3 = ((double) par5Random.nextFloat() - 0.5D) * 0.5D;
				d4 = ((double) par5Random.nextFloat() - 0.5D) * 0.5D;
				d5 = ((double) par5Random.nextFloat() - 0.5D) * 0.5D;
				ParticleHandler.BLAZFLAME.spawn(par1World, d0 - d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D, 0.0f, new Object[0]); 
			}
        
    }
    
    public void updateTick(final World world, final int x, final int y, final int z, final Random rand) {
        if (world.getGameRules().getGameRuleBooleanValue("doFireTick")) {
            final boolean flag = world.getBlock(x, y - 1, z).isFireSource(world, x, y - 1, z, ForgeDirection.UP) || world.getBlock(x, y - 1, z) == NovaCraftBlocks.deepfire;
            if (!this.canPlaceBlockAt(world, x, y, z)) {
                world.setBlockToAir(x, y, z);
            }
            if (!flag && world.isRaining() && (world.canLightningStrikeAt(x, y, z) || world.canLightningStrikeAt(x - 1, y, z) || world.canLightningStrikeAt(x + 1, y, z) || world.canLightningStrikeAt(x, y, z - 1) || world.canLightningStrikeAt(x, y, z + 1))) {
                world.setBlockToAir(x, y, z);
            }
            else {
                final int l = world.getBlockMetadata(x, y, z);
                if (l < 15) {
                    world.setBlockMetadataWithNotify(x, y, z, l + rand.nextInt(3) / 2, 4);
                }
                world.scheduleBlockUpdate(x, y, z, (Block)this, this.tickRate(world) + rand.nextInt(10));
                if (!flag && !this.canNeighborBurn(world, x, y, z)) {
                    if (!World.doesBlockHaveSolidTopSurface((IBlockAccess)world, x, y - 1, z) || l > 3) {
                        world.setBlockToAir(x, y, z);
                    }
                }
                else {
                    final boolean flag2 = world.isBlockHighHumidity(x, y, z);
                    byte b0 = 0;
                    if (flag2) {
                        b0 = -50;
                    }
                    this.tryCatchFire(world, x + 1, y, z, 300 + b0, rand, l, ForgeDirection.WEST);
                    this.tryCatchFire(world, x - 1, y, z, 300 + b0, rand, l, ForgeDirection.EAST);
                    this.tryCatchFire(world, x, y - 1, z, 250 + b0, rand, l, ForgeDirection.UP);
                    this.tryCatchFire(world, x, y + 1, z, 250 + b0, rand, l, ForgeDirection.DOWN);
                    this.tryCatchFire(world, x, y, z - 1, 300 + b0, rand, l, ForgeDirection.SOUTH);
                    this.tryCatchFire(world, x, y, z + 1, 300 + b0, rand, l, ForgeDirection.NORTH);
                    for (int i1 = x - 1; i1 <= x + 1; ++i1) {
                        for (int j1 = z - 1; j1 <= z + 1; ++j1) {
                            for (int k1 = y - 1; k1 <= y + 4; ++k1) {
                                if (i1 != x || k1 != y || j1 != z) {
                                    int l2 = 100;
                                    if (k1 > y + 1) {
                                        l2 += (k1 - (y + 1)) * 100;
                                    }
                                    final int i2 = this.getChanceOfNeighborsEncouragingFire(world, i1, k1, j1);
                                    if (i2 > 0) {
                                        int j2 = (i2 + 40 + world.difficultySetting.getDifficultyId() * 7) / (l + 30);
                                        if (flag2) {
                                            j2 /= 2;
                                        }
                                        if (j2 > 0 && rand.nextInt(l2) <= j2 && (!world.isRaining() || !world.canLightningStrikeAt(i1, k1, j1)) && !world.canLightningStrikeAt(i1 - 1, k1, z) && !world.canLightningStrikeAt(i1 + 1, k1, j1) && !world.canLightningStrikeAt(i1, k1, j1 - 1) && !world.canLightningStrikeAt(i1, k1, j1 + 1)) {
                                            int k2 = l + rand.nextInt(5) / 4;
                                            if (k2 > 15) {
                                                k2 = 15;
                                            }
                                            world.setBlock(i1, k1, j1, (Block)Blocks.fire, k2, 3);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
