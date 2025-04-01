/*
 * Decompiled with CFR 0.152.
 */
package baritone;

import baritone.api.pathing.goals.Goal;
import baritone.api.utils.BetterBlockPos;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class m {
    public final int a;
    public final int b;
    public final int c;
    public final double a;
    public double b = 1000000.0;
    public double c;
    public m a = null;
    public int d;

    public m(int n, int n2, int n3, Goal goal) {
        this.a = goal.heuristic(n, n2, n3);
        if (Double.isNaN(this.a)) {
            throw new IllegalStateException(goal + " calculated implausible heuristic");
        }
        this.d = -1;
        this.a = n;
        this.b = n2;
        this.c = n3;
    }

    public final boolean a() {
        return this.d != -1;
    }

    public final int hashCode() {
        return (int)BetterBlockPos.longHash(this.a, this.b, this.c);
    }

    public final boolean equals(Object object) {
        object = (m)object;
        return this.a == ((m)object).a && this.b == ((m)object).b && this.c == ((m)object).c;
    }
}
