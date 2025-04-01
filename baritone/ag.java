/*
 * Decompiled with CFR 0.152.
 */
package baritone;

import baritone.api.utils.BetterBlockPos;
import baritone.bb;
import baritone.o;
import baritone.pathing.movement.CalculationContext;
import baritone.r;

/*
 * Exception performing whole class analysis ignored.
 */
static final class ag
extends r {
    @Override
    public final o a(CalculationContext calculationContext, BetterBlockPos betterBlockPos) {
        BetterBlockPos betterBlockPos2 = betterBlockPos;
        return new bb(calculationContext.a, betterBlockPos2, betterBlockPos2.west());
    }

    @Override
    public final double a(CalculationContext calculationContext, int n, int n2, int n3) {
        return bb.a(calculationContext, n, n2, n3, n - 1, n3);
    }
}
