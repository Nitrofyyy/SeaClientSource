// 
// Decompiled by Procyon v0.5.36
// 

package javax.vecmath;

import java.io.Serializable;

public abstract class Tuple3b implements Serializable
{
    public byte x;
    public byte y;
    public byte z;
    
    public Tuple3b(final byte b1, final byte b2, final byte b3) {
        this.x = b1;
        this.y = b2;
        this.z = b3;
    }
    
    public Tuple3b(final byte[] t) {
        this.x = t[0];
        this.y = t[1];
        this.z = t[2];
    }
    
    public Tuple3b(final Tuple3b t1) {
        this.x = t1.x;
        this.y = t1.y;
        this.z = t1.z;
    }
    
    public Tuple3b() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }
    
    public final void set(final Tuple3b t1) {
        this.x = t1.x;
        this.y = t1.y;
        this.z = t1.z;
    }
    
    public final void set(final byte[] t) {
        this.x = t[0];
        this.y = t[1];
        this.z = t[2];
    }
    
    public final void get(final byte[] t) {
        t[0] = this.x;
        t[1] = this.y;
        t[2] = this.z;
    }
    
    public final void get(final Tuple3b t) {
        t.x = this.x;
        t.y = this.y;
        t.z = this.z;
    }
    
    public int hashCode() {
        return this.x | this.y << 8 | this.z << 16;
    }
    
    public boolean equals(final Tuple3b t1) {
        return t1 != null && this.x == t1.x && this.y == t1.y && this.z == t1.z;
    }
    
    public boolean equals(final Object o1) {
        return o1 != null && o1 instanceof Tuple3b && this.equals((Tuple3b)o1);
    }
    
    public String toString() {
        return "(" + this.x + ", " + this.y + ", " + this.z + ")";
    }
}
