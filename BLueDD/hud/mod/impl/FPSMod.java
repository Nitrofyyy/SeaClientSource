// 
// Decompiled by Procyon v0.5.36
// 

package BLueDD.hud.mod.impl;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import java.awt.Color;
import BLueDD.hud.mod.HudMod;

public class FPSMod extends HudMod
{
    public FPSMod() {
        super("FPSMod", 5, 5);
    }
    
    @Override
    public void draw() {
        Gui.drawRect(this.getX() - 2, this.getY() - 2, this.getX() + this.getWidth(), this.getY() + this.getHieght(), new Color(0, 0, 0, 170).getRGB());
        this.fr.drawStringWithShadow("§3[§bFPS §f" + Minecraft.getDebugFPS() + "§3]§f", (float)this.getX(), (float)this.getY(), -1);
        super.draw();
    }
    
    @Override
    public void renderDummy(final int mouseX, final int mouseY) {
        Gui.drawRect(this.getX() - 2, this.getY() - 2, this.getX() + this.getWidth(), this.getY() + this.getHieght(), new Color(0, 0, 0, 170).getRGB());
        this.fr.drawStringWithShadow("§3[§bFPS §f" + Minecraft.getDebugFPS() + "§3]§f", (float)this.getX(), (float)this.getY(), -1);
        super.renderDummy(mouseX, mouseY);
    }
    
    @Override
    public int getWidth() {
        return this.fr.getStringWidth("Fps§b[ §f" + Minecraft.getDebugFPS() + "§b]§f");
    }
    
    @Override
    public int getHieght() {
        return this.fr.FONT_HEIGHT;
    }
}
