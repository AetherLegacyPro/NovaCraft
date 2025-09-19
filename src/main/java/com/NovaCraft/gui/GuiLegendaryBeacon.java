package com.NovaCraft.gui;

import net.minecraft.client.gui.inventory.*;
import net.minecraft.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;
import net.minecraft.client.gui.*;
import net.minecraft.network.play.client.*;
import net.minecraft.network.*;
import io.netty.buffer.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.resources.*;
import java.util.*;
import org.lwjgl.opengl.*;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.TileEntity.ContainerLegendaryBeacon;
import com.NovaCraft.TileEntity.TileEntityLegendaryBeacon;

import net.minecraft.item.*;
import net.minecraft.init.*;
import org.apache.logging.log4j.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.client.*;
import net.minecraft.potion.*;

public class GuiLegendaryBeacon extends GuiContainer
{
    private static final Logger logger;
    private static final ResourceLocation beaconGuiTextures;
    private TileEntityLegendaryBeacon tileBeacon;
    private ConfirmButton beaconConfirmButton;
    private boolean buttonsNotDrawn;
    
    public GuiLegendaryBeacon(final InventoryPlayer p_i1078_1_, final TileEntityLegendaryBeacon p_i1078_2_) {
        super((Container)new ContainerLegendaryBeacon(p_i1078_1_, p_i1078_2_));
        this.tileBeacon = p_i1078_2_;
        this.xSize = 230;
        this.ySize = 219;
    }
    
    public void initGui() {
        super.initGui();
        this.buttonList.add(this.beaconConfirmButton = new ConfirmButton(-1, this.guiLeft + 164, this.guiTop + 107));
        this.buttonList.add(new CancelButton(-2, this.guiLeft + 190, this.guiTop + 107));
        this.buttonsNotDrawn = true;
        this.beaconConfirmButton.enabled = false;
    }
    
    public void updateScreen() {
        super.updateScreen();
        if (this.buttonsNotDrawn && this.tileBeacon.getLevels() >= 0) {
            this.buttonsNotDrawn = false;
            for (int i = 0; i <= 2; ++i) {
                final int j = TileEntityLegendaryBeacon.effectsList[i].length;
                final int k = j * 22 + (j - 1) * 2;
                for (int l = 0; l < j; ++l) {
                    final int i2 = TileEntityLegendaryBeacon.effectsList[i][l].id;
                    final PowerButton powerbutton = new PowerButton(i << 8 | i2, this.guiLeft + 76 + l * 24 - k / 2, this.guiTop + 22 + i * 25, i2, i);
                    this.buttonList.add(powerbutton);
                    if (i >= this.tileBeacon.getLevels()) {
                        powerbutton.enabled = false;
                    }
                    else if (i2 == this.tileBeacon.getPrimaryEffect()) {
                        powerbutton.func_146140_b(true);
                    }
                }
            }
            final byte b0 = 3;
            final int j = TileEntityLegendaryBeacon.effectsList[b0].length + 1;
            final int k = j * 22 + (j - 1) * 2;
            for (int l = 0; l < j - 1; ++l) {
                final int i2 = TileEntityLegendaryBeacon.effectsList[b0][l].id;
                final PowerButton powerbutton = new PowerButton(b0 << 8 | i2, this.guiLeft + 167 + l * 24 - k / 2, this.guiTop + 47, i2, b0);
                this.buttonList.add(powerbutton);
                if (b0 >= this.tileBeacon.getLevels()) {
                    powerbutton.enabled = false;
                }
                else if (i2 == this.tileBeacon.getSecondaryEffect()) {
                    powerbutton.func_146140_b(true);
                }
            }
            if (this.tileBeacon.getPrimaryEffect() > 0) {
                final PowerButton powerbutton2 = new PowerButton(b0 << 8 | this.tileBeacon.getPrimaryEffect(), this.guiLeft + 167 + (j - 1) * 24 - k / 2, this.guiTop + 47, this.tileBeacon.getPrimaryEffect(), b0);
                this.buttonList.add(powerbutton2);
                if (b0 >= this.tileBeacon.getLevels()) {
                    powerbutton2.enabled = false;
                }
                else if (this.tileBeacon.getPrimaryEffect() == this.tileBeacon.getSecondaryEffect()) {
                    powerbutton2.func_146140_b(true);
                }
            }
        }
        this.beaconConfirmButton.enabled = (this.tileBeacon.getStackInSlot(0) != null && this.tileBeacon.getPrimaryEffect() > 0);
    }
    
