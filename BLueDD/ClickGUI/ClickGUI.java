// 
// Decompiled by Procyon v0.5.36
// 

package BLueDD.ClickGUI;

import java.io.IOException;
import java.util.Iterator;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.gui.Gui;
import java.awt.Color;
import net.minecraft.client.gui.ScaledResolution;
import BLueDD.hud.mod.HudMod;
import BLueDD.Client;
import java.util.ArrayList;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;

public class ClickGUI extends GuiScreen
{
    Minecraft mc;
    ArrayList<ModButton> modButtons;
    
    public ClickGUI() {
        this.mc = Minecraft.getMinecraft();
        this.modButtons = new ArrayList<ModButton>();
    }
    
    @Override
    public void initGui() {
        this.modButtons.add(new ModButton(0, 50, 100, 8, Client.INSTANCE.hudManager.FPSMod));
        this.modButtons.add(new ModButton(0, 60, 100, 8, Client.INSTANCE.hudManager.ClockMod));
        this.modButtons.add(new ModButton(0, 70, 100, 8, Client.INSTANCE.hudManager.DirectionMod));
        this.modButtons.add(new ModButton(0, 80, 100, 8, Client.INSTANCE.hudManager.DisplayPack));
        this.modButtons.add(new ModButton(0, 90, 100, 8, Client.INSTANCE.hudManager.CPSMod));
        this.modButtons.add(new ModButton(0, 100, 100, 8, Client.INSTANCE.hudManager.armor));
        this.modButtons.add(new ModButton(0, 110, 100, 8, Client.INSTANCE.hudManager.ping));
        this.modButtons.add(new ModButton(0, 120, 100, 8, Client.INSTANCE.hudManager.pot));
        this.modButtons.add(new ModButton(0, 130, 100, 8, Client.INSTANCE.hudManager.zyz));
        this.modButtons.add(new ModButton(0, 140, 100, 8, Client.INSTANCE.hudManager.key));
        this.modButtons.add(new ModButton(0, 150, 100, 8, Client.INSTANCE.hudManager.mini));
        this.modButtons.add(new ModButton(0, 160, 100, 8, Client.INSTANCE.hudManager.fullbright));
        this.modButtons.add(new ModButton(0, 170, 100, 8, Client.INSTANCE.hudManager.sprint));
        this.modButtons.add(new ModButton(0, 180, 100, 8, Client.INSTANCE.hudManager.freelook));
        super.initGui();
    }
    
    @Override
    public void drawScreen(final int mouseX, final int mouseY, final float partialTicks) {
        final ScaledResolution sr = new ScaledResolution(this.mc);
        final FontRenderer fr = this.mc.fontRendererObj;
        super.drawScreen(mouseX, mouseY, partialTicks);
        Gui.drawRect(127, 0, sr.getScaledWidth() - 270, sr.getScaledHeight() - 0, new Color(0, 51, 153, 255).getRGB());
        Gui.drawRect(0, 0, sr.getScaledWidth() - 300, sr.getScaledHeight() - 0, new Color(0, 0, 0, 170).getRGB());
        this.mc.getTextureManager().bindTexture(new ResourceLocation("BLueDD/logo_Inventory.png"));
        GlStateManager.pushMatrix();
        GlStateManager.translate(0.0f, 0.0f, 0.0f);
        GlStateManager.scale(2.0f, 2.0f, 1.0f);
        GlStateManager.translate(-14.0f, 0.0f, 0.0f);
        Gui.drawCenteredString(fr, "SeaClient", 40.0f, 10.0f, -1);
        GlStateManager.popMatrix();
        for (final ModButton m : this.modButtons) {
            m.draw();
        }
    }
    
    @Override
    protected void mouseClicked(final int mouseX, final int mouseY, final int mouseButton) throws IOException {
        super.mouseClicked(mouseX, mouseY, mouseButton);
        for (final ModButton m : this.modButtons) {
            m.onClick(mouseX, mouseY, mouseButton);
        }
    }
}
