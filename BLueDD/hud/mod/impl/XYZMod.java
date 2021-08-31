// 
// Decompiled by Procyon v0.5.36
// 

package BLueDD.hud.mod.impl;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import java.awt.Color;
import BLueDD.hud.mod.HudMod;

public class XYZMod extends HudMod
{
    public XYZMod() {
        super("XYZ", 99, 99);
    }
    
    @Override
    public int getWidth() {
        return 100;
    }
    
    @Override
    public int getHieght() {
        return 30;
    }
    
    @Override
    public void draw() {
        Gui.drawRect(this.getX() - 1, this.getY() - 1, this.getX() + 60, this.getY() + this.getHieght(), new Color(0, 0, 0, 170).getRGB());
        this.fr.drawString("§3[§bPos X§3] §f" + Math.round(Minecraft.getMinecraft().thePlayer.posX * 1000.0) / 1000L, this.drag.getxPosition() + 2, this.drag.getyPosition() + 2, -1);
        this.fr.drawString("§3[§bPos Y§3] §f" + Math.round(Minecraft.getMinecraft().thePlayer.posY * 1000.0) / 1000L, this.drag.getxPosition() + 2, this.drag.getyPosition() + 12, -1);
        this.fr.drawString("§3[§bPos Z§3] §f" + Math.round(Minecraft.getMinecraft().thePlayer.posZ * 1000.0) / 1000L, this.drag.getxPosition() + 2, this.drag.getyPosition() + 22, -1);
        super.draw();
    }
    
    @Override
    public void renderDummy(final int mouseX, final int mouseY) {
        Gui.drawRect(this.getX() - 1, this.getY() - 1, this.getX() + 60, this.getY() + this.getHieght(), new Color(0, 0, 0, 170).getRGB());
        this.fr.drawString("§3[§bPos X§3] §f" + Math.round(Minecraft.getMinecraft().thePlayer.posX * 1000.0) / 1000L, this.drag.getxPosition() + 2, this.drag.getyPosition() + 2, -1);
        this.fr.drawString("§3[§bPos Y§3] §f" + Math.round(Minecraft.getMinecraft().thePlayer.posY * 1000.0) / 1000L, this.drag.getxPosition() + 2, this.drag.getyPosition() + 12, -1);
        this.fr.drawString("§3[§bPos Z§3] §f" + Math.round(Minecraft.getMinecraft().thePlayer.posZ * 1000.0) / 1000L, this.drag.getxPosition() + 2, this.drag.getyPosition() + 22, -1);
        super.renderDummy(mouseX, mouseY);
    }
}