    protected void actionPerformed(final GuiButton p_146284_1_) {
        if (p_146284_1_.id == -2) {
            this.mc.displayGuiScreen((GuiScreen)null);
        }
        else if (p_146284_1_.id == -1) {
            final String s = "MC|Beacon";
            final ByteBuf bytebuf = Unpooled.buffer();
            try {
                bytebuf.writeInt(this.tileBeacon.getPrimaryEffect());
                bytebuf.writeInt(this.tileBeacon.getSecondaryEffect());
                this.mc.getNetHandler().addToSendQueue((Packet)new C17PacketCustomPayload(s, bytebuf));
            }
            catch (Exception exception) {
                GuiLegendaryBeacon.logger.error("Couldn't send beacon info", (Throwable)exception);
            }
            finally {
                bytebuf.release();
            }
            this.mc.displayGuiScreen((GuiScreen)null);
        }
        else if (p_146284_1_ instanceof PowerButton) {
            if (((PowerButton)p_146284_1_).func_146141_c()) {
                return;
            }
            final int j = p_146284_1_.id;
            final int k = j & 0xFF;
            final int i = j >> 8;
            if (i < 3) {
                this.tileBeacon.setPrimaryEffect(k);
            }
            else {
                this.tileBeacon.setSecondaryEffect(k);
            }
            this.buttonList.clear();
            this.initGui();
            this.updateScreen();
        }
    }
    
    protected void drawGuiContainerForegroundLayer(final int p_146979_1_, final int p_146979_2_) {
        RenderHelper.disableStandardItemLighting();
        this.drawCenteredString(this.fontRendererObj, I18n.format("tile.beacon.primary", new Object[0]), 62, 10, 14737632);
        this.drawCenteredString(this.fontRendererObj, I18n.format("tile.beacon.secondary", new Object[0]), 169, 10, 14737632);
        //for (final GuiButton guibutton : this.buttonList) {
            Iterator iterator = this.buttonList.iterator();
            while(iterator.hasNext()) {
                GuiButton guibutton = (GuiButton)iterator.next();

                if (guibutton.func_146115_a()) {
                guibutton.func_146111_b(p_146979_1_ - this.guiLeft, p_146979_2_ - this.guiTop);
                break;
            }
        }
        RenderHelper.enableGUIStandardItemLighting();
    }
    
