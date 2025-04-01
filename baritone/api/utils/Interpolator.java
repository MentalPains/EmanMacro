/*
 * Decompiled with CFR 0.152.
 */
package baritone.api.utils;

import baritone.api.utils.CubicBezier;

public class Interpolator {
    private final CubicBezier bezier;
    private final int animationTimeTicks;
    private int currentTicks;

    public Interpolator(int n, CubicBezier cubicBezier) {
        this.bezier = cubicBezier;
        this.animationTimeTicks = n;
        this.currentTicks = 0;
    }

    public Interpolator(int n, int n2, CubicBezier cubicBezier) {
        this.bezier = cubicBezier;
        this.animationTimeTicks = n;
        this.currentTicks = n2;
    }

    public boolean finished() {
        return this.currentTicks >= this.animationTimeTicks;
    }

    public float nextInterpolation() {
        if (this.finished()) {
            return this.bezier.calculateYWithX(1.0f);
        }
        ++this.currentTicks;
        float f = (float)this.currentTicks / (float)this.animationTimeTicks;
        return this.bezier.calculateYWithX(f);
    }
}
