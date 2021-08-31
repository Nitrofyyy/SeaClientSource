// 
// Decompiled by Procyon v0.5.36
// 

package BLueDD.betterfps;

public class Naming
{
    public static final ObfuscationName C_Minecraft;
    public static final ObfuscationName C_KeyBinding;
    public static final ObfuscationName C_MathHelper;
    public static final ObfuscationName M_startGame;
    public static final ObfuscationName M_onTick;
    public static final ObfuscationName M_sin;
    public static final ObfuscationName M_cos;
    
    static {
        C_Minecraft = new ObfuscationName("net.minecraft.client.Minecraft", "ave");
        C_KeyBinding = new ObfuscationName("net.minecraft.client.settings.KeyBinding", "avb");
        C_MathHelper = new ObfuscationName("net.minecraft.util.MathHelper", "ns");
        M_startGame = new ObfuscationName("startGame", "am", "()V");
        M_onTick = new ObfuscationName("onTick", "a", "(I)V");
        M_sin = new ObfuscationName("sin", "a", "(F)F");
        M_cos = new ObfuscationName("cos", "b", "(F)F");
    }
    
    public static class ObfuscationName
    {
        private String deob;
        private String deobRepl;
        private String ob;
        private String obRepl;
        private String desc;
        
        public ObfuscationName(final String deob, String ob) {
            this.deob = deob;
            this.deobRepl = deob.replaceAll("\\.", "/");
            if (ob == null) {
                ob = deob;
            }
            this.ob = ob;
            this.obRepl = ob.replaceAll("\\.", "/");
        }
        
        public ObfuscationName(final String deob, final String ob, final String desc) {
            this(deob, ob);
            this.desc = desc;
        }
        
        public boolean is(final String name) {
            return name.equals(this.deob) || name.equals(this.ob);
        }
        
        public boolean isASM(final String name) {
            return name.equals(this.deobRepl) || name.equals(this.obRepl);
        }
        
        public boolean is(final String name, final String desc) {
            return this.desc.equals(desc) && this.is(name);
        }
    }
}
