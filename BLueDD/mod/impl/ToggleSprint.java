// 
// Decompiled by Procyon v0.5.36
// 

package BLueDD.mod.impl;

import BLueDD.event.EventTarget;
import BLueDD.event.impl.EventUpdate;
import BLueDD.mod.Category;
import net.minecraft.client.Minecraft;
import BLueDD.mod.Mod;

public class ToggleSprint extends Mod
{
    public Minecraft mc;
    
    public ToggleSprint() {
        super("Toggle Sprint", "Toggles your sprinting.", Category.MISC);
        this.mc = Minecraft.getMinecraft();
    }
    
    @EventTarget
    private void onUpdate(final EventUpdate event) {
        if (Mod.isEnabled() && !this.mc.thePlayer.isBlocking() && !this.mc.thePlayer.isSneaking() && !this.mc.gameSettings.keyBindBack.isKeyDown() && this.mc.gameSettings.keyBindForward.isKeyDown() && !this.mc.thePlayer.isEating() && !this.mc.thePlayer.isPotionActive(15)) {
            this.mc.thePlayer.setSprinting(true);
        }
    }
    
    @Override
    public void onDisable() {
        super.onDisable();
        this.mc.thePlayer.setSprinting(false);
    }
}
