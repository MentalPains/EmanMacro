/*
 * Decompiled with CFR 0.152.
 */
package baritone.pathing.calc;

import baritone.a;
import baritone.am;
import baritone.api.pathing.calc.IPath;
import baritone.api.pathing.goals.Goal;
import baritone.api.utils.BetterBlockPos;
import baritone.b;
import baritone.bu;
import baritone.bv;
import baritone.k;
import baritone.l;
import baritone.m;
import baritone.n;
import baritone.pathing.movement.CalculationContext;
import java.util.Optional;

@b
public class FlyAStar
extends k {
    private final CalculationContext a;

    @b
    public FlyAStar(int n, int n2, int n3, Goal goal, CalculationContext calculationContext) {
        super(n, n2, n3, goal, calculationContext);
        this.a = calculationContext;
    }

    @Override
    public final Optional<IPath> a(long l2, long l3) {
        long l4;
        this.a = this.a((int)this.a, this.b, this.c, BetterBlockPos.longHash((int)this.a, this.b, this.c));
        ((m)((Object)this.a)).b = 0.0;
        ((m)((Object)this.a)).c = ((m)((Object)this.a)).a;
        n n2 = new n();
        n2.a((m)((Object)this.a));
        double[] dArray = new double[7];
        for (int i = 0; i < 7; ++i) {
            dArray[i] = ((m)((Object)this.a)).a;
            this.a[i] = this.a;
        }
        bv bv2 = new bv();
        bu bu2 = new bu(this.a.a.af());
        long l5 = System.currentTimeMillis();
        boolean bl = (Boolean)baritone.a.a().slowPath.value;
        if (bl) {
            this.logDebug("slowPath is on, path timeout will be " + baritone.a.a().slowPathTimeoutMS.value + "ms instead of " + l2 + "ms");
        }
        long l6 = l5 + (bl ? (Long)baritone.a.a().slowPathTimeoutMS.value : l2);
        long l7 = l5 + (bl ? (Long)baritone.a.a().slowPathTimeoutMS.value : l3);
        boolean bl2 = true;
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        int n6 = (Integer)baritone.a.a().pathingMaxChunkBorderFetch.value;
        double d2 = (Boolean)baritone.a.a().minimumImprovementRepropagation.value != false ? 0.01 : 0.0;
        am[] amArray = am.values();
        while (!n2.a() && n5 < n6 && this.a == false && ((n3 & 0x3F) != 0 || (l4 = System.currentTimeMillis()) - l7 < 0L && (bl2 || l4 - l6 < 0L))) {
            m m2;
            if (bl) {
                try {
                    Thread.sleep((Long)baritone.a.a().slowPathTimeDelayMS.value);
                }
                catch (InterruptedException interruptedException) {}
            }
            this.b = m2 = n2.a();
            ++n3;
            if (this.a.isInGoal(m2.a, m2.b, m2.c)) {
                this.logDebug("Took " + (System.currentTimeMillis() - l5) + "ms, " + n4 + " movements considered");
                return Optional.of(new l((m)((Object)this.a), m2, n3, (Goal)((Object)this.a), this.a));
            }
            am[] amArray2 = amArray;
            int n7 = amArray.length;
            for (int i = 0; i < n7; ++i) {
                Object object = amArray2[i];
                int n8 = m2.a + ((am)((Object)object)).a;
                int n9 = m2.c + ((am)((Object)object)).c;
                if (!(n8 >> 4 == m2.a >> 4 && n9 >> 4 == m2.c >> 4 || this.a.a(n8, n9))) {
                    ++n5;
                    continue;
                }
                if (!bu2.a(n8, n9) || m2.b + ((am)((Object)object)).b > 256 || m2.b + ((am)((Object)object)).b < 0) continue;
                bv2.a();
                bv bv3 = bv2;
                int n10 = m2.c;
                int n11 = m2.b;
                int n12 = m2.a;
                CalculationContext calculationContext = this.a;
                am am2 = object;
                bv3.a = n12 + am2.a;
                bv3.b = n11 + am2.b;
                bv3.c = n10 + am2.c;
                bv3.a = am2.a(calculationContext, n12, n11, n10);
                ++n4;
                double d3 = bv2.a;
                if (d3 >= 1000000.0) continue;
                if (d3 <= 0.0 || Double.isNaN(d3)) {
                    throw new IllegalStateException(object + " calculated implausible cost " + d3);
                }
                if (bv2.a != n8 || bv2.c != n9) {
                    throw new IllegalStateException(object + " " + bv2.a + " " + n8 + " " + bv2.c + " " + n9);
                }
                if (bv2.b != m2.b + ((am)((Object)object)).b) {
                    throw new IllegalStateException(object + " " + bv2.b + " " + (m2.b + ((am)((Object)object)).b));
                }
                long l8 = BetterBlockPos.longHash(bv2.a, bv2.b, bv2.c);
                object = this.a(bv2.a, bv2.b, bv2.c, l8);
                double d4 = m2.b + d3;
                if (!(((m)object).b - d4 > d2)) continue;
                ((m)object).a = m2;
                ((m)object).b = d4;
                ((m)object).c = d4 + ((m)object).a;
                if (((m)object).a()) {
                    n2.b((m)object);
                } else {
                    n2.a((m)object);
                }
                for (n8 = 0; n8 < 7; ++n8) {
                    double d5 = ((m)object).a + ((m)object).b / a[n8];
                    if (!(dArray[n8] - d5 > d2)) continue;
                    dArray[n8] = d5;
                    this.a[n8] = object;
                    if (!bl2 || !(this.a((m)object) > 25.0)) continue;
                    bl2 = false;
                }
            }
        }
        if (this.a != false) {
            return Optional.empty();
        }
        System.out.println(n4 + " movements considered");
        System.out.println("Open set size: " + n2.a);
        System.out.println("PathNode map size: " + ((k)this).a.size());
        System.out.println((int)((double)n3 / (double)((float)(System.currentTimeMillis() - l5) / 1000.0f)) + " nodes per second");
        Optional<IPath> optional = this.a(true, n3);
        if (optional.isPresent()) {
            this.logDebug("Took " + (System.currentTimeMillis() - l5) + "ms, " + n4 + " movements considered");
        }
        return optional;
    }
}
