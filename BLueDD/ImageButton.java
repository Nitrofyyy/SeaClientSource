// 
// Decompiled by Procyon v0.5.36
// 

package BLueDD;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;

public class ImageButton
{
    protected ResourceLocation image;
    protected int height;
    protected int ani;
    protected Minecraft mc;
    protected int x;
    protected int width;
    protected int target;
    protected int y;
    protected String description;
    
    public ImageButton(final ResourceLocation image, final int x, final int y, final int width, final int height, final String description, final int target) {
        this.ani = "".length();
        this.image = image;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.description = description;
        this.target = target;
        this.mc = Minecraft.getMinecraft();
    }
}
