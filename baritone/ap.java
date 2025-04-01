/*
 * Decompiled with CFR 0.152.
 */
package baritone;

import baritone.am;
import baritone.api.utils.BetterBlockPos;
import baritone.au;
import baritone.o;
import baritone.pathing.movement.CalculationContext;

/*
 * Exception performing whole class analysis ignored.
 */
static final class ap
extends am {
    @Override
    public final o a(CalculationContext calculationContext, BetterBlockPos betterBlockPos) {
        BetterBlockPos betterBlockPos2 = betterBlockPos;
        return new au(calculationContext.a, betterBlockPos2, betterBlockPos2.east());
    }

    @Override
    public final double a(CalculationContext calculationContext, int n, int n2, int n3) {
        return au.a(calculationContext, n2, n + 1, n3);
    }
}
