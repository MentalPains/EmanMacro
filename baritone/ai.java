/*
 * Decompiled with CFR 0.152.
 */
package baritone;

import baritone.api.utils.BetterBlockPos;
import baritone.aw;
import baritone.o;
import baritone.pathing.movement.CalculationContext;
import baritone.r;

/*
 * Exception performing whole class analysis ignored.
 */
static final class ai
extends r {
    @Override
    public final o a(CalculationContext calculationContext, BetterBlockPos betterBlockPos) {
        return new aw(calculationContext.a, betterBlockPos, new BetterBlockPos(betterBlockPos.a, betterBlockPos.c + 1, betterBlockPos.d + 1));
    }

    @Override
    public final double a(CalculationContext calculationContext, int n, int n2, int n3) {
        return aw.a(calculationContext, n, n2, n3, n, n3 + 1);
    }
}
