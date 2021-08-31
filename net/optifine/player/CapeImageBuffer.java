// 
// Decompiled by Procyon v0.5.36
// 

package net.optifine.player;

import java.awt.image.BufferedImage;
import java.lang.ref.WeakReference;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.ImageBufferDownload;

public class CapeImageBuffer extends ImageBufferDownload
{
    private AbstractClientPlayer player;
    private ResourceLocation resourceLocation;
    private boolean elytraOfCape;
    public ImageBufferDownload imageBufferDownload;
    public final WeakReference<AbstractClientPlayer> playerRef;
    
    public CapeImageBuffer(final AbstractClientPlayer player, final ResourceLocation resourceLocation) {
        this.playerRef = new WeakReference<AbstractClientPlayer>(player);
        this.resourceLocation = resourceLocation;
        this.imageBufferDownload = new ImageBufferDownload();
    }
    
    @Override
    public BufferedImage parseUserSkin(final BufferedImage imageRaw) {
        final BufferedImage bufferedimage = CapeUtils.parseCape(imageRaw);
        this.elytraOfCape = CapeUtils.isElytraCape(imageRaw, bufferedimage);
        return bufferedimage;
    }
    
    @Override
    public void skinAvailable() {
        final AbstractClientPlayer player = this.playerRef.get();
        if (player != null) {
            this.setLocationOfCape(player, this.resourceLocation);
        }
        this.cleanup();
    }
    
    private void setLocationOfCape(final AbstractClientPlayer player2, final ResourceLocation resourceLocation2) {
    }
    
    public void cleanup() {
        this.player = null;
    }
    
    public boolean isElytraOfCape() {
        return this.elytraOfCape;
    }
}
