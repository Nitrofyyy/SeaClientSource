// 
// Decompiled by Procyon v0.5.36
// 

package BLueDD.mod.impl;

import java.io.IOException;
import org.lwjgl.input.Keyboard;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.GuiScreen;

public final class GuiWatchdogReport extends GuiScreen
{
    private final GuiScreen previousScreen;
    private GuiTextField username;
    
    public GuiWatchdogReport(final GuiScreen previousScreen) {
        this.previousScreen = previousScreen;
    }
    
    @Override
    protected void actionPerformed(final GuiButton button) {
        if (button.id == 0) {
            this.mc.thePlayer.sendChatMessage("/wdr " + this.username.getText() + " " + "Speed");
        }
        if (button.id == 1) {
            this.mc.thePlayer.sendChatMessage("/wdr " + this.username.getText() + " " + "KillAura");
        }
    }
    
    @Override
    public void drawScreen(final int x2, final int y2, final float z2) {
        final ScaledResolution sr = new ScaledResolution(this.mc);
        this.username.drawTextBox();
        Gui.drawCenteredString(this.mc.fontRendererObj, "Watchdog Report!", (float)(int)(GuiWatchdogReport.width / 2.0f), (float)(sr.getScaledHeight() / 2 - 65), -1);
        super.drawScreen(x2, y2, z2);
    }
    
    @Override
    public void initGui() {
        final ScaledResolution sr = new ScaledResolution(this.mc);
        this.buttonList.clear();
        this.buttonList.add(new GuiButton(0, GuiWatchdogReport.width / 2 - 50, GuiWatchdogReport.height / 2 - 20, 98, 20, I18n.format("Speed", new Object[0])));
        this.buttonList.add(new GuiButton(1, GuiWatchdogReport.width / 2 - 50, GuiWatchdogReport.height / 2 + 5, 98, 20, I18n.format("KillAura", new Object[0])));
        (this.username = new GuiTextField(100, this.fontRendererObj, GuiWatchdogReport.width / 2 - 50, sr.getScaledHeight() / 2 - 50, 100, 20)).setFocused(true);
        Keyboard.enableRepeatEvents(true);
    }
    
    @Override
    protected void keyTyped(final char character, final int key) {
        try {
            super.keyTyped(character, key);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        if (character == '\t' && !this.username.isFocused()) {
            this.username.setFocused(true);
        }
        if (character == '\r') {
            this.actionPerformed(this.buttonList.get(0));
        }
        this.username.textboxKeyTyped(character, key);
    }
    
    @Override
    protected void mouseClicked(final int x2, final int y2, final int button) {
        try {
            super.mouseClicked(x2, y2, button);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        this.username.mouseClicked(x2, y2, button);
    }
    
    @Override
    public void onGuiClosed() {
        Keyboard.enableRepeatEvents(false);
    }
    
    @Override
    public void updateScreen() {
        this.username.updateCursorCounter();
    }
}
