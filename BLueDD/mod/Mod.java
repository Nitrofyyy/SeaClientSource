// 
// Decompiled by Procyon v0.5.36
// 

package BLueDD.mod;

import BLueDD.hud.mod.impl.ModPerspectiveHud;
import BLueDD.event.EventManager;
import BLueDD.Client;
import net.minecraft.client.Minecraft;

public class Mod
{
    public Minecraft mc;
    public String name;
    public String description;
    public static boolean enabled;
    public static Object autoGG;
    public Category category;
    
    public Mod(final String name, final String description, final Category category) {
        this.mc = Minecraft.getMinecraft();
        this.name = name;
        this.description = description;
        this.category = category;
        Mod.enabled = true;
    }
    
    public void onEnable() {
        final EventManager eventManager = Client.INSTANCE.eventManager;
        EventManager.register(this);
    }
    
    public void onDisable() {
        final EventManager eventManager = Client.INSTANCE.eventManager;
        EventManager.register(this);
    }
    
    public void setEnable(final boolean enabled) {
        Mod.enabled = enabled;
        if (enabled) {
            this.onEnable();
        }
        else {
            this.onDisable();
        }
    }
    
    public void toggle() {
        this.setEnable(!Mod.enabled);
    }
    
    public static boolean isEnabled() {
        return Mod.enabled;
    }
    
    public void setEnabled(final boolean enabled) {
        Mod.enabled = enabled;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public Category getCategory() {
        return this.category;
    }
    
    public static Mod getModPusula() {
        return null;
    }
    
    public static Mod getModZoom() {
        return null;
    }
    
    public static Mod getAnime() {
        return null;
    }
    
    public static Object Block() {
        return null;
    }
    
    public static ModPerspectiveHud getModPerspective() {
        return new ModPerspectiveHud();
    }
}
