/*
 * Decompiled with CFR 0.152.
 */
package baritone.api.utils;

public class Rotation {
    private final float yaw;
    private final float pitch;

    public Rotation(float f, float f2) {
        this.yaw = Float.isInfinite(f) || Float.isNaN(f) ? 0.0f : f;
        if (Float.isInfinite(f2) || Float.isNaN(f2)) {
            this.pitch = 0.0f;
            return;
        }
        this.pitch = f2;
    }

    public float getYaw() {
        return this.yaw;
    }

    public float getPitch() {
        return this.pitch;
    }

    public Rotation add(Rotation rotation) {
        return new Rotation(this.yaw + rotation.yaw, this.pitch + rotation.pitch);
    }

    public Rotation subtract(Rotation rotation) {
        return new Rotation(this.yaw - rotation.yaw, this.pitch - rotation.pitch);
    }

    public Rotation clamp() {
        return new Rotation(this.yaw, Rotation.clampPitch(this.pitch));
    }

    public Rotation normalize() {
        return new Rotation(Rotation.normalizeYaw(this.yaw), this.pitch);
    }

    public Rotation normalizeAndClamp() {
        return new Rotation(Rotation.normalizeYaw(this.yaw), Rotation.clampPitch(this.pitch));
    }

    public Rotation withPitch(float f) {
        return new Rotation(this.yaw, f);
    }

    public boolean isReallyCloseTo(Rotation rotation) {
        return this.yawIsReallyClose(rotation) && (double)Math.abs(this.pitch - rotation.pitch) < 0.01;
    }

    public boolean yawIsReallyClose(Rotation rotation) {
        float f = Math.abs(Rotation.normalizeYaw(this.yaw) - Rotation.normalizeYaw(rotation.yaw));
        return (double)f < 0.01 || (double)f > 359.99;
    }

    public static float clampPitch(float f) {
        return Math.max(-90.0f, Math.min(90.0f, f));
    }

    public static float normalizeYaw(float f) {
        float f2;
        f %= 360.0f;
        if (f2 < -180.0f) {
            f += 360.0f;
        }
        if (f > 180.0f) {
            f -= 360.0f;
        }
        return f;
    }

    public String toString() {
        return "Yaw: " + this.yaw + ", Pitch: " + this.pitch;
    }
}
