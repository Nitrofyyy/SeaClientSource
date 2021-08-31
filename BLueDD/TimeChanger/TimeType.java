// 
// Decompiled by Procyon v0.5.36
// 

package BLueDD.TimeChanger;

public enum TimeType
{
    DAY("DAY", 0, "DAY", TimeType.l = 1000), 
    SUNSET("SUNSET", 1, "SUNSET", TimeType.l = 13000), 
    NIGHT("NIGHT", 2, "NIGHT", 2), 
    VANILLA("VANILLA", 3, "VANILLA", 1000), 
    FAST("FAST", 4, "FAST", 4);
    
    private static int l;
    
    private TimeType(final String name2, final int ordinal2, final String name, final int ordinal) {
    }
}
