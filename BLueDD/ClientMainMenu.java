// 
// Decompiled by Procyon v0.5.36
// 

package BLueDD;

import java.io.IOException;
import BLueDD.Login.GuiAltLogin;
import net.minecraft.client.gui.GuiOptions;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiSelectWorld;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.gui.ScaledResolution;
import BLueDD.cosmetic.AnimatedResourceLocation;
import net.minecraft.client.gui.GuiScreen;

public class ClientMainMenu extends GuiScreen
{
    public static AnimatedResourceLocation AD;
    
    static {
        ClientMainMenu.AD = new AnimatedResourceLocation("BLueDD/backgrounds", 14, 2);
    }
    
    @Override
    public void drawScreen(final int mouseX, final int mouseY, final float partialTicks) {
        final ScaledResolution sr = new ScaledResolution(this.mc);
        this.mc.getTextureManager().bindTexture(new ResourceLocation("BLueDD/backgrounds/ea.jpeg"));
        Gui.drawModalRectWithCustomSizedTexture(0, 0, 0.0f, 0.0f, ClientMainMenu.width, ClientMainMenu.height, (float)ClientMainMenu.width, (float)ClientMainMenu.height);
        GlStateManager.pushMatrix();
        GlStateManager.translate(-(ClientMainMenu.width / 2.0f), -(ClientMainMenu.height / 2.0f), 0.0f);
        Gui.drawModalRectWithCustomSizedTexture(ClientMainMenu.width / 2, ClientMainMenu.height / 2, 0.0f, 0.0f, 0, 0, 0.0f, 0.0f);
        GlStateManager.popMatrix();
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.mc.getTextureManager().bindTexture(new ResourceLocation("BLueDD/logo.png"));
    }
    
    @Override
    public void initGui() {
        final ScaledResolution sr = new ScaledResolution(this.mc);
        final String strText = new StringBuilder().append(EnumChatFormatting.GREEN).append(EnumChatFormatting.BOLD).append(this.mc.getSession().getUsername()).append(EnumChatFormatting.RESET).toString();
        this.buttonList.add(new GuiButton(1, 157, ClientMainMenu.height / 2 - 25, 100, 20, "Singleplayer"));
        this.buttonList.add(new GuiButton(2, 157, ClientMainMenu.height / 2 - 3, 100, 20, "Multiplayer"));
        this.buttonList.add(new GuiButton(3, 180, ClientMainMenu.height / 2 + 100, 50, 20, "Settings"));
        this.buttonList.add(new GuiButton(4, 410, ClientMainMenu.height / 2 - 118, 16, 17, "X"));
        this.buttonList.add(new GuiButton(6, 0, 2, 75, 20, strText));
        this.buttonList.add(new GuiButton(5, 0, ClientMainMenu.height / 2 + 100, 67, 20, "§c Subscribe!§r"));
        this.buttonList.add(new GuiButton(7, 359, ClientMainMenu.height / 2 + 100, 67, 20, "§5Discord§r"));
        this.buttonList.add(new GuiButton(8, 359, ClientMainMenu.height / 2 + 80, 67, 20, "§3Website§r"));
        super.initGui();
    }
    
    @Override
    protected void actionPerformed(final GuiButton button) throws IOException {
        if (button.id == 1) {
            this.mc.displayGuiScreen(new GuiSelectWorld(this));
        }
        if (button.id == 2) {
            this.mc.displayGuiScreen(new GuiMultiplayer(this));
        }
        if (button.id == 3) {
            this.mc.displayGuiScreen(new GuiOptions(this, this.mc.gameSettings));
        }
        switch (button.id) {
            case 4: {
                this.mc.shutdown();
                break;
            }
        }
        if (button.id == 5) {
            LinkOpener.openLink("https://www.youtube.com/channel/UCWizzKz7F12MNs6nVk0Dmew");
        }
        if (button.id == 6) {
            this.mc.displayGuiScreen(new GuiAltLogin(this));
        }
        if (button.id == 7) {
            LinkOpener.openLink("https://discord.io/BLueDD");
        }
        if (button.id == 8) {
            LinkOpener.openLink("http://seaclient.ml/");
        }
    }
}
