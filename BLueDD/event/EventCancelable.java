// 
// Decompiled by Procyon v0.5.36
// 

package BLueDD.event;

public class EventCancelable extends Event
{
    private boolean cancelled;
    
    public EventCancelable() {
        this.cancelled = false;
    }
    
    @Override
    public boolean isCancelled() {
        return this.cancelled;
    }
    
    @Override
    public void setCancelled(final boolean cancelled) {
        this.cancelled = cancelled;
    }
}
