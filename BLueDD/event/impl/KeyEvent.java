// 
// Decompiled by Procyon v0.5.36
// 

package BLueDD.event.impl;

import BLueDD.event.EventCancelable;

public class KeyEvent extends EventCancelable
{
    private final int key;
    
    public KeyEvent(final int key) {
        this.key = key;
    }
    
    public int getKey() {
        return this.key;
    }
}
