package com.NovaCraft.gui;

import com.NovaCraft.container.VaniteAnvilContainer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class GuiVaniteAnvil extends GuiContainer implements ICrafting {
    private static final ResourceLocation ANVIL_TEXTURE = new ResourceLocation("nova_craft","textures/gui/vanite_anvil_gui.png");

    private final VaniteAnvilContainer container;
    private GuiTextField nameField;
    private final InventoryPlayer playerInv;

    public GuiVaniteAnvil(InventoryPlayer inv, World world, int x, int y, int z) {
        super(new VaniteAnvilContainer(inv, world, x, y, z, Minecraft.getMinecraft().thePlayer));
        this.playerInv = inv;
        this.container = (VaniteAnvilContainer)this.inventorySlots;
    }

    @Override
    public void updateScreen() {
        super.updateScreen();

        if (this.inventorySlots instanceof VaniteAnvilContainer) {
            ((VaniteAnvilContainer) this.inventorySlots).updateRepairOutput();
        }
    }

    @Override
    public void initGui() {
        super.initGui();
        Keyboard.enableRepeatEvents(true);

        int guiLeft = (this.width - this.xSize) / 2;
        int guiTop = (this.height - this.ySize) / 2;

        this.nameField = new GuiTextField(this.fontRendererObj, guiLeft + 62, guiTop + 24, 103, 12);

        this.nameField.setTextColor(0xFFFFFF);
        this.nameField.setDisabledTextColour(0xFFFFFF);
        this.nameField.setEnableBackgroundDrawing(false);
        this.nameField.setMaxStringLength(40);

        this.inventorySlots.removeCraftingFromCrafters(this);
        this.inventorySlots.addCraftingToCrafters(this);

        this.nameField.setFocused(false);
        this.nameField.setCanLoseFocus(false);
        this.nameField.setEnabled(false);
    }

    @Override
    public void onGuiClosed() {
        super.onGuiClosed();
        Keyboard.enableRepeatEvents(false);
        this.inventorySlots.removeCraftingFromCrafters(this);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glDisable(GL11.GL_BLEND);

        this.fontRendererObj.drawString(I18n.format("gui.container.repair"), 60, 6, 0x404040);

        if (this.container.maximumCost > 0) {
            boolean canTake = this.container.getSlot(2).getHasStack() && this.container.getSlot(2).canTakeStack(this.playerInv.player);

            int color = canTake ? 0x80FF20 : 0xFF6060;
            String costText = I18n.format("container.repair.cost", this.container.maximumCost);

            int x = this.xSize - 8 - this.fontRendererObj.getStringWidth(costText);
            int y = 67;

            this.fontRendererObj.drawString(costText, x, y, color);
        }

        GL11.glEnable(GL11.GL_LIGHTING);
    }

    @Override
    protected void mouseClicked(int mouseX, int mouseY, int button) {
        super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        super.drawScreen(mouseX, mouseY, partialTicks);
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glDisable(GL11.GL_BLEND);
        this.nameField.drawTextBox();
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GL11.glColor4f(1F, 1F, 1F, 1F);
        this.mc.getTextureManager().bindTexture(ANVIL_TEXTURE);

        int guiLeft = (this.width - this.xSize) / 2;
        int guiTop = (this.height - this.ySize) / 2;

        this.drawTexturedModalRect(guiLeft, guiTop, 0, 0, this.xSize, this.ySize);

        this.drawTexturedModalRect(guiLeft + 59, guiTop + 20, 0, this.ySize + (this.container.getSlot(0).getHasStack() ? 0 : 16), 110, 16);

        if ((this.container.getSlot(0).getHasStack() || this.container.getSlot(1).getHasStack()) && !this.container.getSlot(2).getHasStack()) {
            this.drawTexturedModalRect(guiLeft + 99, guiTop + 45, this.xSize, 0, 28, 21);
        }
    }

    @Override
    public void sendContainerAndContentsToPlayer(Container container, List list)
    {
        this.sendSlotContents(container, 0, container.getSlot(0).getStack());
    }

    @Override
    public void sendSlotContents(Container container, int slot, ItemStack stack)
    {
        if (slot == 0)
        {
            this.nameField.setText(stack == null ? "" : stack.getDisplayName());
            this.nameField.setEnabled(stack != null);
            this.nameField.setCursorPositionZero();
        }
    }

    @Override
    public void sendProgressBarUpdate(Container container, int id, int value) {
        if (id == 0) {
            this.container.maximumCost = value;
        }
    }
}
