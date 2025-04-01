/*
 * Decompiled with CFR 0.152.
 */
package baritone;

import baritone.a;
import baritone.api.behavior.look.ITickableAimProcessor;
import baritone.api.utils.CubicBezier;
import baritone.api.utils.IPlayerContext;
import baritone.api.utils.Rotation;
import baritone.d;
import baritone.ef;
import baritone.ev;
import baritone.f;
import baritone.h;
import java.util.Arrays;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
static abstract class d.a
implements ITickableAimProcessor {
    protected final IPlayerContext a;
    private final h a;
    private double a;
    private double b;
    private final ef a;
    private final ef b;

    public d.a(IPlayerContext object) {
        this.a = object;
        this.a = new h();
        object = new CubicBezier(0.56, 0.17, 0.29, 1.0);
        double[] dArray = new double[11];
        double[] dArray2 = new double[11];
        for (int i = 0; i < 11; ++i) {
            float f2 = (float)i / 10.0f;
            dArray[i] = f2;
            dArray2[i] = ((CubicBezier)object).calculateYWithX(f2);
        }
        new ev();
        this.a = ev.a(dArray, dArray2);
        CubicBezier cubicBezier = new CubicBezier(0.22, 1.0, 0.36, 1.0);
        double[] dArray3 = new double[11];
        object = new double[11];
        for (int i = 0; i < 11; ++i) {
            float f3 = (float)i / 10.0f;
            dArray3[i] = f3;
            object[i] = (double)cubicBezier.calculateYWithX(f3);
        }
        new ev();
        this.b = ev.a(dArray3, (double[])object);
    }

    private d.a(d.a a2) {
        this.a = a2.a;
        h h2 = a2.a;
        this.a = new h(Arrays.copyOf(h2.a, 4));
        this.a = a2.a;
        this.b = a2.b;
        this.a = a2.a;
        this.b = a2.b;
    }

    @Override
    public final Rotation peekRotation(Rotation rotation) {
        Rotation rotation2 = this.a();
        float f2 = rotation.getYaw();
        float f3 = rotation.getPitch();
        if (f3 == rotation2.getPitch()) {
            f3 = f3 < -20.0f ? f3 + 1.0f : (f3 > 10.0f ? f3 - 1.0f : f3);
        }
        f2 = (float)((double)f2 + this.a);
        f3 = (float)((double)f3 + this.b);
        return new Rotation(this.a(rotation2.getYaw(), f2), this.a(rotation2.getPitch(), f3)).clamp();
    }

    @Override
    public final Rotation interpolate(Rotation rotation, Rotation rotation2) {
        double d2;
        double d3;
        Rotation rotation3 = this.a();
        Rotation rotation4 = rotation3.subtract(rotation).normalizeAndClamp();
        rotation2 = rotation2.subtract(rotation).normalizeAndClamp();
        double d4 = Math.ceil(d.a(this.a, rotation4.getYaw() / rotation2.getYaw()) * 10.0) / 10.0 + (double)((Float)baritone.a.a().yawSmoothingFactor.value).floatValue();
        if (d3 > 1.0) {
            d4 = 1.0;
        }
        if (d4 < 0.0) {
            d4 = 0.0;
        }
        float f2 = (float)((double)rotation.getYaw() + this.a.a(d4) * (double)rotation2.getYaw());
        double d5 = Math.ceil(d.a(this.b, rotation4.getPitch() / rotation2.getPitch()) * 10.0) / 10.0 + (double)((Float)baritone.a.a().pitchSmoothingFactor.value).floatValue();
        if (d2 > 1.0) {
            d5 = 1.0;
        }
        if (d5 < 0.0) {
            d5 = 0.0;
        }
        float f3 = (float)((double)rotation.getPitch() + this.b.a(d5) * (double)rotation2.getPitch());
        return new Rotation(this.a(rotation3.getYaw(), f2), this.a(rotation3.getPitch(), f3)).clamp();
    }

    @Override
    public final void tick() {
        double d2;
        this.a = (this.a.a() - 0.5) * (Double)baritone.a.a().randomLooking.value;
        this.b = (this.a.a() - 0.5) * (Double)baritone.a.a().randomLooking.value;
        double d3 = this.a.a() - 0.5;
        if (Math.abs(d2) < 0.1) {
            d3 *= 4.0;
        }
        this.a += d3 * (Double)baritone.a.a().randomLooking113.value;
    }

    @Override
    public final void advance(int n) {
        for (int i = 0; i < n; ++i) {
            this.tick();
        }
    }

    @Override
    public Rotation nextRotation(Rotation rotation, Rotation rotation2) {
        rotation = this.interpolate(rotation, rotation2);
        rotation = this.peekRotation(rotation);
        this.tick();
        return rotation;
    }

    @Override
    public final ITickableAimProcessor fork() {
        d.a a2 = this;
        return new f(a2, a2);
    }

    protected abstract Rotation a();

    private float a(float f2, float f3) {
        int n = this.a(f3 -= f2);
        return f2 + this.a(n);
    }

    private int a(float f2) {
        float f3 = this.a(1);
        return Math.round(f2 / f3);
    }

    private float a(int n) {
        float f2 = this.a.minecraft().t.a * 0.6f + 0.2f;
        return (float)n * f2 * f2 * f2 * 8.0f * 0.15f;
    }

    /* synthetic */ d.a(d.a a2, byte by) {
        this(a2);
    }
}
