// 
// Decompiled by Procyon v0.5.36
// 

package BLueDD.TimeChanger;

import BLueDD.event.impl.ClientTick;
import net.minecraft.client.Minecraft;

public class TimeChanger
{
    public static Minecraft mc;
    public double fastTimeMultiplier;
    public TimeType timeType;
    
    public TimeChanger() {
        TimeChanger.mc = Minecraft.getMinecraft();
        this.fastTimeMultiplier = 1.0;
        this.timeType = TimeType.VANILLA;
    }
    
    public TimeType getTimeType() {
        return this.timeType;
    }
    
    public void setTimeType(final TimeType timeType) {
        this.timeType = timeType;
    }
    
    public void setFastTimeMultiplier(final double fastTimeMultiplier) {
        this.fastTimeMultiplier = fastTimeMultiplier;
    }
    
    public void onTick(final ClientTick event) {
        if (TimeChanger.mc.theWorld != null && this.timeType == TimeType.FAST) {
            TimeChanger.mc.theWorld.setWorldTime((long)(System.currentTimeMillis() * this.fastTimeMultiplier % 24000.0));
        }
    }
}
