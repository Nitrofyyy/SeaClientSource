// 
// Decompiled by Procyon v0.5.36
// 

package javax.vecmath;

import java.io.Serializable;

public class Vector3d extends Tuple3d implements Serializable
{
    public Vector3d(final double x, final double y, final double z) {
        super(x, y, z);
    }
    
    public Vector3d(final double[] v) {
        super(v);
    }
    
    public Vector3d(final Vector3f v1) {
        super((Tuple3f)v1);
    }
    
    public Vector3d(final Vector3d v1) {
        super((Tuple3d)v1);
    }
    
    public Vector3d(final Tuple3d t1) {
        super(t1);
    }
    
    public Vector3d(final Tuple3f t1) {
        super(t1);
    }
    
    public Vector3d() {
    }
    
    public final void cross(final Vector3d v1, final Vector3d v2) {
        this.set(((Tuple3d)v1).y * ((Tuple3d)v2).z - ((Tuple3d)v1).z * ((Tuple3d)v2).y, ((Tuple3d)v1).z * ((Tuple3d)v2).x - ((Tuple3d)v1).x * ((Tuple3d)v2).z, ((Tuple3d)v1).x * ((Tuple3d)v2).y - ((Tuple3d)v1).y * ((Tuple3d)v2).x);
    }
    
    public final void normalize(final Vector3d v1) {
        this.set((Tuple3d)v1);
        this.normalize();
    }
    
    public final void normalize() {
        final double d = this.length();
        super.x /= d;
        super.y /= d;
        super.z /= d;
    }
    
    public final double dot(final Vector3d v1) {
        return super.x * ((Tuple3d)v1).x + super.y * ((Tuple3d)v1).y + super.z * ((Tuple3d)v1).z;
    }
    
    public final double lengthSquared() {
        return super.x * super.x + super.y * super.y + super.z * super.z;
    }
    
    public final double length() {
        return Math.sqrt(this.lengthSquared());
    }
    
    public final double angle(final Vector3d v1) {
        final double xx = super.y * ((Tuple3d)v1).z - super.z * ((Tuple3d)v1).y;
        final double yy = super.z * ((Tuple3d)v1).x - super.x * ((Tuple3d)v1).z;
        final double zz = super.x * ((Tuple3d)v1).y - super.y * ((Tuple3d)v1).x;
        final double cross = Math.sqrt(xx * xx + yy * yy + zz * zz);
        return Math.abs(Math.atan2(cross, this.dot(v1)));
    }
}
