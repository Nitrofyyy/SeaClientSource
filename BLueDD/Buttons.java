// 
// Decompiled by Procyon v0.5.36
// 

package BLueDD;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;

public class Buttons extends GuiButton
{
    private boolean background;
    int outlineColor;
    
    public Buttons(final int buttonId, final int x, final int y, final int widthIn, final int heightIn, final boolean hasBackground, final String buttonText) {
        super(buttonId, x, y, widthIn, heightIn, buttonText);
        this.background = hasBackground;
    }
    
    @Override
    public void drawButton(final Minecraft mc, final int mouseX, final int mouseY) {
        if (this.visible) {
            final FontRenderer fontrenderer = mc.fontRendererObj;
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            this.hovered = (mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height);
            final int i = this.getHoverState(this.hovered);
            Gui.drawRect(this.xPosition, this.yPosition, this.xPosition + this.width, this.yPosition + this.height, -1355467467);
            this.drawHorizontalLine(this.xPosition, this.xPosition + this.width - 1, this.yPosition, this.outlineColor);
            this.drawHorizontalLine(this.xPosition, this.xPosition + this.width - 1, this.yPosition + this.height - 1, this.outlineColor);
            this.drawVerticalLine(this.xPosition, this.yPosition + this.height, this.yPosition, this.outlineColor);
            this.drawVerticalLine(this.xPosition + this.width - 1, this.yPosition + this.height, this.yPosition, this.outlineColor);
            this.mouseDragged(mc, mouseX, mouseY);
            int j = 14737632;
            if (!this.enabled) {
                j = 10526880;
            }
            else if (this.hovered) {
                this.outlineColor = -13619152;
                if (this.id == 99) {
                    j = -51915;
                }
                else {
                    j = 16777120;
                }
            }
            else {
                this.outlineColor = -1358954496;
            }
            mc.fontRendererObj.drawString(this.displayString, this.xPosition + this.width / 2, this.yPosition + (this.height - 10) / 2, j);
        }
    }
}
