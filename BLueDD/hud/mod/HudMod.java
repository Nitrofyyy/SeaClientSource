// 
// Decompiled by Procyon v0.5.36
// 

package BLueDD.hud.mod;

import BLueDD.event.EventManager;
import java.util.Arrays;
import java.awt.Color;
import BLueDD.Client;
import BLueDD.settings.Settings;
import java.util.ArrayList;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.Minecraft;

public class HudMod
{
    public Minecraft mc;
    public FontRenderer fr;
    ArrayList<Settings> settings;
    public String name;
    public boolean enabled;
    public boolean disable;
    public DraggableComponent drag;
    public int x;
    public int y;
    
    public HudMod(final String name, final int x, final int y) {
        this.mc = Minecraft.getMinecraft();
        this.fr = this.mc.fontRendererObj;
        this.enabled = true;
        this.disable = false;
        this.name = name;
        try {
            this.x = (int)Client.INSTANCE.config.config.get(String.valueOf(name) + " x");
            this.y = (int)Client.INSTANCE.config.config.get(String.valueOf(name) + " y");
            this.setEnabled((boolean)Client.INSTANCE.config.config.get(String.valueOf(name) + " enabled"));
        }
        catch (NullPointerException e) {
            e.printStackTrace();
            this.x = x;
            this.y = y;
            this.enabled = false;
        }
        this.settings = new ArrayList<Settings>();
        this.drag = new DraggableComponent(this.x, this.y, this.getWidth(), y + this.getHieght(), new Color(0, 0, 0, 0).getRGB());
    }
    
    public void addSettings(final Settings... sets) {
        this.settings.add((Settings)Arrays.asList(sets));
    }
    
    public int getWidth() {
        return 50;
    }
    
    public int getHieght() {
        return 50;
    }
    
    public void draw() {
    }
    
    public void renderDummy(final int mouseX, final int mouseY) {
        this.drag.draw(mouseX, mouseY);
    }
    
    public int getX() {
        return this.drag.getxPosition();
    }
    
    public void onEnable() {
        final EventManager eventManager = Client.INSTANCE.eventManager;
        EventManager.register(this);
    }
    
    public void onDisable() {
        final EventManager eventManager = Client.INSTANCE.eventManager;
        EventManager.register(this);
    }
    
    public int getY() {
        return this.drag.getyPosition();
    }
    
    public void setEnabled(final boolean enabled) {
        this.enabled = enabled;
    }
    
    public void toggle() {
        this.setEnabled(!this.enabled);
    }
    
    public boolean isEnabled() {
        return this.enabled;
    }
    
    public boolean isDisabled() {
        return this.disable;
    }
}
