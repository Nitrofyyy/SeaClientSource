// 
// Decompiled by Procyon v0.5.36
// 

package BLueDD.mod.impl;

import BLueDD.mod.Category;
import BLueDD.hud.mod.HudManager;
import BLueDD.mod.Mod;

public class FullBright extends Mod
{
    public HudManager hm;
    
    public FullBright() {
        super("FullBright", "kjasd", Category.WORLD);
    }
    
    @Override
    public void onEnable() {
        super.onEnable();
        if (this.hm.fullbright.isEnabled()) {
            this.mc.gameSettings.gammaSetting = 100000.0f;
        }
    }
    
    @Override
    public void onDisable() {
        super.onDisable();
        this.mc.gameSettings.gammaSetting = 1.0f;
    }
}
