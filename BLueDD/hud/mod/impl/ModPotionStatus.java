// 
// Decompiled by Procyon v0.5.36
// 

package BLueDD.hud.mod.impl;

import java.util.Iterator;
import java.util.Collection;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.Minecraft;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.Tessellator;
import org.lwjgl.opengl.GL11;
import net.minecraft.client.gui.FontRenderer;
import BLueDD.hud.mod.HudMod;

public class ModPotionStatus extends HudMod
{
    protected FontRenderer fontRendererObj;
    protected float zLevelFloat;
    
    public ModPotionStatus() {
        super("PotionStatus", 40, 50);
    }
    
    public void drawTexturedModalRect(final int x, final int y, final int textureX, final int textureY, final int width, final int height) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        final float f = 0.00390625f;
        final float f2 = 0.00390625f;
        final Tessellator tessellator = Tessellator.getInstance();
        final WorldRenderer worldrenderer = tessellator.getWorldRenderer();
        worldrenderer.begin(7, DefaultVertexFormats.POSITION_TEX);
        worldrenderer.pos(x + 0, y + height, this.zLevelFloat).tex((textureX + 0) * f, (textureY + height) * f2).endVertex();
        worldrenderer.pos(x + width, y + height, this.zLevelFloat).tex((textureX + width) * f, (textureY + height) * f2).endVertex();
        worldrenderer.pos(x + width, y + 0, this.zLevelFloat).tex((textureX + width) * f, (textureY + 0) * f2).endVertex();
        worldrenderer.pos(x + 0, y + 0, this.zLevelFloat).tex((textureX + 0) * f, (textureY + 0) * f2).endVertex();
        tessellator.draw();
    }
    
    @Override
    public void draw() {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        final int offsetX = 21;
        final int offsetY = 14;
        final int i = 80;
        int i2 = 16;
        final Collection<PotionEffect> collection = this.mc.thePlayer.getActivePotionEffects();
        if (!collection.isEmpty()) {
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            GlStateManager.disableLighting();
            int l = 20;
            if (collection.size() > 100) {
                l = 150 / (collection.size() - 10);
            }
            for (final PotionEffect potioneffect : this.mc.thePlayer.getActivePotionEffects()) {
                final Potion potion = Potion.potionTypes[potioneffect.getPotionID()];
                GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
                if (potion.hasStatusIcon()) {
                    Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("textures/gui/container/inventory.png"));
                    final int i3 = potion.getStatusIconIndex();
                    this.drawTexturedModalRect(this.getX() + offsetX - 20, this.getY() + i2 - offsetY, 0 + i3 % 8 * 18, 198 + i3 / 8 * 18, 18, 18);
                }
                String s1 = I18n.format(potion.getName(), new Object[0]);
                if (potioneffect.getAmplifier() == 1) {
                    s1 = String.valueOf(s1) + " " + I18n.format("enchantment.level.2", new Object[0]);
                }
                else if (potioneffect.getAmplifier() == 2) {
                    s1 = String.valueOf(s1) + " " + I18n.format("enchantment.level.3", new Object[0]);
                }
                else if (potioneffect.getAmplifier() == 3) {
                    s1 = String.valueOf(s1) + " " + I18n.format("enchantment.level.4", new Object[0]);
                }
                this.fr.drawString(s1, (float)(this.getX() + offsetX), (float)(this.getY() + i2 - offsetY), -1, true);
                final String s2 = Potion.getDurationString(potioneffect);
                this.fr.drawString(s2, (float)(this.getX() + offsetX), (float)(this.getY() + i2 + 10 - offsetY), -1, true);
                i2 += l;
            }
        }
    }
    
    @Override
    public void renderDummy(final int mouseX, final int mouseY) {
        super.renderDummy(mouseX, mouseY);
        this.fr.drawString("Potion Effects", this.drag.getxPosition(), this.drag.getyPosition(), -1);
    }
}
