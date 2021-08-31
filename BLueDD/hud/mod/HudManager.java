// 
// Decompiled by Procyon v0.5.36
// 

package BLueDD.hud.mod;

import BLueDD.event.impl.EventUpdate;
import java.util.Iterator;
import BLueDD.hud.mod.impl.ReachDisplay;
import BLueDD.hud.mod.impl.BlockOverlay;
import BLueDD.hud.mod.impl.ModPerspectiveHud;
import BLueDD.hud.mod.impl.ItemPhysicss;
import BLueDD.hud.mod.impl.ToggleSprintHud;
import BLueDD.hud.mod.impl.MiniPlayer;
import BLueDD.hud.mod.impl.FullBrightEnable;
import BLueDD.hud.mod.impl.AutoGG;
import BLueDD.hud.mod.impl.XYZMod;
import BLueDD.hud.mod.impl.ModPotionStatus;
import BLueDD.hud.mod.impl.ModKeystrokes;
import BLueDD.hud.mod.impl.PingMod;
import BLueDD.hud.mod.impl.ArmorStatusMod;
import BLueDD.hud.mod.impl.DirectionMod;
import BLueDD.hud.mod.impl.TestMod;
import BLueDD.hud.mod.impl.CPSMod;
import BLueDD.hud.mod.impl.PacOverlay;
import BLueDD.hud.mod.impl.ClockMod;
import BLueDD.hud.mod.impl.FPSMod;
import java.util.ArrayList;

public class HudManager
{
    public ArrayList<HudMod> hudMods;
    public static HudManager INSTANCE;
    public FPSMod FPSMod;
    public ClockMod ClockMod;
    public PacOverlay DisplayPack;
    public CPSMod CPSMod;
    public TestMod test;
    public DirectionMod DirectionMod;
    public ArmorStatusMod armor;
    public PingMod ping;
    public ModKeystrokes key;
    public ModPotionStatus pot;
    public XYZMod zyz;
    public AutoGG autoGG;
    public FullBrightEnable fullbright;
    public MiniPlayer mini;
    public ToggleSprintHud sprint;
    public ItemPhysicss item;
    public ModPerspectiveHud freelook;
    public BlockOverlay overlay;
    public ReachDisplay reach;
    public static HudManager getInstance;
    
    static {
        HudManager.INSTANCE = new HudManager();
    }
    
    public HudManager() {
        (this.hudMods = new ArrayList<HudMod>()).add(this.ClockMod = new ClockMod());
        this.hudMods.add(this.DisplayPack = new PacOverlay());
        this.hudMods.add(this.FPSMod = new FPSMod());
        this.hudMods.add(this.CPSMod = new CPSMod());
        this.hudMods.add(this.test = new TestMod());
        this.hudMods.add(this.DirectionMod = new DirectionMod());
        this.hudMods.add(this.armor = new ArmorStatusMod());
        this.hudMods.add(this.ping = new PingMod());
        this.hudMods.add(this.pot = new ModPotionStatus());
        this.hudMods.add(this.zyz = new XYZMod());
        this.hudMods.add(this.fullbright = new FullBrightEnable());
        this.hudMods.add(this.mini = new MiniPlayer());
        this.hudMods.add(this.key = new ModKeystrokes());
        this.hudMods.add(this.sprint = new ToggleSprintHud());
        this.hudMods.add(this.item = new ItemPhysicss());
        this.hudMods.add(this.freelook = new ModPerspectiveHud());
        this.hudMods.add(this.overlay = new BlockOverlay());
        this.hudMods.add(this.reach = new ReachDisplay());
    }
    
    public void renderMod() {
        for (final HudMod m : this.hudMods) {
            if (m.isEnabled()) {
                m.draw();
            }
        }
    }
    
    public static HudManager getInstance() {
        return HudManager.INSTANCE;
    }
    
    public EventUpdate[] getRegisteredRenderers() {
        return null;
    }
}
