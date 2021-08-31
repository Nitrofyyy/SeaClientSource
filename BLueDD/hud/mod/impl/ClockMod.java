// 
// Decompiled by Procyon v0.5.36
// 

package BLueDD.hud.mod.impl;

import java.time.temporal.TemporalAccessor;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import BLueDD.Rainbow;
import net.minecraft.client.gui.Gui;
import java.awt.Color;
import BLueDD.hud.mod.HudMod;

public class ClockMod extends HudMod
{
    public ClockMod() {
        super("Clock", 70, 70);
    }
    
    @Override
    public int getWidth() {
        return this.fr.getStringWidth(this.getTime());
    }
    
    @Override
    public int getHieght() {
        return this.fr.FONT_HEIGHT;
    }
    
    @Override
    public void renderDummy(final int mouseX, final int mouseY) {
        Gui.drawRect(this.getX() - 2, this.getY() - 2, this.getX() + this.getWidth() + 15, this.getY() + this.getHieght(), new Color(0, 0, 0, 170).getRGB());
        this.fr.drawStringWithShadow("§3[§f" + this.getTime() + "§3]§f", (float)(this.drag.getxPosition() + 1), (float)(this.drag.getyPosition() + 1), Rainbow.getChromaColor());
        super.renderDummy(mouseX, mouseY);
    }
    
    @Override
    public void draw() {
        Gui.drawRect(this.getX() - 2, this.getY() - 2, this.getX() + this.getWidth() + 15, this.getY() + this.getHieght(), new Color(0, 0, 0, 170).getRGB());
        this.fr.drawStringWithShadow("§3[§f" + this.getTime() + "§3]§f", (float)(this.drag.getxPosition() + 1), (float)(this.drag.getyPosition() + 1), Rainbow.getChromaColor());
        super.draw();
    }
    
    private String getTime() {
        final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("[ h:mm a]");
        final LocalDateTime localtime = LocalDateTime.now();
        return dtf.format(localtime);
    }
}
