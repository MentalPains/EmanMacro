/*
 * Decompiled with CFR 0.152.
 */
package baritone;

import baritone.am;
import baritone.api.utils.BetterBlockPos;
import baritone.av;
import baritone.o;
import baritone.pathing.movement.CalculationContext;

/*
 * Exception performing whole class analysis ignored.
 */
static final class ar
extends am {
    @Override
    public final o a(CalculationContext calculationContext, BetterBlockPos betterBlockPos) {
        BetterBlockPos betterBlockPos2 = betterBlockPos;
        return new av(calculationContext.a, betterBlockPos2, betterBlockPos2.up());
    }

    @Override
    public final double a(CalculationContext calculationContext, int n, int n2, int n3) {
        return av.a(calculationContext, n, n2, n3);
    }
}
