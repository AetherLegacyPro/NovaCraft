package com.NovaCraft.gui;

import net.minecraft.client.gui.inventory.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import net.minecraft.inventory.*;
import org.lwjgl.opengl.*;

import com.NovaCraft.container.AdvancedSmithingTableContainer;

import net.minecraft.client.resources.*;

@SideOnly(Side.CLIENT)
public class GuiAdvancedSmithingTable extends GuiContainer
{
    private static final ResourceLocation craftingTableGuiTextures;
    
    public GuiAdvancedSmithingTable(final InventoryPlayer p_i1084_1_, final World p_i1084_2_, final int p_i1084_3_, final int p_i1084_4_, final int p_i1084_5_) {
        super((Container)new AdvancedSmithingTableContainer(p_i1084_1_, p_i1084_2_, p_i1084_3_, p_i1084_4_, p_i1084_5_));
    }
    
    protected void drawGuiContainerBackgroundLayer(final float p_146976_1_, final int p_146976_2_, final int p_146976_3_) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(GuiAdvancedSmithingTable.craftingTableGuiTextures);
        final int k = (this.width - this.xSize) / 2;
        final int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
    }
    
    protected void drawGuiContainerForegroundLayer(final int p_146979_1_, final int p_146979_2_) {
        this.fontRendererObj.drawString(I18n.format("container.advancedSmithingTable", new Object[0]), 28, 6, 4210752);
        this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, this.ySize - 96 + 2, 4210752);
    }
    
    static {
        craftingTableGuiTextures = new ResourceLocation("textures/gui/container/crafting_table.png");
    }
}
