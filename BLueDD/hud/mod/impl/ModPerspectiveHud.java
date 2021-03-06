// 
// Decompiled by Procyon v0.5.36
// 

package BLueDD.hud.mod.impl;

import org.lwjgl.opengl.Display;
import BLueDD.event.EventTarget;
import org.lwjgl.input.Keyboard;
import BLueDD.event.impl.KeyEvent;
import BLueDD.hud.mod.HudMod;

public class ModPerspectiveHud extends HudMod
{
    private boolean returnOnRelease;
    private boolean perspectiveToggled;
    private float cameraYaw;
    private float cameraPitch;
    private int previousPerspective;
    
    public ModPerspectiveHud() {
        super("FreeLook [debug]", 10, 20);
        this.returnOnRelease = true;
        this.perspectiveToggled = false;
        this.cameraYaw = 0.0f;
        this.cameraPitch = 0.0f;
        this.previousPerspective = 0;
    }
    
    @EventTarget
    public void keyboardEvent(final KeyEvent e) {
        if (e.getKey() == this.mc.gameSettings.CLIENT_PERSPECTIVE.getKeyCode()) {
            if (Keyboard.getEventKeyState()) {
                this.perspectiveToggled = !this.perspectiveToggled;
                this.cameraYaw = this.mc.thePlayer.rotationYaw;
                this.cameraPitch = this.mc.thePlayer.rotationPitch;
                if (this.perspectiveToggled) {
                    this.previousPerspective = this.mc.gameSettings.thirdPersonView;
                    this.mc.gameSettings.thirdPersonView = 1;
                }
                else {
                    this.mc.gameSettings.thirdPersonView = this.previousPerspective;
                }
            }
            else if (this.returnOnRelease) {
                this.perspectiveToggled = false;
                this.mc.gameSettings.thirdPersonView = this.previousPerspective;
            }
        }
        if (Keyboard.getEventKey() == this.mc.gameSettings.keyBindTogglePerspective.getKeyCode()) {
            this.perspectiveToggled = false;
        }
    }
    
    public float getCameraYaw() {
        return this.perspectiveToggled ? this.cameraYaw : this.mc.thePlayer.rotationYaw;
    }
    
    public float getCameraPitch() {
        return this.perspectiveToggled ? this.cameraPitch : this.mc.thePlayer.rotationPitch;
    }
    
    public boolean overrideMouse() {
        if (this.mc.inGameHasFocus && Display.isActive()) {
            if (!this.perspectiveToggled) {
                return true;
            }
            this.mc.mouseHelper.mouseXYChange();
            final float f1 = this.mc.gameSettings.mouseSensitivity * 0.6f + 0.2f;
            final float f2 = f1 * f1 * f1 * 8.0f;
            final float f3 = this.mc.mouseHelper.deltaX * f2;
            final float f4 = this.mc.mouseHelper.deltaY * f2;
            this.cameraYaw += f3 * 0.15f;
            this.cameraPitch += f4 * 0.15f;
            if (this.cameraPitch > 90.0f) {
                this.cameraPitch = 90.0f;
            }
            if (this.cameraPitch < -90.0f) {
                this.cameraPitch = -90.0f;
            }
        }
        return false;
    }
    
    @Override
    public int getWidth() {
        return this.fr.getStringWidth("[Perspective (Key Held)]");
    }
    
    @Override
    public int getHieght() {
        return this.fr.FONT_HEIGHT;
    }
    
    @Override
    public void draw() {
        if (this.mc.gameSettings.CLIENT_PERSPECTIVE.isPressed()) {
            this.fr.drawString("[Perspective (Key Held)]", this.getX(), this.getY(), -1);
            super.draw();
        }
    }
    
    @Override
    public void renderDummy(final int mouseX, final int mouseY) {
        this.fr.drawString("[Perspective]", this.getX(), this.getY(), -1);
        super.renderDummy(mouseX, mouseY);
    }
}
