// 
// Decompiled by Procyon v0.5.36
// 

package BLueDD;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.OpenGlHelper;
import org.lwjgl.opengl.GL11;
import java.awt.Color;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.Minecraft;

public enum RenderUtil1
{
    instance("instance", 0, "instance", 0);
    
    protected Minecraft mc;
    
    private RenderUtil1(final String name, final int ordinal, final String s, final int n) {
        this.mc = Minecraft.getMinecraft();
    }
    
    public void draw2DImage(final ResourceLocation image, final int x, final int y, final int width, final int height, final Color c) {
        GL11.glDisable(2929);
        GL11.glEnable(3042);
        GL11.glDepthMask(false);
        OpenGlHelper.glBlendFunc(770, 771, 1, 0);
        GL11.glColor4f(c.getRed() / 255.0f, c.getGreen() / 255.0f, c.getBlue() / 255.0f, (float)c.getAlpha());
        this.mc.getTextureManager().bindTexture(image);
        Gui.drawModalRectWithCustomSizedTexture(x, y, 0.0f, 0.0f, width, height, (float)width, (float)height);
        GL11.glDepthMask(true);
        GL11.glDisable(3042);
        GL11.glEnable(2929);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
    }
    
    public boolean isHovered(final double x, final double y, final double width, final double height, final int mouseX, final int mouseY) {
        return mouseX > x && mouseY > y && mouseX < width && mouseY < height;
    }
}
