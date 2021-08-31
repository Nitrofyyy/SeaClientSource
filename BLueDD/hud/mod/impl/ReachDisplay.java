// 
// Decompiled by Procyon v0.5.36
// 

package BLueDD.hud.mod.impl;

import net.minecraft.event.ClickEvent;
import java.text.DecimalFormat;
import BLueDD.event.EventTarget;
import net.minecraft.util.Vec3;
import BLueDD.event.EventAttack;
import net.minecraft.entity.Entity;
import BLueDD.hud.mod.HudMod;

public class ReachDisplay extends HudMod
{
    String ReachDisplay;
    private long lastAttack;
    private boolean enabled;
    private int decimals;
    private Entity entity;
    
    public ReachDisplay() {
        super("Reach", 10, 40);
        this.ReachDisplay = "Reach: ";
        this.enabled = true;
    }
    
    @Override
    public int getHieght() {
        return 50;
    }
    
    @Override
    public int getWidth() {
        return 50;
    }
    
    @Override
    public void draw() {
        this.fr.drawStringWithShadow(this.ReachDisplay, (float)this.getX(), (float)this.getY(), -1);
        super.draw();
    }
    
    @Override
    public void renderDummy(final int mouseX, final int mouseY) {
        this.fr.drawStringWithShadow("Reach", (float)this.getX(), (float)this.getY(), -1);
        super.renderDummy(mouseX, mouseY);
    }
    
    @EventTarget
    public void onHit(final EventAttack event) {
        final Vec3 vec3 = this.mc.getRenderViewEntity().getPositionEyes(1.0f);
        final double hitRange = this.mc.objectMouseOver.hitVec.distanceTo(vec3);
        this.ReachDisplay = String.valueOf(this.getFormatter().format(hitRange)) + " blocks";
        this.lastAttack = System.nanoTime();
    }
    
    private DecimalFormat getFormatter() {
        final StringBuilder format = new StringBuilder("0.");
        for (int i = 0; this.decimals > i; ++i) {
            format.append('0');
        }
        return new DecimalFormat(format.toString());
    }
    
    @EventTarget
    public void onTick(final ClickEvent event) {
        if (System.nanoTime() - this.lastAttack >= 2.0E9 && this.enabled) {
            this.ReachDisplay = "Hasn't attacked";
        }
    }
}
