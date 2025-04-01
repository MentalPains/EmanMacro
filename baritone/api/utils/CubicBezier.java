/*
 * Decompiled with CFR 0.152.
 */
package baritone.api.utils;

import java.util.function.Function;

public class CubicBezier {
    private static final double EPSILON = 1.0E-6;
    private final Function<Float, Float> calculateX = f5 -> Float.valueOf((float)(Math.pow(1.0f - f5.floatValue(), 3.0) * (double)f + 3.0 * Math.pow(1.0f - f5.floatValue(), 2.0) * (double)f5.floatValue() * (double)f3 + (double)(3.0f * (1.0f - f5.floatValue())) * Math.pow(f5.floatValue(), 2.0) * (double)f6 + Math.pow(f5.floatValue(), 3.0) * (double)f8));
    private final Function<Float, Float> calculateY = f5 -> Float.valueOf((float)(Math.pow(1.0f - f5.floatValue(), 3.0) * (double)f2 + 3.0 * Math.pow(1.0f - f5.floatValue(), 2.0) * (double)f5.floatValue() * (double)f4 + (double)(3.0f * (1.0f - f5.floatValue())) * Math.pow(f5.floatValue(), 2.0) * (double)f7 + Math.pow(f5.floatValue(), 3.0) * (double)f9));
    private final Function<Float, Float> calculateGradientX = f5 -> Float.valueOf((float)(3.0 * Math.pow(1.0f - f5.floatValue(), 2.0) * (double)(f3 - f) + (double)(6.0f * (1.0f - f5.floatValue()) * f5.floatValue() * (f6 - f3)) + 3.0 * Math.pow(f5.floatValue(), 2.0) * (double)(f8 - f6)));

    public CubicBezier(double d, double d2, double d3, double d4) {
        this(0.0, 0.0, d, d2, d3, d4, 1.0, 1.0);
    }

    public CubicBezier(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
        this((float)d, (float)d2, (float)d3, (float)d4, (float)d5, (float)d6, (float)d7, (float)d8);
    }

    public CubicBezier(float f, float f2, float f3, float f4) {
        this(0.0f, 0.0f, f, f2, f3, f4, 1.0f, 1.0f);
    }

    public CubicBezier(float f, float f2, float f3, float f4, float f6, float f7, float f8, float f9) {
    }

    public float calculateYWithX(float f) {
        float f2;
        float f3;
        float f4 = f;
        for (int i = 0; i < 8; ++i) {
            float f5;
            f3 = this.calculateX.apply(Float.valueOf(f4)).floatValue() - f;
            if ((double)Math.abs(f5) < 1.0E-6) {
                return this.calculateY.apply(Float.valueOf(f4)).floatValue();
            }
            f2 = this.calculateGradientX.apply(Float.valueOf(f4)).floatValue();
            if ((double)Math.abs(f2) < 1.0E-6) break;
            f4 -= f3 / f2;
        }
        float f6 = 0.0f;
        f3 = 1.0f;
        f4 = f;
        if (f < 0.0f) {
            return this.calculateY.apply(Float.valueOf(0.0f)).floatValue();
        }
        if (f > 1.0f) {
            return this.calculateY.apply(Float.valueOf(1.0f)).floatValue();
        }
        while (f6 < f3) {
            float f7;
            f2 = this.calculateX.apply(Float.valueOf(f4)).floatValue();
            if ((double)Math.abs(f7) < 1.0E-6) {
                return this.calculateY.apply(Float.valueOf(f4)).floatValue();
            }
            if (f2 < 0.0f) {
                f6 = f4;
            } else {
                f3 = f4;
            }
            f4 = (f3 - f6) * 0.5f + f6;
        }
        return this.calculateY.apply(Float.valueOf(f4)).floatValue();
    }
}
