// 
// Decompiled by Procyon v0.5.36
// 

package BLueDD.hud.mod.impl;

import net.minecraft.client.gui.Gui;
import java.awt.Color;
import org.lwjgl.input.Mouse;
import java.util.ArrayList;
import java.util.List;
import BLueDD.hud.mod.HudMod;

public class CPSMod extends HudMod
{
    private List<Long> leftClicks;
    private List<Long> rightClicks;
    private boolean leftWasPressed;
    private boolean rightWasPressed;
    private long leftLastPressed;
    private long rightLastPressed;
    
    public CPSMod() {
        super("CPSMod", 50, 50);
        this.leftClicks = new ArrayList<Long>();
        this.rightClicks = new ArrayList<Long>();
    }
    
    @Override
    public void draw() {
        final boolean leftPressed = Mouse.isButtonDown(0);
        final boolean rightPressed = Mouse.isButtonDown(1);
        if (leftPressed != this.leftWasPressed) {
            this.leftLastPressed = System.currentTimeMillis();
            this.leftWasPressed = leftPressed;
            if (leftPressed) {
                this.leftClicks.add(this.leftLastPressed);
            }
        }
        else if (rightPressed != this.rightWasPressed) {
            this.rightLastPressed = System.currentTimeMillis();
            if (this.rightWasPressed = rightPressed) {
                this.rightClicks.add(this.rightLastPressed);
            }
        }
        if (this.leftClicks != null) {
            Gui.drawRect(this.getX() - 2, this.getY() - 2, this.getX() + this.getWidth(), this.getY() + this.getHieght(), new Color(0, 0, 0, 170).getRGB());
            this.fr.drawStringWithShadow(String.valueOf(this.getLeftCPS()) + " | " + this.getRightCPS(), (float)this.getX(), (float)this.getY(), -1);
        }
        else {
            Gui.drawRect(this.getX() - 2, this.getY() - 2, this.getX() + this.getWidth(), this.getY() + this.getHieght(), new Color(0, 0, 0, 170).getRGB());
            this.fr.drawStringWithShadow("1 | 1", (float)this.getX(), (float)this.getY(), -1);
        }
        super.draw();
    }
    
    @Override
    public void renderDummy(final int mouseX, final int mouseY) {
        if (this.leftClicks != null) {
            Gui.drawRect(this.getX() - 2, this.getY() - 2, this.getX() + this.getWidth(), this.getY() + this.getHieght(), new Color(0, 0, 0, 170).getRGB());
            this.fr.drawStringWithShadow(String.valueOf(this.getLeftCPS()) + " | " + this.getRightCPS(), (float)this.getX(), (float)this.getY(), -1);
        }
        else {
            Gui.drawRect(this.getX() - 2, this.getY() - 2, this.getX() + this.getWidth(), this.getY() + this.getHieght(), new Color(0, 0, 0, 170).getRGB());
            this.fr.drawStringWithShadow("1 | 1 CPS ", (float)this.getX(), (float)this.getY(), -1);
        }
        super.renderDummy(mouseX, mouseY);
    }
    
    @Override
    public int getWidth() {
        if (this.leftClicks != null) {
            this.fr.drawStringWithShadow(String.valueOf(this.getLeftCPS()) + " | " + this.getRightCPS(), (float)this.getX(), (float)this.getY(), -1);
        }
        return this.fr.getStringWidth("1 | 1") + 1;
    }
    
    @Override
    public int getHieght() {
        return this.fr.FONT_HEIGHT + 1;
    }
    
    private int getLeftCPS() {
        final long leftTime = System.currentTimeMillis() + 100L;
        this.leftClicks.removeIf(beenLeftTime -> beenLeftTime + 1200L < leftTime + 200L);
        return this.leftClicks.size();
    }
    
    private int getRightCPS() {
        final long rightTime = System.currentTimeMillis() + 100L;
        this.rightClicks.removeIf(beenRightTime -> beenRightTime + 1200L < rightTime + 200L);
        return this.rightClicks.size();
    }
}
