// 
// Decompiled by Procyon v0.5.36
// 

package BLueDD.hud.mod.impl;

import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;
import BLueDD.hud.mod.HudMod;

public class AutoGG extends HudMod
{
    private double delayS;
    private int delay;
    private transient double currentDelay;
    private String[] triggers;
    
    public AutoGG() {
        super("AutoGG", 0, 0);
        this.delayS = 0.0;
        this.delay = 0;
        this.currentDelay = -1.0;
        this.triggers = new String[] { "1st Killer - ", "1st Place - ", "Winner: ", " - Damage Dealt - ", "Winning Team -", "1st - ", "Winners: ", "Winner: ", "Winning Team: ", " won the game!", "Top Seeker: ", "1st Place: ", "Last team standing!", "Winner #1 (", "Top Survivors", "Winners - " };
    }
    
    public void eventPog(final String event) {
        if (event.equals("tick")) {
            if (this.currentDelay != -1.0) {
                this.currentDelay += 0.05;
                if (this.currentDelay >= this.delay) {
                    this.mc.thePlayer.sendChatMessage("gg");
                    this.currentDelay = -1.0;
                }
            }
        }
        else {
            event.equals("chat");
        }
    }
    
    private void handleChat(final IChatComponent chatComponent) {
        if (this.mc.getCurrentServerData().serverIP.toLowerCase().contains("blocksmc.com") || this.mc.getCurrentServerData().serverIP.toLowerCase().contains("BLOCKSMC.COM") || this.mc.getCurrentServerData().serverIP.toLowerCase().contains("hypixel.net") || this.mc.getCurrentServerData().serverIP.toLowerCase().contains("premium.blocksmc.com")) {
            final String s = EnumChatFormatting.getTextWithoutFormattingCodes(chatComponent.getUnformattedText());
            if (s != null && s.startsWith(" ")) {
                String[] triggers;
                for (int length = (triggers = this.triggers).length, i = 0; i < length; ++i) {
                    final String s2 = triggers[i];
                    if (s.contains(s2)) {
                        this.currentDelay = 0.0;
                        break;
                    }
                }
            }
        }
    }
}
