// 
// Decompiled by Procyon v0.5.36
// 

package BLueDD.hud.mod;

import java.io.IOException;
import BLueDD.ClickGUI.ClickGUI;
import java.util.Iterator;
import BLueDD.Client;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

public class HUDConfigScreen extends GuiScreen
{
    @Override
    public void initGui() {
        super.initGui();
        this.buttonList.add(new GuiButton(6340, HUDConfigScreen.width / 2 - 50, HUDConfigScreen.height / 2 - 10, 100, 20, "ClickGui"));
    }
    
    @Override
    public void drawScreen(final int mouseX, final int mouseY, final float partialTicks) {
        this.drawDefaultBackground();
        for (final HudMod m : Client.INSTANCE.hudManager.hudMods) {
            if (m.isEnabled()) {
                m.renderDummy(mouseX, mouseY);
            }
        }
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
    
    @Override
    protected void actionPerformed(final GuiButton button) throws IOException {
        switch (button.id) {
            case 6340: {
                this.mc.displayGuiScreen(new ClickGUI());
                break;
            }
        }
        final int id = button.id;
        super.actionPerformed(button);
    }
}
