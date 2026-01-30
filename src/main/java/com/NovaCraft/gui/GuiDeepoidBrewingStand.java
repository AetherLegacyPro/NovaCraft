package com.NovaCraft.gui;

import com.NovaCraft.TileEntity.TileEntityDeepoidBrewingStand;
import com.NovaCraft.container.DeepoidBrewingStandContainer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class GuiDeepoidBrewingStand extends GuiContainer {
    
    private static final ResourceLocation brewingStandGuiTextures = new ResourceLocation("nova_craft", "textures/gui/deepoid_brewing_stand_gui.png");
    private TileEntityDeepoidBrewingStand tileBrewingStand;

    public GuiDeepoidBrewingStand(InventoryPlayer p_i1081_1_, TileEntityDeepoidBrewingStand p_i1081_2_)
    {
        super(new DeepoidBrewingStandContainer(p_i1081_1_, p_i1081_2_));
        this.tileBrewingStand = p_i1081_2_;
    }

    protected void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_)
    {
        String s = this.tileBrewingStand.hasCustomInventoryName() ? this.tileBrewingStand.getInventoryName() : I18n.format(this.tileBrewingStand.getInventoryName(), new Object[0]);
        this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
        this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, this.ySize - 96 + 2, 4210752);
    }

    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(brewingStandGuiTextures);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
        int i1 = this.tileBrewingStand.getBrewTime();

        if (i1 > 0)
        {
            int j1 = (int)(28.0F * (1.0F - (float)i1 / 400.0F));

            if (j1 > 0)
            {
                this.drawTexturedModalRect(k + 97, l + 16, 176, 0, 9, j1);
            }

            int k1 = i1 / 2 % 7;

            switch (k1)
            {
                case 0:
                    j1 = 29;
                    break;
                case 1:
                    j1 = 24;
                    break;
                case 2:
                    j1 = 20;
                    break;
                case 3:
                    j1 = 16;
                    break;
                case 4:
                    j1 = 11;
                    break;
                case 5:
                    j1 = 6;
                    break;
                case 6:
                    j1 = 0;
            }

            if (j1 > 0)
            {
                this.drawTexturedModalRect(k + 65, l + 14 + 29 - j1, 185, 29 - j1, 12, j1);
            }
        }
    }
}
