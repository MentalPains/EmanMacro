/*
 * Decompiled with CFR 0.152.
 */
package baritone;

import baritone.api.utils.BetterBlockPos;
import baritone.ax;
import baritone.az;
import baritone.bv;
import baritone.o;
import baritone.pathing.movement.CalculationContext;
import baritone.r;

/*
 * Exception performing whole class analysis ignored.
 */
static final class u
extends r {
    @Override
    public final o a(CalculationContext calculationContext, BetterBlockPos betterBlockPos) {
        bv bv2 = new bv();
        this.a(calculationContext, betterBlockPos.a, betterBlockPos.c, betterBlockPos.d, bv2);
        if (bv2.b == betterBlockPos.c - 1) {
            return new ax(calculationContext.a, betterBlockPos, new BetterBlockPos(bv2.a, bv2.b, bv2.c));
        }
        return new az(calculationContext.a, betterBlockPos, new BetterBlockPos(bv2.a, bv2.b, bv2.c));
    }

    @Override
    public final void a(CalculationContext calculationContext, int n, int n2, int n3, bv bv2) {
        ax.a(calculationContext, n, n2, n3, n, n3 - 1, bv2);
    }
}
