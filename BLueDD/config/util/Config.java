// 
// Decompiled by Procyon v0.5.36
// 

package BLueDD.config.util;

import java.util.Iterator;
import java.io.IOException;
import BLueDD.hud.mod.HudMod;
import BLueDD.Client;
import java.io.File;

public class Config
{
    public File configFolder;
    public File modsFolder;
    public Configuration config;
    public Configuration configToSave;
    
    public Config() {
        this.configFolder = new File("SeaClient");
        this.modsFolder = new File("SeaClient/Mods");
        this.configToSave = ConfigurationAPI.newConfiguration(new File("SeaClient/Mods/Mods.json"));
    }
    
    public void saveModConfig() {
        if (!this.configFolder.exists()) {
            this.configFolder.mkdirs();
        }
        if (!this.modsFolder.exists()) {
            this.modsFolder.mkdirs();
        }
        System.out.println("Saving Mod Config");
        for (final HudMod m : Client.INSTANCE.hudManager.hudMods) {
            this.configToSave.set(String.valueOf(m.name) + " x", m.getX());
            this.configToSave.set(String.valueOf(m.name) + " y", m.getY());
            this.configToSave.set(String.valueOf(m.name) + " enabled", m.isEnabled());
        }
        try {
            this.configToSave.save();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void loadModConfig() {
        try {
            System.out.println("Loading Mod Config");
            this.config = ConfigurationAPI.loadExistingConfiguration(new File("SeaClient/Mods/Mods.json"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
