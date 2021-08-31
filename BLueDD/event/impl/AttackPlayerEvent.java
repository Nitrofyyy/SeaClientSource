// 
// Decompiled by Procyon v0.5.36
// 

package BLueDD.event.impl;

import BLueDD.event.Event;

public class AttackPlayerEvent extends Event
{
    private final String attack;
    
    public AttackPlayerEvent(final String attack) {
        this.attack = attack;
    }
    
    public String getAttack() {
        return this.attack;
    }
}
