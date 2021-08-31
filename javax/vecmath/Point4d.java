// 
// Decompiled by Procyon v0.5.36
// 

package javax.vecmath;

import java.io.Serializable;

public class Point4d extends Tuple4d implements Serializable
{
    public Point4d(final double x, final double y, final double z, final double w) {
        super(x, y, z, w);
    }
    
    public Point4d(final double[] p) {
        super(p);
    }
    
    public Point4d(final Point4f p1) {
        super((Tuple4f)p1);
    }
    
    public Point4d(final Point4d p1) {
        super((Tuple4d)p1);
    }
    
    public Point4d(final Tuple4d t1) {
        super(t1);
    }
    
    public Point4d(final Tuple4f t1) {
        super(t1);
    }
    
    public Point4d() {
    }
    
    public Point4d(final Tuple3d t1) {
        super(t1.x, t1.y, t1.z, 1.0);
    }
    
    public final void set(final Tuple3d t1) {
        this.set(t1.x, t1.y, t1.z, 1.0);
    }
    
    public final double distanceSquared(final Point4d p1) {
        final double dx = super.x - ((Tuple4d)p1).x;
        final double dy = super.y - ((Tuple4d)p1).y;
        final double dz = super.z - ((Tuple4d)p1).z;
        final double dw = super.w - ((Tuple4d)p1).w;
        return (float)(dx * dx + dy * dy + dz * dz + dw * dw);
    }
    
    public final double distance(final Point4d p1) {
        return Math.sqrt(this.distanceSquared(p1));
    }
    
    public final double distanceL1(final Point4d p1) {
        return Math.abs(super.x - ((Tuple4d)p1).x) + Math.abs(super.y - ((Tuple4d)p1).y) + Math.abs(super.z - ((Tuple4d)p1).z) + Math.abs(super.w - ((Tuple4d)p1).w);
    }
    
    public final double distanceLinf(final Point4d p1) {
        return Math.max(Math.max(Math.abs(super.x - ((Tuple4d)p1).x), Math.abs(super.y - ((Tuple4d)p1).y)), Math.max(Math.abs(super.z - ((Tuple4d)p1).z), Math.abs(super.w - ((Tuple4d)p1).w)));
    }
    
    public final void project(final Point4d p1) {
        super.x = ((Tuple4d)p1).x / ((Tuple4d)p1).w;
        super.y = ((Tuple4d)p1).y / ((Tuple4d)p1).w;
        super.z = ((Tuple4d)p1).z / ((Tuple4d)p1).w;
        super.w = 1.0;
    }
}
