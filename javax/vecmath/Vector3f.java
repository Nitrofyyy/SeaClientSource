// 
// Decompiled by Procyon v0.5.36
// 

package javax.vecmath;

import java.io.Serializable;

public class Vector3f extends Tuple3f implements Serializable
{
    public Vector3f(final float x, final float y, final float z) {
        super(x, y, z);
    }
    
    public Vector3f(final float[] v) {
        super(v);
    }
    
    public Vector3f(final Vector3f v1) {
        super((Tuple3f)v1);
    }
    
    public Vector3f(final Vector3d v1) {
        super((Tuple3d)v1);
    }
    
    public Vector3f(final Tuple3d t1) {
        super(t1);
    }
    
    public Vector3f(final Tuple3f t1) {
        super(t1);
    }
    
    public Vector3f() {
    }
    
    public final float lengthSquared() {
        return super.x * super.x + super.y * super.y + super.z * super.z;
    }
    
    public final float length() {
        return (float)Math.sqrt(this.lengthSquared());
    }
    
    public final void cross(final Vector3f v1, final Vector3f v2) {
        this.set(((Tuple3f)v1).y * ((Tuple3f)v2).z - ((Tuple3f)v1).z * ((Tuple3f)v2).y, ((Tuple3f)v1).z * ((Tuple3f)v2).x - ((Tuple3f)v1).x * ((Tuple3f)v2).z, ((Tuple3f)v1).x * ((Tuple3f)v2).y - ((Tuple3f)v1).y * ((Tuple3f)v2).x);
    }
    
    public final float dot(final Vector3f v1) {
        return super.x * ((Tuple3f)v1).x + super.y * ((Tuple3f)v1).y + super.z * ((Tuple3f)v1).z;
    }
    
    public final void normalize(final Vector3f v1) {
        this.set((Tuple3f)v1);
        this.normalize();
    }
    
    public final void normalize() {
        final double d = this.length();
        super.x /= (float)d;
        super.y /= (float)d;
        super.z /= (float)d;
    }
    
    public final float angle(final Vector3f v1) {
        final double xx = super.y * ((Tuple3f)v1).z - super.z * ((Tuple3f)v1).y;
        final double yy = super.z * ((Tuple3f)v1).x - super.x * ((Tuple3f)v1).z;
        final double zz = super.x * ((Tuple3f)v1).y - super.y * ((Tuple3f)v1).x;
        final double cross = Math.sqrt(xx * xx + yy * yy + zz * zz);
        return (float)Math.abs(Math.atan2(cross, this.dot(v1)));
    }
}
