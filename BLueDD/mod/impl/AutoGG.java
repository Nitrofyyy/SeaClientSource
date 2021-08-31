// 
// Decompiled by Procyon v0.5.36
// 

package BLueDD.mod.impl;

import net.minecraft.util.IChatComponent;

public class AutoGG
{
    public static final AutoGG INSTANCE;
    private long lastTrigger;
    
    static {
        INSTANCE = new AutoGG();
    }
    
    public void onChat(final IChatComponent message) {
    }
    
    public static String getHypixelTrigger() {
        return "1st Killer - \n1st Place - \nWinner: \n - Damage Dealt - \nWinning Team -\n1st - \nWinners: \nWinner: \nWinning Team: \n won the game!\nTop Seeker: \n1st Place: \nLast team standing!\nWinner #1 (\nTop Survivors\nWinners - \nSumo Duel - \n";
    }
}
