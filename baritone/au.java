/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  alz
 *  com.google.common.collect.ImmutableSet
 */
package baritone;

import baritone.api.IBaritone;
import baritone.api.pathing.movement.MovementStatus;
import baritone.api.utils.BetterBlockPos;
import baritone.o;
import baritone.p;
import baritone.pathing.movement.CalculationContext;
import baritone.q;
import com.google.common.collect.ImmutableSet;
import java.util.Set;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class au
extends o {
    public au(IBaritone iBaritone, BetterBlockPos betterBlockPos, BetterBlockPos betterBlockPos2) {
        super(iBaritone, betterBlockPos, betterBlockPos2);
    }

    @Override
    public final void reset() {
        super.reset();
    }

    @Override
    public final double a(CalculationContext calculationContext) {
        return au.a(calculationContext, this.a.c, this.b.a, this.b.d);
    }

    @Override
    public final Set<BetterBlockPos> a() {
        return ImmutableSet.of((Object)((Object)this.a), (Object)((Object)this.b));
    }

    public static double a(CalculationContext calculationContext, int n, int n2, int n3) {
        alz alz2 = calculationContext.a(n2, n + 1, n3);
        alz alz3 = calculationContext.a(n2, n, n3);
        if (!p.a(calculationContext, n2, n, n3, alz3) && !p.b(alz3.c())) {
            return 1000000.0;
        }
        if (!p.a(calculationContext, n2, n + 1, n3, alz2) && !p.b(alz2.c())) {
            return 1000000.0;
        }
        if (!p.a(calculationContext, n2, n - 1, n3)) {
            return 9.26569376882094;
        }
        return 4.63284688441047;
    }

    @Override
    public final q a(q q2) {
        super.a(q2);
        if (q2.a != MovementStatus.RUNNING) {
            return q2;
        }
        return q2;
    }

    @Override
    public final boolean a(q q2) {
        return true;
    }
}
