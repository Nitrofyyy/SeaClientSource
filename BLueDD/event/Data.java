// 
// Decompiled by Procyon v0.5.36
// 

package BLueDD.event;

import java.lang.reflect.Method;

public class Data
{
    public final Object source;
    public final Method target;
    public final byte priority;
    
    Data(final Object source, final Method target, final byte priority) {
        this.source = source;
        this.target = target;
        this.priority = priority;
    }
}
