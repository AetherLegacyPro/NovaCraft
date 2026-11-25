package com.NovaCraft.TileEntity;

import com.NovaCraft.achievements.AchievementsNovaCraft;
import com.NovaCraftBlocks.NovaCraftBlocks;
import net.minecraft.tileentity.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.item.*;
import com.google.common.collect.*;
import net.minecraft.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.potion.*;
import net.minecraft.world.*;
import net.minecraft.stats.*;
import net.minecraft.block.*;
import net.minecraft.network.*;
import net.minecraft.nbt.*;
import net.minecraft.network.play.server.*;
import net.minecraft.entity.passive.*;
import net.minecraft.init.*;
import java.util.*;

public class TileEntityLegendaryBeacon extends TileEntityBeacon {
    public static final Potion[][] effectsList;
    @SideOnly(Side.CLIENT)
    private long field_146016_i;
    @SideOnly(Side.CLIENT)
    private float field_146014_j;
    private boolean field_146015_k;
    private int levels = -1;
    private int primaryEffect;
    private int secondaryEffect;
    private ItemStack payment;
    private String field_146008_p;
    private final List segments = Lists.newArrayList();

    private boolean isValidLegendaryBeaconBase(int x, int y, int z) {
        Block block = this.worldObj.getBlock(x, y, z);

        return block == Blocks.diamond_block || block == NovaCraftBlocks.block_of_klangite || block == NovaCraftBlocks.block_of_mercuridium
                || block == NovaCraftBlocks.block_of_reinforced_vanite || block == NovaCraftBlocks.block_of_iridium || block == NovaCraftBlocks.block_of_tophinite
                || block == NovaCraftBlocks.nullified_vanite || block == NovaCraftBlocks.crystallized_vanite || block == NovaCraftBlocks.legendary_ore_block;
    }

