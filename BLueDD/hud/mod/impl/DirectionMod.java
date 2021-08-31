// 
// Decompiled by Procyon v0.5.36
// 

package BLueDD.hud.mod.impl;

import net.minecraft.client.gui.Gui;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.MathHelper;
import BLueDD.mod.Mod;
import net.minecraft.client.gui.ScaledResolution;
import BLueDD.hud.mod.HudMod;

public class DirectionMod extends HudMod
{
    protected static ScaledResolution scaledResolution;
    public static String markerColor;
    public static int compassIndex;
    
    static {
        DirectionMod.markerColor = "c";
        DirectionMod.compassIndex = 0;
    }
    
    public DirectionMod() {
        super("Direction", 90, 8);
    }
    
    @Override
    public int getWidth() {
        return 102;
    }
    
    @Override
    public int getHieght() {
        return 15;
    }
    
    @Override
    public void draw() {
        Mod.getModPusula();
        if (Mod.isEnabled()) {
            final int direction = MathHelper.floor_double(this.mc.thePlayer.rotationYaw * 256.0f / 360.0f + 0.5) & 0xFF;
            final int yBase = getY(1, 12);
            final int xBase = getX(65);
            this.mc.getTextureManager().bindTexture(new ResourceLocation("BLueDD/pics/Pusula.png"));
            if (direction < 128) {
                Gui.drawTexturedModalRect(this.drag.getxPosition() + xBase - 64, this.drag.getyPosition() + yBase - 10, direction, DirectionMod.compassIndex * 24, 100, 13);
            }
            else {
                Gui.drawTexturedModalRect(this.drag.getxPosition() + xBase - 64, this.drag.getyPosition() + yBase - 10, direction - 128, DirectionMod.compassIndex * 24 + 12, 100, 13);
            }
            this.mc.fontRendererObj.drawString("§" + DirectionMod.markerColor.toLowerCase() + "|§r", this.drag.getxPosition() + xBase - 16, this.drag.getyPosition() + yBase - 7, 16777215);
            super.draw();
        }
    }
    
    @Override
    public void renderDummy(final int mouseX, final int mouseY) {
        Mod.getModPusula();
        if (Mod.isEnabled()) {
            final int direction = MathHelper.floor_double(this.mc.thePlayer.rotationYaw * 256.0f / 360.0f + 0.5) & 0xFF;
            final int yBase = getY(1, 12);
            final int xBase = getX(65);
            this.mc.getTextureManager().bindTexture(new ResourceLocation("BLueDD/pics/Pusula.png"));
            if (direction < 128) {
                Gui.drawTexturedModalRect(this.drag.getxPosition() + xBase - 64, this.drag.getyPosition() + yBase - 10, direction, DirectionMod.compassIndex * 24, 100, 13);
            }
            else {
                Gui.drawTexturedModalRect(this.drag.getxPosition() + xBase - 64, this.drag.getyPosition() + yBase - 10, direction - 128, DirectionMod.compassIndex * 24 + 12, 100, 13);
            }
            this.mc.fontRendererObj.drawString("§" + DirectionMod.markerColor.toLowerCase() + "|§r", this.drag.getxPosition() + xBase - 16, this.drag.getyPosition() + yBase - 7, 16777215);
            super.renderDummy(mouseX, mouseY);
        }
    }
    
    private static int getX(final int width) {
        return width;
    }
    
    private static int getY(final int rowCount, final int height) {
        return height;
    }
    
    public enum Direction
    {
        S("S", 0), 
        SW("SW", 1), 
        W("W", 2), 
        NW("NW", 3), 
        N("N", 4), 
        NE("NE", 5), 
        E("E", 6), 
        SE("SE", 7);
        
        private Direction(final String name, final int ordinal) {
        }
    }
}
