// 
// Decompiled by Procyon v0.5.36
// 

package BLueDD.hud.mod.impl;

import net.minecraft.client.settings.KeyBinding;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import java.awt.Color;
import org.lwjgl.opengl.GL11;
import BLueDD.hud.mod.HudMod;

public class ModKeystrokes extends HudMod
{
    private KeystrokesMode mode;
    
    public ModKeystrokes() {
        super("KeyStroke", 90, 50);
        this.mode = KeystrokesMode.WASD_MOUSE;
    }
    
    @Override
    public int getWidth() {
        return 56;
    }
    
    @Override
    public int getHieght() {
        return 28;
    }
    
    @Override
    public void draw() {
        GL11.glPushMatrix();
        Key[] keys;
        for (int length = (keys = this.mode.getKeys()).length, i = 0; i < length; ++i) {
            final Key key = keys[i];
            final int textWidht = this.fr.getStringWidth(key.getName());
            Gui.drawRect(this.getX() + key.getX(), this.getY() + key.getY(), this.getX() + key.getX() + key.getWidht(), this.getY() + key.getY() + key.getHieght(), key.isDown() ? new Color(255, 255, 255, 102).getRGB() : new Color(0, 0, 0, 120).getRGB());
            this.fr.drawStringWithShadow(key.getName(), (float)(this.getX() + key.getX() + key.getWidht() / 2 - textWidht / 2), (float)(this.getY() + key.getY() + key.getHieght() / 2 - 4), key.isDown() ? new Color(0, 255, 255, 255).getRGB() : -1);
        }
        GL11.glPopMatrix();
        super.draw();
    }
    
    @Override
    public void renderDummy(final int mouseX, final int mouseY) {
        GL11.glPushMatrix();
        Key[] keys;
        for (int length = (keys = this.mode.getKeys()).length, i = 0; i < length; ++i) {
            final Key key = keys[i];
            final int textWidht = this.fr.getStringWidth(key.getName());
            Gui.drawRect(this.getX() + key.getX(), this.getY() + key.getY(), this.getX() + key.getX() + key.getWidht(), this.getY() + key.getY() + key.getHieght(), key.isDown() ? new Color(255, 255, 255, 102).getRGB() : new Color(0, 0, 0, 120).getRGB());
            this.fr.drawStringWithShadow(key.getName(), (float)(this.getX() + key.getX() + key.getWidht() / 2 - textWidht / 2), (float)(this.getY() + key.getY() + key.getHieght() / 2 - 4), key.isDown() ? new Color(0, 255, 255, 255).getRGB() : -1);
        }
        GL11.glPopMatrix();
        super.renderDummy(mouseX, mouseY);
    }
    
    public enum KeystrokesMode
    {
        WASD_MOUSE("WASD_MOUSE", 0, new Key[] { Key.W, Key.A, Key.S, Key.D, Key.RBM, Key.LBM });
        
        private final Key[] keys;
        private int width;
        private int height;
        
        private KeystrokesMode(final String name, final int ordinal, final Key... keyIn) {
            this.keys = keyIn;
            Key[] keys;
            for (int length = (keys = this.keys).length, i = 0; i < length; ++i) {
                final Key key = keys[i];
                this.width = Math.max(this.width, key.getX() + key.getWidht());
                this.height = Math.max(this.height, key.getY() + key.getHieght());
            }
        }
        
        public int getWidth() {
            return this.width;
        }
        
        public int getHeight() {
            return this.height;
        }
        
        public Key[] getKeys() {
            return this.keys;
        }
    }
    
    public static class Key
    {
        public static final Minecraft mc;
        private static final Key W;
        private static final Key A;
        private static final Key S;
        private static final Key D;
        private static final Key LBM;
        private static final Key RBM;
        private final String name;
        private final KeyBinding keyBind;
        private final int x;
        private final int y;
        private final int w;
        private final int h;
        
        static {
            mc = Minecraft.getMinecraft();
            W = new Key("W", Key.mc.gameSettings.keyBindForward, 21, 1, 18, 18);
            A = new Key("A", Key.mc.gameSettings.keyBindLeft, 1, 21, 18, 18);
            S = new Key("S", Key.mc.gameSettings.keyBindBack, 21, 21, 18, 18);
            D = new Key("D", Key.mc.gameSettings.keyBindRight, 41, 21, 18, 18);
            LBM = new Key("LMB", Key.mc.gameSettings.keyBindAttack, 1, 41, 28, 18);
            RBM = new Key("RMB", Key.mc.gameSettings.keyBindUseItem, 31, 41, 28, 18);
        }
        
        public Key(final String name, final KeyBinding keyBind, final int x, final int y, final int w, final int h) {
            this.name = name;
            this.keyBind = keyBind;
            this.x = x;
            this.y = y;
            this.w = w;
            this.h = h;
        }
        
        public String getName() {
            return this.name;
        }
        
        public boolean isDown() {
            return this.keyBind.isKeyDown();
        }
        
        public int getHieght() {
            return this.h;
        }
        
        public int getWidht() {
            return this.w;
        }
        
        public int getX() {
            return this.x;
        }
        
        public int getY() {
            return this.y;
        }
    }
}
