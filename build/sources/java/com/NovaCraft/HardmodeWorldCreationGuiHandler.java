package com.NovaCraft;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiCreateWorld;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.GuiScreenEvent;

@SideOnly(Side.CLIENT)
public class HardmodeWorldCreationGuiHandler {
    private static final int HARDMODE_BUTTON_ID = 7560;
    private GuiCreateWorld currentScreen;
    private GuiButton gameModeButton;
    private GuiButton hardmodeButton;
    private boolean startingHardmode;

    @SubscribeEvent
    public void onGuiInit(GuiScreenEvent.InitGuiEvent.Post event) {
        if (!(event.gui instanceof GuiCreateWorld)) {
            return;
        }

        GuiCreateWorld screen = (GuiCreateWorld)event.gui;

        if (this.currentScreen != screen) {
            this.currentScreen = screen;
            this.startingHardmode = false;
            HardmodeWorldCreationSettings.clear();
        }

        this.gameModeButton = null;
        this.hardmodeButton = null;

        GuiButton moreOptionsButton = null;
        for (Object object : event.buttonList) {
            GuiButton button = (GuiButton)object;

            if (button.id == 2) {
                this.gameModeButton = button;
            }

            if (button.id == 3) {
                moreOptionsButton = button;
            }
        }

        if (this.gameModeButton == null || moreOptionsButton == null) {
            return;
        }

        int buttonY = moreOptionsButton.yPosition - 24;
        this.hardmodeButton = new GuiButton(HARDMODE_BUTTON_ID, moreOptionsButton.xPosition, buttonY, moreOptionsButton.width, moreOptionsButton.height, this.getButtonLabel());
        this.hardmodeButton.visible = this.gameModeButton.visible;
        event.buttonList.add(this.hardmodeButton);
    }

    @SubscribeEvent
    public void onDrawScreen(GuiScreenEvent.DrawScreenEvent.Pre event) {
        if (event.gui != this.currentScreen || this.hardmodeButton == null || this.gameModeButton == null) {
            return;
        }

        this.hardmodeButton.visible = this.gameModeButton.visible;
    }

    @SubscribeEvent
    public void onButton(GuiScreenEvent.ActionPerformedEvent.Pre event) {
        if (event.gui != this.currentScreen) {
            return;
        }

        if (event.button.id == HARDMODE_BUTTON_ID) {
            this.startingHardmode = !this.startingHardmode;
            event.button.displayString = this.getButtonLabel();
            Minecraft.getMinecraft().getSoundHandler().playSound(PositionedSoundRecord.func_147674_a(new ResourceLocation("minecraft:portal.travel"), 1.0F));
            event.setCanceled(true);
        }
        else if (event.button.id == 0) {
            HardmodeWorldCreationSettings.prepare(this.startingHardmode);
        }
        else if (event.button.id == 1) {
            HardmodeWorldCreationSettings.clear();
        }
    }

    private String getButtonLabel() {
        return "Hardmode: " + (this.startingHardmode ? "ON" : "OFF");
    }
}