    public void updateEntity() {
        if (this.worldObj.getTotalWorldTime() % 80L == 0L) {
            this.func_146003_y();
            this.func_146000_x();
            if (this.worldObj.isRemote) {
                this.updateSegments();
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public AxisAlignedBB getRenderBoundingBox() {
        final int height = (this.worldObj == null) ? 256 : this.worldObj.getActualHeight();
        return AxisAlignedBB.getBoundingBox((double) this.xCoord, (double) this.yCoord, (double) this.zCoord, (double) (this.xCoord + 1), Double.POSITIVE_INFINITY, (double) (this.zCoord + 1));
    }

    private void func_146000_x() {
        if (!this.field_146015_k || this.levels <= 0 || this.worldObj.isRemote || this.primaryEffect <= 0) {
            return;
        }

        double range = (this.levels * 20.0D + 20.0D) * 4.0D;
        int amplifier = 1;
        if (this.levels >= 4 && this.primaryEffect == this.secondaryEffect) {
            amplifier = 2;
        }

        AxisAlignedBB effectArea = AxisAlignedBB.getBoundingBox(this.xCoord, this.yCoord, this.zCoord, this.xCoord + 1, this.yCoord + 1, this.zCoord + 1).expand(range, range, range);
        List<EntityPlayer> players = this.worldObj.getEntitiesWithinAABB(EntityPlayer.class, effectArea);
        for (EntityPlayer player : players) {
            player.addPotionEffect(new PotionEffect(this.primaryEffect, 180, amplifier, true));
            if (this.levels >= 4 && this.primaryEffect != this.secondaryEffect && this.secondaryEffect > 0) {
                player.addPotionEffect(new PotionEffect(this.secondaryEffect, 300, 0, true));
            }
        }
    }

    private void func_146003_y() {
        int previousLevels = this.levels;
        this.field_146015_k = true;
        this.levels = 0;

        for (int layer = 1; layer <= 4; ++layer) {
            int y = this.yCoord - layer;
            if (y < 0) {
                break;
            }

            boolean validLayer = true;
            for (int x = this.xCoord - layer; x <= this.xCoord + layer && validLayer; ++x) {
                for (int z = this.zCoord - layer; z <= this.zCoord + layer; ++z) {
                    if (!this.isValidLegendaryBeaconBase(x, y, z)) {
                        validLayer = false;
                        break;
                    }
                }
            }

            if (!validLayer) {
                break;
            }

            this.levels = layer;
        }

        if (this.levels == 0) {
            this.field_146015_k = false;
        }

        if (!this.worldObj.isRemote && this.levels == 4 && previousLevels < 4) {
            AxisAlignedBB achievementArea = AxisAlignedBB.getBoundingBox(this.xCoord, this.yCoord - 4, this.zCoord, this.xCoord + 1, this.yCoord + 1, this.zCoord + 1).expand(10.0D, 5.0D, 10.0D);
            List<EntityPlayer> players = this.worldObj.getEntitiesWithinAABB(EntityPlayer.class, achievementArea);
            for (EntityPlayer player : players) {
                player.triggerAchievement(AchievementsNovaCraft.legend);
            }
        }
    }
    
    @SideOnly(Side.CLIENT)
    public float func_146002_i() {
        if (!this.field_146015_k) {
            return 0.0f;
        }
        final int i = (int)(this.worldObj.getTotalWorldTime() - this.field_146016_i);
        this.field_146016_i = this.worldObj.getTotalWorldTime();
        if (i > 1) {
            this.field_146014_j -= i / 40.0f;
            if (this.field_146014_j < 0.0f) {
                this.field_146014_j = 0.0f;
            }
        }
        this.field_146014_j += 0.025f;
        if (this.field_146014_j > 1.0f) {
            this.field_146014_j = 1.0f;
        }
        return this.field_146014_j;
    }
    
    public int getPrimaryEffect() {
        return this.primaryEffect;
    }
    
    public int getSecondaryEffect() {
        return this.secondaryEffect;
    }
    
    public int getLevels() {
        return this.levels;
    }
    
    @SideOnly(Side.CLIENT)
    public void func_146005_c(final int p_146005_1_) {
        this.levels = p_146005_1_;
    }
    
    public void setPrimaryEffect(final int p_146001_1_) {
        this.primaryEffect = 1;
        for (int j = 0; j < this.levels && j < 3; ++j) {
            for (final Potion potion : TileEntityLegendaryBeacon.effectsList[j]) {
                if (potion.id == p_146001_1_) {
                    this.primaryEffect = p_146001_1_;
                    return;
                }
            }
        }
    }
    
    public void setSecondaryEffect(final int p_146004_1_) {
        this.secondaryEffect = 2;
        if (this.levels >= 4) {
            for (int j = 0; j < 4; ++j) {
                for (final Potion potion : TileEntityLegendaryBeacon.effectsList[j]) {
                    if (potion.id == p_146004_1_) {
                        this.secondaryEffect = p_146004_1_;
                        return;
                    }
                }
                
            }
        }
    }
    
    public Packet getDescriptionPacket() {
        final NBTTagCompound nbttagcompound = new NBTTagCompound();
        this.writeToNBT(nbttagcompound);
        return (Packet)new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 3, nbttagcompound);
    }
    
    @SideOnly(Side.CLIENT)
    public double getMaxRenderDistanceSquared() {
        return 65536.0;
    }
    
    public void readFromNBT(final NBTTagCompound p_145839_1_) {
        super.readFromNBT(p_145839_1_);
        this.primaryEffect = p_145839_1_.getInteger("Primary");
        this.secondaryEffect = p_145839_1_.getInteger("Secondary");
        this.levels = p_145839_1_.getInteger("Levels");
    }
    
    public void writeToNBT(final NBTTagCompound p_145841_1_) {
        super.writeToNBT(p_145841_1_);
        p_145841_1_.setInteger("Primary", this.primaryEffect);
        p_145841_1_.setInteger("Secondary", this.secondaryEffect);
        p_145841_1_.setInteger("Levels", this.levels);
    }
    
    public int getSizeInventory() {
        return 1;
    }
    
    public ItemStack getStackInSlot(final int p_70301_1_) {
        return (p_70301_1_ == 0) ? this.payment : null;
    }
    
    public ItemStack decrStackSize(final int p_70298_1_, final int p_70298_2_) {
        if (p_70298_1_ != 0 || this.payment == null) {
            return null;
        }
        if (p_70298_2_ >= this.payment.stackSize) {
            final ItemStack itemstack = this.payment;
            this.payment = null;
            return itemstack;
        }
        final ItemStack payment = this.payment;
        payment.stackSize -= p_70298_2_;
        return new ItemStack(this.payment.getItem(), p_70298_2_, this.payment.getItemDamage());
    }
    
    public ItemStack getStackInSlotOnClosing(final int p_70304_1_) {
        if (p_70304_1_ == 0 && this.payment != null) {
            final ItemStack itemstack = this.payment;
            this.payment = null;
            return itemstack;
        }
        return null;
    }
    
    public void setInventorySlotContents(final int p_70299_1_, final ItemStack p_70299_2_) {
        if (p_70299_1_ == 0) {
            this.payment = p_70299_2_;
        }
    }
    
    public String getInventoryName() {
        return this.hasCustomInventoryName() ? this.field_146008_p : "container.beacon";
    }
    
    public boolean hasCustomInventoryName() {
        return this.field_146008_p != null && this.field_146008_p.length() > 0;
    }
    
    public void func_145999_a(final String p_145999_1_) {
        this.field_146008_p = p_145999_1_;
    }
    
    public int getInventoryStackLimit() {
        return 1;
    }
    
    public boolean isUseableByPlayer(final EntityPlayer p_70300_1_) {
        return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) == this && p_70300_1_.getDistanceSq(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5) <= 64.0;
    }
    
    public void openInventory() {
    }
    
    public void closeInventory() {
    }
    
    public boolean isItemValidForSlot(final int p_94041_1_, final ItemStack p_94041_2_) {
        return p_94041_2_.getItem() != null && p_94041_2_.getItem().isBeaconPayment(p_94041_2_);
    }
    
    private void updateSegments() {
        final int x = this.xCoord;
        final int y = this.yCoord;
        final int z = this.zCoord;
        this.segments.clear();
        BeamSegment beamsegment = new BeamSegment(EntitySheep.fleeceColorTable[0]);
        this.segments.add(beamsegment);
        boolean flag = true;
        for (int i = y + 1; i < this.worldObj.getActualHeight(); ++i) {
            final Block iblockstate = this.worldObj.getBlock(x, i, z);
            float[] colours;
            if (iblockstate == Blocks.stained_glass) {
                colours = EntitySheep.fleeceColorTable[this.worldObj.getBlockMetadata(x, i, z)];
            }
            else {
                if (iblockstate != Blocks.stained_glass_pane) {
                    beamsegment.func_177262_a();
                    continue;
                }
                colours = EntitySheep.fleeceColorTable[this.worldObj.getBlockMetadata(x, i, z)];
            }
            if (!flag) {
                colours = new float[] { (beamsegment.func_177263_b()[0] + colours[0]) / 2.0f, (beamsegment.func_177263_b()[1] + colours[1]) / 2.0f, (beamsegment.func_177263_b()[2] + colours[2]) / 2.0f };
            }
            if (Arrays.equals(colours, beamsegment.func_177263_b())) {
                beamsegment.func_177262_a();
            }
            else {
                beamsegment = new BeamSegment(colours);
                this.segments.add(beamsegment);
            }
            flag = false;
        }
    }
    
    public List<BeamSegment> getSegments() {
        return this.segments;
    }
    
    static {
        effectsList = new Potion[][] { { Potion.moveSpeed, Potion.digSpeed }, { Potion.fireResistance, Potion.resistance }, { Potion.damageBoost, Potion.regeneration }, { } };
    }
    
    public static class BeamSegment
    {
        private final float[] colours;
        private int field_177265_b;
        
        public BeamSegment(final float[] colours) {
            this.colours = colours;
            this.field_177265_b = 1;
        }
        
        protected void func_177262_a() {
            ++this.field_177265_b;
        }
        
        public float[] func_177263_b() {
            return this.colours;
        }
        
        public int func_177264_c() {
            return this.field_177265_b;
        }
    }
    
}
