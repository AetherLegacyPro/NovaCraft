package com.NovaCraftBlocks.explosives;

import net.minecraft.block.*;
import net.minecraft.util.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.block.material.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.init.*;
import net.minecraft.entity.projectile.*;
import java.util.*;

import com.NovaCraft.entity.EntityPrimedPETN;
import com.NovaCraft.registry.NovaCraftCreativeTabs;

import net.minecraft.client.renderer.texture.*;

public class BlockPETN extends Block
{   
    @SideOnly(Side.CLIENT)
	private IIcon iconFace, iconTop;
    
    public BlockPETN() {
        super(Material.tnt);
        this.setStepSound(Block.soundTypeGrass);
        this.setHardness(0.0f);
        this.setCreativeTab(NovaCraftCreativeTabs.blocks);
    }
    
    public boolean canDropFromExplosion(final Explosion explosion) {
        return false;
    }
    
    public void func_150114_a(final World world, final int x, final int y, final int z, final int p_150114_5_, final EntityLivingBase entityBase) {
        if (!world.isRemote && (p_150114_5_ & 0x1) == 0x1) {
            final EntityPrimedPETN entitytntprimed = new EntityPrimedPETN(world, x + 0.5f, y + 0.5f, z + 0.5f, entityBase);
            world.spawnEntityInWorld((Entity)entitytntprimed);
            world.playSoundAtEntity((Entity)entitytntprimed, "game.tnt.primed", 1.0f, 1.0f);
        }
    }
    
    public boolean onBlockActivated(final World world, final int x, final int y, final int z, final EntityPlayer player, final int side, final float subX, final float subY, final float subZ) {
        if (player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() == Items.flint_and_steel) {
            this.func_150114_a(world, x, y, z, 1, (EntityLivingBase)player);
            world.setBlockToAir(x, y, z);
            player.getCurrentEquippedItem().damageItem(1, (EntityLivingBase)player);
            return true;
        }
        return super.onBlockActivated(world, x, y, z, player, side, subX, subY, subZ);
    }
    
    public void onBlockAdded(final World world, final int x, final int y, final int z) {
        super.onBlockAdded(world, x, y, z);
        if (world.isBlockIndirectlyGettingPowered(x, y, z)) {
            this.onBlockDestroyedByPlayer(world, x, y, z, 1);
            world.setBlockToAir(x, y, z);
        }
    }
    
    public void onBlockDestroyedByExplosion(final World world, final int x, final int y, final int z, final Explosion explosion) {
        if (!world.isRemote) {
            final EntityPrimedPETN entitytntprimed = new EntityPrimedPETN(world, x + 0.5f, y + 0.5f, z + 0.5f, explosion.getExplosivePlacedBy());
            entitytntprimed.fuse = world.rand.nextInt(entitytntprimed.fuse / 4) + entitytntprimed.fuse / 8;
            world.spawnEntityInWorld((Entity)entitytntprimed);
        }
    }
    
    public void onBlockDestroyedByPlayer(final World world, final int x, final int y, final int z, final int meta) {
        this.func_150114_a(world, x, y, z, meta, null);
    }
    
    public void onEntityCollidedWithBlock(final World world, final int x, final int y, final int z, final Entity entity) {
        if (entity instanceof EntityArrow && !world.isRemote) {
            final EntityArrow entityarrow = (EntityArrow)entity;
            if (entityarrow.isBurning()) {
                this.func_150114_a(world, x, y, z, 1, (EntityLivingBase) ((entityarrow.shootingEntity instanceof EntityLivingBase) ? entityarrow.shootingEntity : null));
                world.setBlockToAir(x, y, z);
            }
        }
    }
    
    public void onNeighborBlockChange(final World world, final int x, final int y, final int z, final Block block) {
        if (world.isBlockIndirectlyGettingPowered(x, y, z)) {
            this.onBlockDestroyedByPlayer(world, x, y, z, 1);
            world.setBlockToAir(x, y, z);
        }
    }
    
    public int quantityDropped(final Random random) {
        return 1;
    }
    
    @Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta){
		return side == 0 || side == 1 ? iconTop : meta >= 1 && side-1 == meta ? iconFace : blockIcon;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister){
		blockIcon = iconRegister.registerIcon("nova_craft:PETN_side");
		iconFace = iconRegister.registerIcon("nova_craft:PETN_bottom");
		iconTop = iconRegister.registerIcon("nova_craft:PETN_top");
	}
}


