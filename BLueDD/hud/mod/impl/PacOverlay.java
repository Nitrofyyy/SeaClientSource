// 
// Decompiled by Procyon v0.5.36
// 

package BLueDD.hud.mod.impl;

import java.util.Iterator;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.gui.Gui;
import java.awt.Color;
import net.minecraft.client.resources.ResourcePackRepository;
import java.util.List;
import com.google.common.collect.Lists;
import net.minecraft.client.gui.FontRenderer;
import BLueDD.hud.mod.HudMod;

public class PacOverlay extends HudMod
{
    private static final FontRenderer Gapple;
    int width;
    
    static {
        Gapple = null;
    }
    
    public PacOverlay() {
        super("PackDisplay", 5, 5);
    }
    
    @Override
    public int getWidth() {
        return this.width;
    }
    
    @Override
    public int getHieght() {
        return this.mc.getResourcePackRepository().getRepositoryEntries().size() * 32 + (this.mc.getResourcePackRepository().getRepositoryEntries().size() - 1) * 2;
    }
    
    @Override
    public void draw() {
        this.width = 0;
        final int offset = 0;
        for (final ResourcePackRepository.Entry entry : Lists.reverse((List)this.mc.getResourcePackRepository().getRepositoryEntries())) {
            this.width = Math.max(this.width, this.mc.fontRendererObj.getStringWidth(entry.getResourcePackName()) + 38);
            final List<String> list = this.mc.fontRendererObj.listFormattedStringToWidth(entry.getTexturePackDescription(), 157);
            for (int l = 0; l < 2 && l < list.size(); ++l) {
                this.width = Math.max(this.width, this.mc.fontRendererObj.getStringWidth(list.get(l)) + 38);
            }
        }
        for (final ResourcePackRepository.Entry entry : Lists.reverse((List)this.mc.getResourcePackRepository().getRepositoryEntries())) {
            this.drawRect(this.drag.getxPosition(), this.drag.getyPosition() + offset, this.drag.getxPosition() + this.width, this.drag.getxPosition() + offset + 32, new Color(0, 0, 0, 100).getRGB());
            final List<String> list = this.mc.fontRendererObj.listFormattedStringToWidth(entry.getTexturePackDescription(), 157);
            final FontRenderer font = this.fr;
            font.drawString(entry.getResourcePackName(), (float)(this.drag.getxPosition() + 36), this.drag.getyPosition() + 0 + offset + 1.0f, 16777215, true);
            for (int i = 0; i < 2 && i < list.size(); ++i) {
                Gui.drawString(list.get(i), this.drag.getxPosition() + 36, this.drag.getyPosition() + offset + 11.0f + 10 * i, 8421504, true);
                entry.bindTexturePackIcon(this.mc.getTextureManager());
                GlStateManager.pushMatrix();
                GlStateManager.enableBlend();
                GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
                GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
                Gui.drawModalRectWithCustomSizedTexture(this.drag.getxPosition(), this.drag.getyPosition() + offset, 0.0f, 0.0f, 32, 32, 32.0f, 32.0f);
                GlStateManager.enableTexture2D();
                GlStateManager.popMatrix();
            }
            super.draw();
        }
    }
    
    private void drawRect(final int getxPosition, final int i, final int j, final int k, final int rgb) {
    }
    
    @Override
    public void renderDummy(final int mouseX, final int mouseY) {
        for (final ResourcePackRepository.Entry entry : Lists.reverse((List)this.mc.getResourcePackRepository().getRepositoryEntries())) {
            this.fr.drawStringWithShadow(new StringBuilder().append(entry.getResourcePackName()).toString(), (float)this.drag.getxPosition(), (float)this.drag.getyPosition(), -1);
        }
        super.renderDummy(mouseX, mouseY);
    }
}
