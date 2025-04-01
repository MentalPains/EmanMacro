/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  afh
 *  afi
 *  alz
 *  aui
 *  cj
 *  com.google.common.collect.ImmutableSet
 *  df
 */
package baritone;

import baritone.api.IBaritone;
import baritone.api.pathing.movement.MovementStatus;
import baritone.api.utils.BetterBlockPos;
import baritone.api.utils.IPlayerContext;
import baritone.api.utils.VecUtils;
import baritone.bj;
import baritone.bv;
import baritone.o;
import baritone.p;
import baritone.pathing.movement.CalculationContext;
import baritone.q;
import com.google.common.collect.ImmutableSet;
import java.util.Set;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class ax
extends o {
    private int a;
    public boolean a = false;

    public ax(IBaritone iBaritone, BetterBlockPos betterBlockPos, BetterBlockPos betterBlockPos2) {
        super(iBaritone, betterBlockPos, betterBlockPos2);
    }

    @Override
    public final void reset() {
        super.reset();
        this.a = 0;
        this.a = false;
    }

    @Override
    public final double a(CalculationContext calculationContext) {
        bv bv2 = new bv();
        ax.a(calculationContext, this.a.a, this.a.c, this.a.d, this.b.a, this.b.d, bv2);
        if (bv2.b != this.b.c) {
            return 1000000.0;
        }
        return bv2.a;
    }

    @Override
    public final Set<BetterBlockPos> a() {
        return ImmutableSet.of((Object)this.a, (Object)((Object)this.b.up()), (Object)((Object)this.b));
    }

    public static void a(CalculationContext calculationContext, int n, int n2, int n3, int n4, int n5, bv bv2) {
        alz alz2 = calculationContext.a(n4, n2 - 1, n5);
        if (!p.a(calculationContext, n4, n2 - 1, n3, alz2)) {
            return;
        }
        if (!p.a(calculationContext, n4, n2, n5)) {
            return;
        }
        if (!p.a(calculationContext, n4, n2 + 1, n5)) {
            return;
        }
        afh afh2 = calculationContext.a(n, n2 - 1, n3).c();
        if (afh2 == afi.au || afh2 == afi.bn) {
            return;
        }
        alz alz3 = calculationContext.a(n4, n2 - 2, n5);
        if (p.a(calculationContext, n4, n2 - 2, n5, alz3)) {
            ax.a(calculationContext, n2, n4, n5, alz3, bv2);
            return;
        }
        if (alz2.c() == afi.au || alz2.c() == afi.bn) {
            return;
        }
        double d = 3.7062775075283763;
        if (afh2 == afi.aW) {
            d = 7.4125550150567525;
        }
        bv2.a = n4;
        bv2.b = n2 - 1;
        bv2.c = n5;
        bv2.a = d += Math.max(FALL_N_BLOCKS_COST[1], 0.9265693768820937);
    }

    private static void a(CalculationContext calculationContext, int n, int n2, int n3, alz alz2, bv bv2) {
        if (!p.a(calculationContext, n2, n - 2, n3, alz2)) {
            return;
        }
        double d = 0.0;
        int n4 = n;
        int n5 = 3;
        int n6;
        while ((n6 = n - n5) >= 0) {
            alz alz3 = calculationContext.a(n2, n6, n3);
            int n7 = n5 - (n - n4);
            double d2 = 3.7062775075283763 + FALL_N_BLOCKS_COST[n7] + d;
            if (p.b(alz3.c())) {
                if (!p.a(calculationContext, n2, n6, n3, alz3)) {
                    return;
                }
                if (calculationContext.f) {
                    return;
                }
                if (p.a(n2, n6, n3, alz3, calculationContext.a)) {
                    return;
                }
                if (!p.c(calculationContext, n2, n6 - 1, n3)) {
                    return;
                }
                bv2.a = n2;
                bv2.b = n6;
                bv2.c = n3;
                bv2.a = d2;
                return;
            }
            if (n7 <= 11 && (alz3.c() == afi.bn || alz3.c() == afi.au)) {
                d = d + FALL_N_BLOCKS_COST[n7 - 1] + 6.666666666666667;
                n4 = n6;
            } else if (!p.a(calculationContext, n2, n6, n3, alz3)) {
                if (!p.c(calculationContext, n2, n6, n3, alz3)) {
                    return;
                }
                if (p.a(alz3)) {
                    return;
                }
                if (n7 <= calculationContext.a + 1) {
                    bv2.a = n2;
                    bv2.b = n6 + 1;
                    bv2.c = n3;
                    bv2.a = d2;
                }
                return;
            }
            ++n5;
        }
        return;
    }

    @Override
    public final q a(q object) {
        super.a((q)object);
        if (object.a != MovementStatus.RUNNING) {
            return object;
        }
        Object object2 = this.a.playerFeet();
        cj cj2 = new cj((this.b.n() << 1) - this.a.n(), this.b.o(), (this.b.p() << 1) - this.a.p());
        if ((object2.equals((Object)this.b) || object2.equals(cj2)) && (p.c((IPlayerContext)this.a, this.b) || this.a.playerFeetAsVec().b - (double)this.b.o() < 0.5)) {
            q q2 = object;
            object = MovementStatus.SUCCESS;
            object2 = q2;
            q2.a = object;
            return object2;
        }
        if (this.b()) {
            double d = ((double)this.a.n() + 0.5) * 0.17 + ((double)this.b.n() + 0.5) * 0.83;
            double d2 = ((double)this.a.p() + 0.5) * 0.17 + ((double)this.b.p() + 0.5) * 0.83;
            aui aui2 = new aui(d, (double)this.b.o(), d2).a(0.0, 0.5, 0.0);
            p.a((IPlayerContext)this.a, object, (BetterBlockPos)this.a, aui2);
            p.c((IPlayerContext)this.a, object, aui2);
            return object;
        }
        double d = this.a.playerFeetAsVec().a - ((double)this.b.n() + 0.5);
        double d3 = this.a.playerFeetAsVec().c - ((double)this.b.p() + 0.5);
        double d4 = d;
        double d5 = d3;
        double d6 = Math.sqrt(d4 * d4 + d5 * d5);
        double d7 = this.a.playerFeetAsVec().a - ((double)this.a.n() + 0.5);
        double d8 = this.a.playerFeetAsVec().c - ((double)this.a.p() + 0.5);
        double d9 = d7;
        double d10 = d8;
        double d11 = Math.sqrt(d9 * d9 + d10 * d10);
        if (!object2.equals((Object)this.b) || d6 > 0.25) {
            if (this.a++ < 20 && d11 < 1.25) {
                object2 = VecUtils.getBlockPosCenter(cj2);
                p.a((IPlayerContext)this.a, object, (BetterBlockPos)this.a, (aui)object2);
                p.c((IPlayerContext)this.a, object, (aui)object2);
            } else {
                object2 = VecUtils.getBlockPosCenter(this.b);
                p.a((IPlayerContext)this.a, object, (BetterBlockPos)this.a, (aui)object2);
                p.c((IPlayerContext)this.a, object, (aui)object2);
            }
        }
        return object;
    }

    public final boolean b() {
        if (this.a) {
            return true;
        }
        cj cj2 = this.b.b((df)this.a.down()).a((df)this.b);
        if (this.c()) {
            return true;
        }
        for (int i = 0; i <= 2; ++i) {
            if (!p.a(bj.a((IPlayerContext)this.a, cj2.b(i)))) continue;
            return true;
        }
        return false;
    }

    public final boolean c() {
        cj cj2 = this.b.b((df)this.a.down()).a((df)this.b);
        return !p.a((IPlayerContext)this.a, new BetterBlockPos(cj2)) && p.a((IPlayerContext)this.a, new BetterBlockPos(cj2).up()) && p.a((IPlayerContext)this.a, new BetterBlockPos(cj2).up(2));
    }
}
