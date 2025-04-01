/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cq
 */
package baritone;

import baritone.api.utils.BetterBlockPos;
import baritone.ba;
import baritone.bv;
import baritone.o;
import baritone.pathing.movement.CalculationContext;
import baritone.r;

/*
 * Exception performing whole class analysis ignored.
 */
static final class ae
extends r {
    @Override
    public final o a(CalculationContext calculationContext, BetterBlockPos betterBlockPos) {
        return ba.a(calculationContext, betterBlockPos, cq.e);
    }

    @Override
    public final void a(CalculationContext calculationContext, int n, int n2, int n3, bv bv2) {
        ba.a(calculationContext, n, n2, n3, cq.e, bv2);
    }
}
