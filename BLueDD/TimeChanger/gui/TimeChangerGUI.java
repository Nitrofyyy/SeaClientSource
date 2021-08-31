// 
// Decompiled by Procyon v0.5.36
// 

package BLueDD.TimeChanger.gui;

import java.io.IOException;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.Gui;
import java.awt.Color;
import net.minecraft.client.gui.ScaledResolution;
import BLueDD.TimeChanger.TimeType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;

public class TimeChangerGUI extends GuiScreen
{
    public static Minecraft mc;
    public double fastTimeMultiplier;
    public TimeType timeType;
    
    public TimeChangerGUI() {
        TimeChangerGUI.mc = Minecraft.getMinecraft();
        this.fastTimeMultiplier = 1.0;
        this.timeType = TimeType.VANILLA;
    }
    
    @Override
    public void drawScreen(final int mouseX, final int mouseY, final float partialTicks) {
        final ScaledResolution sr = new ScaledResolution(TimeChangerGUI.mc);
        super.drawScreen(mouseX, mouseY, partialTicks);
        Gui.drawRect(21, 10, sr.getScaledWidth() - 21, sr.getScaledHeight() - 0, new Color(0, 0, 0, 170).getRGB());
    }
    
    @Override
    public void initGui() {
        super.initGui();
        this.buttonList.add(new GuiButton(6340, TimeChangerGUI.width / 2 - 50, TimeChangerGUI.height / 2 - 10, 100, 20, "DAY"));
    }
    
    @Override
    protected void actionPerformed(final GuiButton button) throws IOException {
        switch (button.id) {
            case 6340: {
                final TimeType vanilla = TimeType.VANILLA;
                this.setTimeType(TimeType.NIGHT);
                System.out.println(this.getTimeType());
                this.getTimeType();
                break;
            }
        }
        super.actionPerformed(button);
    }
    
    public void setTimeType(final TimeType timeType) {
        this.timeType = timeType;
    }
    
    public TimeType getTimeType() {
        return this.timeType;
    }
    
    public void setFastTimeMultiplier(final double fastTimeMultiplier) {
        this.fastTimeMultiplier = fastTimeMultiplier;
    }
}
