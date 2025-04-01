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
public final class av
extends o {
    public av(IBaritone iBaritone, BetterBlockPos betterBlockPos, BetterBlockPos betterBlockPos2) {
        super(iBaritone, betterBlockPos, betterBlockPos2);
    }

    @Override
    public final double a(CalculationContext calculationContext) {
        return av.a(calculationContext, this.a.a, this.a.c, this.a.d);
    }

    @Override
    public final Set<BetterBlockPos> a() {
        return ImmutableSet.of((Object)((Object)this.a), (Object)((Object)this.b));
    }

    public static double a(CalculationContext calculationContext, int n, int n2, int n3) {
        alz alz2 = calculationContext.a(n, n2 + 2, n3);
        if (!p.a(calculationContext, n, n2 + 2, n3, alz2) && !p.b(alz2.c())) {
            return 1000000.0;
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
