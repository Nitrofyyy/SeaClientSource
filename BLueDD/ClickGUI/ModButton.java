// 
// Decompiled by Procyon v0.5.36
// 

package BLueDD.ClickGUI;

import net.minecraft.client.gui.Gui;
import java.awt.Color;
import BLueDD.hud.mod.HudMod;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;

public class ModButton
{
    public int x;
    public int y;
    public int w;
    public int h;
    public int outlineColor;
    public int xPosition;
    public int yPosition;
    public static ResourceLocation enable_background;
    public static ResourceLocation disable_background;
    public static Minecraft mc;
    public HudMod m;
    
    static {
        ModButton.enable_background = new ResourceLocation("BLueDD/LpJDUul.png");
        ModButton.disable_background = new ResourceLocation("BLueDD/disable.png");
        ModButton.mc = Minecraft.getMinecraft();
    }
    
    public ModButton(final int x, final int y, final int w, final int h, final HudMod m) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.m = m;
    }
    
    public void draw() {
        Gui.drawRect(this.x, this.y, this.x + this.w, this.y + this.h, new Color(0, 0, 0, 170).getRGB());
        Gui.drawRect(this.x, this.y, this.x + this.w, this.y + this.h, new Color(0, 0, 0, 170).getRGB());
        Gui.drawRect(this.x, this.y, this.x + this.w, this.y + this.h, new Color(0, 0, 0, 170).getRGB());
        Gui.drawRect(this.x, this.y, this.x + this.w, this.y + this.h, new Color(0, 0, 0, 170).getRGB());
        Gui.drawRect(this.x, this.y, this.x + this.w, this.y + this.h, new Color(0, 0, 0, 170).getRGB());
        Gui.drawRect(this.x, this.y, this.x + this.w, this.y + this.h, new Color(0, 0, 0, 170).getRGB());
        Gui.drawRect(this.x + 88, this.y, this.x + this.w, this.y + this.h, this.getColor());
        Minecraft.getMinecraft().fontRendererObj.drawString(this.m.name, this.x + 2, this.y + 2, -1);
    }
    
    private ResourceLocation getResourceLocation() {
        if (this.m.isEnabled()) {
            return ModButton.enable_background;
        }
        return ModButton.disable_background;
    }
    
    private void drawBackGround(final int x, final int y, final int w, final int h, final ResourceLocation resource) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }
    
    private void drawVerticalLine(final int xPosition2, final int i, final int yPosition2, final int Color) {
    }
    
    private void drawHorizontalLine(final int xPosition2, final int i, final int j, final int Color) {
    }
    
    public int getColor() {
        if (this.m.isEnabled()) {
            return new Color(0, 255, 0, 255).getRGB();
        }
        return new Color(255, 0, 0, 255).getRGB();
    }
    
    public void onClick(final int mouseX, final int mouseY, final int button) {
        if (mouseX >= this.x && mouseX <= this.x + this.w && mouseY >= this.y && mouseY <= this.y + this.h) {
            if (this.m.isEnabled()) {
                this.m.setEnabled(false);
            }
            else {
                this.m.setEnabled(true);
            }
            System.out.println(String.valueOf(this.m.name) + " " + this.m.enabled + " " + this.getColor());
        }
    }
}
