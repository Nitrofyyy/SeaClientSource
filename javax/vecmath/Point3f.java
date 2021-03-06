// 
// Decompiled by Procyon v0.5.36
// 

package javax.vecmath;

import java.io.Serializable;

public class Point3f extends Tuple3f implements Serializable
{
    public Point3f(final float x, final float y, final float z) {
        super(x, y, z);
    }
    
    public Point3f(final float[] p) {
        super(p);
    }
    
    public Point3f(final Point3f p1) {
        super((Tuple3f)p1);
    }
    
    public Point3f(final Point3d p1) {
        super((Tuple3d)p1);
    }
    
    public Point3f(final Tuple3f t1) {
        super(t1);
    }
    
    public Point3f(final Tuple3d t1) {
        super(t1);
    }
    
    public Point3f() {
    }
    
    public final float distanceSquared(final Point3f p1) {
        final double dx = super.x - ((Tuple3f)p1).x;
        final double dy = super.y - ((Tuple3f)p1).y;
        final double dz = super.z - ((Tuple3f)p1).z;
        return (float)(dx * dx + dy * dy + dz * dz);
    }
    
    public final float distance(final Point3f p1) {
        return (float)Math.sqrt(this.distanceSquared(p1));
    }
    
    public final float distanceL1(final Point3f p1) {
        return Math.abs(super.x - ((Tuple3f)p1).x) + Math.abs(super.y - ((Tuple3f)p1).y) + Math.abs(super.z - ((Tuple3f)p1).z);
    }
    
    public final float distanceLinf(final Point3f p1) {
        return Math.max(Math.max(Math.abs(super.x - ((Tuple3f)p1).x), Math.abs(super.y - ((Tuple3f)p1).y)), Math.abs(super.z - ((Tuple3f)p1).z));
    }
    
    public final void project(final Point4f p1) {
        super.x = ((Tuple4f)p1).x / ((Tuple4f)p1).w;
        super.y = ((Tuple4f)p1).y / ((Tuple4f)p1).w;
        super.z = ((Tuple4f)p1).z / ((Tuple4f)p1).w;
    }
}
