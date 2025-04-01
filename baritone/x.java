/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cq
 */
package baritone;

import baritone.api.utils.BetterBlockPos;
import baritone.ay;
import baritone.bv;
import baritone.o;
import baritone.pathing.movement.CalculationContext;
import baritone.r;

/*
 * Exception performing whole class analysis ignored.
 */
static final class x
extends r {
    @Override
    public final o a(CalculationContext calculationContext, BetterBlockPos betterBlockPos) {
        bv bv2 = new bv();
        this.a(calculationContext, betterBlockPos.a, betterBlockPos.c, betterBlockPos.d, bv2);
        return new ay(calculationContext.a, betterBlockPos, cq.c, cq.e, bv2.b - betterBlockPos.c);
    }

    @Override
    public final void a(CalculationContext calculationContext, int n, int n2, int n3, bv bv2) {
        ay.a(calculationContext, n, n2, n3, n - 1, n3 - 1, bv2);
    }
}
