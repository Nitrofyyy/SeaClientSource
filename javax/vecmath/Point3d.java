// 
// Decompiled by Procyon v0.5.36
// 

package javax.vecmath;

import java.io.Serializable;

public class Point3d extends Tuple3d implements Serializable
{
    public Point3d(final double x, final double y, final double z) {
        super(x, y, z);
    }
    
    public Point3d(final double[] p) {
        super(p);
    }
    
    public Point3d(final Point3d p1) {
        super((Tuple3d)p1);
    }
    
    public Point3d(final Point3f p1) {
        super((Tuple3f)p1);
    }
    
    public Point3d(final Tuple3d t1) {
        super(t1);
    }
    
    public Point3d(final Tuple3f t1) {
        super(t1);
    }
    
    public Point3d() {
    }
    
    public final double distanceSquared(final Point3d p1) {
        final double dx = super.x - ((Tuple3d)p1).x;
        final double dy = super.y - ((Tuple3d)p1).y;
        final double dz = super.z - ((Tuple3d)p1).z;
        return dx * dx + dy * dy + dz * dz;
    }
    
    public final double distance(final Point3d p1) {
        return Math.sqrt(this.distanceSquared(p1));
    }
    
    public final double distanceL1(final Point3d p1) {
        return Math.abs(super.x - ((Tuple3d)p1).x) + Math.abs(super.y - ((Tuple3d)p1).y) + Math.abs(super.z - ((Tuple3d)p1).z);
    }
    
    public final double distanceLinf(final Point3d p1) {
        return Math.max(Math.max(Math.abs(super.x - ((Tuple3d)p1).x), Math.abs(super.y - ((Tuple3d)p1).y)), Math.abs(super.z - ((Tuple3d)p1).z));
    }
    
    public final void project(final Point4d p1) {
        super.x = ((Tuple4d)p1).x / ((Tuple4d)p1).w;
        super.y = ((Tuple4d)p1).y / ((Tuple4d)p1).w;
        super.z = ((Tuple4d)p1).z / ((Tuple4d)p1).w;
    }
}
