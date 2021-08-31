// 
// Decompiled by Procyon v0.5.36
// 

package BLueDD.hud.mod.impl;

import net.minecraft.client.gui.Gui;
import java.awt.Color;
import BLueDD.hud.mod.HudMod;

public class PingMod extends HudMod
{
    public PingMod() {
        super("Ping", 100, 80);
    }
    
    @Override
    public void draw() {
        if (this.enabled) {
            Gui.drawRect(this.getX() - 2, this.getY() - 2, this.getX() + this.getWidth(), this.getY() + this.getHieght(), new Color(0, 0, 0, 170).getRGB());
            if (this.mc.getCurrentServerData() == null) {
                new Gui();
                Gui.drawCenteredString(this.fr, "ms -1", (float)(this.getX() + this.getWidth() / 2), (float)(this.getY() + 1), -1);
            }
            else {
                new Gui();
                Gui.drawCenteredString(this.fr, "ms : " + this.mc.getCurrentServerData().pingToServer, (float)(this.getX() + this.getWidth() / 2), (float)(this.getY() + 1), -1);
            }
        }
    }
    
    @Override
    public void renderDummy(final int mouseX, final int mouseY) {
        Gui.drawRect(this.getX() - 2, this.getY() - 2, this.getX() + this.getWidth(), this.getY() + this.getHieght(), new Color(0, 0, 0, 170).getRGB());
        if (this.mc.getCurrentServerData() == null) {
            new Gui();
            Gui.drawCenteredString(this.fr, "ms -1", (float)(this.getX() + this.getWidth() / 2), (float)(this.getY() + 1), -1);
        }
        else {
            new Gui();
            Gui.drawCenteredString(this.fr, "Ping", (float)(this.getX() + this.getWidth() / 2), (float)(this.getY() + 1), -1);
        }
        super.renderDummy(mouseX, mouseY);
    }
    
    @Override
    public int getWidth() {
        if (this.mc.getCurrentServerData() != null) {
            return this.fr.getStringWidth("999 ms") + 8;
        }
        return this.fr.getStringWidth("Ping ms");
    }
    
    @Override
    public int getHieght() {
        return 10;
    }
}