    protected void drawGuiContainerBackgroundLayer(final float p_146976_1_, final int p_146976_2_, final int p_146976_3_) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(GuiLegendaryBeacon.beaconGuiTextures);
        final int k = (this.width - this.xSize) / 2;
        final int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
        GuiLegendaryBeacon.itemRender.zLevel = 100.0f;
        GuiLegendaryBeacon.itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(NovaCraftItems.klangite_ingot, 1, 0), k + 20, l + 109);
        GuiLegendaryBeacon.itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(NovaCraftItems.warden_shard), k + 42, l + 109);
        GuiLegendaryBeacon.itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(NovaCraftItems.nullified_vanite_alloy), k + 42 + 22, l + 109);
        GuiLegendaryBeacon.itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(NovaCraftItems.nullified_dust), k + 42 + 44, l + 109);
        GuiLegendaryBeacon.itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(NovaCraftItems.dark_essence), k + 42 + 66, l + 109);
        GuiLegendaryBeacon.itemRender.zLevel = 0.0f;
    }
    
    static /* synthetic */ void access$100(final GuiLegendaryBeacon x0, final String x1, final int x2, final int x3) {
        x0.drawCreativeTabHoveringText(x1, x2, x3);
    }
    
    static /* synthetic */ void access$200(final GuiLegendaryBeacon x0, final String x1, final int x2, final int x3) {
        x0.drawCreativeTabHoveringText(x1, x2, x3);
    }
    
    static /* synthetic */ void access$400(final GuiLegendaryBeacon x0, final String x1, final int x2, final int x3) {
        x0.drawCreativeTabHoveringText(x1, x2, x3);
    }
    
    static {
        logger = LogManager.getLogger();
        beaconGuiTextures = new ResourceLocation("nova_craft:textures/gui/beacon.png");
    }
    
    @SideOnly(Side.CLIENT)
    static class Button extends GuiButton
    {
        private final ResourceLocation field_146145_o;
        private final int field_146144_p;
        private final int field_146143_q;
        private boolean field_146142_r;
        private static final String __OBFID = "CL_00000743";
        
        protected Button(final int p_i1077_1_, final int p_i1077_2_, final int p_i1077_3_, final ResourceLocation p_i1077_4_, final int p_i1077_5_, final int p_i1077_6_) {
            super(p_i1077_1_, p_i1077_2_, p_i1077_3_, 22, 22, "");
            this.field_146145_o = p_i1077_4_;
            this.field_146144_p = p_i1077_5_;
            this.field_146143_q = p_i1077_6_;
        }
        
        public void drawButton(final Minecraft p_146112_1_, final int p_146112_2_, final int p_146112_3_) {
            if (this.visible) {
                p_146112_1_.getTextureManager().bindTexture(GuiLegendaryBeacon.beaconGuiTextures);
                GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
                this.field_146123_n = (p_146112_2_ >= this.xPosition && p_146112_3_ >= this.yPosition && p_146112_2_ < this.xPosition + this.width && p_146112_3_ < this.yPosition + this.height);
                final short short1 = 219;
                int k = 0;
                if (!this.enabled) {
                    k += this.width * 2;
                }
                else if (this.field_146142_r) {
                    k += this.width * 1;
                }
                else if (this.field_146123_n) {
                    k += this.width * 3;
                }
                this.drawTexturedModalRect(this.xPosition, this.yPosition, k, (int)short1, this.width, this.height);
                if (!GuiLegendaryBeacon.beaconGuiTextures.equals((Object)this.field_146145_o)) {
                    p_146112_1_.getTextureManager().bindTexture(this.field_146145_o);
                }
                this.drawTexturedModalRect(this.xPosition + 2, this.yPosition + 2, this.field_146144_p, this.field_146143_q, 18, 18);
            }
        }
        
        public boolean func_146141_c() {
            return this.field_146142_r;
        }
        
        public void func_146140_b(final boolean p_146140_1_) {
            this.field_146142_r = p_146140_1_;
        }
    }
    
    @SideOnly(Side.CLIENT)
    class CancelButton extends Button
    {
        private static final String __OBFID = "CL_00000740";
        
        public CancelButton(final int p_i1074_2_, final int p_i1074_3_, final int p_i1074_4_) {
            super(p_i1074_2_, p_i1074_3_, p_i1074_4_, GuiLegendaryBeacon.beaconGuiTextures, 112, 220);
        }
        
        public void func_146111_b(final int p_146111_1_, final int p_146111_2_) {
            GuiLegendaryBeacon.access$100(GuiLegendaryBeacon.this, I18n.format("gui.cancel", new Object[0]), p_146111_1_, p_146111_2_);
        }
    }
    
    @SideOnly(Side.CLIENT)
    class ConfirmButton extends Button
    {
        private static final String __OBFID = "CL_00000741";
        
        public ConfirmButton(final int p_i1075_2_, final int p_i1075_3_, final int p_i1075_4_) {
            super(p_i1075_2_, p_i1075_3_, p_i1075_4_, GuiLegendaryBeacon.beaconGuiTextures, 90, 220);
        }
        
        public void func_146111_b(final int p_146111_1_, final int p_146111_2_) {
            GuiLegendaryBeacon.access$200(GuiLegendaryBeacon.this, I18n.format("gui.done", new Object[0]), p_146111_1_, p_146111_2_);
        }
    }
    
    @SideOnly(Side.CLIENT)
    class PowerButton extends Button
    {
        private final int field_146149_p;
        private final int field_146148_q;
        private static final String __OBFID = "CL_00000742";
        
        public PowerButton(final int p_i1076_2_, final int p_i1076_3_, final int p_i1076_4_, final int p_i1076_5_, final int p_i1076_6_) {
            super(p_i1076_2_, p_i1076_3_, p_i1076_4_, GuiLegendaryBeacon.field_147001_a, 0 + Potion.potionTypes[p_i1076_5_].getStatusIconIndex() % 8 * 18, 198 + Potion.potionTypes[p_i1076_5_].getStatusIconIndex() / 8 * 18);
            this.field_146149_p = p_i1076_5_;
            this.field_146148_q = p_i1076_6_;
        }
        
        public void func_146111_b(final int p_146111_1_, final int p_146111_2_) {
            String s = I18n.format(Potion.potionTypes[this.field_146149_p].getName(), new Object[0]);
            if (this.field_146148_q >= 3 && this.field_146149_p != Potion.regeneration.id && this.field_146149_p != Potion.nightVision.id && this.field_146149_p != Potion.fireResistance.id && this.field_146149_p != Potion.moveSpeed.id && this.field_146149_p != Potion.jump.id && this.field_146149_p != Potion.resistance.id) {
                s += " III";
            }
            if (this.field_146148_q >= 3 && (this.field_146149_p == Potion.regeneration.id || this.field_146149_p == Potion.resistance.id) && this.field_146149_p != Potion.nightVision.id && this.field_146149_p != Potion.fireResistance.id && this.field_146149_p != Potion.moveSpeed.id && this.field_146149_p != Potion.jump.id) {
                s += " II";
            }
            if (this.field_146148_q >= 3 && (this.field_146149_p == Potion.moveSpeed.id || this.field_146149_p == Potion.jump.id) && this.field_146149_p != Potion.damageBoost.id && this.field_146149_p != Potion.regeneration.id && this.field_146149_p != Potion.digSpeed.id && this.field_146149_p != Potion.nightVision.id && this.field_146149_p != Potion.fireResistance.id && this.field_146149_p != Potion.resistance.id) {
                s += " III";
            }
            GuiLegendaryBeacon.access$400(GuiLegendaryBeacon.this, s, p_146111_1_, p_146111_2_);
        }
    }
}

