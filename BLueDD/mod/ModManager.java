// 
// Decompiled by Procyon v0.5.36
// 

package BLueDD.mod;

import java.util.ArrayList;
import BLueDD.mod.impl.FullBright;
import BLueDD.mod.impl.ItemPhysic;
import BLueDD.mod.impl.ModPerspective;
import BLueDD.mod.impl.BlockOverlayasd;
import BLueDD.mod.impl.ToggleSprint;
import BLueDD.mod.impl.TestMod;

public class ModManager
{
    public TestMod testmod;
    public ToggleSprint sprint;
    public BlockOverlayasd block;
    public static ModPerspective freelook;
    public ItemPhysic itempsic;
    public FullBright full;
    public ArrayList<Mod> mods;
    
    public ModManager() {
        (this.mods = new ArrayList<Mod>()).add(this.testmod = new TestMod());
        this.mods.add(this.sprint = new ToggleSprint());
        this.mods.add(this.block = new BlockOverlayasd());
        this.mods.add(this.itempsic = new ItemPhysic());
        this.mods.add(this.full = new FullBright());
    }
    
    public static ModPerspective getModPerspective() {
        return new ModPerspective();
    }
}
